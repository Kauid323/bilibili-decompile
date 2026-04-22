package tv.danmaku.bili.ui.splash.ad.landingpage;

import android.media.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.ad.player.SplashMediaPlayerManager;
import tv.danmaku.bili.ui.splash.databinding.BiliAppListSplashImmersiveVideoLandingActivityV2Binding;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkCpuInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashImmersiveVideoLandingActivityV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.ad.landingpage.SplashImmersiveVideoLandingActivityV2$initView$1$1", f = "SplashImmersiveVideoLandingActivityV2.kt", i = {}, l = {IjkCpuInfo.CPU_IMPL_MARVELL}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SplashImmersiveVideoLandingActivityV2$initView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SplashImmersiveVideoLandingActivityV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashImmersiveVideoLandingActivityV2$initView$1$1(SplashImmersiveVideoLandingActivityV2 splashImmersiveVideoLandingActivityV2, Continuation<? super SplashImmersiveVideoLandingActivityV2$initView$1$1> continuation) {
        super(2, continuation);
        this.this$0 = splashImmersiveVideoLandingActivityV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashImmersiveVideoLandingActivityV2$initView$1$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SplashImmersiveVideoLandingActivityV2.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "open", ""}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.bili.ui.splash.ad.landingpage.SplashImmersiveVideoLandingActivityV2$initView$1$1$1", f = "SplashImmersiveVideoLandingActivityV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.splash.ad.landingpage.SplashImmersiveVideoLandingActivityV2$initView$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ SplashImmersiveVideoLandingActivityV2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SplashImmersiveVideoLandingActivityV2 splashImmersiveVideoLandingActivityV2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = splashImmersiveVideoLandingActivityV2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.Z$0 = ((Boolean) obj).booleanValue();
            return anonymousClass1;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
        }

        public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
            return create(Boolean.valueOf(z), continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            BiliAppListSplashImmersiveVideoLandingActivityV2Binding biliAppListSplashImmersiveVideoLandingActivityV2Binding;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    boolean open = this.Z$0;
                    float volume = open ? 1.0f : DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
                    biliAppListSplashImmersiveVideoLandingActivityV2Binding = this.this$0.binding;
                    if (biliAppListSplashImmersiveVideoLandingActivityV2Binding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        biliAppListSplashImmersiveVideoLandingActivityV2Binding = null;
                    }
                    biliAppListSplashImmersiveVideoLandingActivityV2Binding.muteBtn.setImageResource(open ? R.drawable.speaker_sound_on_line_24 : R.drawable.speaker_sound_off_line_24);
                    MediaPlayer player = SplashMediaPlayerManager.INSTANCE.getPlayer();
                    if (player != null) {
                        player.setVolume(volume, volume);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Flow flow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                flow = this.this$0.openSoundState;
                this.label = 1;
                if (FlowKt.collectLatest(flow, new AnonymousClass1(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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