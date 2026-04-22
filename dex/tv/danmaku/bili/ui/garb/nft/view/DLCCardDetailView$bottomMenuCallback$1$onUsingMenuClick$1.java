package tv.danmaku.bili.ui.garb.nft.view;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.nft.DLCSplashSettingService;

/* compiled from: DLCCardDetailView.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.nft.view.DLCCardDetailView$bottomMenuCallback$1$onUsingMenuClick$1", f = "DLCCardDetailView.kt", i = {}, l = {BR.icon}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class DLCCardDetailView$bottomMenuCallback$1$onUsingMenuClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DLCCardDetailView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DLCCardDetailView$bottomMenuCallback$1$onUsingMenuClick$1(DLCCardDetailView dLCCardDetailView, Continuation<? super DLCCardDetailView$bottomMenuCallback$1$onUsingMenuClick$1> continuation) {
        super(2, continuation);
        this.this$0 = dLCCardDetailView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DLCCardDetailView$bottomMenuCallback$1$onUsingMenuClick$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        DLCSplashSettingService dLCSplashSettingService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                dLCSplashSettingService = this.this$0.splashSettingService;
                this.label = 1;
                if (dLCSplashSettingService.splashSetting(this.this$0.getActivityId(), this.this$0.getCardTypeId(), (Continuation) this) == coroutine_suspended) {
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