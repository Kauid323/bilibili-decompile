package j$.util;

import j$.time.Instant;
import java.util.Date;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DateRetargetClass {
    public static /* synthetic */ Instant toInstant(Date date) {
        return date instanceof DateRetargetInterface ? ((DateRetargetInterface) date).toInstant() : DesugarDate.toInstant(date);
    }
}