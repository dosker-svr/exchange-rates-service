package com.example.exchangeratesservice.service;

import com.example.exchangeratesservice.client.ExchangeRatesClient;
import com.example.exchangeratesservice.pojo.ResponseExchangeRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class ExchangeService {
    @Autowired
    private ExchangeRatesClient client;

    @Value("${app.open-exchange-rates.appId}")
    private String appId;

    @Value("${app.code-rates.840}")
    private String USD;

    private static Map<Long, String> currencyNameByCode = new HashMap<>();

    public Double getTodayRate(Long rateCode) throws Exception {
        if (currencyNameByCode.get(rateCode) != null ) {
            String currencyName = currencyNameByCode.get(rateCode);
            ResponseExchangeRates respRate = client.getLatestRates(appId, USD, currencyName);
            return respRate.getRates().get(currencyName);
        } else throw new Exception("Currency by code=" + rateCode + " not found");

    }

    public Double getYesterdayRate(Long rateCode) throws Exception {
        LocalDate yesterdayDate = LocalDateTime.now().minusDays(1L).toLocalDate();
        String date = yesterdayDate.toString();
        if (currencyNameByCode.get(rateCode) != null) {
            String currencyName = currencyNameByCode.get(rateCode);
            ResponseExchangeRates respRate = client.getHistoricalRates(appId, date, USD, currencyName);
            return respRate.getRates().get(currencyName);
        } else throw new Exception("Currency by code=" + rateCode + " and date=" + date + "not found");
    }

    @PostConstruct
    private void initialCodeRatesMap() {
        currencyNameByCode.put(784L, "AED");
        currencyNameByCode.put(971L, "AFN");
        currencyNameByCode.put(8L, "ALL");
        currencyNameByCode.put(51L, "AMD");
        currencyNameByCode.put(532L, "ANG");
        currencyNameByCode.put(973L, "AOA");
        currencyNameByCode.put(32L, "ARS");
        currencyNameByCode.put(36L, "AUD");
        currencyNameByCode.put(533L, "AWG");
        currencyNameByCode.put(944L, "AZN");
        currencyNameByCode.put(977L, "BAM");
        currencyNameByCode.put(52L, "BBD");
        currencyNameByCode.put(50L, "BDT");
        currencyNameByCode.put(975L, "BGN");
        currencyNameByCode.put(48L, "BHD");
        currencyNameByCode.put(108L, "BIF");
        currencyNameByCode.put(60L, "BMD");
        currencyNameByCode.put(96L, "BND");
        currencyNameByCode.put(68L, "BOB");
        currencyNameByCode.put(986L, "BRL");
        currencyNameByCode.put(44L, "BSD");
        currencyNameByCode.put(64L, "BTN");
        currencyNameByCode.put(72L, "BWP");
        currencyNameByCode.put(933L, "BYN");
        currencyNameByCode.put(974L, "BYR");
        currencyNameByCode.put(84L, "BZD");
        currencyNameByCode.put(124L, "CAD");
        currencyNameByCode.put(976L, "CDF");
        currencyNameByCode.put(756L, "CHF");
        currencyNameByCode.put(990L, "CLF");
        currencyNameByCode.put(152L, "CLP");
        currencyNameByCode.put(156L, "CNY");
        currencyNameByCode.put(170L, "COP");
        currencyNameByCode.put(188L, "CRC");
        currencyNameByCode.put(931L, "CUC");
        currencyNameByCode.put(192L, "CUP");
        currencyNameByCode.put(132L, "CVE");
        currencyNameByCode.put(203L, "CZK");
        currencyNameByCode.put(262L, "DJF");
        currencyNameByCode.put(208L, "DKK");
        currencyNameByCode.put(214L, "DOP");
        currencyNameByCode.put(12L, "DZD");
        currencyNameByCode.put(233L, "EEK");
        currencyNameByCode.put(818L, "EGP");
        currencyNameByCode.put(232L, "ERN");
        currencyNameByCode.put(230L, "ETB");
        currencyNameByCode.put(978L, "EUR");
        currencyNameByCode.put(242L, "FJD");
        currencyNameByCode.put(238L, "FKP");
        currencyNameByCode.put(826L, "GBP");
        currencyNameByCode.put(981L, "GEL");
        currencyNameByCode.put(936L, "GHS");
        currencyNameByCode.put(292L, "GIP");
        currencyNameByCode.put(270L, "GMD");
        currencyNameByCode.put(324L, "GNF");
        currencyNameByCode.put(320L, "GTQ");
        currencyNameByCode.put(328L, "GYD");
        currencyNameByCode.put(344L, "HKD");
        currencyNameByCode.put(340L, "HNL");
        currencyNameByCode.put(191L, "HRK");
        currencyNameByCode.put(332L, "HTG");
        currencyNameByCode.put(348L, "HUF");
        currencyNameByCode.put(360L, "IDR");
        currencyNameByCode.put(376L, "ILS");
        currencyNameByCode.put(356L, "INR");
        currencyNameByCode.put(368L, "IQD");
        currencyNameByCode.put(364L, "IRR");
        currencyNameByCode.put(352L, "ISK");
        currencyNameByCode.put(388L, "JMD");
        currencyNameByCode.put(400L, "JOD");
        currencyNameByCode.put(392L, "JPY");
        currencyNameByCode.put(404L, "KES");
        currencyNameByCode.put(417L, "KGS");
        currencyNameByCode.put(116L, "KHR");
        currencyNameByCode.put(174L, "KMF");
        currencyNameByCode.put(408L, "KPW");
        currencyNameByCode.put(410L, "KRW");
        currencyNameByCode.put(414L, "KWD");
        currencyNameByCode.put(136L, "KYD");
        currencyNameByCode.put(398L, "KZT");
        currencyNameByCode.put(418L, "LAK");
        currencyNameByCode.put(422L, "LBP");
        currencyNameByCode.put(144L, "LKR");
        currencyNameByCode.put(430L, "LRD");
        currencyNameByCode.put(426L, "LSL");
        currencyNameByCode.put(434L, "LYD");
        currencyNameByCode.put(504L, "MAD");
        currencyNameByCode.put(498L, "MDL");
        currencyNameByCode.put(969L, "MGA");
        currencyNameByCode.put(807L, "MKD");
        currencyNameByCode.put(104L, "MMK");
        currencyNameByCode.put(496L, "MNT");
        currencyNameByCode.put(446L, "MOP");
        currencyNameByCode.put(478L, "MRO");
        currencyNameByCode.put(480L, "MRU");
        currencyNameByCode.put(470L, "MTL");
        currencyNameByCode.put(462L, "MVR");
        currencyNameByCode.put(454L, "MWK");
        currencyNameByCode.put(484L, "MXN");
        currencyNameByCode.put(458L, "MYR");
        currencyNameByCode.put(943L, "MZN");
        currencyNameByCode.put(516L, "NAD");
        currencyNameByCode.put(566L, "NGN");
        currencyNameByCode.put(558L, "NIO");
        currencyNameByCode.put(578L, "NOK");
        currencyNameByCode.put(524L, "NPR");
        currencyNameByCode.put(554L, "NZD");
        currencyNameByCode.put(512L, "OMR");
        currencyNameByCode.put(590L, "PAB");
        currencyNameByCode.put(604L, "PEN");
        currencyNameByCode.put(598L, "PGK");
        currencyNameByCode.put(608L, "PHP");
        currencyNameByCode.put(586L, "PKR");
        currencyNameByCode.put(985L, "PLN");
        currencyNameByCode.put(600L, "PYG");
        currencyNameByCode.put(634L, "QAR");
        currencyNameByCode.put(946L, "RON");
        currencyNameByCode.put(941L, "RSD");
        currencyNameByCode.put(643L, "RUB");
        currencyNameByCode.put(646L, "RWF");
        currencyNameByCode.put(682L, "SAR");
        currencyNameByCode.put(90L, "SBD");
        currencyNameByCode.put(690L, "SCR");
        currencyNameByCode.put(938L, "SDG");
        currencyNameByCode.put(752L, "SEK");
        currencyNameByCode.put(702L, "SGD");
        currencyNameByCode.put(654L, "SHP");
        currencyNameByCode.put(694L, "SLL");
        currencyNameByCode.put(706L, "SOS");
        currencyNameByCode.put(968L, "SRD");
        currencyNameByCode.put(728L, "SSP");
        currencyNameByCode.put(678L, "STD");
        currencyNameByCode.put(222L, "SVC");
        currencyNameByCode.put(760L, "SYP");
        currencyNameByCode.put(748L, "SZL");
        currencyNameByCode.put(764L, "THB");
        currencyNameByCode.put(972L, "TJS");
        currencyNameByCode.put(934L, "TMT");
        currencyNameByCode.put(788L, "TND");
        currencyNameByCode.put(776L, "TOP");
        currencyNameByCode.put(949L, "TRY");
        currencyNameByCode.put(780L, "TTD");
        currencyNameByCode.put(901L, "TWD");
        currencyNameByCode.put(834L, "TZS");
        currencyNameByCode.put(980L, "UAH");
        currencyNameByCode.put(800L, "UGX");
        currencyNameByCode.put(840L, "USD");
        currencyNameByCode.put(858L, "UYU");
        currencyNameByCode.put(860L, "UZS");
        currencyNameByCode.put(937L, "VEF");
        currencyNameByCode.put(704L, "VND");
        currencyNameByCode.put(548L, "VUV");
        currencyNameByCode.put(882L, "WST");
        currencyNameByCode.put(950L, "XAF");
        currencyNameByCode.put(961L, "XAG");
        currencyNameByCode.put(959L, "XAU");
        currencyNameByCode.put(951L, "XCD");
        currencyNameByCode.put(960L, "XDR");
        currencyNameByCode.put(952L, "XOF");
        currencyNameByCode.put(964L, "XPD");
        currencyNameByCode.put(953L, "XPF");
        currencyNameByCode.put(962L, "XPT");
        currencyNameByCode.put(886L, "YER");
        currencyNameByCode.put(710L, "ZAR");
        currencyNameByCode.put(894L, "ZMK");
        currencyNameByCode.put(967L, "ZMW");

//        baseRatesByCode.put(999991L, "BTC");
//        baseRatesByCode.put(999992L, "CNH");
//        baseRatesByCode.put(999993L, "GGP");
//        baseRatesByCode.put(999994L, "IMP");
//        baseRatesByCode.put(999995L, "JEP");
//        baseRatesByCode.put(999996L, "STN");
    }
}
