package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteChannel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
@DebugMetadata(c = "io.ktor.utils.io.ByteChannel", f = "ByteChannel.kt", i = {0}, l = {PropertyIDConstants.BackgroundClip}, m = "flushAndClose", n = {"this"}, s = {"L$0"})
public final class ByteChannel$flushAndClose$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteChannel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannel$flushAndClose$1(ByteChannel byteChannel, Continuation<? super ByteChannel$flushAndClose$1> continuation) {
        super(continuation);
        this.this$0 = byteChannel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LynxAccessibilityDelegate.INVALID_NODE_ID;
        return this.this$0.flushAndClose((Continuation) this);
    }
}