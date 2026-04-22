package leakcanary;

import android.content.Intent;
import java.io.File;
import java.io.Serializable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.SerializableIntent;
import shark.HeapAnalysis;
import shark.HeapAnalysisFailure;
import shark.HeapAnalysisSuccess;
import shark.OnAnalysisProgressListener;

/* compiled from: EventListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lleakcanary/EventListener;", "", "onEvent", "", "event", "Lleakcanary/EventListener$Event;", "Event", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public interface EventListener {
    void onEvent(Event event);

    /* compiled from: EventListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0007\b\t\n\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0005\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lleakcanary/EventListener$Event;", "Ljava/io/Serializable;", "uniqueId", "", "(Ljava/lang/String;)V", "getUniqueId", "()Ljava/lang/String;", "DumpingHeap", "HeapAnalysisDone", "HeapAnalysisProgress", "HeapDump", "HeapDumpFailed", "Lleakcanary/EventListener$Event$DumpingHeap;", "Lleakcanary/EventListener$Event$HeapDump;", "Lleakcanary/EventListener$Event$HeapDumpFailed;", "Lleakcanary/EventListener$Event$HeapAnalysisProgress;", "Lleakcanary/EventListener$Event$HeapAnalysisDone;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static abstract class Event implements Serializable {
        private final String uniqueId;

        private Event(String uniqueId) {
            this.uniqueId = uniqueId;
        }

        public /* synthetic */ Event(String uniqueId, DefaultConstructorMarker $constructor_marker) {
            this(uniqueId);
        }

        public final String getUniqueId() {
            return this.uniqueId;
        }

        /* compiled from: EventListener.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lleakcanary/EventListener$Event$DumpingHeap;", "Lleakcanary/EventListener$Event;", "uniqueId", "", "(Ljava/lang/String;)V", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class DumpingHeap extends Event {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DumpingHeap(String uniqueId) {
                super(uniqueId, null);
                Intrinsics.checkParameterIsNotNull(uniqueId, "uniqueId");
            }
        }

        /* compiled from: EventListener.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lleakcanary/EventListener$Event$HeapDump;", "Lleakcanary/EventListener$Event;", "uniqueId", "", "file", "Ljava/io/File;", "durationMillis", "", "reason", "(Ljava/lang/String;Ljava/io/File;JLjava/lang/String;)V", "getDurationMillis", "()J", "getFile", "()Ljava/io/File;", "getReason", "()Ljava/lang/String;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class HeapDump extends Event {
            private final long durationMillis;
            private final File file;
            private final String reason;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HeapDump(String uniqueId, File file, long durationMillis, String reason) {
                super(uniqueId, null);
                Intrinsics.checkParameterIsNotNull(uniqueId, "uniqueId");
                Intrinsics.checkParameterIsNotNull(file, "file");
                Intrinsics.checkParameterIsNotNull(reason, "reason");
                this.file = file;
                this.durationMillis = durationMillis;
                this.reason = reason;
            }

            public final File getFile() {
                return this.file;
            }

            public final long getDurationMillis() {
                return this.durationMillis;
            }

            public final String getReason() {
                return this.reason;
            }
        }

        /* compiled from: EventListener.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lleakcanary/EventListener$Event$HeapDumpFailed;", "Lleakcanary/EventListener$Event;", "uniqueId", "", "exception", "", "willRetryLater", "", "(Ljava/lang/String;Ljava/lang/Throwable;Z)V", "getException", "()Ljava/lang/Throwable;", "getWillRetryLater", "()Z", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class HeapDumpFailed extends Event {
            private final Throwable exception;
            private final boolean willRetryLater;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HeapDumpFailed(String uniqueId, Throwable exception, boolean willRetryLater) {
                super(uniqueId, null);
                Intrinsics.checkParameterIsNotNull(uniqueId, "uniqueId");
                Intrinsics.checkParameterIsNotNull(exception, "exception");
                this.exception = exception;
                this.willRetryLater = willRetryLater;
            }

            public final Throwable getException() {
                return this.exception;
            }

            public final boolean getWillRetryLater() {
                return this.willRetryLater;
            }
        }

        /* compiled from: EventListener.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lleakcanary/EventListener$Event$HeapAnalysisProgress;", "Lleakcanary/EventListener$Event;", "uniqueId", "", "step", "Lshark/OnAnalysisProgressListener$Step;", "progressPercent", "", "(Ljava/lang/String;Lshark/OnAnalysisProgressListener$Step;D)V", "getProgressPercent", "()D", "getStep", "()Lshark/OnAnalysisProgressListener$Step;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class HeapAnalysisProgress extends Event {
            private final double progressPercent;
            private final OnAnalysisProgressListener.Step step;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HeapAnalysisProgress(String uniqueId, OnAnalysisProgressListener.Step step, double progressPercent) {
                super(uniqueId, null);
                Intrinsics.checkParameterIsNotNull(uniqueId, "uniqueId");
                Intrinsics.checkParameterIsNotNull(step, "step");
                this.step = step;
                this.progressPercent = progressPercent;
            }

            public final OnAnalysisProgressListener.Step getStep() {
                return this.step;
            }

            public final double getProgressPercent() {
                return this.progressPercent;
            }
        }

        /* compiled from: EventListener.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0002\u0011\u0012B\u001f\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0001\u0002\u0013\u0014¨\u0006\u0015"}, d2 = {"Lleakcanary/EventListener$Event$HeapAnalysisDone;", "T", "Lshark/HeapAnalysis;", "Lleakcanary/EventListener$Event;", "uniqueId", "", "heapAnalysis", "showIntent", "Landroid/content/Intent;", "(Ljava/lang/String;Lshark/HeapAnalysis;Landroid/content/Intent;)V", "getHeapAnalysis", "()Lshark/HeapAnalysis;", "Lshark/HeapAnalysis;", "serializableShowIntent", "Lleakcanary/internal/SerializableIntent;", "getShowIntent", "()Landroid/content/Intent;", "HeapAnalysisFailed", "HeapAnalysisSucceeded", "Lleakcanary/EventListener$Event$HeapAnalysisDone$HeapAnalysisSucceeded;", "Lleakcanary/EventListener$Event$HeapAnalysisDone$HeapAnalysisFailed;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static abstract class HeapAnalysisDone<T extends HeapAnalysis> extends Event {
            private final T heapAnalysis;
            private final SerializableIntent serializableShowIntent;

            private HeapAnalysisDone(String uniqueId, T t, Intent showIntent) {
                super(uniqueId, null);
                this.heapAnalysis = t;
                this.serializableShowIntent = new SerializableIntent(showIntent);
            }

            public /* synthetic */ HeapAnalysisDone(String uniqueId, HeapAnalysis heapAnalysis, Intent showIntent, DefaultConstructorMarker $constructor_marker) {
                this(uniqueId, heapAnalysis, showIntent);
            }

            public final T getHeapAnalysis() {
                return this.heapAnalysis;
            }

            public final Intent getShowIntent() {
                return this.serializableShowIntent.getIntent();
            }

            /* compiled from: EventListener.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lleakcanary/EventListener$Event$HeapAnalysisDone$HeapAnalysisSucceeded;", "Lleakcanary/EventListener$Event$HeapAnalysisDone;", "Lshark/HeapAnalysisSuccess;", "uniqueId", "", "heapAnalysis", "unreadLeakSignatures", "", "showIntent", "Landroid/content/Intent;", "(Ljava/lang/String;Lshark/HeapAnalysisSuccess;Ljava/util/Set;Landroid/content/Intent;)V", "getUnreadLeakSignatures", "()Ljava/util/Set;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class HeapAnalysisSucceeded extends HeapAnalysisDone<HeapAnalysisSuccess> {
                private final Set<String> unreadLeakSignatures;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public HeapAnalysisSucceeded(String uniqueId, HeapAnalysisSuccess heapAnalysis, Set<String> unreadLeakSignatures, Intent showIntent) {
                    super(uniqueId, (HeapAnalysis) heapAnalysis, showIntent, null);
                    Intrinsics.checkParameterIsNotNull(uniqueId, "uniqueId");
                    Intrinsics.checkParameterIsNotNull(heapAnalysis, "heapAnalysis");
                    Intrinsics.checkParameterIsNotNull(unreadLeakSignatures, "unreadLeakSignatures");
                    Intrinsics.checkParameterIsNotNull(showIntent, "showIntent");
                    this.unreadLeakSignatures = unreadLeakSignatures;
                }

                public final Set<String> getUnreadLeakSignatures() {
                    return this.unreadLeakSignatures;
                }
            }

            /* compiled from: EventListener.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lleakcanary/EventListener$Event$HeapAnalysisDone$HeapAnalysisFailed;", "Lleakcanary/EventListener$Event$HeapAnalysisDone;", "Lshark/HeapAnalysisFailure;", "uniqueId", "", "heapAnalysis", "showIntent", "Landroid/content/Intent;", "(Ljava/lang/String;Lshark/HeapAnalysisFailure;Landroid/content/Intent;)V", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class HeapAnalysisFailed extends HeapAnalysisDone<HeapAnalysisFailure> {
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public HeapAnalysisFailed(String uniqueId, HeapAnalysisFailure heapAnalysis, Intent showIntent) {
                    super(uniqueId, (HeapAnalysis) heapAnalysis, showIntent, null);
                    Intrinsics.checkParameterIsNotNull(uniqueId, "uniqueId");
                    Intrinsics.checkParameterIsNotNull(heapAnalysis, "heapAnalysis");
                    Intrinsics.checkParameterIsNotNull(showIntent, "showIntent");
                }
            }
        }
    }
}