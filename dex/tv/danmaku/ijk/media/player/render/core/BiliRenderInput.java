package tv.danmaku.ijk.media.player.render.core;

import tv.danmaku.ijk.media.player.render.tools.BiliSize;

public interface BiliRenderInput {
    boolean isEnable();

    boolean isShouldIgnoreUpdatesToThisTarget();

    BiliSize maximumOutputSize();

    void newFrameReady(long j, int i);

    int nextAvailableTextureIndex();

    void setBackgroundColor(float f, float f2, float f3, float f4);

    void setInputFrameBuffer(BiliFrameBuffer biliFrameBuffer, int i);

    void setInputRotation(BiliImageOrientation biliImageOrientation, int i);

    void setInputSize(BiliSize biliSize, int i);
}