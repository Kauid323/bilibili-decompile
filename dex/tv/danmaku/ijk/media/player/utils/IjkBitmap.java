package tv.danmaku.ijk.media.player.utils;

import android.graphics.Bitmap;

public class IjkBitmap {
    public long bitmap;
    public long duration;
    public int height;
    public int width;

    public void render(int width, int height, Bitmap bitmap) {
        IjkImageRecorder.transformBitmap(bitmap, width, height, this.bitmap, this.width, this.height);
    }

    public void release() {
        if (this.bitmap != 0) {
            IjkImageRecorder.releaseBitmap(this.bitmap);
        }
        this.width = 0;
        this.height = 0;
        this.duration = 0L;
    }
}