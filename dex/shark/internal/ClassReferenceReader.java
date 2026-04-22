package shark.internal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.HeapField;
import shark.HeapGraph;
import shark.HeapObject;
import shark.IgnoredReferenceMatcher;
import shark.LibraryLeakReferenceMatcher;
import shark.ReferenceMatcher;
import shark.ReferenceMatcherKt;
import shark.ReferencePattern;
import shark.ValueHolder;
import shark.internal.Reference;

/* compiled from: ClassReferenceReader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R&\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lshark/internal/ClassReferenceReader;", "Lshark/internal/ReferenceReader;", "Lshark/HeapObject$HeapClass;", "graph", "Lshark/HeapGraph;", "referenceMatchers", "", "Lshark/ReferenceMatcher;", "(Lshark/HeapGraph;Ljava/util/List;)V", "staticFieldNameByClassName", "", "", "read", "Lkotlin/sequences/Sequence;", "Lshark/internal/Reference;", "source", "shark"}, k = 1, mv = {1, 4, 1})
public final class ClassReferenceReader implements ReferenceReader<HeapObject.HeapClass> {
    private final Map<String, Map<String, ReferenceMatcher>> staticFieldNameByClassName;

    public ClassReferenceReader(HeapGraph graph, List<? extends ReferenceMatcher> list) {
        LinkedHashMap newMap;
        Intrinsics.checkParameterIsNotNull(graph, "graph");
        Intrinsics.checkParameterIsNotNull(list, "referenceMatchers");
        Map staticFieldNameByClassName = new LinkedHashMap();
        Iterable $this$forEach$iv = ReferenceMatcherKt.filterFor(list, graph);
        for (Object element$iv : $this$forEach$iv) {
            ReferenceMatcher referenceMatcher = (ReferenceMatcher) element$iv;
            ReferencePattern pattern = referenceMatcher.getPattern();
            if (pattern instanceof ReferencePattern.StaticFieldPattern) {
                Map mapOrNull = (Map) staticFieldNameByClassName.get(((ReferencePattern.StaticFieldPattern) pattern).getClassName());
                if (mapOrNull != null) {
                    newMap = mapOrNull;
                } else {
                    newMap = new LinkedHashMap();
                    staticFieldNameByClassName.put(((ReferencePattern.StaticFieldPattern) pattern).getClassName(), newMap);
                }
                newMap.put(((ReferencePattern.StaticFieldPattern) pattern).getFieldName(), referenceMatcher);
            }
        }
        this.staticFieldNameByClassName = staticFieldNameByClassName;
    }

    @Override // shark.internal.ReferenceReader
    public Sequence<Reference> read(final HeapObject.HeapClass source) {
        Intrinsics.checkParameterIsNotNull(source, "source");
        final Map ignoredStaticFields = this.staticFieldNameByClassName.get(source.getName());
        if (ignoredStaticFields == null) {
            ignoredStaticFields = MapsKt.emptyMap();
        }
        return SequencesKt.mapNotNull(source.readStaticFields(), new Function1<HeapField, Reference>() { // from class: shark.internal.ClassReferenceReader$read$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Reference invoke(HeapField staticField) {
                Intrinsics.checkParameterIsNotNull(staticField, "staticField");
                Reference reference = null;
                if (staticField.getValue().isNonNullReference()) {
                    final String fieldName = staticField.getName();
                    if (Intrinsics.areEqual(fieldName, "$staticOverhead") || Intrinsics.areEqual(fieldName, "$classOverhead")) {
                        return null;
                    }
                    ValueHolder holder = staticField.getValue().getHolder();
                    if (holder == null) {
                        throw new TypeCastException("null cannot be cast to non-null type shark.ValueHolder.ReferenceHolder");
                    }
                    long valueObjectId = ((ValueHolder.ReferenceHolder) holder).getValue();
                    final ReferenceMatcher referenceMatcher = (ReferenceMatcher) ignoredStaticFields.get(fieldName);
                    if (!(referenceMatcher instanceof IgnoredReferenceMatcher)) {
                        final long sourceObjectId = source.getObjectId();
                        reference = new Reference(valueObjectId, referenceMatcher != null, new Reference.LazyDetails.Resolver() { // from class: shark.internal.ClassReferenceReader$read$1.1
                            @Override // shark.internal.Reference.LazyDetails.Resolver
                            public final Reference.LazyDetails resolve() {
                                return new Reference.LazyDetails(fieldName, sourceObjectId, ReferenceLocationType.STATIC_FIELD, (LibraryLeakReferenceMatcher) referenceMatcher, false);
                            }
                        });
                    }
                    return reference;
                }
                return null;
            }
        });
    }
}