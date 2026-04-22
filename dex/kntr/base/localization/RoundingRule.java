package kntr.base.localization;

import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: NumberFormat.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006%"}, d2 = {"Lkntr/base/localization/RoundingRule;", "", "ranges", "", "Lkntr/base/localization/RoundingRange;", "<init>", "(Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRanges", "()Ljava/util/List;", "roundingFor", "Lkotlin/Function1;", "", WatchLaterReporterKt.KEY_NUM, "", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$localization_debug", "Companion", "$serializer", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class RoundingRule {
    private final List<RoundingRange> ranges;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.localization.RoundingRule$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = RoundingRule._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};
    private static final RoundingRule DEFAULT = new RoundingRule(CollectionsKt.listOf(new RoundingRange[]{new RoundingRange(0, 1000000L, RoundingType.REAL_ROUND), new RoundingRange(1000000, null, RoundingType.FLOOR)}));

    /* compiled from: NumberFormat.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RoundingType.values().length];
            try {
                iArr[RoundingType.REAL_ROUND.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[RoundingType.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[RoundingType.CEIL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RoundingRule copy$default(RoundingRule roundingRule, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = roundingRule.ranges;
        }
        return roundingRule.copy(list);
    }

    public final List<RoundingRange> component1() {
        return this.ranges;
    }

    public final RoundingRule copy(List<RoundingRange> list) {
        Intrinsics.checkNotNullParameter(list, "ranges");
        return new RoundingRule(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RoundingRule) && Intrinsics.areEqual(this.ranges, ((RoundingRule) obj).ranges);
    }

    public int hashCode() {
        return this.ranges.hashCode();
    }

    public String toString() {
        return "RoundingRule(ranges=" + this.ranges + ")";
    }

    public /* synthetic */ RoundingRule(int seen0, List ranges, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, RoundingRule$$serializer.INSTANCE.getDescriptor());
        }
        this.ranges = ranges;
    }

    public RoundingRule(List<RoundingRange> list) {
        Intrinsics.checkNotNullParameter(list, "ranges");
        this.ranges = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(RoundingRange$$serializer.INSTANCE);
    }

    public final List<RoundingRange> getRanges() {
        return this.ranges;
    }

    public final Function1<Double, Double> roundingFor(long num) {
        Object element$iv;
        RoundingType roundingType;
        boolean z;
        long abs = Math.abs(num);
        Iterable $this$firstOrNull$iv = this.ranges;
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                RoundingRange range = (RoundingRange) element$iv;
                if (abs < range.getMin() || (range.getMax() != null && abs >= range.getMax().longValue())) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        RoundingRange range2 = (RoundingRange) element$iv;
        if (range2 == null || (roundingType = range2.getType()) == null) {
            roundingType = RoundingType.REAL_ROUND;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[roundingType.ordinal()]) {
            case 1:
                return RoundingRule$roundingFor$1.INSTANCE;
            case 2:
                return RoundingRule$roundingFor$2.INSTANCE;
            case 3:
                return RoundingRule$roundingFor$3.INSTANCE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* compiled from: NumberFormat.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lkntr/base/localization/RoundingRule$Companion;", "", "<init>", "()V", "DEFAULT", "Lkntr/base/localization/RoundingRule;", "getDEFAULT", "()Lkntr/base/localization/RoundingRule;", "serializer", "Lkotlinx/serialization/KSerializer;", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<RoundingRule> serializer() {
            return RoundingRule$$serializer.INSTANCE;
        }

        public final RoundingRule getDEFAULT() {
            return RoundingRule.DEFAULT;
        }
    }
}