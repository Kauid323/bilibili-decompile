package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Buffer;

/* compiled from: CountedByteReadChannel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0011\u0010\u001d\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001a\u0010&\u001a\u00020\u00148VX\u0097\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0010\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lio/ktor/utils/io/CountedByteReadChannel;", "Lio/ktor/utils/io/ByteReadChannel;", "delegate", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;)V", "", "min", "", "awaitContent", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)V", "updateConsumed", "()V", "Lio/ktor/utils/io/ByteReadChannel;", "getDelegate", "()Lio/ktor/utils/io/ByteReadChannel;", "Lkotlinx/io/Buffer;", "buffer", "Lkotlinx/io/Buffer;", "", "initial", "J", "consumed", "getTotalBytesRead", "()J", "totalBytesRead", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "isClosedForRead", "()Z", "getReadBuffer", "()Lkotlinx/io/Buffer;", "getReadBuffer$annotations", "readBuffer", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class CountedByteReadChannel implements ByteReadChannel {
    private final Buffer buffer;
    private long consumed;
    private final ByteReadChannel delegate;
    private long initial;

    @InternalAPI
    public static /* synthetic */ void getReadBuffer$annotations() {
    }

    public CountedByteReadChannel(ByteReadChannel delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.buffer = new Buffer();
    }

    public final ByteReadChannel getDelegate() {
        return this.delegate;
    }

    public final long getTotalBytesRead() {
        updateConsumed();
        return this.consumed;
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public Throwable getClosedCause() {
        return this.delegate.getClosedCause();
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public boolean isClosedForRead() {
        return this.buffer.exhausted() && this.delegate.isClosedForRead();
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    /* renamed from: getReadBuffer */
    public Buffer mo1388getReadBuffer() {
        updateConsumed();
        long appended = this.buffer.transferFrom(this.delegate.mo1388getReadBuffer());
        this.initial += appended;
        return this.buffer;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object awaitContent(int min, Continuation<? super Boolean> continuation) {
        return mo1388getReadBuffer().getSize() < ((long) min) ? this.delegate.awaitContent(min, continuation) : Boxing.boxBoolean(true);
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public void cancel(Throwable cause) {
        this.delegate.cancel(cause);
        this.buffer.close();
    }

    private final void updateConsumed() {
        this.consumed += this.initial - this.buffer.getSize();
        this.initial = this.buffer.getSize();
    }
}