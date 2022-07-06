package ru.rsreu.jackal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class JackalGameSessionServiceApplication

fun main(args: Array<String>) {
	runApplication<JackalGameSessionServiceApplication>(*args)
}
@RestController
class Controller {
	@GetMapping
	fun index(): String = "test"
}