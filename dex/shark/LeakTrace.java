package shark;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.GcRoot;
import shark.LeakTraceObject;
import shark.LeakTraceReference;
import shark.internal.StringsKt;
import tv.danmaku.bili.ui.filechooser.FileUtils;

/* compiled from: LeakTrace.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0002-.B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J-\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0011HÖ\u0001J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020#H\u0002J\u000e\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0011J\u0006\u0010+\u001a\u00020\u0017J\b\u0010,\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006/"}, d2 = {"Lshark/LeakTrace;", "Ljava/io/Serializable;", "gcRootType", "Lshark/LeakTrace$GcRootType;", "referencePath", "", "Lshark/LeakTraceReference;", "leakingObject", "Lshark/LeakTraceObject;", "(Lshark/LeakTrace$GcRootType;Ljava/util/List;Lshark/LeakTraceObject;)V", "getGcRootType", "()Lshark/LeakTrace$GcRootType;", "getLeakingObject", "()Lshark/LeakTraceObject;", "getReferencePath", "()Ljava/util/List;", "retainedHeapByteSize", "", "getRetainedHeapByteSize", "()Ljava/lang/Integer;", "retainedObjectCount", "getRetainedObjectCount", "signature", "", "getSignature", "()Ljava/lang/String;", "suspectReferenceSubpath", "Lkotlin/sequences/Sequence;", "getSuspectReferenceSubpath", "()Lkotlin/sequences/Sequence;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "leakTraceAsString", "showLeakingStatus", "referencePathElementIsSuspect", "index", "toSimplePathString", "toString", "Companion", "GcRootType", "shark"}, k = 1, mv = {1, 4, 1})
public final class LeakTrace implements Serializable {
    public static final Companion Companion = new Companion(null);
    public static final char ZERO_WIDTH_SPACE = 8203;
    private static final long serialVersionUID = -6315725584154386429L;
    private final GcRootType gcRootType;
    private final LeakTraceObject leakingObject;
    private final List<LeakTraceReference> referencePath;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LeakTrace copy$default(LeakTrace leakTrace, GcRootType gcRootType, List list, LeakTraceObject leakTraceObject, int i, Object obj) {
        if ((i & 1) != 0) {
            gcRootType = leakTrace.gcRootType;
        }
        if ((i & 2) != 0) {
            list = leakTrace.referencePath;
        }
        if ((i & 4) != 0) {
            leakTraceObject = leakTrace.leakingObject;
        }
        return leakTrace.copy(gcRootType, list, leakTraceObject);
    }

    public final GcRootType component1() {
        return this.gcRootType;
    }

    public final List<LeakTraceReference> component2() {
        return this.referencePath;
    }

    public final LeakTraceObject component3() {
        return this.leakingObject;
    }

    public final LeakTrace copy(GcRootType gcRootType, List<LeakTraceReference> list, LeakTraceObject leakTraceObject) {
        Intrinsics.checkParameterIsNotNull(gcRootType, "gcRootType");
        Intrinsics.checkParameterIsNotNull(list, "referencePath");
        Intrinsics.checkParameterIsNotNull(leakTraceObject, "leakingObject");
        return new LeakTrace(gcRootType, list, leakTraceObject);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LeakTrace) {
                LeakTrace leakTrace = (LeakTrace) obj;
                return Intrinsics.areEqual(this.gcRootType, leakTrace.gcRootType) && Intrinsics.areEqual(this.referencePath, leakTrace.referencePath) && Intrinsics.areEqual(this.leakingObject, leakTrace.leakingObject);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        GcRootType gcRootType = this.gcRootType;
        int hashCode = (gcRootType != null ? gcRootType.hashCode() : 0) * 31;
        List<LeakTraceReference> list = this.referencePath;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        LeakTraceObject leakTraceObject = this.leakingObject;
        return hashCode2 + (leakTraceObject != null ? leakTraceObject.hashCode() : 0);
    }

    public LeakTrace(GcRootType gcRootType, List<LeakTraceReference> list, LeakTraceObject leakingObject) {
        Intrinsics.checkParameterIsNotNull(gcRootType, "gcRootType");
        Intrinsics.checkParameterIsNotNull(list, "referencePath");
        Intrinsics.checkParameterIsNotNull(leakingObject, "leakingObject");
        this.gcRootType = gcRootType;
        this.referencePath = list;
        this.leakingObject = leakingObject;
    }

    public final GcRootType getGcRootType() {
        return this.gcRootType;
    }

    public final List<LeakTraceReference> getReferencePath() {
        return this.referencePath;
    }

    public final LeakTraceObject getLeakingObject() {
        return this.leakingObject;
    }

    public final Integer getRetainedHeapByteSize() {
        List listOf = CollectionsKt.listOf(this.leakingObject);
        Iterable $this$map$iv = this.referencePath;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            LeakTraceReference it = (LeakTraceReference) item$iv$iv;
            destination$iv$iv.add(it.getOriginObject());
        }
        Iterable allObjects = CollectionsKt.plus(listOf, (List) destination$iv$iv);
        Iterable $this$filter$iv = allObjects;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            LeakTraceObject it2 = (LeakTraceObject) element$iv$iv;
            if (it2.getLeakingStatus() == LeakTraceObject.LeakingStatus.LEAKING) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        Iterable $this$filter$iv2 = (List) destination$iv$iv2;
        Iterable $this$mapNotNull$iv = $this$filter$iv2;
        Collection destination$iv$iv3 = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            LeakTraceObject it3 = (LeakTraceObject) element$iv$iv$iv;
            Integer retainedHeapByteSize = it3.getRetainedHeapByteSize();
            if (retainedHeapByteSize != null) {
                destination$iv$iv3.add(retainedHeapByteSize);
            }
        }
        Iterable $this$mapNotNull$iv2 = (List) destination$iv$iv3;
        return (Integer) CollectionsKt.max($this$mapNotNull$iv2);
    }

    public final Integer getRetainedObjectCount() {
        List listOf = CollectionsKt.listOf(this.leakingObject);
        Iterable $this$map$iv = this.referencePath;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            LeakTraceReference it = (LeakTraceReference) item$iv$iv;
            destination$iv$iv.add(it.getOriginObject());
        }
        Iterable allObjects = CollectionsKt.plus(listOf, (List) destination$iv$iv);
        Iterable $this$filter$iv = allObjects;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            LeakTraceObject it2 = (LeakTraceObject) element$iv$iv;
            if (it2.getLeakingStatus() == LeakTraceObject.LeakingStatus.LEAKING) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        Iterable $this$filter$iv2 = (List) destination$iv$iv2;
        Iterable $this$mapNotNull$iv = $this$filter$iv2;
        Collection destination$iv$iv3 = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            LeakTraceObject it3 = (LeakTraceObject) element$iv$iv$iv;
            Integer retainedObjectCount = it3.getRetainedObjectCount();
            if (retainedObjectCount != null) {
                destination$iv$iv3.add(retainedObjectCount);
            }
        }
        Iterable $this$mapNotNull$iv2 = (List) destination$iv$iv3;
        return (Integer) CollectionsKt.max($this$mapNotNull$iv2);
    }

    public final Sequence<LeakTraceReference> getSuspectReferenceSubpath() {
        return SequencesKt.filterIndexed(CollectionsKt.asSequence(this.referencePath), new Function2<Integer, LeakTraceReference, Boolean>() { // from class: shark.LeakTrace$suspectReferenceSubpath$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(invoke(((Number) obj).intValue(), (LeakTraceReference) obj2));
            }

            public final boolean invoke(int index, LeakTraceReference $noName_1) {
                Intrinsics.checkParameterIsNotNull($noName_1, "<anonymous parameter 1>");
                return LeakTrace.this.referencePathElementIsSuspect(index);
            }
        });
    }

    public final String getSignature() {
        return StringsKt.createSHA1Hash(SequencesKt.joinToString$default(getSuspectReferenceSubpath(), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<LeakTraceReference, CharSequence>() { // from class: shark.LeakTrace$signature$1
            public final CharSequence invoke(LeakTraceReference element) {
                Intrinsics.checkParameterIsNotNull(element, "element");
                return element.getOriginObject().getClassName() + element.getReferenceGenericName();
            }
        }, 30, (Object) null));
    }

    public final boolean referencePathElementIsSuspect(int index) {
        switch (this.referencePath.get(index).getOriginObject().getLeakingStatus()) {
            case UNKNOWN:
                return true;
            case NOT_LEAKING:
                return index == CollectionsKt.getLastIndex(this.referencePath) || this.referencePath.get(index + 1).getOriginObject().getLeakingStatus() != LeakTraceObject.LeakingStatus.NOT_LEAKING;
            default:
                return false;
        }
    }

    public String toString() {
        return leakTraceAsString(true);
    }

    public final String toSimplePathString() {
        return leakTraceAsString(false);
    }

    private final String leakTraceAsString(boolean showLeakingStatus) {
        String trimIndent = kotlin.text.StringsKt.trimIndent("\n        ┬───\n        │ GC Root: " + this.gcRootType.getDescription() + "\n        │\n      ");
        Iterable $this$forEachIndexed$iv = this.referencePath;
        int index = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            LeakTraceReference element = (LeakTraceReference) item$iv;
            LeakTraceObject originObject = element.getOriginObject();
            trimIndent = ((trimIndent + "\n") + originObject.toString$shark("├─ ", "│    ", showLeakingStatus, originObject.getTypeName())) + Companion.getNextElementString(this, element, index, showLeakingStatus);
            index = index$iv;
        }
        return (trimIndent + "\n") + LeakTraceObject.toString$shark$default(this.leakingObject, "╰→ ", "\u200b     ", showLeakingStatus, null, 8, null);
    }

    /* compiled from: LeakTrace.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lshark/LeakTrace$GcRootType;", "", "description", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "JNI_GLOBAL", "JNI_LOCAL", "JAVA_FRAME", "NATIVE_STACK", "STICKY_CLASS", "THREAD_BLOCK", "MONITOR_USED", "THREAD_OBJECT", "JNI_MONITOR", "Companion", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public enum GcRootType {
        JNI_GLOBAL("Global variable in native code"),
        JNI_LOCAL("Local variable in native code"),
        JAVA_FRAME("Java local variable"),
        NATIVE_STACK("Input or output parameters in native code"),
        STICKY_CLASS("System class"),
        THREAD_BLOCK("Thread block"),
        MONITOR_USED("Monitor (anything that called the wait() or notify() methods, or that is synchronized.)"),
        THREAD_OBJECT("Thread object"),
        JNI_MONITOR("Root JNI monitor");
        
        public static final Companion Companion = new Companion(null);
        private final String description;

        GcRootType(String description) {
            this.description = description;
        }

        public final String getDescription() {
            return this.description;
        }

        /* compiled from: LeakTrace.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lshark/LeakTrace$GcRootType$Companion;", "", "()V", "fromGcRoot", "Lshark/LeakTrace$GcRootType;", "gcRoot", "Lshark/GcRoot;", "shark"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }

            public final GcRootType fromGcRoot(GcRoot gcRoot) {
                Intrinsics.checkParameterIsNotNull(gcRoot, "gcRoot");
                if (gcRoot instanceof GcRoot.JniGlobal) {
                    return GcRootType.JNI_GLOBAL;
                }
                if (gcRoot instanceof GcRoot.JniLocal) {
                    return GcRootType.JNI_LOCAL;
                }
                if (gcRoot instanceof GcRoot.JavaFrame) {
                    return GcRootType.JAVA_FRAME;
                }
                if (gcRoot instanceof GcRoot.NativeStack) {
                    return GcRootType.NATIVE_STACK;
                }
                if (gcRoot instanceof GcRoot.StickyClass) {
                    return GcRootType.STICKY_CLASS;
                }
                if (gcRoot instanceof GcRoot.ThreadBlock) {
                    return GcRootType.THREAD_BLOCK;
                }
                if (gcRoot instanceof GcRoot.MonitorUsed) {
                    return GcRootType.MONITOR_USED;
                }
                if (gcRoot instanceof GcRoot.ThreadObject) {
                    return GcRootType.THREAD_OBJECT;
                }
                if (gcRoot instanceof GcRoot.JniMonitor) {
                    return GcRootType.JNI_MONITOR;
                }
                throw new IllegalStateException("Unexpected gc root " + gcRoot);
            }
        }
    }

    /* compiled from: LeakTrace.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lshark/LeakTrace$Companion;", "", "()V", "ZERO_WIDTH_SPACE", "", "serialVersionUID", "", "getNextElementString", "", "leakTrace", "Lshark/LeakTrace;", "reference", "Lshark/LeakTraceReference;", "index", "", "showLeakingStatus", "", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getNextElementString(LeakTrace leakTrace, LeakTraceReference reference, int index, boolean showLeakingStatus) {
            String str = "";
            StringBuilder append = new StringBuilder().append("    ↓").append(reference.getReferenceType() == LeakTraceReference.ReferenceType.STATIC_FIELD ? " static" : "").append(' ').append(kotlin.text.StringsKt.removeSuffix(reference.getOwningClassSimpleName(), "[]"));
            switch (reference.getReferenceType()) {
                case STATIC_FIELD:
                case INSTANCE_FIELD:
                    str = FileUtils.HIDDEN_PREFIX;
                    break;
            }
            String referenceLinePrefix = append.append(str).toString();
            String referenceName = reference.getReferenceDisplayName();
            String referenceLine = referenceLinePrefix + referenceName;
            if (!showLeakingStatus || !leakTrace.referencePathElementIsSuspect(index)) {
                return "\n│" + referenceLine;
            }
            String spaces = kotlin.text.StringsKt.repeat(" ", referenceLinePrefix.length());
            String underline = kotlin.text.StringsKt.repeat("~", referenceName.length());
            return "\n│" + referenceLine + "\n│" + spaces + underline;
        }
    }
}