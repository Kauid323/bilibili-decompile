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
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0}, l = {520}, m = "readUntil$appendPartialMatch", n = {"matchIndex", "rc"}, s = {"L$0", "L$1"})
public final class ByteReadChannelOperationsKt$readUntil$appendPartialMatch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteReadChannelOperationsKt$readUntil$appendPartialMatch$1(Continuation<? super ByteReadChannelOperationsKt$readUntil$appendPartialMatch$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object readUntil$appendPartialMatch;
        this.result = obj;
        this.label |= LynxAccessibilityDelegate.INVALID_NODE_ID;
        readUntil$appendPartialMatch = ByteReadChannelOperationsKt.readUntil$appendPartialMatch(null, null, null, null, (Continuation) this);
        return readUntil$appendPartialMatch;
    }
}