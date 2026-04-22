package tv.danmaku.bili.splash.ad.page.component;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OneShotPreDrawListener;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.anim.LandDanmakuView;
import tv.danmaku.bili.splash.ad.model.SplashDanmakuKt;
import tv.danmaku.bili.splash.ad.page.BaseSplash;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DanmakuComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.page.component.DanmakuComponentKt$initDanmakuView$1", f = "DanmakuComponent.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DanmakuComponentKt$initDanmakuView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<LandDanmakuView> $danmakuView;
    final /* synthetic */ BaseSplash $this_initDanmakuView;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanmakuComponentKt$initDanmakuView$1(BaseSplash baseSplash, Ref.ObjectRef<LandDanmakuView> objectRef, Continuation<? super DanmakuComponentKt$initDanmakuView$1> continuation) {
        super(2, continuation);
        this.$this_initDanmakuView = baseSplash;
        this.$danmakuView = objectRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DanmakuComponentKt$initDanmakuView$1(this.$this_initDanmakuView, this.$danmakuView, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DanmakuComponent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/bilibili/lib/homepage/splash/model/SplashState;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.splash.ad.page.component.DanmakuComponentKt$initDanmakuView$1$1", f = "DanmakuComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.splash.ad.page.component.DanmakuComponentKt$initDanmakuView$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
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
                    return Boxing.boxBoolean(it.isSplashRealReady() && it.getExpectBannerRect() != null);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Context activity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (FlowKt.first(this.$this_initDanmakuView.getViewModel$adsplash_debug().getState(), new AnonymousClass1(null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Rect rect = ((SplashState) this.$this_initDanmakuView.getViewModel$adsplash_debug().getState().getValue()).getExpectBannerRect();
        if (rect != null && (activity = this.$this_initDanmakuView.getActivity()) != null) {
            Ref.ObjectRef<LandDanmakuView> objectRef = this.$danmakuView;
            final LandDanmakuView $this$invokeSuspend_u24lambda_u240 = new LandDanmakuView(activity, null, 0, 0, 14, null);
            final BaseSplash baseSplash = this.$this_initDanmakuView;
            $this$invokeSuspend_u24lambda_u240.setLayoutParams(new ViewGroup.LayoutParams(rect.width(), rect.height()));
            $this$invokeSuspend_u24lambda_u240.setX(rect.left);
            $this$invokeSuspend_u24lambda_u240.setY(rect.top);
            final LandDanmakuView $this$doOnPreDraw$iv = $this$invokeSuspend_u24lambda_u240;
            OneShotPreDrawListener.add($this$doOnPreDraw$iv, new Runnable() { // from class: tv.danmaku.bili.splash.ad.page.component.DanmakuComponentKt$initDanmakuView$1$invokeSuspend$lambda$0$$inlined$doOnPreDraw$1
                @Override // java.lang.Runnable
                public final void run() {
                    View it = $this$doOnPreDraw$iv;
                    $this$invokeSuspend_u24lambda_u240.update(SplashDanmakuKt.toDanmakuData(baseSplash.getSplash$adsplash_debug().getDanmukus(), it.getWidth(), it.getHeight()));
                }
            });
            baseSplash.getBinding$adsplash_debug().getRoot().addView($this$invokeSuspend_u24lambda_u240);
            objectRef.element = $this$invokeSuspend_u24lambda_u240;
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}