package shark.internal;

import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.HeapField;
import shark.HeapObject;
import shark.internal.ChainingInstanceReferenceReader;
import shark.internal.Reference;

/* compiled from: AndroidReferenceReaders.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"shark/internal/AndroidReferenceReaders$MESSAGE_QUEUE$create$1", "Lshark/internal/ChainingInstanceReferenceReader$VirtualInstanceReferenceReader;", "matches", "", "instance", "Lshark/HeapObject$HeapInstance;", "read", "Lkotlin/sequences/Sequence;", "Lshark/internal/Reference;", "source", "shark"}, k = 1, mv = {1, 4, 1})
public final class AndroidReferenceReaders$MESSAGE_QUEUE$create$1 implements ChainingInstanceReferenceReader.VirtualInstanceReferenceReader {
    final /* synthetic */ long $messageQueueClassId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidReferenceReaders$MESSAGE_QUEUE$create$1(long $captured_local_variable$0) {
        this.$messageQueueClassId = $captured_local_variable$0;
    }

    @Override // shark.internal.ChainingInstanceReferenceReader.VirtualInstanceReferenceReader
    public boolean matches(HeapObject.HeapInstance instance) {
        Intrinsics.checkParameterIsNotNull(instance, "instance");
        return instance.getInstanceClassId() == this.$messageQueueClassId;
    }

    @Override // shark.internal.ReferenceReader
    public Sequence<Reference> read(HeapObject.HeapInstance source) {
        Intrinsics.checkParameterIsNotNull(source, "source");
        HeapField heapField = source.get("android.os.MessageQueue", "mMessages");
        if (heapField == null) {
            Intrinsics.throwNpe();
        }
        HeapObject.HeapInstance firstMessage = heapField.getValueAsInstance();
        return SequencesKt.map(SequencesKt.withIndex(SequencesKt.generateSequence(firstMessage, new Function1<HeapObject.HeapInstance, HeapObject.HeapInstance>() { // from class: shark.internal.AndroidReferenceReaders$MESSAGE_QUEUE$create$1$read$1
            public final HeapObject.HeapInstance invoke(HeapObject.HeapInstance node) {
                Intrinsics.checkParameterIsNotNull(node, "node");
                HeapField heapField2 = node.get("android.os.Message", "next");
                if (heapField2 == null) {
                    Intrinsics.throwNpe();
                }
                return heapField2.getValueAsInstance();
            }
        })), new Function1<IndexedValue<? extends HeapObject.HeapInstance>, Reference>() { // from class: shark.internal.AndroidReferenceReaders$MESSAGE_QUEUE$create$1$read$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final Reference invoke(IndexedValue<HeapObject.HeapInstance> indexedValue) {
                Intrinsics.checkParameterIsNotNull(indexedValue, "<name for destructuring parameter 0>");
                final int index = indexedValue.component1();
                HeapObject.HeapInstance node = (HeapObject.HeapInstance) indexedValue.component2();
                return new Reference(node.getObjectId(), false, new Reference.LazyDetails.Resolver() { // from class: shark.internal.AndroidReferenceReaders$MESSAGE_QUEUE$create$1$read$2.1
                    @Override // shark.internal.Reference.LazyDetails.Resolver
                    public final Reference.LazyDetails resolve() {
                        return new Reference.LazyDetails(String.valueOf(index), AndroidReferenceReaders$MESSAGE_QUEUE$create$1.this.$messageQueueClassId, ReferenceLocationType.ARRAY_ENTRY, null, true);
                    }
                });
            }
        });
    }
}