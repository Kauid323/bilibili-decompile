package tv.danmaku.bili.core.test;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.droid.ToastHelper;
import com.bilibili.list.test.AbsButtonTestItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.basic.HomeAvatarHelper;

/* compiled from: MainTestPageActivity.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/core/test/ResetHomeAvatarRectShown;", "Lcom/bilibili/list/test/AbsButtonTestItem;", "<init>", "()V", "getButtonText", "", "context", "Landroid/content/Context;", "onClick", "", "v", "Landroid/view/View;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ResetHomeAvatarRectShown extends AbsButtonTestItem {
    public static final int $stable = AbsButtonTestItem.$stable;

    public CharSequence getButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String shown = HomeAvatarHelper.shownTagThisTime ? "展示中" : "未展示";
        String times = Intrinsics.areEqual(HomeAvatarHelper.userHasClickedRect, true) ? "已点击" : String.valueOf(HomeAvatarHelper.showTagTimes);
        return "重置首页头像特殊样式次数 " + shown + " " + times;
    }

    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        Application ctx = BiliContext.application();
        if (ctx == null) {
            return;
        }
        SharedPreferences preference = BiliGlobalPreferenceHelper.getBLKVSharedPreference(ctx);
        preference.edit().remove("KEY_USER_HAS_CLICKED_AVATAR_RECT:2").remove("SP_HOME_STORY_ENTRANCE_SHOW_TIMES").remove("KEY_SHOW_AVATAR_RECT_TIMES:2").remove("SP_HOME_STORY_INDEPENDENT_GUIDANCE_SHOW").remove("SP_HOME_STORY_ENTRANCE_SHOW_TIMES").remove("top_game_local_time").apply();
        ToastHelper.showToastShort(v.getContext(), "重置成功，请冷启");
    }
}