package com.example.FirstSpringBootWithKotlin.users

import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface UserRepository : CrudRepository<User, Long>