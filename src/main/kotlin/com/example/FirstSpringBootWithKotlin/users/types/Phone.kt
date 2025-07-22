package com.example.FirstSpringBootWithKotlin.users.types

@JvmInline
value class Phone(val number: String){
    init {
        require(isValidPhone(number)) { "Invalid number phone: $number" }
    }

    companion object {
        private val PHONE_REGEX = Regex("^\\(?\\d{2}\\)?\\s?9\\d{4}-?\\d{4}$")

        fun isValidPhone(phone: String) = PHONE_REGEX.matches(phone)
    }
}
