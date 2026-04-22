package tv.danmaku.bili.ui.main2.resource;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.app.comm.list.common.utils.BiliCallLifeCycleObserverKt;
import com.bilibili.homepage.HomeFragmentListener;
import com.bilibili.homepage.HomeTabInfo;
import com.bilibili.homepage.HomeTabSelectedListener;
import com.bilibili.homepage.HomeTabService;
import com.bilibili.homepage.TabIconInfo;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.homepage.startdust.secondary.BasePrimaryMultiPageFragment;
import com.bilibili.lib.homepage.util.BottomTabSelectedHelper;
import com.bilibili.lib.homepage.widget.TabHost;
import com.bilibili.live.LiveHomeTabService;
import com.bilibili.pegasus.PegasusHomeTabService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.v2.InnerPushReceiverKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.main2.HomeFragOperator;
import tv.danmaku.bili.ui.main2.resource.MainResourceManager;

/* compiled from: HomeTabServiceImpl.kt */
@Singleton
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010-\u001a\u00020.2\u000e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000\u0010J\u000e\u00101\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0096@¢\u0006\u0002\u00103J\b\u00104\u001a\u00020.H\u0016J\b\u00105\u001a\u00020.H\u0016J\u0006\u0010<\u001a\u00020.J\u0006\u0010=\u001a\u00020.J\u0010\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020\fH\u0016J\u0010\u0010A\u001a\u00020.2\u0006\u0010@\u001a\u00020\fH\u0016J\u0010\u0010B\u001a\u00020.2\u0006\u0010@\u001a\u00020\u000eH\u0016J\u0010\u0010C\u001a\u00020.2\u0006\u0010@\u001a\u00020\u000eH\u0016J\u0010\u0010D\u001a\u00020,2\u0006\u0010E\u001a\u00020\u001aH\u0016J\u0012\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010E\u001a\u00020\u001aH\u0016J\b\u0010H\u001a\u000207H\u0016J\n\u0010I\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010J\u001a\u00020.2\b\u0010K\u001a\u0004\u0018\u00010\u001aH\u0016J4\u0010L\u001a\u00020.2\u0006\u0010M\u001a\u0002072\u0006\u0010N\u001a\u00020,2\b\u0010O\u001a\u0004\u0018\u00010\u001a2\b\u0010P\u001a\u0004\u0018\u00010G2\b\u0010Q\u001a\u0004\u0018\u00010RJ\u000e\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\b\u0010T\u001a\u00020,H\u0016J\u0012\u0010U\u001a\u00020\u001a2\b\u0010E\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010V\u001a\u00020.2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00198F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR(\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00106\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b8\u00109R\u0014\u0010>\u001a\u0002078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u00109¨\u0006Y"}, d2 = {"Ltv/danmaku/bili/ui/main2/resource/HomeTabServiceImpl;", "Lcom/bilibili/homepage/HomeTabService;", "<init>", "()V", "homeFragmentOperator", "Ltv/danmaku/bili/ui/main2/HomeFragOperator;", "getHomeFragmentOperator", "()Ltv/danmaku/bili/ui/main2/HomeFragOperator;", "setHomeFragmentOperator", "(Ltv/danmaku/bili/ui/main2/HomeFragOperator;)V", "mTabSelectedListener", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bilibili/homepage/HomeTabSelectedListener;", "mHomeFragmentListener", "Lcom/bilibili/homepage/HomeFragmentListener;", "showingTabs", "", "Lcom/bilibili/homepage/HomeTabInfo;", "mHandler", "Landroid/os/Handler;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "lock", "Lkotlinx/coroutines/sync/Mutex;", "tabIconMap", "", "", "Lcom/bilibili/homepage/TabIconInfo;", "getTabIconMap", "()Ljava/util/Map;", "value", "Landroidx/lifecycle/LifecycleCoroutineScope;", "lifeCycleScope", "getLifeCycleScope", "()Landroidx/lifecycle/LifecycleCoroutineScope;", "setLifeCycleScope", "(Landroidx/lifecycle/LifecycleCoroutineScope;)V", "tabHost", "Lcom/bilibili/lib/homepage/widget/TabHost;", "getTabHost", "()Lcom/bilibili/lib/homepage/widget/TabHost;", "setTabHost", "(Lcom/bilibili/lib/homepage/widget/TabHost;)V", "pullDownRefreshTimes", "", "setShowingTabs", "", "info", "Lcom/bilibili/lib/homepage/startdust/secondary/BasePrimaryMultiPageFragment$PageInfo;", "getCachedHomeTabs", "updateTabsFromRemote", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTabsFromCache", "tryUpdateHomeTab", "hotUpdateSwitch", "", "getHotUpdateSwitch", "()Z", "hotUpdateSwitch$delegate", "Lkotlin/Lazy;", "onFragmentHide", "onFragmentShow", "isHotUpdateEnable", "registerHomeTabSelectedListener", "listener", "unregisterHomeTabSelectedListener", "registerHomeFragmentListener", "unregisterHomeFragmentListener", "getTabPosById", "tabId", "getTabViewById", "Landroid/view/View;", "currentIsMainTab", "getHomeLifeCycleScope", "updateTabFromInterestChoose", "selectedIds", "onHomeTabSelect", "isTop", "position", "tabUrl", "tabView", InnerPushReceiverKt.KEY_EXTRA, "Landroid/os/Bundle;", "getShowingHomeTabs", "getTMRefreshTimes", "buildHomeTabUrl", "tryUpdateTab", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@Named("HOME_TAB_SERVICE")
public final class HomeTabServiceImpl implements HomeTabService {
    public static final int $stable = 8;
    private HomeFragOperator homeFragmentOperator;
    private LifecycleCoroutineScope lifeCycleScope;
    private int pullDownRefreshTimes;
    private TabHost tabHost;
    private final CopyOnWriteArrayList<HomeTabSelectedListener> mTabSelectedListener = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<HomeFragmentListener> mHomeFragmentListener = new CopyOnWriteArrayList<>();
    private List<HomeTabInfo> showingTabs = CollectionsKt.emptyList();
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
    private final Mutex lock = MutexKt.Mutex$default(false, 1, (Object) null);
    private final Lazy hotUpdateSwitch$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.main2.resource.HomeTabServiceImpl$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean hotUpdateSwitch_delegate$lambda$0;
            hotUpdateSwitch_delegate$lambda$0 = HomeTabServiceImpl.hotUpdateSwitch_delegate$lambda$0();
            return Boolean.valueOf(hotUpdateSwitch_delegate$lambda$0);
        }
    });

    public final HomeFragOperator getHomeFragmentOperator() {
        return this.homeFragmentOperator;
    }

    public final void setHomeFragmentOperator(HomeFragOperator homeFragOperator) {
        this.homeFragmentOperator = homeFragOperator;
    }

    public final Map<String, TabIconInfo> getTabIconMap() {
        TabIconInfo it;
        TabIconInfo it2;
        Map $this$_get_tabIconMap__u24lambda_u240 = new LinkedHashMap();
        PegasusHomeTabService pegasusHomeTabService = (PegasusHomeTabService) BLRouter.get$default(BLRouter.INSTANCE, PegasusHomeTabService.class, (String) null, 2, (Object) null);
        if (pegasusHomeTabService != null && (it2 = pegasusHomeTabService.getTabIconInfo()) != null) {
            TabIconInfo tabIconInfo = (TabIconInfo) $this$_get_tabIconMap__u24lambda_u240.put(DefaultResourceResolver.HOME_PROMO, it2);
        }
        LiveHomeTabService liveHomeTabService = (LiveHomeTabService) BLRouter.get$default(BLRouter.INSTANCE, LiveHomeTabService.class, (String) null, 2, (Object) null);
        if (liveHomeTabService != null && (it = liveHomeTabService.getTabIconInfo()) != null) {
            $this$_get_tabIconMap__u24lambda_u240.put(DefaultResourceResolver.HOME_LIVE, it);
        }
        return $this$_get_tabIconMap__u24lambda_u240;
    }

    public final LifecycleCoroutineScope getLifeCycleScope() {
        return this.lifeCycleScope;
    }

    public final void setLifeCycleScope(LifecycleCoroutineScope value) {
        this.lifeCycleScope = value;
        Iterable $this$forEach$iv = this.mHomeFragmentListener;
        for (Object element$iv : $this$forEach$iv) {
            HomeFragmentListener it = (HomeFragmentListener) element$iv;
            it.onViewCreated(this.lifeCycleScope);
        }
    }

    public final TabHost getTabHost() {
        return this.tabHost;
    }

    public final void setTabHost(TabHost tabHost) {
        this.tabHost = tabHost;
    }

    public final void setShowingTabs(List<BasePrimaryMultiPageFragment.PageInfo> list) {
        Intrinsics.checkNotNullParameter(list, "info");
        Iterable $this$map$iv = CollectionsKt.filterNotNull(list);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            BasePrimaryMultiPageFragment.PageInfo it = (BasePrimaryMultiPageFragment.PageInfo) item$iv$iv;
            destination$iv$iv.add(new HomeTabInfo(it.name, it.reporterId, it.url, buildHomeTabUrl(it.reporterId)));
        }
        this.showingTabs = (List) destination$iv$iv;
    }

    public List<HomeTabInfo> getCachedHomeTabs() {
        Iterable filterNotNull;
        List<SecondaryPage> forHomeTabPages = new CachedResourceResolver().forHomeTabPages();
        if (forHomeTabPages == null || (filterNotNull = CollectionsKt.filterNotNull(forHomeTabPages)) == null) {
            return CollectionsKt.emptyList();
        }
        Iterable $this$map$iv = filterNotNull;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            SecondaryPage it = (SecondaryPage) item$iv$iv;
            destination$iv$iv.add(new HomeTabInfo(it.reporterId, it.title, it.url, buildHomeTabUrl(it.reporterId)));
        }
        return (List) destination$iv$iv;
    }

    public Object updateTabsFromRemote(Continuation<? super List<HomeTabInfo>> continuation) throws IllegalStateException {
        Continuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final Continuation it = safeContinuation;
        MainResourceManager.getInstance().fetchInBackGround(false, null, new MainResourceManager.ShowTabApiListener() { // from class: tv.danmaku.bili.ui.main2.resource.HomeTabServiceImpl$updateTabsFromRemote$2$1
            @Override // tv.danmaku.bili.ui.main2.resource.MainResourceManager.ShowTabApiListener
            public void onSuccessSaveToDisk(final MainResourceManager.TabResponse response) {
                Handler handler;
                Intrinsics.checkNotNullParameter(response, "response");
                handler = HomeTabServiceImpl.this.mHandler;
                final HomeTabServiceImpl homeTabServiceImpl = HomeTabServiceImpl.this;
                final Continuation<List<HomeTabInfo>> continuation2 = it;
                handler.post(new Runnable() { // from class: tv.danmaku.bili.ui.main2.resource.HomeTabServiceImpl$updateTabsFromRemote$2$1$onSuccessSaveToDisk$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        List list;
                        List<MainResourceManager.Tab> list2;
                        Iterable filterNotNull;
                        String buildHomeTabUrl;
                        MainResourceManager.TabData tabData = MainResourceManager.TabResponse.this.tabData;
                        if (tabData == null || (list2 = tabData.tab) == null || (filterNotNull = CollectionsKt.filterNotNull(list2)) == null) {
                            list = null;
                        } else {
                            Iterable $this$map$iv = filterNotNull;
                            HomeTabServiceImpl homeTabServiceImpl2 = homeTabServiceImpl;
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                MainResourceManager.Tab tab = (MainResourceManager.Tab) item$iv$iv;
                                String str = tab.tabId;
                                String str2 = tab.name;
                                String str3 = tab.uri;
                                buildHomeTabUrl = homeTabServiceImpl2.buildHomeTabUrl(tab.reportId);
                                destination$iv$iv.add(new HomeTabInfo(str, str2, str3, buildHomeTabUrl));
                            }
                            list = (List) destination$iv$iv;
                        }
                        List topTabs = list;
                        HomeFragOperator homeFragmentOperator = homeTabServiceImpl.getHomeFragmentOperator();
                        if (homeFragmentOperator != null) {
                            homeFragmentOperator.forceUpdateHomeTab();
                        }
                        Continuation<List<HomeTabInfo>> continuation3 = continuation2;
                        Result.Companion companion = Result.Companion;
                        continuation3.resumeWith(Result.constructor-impl(topTabs == null ? CollectionsKt.emptyList() : topTabs));
                    }
                });
            }

            @Override // tv.danmaku.bili.ui.main2.resource.MainResourceManager.ShowTabApiListener
            public void onNothingToSave() {
                Handler handler;
                handler = HomeTabServiceImpl.this.mHandler;
                final Continuation<List<HomeTabInfo>> continuation2 = it;
                handler.post(new Runnable() { // from class: tv.danmaku.bili.ui.main2.resource.HomeTabServiceImpl$updateTabsFromRemote$2$1$onNothingToSave$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Continuation<List<HomeTabInfo>> continuation3 = continuation2;
                        Result.Companion companion = Result.Companion;
                        continuation3.resumeWith(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("An exception occurred, the request failed, or the data was invalid "))));
                    }
                });
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public void updateTabsFromCache() {
        HomeFragOperator homeFragOperator = this.homeFragmentOperator;
        if (homeFragOperator != null) {
            homeFragOperator.forceUpdateHomeTab();
        }
    }

    public void tryUpdateHomeTab() {
        if (!getHotUpdateSwitch()) {
            BLog.i("HomeTabServiceImpl", "tryUpdateHomeTab ret");
            return;
        }
        BLog.i("HomeTabServiceImpl", "tryUpdateHomeTab");
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new HomeTabServiceImpl$tryUpdateHomeTab$1(this, null), 3, (Object) null);
    }

    private final boolean getHotUpdateSwitch() {
        return ((Boolean) this.hotUpdateSwitch$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hotUpdateSwitch_delegate$lambda$0() {
        return Intrinsics.areEqual(ConfigManager.Companion.ab().get("ff_main_tab_hot_refresh", true), true);
    }

    public final void onFragmentHide() {
        Iterable $this$forEach$iv = this.mHomeFragmentListener;
        for (Object element$iv : $this$forEach$iv) {
            HomeFragmentListener it = (HomeFragmentListener) element$iv;
            it.onHide();
        }
    }

    public final void onFragmentShow() {
        Iterable $this$forEach$iv = this.mHomeFragmentListener;
        for (Object element$iv : $this$forEach$iv) {
            HomeFragmentListener it = (HomeFragmentListener) element$iv;
            it.onShow();
        }
    }

    public boolean isHotUpdateEnable() {
        return getHotUpdateSwitch();
    }

    public void registerHomeTabSelectedListener(HomeTabSelectedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.mTabSelectedListener.contains(listener)) {
            this.mTabSelectedListener.add(listener);
        }
    }

    public void unregisterHomeTabSelectedListener(HomeTabSelectedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mTabSelectedListener.remove(listener);
    }

    public void registerHomeFragmentListener(HomeFragmentListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.mHomeFragmentListener.contains(listener)) {
            this.mHomeFragmentListener.add(listener);
        }
    }

    public void unregisterHomeFragmentListener(HomeFragmentListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mHomeFragmentListener.remove(listener);
    }

    public int getTabPosById(String tabId) {
        List $this$indexOfFirst$iv;
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        TabHost tabHost = this.tabHost;
        int i = -1;
        if (tabHost != null && ($this$indexOfFirst$iv = tabHost.getTabs()) != null) {
            int index$iv = 0;
            Iterator it = $this$indexOfFirst$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object item$iv = it.next();
                TabHost.TabInfo it2 = (TabHost.TabInfo) item$iv;
                if (Intrinsics.areEqual(it2.reportId, tabId)) {
                    i = index$iv;
                    break;
                }
                index$iv++;
            }
        }
        return i + 1;
    }

    public View getTabViewById(String tabId) {
        List $this$indexOfFirst$iv;
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        TabHost tabHost = this.tabHost;
        ViewGroup viewGroup = null;
        if (tabHost != null && ($this$indexOfFirst$iv = tabHost.getTabs()) != null) {
            int index$iv = 0;
            Iterator it = $this$indexOfFirst$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object item$iv = it.next();
                    TabHost.TabInfo it2 = (TabHost.TabInfo) item$iv;
                    if (Intrinsics.areEqual(it2.reportId, tabId)) {
                        break;
                    }
                    index$iv++;
                } else {
                    index$iv = -1;
                    break;
                }
            }
            int it3 = index$iv;
            TabHost tabHost2 = this.tabHost;
            if (tabHost2 != null) {
                viewGroup = tabHost2.getItemView(it3);
            }
        }
        return viewGroup;
    }

    public boolean currentIsMainTab() {
        return BottomTabSelectedHelper.INSTANCE.currentIsMainPage();
    }

    public LifecycleCoroutineScope getHomeLifeCycleScope() {
        return this.lifeCycleScope;
    }

    public void updateTabFromInterestChoose(String selectedIds) {
        MainResourceManager.getInstance().fetchInBackGround(false, selectedIds, new HomeTabServiceImpl$updateTabFromInterestChoose$1(this));
    }

    public final void onHomeTabSelect(boolean isTop, int position, String tabUrl, View tabView, Bundle extra) {
        Iterable $this$forEach$iv = this.mTabSelectedListener;
        for (Object element$iv : $this$forEach$iv) {
            HomeTabSelectedListener it = (HomeTabSelectedListener) element$iv;
            it.onTabSelected(isTop, position, tabUrl, tabView, extra);
        }
    }

    public List<HomeTabInfo> getShowingHomeTabs() {
        return this.showingTabs;
    }

    public int getTMRefreshTimes() {
        return this.pullDownRefreshTimes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildHomeTabUrl(String tabId) {
        String str = tabId;
        return str == null || StringsKt.isBlank(str) ? "" : "bilibili://home?bottom_tab_id=home&tab_id=" + tabId;
    }

    public void tryUpdateTab(Activity activity) {
        LifecycleOwner lifecycleOwner;
        CoroutineScope lifecycleScope;
        if (activity == null || (lifecycleOwner = BiliCallLifeCycleObserverKt.getLifecycleOwner(activity)) == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) == null) {
            return;
        }
        BuildersKt.launch$default(lifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new HomeTabServiceImpl$tryUpdateTab$1(this, null), 3, (Object) null);
    }
}