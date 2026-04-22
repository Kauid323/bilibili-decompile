package tv.danmaku.bili.videopage.common.helper;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import tv.danmaku.bili.videopage.common.VideoPageConstants;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ActivityBundleFix.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/videopage/common/helper/ActivityBundleFix;", "", "<init>", "()V", "clearInvalidBundle", "", "bundle", "Landroid/os/Bundle;", "fixInvalidClassLoader", "context", "Landroid/content/Context;", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ActivityBundleFix {
    public static final ActivityBundleFix INSTANCE = new ActivityBundleFix();

    private ActivityBundleFix() {
    }

    @JvmStatic
    public static final void clearInvalidBundle(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.remove(VideoPageConstants.FRAGMENTS_TAG);
        Bundle bundle2 = bundle.getBundle(VideoPageConstants.SAVED_COMPONENTS_KEY);
        if (bundle2 != null) {
            bundle2.remove(VideoPageConstants.FRAGMENTS_TAG);
        }
    }

    @JvmStatic
    public static final void fixInvalidClassLoader(Context context, Bundle bundle) {
        Iterable keySet;
        if (bundle == null || context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT == 29 || Build.VERSION.SDK_INT == 28) {
            try {
                bundle.setClassLoader(context.getClass().getClassLoader());
                Bundle it = bundle.getBundle(VideoPageConstants.SAVED_COMPONENTS_KEY);
                if (it == null || (keySet = it.keySet()) == null) {
                    return;
                }
                Iterable $this$forEach$iv = keySet;
                for (Object element$iv : $this$forEach$iv) {
                    String key = (String) element$iv;
                    Object obj = it.get(key);
                    Bundle bundle2 = obj instanceof Bundle ? (Bundle) obj : null;
                    if (bundle2 != null) {
                        bundle2.setClassLoader(context.getClass().getClassLoader());
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}