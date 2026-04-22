package tv.danmaku.bili.ui.splash.event;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import tv.danmaku.bili.ui.splash.common.CachedResource;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: EventSplashData.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010!\u001a\u00020\u001dH\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001e\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Ltv/danmaku/bili/ui/splash/event/Resource;", "Ltv/danmaku/bili/ui/splash/common/CachedResource;", "<init>", "()V", "resourceHash", "", "getResourceHash", "()Ljava/lang/String;", "setResourceHash", "(Ljava/lang/String;)V", "resourceType", "", "getResourceType", "()I", "setResourceType", "(I)V", "resourceUrl", "getResourceUrl", "setResourceUrl", "videoHeight", "getVideoHeight", "setVideoHeight", "videoWidth", "getVideoWidth", "setVideoWidth", "localResourcePath", "getLocalResourcePath", "setLocalResourcePath", "isLocalBirthdayRes", "", "()Z", "setLocalBirthdayRes", "(Z)V", "isResValid", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class Resource implements CachedResource {
    public static final int $stable = 8;
    private boolean isLocalBirthdayRes;
    private String localResourcePath;
    @JSONField(name = "resource_hash")
    private String resourceHash;
    @JSONField(name = "resource_type")
    private int resourceType;
    @JSONField(name = "resource_url")
    private String resourceUrl;
    @JSONField(name = "video_height")
    private int videoHeight;
    @JSONField(name = "video_width")
    private int videoWidth;

    public final String getResourceHash() {
        return this.resourceHash;
    }

    public final void setResourceHash(String str) {
        this.resourceHash = str;
    }

    public final int getResourceType() {
        return this.resourceType;
    }

    public final void setResourceType(int i) {
        this.resourceType = i;
    }

    public final String getResourceUrl() {
        return this.resourceUrl;
    }

    public final void setResourceUrl(String str) {
        this.resourceUrl = str;
    }

    public final int getVideoHeight() {
        return this.videoHeight;
    }

    public final void setVideoHeight(int i) {
        this.videoHeight = i;
    }

    public final int getVideoWidth() {
        return this.videoWidth;
    }

    public final void setVideoWidth(int i) {
        this.videoWidth = i;
    }

    public final String getLocalResourcePath() {
        return this.localResourcePath;
    }

    public final void setLocalResourcePath(String str) {
        this.localResourcePath = str;
    }

    public final boolean isLocalBirthdayRes() {
        return this.isLocalBirthdayRes;
    }

    public final void setLocalBirthdayRes(boolean z) {
        this.isLocalBirthdayRes = z;
    }

    @Override // tv.danmaku.bili.ui.splash.common.CachedResource
    public boolean isResValid() {
        boolean z = false;
        if (this.resourceType != 1 || (this.videoHeight > 0 && this.videoWidth > 0)) {
            if (!this.isLocalBirthdayRes || this.localResourcePath == null) {
                String path = EventSplashStorageKt.fetchResourceLocalPathByHash(this.resourceHash);
                if (path == null) {
                    path = EventSplashStorageKt.fetchResourceLocalPathByUrl(this.resourceUrl);
                }
                this.localResourcePath = path;
                String str = path;
                if (str == null || StringsKt.isBlank(str)) {
                    z = true;
                }
                return !z;
            }
            return true;
        }
        return false;
    }
}