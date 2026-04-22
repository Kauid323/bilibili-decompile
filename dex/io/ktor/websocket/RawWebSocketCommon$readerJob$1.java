package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import com.bilibili.game.service.exception.DownloadError;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.Frame;
import java.io.EOFException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RawWebSocketCommon.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", Column.INVAL_VALUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommon$readerJob$1", f = "RawWebSocketCommon.kt", i = {2, 3}, l = {91, 95, 98, DownloadError.NETWORK_CONNECTION_TIMEOUT}, m = "invokeSuspend", n = {"cause", "cause"}, s = {"L$0", "L$0"})
public final class RawWebSocketCommon$readerJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ RawWebSocketCommon this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawWebSocketCommon$readerJob$1(RawWebSocketCommon rawWebSocketCommon, Continuation<? super RawWebSocketCommon$readerJob$1> continuation) {
        super(2, continuation);
        this.this$0 = rawWebSocketCommon;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RawWebSocketCommon$readerJob$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0173: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY] A[D('this' io.ktor.websocket.RawWebSocketCommon$readerJob$1)]), block:B:91:0x0173 */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0084 A[Catch: all -> 0x00b0, ClosedReceiveChannelException -> 0x00b6, EOFException -> 0x00ba, CancellationException -> 0x00be, ProtocolViolationException -> 0x00c4, FrameTooBigException -> 0x00ca, TryCatch #9 {EOFException -> 0x00ba, ClosedReceiveChannelException -> 0x00b6, FrameTooBigException -> 0x00ca, ProtocolViolationException -> 0x00c4, CancellationException -> 0x00be, all -> 0x00b0, blocks: (B:35:0x0078, B:37:0x0084, B:41:0x0096, B:40:0x008e, B:42:0x0099), top: B:95:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ab A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0124 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x015d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x015e  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00ac -> B:97:0x0055). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        RawWebSocketCommon$readerJob$1 rawWebSocketCommon$readerJob$1;
        RawWebSocketCommon$readerJob$1 rawWebSocketCommon$readerJob$12;
        RawWebSocketCommon$readerJob$1 rawWebSocketCommon$readerJob$13;
        SendChannel sendChannel;
        Channel channel;
        Channel channel2;
        ProtocolViolationException cause;
        FrameTooBigException cause2;
        Channel channel3;
        SendChannel sendChannel2;
        Channel channel4;
        Object obj;
        Object $result2;
        Frame frame;
        Channel channel5;
        ByteReadChannel byteReadChannel;
        int i;
        Object readFrame;
        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        RawWebSocketCommon$readerJob$1 rawWebSocketCommon$readerJob$14 = this.label;
        try {
            try {
                try {
                    try {
                    } catch (Throwable th) {
                        cause = th;
                        rawWebSocketCommon$readerJob$14 = this;
                        sendChannel = rawWebSocketCommon$readerJob$14.this$0._incoming;
                        SendChannel.DefaultImpls.close$default(sendChannel, (Throwable) null, 1, (Object) null);
                        throw cause;
                    }
                } catch (Throwable th2) {
                    cause = th2;
                    rawWebSocketCommon$readerJob$14 = rawWebSocketCommon$readerJob$13;
                    sendChannel = rawWebSocketCommon$readerJob$14.this$0._incoming;
                    SendChannel.DefaultImpls.close$default(sendChannel, (Throwable) null, 1, (Object) null);
                    throw cause;
                }
            } catch (Throwable th3) {
                cause = th3;
                sendChannel = rawWebSocketCommon$readerJob$14.this$0._incoming;
                SendChannel.DefaultImpls.close$default(sendChannel, (Throwable) null, 1, (Object) null);
                throw cause;
            }
        } catch (EOFException e) {
            rawWebSocketCommon$readerJob$1 = this;
        } catch (CancellationException e2) {
            cause = e2;
            rawWebSocketCommon$readerJob$1 = this;
        } catch (ClosedReceiveChannelException e3) {
            rawWebSocketCommon$readerJob$1 = this;
        } catch (FrameTooBigException e4) {
            cause = e4;
            rawWebSocketCommon$readerJob$12 = this;
        } catch (ProtocolViolationException e5) {
            cause = e5;
            rawWebSocketCommon$readerJob$12 = this;
        } catch (Throwable th4) {
            cause = th4;
            rawWebSocketCommon$readerJob$1 = this;
        }
        switch (rawWebSocketCommon$readerJob$14) {
            case 0:
                ResultKt.throwOnFailure($result);
                rawWebSocketCommon$readerJob$1 = this;
                try {
                    byteReadChannel = rawWebSocketCommon$readerJob$1.this$0.input;
                    long maxFrameSize = rawWebSocketCommon$readerJob$1.this$0.getMaxFrameSize();
                    i = rawWebSocketCommon$readerJob$1.this$0.lastOpcode;
                    rawWebSocketCommon$readerJob$1.label = 1;
                    readFrame = RawWebSocketCommonKt.readFrame(byteReadChannel, maxFrameSize, i, (Continuation) rawWebSocketCommon$readerJob$1);
                    if (readFrame == $result3) {
                        return $result3;
                    }
                    Object obj2 = $result3;
                    $result2 = $result;
                    $result = readFrame;
                    rawWebSocketCommon$readerJob$12 = rawWebSocketCommon$readerJob$1;
                    obj = obj2;
                    try {
                        frame = (Frame) $result;
                        if (!frame.getFrameType().getControlFrame()) {
                            rawWebSocketCommon$readerJob$12.this$0.lastOpcode = frame.getFin() ? 0 : frame.getFrameType().getOpcode();
                        }
                        channel5 = rawWebSocketCommon$readerJob$12.this$0._incoming;
                        rawWebSocketCommon$readerJob$12.label = 2;
                        if (channel5.send(frame, (Continuation) rawWebSocketCommon$readerJob$12) != obj) {
                            return obj;
                        }
                        $result = $result2;
                        $result3 = obj;
                        rawWebSocketCommon$readerJob$1 = rawWebSocketCommon$readerJob$12;
                        byteReadChannel = rawWebSocketCommon$readerJob$1.this$0.input;
                        long maxFrameSize2 = rawWebSocketCommon$readerJob$1.this$0.getMaxFrameSize();
                        i = rawWebSocketCommon$readerJob$1.this$0.lastOpcode;
                        rawWebSocketCommon$readerJob$1.label = 1;
                        readFrame = RawWebSocketCommonKt.readFrame(byteReadChannel, maxFrameSize2, i, (Continuation) rawWebSocketCommon$readerJob$1);
                        if (readFrame == $result3) {
                        }
                    } catch (EOFException e6) {
                        rawWebSocketCommon$readerJob$1 = rawWebSocketCommon$readerJob$12;
                    } catch (ClosedReceiveChannelException e7) {
                        rawWebSocketCommon$readerJob$1 = rawWebSocketCommon$readerJob$12;
                    } catch (FrameTooBigException e8) {
                        Object obj3 = obj;
                        cause = e8;
                        $result3 = obj3;
                        rawWebSocketCommon$readerJob$12.L$0 = cause;
                        rawWebSocketCommon$readerJob$12.label = 3;
                        if (rawWebSocketCommon$readerJob$12.this$0.getOutgoing().send(new Frame.Close(new CloseReason(CloseReason.Codes.TOO_BIG, cause.getMessage())), (Continuation) rawWebSocketCommon$readerJob$12) != $result3) {
                            return $result3;
                        }
                        cause2 = cause;
                        rawWebSocketCommon$readerJob$1 = rawWebSocketCommon$readerJob$12;
                        channel3 = rawWebSocketCommon$readerJob$1.this$0._incoming;
                        channel3.close(cause2);
                        sendChannel2 = rawWebSocketCommon$readerJob$1.this$0._incoming;
                        SendChannel.DefaultImpls.close$default(sendChannel2, (Throwable) null, 1, (Object) null);
                        return Unit.INSTANCE;
                    } catch (ProtocolViolationException e9) {
                        Object obj4 = obj;
                        cause = e9;
                        $result3 = obj4;
                        rawWebSocketCommon$readerJob$12.L$0 = cause;
                        rawWebSocketCommon$readerJob$12.label = 4;
                        if (rawWebSocketCommon$readerJob$12.this$0.getOutgoing().send(new Frame.Close(new CloseReason(CloseReason.Codes.PROTOCOL_ERROR, cause.getMessage())), (Continuation) rawWebSocketCommon$readerJob$12) != $result3) {
                            return $result3;
                        }
                        cause = cause;
                        rawWebSocketCommon$readerJob$1 = rawWebSocketCommon$readerJob$12;
                        channel4 = rawWebSocketCommon$readerJob$1.this$0._incoming;
                        channel4.close(cause);
                        sendChannel2 = rawWebSocketCommon$readerJob$1.this$0._incoming;
                        SendChannel.DefaultImpls.close$default(sendChannel2, (Throwable) null, 1, (Object) null);
                        return Unit.INSTANCE;
                    } catch (CancellationException e10) {
                        rawWebSocketCommon$readerJob$1 = rawWebSocketCommon$readerJob$12;
                        cause = e10;
                        channel2 = rawWebSocketCommon$readerJob$1.this$0._incoming;
                        channel2.cancel(cause);
                        sendChannel2 = rawWebSocketCommon$readerJob$1.this$0._incoming;
                        SendChannel.DefaultImpls.close$default(sendChannel2, (Throwable) null, 1, (Object) null);
                        return Unit.INSTANCE;
                    } catch (Throwable th5) {
                        rawWebSocketCommon$readerJob$1 = rawWebSocketCommon$readerJob$12;
                        cause = th5;
                        channel = rawWebSocketCommon$readerJob$1.this$0._incoming;
                        channel.close(cause);
                        throw cause;
                    }
                } catch (FrameTooBigException e11) {
                    rawWebSocketCommon$readerJob$12 = rawWebSocketCommon$readerJob$1;
                    cause = e11;
                    rawWebSocketCommon$readerJob$12.L$0 = cause;
                    rawWebSocketCommon$readerJob$12.label = 3;
                    if (rawWebSocketCommon$readerJob$12.this$0.getOutgoing().send(new Frame.Close(new CloseReason(CloseReason.Codes.TOO_BIG, cause.getMessage())), (Continuation) rawWebSocketCommon$readerJob$12) != $result3) {
                    }
                } catch (ProtocolViolationException e12) {
                    rawWebSocketCommon$readerJob$12 = rawWebSocketCommon$readerJob$1;
                    cause = e12;
                    rawWebSocketCommon$readerJob$12.L$0 = cause;
                    rawWebSocketCommon$readerJob$12.label = 4;
                    if (rawWebSocketCommon$readerJob$12.this$0.getOutgoing().send(new Frame.Close(new CloseReason(CloseReason.Codes.PROTOCOL_ERROR, cause.getMessage())), (Continuation) rawWebSocketCommon$readerJob$12) != $result3) {
                    }
                } catch (EOFException e13) {
                } catch (CancellationException e14) {
                    cause = e14;
                    channel2 = rawWebSocketCommon$readerJob$1.this$0._incoming;
                    channel2.cancel(cause);
                    sendChannel2 = rawWebSocketCommon$readerJob$1.this$0._incoming;
                    SendChannel.DefaultImpls.close$default(sendChannel2, (Throwable) null, 1, (Object) null);
                    return Unit.INSTANCE;
                } catch (ClosedReceiveChannelException e15) {
                } catch (Throwable th6) {
                    cause = th6;
                    channel = rawWebSocketCommon$readerJob$1.this$0._incoming;
                    channel.close(cause);
                    throw cause;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                rawWebSocketCommon$readerJob$12 = this;
                obj = $result3;
                $result2 = $result;
                frame = (Frame) $result;
                if (!frame.getFrameType().getControlFrame()) {
                }
                channel5 = rawWebSocketCommon$readerJob$12.this$0._incoming;
                rawWebSocketCommon$readerJob$12.label = 2;
                if (channel5.send(frame, (Continuation) rawWebSocketCommon$readerJob$12) != obj) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                rawWebSocketCommon$readerJob$1 = this;
                byteReadChannel = rawWebSocketCommon$readerJob$1.this$0.input;
                long maxFrameSize22 = rawWebSocketCommon$readerJob$1.this$0.getMaxFrameSize();
                i = rawWebSocketCommon$readerJob$1.this$0.lastOpcode;
                rawWebSocketCommon$readerJob$1.label = 1;
                readFrame = RawWebSocketCommonKt.readFrame(byteReadChannel, maxFrameSize22, i, (Continuation) rawWebSocketCommon$readerJob$1);
                if (readFrame == $result3) {
                }
                break;
            case 3:
                cause2 = (FrameTooBigException) this.L$0;
                ResultKt.throwOnFailure($result);
                rawWebSocketCommon$readerJob$1 = this;
                channel3 = rawWebSocketCommon$readerJob$1.this$0._incoming;
                channel3.close(cause2);
                sendChannel2 = rawWebSocketCommon$readerJob$1.this$0._incoming;
                SendChannel.DefaultImpls.close$default(sendChannel2, (Throwable) null, 1, (Object) null);
                return Unit.INSTANCE;
            case 4:
                cause = (ProtocolViolationException) this.L$0;
                ResultKt.throwOnFailure($result);
                rawWebSocketCommon$readerJob$1 = this;
                channel4 = rawWebSocketCommon$readerJob$1.this$0._incoming;
                channel4.close(cause);
                sendChannel2 = rawWebSocketCommon$readerJob$1.this$0._incoming;
                SendChannel.DefaultImpls.close$default(sendChannel2, (Throwable) null, 1, (Object) null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}