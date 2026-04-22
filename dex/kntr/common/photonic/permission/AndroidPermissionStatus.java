package kntr.common.photonic.permission;

import BottomSheetItemData$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: PermissionState.android.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/common/photonic/permission/AndroidPermissionStatus;", "", "Granted", "Denied", "Lkntr/common/photonic/permission/AndroidPermissionStatus$Denied;", "Lkntr/common/photonic/permission/AndroidPermissionStatus$Granted;", "permission_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AndroidPermissionStatus {

    /* compiled from: PermissionState.android.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/photonic/permission/AndroidPermissionStatus$Granted;", "Lkntr/common/photonic/permission/AndroidPermissionStatus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "permission_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Granted implements AndroidPermissionStatus {
        public static final int $stable = 0;
        public static final Granted INSTANCE = new Granted();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Granted) {
                Granted granted = (Granted) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 941767264;
        }

        public String toString() {
            return "Granted";
        }

        private Granted() {
        }
    }

    /* compiled from: PermissionState.android.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/common/photonic/permission/AndroidPermissionStatus$Denied;", "Lkntr/common/photonic/permission/AndroidPermissionStatus;", "shouldShowRationale", "", "<init>", "(Z)V", "getShouldShowRationale", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "permission_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Denied implements AndroidPermissionStatus {
        public static final int $stable = 0;
        private final boolean shouldShowRationale;

        public static /* synthetic */ Denied copy$default(Denied denied, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = denied.shouldShowRationale;
            }
            return denied.copy(z);
        }

        public final boolean component1() {
            return this.shouldShowRationale;
        }

        public final Denied copy(boolean z) {
            return new Denied(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Denied) && this.shouldShowRationale == ((Denied) obj).shouldShowRationale;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.shouldShowRationale);
        }

        public String toString() {
            return "Denied(shouldShowRationale=" + this.shouldShowRationale + ")";
        }

        public Denied(boolean shouldShowRationale) {
            this.shouldShowRationale = shouldShowRationale;
        }

        public final boolean getShouldShowRationale() {
            return this.shouldShowRationale;
        }
    }
}