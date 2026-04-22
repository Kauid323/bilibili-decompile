package tv.danmaku.bili.ui.main2.resource;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: HomeTabServiceImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.resource.HomeTabServiceImpl$tryUpdateHomeTab$1", f = "HomeTabServiceImpl.kt", i = {0}, l = {BR.height}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"}, v = 1)
final class HomeTabServiceImpl$tryUpdateHomeTab$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ HomeTabServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeTabServiceImpl$tryUpdateHomeTab$1(HomeTabServiceImpl homeTabServiceImpl, Continuation<? super HomeTabServiceImpl$tryUpdateHomeTab$1> continuation) {
        super(2, continuation);
        this.this$0 = homeTabServiceImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeTabServiceImpl$tryUpdateHomeTab$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Mutex $this$withLock_u24default$iv;
        HomeTabServiceImpl homeTabServiceImpl;
        Object owner$iv;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$withLock_u24default$iv = this.this$0.lock;
                homeTabServiceImpl = this.this$0;
                owner$iv = null;
                this.L$0 = $this$withLock_u24default$iv;
                this.L$1 = homeTabServiceImpl;
                this.label = 1;
                if ($this$withLock_u24default$iv.lock((Object) null, (Continuation) this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                homeTabServiceImpl = (HomeTabServiceImpl) this.L$1;
                owner$iv = null;
                $this$withLock_u24default$iv = (Mutex) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            try {
                homeTabServiceImpl.updateTabsFromCache();
            } catch (Exception e) {
                BLog.e("HomeTabServiceImpl", "tryUpdateHomeTab error", e);
            }
            Unit unit = Unit.INSTANCE;
            $this$withLock_u24default$iv.unlock(owner$iv);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            $this$withLock_u24default$iv.unlock(owner$iv);
            throw th;
        }
    }
}