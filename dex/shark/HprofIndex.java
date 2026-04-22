package shark;

import java.util.EnumSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import shark.internal.HprofInMemoryIndex;

/* compiled from: HprofIndex.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lshark/HprofIndex;", "", "sourceProvider", "Lshark/RandomAccessSourceProvider;", "header", "Lshark/HprofHeader;", "index", "Lshark/internal/HprofInMemoryIndex;", "(Lshark/RandomAccessSourceProvider;Lshark/HprofHeader;Lshark/internal/HprofInMemoryIndex;)V", "openHeapGraph", "Lshark/CloseableHeapGraph;", "Companion", "shark-graph"}, k = 1, mv = {1, 4, 1})
public final class HprofIndex {
    public static final Companion Companion = new Companion(null);
    private final HprofHeader header;
    private final HprofInMemoryIndex index;
    private final RandomAccessSourceProvider sourceProvider;

    private HprofIndex(RandomAccessSourceProvider sourceProvider, HprofHeader header, HprofInMemoryIndex index) {
        this.sourceProvider = sourceProvider;
        this.header = header;
        this.index = index;
    }

    public /* synthetic */ HprofIndex(RandomAccessSourceProvider sourceProvider, HprofHeader header, HprofInMemoryIndex index, DefaultConstructorMarker $constructor_marker) {
        this(sourceProvider, header, index);
    }

    public final CloseableHeapGraph openHeapGraph() {
        RandomAccessHprofReader reader = RandomAccessHprofReader.Companion.openReaderFor(this.sourceProvider, this.header);
        return new HprofHeapGraph(this.header, reader, this.index);
    }

    /* compiled from: HprofIndex.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J2\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f¨\u0006\u0010"}, d2 = {"Lshark/HprofIndex$Companion;", "", "()V", "defaultIndexedGcRootTags", "Ljava/util/EnumSet;", "Lshark/HprofRecordTag;", "indexRecordsOf", "Lshark/HprofIndex;", "hprofSourceProvider", "Lshark/DualSourceProvider;", "hprofHeader", "Lshark/HprofHeader;", "proguardMapping", "Lshark/ProguardMapping;", "indexedGcRootTags", "", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HprofIndex indexRecordsOf$default(Companion companion, DualSourceProvider dualSourceProvider, HprofHeader hprofHeader, ProguardMapping proguardMapping, Set set, int i, Object obj) {
            if ((i & 4) != 0) {
                proguardMapping = null;
            }
            if ((i & 8) != 0) {
                set = companion.defaultIndexedGcRootTags();
            }
            return companion.indexRecordsOf(dualSourceProvider, hprofHeader, proguardMapping, set);
        }

        public final HprofIndex indexRecordsOf(DualSourceProvider hprofSourceProvider, HprofHeader hprofHeader, ProguardMapping proguardMapping, Set<? extends HprofRecordTag> set) {
            Intrinsics.checkParameterIsNotNull(hprofSourceProvider, "hprofSourceProvider");
            Intrinsics.checkParameterIsNotNull(hprofHeader, "hprofHeader");
            Intrinsics.checkParameterIsNotNull(set, "indexedGcRootTags");
            StreamingHprofReader reader = StreamingHprofReader.Companion.readerFor(hprofSourceProvider, hprofHeader);
            HprofInMemoryIndex index = HprofInMemoryIndex.Companion.indexHprof(reader, hprofHeader, proguardMapping, set);
            return new HprofIndex(hprofSourceProvider, hprofHeader, index, null);
        }

        public final EnumSet<HprofRecordTag> defaultIndexedGcRootTags() {
            EnumSet<HprofRecordTag> of = EnumSet.of(HprofRecordTag.ROOT_JNI_GLOBAL, HprofRecordTag.ROOT_JAVA_FRAME, HprofRecordTag.ROOT_JNI_LOCAL, HprofRecordTag.ROOT_MONITOR_USED, HprofRecordTag.ROOT_NATIVE_STACK, HprofRecordTag.ROOT_STICKY_CLASS, HprofRecordTag.ROOT_THREAD_BLOCK, HprofRecordTag.ROOT_THREAD_OBJECT, HprofRecordTag.ROOT_JNI_MONITOR);
            Intrinsics.checkExpressionValueIsNotNull(of, "EnumSet.of(\n      HprofR…reachable\n       */\n    )");
            return of;
        }
    }
}