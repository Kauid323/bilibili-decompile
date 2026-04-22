package tv.danmaku.bili.splash.ad.state.actions;

import android.graphics.Rect;
import com.bilibili.lib.homepage.splash.actions.SplashStateUpdateAction;
import com.bilibili.lib.homepage.splash.model.BannerSharePlayInfo;
import com.bilibili.lib.homepage.splash.model.ExecutedPlayerState;
import com.bilibili.lib.homepage.splash.model.PlayerShareData;
import com.bilibili.lib.homepage.splash.model.SelectedSplashTopViewIdInfo;
import com.bilibili.lib.homepage.splash.model.SplashState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: SplashSkipClickEvent.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/splash/ad/state/actions/SplashSkipClickEvent;", "Lcom/bilibili/lib/homepage/splash/actions/SplashStateUpdateAction;", "from", "", "<init>", "(Ljava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "reduce", "Lcom/bilibili/lib/homepage/splash/model/SplashState;", AuthResultCbHelper.ARGS_STATE, "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "splashwidget_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashSkipClickEvent implements SplashStateUpdateAction {
    public static final int $stable = 0;
    private final String from;

    public SplashSkipClickEvent() {
        this(null, 1, null);
    }

    public static /* synthetic */ SplashSkipClickEvent copy$default(SplashSkipClickEvent splashSkipClickEvent, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = splashSkipClickEvent.from;
        }
        return splashSkipClickEvent.copy(str);
    }

    public final String component1() {
        return this.from;
    }

    public final SplashSkipClickEvent copy(String str) {
        Intrinsics.checkNotNullParameter(str, "from");
        return new SplashSkipClickEvent(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SplashSkipClickEvent) && Intrinsics.areEqual(this.from, ((SplashSkipClickEvent) obj).from);
    }

    public int hashCode() {
        return this.from.hashCode();
    }

    public /* synthetic */ boolean needEmit() {
        return SplashStateUpdateAction.-CC.$default$needEmit(this);
    }

    public String toString() {
        return "SplashSkipClickEvent(from=" + this.from + ")";
    }

    public SplashSkipClickEvent(String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        this.from = from;
    }

    public /* synthetic */ SplashSkipClickEvent(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    public final String getFrom() {
        return this.from;
    }

    public SplashState reduce(SplashState state) {
        Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
        return state.getSkipClick() ? state : SplashState.copy$default(state, (Rect) null, (Rect) null, (PlayerShareData) null, (Boolean) null, (SelectedSplashTopViewIdInfo) null, (String) null, (String) null, (String) null, (String) null, false, (ExecutedPlayerState) null, true, false, (BannerSharePlayInfo) null, false, 30719, (Object) null);
    }
}