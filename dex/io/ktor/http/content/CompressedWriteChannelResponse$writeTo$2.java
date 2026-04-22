package io.ktor.http.content;

import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelKt;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CompressedContent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.http.content.CompressedWriteChannelResponse$writeTo$2", f = "CompressedContent.kt", i = {0}, l = {82}, m = "invokeSuspend", n = {"$this$use$iv"}, s = {"L$0"})
final class CompressedWriteChannelResponse$writeTo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteWriteChannel $channel;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CompressedWriteChannelResponse this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompressedWriteChannelResponse$writeTo$2(CompressedWriteChannelResponse compressedWriteChannelResponse, ByteWriteChannel byteWriteChannel, Continuation<? super CompressedWriteChannelResponse$writeTo$2> continuation) {
        super(2, continuation);
        this.this$0 = compressedWriteChannelResponse;
        this.$channel = byteWriteChannel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> compressedWriteChannelResponse$writeTo$2 = new CompressedWriteChannelResponse$writeTo$2(this.this$0, this.$channel, continuation);
        compressedWriteChannelResponse$writeTo$2.L$0 = obj;
        return compressedWriteChannelResponse$writeTo$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ByteWriteChannel $this$use$iv;
        Throwable cause$iv;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineScope $this$withContext = (CoroutineScope) this.L$0;
                $this$use$iv = this.this$0.getEncoder().encode(this.$channel, $this$withContext.getCoroutineContext());
                try {
                    OutgoingContent.WriteChannelContent original = this.this$0.getOriginal();
                    this.L$0 = $this$use$iv;
                    this.label = 1;
                    if (original.writeTo($this$use$iv, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ByteWriteChannelKt.close($this$use$iv);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    cause$iv = th;
                    try {
                        ByteWriteChannelOperationsKt.close($this$use$iv, cause$iv);
                        throw cause$iv;
                    } catch (Throwable cause$iv2) {
                        ByteWriteChannelKt.close($this$use$iv);
                        throw cause$iv2;
                    }
                }
            case 1:
                $this$use$iv = (ByteWriteChannel) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    ByteWriteChannelKt.close($this$use$iv);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    cause$iv = th2;
                    ByteWriteChannelOperationsKt.close($this$use$iv, cause$iv);
                    throw cause$iv;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}