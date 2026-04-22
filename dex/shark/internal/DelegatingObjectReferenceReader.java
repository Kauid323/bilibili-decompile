package shark.internal;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.HeapObject;

/* compiled from: DelegatingObjectReferenceReader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lshark/internal/DelegatingObjectReferenceReader;", "Lshark/internal/ReferenceReader;", "Lshark/HeapObject;", "classReferenceReader", "Lshark/HeapObject$HeapClass;", "instanceReferenceReader", "Lshark/HeapObject$HeapInstance;", "objectArrayReferenceReader", "Lshark/HeapObject$HeapObjectArray;", "(Lshark/internal/ReferenceReader;Lshark/internal/ReferenceReader;Lshark/internal/ReferenceReader;)V", "read", "Lkotlin/sequences/Sequence;", "Lshark/internal/Reference;", "source", "shark"}, k = 1, mv = {1, 4, 1})
public final class DelegatingObjectReferenceReader implements ReferenceReader<HeapObject> {
    private final ReferenceReader<HeapObject.HeapClass> classReferenceReader;
    private final ReferenceReader<HeapObject.HeapInstance> instanceReferenceReader;
    private final ReferenceReader<HeapObject.HeapObjectArray> objectArrayReferenceReader;

    public DelegatingObjectReferenceReader(ReferenceReader<HeapObject.HeapClass> referenceReader, ReferenceReader<HeapObject.HeapInstance> referenceReader2, ReferenceReader<HeapObject.HeapObjectArray> referenceReader3) {
        Intrinsics.checkParameterIsNotNull(referenceReader, "classReferenceReader");
        Intrinsics.checkParameterIsNotNull(referenceReader2, "instanceReferenceReader");
        Intrinsics.checkParameterIsNotNull(referenceReader3, "objectArrayReferenceReader");
        this.classReferenceReader = referenceReader;
        this.instanceReferenceReader = referenceReader2;
        this.objectArrayReferenceReader = referenceReader3;
    }

    @Override // shark.internal.ReferenceReader
    public Sequence<Reference> read(HeapObject source) {
        Intrinsics.checkParameterIsNotNull(source, "source");
        if (source instanceof HeapObject.HeapClass) {
            return this.classReferenceReader.read(source);
        }
        if (source instanceof HeapObject.HeapInstance) {
            return this.instanceReferenceReader.read(source);
        }
        if (source instanceof HeapObject.HeapObjectArray) {
            return this.objectArrayReferenceReader.read(source);
        }
        if (source instanceof HeapObject.HeapPrimitiveArray) {
            return SequencesKt.emptySequence();
        }
        throw new NoWhenBranchMatchedException();
    }
}