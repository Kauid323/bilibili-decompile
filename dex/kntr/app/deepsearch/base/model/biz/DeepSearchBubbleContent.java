package kntr.app.deepsearch.base.model.biz;

import com.bilibili.blens.Lens;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchBubbleContent.kt */
@Lens
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchBubbleContent;", RoomRecommendViewModel.EMPTY_CURSOR, "idModel", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItemIdentifier;", "rangeString", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItemIdentifier;Ljava/lang/String;)V", "getIdModel", "()Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItemIdentifier;", "getRangeString", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchBubbleContent {
    public static final Companion Companion = new Companion(null);
    private final DeepSearchDataItemIdentifier idModel;
    private final String rangeString;

    public static /* synthetic */ DeepSearchBubbleContent copy$default(DeepSearchBubbleContent deepSearchBubbleContent, DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            deepSearchDataItemIdentifier = deepSearchBubbleContent.idModel;
        }
        if ((i & 2) != 0) {
            str = deepSearchBubbleContent.rangeString;
        }
        return deepSearchBubbleContent.copy(deepSearchDataItemIdentifier, str);
    }

    public final DeepSearchDataItemIdentifier component1() {
        return this.idModel;
    }

    public final String component2() {
        return this.rangeString;
    }

    public final DeepSearchBubbleContent copy(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, String str) {
        Intrinsics.checkNotNullParameter(deepSearchDataItemIdentifier, "idModel");
        Intrinsics.checkNotNullParameter(str, "rangeString");
        return new DeepSearchBubbleContent(deepSearchDataItemIdentifier, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeepSearchBubbleContent) {
            DeepSearchBubbleContent deepSearchBubbleContent = (DeepSearchBubbleContent) obj;
            return Intrinsics.areEqual(this.idModel, deepSearchBubbleContent.idModel) && Intrinsics.areEqual(this.rangeString, deepSearchBubbleContent.rangeString);
        }
        return false;
    }

    public int hashCode() {
        return (this.idModel.hashCode() * 31) + this.rangeString.hashCode();
    }

    public String toString() {
        DeepSearchDataItemIdentifier deepSearchDataItemIdentifier = this.idModel;
        return "DeepSearchBubbleContent(idModel=" + deepSearchDataItemIdentifier + ", rangeString=" + this.rangeString + ")";
    }

    public DeepSearchBubbleContent(DeepSearchDataItemIdentifier idModel, String rangeString) {
        Intrinsics.checkNotNullParameter(idModel, "idModel");
        Intrinsics.checkNotNullParameter(rangeString, "rangeString");
        this.idModel = idModel;
        this.rangeString = rangeString;
    }

    public final DeepSearchDataItemIdentifier getIdModel() {
        return this.idModel;
    }

    public final String getRangeString() {
        return this.rangeString;
    }

    /* compiled from: DeepSearchBubbleContent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchBubbleContent$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}