package tv.danmaku.ijk.media.player.render;

import android.util.Pair;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import tv.danmaku.android.log.BLog;

public class IHdrVividProcess {
    private static final String TAG = "IHdrVividProcess";
    private Queue<Pair<ByteBuffer, Long>> mVividDataList;

    public void setVividDataList(Queue<Pair<ByteBuffer, Long>> list) {
        if (this.mVividDataList == null) {
            this.mVividDataList = new LinkedList();
        }
        if (list != null) {
            synchronized (list) {
                this.mVividDataList = list;
            }
        }
    }

    public void flush() {
        if (this.mVividDataList != null) {
            synchronized (this.mVividDataList) {
                this.mVividDataList.clear();
                BLog.w(TAG, "[VividDataList LifeCycle] flush: mVividDataList.clear()");
            }
            return;
        }
        BLog.w(TAG, "[VividDataList LifeCycle] try flush but mVividDataList was null!");
    }

    public ByteBuffer processFrame(long pts) {
        if (this.mVividDataList == null) {
            return null;
        }
        synchronized (this.mVividDataList) {
            Iterator<Pair<ByteBuffer, Long>> it = this.mVividDataList.iterator();
            while (it.hasNext()) {
                Pair<ByteBuffer, Long> pair = it.next();
                if (((Long) pair.second).longValue() == pts) {
                    ByteBuffer data = (ByteBuffer) pair.first;
                    ByteBuffer copy = data.duplicate();
                    it.remove();
                    return copy;
                }
            }
            return null;
        }
    }
}