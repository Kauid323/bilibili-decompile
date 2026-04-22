package tv.danmaku.bili.auth.helper;

import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: ModifyHelperApi.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/auth/helper/RequestUploadPhotoListener;", "", "onSuccess", "", "token", "", "onError", "onCancel", "", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface RequestUploadPhotoListener {
    boolean onCancel();

    void onError();

    void onSuccess(String str);
}