package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.CouponInfoFloor;
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
/* compiled from: ActivityCouponSheetComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$CouponListComponent$2$1", f = "ActivityCouponSheetComponent.kt", i = {}, l = {478}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ActivityCouponSheetComponentKt$CouponListComponent$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<CouponInfoFloor.CouponInfo> $couponList;
    final /* synthetic */ CouponInfoFloor.DetailNetPriceInfo $detailNetPriceInfo;
    final /* synthetic */ SnapshotStateList<MergedCouponItem> $mergedCouponListState;
    final /* synthetic */ PageViewModel $pageViewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityCouponSheetComponentKt$CouponListComponent$2$1(PageViewModel pageViewModel, List<CouponInfoFloor.CouponInfo> list, CouponInfoFloor.DetailNetPriceInfo detailNetPriceInfo, SnapshotStateList<MergedCouponItem> snapshotStateList, Continuation<? super ActivityCouponSheetComponentKt$CouponListComponent$2$1> continuation) {
        super(2, continuation);
        this.$pageViewModel = pageViewModel;
        this.$couponList = list;
        this.$detailNetPriceInfo = detailNetPriceInfo;
        this.$mergedCouponListState = snapshotStateList;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ActivityCouponSheetComponentKt$CouponListComponent$2$1(this.$pageViewModel, this.$couponList, this.$detailNetPriceInfo, this.$mergedCouponListState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
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