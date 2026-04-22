package kntr.app.deepsearch.base.model.biz;

import BottomSheetItemData$;
import androidx.collection.DoubleList$;
import com.bilibili.blens.Lens;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchPageData.kt */
@Lens
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 22\u00020\u0001:\u00012Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\t\u0010(\u001a\u00020\rHÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\t\u0010*\u001a\u00020\u0010HÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003Jm\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001J\u0013\u0010-\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0011\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001b¨\u00063"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItem;", RoomRecommendViewModel.EMPTY_CURSOR, "idModel", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItemIdentifier;", "embed", RoomRecommendViewModel.EMPTY_CURSOR, "isFirst", "isLast", "cardType", "Lkntr/app/deepsearch/base/model/biz/CardType;", "containerWidth", RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", "content", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent;", "height", "<init>", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItemIdentifier;ZZZLkntr/app/deepsearch/base/model/biz/CardType;DLjava/lang/String;Ljava/lang/String;Lkntr/app/deepsearch/base/model/biz/DeepSearchContent;D)V", "getIdModel", "()Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItemIdentifier;", "getEmbed", "()Z", "getCardType", "()Lkntr/app/deepsearch/base/model/biz/CardType;", "getContainerWidth", "()D", "getSessionId", "()Ljava/lang/String;", "getQueryId", "getContent", "()Lkntr/app/deepsearch/base/model/biz/DeepSearchContent;", "getHeight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchDataItem {
    public static final Companion Companion = new Companion(null);
    private final CardType cardType;
    private final double containerWidth;
    private final DeepSearchContent content;
    private final boolean embed;
    private final double height;
    private final DeepSearchDataItemIdentifier idModel;
    private final boolean isFirst;
    private final boolean isLast;
    private final String queryId;
    private final String sessionId;

    public final DeepSearchDataItemIdentifier component1() {
        return this.idModel;
    }

    public final double component10() {
        return this.height;
    }

    public final boolean component2() {
        return this.embed;
    }

    public final boolean component3() {
        return this.isFirst;
    }

    public final boolean component4() {
        return this.isLast;
    }

    public final CardType component5() {
        return this.cardType;
    }

    public final double component6() {
        return this.containerWidth;
    }

    public final String component7() {
        return this.sessionId;
    }

    public final String component8() {
        return this.queryId;
    }

    public final DeepSearchContent component9() {
        return this.content;
    }

    public final DeepSearchDataItem copy(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, boolean z, boolean z2, boolean z3, CardType cardType, double d, String str, String str2, DeepSearchContent deepSearchContent, double d2) {
        Intrinsics.checkNotNullParameter(deepSearchDataItemIdentifier, "idModel");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(str2, "queryId");
        Intrinsics.checkNotNullParameter(deepSearchContent, "content");
        return new DeepSearchDataItem(deepSearchDataItemIdentifier, z, z2, z3, cardType, d, str, str2, deepSearchContent, d2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeepSearchDataItem) {
            DeepSearchDataItem deepSearchDataItem = (DeepSearchDataItem) obj;
            return Intrinsics.areEqual(this.idModel, deepSearchDataItem.idModel) && this.embed == deepSearchDataItem.embed && this.isFirst == deepSearchDataItem.isFirst && this.isLast == deepSearchDataItem.isLast && this.cardType == deepSearchDataItem.cardType && Double.compare(this.containerWidth, deepSearchDataItem.containerWidth) == 0 && Intrinsics.areEqual(this.sessionId, deepSearchDataItem.sessionId) && Intrinsics.areEqual(this.queryId, deepSearchDataItem.queryId) && Intrinsics.areEqual(this.content, deepSearchDataItem.content) && Double.compare(this.height, deepSearchDataItem.height) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((this.idModel.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.embed)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isFirst)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLast)) * 31) + this.cardType.hashCode()) * 31) + DoubleList$.ExternalSyntheticBackport0.m(this.containerWidth)) * 31) + this.sessionId.hashCode()) * 31) + this.queryId.hashCode()) * 31) + this.content.hashCode()) * 31) + DoubleList$.ExternalSyntheticBackport0.m(this.height);
    }

    public String toString() {
        DeepSearchDataItemIdentifier deepSearchDataItemIdentifier = this.idModel;
        boolean z = this.embed;
        boolean z2 = this.isFirst;
        boolean z3 = this.isLast;
        CardType cardType = this.cardType;
        double d = this.containerWidth;
        String str = this.sessionId;
        String str2 = this.queryId;
        DeepSearchContent deepSearchContent = this.content;
        return "DeepSearchDataItem(idModel=" + deepSearchDataItemIdentifier + ", embed=" + z + ", isFirst=" + z2 + ", isLast=" + z3 + ", cardType=" + cardType + ", containerWidth=" + d + ", sessionId=" + str + ", queryId=" + str2 + ", content=" + deepSearchContent + ", height=" + this.height + ")";
    }

    public DeepSearchDataItem(DeepSearchDataItemIdentifier idModel, boolean embed, boolean isFirst, boolean isLast, CardType cardType, double containerWidth, String sessionId, String queryId, DeepSearchContent content, double height) {
        Intrinsics.checkNotNullParameter(idModel, "idModel");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(queryId, "queryId");
        Intrinsics.checkNotNullParameter(content, "content");
        this.idModel = idModel;
        this.embed = embed;
        this.isFirst = isFirst;
        this.isLast = isLast;
        this.cardType = cardType;
        this.containerWidth = containerWidth;
        this.sessionId = sessionId;
        this.queryId = queryId;
        this.content = content;
        this.height = height;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ DeepSearchDataItem(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, boolean z, boolean z2, boolean z3, CardType cardType, double d, String str, String str2, DeepSearchContent deepSearchContent, double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r14, r15, r16, r17, cardType, r1, (i & 64) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 128) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, deepSearchContent, (i & 512) != 0 ? DeepSearchPageData_androidKt.calHeight(cardType, r1, deepSearchContent) : d2);
        DeepSearchDataItemIdentifier deepSearchDataItemIdentifier2 = (i & 1) != 0 ? new DeepSearchDataItemIdentifier(null, null, null, null, false, 0, 0, 0, 255, null) : deepSearchDataItemIdentifier;
        boolean z4 = (i & 2) != 0 ? false : z;
        boolean z5 = (i & 4) != 0 ? false : z2;
        boolean z6 = (i & 8) != 0 ? false : z3;
        double d3 = (i & 32) != 0 ? 0.0d : d;
    }

    public final DeepSearchDataItemIdentifier getIdModel() {
        return this.idModel;
    }

    public final boolean getEmbed() {
        return this.embed;
    }

    public final boolean isFirst() {
        return this.isFirst;
    }

    public final boolean isLast() {
        return this.isLast;
    }

    public final CardType getCardType() {
        return this.cardType;
    }

    public final double getContainerWidth() {
        return this.containerWidth;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getQueryId() {
        return this.queryId;
    }

    public final DeepSearchContent getContent() {
        return this.content;
    }

    public final double getHeight() {
        return this.height;
    }

    /* compiled from: DeepSearchPageData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItem$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}