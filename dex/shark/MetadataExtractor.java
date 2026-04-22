package shark;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MetadataExtractor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lshark/MetadataExtractor;", "", "extractMetadata", "", "", "graph", "Lshark/HeapGraph;", "Companion", "shark"}, k = 1, mv = {1, 4, 1})
public interface MetadataExtractor {
    public static final Companion Companion = Companion.$$INSTANCE;

    Map<String, String> extractMetadata(HeapGraph heapGraph);

    /* compiled from: MetadataExtractor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0007\u001a\u00020\u00042 \b\u0004\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b0\tH\u0086\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lshark/MetadataExtractor$Companion;", "", "()V", "NO_OP", "Lshark/MetadataExtractor;", "getNO_OP", "()Lshark/MetadataExtractor;", "invoke", "block", "Lkotlin/Function1;", "Lshark/HeapGraph;", "", "", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final MetadataExtractor NO_OP = new MetadataExtractor() { // from class: shark.MetadataExtractor$Companion$NO_OP$1
            @Override // shark.MetadataExtractor
            public final Map<String, String> extractMetadata(HeapGraph it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return MapsKt.emptyMap();
            }
        };

        private Companion() {
        }

        public final MetadataExtractor getNO_OP() {
            return NO_OP;
        }

        public final MetadataExtractor invoke(final Function1<? super HeapGraph, ? extends Map<String, String>> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "block");
            return new MetadataExtractor() { // from class: shark.MetadataExtractor$Companion$invoke$1
                @Override // shark.MetadataExtractor
                public final Map<String, String> extractMetadata(HeapGraph graph) {
                    Intrinsics.checkParameterIsNotNull(graph, "graph");
                    return (Map) function1.invoke(graph);
                }
            };
        }
    }
}