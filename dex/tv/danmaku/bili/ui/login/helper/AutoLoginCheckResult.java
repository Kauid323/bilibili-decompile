package tv.danmaku.bili.ui.login.helper;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: QuickLoginHelper.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/ui/login/helper/AutoLoginCheckResult;", "", "data", "Ltv/danmaku/bili/ui/login/helper/AutoLoginData;", "goOn", "", "<init>", "(Ltv/danmaku/bili/ui/login/helper/AutoLoginData;Z)V", "getData", "()Ltv/danmaku/bili/ui/login/helper/AutoLoginData;", "getGoOn", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AutoLoginCheckResult {
    public static final int $stable = 8;
    private final AutoLoginData data;
    private final boolean goOn;

    public static /* synthetic */ AutoLoginCheckResult copy$default(AutoLoginCheckResult autoLoginCheckResult, AutoLoginData autoLoginData, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            autoLoginData = autoLoginCheckResult.data;
        }
        if ((i & 2) != 0) {
            z = autoLoginCheckResult.goOn;
        }
        return autoLoginCheckResult.copy(autoLoginData, z);
    }

    public final AutoLoginData component1() {
        return this.data;
    }

    public final boolean component2() {
        return this.goOn;
    }

    public final AutoLoginCheckResult copy(AutoLoginData autoLoginData, boolean z) {
        Intrinsics.checkNotNullParameter(autoLoginData, "data");
        return new AutoLoginCheckResult(autoLoginData, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AutoLoginCheckResult) {
            AutoLoginCheckResult autoLoginCheckResult = (AutoLoginCheckResult) obj;
            return Intrinsics.areEqual(this.data, autoLoginCheckResult.data) && this.goOn == autoLoginCheckResult.goOn;
        }
        return false;
    }

    public int hashCode() {
        return (this.data.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.goOn);
    }

    public String toString() {
        AutoLoginData autoLoginData = this.data;
        return "AutoLoginCheckResult(data=" + autoLoginData + ", goOn=" + this.goOn + ")";
    }

    public AutoLoginCheckResult(AutoLoginData data, boolean goOn) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.goOn = goOn;
    }

    public /* synthetic */ AutoLoginCheckResult(AutoLoginData autoLoginData, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(autoLoginData, (i & 2) != 0 ? true : z);
    }

    public final AutoLoginData getData() {
        return this.data;
    }

    public final boolean getGoOn() {
        return this.goOn;
    }
}