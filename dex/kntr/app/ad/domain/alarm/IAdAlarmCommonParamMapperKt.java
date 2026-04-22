package kntr.app.ad.domain.alarm;

import kntr.app.ad.common.model.AdInfo;
import kntr.app.ad.common.model.AdInfoCard;
import kntr.app.ad.common.model.AdInfoExtra;
import kntr.app.ad.common.model.AdSourceContent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

/* compiled from: IAdAlarmCommonParamMapper.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003¨\u0006\u0004"}, d2 = {"asAlarmParams", "Lkntr/app/ad/domain/alarm/IAdAlarmCommonParams;", "Lkntr/app/ad/common/model/AdSourceContent;", "Lkntr/app/ad/common/model/AdInfo;", "alarm_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IAdAlarmCommonParamMapperKt {
    public static final IAdAlarmCommonParams asAlarmParams(AdSourceContent $this$asAlarmParams) {
        Integer num;
        AdInfoExtra it;
        AdInfoExtra extra;
        AdInfoCard card;
        Intrinsics.checkNotNullParameter($this$asAlarmParams, "<this>");
        String requestId = $this$asAlarmParams.getRequestId();
        AdSourceContent.AdContent adContent = $this$asAlarmParams.getAdContent();
        String str = null;
        String valueOf = String.valueOf(adContent != null ? Long.valueOf(adContent.getCreativeId()) : null);
        String valueOf2 = String.valueOf($this$asAlarmParams.getSourceId());
        AdSourceContent.AdContent adContent2 = $this$asAlarmParams.getAdContent();
        if (adContent2 == null || (extra = adContent2.getExtra()) == null || (card = extra.getCard()) == null) {
            num = null;
        } else {
            num = Integer.valueOf(card.getCardType());
        }
        String valueOf3 = String.valueOf(num);
        AdSourceContent.AdContent adContent3 = $this$asAlarmParams.getAdContent();
        if (adContent3 != null && (it = adContent3.getExtra()) != null) {
            str = Json.Default.encodeToString(AdInfoExtra.Companion.serializer(), it);
        }
        return new AdAlarmCommonParams(requestId, valueOf, valueOf2, valueOf3, str == null ? RoomRecommendViewModel.EMPTY_CURSOR : str);
    }

    public static final IAdAlarmCommonParams asAlarmParams(AdInfo $this$asAlarmParams) {
        AdInfoCard card;
        Intrinsics.checkNotNullParameter($this$asAlarmParams, "<this>");
        String requestId = $this$asAlarmParams.getRequestId();
        String valueOf = String.valueOf($this$asAlarmParams.getCreativeId());
        String valueOf2 = String.valueOf($this$asAlarmParams.getSourceId());
        AdInfoExtra extra = $this$asAlarmParams.getExtra();
        String valueOf3 = String.valueOf((extra == null || (card = extra.getCard()) == null) ? null : Integer.valueOf(card.getCardType()));
        AdInfoExtra it = $this$asAlarmParams.getExtra();
        String encodeToString = it != null ? Json.Default.encodeToString(AdInfoExtra.Companion.serializer(), it) : null;
        return new AdAlarmCommonParams(requestId, valueOf, valueOf2, valueOf3, encodeToString == null ? RoomRecommendViewModel.EMPTY_CURSOR : encodeToString);
    }
}