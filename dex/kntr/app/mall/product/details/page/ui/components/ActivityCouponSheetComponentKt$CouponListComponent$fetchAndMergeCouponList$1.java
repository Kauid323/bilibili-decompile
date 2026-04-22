package kntr.app.mall.product.details.page.ui.components;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActivityCouponSheetComponent.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt", f = "ActivityCouponSheetComponent.kt", i = {0, 0, 0, 0}, l = {466}, m = "CouponListComponent$fetchAndMergeCouponList", n = {"$pageViewModel", "$couponList", "$detailNetPriceInfo", "mergedCouponListState"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class ActivityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1(Continuation<? super ActivityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object CouponListComponent$fetchAndMergeCouponList;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        CouponListComponent$fetchAndMergeCouponList = ActivityCouponSheetComponentKt.CouponListComponent$fetchAndMergeCouponList(null, null, null, null, (Continuation) this);
        return CouponListComponent$fetchAndMergeCouponList;
    }
}