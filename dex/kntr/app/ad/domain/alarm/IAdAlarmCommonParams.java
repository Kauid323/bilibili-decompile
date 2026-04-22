package kntr.app.ad.domain.alarm;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: IAdAlarmCommonParams.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lkntr/app/ad/domain/alarm/IAdAlarmCommonParams;", RoomRecommendViewModel.EMPTY_CURSOR, "requestId", RoomRecommendViewModel.EMPTY_CURSOR, "getRequestId", "()Ljava/lang/String;", "creativeId", "getCreativeId$annotations", "()V", "getCreativeId", "srcId", "getSrcId", "cardType", "getCardType", "extra", "getExtra", "alarm_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IAdAlarmCommonParams {

    /* compiled from: IAdAlarmCommonParams.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getCreativeId$annotations() {
        }
    }

    String getCardType();

    String getCreativeId();

    String getExtra();

    String getRequestId();

    String getSrcId();
}