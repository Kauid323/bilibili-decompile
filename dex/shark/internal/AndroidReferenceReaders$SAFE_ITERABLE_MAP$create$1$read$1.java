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
/* compiled from: AndroidReferenceReaders.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/sequences/Sequence;", "Lshark/internal/Reference;", LoginActivityV2.LOGIN_ENTRY_KEY, "Lshark/HeapObject$HeapInstance;", "invoke"}, k = 3, mv = {1, 4, 1})
public final class AndroidReferenceReaders$SAFE_ITERABLE_MAP$create$1$read$1 extends Lambda implements Function1<HeapObject.HeapInstance, Sequence<? extends Reference>> {
    final /* synthetic */ long $locationClassObjectId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidReferenceReaders$SAFE_ITERABLE_MAP$create$1$read$1(long j) {
        super(1);
        this.$locationClassObjectId = j;
    }

    public final Sequence<Reference> invoke(HeapObject.HeapInstance entry) {
        Intrinsics.checkParameterIsNotNull(entry, LoginActivityV2.LOGIN_ENTRY_KEY);
        HeapField heapField = entry.get("androidx.arch.core.internal.SafeIterableMap$Entry", "mKey");
        if (heapField == null) {
            Intrinsics.throwNpe();
        }
        final HeapValue key = heapField.getValue();
        Long asObjectId = key.getAsObjectId();
        if (asObjectId == null) {
            Intrinsics.throwNpe();
        }
        Reference keyRef = new Reference(asObjectId.longValue(), false, new Reference.LazyDetails.Resolver() { // from class: shark.internal.AndroidReferenceReaders$SAFE_ITERABLE_MAP$create$1$read$1$keyRef$1
            @Override // shark.internal.Reference.LazyDetails.Resolver
            public final Reference.LazyDetails resolve() {
                return new Reference.LazyDetails("key()", AndroidReferenceReaders$SAFE_ITERABLE_MAP$create$1$read$1.this.$locationClassObjectId, ReferenceLocationType.ARRAY_ENTRY, null, true);
            }
        });
        HeapField heapField2 = entry.get("androidx.arch.core.internal.SafeIterableMap$Entry", "mValue");
        if (heapField2 == null) {
            Intrinsics.throwNpe();
        }
        HeapValue value = heapField2.getValue();
        Long asObjectId2 = value.getAsObjectId();
        if (asObjectId2 == null) {
            Intrinsics.throwNpe();
        }
        Reference valueRef = new Reference(asObjectId2.longValue(), false, new Reference.LazyDetails.Resolver() { // from class: shark.internal.AndroidReferenceReaders$SAFE_ITERABLE_MAP$create$1$read$1$valueRef$1
            @Override // shark.internal.Reference.LazyDetails.Resolver
            public final Reference.LazyDetails resolve() {
                HeapObject.HeapInstance asInstance;
                String it;
                HeapObject asObject = key.getAsObject();
                String str = null;
                String it2 = (asObject == null || (asInstance = asObject.getAsInstance()) == null || (it = asInstance.readAsJavaString()) == null) ? null : '\"' + it + '\"';
                if (it2 != null) {
                    str = it2;
                } else {
                    HeapObject asObject2 = key.getAsObject();
                    if (asObject2 != null) {
                        str = asObject2.toString();
                    }
                }
                if (str == null) {
                    str = "null";
                }
                String keyAsName = str;
                return new Reference.LazyDetails(keyAsName, AndroidReferenceReaders$SAFE_ITERABLE_MAP$create$1$read$1.this.$locationClassObjectId, ReferenceLocationType.ARRAY_ENTRY, null, true);
            }
        });
        return SequencesKt.sequenceOf(new Reference[]{keyRef, valueRef});
    }
}