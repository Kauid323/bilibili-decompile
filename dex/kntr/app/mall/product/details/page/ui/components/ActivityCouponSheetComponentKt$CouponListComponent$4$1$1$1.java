package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.CouponInfoFloor;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.imp.InitGMultiDomainKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActivityCouponSheetComponent.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$CouponListComponent$4$1$1$1", f = "ActivityCouponSheetComponent.kt", i = {}, l = {InitGMultiDomainKt.HTTP_CODE_HTTP_BAD_GATEWAY}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ActivityCouponSheetComponentKt$CouponListComponent$4$1$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ List<CouponInfoFloor.CouponInfo> $couponList;
    final /* synthetic */ CouponInfoFloor.DetailNetPriceInfo $detailNetPriceInfo;
    final /* synthetic */ SnapshotStateList<MergedCouponItem> $mergedCouponListState;
    final /* synthetic */ PageViewModel $pageViewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityCouponSheetComponentKt$CouponListComponent$4$1$1$1(PageViewModel pageViewModel, List<CouponInfoFloor.CouponInfo> list, CouponInfoFloor.DetailNetPriceInfo detailNetPriceInfo, SnapshotStateList<MergedCouponItem> snapshotStateList, Continuation<? super ActivityCouponSheetComponentKt$CouponListComponent$4$1$1$1> continuation) {
        super(1, continuation);
        this.$pageViewModel = pageViewModel;
        this.$couponList = list;
        this.$detailNetPriceInfo = detailNetPriceInfo;
        this.$mergedCouponListState = snapshotStateList;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ActivityCouponSheetComponentKt$CouponListComponent$4$1$1$1(this.$pageViewModel, this.$couponList, this.$detailNetPriceInfo, this.$mergedCouponListState, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object CouponListComponent$fetchAndMergeCouponList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                CouponListComponent$fetchAndMergeCouponList = ActivityCouponSheetComponentKt.CouponListComponent$fetchAndMergeCouponList(this.$pageViewModel, this.$couponList, this.$detailNetPriceInfo, this.$mergedCouponListState, (Continuation) this);
                if (CouponListComponent$fetchAndMergeCouponList == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}