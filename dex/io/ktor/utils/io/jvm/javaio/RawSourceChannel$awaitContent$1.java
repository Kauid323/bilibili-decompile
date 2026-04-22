package io.ktor.utils.io.jvm.javaio;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Reading.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.RawSourceChannel", f = "Reading.kt", i = {0, 0}, l = {65}, m = "awaitContent", n = {"this", "min"}, s = {"L$0", "I$0"})
public final class RawSourceChannel$awaitContent$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RawSourceChannel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawSourceChannel$awaitContent$1(RawSourceChannel rawSourceChannel, Continuation<? super RawSourceChannel$awaitContent$1> continuation) {
        super(continuation);
        this.this$0 = rawSourceChannel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LynxAccessibilityDelegate.INVALID_NODE_ID;
        return this.this$0.awaitContent(0, (Continuation) this);
    }
}