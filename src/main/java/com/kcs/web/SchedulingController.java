package com.kcs.web;

import com.kcs.scheduling.ScheduledRun;
import com.kcs.scheduling.SchedulerFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scheduled")
@RequiredArgsConstructor
class SchedulingController {

  private final SchedulerFacade schedulerFacade;

  @PostMapping("/runs")
  String scheduleRun(@RequestBody ScheduledRun scheduledRun) {
    return schedulerFacade.schedule(scheduledRun);
  }

  @DeleteMapping("/runs/{id}")
  boolean unschedule(@PathVariable String id) {
    return schedulerFacade.unschedule(id);
  }

  @GetMapping("/runs")
  List<ScheduledRun> getAllScheduledRuns() {
    return schedulerFacade.getAllScheduledRuns();
  }
}
