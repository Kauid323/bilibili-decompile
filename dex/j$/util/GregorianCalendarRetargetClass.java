package j$.util;

import j$.time.ZonedDateTime;
import java.util.GregorianCalendar;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GregorianCalendarRetargetClass {
    public static /* synthetic */ ZonedDateTime toZonedDateTime(GregorianCalendar gregorianCalendar) {
        return gregorianCalendar instanceof GregorianCalendarRetargetInterface ? ((GregorianCalendarRetargetInterface) gregorianCalendar).toZonedDateTime() : DesugarGregorianCalendar.toZonedDateTime(gregorianCalendar);
    }
}