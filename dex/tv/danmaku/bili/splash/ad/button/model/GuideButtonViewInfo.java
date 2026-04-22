package tv.danmaku.bili.splash.ad.button.model;

import BottomSheetItemData$;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: GuideButtonViewInfo.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/splash/ad/button/model/GuideButtonViewInfo;", "", "view", "Landroid/view/View;", "disableOutsideInteractiveView", "", "<init>", "(Landroid/view/View;Z)V", "getView", "()Landroid/view/View;", "getDisableOutsideInteractiveView", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GuideButtonViewInfo {
    public static final int $stable = 8;
    private final boolean disableOutsideInteractiveView;
    private final View view;

    public static /* synthetic */ GuideButtonViewInfo copy$default(GuideButtonViewInfo guideButtonViewInfo, View view, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            view = guideButtonViewInfo.view;
        }
        if ((i & 2) != 0) {
            z = guideButtonViewInfo.disableOutsideInteractiveView;
        }
        return guideButtonViewInfo.copy(view, z);
    }

    public final View component1() {
        return this.view;
    }

    public final boolean component2() {
        return this.disableOutsideInteractiveView;
    }

    public final GuideButtonViewInfo copy(View view, boolean z) {
        return new GuideButtonViewInfo(view, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GuideButtonViewInfo) {
            GuideButtonViewInfo guideButtonViewInfo = (GuideButtonViewInfo) obj;
            return Intrinsics.areEqual(this.view, guideButtonViewInfo.view) && this.disableOutsideInteractiveView == guideButtonViewInfo.disableOutsideInteractiveView;
        }
        return false;
    }

    public int hashCode() {
        return ((this.view == null ? 0 : this.view.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.disableOutsideInteractiveView);
    }

    public String toString() {
        View view = this.view;
        return "GuideButtonViewInfo(view=" + view + ", disableOutsideInteractiveView=" + this.disableOutsideInteractiveView + ")";
    }

    public GuideButtonViewInfo(View view, boolean disableOutsideInteractiveView) {
        this.view = view;
        this.disableOutsideInteractiveView = disableOutsideInteractiveView;
    }

    public final boolean getDisableOutsideInteractiveView() {
        return this.disableOutsideInteractiveView;
    }

    public final View getView() {
        return this.view;
    }
}