package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import io.ktor.utils.io.core.ByteReadPacketKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Source;
import kotlinx.io.SourcesKt;

/* compiled from: LookAheadSession.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/utils/io/LookAheadSuspendSession;", "", "Lio/ktor/utils/io/ByteReadChannel;", "channel", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;)V", "", "skip", "atLeast", "Ljava/nio/ByteBuffer;", "request", "(II)Ljava/nio/ByteBuffer;", "min", "", "awaitAtLeast", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "count", "", "consumed", "(I)V", "Lio/ktor/utils/io/ByteReadChannel;", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class LookAheadSuspendSession {
    private final ByteReadChannel channel;

    public LookAheadSuspendSession(ByteReadChannel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.channel = channel;
    }

    public final ByteBuffer request(int skip, int atLeast) {
        if (ByteReadPacketKt.getRemaining(this.channel.mo1388getReadBuffer()) < skip + atLeast) {
            return null;
        }
        ByteBuffer buffer = (ByteBuffer) ByteReadPacketKt.preview(this.channel.mo1388getReadBuffer(), new Function1() { // from class: io.ktor.utils.io.LookAheadSuspendSession$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                ByteBuffer request$lambda$0;
                request$lambda$0 = LookAheadSuspendSession.request$lambda$0((Source) obj);
                return request$lambda$0;
            }
        });
        if (skip > 0) {
            buffer.position(buffer.position() + skip);
        }
        return buffer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteBuffer request$lambda$0(Source it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ByteBuffer.wrap(SourcesKt.readByteArray(it));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitAtLeast(int min, Continuation<? super Boolean> continuation) {
        LookAheadSuspendSession$awaitAtLeast$1 lookAheadSuspendSession$awaitAtLeast$1;
        LookAheadSuspendSession lookAheadSuspendSession;
        if (continuation instanceof LookAheadSuspendSession$awaitAtLeast$1) {
            lookAheadSuspendSession$awaitAtLeast$1 = (LookAheadSuspendSession$awaitAtLeast$1) continuation;
            if ((lookAheadSuspendSession$awaitAtLeast$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                lookAheadSuspendSession$awaitAtLeast$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = lookAheadSuspendSession$awaitAtLeast$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (lookAheadSuspendSession$awaitAtLeast$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (ByteReadPacketKt.getRemaining(this.channel.mo1388getReadBuffer()) < min) {
                            ByteReadChannel byteReadChannel = this.channel;
                            lookAheadSuspendSession$awaitAtLeast$1.L$0 = this;
                            lookAheadSuspendSession$awaitAtLeast$1.I$0 = min;
                            lookAheadSuspendSession$awaitAtLeast$1.label = 1;
                            if (byteReadChannel.awaitContent(min, lookAheadSuspendSession$awaitAtLeast$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            lookAheadSuspendSession = this;
                            break;
                        } else {
                            return Boxing.boxBoolean(true);
                        }
                    case 1:
                        min = lookAheadSuspendSession$awaitAtLeast$1.I$0;
                        lookAheadSuspendSession = (LookAheadSuspendSession) lookAheadSuspendSession$awaitAtLeast$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Boxing.boxBoolean(ByteReadPacketKt.getRemaining(lookAheadSuspendSession.channel.mo1388getReadBuffer()) >= ((long) min));
            }
        }
        lookAheadSuspendSession$awaitAtLeast$1 = new LookAheadSuspendSession$awaitAtLeast$1(this, continuation);
        Object $result2 = lookAheadSuspendSession$awaitAtLeast$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (lookAheadSuspendSession$awaitAtLeast$1.label) {
        }
        return Boxing.boxBoolean(ByteReadPacketKt.getRemaining(lookAheadSuspendSession.channel.mo1388getReadBuffer()) >= ((long) min));
    }

    public final void consumed(int count) {
        ByteReadPacketKt.discard(this.channel.mo1388getReadBuffer(), count);
    }
}