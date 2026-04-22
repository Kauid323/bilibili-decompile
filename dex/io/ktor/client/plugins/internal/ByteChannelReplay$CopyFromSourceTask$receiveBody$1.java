package io.ktor.client.plugins.internal;

import com.tencent.open.log.TraceLevel;
import io.ktor.client.plugins.internal.ByteChannelReplay;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.SourcesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteChannelReplay.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.internal.ByteChannelReplay$CopyFromSourceTask$receiveBody$1", f = "ByteChannelReplay.kt", i = {0, 0, 1, 1, 2, 2, 2, 3, 3, 3}, l = {59, TraceLevel.ABOVE_DEBUG, 64, 65}, m = "invokeSuspend", n = {"$this$writer", "body", "$this$writer", "body", "$this$writer", "body", "packet", "$this$writer", "body", "packet"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
public final class ByteChannelReplay$CopyFromSourceTask$receiveBody$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ByteChannelReplay this$0;
    final /* synthetic */ ByteChannelReplay.CopyFromSourceTask this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelReplay$CopyFromSourceTask$receiveBody$1(ByteChannelReplay byteChannelReplay, ByteChannelReplay.CopyFromSourceTask copyFromSourceTask, Continuation<? super ByteChannelReplay$CopyFromSourceTask$receiveBody$1> continuation) {
        super(2, continuation);
        this.this$0 = byteChannelReplay;
        this.this$1 = copyFromSourceTask;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> byteChannelReplay$CopyFromSourceTask$receiveBody$1 = new ByteChannelReplay$CopyFromSourceTask$receiveBody$1(this.this$0, this.this$1, continuation);
        byteChannelReplay$CopyFromSourceTask$receiveBody$1.L$0 = obj;
        return byteChannelReplay$CopyFromSourceTask$receiveBody$1;
    }

    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return create(writerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:25|26|27|28|(2:30|(1:32)(5:33|34|35|(1:37)|10))|11|12|13|14|15|(2:48|(3:50|51|52)(2:53|54))(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0114, code lost:
        r10 = r1;
        r1 = r12;
        r12 = r0;
        r0 = r10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076 A[Catch: all -> 0x014f, TryCatch #6 {all -> 0x014f, blocks: (B:23:0x006a, B:25:0x0076, B:27:0x0082, B:31:0x009d, B:57:0x012b, B:59:0x0137, B:63:0x014e), top: B:72:0x006a }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d3 A[Catch: Exception -> 0x0113, all -> 0x0125, TRY_LEAVE, TryCatch #0 {all -> 0x0125, blocks: (B:53:0x011c, B:35:0x00c6, B:36:0x00c9, B:38:0x00d3), top: B:67:0x011c }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0108 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012b A[Catch: all -> 0x014f, TRY_ENTER, TryCatch #6 {all -> 0x014f, blocks: (B:23:0x006a, B:25:0x0076, B:27:0x0082, B:31:0x009d, B:57:0x012b, B:59:0x0137, B:63:0x014e), top: B:72:0x006a }] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00d1 -> B:67:0x011c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0106 -> B:45:0x0109). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0118 -> B:67:0x011c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ByteChannelReplay$CopyFromSourceTask$receiveBody$1 byteChannelReplay$CopyFromSourceTask$receiveBody$1;
        ByteChannelReplay$CopyFromSourceTask$receiveBody$1 byteChannelReplay$CopyFromSourceTask$receiveBody$12;
        Sink body;
        WriterScope $this$writer;
        Object $result2;
        Source packet;
        Object obj;
        WriterScope $this$writer2;
        ByteReadChannel byteReadChannel;
        ByteReadChannel byteReadChannel2;
        Object readPacket;
        ByteReadChannel byteReadChannel3;
        ByteReadChannel byteReadChannel4;
        ByteReadChannel byteReadChannel5;
        ByteReadChannel byteReadChannel6;
        Source packet2;
        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        try {
            try {
            } catch (Throwable th) {
                it = th;
                byteChannelReplay$CopyFromSourceTask$receiveBody$12 = this;
                body.close();
                byteChannelReplay$CopyFromSourceTask$receiveBody$12.this$1.getSavedResponse().completeExceptionally(it);
                throw it;
            }
        } catch (Exception e2) {
            byteChannelReplay$CopyFromSourceTask$receiveBody$1 = this;
            Object obj2 = $result3;
            $result2 = $result;
            packet = r1;
            obj = obj2;
            try {
                try {
                    BytePacketBuilderKt.writePacket(body, packet);
                    byteReadChannel3 = byteChannelReplay$CopyFromSourceTask$receiveBody$12.this$0.origin;
                    if (byteReadChannel3.isClosedForRead()) {
                    }
                } catch (Throwable th2) {
                    byteChannelReplay$CopyFromSourceTask$receiveBody$12 = byteChannelReplay$CopyFromSourceTask$receiveBody$1;
                    it = th2;
                    body.close();
                    byteChannelReplay$CopyFromSourceTask$receiveBody$12.this$1.getSavedResponse().completeExceptionally(it);
                    throw it;
                }
            } catch (Throwable th3) {
                it = th3;
                body.close();
                byteChannelReplay$CopyFromSourceTask$receiveBody$12.this$1.getSavedResponse().completeExceptionally(it);
                throw it;
            }
            $result = $result2;
            $result3 = obj;
            $this$writer2 = $this$writer;
            byteChannelReplay$CopyFromSourceTask$receiveBody$12 = byteChannelReplay$CopyFromSourceTask$receiveBody$1;
        }
        switch (r1) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$writer2 = (WriterScope) this.L$0;
                body = BytePacketBuilderKt.BytePacketBuilder();
                byteChannelReplay$CopyFromSourceTask$receiveBody$12 = this;
                byteReadChannel3 = byteChannelReplay$CopyFromSourceTask$receiveBody$12.this$0.origin;
                if (byteReadChannel3.isClosedForRead()) {
                    byteReadChannel5 = byteChannelReplay$CopyFromSourceTask$receiveBody$12.this$0.origin;
                    if (ByteReadChannelOperationsKt.getAvailableForRead(byteReadChannel5) == 0) {
                        byteReadChannel6 = byteChannelReplay$CopyFromSourceTask$receiveBody$12.this$0.origin;
                        byteChannelReplay$CopyFromSourceTask$receiveBody$12.L$0 = $this$writer2;
                        byteChannelReplay$CopyFromSourceTask$receiveBody$12.L$1 = body;
                        byteChannelReplay$CopyFromSourceTask$receiveBody$12.L$2 = null;
                        byteChannelReplay$CopyFromSourceTask$receiveBody$12.label = 1;
                        if (ByteReadChannel.DefaultImpls.awaitContent$default(byteReadChannel6, 0, (Continuation) byteChannelReplay$CopyFromSourceTask$receiveBody$12, 1, (Object) null) == $result3) {
                            return $result3;
                        }
                    }
                    byteReadChannel = byteChannelReplay$CopyFromSourceTask$receiveBody$12.this$0.origin;
                    byteReadChannel2 = byteChannelReplay$CopyFromSourceTask$receiveBody$12.this$0.origin;
                    byteChannelReplay$CopyFromSourceTask$receiveBody$12.L$0 = $this$writer2;
                    byteChannelReplay$CopyFromSourceTask$receiveBody$12.L$1 = body;
                    byteChannelReplay$CopyFromSourceTask$receiveBody$12.L$2 = null;
                    byteChannelReplay$CopyFromSourceTask$receiveBody$12.label = 2;
                    readPacket = ByteReadChannelOperationsKt.readPacket(byteReadChannel, ByteReadChannelOperationsKt.getAvailableForRead(byteReadChannel2), (Continuation) byteChannelReplay$CopyFromSourceTask$receiveBody$12);
                    if (readPacket != $result3) {
                        return $result3;
                    }
                    Object obj3 = $result3;
                    $result2 = $result;
                    $result = readPacket;
                    byteChannelReplay$CopyFromSourceTask$receiveBody$1 = byteChannelReplay$CopyFromSourceTask$receiveBody$12;
                    $this$writer = $this$writer2;
                    obj = obj3;
                    packet = (Source) $result;
                    if (!$this$writer.getChannel().isClosedForWrite()) {
                        byteChannelReplay$CopyFromSourceTask$receiveBody$1.L$0 = $this$writer;
                        byteChannelReplay$CopyFromSourceTask$receiveBody$1.L$1 = body;
                        byteChannelReplay$CopyFromSourceTask$receiveBody$1.L$2 = packet;
                        byteChannelReplay$CopyFromSourceTask$receiveBody$1.label = 3;
                        if (ByteWriteChannelOperationsKt.writePacket($this$writer.getChannel(), packet.peek(), (Continuation) byteChannelReplay$CopyFromSourceTask$receiveBody$1) == obj) {
                            return obj;
                        }
                        Object obj4 = obj;
                        r1 = packet;
                        $result = $result2;
                        $result3 = obj4;
                        try {
                        } catch (Exception e3) {
                            Object obj22 = $result3;
                            $result2 = $result;
                            packet = r1;
                            obj = obj22;
                            BytePacketBuilderKt.writePacket(body, packet);
                            $result = $result2;
                            $result3 = obj;
                            $this$writer2 = $this$writer;
                            byteChannelReplay$CopyFromSourceTask$receiveBody$12 = byteChannelReplay$CopyFromSourceTask$receiveBody$1;
                            byteReadChannel3 = byteChannelReplay$CopyFromSourceTask$receiveBody$12.this$0.origin;
                            if (byteReadChannel3.isClosedForRead()) {
                            }
                        } catch (Throwable th4) {
                            it = th4;
                            byteChannelReplay$CopyFromSourceTask$receiveBody$12 = byteChannelReplay$CopyFromSourceTask$receiveBody$1;
                            body.close();
                            byteChannelReplay$CopyFromSourceTask$receiveBody$12.this$1.getSavedResponse().completeExceptionally(it);
                            throw it;
                        }
                        byteChannelReplay$CopyFromSourceTask$receiveBody$1.L$0 = $this$writer;
                        byteChannelReplay$CopyFromSourceTask$receiveBody$1.L$1 = body;
                        byteChannelReplay$CopyFromSourceTask$receiveBody$1.L$2 = r1;
                        byteChannelReplay$CopyFromSourceTask$receiveBody$1.label = 4;
                        packet2 = r1;
                        if ($this$writer.getChannel().flush((Continuation) byteChannelReplay$CopyFromSourceTask$receiveBody$1) == $result3) {
                            return $result3;
                        }
                        Object obj5 = $result3;
                        $result2 = $result;
                        packet = packet2;
                        obj = obj5;
                    }
                    BytePacketBuilderKt.writePacket(body, packet);
                    $result = $result2;
                    $result3 = obj;
                    $this$writer2 = $this$writer;
                    byteChannelReplay$CopyFromSourceTask$receiveBody$12 = byteChannelReplay$CopyFromSourceTask$receiveBody$1;
                    byteReadChannel3 = byteChannelReplay$CopyFromSourceTask$receiveBody$12.this$0.origin;
                    if (byteReadChannel3.isClosedForRead()) {
                        byteReadChannel4 = byteChannelReplay$CopyFromSourceTask$receiveBody$12.this$0.origin;
                        Throwable it = byteReadChannel4.getClosedCause();
                        if (it == null) {
                            byteChannelReplay$CopyFromSourceTask$receiveBody$12.this$1.getSavedResponse().complete(SourcesKt.readByteArray(BytePacketBuilderKt.build(body)));
                            return Unit.INSTANCE;
                        }
                        throw it;
                    }
                }
            case 1:
                body = (Sink) this.L$1;
                $this$writer2 = (WriterScope) this.L$0;
                ResultKt.throwOnFailure($result);
                byteChannelReplay$CopyFromSourceTask$receiveBody$12 = this;
                byteReadChannel = byteChannelReplay$CopyFromSourceTask$receiveBody$12.this$0.origin;
                byteReadChannel2 = byteChannelReplay$CopyFromSourceTask$receiveBody$12.this$0.origin;
                byteChannelReplay$CopyFromSourceTask$receiveBody$12.L$0 = $this$writer2;
                byteChannelReplay$CopyFromSourceTask$receiveBody$12.L$1 = body;
                byteChannelReplay$CopyFromSourceTask$receiveBody$12.L$2 = null;
                byteChannelReplay$CopyFromSourceTask$receiveBody$12.label = 2;
                readPacket = ByteReadChannelOperationsKt.readPacket(byteReadChannel, ByteReadChannelOperationsKt.getAvailableForRead(byteReadChannel2), (Continuation) byteChannelReplay$CopyFromSourceTask$receiveBody$12);
                if (readPacket != $result3) {
                }
                break;
            case 2:
                body = (Sink) this.L$1;
                WriterScope $this$writer3 = (WriterScope) this.L$0;
                ResultKt.throwOnFailure($result);
                byteChannelReplay$CopyFromSourceTask$receiveBody$1 = this;
                $this$writer = $this$writer3;
                obj = $result3;
                $result2 = $result;
                packet = (Source) $result;
                if (!$this$writer.getChannel().isClosedForWrite()) {
                }
                BytePacketBuilderKt.writePacket(body, packet);
                $result = $result2;
                $result3 = obj;
                $this$writer2 = $this$writer;
                byteChannelReplay$CopyFromSourceTask$receiveBody$12 = byteChannelReplay$CopyFromSourceTask$receiveBody$1;
                byteReadChannel3 = byteChannelReplay$CopyFromSourceTask$receiveBody$12.this$0.origin;
                if (byteReadChannel3.isClosedForRead()) {
                }
                break;
            case 3:
                Source source = (Source) this.L$2;
                body = (Sink) this.L$1;
                $this$writer = (WriterScope) this.L$0;
                ResultKt.throwOnFailure($result);
                byteChannelReplay$CopyFromSourceTask$receiveBody$1 = this;
                r1 = source;
                byteChannelReplay$CopyFromSourceTask$receiveBody$1.L$0 = $this$writer;
                byteChannelReplay$CopyFromSourceTask$receiveBody$1.L$1 = body;
                byteChannelReplay$CopyFromSourceTask$receiveBody$1.L$2 = r1;
                byteChannelReplay$CopyFromSourceTask$receiveBody$1.label = 4;
                packet2 = r1;
                if ($this$writer.getChannel().flush((Continuation) byteChannelReplay$CopyFromSourceTask$receiveBody$1) == $result3) {
                }
                Object obj52 = $result3;
                $result2 = $result;
                packet = packet2;
                obj = obj52;
                BytePacketBuilderKt.writePacket(body, packet);
                $result = $result2;
                $result3 = obj;
                $this$writer2 = $this$writer;
                byteChannelReplay$CopyFromSourceTask$receiveBody$12 = byteChannelReplay$CopyFromSourceTask$receiveBody$1;
                byteReadChannel3 = byteChannelReplay$CopyFromSourceTask$receiveBody$12.this$0.origin;
                if (byteReadChannel3.isClosedForRead()) {
                }
                break;
            case 4:
                Source source2 = (Source) this.L$2;
                body = (Sink) this.L$1;
                $this$writer = (WriterScope) this.L$0;
                ResultKt.throwOnFailure($result);
                byteChannelReplay$CopyFromSourceTask$receiveBody$1 = this;
                packet2 = source2;
                Object obj522 = $result3;
                $result2 = $result;
                packet = packet2;
                obj = obj522;
                BytePacketBuilderKt.writePacket(body, packet);
                $result = $result2;
                $result3 = obj;
                $this$writer2 = $this$writer;
                byteChannelReplay$CopyFromSourceTask$receiveBody$12 = byteChannelReplay$CopyFromSourceTask$receiveBody$1;
                byteReadChannel3 = byteChannelReplay$CopyFromSourceTask$receiveBody$12.this$0.origin;
                if (byteReadChannel3.isClosedForRead()) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}