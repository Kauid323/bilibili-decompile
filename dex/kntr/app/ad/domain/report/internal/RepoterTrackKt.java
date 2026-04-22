package kntr.app.ad.domain.report.internal;

import java.util.Map;
import kntr.app.ad.common.utils.JsonExtKt;
import kntr.app.ad.domain.track.AdTrack;
import kntr.app.ad.domain.track.AdTrackCommonParams;
import kntr.app.ad.domain.track.AdTrackEvent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;

/* compiled from: RepoterTrack.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a-\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"trackSuccess", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/report/internal/ReportRecord;", "trackFail", "track", "isSuccess", RoomRecommendViewModel.EMPTY_CURSOR, "code", RoomRecommendViewModel.EMPTY_CURSOR, "msg", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/ad/domain/report/internal/ReportRecord;ZLjava/lang/Integer;Ljava/lang/String;)V", "report_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RepoterTrackKt {

    /* compiled from: RepoterTrack.kt */
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

    public static final void trackSuccess(ReportRecord $this$trackSuccess) {
        Intrinsics.checkNotNullParameter($this$trackSuccess, "<this>");
        track($this$trackSuccess, true, $this$trackSuccess.getCode(), $this$trackSuccess.getMsg());
    }

    public static final void trackFail(ReportRecord $this$trackFail) {
        Intrinsics.checkNotNullParameter($this$trackFail, "<this>");
        track($this$trackFail, false, $this$trackFail.getCode(), $this$trackFail.getMsg());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0039 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void track(ReportRecord $this$track, boolean isSuccess, Integer code, String msg) {
        String str;
        boolean isReUpload;
        int extraCode;
        AdTrackEvent trackEvent;
        JsonObject jsonObject;
        String reportEvent;
        String url;
        long j2;
        Long longOrNull;
        Long longOrNull2;
        Function1 extraInfo = $this$track.getExtraInfo();
        if (extraInfo != null) {
            JsonObjectBuilder builder$iv = new JsonObjectBuilder();
            extraInfo.invoke(new ReportExtraHandler(builder$iv));
            JsonObject build = builder$iv.build();
            if (build != null) {
                str = JsonExtKt.getStringOrNull(build, ReportBuildInParam.IS_REUPLOAD);
                isReUpload = Intrinsics.areEqual(str, "1");
                if (isReUpload) {
                    if (isSuccess) {
                        extraCode = 0;
                    } else if (code != null && code.intValue() == -5) {
                        extraCode = 1;
                    } else {
                        extraCode = (code != null && code.intValue() == -3) ? 2 : -1;
                    }
                    RecordType type = $this$track.getType();
                    if (type == null) {
                        return;
                    }
                    switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                        case 1:
                            trackEvent = AdTrackEvent.FEE_REPORT;
                            break;
                        case 2:
                            trackEvent = AdTrackEvent.UI_REPORT;
                            break;
                        case 3:
                            trackEvent = AdTrackEvent.MMA_REPORT;
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                    Function1 adInfo = $this$track.getAdInfo();
                    if (adInfo != null) {
                        JsonObjectBuilder builder$iv2 = new JsonObjectBuilder();
                        adInfo.invoke(new ReportExtraHandler(builder$iv2));
                        jsonObject = builder$iv2.build();
                    } else {
                        jsonObject = null;
                    }
                    JsonObject adInfo2 = jsonObject;
                    Function1 extraInfo2 = $this$track.getExtraInfo();
                    if (extraInfo2 != null) {
                        JsonObjectBuilder builder$iv3 = new JsonObjectBuilder();
                        extraInfo2.invoke(new ReportExtraHandler(builder$iv3));
                        JsonObject build2 = builder$iv3.build();
                        if (build2 != null) {
                            reportEvent = JsonExtKt.getStringOrNull(build2, "event");
                            if (RecordType.MMA != type) {
                                Function1 extraInfo3 = $this$track.getExtraInfo();
                                if (extraInfo3 != null) {
                                    JsonObjectBuilder builder$iv4 = new JsonObjectBuilder();
                                    extraInfo3.invoke(new ReportExtraHandler(builder$iv4));
                                    JsonObject build3 = builder$iv4.build();
                                    if (build3 != null) {
                                        url = JsonExtKt.getStringOrNull(build3, "url");
                                    }
                                }
                                url = null;
                            } else {
                                url = null;
                            }
                            AdTrack adTrack = AdTrack.INSTANCE;
                            String stringOrNull = adInfo2 == null ? JsonExtKt.getStringOrNull(adInfo2, ReportBuildInParam.REQUEST_ID) : null;
                            j2 = -1;
                            long longValue = (adInfo2 != null || (longOrNull2 = JsonExtKt.getLongOrNull(adInfo2, ReportBuildInParam.RESOURCE_ID)) == null) ? -1L : longOrNull2.longValue();
                            String stringOrNull2 = adInfo2 == null ? JsonExtKt.getStringOrNull(adInfo2, ReportBuildInParam.SRC_ID) : null;
                            if (adInfo2 != null && (longOrNull = JsonExtKt.getLongOrNull(adInfo2, ReportBuildInParam.CREATIVE_ID)) != null) {
                                j2 = longOrNull.longValue();
                            }
                            AdTrackCommonParams adTrackCommonParams = new AdTrackCommonParams(stringOrNull, longValue, stringOrNull2, j2, adInfo2 == null ? JsonExtKt.getStringOrNull(adInfo2, ReportBuildInParam.CARD_TYPE) : null, RoomRecommendViewModel.EMPTY_CURSOR);
                            Map $this$track_u24lambda_u244 = MapsKt.createMapBuilder();
                            if (url != null) {
                                String it = url;
                                String str2 = (String) $this$track_u24lambda_u244.put("url", it);
                            }
                            $this$track_u24lambda_u244.put("code", String.valueOf(extraCode));
                            $this$track_u24lambda_u244.put("desc", msg != null ? RoomRecommendViewModel.EMPTY_CURSOR : msg);
                            $this$track_u24lambda_u244.put("event", reportEvent);
                            $this$track_u24lambda_u244.put("is_kntr", "1");
                            Unit unit = Unit.INSTANCE;
                            adTrack.track(trackEvent, adTrackCommonParams, MapsKt.build($this$track_u24lambda_u244));
                            return;
                        }
                    }
                    reportEvent = null;
                    if (RecordType.MMA != type) {
                    }
                    AdTrack adTrack2 = AdTrack.INSTANCE;
                    if (adInfo2 == null) {
                    }
                    j2 = -1;
                    if (adInfo2 != null) {
                    }
                    if (adInfo2 == null) {
                    }
                    if (adInfo2 != null) {
                        j2 = longOrNull.longValue();
                    }
                    AdTrackCommonParams adTrackCommonParams2 = new AdTrackCommonParams(stringOrNull, longValue, stringOrNull2, j2, adInfo2 == null ? JsonExtKt.getStringOrNull(adInfo2, ReportBuildInParam.CARD_TYPE) : null, RoomRecommendViewModel.EMPTY_CURSOR);
                    Map $this$track_u24lambda_u2442 = MapsKt.createMapBuilder();
                    if (url != null) {
                    }
                    $this$track_u24lambda_u2442.put("code", String.valueOf(extraCode));
                    $this$track_u24lambda_u2442.put("desc", msg != null ? RoomRecommendViewModel.EMPTY_CURSOR : msg);
                    $this$track_u24lambda_u2442.put("event", reportEvent);
                    $this$track_u24lambda_u2442.put("is_kntr", "1");
                    Unit unit2 = Unit.INSTANCE;
                    adTrack2.track(trackEvent, adTrackCommonParams2, MapsKt.build($this$track_u24lambda_u2442));
                    return;
                }
                return;
            }
        }
        str = null;
        isReUpload = Intrinsics.areEqual(str, "1");
        if (isReUpload) {
        }
    }
}