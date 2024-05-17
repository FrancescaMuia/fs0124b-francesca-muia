package com.epicode.U5D1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OrderRunner implements CommandLineRunner {

    @Value("${order.placeAmount}")
    Double seatAmount;
    @Override
    public void run(String... args) throws Exception {

    }
}
