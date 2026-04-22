package tv.danmaku.bili.rating;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: MarketHelper.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\b'\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016R\u001b\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/rating/AbsMarket;", "", "marketPkgs", "", "", "<init>", "([Ljava/lang/String;)V", "getMarketPkgs", "()[Ljava/lang/String;", "[Ljava/lang/String;", "marketProtocol", "appPkg", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class AbsMarket {
    public static final int $stable = 8;
    private final String[] marketPkgs;

    public AbsMarket(String... marketPkgs) {
        Intrinsics.checkNotNullParameter(marketPkgs, "marketPkgs");
        this.marketPkgs = marketPkgs;
    }

    public final String[] getMarketPkgs() {
        return this.marketPkgs;
    }

    public String marketProtocol(String appPkg) {
        Intrinsics.checkNotNullParameter(appPkg, "appPkg");
        return "market://details?id=" + appPkg;
    }
}