package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NumberFormat.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\b\u0018\u0000 '2\u00020\u0001:\u0002'(B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006)"}, d2 = {"Lkntr/base/localization/NumberFormatRule;", "", "threshold", "Lkntr/base/localization/ThresholdRule;", "rounding", "Lkntr/base/localization/RoundingRule;", "carry", "Lkntr/base/localization/CarryRule;", "<init>", "(Lkntr/base/localization/ThresholdRule;Lkntr/base/localization/RoundingRule;Lkntr/base/localization/CarryRule;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/base/localization/ThresholdRule;Lkntr/base/localization/RoundingRule;Lkntr/base/localization/CarryRule;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getThreshold", "()Lkntr/base/localization/ThresholdRule;", "getRounding", "()Lkntr/base/localization/RoundingRule;", "getCarry", "()Lkntr/base/localization/CarryRule;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$localization_debug", "Companion", "$serializer", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class NumberFormatRule {
    public static final Companion Companion = new Companion(null);
    private static final NumberFormatRule DEFAULT = new NumberFormatRule(ThresholdRule.Companion.getDEFAULT(), RoundingRule.Companion.getDEFAULT(), (CarryRule) null, 4, (DefaultConstructorMarker) null);
    private final CarryRule carry;
    private final RoundingRule rounding;
    private final ThresholdRule threshold;

    public static /* synthetic */ NumberFormatRule copy$default(NumberFormatRule numberFormatRule, ThresholdRule thresholdRule, RoundingRule roundingRule, CarryRule carryRule, int i, Object obj) {
        if ((i & 1) != 0) {
            thresholdRule = numberFormatRule.threshold;
        }
        if ((i & 2) != 0) {
            roundingRule = numberFormatRule.rounding;
        }
        if ((i & 4) != 0) {
            carryRule = numberFormatRule.carry;
        }
        return numberFormatRule.copy(thresholdRule, roundingRule, carryRule);
    }

    public final ThresholdRule component1() {
        return this.threshold;
    }

    public final RoundingRule component2() {
        return this.rounding;
    }

    public final CarryRule component3() {
        return this.carry;
    }

    public final NumberFormatRule copy(ThresholdRule thresholdRule, RoundingRule roundingRule, CarryRule carryRule) {
        Intrinsics.checkNotNullParameter(thresholdRule, "threshold");
        Intrinsics.checkNotNullParameter(roundingRule, "rounding");
        return new NumberFormatRule(thresholdRule, roundingRule, carryRule);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NumberFormatRule) {
            NumberFormatRule numberFormatRule = (NumberFormatRule) obj;
            return Intrinsics.areEqual(this.threshold, numberFormatRule.threshold) && Intrinsics.areEqual(this.rounding, numberFormatRule.rounding) && Intrinsics.areEqual(this.carry, numberFormatRule.carry);
        }
        return false;
    }

    public int hashCode() {
        return (((this.threshold.hashCode() * 31) + this.rounding.hashCode()) * 31) + (this.carry == null ? 0 : this.carry.hashCode());
    }

    public String toString() {
        ThresholdRule thresholdRule = this.threshold;
        RoundingRule roundingRule = this.rounding;
        return "NumberFormatRule(threshold=" + thresholdRule + ", rounding=" + roundingRule + ", carry=" + this.carry + ")";
    }

    public /* synthetic */ NumberFormatRule(int seen0, ThresholdRule threshold, RoundingRule rounding, CarryRule carry, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (seen0 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, NumberFormatRule$$serializer.INSTANCE.getDescriptor());
        }
        this.threshold = threshold;
        this.rounding = rounding;
        if ((seen0 & 4) == 0) {
            this.carry = null;
        } else {
            this.carry = carry;
        }
    }

    public NumberFormatRule(ThresholdRule threshold, RoundingRule rounding, CarryRule carry) {
        Intrinsics.checkNotNullParameter(threshold, "threshold");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        this.threshold = threshold;
        this.rounding = rounding;
        this.carry = carry;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$localization_debug(NumberFormatRule self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, ThresholdRule$$serializer.INSTANCE, self.threshold);
        output.encodeSerializableElement(serialDesc, 1, RoundingRule$$serializer.INSTANCE, self.rounding);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.carry != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, CarryRule$$serializer.INSTANCE, self.carry);
        }
    }

    public /* synthetic */ NumberFormatRule(ThresholdRule thresholdRule, RoundingRule roundingRule, CarryRule carryRule, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(thresholdRule, roundingRule, (i & 4) != 0 ? null : carryRule);
    }

    public final ThresholdRule getThreshold() {
        return this.threshold;
    }

    public final RoundingRule getRounding() {
        return this.rounding;
    }

    public final CarryRule getCarry() {
        return this.carry;
    }

    /* compiled from: NumberFormat.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lkntr/base/localization/NumberFormatRule$Companion;", "", "<init>", "()V", "DEFAULT", "Lkntr/base/localization/NumberFormatRule;", "getDEFAULT", "()Lkntr/base/localization/NumberFormatRule;", "serializer", "Lkotlinx/serialization/KSerializer;", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<NumberFormatRule> serializer() {
            return NumberFormatRule$$serializer.INSTANCE;
        }

        public final NumberFormatRule getDEFAULT() {
            return NumberFormatRule.DEFAULT;
        }
    }
}