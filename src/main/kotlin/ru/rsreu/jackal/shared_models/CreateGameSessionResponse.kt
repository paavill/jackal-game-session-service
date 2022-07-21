package ru.rsreu.jackal.shared_models

import java.util.*

data class CreateGameSessionResponse(
    val startDate: Date,
    override val responseStatus: HttpResponseStatus
) : HttpResponse(responseStatus)
