package kntr.base.ktor.ignet;

import io.ktor.client.content.ProgressListener;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;

/* compiled from: IgnetHttpEngine.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.ktor.ignet.IgnetHttpEngineKt$convertToIgnetStreamDataProvider$2$onProduceData$1", f = "IgnetHttpEngine.kt", i = {1, 1, 1, 1, 1}, l = {294, 300}, m = "invokeSuspend", n = {"chunk", "it", "listener", "$i$a$-let-IgnetHttpEngineKt$convertToIgnetStreamDataProvider$2$onProduceData$1$1", "$i$a$-let-IgnetHttpEngineKt$convertToIgnetStreamDataProvider$2$onProduceData$1$1$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
final class IgnetHttpEngineKt$convertToIgnetStreamDataProvider$2$onProduceData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
    final /* synthetic */ Channel<byte[]> $dataChannel;
    final /* synthetic */ AtomicBoolean $isClosed;
    final /* synthetic */ long $totalSize;
    final /* synthetic */ ProgressListener $uploadListener;
    final /* synthetic */ Ref.LongRef $uploadedBytes;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IgnetHttpEngineKt$convertToIgnetStreamDataProvider$2$onProduceData$1(Channel<byte[]> channel, AtomicBoolean atomicBoolean, Ref.LongRef longRef, ProgressListener progressListener, long j, Continuation<? super IgnetHttpEngineKt$convertToIgnetStreamDataProvider$2$onProduceData$1> continuation) {
        super(2, continuation);
        this.$dataChannel = channel;
        this.$isClosed = atomicBoolean;
        this.$uploadedBytes = longRef;
        this.$uploadListener = progressListener;
        this.$totalSize = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IgnetHttpEngineKt$convertToIgnetStreamDataProvider$2$onProduceData$1(this.$dataChannel, this.$isClosed, this.$uploadedBytes, this.$uploadListener, this.$totalSize, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0055 A[Catch: Exception -> 0x0034, ClosedReceiveChannelException -> 0x0037, TRY_LEAVE, TryCatch #2 {Exception -> 0x0034, blocks: (B:33:0x0091, B:11:0x0029, B:21:0x004c, B:23:0x0055, B:18:0x003e), top: B:46:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object obj;
        byte[] chunk;
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        obj = this.$dataChannel.receiveCatching-JP2dKIU((Continuation) this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        chunk = (byte[]) ChannelResult.getOrNull-impl(obj);
                        if (chunk == null) {
                            Ref.LongRef longRef = this.$uploadedBytes;
                            ProgressListener listener = this.$uploadListener;
                            long j = this.$totalSize;
                            longRef.element += chunk.length;
                            if (listener != null) {
                                try {
                                    long j2 = longRef.element;
                                    Long boxLong = Boxing.boxLong(j);
                                    this.L$0 = chunk;
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(chunk);
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(listener);
                                    this.I$0 = 0;
                                    this.I$1 = 0;
                                    this.label = 2;
                                    if (listener.onProgress(j2, boxLong, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    i = 0;
                                    return chunk;
                                } catch (Exception e) {
                                    e = e;
                                    i = 0;
                                    KLog_androidKt.getKLog().w("IgnetHttpEngine", "Upload progress listener error: " + e.getMessage());
                                    return chunk;
                                }
                            }
                            return chunk;
                        }
                        return chunk;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        obj = ((ChannelResult) $result).unbox-impl();
                        chunk = (byte[]) ChannelResult.getOrNull-impl(obj);
                        if (chunk == null) {
                        }
                        break;
                    case 2:
                        int i2 = this.I$1;
                        i = this.I$0;
                        ProgressListener progressListener = (ProgressListener) this.L$2;
                        byte[] bArr = (byte[]) this.L$1;
                        chunk = (byte[]) this.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            return chunk;
                        } catch (Exception e2) {
                            e = e2;
                            KLog_androidKt.getKLog().w("IgnetHttpEngine", "Upload progress listener error: " + e.getMessage());
                            return chunk;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e3) {
                this.$isClosed.set(true);
                throw new IOException("Failed to read stream", e3);
            }
        } catch (ClosedReceiveChannelException e4) {
            this.$isClosed.set(true);
            return null;
        }
    }
}