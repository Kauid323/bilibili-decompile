package leakcanary;

import android.content.Intent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.ConstantsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.HeapDumpControl;
import leakcanary.internal.InternalLeakCanary;
import leakcanary.internal.activity.LeakActivity;
import shark.AndroidMetadataExtractor;
import shark.AndroidObjectInspectors;
import shark.AndroidReferenceMatchers;
import shark.KeyedWeakReferenceFinder;
import shark.LeakingObjectFinder;
import shark.MetadataExtractor;
import shark.ObjectInspector;
import shark.ReferenceMatcher;
import shark.SharkLog;

/* compiled from: LeakCanary.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013R,\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048\u0006@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lleakcanary/LeakCanary;", "", "()V", "newConfig", "Lleakcanary/LeakCanary$Config;", "config", "getConfig$annotations", "getConfig", "()Lleakcanary/LeakCanary$Config;", "setConfig", "(Lleakcanary/LeakCanary$Config;)V", "dumpHeap", "", "logConfigChange", "previousConfig", "newLeakDisplayActivityIntent", "Landroid/content/Intent;", "showLeakDisplayActivityLauncherIcon", "showLauncherIcon", "", "Config", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class LeakCanary {
    public static final LeakCanary INSTANCE = new LeakCanary();
    private static volatile Config config = new Config(false, false, 0, null, null, null, null, false, 0, false, null, null, null, false, false, 32767, null);

    @JvmStatic
    public static /* synthetic */ void getConfig$annotations() {
    }

    private LeakCanary() {
    }

    /* compiled from: LeakCanary.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001LB\u00ad\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003¢\u0006\u0002\u0010\u001bJ\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0014HÆ\u0003J\t\u00108\u001a\u00020\u0016HÆ\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00180\bHÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0006HÆ\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000b0\bHÆ\u0003J\t\u0010@\u001a\u00020\rHÆ\u0003J\t\u0010A\u001a\u00020\u000fHÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0006HÆ\u0003J±\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\b2\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u0003HÆ\u0001J\u0013\u0010E\u001a\u00020\u00032\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020\u0006HÖ\u0001J\b\u0010H\u001a\u00020IH\u0007J\t\u0010J\u001a\u00020KHÖ\u0001R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u001c\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b1\u0010'R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001dR\u001c\u0010\u001a\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010,\u001a\u0004\b4\u0010\u001d¨\u0006M"}, d2 = {"Lleakcanary/LeakCanary$Config;", "", "dumpHeap", "", "dumpHeapWhenDebugging", "retainedVisibleThreshold", "", "referenceMatchers", "", "Lshark/ReferenceMatcher;", "objectInspectors", "Lshark/ObjectInspector;", "onHeapAnalyzedListener", "Lleakcanary/OnHeapAnalyzedListener;", "metadataExtractor", "Lshark/MetadataExtractor;", "computeRetainedHeapSize", "maxStoredHeapDumps", "requestWriteExternalStoragePermission", "leakingObjectFinder", "Lshark/LeakingObjectFinder;", "heapDumper", "Lleakcanary/HeapDumper;", "eventListeners", "Lleakcanary/EventListener;", "showNotifications", "useExperimentalLeakFinders", "(ZZILjava/util/List;Ljava/util/List;Lleakcanary/OnHeapAnalyzedListener;Lshark/MetadataExtractor;ZIZLshark/LeakingObjectFinder;Lleakcanary/HeapDumper;Ljava/util/List;ZZ)V", "getComputeRetainedHeapSize", "()Z", "getDumpHeap", "getDumpHeapWhenDebugging", "getEventListeners", "()Ljava/util/List;", "getHeapDumper", "()Lleakcanary/HeapDumper;", "getLeakingObjectFinder", "()Lshark/LeakingObjectFinder;", "getMaxStoredHeapDumps", "()I", "getMetadataExtractor", "()Lshark/MetadataExtractor;", "getObjectInspectors", "getOnHeapAnalyzedListener$annotations", "()V", "getOnHeapAnalyzedListener", "()Lleakcanary/OnHeapAnalyzedListener;", "getReferenceMatchers", "getRequestWriteExternalStoragePermission", "getRetainedVisibleThreshold", "getShowNotifications", "getUseExperimentalLeakFinders$annotations", "getUseExperimentalLeakFinders", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "newBuilder", "Lleakcanary/LeakCanary$Config$Builder;", "toString", "", "Builder", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Config {
        private final boolean computeRetainedHeapSize;
        private final boolean dumpHeap;
        private final boolean dumpHeapWhenDebugging;
        private final List<EventListener> eventListeners;
        private final HeapDumper heapDumper;
        private final LeakingObjectFinder leakingObjectFinder;
        private final int maxStoredHeapDumps;
        private final MetadataExtractor metadataExtractor;
        private final List<ObjectInspector> objectInspectors;
        private final OnHeapAnalyzedListener onHeapAnalyzedListener;
        private final List<ReferenceMatcher> referenceMatchers;
        private final boolean requestWriteExternalStoragePermission;
        private final int retainedVisibleThreshold;
        private final boolean showNotifications;
        private final boolean useExperimentalLeakFinders;

        public Config() {
            this(false, false, 0, null, null, null, null, false, 0, false, null, null, null, false, false, 32767, null);
        }

        @Deprecated(message = "Add to LeakCanary.config.eventListeners instead")
        public static /* synthetic */ void getOnHeapAnalyzedListener$annotations() {
        }

        @Deprecated(message = "This is a no-op, set a custom leakingObjectFinder instead")
        public static /* synthetic */ void getUseExperimentalLeakFinders$annotations() {
        }

        public final boolean component1() {
            return this.dumpHeap;
        }

        public final boolean component10() {
            return this.requestWriteExternalStoragePermission;
        }

        public final LeakingObjectFinder component11() {
            return this.leakingObjectFinder;
        }

        public final HeapDumper component12() {
            return this.heapDumper;
        }

        public final List<EventListener> component13() {
            return this.eventListeners;
        }

        public final boolean component14() {
            return this.showNotifications;
        }

        public final boolean component15() {
            return this.useExperimentalLeakFinders;
        }

        public final boolean component2() {
            return this.dumpHeapWhenDebugging;
        }

        public final int component3() {
            return this.retainedVisibleThreshold;
        }

        public final List<ReferenceMatcher> component4() {
            return this.referenceMatchers;
        }

        public final List<ObjectInspector> component5() {
            return this.objectInspectors;
        }

        public final OnHeapAnalyzedListener component6() {
            return this.onHeapAnalyzedListener;
        }

        public final MetadataExtractor component7() {
            return this.metadataExtractor;
        }

        public final boolean component8() {
            return this.computeRetainedHeapSize;
        }

        public final int component9() {
            return this.maxStoredHeapDumps;
        }

        public final Config copy(boolean z, boolean z2, int i, List<? extends ReferenceMatcher> referenceMatchers, List<? extends ObjectInspector> objectInspectors, OnHeapAnalyzedListener onHeapAnalyzedListener, MetadataExtractor metadataExtractor, boolean z3, int i2, boolean z4, LeakingObjectFinder leakingObjectFinder, HeapDumper heapDumper, List<? extends EventListener> eventListeners, boolean z5, boolean z6) {
            Intrinsics.checkParameterIsNotNull(referenceMatchers, "referenceMatchers");
            Intrinsics.checkParameterIsNotNull(objectInspectors, "objectInspectors");
            Intrinsics.checkParameterIsNotNull(onHeapAnalyzedListener, "onHeapAnalyzedListener");
            Intrinsics.checkParameterIsNotNull(metadataExtractor, "metadataExtractor");
            Intrinsics.checkParameterIsNotNull(leakingObjectFinder, "leakingObjectFinder");
            Intrinsics.checkParameterIsNotNull(heapDumper, "heapDumper");
            Intrinsics.checkParameterIsNotNull(eventListeners, "eventListeners");
            return new Config(z, z2, i, referenceMatchers, objectInspectors, onHeapAnalyzedListener, metadataExtractor, z3, i2, z4, leakingObjectFinder, heapDumper, eventListeners, z5, z6);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Config) {
                    Config config = (Config) obj;
                    return this.dumpHeap == config.dumpHeap && this.dumpHeapWhenDebugging == config.dumpHeapWhenDebugging && this.retainedVisibleThreshold == config.retainedVisibleThreshold && Intrinsics.areEqual(this.referenceMatchers, config.referenceMatchers) && Intrinsics.areEqual(this.objectInspectors, config.objectInspectors) && Intrinsics.areEqual(this.onHeapAnalyzedListener, config.onHeapAnalyzedListener) && Intrinsics.areEqual(this.metadataExtractor, config.metadataExtractor) && this.computeRetainedHeapSize == config.computeRetainedHeapSize && this.maxStoredHeapDumps == config.maxStoredHeapDumps && this.requestWriteExternalStoragePermission == config.requestWriteExternalStoragePermission && Intrinsics.areEqual(this.leakingObjectFinder, config.leakingObjectFinder) && Intrinsics.areEqual(this.heapDumper, config.heapDumper) && Intrinsics.areEqual(this.eventListeners, config.eventListeners) && this.showNotifications == config.showNotifications && this.useExperimentalLeakFinders == config.useExperimentalLeakFinders;
                }
                return false;
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v30 */
        /* JADX WARN: Type inference failed for: r0v31 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v15, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v18, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v27, types: [boolean] */
        public int hashCode() {
            boolean z = this.dumpHeap;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.dumpHeapWhenDebugging;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (((i + i2) * 31) + this.retainedVisibleThreshold) * 31;
            List<ReferenceMatcher> list = this.referenceMatchers;
            int hashCode = (i3 + (list != null ? list.hashCode() : 0)) * 31;
            List<ObjectInspector> list2 = this.objectInspectors;
            int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            OnHeapAnalyzedListener onHeapAnalyzedListener = this.onHeapAnalyzedListener;
            int hashCode3 = (hashCode2 + (onHeapAnalyzedListener != null ? onHeapAnalyzedListener.hashCode() : 0)) * 31;
            MetadataExtractor metadataExtractor = this.metadataExtractor;
            int hashCode4 = (hashCode3 + (metadataExtractor != null ? metadataExtractor.hashCode() : 0)) * 31;
            ?? r22 = this.computeRetainedHeapSize;
            int i4 = r22;
            if (r22 != 0) {
                i4 = 1;
            }
            int i5 = (((hashCode4 + i4) * 31) + this.maxStoredHeapDumps) * 31;
            ?? r23 = this.requestWriteExternalStoragePermission;
            int i6 = r23;
            if (r23 != 0) {
                i6 = 1;
            }
            int i7 = (i5 + i6) * 31;
            LeakingObjectFinder leakingObjectFinder = this.leakingObjectFinder;
            int hashCode5 = (i7 + (leakingObjectFinder != null ? leakingObjectFinder.hashCode() : 0)) * 31;
            HeapDumper heapDumper = this.heapDumper;
            int hashCode6 = (hashCode5 + (heapDumper != null ? heapDumper.hashCode() : 0)) * 31;
            List<EventListener> list3 = this.eventListeners;
            int hashCode7 = (hashCode6 + (list3 != null ? list3.hashCode() : 0)) * 31;
            ?? r24 = this.showNotifications;
            int i8 = r24;
            if (r24 != 0) {
                i8 = 1;
            }
            int i9 = (hashCode7 + i8) * 31;
            boolean z2 = this.useExperimentalLeakFinders;
            return i9 + (z2 ? 1 : z2 ? 1 : 0);
        }

        public String toString() {
            return "Config(dumpHeap=" + this.dumpHeap + ", dumpHeapWhenDebugging=" + this.dumpHeapWhenDebugging + ", retainedVisibleThreshold=" + this.retainedVisibleThreshold + ", referenceMatchers=" + this.referenceMatchers + ", objectInspectors=" + this.objectInspectors + ", onHeapAnalyzedListener=" + this.onHeapAnalyzedListener + ", metadataExtractor=" + this.metadataExtractor + ", computeRetainedHeapSize=" + this.computeRetainedHeapSize + ", maxStoredHeapDumps=" + this.maxStoredHeapDumps + ", requestWriteExternalStoragePermission=" + this.requestWriteExternalStoragePermission + ", leakingObjectFinder=" + this.leakingObjectFinder + ", heapDumper=" + this.heapDumper + ", eventListeners=" + this.eventListeners + ", showNotifications=" + this.showNotifications + ", useExperimentalLeakFinders=" + this.useExperimentalLeakFinders + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Config(boolean dumpHeap, boolean dumpHeapWhenDebugging, int retainedVisibleThreshold, List<? extends ReferenceMatcher> referenceMatchers, List<? extends ObjectInspector> objectInspectors, OnHeapAnalyzedListener onHeapAnalyzedListener, MetadataExtractor metadataExtractor, boolean computeRetainedHeapSize, int maxStoredHeapDumps, boolean requestWriteExternalStoragePermission, LeakingObjectFinder leakingObjectFinder, HeapDumper heapDumper, List<? extends EventListener> eventListeners, boolean showNotifications, boolean useExperimentalLeakFinders) {
            Intrinsics.checkParameterIsNotNull(referenceMatchers, "referenceMatchers");
            Intrinsics.checkParameterIsNotNull(objectInspectors, "objectInspectors");
            Intrinsics.checkParameterIsNotNull(onHeapAnalyzedListener, "onHeapAnalyzedListener");
            Intrinsics.checkParameterIsNotNull(metadataExtractor, "metadataExtractor");
            Intrinsics.checkParameterIsNotNull(leakingObjectFinder, "leakingObjectFinder");
            Intrinsics.checkParameterIsNotNull(heapDumper, "heapDumper");
            Intrinsics.checkParameterIsNotNull(eventListeners, "eventListeners");
            this.dumpHeap = dumpHeap;
            this.dumpHeapWhenDebugging = dumpHeapWhenDebugging;
            this.retainedVisibleThreshold = retainedVisibleThreshold;
            this.referenceMatchers = referenceMatchers;
            this.objectInspectors = objectInspectors;
            this.onHeapAnalyzedListener = onHeapAnalyzedListener;
            this.metadataExtractor = metadataExtractor;
            this.computeRetainedHeapSize = computeRetainedHeapSize;
            this.maxStoredHeapDumps = maxStoredHeapDumps;
            this.requestWriteExternalStoragePermission = requestWriteExternalStoragePermission;
            this.leakingObjectFinder = leakingObjectFinder;
            this.heapDumper = heapDumper;
            this.eventListeners = eventListeners;
            this.showNotifications = showNotifications;
            this.useExperimentalLeakFinders = useExperimentalLeakFinders;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ Config(boolean z, boolean z2, int i, List list, List list2, OnHeapAnalyzedListener onHeapAnalyzedListener, MetadataExtractor metadataExtractor, boolean z3, int i2, boolean z4, LeakingObjectFinder leakingObjectFinder, HeapDumper heapDumper, List list3, boolean z5, boolean z6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(r1, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r2, (i3 & 8192) != 0 ? true : z5, (i3 & 16384) != 0 ? false : z6);
            List list4;
            boolean z7 = (i3 & 1) != 0 ? true : z;
            boolean z8 = (i3 & 2) != 0 ? false : z2;
            int i4 = (i3 & 4) != 0 ? 5 : i;
            List appDefaults = (i3 & 8) != 0 ? AndroidReferenceMatchers.Companion.getAppDefaults() : list;
            List appDefaults2 = (i3 & 16) != 0 ? AndroidObjectInspectors.Companion.getAppDefaults() : list2;
            OnHeapAnalyzedListener create = (i3 & 32) != 0 ? DefaultOnHeapAnalyzedListener.Companion.create() : onHeapAnalyzedListener;
            MetadataExtractor metadataExtractor2 = (i3 & 64) != 0 ? (MetadataExtractor) AndroidMetadataExtractor.INSTANCE : metadataExtractor;
            boolean z9 = (i3 & 128) != 0 ? true : z3;
            int i5 = (i3 & 256) != 0 ? 7 : i2;
            boolean z10 = (i3 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? false : z4;
            LeakingObjectFinder leakingObjectFinder2 = (i3 & 1024) != 0 ? (LeakingObjectFinder) KeyedWeakReferenceFinder.INSTANCE : leakingObjectFinder;
            AndroidDebugHeapDumper androidDebugHeapDumper = (i3 & 2048) != 0 ? AndroidDebugHeapDumper.INSTANCE : heapDumper;
            if ((i3 & 4096) != 0) {
                EventListener[] eventListenerArr = new EventListener[4];
                eventListenerArr[0] = LogcatEventListener.INSTANCE;
                eventListenerArr[1] = ToastEventListener.INSTANCE;
                eventListenerArr[2] = new LazyForwardingEventListener(new Function0<EventListener>() { // from class: leakcanary.LeakCanary.Config.1
                    @Override // kotlin.jvm.functions.Function0
                    public final EventListener invoke() {
                        return InternalLeakCanary.INSTANCE.getFormFactor() == InternalLeakCanary.FormFactor.TV ? TvEventListener.INSTANCE : NotificationEventListener.INSTANCE;
                    }
                });
                eventListenerArr[3] = RemoteWorkManagerHeapAnalyzer.INSTANCE.getRemoteLeakCanaryServiceInClasspath$leakcanary_android_core_release() ? RemoteWorkManagerHeapAnalyzer.INSTANCE : WorkManagerHeapAnalyzer.INSTANCE.getValidWorkManagerInClasspath$leakcanary_android_core_release() ? WorkManagerHeapAnalyzer.INSTANCE : BackgroundThreadHeapAnalyzer.INSTANCE;
                list4 = CollectionsKt.listOf((Object[]) eventListenerArr);
            } else {
                list4 = list3;
            }
        }

        public final boolean getDumpHeap() {
            return this.dumpHeap;
        }

        public final boolean getDumpHeapWhenDebugging() {
            return this.dumpHeapWhenDebugging;
        }

        public final int getRetainedVisibleThreshold() {
            return this.retainedVisibleThreshold;
        }

        public final List<ReferenceMatcher> getReferenceMatchers() {
            return this.referenceMatchers;
        }

        public final List<ObjectInspector> getObjectInspectors() {
            return this.objectInspectors;
        }

        public final OnHeapAnalyzedListener getOnHeapAnalyzedListener() {
            return this.onHeapAnalyzedListener;
        }

        public final MetadataExtractor getMetadataExtractor() {
            return this.metadataExtractor;
        }

        public final boolean getComputeRetainedHeapSize() {
            return this.computeRetainedHeapSize;
        }

        public final int getMaxStoredHeapDumps() {
            return this.maxStoredHeapDumps;
        }

        public final boolean getRequestWriteExternalStoragePermission() {
            return this.requestWriteExternalStoragePermission;
        }

        public final LeakingObjectFinder getLeakingObjectFinder() {
            return this.leakingObjectFinder;
        }

        public final HeapDumper getHeapDumper() {
            return this.heapDumper;
        }

        public final List<EventListener> getEventListeners() {
            return this.eventListeners;
        }

        public final boolean getShowNotifications() {
            return this.showNotifications;
        }

        public final boolean getUseExperimentalLeakFinders() {
            return this.useExperimentalLeakFinders;
        }

        public final Builder newBuilder() {
            return new Builder(this);
        }

        /* compiled from: LeakCanary.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001e\u001a\u00020\u0003J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0006J\u0014\u0010\t\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u0014\u0010\u0014\u001a\u00020\u00002\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\nJ\u0010\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0014\u0010\u0018\u001a\u00020\u00002\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\nJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0011J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0006J\u0010\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0006H\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lleakcanary/LeakCanary$Config$Builder;", "", "config", "Lleakcanary/LeakCanary$Config;", "(Lleakcanary/LeakCanary$Config;)V", "computeRetainedHeapSize", "", "dumpHeap", "dumpHeapWhenDebugging", "eventListeners", "", "Lleakcanary/EventListener;", "heapDumper", "Lleakcanary/HeapDumper;", "leakingObjectFinder", "Lshark/LeakingObjectFinder;", "maxStoredHeapDumps", "", "metadataExtractor", "Lshark/MetadataExtractor;", "objectInspectors", "Lshark/ObjectInspector;", "onHeapAnalyzedListener", "Lleakcanary/OnHeapAnalyzedListener;", "referenceMatchers", "Lshark/ReferenceMatcher;", "requestWriteExternalStoragePermission", "retainedVisibleThreshold", "showNotifications", "useExperimentalLeakFinders", "build", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class Builder {
            private boolean computeRetainedHeapSize;
            private boolean dumpHeap;
            private boolean dumpHeapWhenDebugging;
            private List<? extends EventListener> eventListeners;
            private HeapDumper heapDumper;
            private LeakingObjectFinder leakingObjectFinder;
            private int maxStoredHeapDumps;
            private MetadataExtractor metadataExtractor;
            private List<? extends ObjectInspector> objectInspectors;
            private OnHeapAnalyzedListener onHeapAnalyzedListener;
            private List<? extends ReferenceMatcher> referenceMatchers;
            private boolean requestWriteExternalStoragePermission;
            private int retainedVisibleThreshold;
            private boolean showNotifications;
            private boolean useExperimentalLeakFinders;

            public Builder(Config config) {
                Intrinsics.checkParameterIsNotNull(config, "config");
                this.dumpHeap = config.getDumpHeap();
                this.dumpHeapWhenDebugging = config.getDumpHeapWhenDebugging();
                this.retainedVisibleThreshold = config.getRetainedVisibleThreshold();
                this.referenceMatchers = config.getReferenceMatchers();
                this.objectInspectors = config.getObjectInspectors();
                this.onHeapAnalyzedListener = config.getOnHeapAnalyzedListener();
                this.metadataExtractor = config.getMetadataExtractor();
                this.computeRetainedHeapSize = config.getComputeRetainedHeapSize();
                this.maxStoredHeapDumps = config.getMaxStoredHeapDumps();
                this.requestWriteExternalStoragePermission = config.getRequestWriteExternalStoragePermission();
                this.leakingObjectFinder = config.getLeakingObjectFinder();
                this.heapDumper = config.getHeapDumper();
                this.eventListeners = config.getEventListeners();
                this.useExperimentalLeakFinders = config.getUseExperimentalLeakFinders();
                this.showNotifications = config.getShowNotifications();
            }

            public final Builder dumpHeap(boolean dumpHeap) {
                Builder $this$apply = this;
                $this$apply.dumpHeap = dumpHeap;
                return this;
            }

            public final Builder dumpHeapWhenDebugging(boolean dumpHeapWhenDebugging) {
                Builder $this$apply = this;
                $this$apply.dumpHeapWhenDebugging = dumpHeapWhenDebugging;
                return this;
            }

            public final Builder retainedVisibleThreshold(int retainedVisibleThreshold) {
                Builder $this$apply = this;
                $this$apply.retainedVisibleThreshold = retainedVisibleThreshold;
                return this;
            }

            public final Builder referenceMatchers(List<? extends ReferenceMatcher> referenceMatchers) {
                Intrinsics.checkParameterIsNotNull(referenceMatchers, "referenceMatchers");
                Builder $this$apply = this;
                $this$apply.referenceMatchers = referenceMatchers;
                return this;
            }

            public final Builder objectInspectors(List<? extends ObjectInspector> objectInspectors) {
                Intrinsics.checkParameterIsNotNull(objectInspectors, "objectInspectors");
                Builder $this$apply = this;
                $this$apply.objectInspectors = objectInspectors;
                return this;
            }

            @Deprecated(message = "Add to LeakCanary.config.eventListeners instead")
            public final Builder onHeapAnalyzedListener(OnHeapAnalyzedListener onHeapAnalyzedListener) {
                Intrinsics.checkParameterIsNotNull(onHeapAnalyzedListener, "onHeapAnalyzedListener");
                Builder $this$apply = this;
                $this$apply.onHeapAnalyzedListener = onHeapAnalyzedListener;
                return this;
            }

            public final Builder metadataExtractor(MetadataExtractor metadataExtractor) {
                Intrinsics.checkParameterIsNotNull(metadataExtractor, "metadataExtractor");
                Builder $this$apply = this;
                $this$apply.metadataExtractor = metadataExtractor;
                return this;
            }

            public final Builder computeRetainedHeapSize(boolean computeRetainedHeapSize) {
                Builder $this$apply = this;
                $this$apply.computeRetainedHeapSize = computeRetainedHeapSize;
                return this;
            }

            public final Builder maxStoredHeapDumps(int maxStoredHeapDumps) {
                Builder $this$apply = this;
                $this$apply.maxStoredHeapDumps = maxStoredHeapDumps;
                return this;
            }

            public final Builder requestWriteExternalStoragePermission(boolean requestWriteExternalStoragePermission) {
                Builder $this$apply = this;
                $this$apply.requestWriteExternalStoragePermission = requestWriteExternalStoragePermission;
                return this;
            }

            public final Builder leakingObjectFinder(LeakingObjectFinder leakingObjectFinder) {
                Intrinsics.checkParameterIsNotNull(leakingObjectFinder, "leakingObjectFinder");
                Builder $this$apply = this;
                $this$apply.leakingObjectFinder = leakingObjectFinder;
                return this;
            }

            public final Builder heapDumper(HeapDumper heapDumper) {
                Intrinsics.checkParameterIsNotNull(heapDumper, "heapDumper");
                Builder $this$apply = this;
                $this$apply.heapDumper = heapDumper;
                return this;
            }

            public final Builder eventListeners(List<? extends EventListener> eventListeners) {
                Intrinsics.checkParameterIsNotNull(eventListeners, "eventListeners");
                Builder $this$apply = this;
                $this$apply.eventListeners = eventListeners;
                return this;
            }

            @Deprecated(message = "Set a custom leakingObjectFinder instead")
            public final Builder useExperimentalLeakFinders(boolean useExperimentalLeakFinders) {
                Builder $this$apply = this;
                $this$apply.useExperimentalLeakFinders = useExperimentalLeakFinders;
                return this;
            }

            public final Builder showNotifications(boolean showNotifications) {
                Builder $this$apply = this;
                $this$apply.showNotifications = showNotifications;
                return this;
            }

            public final Config build() {
                return LeakCanary.getConfig().copy(this.dumpHeap, this.dumpHeapWhenDebugging, this.retainedVisibleThreshold, this.referenceMatchers, this.objectInspectors, this.onHeapAnalyzedListener, this.metadataExtractor, this.computeRetainedHeapSize, this.maxStoredHeapDumps, this.requestWriteExternalStoragePermission, this.leakingObjectFinder, this.heapDumper, this.eventListeners, this.showNotifications, this.useExperimentalLeakFinders);
            }
        }
    }

    public static final Config getConfig() {
        return config;
    }

    public static final void setConfig(Config newConfig) {
        Intrinsics.checkParameterIsNotNull(newConfig, "newConfig");
        Config previousConfig = config;
        config = newConfig;
        INSTANCE.logConfigChange(previousConfig, newConfig);
        HeapDumpControl.INSTANCE.updateICanHasHeapInBackground();
    }

    private final void logConfigChange(Config previousConfig, Config newConfig) {
        SharkLog this_$iv;
        boolean z;
        boolean z2;
        SharkLog this_$iv2 = SharkLog.INSTANCE;
        boolean z3 = false;
        SharkLog.Logger logger$iv = this_$iv2.getLogger();
        if (logger$iv == null) {
            return;
        }
        boolean z4 = false;
        List changedFields = new ArrayList();
        Field[] declaredFields = Config.class.getDeclaredFields();
        Intrinsics.checkExpressionValueIsNotNull(declaredFields, "Config::class.java.declaredFields");
        int length = declaredFields.length;
        int i = 0;
        while (i < length) {
            Field field = declaredFields[i];
            Intrinsics.checkExpressionValueIsNotNull(field, "field");
            field.setAccessible(true);
            Object previousValue = field.get(previousConfig);
            Object newValue = field.get(newConfig);
            if (Intrinsics.areEqual(previousValue, newValue)) {
                this_$iv = this_$iv2;
                z = z3;
                z2 = z4;
            } else {
                this_$iv = this_$iv2;
                z = z3;
                z2 = z4;
                changedFields.add(field.getName() + '=' + newValue);
            }
            i++;
            this_$iv2 = this_$iv;
            z3 = z;
            z4 = z2;
        }
        String changesInConfig = !changedFields.isEmpty() ? CollectionsKt.joinToString$default(changedFields, ", ", null, null, 0, null, null, 62, null) : "no changes";
        logger$iv.d("Updated LeakCanary.config: Config(" + changesInConfig + ')');
    }

    public final Intent newLeakDisplayActivityIntent() {
        return LeakActivity.Companion.createHomeIntent(InternalLeakCanary.INSTANCE.getApplication());
    }

    public final void showLeakDisplayActivityLauncherIcon(boolean showLauncherIcon) {
        InternalLeakCanary.INSTANCE.setEnabledBlocking("leakcanary.internal.activity.LeakLauncherActivity", showLauncherIcon);
    }

    public final void dumpHeap() {
        InternalLeakCanary.INSTANCE.onDumpHeapReceived(true);
    }
}