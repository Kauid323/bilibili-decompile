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
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 4}, l = {532, 535, 545, 555, 556}, m = "readUntil", n = {"$this$readUntil", "matchString", "writeChannel", "partialMatchTable", "matchIndex", "matchBuffer", "rc", "limit", "ignoreMissing", "$this$readUntil", "matchString", "writeChannel", "partialMatchTable", "matchIndex", "matchBuffer", "rc", "limit", "ignoreMissing", "byte", "$this$readUntil", "matchString", "writeChannel", "partialMatchTable", "matchIndex", "matchBuffer", "rc", "limit", "ignoreMissing", "writeChannel", "rc", "rc"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "Z$0", "B$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "Z$0", "L$0", "L$1", "L$0"})
public final class ByteReadChannelOperationsKt$readUntil$1 extends ContinuationImpl {
    byte B$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteReadChannelOperationsKt$readUntil$1(Continuation<? super ByteReadChannelOperationsKt$readUntil$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LynxAccessibilityDelegate.INVALID_NODE_ID;
        return ByteReadChannelOperationsKt.readUntil(null, null, null, 0L, false, (Continuation) this);
    }
}