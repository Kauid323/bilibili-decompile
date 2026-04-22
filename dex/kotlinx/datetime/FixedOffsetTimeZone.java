package kotlinx.datetime;

import j$.time.ZoneId;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.serializers.FixedOffsetTimeZoneSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: TimeZoneJvm.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkotlinx/datetime/FixedOffsetTimeZone;", "Lkotlinx/datetime/TimeZone;", "Lkotlinx/datetime/UtcOffset;", "offset", "j$/time/ZoneId", "zoneId", "<init>", "(Lkotlinx/datetime/UtcOffset;Lj$/time/ZoneId;)V", "(Lkotlinx/datetime/UtcOffset;)V", "Lkotlinx/datetime/UtcOffset;", "getOffset", "()Lkotlinx/datetime/UtcOffset;", "", "getTotalSeconds", "()I", "getTotalSeconds$annotations", "()V", "totalSeconds", "Companion", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable(with = FixedOffsetTimeZoneSerializer.class)
public final class FixedOffsetTimeZone extends TimeZone {
    public static final Companion Companion = new Companion(null);
    private final UtcOffset offset;

    @Deprecated(message = "Use offset.totalSeconds", replaceWith = @ReplaceWith(expression = "offset.totalSeconds", imports = {}))
    public static /* synthetic */ void getTotalSeconds$annotations() {
    }

    /* compiled from: TimeZoneJvm.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lkotlinx/datetime/FixedOffsetTimeZone$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/datetime/FixedOffsetTimeZone;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<FixedOffsetTimeZone> serializer() {
            return FixedOffsetTimeZoneSerializer.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedOffsetTimeZone(UtcOffset offset, ZoneId zoneId) {
        super(zoneId);
        Intrinsics.checkNotNullParameter(offset, "offset");
        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
        this.offset = offset;
    }

    public final UtcOffset getOffset() {
        return this.offset;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FixedOffsetTimeZone(UtcOffset offset) {
        this(offset, offset.getZoneOffset$kotlinx_datetime());
        Intrinsics.checkNotNullParameter(offset, "offset");
    }

    public final int getTotalSeconds() {
        return this.offset.getTotalSeconds();
    }
}