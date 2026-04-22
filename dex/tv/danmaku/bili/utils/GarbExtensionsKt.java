package tv.danmaku.bili.utils;

import android.app.Application;
import android.content.Context;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.utils.GarbStyle;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: GarbExtensions.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"mineStyle", "Ltv/danmaku/bili/utils/GarbStyle$Mine;", "Lcom/bilibili/lib/ui/garb/Garb;", "getMineStyle", "(Lcom/bilibili/lib/ui/garb/Garb;)Ltv/danmaku/bili/utils/GarbStyle$Mine;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class GarbExtensionsKt {
    public static final GarbStyle.Mine getMineStyle(Garb $this$mineStyle) {
        Context applicationContext;
        Intrinsics.checkNotNullParameter($this$mineStyle, "<this>");
        Application application = BiliContext.application();
        if (application != null && (applicationContext = application.getApplicationContext()) != null) {
            boolean isNight = MultipleThemeUtils.isNightTheme(applicationContext);
            return $this$mineStyle.isWhite() ? GarbStyle.Mine.PURE_WHITE : ($this$mineStyle.isPure() && isNight) ? GarbStyle.Mine.NIGHT_NO_DRESS : $this$mineStyle.isPure() ? GarbStyle.Mine.COLORFUL : (isNight || $this$mineStyle.isDarkMode()) ? (isNight || !$this$mineStyle.isDarkMode()) ? (!isNight || $this$mineStyle.isDarkMode()) ? (isNight && $this$mineStyle.isDarkMode()) ? GarbStyle.Mine.NIGHT_DRESS_LIGHT : GarbStyle.Mine.PURE_WHITE : GarbStyle.Mine.NIGHT_DRESS_DARK : GarbStyle.Mine.DAY_DRESS_LIGHT : GarbStyle.Mine.DAY_DRESS_DARK;
        }
        return GarbStyle.Mine.PURE_WHITE;
    }
}