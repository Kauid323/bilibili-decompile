package shark.internal;

import kotlin.Metadata;
import kotlin.sequences.Sequence;
import shark.HeapGraph;
import shark.HeapObject;

/* compiled from: ReferenceReader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bà\u0080\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\tJ\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"Lshark/internal/ReferenceReader;", "T", "Lshark/HeapObject;", "", "read", "Lkotlin/sequences/Sequence;", "Lshark/internal/Reference;", "source", "(Lshark/HeapObject;)Lkotlin/sequences/Sequence;", "Factory", "shark"}, k = 1, mv = {1, 4, 1})
public interface ReferenceReader<T extends HeapObject> {

    /* compiled from: ReferenceReader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lshark/internal/ReferenceReader$Factory;", "T", "Lshark/HeapObject;", "", "create", "Lshark/internal/ReferenceReader;", "graph", "Lshark/HeapGraph;", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface Factory<T extends HeapObject> {
        ReferenceReader<T> create(HeapGraph heapGraph);
    }

    Sequence<Reference> read(T t);
}