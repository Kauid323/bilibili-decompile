package io.ktor.util.date;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Date.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/util/date/Month;", "", "", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public enum Month {
    JANUARY("Jan"),
    FEBRUARY("Feb"),
    MARCH("Mar"),
    APRIL("Apr"),
    MAY("May"),
    JUNE("Jun"),
    JULY("Jul"),
    AUGUST("Aug"),
    SEPTEMBER("Sep"),
    OCTOBER("Oct"),
    NOVEMBER("Nov"),
    DECEMBER("Dec");
    
    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Companion Companion = new Companion(null);

    Month(String value) {
        this.value = value;
    }

    public final String getValue() {
        return this.value;
    }

    /* compiled from: Date.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/util/date/Month$Companion;", "", "<init>", "()V", "", "ordinal", "Lio/ktor/util/date/Month;", "from", "(I)Lio/ktor/util/date/Month;", "", "value", "(Ljava/lang/String;)Lio/ktor/util/date/Month;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602230614216d888f0a-efdb-42c6-942f-a4b7baea1519/202602230614216d888f0a-efdb-42c6-942f-a4b7baea1519.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Month from(int ordinal) {
            return (Month) Month.getEntries().get(ordinal);
        }

        public final Month from(String value) {
            Object obj;
            Intrinsics.checkNotNullParameter(value, "value");
            Iterator it = Month.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                Month it2 = (Month) obj;
                if (Intrinsics.areEqual(it2.getValue(), value)) {
                    break;
                }
            }
            Month month = (Month) obj;
            if (month == null) {
                throw new IllegalStateException(("Invalid month: " + value).toString());
            }
            return month;
        }
    }

    public static EnumEntries<Month> getEntries() {
        return $ENTRIES;
    }
}