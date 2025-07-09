package com.chessalarm.controller;

import com.chessalarm.model.Alarm;
import com.chessalarm.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/alarm")
public class AlarmController {

    @Autowired
    private AlarmService alarmService;

    @PostMapping("/set")
    public Alarm setAlarm(@RequestBody Map<String, String> request) {
        String timeStr = request.get("time"); // format: "2025-07-08T17:00"
        LocalDateTime time = LocalDateTime.parse(timeStr);
        return alarmService.createAlarm(time);
    }

    @GetMapping("/{id}")
    public Alarm getAlarm(@PathVariable Long id) {
        return alarmService.getAlarmById(id);
    }
}
