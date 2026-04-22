package tv.danmaku.bili.ui.splash.ad.page;

import android.view.ViewGroup;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import com.bilibili.lib.homepage.splash.model.SplashState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.splash.ad.player.SplashBannerPlayer;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BannerSplash.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.ad.page.BannerSplash$doShare$1", f = "BannerSplash.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BannerSplash$doShare$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BannerSplash this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerSplash$doShare$1(BannerSplash bannerSplash, Continuation<? super BannerSplash$doShare$1> continuation) {
        super(2, continuation);
        this.this$0 = bannerSplash;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BannerSplash$doShare$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
        r0 = r5.this$0.bannerPlayer;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Flow state;
        Object $result2;
        SplashBannerPlayer splashBannerPlayer;
        SplashBannerPlayer splashBannerPlayer2;
        ViewGroup container;
        ViewGroup container2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                SplashViewModel splashViewModel = this.this$0.mSplashViewModel;
                if (splashViewModel != null && (state = splashViewModel.getState()) != null) {
                    this.label = 1;
                    Object first = FlowKt.first(state, new AnonymousClass1(null), (Continuation) this);
                    if (first == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = $result;
                    $result = first;
                    SplashState splashState = (SplashState) $result;
                    break;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                SplashState splashState2 = (SplashState) $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        BLog.i("[Splash]BannerSplash", "pegasus banner render start");
        splashBannerPlayer = this.this$0.bannerPlayer;
        if (splashBannerPlayer == null || (container2 = splashBannerPlayer.getContainer()) == null || !container2.isLaidOut()) {
            z = false;
        }
        if (z && splashBannerPlayer2 != null && (container = splashBannerPlayer2.getContainer()) != null) {
            container.setVisibility(4);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BannerSplash.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/bilibili/lib/homepage/splash/model/SplashState;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.bili.ui.splash.ad.page.BannerSplash$doShare$1$1", f = "BannerSplash.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.splash.ad.page.BannerSplash$doShare$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<SplashState, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(SplashState splashState, Continuation<? super Boolean> continuation) {
            return create(splashState, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    SplashState it = (SplashState) this.L$0;
                    return Boxing.boxBoolean(Intrinsics.areEqual(it.getTopViewShareRenderStart(), Boxing.boxBoolean(true)));
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}