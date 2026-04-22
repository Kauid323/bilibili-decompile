package tv.danmaku.bili.splash.ad.player;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.bili.BR;
import tv.danmaku.video.bilicardplayer.player.BiliCardPlayerScene;
import tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashBannerPlayer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.player.SplashBannerPlayer$takeSnapshot$1$bm$1", f = "SplashBannerPlayer.kt", i = {}, l = {BR.coverThumbHeight}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SplashBannerPlayer$takeSnapshot$1$bm$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    int label;
    final /* synthetic */ SplashBannerPlayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashBannerPlayer$takeSnapshot$1$bm$1(SplashBannerPlayer splashBannerPlayer, Continuation<? super SplashBannerPlayer$takeSnapshot$1$bm$1> continuation) {
        super(2, continuation);
        this.this$0 = splashBannerPlayer;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashBannerPlayer$takeSnapshot$1$bm$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SplashBannerPlayer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.splash.ad.player.SplashBannerPlayer$takeSnapshot$1$bm$1$1", f = "SplashBannerPlayer.kt", i = {}, l = {BR.coverHorizontal}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.splash.ad.player.SplashBannerPlayer$takeSnapshot$1$bm$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super Bitmap>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SplashBannerPlayer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SplashBannerPlayer splashBannerPlayer, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = splashBannerPlayer;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(ProducerScope<? super Bitmap> producerScope, Continuation<? super Unit> continuation) {
            return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            BiliCardPlayerScene.CardPlayTask.Token token;
            int i;
            int i2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final ProducerScope $this$callbackFlow = (ProducerScope) this.L$0;
                    token = this.this$0.token;
                    if (token != null) {
                        i = this.this$0.SIZE_IGNORE_MODEL_CHANGE;
                        i2 = this.this$0.SIZE_IGNORE_MODEL_CHANGE;
                        token.takeVideoCapture(new IMediaPlayRenderContext.OnTakeVideoCapture() { // from class: tv.danmaku.bili.splash.ad.player.SplashBannerPlayer.takeSnapshot.1.bm.1.1.1
                            public void onResult(Bitmap capture) {
                                $this$callbackFlow.trySend-JP2dKIU(capture);
                            }
                        }, i, i2);
                    }
                    this.label = 1;
                    if (ProduceKt.awaitClose$default($this$callbackFlow, (Function0) null, (Continuation) this, 1, (Object) null) == coroutine_suspended) {
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

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object firstOrNull = FlowKt.firstOrNull(FlowKt.callbackFlow(new AnonymousClass1(this.this$0, null)), (Continuation) this);
                if (firstOrNull == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return firstOrNull;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}