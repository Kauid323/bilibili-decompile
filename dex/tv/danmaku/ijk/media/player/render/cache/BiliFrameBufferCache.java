package tv.danmaku.ijk.media.player.render.cache;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tv.danmaku.ijk.media.player.render.core.BiliFrameBuffer;

public final class BiliFrameBufferCache {
    private static final String TAG = "BiliFrameBufferCache";
    private boolean isDestroy;
    private final Object _lock = new Object();
    private ArrayList<BiliFrameBuffer> _fbo_works = new ArrayList<>();
    private ArrayList<BiliFrameBuffer> _fbo_recycles = new ArrayList<>();
    private ArrayList<BiliFrameBuffer> _fbo_local_list = new ArrayList<>();
    private HashMap<String, ArrayList<BiliFrameBuffer>> _fbo_local_map = new HashMap<>();

    private void clear() {
        synchronized (this._lock) {
            this._fbo_local_list.clear();
            this._fbo_works.clear();
            Iterator<BiliFrameBuffer> it = this._fbo_recycles.iterator();
            while (it.hasNext()) {
                BiliFrameBuffer frameBuffer = it.next();
                frameBuffer.destroy();
            }
            this._fbo_recycles.clear();
        }
    }

    private void clearTemp() {
        synchronized (this._lock) {
            Iterator<BiliFrameBuffer> it = this._fbo_recycles.iterator();
            while (it.hasNext()) {
                BiliFrameBuffer buffer = it.next();
                if (buffer == null) {
                    return;
                }
                ArrayList<BiliFrameBuffer> itemList = this._fbo_local_map.get(buffer.getCacheHash());
                if (itemList != null && itemList.size() != 0) {
                    itemList.remove(buffer);
                    buffer.destroy();
                }
            }
            this._fbo_recycles.clear();
        }
    }

    public BiliFrameBuffer fetchOESTexture(int width, int height) {
        BiliFrameBuffer frameBuffer = BiliFrameBuffer.makeOESTexture(width, height);
        synchronized (this._lock) {
            this._fbo_works.add(frameBuffer);
        }
        clearTemp();
        return frameBuffer;
    }

    public BiliFrameBuffer fetchTexture(Bitmap bitmap) {
        BiliFrameBuffer frameBuffer = BiliFrameBuffer.makeTextureFromImage(bitmap);
        synchronized (this._lock) {
            this._fbo_works.add(frameBuffer);
        }
        clearTemp();
        return frameBuffer;
    }

    public BiliFrameBuffer fetchTextureHolder(int width, int height, int channels) {
        BiliFrameBuffer frameBuffer = BiliFrameBuffer.makeTextureHolder(width, height, channels);
        synchronized (this._lock) {
            this._fbo_works.add(frameBuffer);
        }
        clearTemp();
        return frameBuffer;
    }

    public BiliFrameBuffer fetchFramebuffer(int width, int height) {
        BiliFrameBuffer sfbo;
        BiliFrameBuffer sfbo2;
        BiliFrameBuffer.BiliTextureOptions options = new BiliFrameBuffer.BiliTextureOptions();
        String hash = BiliFrameBuffer.createHash(width, height, BiliFrameBuffer.FboModel.Fbo_FBO_AND_TEXTURE, options);
        synchronized (this._lock) {
            try {
                ArrayList<BiliFrameBuffer> fbos = this._fbo_local_map.get(hash);
                if (fbos != null && !fbos.isEmpty()) {
                    BiliFrameBuffer sfbo3 = fbos.get(fbos.size() - 1);
                    fbos.remove(sfbo3);
                    this._fbo_local_list.remove(sfbo3);
                    this._fbo_works.add(sfbo3);
                    sfbo = sfbo3;
                } else {
                    sfbo = null;
                }
                if (sfbo != null) {
                    sfbo2 = sfbo;
                } else {
                    try {
                        sfbo2 = new BiliFrameBuffer(width, height, BiliFrameBuffer.FboModel.Fbo_FBO_AND_TEXTURE, 0, options);
                        this._fbo_works.add(sfbo2);
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
                clearTemp();
                if (sfbo2 != null) {
                    sfbo2.lock();
                }
                return sfbo2;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public BiliFrameBuffer fetchFramebuffer(int width, int height, BiliFrameBuffer.BiliTextureOptions options) {
        String hash = BiliFrameBuffer.createHash(width, height, BiliFrameBuffer.FboModel.Fbo_FBO_AND_TEXTURE, options);
        BiliFrameBuffer sfbo = null;
        synchronized (this._lock) {
            ArrayList<BiliFrameBuffer> fbos = this._fbo_local_map.get(hash);
            if (fbos != null && !fbos.isEmpty()) {
                sfbo = fbos.get(fbos.size() - 1);
                fbos.remove(sfbo);
                this._fbo_local_list.remove(sfbo);
                this._fbo_works.add(sfbo);
            }
            if (sfbo == null) {
                sfbo = new BiliFrameBuffer(width, height, BiliFrameBuffer.FboModel.Fbo_FBO_AND_TEXTURE, 0, options);
                this._fbo_works.add(sfbo);
            }
        }
        clearTemp();
        if (sfbo != null) {
            sfbo.lock();
        }
        return sfbo;
    }

    public void returnFramebufferToCache(BiliFrameBuffer frameBuffer) {
        if (frameBuffer == null) {
            return;
        }
        if (frameBuffer.isDestroy()) {
            recycleFramebuffer(frameBuffer);
            return;
        }
        synchronized (this._lock) {
            if (this._fbo_works.contains(frameBuffer)) {
                this._fbo_works.remove(frameBuffer);
            }
            addFramebuffer(frameBuffer, this._fbo_local_map);
            this._fbo_local_list.add(frameBuffer);
        }
        clearTemp();
    }

    private void addFramebuffer(BiliFrameBuffer frameBuffer, HashMap<String, ArrayList<BiliFrameBuffer>> map) {
        if (frameBuffer == null) {
            return;
        }
        if (map.get(frameBuffer.getCacheHash()) != null) {
            map.get(frameBuffer.getCacheHash()).add(frameBuffer);
            return;
        }
        ArrayList<BiliFrameBuffer> items = new ArrayList<>();
        items.add(frameBuffer);
        map.put(frameBuffer.getCacheHash(), items);
    }

    public void recycleFramebuffer(BiliFrameBuffer frameBuffer) {
        if (frameBuffer == null) {
            return;
        }
        synchronized (this._lock) {
            frameBuffer.clearAllLocks();
            if (!this._fbo_recycles.contains(frameBuffer)) {
                this._fbo_recycles.add(frameBuffer);
            }
        }
        clearTemp();
    }

    public void destroy() {
        if (this.isDestroy) {
            return;
        }
        this.isDestroy = true;
        clear();
    }
}