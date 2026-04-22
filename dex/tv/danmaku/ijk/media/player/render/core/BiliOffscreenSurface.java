package tv.danmaku.ijk.media.player.render.core;

public class BiliOffscreenSurface extends EglSurfaceBase {
    public BiliOffscreenSurface(EglCore eglCore, int width, int height) {
        super(eglCore);
        createOffscreenSurface(width, height);
    }

    public void release() {
        releaseEglSurface();
    }
}