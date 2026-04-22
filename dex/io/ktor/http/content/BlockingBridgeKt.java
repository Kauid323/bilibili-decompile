package io.ktor.http.content;

import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: BlockingBridge.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a.\u0010\u0005\u001a\u00020\u00022\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0000H\u0080@¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t\u001a.\u0010\n\u001a\u00020\u00022\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0000H\u0082@¢\u0006\u0004\b\n\u0010\u0006\"\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "block", "withBlocking", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "safeToRunInPlace", "()Z", "withBlockingAndRedispatch", "Ljava/lang/reflect/Method;", "isParkingAllowedFunction$delegate", "Lkotlin/Lazy;", "isParkingAllowedFunction", "()Ljava/lang/reflect/Method;", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BlockingBridgeKt {
    private static final Lazy isParkingAllowedFunction$delegate = LazyKt.lazy(new Function0() { // from class: io.ktor.http.content.BlockingBridgeKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            Method isParkingAllowedFunction_delegate$lambda$0;
            isParkingAllowedFunction_delegate$lambda$0 = BlockingBridgeKt.isParkingAllowedFunction_delegate$lambda$0();
            return isParkingAllowedFunction_delegate$lambda$0;
        }
    });

    private static final Method isParkingAllowedFunction() {
        return (Method) isParkingAllowedFunction$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Method isParkingAllowedFunction_delegate$lambda$0() {
        try {
            return Class.forName("io.ktor.utils.io.jvm.javaio.PollersKt").getMethod("isParkingAllowed", new Class[0]);
        } catch (Throwable th) {
            return null;
        }
    }

    public static final Object withBlocking(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        if (safeToRunInPlace()) {
            Object invoke = function1.invoke(continuation);
            return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
        }
        Object withBlockingAndRedispatch = withBlockingAndRedispatch(function1, continuation);
        return withBlockingAndRedispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withBlockingAndRedispatch : Unit.INSTANCE;
    }

    private static final boolean safeToRunInPlace() {
        boolean z;
        Method isParkingAllowed = isParkingAllowedFunction();
        if (isParkingAllowed == null) {
            return false;
        }
        try {
            z = Intrinsics.areEqual(isParkingAllowed.invoke(null, new Object[0]), true);
        } catch (Throwable th) {
            z = false;
        }
        if (!z) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object withBlockingAndRedispatch(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new BlockingBridgeKt$withBlockingAndRedispatch$2(function1, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}