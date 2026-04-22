package kntr.app.ad.domain.track;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: AdTrackEvent.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lkntr/app/ad/domain/track/AdTrackEvent;", RoomRecommendViewModel.EMPTY_CURSOR, "value", RoomRecommendViewModel.EMPTY_CURSOR, "sampler", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getValue", "()Ljava/lang/String;", "getSampler", "()I", "APPSTORE_LOAD_STATUS", "AD_DATA", "CLICK", "WX_CALL_UP", "APP_CALL_UP", "APP_DOWNLOAD", "WEB_VIEW_LOAD", "MMA_REPORT", "FEE_REPORT", "UI_REPORT", "track_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum AdTrackEvent {
    APPSTORE_LOAD_STATUS("ad.track.appstore-load-status", AdTrackSamplerKt.getAction_sampler()),
    AD_DATA("ad.track.ad-data", AdTrackSamplerKt.getData_sampler()),
    CLICK("ad.track.click", AdTrackSamplerKt.getAction_sampler()),
    WX_CALL_UP("ad.track.wxprogram-callup", AdTrackSamplerKt.getAction_sampler()),
    APP_CALL_UP("ad.track.app-callup", AdTrackSamplerKt.getAction_sampler()),
    APP_DOWNLOAD("ad.track.app-download", AdTrackSamplerKt.getAction_sampler()),
    WEB_VIEW_LOAD("ad.track.webview-load", AdTrackSamplerKt.getAction_sampler()),
    MMA_REPORT("ad.track.report-mma", AdTrackSamplerKt.getReport_sampler()),
    FEE_REPORT("ad.track.report-fee", AdTrackSamplerKt.getReport_sampler()),
    UI_REPORT("ad.track.report-ui", AdTrackSamplerKt.getReport_sampler());
    
    private final int sampler;
    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<AdTrackEvent> getEntries() {
        return $ENTRIES;
    }

    AdTrackEvent(String value, int sampler) {
        this.value = value;
        this.sampler = sampler;
    }

    public final String getValue() {
        return this.value;
    }

    public final int getSampler() {
        return this.sampler;
    }
}