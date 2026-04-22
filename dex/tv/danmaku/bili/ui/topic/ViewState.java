package tv.danmaku.bili.ui.topic;

import BottomSheetItemData$;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.topic.api.BiliTopic;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: TopicViewModel.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/ui/topic/ViewState;", "", "isLoading", "", "isFirstPage", "data", "", "Ltv/danmaku/bili/ui/topic/api/BiliTopic;", "error", "", "<init>", "(ZZLjava/util/List;Ljava/lang/Throwable;)V", "()Z", "getData", "()Ljava/util/List;", "getError", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "topic_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ViewState {
    private final List<BiliTopic> data;
    private final Throwable error;
    private final boolean isFirstPage;
    private final boolean isLoading;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z, boolean z2, List list, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            z = viewState.isLoading;
        }
        if ((i & 2) != 0) {
            z2 = viewState.isFirstPage;
        }
        if ((i & 4) != 0) {
            list = viewState.data;
        }
        if ((i & 8) != 0) {
            th = viewState.error;
        }
        return viewState.copy(z, z2, list, th);
    }

    public final boolean component1() {
        return this.isLoading;
    }

    public final boolean component2() {
        return this.isFirstPage;
    }

    public final List<BiliTopic> component3() {
        return this.data;
    }

    public final Throwable component4() {
        return this.error;
    }

    public final ViewState copy(boolean z, boolean z2, List<BiliTopic> list, Throwable th) {
        Intrinsics.checkNotNullParameter(list, "data");
        return new ViewState(z, z2, list, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ViewState) {
            ViewState viewState = (ViewState) obj;
            return this.isLoading == viewState.isLoading && this.isFirstPage == viewState.isFirstPage && Intrinsics.areEqual(this.data, viewState.data) && Intrinsics.areEqual(this.error, viewState.error);
        }
        return false;
    }

    public int hashCode() {
        return (((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLoading) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isFirstPage)) * 31) + this.data.hashCode()) * 31) + (this.error == null ? 0 : this.error.hashCode());
    }

    public String toString() {
        boolean z = this.isLoading;
        boolean z2 = this.isFirstPage;
        List<BiliTopic> list = this.data;
        return "ViewState(isLoading=" + z + ", isFirstPage=" + z2 + ", data=" + list + ", error=" + this.error + ")";
    }

    public ViewState(boolean isLoading, boolean isFirstPage, List<BiliTopic> list, Throwable error) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.isLoading = isLoading;
        this.isFirstPage = isFirstPage;
        this.data = list;
        this.error = error;
    }

    public /* synthetic */ ViewState(boolean z, boolean z2, List list, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? null : th);
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final boolean isFirstPage() {
        return this.isFirstPage;
    }

    public final List<BiliTopic> getData() {
        return this.data;
    }

    public final Throwable getError() {
        return this.error;
    }
}