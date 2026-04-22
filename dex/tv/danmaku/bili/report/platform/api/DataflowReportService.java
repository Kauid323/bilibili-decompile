package tv.danmaku.bili.report.platform.api;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import retrofit2.http.BaseUrl;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

@BaseUrl("https://app.bilibili.com")
interface DataflowReportService {
    @FormUrlEncoded
    @POST("/x/v2/dataflow/report")
    BiliCall<GeneralResponse<Void>> report(@Field("buvid") String str, @Field("fts") long j, @Field("event_id") String str2, @Field("event_type") String str3, @Field("message_info") String str4);
}