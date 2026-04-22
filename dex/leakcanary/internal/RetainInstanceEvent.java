package leakcanary.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnRetainInstanceListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\u0005\u0006\u0007\b\t¨\u0006\n"}, d2 = {"Lleakcanary/internal/RetainInstanceEvent;", "", "()V", "CountChanged", "NoMoreObjects", "Lleakcanary/internal/RetainInstanceEvent$NoMoreObjects;", "Lleakcanary/internal/RetainInstanceEvent$CountChanged;", "Lleakcanary/internal/RetainInstanceEvent$CountChanged$BelowThreshold;", "Lleakcanary/internal/RetainInstanceEvent$CountChanged$DumpingDisabled;", "Lleakcanary/internal/RetainInstanceEvent$CountChanged$DumpHappenedRecently;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public abstract class RetainInstanceEvent {

    /* compiled from: OnRetainInstanceListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lleakcanary/internal/RetainInstanceEvent$NoMoreObjects;", "Lleakcanary/internal/RetainInstanceEvent;", "()V", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class NoMoreObjects extends RetainInstanceEvent {
        public static final NoMoreObjects INSTANCE = new NoMoreObjects();

        private NoMoreObjects() {
            super(null);
        }
    }

    private RetainInstanceEvent() {
    }

    public /* synthetic */ RetainInstanceEvent(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    /* compiled from: OnRetainInstanceListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lleakcanary/internal/RetainInstanceEvent$CountChanged;", "Lleakcanary/internal/RetainInstanceEvent;", "()V", "BelowThreshold", "DumpHappenedRecently", "DumpingDisabled", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static abstract class CountChanged extends RetainInstanceEvent {

        /* compiled from: OnRetainInstanceListener.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lleakcanary/internal/RetainInstanceEvent$CountChanged$BelowThreshold;", "Lleakcanary/internal/RetainInstanceEvent;", "retainedCount", "", "(I)V", "getRetainedCount", "()I", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class BelowThreshold extends RetainInstanceEvent {
            private final int retainedCount;

            public BelowThreshold(int retainedCount) {
                super(null);
                this.retainedCount = retainedCount;
            }

            public final int getRetainedCount() {
                return this.retainedCount;
            }
        }

        private CountChanged() {
            super(null);
        }

        /* compiled from: OnRetainInstanceListener.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lleakcanary/internal/RetainInstanceEvent$CountChanged$DumpingDisabled;", "Lleakcanary/internal/RetainInstanceEvent;", "reason", "", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class DumpingDisabled extends RetainInstanceEvent {
            private final String reason;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DumpingDisabled(String reason) {
                super(null);
                Intrinsics.checkParameterIsNotNull(reason, "reason");
                this.reason = reason;
            }

            public final String getReason() {
                return this.reason;
            }
        }

        /* compiled from: OnRetainInstanceListener.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lleakcanary/internal/RetainInstanceEvent$CountChanged$DumpHappenedRecently;", "Lleakcanary/internal/RetainInstanceEvent;", "()V", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class DumpHappenedRecently extends RetainInstanceEvent {
            public static final DumpHappenedRecently INSTANCE = new DumpHappenedRecently();

            private DumpHappenedRecently() {
                super(null);
            }
        }
    }
}