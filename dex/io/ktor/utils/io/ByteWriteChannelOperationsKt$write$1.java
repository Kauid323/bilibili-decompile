package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteWriteChannelOperations.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
@DebugMetadata(c = "io.ktor.utils.io.ByteWriteChannelOperationsKt", f = "ByteWriteChannelOperations.kt", i = {0}, l = {PropertyIDConstants.GridAutoFlow}, m = "write", n = {"written"}, s = {"I$0"})
public final class ByteWriteChannelOperationsKt$write$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteWriteChannelOperationsKt$write$1(Continuation<? super ByteWriteChannelOperationsKt$write$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LynxAccessibilityDelegate.INVALID_NODE_ID;
        return ByteWriteChannelOperationsKt.write(null, 0, null, (Continuation) this);
    }
}