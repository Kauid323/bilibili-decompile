package kntr.app.live.room.interactiongame;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RoomInteractionGameGuideStore.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lkntr/app/live/room/interactiongame/GuideModel;", RoomRecommendViewModel.EMPTY_CURSOR, "imgName", RoomRecommendViewModel.EMPTY_CURSOR, "layoutInfo", "Lkntr/app/live/room/interactiongame/GuideLayoutInfo;", "<init>", "(Ljava/lang/String;Lkntr/app/live/room/interactiongame/GuideLayoutInfo;)V", "getImgName$annotations", "()V", "getImgName", "()Ljava/lang/String;", "getLayoutInfo", "()Lkntr/app/live/room/interactiongame/GuideLayoutInfo;", "setLayoutInfo", "(Lkntr/app/live/room/interactiongame/GuideLayoutInfo;)V", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "interactiongame_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GuideModel {
    private final String imgName;
    private GuideLayoutInfo layoutInfo;

    public GuideModel() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ GuideModel copy$default(GuideModel guideModel, String str, GuideLayoutInfo guideLayoutInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guideModel.imgName;
        }
        if ((i & 2) != 0) {
            guideLayoutInfo = guideModel.layoutInfo;
        }
        return guideModel.copy(str, guideLayoutInfo);
    }

    public static /* synthetic */ void getImgName$annotations() {
    }

    public final String component1() {
        return this.imgName;
    }

    public final GuideLayoutInfo component2() {
        return this.layoutInfo;
    }

    public final GuideModel copy(String str, GuideLayoutInfo guideLayoutInfo) {
        Intrinsics.checkNotNullParameter(str, "imgName");
        Intrinsics.checkNotNullParameter(guideLayoutInfo, "layoutInfo");
        return new GuideModel(str, guideLayoutInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GuideModel) {
            GuideModel guideModel = (GuideModel) obj;
            return Intrinsics.areEqual(this.imgName, guideModel.imgName) && Intrinsics.areEqual(this.layoutInfo, guideModel.layoutInfo);
        }
        return false;
    }

    public int hashCode() {
        return (this.imgName.hashCode() * 31) + this.layoutInfo.hashCode();
    }

    public String toString() {
        String str = this.imgName;
        return "GuideModel(imgName=" + str + ", layoutInfo=" + this.layoutInfo + ")";
    }

    public GuideModel(String imgName, GuideLayoutInfo layoutInfo) {
        Intrinsics.checkNotNullParameter(imgName, "imgName");
        Intrinsics.checkNotNullParameter(layoutInfo, "layoutInfo");
        this.imgName = imgName;
        this.layoutInfo = layoutInfo;
    }

    public /* synthetic */ GuideModel(String str, GuideLayoutInfo guideLayoutInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? new GuideLayoutInfo(null, 1, null) : guideLayoutInfo);
    }

    public final String getImgName() {
        return this.imgName;
    }

    public final GuideLayoutInfo getLayoutInfo() {
        return this.layoutInfo;
    }

    public final void setLayoutInfo(GuideLayoutInfo guideLayoutInfo) {
        Intrinsics.checkNotNullParameter(guideLayoutInfo, "<set-?>");
        this.layoutInfo = guideLayoutInfo;
    }
}