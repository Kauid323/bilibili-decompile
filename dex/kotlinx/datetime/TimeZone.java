package kotlinx.datetime;

import j$.time.DateTimeException;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.serializers.TimeZoneSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: TimeZoneJvm.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0017\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\b\u001a\u00020\u0007*\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\n\u001a\u00020\u0006*\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001a\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015¨\u0006\u001c"}, d2 = {"Lkotlinx/datetime/TimeZone;", "", "j$/time/ZoneId", "zoneId", "<init>", "(Lj$/time/ZoneId;)V", "Lkotlinx/datetime/Instant;", "Lkotlinx/datetime/LocalDateTime;", "toLocalDateTime", "(Lkotlinx/datetime/Instant;)Lkotlinx/datetime/LocalDateTime;", "toInstant", "(Lkotlinx/datetime/LocalDateTime;)Lkotlinx/datetime/Instant;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lj$/time/ZoneId;", "getZoneId$kotlinx_datetime", "()Lj$/time/ZoneId;", "getId", "id", "Companion", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable(with = TimeZoneSerializer.class)
public class TimeZone {
    public static final Companion Companion = new Companion(null);
    private static final FixedOffsetTimeZone UTC;
    private final ZoneId zoneId;

    public TimeZone(ZoneId zoneId) {
        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
        this.zoneId = zoneId;
    }

    public final ZoneId getZoneId$kotlinx_datetime() {
        return this.zoneId;
    }

    public final String getId() {
        String id = this.zoneId.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        return id;
    }

    public final LocalDateTime toLocalDateTime(Instant $this$toLocalDateTime) {
        Intrinsics.checkNotNullParameter($this$toLocalDateTime, "<this>");
        return TimeZoneKt.toLocalDateTime($this$toLocalDateTime, this);
    }

    public final Instant toInstant(LocalDateTime $this$toInstant) {
        Intrinsics.checkNotNullParameter($this$toInstant, "<this>");
        return TimeZoneKt.toInstant($this$toInstant, this);
    }

    public boolean equals(Object other) {
        return this == other || ((other instanceof TimeZone) && Intrinsics.areEqual(this.zoneId, ((TimeZone) other).zoneId));
    }

    public int hashCode() {
        return this.zoneId.hashCode();
    }

    public String toString() {
        String zoneId = this.zoneId.toString();
        Intrinsics.checkNotNullExpressionValue(zoneId, "toString(...)");
        return zoneId;
    }

    /* compiled from: TimeZoneJvm.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/datetime/TimeZone$Companion;", "", "<init>", "()V", "Lkotlinx/datetime/TimeZone;", "currentSystemDefault", "()Lkotlinx/datetime/TimeZone;", "", "zoneId", "of", "(Ljava/lang/String;)Lkotlinx/datetime/TimeZone;", "j$/time/ZoneId", "ofZone$kotlinx_datetime", "(Lj$/time/ZoneId;)Lkotlinx/datetime/TimeZone;", "ofZone", "Lkotlinx/serialization/KSerializer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "Lkotlinx/datetime/FixedOffsetTimeZone;", "UTC", "Lkotlinx/datetime/FixedOffsetTimeZone;", "getUTC", "()Lkotlinx/datetime/FixedOffsetTimeZone;", "", "getAvailableZoneIds", "()Ljava/util/Set;", "availableZoneIds", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<TimeZone> serializer() {
            return TimeZoneSerializer.INSTANCE;
        }

        public final TimeZone currentSystemDefault() {
            ZoneId systemDefault = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(systemDefault, "systemDefault(...)");
            return ofZone$kotlinx_datetime(systemDefault);
        }

        public final FixedOffsetTimeZone getUTC() {
            return TimeZone.UTC;
        }

        public final TimeZone of(String zoneId) {
            Intrinsics.checkNotNullParameter(zoneId, "zoneId");
            try {
                ZoneId of = ZoneId.of(zoneId);
                Intrinsics.checkNotNullExpressionValue(of, "of(...)");
                return ofZone$kotlinx_datetime(of);
            } catch (Exception e) {
                if (e instanceof DateTimeException) {
                    throw new IllegalTimeZoneException(e);
                }
                throw e;
            }
        }

        public final TimeZone ofZone$kotlinx_datetime(ZoneId zoneId) {
            Intrinsics.checkNotNullParameter(zoneId, "zoneId");
            if (zoneId instanceof ZoneOffset) {
                return new FixedOffsetTimeZone(new UtcOffset((ZoneOffset) zoneId));
            }
            if (TimeZoneKt__TimeZoneJvmKt.access$isFixedOffset(zoneId)) {
                ZoneOffset normalized = zoneId.normalized();
                Intrinsics.checkNotNull(normalized, "null cannot be cast to non-null type java.time.ZoneOffset");
                return new FixedOffsetTimeZone(new UtcOffset(normalized), zoneId);
            }
            return new TimeZone(zoneId);
        }

        public final Set<String> getAvailableZoneIds() {
            Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
            Intrinsics.checkNotNullExpressionValue(availableZoneIds, "getAvailableZoneIds(...)");
            return availableZoneIds;
        }
    }

    static {
        ZoneOffset UTC2 = ZoneOffset.UTC;
        Intrinsics.checkNotNullExpressionValue(UTC2, "UTC");
        UTC = UtcOffsetKt.asTimeZone(new UtcOffset(UTC2));
    }
}