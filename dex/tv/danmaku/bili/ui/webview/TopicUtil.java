package tv.danmaku.bili.ui.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import bili.resource.homepage.R;
import com.bilibili.api.BiliApiException;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.router.Router;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.topic.api.FavouredStatus;
import tv.danmaku.bili.ui.topic.api.TopicApiService;

public class TopicUtil {
    private static final int REQUEST_CODE_LOGIN_FAVORITE = 100;
    private boolean mIsFavorited;
    private String mTopicId;

    public static boolean isTopicUrl(Uri uri) {
        return "topic".equalsIgnoreCase(uri.getQueryParameter("goto"));
    }

    public void setTopicId(String topicId) {
        this.mTopicId = topicId;
    }

    public void queryStatus(Context context) {
        String accessKey = BiliAccounts.get(context).getAccessKey();
        ((TopicApiService) ServiceGenerator.createService(TopicApiService.class)).queryFavorStatus(accessKey, this.mTopicId).enqueue(new BiliApiDataCallback<FavouredStatus>() { // from class: tv.danmaku.bili.ui.webview.TopicUtil.1
            public void onDataSuccess(FavouredStatus data) {
                if (data == null) {
                    return;
                }
                TopicUtil.this.mIsFavorited = data.favoured;
            }

            public void onError(Throwable t) {
                BLog.w(t.getMessage(), t);
            }
        });
    }

    private void favorite(final Context context) {
        String accessKey = BiliAccounts.get(context).getAccessKey();
        ((TopicApiService) ServiceGenerator.createService(TopicApiService.class)).favorTopic(accessKey, this.mTopicId).enqueue(new BiliApiDataCallback<Void>() { // from class: tv.danmaku.bili.ui.webview.TopicUtil.2
            public void onDataSuccess(Void data) {
                TopicUtil.this.mIsFavorited = true;
                ToastHelper.showToast(context, R.string.homepage_global_string_230, 0);
            }

            public void onError(Throwable t) {
                if ((t instanceof BiliApiException) && 15002 == ((BiliApiException) t).mCode) {
                    onDataSuccess((Void) null);
                } else {
                    ToastHelper.showToast(context, bili.resource.others.R.string.others_global_string_103, 0);
                }
            }
        });
    }

    private void unFavorite(final Context context) {
        String accessKey = BiliAccounts.get(context).getAccessKey();
        ((TopicApiService) ServiceGenerator.createService(TopicApiService.class)).unFavorTopic(accessKey, this.mTopicId).enqueue(new BiliApiDataCallback<Void>() { // from class: tv.danmaku.bili.ui.webview.TopicUtil.3
            public void onDataSuccess(Void data) {
                TopicUtil.this.mIsFavorited = false;
                ToastHelper.showToast(context, bili.resource.others.R.string.others_global_string_392, 0);
            }

            public void onError(Throwable t) {
                ToastHelper.showToast(context, bili.resource.playerbaseres.R.string.playerbaseres_global_string_463, 0);
            }
        });
    }

    public void toogle(Context context) {
        if (!BiliAccounts.get(context).isLogin()) {
            Router.global().with(context).forResult(100).open("activity://main/login/");
            return;
        }
        Intent intent = new Intent();
        if (this.mIsFavorited) {
            unFavorite(context);
            intent.putExtra("unfav_topic_id", this.mTopicId);
        } else {
            favorite(context);
            intent.putExtra("unfav_topic_id", "");
        }
        Activity activity = ContextUtilKt.findActivityOrNull(context);
        if (activity instanceof MWebActivity) {
            MWebActivity webActivity = (MWebActivity) activity;
            webActivity.setResult(-1, intent);
        }
    }

    public boolean isFavorited() {
        return this.mIsFavorited;
    }

    public boolean isFavoriteEnable() {
        return !TextUtils.isEmpty(this.mTopicId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onActivityResult(MWebActivity activity, int requestCode, int resultCode) {
        if (requestCode == 100 && resultCode == -1) {
            toogle(activity);
            return true;
        }
        return false;
    }
}