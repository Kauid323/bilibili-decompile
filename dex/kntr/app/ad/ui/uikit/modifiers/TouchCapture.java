package kntr.app.ad.ui.uikit.modifiers;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TouchCaptureModifier.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fBC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006 "}, d2 = {"Lkntr/app/ad/ui/uikit/modifiers/TouchCapture;", RoomRecommendViewModel.EMPTY_CURSOR, "width", RoomRecommendViewModel.EMPTY_CURSOR, "height", "downX", "downY", "upX", "upY", "<init>", "(IIIIII)V", "getWidth", "()I", "getHeight", "getDownX", "getDownY", "getUpX", "getUpY", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "Companion", "uikit_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TouchCapture {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT = -1;
    private final int downX;
    private final int downY;
    private final int height;
    private final int upX;
    private final int upY;
    private final int width;

    public TouchCapture() {
        this(0, 0, 0, 0, 0, 0, 63, null);
    }

    public static /* synthetic */ TouchCapture copy$default(TouchCapture touchCapture, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = touchCapture.width;
        }
        if ((i7 & 2) != 0) {
            i2 = touchCapture.height;
        }
        int i8 = i2;
        if ((i7 & 4) != 0) {
            i3 = touchCapture.downX;
        }
        int i9 = i3;
        if ((i7 & 8) != 0) {
            i4 = touchCapture.downY;
        }
        int i10 = i4;
        if ((i7 & 16) != 0) {
            i5 = touchCapture.upX;
        }
        int i11 = i5;
        if ((i7 & 32) != 0) {
            i6 = touchCapture.upY;
        }
        return touchCapture.copy(i, i8, i9, i10, i11, i6);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final int component3() {
        return this.downX;
    }

    public final int component4() {
        return this.downY;
    }

    public final int component5() {
        return this.upX;
    }

    public final int component6() {
        return this.upY;
    }

    public final TouchCapture copy(int i, int i2, int i3, int i4, int i5, int i6) {
        return new TouchCapture(i, i2, i3, i4, i5, i6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TouchCapture) {
            TouchCapture touchCapture = (TouchCapture) obj;
            return this.width == touchCapture.width && this.height == touchCapture.height && this.downX == touchCapture.downX && this.downY == touchCapture.downY && this.upX == touchCapture.upX && this.upY == touchCapture.upY;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.width * 31) + this.height) * 31) + this.downX) * 31) + this.downY) * 31) + this.upX) * 31) + this.upY;
    }

    public String toString() {
        int i = this.width;
        int i2 = this.height;
        int i3 = this.downX;
        int i4 = this.downY;
        int i5 = this.upX;
        return "TouchCapture(width=" + i + ", height=" + i2 + ", downX=" + i3 + ", downY=" + i4 + ", upX=" + i5 + ", upY=" + this.upY + ")";
    }

    public TouchCapture(int width, int height, int downX, int downY, int upX, int upY) {
        this.width = width;
        this.height = height;
        this.downX = downX;
        this.downY = downY;
        this.upX = upX;
        this.upY = upY;
    }

    public /* synthetic */ TouchCapture(int i, int i2, int i3, int i4, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i7 & 1) != 0 ? -1 : i, (i7 & 2) != 0 ? -1 : i2, (i7 & 4) != 0 ? -1 : i3, (i7 & 8) != 0 ? -1 : i4, (i7 & 16) != 0 ? -1 : i5, (i7 & 32) != 0 ? -1 : i6);
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getDownX() {
        return this.downX;
    }

    public final int getDownY() {
        return this.downY;
    }

    public final int getUpX() {
        return this.upX;
    }

    public final int getUpY() {
        return this.upY;
    }

    /* compiled from: TouchCaptureModifier.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkntr/app/ad/ui/uikit/modifiers/TouchCapture$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "DEFAULT", RoomRecommendViewModel.EMPTY_CURSOR, "uikit_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}