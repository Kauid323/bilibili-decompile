package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* compiled from: LookAheadSession.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a=\u0010\b\u001a\u00020\u0004*\u00020\u00002'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006H\u0086@¢\u0006\u0004\b\b\u0010\t\u001a=\u0010\n\u001a\u00020\u0004*\u00020\u00002'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006H\u0086@¢\u0006\u0004\b\n\u0010\t*\n\u0010\u000b\"\u00020\u00022\u00020\u0002¨\u0006\f"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Lkotlin/Function2;", "Lio/ktor/utils/io/LookAheadSuspendSession;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "block", "lookAhead", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lookAheadSuspend", "LookAheadSession", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class LookAheadSessionKt {
    public static final Object lookAhead(ByteReadChannel $this$lookAhead, Function2<? super LookAheadSuspendSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object invoke = function2.invoke(new LookAheadSuspendSession($this$lookAhead), continuation);
        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }

    public static final Object lookAheadSuspend(ByteReadChannel $this$lookAheadSuspend, Function2<? super LookAheadSuspendSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object invoke = function2.invoke(new LookAheadSuspendSession($this$lookAheadSuspend), continuation);
        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }
}