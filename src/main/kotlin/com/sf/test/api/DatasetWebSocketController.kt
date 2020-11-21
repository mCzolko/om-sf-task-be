package com.sf.test.api

import com.sf.test.service.DatasetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Controller


@EnableScheduling
@Controller
class DatasetWebSocketController @Autowired constructor(
        private var template: SimpMessagingTemplate,
        private var datasetService: DatasetService
) {

    @Scheduled(fixedRate = 1000)
    @SendTo("/topic/datasets")
    fun datasets() {
        datasetService.createUpdateMessages().forEach {
            template.convertAndSend("/topic/datasets", it)
        }
    }

}
