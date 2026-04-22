package tv.danmaku.bili.ui.main2.mine.modularvip;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: MineVipService.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"VIP_REPORT_PARAM_TIPS_ID", "", "VIP_REPORT_PARAM_VIP_STATUS", "VIP_REPORT_PARAM_VIP_TYPE", "VIP_REPORT_PARAM_EXP_TAG", "VIP_REPORT_PARAM_EXP_GROUP_TAG", "VIP_ENTRANCE_EVENT_REAL_SHOW", "VIP_ENTRANCE_EVENT_NEW_SHOW", "VIP_ENTRANCE_EVENT_NEW_CLICK", "VIP_ENTRANCE_EVENT_TEXT_CLICK", "VIP_ENTRANCE_PARAM_SOURCE_FROM", "VIP_REPORT_PARAM_VIP_BUTTON_STYLE", "VIP_REPORT_VALUE_NORMAL", "VIP_REPORT_VALUE_SPECIAL", "VIP_REPORT_KEY_BACKGROUND", "VIP_REPORT_KEY_BUTTON_COLOR", "VIP_REPORT_KEY_CLICK_AREA", "VIP_REPORT_KEY_URL", "appendVipSourceFromIfAbsent", "Landroid/net/Uri;", "toAppend", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineVipServiceKt {
    public static final String VIP_ENTRANCE_EVENT_NEW_CLICK = "main.my-information.vip-entrance.new.click";
    public static final String VIP_ENTRANCE_EVENT_NEW_SHOW = "main.my-information.vip-entrance.new.show";
    public static final String VIP_ENTRANCE_EVENT_REAL_SHOW = "main.my-information.vip-entrance.latency.show";
    public static final String VIP_ENTRANCE_EVENT_TEXT_CLICK = "main.my-information.vip-entrance.text.click";
    public static final String VIP_ENTRANCE_PARAM_SOURCE_FROM = "source_from";
    public static final String VIP_REPORT_KEY_BACKGROUND = "is_background";
    public static final String VIP_REPORT_KEY_BUTTON_COLOR = "is_button_color";
    public static final String VIP_REPORT_KEY_CLICK_AREA = "click_area";
    public static final String VIP_REPORT_KEY_URL = "url";
    public static final String VIP_REPORT_PARAM_EXP_GROUP_TAG = "exp_group_tag";
    public static final String VIP_REPORT_PARAM_EXP_TAG = "exp_tag";
    public static final String VIP_REPORT_PARAM_TIPS_ID = "tips_id";
    public static final String VIP_REPORT_PARAM_VIP_BUTTON_STYLE = "vip_btn_style";
    public static final String VIP_REPORT_PARAM_VIP_STATUS = "vip_status";
    public static final String VIP_REPORT_PARAM_VIP_TYPE = "vip_type";
    public static final String VIP_REPORT_VALUE_NORMAL = "normal";
    public static final String VIP_REPORT_VALUE_SPECIAL = "special";

    public static final Uri appendVipSourceFromIfAbsent(Uri $this$appendVipSourceFromIfAbsent, String toAppend) {
        Intrinsics.checkNotNullParameter($this$appendVipSourceFromIfAbsent, "<this>");
        Intrinsics.checkNotNullParameter(toAppend, "toAppend");
        if ($this$appendVipSourceFromIfAbsent.isHierarchical()) {
            if ($this$appendVipSourceFromIfAbsent.getQueryParameter(VIP_ENTRANCE_PARAM_SOURCE_FROM) != null) {
                return $this$appendVipSourceFromIfAbsent;
            }
            Uri build = $this$appendVipSourceFromIfAbsent.buildUpon().appendQueryParameter(VIP_ENTRANCE_PARAM_SOURCE_FROM, toAppend).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            return build;
        }
        return $this$appendVipSourceFromIfAbsent;
    }
}