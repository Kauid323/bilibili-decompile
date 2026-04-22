package kntr.app.ad.domain.report.vendor.mma;

import kntr.app.ad.common.utils.JsonExtKt;
import kntr.app.ad.domain.report.AdReportHub;
import kntr.app.ad.domain.report.internal.ReportAlarmKt;
import kntr.app.ad.domain.report.internal.ReportBuildInEvent;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.ad.domain.report.internal.ReportExtraHandler;
import kntr.app.ad.domain.report.internal.ReportFeature;
import kntr.app.ad.domain.report.internal.ReportRecord;
import kntr.app.ad.domain.report.internal.RepoterTrackKt;
import kntr.app.ad.domain.report.internal.upload.ReportUploader;
import kntr.app.ad.protocol.report.IReportExtraHandler;
import kntr.app.ad.protocol.report.IReportUI;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;

/* compiled from: MMAReportUploader.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003Jb\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0016\u0010\t\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e2\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0010H\u0096@¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0005H\u0014¨\u0006\u0014"}, d2 = {"Lkntr/app/ad/domain/report/vendor/mma/MMAReportUploader;", "Lkntr/app/ad/domain/report/internal/upload/ReportUploader;", "<init>", "()V", "upload", RoomRecommendViewModel.EMPTY_CURSOR, "record", "Lkntr/app/ad/domain/report/internal/ReportRecord;", "needRetry", "startAction", "Lkotlin/Function1;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "successAction", "Lkotlin/Function0;", "failureAction", "Lkotlin/Function2;", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/ad/domain/report/internal/ReportRecord;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "watchBizCode", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MMAReportUploader extends ReportUploader {
    @Override // kntr.app.ad.domain.report.internal.upload.IReportUploader
    public Object upload(final ReportRecord record, final boolean needRetry, Function1<? super String, Unit> function1, final Function0<Unit> function0, final Function2<? super Integer, ? super String, Unit> function2, Continuation<? super Boolean> continuation) {
        String str;
        Function1 extraInfo = record.getExtraInfo();
        if (extraInfo != null) {
            JsonObjectBuilder builder$iv = new JsonObjectBuilder();
            extraInfo.invoke(new ReportExtraHandler(builder$iv));
            final String url = JsonExtKt.getStringOrNull(builder$iv.build(), "url");
            if (url != null) {
                Function1 adInfo = record.getAdInfo();
                if (adInfo != null) {
                    JsonObjectBuilder builder$iv2 = new JsonObjectBuilder();
                    adInfo.invoke(new ReportExtraHandler(builder$iv2));
                    str = JsonExtKt.getStringOrNull(builder$iv2.build(), "ad_cb");
                } else {
                    str = null;
                }
                final String adCb = str;
                return commit$report_debug(ReportUploader.buildRequest$default(this, url, null, function1, 2, null), new Function0() { // from class: kntr.app.ad.domain.report.vendor.mma.MMAReportUploader$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit upload$lambda$2;
                        upload$lambda$2 = MMAReportUploader.upload$lambda$2(needRetry, function0, record, adCb, url);
                        return upload$lambda$2;
                    }
                }, new Function2() { // from class: kntr.app.ad.domain.report.vendor.mma.MMAReportUploader$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2) {
                        Unit upload$lambda$3;
                        upload$lambda$3 = MMAReportUploader.upload$lambda$3(ReportRecord.this, needRetry, function2, adCb, url, ((Integer) obj).intValue(), (String) obj2);
                        return upload$lambda$3;
                    }
                }, continuation);
            }
        }
        return Boxing.boxBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit upload$lambda$2(boolean $needRetry, Function0 $successAction, ReportRecord $record, final String $adCb, final String $url) {
        JsonObject jsonObject;
        if ($needRetry) {
            ReportFeature.startSchedulingRetryTask$default(MMAReportFeature.INSTANCE, false, 1, null);
            if ($successAction != null) {
                $successAction.invoke();
            }
        }
        Function1 extraInfo = $record.getExtraInfo();
        if (extraInfo == null) {
            jsonObject = null;
        } else {
            JsonObjectBuilder builder$iv = new JsonObjectBuilder();
            extraInfo.invoke(new ReportExtraHandler(builder$iv));
            jsonObject = builder$iv.build();
        }
        JsonObject json = jsonObject;
        final String submitActionFrom = json != null ? JsonExtKt.getStringOrNull(json, ReportBuildInParam.SUBMIT_ACTION_FROM) : null;
        final String submitType = json != null ? JsonExtKt.getStringOrNull(json, ReportBuildInParam.SUBMIT_TYPE) : null;
        IReportUI.CC.event$default(AdReportHub.Companion.getUi(), ReportBuildInEvent.MMA_SUBMIT_SUCCESS, null, false, null, new Function1() { // from class: kntr.app.ad.domain.report.vendor.mma.MMAReportUploader$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit upload$lambda$2$1;
                upload$lambda$2$1 = MMAReportUploader.upload$lambda$2$1($adCb, $url, submitActionFrom, submitType, (IReportExtraHandler) obj);
                return upload$lambda$2$1;
            }
        }, 14, null);
        RepoterTrackKt.trackSuccess($record);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003b, code lost:
        if ((r6.length() == 0) == false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit upload$lambda$2$1(String $adCb, String $url, String $submitActionFrom, String $submitType, IReportExtraHandler $this$event) {
        boolean z;
        Intrinsics.checkNotNullParameter($this$event, "$this$event");
        $this$event.put("ad_cb", $adCb);
        $this$event.put("url", $url);
        boolean z2 = true;
        if ($submitActionFrom != null) {
            if (!($submitActionFrom.length() == 0)) {
                z = true;
                if (z) {
                    $this$event.put(ReportBuildInParam.SUBMIT_ACTION_FROM, $submitActionFrom);
                }
                if ($submitType != null) {
                }
                z2 = false;
                if (z2) {
                    $this$event.put(ReportBuildInParam.SUBMIT_TYPE, $submitType);
                }
                return Unit.INSTANCE;
            }
        }
        z = false;
        if (z) {
        }
        if ($submitType != null) {
        }
        z2 = false;
        if (z2) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit upload$lambda$3(ReportRecord $record, boolean $needRetry, Function2 $failureAction, final String $adCb, final String $url, final int code, String msg) {
        JsonObject jsonObject;
        Intrinsics.checkNotNullParameter(msg, "msg");
        Function1 extraInfo = $record.getExtraInfo();
        if (extraInfo != null) {
            JsonObjectBuilder builder$iv = new JsonObjectBuilder();
            extraInfo.invoke(new ReportExtraHandler(builder$iv));
            jsonObject = builder$iv.build();
        } else {
            jsonObject = null;
        }
        JsonObject json = jsonObject;
        final String submitActionFrom = json != null ? JsonExtKt.getStringOrNull(json, ReportBuildInParam.SUBMIT_ACTION_FROM) : null;
        final String submitType = json != null ? JsonExtKt.getStringOrNull(json, ReportBuildInParam.SUBMIT_TYPE) : null;
        IReportUI.CC.event$default(AdReportHub.Companion.getUi(), ReportBuildInEvent.MMA_SUBMIT_FAILED, null, false, null, new Function1() { // from class: kntr.app.ad.domain.report.vendor.mma.MMAReportUploader$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit upload$lambda$3$1;
                upload$lambda$3$1 = MMAReportUploader.upload$lambda$3$1($adCb, $url, code, submitActionFrom, submitType, (IReportExtraHandler) obj);
                return upload$lambda$3$1;
            }
        }, 14, null);
        if ($needRetry && $failureAction != null) {
            $failureAction.invoke(Integer.valueOf(code), msg);
        }
        $record.setCode(Integer.valueOf(code));
        $record.setMsg(msg);
        ReportAlarmKt.alarmFailed($record);
        RepoterTrackKt.trackFail($record);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
        if ((r7.length() == 0) == false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit upload$lambda$3$1(String $adCb, String $url, int $code, String $submitActionFrom, String $submitType, IReportExtraHandler $this$event) {
        boolean z;
        Intrinsics.checkNotNullParameter($this$event, "$this$event");
        $this$event.put("ad_cb", $adCb);
        $this$event.put("url", $url);
        $this$event.put("code", String.valueOf($code));
        boolean z2 = true;
        if ($submitActionFrom != null) {
            if (!($submitActionFrom.length() == 0)) {
                z = true;
                if (z) {
                    $this$event.put(ReportBuildInParam.SUBMIT_ACTION_FROM, $submitActionFrom);
                }
                if ($submitType != null) {
                }
                z2 = false;
                if (z2) {
                    $this$event.put(ReportBuildInParam.SUBMIT_TYPE, $submitType);
                }
                return Unit.INSTANCE;
            }
        }
        z = false;
        if (z) {
        }
        if ($submitType != null) {
        }
        z2 = false;
        if (z2) {
        }
        return Unit.INSTANCE;
    }

    @Override // kntr.app.ad.domain.report.internal.upload.ReportUploader
    protected boolean watchBizCode() {
        return false;
    }
}