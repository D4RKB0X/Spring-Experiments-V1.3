package com.WC3.Unit_Roster.DTOs;

import com.WC3.Unit_Roster.Entities.UnitType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UnitRequest {

    @NotBlank(message = "Name cannot be blank!")
    private String name;

    @NotNull(message = "Type cannot be null!")
    private UnitType type;

    @Min(value = 1, message = "Health must be at least 1!")
    private Integer health;

    @Min(value = 0, message = "Damage cannot be negative!")
    private Integer damage;

    @Min(value = 0, message = "Gold cost cannot be negative!")
    private Integer goldCost;
}
