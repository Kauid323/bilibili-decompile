package tv.danmaku.bili.ui.main2.mine;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.api.AccountMine;

/* compiled from: DisplayStrategyUtils.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/DisplayResult;", "", "config", "Ltv/danmaku/bili/ui/main2/api/AccountMine$PositionStrategyConfig;", "sussess", "", "<init>", "(Ltv/danmaku/bili/ui/main2/api/AccountMine$PositionStrategyConfig;Z)V", "getConfig", "()Ltv/danmaku/bili/ui/main2/api/AccountMine$PositionStrategyConfig;", "getSussess", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DisplayResult {
    public static final int $stable = 8;
    private final AccountMine.PositionStrategyConfig config;
    private final boolean sussess;

    public static /* synthetic */ DisplayResult copy$default(DisplayResult displayResult, AccountMine.PositionStrategyConfig positionStrategyConfig, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            positionStrategyConfig = displayResult.config;
        }
        if ((i & 2) != 0) {
            z = displayResult.sussess;
        }
        return displayResult.copy(positionStrategyConfig, z);
    }

    public final AccountMine.PositionStrategyConfig component1() {
        return this.config;
    }

    public final boolean component2() {
        return this.sussess;
    }

    public final DisplayResult copy(AccountMine.PositionStrategyConfig positionStrategyConfig, boolean z) {
        Intrinsics.checkNotNullParameter(positionStrategyConfig, "config");
        return new DisplayResult(positionStrategyConfig, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DisplayResult) {
            DisplayResult displayResult = (DisplayResult) obj;
            return Intrinsics.areEqual(this.config, displayResult.config) && this.sussess == displayResult.sussess;
        }
        return false;
    }

    public int hashCode() {
        return (this.config.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.sussess);
    }

    public String toString() {
        AccountMine.PositionStrategyConfig positionStrategyConfig = this.config;
        return "DisplayResult(config=" + positionStrategyConfig + ", sussess=" + this.sussess + ")";
    }

    public DisplayResult(AccountMine.PositionStrategyConfig config, boolean sussess) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.sussess = sussess;
    }

    public final AccountMine.PositionStrategyConfig getConfig() {
        return this.config;
    }

    public final boolean getSussess() {
        return this.sussess;
    }
}