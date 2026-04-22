package tv.danmaku.bili.ui.splash;

import androidx.lifecycle.MutableLiveData;
import com.bilibili.homepage.HomePageJumpService;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.pegasus.AutoJumpType;
import com.bilibili.pegasus.PegasusVisibleService;
import com.bilibili.pegasus.PegasusVisibleServiceKt;
import kotlin.Metadata;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ClipboardJumpHelper.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\u0000\u001a\b\u0010\u000e\u001a\u00020\fH\u0000\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0000\u0010\u0002\"\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u00020\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0002\"\u0004\b\u0006\u0010\u0004\"\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"isClipboardJumped", "", "()Z", "setClipboardJumped", "(Z)V", "isSceneRedirected", "setSceneRedirected", "service", "Lcom/bilibili/homepage/HomePageJumpService;", "TAG", "", "onClipboardJumped", "", "jumped", "onClipboardChecking", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ClipboardJumpHelper {
    private static final String TAG = "ClipboardJumpHelper";
    private static boolean isClipboardJumped;
    private static boolean isSceneRedirected;
    private static final HomePageJumpService service = (HomePageJumpService) BLRouter.INSTANCE.get(HomePageJumpService.class, "HomePageJumpService");

    public static final boolean isClipboardJumped() {
        return isClipboardJumped;
    }

    public static final void setClipboardJumped(boolean z) {
        isClipboardJumped = z;
    }

    public static final boolean isSceneRedirected() {
        return isSceneRedirected;
    }

    public static final void setSceneRedirected(boolean z) {
        isSceneRedirected = z;
    }

    public static final void onClipboardJumped(boolean jumped) {
        PegasusVisibleService pegasusVisibleService;
        if (jumped && (pegasusVisibleService = PegasusVisibleServiceKt.getPegasusVisibleService()) != null) {
            pegasusVisibleService.onAutoJump(AutoJumpType.COPY_LINK, (String) null);
        }
        if (isClipboardJumped) {
            BLog.d(TAG, "isClipboardJumped jumped: " + jumped);
            return;
        }
        HomePageJumpService homePageJumpService = service;
        MutableLiveData livedata = homePageJumpService != null ? homePageJumpService.getJumpStatus() : null;
        if (livedata != null) {
            livedata.postValue(Integer.valueOf(jumped ? 2 : 3));
        }
        isClipboardJumped = jumped;
        BLog.d(TAG, "on clipboard jumped: " + jumped + " livedata:" + (livedata != null ? (Integer) livedata.getValue() : null));
    }

    public static final void onClipboardChecking() {
        MutableLiveData jumpStatus;
        isClipboardJumped = false;
        HomePageJumpService homePageJumpService = service;
        if (homePageJumpService != null && (jumpStatus = homePageJumpService.getJumpStatus()) != null) {
            jumpStatus.postValue(1);
        }
        BLog.d(TAG, "on clipboard jump checking");
    }
}