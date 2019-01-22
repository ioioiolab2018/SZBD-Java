package pl.szbd.virtualuniversity.domain.commons.utils;

import java.text.SimpleDateFormat;

public class DateFormatter {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public static SimpleDateFormat getFormatter() {
        return formatter;
    }
}
