package tv.danmaku.bili.core.test;

import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.bilibili.commons.time.DateUtils;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.list.test.AbsButtonTestItem;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.pushsetting.config.PushSettingDialogDuplicateExperimentKt;

/* compiled from: MainTestPageActivity.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/core/test/PushDuplicateButton;", "Lcom/bilibili/list/test/AbsButtonTestItem;", "<init>", "()V", "getButtonText", "", "context", "Landroid/content/Context;", "onClick", "", "v", "Landroid/view/View;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PushDuplicateButton extends AbsButtonTestItem {
    public static final int $stable = AbsButtonTestItem.$stable;

    public CharSequence getButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return "查看权限弹窗去重实验信息";
    }

    public void onClick(View v) {
        Context context;
        boolean hitBrand = ConfigManager.Companion.isHitFF("ff_custom_system_notification_dialog_brand");
        boolean hitExp1 = ConfigManager.Companion.isHitFF("ff_custom_push_setting_delay_next_cold_start");
        boolean hitExp2 = ConfigManager.Companion.isHitFF("ff_custom_push_setting_delay_next_day");
        boolean canShowCustomDialog = PushSettingDialogDuplicateExperimentKt.getCanShowCustomDialogInDialogDuplicateExp();
        boolean meetExperimentCondition = Build.VERSION.SDK_INT >= 33 || hitBrand;
        long firstStartDate = EnvironmentManager.getInstance().getFirstRunTime() * 1000;
        boolean isFirstDay = DateUtils.isSameDay(new Date(firstStartDate), new Date());
        String info = "基础条件：android13或vivo手机 = " + meetExperimentCondition + "\nVivo手机 = " + hitBrand + "\n命中实验组1 = " + hitExp1 + "\n命中实验组2 = hitExp2 = " + hitExp2 + "\n是否是首次启动 = " + EnvironmentManager.getInstance().isFirstStart() + "\n是否是首日 = " + isFirstDay + "\n是否拦截展示 = " + (!canShowCustomDialog) + "\n\n注意基础条件满足后，才是真正命中实验组，去判断是否拦截展示";
        if (v != null && (context = v.getContext()) != null) {
            new AlertDialog.Builder(context).setTitle("Push去重实验分组情况").setMessage(info).setCancelable(true).create().show();
        }
    }
}