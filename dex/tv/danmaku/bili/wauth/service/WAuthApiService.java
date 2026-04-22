package tv.danmaku.bili.wauth.service;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import kotlin.Metadata;
import retrofit2.http.BaseUrl;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tv.danmaku.bili.wauth.Bean.WAuthVerifyBean;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.P2P;

/* compiled from: WAuthApiService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\u0082\u0001\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u00072\b\b\u0001\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\u0010\u001a\u00020\u00072\b\b\u0001\u0010\u0011\u001a\u00020\u0007H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/wauth/service/WAuthApiService;", "", "wAuthVerify", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/wauth/Bean/WAuthVerifyBean;", "appKey", "", "tempCode", "bizSeq", "certPwd", "photoData", "idCardAuthData", "localId", "devicePlatform", "deviceName", "deviceID", P2P.KEY_EXT_P2P_BUVID, "networkauth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@BaseUrl("https://passport.bilibili.com")
public interface WAuthApiService {
    @POST("/x/safecenter/net_code/face/verify")
    BiliCall<GeneralResponse<WAuthVerifyBean>> wAuthVerify(@Query("appKey") String str, @Query("tmp_code") String str2, @Query("biz_seq") String str3, @Query("cert_pwd_data") String str4, @Query("photo_data") String str5, @Query("idcard_auth_data") String str6, @Query("local_id") String str7, @Query("device_platform") String str8, @Query("device_name") String str9, @Query("device_id") String str10, @Query("buvid") String str11);
}