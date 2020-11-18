package com.sf.test.api

import com.sf.test.message.DataUpdateMessage
import com.sf.test.model.DatasetOne
import com.sf.test.model.DatasetTwo
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
        this.template.convertAndSend("/topic/datasets", createMessageDatasetOne())
        this.template.convertAndSend("/topic/datasets", createMessageDatasetTwo())
    }

    fun createMessageDatasetOne(): DataUpdateMessage {
        val iterator = (1..Random.nextInt(5, 10)).iterator()

        val datasetOne = DatasetOne(Random.nextInt(1, 10))
        val dataUpdateOneMessage = DataUpdateMessage(datasetOne.getDatasetId())
        iterator.forEach {
            dataUpdateOneMessage.addDataset(DatasetOne(it))
        }

        return dataUpdateOneMessage
    }

    fun createMessageDatasetTwo(): DataUpdateMessage {
        val iterator = (1..Random.nextInt(5, 10)).iterator()

        val datasetTwo = DatasetTwo(Random.nextInt(1, 10))
        val dataUpdateTwoMessage = DataUpdateMessage(datasetTwo.getDatasetId())
        iterator.forEach {
            dataUpdateTwoMessage.addDataset(DatasetTwo(it))
        }

        return dataUpdateTwoMessage
    }

}
