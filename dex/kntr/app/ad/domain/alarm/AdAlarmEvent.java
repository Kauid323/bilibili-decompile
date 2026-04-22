package kntr.app.ad.domain.alarm;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: AdAlarmEvent.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, d2 = {"Lkntr/app/ad/domain/alarm/AdAlarmEvent;", RoomRecommendViewModel.EMPTY_CURSOR, "value", RoomRecommendViewModel.EMPTY_CURSOR, "sampler", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getValue", "()Ljava/lang/String;", "getSampler", "()I", "APPSTORE_LOAD_STATUS", "DATA_NO_ADINFO", "DATA_UNSUPPORT_CARD_TYPE", "DATA_MATERIAL_INVALID", "CLICK_NO_REACT", "CLICK_WXPROGRAM_CALLUP_FAILED", "CLICK_OPENWHITELIST_FAILED", "CLICK_DOWNLOADWHITELIST_FAILED", "WEBVIEW_LOAD_FAILED", "REPORT_MMA_FAILED", "REPORT_FEE_FAILED", "REPORT_UI_FAILED", "REPORT_FEE_ABANDON", "REPORT_UI_ABANDON", "REPORT_MMA_ABANDON", "IAA_LOAD_FAILED", "IAA_SHOW_FAILED", "IAA_LOAD_STATUS", "IAA_SHOW_STATUS", "IAA_PLAYABLE_LOAD_STATUS", "IAA_PLUGIN_REQUEST_STATUS", "alarm_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum AdAlarmEvent {
    APPSTORE_LOAD_STATUS("ad.ops.appstore.load-status", AdAlarmSamplerKt.getClick_sampler()),
    DATA_NO_ADINFO("ad.ops.data.no-adinfo", AdAlarmSamplerKt.getData_sampler()),
    DATA_UNSUPPORT_CARD_TYPE("ad.ops.data.unsupport-card-type", AdAlarmSamplerKt.getData_sampler()),
    DATA_MATERIAL_INVALID("ad.ops.data.material-invalid", AdAlarmSamplerKt.getData_sampler()),
    CLICK_NO_REACT("ad.ops.click.no-react", AdAlarmSamplerKt.getClick_sampler()),
    CLICK_WXPROGRAM_CALLUP_FAILED("ad.ops.click.wxprogram-callup-failed", AdAlarmSamplerKt.getClick_sampler()),
    CLICK_OPENWHITELIST_FAILED("ad.ops.click.openwhitelist-failed", AdAlarmSamplerKt.getClick_sampler()),
    CLICK_DOWNLOADWHITELIST_FAILED("ad.ops.click.downloadwhitelist-failed", AdAlarmSamplerKt.getClick_sampler()),
    WEBVIEW_LOAD_FAILED("ad.ops.webview.load-failed", AdAlarmSamplerKt.getClick_sampler()),
    REPORT_MMA_FAILED("ad.ops.report.mma-failed", AdAlarmSamplerKt.getReport_sampler()),
    REPORT_FEE_FAILED("ad.ops.report.fee-failed", AdAlarmSamplerKt.getReport_sampler()),
    REPORT_UI_FAILED("ad.ops.report.ui-failed", AdAlarmSamplerKt.getReport_sampler()),
    REPORT_FEE_ABANDON("ad.ops.report.fee-abandon", AdAlarmSamplerKt.getReport_sampler()),
    REPORT_UI_ABANDON("ad.ops.report.ui-abandon", AdAlarmSamplerKt.getReport_sampler()),
    REPORT_MMA_ABANDON("ad.ops.report.mma-abandon", AdAlarmSamplerKt.getReport_sampler()),
    IAA_LOAD_FAILED("ad.ops.iaa.load-failed", AdAlarmSamplerKt.getClick_sampler()),
    IAA_SHOW_FAILED("ad.ops.iaa.show-failed", AdAlarmSamplerKt.getClick_sampler()),
    IAA_LOAD_STATUS("ad.ops.iaa.load-status", AdAlarmSamplerKt.getStatus_sampler()),
    IAA_SHOW_STATUS("ad.ops.iaa.show-status", AdAlarmSamplerKt.getStatus_sampler()),
    IAA_PLAYABLE_LOAD_STATUS("ad.ops.iaa.playable-load-status", AdAlarmSamplerKt.getStatus_sampler()),
    IAA_PLUGIN_REQUEST_STATUS("ad.ops.iaa.plugin-request-status", AdAlarmSamplerKt.getStatus_sampler());
    
    private final int sampler;
    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<AdAlarmEvent> getEntries() {
        return $ENTRIES;
    }

    AdAlarmEvent(String value, int sampler) {
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