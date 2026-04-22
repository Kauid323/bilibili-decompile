package video.biz.offline.base.facade.model;

import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: PanelStateModel.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\u000fH\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lvideo/biz/offline/base/facade/model/PanelStateModel;", "", "videoId", "", "pageId", "state", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State;", "<init>", "(JJLvideo/biz/offline/base/model/entity/OfflineVideoEntity$State;)V", "getVideoId", "()J", "getPageId", "getState", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State;", "isCompleted", "", "isError", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "facade_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PanelStateModel {
    public static final int $stable = OfflineVideoEntity.State.$stable;
    private final long pageId;
    private final OfflineVideoEntity.State state;
    private final long videoId;

    public static /* synthetic */ PanelStateModel copy$default(PanelStateModel panelStateModel, long j, long j2, OfflineVideoEntity.State state, int i, Object obj) {
        if ((i & 1) != 0) {
            j = panelStateModel.videoId;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = panelStateModel.pageId;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            state = panelStateModel.state;
        }
        return panelStateModel.copy(j3, j4, state);
    }

    public final long component1() {
        return this.videoId;
    }

    public final long component2() {
        return this.pageId;
    }

    public final OfflineVideoEntity.State component3() {
        return this.state;
    }

    public final PanelStateModel copy(long j, long j2, OfflineVideoEntity.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return new PanelStateModel(j, j2, state);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PanelStateModel) {
            PanelStateModel panelStateModel = (PanelStateModel) obj;
            return this.videoId == panelStateModel.videoId && this.pageId == panelStateModel.pageId && Intrinsics.areEqual(this.state, panelStateModel.state);
        }
        return false;
    }

    public int hashCode() {
        return (((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.videoId) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.pageId)) * 31) + this.state.hashCode();
    }

    public String toString() {
        long j = this.videoId;
        long j2 = this.pageId;
        return "PanelStateModel(videoId=" + j + ", pageId=" + j2 + ", state=" + this.state + ")";
    }

    public PanelStateModel(long videoId, long pageId, OfflineVideoEntity.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.videoId = videoId;
        this.pageId = pageId;
        this.state = state;
    }

    public final long getVideoId() {
        return this.videoId;
    }

    public final long getPageId() {
        return this.pageId;
    }

    public final OfflineVideoEntity.State getState() {
        return this.state;
    }

    public final boolean isCompleted() {
        return this.state instanceof OfflineVideoEntity.State.COMPLETED;
    }

    public final boolean isError() {
        return this.state instanceof OfflineVideoEntity.State.ERROR;
    }
}