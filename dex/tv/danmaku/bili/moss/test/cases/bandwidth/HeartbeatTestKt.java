package tv.danmaku.bili.moss.test.cases.bandwidth;

import bili.resource.homepage.R;
import com.bapis.bilibili.api.player.v1.HeartbeatMoss;
import com.bapis.bilibili.api.player.v1.HeartbeatReply;
import com.bapis.bilibili.api.player.v1.HeartbeatReq;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.moss.api.MossException;
import com.bilibili.lib.moss.api.MossResponseHandler;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.moss.MossTestKt;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: HeartbeatTest.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\b\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0006\u0010\u0006\u001a\u00020\u0001¨\u0006\u0007"}, d2 = {"testHeartbeatSync", "", "getHeartbeatParams", "Ltv/danmaku/bili/moss/test/cases/bandwidth/HeartbeatParams;", "getHeartbeatParamsPb", "Lcom/bapis/bilibili/api/player/v1/HeartbeatReq;", "testHeartbeatAsync", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HeartbeatTestKt {
    public static final void testHeartbeatSync() {
        ToastHelper.showToastShort(BiliContext.application(), R.string.homepage_global_string_173);
    }

    private static final HeartbeatParams getHeartbeatParams() {
        return new HeartbeatParams(1598603704L, "0b7bd27696e23ef3f77a037a361fdae0fe780057", 0L, 455791214L, 195402555L, "0", 0L, "3", 0, 32, 156L, 4L, 152L, 148L, "1", 1, 5L, 5L, 7, LoginReporterV2.Show.SMS_LOGIN_DIALOG_FROM_HOME, "main.ugc-video-detail.0.0", "", "0", "0", 152L, 0, 0L, 152L);
    }

    private static final HeartbeatReq getHeartbeatParamsPb() {
        HeartbeatReq.Builder $this$getHeartbeatParamsPb_u24lambda_u240 = HeartbeatReq.newBuilder();
        $this$getHeartbeatParamsPb_u24lambda_u240.setServerTime(1598603704L);
        $this$getHeartbeatParamsPb_u24lambda_u240.setSession("0b7bd27696e23ef3f77a037a361fdae0fe780057");
        $this$getHeartbeatParamsPb_u24lambda_u240.setMid(0L);
        $this$getHeartbeatParamsPb_u24lambda_u240.setAid(455791214L);
        $this$getHeartbeatParamsPb_u24lambda_u240.setCid(195402555L);
        $this$getHeartbeatParamsPb_u24lambda_u240.setSid("0");
        $this$getHeartbeatParamsPb_u24lambda_u240.setEpid(0L);
        $this$getHeartbeatParamsPb_u24lambda_u240.setType("3");
        $this$getHeartbeatParamsPb_u24lambda_u240.setSubType(0);
        $this$getHeartbeatParamsPb_u24lambda_u240.setQuality(32);
        $this$getHeartbeatParamsPb_u24lambda_u240.setTotalTime(156L);
        $this$getHeartbeatParamsPb_u24lambda_u240.setPausedTime(4L);
        $this$getHeartbeatParamsPb_u24lambda_u240.setPlayedTime(152L);
        $this$getHeartbeatParamsPb_u24lambda_u240.setVideoDuration(148L);
        $this$getHeartbeatParamsPb_u24lambda_u240.setPlayType("1");
        $this$getHeartbeatParamsPb_u24lambda_u240.setNetworkType(1);
        $this$getHeartbeatParamsPb_u24lambda_u240.setLastPlayProgressTime(5L);
        $this$getHeartbeatParamsPb_u24lambda_u240.setMaxPlayProgressTime(5L);
        $this$getHeartbeatParamsPb_u24lambda_u240.setFrom(7);
        $this$getHeartbeatParamsPb_u24lambda_u240.setFromSpmid(LoginReporterV2.Show.SMS_LOGIN_DIALOG_FROM_HOME);
        $this$getHeartbeatParamsPb_u24lambda_u240.setSpmid("main.ugc-video-detail.0.0");
        $this$getHeartbeatParamsPb_u24lambda_u240.setEpidStatus("");
        $this$getHeartbeatParamsPb_u24lambda_u240.setPlayStatus("0");
        $this$getHeartbeatParamsPb_u24lambda_u240.setUserStatus("0");
        $this$getHeartbeatParamsPb_u24lambda_u240.setActualPlayedTime(152L);
        $this$getHeartbeatParamsPb_u24lambda_u240.setAutoPlay(0);
        $this$getHeartbeatParamsPb_u24lambda_u240.setListPlayTime(0L);
        $this$getHeartbeatParamsPb_u24lambda_u240.setDetailPlayTime(152L);
        HeartbeatReq build = $this$getHeartbeatParamsPb_u24lambda_u240.build();
        Intrinsics.checkNotNullExpressionValue(build, "run(...)");
        return build;
    }

    public static final void testHeartbeatAsync() {
        final long start = System.currentTimeMillis();
        ((HeartbeatApi) ServiceGenerator.createService(HeartbeatApi.class)).reportV2(getHeartbeatParams()).enqueue(new BiliApiDataCallback<String>() { // from class: tv.danmaku.bili.moss.test.cases.bandwidth.HeartbeatTestKt$testHeartbeatAsync$1
            public void onDataSuccess(String data) {
                long end = System.currentTimeMillis();
                BLog.e(MossTestKt.TAG, "Heartbeat cost, " + (end - start));
            }

            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
            }
        });
        new HeartbeatMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null).mobile(getHeartbeatParamsPb(), new MossResponseHandler<HeartbeatReply>() { // from class: tv.danmaku.bili.moss.test.cases.bandwidth.HeartbeatTestKt$testHeartbeatAsync$2
            public /* synthetic */ void onCompleted() {
                MossResponseHandler.-CC.$default$onCompleted(this);
            }

            public /* synthetic */ void onHeaders(Map map) {
                MossResponseHandler.-CC.$default$onHeaders(this, map);
            }

            public /* synthetic */ long onNextForAck(Object obj) {
                return MossResponseHandler.-CC.$default$onNextForAck(this, obj);
            }

            public /* synthetic */ void onUpstreamAck(Long l) {
                MossResponseHandler.-CC.$default$onUpstreamAck(this, l);
            }

            public /* synthetic */ void onValid() {
                MossResponseHandler.-CC.$default$onValid(this);
            }

            public void onNext(HeartbeatReply value) {
                if (value != null) {
                    BLog.d(MossTestKt.TAG, "Report heartbeat on next, " + value.getTs());
                }
            }

            public void onError(MossException t) {
                if (t != null) {
                    BLog.e(MossTestKt.TAG, "Report heartbeat on error, " + t);
                }
            }
        });
    }
}