package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.io.Sink;

/* compiled from: ByteWriteChannel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "", "", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flushAndClose", "", "cause", "cancel", "(Ljava/lang/Throwable;)V", "", "isClosedForWrite", "()Z", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "Lkotlinx/io/Sink;", "getWriteBuffer", "()Lkotlinx/io/Sink;", "getWriteBuffer$annotations", "()V", "writeBuffer", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public interface ByteWriteChannel {

    /* compiled from: ByteWriteChannel.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
    /* loaded from: /data/np/file-convert/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7.dex */
    public static final class DefaultImpls {
        @InternalAPI
        public static /* synthetic */ void getWriteBuffer$annotations() {
        }
    }

    void cancel(Throwable th);

    Object flush(Continuation<? super Unit> continuation);

    Object flushAndClose(Continuation<? super Unit> continuation);

    Throwable getClosedCause();

    Sink getWriteBuffer();

    boolean isClosedForWrite();
}