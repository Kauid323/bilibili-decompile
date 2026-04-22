package kotlinx.datetime;

import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.DateTimeFormat;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.format.UtcOffsetFormat;
import kotlinx.datetime.format.UtcOffsetFormatKt;
import kotlinx.datetime.serializers.UtcOffsetSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: UtcOffsetJvm.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0014\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\b¨\u0006\u0017"}, d2 = {"Lkotlinx/datetime/UtcOffset;", "", "j$/time/ZoneOffset", "zoneOffset", "<init>", "(Lj$/time/ZoneOffset;)V", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "toString", "()Ljava/lang/String;", "Lj$/time/ZoneOffset;", "getZoneOffset$kotlinx_datetime", "()Lj$/time/ZoneOffset;", "getTotalSeconds", "totalSeconds", "Companion", "Formats", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable(with = UtcOffsetSerializer.class)
public final class UtcOffset {
    public static final Companion Companion = new Companion(null);
    private static final UtcOffset ZERO;
    private final ZoneOffset zoneOffset;

    public UtcOffset(ZoneOffset zoneOffset) {
        Intrinsics.checkNotNullParameter(zoneOffset, "zoneOffset");
        this.zoneOffset = zoneOffset;
    }

    public final ZoneOffset getZoneOffset$kotlinx_datetime() {
        return this.zoneOffset;
    }

    public final int getTotalSeconds() {
        return this.zoneOffset.getTotalSeconds();
    }

    public int hashCode() {
        return this.zoneOffset.hashCode();
    }

    public boolean equals(Object other) {
        return (other instanceof UtcOffset) && Intrinsics.areEqual(this.zoneOffset, ((UtcOffset) other).zoneOffset);
    }

    public String toString() {
        String zoneOffset = this.zoneOffset.toString();
        Intrinsics.checkNotNullExpressionValue(zoneOffset, "toString(...)");
        return zoneOffset;
    }

    /* compiled from: UtcOffsetJvm.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rJ\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\bJ\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015HÆ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lkotlinx/datetime/UtcOffset$Companion;", "", "()V", "ZERO", "Lkotlinx/datetime/UtcOffset;", "getZERO", "()Lkotlinx/datetime/UtcOffset;", "Format", "Lkotlinx/datetime/format/DateTimeFormat;", "block", "Lkotlin/Function1;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithUtcOffset;", "", "Lkotlin/ExtensionFunctionType;", "parse", "input", "", "format", "offsetString", "", "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<UtcOffset> serializer() {
            return UtcOffsetSerializer.INSTANCE;
        }

        public final UtcOffset getZERO() {
            return UtcOffset.ZERO;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UtcOffset parse$default(Companion companion, CharSequence charSequence, DateTimeFormat dateTimeFormat, int i, Object obj) {
            if ((i & 2) != 0) {
                dateTimeFormat = UtcOffsetKt.getIsoUtcOffsetFormat();
            }
            return companion.parse(charSequence, dateTimeFormat);
        }

        public final UtcOffset parse(CharSequence input, DateTimeFormat<UtcOffset> format) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(format, "format");
            if (format == Formats.INSTANCE.getISO()) {
                DateTimeFormatter access$getIsoFormat = UtcOffsetJvmKt.access$getIsoFormat();
                Intrinsics.checkNotNullExpressionValue(access$getIsoFormat, "access$getIsoFormat(...)");
                return UtcOffsetJvmKt.access$parseWithFormat(input, access$getIsoFormat);
            } else if (format == Formats.INSTANCE.getISO_BASIC()) {
                DateTimeFormatter access$getIsoBasicFormat = UtcOffsetJvmKt.access$getIsoBasicFormat();
                Intrinsics.checkNotNullExpressionValue(access$getIsoBasicFormat, "access$getIsoBasicFormat(...)");
                return UtcOffsetJvmKt.access$parseWithFormat(input, access$getIsoBasicFormat);
            } else if (format == Formats.INSTANCE.getFOUR_DIGITS()) {
                DateTimeFormatter access$getFourDigitsFormat = UtcOffsetJvmKt.access$getFourDigitsFormat();
                Intrinsics.checkNotNullExpressionValue(access$getFourDigitsFormat, "access$getFourDigitsFormat(...)");
                return UtcOffsetJvmKt.access$parseWithFormat(input, access$getFourDigitsFormat);
            } else {
                return format.parse(input);
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This overload is only kept for binary compatibility")
        public final /* synthetic */ UtcOffset parse(String offsetString) {
            Intrinsics.checkNotNullParameter(offsetString, "offsetString");
            return parse$default(this, offsetString, null, 2, null);
        }

        public final DateTimeFormat<UtcOffset> Format(Function1<? super DateTimeFormatBuilder.WithUtcOffset, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return UtcOffsetFormat.Companion.build(block);
        }
    }

    static {
        ZoneOffset UTC = ZoneOffset.UTC;
        Intrinsics.checkNotNullExpressionValue(UTC, "UTC");
        ZERO = new UtcOffset(UTC);
    }

    /* compiled from: UtcOffsetJvm.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lkotlinx/datetime/UtcOffset$Formats;", "", "()V", "FOUR_DIGITS", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/UtcOffset;", "getFOUR_DIGITS", "()Lkotlinx/datetime/format/DateTimeFormat;", "ISO", "getISO", "ISO_BASIC", "getISO_BASIC", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Formats {
        public static final Formats INSTANCE = new Formats();

        private Formats() {
        }

        public final DateTimeFormat<UtcOffset> getISO() {
            return UtcOffsetFormatKt.getISO_OFFSET();
        }

        public final DateTimeFormat<UtcOffset> getISO_BASIC() {
            return UtcOffsetFormatKt.getISO_OFFSET_BASIC();
        }

        public final DateTimeFormat<UtcOffset> getFOUR_DIGITS() {
            return UtcOffsetFormatKt.getFOUR_DIGIT_OFFSET();
        }
    }
}