package tv.danmaku.bili.safe;

import com.bilibili.lib.accounts.model.AuthKey;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import retrofit2.http.BaseUrl;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/* JADX INFO: Access modifiers changed from: package-private */
@BaseUrl("https://api.bilibili.com")
public interface BiliSafeService {
    @GET("/x/safecenter/key")
    BiliCall<GeneralResponse<AuthKey>> getKey();

    @FormUrlEncoded
    @POST("/x/safecenter/pwd/supplement")
    BiliCall<GeneralResponse<Void>> setPwd(@Field("access_key") String str, @Field("pwd") String str2);
}