package kntr.app.im.chat.sticker.entity;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: StickerEntity.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lkntr/app/im/chat/sticker/entity/StickerResolution;", RoomRecommendViewModel.EMPTY_CURSOR, "widthPx", RoomRecommendViewModel.EMPTY_CURSOR, "heightPx", "<init>", "(II)V", "getWidthPx", "()I", "getHeightPx", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StickerResolution {
    public static final int $stable = 0;
    private final int heightPx;
    private final int widthPx;

    public static /* synthetic */ StickerResolution copy$default(StickerResolution stickerResolution, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = stickerResolution.widthPx;
        }
        if ((i3 & 2) != 0) {
            i2 = stickerResolution.heightPx;
        }
        return stickerResolution.copy(i, i2);
    }

    public final int component1() {
        return this.widthPx;
    }

    public final int component2() {
        return this.heightPx;
    }

    public final StickerResolution copy(int i, int i2) {
        return new StickerResolution(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StickerResolution) {
            StickerResolution stickerResolution = (StickerResolution) obj;
            return this.widthPx == stickerResolution.widthPx && this.heightPx == stickerResolution.heightPx;
        }
        return false;
    }

    public int hashCode() {
        return (this.widthPx * 31) + this.heightPx;
    }

    public String toString() {
        int i = this.widthPx;
        return "StickerResolution(widthPx=" + i + ", heightPx=" + this.heightPx + ")";
    }

    public StickerResolution(int widthPx, int heightPx) {
        this.widthPx = widthPx;
        this.heightPx = heightPx;
    }

    public final int getWidthPx() {
        return this.widthPx;
    }

    public final int getHeightPx() {
        return this.heightPx;
    }
}