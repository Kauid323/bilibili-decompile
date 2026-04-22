package tv.danmaku.ijk.media.player.services;

import android.graphics.SurfaceTexture;

public class IJKAmcOnFrameAvailableListener implements SurfaceTexture.OnFrameAvailableListener {
    private long context = 0;

    private native void native_onFrameAvailable(long j, SurfaceTexture surfaceTexture);

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public synchronized void onFrameAvailable(SurfaceTexture surfaceTexture) {
        native_onFrameAvailable(this.context, surfaceTexture);
    }

    public synchronized long getContext() {
        return this.context;
    }

    public synchronized void setContext(long c) {
        this.context = c;
    }
}