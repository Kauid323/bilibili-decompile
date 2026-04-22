package io.ktor.http.content;

import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import java.io.Closeable;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: OutputStreamContent.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.http.content.OutputStreamContent$writeTo$2", f = "OutputStreamContent.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
final class OutputStreamContent$writeTo$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteWriteChannel $channel;
    Object L$0;
    int label;
    final /* synthetic */ OutputStreamContent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutputStreamContent$writeTo$2(ByteWriteChannel byteWriteChannel, OutputStreamContent outputStreamContent, Continuation<? super OutputStreamContent$writeTo$2> continuation) {
        super(1, continuation);
        this.$channel = byteWriteChannel;
        this.this$0 = outputStreamContent;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new OutputStreamContent$writeTo$2(this.$channel, this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final Object invokeSuspend(Object $result) {
        Function2 function2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        try {
            switch (r1) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    OutputStream outputStream = BlockingKt.toOutputStream(this.$channel);
                    OutputStream stream = outputStream;
                    function2 = this.this$0.body;
                    this.L$0 = outputStream;
                    this.label = 1;
                    if (function2.invoke(stream, this) != coroutine_suspended) {
                        r1 = outputStream;
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    Closeable closeable = (Closeable) this.L$0;
                    ResultKt.throwOnFailure($result);
                    r1 = closeable;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally((Closeable) r1, (Throwable) null);
            return Unit.INSTANCE;
        } finally {
        }
    }
}