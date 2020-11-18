package com.sf.test.model

import kotlin.random.Random


data class DatasetTwo(
        val id: Int,
        val name: String = "Stock$id",
        val currentPrice: Int = Random.nextInt(1, 1000),
) : Dataset {

    override fun getDatasetId(): String {
        return "Dataset2"
    }

}
