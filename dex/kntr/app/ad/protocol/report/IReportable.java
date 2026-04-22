package kntr.app.ad.protocol.report;

import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: IReportable.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b1\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0012\u0010\u0010\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\tR\u0012\u0010\u0014\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0012\u0010\u0016\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0012\u0010\u0018\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\rR\u0012\u0010\u001a\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\rR\u0012\u0010\u001c\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0012\u0010 \u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\rR\u0012\u0010\"\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001fR\u001a\u0010$\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\f\u0012\u0004\b%\u0010&\u001a\u0004\b'\u0010\tR\u0012\u0010(\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\rR\u0012\u0010*\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\rR\u0012\u0010,\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\rR\u0012\u0010.\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u001fR\u0014\u00100\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\tR\u0014\u00102\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\tR\u001a\u00104\u001a\u00020\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b5\u0010&\u001a\u0004\b6\u0010\rR\u0012\u00107\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u001fR\u0014\u00109\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\tR\u001a\u0010;\u001a\u00020\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b<\u0010&\u001a\u0004\b=\u0010\rR\u0012\u0010>\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u001fR\u0012\u0010@\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\rR\u001a\u0010B\u001a\u0004\u0018\u00010\u0007X¦\u000e¢\u0006\f\u001a\u0004\bC\u0010\t\"\u0004\bD\u0010ER\u0018\u0010F\u001a\u00020\u000bX¦\u000e¢\u0006\f\u001a\u0004\bG\u0010\r\"\u0004\bH\u0010IR\u0018\u0010J\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bK\u0010\u0004\"\u0004\bL\u0010M¨\u0006NÀ\u0006\u0003"}, d2 = {"Lkntr/app/ad/protocol/report/IReportable;", RoomRecommendViewModel.EMPTY_CURSOR, "isAdLoc", RoomRecommendViewModel.EMPTY_CURSOR, "()Z", "isAd", "adCb", RoomRecommendViewModel.EMPTY_CURSOR, "getAdCb", "()Ljava/lang/String;", "sourceId", RoomRecommendViewModel.EMPTY_CURSOR, "getSourceId", "()J", "requestId", "getRequestId", "creativeId", "getCreativeId", ReportBuildInParam.IP, "getIp", "resourceId", "getResourceId", "index", "getIndex", "cardIndex", "getCardIndex", "serverType", "getServerType", "cmMark", RoomRecommendViewModel.EMPTY_CURSOR, "getCmMark", "()I", "creativeType", "getCreativeType", "creativeStyle", "getCreativeStyle", "track_id", "getTrack_id$annotations", "()V", "getTrack_id", "shopId", "getShopId", "upMid", "getUpMid", "productId", "getProductId", "replaceStrategy", "getReplaceStrategy", "fromTrackId", "getFromTrackId", "cmFromTrackId", "getCmFromTrackId", "itemId", "getItemId$annotations", "getItemId", "itemSource", "getItemSource", "extraParams", "getExtraParams", ReportBuildInParam.ID, "getId$annotations", "getId", "natureAd", "getNatureAd", "liveBookingId", "getLiveBookingId", "cardType", "getCardType", "setCardType", "(Ljava/lang/String;)V", "avid", "getAvid", "setAvid", "(J)V", "buttonShow", "getButtonShow", "setButtonShow", "(Z)V", "protocol_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IReportable {

    /* compiled from: IReportable.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getId$annotations() {
        }

        public static /* synthetic */ void getItemId$annotations() {
        }

        public static /* synthetic */ void getTrack_id$annotations() {
        }
    }

    String getAdCb();

    long getAvid();

    boolean getButtonShow();

    long getCardIndex();

    String getCardType();

    String getCmFromTrackId();

    int getCmMark();

    long getCreativeId();

    int getCreativeStyle();

    long getCreativeType();

    String getExtraParams();

    String getFromTrackId();

    long getId();

    long getIndex();

    String getIp();

    long getItemId();

    int getItemSource();

    long getLiveBookingId();

    int getNatureAd();

    long getProductId();

    int getReplaceStrategy();

    String getRequestId();

    long getResourceId();

    long getServerType();

    long getShopId();

    long getSourceId();

    String getTrack_id();

    long getUpMid();

    boolean isAd();

    boolean isAdLoc();

    void setAvid(long j2);

    void setButtonShow(boolean z);

    void setCardType(String str);
}