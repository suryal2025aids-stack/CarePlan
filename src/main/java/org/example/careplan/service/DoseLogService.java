package org.example.careplan.service;

import org.example.careplan.entity.DoseLog;
import org.example.careplan.repository.DoseLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoseLogService {

    private final DoseLogRepository doseLogRepository;

    public DoseLogService(DoseLogRepository doseLogRepository) {
        this.doseLogRepository = doseLogRepository;
    }

    public DoseLog saveDoseLog(DoseLog doseLog) {

        if (!doseLog.getStatus().equals("TAKEN")
                && !doseLog.getStatus().equals("MISSED")) {
            throw new IllegalArgumentException(
                    "Status must be TAKEN or MISSED"
            );
        }

        return doseLogRepository.save(doseLog);
    }

    public List<DoseLog> getAllDoseLogs() {
        return doseLogRepository.findAll();
    }

    public DoseLog getDoseLogById(Long id) {
        return doseLogRepository.findById(id).orElse(null);
    }
}