package tv.danmaku.bili.wauth;

import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Callback;
import tv.danmaku.bili.wauth.Bean.WAuthVerifyBean;
import tv.danmaku.bili.wauth.service.WAuthApiService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.P2P;

/* compiled from: WAuthRequestHelper.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0082\u0001\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/wauth/WAuthRequestHelper;", "", "<init>", "()V", "mWAuthApiService", "Ltv/danmaku/bili/wauth/service/WAuthApiService;", "getWAuthVerify", "", "appKey", "", "tempCode", "bizSeq", "certPwd", "photoData", "idCardAuthData", "localId", "devicePlatform", "deviceName", "deviceID", P2P.KEY_EXT_P2P_BUVID, "cb", "Lcom/bilibili/okretro/BiliApiDataCallback;", "Ltv/danmaku/bili/wauth/Bean/WAuthVerifyBean;", "SingleInstanceHolder", "Companion", "networkauth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WAuthRequestHelper {
    public static final Companion Companion = new Companion(null);
    private WAuthApiService mWAuthApiService;

    public WAuthRequestHelper() {
        Object createService = ServiceGenerator.createService(WAuthApiService.class);
        Intrinsics.checkNotNullExpressionValue(createService, "createService(...)");
        this.mWAuthApiService = (WAuthApiService) createService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WAuthRequestHelper.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/wauth/WAuthRequestHelper$SingleInstanceHolder;", "", "<init>", "()V", "sWAuthServiceHelper", "Ltv/danmaku/bili/wauth/WAuthRequestHelper;", "getSWAuthServiceHelper", "()Ltv/danmaku/bili/wauth/WAuthRequestHelper;", "networkauth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class SingleInstanceHolder {
        public static final SingleInstanceHolder INSTANCE = new SingleInstanceHolder();
        private static final WAuthRequestHelper sWAuthServiceHelper = new WAuthRequestHelper();

        private SingleInstanceHolder() {
        }

        public final WAuthRequestHelper getSWAuthServiceHelper() {
            return sWAuthServiceHelper;
        }
    }

    /* compiled from: WAuthRequestHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/wauth/WAuthRequestHelper$Companion;", "", "<init>", "()V", "getInstance", "Ltv/danmaku/bili/wauth/WAuthRequestHelper;", "networkauth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WAuthRequestHelper getInstance() {
            return SingleInstanceHolder.INSTANCE.getSWAuthServiceHelper();
        }
    }

    public final void getWAuthVerify(String appKey, String tempCode, String bizSeq, String certPwd, String photoData, String idCardAuthData, String localId, String devicePlatform, String deviceName, String deviceID, String buvid, BiliApiDataCallback<WAuthVerifyBean> biliApiDataCallback) {
        Intrinsics.checkNotNullParameter(biliApiDataCallback, "cb");
        this.mWAuthApiService.wAuthVerify(appKey == null ? "" : appKey, tempCode == null ? "" : tempCode, bizSeq == null ? "" : bizSeq, certPwd == null ? "" : certPwd, photoData == null ? "" : photoData, idCardAuthData == null ? "" : idCardAuthData, localId == null ? "" : localId, devicePlatform == null ? "" : devicePlatform, deviceName == null ? "" : deviceName, deviceID == null ? "" : deviceID, buvid == null ? "" : buvid).enqueue((Callback) biliApiDataCallback);
    }
}