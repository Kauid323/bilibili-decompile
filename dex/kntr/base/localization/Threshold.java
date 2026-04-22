package kntr.base.localization;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NumberFormat.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0083\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lkntr/base/localization/Threshold;", "", "units", "Lkntr/base/localization/Units;", "limit", "", "suffix", "", "<init>", "(Lkntr/base/localization/Units;JLjava/lang/String;)V", "getUnits", "()Lkntr/base/localization/Units;", "getLimit", "()J", "getSuffix", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable(with = ThresholdSerializer.class)
public final class Threshold {
    public static final Companion Companion = new Companion(null);
    private final long limit;
    private final String suffix;
    private final Units units;

    public static /* synthetic */ Threshold copy$default(Threshold threshold, Units units, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            units = threshold.units;
        }
        if ((i & 2) != 0) {
            j = threshold.limit;
        }
        if ((i & 4) != 0) {
            str = threshold.suffix;
        }
        return threshold.copy(units, j, str);
    }

    public final Units component1() {
        return this.units;
    }

    public final long component2() {
        return this.limit;
    }

    public final String component3() {
        return this.suffix;
    }

    public final Threshold copy(Units units, long j, String str) {
        Intrinsics.checkNotNullParameter(units, "units");
        Intrinsics.checkNotNullParameter(str, "suffix");
        return new Threshold(units, j, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Threshold) {
            Threshold threshold = (Threshold) obj;
            return Intrinsics.areEqual(this.units, threshold.units) && this.limit == threshold.limit && Intrinsics.areEqual(this.suffix, threshold.suffix);
        }
        return false;
    }

    public int hashCode() {
        return (((this.units.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.limit)) * 31) + this.suffix.hashCode();
    }

    public String toString() {
        Units units = this.units;
        long j = this.limit;
        return "Threshold(units=" + units + ", limit=" + j + ", suffix=" + this.suffix + ")";
    }

    /* compiled from: NumberFormat.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/base/localization/Threshold$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/localization/Threshold;", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Threshold> serializer() {
            return ThresholdSerializer.INSTANCE;
        }
    }

    public Threshold(Units units, long limit, String suffix) {
        Intrinsics.checkNotNullParameter(units, "units");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        this.units = units;
        this.limit = limit;
        this.suffix = suffix;
    }

    public final Units getUnits() {
        return this.units;
    }

    public final long getLimit() {
        return this.limit;
    }

    public final String getSuffix() {
        return this.suffix;
    }
}