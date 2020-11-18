package com.sf.test.websocket

import com.sf.test.message.DataUpdate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Controller
import kotlin.random.Random


@EnableScheduling
@Controller
class DatasetController @Autowired constructor(
        private var template: SimpMessagingTemplate
) {

    @Scheduled(fixedRate = 1000)
    @SendTo("/topic/datasets")
    fun greeting() {
        this.template.convertAndSend("/topic/datasets", "data update")
    }

}
