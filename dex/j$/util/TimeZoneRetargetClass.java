package j$.util;

import j$.time.ZoneId;
import java.util.TimeZone;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TimeZoneRetargetClass {
    public static /* synthetic */ ZoneId toZoneId(TimeZone timeZone) {
        return timeZone instanceof TimeZoneRetargetInterface ? ((TimeZoneRetargetInterface) timeZone).toZoneId() : DesugarTimeZone.toZoneId(timeZone);
    }
}