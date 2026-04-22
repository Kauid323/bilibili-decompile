package io.ktor.client.plugins.internal;

import io.ktor.client.plugins.internal.ByteChannelReplay;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteChannelReplay.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.internal.ByteChannelReplay$replay$1", f = "ByteChannelReplay.kt", i = {0}, l = {33, 34}, m = "invokeSuspend", n = {"$this$writer"}, s = {"L$0"})
public final class ByteChannelReplay$replay$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<ByteChannelReplay.CopyFromSourceTask> $copyTask;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelReplay$replay$1(Ref.ObjectRef<ByteChannelReplay.CopyFromSourceTask> objectRef, Continuation<? super ByteChannelReplay$replay$1> continuation) {
        super(2, continuation);
        this.$copyTask = objectRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> byteChannelReplay$replay$1 = new ByteChannelReplay$replay$1(this.$copyTask, continuation);
        byteChannelReplay$replay$1.L$0 = obj;
        return byteChannelReplay$replay$1;
    }

    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return create(writerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object $result2;
        WriterScope $this$writer;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                WriterScope $this$writer2 = (WriterScope) this.L$0;
                Object obj = this.$copyTask.element;
                Intrinsics.checkNotNull(obj);
                this.L$0 = $this$writer2;
                this.label = 1;
                Object awaitImpatiently = ((ByteChannelReplay.CopyFromSourceTask) obj).awaitImpatiently((Continuation) this);
                if (awaitImpatiently == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result = awaitImpatiently;
                $this$writer = $this$writer2;
                byte[] body = (byte[]) $result;
                this.L$0 = null;
                this.label = 2;
                return ByteWriteChannelOperationsKt.writeFully$default($this$writer.getChannel(), body, 0, 0, (Continuation) this, 6, (Object) null) != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                $this$writer = (WriterScope) this.L$0;
                $result2 = $result;
                byte[] body2 = (byte[]) $result;
                this.L$0 = null;
                this.label = 2;
                if (ByteWriteChannelOperationsKt.writeFully$default($this$writer.getChannel(), body2, 0, 0, (Continuation) this, 6, (Object) null) != coroutine_suspended) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}