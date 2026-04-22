package kntr.app.digital.preview.share;

import androidx.compose.ui.graphics.ImageBitmap;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Share.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lkntr/app/digital/preview/share/ShareData;", RoomRecommendViewModel.EMPTY_CURSOR, "oid", RoomRecommendViewModel.EMPTY_CURSOR, "title", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "shareUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;)V", "getOid", "()Ljava/lang/String;", "getTitle", "getImage", "()Landroidx/compose/ui/graphics/ImageBitmap;", "getShareUrl", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ShareData {
    public static final int $stable = 8;
    private final ImageBitmap image;
    private final String oid;
    private final String shareUrl;
    private final String title;

    public ShareData(String oid, String title, ImageBitmap image, String shareUrl) {
        Intrinsics.checkNotNullParameter(oid, "oid");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
        this.oid = oid;
        this.title = title;
        this.image = image;
        this.shareUrl = shareUrl;
    }

    public final String getOid() {
        return this.oid;
    }

    public final String getTitle() {
        return this.title;
    }

    public final ImageBitmap getImage() {
        return this.image;
    }

    public final String getShareUrl() {
        return this.shareUrl;
    }
}