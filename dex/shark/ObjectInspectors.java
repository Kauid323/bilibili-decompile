package shark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import shark.FilteringLeakingObjectFinder;
import shark.HeapObject;
import shark.internal.KeyedWeakReferenceMirror;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: ObjectInspectors.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0003R1\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lshark/ObjectInspectors;", "", "Lshark/ObjectInspector;", "(Ljava/lang/String;I)V", "leakingObjectFilter", "Lkotlin/Function1;", "Lshark/HeapObject;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "heapObject", "", "getLeakingObjectFilter$shark", "()Lkotlin/jvm/functions/Function1;", "KEYED_WEAK_REFERENCE", "CLASSLOADER", "CLASS", "ANONYMOUS_CLASS", "THREAD", "Companion", "shark"}, k = 1, mv = {1, 4, 1})
public enum ObjectInspectors implements ObjectInspector {
    KEYED_WEAK_REFERENCE { // from class: shark.ObjectInspectors.KEYED_WEAK_REFERENCE
        private final Function1<HeapObject, Boolean> leakingObjectFilter = new Function1<HeapObject, Boolean>() { // from class: shark.ObjectInspectors$KEYED_WEAK_REFERENCE$leakingObjectFilter$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Boolean.valueOf(invoke((HeapObject) obj));
            }

            public final boolean invoke(HeapObject heapObject) {
                KeyedWeakReferenceMirror reference;
                Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
                Iterable $this$filter$iv = KeyedWeakReferenceFinder.INSTANCE.findKeyedWeakReferences$shark(heapObject.getGraph());
                Collection destination$iv$iv = new ArrayList();
                Iterator<T> it = $this$filter$iv.iterator();
                while (true) {
                    boolean z = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object element$iv$iv = it.next();
                    KeyedWeakReferenceMirror it2 = (KeyedWeakReferenceMirror) element$iv$iv;
                    if ((it2.getHasReferent() && it2.isRetained()) ? false : false) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                Iterable $this$filter$iv2 = (List) destination$iv$iv;
                Iterable $this$any$iv = $this$filter$iv2;
                if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
                    return false;
                }
                for (Object element$iv : $this$any$iv) {
                    KeyedWeakReferenceMirror reference2 = (KeyedWeakReferenceMirror) element$iv;
                    if (reference2.getReferent().getValue() == heapObject.getObjectId()) {
                        reference = 1;
                        continue;
                    } else {
                        reference = null;
                        continue;
                    }
                    if (reference != null) {
                        return true;
                    }
                }
                return false;
            }
        };

        @Override // shark.ObjectInspectors
        public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark() {
            return this.leakingObjectFilter;
        }

        @Override // shark.ObjectInspector
        public void inspect(ObjectReporter reporter) {
            String str;
            Intrinsics.checkParameterIsNotNull(reporter, "reporter");
            HeapGraph graph = reporter.getHeapObject().getGraph();
            Iterable references = KeyedWeakReferenceFinder.INSTANCE.findKeyedWeakReferences$shark(graph);
            long objectId = reporter.getHeapObject().getObjectId();
            Iterable $this$forEach$iv = references;
            for (Object element$iv : $this$forEach$iv) {
                KeyedWeakReferenceMirror ref = (KeyedWeakReferenceMirror) element$iv;
                if (ref.getReferent().getValue() == objectId) {
                    Set<String> leakingReasons = reporter.getLeakingReasons();
                    if (ref.getDescription().length() > 0) {
                        str = "ObjectWatcher was watching this because " + ref.getDescription();
                    } else {
                        str = "ObjectWatcher was watching this";
                    }
                    leakingReasons.add(str);
                    reporter.getLabels().add("key = " + ref.getKey());
                    if (ref.getWatchDurationMillis() != null) {
                        reporter.getLabels().add("watchDurationMillis = " + ref.getWatchDurationMillis());
                    }
                    if (ref.getRetainedDurationMillis() != null) {
                        reporter.getLabels().add("retainedDurationMillis = " + ref.getRetainedDurationMillis());
                    }
                }
            }
        }
    },
    CLASSLOADER { // from class: shark.ObjectInspectors.CLASSLOADER
        @Override // shark.ObjectInspector
        public void inspect(ObjectReporter reporter) {
            Intrinsics.checkParameterIsNotNull(reporter, "reporter");
            reporter.whenInstanceOf(Reflection.getOrCreateKotlinClass(ClassLoader.class), new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.ObjectInspectors$CLASSLOADER$inspect$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance it) {
                    Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    $this$whenInstanceOf.getNotLeakingReasons().add("A ClassLoader is never leaking");
                }
            });
        }
    },
    CLASS { // from class: shark.ObjectInspectors.CLASS
        @Override // shark.ObjectInspector
        public void inspect(ObjectReporter reporter) {
            Intrinsics.checkParameterIsNotNull(reporter, "reporter");
            if (reporter.getHeapObject() instanceof HeapObject.HeapClass) {
                reporter.getNotLeakingReasons().add("a class is never leaking");
            }
        }
    },
    ANONYMOUS_CLASS { // from class: shark.ObjectInspectors.ANONYMOUS_CLASS
        @Override // shark.ObjectInspector
        public void inspect(ObjectReporter reporter) {
            String str;
            Intrinsics.checkParameterIsNotNull(reporter, "reporter");
            HeapObject heapObject = reporter.getHeapObject();
            if (heapObject instanceof HeapObject.HeapInstance) {
                HeapObject.HeapClass instanceClass = ((HeapObject.HeapInstance) heapObject).getInstanceClass();
                if (ObjectInspectors.ANONYMOUS_CLASS_NAME_PATTERN_REGEX.matches(instanceClass.getName())) {
                    HeapObject.HeapClass parentClassRecord = instanceClass.getSuperclass();
                    if (parentClassRecord == null) {
                        Intrinsics.throwNpe();
                    }
                    if (Intrinsics.areEqual(parentClassRecord.getName(), "java.lang.Object")) {
                        try {
                            Class actualClass = Class.forName(instanceClass.getName());
                            Intrinsics.checkExpressionValueIsNotNull(actualClass, "actualClass");
                            Class[] interfaces = actualClass.getInterfaces();
                            LinkedHashSet<String> labels = reporter.getLabels();
                            Intrinsics.checkExpressionValueIsNotNull(interfaces, "interfaces");
                            if (!(interfaces.length == 0)) {
                                Class implementedInterface = interfaces[0];
                                StringBuilder append = new StringBuilder().append("Anonymous class implementing ");
                                Intrinsics.checkExpressionValueIsNotNull(implementedInterface, "implementedInterface");
                                str = append.append(implementedInterface.getName()).toString();
                            } else {
                                str = "Anonymous subclass of java.lang.Object";
                            }
                            labels.add(str);
                            return;
                        } catch (ClassNotFoundException e) {
                            return;
                        }
                    }
                    reporter.getLabels().add("Anonymous subclass of " + parentClassRecord.getName());
                }
            }
        }
    },
    THREAD { // from class: shark.ObjectInspectors.THREAD
        @Override // shark.ObjectInspector
        public void inspect(ObjectReporter reporter) {
            Intrinsics.checkParameterIsNotNull(reporter, "reporter");
            reporter.whenInstanceOf(Reflection.getOrCreateKotlinClass(Thread.class), new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.ObjectInspectors$THREAD$inspect$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                    Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                    Intrinsics.checkParameterIsNotNull(instance, "instance");
                    HeapField heapField = instance.get(Reflection.getOrCreateKotlinClass(Thread.class), ChannelRoutes.CHANNEL_NAME);
                    if (heapField == null) {
                        Intrinsics.throwNpe();
                    }
                    String threadName = heapField.getValue().readAsJavaString();
                    $this$whenInstanceOf.getLabels().add("Thread name: '" + threadName + '\'');
                }
            });
        }
    };
    
    private static final List<FilteringLeakingObjectFinder.LeakingObjectFilter> jdkLeakingObjectFilters;
    private final Function1<HeapObject, Boolean> leakingObjectFilter;
    public static final Companion Companion = new Companion(null);
    private static final String ANONYMOUS_CLASS_NAME_PATTERN = "^.+\\$\\d+$";
    private static final Regex ANONYMOUS_CLASS_NAME_PATTERN_REGEX = new Regex(ANONYMOUS_CLASS_NAME_PATTERN);

    /* synthetic */ ObjectInspectors(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark() {
        return this.leakingObjectFilter;
    }

    /* compiled from: ObjectInspectors.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0013"}, d2 = {"Lshark/ObjectInspectors$Companion;", "", "()V", "ANONYMOUS_CLASS_NAME_PATTERN", "", "ANONYMOUS_CLASS_NAME_PATTERN_REGEX", "Lkotlin/text/Regex;", "jdkDefaults", "", "Lshark/ObjectInspector;", "getJdkDefaults", "()Ljava/util/List;", "jdkLeakingObjectFilters", "Lshark/FilteringLeakingObjectFinder$LeakingObjectFilter;", "getJdkLeakingObjectFilters", "createLeakingObjectFilters", "inspectors", "", "Lshark/ObjectInspectors;", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final List<ObjectInspector> getJdkDefaults() {
            return ArraysKt.toList(ObjectInspectors.values());
        }

        public final List<FilteringLeakingObjectFinder.LeakingObjectFilter> getJdkLeakingObjectFilters() {
            return ObjectInspectors.jdkLeakingObjectFilters;
        }

        public final List<FilteringLeakingObjectFinder.LeakingObjectFilter> createLeakingObjectFilters(Set<? extends ObjectInspectors> set) {
            Intrinsics.checkParameterIsNotNull(set, "inspectors");
            Set<? extends ObjectInspectors> $this$mapNotNull$iv = set;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                ObjectInspectors it = (ObjectInspectors) element$iv$iv$iv;
                Function1<HeapObject, Boolean> leakingObjectFilter$shark = it.getLeakingObjectFilter$shark();
                if (leakingObjectFilter$shark != null) {
                    destination$iv$iv.add(leakingObjectFilter$shark);
                }
            }
            Iterable $this$mapNotNull$iv2 = (List) destination$iv$iv;
            Iterable $this$map$iv = $this$mapNotNull$iv2;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                final Function1 filter = (Function1) item$iv$iv;
                destination$iv$iv2.add(new FilteringLeakingObjectFinder.LeakingObjectFilter() { // from class: shark.ObjectInspectors$Companion$createLeakingObjectFilters$2$1
                    @Override // shark.FilteringLeakingObjectFinder.LeakingObjectFilter
                    public final boolean isLeakingObject(HeapObject heapObject) {
                        Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
                        return ((Boolean) filter.invoke(heapObject)).booleanValue();
                    }
                });
            }
            return (List) destination$iv$iv2;
        }
    }

    static {
        Companion companion = Companion;
        EnumSet allOf = EnumSet.allOf(ObjectInspectors.class);
        Intrinsics.checkExpressionValueIsNotNull(allOf, "EnumSet.allOf(ObjectInspectors::class.java)");
        jdkLeakingObjectFilters = companion.createLeakingObjectFilters(allOf);
    }
}