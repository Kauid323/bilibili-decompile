package tv.danmaku.biliplayerv2.utils;

import android.content.Context;
import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DpUtils.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0007J\u001a\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0007¨\u0006\u000b"}, d2 = {"Ltv/danmaku/biliplayerv2/utils/DpUtils;", "", "<init>", "()V", "px2dp", "", "context", "Landroid/content/Context;", "px", "dp2px", "dp", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DpUtils {
    public static final DpUtils INSTANCE = new DpUtils();

    private DpUtils() {
    }

    @JvmStatic
    public static final float px2dp(Context context, float px) {
        if (context == null) {
            return px;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            return px;
        }
        float density = resources.getDisplayMetrics().density;
        return px / density;
    }

    @JvmStatic
    public static final float dp2px(Context context, float dp) {
        if (context == null) {
            return dp;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            return dp;
        }
        float density = resources.getDisplayMetrics().density;
        return dp * density;
    }
}