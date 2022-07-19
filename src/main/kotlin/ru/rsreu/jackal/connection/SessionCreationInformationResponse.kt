package ru.rsreu.jackal.connection

import java.util.*

// TODO: 19.07.2022 responseStatus - соответсвие контракту (я не знаю что на тыртерпрайзе) 
data class SessionCreationInformationResponse(
    val playersInfo: List<UserResponse>,
    val startDate: Date,
    val responseStatus: String
)