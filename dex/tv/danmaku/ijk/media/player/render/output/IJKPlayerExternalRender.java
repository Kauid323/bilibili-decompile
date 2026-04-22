package tv.danmaku.ijk.media.player.render.output;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import android.view.Surface;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.ijk.media.player.render.IExternalRenderCallback;
import tv.danmaku.ijk.media.player.render.core.BiliEGLContext;
import tv.danmaku.ijk.media.player.render.core.BiliFrameBuffer;
import tv.danmaku.ijk.media.player.render.core.BiliImageOrientation;
import tv.danmaku.ijk.media.player.render.core.BiliRenderContext;
import tv.danmaku.ijk.media.player.render.filter.BiliEnhanceFilter;
import tv.danmaku.ijk.media.player.render.filter.BiliFilter;
import tv.danmaku.ijk.media.player.render.filter.BiliFrameNotifierFakeFilter;
import tv.danmaku.ijk.media.player.render.filter.BiliGaussianFilter;
import tv.danmaku.ijk.media.player.render.filter.BiliMultiRenderFilter;
import tv.danmaku.ijk.media.player.render.filter.BiliOESRetrieval;
import tv.danmaku.ijk.media.player.render.output.IImageCapture;
import tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface;
import tv.danmaku.ijk.media.player.render.tools.BiliDaltonizer;
import tv.danmaku.ijk.media.player.render.tools.BiliPipeTask;
import tv.danmaku.ijk.media.player.render.tools.BiliSensorEntity;
import tv.danmaku.ijk.media.player.render.tools.BiliSensorEventHandler;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;
import tv.danmaku.ijk.media.player.render.transform.BiliMVPMatrix;

public class IJKPlayerExternalRender implements IExternalRenderCallback, BiliSensorEventHandler.SensorChangedListener, IJKEXTRendererInterface {
    private static final int RPUCACHESIZE = 100;
    private static final String TAG = "IJKPlayerExternalRender";
    private boolean isDolbyInit;
    private boolean isRecycle;
    private float mBackgroundColorBlue;
    private float mBackgroundColorGreen;
    private float mBackgroundColorRed;
    private Bitmap mBgBitmap;
    private Rect mBgDisplayRect;
    private BiliGaussianFilter mBlurFilter;
    private BiliMVPMatrix mCaptureMatrix;
    private IImageCapture mCaptureThread;
    private BiliMVPMatrix mDisplayMatrix;
    private volatile Rect mDisplayRect;
    private String mDolbyConfigPath;
    private boolean mDolbyModel;
    private boolean mEnableEnhance;
    private boolean mEnableSwHDR;
    private BiliEnhanceFilter mEnhanceFilter;
    private IJKEXTRendererInterface.IjkEnhanceType mEnhanceType;
    private BiliFrameNotifierFakeFilter mFrameNotifierFilter;
    private BiliFilter mHeadFilter;
    private IJKTerminalRenderWrap mIjkRenderWrap;
    private BiliFrameBuffer mInputOESFramebuffer;
    private boolean mIsHdrVivid;
    private BiliFilter mLastFilter;
    private BiliOESRetrieval mOESRetrieval;
    private IJKEXTRendererInterface.OnFirstFrameListener mOnFirstFrameListener;
    private IJKEXTRendererInterface.OnFrameRenderedListener mOnFrameRenderedListener;
    private final BiliPipeTask mRunOnDraw;
    private BiliSensorEventHandler mSensorHandler;
    private boolean mSupportVivid;
    private Queue<Pair<ByteBuffer, Long>> mVividDataList;
    private WeakReference<Context> mWeakContext;
    private WeakReference<IExternalRenderCallback.IExternalWindow> mWeakWindow;
    private List<Pair<ByteBuffer, Long>> rpuBufferCache;
    private final Object mLock = new Object();
    private BiliDaltonizer.ColorBlindnessType mDaltonizerType = BiliDaltonizer.ColorBlindnessType.None;
    private final Object mRPULock = new Object();
    private int mVerticesCalcModel = 0;
    private List<RectF> mBlurRectList = new ArrayList();
    private int mRenderModel = 1;
    private BiliImageOrientation mOrientation = BiliImageOrientation.Up;
    private BiliSize mImageSize = new BiliSize();
    private BiliSize mSurfaceSize = new BiliSize();
    private int mCaptureModel = 1;
    private float mBackgroundColorAlpha = 1.0f;
    private boolean isEnableMultiRender = false;
    private BiliMultiRenderFilter mMultiRenderFilter = null;
    private Surface mSubSurface = null;
    private RectF mMainScreenRect = new RectF(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f);
    private RectF mSubScreenRect = new RectF(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f);

    public IJKPlayerExternalRender() {
        BLog.i(TAG, "constructor()");
        this.mRunOnDraw = new BiliPipeTask();
        this.mDisplayMatrix = new BiliMVPMatrix();
        this.mCaptureMatrix = new BiliMVPMatrix();
        createCapture();
        this.mSensorHandler = new BiliSensorEventHandler();
        this.mSensorHandler.setSensorChangedListener(this);
        this.rpuBufferCache = new ArrayList();
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void setCaptureModel(int model) {
        if (model < 0) {
            model = 0;
        }
        if (model > 6) {
            model = 6;
        }
        this.mCaptureModel = model;
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public int getCaptureModel() {
        return this.mCaptureModel;
    }

    private void createCapture() {
        if (this.mCaptureThread != null) {
            return;
        }
        this.mCaptureThread = new BiliImageCapture(this.mCaptureMatrix);
    }

    @Override // tv.danmaku.ijk.media.player.render.IExternalRenderCallback
    public void glesSupportHdrVivid(boolean support) {
        BLog.i(TAG, "glesVersionSupportHdrVivid() supportVivid:" + support);
        this.mSupportVivid = support;
    }

    @Override // tv.danmaku.ijk.media.player.render.IExternalRenderCallback
    public void onSurfaceCreate(IExternalRenderCallback.IExternalWindow externalWindow, Surface amcSurface, Surface avcSurface) {
        BLog.i(TAG, "onSurfaceCreate() amcSurface :" + amcSurface + " | avcSurface:" + avcSurface);
        synchronized (this.mLock) {
            BiliRenderContext.createEGLContext(BiliRenderContext.currentEGLContext());
            createCapture();
            this.mCaptureThread.prepare(BiliRenderContext.currentEGLContext());
            this.mWeakWindow = new WeakReference<>(externalWindow);
            if (this.mInputOESFramebuffer != null) {
                this.mInputOESFramebuffer.destroy();
            }
            if (this.mOESRetrieval != null) {
                this.mOESRetrieval.destroy();
                this.mOESRetrieval = null;
                this.isDolbyInit = false;
                BLog.i(TAG, "SurfaceCreate OESRetrieval destroy()");
            }
            BLog.i(TAG, "SurfaceCreate OESRetrieval init()");
            this.mOESRetrieval = new BiliOESRetrieval(this.mSupportVivid);
            this.mOESRetrieval.enableHDR(this.mEnableSwHDR);
            this.mOESRetrieval.setDaltonismType(this.mDaltonizerType);
            if (this.mDolbyModel) {
                this.mOESRetrieval.initDolbyHDR(this.mDolbyConfigPath);
                this.mOESRetrieval.enableDolbyHDR(this.mDolbyModel);
                writeRpuCache();
                this.isDolbyInit = true;
            }
            this.mOESRetrieval.isHdrVivid(this.mIsHdrVivid);
            if (this.mVividDataList != null) {
                this.mOESRetrieval.setVividDataList(this.mVividDataList);
            }
            if (this.mRenderModel == 2 && this.mWeakContext != null) {
                this.mSensorHandler.init(this.mWeakContext.get());
                this.mSensorHandler.setOrientation(this.mOrientation);
            }
            if (this.mIjkRenderWrap != null) {
                this.mIjkRenderWrap.destroy();
                this.mIjkRenderWrap = null;
                BLog.i(TAG, "SurfaceCreate IjkRenderWrap destroy()");
            }
            BLog.i(TAG, "SurfaceCreate IjkRenderWrap init()");
            this.mIjkRenderWrap = new IJKTerminalRenderWrap(this.mRenderModel);
            this.mIjkRenderWrap.setVerticesModel(this.mVerticesCalcModel);
            this.mIjkRenderWrap.setDisplayRect(this.mDisplayRect);
            this.mIjkRenderWrap.setMatrix(this.mDisplayMatrix);
            this.mIjkRenderWrap.setBackgroundColor(this.mBackgroundColorRed, this.mBackgroundColorGreen, this.mBackgroundColorBlue, this.mBackgroundColorAlpha);
            if (this.mBgBitmap != null && !this.mBgBitmap.isRecycled()) {
                this.mIjkRenderWrap.runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.output.IJKPlayerExternalRender.1
                    @Override // java.lang.Runnable
                    public void run() {
                        IJKPlayerExternalRender.this.mIjkRenderWrap.setBackgroundImage(IJKPlayerExternalRender.this.mBgBitmap, IJKPlayerExternalRender.this.isRecycle, IJKPlayerExternalRender.this.mBgDisplayRect);
                    }
                });
            }
            BiliFrameBuffer.BiliTextureOptions options = new BiliFrameBuffer.BiliTextureOptions();
            options.textureTarget = 36197;
            this.mInputOESFramebuffer = new BiliFrameBuffer(16, 16, BiliFrameBuffer.FboModel.Fbo_HOLDER, 0, options);
            this.mOESRetrieval.setInputFrameBuffer(this.mInputOESFramebuffer, 0);
            this.mHeadFilter = this.mOESRetrieval;
            this.mLastFilter = this.mOESRetrieval;
            buildFilterChain();
            this.mLastFilter.addTarget(this.mIjkRenderWrap);
            this.mCaptureThread.setInputFrameBuffer(this.mInputOESFramebuffer);
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.IExternalRenderCallback
    public void onSurfaceChange(int width, int height) {
        BLog.i(TAG, "onSurfaceChange() width :" + width + " | height:" + height);
        this.mSurfaceSize = BiliSize.create(width, height);
        this.mIjkRenderWrap.setOutputSize(this.mSurfaceSize);
        this.mCaptureThread.setSurfaceSize(width, height);
    }

    @Override // tv.danmaku.ijk.media.player.render.IExternalRenderCallback
    public void onImageSizeChange(int imgWidth, int imgHeight) {
        BLog.i(TAG, "onImageSizeChange() width :" + imgWidth + " | height:" + imgHeight);
        this.mImageSize = BiliSize.create(imgWidth, imgHeight);
        this.mOESRetrieval.setInputSize(this.mImageSize, 0);
        this.mCaptureThread.setInputImageSize(imgWidth, imgHeight);
    }

    @Override // tv.danmaku.ijk.media.player.render.IExternalRenderCallback
    public void setSurfaceTextureMatrix(float[] matrix) {
        if (matrix.length != 16) {
            return;
        }
        if (this.mOESRetrieval != null) {
            this.mOESRetrieval.setSurfaceTextureMatrix(matrix);
        }
        if (this.mCaptureThread != null) {
            this.mCaptureThread.setSurfaceTextureMatrix(matrix);
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.IExternalRenderCallback
    public boolean drawFrame(int oes, long timeUS) {
        this.mRunOnDraw.runPendingOnDrawTasks();
        if (this.mOESRetrieval != null) {
            if (this.mDolbyModel && !this.isDolbyInit) {
                this.mOESRetrieval.initDolbyHDR(this.mDolbyConfigPath);
                writeRpuCache();
                this.isDolbyInit = true;
            } else if (!this.mDolbyModel && this.isDolbyInit) {
                this.mOESRetrieval.destroyDolbyHDR();
                this.isDolbyInit = false;
            }
        }
        this.mInputOESFramebuffer.updateTexture(oes);
        this.mInputOESFramebuffer.updateTimeUS(timeUS);
        if (this.mOESRetrieval != null) {
            this.mOESRetrieval.newFrameReady(timeUS, 0);
        }
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.render.IExternalRenderCallback
    public void onSurfaceDestroyed() {
        BLog.i(TAG, "onSurfaceDestroyed()");
        synchronized (this.mLock) {
            if (this.mSensorHandler != null) {
                this.mSensorHandler.releaseResources();
            }
            if (this.mOESRetrieval != null) {
                this.mOESRetrieval.removeAllTargets();
                this.mOESRetrieval.destroy();
                this.isDolbyInit = false;
                this.mOESRetrieval = null;
                BLog.i(TAG, "onSurfaceDestroyed() OESRetrieval destroy()");
            }
            if (this.mEnhanceFilter != null) {
                this.mEnhanceFilter.removeAllTargets();
                this.mEnhanceFilter = null;
                this.mEnableEnhance = false;
                this.mEnhanceType = null;
                BLog.i(TAG, "onSurfaceDestroyed() EnhanceFilter destroy()");
            }
            if (this.mBlurFilter != null) {
                this.mBlurFilter.removeAllTargets();
                this.mBlurFilter = null;
                BLog.i(TAG, "onSurfaceDestroyed() BlurFilter destroy()");
            }
            if (this.mMultiRenderFilter != null) {
                this.mMultiRenderFilter.removeAllTargets();
                this.mMultiRenderFilter.release();
                this.mMultiRenderFilter = null;
                BLog.i(TAG, "onSurfaceDestroyed() MultiRenderFilter destroy()");
            }
            if (this.mFrameNotifierFilter != null) {
                this.mFrameNotifierFilter.removeAllTargets();
                this.mFrameNotifierFilter = null;
                BLog.i(TAG, "onSurfaceDestroyed() FrameNotifierFilter destroy()");
            }
            if (this.mIjkRenderWrap != null) {
                this.mIjkRenderWrap.destroy();
                this.mIjkRenderWrap = null;
                BLog.i(TAG, "onSurfaceDestroyed() IjkRenderWrap destroy()");
            }
            if (this.mCaptureThread != null) {
                this.mCaptureThread.release();
            }
            if (this.mInputOESFramebuffer != null) {
                this.mInputOESFramebuffer.destroy();
            }
            BiliRenderContext.destroyContext(BiliEGLContext.currentEGLContext());
            this.mOrientation = BiliImageOrientation.Up;
            this.mCaptureThread = null;
            this.mInputOESFramebuffer = null;
            this.mHeadFilter = null;
            this.mLastFilter = null;
            if (this.mVividDataList != null) {
                this.mVividDataList = null;
                BLog.i(TAG, "[VividDataList LifeCycle] onSurfaceDestroyed() mVividDataList cleared");
            }
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void captureOneImage() {
        BLog.i(TAG, "captureOneImage()");
        synchronized (this.mLock) {
            if (this.mCaptureThread != null && this.mIjkRenderWrap != null) {
                BiliFrameBuffer outputFrame = this.mIjkRenderWrap.getOutputFrameBuffer();
                if (outputFrame != null) {
                    BiliSize targetSize = this.mImageSize;
                    if (this.isEnableMultiRender && this.mMultiRenderFilter != null) {
                        targetSize = this.mMultiRenderFilter.getOutputFrameBuffer().getSize();
                    }
                    this.mCaptureThread.setInputImageSize(targetSize.getWidth(), targetSize.getHeight());
                    if (this.mCaptureThread.getSurfaceSize() != null && !this.mCaptureThread.getSurfaceSize().equals(this.mSurfaceSize)) {
                        this.mCaptureThread.setSurfaceSize(this.mSurfaceSize.width, this.mSurfaceSize.height);
                    }
                    this.mCaptureThread.setInputFrameBuffer(outputFrame);
                    this.mCaptureThread.captureOneImage();
                } else {
                    BLog.i(TAG, "captureOneImage error");
                }
            }
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void captureOneImage(BiliSize size) {
        BLog.i(TAG, "captureOneImage()");
        synchronized (this.mLock) {
            if (this.mCaptureThread != null && this.mIjkRenderWrap != null) {
                BiliFrameBuffer outputFrame = this.mIjkRenderWrap.getOutputFrameBuffer();
                if (outputFrame != null) {
                    BiliSize targetSize = this.mImageSize;
                    if (this.isEnableMultiRender && this.mMultiRenderFilter != null) {
                        targetSize = this.mMultiRenderFilter.getOutputFrameBuffer().getSize();
                    }
                    this.mCaptureThread.setInputImageSize(targetSize.getWidth(), targetSize.getHeight());
                    if (!size.isSize()) {
                        this.mCaptureThread.setSurfaceSize(this.mImageSize.width, this.mImageSize.height);
                    } else {
                        this.mCaptureThread.setSurfaceSize(size.width, size.height);
                    }
                    this.mCaptureThread.setInputFrameBuffer(outputFrame);
                    this.mCaptureThread.captureOneImage();
                } else {
                    BLog.i(TAG, "captureOneImage error");
                }
            }
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void captureOneImage(BiliSize size, float[] matrix) {
        BLog.i(TAG, "captureOneImage()");
        synchronized (this.mLock) {
            if (this.mCaptureThread != null && this.mIjkRenderWrap != null) {
                BiliFrameBuffer outputFrame = this.mIjkRenderWrap.getOutputFrameBuffer();
                if (outputFrame != null) {
                    BiliSize targetSize = this.mImageSize;
                    if (this.isEnableMultiRender && this.mMultiRenderFilter != null) {
                        targetSize = this.mMultiRenderFilter.getOutputFrameBuffer().getSize();
                    }
                    this.mCaptureThread.setInputImageSize(targetSize.getWidth(), targetSize.getHeight());
                    if (!size.isSize()) {
                        this.mCaptureThread.setSurfaceSize(this.mImageSize.width, this.mImageSize.height);
                    } else {
                        this.mCaptureThread.setSurfaceSize(size.width, size.height);
                    }
                    this.mCaptureThread.setInputFrameBuffer(outputFrame);
                    this.mCaptureMatrix.setScale(1.0f);
                    this.mCaptureMatrix.setTranslate(0, 0);
                    this.mCaptureMatrix.setRotation(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                    System.arraycopy(matrix, 0, this.mCaptureMatrix.getMatrix(), 0, matrix.length);
                    this.mCaptureThread.captureOneImage();
                } else {
                    BLog.i(TAG, "captureOneImage error");
                }
            }
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void setCaptureFrameAvailableListener(IImageCapture.OnCaptureFrameAvailableListener frameAvailableListener) {
        try {
            synchronized (this.mLock) {
                if (this.mCaptureThread != null) {
                    this.mCaptureThread.setCaptureFrameAvailableListener(frameAvailableListener);
                }
            }
        } catch (Exception e) {
            BLog.e(TAG, e);
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void translate(int transX, int transY) {
        BLog.i(TAG, "translate()  x :" + transX + " y:" + transY);
        if (getRenderMatrix() != null) {
            getRenderMatrix().setTranslate(transX, transY);
        }
        if ((getCaptureModel() == 2 || getCaptureModel() == 6) && getCaptureMatrix() != null) {
            getCaptureMatrix().setTranslate(transX, transY);
        }
        notifyUpdate();
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void scale(float scale) {
        BLog.i(TAG, "scale() scale:" + scale);
        if (getRenderMatrix() != null) {
            getRenderMatrix().setScale(scale);
        }
        if ((getCaptureModel() == 1 || getCaptureModel() == 6) && getCaptureMatrix() != null) {
            getCaptureMatrix().setScale(scale);
        }
        notifyUpdate();
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void scale(float scaleX, float scaleY) {
        BLog.i(TAG, "scale() scaleX :" + scaleX + " scaleY:" + scaleY);
        if (getRenderMatrix() != null) {
            getRenderMatrix().setScale(scaleX, scaleY, 1.0f);
        }
        if ((getCaptureModel() == 1 || getCaptureModel() == 6) && getCaptureMatrix() != null) {
            getCaptureMatrix().setScale(scaleX, scaleY, 1.0f);
        }
        notifyUpdate();
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void rotate(float degree) {
        BLog.i(TAG, "rotate() degree:" + degree);
        if (getRenderMatrix() != null) {
            getRenderMatrix().setRotation(degree);
        }
        if ((getCaptureModel() == 3 || getCaptureModel() == 6) && getCaptureMatrix() != null) {
            getCaptureMatrix().setRotation(degree);
        }
        notifyUpdate();
    }

    public void transform(float scale, int tX, int tY, float degree) {
        BLog.i(TAG, "transform() scale:" + scale + " tX:" + tX + " tY:" + tY + " degree:" + degree);
        BiliMVPMatrix displayMatrix = getRenderMatrix();
        if (displayMatrix != null) {
            displayMatrix.setScale(scale);
            displayMatrix.setTranslate(tX, tY);
            displayMatrix.setRotation(degree);
        }
        BiliMVPMatrix captureMatrix = getCaptureMatrix();
        int captureModel = getCaptureModel();
        if (captureModel == 1 || captureModel == 6) {
            captureMatrix.setScale(scale);
        }
        if ((captureModel == 2 || captureModel == 6) && captureMatrix != null) {
            captureMatrix.setTranslate(tX, tY);
        }
        if (captureModel == 3 || captureModel == 6) {
            captureMatrix.setRotation(degree);
        }
        notifyUpdate();
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void rotate(float degreeX, float degreeY, float degreeZ) {
        BLog.i(TAG, "rotate() degreeX:" + degreeX + "| degreeY:" + degreeY + " | degreeZ:" + degreeZ);
        if (getRenderMatrix() != null) {
            getRenderMatrix().setRotation(degreeX, degreeY, degreeZ);
        }
        if ((getCaptureModel() == 3 || getCaptureModel() == 6) && getCaptureMatrix() != null) {
            getCaptureMatrix().setRotation(degreeX, degreeY, degreeZ);
        }
        notifyUpdate();
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void mirror(int type, boolean mirror) {
        BLog.i(TAG, "mirror() type" + type + " mirror:" + mirror);
        if (getRenderMatrix() != null) {
            getRenderMatrix().setMirror(type, mirror);
        }
        if ((getCaptureModel() == 4 || getCaptureModel() == 6) && getCaptureMatrix() != null) {
            getCaptureMatrix().setMirror(type, mirror);
        }
        notifyUpdate();
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void aspectRatio(int ratio) {
        BLog.i(TAG, "mirror() aspectRatio" + ratio);
        if (getRenderMatrix() != null) {
            getRenderMatrix().setAspectRatio(ratio);
        }
        if ((getCaptureModel() == 5 || getCaptureModel() == 6) && getCaptureMatrix() != null) {
            getCaptureMatrix().setAspectRatio(ratio);
        }
        notifyUpdate();
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public BiliSize getTransformSize() {
        BLog.i(TAG, "mirror() getTransformSize");
        return getRenderMatrix() != null ? getRenderMatrix().getTransformSize() : BiliSize.create(-1, -1);
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void setVerticesModel(int model) {
        this.mVerticesCalcModel = model;
        if (this.mIjkRenderWrap != null) {
            this.mIjkRenderWrap.setVerticesModel(model);
            notifyUpdateNow();
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void setDisplayRect(Rect displayRect) {
        this.mDisplayRect = displayRect;
        if (this.mIjkRenderWrap != null) {
            this.mIjkRenderWrap.setDisplayRect(displayRect);
            notifyUpdateNow();
        }
    }

    public Rect getDisplayRect() {
        return this.mDisplayRect;
    }

    private BiliMVPMatrix getCaptureMatrix() {
        return this.mCaptureMatrix;
    }

    private BiliMVPMatrix getRenderMatrix() {
        return this.mDisplayMatrix;
    }

    public void notifyUpdate() {
        try {
            if (this.mWeakWindow == null || this.mWeakWindow.get() == null) {
                return;
            }
            this.mWeakWindow.get().refreshWindow();
        } catch (Exception e) {
            BLog.e(TAG, e.getMessage());
        }
    }

    public void enableHDR(boolean enable) {
        BLog.i(TAG, "enableHDR:" + enable + " mIsHdrVivid" + this.mIsHdrVivid);
        this.mEnableSwHDR = enable;
        if (!enable) {
            boolean result = false;
            if (this.mWeakWindow != null && this.mWeakWindow.get() != null) {
                result = this.mWeakWindow.get().enableWindowHDR(enable);
            }
            if (enable && result) {
                return;
            }
            this.mEnableSwHDR = enable;
            if (this.mOESRetrieval != null) {
                this.mOESRetrieval.enableHDR(enable);
            }
        }
        if (this.mOESRetrieval != null) {
            this.mOESRetrieval.enableHDR(enable);
        }
        if (this.mIsHdrVivid && this.mWeakWindow != null && this.mWeakWindow.get() != null) {
            BLog.i(TAG, "enableHDR:" + enable + " HdrVivid enableWindowHDR result:" + this.mWeakWindow.get().enableWindowHDR(enable));
        }
    }

    public void enableHDRTryHW(boolean enable) {
        BLog.i(TAG, "enableHDRTryHW:" + enable);
        if (this.mWeakWindow != null && this.mWeakWindow.get() != null) {
            boolean result = this.mWeakWindow.get().enableWindowHDR(enable);
            BLog.i(TAG, "enableHDRTryHW:" + enable + " enableWindowHDR result:" + result);
            if (enable && result) {
                return;
            }
            this.mEnableSwHDR = enable;
            if (this.mOESRetrieval != null) {
                this.mOESRetrieval.enableHDR(enable);
            }
        }
    }

    public void enableHDRTryHW_LiveHdrVivid(boolean enable) {
        BLog.i(TAG, "enableHDRTryHW_LiveHdrVivid:" + enable);
        if (this.mWeakWindow != null && this.mWeakWindow.get() != null) {
            boolean result = this.mWeakWindow.get().enableWindowHDR(enable);
            BLog.i(TAG, "enableHDRTryHW_LiveHdrVivid, enableWindowHDR result:" + result);
        }
    }

    public void notifyUpdateNow() {
        try {
            if (this.mWeakWindow != null && this.mWeakWindow.get() != null) {
                this.mWeakWindow.get().refreshWindowNow();
            }
        } catch (Exception e) {
            BLog.e(TAG, e.getMessage());
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void switchRenderer(int model) {
        this.mRenderModel = model;
        if (this.mRenderModel == 2) {
            if (this.mSensorHandler == null) {
                this.mSensorHandler = new BiliSensorEventHandler();
            }
            this.mSensorHandler.setSensorChangedListener(null);
            this.mSensorHandler.releaseResources();
            this.mSensorHandler.setSensorChangedListener(this);
            if (this.mWeakContext != null) {
                this.mSensorHandler.init(this.mWeakContext.get());
            }
        }
        if (this.mIjkRenderWrap != null) {
            this.mIjkRenderWrap.switchRenderer(model);
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void setSensorContext(Context currentActivity) {
        if (this.mWeakContext != null) {
            this.mWeakContext.clear();
        }
        this.mWeakContext = new WeakReference<>(currentActivity);
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void setWindowOrientation(BiliImageOrientation orientation) {
        this.mOrientation = orientation;
        if (this.mSensorHandler != null) {
            this.mSensorHandler.setOrientation(this.mOrientation);
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.tools.BiliSensorEventHandler.SensorChangedListener
    public void sensorUpdateMatrix(BiliSensorEntity sensorEntity) {
        if (this.mIjkRenderWrap != null) {
            this.mIjkRenderWrap.setSensorMatrix(sensorEntity);
        }
        notifyUpdateNow();
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void setPanoramaRotation(float x, float y) {
        if (this.mIjkRenderWrap != null) {
            this.mIjkRenderWrap.setRotation(x, y);
        }
        notifyUpdateNow();
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void setPerspective(float value) {
        if (this.mIjkRenderWrap != null) {
            this.mIjkRenderWrap.setPerspective(value);
        }
        notifyUpdateNow();
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void setOperationModel(int model) {
        if (this.mIjkRenderWrap != null) {
            this.mIjkRenderWrap.setOperationModel(model);
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void openGyroSensor() {
        if (this.mSensorHandler != null && this.mWeakContext != null) {
            this.mSensorHandler.init(this.mWeakContext.get());
            this.mSensorHandler.setOrientation(this.mOrientation);
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void closeGyroSensor() {
        if (this.mSensorHandler != null) {
            this.mSensorHandler.releaseResources();
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void resetAxis(int index) {
        if (this.mSensorHandler != null) {
            this.mSensorHandler.resetAxis(index);
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void setDaltonismType(BiliDaltonizer.ColorBlindnessType type) {
        this.mDaltonizerType = type;
        if (this.mOESRetrieval != null) {
            this.mOESRetrieval.setDaltonismType(type);
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public BiliDaltonizer.ColorBlindnessType getDaltonismType() {
        return this.mDaltonizerType;
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void setBackgroundImage(Bitmap bitmap, boolean recycle, Rect rect) {
        this.mBgBitmap = bitmap;
        this.isRecycle = recycle;
        this.mBgDisplayRect = rect;
        if (this.mIjkRenderWrap != null) {
            this.mIjkRenderWrap.setBackgroundImage(bitmap, recycle, rect);
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void setOnFirstFrameListener(IJKEXTRendererInterface.OnFirstFrameListener firstFrameListener) {
        this.mOnFirstFrameListener = firstFrameListener;
    }

    @Override // tv.danmaku.ijk.media.player.render.IExternalRenderCallback
    public IJKEXTRendererInterface.OnFirstFrameListener getOnFirstFrameListener() {
        return this.mOnFirstFrameListener;
    }

    public void enableDolbyHDR(String configPath) {
        this.mDolbyConfigPath = configPath;
    }

    public void disableDolbyHDR() {
    }

    public void setDolbyModel(int model) {
        this.mDolbyModel = model == 3;
        BLog.i(TAG, "setDolbyModel " + this.mDolbyModel);
        if (this.mOESRetrieval != null) {
            this.mOESRetrieval.enableDolbyHDR(this.mDolbyModel);
        }
    }

    public void video_packet_callback(byte[] buffer, int size, long timeUS, int flag) {
        if (size > 0) {
            ByteBuffer rpuBuf = ByteBuffer.allocateDirect(buffer.length);
            rpuBuf.order(ByteOrder.nativeOrder());
            rpuBuf.put(buffer);
            rpuBuf.position(0);
            synchronized (this.mRPULock) {
                if (this.rpuBufferCache.size() >= 100) {
                    this.rpuBufferCache.remove(0);
                }
                this.rpuBufferCache.add(new Pair<>(rpuBuf, Long.valueOf(timeUS)));
                if (this.mOESRetrieval != null) {
                    this.mOESRetrieval.video_packet_callback(rpuBuf, timeUS, flag);
                }
            }
        } else if (this.mOESRetrieval != null) {
            this.mOESRetrieval.video_packet_callback(null, timeUS, flag);
        }
    }

    public void writeRpuCache() {
        synchronized (this.mRPULock) {
            BLog.i(TAG, "dolby init finish, write cache rpu size : " + this.rpuBufferCache.size());
            for (int i = 0; i < this.rpuBufferCache.size(); i++) {
                Pair<ByteBuffer, Long> data = this.rpuBufferCache.get(i);
                if (data != null) {
                    this.mOESRetrieval.video_packet_callback((ByteBuffer) data.first, ((Long) data.second).longValue(), 0);
                }
            }
        }
    }

    public void isHdrVivid(boolean enable) {
        this.mIsHdrVivid = enable;
        if (this.mOESRetrieval != null) {
            this.mOESRetrieval.isHdrVivid(enable);
        }
    }

    public void setVividDataList(Queue<Pair<ByteBuffer, Long>> list) {
        this.mVividDataList = list;
        if (this.mOESRetrieval != null) {
            this.mOESRetrieval.setVividDataList(list);
        }
    }

    public void flushVividDataList() {
        if (this.mVividDataList != null) {
            this.mVividDataList = null;
            BLog.i(TAG, "[VividDataList LifeCycle] flushVividDataList() mVividDataList cleared");
        }
        if (this.mOESRetrieval != null) {
            this.mOESRetrieval.flushVividDataList();
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.mBgBitmap != null && this.isRecycle && !this.mBgBitmap.isRecycled()) {
            this.mBgBitmap.recycle();
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.IExternalRenderCallback
    public void setBackgroundColor(float red, float green, float blue, float alpha) {
        this.mBackgroundColorRed = red;
        this.mBackgroundColorGreen = green;
        this.mBackgroundColorBlue = blue;
        this.mBackgroundColorAlpha = alpha;
        if (this.mIjkRenderWrap != null) {
            this.mIjkRenderWrap.setBackgroundColor(this.mBackgroundColorRed, this.mBackgroundColorGreen, this.mBackgroundColorBlue, this.mBackgroundColorAlpha);
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void setEnhance(boolean enable, IJKEXTRendererInterface.IjkEnhanceType type) {
        if (type != null) {
            if (this.mEnableEnhance == enable && this.mEnhanceType == type) {
                return;
            }
            this.mEnableEnhance = enable;
            this.mEnhanceType = type;
            BLog.i(TAG, "SetEnhance:" + enable + "enhanceType:" + type);
            this.mRunOnDraw.addTask(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.output.IJKPlayerExternalRender.2
                @Override // java.lang.Runnable
                public void run() {
                    IJKPlayerExternalRender.this.mOESRetrieval.removeAllTargets();
                    IJKPlayerExternalRender.this.buildFilterChain();
                }
            });
        }
    }

    public void clearEnhanceState() {
        BLog.i(TAG, "clearEnhanceState when replace item");
        this.mEnableEnhance = false;
        this.mEnhanceType = null;
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void setBlurRectList(final List<RectF> rectList) {
        this.mRunOnDraw.addTask(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.output.IJKPlayerExternalRender.3
            @Override // java.lang.Runnable
            public void run() {
                IJKPlayerExternalRender.this.mBlurRectList.clear();
                IJKPlayerExternalRender.this.mBlurRectList.addAll(rectList);
                IJKPlayerExternalRender.this.buildFilterChain();
            }
        });
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void clearBlurRect() {
        this.mRunOnDraw.addTask(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.output.IJKPlayerExternalRender.4
            @Override // java.lang.Runnable
            public void run() {
                IJKPlayerExternalRender.this.mBlurRectList.clear();
                IJKPlayerExternalRender.this.buildFilterChain();
            }
        });
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface
    public void setOnFrameRenderedListener(IJKEXTRendererInterface.OnFrameRenderedListener listener) {
        BLog.i(TAG, "setOnFrameRenderedListener");
        this.mOnFrameRenderedListener = listener;
        this.mRunOnDraw.addTask(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.output.IJKPlayerExternalRender$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                IJKPlayerExternalRender.this.m2641lambda$setOnFrameRenderedListener$0$tvdanmakuijkmediaplayerrenderoutputIJKPlayerExternalRender();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setOnFrameRenderedListener$0$tv-danmaku-ijk-media-player-render-output-IJKPlayerExternalRender  reason: not valid java name */
    public /* synthetic */ void m2641lambda$setOnFrameRenderedListener$0$tvdanmakuijkmediaplayerrenderoutputIJKPlayerExternalRender() {
        this.mOESRetrieval.removeAllTargets();
        buildFilterChain();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buildFilterChain() {
        if (this.mHeadFilter == null || this.mLastFilter == null) {
            return;
        }
        this.mHeadFilter.removeAllTargets();
        this.mLastFilter.removeAllTargets();
        this.mHeadFilter = this.mOESRetrieval;
        this.mLastFilter = this.mOESRetrieval;
        if (this.mEnhanceFilter != null) {
            this.mEnhanceFilter.removeAllTargets();
            this.mEnhanceFilter = null;
        }
        if (this.mEnableEnhance) {
            if (this.mEnhanceFilter == null) {
                boolean isPlus = this.mEnhanceType != null && this.mEnhanceType == IJKEXTRendererInterface.IjkEnhanceType.ShaderPlus;
                this.mEnhanceFilter = new BiliEnhanceFilter(isPlus);
            }
            this.mLastFilter.addTarget(this.mEnhanceFilter);
            this.mLastFilter = this.mEnhanceFilter;
        }
        if (!this.mBlurRectList.isEmpty()) {
            if (this.mBlurFilter == null) {
                this.mBlurFilter = new BiliGaussianFilter();
            }
            this.mBlurFilter.setBlurRectList(this.mBlurRectList);
            this.mLastFilter.addTarget(this.mBlurFilter);
            this.mLastFilter = this.mBlurFilter;
        } else if (this.mBlurFilter != null) {
            this.mBlurFilter.clearBlurRect();
            this.mBlurFilter.removeAllTargets();
            this.mBlurFilter = null;
        }
        if (this.isEnableMultiRender) {
            BLog.i(TAG, "build multi render filter");
            if (this.mMultiRenderFilter == null) {
                this.mMultiRenderFilter = new BiliMultiRenderFilter();
                this.mMultiRenderFilter.setMainScreenRect(this.mMainScreenRect);
                if (this.mSubSurface != null) {
                    this.mMultiRenderFilter.setSubWindowSurface(this.mSubSurface);
                    this.mMultiRenderFilter.setSubWindowCaptureRect(this.mSubScreenRect);
                }
            }
            this.mLastFilter.addTarget(this.mMultiRenderFilter);
            this.mLastFilter = this.mMultiRenderFilter;
        } else {
            BLog.i(TAG, "remove multi render filter");
            if (this.mMultiRenderFilter != null) {
                this.mMultiRenderFilter.removeAllTargets();
                this.mMultiRenderFilter.release();
                this.mMultiRenderFilter = null;
            }
        }
        if (this.mFrameNotifierFilter != null) {
            BLog.i(TAG, "ensure frame notifier removed");
            this.mFrameNotifierFilter.removeAllTargets();
            this.mFrameNotifierFilter = null;
        }
        if (this.mOnFrameRenderedListener != null) {
            BLog.i(TAG, "build frame notifier filter");
            this.mFrameNotifierFilter = new BiliFrameNotifierFakeFilter(this.mOnFrameRenderedListener);
            this.mLastFilter.addTarget(this.mFrameNotifierFilter);
            this.mLastFilter = this.mFrameNotifierFilter;
        }
        this.mLastFilter.addTarget(this.mIjkRenderWrap);
    }

    public void setEnableMultiRender(final boolean isEnable) {
        this.mRunOnDraw.addTask(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.output.IJKPlayerExternalRender.5
            @Override // java.lang.Runnable
            public void run() {
                IJKPlayerExternalRender.this.isEnableMultiRender = isEnable;
                IJKPlayerExternalRender.this.buildFilterChain();
            }
        });
    }

    public void setMultiMainCaptureRect(final RectF rect) {
        this.mRunOnDraw.addTask(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.output.IJKPlayerExternalRender.6
            @Override // java.lang.Runnable
            public void run() {
                if (IJKPlayerExternalRender.this.mMultiRenderFilter != null) {
                    BLog.i(IJKPlayerExternalRender.TAG, "setMultiMainCaptureRect:" + rect);
                    IJKPlayerExternalRender.this.mMultiRenderFilter.setMainScreenRect(rect);
                    IJKPlayerExternalRender.this.mMainScreenRect = rect;
                    return;
                }
                BLog.i(IJKPlayerExternalRender.TAG, "setMultiMainCaptureRect:mMultiRenderFilter is null" + rect);
            }
        });
    }

    public void setMultiSubWindowSurface(final Surface surface) {
        this.mRunOnDraw.addTask(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.output.IJKPlayerExternalRender.7
            @Override // java.lang.Runnable
            public void run() {
                if (IJKPlayerExternalRender.this.mMultiRenderFilter != null) {
                    IJKPlayerExternalRender.this.mMultiRenderFilter.setSubWindowSurface(surface);
                }
                IJKPlayerExternalRender.this.mSubSurface = surface;
            }
        });
    }

    public void setMultiSubWindowCaptureRect(final RectF rect) {
        this.mRunOnDraw.addTask(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.output.IJKPlayerExternalRender.8
            @Override // java.lang.Runnable
            public void run() {
                BLog.i(IJKPlayerExternalRender.TAG, "setMultiSubWindowCaptureRect:" + rect);
                IJKPlayerExternalRender.this.mMultiRenderFilter.setSubWindowCaptureRect(rect);
                IJKPlayerExternalRender.this.mSubScreenRect = rect;
            }
        });
    }
}