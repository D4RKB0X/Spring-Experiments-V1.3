package com.WC3.Unit_Roster.Controllers;

import com.WC3.Unit_Roster.DTOs.UnitRequest;
import com.WC3.Unit_Roster.DTOs.UnitResponse;
import com.WC3.Unit_Roster.Services.UnitService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unit-roster")
public class UnitController {

    private static final Logger inputLogs = LoggerFactory.getLogger(UnitController.class);

    @Autowired
    private UnitService inputService;

    @PostMapping("/create-unit")
    public ResponseEntity<UnitResponse> createUnit(@Valid @RequestBody UnitRequest inputUnit) {

        inputLogs.info("Creating unit request received");
        UnitResponse inputResponse = inputService.createUnit(inputUnit);

        return ResponseEntity.status(HttpStatus.CREATED).body(inputResponse);
    }

    @GetMapping("/get-all-units")
    public ResponseEntity<List<UnitResponse>> getAllUnits() {

        inputLogs.info("Getting all units request received");
        List<UnitResponse> inputUnits = inputService.getAllUnits();

        return ResponseEntity.ok(inputUnits);
    }

    @GetMapping("/get-unit/{id}")
    public ResponseEntity<UnitResponse> getUnitById(@PathVariable Long id) {

        inputLogs.info("Getting unit by id request received");
        UnitResponse inputUnit = inputService.getUnitById(id);

        return ResponseEntity.ok(inputUnit);
    }

}
