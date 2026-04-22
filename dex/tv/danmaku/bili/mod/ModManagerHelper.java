package tv.danmaku.bili.mod;

import android.content.Context;
import bolts.Task;
import com.bilibili.base.ipc.IPCAppStateManager;
import com.bilibili.lib.mod.ModResourceClient;
import java.util.concurrent.Callable;
import tv.danmaku.android.log.BLog;

public class ModManagerHelper {
    private static final long UPDATE_INTERVAL_MS = 1800000;
    private static long sLastUpdateTime = System.currentTimeMillis();

    public static void updateAllAsync(final Context context, final boolean ignoreCache) {
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.mod.ModManagerHelper$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ModManagerHelper.lambda$updateAllAsync$0(context, ignoreCache);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$updateAllAsync$0(Context context, boolean ignoreCache) throws Exception {
        if (ModResourceClient.getInstance().isInitFinish(context)) {
            ModResourceClient.getInstance().updateAll(context, ignoreCache);
            return null;
        }
        return null;
    }

    public static void registerIPCCallback(final Context context) {
        IPCAppStateManager.getInstance().addIPCActivityStateCallback(new IPCAppStateManager.GlobalVisibilityChangeCallback() { // from class: tv.danmaku.bili.mod.ModManagerHelper.1
            public void onBackground() {
                if (System.currentTimeMillis() - ModManagerHelper.sLastUpdateTime >= ModManagerHelper.UPDATE_INTERVAL_MS) {
                    ModManagerHelper.sLastUpdateTime = System.currentTimeMillis();
                    ModManagerHelper.updateAllAsync(context, true);
                    BLog.i("ModManager", "try update after 30min in background");
                }
            }

            public void onForeground() {
            }
        });
    }
}