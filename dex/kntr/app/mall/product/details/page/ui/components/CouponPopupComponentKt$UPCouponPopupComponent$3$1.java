package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.runtime.MutableIntState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CouponPopupComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.CouponPopupComponentKt$UPCouponPopupComponent$3$1", f = "CouponPopupComponent.kt", i = {}, l = {ConstantsKt.RECOMMEND_RESERVATION_CARD_HEIGHT}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class CouponPopupComponentKt$UPCouponPopupComponent$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableIntState $countDownSeconds$delegate;
    final /* synthetic */ Function0<Unit> $onClose;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CouponPopupComponentKt$UPCouponPopupComponent$3$1(Function0<Unit> function0, MutableIntState mutableIntState, Continuation<? super CouponPopupComponentKt$UPCouponPopupComponent$3$1> continuation) {
        super(2, continuation);
        this.$onClose = function0;
        this.$countDownSeconds$delegate = mutableIntState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CouponPopupComponentKt$UPCouponPopupComponent$3$1(this.$onClose, this.$countDownSeconds$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002e -> B:13:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        CouponPopupComponentKt$UPCouponPopupComponent$3$1 couponPopupComponentKt$UPCouponPopupComponent$3$1;
        int UPCouponPopupComponent$lambda$3;
        int UPCouponPopupComponent$lambda$32;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                couponPopupComponentKt$UPCouponPopupComponent$3$1 = this;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                couponPopupComponentKt$UPCouponPopupComponent$3$1 = this;
                UPCouponPopupComponent$lambda$32 = CouponPopupComponentKt.UPCouponPopupComponent$lambda$3(couponPopupComponentKt$UPCouponPopupComponent$3$1.$countDownSeconds$delegate);
                couponPopupComponentKt$UPCouponPopupComponent$3$1.$countDownSeconds$delegate.setIntValue(UPCouponPopupComponent$lambda$32 - 1);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        UPCouponPopupComponent$lambda$3 = CouponPopupComponentKt.UPCouponPopupComponent$lambda$3(couponPopupComponentKt$UPCouponPopupComponent$3$1.$countDownSeconds$delegate);
        if (UPCouponPopupComponent$lambda$3 <= 0) {
            couponPopupComponentKt$UPCouponPopupComponent$3$1.label = 1;
            if (DelayKt.delay(1000L, (Continuation) couponPopupComponentKt$UPCouponPopupComponent$3$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            UPCouponPopupComponent$lambda$32 = CouponPopupComponentKt.UPCouponPopupComponent$lambda$3(couponPopupComponentKt$UPCouponPopupComponent$3$1.$countDownSeconds$delegate);
            couponPopupComponentKt$UPCouponPopupComponent$3$1.$countDownSeconds$delegate.setIntValue(UPCouponPopupComponent$lambda$32 - 1);
            UPCouponPopupComponent$lambda$3 = CouponPopupComponentKt.UPCouponPopupComponent$lambda$3(couponPopupComponentKt$UPCouponPopupComponent$3$1.$countDownSeconds$delegate);
            if (UPCouponPopupComponent$lambda$3 <= 0) {
                couponPopupComponentKt$UPCouponPopupComponent$3$1.$onClose.invoke();
                return Unit.INSTANCE;
            }
        }
    }
}