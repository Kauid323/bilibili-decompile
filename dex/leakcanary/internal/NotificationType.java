package leakcanary.internal;

import com.squareup.leakcanary.core.R;
import kotlin.Metadata;

/* compiled from: NotificationType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lleakcanary/internal/NotificationType;", "", "nameResId", "", "importance", "(Ljava/lang/String;III)V", "getImportance", "()I", "getNameResId", "LEAKCANARY_LOW", "LEAKCANARY_MAX", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public enum NotificationType {
    LEAKCANARY_LOW(R.string.leak_canary_notification_channel_low, 2),
    LEAKCANARY_MAX(R.string.leak_canary_notification_channel_result, 5);
    
    private final int importance;
    private final int nameResId;

    NotificationType(int nameResId, int importance) {
        this.nameResId = nameResId;
        this.importance = importance;
    }

    public final int getNameResId() {
        return this.nameResId;
    }

    public final int getImportance() {
        return this.importance;
    }
}