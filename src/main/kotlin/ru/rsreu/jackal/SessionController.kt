package ru.rsreu.jackal

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SessionController(private val creator: Creator){
    private val sessions: HashMap<String, GameSessionController> = HashMap()
    @GetMapping("/create-new")
    fun createNewSession(@RequestParam id: String) : ResponseEntity<String> {
        sessions[id] = creator.createBean(id)
        println(sessions.size)
        return ResponseEntity<String>(HttpStatus.OK)
    }
}