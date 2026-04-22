package tv.danmaku.ijk.media.player.render.tools;

import android.graphics.Bitmap;
import android.graphics.Rect;
import tv.danmaku.ijk.media.player.render.tools.hardware.BiliGPU;

public class BiliSize {
    public int height;
    public int width;

    public static BiliSize create(Bitmap image) {
        if (image != null) {
            return new BiliSize(image.getWidth(), image.getHeight());
        }
        return null;
    }

    public static BiliSize create(BiliSize size) {
        if (size != null) {
            return new BiliSize(size.getWidth(), size.getHeight());
        }
        return null;
    }

    public static BiliSize create(int width, int height) {
        return new BiliSize(width, height);
    }

    public BiliSize() {
    }

    public BiliSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static BiliSize create(Rect rect) {
        if (rect != null) {
            return new BiliSize(rect.width(), rect.height());
        }
        return null;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BiliSize limitSize() {
        return limitSize(BiliGPU.getMaxTextureOptimizedSize());
    }

    private BiliSize limitSize(int limit) {
        if (limit <= 0 || !isSize() || limit >= maxSide()) {
            return evenSize();
        }
        BiliSize adjustedSize = create(this);
        if (this.width > this.height) {
            adjustedSize.width = limit;
            adjustedSize.height = (int) Math.floor((limit / this.width) * this.height);
        } else {
            adjustedSize.height = limit;
            adjustedSize.width = (int) Math.floor((limit / this.height) * this.width);
        }
        return adjustedSize.evenSize();
    }

    public float getRatioFloat() {
        return this.width / this.height;
    }

    public BiliSize maxSize() {
        int side = maxSide();
        return new BiliSize(side, side);
    }

    public int maxSide() {
        return Math.max(this.width, this.height);
    }

    public BiliSize minSize() {
        int side = minSide();
        return new BiliSize(side, side);
    }

    public int minSide() {
        return Math.min(this.width, this.height);
    }

    public boolean isSize() {
        return minSide() > 0;
    }

    public float maxMinRatio() {
        return maxSide() / minSide();
    }

    public float minMaxRatio() {
        return minSide() / maxSide();
    }

    public float diagonal() {
        float result = (float) Math.sqrt((this.width * this.width) + (this.height * this.height));
        return result;
    }

    public boolean equals(Object obj) {
        if (obj instanceof BiliSize) {
            BiliSize s = (BiliSize) obj;
            return this.width == s.width && this.height == s.height;
        }
        return false;
    }

    public int hashCode() {
        return (this.width * 32713) + this.height;
    }

    public String toString() {
        String info = String.format("{width: %s, height:%s };", Integer.valueOf(this.width), Integer.valueOf(this.height));
        return info;
    }

    public BiliSize copy() {
        return new BiliSize(this.width, this.height);
    }

    public BiliSize evenSize() {
        BiliSize adjustedSize = create(this);
        if (adjustedSize.width % 2 != 0) {
            adjustedSize.width--;
        }
        if (adjustedSize.height % 2 != 0) {
            adjustedSize.height--;
        }
        return adjustedSize;
    }
}