package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: DateTimeFormat.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/datetime/format/Padding;", "", "(Ljava/lang/String;I)V", "NONE", "ZERO", "SPACE", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum Padding {
    NONE,
    ZERO,
    SPACE;
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<Padding> getEntries() {
        return $ENTRIES;
    }
}