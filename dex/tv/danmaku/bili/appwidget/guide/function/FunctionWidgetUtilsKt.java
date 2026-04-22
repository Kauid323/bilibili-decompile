package tv.danmaku.bili.appwidget.guide.function;

import com.bilibili.lib.dd.DeviceDecision;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: FunctionWidgetUtils.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"enableFunctionGuideWidget", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FunctionWidgetUtilsKt {
    public static final boolean enableFunctionGuideWidget() {
        return DeviceDecision.INSTANCE.getBoolean("dd.show_auto_add_function_widget_dialog", true);
    }
}