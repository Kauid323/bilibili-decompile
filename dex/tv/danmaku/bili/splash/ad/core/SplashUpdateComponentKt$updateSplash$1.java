package tv.danmaku.bili.splash.ad.core;

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
import tv.danmaku.bili.splash.ad.utils.SplashStateStorageHelperKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashUpdateComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.core.SplashUpdateComponentKt$updateSplash$1", f = "SplashUpdateComponent.kt", i = {}, l = {BR.changeEpBtnVisible, BR.chatPlayerInputHint}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SplashUpdateComponentKt$updateSplash$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delay;
    final /* synthetic */ String $openEvent;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashUpdateComponentKt$updateSplash$1(long j, String str, Continuation<? super SplashUpdateComponentKt$updateSplash$1> continuation) {
        super(2, continuation);
        this.$delay = j;
        this.$openEvent = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashUpdateComponentKt$updateSplash$1(this.$delay, this.$openEvent, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object forceUpdateSplash;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (DelayKt.delay(this.$delay, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                SplashUpdateComponentKt.canUpdateJobInterrupt = false;
                this.label = 2;
                forceUpdateSplash = SplashUpdateComponentKt.forceUpdateSplash(this.$openEvent, (Continuation) this);
                if (forceUpdateSplash == coroutine_suspended) {
                    return coroutine_suspended;
                }
                SplashUpdateComponentKt.updateJob = null;
                SplashUpdateComponentKt.canUpdateJobInterrupt = true;
                SplashUpdateComponentKt.updateSplash(SplashStateStorageHelperKt.getSplashLastRequestIntervalMs(), "cycle");
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                SplashUpdateComponentKt.canUpdateJobInterrupt = false;
                this.label = 2;
                forceUpdateSplash = SplashUpdateComponentKt.forceUpdateSplash(this.$openEvent, (Continuation) this);
                if (forceUpdateSplash == coroutine_suspended) {
                }
                SplashUpdateComponentKt.updateJob = null;
                SplashUpdateComponentKt.canUpdateJobInterrupt = true;
                SplashUpdateComponentKt.updateSplash(SplashStateStorageHelperKt.getSplashLastRequestIntervalMs(), "cycle");
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                SplashUpdateComponentKt.updateJob = null;
                SplashUpdateComponentKt.canUpdateJobInterrupt = true;
                SplashUpdateComponentKt.updateSplash(SplashStateStorageHelperKt.getSplashLastRequestIntervalMs(), "cycle");
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}