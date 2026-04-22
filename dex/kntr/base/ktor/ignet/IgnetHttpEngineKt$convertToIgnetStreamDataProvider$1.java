package kntr.base.ktor.ignet;

import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import java.util.Arrays;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IgnetHttpEngine.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.ktor.ignet.IgnetHttpEngineKt$convertToIgnetStreamDataProvider$1", f = "IgnetHttpEngine.kt", i = {0, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4}, l = {238, 247, 249, 261, 263}, m = "invokeSuspend", n = {"data", "channel", "buffer", "channel", "buffer", "bytesRead", "writeChannel", "buffer", "writeChannel", "buffer", "bytesRead"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "L$1", "I$0"}, v = 1)
public final class IgnetHttpEngineKt$convertToIgnetStreamDataProvider$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineContext $callContext;
    final /* synthetic */ Channel<byte[]> $dataChannel;
    final /* synthetic */ OutgoingContent $this_convertToIgnetStreamDataProvider;
    int I$0;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IgnetHttpEngineKt$convertToIgnetStreamDataProvider$1(OutgoingContent outgoingContent, Channel<byte[]> channel, CoroutineContext coroutineContext, Continuation<? super IgnetHttpEngineKt$convertToIgnetStreamDataProvider$1> continuation) {
        super(2, continuation);
        this.$this_convertToIgnetStreamDataProvider = outgoingContent;
        this.$dataChannel = channel;
        this.$callContext = coroutineContext;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IgnetHttpEngineKt$convertToIgnetStreamDataProvider$1(this.$this_convertToIgnetStreamDataProvider, this.$dataChannel, this.$callContext, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00c4 A[Catch: Exception -> 0x0115, TryCatch #2 {Exception -> 0x0115, blocks: (B:64:0x0145, B:66:0x014b, B:70:0x016c, B:72:0x0174, B:78:0x019c, B:42:0x00be, B:44:0x00c4, B:48:0x00e5, B:50:0x00ed, B:58:0x0118), top: B:91:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ed A[Catch: Exception -> 0x0115, TryCatch #2 {Exception -> 0x0115, blocks: (B:64:0x0145, B:66:0x014b, B:70:0x016c, B:72:0x0174, B:78:0x019c, B:42:0x00be, B:44:0x00c4, B:48:0x00e5, B:50:0x00ed, B:58:0x0118), top: B:91:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x014b A[Catch: Exception -> 0x0115, TryCatch #2 {Exception -> 0x0115, blocks: (B:64:0x0145, B:66:0x014b, B:70:0x016c, B:72:0x0174, B:78:0x019c, B:42:0x00be, B:44:0x00c4, B:48:0x00e5, B:50:0x00ed, B:58:0x0118), top: B:91:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0174 A[Catch: Exception -> 0x0115, TryCatch #2 {Exception -> 0x0115, blocks: (B:64:0x0145, B:66:0x014b, B:70:0x016c, B:72:0x0174, B:78:0x019c, B:42:0x00be, B:44:0x00c4, B:48:0x00e5, B:50:0x00ed, B:58:0x0118), top: B:91:0x000e }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x010d -> B:54:0x0112). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0194 -> B:76:0x0199). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        IgnetHttpEngineKt$convertToIgnetStreamDataProvider$1 ignetHttpEngineKt$convertToIgnetStreamDataProvider$1;
        Object $result2;
        IgnetHttpEngineKt$convertToIgnetStreamDataProvider$1 ignetHttpEngineKt$convertToIgnetStreamDataProvider$12;
        ByteReadChannel writeChannel;
        Object $result3;
        IgnetHttpEngineKt$convertToIgnetStreamDataProvider$1 ignetHttpEngineKt$convertToIgnetStreamDataProvider$13;
        ByteReadChannel channel;
        Object $result4;
        byte[] data;
        byte[] buffer;
        Object obj;
        int bytesRead;
        Object $result5;
        byte[] buffer2;
        Object obj2;
        int bytesRead2;
        Object $result6;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
            } catch (Exception e) {
                e = e;
                ignetHttpEngineKt$convertToIgnetStreamDataProvider$1 = this;
            }
        } catch (Exception e2) {
            e = e2;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    $result2 = this.$this_convertToIgnetStreamDataProvider;
                } catch (Exception e3) {
                    e = e3;
                    ignetHttpEngineKt$convertToIgnetStreamDataProvider$1 = this;
                    KLog_androidKt.getKLog().w("IgnetHttpEngine", "convertToIgnetStreamDataProvider error: " + e.getMessage());
                    ignetHttpEngineKt$convertToIgnetStreamDataProvider$1.$dataChannel.close(e);
                    return Unit.INSTANCE;
                }
                if ($result2 instanceof OutgoingContent.ByteArrayContent) {
                    byte[] data2 = this.$this_convertToIgnetStreamDataProvider.bytes();
                    if (!(data2.length == 0)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        this.label = 1;
                        if (this.$dataChannel.send(data2, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        data = data2;
                    }
                    SendChannel.DefaultImpls.close$default(this.$dataChannel, (Throwable) null, 1, (Object) null);
                    return Unit.INSTANCE;
                } else if ($result2 instanceof OutgoingContent.ReadChannelContent) {
                    ignetHttpEngineKt$convertToIgnetStreamDataProvider$13 = this;
                    channel = this.$this_convertToIgnetStreamDataProvider.readFrom();
                    $result4 = $result;
                    if (!channel.isClosedForRead()) {
                        byte[] buffer3 = new byte[65536];
                        ignetHttpEngineKt$convertToIgnetStreamDataProvider$13.L$0 = channel;
                        ignetHttpEngineKt$convertToIgnetStreamDataProvider$13.L$1 = buffer3;
                        ignetHttpEngineKt$convertToIgnetStreamDataProvider$13.label = 2;
                        obj = ByteReadChannelOperationsKt.readAvailable$default(channel, buffer3, 0, 0, (Continuation) ignetHttpEngineKt$convertToIgnetStreamDataProvider$13, 6, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        buffer = buffer3;
                        bytesRead = ((Number) obj).intValue();
                        if (bytesRead <= 0) {
                            Channel<byte[]> channel2 = ignetHttpEngineKt$convertToIgnetStreamDataProvider$13.$dataChannel;
                            byte[] copyOf = Arrays.copyOf(buffer, bytesRead);
                            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                            ignetHttpEngineKt$convertToIgnetStreamDataProvider$13.L$0 = channel;
                            ignetHttpEngineKt$convertToIgnetStreamDataProvider$13.L$1 = SpillingKt.nullOutSpilledVariable(buffer);
                            ignetHttpEngineKt$convertToIgnetStreamDataProvider$13.I$0 = bytesRead;
                            ignetHttpEngineKt$convertToIgnetStreamDataProvider$13.label = 3;
                            if (channel2.send(copyOf, (Continuation) ignetHttpEngineKt$convertToIgnetStreamDataProvider$13) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result5 = $result4;
                            $result4 = $result5;
                            if (!channel.isClosedForRead()) {
                            }
                        }
                    }
                    SendChannel.DefaultImpls.close$default(ignetHttpEngineKt$convertToIgnetStreamDataProvider$13.$dataChannel, (Throwable) null, 1, (Object) null);
                    return Unit.INSTANCE;
                } else if (!($result2 instanceof OutgoingContent.WriteChannelContent)) {
                    if ($result2 instanceof OutgoingContent.NoContent) {
                        SendChannel.DefaultImpls.close$default(this.$dataChannel, (Throwable) null, 1, (Object) null);
                    } else {
                        this.$dataChannel.close(new UnsupportedOperationException("Unsupported OutgoingContent type: " + this.$this_convertToIgnetStreamDataProvider.getClass()));
                    }
                    return Unit.INSTANCE;
                } else {
                    ignetHttpEngineKt$convertToIgnetStreamDataProvider$12 = this;
                    writeChannel = ByteWriteChannelOperationsKt.writer$default(GlobalScope.INSTANCE, this.$callContext, false, new IgnetHttpEngineKt$convertToIgnetStreamDataProvider$1$writeChannel$1(this.$this_convertToIgnetStreamDataProvider, null), 2, (Object) null).getChannel();
                    $result3 = $result;
                    if (!writeChannel.isClosedForRead()) {
                        byte[] buffer4 = new byte[65536];
                        ignetHttpEngineKt$convertToIgnetStreamDataProvider$12.L$0 = writeChannel;
                        ignetHttpEngineKt$convertToIgnetStreamDataProvider$12.L$1 = buffer4;
                        ignetHttpEngineKt$convertToIgnetStreamDataProvider$12.label = 4;
                        obj2 = ByteReadChannelOperationsKt.readAvailable$default(writeChannel, buffer4, 0, 0, (Continuation) ignetHttpEngineKt$convertToIgnetStreamDataProvider$12, 6, (Object) null);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        buffer2 = buffer4;
                        bytesRead2 = ((Number) obj2).intValue();
                        if (bytesRead2 > 0) {
                            Channel<byte[]> channel3 = ignetHttpEngineKt$convertToIgnetStreamDataProvider$12.$dataChannel;
                            byte[] copyOf2 = Arrays.copyOf(buffer2, bytesRead2);
                            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
                            ignetHttpEngineKt$convertToIgnetStreamDataProvider$12.L$0 = writeChannel;
                            ignetHttpEngineKt$convertToIgnetStreamDataProvider$12.L$1 = SpillingKt.nullOutSpilledVariable(buffer2);
                            ignetHttpEngineKt$convertToIgnetStreamDataProvider$12.I$0 = bytesRead2;
                            ignetHttpEngineKt$convertToIgnetStreamDataProvider$12.label = 5;
                            if (channel3.send(copyOf2, (Continuation) ignetHttpEngineKt$convertToIgnetStreamDataProvider$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result6 = $result3;
                            $result3 = $result6;
                            if (!writeChannel.isClosedForRead()) {
                            }
                        }
                    }
                    SendChannel.DefaultImpls.close$default(ignetHttpEngineKt$convertToIgnetStreamDataProvider$12.$dataChannel, (Throwable) null, 1, (Object) null);
                    return Unit.INSTANCE;
                }
            case 1:
                data = (byte[]) this.L$0;
                ResultKt.throwOnFailure($result);
                SendChannel.DefaultImpls.close$default(this.$dataChannel, (Throwable) null, 1, (Object) null);
                return Unit.INSTANCE;
            case 2:
                byte[] buffer5 = (byte[]) this.L$1;
                ByteReadChannel channel4 = (ByteReadChannel) this.L$0;
                ResultKt.throwOnFailure($result);
                ignetHttpEngineKt$convertToIgnetStreamDataProvider$13 = this;
                buffer = buffer5;
                channel = channel4;
                $result4 = $result;
                obj = $result4;
                bytesRead = ((Number) obj).intValue();
                if (bytesRead <= 0) {
                }
                break;
            case 3:
                int i = this.I$0;
                byte[] bArr = (byte[]) this.L$1;
                ByteReadChannel channel5 = (ByteReadChannel) this.L$0;
                ResultKt.throwOnFailure($result);
                ignetHttpEngineKt$convertToIgnetStreamDataProvider$13 = this;
                channel = channel5;
                $result5 = $result;
                $result4 = $result5;
                if (!channel.isClosedForRead()) {
                }
                SendChannel.DefaultImpls.close$default(ignetHttpEngineKt$convertToIgnetStreamDataProvider$13.$dataChannel, (Throwable) null, 1, (Object) null);
                return Unit.INSTANCE;
            case 4:
                byte[] buffer6 = (byte[]) this.L$1;
                ByteReadChannel writeChannel2 = (ByteReadChannel) this.L$0;
                ResultKt.throwOnFailure($result);
                ignetHttpEngineKt$convertToIgnetStreamDataProvider$12 = this;
                buffer2 = buffer6;
                writeChannel = writeChannel2;
                $result3 = $result;
                obj2 = $result3;
                bytesRead2 = ((Number) obj2).intValue();
                if (bytesRead2 > 0) {
                }
                SendChannel.DefaultImpls.close$default(ignetHttpEngineKt$convertToIgnetStreamDataProvider$12.$dataChannel, (Throwable) null, 1, (Object) null);
                return Unit.INSTANCE;
            case 5:
                int i2 = this.I$0;
                byte[] bArr2 = (byte[]) this.L$1;
                ByteReadChannel writeChannel3 = (ByteReadChannel) this.L$0;
                ResultKt.throwOnFailure($result);
                ignetHttpEngineKt$convertToIgnetStreamDataProvider$12 = this;
                writeChannel = writeChannel3;
                $result6 = $result;
                $result3 = $result6;
                if (!writeChannel.isClosedForRead()) {
                }
                SendChannel.DefaultImpls.close$default(ignetHttpEngineKt$convertToIgnetStreamDataProvider$12.$dataChannel, (Throwable) null, 1, (Object) null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}