package tv.danmaku.bili.ui.theme;

import android.content.Context;
import com.bilibili.moduleservice.main.ThemeService;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ThemeServiceImpl.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007¨\u0006\u0002"}, d2 = {"themeServiceProducer", "Lcom/bilibili/moduleservice/main/ThemeService;", "theme_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ThemeServiceImplKt {
    public static final ThemeService themeServiceProducer() {
        return new ThemeService() { // from class: tv.danmaku.bili.ui.theme.ThemeServiceImplKt$themeServiceProducer$1
            public int getCurThemeTypeForH5() {
                return H5ThemeCompatHelper.getCompatThemeId();
            }

            public int getCurThemeTypeForH5(int themeID) {
                return H5ThemeCompatHelper.getCompatThemeId(themeID);
            }

            public void callThemeExpired(Context context) {
                if (context != null) {
                    ThemeManager.getInstance(context).callbackThemeExpired();
                }
            }
        };
    }
}