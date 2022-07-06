package ru.rsreu.jackal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JackalGameSessionServiceApplication

fun main(args: Array<String>) {
	runApplication<JackalGameSessionServiceApplication>(*args)
}
