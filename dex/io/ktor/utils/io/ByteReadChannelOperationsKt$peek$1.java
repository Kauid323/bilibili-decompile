package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteReadChannelOperations.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0}, l = {611}, m = "peek", n = {"$this$peek", "count"}, s = {"L$0", "I$0"})
public final class ByteReadChannelOperationsKt$peek$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteReadChannelOperationsKt$peek$1(Continuation<? super ByteReadChannelOperationsKt$peek$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LynxAccessibilityDelegate.INVALID_NODE_ID;
        return ByteReadChannelOperationsKt.peek(null, 0, (Continuation) this);
    }
}