package pl.szbd.virtualuniversity.domain.commons.model.enums;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum RoleType {
    @JsonEnumDefaultValue
    STUDENT,
    LECTURER
}
