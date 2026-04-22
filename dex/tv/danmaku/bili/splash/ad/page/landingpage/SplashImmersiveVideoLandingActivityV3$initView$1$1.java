package tv.danmaku.bili.splash.ad.page.landingpage;

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
import tv.danmaku.bili.BR;
import tv.danmaku.bili.adsplash.R;
import tv.danmaku.bili.adsplash.databinding.BiliAppListSplashImmersiveVideoLandingActivityV3Binding;
import tv.danmaku.bili.splash.ad.player.SplashMediaPlayerManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashImmersiveVideoLandingActivityV3.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.page.landingpage.SplashImmersiveVideoLandingActivityV3$initView$1$1", f = "SplashImmersiveVideoLandingActivityV3.kt", i = {}, l = {BR.card}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SplashImmersiveVideoLandingActivityV3$initView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SplashImmersiveVideoLandingActivityV3 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashImmersiveVideoLandingActivityV3$initView$1$1(SplashImmersiveVideoLandingActivityV3 splashImmersiveVideoLandingActivityV3, Continuation<? super SplashImmersiveVideoLandingActivityV3$initView$1$1> continuation) {
        super(2, continuation);
        this.this$0 = splashImmersiveVideoLandingActivityV3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashImmersiveVideoLandingActivityV3$initView$1$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SplashImmersiveVideoLandingActivityV3.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "open", ""}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.splash.ad.page.landingpage.SplashImmersiveVideoLandingActivityV3$initView$1$1$1", f = "SplashImmersiveVideoLandingActivityV3.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.splash.ad.page.landingpage.SplashImmersiveVideoLandingActivityV3$initView$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ SplashImmersiveVideoLandingActivityV3 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SplashImmersiveVideoLandingActivityV3 splashImmersiveVideoLandingActivityV3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = splashImmersiveVideoLandingActivityV3;
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
            BiliAppListSplashImmersiveVideoLandingActivityV3Binding biliAppListSplashImmersiveVideoLandingActivityV3Binding;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    boolean open = this.Z$0;
                    float volume = open ? 1.0f : 0.0f;
                    biliAppListSplashImmersiveVideoLandingActivityV3Binding = this.this$0.binding;
                    if (biliAppListSplashImmersiveVideoLandingActivityV3Binding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        biliAppListSplashImmersiveVideoLandingActivityV3Binding = null;
                    }
                    biliAppListSplashImmersiveVideoLandingActivityV3Binding.muteBtn.setImageResource(open ? R.drawable.speaker_sound_on_line_24 : R.drawable.speaker_sound_off_line_24);
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