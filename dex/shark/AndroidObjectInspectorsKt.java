package shark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.HeapObject;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: AndroidObjectInspectors.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001e\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002\u001a\u0015\u0010\f\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0001H\u0082\u0004\u001a\u001c\u0010\u000e\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0000\u001a&\u0010\u0011\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u0001H\u0002\u001a\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0002H\u0002\u001a\u000e\u0010\u0017\u001a\u0004\u0018\u00010\u0002*\u00020\u0002H\u0000\u001a\u000e\u0010\u0018\u001a\u0004\u0018\u00010\u0002*\u00020\u0002H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0019"}, d2 = {"lifecycleRegistryState", "", "Lshark/HeapObject$HeapInstance;", "getLifecycleRegistryState", "(Lshark/HeapObject$HeapInstance;)Ljava/lang/String;", "applyFromField", "", "Lshark/ObjectReporter;", "inspector", "Lshark/ObjectInspector;", "field", "Lshark/HeapField;", "describedWithValue", "valueDescription", "getOrThrow", "declaringClassName", "fieldName", "inspectContextImplOuterContext", "outerContext", "contextImpl", "prefix", "outerContextIsLeaking", "", "unwrapActivityContext", "unwrapComponentContext", "shark-android"}, k = 2, mv = {1, 4, 1})
public final class AndroidObjectInspectorsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean outerContextIsLeaking(HeapObject.HeapInstance $this$outerContextIsLeaking) {
        HeapValue value;
        HeapField heapField = $this$outerContextIsLeaking.get("android.app.ContextImpl", "mOuterContext");
        if (heapField == null) {
            Intrinsics.throwNpe();
        }
        HeapObject.HeapInstance $this$run = heapField.getValueAsInstance();
        if ($this$run == null) {
            Intrinsics.throwNpe();
        }
        if ($this$run.instanceOf("android.app.Activity")) {
            HeapField heapField2 = $this$run.get("android.app.Activity", "mDestroyed");
            if (Intrinsics.areEqual((heapField2 == null || (value = heapField2.getValue()) == null) ? null : value.getAsBoolean(), true)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void inspectContextImplOuterContext$default(ObjectReporter objectReporter, HeapObject.HeapInstance heapInstance, HeapObject.HeapInstance heapInstance2, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "ContextImpl";
        }
        inspectContextImplOuterContext(objectReporter, heapInstance, heapInstance2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void inspectContextImplOuterContext(ObjectReporter $this$inspectContextImplOuterContext, HeapObject.HeapInstance outerContext, HeapObject.HeapInstance contextImpl, String prefix) {
        HeapValue value;
        if (outerContext.instanceOf("android.app.Activity")) {
            HeapField heapField = outerContext.get("android.app.Activity", "mDestroyed");
            Boolean mDestroyed = (heapField == null || (value = heapField.getValue()) == null) ? null : value.getAsBoolean();
            if (mDestroyed != null) {
                if (mDestroyed.booleanValue()) {
                    $this$inspectContextImplOuterContext.getLeakingReasons().add(prefix + ".mOuterContext is an instance of " + outerContext.getInstanceClassName() + " with Activity.mDestroyed true");
                    return;
                } else {
                    $this$inspectContextImplOuterContext.getNotLeakingReasons().add(prefix + ".mOuterContext is an instance of " + outerContext.getInstanceClassName() + " with Activity.mDestroyed false");
                    return;
                }
            }
            $this$inspectContextImplOuterContext.getLabels().add(prefix + ".mOuterContext is an instance of " + outerContext.getInstanceClassName());
        } else if (outerContext.instanceOf("android.app.Application")) {
            $this$inspectContextImplOuterContext.getNotLeakingReasons().add(prefix + ".mOuterContext is an instance of " + outerContext.getInstanceClassName() + " which extends android.app.Application");
        } else if (outerContext.getObjectId() == contextImpl.getObjectId()) {
            $this$inspectContextImplOuterContext.getLabels().add(prefix + ".mOuterContext == ContextImpl.this: not tied to any particular lifecycle");
        } else {
            $this$inspectContextImplOuterContext.getLabels().add(prefix + ".mOuterContext is an instance of " + outerContext.getInstanceClassName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String describedWithValue(HeapField $this$describedWithValue, String valueDescription) {
        return $this$describedWithValue.getDeclaringClass().getSimpleName() + '#' + $this$describedWithValue.getName() + " is " + valueDescription;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyFromField(ObjectReporter $this$applyFromField, ObjectInspector inspector, HeapField field) {
        if (field == null || field.getValue().isNullReference()) {
            return;
        }
        HeapObject heapObject = field.getValue().getAsObject();
        if (heapObject == null) {
            Intrinsics.throwNpe();
        }
        ObjectReporter delegateReporter = new ObjectReporter(heapObject);
        inspector.inspect(delegateReporter);
        String prefix = field.getDeclaringClass().getSimpleName() + '#' + field.getName() + ':';
        LinkedHashSet<String> labels = $this$applyFromField.getLabels();
        Iterable $this$map$iv = delegateReporter.getLabels();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(prefix + ' ' + it);
        }
        CollectionsKt.addAll(labels, (List) destination$iv$iv);
        Set<String> leakingReasons = $this$applyFromField.getLeakingReasons();
        Iterable $this$map$iv2 = delegateReporter.getLeakingReasons();
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            String it2 = (String) item$iv$iv2;
            destination$iv$iv2.add(prefix + ' ' + it2);
        }
        CollectionsKt.addAll(leakingReasons, (List) destination$iv$iv2);
        Set<String> notLeakingReasons = $this$applyFromField.getNotLeakingReasons();
        Iterable $this$map$iv3 = delegateReporter.getNotLeakingReasons();
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
        for (Object item$iv$iv3 : $this$map$iv3) {
            String it3 = (String) item$iv$iv3;
            destination$iv$iv3.add(prefix + ' ' + it3);
        }
        CollectionsKt.addAll(notLeakingReasons, (List) destination$iv$iv3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getLifecycleRegistryState(HeapObject.HeapInstance $this$lifecycleRegistryState) {
        HeapField stateField = $this$lifecycleRegistryState.get("androidx.lifecycle.LifecycleRegistry", AuthResultCbHelper.ARGS_STATE);
        if (stateField == null && (stateField = $this$lifecycleRegistryState.get("androidx.lifecycle.LifecycleRegistry", "mState")) == null) {
            Intrinsics.throwNpe();
        }
        HeapObject.HeapInstance state = stateField.getValueAsInstance();
        if (state == null) {
            Intrinsics.throwNpe();
        }
        HeapField heapField = state.get("java.lang.Enum", ChannelRoutes.CHANNEL_NAME);
        if (heapField == null) {
            Intrinsics.throwNpe();
        }
        String readAsJavaString = heapField.getValue().readAsJavaString();
        if (readAsJavaString == null) {
            Intrinsics.throwNpe();
        }
        return readAsJavaString;
    }

    public static final HeapObject.HeapInstance unwrapActivityContext(HeapObject.HeapInstance $this$unwrapActivityContext) {
        Intrinsics.checkParameterIsNotNull($this$unwrapActivityContext, "$this$unwrapActivityContext");
        HeapObject.HeapInstance context = unwrapComponentContext($this$unwrapActivityContext);
        if (context != null && context.instanceOf("android.app.Activity")) {
            return context;
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x005a, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x00fc, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0047, code lost:
        if (r12.equals("android.app.Service") != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004e, code lost:
        if (r12.equals("android.app.Application") != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
        if (r12.equals("android.app.Activity") != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e2, code lost:
        if (r5.equals("android.content.ContextWrapper") != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e9, code lost:
        if (r5.equals("android.app.Service") != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f0, code lost:
        if (r5.equals("android.app.Application") != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f7, code lost:
        if (r5.equals("android.app.Activity") != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f9, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0040, code lost:
        if (r12.equals("android.content.ContextWrapper") != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final HeapObject.HeapInstance unwrapComponentContext(HeapObject.HeapInstance $this$unwrapComponentContext) {
        Object element$iv;
        Object element$iv2;
        HeapField mPhoneWindowField;
        boolean z;
        boolean z2;
        Intrinsics.checkParameterIsNotNull($this$unwrapComponentContext, "$this$unwrapComponentContext");
        Sequence $this$firstOrNull$iv = SequencesKt.map($this$unwrapComponentContext.getInstanceClass().getClassHierarchy(), new Function1<HeapObject.HeapClass, String>() { // from class: shark.AndroidObjectInspectorsKt$unwrapComponentContext$matchingClassName$1
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
                        z2 = false;
                        continue;
                }
                if (z2) {
                }
            } else {
                element$iv = null;
            }
        }
        String matchingClassName = (String) element$iv;
        if (matchingClassName == null) {
            return null;
        }
        if (Intrinsics.areEqual(matchingClassName, "android.content.ContextWrapper")) {
            HeapObject.HeapInstance context = $this$unwrapComponentContext;
            List visitedInstances = new ArrayList();
            boolean keepUnwrapping = true;
            while (keepUnwrapping) {
                visitedInstances.add(Long.valueOf(context.getObjectId()));
                keepUnwrapping = false;
                HeapField heapField = context.get("android.content.ContextWrapper", "mBase");
                if (heapField == null) {
                    Intrinsics.throwNpe();
                }
                HeapValue mBase = heapField.getValue();
                if (mBase.isNonNullReference()) {
                    HeapObject.HeapInstance wrapperContext = context;
                    HeapObject asObject = mBase.getAsObject();
                    if (asObject == null) {
                        Intrinsics.throwNpe();
                    }
                    HeapObject.HeapInstance asInstance = asObject.getAsInstance();
                    if (asInstance == null) {
                        Intrinsics.throwNpe();
                    }
                    context = asInstance;
                    Sequence $this$firstOrNull$iv2 = SequencesKt.map(context.getInstanceClass().getClassHierarchy(), new Function1<HeapObject.HeapClass, String>() { // from class: shark.AndroidObjectInspectorsKt$unwrapComponentContext$contextMatchingClassName$1
                        public final String invoke(HeapObject.HeapClass it3) {
                            Intrinsics.checkParameterIsNotNull(it3, "it");
                            return it3.getName();
                        }
                    });
                    Iterator it3 = $this$firstOrNull$iv2.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            element$iv2 = it3.next();
                            String it4 = (String) element$iv2;
                            switch (it4.hashCode()) {
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
                            element$iv2 = null;
                        }
                    }
                    String contextMatchingClassName = (String) element$iv2;
                    boolean isContextWrapper = Intrinsics.areEqual(contextMatchingClassName, "android.content.ContextWrapper");
                    if (Intrinsics.areEqual(contextMatchingClassName, "android.app.Activity")) {
                        return context;
                    }
                    if (wrapperContext.instanceOf("com.android.internal.policy.DecorContext") && (mPhoneWindowField = wrapperContext.get("com.android.internal.policy.DecorContext", "mPhoneWindow")) != null) {
                        HeapObject.HeapInstance phoneWindow = mPhoneWindowField.getValueAsInstance();
                        if (phoneWindow == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapField heapField2 = phoneWindow.get("android.view.Window", "mContext");
                        if (heapField2 == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapObject.HeapInstance valueAsInstance = heapField2.getValueAsInstance();
                        if (valueAsInstance == null) {
                            Intrinsics.throwNpe();
                        }
                        context = valueAsInstance;
                        if (context.instanceOf("android.app.Activity")) {
                            return context;
                        }
                        isContextWrapper = context.instanceOf("android.content.ContextWrapper");
                    }
                    if (Intrinsics.areEqual(contextMatchingClassName, "android.app.Service") || Intrinsics.areEqual(contextMatchingClassName, "android.app.Application")) {
                        return context;
                    }
                    if (isContextWrapper && !visitedInstances.contains(Long.valueOf(context.getObjectId()))) {
                        keepUnwrapping = true;
                    }
                }
            }
            return null;
        }
        return $this$unwrapComponentContext;
    }

    public static final HeapField getOrThrow(HeapObject.HeapInstance $this$getOrThrow, String declaringClassName, String fieldName) {
        Intrinsics.checkParameterIsNotNull($this$getOrThrow, "$this$getOrThrow");
        Intrinsics.checkParameterIsNotNull(declaringClassName, "declaringClassName");
        Intrinsics.checkParameterIsNotNull(fieldName, "fieldName");
        HeapField heapField = $this$getOrThrow.get(declaringClassName, fieldName);
        if (heapField != null) {
            return heapField;
        }
        throw new IllegalStateException('\n' + $this$getOrThrow.getInstanceClassName() + " is expected to have a " + declaringClassName + '.' + fieldName + " field which cannot be found.\nThis might be due to the app code being obfuscated. If that's the case, then the heap analysis\nis unable to proceed without a mapping file to deobfuscate class names.\nYou can run LeakCanary on obfuscated builds by following the instructions at\nhttps://square.github.io/leakcanary/recipes/#using-leakcanary-with-obfuscated-apps\n      ");
    }
}