package tv.danmaku.bili.ui.main2.mine;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeUserCenterFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$vipEntranceRealExposure$1", f = "HomeUserCenterFragment.kt", i = {}, l = {961}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HomeUserCenterFragment$vipEntranceRealExposure$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeUserCenterFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeUserCenterFragment$vipEntranceRealExposure$1(HomeUserCenterFragment homeUserCenterFragment, Continuation<? super HomeUserCenterFragment$vipEntranceRealExposure$1> continuation) {
        super(2, continuation);
        this.this$0 = homeUserCenterFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeUserCenterFragment$vipEntranceRealExposure$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
        r0 = r4.this$0.mineVipModuleManager;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        MineVipModuleManager mineVipModuleManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (DelayKt.delay(1000L, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (this.this$0.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) && mineVipModuleManager != null) {
            mineVipModuleManager.reportLatencyExposure();
        }
        return Unit.INSTANCE;
    }
}