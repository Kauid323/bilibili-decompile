package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NumberFormat.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0083\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/base/localization/CarryConfig;", "", "units", "Lkntr/base/localization/Units;", "strategy", "Lkntr/base/localization/CarryStrategy;", "<init>", "(Lkntr/base/localization/Units;Lkntr/base/localization/CarryStrategy;)V", "getUnits", "()Lkntr/base/localization/Units;", "getStrategy", "()Lkntr/base/localization/CarryStrategy;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable(with = CarryConfigSerializer.class)
public final class CarryConfig {
    public static final Companion Companion = new Companion(null);
    private final CarryStrategy strategy;
    private final Units units;

    public static /* synthetic */ CarryConfig copy$default(CarryConfig carryConfig, Units units, CarryStrategy carryStrategy, int i, Object obj) {
        if ((i & 1) != 0) {
            units = carryConfig.units;
        }
        if ((i & 2) != 0) {
            carryStrategy = carryConfig.strategy;
        }
        return carryConfig.copy(units, carryStrategy);
    }

    public final Units component1() {
        return this.units;
    }

    public final CarryStrategy component2() {
        return this.strategy;
    }

    public final CarryConfig copy(Units units, CarryStrategy carryStrategy) {
        Intrinsics.checkNotNullParameter(units, "units");
        Intrinsics.checkNotNullParameter(carryStrategy, "strategy");
        return new CarryConfig(units, carryStrategy);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CarryConfig) {
            CarryConfig carryConfig = (CarryConfig) obj;
            return Intrinsics.areEqual(this.units, carryConfig.units) && this.strategy == carryConfig.strategy;
        }
        return false;
    }

    public int hashCode() {
        return (this.units.hashCode() * 31) + this.strategy.hashCode();
    }

    public String toString() {
        Units units = this.units;
        return "CarryConfig(units=" + units + ", strategy=" + this.strategy + ")";
    }

    /* compiled from: NumberFormat.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/base/localization/CarryConfig$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/localization/CarryConfig;", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CarryConfig> serializer() {
            return CarryConfigSerializer.INSTANCE;
        }
    }

    public CarryConfig(Units units, CarryStrategy strategy) {
        Intrinsics.checkNotNullParameter(units, "units");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.units = units;
        this.strategy = strategy;
    }

    public final Units getUnits() {
        return this.units;
    }

    public final CarryStrategy getStrategy() {
        return this.strategy;
    }
}