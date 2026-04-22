package tv.danmaku.bili.videopage.common.helper;

import android.app.Application;
import android.content.Context;
import com.bilibili.base.BiliContext;
import com.bilibili.base.SharedPreferencesHelper;
import java.lang.ref.WeakReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VideoDetailsSharedPreferences.kt */
@Deprecated(message = "不要直接使用大的SharedPreferencesHelper，而是根据具体业务和情况暴露读写的函数")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/videopage/common/helper/VideoDetailsSharedPreferences;", "", "<init>", "()V", "PREF_NAME", "", "PREF_KEY_SHARE_LISTEN_SHOW_NEW", "PREF_KEY_POPUP_SHARE_PROMPT_TIME", "PREF_KEY_POPUP_SHARE_PROMPT_DAY", "mPreferencesRef", "Ljava/lang/ref/WeakReference;", "Lcom/bilibili/base/SharedPreferencesHelper;", "getSharedPreferences", "context", "Landroid/content/Context;", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideoDetailsSharedPreferences {
    public static final VideoDetailsSharedPreferences INSTANCE = new VideoDetailsSharedPreferences();
    public static final String PREF_KEY_POPUP_SHARE_PROMPT_DAY = "pref_key_popup_share_prompt_day";
    public static final String PREF_KEY_POPUP_SHARE_PROMPT_TIME = "pref_key_popup_share_prompt_time";
    public static final String PREF_KEY_SHARE_LISTEN_SHOW_NEW = "pref_key_share_listen_show_new";
    private static final String PREF_NAME = "video_detail_preference";
    private static WeakReference<SharedPreferencesHelper> mPreferencesRef;

    private VideoDetailsSharedPreferences() {
    }

    public final SharedPreferencesHelper getSharedPreferences(Context context) {
        Application ctx = context == null ? BiliContext.application() : context;
        if (ctx == null) {
            return null;
        }
        if (mPreferencesRef != null) {
            WeakReference<SharedPreferencesHelper> weakReference = mPreferencesRef;
            SharedPreferencesHelper sharedPreferencesHelper = weakReference != null ? weakReference.get() : null;
            SharedPreferencesHelper it = sharedPreferencesHelper;
            if (sharedPreferencesHelper != null) {
                return it;
            }
        }
        SharedPreferencesHelper sharedPreferencesHelper2 = new SharedPreferencesHelper(ctx, PREF_NAME);
        mPreferencesRef = new WeakReference<>(sharedPreferencesHelper2);
        return sharedPreferencesHelper2;
    }
}