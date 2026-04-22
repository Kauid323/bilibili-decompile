package tv.danmaku.bili.ui.main2.mine;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.app.comm.restrict.utils.TeenagersModeKt;
import com.bilibili.lib.dd.DeviceDecision;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.api.AccountMine;

/* compiled from: HomeUserCenterViewModel.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ0\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J=\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000e¨\u0006%"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/AccountMineData;", "", "idle", "", "accountMine", "Ltv/danmaku/bili/ui/main2/api/AccountMine;", "fromCache", "garbEnum", "Ltv/danmaku/bili/ui/main2/mine/GarbEnum;", "version", "", "<init>", "(ZLtv/danmaku/bili/ui/main2/api/AccountMine;ZLtv/danmaku/bili/ui/main2/mine/GarbEnum;J)V", "getIdle", "()Z", "getAccountMine", "()Ltv/danmaku/bili/ui/main2/api/AccountMine;", "getFromCache", "getGarbEnum", "()Ltv/danmaku/bili/ui/main2/mine/GarbEnum;", "getVersion", "()J", "showTeenagersAgeSetting", "getShowTeenagersAgeSetting", "next", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AccountMineData {
    public static final int $stable = 8;
    private final AccountMine accountMine;
    private final boolean fromCache;
    private final GarbEnum garbEnum;
    private final boolean idle;
    private final long version;

    public static /* synthetic */ AccountMineData copy$default(AccountMineData accountMineData, boolean z, AccountMine accountMine, boolean z2, GarbEnum garbEnum, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            z = accountMineData.idle;
        }
        if ((i & 2) != 0) {
            accountMine = accountMineData.accountMine;
        }
        AccountMine accountMine2 = accountMine;
        if ((i & 4) != 0) {
            z2 = accountMineData.fromCache;
        }
        boolean z3 = z2;
        if ((i & 8) != 0) {
            garbEnum = accountMineData.garbEnum;
        }
        GarbEnum garbEnum2 = garbEnum;
        if ((i & 16) != 0) {
            j = accountMineData.version;
        }
        return accountMineData.copy(z, accountMine2, z3, garbEnum2, j);
    }

    public final boolean component1() {
        return this.idle;
    }

    public final AccountMine component2() {
        return this.accountMine;
    }

    public final boolean component3() {
        return this.fromCache;
    }

    public final GarbEnum component4() {
        return this.garbEnum;
    }

    public final long component5() {
        return this.version;
    }

    public final AccountMineData copy(boolean z, AccountMine accountMine, boolean z2, GarbEnum garbEnum, long j) {
        Intrinsics.checkNotNullParameter(garbEnum, "garbEnum");
        return new AccountMineData(z, accountMine, z2, garbEnum, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AccountMineData) {
            AccountMineData accountMineData = (AccountMineData) obj;
            return this.idle == accountMineData.idle && Intrinsics.areEqual(this.accountMine, accountMineData.accountMine) && this.fromCache == accountMineData.fromCache && this.garbEnum == accountMineData.garbEnum && this.version == accountMineData.version;
        }
        return false;
    }

    public int hashCode() {
        return (((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.idle) * 31) + (this.accountMine == null ? 0 : this.accountMine.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.fromCache)) * 31) + this.garbEnum.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.version);
    }

    public String toString() {
        boolean z = this.idle;
        AccountMine accountMine = this.accountMine;
        boolean z2 = this.fromCache;
        GarbEnum garbEnum = this.garbEnum;
        return "AccountMineData(idle=" + z + ", accountMine=" + accountMine + ", fromCache=" + z2 + ", garbEnum=" + garbEnum + ", version=" + this.version + ")";
    }

    public AccountMineData(boolean idle, AccountMine accountMine, boolean fromCache, GarbEnum garbEnum, long version) {
        Intrinsics.checkNotNullParameter(garbEnum, "garbEnum");
        this.idle = idle;
        this.accountMine = accountMine;
        this.fromCache = fromCache;
        this.garbEnum = garbEnum;
        this.version = version;
    }

    public final boolean getIdle() {
        return this.idle;
    }

    public final AccountMine getAccountMine() {
        return this.accountMine;
    }

    public final boolean getFromCache() {
        return this.fromCache;
    }

    public final GarbEnum getGarbEnum() {
        return this.garbEnum;
    }

    public final long getVersion() {
        return this.version;
    }

    public final boolean getShowTeenagersAgeSetting() {
        return ((Boolean) TeenagersModeKt.getTeenagersModeState().getValue()).booleanValue() && DeviceDecision.INSTANCE.getBoolean("dd_show_teens_age_setting", false);
    }

    public static /* synthetic */ AccountMineData next$default(AccountMineData accountMineData, boolean z, AccountMine accountMine, boolean z2, GarbEnum garbEnum, int i, Object obj) {
        if ((i & 1) != 0) {
            z = accountMineData.idle;
        }
        if ((i & 2) != 0) {
            accountMine = accountMineData.accountMine;
        }
        if ((i & 4) != 0) {
            z2 = accountMineData.fromCache;
        }
        if ((i & 8) != 0) {
            garbEnum = accountMineData.garbEnum;
        }
        return accountMineData.next(z, accountMine, z2, garbEnum);
    }

    public final AccountMineData next(boolean idle, AccountMine accountMine, boolean fromCache, GarbEnum garbEnum) {
        Intrinsics.checkNotNullParameter(garbEnum, "garbEnum");
        return copy(idle, accountMine, fromCache, garbEnum, this.version + 1);
    }
}