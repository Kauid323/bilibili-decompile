package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.shadow.text.TextAttributes;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Sink;

/* compiled from: CountedByteWriteChannel.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b\b\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\rR\u001c\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0018\u001a\u00020\u00148F¢\u0006\f\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010#\u001a\u00020\u001f8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0012\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lio/ktor/utils/io/CountedByteWriteChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "delegate", "<init>", "(Lio/ktor/utils/io/ByteWriteChannel;)V", "", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flushAndClose", "", "cause", "cancel", "(Ljava/lang/Throwable;)V", "Lio/ktor/utils/io/ByteWriteChannel;", "", "initial", TextAttributes.INLINE_IMAGE_PLACEHOLDER, "getInitial$annotations", "()V", "flushedCount", "", "getTotalBytesWritten", "()J", "getTotalBytesWritten$annotations", "totalBytesWritten", "", "isClosedForWrite", "()Z", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "Lkotlinx/io/Sink;", "getWriteBuffer", "()Lkotlinx/io/Sink;", "getWriteBuffer$annotations", "writeBuffer", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class CountedByteWriteChannel implements ByteWriteChannel {
    private final ByteWriteChannel delegate;
    private int flushedCount;
    private int initial;

    private static /* synthetic */ void getInitial$annotations() {
    }

    public static /* synthetic */ void getTotalBytesWritten$annotations() {
    }

    @InternalAPI
    public static /* synthetic */ void getWriteBuffer$annotations() {
    }

    public CountedByteWriteChannel(ByteWriteChannel delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.initial = BytePacketBuilderKt.getSize(this.delegate.getWriteBuffer());
    }

    public final long getTotalBytesWritten() {
        return (this.flushedCount + BytePacketBuilderKt.getSize(getWriteBuffer())) - this.initial;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean isClosedForWrite() {
        return this.delegate.isClosedForWrite();
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Throwable getClosedCause() {
        return this.delegate.getClosedCause();
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Sink getWriteBuffer() {
        return this.delegate.getWriteBuffer();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    @Override // io.ktor.utils.io.ByteWriteChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object flush(Continuation<? super Unit> continuation) {
        CountedByteWriteChannel$flush$1 countedByteWriteChannel$flush$1;
        CountedByteWriteChannel countedByteWriteChannel;
        if (continuation instanceof CountedByteWriteChannel$flush$1) {
            countedByteWriteChannel$flush$1 = (CountedByteWriteChannel$flush$1) continuation;
            if ((countedByteWriteChannel$flush$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                countedByteWriteChannel$flush$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = countedByteWriteChannel$flush$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (countedByteWriteChannel$flush$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.flushedCount += BytePacketBuilderKt.getSize(getWriteBuffer());
                        ByteWriteChannel byteWriteChannel = this.delegate;
                        countedByteWriteChannel$flush$1.L$0 = this;
                        countedByteWriteChannel$flush$1.label = 1;
                        if (byteWriteChannel.flush(countedByteWriteChannel$flush$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        countedByteWriteChannel = this;
                        break;
                    case 1:
                        countedByteWriteChannel = (CountedByteWriteChannel) countedByteWriteChannel$flush$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                countedByteWriteChannel.initial = BytePacketBuilderKt.getSize(countedByteWriteChannel.getWriteBuffer());
                return Unit.INSTANCE;
            }
        }
        countedByteWriteChannel$flush$1 = new CountedByteWriteChannel$flush$1(this, continuation);
        Object $result2 = countedByteWriteChannel$flush$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (countedByteWriteChannel$flush$1.label) {
        }
        countedByteWriteChannel.initial = BytePacketBuilderKt.getSize(countedByteWriteChannel.getWriteBuffer());
        return Unit.INSTANCE;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object flushAndClose(Continuation<? super Unit> continuation) {
        Object flushAndClose = this.delegate.flushAndClose(continuation);
        return flushAndClose == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? flushAndClose : Unit.INSTANCE;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public void cancel(Throwable cause) {
        this.delegate.cancel(cause);
    }
}