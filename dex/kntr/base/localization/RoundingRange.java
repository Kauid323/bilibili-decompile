package kntr.base.localization;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: NumberFormat.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB7\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J.\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\nHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006*"}, d2 = {"Lkntr/base/localization/RoundingRange;", "", "min", "", "max", "type", "Lkntr/base/localization/RoundingType;", "<init>", "(JLjava/lang/Long;Lkntr/base/localization/RoundingType;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/Long;Lkntr/base/localization/RoundingType;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMin", "()J", "getMax", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getType", "()Lkntr/base/localization/RoundingType;", "component1", "component2", "component3", "copy", "(JLjava/lang/Long;Lkntr/base/localization/RoundingType;)Lkntr/base/localization/RoundingRange;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$localization_debug", "$serializer", "Companion", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class RoundingRange {
    public static final int $stable = 0;
    private final Long max;
    private final long min;
    private final RoundingType type;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.localization.RoundingRange$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = RoundingRange._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public static /* synthetic */ RoundingRange copy$default(RoundingRange roundingRange, long j, Long l, RoundingType roundingType, int i, Object obj) {
        if ((i & 1) != 0) {
            j = roundingRange.min;
        }
        if ((i & 2) != 0) {
            l = roundingRange.max;
        }
        if ((i & 4) != 0) {
            roundingType = roundingRange.type;
        }
        return roundingRange.copy(j, l, roundingType);
    }

    public final long component1() {
        return this.min;
    }

    public final Long component2() {
        return this.max;
    }

    public final RoundingType component3() {
        return this.type;
    }

    public final RoundingRange copy(long j, Long l, RoundingType roundingType) {
        Intrinsics.checkNotNullParameter(roundingType, "type");
        return new RoundingRange(j, l, roundingType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RoundingRange) {
            RoundingRange roundingRange = (RoundingRange) obj;
            return this.min == roundingRange.min && Intrinsics.areEqual(this.max, roundingRange.max) && this.type == roundingRange.type;
        }
        return false;
    }

    public int hashCode() {
        return (((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.min) * 31) + (this.max == null ? 0 : this.max.hashCode())) * 31) + this.type.hashCode();
    }

    public String toString() {
        long j = this.min;
        Long l = this.max;
        return "RoundingRange(min=" + j + ", max=" + l + ", type=" + this.type + ")";
    }

    /* compiled from: NumberFormat.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/base/localization/RoundingRange$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/localization/RoundingRange;", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<RoundingRange> serializer() {
            return RoundingRange$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ RoundingRange(int seen0, long min, Long max, RoundingType type, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (seen0 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 7, RoundingRange$$serializer.INSTANCE.getDescriptor());
        }
        this.min = min;
        this.max = max;
        this.type = type;
    }

    public RoundingRange(long min, Long max, RoundingType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.min = min;
        this.max = max;
        this.type = type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return RoundingType.Companion.serializer();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$localization_debug(RoundingRange self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeLongElement(serialDesc, 0, self.min);
        output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.max);
        output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.type);
    }

    public final long getMin() {
        return this.min;
    }

    public final Long getMax() {
        return this.max;
    }

    public final RoundingType getType() {
        return this.type;
    }
}