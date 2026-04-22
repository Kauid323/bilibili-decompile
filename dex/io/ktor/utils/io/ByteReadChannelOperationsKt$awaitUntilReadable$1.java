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
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 1, 1}, l = {73, 74}, m = "awaitUntilReadable", n = {"$this$awaitUntilReadable", "numberOfBytes", "$this$awaitUntilReadable", "numberOfBytes"}, s = {"L$0", "I$0", "L$0", "I$0"})
public final class ByteReadChannelOperationsKt$awaitUntilReadable$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteReadChannelOperationsKt$awaitUntilReadable$1(Continuation<? super ByteReadChannelOperationsKt$awaitUntilReadable$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object awaitUntilReadable;
        this.result = obj;
        this.label |= LynxAccessibilityDelegate.INVALID_NODE_ID;
        awaitUntilReadable = ByteReadChannelOperationsKt.awaitUntilReadable(null, 0, (Continuation) this);
        return awaitUntilReadable;
    }
}