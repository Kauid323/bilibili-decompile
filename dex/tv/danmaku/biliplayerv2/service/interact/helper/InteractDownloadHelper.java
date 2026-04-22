package tv.danmaku.biliplayerv2.service.interact.helper;

import android.content.Context;
import android.text.TextUtils;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.okretro.interceptor.SignOnUrlRequestInterceptor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Request;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: InteractDownloadHelper.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/helper/InteractDownloadHelper;", "", "<init>", "()V", "DANMAKU_OLD_DOMAIN", "", "getOldDanmakuUrlFromCid", "context", "Landroid/content/Context;", "cid", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class InteractDownloadHelper {
    private static final String DANMAKU_OLD_DOMAIN = "/x/v1/dm/list.so";
    public static final InteractDownloadHelper INSTANCE = new InteractDownloadHelper();

    private InteractDownloadHelper() {
    }

    public final String getOldDanmakuUrlFromCid(Context context, long cid) {
        Intrinsics.checkNotNullParameter(context, "context");
        long mid = BiliAccounts.get(context).mid();
        String accessKey = BiliAccounts.get(context).getAccessKey();
        HttpUrl parse = HttpUrl.parse("https://api.bilibili.com/x/v1/dm/list.so");
        Intrinsics.checkNotNull(parse);
        HttpUrl.Builder builder = parse.newBuilder();
        builder.addQueryParameter("oid", String.valueOf(cid));
        if (!TextUtils.isEmpty(accessKey) && mid > 0) {
            builder.addQueryParameter("access_key", accessKey);
        }
        HttpUrl httpUrl = builder.build();
        Request request = new Request.Builder().url(httpUrl).build();
        SignOnUrlRequestInterceptor signOnUrlRequestInterceptor = new SignOnUrlRequestInterceptor();
        Request intercept = signOnUrlRequestInterceptor.intercept(request);
        String httpUrl2 = intercept.url().toString();
        Intrinsics.checkNotNullExpressionValue(httpUrl2, "toString(...)");
        return httpUrl2;
    }
}