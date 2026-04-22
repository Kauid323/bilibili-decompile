package tv.danmaku.ijk.media.player.render.output;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.ijk.media.player.render.core.BiliFrameBuffer;
import tv.danmaku.ijk.media.player.render.core.BiliImageOrientation;
import tv.danmaku.ijk.media.player.render.core.BiliProgram;
import tv.danmaku.ijk.media.player.render.core.BiliRenderContext;
import tv.danmaku.ijk.media.player.render.extend.BiliTextureSizeAlign;
import tv.danmaku.ijk.media.player.render.filter.BiliFilter;
import tv.danmaku.ijk.media.player.render.tools.BiliPipeTask;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;
import tv.danmaku.ijk.media.player.render.transform.BiliMVPMatrix;

public class BiliTerminalOprationRenderer implements BiliSurfaceDisplay {
    public static final String BILI_OPRATION_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;uniform sampler2D inputImageTexture;void main(){     gl_FragColor = texture2D(inputImageTexture,textureCoordinate);}";
    public static final String BILI_OPRATION_SHADER = "attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;uniform mat4 matrix;void main(){    gl_Position =matrix * position;    textureCoordinate = inputTextureCoordinate.xy;}";
    public static final String TAG = "BiliTerminalRenderer";
    public static final int VERTICES_FOR_IMAGE = 0;
    public static final int VERTICES_FOR_INPUT = 1;
    protected float mBackgroundColorAlpha;
    protected float mBackgroundColorBlue;
    protected float mBackgroundColorGreen;
    protected float mBackgroundColorRed;
    private BiliRenderImage mBackgroundImageRender;
    protected int mDisplayInputTextureUniform;
    protected int mDisplayPositionAttribute;
    protected BiliProgram mDisplayProgram;
    protected volatile Rect mDisplayRect;
    protected int mDisplayTextureCoordinateAttribute;
    protected BiliFrameBuffer mInputFramebufferForDisplay;
    protected BiliSize mInputImageSize;
    private BiliImageOrientation mInputRotation;
    protected BiliMVPMatrix mMVPMatrix;
    protected int mMatrixIndex;
    private BiliSize mOutputSize;
    private final BiliPipeTask mRunOnDraw;
    private FloatBuffer mTextureBuffer;
    private FloatBuffer mVerticesBuffer;
    protected int mVerticesMode;
    public static final float[] noRotationTextureCoordinates = {DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN};
    public static final float[] rotateRightTextureCoordinates = {1.0f, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN};
    public static final float[] rotateLeftTextureCoordinates = {DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f};
    public static final float[] verticalFlipTextureCoordinates = {DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, 1.0f};
    public static final float[] horizontalFlipTextureCoordinates = {1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN};
    public static final float[] rotateRightVerticalFlipTextureCoordinates = {1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f};
    public static final float[] rotateRightHorizontalFlipTextureCoordinates = {DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN};
    public static final float[] rotate180TextureCoordinates = {1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f};
    public static final float[] imageVertices = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] mtxFlipV = {1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, -1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f};

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

    public BiliTerminalOprationRenderer() {
        this("varying highp vec2 textureCoordinate;uniform sampler2D inputImageTexture;void main(){     gl_FragColor = texture2D(inputImageTexture,textureCoordinate);}");
    }

    public BiliTerminalOprationRenderer(String fragmentShaderString) {
        this(BILI_OPRATION_SHADER, fragmentShaderString);
    }

    public BiliTerminalOprationRenderer(final String vertexShaderString, final String fragmentShaderString) {
        this.mVerticesMode = 0;
        this.mInputImageSize = new BiliSize();
        this.mBackgroundColorAlpha = 1.0f;
        this.mMatrixIndex = -1;
        this.mRunOnDraw = new BiliPipeTask();
        this.mInputRotation = BiliImageOrientation.Up;
        this.mVerticesBuffer = BiliFilter.buildBuffer(imageVertices);
        this.mTextureBuffer = BiliFilter.buildBuffer(noRotationTextureCoordinates);
        this.mBackgroundImageRender = new BiliRenderImage();
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.output.BiliTerminalOprationRenderer.1
            @Override // java.lang.Runnable
            public void run() {
                BiliTerminalOprationRenderer.this._initOnGLThread(vertexShaderString, fragmentShaderString);
                BiliTerminalOprationRenderer.this.onInitOnGLThread();
                BiliTerminalOprationRenderer.this.mBackgroundImageRender.initOnGLThread();
            }
        });
    }

    public void setMatrix(BiliMVPMatrix matrix) {
        this.mMVPMatrix = matrix;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onInitOnGLThread() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _initOnGLThread(String vertexShaderString, String fragmentShaderString) {
        this.mDisplayProgram = BiliProgram.create(vertexShaderString, fragmentShaderString);
        if (!this.mDisplayProgram.isInitialized() && !this.mDisplayProgram.isValidate()) {
            BLog.e("BiliTerminalRenderer", "DisplayProgram is error !");
            this.mDisplayProgram = null;
            return;
        }
        this.mDisplayPositionAttribute = this.mDisplayProgram.attributeIndex("position");
        this.mDisplayTextureCoordinateAttribute = this.mDisplayProgram.attributeIndex("inputTextureCoordinate");
        this.mDisplayInputTextureUniform = this.mDisplayProgram.uniformIndex("inputImageTexture");
        this.mMatrixIndex = this.mDisplayProgram.uniformIndex(BiliMVPMatrix.BILI_MATRIX);
        BiliRenderContext.setActiveShaderProgram(this.mDisplayProgram);
        GLES20.glEnableVertexAttribArray(this.mDisplayPositionAttribute);
        GLES20.glEnableVertexAttribArray(this.mDisplayTextureCoordinateAttribute);
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void newFrameReady(long frameTimeUs, int textureIndex) {
        this.mTextureBuffer.clear();
        this.mTextureBuffer.put(textureCoordinates(this.mInputRotation)).position(0);
        if (this.mOutputSize == null) {
            this.mOutputSize = this.mInputImageSize;
        }
        runPendingOnDrawTasks();
        if (this.mVerticesMode == 0) {
            getMVPMatrix().mapTextureToVertex(this.mInputImageSize, this.mOutputSize, this.mVerticesBuffer);
        } else if (this.mVerticesMode == 1) {
            getMVPMatrix().mapVerticesFromRect(this.mDisplayRect, this.mOutputSize, this.mVerticesBuffer);
        }
        renderToTexture(frameTimeUs, this.mVerticesBuffer, this.mTextureBuffer);
    }

    public void setVerticesModel(final int model) {
        if (model == 0 || model == 1) {
            BLog.i("BiliTerminalRenderer", "setVerticesModel : " + model);
            runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.output.BiliTerminalOprationRenderer.2
                @Override // java.lang.Runnable
                public void run() {
                    BiliTerminalOprationRenderer.this.mVerticesMode = model;
                }
            });
            return;
        }
        BLog.e("BiliTerminalRenderer", "set vertices model invalid ！" + model);
    }

    public void setDisplayRect(Rect rect) {
        BLog.i("BiliTerminalRenderer", "setDisplayRect : " + rect);
        this.mDisplayRect = rect;
    }

    protected void renderToTexture(long frameTime, FloatBuffer vertices, FloatBuffer textureCoordinates) {
        float[] matrix;
        if (this.mInputFramebufferForDisplay == null) {
            return;
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, maximumOutputSize().getWidth(), maximumOutputSize().getHeight());
        GLES20.glClearColor(this.mBackgroundColorRed, this.mBackgroundColorGreen, this.mBackgroundColorBlue, this.mBackgroundColorAlpha);
        GLES20.glClear(16640);
        this.mBackgroundImageRender.drawImage();
        BiliRenderContext.setActiveShaderProgram(this.mDisplayProgram);
        GLES20.glActiveTexture(33988);
        GLES20.glBindTexture(3553, getInputFramebufferTexture());
        GLES20.glUniform1i(this.mDisplayInputTextureUniform, 4);
        if (this.mMatrixIndex == -1) {
            BLog.e("BiliTerminalRenderer", "Matrix index is -1 !");
        }
        switch (this.mVerticesMode) {
            case 0:
                matrix = this.mMVPMatrix.getMatrix();
                break;
            case 1:
                matrix = this.mMVPMatrix.getMatrixForInput();
                break;
            default:
                matrix = this.mMVPMatrix.getMatrix();
                break;
        }
        GLES20.glUniformMatrix4fv(this.mMatrixIndex, 1, false, matrix, 0);
        GLES20.glEnableVertexAttribArray(this.mDisplayPositionAttribute);
        GLES20.glEnableVertexAttribArray(this.mDisplayTextureCoordinateAttribute);
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
        this.mInputFramebufferForDisplay = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getInputFramebufferTexture() {
        if (this.mInputFramebufferForDisplay == null) {
            return 0;
        }
        int textId = this.mInputFramebufferForDisplay.getTexture();
        return textId;
    }

    public BiliFrameBuffer getInputFrameBuffer() {
        return this.mInputFramebufferForDisplay;
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
        if (this.mBackgroundImageRender != null) {
            this.mBackgroundImageRender.destroy();
        }
        if (this.mDisplayProgram != null) {
            this.mDisplayProgram.destroy();
        }
        if (this.mRunOnDraw != null) {
            this.mRunOnDraw.clearTask();
        }
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
        this.mInputImageSize = BiliTextureSizeAlign.Align2MultipleMin.align(inputSize);
        getMVPMatrix().setTextureSize(this.mInputImageSize.width, this.mInputImageSize.height);
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void setBackgroundColor(float red, float green, float blue, float alpha) {
        this.mBackgroundColorRed = red;
        this.mBackgroundColorGreen = green;
        this.mBackgroundColorBlue = blue;
        this.mBackgroundColorAlpha = alpha;
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
        this.mRunOnDraw.runPendingOnDrawTasks();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runOnDraw(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.mRunOnDraw.addTask(runnable);
    }

    public void setGLScreenSizeSize(BiliSize biliSize) {
        this.mOutputSize = biliSize;
        getMVPMatrix().setScreenSize(biliSize.width, biliSize.height);
        this.mBackgroundImageRender.setScreenSize(biliSize);
    }

    public BiliMVPMatrix getMVPMatrix() {
        if (this.mMVPMatrix == null) {
            this.mMVPMatrix = new BiliMVPMatrix();
        }
        return this.mMVPMatrix;
    }

    public void setBackgroundImage(final Bitmap bitmap, final boolean recycle, final Rect displayRect) {
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.output.BiliTerminalOprationRenderer.3
            @Override // java.lang.Runnable
            public void run() {
                BLog.i("BiliTerminalRenderer", "setBackgroundImage " + displayRect);
                BiliTerminalOprationRenderer.this.mBackgroundImageRender.setBackgroundBitmap(bitmap, recycle, displayRect);
            }
        });
    }
}