package kntr.app.digital.preview.shop;

import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStoreKt;
import kotlin.Metadata;

/* compiled from: ShopPreviewPageDataModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {ReportBuildInParam.MID, RoomRecommendViewModel.EMPTY_CURSOR, "getMid", "()J", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ShopPreviewPageDataModuleKt {
    public static final long getMid() {
        AccountState.Logged logged = (AccountState) KAccountStoreKt.getAccountHolder().getState().getValue();
        if (logged instanceof AccountState.Logged) {
            return logged.getUserInfo().getMid();
        }
        return 0L;
    }
}