package ru.rsreu.jackal.connection.connection_checker

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.scheduling.TaskScheduler
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.postForEntity
import ru.rsreu.jackal.configuration.EnterpriseServiceConfiguration
import ru.rsreu.jackal.connection.Session
import ru.rsreu.jackal.connection.SessionService
import java.util.*

@Component
class SessionConnectionChecker(
    @Qualifier("threadPoolTaskScheduler")
    private val taskScheduler: TaskScheduler,

    @Value("\${connection.checker.delay-s}")
    private val secondsDelayToCheck: Long,

    private val simpMessagingTemplate: SimpMessagingTemplate,

    private val enterpriseServiceConfiguration: EnterpriseServiceConfiguration,
    private val httpClient: RestTemplate,

    private val sessionService: SessionService
) {
    fun addCheckConnectionTask(session: Session) {
        taskScheduler.schedule({
            val notConnectedUsersIds = getNotConnectedUsersIds(session)
            if (notConnectedUsersIds.isNotEmpty()) {
                performNotConnectedPipeline(notConnectedUsersIds, session)
            }
        }, Date().toInstant().plusSeconds(secondsDelayToCheck))
    }

    private fun performNotConnectedPipeline(
        notConnectedUsersIds: List<Long>,
        session: Session
    ) {
        fun sendNotStartedInfoToAllClientByWebSocket() {
            simpMessagingTemplate.convertAndSend(
                "/jackal-broker/init-result/${session.id}",
                GameNotStartedWsResponse(notConnectedUserIds = notConnectedUsersIds)
            )
        }

        fun sendNotStartedInfoToEnterprise(
            session: Session,
            notConnectedUserIds: List<Long>
        ) {
            httpClient.postForEntity<Any>(
                with(enterpriseServiceConfiguration) {
                    baseUrl + notStartedApiUrl
                },
                GameNotStartedRequest(session.lobbyId, notConnectedUserIds)
            )
        }

        sendNotStartedInfoToAllClientByWebSocket()
        sendNotStartedInfoToEnterprise(session, notConnectedUsersIds)
        sessionService.removeSession(session.id)
    }

    private fun getNotConnectedUsersIds(session: Session): List<Long> {
        return session.users.values.filter {
            !it.isConnected
        }.map {
            it.id
        }
    }
}