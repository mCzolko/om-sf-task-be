package com.sf.test.api

import com.sf.test.message.DataUpdateMessageDto
import com.sf.test.model.DatasetTopic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Controller
import kotlin.random.Random


@EnableScheduling
@Controller
class DatasetWebSocketController @Autowired constructor(
        private var template: SimpMessagingTemplate
) {

    @Scheduled(fixedRate = 1000)
    @SendTo("/topic/datasets")
    fun datasets() {
        template.convertAndSend("/topic/datasets", createMessageDatasetByType(DatasetTopic.CONTRACTS))
        template.convertAndSend("/topic/datasets", createMessageDatasetByType(DatasetTopic.STOCKS))
    }

    fun createMessageDatasetByType(topic: DatasetTopic): DataUpdateMessageDto {
        val dataUpdateMessage = DataUpdateMessageDto(topic.createDataset().getTopic())
        (1..Random.nextInt(5, 10)).iterator()
                .forEach {
                    dataUpdateMessage.payload.add(topic.createDataset())
                }

        return dataUpdateMessage
    }

}
