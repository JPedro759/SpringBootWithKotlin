package com.example.FirstSpringBootWithKotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FirstSpringBootWithKotlinApplication

fun main(args: Array<String>) {
	runApplication<FirstSpringBootWithKotlinApplication>(*args)
}
