package tv.danmaku.bili.splash.ad.button.model;

import BottomSheetItemData$;
import android.view.View;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: GuideButtonViewListInfo.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/splash/ad/button/model/GuideButtonViewListInfo;", "", "viewList", "", "Landroid/view/View;", "disableOutsideInteractiveView", "", "<init>", "(Ljava/util/List;Z)V", "getViewList", "()Ljava/util/List;", "getDisableOutsideInteractiveView", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GuideButtonViewListInfo {
    public static final int $stable = 8;
    private final boolean disableOutsideInteractiveView;
    private final List<View> viewList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuideButtonViewListInfo copy$default(GuideButtonViewListInfo guideButtonViewListInfo, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = guideButtonViewListInfo.viewList;
        }
        if ((i & 2) != 0) {
            z = guideButtonViewListInfo.disableOutsideInteractiveView;
        }
        return guideButtonViewListInfo.copy(list, z);
    }

    public final List<View> component1() {
        return this.viewList;
    }

    public final boolean component2() {
        return this.disableOutsideInteractiveView;
    }

    public final GuideButtonViewListInfo copy(List<? extends View> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "viewList");
        return new GuideButtonViewListInfo(list, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GuideButtonViewListInfo) {
            GuideButtonViewListInfo guideButtonViewListInfo = (GuideButtonViewListInfo) obj;
            return Intrinsics.areEqual(this.viewList, guideButtonViewListInfo.viewList) && this.disableOutsideInteractiveView == guideButtonViewListInfo.disableOutsideInteractiveView;
        }
        return false;
    }

    public int hashCode() {
        return (this.viewList.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.disableOutsideInteractiveView);
    }

    public String toString() {
        List<View> list = this.viewList;
        return "GuideButtonViewListInfo(viewList=" + list + ", disableOutsideInteractiveView=" + this.disableOutsideInteractiveView + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuideButtonViewListInfo(List<? extends View> list, boolean disableOutsideInteractiveView) {
        Intrinsics.checkNotNullParameter(list, "viewList");
        this.viewList = list;
        this.disableOutsideInteractiveView = disableOutsideInteractiveView;
    }

    public final boolean getDisableOutsideInteractiveView() {
        return this.disableOutsideInteractiveView;
    }

    public final List<View> getViewList() {
        return this.viewList;
    }
}