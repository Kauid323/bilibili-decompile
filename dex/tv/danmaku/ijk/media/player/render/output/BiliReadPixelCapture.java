package tv.danmaku.ijk.media.player.render.output;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.microedition.khronos.egl.EGLContext;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.render.core.BiliFrameBuffer;
import tv.danmaku.ijk.media.player.render.core.BiliImageOrientation;
import tv.danmaku.ijk.media.player.render.core.EglCore;
import tv.danmaku.ijk.media.player.render.core.EglSurfaceBase;
import tv.danmaku.ijk.media.player.render.core.IjkGLUtils;
import tv.danmaku.ijk.media.player.render.extend.BiliTextureSizeAlign;
import tv.danmaku.ijk.media.player.render.output.IImageCapture;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;
import tv.danmaku.ijk.media.player.render.transform.BiliMVPMatrix;

public class BiliReadPixelCapture implements IImageCapture {
    private static final int BILI_READ_PIXEL_INIT_GL = 2;
    private static final int BILI_READ_PIXEL_PREPARE = 1;
    private static final int BILI_READ_PIXEL_SET_WINDOW_SIZE = 3;
    private static final String BILI_RENDER_THREAD = "ijk_java_render";
    private static final int HANDLER_CAPTURE_FRAME = 6;
    private static final int HANDLER_INIT_GL_CONTEXT = 4;
    private static final int HANDLER_RELEASE = 7;
    private static final int HANDLER_SET_WINDOW_SIZE = 5;
    private static final String TAG = "BiliReadPixelCapture";
    private IImageCapture.OnCaptureFrameAvailableListener frameAvailableListener;
    private boolean isEglInit;
    private boolean isEglReleased;
    private BiliMVPMatrix mCaptureMatrix;
    private BiliSize mCurrentScreenSize;
    private EglCore mGLCore;
    private int mImgHeight;
    private int mImgWidth;
    private BiliFrameBuffer mInputFrameBuffer;
    private Handler mRenderHandler;
    private HandlerThread mRenderThread;
    private BiliSize mScreenSize;
    private EGLContext mShareContext;
    private int mState;
    private EglSurfaceBase mSurfaceBase;
    private BiliTerminalOprationRenderer mTerminalRender;
    private float[] mUm4Matrix;

    public BiliReadPixelCapture() {
        this.mUm4Matrix = new float[16];
        this.mState = 0;
        this.mScreenSize = new BiliSize();
        this.mCurrentScreenSize = new BiliSize();
        this.mCaptureMatrix = new BiliMVPMatrix();
    }

    public BiliReadPixelCapture(BiliMVPMatrix matrix) {
        this.mUm4Matrix = new float[16];
        this.mState = 0;
        this.mScreenSize = new BiliSize();
        this.mCurrentScreenSize = new BiliSize();
        this.mCaptureMatrix = matrix;
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public void prepare() {
        prepare(null);
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public void prepare(EGLContext shareContext) {
        prepare(shareContext, 1);
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public void prepare(EGLContext shareContext, int maxImages) {
        if (this.mState >= 1) {
            BLog.w(TAG, "not many times prepare");
            return;
        }
        BLog.i(TAG, "prepare");
        this.mTerminalRender = new BiliTerminalOprationRenderer();
        this.mTerminalRender.setInputRotation(BiliImageOrientation.DownMirrored, 0);
        this.mTerminalRender.setMatrix(this.mCaptureMatrix);
        this.mShareContext = shareContext;
        this.mRenderThread = new HandlerThread(BILI_RENDER_THREAD);
        this.mRenderThread.start();
        this.mRenderHandler = new Handler(this.mRenderThread.getLooper()) { // from class: tv.danmaku.ijk.media.player.render.output.BiliReadPixelCapture.1
            @Override // android.os.Handler
            public void dispatchMessage(Message msg) {
                super.dispatchMessage(msg);
                try {
                    switch (msg.what) {
                        case 6:
                            BiliReadPixelCapture.this._initGLContext();
                            if (!BiliReadPixelCapture.this.mCurrentScreenSize.equals(BiliReadPixelCapture.this.mScreenSize) || !BiliReadPixelCapture.this.mCurrentScreenSize.isSize()) {
                                BiliReadPixelCapture.this._windowSize(BiliReadPixelCapture.this.mScreenSize.width, BiliReadPixelCapture.this.mScreenSize.height);
                            }
                            BiliReadPixelCapture.this._renderOneFrame();
                            return;
                        case 7:
                            BiliReadPixelCapture.this._captureRelease();
                            return;
                        default:
                            return;
                    }
                } catch (Exception e) {
                    BLog.e(BiliReadPixelCapture.TAG, "dispatch message :" + msg.what + " error !");
                    BLog.e(BiliReadPixelCapture.TAG, e);
                }
            }
        };
        this.mState = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _initGLContext() {
        if (this.mGLCore != null) {
            return;
        }
        BLog.i(TAG, " _initGLContext() ");
        if (this.mState > 2) {
            BLog.w(TAG, "not many times init gl context");
            return;
        }
        this.mGLCore = new EglCore(this.mShareContext, 2);
        this.mState = 2;
        BLog.i(TAG, " _initGLContext() end()");
        this.isEglInit = true;
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public void setSurfaceSize(int width, int height) {
        BLog.i(TAG, "setSurfaceSize width:" + width + " height:" + height);
        if (width <= 0 || height <= 0) {
            BLog.e(TAG, "invalid surface size !  width:" + width + " | height:" + height);
        } else if (this.mScreenSize.width == width && this.mScreenSize.height == height) {
        } else {
            this.mScreenSize = BiliTextureSizeAlign.Align16MultipleMin.align_2(BiliSize.create(width, height));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _windowSize(int width, int height) {
        BLog.i(TAG, " _windowSize() width:" + width + " height:" + height);
        this.mState = 3;
        if (this.mSurfaceBase != null) {
            this.mSurfaceBase.releaseEglSurface();
        }
        this.mSurfaceBase = null;
        this.mSurfaceBase = new EglSurfaceBase(this.mGLCore);
        this.mSurfaceBase.createOffscreenSurface(width, height);
        this.mSurfaceBase.makeCurrent();
        this.mCurrentScreenSize.width = width;
        this.mCurrentScreenSize.height = height;
        if (this.mInputFrameBuffer == null || !this.mInputFrameBuffer.getSize().isSize()) {
            BLog.e(TAG, "input frame buffer is invalid !");
        } else if (this.mCurrentScreenSize == null || !this.mCurrentScreenSize.isSize()) {
            BLog.e(TAG, "screen size is invalid !");
        } else {
            GLES20.glViewport(0, 0, width, height);
            this.mTerminalRender.setGLScreenSizeSize(this.mScreenSize);
            this.mTerminalRender.setInputFrameBuffer(this.mInputFrameBuffer, 0);
            this.mTerminalRender.setInputSize(this.mInputFrameBuffer.getSize(), 0);
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public void captureOneImage() {
        BLog.i(TAG, "captureOneImage");
        this.mRenderHandler.sendEmptyMessage(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _renderOneFrame() {
        if (this.mSurfaceBase == null) {
            return;
        }
        this.mSurfaceBase.makeCurrent();
        this.mTerminalRender.setInputFrameBuffer(this.mInputFrameBuffer, 0);
        this.mTerminalRender.setInputSize(BiliSize.create(this.mImgWidth, this.mImgHeight), 0);
        long _capOneFrameTimeMS = System.currentTimeMillis();
        this.mTerminalRender.newFrameReady(System.currentTimeMillis(), 0);
        IjkGLUtils.checkGlError("_renderOneFrame");
        ByteBuffer buf = ByteBuffer.allocateDirect(this.mCurrentScreenSize.width * this.mCurrentScreenSize.height * 4);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        GLES20.glReadPixels(0, 0, this.mCurrentScreenSize.width, this.mCurrentScreenSize.height, 6408, 5121, buf);
        IjkGLUtils.checkGlError("glReadPixels");
        buf.rewind();
        Bitmap bmp = Bitmap.createBitmap(this.mCurrentScreenSize.width, this.mCurrentScreenSize.height, Bitmap.Config.ARGB_8888);
        bmp.copyPixelsFromBuffer(buf);
        long diff = System.currentTimeMillis() - _capOneFrameTimeMS;
        BLog.i(TAG, "capOneFrameTimeMS :" + diff);
        if (this.frameAvailableListener != null) {
            this.frameAvailableListener.onCaptureFrameAvailable(bmp);
        } else {
            bmp.recycle();
        }
        this.mSurfaceBase.swapBuffers();
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public void setInputFrameBuffer(BiliFrameBuffer frameBuffer) {
        BLog.i(TAG, " setInputFrameBuffer() frameBuffer :" + frameBuffer);
        this.mInputFrameBuffer = frameBuffer;
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public void setInputImageSize(int width, int height) {
        BLog.i(TAG, "input image size :" + width + "|" + height);
        this.mImgWidth = BiliTextureSizeAlign.Align2MultipleMin.align_2(width);
        this.mImgHeight = BiliTextureSizeAlign.Align2MultipleMin.align_2(height);
        this.mCaptureMatrix.setTextureSize(this.mImgWidth, this.mImgHeight);
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public void setCaptureFrameAvailableListener(IImageCapture.OnCaptureFrameAvailableListener listener) {
        this.frameAvailableListener = listener;
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public void setSurfaceTextureMatrix(float[] matrix) {
        System.arraycopy(matrix, 0, this.mUm4Matrix, 0, matrix.length);
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public BiliMVPMatrix getMatrix() {
        return this.mCaptureMatrix;
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public BiliSize getSurfaceSize() {
        return this.mScreenSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _captureRelease() {
        BLog.i(TAG, " _captureRelease() ");
        if (this.mTerminalRender != null) {
            this.mTerminalRender.destroy();
        }
        if (this.mSurfaceBase != null && this.mGLCore != null) {
            this.mGLCore.makeNothingCurrent();
            this.mSurfaceBase.releaseEglSurface();
        }
        if (this.mGLCore != null) {
            this.mGLCore.release();
        }
        this.mGLCore = null;
        if (this.mRenderThread != null && this.mRenderThread.isAlive()) {
            this.mRenderThread.quit();
        }
        this.mState = 0;
        this.isEglReleased = true;
    }

    protected void finalize() throws Throwable {
        try {
            try {
                if (this.isEglInit && !this.isEglReleased) {
                    BLog.w(TAG, "finalize() release .");
                    _captureRelease();
                }
            } catch (Exception e) {
                BLog.e(TAG, e);
            }
        } finally {
            super.finalize();
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public void release() {
        if (this.mRenderHandler != null) {
            this.mRenderHandler.sendEmptyMessage(7);
        }
    }
}