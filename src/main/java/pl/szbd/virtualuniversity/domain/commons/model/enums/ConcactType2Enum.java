package pl.szbd.virtualuniversity.domain.commons.model.enums;

public enum ConcactType2Enum {
    BUSINESS("BUSINESS"), PRIVATE("PRIVATE");

    private final String name;

    private ConcactType2Enum(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
