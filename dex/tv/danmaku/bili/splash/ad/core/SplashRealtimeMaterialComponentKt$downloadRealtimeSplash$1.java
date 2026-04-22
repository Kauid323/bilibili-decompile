package tv.danmaku.bili.splash.ad.core;

import com.bilibili.app.comm.list.common.utils.ListDeviceInfoKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.SplashExtra;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashRealtimeMaterialComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.core.SplashRealtimeMaterialComponentKt$downloadRealtimeSplash$1", f = "SplashRealtimeMaterialComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SplashRealtimeMaterialComponentKt$downloadRealtimeSplash$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SplashOrder $splash;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashRealtimeMaterialComponentKt$downloadRealtimeSplash$1(SplashOrder splashOrder, Continuation<? super SplashRealtimeMaterialComponentKt$downloadRealtimeSplash$1> continuation) {
        super(2, continuation);
        this.$splash = splashOrder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> splashRealtimeMaterialComponentKt$downloadRealtimeSplash$1 = new SplashRealtimeMaterialComponentKt$downloadRealtimeSplash$1(this.$splash, continuation);
        splashRealtimeMaterialComponentKt$downloadRealtimeSplash$1.L$0 = obj;
        return splashRealtimeMaterialComponentKt$downloadRealtimeSplash$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        boolean handleRealtimeSplashVideoTypeDownload;
        boolean success;
        boolean handleRealtimeSplashVideoTypeDownload2;
        boolean handleRealtimeSplashImageTypeDownload;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                CoroutineScope $this$invokeSuspend_u24lambda_u240 = (CoroutineScope) this.L$0;
                SplashOrder splashOrder = this.$splash;
                try {
                    Result.Companion companion = Result.Companion;
                    boolean z = true;
                    if (ExtSplashOrderKt.isVideo(splashOrder) && ListDeviceInfoKt.isHdApp()) {
                        handleRealtimeSplashVideoTypeDownload2 = SplashRealtimeMaterialComponentKt.handleRealtimeSplashVideoTypeDownload(splashOrder);
                        if (handleRealtimeSplashVideoTypeDownload2) {
                            handleRealtimeSplashImageTypeDownload = SplashRealtimeMaterialComponentKt.handleRealtimeSplashImageTypeDownload(splashOrder);
                            if (handleRealtimeSplashImageTypeDownload) {
                                handleRealtimeSplashVideoTypeDownload = true;
                            }
                        }
                        handleRealtimeSplashVideoTypeDownload = false;
                    } else {
                        handleRealtimeSplashVideoTypeDownload = ExtSplashOrderKt.isVideo(splashOrder) ? SplashRealtimeMaterialComponentKt.handleRealtimeSplashVideoTypeDownload(splashOrder) : SplashRealtimeMaterialComponentKt.handleRealtimeSplashImageTypeDownload(splashOrder);
                    }
                    success = handleRealtimeSplashVideoTypeDownload;
                    SplashExtra runtimeExtra = splashOrder.getRuntimeExtra();
                    if (!success) {
                        z = false;
                    }
                    runtimeExtra.setRealtimeMaterialLoadSuccess(z);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (success) {
                    SplashRealtimeMaterialComponentKt.handleRealtimeEggVideoTypeDownload(splashOrder);
                    obj2 = Result.constructor-impl(BuildersKt.async$default($this$invokeSuspend_u24lambda_u240, (CoroutineContext) null, (CoroutineStart) null, new SplashRealtimeMaterialComponentKt$downloadRealtimeSplash$1$1$1(splashOrder, null), 3, (Object) null));
                    SplashOrder splashOrder2 = this.$splash;
                    Throwable e = Result.exceptionOrNull-impl(obj2);
                    if (e != null) {
                        SplashCustomReporterKt.reportRealtimeDownloadError(splashOrder2, "exception occur", e);
                        BLog.i("[Splash]SplashRealtimeMaterialComponent", "download real splash failed", e);
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}