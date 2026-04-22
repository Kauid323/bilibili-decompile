package j$.time.format;

import j$.util.DesugarCalendar;

public enum SignStyle {
    NORMAL,
    ALWAYS,
    NEVER,
    NOT_NEGATIVE,
    EXCEEDS_PAD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean parse(boolean positive, boolean strict, boolean fixedWidth) {
        switch (ordinal()) {
            case 0:
                return (positive && strict) ? false : true;
            case 1:
            case 4:
                return true;
            case DesugarCalendar.LONG_FORMAT /* 2 */:
            case 3:
            default:
                return (strict || fixedWidth) ? false : true;
        }
    }
}