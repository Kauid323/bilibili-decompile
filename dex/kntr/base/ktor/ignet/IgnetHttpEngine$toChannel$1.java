package kntr.base.ktor.ignet;

import com.bilibili.lib.ighttp.IgHttpResponse;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import java.util.concurrent.CancellationException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: IgnetHttpEngine.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.ktor.ignet.IgnetHttpEngine$toChannel$1", f = "IgnetHttpEngine.kt", i = {0, 0, 0}, l = {101}, m = "invokeSuspend", n = {"$this$launch", "buffer", "lastRead"}, s = {"L$0", "L$1", "I$0"}, v = 1)
final class IgnetHttpEngine$toChannel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteChannel $responseChannel;
    final /* synthetic */ IgHttpResponse $this_toChannel;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IgnetHttpEngine$toChannel$1(IgHttpResponse igHttpResponse, ByteChannel byteChannel, Continuation<? super IgnetHttpEngine$toChannel$1> continuation) {
        super(2, continuation);
        this.$this_toChannel = igHttpResponse;
        this.$responseChannel = byteChannel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> ignetHttpEngine$toChannel$1 = new IgnetHttpEngine$toChannel$1(this.$this_toChannel, this.$responseChannel, continuation);
        ignetHttpEngine$toChannel$1.L$0 = obj;
        return ignetHttpEngine$toChannel$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
        if (r2 > 0) goto L15;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0046 -> B:24:0x0061). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005d -> B:24:0x0061). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        IgnetHttpEngine$toChannel$1 ignetHttpEngine$toChannel$1;
        IgnetHttpEngine$toChannel$1 ignetHttpEngine$toChannel$12;
        byte[] buffer;
        int lastRead;
        CoroutineScope $this$launch = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        byte[] buffer2 = new byte[32768];
                        ignetHttpEngine$toChannel$12 = this;
                        buffer = buffer2;
                        try {
                            CoroutineScopeKt.ensureActive($this$launch);
                            lastRead = ignetHttpEngine$toChannel$12.$this_toChannel.readDataV2(buffer, buffer.length);
                            if (lastRead > 0) {
                                ignetHttpEngine$toChannel$12.L$0 = $this$launch;
                                ignetHttpEngine$toChannel$12.L$1 = buffer;
                                ignetHttpEngine$toChannel$12.I$0 = lastRead;
                                ignetHttpEngine$toChannel$12.label = 1;
                                if (ByteWriteChannelOperationsKt.writeFully(ignetHttpEngine$toChannel$12.$responseChannel, buffer, 0, lastRead, (Continuation) ignetHttpEngine$toChannel$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } catch (CancellationException e) {
                            e = e;
                            KLog_androidKt.getKLog().w("IgnetHttpEngine", "Request cancelled: " + e.getMessage());
                            ignetHttpEngine$toChannel$12.$this_toChannel.close();
                            ByteWriteChannelOperationsKt.close(ignetHttpEngine$toChannel$12.$responseChannel, e);
                            ignetHttpEngine$toChannel$12.$this_toChannel.close();
                            ignetHttpEngine$toChannel$12.$responseChannel.close();
                            return Unit.INSTANCE;
                        } catch (Exception e2) {
                            e = e2;
                            KLog_androidKt.getKLog().w("IgnetHttpEngine", "Read error: " + e.getMessage());
                            ignetHttpEngine$toChannel$12.$this_toChannel.close();
                            ByteWriteChannelOperationsKt.close(ignetHttpEngine$toChannel$12.$responseChannel, e);
                            throw e;
                        }
                    } catch (CancellationException e3) {
                        e = e3;
                        ignetHttpEngine$toChannel$12 = this;
                        KLog_androidKt.getKLog().w("IgnetHttpEngine", "Request cancelled: " + e.getMessage());
                        ignetHttpEngine$toChannel$12.$this_toChannel.close();
                        ByteWriteChannelOperationsKt.close(ignetHttpEngine$toChannel$12.$responseChannel, e);
                        ignetHttpEngine$toChannel$12.$this_toChannel.close();
                        ignetHttpEngine$toChannel$12.$responseChannel.close();
                        return Unit.INSTANCE;
                    } catch (Exception e4) {
                        e = e4;
                        ignetHttpEngine$toChannel$12 = this;
                        KLog_androidKt.getKLog().w("IgnetHttpEngine", "Read error: " + e.getMessage());
                        ignetHttpEngine$toChannel$12.$this_toChannel.close();
                        ByteWriteChannelOperationsKt.close(ignetHttpEngine$toChannel$12.$responseChannel, e);
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        ignetHttpEngine$toChannel$1 = this;
                        ignetHttpEngine$toChannel$1.$this_toChannel.close();
                        ignetHttpEngine$toChannel$1.$responseChannel.close();
                        throw th;
                    }
                    break;
                case 1:
                    lastRead = this.I$0;
                    buffer = (byte[]) this.L$1;
                    try {
                        ResultKt.throwOnFailure($result);
                        ignetHttpEngine$toChannel$12 = this;
                        break;
                    } catch (CancellationException e5) {
                        e = e5;
                        ignetHttpEngine$toChannel$12 = this;
                        KLog_androidKt.getKLog().w("IgnetHttpEngine", "Request cancelled: " + e.getMessage());
                        ignetHttpEngine$toChannel$12.$this_toChannel.close();
                        ByteWriteChannelOperationsKt.close(ignetHttpEngine$toChannel$12.$responseChannel, e);
                        ignetHttpEngine$toChannel$12.$this_toChannel.close();
                        ignetHttpEngine$toChannel$12.$responseChannel.close();
                        return Unit.INSTANCE;
                    } catch (Exception e6) {
                        e = e6;
                        ignetHttpEngine$toChannel$12 = this;
                        KLog_androidKt.getKLog().w("IgnetHttpEngine", "Read error: " + e.getMessage());
                        ignetHttpEngine$toChannel$12.$this_toChannel.close();
                        ByteWriteChannelOperationsKt.close(ignetHttpEngine$toChannel$12.$responseChannel, e);
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        ignetHttpEngine$toChannel$1 = this;
                        ignetHttpEngine$toChannel$1.$this_toChannel.close();
                        ignetHttpEngine$toChannel$1.$responseChannel.close();
                        throw th;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}