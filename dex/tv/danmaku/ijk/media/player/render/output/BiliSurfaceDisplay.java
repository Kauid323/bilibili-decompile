package tv.danmaku.ijk.media.player.render.output;

import tv.danmaku.ijk.media.player.render.core.BiliRenderInput;

public interface BiliSurfaceDisplay extends BiliRenderInput {
    void destroy();

    void duplicateFrameReadyInGLThread(long j);

    void newFrameReadyInGLThread(long j);
}