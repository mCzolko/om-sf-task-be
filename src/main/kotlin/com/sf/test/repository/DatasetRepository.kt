package com.sf.test.repository

import org.springframework.stereotype.Service


@Service
class DatasetRepository {

    fun getMetadata(): Map<String, Map<String, String>> {
        return mapOf(
                "contracts" to mapOf(
                        "id" to "ID",
                        "contract" to "Contract",
                        "buy" to "Buy price",
                        "sell" to "Sell price"
                ),
                "stocks" to mapOf(
                    "id" to "ID",
                    "name" to "Stock name",
                    "currentPrice" to "Current price for stock"
                )
        )
    }

    fun getDatasets(): Set<String> {
        return getMetadata().keys
    }

}
