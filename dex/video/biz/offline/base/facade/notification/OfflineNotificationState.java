package video.biz.offline.base.facade.notification;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: OfflineNotificationState.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b&\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003Jm\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0007HÆ\u0001J\u0013\u0010)\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016¨\u0006-"}, d2 = {"Lvideo/biz/offline/base/facade/notification/OfflineNotificationState;", "", "notificationId", "", "key", "", "autoCancel", "", "ongoing", "contentTitle", "contentText", "showProgress", "progress", "max", "indeterminate", "<init>", "(ILjava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ZIIZ)V", "getNotificationId", "()I", "getKey", "()Ljava/lang/String;", "getAutoCancel", "()Z", "getOngoing", "getContentTitle", "getContentText", "getShowProgress", "getProgress", "getMax", "getIndeterminate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "facade_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineNotificationState {
    public static final int $stable = 0;
    private final boolean autoCancel;
    private final String contentText;
    private final String contentTitle;
    private final boolean indeterminate;
    private final String key;
    private final int max;
    private final int notificationId;
    private final boolean ongoing;
    private final int progress;
    private final boolean showProgress;

    public final int component1() {
        return this.notificationId;
    }

    public final boolean component10() {
        return this.indeterminate;
    }

    public final String component2() {
        return this.key;
    }

    public final boolean component3() {
        return this.autoCancel;
    }

    public final boolean component4() {
        return this.ongoing;
    }

    public final String component5() {
        return this.contentTitle;
    }

    public final String component6() {
        return this.contentText;
    }

    public final boolean component7() {
        return this.showProgress;
    }

    public final int component8() {
        return this.progress;
    }

    public final int component9() {
        return this.max;
    }

    public final OfflineNotificationState copy(int i, String str, boolean z, boolean z2, String str2, String str3, boolean z3, int i2, int i3, boolean z4) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "contentTitle");
        Intrinsics.checkNotNullParameter(str3, "contentText");
        return new OfflineNotificationState(i, str, z, z2, str2, str3, z3, i2, i3, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OfflineNotificationState) {
            OfflineNotificationState offlineNotificationState = (OfflineNotificationState) obj;
            return this.notificationId == offlineNotificationState.notificationId && Intrinsics.areEqual(this.key, offlineNotificationState.key) && this.autoCancel == offlineNotificationState.autoCancel && this.ongoing == offlineNotificationState.ongoing && Intrinsics.areEqual(this.contentTitle, offlineNotificationState.contentTitle) && Intrinsics.areEqual(this.contentText, offlineNotificationState.contentText) && this.showProgress == offlineNotificationState.showProgress && this.progress == offlineNotificationState.progress && this.max == offlineNotificationState.max && this.indeterminate == offlineNotificationState.indeterminate;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((this.notificationId * 31) + this.key.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.autoCancel)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.ongoing)) * 31) + this.contentTitle.hashCode()) * 31) + this.contentText.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showProgress)) * 31) + this.progress) * 31) + this.max) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.indeterminate);
    }

    public String toString() {
        int i = this.notificationId;
        String str = this.key;
        boolean z = this.autoCancel;
        boolean z2 = this.ongoing;
        String str2 = this.contentTitle;
        String str3 = this.contentText;
        boolean z3 = this.showProgress;
        int i2 = this.progress;
        int i3 = this.max;
        return "OfflineNotificationState(notificationId=" + i + ", key=" + str + ", autoCancel=" + z + ", ongoing=" + z2 + ", contentTitle=" + str2 + ", contentText=" + str3 + ", showProgress=" + z3 + ", progress=" + i2 + ", max=" + i3 + ", indeterminate=" + this.indeterminate + ")";
    }

    public OfflineNotificationState(int notificationId, String key, boolean autoCancel, boolean ongoing, String contentTitle, String contentText, boolean showProgress, int progress, int max, boolean indeterminate) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(contentTitle, "contentTitle");
        Intrinsics.checkNotNullParameter(contentText, "contentText");
        this.notificationId = notificationId;
        this.key = key;
        this.autoCancel = autoCancel;
        this.ongoing = ongoing;
        this.contentTitle = contentTitle;
        this.contentText = contentText;
        this.showProgress = showProgress;
        this.progress = progress;
        this.max = max;
        this.indeterminate = indeterminate;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ OfflineNotificationState(int i, String str, boolean z, boolean z2, String str2, String str3, boolean z3, int i2, int i3, boolean z4, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, z, z2, str2, str3, z3, i2, r10, z4);
        int i5;
        if ((i4 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) == 0) {
            i5 = i3;
        } else {
            i5 = 100;
        }
    }

    public final int getNotificationId() {
        return this.notificationId;
    }

    public final String getKey() {
        return this.key;
    }

    public final boolean getAutoCancel() {
        return this.autoCancel;
    }

    public final boolean getOngoing() {
        return this.ongoing;
    }

    public final String getContentTitle() {
        return this.contentTitle;
    }

    public final String getContentText() {
        return this.contentText;
    }

    public final boolean getShowProgress() {
        return this.showProgress;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final int getMax() {
        return this.max;
    }

    public final boolean getIndeterminate() {
        return this.indeterminate;
    }
}