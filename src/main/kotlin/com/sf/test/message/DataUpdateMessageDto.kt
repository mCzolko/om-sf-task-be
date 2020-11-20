package com.sf.test.message

import com.fasterxml.jackson.annotation.JsonProperty
import com.sf.test.model.Dataset
import com.sf.test.model.DatasetTopic


class DataUpdateMessageDto(
        @JsonProperty("topic")
        val topic: DatasetTopic
) {

    @JsonProperty("payload")
    val payload: MutableList<Dataset> = mutableListOf()

    @JsonProperty("action")
    val action = "DATA_UPDATE"

}
