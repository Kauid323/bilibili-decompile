package shark.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.HeapGraph;
import shark.HeapObject;

/* compiled from: ChainingInstanceReferenceReader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lshark/internal/ChainingInstanceReferenceReader;", "Lshark/internal/ReferenceReader;", "Lshark/HeapObject$HeapInstance;", "virtualRefReaders", "", "Lshark/internal/ChainingInstanceReferenceReader$VirtualInstanceReferenceReader;", "fieldRefReader", "Lshark/internal/FieldInstanceReferenceReader;", "(Ljava/util/List;Lshark/internal/FieldInstanceReferenceReader;)V", "expandVirtualRefs", "Lkotlin/sequences/Sequence;", "Lshark/internal/Reference;", "instance", "read", "source", "VirtualInstanceReferenceReader", "shark"}, k = 1, mv = {1, 4, 1})
public final class ChainingInstanceReferenceReader implements ReferenceReader<HeapObject.HeapInstance> {
    private final FieldInstanceReferenceReader fieldRefReader;
    private final List<VirtualInstanceReferenceReader> virtualRefReaders;

    /* compiled from: ChainingInstanceReferenceReader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H&¨\u0006\u0007"}, d2 = {"Lshark/internal/ChainingInstanceReferenceReader$VirtualInstanceReferenceReader;", "Lshark/internal/ReferenceReader;", "Lshark/HeapObject$HeapInstance;", "matches", "", "instance", "OptionalFactory", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface VirtualInstanceReferenceReader extends ReferenceReader<HeapObject.HeapInstance> {

        /* compiled from: ChainingInstanceReferenceReader.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lshark/internal/ChainingInstanceReferenceReader$VirtualInstanceReferenceReader$OptionalFactory;", "", "create", "Lshark/internal/ChainingInstanceReferenceReader$VirtualInstanceReferenceReader;", "graph", "Lshark/HeapGraph;", "shark"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public interface OptionalFactory {
            VirtualInstanceReferenceReader create(HeapGraph heapGraph);
        }

        boolean matches(HeapObject.HeapInstance heapInstance);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChainingInstanceReferenceReader(List<? extends VirtualInstanceReferenceReader> list, FieldInstanceReferenceReader fieldRefReader) {
        Intrinsics.checkParameterIsNotNull(list, "virtualRefReaders");
        Intrinsics.checkParameterIsNotNull(fieldRefReader, "fieldRefReader");
        this.virtualRefReaders = list;
        this.fieldRefReader = fieldRefReader;
    }

    @Override // shark.internal.ReferenceReader
    public Sequence<Reference> read(HeapObject.HeapInstance source) {
        Intrinsics.checkParameterIsNotNull(source, "source");
        Sequence virtualRefs = expandVirtualRefs(source);
        Sequence fieldRefs = this.fieldRefReader.read(source);
        return SequencesKt.plus(virtualRefs, fieldRefs);
    }

    private final Sequence<Reference> expandVirtualRefs(HeapObject.HeapInstance instance) {
        for (VirtualInstanceReferenceReader expander : this.virtualRefReaders) {
            if (expander.matches(instance)) {
                return expander.read(instance);
            }
        }
        return SequencesKt.emptySequence();
    }
}