package kntr.common.photonic.aphro.ui.preview;

import androidx.compose.ui.geometry.Rect;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.ImageSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImagePreviewLauncher.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/ExitTransitionState;", "", "imageSource", "Lkntr/base/imageloader/ImageSource;", "sourceRect", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Lkntr/base/imageloader/ImageSource;Landroidx/compose/ui/geometry/Rect;)V", "getImageSource", "()Lkntr/base/imageloader/ImageSource;", "getSourceRect", "()Landroidx/compose/ui/geometry/Rect;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ExitTransitionState {
    public static final int $stable = 0;
    private final ImageSource imageSource;
    private final Rect sourceRect;

    public static /* synthetic */ ExitTransitionState copy$default(ExitTransitionState exitTransitionState, ImageSource imageSource, Rect rect, int i, Object obj) {
        if ((i & 1) != 0) {
            imageSource = exitTransitionState.imageSource;
        }
        if ((i & 2) != 0) {
            rect = exitTransitionState.sourceRect;
        }
        return exitTransitionState.copy(imageSource, rect);
    }

    public final ImageSource component1() {
        return this.imageSource;
    }

    public final Rect component2() {
        return this.sourceRect;
    }

    public final ExitTransitionState copy(ImageSource imageSource, Rect rect) {
        Intrinsics.checkNotNullParameter(imageSource, "imageSource");
        Intrinsics.checkNotNullParameter(rect, "sourceRect");
        return new ExitTransitionState(imageSource, rect);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ExitTransitionState) {
            ExitTransitionState exitTransitionState = (ExitTransitionState) obj;
            return Intrinsics.areEqual(this.imageSource, exitTransitionState.imageSource) && Intrinsics.areEqual(this.sourceRect, exitTransitionState.sourceRect);
        }
        return false;
    }

    public int hashCode() {
        return (this.imageSource.hashCode() * 31) + this.sourceRect.hashCode();
    }

    public String toString() {
        ImageSource imageSource = this.imageSource;
        return "ExitTransitionState(imageSource=" + imageSource + ", sourceRect=" + this.sourceRect + ")";
    }

    public ExitTransitionState(ImageSource imageSource, Rect sourceRect) {
        Intrinsics.checkNotNullParameter(imageSource, "imageSource");
        Intrinsics.checkNotNullParameter(sourceRect, "sourceRect");
        this.imageSource = imageSource;
        this.sourceRect = sourceRect;
    }

    public final ImageSource getImageSource() {
        return this.imageSource;
    }

    public final Rect getSourceRect() {
        return this.sourceRect;
    }
}