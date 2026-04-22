package tv.danmaku.ijk.media.player.utils;

public interface IIjkMp4Image {
    void dispose();

    boolean doesRenderSupportScaling();

    long getDuration();

    IIjkMp4Frame getFrame(int i);

    int getFrameCount();

    long[] getFrameDurations();

    IjkMp4FrameInfo getFrameInfo(int i);

    int getHeight();

    int getLoopCount();

    int getSizeInBytes();

    int getWidth();
}