package com.WC3.Unit_Roster.Repositories;

import com.WC3.Unit_Roster.Entities.Unit;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository <Unit, Long> {
    boolean existsByName(
            @NotBlank(message = "Name cannot be blank!")
            String name
    );
}