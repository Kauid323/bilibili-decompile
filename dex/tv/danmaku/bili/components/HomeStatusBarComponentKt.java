package tv.danmaku.bili.components;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.helper.NotchCompat;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.lib.ui.util.StatusBarCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.MainActivityV2;
import tv.danmaku.bili.report.misaka.MisakaHelper;

/* compiled from: HomeStatusBarComponent.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0006\u001a\f\u0010\u0007\u001a\u00020\u0003*\u00020\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"TAG", "", "observerStatusBarStatus", "", "Ltv/danmaku/bili/MainActivityV2;", "enterFullscreen", "(Ltv/danmaku/bili/MainActivityV2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exitFullScreen", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HomeStatusBarComponentKt {
    private static final String TAG = "[Home]HomeStatusBarComponent";

    public static final void observerStatusBarStatus(MainActivityV2 $this$observerStatusBarStatus) {
        Intrinsics.checkNotNullParameter($this$observerStatusBarStatus, "<this>");
        Ref.ObjectRef pathLog = new Ref.ObjectRef();
        pathLog.element = "";
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $this$observerStatusBarStatus), (CoroutineContext) null, (CoroutineStart) null, new HomeStatusBarComponentKt$observerStatusBarStatus$1($this$observerStatusBarStatus, pathLog, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $this$observerStatusBarStatus), (CoroutineContext) null, (CoroutineStart) null, new HomeStatusBarComponentKt$observerStatusBarStatus$2($this$observerStatusBarStatus, null), 3, (Object) null);
        boolean statusBarFixExp = DeviceDecision.INSTANCE.getBoolean("dd_home_page_status_bar_fix_exp", true);
        if (statusBarFixExp) {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $this$observerStatusBarStatus), (CoroutineContext) null, (CoroutineStart) null, new HomeStatusBarComponentKt$observerStatusBarStatus$3($this$observerStatusBarStatus, pathLog, $this$observerStatusBarStatus, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object enterFullscreen(MainActivityV2 $this$enterFullscreen, Continuation<? super Unit> continuation) {
        HomeStatusBarComponentKt$enterFullscreen$1 homeStatusBarComponentKt$enterFullscreen$1;
        if (continuation instanceof HomeStatusBarComponentKt$enterFullscreen$1) {
            homeStatusBarComponentKt$enterFullscreen$1 = (HomeStatusBarComponentKt$enterFullscreen$1) continuation;
            if ((homeStatusBarComponentKt$enterFullscreen$1.label & Integer.MIN_VALUE) != 0) {
                homeStatusBarComponentKt$enterFullscreen$1.label -= Integer.MIN_VALUE;
                Object $result = homeStatusBarComponentKt$enterFullscreen$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (homeStatusBarComponentKt$enterFullscreen$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        BLog.i(TAG, "enterFullscreen, start");
                        Flow callbackFlow = FlowKt.callbackFlow(new HomeStatusBarComponentKt$enterFullscreen$2($this$enterFullscreen, null));
                        homeStatusBarComponentKt$enterFullscreen$1.L$0 = $this$enterFullscreen;
                        homeStatusBarComponentKt$enterFullscreen$1.label = 1;
                        if (FlowKt.first(callbackFlow, homeStatusBarComponentKt$enterFullscreen$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        $this$enterFullscreen = (MainActivityV2) homeStatusBarComponentKt$enterFullscreen$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                BLog.i(TAG, "enterFullscreen, start set full screen");
                $this$enterFullscreen.getWindow().setFlags(MisakaHelper.MAX_REPORT_SIZE, MisakaHelper.MAX_REPORT_SIZE);
                if (NotchCompat.hasDisplayCutout($this$enterFullscreen.getWindow())) {
                    NotchCompat.immersiveDisplayCutout($this$enterFullscreen.getWindow());
                }
                BLog.i(TAG, "enterFullscreen, set finish");
                return Unit.INSTANCE;
            }
        }
        homeStatusBarComponentKt$enterFullscreen$1 = new HomeStatusBarComponentKt$enterFullscreen$1(continuation);
        Object $result2 = homeStatusBarComponentKt$enterFullscreen$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (homeStatusBarComponentKt$enterFullscreen$1.label) {
        }
        BLog.i(TAG, "enterFullscreen, start set full screen");
        $this$enterFullscreen.getWindow().setFlags(MisakaHelper.MAX_REPORT_SIZE, MisakaHelper.MAX_REPORT_SIZE);
        if (NotchCompat.hasDisplayCutout($this$enterFullscreen.getWindow())) {
        }
        BLog.i(TAG, "enterFullscreen, set finish");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void exitFullScreen(MainActivityV2 $this$exitFullScreen) {
        BLog.i(TAG, "exitFullscreen, start");
        Window window = $this$exitFullScreen.getWindow();
        if (window == null) {
            return;
        }
        window.clearFlags(MisakaHelper.MAX_REPORT_SIZE);
        boolean statusBarJumpFix = DeviceDecision.INSTANCE.getBoolean("dd_home_status_bar_jump_fix", true);
        if (!statusBarJumpFix && NotchCompat.hasDisplayCutout(window)) {
            NotchCompat.resetDisplayCutout(window);
        }
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        window.getDecorView().setSystemUiVisibility(StatusBarCompat.setNavigationBarMode((Activity) $this$exitFullScreen, 1024 | systemUiVisibility | BR.hallEnterHotText, MultipleThemeUtils.isNightTheme((Context) $this$exitFullScreen)));
        Garb garb = GarbManager.getGarbWithNightMode((Context) $this$exitFullScreen);
        if (garb.isPure()) {
            $this$exitFullScreen.tintStatusBarPureForDrawer();
        } else {
            StatusBarCompat.tintStatusBarForDrawer((Activity) $this$exitFullScreen, garb.getSecondaryPageColor(), garb.isDarkMode() ? 1 : 2);
        }
        BLog.i(TAG, "exitFullscreen, end");
    }
}