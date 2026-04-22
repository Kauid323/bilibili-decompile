package tv.danmaku.bili.components;

import androidx.lifecycle.Observer;
import com.bilibili.app.comm.list.common.feed.PegasusProblemReporter;
import com.bilibili.lib.homepage.home.model.HomeState;
import com.bilibili.lib.homepage.home.model.StatusBarEvent;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.MainActivityV2;
import tv.danmaku.bili.core.test.FdDebugActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeStatusBarComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.components.HomeStatusBarComponentKt$observerStatusBarStatus$3", f = "HomeStatusBarComponent.kt", i = {}, l = {BR.bottomDisplay4, BR.bottomText}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HomeStatusBarComponentKt$observerStatusBarStatus$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MainActivityV2 $lifeCycleOwner;
    final /* synthetic */ Ref.ObjectRef<String> $pathLog;
    final /* synthetic */ MainActivityV2 $this_observerStatusBarStatus;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeStatusBarComponentKt$observerStatusBarStatus$3(MainActivityV2 mainActivityV2, Ref.ObjectRef<String> objectRef, MainActivityV2 mainActivityV22, Continuation<? super HomeStatusBarComponentKt$observerStatusBarStatus$3> continuation) {
        super(2, continuation);
        this.$this_observerStatusBarStatus = mainActivityV2;
        this.$pathLog = objectRef;
        this.$lifeCycleOwner = mainActivityV22;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeStatusBarComponentKt$observerStatusBarStatus$3(this.$this_observerStatusBarStatus, this.$pathLog, this.$lifeCycleOwner, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeStatusBarComponent.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", ""}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.components.HomeStatusBarComponentKt$observerStatusBarStatus$3$1", f = "HomeStatusBarComponent.kt", i = {}, l = {BR.bottomDisplay3}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.components.HomeStatusBarComponentKt$observerStatusBarStatus$3$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super Boolean>, Continuation<? super Unit>, Object> {
        final /* synthetic */ MainActivityV2 $lifeCycleOwner;
        final /* synthetic */ MainActivityV2 $this_observerStatusBarStatus;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MainActivityV2 mainActivityV2, MainActivityV2 mainActivityV22, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_observerStatusBarStatus = mainActivityV2;
            this.$lifeCycleOwner = mainActivityV22;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$this_observerStatusBarStatus, this.$lifeCycleOwner, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(ProducerScope<? super Boolean> producerScope, Continuation<? super Unit> continuation) {
            return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final ProducerScope $this$callbackFlow = (ProducerScope) this.L$0;
                    this.$this_observerStatusBarStatus.mSplashViewModel.getSplashExit().observe(this.$lifeCycleOwner, new Observer<SplashViewModel.SplashExitInfo>() { // from class: tv.danmaku.bili.components.HomeStatusBarComponentKt.observerStatusBarStatus.3.1.1
                        public void onChanged(SplashViewModel.SplashExitInfo value) {
                            Intrinsics.checkNotNullParameter(value, "value");
                            $this$callbackFlow.trySend-JP2dKIU(true);
                        }
                    });
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

    /* JADX WARN: Removed duplicated region for block: B:13:0x0047 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        boolean fullScreen;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (FlowKt.first(FlowKt.callbackFlow(new AnonymousClass1(this.$this_observerStatusBarStatus, this.$lifeCycleOwner, null)), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.label = 2;
                if (DelayKt.delay((long) FdDebugActivity.UPDATE_DELAY_TIME, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                fullScreen = ((HomeState) this.$this_observerStatusBarStatus.viewModel.getState().getValue()).getHomePageState().getFullScreenMode();
                BLog.i("[Home]HomeStatusBarComponent", "observerStatusBarStatus, errorPath = " + this.$pathLog.element + "， fullScreenMode = " + fullScreen);
                if (fullScreen) {
                    PegasusProblemReporter.INSTANCE.reportErrorStatusBarPath((String) this.$pathLog.element);
                }
                this.$this_observerStatusBarStatus.viewModel.update(new StatusBarEvent.ExitFullScreen("time out"));
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                this.label = 2;
                if (DelayKt.delay((long) FdDebugActivity.UPDATE_DELAY_TIME, (Continuation) this) == coroutine_suspended) {
                }
                fullScreen = ((HomeState) this.$this_observerStatusBarStatus.viewModel.getState().getValue()).getHomePageState().getFullScreenMode();
                BLog.i("[Home]HomeStatusBarComponent", "observerStatusBarStatus, errorPath = " + this.$pathLog.element + "， fullScreenMode = " + fullScreen);
                if (fullScreen) {
                }
                this.$this_observerStatusBarStatus.viewModel.update(new StatusBarEvent.ExitFullScreen("time out"));
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                fullScreen = ((HomeState) this.$this_observerStatusBarStatus.viewModel.getState().getValue()).getHomePageState().getFullScreenMode();
                BLog.i("[Home]HomeStatusBarComponent", "observerStatusBarStatus, errorPath = " + this.$pathLog.element + "， fullScreenMode = " + fullScreen);
                if (fullScreen) {
                }
                this.$this_observerStatusBarStatus.viewModel.update(new StatusBarEvent.ExitFullScreen("time out"));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}