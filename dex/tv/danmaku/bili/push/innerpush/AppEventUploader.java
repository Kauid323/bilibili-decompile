package tv.danmaku.bili.push.innerpush;

import android.app.Activity;
import com.bilibili.base.BiliContext;
import com.bilibili.base.ipc.IPCAppStateManager;
import com.bilibili.lib.homepage.util.BottomTabSelectedHelper;
import com.bilibili.lib.homepage.util.UriUtils;
import com.bilibili.lib.ui.IDrawerHost;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: AppEventUploader.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/push/innerpush/AppEventUploader;", "", "<init>", "()V", "HOMEPAGE_MAIN_PATH", "", "TAG", "checkHomePage", "", "initialize", "", "onLaunch", "onBackground", "onForeground", "onBackHomepage", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AppEventUploader {
    public static final int $stable = 0;
    private static final String HOMEPAGE_MAIN_PATH = "bilibili://main/home";
    public static final AppEventUploader INSTANCE = new AppEventUploader();
    private static final String TAG = "AppEventUploader";

    private AppEventUploader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkHomePage() {
        return UriUtils.equals(BottomTabSelectedHelper.INSTANCE.getCurrentBottomTabUrl(), "bilibili://main/home");
    }

    @JvmStatic
    public static final void initialize() {
        if (BiliContext.isMainProcess()) {
            final Ref.BooleanRef skipLaunch = new Ref.BooleanRef();
            skipLaunch.element = true;
            final Ref.BooleanRef isBackHomepage = new Ref.BooleanRef();
            final Ref.BooleanRef isBackground = new Ref.BooleanRef();
            IPCAppStateManager.getInstance().addIPCActivityStateCallback(new IPCAppStateManager.IPCActivityStateCallback() { // from class: tv.danmaku.bili.push.innerpush.AppEventUploader$initialize$1
                public void onVisibleCountChanged(int lastVisibleCount, int currentVisibleCount) {
                    if (currentVisibleCount == 0) {
                        isBackground.element = true;
                        AppEventUploader.INSTANCE.onBackground();
                        return;
                    }
                    if (isBackground.element) {
                        AppEventUploader.INSTANCE.onForeground();
                    } else if (isBackHomepage.element) {
                        AppEventUploader.INSTANCE.onBackHomepage();
                    }
                    isBackground.element = false;
                    isBackHomepage.element = false;
                }

                public void onForegroundActivitiesChanged(int lastForegroundCount, int currentForegroundCount) {
                }
            });
            BiliContext.registerActivityStateCallback(new BiliContext.ActivityStateCallback() { // from class: tv.danmaku.bili.push.innerpush.AppEventUploader$initialize$2
                public void onActivityStarted(Activity activity) {
                    boolean checkHomePage;
                    Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
                    if (skipLaunch.element) {
                        skipLaunch.element = false;
                    } else if (activity instanceof IDrawerHost) {
                        checkHomePage = AppEventUploader.INSTANCE.checkHomePage();
                        if (checkHomePage) {
                            isBackHomepage.element = true;
                        }
                    }
                }
            });
            INSTANCE.onLaunch();
        }
    }

    private final void onLaunch() {
        BuildersKt.launch$default(AppEventUploaderKt.getUploadLoadScope(), (CoroutineContext) null, (CoroutineStart) null, new AppEventUploader$onLaunch$1(null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBackground() {
        BuildersKt.launch$default(AppEventUploaderKt.getUploadLoadScope(), (CoroutineContext) null, (CoroutineStart) null, new AppEventUploader$onBackground$1(null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onForeground() {
        BuildersKt.launch$default(AppEventUploaderKt.getUploadLoadScope(), (CoroutineContext) null, (CoroutineStart) null, new AppEventUploader$onForeground$1(null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBackHomepage() {
        BuildersKt.launch$default(AppEventUploaderKt.getUploadLoadScope(), (CoroutineContext) null, (CoroutineStart) null, new AppEventUploader$onBackHomepage$1(null), 3, (Object) null);
    }
}