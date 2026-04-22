package tv.danmaku.bili.ui.splash;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashTestAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B2\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J$\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003J8\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR,\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/splash/SplashTestItem;", "", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "action", "Lkotlin/Function1;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getTitle", "()Ljava/lang/String;", "getAction", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashTestItem {
    public static final int $stable = 0;
    private final Function1<Context, Unit> action;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SplashTestItem copy$default(SplashTestItem splashTestItem, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = splashTestItem.title;
        }
        if ((i & 2) != 0) {
            function1 = splashTestItem.action;
        }
        return splashTestItem.copy(str, function1);
    }

    public final String component1() {
        return this.title;
    }

    public final Function1<Context, Unit> component2() {
        return this.action;
    }

    public final SplashTestItem copy(String str, Function1<? super Context, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(function1, "action");
        return new SplashTestItem(str, function1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SplashTestItem) {
            SplashTestItem splashTestItem = (SplashTestItem) obj;
            return Intrinsics.areEqual(this.title, splashTestItem.title) && Intrinsics.areEqual(this.action, splashTestItem.action);
        }
        return false;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.action.hashCode();
    }

    public String toString() {
        String str = this.title;
        return "SplashTestItem(title=" + str + ", action=" + this.action + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SplashTestItem(String title, Function1<? super Context, Unit> function1) {
        Intrinsics.checkNotNullParameter(title, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(function1, "action");
        this.title = title;
        this.action = function1;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Function1<Context, Unit> getAction() {
        return this.action;
    }
}