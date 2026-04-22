package tv.danmaku.bili.splash.ad.test;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: SplashTestItem.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/splash/ad/test/SplashTestItem;", "", "id", "", ReportUtilKt.POS_TITLE, "", "action", "Lkotlin/Function0;", "", "<init>", "(ILjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getAction", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashTestItem {
    public static final int $stable = 0;
    private final Function0<Unit> action;
    private final int id;
    private final String title;

    public SplashTestItem() {
        this(0, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SplashTestItem copy$default(SplashTestItem splashTestItem, int i, String str, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = splashTestItem.id;
        }
        if ((i2 & 2) != 0) {
            str = splashTestItem.title;
        }
        if ((i2 & 4) != 0) {
            function0 = splashTestItem.action;
        }
        return splashTestItem.copy(i, str, function0);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final Function0<Unit> component3() {
        return this.action;
    }

    public final SplashTestItem copy(int i, String str, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, ReportUtilKt.POS_TITLE);
        Intrinsics.checkNotNullParameter(function0, "action");
        return new SplashTestItem(i, str, function0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SplashTestItem) {
            SplashTestItem splashTestItem = (SplashTestItem) obj;
            return this.id == splashTestItem.id && Intrinsics.areEqual(this.title, splashTestItem.title) && Intrinsics.areEqual(this.action, splashTestItem.action);
        }
        return false;
    }

    public int hashCode() {
        return (((this.id * 31) + this.title.hashCode()) * 31) + this.action.hashCode();
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        return "SplashTestItem(id=" + i + ", title=" + str + ", action=" + this.action + ")";
    }

    public SplashTestItem(int id, String title, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(title, ReportUtilKt.POS_TITLE);
        Intrinsics.checkNotNullParameter(function0, "action");
        this.id = id;
        this.title = title;
        this.action = function0;
    }

    public /* synthetic */ SplashTestItem(int i, String str, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? new Function0() { // from class: tv.danmaku.bili.splash.ad.test.SplashTestItem$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        } : function0);
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Function0<Unit> getAction() {
        return this.action;
    }
}