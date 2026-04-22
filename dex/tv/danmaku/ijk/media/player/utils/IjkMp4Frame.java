package tv.danmaku.ijk.media.player.utils;

import android.graphics.Bitmap;

public class IjkMp4Frame implements IIjkMp4Frame {
    private IjkBitmap mBitmap;

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMp4Frame
    public int getWidth() {
        if (this.mBitmap == null) {
            return 0;
        }
        return this.mBitmap.width;
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMp4Frame
    public int getHeight() {
        if (this.mBitmap == null) {
            return 0;
        }
        return this.mBitmap.height;
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMp4Frame
    public long getDurationMs() {
        if (this.mBitmap == null) {
            return 0L;
        }
        return this.mBitmap.duration;
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMp4Frame
    public int getXOffset() {
        return 0;
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMp4Frame
    public int getYOffset() {
        return 0;
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMp4Frame
    public void getRenderFrame(int width, int height, Bitmap bitmap) {
        if (this.mBitmap == null) {
            return;
        }
        this.mBitmap.render(width, height, bitmap);
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMp4Frame
    public void dispose() {
        if (this.mBitmap == null) {
            return;
        }
        this.mBitmap.release();
    }

    public IjkMp4Frame(IjkBitmap bitmap) {
        this.mBitmap = bitmap;
    }
}