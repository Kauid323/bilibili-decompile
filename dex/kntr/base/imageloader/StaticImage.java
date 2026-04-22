package kntr.base.imageloader;

import androidx.compose.ui.graphics.ImageBitmap;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: Image.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/base/imageloader/StaticImage;", "Lkntr/base/imageloader/Image;", "getImageInfo", "Lkntr/base/imageloader/StaticImageInfo;", "getBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface StaticImage extends Image {
    ImageBitmap getBitmap();

    StaticImageInfo getImageInfo();
}