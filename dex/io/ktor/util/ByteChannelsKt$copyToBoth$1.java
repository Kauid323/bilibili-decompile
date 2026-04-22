package io.ktor.util;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.io.Source;

/* compiled from: ByteChannels.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.ByteChannelsKt$copyToBoth$1", f = "ByteChannels.kt", i = {1}, l = {62, 64, 65, 79, 80, 79, 80, 79, 80}, m = "invokeSuspend", n = {"it"}, s = {"L$4"})
final class ByteChannelsKt$copyToBoth$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteWriteChannel $first;
    final /* synthetic */ ByteWriteChannel $second;
    final /* synthetic */ ByteReadChannel $this_copyToBoth;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelsKt$copyToBoth$1(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, ByteWriteChannel byteWriteChannel2, Continuation<? super ByteChannelsKt$copyToBoth$1> continuation) {
        super(2, continuation);
        this.$this_copyToBoth = byteReadChannel;
        this.$first = byteWriteChannel;
        this.$second = byteWriteChannel2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ByteChannelsKt$copyToBoth$1(this.$this_copyToBoth, this.$first, this.$second, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:45|48|49|50|51|52|(1:54)(4:55|56|57|(1:59)(10:60|30|31|32|33|34|35|(2:37|39)|91|(0)(0)))) */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0118, code lost:
        r7 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0119, code lost:
        r11 = r3;
        r3 = r13;
        r13 = r0;
        r0 = r1;
        r8 = r6;
        r6 = r4;
        r4 = r11;
     */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0135: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY] A[D('this' io.ktor.util.ByteChannelsKt$copyToBoth$1)]), block:B:59:0x0135 */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0098 A[Catch: all -> 0x0182, TryCatch #1 {all -> 0x0182, blocks: (B:26:0x0090, B:28:0x0098, B:30:0x00a0, B:32:0x00a8, B:72:0x014e, B:82:0x0181), top: B:106:0x0090 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0110 -> B:113:0x012c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x012a -> B:113:0x012c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ByteChannelsKt$copyToBoth$1 byteChannelsKt$copyToBoth$1;
        Continuation continuation;
        Object obj;
        Throwable th;
        Object obj2;
        Object $result2;
        ByteChannelsKt$copyToBoth$1 byteChannelsKt$copyToBoth$12;
        Source it;
        Source source;
        Throwable cause;
        ByteReadChannel byteReadChannel;
        ByteChannelsKt$copyToBoth$1 byteChannelsKt$copyToBoth$13;
        ByteWriteChannel byteWriteChannel;
        ByteWriteChannel byteWriteChannel2;
        ByteWriteChannel byteWriteChannel3;
        ByteReadChannel byteReadChannel2;
        Source source2;
        Source copy;
        Source source3;
        ByteWriteChannel byteWriteChannel4;
        ByteReadChannel byteReadChannel3;
        Source copy2;
        Throwable it2;
        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Throwable th2) {
            cause = th2;
            continuation = byteChannelsKt$copyToBoth$1;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                byteChannelsKt$copyToBoth$12 = this;
                try {
                } catch (Throwable it3) {
                    continuation = byteChannelsKt$copyToBoth$12;
                    cause = it3;
                    try {
                        ByteWriteChannelOperationsKt.close(continuation.$first, cause);
                        ByteWriteChannelOperationsKt.close(continuation.$second, cause);
                        continuation.L$0 = null;
                        continuation.L$1 = null;
                        continuation.L$2 = null;
                        continuation.L$3 = null;
                        continuation.L$4 = null;
                        continuation.label = 6;
                        if (continuation.$first.flushAndClose(continuation) == $result3) {
                            return $result3;
                        }
                        continuation.label = 7;
                        if (continuation.$second.flushAndClose((Continuation) continuation) != $result3) {
                        }
                    } catch (Throwable th3) {
                        continuation.L$0 = th3;
                        continuation.L$1 = null;
                        continuation.L$2 = null;
                        continuation.L$3 = null;
                        continuation.L$4 = null;
                        continuation.label = 8;
                        if (continuation.$first.flushAndClose(continuation) != $result3) {
                            obj = $result3;
                            th = th3;
                            break;
                        } else {
                            return $result3;
                        }
                    }
                }
                if (!byteChannelsKt$copyToBoth$12.$this_copyToBoth.isClosedForRead() || (byteChannelsKt$copyToBoth$12.$first.isClosedForWrite() && byteChannelsKt$copyToBoth$12.$second.isClosedForWrite())) {
                    it2 = byteChannelsKt$copyToBoth$12.$this_copyToBoth.getClosedCause();
                    if (it2 != null) {
                        throw it2;
                    }
                    byteChannelsKt$copyToBoth$12.L$0 = null;
                    byteChannelsKt$copyToBoth$12.L$1 = null;
                    byteChannelsKt$copyToBoth$12.L$2 = null;
                    byteChannelsKt$copyToBoth$12.L$3 = null;
                    byteChannelsKt$copyToBoth$12.L$4 = null;
                    byteChannelsKt$copyToBoth$12.label = 4;
                    if (byteChannelsKt$copyToBoth$12.$first.flushAndClose((Continuation) byteChannelsKt$copyToBoth$12) == $result3) {
                        return $result3;
                    }
                    byteChannelsKt$copyToBoth$12.label = 5;
                    if (byteChannelsKt$copyToBoth$12.$second.flushAndClose((Continuation) byteChannelsKt$copyToBoth$12) == $result3) {
                        return $result3;
                    }
                }
                byteChannelsKt$copyToBoth$12.L$0 = null;
                byteChannelsKt$copyToBoth$12.L$1 = null;
                byteChannelsKt$copyToBoth$12.L$2 = null;
                byteChannelsKt$copyToBoth$12.L$3 = null;
                byteChannelsKt$copyToBoth$12.L$4 = null;
                byteChannelsKt$copyToBoth$12.label = 1;
                Object readRemaining = ByteReadChannelOperationsKt.readRemaining(byteChannelsKt$copyToBoth$12.$this_copyToBoth, 4096L, (Continuation) byteChannelsKt$copyToBoth$12);
                if (readRemaining == $result3) {
                    return $result3;
                }
                try {
                    Object obj3 = $result3;
                    $result2 = $result;
                    $result = readRemaining;
                    continuation = byteChannelsKt$copyToBoth$12;
                    obj2 = obj3;
                    try {
                        Source it4 = source3;
                        copy2 = ByteReadPacketKt.copy(it4);
                        continuation.L$0 = source3;
                        continuation.L$1 = byteWriteChannel2;
                        continuation.L$2 = byteWriteChannel4;
                        continuation.L$3 = byteReadChannel3;
                        continuation.L$4 = it4;
                        continuation.label = 2;
                        if (ByteWriteChannelOperationsKt.writePacket(byteWriteChannel2, copy2, continuation) != obj2) {
                            return obj2;
                        }
                        byteReadChannel2 = byteReadChannel3;
                        $result = $result2;
                        $result3 = obj2;
                        source = source3;
                        byteWriteChannel = byteWriteChannel4;
                        byteChannelsKt$copyToBoth$13 = continuation;
                        it = it4;
                        byteWriteChannel3 = byteWriteChannel2;
                        try {
                        } catch (Throwable th4) {
                            try {
                                try {
                                    Unit unit = Unit.INSTANCE;
                                    AutoCloseableKt.closeFinally(source2, (Throwable) null);
                                    byteChannelsKt$copyToBoth$12 = byteChannelsKt$copyToBoth$13;
                                    if (byteChannelsKt$copyToBoth$12.$this_copyToBoth.isClosedForRead()) {
                                    }
                                    it2 = byteChannelsKt$copyToBoth$12.$this_copyToBoth.getClosedCause();
                                    if (it2 != null) {
                                    }
                                } catch (Throwable th5) {
                                    throw th5;
                                }
                                byteReadChannel.cancel(cause);
                                ByteWriteChannelOperationsKt.close(byteWriteChannel2, cause);
                                ByteWriteChannelOperationsKt.close(byteWriteChannel, cause);
                                source2 = source;
                            } catch (Throwable th6) {
                                throw th6;
                            }
                            ByteWriteChannel byteWriteChannel5 = byteWriteChannel3;
                            cause = th4;
                            byteReadChannel = byteReadChannel2;
                            byteWriteChannel2 = byteWriteChannel5;
                        }
                        copy = ByteReadPacketKt.copy(it);
                        byteChannelsKt$copyToBoth$13.L$0 = source;
                        byteChannelsKt$copyToBoth$13.L$1 = byteWriteChannel3;
                        byteChannelsKt$copyToBoth$13.L$2 = byteWriteChannel;
                        byteChannelsKt$copyToBoth$13.L$3 = byteReadChannel2;
                        byteChannelsKt$copyToBoth$13.L$4 = null;
                        byteChannelsKt$copyToBoth$13.label = 3;
                        if (ByteWriteChannelOperationsKt.writePacket(byteWriteChannel, copy, byteChannelsKt$copyToBoth$13) != $result3) {
                            return $result3;
                        }
                        source2 = source;
                        Unit unit2 = Unit.INSTANCE;
                        AutoCloseableKt.closeFinally(source2, (Throwable) null);
                        byteChannelsKt$copyToBoth$12 = byteChannelsKt$copyToBoth$13;
                        if (byteChannelsKt$copyToBoth$12.$this_copyToBoth.isClosedForRead()) {
                        }
                        it2 = byteChannelsKt$copyToBoth$12.$this_copyToBoth.getClosedCause();
                        if (it2 != null) {
                        }
                    } catch (Throwable th7) {
                        Object obj4 = obj2;
                        cause = th7;
                        $result3 = obj4;
                        ByteWriteChannelOperationsKt.close(continuation.$first, cause);
                        ByteWriteChannelOperationsKt.close(continuation.$second, cause);
                        continuation.L$0 = null;
                        continuation.L$1 = null;
                        continuation.L$2 = null;
                        continuation.L$3 = null;
                        continuation.L$4 = null;
                        continuation.label = 6;
                        if (continuation.$first.flushAndClose(continuation) == $result3) {
                        }
                        continuation.label = 7;
                        if (continuation.$second.flushAndClose((Continuation) continuation) != $result3) {
                        }
                    }
                } catch (Throwable th8) {
                    throw th8;
                }
                source3 = (AutoCloseable) $result;
                byteWriteChannel2 = continuation.$first;
                byteWriteChannel4 = continuation.$second;
                byteReadChannel3 = continuation.$this_copyToBoth;
                break;
            case 1:
                try {
                    ResultKt.throwOnFailure($result);
                    continuation = this;
                    obj2 = $result3;
                    $result2 = $result;
                    source3 = (AutoCloseable) $result;
                    byteWriteChannel2 = continuation.$first;
                    byteWriteChannel4 = continuation.$second;
                    byteReadChannel3 = continuation.$this_copyToBoth;
                    Source it42 = source3;
                    copy2 = ByteReadPacketKt.copy(it42);
                    continuation.L$0 = source3;
                    continuation.L$1 = byteWriteChannel2;
                    continuation.L$2 = byteWriteChannel4;
                    continuation.L$3 = byteReadChannel3;
                    continuation.L$4 = it42;
                    continuation.label = 2;
                    if (ByteWriteChannelOperationsKt.writePacket(byteWriteChannel2, copy2, continuation) != obj2) {
                    }
                } catch (Throwable th9) {
                    cause = th9;
                    continuation = this;
                    ByteWriteChannelOperationsKt.close(continuation.$first, cause);
                    ByteWriteChannelOperationsKt.close(continuation.$second, cause);
                    continuation.L$0 = null;
                    continuation.L$1 = null;
                    continuation.L$2 = null;
                    continuation.L$3 = null;
                    continuation.L$4 = null;
                    continuation.label = 6;
                    if (continuation.$first.flushAndClose(continuation) == $result3) {
                    }
                    continuation.label = 7;
                    if (continuation.$second.flushAndClose((Continuation) continuation) != $result3) {
                    }
                }
                break;
            case 2:
                it = (Source) this.L$4;
                ByteReadChannel byteReadChannel4 = (ByteReadChannel) this.L$3;
                ByteWriteChannel byteWriteChannel6 = (ByteWriteChannel) this.L$2;
                ByteWriteChannel byteWriteChannel7 = (ByteWriteChannel) this.L$1;
                Source source4 = (AutoCloseable) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    source = source4;
                    byteWriteChannel3 = byteWriteChannel7;
                    byteWriteChannel = byteWriteChannel6;
                    byteReadChannel2 = byteReadChannel4;
                    byteChannelsKt$copyToBoth$13 = this;
                } catch (Throwable th10) {
                    source = source4;
                    cause = th10;
                    byteReadChannel = byteReadChannel4;
                    byteChannelsKt$copyToBoth$13 = this;
                    byteWriteChannel = byteWriteChannel6;
                    byteWriteChannel2 = byteWriteChannel7;
                    byteReadChannel.cancel(cause);
                    ByteWriteChannelOperationsKt.close(byteWriteChannel2, cause);
                    ByteWriteChannelOperationsKt.close(byteWriteChannel, cause);
                    source2 = source;
                    Unit unit22 = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(source2, (Throwable) null);
                    byteChannelsKt$copyToBoth$12 = byteChannelsKt$copyToBoth$13;
                    if (byteChannelsKt$copyToBoth$12.$this_copyToBoth.isClosedForRead()) {
                    }
                    it2 = byteChannelsKt$copyToBoth$12.$this_copyToBoth.getClosedCause();
                    if (it2 != null) {
                    }
                }
                copy = ByteReadPacketKt.copy(it);
                byteChannelsKt$copyToBoth$13.L$0 = source;
                byteChannelsKt$copyToBoth$13.L$1 = byteWriteChannel3;
                byteChannelsKt$copyToBoth$13.L$2 = byteWriteChannel;
                byteChannelsKt$copyToBoth$13.L$3 = byteReadChannel2;
                byteChannelsKt$copyToBoth$13.L$4 = null;
                byteChannelsKt$copyToBoth$13.label = 3;
                if (ByteWriteChannelOperationsKt.writePacket(byteWriteChannel, copy, byteChannelsKt$copyToBoth$13) != $result3) {
                }
                break;
            case 3:
                byteReadChannel = (ByteReadChannel) this.L$3;
                ByteWriteChannel byteWriteChannel8 = (ByteWriteChannel) this.L$2;
                byteWriteChannel2 = (ByteWriteChannel) this.L$1;
                source2 = (AutoCloseable) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    byteChannelsKt$copyToBoth$13 = this;
                } catch (Throwable th11) {
                    cause = th11;
                    source = source2;
                    byteWriteChannel = byteWriteChannel8;
                    byteChannelsKt$copyToBoth$13 = this;
                    byteReadChannel.cancel(cause);
                    ByteWriteChannelOperationsKt.close(byteWriteChannel2, cause);
                    ByteWriteChannelOperationsKt.close(byteWriteChannel, cause);
                    source2 = source;
                    Unit unit222 = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(source2, (Throwable) null);
                    byteChannelsKt$copyToBoth$12 = byteChannelsKt$copyToBoth$13;
                    if (byteChannelsKt$copyToBoth$12.$this_copyToBoth.isClosedForRead()) {
                    }
                    it2 = byteChannelsKt$copyToBoth$12.$this_copyToBoth.getClosedCause();
                    if (it2 != null) {
                    }
                }
                Unit unit2222 = Unit.INSTANCE;
                AutoCloseableKt.closeFinally(source2, (Throwable) null);
                byteChannelsKt$copyToBoth$12 = byteChannelsKt$copyToBoth$13;
                if (byteChannelsKt$copyToBoth$12.$this_copyToBoth.isClosedForRead()) {
                }
                it2 = byteChannelsKt$copyToBoth$12.$this_copyToBoth.getClosedCause();
                if (it2 != null) {
                }
                break;
            case 4:
                ResultKt.throwOnFailure($result);
                byteChannelsKt$copyToBoth$12 = this;
                byteChannelsKt$copyToBoth$12.label = 5;
                if (byteChannelsKt$copyToBoth$12.$second.flushAndClose((Continuation) byteChannelsKt$copyToBoth$12) == $result3) {
                }
            case 5:
            case 7:
                ResultKt.throwOnFailure($result);
            case 6:
                ResultKt.throwOnFailure($result);
                continuation = this;
                continuation.label = 7;
                return continuation.$second.flushAndClose((Continuation) continuation) != $result3 ? $result3 : Unit.INSTANCE;
            case 8:
                Throwable th12 = (Throwable) this.L$0;
                ResultKt.throwOnFailure($result);
                continuation = this;
                obj = $result3;
                th = th12;
                continuation.L$0 = th;
                continuation.label = 9;
                if (continuation.$second.flushAndClose((Continuation) continuation) == obj) {
                    return obj;
                }
                throw th;
            case 9:
                Throwable th13 = (Throwable) this.L$0;
                ResultKt.throwOnFailure($result);
                throw th13;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}