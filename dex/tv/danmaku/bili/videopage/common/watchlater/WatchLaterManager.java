package tv.danmaku.bili.videopage.common.watchlater;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import bili.resource.playerbaseres.R;
import com.bilibili.base.Applications;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.okretro.BiliApiCallback;
import com.bilibili.okretro.GeneralResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tv.danmaku.bili.videopage.common.watchlater.api.WatchLaterApiManager;

@Deprecated
public class WatchLaterManager implements PassportObserver {
    private static final String WATCH_LATER_VIEW_IS_SHOW = "watch_later_view_is_show";
    private static WatchLaterManager mInstance;
    private String mFrom;
    private String mShouldRetryAddAvId;
    private BiliGlobalPreferenceHelper preferencesHelper;
    private boolean shouldShowToast = true;

    private WatchLaterManager() {
    }

    public static WatchLaterManager getInstance() {
        synchronized (WatchLaterManager.class) {
            if (mInstance == null) {
                mInstance = new WatchLaterManager();
                BiliAccounts.get(Applications.getCurrent()).subscribe(mInstance, new Topic[]{Topic.SIGN_IN, Topic.SIGN_OUT});
            }
        }
        return mInstance;
    }

    private BiliGlobalPreferenceHelper getPreferenceHelper() {
        if (this.preferencesHelper == null) {
            this.preferencesHelper = BiliGlobalPreferenceHelper.getInstance(Applications.getCurrent());
        }
        return this.preferencesHelper;
    }

    public void addWatchLater(String avId, Context context) {
        addWatchLater(avId, context, null);
    }

    public void addWatchLater(String avId, final Context context, String from) {
        if (avId == null || !TextUtils.isDigitsOnly(avId) || context == null) {
            return;
        }
        this.mFrom = from;
        if (!BiliAccounts.get(context).isLogin()) {
            this.mShouldRetryAddAvId = avId;
            RouteRequest routeRequest = new RouteRequest.Builder(Uri.parse("activity://main/login")).extras(new Function1() { // from class: tv.danmaku.bili.videopage.common.watchlater.WatchLaterManager$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return WatchLaterManager.lambda$addWatchLater$0((MutableBundleLike) obj);
                }
            }).flags(268435456).build();
            BLRouter.routeTo(routeRequest, context);
            return;
        }
        String accessKey = BiliAccounts.get(context).getAccessKey();
        WatchLaterApiManager.addToWatchLater(accessKey, avId, from, new BiliApiCallback<GeneralResponse<Void>>() { // from class: tv.danmaku.bili.videopage.common.watchlater.WatchLaterManager.1
            public void onSuccess(GeneralResponse<Void> result) {
                if (WatchLaterManager.this.shouldShowToast) {
                    if (result.code == 0) {
                        ToastHelper.showToast(context, context.getString(R.string.playerbaseres_global_string_517), 0, 17);
                    } else {
                        String message = TextUtils.isEmpty(result.message) ? context.getString(R.string.playerbaseres_global_string_1189) : result.message;
                        ToastHelper.showToast(context, message, 0, 17);
                    }
                }
                WatchLaterManager.this.reset();
            }

            public void onError(Throwable t) {
                if (WatchLaterManager.this.shouldShowToast) {
                    ToastHelper.showToast(context, context.getString(R.string.playerbaseres_global_string_1189), 0, 17);
                }
                WatchLaterManager.this.reset();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$addWatchLater$0(MutableBundleLike bundleWrapper) {
        bundleWrapper.put("key_prompt_scene", "player.ugc-video-detail.relatedvideo.watchlater.click");
        return null;
    }

    public void reset() {
        this.mShouldRetryAddAvId = null;
        this.shouldShowToast = true;
    }

    public void updateWatchLaterListViewState(boolean isOpen) {
        if (this.preferencesHelper == null) {
            return;
        }
        this.preferencesHelper.setBoolean(WATCH_LATER_VIEW_IS_SHOW, isOpen);
    }

    private void retryWatchLater(String avId) {
        this.shouldShowToast = false;
        addWatchLater(avId, Applications.getCurrent(), this.mFrom);
    }

    private void resetWatchLaterViewShow() {
        getPreferenceHelper().setBoolean(WATCH_LATER_VIEW_IS_SHOW, true);
    }

    public boolean shouldExpandWatchLaterListView() {
        return getPreferenceHelper().optBoolean(WATCH_LATER_VIEW_IS_SHOW, true);
    }

    public void onChange(Topic topic) {
        if (topic == Topic.SIGN_OUT) {
            resetWatchLaterViewShow();
        } else if (topic == Topic.SIGN_IN) {
            retryWatchLater(this.mShouldRetryAddAvId);
        }
    }
}