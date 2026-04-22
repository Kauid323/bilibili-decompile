package tv.danmaku.bili.bilow.cdn;

import com.bilibili.app.comm.billow.biz.BuildConfig;
import com.bilibili.lib.okhttp.track.tag.TrackTag;
import com.bilibili.lib.okhttp.track.tag.TrackTagKt;
import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestTag;
import okhttp3.Response;
import tv.danmaku.android.log.BLog;

@Deprecated
public class RecordConnectionInfoInterceptor implements Interceptor {
    private static final String TAG = "RecordConnectionInfoInterceptor";

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url();
        String remoteIp = "";
        try {
            remoteIp = chain.connection().socket().getInetAddress().getHostAddress();
        } catch (Exception ignore) {
            BLog.efmt(TAG, "Get peer address with exception %s.", ignore.toString());
        }
        CallInfoManager.getInstance().fill(url.toString(), remoteIp, chain.call().hashCode());
        Request originalRequest = chain.call().request();
        if (originalRequest.tag() instanceof RequestTag) {
            RequestTag tag = (RequestTag) originalRequest.tag();
            TrackTag tt = new TrackTag(remoteIp, "");
            TrackTagKt.attachTrackTag(tag, tt);
        }
        if (BuildConfig.DEBUG) {
            BLog.d(TAG, "host--> " + url.host() + ", dnsprovider-->, url-->" + url);
        }
        return chain.proceed(request);
    }
}