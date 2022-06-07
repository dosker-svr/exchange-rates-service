package com.example.exchangeratesservice.controller;

import com.example.exchangeratesservice.service.ExchangeService;
import com.example.exchangeratesservice.service.GiphyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/actual-gif")
public class GiphyController {
    @Autowired
    private ExchangeService exchangeService;

    @Autowired
    private GiphyService giphyService;

    @GetMapping
    public Object getActualGif(@RequestParam Long rateCode) throws Exception {
        Double todayRate = null;
        Double yesterdayRate = null;
        try {
            todayRate = exchangeService.getTodayRate(rateCode);
            yesterdayRate = exchangeService.getYesterdayRate(rateCode);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        return giphyService.getRandomGif(todayRate, yesterdayRate);
    }
}
