package tv.danmaku.bili.ui.theme.router;

import android.app.Application;
import android.content.Context;
import com.bilibili.base.BiliContext;
import com.bilibili.moduleservice.theme.ThemeService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.theme.BiliTheme;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ThemeServiceImpl.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/theme/router/ThemeServiceImpl;", "Lcom/bilibili/moduleservice/theme/ThemeService;", "<init>", "()V", "isNightTheme", "", "readThemeId", "", "context", "Landroid/content/Context;", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ThemeServiceImpl implements ThemeService {
    public boolean isNightTheme() {
        Application it = BiliContext.application();
        if (it == null) {
            return false;
        }
        return BiliTheme.isNightTheme(it);
    }

    public int readThemeId(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BiliTheme.readThemeId(context);
    }
}