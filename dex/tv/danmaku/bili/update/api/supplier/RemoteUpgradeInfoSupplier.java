package tv.danmaku.bili.update.api.supplier;

import android.content.Context;
import android.text.TextUtils;
import com.bilibili.app.updater.R;
import com.bilibili.lib.okhttp.OkHttpClientWrapper;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.update.internal.exception.LatestVersionException;
import tv.danmaku.bili.update.internal.json.JsonParserKt;
import tv.danmaku.bili.update.internal.persist.files.UpdateApk;
import tv.danmaku.bili.update.model.BiliUpgradeInfo;
import tv.danmaku.bili.update.utils.RuntimeHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: RemoteUpgradeInfoSupplier.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\b\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/update/api/supplier/RemoteUpgradeInfoSupplier;", "Ltv/danmaku/bili/update/api/supplier/UpgradeInfoSupplier;", "<init>", "()V", "TAG", "", "get", "Ltv/danmaku/bili/update/model/BiliUpgradeInfo;", "context", "Landroid/content/Context;", "mHeaderInterceptor", "Lokhttp3/Interceptor;", "getUpdateInfoSync", "getUpdateInfoSync$updater_debug", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RemoteUpgradeInfoSupplier implements UpgradeInfoSupplier {
    private final String TAG = "fawkes.update.info.supplier";
    private final Interceptor mHeaderInterceptor = new Interceptor() { // from class: tv.danmaku.bili.update.api.supplier.RemoteUpgradeInfoSupplier$$ExternalSyntheticLambda0
        public final Response intercept(Interceptor.Chain chain) {
            Response mHeaderInterceptor$lambda$0;
            mHeaderInterceptor$lambda$0 = RemoteUpgradeInfoSupplier.mHeaderInterceptor$lambda$0(chain);
            return mHeaderInterceptor$lambda$0;
        }
    };

    @Override // tv.danmaku.bili.update.api.supplier.UpgradeInfoSupplier
    public BiliUpgradeInfo get(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getUpdateInfoSync$updater_debug(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Response mHeaderInterceptor$lambda$0(Interceptor.Chain chain) {
        Request.Builder builder = chain.request().newBuilder();
        Map $this$forEach$iv = RuntimeHelper.INSTANCE.headers();
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            builder.addHeader(element$iv.getKey(), element$iv.getValue());
        }
        return chain.proceed(builder.build());
    }

    public final BiliUpgradeInfo getUpdateInfoSync$updater_debug(Context context) throws Exception {
        Intrinsics.checkNotNullParameter(context, "context");
        BLog.d(this.TAG, "Do sync http request.");
        OkHttpClient client = OkHttpClientWrapper.get().newBuilder().addInterceptor(this.mHeaderInterceptor).connectTimeout(6L, TimeUnit.SECONDS).readTimeout(6L, TimeUnit.SECONDS).followRedirects(false).build();
        Map commonParams = RuntimeHelper.INSTANCE.params();
        String httpUrl = RuntimeHelper.getUpdaterOptions().getUpgradeInfoHttpUrl();
        HttpUrl parse = HttpUrl.parse(httpUrl);
        Intrinsics.checkNotNull(parse);
        HttpUrl url = parse.newBuilder().encodedQuery(RuntimeHelper.signQuery(commonParams)).build();
        Request.Builder reqBuilder = new Request.Builder();
        Map $this$forEach$iv = RuntimeHelper.INSTANCE.headers();
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            reqBuilder.header(element$iv.getKey(), element$iv.getValue());
        }
        reqBuilder.cacheControl(CacheControl.FORCE_NETWORK).url(url);
        Call call = client.newCall(reqBuilder.build());
        try {
            Response response = call.execute();
            Intrinsics.checkNotNullExpressionValue(response, "execute(...)");
            try {
                try {
                    if (response.code() == 200) {
                        ResponseBody body = response.body();
                        Intrinsics.checkNotNull(body);
                        JSONObject object = new JSONObject(body.string());
                        int code = object.optInt("code", -1);
                        BiliUpgradeInfo info = (BiliUpgradeInfo) JsonParserKt.getObject(object, "data", BiliUpgradeInfo.class);
                        if (code == 0 && info != null) {
                            UpdateApk.writeInfo(context, info);
                            BLog.vfmt(this.TAG, "Http request result %s, saved to file cache.", new Object[]{info});
                            return info;
                        } else if (code == -304) {
                            BLog.d(this.TAG, "Nothing to update, clean caches.");
                            UpdateApk.cleanApkDir(context, true);
                            throw new LatestVersionException(context.getString(R.string.update_check_update_no_new));
                        } else {
                            String msg = object.getString("message");
                            if (TextUtils.isEmpty(msg)) {
                                throw new Exception(context.getString(R.string.update_check_update_fail_try_again_later));
                            }
                            throw new Exception(msg);
                        }
                    }
                } catch (JSONException e) {
                    BLog.w(this.TAG, e.getMessage());
                }
                throw new Exception(context.getString(R.string.update_check_update_fail_try_again_later));
            } finally {
                response.close();
            }
        } catch (IOException e2) {
            throw new Exception(context.getString(R.string.update_check_update_fail_try_again_later));
        } catch (Exception t) {
            BLog.e(this.TAG, "upgrade info error, msg -> " + t.getMessage());
            throw t;
        }
    }
}