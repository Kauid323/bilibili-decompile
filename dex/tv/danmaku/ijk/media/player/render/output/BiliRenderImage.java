package tv.danmaku.ijk.media.player.render.output;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.render.core.BiliProgram;
import tv.danmaku.ijk.media.player.render.core.BiliRenderContext;
import tv.danmaku.ijk.media.player.render.core.GlUtil;
import tv.danmaku.ijk.media.player.render.filter.BiliFilter;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;
import tv.danmaku.ijk.media.player.render.transform.BiliMVPMatrix;

public class BiliRenderImage {
    private static final String TAG = "BiliRenderImage";
    private boolean isRecycle;
    private int mBgImageFilterInputTextureUniform;
    private int mBgImageFilterPositionAttribute;
    private int mBgImageFilterTextureCoordinateAttribute;
    private BiliProgram mBgProgram;
    private Bitmap mImageBitmap;
    private FloatBuffer mTextureBuffer;
    private FloatBuffer mVerticesBuffer;
    private final String BILI_BACKGROUND_OPRATION_SHADER = BiliTerminalOprationRenderer.BILI_OPRATION_SHADER;
    private BiliSize mScreenSize = new BiliSize();
    private BiliSize mImageSize = new BiliSize();
    private int mImageTexId = -1;
    protected int mMatrixIndex = -1;
    private Rect mDisplayRect = new Rect(0, 0, 0, 0);
    private BiliMVPMatrix mMvpMatrix = new BiliMVPMatrix();

    public void initOnGLThread() {
        this.mBgProgram = BiliRenderContext.program(BiliTerminalOprationRenderer.BILI_OPRATION_SHADER, BiliFilter.BILI_PASSTHROUGH_FRAGMENT_SHADER);
        this.mVerticesBuffer = GlUtil.createFloatBuffer(BiliFilter.imageVertices);
        this.mTextureBuffer = GlUtil.createFloatBuffer(BiliFilter.verticalFlipTextureCoordinates);
        if (this.mBgProgram == null) {
            BLog.e(TAG, "Background image program is null !");
        } else if (!this.mBgProgram.isInitialized() && !this.mBgProgram.isValidate()) {
            BLog.e(TAG, "Background image Program is in validate !");
        } else {
            this.mBgImageFilterPositionAttribute = this.mBgProgram.attributeIndex("position");
            this.mBgImageFilterTextureCoordinateAttribute = this.mBgProgram.attributeIndex("inputTextureCoordinate");
            this.mBgImageFilterInputTextureUniform = this.mBgProgram.uniformIndex("inputImageTexture");
            this.mMatrixIndex = this.mBgProgram.uniformIndex(BiliMVPMatrix.BILI_MATRIX);
            GLES20.glEnableVertexAttribArray(this.mBgImageFilterPositionAttribute);
            GLES20.glEnableVertexAttribArray(this.mBgImageFilterTextureCoordinateAttribute);
        }
    }

    public void setScreenSize(BiliSize screenSize) {
        BLog.i(TAG, "setScreenSize : " + screenSize);
        this.mScreenSize = screenSize;
        this.mMvpMatrix.setScreenSize(this.mScreenSize.width, this.mScreenSize.height);
    }

    public void setDisplayRect(Rect rect) {
        this.mDisplayRect = rect;
    }

    public void drawImage() {
        if (this.mImageTexId == -1) {
            return;
        }
        if (this.mDisplayRect.width() == 0 || this.mDisplayRect.height() == 0) {
            this.mDisplayRect.set(0, 0, this.mScreenSize.width, this.mScreenSize.height);
        }
        this.mMvpMatrix.mapVerticesFromRect(this.mDisplayRect, this.mScreenSize, this.mVerticesBuffer);
        BiliRenderContext.setActiveShaderProgram(this.mBgProgram);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, this.mImageTexId);
        GLES20.glUniform1i(this.mBgImageFilterInputTextureUniform, 3);
        GLES20.glUniformMatrix4fv(this.mMatrixIndex, 1, false, this.mMvpMatrix.getMatrixForInput(), 0);
        GLES20.glEnableVertexAttribArray(this.mBgImageFilterPositionAttribute);
        GLES20.glEnableVertexAttribArray(this.mBgImageFilterTextureCoordinateAttribute);
        GLES20.glVertexAttribPointer(this.mBgImageFilterPositionAttribute, 2, 5126, false, 0, (Buffer) this.mVerticesBuffer);
        GLES20.glVertexAttribPointer(this.mBgImageFilterTextureCoordinateAttribute, 2, 5126, false, 0, (Buffer) this.mTextureBuffer);
        GLES20.glDrawArrays(5, 0, 4);
    }

    public void setBackgroundBitmap(Bitmap bitmap, boolean recycle, Rect displayRect) {
        if (bitmap == null) {
            GLES20.glDeleteTextures(1, new int[]{this.mImageTexId}, 0);
            this.mImageTexId = -1;
            return;
        }
        if (this.mImageTexId > 0) {
            GLES20.glDeleteTextures(1, new int[]{this.mImageTexId}, 0);
            this.mImageTexId = -1;
        }
        if (this.mImageBitmap != null && !this.mImageBitmap.isRecycled() && this.isRecycle) {
            this.mImageBitmap.recycle();
            BLog.i(TAG, "setBackgroundBitmap : old image is recycled !");
        }
        this.mImageBitmap = bitmap;
        this.isRecycle = recycle;
        this.mImageSize = BiliSize.create(bitmap.getWidth(), bitmap.getHeight());
        BLog.i(TAG, String.format("setBackgroundBitmap : image w:%s|h:%s  rect : %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), displayRect));
        int[] texIds = new int[1];
        this.mImageTexId = texIds[0];
        GLES20.glGenTextures(1, texIds, 0);
        GLES20.glBindTexture(3553, this.mImageTexId);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glBindTexture(3553, this.mImageTexId);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        GLES20.glBindTexture(3553, 0);
        setDisplayRect(displayRect);
        this.mMvpMatrix.setTextureSize(bitmap.getWidth(), bitmap.getHeight());
        this.mMvpMatrix.setAspectRatio(3);
    }

    public void destroy() {
        if (this.mImageTexId > 0) {
            GLES20.glDeleteTextures(1, new int[]{this.mImageTexId}, 0);
        }
        if (this.mBgProgram != null) {
            this.mBgProgram.destroy();
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.isRecycle && !this.mImageBitmap.isRecycled() && this.mImageBitmap != null) {
            this.mImageBitmap.recycle();
        }
    }
}