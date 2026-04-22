package tv.danmaku.ijk.media.player.render.filter;

import android.graphics.RectF;
import android.opengl.GLES20;
import android.view.Surface;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.ijk.media.player.render.core.BiliEGLContext;
import tv.danmaku.ijk.media.player.render.core.BiliFrameBuffer;
import tv.danmaku.ijk.media.player.render.core.BiliProgram;
import tv.danmaku.ijk.media.player.render.core.BiliRenderContext;
import tv.danmaku.ijk.media.player.render.core.GlUtil;
import tv.danmaku.ijk.media.player.render.output.BiliSubWindowRenderer;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;

public class BiliMultiRenderFilter extends BiliFilter {
    private boolean isMainRectChanged;
    private boolean isSubWindowRectChanged;
    private Surface mSubSurface;
    private RectF mSubSurfaceRect;
    private BiliSubWindowRenderer mSubWindowRenderer;
    private RectF mainScreenRect;
    private final FloatBuffer mMainWindowCoordinates = GlUtil.createFloatBuffer(noRotationTextureCoordinates);
    private final FloatBuffer mSubWindowCoordinates = GlUtil.createFloatBuffer(noRotationTextureCoordinates);
    private final FloatBuffer mSubVertex = BiliFilter.buildBuffer(imageVertices);

    public void setMainScreenRect(RectF rect) {
        BLog.i(BiliFilter.TAG, "setMainScreenRect() " + rect);
        if (rect.width() <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN || rect.height() <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            BLog.e(BiliFilter.TAG, "invalid rect : " + rect);
        } else if (this.mainScreenRect == rect) {
            BLog.w(BiliFilter.TAG, "same rect !");
        } else {
            this.isMainRectChanged = true;
            this.mainScreenRect = rect;
            BLog.i(BiliFilter.TAG, "setMainScreenRect() end()" + rect);
        }
    }

    public void setSubWindowSurface(Surface surface) {
        BLog.i(BiliFilter.TAG, "setSubWindowSurface() " + surface);
        this.mSubSurface = surface;
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliMultiRenderFilter.1
            @Override // java.lang.Runnable
            public void run() {
                BiliMultiRenderFilter.this.mSubWindowRenderer.setSurface(BiliMultiRenderFilter.this.mSubSurface);
            }
        });
        BLog.i(BiliFilter.TAG, "setSubWindowSurface() end() " + surface);
    }

    public void setSubWindowCaptureRect(RectF rect) {
        BLog.i(BiliFilter.TAG, "setSecondWindow() end() rect:" + rect);
        if (rect.width() <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN || rect.height() <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            BLog.e(BiliFilter.TAG, "invalid rect : " + rect);
        } else if (this.mainScreenRect == rect) {
            BLog.w(BiliFilter.TAG, "same rect !");
        } else {
            this.mSubSurfaceRect = rect;
            this.isSubWindowRectChanged = true;
            BLog.i(BiliFilter.TAG, "setSecondWindow() end() rect:" + rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter
    public void onInitOnGLThread() {
        super.onInitOnGLThread();
        if (this.mSubWindowRenderer == null) {
            this.mSubWindowRenderer = new BiliSubWindowRenderer();
            this.mSubWindowRenderer.prepare(BiliEGLContext.currentEGLContext());
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter, tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void setInputSize(BiliSize newSize, int textureIndex) {
        super.setInputSize(newSize, textureIndex);
    }

    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter, tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public BiliSize maximumOutputSize() {
        if (this.mainScreenRect == null) {
            return new BiliSize();
        }
        int out_width = (int) (this.mInputTextureSize.width * this.mainScreenRect.width());
        int out_height = (int) (this.mInputTextureSize.height * this.mainScreenRect.height());
        return new BiliSize(out_width, out_height);
    }

    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter
    public BiliSize outputFrameSize() {
        if (this.mainScreenRect == null) {
            return new BiliSize();
        }
        int out_width = (int) (this.mInputTextureSize.width * this.mainScreenRect.width());
        int out_height = (int) (this.mInputTextureSize.height * this.mainScreenRect.height());
        return new BiliSize(out_width, out_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter
    public void renderToTexture(FloatBuffer vertices, FloatBuffer textureCoordinates) {
        final BiliFrameBuffer capturedInputFbo = this.mFirstInputFramebuffer;
        if (capturedInputFbo != null) {
            capturedInputFbo.lock();
        }
        if (this.isMainRectChanged) {
            this.mMainWindowCoordinates.clear();
            float texLeft = this.mainScreenRect.left;
            float texRight = this.mainScreenRect.right;
            float texTop = this.mainScreenRect.bottom;
            float texBottom = this.mainScreenRect.top;
            this.mMainWindowCoordinates.put(new float[]{texLeft, texBottom, texRight, texBottom, texLeft, texTop, texRight, texTop});
            this.mMainWindowCoordinates.position(0);
            this.isMainRectChanged = false;
        }
        super.renderToTexture(vertices, this.mMainWindowCoordinates);
        this.mSubWindowRenderer.renderTextureWidthRect(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliMultiRenderFilter.2
            @Override // java.lang.Runnable
            public void run() {
                BiliFrameBuffer biliFrameBuffer;
                if (BiliMultiRenderFilter.this.isSubWindowRectChanged) {
                    BiliMultiRenderFilter.this.mSubWindowCoordinates.clear();
                    float texLeft2 = BiliMultiRenderFilter.this.mSubSurfaceRect.left;
                    float texRight2 = BiliMultiRenderFilter.this.mSubSurfaceRect.right;
                    float texTop2 = BiliMultiRenderFilter.this.mSubSurfaceRect.top;
                    float texBottom2 = BiliMultiRenderFilter.this.mSubSurfaceRect.bottom;
                    BiliMultiRenderFilter.this.mSubWindowCoordinates.put(new float[]{texLeft2, texBottom2, texRight2, texBottom2, texLeft2, texTop2, texRight2, texTop2});
                    BiliMultiRenderFilter.this.mSubWindowCoordinates.position(0);
                    BiliMultiRenderFilter.this.isSubWindowRectChanged = false;
                }
                try {
                    BiliProgram subProgram = BiliRenderContext.program("attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}", BiliFilter.BILI_PASSTHROUGH_FRAGMENT_SHADER);
                    if (subProgram == null) {
                        if (biliFrameBuffer != null) {
                            return;
                        }
                        return;
                    }
                    BiliRenderContext.setActiveShaderProgram(subProgram);
                    GLES20.glClearColor(BiliMultiRenderFilter.this.mBackgroundColorRed, BiliMultiRenderFilter.this.mBackgroundColorGreen, BiliMultiRenderFilter.this.mBackgroundColorBlue, BiliMultiRenderFilter.this.mBackgroundColorAlpha);
                    GLES20.glClear(IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID);
                    GLES20.glActiveTexture(33986);
                    GLES20.glBindTexture(3553, capturedInputFbo == null ? 0 : capturedInputFbo.getTexture());
                    int sampler = subProgram.uniformIndex("inputImageTexture");
                    GLES20.glUniform1i(sampler, 2);
                    int posAttr = subProgram.attributeIndex("position");
                    int texAttr = subProgram.attributeIndex("inputTextureCoordinate");
                    GLES20.glEnableVertexAttribArray(posAttr);
                    GLES20.glEnableVertexAttribArray(texAttr);
                    GLES20.glVertexAttribPointer(posAttr, 2, 5126, false, 0, (Buffer) BiliMultiRenderFilter.this.mSubVertex);
                    GLES20.glVertexAttribPointer(texAttr, 2, 5126, false, 0, (Buffer) BiliMultiRenderFilter.this.mSubWindowCoordinates);
                    GLES20.glDrawArrays(5, 0, 4);
                    if (capturedInputFbo != null) {
                        capturedInputFbo.unlock();
                    }
                } finally {
                    if (capturedInputFbo != null) {
                        capturedInputFbo.unlock();
                    }
                }
            }
        });
    }

    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter, tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public boolean isEnable() {
        return true;
    }

    public void release() {
        if (this.mSubWindowRenderer != null) {
            this.mSubWindowRenderer.release();
            this.mSubWindowRenderer = null;
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.mSubWindowRenderer != null) {
            this.mSubWindowRenderer.release();
            this.mSubWindowRenderer = null;
        }
    }
}