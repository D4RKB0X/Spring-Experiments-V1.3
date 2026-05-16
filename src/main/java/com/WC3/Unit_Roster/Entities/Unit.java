package com.WC3.Unit_Roster.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "Units")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;

    @Column(name = "Name")
    @NotBlank(message = "Name cannot be blank!")
    private String name;

    @Column(name = "Type")
    @NotNull(message = "Type cannot be null!")
    @Enumerated(EnumType.STRING)
    private UnitType type;

    @Column(name = "Health")
    @Min(value = 1, message = "Health must be at least 1!")
    private Integer health;

    @Column(name = "Damage")
    @Min(value = 0, message = "Damage cannot be negative!")
    private Integer damage;

    @Column(name = "GoldCost")
    @Min(value = 0, message = "Gold cost cannot be negative!")
    private Integer goldCost;
}
