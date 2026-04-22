package kotlinx.datetime;

import j$.time.Month;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Month.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\"\u0019\u0010\u0001\u001a\u00020\u0000*\u00060\u0002j\u0002`\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "number", "j$/time/Month", "Lkotlinx/datetime/Month;", "Month", "(I)Lj$/time/Month;", "getNumber", "(Lj$/time/Month;)I", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class MonthKt {

    /* compiled from: Month.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<Month> entries$0 = EnumEntriesKt.enumEntries(Month.values());
    }

    public static final int getNumber(Month $this$number) {
        Intrinsics.checkNotNullParameter($this$number, "<this>");
        return $this$number.ordinal() + 1;
    }

    public static final Month Month(int number) {
        boolean z = false;
        if (1 <= number && number < 13) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return (Month) EntriesMappings.entries$0.get(number - 1);
    }
}