package io.ktor.util.cio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperations_jvmKt;
import io.ktor.utils.io.InternalAPI;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

/* compiled from: ReadersJvm.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a0\u0010\u0006\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0087H¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Ljava/nio/ByteBuffer;", "buffer", "Lkotlin/Function1;", "", "block", "pass", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/ByteBuffer;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ReadersJvmKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005d -> B:19:0x0060). Please submit an issue!!! */
    @InternalAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object pass(ByteReadChannel $this$pass, ByteBuffer buffer, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation) {
        ReadersJvmKt$pass$1 readersJvmKt$pass$1;
        ByteReadChannel $this$pass2;
        ByteBuffer buffer2;
        Function1 block;
        if (continuation instanceof ReadersJvmKt$pass$1) {
            readersJvmKt$pass$1 = (ReadersJvmKt$pass$1) continuation;
            if ((readersJvmKt$pass$1.label & Integer.MIN_VALUE) != 0) {
                readersJvmKt$pass$1.label -= Integer.MIN_VALUE;
                Object $result = readersJvmKt$pass$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (readersJvmKt$pass$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$pass2 = $this$pass;
                        buffer2 = buffer;
                        block = function1;
                        break;
                    case 1:
                        block = (Function1) readersJvmKt$pass$1.L$2;
                        buffer2 = (ByteBuffer) readersJvmKt$pass$1.L$1;
                        $this$pass2 = (ByteReadChannel) readersJvmKt$pass$1.L$0;
                        ResultKt.throwOnFailure($result);
                        buffer2.flip();
                        block.invoke(buffer2);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!$this$pass2.isClosedForRead()) {
                    buffer2.clear();
                    readersJvmKt$pass$1.L$0 = $this$pass2;
                    readersJvmKt$pass$1.L$1 = buffer2;
                    readersJvmKt$pass$1.L$2 = block;
                    readersJvmKt$pass$1.label = 1;
                    if (ByteReadChannelOperations_jvmKt.readAvailable($this$pass2, buffer2, readersJvmKt$pass$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    buffer2.flip();
                    block.invoke(buffer2);
                    if (!$this$pass2.isClosedForRead()) {
                        Throwable it = $this$pass2.getClosedCause();
                        if (it != null) {
                            throw it;
                        }
                        return Unit.INSTANCE;
                    }
                }
            }
        }
        readersJvmKt$pass$1 = new ReadersJvmKt$pass$1(continuation);
        Object $result2 = readersJvmKt$pass$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (readersJvmKt$pass$1.label) {
        }
        if (!$this$pass2.isClosedForRead()) {
        }
    }

    @InternalAPI
    private static final Object pass$$forInline(ByteReadChannel $this$pass, ByteBuffer buffer, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation) {
        while (!$this$pass.isClosedForRead()) {
            buffer.clear();
            InlineMarker.mark(0);
            ByteReadChannelOperations_jvmKt.readAvailable($this$pass, buffer, continuation);
            InlineMarker.mark(1);
            buffer.flip();
            function1.invoke(buffer);
        }
        Throwable closedCause = $this$pass.getClosedCause();
        if (closedCause == null) {
            return Unit.INSTANCE;
        }
        Throwable it = closedCause;
        throw it;
    }
}