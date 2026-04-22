package tv.danmaku.ijk.media.player.render;

import android.util.Pair;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Queue;
import tv.danmaku.android.log.BLog;

public class IDolbyHDRApi {
    private static final int FLUSH_FLAG_IMMEDIATELY = 1;
    private static final int FLUSH_FLAG_REQUEST = 2;
    private static final String TAG = "IDolbyHDRApi";
    private long mNativeContext = 0;
    private int rpuCount = 0;
    private boolean flushRequest = false;
    private Queue<Pair<ByteBuffer, Long>> rpuBufferCache = new LinkedList();

    private native int _initGlComponents();

    private native int _parseRpu(ByteBuffer byteBuffer, int i, long j);

    private native int _processFrame(int i, float[] fArr, long j);

    private native int _setPQMode(String str, int i);

    private native int _setResolution(int i, int i2);

    private native int _visionFlush();

    private native int _visionHDRImpl();

    private native int _visionHDRTearDown();

    static {
        System.loadLibrary("ijkplayer");
    }

    public boolean initDolby(String configPath, int configMode) {
        if (_visionHDRImpl() != 0) {
            BLog.e(TAG, "DolbyHDR _visionHDRImpl error !");
            return false;
        } else if (_setPQMode(configPath, configMode) != 0) {
            BLog.e(TAG, "DolbyHDR _setPQMode error !");
            return false;
        } else {
            _initGlComponents();
            return true;
        }
    }

    public void relsase() {
        _visionHDRTearDown();
    }

    public void flush(int flag) {
        if (this.rpuCount == 0) {
            return;
        }
        if (flag == 2) {
            this.flushRequest = true;
            this.rpuBufferCache.clear();
            BLog.i(TAG, "dolby flush request, wait frist frame");
        } else if (flag == 1) {
            this.flushRequest = false;
            _visionFlush();
            this.rpuCount = 0;
            BLog.i(TAG, "dolby flush, write rpu from cache, cache size : " + this.rpuBufferCache.size());
            while (!this.rpuBufferCache.isEmpty()) {
                Pair<ByteBuffer, Long> data = this.rpuBufferCache.poll();
                if (data != null) {
                    _parseRpu((ByteBuffer) data.first, ((ByteBuffer) data.first).capacity(), ((Long) data.second).longValue());
                    this.rpuCount++;
                }
            }
        }
    }

    public void sendRPU(ByteBuffer au_buf, int size, long timeUs) {
        if (this.flushRequest) {
            this.rpuBufferCache.offer(new Pair<>(au_buf, Long.valueOf(timeUs)));
            return;
        }
        _parseRpu(au_buf, size, timeUs);
        this.rpuCount++;
    }

    public void processFrame(int OESTexID, float[] texTransform, long timeUs) {
        if (this.flushRequest && this.rpuCount == 0) {
            BLog.w(TAG, "flush request but not implemented until processFrame, force flush and write rpu");
            flush(1);
        }
        _processFrame(OESTexID, texTransform, timeUs);
    }

    public void setResolution(int width, int height) {
        _setResolution(width, height);
    }
}