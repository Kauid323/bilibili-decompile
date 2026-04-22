package kotlinx.datetime;

import j$.time.DayOfWeek;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DayOfWeek.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\"\u0019\u0010\u0001\u001a\u00020\u0000*\u00060\u0002j\u0002`\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "isoDayNumber", "j$/time/DayOfWeek", "Lkotlinx/datetime/DayOfWeek;", "DayOfWeek", "(I)Lj$/time/DayOfWeek;", "getIsoDayNumber", "(Lj$/time/DayOfWeek;)I", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DayOfWeekKt {

    /* compiled from: DayOfWeek.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<DayOfWeek> entries$0 = EnumEntriesKt.enumEntries(DayOfWeek.values());
    }

    public static final int getIsoDayNumber(DayOfWeek $this$isoDayNumber) {
        Intrinsics.checkNotNullParameter($this$isoDayNumber, "<this>");
        return $this$isoDayNumber.ordinal() + 1;
    }

    public static final DayOfWeek DayOfWeek(int isoDayNumber) {
        boolean z = false;
        if (1 <= isoDayNumber && isoDayNumber < 8) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException(("Expected ISO day-of-week number in 1..7, got " + isoDayNumber).toString());
        }
        return (DayOfWeek) EntriesMappings.entries$0.get(isoDayNumber - 1);
    }
}