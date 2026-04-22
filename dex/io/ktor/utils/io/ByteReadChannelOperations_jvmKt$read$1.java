package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteReadChannelOperations.jvm.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PropertyIDConstants.GridRowSpan)
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperations_jvmKt", f = "ByteReadChannelOperations.jvm.kt", i = {0, 0, 0}, l = {PropertyIDConstants.GridRowGap}, m = "read", n = {"$this$read", "consumer", "min"}, s = {"L$0", "L$1", "I$0"})
public final class ByteReadChannelOperations_jvmKt$read$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteReadChannelOperations_jvmKt$read$1(Continuation<? super ByteReadChannelOperations_jvmKt$read$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LynxAccessibilityDelegate.INVALID_NODE_ID;
        return ByteReadChannelOperations_jvmKt.read(null, 0, null, (Continuation) this);
    }
}