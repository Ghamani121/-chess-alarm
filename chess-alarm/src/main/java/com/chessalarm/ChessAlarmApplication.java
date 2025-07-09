package com.chessalarm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ChessAlarmApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChessAlarmApplication.class, args);
    }
}

