package tv.danmaku.ijk.media.player.render.tools;

public class BiliSizeF {
    public float height;
    public float width;

    public static BiliSizeF create(float width, float height) {
        return new BiliSizeF(width, height);
    }

    public BiliSizeF() {
    }

    public BiliSizeF(float w, float h) {
        this.width = w;
        this.height = h;
    }

    public BiliSize toSize() {
        BiliSize size = new BiliSize((int) this.width, (int) this.width);
        return size;
    }

    public BiliSize toSizeFloor() {
        BiliSize size = new BiliSize((int) Math.floor(this.width), (int) Math.floor(this.height));
        return size;
    }

    public BiliSize toSizeCeil() {
        BiliSize size = new BiliSize((int) Math.ceil(this.width), (int) Math.ceil(this.height));
        return size;
    }
}