package tv.danmaku.bili.ui.garb.api;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.app.authorspace.BiliSpaceApiServiceV2;
import com.bilibili.app.comm.list.avatarcommon.R;
import com.bilibili.base.BiliContext;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.bfs.BfsResponse;
import com.bilibili.bfs.BfsUploadRequest;
import com.bilibili.bfs.BfsUploader;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.okretro.ServiceGenerator;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.garb.api.BiliNftAvatarUploader;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: BiliNftAvatarUploader.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/BiliNftAvatarUploader;", "", "<init>", "()V", "Companion", "UploadBFSCallback", "UploadCallback", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliNftAvatarUploader {
    public static final int $stable = 0;
    private static final int CONNECT_NETWORK_ERROR = -4097;
    public static final Companion Companion = new Companion(null);
    private static final String NFT_LIST_BFS_BUCKET = "medialist";
    private static final String NFT_LIST_COVER_DIR = "nft";
    private static final String TAG = "BiliNftAvatarUploader";

    /* compiled from: BiliNftAvatarUploader.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/BiliNftAvatarUploader$UploadBFSCallback;", "", "onSuccess", "", "imageUrl", "", "onFailure", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface UploadBFSCallback {
        void onFailure();

        void onSuccess(String str);
    }

    /* compiled from: BiliNftAvatarUploader.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/BiliNftAvatarUploader$UploadCallback;", "", "onUploadSuccess", "", "onUploadFailed", LoginReporterV2.Show.SIGNUP_KEY_CODE, "", AuthResultCbHelper.ARGS_MSG, "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface UploadCallback {
        void onUploadFailed(int i, String str);

        void onUploadSuccess();
    }

    /* compiled from: BiliNftAvatarUploader.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u001a\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/BiliNftAvatarUploader$Companion;", "", "<init>", "()V", "TAG", "", "CONNECT_NETWORK_ERROR", "", "uploadAvatar", "", "context", "Landroid/content/Context;", "width", "height", "offsetX", "offsetY", "cardId", "", "uploadCallback", "Ltv/danmaku/bili/ui/garb/api/BiliNftAvatarUploader$UploadCallback;", "NFT_LIST_BFS_BUCKET", "NFT_LIST_COVER_DIR", "uploadBFS", AudioIntentHelper.ARGS_URI, "Landroid/net/Uri;", AuthResultCbHelper.ARGS_CALLBACK, "Ltv/danmaku/bili/ui/garb/api/BiliNftAvatarUploader$UploadBFSCallback;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void uploadAvatar(Context context, int width, int height, int offsetX, int offsetY, long cardId, final UploadCallback uploadCallback) {
            Intrinsics.checkNotNullParameter(context, "context");
            ((BiliSpaceApiServiceV2) ServiceGenerator.createService(BiliSpaceApiServiceV2.class)).setDigitalAvatar(width, height, offsetX, offsetY, String.valueOf(cardId)).enqueue(new Callback<JSONObject>() { // from class: tv.danmaku.bili.ui.garb.api.BiliNftAvatarUploader$Companion$uploadAvatar$callback$1
                public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    JSONObject jsonObject = (JSONObject) response.body();
                    int code = jsonObject != null ? jsonObject.getIntValue(LoginReporterV2.Show.SIGNUP_KEY_CODE) : -1;
                    String msg = jsonObject != null ? jsonObject.getString("message") : null;
                    if (code == 0) {
                        BiliNftAvatarUploader.UploadCallback uploadCallback2 = BiliNftAvatarUploader.UploadCallback.this;
                        if (uploadCallback2 != null) {
                            uploadCallback2.onUploadSuccess();
                            return;
                        }
                        return;
                    }
                    BiliNftAvatarUploader.UploadCallback uploadCallback3 = BiliNftAvatarUploader.UploadCallback.this;
                    if (uploadCallback3 != null) {
                        uploadCallback3.onUploadFailed(code, msg);
                    }
                }

                public void onFailure(Call<JSONObject> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    BiliNftAvatarUploader.UploadCallback uploadCallback2 = BiliNftAvatarUploader.UploadCallback.this;
                    if (uploadCallback2 != null) {
                        Application application = BiliContext.application();
                        uploadCallback2.onUploadFailed(-4097, application != null ? application.getString(R.string.avatar_failed_without_internet) : null);
                    }
                }
            });
        }

        public final void uploadBFS(Uri uri, final UploadBFSCallback callback) {
            String path;
            if (!ConnectivityMonitor.getInstance().isNetworkActive()) {
                return;
            }
            Bitmap bitmap = null;
            if (uri == null) {
                path = null;
            } else {
                try {
                    path = uri.getPath();
                } catch (Throwable th) {
                    BLog.e(BiliNftAvatarUploader.TAG, "parse bitmap err");
                }
            }
            bitmap = BitmapFactory.decodeFile(path);
            if (bitmap == null) {
                return;
            }
            Bitmap finalBitmap = bitmap;
            BfsUploadRequest request = BfsUploader.newRequest(BiliNftAvatarUploader.NFT_LIST_BFS_BUCKET).dir(BiliNftAvatarUploader.NFT_LIST_COVER_DIR).image(finalBitmap).accesskey(new Function0() { // from class: tv.danmaku.bili.ui.garb.api.BiliNftAvatarUploader$Companion$$ExternalSyntheticLambda0
                public final Object invoke() {
                    String uploadBFS$lambda$0;
                    uploadBFS$lambda$0 = BiliNftAvatarUploader.Companion.uploadBFS$lambda$0();
                    return uploadBFS$lambda$0;
                }
            }).build();
            Call call = BfsUploader.newCall$default(request, (Executor) null, 2, (Object) null);
            call.enqueue(new Callback<BfsResponse>() { // from class: tv.danmaku.bili.ui.garb.api.BiliNftAvatarUploader$Companion$uploadBFS$1
                public void onResponse(Call<BfsResponse> call2, Response<BfsResponse> response) {
                    Intrinsics.checkNotNullParameter(call2, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (!response.isSuccessful() || BiliNftAvatarUploader.UploadBFSCallback.this == null) {
                        return;
                    }
                    BfsResponse bfsResponse = (BfsResponse) response.body();
                    if (bfsResponse == null || TextUtils.isEmpty(bfsResponse.location)) {
                        BiliNftAvatarUploader.UploadBFSCallback.this.onFailure();
                        return;
                    }
                    String bfsImgUrl = bfsResponse.location;
                    BiliNftAvatarUploader.UploadBFSCallback.this.onSuccess(bfsImgUrl);
                }

                public void onFailure(Call<BfsResponse> call2, Throwable t) {
                    Intrinsics.checkNotNullParameter(call2, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    BiliNftAvatarUploader.UploadBFSCallback uploadBFSCallback = BiliNftAvatarUploader.UploadBFSCallback.this;
                    if (uploadBFSCallback != null) {
                        uploadBFSCallback.onFailure();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String uploadBFS$lambda$0() {
            String accessKey = BiliAccounts.get(BiliContext.application()).getAccessKey();
            Intrinsics.checkNotNullExpressionValue(accessKey, "getAccessKey(...)");
            return accessKey;
        }
    }

    @JvmStatic
    public static final void uploadAvatar(Context context, int width, int height, int offsetX, int offsetY, long cardId, UploadCallback uploadCallback) {
        Companion.uploadAvatar(context, width, height, offsetX, offsetY, cardId, uploadCallback);
    }
}