package io.ktor.utils.io.jvm.javaio;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import io.ktor.utils.io.ByteReadChannel;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.io.BuffersJvmKt;

/* compiled from: Writing.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u001a&\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Ljava/io/OutputStream;", "out", "", "limit", "copyTo", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/io/OutputStream;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class WritingKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0076 -> B:26:0x0079). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007b -> B:28:0x007c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object copyTo(ByteReadChannel $this$copyTo, OutputStream out, long limit, Continuation<? super Long> continuation) {
        WritingKt$copyTo$1 writingKt$copyTo$1;
        long result;
        ByteReadChannel $this$copyTo2;
        OutputStream out2;
        ByteReadChannel $this$copyTo3;
        if (continuation instanceof WritingKt$copyTo$1) {
            writingKt$copyTo$1 = (WritingKt$copyTo$1) continuation;
            if ((writingKt$copyTo$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                writingKt$copyTo$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = writingKt$copyTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (writingKt$copyTo$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!(limit >= 0)) {
                            throw new IllegalArgumentException(("Limit shouldn't be negative: " + limit).toString());
                        }
                        result = 0;
                        $this$copyTo2 = $this$copyTo;
                        out2 = out;
                        break;
                    case 1:
                        result = writingKt$copyTo$1.J$0;
                        out2 = (OutputStream) writingKt$copyTo$1.L$1;
                        $this$copyTo2 = (ByteReadChannel) writingKt$copyTo$1.L$0;
                        ResultKt.throwOnFailure($result);
                        $this$copyTo3 = $this$copyTo2;
                        long result2 = result + $this$copyTo3.mo1388getReadBuffer().getBuffer().getSize();
                        BuffersJvmKt.readTo$default($this$copyTo3.mo1388getReadBuffer().getBuffer(), out2, 0L, 2, (Object) null);
                        $this$copyTo2 = $this$copyTo3;
                        result = result2;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!$this$copyTo2.isClosedForRead()) {
                    if (!$this$copyTo2.mo1388getReadBuffer().exhausted()) {
                        $this$copyTo3 = $this$copyTo2;
                        long result22 = result + $this$copyTo3.mo1388getReadBuffer().getBuffer().getSize();
                        BuffersJvmKt.readTo$default($this$copyTo3.mo1388getReadBuffer().getBuffer(), out2, 0L, 2, (Object) null);
                        $this$copyTo2 = $this$copyTo3;
                        result = result22;
                        if (!$this$copyTo2.isClosedForRead()) {
                        }
                    } else {
                        writingKt$copyTo$1.L$0 = $this$copyTo2;
                        writingKt$copyTo$1.L$1 = out2;
                        writingKt$copyTo$1.J$0 = result;
                        writingKt$copyTo$1.label = 1;
                        if (ByteReadChannel.DefaultImpls.awaitContent$default($this$copyTo2, 0, writingKt$copyTo$1, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$copyTo3 = $this$copyTo2;
                        long result222 = result + $this$copyTo3.mo1388getReadBuffer().getBuffer().getSize();
                        BuffersJvmKt.readTo$default($this$copyTo3.mo1388getReadBuffer().getBuffer(), out2, 0L, 2, (Object) null);
                        $this$copyTo2 = $this$copyTo3;
                        result = result222;
                        if (!$this$copyTo2.isClosedForRead()) {
                        }
                    }
                } else {
                    return Boxing.boxLong(result);
                }
            }
        }
        writingKt$copyTo$1 = new WritingKt$copyTo$1(continuation);
        Object $result2 = writingKt$copyTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (writingKt$copyTo$1.label) {
        }
        if (!$this$copyTo2.isClosedForRead()) {
        }
    }

    public static /* synthetic */ Object copyTo$default(ByteReadChannel byteReadChannel, OutputStream outputStream, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(byteReadChannel, outputStream, j, continuation);
    }
}