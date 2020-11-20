package com.sf.test.model

import kotlin.random.Random


data class DatasetStock(
        val id: Int,
        val name: String = "Stock$id",
        val currentPrice: Int = Random.nextInt(1, 1000),
) : Dataset {

    override fun getTopic(): DatasetTopic {
        return DatasetTopic.STOCKS
    }

}
