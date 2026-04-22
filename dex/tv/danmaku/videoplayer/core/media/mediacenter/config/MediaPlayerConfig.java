package tv.danmaku.videoplayer.core.media.mediacenter.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkLibLoader;
import tv.danmaku.videoplayer.core.media.mediacenter.MediaType;

/* compiled from: MediaPlayerConfig.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001 B=\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006!"}, d2 = {"Ltv/danmaku/videoplayer/core/media/mediacenter/config/MediaPlayerConfig;", "", "forceCreate", "", "useExternalRender", "mediaType", "Ltv/danmaku/videoplayer/core/media/mediacenter/MediaType;", "ijkLibLoader", "Ltv/danmaku/ijk/media/player/IjkLibLoader;", "startPlayerService", "<init>", "(ZZLtv/danmaku/videoplayer/core/media/mediacenter/MediaType;Ltv/danmaku/ijk/media/player/IjkLibLoader;Z)V", "getForceCreate", "()Z", "setForceCreate", "(Z)V", "getUseExternalRender", "setUseExternalRender", "getMediaType", "()Ltv/danmaku/videoplayer/core/media/mediacenter/MediaType;", "setMediaType", "(Ltv/danmaku/videoplayer/core/media/mediacenter/MediaType;)V", "getIjkLibLoader", "()Ltv/danmaku/ijk/media/player/IjkLibLoader;", "setIjkLibLoader", "(Ltv/danmaku/ijk/media/player/IjkLibLoader;)V", "getStartPlayerService", "setStartPlayerService", "hashCode", "", "equals", "other", "Builder", "mediacenter_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MediaPlayerConfig {
    private boolean forceCreate;
    private IjkLibLoader ijkLibLoader;
    private MediaType mediaType;
    private boolean startPlayerService;
    private boolean useExternalRender;

    private MediaPlayerConfig(boolean forceCreate, boolean useExternalRender, MediaType mediaType, IjkLibLoader ijkLibLoader, boolean startPlayerService) {
        this.forceCreate = forceCreate;
        this.useExternalRender = useExternalRender;
        this.mediaType = mediaType;
        this.ijkLibLoader = ijkLibLoader;
        this.startPlayerService = startPlayerService;
    }

    /* synthetic */ MediaPlayerConfig(boolean z, boolean z2, MediaType mediaType, IjkLibLoader ijkLibLoader, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? MediaType.IJK : mediaType, (i & 8) != 0 ? null : ijkLibLoader, (i & 16) != 0 ? false : z3);
    }

    public final boolean getForceCreate() {
        return this.forceCreate;
    }

    public final void setForceCreate(boolean z) {
        this.forceCreate = z;
    }

    public final boolean getUseExternalRender() {
        return this.useExternalRender;
    }

    public final void setUseExternalRender(boolean z) {
        this.useExternalRender = z;
    }

    public final MediaType getMediaType() {
        return this.mediaType;
    }

    public final void setMediaType(MediaType mediaType) {
        Intrinsics.checkNotNullParameter(mediaType, "<set-?>");
        this.mediaType = mediaType;
    }

    public final IjkLibLoader getIjkLibLoader() {
        return this.ijkLibLoader;
    }

    public final void setIjkLibLoader(IjkLibLoader ijkLibLoader) {
        this.ijkLibLoader = ijkLibLoader;
    }

    public final boolean getStartPlayerService() {
        return this.startPlayerService;
    }

    public final void setStartPlayerService(boolean z) {
        this.startPlayerService = z;
    }

    public int hashCode() {
        return super.hashCode() + this.mediaType.hashCode();
    }

    public boolean equals(Object other) {
        return (other instanceof MediaPlayerConfig) && ((MediaPlayerConfig) other).mediaType == this.mediaType && ((MediaPlayerConfig) other).forceCreate == this.forceCreate && ((MediaPlayerConfig) other).useExternalRender == this.useExternalRender;
    }

    /* compiled from: MediaPlayerConfig.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\bJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/videoplayer/core/media/mediacenter/config/MediaPlayerConfig$Builder;", "", "<init>", "()V", "force", "", "externalRender", "type", "Ltv/danmaku/videoplayer/core/media/mediacenter/MediaType;", "libLoader", "Ltv/danmaku/ijk/media/player/IjkLibLoader;", "forceCreate", "useExternalRender", "mediaType", "ijkLibLoader", "build", "Ltv/danmaku/videoplayer/core/media/mediacenter/config/MediaPlayerConfig;", "mediacenter_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Builder {
        private boolean externalRender;
        private boolean force;
        private IjkLibLoader libLoader;
        private MediaType type = MediaType.IJK;

        public final Builder forceCreate() {
            this.force = true;
            return this;
        }

        public final Builder useExternalRender(boolean useExternalRender) {
            this.externalRender = useExternalRender;
            return this;
        }

        public final Builder mediaType(MediaType mediaType) {
            Intrinsics.checkNotNullParameter(mediaType, "mediaType");
            this.type = mediaType;
            return this;
        }

        public final Builder ijkLibLoader(IjkLibLoader ijkLibLoader) {
            this.libLoader = ijkLibLoader;
            return this;
        }

        public final MediaPlayerConfig build() {
            return new MediaPlayerConfig(this.force, this.externalRender, this.type, this.libLoader, false, 16, null);
        }
    }
}