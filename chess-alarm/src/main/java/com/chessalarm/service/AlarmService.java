package com.chessalarm.service;

import com.chessalarm.model.Alarm;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AlarmService {

    private final Map<Long, Alarm> alarms = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Alarm createAlarm(LocalDateTime time) {
        Long id = idGenerator.getAndIncrement();
        Alarm alarm = new Alarm(id, time);
        alarms.put(id, alarm);
        return alarm;
    }

    public Alarm getAlarmById(Long id) {
        return alarms.get(id);
    }

    // Checks every 10 seconds if an alarm needs to ring
    @Scheduled(fixedRate = 10000)
    public void checkAlarms() {
        LocalDateTime now = LocalDateTime.now();
        for (Alarm alarm : alarms.values()) {
            if (alarm.isActive() && !alarm.isRinging() && now.isAfter(alarm.getTime())) {
                alarm.setRinging(true);
                System.out.println("🔔 Alarm " + alarm.getId() + " is now ringing!");
            }
        }
    }
}

