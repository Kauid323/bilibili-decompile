package io.ktor.utils.io;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$;
import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.shadow.text.TextAttributes;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;

/* compiled from: ByteChannel.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001GB\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\u0010\u0010\rJ\u000f\u0010\u0011\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\rJ\u0010\u0010\u0012\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u0012\u0010\u000fJ\u0019\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019JH\u0010!\u001a\u00020\u000b\"\n\b\u0000\u0010\u001b\u0018\u0001*\u00020\u001a2\u001a\b\u0004\u0010\u001e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001d\u0012\u0004\u0012\u00028\u00000\u001c2\u000e\b\u0004\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u001fH\u0082H¢\u0006\u0004\b!\u0010\"J\u001c\u0010$\u001a\u00020\u000b\"\n\b\u0000\u0010#\u0018\u0001*\u00020\u001aH\u0082\b¢\u0006\u0004\b$\u0010\rJ\u0019\u0010%\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b%\u0010\u0016J4\u0010'\u001a\u00020\u000b\"\n\b\u0000\u0010\u001b\u0018\u0001*\u00020\u001a2\u0006\u0010&\u001a\u00028\u00002\u000e\b\u0004\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u001fH\u0082\b¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010)\u001a\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u001e\u00103\u001a\u000601j\u0002`28\u0002X\u0082\u0004¢\u0006\f\n\u0004\b3\u00104\u0012\u0004\b5\u0010\rR\u0014\u00106\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010.R\u0014\u00107\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010.R\u001a\u0010<\u001a\u0002088VX\u0097\u0004¢\u0006\f\u0012\u0004\b;\u0010\r\u001a\u0004\b9\u0010:R\u001a\u0010A\u001a\u00020=8VX\u0097\u0004¢\u0006\f\u0012\u0004\b@\u0010\r\u001a\u0004\b>\u0010?R\u0016\u0010D\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0014\u0010E\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010+R\u0014\u0010F\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010+¨\u0006H"}, d2 = {"Lio/ktor/utils/io/ByteChannel;", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/BufferedByteWriteChannel;", "", "autoFlush", "<init>", "(Z)V", "", "min", "awaitContent", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "moveFlushToReadBuffer", "()V", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flushWriteBuffer", "close", "flushAndClose", "", "cause", "cancel", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lio/ktor/utils/io/ByteChannel$Slot$Task;", "TaskType", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "createTask", "Lkotlin/Function0;", "shouldSleep", "sleepWhile", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Expected", "resumeSlot", "closeSlot", "slot", "trySuspend", "(Lio/ktor/utils/io/ByteChannel$Slot$Task;Lkotlin/jvm/functions/Function0;)V", "Z", "getAutoFlush", "()Z", "Lkotlinx/io/Buffer;", "flushBuffer", "Lkotlinx/io/Buffer;", "flushBufferSize", TextAttributes.INLINE_IMAGE_PLACEHOLDER, "", "Lio/ktor/utils/io/locks/SynchronizedObject;", "flushBufferMutex", "Ljava/lang/Object;", "getFlushBufferMutex$annotations", "_readBuffer", "_writeBuffer", "Lkotlinx/io/Source;", "getReadBuffer", "()Lkotlinx/io/Source;", "getReadBuffer$annotations", "readBuffer", "Lkotlinx/io/Sink;", "getWriteBuffer", "()Lkotlinx/io/Sink;", "getWriteBuffer$annotations", "writeBuffer", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "isClosedForWrite", "isClosedForRead", "Slot", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class ByteChannel implements ByteReadChannel, BufferedByteWriteChannel {
    volatile /* synthetic */ Object _closedCause;
    private final Buffer _readBuffer;
    private final Buffer _writeBuffer;
    private final boolean autoFlush;
    private final Buffer flushBuffer;
    private final Object flushBufferMutex;
    private volatile int flushBufferSize;
    volatile /* synthetic */ Object suspensionSlot;
    static final /* synthetic */ AtomicReferenceFieldUpdater suspensionSlot$FU = AtomicReferenceFieldUpdater.newUpdater(ByteChannel.class, Object.class, "suspensionSlot");
    static final /* synthetic */ AtomicReferenceFieldUpdater _closedCause$FU = AtomicReferenceFieldUpdater.newUpdater(ByteChannel.class, Object.class, "_closedCause");

    public ByteChannel() {
        this(false, 1, null);
    }

    private static /* synthetic */ void getFlushBufferMutex$annotations() {
    }

    @InternalAPI
    public static /* synthetic */ void getReadBuffer$annotations() {
    }

    @InternalAPI
    public static /* synthetic */ void getWriteBuffer$annotations() {
    }

    public ByteChannel(boolean autoFlush) {
        this.autoFlush = autoFlush;
        this.flushBuffer = new Buffer();
        this.flushBufferMutex = new Object();
        this.suspensionSlot = Slot.Empty.INSTANCE;
        this._readBuffer = new Buffer();
        this._writeBuffer = new Buffer();
        this._closedCause = null;
    }

    public /* synthetic */ ByteChannel(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final boolean getAutoFlush() {
        return this.autoFlush;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    /* renamed from: getReadBuffer */
    public Source mo1388getReadBuffer() {
        Throwable it = getClosedCause();
        if (it != null) {
            throw it;
        }
        if (this._readBuffer.exhausted()) {
            moveFlushToReadBuffer();
        }
        return this._readBuffer;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Sink getWriteBuffer() {
        Throwable it = getClosedCause();
        if (it != null) {
            throw it;
        }
        if (isClosedForWrite()) {
            throw new IOException("Channel is closed for write");
        }
        return this._writeBuffer;
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public Throwable getClosedCause() {
        CloseToken closeToken = (CloseToken) this._closedCause;
        if (closeToken != null) {
            return closeToken.getCause();
        }
        return null;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean isClosedForWrite() {
        return this._closedCause != null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public boolean isClosedForRead() {
        return getClosedCause() != null || (isClosedForWrite() && this.flushBufferSize == 0 && this._readBuffer.exhausted());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0172  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0161 -> B:61:0x0167). Please submit an issue!!! */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object awaitContent(int min, Continuation<? super Boolean> continuation) {
        Continuation $continuation;
        int i;
        ByteChannel byteChannel;
        boolean z;
        ByteChannel this_$iv;
        int min2;
        Object $result;
        boolean z2;
        Continuation $completion = continuation;
        if ($completion instanceof ByteChannel$awaitContent$1) {
            $continuation = (ByteChannel$awaitContent$1) $completion;
            if (($continuation.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                $continuation.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result2 = $continuation.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = 1;
                switch ($continuation.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        ByteReadChannelOperationsKt.rethrowCloseCauseIfNeeded(this);
                        if (this._readBuffer.getSize() < min) {
                            byteChannel = this;
                            z = false;
                            this_$iv = this;
                            min2 = min;
                            break;
                        } else {
                            return Boxing.boxBoolean(true);
                        }
                    case 1:
                        z = false;
                        min2 = $continuation.I$0;
                        this_$iv = (ByteChannel) $continuation.L$1;
                        byteChannel = (ByteChannel) $continuation.L$0;
                        ResultKt.throwOnFailure($result2);
                        i = 1;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (((((long) byteChannel.flushBufferSize) + byteChannel._readBuffer.getSize() < ((long) min2) || byteChannel._closedCause != null) ? 0 : i) != 0) {
                    $continuation.L$0 = byteChannel;
                    $continuation.L$1 = this_$iv;
                    $continuation.I$0 = min2;
                    $continuation.label = i;
                    Continuation uCont$iv$iv = $continuation;
                    Continuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv$iv), i);
                    cancellableContinuationImpl.initCancellability();
                    Continuation p0 = (CancellableContinuation) cancellableContinuationImpl;
                    Slot.Task read = new Slot.Read(p0);
                    ByteChannel this_$iv$iv = this_$iv;
                    Slot.Task slot$iv$iv = read;
                    Slot previous$iv$iv = (Slot) this_$iv$iv.suspensionSlot;
                    Continuation $completion2 = $completion;
                    if (!(previous$iv$iv instanceof Slot.Closed) && !AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(suspensionSlot$FU, this_$iv$iv, previous$iv$iv, slot$iv$iv)) {
                        slot$iv$iv.resume();
                        $result = $result2;
                        z2 = z;
                    } else {
                        if (previous$iv$iv instanceof Slot.Read) {
                            $result = $result2;
                            z2 = z;
                            ((Slot.Task) previous$iv$iv).resume(new ConcurrentIOException(slot$iv$iv.taskName(), ((Slot.Task) previous$iv$iv).getCreated()));
                        } else {
                            $result = $result2;
                            z2 = z;
                            if (previous$iv$iv instanceof Slot.Task) {
                                ((Slot.Task) previous$iv$iv).resume();
                            } else if (previous$iv$iv instanceof Slot.Closed) {
                                slot$iv$iv.resume(((Slot.Closed) previous$iv$iv).getCause());
                            } else if (!Intrinsics.areEqual(previous$iv$iv, Slot.Empty.INSTANCE)) {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                        if (!(((long) byteChannel.flushBufferSize) + byteChannel._readBuffer.getSize() < ((long) min2) && byteChannel._closedCause == null)) {
                            Slot current$iv$iv$iv = (Slot) this_$iv$iv.suspensionSlot;
                            if ((current$iv$iv$iv instanceof Slot.Read) && AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(suspensionSlot$FU, this_$iv$iv, current$iv$iv$iv, Slot.Empty.INSTANCE)) {
                                ((Slot.Task) current$iv$iv$iv).resume();
                            }
                        }
                    }
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended($continuation);
                    }
                    if (result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $completion = $completion2;
                    $result2 = $result;
                    z = z2;
                    i = 1;
                    if (((((long) byteChannel.flushBufferSize) + byteChannel._readBuffer.getSize() < ((long) min2) || byteChannel._closedCause != null) ? 0 : i) != 0) {
                        if (byteChannel._readBuffer.getSize() < 1048576) {
                            byteChannel.moveFlushToReadBuffer();
                        }
                        return Boxing.boxBoolean(byteChannel._readBuffer.getSize() >= ((long) min2));
                    }
                }
            }
        }
        $continuation = new ByteChannel$awaitContent$1(this, $completion);
        Object $result22 = $continuation.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = 1;
        switch ($continuation.label) {
        }
        if (((((long) byteChannel.flushBufferSize) + byteChannel._readBuffer.getSize() < ((long) min2) || byteChannel._closedCause != null) ? 0 : i) != 0) {
        }
    }

    private final void moveFlushToReadBuffer() {
        Object lock$iv = this.flushBufferMutex;
        synchronized (lock$iv) {
            this.flushBuffer.transferTo(this._readBuffer);
            this.flushBufferSize = 0;
            Unit unit = Unit.INSTANCE;
        }
        Slot current$iv = (Slot) this.suspensionSlot;
        if (!(current$iv instanceof Slot.Write) || !AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(suspensionSlot$FU, this, current$iv, Slot.Empty.INSTANCE)) {
            return;
        }
        ((Slot.Task) current$iv).resume();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0152  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0143 -> B:61:0x0145). Please submit an issue!!! */
    @Override // io.ktor.utils.io.ByteWriteChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object flush(Continuation<? super Unit> continuation) {
        Continuation $continuation;
        int i;
        int i2;
        ByteChannel byteChannel;
        ByteChannel this_$iv;
        Continuation $completion;
        Object $result;
        int i3;
        Continuation $completion2 = continuation;
        if ($completion2 instanceof ByteChannel$flush$1) {
            $continuation = (ByteChannel$flush$1) $completion2;
            if (($continuation.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                $continuation.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result2 = $continuation.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = $continuation.label;
                i2 = ByteChannelKt.CHANNEL_MAX_SIZE;
                switch (i) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        ByteReadChannelOperationsKt.rethrowCloseCauseIfNeeded(this);
                        flushWriteBuffer();
                        if (this.flushBufferSize >= 1048576) {
                            byteChannel = this;
                            this_$iv = this;
                            break;
                        } else {
                            return Unit.INSTANCE;
                        }
                    case 1:
                        this_$iv = (ByteChannel) $continuation.L$1;
                        byteChannel = (ByteChannel) $continuation.L$0;
                        ResultKt.throwOnFailure($result2);
                        $result = $result2;
                        i3 = 1048576;
                        i2 = i3;
                        $result2 = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (((byteChannel.flushBufferSize >= i2 || byteChannel._closedCause != null) ? 0 : 1) != 0) {
                    $continuation.L$0 = byteChannel;
                    $continuation.L$1 = this_$iv;
                    $continuation.label = 1;
                    Continuation uCont$iv$iv = $continuation;
                    Continuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv$iv), 1);
                    cancellableContinuationImpl.initCancellability();
                    Continuation p0 = (CancellableContinuation) cancellableContinuationImpl;
                    Slot.Task write = new Slot.Write(p0);
                    ByteChannel this_$iv$iv = this_$iv;
                    Slot.Task slot$iv$iv = write;
                    Slot previous$iv$iv = (Slot) this_$iv$iv.suspensionSlot;
                    if (!(previous$iv$iv instanceof Slot.Closed) && !AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(suspensionSlot$FU, this_$iv$iv, previous$iv$iv, slot$iv$iv)) {
                        slot$iv$iv.resume();
                        $completion = $completion2;
                        $result = $result2;
                        i3 = ByteChannelKt.CHANNEL_MAX_SIZE;
                    } else {
                        if (previous$iv$iv instanceof Slot.Write) {
                            $completion = $completion2;
                            $result = $result2;
                            ((Slot.Task) previous$iv$iv).resume(new ConcurrentIOException(slot$iv$iv.taskName(), ((Slot.Task) previous$iv$iv).getCreated()));
                        } else {
                            $completion = $completion2;
                            $result = $result2;
                            if (previous$iv$iv instanceof Slot.Task) {
                                ((Slot.Task) previous$iv$iv).resume();
                            } else if (previous$iv$iv instanceof Slot.Closed) {
                                slot$iv$iv.resume(((Slot.Closed) previous$iv$iv).getCause());
                                i3 = ByteChannelKt.CHANNEL_MAX_SIZE;
                            } else if (!Intrinsics.areEqual(previous$iv$iv, Slot.Empty.INSTANCE)) {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                        int i4 = byteChannel.flushBufferSize;
                        i3 = ByteChannelKt.CHANNEL_MAX_SIZE;
                        if (!(i4 >= 1048576 && byteChannel._closedCause == null)) {
                            Slot current$iv$iv$iv = (Slot) this_$iv$iv.suspensionSlot;
                            if ((current$iv$iv$iv instanceof Slot.Write) && AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(suspensionSlot$FU, this_$iv$iv, current$iv$iv$iv, Slot.Empty.INSTANCE)) {
                                ((Slot.Task) current$iv$iv$iv).resume();
                            }
                        }
                    }
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended($continuation);
                    }
                    if (result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $completion2 = $completion;
                    i2 = i3;
                    $result2 = $result;
                    if (((byteChannel.flushBufferSize >= i2 || byteChannel._closedCause != null) ? 0 : 1) != 0) {
                        return Unit.INSTANCE;
                    }
                }
            }
        }
        $continuation = new ByteChannel$flush$1(this, $completion2);
        Object $result22 = $continuation.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = $continuation.label;
        i2 = ByteChannelKt.CHANNEL_MAX_SIZE;
        switch (i) {
        }
        if (((byteChannel.flushBufferSize >= i2 || byteChannel._closedCause != null) ? 0 : 1) != 0) {
        }
    }

    @Override // io.ktor.utils.io.BufferedByteWriteChannel
    @InternalAPI
    public void flushWriteBuffer() {
        if (this._writeBuffer.exhausted()) {
            return;
        }
        Object lock$iv = this.flushBufferMutex;
        synchronized (lock$iv) {
            int count = (int) this._writeBuffer.getSize();
            this.flushBuffer.transferFrom(this._writeBuffer);
            this.flushBufferSize += count;
            Unit unit = Unit.INSTANCE;
        }
        Slot current$iv = (Slot) this.suspensionSlot;
        if (!(current$iv instanceof Slot.Read) || !AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(suspensionSlot$FU, this, current$iv, Slot.Empty.INSTANCE)) {
            return;
        }
        ((Slot.Task) current$iv).resume();
    }

    @Override // io.ktor.utils.io.BufferedByteWriteChannel
    public void close() {
        flushWriteBuffer();
        if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_closedCause$FU, this, (Object) null, CloseTokenKt.getCLOSED())) {
            closeSlot(null);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|8|14|15|(2:17|18)(2:19|20)))|29|6|7|8|14|15|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
        r4 = kotlin.Result.Companion;
        kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
        r3 = r3;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /* JADX WARN: Type inference failed for: r3v1 */
    @Override // io.ktor.utils.io.ByteWriteChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object flushAndClose(Continuation<? super Unit> continuation) {
        ByteChannel$flushAndClose$1 byteChannel$flushAndClose$1;
        int i;
        ByteChannel byteChannel;
        if (continuation instanceof ByteChannel$flushAndClose$1) {
            byteChannel$flushAndClose$1 = (ByteChannel$flushAndClose$1) continuation;
            if ((byteChannel$flushAndClose$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteChannel$flushAndClose$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteChannel$flushAndClose$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannel$flushAndClose$1.label;
                switch (i) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        ByteChannel byteChannel2 = this;
                        Result.Companion companion = Result.Companion;
                        ByteChannel $this$flushAndClose_u24lambda_u247 = byteChannel2;
                        byteChannel$flushAndClose$1.L$0 = byteChannel2;
                        byteChannel$flushAndClose$1.label = 1;
                        if ($this$flushAndClose_u24lambda_u247.flush(byteChannel$flushAndClose$1) != coroutine_suspended) {
                            i = byteChannel2;
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        ByteChannel byteChannel3 = (ByteChannel) byteChannel$flushAndClose$1.L$0;
                        ResultKt.throwOnFailure($result);
                        i = byteChannel3;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result.constructor-impl(Unit.INSTANCE);
                byteChannel = i;
                if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_closedCause$FU, byteChannel, (Object) null, CloseTokenKt.getCLOSED())) {
                    return Unit.INSTANCE;
                }
                byteChannel.closeSlot(null);
                return Unit.INSTANCE;
            }
        }
        byteChannel$flushAndClose$1 = new ByteChannel$flushAndClose$1(this, continuation);
        Object $result2 = byteChannel$flushAndClose$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannel$flushAndClose$1.label;
        switch (i) {
        }
        Result.constructor-impl(Unit.INSTANCE);
        byteChannel = i;
        if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_closedCause$FU, byteChannel, (Object) null, CloseTokenKt.getCLOSED())) {
        }
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public void cancel(Throwable cause) {
        if (this._closedCause != null) {
            return;
        }
        CloseToken closedToken = new CloseToken(cause);
        AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_closedCause$FU, this, (Object) null, closedToken);
        Throwable actualCause = closedToken.getCause();
        closeSlot(actualCause);
    }

    public String toString() {
        return "ByteChannel[" + hashCode() + ']';
    }

    private final /* synthetic */ <TaskType extends Slot.Task> Object sleepWhile(Function1<? super Continuation<? super Unit>, ? extends TaskType> function1, Function0<Boolean> function0, Continuation<? super Unit> continuation) {
        boolean z;
        boolean z2 = false;
        while (((Boolean) function0.invoke()).booleanValue()) {
            InlineMarker.mark(0);
            Continuation<? super Unit> uCont$iv = continuation;
            CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
            cancellableContinuationImpl.initCancellability();
            CancellableContinuation continuation2 = cancellableContinuationImpl;
            Slot.Task slot$iv = (Slot.Task) function1.invoke(continuation2);
            Slot previous$iv = (Slot) this.suspensionSlot;
            if (!(previous$iv instanceof Slot.Closed) && !AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(suspensionSlot$FU, this, previous$iv, slot$iv)) {
                slot$iv.resume();
                Unit unit = Unit.INSTANCE;
                z = z2;
            } else {
                Intrinsics.reifiedOperationMarker(3, "TaskType");
                if (previous$iv instanceof Slot.Task) {
                    z = z2;
                    ((Slot.Task) previous$iv).resume(new ConcurrentIOException(slot$iv.taskName(), ((Slot.Task) previous$iv).getCreated()));
                } else {
                    z = z2;
                    if (previous$iv instanceof Slot.Task) {
                        ((Slot.Task) previous$iv).resume();
                    } else if (previous$iv instanceof Slot.Closed) {
                        slot$iv.resume(((Slot.Closed) previous$iv).getCause());
                        Unit unit2 = Unit.INSTANCE;
                    } else if (!Intrinsics.areEqual(previous$iv, Slot.Empty.INSTANCE)) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                if (!((Boolean) function0.invoke()).booleanValue()) {
                    Slot current$iv$iv = (Slot) this.suspensionSlot;
                    Intrinsics.reifiedOperationMarker(3, "TaskType");
                    if ((current$iv$iv instanceof Slot.Task) && AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(suspensionSlot$FU, this, current$iv$iv, Slot.Empty.INSTANCE)) {
                        ((Slot.Task) current$iv$iv).resume();
                    }
                }
            }
            Unit unit3 = Unit.INSTANCE;
            if (cancellableContinuationImpl.getResult() == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            InlineMarker.mark(1);
            z2 = z;
        }
        return Unit.INSTANCE;
    }

    private final /* synthetic */ <Expected extends Slot.Task> void resumeSlot() {
        Slot current = (Slot) this.suspensionSlot;
        Intrinsics.reifiedOperationMarker(3, "Expected");
        if ((current instanceof Slot.Task) && AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(suspensionSlot$FU, this, current, Slot.Empty.INSTANCE)) {
            ((Slot.Task) current).resume();
        }
    }

    private final void closeSlot(Throwable cause) {
        Slot.Closed closeContinuation = cause != null ? new Slot.Closed(cause) : Slot.Companion.getCLOSED();
        Slot continuation = (Slot) suspensionSlot$FU.getAndSet(this, closeContinuation);
        if (continuation instanceof Slot.Task) {
            ((Slot.Task) continuation).resume(cause);
        }
    }

    private final /* synthetic */ <TaskType extends Slot.Task> void trySuspend(TaskType tasktype, Function0<Boolean> function0) {
        Slot previous = (Slot) this.suspensionSlot;
        if (!(previous instanceof Slot.Closed) && !AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(suspensionSlot$FU, this, previous, tasktype)) {
            tasktype.resume();
            return;
        }
        Intrinsics.reifiedOperationMarker(3, "TaskType");
        if (previous instanceof Slot.Task) {
            ((Slot.Task) previous).resume(new ConcurrentIOException(tasktype.taskName(), ((Slot.Task) previous).getCreated()));
        } else if (previous instanceof Slot.Task) {
            ((Slot.Task) previous).resume();
        } else if (previous instanceof Slot.Closed) {
            tasktype.resume(((Slot.Closed) previous).getCause());
            return;
        } else if (!Intrinsics.areEqual(previous, Slot.Empty.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        if (((Boolean) function0.invoke()).booleanValue()) {
            return;
        }
        Slot current$iv = (Slot) this.suspensionSlot;
        Intrinsics.reifiedOperationMarker(3, "TaskType");
        if (!(current$iv instanceof Slot.Task) || !AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(suspensionSlot$FU, this, current$iv, Slot.Empty.INSTANCE)) {
            return;
        }
        ((Slot.Task) current$iv).resume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ByteChannel.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u0000 \u00022\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot;", "", "Companion", "Empty", "Closed", "Task", "Read", "Write", "Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "Lio/ktor/utils/io/ByteChannel$Slot$Empty;", "Lio/ktor/utils/io/ByteChannel$Slot$Task;", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
    /* loaded from: /data/np/file-convert/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7.dex */
    public interface Slot {
        public static final Companion Companion = Companion.$$INSTANCE;

        /* compiled from: ByteChannel.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR&\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\f\u0010\r\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Companion;", "", "<init>", "()V", "Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "CLOSED", "Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "getCLOSED", "()Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "getCLOSED$annotations", "Lkotlin/Result;", "", "RESUME", "Ljava/lang/Object;", "getRESUME-d1pmJ48", "()Ljava/lang/Object;", "getRESUME-d1pmJ48$annotations", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
        /* loaded from: /data/np/file-convert/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            private static final Closed CLOSED = new Closed(null);
            private static final Object RESUME;

            @JvmStatic
            public static /* synthetic */ void getCLOSED$annotations() {
            }

            @JvmStatic
            /* renamed from: getRESUME-d1pmJ48$annotations  reason: not valid java name */
            public static /* synthetic */ void m1382getRESUMEd1pmJ48$annotations() {
            }

            private Companion() {
            }

            public final Closed getCLOSED() {
                return CLOSED;
            }

            static {
                Result.Companion companion = Result.Companion;
                RESUME = Result.constructor-impl(Unit.INSTANCE);
            }

            /* renamed from: getRESUME-d1pmJ48  reason: not valid java name */
            public final Object m1383getRESUMEd1pmJ48() {
                return RESUME;
            }
        }

        /* compiled from: ByteChannel.kt */
        /* renamed from: io.ktor.utils.io.ByteChannel$Slot$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7.dex */
        public final /* synthetic */ class CC {
            static {
                Companion companion = Slot.Companion;
            }

            public static Closed getCLOSED() {
                return Slot.Companion.getCLOSED();
            }

            /* renamed from: getRESUME-d1pmJ48  reason: not valid java name */
            public static Object m1381getRESUMEd1pmJ48() {
                return Slot.Companion.m1383getRESUMEd1pmJ48();
            }
        }

        /* compiled from: ByteChannel.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÖ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Empty;", "Lio/ktor/utils/io/ByteChannel$Slot;", "<init>", "()V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
        /* loaded from: /data/np/file-convert/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7.dex */
        public static final class Empty implements Slot {
            public static final Empty INSTANCE = new Empty();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Empty) {
                    Empty empty = (Empty) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -231472095;
            }

            public String toString() {
                return "Empty";
            }

            private Empty() {
            }
        }

        /* compiled from: ByteChannel.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "Lio/ktor/utils/io/ByteChannel$Slot;", "", "cause", "<init>", "(Ljava/lang/Throwable;)V", "component1", "()Ljava/lang/Throwable;", "copy", "(Ljava/lang/Throwable;)Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Throwable;", "getCause", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
        /* loaded from: /data/np/file-convert/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7.dex */
        public static final class Closed implements Slot {
            private final Throwable cause;

            public static /* synthetic */ Closed copy$default(Closed closed, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    th = closed.cause;
                }
                return closed.copy(th);
            }

            public final Throwable component1() {
                return this.cause;
            }

            public final Closed copy(Throwable th) {
                return new Closed(th);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Closed) && Intrinsics.areEqual(this.cause, ((Closed) obj).cause);
            }

            public int hashCode() {
                if (this.cause == null) {
                    return 0;
                }
                return this.cause.hashCode();
            }

            public String toString() {
                return "Closed(cause=" + this.cause + ')';
            }

            public Closed(Throwable cause) {
                this.cause = cause;
            }

            public final Throwable getCause() {
                return this.cause;
            }
        }

        /* compiled from: ByteChannel.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0006\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0001\u0002\u0012\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Task;", "Lio/ktor/utils/io/ByteChannel$Slot;", "", "taskName", "()Ljava/lang/String;", "", "resume", "()V", "", "throwable", "(Ljava/lang/Throwable;)V", "getCreated", "()Ljava/lang/Throwable;", "created", "Lkotlin/coroutines/Continuation;", "getContinuation", "()Lkotlin/coroutines/Continuation;", "continuation", "Lio/ktor/utils/io/ByteChannel$Slot$Read;", "Lio/ktor/utils/io/ByteChannel$Slot$Write;", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
        /* loaded from: /data/np/file-convert/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7.dex */
        public interface Task extends Slot {
            Continuation<Unit> getContinuation();

            Throwable getCreated();

            void resume();

            void resume(Throwable th);

            String taskName();

            /* compiled from: ByteChannel.kt */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
            /* loaded from: /data/np/file-convert/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7.dex */
            public static final class DefaultImpls {
                public static void resume(Task $this) {
                    $this.getContinuation().resumeWith(Slot.Companion.m1383getRESUMEd1pmJ48());
                }

                public static /* synthetic */ void resume$default(Task task, Throwable th, int i, Object obj) {
                    if (obj != null) {
                        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resume");
                    }
                    if ((i & 1) != 0) {
                        th = null;
                    }
                    task.resume(th);
                }

                public static void resume(Task $this, Throwable throwable) {
                    Object m1383getRESUMEd1pmJ48;
                    Continuation<Unit> continuation = $this.getContinuation();
                    if (throwable != null) {
                        Result.Companion companion = Result.Companion;
                        m1383getRESUMEd1pmJ48 = Result.constructor-impl(ResultKt.createFailure(throwable));
                    } else {
                        m1383getRESUMEd1pmJ48 = Slot.Companion.m1383getRESUMEd1pmJ48();
                    }
                    continuation.resumeWith(m1383getRESUMEd1pmJ48);
                }
            }
        }

        /* compiled from: ByteChannel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Read;", "Lio/ktor/utils/io/ByteChannel$Slot$Task;", "Lkotlin/coroutines/Continuation;", "", "continuation", "<init>", "(Lkotlin/coroutines/Continuation;)V", "", "taskName", "()Ljava/lang/String;", "Lkotlin/coroutines/Continuation;", "getContinuation", "()Lkotlin/coroutines/Continuation;", "", "created", "Ljava/lang/Throwable;", "getCreated", "()Ljava/lang/Throwable;", "setCreated", "(Ljava/lang/Throwable;)V", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
        /* loaded from: /data/np/file-convert/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7.dex */
        public static final class Read implements Task {
            private final Continuation<Unit> continuation;
            private Throwable created;

            public Read(Continuation<? super Unit> continuation) {
                Intrinsics.checkNotNullParameter(continuation, "continuation");
                this.continuation = continuation;
                if (!ByteChannel_jvmKt.getDEVELOPMENT_MODE()) {
                    return;
                }
                StringBuilder append = new StringBuilder().append("ReadTask 0x");
                String num = Integer.toString(getContinuation().hashCode(), CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
                Throwable it = new Throwable(append.append(num).toString());
                kotlin.ExceptionsKt.stackTraceToString(it);
                setCreated(it);
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public Continuation<Unit> getContinuation() {
                return this.continuation;
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public void resume() {
                Task.DefaultImpls.resume(this);
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public void resume(Throwable throwable) {
                Task.DefaultImpls.resume(this, throwable);
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public Throwable getCreated() {
                return this.created;
            }

            public void setCreated(Throwable th) {
                this.created = th;
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public String taskName() {
                return "read";
            }
        }

        /* compiled from: ByteChannel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Write;", "Lio/ktor/utils/io/ByteChannel$Slot$Task;", "Lkotlin/coroutines/Continuation;", "", "continuation", "<init>", "(Lkotlin/coroutines/Continuation;)V", "", "taskName", "()Ljava/lang/String;", "Lkotlin/coroutines/Continuation;", "getContinuation", "()Lkotlin/coroutines/Continuation;", "", "created", "Ljava/lang/Throwable;", "getCreated", "()Ljava/lang/Throwable;", "setCreated", "(Ljava/lang/Throwable;)V", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
        /* loaded from: /data/np/file-convert/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7.dex */
        public static final class Write implements Task {
            private final Continuation<Unit> continuation;
            private Throwable created;

            public Write(Continuation<? super Unit> continuation) {
                Intrinsics.checkNotNullParameter(continuation, "continuation");
                this.continuation = continuation;
                if (!ByteChannel_jvmKt.getDEVELOPMENT_MODE()) {
                    return;
                }
                StringBuilder append = new StringBuilder().append("WriteTask 0x");
                String num = Integer.toString(getContinuation().hashCode(), CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
                Throwable it = new Throwable(append.append(num).toString());
                kotlin.ExceptionsKt.stackTraceToString(it);
                setCreated(it);
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public Continuation<Unit> getContinuation() {
                return this.continuation;
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public void resume() {
                Task.DefaultImpls.resume(this);
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public void resume(Throwable throwable) {
                Task.DefaultImpls.resume(this, throwable);
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public Throwable getCreated() {
                return this.created;
            }

            public void setCreated(Throwable th) {
                this.created = th;
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public String taskName() {
                return "write";
            }
        }
    }
}