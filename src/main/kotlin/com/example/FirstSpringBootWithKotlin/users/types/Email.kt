package com.example.FirstSpringBootWithKotlin.users.types

@JvmInline
value class Email(val address: String) {
    init {
        require(isValidEmail(address)) { "Invalid email address: $address" }
    }

    companion object {
        private val EMAIL_REGEX = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")

        fun isValidEmail(email: String) = EMAIL_REGEX.matches(email)
    }
}
