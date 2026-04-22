package tv.danmaku.biliplayerv2.service;

import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.DelayKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToast;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IToastServiceKtx.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"retainToast", "", "Ltv/danmaku/biliplayerv2/service/IToastService;", "toast", "Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast;", "(Ltv/danmaku/biliplayerv2/service/IToastService;Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "biliplayerv2_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class IToastServiceKtxKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARN: Type inference failed for: r8v0, types: [tv.danmaku.biliplayerv2.service.IToastService, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1, types: [tv.danmaku.biliplayerv2.widget.toast.PlayerToast] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r9v0, types: [tv.danmaku.biliplayerv2.widget.toast.PlayerToast, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v1, types: [tv.danmaku.biliplayerv2.service.IToastService] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object retainToast(IToastService iToastService, PlayerToast playerToast, Continuation<? super Unit> continuation) {
        IToastServiceKtxKt$retainToast$1 iToastServiceKtxKt$retainToast$1;
        try {
            if (continuation instanceof IToastServiceKtxKt$retainToast$1) {
                iToastServiceKtxKt$retainToast$1 = (IToastServiceKtxKt$retainToast$1) continuation;
                if ((iToastServiceKtxKt$retainToast$1.label & Integer.MIN_VALUE) != 0) {
                    iToastServiceKtxKt$retainToast$1.label -= Integer.MIN_VALUE;
                    Object $result = iToastServiceKtxKt$retainToast$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (iToastServiceKtxKt$retainToast$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            iToastService.showToast(playerToast);
                            try {
                                if (playerToast.getDuration() != PlayerToastConfig.DURATION_FOREVER) {
                                    long duration = playerToast.getDuration();
                                    iToastServiceKtxKt$retainToast$1.L$0 = iToastService;
                                    iToastServiceKtxKt$retainToast$1.L$1 = playerToast;
                                    iToastServiceKtxKt$retainToast$1.label = 2;
                                    return DelayKt.delay(duration, iToastServiceKtxKt$retainToast$1) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                                }
                                iToastServiceKtxKt$retainToast$1.L$0 = iToastService;
                                iToastServiceKtxKt$retainToast$1.L$1 = playerToast;
                                iToastServiceKtxKt$retainToast$1.label = 1;
                                if (DelayKt.awaitCancellation(iToastServiceKtxKt$retainToast$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                throw new KotlinNothingValueException();
                            } catch (CancellationException e) {
                                e = e;
                                playerToast = iToastService;
                                iToastService = playerToast;
                                playerToast.dismissToast(iToastService);
                                throw e;
                            }
                        case 1:
                            PlayerToast playerToast2 = (PlayerToast) iToastServiceKtxKt$retainToast$1.L$1;
                            IToastService iToastService2 = (IToastService) iToastServiceKtxKt$retainToast$1.L$0;
                            ResultKt.throwOnFailure($result);
                            throw new KotlinNothingValueException();
                        case 2:
                            PlayerToast playerToast3 = (PlayerToast) iToastServiceKtxKt$retainToast$1.L$1;
                            IToastService iToastService3 = (IToastService) iToastServiceKtxKt$retainToast$1.L$0;
                            ResultKt.throwOnFailure($result);
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (iToastServiceKtxKt$retainToast$1.label) {
            }
        } catch (CancellationException e2) {
            e = e2;
        }
        iToastServiceKtxKt$retainToast$1 = new IToastServiceKtxKt$retainToast$1(continuation);
        Object $result2 = iToastServiceKtxKt$retainToast$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
}