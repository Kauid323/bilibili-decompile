package io.ktor.http.content;

import com.tencent.open.SocialConstants;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.LongRange;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OutgoingContent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.http.content.OutgoingContent$ReadChannelContent$readFrom$1", f = "OutgoingContent.kt", i = {0, 0}, l = {93, 95}, m = "invokeSuspend", n = {"$this$writer", SocialConstants.PARAM_SOURCE}, s = {"L$0", "L$1"})
public final class OutgoingContent$ReadChannelContent$readFrom$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LongRange $range;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ OutgoingContent.ReadChannelContent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutgoingContent$ReadChannelContent$readFrom$1(OutgoingContent.ReadChannelContent readChannelContent, LongRange longRange, Continuation<? super OutgoingContent$ReadChannelContent$readFrom$1> continuation) {
        super(2, continuation);
        this.this$0 = readChannelContent;
        this.$range = longRange;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> outgoingContent$ReadChannelContent$readFrom$1 = new OutgoingContent$ReadChannelContent$readFrom$1(this.this$0, this.$range, continuation);
        outgoingContent$ReadChannelContent$readFrom$1.L$0 = obj;
        return outgoingContent$ReadChannelContent$readFrom$1;
    }

    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return create(writerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        WriterScope $this$writer;
        ByteReadChannel source;
        long limit;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$writer = (WriterScope) this.L$0;
                source = this.this$0.readFrom();
                this.L$0 = $this$writer;
                this.L$1 = source;
                this.label = 1;
                if (ByteReadChannelOperationsKt.discard(source, this.$range.getFirst(), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                limit = (this.$range.getLast() - this.$range.getFirst()) + 1;
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
                if (ByteReadChannelOperationsKt.copyTo(source, $this$writer.getChannel(), limit, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                source = (ByteReadChannel) this.L$1;
                $this$writer = (WriterScope) this.L$0;
                ResultKt.throwOnFailure($result);
                limit = (this.$range.getLast() - this.$range.getFirst()) + 1;
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
                if (ByteReadChannelOperationsKt.copyTo(source, $this$writer.getChannel(), limit, (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}