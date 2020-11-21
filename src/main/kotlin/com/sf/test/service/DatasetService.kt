package com.sf.test.service

import com.sf.test.message.DataUpdateMessageDto
import com.sf.test.model.DatasetTopic
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class DatasetService {

    fun createUpdateMessages(): List<DataUpdateMessageDto> {
        return listOf(
                createMessageDatasetByType(DatasetTopic.CONTRACTS),
                createMessageDatasetByType(DatasetTopic.STOCKS)
        )
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
