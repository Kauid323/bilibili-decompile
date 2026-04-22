package io.ktor.client.plugins.sse;

import faceverify.q;
import im.setting.UtilsKt;
import io.ktor.sse.ServerSentEvent;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: DefaultClientSSESession.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000b\u001a\u0004\u0018\u00010\n*\u00020\u0004H\u0082@¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u0011*\u00060\rj\u0002`\u000e2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u000f*\u00060\rj\u0002`\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0017\u001a\u00020\u0016*\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0016*\u00020\nH\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u0013\u0010\u001a\u001a\u00020\u0016*\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010%R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lio/ktor/client/plugins/sse/DefaultClientSSESession;", "Lio/ktor/client/plugins/sse/SSESession;", "Lio/ktor/client/plugins/sse/SSEClientContent;", q.KEY_RES_9_CONTENT, "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Lio/ktor/client/plugins/sse/SSEClientContent;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/CoroutineContext;)V", "Lio/ktor/sse/ServerSentEvent;", "parseEvent", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "comment", "", "appendComment", "(Ljava/lang/StringBuilder;Ljava/lang/String;)V", "toText", "(Ljava/lang/StringBuilder;)Ljava/lang/String;", "", "isEmpty", "(Lio/ktor/sse/ServerSentEvent;)Z", "isCommentsEvent", "isRetryEvent", "Lio/ktor/utils/io/ByteReadChannel;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "lastEventId", "Ljava/lang/String;", "", "reconnectionTimeMillis", "J", "showCommentEvents", "Z", "showRetryEvents", "Lkotlinx/coroutines/flow/Flow;", "_incoming", "Lkotlinx/coroutines/flow/Flow;", "getIncoming", "()Lkotlinx/coroutines/flow/Flow;", "incoming", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultClientSSESession implements SSESession {
    private final Flow<ServerSentEvent> _incoming;
    private final CoroutineContext coroutineContext;
    private ByteReadChannel input;
    private String lastEventId;
    private long reconnectionTimeMillis;
    private final boolean showCommentEvents;
    private final boolean showRetryEvents;

    public DefaultClientSSESession(SSEClientContent content, ByteReadChannel input, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(content, q.KEY_RES_9_CONTENT);
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.input = input;
        this.coroutineContext = coroutineContext;
        this.reconnectionTimeMillis = Duration.getInWholeMilliseconds-impl(content.m3498getReconnectionTimeUwyO8pc());
        this.showCommentEvents = content.getShowCommentEvents();
        this.showRetryEvents = content.getShowRetryEvents();
        this._incoming = FlowKt.channelFlow(new DefaultClientSSESession$_incoming$1(this, null));
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.client.plugins.sse.SSESession
    public Flow<ServerSentEvent> getIncoming() {
        return this._incoming;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ea A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x023f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0253 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0254  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0117 -> B:28:0x011b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x0240 -> B:79:0x024f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object parseEvent(ByteReadChannel byteReadChannel, Continuation<? super ServerSentEvent> continuation) {
        DefaultClientSSESession$parseEvent$1 defaultClientSSESession$parseEvent$1;
        DefaultClientSSESession defaultClientSSESession;
        ByteReadChannel $this$parseEvent;
        StringBuilder data;
        StringBuilder comments;
        String eventType;
        Ref.ObjectRef curRetry;
        String lastEventId;
        int i2;
        int i3;
        Object readUTF8Line$default;
        String str;
        DefaultClientSSESession$parseEvent$1 defaultClientSSESession$parseEvent$12;
        Object $result;
        String str2;
        Continuation $completion;
        Object $result2;
        String value;
        int i4;
        int i5;
        String eventType2;
        boolean z;
        ByteReadChannel $this$parseEvent2;
        StringBuilder data2;
        Ref.ObjectRef curRetry2;
        StringBuilder data3;
        String eventType3;
        String lastEventId2;
        DefaultClientSSESession defaultClientSSESession2;
        int i6;
        Object obj;
        Object $result3;
        String str3;
        Continuation $completion2 = continuation;
        if ($completion2 instanceof DefaultClientSSESession$parseEvent$1) {
            defaultClientSSESession$parseEvent$1 = (DefaultClientSSESession$parseEvent$1) $completion2;
            if ((defaultClientSSESession$parseEvent$1.label & Integer.MIN_VALUE) != 0) {
                defaultClientSSESession$parseEvent$1.label -= Integer.MIN_VALUE;
                Object $result4 = defaultClientSSESession$parseEvent$1.result;
                Object $result5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (defaultClientSSESession$parseEvent$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result4);
                        defaultClientSSESession = this;
                        $this$parseEvent = byteReadChannel;
                        data = new StringBuilder();
                        comments = new StringBuilder();
                        eventType = null;
                        curRetry = new Ref.ObjectRef();
                        lastEventId = defaultClientSSESession.lastEventId;
                        i2 = 0;
                        i3 = 0;
                        defaultClientSSESession$parseEvent$1.L$0 = defaultClientSSESession;
                        defaultClientSSESession$parseEvent$1.L$1 = $this$parseEvent;
                        defaultClientSSESession$parseEvent$1.L$2 = data;
                        defaultClientSSESession$parseEvent$1.L$3 = comments;
                        defaultClientSSESession$parseEvent$1.L$4 = curRetry;
                        defaultClientSSESession$parseEvent$1.L$5 = lastEventId;
                        defaultClientSSESession$parseEvent$1.I$0 = 0;
                        defaultClientSSESession$parseEvent$1.I$1 = 0;
                        defaultClientSSESession$parseEvent$1.label = 1;
                        readUTF8Line$default = ByteReadChannelOperationsKt.readUTF8Line$default($this$parseEvent, 0, defaultClientSSESession$parseEvent$1, 1, (Object) null);
                        if (readUTF8Line$default == $result5) {
                            return $result5;
                        }
                        str = (String) readUTF8Line$default;
                        if (str != null) {
                            return null;
                        }
                        defaultClientSSESession$parseEvent$12 = defaultClientSSESession$parseEvent$1;
                        String line = str;
                        $completion2 = continuation;
                        if (!StringsKt.isBlank(line)) {
                            defaultClientSSESession$parseEvent$12.L$0 = defaultClientSSESession;
                            defaultClientSSESession$parseEvent$12.L$1 = $this$parseEvent;
                            defaultClientSSESession$parseEvent$12.L$2 = data;
                            defaultClientSSESession$parseEvent$12.L$3 = comments;
                            defaultClientSSESession$parseEvent$12.L$4 = curRetry;
                            defaultClientSSESession$parseEvent$12.L$5 = lastEventId;
                            defaultClientSSESession$parseEvent$12.I$0 = i2;
                            defaultClientSSESession$parseEvent$12.I$1 = i3;
                            defaultClientSSESession$parseEvent$12.label = 2;
                            Continuation $completion3 = $completion2;
                            Object readUTF8Line$default2 = ByteReadChannelOperationsKt.readUTF8Line$default($this$parseEvent, 0, defaultClientSSESession$parseEvent$12, 1, (Object) null);
                            if (readUTF8Line$default2 == $result5) {
                                return $result5;
                            }
                            $result = $result4;
                            $result4 = readUTF8Line$default2;
                            $completion2 = $completion3;
                            str2 = (String) $result4;
                            if (str2 != null) {
                                return null;
                            }
                            $result4 = $result;
                            line = str2;
                            if (!StringsKt.isBlank(line)) {
                                Ref.ObjectRef objectRef = curRetry;
                                String lastEventId3 = lastEventId;
                                DefaultClientSSESession defaultClientSSESession3 = defaultClientSSESession;
                                StringBuilder comments2 = data;
                                StringBuilder data4 = comments;
                                Ref.ObjectRef curRetry3 = objectRef;
                                if (StringsKt.isBlank(line)) {
                                    $completion = $completion2;
                                    $result2 = $result4;
                                    if (!StringsKt.startsWith$default(line, ":", false, 2, (Object) null)) {
                                        String field = StringsKt.substringBefore$default(line, ":", (String) null, 2, (Object) null);
                                        value = StringsKt.removePrefix(StringsKt.substringAfter(line, ":", ""), ServerSentEventKt.SPACE);
                                        switch (field.hashCode()) {
                                            case 3355:
                                                if (field.equals("id")) {
                                                    i4 = i3;
                                                    if (!StringsKt.contains$default(value, "\u0000", false, 2, (Object) null)) {
                                                        i5 = i2;
                                                        value = eventType;
                                                        i3 = i4;
                                                        eventType2 = value;
                                                        break;
                                                    }
                                                }
                                                i4 = i3;
                                                break;
                                            case 3076010:
                                                if (field.equals(UtilsKt.DATA_KEY)) {
                                                    comments2.append(value).append(ServerSentEventKt.END_OF_LINE);
                                                    value = eventType;
                                                    eventType2 = lastEventId3;
                                                    i5 = 1;
                                                    break;
                                                }
                                                i4 = i3;
                                                break;
                                            case 96891546:
                                                if (field.equals("event")) {
                                                    eventType2 = lastEventId3;
                                                    i5 = i2;
                                                    break;
                                                }
                                                i4 = i3;
                                                break;
                                            case 108405416:
                                                if (field.equals("retry")) {
                                                    Long longOrNull = StringsKt.toLongOrNull(value);
                                                    if (longOrNull != null) {
                                                        long it = longOrNull.longValue();
                                                        defaultClientSSESession3.reconnectionTimeMillis = it;
                                                        curRetry3.element = Boxing.boxLong(it);
                                                    }
                                                    i4 = i3;
                                                    break;
                                                }
                                                i4 = i3;
                                                break;
                                            default:
                                                i4 = i3;
                                                break;
                                        }
                                    } else {
                                        defaultClientSSESession3.appendComment(data4, line);
                                        i3 = 1;
                                        value = eventType;
                                        eventType2 = lastEventId3;
                                        i5 = i2;
                                    }
                                    defaultClientSSESession$parseEvent$12.L$0 = defaultClientSSESession3;
                                    defaultClientSSESession$parseEvent$12.L$1 = $this$parseEvent;
                                    defaultClientSSESession$parseEvent$12.L$2 = comments2;
                                    defaultClientSSESession$parseEvent$12.L$3 = data4;
                                    defaultClientSSESession$parseEvent$12.L$4 = value;
                                    defaultClientSSESession$parseEvent$12.L$5 = curRetry3;
                                    defaultClientSSESession$parseEvent$12.L$6 = eventType2;
                                    defaultClientSSESession$parseEvent$12.I$0 = i5;
                                    defaultClientSSESession$parseEvent$12.I$1 = i3;
                                    defaultClientSSESession$parseEvent$12.label = 3;
                                    z = true;
                                    $result4 = ByteReadChannelOperationsKt.readUTF8Line$default($this$parseEvent, 0, defaultClientSSESession$parseEvent$12, 1, (Object) null);
                                    if ($result4 != $result5) {
                                        return $result5;
                                    }
                                    $this$parseEvent2 = $this$parseEvent;
                                    data2 = comments2;
                                    curRetry2 = curRetry3;
                                    data3 = data4;
                                    eventType3 = value;
                                    lastEventId2 = eventType2;
                                    $completion2 = $completion;
                                    defaultClientSSESession2 = defaultClientSSESession3;
                                    i6 = i3;
                                    obj = $result5;
                                    $result3 = $result2;
                                    str3 = (String) $result4;
                                    if (str3 != null) {
                                        return null;
                                    }
                                    line = str3;
                                    $result4 = $result3;
                                    $result5 = obj;
                                    i3 = i6;
                                    i2 = i5;
                                    defaultClientSSESession3 = defaultClientSSESession2;
                                    lastEventId3 = lastEventId2;
                                    eventType = eventType3;
                                    curRetry3 = curRetry2;
                                    data4 = data3;
                                    $this$parseEvent = $this$parseEvent2;
                                    comments2 = data2;
                                    if (StringsKt.isBlank(line)) {
                                    }
                                } else {
                                    defaultClientSSESession3.lastEventId = lastEventId3;
                                    ServerSentEvent event = new ServerSentEvent(i2 != 0 ? defaultClientSSESession3.toText(comments2) : null, eventType, lastEventId3, (Long) curRetry3.element, i3 != 0 ? defaultClientSSESession3.toText(data4) : null);
                                    if (!defaultClientSSESession3.isEmpty(event)) {
                                        return event;
                                    }
                                    $completion = $completion2;
                                    $result2 = $result4;
                                    i4 = i3;
                                }
                                value = eventType;
                                i3 = i4;
                                eventType2 = lastEventId3;
                                i5 = i2;
                                defaultClientSSESession$parseEvent$12.L$0 = defaultClientSSESession3;
                                defaultClientSSESession$parseEvent$12.L$1 = $this$parseEvent;
                                defaultClientSSESession$parseEvent$12.L$2 = comments2;
                                defaultClientSSESession$parseEvent$12.L$3 = data4;
                                defaultClientSSESession$parseEvent$12.L$4 = value;
                                defaultClientSSESession$parseEvent$12.L$5 = curRetry3;
                                defaultClientSSESession$parseEvent$12.L$6 = eventType2;
                                defaultClientSSESession$parseEvent$12.I$0 = i5;
                                defaultClientSSESession$parseEvent$12.I$1 = i3;
                                defaultClientSSESession$parseEvent$12.label = 3;
                                z = true;
                                $result4 = ByteReadChannelOperationsKt.readUTF8Line$default($this$parseEvent, 0, defaultClientSSESession$parseEvent$12, 1, (Object) null);
                                if ($result4 != $result5) {
                                }
                            }
                        }
                    case 1:
                        i3 = defaultClientSSESession$parseEvent$1.I$1;
                        i2 = defaultClientSSESession$parseEvent$1.I$0;
                        lastEventId = (String) defaultClientSSESession$parseEvent$1.L$5;
                        curRetry = (Ref.ObjectRef) defaultClientSSESession$parseEvent$1.L$4;
                        eventType = null;
                        comments = (StringBuilder) defaultClientSSESession$parseEvent$1.L$3;
                        data = (StringBuilder) defaultClientSSESession$parseEvent$1.L$2;
                        $this$parseEvent = (ByteReadChannel) defaultClientSSESession$parseEvent$1.L$1;
                        defaultClientSSESession = (DefaultClientSSESession) defaultClientSSESession$parseEvent$1.L$0;
                        ResultKt.throwOnFailure($result4);
                        readUTF8Line$default = $result4;
                        str = (String) readUTF8Line$default;
                        if (str != null) {
                        }
                        break;
                    case 2:
                        i3 = defaultClientSSESession$parseEvent$1.I$1;
                        i2 = defaultClientSSESession$parseEvent$1.I$0;
                        lastEventId = (String) defaultClientSSESession$parseEvent$1.L$5;
                        curRetry = (Ref.ObjectRef) defaultClientSSESession$parseEvent$1.L$4;
                        eventType = null;
                        comments = (StringBuilder) defaultClientSSESession$parseEvent$1.L$3;
                        data = (StringBuilder) defaultClientSSESession$parseEvent$1.L$2;
                        $this$parseEvent = (ByteReadChannel) defaultClientSSESession$parseEvent$1.L$1;
                        defaultClientSSESession = (DefaultClientSSESession) defaultClientSSESession$parseEvent$1.L$0;
                        ResultKt.throwOnFailure($result4);
                        defaultClientSSESession$parseEvent$12 = defaultClientSSESession$parseEvent$1;
                        $result = $result4;
                        str2 = (String) $result4;
                        if (str2 != null) {
                        }
                        break;
                    case 3:
                        int i7 = defaultClientSSESession$parseEvent$1.I$1;
                        i5 = defaultClientSSESession$parseEvent$1.I$0;
                        eventType3 = (String) defaultClientSSESession$parseEvent$1.L$4;
                        ResultKt.throwOnFailure($result4);
                        defaultClientSSESession$parseEvent$12 = defaultClientSSESession$parseEvent$1;
                        $this$parseEvent2 = (ByteReadChannel) defaultClientSSESession$parseEvent$1.L$1;
                        z = true;
                        data2 = (StringBuilder) defaultClientSSESession$parseEvent$1.L$2;
                        data3 = (StringBuilder) defaultClientSSESession$parseEvent$1.L$3;
                        curRetry2 = (Ref.ObjectRef) defaultClientSSESession$parseEvent$1.L$5;
                        lastEventId2 = (String) defaultClientSSESession$parseEvent$1.L$6;
                        defaultClientSSESession2 = (DefaultClientSSESession) defaultClientSSESession$parseEvent$1.L$0;
                        i6 = i7;
                        obj = $result5;
                        $result3 = $result4;
                        str3 = (String) $result4;
                        if (str3 != null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        defaultClientSSESession$parseEvent$1 = new DefaultClientSSESession$parseEvent$1(this, $completion2);
        Object $result42 = defaultClientSSESession$parseEvent$1.result;
        Object $result52 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (defaultClientSSESession$parseEvent$1.label) {
        }
    }

    private final void appendComment(StringBuilder $this$appendComment, String comment) {
        $this$appendComment.append(StringsKt.removePrefix(StringsKt.removePrefix(comment, ":"), ServerSentEventKt.SPACE)).append(ServerSentEventKt.END_OF_LINE);
    }

    private final String toText(StringBuilder $this$toText) {
        String sb = $this$toText.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return StringsKt.removeSuffix(sb, ServerSentEventKt.END_OF_LINE);
    }

    private final boolean isEmpty(ServerSentEvent $this$isEmpty) {
        return $this$isEmpty.getData() == null && $this$isEmpty.getId() == null && $this$isEmpty.getEvent() == null && $this$isEmpty.getRetry() == null && $this$isEmpty.getComments() == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCommentsEvent(ServerSentEvent $this$isCommentsEvent) {
        return $this$isCommentsEvent.getData() == null && $this$isCommentsEvent.getEvent() == null && $this$isCommentsEvent.getId() == null && $this$isCommentsEvent.getRetry() == null && $this$isCommentsEvent.getComments() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isRetryEvent(ServerSentEvent $this$isRetryEvent) {
        return $this$isRetryEvent.getData() == null && $this$isRetryEvent.getEvent() == null && $this$isRetryEvent.getId() == null && $this$isRetryEvent.getComments() == null && $this$isRetryEvent.getRetry() != null;
    }
}