package com.example.FirstSpringBootWithKotlin.users

import com.example.FirstSpringBootWithKotlin.users.types.Email
import com.example.FirstSpringBootWithKotlin.users.types.Phone
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(@Autowired private val userRepository: UserRepository) {
    @GetMapping
    fun getUsers() = userRepository.findAll().toList()

    @PostMapping
    fun createNewUser(@RequestBody user: User): ResponseEntity<User> {
        val createdUser = userRepository.save(user)

        return ResponseEntity(createdUser, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable("id") userId: Long): ResponseEntity<User> {
        val user = userRepository.findById(userId).orElse(null)
            ?: return ResponseEntity( HttpStatus.NOT_FOUND)

        return ResponseEntity(user, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateUserById(@PathVariable("id") userId: Long, @RequestBody dto: UserDTO): ResponseEntity<User> {
        val existingUser = userRepository.findById(userId).orElse(null)
            ?: return ResponseEntity(HttpStatus.NOT_FOUND)

        val updatedUser = existingUser.copy(
            name = dto.name,
            email = Email(dto.email),
            phone = Phone(dto.phone),
            password = dto.password
        )

        userRepository.save(updatedUser)

        return ResponseEntity(updatedUser, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteUserById(@PathVariable("id") userId: Long): ResponseEntity<User> {
        if (!userRepository.existsById(userId)) return ResponseEntity(HttpStatus.NOT_FOUND)

        userRepository.deleteById(userId)

        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}