package kntr.base.imageloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Image.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/base/imageloader/AnimationState;", "", "Ready", "Start", "Stop", "LastFrame", "Lkntr/base/imageloader/AnimationState$LastFrame;", "Lkntr/base/imageloader/AnimationState$Ready;", "Lkntr/base/imageloader/AnimationState$Start;", "Lkntr/base/imageloader/AnimationState$Stop;", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AnimationState {

    /* compiled from: Image.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/base/imageloader/AnimationState$Ready;", "Lkntr/base/imageloader/AnimationState;", "imageInfo", "Lkntr/base/imageloader/AnimateImageInfo;", "controller", "Lkntr/base/imageloader/AnimateController;", "<init>", "(Lkntr/base/imageloader/AnimateImageInfo;Lkntr/base/imageloader/AnimateController;)V", "getImageInfo", "()Lkntr/base/imageloader/AnimateImageInfo;", "getController", "()Lkntr/base/imageloader/AnimateController;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Ready implements AnimationState {
        public static final int $stable = 0;
        private final AnimateController controller;
        private final AnimateImageInfo imageInfo;

        public static /* synthetic */ Ready copy$default(Ready ready, AnimateImageInfo animateImageInfo, AnimateController animateController, int i, Object obj) {
            if ((i & 1) != 0) {
                animateImageInfo = ready.imageInfo;
            }
            if ((i & 2) != 0) {
                animateController = ready.controller;
            }
            return ready.copy(animateImageInfo, animateController);
        }

        public final AnimateImageInfo component1() {
            return this.imageInfo;
        }

        public final AnimateController component2() {
            return this.controller;
        }

        public final Ready copy(AnimateImageInfo animateImageInfo, AnimateController animateController) {
            Intrinsics.checkNotNullParameter(animateImageInfo, "imageInfo");
            Intrinsics.checkNotNullParameter(animateController, "controller");
            return new Ready(animateImageInfo, animateController);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Ready) {
                Ready ready = (Ready) obj;
                return Intrinsics.areEqual(this.imageInfo, ready.imageInfo) && Intrinsics.areEqual(this.controller, ready.controller);
            }
            return false;
        }

        public int hashCode() {
            return (this.imageInfo.hashCode() * 31) + this.controller.hashCode();
        }

        public String toString() {
            AnimateImageInfo animateImageInfo = this.imageInfo;
            return "Ready(imageInfo=" + animateImageInfo + ", controller=" + this.controller + ")";
        }

        public Ready(AnimateImageInfo imageInfo, AnimateController controller) {
            Intrinsics.checkNotNullParameter(imageInfo, "imageInfo");
            Intrinsics.checkNotNullParameter(controller, "controller");
            this.imageInfo = imageInfo;
            this.controller = controller;
        }

        public final AnimateImageInfo getImageInfo() {
            return this.imageInfo;
        }

        public final AnimateController getController() {
            return this.controller;
        }
    }

    /* compiled from: Image.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/base/imageloader/AnimationState$Start;", "Lkntr/base/imageloader/AnimationState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Start implements AnimationState {
        public static final int $stable = 0;
        public static final Start INSTANCE = new Start();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Start) {
                Start start = (Start) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 863766993;
        }

        public String toString() {
            return "Start";
        }

        private Start() {
        }
    }

    /* compiled from: Image.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/base/imageloader/AnimationState$Stop;", "Lkntr/base/imageloader/AnimationState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Stop implements AnimationState {
        public static final int $stable = 0;
        public static final Stop INSTANCE = new Stop();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Stop) {
                Stop stop = (Stop) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -664872781;
        }

        public String toString() {
            return "Stop";
        }

        private Stop() {
        }
    }

    /* compiled from: Image.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/base/imageloader/AnimationState$LastFrame;", "Lkntr/base/imageloader/AnimationState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class LastFrame implements AnimationState {
        public static final int $stable = 0;
        public static final LastFrame INSTANCE = new LastFrame();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LastFrame) {
                LastFrame lastFrame = (LastFrame) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1786623386;
        }

        public String toString() {
            return "LastFrame";
        }

        private LastFrame() {
        }
    }
}