package kntr.app.im.chat.core.model;

import com.bapis.bilibili.app.dynamic.v2.KParagraph;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushMessageAdditionalInfoHolder.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lkntr/app/im/chat/core/model/PushMessageAdditionalInfoHolder;", RoomRecommendViewModel.EMPTY_CURSOR, "phaseOne", "Lcom/bapis/bilibili/app/dynamic/v2/KParagraph;", "phaseTwo", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KParagraph;Lcom/bapis/bilibili/app/dynamic/v2/KParagraph;)V", "getPhaseOne", "()Lcom/bapis/bilibili/app/dynamic/v2/KParagraph;", "getPhaseTwo", "valid", RoomRecommendViewModel.EMPTY_CURSOR, "getValid", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PushMessageAdditionalInfoHolder {
    public static final int $stable = 8;
    private final KParagraph phaseOne;
    private final KParagraph phaseTwo;

    public static /* synthetic */ PushMessageAdditionalInfoHolder copy$default(PushMessageAdditionalInfoHolder pushMessageAdditionalInfoHolder, KParagraph kParagraph, KParagraph kParagraph2, int i, Object obj) {
        if ((i & 1) != 0) {
            kParagraph = pushMessageAdditionalInfoHolder.phaseOne;
        }
        if ((i & 2) != 0) {
            kParagraph2 = pushMessageAdditionalInfoHolder.phaseTwo;
        }
        return pushMessageAdditionalInfoHolder.copy(kParagraph, kParagraph2);
    }

    public final KParagraph component1() {
        return this.phaseOne;
    }

    public final KParagraph component2() {
        return this.phaseTwo;
    }

    public final PushMessageAdditionalInfoHolder copy(KParagraph kParagraph, KParagraph kParagraph2) {
        return new PushMessageAdditionalInfoHolder(kParagraph, kParagraph2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PushMessageAdditionalInfoHolder) {
            PushMessageAdditionalInfoHolder pushMessageAdditionalInfoHolder = (PushMessageAdditionalInfoHolder) obj;
            return Intrinsics.areEqual(this.phaseOne, pushMessageAdditionalInfoHolder.phaseOne) && Intrinsics.areEqual(this.phaseTwo, pushMessageAdditionalInfoHolder.phaseTwo);
        }
        return false;
    }

    public int hashCode() {
        return ((this.phaseOne == null ? 0 : this.phaseOne.hashCode()) * 31) + (this.phaseTwo != null ? this.phaseTwo.hashCode() : 0);
    }

    public String toString() {
        KParagraph kParagraph = this.phaseOne;
        return "PushMessageAdditionalInfoHolder(phaseOne=" + kParagraph + ", phaseTwo=" + this.phaseTwo + ")";
    }

    public PushMessageAdditionalInfoHolder(KParagraph phaseOne, KParagraph phaseTwo) {
        this.phaseOne = phaseOne;
        this.phaseTwo = phaseTwo;
    }

    public final KParagraph getPhaseOne() {
        return this.phaseOne;
    }

    public final KParagraph getPhaseTwo() {
        return this.phaseTwo;
    }

    public final boolean getValid() {
        return (this.phaseOne == null || this.phaseTwo == null) ? false : true;
    }
}