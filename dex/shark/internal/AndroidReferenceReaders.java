package shark.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.HeapField;
import shark.HeapGraph;
import shark.HeapObject;
import shark.HeapValue;
import shark.HprofRecord;
import shark.internal.ChainingInstanceReferenceReader;
import shark.internal.Reference;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AndroidReferenceReaders.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\b\b\u0080\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lshark/internal/AndroidReferenceReaders;", "", "Lshark/internal/ChainingInstanceReferenceReader$VirtualInstanceReferenceReader$OptionalFactory;", "(Ljava/lang/String;I)V", "ACTIVITY_THREAD__NEW_ACTIVITIES", "MESSAGE_QUEUE", "ANIMATOR_WEAK_REF_SUCKS", "SAFE_ITERABLE_MAP", "ARRAY_SET", "Companion", "shark"}, k = 1, mv = {1, 4, 1})
public abstract class AndroidReferenceReaders implements ChainingInstanceReferenceReader.VirtualInstanceReferenceReader.OptionalFactory {
    private static final /* synthetic */ AndroidReferenceReaders[] $VALUES;
    public static final AndroidReferenceReaders ACTIVITY_THREAD__NEW_ACTIVITIES;
    public static final AndroidReferenceReaders ANIMATOR_WEAK_REF_SUCKS;
    public static final AndroidReferenceReaders ARRAY_SET;
    private static final String ARRAY_SET_CLASS_NAME = "android.util.ArraySet";
    public static final Companion Companion;
    private static final String FAST_SAFE_ITERABLE_MAP_CLASS_NAME = "androidx.arch.core.internal.FastSafeIterableMap";
    public static final AndroidReferenceReaders MESSAGE_QUEUE;
    public static final AndroidReferenceReaders SAFE_ITERABLE_MAP;
    private static final String SAFE_ITERABLE_MAP_CLASS_NAME = "androidx.arch.core.internal.SafeIterableMap";
    private static final String SAFE_ITERABLE_MAP_ENTRY_CLASS_NAME = "androidx.arch.core.internal.SafeIterableMap$Entry";

    static {
        ACTIVITY_THREAD__NEW_ACTIVITIES activity_thread__new_activities = new ACTIVITY_THREAD__NEW_ACTIVITIES("ACTIVITY_THREAD__NEW_ACTIVITIES", 0);
        ACTIVITY_THREAD__NEW_ACTIVITIES = activity_thread__new_activities;
        AndroidReferenceReaders androidReferenceReaders = new AndroidReferenceReaders("MESSAGE_QUEUE", 1) { // from class: shark.internal.AndroidReferenceReaders.MESSAGE_QUEUE
            @Override // shark.internal.ChainingInstanceReferenceReader.VirtualInstanceReferenceReader.OptionalFactory
            public ChainingInstanceReferenceReader.VirtualInstanceReferenceReader create(HeapGraph graph) {
                Intrinsics.checkParameterIsNotNull(graph, "graph");
                HeapObject.HeapClass messageQueueClass = graph.findClassByName("android.os.MessageQueue");
                if (messageQueueClass == null) {
                    return null;
                }
                long messageQueueClassId = messageQueueClass.getObjectId();
                return new AndroidReferenceReaders$MESSAGE_QUEUE$create$1(messageQueueClassId);
            }
        };
        MESSAGE_QUEUE = androidReferenceReaders;
        AndroidReferenceReaders androidReferenceReaders2 = new AndroidReferenceReaders("ANIMATOR_WEAK_REF_SUCKS", 2) { // from class: shark.internal.AndroidReferenceReaders.ANIMATOR_WEAK_REF_SUCKS
            @Override // shark.internal.ChainingInstanceReferenceReader.VirtualInstanceReferenceReader.OptionalFactory
            public ChainingInstanceReferenceReader.VirtualInstanceReferenceReader create(HeapGraph graph) {
                HeapObject.HeapClass findClassByName;
                Intrinsics.checkParameterIsNotNull(graph, "graph");
                HeapObject.HeapClass objectAnimatorClass = graph.findClassByName("android.animation.ObjectAnimator");
                if (objectAnimatorClass == null || (findClassByName = graph.findClassByName("java.lang.ref.WeakReference")) == null) {
                    return null;
                }
                long weakRefClassId = findClassByName.getObjectId();
                long objectAnimatorClassId = objectAnimatorClass.getObjectId();
                return new AndroidReferenceReaders$ANIMATOR_WEAK_REF_SUCKS$create$1(objectAnimatorClassId, weakRefClassId);
            }
        };
        ANIMATOR_WEAK_REF_SUCKS = androidReferenceReaders2;
        AndroidReferenceReaders androidReferenceReaders3 = new AndroidReferenceReaders("SAFE_ITERABLE_MAP", 3) { // from class: shark.internal.AndroidReferenceReaders.SAFE_ITERABLE_MAP
            @Override // shark.internal.ChainingInstanceReferenceReader.VirtualInstanceReferenceReader.OptionalFactory
            public ChainingInstanceReferenceReader.VirtualInstanceReferenceReader create(HeapGraph graph) {
                Intrinsics.checkParameterIsNotNull(graph, "graph");
                HeapObject.HeapClass mapClass = graph.findClassByName(AndroidReferenceReaders.SAFE_ITERABLE_MAP_CLASS_NAME);
                if (mapClass != null) {
                    HeapObject.HeapClass fastMapClass = graph.findClassByName(AndroidReferenceReaders.FAST_SAFE_ITERABLE_MAP_CLASS_NAME);
                    final long mapClassId = mapClass.getObjectId();
                    final Long fastMapClassId = fastMapClass != null ? Long.valueOf(fastMapClass.getObjectId()) : null;
                    return new ChainingInstanceReferenceReader.VirtualInstanceReferenceReader() { // from class: shark.internal.AndroidReferenceReaders$SAFE_ITERABLE_MAP$create$1
                        @Override // shark.internal.ChainingInstanceReferenceReader.VirtualInstanceReferenceReader
                        public boolean matches(HeapObject.HeapInstance instance) {
                            Long l;
                            Intrinsics.checkParameterIsNotNull(instance, "instance");
                            long classId = instance.getInstanceClassId();
                            return classId == mapClassId || ((l = fastMapClassId) != null && classId == l.longValue());
                        }

                        @Override // shark.internal.ReferenceReader
                        public Sequence<Reference> read(HeapObject.HeapInstance source) {
                            Intrinsics.checkParameterIsNotNull(source, "source");
                            HeapField heapField = source.get("androidx.arch.core.internal.SafeIterableMap", "mStart");
                            if (heapField == null) {
                                Intrinsics.throwNpe();
                            }
                            HeapObject.HeapInstance start = heapField.getValueAsInstance();
                            Sequence entries = SequencesKt.generateSequence(start, new Function1<HeapObject.HeapInstance, HeapObject.HeapInstance>() { // from class: shark.internal.AndroidReferenceReaders$SAFE_ITERABLE_MAP$create$1$read$entries$1
                                public final HeapObject.HeapInstance invoke(HeapObject.HeapInstance node) {
                                    Intrinsics.checkParameterIsNotNull(node, "node");
                                    HeapField heapField2 = node.get("androidx.arch.core.internal.SafeIterableMap$Entry", "mNext");
                                    if (heapField2 == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    return heapField2.getValueAsInstance();
                                }
                            });
                            long locationClassObjectId = source.getInstanceClassId();
                            return SequencesKt.flatMap(entries, new AndroidReferenceReaders$SAFE_ITERABLE_MAP$create$1$read$1(locationClassObjectId));
                        }
                    };
                }
                return null;
            }
        };
        SAFE_ITERABLE_MAP = androidReferenceReaders3;
        AndroidReferenceReaders androidReferenceReaders4 = new AndroidReferenceReaders("ARRAY_SET", 4) { // from class: shark.internal.AndroidReferenceReaders.ARRAY_SET
            @Override // shark.internal.ChainingInstanceReferenceReader.VirtualInstanceReferenceReader.OptionalFactory
            public ChainingInstanceReferenceReader.VirtualInstanceReferenceReader create(HeapGraph graph) {
                Intrinsics.checkParameterIsNotNull(graph, "graph");
                HeapObject.HeapClass findClassByName = graph.findClassByName(AndroidReferenceReaders.ARRAY_SET_CLASS_NAME);
                if (findClassByName == null) {
                    return null;
                }
                final long arraySetClassId = findClassByName.getObjectId();
                return new ChainingInstanceReferenceReader.VirtualInstanceReferenceReader() { // from class: shark.internal.AndroidReferenceReaders$ARRAY_SET$create$1
                    @Override // shark.internal.ChainingInstanceReferenceReader.VirtualInstanceReferenceReader
                    public boolean matches(HeapObject.HeapInstance instance) {
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        return instance.getInstanceClassId() == arraySetClassId;
                    }

                    @Override // shark.internal.ReferenceReader
                    public Sequence<Reference> read(HeapObject.HeapInstance source) {
                        Intrinsics.checkParameterIsNotNull(source, "source");
                        HeapField heapField = source.get("android.util.ArraySet", "mArray");
                        if (heapField == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject.HeapObjectArray mArray = heapField.getValueAsObjectArray();
                        if (mArray == null) {
                            Intrinsics.throwNpe();
                        }
                        final long locationClassObjectId = source.getInstanceClassId();
                        return SequencesKt.map(SequencesKt.filter(mArray.readElements(), new Function1<HeapValue, Boolean>() { // from class: shark.internal.AndroidReferenceReaders$ARRAY_SET$create$1$read$1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return Boolean.valueOf(invoke((HeapValue) obj));
                            }

                            public final boolean invoke(HeapValue it) {
                                Intrinsics.checkParameterIsNotNull(it, "it");
                                return it.isNonNullReference();
                            }
                        }), new Function1<HeapValue, Reference>() { // from class: shark.internal.AndroidReferenceReaders$ARRAY_SET$create$1$read$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final Reference invoke(HeapValue reference) {
                                Intrinsics.checkParameterIsNotNull(reference, "reference");
                                Long asNonNullObjectId = reference.getAsNonNullObjectId();
                                if (asNonNullObjectId == null) {
                                    Intrinsics.throwNpe();
                                }
                                return new Reference(asNonNullObjectId.longValue(), false, new Reference.LazyDetails.Resolver() { // from class: shark.internal.AndroidReferenceReaders$ARRAY_SET$create$1$read$2.1
                                    @Override // shark.internal.Reference.LazyDetails.Resolver
                                    public final Reference.LazyDetails resolve() {
                                        return new Reference.LazyDetails("element()", locationClassObjectId, ReferenceLocationType.ARRAY_ENTRY, null, true);
                                    }
                                });
                            }
                        });
                    }
                };
            }
        };
        ARRAY_SET = androidReferenceReaders4;
        $VALUES = new AndroidReferenceReaders[]{activity_thread__new_activities, androidReferenceReaders, androidReferenceReaders2, androidReferenceReaders3, androidReferenceReaders4};
        Companion = new Companion(null);
    }

    public static AndroidReferenceReaders valueOf(String str) {
        return (AndroidReferenceReaders) Enum.valueOf(AndroidReferenceReaders.class, str);
    }

    public static AndroidReferenceReaders[] values() {
        return (AndroidReferenceReaders[]) $VALUES.clone();
    }

    private AndroidReferenceReaders(String $enum$name, int $enum$ordinal) {
    }

    public /* synthetic */ AndroidReferenceReaders(String $enum$name, int $enum$ordinal, DefaultConstructorMarker $constructor_marker) {
        this($enum$name, $enum$ordinal);
    }

    /* compiled from: AndroidReferenceReaders.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lshark/internal/AndroidReferenceReaders$ACTIVITY_THREAD__NEW_ACTIVITIES;", "Lshark/internal/AndroidReferenceReaders;", "create", "Lshark/internal/ChainingInstanceReferenceReader$VirtualInstanceReferenceReader;", "graph", "Lshark/HeapGraph;", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    static final class ACTIVITY_THREAD__NEW_ACTIVITIES extends AndroidReferenceReaders {
        ACTIVITY_THREAD__NEW_ACTIVITIES(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal, null);
        }

        @Override // shark.internal.ChainingInstanceReferenceReader.VirtualInstanceReferenceReader.OptionalFactory
        public ChainingInstanceReferenceReader.VirtualInstanceReferenceReader create(HeapGraph graph) {
            HeapObject.HeapClass activityClientRecordClass;
            Intrinsics.checkParameterIsNotNull(graph, "graph");
            HeapObject.HeapClass activityThreadClass = graph.findClassByName("android.app.ActivityThread");
            if (activityThreadClass != null) {
                Iterable $this$none$iv = activityThreadClass.readRecordFields();
                boolean z = true;
                if (!($this$none$iv instanceof Collection) || !((Collection) $this$none$iv).isEmpty()) {
                    Iterator<T> it = $this$none$iv.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object element$iv = it.next();
                        HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord it2 = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord) element$iv;
                        if (Intrinsics.areEqual(activityThreadClass.instanceFieldName(it2), "mNewActivities")) {
                            z = false;
                            break;
                        }
                    }
                }
                if (z || (activityClientRecordClass = graph.findClassByName("android.app.ActivityThread$ActivityClientRecord")) == null) {
                    return null;
                }
                Iterable $this$map$iv = activityClientRecordClass.readRecordFields();
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord it3 = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord) item$iv$iv;
                    destination$iv$iv.add(activityThreadClass.instanceFieldName(it3));
                }
                List activityClientRecordFieldNames = CollectionsKt.toList((List) destination$iv$iv);
                if (activityClientRecordFieldNames.contains("nextIdle") && activityClientRecordFieldNames.contains(AudioIntentHelper.FROM_ACTIVITY)) {
                    long activityThreadClassId = activityThreadClass.getObjectId();
                    long activityClientRecordClassId = activityClientRecordClass.getObjectId();
                    return new AndroidReferenceReaders$ACTIVITY_THREAD__NEW_ACTIVITIES$create$2(this, activityThreadClassId, activityClientRecordClassId);
                }
                return null;
            }
            return null;
        }
    }

    /* compiled from: AndroidReferenceReaders.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lshark/internal/AndroidReferenceReaders$Companion;", "", "()V", "ARRAY_SET_CLASS_NAME", "", "FAST_SAFE_ITERABLE_MAP_CLASS_NAME", "SAFE_ITERABLE_MAP_CLASS_NAME", "SAFE_ITERABLE_MAP_ENTRY_CLASS_NAME", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}