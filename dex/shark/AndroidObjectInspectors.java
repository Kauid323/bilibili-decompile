package shark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.AndroidObjectInspectors;
import shark.FilteringLeakingObjectFinder;
import shark.HeapObject;
import shark.internal.InternalSharkCollectionsHelper;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.router.MainRouteUris;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AndroidObjectInspectors.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b#\b\u0086\u0001\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u00012B\u0007\b\u0002¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR1\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1¨\u00063"}, d2 = {"Lshark/AndroidObjectInspectors;", "", "Lshark/ObjectInspector;", "(Ljava/lang/String;I)V", "ANDROID_SUPPORT_FRAGMENT_CLASS_NAME", "", "getANDROID_SUPPORT_FRAGMENT_CLASS_NAME$shark_android$annotations", "()V", "getANDROID_SUPPORT_FRAGMENT_CLASS_NAME$shark_android", "()Ljava/lang/String;", "leakingObjectFilter", "Lkotlin/Function1;", "Lshark/HeapObject;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "heapObject", "", "getLeakingObjectFilter$shark_android", "()Lkotlin/jvm/functions/Function1;", "VIEW", "EDITOR", "ACTIVITY", "SERVICE", "CONTEXT_FIELD", "CONTEXT_WRAPPER", "APPLICATION_PACKAGE_MANAGER", "CONTEXT_IMPL", "DIALOG", "ACTIVITY_THREAD", "APPLICATION", "INPUT_METHOD_MANAGER", "FRAGMENT", "SUPPORT_FRAGMENT", "ANDROIDX_FRAGMENT", "MESSAGE_QUEUE", "LOADED_APK", "MORTAR_PRESENTER", "MORTAR_SCOPE", "COORDINATOR", "MAIN_THREAD", "VIEW_ROOT_IMPL", "WINDOW", "MESSAGE", "TOAST", "RECOMPOSER", "COMPOSITION_IMPL", "ANIMATOR", "OBJECT_ANIMATOR", "LIFECYCLE_REGISTRY", "STUB", "Companion", "shark-android"}, k = 1, mv = {1, 4, 1})
public abstract class AndroidObjectInspectors implements ObjectInspector {
    private static final /* synthetic */ AndroidObjectInspectors[] $VALUES;
    public static final AndroidObjectInspectors ACTIVITY;
    public static final AndroidObjectInspectors ACTIVITY_THREAD;
    public static final AndroidObjectInspectors ANDROIDX_FRAGMENT;
    public static final AndroidObjectInspectors ANIMATOR;
    public static final AndroidObjectInspectors APPLICATION;
    public static final AndroidObjectInspectors APPLICATION_PACKAGE_MANAGER;
    public static final AndroidObjectInspectors COMPOSITION_IMPL;
    public static final AndroidObjectInspectors CONTEXT_FIELD;
    public static final AndroidObjectInspectors CONTEXT_IMPL;
    public static final AndroidObjectInspectors CONTEXT_WRAPPER;
    public static final AndroidObjectInspectors COORDINATOR;
    public static final Companion Companion;
    public static final AndroidObjectInspectors DIALOG;
    public static final AndroidObjectInspectors EDITOR;
    public static final AndroidObjectInspectors FRAGMENT;
    public static final AndroidObjectInspectors INPUT_METHOD_MANAGER;
    public static final AndroidObjectInspectors LIFECYCLE_REGISTRY;
    public static final AndroidObjectInspectors LOADED_APK;
    public static final AndroidObjectInspectors MAIN_THREAD;
    public static final AndroidObjectInspectors MESSAGE;
    public static final AndroidObjectInspectors MESSAGE_QUEUE;
    public static final AndroidObjectInspectors MORTAR_PRESENTER;
    public static final AndroidObjectInspectors MORTAR_SCOPE;
    public static final AndroidObjectInspectors OBJECT_ANIMATOR;
    public static final AndroidObjectInspectors RECOMPOSER;
    public static final AndroidObjectInspectors SERVICE;
    public static final AndroidObjectInspectors STUB;
    public static final AndroidObjectInspectors SUPPORT_FRAGMENT;
    public static final AndroidObjectInspectors TOAST;
    public static final AndroidObjectInspectors VIEW;
    public static final AndroidObjectInspectors VIEW_ROOT_IMPL;
    public static final AndroidObjectInspectors WINDOW;
    private static final List<FilteringLeakingObjectFinder.LeakingObjectFilter> appLeakingObjectFilters;
    private final String ANDROID_SUPPORT_FRAGMENT_CLASS_NAME;
    private final Function1<HeapObject, Boolean> leakingObjectFilter;

    public static /* synthetic */ void getANDROID_SUPPORT_FRAGMENT_CLASS_NAME$shark_android$annotations() {
    }

    public static AndroidObjectInspectors valueOf(String str) {
        return (AndroidObjectInspectors) Enum.valueOf(AndroidObjectInspectors.class, str);
    }

    public static AndroidObjectInspectors[] values() {
        return (AndroidObjectInspectors[]) $VALUES.clone();
    }

    private AndroidObjectInspectors(String $enum$name, int $enum$ordinal) {
        String str = "android.support.v4.app.Fragment";
        Intrinsics.checkExpressionValueIsNotNull(str, "StringBuilder(\"android.\"…gment\")\n      .toString()");
        this.ANDROID_SUPPORT_FRAGMENT_CLASS_NAME = str;
    }

    public /* synthetic */ AndroidObjectInspectors(String $enum$name, int $enum$ordinal, DefaultConstructorMarker $constructor_marker) {
        this($enum$name, $enum$ordinal);
    }

    /* compiled from: AndroidObjectInspectors.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lshark/AndroidObjectInspectors$SUPPORT_FRAGMENT;", "Lshark/AndroidObjectInspectors;", "leakingObjectFilter", "Lkotlin/Function1;", "Lshark/HeapObject;", "", "getLeakingObjectFilter$shark_android", "()Lkotlin/jvm/functions/Function1;", "inspect", "", "reporter", "Lshark/ObjectReporter;", "shark-android"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    static final class SUPPORT_FRAGMENT extends AndroidObjectInspectors {
        private final Function1<HeapObject, Boolean> leakingObjectFilter;

        SUPPORT_FRAGMENT(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal, null);
            this.leakingObjectFilter = new Function1<HeapObject, Boolean>() { // from class: shark.AndroidObjectInspectors$SUPPORT_FRAGMENT$leakingObjectFilter$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((HeapObject) obj));
                }

                public final boolean invoke(HeapObject heapObject) {
                    Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
                    return (heapObject instanceof HeapObject.HeapInstance) && ((HeapObject.HeapInstance) heapObject).instanceOf(AndroidObjectInspectors.SUPPORT_FRAGMENT.this.getANDROID_SUPPORT_FRAGMENT_CLASS_NAME$shark_android()) && AndroidObjectInspectorsKt.getOrThrow((HeapObject.HeapInstance) heapObject, AndroidObjectInspectors.SUPPORT_FRAGMENT.this.getANDROID_SUPPORT_FRAGMENT_CLASS_NAME$shark_android(), "mFragmentManager").getValue().isNullReference();
                }
            };
        }

        @Override // shark.AndroidObjectInspectors
        public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark_android() {
            return this.leakingObjectFilter;
        }

        @Override // shark.ObjectInspector
        public void inspect(ObjectReporter reporter) {
            Intrinsics.checkParameterIsNotNull(reporter, "reporter");
            reporter.whenInstanceOf(getANDROID_SUPPORT_FRAGMENT_CLASS_NAME$shark_android(), new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$SUPPORT_FRAGMENT$inspect$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                    String describedWithValue;
                    HeapValue value;
                    String describedWithValue2;
                    Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                    Intrinsics.checkParameterIsNotNull(instance, "instance");
                    HeapField fragmentManager = AndroidObjectInspectorsKt.getOrThrow(instance, AndroidObjectInspectors.SUPPORT_FRAGMENT.this.getANDROID_SUPPORT_FRAGMENT_CLASS_NAME$shark_android(), "mFragmentManager");
                    if (fragmentManager.getValue().isNullReference()) {
                        describedWithValue2 = AndroidObjectInspectorsKt.describedWithValue(fragmentManager, "null");
                        $this$whenInstanceOf.getLeakingReasons().add(describedWithValue2);
                    } else {
                        describedWithValue = AndroidObjectInspectorsKt.describedWithValue(fragmentManager, "not null");
                        $this$whenInstanceOf.getNotLeakingReasons().add(describedWithValue);
                    }
                    HeapField heapField = instance.get(AndroidObjectInspectors.SUPPORT_FRAGMENT.this.getANDROID_SUPPORT_FRAGMENT_CLASS_NAME$shark_android(), "mTag");
                    String mTag = (heapField == null || (value = heapField.getValue()) == null) ? null : value.readAsJavaString();
                    String str = mTag;
                    if (!(str == null || str.length() == 0)) {
                        $this$whenInstanceOf.getLabels().add("Fragment.mTag=" + mTag);
                    }
                }
            });
        }
    }

    public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark_android() {
        return this.leakingObjectFilter;
    }

    /* compiled from: AndroidObjectInspectors.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007¨\u0006\u000f"}, d2 = {"Lshark/AndroidObjectInspectors$Companion;", "", "()V", "appDefaults", "", "Lshark/ObjectInspector;", "getAppDefaults", "()Ljava/util/List;", "appLeakingObjectFilters", "Lshark/FilteringLeakingObjectFinder$LeakingObjectFilter;", "getAppLeakingObjectFilters", "createLeakingObjectFilters", "inspectors", "", "Lshark/AndroidObjectInspectors;", "shark-android"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final List<ObjectInspector> getAppDefaults() {
            return CollectionsKt.plus(ObjectInspectors.Companion.getJdkDefaults(), AndroidObjectInspectors.values());
        }

        public final List<FilteringLeakingObjectFinder.LeakingObjectFilter> getAppLeakingObjectFilters() {
            return AndroidObjectInspectors.appLeakingObjectFilters;
        }

        public final List<FilteringLeakingObjectFinder.LeakingObjectFilter> createLeakingObjectFilters(Set<? extends AndroidObjectInspectors> set) {
            Intrinsics.checkParameterIsNotNull(set, "inspectors");
            Set<? extends AndroidObjectInspectors> $this$mapNotNull$iv = set;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                AndroidObjectInspectors it = (AndroidObjectInspectors) element$iv$iv$iv;
                Function1<HeapObject, Boolean> leakingObjectFilter$shark_android = it.getLeakingObjectFilter$shark_android();
                if (leakingObjectFilter$shark_android != null) {
                    destination$iv$iv.add(leakingObjectFilter$shark_android);
                }
            }
            Iterable $this$mapNotNull$iv2 = (List) destination$iv$iv;
            Iterable $this$map$iv = $this$mapNotNull$iv2;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                final Function1 filter = (Function1) item$iv$iv;
                destination$iv$iv2.add(new FilteringLeakingObjectFinder.LeakingObjectFilter() { // from class: shark.AndroidObjectInspectors$Companion$createLeakingObjectFilters$2$1
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
        AndroidObjectInspectors androidObjectInspectors = new AndroidObjectInspectors("VIEW", 0) { // from class: shark.AndroidObjectInspectors.VIEW
            private final Function1<HeapObject, Boolean> leakingObjectFilter = new Function1<HeapObject, Boolean>() { // from class: shark.AndroidObjectInspectors$VIEW$leakingObjectFilter$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((HeapObject) obj));
                }

                /* JADX WARN: Removed duplicated region for block: B:49:0x0099  */
                /* JADX WARN: Removed duplicated region for block: B:50:0x009b  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final boolean invoke(HeapObject heapObject) {
                    boolean mContextIsDestroyedActivity;
                    HeapValue value;
                    Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
                    if (!(heapObject instanceof HeapObject.HeapInstance) || !((HeapObject.HeapInstance) heapObject).instanceOf("android.view.View")) {
                        return false;
                    }
                    HeapField heapField = ((HeapObject.HeapInstance) heapObject).get("android.view.View", "mParent");
                    if (heapField == null) {
                        Intrinsics.throwNpe();
                    }
                    HeapObject.HeapInstance viewParent = heapField.getValueAsInstance();
                    boolean isParentlessView = viewParent == null;
                    boolean isChildOfViewRootImpl = (viewParent == null || viewParent.instanceOf("android.view.View")) ? false : true;
                    boolean isRootView = isParentlessView || isChildOfViewRootImpl;
                    if (!isRootView) {
                        return false;
                    }
                    HeapField heapField2 = ((HeapObject.HeapInstance) heapObject).get("android.view.View", "mContext");
                    if (heapField2 == null) {
                        Intrinsics.throwNpe();
                    }
                    HeapObject asObject = heapField2.getValue().getAsObject();
                    if (asObject == null) {
                        Intrinsics.throwNpe();
                    }
                    HeapObject.HeapInstance mContext = asObject.getAsInstance();
                    if (mContext == null) {
                        Intrinsics.throwNpe();
                    }
                    HeapObject.HeapInstance activityContext = AndroidObjectInspectorsKt.unwrapActivityContext(mContext);
                    if (activityContext != null) {
                        HeapField heapField3 = activityContext.get("android.app.Activity", "mDestroyed");
                        if (Intrinsics.areEqual((heapField3 == null || (value = heapField3.getValue()) == null) ? null : value.getAsBoolean(), true)) {
                            mContextIsDestroyedActivity = true;
                            if (!mContextIsDestroyedActivity) {
                                return true;
                            }
                            HeapField heapField4 = ((HeapObject.HeapInstance) heapObject).get("android.view.View", "mAttachInfo");
                            if (heapField4 == null) {
                                Intrinsics.throwNpe();
                            }
                            boolean viewDetached = heapField4.getValue().isNullReference();
                            if (viewDetached) {
                                HeapField heapField5 = ((HeapObject.HeapInstance) heapObject).get("android.view.View", "mWindowAttachCount");
                                HeapValue value2 = heapField5 != null ? heapField5.getValue() : null;
                                if (value2 == null) {
                                    Intrinsics.throwNpe();
                                }
                                Integer asInt = value2.getAsInt();
                                if (asInt == null) {
                                    Intrinsics.throwNpe();
                                }
                                int mWindowAttachCount = asInt.intValue();
                                if (mWindowAttachCount > 0) {
                                    return isChildOfViewRootImpl || Intrinsics.areEqual(((HeapObject.HeapInstance) heapObject).getInstanceClassName(), "com.android.internal.policy.DecorView");
                                }
                                return false;
                            }
                            return false;
                        }
                    }
                    mContextIsDestroyedActivity = false;
                    if (!mContextIsDestroyedActivity) {
                    }
                }
            };

            @Override // shark.AndroidObjectInspectors
            public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark_android() {
                return this.leakingObjectFilter;
            }

            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("android.view.View", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$VIEW$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:66:0x013f  */
                    /* JADX WARN: Removed duplicated region for block: B:67:0x0142  */
                    /* JADX WARN: Removed duplicated region for block: B:70:0x014f  */
                    /* JADX WARN: Removed duplicated region for block: B:71:0x0152  */
                    /* JADX WARN: Removed duplicated region for block: B:74:0x0166  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        String str;
                        String str2;
                        AndroidResourceIdNames resIds;
                        HeapValue value;
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        HeapField heapField = instance.get("android.view.View", "mParent");
                        if (heapField == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject.HeapInstance rootParent = heapField.getValueAsInstance();
                        Boolean bool = null;
                        HeapObject.HeapInstance rootView = null;
                        while (rootParent != null && rootParent.instanceOf("android.view.View")) {
                            rootView = rootParent;
                            HeapField heapField2 = rootParent.get("android.view.View", "mParent");
                            if (heapField2 == null) {
                                Intrinsics.throwNpe();
                            }
                            rootParent = heapField2.getValueAsInstance();
                        }
                        boolean partOfWindowHierarchy = rootParent != null || (rootView != null && Intrinsics.areEqual(rootView.getInstanceClassName(), "com.android.internal.policy.DecorView"));
                        HeapField heapField3 = instance.get("android.view.View", "mWindowAttachCount");
                        HeapValue value2 = heapField3 != null ? heapField3.getValue() : null;
                        if (value2 == null) {
                            Intrinsics.throwNpe();
                        }
                        Integer asInt = value2.getAsInt();
                        if (asInt == null) {
                            Intrinsics.throwNpe();
                        }
                        int mWindowAttachCount = asInt.intValue();
                        HeapField heapField4 = instance.get("android.view.View", "mAttachInfo");
                        if (heapField4 == null) {
                            Intrinsics.throwNpe();
                        }
                        boolean viewDetached = heapField4.getValue().isNullReference();
                        HeapField heapField5 = instance.get("android.view.View", "mContext");
                        if (heapField5 == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject asObject = heapField5.getValue().getAsObject();
                        if (asObject == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject.HeapInstance mContext = asObject.getAsInstance();
                        if (mContext == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject.HeapInstance activityContext = AndroidObjectInspectorsKt.unwrapActivityContext(mContext);
                        if (activityContext != null) {
                            HeapField heapField6 = activityContext.get("android.app.Activity", "mDestroyed");
                            if (heapField6 != null && (value = heapField6.getValue()) != null) {
                                bool = value.getAsBoolean();
                            }
                            if (Intrinsics.areEqual(bool, true)) {
                                $this$whenInstanceOf.getLeakingReasons().add("View.mContext references a destroyed activity");
                                LinkedHashSet<String> labels = $this$whenInstanceOf.getLabels();
                                if (!partOfWindowHierarchy) {
                                    str = "View is part of a window view hierarchy";
                                } else {
                                    str = "View not part of a window view hierarchy";
                                }
                                labels.add(str);
                                LinkedHashSet<String> labels2 = $this$whenInstanceOf.getLabels();
                                if (!viewDetached) {
                                    str2 = "View.mAttachInfo is null (view detached)";
                                } else {
                                    str2 = "View.mAttachInfo is not null (view attached)";
                                }
                                labels2.add(str2);
                                resIds = AndroidResourceIdNames.Companion.readFromHeap(instance.getGraph());
                                if (resIds != null) {
                                    HeapField heapField7 = instance.get("android.view.View", "mID");
                                    if (heapField7 == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    Integer asInt2 = heapField7.getValue().getAsInt();
                                    if (asInt2 == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    int mID = asInt2.intValue();
                                    if (mID != -1) {
                                        String resourceName = resIds.get(mID);
                                        $this$whenInstanceOf.getLabels().add("View.mID = R.id." + resourceName);
                                    }
                                }
                                $this$whenInstanceOf.getLabels().add("View.mWindowAttachCount = " + mWindowAttachCount);
                            }
                        }
                        if (partOfWindowHierarchy && mWindowAttachCount > 0) {
                            if (viewDetached) {
                                $this$whenInstanceOf.getLeakingReasons().add("View detached yet still part of window view hierarchy");
                            } else {
                                if (rootView != null) {
                                    HeapField heapField8 = rootView.get("android.view.View", "mAttachInfo");
                                    if (heapField8 == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    if (heapField8.getValue().isNullReference()) {
                                        $this$whenInstanceOf.getLeakingReasons().add("View attached but root view " + rootView.getInstanceClassName() + " detached (attach disorder)");
                                    }
                                }
                                $this$whenInstanceOf.getNotLeakingReasons().add("View attached");
                            }
                        }
                        LinkedHashSet<String> labels3 = $this$whenInstanceOf.getLabels();
                        if (!partOfWindowHierarchy) {
                        }
                        labels3.add(str);
                        LinkedHashSet<String> labels22 = $this$whenInstanceOf.getLabels();
                        if (!viewDetached) {
                        }
                        labels22.add(str2);
                        resIds = AndroidResourceIdNames.Companion.readFromHeap(instance.getGraph());
                        if (resIds != null) {
                        }
                        $this$whenInstanceOf.getLabels().add("View.mWindowAttachCount = " + mWindowAttachCount);
                    }
                });
            }
        };
        VIEW = androidObjectInspectors;
        AndroidObjectInspectors androidObjectInspectors2 = new AndroidObjectInspectors("EDITOR", 1) { // from class: shark.AndroidObjectInspectors.EDITOR
            private final Function1<HeapObject, Boolean> leakingObjectFilter = new Function1<HeapObject, Boolean>() { // from class: shark.AndroidObjectInspectors$EDITOR$leakingObjectFilter$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((HeapObject) obj));
                }

                public final boolean invoke(HeapObject heapObject) {
                    boolean z;
                    HeapValue value;
                    HeapObject textView;
                    Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
                    if ((heapObject instanceof HeapObject.HeapInstance) && ((HeapObject.HeapInstance) heapObject).instanceOf("android.widget.Editor")) {
                        HeapField heapField = ((HeapObject.HeapInstance) heapObject).get("android.widget.Editor", "mTextView");
                        if (heapField != null && (value = heapField.getValue()) != null && (textView = value.getAsObject()) != null) {
                            Function1<HeapObject, Boolean> leakingObjectFilter$shark_android = AndroidObjectInspectors.VIEW.getLeakingObjectFilter$shark_android();
                            if (leakingObjectFilter$shark_android == null) {
                                Intrinsics.throwNpe();
                            }
                            z = ((Boolean) leakingObjectFilter$shark_android.invoke(textView)).booleanValue();
                        } else {
                            z = false;
                        }
                        return z;
                    }
                    return false;
                }
            };

            @Override // shark.AndroidObjectInspectors
            public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark_android() {
                return this.leakingObjectFilter;
            }

            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("android.widget.Editor", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$EDITOR$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        AndroidObjectInspectorsKt.applyFromField($this$whenInstanceOf, AndroidObjectInspectors.VIEW, instance.get("android.widget.Editor", "mTextView"));
                    }
                });
            }
        };
        EDITOR = androidObjectInspectors2;
        AndroidObjectInspectors androidObjectInspectors3 = new AndroidObjectInspectors("ACTIVITY", 2) { // from class: shark.AndroidObjectInspectors.ACTIVITY
            private final Function1<HeapObject, Boolean> leakingObjectFilter = new Function1<HeapObject, Boolean>() { // from class: shark.AndroidObjectInspectors$ACTIVITY$leakingObjectFilter$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((HeapObject) obj));
                }

                public final boolean invoke(HeapObject heapObject) {
                    HeapValue value;
                    Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
                    if ((heapObject instanceof HeapObject.HeapInstance) && ((HeapObject.HeapInstance) heapObject).instanceOf("android.app.Activity")) {
                        HeapField heapField = ((HeapObject.HeapInstance) heapObject).get("android.app.Activity", "mDestroyed");
                        if (Intrinsics.areEqual((heapField == null || (value = heapField.getValue()) == null) ? null : value.getAsBoolean(), true)) {
                            return true;
                        }
                    }
                    return false;
                }
            };

            @Override // shark.AndroidObjectInspectors
            public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark_android() {
                return this.leakingObjectFilter;
            }

            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("android.app.Activity", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$ACTIVITY$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        String describedWithValue;
                        String describedWithValue2;
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        HeapField field = instance.get("android.app.Activity", "mDestroyed");
                        if (field != null) {
                            Boolean asBoolean = field.getValue().getAsBoolean();
                            if (asBoolean == null) {
                                Intrinsics.throwNpe();
                            }
                            if (asBoolean.booleanValue()) {
                                describedWithValue2 = AndroidObjectInspectorsKt.describedWithValue(field, "true");
                                $this$whenInstanceOf.getLeakingReasons().add(describedWithValue2);
                                return;
                            }
                            describedWithValue = AndroidObjectInspectorsKt.describedWithValue(field, "false");
                            $this$whenInstanceOf.getNotLeakingReasons().add(describedWithValue);
                        }
                    }
                });
            }
        };
        ACTIVITY = androidObjectInspectors3;
        AndroidObjectInspectors androidObjectInspectors4 = new AndroidObjectInspectors("SERVICE", 3) { // from class: shark.AndroidObjectInspectors.SERVICE
            private final Function1<HeapObject, Boolean> leakingObjectFilter = new Function1<HeapObject, Boolean>() { // from class: shark.AndroidObjectInspectors$SERVICE$leakingObjectFilter$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((HeapObject) obj));
                }

                public final boolean invoke(HeapObject heapObject) {
                    Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
                    return (heapObject instanceof HeapObject.HeapInstance) && ((HeapObject.HeapInstance) heapObject).instanceOf("android.app.Service") && !AndroidServices.INSTANCE.getAliveAndroidServiceObjectIds(heapObject.getGraph()).contains(Long.valueOf(heapObject.getObjectId()));
                }
            };

            @Override // shark.AndroidObjectInspectors
            public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark_android() {
                return this.leakingObjectFilter;
            }

            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("android.app.Service", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$SERVICE$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        if (AndroidServices.INSTANCE.getAliveAndroidServiceObjectIds(instance.getGraph()).contains(Long.valueOf(instance.getObjectId()))) {
                            $this$whenInstanceOf.getNotLeakingReasons().add("Service held by ActivityThread");
                        } else {
                            $this$whenInstanceOf.getLeakingReasons().add("Service not held by ActivityThread");
                        }
                    }
                });
            }
        };
        SERVICE = androidObjectInspectors4;
        AndroidObjectInspectors androidObjectInspectors5 = new AndroidObjectInspectors("CONTEXT_FIELD", 4) { // from class: shark.AndroidObjectInspectors.CONTEXT_FIELD
            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                HeapObject instance;
                String str;
                HeapValue value;
                Boolean asBoolean;
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                HeapObject instance2 = reporter.getHeapObject();
                if (!(instance2 instanceof HeapObject.HeapInstance)) {
                    return;
                }
                Sequence $this$forEach$iv = ((HeapObject.HeapInstance) instance2).readFields();
                for (Object element$iv : $this$forEach$iv) {
                    HeapField field = (HeapField) element$iv;
                    HeapObject.HeapInstance fieldInstance = field.getValueAsInstance();
                    if (fieldInstance == null || !fieldInstance.instanceOf("android.content.Context")) {
                        instance = instance2;
                    } else {
                        HeapObject.HeapInstance componentContext = AndroidObjectInspectorsKt.unwrapComponentContext(fieldInstance);
                        LinkedHashSet<String> labels = reporter.getLabels();
                        if (componentContext == null) {
                            str = field.getName() + " instance of " + fieldInstance.getInstanceClassName();
                            instance = instance2;
                        } else if (componentContext.instanceOf("android.app.Activity")) {
                            instance = instance2;
                            StringBuilder append = new StringBuilder().append("with mDestroyed = ");
                            HeapField heapField = componentContext.get("android.app.Activity", "mDestroyed");
                            String activityDescription = append.append((heapField == null || (value = heapField.getValue()) == null || (asBoolean = value.getAsBoolean()) == null || (r14 = String.valueOf(asBoolean.booleanValue())) == null) ? "UNKNOWN" : "UNKNOWN").toString();
                            if (Intrinsics.areEqual(componentContext, fieldInstance)) {
                                str = field.getName() + " instance of " + fieldInstance.getInstanceClassName() + ' ' + activityDescription;
                            } else {
                                str = field.getName() + " instance of " + fieldInstance.getInstanceClassName() + ", wrapping activity " + componentContext.getInstanceClassName() + ' ' + activityDescription;
                            }
                        } else {
                            instance = instance2;
                            if (Intrinsics.areEqual(componentContext, fieldInstance)) {
                                str = field.getName() + " instance of " + fieldInstance.getInstanceClassName();
                            } else {
                                str = field.getName() + " instance of " + fieldInstance.getInstanceClassName() + ", wrapping " + componentContext.getInstanceClassName();
                            }
                        }
                        labels.add(str);
                    }
                    instance2 = instance;
                }
            }
        };
        CONTEXT_FIELD = androidObjectInspectors5;
        AndroidObjectInspectors androidObjectInspectors6 = new AndroidObjectInspectors("CONTEXT_WRAPPER", 5) { // from class: shark.AndroidObjectInspectors.CONTEXT_WRAPPER
            private final Function1<HeapObject, Boolean> leakingObjectFilter = new Function1<HeapObject, Boolean>() { // from class: shark.AndroidObjectInspectors$CONTEXT_WRAPPER$leakingObjectFilter$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((HeapObject) obj));
                }

                public final boolean invoke(HeapObject heapObject) {
                    HeapField heapField;
                    HeapValue value;
                    Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
                    if (heapObject instanceof HeapObject.HeapInstance) {
                        HeapObject.HeapInstance unwrapActivityContext = AndroidObjectInspectorsKt.unwrapActivityContext((HeapObject.HeapInstance) heapObject);
                        if (Intrinsics.areEqual((unwrapActivityContext == null || (heapField = unwrapActivityContext.get("android.app.Activity", "mDestroyed")) == null || (value = heapField.getValue()) == null) ? null : value.getAsBoolean(), true)) {
                            return true;
                        }
                    }
                    return false;
                }
            };

            @Override // shark.AndroidObjectInspectors
            public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark_android() {
                return this.leakingObjectFilter;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:12:0x0049, code lost:
                if (r8.equals("android.content.ContextWrapper") != false) goto L12;
             */
            /* JADX WARN: Code restructure failed: missing block: B:15:0x0052, code lost:
                if (r8.equals("android.app.Service") != false) goto L12;
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
                if (r8.equals("android.app.Application") != false) goto L12;
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
                if (r8.equals("android.app.Activity") != false) goto L12;
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
                r10 = true;
             */
            /* JADX WARN: Code restructure failed: missing block: B:52:0x0065, code lost:
                continue;
             */
            @Override // shark.ObjectInspector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void inspect(ObjectReporter reporter) {
                Object element$iv;
                boolean z;
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                HeapObject instance = reporter.getHeapObject();
                if (!(instance instanceof HeapObject.HeapInstance)) {
                    return;
                }
                Sequence $this$firstOrNull$iv = SequencesKt.map(((HeapObject.HeapInstance) instance).getInstanceClass().getClassHierarchy(), new Function1<HeapObject.HeapClass, String>() { // from class: shark.AndroidObjectInspectors$CONTEXT_WRAPPER$inspect$matchingClassName$1
                    public final String invoke(HeapObject.HeapClass it) {
                        Intrinsics.checkParameterIsNotNull(it, "it");
                        return it.getName();
                    }
                });
                Iterator it = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        element$iv = it.next();
                        String it2 = (String) element$iv;
                        switch (it2.hashCode()) {
                            case -880360069:
                                break;
                            case 735120228:
                                break;
                            case 762246857:
                                break;
                            case 774146168:
                                break;
                            default:
                                z = false;
                                continue;
                        }
                        if (z) {
                        }
                    } else {
                        element$iv = null;
                    }
                }
                String matchingClassName = (String) element$iv;
                if (Intrinsics.areEqual(matchingClassName, "android.content.ContextWrapper")) {
                    HeapObject.HeapInstance componentContext = AndroidObjectInspectorsKt.unwrapComponentContext((HeapObject.HeapInstance) instance);
                    if (componentContext != null) {
                        if (componentContext.instanceOf("android.app.Activity")) {
                            HeapField mDestroyed = componentContext.get("android.app.Activity", "mDestroyed");
                            if (mDestroyed != null) {
                                Boolean asBoolean = mDestroyed.getValue().getAsBoolean();
                                if (asBoolean == null) {
                                    Intrinsics.throwNpe();
                                }
                                if (asBoolean.booleanValue()) {
                                    reporter.getLeakingReasons().add(((HeapObject.HeapInstance) instance).getInstanceClassSimpleName() + " wraps an Activity with Activity.mDestroyed true");
                                    return;
                                } else {
                                    reporter.getLabels().add(((HeapObject.HeapInstance) instance).getInstanceClassSimpleName() + " wraps an Activity with Activity.mDestroyed false");
                                    return;
                                }
                            }
                            return;
                        } else if (componentContext.instanceOf("android.app.Application")) {
                            reporter.getLabels().add(((HeapObject.HeapInstance) instance).getInstanceClassSimpleName() + " wraps an Application context");
                            return;
                        } else {
                            reporter.getLabels().add(((HeapObject.HeapInstance) instance).getInstanceClassSimpleName() + " wraps a Service context");
                            return;
                        }
                    }
                    reporter.getLabels().add(((HeapObject.HeapInstance) instance).getInstanceClassSimpleName() + " does not wrap a known Android context");
                }
            }
        };
        CONTEXT_WRAPPER = androidObjectInspectors6;
        AndroidObjectInspectors androidObjectInspectors7 = new AndroidObjectInspectors("APPLICATION_PACKAGE_MANAGER", 6) { // from class: shark.AndroidObjectInspectors.APPLICATION_PACKAGE_MANAGER
            private final Function1<HeapObject, Boolean> leakingObjectFilter = new Function1<HeapObject, Boolean>() { // from class: shark.AndroidObjectInspectors$APPLICATION_PACKAGE_MANAGER$leakingObjectFilter$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((HeapObject) obj));
                }

                public final boolean invoke(HeapObject heapObject) {
                    boolean outerContextIsLeaking;
                    Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
                    if ((heapObject instanceof HeapObject.HeapInstance) && ((HeapObject.HeapInstance) heapObject).instanceOf("android.app.ApplicationContextManager")) {
                        HeapField heapField = ((HeapObject.HeapInstance) heapObject).get("android.app.ApplicationContextManager", "mContext");
                        if (heapField == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject.HeapInstance valueAsInstance = heapField.getValueAsInstance();
                        if (valueAsInstance == null) {
                            Intrinsics.throwNpe();
                        }
                        outerContextIsLeaking = AndroidObjectInspectorsKt.outerContextIsLeaking(valueAsInstance);
                        if (outerContextIsLeaking) {
                            return true;
                        }
                    }
                    return false;
                }
            };

            @Override // shark.AndroidObjectInspectors
            public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark_android() {
                return this.leakingObjectFilter;
            }

            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("android.app.ApplicationContextManager", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$APPLICATION_PACKAGE_MANAGER$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        HeapField heapField = instance.get("android.app.ApplicationContextManager", "mContext");
                        if (heapField == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject.HeapInstance valueAsInstance = heapField.getValueAsInstance();
                        if (valueAsInstance == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapField heapField2 = valueAsInstance.get("android.app.ContextImpl", "mOuterContext");
                        if (heapField2 == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject.HeapInstance outerContext = heapField2.getValueAsInstance();
                        if (outerContext == null) {
                            Intrinsics.throwNpe();
                        }
                        AndroidObjectInspectorsKt.inspectContextImplOuterContext($this$whenInstanceOf, outerContext, instance, "ApplicationContextManager.mContext");
                    }
                });
            }
        };
        APPLICATION_PACKAGE_MANAGER = androidObjectInspectors7;
        AndroidObjectInspectors androidObjectInspectors8 = new AndroidObjectInspectors("CONTEXT_IMPL", 7) { // from class: shark.AndroidObjectInspectors.CONTEXT_IMPL
            private final Function1<HeapObject, Boolean> leakingObjectFilter = new Function1<HeapObject, Boolean>() { // from class: shark.AndroidObjectInspectors$CONTEXT_IMPL$leakingObjectFilter$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((HeapObject) obj));
                }

                public final boolean invoke(HeapObject heapObject) {
                    boolean outerContextIsLeaking;
                    Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
                    if ((heapObject instanceof HeapObject.HeapInstance) && ((HeapObject.HeapInstance) heapObject).instanceOf("android.app.ContextImpl")) {
                        outerContextIsLeaking = AndroidObjectInspectorsKt.outerContextIsLeaking((HeapObject.HeapInstance) heapObject);
                        if (outerContextIsLeaking) {
                            return true;
                        }
                    }
                    return false;
                }
            };

            @Override // shark.AndroidObjectInspectors
            public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark_android() {
                return this.leakingObjectFilter;
            }

            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("android.app.ContextImpl", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$CONTEXT_IMPL$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        HeapField heapField = instance.get("android.app.ContextImpl", "mOuterContext");
                        if (heapField == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject.HeapInstance outerContext = heapField.getValueAsInstance();
                        if (outerContext == null) {
                            Intrinsics.throwNpe();
                        }
                        AndroidObjectInspectorsKt.inspectContextImplOuterContext$default($this$whenInstanceOf, outerContext, instance, null, 4, null);
                    }
                });
            }
        };
        CONTEXT_IMPL = androidObjectInspectors8;
        AndroidObjectInspectors androidObjectInspectors9 = new AndroidObjectInspectors("DIALOG", 8) { // from class: shark.AndroidObjectInspectors.DIALOG
            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("android.app.Dialog", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$DIALOG$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        String str;
                        String describedWithValue;
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        HeapField mDecor = instance.get("android.app.Dialog", "mDecor");
                        if (mDecor == null) {
                            Intrinsics.throwNpe();
                        }
                        LinkedHashSet<String> labels = $this$whenInstanceOf.getLabels();
                        if (mDecor.getValue().isNullReference()) {
                            str = "null";
                        } else {
                            str = "not null";
                        }
                        describedWithValue = AndroidObjectInspectorsKt.describedWithValue(mDecor, str);
                        labels.add(describedWithValue);
                    }
                });
            }
        };
        DIALOG = androidObjectInspectors9;
        AndroidObjectInspectors androidObjectInspectors10 = new AndroidObjectInspectors("ACTIVITY_THREAD", 9) { // from class: shark.AndroidObjectInspectors.ACTIVITY_THREAD
            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("android.app.ActivityThread", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$ACTIVITY_THREAD$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance it) {
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(it, "it");
                        $this$whenInstanceOf.getNotLeakingReasons().add("ActivityThread is a singleton");
                    }
                });
            }
        };
        ACTIVITY_THREAD = androidObjectInspectors10;
        AndroidObjectInspectors androidObjectInspectors11 = new AndroidObjectInspectors("APPLICATION", 10) { // from class: shark.AndroidObjectInspectors.APPLICATION
            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("android.app.Application", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$APPLICATION$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance it) {
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(it, "it");
                        $this$whenInstanceOf.getNotLeakingReasons().add("Application is a singleton");
                    }
                });
            }
        };
        APPLICATION = androidObjectInspectors11;
        AndroidObjectInspectors androidObjectInspectors12 = new AndroidObjectInspectors("INPUT_METHOD_MANAGER", 11) { // from class: shark.AndroidObjectInspectors.INPUT_METHOD_MANAGER
            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("android.view.inputmethod.InputMethodManager", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$INPUT_METHOD_MANAGER$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance it) {
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(it, "it");
                        $this$whenInstanceOf.getNotLeakingReasons().add("InputMethodManager is a singleton");
                    }
                });
            }
        };
        INPUT_METHOD_MANAGER = androidObjectInspectors12;
        AndroidObjectInspectors androidObjectInspectors13 = new AndroidObjectInspectors("FRAGMENT", 12) { // from class: shark.AndroidObjectInspectors.FRAGMENT
            private final Function1<HeapObject, Boolean> leakingObjectFilter = new Function1<HeapObject, Boolean>() { // from class: shark.AndroidObjectInspectors$FRAGMENT$leakingObjectFilter$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((HeapObject) obj));
                }

                public final boolean invoke(HeapObject heapObject) {
                    Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
                    if ((heapObject instanceof HeapObject.HeapInstance) && ((HeapObject.HeapInstance) heapObject).instanceOf("android.app.Fragment")) {
                        HeapField heapField = ((HeapObject.HeapInstance) heapObject).get("android.app.Fragment", "mFragmentManager");
                        if (heapField == null) {
                            Intrinsics.throwNpe();
                        }
                        if (heapField.getValue().isNullReference()) {
                            return true;
                        }
                    }
                    return false;
                }
            };

            @Override // shark.AndroidObjectInspectors
            public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark_android() {
                return this.leakingObjectFilter;
            }

            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("android.app.Fragment", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$FRAGMENT$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        String describedWithValue;
                        HeapValue value;
                        String describedWithValue2;
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        HeapField fragmentManager = instance.get("android.app.Fragment", "mFragmentManager");
                        if (fragmentManager == null) {
                            Intrinsics.throwNpe();
                        }
                        if (fragmentManager.getValue().isNullReference()) {
                            describedWithValue2 = AndroidObjectInspectorsKt.describedWithValue(fragmentManager, "null");
                            $this$whenInstanceOf.getLeakingReasons().add(describedWithValue2);
                        } else {
                            describedWithValue = AndroidObjectInspectorsKt.describedWithValue(fragmentManager, "not null");
                            $this$whenInstanceOf.getNotLeakingReasons().add(describedWithValue);
                        }
                        HeapField heapField = instance.get("android.app.Fragment", "mTag");
                        String mTag = (heapField == null || (value = heapField.getValue()) == null) ? null : value.readAsJavaString();
                        String str = mTag;
                        if (!(str == null || str.length() == 0)) {
                            $this$whenInstanceOf.getLabels().add("Fragment.mTag=" + mTag);
                        }
                    }
                });
            }
        };
        FRAGMENT = androidObjectInspectors13;
        SUPPORT_FRAGMENT support_fragment = new SUPPORT_FRAGMENT("SUPPORT_FRAGMENT", 13);
        SUPPORT_FRAGMENT = support_fragment;
        AndroidObjectInspectors androidObjectInspectors14 = new AndroidObjectInspectors("ANDROIDX_FRAGMENT", 14) { // from class: shark.AndroidObjectInspectors.ANDROIDX_FRAGMENT
            private final Function1<HeapObject, Boolean> leakingObjectFilter = new Function1<HeapObject, Boolean>() { // from class: shark.AndroidObjectInspectors$ANDROIDX_FRAGMENT$leakingObjectFilter$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((HeapObject) obj));
                }

                public final boolean invoke(HeapObject heapObject) {
                    Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
                    if ((heapObject instanceof HeapObject.HeapInstance) && ((HeapObject.HeapInstance) heapObject).instanceOf("androidx.fragment.app.Fragment")) {
                        HeapField heapField = ((HeapObject.HeapInstance) heapObject).get("androidx.fragment.app.Fragment", "mLifecycleRegistry");
                        if (heapField == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject.HeapInstance valueAsInstance = heapField.getValueAsInstance();
                        if (Intrinsics.areEqual(valueAsInstance != null ? AndroidObjectInspectorsKt.getLifecycleRegistryState(valueAsInstance) : null, "DESTROYED")) {
                            return true;
                        }
                    }
                    return false;
                }
            };

            @Override // shark.AndroidObjectInspectors
            public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark_android() {
                return this.leakingObjectFilter;
            }

            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("androidx.fragment.app.Fragment", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$ANDROIDX_FRAGMENT$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        HeapValue value;
                        String state;
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        HeapField lifecycleRegistryField = instance.get("androidx.fragment.app.Fragment", "mLifecycleRegistry");
                        if (lifecycleRegistryField == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject.HeapInstance lifecycleRegistry = lifecycleRegistryField.getValueAsInstance();
                        if (lifecycleRegistry != null) {
                            state = AndroidObjectInspectorsKt.getLifecycleRegistryState(lifecycleRegistry);
                            String reason = "Fragment.mLifecycleRegistry.state is " + state;
                            if (Intrinsics.areEqual(state, "DESTROYED")) {
                                $this$whenInstanceOf.getLeakingReasons().add(reason);
                            } else {
                                $this$whenInstanceOf.getNotLeakingReasons().add(reason);
                            }
                        } else {
                            $this$whenInstanceOf.getLabels().add("Fragment.mLifecycleRegistry = null");
                        }
                        HeapField heapField = instance.get("androidx.fragment.app.Fragment", "mTag");
                        String mTag = (heapField == null || (value = heapField.getValue()) == null) ? null : value.readAsJavaString();
                        String str = mTag;
                        if (!(str == null || str.length() == 0)) {
                            $this$whenInstanceOf.getLabels().add("Fragment.mTag = " + mTag);
                        }
                    }
                });
            }
        };
        ANDROIDX_FRAGMENT = androidObjectInspectors14;
        AndroidObjectInspectors androidObjectInspectors15 = new AndroidObjectInspectors("MESSAGE_QUEUE", 15) { // from class: shark.AndroidObjectInspectors.MESSAGE_QUEUE
            private final Function1<HeapObject, Boolean> leakingObjectFilter = new Function1<HeapObject, Boolean>() { // from class: shark.AndroidObjectInspectors$MESSAGE_QUEUE$leakingObjectFilter$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((HeapObject) obj));
                }

                public final boolean invoke(HeapObject heapObject) {
                    Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
                    if ((heapObject instanceof HeapObject.HeapInstance) && ((HeapObject.HeapInstance) heapObject).instanceOf("android.os.MessageQueue")) {
                        HeapField heapField = ((HeapObject.HeapInstance) heapObject).get("android.os.MessageQueue", "mQuitting");
                        if (heapField == null && (heapField = ((HeapObject.HeapInstance) heapObject).get("android.os.MessageQueue", "mQuiting")) == null) {
                            Intrinsics.throwNpe();
                        }
                        Boolean asBoolean = heapField.getValue().getAsBoolean();
                        if (asBoolean == null) {
                            Intrinsics.throwNpe();
                        }
                        if (asBoolean.booleanValue()) {
                            return true;
                        }
                    }
                    return false;
                }
            };

            @Override // shark.AndroidObjectInspectors
            public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark_android() {
                return this.leakingObjectFilter;
            }

            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("android.os.MessageQueue", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$MESSAGE_QUEUE$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        String describedWithValue;
                        String describedWithValue2;
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        HeapField mQuitting = instance.get("android.os.MessageQueue", "mQuitting");
                        if (mQuitting == null && (mQuitting = instance.get("android.os.MessageQueue", "mQuiting")) == null) {
                            Intrinsics.throwNpe();
                        }
                        Boolean asBoolean = mQuitting.getValue().getAsBoolean();
                        if (asBoolean == null) {
                            Intrinsics.throwNpe();
                        }
                        if (asBoolean.booleanValue()) {
                            describedWithValue2 = AndroidObjectInspectorsKt.describedWithValue(mQuitting, "true");
                            $this$whenInstanceOf.getLeakingReasons().add(describedWithValue2);
                        } else {
                            describedWithValue = AndroidObjectInspectorsKt.describedWithValue(mQuitting, "false");
                            $this$whenInstanceOf.getNotLeakingReasons().add(describedWithValue);
                        }
                        HeapField heapField = instance.get("android.os.MessageQueue", "mMessages");
                        if (heapField == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject.HeapInstance queueHead = heapField.getValueAsInstance();
                        if (queueHead != null) {
                            HeapField heapField2 = queueHead.get("android.os.Message", "target");
                            if (heapField2 == null) {
                                Intrinsics.throwNpe();
                            }
                            HeapObject.HeapInstance targetHandler = heapField2.getValueAsInstance();
                            if (targetHandler != null) {
                                HeapField heapField3 = targetHandler.get("android.os.Handler", "mLooper");
                                if (heapField3 == null) {
                                    Intrinsics.throwNpe();
                                }
                                HeapObject.HeapInstance looper = heapField3.getValueAsInstance();
                                if (looper != null) {
                                    HeapField heapField4 = looper.get("android.os.Looper", "mThread");
                                    if (heapField4 == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    HeapObject.HeapInstance thread = heapField4.getValueAsInstance();
                                    if (thread == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    HeapField heapField5 = thread.get(Reflection.getOrCreateKotlinClass(Thread.class), ChannelRoutes.CHANNEL_NAME);
                                    if (heapField5 == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    String threadName = heapField5.getValue().readAsJavaString();
                                    $this$whenInstanceOf.getLabels().add("HandlerThread: \"" + threadName + '\"');
                                }
                            }
                        }
                    }
                });
            }
        };
        MESSAGE_QUEUE = androidObjectInspectors15;
        AndroidObjectInspectors androidObjectInspectors16 = new AndroidObjectInspectors("LOADED_APK", 16) { // from class: shark.AndroidObjectInspectors.LOADED_APK
            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("android.app.LoadedApk", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$LOADED_APK$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        HeapObject.HeapInstance receiversMap;
                        String str;
                        String str2;
                        List contextReceivers;
                        Collection destination$iv$iv;
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        HeapField heapField = instance.get("android.app.LoadedApk", "mReceivers");
                        if (heapField == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject.HeapInstance receiversMap2 = heapField.getValueAsInstance();
                        if (receiversMap2 == null) {
                            Intrinsics.throwNpe();
                        }
                        String str3 = "android.util.ArrayMap";
                        String str4 = "mArray";
                        HeapField heapField2 = receiversMap2.get("android.util.ArrayMap", "mArray");
                        if (heapField2 == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject.HeapObjectArray receiversArray = heapField2.getValueAsObjectArray();
                        if (receiversArray == null) {
                            Intrinsics.throwNpe();
                        }
                        List receiverContextList = SequencesKt.toList(receiversArray.readElements());
                        Iterable $this$mapNotNull$iv = RangesKt.step(CollectionsKt.getIndices(receiverContextList), 2);
                        Collection destination$iv$iv2 = new ArrayList();
                        IntIterator it = $this$mapNotNull$iv.iterator();
                        while (it.hasNext()) {
                            int element$iv$iv$iv = it.nextInt();
                            HeapValue context = (HeapValue) receiverContextList.get(element$iv$iv$iv);
                            Pair pair = null;
                            if (context.isNonNullReference()) {
                                HeapObject asObject = ((HeapValue) receiverContextList.get(element$iv$iv$iv + 1)).getAsObject();
                                if (asObject == null) {
                                    Intrinsics.throwNpe();
                                }
                                HeapObject.HeapInstance contextReceiversMap = asObject.getAsInstance();
                                if (contextReceiversMap == null) {
                                    Intrinsics.throwNpe();
                                }
                                HeapField heapField3 = contextReceiversMap.get(str3, str4);
                                if (heapField3 == null) {
                                    Intrinsics.throwNpe();
                                }
                                HeapObject.HeapObjectArray valueAsObjectArray = heapField3.getValueAsObjectArray();
                                if (valueAsObjectArray == null) {
                                    Intrinsics.throwNpe();
                                }
                                List contextReceivers2 = SequencesKt.toList(valueAsObjectArray.readElements());
                                receiversMap = receiversMap2;
                                Iterable $this$mapNotNull$iv2 = RangesKt.step(CollectionsKt.getIndices(contextReceivers2), 2);
                                Iterable destination$iv$iv3 = (Collection) new ArrayList();
                                IntIterator it2 = $this$mapNotNull$iv2.iterator();
                                while (it2.hasNext()) {
                                    HeapObject asObject2 = ((HeapValue) contextReceivers2.get(it2.nextInt())).getAsObject();
                                    HeapObject.HeapInstance asInstance = asObject2 != null ? asObject2.getAsInstance() : null;
                                    if (asInstance != null) {
                                        contextReceivers = contextReceivers2;
                                        destination$iv$iv = destination$iv$iv3;
                                        destination$iv$iv.add(asInstance);
                                    } else {
                                        contextReceivers = contextReceivers2;
                                        destination$iv$iv = destination$iv$iv3;
                                    }
                                    destination$iv$iv3 = destination$iv$iv;
                                    contextReceivers2 = contextReceivers;
                                }
                                Iterable receivers = (List) destination$iv$iv3;
                                HeapObject asObject3 = context.getAsObject();
                                if (asObject3 == null) {
                                    Intrinsics.throwNpe();
                                }
                                HeapObject.HeapInstance contextInstance = asObject3.getAsInstance();
                                if (contextInstance == null) {
                                    Intrinsics.throwNpe();
                                }
                                str = str3;
                                str2 = str4;
                                String contextString = contextInstance.getInstanceClassSimpleName() + '@' + contextInstance.getObjectId();
                                Iterable iterable = receivers;
                                boolean z = false;
                                Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                                Iterable $this$mapTo$iv$iv = iterable;
                                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                                    HeapObject.HeapInstance it3 = (HeapObject.HeapInstance) item$iv$iv;
                                    destination$iv$iv4.add(it3.getInstanceClassSimpleName() + '@' + it3.getObjectId());
                                    z = z;
                                    $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                                    iterable = iterable;
                                }
                                pair = TuplesKt.to(contextString, (List) destination$iv$iv4);
                            } else {
                                receiversMap = receiversMap2;
                                str = str3;
                                str2 = str4;
                            }
                            if (pair != null) {
                                destination$iv$iv2.add(pair);
                            }
                            str3 = str;
                            str4 = str2;
                            receiversMap2 = receiversMap;
                        }
                        List allReceivers = CollectionsKt.toList((List) destination$iv$iv2);
                        if (!((Collection) allReceivers).isEmpty()) {
                            $this$whenInstanceOf.getLabels().add("Receivers");
                            Iterable $this$forEach$iv = allReceivers;
                            boolean z2 = false;
                            for (Object element$iv : $this$forEach$iv) {
                                Pair $dstr$contextString$receiverStrings = (Pair) element$iv;
                                String contextString2 = (String) $dstr$contextString$receiverStrings.component1();
                                Iterable receiverStrings = (List) $dstr$contextString$receiverStrings.component2();
                                $this$whenInstanceOf.getLabels().add(".." + contextString2);
                                for (Object element$iv2 : receiverStrings) {
                                    String receiverString = (String) element$iv2;
                                    $this$whenInstanceOf.getLabels().add("...." + receiverString);
                                    $this$forEach$iv = $this$forEach$iv;
                                    allReceivers = allReceivers;
                                    z2 = z2;
                                }
                            }
                        }
                    }
                });
            }
        };
        LOADED_APK = androidObjectInspectors16;
        AndroidObjectInspectors androidObjectInspectors17 = new AndroidObjectInspectors("MORTAR_PRESENTER", 17) { // from class: shark.AndroidObjectInspectors.MORTAR_PRESENTER
            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("mortar.Presenter", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$MORTAR_PRESENTER$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        String describedWithValue;
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        HeapField view = AndroidObjectInspectorsKt.getOrThrow(instance, "mortar.Presenter", "view");
                        LinkedHashSet<String> labels = $this$whenInstanceOf.getLabels();
                        describedWithValue = AndroidObjectInspectorsKt.describedWithValue(view, view.getValue().isNullReference() ? "null" : "not null");
                        labels.add(describedWithValue);
                    }
                });
            }
        };
        MORTAR_PRESENTER = androidObjectInspectors17;
        AndroidObjectInspectors androidObjectInspectors18 = new AndroidObjectInspectors("MORTAR_SCOPE", 18) { // from class: shark.AndroidObjectInspectors.MORTAR_SCOPE
            private final Function1<HeapObject, Boolean> leakingObjectFilter = new Function1<HeapObject, Boolean>() { // from class: shark.AndroidObjectInspectors$MORTAR_SCOPE$leakingObjectFilter$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((HeapObject) obj));
                }

                public final boolean invoke(HeapObject heapObject) {
                    Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
                    if ((heapObject instanceof HeapObject.HeapInstance) && ((HeapObject.HeapInstance) heapObject).instanceOf("mortar.MortarScope")) {
                        Boolean asBoolean = AndroidObjectInspectorsKt.getOrThrow((HeapObject.HeapInstance) heapObject, "mortar.MortarScope", "dead").getValue().getAsBoolean();
                        if (asBoolean == null) {
                            Intrinsics.throwNpe();
                        }
                        if (asBoolean.booleanValue()) {
                            return true;
                        }
                    }
                    return false;
                }
            };

            @Override // shark.AndroidObjectInspectors
            public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark_android() {
                return this.leakingObjectFilter;
            }

            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("mortar.MortarScope", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$MORTAR_SCOPE$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        Boolean asBoolean = AndroidObjectInspectorsKt.getOrThrow(instance, "mortar.MortarScope", "dead").getValue().getAsBoolean();
                        if (asBoolean == null) {
                            Intrinsics.throwNpe();
                        }
                        boolean dead = asBoolean.booleanValue();
                        String scopeName = AndroidObjectInspectorsKt.getOrThrow(instance, "mortar.MortarScope", ChannelRoutes.CHANNEL_NAME).getValue().readAsJavaString();
                        if (dead) {
                            $this$whenInstanceOf.getLeakingReasons().add("mortar.MortarScope.dead is true for scope " + scopeName);
                        } else {
                            $this$whenInstanceOf.getNotLeakingReasons().add("mortar.MortarScope.dead is false for scope " + scopeName);
                        }
                    }
                });
            }
        };
        MORTAR_SCOPE = androidObjectInspectors18;
        AndroidObjectInspectors androidObjectInspectors19 = new AndroidObjectInspectors("COORDINATOR", 19) { // from class: shark.AndroidObjectInspectors.COORDINATOR
            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("com.squareup.coordinators.Coordinator", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$COORDINATOR$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        String describedWithValue;
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        HeapField attached = AndroidObjectInspectorsKt.getOrThrow(instance, "com.squareup.coordinators.Coordinator", "attached");
                        describedWithValue = AndroidObjectInspectorsKt.describedWithValue(attached, String.valueOf(attached.getValue().getAsBoolean()));
                        $this$whenInstanceOf.getLabels().add(describedWithValue);
                    }
                });
            }
        };
        COORDINATOR = androidObjectInspectors19;
        AndroidObjectInspectors androidObjectInspectors20 = new AndroidObjectInspectors("MAIN_THREAD", 20) { // from class: shark.AndroidObjectInspectors.MAIN_THREAD
            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf(Reflection.getOrCreateKotlinClass(Thread.class), new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$MAIN_THREAD$inspect$1
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
                        if (Intrinsics.areEqual(threadName, MainRouteUris.MODULE_MAIN)) {
                            $this$whenInstanceOf.getNotLeakingReasons().add("the main thread always runs");
                        }
                    }
                });
            }
        };
        MAIN_THREAD = androidObjectInspectors20;
        AndroidObjectInspectors androidObjectInspectors21 = new AndroidObjectInspectors("VIEW_ROOT_IMPL", 21) { // from class: shark.AndroidObjectInspectors.VIEW_ROOT_IMPL
            private final Function1<HeapObject, Boolean> leakingObjectFilter = new Function1<HeapObject, Boolean>() { // from class: shark.AndroidObjectInspectors$VIEW_ROOT_IMPL$leakingObjectFilter$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((HeapObject) obj));
                }

                public final boolean invoke(HeapObject heapObject) {
                    HeapValue value;
                    Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
                    if ((heapObject instanceof HeapObject.HeapInstance) && ((HeapObject.HeapInstance) heapObject).instanceOf("android.view.ViewRootImpl")) {
                        HeapField heapField = ((HeapObject.HeapInstance) heapObject).get("android.view.ViewRootImpl", "mView");
                        if (heapField == null) {
                            Intrinsics.throwNpe();
                        }
                        if (heapField.getValue().isNullReference()) {
                            return true;
                        }
                        HeapField mContextField = ((HeapObject.HeapInstance) heapObject).get("android.view.ViewRootImpl", "mContext");
                        if (mContextField != null) {
                            HeapObject.HeapInstance mContext = mContextField.getValueAsInstance();
                            if (mContext == null) {
                                Intrinsics.throwNpe();
                            }
                            HeapObject.HeapInstance activityContext = AndroidObjectInspectorsKt.unwrapActivityContext(mContext);
                            if (activityContext != null) {
                                HeapField heapField2 = activityContext.get("android.app.Activity", "mDestroyed");
                                return Intrinsics.areEqual((heapField2 == null || (value = heapField2.getValue()) == null) ? null : value.getAsBoolean(), true);
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
            };

            @Override // shark.AndroidObjectInspectors
            public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark_android() {
                return this.leakingObjectFilter;
            }

            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("android.view.ViewRootImpl", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$VIEW_ROOT_IMPL$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        String describedWithValue;
                        HeapValue value;
                        String mTitle;
                        String details;
                        String describedWithValue2;
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        HeapField mViewField = instance.get("android.view.ViewRootImpl", "mView");
                        if (mViewField == null) {
                            Intrinsics.throwNpe();
                        }
                        if (mViewField.getValue().isNullReference()) {
                            describedWithValue2 = AndroidObjectInspectorsKt.describedWithValue(mViewField, "null");
                            $this$whenInstanceOf.getLeakingReasons().add(describedWithValue2);
                        } else {
                            HeapField mContextField = instance.get("android.view.ViewRootImpl", "mContext");
                            if (mContextField != null) {
                                HeapObject.HeapInstance mContext = mContextField.getValueAsInstance();
                                if (mContext == null) {
                                    Intrinsics.throwNpe();
                                }
                                HeapObject.HeapInstance activityContext = AndroidObjectInspectorsKt.unwrapActivityContext(mContext);
                                if (activityContext != null) {
                                    HeapField heapField = activityContext.get("android.app.Activity", "mDestroyed");
                                    if (Intrinsics.areEqual((heapField == null || (value = heapField.getValue()) == null) ? null : value.getAsBoolean(), true)) {
                                        $this$whenInstanceOf.getLeakingReasons().add("ViewRootImpl.mContext references a destroyed activity, did you forget to cancel toasts or dismiss dialogs?");
                                    }
                                }
                            }
                            describedWithValue = AndroidObjectInspectorsKt.describedWithValue(mViewField, "not null");
                            $this$whenInstanceOf.getLabels().add(describedWithValue);
                        }
                        HeapField heapField2 = instance.get("android.view.ViewRootImpl", "mWindowAttributes");
                        if (heapField2 == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject.HeapInstance mWindowAttributes = heapField2.getValueAsInstance();
                        if (mWindowAttributes == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapField mTitleField = mWindowAttributes.get("android.view.WindowManager$LayoutParams", "mTitle");
                        if (mTitleField == null) {
                            Intrinsics.throwNpe();
                        }
                        LinkedHashSet<String> labels = $this$whenInstanceOf.getLabels();
                        if (mTitleField.getValue().isNonNullReference()) {
                            HeapObject.HeapInstance valueAsInstance = mTitleField.getValueAsInstance();
                            if (valueAsInstance == null) {
                                Intrinsics.throwNpe();
                            }
                            String mTitle2 = valueAsInstance.readAsJavaString();
                            if (mTitle2 == null) {
                                Intrinsics.throwNpe();
                            }
                            mTitle = "mWindowAttributes.mTitle = \"" + mTitle2 + '\"';
                        } else {
                            mTitle = "mWindowAttributes.mTitle is null";
                        }
                        labels.add(mTitle);
                        HeapField heapField3 = mWindowAttributes.get("android.view.WindowManager$LayoutParams", "type");
                        if (heapField3 == null) {
                            Intrinsics.throwNpe();
                        }
                        Integer asInt = heapField3.getValue().getAsInt();
                        if (asInt == null) {
                            Intrinsics.throwNpe();
                        }
                        int type = asInt.intValue();
                        if (type == 2005) {
                            details = " (Toast)";
                        } else {
                            details = "";
                        }
                        $this$whenInstanceOf.getLabels().add("mWindowAttributes.type = " + type + details);
                    }
                });
            }
        };
        VIEW_ROOT_IMPL = androidObjectInspectors21;
        AndroidObjectInspectors androidObjectInspectors22 = new AndroidObjectInspectors("WINDOW", 22) { // from class: shark.AndroidObjectInspectors.WINDOW
            private final Function1<HeapObject, Boolean> leakingObjectFilter = new Function1<HeapObject, Boolean>() { // from class: shark.AndroidObjectInspectors$WINDOW$leakingObjectFilter$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((HeapObject) obj));
                }

                public final boolean invoke(HeapObject heapObject) {
                    Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
                    if ((heapObject instanceof HeapObject.HeapInstance) && ((HeapObject.HeapInstance) heapObject).instanceOf("android.view.Window")) {
                        HeapField heapField = ((HeapObject.HeapInstance) heapObject).get("android.view.Window", "mDestroyed");
                        if (heapField == null) {
                            Intrinsics.throwNpe();
                        }
                        Boolean asBoolean = heapField.getValue().getAsBoolean();
                        if (asBoolean == null) {
                            Intrinsics.throwNpe();
                        }
                        if (asBoolean.booleanValue()) {
                            return true;
                        }
                    }
                    return false;
                }
            };

            @Override // shark.AndroidObjectInspectors
            public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark_android() {
                return this.leakingObjectFilter;
            }

            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("android.view.Window", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$WINDOW$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        String describedWithValue;
                        String describedWithValue2;
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        HeapField mDestroyed = instance.get("android.view.Window", "mDestroyed");
                        if (mDestroyed == null) {
                            Intrinsics.throwNpe();
                        }
                        Boolean asBoolean = mDestroyed.getValue().getAsBoolean();
                        if (asBoolean == null) {
                            Intrinsics.throwNpe();
                        }
                        if (asBoolean.booleanValue()) {
                            describedWithValue2 = AndroidObjectInspectorsKt.describedWithValue(mDestroyed, "true");
                            $this$whenInstanceOf.getLeakingReasons().add(describedWithValue2);
                            return;
                        }
                        describedWithValue = AndroidObjectInspectorsKt.describedWithValue(mDestroyed, "false");
                        $this$whenInstanceOf.getLabels().add(describedWithValue);
                    }
                });
            }
        };
        WINDOW = androidObjectInspectors22;
        AndroidObjectInspectors androidObjectInspectors23 = new AndroidObjectInspectors("MESSAGE", 23) { // from class: shark.AndroidObjectInspectors.MESSAGE
            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("android.os.Message", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$MESSAGE$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        String str;
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        LinkedHashSet<String> labels = $this$whenInstanceOf.getLabels();
                        StringBuilder append = new StringBuilder().append("Message.what = ");
                        HeapField heapField = instance.get("android.os.Message", "what");
                        if (heapField == null) {
                            Intrinsics.throwNpe();
                        }
                        labels.add(append.append(heapField.getValue().getAsInt()).toString());
                        Long heapDumpUptimeMillis = KeyedWeakReferenceFinder.INSTANCE.heapDumpUptimeMillis(instance.getGraph());
                        HeapField heapField2 = instance.get("android.os.Message", "when");
                        if (heapField2 == null) {
                            Intrinsics.throwNpe();
                        }
                        Long asLong = heapField2.getValue().getAsLong();
                        if (asLong == null) {
                            Intrinsics.throwNpe();
                        }
                        long whenUptimeMillis = asLong.longValue();
                        LinkedHashSet<String> labels2 = $this$whenInstanceOf.getLabels();
                        if (heapDumpUptimeMillis != null) {
                            long diffMs = whenUptimeMillis - heapDumpUptimeMillis.longValue();
                            if (diffMs > 0) {
                                str = "Message.when = " + whenUptimeMillis + " (" + diffMs + " ms after heap dump)";
                            } else {
                                str = "Message.when = " + whenUptimeMillis + " (" + Math.abs(diffMs) + " ms before heap dump)";
                            }
                        } else {
                            str = "Message.when = " + whenUptimeMillis;
                        }
                        labels2.add(str);
                        LinkedHashSet<String> labels3 = $this$whenInstanceOf.getLabels();
                        StringBuilder append2 = new StringBuilder().append("Message.obj = ");
                        HeapField heapField3 = instance.get("android.os.Message", "obj");
                        if (heapField3 == null) {
                            Intrinsics.throwNpe();
                        }
                        labels3.add(append2.append(heapField3.getValue().getAsObject()).toString());
                        LinkedHashSet<String> labels4 = $this$whenInstanceOf.getLabels();
                        StringBuilder append3 = new StringBuilder().append("Message.callback = ");
                        HeapField heapField4 = instance.get("android.os.Message", AuthResultCbHelper.ARGS_CALLBACK);
                        if (heapField4 == null) {
                            Intrinsics.throwNpe();
                        }
                        labels4.add(append3.append(heapField4.getValue().getAsObject()).toString());
                        LinkedHashSet<String> labels5 = $this$whenInstanceOf.getLabels();
                        StringBuilder append4 = new StringBuilder().append("Message.target = ");
                        HeapField heapField5 = instance.get("android.os.Message", "target");
                        if (heapField5 == null) {
                            Intrinsics.throwNpe();
                        }
                        labels5.add(append4.append(heapField5.getValue().getAsObject()).toString());
                    }
                });
            }
        };
        MESSAGE = androidObjectInspectors23;
        AndroidObjectInspectors androidObjectInspectors24 = new AndroidObjectInspectors("TOAST", 24) { // from class: shark.AndroidObjectInspectors.TOAST
            private final Function1<HeapObject, Boolean> leakingObjectFilter = new Function1<HeapObject, Boolean>() { // from class: shark.AndroidObjectInspectors$TOAST$leakingObjectFilter$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((HeapObject) obj));
                }

                public final boolean invoke(HeapObject heapObject) {
                    Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
                    if ((heapObject instanceof HeapObject.HeapInstance) && ((HeapObject.HeapInstance) heapObject).instanceOf("android.widget.Toast")) {
                        HeapField heapField = ((HeapObject.HeapInstance) heapObject).get("android.widget.Toast", "mTN");
                        if (heapField == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject asObject = heapField.getValue().getAsObject();
                        if (asObject == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject.HeapInstance tnInstance = asObject.getAsInstance();
                        if (tnInstance == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapField heapField2 = tnInstance.get("android.widget.Toast$TN", "mWM");
                        if (heapField2 == null) {
                            Intrinsics.throwNpe();
                        }
                        if (heapField2.getValue().isNonNullReference()) {
                            HeapField heapField3 = tnInstance.get("android.widget.Toast$TN", "mView");
                            if (heapField3 == null) {
                                Intrinsics.throwNpe();
                            }
                            return heapField3.getValue().isNullReference();
                        }
                        return false;
                    }
                    return false;
                }
            };

            @Override // shark.AndroidObjectInspectors
            public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark_android() {
                return this.leakingObjectFilter;
            }

            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("android.widget.Toast", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$TOAST$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        HeapField heapField = instance.get("android.widget.Toast", "mTN");
                        if (heapField == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject asObject = heapField.getValue().getAsObject();
                        if (asObject == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject.HeapInstance tnInstance = asObject.getAsInstance();
                        if (tnInstance == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapField heapField2 = tnInstance.get("android.widget.Toast$TN", "mWM");
                        if (heapField2 == null) {
                            Intrinsics.throwNpe();
                        }
                        if (heapField2.getValue().isNonNullReference()) {
                            HeapField heapField3 = tnInstance.get("android.widget.Toast$TN", "mView");
                            if (heapField3 == null) {
                                Intrinsics.throwNpe();
                            }
                            if (heapField3.getValue().isNullReference()) {
                                $this$whenInstanceOf.getLeakingReasons().add("This toast is done showing (Toast.mTN.mWM != null && Toast.mTN.mView == null)");
                            } else {
                                $this$whenInstanceOf.getNotLeakingReasons().add("This toast is showing (Toast.mTN.mWM != null && Toast.mTN.mView != null)");
                            }
                        }
                    }
                });
            }
        };
        TOAST = androidObjectInspectors24;
        AndroidObjectInspectors androidObjectInspectors25 = new AndroidObjectInspectors("RECOMPOSER", 25) { // from class: shark.AndroidObjectInspectors.RECOMPOSER
            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("androidx.compose.runtime.Recomposer", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$RECOMPOSER$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        HeapField heapField = instance.get("androidx.compose.runtime.Recomposer", "_state");
                        if (heapField == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject.HeapInstance stateFlow = heapField.getValueAsInstance();
                        if (stateFlow == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapField heapField2 = stateFlow.get("kotlinx.coroutines.flow.StateFlowImpl", "_state");
                        HeapObject.HeapInstance state = heapField2 != null ? heapField2.getValueAsInstance() : null;
                        if (state != null) {
                            HeapField heapField3 = state.get("java.lang.Enum", ChannelRoutes.CHANNEL_NAME);
                            if (heapField3 == null) {
                                Intrinsics.throwNpe();
                            }
                            HeapObject.HeapInstance valueAsInstance = heapField3.getValueAsInstance();
                            if (valueAsInstance == null) {
                                Intrinsics.throwNpe();
                            }
                            String stateName = valueAsInstance.readAsJavaString();
                            if (stateName == null) {
                                Intrinsics.throwNpe();
                            }
                            String label = "Recomposer is in state " + stateName;
                            switch (stateName.hashCode()) {
                                case -1513699032:
                                    if (!stateName.equals("PendingWork")) {
                                        return;
                                    }
                                    $this$whenInstanceOf.getNotLeakingReasons().add(label);
                                    return;
                                case -491727939:
                                    if (!stateName.equals("InactivePendingWork")) {
                                        return;
                                    }
                                    $this$whenInstanceOf.getLabels().add(label);
                                    return;
                                case -105652586:
                                    if (!stateName.equals("ShutDown")) {
                                        return;
                                    }
                                    $this$whenInstanceOf.getLeakingReasons().add(label);
                                    return;
                                case 2274292:
                                    if (!stateName.equals("Idle")) {
                                        return;
                                    }
                                    $this$whenInstanceOf.getNotLeakingReasons().add(label);
                                    return;
                                case 89309323:
                                    if (!stateName.equals("Inactive")) {
                                        return;
                                    }
                                    $this$whenInstanceOf.getLabels().add(label);
                                    return;
                                case 1443627140:
                                    if (!stateName.equals("ShuttingDown")) {
                                        return;
                                    }
                                    $this$whenInstanceOf.getLeakingReasons().add(label);
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                });
            }
        };
        RECOMPOSER = androidObjectInspectors25;
        AndroidObjectInspectors androidObjectInspectors26 = new AndroidObjectInspectors("COMPOSITION_IMPL", 26) { // from class: shark.AndroidObjectInspectors.COMPOSITION_IMPL
            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("androidx.compose.runtime.CompositionImpl", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$COMPOSITION_IMPL$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        HeapField heapField = instance.get("androidx.compose.runtime.CompositionImpl", "disposed");
                        if (heapField == null) {
                            Intrinsics.throwNpe();
                        }
                        Boolean asBoolean = heapField.getValue().getAsBoolean();
                        if (asBoolean == null) {
                            Intrinsics.throwNpe();
                        }
                        if (asBoolean.booleanValue()) {
                            $this$whenInstanceOf.getLeakingReasons().add("Composition disposed");
                        } else {
                            $this$whenInstanceOf.getNotLeakingReasons().add("Composition not disposed");
                        }
                    }
                });
            }
        };
        COMPOSITION_IMPL = androidObjectInspectors26;
        AndroidObjectInspectors androidObjectInspectors27 = new AndroidObjectInspectors("ANIMATOR", 27) { // from class: shark.AndroidObjectInspectors.ANIMATOR
            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("android.animation.Animator", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$ANIMATOR$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        HeapField heapField = instance.get("android.animation.Animator", "mListeners");
                        if (heapField == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject.HeapInstance mListeners = heapField.getValueAsInstance();
                        if (mListeners != null) {
                            Iterable listenerValues = SequencesKt.toList(InternalSharkCollectionsHelper.INSTANCE.arrayListValues(mListeners));
                            if (!((Collection) listenerValues).isEmpty()) {
                                Iterable $this$forEach$iv = listenerValues;
                                for (Object element$iv : $this$forEach$iv) {
                                    String value = (String) element$iv;
                                    $this$whenInstanceOf.getLabels().add("mListeners" + value);
                                }
                                return;
                            }
                            $this$whenInstanceOf.getLabels().add("mListeners is empty");
                            return;
                        }
                        $this$whenInstanceOf.getLabels().add("mListeners = null");
                    }
                });
            }
        };
        ANIMATOR = androidObjectInspectors27;
        AndroidObjectInspectors androidObjectInspectors28 = new AndroidObjectInspectors("OBJECT_ANIMATOR", 28) { // from class: shark.AndroidObjectInspectors.OBJECT_ANIMATOR
            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("android.animation.ObjectAnimator", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$OBJECT_ANIMATOR$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        String name;
                        String repeatModeConstant;
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        LinkedHashSet<String> labels = $this$whenInstanceOf.getLabels();
                        StringBuilder append = new StringBuilder().append("mPropertyName = ");
                        HeapField heapField = instance.get("android.animation.ObjectAnimator", "mPropertyName");
                        if (heapField == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject.HeapInstance valueAsInstance = heapField.getValueAsInstance();
                        String str = "null";
                        labels.add(append.append((valueAsInstance == null || (r2 = valueAsInstance.readAsJavaString()) == null) ? "null" : "null").toString());
                        HeapField heapField2 = instance.get("android.animation.ObjectAnimator", "mProperty");
                        if (heapField2 == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject.HeapInstance mProperty = heapField2.getValueAsInstance();
                        if (mProperty == null) {
                            $this$whenInstanceOf.getLabels().add("mProperty = null");
                        } else {
                            LinkedHashSet<String> labels2 = $this$whenInstanceOf.getLabels();
                            StringBuilder append2 = new StringBuilder().append("mProperty.mName = ");
                            HeapField heapField3 = mProperty.get("android.util.Property", "mName");
                            if (heapField3 == null) {
                                Intrinsics.throwNpe();
                            }
                            HeapObject.HeapInstance valueAsInstance2 = heapField3.getValueAsInstance();
                            labels2.add(append2.append((valueAsInstance2 == null || (r3 = valueAsInstance2.readAsJavaString()) == null) ? "null" : "null").toString());
                            LinkedHashSet<String> labels3 = $this$whenInstanceOf.getLabels();
                            StringBuilder append3 = new StringBuilder().append("mProperty.mType = ");
                            HeapField heapField4 = mProperty.get("android.util.Property", "mType");
                            if (heapField4 == null) {
                                Intrinsics.throwNpe();
                            }
                            HeapObject.HeapClass valueAsClass = heapField4.getValueAsClass();
                            if (valueAsClass != null && (name = valueAsClass.getName()) != null) {
                                str = name;
                            }
                            labels3.add(append3.append(str).toString());
                        }
                        LinkedHashSet<String> labels4 = $this$whenInstanceOf.getLabels();
                        StringBuilder append4 = new StringBuilder().append("mInitialized = ");
                        HeapField heapField5 = instance.get("android.animation.ValueAnimator", "mInitialized");
                        if (heapField5 == null) {
                            Intrinsics.throwNpe();
                        }
                        Boolean asBoolean = heapField5.getValue().getAsBoolean();
                        if (asBoolean == null) {
                            Intrinsics.throwNpe();
                        }
                        labels4.add(append4.append(asBoolean.booleanValue()).toString());
                        LinkedHashSet<String> labels5 = $this$whenInstanceOf.getLabels();
                        StringBuilder append5 = new StringBuilder().append("mStarted = ");
                        HeapField heapField6 = instance.get("android.animation.ValueAnimator", "mStarted");
                        if (heapField6 == null) {
                            Intrinsics.throwNpe();
                        }
                        Boolean asBoolean2 = heapField6.getValue().getAsBoolean();
                        if (asBoolean2 == null) {
                            Intrinsics.throwNpe();
                        }
                        labels5.add(append5.append(asBoolean2.booleanValue()).toString());
                        LinkedHashSet<String> labels6 = $this$whenInstanceOf.getLabels();
                        StringBuilder append6 = new StringBuilder().append("mRunning = ");
                        HeapField heapField7 = instance.get("android.animation.ValueAnimator", "mRunning");
                        if (heapField7 == null) {
                            Intrinsics.throwNpe();
                        }
                        Boolean asBoolean3 = heapField7.getValue().getAsBoolean();
                        if (asBoolean3 == null) {
                            Intrinsics.throwNpe();
                        }
                        labels6.add(append6.append(asBoolean3.booleanValue()).toString());
                        LinkedHashSet<String> labels7 = $this$whenInstanceOf.getLabels();
                        StringBuilder append7 = new StringBuilder().append("mAnimationEndRequested = ");
                        HeapField heapField8 = instance.get("android.animation.ValueAnimator", "mAnimationEndRequested");
                        if (heapField8 == null) {
                            Intrinsics.throwNpe();
                        }
                        Boolean asBoolean4 = heapField8.getValue().getAsBoolean();
                        if (asBoolean4 == null) {
                            Intrinsics.throwNpe();
                        }
                        labels7.add(append7.append(asBoolean4.booleanValue()).toString());
                        LinkedHashSet<String> labels8 = $this$whenInstanceOf.getLabels();
                        StringBuilder append8 = new StringBuilder().append("mDuration = ");
                        HeapField heapField9 = instance.get("android.animation.ValueAnimator", "mDuration");
                        if (heapField9 == null) {
                            Intrinsics.throwNpe();
                        }
                        Long asLong = heapField9.getValue().getAsLong();
                        if (asLong == null) {
                            Intrinsics.throwNpe();
                        }
                        labels8.add(append8.append(asLong.longValue()).toString());
                        LinkedHashSet<String> labels9 = $this$whenInstanceOf.getLabels();
                        StringBuilder append9 = new StringBuilder().append("mStartDelay = ");
                        HeapField heapField10 = instance.get("android.animation.ValueAnimator", "mStartDelay");
                        if (heapField10 == null) {
                            Intrinsics.throwNpe();
                        }
                        Long asLong2 = heapField10.getValue().getAsLong();
                        if (asLong2 == null) {
                            Intrinsics.throwNpe();
                        }
                        labels9.add(append9.append(asLong2.longValue()).toString());
                        HeapField heapField11 = instance.get("android.animation.ValueAnimator", "mRepeatCount");
                        if (heapField11 == null) {
                            Intrinsics.throwNpe();
                        }
                        Integer asInt = heapField11.getValue().getAsInt();
                        if (asInt == null) {
                            Intrinsics.throwNpe();
                        }
                        int repeatCount = asInt.intValue();
                        $this$whenInstanceOf.getLabels().add("mRepeatCount = " + (repeatCount == -1 ? "INFINITE (-1)" : Integer.valueOf(repeatCount)));
                        HeapField heapField12 = instance.get("android.animation.ValueAnimator", "mRepeatMode");
                        if (heapField12 == null) {
                            Intrinsics.throwNpe();
                        }
                        Integer asInt2 = heapField12.getValue().getAsInt();
                        if (asInt2 == null) {
                            Intrinsics.throwNpe();
                        }
                        int repeatMode = asInt2.intValue();
                        switch (repeatMode) {
                            case 1:
                                repeatModeConstant = "RESTART (1)";
                                break;
                            case 2:
                                repeatModeConstant = "REVERSE (2)";
                                break;
                            default:
                                repeatModeConstant = "Unknown (" + repeatMode + ')';
                                break;
                        }
                        $this$whenInstanceOf.getLabels().add("mRepeatMode = " + repeatModeConstant);
                    }
                });
            }
        };
        OBJECT_ANIMATOR = androidObjectInspectors28;
        AndroidObjectInspectors androidObjectInspectors29 = new AndroidObjectInspectors("LIFECYCLE_REGISTRY", 29) { // from class: shark.AndroidObjectInspectors.LIFECYCLE_REGISTRY
            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("androidx.lifecycle.LifecycleRegistry", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$LIFECYCLE_REGISTRY$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        String state;
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        state = AndroidObjectInspectorsKt.getLifecycleRegistryState(instance);
                        if (!Intrinsics.areEqual(state, "DESTROYED")) {
                            $this$whenInstanceOf.getNotLeakingReasons().add("state is " + state);
                        } else {
                            $this$whenInstanceOf.getLabels().add("state = " + state);
                        }
                    }
                });
            }
        };
        LIFECYCLE_REGISTRY = androidObjectInspectors29;
        AndroidObjectInspectors androidObjectInspectors30 = new AndroidObjectInspectors("STUB", 30) { // from class: shark.AndroidObjectInspectors.STUB
            @Override // shark.ObjectInspector
            public void inspect(ObjectReporter reporter) {
                Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                reporter.whenInstanceOf("android.os.Binder", new Function2<ObjectReporter, HeapObject.HeapInstance, Unit>() { // from class: shark.AndroidObjectInspectors$STUB$inspect$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
                        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus($this$whenInstanceOf.getLabels(), instance.getInstanceClassSimpleName() + " is a binder stub. Binder stubs will often be"), " retained long after the associated activity or service is destroyed, as by design stubs"), " are retained until the other side gets GCed. If " + instance.getInstanceClassSimpleName() + " is"), " not a *static* inner class then that's most likely the root cause of this leak. Make"), " it static. If " + instance.getInstanceClassSimpleName() + " is an Android Framework class, file"), " a ticket here: https://issuetracker.google.com/issues/new?component=192705");
                    }
                });
            }
        };
        STUB = androidObjectInspectors30;
        $VALUES = new AndroidObjectInspectors[]{androidObjectInspectors, androidObjectInspectors2, androidObjectInspectors3, androidObjectInspectors4, androidObjectInspectors5, androidObjectInspectors6, androidObjectInspectors7, androidObjectInspectors8, androidObjectInspectors9, androidObjectInspectors10, androidObjectInspectors11, androidObjectInspectors12, androidObjectInspectors13, support_fragment, androidObjectInspectors14, androidObjectInspectors15, androidObjectInspectors16, androidObjectInspectors17, androidObjectInspectors18, androidObjectInspectors19, androidObjectInspectors20, androidObjectInspectors21, androidObjectInspectors22, androidObjectInspectors23, androidObjectInspectors24, androidObjectInspectors25, androidObjectInspectors26, androidObjectInspectors27, androidObjectInspectors28, androidObjectInspectors29, androidObjectInspectors30};
        Companion = new Companion(null);
        Companion companion = Companion;
        EnumSet allOf = EnumSet.allOf(AndroidObjectInspectors.class);
        Intrinsics.checkExpressionValueIsNotNull(allOf, "EnumSet.allOf(AndroidObjectInspectors::class.java)");
        appLeakingObjectFilters = CollectionsKt.plus(ObjectInspectors.Companion.getJdkLeakingObjectFilters(), companion.createLeakingObjectFilters(allOf));
    }

    public final String getANDROID_SUPPORT_FRAGMENT_CLASS_NAME$shark_android() {
        return this.ANDROID_SUPPORT_FRAGMENT_CLASS_NAME;
    }
}