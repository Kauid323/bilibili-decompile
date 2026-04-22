package tv.danmaku.ijk.media.player.render.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLES20;
import android.util.DisplayMetrics;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.render.cache.BiliEGLContextCache;
import tv.danmaku.ijk.media.player.render.cache.BiliFrameBufferCache;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;
import tv.danmaku.ijk.media.player.render.tools.StringHelper;
import tv.danmaku.ijk.media.player.render.tools.hardware.BiliGPU;

public class BiliRenderContext {
    private static final String TAG = "BiliRenderContext";
    private static BiliRenderContext mShared;
    private String mCpuType;
    private String mExtensionNames;
    private String mGpuInfo;
    private int mMaxFragmentUniformVertors;
    private int mMaxTextureImageUnits;
    private int mMaxTextureOptimizedSize;
    private int mMaxTextureSize;
    private int mMaxVaryingVectors;
    private int mMaxVertexAttribs;
    private int mMaxVertexTextureImageUnits;
    private int mMaxVertexUniformVertors;
    private boolean mSupportFrameBufferReads;
    private boolean mSupportGL2;
    private boolean mSupportGL3;
    private boolean mSupportOESImageExternal;
    private boolean mSupportRedTextures;
    private float[] mVertexPointSizeRange;
    private final HashMap<String, BiliEGLContextCache> mEGLContextCache = new HashMap<>();
    private final LinkedList<IjkEglCore> mRenderThreadEGLContextCache = new LinkedList<>();
    private final LinkedList<EglCore> mCaptureThreadEGLContextCache = new LinkedList<>();
    private BiliSize mScreenSize = new BiliSize();

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface ResponseListener<T> {
        void response(T t);
    }

    public static BiliRenderContext shared() {
        return mShared;
    }

    public static synchronized BiliRenderContext init(Context context) {
        BiliRenderContext biliRenderContext;
        synchronized (BiliRenderContext.class) {
            if (context != null) {
                if (mShared == null) {
                    mShared = new BiliRenderContext();
                    mShared.initContext(context);
                }
            }
            biliRenderContext = mShared;
        }
        return biliRenderContext;
    }

    public static boolean isSupportGL2() {
        if (shared() == null) {
            return false;
        }
        return shared().mSupportGL2;
    }

    public static boolean isSupportGL3() {
        if (shared() == null) {
            return false;
        }
        return shared().mSupportGL3;
    }

    public static int getMaxTextureSize() {
        if (shared() == null) {
            return 0;
        }
        return shared().mMaxTextureSize;
    }

    public static int getMaxTextureOptimizedSize() {
        if (shared() == null) {
            return 0;
        }
        return shared().mMaxTextureOptimizedSize;
    }

    public static int getMaxTextureImageUnits() {
        if (shared() == null) {
            return 0;
        }
        return shared().mMaxTextureImageUnits;
    }

    public static int getMaxVertexAttribs() {
        if (shared() == null) {
            return 0;
        }
        return shared().mMaxVertexAttribs;
    }

    public static int getMaxVertexUniformVertors() {
        if (shared() == null) {
            return 0;
        }
        return shared().mMaxVertexUniformVertors;
    }

    public static int getMaxFragmentUniformVertors() {
        if (shared() == null) {
            return 0;
        }
        return shared().mMaxFragmentUniformVertors;
    }

    public static int getMaxVertexTextureImageUnits() {
        if (shared() == null) {
            return 0;
        }
        return shared().mMaxVertexTextureImageUnits;
    }

    public static int getMaxVaryingVectors() {
        if (shared() == null) {
            return 0;
        }
        return shared().mMaxVaryingVectors;
    }

    public float[] getVertexPointSize() {
        return shared() == null ? new float[4] : shared().mVertexPointSizeRange;
    }

    public static String getGpuInfo() {
        if (shared() == null) {
            return null;
        }
        return shared().mGpuInfo;
    }

    public static String getCpuType() {
        if (shared() == null) {
            return null;
        }
        return shared().mCpuType;
    }

    public static boolean isSupportRedTextures() {
        if (shared() == null) {
            return false;
        }
        return shared().mSupportRedTextures;
    }

    public static boolean isSupportFrameBufferReads() {
        if (shared() == null) {
            return false;
        }
        return shared().mSupportFrameBufferReads;
    }

    public static boolean isSupportOESImageExternal() {
        if (shared() == null) {
            return false;
        }
        return shared().mSupportOESImageExternal;
    }

    private BiliRenderContext() {
    }

    private void initContext(Context context) {
        this.mSupportGL2 = supportsOpenGLES2(context);
        if (!this.mSupportGL2) {
            BLog.e(TAG, "OpenGL ES 2.0 is not supported on this device.");
            return;
        }
        this.mSupportGL3 = supportsOpenGLES3(context);
        this.mScreenSize = screenSize(context);
        EglCore core = new EglCore();
        BiliOffscreenSurface pb = new BiliOffscreenSurface(core, 1, 1);
        pb.makeCurrent();
        this.mMaxTextureSize = glGetIntegerv(3379);
        this.mMaxTextureImageUnits = glGetIntegerv(34930);
        this.mMaxVertexAttribs = glGetIntegerv(34921);
        this.mMaxVertexUniformVertors = glGetIntegerv(36347);
        this.mMaxFragmentUniformVertors = glGetIntegerv(36349);
        this.mMaxVertexTextureImageUnits = glGetIntegerv(35660);
        this.mMaxVaryingVectors = glGetIntegerv(36348);
        this.mGpuInfo = GLES20.glGetString(7937);
        this.mCpuType = GLES20.glGetString(7936);
        this.mExtensionNames = GLES20.glGetString(7939);
        this.mVertexPointSizeRange = new float[4];
        GLES20.glGetFloatv(33901, this.mVertexPointSizeRange, 0);
        core.makeNothingCurrent();
        pb.release();
        this.mSupportRedTextures = supportsOpenGLESExtension("GL_EXT_texture_rg");
        this.mSupportFrameBufferReads = supportsOpenGLESExtension("GL_EXT_shader_framebuffer_fetch");
        this.mSupportOESImageExternal = supportsOpenGLESExtension("GL_OES_EGL_image_external");
        this.mMaxTextureOptimizedSize = BiliGPU.getMaxTextureOptimizedSize();
        dumpGPU();
        core.release();
    }

    private boolean supportsOpenGLES2(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        return configurationInfo != null && configurationInfo.reqGlEsVersion >= 131072;
    }

    private boolean supportsOpenGLES3(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        return configurationInfo != null && configurationInfo.reqGlEsVersion >= 196608;
    }

    private int glGetIntegerv(int type) {
        int[] values = new int[1];
        GLES20.glGetIntegerv(type, values, 0);
        return values[0];
    }

    public boolean supportsOpenGLESExtension(String extension) {
        if (StringHelper.isBlank(this.mExtensionNames) || StringHelper.isBlank(extension)) {
            return false;
        }
        return this.mExtensionNames.contains(extension);
    }

    public static BiliSize sizeThatFitsWithinATexture(BiliSize inputSize) {
        if (inputSize == null) {
            return null;
        }
        return inputSize.limitSize();
    }

    private BiliSize screenSize(Context context) {
        int screenWidth = 0;
        int screenHeight = 0;
        try {
            new DisplayMetrics();
            DisplayMetrics dm = context.getApplicationContext().getResources().getDisplayMetrics();
            screenWidth = dm.widthPixels;
            screenHeight = dm.heightPixels;
        } catch (Exception e) {
        }
        return BiliSize.create(screenWidth, screenHeight);
    }

    public BiliSize screenSize() {
        return this.mScreenSize;
    }

    public synchronized void addRenderEglCoreToCache(IjkEglCore core) {
        BLog.i(TAG, "addRenderEglCoreToCache : " + core);
        if (this.mRenderThreadEGLContextCache.contains(core)) {
            return;
        }
        this.mRenderThreadEGLContextCache.add(core);
    }

    public synchronized void removeRenderEglCoreToCache(IjkEglCore core) {
        BLog.i(TAG, "removeRenderEglCoreToCache : " + core);
        if (this.mRenderThreadEGLContextCache.size() == 0) {
            return;
        }
        this.mRenderThreadEGLContextCache.remove(core);
    }

    public int getRenderEglCoreCacheSize() {
        return this.mRenderThreadEGLContextCache.size();
    }

    public synchronized void addCaptureEglCoreToCache(EglCore core) {
        BLog.i(TAG, "addCaptureEglCoreToCache : " + core);
        if (this.mCaptureThreadEGLContextCache.contains(core)) {
            return;
        }
        this.mCaptureThreadEGLContextCache.add(core);
    }

    public synchronized void removeCaptureEglCoreToCache(EglCore core) {
        BLog.i(TAG, "removeCaptureEglCoreToCache : " + core);
        if (this.mRenderThreadEGLContextCache.size() == 0) {
            return;
        }
        this.mCaptureThreadEGLContextCache.remove(core);
    }

    public int getCaptureEglCoreCacheSize() {
        return this.mCaptureThreadEGLContextCache.size();
    }

    public static BiliProgram program(String vertexString, String fragmentString) {
        if (shared() == null || vertexString == null || fragmentString == null) {
            return null;
        }
        BiliEGLContextCache cache = getOrBuildEGLContextCache(BiliEGLContext.currentHashKey());
        if (cache == null) {
            BLog.e(TAG, String.format("Can not find GLProgram: %s", BiliEGLContext.currentEGLContext()));
            return null;
        }
        return cache.getProgram(vertexString, fragmentString);
    }

    public static void setActiveShaderProgram(BiliProgram shaderProgram) {
        if (shared() == null || shaderProgram == null) {
            return;
        }
        shaderProgram.use();
    }

    public static BiliFrameBufferCache sharedFramebufferCache() {
        BiliEGLContextCache cache;
        if (shared() == null || (cache = getOrBuildEGLContextCache(BiliEGLContext.currentHashKey())) == null) {
            return null;
        }
        return cache.sharedFramebufferCache();
    }

    public static void returnFramebufferToCache(BiliFrameBuffer fbo) {
        BiliEGLContextCache cache;
        if (shared() == null || fbo == null || fbo.isDestroy() || (cache = getOrBuildEGLContextCache(fbo.getEglContext().getHashKey())) == null) {
            return;
        }
        cache.returnFramebufferToCache(fbo);
    }

    public static void recycleFramebuffer(BiliFrameBuffer fbo) {
        BiliEGLContextCache cache;
        if (shared() == null || fbo == null || fbo.isDestroy() || (cache = shared().mEGLContextCache.get(fbo.getEglContext().getHashKey())) == null) {
            return;
        }
        cache.recycleFramebuffer(fbo);
    }

    public static BiliVertexBuffer fetchVertexbuffer(FloatBuffer buffer) {
        BiliEGLContextCache cache;
        if (shared() == null || buffer == null || (cache = getOrBuildEGLContextCache(BiliEGLContext.currentHashKey())) == null) {
            return null;
        }
        return cache.sharedEGLBufferCache().fetchVertexbuffer(buffer);
    }

    public static void recycleVertexbuffer(BiliVertexBuffer vbo) {
        BiliEGLContextCache cache;
        if (shared() == null || vbo == null || (cache = shared().mEGLContextCache.get(vbo.getEglContext().getHashKey())) == null) {
            return;
        }
        cache.sharedEGLBufferCache().recycleVertexbuffer(vbo);
    }

    public static BiliPixelBuffer fetchPixelBuffer(BiliSize size, int total) {
        BiliEGLContextCache cache;
        if (shared() == null || size == null || !size.isSize() || total < 1 || (cache = getOrBuildEGLContextCache(BiliEGLContext.currentHashKey())) == null) {
            return null;
        }
        return cache.sharedEGLBufferCache().fetchPixelBuffer(size, total);
    }

    public static void recyclePixelbuffer(BiliPixelBuffer pbo) {
        BiliEGLContextCache cache;
        if (shared() == null || pbo == null || (cache = shared().mEGLContextCache.get(pbo.getEglContext().getHashKey())) == null) {
            return;
        }
        cache.sharedEGLBufferCache().recyclePixelbuffer(pbo);
    }

    private static BiliEGLContextCache getOrBuildEGLContextCache(String key) {
        if (shared() == null || key == null || BiliEGLContext.equalsCurrent(EGL10.EGL_NO_CONTEXT)) {
            return null;
        }
        BiliEGLContextCache cache = shared().mEGLContextCache.get(key);
        if (cache == null) {
            createEGLContext(BiliEGLContext.currentEGLContext());
            return shared().mEGLContextCache.get(key);
        }
        return cache;
    }

    public static EGLContext currentEGLContext() {
        return BiliEGLContext.currentEGLContext();
    }

    public static GL10 currentGL() {
        return BiliEGLContext.currentGL();
    }

    public static synchronized void createEGLContext(EGLContext eglContext) {
        synchronized (BiliRenderContext.class) {
            if (shared() != null && eglContext != null && !eglContext.equals(EGL10.EGL_NO_CONTEXT)) {
                String hashKey = BiliEGLContext.currentHashKey();
                if (BiliEGLContext.equalsCurrent(eglContext) && !shared().mEGLContextCache.containsKey(hashKey)) {
                    shared().mEGLContextCache.put(hashKey, new BiliEGLContextCache());
                }
            }
        }
    }

    public static synchronized void destroyContext(EGLContext eglContext) {
        synchronized (BiliRenderContext.class) {
            if (shared() != null && eglContext != null && !eglContext.equals(EGL10.EGL_NO_CONTEXT)) {
                String hashKey = BiliEGLContext.currentHashKey(eglContext);
                BiliEGLContextCache cache = shared().mEGLContextCache.remove(hashKey);
                if (cache == null) {
                    return;
                }
                cache.destory();
            }
        }
    }

    public static boolean checkGlError(String tag) {
        int error = GLES20.glGetError();
        if (error != 0) {
            BLog.e(TAG, String.format("%s glError: 0x%s", tag, Integer.toHexString(error)));
            return true;
        }
        return false;
    }

    public void dumpGPU() {
        BLog.d(TAG, String.format("-------- GPU info --------", new Object[0]));
        BLog.d(TAG, String.format("mSupportGL2: %s", Boolean.valueOf(this.mSupportGL2)));
        BLog.d(TAG, String.format("mSupportGL3: %s", Boolean.valueOf(this.mSupportGL3)));
        BLog.d(TAG, String.format("mSupportRedTextures: %s", Boolean.valueOf(this.mSupportRedTextures)));
        BLog.d(TAG, String.format("mSupportFrameBufferReads: %s", Boolean.valueOf(this.mSupportFrameBufferReads)));
        BLog.d(TAG, String.format("mSupportOESImageExternal: %s", Boolean.valueOf(this.mSupportOESImageExternal)));
        BLog.d(TAG, String.format("mMaxTextureSize: %s", Integer.valueOf(this.mMaxTextureSize)));
        BLog.d(TAG, String.format("mMaxTextureOptimizedSize: %s", Integer.valueOf(this.mMaxTextureOptimizedSize)));
        BLog.d(TAG, String.format("mMaxTextureImageUnits: %s", Integer.valueOf(this.mMaxTextureImageUnits)));
        BLog.d(TAG, String.format("mMaxVertexAttribs: %s", Integer.valueOf(this.mMaxVertexAttribs)));
        BLog.d(TAG, String.format("mMaxVertexUniformVertors: %s", Integer.valueOf(this.mMaxVertexUniformVertors)));
        BLog.d(TAG, String.format("mMaxFragmentUniformVertors: %s", Integer.valueOf(this.mMaxFragmentUniformVertors)));
        BLog.d(TAG, String.format("mMaxVertexTextureImageUnits: %s", Integer.valueOf(this.mMaxVertexTextureImageUnits)));
        BLog.d(TAG, String.format("mMaxVaryingVectors: %s", Integer.valueOf(this.mMaxVaryingVectors)));
        BLog.d(TAG, String.format("mVertexPointSizeRange: [%f, %f]", Float.valueOf(this.mVertexPointSizeRange[0]), Float.valueOf(this.mVertexPointSizeRange[1])));
        BLog.d(TAG, String.format("mGpuInfo: %s", this.mGpuInfo));
        BLog.d(TAG, String.format("mCpuType: %s", this.mCpuType));
        BLog.d(TAG, String.format("mExtensionNames: %s", this.mExtensionNames));
    }
}