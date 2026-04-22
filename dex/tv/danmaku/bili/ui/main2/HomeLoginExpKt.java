package tv.danmaku.bili.ui.main2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.app.comm.list.common.feed.PegasusProblemReporter;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.accounts.BiliAccounts;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.exp.FullscreenLoginExp;

/* compiled from: HomeLoginExp.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\u0014\u0010\b\u001a\u00020\u0003*\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0000\u001a\f\u0010\u000b\u001a\u00020\u0003*\u00020\fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"TAG", "", "onAppStart", "", "Landroidx/fragment/app/FragmentActivity;", "hasOneLoginShown", "", "hasStartFromHomeFragment", "checkShowOnePassLoginGuide", "Landroidx/fragment/app/Fragment;", "fromStartUpFragment", "checkShowOnePass", "Ltv/danmaku/bili/ui/main2/HomeFragmentV2;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HomeLoginExpKt {
    private static final String TAG = "[Home]HomeLoginExp";
    private static boolean hasOneLoginShown;
    private static boolean hasStartFromHomeFragment;

    public static final void onAppStart(FragmentActivity $this$onAppStart) {
        Intrinsics.checkNotNullParameter($this$onAppStart, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $this$onAppStart), (CoroutineContext) null, (CoroutineStart) null, new HomeLoginExpKt$onAppStart$1($this$onAppStart, null), 3, (Object) null);
    }

    public static final void checkShowOnePassLoginGuide(Fragment $this$checkShowOnePassLoginGuide, boolean fromStartUpFragment) {
        Intrinsics.checkNotNullParameter($this$checkShowOnePassLoginGuide, "<this>");
        hasStartFromHomeFragment |= !fromStartUpFragment;
        if (fromStartUpFragment && (FullscreenLoginExp.INSTANCE.getExpLoginDialogShown() || FullscreenLoginExp.INSTANCE.getFullScreenShown() || hasOneLoginShown)) {
            BLog.i(TAG, "checkShowOnePassLoginGuide, login has shown");
            return;
        }
        if (fromStartUpFragment && hasStartFromHomeFragment && !BiliAccounts.get(BiliContext.application()).isLogin()) {
            BLog.i(TAG, "checkShowOnePassLoginGuide, dup request");
            PegasusProblemReporter.INSTANCE.reportDupLoginRequest();
        }
        BLog.i(TAG, "checkShowOnePassLoginGuide, fromStartUp = " + fromStartUpFragment + ", hasOneLoginShown = " + hasOneLoginShown);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $this$checkShowOnePassLoginGuide), (CoroutineContext) null, (CoroutineStart) null, new HomeLoginExpKt$checkShowOnePassLoginGuide$1($this$checkShowOnePassLoginGuide, fromStartUpFragment, null), 3, (Object) null);
    }

    public static final void checkShowOnePass(HomeFragmentV2 $this$checkShowOnePass) {
        Intrinsics.checkNotNullParameter($this$checkShowOnePass, "<this>");
        LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $this$checkShowOnePass).launchWhenResumed(new HomeLoginExpKt$checkShowOnePass$1($this$checkShowOnePass, null));
    }
}