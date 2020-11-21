package com.sf.test.service

import com.sf.test.model.DatasetTopic
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class DatasetServiceTest {

    @Autowired
    lateinit var datasetService: DatasetService

    @Test
    fun createUpdateMessages() {
        assertEquals(
                datasetService.createUpdateMessages().size,
                2,
                "createUpdateMessages should return messages for all topics"
        )
    }

    @Test
    fun createMessageDatasetByType() {
        val message = datasetService.createMessageDatasetByType(DatasetTopic.CONTRACTS)

        assertTrue(
                message.payload.size in 5..10,
                "createMessageDatasetByType should have from 5 to 10 updates"
        )
    }

}
