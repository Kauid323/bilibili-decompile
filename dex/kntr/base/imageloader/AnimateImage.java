package kntr.base.imageloader;

import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.Painter;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: Image.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&J\u0017\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lkntr/base/imageloader/AnimateImage;", "Lkntr/base/imageloader/Image;", "getImageInfo", "Lkntr/base/imageloader/AnimateImageInfo;", "getPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "setAnimationListener", "", "listener", "Lkntr/base/imageloader/AnimationListener;", "getFrame", "Landroidx/compose/ui/graphics/ImageBitmap;", "index", "", "getFrameCount", "getFrameDuration", "Lkotlin/time/Duration;", "getFrameDuration-5sfh64U", "(I)J", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AnimateImage extends Image {
    ImageBitmap getFrame(int i);

    int getFrameCount();

    /* renamed from: getFrameDuration-5sfh64U  reason: not valid java name */
    long mo1409getFrameDuration5sfh64U(int i);

    AnimateImageInfo getImageInfo();

    Painter getPainter();

    void setAnimationListener(AnimationListener animationListener);
}