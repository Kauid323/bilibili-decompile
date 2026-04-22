package tv.danmaku.bili.ui.appeal;

import android.content.Context;
import android.text.TextUtils;
import bolts.Continuation;
import bolts.Task;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.boxing.model.entity.impl.ImageMedia;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.okretro.ServiceGenerator;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.appeal.IImageUploader;
import tv.danmaku.bili.ui.login.LoginReporterV2;

public class AppealImageUploader implements IImageUploader {
    public static final String TAG = "ImageUploader";
    private String mAid;
    private Map<String, String> mCacheImages = new ConcurrentHashMap();
    private UploadCall mUploadCall;
    private IImageUploader.OnUploadListener mUploadListener;

    public AppealImageUploader(String aid) {
        this.mAid = aid;
    }

    @Override // tv.danmaku.bili.ui.appeal.IImageUploader
    public void upload(Context context, List<ImageMedia> medias, int retryCountPerImage, IImageUploader.OnUploadListener listener) {
        this.mUploadListener = listener;
        onStart();
        UploadCall uploadCall = new UploadCall(context, this.mAid, medias, this.mCacheImages, retryCountPerImage);
        this.mUploadCall = uploadCall;
        Task.callInBackground(uploadCall).continueWith(new Continuation<List<String>, Void>() { // from class: tv.danmaku.bili.ui.appeal.AppealImageUploader.1
            public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                return m1545then((Task<List<String>>) task);
            }

            /* renamed from: then  reason: collision with other method in class */
            public Void m1545then(Task<List<String>> task) throws Exception {
                boolean isCompleted = task.isCompleted();
                if (!isCompleted) {
                    AppealImageUploader.this.onFailed(null);
                    BLog.d(AppealImageUploader.TAG, "upload failed: unCompleted");
                    return null;
                }
                boolean isCancelled = task.isCancelled();
                Exception e = task.getError();
                if (isCancelled || (e instanceof CancellationException)) {
                    BLog.d(AppealImageUploader.TAG, "upload cancelled");
                    AppealImageUploader.this.onCanceled();
                    return null;
                }
                boolean isFaulted = task.isFaulted();
                List<String> result = (List) task.getResult();
                if (isFaulted || result == null || result.isEmpty()) {
                    AppealImageUploader.this.onFailed(e instanceof ImageUploadException ? (ImageUploadException) e : null);
                    if (!isFaulted) {
                        BLog.d(AppealImageUploader.TAG, "upload failed: invalid result");
                    }
                    return null;
                }
                AppealImageUploader.this.onSuccess(result);
                BLog.d(AppealImageUploader.TAG, "upload success");
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    @Override // tv.danmaku.bili.ui.appeal.IImageUploader
    public void cancel() {
        if (this.mUploadCall != null) {
            this.mUploadCall.cancel();
        }
    }

    private void onStart() {
        this.mUploadListener.onStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSuccess(List<String> result) {
        this.mUploadListener.onSuccess(result);
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFailed(ImageUploadException e) {
        this.mUploadListener.onFailed(e);
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCanceled() {
        this.mUploadListener.onCanceled();
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getCacheKey(String avid, ImageMedia media) {
        return String.format("%s-%s", avid, media.getCompressPath());
    }

    private void reset() {
        this.mUploadListener = null;
        this.mUploadCall = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class UploadCall implements Callable<List<String>> {
        private final String mAid;
        private final Map<String, String> mCacheImages;
        private final AtomicBoolean mCanceled = new AtomicBoolean(false);
        private final Context mContext;
        private final int mMaxRetry;
        private final List<ImageMedia> mMedias;

        UploadCall(Context context, String aid, List<ImageMedia> medias, Map<String, String> cacheImages, int maxRetry) {
            this.mContext = context;
            this.mAid = aid;
            this.mMedias = new ArrayList(medias);
            this.mCacheImages = cacheImages;
            this.mMaxRetry = Math.max(1, maxRetry);
        }

        @Override // java.util.concurrent.Callable
        public List<String> call() throws Exception {
            String postImage;
            BLog.d(AppealImageUploader.TAG, "upload start");
            List<String> result = new ArrayList<>();
            int size = this.mMedias.size();
            for (int index = 0; index < size; index++) {
                checkCancellation();
                ImageMedia item = this.mMedias.get(index);
                String cacheResult = this.mCacheImages.get(AppealImageUploader.getCacheKey(this.mAid, item));
                if (!TextUtils.isEmpty(cacheResult)) {
                    postImage = cacheResult;
                    BLog.dfmt(AppealImageUploader.TAG, "get upload item(%d) result from cache", Integer.valueOf(index));
                } else {
                    String postImage2 = this.mAid;
                    postImage = upload(postImage2, item, index);
                }
                if (TextUtils.isEmpty(postImage)) {
                    BLog.dfmt(AppealImageUploader.TAG, "upload item(%d) failed", Integer.valueOf(index));
                    return null;
                }
                result.add(postImage);
                this.mCacheImages.put(AppealImageUploader.getCacheKey(this.mAid, item), postImage);
                BLog.dfmt(AppealImageUploader.TAG, "upload item(%d) success (%s)", Integer.valueOf(index), postImage);
            }
            return result;
        }

        private String upload(String aid, ImageMedia imageMedia, int index) throws ImageUploadException {
            int i;
            File file;
            UploadCall uploadCall = this;
            if (imageMedia == null) {
                return null;
            }
            int i2 = 2;
            char c = 0;
            BLog.dfmt(AppealImageUploader.TAG, "upload item(%d) (%s) start", Integer.valueOf(index), imageMedia.getCompressPath());
            int reTry = uploadCall.mMaxRetry;
            File file2 = uploadCall.getImageFile(imageMedia);
            RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file2);
            MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", file2.getName(), fileBody);
            RequestBody aidPart = RequestBody.create((MediaType) null, aid);
            RequestBody midPart = RequestBody.create((MediaType) null, String.valueOf(BiliAccounts.get(uploadCall.mContext).mid()));
            String accessKey = BiliAccounts.get(uploadCall.mContext).getAccessKey();
            while (true) {
                checkCancellation();
                int reTry2 = reTry - 1;
                try {
                    Integer valueOf = Integer.valueOf(index);
                    Integer valueOf2 = Integer.valueOf(uploadCall.mMaxRetry - reTry2);
                    Object[] objArr = new Object[i2];
                    objArr[c] = valueOf;
                    objArr[1] = valueOf2;
                    BLog.dfmt(AppealImageUploader.TAG, "upload item(%d) retry(%d)", objArr);
                    JSONObject json = (JSONObject) ((VideoAppealApi) ServiceGenerator.createService(VideoAppealApi.class)).appealImageUpload(accessKey, aidPart, midPart, filePart).execute().body();
                    int code = json.getIntValue(LoginReporterV2.Show.SIGNUP_KEY_CODE);
                    try {
                        if (code == 0) {
                            try {
                                JSONObject data = json.getJSONObject("data");
                                if (data == null) {
                                    try {
                                        try {
                                            BLog.dfmt(AppealImageUploader.TAG, "upload item(%d) failed: null data in response", Integer.valueOf(index));
                                            return null;
                                        } catch (Exception e) {
                                            e = e;
                                            file = file2;
                                            i = 2;
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        file = file2;
                                        i = 2;
                                    }
                                } else {
                                    String url = data.getString("url");
                                    if (!TextUtils.isEmpty(url)) {
                                        return url;
                                    }
                                    file = file2;
                                    try {
                                        BLog.dfmt(AppealImageUploader.TAG, "upload item(%d) failed: null url in response", Integer.valueOf(index));
                                        return null;
                                    } catch (Exception e3) {
                                        e = e3;
                                        i = 2;
                                    }
                                }
                            } catch (Exception e4) {
                                e = e4;
                                file = file2;
                                i = 2;
                            }
                        } else {
                            file = file2;
                            String message = json.getString("message");
                            i = 2;
                            try {
                                BLog.dfmt(AppealImageUploader.TAG, "upload item(%d) failed: code(%d)", Integer.valueOf(index), Integer.valueOf(code));
                                throw new ImageUploadException(code, message);
                                break;
                            } catch (Exception e5) {
                                e = e5;
                            }
                        }
                    } catch (Exception e6) {
                        e = e6;
                        i = 2;
                    }
                } catch (Exception e7) {
                    e = e7;
                    i = i2;
                    file = file2;
                }
                BLog.d(String.format(Locale.US, "upload item(%d) failed \n", Integer.valueOf(index)), e);
                e.printStackTrace();
                if (e instanceof ImageUploadException) {
                    throw ((ImageUploadException) e);
                }
                if (reTry2 <= 0) {
                    return null;
                }
                i2 = i;
                reTry = reTry2;
                c = 0;
                file2 = file;
                uploadCall = this;
            }
        }

        private File getImageFile(ImageMedia photoMedia) {
            String path = photoMedia.getCompressPath();
            if (!TextUtils.isEmpty(path)) {
                File imgFile = new File(path);
                if (imgFile.exists() && imgFile.isFile()) {
                    return imgFile;
                }
                return null;
            }
            return null;
        }

        public void cancel() {
            this.mCanceled.set(true);
        }

        private void checkCancellation() {
            if (this.mCanceled.get()) {
                throw new CancellationException();
            }
        }
    }
}