package tv.danmaku.bili;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import tv.danmaku.bili.router.SearchRoutes;
import tv.danmaku.bili.ui.intent.IntentHandlerActivity;

/* compiled from: ShortcutHelper.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/ShortcutHelper;", "", "<init>", "()V", "TAG", "", "ACTION_SHORT_CUT", "SHORTCUT_SEARCH", "SHORTCUT_DOWNLOAD", "ENABLED", "", "publishAllDynamic", "", "context", "Landroid/content/Context;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ShortcutHelper {
    public static final int $stable = 0;
    private static final String ACTION_SHORT_CUT = "tv.danmaku.bili.action.SHORT_CUT";
    private static final boolean ENABLED;
    public static final ShortcutHelper INSTANCE = new ShortcutHelper();
    private static final String SHORTCUT_DOWNLOAD = "download-list";
    private static final String SHORTCUT_SEARCH = "search";
    private static final String TAG = "ShortcutHelper";

    private ShortcutHelper() {
    }

    static {
        ENABLED = Build.VERSION.SDK_INT >= 25;
    }

    @JvmStatic
    public static final void publishAllDynamic(Context context) {
        ShortcutManager shortcutManager;
        Intrinsics.checkNotNullParameter(context, "context");
        if (ENABLED && (shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class)) != null) {
            ArrayList shortcutInfos = new ArrayList(2);
            ShortcutInfo searchShortcut = new ShortcutInfo.Builder(context, "search").setShortLabel(context.getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_531)).setLongLabel(context.getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_531)).setIcon(Icon.createWithResource(context, R.drawable.ic_shortcut_search)).setIntent(new Intent(ACTION_SHORT_CUT, Uri.parse(SearchRoutes.URI_BILIBILI_SEARCH)).setClass(context, IntentHandlerActivity.class)).build();
            Intrinsics.checkNotNullExpressionValue(searchShortcut, "build(...)");
            shortcutInfos.add(searchShortcut);
            ShortcutInfo downloadShortcut = new ShortcutInfo.Builder(context, SHORTCUT_DOWNLOAD).setShortLabel(context.getString(bili.resource.homepage.R.string.homepage_global_string_247)).setLongLabel(context.getString(bili.resource.homepage.R.string.homepage_global_string_247)).setIcon(Icon.createWithResource(context, R.drawable.ic_shortcut_download)).setIntent(new Intent(ACTION_SHORT_CUT, Uri.parse("activity://main/download-list")).setClass(context, IntentHandlerActivity.class)).build();
            Intrinsics.checkNotNullExpressionValue(downloadShortcut, "build(...)");
            shortcutInfos.add(downloadShortcut);
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new ShortcutHelper$publishAllDynamic$1(shortcutManager, shortcutInfos, null), 2, (Object) null);
        }
    }
}