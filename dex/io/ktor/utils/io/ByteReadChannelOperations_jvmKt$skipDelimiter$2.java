package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.io.bytestring.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteReadChannelOperations.jvm.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperations_jvmKt", f = "ByteReadChannelOperations.jvm.kt", i = {0, 0, 0}, l = {PropertyIDConstants.BorderTop}, m = "skipDelimiter", n = {"$this$skipDelimiter", "delimiter", "i"}, s = {"L$0", "L$1", "I$0"})
public final class ByteReadChannelOperations_jvmKt$skipDelimiter$2 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteReadChannelOperations_jvmKt$skipDelimiter$2(Continuation<? super ByteReadChannelOperations_jvmKt$skipDelimiter$2> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LynxAccessibilityDelegate.INVALID_NODE_ID;
        return ByteReadChannelOperations_jvmKt.skipDelimiter((ByteReadChannel) null, (ByteString) null, (Continuation) this);
    }
}