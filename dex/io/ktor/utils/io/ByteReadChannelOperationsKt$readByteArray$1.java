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
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0, 0}, l = {PropertyIDConstants.LinearDirection}, m = "readByteArray", n = {"$this$readByteArray", "builder$iv", "$this$readByteArray_u24lambda_u242", "count"}, s = {"L$0", "L$1", "L$2", "I$0"})
public final class ByteReadChannelOperationsKt$readByteArray$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteReadChannelOperationsKt$readByteArray$1(Continuation<? super ByteReadChannelOperationsKt$readByteArray$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LynxAccessibilityDelegate.INVALID_NODE_ID;
        return ByteReadChannelOperationsKt.readByteArray(null, 0, (Continuation) this);
    }
}