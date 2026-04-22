package tv.danmaku.bili.ui.main2.basic;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import com.bilibili.lib.homepage.splash.BaseMainViewModel;
import com.bilibili.magicasakura.widgets.TintAppBarLayout;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: BaseMainFrameComponent.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\u0016\u0010\u0005\u001a\u00020\u0003*\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u001c\u0010\b\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002\u001a\u0014\u0010\u000b\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\r\u001a\u00020\u0007*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0018\u0010\u000f\u001a\u00020\u0007*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"LOG_TAG", "", "observerAppbar", "", "Ltv/danmaku/bili/ui/main2/basic/BaseMainFrameFragment;", "enableScroll", "enable", "", "expandToolBar", "expand", "animate", "showToolbar", ReportEvent.EVENT_TYPE_SHOW, "isToolbarVisible", "(Ltv/danmaku/bili/ui/main2/basic/BaseMainFrameFragment;)Z", "isToolbarScrollable", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BaseMainFrameComponentKt {
    private static final String LOG_TAG = "[HomeFrame]BaseMainFrameComponent";

    public static final void observerAppbar(BaseMainFrameFragment $this$observerAppbar) {
        Intrinsics.checkNotNullParameter($this$observerAppbar, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $this$observerAppbar), (CoroutineContext) null, (CoroutineStart) null, new BaseMainFrameComponentKt$observerAppbar$1($this$observerAppbar, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void enableScroll$default(BaseMainFrameFragment baseMainFrameFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        enableScroll(baseMainFrameFragment, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enableScroll(BaseMainFrameFragment $this$enableScroll, boolean enable) {
        int i;
        AppBarLayout.LayoutParams layoutParams = $this$enableScroll.mToolbar.getLayoutParams();
        AppBarLayout.LayoutParams lp = layoutParams instanceof AppBarLayout.LayoutParams ? layoutParams : null;
        if (lp == null) {
            return;
        }
        if (enable) {
            i = 21;
        } else {
            i = 0;
        }
        lp.setScrollFlags(i);
        $this$enableScroll.mToolbar.setLayoutParams((ViewGroup.LayoutParams) lp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void expandToolBar(BaseMainFrameFragment $this$expandToolBar, boolean expand, boolean animate) {
        $this$expandToolBar.mAppBarLayout.setExpanded(expand, animate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showToolbar(BaseMainFrameFragment $this$showToolbar, boolean show) {
        Toolbar toolbar = $this$showToolbar.mToolbar;
        boolean z = true;
        if ((toolbar != null && toolbar.getVisibility() == 0) && show) {
            return;
        }
        Toolbar toolbar2 = $this$showToolbar.mToolbar;
        if (toolbar2 == null || toolbar2.getVisibility() != 8) {
            z = false;
        }
        if (z && !show) {
            return;
        }
        if (show) {
            TintAppBarLayout tintAppBarLayout = $this$showToolbar.mAppBarLayout;
            if (tintAppBarLayout != null) {
                tintAppBarLayout.addOnOffsetChangedListener($this$showToolbar.mOffsetListener);
            }
        } else {
            TintAppBarLayout tintAppBarLayout2 = $this$showToolbar.mAppBarLayout;
            if (tintAppBarLayout2 != null) {
                tintAppBarLayout2.removeOnOffsetChangedListener($this$showToolbar.mOffsetListener);
            }
        }
        Toolbar toolbar3 = $this$showToolbar.mToolbar;
        if (toolbar3 != null) {
            toolbar3.setVisibility(show ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isToolbarVisible(BaseMainFrameFragment $this$isToolbarVisible) {
        MutableLiveData isExpanded;
        Toolbar toolbar = $this$isToolbarVisible.mToolbar;
        if (toolbar != null && toolbar.getVisibility() == 0) {
            BaseMainViewModel baseMainViewModel = $this$isToolbarVisible.mBaseMainViewModel;
            if ((baseMainViewModel == null || (isExpanded = baseMainViewModel.isExpanded()) == null) ? false : Intrinsics.areEqual(isExpanded.getValue(), true)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean isToolbarScrollable(BaseMainFrameFragment $this$isToolbarScrollable) {
        View view = $this$isToolbarScrollable.mToolbar;
        if (view == null) {
            return false;
        }
        AppBarLayout.LayoutParams layoutParams = $this$isToolbarScrollable.mToolbar.getLayoutParams();
        AppBarLayout.LayoutParams lp = layoutParams instanceof AppBarLayout.LayoutParams ? layoutParams : null;
        if (lp == null) {
            return false;
        }
        lp.getScrollFlags();
        View $this$isVisible$iv = view;
        View $this$isVisible$iv2 = $this$isVisible$iv.getVisibility() == 0 ? 1 : null;
        return ($this$isVisible$iv2 == null || 1 == 0) ? false : true;
    }
}