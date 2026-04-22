package shark.internal;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.HeapField;
import shark.HeapObject;
import shark.internal.ChainingInstanceReferenceReader;

/* compiled from: InternalSharedExpanderHelpers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lshark/internal/InternalSharedLinkedListReferenceReader;", "Lshark/internal/ChainingInstanceReferenceReader$VirtualInstanceReferenceReader;", "classObjectId", "", "headFieldName", "", "nodeClassName", "nodeNextFieldName", "nodeElementFieldName", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "matches", "", "instance", "Lshark/HeapObject$HeapInstance;", "read", "Lkotlin/sequences/Sequence;", "Lshark/internal/Reference;", "source", "shark"}, k = 1, mv = {1, 4, 1})
public final class InternalSharedLinkedListReferenceReader implements ChainingInstanceReferenceReader.VirtualInstanceReferenceReader {
    private final long classObjectId;
    private final String headFieldName;
    private final String nodeClassName;
    private final String nodeElementFieldName;
    private final String nodeNextFieldName;

    public InternalSharedLinkedListReferenceReader(long classObjectId, String headFieldName, String nodeClassName, String nodeNextFieldName, String nodeElementFieldName) {
        Intrinsics.checkParameterIsNotNull(headFieldName, "headFieldName");
        Intrinsics.checkParameterIsNotNull(nodeClassName, "nodeClassName");
        Intrinsics.checkParameterIsNotNull(nodeNextFieldName, "nodeNextFieldName");
        Intrinsics.checkParameterIsNotNull(nodeElementFieldName, "nodeElementFieldName");
        this.classObjectId = classObjectId;
        this.headFieldName = headFieldName;
        this.nodeClassName = nodeClassName;
        this.nodeNextFieldName = nodeNextFieldName;
        this.nodeElementFieldName = nodeElementFieldName;
    }

    @Override // shark.internal.ChainingInstanceReferenceReader.VirtualInstanceReferenceReader
    public boolean matches(HeapObject.HeapInstance instance) {
        Intrinsics.checkParameterIsNotNull(instance, "instance");
        return instance.getInstanceClassId() == this.classObjectId;
    }

    @Override // shark.internal.ReferenceReader
    public Sequence<Reference> read(HeapObject.HeapInstance source) {
        Intrinsics.checkParameterIsNotNull(source, "source");
        long instanceClassId = source.getInstanceClassId();
        HeapField heapField = source.get("java.util.LinkedList", this.headFieldName);
        if (heapField == null) {
            Intrinsics.throwNpe();
        }
        HeapObject.HeapInstance firstNode = heapField.getValueAsInstance();
        final Set visitedNodes = new LinkedHashSet();
        if (firstNode != null) {
            visitedNodes.add(Long.valueOf(firstNode.getObjectId()));
        }
        return SequencesKt.mapNotNull(SequencesKt.withIndex(SequencesKt.generateSequence(firstNode, new Function1<HeapObject.HeapInstance, HeapObject.HeapInstance>() { // from class: shark.internal.InternalSharedLinkedListReferenceReader$read$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final HeapObject.HeapInstance invoke(HeapObject.HeapInstance node) {
                String str;
                String str2;
                Intrinsics.checkParameterIsNotNull(node, "node");
                str = InternalSharedLinkedListReferenceReader.this.nodeClassName;
                str2 = InternalSharedLinkedListReferenceReader.this.nodeNextFieldName;
                HeapField heapField2 = node.get(str, str2);
                if (heapField2 == null) {
                    Intrinsics.throwNpe();
                }
                HeapObject.HeapInstance nextNode = heapField2.getValueAsInstance();
                if (nextNode != null && visitedNodes.add(Long.valueOf(nextNode.getObjectId()))) {
                    return nextNode;
                }
                return null;
            }
        })), new InternalSharedLinkedListReferenceReader$read$2(this, instanceClassId));
    }
}