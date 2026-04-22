package io.ktor.util.date;

import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: Date.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0087\b\u0018\u0000 F2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002FGBO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010Bg\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000f\u0010\u0014J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001bJ\u0010\u0010\u001e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u001bJ\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u001bJ\u0010\u0010\"\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u001bJ\u0010\u0010%\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b%\u0010&Jj\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0018\u0010'J\u001a\u0010*\u001a\u00020)2\b\u0010\u0015\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b,\u0010\u001bJ\u0010\u0010.\u001a\u00020-HÖ\u0001¢\u0006\u0004\b.\u0010/J'\u00108\u001a\u0002052\u0006\u00100\u001a\u00020\u00002\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u000203H\u0001¢\u0006\u0004\b6\u00107R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00109\u001a\u0004\b:\u0010\u001bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00109\u001a\u0004\b;\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u00109\u001a\u0004\b<\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010=\u001a\u0004\b>\u0010\u001fR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u00109\u001a\u0004\b?\u0010\u001bR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u00109\u001a\u0004\b@\u0010\u001bR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010A\u001a\u0004\bB\u0010#R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u00109\u001a\u0004\bC\u0010\u001bR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010D\u001a\u0004\bE\u0010&¨\u0006H"}, d2 = {"Lio/ktor/util/date/GMTDate;", "", "", "seconds", "minutes", "hours", "Lio/ktor/util/date/WeekDay;", "dayOfWeek", "dayOfMonth", "dayOfYear", "Lio/ktor/util/date/Month;", "month", "year", "", "timestamp", "<init>", "(IIILio/ktor/util/date/WeekDay;IILio/ktor/util/date/Month;IJ)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IIIILio/ktor/util/date/WeekDay;IILio/ktor/util/date/Month;IJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "other", "compareTo", "(Lio/ktor/util/date/GMTDate;)I", "copy", "()Lio/ktor/util/date/GMTDate;", "component1", "()I", "component2", "component3", "component4", "()Lio/ktor/util/date/WeekDay;", "component5", "component6", "component7", "()Lio/ktor/util/date/Month;", "component8", "component9", "()J", "(IIILio/ktor/util/date/WeekDay;IILio/ktor/util/date/Month;IJ)Lio/ktor/util/date/GMTDate;", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_utils", "(Lio/ktor/util/date/GMTDate;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "I", "getSeconds", "getMinutes", "getHours", "Lio/ktor/util/date/WeekDay;", "getDayOfWeek", "getDayOfMonth", "getDayOfYear", "Lio/ktor/util/date/Month;", "getMonth", "getYear", "J", "getTimestamp", "Companion", "$serializer", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
public final class GMTDate implements Comparable<GMTDate> {
    private final int dayOfMonth;
    private final WeekDay dayOfWeek;
    private final int dayOfYear;
    private final int hours;
    private final int minutes;
    private final Month month;
    private final int seconds;
    private final long timestamp;
    private final int year;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, EnumsKt.createSimpleEnumSerializer("io.ktor.util.date.WeekDay", WeekDay.values()), null, null, EnumsKt.createSimpleEnumSerializer("io.ktor.util.date.Month", Month.values()), null, null};
    private static final GMTDate START = DateJvmKt.GMTDate(0L);

    public final int component1() {
        return this.seconds;
    }

    public final int component2() {
        return this.minutes;
    }

    public final int component3() {
        return this.hours;
    }

    public final WeekDay component4() {
        return this.dayOfWeek;
    }

    public final int component5() {
        return this.dayOfMonth;
    }

    public final int component6() {
        return this.dayOfYear;
    }

    public final Month component7() {
        return this.month;
    }

    public final int component8() {
        return this.year;
    }

    public final long component9() {
        return this.timestamp;
    }

    public final GMTDate copy(int i, int i2, int i3, WeekDay weekDay, int i4, int i5, Month month, int i6, long j) {
        Intrinsics.checkNotNullParameter(weekDay, "dayOfWeek");
        Intrinsics.checkNotNullParameter(month, "month");
        return new GMTDate(i, i2, i3, weekDay, i4, i5, month, i6, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GMTDate) {
            GMTDate gMTDate = (GMTDate) obj;
            return this.seconds == gMTDate.seconds && this.minutes == gMTDate.minutes && this.hours == gMTDate.hours && this.dayOfWeek == gMTDate.dayOfWeek && this.dayOfMonth == gMTDate.dayOfMonth && this.dayOfYear == gMTDate.dayOfYear && this.month == gMTDate.month && this.year == gMTDate.year && this.timestamp == gMTDate.timestamp;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((this.seconds * 31) + this.minutes) * 31) + this.hours) * 31) + this.dayOfWeek.hashCode()) * 31) + this.dayOfMonth) * 31) + this.dayOfYear) * 31) + this.month.hashCode()) * 31) + this.year) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.timestamp);
    }

    public String toString() {
        return "GMTDate(seconds=" + this.seconds + ", minutes=" + this.minutes + ", hours=" + this.hours + ", dayOfWeek=" + this.dayOfWeek + ", dayOfMonth=" + this.dayOfMonth + ", dayOfYear=" + this.dayOfYear + ", month=" + this.month + ", year=" + this.year + ", timestamp=" + this.timestamp + ')';
    }

    public /* synthetic */ GMTDate(int seen0, int seconds, int minutes, int hours, WeekDay dayOfWeek, int dayOfMonth, int dayOfYear, Month month, int year, long timestamp, SerializationConstructorMarker serializationConstructorMarker) {
        if (511 != (seen0 & 511)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 511, GMTDate$$serializer.INSTANCE.getDescriptor());
        }
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
        this.dayOfWeek = dayOfWeek;
        this.dayOfMonth = dayOfMonth;
        this.dayOfYear = dayOfYear;
        this.month = month;
        this.year = year;
        this.timestamp = timestamp;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$ktor_utils(GMTDate self, CompositeEncoder output, SerialDescriptor serialDesc) {
        SerializationStrategy[] serializationStrategyArr = $childSerializers;
        output.encodeIntElement(serialDesc, 0, self.seconds);
        output.encodeIntElement(serialDesc, 1, self.minutes);
        output.encodeIntElement(serialDesc, 2, self.hours);
        output.encodeSerializableElement(serialDesc, 3, serializationStrategyArr[3], self.dayOfWeek);
        output.encodeIntElement(serialDesc, 4, self.dayOfMonth);
        output.encodeIntElement(serialDesc, 5, self.dayOfYear);
        output.encodeSerializableElement(serialDesc, 6, serializationStrategyArr[6], self.month);
        output.encodeIntElement(serialDesc, 7, self.year);
        output.encodeLongElement(serialDesc, 8, self.timestamp);
    }

    public GMTDate(int seconds, int minutes, int hours, WeekDay dayOfWeek, int dayOfMonth, int dayOfYear, Month month, int year, long timestamp) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        Intrinsics.checkNotNullParameter(month, "month");
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
        this.dayOfWeek = dayOfWeek;
        this.dayOfMonth = dayOfMonth;
        this.dayOfYear = dayOfYear;
        this.month = month;
        this.year = year;
        this.timestamp = timestamp;
    }

    public final int getSeconds() {
        return this.seconds;
    }

    public final int getMinutes() {
        return this.minutes;
    }

    public final int getHours() {
        return this.hours;
    }

    public final WeekDay getDayOfWeek() {
        return this.dayOfWeek;
    }

    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public final int getDayOfYear() {
        return this.dayOfYear;
    }

    public final Month getMonth() {
        return this.month;
    }

    public final int getYear() {
        return this.year;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @Override // java.lang.Comparable
    public int compareTo(GMTDate other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.compare(this.timestamp, other.timestamp);
    }

    public final GMTDate copy() {
        return DateJvmKt.GMTDate$default(null, 1, null);
    }

    /* compiled from: Date.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/util/date/GMTDate$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/util/date/GMTDate;", "serializer", "()Lkotlinx/serialization/KSerializer;", "START", "Lio/ktor/util/date/GMTDate;", "getSTART", "()Lio/ktor/util/date/GMTDate;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602230614216d888f0a-efdb-42c6-942f-a4b7baea1519/202602230614216d888f0a-efdb-42c6-942f-a4b7baea1519.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<GMTDate> serializer() {
            return GMTDate$$serializer.INSTANCE;
        }

        public final GMTDate getSTART() {
            return GMTDate.START;
        }
    }
}