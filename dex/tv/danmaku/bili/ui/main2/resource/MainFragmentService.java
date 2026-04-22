package tv.danmaku.bili.ui.main2.resource;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.resource.MainResourceManager;

/* compiled from: MainFragmentOperator.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/main2/resource/MainFragmentService;", "", "<init>", "()V", "mOperator", "Ltv/danmaku/bili/ui/main2/resource/MainFragmentOperator;", "setOperator", "", "op", "owner", "Landroidx/lifecycle/LifecycleOwner;", "fetchMainResourceInBackground", "Ltv/danmaku/bili/ui/main2/resource/MainResourceManager$TabResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forceUpdateBottomNav", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MainFragmentService {
    private static MainFragmentOperator mOperator;
    public static final MainFragmentService INSTANCE = new MainFragmentService();
    public static final int $stable = 8;

    private MainFragmentService() {
    }

    public final void setOperator(MainFragmentOperator op, final LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(op, "op");
        Intrinsics.checkNotNullParameter(owner, "owner");
        mOperator = op;
        owner.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: tv.danmaku.bili.ui.main2.resource.MainFragmentService$setOperator$1
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                if (event == Lifecycle.Event.ON_DESTROY) {
                    MainFragmentService mainFragmentService = MainFragmentService.INSTANCE;
                    MainFragmentService.mOperator = null;
                    owner.getLifecycle().removeObserver((LifecycleObserver) this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchMainResourceInBackground(Continuation<? super MainResourceManager.TabResponse> continuation) {
        Continuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final Continuation it = safeContinuation;
        MainResourceManager.getInstance().fetchInBackGround(false, null, new MainResourceManager.ShowTabApiListener() { // from class: tv.danmaku.bili.ui.main2.resource.MainFragmentService$fetchMainResourceInBackground$2$1
            @Override // tv.danmaku.bili.ui.main2.resource.MainResourceManager.ShowTabApiListener
            public void onSuccessSaveToDisk(MainResourceManager.TabResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
                Continuation<MainResourceManager.TabResponse> continuation2 = it;
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.constructor-impl(response));
            }

            @Override // tv.danmaku.bili.ui.main2.resource.MainResourceManager.ShowTabApiListener
            public void onNothingToSave() {
                Continuation<MainResourceManager.TabResponse> continuation2 = it;
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("An exception occurred, the request failed, or the data was invalid "))));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object forceUpdateBottomNav(Continuation<? super Unit> continuation) {
        MainFragmentService$forceUpdateBottomNav$1 mainFragmentService$forceUpdateBottomNav$1;
        MainFragmentOperator mainFragmentOperator;
        HomeTabServiceImpl homeTabServiceImpl;
        if (continuation instanceof MainFragmentService$forceUpdateBottomNav$1) {
            mainFragmentService$forceUpdateBottomNav$1 = (MainFragmentService$forceUpdateBottomNav$1) continuation;
            if ((mainFragmentService$forceUpdateBottomNav$1.label & Integer.MIN_VALUE) != 0) {
                mainFragmentService$forceUpdateBottomNav$1.label -= Integer.MIN_VALUE;
                Object $result = mainFragmentService$forceUpdateBottomNav$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (mainFragmentService$forceUpdateBottomNav$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        mainFragmentService$forceUpdateBottomNav$1.label = 1;
                        if (fetchMainResourceInBackground(mainFragmentService$forceUpdateBottomNav$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mainFragmentOperator = mOperator;
                if (mainFragmentOperator != null) {
                    mainFragmentOperator.updateBottomNavFromCache();
                }
                homeTabServiceImpl = HomeTabServiceImplKt.getHomeTabServiceImpl();
                if (homeTabServiceImpl != null) {
                    homeTabServiceImpl.updateTabsFromCache();
                }
                return Unit.INSTANCE;
            }
        }
        mainFragmentService$forceUpdateBottomNav$1 = new MainFragmentService$forceUpdateBottomNav$1(this, continuation);
        Object $result2 = mainFragmentService$forceUpdateBottomNav$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (mainFragmentService$forceUpdateBottomNav$1.label) {
        }
        mainFragmentOperator = mOperator;
        if (mainFragmentOperator != null) {
        }
        homeTabServiceImpl = HomeTabServiceImplKt.getHomeTabServiceImpl();
        if (homeTabServiceImpl != null) {
        }
        return Unit.INSTANCE;
    }

    public final void forceUpdateBottomNav(Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        BuildersKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), (CoroutineContext) null, (CoroutineStart) null, new MainFragmentService$forceUpdateBottomNav$2(null), 3, (Object) null);
    }
}