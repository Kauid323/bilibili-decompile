package tv.danmaku.bili.ui.splash.ad;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.bili.ui.splash.SplashOrderFilterReason;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdReporter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.ad.AdReporterKt$reportAd$1", f = "AdReporter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AdReporterKt$reportAd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $adCb;
    final /* synthetic */ int $index;
    final /* synthetic */ boolean $isRealShow;
    final /* synthetic */ int $openEvent;
    final /* synthetic */ SplashOrderFilterReason $reason;
    final /* synthetic */ Splash $splash;
    final /* synthetic */ long $splashId;
    final /* synthetic */ String $splashRequestId;
    final /* synthetic */ int $step;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdReporterKt$reportAd$1(int i, Splash splash, long j, int i2, String str, int i3, boolean z, SplashOrderFilterReason splashOrderFilterReason, String str2, Continuation<? super AdReporterKt$reportAd$1> continuation) {
        super(2, continuation);
        this.$step = i;
        this.$splash = splash;
        this.$splashId = j;
        this.$index = i2;
        this.$splashRequestId = str;
        this.$openEvent = i3;
        this.$isRealShow = z;
        this.$reason = splashOrderFilterReason;
        this.$adCb = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdReporterKt$reportAd$1(this.$step, this.$splash, this.$splashId, this.$index, this.$splashRequestId, this.$openEvent, this.$isRealShow, this.$reason, this.$adCb, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                SplashAdHelper.reportSplashOrderSelectFilterEvent(this.$step, this.$splash, this.$splashId, this.$index, this.$splashRequestId, this.$openEvent, this.$isRealShow, this.$reason, this.$adCb);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}