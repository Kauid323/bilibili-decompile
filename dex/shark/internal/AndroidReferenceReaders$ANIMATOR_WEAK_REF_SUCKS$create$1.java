package shark.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.HeapField;
import shark.HeapObject;
import shark.ValueHolder;
import shark.internal.ChainingInstanceReferenceReader;
import shark.internal.Reference;

/* compiled from: AndroidReferenceReaders.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"shark/internal/AndroidReferenceReaders$ANIMATOR_WEAK_REF_SUCKS$create$1", "Lshark/internal/ChainingInstanceReferenceReader$VirtualInstanceReferenceReader;", "matches", "", "instance", "Lshark/HeapObject$HeapInstance;", "read", "Lkotlin/sequences/Sequence;", "Lshark/internal/Reference;", "source", "shark"}, k = 1, mv = {1, 4, 1})
public final class AndroidReferenceReaders$ANIMATOR_WEAK_REF_SUCKS$create$1 implements ChainingInstanceReferenceReader.VirtualInstanceReferenceReader {
    final /* synthetic */ long $objectAnimatorClassId;
    final /* synthetic */ long $weakRefClassId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidReferenceReaders$ANIMATOR_WEAK_REF_SUCKS$create$1(long $captured_local_variable$0, long $captured_local_variable$1) {
        this.$objectAnimatorClassId = $captured_local_variable$0;
        this.$weakRefClassId = $captured_local_variable$1;
    }

    @Override // shark.internal.ChainingInstanceReferenceReader.VirtualInstanceReferenceReader
    public boolean matches(HeapObject.HeapInstance instance) {
        Intrinsics.checkParameterIsNotNull(instance, "instance");
        return instance.getInstanceClassId() == this.$objectAnimatorClassId;
    }

    @Override // shark.internal.ReferenceReader
    public Sequence<Reference> read(HeapObject.HeapInstance source) {
        HeapObject.HeapInstance mTarget;
        Intrinsics.checkParameterIsNotNull(source, "source");
        HeapField heapField = source.get("android.animation.ObjectAnimator", "mTarget");
        if (heapField == null || (mTarget = heapField.getValueAsInstance()) == null) {
            return SequencesKt.emptySequence();
        }
        if (mTarget.getInstanceClassId() != this.$weakRefClassId) {
            return SequencesKt.emptySequence();
        }
        HeapField heapField2 = mTarget.get("java.lang.ref.Reference", "referent");
        if (heapField2 == null) {
            Intrinsics.throwNpe();
        }
        ValueHolder holder = heapField2.getValue().getHolder();
        if (holder != null) {
            ValueHolder.ReferenceHolder actualRef = (ValueHolder.ReferenceHolder) holder;
            return actualRef.isNull() ? SequencesKt.emptySequence() : SequencesKt.sequenceOf(new Reference[]{new Reference(actualRef.getValue(), true, new Reference.LazyDetails.Resolver() { // from class: shark.internal.AndroidReferenceReaders$ANIMATOR_WEAK_REF_SUCKS$create$1$read$1
                @Override // shark.internal.Reference.LazyDetails.Resolver
                public final Reference.LazyDetails resolve() {
                    return new Reference.LazyDetails("mTarget", AndroidReferenceReaders$ANIMATOR_WEAK_REF_SUCKS$create$1.this.$objectAnimatorClassId, ReferenceLocationType.INSTANCE_FIELD, null, true);
                }
            })});
        }
        throw new TypeCastException("null cannot be cast to non-null type shark.ValueHolder.ReferenceHolder");
    }
}