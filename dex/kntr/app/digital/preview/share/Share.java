package kntr.app.digital.preview.share;

import androidx.compose.ui.graphics.ImageBitmap;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: Share.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/app/digital/preview/share/Share;", RoomRecommendViewModel.EMPTY_CURSOR, "getQrcodeImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "source", RoomRecommendViewModel.EMPTY_CURSOR, "bitmapWidth", RoomRecommendViewModel.EMPTY_CURSOR, "bitmapHeight", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface Share {
    ImageBitmap getQrcodeImageBitmap(String str, int i, int i2);
}