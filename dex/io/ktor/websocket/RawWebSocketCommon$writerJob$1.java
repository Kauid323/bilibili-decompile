package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import io.ktor.util.cio.ChannelWriteException;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.websocket.Frame;
import io.ktor.websocket.RawWebSocketCommon;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RawWebSocketCommon.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", Column.INVAL_VALUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommon$writerJob$1", f = "RawWebSocketCommon.kt", i = {1, 2}, l = {58, 60, 61, 79, 79, 79, 79}, m = "invokeSuspend", n = {"message", "message"}, s = {"L$0", "L$0"})
public final class RawWebSocketCommon$writerJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ RawWebSocketCommon this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawWebSocketCommon$writerJob$1(RawWebSocketCommon rawWebSocketCommon, Continuation<? super RawWebSocketCommon$writerJob$1> continuation) {
        super(2, continuation);
        this.this$0 = rawWebSocketCommon;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RawWebSocketCommon$writerJob$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0066 A[Catch: all -> 0x010b, ChannelWriteException -> 0x0111, TRY_LEAVE, TryCatch #7 {ChannelWriteException -> 0x0111, all -> 0x010b, blocks: (B:25:0x0062, B:27:0x0066, B:47:0x00de, B:49:0x00e2, B:50:0x00f1, B:51:0x010a), top: B:85:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a5 A[Catch: all -> 0x00d9, ChannelWriteException -> 0x00db, TRY_LEAVE, TryCatch #6 {ChannelWriteException -> 0x00db, all -> 0x00d9, blocks: (B:35:0x00a1, B:37:0x00a5), top: B:87:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00de A[Catch: all -> 0x010b, ChannelWriteException -> 0x0111, TRY_ENTER, TryCatch #7 {ChannelWriteException -> 0x0111, all -> 0x010b, blocks: (B:25:0x0062, B:27:0x0066, B:47:0x00de, B:49:0x00e2, B:50:0x00f1, B:51:0x010a), top: B:85:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0147 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0183 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0197  */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x009e -> B:87:0x00a1). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00e2 -> B:83:0x0048). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0184 -> B:68:0x0184). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        RawWebSocketCommon$writerJob$1 rawWebSocketCommon$writerJob$1;
        Channel channel;
        ByteWriteChannel byteWriteChannel;
        Channel channel2;
        Channel channel3;
        ByteWriteChannel byteWriteChannel2;
        Channel channel4;
        Channel channel5;
        ByteWriteChannel byteWriteChannel3;
        Channel channel6;
        Object obj;
        Object $result2;
        Object message;
        RawWebSocketCommon$writerJob$1 rawWebSocketCommon$writerJob$12;
        ByteWriteChannel byteWriteChannel4;
        Object message2;
        ByteWriteChannel byteWriteChannel5;
        Channel channel7;
        Object receive;
        SendChannel sendChannel;
        Channel channel8;
        ByteWriteChannel byteWriteChannel6;
        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r3 = "WebSocket closed.";
        try {
            try {
            } catch (Throwable th) {
                Object obj2 = $result3;
                channel = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                channel.close(ExceptionsKt.CancellationException((String) r3, (Throwable) null));
                byteWriteChannel = rawWebSocketCommon$writerJob$1.this$0.output;
                rawWebSocketCommon$writerJob$1.L$0 = th;
                rawWebSocketCommon$writerJob$1.label = 7;
                if (byteWriteChannel.flushAndClose((Continuation) rawWebSocketCommon$writerJob$1) == obj2) {
                    return obj2;
                }
                throw th;
            }
        } catch (ChannelWriteException e) {
            cause = e;
            rawWebSocketCommon$writerJob$1 = this;
        } catch (Throwable th2) {
            t = th2;
            rawWebSocketCommon$writerJob$1 = this;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                RawWebSocketCommon$writerJob$1 rawWebSocketCommon$writerJob$13 = this;
                try {
                    channel7 = rawWebSocketCommon$writerJob$13.this$0._outgoing;
                    rawWebSocketCommon$writerJob$13.L$0 = null;
                    rawWebSocketCommon$writerJob$13.label = 1;
                    receive = channel7.receive((Continuation) rawWebSocketCommon$writerJob$13);
                } catch (ChannelWriteException e2) {
                    rawWebSocketCommon$writerJob$1 = rawWebSocketCommon$writerJob$13;
                    cause = e2;
                    channel4 = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                    channel4.close(ExceptionsKt.CancellationException("Failed to write to WebSocket.", cause));
                    channel5 = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                    channel5.close(ExceptionsKt.CancellationException("WebSocket closed.", (Throwable) null));
                    byteWriteChannel3 = rawWebSocketCommon$writerJob$1.this$0.output;
                    rawWebSocketCommon$writerJob$1.L$0 = null;
                    r3 = 5;
                    rawWebSocketCommon$writerJob$1.label = 5;
                    if (byteWriteChannel3.flushAndClose((Continuation) rawWebSocketCommon$writerJob$1) == $result3) {
                        return $result3;
                    }
                    channel6 = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                    $result3 = ChannelResult.getOrNull-impl(channel6.tryReceive-PtdJZtk());
                    if ($result3 == null) {
                    }
                } catch (Throwable th3) {
                    rawWebSocketCommon$writerJob$1 = rawWebSocketCommon$writerJob$13;
                    t = th3;
                    channel2 = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                    channel2.close(t);
                    channel3 = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                    channel3.close(ExceptionsKt.CancellationException("WebSocket closed.", (Throwable) null));
                    byteWriteChannel2 = rawWebSocketCommon$writerJob$1.this$0.output;
                    rawWebSocketCommon$writerJob$1.L$0 = null;
                    r3 = 6;
                    rawWebSocketCommon$writerJob$1.label = 6;
                    if (byteWriteChannel2.flushAndClose((Continuation) rawWebSocketCommon$writerJob$1) == $result3) {
                        return $result3;
                    }
                    channel6 = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                    $result3 = ChannelResult.getOrNull-impl(channel6.tryReceive-PtdJZtk());
                    if ($result3 == null) {
                    }
                }
                if (receive == $result3) {
                    return $result3;
                }
                Object obj3 = $result3;
                $result2 = $result;
                $result = receive;
                rawWebSocketCommon$writerJob$1 = rawWebSocketCommon$writerJob$13;
                obj = obj3;
                try {
                } catch (ChannelWriteException e3) {
                    Object obj4 = obj;
                    cause = e3;
                    $result3 = obj4;
                    channel4 = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                    channel4.close(ExceptionsKt.CancellationException("Failed to write to WebSocket.", cause));
                    channel5 = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                    channel5.close(ExceptionsKt.CancellationException("WebSocket closed.", (Throwable) null));
                    byteWriteChannel3 = rawWebSocketCommon$writerJob$1.this$0.output;
                    rawWebSocketCommon$writerJob$1.L$0 = null;
                    r3 = 5;
                    rawWebSocketCommon$writerJob$1.label = 5;
                    if (byteWriteChannel3.flushAndClose((Continuation) rawWebSocketCommon$writerJob$1) == $result3) {
                    }
                    channel6 = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                    $result3 = ChannelResult.getOrNull-impl(channel6.tryReceive-PtdJZtk());
                    if ($result3 == null) {
                    }
                } catch (Throwable th4) {
                    Object obj5 = obj;
                    t = th4;
                    $result3 = obj5;
                    channel2 = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                    channel2.close(t);
                    channel3 = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                    channel3.close(ExceptionsKt.CancellationException("WebSocket closed.", (Throwable) null));
                    byteWriteChannel2 = rawWebSocketCommon$writerJob$1.this$0.output;
                    rawWebSocketCommon$writerJob$1.L$0 = null;
                    r3 = 6;
                    rawWebSocketCommon$writerJob$1.label = 6;
                    if (byteWriteChannel2.flushAndClose((Continuation) rawWebSocketCommon$writerJob$1) == $result3) {
                    }
                    channel6 = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                    $result3 = ChannelResult.getOrNull-impl(channel6.tryReceive-PtdJZtk());
                    if ($result3 == null) {
                    }
                }
                if ($result instanceof Frame) {
                    byteWriteChannel5 = rawWebSocketCommon$writerJob$1.this$0.output;
                    rawWebSocketCommon$writerJob$1.L$0 = $result;
                    rawWebSocketCommon$writerJob$1.label = 2;
                    if (RawWebSocketCommonKt.writeFrame(byteWriteChannel5, (Frame) $result, rawWebSocketCommon$writerJob$1.this$0.getMasking(), (Continuation) rawWebSocketCommon$writerJob$1) == obj) {
                        return obj;
                    }
                    RawWebSocketCommon$writerJob$1 rawWebSocketCommon$writerJob$14 = rawWebSocketCommon$writerJob$1;
                    message = $result;
                    $result = $result2;
                    $result3 = obj;
                    rawWebSocketCommon$writerJob$12 = rawWebSocketCommon$writerJob$14;
                    byteWriteChannel4 = rawWebSocketCommon$writerJob$12.this$0.output;
                    rawWebSocketCommon$writerJob$12.L$0 = message;
                    rawWebSocketCommon$writerJob$12.label = 3;
                    if (byteWriteChannel4.flush((Continuation) rawWebSocketCommon$writerJob$12) != $result3) {
                        return $result3;
                    }
                    Object obj6 = message;
                    rawWebSocketCommon$writerJob$1 = rawWebSocketCommon$writerJob$12;
                    message2 = obj6;
                    try {
                    } catch (ChannelWriteException e4) {
                        cause = e4;
                        channel4 = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                        channel4.close(ExceptionsKt.CancellationException("Failed to write to WebSocket.", cause));
                        channel5 = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                        channel5.close(ExceptionsKt.CancellationException("WebSocket closed.", (Throwable) null));
                        byteWriteChannel3 = rawWebSocketCommon$writerJob$1.this$0.output;
                        rawWebSocketCommon$writerJob$1.L$0 = null;
                        r3 = 5;
                        rawWebSocketCommon$writerJob$1.label = 5;
                        if (byteWriteChannel3.flushAndClose((Continuation) rawWebSocketCommon$writerJob$1) == $result3) {
                        }
                        channel6 = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                        $result3 = ChannelResult.getOrNull-impl(channel6.tryReceive-PtdJZtk());
                        if ($result3 == null) {
                        }
                    } catch (Throwable th5) {
                        t = th5;
                        channel2 = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                        channel2.close(t);
                        channel3 = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                        channel3.close(ExceptionsKt.CancellationException("WebSocket closed.", (Throwable) null));
                        byteWriteChannel2 = rawWebSocketCommon$writerJob$1.this$0.output;
                        rawWebSocketCommon$writerJob$1.L$0 = null;
                        r3 = 6;
                        rawWebSocketCommon$writerJob$1.label = 6;
                        if (byteWriteChannel2.flushAndClose((Continuation) rawWebSocketCommon$writerJob$1) == $result3) {
                        }
                        channel6 = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                        $result3 = ChannelResult.getOrNull-impl(channel6.tryReceive-PtdJZtk());
                        if ($result3 == null) {
                        }
                    }
                    if (message2 instanceof Frame.Close) {
                        rawWebSocketCommon$writerJob$13 = rawWebSocketCommon$writerJob$1;
                        channel7 = rawWebSocketCommon$writerJob$13.this$0._outgoing;
                        rawWebSocketCommon$writerJob$13.L$0 = null;
                        rawWebSocketCommon$writerJob$13.label = 1;
                        receive = channel7.receive((Continuation) rawWebSocketCommon$writerJob$13);
                        if (receive == $result3) {
                        }
                    } else {
                        sendChannel = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                        SendChannel.DefaultImpls.close$default(sendChannel, (Throwable) null, 1, (Object) null);
                        channel8 = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                        channel8.close(ExceptionsKt.CancellationException("WebSocket closed.", (Throwable) null));
                        byteWriteChannel6 = rawWebSocketCommon$writerJob$1.this$0.output;
                        rawWebSocketCommon$writerJob$1.L$0 = null;
                        r3 = 4;
                        rawWebSocketCommon$writerJob$1.label = 4;
                        if (byteWriteChannel6.flushAndClose((Continuation) rawWebSocketCommon$writerJob$1) == $result3) {
                            return $result3;
                        }
                        channel6 = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                        $result3 = ChannelResult.getOrNull-impl(channel6.tryReceive-PtdJZtk());
                        if ($result3 == null) {
                            return Unit.INSTANCE;
                        }
                        r3 = r3;
                        if ($result3 instanceof RawWebSocketCommon.FlushRequest) {
                            Boxing.boxBoolean(((RawWebSocketCommon.FlushRequest) $result3).complete());
                            r3 = r3;
                        }
                        channel6 = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                        $result3 = ChannelResult.getOrNull-impl(channel6.tryReceive-PtdJZtk());
                        if ($result3 == null) {
                        }
                    }
                } else if (!($result instanceof RawWebSocketCommon.FlushRequest)) {
                    throw new IllegalArgumentException("unknown message " + $result);
                } else {
                    Boxing.boxBoolean(((RawWebSocketCommon.FlushRequest) $result).complete());
                    $result = $result2;
                    $result3 = obj;
                    rawWebSocketCommon$writerJob$13 = rawWebSocketCommon$writerJob$1;
                    channel7 = rawWebSocketCommon$writerJob$13.this$0._outgoing;
                    rawWebSocketCommon$writerJob$13.L$0 = null;
                    rawWebSocketCommon$writerJob$13.label = 1;
                    receive = channel7.receive((Continuation) rawWebSocketCommon$writerJob$13);
                    if (receive == $result3) {
                    }
                }
            case 1:
                ResultKt.throwOnFailure($result);
                rawWebSocketCommon$writerJob$1 = this;
                obj = $result3;
                $result2 = $result;
                if ($result instanceof Frame) {
                }
                break;
            case 2:
                Object message3 = this.L$0;
                ResultKt.throwOnFailure($result);
                message = message3;
                rawWebSocketCommon$writerJob$12 = this;
                byteWriteChannel4 = rawWebSocketCommon$writerJob$12.this$0.output;
                rawWebSocketCommon$writerJob$12.L$0 = message;
                rawWebSocketCommon$writerJob$12.label = 3;
                if (byteWriteChannel4.flush((Continuation) rawWebSocketCommon$writerJob$12) != $result3) {
                }
                break;
            case 3:
                message2 = this.L$0;
                ResultKt.throwOnFailure($result);
                rawWebSocketCommon$writerJob$1 = this;
                if (message2 instanceof Frame.Close) {
                }
                break;
            case 4:
            case 5:
            case 6:
                ResultKt.throwOnFailure($result);
                rawWebSocketCommon$writerJob$1 = this;
                channel6 = rawWebSocketCommon$writerJob$1.this$0._outgoing;
                $result3 = ChannelResult.getOrNull-impl(channel6.tryReceive-PtdJZtk());
                if ($result3 == null) {
                }
                break;
            case 7:
                Throwable th6 = (Throwable) this.L$0;
                ResultKt.throwOnFailure($result);
                throw th6;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}