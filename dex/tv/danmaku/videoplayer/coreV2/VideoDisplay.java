package tv.danmaku.videoplayer.coreV2;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VideoDisplay.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B)\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB%\b\u0017\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\fJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\"H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006$"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/VideoDisplay;", "", "surface", "Landroid/view/Surface;", "surfaceHolder", "Landroid/view/SurfaceHolder;", "type", "", "<init>", "(Landroid/view/Surface;Landroid/view/SurfaceHolder;I)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "(Landroid/graphics/SurfaceTexture;Landroid/view/SurfaceHolder;I)V", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "getSurfaceHolder", "()Landroid/view/SurfaceHolder;", "setSurfaceHolder", "(Landroid/view/SurfaceHolder;)V", "getType", "()I", "setType", "(I)V", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "isValid", "", "release", "", "toString", "", "Companion", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideoDisplay {
    public static final Companion Companion = new Companion(null);
    public static final int DISPLAY_TYPE_SURFACE = 1;
    public static final int DISPLAY_TYPE_TEXTURE = 2;
    public static final int DISPLAY_TYPE_UNKNOWN = 3;
    private Surface surface;
    private SurfaceHolder surfaceHolder;
    private SurfaceTexture surfaceTexture;
    private int type;

    public final Surface getSurface() {
        return this.surface;
    }

    public final void setSurface(Surface surface) {
        this.surface = surface;
    }

    public final SurfaceHolder getSurfaceHolder() {
        return this.surfaceHolder;
    }

    public final void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    /* compiled from: VideoDisplay.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/VideoDisplay$Companion;", "", "<init>", "()V", "DISPLAY_TYPE_SURFACE", "", "DISPLAY_TYPE_TEXTURE", "DISPLAY_TYPE_UNKNOWN", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final SurfaceTexture getSurfaceTexture() {
        return this.surfaceTexture;
    }

    public final void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.surfaceTexture = surfaceTexture;
    }

    public VideoDisplay(Surface surface, SurfaceHolder surfaceHolder, int type) {
        this.type = 3;
        this.surface = surface;
        this.surfaceHolder = surfaceHolder;
        this.type = type;
    }

    public /* synthetic */ VideoDisplay(Surface surface, SurfaceHolder surfaceHolder, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : surface, (i2 & 2) != 0 ? null : surfaceHolder, i);
    }

    public VideoDisplay(SurfaceTexture surfaceTexture, SurfaceHolder surfaceHolder, int type) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        this.type = 3;
        this.surfaceTexture = surfaceTexture;
        this.surface = new Surface(surfaceTexture);
        this.surfaceHolder = surfaceHolder;
        this.type = type;
    }

    public /* synthetic */ VideoDisplay(SurfaceTexture surfaceTexture, SurfaceHolder surfaceHolder, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(surfaceTexture, (i2 & 2) != 0 ? null : surfaceHolder, i);
    }

    public final boolean isValid() {
        Surface surface;
        Surface surface2 = this.surface;
        if (surface2 != null && surface2.isValid()) {
            return true;
        }
        SurfaceHolder surfaceHolder = this.surfaceHolder;
        return surfaceHolder != null && (surface = surfaceHolder.getSurface()) != null && surface.isValid();
    }

    public final void release() {
        SurfaceHolder surfaceHolder;
        Surface surface;
        Surface surface2;
        Surface surface3;
        Surface surface4 = this.surface;
        boolean z = true;
        if ((surface4 != null && surface4.isValid()) && (surface3 = this.surface) != null) {
            surface3.release();
        }
        this.surface = null;
        SurfaceHolder surfaceHolder2 = this.surfaceHolder;
        if (surfaceHolder2 == null || (surface2 = surfaceHolder2.getSurface()) == null || !surface2.isValid()) {
            z = false;
        }
        if (z && (surfaceHolder = this.surfaceHolder) != null && (surface = surfaceHolder.getSurface()) != null) {
            surface.release();
        }
        this.surfaceHolder = null;
        try {
            SurfaceTexture surfaceTexture = this.surfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
            }
        } catch (Exception e) {
        }
        this.surfaceTexture = null;
    }

    public String toString() {
        String obj = super.toString();
        int i = this.type;
        return "@" + obj + "[type=" + i + ",valid=" + isValid() + "]";
    }
}