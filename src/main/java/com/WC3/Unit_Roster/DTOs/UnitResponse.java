package com.WC3.Unit_Roster.DTOs;

import com.WC3.Unit_Roster.Entities.UnitType;
import lombok.Data;

@Data
public class UnitResponse {
    private Long id;
    private String name;
    private UnitType type;
    private Integer health;
    private Integer damage;
    private Integer goldCost;
}
