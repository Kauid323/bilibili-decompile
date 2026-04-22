package tv.danmaku.ijk.media.player.render.filter;

import tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface;

public class BiliFrameNotifierFakeFilter extends BiliFilter {
    private final IJKEXTRendererInterface.OnFrameRenderedListener listener;

    public BiliFrameNotifierFakeFilter(IJKEXTRendererInterface.OnFrameRenderedListener listener) {
        this.listener = listener;
    }

    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter, tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public boolean isEnable() {
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter, tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void newFrameReady(long frameTimeUs, int textureIndex) {
        super.newFrameReady(frameTimeUs, textureIndex);
        this.listener.invoke(this.mOutputFrameBuffer.getTexture(), this.mOutputFrameBuffer.getWidth(), this.mOutputFrameBuffer.getHeight(), frameTimeUs);
    }
}