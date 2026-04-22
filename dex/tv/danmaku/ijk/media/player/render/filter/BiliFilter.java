package tv.danmaku.ijk.media.player.render.filter;

import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.ijk.media.player.render.cache.BiliFrameBufferCache;
import tv.danmaku.ijk.media.player.render.core.BiliFrameBuffer;
import tv.danmaku.ijk.media.player.render.core.BiliImageOrientation;
import tv.danmaku.ijk.media.player.render.core.BiliOutInput;
import tv.danmaku.ijk.media.player.render.core.BiliProgram;
import tv.danmaku.ijk.media.player.render.core.BiliRenderContext;
import tv.danmaku.ijk.media.player.render.core.BiliRenderInput;
import tv.danmaku.ijk.media.player.render.core.GlUtil;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;
import tv.danmaku.ijk.media.player.render.tools.BiliSizeF;
import tv.danmaku.ijk.media.player.render.tools.RectHelper;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;

public class BiliFilter extends BiliOutInput {
    public static final String BILI_PASSTHROUGH_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;uniform sampler2D inputImageTexture;void main(){     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);}";
    public static final String BILI_VERTEX_SHADER = "attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}";
    public static final String TAG = "BiliFilter";
    protected float mBackgroundColorAlpha;
    protected float mBackgroundColorBlue;
    protected float mBackgroundColorGreen;
    protected float mBackgroundColorRed;
    private final Map<BiliRenderInput, Integer> mEnableCache;
    protected int mFilterInputTextureUniform;
    protected int mFilterPositionAttribute;
    protected BiliProgram mFilterProgram;
    protected int mFilterTextureCoordinateAttribute;
    protected BiliFrameBuffer mFirstInputFramebuffer;
    protected BiliImageOrientation mInputRotation;
    protected final FloatBuffer mTextureBuffer;
    protected final Map<Integer, Runnable> mUniformStateRestorationBlocks;
    protected final FloatBuffer mVerticesBuffer;
    public static final float[] noRotationTextureCoordinates = {DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, 1.0f};
    public static final float[] rotateLeftTextureCoordinates = {1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f};
    public static final float[] rotateRightTextureCoordinates = {DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN};
    public static final float[] verticalFlipTextureCoordinates = {DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN};
    public static final float[] horizontalFlipTextureCoordinates = {1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f};
    public static final float[] rotateRightVerticalFlipTextureCoordinates = {DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f};
    public static final float[] rotateRightHorizontalFlipTextureCoordinates = {1.0f, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN};
    public static final float[] rotate180TextureCoordinates = {1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN};
    public static final float[] imageVertices = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    public BiliFilter() {
        this(BILI_PASSTHROUGH_FRAGMENT_SHADER);
    }

    public BiliFilter(String fragmentShader) {
        this("attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}", fragmentShader);
    }

    public BiliFilter(final String vertexShaderString, final String fragmentShaderString) {
        this.mUniformStateRestorationBlocks = new HashMap();
        this.mBackgroundColorAlpha = 1.0f;
        this.mInputRotation = BiliImageOrientation.Up;
        this.mEnableCache = new LinkedHashMap();
        this.mVerticesBuffer = GlUtil.createFloatBuffer(imageVertices);
        this.mTextureBuffer = GlUtil.createFloatBuffer(noRotationTextureCoordinates);
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.1
            @Override // java.lang.Runnable
            public void run() {
                BiliFilter.this._initOnGLThread(vertexShaderString, fragmentShaderString);
                BiliFilter.this.onInitOnGLThread();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onInitOnGLThread() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _initOnGLThread(String vertexShaderString, String fragmentShaderString) {
        this.mFilterProgram = BiliRenderContext.program(vertexShaderString, fragmentShaderString);
        if (this.mFilterProgram == null) {
            BLog.e(TAG, "Program is null !");
        } else if (!this.mFilterProgram.isInitialized() && !this.mFilterProgram.isValidate()) {
            BLog.e(TAG, "Program is in validate !");
        } else {
            this.mFilterPositionAttribute = this.mFilterProgram.attributeIndex("position");
            this.mFilterTextureCoordinateAttribute = this.mFilterProgram.attributeIndex("inputTextureCoordinate");
            this.mFilterInputTextureUniform = this.mFilterProgram.uniformIndex("inputImageTexture");
            BiliRenderContext.setActiveShaderProgram(this.mFilterProgram);
            GLES20.glEnableVertexAttribArray(this.mFilterPositionAttribute);
            GLES20.glEnableVertexAttribArray(this.mFilterTextureCoordinateAttribute);
        }
    }

    public void setupFilterForSize(BiliSize filterFrameSize) {
    }

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

    /* JADX INFO: Access modifiers changed from: protected */
    public void informTargetsAboutNewFrame(long frameTime) {
        this.mEnableCache.clear();
        for (BiliRenderInput currentTarget : this.mTargets) {
            if (currentTarget.isEnable()) {
                int indexOfObject = this.mTargets.indexOf(currentTarget);
                int textureIndex = this.mTargetTextureIndices.get(indexOfObject).intValue();
                this.mEnableCache.put(currentTarget, Integer.valueOf(textureIndex));
                setInputFramebufferForTarget(currentTarget, textureIndex);
                currentTarget.setInputSize(outputFrameSize(), textureIndex);
            }
        }
        try {
            if (getOutputFrameBuffer() != null) {
                getOutputFrameBuffer().unlock();
            }
        } catch (NullPointerException e) {
        }
        if (this.mUsingNextFrameForImageCapture) {
            removeOutputFramebuffer();
        }
        for (Map.Entry<BiliRenderInput, Integer> item : this.mEnableCache.entrySet()) {
            item.getKey().newFrameReady(frameTime, item.getValue().intValue());
        }
    }

    public BiliSize outputFrameSize() {
        return this.mInputTextureSize;
    }

    public BiliSize sizeOfFBO() {
        BiliSize outputSize = maximumOutputSize();
        if (outputSize.minSide() < 1 || this.mInputTextureSize.getWidth() < outputSize.getWidth()) {
            return this.mInputTextureSize;
        }
        return outputSize;
    }

    public static FloatBuffer buildBuffer(float[] coordinates) {
        FloatBuffer buffer = ByteBuffer.allocateDirect(coordinates.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        buffer.put(coordinates).position(0);
        return buffer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
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

    public void newFrameReady(long frameTimeUs, int textureIndex) {
        if (this.mFirstInputFramebuffer == null) {
            return;
        }
        this.mTextureBuffer.clear();
        this.mTextureBuffer.put(textureCoordinates(this.mInputRotation)).position(0);
        renderToTexture(this.mVerticesBuffer, this.mTextureBuffer);
        informTargetsAboutNewFrame(frameTimeUs);
    }

    public void setInputFrameBuffer(BiliFrameBuffer newInputFrameBuffer, int textureIndex) {
        if (newInputFrameBuffer == null) {
            return;
        }
        this.mFirstInputFramebuffer = newInputFrameBuffer;
        this.mFirstInputFramebuffer.lock();
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public int nextAvailableTextureIndex() {
        return 0;
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void setInputSize(BiliSize newSize, int textureIndex) {
        if (this.mOverrideInputSize) {
            if (this.mForcedMaximumSize == null || this.mForcedMaximumSize.minSide() < 1) {
                setupFilterForSize(sizeOfFBO());
                return;
            } else {
                Rect rect = RectHelper.makeRectWithAspectRatioInsideRect(newSize, new Rect(0, 0, this.mForcedMaximumSize.getWidth(), this.mForcedMaximumSize.getHeight()));
                newSize = BiliSize.create(rect);
            }
        }
        BiliSize rotatedSize = rotatedSize(newSize, textureIndex);
        if (rotatedSize.minSide() < 1) {
            this.mInputTextureSize = rotatedSize;
        } else if (!rotatedSize.equals(this.mInputTextureSize)) {
            this.mInputTextureSize = rotatedSize;
        }
        setupFilterForSize(sizeOfFBO());
    }

    public BiliSize rotatedSize(BiliSize sizeToRotate, int textureIndex) {
        BiliSize rotatedSize = sizeToRotate.copy();
        if (this.mInputRotation.isTransposed()) {
            rotatedSize.setWidth(sizeToRotate.getHeight());
            rotatedSize.setHeight(sizeToRotate.getWidth());
        }
        return rotatedSize;
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void setInputRotation(BiliImageOrientation inputRotation, int textureIndex) {
        this.mInputRotation = inputRotation;
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public BiliSize maximumOutputSize() {
        return new BiliSize();
    }

    public boolean isEnable() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void inputFramebufferBindTexture() {
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.mFirstInputFramebuffer == null ? 0 : this.mFirstInputFramebuffer.getTexture());
        GLES20.glUniform1i(this.mFilterInputTextureUniform, 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void inputFramebufferUnlock() {
        if (this.mFirstInputFramebuffer == null) {
            return;
        }
        this.mFirstInputFramebuffer.unlock();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUniformsForProgramAtIndex(int programIndex) {
        for (Runnable runnable : this.mUniformStateRestorationBlocks.values()) {
            runnable.run();
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void setBackgroundColor(float red, float green, float blue, float alpha) {
        this.mBackgroundColorRed = red;
        this.mBackgroundColorGreen = green;
        this.mBackgroundColorBlue = blue;
        this.mBackgroundColorAlpha = alpha;
    }

    public void setInteger(final int newInteger, final String uniformName) {
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.2
            @Override // java.lang.Runnable
            public void run() {
                int uniformIndex = BiliFilter.this.mFilterProgram.uniformIndex(uniformName);
                BiliFilter.this.setInteger(newInteger, uniformIndex, BiliFilter.this.mFilterProgram);
            }
        });
    }

    public void setFloat(final float newFloat, final String uniformName) {
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.3
            @Override // java.lang.Runnable
            public void run() {
                int uniformIndex = BiliFilter.this.mFilterProgram.uniformIndex(uniformName);
                BiliFilter.this.setFloat(newFloat, uniformIndex, BiliFilter.this.mFilterProgram);
            }
        });
    }

    public void setSize(final BiliSizeF newSize, final String uniformName) {
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.4
            @Override // java.lang.Runnable
            public void run() {
                int uniformIndex = BiliFilter.this.mFilterProgram.uniformIndex(uniformName);
                BiliFilter.this.setSize(newSize, uniformIndex, BiliFilter.this.mFilterProgram);
            }
        });
    }

    public void setPoint(final PointF newPoint, final String uniformName) {
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.5
            @Override // java.lang.Runnable
            public void run() {
                int uniformIndex = BiliFilter.this.mFilterProgram.uniformIndex(uniformName);
                BiliFilter.this.setPoint(newPoint, uniformIndex, BiliFilter.this.mFilterProgram);
            }
        });
    }

    public void setFloatVec3(final float[] newVec3, final String uniformName) {
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.6
            @Override // java.lang.Runnable
            public void run() {
                int uniformIndex = BiliFilter.this.mFilterProgram.uniformIndex(uniformName);
                BiliFilter.this.setVec3(newVec3, uniformIndex, BiliFilter.this.mFilterProgram);
            }
        });
    }

    public void setFloatVec4(final float[] newVec4, final String uniformName) {
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.7
            @Override // java.lang.Runnable
            public void run() {
                int uniformIndex = BiliFilter.this.mFilterProgram.uniformIndex(uniformName);
                BiliFilter.this.setVec4(newVec4, uniformIndex, BiliFilter.this.mFilterProgram);
            }
        });
    }

    public void setFloatArray(final float[] array, final String uniformName) {
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.8
            @Override // java.lang.Runnable
            public void run() {
                int uniformIndex = BiliFilter.this.mFilterProgram.uniformIndex(uniformName);
                BiliFilter.this.setFloatArray(array, uniformIndex, BiliFilter.this.mFilterProgram);
            }
        });
    }

    public void setMatrix3f(final float[] matrix, final int uniform, final BiliProgram shaderProgram) {
        if (shaderProgram == null) {
            return;
        }
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.9
            @Override // java.lang.Runnable
            public void run() {
                BiliRenderContext.setActiveShaderProgram(shaderProgram);
                BiliFilter.this.setAndExecuteUniformStateCallbackAtIndex(uniform, shaderProgram, new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GLES20.glUniformMatrix3fv(uniform, 1, false, matrix, 0);
                    }
                });
            }
        });
    }

    public void setMatrix4f(final float[] matrix, final int uniform, final BiliProgram shaderProgram) {
        if (shaderProgram == null) {
            return;
        }
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.10
            @Override // java.lang.Runnable
            public void run() {
                BiliRenderContext.setActiveShaderProgram(shaderProgram);
                BiliFilter.this.setAndExecuteUniformStateCallbackAtIndex(uniform, shaderProgram, new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GLES20.glUniformMatrix4fv(uniform, 1, false, matrix, 0);
                    }
                });
            }
        });
    }

    public void setFloat(final float floatValue, final int uniform, final BiliProgram shaderProgram) {
        if (shaderProgram == null) {
            return;
        }
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.11
            @Override // java.lang.Runnable
            public void run() {
                BiliRenderContext.setActiveShaderProgram(shaderProgram);
                BiliFilter.this.setAndExecuteUniformStateCallbackAtIndex(uniform, shaderProgram, new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GLES20.glUniform1f(uniform, floatValue);
                    }
                });
            }
        });
    }

    public void setPoint(PointF pointValue, int uniform, BiliProgram shaderProgram) {
        float[] vectorValue = {pointValue.x, pointValue.y};
        setVec2(vectorValue, uniform, shaderProgram);
    }

    public void setSize(BiliSizeF sizeValue, int uniform, BiliProgram shaderProgram) {
        float[] vectorValue = {sizeValue.width, sizeValue.height};
        setVec2(vectorValue, uniform, shaderProgram);
    }

    public void setVec2(final float[] vectorValue, final int uniform, final BiliProgram shaderProgram) {
        if (shaderProgram == null) {
            return;
        }
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.12
            @Override // java.lang.Runnable
            public void run() {
                BiliRenderContext.setActiveShaderProgram(shaderProgram);
                BiliFilter.this.setAndExecuteUniformStateCallbackAtIndex(uniform, shaderProgram, new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GLES20.glUniform2fv(uniform, 1, vectorValue, 0);
                    }
                });
            }
        });
    }

    public void setVec3(final float[] vectorValue, final int uniform, final BiliProgram shaderProgram) {
        if (shaderProgram == null) {
            return;
        }
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.13
            @Override // java.lang.Runnable
            public void run() {
                BiliRenderContext.setActiveShaderProgram(shaderProgram);
                BiliFilter.this.setAndExecuteUniformStateCallbackAtIndex(uniform, shaderProgram, new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GLES20.glUniform3fv(uniform, 1, vectorValue, 0);
                    }
                });
            }
        });
    }

    public void setVec4(final float[] vectorValue, final int uniform, final BiliProgram shaderProgram) {
        if (shaderProgram == null) {
            return;
        }
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.14
            @Override // java.lang.Runnable
            public void run() {
                BiliRenderContext.setActiveShaderProgram(shaderProgram);
                BiliFilter.this.setAndExecuteUniformStateCallbackAtIndex(uniform, shaderProgram, new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GLES20.glUniform4fv(uniform, 1, vectorValue, 0);
                    }
                });
            }
        });
    }

    public void setFloatArray(final float[] arrayValue, final int uniform, final BiliProgram shaderProgram) {
        if (shaderProgram == null) {
            return;
        }
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.15
            @Override // java.lang.Runnable
            public void run() {
                BiliRenderContext.setActiveShaderProgram(shaderProgram);
                BiliFilter.this.setAndExecuteUniformStateCallbackAtIndex(uniform, shaderProgram, new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GLES20.glUniform1fv(uniform, arrayValue.length, arrayValue, 0);
                    }
                });
            }
        });
    }

    public void setInteger(final int intValue, final int uniform, final BiliProgram shaderProgram) {
        if (shaderProgram == null) {
            return;
        }
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.16
            @Override // java.lang.Runnable
            public void run() {
                BiliRenderContext.setActiveShaderProgram(shaderProgram);
                BiliFilter.this.setAndExecuteUniformStateCallbackAtIndex(uniform, shaderProgram, new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliFilter.16.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GLES20.glUniform1i(uniform, intValue);
                    }
                });
            }
        });
    }

    protected void setAndExecuteUniformStateCallbackAtIndex(int uniform, BiliProgram shaderProgram, Runnable uniformStateBlock) {
        if (uniformStateBlock == null) {
            return;
        }
        this.mUniformStateRestorationBlocks.put(Integer.valueOf(uniform), uniformStateBlock);
        uniformStateBlock.run();
    }
}