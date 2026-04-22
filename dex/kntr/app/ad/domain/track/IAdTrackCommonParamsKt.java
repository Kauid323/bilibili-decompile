package kntr.app.ad.domain.track;

import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAdTrackCommonParams.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0000\u001a&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0000¨\u0006\u0005"}, d2 = {"asMap", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/track/IAdTrackCommonParams;", "filter", "track_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IAdTrackCommonParamsKt {
    public static final Map<String, String> asMap(IAdTrackCommonParams $this$asMap) {
        Intrinsics.checkNotNullParameter($this$asMap, "<this>");
        Map $this$asMap_u24lambda_u240 = MapsKt.createMapBuilder();
        String requestId = $this$asMap.getRequestId();
        String str = RoomRecommendViewModel.EMPTY_CURSOR;
        if (requestId == null) {
            requestId = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        $this$asMap_u24lambda_u240.put(ReportBuildInParam.REQUEST_ID, requestId);
        $this$asMap_u24lambda_u240.put(ReportBuildInParam.RESOURCE_ID, String.valueOf($this$asMap.getResourceId()));
        String srcId = $this$asMap.getSrcId();
        if (srcId == null) {
            srcId = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        $this$asMap_u24lambda_u240.put(ReportBuildInParam.SRC_ID, srcId);
        $this$asMap_u24lambda_u240.put(ReportBuildInParam.CREATIVE_ID, String.valueOf($this$asMap.getCreativeId()));
        String cardType = $this$asMap.getCardType();
        if (cardType == null) {
            cardType = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        $this$asMap_u24lambda_u240.put(ReportBuildInParam.CARD_TYPE, cardType);
        if (AdTrackSamplerKt.getParam_with_large_param()) {
            String extra = $this$asMap.getExtra();
            if (extra != null) {
                str = extra;
            }
            $this$asMap_u24lambda_u240.put("extra", str);
        }
        return MapsKt.build($this$asMap_u24lambda_u240);
    }

    public static final Map<String, String> filter(Map<String, String> map) {
        Map<String, String> map2;
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map.containsKey("item") && !AdTrackSamplerKt.getParam_with_large_param()) {
            map2 = MapsKt.toMutableMap(map);
            map2.remove("item");
        } else {
            map2 = map;
        }
        LinkedHashMap result$iv = new LinkedHashMap();
        for (Map.Entry entry$iv : map2.entrySet()) {
            String it = entry$iv.getValue();
            if (it != null) {
                result$iv.put(entry$iv.getKey(), entry$iv.getValue());
            }
        }
        LinkedHashMap $this$mapValues$iv = result$iv;
        Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
        Iterable $this$associateByTo$iv$iv$iv = $this$mapValues$iv.entrySet();
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
            Object key = it$iv$iv.getKey();
            Map.Entry it2 = (Map.Entry) element$iv$iv$iv;
            Object value = it2.getValue();
            Intrinsics.checkNotNull(value);
            destination$iv$iv.put(key, (String) value);
        }
        return destination$iv$iv;
    }
}