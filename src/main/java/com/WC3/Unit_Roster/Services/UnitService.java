package com.WC3.Unit_Roster.Services;

import com.WC3.Unit_Roster.DTOs.UnitRequest;
import com.WC3.Unit_Roster.DTOs.UnitResponse;

import java.util.List;

public interface UnitService {

    UnitResponse createUnit(UnitRequest inputRequest);
    List<UnitResponse> getAllUnits();
    UnitResponse getUnitById(Long inputId);
}