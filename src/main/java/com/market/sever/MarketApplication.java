package com.market.sever;

import com.market.sever.service.Sever;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketApplication.class, args);
        Sever sever = new Sever(4242);
        sever.start();
    }

}
