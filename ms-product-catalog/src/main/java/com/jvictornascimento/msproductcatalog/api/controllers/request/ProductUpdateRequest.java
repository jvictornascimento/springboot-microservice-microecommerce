package com.jvictornascimento.msproductcatalog.api.controllers.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductUpdateRequest(                @JsonProperty("name")
                                                   String name,
                                                   @JsonProperty("amount")
                                                   Integer amount) {
}
