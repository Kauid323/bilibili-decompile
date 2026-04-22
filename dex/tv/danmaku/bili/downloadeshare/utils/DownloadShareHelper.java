package tv.danmaku.bili.downloadeshare.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.bilibili.lib.sharewrapper.selector.SharePlatform;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: DownloadShareHelper.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005J\u0016\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/downloadeshare/utils/DownloadShareHelper;", "", "<init>", "()V", "STYLE_DEFAULT", "", "STYLE_A", "isOutOfBounds", "", "window", "Landroid/view/Window;", "event", "Landroid/view/MotionEvent;", "dp2px", "", "context", "Landroid/content/Context;", "dp", "vibrate", "", "milliseconds", "", "amplitude", "checkInstalledThirdPartChannel", "channel", "", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DownloadShareHelper {
    public static final DownloadShareHelper INSTANCE = new DownloadShareHelper();
    public static final int STYLE_A = 1;
    public static final int STYLE_DEFAULT = 0;

    private DownloadShareHelper() {
    }

    public final boolean isOutOfBounds(Window window, MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (window == null) {
            return false;
        }
        int x = (int) event.getX();
        int y = (int) event.getY();
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        BLog.i("miamiaomiao", "x" + x + ", y" + y + ", width" + decorView.getWidth() + ", height" + decorView);
        return x < 0 || y < 0 || x > decorView.getWidth() || y > decorView.getHeight();
    }

    public final float dp2px(Context context, float dp) {
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

    public final void vibrate(Context context, long milliseconds, int amplitude) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("vibrator");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        Vibrator vibrator = (Vibrator) systemService;
        if (Build.VERSION.SDK_INT < 26) {
            vibrator.vibrate(milliseconds);
            return;
        }
        VibrationEffect effect = VibrationEffect.createOneShot(milliseconds, amplitude);
        Intrinsics.checkNotNullExpressionValue(effect, "createOneShot(...)");
        vibrator.vibrate(effect);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
        if (r2.equals("QQ") == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
        if (r2.equals("WEIXIN") == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
        return com.bilibili.lib.sharewrapper.selector.SharePlatform.isQQInstalled(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
        return com.bilibili.lib.sharewrapper.selector.SharePlatform.isWxInstalled(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:
        if (r2.equals("WEIXIN_MONMENT") == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        if (r2.equals("QZONE") == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean checkInstalledThirdPartChannel(String channel, Context context) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(context, "context");
        switch (channel.hashCode()) {
            case -1738246558:
                break;
            case 2592:
                break;
            case 2545289:
                if (channel.equals("SINA")) {
                    return SharePlatform.isSinaInstalled(context);
                }
                return true;
            case 77564797:
                break;
            case 1120828781:
                break;
            default:
                return true;
        }
    }
}