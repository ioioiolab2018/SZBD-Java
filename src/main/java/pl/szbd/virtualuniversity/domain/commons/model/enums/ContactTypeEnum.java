package pl.szbd.virtualuniversity.domain.commons.model.enums;

public enum ContactTypeEnum {
    EMAIL("EMAIL"), PHONE("PHONE");

    private final String name;

    private ContactTypeEnum(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
