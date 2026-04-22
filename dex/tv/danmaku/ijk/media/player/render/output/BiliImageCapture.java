package tv.danmaku.ijk.media.player.render.output;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.Image;
import android.media.ImageReader;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.nio.ByteBuffer;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.ijk.media.player.render.core.BiliFrameBuffer;
import tv.danmaku.ijk.media.player.render.core.BiliRenderContext;
import tv.danmaku.ijk.media.player.render.core.EglCore;
import tv.danmaku.ijk.media.player.render.core.EglSurfaceBase;
import tv.danmaku.ijk.media.player.render.extend.BiliTextureSizeAlign;
import tv.danmaku.ijk.media.player.render.output.IImageCapture;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;
import tv.danmaku.ijk.media.player.render.transform.BiliMVPMatrix;

public class BiliImageCapture implements ImageReader.OnImageAvailableListener, IImageCapture {
    private static final int CAPTURE_GL_CAPTURE_IMAGE = 3;
    private static final int CAPTURE_GL_INIT = 1;
    private static final int CAPTURE_GL_RELEASE = 4;
    private static final int CAPTURE_GL_RESIZE_WINDOW = 2;
    private static final String TAG = "BiliImageCapture";
    private static final String TAG_CAPTURE_HANDLER = "ijk_java_cap";
    private static final String TAG_RENDER_HANDLER = "ijk_java_render";
    private long _capOneFrameTimeMS;
    private Handler.Callback h;
    private boolean isPrepare;
    private boolean isRelease;
    private Handler mCaptureHandler;
    private BiliMVPMatrix mCaptureMatrix;
    private HandlerThread mCaptureRenderThread;
    private BiliSize mCurrentScreenSize;
    private IImageCapture.OnCaptureFrameAvailableListener mFrameAvailableListener;
    private EglCore mGLCore;
    private Handler mImageHandler;
    private HandlerThread mImageHandlerThread;
    private ImageReader mImageReader;
    private int mImgHeight;
    private int mImgWidth;
    private BiliFrameBuffer mInputFrameBuffer;
    private int mMaxImages;
    private BiliSize mScreenSize;
    private Semaphore mSemaphore;
    private EGLContext mShareEGLContext;
    private EglSurfaceBase mSurfaceBase;
    private BiliTerminalOprationRenderer mTerminalRender;
    private float[] mUm4Matrix;

    public BiliImageCapture() {
        this.mUm4Matrix = new float[16];
        this.mScreenSize = new BiliSize();
        this.mCurrentScreenSize = new BiliSize();
        this.isPrepare = false;
        this.isRelease = false;
        this.mImgWidth = 0;
        this.mImgHeight = 0;
        this.h = new Handler.Callback() { // from class: tv.danmaku.ijk.media.player.render.output.BiliImageCapture.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message msg) {
                try {
                    switch (msg.what) {
                        case 3:
                            if (!BiliImageCapture.this.isPrepare) {
                                BiliImageCapture.this._captureGLInit(BiliImageCapture.this.mShareEGLContext);
                            }
                            if (!BiliImageCapture.this.mCurrentScreenSize.equals(BiliImageCapture.this.mScreenSize) || !BiliImageCapture.this.mCurrentScreenSize.isSize()) {
                                BiliImageCapture.this._captureGLResizeWindow(BiliImageCapture.this.mScreenSize.width, BiliImageCapture.this.mScreenSize.height);
                            }
                            BiliImageCapture.this._captureImage();
                            return false;
                        case 4:
                            BiliImageCapture.this._captureRelease();
                            return false;
                        default:
                            return false;
                    }
                } catch (Exception e) {
                    BLog.e(BiliImageCapture.TAG, "ImageCapture Error !" + e.getMessage());
                    return false;
                }
            }
        };
        this.mCaptureMatrix = new BiliMVPMatrix();
    }

    public BiliImageCapture(BiliMVPMatrix matrix) {
        this.mUm4Matrix = new float[16];
        this.mScreenSize = new BiliSize();
        this.mCurrentScreenSize = new BiliSize();
        this.isPrepare = false;
        this.isRelease = false;
        this.mImgWidth = 0;
        this.mImgHeight = 0;
        this.h = new Handler.Callback() { // from class: tv.danmaku.ijk.media.player.render.output.BiliImageCapture.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message msg) {
                try {
                    switch (msg.what) {
                        case 3:
                            if (!BiliImageCapture.this.isPrepare) {
                                BiliImageCapture.this._captureGLInit(BiliImageCapture.this.mShareEGLContext);
                            }
                            if (!BiliImageCapture.this.mCurrentScreenSize.equals(BiliImageCapture.this.mScreenSize) || !BiliImageCapture.this.mCurrentScreenSize.isSize()) {
                                BiliImageCapture.this._captureGLResizeWindow(BiliImageCapture.this.mScreenSize.width, BiliImageCapture.this.mScreenSize.height);
                            }
                            BiliImageCapture.this._captureImage();
                            return false;
                        case 4:
                            BiliImageCapture.this._captureRelease();
                            return false;
                        default:
                            return false;
                    }
                } catch (Exception e) {
                    BLog.e(BiliImageCapture.TAG, "ImageCapture Error !" + e.getMessage());
                    return false;
                }
            }
        };
        this.mCaptureMatrix = matrix;
    }

    public BiliImageCapture(EGLContext shareContext, BiliSize screen) {
        this(shareContext, screen, 1);
    }

    public BiliImageCapture(EGLContext shareContext, BiliSize screen, int maxImages) {
        this.mUm4Matrix = new float[16];
        this.mScreenSize = new BiliSize();
        this.mCurrentScreenSize = new BiliSize();
        this.isPrepare = false;
        this.isRelease = false;
        this.mImgWidth = 0;
        this.mImgHeight = 0;
        this.h = new Handler.Callback() { // from class: tv.danmaku.ijk.media.player.render.output.BiliImageCapture.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message msg) {
                try {
                    switch (msg.what) {
                        case 3:
                            if (!BiliImageCapture.this.isPrepare) {
                                BiliImageCapture.this._captureGLInit(BiliImageCapture.this.mShareEGLContext);
                            }
                            if (!BiliImageCapture.this.mCurrentScreenSize.equals(BiliImageCapture.this.mScreenSize) || !BiliImageCapture.this.mCurrentScreenSize.isSize()) {
                                BiliImageCapture.this._captureGLResizeWindow(BiliImageCapture.this.mScreenSize.width, BiliImageCapture.this.mScreenSize.height);
                            }
                            BiliImageCapture.this._captureImage();
                            return false;
                        case 4:
                            BiliImageCapture.this._captureRelease();
                            return false;
                        default:
                            return false;
                    }
                } catch (Exception e) {
                    BLog.e(BiliImageCapture.TAG, "ImageCapture Error !" + e.getMessage());
                    return false;
                }
            }
        };
        this.mCaptureMatrix = new BiliMVPMatrix();
        prepare(shareContext, maxImages);
        setSurfaceSize(screen.width, screen.height);
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public void prepare() {
        if (BiliRenderContext.currentEGLContext() == EGL10.EGL_NO_CONTEXT) {
            BLog.e(TAG, "must in gl thread call prepare() !");
        } else {
            prepare(BiliRenderContext.currentEGLContext());
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public void prepare(EGLContext shareContext) {
        prepare(shareContext, 1);
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public void prepare(EGLContext shareContext, int maxImages) {
        if (this.isPrepare) {
            BLog.w(TAG, "This Capture is prepare !");
            return;
        }
        this.mShareEGLContext = shareContext;
        this.mMaxImages = maxImages;
        this.mSemaphore = new Semaphore(this.mMaxImages);
        this.mImageHandlerThread = new HandlerThread(TAG_CAPTURE_HANDLER);
        this.mImageHandlerThread.start();
        this.mImageHandler = new Handler(this.mImageHandlerThread.getLooper());
        this.mCaptureRenderThread = new HandlerThread(TAG_RENDER_HANDLER);
        this.mCaptureRenderThread.start();
        this.mCaptureHandler = new Handler(this.mCaptureRenderThread.getLooper(), this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _captureGLInit(EGLContext shareContext) {
        BLog.i(TAG, "_captureGLInit()");
        this.mGLCore = new EglCore(shareContext, 2);
        this.mTerminalRender = new BiliTerminalOprationRenderer();
        this.mTerminalRender.setMatrix(this.mCaptureMatrix);
        this.isPrepare = true;
        BiliRenderContext.shared().addCaptureEglCoreToCache(this.mGLCore);
        int cacheSize = BiliRenderContext.shared().getCaptureEglCoreCacheSize();
        BLog.i(TAG, "_captureGLInit() end()   eglCore cacheSize : " + cacheSize);
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public void setSurfaceSize(int width, int height) {
        if (width <= 0 || height <= 0) {
            BLog.e(TAG, "invalid surface size !  width:" + width + " | height:" + height);
        } else if (this.mScreenSize != null && this.mScreenSize.width == width && this.mScreenSize.height == height) {
        } else {
            this.mScreenSize = BiliTextureSizeAlign.Align16MultipleMin.align_2(BiliSize.create(width, height));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _captureGLResizeWindow(int width, int height) {
        BLog.i(TAG, "_captureGLResizeWindow() width:" + width + " height:" + height);
        if (this.mImageReader != null) {
            this.mImageReader.close();
        }
        if (this.mSurfaceBase != null) {
            this.mSurfaceBase.releaseEglSurface();
        }
        this.mCurrentScreenSize.width = width;
        this.mCurrentScreenSize.height = height;
        this.mImageReader = ImageReader.newInstance(width, height, 1, this.mMaxImages);
        this.mImageReader.setOnImageAvailableListener(this, this.mImageHandler);
        this.mSurfaceBase = new EglSurfaceBase(this.mGLCore);
        this.mSurfaceBase.createWindowSurface(this.mImageReader.getSurface());
        if (this.mInputFrameBuffer == null || !this.mInputFrameBuffer.getSize().isSize()) {
            BLog.e(TAG, "input frame buffer is invalid !");
        } else if (this.mCurrentScreenSize == null || !this.mCurrentScreenSize.isSize()) {
            BLog.e(TAG, "screen size is invalid !");
        } else {
            GLES20.glViewport(0, 0, width, height);
            this.mTerminalRender.setGLScreenSizeSize(this.mCurrentScreenSize);
            this.mTerminalRender.setInputFrameBuffer(this.mInputFrameBuffer, 0);
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public void captureOneImage() {
        this.mCaptureHandler.sendEmptyMessage(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _captureImage() {
        BLog.i(TAG, "_captureImage()");
        if (this.mSurfaceBase == null || this.mGLCore == null) {
            return;
        }
        try {
            this.mSemaphore.acquire();
            this.mSurfaceBase.makeCurrent();
            this.mTerminalRender.setInputFrameBuffer(this.mInputFrameBuffer, 0);
            this.mTerminalRender.setInputSize(BiliSize.create(this.mImgWidth, this.mImgHeight), 0);
            this._capOneFrameTimeMS = System.currentTimeMillis();
            this.mTerminalRender.newFrameReady(System.currentTimeMillis(), 0);
            this.mSurfaceBase.swapBuffers();
            this.mGLCore.makeNothingCurrent();
            GLES20.glFinish();
        } catch (InterruptedException e) {
            BLog.e(TAG, "_captureImage error : " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _captureRelease() {
        BLog.i(TAG, "_captureRelease()");
        try {
            this.mSemaphore.tryAcquire(this.mMaxImages, 200L, TimeUnit.MILLISECONDS);
            if (this.mSurfaceBase != null && this.mGLCore != null) {
                if (this.mTerminalRender != null) {
                    this.mTerminalRender.destroy();
                }
                this.mGLCore.makeNothingCurrent();
                this.mSurfaceBase.releaseEglSurface();
            }
            if (this.mGLCore != null) {
                this.mGLCore.release();
                BiliRenderContext.shared().removeCaptureEglCoreToCache(this.mGLCore);
                int cacheSize = BiliRenderContext.shared().getCaptureEglCoreCacheSize();
                BLog.i(TAG, "_captureRelease() end()   eglCore cacheSize : " + cacheSize);
            }
            if (this.mImageReader != null) {
                this.mImageReader.close();
            }
            this.mSurfaceBase = null;
            this.mGLCore = null;
            this.mInputFrameBuffer = null;
            this.mShareEGLContext = null;
        } catch (InterruptedException e) {
            BLog.e(TAG, e);
        }
        this.isRelease = true;
    }

    protected void finalize() throws Throwable {
        try {
            try {
                if (!this.isRelease && this.isPrepare) {
                    BLog.w(TAG, "finalize() release()");
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
    public void setInputFrameBuffer(BiliFrameBuffer frameBuffer) {
        BLog.i(TAG, "setInputFrameBuffer()  " + frameBuffer);
        this.mInputFrameBuffer = frameBuffer;
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public void setInputImageSize(int width, int height) {
        BLog.i(TAG, "setInputFrameBuffer()  w:" + width + " h:" + height);
        this.mImgWidth = BiliTextureSizeAlign.Align16MultipleMin.align_2(width);
        this.mImgHeight = BiliTextureSizeAlign.Align16MultipleMin.align_2(height);
        this.mCaptureMatrix.setTextureSize(this.mImgWidth, this.mImgHeight);
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public void setCaptureFrameAvailableListener(IImageCapture.OnCaptureFrameAvailableListener listener) {
        BLog.i(TAG, "setCaptureFrameAvailableListener()  " + listener);
        this.mFrameAvailableListener = listener;
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public void setSurfaceTextureMatrix(float[] matrix) {
        System.arraycopy(matrix, 0, this.mUm4Matrix, 0, matrix.length);
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public void onImageAvailable(ImageReader reader) {
        BLog.i(TAG, "onImageAvailable()");
        Image image = reader.acquireNextImage();
        if (image != null) {
            int width = image.getWidth();
            int height = image.getHeight();
            Image.Plane[] planes = image.getPlanes();
            ByteBuffer buffer = planes[0].getBuffer();
            int pixelStride = planes[0].getPixelStride();
            int rowStride = planes[0].getRowStride();
            int rowPadding = rowStride - (pixelStride * width);
            Bitmap bitmap = Bitmap.createBitmap((rowPadding / pixelStride) + width, height, Bitmap.Config.ARGB_8888);
            bitmap.copyPixelsFromBuffer(buffer);
            Bitmap bmp = Bitmap.createBitmap(this.mScreenSize.width, this.mScreenSize.height, Bitmap.Config.ARGB_8888);
            Rect src = new Rect(0, 0, this.mScreenSize.width, this.mScreenSize.height);
            RectF dst = new RectF(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, this.mScreenSize.width, this.mScreenSize.height);
            Canvas canvas = new Canvas(bmp);
            canvas.drawBitmap(bitmap, src, dst, (Paint) null);
            long diff = System.currentTimeMillis() - this._capOneFrameTimeMS;
            BLog.d(TAG, "capOneFrameTimeMS :" + diff);
            bitmap.recycle();
            if (this.mFrameAvailableListener != null) {
                this.mFrameAvailableListener.onCaptureFrameAvailable(bmp);
            } else {
                bmp.recycle();
            }
            image.close();
        }
        this.mSemaphore.release();
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public BiliMVPMatrix getMatrix() {
        BLog.i(TAG, "getMatrix()");
        return this.mCaptureMatrix;
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public BiliSize getSurfaceSize() {
        return this.mScreenSize;
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture
    public void release() {
        BLog.i(TAG, "release()  isPrepare:" + this.isPrepare);
        if (!this.isPrepare) {
            this.mCaptureRenderThread.quitSafely();
            this.mImageHandlerThread.quitSafely();
            return;
        }
        this.mCaptureHandler.sendEmptyMessage(4);
        this.mCaptureRenderThread.quitSafely();
        this.mImageHandlerThread.quitSafely();
        this.isPrepare = false;
    }
}