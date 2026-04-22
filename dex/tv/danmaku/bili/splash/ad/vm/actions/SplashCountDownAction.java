package tv.danmaku.bili.splash.ad.vm.actions;

import com.bilibili.lib.homepage.splash.actions.SplashStateUpdateAction;
import com.bilibili.lib.homepage.splash.model.SplashState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;

/* compiled from: SplashCountDownAction.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/splash/ad/vm/actions/SplashCountDownAction;", "Lcom/bilibili/lib/homepage/splash/actions/SplashStateUpdateAction;", "totalMs", "", "leftTimeMs", "<init>", "(II)V", "getTotalMs", "()I", "getLeftTimeMs", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashCountDownAction implements SplashStateUpdateAction {
    public static final int $stable = 0;
    private final int leftTimeMs;
    private final int totalMs;

    public SplashCountDownAction() {
        this(0, 0, 3, null);
    }

    public static /* synthetic */ SplashCountDownAction copy$default(SplashCountDownAction splashCountDownAction, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = splashCountDownAction.totalMs;
        }
        if ((i3 & 2) != 0) {
            i2 = splashCountDownAction.leftTimeMs;
        }
        return splashCountDownAction.copy(i, i2);
    }

    public final int component1() {
        return this.totalMs;
    }

    public final int component2() {
        return this.leftTimeMs;
    }

    public final SplashCountDownAction copy(int i, int i2) {
        return new SplashCountDownAction(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SplashCountDownAction) {
            SplashCountDownAction splashCountDownAction = (SplashCountDownAction) obj;
            return this.totalMs == splashCountDownAction.totalMs && this.leftTimeMs == splashCountDownAction.leftTimeMs;
        }
        return false;
    }

    public int hashCode() {
        return (this.totalMs * 31) + this.leftTimeMs;
    }

    public /* synthetic */ boolean needEmit() {
        return SplashStateUpdateAction.-CC.$default$needEmit(this);
    }

    public /* synthetic */ SplashState reduce(SplashState splashState) {
        return SplashStateUpdateAction.-CC.$default$reduce(this, splashState);
    }

    public String toString() {
        int i = this.totalMs;
        return "SplashCountDownAction(totalMs=" + i + ", leftTimeMs=" + this.leftTimeMs + ")";
    }

    public SplashCountDownAction(int totalMs, int leftTimeMs) {
        this.totalMs = totalMs;
        this.leftTimeMs = leftTimeMs;
    }

    public /* synthetic */ SplashCountDownAction(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getTotalMs() {
        return this.totalMs;
    }

    public final int getLeftTimeMs() {
        return this.leftTimeMs;
    }
}