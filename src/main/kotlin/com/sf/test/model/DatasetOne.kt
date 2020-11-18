package com.sf.test.model

import kotlin.random.Random


data class DatasetOne(
        val id: Int,
        val contract: String = "Contract$id",
        val buy: Int = Random.nextInt(1, 10),
        val sell: Int = Random.nextInt(1, 10)
) : Dataset {

    override fun getDatasetId(): String {
        return "Dataset1"
    }

}
