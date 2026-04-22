package shark.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import shark.HeapField;
import shark.HeapObject;
import shark.HeapValue;
import shark.ValueHolder;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: KeyedWeakReferenceMirror.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u001a"}, d2 = {"Lshark/internal/KeyedWeakReferenceMirror;", "", "referent", "Lshark/ValueHolder$ReferenceHolder;", "key", "", "description", "watchDurationMillis", "", "retainedDurationMillis", "(Lshark/ValueHolder$ReferenceHolder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getDescription", "()Ljava/lang/String;", "hasReferent", "", "getHasReferent", "()Z", "isRetained", "getKey", "getReferent", "()Lshark/ValueHolder$ReferenceHolder;", "getRetainedDurationMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getWatchDurationMillis", "Companion", "shark"}, k = 1, mv = {1, 4, 1})
public final class KeyedWeakReferenceMirror {
    public static final Companion Companion = new Companion(null);
    private static final String UNKNOWN_LEGACY = "Unknown (legacy)";
    private final String description;
    private final boolean hasReferent;
    private final boolean isRetained;
    private final String key;
    private final ValueHolder.ReferenceHolder referent;
    private final Long retainedDurationMillis;
    private final Long watchDurationMillis;

    public KeyedWeakReferenceMirror(ValueHolder.ReferenceHolder referent, String key, String description, Long watchDurationMillis, Long retainedDurationMillis) {
        Long l;
        Intrinsics.checkParameterIsNotNull(referent, "referent");
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(description, "description");
        this.referent = referent;
        this.key = key;
        this.description = description;
        this.watchDurationMillis = watchDurationMillis;
        this.retainedDurationMillis = retainedDurationMillis;
        boolean z = true;
        this.hasReferent = this.referent.getValue() != 0;
        if (this.retainedDurationMillis != null && (l = this.retainedDurationMillis) != null && l.longValue() == -1) {
            z = false;
        }
        this.isRetained = z;
    }

    public final ValueHolder.ReferenceHolder getReferent() {
        return this.referent;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Long getWatchDurationMillis() {
        return this.watchDurationMillis;
    }

    public final Long getRetainedDurationMillis() {
        return this.retainedDurationMillis;
    }

    public final boolean getHasReferent() {
        return this.hasReferent;
    }

    public final boolean isRetained() {
        return this.isRetained;
    }

    /* compiled from: KeyedWeakReferenceMirror.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lshark/internal/KeyedWeakReferenceMirror$Companion;", "", "()V", "UNKNOWN_LEGACY", "", "fromInstance", "Lshark/internal/KeyedWeakReferenceMirror;", "weakRef", "Lshark/HeapObject$HeapInstance;", "heapDumpUptimeMillis", "", "(Lshark/HeapObject$HeapInstance;Ljava/lang/Long;)Lshark/internal/KeyedWeakReferenceMirror;", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final KeyedWeakReferenceMirror fromInstance(HeapObject.HeapInstance weakRef, Long heapDumpUptimeMillis) {
            Long watchDurationMillis;
            Long retainedDurationMillis;
            String str;
            HeapValue value;
            Intrinsics.checkParameterIsNotNull(weakRef, "weakRef");
            String keyWeakRefClassName = weakRef.getInstanceClassName();
            if (heapDumpUptimeMillis != null) {
                long longValue = heapDumpUptimeMillis.longValue();
                HeapField heapField = weakRef.get(keyWeakRefClassName, "watchUptimeMillis");
                if (heapField == null) {
                    Intrinsics.throwNpe();
                }
                Long asLong = heapField.getValue().getAsLong();
                if (asLong == null) {
                    Intrinsics.throwNpe();
                }
                watchDurationMillis = Long.valueOf(longValue - asLong.longValue());
            } else {
                watchDurationMillis = null;
            }
            if (heapDumpUptimeMillis != null) {
                HeapField heapField2 = weakRef.get(keyWeakRefClassName, "retainedUptimeMillis");
                if (heapField2 == null) {
                    Intrinsics.throwNpe();
                }
                Long asLong2 = heapField2.getValue().getAsLong();
                if (asLong2 == null) {
                    Intrinsics.throwNpe();
                }
                long retainedUptimeMillis = asLong2.longValue();
                retainedDurationMillis = Long.valueOf(retainedUptimeMillis != -1 ? heapDumpUptimeMillis.longValue() - retainedUptimeMillis : -1L);
            } else {
                retainedDurationMillis = null;
            }
            HeapField heapField3 = weakRef.get(keyWeakRefClassName, "key");
            if (heapField3 == null) {
                Intrinsics.throwNpe();
            }
            String keyString = heapField3.getValue().readAsJavaString();
            if (keyString == null) {
                Intrinsics.throwNpe();
            }
            HeapField heapField4 = weakRef.get(keyWeakRefClassName, "description");
            if (heapField4 == null) {
                heapField4 = weakRef.get(keyWeakRefClassName, ChannelRoutes.CHANNEL_NAME);
            }
            if (heapField4 == null || (value = heapField4.getValue()) == null || (str = value.readAsJavaString()) == null) {
                str = KeyedWeakReferenceMirror.UNKNOWN_LEGACY;
            }
            String description = str;
            HeapField heapField5 = weakRef.get("java.lang.ref.Reference", "referent");
            if (heapField5 == null) {
                Intrinsics.throwNpe();
            }
            ValueHolder holder = heapField5.getValue().getHolder();
            if (holder != null) {
                return new KeyedWeakReferenceMirror((ValueHolder.ReferenceHolder) holder, keyString, description, watchDurationMillis, retainedDurationMillis);
            }
            throw new TypeCastException("null cannot be cast to non-null type shark.ValueHolder.ReferenceHolder");
        }
    }
}