package tv.danmaku.ijk.media.player.render.core;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import java.nio.IntBuffer;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.render.tools.BiliHash;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;

public class BiliFrameBuffer {
    private static final String TAG = "BiliFrameBuffer";
    private boolean _bindHolder;
    private String _cacheHash;
    private int _channel;
    private boolean _destroy;
    private BiliEGLContext _egl_context;
    private int _framebuffer;
    private BiliHash _hash;
    private int _height;
    private Semaphore _imageCaptureSemaphore;
    private boolean _missingFrameBuffer;
    private FboModel _model;
    private String _name;
    private BiliTextureOptions _options;
    private int _referenceCount;
    private boolean _referenceDisabled;
    private int _renderbuffer;
    private int _texture;
    private long _timeUS;
    private int _unpack_alig;
    private int _width;
    private final int UNPACK_ALIG = 4;
    private ReentrantLock _lock = new ReentrantLock();

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class BiliTextureOptions {
        public int minFilter = 9729;
        public int magFilter = 9729;
        public int wrapS = 33071;
        public int wrapT = 33071;
        public int internalFormat = 6408;
        public int format = 6408;
        public int type = 5121;
        public int textureTarget = 3553;

        public String toString() {
            return "BiliTextureOptions{minFilter=" + this.minFilter + ", magFilter=" + this.magFilter + ", wrapS=" + this.wrapS + ", wrapT=" + this.wrapT + ", internalFormat=" + this.internalFormat + ", format=" + this.format + ", type=" + this.type + ", textureTarget=" + this.textureTarget + '}';
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum FboModel {
        Fbo_HOLDER(0),
        Fbo_PACKAGE(1),
        Fbo_TEXTURE(2),
        Fbo_TEXTURE_ACTIVE(3),
        Fbo_TEXTURE_OES(4),
        Fbo_FBO_AND_TEXTURE(5),
        Fbo_FBO_AND_TEXTURE_AND_RENDER(6);
        
        int index;

        FboModel(int index) {
            this.index = index;
        }

        public int getIndex() {
            return this.index;
        }
    }

    public static BiliFrameBuffer makeFrameBuffer(BiliSize size) {
        return makeFrameBuffer(size.getWidth(), size.getHeight());
    }

    public static BiliFrameBuffer makeFrameBuffer(int width, int height) {
        BiliTextureOptions options = new BiliTextureOptions();
        return makeFrameBuffer(width, height, FboModel.Fbo_FBO_AND_TEXTURE, options);
    }

    public static BiliFrameBuffer makeFrameBuffer(int width, int height, FboModel model, BiliTextureOptions options) {
        return new BiliFrameBuffer(width, height, model, 0, options);
    }

    public static BiliFrameBuffer makeTextureFromImage(Bitmap bitmap) {
        BiliTextureOptions options = new BiliTextureOptions();
        BiliFrameBuffer frameBuffer = makeFrameBuffer(bitmap.getWidth(), bitmap.getHeight(), FboModel.Fbo_TEXTURE, options);
        frameBuffer.bindTexture(bitmap, true);
        return frameBuffer;
    }

    public static BiliFrameBuffer makeTextureFromImage(Bitmap bitmap, BiliTextureOptions options) {
        BiliFrameBuffer frameBuffer = makeFrameBuffer(bitmap.getWidth(), bitmap.getHeight(), FboModel.Fbo_TEXTURE, options);
        frameBuffer.bindTexture(bitmap, true);
        return frameBuffer;
    }

    public static BiliFrameBuffer makeTextureHolder(int width, int height, int channels) {
        BiliTextureOptions options = new BiliTextureOptions();
        BiliFrameBuffer fbo = makeFrameBuffer(width, height, FboModel.Fbo_TEXTURE, options);
        fbo.bindTextureHolder(channels);
        return fbo;
    }

    public static BiliFrameBuffer makeOESTexture(int width, int height) {
        BiliTextureOptions options = new BiliTextureOptions();
        options.textureTarget = 36197;
        BiliFrameBuffer fbo = makeFrameBuffer(width, height, FboModel.Fbo_TEXTURE_OES, options);
        return fbo;
    }

    public BiliFrameBuffer(int width, int height, FboModel model, int texture, BiliTextureOptions option) {
        this._unpack_alig = 4;
        if (width == 0 || height == 0) {
            BLog.e(TAG, "init width or height is invalid");
            return;
        }
        this._width = width;
        this._height = height;
        this._model = model;
        this._texture = texture;
        this._options = option;
        if (model == FboModel.Fbo_HOLDER) {
            makeDestroy();
        }
        this._egl_context = new BiliEGLContext();
        this._unpack_alig = 4;
        if (((this._width % 4) & 1) == 1) {
            this._unpack_alig = 1;
        }
        if (this._width % 4 == 2) {
            this._unpack_alig = 2;
        }
        this._imageCaptureSemaphore = new Semaphore(0);
        this._imageCaptureSemaphore.release();
        boolean z = model.getIndex() <= FboModel.Fbo_TEXTURE_OES.getIndex();
        this._missingFrameBuffer = z;
        this._referenceDisabled = z;
        this._cacheHash = createHash(this._width, this._height, this._model, this._options);
        if (model.getIndex() <= FboModel.Fbo_PACKAGE.getIndex()) {
            return;
        }
        if (model.getIndex() <= FboModel.Fbo_TEXTURE_OES.getIndex()) {
            generateTexture(model.getIndex() == FboModel.Fbo_TEXTURE_ACTIVE.getIndex() ? 33985 : 0);
        } else if (model.getIndex() == FboModel.Fbo_FBO_AND_TEXTURE.getIndex()) {
            generateFramebuffer();
        } else if (model.getIndex() == FboModel.Fbo_FBO_AND_TEXTURE_AND_RENDER.getIndex()) {
            generateRenderbuffer();
        }
    }

    public static String createHash(int width, int height, FboModel model, BiliTextureOptions options) {
        return String.format("%s:%s:%s:%s", Integer.valueOf(width), Integer.valueOf(height), options.toString(), Integer.valueOf(model.getIndex()));
    }

    public String getName() {
        return this._name;
    }

    public BiliHash getHash() {
        return this._hash;
    }

    public void setHash(BiliHash hash) {
        this._hash = hash;
    }

    public boolean equalHash(BiliHash other) {
        if (this._hash.empty() || other.empty()) {
            return false;
        }
        return this._hash.equal(other);
    }

    public String getCacheHash() {
        return this._cacheHash;
    }

    public IntBuffer getRawBuffer() {
        if (this._framebuffer == 0) {
            BLog.e(TAG, "framebuffer not ready");
            return null;
        }
        IntBuffer imageBuffer = IntBuffer.allocate(this._width * this._height);
        GLES20.glBindFramebuffer(36160, this._framebuffer);
        GLES30.glReadBuffer(36064);
        GLES20.glViewport(0, 0, this._width, this._height);
        GLES20.glReadPixels(0, 0, this._width, this._height, 6408, this._options.type, imageBuffer);
        GLES20.glBindFramebuffer(36160, 0);
        return imageBuffer;
    }

    public boolean bindTexture(Bitmap bitmap, boolean smooth) {
        if (this._texture == 0) {
            BLog.e(TAG, "bindTexture not okey !");
            return false;
        } else if (this._width != bitmap.getWidth() || this._height != bitmap.getHeight()) {
            BLog.e(TAG, String.format("bindTexture empty image or incorrect wh[%d * %d], need[%d * %d]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(this._width), Integer.valueOf(this._height)));
            return false;
        } else {
            GLES20.glPixelStorei(3317, this._unpack_alig);
            GLES20.glBindTexture(this._options.textureTarget, this._texture);
            if (smooth) {
                GLES20.glTexParameteri(this._options.textureTarget, 10241, 9987);
            }
            GLUtils.texImage2D(this._options.textureTarget, 0, bitmap, 0);
            if (smooth) {
                GLES20.glGenerateMipmap(this._options.textureTarget);
            }
            GLES20.glBindTexture(this._options.textureTarget, 0);
            this._bindHolder = true;
            return true;
        }
    }

    public boolean bindTextureHolder(int channels) {
        if (this._texture == 0) {
            BLog.e(TAG, "bindTextureHolder not okey");
            return false;
        }
        this._channel = channels;
        GLES20.glPixelStorei(3317, this._unpack_alig);
        GLES20.glBindTexture(this._options.textureTarget, this._texture);
        GLES20.glTexParameteri(this._options.textureTarget, 10241, 9987);
        GLES20.glTexImage2D(this._options.textureTarget, 0, this._options.internalFormat, this._width, this._height, 0, this._options.format, this._options.type, null);
        GLES20.glGenerateMipmap(this._options.textureTarget);
        this._bindHolder = true;
        return true;
    }

    public BiliEGLContext getEglContext() {
        return this._egl_context;
    }

    public int getWidth() {
        return this._width;
    }

    public int getHeight() {
        return this._height;
    }

    public BiliSize getSize() {
        return new BiliSize(this._width, this._height);
    }

    public int getTexture() {
        return this._texture;
    }

    public long getTimeUS() {
        return this._timeUS;
    }

    public int getFrameBuffer() {
        return this._framebuffer;
    }

    public int getRenderBuffer() {
        return this._renderbuffer;
    }

    public FboModel getModel() {
        return this._model;
    }

    public BiliTextureOptions getOptions() {
        return this._options;
    }

    public void setReferenceDisabled(boolean enable) {
        this._referenceDisabled = enable;
    }

    public boolean isDestroy() {
        return this._destroy;
    }

    public void use() {
        if (this._framebuffer == 0) {
            BLog.e(TAG, "Framebuffer not ready!");
            return;
        }
        GLES20.glBindFramebuffer(36160, this._framebuffer);
        GLES20.glViewport(0, 0, this._width, this._height);
        checkFramebufferStatus("activateFramebuffer");
    }

    public void useTexture() {
        if (this._texture == 0) {
            BLog.e(TAG, "Texture not ready!");
        } else {
            GLES20.glBindTexture(this._options.textureTarget, this._texture);
        }
    }

    public void updateTexture(int texture) {
        this._texture = texture;
    }

    public void updateTimeUS(long timeUS) {
        this._timeUS = timeUS;
    }

    public void lock() {
        if (this._referenceDisabled) {
            return;
        }
        this._lock.lock();
        this._referenceCount++;
        this._lock.unlock();
    }

    public void unlock() {
        if (this._referenceDisabled) {
            return;
        }
        if (this._referenceCount < 1) {
            BLog.e(TAG, "Tried to overrelease a framebuffer, did you forget to call useNextFrameForImageCapture before using imageFromCurrentFramebuffer?");
            return;
        }
        this._lock.lock();
        this._referenceCount--;
        if (this._referenceCount < 1) {
            BiliRenderContext.returnFramebufferToCache(this);
        }
        this._lock.unlock();
    }

    public void recycle() {
        BiliRenderContext.returnFramebufferToCache(this);
    }

    public void clearAllLocks() {
        this._referenceCount = 0;
    }

    private void makeDestroy() {
        this._destroy = false;
    }

    private int generateTexture(int activeTexture) {
        if (activeTexture != 0) {
            GLES20.glActiveTexture(activeTexture);
        }
        int[] textures = new int[1];
        GLES20.glGenTextures(1, textures, 0);
        this._texture = textures[0];
        if (this._texture == 0) {
            BLog.e(TAG, "create_texture() failed!");
            return this._texture;
        }
        GLES20.glBindTexture(this._options.textureTarget, this._texture);
        GLES20.glTexParameteri(this._options.textureTarget, 10241, this._options.minFilter);
        GLES20.glTexParameteri(this._options.textureTarget, 10240, this._options.magFilter);
        GLES20.glTexParameteri(this._options.textureTarget, 10242, this._options.wrapS);
        GLES20.glTexParameteri(this._options.textureTarget, 10243, this._options.wrapT);
        return this._texture;
    }

    private int generateFramebuffer() {
        int[] fbos = new int[1];
        GLES20.glGenFramebuffers(1, fbos, 0);
        this._framebuffer = fbos[0];
        GLES20.glBindFramebuffer(36160, this._framebuffer);
        generateTexture(33985);
        GLES20.glBindTexture(this._options.textureTarget, this._texture);
        GLES20.glTexImage2D(this._options.textureTarget, 0, this._options.internalFormat, this._width, this._height, 0, this._options.format, this._options.type, null);
        GLES20.glFramebufferTexture2D(36160, 36064, this._options.textureTarget, this._texture, 0);
        checkFramebufferStatus("generateFramebuffer");
        GLES20.glBindTexture(this._options.textureTarget, 0);
        return this._framebuffer;
    }

    private int generateRenderbuffer() {
        generateFramebuffer();
        int[] rbos = new int[0];
        GLES20.glGenRenderbuffers(1, rbos, 0);
        this._renderbuffer = rbos[0];
        GLES20.glBindRenderbuffer(36161, this._renderbuffer);
        GLES20.glRenderbufferStorage(36161, 33189, this._width, this._height);
        GLES20.glBindFramebuffer(36160, this._renderbuffer);
        GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this._renderbuffer);
        GLES20.glBindRenderbuffer(36161, 0);
        checkFramebufferStatus("generateRenderbuffer");
        return this._renderbuffer;
    }

    private boolean checkFramebufferStatus(String tag) {
        int status = GLES20.glCheckFramebufferStatus(36160);
        if (status == 36053) {
            return true;
        }
        BLog.e(TAG, String.format("%s framebuffer error:[0x%x], fbo: %d, texture: %d, rbo: %d", tag, Integer.valueOf(status), Integer.valueOf(this._framebuffer), Integer.valueOf(this._texture), Integer.valueOf(this._renderbuffer)));
        return false;
    }

    public void destroy() {
        if (isDestroy()) {
            return;
        }
        makeDestroy();
        int[] deleteTextures = {this._texture};
        if (this._texture > 0) {
            GLES20.glDeleteTextures(1, deleteTextures, 0);
        }
        this._texture = 0;
        int[] deleteFrameBuffers = {this._framebuffer};
        if (this._framebuffer > 0) {
            GLES20.glDeleteFramebuffers(1, deleteFrameBuffers, 0);
        }
        this._framebuffer = 0;
        int[] deleteRenderBuffer = {this._renderbuffer};
        if (this._renderbuffer > 0) {
            GLES20.glDeleteRenderbuffers(1, deleteRenderBuffer, 0);
        }
        this._renderbuffer = 0;
        if (this._imageCaptureSemaphore != null) {
            this._imageCaptureSemaphore.release();
            this._imageCaptureSemaphore = null;
        }
    }
}