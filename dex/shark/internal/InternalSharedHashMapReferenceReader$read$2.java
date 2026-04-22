package shark.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.HeapField;
import shark.HeapObject;
import shark.HeapValue;
import shark.internal.Reference;
import tv.danmaku.bili.ui.loginv2.LoginActivityV2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InternalSharedExpanderHelpers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/sequences/Sequence;", "Lshark/internal/Reference;", LoginActivityV2.LOGIN_ENTRY_KEY, "Lshark/HeapObject$HeapInstance;", "invoke"}, k = 3, mv = {1, 4, 1})
public final class InternalSharedHashMapReferenceReader$read$2 extends Lambda implements Function1<HeapObject.HeapInstance, Sequence<? extends Reference>> {
    final /* synthetic */ Function1 $createKeyRef;
    final /* synthetic */ long $declaringClassId;
    final /* synthetic */ InternalSharedHashMapReferenceReader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InternalSharedHashMapReferenceReader$read$2(InternalSharedHashMapReferenceReader internalSharedHashMapReferenceReader, Function1 function1, long j) {
        super(1);
        this.this$0 = internalSharedHashMapReferenceReader;
        this.$createKeyRef = function1;
        this.$declaringClassId = j;
    }

    public final Sequence<Reference> invoke(HeapObject.HeapInstance entry) {
        String str;
        String str2;
        String str3;
        String str4;
        Reference valueRef;
        Intrinsics.checkParameterIsNotNull(entry, LoginActivityV2.LOGIN_ENTRY_KEY);
        str = this.this$0.nodeClassName;
        str2 = this.this$0.nodeKeyFieldName;
        HeapField heapField = entry.get(str, str2);
        if (heapField == null) {
            Intrinsics.throwNpe();
        }
        final HeapValue key = heapField.getValue();
        Reference keyRef = (Reference) this.$createKeyRef.invoke(key);
        str3 = this.this$0.nodeClassName;
        str4 = this.this$0.nodeValueFieldName;
        HeapField heapField2 = entry.get(str3, str4);
        if (heapField2 == null) {
            Intrinsics.throwNpe();
        }
        HeapValue value = heapField2.getValue();
        if (value.isNonNullReference()) {
            Long asObjectId = value.getAsObjectId();
            if (asObjectId == null) {
                Intrinsics.throwNpe();
            }
            valueRef = new Reference(asObjectId.longValue(), false, new Reference.LazyDetails.Resolver() { // from class: shark.internal.InternalSharedHashMapReferenceReader$read$2$valueRef$1
                @Override // shark.internal.Reference.LazyDetails.Resolver
                public final Reference.LazyDetails resolve() {
                    HeapObject.HeapInstance asInstance;
                    String it;
                    HeapObject asObject = key.getAsObject();
                    String str5 = null;
                    String it2 = (asObject == null || (asInstance = asObject.getAsInstance()) == null || (it = asInstance.readAsJavaString()) == null) ? null : '\"' + it + '\"';
                    if (it2 != null) {
                        str5 = it2;
                    } else {
                        HeapObject asObject2 = key.getAsObject();
                        if (asObject2 != null) {
                            str5 = asObject2.toString();
                        }
                    }
                    if (str5 == null) {
                        str5 = "null";
                    }
                    String keyAsName = str5;
                    return new Reference.LazyDetails(keyAsName, InternalSharedHashMapReferenceReader$read$2.this.$declaringClassId, ReferenceLocationType.ARRAY_ENTRY, null, true);
                }
            });
        } else {
            valueRef = null;
        }
        return (keyRef == null || valueRef == null) ? keyRef != null ? SequencesKt.sequenceOf(new Reference[]{keyRef}) : valueRef != null ? SequencesKt.sequenceOf(new Reference[]{valueRef}) : SequencesKt.emptySequence() : SequencesKt.sequenceOf(new Reference[]{keyRef, valueRef});
    }
}