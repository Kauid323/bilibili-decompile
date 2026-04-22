package io.ktor.client.plugins.sse;

import io.ktor.sse.ServerSentEvent;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultClientSSESession.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lio/ktor/sse/ServerSentEvent;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.sse.DefaultClientSSESession$_incoming$1", f = "DefaultClientSSESession.kt", i = {0, 1}, l = {25, 30}, m = "invokeSuspend", n = {"$this$channelFlow", "$this$channelFlow"}, s = {"L$0", "L$0"})
public final class DefaultClientSSESession$_incoming$1 extends SuspendLambda implements Function2<ProducerScope<? super ServerSentEvent>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DefaultClientSSESession this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultClientSSESession$_incoming$1(DefaultClientSSESession defaultClientSSESession, Continuation<? super DefaultClientSSESession$_incoming$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultClientSSESession;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> defaultClientSSESession$_incoming$1 = new DefaultClientSSESession$_incoming$1(this.this$0, continuation);
        defaultClientSSESession$_incoming$1.L$0 = obj;
        return defaultClientSSESession$_incoming$1;
    }

    public final Object invoke(ProducerScope<? super ServerSentEvent> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0063, code lost:
        if (r4 != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0073, code lost:
        if (r4 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0076, code lost:
        r9 = r0;
        r0 = r1;
        r1 = r2;
        r2 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0076 -> B:9:0x002f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x008a -> B:9:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ProducerScope $this$channelFlow;
        DefaultClientSSESession$_incoming$1 defaultClientSSESession$_incoming$1;
        DefaultClientSSESession$_incoming$1 defaultClientSSESession$_incoming$12;
        ProducerScope $this$channelFlow2;
        Object obj;
        Object $result2;
        ServerSentEvent event;
        boolean isCommentsEvent;
        boolean isRetryEvent;
        boolean z;
        boolean z2;
        ByteReadChannel byteReadChannel;
        Object parseEvent;
        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$channelFlow = (ProducerScope) this.L$0;
                defaultClientSSESession$_incoming$1 = this;
                DefaultClientSSESession defaultClientSSESession = defaultClientSSESession$_incoming$1.this$0;
                byteReadChannel = defaultClientSSESession$_incoming$1.this$0.input;
                defaultClientSSESession$_incoming$1.L$0 = $this$channelFlow;
                defaultClientSSESession$_incoming$1.label = 1;
                parseEvent = defaultClientSSESession.parseEvent(byteReadChannel, (Continuation) defaultClientSSESession$_incoming$1);
                if (parseEvent == $result3) {
                    return $result3;
                }
                Object obj2 = $result3;
                $result2 = $result;
                $result = parseEvent;
                defaultClientSSESession$_incoming$12 = defaultClientSSESession$_incoming$1;
                $this$channelFlow2 = $this$channelFlow;
                obj = obj2;
                event = (ServerSentEvent) $result;
                if (event == null) {
                    isCommentsEvent = defaultClientSSESession$_incoming$12.this$0.isCommentsEvent(event);
                    if (isCommentsEvent) {
                        z2 = defaultClientSSESession$_incoming$12.this$0.showCommentEvents;
                        break;
                    }
                    isRetryEvent = defaultClientSSESession$_incoming$12.this$0.isRetryEvent(event);
                    if (isRetryEvent) {
                        z = defaultClientSSESession$_incoming$12.this$0.showRetryEvents;
                        break;
                    }
                    defaultClientSSESession$_incoming$12.L$0 = $this$channelFlow2;
                    defaultClientSSESession$_incoming$12.label = 2;
                    if ($this$channelFlow2.send(event, (Continuation) defaultClientSSESession$_incoming$12) == obj) {
                        return obj;
                    }
                    $result = $result2;
                    $result3 = obj;
                    $this$channelFlow = $this$channelFlow2;
                    defaultClientSSESession$_incoming$1 = defaultClientSSESession$_incoming$12;
                    DefaultClientSSESession defaultClientSSESession2 = defaultClientSSESession$_incoming$1.this$0;
                    byteReadChannel = defaultClientSSESession$_incoming$1.this$0.input;
                    defaultClientSSESession$_incoming$1.L$0 = $this$channelFlow;
                    defaultClientSSESession$_incoming$1.label = 1;
                    parseEvent = defaultClientSSESession2.parseEvent(byteReadChannel, (Continuation) defaultClientSSESession$_incoming$1);
                    if (parseEvent == $result3) {
                    }
                } else {
                    return Unit.INSTANCE;
                }
            case 1:
                ProducerScope $this$channelFlow3 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure($result);
                defaultClientSSESession$_incoming$12 = this;
                $this$channelFlow2 = $this$channelFlow3;
                obj = $result3;
                $result2 = $result;
                event = (ServerSentEvent) $result;
                if (event == null) {
                }
                break;
            case 2:
                $this$channelFlow = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure($result);
                defaultClientSSESession$_incoming$1 = this;
                DefaultClientSSESession defaultClientSSESession22 = defaultClientSSESession$_incoming$1.this$0;
                byteReadChannel = defaultClientSSESession$_incoming$1.this$0.input;
                defaultClientSSESession$_incoming$1.L$0 = $this$channelFlow;
                defaultClientSSESession$_incoming$1.label = 1;
                parseEvent = defaultClientSSESession22.parseEvent(byteReadChannel, (Continuation) defaultClientSSESession$_incoming$1);
                if (parseEvent == $result3) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}