package kntr.app.live.room.interactiongame;

import BottomSheetItemData$;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RoomInteractionGameGuideStore.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lkntr/app/live/room/interactiongame/LiveRoomInteractionGuideState;", RoomRecommendViewModel.EMPTY_CURSOR, "dismiss", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.MODEL, "Lkntr/app/live/room/interactiongame/GuideModel;", "<init>", "(ZLkntr/app/live/room/interactiongame/GuideModel;)V", "getDismiss", "()Z", "setDismiss", "(Z)V", "getModel", "()Lkntr/app/live/room/interactiongame/GuideModel;", "setModel", "(Lkntr/app/live/room/interactiongame/GuideModel;)V", "component1", "component2", "copy", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "interactiongame_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LiveRoomInteractionGuideState {
    private boolean dismiss;
    private GuideModel model;

    public LiveRoomInteractionGuideState() {
        this(false, null, 3, null);
    }

    public static /* synthetic */ LiveRoomInteractionGuideState copy$default(LiveRoomInteractionGuideState liveRoomInteractionGuideState, boolean z, GuideModel guideModel, int i, Object obj) {
        if ((i & 1) != 0) {
            z = liveRoomInteractionGuideState.dismiss;
        }
        if ((i & 2) != 0) {
            guideModel = liveRoomInteractionGuideState.model;
        }
        return liveRoomInteractionGuideState.copy(z, guideModel);
    }

    public final boolean component1() {
        return this.dismiss;
    }

    public final GuideModel component2() {
        return this.model;
    }

    public final LiveRoomInteractionGuideState copy(boolean z, GuideModel guideModel) {
        Intrinsics.checkNotNullParameter(guideModel, ReportBuildInParam.MODEL);
        return new LiveRoomInteractionGuideState(z, guideModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveRoomInteractionGuideState) {
            LiveRoomInteractionGuideState liveRoomInteractionGuideState = (LiveRoomInteractionGuideState) obj;
            return this.dismiss == liveRoomInteractionGuideState.dismiss && Intrinsics.areEqual(this.model, liveRoomInteractionGuideState.model);
        }
        return false;
    }

    public int hashCode() {
        return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.dismiss) * 31) + this.model.hashCode();
    }

    public String toString() {
        boolean z = this.dismiss;
        return "LiveRoomInteractionGuideState(dismiss=" + z + ", model=" + this.model + ")";
    }

    public LiveRoomInteractionGuideState(boolean dismiss, GuideModel model) {
        Intrinsics.checkNotNullParameter(model, ReportBuildInParam.MODEL);
        this.dismiss = dismiss;
        this.model = model;
    }

    public /* synthetic */ LiveRoomInteractionGuideState(boolean z, GuideModel guideModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? new GuideModel(null, null, 3, null) : guideModel);
    }

    public final boolean getDismiss() {
        return this.dismiss;
    }

    public final void setDismiss(boolean z) {
        this.dismiss = z;
    }

    public final GuideModel getModel() {
        return this.model;
    }

    public final void setModel(GuideModel guideModel) {
        Intrinsics.checkNotNullParameter(guideModel, "<set-?>");
        this.model = guideModel;
    }
}