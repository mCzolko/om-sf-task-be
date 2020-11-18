package com.sf.test.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Controller


@EnableScheduling
@Controller
class DatasetWebSocketController @Autowired constructor(
        private var template: SimpMessagingTemplate
) {

    @Scheduled(fixedRate = 1000)
    @SendTo("/topic/datasets")
    fun greeting() {
        this.template.convertAndSend("/topic/datasets", "data update")
    }

}
