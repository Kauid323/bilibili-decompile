package tv.danmaku.bili.core.test;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.format.DateFormat;
import android.view.View;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.droid.ToastHelper;
import com.bilibili.list.test.AbsButtonTestItem;
import com.bilibili.teenagersmode.TeenagersModeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: MainTestPageActivity.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/core/test/ResetTeenagersModeDaily;", "Lcom/bilibili/list/test/AbsButtonTestItem;", "<init>", "()V", "onClick", "", "view", "Landroid/view/View;", "getButtonText", "", "context", "Landroid/content/Context;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ResetTeenagersModeDaily extends AbsButtonTestItem {
    public static final int $stable = AbsButtonTestItem.$stable;

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        long lastShowTime = BiliGlobalPreferenceHelper.getInstance(view.getContext()).optLong("teenagers_mode_dialog_show_time", 0L);
        if (lastShowTime > 0) {
            ToastHelper.showToastShort(view.getContext(), "上次显示：" + ((Object) DateFormat.format("yyyy-MM-dd c HH:mm:ss", lastShowTime)) + "，已重置");
        } else {
            ToastHelper.showToastShort(view.getContext(), "上次未显示过，也已重置");
        }
        BiliGlobalPreferenceHelper.getInstance(view.getContext()).edit().putLong("teenagers_mode_dialog_show_time", 0L).apply();
        SharedPreferences preferences = TeenagersModeHelper.getSharedPreferences(view.getContext());
        preferences.edit().putBoolean("teenagers_mode_dialog_is_appeared", false).apply();
    }

    public CharSequence getButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return "重置青少年弹窗显示时间";
    }
}