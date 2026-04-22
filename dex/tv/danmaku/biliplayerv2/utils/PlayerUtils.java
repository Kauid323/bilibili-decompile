package tv.danmaku.biliplayerv2.utils;

import android.content.Context;
import android.media.MediaScannerConnection;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.comm.restrict.RestrictedType;
import com.bilibili.teenagersmode.TeenagersMode;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.player.plugin.mod.X86IjkRequest;

/* compiled from: PlayerUtils.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0005H\u0007J\b\u0010\t\u001a\u00020\u0005H\u0007J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/biliplayerv2/utils/PlayerUtils;", "", "<init>", "()V", "mInit", "", "isTeenagersMode", "isLessonsMode", "inTeenagersMode", "inLessonsMode", "scanMediaFile", "", "context", "Landroid/content/Context;", "newFile", "Ljava/io/File;", "initRestrictedType", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerUtils {
    public static final PlayerUtils INSTANCE = new PlayerUtils();
    private static boolean isLessonsMode;
    private static boolean isTeenagersMode;
    private static boolean mInit;

    private PlayerUtils() {
    }

    @JvmStatic
    public static final boolean inTeenagersMode() {
        INSTANCE.initRestrictedType();
        return isTeenagersMode;
    }

    @JvmStatic
    public static final boolean inLessonsMode() {
        INSTANCE.initRestrictedType();
        return isLessonsMode;
    }

    public final void scanMediaFile(Context context, File newFile) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(newFile, "newFile");
        MediaScannerConnection.scanFile(context, new String[]{newFile.getPath()}, null, null);
    }

    private final void initRestrictedType() {
        if (mInit) {
            return;
        }
        mInit = true;
        isTeenagersMode = TeenagersMode.getInstance().isEnable(X86IjkRequest.POOL);
        isLessonsMode = RestrictedMode.isEnable(RestrictedType.LESSONS, X86IjkRequest.POOL);
        TeenagersMode.getInstance().registerListener(new TeenagersMode.OnTeenagersModeChangeListener() { // from class: tv.danmaku.biliplayerv2.utils.PlayerUtils$initRestrictedType$1
            public /* synthetic */ void onStateChange(boolean z, boolean z2, boolean z3) {
                TeenagersMode.OnTeenagersModeChangeListener.-CC.$default$onStateChange(this, z, z2, z3);
            }

            public void onStateChange(boolean isEnable, boolean isBizEnable) {
                PlayerUtils playerUtils = PlayerUtils.INSTANCE;
                PlayerUtils.isTeenagersMode = isEnable;
            }

            public void onTeenagerModePageShow(boolean isShow) {
            }
        });
        RestrictedMode.registerLessonsChangeListener(X86IjkRequest.POOL, new RestrictedMode.OnStateChangeListener() { // from class: tv.danmaku.biliplayerv2.utils.PlayerUtils$initRestrictedType$2
            public void onChanged(boolean isEnable) {
                PlayerUtils playerUtils = PlayerUtils.INSTANCE;
                PlayerUtils.isLessonsMode = isEnable;
            }
        });
    }
}