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
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0}, l = {341}, m = "discardExact", n = {"value"}, s = {"J$0"})
public final class ByteReadChannelOperationsKt$discardExact$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteReadChannelOperationsKt$discardExact$1(Continuation<? super ByteReadChannelOperationsKt$discardExact$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LynxAccessibilityDelegate.INVALID_NODE_ID;
        return ByteReadChannelOperationsKt.discardExact(null, 0L, (Continuation) this);
    }
}