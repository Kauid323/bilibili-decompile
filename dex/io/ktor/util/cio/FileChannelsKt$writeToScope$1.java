package io.ktor.util.cio;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileChannels.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.cio.FileChannelsKt", f = "FileChannels.kt", i = {0, 0, 0, 1, 1, 1, 1, 1}, l = {142, 178}, m = "writeToScope", n = {"$this$writeToScope", "$this$writeWhile$iv", "done$iv", "$this$writeToScope", "position", "$this$writeWhile$iv", "done$iv", "endInclusive"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "J$0"})
public final class FileChannelsKt$writeToScope$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileChannelsKt$writeToScope$1(Continuation<? super FileChannelsKt$writeToScope$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FileChannelsKt.writeToScope(null, null, 0L, 0L, (Continuation) this);
    }
}