package tv.danmaku.bili.core.test;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.droid.ToastHelper;
import com.bilibili.list.test.AbsButtonTestItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: MainTestPageActivity.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/core/test/ClearPublishBubbleCount;", "Lcom/bilibili/list/test/AbsButtonTestItem;", "<init>", "()V", "getButtonText", "", "context", "Landroid/content/Context;", "onClick", "", "v", "Landroid/view/View;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ClearPublishBubbleCount extends AbsButtonTestItem {
    public static final int $stable = AbsButtonTestItem.$stable;

    public CharSequence getButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return "清除大加号气泡展示次数";
    }

    public void onClick(View v) {
        if (v == null) {
            return;
        }
        SharedPreferences bLKVSharedPreference = BiliGlobalPreferenceHelper.getBLKVSharedPreference();
        Intrinsics.checkNotNull(bLKVSharedPreference);
        bLKVSharedPreference.edit().remove("SP_KEY_PUBLISH_GUIDE_POPUP_START_TIME").remove("SP_KEY_PUBLISH_GUIDE_POPUP_SHOW_TIMES_SEVEN_DAYS").remove("SP_KEY_PUBLISH_GUIDE_POPUP_SHOW_HISTORY").apply();
        ToastHelper.showToastShort(v.getContext(), "清除成功");
    }
}