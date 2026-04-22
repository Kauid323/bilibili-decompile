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
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.SplashListResponse;
import tv.danmaku.bili.splash.ad.model.SplashOrder;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashUpdateComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.core.SplashUpdateComponentKt$increaseSplashShowCount$1", f = "SplashUpdateComponent.kt", i = {}, l = {192}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SplashUpdateComponentKt$increaseSplashShowCount$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SplashOrder $splash;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashUpdateComponentKt$increaseSplashShowCount$1(SplashOrder splashOrder, Continuation<? super SplashUpdateComponentKt$increaseSplashShowCount$1> continuation) {
        super(2, continuation);
        this.$splash = splashOrder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashUpdateComponentKt$increaseSplashShowCount$1(this.$splash, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Iterable splashList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                SplashListResponse data = SplashUpdateComponentKt.readConfigFromDisk();
                BLog.i("updateLocalSplashOrder, splashId = " + this.$splash.getId() + " ，exposeCount = " + this.$splash.getLocalExposeCount());
                if ((data != null ? data.getSplashList() : null) == null) {
                    BLog.i("updateLocalSplashOrder, splash data invalid");
                }
                if (data != null && (splashList = data.getSplashList()) != null) {
                    Iterable $this$forEach$iv = splashList;
                    SplashOrder splashOrder = this.$splash;
                    for (Object element$iv : $this$forEach$iv) {
                        SplashOrder sp = (SplashOrder) element$iv;
                        if (sp.getId() == splashOrder.getId()) {
                            int exposeCount = splashOrder.getLocalExposeCount() + 1;
                            long time = System.currentTimeMillis();
                            splashOrder.setLocalExposeCount(exposeCount);
                            splashOrder.setLastExposeTime(time);
                            splashOrder.setLocalExposed(true);
                            sp.setLocalExposeCount(exposeCount);
                            sp.setLastExposeTime(time);
                            sp.setLocalExposed(true);
                        }
                    }
                }
                this.label = 1;
                if (SplashUpdateComponentKt.saveConfigToDisk(data, (Continuation) this) == coroutine_suspended) {
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