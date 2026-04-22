package shark.internal;

import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.HeapField;
import shark.HeapObject;
import shark.HeapValue;
import shark.internal.ChainingInstanceReferenceReader;
import shark.internal.Reference;

/* compiled from: InternalSharedExpanderHelpers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lshark/internal/InternalSharedArrayListReferenceReader;", "Lshark/internal/ChainingInstanceReferenceReader$VirtualInstanceReferenceReader;", "className", "", "classObjectId", "", "elementArrayName", "sizeFieldName", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "matches", "", "instance", "Lshark/HeapObject$HeapInstance;", "read", "Lkotlin/sequences/Sequence;", "Lshark/internal/Reference;", "source", "shark"}, k = 1, mv = {1, 4, 1})
public final class InternalSharedArrayListReferenceReader implements ChainingInstanceReferenceReader.VirtualInstanceReferenceReader {
    private final String className;
    private final long classObjectId;
    private final String elementArrayName;
    private final String sizeFieldName;

    public InternalSharedArrayListReferenceReader(String className, long classObjectId, String elementArrayName, String sizeFieldName) {
        Intrinsics.checkParameterIsNotNull(className, "className");
        Intrinsics.checkParameterIsNotNull(elementArrayName, "elementArrayName");
        this.className = className;
        this.classObjectId = classObjectId;
        this.elementArrayName = elementArrayName;
        this.sizeFieldName = sizeFieldName;
    }

    @Override // shark.internal.ChainingInstanceReferenceReader.VirtualInstanceReferenceReader
    public boolean matches(HeapObject.HeapInstance instance) {
        Intrinsics.checkParameterIsNotNull(instance, "instance");
        return instance.getInstanceClassId() == this.classObjectId;
    }

    @Override // shark.internal.ReferenceReader
    public Sequence<Reference> read(HeapObject.HeapInstance source) {
        Sequence elements;
        Intrinsics.checkParameterIsNotNull(source, "source");
        final long instanceClassId = source.getInstanceClassId();
        HeapField heapField = source.get(this.className, this.elementArrayName);
        if (heapField == null) {
            Intrinsics.throwNpe();
        }
        HeapObject.HeapObjectArray elementFieldRef = heapField.getValueAsObjectArray();
        if (elementFieldRef == null) {
            return SequencesKt.emptySequence();
        }
        if (this.sizeFieldName != null) {
            HeapField heapField2 = source.get(this.className, this.sizeFieldName);
            if (heapField2 == null) {
                Intrinsics.throwNpe();
            }
            Integer asInt = heapField2.getValue().getAsInt();
            if (asInt == null) {
                Intrinsics.throwNpe();
            }
            int size = asInt.intValue();
            elements = SequencesKt.take(elementFieldRef.readElements(), size);
        } else {
            elements = elementFieldRef.readElements();
        }
        return SequencesKt.mapNotNull(SequencesKt.withIndex(elements), new Function1<IndexedValue<? extends HeapValue>, Reference>() { // from class: shark.internal.InternalSharedArrayListReferenceReader$read$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Reference invoke(IndexedValue<HeapValue> indexedValue) {
                Intrinsics.checkParameterIsNotNull(indexedValue, "<name for destructuring parameter 0>");
                final int index = indexedValue.component1();
                HeapValue elementValue = (HeapValue) indexedValue.component2();
                if (elementValue.isNonNullReference()) {
                    Long asObjectId = elementValue.getAsObjectId();
                    if (asObjectId == null) {
                        Intrinsics.throwNpe();
                    }
                    return new Reference(asObjectId.longValue(), false, new Reference.LazyDetails.Resolver() { // from class: shark.internal.InternalSharedArrayListReferenceReader$read$1.1
                        @Override // shark.internal.Reference.LazyDetails.Resolver
                        public final Reference.LazyDetails resolve() {
                            return new Reference.LazyDetails(String.valueOf(index), instanceClassId, ReferenceLocationType.ARRAY_ENTRY, null, true);
                        }
                    });
                }
                return null;
            }
        });
    }
}