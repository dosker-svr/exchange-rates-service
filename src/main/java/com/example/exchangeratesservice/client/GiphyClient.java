package com.example.exchangeratesservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${app.giphy.config.name}", url = "${app.giphy.config.url}")
public interface GiphyClient {

    @RequestMapping(method = RequestMethod.GET, value = "/random")
    Object getRandomGif(@RequestParam String api_key, @RequestParam String tag);
}
