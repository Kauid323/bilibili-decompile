package tv.danmaku.bili.rating;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: MarketHelper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/rating/SAMSUNGMarket;", "Ltv/danmaku/bili/rating/AbsMarket;", "<init>", "()V", "marketProtocol", "", "appPkg", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public class SAMSUNGMarket extends AbsMarket {
    public static final int $stable = 8;

    public SAMSUNGMarket() {
        super("com.sec.android.app.samsungapps");
    }

    @Override // tv.danmaku.bili.rating.AbsMarket
    public String marketProtocol(String appPkg) {
        Intrinsics.checkNotNullParameter(appPkg, "appPkg");
        return "samsungapps://ProductDetail/" + appPkg;
    }
}