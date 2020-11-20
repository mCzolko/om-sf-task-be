package com.sf.test.api

import com.sf.test.repository.DatasetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


@Controller
class DatasetRestController @Autowired constructor(
        private val repository: DatasetRepository
) {

    @GetMapping("/dataset")
    fun getDatasets(): ResponseEntity<Set<String>> {
        return ResponseEntity.ok(repository.getDatasets())
    }

    @GetMapping("/dataset/{datasetId}/metadata")
    fun getMetadata(@PathVariable datasetId: String): ResponseEntity<Map<String, String>?> {
        return ResponseEntity.ok(
                repository.getMetadata().getOrDefault(datasetId, emptyMap())
        )
    }

}
