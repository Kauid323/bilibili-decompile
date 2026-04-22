package tv.danmaku.bili.ui.userfeedback;

import android.content.Context;
import bolts.Continuation;
import bolts.Task;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.moduleservice.userfeedback.UserFeedbackService;
import com.bilibili.userfeedback.AddFeedbackItemHelper;
import com.bilibili.userfeedback.UploadFeedbackFileHelper;
import java.util.List;
import java.util.concurrent.Callable;

public class UserFeedbackHelper {
    public static final String CUSTOM_SERVICE_URI = "https://www.bilibili.com/h5/customer-service";
    private static final String TAG = "UserFeedbackHelper";

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface CheckFeedbackCallback {
        void onHasNewestFeedback(UserFeedbackItem userFeedbackItem);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface FeedbackTagsCallback {
        void onResponseFeedbackTags(List<UserFeedbackTag> list);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    static final class Keys {
        static final String BUNDLE_ADD_FEEDBACK_CONTENT = "bundle_add_feedback_content";
        static final String BUNDLE_ADD_FEEDBACK_ENTRANCE = "bundle_add_feedback_entrance";
        static final String BUNDLE_ADD_FEEDBACK_FILE_URL = "bundle_add_feedback_file_url";
        static final String BUNDLE_ADD_FEEDBACK_IMAGE_URL = "bundle_add_feedback_image_url";
        static final String BUNDLE_ADD_FEEDBACK_REPORTID = "bundle_add_feedback_reportid";
        static final String BUNDLE_REQUEST_FEEDBACK_TAGS_TYPE = "bundle_request_feedback_tags_type";
        static final String BUNDLE_RESOLVE_INTENT_NAME = "bundle_resolve_intent_name";
        static final String BUNDLE_UPLOAD_FEEDBACK_FILE_PATH = "bundle_upload_feedback_file_path";
        static final String BUNDLE_USERFEEDBACK_AUTO_EXTRA_FILE = "bundle_userfeedback_auto_extra_file";
        static final String BUNDLE_USERFEEDBACK_AUTO_IMG = "bundle_userfeedback_auto_img";
        static final String BUNDLE_USERFEEDBACK_AUTO_LOGFILE = "bundle_userfeedback_auto_logfile";

        Keys() {
        }
    }

    public static String uploadFile(String filePath) {
        return UploadFeedbackFileHelper.uploadFeedBackFile(filePath, (String) null);
    }

    public static JSONObject uploadLog(Context context) {
        String result;
        UserFeedbackService service = (UserFeedbackService) BLRouter.INSTANCE.getServices(UserFeedbackService.class).get("default");
        if (service != null && (result = service.uploadLog(context)) != null) {
            return JSON.parseObject(result);
        }
        return new JSONObject();
    }

    public static boolean addFeedbackItem(String logUrl, String imageUrl, String content, String reportId, String entrance) {
        return AddFeedbackItemHelper.addFeedbackItem(BiliContext.application(), content, imageUrl, logUrl, reportId, entrance).booleanValue();
    }

    public static void requestFeedbackTagList(final String type, final FeedbackTagsCallback callback) {
        Task.callInBackground(new Callable<List<UserFeedbackTag>>() { // from class: tv.danmaku.bili.ui.userfeedback.UserFeedbackHelper.2
            @Override // java.util.concurrent.Callable
            public List<UserFeedbackTag> call() throws Exception {
                String result;
                UserFeedbackService service = (UserFeedbackService) BLRouter.INSTANCE.getServices(UserFeedbackService.class).get("default");
                if (service == null || (result = service.requestFeedbackTags(type)) == null) {
                    return null;
                }
                return JSONObject.parseArray(result, UserFeedbackTag.class);
            }
        }).continueWith(new Continuation<List<UserFeedbackTag>, Void>() { // from class: tv.danmaku.bili.ui.userfeedback.UserFeedbackHelper.1
            public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                return m1709then((Task<List<UserFeedbackTag>>) task);
            }

            /* renamed from: then  reason: collision with other method in class */
            public Void m1709then(Task<List<UserFeedbackTag>> task) throws Exception {
                if (FeedbackTagsCallback.this != null) {
                    FeedbackTagsCallback.this.onResponseFeedbackTags((List) task.getResult());
                    return null;
                }
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }
}