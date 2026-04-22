package tv.danmaku.ijk.media.player.render.filter;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.ijk.media.player.render.cache.BiliFrameBufferCache;
import tv.danmaku.ijk.media.player.render.core.BiliRenderContext;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;

public class BiliTransFilter extends BiliFilter {
    public static final String BILI_VERTEX_SHADER = "attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;uniform mat4 model;uniform mat4 view;uniform mat4 projection;void main(){    gl_Position = projection * view * model * position;    textureCoordinate = inputTextureCoordinate.xy;}";
    private static final String TAG = "BiliTransFilter";
    private int mModelIndex;
    private float[] mModelMatrix;
    private int mProjectionIndex;
    private float[] mProjectionMatrix;
    private float mRatio;
    private BiliSize mSurfaceSize;
    private int mViewIndex;
    private float[] mViewMatrix;

    public BiliTransFilter() {
        super(BILI_VERTEX_SHADER, BiliFilter.BILI_PASSTHROUGH_FRAGMENT_SHADER);
        this.mProjectionMatrix = new float[16];
        this.mViewMatrix = new float[16];
        this.mModelMatrix = new float[16];
        this.mProjectionIndex = -1;
        this.mViewIndex = -1;
        this.mModelIndex = -1;
    }

    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter, tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void setInputSize(BiliSize newSize, int textureIndex) {
        super.setInputSize(newSize, textureIndex);
    }

    public void setGLSurfaceSize(BiliSize surfaceSize) {
        this.mSurfaceSize = surfaceSize;
        this.mRatio = surfaceSize.getRatioFloat();
        Matrix.setIdentityM(this.mProjectionMatrix, 0);
        Matrix.setIdentityM(this.mViewMatrix, 0);
        Matrix.setIdentityM(this.mModelMatrix, 0);
        Matrix.translateM(this.mViewMatrix, 0, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f);
        Matrix.translateM(this.mModelMatrix, 0, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        Matrix.rotateM(this.mModelMatrix, 0, 90.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f);
        Matrix.scaleM(this.mModelMatrix, 0, 1.0f, surfaceSize.getHeight() / surfaceSize.getWidth(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter
    public void onInitOnGLThread() {
        super.onInitOnGLThread();
        this.mProjectionIndex = this.mFilterProgram.uniformIndex("projection");
        if (this.mProjectionIndex < 0) {
            BLog.w(TAG, "mvp projection index is :" + this.mProjectionIndex);
        }
        this.mViewIndex = this.mFilterProgram.uniformIndex("view");
        if (this.mViewIndex < 0) {
            BLog.w(TAG, "mvp view index is :" + this.mViewIndex);
        }
        this.mModelIndex = this.mFilterProgram.uniformIndex("model");
        if (this.mModelIndex < 0) {
            BLog.w(TAG, "mvp model index is :" + this.mModelIndex);
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter, tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void newFrameReady(long frameTimeUs, int textureIndex) {
        super.newFrameReady(frameTimeUs, textureIndex);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter
    public void renderToTexture(FloatBuffer vertices, FloatBuffer textureCoordinates) {
        runPendingOnDrawTasks();
        BiliRenderContext.setActiveShaderProgram(this.mFilterProgram);
        BiliSize outputSize = sizeOfFBO();
        BiliFrameBufferCache framebufferCache = BiliRenderContext.sharedFramebufferCache();
        if (framebufferCache == null) {
            return;
        }
        this.mOutputFrameBuffer = framebufferCache.fetchFramebuffer(outputSize.getWidth(), outputSize.getHeight(), getOutputTextureOptions());
        this.mOutputFrameBuffer.use();
        if (this.mUsingNextFrameForImageCapture) {
            this.mOutputFrameBuffer.lock();
        }
        setUniformsForProgramAtIndex(0);
        setMatrix4f(this.mProjectionMatrix, this.mProjectionIndex, this.mFilterProgram);
        setMatrix4f(this.mViewMatrix, this.mViewIndex, this.mFilterProgram);
        setMatrix4f(this.mModelMatrix, this.mModelIndex, this.mFilterProgram);
        GLES20.glClearColor(this.mBackgroundColorRed, this.mBackgroundColorGreen, this.mBackgroundColorBlue, this.mBackgroundColorAlpha);
        GLES20.glClear(IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID);
        inputFramebufferBindTexture();
        GLES20.glEnableVertexAttribArray(this.mFilterPositionAttribute);
        GLES20.glEnableVertexAttribArray(this.mFilterTextureCoordinateAttribute);
        GLES20.glVertexAttribPointer(this.mFilterPositionAttribute, 2, 5126, false, 0, (Buffer) vertices);
        GLES20.glVertexAttribPointer(this.mFilterTextureCoordinateAttribute, 2, 5126, false, 0, (Buffer) textureCoordinates);
        GLES20.glDrawArrays(5, 0, 4);
        inputFramebufferUnlock();
    }
}