package tv.danmaku.bili.moss.test.cases.bandwidth;

import bili.resource.homepage.R;
import com.bapis.bilibili.app.splash.v1.SplashMoss;
import com.bapis.bilibili.app.splash.v1.SplashReply;
import com.bapis.bilibili.app.splash.v1.SplashReq;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.moss.api.MossException;
import com.bilibili.lib.moss.api.MossResponseHandler;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.moss.MossTestKt;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.splash.ad.utils.NetworkUtilsKt;
import tv.danmaku.bili.ui.splash.ad.model.SplashData;
import tv.danmaku.bili.ui.splash.ad.service.SplashService;

/* compiled from: SplashTest.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"testSplashSync", "", "testSplashAsync", "getSplashPb", "Lcom/bapis/bilibili/app/splash/v1/SplashReq;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashTestKt {
    public static final void testSplashSync() {
        ToastHelper.showToastShort(BiliContext.application(), R.string.homepage_global_string_173);
    }

    public static final void testSplashAsync() {
        BiliCall call = ((SplashService) ServiceGenerator.createService(SplashService.class)).getSplashList("1,2,3", "1,2,3", BusinessSplashDefineKt.SPLASH_OPEN_EVENT_COLD);
        if (call != null) {
            call.enqueue(new BiliApiDataCallback<SplashData>() { // from class: tv.danmaku.bili.moss.test.cases.bandwidth.SplashTestKt$testSplashAsync$1
                public void onDataSuccess(SplashData data) {
                }

                public void onError(Throwable t) {
                }
            });
        }
        new SplashMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null).list(getSplashPb(), new MossResponseHandler<SplashReply>() { // from class: tv.danmaku.bili.moss.test.cases.bandwidth.SplashTestKt$testSplashAsync$2
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

            public void onNext(SplashReply value) {
                if (value != null) {
                    BLog.d(MossTestKt.TAG, "Splash on next");
                }
            }

            public void onError(MossException t) {
                if (t != null) {
                    BLog.e(MossTestKt.TAG, "Splash on error, " + t);
                }
            }
        });
    }

    public static final SplashReq getSplashPb() {
        SplashReq.Builder $this$getSplashPb_u24lambda_u240 = SplashReq.newBuilder();
        $this$getSplashPb_u24lambda_u240.setWidth(1080);
        $this$getSplashPb_u24lambda_u240.setHeight(1794);
        $this$getSplashPb_u24lambda_u240.setBirth("0101");
        $this$getSplashPb_u24lambda_u240.setAdExtra("979CD936E441AD18D4DA41A86BACC8168EBE79AA118B33339F80B75C0CD4A1992D36232462A56F4CC7C7E93BFAE33C2EDEA22F19D1DB9C021604DAB304035F8FD09CC00070E1751C322FDA073FE81362163A60D48EF19F79929E98E56202A64E9CC418923EBCC72B8D676AA9423D243CBA9F7F544456356D3F20CC8EF065EB485098B21A7C39249AAA2944F0878CEB6400A58D841A31395E563CC9C9D0EC24F85A956FC3C0BEBBD28A04F20CA973344137F8583324E9EA32FE172917A0F5068F6C711E0EE360CB39DF943E09D7479CDA7584FB8AAECF4207C2AE5CCB652D1B0E445CCF13E1DAC3DFE45D86190945FECFBD82ED8DFE3BC7182313203A9DF1D93BDB0B32F3542EF35D78A806F29C5F1A66D94790E1B3077361C48F0F6C62202E21E7ACB125B18093EA08237831BB23E545610141CEEDC7D7D3F1B2D8AA4E305B91C22C112EF4E12C0C90034FFE36E32304A3926E7AD04BB7A23C3068DBF1DD757C6B43837275DF468FB0AFA297B71A8C9422175EB48877DA262EF6A41351614E89C05AB4E47292E4B405E49BE54E5F0D30D6FBCB8B441433444A8C0E4B37EDF281170B66BA8CDF704CFEBC6C9C8A8AFD9B35B55A716DEF754409DE4300E5F7A609D6EFC5FF10F253513971D6D8F09552184C7ECF6A62358BB3DBF2DA3B2FFFB77A2F8D34E8DADECDAA842A5A4966797C03");
        $this$getSplashPb_u24lambda_u240.setNetwork(NetworkUtilsKt.NETWORK_TYPE_WIFI);
        SplashReq build = $this$getSplashPb_u24lambda_u240.build();
        Intrinsics.checkNotNullExpressionValue(build, "run(...)");
        return build;
    }
}