package com.jvictornascimento.msproductcatalog.api.controllers.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductRequest(@JsonProperty("id")
                             Long id,
                             @JsonProperty("name")
                             String name,
                             @JsonProperty("amount")
                             Integer amount) {
}
