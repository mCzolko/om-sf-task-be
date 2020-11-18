package com.sf.test.message

import com.fasterxml.jackson.annotation.JsonProperty
import com.sf.test.model.Dataset


class DataUpdateMessage(
        @JsonProperty("topic")
        val topic: String
) {

    @JsonProperty("payload")
    val payload: MutableList<Dataset> = mutableListOf()

    @JsonProperty("action")
    val action = "DATA_UPDATE"

    fun addDataset(dataset: Dataset) {
        payload.add(dataset)
    }

}
