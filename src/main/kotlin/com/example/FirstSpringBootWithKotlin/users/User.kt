package com.example.FirstSpringBootWithKotlin.users

import com.example.FirstSpringBootWithKotlin.users.types.Email
import com.example.FirstSpringBootWithKotlin.users.types.Phone
import jakarta.persistence.*

@Entity
@Table(name = "Users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val name: String,

    val email: Email,
    val phone: Phone,

    val password: String,
)
