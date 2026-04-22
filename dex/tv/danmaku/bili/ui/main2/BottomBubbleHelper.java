package tv.danmaku.bili.ui.main2;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.homepage.widget.TabHost;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.performance.EntryPointKt;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.utils.ExBilowUtil;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.MainActivityV2;
import tv.danmaku.bili.ui.favorite.BaseFavoritesFragment;
import tv.danmaku.bili.ui.main2.basic.TabHostHelper;
import tv.danmaku.bili.ui.main2.resource.MainResourceManager;
import tv.danmaku.bili.ui.theme.BiliTheme;

public class BottomBubbleHelper {
    public static final String EVENT_BOTTOM_BAR_CLICK = "main.homepage.bottombar.0.click";
    public static final String EVENT_BUBBLE_CLICK = "main.homepage.bubble.0.click";
    public static final String EVENT_BUBBLE_SHOW = "main.homepage.bubble.0.show";
    private static final int MIN_REQUEST_INTERVAL = 300000;
    private static final String TAG = "BottomBubbleHelper";
    public static String lastShowId;
    public static long lastShowTime;
    private static long mGarbId;
    private static long sLastLoadTime;
    private static long sMid;
    private static WeakReference<BottomBubbleWindow> windowListWeakReference;
    public static int lastShowPosition = -1;
    public static String cacheOnLogin = null;
    private static Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: tv.danmaku.bili.ui.main2.BottomBubbleHelper.3
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            if (!(activity instanceof MainActivityV2)) {
                BottomBubbleHelper.dismissWindow(false);
                BLog.d(BottomBubbleHelper.TAG, "dismiss on going other page");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }
    };

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface GetBubbleCallback {
        void onGetFinish();
    }

    public static void checkShowBubble(final Activity activity, final TabHost tabHost, final TabHostHelper tabHostHelper, final GetBubbleCallback getBubbleCallback) {
        if (!checkCanLoad()) {
            if (getBubbleCallback != null) {
                getBubbleCallback.onGetFinish();
                return;
            }
            return;
        }
        Observable.create(new ObservableOnSubscribe() { // from class: tv.danmaku.bili.ui.main2.BottomBubbleHelper$$ExternalSyntheticLambda1
            public final void subscribe(ObservableEmitter observableEmitter) {
                observableEmitter.onNext(BottomBubbleHelper.getBubble());
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<String>() { // from class: tv.danmaku.bili.ui.main2.BottomBubbleHelper.1
            public void onComplete() {
            }

            public void onError(Throwable e) {
            }

            public void onSubscribe(Disposable d) {
            }

            public void onNext(String response) {
                BottomBubbleHelper.showWindowIfNeed(activity, response, tabHost, tabHostHelper);
                if (getBubbleCallback != null) {
                    getBubbleCallback.onGetFinish();
                }
            }
        });
    }

    private static boolean checkCanLoad() {
        if (BiliAccounts.get(BiliContext.application()).isLogin()) {
            if (sMid != BiliAccounts.get(BiliContext.application()).mid()) {
                BLog.d(TAG, "change account");
                sLastLoadTime = 0L;
            }
            if (System.currentTimeMillis() - sLastLoadTime < 300000) {
                BLog.d(TAG, "less than 5 minutes");
                return false;
            }
            sLastLoadTime = System.currentTimeMillis();
            sMid = BiliAccounts.get(BiliContext.application()).mid();
            return true;
        }
        return false;
    }

    public static void onChange(Topic topic) {
        if (topic == Topic.SIGN_IN && checkCanLoad()) {
            Observable.create(new ObservableOnSubscribe() { // from class: tv.danmaku.bili.ui.main2.BottomBubbleHelper$$ExternalSyntheticLambda0
                public final void subscribe(ObservableEmitter observableEmitter) {
                    observableEmitter.onNext(BottomBubbleHelper.getBubble());
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<String>() { // from class: tv.danmaku.bili.ui.main2.BottomBubbleHelper.2
                public void onComplete() {
                }

                public void onError(Throwable e) {
                }

                public void onSubscribe(Disposable d) {
                }

                public void onNext(String response) {
                    BottomBubbleHelper.cacheOnLogin = response;
                }
            });
        }
    }

    private static String getBubble() {
        if (EntryPointKt.getNetRequestOptEnable()) {
            BLog.i(TAG, "/x/resource/show/tab/bubble hit network request exp");
            return null;
        }
        GeneralResponse<String> bottomBubbleResponse = null;
        try {
            MainResourceManager.TabService tabService = (MainResourceManager.TabService) ServiceGenerator.createService(MainResourceManager.TabService.class);
            bottomBubbleResponse = (GeneralResponse) ExBilowUtil.extractResponse(tabService.getBubbleInfo(BiliAccounts.get(BiliContext.application()).getAccessKey()).execute());
        } catch (Exception e) {
        }
        if (bottomBubbleResponse != null) {
            return (String) bottomBubbleResponse.data;
        }
        return null;
    }

    public static void resetLastShow() {
        lastShowTime = 0L;
        lastShowId = null;
        lastShowPosition = -1;
    }

    public static void showWindowFromLoginCacheIfNeed(Activity activity, TabHost tabHost, TabHostHelper tabHostHelper) {
        BLog.d(TAG, "showWindowFromLoginCacheIfNeed, cache = " + cacheOnLogin);
        showWindowIfNeed(activity, cacheOnLogin, tabHost, tabHostHelper);
        cacheOnLogin = null;
    }

    private static boolean activityDie(Activity activity) {
        return activity == null || activity.isDestroyed() || activity.isFinishing();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void showWindowIfNeed(Activity activity, String response, TabHost tabHost, TabHostHelper tabHostHelper) {
        if (!TextUtils.isEmpty(response) && !activityDie(activity)) {
            JSONObject responseJSON = null;
            try {
                try {
                    responseJSON = new JSONObject(response);
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                    if (responseJSON == null) {
                    }
                }
            } catch (JSONException e2) {
                e = e2;
            }
            if (responseJSON == null) {
                long sTime = -1;
                int targetPosition = -1;
                MainResourceManager.TabBubbleItem tabBubbleItem = null;
                for (int i = 0; i < tabHost.getTabs().size(); i++) {
                    TabHost.TabInfo tabInfo = (TabHost.TabInfo) tabHost.getTabs().get(i);
                    BLog.d(TAG, "tabId = " + tabInfo.tabId);
                    JSONObject jsonObject = responseJSON.optJSONObject(String.valueOf(tabInfo.tabId));
                    if (jsonObject != null) {
                        MainResourceManager.TabBubbleItem item = (MainResourceManager.TabBubbleItem) com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), MainResourceManager.TabBubbleItem.class);
                        if (item.stime > sTime) {
                            sTime = item.stime;
                            tabBubbleItem = item;
                            targetPosition = i;
                        }
                    }
                }
                if (targetPosition >= 0) {
                    lastShowTime = System.currentTimeMillis();
                    lastShowId = String.valueOf(tabBubbleItem.id);
                    lastShowPosition = targetPosition;
                    if (windowListWeakReference != null && windowListWeakReference.get() != null) {
                        BLog.d(TAG, "dismiss previous");
                        windowListWeakReference.get().dismiss();
                    }
                    BLog.d(TAG, "begin show!");
                    BottomBubbleWindow window = new BottomBubbleWindow(activity, tabHost, tabBubbleItem, targetPosition);
                    window.show();
                    windowListWeakReference = new WeakReference<>(window);
                    tabHostHelper.hideBadge(targetPosition);
                    Garb garb = GarbManager.getGarbWithNightMode(activity);
                    if (garb.isPure() && !TextUtils.isEmpty(tabBubbleItem.cover)) {
                        tabHost.loadBubbleIcon(targetPosition, tabBubbleItem.cover, tabBubbleItem.uri, tabBubbleItem.id, BiliTheme.isNightTheme(activity));
                    }
                    mGarbId = garb.getId();
                    reportBubbleShow(String.valueOf(tabBubbleItem.id));
                    ((Application) activity.getApplicationContext()).registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
                }
            }
        }
    }

    public static long getCurbGarbId() {
        return mGarbId;
    }

    public static void setGarbId(long garbId) {
        mGarbId = garbId;
    }

    public static void dismissWindow(boolean withAnimation) {
        if (windowListWeakReference != null && windowListWeakReference.get() != null) {
            if (withAnimation) {
                windowListWeakReference.get().dismissWithAnimation();
            } else {
                windowListWeakReference.get().dismiss();
            }
        }
        removeLifecycleCallback();
        windowListWeakReference = null;
    }

    public static void dismissWindow(int tabPosition) {
        if (windowListWeakReference != null && windowListWeakReference.get() != null && windowListWeakReference.get().getPosition() == tabPosition) {
            dismissWindow(true);
            BLog.d(TAG, "dismiss on click tab");
        }
    }

    private static void removeLifecycleCallback() {
        if (BiliContext.application() != null) {
            BiliContext.application().unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public static void reportBubbleShow(String id) {
        Map<String, String> extension = new HashMap<>();
        extension.put("bubble_id", id);
        Neurons.reportExposure(false, EVENT_BUBBLE_SHOW, extension);
    }

    public static void reportBubbleClick(String id) {
        Map<String, String> extension = new HashMap<>();
        extension.put("bubble_id", id);
        extension.put("bubble_delay", String.valueOf(System.currentTimeMillis() - lastShowTime));
        Neurons.reportClick(false, EVENT_BUBBLE_CLICK, extension);
    }

    public static void reportBottomBarClick(int position, String tab) {
        reportBottomBarClick(position, tab, null, null);
    }

    public static void reportBottomBarClick(int position, String tab, String trackId, String sdkType) {
        Map<String, String> extension = new HashMap<>();
        extension.put(BaseFavoritesFragment.TAB, tab);
        if (!TextUtils.isEmpty(trackId)) {
            extension.put("track_id", trackId);
        }
        if (!TextUtils.isEmpty(sdkType)) {
            extension.put("sdk_type", sdkType);
        }
        if (lastShowPosition == position) {
            if (lastShowTime > 0 && System.currentTimeMillis() - lastShowTime <= 30000 && !TextUtils.isEmpty(lastShowId)) {
                extension.put("bubble_id", lastShowId);
                extension.put("bubble_delay", String.valueOf(System.currentTimeMillis() - lastShowTime));
            }
            resetLastShow();
        }
        Neurons.reportClick(false, EVENT_BOTTOM_BAR_CLICK, extension);
    }
}