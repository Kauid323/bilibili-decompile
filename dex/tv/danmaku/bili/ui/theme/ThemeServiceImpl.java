package tv.danmaku.bili.ui.theme;

import android.content.Context;
import com.bilibili.moduleservice.main.ThemeService;
import javax.inject.Singleton;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ThemeServiceImpl.kt */
@Singleton
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/theme/ThemeServiceImpl;", "Lcom/bilibili/moduleservice/main/ThemeService;", "<init>", "()V", "getCurThemeTypeForH5", "", "themeID", "callThemeExpired", "", "context", "Landroid/content/Context;", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ThemeServiceImpl implements ThemeService {
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
}