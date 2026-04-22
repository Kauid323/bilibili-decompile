package tv.danmaku.bili.videopage.common.helper;

import android.content.Context;
import com.bilibili.commons.ClassUtils;
import com.bilibili.droid.RomUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MultiWindowModeUtils.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/videopage/common/helper/MultiWindowModeUtils;", "", "<init>", "()V", "isInXiaoMiFreeform", "", "context", "Landroid/content/Context;", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MultiWindowModeUtils {
    public static final MultiWindowModeUtils INSTANCE = new MultiWindowModeUtils();

    private MultiWindowModeUtils() {
    }

    @JvmStatic
    public static final boolean isInXiaoMiFreeform(Context context) {
        if (context != null && RomUtils.isMiuiRom()) {
            try {
                Class cClazz = ClassUtils.getClass(context.getClassLoader(), "android.content.res.Configuration", false);
                Class wcClazz = ClassUtils.getClass(context.getClassLoader(), "android.app.WindowConfiguration", false);
                Object wc = cClazz.getDeclaredField("windowConfiguration").get(context.getResources().getConfiguration());
                Object invoke = wcClazz.getMethod("getWindowingMode", new Class[0]).invoke(wc, new Object[0]);
                Integer wm = invoke instanceof Integer ? (Integer) invoke : null;
                if (wm != null) {
                    if (wm.intValue() == 5) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}