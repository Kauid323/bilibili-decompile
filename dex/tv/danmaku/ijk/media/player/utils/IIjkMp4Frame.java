package tv.danmaku.ijk.media.player.utils;

import android.graphics.Bitmap;

public interface IIjkMp4Frame {
    void dispose();

    long getDurationMs();

    int getHeight();

    void getRenderFrame(int i, int i2, Bitmap bitmap);

    int getWidth();

    int getXOffset();

    int getYOffset();
}