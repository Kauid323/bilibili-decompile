package tv.danmaku.ijk.media.player.render;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.Surface;
import java.util.concurrent.LinkedBlockingDeque;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.render.IExternalRenderCallback;
import tv.danmaku.ijk.media.player.render.core.BiliRenderContext;
import tv.danmaku.ijk.media.player.render.core.IjkEglCore;
import tv.danmaku.ijk.media.player.render.core.IjkGLUtils;
import tv.danmaku.ijk.media.player.render.core.IjkWindowSurface;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;

public class IjkExternalRenderThread implements SurfaceTexture.OnFrameAvailableListener, IExternalRenderCallback.IExternalWindow {
    private static final int EXTERNAL_RENDER_CREATE_GL_CONTEXT = 3;
    private static final int EXTERNAL_RENDER_DESTROY = 4;
    private static final int EXTERNAL_RENDER_DESTROY_GL_CONTEXT = 4;
    private static final int EXTERNAL_RENDER_INIT = 1;
    private static final int EXTERNAL_RENDER_SET_INTERNAL_SURFACE = 2;
    private static final String EXTERNAL_RENDER_THREAD = "ijk_ext_render";
    public static int EXTERNAL_RENDER_TYPE = 0;
    public static final int EXTERNAL_RENDER_TYPE_CHOREOGRAPHER = 1;
    public static final int EXTERNAL_RENDER_TYPE_NORMAL = 0;
    private static final long MIN_FRAME_INTERVAL = 8;
    private static final long PAUSE_LOOP_FPS = 50;
    private static final int RELEASE_QUIT = 3;
    private static final int RENDER_ONE_BLACK_FRAME = 2;
    private static final int RENDER_ONE_FRAME = 1;
    private static final int VIDEO_SIZE_SYNC_STATE_ITEM_RECEIVE_FIRST_FRAME = 1;
    private static final int VIDEO_SIZE_SYNC_STATE_NONE = 0;
    private static final long WATCHER_LOOP_TIME_MS = 16;
    private volatile boolean isCanPostRender;
    private boolean isFirstFrame;
    private volatile Surface mAmcSurface;
    private int mAvOESTextureID;
    private volatile Surface mAvSurface;
    private float mBackgroundColorBlue;
    private float mBackgroundColorGreen;
    private float mBackgroundColorRed;
    private volatile IjkEglCore mEglCore;
    private int mFrameAvailableFps;
    private long mFrameAvailableTimer;
    private GetPlayerPauseStateCallback mGetPlayerPauseStateCallback;
    private int mHeight;
    private int mImageDenNum;
    private volatile int mImageHeight;
    private int mImageSarNum;
    private volatile int mImageWidth;
    private volatile Surface mInternalSurface;
    private int mMcOESTextureID;
    private IjkExternalOESRenderer mOESRenderer;
    private boolean mQuitRender;
    private IExternalRenderCallback mRenderCallback;
    private Choreographer mRenderChoreographer;
    private LinkedBlockingDeque<Long> mRenderFrameList;
    private Handler mRenderHandler;
    private int mState;
    private int mWidth;
    private volatile IjkWindowSurface mWindowSurface;
    private SurfaceTexture updateSurfaceTexture;
    private BiliSize mImageSize = new BiliSize();
    private boolean isInit = false;
    private boolean isWSNeedCreate = false;
    private boolean isAttach = false;
    private boolean isSurfaceAttach = false;
    private volatile boolean isCallReleased = false;
    private volatile int mVideoSizeSyncState = 0;
    private HandlerThread mRenderThread = new HandlerThread(EXTERNAL_RENDER_THREAD);
    private long mLastUpdateTimeMS = 0;
    private final Object mSurfaceOptionLock = new Object();
    private boolean isOpenHDR = false;
    private boolean hasCallFirstFrame = false;
    private boolean isDisableFlashBlack = false;
    private boolean isDisableAlignSurfaceSize = false;
    private float mBackgroundColorAlpha = 1.0f;
    private Choreographer.FrameCallback mFrameCallback = new Choreographer.FrameCallback() { // from class: tv.danmaku.ijk.media.player.render.IjkExternalRenderThread.1
        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long frameTimeNanos) {
            try {
                IjkExternalRenderThread.this.isCanPostRender = true;
                IjkExternalRenderThread.this.renderOneFrame(false);
            } catch (Exception e) {
                BLog.e(IjkExternalRenderThread.EXTERNAL_RENDER_THREAD, "doFrame renderOneFrame error !");
                BLog.e(IjkExternalRenderThread.EXTERNAL_RENDER_THREAD, e.getMessage());
                if (IjkExternalRenderThread.this.mEglCore != null) {
                    IjkExternalRenderThread.this.mEglCore.makeNothingCurrent();
                }
            }
        }
    };
    private SurfaceTexture mAmcSurfaceTexture = new SurfaceTexture(0);
    private SurfaceTexture mAvSurfaceTexture = new SurfaceTexture(0);

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface GetPlayerPauseStateCallback {
        boolean isPlayerPause();
    }

    public IjkExternalRenderThread() {
        this.mAmcSurface = null;
        this.mAvSurface = null;
        this.mState = 0;
        this.mState = 1;
        this.mAmcSurfaceTexture.setOnFrameAvailableListener(this);
        this.mAvSurfaceTexture.setOnFrameAvailableListener(this);
        this.mRenderFrameList = new LinkedBlockingDeque<>();
        try {
            BiliSize defaultSize = BiliRenderContext.shared().screenSize();
            this.mAmcSurfaceTexture.setDefaultBufferSize(defaultSize.width, defaultSize.height);
            this.mAvSurfaceTexture.setDefaultBufferSize(defaultSize.width, defaultSize.height);
            this.mAmcSurfaceTexture.detachFromGLContext();
            this.mAvSurfaceTexture.detachFromGLContext();
        } catch (Exception e) {
            BLog.w(EXTERNAL_RENDER_THREAD, e);
        }
        this.mAmcSurface = new Surface(this.mAmcSurfaceTexture);
        this.mAvSurface = new Surface(this.mAvSurfaceTexture);
        BLog.i(EXTERNAL_RENDER_THREAD, "IjkExternalRenderThread() " + this);
        this.mRenderThread.start();
        this.mRenderHandler = new Handler(this.mRenderThread.getLooper()) { // from class: tv.danmaku.ijk.media.player.render.IjkExternalRenderThread.2
            @Override // android.os.Handler
            public void dispatchMessage(Message msg) {
                super.dispatchMessage(msg);
                try {
                    switch (msg.what) {
                        case 1:
                            if (IjkExternalRenderThread.this.mQuitRender) {
                                BLog.w(IjkExternalRenderThread.EXTERNAL_RENDER_THREAD, "[ Render Frame ] Handle Message is QuitRender");
                                return;
                            } else {
                                IjkExternalRenderThread.this.renderOneFrame(false);
                                return;
                            }
                        case 2:
                            if (IjkExternalRenderThread.this.mQuitRender) {
                                BLog.w(IjkExternalRenderThread.EXTERNAL_RENDER_THREAD, "[ Render Frame ] Handle Message is QuitRender");
                                return;
                            } else {
                                IjkExternalRenderThread.this.renderOneFrame(true);
                                return;
                            }
                        case 3:
                            IjkExternalRenderThread.this.mRenderHandler.removeCallbacksAndMessages(null);
                            IjkExternalRenderThread.this.mRenderThread.quit();
                            return;
                        default:
                            return;
                    }
                } catch (Exception e2) {
                    BLog.e(IjkExternalRenderThread.EXTERNAL_RENDER_THREAD, "msg:" + msg.what);
                    BLog.e(IjkExternalRenderThread.EXTERNAL_RENDER_THREAD, e2);
                }
            }
        };
        _createEGLCore();
        this.mRenderHandler.post(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.IjkExternalRenderThread.3
            @Override // java.lang.Runnable
            public void run() {
                IjkExternalRenderThread.this.mRenderChoreographer = Choreographer.getInstance();
                IjkExternalRenderThread.this.isCanPostRender = false;
                IjkExternalRenderThread.this.mRenderChoreographer.postFrameCallback(IjkExternalRenderThread.this.mFrameCallback);
            }
        });
    }

    public void setPlayerPauseStateCallback(GetPlayerPauseStateCallback callback) {
        BLog.i(EXTERNAL_RENDER_THREAD, "setPlayerPauseStateCallback:" + callback);
        this.mGetPlayerPauseStateCallback = callback;
    }

    public void setDisableFlashBlack(boolean disabled) {
        BLog.i(EXTERNAL_RENDER_THREAD, "setDisableFlashBlack:" + disabled);
        this.isDisableFlashBlack = disabled;
    }

    public void setDisableSurfaceAlign(boolean disable) {
        BLog.i(EXTERNAL_RENDER_THREAD, "setDisableSurfaceAlign:" + disable);
        this.isDisableAlignSurfaceSize = disable;
    }

    private void _createEGLCore() {
        if (this.mEglCore != null) {
            this.mEglCore.release();
        }
        this.mEglCore = new IjkEglCore();
        BiliRenderContext.shared().addRenderEglCoreToCache(this.mEglCore);
        int cacheSize = BiliRenderContext.shared().getRenderEglCoreCacheSize();
        BLog.i(EXTERNAL_RENDER_THREAD, "createEGLCore() eglCore cacheSize : " + cacheSize);
    }

    public void releaseGLCore() {
        BLog.i(EXTERNAL_RENDER_THREAD, "releaseGLCore() [" + this + "]");
        if (this.mRenderChoreographer != null) {
            this.mRenderChoreographer.removeFrameCallback(this.mFrameCallback);
            this.isCanPostRender = true;
        }
        releaseWindowSurface();
        _releaseEGLCore();
        BLog.i(EXTERNAL_RENDER_THREAD, "releaseGLCore() [" + this + "] end()");
    }

    public void quitExternalRender() {
        if (this.mQuitRender || !this.mRenderThread.isAlive()) {
            return;
        }
        this.mQuitRender = true;
        this.mRenderHandler.removeCallbacksAndMessages(null);
        this.mRenderHandler.sendEmptyMessage(3);
        releaseGLCore();
    }

    private void _releaseEGLCore() {
        try {
            if (this.mAmcSurfaceTexture != null) {
                this.mAmcSurfaceTexture.release();
            }
            if (this.mAvSurfaceTexture != null) {
                this.mAvSurfaceTexture.release();
            }
            if (this.mAvSurface != null) {
                this.mAvSurface.release();
            }
            if (this.mAmcSurface != null) {
                this.mAmcSurface.release();
            }
            if (this.mEglCore != null) {
                this.mEglCore.release();
            }
            BiliRenderContext.shared().removeRenderEglCoreToCache(this.mEglCore);
        } catch (Exception e) {
            BLog.e(EXTERNAL_RENDER_THREAD, e);
        }
        this.mEglCore = null;
        this.mAmcSurface = null;
        this.mAvSurface = null;
        this.mAmcSurfaceTexture = null;
        this.mAvSurfaceTexture = null;
        this.mRenderCallback = null;
        int cacheSize = BiliRenderContext.shared().getRenderEglCoreCacheSize();
        BLog.i(EXTERNAL_RENDER_THREAD, "Render Thread Released,eglCore cacheSize:" + cacheSize);
        this.mState = 4;
        this.isFirstFrame = false;
    }

    public boolean createWindowSurface(Surface surface) {
        this.mWidth = 0;
        this.mHeight = 0;
        BLog.i(EXTERNAL_RENDER_THREAD, "set internal surface :" + surface);
        this.mInternalSurface = surface;
        if (this.mQuitRender) {
            return false;
        }
        this.isCallReleased = false;
        synchronized (this.mSurfaceOptionLock) {
            if (!checkSurfaceStatus(surface)) {
                BLog.w(EXTERNAL_RENDER_THREAD, "_setSurface is null");
                this.isWSNeedCreate = true;
                return false;
            }
            this.mState = 2;
            boolean result = _createWindowSurface(surface);
            this.mState = 3;
            return result;
        }
    }

    private boolean _createWindowSurface(Surface internalSurface) {
        BLog.i(EXTERNAL_RENDER_THREAD, "_createWindowSurface() surface:" + internalSurface);
        if (this.mEglCore == null) {
            BLog.w(EXTERNAL_RENDER_THREAD, "not init gl core !");
            return false;
        }
        try {
            if (this.mWindowSurface != null) {
                _detachWindowSurface();
            }
            if (!checkSurfaceStatus(internalSurface)) {
                BLog.w(EXTERNAL_RENDER_THREAD, "_createWindowSurface internalSurface is invalid ! " + internalSurface);
                this.isWSNeedCreate = true;
                return false;
            }
            IjkWindowSurface windowSurface = new IjkWindowSurface(this.mEglCore, false);
            if (!windowSurface.createWindowSurface(internalSurface)) {
                BLog.e(EXTERNAL_RENDER_THREAD, "windowSurface createWindowSurface failed ! " + internalSurface);
                this.isWSNeedCreate = true;
                return false;
            }
            this.isWSNeedCreate = false;
            this.mWindowSurface = windowSurface;
            this.isInit = true;
            if (!checkSurfaceStatus(this.mInternalSurface)) {
                BLog.e(EXTERNAL_RENDER_THREAD, "_createWindowSurface to attachWindowSurface surface is invalid ! " + this.mInternalSurface);
                return true;
            }
            _attachWindowSurface();
            this.isCanPostRender = true;
            refreshWindowNow();
            BLog.i(EXTERNAL_RENDER_THREAD, "_createWindowSurface() end");
            return true;
        } catch (IllegalArgumentException e) {
            BLog.e(EXTERNAL_RENDER_THREAD, "_createWindowSurface Surface:" + internalSurface + " error : " + e.getMessage());
            BLog.e(EXTERNAL_RENDER_THREAD, e);
            return false;
        } catch (Exception e2) {
            BLog.e(EXTERNAL_RENDER_THREAD, "_createWindowSurface Surface:" + internalSurface + " error : " + e2.getMessage());
            BLog.e(EXTERNAL_RENDER_THREAD, e2);
            return false;
        }
    }

    private boolean _attachWindowSurface() {
        boolean supportHdrVivid = false;
        if (this.isInit && !this.isAttach) {
            BLog.i(EXTERNAL_RENDER_THREAD, "attachWindowSurface()");
            IjkEglCore eglCore = this.mEglCore;
            IjkWindowSurface windowSurface = this.mWindowSurface;
            Surface internalSurface = this.mInternalSurface;
            if (this.mEglCore == null || this.mWindowSurface == null || this.mInternalSurface == null || !this.mInternalSurface.isValid()) {
                return false;
            }
            if (!windowSurface.makeCurrent()) {
                IjkGLUtils.checkGlError("create Window MakeCurrent");
                BLog.e(EXTERNAL_RENDER_THREAD, "[PlayProblem] ijkExternalRenderError=makeCurrentFailed ! " + internalSurface.isValid());
                return false;
            }
            IjkGLUtils.checkGlError("create Window MakeCurrent");
            detachSurfaceTexture();
            if (1.0f - this.mBackgroundColorAlpha > 0.01d) {
                GLES20.glEnable(3042);
                GLES20.glBlendFunc(6406, 771);
            }
            if (!this.mEglCore.supportBT202PQ() && !this.isDisableFlashBlack) {
                GLES20.glViewport(0, 0, 16, 16);
                GLES20.glClearColor(this.mBackgroundColorRed, this.mBackgroundColorGreen, this.mBackgroundColorBlue, this.mBackgroundColorAlpha);
                GLES20.glClear(16640);
            }
            BLog.i(EXTERNAL_RENDER_THREAD, "attachWindow glClear : " + internalSurface.isValid());
            IjkGLUtils.checkGlError("clear frame");
            this.mOESRenderer = new IjkExternalOESRenderer();
            this.mOESRenderer.setBackgroundColor(this.mBackgroundColorRed, this.mBackgroundColorGreen, this.mBackgroundColorBlue, this.mBackgroundColorAlpha);
            this.mOESRenderer.onSurfaceCreate();
            IjkGLUtils.checkGlError("create OESRenderer");
            if (this.mRenderCallback != null) {
                if (this.mEglCore.getGlVersion() == 3 && this.mEglCore.supportExternal_essl3()) {
                    supportHdrVivid = true;
                }
                this.mRenderCallback.glesSupportHdrVivid(supportHdrVivid);
                this.mRenderCallback.onSurfaceCreate(this, this.mAmcSurface, this.mAvSurface);
            }
            IjkGLUtils.checkGlError("create render callback");
            this.mMcOESTextureID = IjkGLUtils.genOESTexture();
            this.mAvOESTextureID = IjkGLUtils.genOESTexture();
            if (getInternalSurfaceSize().isSize()) {
                BiliSize size = getInternalSurfaceSize();
                this.mAmcSurfaceTexture.setDefaultBufferSize(size.width, size.height);
                this.mAvSurfaceTexture.setDefaultBufferSize(size.width, size.height);
                BLog.i(EXTERNAL_RENDER_THREAD, "create window surface | set default size :" + size);
            }
            if (this.mRenderCallback != null) {
                this.mRenderCallback.setBackgroundColor(this.mBackgroundColorRed, this.mBackgroundColorGreen, this.mBackgroundColorBlue, this.mBackgroundColorAlpha);
            }
            attachSurfaceTexture(this.mMcOESTextureID, this.mAvOESTextureID);
            if (this.mImageWidth != 0 && this.mImageHeight != 0 && this.mRenderCallback != null) {
                this.mRenderCallback.onImageSizeChange(this.mImageWidth, this.mImageHeight);
            }
            if (!this.mEglCore.supportBT202PQ() && !this.isDisableFlashBlack) {
                windowSurface.swapBuffers();
            }
            eglCore.makeNothingCurrent();
            this.isAttach = true;
            return true;
        }
        return false;
    }

    public void setRenderCallback(IExternalRenderCallback renderCallback) {
        BLog.i(EXTERNAL_RENDER_THREAD, "set render callback " + renderCallback);
        this.mRenderCallback = renderCallback;
    }

    public void releaseWindowSurface() {
        this.mRenderHandler.removeMessages(1);
        this.mRenderHandler.removeMessages(2);
        BLog.i(EXTERNAL_RENDER_THREAD, "releaseWindowSurface() surface " + this.mInternalSurface);
        this.isCallReleased = true;
        if (EXTERNAL_RENDER_TYPE == 1) {
            if (this.mRenderChoreographer != null) {
                this.mRenderChoreographer.removeFrameCallback(this.mFrameCallback);
            }
            this.isCanPostRender = true;
        }
        synchronized (this.mSurfaceOptionLock) {
            try {
                _detachWindowSurface();
                this.mInternalSurface = null;
            } catch (Exception e) {
                BLog.e(EXTERNAL_RENDER_THREAD, "releaseWindowSurface  error : " + e.getMessage());
                BLog.e(EXTERNAL_RENDER_THREAD, e);
            }
        }
    }

    private void _detachWindowSurface() {
        if (this.isInit && this.isAttach) {
            this.isAttach = false;
            BLog.i(EXTERNAL_RENDER_THREAD, "detachWindowSurface()");
            if (this.mWindowSurface == null || this.mEglCore == null || this.mInternalSurface == null || !this.mInternalSurface.isValid()) {
                return;
            }
            this.mWidth = 0;
            this.mHeight = 0;
            try {
                if (!this.mWindowSurface.makeCurrent()) {
                    BLog.e(EXTERNAL_RENDER_THREAD, "makeCurrent() failed !");
                    this.mEglCore.makeNothingCurrent();
                    return;
                }
                IjkGLUtils.checkGlError("detach makeCurrent()");
                BLog.i(EXTERNAL_RENDER_THREAD, "detachWindowSurface() delete texture");
                GLES20.glDeleteTextures(1, new int[]{this.mMcOESTextureID}, 0);
                GLES20.glDeleteTextures(1, new int[]{this.mAvOESTextureID}, 0);
                detachSurfaceTexture();
                if (this.mRenderCallback != null) {
                    this.mRenderCallback.onSurfaceDestroyed();
                }
                this.mOESRenderer.release();
                this.mEglCore.makeNothingCurrent();
                this.mWindowSurface.release();
                IjkGLUtils.checkGlError("windowSurfaceRelease()");
                this.mOESRenderer = null;
                this.mWindowSurface = null;
                this.mState = 4;
                this.isInit = false;
            } catch (Exception e) {
                BLog.e(EXTERNAL_RENDER_THREAD, "detachWindowSurface() error ! " + e.getMessage());
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:13:0x0038
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public void renderOneFrame(boolean r28) {
        /*
            Method dump skipped, instructions count: 777
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.ijk.media.player.render.IjkExternalRenderThread.renderOneFrame(boolean):void");
    }

    private void updateAllTexImage(SurfaceTexture avTexture, SurfaceTexture amcTexture) {
        if (this.mAmcSurface != null && this.mAmcSurface.isValid()) {
            updateTexImage(avTexture);
        } else {
            BLog.w(EXTERNAL_RENDER_THREAD, "updateAllTexImage() mAmcSurface : " + this.mAvSurface);
        }
        if (this.mAvSurface != null && this.mAvSurface.isValid()) {
            updateTexImage(amcTexture);
        } else {
            BLog.w(EXTERNAL_RENDER_THREAD, "updateAllTexImage() mAvSurface : " + this.mAvSurface);
        }
    }

    private void updateTexImage(SurfaceTexture surfaceTexture) {
        if (surfaceTexture == null) {
            BLog.e(EXTERNAL_RENDER_THREAD, "updateTexImage() null surfaceTexture");
            return;
        }
        long ts = surfaceTexture.getTimestamp();
        while (true) {
            surfaceTexture.updateTexImage();
            long newTs = surfaceTexture.getTimestamp();
            if (ts != newTs) {
                ts = newTs;
            } else {
                return;
            }
        }
    }

    public void setVideoSize(int width, int height) {
        if (this.mImageSarNum != 0 && this.mImageDenNum != 0 && this.mImageSarNum != this.mImageDenNum) {
            float ratio = this.mImageSarNum / this.mImageDenNum;
            float displayAspectRatio = (width / height) * ratio;
            height = (int) (width / displayAspectRatio);
            width = (int) (height * displayAspectRatio);
        }
        if (this.mImageSarNum == 0 && this.mImageDenNum == 0) {
            return;
        }
        if (this.mImageWidth == width && this.mImageHeight == height) {
            return;
        }
        BLog.i(EXTERNAL_RENDER_THREAD, "onVideoSizeChanged w:" + width + " h:" + height + " num:" + this.mImageSarNum + " den:" + this.mImageDenNum);
        this.mImageWidth = width;
        this.mImageHeight = height;
        this.mAmcSurfaceTexture.setDefaultBufferSize(this.mImageWidth, this.mImageHeight);
        this.mAvSurfaceTexture.setDefaultBufferSize(this.mImageWidth, this.mImageHeight);
    }

    public void setAspectRatio(int sarNum, int denNum) {
        this.mImageSarNum = sarNum;
        this.mImageDenNum = denNum;
    }

    private void _videoSize(int width, int height) {
        if (this.mImageSize.width == width && this.mImageSize.height == height) {
            return;
        }
        this.mImageSize.width = width;
        this.mImageSize.height = height;
        BLog.i(EXTERNAL_RENDER_THREAD, "_videoSize width" + this.mImageSize.width + "  height:" + this.mImageSize.height);
        if (this.mRenderCallback != null) {
            this.mRenderCallback.onImageSizeChange(width, height);
        }
    }

    private BiliSize getInternalSurfaceSize() {
        BiliSize size = BiliSize.create(0, 0);
        try {
        } catch (Exception ex) {
            BLog.e(EXTERNAL_RENDER_THREAD, ex);
        }
        if (this.mWindowSurface == null) {
            return size;
        }
        size.width = this.mWindowSurface.getWidth();
        size.height = this.mWindowSurface.getHeight();
        return size;
    }

    public Surface getAmcSurface() {
        BLog.i(EXTERNAL_RENDER_THREAD, "getAmcSurface() :" + this.mAmcSurface);
        return this.mAmcSurface;
    }

    public Surface getAvSurface() {
        BLog.i(EXTERNAL_RENDER_THREAD, "getAvSurface() :" + this.mAvSurface);
        return this.mAvSurface;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.mQuitRender) {
            BLog.w(EXTERNAL_RENDER_THREAD, "onFrameAvailable() Quit Render");
            return;
        }
        this.updateSurfaceTexture = surfaceTexture;
        releaseFrame();
        if (this.mFrameAvailableTimer == 0) {
            this.mFrameAvailableTimer = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() - this.mFrameAvailableTimer >= 1000) {
            if (this.mFrameAvailableFps < 20) {
                BLog.w(EXTERNAL_RENDER_THREAD, "onFrameAvailable is low fps : " + this.mFrameAvailableFps);
            }
            this.mFrameAvailableTimer = System.currentTimeMillis();
        }
        this.mFrameAvailableFps++;
        if (!this.isFirstFrame) {
            this.mVideoSizeSyncState = 1;
            BLog.i(EXTERNAL_RENDER_THREAD, "first frame render，mVideoSizeSyncState:" + this.mVideoSizeSyncState);
            this.mLastUpdateTimeMS = System.currentTimeMillis();
            this.isFirstFrame = true;
            this.hasCallFirstFrame = false;
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.IExternalRenderCallback.IExternalWindow
    public void refreshWindow() {
        if (isValidRend() && this.isFirstFrame) {
            releaseFrame();
            if (!this.mRenderFrameList.isEmpty()) {
                this.mRenderFrameList.removeFirst();
            }
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.IExternalRenderCallback.IExternalWindow
    public void refreshWindowNow() {
        if (!this.mRenderThread.isAlive() || this.mRenderHandler.hasMessages(1) || this.mRenderHandler.hasMessages(2)) {
            return;
        }
        if (EXTERNAL_RENDER_TYPE == 1) {
            this.isCanPostRender = true;
        }
        releaseFrame();
    }

    @Override // tv.danmaku.ijk.media.player.render.IExternalRenderCallback.IExternalWindow
    public boolean enableWindowHDR(boolean enable) {
        if (this.mEglCore == null) {
            return false;
        }
        boolean isEnableWindowHDR = this.mEglCore.supportBT202PQ();
        if (!isEnableWindowHDR) {
            BLog.i(EXTERNAL_RENDER_THREAD, "EGL_EXTENSIONS supportBT202PQ:false");
            return false;
        } else if (enable || this.isOpenHDR || this.mEglCore.isNeedOpenHDR()) {
            if (!this.isOpenHDR && enable) {
                this.mEglCore.setNeedOpenHDR(enable);
                this.isOpenHDR = this.mEglCore.isNeedOpenHDR();
                Surface temp = this.mInternalSurface;
                releaseWindowSurface();
                isEnableWindowHDR = createWindowSurface(temp);
                BLog.i(EXTERNAL_RENDER_THREAD, "createWindowSurface:" + isEnableWindowHDR);
            } else if (this.isOpenHDR && this.mEglCore.isNeedOpenHDR() && !enable) {
                this.isOpenHDR = false;
                this.mEglCore.setNeedOpenHDR(enable);
                this.mRenderHandler.removeMessages(1);
                this.mRenderHandler.removeMessages(2);
                synchronized (this.mSurfaceOptionLock) {
                    Surface temp2 = this.mInternalSurface;
                    _detachWindowSurface();
                    if (this.mEglCore != null) {
                        this.mEglCore.release();
                    }
                    BiliRenderContext.shared().removeRenderEglCoreToCache(this.mEglCore);
                    _createEGLCore();
                    _createWindowSurface(temp2);
                }
            }
            if (enable && this.mEglCore.isNeedOpenHDR() && !isEnableWindowHDR) {
                this.mEglCore.setNeedOpenHDR(false);
                this.isOpenHDR = false;
                Surface temp3 = this.mInternalSurface;
                releaseWindowSurface();
                createWindowSurface(temp3);
            }
            return isEnableWindowHDR;
        } else {
            return false;
        }
    }

    public void freshBlackFrame() {
        Message msg = this.mRenderHandler.obtainMessage(2);
        if (this.mRenderThread.isAlive()) {
            this.mRenderHandler.sendMessage(msg);
        }
    }

    private void releaseFrame() {
        if (this.mRenderThread == null || !this.mRenderThread.isAlive() || this.mQuitRender) {
            BLog.e(EXTERNAL_RENDER_THREAD, "RenderThread:" + this.mRenderThread + " mQuitRender " + this.mQuitRender);
        } else if (EXTERNAL_RENDER_TYPE == 1) {
            if (this.isCanPostRender && this.mRenderChoreographer != null) {
                this.isCanPostRender = false;
                this.mRenderChoreographer.postFrameCallback(this.mFrameCallback);
            }
        } else if (EXTERNAL_RENDER_TYPE == 0) {
            Message msg = this.mRenderHandler.obtainMessage(1);
            this.mRenderHandler.sendMessage(msg);
        }
    }

    private boolean isValidRend() {
        long timeMS = SystemClock.elapsedRealtime();
        if (this.mRenderFrameList.isEmpty()) {
            this.mRenderFrameList.addLast(Long.valueOf(timeMS));
            return true;
        }
        BLog.w(EXTERNAL_RENDER_THREAD, " diff time " + Math.abs(this.mRenderFrameList.getLast().longValue() - timeMS));
        return Math.abs(this.mRenderFrameList.getLast().longValue() - timeMS) >= 8;
    }

    private void detachSurfaceTexture() {
        if (this.isSurfaceAttach) {
            try {
                BLog.i(EXTERNAL_RENDER_THREAD, "detachWindowSurface() detach SurfaceTexture");
                if (this.mAmcSurfaceTexture != null) {
                    this.mAmcSurfaceTexture.detachFromGLContext();
                }
                if (this.mAvSurfaceTexture != null) {
                    this.mAvSurfaceTexture.detachFromGLContext();
                }
                this.isSurfaceAttach = false;
            } catch (Exception e) {
                BLog.w(EXTERNAL_RENDER_THREAD, e);
            }
        }
    }

    private void attachSurfaceTexture(int mcOes, int avOes) {
        if (this.isSurfaceAttach) {
            return;
        }
        try {
            if (this.mAmcSurfaceTexture != null) {
                this.mAmcSurfaceTexture.attachToGLContext(mcOes);
            }
            if (this.mAvSurfaceTexture != null) {
                this.mAvSurfaceTexture.attachToGLContext(avOes);
            }
            updateAllTexImage(this.mAvSurfaceTexture, this.mAmcSurfaceTexture);
        } catch (Exception e) {
            BLog.w(EXTERNAL_RENDER_THREAD, e);
        }
        this.isSurfaceAttach = true;
    }

    private boolean checkSurfaceStatus(Surface surface) {
        if (surface == null || !surface.isValid()) {
            return false;
        }
        return true;
    }

    public boolean isInit() {
        return this.mInternalSurface != null && this.isInit;
    }

    public void resetFirstFrame() {
        this.isFirstFrame = false;
        this.mVideoSizeSyncState = 0;
        BLog.i(EXTERNAL_RENDER_THREAD, "resetFirstFrame() VideoSizeSyncState:" + this.mVideoSizeSyncState);
    }

    public void resetHasCallFirstFrame() {
        this.hasCallFirstFrame = false;
        BLog.i(EXTERNAL_RENDER_THREAD, "resetHasCallFirstFrame() false");
    }

    public void setBackgroundColor(float red, float green, float blue, float alpha) {
        this.mBackgroundColorRed = red;
        this.mBackgroundColorGreen = green;
        this.mBackgroundColorBlue = blue;
        this.mBackgroundColorAlpha = alpha;
        if (this.mOESRenderer != null) {
            this.mOESRenderer.setBackgroundColor(red, green, blue, alpha);
        }
    }

    protected void finalize() throws Throwable {
        try {
            try {
            } catch (Exception e) {
                BLog.e(EXTERNAL_RENDER_THREAD, e);
            }
            if (this.mQuitRender) {
                return;
            }
            BLog.w(EXTERNAL_RENDER_THREAD, "finalize() release : " + this);
            quitExternalRender();
            _releaseEGLCore();
        } finally {
            super.finalize();
        }
    }
}