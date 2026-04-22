package tv.danmaku.ijk.media.player.render.output;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.ijk.media.player.render.core.BiliFrameBuffer;
import tv.danmaku.ijk.media.player.render.core.BiliImageOrientation;
import tv.danmaku.ijk.media.player.render.core.BiliProgram;
import tv.danmaku.ijk.media.player.render.core.BiliRenderContext;
import tv.danmaku.ijk.media.player.render.filter.BiliFilter;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;

public class BiliTerminalRenderer implements BiliSurfaceDisplay {
    public static final String TAG = "BiliTerminalRenderer";
    private float mBackgroundColorAlpha;
    private float mBackgroundColorBlue;
    private float mBackgroundColorGreen;
    private float mBackgroundColorRed;
    private int mDisplayInputTextureUniform;
    private int mDisplayPositionAttribute;
    protected BiliProgram mDisplayProgram;
    private int mDisplayTextureCoordinateAttribute;
    protected BiliFrameBuffer mInputFramebufferForDisplay;
    protected BiliSize mInputImageSize;
    private BiliImageOrientation mInputRotation;
    private BiliSize mOutputSize;
    private final BlockingQueue<Runnable> mRunOnDraw;
    private FloatBuffer mTextureBuffer;
    private FloatBuffer mVerticesBuffer;
    public static final float[] noRotationTextureCoordinates = {DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN};
    public static final float[] rotateRightTextureCoordinates = {1.0f, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN};
    public static final float[] rotateLeftTextureCoordinates = {DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f};
    public static final float[] verticalFlipTextureCoordinates = {DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, 1.0f};
    public static final float[] horizontalFlipTextureCoordinates = {1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN};
    public static final float[] rotateRightVerticalFlipTextureCoordinates = {1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f};
    public static final float[] rotateRightHorizontalFlipTextureCoordinates = {DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN};
    public static final float[] rotate180TextureCoordinates = {1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f};
    public static final float[] imageVertices = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    public static float[] textureCoordinates(BiliImageOrientation rotationMode) {
        if (rotationMode == null) {
            rotationMode = BiliImageOrientation.Up;
        }
        switch (rotationMode) {
            case Left:
                return rotateLeftTextureCoordinates;
            case Right:
                return rotateRightTextureCoordinates;
            case DownMirrored:
                return verticalFlipTextureCoordinates;
            case UpMirrored:
                return horizontalFlipTextureCoordinates;
            case RightMirrored:
                return rotateRightVerticalFlipTextureCoordinates;
            case LeftMirrored:
                return rotateRightHorizontalFlipTextureCoordinates;
            case Down:
                return rotate180TextureCoordinates;
            default:
                return noRotationTextureCoordinates;
        }
    }

    public BiliTerminalRenderer() {
        this(BiliFilter.BILI_PASSTHROUGH_FRAGMENT_SHADER);
    }

    public BiliTerminalRenderer(String fragmentShaderString) {
        this("attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}", fragmentShaderString);
    }

    public BiliTerminalRenderer(final String vertexShaderString, final String fragmentShaderString) {
        this.mInputImageSize = new BiliSize();
        this.mBackgroundColorAlpha = 1.0f;
        this.mRunOnDraw = new LinkedBlockingQueue();
        this.mInputRotation = BiliImageOrientation.Up;
        this.mVerticesBuffer = BiliFilter.buildBuffer(imageVertices);
        this.mTextureBuffer = BiliFilter.buildBuffer(noRotationTextureCoordinates);
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.output.BiliTerminalRenderer.1
            @Override // java.lang.Runnable
            public void run() {
                BiliTerminalRenderer.this._initOnGLThread(vertexShaderString, fragmentShaderString);
                BiliTerminalRenderer.this.onInitOnGLThread();
            }
        });
    }

    protected void onInitOnGLThread() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _initOnGLThread(String vertexShaderString, String fragmentShaderString) {
        this.mDisplayProgram = BiliRenderContext.program(vertexShaderString, fragmentShaderString);
        if (!this.mDisplayProgram.isInitialized() && !this.mDisplayProgram.isValidate()) {
            BLog.e("BiliTerminalRenderer", "DisplayProgram is error !");
            this.mDisplayProgram = null;
            return;
        }
        this.mDisplayPositionAttribute = this.mDisplayProgram.attributeIndex("position");
        this.mDisplayTextureCoordinateAttribute = this.mDisplayProgram.attributeIndex("inputTextureCoordinate");
        this.mDisplayInputTextureUniform = this.mDisplayProgram.uniformIndex("inputImageTexture");
        BiliRenderContext.setActiveShaderProgram(this.mDisplayProgram);
        GLES20.glEnableVertexAttribArray(this.mDisplayPositionAttribute);
        GLES20.glEnableVertexAttribArray(this.mDisplayTextureCoordinateAttribute);
    }

    private void renderToTexture(long frameTime, FloatBuffer vertices, FloatBuffer textureCoordinates) {
        if (this.mInputFramebufferForDisplay == null) {
            return;
        }
        BiliRenderContext.setActiveShaderProgram(this.mDisplayProgram);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, maximumOutputSize().getWidth(), maximumOutputSize().getHeight());
        GLES20.glClearColor(this.mBackgroundColorRed, this.mBackgroundColorGreen, this.mBackgroundColorBlue, this.mBackgroundColorAlpha);
        GLES20.glClear(16640);
        GLES20.glActiveTexture(33988);
        GLES20.glBindTexture(3553, getInputFramebufferTexture());
        GLES20.glUniform1i(this.mDisplayInputTextureUniform, 4);
        GLES20.glVertexAttribPointer(this.mDisplayPositionAttribute, 2, 5126, false, 0, (Buffer) vertices);
        GLES20.glVertexAttribPointer(this.mDisplayTextureCoordinateAttribute, 2, 5126, false, 0, (Buffer) textureCoordinates);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(3553, 0);
    }

    private void releaseInputFrameBuffer() {
        if (this.mInputFramebufferForDisplay == null) {
            return;
        }
        this.mInputFramebufferForDisplay.unlock();
    }

    private int getInputFramebufferTexture() {
        if (this.mInputFramebufferForDisplay == null) {
            return 0;
        }
        int textId = this.mInputFramebufferForDisplay.getTexture();
        return textId;
    }

    @Override // tv.danmaku.ijk.media.player.render.output.BiliSurfaceDisplay
    public void newFrameReadyInGLThread(long frameTimeUs) {
        runPendingOnDrawTasks();
    }

    @Override // tv.danmaku.ijk.media.player.render.output.BiliSurfaceDisplay
    public void duplicateFrameReadyInGLThread(long frameTimeUs) {
        if (this.mInputFramebufferForDisplay == null) {
            return;
        }
        renderToTexture(frameTimeUs, this.mVerticesBuffer, this.mTextureBuffer);
    }

    @Override // tv.danmaku.ijk.media.player.render.output.BiliSurfaceDisplay
    public void destroy() {
        releaseInputFrameBuffer();
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void newFrameReady(long frameTimeUs, int textureIndex) {
        this.mTextureBuffer.clear();
        this.mTextureBuffer.put(textureCoordinates(this.mInputRotation)).position(0);
        if (this.mOutputSize == null) {
            this.mOutputSize = this.mInputImageSize;
        }
        runPendingOnDrawTasks();
        renderToTexture(frameTimeUs, this.mVerticesBuffer, this.mTextureBuffer);
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void setInputFrameBuffer(BiliFrameBuffer newInputframeBuffer, int textureIndex) {
        if (newInputframeBuffer == null) {
            return;
        }
        releaseInputFrameBuffer();
        this.mInputFramebufferForDisplay = newInputframeBuffer;
        this.mInputFramebufferForDisplay.lock();
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public int nextAvailableTextureIndex() {
        return 0;
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void setInputSize(BiliSize inputSize, int textureIndex) {
        if (inputSize == null || !inputSize.isSize()) {
            return;
        }
        BiliSize rotatedSize = inputSize.copy();
        if (this.mInputRotation.isTransposed()) {
            rotatedSize.setWidth(inputSize.getHeight());
            rotatedSize.setHeight(inputSize.getWidth());
        }
        if (this.mInputImageSize.equals(rotatedSize)) {
            return;
        }
        this.mInputImageSize = rotatedSize;
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void setInputRotation(BiliImageOrientation inputRotation, int textureIndex) {
        if (inputRotation == null) {
            return;
        }
        this.mInputRotation = inputRotation;
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public BiliSize maximumOutputSize() {
        return this.mOutputSize == null ? this.mInputImageSize : this.mOutputSize;
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public boolean isShouldIgnoreUpdatesToThisTarget() {
        return false;
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public boolean isEnable() {
        return true;
    }

    protected void runPendingOnDrawTasks() {
        while (!this.mRunOnDraw.isEmpty()) {
            try {
                this.mRunOnDraw.take().run();
            } catch (InterruptedException e) {
                BLog.e("BiliTerminalRenderer", e.getMessage());
            }
        }
    }

    protected boolean isOnDrawTasksEmpty() {
        return this.mRunOnDraw.isEmpty();
    }

    protected void runOnDraw(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        synchronized (this.mRunOnDraw) {
            this.mRunOnDraw.add(runnable);
        }
    }

    public void setOutputSize(BiliSize biliSize) {
        this.mOutputSize = biliSize;
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void setBackgroundColor(float red, float green, float blue, float alpha) {
        this.mBackgroundColorRed = red;
        this.mBackgroundColorGreen = green;
        this.mBackgroundColorBlue = blue;
        this.mBackgroundColorAlpha = alpha;
    }
}