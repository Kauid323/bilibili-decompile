package tv.danmaku.bili.ui.splash.event;

import android.content.Context;
import android.content.res.Resources;
import bili.resource.common.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import tv.danmaku.bili.ui.splash.databinding.SplashFragmentEventSplashBinding;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EventSplashFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.event.EventSplashFragment$startCountDown$runnable$1$1", f = "EventSplashFragment.kt", i = {0, 0, 1, 1}, l = {399, 401}, m = "invokeSuspend", n = {"$this$launch", "existTime", "$this$launch", "existTime"}, s = {"L$0", "I$0", "L$0", "I$0"}, v = 1)
public final class EventSplashFragment$startCountDown$runnable$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $duration;
    final /* synthetic */ boolean $showCountDown;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EventSplashFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventSplashFragment$startCountDown$runnable$1$1(int i, EventSplashFragment eventSplashFragment, boolean z, Continuation<? super EventSplashFragment$startCountDown$runnable$1$1> continuation) {
        super(2, continuation);
        this.$duration = i;
        this.this$0 = eventSplashFragment;
        this.$showCountDown = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> eventSplashFragment$startCountDown$runnable$1$1 = new EventSplashFragment$startCountDown$runnable$1$1(this.$duration, this.this$0, this.$showCountDown, continuation);
        eventSplashFragment$startCountDown$runnable$1$1.L$0 = obj;
        return eventSplashFragment$startCountDown$runnable$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0090 -> B:29:0x00a7). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00a3 -> B:29:0x00a7). Please submit an issue!!! */
    public final Object invokeSuspend(Object $result) {
        EventSplashFragment$startCountDown$runnable$1$1 eventSplashFragment$startCountDown$runnable$1$1;
        CoroutineScope $this$launch;
        int existTime;
        EventSplashData eventSplashData;
        boolean z;
        Resources res;
        SplashFragmentEventSplashBinding mBinding;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineScope $this$launch2 = (CoroutineScope) this.L$0;
                eventSplashFragment$startCountDown$runnable$1$1 = this;
                $this$launch = $this$launch2;
                existTime = this.$duration;
                break;
            case 1:
                existTime = this.I$0;
                $this$launch = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure($result);
                eventSplashFragment$startCountDown$runnable$1$1 = this;
                existTime -= IjkMediaCodecInfo.RANK_MAX;
                break;
            case 2:
                existTime = this.I$0;
                $this$launch = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure($result);
                eventSplashFragment$startCountDown$runnable$1$1 = this;
                existTime -= IjkMediaCodecInfo.RANK_MAX;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (existTime > 0 || !CoroutineScopeKt.isActive($this$launch)) {
            eventSplashFragment$startCountDown$runnable$1$1.this$0.exit();
            eventSplashData = eventSplashFragment$startCountDown$runnable$1$1.this$0.mSplashData;
            z = eventSplashFragment$startCountDown$runnable$1$1.this$0.isActionTrigger;
            ReporterKt.reportCountDownExit(eventSplashData, z);
            return Unit.INSTANCE;
        }
        Context context = eventSplashFragment$startCountDown$runnable$1$1.this$0.getContext();
        if (context == null || (res = context.getResources()) == null) {
            return Unit.INSTANCE;
        }
        if (eventSplashFragment$startCountDown$runnable$1$1.$showCountDown) {
            mBinding = eventSplashFragment$startCountDown$runnable$1$1.this$0.getMBinding();
            mBinding.skip.setText(res.getString(R.string.common_global_string_144) + " " + (existTime / IjkMediaCodecInfo.RANK_MAX));
        }
        if (existTime > 1000) {
            eventSplashFragment$startCountDown$runnable$1$1.L$0 = $this$launch;
            eventSplashFragment$startCountDown$runnable$1$1.I$0 = existTime;
            eventSplashFragment$startCountDown$runnable$1$1.label = 1;
            if (DelayKt.delay(1000L, (Continuation) eventSplashFragment$startCountDown$runnable$1$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            eventSplashFragment$startCountDown$runnable$1$1.L$0 = $this$launch;
            eventSplashFragment$startCountDown$runnable$1$1.I$0 = existTime;
            eventSplashFragment$startCountDown$runnable$1$1.label = 2;
            if (DelayKt.delay(existTime, (Continuation) eventSplashFragment$startCountDown$runnable$1$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        existTime -= IjkMediaCodecInfo.RANK_MAX;
        if (existTime > 0) {
        }
        eventSplashFragment$startCountDown$runnable$1$1.this$0.exit();
        eventSplashData = eventSplashFragment$startCountDown$runnable$1$1.this$0.mSplashData;
        z = eventSplashFragment$startCountDown$runnable$1$1.this$0.isActionTrigger;
        ReporterKt.reportCountDownExit(eventSplashData, z);
        return Unit.INSTANCE;
    }
}