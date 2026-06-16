package com.lumina.judicial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SchedulingController {

    @GetMapping("/schedule")
    public String schedule() {
        return "schedule";
    }

    @PostMapping("/schedule")
    public String handleSchedule(@RequestParam String date, @RequestParam String time) {
        System.out.println("Scheduling appointment for: " + date + " at " + time);
        return "schedule-success";
    }
}
