package kotlinx.io.unsafe;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Segment;

/* compiled from: UnsafeBufferOperations.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ar\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042K\u0010\u0005\u001aG\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u0006H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\"\u001c\u0010\u000e\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u001c\u0010\u0013\u001a\u00020\u00148\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017\"\u001c\u0010\u0018\u001a\u00020\u00198\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"withData", "", "Lkotlinx/io/unsafe/SegmentReadContext;", "segment", "Lkotlinx/io/Segment;", "readAction", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "bytes", "", "startIndexInclusive", "endIndexExclusive", "SegmentReadContextImpl", "getSegmentReadContextImpl$annotations", "()V", "getSegmentReadContextImpl", "()Lkotlinx/io/unsafe/SegmentReadContext;", "SegmentWriteContextImpl", "Lkotlinx/io/unsafe/SegmentWriteContext;", "getSegmentWriteContextImpl$annotations", "getSegmentWriteContextImpl", "()Lkotlinx/io/unsafe/SegmentWriteContext;", "BufferIterationContextImpl", "Lkotlinx/io/unsafe/BufferIterationContext;", "getBufferIterationContextImpl$annotations", "getBufferIterationContextImpl", "()Lkotlinx/io/unsafe/BufferIterationContext;", "kotlinx-io-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class UnsafeBufferOperationsKt {
    private static final SegmentReadContext SegmentReadContextImpl = new SegmentReadContext() { // from class: kotlinx.io.unsafe.UnsafeBufferOperationsKt$SegmentReadContextImpl$1
        @Override // kotlinx.io.unsafe.SegmentReadContext
        public byte getUnchecked(Segment segment, int offset) {
            Intrinsics.checkNotNullParameter(segment, "segment");
            return segment.getUnchecked$kotlinx_io_core(offset);
        }
    };
    private static final SegmentWriteContext SegmentWriteContextImpl = new SegmentWriteContext() { // from class: kotlinx.io.unsafe.UnsafeBufferOperationsKt$SegmentWriteContextImpl$1
        @Override // kotlinx.io.unsafe.SegmentWriteContext
        public void setUnchecked(Segment segment, int offset, byte value) {
            Intrinsics.checkNotNullParameter(segment, "segment");
            segment.setUnchecked$kotlinx_io_core(offset, value);
        }

        @Override // kotlinx.io.unsafe.SegmentWriteContext
        public void setUnchecked(Segment segment, int offset, byte b0, byte b1) {
            Intrinsics.checkNotNullParameter(segment, "segment");
            segment.setUnchecked$kotlinx_io_core(offset, b0, b1);
        }

        @Override // kotlinx.io.unsafe.SegmentWriteContext
        public void setUnchecked(Segment segment, int offset, byte b0, byte b1, byte b2) {
            Intrinsics.checkNotNullParameter(segment, "segment");
            segment.setUnchecked$kotlinx_io_core(offset, b0, b1, b2);
        }

        @Override // kotlinx.io.unsafe.SegmentWriteContext
        public void setUnchecked(Segment segment, int offset, byte b0, byte b1, byte b2, byte b3) {
            Intrinsics.checkNotNullParameter(segment, "segment");
            segment.setUnchecked$kotlinx_io_core(offset, b0, b1, b2, b3);
        }
    };
    private static final BufferIterationContext BufferIterationContextImpl = new BufferIterationContext() { // from class: kotlinx.io.unsafe.UnsafeBufferOperationsKt$BufferIterationContextImpl$1
        @Override // kotlinx.io.unsafe.BufferIterationContext
        public Segment next(Segment segment) {
            Intrinsics.checkNotNullParameter(segment, "segment");
            return segment.getNext();
        }

        @Override // kotlinx.io.unsafe.SegmentReadContext
        public byte getUnchecked(Segment segment, int offset) {
            SegmentReadContext segmentReadContext;
            Intrinsics.checkNotNullParameter(segment, "segment");
            segmentReadContext = UnsafeBufferOperationsKt.SegmentReadContextImpl;
            return segmentReadContext.getUnchecked(segment, offset);
        }
    };

    public static /* synthetic */ void getBufferIterationContextImpl$annotations() {
    }

    public static /* synthetic */ void getSegmentReadContextImpl$annotations() {
    }

    public static /* synthetic */ void getSegmentWriteContextImpl$annotations() {
    }

    public static final /* synthetic */ void withData(SegmentReadContext $this$withData, Segment segment, Function3<? super byte[], ? super Integer, ? super Integer, Unit> readAction) {
        Intrinsics.checkNotNullParameter($this$withData, "<this>");
        Intrinsics.checkNotNullParameter(segment, "segment");
        Intrinsics.checkNotNullParameter(readAction, "readAction");
        readAction.invoke(segment.dataAsByteArray(true), Integer.valueOf(segment.getPos()), Integer.valueOf(segment.getLimit()));
    }
}