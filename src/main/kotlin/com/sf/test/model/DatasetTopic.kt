package com.sf.test.model

import kotlin.random.Random


enum class DatasetTopic {
    STOCKS {
        override fun createDataset(): Dataset {
            return DatasetStock(Random.nextInt(1, 10))
        }
    },
    CONTRACTS {
        override fun createDataset(): Dataset {
            return DatasetContract(Random.nextInt(1, 10))
        }
    };

    abstract fun createDataset(): Dataset
}
