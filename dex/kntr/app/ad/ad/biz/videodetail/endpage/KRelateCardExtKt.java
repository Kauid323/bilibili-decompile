package kntr.app.ad.ad.biz.videodetail.endpage;

import com.bapis.bilibili.app.viewunite.common.KCardBasicInfo;
import com.bapis.bilibili.app.viewunite.common.KRelateCMLive;
import com.bapis.bilibili.app.viewunite.common.KRelateCard;
import com.bapis.bilibili.app.viewunite.common.KStat;
import com.bapis.bilibili.app.viewunite.common.KStatInfo;
import com.google.protobuf.KAny;
import kntr.app.ad.ad.biz.IAdInfoExtKt;
import kntr.app.ad.ad.biz.videodetail.endpage.VDEndPageUiState;
import kntr.app.ad.common.AdInfoExtKt;
import kntr.app.ad.common.model.AdButton;
import kntr.app.ad.common.model.AdFeedbackPanel;
import kntr.app.ad.common.model.AdRcmdReasonStyle;
import kntr.app.ad.common.model.AdTagStyle;
import kntr.app.ad.common.protocol.IAdInfo;
import kntr.app.ad.common.protocol.IExtraInfo;
import kntr.app.ad.common.protocol.IRenderable;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: KRelateCardExt.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0001H\u0000\u001a\f\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0001¨\u0006\u0007"}, d2 = {"toKRelateCard", "Lcom/bapis/bilibili/app/viewunite/common/KRelateCard;", RoomRecommendViewModel.EMPTY_CURSOR, "asVDEndPageUIContent", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState$Content;", "asIAdInfo", "Lkntr/app/ad/common/protocol/IAdInfo;", "videodetail_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KRelateCardExtKt {
    public static final KRelateCard toKRelateCard(byte[] $this$toKRelateCard) {
        Object obj;
        Intrinsics.checkNotNullParameter($this$toKRelateCard, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            BinaryFormat $this$decodeFromByteArray$iv = ProtoBuf.Default;
            $this$decodeFromByteArray$iv.getSerializersModule();
            obj = Result.constructor-impl((KRelateCard) $this$decodeFromByteArray$iv.decodeFromByteArray(KRelateCard.Companion.serializer(), $this$toKRelateCard));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (KRelateCard) obj;
    }

    public static final VDEndPageUiState.Content asVDEndPageUIContent(KRelateCard $this$asVDEndPageUIContent) {
        KAny sourceContent;
        byte[] value;
        IAdInfo sc;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        KStatInfo danmaku;
        KStatInfo danmaku2;
        KStatInfo statInfo;
        KStatInfo statInfo2;
        KStatInfo vt;
        KStatInfo vt2;
        IRenderable card;
        Intrinsics.checkNotNullParameter($this$asVDEndPageUIContent, "<this>");
        KRelateCard.KCm card2 = $this$asVDEndPageUIContent.getCard();
        if (card2 == null || !(card2 instanceof KRelateCard.KCm) || (sourceContent = card2.getValue().getSourceContent()) == null || (value = sourceContent.getValue()) == null || (sc = AdInfoExtKt.asAdInfo$default(value, false, 1, (Object) null)) == null) {
            return null;
        }
        String firstCoverUrl = IAdInfoExtKt.getFirstCoverUrl(sc);
        String str7 = firstCoverUrl == null ? RoomRecommendViewModel.EMPTY_CURSOR : firstCoverUrl;
        AdTagStyle adTagStyle = IAdInfoExtKt.getAdTagStyle(sc);
        AdTagStyle adTagStyleFullScreen = IAdInfoExtKt.getAdTagStyleFullScreen(sc);
        String title = IAdInfoExtKt.getTitle(sc);
        String str8 = title == null ? RoomRecommendViewModel.EMPTY_CURSOR : title;
        AdButton button = IAdInfoExtKt.getButton(sc);
        AdRcmdReasonStyle rcmdReasonStyle = IAdInfoExtKt.getRcmdReasonStyle(sc);
        String desc = IAdInfoExtKt.getDesc(sc);
        String str9 = desc == null ? RoomRecommendViewModel.EMPTY_CURSOR : desc;
        IExtraInfo extra = sc.getExtra();
        AdFeedbackPanel feedbackPanel = (extra == null || (card = extra.getCard()) == null) ? null : card.getFeedbackPanel();
        KCardBasicInfo basicInfo = $this$asVDEndPageUIContent.getBasicInfo();
        String title2 = basicInfo != null ? basicInfo.getTitle() : null;
        String str10 = title2 == null ? RoomRecommendViewModel.EMPTY_CURSOR : title2;
        KStat stat = card2.getValue().getStat();
        if (stat == null || (vt2 = stat.getVt()) == null) {
            str = null;
        } else {
            str = vt2.getIcon();
        }
        if (str == null) {
            str = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        KStat stat2 = card2.getValue().getStat();
        if (stat2 == null || (vt = stat2.getVt()) == null) {
            str2 = null;
        } else {
            str2 = vt.getText();
        }
        VDEndPageUiState.IconText iconText = new VDEndPageUiState.IconText(str, str2 == null ? RoomRecommendViewModel.EMPTY_CURSOR : str2);
        KRelateCMLive live = card2.getValue().getLive();
        if (live == null || (statInfo2 = live.getStatInfo()) == null) {
            str3 = null;
        } else {
            str3 = statInfo2.getIcon();
        }
        if (str3 == null) {
            str3 = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        KRelateCMLive live2 = card2.getValue().getLive();
        if (live2 == null || (statInfo = live2.getStatInfo()) == null) {
            str4 = null;
        } else {
            str4 = statInfo.getText();
        }
        VDEndPageUiState.IconText iconText2 = new VDEndPageUiState.IconText(str3, str4 == null ? RoomRecommendViewModel.EMPTY_CURSOR : str4);
        KStat stat3 = card2.getValue().getStat();
        if (stat3 == null || (danmaku2 = stat3.getDanmaku()) == null) {
            str5 = null;
        } else {
            str5 = danmaku2.getIcon();
        }
        if (str5 == null) {
            str5 = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        KStat stat4 = card2.getValue().getStat();
        if (stat4 == null || (danmaku = stat4.getDanmaku()) == null) {
            str6 = null;
        } else {
            str6 = danmaku.getText();
        }
        VDEndPageUiState.IconText iconText3 = new VDEndPageUiState.IconText(str5, str6 == null ? RoomRecommendViewModel.EMPTY_CURSOR : str6);
        KRelateCMLive live3 = card2.getValue().getLive();
        String areaName = live3 != null ? live3.getAreaName() : null;
        if (areaName == null) {
            areaName = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        KCardBasicInfo basicInfo2 = $this$asVDEndPageUIContent.getBasicInfo();
        String coverRightText = basicInfo2 != null ? basicInfo2.getCoverRightText() : null;
        String str11 = coverRightText == null ? RoomRecommendViewModel.EMPTY_CURSOR : coverRightText;
        KRelateCMLive live4 = card2.getValue().getLive();
        return new VDEndPageUiState.Content(str7, adTagStyle, adTagStyleFullScreen, str8, button, rcmdReasonStyle, str9, feedbackPanel, str10, iconText, iconText3, iconText2, areaName, str11, live4 != null && live4.getLiveStatus() == 1);
    }

    public static final IAdInfo asIAdInfo(KRelateCard $this$asIAdInfo) {
        KAny sourceContent;
        byte[] value;
        Intrinsics.checkNotNullParameter($this$asIAdInfo, "<this>");
        KRelateCard.KCm card = $this$asIAdInfo.getCard();
        if (card == null || !(card instanceof KRelateCard.KCm) || (sourceContent = card.getValue().getSourceContent()) == null || (value = sourceContent.getValue()) == null) {
            return null;
        }
        return AdInfoExtKt.asAdInfo$default(value, false, 1, (Object) null);
    }
}