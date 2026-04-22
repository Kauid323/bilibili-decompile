package kntr.app.live.room.interactiongame;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RoomInteractionGameGuideStore.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/live/room/interactiongame/GuideLayoutInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "type", "Lkntr/app/live/room/interactiongame/GuideLayoutType;", "<init>", "(Lkntr/app/live/room/interactiongame/GuideLayoutType;)V", "getType", "()Lkntr/app/live/room/interactiongame/GuideLayoutType;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "interactiongame_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GuideLayoutInfo {
    private final GuideLayoutType type;

    public GuideLayoutInfo() {
        this(null, 1, null);
    }

    public static /* synthetic */ GuideLayoutInfo copy$default(GuideLayoutInfo guideLayoutInfo, GuideLayoutType guideLayoutType, int i, Object obj) {
        if ((i & 1) != 0) {
            guideLayoutType = guideLayoutInfo.type;
        }
        return guideLayoutInfo.copy(guideLayoutType);
    }

    public final GuideLayoutType component1() {
        return this.type;
    }

    public final GuideLayoutInfo copy(GuideLayoutType guideLayoutType) {
        Intrinsics.checkNotNullParameter(guideLayoutType, "type");
        return new GuideLayoutInfo(guideLayoutType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GuideLayoutInfo) && this.type == ((GuideLayoutInfo) obj).type;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public String toString() {
        return "GuideLayoutInfo(type=" + this.type + ")";
    }

    public GuideLayoutInfo(GuideLayoutType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
    }

    public /* synthetic */ GuideLayoutInfo(GuideLayoutType guideLayoutType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? GuideLayoutType.Bottom : guideLayoutType);
    }

    public final GuideLayoutType getType() {
        return this.type;
    }
}