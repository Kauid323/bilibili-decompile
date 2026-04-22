package io.ktor.serialization.kotlinx.json;

import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.io.Buffer;

/* compiled from: ExperimentalJsonConverter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/ByteWriteChannel;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.serialization.kotlinx.json.ExperimentalJsonConverter$serialize$2", f = "ExperimentalJsonConverter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ExperimentalJsonConverter$serialize$2 extends SuspendLambda implements Function2<ByteWriteChannel, Continuation<? super Unit>, Object> {
    final /* synthetic */ Buffer $buffer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExperimentalJsonConverter$serialize$2(Buffer buffer, Continuation<? super ExperimentalJsonConverter$serialize$2> continuation) {
        super(2, continuation);
        this.$buffer = buffer;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> experimentalJsonConverter$serialize$2 = new ExperimentalJsonConverter$serialize$2(this.$buffer, continuation);
        experimentalJsonConverter$serialize$2.L$0 = obj;
        return experimentalJsonConverter$serialize$2;
    }

    public final Object invoke(ByteWriteChannel byteWriteChannel, Continuation<? super Unit> continuation) {
        return create(byteWriteChannel, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                ByteWriteChannel $this$ChannelWriterContent = (ByteWriteChannel) this.L$0;
                $this$ChannelWriterContent.getWriteBuffer().transferFrom(this.$buffer);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}