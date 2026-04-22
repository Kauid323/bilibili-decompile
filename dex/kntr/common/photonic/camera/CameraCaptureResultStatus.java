package kntr.common.photonic.camera;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestCamera.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/common/photonic/camera/CameraCaptureResultStatus;", "", "ConfirmedAsset", "Canceled", "Lkntr/common/photonic/camera/CameraCaptureResultStatus$Canceled;", "Lkntr/common/photonic/camera/CameraCaptureResultStatus$ConfirmedAsset;", "camera_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface CameraCaptureResultStatus {

    /* compiled from: RequestCamera.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkntr/common/photonic/camera/CameraCaptureResultStatus$ConfirmedAsset;", "Lkntr/common/photonic/camera/CameraCaptureResultStatus;", "asset", "Lkntr/common/photonic/Asset;", "<init>", "(Lkntr/common/photonic/Asset;)V", "getAsset", "()Lkntr/common/photonic/Asset;", "camera_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ConfirmedAsset implements CameraCaptureResultStatus {
        public static final int $stable = 8;
        private final Asset asset;

        public ConfirmedAsset(Asset asset) {
            Intrinsics.checkNotNullParameter(asset, "asset");
            this.asset = asset;
        }

        public final Asset getAsset() {
            return this.asset;
        }
    }

    /* compiled from: RequestCamera.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/photonic/camera/CameraCaptureResultStatus$Canceled;", "Lkntr/common/photonic/camera/CameraCaptureResultStatus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "camera_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Canceled implements CameraCaptureResultStatus {
        public static final int $stable = 0;
        public static final Canceled INSTANCE = new Canceled();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Canceled) {
                Canceled canceled = (Canceled) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -252549634;
        }

        public String toString() {
            return "Canceled";
        }

        private Canceled() {
        }
    }
}