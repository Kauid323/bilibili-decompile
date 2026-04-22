package kntr.app.digital.preview.card;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import java.util.Map;
import kntr.app.digital.preview.action.Action;
import kntr.app.digital.preview.api.CardData;
import kntr.app.digital.preview.api.DescTag;
import kntr.app.digital.preview.api.TopText;
import kntr.app.digital.preview.button.DigitalButton;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CardBasic.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001:\u0002PQBË\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u000eHÆ\u0003J\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J\t\u0010D\u001a\u00020\u0013HÆ\u0003J\u0015\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0015HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u0015\u0010H\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b\u0018\u00010\u0010HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u001dHÆ\u0003JÛ\u0001\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b\u0018\u00010\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÆ\u0001J\u0013\u0010K\u001a\u00020\u00052\b\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010M\u001a\u00020NHÖ\u0001J\t\u0010O\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0015¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u001d\u0010\u001a\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b6\u0010-R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u0006R"}, d2 = {"Lkntr/app/digital/preview/card/CardBasic;", RoomRecommendViewModel.EMPTY_CURSOR, "uniqueId", RoomRecommendViewModel.EMPTY_CURSOR, "isSelected", RoomRecommendViewModel.EMPTY_CURSOR, "cardName", "frameImg", "image", "leftTopTagImg", "baseShowing", "featurePanelShowing", "hasMask", "rarity", "Lkntr/app/digital/preview/card/CardBasic$Rarity;", "buttons", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/button/DigitalButton;", "cardIdInfo", "Lkntr/app/digital/preview/card/CardBasic$CardIdInfo;", "reportParams", RoomRecommendViewModel.EMPTY_CURSOR, "topText", "Lkntr/app/digital/preview/api/TopText;", "descTag", "Lkntr/app/digital/preview/api/DescTag;", "topBarActions", "Lkntr/app/digital/preview/action/Action;", "cardLockStatus", "Lkntr/app/digital/preview/api/CardData$Data$CardLockStatus;", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLkntr/app/digital/preview/card/CardBasic$Rarity;Ljava/util/List;Lkntr/app/digital/preview/card/CardBasic$CardIdInfo;Ljava/util/Map;Lkntr/app/digital/preview/api/TopText;Lkntr/app/digital/preview/api/DescTag;Ljava/util/List;Lkntr/app/digital/preview/api/CardData$Data$CardLockStatus;)V", "getUniqueId", "()Ljava/lang/String;", "()Z", "getCardName", "getFrameImg", "getImage", "getLeftTopTagImg", "getBaseShowing", "getFeaturePanelShowing", "getHasMask", "getRarity", "()Lkntr/app/digital/preview/card/CardBasic$Rarity;", "getButtons", "()Ljava/util/List;", "getCardIdInfo", "()Lkntr/app/digital/preview/card/CardBasic$CardIdInfo;", "getReportParams", "()Ljava/util/Map;", "getTopText", "()Lkntr/app/digital/preview/api/TopText;", "getDescTag", "()Lkntr/app/digital/preview/api/DescTag;", "getTopBarActions", "getCardLockStatus", "()Lkntr/app/digital/preview/api/CardData$Data$CardLockStatus;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "CardIdInfo", "Rarity", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardBasic {
    public static final int $stable = 8;
    private final boolean baseShowing;
    private final List<DigitalButton> buttons;
    private final CardIdInfo cardIdInfo;
    private final CardData.Data.CardLockStatus cardLockStatus;
    private final String cardName;
    private final DescTag descTag;
    private final boolean featurePanelShowing;
    private final String frameImg;
    private final boolean hasMask;
    private final String image;
    private final boolean isSelected;
    private final String leftTopTagImg;
    private final Rarity rarity;
    private final Map<String, String> reportParams;
    private final List<Action<?>> topBarActions;
    private final TopText topText;
    private final String uniqueId;

    public final String component1() {
        return this.uniqueId;
    }

    public final Rarity component10() {
        return this.rarity;
    }

    public final List<DigitalButton> component11() {
        return this.buttons;
    }

    public final CardIdInfo component12() {
        return this.cardIdInfo;
    }

    public final Map<String, String> component13() {
        return this.reportParams;
    }

    public final TopText component14() {
        return this.topText;
    }

    public final DescTag component15() {
        return this.descTag;
    }

    public final List<Action<?>> component16() {
        return this.topBarActions;
    }

    public final CardData.Data.CardLockStatus component17() {
        return this.cardLockStatus;
    }

    public final boolean component2() {
        return this.isSelected;
    }

    public final String component3() {
        return this.cardName;
    }

    public final String component4() {
        return this.frameImg;
    }

    public final String component5() {
        return this.image;
    }

    public final String component6() {
        return this.leftTopTagImg;
    }

    public final boolean component7() {
        return this.baseShowing;
    }

    public final boolean component8() {
        return this.featurePanelShowing;
    }

    public final boolean component9() {
        return this.hasMask;
    }

    public final CardBasic copy(String str, boolean z, String str2, String str3, String str4, String str5, boolean z2, boolean z3, boolean z4, Rarity rarity, List<DigitalButton> list, CardIdInfo cardIdInfo, Map<String, String> map, TopText topText, DescTag descTag, List<? extends Action<?>> list2, CardData.Data.CardLockStatus cardLockStatus) {
        Intrinsics.checkNotNullParameter(str, "uniqueId");
        Intrinsics.checkNotNullParameter(str2, "cardName");
        Intrinsics.checkNotNullParameter(str4, "image");
        Intrinsics.checkNotNullParameter(rarity, "rarity");
        Intrinsics.checkNotNullParameter(list, "buttons");
        Intrinsics.checkNotNullParameter(cardIdInfo, "cardIdInfo");
        Intrinsics.checkNotNullParameter(map, "reportParams");
        return new CardBasic(str, z, str2, str3, str4, str5, z2, z3, z4, rarity, list, cardIdInfo, map, topText, descTag, list2, cardLockStatus);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CardBasic) {
            CardBasic cardBasic = (CardBasic) obj;
            return Intrinsics.areEqual(this.uniqueId, cardBasic.uniqueId) && this.isSelected == cardBasic.isSelected && Intrinsics.areEqual(this.cardName, cardBasic.cardName) && Intrinsics.areEqual(this.frameImg, cardBasic.frameImg) && Intrinsics.areEqual(this.image, cardBasic.image) && Intrinsics.areEqual(this.leftTopTagImg, cardBasic.leftTopTagImg) && this.baseShowing == cardBasic.baseShowing && this.featurePanelShowing == cardBasic.featurePanelShowing && this.hasMask == cardBasic.hasMask && Intrinsics.areEqual(this.rarity, cardBasic.rarity) && Intrinsics.areEqual(this.buttons, cardBasic.buttons) && Intrinsics.areEqual(this.cardIdInfo, cardBasic.cardIdInfo) && Intrinsics.areEqual(this.reportParams, cardBasic.reportParams) && Intrinsics.areEqual(this.topText, cardBasic.topText) && Intrinsics.areEqual(this.descTag, cardBasic.descTag) && Intrinsics.areEqual(this.topBarActions, cardBasic.topBarActions) && this.cardLockStatus == cardBasic.cardLockStatus;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.uniqueId.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isSelected)) * 31) + this.cardName.hashCode()) * 31) + (this.frameImg == null ? 0 : this.frameImg.hashCode())) * 31) + this.image.hashCode()) * 31) + (this.leftTopTagImg == null ? 0 : this.leftTopTagImg.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.baseShowing)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.featurePanelShowing)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasMask)) * 31) + this.rarity.hashCode()) * 31) + this.buttons.hashCode()) * 31) + this.cardIdInfo.hashCode()) * 31) + this.reportParams.hashCode()) * 31) + (this.topText == null ? 0 : this.topText.hashCode())) * 31) + (this.descTag == null ? 0 : this.descTag.hashCode())) * 31) + (this.topBarActions == null ? 0 : this.topBarActions.hashCode())) * 31) + (this.cardLockStatus != null ? this.cardLockStatus.hashCode() : 0);
    }

    public String toString() {
        String str = this.uniqueId;
        boolean z = this.isSelected;
        String str2 = this.cardName;
        String str3 = this.frameImg;
        String str4 = this.image;
        String str5 = this.leftTopTagImg;
        boolean z2 = this.baseShowing;
        boolean z3 = this.featurePanelShowing;
        boolean z4 = this.hasMask;
        Rarity rarity = this.rarity;
        List<DigitalButton> list = this.buttons;
        CardIdInfo cardIdInfo = this.cardIdInfo;
        Map<String, String> map = this.reportParams;
        TopText topText = this.topText;
        DescTag descTag = this.descTag;
        List<Action<?>> list2 = this.topBarActions;
        return "CardBasic(uniqueId=" + str + ", isSelected=" + z + ", cardName=" + str2 + ", frameImg=" + str3 + ", image=" + str4 + ", leftTopTagImg=" + str5 + ", baseShowing=" + z2 + ", featurePanelShowing=" + z3 + ", hasMask=" + z4 + ", rarity=" + rarity + ", buttons=" + list + ", cardIdInfo=" + cardIdInfo + ", reportParams=" + map + ", topText=" + topText + ", descTag=" + descTag + ", topBarActions=" + list2 + ", cardLockStatus=" + this.cardLockStatus + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CardBasic(String uniqueId, boolean isSelected, String cardName, String frameImg, String image, String leftTopTagImg, boolean baseShowing, boolean featurePanelShowing, boolean hasMask, Rarity rarity, List<DigitalButton> list, CardIdInfo cardIdInfo, Map<String, String> map, TopText topText, DescTag descTag, List<? extends Action<?>> list2, CardData.Data.CardLockStatus cardLockStatus) {
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(cardName, "cardName");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(rarity, "rarity");
        Intrinsics.checkNotNullParameter(list, "buttons");
        Intrinsics.checkNotNullParameter(cardIdInfo, "cardIdInfo");
        Intrinsics.checkNotNullParameter(map, "reportParams");
        this.uniqueId = uniqueId;
        this.isSelected = isSelected;
        this.cardName = cardName;
        this.frameImg = frameImg;
        this.image = image;
        this.leftTopTagImg = leftTopTagImg;
        this.baseShowing = baseShowing;
        this.featurePanelShowing = featurePanelShowing;
        this.hasMask = hasMask;
        this.rarity = rarity;
        this.buttons = list;
        this.cardIdInfo = cardIdInfo;
        this.reportParams = map;
        this.topText = topText;
        this.descTag = descTag;
        this.topBarActions = list2;
        this.cardLockStatus = cardLockStatus;
    }

    public /* synthetic */ CardBasic(String str, boolean z, String str2, String str3, String str4, String str5, boolean z2, boolean z3, boolean z4, Rarity rarity, List list, CardIdInfo cardIdInfo, Map map, TopText topText, DescTag descTag, List list2, CardData.Data.CardLockStatus cardLockStatus, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, str2, (i & 8) != 0 ? null : str3, str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? false : z2, (i & 128) != 0 ? false : z3, (i & 256) != 0 ? false : z4, rarity, list, cardIdInfo, (i & 4096) != 0 ? MapsKt.emptyMap() : map, (i & 8192) != 0 ? null : topText, (i & 16384) != 0 ? null : descTag, (32768 & i) != 0 ? null : list2, (i & 65536) != 0 ? null : cardLockStatus);
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final String getCardName() {
        return this.cardName;
    }

    public final String getFrameImg() {
        return this.frameImg;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getLeftTopTagImg() {
        return this.leftTopTagImg;
    }

    public final boolean getBaseShowing() {
        return this.baseShowing;
    }

    public final boolean getFeaturePanelShowing() {
        return this.featurePanelShowing;
    }

    public final boolean getHasMask() {
        return this.hasMask;
    }

    public final Rarity getRarity() {
        return this.rarity;
    }

    public final List<DigitalButton> getButtons() {
        return this.buttons;
    }

    public final CardIdInfo getCardIdInfo() {
        return this.cardIdInfo;
    }

    public final Map<String, String> getReportParams() {
        return this.reportParams;
    }

    public final TopText getTopText() {
        return this.topText;
    }

    public final DescTag getDescTag() {
        return this.descTag;
    }

    public final List<Action<?>> getTopBarActions() {
        return this.topBarActions;
    }

    public final CardData.Data.CardLockStatus getCardLockStatus() {
        return this.cardLockStatus;
    }

    /* compiled from: CardBasic.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lkntr/app/digital/preview/card/CardBasic$CardIdInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "cardId", RoomRecommendViewModel.EMPTY_CURSOR, "cardTypeId", "cardNo", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(JJLjava/lang/String;)V", "getCardId", "()J", "getCardTypeId", "getCardNo", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CardIdInfo {
        public static final int $stable = 0;
        private final long cardId;
        private final String cardNo;
        private final long cardTypeId;

        public static /* synthetic */ CardIdInfo copy$default(CardIdInfo cardIdInfo, long j2, long j3, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j2 = cardIdInfo.cardId;
            }
            long j4 = j2;
            if ((i & 2) != 0) {
                j3 = cardIdInfo.cardTypeId;
            }
            long j5 = j3;
            if ((i & 4) != 0) {
                str = cardIdInfo.cardNo;
            }
            return cardIdInfo.copy(j4, j5, str);
        }

        public final long component1() {
            return this.cardId;
        }

        public final long component2() {
            return this.cardTypeId;
        }

        public final String component3() {
            return this.cardNo;
        }

        public final CardIdInfo copy(long j2, long j3, String str) {
            Intrinsics.checkNotNullParameter(str, "cardNo");
            return new CardIdInfo(j2, j3, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CardIdInfo) {
                CardIdInfo cardIdInfo = (CardIdInfo) obj;
                return this.cardId == cardIdInfo.cardId && this.cardTypeId == cardIdInfo.cardTypeId && Intrinsics.areEqual(this.cardNo, cardIdInfo.cardNo);
            }
            return false;
        }

        public int hashCode() {
            return (((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cardId) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cardTypeId)) * 31) + this.cardNo.hashCode();
        }

        public String toString() {
            long j2 = this.cardId;
            long j3 = this.cardTypeId;
            return "CardIdInfo(cardId=" + j2 + ", cardTypeId=" + j3 + ", cardNo=" + this.cardNo + ")";
        }

        public CardIdInfo(long cardId, long cardTypeId, String cardNo) {
            Intrinsics.checkNotNullParameter(cardNo, "cardNo");
            this.cardId = cardId;
            this.cardTypeId = cardTypeId;
            this.cardNo = cardNo;
        }

        public final long getCardId() {
            return this.cardId;
        }

        public final long getCardTypeId() {
            return this.cardTypeId;
        }

        public final String getCardNo() {
            return this.cardNo;
        }
    }

    /* compiled from: CardBasic.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lkntr/app/digital/preview/card/CardBasic$Rarity;", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "jumpUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "getJumpUrl", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Rarity {
        public static final int $stable = 0;
        private final String jumpUrl;
        private final String text;

        public static /* synthetic */ Rarity copy$default(Rarity rarity, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = rarity.text;
            }
            if ((i & 2) != 0) {
                str2 = rarity.jumpUrl;
            }
            return rarity.copy(str, str2);
        }

        public final String component1() {
            return this.text;
        }

        public final String component2() {
            return this.jumpUrl;
        }

        public final Rarity copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(str2, "jumpUrl");
            return new Rarity(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Rarity) {
                Rarity rarity = (Rarity) obj;
                return Intrinsics.areEqual(this.text, rarity.text) && Intrinsics.areEqual(this.jumpUrl, rarity.jumpUrl);
            }
            return false;
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + this.jumpUrl.hashCode();
        }

        public String toString() {
            String str = this.text;
            return "Rarity(text=" + str + ", jumpUrl=" + this.jumpUrl + ")";
        }

        public Rarity(String text, String jumpUrl) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
            this.text = text;
            this.jumpUrl = jumpUrl;
        }

        public final String getText() {
            return this.text;
        }

        public final String getJumpUrl() {
            return this.jumpUrl;
        }
    }
}