package kntr.common.photonic.aphro.ui.preview.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.ContentSize;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ImagePreviewDataSource.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/model/OriginImageHint;", "", "Always", "Invisible", "Threshold", "Lkntr/common/photonic/aphro/ui/preview/model/OriginImageHint$Always;", "Lkntr/common/photonic/aphro/ui/preview/model/OriginImageHint$Invisible;", "Lkntr/common/photonic/aphro/ui/preview/model/OriginImageHint$Threshold;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface OriginImageHint {

    /* compiled from: ImagePreviewDataSource.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/model/OriginImageHint$Always;", "Lkntr/common/photonic/aphro/ui/preview/model/OriginImageHint;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Always implements OriginImageHint {
        public static final int $stable = 0;
        public static final Always INSTANCE = new Always();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Always) {
                Always always = (Always) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1987166860;
        }

        public String toString() {
            return "Always";
        }

        private Always() {
        }
    }

    /* compiled from: ImagePreviewDataSource.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/model/OriginImageHint$Invisible;", "Lkntr/common/photonic/aphro/ui/preview/model/OriginImageHint;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Invisible implements OriginImageHint {
        public static final int $stable = 0;
        public static final Invisible INSTANCE = new Invisible();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Invisible) {
                Invisible invisible = (Invisible) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -894606832;
        }

        public String toString() {
            return "Invisible";
        }

        private Invisible() {
        }
    }

    /* compiled from: ImagePreviewDataSource.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/model/OriginImageHint$Threshold;", "Lkntr/common/photonic/aphro/ui/preview/model/OriginImageHint;", "thresholdSize", "Lkntr/common/photonic/ContentSize;", "<init>", "(DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getThresholdSize-QJZHGII", "()D", "D", "component1", "component1-QJZHGII", "copy", "copy-4yfSoQ8", "(D)Lkntr/common/photonic/aphro/ui/preview/model/OriginImageHint$Threshold;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Threshold implements OriginImageHint {
        public static final int $stable = 0;
        private final double thresholdSize;

        public /* synthetic */ Threshold(double d, DefaultConstructorMarker defaultConstructorMarker) {
            this(d);
        }

        /* renamed from: copy-4yfSoQ8$default  reason: not valid java name */
        public static /* synthetic */ Threshold m2308copy4yfSoQ8$default(Threshold threshold, double d, int i, Object obj) {
            if ((i & 1) != 0) {
                d = threshold.thresholdSize;
            }
            return threshold.m2310copy4yfSoQ8(d);
        }

        /* renamed from: component1-QJZHGII  reason: not valid java name */
        public final double m2309component1QJZHGII() {
            return this.thresholdSize;
        }

        /* renamed from: copy-4yfSoQ8  reason: not valid java name */
        public final Threshold m2310copy4yfSoQ8(double d) {
            return new Threshold(d, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Threshold) && ContentSize.m2186equalsimpl0(this.thresholdSize, ((Threshold) obj).thresholdSize);
        }

        public int hashCode() {
            return ContentSize.m2190hashCodeimpl(this.thresholdSize);
        }

        public String toString() {
            return "Threshold(thresholdSize=" + ContentSize.m2193toStringimpl(this.thresholdSize) + ")";
        }

        private Threshold(double thresholdSize) {
            this.thresholdSize = thresholdSize;
        }

        /* renamed from: getThresholdSize-QJZHGII  reason: not valid java name */
        public final double m2311getThresholdSizeQJZHGII() {
            return this.thresholdSize;
        }
    }
}