package tv.danmaku.bili.push;

import androidx.activity.ComponentActivity;
import com.bilibili.following.DisplayType;
import com.bilibili.following.UnreadState;
import com.bilibili.following.UnreadStateProvider;
import com.bilibili.gripper.api.push.GNotificationPermissionCallback;
import com.bilibili.gripper.api.push.GPush;
import com.bilibili.gripper.api.push.RedDotBiz;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.foundation.FoundationAlias;
import dagger.hilt.EntryPoints;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.StateFlow;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: BPushHelper.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0007J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0005H\u0007J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J \u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 H\u0007J\b\u0010!\u001a\u00020\u0005H\u0007R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\b¨\u0006\""}, d2 = {"Ltv/danmaku/bili/push/BPushHelper;", "", "<init>", "()V", "stateLogin", "", "getStateLogin$annotations", "getStateLogin", "()I", "stateLogout", "getStateLogout$annotations", "getStateLogout", "stateSwitch", "getStateSwitch$annotations", "getStateSwitch", "startPushService", "", "setRedDotByBiz", "gPush", "Lcom/bilibili/gripper/api/push/GPush;", "reportForeground", "triggerUpdateUserInfo", "loginState", "setRedDot", "num", "biz", "Lcom/bilibili/gripper/api/push/RedDotBiz;", "requestNotificationPermission", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/activity/ComponentActivity;", "requestCode", AuthResultCbHelper.ARGS_CALLBACK, "Lcom/bilibili/gripper/api/push/GNotificationPermissionCallback;", "currentPushType", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BPushHelper {
    public static final int $stable = 0;
    public static final BPushHelper INSTANCE = new BPushHelper();
    private static final int stateLogin = GPush.LoginState.LOGIN.getCode();
    private static final int stateLogout = GPush.LoginState.LOGOUT.getCode();
    private static final int stateSwitch = GPush.LoginState.SWITCH.getCode();

    @JvmStatic
    public static /* synthetic */ void getStateLogin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getStateLogout$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getStateSwitch$annotations() {
    }

    private BPushHelper() {
    }

    public static final int getStateLogin() {
        return stateLogin;
    }

    public static final int getStateLogout() {
        return stateLogout;
    }

    public static final int getStateSwitch() {
        return stateSwitch;
    }

    @JvmStatic
    public static final void startPushService() {
        GPush gPush = ((GPush.Fetcher) EntryPoints.get(FoundationAlias.getFapp(), GPush.Fetcher.class)).getGPush();
        if (gPush != null) {
            gPush.startPushService();
        }
        INSTANCE.setRedDotByBiz(gPush);
    }

    private final void setRedDotByBiz(GPush gPush) {
        UnreadStateProvider unreadStateProvider = (UnreadStateProvider) BLRouter.get$default(BLRouter.INSTANCE, UnreadStateProvider.class, (String) null, 2, (Object) null);
        final StateFlow followState = unreadStateProvider != null ? unreadStateProvider.getFollowingUnreadCount() : null;
        if (gPush != null) {
            gPush.registerRedDotCallback(new GPush.RedDotCallback() { // from class: tv.danmaku.bili.push.BPushHelper$setRedDotByBiz$1

                /* compiled from: BPushHelper.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[DisplayType.values().length];
                        try {
                            iArr[DisplayType.None.ordinal()] = 1;
                        } catch (NoSuchFieldError e) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                public int getFollowingRedDot() {
                    if (followState == null) {
                        return 0;
                    }
                    UnreadState current = (UnreadState) followState.getValue();
                    BLog.d("BPush", "followState getFollowingRedDot: " + current);
                    if (WhenMappings.$EnumSwitchMapping$0[current.getDisplayType().ordinal()] == 1) {
                        return 0;
                    }
                    return current.getCount();
                }
            });
        }
        BuildersKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new BPushHelper$setRedDotByBiz$2(followState, null), 3, (Object) null);
    }

    @JvmStatic
    public static final void reportForeground() {
        GPush gPush = ((GPush.Fetcher) EntryPoints.get(FoundationAlias.getFapp(), GPush.Fetcher.class)).getGPush();
        if (gPush != null) {
            gPush.reportForeground();
        }
    }

    @JvmStatic
    public static final void triggerUpdateUserInfo(int loginState) {
        GPush gPush = ((GPush.Fetcher) EntryPoints.get(FoundationAlias.getFapp(), GPush.Fetcher.class)).getGPush();
        if (gPush != null) {
            gPush.triggerUpdateUserInfo(loginState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRedDot(int num, RedDotBiz biz) {
        GPush gPush = ((GPush.Fetcher) EntryPoints.get(FoundationAlias.getFapp(), GPush.Fetcher.class)).getGPush();
        if (gPush != null) {
            gPush.setRedDot(num, biz);
        }
    }

    @JvmStatic
    public static final void requestNotificationPermission(ComponentActivity activity, int requestCode, GNotificationPermissionCallback callback) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(callback, AuthResultCbHelper.ARGS_CALLBACK);
        GPush gPush = ((GPush.Fetcher) EntryPoints.get(FoundationAlias.getFapp(), GPush.Fetcher.class)).getGPush();
        if (gPush != null) {
            gPush.requestNotificationPermission(activity, requestCode, callback);
        }
    }

    @JvmStatic
    public static final int currentPushType() {
        GPush gPush = ((GPush.Fetcher) EntryPoints.get(FoundationAlias.getFapp(), GPush.Fetcher.class)).getGPush();
        if (gPush != null) {
            int it = gPush.currentPushType();
            return it;
        }
        return -1;
    }
}