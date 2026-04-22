package kntr.app.ad.ad.biz.liveroom.respository;

import java.util.Map;
import kntr.app.ad.common.model.AdInfoExtra;
import kntr.app.ad.common.model.AdSourceContent;
import kntr.app.ad.common.model.AdSourceContentKt;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.ad.protocol.report.IReportable;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LiveRoomBigCardRepository.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lkntr/app/ad/ad/biz/liveroom/respository/LiveRoomBigCardRepository;", RoomRecommendViewModel.EMPTY_CURSOR, "liveRoomId", RoomRecommendViewModel.EMPTY_CURSOR, "sourceContent", "Lkntr/app/ad/common/model/AdSourceContent;", "<init>", "(Ljava/lang/String;Lkntr/app/ad/common/model/AdSourceContent;)V", "getLiveRoomId", "()Ljava/lang/String;", "getSourceContent", "()Lkntr/app/ad/common/model/AdSourceContent;", "setSourceContent", "(Lkntr/app/ad/common/model/AdSourceContent;)V", "feedExtra", "Lkntr/app/ad/common/model/AdInfoExtra;", "getFeedExtra", "()Lkntr/app/ad/common/model/AdInfoExtra;", "reportable", "Lkntr/app/ad/protocol/report/IReportable;", "getReportable", "()Lkntr/app/ad/protocol/report/IReportable;", "adCommonParams", RoomRecommendViewModel.EMPTY_CURSOR, "getAdCommonParams", "()Ljava/util/Map;", "liveroom_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LiveRoomBigCardRepository {
    public static final int $stable = 8;
    private final String liveRoomId;
    private AdSourceContent sourceContent;

    public LiveRoomBigCardRepository(String liveRoomId, AdSourceContent sourceContent) {
        this.liveRoomId = liveRoomId;
        this.sourceContent = sourceContent;
    }

    public /* synthetic */ LiveRoomBigCardRepository(String str, AdSourceContent adSourceContent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : adSourceContent);
    }

    public final String getLiveRoomId() {
        return this.liveRoomId;
    }

    public final AdSourceContent getSourceContent() {
        return this.sourceContent;
    }

    public final void setSourceContent(AdSourceContent adSourceContent) {
        this.sourceContent = adSourceContent;
    }

    private final AdInfoExtra getFeedExtra() {
        AdSourceContent.AdContent adContent;
        AdSourceContent adSourceContent = this.sourceContent;
        if (adSourceContent == null || (adContent = adSourceContent.getAdContent()) == null) {
            return null;
        }
        return adContent.getExtra();
    }

    public final IReportable getReportable() {
        AdSourceContent adSourceContent = this.sourceContent;
        return adSourceContent != null ? AdSourceContentKt.asAdInfo(adSourceContent) : null;
    }

    public final Map<String, String> getAdCommonParams() {
        AdSourceContent.AdContent adContent;
        Pair[] pairArr = new Pair[6];
        pairArr[0] = TuplesKt.to("room_id", this.liveRoomId);
        AdInfoExtra feedExtra = getFeedExtra();
        String str = null;
        pairArr[1] = TuplesKt.to("track_id", feedExtra != null ? feedExtra.getTrackId() : null);
        AdInfoExtra feedExtra2 = getFeedExtra();
        pairArr[2] = TuplesKt.to(ReportBuildInParam.FROM_TRACK_ID, feedExtra2 != null ? feedExtra2.getFromTrackId() : null);
        AdInfoExtra feedExtra3 = getFeedExtra();
        pairArr[3] = TuplesKt.to("cm_from_track_id", feedExtra3 != null ? feedExtra3.getCmFromTrackId() : null);
        AdSourceContent adSourceContent = this.sourceContent;
        if (adSourceContent != null && (adContent = adSourceContent.getAdContent()) != null) {
            str = adContent.getAdCb();
        }
        pairArr[4] = TuplesKt.to("ad_cb", str);
        pairArr[5] = TuplesKt.to("use_kntr_vm", "1");
        return MapsKt.mapOf(pairArr);
    }
}