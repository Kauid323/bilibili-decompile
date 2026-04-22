package tv.danmaku.bili.bilow.domain.legacy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.api.base.util.NetworkManager;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.converter.IParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.login.LoginReporterV2;

@Deprecated
public class ImageFetchStrategy implements DomainStrategy {
    private static final String TAG = "ImageFetchStrategy";
    private List<String> domainList;

    @Override // tv.danmaku.bili.bilow.domain.legacy.DomainStrategy
    public List<String> domainList() {
        ResponseBody body;
        Request request = new Request.Builder().url(CDNApiService.DOMAIN_LIST_URL).get().build();
        Response response = NetworkManager.getBiliCache().get(request);
        if (response != null && (body = response.body()) != null) {
            try {
                GeneralResponse<List<String>> generalResponse = new ImageDomainParser().m738convert(body);
                this.domainList = (List) generalResponse.data;
            } catch (Exception e) {
                BLog.e(TAG, e.getMessage());
            }
        }
        return this.domainList == null ? Collections.emptyList() : this.domainList;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    static class ImageDomainParser implements IParser<GeneralResponse<List<String>>> {
        ImageDomainParser() {
        }

        /* renamed from: convert */
        public GeneralResponse<List<String>> m738convert(ResponseBody value) throws IOException, RuntimeException {
            JSONArray array;
            JSONObject root = JSON.parseObject(value.string());
            GeneralResponse<List<String>> general = new GeneralResponse<>();
            general.code = root.getIntValue(LoginReporterV2.Show.SIGNUP_KEY_CODE);
            general.message = root.getString("message");
            JSONObject data = root.getJSONObject("data");
            if (data != null && (array = data.getJSONArray("image_domains")) != null) {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < array.size(); i++) {
                    list.add(array.getString(i));
                }
                general.data = list;
            }
            return general;
        }
    }
}