package tv.danmaku.bili.ui.garb;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.common.webview.js.JsBridgeCallHandlerV2;
import com.bilibili.commons.security.DigestUtils;
import com.bilibili.lib.okdownloader.BiliDownloader;
import com.bilibili.lib.okdownloader.DownloadListener;
import com.bilibili.lib.okdownloader.Task;
import com.bilibili.okretro.call.json.JsonUtilKt;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.log.BuildConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.push.innerpush.v2.InnerPushReceiverKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.filechooser.FileUtils;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: NftCardJsBridgeCallHandler.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016H\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardJsBridgeCallHandler;", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerV2;", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", AuthResultCbHelper.ARGS_CALLBACK, "Ltv/danmaku/bili/ui/garb/NftCardJsbCallback;", "<init>", "(Landroid/app/Activity;Ltv/danmaku/bili/ui/garb/NftCardJsbCallback;)V", "getActivity", "()Landroid/app/Activity;", "getCallback", "()Ltv/danmaku/bili/ui/garb/NftCardJsbCallback;", "invokeNative", "", "method", "", "data", "Lcom/alibaba/fastjson/JSONObject;", "callbackId", "loadVideoWithUrl", "url", "getSupportFunctions", "", "()[Ljava/lang/String;", BuildConfig.BUILD_TYPE, "getTag", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NftCardJsBridgeCallHandler extends JsBridgeCallHandlerV2 {
    public static final String GET_EXTRA = "getExtra";
    public static final String PRELOAD_RESOURCE = "preloadResource";
    public static final String SHOW_CARD_DETAIL = "showCardDetail";
    public static final String TAG = "NftCardJsBridgeCallHandler";
    private final Activity activity;
    private final NftCardJsbCallback callback;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public NftCardJsBridgeCallHandler(Activity activity, NftCardJsbCallback callback) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(callback, AuthResultCbHelper.ARGS_CALLBACK);
        this.activity = activity;
        this.callback = callback;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final NftCardJsbCallback getCallback() {
        return this.callback;
    }

    /* compiled from: NftCardJsBridgeCallHandler.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardJsBridgeCallHandler$Companion;", "", "<init>", "()V", "TAG", "", "SHOW_CARD_DETAIL", "PRELOAD_RESOURCE", "GET_EXTRA", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void invokeNative(String method, final JSONObject data, final String callbackId) {
        Intrinsics.checkNotNullParameter(method, "method");
        try {
            switch (method.hashCode()) {
                case 916749623:
                    if (method.equals(PRELOAD_RESOURCE)) {
                        runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.ui.garb.NftCardJsBridgeCallHandler$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                NftCardJsBridgeCallHandler.invokeNative$lambda$1(data, this);
                            }
                        });
                        break;
                    }
                    break;
                case 1801245278:
                    if (!method.equals(SHOW_CARD_DETAIL)) {
                        break;
                    } else {
                        runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.ui.garb.NftCardJsBridgeCallHandler$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                NftCardJsBridgeCallHandler.invokeNative$lambda$0(data, this);
                            }
                        });
                        break;
                    }
                case 1952791130:
                    if (!method.equals(GET_EXTRA)) {
                        break;
                    } else {
                        runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.ui.garb.NftCardJsBridgeCallHandler$$ExternalSyntheticLambda2
                            @Override // java.lang.Runnable
                            public final void run() {
                                NftCardJsBridgeCallHandler.invokeNative$lambda$2(NftCardJsBridgeCallHandler.this, callbackId);
                            }
                        });
                        break;
                    }
            }
        } catch (Throwable th) {
            BLog.e(TAG, "invoke garb jsb error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r4v1, types: [tv.danmaku.bili.ui.garb.NftCardJsBridgeCallHandler$invokeNative$lambda$0$$inlined$parseJson$1] */
    public static final void invokeNative$lambda$0(JSONObject $data, NftCardJsBridgeCallHandler this$0) {
        if ($data == null) {
            return;
        }
        try {
            String result = $data.getString("result");
            if (result == null) {
                return;
            }
            Type type = new TypeToken<NftCardModel>() { // from class: tv.danmaku.bili.ui.garb.NftCardJsBridgeCallHandler$invokeNative$lambda$0$$inlined$parseJson$1
            }.getType();
            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            NftCardModel model = (NftCardModel) JsonUtilKt.parseJson(result, type);
            BLog.i(TAG, "show card detail from type: " + (model != null ? Integer.valueOf(model.getType()) : null) + "  not_on_sale: " + (model != null ? Integer.valueOf(model.getNotOnSale()) : null));
            NftCardDialog.Companion.show(this$0.activity, model, this$0.callback);
        } catch (Throwable e) {
            BLog.e(TAG, "parse json error " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeNative$lambda$1(JSONObject $data, NftCardJsBridgeCallHandler this$0) {
        if ($data != null) {
            try {
                BLog.i(TAG, "preload resource " + $data);
                Map jSONObject = $data.getJSONObject("animation_draw_list");
                String loadingUrl = $data.getString("animation_draw_url");
                if (jSONObject != null) {
                    Map $this$forEach$iv = jSONObject;
                    for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                        Object value = element$iv.getValue();
                        String it = value instanceof String ? (String) value : null;
                        if (it != null) {
                            this$0.loadVideoWithUrl(it);
                        }
                    }
                }
                if (loadingUrl != null) {
                    this$0.loadVideoWithUrl(loadingUrl);
                }
            } catch (Throwable e) {
                BLog.e(TAG, "parse json error " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeNative$lambda$2(NftCardJsBridgeCallHandler this$0, String $callbackId) {
        SharedPreferences bLKVSharedPreference = BiliGlobalPreferenceHelper.getBLKVSharedPreference();
        String extraString = bLKVSharedPreference != null ? bLKVSharedPreference.getString("COLLECT_CARD_HANDBOOK_DATA", "") : null;
        Map jSONObject = new JSONObject();
        jSONObject.put(LoginReporterV2.Show.SIGNUP_KEY_CODE, "0");
        if (!TextUtils.isEmpty(extraString)) {
            BLog.i(TAG, "get extra success");
            jSONObject.put("success", "1");
            jSONObject.put(InnerPushReceiverKt.KEY_EXTRA, extraString);
        } else {
            BLog.i(TAG, "get extra failed");
            jSONObject.put("success", "0");
        }
        this$0.callbackToJs(new Object[]{$callbackId, jSONObject});
    }

    private final void loadVideoWithUrl(final String url) {
        File filesDir;
        Activity ctx = this.activity;
        Application application = BiliContext.application();
        String finalDir = ((application == null || (filesDir = application.getFilesDir()) == null) ? null : filesDir.getAbsolutePath()) + "/earn/animation";
        String suffix = (String) CollectionsKt.last(StringsKt.split$default(url, new String[]{FileUtils.HIDDEN_PREFIX}, false, 0, 6, (Object) null));
        String fileName = DigestUtils.md5(url) + FileUtils.HIDDEN_PREFIX + suffix;
        final Ref.LongRef startTime = new Ref.LongRef();
        final Ref.LongRef endTime = new Ref.LongRef();
        Task task = BiliDownloader.Companion.get(ctx).create(url, "earn.mp4").into(finalDir).fileName(fileName).rejectedWhenFileExists().retryTime(3).networkOn(3).priority(10).addListener(new DownloadListener() { // from class: tv.danmaku.bili.ui.garb.NftCardJsBridgeCallHandler$loadVideoWithUrl$task$1
            public /* synthetic */ void onCancel(String str) {
                DownloadListener.-CC.$default$onCancel(this, str);
            }

            public /* synthetic */ void onCheck(String str) {
                DownloadListener.-CC.$default$onCheck(this, str);
            }

            public /* synthetic */ void onLoading(String str, long j, long j2, long j3, int i) {
                DownloadListener.-CC.$default$onLoading(this, str, j, j2, j3, i);
            }

            public /* synthetic */ void onPause(String str, long j, long j2) {
                DownloadListener.-CC.$default$onPause(this, str, j, j2);
            }

            public /* synthetic */ void onWait(String str) {
                DownloadListener.-CC.$default$onWait(this, str);
            }

            public void onStart(String taskId) {
                Intrinsics.checkNotNullParameter(taskId, "taskId");
                DownloadListener.-CC.$default$onStart(this, taskId);
                BLog.d("NftCardDialog", "downloadResource start url:" + url);
                startTime.element = System.currentTimeMillis();
            }

            public void onError(String taskId, List<Integer> list, long totalSize, long loadedSize) {
                Intrinsics.checkNotNullParameter(taskId, "taskId");
                DownloadListener.-CC.$default$onError(this, taskId, list, totalSize, loadedSize);
                BLog.e("NftCardDialog", "download error, code " + list);
            }

            public void onFinish(String taskId, String dir, String name) {
                Intrinsics.checkNotNullParameter(taskId, "taskId");
                DownloadListener.-CC.$default$onFinish(this, taskId, dir, name);
                endTime.element = System.currentTimeMillis();
                long j = endTime.element - startTime.element;
                BLog.i("NftCardDialog", "download success cost time " + j + "ms url:" + url + " path:" + dir + "/" + name);
            }

            public void onRetry(String taskId, int retryTimes) {
                Intrinsics.checkNotNullParameter(taskId, "taskId");
                DownloadListener.-CC.$default$onRetry(this, taskId, retryTimes);
                BLog.d("NftCardDialog", "downloadResource retry url:" + url + " retryTime:" + retryTimes);
            }
        }).build();
        startTime.element = System.currentTimeMillis();
        task.enqueue();
    }

    public String[] getSupportFunctions() {
        return new String[]{SHOW_CARD_DETAIL, PRELOAD_RESOURCE, GET_EXTRA};
    }

    public void release() {
    }

    protected String getTag() {
        return TAG;
    }
}