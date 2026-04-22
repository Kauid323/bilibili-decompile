package tv.danmaku.bili.bilow.domain.legacy;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.anno.CacheControl;
import com.bilibili.okretro.call.BiliCall;
import java.util.List;
import retrofit2.http.BaseUrl;
import retrofit2.http.GET;

@Deprecated
@BaseUrl("https://app.bilibili.com")
public interface CDNApiService {
    public static final String DOMAIN_LIST_URL = "https://app.bilibili.com/x/resource/domain";

    @GET("/x/resource/domain")
    @CacheControl(3600000)
    BiliCall<GeneralResponse<List<String>>> getCDNDomainList();
}