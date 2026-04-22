package tv.danmaku.ijk.media.player.render.core;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import tv.danmaku.android.log.BLog;

public class IjkWindowSurface extends IjkEglSurfaceBase {
    private boolean mReleaseSurface;
    private Surface mSurface;

    public IjkWindowSurface(IjkEglCore ijkEglCore, Surface surface, boolean releaseSurface) {
        super(ijkEglCore);
        createWindowSurface(surface);
        this.mSurface = surface;
        this.mReleaseSurface = releaseSurface;
    }

    public IjkWindowSurface(IjkEglCore ijkEglCore, SurfaceTexture surfaceTexture) {
        super(ijkEglCore);
        createWindowSurface(surfaceTexture);
    }

    public IjkWindowSurface(IjkEglCore ijkEglCore, boolean releaseSurface) {
        super(ijkEglCore);
        this.mReleaseSurface = releaseSurface;
    }

    @Override // tv.danmaku.ijk.media.player.render.core.IjkEglSurfaceBase
    public boolean createWindowSurface(Object surface) {
        this.mSurface = (Surface) surface;
        return super.createWindowSurface(surface);
    }

    public void release() {
        releaseEglSurface();
        if (this.mSurface != null) {
            if (this.mReleaseSurface) {
                this.mSurface.release();
            }
            this.mSurface = null;
        }
    }

    public void recreate(IjkEglCore newIjkEglCore) {
        if (this.mSurface == null) {
            BLog.e(IjkGLUtils.TAG, "not yet implemented for SurfaceTexture");
            return;
        }
        this.mIjkEglCore = newIjkEglCore;
        createWindowSurface(this.mSurface);
    }
}