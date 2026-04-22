package kntr.base.localization;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.localization.Units;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NumberFormat.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\b\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\bHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006#"}, d2 = {"Lkntr/base/localization/ThresholdRule;", "", "rules", "", "Lkntr/base/localization/Threshold;", "<init>", "(Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRules", "()Ljava/util/List;", "thresholdFor", WatchLaterReporterKt.KEY_NUM, "", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$localization_debug", "Companion", "$serializer", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class ThresholdRule {
    private final List<Threshold> rules;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.localization.ThresholdRule$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ThresholdRule._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};
    private static final ThresholdRule DEFAULT = new ThresholdRule(CollectionsKt.listOf(new Threshold[]{new Threshold(Units.TenThousands.INSTANCE, 10000, "万"), new Threshold(Units.HundredMillions.INSTANCE, 100000000, "亿")}));

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ThresholdRule copy$default(ThresholdRule thresholdRule, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = thresholdRule.rules;
        }
        return thresholdRule.copy(list);
    }

    public final List<Threshold> component1() {
        return this.rules;
    }

    public final ThresholdRule copy(List<Threshold> list) {
        Intrinsics.checkNotNullParameter(list, "rules");
        return new ThresholdRule(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ThresholdRule) && Intrinsics.areEqual(this.rules, ((ThresholdRule) obj).rules);
    }

    public int hashCode() {
        return this.rules.hashCode();
    }

    public String toString() {
        return "ThresholdRule(rules=" + this.rules + ")";
    }

    public /* synthetic */ ThresholdRule(int seen0, List rules, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, ThresholdRule$$serializer.INSTANCE.getDescriptor());
        }
        this.rules = rules;
    }

    public ThresholdRule(List<Threshold> list) {
        Intrinsics.checkNotNullParameter(list, "rules");
        this.rules = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(ThresholdSerializer.INSTANCE);
    }

    public final List<Threshold> getRules() {
        return this.rules;
    }

    public final Threshold thresholdFor(long num) {
        Object element$iv;
        boolean z;
        Iterable $this$sortedBy$iv = this.rules;
        List $this$lastOrNull$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: kntr.base.localization.ThresholdRule$thresholdFor$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Threshold it = (Threshold) t;
                Threshold it2 = (Threshold) t2;
                return ComparisonsKt.compareValues(Long.valueOf(it.getLimit()), Long.valueOf(it2.getLimit()));
            }
        });
        ListIterator iterator$iv = $this$lastOrNull$iv.listIterator($this$lastOrNull$iv.size());
        while (true) {
            if (iterator$iv.hasPrevious()) {
                element$iv = iterator$iv.previous();
                Threshold it = (Threshold) element$iv;
                if (Math.abs(num) >= it.getLimit()) {
                    z = true;
                    continue;
                } else {
                    z = false;
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
        Threshold threshold = (Threshold) element$iv;
        return threshold == null ? new Threshold(Units.Ones.INSTANCE, 0L, "") : threshold;
    }

    /* compiled from: NumberFormat.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lkntr/base/localization/ThresholdRule$Companion;", "", "<init>", "()V", "DEFAULT", "Lkntr/base/localization/ThresholdRule;", "getDEFAULT", "()Lkntr/base/localization/ThresholdRule;", "serializer", "Lkotlinx/serialization/KSerializer;", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ThresholdRule> serializer() {
            return ThresholdRule$$serializer.INSTANCE;
        }

        public final ThresholdRule getDEFAULT() {
            return ThresholdRule.DEFAULT;
        }
    }
}