package kntr.app.ad.domain.alarm;

import java.util.Map;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAdAlarmCommonParams.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"asMap", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/alarm/IAdAlarmCommonParams;", "alarm_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IAdAlarmCommonParamsKt {
    public static final Map<String, String> asMap(IAdAlarmCommonParams $this$asMap) {
        Intrinsics.checkNotNullParameter($this$asMap, "<this>");
        Pair[] pairArr = new Pair[5];
        String requestId = $this$asMap.getRequestId();
        String str = RoomRecommendViewModel.EMPTY_CURSOR;
        if (requestId == null) {
            requestId = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        pairArr[0] = TuplesKt.to(ReportBuildInParam.REQUEST_ID, requestId);
        String creativeId = $this$asMap.getCreativeId();
        if (creativeId == null) {
            creativeId = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        pairArr[1] = TuplesKt.to(ReportBuildInParam.CREATIVE_ID, creativeId);
        String srcId = $this$asMap.getSrcId();
        if (srcId == null) {
            srcId = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        pairArr[2] = TuplesKt.to(ReportBuildInParam.SRC_ID, srcId);
        String cardType = $this$asMap.getCardType();
        if (cardType == null) {
            cardType = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        pairArr[3] = TuplesKt.to(ReportBuildInParam.CARD_TYPE, cardType);
        String extra = $this$asMap.getExtra();
        if (extra != null) {
            str = extra;
        }
        pairArr[4] = TuplesKt.to("extra", str);
        return MapsKt.mapOf(pairArr);
    }
}