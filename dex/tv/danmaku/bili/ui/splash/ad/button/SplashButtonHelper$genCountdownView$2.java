package tv.danmaku.bili.ui.splash.ad.button;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
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
import tv.danmaku.bili.ui.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.ui.splash.ad.page.BaseSplash;
import tv.danmaku.bili.ui.splash.utils.CountdownUtilKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: SplashButtonHelper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelper$genCountdownView$2", f = "SplashButtonHelper.kt", i = {}, l = {616}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class SplashButtonHelper$genCountdownView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BaseSplash $baseSplash;
    final /* synthetic */ SplashGuideButton $buttonData;
    final /* synthetic */ View $contentView;
    final /* synthetic */ Context $context;
    final /* synthetic */ TextView $countdownView;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashButtonHelper$genCountdownView$2(BaseSplash baseSplash, View view2, TextView textView, Context context, SplashGuideButton splashGuideButton, Continuation<? super SplashButtonHelper$genCountdownView$2> continuation) {
        super(2, continuation);
        this.$baseSplash = baseSplash;
        this.$contentView = view2;
        this.$countdownView = textView;
        this.$context = context;
        this.$buttonData = splashGuideButton;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashButtonHelper$genCountdownView$2(this.$baseSplash, this.$contentView, this.$countdownView, this.$context, this.$buttonData, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        SplashButtonHelper$genCountdownView$2 splashButtonHelper$genCountdownView$2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                splashButtonHelper$genCountdownView$2 = this;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                splashButtonHelper$genCountdownView$2 = this;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (ListExtentionsKt.isViewAlive(splashButtonHelper$genCountdownView$2.$baseSplash)) {
            View $this$isVisible$iv = splashButtonHelper$genCountdownView$2.$contentView;
            View $this$isVisible$iv2 = $this$isVisible$iv.getVisibility() == 0 ? 1 : null;
            if ($this$isVisible$iv2 != null) {
                splashButtonHelper$genCountdownView$2.$countdownView.setText(CountdownUtilKt.getCountdownText(splashButtonHelper$genCountdownView$2.$context, splashButtonHelper$genCountdownView$2.$buttonData.getActivityTime(), splashButtonHelper$genCountdownView$2.$buttonData.getTimeShowType()));
                long timeDiff = (System.currentTimeMillis() / ((long) IjkMediaCodecInfo.RANK_MAX)) - splashButtonHelper$genCountdownView$2.$buttonData.getActivityTime();
                if (timeDiff >= 0) {
                    splashButtonHelper$genCountdownView$2.$contentView.setVisibility(8);
                }
                splashButtonHelper$genCountdownView$2.label = 1;
                if (DelayKt.delay(100L, (Continuation) splashButtonHelper$genCountdownView$2) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }
}