package tv.danmaku.bili.ui.videospace;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.core.view.ViewCompat;
import com.bilibili.droid.RomUtils;
import com.bilibili.lib.basecomponent.R;
import com.bilibili.lib.ui.helper.NotchCompat;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.bilibili.playerbizcommon.features.hardware.IHardwareDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.WindowInset;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AuthorSpaceHeaderPlayerFragment.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\t2\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/ui/videospace/HardwareDelegate;", "Lcom/bilibili/playerbizcommon/features/hardware/IHardwareDelegate;", "mActivity", "Landroid/app/Activity;", "mVideoContainer", "Landroid/view/ViewGroup;", "<init>", "(Landroid/app/Activity;Landroid/view/ViewGroup;)V", "onHandleSwitchControlContainerType", "", "type", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "setStatusBarColor", "color", "", "fitSystemWindow", "landscape", "", "level", "tintFakeStatusBar", "onAdjustWindowInset", "inset", "Ltv/danmaku/biliplayerv2/service/WindowInset;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class HardwareDelegate implements IHardwareDelegate {
    public static final int $stable = 8;
    private final Activity mActivity;
    private final ViewGroup mVideoContainer;

    public /* synthetic */ boolean changeOrientationEnable() {
        return IHardwareDelegate.-CC.$default$changeOrientationEnable(this);
    }

    public /* synthetic */ boolean onAdjustControlContainerType(ScreenModeType screenModeType, Video.PlayableParams playableParams) {
        return IHardwareDelegate.-CC.$default$onAdjustControlContainerType(this, screenModeType, playableParams);
    }

    public /* synthetic */ ControlContainerType onGetControlContainerType(ScreenModeType screenModeType) {
        return IHardwareDelegate.-CC.$default$onGetControlContainerType(this, screenModeType);
    }

    public /* synthetic */ ControlContainerType onGetControlContainerTypeForOrientation(int i) {
        return IHardwareDelegate.-CC.$default$onGetControlContainerTypeForOrientation(this, i);
    }

    public HardwareDelegate(Activity mActivity, ViewGroup mVideoContainer) {
        Intrinsics.checkNotNullParameter(mActivity, "mActivity");
        Intrinsics.checkNotNullParameter(mVideoContainer, "mVideoContainer");
        this.mActivity = mActivity;
        this.mVideoContainer = mVideoContainer;
    }

    public void onHandleSwitchControlContainerType(ControlContainerType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (type == ControlContainerType.HALF_SCREEN || type == ControlContainerType.VERTICAL_FULLSCREEN) {
            this.mActivity.getWindow().clearFlags(1024);
            this.mVideoContainer.getLayoutParams().height = StatusBarCompat.getDisplayRealSize(this.mActivity).y;
            this.mVideoContainer.getLayoutParams().width = StatusBarCompat.getDisplayRealSize(this.mActivity).x;
            fitSystemWindow(false, 3);
            NotchCompat.immersiveDisplayCutout(this.mActivity.getWindow());
            this.mVideoContainer.requestLayout();
            ViewCompat.setElevation(this.mVideoContainer, 100.0f);
            if (NotchCompat.hasDisplayCutout(this.mActivity.getWindow()) && !RomUtils.isSamsungRom()) {
                setStatusBarColor(0);
                tintFakeStatusBar(this.mActivity.getResources().getColor(17170445));
                return;
            }
            return;
        }
        this.mActivity.getWindow().setFlags(1024, 1024);
        this.mVideoContainer.getLayoutParams().height = StatusBarCompat.getDisplayRealSize(this.mActivity).y;
        this.mVideoContainer.getLayoutParams().width = StatusBarCompat.getDisplayRealSize(this.mActivity).x;
        fitSystemWindow(true, -1);
        NotchCompat.immersiveDisplayCutout(this.mActivity.getWindow());
        this.mVideoContainer.requestLayout();
        ViewCompat.setElevation(this.mVideoContainer, 100.0f);
        if (NotchCompat.hasDisplayCutout(this.mActivity.getWindow()) && !RomUtils.isSamsungRom()) {
            setStatusBarColor(0);
            tintFakeStatusBar(this.mActivity.getResources().getColor(17170445));
        }
    }

    private final void setStatusBarColor(int color) {
        this.mActivity.getWindow().setStatusBarColor(color);
    }

    private final void fitSystemWindow(boolean landscape, int level) {
        if (level < 0) {
            ViewGroup rootView = this.mVideoContainer;
            while (rootView != null && rootView.getId() != 16908290) {
                if (rootView instanceof ViewGroup) {
                    ((ViewGroup) rootView).setClipToPadding(!landscape);
                    ((ViewGroup) rootView).setClipChildren(!landscape);
                }
                ViewParent parent = rootView.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
                rootView = (View) parent;
            }
            return;
        }
        View rootView2 = this.mVideoContainer;
        View rootView3 = rootView2;
        for (int maxLevel = level; rootView3 != null && rootView3.getId() != 16908290 && maxLevel > 0; maxLevel--) {
            if (rootView3 instanceof ViewGroup) {
                ((ViewGroup) rootView3).setClipToPadding(!landscape);
                ((ViewGroup) rootView3).setClipChildren(!landscape);
            }
            ViewParent parent2 = rootView3.getParent();
            Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.View");
            rootView3 = (View) parent2;
        }
    }

    private final void tintFakeStatusBar(int color) {
        Window window = this.mActivity.getWindow();
        View decorView = window.getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup decorView2 = (ViewGroup) decorView;
        View statusBarView = this.mActivity.findViewById(R.id.bili_status_bar_view);
        if (statusBarView == null) {
            statusBarView = new View(this.mActivity);
            statusBarView.setId(R.id.bili_status_bar_view);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(-1, StatusBarCompat.getStatusBarHeight(this.mActivity));
            decorView2.addView(statusBarView, lp);
        }
        statusBarView.setBackgroundColor(color);
        statusBarView.setVisibility(0);
    }

    public boolean onAdjustWindowInset(WindowInset inset) {
        Intrinsics.checkNotNullParameter(inset, "inset");
        return true;
    }
}