package tv.danmaku.bili.ui.main.usergrow;

import android.content.Context;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: UserGrowHelper.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/bili/ui/main/usergrow/UserGrowSpHelper;", "", "<init>", "()V", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UserGrowSpHelper {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final String PREF_KEY_IS_DIALOG_SHOWING = "pref_key_user_grow_dialog_showing";
    private static final String PREF_KEY_JUMP_URL_FOR_LOGIN = "pref_key_user_grow_jump_url_for_login";
    private static final String PREF_KEY_LAST_SHARE_WORD_CLIP_CONTENT = "pref_key_last_share_word_clip_content";
    private static final String PREF_KEY_NEED_SHOW_FOR_LOGIN = "pref_key_user_grow_need_show_for_login";

    /* compiled from: UserGrowHelper.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0005J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/main/usergrow/UserGrowSpHelper$Companion;", "", "<init>", "()V", "PREF_KEY_NEED_SHOW_FOR_LOGIN", "", "PREF_KEY_JUMP_URL_FOR_LOGIN", "PREF_KEY_IS_DIALOG_SHOWING", "PREF_KEY_LAST_SHARE_WORD_CLIP_CONTENT", "needShowForLogin", "", "context", "Landroid/content/Context;", "getJumpUrlForLogin", "setNeedShowForLogin", "", "needShow", "jumpUrl", "setDialogShowing", "isShowing", "isDialogShowing", "setLastShareWord", "content", "getLastShareWord", "clearShareWord", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean needShowForLogin(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getBoolean(UserGrowSpHelper.PREF_KEY_NEED_SHOW_FOR_LOGIN, false);
        }

        public final String getJumpUrlForLogin(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getString(UserGrowSpHelper.PREF_KEY_JUMP_URL_FOR_LOGIN, "");
        }

        public final void setNeedShowForLogin(Context context, boolean needShow, String jumpUrl) {
            Intrinsics.checkNotNullParameter(context, "context");
            BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putBoolean(UserGrowSpHelper.PREF_KEY_NEED_SHOW_FOR_LOGIN, needShow).putString(UserGrowSpHelper.PREF_KEY_JUMP_URL_FOR_LOGIN, jumpUrl).apply();
        }

        public final void setDialogShowing(Context context, boolean isShowing) {
            Intrinsics.checkNotNullParameter(context, "context");
            BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putBoolean(UserGrowSpHelper.PREF_KEY_IS_DIALOG_SHOWING, isShowing).apply();
        }

        public final boolean isDialogShowing(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getBoolean(UserGrowSpHelper.PREF_KEY_IS_DIALOG_SHOWING, false);
        }

        public final void setLastShareWord(Context context, String content) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(content, "content");
            BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putString(UserGrowSpHelper.PREF_KEY_LAST_SHARE_WORD_CLIP_CONTENT, content).apply();
        }

        public final String getLastShareWord(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getString(UserGrowSpHelper.PREF_KEY_LAST_SHARE_WORD_CLIP_CONTENT, null);
        }

        public final void clearShareWord(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putString(UserGrowSpHelper.PREF_KEY_LAST_SHARE_WORD_CLIP_CONTENT, "").apply();
        }
    }
}