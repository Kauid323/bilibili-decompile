package tv.danmaku.android.util;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class WeakHandler extends Handler {
    private WeakReference<Handler.Callback> mWeakCallback;

    public WeakHandler(Handler.Callback callback) {
        this.mWeakCallback = new WeakReference<>(callback);
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        Handler.Callback callback;
        if (this.mWeakCallback == null || (callback = this.mWeakCallback.get()) == null) {
            return;
        }
        callback.handleMessage(msg);
    }

    public void release() {
        removeCallbacksAndMessages(null);
        this.mWeakCallback.clear();
        this.mWeakCallback = null;
    }

    protected void finalize() throws Throwable {
        if (this.mWeakCallback != null) {
            release();
        }
        super.finalize();
    }
}