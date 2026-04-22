package io.ktor.utils.io.jvm.nio;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import io.ktor.utils.io.ByteWriteChannel;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.io.Buffer;
import kotlinx.io.Segment;
import kotlinx.io.SegmentKt;
import kotlinx.io.unsafe.UnsafeBufferOperations;

/* compiled from: WriteSuspendSession.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a=\u0010\b\u001a\u00020\u0004*\u00020\u00002'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006H\u0087@¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\r\u001a\u00020\u0004*\u00020\u00002\u0014\b\u0004\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0086H¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "Lkotlin/Function2;", "Lio/ktor/utils/io/jvm/nio/WriteSuspendSession;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "block", "writeSuspendSession", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "Ljava/nio/ByteBuffer;", "", "writeWhile", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class WriteSuspendSessionKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061 A[RETURN] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object] */
    @Deprecated(level = DeprecationLevel.WARNING, message = "writeSuspendSession deprecated, use writeWhile instead", replaceWith = @ReplaceWith(expression = "writeWhile { buffer -> }", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object writeSuspendSession(ByteWriteChannel byteWriteChannel, Function2<? super WriteSuspendSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        WriteSuspendSessionKt$writeSuspendSession$1 writeSuspendSessionKt$writeSuspendSession$1;
        Object coroutine_suspended;
        ByteWriteChannel $this$writeSuspendSession;
        try {
            if (continuation instanceof WriteSuspendSessionKt$writeSuspendSession$1) {
                writeSuspendSessionKt$writeSuspendSession$1 = (WriteSuspendSessionKt$writeSuspendSession$1) continuation;
                if ((writeSuspendSessionKt$writeSuspendSession$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                    writeSuspendSessionKt$writeSuspendSession$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                    Object $result = writeSuspendSessionKt$writeSuspendSession$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (writeSuspendSessionKt$writeSuspendSession$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            WriteSuspendSession writeSuspendSession = new WriteSuspendSession(byteWriteChannel);
                            writeSuspendSessionKt$writeSuspendSession$1.L$0 = byteWriteChannel;
                            writeSuspendSessionKt$writeSuspendSession$1.label = 1;
                            $this$writeSuspendSession = byteWriteChannel;
                            if (function2.invoke(writeSuspendSession, writeSuspendSessionKt$writeSuspendSession$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            writeSuspendSessionKt$writeSuspendSession$1.L$0 = null;
                            writeSuspendSessionKt$writeSuspendSession$1.label = 2;
                            byteWriteChannel = $this$writeSuspendSession.flush(writeSuspendSessionKt$writeSuspendSession$1);
                            if (byteWriteChannel == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        case 1:
                            ByteWriteChannel byteWriteChannel2 = (ByteWriteChannel) writeSuspendSessionKt$writeSuspendSession$1.L$0;
                            ResultKt.throwOnFailure($result);
                            $this$writeSuspendSession = byteWriteChannel2;
                            writeSuspendSessionKt$writeSuspendSession$1.L$0 = null;
                            writeSuspendSessionKt$writeSuspendSession$1.label = 2;
                            byteWriteChannel = $this$writeSuspendSession.flush(writeSuspendSessionKt$writeSuspendSession$1);
                            if (byteWriteChannel == coroutine_suspended) {
                            }
                            return Unit.INSTANCE;
                        case 2:
                            ResultKt.throwOnFailure($result);
                            return Unit.INSTANCE;
                        case 3:
                            Throwable th = (Throwable) writeSuspendSessionKt$writeSuspendSession$1.L$0;
                            ResultKt.throwOnFailure($result);
                            throw th;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (writeSuspendSessionKt$writeSuspendSession$1.label) {
            }
        } catch (Throwable th2) {
            ByteWriteChannel $this$writeSuspendSession2 = byteWriteChannel;
            writeSuspendSessionKt$writeSuspendSession$1.L$0 = th2;
            writeSuspendSessionKt$writeSuspendSession$1.label = 3;
            if ($this$writeSuspendSession2.flush(writeSuspendSessionKt$writeSuspendSession$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            throw th2;
        }
        writeSuspendSessionKt$writeSuspendSession$1 = new WriteSuspendSessionKt$writeSuspendSession$1(continuation);
        Object $result2 = writeSuspendSessionKt$writeSuspendSession$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object writeWhile(ByteWriteChannel $this$writeWhile, Function1<? super ByteBuffer, Boolean> function1, Continuation<? super Unit> continuation) {
        WriteSuspendSessionKt$writeWhile$1 writeSuspendSessionKt$writeWhile$1;
        ByteWriteChannel $this$writeWhile2;
        Function1 block;
        Ref.BooleanRef done;
        Continuation $completion = continuation;
        if ($completion instanceof WriteSuspendSessionKt$writeWhile$1) {
            writeSuspendSessionKt$writeWhile$1 = (WriteSuspendSessionKt$writeWhile$1) $completion;
            if ((writeSuspendSessionKt$writeWhile$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                writeSuspendSessionKt$writeWhile$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = writeSuspendSessionKt$writeWhile$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (writeSuspendSessionKt$writeWhile$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$writeWhile2 = $this$writeWhile;
                        block = function1;
                        done = new Ref.BooleanRef();
                        break;
                    case 1:
                        done = (Ref.BooleanRef) writeSuspendSessionKt$writeWhile$1.L$2;
                        block = (Function1) writeSuspendSessionKt$writeWhile$1.L$1;
                        $this$writeWhile2 = (ByteWriteChannel) writeSuspendSessionKt$writeWhile$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                while (!done.element) {
                    UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
                    Buffer buffer$iv = $this$writeWhile2.getWriteBuffer().getBuffer();
                    Segment tail$iv = buffer$iv.writableSegment(1);
                    byte[] data$iv = tail$iv.dataAsByteArray(false);
                    int start = tail$iv.getLimit();
                    int endExclusive = data$iv.length;
                    Continuation $completion2 = $completion;
                    ByteBuffer buffer = ByteBuffer.wrap(data$iv, start, endExclusive - start);
                    Intrinsics.checkNotNull(buffer);
                    done.element = !((Boolean) block.invoke(buffer)).booleanValue();
                    int bytesWritten$iv = buffer.position() - start;
                    if (bytesWritten$iv == 1) {
                        tail$iv.writeBackData(data$iv, bytesWritten$iv);
                        tail$iv.setLimit(tail$iv.getLimit() + bytesWritten$iv);
                        buffer$iv.setSizeMut(buffer$iv.getSizeMut() + bytesWritten$iv);
                    } else {
                        if (!(bytesWritten$iv >= 0 && bytesWritten$iv <= tail$iv.getRemainingCapacity())) {
                            throw new IllegalStateException(("Invalid number of bytes written: " + bytesWritten$iv + ". Should be in 0.." + tail$iv.getRemainingCapacity()).toString());
                        }
                        if (bytesWritten$iv != 0) {
                            tail$iv.writeBackData(data$iv, bytesWritten$iv);
                            tail$iv.setLimit(tail$iv.getLimit() + bytesWritten$iv);
                            buffer$iv.setSizeMut(buffer$iv.getSizeMut() + bytesWritten$iv);
                        } else if (SegmentKt.isEmpty(tail$iv)) {
                            buffer$iv.recycleTail();
                        }
                    }
                    writeSuspendSessionKt$writeWhile$1.L$0 = $this$writeWhile2;
                    writeSuspendSessionKt$writeWhile$1.L$1 = block;
                    writeSuspendSessionKt$writeWhile$1.L$2 = done;
                    writeSuspendSessionKt$writeWhile$1.label = 1;
                    if ($this$writeWhile2.flush(writeSuspendSessionKt$writeWhile$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $completion = $completion2;
                }
                return Unit.INSTANCE;
            }
        }
        writeSuspendSessionKt$writeWhile$1 = new WriteSuspendSessionKt$writeWhile$1($completion);
        Object $result2 = writeSuspendSessionKt$writeWhile$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (writeSuspendSessionKt$writeWhile$1.label) {
        }
        while (!done.element) {
        }
        return Unit.INSTANCE;
    }

    private static final Object writeWhile$$forInline(ByteWriteChannel $this$writeWhile, Function1<? super ByteBuffer, Boolean> function1, Continuation<? super Unit> continuation) {
        Ref.BooleanRef done = new Ref.BooleanRef();
        while (!done.element) {
            UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
            Buffer buffer$iv = $this$writeWhile.getWriteBuffer().getBuffer();
            Segment tail$iv = buffer$iv.writableSegment(1);
            byte[] data$iv = tail$iv.dataAsByteArray(false);
            Integer valueOf = Integer.valueOf(tail$iv.getLimit());
            int endExclusive = Integer.valueOf(data$iv.length).intValue();
            int start = valueOf.intValue();
            byte[] array = data$iv;
            ByteBuffer buffer = ByteBuffer.wrap(array, start, endExclusive - start);
            Intrinsics.checkNotNull(buffer);
            done.element = !((Boolean) function1.invoke(buffer)).booleanValue();
            int bytesWritten$iv = Integer.valueOf(buffer.position() - start).intValue();
            if (bytesWritten$iv == 1) {
                tail$iv.writeBackData(data$iv, bytesWritten$iv);
                tail$iv.setLimit(tail$iv.getLimit() + bytesWritten$iv);
                buffer$iv.setSizeMut(buffer$iv.getSizeMut() + bytesWritten$iv);
            } else {
                if (!(bytesWritten$iv >= 0 && bytesWritten$iv <= tail$iv.getRemainingCapacity())) {
                    throw new IllegalStateException(("Invalid number of bytes written: " + bytesWritten$iv + ". Should be in 0.." + tail$iv.getRemainingCapacity()).toString());
                }
                if (bytesWritten$iv != 0) {
                    tail$iv.writeBackData(data$iv, bytesWritten$iv);
                    tail$iv.setLimit(tail$iv.getLimit() + bytesWritten$iv);
                    buffer$iv.setSizeMut(buffer$iv.getSizeMut() + bytesWritten$iv);
                } else if (SegmentKt.isEmpty(tail$iv)) {
                    buffer$iv.recycleTail();
                }
            }
            InlineMarker.mark(0);
            $this$writeWhile.flush(continuation);
            InlineMarker.mark(1);
        }
        return Unit.INSTANCE;
    }
}