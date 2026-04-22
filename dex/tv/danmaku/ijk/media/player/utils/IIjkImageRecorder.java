package tv.danmaku.ijk.media.player.utils;

public interface IIjkImageRecorder {
    long getDuration();

    long[] getDurations();

    IjkBitmap getFrame(int i);

    int getHeight();

    int getWidth();

    void release();
}