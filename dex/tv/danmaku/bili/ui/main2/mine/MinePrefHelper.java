package tv.danmaku.bili.ui.main2.mine;

import android.content.Context;
import android.text.TextUtils;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: MinePrefHelper.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\nJ\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0005J\u0016\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0005J\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0005J\u0016\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0005J\u0016\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/MinePrefHelper;", "", "<init>", "()V", "PREF_KEY_MINE_IS_NEW_INSTALL", "", "PREF_KEY_REQUESTED_MINE", "PREF_KEY_MINE_ITEM_CLICKED", "PREF_KEY_MINE_ITEM_SHOWED", "isFirstStart", "", "context", "Landroid/content/Context;", "isRequestedMine", "setIsRequestedMine", "", "requested", "isNewInstall", "setIsNewInstall", "isNew", "setShowForUpdate", "id", "isClickedForNew", "setClickedForNew", "removeShowForUpdate", "isShowForUpdate", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MinePrefHelper {
    public static final int $stable = 0;
    public static final MinePrefHelper INSTANCE = new MinePrefHelper();
    private static final String PREF_KEY_MINE_IS_NEW_INSTALL = "pref_key_mine_is_new_install";
    private static final String PREF_KEY_MINE_ITEM_CLICKED = "pref_key_mine_item_clicked";
    private static final String PREF_KEY_MINE_ITEM_SHOWED = "pref_key_mine_item_showed";
    private static final String PREF_KEY_REQUESTED_MINE = "pref_key_requested_mine";

    private MinePrefHelper() {
    }

    public final boolean isFirstStart(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return EnvironmentManager.getInstance().isFirstStart();
    }

    public final boolean isRequestedMine(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getBoolean(PREF_KEY_REQUESTED_MINE, false);
    }

    public final void setIsRequestedMine(Context context, boolean requested) {
        Intrinsics.checkNotNullParameter(context, "context");
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putBoolean(PREF_KEY_REQUESTED_MINE, requested).apply();
    }

    public final boolean isNewInstall(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getBoolean(PREF_KEY_MINE_IS_NEW_INSTALL, false);
    }

    public final void setIsNewInstall(Context context, boolean isNew) {
        Intrinsics.checkNotNullParameter(context, "context");
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putBoolean(PREF_KEY_MINE_IS_NEW_INSTALL, isNew).apply();
    }

    public final void setShowForUpdate(Context context, String id) {
        Set ids;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(id, "id");
        if (!TextUtils.isEmpty(id) && (ids = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getStringSet(PREF_KEY_MINE_ITEM_SHOWED, new HashSet())) != null) {
            Set temp = new HashSet(ids);
            temp.add(id);
            BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putStringSet(PREF_KEY_MINE_ITEM_SHOWED, temp).apply();
        }
    }

    public final boolean isClickedForNew(Context context, String id) {
        Set ids;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(id, "id");
        if (TextUtils.isEmpty(id) || (ids = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getStringSet(PREF_KEY_MINE_ITEM_CLICKED, new HashSet())) == null) {
            return false;
        }
        return ids.contains(id);
    }

    public final void setClickedForNew(Context context, String id) {
        Set ids;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(id, "id");
        if (!TextUtils.isEmpty(id) && (ids = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getStringSet(PREF_KEY_MINE_ITEM_CLICKED, new HashSet())) != null) {
            Set temp = new HashSet(ids);
            temp.add(id);
            BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putStringSet(PREF_KEY_MINE_ITEM_CLICKED, temp).apply();
            INSTANCE.removeShowForUpdate(context, id);
        }
    }

    public final void removeShowForUpdate(Context context, String id) {
        Set ids;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(id, "id");
        if (!TextUtils.isEmpty(id) && (ids = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getStringSet(PREF_KEY_MINE_ITEM_SHOWED, new HashSet())) != null) {
            Set temp = new HashSet(ids);
            temp.remove(id);
            BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putStringSet(PREF_KEY_MINE_ITEM_SHOWED, temp).apply();
        }
    }

    public final boolean isShowForUpdate(Context context, String id) {
        Set ids;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(id, "id");
        if (TextUtils.isEmpty(id) || (ids = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getStringSet(PREF_KEY_MINE_ITEM_SHOWED, new HashSet())) == null) {
            return false;
        }
        return ids.contains(id);
    }
}