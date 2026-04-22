package tv.danmaku.bili;

import com.bilibili.lib.homepage.home.model.StatusBarEvent;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import com.bilibili.lib.homepage.splash.actions.PreDisplayStatusBarAction;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivitySplashComponentExt.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.MainActivitySplashComponentExtKt$registerSplashObserver$1", f = "MainActivitySplashComponentExt.kt", i = {}, l = {BR.leftBadgeText}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class MainActivitySplashComponentExtKt$registerSplashObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MainActivityV2 $this_registerSplashObserver;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivitySplashComponentExtKt$registerSplashObserver$1(MainActivityV2 mainActivityV2, Continuation<? super MainActivitySplashComponentExtKt$registerSplashObserver$1> continuation) {
        super(2, continuation);
        this.$this_registerSplashObserver = mainActivityV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivitySplashComponentExtKt$registerSplashObserver$1(this.$this_registerSplashObserver, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainActivitySplashComponentExt.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/bilibili/lib/homepage/splash/actions/SplashStateUpdateAction;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.MainActivitySplashComponentExtKt$registerSplashObserver$1$1", f = "MainActivitySplashComponentExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.MainActivitySplashComponentExtKt$registerSplashObserver$1$1  reason: invalid class name */
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
                    return Boxing.boxBoolean(it instanceof PreDisplayStatusBarAction);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Flow actionFlow;
        Object $result2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                SplashViewModel splashViewModel = this.$this_registerSplashObserver.mSplashViewModel;
                if (splashViewModel != null && (actionFlow = splashViewModel.getActionFlow()) != null) {
                    this.label = 1;
                    Object first = FlowKt.first(actionFlow, new AnonymousClass1(null), (Continuation) this);
                    if (first == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = $result;
                    $result = first;
                    SplashStateUpdateAction splashStateUpdateAction = (SplashStateUpdateAction) $result;
                    break;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                SplashStateUpdateAction splashStateUpdateAction2 = (SplashStateUpdateAction) $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$this_registerSplashObserver.viewModel.update(new StatusBarEvent.ExitFullScreen("preDisplaySplash"));
        return Unit.INSTANCE;
    }
}