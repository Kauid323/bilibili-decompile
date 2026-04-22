package tv.danmaku.bili.auth.modify;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: SelectPhotoAdapter.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/auth/modify/UploadPhotoData;", "", "<init>", "()V", AudioIntentHelper.ARGS_URI, "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "mUri", "getMUri", "()Landroid/net/Uri;", "setMUri", "mToken", "", "getMToken", "()Ljava/lang/String;", "setMToken", "(Ljava/lang/String;)V", AppConfig.HOST_TAG, "Ltv/danmaku/bili/auth/modify/PhotoType;", "getTag", "()Ltv/danmaku/bili/auth/modify/PhotoType;", "setTag", "(Ltv/danmaku/bili/auth/modify/PhotoType;)V", "setToken", "value", "setUri", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UploadPhotoData {
    private String mToken;
    private Uri mUri;
    private PhotoType tag;

    public UploadPhotoData() {
        this.mToken = "";
        this.tag = PhotoType.PHOTO;
    }

    public final Uri getMUri() {
        return this.mUri;
    }

    public final void setMUri(Uri uri) {
        this.mUri = uri;
    }

    public final String getMToken() {
        return this.mToken;
    }

    public final void setMToken(String str) {
        this.mToken = str;
    }

    public final PhotoType getTag() {
        return this.tag;
    }

    /* renamed from: setTag  reason: collision with other method in class */
    public final void m718setTag(PhotoType photoType) {
        Intrinsics.checkNotNullParameter(photoType, "<set-?>");
        this.tag = photoType;
    }

    public UploadPhotoData(Uri uri) {
        this();
        this.mUri = uri;
    }

    public final UploadPhotoData setToken(String value) {
        this.mToken = value;
        return this;
    }

    public final UploadPhotoData setUri(Uri value) {
        this.mUri = value;
        return this;
    }

    public final UploadPhotoData setTag(PhotoType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.tag = value;
        return this;
    }
}