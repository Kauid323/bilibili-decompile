package shark.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.HeapGraph;
import shark.HeapObject;
import shark.HprofRecord;
import shark.internal.Reference;

/* compiled from: ObjectArrayReferenceReader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lshark/internal/ObjectArrayReferenceReader;", "Lshark/internal/ReferenceReader;", "Lshark/HeapObject$HeapObjectArray;", "()V", "read", "Lkotlin/sequences/Sequence;", "Lshark/internal/Reference;", "source", "Companion", "shark"}, k = 1, mv = {1, 4, 1})
public final class ObjectArrayReferenceReader implements ReferenceReader<HeapObject.HeapObjectArray> {
    public static final Companion Companion = new Companion(null);
    private static final List<String> skippablePrimitiveWrapperArrayTypes;

    @Override // shark.internal.ReferenceReader
    public Sequence<Reference> read(HeapObject.HeapObjectArray source) {
        Intrinsics.checkParameterIsNotNull(source, "source");
        if (Companion.isSkippablePrimitiveWrapperArray$shark(source)) {
            return SequencesKt.emptySequence();
        }
        final HeapGraph graph = source.getGraph();
        HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord record = source.readRecord();
        final long arrayClassId = source.getArrayClassId();
        return SequencesKt.mapIndexed(SequencesKt.filter(ArraysKt.asSequence(record.getElementIds()), new Function1<Long, Boolean>() { // from class: shark.internal.ObjectArrayReferenceReader$read$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Boolean.valueOf(invoke(((Number) obj).longValue()));
            }

            public final boolean invoke(long objectId) {
                return objectId != 0 && HeapGraph.this.objectExists(objectId);
            }
        }), new Function2<Integer, Long, Reference>() { // from class: shark.internal.ObjectArrayReferenceReader$read$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Number) obj).intValue(), ((Number) obj2).longValue());
            }

            public final Reference invoke(final int index, long elementObjectId) {
                return new Reference(elementObjectId, false, new Reference.LazyDetails.Resolver() { // from class: shark.internal.ObjectArrayReferenceReader$read$2.1
                    @Override // shark.internal.Reference.LazyDetails.Resolver
                    public final Reference.LazyDetails resolve() {
                        return new Reference.LazyDetails(String.valueOf(index), arrayClassId, ReferenceLocationType.ARRAY_ENTRY, null, false);
                    }
                });
            }
        });
    }

    /* compiled from: ObjectArrayReferenceReader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lshark/internal/ObjectArrayReferenceReader$Companion;", "", "()V", "skippablePrimitiveWrapperArrayTypes", "", "", "isSkippablePrimitiveWrapperArray", "", "Lshark/HeapObject$HeapObjectArray;", "isSkippablePrimitiveWrapperArray$shark", "(Lshark/HeapObject$HeapObjectArray;)Z", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final boolean isSkippablePrimitiveWrapperArray$shark(HeapObject.HeapObjectArray $this$isSkippablePrimitiveWrapperArray) {
            Intrinsics.checkParameterIsNotNull($this$isSkippablePrimitiveWrapperArray, "$this$isSkippablePrimitiveWrapperArray");
            return ObjectArrayReferenceReader.skippablePrimitiveWrapperArrayTypes.contains($this$isSkippablePrimitiveWrapperArray.getArrayClassName());
        }
    }

    static {
        Iterable $this$map$iv = SetsKt.setOf(new KClass[]{Reflection.getOrCreateKotlinClass(Boolean.TYPE), Reflection.getOrCreateKotlinClass(Character.TYPE), Reflection.getOrCreateKotlinClass(Float.TYPE), Reflection.getOrCreateKotlinClass(Double.TYPE), Reflection.getOrCreateKotlinClass(Byte.TYPE), Reflection.getOrCreateKotlinClass(Short.TYPE), Reflection.getOrCreateKotlinClass(Integer.TYPE), Reflection.getOrCreateKotlinClass(Long.TYPE)});
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KClass it = (KClass) item$iv$iv;
            destination$iv$iv.add(JvmClassMappingKt.getJavaObjectType(it).getName() + "[]");
        }
        skippablePrimitiveWrapperArrayTypes = (List) destination$iv$iv;
    }
}