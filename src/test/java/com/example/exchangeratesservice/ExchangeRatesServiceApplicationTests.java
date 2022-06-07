package com.example.exchangeratesservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.exchangeratesservice.service.ExchangeService;
import com.example.exchangeratesservice.service.GiphyService;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class ExchangeRatesServiceApplicationTests {

	@Autowired
	private ExchangeService exchangeService;

	@Autowired
	private GiphyService giphyService;

	@Test
	void testExchangeServiceGetRate() {
		// given
		Double rate = 1.0;
		Long rateCode = 840L;// USD

		// when
		Double todayRateFromService = null;
		Double yesterdayRateFromService = null;
		try {
			todayRateFromService = exchangeService.getTodayRate(rateCode);
			yesterdayRateFromService = exchangeService.getYesterdayRate(rateCode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// then
		Assertions.assertEquals(rate, todayRateFromService); // USD to USD
		Assertions.assertEquals(rate, yesterdayRateFromService); // USD to USD
	}

	@Test
	void testGiphyService() {
		// given
		Double todayRate = 2.0;
		Double yesterdayRate = 1.0;

		// when
		Object randomGif = giphyService.getRandomGif(todayRate, yesterdayRate);

		// then
		Assertions.assertNotNull(randomGif);
	}

}
