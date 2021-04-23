package com.cryptocurrency.crypto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.text.SimpleDateFormat;
import java.util.Date;


@EnableScheduling
@Component
@SpringBootApplication
public class CryptoApplication {
	private static final Logger log = LoggerFactory.getLogger(CryptoApplication.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	public static void main(String[] args) {
		SpringApplication.run(CryptoApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Scheduled(fixedRate = 5000)
	public void every5Secs() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		RestTemplate restTemplate = new RestTemplate();
		Bitcoin[] quote = restTemplate.getForObject(
				"https://api.n.exchange/en/api/v1/price/BTCLTC/latest/?market_code=nex", Bitcoin[].class);
		log.info(quote[0].toString());
		log.info("The time is now {}", dateFormat.format(new Date()));
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			every5Secs();
		};
	}
}
