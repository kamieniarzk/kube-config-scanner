package com.kcs.hunter.scheduling;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableScheduling
@RequiredArgsConstructor
class KubeHunterSchedulingService {

  private final KubeHunterLogService logService;

  @Scheduled(cron = "0 * * * * *")
  void persistLogsForRunsWithoutStoredLogs() {
    log.info("Scheduling - persist logs for runs without stored logs");
    logService.persistLogs();
  }
}