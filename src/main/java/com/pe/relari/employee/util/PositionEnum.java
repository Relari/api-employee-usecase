package com.pe.relari.employee.util;

import lombok.Getter;

public enum PositionEnum {

    DEVELOPER("developer"),
    MANAGER("manager"),
    ARCHITECT("architect"),
    SCRUM_MASTER("scrum-master"),
    TEAM_LEAD("team-lead");
    
    @Getter
    private final String value;
    
    PositionEnum(String value) {
        this.value = value;
    }
    
}
