package kntr.app.ad.domain.click.internal.util;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarketHelper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/domain/click/internal/util/SAMSUNGMarket;", "Lkntr/app/ad/domain/click/internal/util/AbsMarket;", "<init>", "()V", "marketProtocol", RoomRecommendViewModel.EMPTY_CURSOR, "appPkg", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class SAMSUNGMarket extends AbsMarket {
    public SAMSUNGMarket() {
        super("com.sec.android.app.samsungapps");
    }

    @Override // kntr.app.ad.domain.click.internal.util.AbsMarket
    public String marketProtocol(String appPkg) {
        Intrinsics.checkNotNullParameter(appPkg, "appPkg");
        return "samsungapps://ProductDetail/" + appPkg;
    }
}