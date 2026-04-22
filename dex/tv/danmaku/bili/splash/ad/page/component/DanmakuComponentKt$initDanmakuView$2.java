package tv.danmaku.bili.splash.ad.page.component;

import com.bilibili.lib.homepage.splash.actions.SplashStateUpdateAction;
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
import tv.danmaku.bili.splash.ad.page.BaseSplash;
import tv.danmaku.bili.splash.ad.state.actions.DoSplashLinkageAnimationAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DanmakuComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.page.component.DanmakuComponentKt$initDanmakuView$2", f = "DanmakuComponent.kt", i = {}, l = {BR.backgroundTranslucentEnable}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DanmakuComponentKt$initDanmakuView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<LandDanmakuView> $danmakuView;
    final /* synthetic */ BaseSplash $this_initDanmakuView;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanmakuComponentKt$initDanmakuView$2(BaseSplash baseSplash, Ref.ObjectRef<LandDanmakuView> objectRef, Continuation<? super DanmakuComponentKt$initDanmakuView$2> continuation) {
        super(2, continuation);
        this.$this_initDanmakuView = baseSplash;
        this.$danmakuView = objectRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DanmakuComponentKt$initDanmakuView$2(this.$this_initDanmakuView, this.$danmakuView, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DanmakuComponent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/bilibili/lib/homepage/splash/actions/SplashStateUpdateAction;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.splash.ad.page.component.DanmakuComponentKt$initDanmakuView$2$1", f = "DanmakuComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.splash.ad.page.component.DanmakuComponentKt$initDanmakuView$2$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<SplashStateUpdateAction, Continuation<? super Boolean>, Object> {
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

        public final Object invoke(SplashStateUpdateAction splashStateUpdateAction, Continuation<? super Boolean> continuation) {
            return create(splashStateUpdateAction, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    SplashStateUpdateAction it = (SplashStateUpdateAction) this.L$0;
                    return Boxing.boxBoolean(it instanceof DoSplashLinkageAnimationAction);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (FlowKt.first(this.$this_initDanmakuView.getViewModel$adsplash_debug().getActionFlow(), new AnonymousClass1(null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LandDanmakuView landDanmakuView = (LandDanmakuView) this.$danmakuView.element;
        if (landDanmakuView != null) {
            landDanmakuView.setVisibility(8);
        }
        return Unit.INSTANCE;
    }
}