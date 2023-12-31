package com.kcs.workload.persistence;

import com.kcs.workload.AggregatedScanRunDto;

import java.util.List;

public interface AggregatedRunRepository {
  AggregatedScanRunDto save(String scoreId, String trivyId);
  AggregatedScanRunDto get(String id);
  List<AggregatedScanRunDto> getAll();
}
