package shark.internal;

import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import shark.HeapField;
import shark.HeapObject;
import shark.internal.Reference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InternalSharedExpanderHelpers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lshark/internal/Reference;", "<name for destructuring parameter 0>", "Lkotlin/collections/IndexedValue;", "Lshark/HeapObject$HeapInstance;", "invoke"}, k = 3, mv = {1, 4, 1})
public final class InternalSharedLinkedListReferenceReader$read$2 extends Lambda implements Function1<IndexedValue<? extends HeapObject.HeapInstance>, Reference> {
    final /* synthetic */ long $instanceClassId;
    final /* synthetic */ InternalSharedLinkedListReferenceReader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InternalSharedLinkedListReferenceReader$read$2(InternalSharedLinkedListReferenceReader internalSharedLinkedListReferenceReader, long j) {
        super(1);
        this.this$0 = internalSharedLinkedListReferenceReader;
        this.$instanceClassId = j;
    }

    public final Reference invoke(IndexedValue<HeapObject.HeapInstance> indexedValue) {
        String str;
        String str2;
        Intrinsics.checkParameterIsNotNull(indexedValue, "<name for destructuring parameter 0>");
        final int index = indexedValue.component1();
        HeapObject.HeapInstance node = (HeapObject.HeapInstance) indexedValue.component2();
        str = this.this$0.nodeClassName;
        str2 = this.this$0.nodeElementFieldName;
        HeapField heapField = node.get(str, str2);
        if (heapField == null) {
            Intrinsics.throwNpe();
        }
        Long itemObjectId = heapField.getValue().getAsObjectId();
        if (itemObjectId != null) {
            long $this$run = itemObjectId.longValue();
            return new Reference($this$run, false, new Reference.LazyDetails.Resolver() { // from class: shark.internal.InternalSharedLinkedListReferenceReader$read$2$$special$$inlined$run$lambda$1
                @Override // shark.internal.Reference.LazyDetails.Resolver
                public final Reference.LazyDetails resolve() {
                    return new Reference.LazyDetails(String.valueOf(index), InternalSharedLinkedListReferenceReader$read$2.this.$instanceClassId, ReferenceLocationType.ARRAY_ENTRY, null, true);
                }
            });
        }
        return null;
    }
}