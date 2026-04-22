package tv.danmaku.bili.ui.main2.mine.topleft;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.api.AccountMine;
import tv.danmaku.bili.ui.main2.mine.GarbEnum;

/* compiled from: TopLeft.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/topleft/TopLeftData;", "", "inTeensModeAndShowTeensAgeSetting", "", "activityAnswer", "Ltv/danmaku/bili/ui/main2/api/AccountMine$ActivityAnswer;", "garbEnum", "Ltv/danmaku/bili/ui/main2/mine/GarbEnum;", "<init>", "(ZLtv/danmaku/bili/ui/main2/api/AccountMine$ActivityAnswer;Ltv/danmaku/bili/ui/main2/mine/GarbEnum;)V", "getInTeensModeAndShowTeensAgeSetting", "()Z", "getActivityAnswer", "()Ltv/danmaku/bili/ui/main2/api/AccountMine$ActivityAnswer;", "getGarbEnum", "()Ltv/danmaku/bili/ui/main2/mine/GarbEnum;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TopLeftData {
    public static final int $stable = 8;
    private final AccountMine.ActivityAnswer activityAnswer;
    private final GarbEnum garbEnum;
    private final boolean inTeensModeAndShowTeensAgeSetting;

    public static /* synthetic */ TopLeftData copy$default(TopLeftData topLeftData, boolean z, AccountMine.ActivityAnswer activityAnswer, GarbEnum garbEnum, int i, Object obj) {
        if ((i & 1) != 0) {
            z = topLeftData.inTeensModeAndShowTeensAgeSetting;
        }
        if ((i & 2) != 0) {
            activityAnswer = topLeftData.activityAnswer;
        }
        if ((i & 4) != 0) {
            garbEnum = topLeftData.garbEnum;
        }
        return topLeftData.copy(z, activityAnswer, garbEnum);
    }

    public final boolean component1() {
        return this.inTeensModeAndShowTeensAgeSetting;
    }

    public final AccountMine.ActivityAnswer component2() {
        return this.activityAnswer;
    }

    public final GarbEnum component3() {
        return this.garbEnum;
    }

    public final TopLeftData copy(boolean z, AccountMine.ActivityAnswer activityAnswer, GarbEnum garbEnum) {
        Intrinsics.checkNotNullParameter(garbEnum, "garbEnum");
        return new TopLeftData(z, activityAnswer, garbEnum);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TopLeftData) {
            TopLeftData topLeftData = (TopLeftData) obj;
            return this.inTeensModeAndShowTeensAgeSetting == topLeftData.inTeensModeAndShowTeensAgeSetting && Intrinsics.areEqual(this.activityAnswer, topLeftData.activityAnswer) && this.garbEnum == topLeftData.garbEnum;
        }
        return false;
    }

    public int hashCode() {
        return (((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.inTeensModeAndShowTeensAgeSetting) * 31) + (this.activityAnswer == null ? 0 : this.activityAnswer.hashCode())) * 31) + this.garbEnum.hashCode();
    }

    public String toString() {
        boolean z = this.inTeensModeAndShowTeensAgeSetting;
        AccountMine.ActivityAnswer activityAnswer = this.activityAnswer;
        return "TopLeftData(inTeensModeAndShowTeensAgeSetting=" + z + ", activityAnswer=" + activityAnswer + ", garbEnum=" + this.garbEnum + ")";
    }

    public TopLeftData(boolean inTeensModeAndShowTeensAgeSetting, AccountMine.ActivityAnswer activityAnswer, GarbEnum garbEnum) {
        Intrinsics.checkNotNullParameter(garbEnum, "garbEnum");
        this.inTeensModeAndShowTeensAgeSetting = inTeensModeAndShowTeensAgeSetting;
        this.activityAnswer = activityAnswer;
        this.garbEnum = garbEnum;
    }

    public final boolean getInTeensModeAndShowTeensAgeSetting() {
        return this.inTeensModeAndShowTeensAgeSetting;
    }

    public final AccountMine.ActivityAnswer getActivityAnswer() {
        return this.activityAnswer;
    }

    public final GarbEnum getGarbEnum() {
        return this.garbEnum;
    }
}