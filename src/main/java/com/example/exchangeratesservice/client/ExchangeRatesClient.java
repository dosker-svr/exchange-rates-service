package com.example.exchangeratesservice.client;

import com.example.exchangeratesservice.pojo.ResponseExchangeRates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${app.open-exchange-rates.config.name}", url = "${app.open-exchange-rates.config.url}")
public interface ExchangeRatesClient {

    @RequestMapping(method = RequestMethod.GET, value = "/latest.json")
    ResponseExchangeRates getLatestRates(@RequestParam String app_id, @RequestParam(required = false) String base, @RequestParam String symbols);

    @RequestMapping(method = RequestMethod.GET, value = "/historical/{date}.json")
    ResponseExchangeRates getHistoricalRates(@RequestParam String app_id, @PathVariable String date, @RequestParam(required = false) String base, @RequestParam String symbols);

}
