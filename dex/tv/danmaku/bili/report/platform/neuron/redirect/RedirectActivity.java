package tv.danmaku.bili.report.platform.neuron.redirect;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.basecomponent.R;
import com.bilibili.lib.biliid.api.BuvidHelper;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.neuron.model.config.RedirectConfig;
import com.bilibili.lib.okhttp.OkHttpClientWrapper;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.report.platform.neuron.env.NeuronEnvTestPageUtils;

@Deprecated
public class RedirectActivity extends BaseToolbarActivity {
    private static final int DEFAULT_TIMEOUT_MS = 6000;
    public static final String QUERY_KEY_REDIRECTCONFIG = "redirectConfig";
    private static final String TAG = "neuron.redirect.ui";
    private static final String URL_SYNC_UUID = "http://davinci.bilibili.co/x/davin/trace/qr/receive";

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bili_app_activity_with_toolbar);
        showBackButton();
        Parcelable parseConfig = parseConfig(getIntent());
        if (savedInstanceState == null) {
            RedirectFragment redirectFragment = new RedirectFragment();
            if (parseConfig != null) {
                Bundle b = new Bundle();
                b.putParcelable(RedirectFragmentKt.BUNDLE_KEY_REDIRECT_CONFIG, parseConfig);
                redirectFragment.setArguments(b);
            }
            getSupportFragmentManager().beginTransaction().add(tv.danmaku.bili.R.id.content_layout, redirectFragment).commit();
        }
        if (parseConfig != null) {
            doConfig(parseConfig);
        }
    }

    private RedirectConfig parseConfig(Intent intent) {
        try {
            Uri uri = intent.getData();
            String jsonStr = uri.getQueryParameter(QUERY_KEY_REDIRECTCONFIG);
            RedirectConfig config = (RedirectConfig) JSON.parseObject(jsonStr, RedirectConfig.class);
            if (config != null && config.isValid()) {
                return config;
            }
            throw new RuntimeException("Invalid direct config " + jsonStr);
        } catch (Exception e) {
            BLog.e(TAG, e.getMessage());
            return null;
        }
    }

    private void doConfig(final RedirectConfig config) {
        Neurons.redirect(config);
        HandlerThreads.getHandler(2).post(new Runnable() { // from class: tv.danmaku.bili.report.platform.neuron.redirect.RedirectActivity.1
            @Override // java.lang.Runnable
            public void run() {
                RedirectActivity.this.syncUuid(config);
                if (!TextUtils.isEmpty(config.uuid)) {
                    NeuronEnvTestPageUtils.Companion.sendScanMessage(config.uuid);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncUuid(RedirectConfig redirectConfig) {
        OkHttpClient client = OkHttpClientWrapper.get().newBuilder().connectTimeout(6000L, TimeUnit.MILLISECONDS).writeTimeout(6000L, TimeUnit.MILLISECONDS).readTimeout(6000L, TimeUnit.MILLISECONDS).build();
        JSONObject json = new JSONObject();
        json.put("uuid", redirectConfig.uuid);
        json.put("buvid", BuvidHelper.getBuvid());
        Request request = new Request.Builder().url(URL_SYNC_UUID).post(RequestBody.create(MediaType.parse("application/json"), json.toJSONString())).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (Throwable ignored) {
            try {
                BLog.e(TAG, ignored.getMessage());
                if (0 == 0) {
                }
            } finally {
                if (0 != 0) {
                    response.close();
                }
            }
        }
    }
}