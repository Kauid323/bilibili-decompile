package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: ElementMarker.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\u0006\u0010\u0012\u001a\u00020\u0006J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkotlinx/serialization/internal/ElementMarker;", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "readIfAbsent", "Lkotlin/Function2;", "", "", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function2;)V", "highMarksArray", "", "lowerMarks", "", "mark", "", "index", "markHigh", "nextUnmarkedHighIndex", "nextUnmarkedIndex", "prepareHighMarksArray", "elementsCount", "Companion", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ElementMarker {
    private static final Companion Companion = new Companion(null);
    private static final long[] EMPTY_HIGH_MARKS = new long[0];
    private final SerialDescriptor descriptor;
    private final long[] highMarksArray;
    private long lowerMarks;
    private final Function2<SerialDescriptor, Integer, Boolean> readIfAbsent;

    /* JADX WARN: Multi-variable type inference failed */
    public ElementMarker(SerialDescriptor descriptor, Function2<? super SerialDescriptor, ? super Integer, Boolean> readIfAbsent) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(readIfAbsent, "readIfAbsent");
        this.descriptor = descriptor;
        this.readIfAbsent = readIfAbsent;
        int elementsCount = this.descriptor.getElementsCount();
        if (elementsCount <= 64) {
            this.lowerMarks = elementsCount != 64 ? (-1) << elementsCount : 0L;
            this.highMarksArray = EMPTY_HIGH_MARKS;
            return;
        }
        this.lowerMarks = 0L;
        this.highMarksArray = prepareHighMarksArray(elementsCount);
    }

    /* compiled from: ElementMarker.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/serialization/internal/ElementMarker$Companion;", "", "()V", "EMPTY_HIGH_MARKS", "", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void mark(int index) {
        if (index < 64) {
            this.lowerMarks |= 1 << index;
        } else {
            markHigh(index);
        }
    }

    public final int nextUnmarkedIndex() {
        int elementsCount = this.descriptor.getElementsCount();
        while (this.lowerMarks != -1) {
            int index = Long.numberOfTrailingZeros(~this.lowerMarks);
            this.lowerMarks |= 1 << index;
            if (this.readIfAbsent.invoke(this.descriptor, Integer.valueOf(index)).booleanValue()) {
                return index;
            }
        }
        if (elementsCount > 64) {
            return nextUnmarkedHighIndex();
        }
        return -1;
    }

    private final long[] prepareHighMarksArray(int elementsCount) {
        int slotsCount = (elementsCount - 1) >>> 6;
        int elementsInLastSlot = elementsCount & 63;
        long[] highMarks = new long[slotsCount];
        if (elementsInLastSlot != 0) {
            highMarks[ArraysKt.getLastIndex(highMarks)] = (-1) << elementsCount;
        }
        return highMarks;
    }

    private final void markHigh(int index) {
        int slot = (index >>> 6) - 1;
        int offsetInSlot = index & 63;
        this.highMarksArray[slot] = this.highMarksArray[slot] | (1 << offsetInSlot);
    }

    private final int nextUnmarkedHighIndex() {
        int length = this.highMarksArray.length;
        for (int slot = 0; slot < length; slot++) {
            int slotOffset = (slot + 1) * 64;
            long slotMarks = this.highMarksArray[slot];
            while (slotMarks != -1) {
                int indexInSlot = Long.numberOfTrailingZeros(~slotMarks);
                slotMarks |= 1 << indexInSlot;
                int index = slotOffset + indexInSlot;
                if (this.readIfAbsent.invoke(this.descriptor, Integer.valueOf(index)).booleanValue()) {
                    this.highMarksArray[slot] = slotMarks;
                    return index;
                }
            }
            this.highMarksArray[slot] = slotMarks;
        }
        return -1;
    }
}