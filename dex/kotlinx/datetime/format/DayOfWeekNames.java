package kotlinx.datetime.format;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalDateFormat.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B?\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nB\u0013\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0002\u0010\rJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lkotlinx/datetime/format/DayOfWeekNames;", "", "monday", "", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "names", "", "(Ljava/util/List;)V", "getNames", "()Ljava/util/List;", "equals", "", "other", "hashCode", "", "toString", "Companion", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DayOfWeekNames {
    private final List<String> names;
    public static final Companion Companion = new Companion(null);
    private static final DayOfWeekNames ENGLISH_FULL = new DayOfWeekNames(CollectionsKt.listOf((Object[]) new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}));
    private static final DayOfWeekNames ENGLISH_ABBREVIATED = new DayOfWeekNames(CollectionsKt.listOf((Object[]) new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"}));

    public DayOfWeekNames(List<String> names) {
        Intrinsics.checkNotNullParameter(names, "names");
        this.names = names;
        if (!(this.names.size() == 7)) {
            throw new IllegalArgumentException("Day of week names must contain exactly 7 elements".toString());
        }
        Iterable $this$forEach$iv = CollectionsKt.getIndices(this.names);
        Iterator<Integer> it = $this$forEach$iv.iterator();
        while (it.hasNext()) {
            int element$iv = ((IntIterator) it).nextInt();
            if (!(this.names.get(element$iv).length() > 0)) {
                throw new IllegalArgumentException("A day-of-week name can not be empty".toString());
            }
            for (int ix2 = 0; ix2 < element$iv; ix2++) {
                if (Intrinsics.areEqual(this.names.get(element$iv), this.names.get(ix2))) {
                    throw new IllegalArgumentException(("Day-of-week names must be unique, but '" + this.names.get(element$iv) + "' was repeated").toString());
                }
            }
        }
    }

    public final List<String> getNames() {
        return this.names;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DayOfWeekNames(String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday) {
        this(CollectionsKt.listOf((Object[]) new String[]{monday, tuesday, wednesday, thursday, friday, saturday, sunday}));
        Intrinsics.checkNotNullParameter(monday, "monday");
        Intrinsics.checkNotNullParameter(tuesday, "tuesday");
        Intrinsics.checkNotNullParameter(wednesday, "wednesday");
        Intrinsics.checkNotNullParameter(thursday, "thursday");
        Intrinsics.checkNotNullParameter(friday, "friday");
        Intrinsics.checkNotNullParameter(saturday, "saturday");
        Intrinsics.checkNotNullParameter(sunday, "sunday");
    }

    /* compiled from: LocalDateFormat.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlinx/datetime/format/DayOfWeekNames$Companion;", "", "()V", "ENGLISH_ABBREVIATED", "Lkotlinx/datetime/format/DayOfWeekNames;", "getENGLISH_ABBREVIATED", "()Lkotlinx/datetime/format/DayOfWeekNames;", "ENGLISH_FULL", "getENGLISH_FULL", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DayOfWeekNames getENGLISH_FULL() {
            return DayOfWeekNames.ENGLISH_FULL;
        }

        public final DayOfWeekNames getENGLISH_ABBREVIATED() {
            return DayOfWeekNames.ENGLISH_ABBREVIATED;
        }
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this.names, ", ", "DayOfWeekNames(", ")", 0, null, DayOfWeekNames$toString$1.INSTANCE, 24, null);
    }

    public boolean equals(Object other) {
        return (other instanceof DayOfWeekNames) && Intrinsics.areEqual(this.names, ((DayOfWeekNames) other).names);
    }

    public int hashCode() {
        return this.names.hashCode();
    }
}