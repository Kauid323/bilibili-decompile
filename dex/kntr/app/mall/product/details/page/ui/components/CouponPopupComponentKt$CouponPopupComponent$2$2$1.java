package kntr.app.mall.product.details.page.ui.components;

import kntr.app.mall.product.details.page.api.model.CouponPackageInfoModel;
import kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CouponPopupComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.CouponPopupComponentKt$CouponPopupComponent$2$2$1", f = "CouponPopupComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class CouponPopupComponentKt$CouponPopupComponent$2$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProductDetailsPageUpCouponDisplayModel $displayModel;
    final /* synthetic */ PageViewModel $pageVM;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CouponPopupComponentKt$CouponPopupComponent$2$2$1(ProductDetailsPageUpCouponDisplayModel productDetailsPageUpCouponDisplayModel, PageViewModel pageViewModel, Continuation<? super CouponPopupComponentKt$CouponPopupComponent$2$2$1> continuation) {
        super(2, continuation);
        this.$displayModel = productDetailsPageUpCouponDisplayModel;
        this.$pageVM = pageViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CouponPopupComponentKt$CouponPopupComponent$2$2$1(this.$displayModel, this.$pageVM, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        CouponPackageInfoModel.CouponPackagePopInfoModel.UserInfo relatedUpInfo;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CouponPackageInfoModel.CouponPackagePopInfoModel popupInfoModel = this.$displayModel.getPopupInfoModel();
                Long upId = (popupInfoModel == null || (relatedUpInfo = popupInfoModel.getRelatedUpInfo()) == null) ? null : relatedUpInfo.getMid();
                this.$pageVM.markAutoFetchedUpCouponPopupDisplayed$product_details_page_debug(upId);
                this.$pageVM.reportUpCouponSheetShow$product_details_page_debug();
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}