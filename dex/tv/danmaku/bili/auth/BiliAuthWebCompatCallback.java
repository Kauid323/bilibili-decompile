package tv.danmaku.bili.auth;

import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: BiliAuthWebCompatFragment.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/auth/BiliAuthWebCompatCallback;", "", "onSuccess", "", "requestId", "", "onFailure", "errorCode", "", AuthResultCbHelper.ARGS_MSG, "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface BiliAuthWebCompatCallback {
    void onFailure(int i, String str);

    void onSuccess(String str);
}