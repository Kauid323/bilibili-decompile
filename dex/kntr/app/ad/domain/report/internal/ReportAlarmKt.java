package kntr.app.ad.domain.report.internal;

import kntr.app.ad.common.utils.JsonExtKt;
import kntr.app.ad.domain.alarm.AdAlarm;
import kntr.app.ad.domain.alarm.AdAlarmCommonParams;
import kntr.app.ad.domain.alarm.AdAlarmEvent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;

/* compiled from: ReportAlarm.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a?\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"alarmAbandon", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/report/internal/ReportRecord;", "alarmFailed", "alarm", "events", "Lkotlin/Triple;", "Lkntr/app/ad/domain/alarm/AdAlarmEvent;", "code", RoomRecommendViewModel.EMPTY_CURSOR, "msg", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/ad/domain/report/internal/ReportRecord;Lkotlin/Triple;Ljava/lang/Integer;Ljava/lang/String;)V", "report_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ReportAlarmKt {

    /* compiled from: ReportAlarm.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RecordType.values().length];
            try {
                iArr[RecordType.FEE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[RecordType.UI.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[RecordType.MMA.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void alarmAbandon(ReportRecord $this$alarmAbandon) {
        Intrinsics.checkNotNullParameter($this$alarmAbandon, "<this>");
        alarm($this$alarmAbandon, new Triple(AdAlarmEvent.REPORT_FEE_ABANDON, AdAlarmEvent.REPORT_UI_ABANDON, AdAlarmEvent.REPORT_MMA_ABANDON), $this$alarmAbandon.getCode(), $this$alarmAbandon.getMsg());
    }

    public static final void alarmFailed(ReportRecord $this$alarmFailed) {
        Intrinsics.checkNotNullParameter($this$alarmFailed, "<this>");
        alarm($this$alarmFailed, new Triple(AdAlarmEvent.REPORT_FEE_FAILED, AdAlarmEvent.REPORT_UI_FAILED, AdAlarmEvent.REPORT_MMA_FAILED), $this$alarmFailed.getCode(), $this$alarmFailed.getMsg());
    }

    private static final void alarm(ReportRecord $this$alarm, Triple<? extends AdAlarmEvent, ? extends AdAlarmEvent, ? extends AdAlarmEvent> triple, Integer code, String msg) {
        AdAlarmEvent event;
        JsonObject jsonObject;
        String url;
        RecordType type = $this$alarm.getType();
        if (type == null) {
            return;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                event = (AdAlarmEvent) triple.getFirst();
                break;
            case 2:
                event = (AdAlarmEvent) triple.getSecond();
                break;
            case 3:
                event = (AdAlarmEvent) triple.getThird();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        Function1 adInfo = $this$alarm.getAdInfo();
        if (adInfo != null) {
            JsonObjectBuilder builder$iv = new JsonObjectBuilder();
            adInfo.invoke(new ReportExtraHandler(builder$iv));
            jsonObject = builder$iv.build();
        } else {
            jsonObject = null;
        }
        JsonObject adInfo2 = jsonObject;
        if (RecordType.MMA == type) {
            Function1 extraInfo = $this$alarm.getExtraInfo();
            if (extraInfo != null) {
                JsonObjectBuilder builder$iv2 = new JsonObjectBuilder();
                extraInfo.invoke(new ReportExtraHandler(builder$iv2));
                JsonObject build = builder$iv2.build();
                if (build != null) {
                    url = JsonExtKt.getStringOrNull(build, "url");
                }
            }
            url = null;
        } else {
            url = null;
        }
        AdAlarm.INSTANCE.fire(event, new AdAlarmCommonParams(adInfo2 != null ? JsonExtKt.getStringOrNull(adInfo2, ReportBuildInParam.REQUEST_ID) : null, adInfo2 != null ? JsonExtKt.getStringOrNull(adInfo2, ReportBuildInParam.CREATIVE_ID) : null, adInfo2 != null ? JsonExtKt.getStringOrNull(adInfo2, ReportBuildInParam.SRC_ID) : null, adInfo2 != null ? JsonExtKt.getStringOrNull(adInfo2, ReportBuildInParam.CARD_TYPE) : null, RoomRecommendViewModel.EMPTY_CURSOR), MapsKt.mapOf(new Pair[]{TuplesKt.to("url", url), TuplesKt.to("code", String.valueOf(code)), TuplesKt.to("desc", msg), TuplesKt.to("is_kntr", "1")}));
    }
}