package ru.rsreu.jackal

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable

@Component
class Creator {
    fun createBean(id: String): GameSessionController {
        return GameSessionController(id)
    }
}