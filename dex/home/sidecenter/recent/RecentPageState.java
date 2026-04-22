package home.sidecenter.recent;

import com.bapis.bilibili.app.home.v1.KHalfWatchedVideo;
import com.bapis.bilibili.app.home.v1.KMineSelection;
import com.bapis.bilibili.app.home.v1.KRecentFav;
import com.bapis.bilibili.app.home.v1.KRecentRes;
import com.bapis.bilibili.app.home.v1.KRecentUsed;
import com.bapis.bilibili.app.home.v1.KToView;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecentPageState.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0004\u0018\u0001`\r\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0004\u0018\u0001`\r\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u0011¢\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0012\u0010\u0016J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0017\u00100\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0004\u0018\u0001`\rHÆ\u0003J\u0017\u00101\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0004\u0018\u0001`\rHÆ\u0003J\u0017\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u0011HÆ\u0003J}\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0004\u0018\u0001`\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0004\u0018\u0001`\r2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u0011HÆ\u0001J\u0013\u00104\u001a\u00020$2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0004\u0018\u0001`\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0004\u0018\u0001`\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u001f\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001f\u0010'\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020)0\u000b0(¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u00069"}, d2 = {"Lhome/sidecenter/recent/RecentPageState;", "", "pageStatus", "Lhome/sidecenter/recent/RecentPageStatus;", "toast", "", "mineSelection", "Lhome/sidecenter/recent/MineSelection;", "recentUsed", "Lhome/sidecenter/recent/RecentUsed;", "recentVideo", "Lhome/sidecenter/recent/RecentModule;", "Lhome/sidecenter/recent/RecentVideoContent;", "Lhome/sidecenter/recent/RecentVideo;", "toView", "recentFav", "Lhome/sidecenter/recent/RecentFavContent;", "Lhome/sidecenter/recent/RecentFav;", "<init>", "(Lhome/sidecenter/recent/RecentPageStatus;Ljava/lang/String;Lhome/sidecenter/recent/MineSelection;Lhome/sidecenter/recent/RecentUsed;Lhome/sidecenter/recent/RecentModule;Lhome/sidecenter/recent/RecentModule;Lhome/sidecenter/recent/RecentModule;)V", "resp", "Lcom/bapis/bilibili/app/home/v1/KRecentRes;", "(Lcom/bapis/bilibili/app/home/v1/KRecentRes;)V", "getPageStatus", "()Lhome/sidecenter/recent/RecentPageStatus;", "getToast", "()Ljava/lang/String;", "getMineSelection", "()Lhome/sidecenter/recent/MineSelection;", "getRecentUsed", "()Lhome/sidecenter/recent/RecentUsed;", "getRecentVideo", "()Lhome/sidecenter/recent/RecentModule;", "getToView", "getRecentFav", "hasRecentContent", "", "getHasRecentContent", "()Z", "orderedModule", "", "Lhome/sidecenter/recent/RecentContent;", "getOrderedModule", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentPageState {
    public static final int $stable = 8;
    private final MineSelection mineSelection;
    private final List<RecentModule<? extends RecentContent>> orderedModule;
    private final RecentPageStatus pageStatus;
    private final RecentModule<RecentFavContent> recentFav;
    private final RecentUsed recentUsed;
    private final RecentModule<RecentVideoContent> recentVideo;
    private final RecentModule<RecentVideoContent> toView;
    private final String toast;

    public RecentPageState() {
        this(null, null, null, null, null, null, null, TbsListener.ErrorCode.STARTDOWNLOAD_OUT_OF_MAXTIME, null);
    }

    public static /* synthetic */ RecentPageState copy$default(RecentPageState recentPageState, RecentPageStatus recentPageStatus, String str, MineSelection mineSelection, RecentUsed recentUsed, RecentModule recentModule, RecentModule recentModule2, RecentModule recentModule3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            recentPageStatus = recentPageState.pageStatus;
        }
        if ((i2 & 2) != 0) {
            str = recentPageState.toast;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            mineSelection = recentPageState.mineSelection;
        }
        MineSelection mineSelection2 = mineSelection;
        if ((i2 & 8) != 0) {
            recentUsed = recentPageState.recentUsed;
        }
        RecentUsed recentUsed2 = recentUsed;
        RecentModule<RecentVideoContent> recentModule4 = recentModule;
        if ((i2 & 16) != 0) {
            recentModule4 = recentPageState.recentVideo;
        }
        RecentModule recentModule5 = recentModule4;
        RecentModule<RecentVideoContent> recentModule6 = recentModule2;
        if ((i2 & 32) != 0) {
            recentModule6 = recentPageState.toView;
        }
        RecentModule recentModule7 = recentModule6;
        RecentModule<RecentFavContent> recentModule8 = recentModule3;
        if ((i2 & 64) != 0) {
            recentModule8 = recentPageState.recentFav;
        }
        return recentPageState.copy(recentPageStatus, str2, mineSelection2, recentUsed2, recentModule5, recentModule7, recentModule8);
    }

    public final RecentPageStatus component1() {
        return this.pageStatus;
    }

    public final String component2() {
        return this.toast;
    }

    public final MineSelection component3() {
        return this.mineSelection;
    }

    public final RecentUsed component4() {
        return this.recentUsed;
    }

    public final RecentModule<RecentVideoContent> component5() {
        return this.recentVideo;
    }

    public final RecentModule<RecentVideoContent> component6() {
        return this.toView;
    }

    public final RecentModule<RecentFavContent> component7() {
        return this.recentFav;
    }

    public final RecentPageState copy(RecentPageStatus recentPageStatus, String str, MineSelection mineSelection, RecentUsed recentUsed, RecentModule<RecentVideoContent> recentModule, RecentModule<RecentVideoContent> recentModule2, RecentModule<RecentFavContent> recentModule3) {
        Intrinsics.checkNotNullParameter(recentPageStatus, "pageStatus");
        Intrinsics.checkNotNullParameter(str, "toast");
        return new RecentPageState(recentPageStatus, str, mineSelection, recentUsed, recentModule, recentModule2, recentModule3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RecentPageState) {
            RecentPageState recentPageState = (RecentPageState) obj;
            return this.pageStatus == recentPageState.pageStatus && Intrinsics.areEqual(this.toast, recentPageState.toast) && Intrinsics.areEqual(this.mineSelection, recentPageState.mineSelection) && Intrinsics.areEqual(this.recentUsed, recentPageState.recentUsed) && Intrinsics.areEqual(this.recentVideo, recentPageState.recentVideo) && Intrinsics.areEqual(this.toView, recentPageState.toView) && Intrinsics.areEqual(this.recentFav, recentPageState.recentFav);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.pageStatus.hashCode() * 31) + this.toast.hashCode()) * 31) + (this.mineSelection == null ? 0 : this.mineSelection.hashCode())) * 31) + (this.recentUsed == null ? 0 : this.recentUsed.hashCode())) * 31) + (this.recentVideo == null ? 0 : this.recentVideo.hashCode())) * 31) + (this.toView == null ? 0 : this.toView.hashCode())) * 31) + (this.recentFav != null ? this.recentFav.hashCode() : 0);
    }

    public String toString() {
        RecentPageStatus recentPageStatus = this.pageStatus;
        String str = this.toast;
        MineSelection mineSelection = this.mineSelection;
        RecentUsed recentUsed = this.recentUsed;
        RecentModule<RecentVideoContent> recentModule = this.recentVideo;
        RecentModule<RecentVideoContent> recentModule2 = this.toView;
        return "RecentPageState(pageStatus=" + recentPageStatus + ", toast=" + str + ", mineSelection=" + mineSelection + ", recentUsed=" + recentUsed + ", recentVideo=" + recentModule + ", toView=" + recentModule2 + ", recentFav=" + this.recentFav + ")";
    }

    public RecentPageState(RecentPageStatus pageStatus, String toast, MineSelection mineSelection, RecentUsed recentUsed, RecentModule<RecentVideoContent> recentModule, RecentModule<RecentVideoContent> recentModule2, RecentModule<RecentFavContent> recentModule3) {
        Intrinsics.checkNotNullParameter(pageStatus, "pageStatus");
        Intrinsics.checkNotNullParameter(toast, "toast");
        this.pageStatus = pageStatus;
        this.toast = toast;
        this.mineSelection = mineSelection;
        this.recentUsed = recentUsed;
        this.recentVideo = recentModule;
        this.toView = recentModule2;
        this.recentFav = recentModule3;
        Iterable $this$sortedBy$iv = CollectionsKt.listOfNotNull(new RecentModule[]{this.recentVideo, this.toView, this.recentFav});
        this.orderedModule = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: home.sidecenter.recent.RecentPageState$special$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                RecentModule it = (RecentModule) t;
                RecentModuleInfo info = it.getInfo();
                Integer valueOf = Integer.valueOf(info != null ? info.getPos() : 0);
                RecentModule it2 = (RecentModule) t2;
                RecentModuleInfo info2 = it2.getInfo();
                return ComparisonsKt.compareValues(valueOf, Integer.valueOf(info2 != null ? info2.getPos() : 0));
            }
        });
    }

    public /* synthetic */ RecentPageState(RecentPageStatus recentPageStatus, String str, MineSelection mineSelection, RecentUsed recentUsed, RecentModule recentModule, RecentModule recentModule2, RecentModule recentModule3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? RecentPageStatus.Idle : recentPageStatus, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? null : mineSelection, (i2 & 8) != 0 ? null : recentUsed, (i2 & 16) != 0 ? null : recentModule, (i2 & 32) != 0 ? null : recentModule2, (i2 & 64) == 0 ? recentModule3 : null);
    }

    public final RecentPageStatus getPageStatus() {
        return this.pageStatus;
    }

    public final String getToast() {
        return this.toast;
    }

    public final MineSelection getMineSelection() {
        return this.mineSelection;
    }

    public final RecentUsed getRecentUsed() {
        return this.recentUsed;
    }

    public final RecentModule<RecentVideoContent> getRecentVideo() {
        return this.recentVideo;
    }

    public final RecentModule<RecentVideoContent> getToView() {
        return this.toView;
    }

    public final RecentModule<RecentFavContent> getRecentFav() {
        return this.recentFav;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RecentPageState(KRecentRes resp) {
        this(r2, null, r4, r5, r6, r7, it != null ? ContentKt.RecentFav(it) : null, 2, null);
        Intrinsics.checkNotNullParameter(resp, "resp");
        RecentPageStatus recentPageStatus = RecentPageStatus.Success;
        KMineSelection it = resp.getMineSelection();
        MineSelection mineSelection = it != null ? new MineSelection(it) : null;
        KRecentUsed it2 = resp.getRecentUsed();
        RecentUsed recentUsed = it2 != null ? new RecentUsed(it2) : null;
        KHalfWatchedVideo it3 = resp.getHalfWatchedVideos();
        RecentModule<RecentVideoContent> RecentVideo = it3 != null ? ContentKt.RecentVideo(it3) : null;
        KToView it4 = resp.getToView();
        RecentModule<RecentVideoContent> RecentToView = it4 != null ? ContentKt.RecentToView(it4) : null;
        KRecentFav it5 = resp.getRecentFav();
    }

    public final boolean getHasRecentContent() {
        boolean z;
        Iterable $this$any$iv = this.orderedModule;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            RecentModule it = (RecentModule) element$iv;
            RecentContentPool content = it.getContent();
            if (content != null) {
                z = content.hasValidContent();
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final List<RecentModule<? extends RecentContent>> getOrderedModule() {
        return this.orderedModule;
    }
}