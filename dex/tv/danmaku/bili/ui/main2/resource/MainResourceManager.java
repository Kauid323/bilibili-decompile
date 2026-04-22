package tv.danmaku.bili.ui.main2.resource;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import bolts.Continuation;
import bolts.Task;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.comm.restrict.RestrictedType;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.base.ipc.IPCAppStateManager;
import com.bilibili.bus.Violet;
import com.bilibili.homepage.HomeSideCenterTab;
import com.bilibili.homepage.HomeTabService;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.homepage.util.UriUtils;
import com.bilibili.okretro.BaseResponse;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import com.bilibili.okretro.utils.ExBilowUtil;
import com.bilibili.teenagersmode.TeenagersMode;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import retrofit2.http.BaseUrl;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tv.danmaku.android.log.BLog;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BuildConfig;
import tv.danmaku.bili.report.InfoEyesOperatingDataPublicQueryString;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.favorite.BaseFavoritesFragment;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.main.event.EventEntranceHelper;
import tv.danmaku.bili.ui.main2.MainTransaction;
import tv.danmaku.bili.ui.main2.api.TabDataUpdateEvent;
import tv.danmaku.bili.ui.main2.basic.TabBottomDataUpdateEvent;
import tv.danmaku.bili.ui.main2.basic.TabTopLeftDataUpdateEvent;
import tv.danmaku.bili.ui.main2.basic.story.HomeTopLeftStateHolderKt;
import tv.danmaku.bili.ui.main2.resource.MainResourceManager;

public class MainResourceManager {
    private static final Comparator COMP;
    private static final MainResourceManager INSTANCE;
    private static final long INTERVAL_FOR_BACKGROUND_UPDATE;
    public static final int REPORT_FROM_API = 0;
    public static final int REPORT_FROM_CACHE = 2;
    public static final int REPORT_FROM_PRESET = 1;
    private static final String TAG = "MainResourceManager";
    private static final int TYPE_PUBLISH_BUTTON = 3;
    public static HashMap<String, Boolean> sTabIsFollowBusMap;
    private final CachedResourceResolver mCachedResource = new CachedResourceResolver();
    private volatile DataWrapper<List<MoreCategoryItem>> mCategoryItemWrapper;
    private volatile DataWrapper<Config> mConfigDataWrapper;
    private volatile DataWrapper<List<MenuItem>> mHomeMenuWrapper;
    private volatile HomeNoLoginAvatar mHomeNoLoginAvatar;
    private volatile DataWrapper<List<SecondaryPage>> mHomeTabPageWrapper;
    private long mLastFetchTime;
    private IMenuChangeListener mMenuChangeListener;
    private volatile DataWrapper<List<PrimaryPage>> mPrimaryPageWrapper;
    private List<MenuItem> mShowingHomeTopMenus;
    private volatile DataWrapper<TopLeftInfo> mTopLeftInfoDataWrapper;
    private volatile PrimaryPage publishPage;

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class AnimateIcon {
        @JSONField(name = "icon")
        public String animatorIconUrl;
        @JSONField(name = "etime")
        public long etime;
        @JSONField(name = "json")
        public String lottieJsonUrl;
        @JSONField(name = "stime")
        public long stime;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Config {
        @JSONField(name = "no_login_avatar")
        public String noLoginAvatar;
        @JSONField(name = "no_login_avatar_type")
        public int noLoginAvatarType;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Extension {
        @JSONField(name = "active_type")
        public int activeAnimate;
        @JSONField(name = "active")
        public int activeResType;
        @JSONField(name = "active_icon")
        public String activeUrl;
        @JSONField(name = "bar_color")
        public int barColor;
        @JSONField(name = "tab_middle_color")
        public String bgCenterColor;
        @JSONField(name = "tab_bottom_color")
        public String bgEndColor;
        @JSONField(name = "tab_top_color")
        public String bgStartColor;
        @JSONField(name = "click")
        public ExtensionClick extensionClick;
        @JSONField(name = "font_color")
        public String fontColor;
        @JSONField(name = "inactive_type")
        public int inactiveAnimate;
        @JSONField(name = "inactive")
        public int inactiveResType;
        @JSONField(name = "inactive_icon")
        public String inactiveUrl;
        @JSONField(name = "is_follow_business")
        public boolean isFollowBusiness;
        @JSONField(name = "bg_image_2")
        public String tabBg;
        @JSONField(name = "bg_image_1")
        public String topBg;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class ExtensionClick {
        @JSONField(name = "id")
        public int id;
        @JSONField(name = "type")
        public String type;
        @JSONField(name = InfoEyesOperatingDataPublicQueryString.KEY_VER)
        public String ver;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface IMenuChangeListener {
        void onMenuChanged(List<MenuItem> list);
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class RedDot {
        @JSONField(name = "number")
        public int number;
        @JSONField(name = "type")
        public int type;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface ShowTabApiListener {
        void onNothingToSave();

        void onSuccessSaveToDisk(TabResponse tabResponse);
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class TabBubbleItem {
        public String cover;
        public long etime;
        public long id;
        public String param;
        public long stime;
        public String title;
        public String uri;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class TabData {
        @JSONField(name = "bottom")
        public List<Tab> bottom;
        @JSONField(name = "top_more")
        public List<Tab> moreCategory;
        @JSONField(name = BaseFavoritesFragment.TAB)
        public List<Tab> tab;
        @JSONField(name = "top")
        public List<Tab> top;
        @JSONField(name = "top_left")
        public TopLeftInfo topLeftInfo;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class TabResponse extends BaseResponse {
        @JSONField(name = "config")
        public Config config;
        @JSONField(name = "data")
        public TabData tabData;
        @JSONField(name = InfoEyesOperatingDataPublicQueryString.KEY_VER)
        public String version;
    }

    @BaseUrl("https://app.bilibili.com")
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface TabService {
        @GET("/x/resource/show/tab/bubble")
        BiliCall<GeneralResponse<String>> getBubbleInfo(@Query("access_key") String str);

        @GET("/x/resource/show/tab/v2")
        BiliCall<TabResponse> getTabs(@Query("access_key") String str, @Query("ver") String str2, @Query("interest_result") String str3);

        @FormUrlEncoded
        @POST("/x/resource/show/click")
        BiliCall<Void> showClick(@Field("id") String str, @Field("ver") String str2, @Field("type") String str3);
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class TopLeftBubble {
        @JSONField(name = "type")
        public int type;
        @JSONField(name = "text")
        public String text = null;
        @JSONField(name = "id")
        public long id = MainResourceManager.INTERVAL_FOR_BACKGROUND_UPDATE;
    }

    static {
        INTERVAL_FOR_BACKGROUND_UPDATE = com.bilibili.api.base.Config.isDebuggable() ? 300000L : 1800000L;
        COMP = new Comparator() { // from class: tv.danmaku.bili.ui.main2.resource.MainResourceManager$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return MainResourceManager.lambda$static$0((MainResourceManager.Tab) obj, (MainResourceManager.Tab) obj2);
            }
        };
        sTabIsFollowBusMap = new HashMap<>();
        INSTANCE = new MainResourceManager();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int lambda$static$0(Tab o1, Tab o2) {
        return o1.pos - o2.pos;
    }

    public void init() {
        RestrictedMode.registerLessonsChangeListener(new RestrictedMode.OnStateChangeListener() { // from class: tv.danmaku.bili.ui.main2.resource.MainResourceManager$$ExternalSyntheticLambda2
            public final void onChanged(boolean z) {
                MainResourceManager.this.m2130lambda$init$1$tvdanmakubiliuimain2resourceMainResourceManager(z);
            }
        });
        RestrictedMode.registerTeenagersChangeListener(new TeenagersMode.OnTeenagersModeChangeListener() { // from class: tv.danmaku.bili.ui.main2.resource.MainResourceManager.1
            public /* synthetic */ void onStateChange(boolean z, boolean z2, boolean z3) {
                TeenagersMode.OnTeenagersModeChangeListener.-CC.$default$onStateChange(this, z, z2, z3);
            }

            public void onStateChange(boolean isEnable, boolean isBizEnable) {
                EventEntranceHelper.initBroadcast();
            }

            public void onTeenagerModePageShow(boolean isShow) {
            }
        });
        fetchInBackGround(true);
        EventEntranceHelper.init();
        HomeTopLeftStateHolderKt.initTopLeftService();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$init$1$tv-danmaku-bili-ui-main2-resource-MainResourceManager  reason: not valid java name */
    public /* synthetic */ void m2130lambda$init$1$tvdanmakubiliuimain2resourceMainResourceManager(boolean isEnable) {
        resetToDefaultResource(TeenagersMode.getInstance().isEnable(), RestrictedMode.isLocalEnable(RestrictedType.LESSONS));
        fetchInBackGround(false);
        EventEntranceHelper.initBroadcast();
    }

    public void setMenuChangeListener(IMenuChangeListener menuChangeListener) {
        this.mMenuChangeListener = menuChangeListener;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.List, T] */
    public List<PrimaryPage> getPrimaryPages() {
        if (this.mPrimaryPageWrapper == null) {
            this.mPrimaryPageWrapper = new DataWrapper<>();
            this.mPrimaryPageWrapper.data = this.mCachedResource.forPrimaryPages();
            if (this.mPrimaryPageWrapper.data == null) {
                if (TeenagersMode.getInstance().isEnable()) {
                    this.mPrimaryPageWrapper.data = TeenagersModeResourceResolver.forPrimaryPages();
                } else if (RestrictedMode.isLocalEnable(RestrictedType.LESSONS)) {
                    this.mPrimaryPageWrapper.data = LessonsModeResourceResolver.forPrimaryPages();
                } else {
                    this.mPrimaryPageWrapper.data = DefaultResourceResolver.forPrimaryPages();
                }
            }
            this.mPrimaryPageWrapper.isApiRequested = true;
        }
        if (this.mPrimaryPageWrapper.isDataChange) {
            this.mPrimaryPageWrapper.isDataChange = false;
        }
        return this.mPrimaryPageWrapper.data;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List, T] */
    public List<PrimaryPage> getDefaultPrimaryPages() {
        if (this.mPrimaryPageWrapper == null) {
            this.mPrimaryPageWrapper = new DataWrapper<>();
        }
        if (TeenagersMode.getInstance().isEnable()) {
            this.mPrimaryPageWrapper.data = TeenagersModeResourceResolver.forPrimaryPages();
        } else if (RestrictedMode.isLocalEnable(RestrictedType.LESSONS)) {
            this.mPrimaryPageWrapper.data = LessonsModeResourceResolver.forPrimaryPages();
        } else {
            this.mPrimaryPageWrapper.data = DefaultResourceResolver.forPrimaryPages();
        }
        return this.mPrimaryPageWrapper.data;
    }

    public void setShowingHomeTopMenus(List<MenuItem> items) {
        this.mShowingHomeTopMenus = items;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.List, T] */
    public List<SecondaryPage> getHomeTabPages() {
        if (this.mHomeTabPageWrapper == null) {
            this.mHomeTabPageWrapper = new DataWrapper<>();
            this.mHomeTabPageWrapper.data = this.mCachedResource.forHomeTabPages();
            if (this.mHomeTabPageWrapper.data == null) {
                if (TeenagersMode.getInstance().isEnable()) {
                    this.mHomeTabPageWrapper.data = TeenagersModeResourceResolver.forHomeSubPages();
                } else if (RestrictedMode.isEnable(RestrictedType.LESSONS)) {
                    this.mHomeTabPageWrapper.data = LessonsModeResourceResolver.forHomeSubPages();
                } else {
                    this.mHomeTabPageWrapper.data = DefaultResourceResolver.forHomeSubPages();
                }
            }
            this.mHomeTabPageWrapper.isApiRequested = true;
        }
        if (this.mHomeTabPageWrapper.isDataChange) {
            this.mHomeTabPageWrapper.isDataChange = false;
        }
        return this.mHomeTabPageWrapper.data;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List, T] */
    public List<SecondaryPage> getDefaultHomeTabPages() {
        if (this.mHomeTabPageWrapper == null) {
            this.mHomeTabPageWrapper = new DataWrapper<>();
        }
        if (TeenagersMode.getInstance().isEnable()) {
            this.mHomeTabPageWrapper.data = TeenagersModeResourceResolver.forHomeSubPages();
        } else if (RestrictedMode.isEnable(RestrictedType.LESSONS)) {
            this.mHomeTabPageWrapper.data = LessonsModeResourceResolver.forHomeSubPages();
        } else {
            this.mHomeTabPageWrapper.data = DefaultResourceResolver.forHomeSubPages();
        }
        return this.mHomeTabPageWrapper.data;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.List, T] */
    public List<MenuItem> getHomeTopMenus() {
        if (this.mHomeMenuWrapper == null) {
            this.mHomeMenuWrapper = new DataWrapper<>();
            this.mHomeMenuWrapper.data = this.mCachedResource.forHomeTopMenus();
            if (this.mHomeMenuWrapper.data == null) {
                if (TeenagersMode.getInstance().isEnable()) {
                    this.mHomeMenuWrapper.data = TeenagersModeResourceResolver.forHomeTopMenus();
                } else if (RestrictedMode.isEnable(RestrictedType.LESSONS)) {
                    this.mHomeMenuWrapper.data = LessonsModeResourceResolver.forHomeTopMenus();
                } else {
                    this.mHomeMenuWrapper.data = DefaultResourceResolver.forHomeTopMenus();
                }
            }
            this.mHomeMenuWrapper.isApiRequested = true;
        }
        if (this.mHomeMenuWrapper.isDataChange) {
            this.mHomeMenuWrapper.isDataChange = false;
        }
        return this.mHomeMenuWrapper.data;
    }

    public HomeNoLoginAvatar getNoLoginAvatar() {
        if (this.mHomeNoLoginAvatar == null) {
            this.mHomeNoLoginAvatar = this.mCachedResource.forNoLoginAvatar();
        }
        return this.mHomeNoLoginAvatar;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, tv.danmaku.bili.ui.main2.resource.MainResourceManager$TopLeftInfo] */
    public TopLeftInfo getTopLeftInfo() {
        if (this.mTopLeftInfoDataWrapper == null) {
            this.mTopLeftInfoDataWrapper = new DataWrapper<>();
            this.mTopLeftInfoDataWrapper.data = this.mCachedResource.forTopLeftInfo();
        }
        return this.mTopLeftInfoDataWrapper.data;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.List, T] */
    public List<MoreCategoryItem> getMoreCategoryItem() {
        if (this.mCategoryItemWrapper == null) {
            this.mCategoryItemWrapper = new DataWrapper<>();
            this.mCategoryItemWrapper.data = this.mCachedResource.forMoreCategoryItem();
            if (this.mCategoryItemWrapper.data == null) {
                this.mCategoryItemWrapper.data = Arrays.asList(DefaultResourceResolver.forCategoryItem());
            }
        }
        this.mCategoryItemWrapper.isDataChange = false;
        return this.mCategoryItemWrapper.data;
    }

    public void markTopLeftNotChange() {
        if (this.mTopLeftInfoDataWrapper != null) {
            this.mTopLeftInfoDataWrapper.isDataChange = false;
        }
    }

    public boolean isTopLeftChange() {
        return this.mTopLeftInfoDataWrapper != null && this.mTopLeftInfoDataWrapper.isDataChange;
    }

    public boolean isBottomChange() {
        return this.mPrimaryPageWrapper != null && this.mPrimaryPageWrapper.isDataChange;
    }

    public boolean isHomeTabChange() {
        return this.mHomeTabPageWrapper != null && this.mHomeTabPageWrapper.isDataChange;
    }

    public boolean isTopMenuChange() {
        return this.mHomeMenuWrapper != null && this.mHomeMenuWrapper.isDataChange;
    }

    public boolean isCategoryChange() {
        return this.mCategoryItemWrapper != null && this.mCategoryItemWrapper.isDataChange;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.List, T] */
    public void resetToDefaultResource(boolean isTeenagersMode, boolean isLessonsMode) {
        CachedResourceResolver.clearCache();
        if (this.mPrimaryPageWrapper == null) {
            this.mPrimaryPageWrapper = new DataWrapper<>();
        }
        if (this.mHomeMenuWrapper == null) {
            this.mHomeMenuWrapper = new DataWrapper<>();
        }
        if (this.mHomeTabPageWrapper == null) {
            this.mHomeTabPageWrapper = new DataWrapper<>();
        }
        if (isTeenagersMode) {
            this.mPrimaryPageWrapper.data = TeenagersModeResourceResolver.forPrimaryPages();
            this.mHomeMenuWrapper.data = TeenagersModeResourceResolver.forHomeTopMenus();
            this.mHomeTabPageWrapper.data = TeenagersModeResourceResolver.forHomeSubPages();
        } else if (isLessonsMode) {
            this.mPrimaryPageWrapper.data = LessonsModeResourceResolver.forPrimaryPages();
            this.mHomeMenuWrapper.data = LessonsModeResourceResolver.forHomeTopMenus();
            this.mHomeTabPageWrapper.data = LessonsModeResourceResolver.forHomeSubPages();
        } else {
            this.mPrimaryPageWrapper.data = DefaultResourceResolver.forPrimaryPages();
            this.mHomeMenuWrapper.data = DefaultResourceResolver.forHomeTopMenus();
            this.mHomeTabPageWrapper.data = DefaultResourceResolver.forHomeSubPages();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, tv.danmaku.bili.ui.main2.resource.MainResourceManager$Config] */
    public Config getConfigData() {
        if (this.mConfigDataWrapper == null) {
            this.mConfigDataWrapper = new DataWrapper<>();
            this.mConfigDataWrapper.data = this.mCachedResource.forConfig();
        }
        return this.mConfigDataWrapper.data;
    }

    public boolean getAndResetPrimaryPageAPIFlag() {
        if (this.mPrimaryPageWrapper != null && this.mPrimaryPageWrapper.isApiRequested) {
            this.mPrimaryPageWrapper.isApiRequested = false;
            return true;
        }
        return false;
    }

    public boolean getAndResetHomeTabAPIFlag() {
        if (this.mHomeTabPageWrapper != null && this.mHomeTabPageWrapper.isApiRequested) {
            this.mHomeTabPageWrapper.isApiRequested = false;
            return true;
        }
        return false;
    }

    public void fetchInBackGround(final boolean coldStart, final String interestResult, final ShowTabApiListener listener) {
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.main2.resource.MainResourceManager$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return MainResourceManager.this.m2129lambda$fetchInBackGround$2$tvdanmakubiliuimain2resourceMainResourceManager(interestResult, listener, coldStart);
            }
        }).continueWith(new Continuation<UpdateInfo, Void>() { // from class: tv.danmaku.bili.ui.main2.resource.MainResourceManager.2
            private PassportObserver passportObserver = new PassportObserver() { // from class: tv.danmaku.bili.ui.main2.resource.MainResourceManager.2.1
                public void onChange(Topic topic) {
                    MainResourceManager.this.fetchInBackGround(false);
                    Context context = BiliContext.application();
                    if (context != null) {
                        BiliAccounts.get(context).unsubscribe(Topic.SIGN_IN, this);
                    }
                }
            };

            public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                return m2131then((Task<UpdateInfo>) task);
            }

            /* renamed from: then  reason: collision with other method in class */
            public Void m2131then(Task<UpdateInfo> task) throws Exception {
                if (MainResourceManager.this.mMenuChangeListener != null && task.getResult() != null) {
                    MainResourceManager.this.mMenuChangeListener.onMenuChanged(((UpdateInfo) task.getResult()).menuItems);
                }
                if (MainResourceManager.this.publishPage != null) {
                    Violet.INSTANCE.sendMsg(new TabBottomDataUpdateEvent(MainResourceManager.this.publishPage));
                }
                if (MainResourceManager.this.mTopLeftInfoDataWrapper != null && MainResourceManager.this.mTopLeftInfoDataWrapper.isDataChange) {
                    Violet.INSTANCE.sendMsg(new TabTopLeftDataUpdateEvent());
                }
                homeTabVisibleUpdate();
                return null;
            }

            private void homeTabVisibleUpdate() {
                Context context = BiliContext.application();
                if (context != null) {
                    BiliAccounts.get(context).unsubscribe(Topic.SIGN_IN, this.passportObserver);
                    Violet.INSTANCE.sendMsg(new TabDataUpdateEvent(true), false);
                }
            }
        }, Task.UI_THREAD_EXECUTOR);
        this.mLastFetchTime = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [T, tv.danmaku.bili.ui.main2.resource.MainResourceManager$Config] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.util.List, java.util.List<tv.danmaku.bili.ui.main2.resource.MenuItem>, T] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r12v1, types: [T, tv.danmaku.bili.ui.main2.resource.MainResourceManager$TopLeftInfo] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.List, T] */
    /* renamed from: lambda$fetchInBackGround$2$tv-danmaku-bili-ui-main2-resource-MainResourceManager  reason: not valid java name */
    public /* synthetic */ UpdateInfo m2129lambda$fetchInBackGround$2$tvdanmakubiliuimain2resourceMainResourceManager(String interestResult, ShowTabApiListener listener, boolean coldStart) throws Exception {
        boolean z;
        String interestIds;
        Context context = BiliContext.application();
        if (context == null) {
            return null;
        }
        String accessKey = BiliAccounts.get(context).getAccessKey();
        TabResponse tabResponse = null;
        try {
            TabService tabService = (TabService) ServiceGenerator.createService(TabService.class);
            if (interestResult != null) {
                interestIds = interestResult;
                HomeTabServiceImplKt.setSelectedInterestIds(interestResult);
            } else {
                interestIds = HomeTabServiceImplKt.getSelectedInterestIds();
            }
            tabResponse = (TabResponse) ExBilowUtil.extractResponse(tabService.getTabs(accessKey, null, interestIds).execute());
        } catch (Exception e) {
            BLog.i(TAG, e.getMessage());
        }
        if (BuildConfig.DEBUG && tabResponse != null && tabResponse.tabData != null && tabResponse.tabData.tab != null) {
            boolean oldPegasusEnable = BiliGlobalPreferenceHelper.getBLKVSharedPreference().getBoolean("sp_key_pegasus_show_old_pegasus_tab", false);
            Tab pegasusTab = null;
            Iterator<Tab> it = tabResponse.tabData.tab.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Tab tab = it.next();
                if (DefaultResourceResolver.HOME_PROMO.equals(tab.uri)) {
                    pegasusTab = tab;
                    break;
                }
            }
            if (!oldPegasusEnable) {
                pegasusTab = null;
            }
            if (pegasusTab != null) {
                Tab pegasusTab2 = (Tab) JSON.parseObject(JSON.toJSONString(pegasusTab), Tab.class);
                pegasusTab2.name = "老天马";
                pegasusTab2.selected = 0;
                pegasusTab2.uri = "bilibili://pegasus/promo?is_old=true";
                tabResponse.tabData.tab.add(2, pegasusTab2);
            }
        }
        if (tabResponse != null && tabResponse.code == 0 && tabResponse.tabData != null) {
            ?? forPrimaryPages = forPrimaryPages(tabResponse.tabData.bottom, 0);
            ?? forHomeTabPages = forHomeTabPages(tabResponse.tabData.tab, 0);
            ?? forHomeTopMenus = forHomeTopMenus(tabResponse.tabData.top, 0);
            HomeTabReporterKt.reportGetGameMenu(forHomeTopMenus);
            ?? forCategoryItem = forCategoryItem(tabResponse.tabData.moreCategory);
            ?? r12 = tabResponse.tabData.topLeftInfo;
            if (forPrimaryPages.size() >= 1 && forHomeTabPages.size() >= 1) {
                boolean saveSuccess = CachedResourceResolver.saveToDisk(tabResponse);
                if (listener != null) {
                    if (saveSuccess) {
                        listener.onSuccessSaveToDisk(tabResponse);
                    } else {
                        listener.onNothingToSave();
                    }
                }
                DataWrapper<TopLeftInfo> topLeftInfoData = new DataWrapper<>();
                topLeftInfoData.isApiRequested = true;
                topLeftInfoData.data = r12;
                topLeftInfoData.isDataChange = true;
                if (this.mTopLeftInfoDataWrapper != null) {
                    topLeftInfoData.isDataChange = this.mTopLeftInfoDataWrapper.isDataChange || isTopLeftChanged(this.mTopLeftInfoDataWrapper.data, r12);
                }
                this.mTopLeftInfoDataWrapper = topLeftInfoData;
                DataWrapper<List<SecondaryPage>> homeTabPageWrapper = new DataWrapper<>();
                homeTabPageWrapper.isApiRequested = true;
                homeTabPageWrapper.data = forHomeTabPages;
                if (this.mHomeTabPageWrapper != null) {
                    if (!this.mHomeTabPageWrapper.isDataChange && !forHomeTabPages.equals(this.mHomeTabPageWrapper.data)) {
                        homeTabPageWrapper.isDataChange = true;
                    } else {
                        homeTabPageWrapper.isDataChange = this.mHomeTabPageWrapper.isDataChange;
                    }
                }
                if (this.mConfigDataWrapper == null) {
                    this.mConfigDataWrapper = new DataWrapper<>();
                }
                this.mConfigDataWrapper.data = tabResponse.config;
                boolean discard = coldStart && this.mPrimaryPageWrapper != null;
                if (!discard) {
                    this.publishPage = null;
                    DataWrapper<List<PrimaryPage>> primaryPageWrapper = new DataWrapper<>();
                    primaryPageWrapper.isApiRequested = true;
                    primaryPageWrapper.data = forPrimaryPages;
                    if (this.mPrimaryPageWrapper != null) {
                        if (!this.mPrimaryPageWrapper.isDataChange && !forPrimaryPages.equals(this.mPrimaryPageWrapper.data)) {
                            primaryPageWrapper.isDataChange = true;
                        } else {
                            primaryPageWrapper.isDataChange = this.mPrimaryPageWrapper.isDataChange;
                        }
                    }
                    DataWrapper<List<MenuItem>> homeMenuWrapper = new DataWrapper<>();
                    homeMenuWrapper.isApiRequested = true;
                    homeMenuWrapper.data = forHomeTopMenus;
                    if (this.mHomeMenuWrapper != null) {
                        if (!this.mHomeMenuWrapper.isDataChange) {
                            if (!forHomeTopMenus.equals(this.mShowingHomeTopMenus == null ? this.mHomeMenuWrapper.data : this.mShowingHomeTopMenus)) {
                                homeMenuWrapper.isDataChange = true;
                            }
                        }
                        homeMenuWrapper.isDataChange = this.mHomeMenuWrapper.isDataChange;
                    }
                    String finishGameIconString = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getString("top_game_lottie_finish", null);
                    Iterator it2 = forHomeTopMenus.iterator();
                    List<SecondaryPage> secondaryPages = forHomeTabPages;
                    List<MenuItem> menuItems = forHomeTopMenus;
                    while (it2.hasNext()) {
                        Iterator it3 = it2;
                        MenuItem menuItem = (MenuItem) it2.next();
                        List<SecondaryPage> secondaryPages2 = secondaryPages;
                        List<MenuItem> menuItems2 = menuItems;
                        if (UriUtils.equals(menuItem.url, "action://game_center/home/menu") && !UriUtils.equals(menuItem.animatorIconUrl, finishGameIconString)) {
                            BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putString("top_game_lottie_finish", null).apply();
                        }
                        secondaryPages = secondaryPages2;
                        it2 = it3;
                        menuItems = menuItems2;
                    }
                    this.mHomeNoLoginAvatar = forNoLoginAvatar(tabResponse.config);
                    DataWrapper<List<MoreCategoryItem>> categoryItemWrapper = new DataWrapper<>();
                    categoryItemWrapper.isApiRequested = true;
                    categoryItemWrapper.data = forCategoryItem;
                    if (this.mCategoryItemWrapper != null) {
                        if (!this.mCategoryItemWrapper.isDataChange && !compareCategory(forCategoryItem, this.mCategoryItemWrapper.data)) {
                            categoryItemWrapper.isDataChange = true;
                        } else {
                            categoryItemWrapper.isDataChange = this.mCategoryItemWrapper.isDataChange;
                        }
                    }
                    this.mPrimaryPageWrapper = primaryPageWrapper;
                    this.mHomeTabPageWrapper = homeTabPageWrapper;
                    this.mHomeMenuWrapper = homeMenuWrapper;
                    this.mCategoryItemWrapper = categoryItemWrapper;
                    return null;
                }
                for (PrimaryPage currentPage : this.mPrimaryPageWrapper.data) {
                    boolean discard2 = discard;
                    if (currentPage.isPublish) {
                        Iterator it4 = forPrimaryPages.iterator();
                        while (it4.hasNext()) {
                            Iterator it5 = it4;
                            PrimaryPage respPage = (PrimaryPage) it4.next();
                            String accessKey2 = accessKey;
                            if (respPage.isPublish && !currentPage.equals(respPage)) {
                                this.publishPage = respPage;
                            }
                            accessKey = accessKey2;
                            it4 = it5;
                        }
                    }
                    discard = discard2;
                    accessKey = accessKey;
                }
                if ("1".equals(ConfigManager.config().get("home.menu_update_enable", "0"))) {
                    if (!forHomeTopMenus.equals(this.mShowingHomeTopMenus == null ? this.mCachedResource.forHomeTopMenus() : this.mShowingHomeTopMenus)) {
                        UpdateInfo updateInfo = new UpdateInfo();
                        updateInfo.menuItems = forHomeTopMenus;
                        if (this.mHomeMenuWrapper != null) {
                            this.mHomeMenuWrapper.data = forHomeTopMenus;
                        }
                        return updateInfo;
                    }
                }
                if (isHotUpdateEnable()) {
                    this.mHomeTabPageWrapper = homeTabPageWrapper;
                    this.mHomeTabPageWrapper.isApiRequested = true;
                    return null;
                }
                return null;
            } else if (listener != null) {
                listener.onNothingToSave();
            }
        } else if (listener != null) {
            listener.onNothingToSave();
        }
        if (this.mPrimaryPageWrapper == null) {
            z = true;
        } else {
            z = true;
            this.mPrimaryPageWrapper.isApiRequested = true;
        }
        if (this.mHomeTabPageWrapper != null) {
            this.mHomeTabPageWrapper.isApiRequested = z;
        }
        if (this.mHomeMenuWrapper != null) {
            this.mHomeMenuWrapper.isApiRequested = z;
            return null;
        }
        return null;
    }

    public void fetchInBackGround(boolean coldStart) {
        fetchInBackGround(coldStart, null, null);
    }

    private boolean compareCategory(List<MoreCategoryItem> item1, List<MoreCategoryItem> item2) {
        if (item1 == null && item2 == null) {
            return true;
        }
        if (item1 != null && item2 != null) {
            return item1.equals(item2);
        }
        return false;
    }

    private boolean isTopLeftChanged(TopLeftInfo a, TopLeftInfo b) {
        if (a == null && b == null) {
            return false;
        }
        if (a == null || b == null) {
            return true;
        }
        return a.equals(b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class UpdateInfo {
        public List<MenuItem> menuItems;

        private UpdateInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<PrimaryPage> forPrimaryPages(List<Tab> bottomMenus, int from) {
        if (bottomMenus == null || bottomMenus.isEmpty()) {
            return Collections.emptyList();
        }
        Collections.sort(bottomMenus, COMP);
        List<PrimaryPage> pages = new ArrayList<>();
        for (Tab tab : bottomMenus) {
            PrimaryPage page = new PrimaryPage();
            page.id = tab.tabId;
            page.title = tab.name;
            page.url = mapping(tab.uri);
            page.normalIcon = tab.icon;
            page.selectedIcon = tab.iconSelected;
            page.reporterId = tab.reportId;
            page.reporterPos = String.valueOf(tab.pos);
            page.from = from;
            page.icon = DefaultResourceResolver.getTabIcon(page.url);
            page.dialogItems = tab.dialogItems;
            page.isPublish = tab.type == 3;
            if (page.isPublish) {
                if (!TeenagersMode.getInstance().isEnable() && !RestrictedMode.isLocalEnable(RestrictedType.LESSONS)) {
                    pages.add(page);
                }
            } else if (page.checkParams() && checkPrimaryPage(tab)) {
                pages.add(page);
            }
        }
        return pages;
    }

    private static boolean checkPrimaryPageForLessonsMode(Tab tab) {
        if (RestrictedMode.isLocalEnable(RestrictedType.LESSONS)) {
            String uri = tab.uri;
            if (UriUtils.equals(uri, DefaultResourceResolver.MALL) && RestrictedMode.isEnable(RestrictedType.LESSONS, "mall_tab")) {
                return false;
            }
            if (UriUtils.equals(uri, DefaultResourceResolver.MALL_HOMEPAGE) && RestrictedMode.isEnable(RestrictedType.LESSONS, "mall_tab")) {
                return false;
            }
            if (UriUtils.equals(uri, DefaultResourceResolver.CHANNEL) && RestrictedMode.isEnable(RestrictedType.LESSONS, "channel_tab")) {
                return false;
            }
            if (UriUtils.equals(uri, DefaultResourceResolver.FOLLOWING) && RestrictedMode.isEnable(RestrictedType.LESSONS, "dynamic_tab")) {
                return false;
            }
            return TextUtils.isEmpty(uri) || !uri.startsWith(DefaultResourceResolver.ACTIVITY);
        }
        return true;
    }

    private static boolean checkPrimaryPage(Tab tab) {
        if (!TeenagersMode.getInstance().isEnable()) {
            return checkPrimaryPageForLessonsMode(tab);
        }
        String uri = tab.uri;
        if (UriUtils.equals(uri, DefaultResourceResolver.MALL) && TeenagersMode.getInstance().getEntranceState("mall") == 0) {
            return false;
        }
        if (UriUtils.equals(uri, DefaultResourceResolver.MALL_HOMEPAGE) && TeenagersMode.getInstance().getEntranceState("mall") == 0) {
            return false;
        }
        if (UriUtils.equals(uri, DefaultResourceResolver.CHANNEL) && TeenagersMode.getInstance().getEntranceState("channel") == 0) {
            return false;
        }
        if (UriUtils.equals(uri, DefaultResourceResolver.FOLLOWING) && TeenagersMode.getInstance().getEntranceState("dynamic") == 0) {
            return false;
        }
        return TextUtils.isEmpty(uri) || !uri.startsWith(DefaultResourceResolver.ACTIVITY);
    }

    static HomeNoLoginAvatar forNoLoginAvatar(Config config) {
        if (config != null) {
            return new HomeNoLoginAvatar(config.noLoginAvatar, config.noLoginAvatarType);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<MenuItem> forHomeTopMenus(List<Tab> topMenu, int from) {
        if (topMenu == null || topMenu.isEmpty()) {
            return Collections.emptyList();
        }
        Collections.sort(topMenu, COMP);
        ArrayList<MenuItem> menus = new ArrayList<>();
        for (Tab tab : topMenu) {
            MenuItem menu = new MenuItem();
            menu.id = tab.tabId;
            menu.title = tab.name;
            menu.url = mapping(tab.uri);
            menu.iconUrl = tab.icon;
            menu.reporterId = tab.reportId;
            menu.reporterPos = String.valueOf(tab.pos);
            menu.from = from;
            menu.icon = DefaultResourceResolver.getTabIcon(menu.url);
            if (tab.redDot != null) {
                menu.type = tab.redDot.type;
                menu.count = tab.redDot.number;
            }
            if (tab.animateIcon != null) {
                long now = System.currentTimeMillis() / 1000;
                if (tab.animateIcon.stime == INTERVAL_FOR_BACKGROUND_UPDATE || tab.animateIcon.etime == INTERVAL_FOR_BACKGROUND_UPDATE || (now >= tab.animateIcon.stime && now <= tab.animateIcon.etime)) {
                    menu.animatorIconUrl = tab.animateIcon.animatorIconUrl;
                    menu.lottieJsonUrl = tab.animateIcon.lottieJsonUrl;
                }
            }
            if (menu.checkParams() && checkHomeTop(tab)) {
                menus.add(menu);
            }
        }
        return menus;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<MoreCategoryItem> forCategoryItem(List<Tab> categories) {
        if (categories == null || categories.isEmpty() || TeenagersMode.getInstance().getEntranceState("channel") == 0) {
            return null;
        }
        List<MoreCategoryItem> categoryList = new ArrayList<>();
        for (Tab tab : categories) {
            if (tab != null) {
                if ("搜索".equals(tab.name)) {
                    categoryList.add(new MoreCategoryItem(tab.uri, tab.icon, 2));
                } else {
                    categoryList.add(new MoreCategoryItem(tab.uri, tab.icon));
                }
            }
        }
        return categoryList;
    }

    private static boolean checkHomeTop(Tab tab) {
        if (!TeenagersMode.getInstance().isEnable() || TeenagersMode.getInstance().getEntranceState("common") == 1) {
            return checkHomeTopForLessonsMode(tab);
        }
        return (UriUtils.equals(tab.uri, "bilibili://game_center/home") && TeenagersMode.getInstance().getEntranceState(AppConfig.HOST_GAME) == 0) ? false : true;
    }

    private static boolean checkHomeTopForLessonsMode(Tab tab) {
        return (RestrictedMode.isLocalEnable(RestrictedType.LESSONS) && UriUtils.equals(tab.uri, "bilibili://game_center/home") && RestrictedMode.isEnable(RestrictedType.LESSONS, AppConfig.HOST_GAME)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<SecondaryPage> forHomeTabPages(List<Tab> homeTab, int from) {
        if (homeTab == null || homeTab.isEmpty()) {
            return Collections.emptyList();
        }
        Collections.sort(homeTab, COMP);
        ArrayList<SecondaryPage> secondaryPages = new ArrayList<>();
        sTabIsFollowBusMap.clear();
        for (Tab tab : homeTab) {
            SecondaryPage secondaryPage = new SecondaryPage();
            secondaryPage.id = tab.tabId;
            secondaryPage.title = tab.name;
            secondaryPage.url = mapping(tab.uri);
            secondaryPage.defaultSelected = tab.selected == 1;
            secondaryPage.reporterId = tab.reportId;
            secondaryPage.reporterPos = String.valueOf(tab.pos);
            secondaryPage.from = from;
            secondaryPage.extension = tab.extension;
            secondaryPage.topTabBubble = tab.topTabBubble;
            secondaryPage.topTabClickAnim = tab.topTabClickAnim;
            if (secondaryPage.checkParams() && checkHomeTab(tab)) {
                secondaryPages.add(secondaryPage);
                if (secondaryPage.extension != null) {
                    sTabIsFollowBusMap.put(secondaryPage.url, Boolean.valueOf(secondaryPage.extension.isFollowBusiness));
                }
            }
        }
        return secondaryPages;
    }

    private static boolean checkHomeTab(Tab tab) {
        if (!TeenagersMode.getInstance().isEnable()) {
            return checkHomeTabForLessonsMode(tab);
        }
        String uri = tab.uri;
        if (UriUtils.equals(uri, DefaultResourceResolver.HOME_PROMO)) {
            return true;
        }
        if (UriUtils.equals(uri, DefaultResourceResolver.HOME_LIVE) && TeenagersMode.getInstance().getEntranceState("home_live") == 1) {
            return true;
        }
        if ((UriUtils.equals(uri, DefaultResourceResolver.HOME_BANGUMI) || UriUtils.equals(uri, DefaultResourceResolver.HOME_BANGUMI_V2)) && isBangumiTabEnable()) {
            return true;
        }
        return ((UriUtils.equals(uri, DefaultResourceResolver.HOME_CINEMA_TAB) || UriUtils.equals(uri, DefaultResourceResolver.HOME_CINEMA_TAB_V2)) && isCinemaTabEnable()) || TeenagersMode.getInstance().getEntranceState("common") == 1;
    }

    private static boolean checkHomeTabForLessonsMode(Tab tab) {
        if (RestrictedMode.isLocalEnable(RestrictedType.LESSONS)) {
            String uri = tab.uri;
            if (TextUtils.equals(uri, DefaultResourceResolver.HOME_BANGUMI) && RestrictedMode.isEnable(RestrictedType.LESSONS, "home_bangumi")) {
                return false;
            }
            if (TextUtils.equals(uri, DefaultResourceResolver.HOME_HOTTOPIC) && RestrictedMode.isEnable(RestrictedType.LESSONS)) {
                return false;
            }
            return (TextUtils.equals(uri, DefaultResourceResolver.HOME_CINEMA) && RestrictedMode.isEnable(RestrictedType.LESSONS)) ? false : true;
        }
        return true;
    }

    public void addIPCActivityCallback() {
        IPCAppStateManager.getInstance().addIPCActivityStateCallback(new IPCAppStateManager.GlobalVisibilityChangeCallback() { // from class: tv.danmaku.bili.ui.main2.resource.MainResourceManager.3
            public void onBackground() {
                if (SystemClock.elapsedRealtime() - MainResourceManager.this.mLastFetchTime > MainResourceManager.INTERVAL_FOR_BACKGROUND_UPDATE) {
                    MainResourceManager.this.fetchInBackGround(false);
                }
            }

            public void onForeground() {
                BLog.d(MainResourceManager.TAG, "onForeground");
                HomeTabService homeTabService = (HomeTabService) BLRouter.INSTANCE.get(HomeTabService.class, "HOME_TAB_SERVICE");
                if (homeTabService != null) {
                    homeTabService.tryUpdateHomeTab();
                }
            }
        });
    }

    private boolean isHotUpdateEnable() {
        HomeTabService homeTabService = (HomeTabService) BLRouter.INSTANCE.get(HomeTabService.class, "HOME_TAB_SERVICE");
        if (homeTabService != null) {
            return homeTabService.isHotUpdateEnable();
        }
        return false;
    }

    private static boolean isCinemaTabEnable() {
        try {
            String enable = DeviceDecision.INSTANCE.dd("dd.teenagers_mode_enable_cinema_biz", "true");
            return "true".equals(enable);
        } catch (Exception e) {
            BLog.e(TAG, "isCinemaTabEnable -> error = " + e);
            return false;
        }
    }

    private static boolean isBangumiTabEnable() {
        try {
            String enable = DeviceDecision.INSTANCE.dd("dd.teenagers_mode_enable_bangumi_biz", "true");
            return "true".equals(enable);
        } catch (Exception e) {
            BLog.e(TAG, "isBangumiTabEnable -> error = " + e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class DataWrapper<T> {
        public volatile T data;
        public volatile boolean isApiRequested;
        public volatile boolean isDataChange;

        private DataWrapper() {
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class TopLeftInfo {
        @JSONField(name = "bubbles")
        public List<TopLeftBubble> bubbles = null;
        @JSONField(name = "game_background_image")
        public String gameBackgroundImage;
        @JSONField(name = "game_foreground_image")
        public String gameForegroundImage;
        @JSONField(name = "goto")
        public int gotoFlag;
        @JSONField(name = "has_recent_tab")
        public int hasRecentTab;
        @JSONField(name = "listen_background_image")
        public String podcastBackgroundImage;
        @JSONField(name = "listen_foreground_image")
        public String podcastForegroundImage;
        @JSONField(name = "story_background_image")
        public String storyBackgroundImage;
        @JSONField(name = "story_foreground_image")
        public String storyForegroundImage;
        @JSONField(name = "url")
        public String url;

        public boolean hitAvatarAndStoryBadgeExp() {
            return !hitRecentTabExp() && (this.gotoFlag == 2 || this.gotoFlag == 3);
        }

        public boolean hitRecentTabExp() {
            return this.hasRecentTab == 1 || HomeTopLeftStateHolderKt.getNewContainerCurrentTabFromLocal() != HomeSideCenterTab.UNKNOWN;
        }

        public String toString() {
            return "TopLeftInfo{hasRecentTab=" + this.hasRecentTab + ", storyForegroundImage='" + this.storyForegroundImage + "', storyBackgroundImage='" + this.storyBackgroundImage + "', podcastForegroundImage='" + this.podcastForegroundImage + "', podcastBackgroundImage='" + this.podcastBackgroundImage + "', gameForegroundImage='" + this.gameForegroundImage + "', gameBackgroundImage='" + this.gameBackgroundImage + "', url='" + this.url + "', gotoFlag=" + this.gotoFlag + '}';
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            TopLeftInfo that = (TopLeftInfo) o;
            if (this.hasRecentTab == that.hasRecentTab && this.gotoFlag == that.gotoFlag && Objects.equals(this.storyForegroundImage, that.storyForegroundImage) && Objects.equals(this.storyBackgroundImage, that.storyBackgroundImage) && Objects.equals(this.podcastForegroundImage, that.podcastForegroundImage) && Objects.equals(this.podcastBackgroundImage, that.podcastBackgroundImage) && Objects.equals(this.gameForegroundImage, that.gameForegroundImage) && Objects.equals(this.gameBackgroundImage, that.gameBackgroundImage) && Objects.equals(this.url, that.url)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.hasRecentTab), this.storyForegroundImage, this.storyBackgroundImage, this.podcastForegroundImage, this.podcastBackgroundImage, this.gameForegroundImage, this.gameBackgroundImage, this.url, Integer.valueOf(this.gotoFlag)});
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Tab implements IHomeTab {
        @JSONField(name = "animate_icon")
        public AnimateIcon animateIcon;
        @JSONField(name = "dialog_items")
        public List<DialogItem> dialogItems;
        @JSONField(name = "expired_at")
        public long expiredAt;
        @JSONField(name = "extension")
        public Extension extension;
        @JSONField(name = "icon")
        public String icon;
        @JSONField(name = "icon_selected")
        public String iconSelected;
        @JSONField(name = ChannelRoutes.CHANNEL_NAME)
        public String name;
        @JSONField(name = FavoritesConstsKt.POS)
        public int pos;
        @JSONField(name = "red_dot")
        public RedDot redDot;
        @JSONField(name = MainTransaction.ARGS_ANCHOR_TAB_ID)
        public String reportId;
        @JSONField(name = "default_selected")
        public int selected;
        @JSONField(name = "id")
        public String tabId;
        @JSONField(name = "tab_bubble")
        public List<TopTabBubble> topTabBubble;
        @JSONField(name = "click_animation")
        public TopTabClickAnim topTabClickAnim;
        @JSONField(name = "type")
        public int type;
        @JSONField(name = AudioIntentHelper.ARGS_URI)
        public String uri;

        @Override // tv.danmaku.bili.ui.main2.resource.IHomeTab
        @JSONField(deserialize = false, serialize = false)
        public String getReporterId() {
            return this.reportId;
        }

        @Override // tv.danmaku.bili.ui.main2.resource.IHomeTab
        @JSONField(deserialize = false, serialize = false)
        public void setReporterId(String s) {
            this.reportId = s;
        }

        @Override // tv.danmaku.bili.ui.main2.resource.IHomeTab
        @JSONField(deserialize = false, serialize = false)
        public boolean getDefaultSelected() {
            return this.selected == 1;
        }

        @Override // tv.danmaku.bili.ui.main2.resource.IHomeTab
        @JSONField(deserialize = false, serialize = false)
        public void setDefaultSelected(boolean b) {
            this.selected = b ? 1 : 0;
        }

        public String toString() {
            return "Tab{name='" + this.name + "', uri='" + this.uri + "', selected=" + this.selected + ", reportId='" + this.reportId + "', expiredAt=" + this.expiredAt + '}';
        }

        @Override // tv.danmaku.bili.ui.main2.resource.IHomeTab
        @JSONField(deserialize = false, serialize = false)
        public int getPos() {
            return this.pos;
        }

        @Override // tv.danmaku.bili.ui.main2.resource.IHomeTab
        @JSONField(deserialize = false, serialize = false)
        public void setPos(int i) {
            this.pos = i;
        }

        @Override // tv.danmaku.bili.ui.main2.resource.IHomeTab
        @JSONField(deserialize = false, serialize = false)
        public long getExpiredAt() {
            return this.expiredAt;
        }

        @Override // tv.danmaku.bili.ui.main2.resource.IHomeTab
        @JSONField(deserialize = false, serialize = false)
        public void setExpiredAt(long l) {
            this.expiredAt = l;
        }

        @Override // tv.danmaku.bili.ui.main2.resource.IHomeTab
        @JSONField(deserialize = false, serialize = false)
        public String getUri() {
            return this.uri;
        }

        @Override // tv.danmaku.bili.ui.main2.resource.IHomeTab
        @JSONField(deserialize = false, serialize = false)
        public void setUri(String s) {
            this.uri = s;
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class TopTabBubble {
        @JSONField(name = "etime")
        public long endTime;
        @JSONField(name = "icon")
        public String icon;
        @JSONField(name = "id")
        public long id;
        @JSONField(name = "stime")
        public long startTime;
        @JSONField(name = "url")
        public String url;

        public boolean isValid() {
            return (TextUtils.isEmpty(this.icon) || TextUtils.isEmpty(this.url)) ? false : true;
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class TopTabClickAnim {
        @JSONField(name = "etime")
        public long endTime;
        @JSONField(name = "file")
        public String file;
        @JSONField(name = "id")
        public long id;
        @JSONField(name = "stime")
        public long startTime;

        public boolean isValid() {
            return !TextUtils.isEmpty(this.file);
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class DialogItem {
        public int defaultIconRes;
        @JSONField(name = "op_icon")
        public DialogMngItem dialogMngItem;
        @JSONField(name = "icon")
        public String iconUrl;
        @JSONField(name = "id")
        public long id;
        @JSONField(name = ChannelRoutes.CHANNEL_NAME)
        public String name;
        @JSONField(name = FavoritesConstsKt.POS)
        public int pos;
        @JSONField(name = AudioIntentHelper.ARGS_URI)
        public String uri;

        public DialogItem() {
        }

        public DialogItem(String name, String uri, int defaultIconRes) {
            this.name = name;
            this.defaultIconRes = defaultIconRes;
            this.uri = uri;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            DialogItem that = (DialogItem) o;
            if (this.id != that.id || this.pos != that.pos) {
                return false;
            }
            if (this.name == null ? that.name != null : !this.name.equals(that.name)) {
                return false;
            }
            if (this.iconUrl == null ? that.iconUrl != null : !this.iconUrl.equals(that.iconUrl)) {
                return false;
            }
            if (this.uri == null ? that.uri != null : !this.uri.equals(that.uri)) {
                return false;
            }
            if (this.dialogMngItem != null) {
                return this.dialogMngItem.equals(that.dialogMngItem);
            }
            if (that.dialogMngItem == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int result = (int) (this.id ^ (this.id >>> 32));
            return (((((((((result * 31) + (this.name != null ? this.name.hashCode() : 0)) * 31) + (this.iconUrl != null ? this.iconUrl.hashCode() : 0)) * 31) + (this.uri != null ? this.uri.hashCode() : 0)) * 31) + this.pos) * 31) + (this.dialogMngItem != null ? this.dialogMngItem.hashCode() : 0);
        }

        public boolean isValid() {
            return (TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.uri) || TextUtils.isEmpty(this.iconUrl)) ? false : true;
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class DialogMngItem {
        public String id;
        @JSONField(name = "ftime")
        public long inValidEndTime;
        @JSONField(name = "etime")
        public long inValidStartTime;
        @JSONField(name = "icon")
        public String mngIconUrl;

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            DialogMngItem that = (DialogMngItem) o;
            if (this.inValidEndTime != that.inValidEndTime || this.inValidStartTime != that.inValidStartTime) {
                return false;
            }
            if (this.id == null ? that.id != null : !this.id.equals(that.id)) {
                return false;
            }
            if (this.mngIconUrl != null) {
                return this.mngIconUrl.equals(that.mngIconUrl);
            }
            if (that.mngIconUrl == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int result = this.id != null ? this.id.hashCode() : 0;
            return (((((result * 31) + (this.mngIconUrl != null ? this.mngIconUrl.hashCode() : 0)) * 31) + ((int) (this.inValidEndTime ^ (this.inValidEndTime >>> 32)))) * 31) + ((int) (this.inValidStartTime ^ (this.inValidStartTime >>> 32)));
        }
    }

    private static String mapping(String oUrl) {
        String oUrl2 = UriUtils.trimSlash(oUrl);
        if (oUrl2 == null) {
            return "";
        }
        if (UriUtils.equals(oUrl2, "bilibili://game_center/home")) {
            String tUrl = concatQuery(oUrl2, "action://game_center/home/menu");
            return tUrl;
        } else if (UriUtils.equals(oUrl2, "bilibili://link/im_home")) {
            String tUrl2 = concatQuery(oUrl2, DefaultResourceResolver.MENU_IM);
            return tUrl2;
        } else {
            return oUrl2;
        }
    }

    private static String concatQuery(String oUrl, String targetUrl) {
        String encodedQuery = Uri.parse(oUrl).getEncodedQuery();
        return Uri.parse(targetUrl).buildUpon().encodedQuery(encodedQuery).build().toString();
    }

    private MainResourceManager() {
    }

    public static MainResourceManager getInstance() {
        return INSTANCE;
    }
}