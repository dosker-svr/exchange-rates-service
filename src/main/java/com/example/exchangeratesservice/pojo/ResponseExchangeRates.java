package com.example.exchangeratesservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseExchangeRates {
    private String disclaimer;
    private String license;
    private Timestamp timestamp;
    private String base;
    private Map<String, Double> rates;
}
