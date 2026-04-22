package tv.danmaku.ijk.media.player.render.cache;

import java.util.HashMap;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.render.core.BiliFrameBuffer;
import tv.danmaku.ijk.media.player.render.core.BiliProgram;
import tv.danmaku.ijk.media.player.render.core.BiliRenderContext;

public class BiliEGLContextCache {
    public static final String TAG = "BiliEGLContextCache";
    private final HashMap<String, BiliProgram> mShaderProgramCache = new HashMap<>();
    private final BiliFrameBufferCache mFramebufferCache = new BiliFrameBufferCache();
    private final BiliEGLBufferCache mEGLBufferCache = new BiliEGLBufferCache();

    public BiliProgram getProgram(String vertexString, String fragmentString) {
        if (vertexString == null || fragmentString == null) {
            return null;
        }
        String key = String.format("V: %s - F: %s", vertexString, fragmentString);
        BiliProgram cache = this.mShaderProgramCache.get(key);
        if (cache == null) {
            BiliProgram cache2 = BiliProgram.create(vertexString, fragmentString);
            this.mShaderProgramCache.put(key, cache2);
            return cache2;
        }
        return cache;
    }

    public BiliFrameBufferCache sharedFramebufferCache() {
        return this.mFramebufferCache;
    }

    public void returnFramebufferToCache(BiliFrameBuffer fbo) {
        this.mFramebufferCache.returnFramebufferToCache(fbo);
    }

    public void recycleFramebuffer(BiliFrameBuffer fbo) {
        this.mFramebufferCache.recycleFramebuffer(fbo);
    }

    public BiliEGLBufferCache sharedEGLBufferCache() {
        return this.mEGLBufferCache;
    }

    public void destory() {
        BLog.i(TAG, String.format("%s destory() %s|%s", TAG, this, BiliRenderContext.currentEGLContext()));
        this.mFramebufferCache.destroy();
        this.mEGLBufferCache.destroy();
        for (BiliProgram tmp : this.mShaderProgramCache.values()) {
            tmp.destroy();
        }
        this.mShaderProgramCache.clear();
    }
}