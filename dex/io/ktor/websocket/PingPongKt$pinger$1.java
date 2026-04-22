package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import io.ktor.util.CryptoKt;
import io.ktor.util.date.DateJvmKt;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.Frame;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PingPong.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", Column.INVAL_VALUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.PingPongKt$pinger$1", f = "PingPong.kt", i = {0, 0, 1, 1}, l = {65, 74, 96}, m = "invokeSuspend", n = {"random", "pingIdBytes", "random", "pingIdBytes"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class PingPongKt$pinger$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Frame.Pong> $channel;
    final /* synthetic */ Function2<CloseReason, Continuation<? super Unit>, Object> $onTimeout;
    final /* synthetic */ SendChannel<Frame> $outgoing;
    final /* synthetic */ long $periodMillis;
    final /* synthetic */ long $timeoutMillis;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PingPongKt$pinger$1(long j, long j2, Function2<? super CloseReason, ? super Continuation<? super Unit>, ? extends Object> function2, Channel<Frame.Pong> channel, SendChannel<? super Frame> sendChannel, Continuation<? super PingPongKt$pinger$1> continuation) {
        super(2, continuation);
        this.$periodMillis = j;
        this.$timeoutMillis = j2;
        this.$onTimeout = function2;
        this.$channel = channel;
        this.$outgoing = sendChannel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PingPongKt$pinger$1(this.$periodMillis, this.$timeoutMillis, this.$onTimeout, this.$channel, this.$outgoing, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00dd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e7 A[Catch: ClosedSendChannelException -> 0x0112, ClosedReceiveChannelException -> 0x0116, CancellationException -> 0x011a, TRY_LEAVE, TryCatch #5 {CancellationException -> 0x011a, ClosedSendChannelException -> 0x0112, ClosedReceiveChannelException -> 0x0116, blocks: (B:30:0x00e3, B:32:0x00e7), top: B:53:0x00e3 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00de -> B:53:0x00e3). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        PingPongKt$pinger$1 pingPongKt$pinger$1;
        byte[] pingIdBytes;
        Random random;
        Object withTimeoutOrNull;
        PingPongKt$pinger$1 pingPongKt$pinger$12;
        byte[] pingIdBytes2;
        Object obj;
        Object $result2;
        Unit rc;
        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (ClosedReceiveChannelException e) {
            pingPongKt$pinger$1 = this;
        } catch (CancellationException e2) {
            pingPongKt$pinger$1 = this;
        } catch (ClosedSendChannelException e3) {
            pingPongKt$pinger$1 = this;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DefaultWebSocketSessionKt.getLOGGER().trace("Starting WebSocket pinger coroutine with period " + this.$periodMillis + " ms and timeout " + this.$timeoutMillis + " ms");
                Random random2 = RandomKt.Random(DateJvmKt.getTimeMillis());
                byte[] pingIdBytes3 = new byte[32];
                pingPongKt$pinger$1 = this;
                try {
                    pingPongKt$pinger$1.L$0 = random2;
                    pingPongKt$pinger$1.L$1 = pingIdBytes3;
                    pingPongKt$pinger$1.label = 1;
                } catch (ClosedSendChannelException e4) {
                } catch (ClosedReceiveChannelException e5) {
                } catch (CancellationException e6) {
                }
                if (TimeoutKt.withTimeoutOrNull(pingPongKt$pinger$1.$periodMillis, new AnonymousClass1(pingPongKt$pinger$1.$channel, null), (Continuation) pingPongKt$pinger$1) != $result3) {
                    return $result3;
                }
                byte[] bArr = pingIdBytes3;
                random = random2;
                pingIdBytes = bArr;
                random.nextBytes(pingIdBytes);
                String pingMessage = "[ping " + CryptoKt.hex(pingIdBytes) + " ping]";
                pingPongKt$pinger$1.L$0 = random;
                pingPongKt$pinger$1.L$1 = pingIdBytes;
                pingPongKt$pinger$1.label = 2;
                withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(pingPongKt$pinger$1.$timeoutMillis, new PingPongKt$pinger$1$rc$1(pingPongKt$pinger$1.$outgoing, pingMessage, pingPongKt$pinger$1.$channel, null), (Continuation) pingPongKt$pinger$1);
                if (withTimeoutOrNull != $result3) {
                    return $result3;
                }
                pingPongKt$pinger$12 = pingPongKt$pinger$1;
                pingIdBytes2 = pingIdBytes;
                obj = $result3;
                $result2 = $result;
                $result = withTimeoutOrNull;
                try {
                    rc = (Unit) $result;
                } catch (CancellationException e7) {
                    pingPongKt$pinger$1 = pingPongKt$pinger$12;
                } catch (ClosedSendChannelException e8) {
                    pingPongKt$pinger$1 = pingPongKt$pinger$12;
                } catch (ClosedReceiveChannelException e9) {
                    pingPongKt$pinger$1 = pingPongKt$pinger$12;
                }
                if (rc != null) {
                    DefaultWebSocketSessionKt.getLOGGER().trace("WebSocket pinger has timed out");
                    Function2<CloseReason, Continuation<? super Unit>, Object> function2 = pingPongKt$pinger$12.$onTimeout;
                    CloseReason closeReason = new CloseReason(CloseReason.Codes.INTERNAL_ERROR, "Ping timeout");
                    pingPongKt$pinger$12.L$0 = null;
                    pingPongKt$pinger$12.L$1 = null;
                    pingPongKt$pinger$12.label = 3;
                    return function2.invoke(closeReason, pingPongKt$pinger$12) == obj ? obj : Unit.INSTANCE;
                }
                $result = $result2;
                $result3 = obj;
                random2 = random;
                pingIdBytes3 = pingIdBytes2;
                pingPongKt$pinger$1 = pingPongKt$pinger$12;
                pingPongKt$pinger$1.L$0 = random2;
                pingPongKt$pinger$1.L$1 = pingIdBytes3;
                pingPongKt$pinger$1.label = 1;
                if (TimeoutKt.withTimeoutOrNull(pingPongKt$pinger$1.$periodMillis, new AnonymousClass1(pingPongKt$pinger$1.$channel, null), (Continuation) pingPongKt$pinger$1) != $result3) {
                }
            case 1:
                pingIdBytes = (byte[]) this.L$1;
                random = (Random) this.L$0;
                ResultKt.throwOnFailure($result);
                pingPongKt$pinger$1 = this;
                random.nextBytes(pingIdBytes);
                String pingMessage2 = "[ping " + CryptoKt.hex(pingIdBytes) + " ping]";
                pingPongKt$pinger$1.L$0 = random;
                pingPongKt$pinger$1.L$1 = pingIdBytes;
                pingPongKt$pinger$1.label = 2;
                withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(pingPongKt$pinger$1.$timeoutMillis, new PingPongKt$pinger$1$rc$1(pingPongKt$pinger$1.$outgoing, pingMessage2, pingPongKt$pinger$1.$channel, null), (Continuation) pingPongKt$pinger$1);
                if (withTimeoutOrNull != $result3) {
                }
                break;
            case 2:
                byte[] pingIdBytes4 = (byte[]) this.L$1;
                random = (Random) this.L$0;
                ResultKt.throwOnFailure($result);
                pingPongKt$pinger$12 = this;
                pingIdBytes2 = pingIdBytes4;
                obj = $result3;
                $result2 = $result;
                rc = (Unit) $result;
                if (rc != null) {
                }
                break;
            case 3:
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PingPong.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", Column.INVAL_VALUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.PingPongKt$pinger$1$1", f = "PingPong.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.websocket.PingPongKt$pinger$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<Frame.Pong> $channel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Channel<Frame.Pong> channel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$channel = channel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$channel, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            AnonymousClass1 anonymousClass1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    anonymousClass1 = this;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    anonymousClass1 = this;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            do {
                anonymousClass1.label = 1;
            } while (anonymousClass1.$channel.receive((Continuation) anonymousClass1) != coroutine_suspended);
            return coroutine_suspended;
        }
    }
}