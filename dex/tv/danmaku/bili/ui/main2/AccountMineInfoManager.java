package tv.danmaku.bili.ui.main2;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import bili.resource.playerbaseres.R;
import bolts.CancellationTokenSource;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.homepage.mine.IMinePageInfo;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.lib.projection.internal.utils.ProjectionClientUtilsKt;
import com.bilibili.moduleservice.upper.UpperService;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.utils.ExBilowUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.main2.api.AccountApiService;
import tv.danmaku.bili.ui.main2.api.AccountMine;
import tv.danmaku.bili.ui.main2.mine.MineInfoItemHelperKt;
import tv.danmaku.bili.ui.main2.mine.MinePrefHelper;
import tv.danmaku.bili.ui.main2.mine.provider.DefaultMineSolution;
import tv.danmaku.bili.ui.main2.mine.provider.FavoritesMineSolution;
import tv.danmaku.bili.ui.main2.mine.provider.FreeDataMineSolution;
import tv.danmaku.bili.ui.main2.mine.provider.GameCenterMineSolution;
import tv.danmaku.bili.ui.main2.mine.provider.LessonsMineSolution;
import tv.danmaku.bili.ui.main2.mine.provider.LiveMineSolution;
import tv.danmaku.bili.ui.main2.mine.provider.MallMineSolution;
import tv.danmaku.bili.ui.main2.mine.provider.OfflineMineSolution;
import tv.danmaku.bili.ui.main2.mine.provider.ParentControlModeSolution;
import tv.danmaku.bili.ui.main2.mine.provider.TeenagersMineSolution;
import tv.danmaku.bili.ui.main2.mine.provider.UperAcademyMineSolution;
import tv.danmaku.bili.ui.main2.mine.provider.UperCenterMineSolution;
import tv.danmaku.bili.ui.main2.mine.provider.UperHotMineSolution;
import tv.danmaku.bili.ui.main2.mine.provider.UperUploadMineSolution;
import tv.danmaku.bili.ui.main2.mine.provider.WalletMineSolution;
import tv.danmaku.bili.ui.main2.mine.provider.WatchLaterMineSolution;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;
import tv.danmaku.bili.ui.notice.NoticeCacheService;
import tv.danmaku.bili.ui.notice.NoticeExtKt;

public final class AccountMineInfoManager {
    private static final String PAGE_FAVORITE = "bilibili://main/drawer/favorites";
    private static final String PAGE_FREEDATA = "bilibili://main/drawer/freedata";
    private static final String PAGE_GAME_CENTER = "bilibili://game_center/user";
    private static final String PAGE_GAME_CENTER_HOME = "bilibili://game_center/home";
    private static final String PAGE_HISTORY = "bilibili://main/drawer/history";
    private static final String PAGE_LESSONS_MODE = "bilibili://user_center/lessonsmode";
    private static final String PAGE_LIVECENTER = "bilibili://main/drawer/live-center";
    private static final String PAGE_MAIN = "bilibili://main/drawer/main-page";
    private static final String PAGE_MALL_CENTER = "bilibili://mall/mine";
    private static final String PAGE_MINE_ORDER = "bilibili://mall/order/list";
    private static final String PAGE_NAME = "mine";
    private static final String PAGE_OFFLINE = "bilibili://main/drawer/offline";
    public static final String PAGE_SETTING = "activity://main/preference";
    private static final String PAGE_TEENAGERS_MODE = "bilibili://user_center/teenagersmode";
    private static final String PAGE_TEEN_PARENT_MODE = "https://www.bilibili.com/h5/teenagers/home";
    private static final String PAGE_UPPER = "bilibili://main/drawer/upper";
    private static final String PAGE_UPPER_ACADEMY = "bilibili://main/drawer/upper-academy";
    private static final String PAGE_UPPER_HOT = "bilibili://main/drawer/upper-hot";
    private static final String PAGE_UPPER_UPLOAD = "bilibili://main/drawer/upper-upload";
    private static final String PAGE_WALLET = "bilibili://bilipay/mine_wallet";
    private static final String PAGE_WATCHLATER = "bilibili://main/drawer/watch-later";
    private static final String TAG = "AccountMineInfoManager";
    private static final AccountMineInfoManager defaultInstance = new AccountMineInfoManager();
    private AccountMine mCache;
    private boolean mIsRefreshsing;
    private CancellationTokenSource mRefreshToken;
    private Set<String> mDrawerMenuRedDotCount = new HashSet();
    private NoticeCacheService noticeCacheService = NoticeCacheService.ofTips();

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface LocalMineInfoLoadListener {
        void onLoadMineInfoLoaded(AccountMine accountMine);
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface OnDataChangedListener {
        void onChanged(AccountMine accountMine, AccountMineRequestResource accountMineRequestResource);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IMinePageInfo createMineSolution(MenuGroup.Item item) {
        char c;
        String striped = Uri.parse(item.uri).buildUpon().clearQuery().build().toString();
        switch (striped.hashCode()) {
            case -2023690722:
                if (striped.equals(PAGE_GAME_CENTER_HOME)) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case -2023299830:
                if (striped.equals(PAGE_GAME_CENTER)) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -1997431799:
                if (striped.equals(PAGE_OFFLINE)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1804337423:
                if (striped.equals(PAGE_TEENAGERS_MODE)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -1790263364:
                if (striped.equals(PAGE_TEEN_PARENT_MODE)) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case -1597055672:
                if (striped.equals(PAGE_UPPER_HOT)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -745209060:
                if (striped.equals(PAGE_MALL_CENTER)) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -225734860:
                if (striped.equals(PAGE_WATCHLATER)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -129039320:
                if (striped.equals(PAGE_WALLET)) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 111032392:
                if (striped.equals(PAGE_UPPER)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 690751229:
                if (striped.equals(PAGE_FAVORITE)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 812413543:
                if (striped.equals(PAGE_UPPER_ACADEMY)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 1376251772:
                if (striped.equals(PAGE_LIVECENTER)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1630912200:
                if (striped.equals(PAGE_MINE_ORDER)) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 1728587440:
                if (striped.equals(PAGE_FREEDATA)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1979205574:
                if (striped.equals(PAGE_LESSONS_MODE)) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 2135154470:
                if (striped.equals(PAGE_UPPER_UPLOAD)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return new OfflineMineSolution();
            case 1:
                return new WatchLaterMineSolution();
            case 2:
                return new FavoritesMineSolution();
            case 3:
                return new LiveMineSolution();
            case 4:
                return new FreeDataMineSolution();
            case 5:
                return new UperCenterMineSolution();
            case 6:
                return new UperUploadMineSolution();
            case 7:
                return new UperHotMineSolution();
            case '\b':
                return new UperAcademyMineSolution();
            case '\t':
                return new TeenagersMineSolution();
            case '\n':
                return new LessonsMineSolution();
            case 11:
            case '\f':
                return new MallMineSolution();
            case '\r':
            case 14:
                return new GameCenterMineSolution();
            case 15:
                return new WalletMineSolution();
            case 16:
                return new ParentControlModeSolution();
            default:
                return new DefaultMineSolution();
        }
    }

    private AccountMineInfoManager() {
    }

    public static AccountMineInfoManager getInstance() {
        return defaultInstance;
    }

    public AccountMine getMemoryMineInfo() {
        return this.mCache;
    }

    public void getLocalMineInfo(final Context context, final LocalMineInfoLoadListener listener) {
        if (this.mCache != null) {
            if (listener != null) {
                listener.onLoadMineInfoLoaded(this.mCache);
                return;
            }
            return;
        }
        Task.callInBackground(new Callable<AccountMine>() { // from class: tv.danmaku.bili.ui.main2.AccountMineInfoManager.2
            @Override // java.util.concurrent.Callable
            public AccountMine call() {
                return AccountMineStorage.read(context);
            }
        }).continueWith(new Continuation<AccountMine, Void>() { // from class: tv.danmaku.bili.ui.main2.AccountMineInfoManager.1
            public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                return m1873then((Task<AccountMine>) task);
            }

            /* renamed from: then  reason: collision with other method in class */
            public Void m1873then(Task<AccountMine> task) throws Exception {
                AccountMine mineInfo = (AccountMine) task.getResult();
                if (mineInfo != null) {
                    if (mineInfo.sectionListV2 == null || mineInfo.sectionListV2.isEmpty()) {
                        mineInfo.sectionListV2 = AccountMineInfoManager.defaultMineSections(context);
                    } else {
                        MineInfoItemHelperKt.setLocalDefault(mineInfo);
                    }
                }
                AccountMineInfoManager.this.mCache = mineInfo;
                if (listener != null) {
                    listener.onLoadMineInfoLoaded(AccountMineInfoManager.this.mCache);
                    return null;
                }
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    public void refreshInfo(final Context context, final boolean fragmentIsShown, final AccountMineRequestResource resource, final OnDataChangedListener callback) {
        if (this.mIsRefreshsing || context == null) {
            return;
        }
        this.mIsRefreshsing = true;
        this.mRefreshToken = new CancellationTokenSource();
        Task.callInBackground(new Callable<AccountMine>() { // from class: tv.danmaku.bili.ui.main2.AccountMineInfoManager.5
            @Override // java.util.concurrent.Callable
            public AccountMine call() throws Exception {
                String accessKey = BiliAccounts.get(context).getAccessKey();
                boolean guideBubbleFirstShow = ProjectionClientUtilsKt.getGuideBubbleFirstShow(3);
                String creatorArchive = AccountMineInfoManager.this.getCreatorArchive();
                AccountApiService accountApiService = (AccountApiService) ServiceGenerator.createService(AccountApiService.class);
                int biliLinkNew = guideBubbleFirstShow ? 1 : 0;
                return (AccountMine) ExBilowUtil.extractResponseData(accountApiService.getMine(accessKey, String.valueOf(biliLinkNew), fragmentIsShown ? AccountMineInfoManager.PAGE_NAME : "", creatorArchive).execute());
            }
        }, this.mRefreshToken.getToken()).continueWith(new Continuation<AccountMine, AccountMine>() { // from class: tv.danmaku.bili.ui.main2.AccountMineInfoManager.4
            public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                return m1875then((Task<AccountMine>) task);
            }

            /* renamed from: then  reason: collision with other method in class */
            public AccountMine m1875then(Task<AccountMine> task) throws Exception {
                AccountMine newInfo;
                boolean isRequested;
                if (task.isCancelled() || task.isFaulted() || (newInfo = (AccountMine) task.getResult()) == null) {
                    return null;
                }
                if (newInfo.mid == 0 && BiliAccounts.get(context).isLogin()) {
                    BiliAccountInfo.get().requestForMyAccountInfo();
                }
                if (!MinePrefHelper.INSTANCE.isNewInstall(context)) {
                    isRequested = true;
                } else {
                    isRequested = MinePrefHelper.INSTANCE.isRequestedMine(context);
                }
                if (newInfo.sectionListV2 == null || newInfo.sectionListV2.isEmpty()) {
                    newInfo.sectionListV2 = AccountMineInfoManager.defaultMineSections(context);
                } else {
                    for (MenuGroup group : newInfo.sectionListV2) {
                        if (group.itemList != null) {
                            Iterator<MenuGroup.Item> itemIt = group.itemList.iterator();
                            while (itemIt.hasNext()) {
                                MenuGroup.Item item = itemIt.next();
                                if (item != null) {
                                    if (TextUtils.isEmpty(item.title) || TextUtils.isEmpty(item.uri)) {
                                        itemIt.remove();
                                        BLog.w(AccountMineInfoManager.TAG, "remove invalid drawer menu data" + item.toString());
                                    } else if (!isRequested) {
                                        BLog.w(AccountMineInfoManager.TAG, "first request mine");
                                        if (item.redDotRorNew && !MinePrefHelper.INSTANCE.isClickedForNew(context, String.valueOf(item.id))) {
                                            MinePrefHelper.INSTANCE.setShowForUpdate(context, String.valueOf(item.id));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                newInfo.gameTips = NoticeExtKt.getTipsIfShown(newInfo.gameTips, AccountMineInfoManager.this.noticeCacheService);
                MinePrefHelper.INSTANCE.setIsRequestedMine(context, true);
                return newInfo;
            }
        }, this.mRefreshToken.getToken()).continueWith(new Continuation<AccountMine, Void>() { // from class: tv.danmaku.bili.ui.main2.AccountMineInfoManager.3
            public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                return m1874then((Task<AccountMine>) task);
            }

            /* renamed from: then  reason: collision with other method in class */
            public Void m1874then(Task<AccountMine> task) throws Exception {
                AccountMineInfoManager.this.mIsRefreshsing = false;
                if (task.isCancelled()) {
                    return null;
                }
                if (task.isFaulted()) {
                    Exception e = task.getError();
                    BLog.e(AccountMineInfoManager.TAG, e);
                    return null;
                }
                AccountMine newInfo = (AccountMine) task.getResult();
                if (newInfo != null) {
                    AccountMineStorage.saveAsync(context, newInfo);
                    AccountMineInfoManager.this.mCache = newInfo;
                    if (callback != null) {
                        callback.onChanged(AccountMineInfoManager.this.mCache, resource);
                    }
                }
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR, this.mRefreshToken.getToken());
    }

    public String getCreatorArchive() {
        String creatorArchive = "";
        UpperService upperService = (UpperService) BLRouter.INSTANCE.get(UpperService.class, MineReporter.MINE_ICON_TYPE_DEFAULT);
        if (upperService != null) {
            creatorArchive = upperService.queryArchiveTaskStatus();
        }
        BLog.e(TAG, "[mine接口] creatorArchive = " + creatorArchive);
        return creatorArchive;
    }

    public void cancelRefresh() {
        if (this.mRefreshToken != null) {
            this.mRefreshToken.cancel();
            this.mRefreshToken = null;
            this.mIsRefreshsing = false;
        }
    }

    public boolean hasDrawerMenuRedDot() {
        return this.mDrawerMenuRedDotCount.size() != 0;
    }

    public void clear() {
        this.mCache = null;
        this.mDrawerMenuRedDotCount.clear();
        AccountMineStorage.deleteAsync(BiliContext.application());
    }

    public static List<MenuGroup> defaultMineSections(Context context) {
        List<MenuGroup> sectionList = new ArrayList<>(3);
        sectionList.add(minePersonalCenter(context));
        sectionList.add(mineService(context));
        sectionList.add(otherService(context));
        MineInfoItemHelperKt.setLocalDefault((List<? extends MenuGroup>) sectionList);
        return sectionList;
    }

    private static MenuGroup minePersonalCenter(Context context) {
        List<MenuGroup.Item> itemList = new ArrayList<>();
        MenuGroup.Item offline = new MenuGroup.Item();
        offline.id = 1L;
        offline.title = context.getString(R.string.playerbaseres_global_string_60);
        offline.uri = PAGE_OFFLINE;
        offline.iconResId = tv.danmaku.bili.R.drawable.ic_mine_offline;
        itemList.add(offline);
        MenuGroup.Item history = new MenuGroup.Item();
        history.id = 2L;
        history.title = context.getString(bili.resource.following.R.string.following_global_string_628);
        history.uri = PAGE_HISTORY;
        history.iconResId = tv.danmaku.bili.R.drawable.ic_mine_history;
        itemList.add(history);
        MenuGroup.Item favorite = new MenuGroup.Item();
        favorite.id = 3L;
        favorite.title = context.getString(bili.resource.favorites.R.string.favorites_global_string_93);
        favorite.uri = PAGE_FAVORITE;
        favorite.iconResId = tv.danmaku.bili.R.drawable.ic_mine_favorite;
        favorite.needLogin = 1;
        itemList.add(favorite);
        MenuGroup.Item watchLater = new MenuGroup.Item();
        watchLater.id = 4L;
        watchLater.title = context.getString(R.string.playerbaseres_global_string_163);
        watchLater.uri = PAGE_WATCHLATER;
        watchLater.iconResId = tv.danmaku.bili.R.drawable.ic_mine_watchlater;
        watchLater.needLogin = 1;
        itemList.add(watchLater);
        MenuGroup group = new MenuGroup();
        group.itemList = itemList;
        group.style = 1;
        return group;
    }

    private static MenuGroup mineService(Context context) {
        List<MenuGroup.Item> itemList = new ArrayList<>();
        MenuGroup.Item live = new MenuGroup.Item();
        live.id = 5L;
        live.title = context.getString(bili.resource.homepage.R.string.homepage_global_string_51);
        live.uri = PAGE_LIVECENTER;
        live.iconResId = tv.danmaku.bili.R.drawable.ic_mine_live_center;
        live.needLogin = 1;
        itemList.add(live);
        MenuGroup.Item freedata = new MenuGroup.Item();
        freedata.id = 6L;
        freedata.title = context.getString(bili.resource.homepage.R.string.homepage_global_string_338);
        freedata.uri = PAGE_FREEDATA;
        freedata.iconResId = tv.danmaku.bili.R.drawable.ic_mine_freedata;
        itemList.add(freedata);
        MenuGroup.Item mall = new MenuGroup.Item();
        mall.id = 7L;
        mall.title = context.getString(bili.resource.others.R.string.others_global_string_285);
        mall.uri = PAGE_MALL_CENTER;
        mall.iconResId = tv.danmaku.bili.R.drawable.ic_mine_mall;
        itemList.add(mall);
        MenuGroup.Item wallet = new MenuGroup.Item();
        wallet.id = 8L;
        wallet.title = context.getString(bili.resource.others.R.string.others_global_string_149);
        wallet.uri = PAGE_WALLET;
        wallet.iconResId = tv.danmaku.bili.R.drawable.ic_mine_wallet;
        itemList.add(wallet);
        MenuGroup myService = new MenuGroup();
        myService.itemList = itemList;
        myService.title = context.getString(bili.resource.homepage.R.string.homepage_global_string_52);
        myService.style = 1;
        return myService;
    }

    private static MenuGroup otherService(Context context) {
        List<MenuGroup.Item> itemList = new ArrayList<>();
        MenuGroup.Item feedback = new MenuGroup.Item();
        feedback.id = 9L;
        feedback.title = context.getString(bili.resource.homepage.R.string.homepage_global_string_71);
        feedback.uri = "https://www.bilibili.com/h5/customer-service";
        feedback.iconResId = tv.danmaku.bili.R.drawable.ic_mine_feedback;
        itemList.add(feedback);
        MenuGroup otherService = new MenuGroup();
        otherService.itemList = itemList;
        otherService.title = context.getString(bili.resource.settings.R.string.settings_global_string_46);
        otherService.style = 2;
        return otherService;
    }
}