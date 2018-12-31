package pl.szbd.virtual.university.domain.commons.model.enums;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum RoleType {
    @JsonEnumDefaultValue
    STUDENT("STUDENT"),
    EMPLOYEE("STUDENT");

    private final String role;

    RoleType(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return role;
    }
}
