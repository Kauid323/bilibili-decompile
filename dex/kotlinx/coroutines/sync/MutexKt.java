package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: Mutex.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r\u001a?\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f*\u00020\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0013H\u0086H\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"HOLDS_LOCK_ANOTHER_OWNER", "", "HOLDS_LOCK_UNLOCKED", "HOLDS_LOCK_YES", "NO_OWNER", "Lkotlinx/coroutines/internal/Symbol;", "ON_LOCK_ALREADY_LOCKED_BY_OWNER", "TRY_LOCK_ALREADY_LOCKED_BY_OWNER", "TRY_LOCK_FAILED", "TRY_LOCK_SUCCESS", "Mutex", "Lkotlinx/coroutines/sync/Mutex;", "locked", "", "withLock", "T", "owner", "", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class MutexKt {
    private static final int HOLDS_LOCK_ANOTHER_OWNER = 2;
    private static final int HOLDS_LOCK_UNLOCKED = 0;
    private static final int HOLDS_LOCK_YES = 1;
    private static final Symbol NO_OWNER = new Symbol("NO_OWNER");
    private static final Symbol ON_LOCK_ALREADY_LOCKED_BY_OWNER = new Symbol("ALREADY_LOCKED_BY_OWNER");
    private static final int TRY_LOCK_ALREADY_LOCKED_BY_OWNER = 2;
    private static final int TRY_LOCK_FAILED = 1;
    private static final int TRY_LOCK_SUCCESS = 0;

    public static /* synthetic */ Mutex Mutex$default(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return Mutex(z);
    }

    public static final Mutex Mutex(boolean locked) {
        return new MutexImpl(locked);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object withLock(Mutex $this$withLock, Object owner, Function0<? extends T> function0, Continuation<? super T> continuation) {
        MutexKt$withLock$1 mutexKt$withLock$1;
        MutexKt$withLock$1 mutexKt$withLock$12;
        Mutex $this$withLock2;
        Object owner2;
        Function0 action;
        try {
            if (continuation instanceof MutexKt$withLock$1) {
                mutexKt$withLock$1 = (MutexKt$withLock$1) continuation;
                if ((mutexKt$withLock$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                    mutexKt$withLock$1.label -= IntCompanionObject.MIN_VALUE;
                    mutexKt$withLock$12 = mutexKt$withLock$1;
                    Object $result = mutexKt$withLock$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (mutexKt$withLock$12.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            mutexKt$withLock$12.L$0 = $this$withLock;
                            mutexKt$withLock$12.L$1 = owner;
                            mutexKt$withLock$12.L$2 = function0;
                            mutexKt$withLock$12.label = 1;
                            if ($this$withLock.lock(owner, mutexKt$withLock$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$withLock2 = $this$withLock;
                            owner2 = owner;
                            action = function0;
                            break;
                        case 1:
                            action = (Function0) mutexKt$withLock$12.L$2;
                            owner2 = mutexKt$withLock$12.L$1;
                            $this$withLock2 = (Mutex) mutexKt$withLock$12.L$0;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    T invoke = action.invoke();
                    InlineMarker.finallyStart(1);
                    $this$withLock2.unlock(owner2);
                    InlineMarker.finallyEnd(1);
                    return invoke;
                }
            }
            T invoke2 = action.invoke();
            InlineMarker.finallyStart(1);
            $this$withLock2.unlock(owner2);
            InlineMarker.finallyEnd(1);
            return invoke2;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            $this$withLock2.unlock(owner2);
            InlineMarker.finallyEnd(1);
            throw th;
        }
        mutexKt$withLock$1 = new MutexKt$withLock$1(continuation);
        mutexKt$withLock$12 = mutexKt$withLock$1;
        Object $result2 = mutexKt$withLock$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (mutexKt$withLock$12.label) {
        }
    }

    public static /* synthetic */ Object withLock$default(Mutex $this$withLock_u24default, Object owner, Function0 action, Continuation $completion, int i, Object obj) {
        if ((i & 1) != 0) {
            owner = null;
        }
        InlineMarker.mark(0);
        $this$withLock_u24default.lock(owner, $completion);
        InlineMarker.mark(1);
        try {
            return action.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            $this$withLock_u24default.unlock(owner);
            InlineMarker.finallyEnd(1);
        }
    }

    private static final <T> Object withLock$$forInline(Mutex $this$withLock, Object owner, Function0<? extends T> function0, Continuation<? super T> continuation) {
        InlineMarker.mark(0);
        $this$withLock.lock(owner, continuation);
        InlineMarker.mark(1);
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            $this$withLock.unlock(owner);
            InlineMarker.finallyEnd(1);
        }
    }
}