package com.WC3.Unit_Roster.Services.Implements;

import com.WC3.Unit_Roster.DTOs.UnitRequest;
import com.WC3.Unit_Roster.DTOs.UnitResponse;
import com.WC3.Unit_Roster.Entities.Unit;
import com.WC3.Unit_Roster.Repositories.UnitRepository;
import com.WC3.Unit_Roster.Services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitRepository inputUnitRepo;

    public UnitResponse createUnit(UnitRequest inputRequest) {
        if(inputUnitRepo.existsByName(inputRequest.getName())) {
            throw new RuntimeException("Unit already exists!");
        }

        Unit inputUnit = new Unit();
        inputUnit.setName(inputRequest.getName());
        inputUnit.setType(inputRequest.getType());
        inputUnit.setHealth(inputRequest.getHealth());
        inputUnit.setDamage(inputRequest.getDamage());
        inputUnit.setGoldCost(inputRequest.getGoldCost());

        Unit savedUnit = inputUnitRepo.save(inputUnit);

        UnitResponse returnUnit = new UnitResponse();
        returnUnit.setId(savedUnit.getId());
        returnUnit.setName(savedUnit.getName());
        returnUnit.setType(savedUnit.getType());
        returnUnit.setHealth(savedUnit.getHealth());
        returnUnit.setDamage(savedUnit.getDamage());
        returnUnit.setGoldCost(savedUnit.getGoldCost());

        return returnUnit;
    }

    @Override
    public List<UnitResponse> getAllUnits() {
        List<Unit> inputUnits = inputUnitRepo.findAll();
        List<UnitResponse> inputResponses = new ArrayList<>();

        for(Unit enteredUnit : inputUnits) {
            UnitResponse enteredResponse = new UnitResponse();

            enteredResponse.setId(enteredUnit.getId());
            enteredResponse.setName(enteredUnit.getName());
            enteredResponse.setType(enteredUnit.getType());
            enteredResponse.setHealth(enteredUnit.getHealth());
            enteredResponse.setDamage(enteredUnit.getDamage());
            enteredResponse.setGoldCost(enteredUnit.getGoldCost());

            inputResponses.add(enteredResponse);
        }

        return inputResponses;
    }

    @Override
    public UnitResponse getUnitById(Long id) {
        Unit inputUnit = inputUnitRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Unit Not Found!"));

        UnitResponse inputResponse = new UnitResponse();
        inputResponse.setId(inputUnit.getId());
        inputResponse.setName(inputUnit.getName());
        inputResponse.setType(inputUnit.getType());
        inputResponse.setHealth(inputUnit.getHealth());
        inputResponse.setDamage(inputUnit.getDamage());
        inputResponse.setGoldCost(inputUnit.getGoldCost());

        return inputResponse;
    }
}
