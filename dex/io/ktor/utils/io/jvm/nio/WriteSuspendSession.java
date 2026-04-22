package io.ktor.utils.io.jvm.nio;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.StyleConstants;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperations_jvmKt;
import io.ktor.utils.io.core.OutputArraysJVMKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Sink;

/* compiled from: WriteSuspendSession.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\n \u0014*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/ktor/utils/io/jvm/nio/WriteSuspendSession;", "", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "<init>", "(Lio/ktor/utils/io/ByteWriteChannel;)V", "", "count", "Ljava/nio/ByteBuffer;", "request", "(I)Ljava/nio/ByteBuffer;", "", "tryAwait", "(I)V", "rc", "written", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteWriteChannel;", "getChannel", "()Lio/ktor/utils/io/ByteWriteChannel;", "kotlin.jvm.PlatformType", "byteBuffer", "Ljava/nio/ByteBuffer;", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class WriteSuspendSession {
    private final ByteBuffer byteBuffer;
    private final ByteWriteChannel channel;

    public WriteSuspendSession(ByteWriteChannel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.byteBuffer = ByteBuffer.allocate(StyleConstants.TRANSFORM_SKEW_X);
    }

    public final ByteWriteChannel getChannel() {
        return this.channel;
    }

    public final ByteBuffer request(int count) {
        return this.byteBuffer;
    }

    public final void tryAwait(int count) {
        Sink writeBuffer = this.channel.getWriteBuffer();
        ByteBuffer byteBuffer = this.byteBuffer;
        Intrinsics.checkNotNullExpressionValue(byteBuffer, "byteBuffer");
        OutputArraysJVMKt.writeByteBuffer(writeBuffer, byteBuffer);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0069 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object written(int i, Continuation<? super Unit> continuation) {
        WriteSuspendSession$written$1 writeSuspendSession$written$1;
        WriteSuspendSession writeSuspendSession;
        ByteWriteChannel byteWriteChannel;
        if (continuation instanceof WriteSuspendSession$written$1) {
            writeSuspendSession$written$1 = (WriteSuspendSession$written$1) continuation;
            if ((writeSuspendSession$written$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                writeSuspendSession$written$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = writeSuspendSession$written$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (writeSuspendSession$written$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        writeSuspendSession = this;
                        writeSuspendSession.byteBuffer.flip();
                        ByteWriteChannel byteWriteChannel2 = writeSuspendSession.channel;
                        ByteBuffer byteBuffer = writeSuspendSession.byteBuffer;
                        Intrinsics.checkNotNullExpressionValue(byteBuffer, "byteBuffer");
                        writeSuspendSession$written$1.L$0 = writeSuspendSession;
                        writeSuspendSession$written$1.label = 1;
                        if (ByteWriteChannelOperations_jvmKt.writeFully(byteWriteChannel2, byteBuffer, writeSuspendSession$written$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        writeSuspendSession.byteBuffer.clear();
                        byteWriteChannel = writeSuspendSession.channel;
                        writeSuspendSession$written$1.L$0 = null;
                        writeSuspendSession$written$1.label = 2;
                        if (byteWriteChannel.flush(writeSuspendSession$written$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        writeSuspendSession = (WriteSuspendSession) writeSuspendSession$written$1.L$0;
                        ResultKt.throwOnFailure($result);
                        writeSuspendSession.byteBuffer.clear();
                        byteWriteChannel = writeSuspendSession.channel;
                        writeSuspendSession$written$1.L$0 = null;
                        writeSuspendSession$written$1.label = 2;
                        if (byteWriteChannel.flush(writeSuspendSession$written$1) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        writeSuspendSession$written$1 = new WriteSuspendSession$written$1(this, continuation);
        Object $result2 = writeSuspendSession$written$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (writeSuspendSession$written$1.label) {
        }
    }
}