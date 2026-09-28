package org.example.careplan.controller;

import org.example.careplan.entity.DoseLog;
import org.example.careplan.service.DoseLogService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/dose-logs")
public class DoseLogController {

    private final DoseLogService doseLogService;

    public DoseLogController(DoseLogService doseLogService) {
        this.doseLogService = doseLogService;
    }

    @PostMapping
    public DoseLog addDoseLog(@Valid @RequestBody DoseLog doseLog) {
        return doseLogService.saveDoseLog(doseLog);
    }

    @GetMapping
    public List<DoseLog> getAllDoseLogs() {
        return doseLogService.getAllDoseLogs();
    }

    @GetMapping("/{id}")
    public DoseLog getDoseLogById(@PathVariable Long id) {
        return doseLogService.getDoseLogById(id);
    }
}