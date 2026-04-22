package shark.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.HeapField;
import shark.HeapObject;
import shark.HeapValue;
import shark.internal.ChainingInstanceReferenceReader;
import shark.internal.Reference;
import tv.danmaku.bili.ui.loginv2.LoginActivityV2;

/* compiled from: InternalSharedExpanderHelpers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00100\r¢\u0006\u0002\u0010\u0011J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lshark/internal/InternalSharedHashMapReferenceReader;", "Lshark/internal/ChainingInstanceReferenceReader$VirtualInstanceReferenceReader;", "className", "", "tableFieldName", "nodeClassName", "nodeNextFieldName", "nodeKeyFieldName", "nodeValueFieldName", "keyName", "keysOnly", "", "matches", "Lkotlin/Function1;", "Lshark/HeapObject$HeapInstance;", "declaringClassId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "instance", "read", "Lkotlin/sequences/Sequence;", "Lshark/internal/Reference;", "source", "shark"}, k = 1, mv = {1, 4, 1})
public final class InternalSharedHashMapReferenceReader implements ChainingInstanceReferenceReader.VirtualInstanceReferenceReader {
    private final String className;
    private final Function1<HeapObject.HeapInstance, Long> declaringClassId;
    private final String keyName;
    private final boolean keysOnly;
    private final Function1<HeapObject.HeapInstance, Boolean> matches;
    private final String nodeClassName;
    private final String nodeKeyFieldName;
    private final String nodeNextFieldName;
    private final String nodeValueFieldName;
    private final String tableFieldName;

    /* JADX WARN: Multi-variable type inference failed */
    public InternalSharedHashMapReferenceReader(String className, String tableFieldName, String nodeClassName, String nodeNextFieldName, String nodeKeyFieldName, String nodeValueFieldName, String keyName, boolean keysOnly, Function1<? super HeapObject.HeapInstance, Boolean> function1, Function1<? super HeapObject.HeapInstance, Long> function12) {
        Intrinsics.checkParameterIsNotNull(className, "className");
        Intrinsics.checkParameterIsNotNull(tableFieldName, "tableFieldName");
        Intrinsics.checkParameterIsNotNull(nodeClassName, "nodeClassName");
        Intrinsics.checkParameterIsNotNull(nodeNextFieldName, "nodeNextFieldName");
        Intrinsics.checkParameterIsNotNull(nodeKeyFieldName, "nodeKeyFieldName");
        Intrinsics.checkParameterIsNotNull(nodeValueFieldName, "nodeValueFieldName");
        Intrinsics.checkParameterIsNotNull(keyName, "keyName");
        Intrinsics.checkParameterIsNotNull(function1, "matches");
        Intrinsics.checkParameterIsNotNull(function12, "declaringClassId");
        this.className = className;
        this.tableFieldName = tableFieldName;
        this.nodeClassName = nodeClassName;
        this.nodeNextFieldName = nodeNextFieldName;
        this.nodeKeyFieldName = nodeKeyFieldName;
        this.nodeValueFieldName = nodeValueFieldName;
        this.keyName = keyName;
        this.keysOnly = keysOnly;
        this.matches = function1;
        this.declaringClassId = function12;
    }

    @Override // shark.internal.ChainingInstanceReferenceReader.VirtualInstanceReferenceReader
    public boolean matches(HeapObject.HeapInstance instance) {
        Intrinsics.checkParameterIsNotNull(instance, "instance");
        return ((Boolean) this.matches.invoke(instance)).booleanValue();
    }

    @Override // shark.internal.ReferenceReader
    public Sequence<Reference> read(HeapObject.HeapInstance source) {
        Intrinsics.checkParameterIsNotNull(source, "source");
        HeapField heapField = source.get(this.className, this.tableFieldName);
        if (heapField == null) {
            Intrinsics.throwNpe();
        }
        HeapObject.HeapObjectArray table = heapField.getValueAsObjectArray();
        if (table != null) {
            Sequence entries = SequencesKt.flatten(SequencesKt.mapNotNull(table.readElements(), new Function1<HeapValue, Sequence<? extends HeapObject.HeapInstance>>() { // from class: shark.internal.InternalSharedHashMapReferenceReader$read$entries$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final Sequence<HeapObject.HeapInstance> invoke(HeapValue entryRef) {
                    Intrinsics.checkParameterIsNotNull(entryRef, "entryRef");
                    if (entryRef.isNonNullReference()) {
                        HeapObject asObject = entryRef.getAsObject();
                        if (asObject == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject.HeapInstance entry = asObject.getAsInstance();
                        if (entry == null) {
                            Intrinsics.throwNpe();
                        }
                        return SequencesKt.generateSequence(entry, new Function1<HeapObject.HeapInstance, HeapObject.HeapInstance>() { // from class: shark.internal.InternalSharedHashMapReferenceReader$read$entries$1.1
                            {
                                super(1);
                            }

                            public final HeapObject.HeapInstance invoke(HeapObject.HeapInstance node) {
                                String str;
                                String str2;
                                Intrinsics.checkParameterIsNotNull(node, "node");
                                str = InternalSharedHashMapReferenceReader.this.nodeClassName;
                                str2 = InternalSharedHashMapReferenceReader.this.nodeNextFieldName;
                                HeapField heapField2 = node.get(str, str2);
                                if (heapField2 == null) {
                                    Intrinsics.throwNpe();
                                }
                                return heapField2.getValueAsInstance();
                            }
                        });
                    }
                    return null;
                }
            }));
            final long declaringClassId = ((Number) this.declaringClassId.invoke(source)).longValue();
            final Function1 createKeyRef = new Function1<HeapValue, Reference>() { // from class: shark.internal.InternalSharedHashMapReferenceReader$read$createKeyRef$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final Reference invoke(HeapValue key) {
                    Intrinsics.checkParameterIsNotNull(key, "key");
                    if (key.isNonNullReference()) {
                        Long asObjectId = key.getAsObjectId();
                        if (asObjectId == null) {
                            Intrinsics.throwNpe();
                        }
                        return new Reference(asObjectId.longValue(), false, new Reference.LazyDetails.Resolver() { // from class: shark.internal.InternalSharedHashMapReferenceReader$read$createKeyRef$1.1
                            @Override // shark.internal.Reference.LazyDetails.Resolver
                            public final Reference.LazyDetails resolve() {
                                String str;
                                str = InternalSharedHashMapReferenceReader.this.keyName;
                                return new Reference.LazyDetails(str, declaringClassId, ReferenceLocationType.ARRAY_ENTRY, null, true);
                            }
                        });
                    }
                    return null;
                }
            };
            if (this.keysOnly) {
                return SequencesKt.mapNotNull(entries, new Function1<HeapObject.HeapInstance, Reference>() { // from class: shark.internal.InternalSharedHashMapReferenceReader$read$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Reference invoke(HeapObject.HeapInstance entry) {
                        String str;
                        String str2;
                        Intrinsics.checkParameterIsNotNull(entry, LoginActivityV2.LOGIN_ENTRY_KEY);
                        str = InternalSharedHashMapReferenceReader.this.nodeClassName;
                        str2 = InternalSharedHashMapReferenceReader.this.nodeKeyFieldName;
                        HeapField heapField2 = entry.get(str, str2);
                        if (heapField2 == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapValue key = heapField2.getValue();
                        return (Reference) createKeyRef.invoke(key);
                    }
                });
            }
            return SequencesKt.flatMap(entries, new InternalSharedHashMapReferenceReader$read$2(this, createKeyRef, declaringClassId));
        }
        return SequencesKt.emptySequence();
    }
}