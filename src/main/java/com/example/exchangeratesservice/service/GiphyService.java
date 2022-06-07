package com.example.exchangeratesservice.service;

import com.example.exchangeratesservice.client.GiphyClient;
import com.example.exchangeratesservice.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GiphyService {
    @Autowired
    private GiphyClient giphyClient;

    @Value("${app.giphy.giphy-app-id}")
    private String api_key;

    public Object getRandomGif(Double todayRate, Double yesterdayRate) {
        if (Double.compare(todayRate, yesterdayRate) == 1) {
            return giphyClient.getRandomGif(api_key, Constants.RICH_GIF);
        } else {
            return giphyClient.getRandomGif(api_key, Constants.BROKE_GIF);
        }
    }
}
