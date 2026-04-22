package tv.danmaku.bili.ui.main2.basic.story;

import android.content.SharedPreferences;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bilibili.app.comm.list.widget.utils.SharedPreferencesField;
import com.bilibili.homepage.HomeSideCenterService;
import com.bilibili.homepage.HomeSideCenterTab;
import com.bilibili.homepage.HomeVideoShortCutService;
import com.bilibili.homepage.SideCenterPageActionListener;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.blrouter.BLRouter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment;
import tv.danmaku.bili.ui.main2.resource.MainResourceManager;

/* compiled from: HomeTopLeftStateHolder.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u001a\b\u0010$\u001a\u00020%H\u0000\u001a\b\u0010&\u001a\u00020%H\u0002\u001a\b\u0010'\u001a\u00020%H\u0002\u001a\u0012\u0010*\u001a\u00020%*\u00020+2\u0006\u0010,\u001a\u00020)\u001a\b\u0010-\u001a\u00020\u0003H\u0000\u001a\b\u0010.\u001a\u00020\u0003H\u0000\u001a\b\u0010/\u001a\u000200H\u0000\u001a\f\u00101\u001a\u000200*\u00020\u0010H\u0000\u001a\b\u00102\u001a\u000200H\u0000\u001a\n\u00103\u001a\u0004\u0018\u00010\u0010H\u0000\u001a\b\u00104\u001a\u00020\u0003H\u0000\u001a\u0006\u00105\u001a\u00020%\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006\"\u001a\u0010\u0007\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0004\"\u0004\b\t\u0010\u0006\"\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"+\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\u0006\"+\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u0006\"\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001e\"\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0014\u00106\u001a\u00020\u0001X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u00069²\u0006\n\u0010:\u001a\u00020\u0003X\u008a\u0084\u0002"}, d2 = {"TAG", "", "isColdStartPlayTopLeftAnimation", "", "()Z", "setColdStartPlayTopLeftAnimation", "(Z)V", "lastIsSideCenterPage", "getLastIsSideCenterPage", "setLastIsSideCenterPage", "isMiniGameOverThisTime", "lastGameInlineTime", "hasEnableShowGuideBubble", "userInfo", "Lcom/bilibili/lib/accountinfo/model/AccountInfo;", "topLeftInfo", "Ltv/danmaku/bili/ui/main2/resource/MainResourceManager$TopLeftInfo;", "<set-?>", "hasDoTopLeftMiniGameAnimation", "getHasDoTopLeftMiniGameAnimation", "setHasDoTopLeftMiniGameAnimation", "hasDoTopLeftMiniGameAnimation$delegate", "Lcom/bilibili/app/comm/list/widget/utils/SharedPreferencesField;", "topLeftAvatarRecentIconIncludePendent", "getTopLeftAvatarRecentIconIncludePendent", "setTopLeftAvatarRecentIconIncludePendent", "topLeftAvatarRecentIconIncludePendent$delegate", "sideCenterService", "Lcom/bilibili/homepage/HomeSideCenterService;", "getSideCenterService", "()Lcom/bilibili/homepage/HomeSideCenterService;", "sideCenterService$delegate", "Lkotlin/Lazy;", "miniGamePlayState", "Ltv/danmaku/bili/ui/main2/basic/story/MiniGameOpenState;", "isTopLeftServiceInit", "initTopLeftService", "", "registerGlobalTopLeftGameListener", "registerGlobalSideCenterPageListener", "sideCenterPageListener", "Ltv/danmaku/bili/ui/main2/basic/story/SideCenterPageListener;", "registerSideCenterPageListener", "Ltv/danmaku/bili/ui/main2/basic/BaseMainFrameFragment;", "listener", "canDisplayTopLeftAnimation", "useAvatarWithPendentStyle", "getCurrentHomeSideCenterTab", "Lcom/bilibili/homepage/HomeSideCenterTab;", "getNewContainerCurrentTab", "getNewContainerCurrentTabFromLocal", "getTopLeftInfo", "lastIsStory", "resetTopLeftMiniGameHistory", "HOME_SIDE_CENTER_ROUTER", "getHOME_SIDE_CENTER_ROUTER", "()Ljava/lang/String;", "core_apinkDebug", "displayed"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HomeTopLeftStateHolderKt {
    private static final String TAG = "[TopLeft]HomeSideCenterStateHolder";
    private static boolean isColdStartPlayTopLeftAnimation;
    private static boolean isMiniGameOverThisTime;
    private static boolean isTopLeftServiceInit;
    private static boolean lastIsSideCenterPage;
    private static SideCenterPageListener sideCenterPageListener;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(HomeTopLeftStateHolderKt.class, "displayed", "<v#0>", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(HomeTopLeftStateHolderKt.class, "hasDoTopLeftMiniGameAnimation", "getHasDoTopLeftMiniGameAnimation()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(HomeTopLeftStateHolderKt.class, "topLeftAvatarRecentIconIncludePendent", "getTopLeftAvatarRecentIconIncludePendent()Z", 1))};
    private static String lastGameInlineTime = "0";
    private static final SharedPreferencesField hasDoTopLeftMiniGameAnimation$delegate = new SharedPreferencesField("sp_have_do_topleft_avatar_animation_mini_game", false, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);
    private static final SharedPreferencesField topLeftAvatarRecentIconIncludePendent$delegate = new SharedPreferencesField("sp_topleft_avatar_rencent_icon_include_pendent", false, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);
    private static final Lazy sideCenterService$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.main2.basic.story.HomeTopLeftStateHolderKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            HomeSideCenterService sideCenterService_delegate$lambda$0;
            sideCenterService_delegate$lambda$0 = HomeTopLeftStateHolderKt.sideCenterService_delegate$lambda$0();
            return sideCenterService_delegate$lambda$0;
        }
    });
    private static MiniGameOpenState miniGamePlayState = MiniGameOpenState.INIT;
    private static final String HOME_SIDE_CENTER_ROUTER = "bilibili://side_center/container";

    public static final boolean isColdStartPlayTopLeftAnimation() {
        return isColdStartPlayTopLeftAnimation;
    }

    public static final void setColdStartPlayTopLeftAnimation(boolean z) {
        isColdStartPlayTopLeftAnimation = z;
    }

    public static final boolean getLastIsSideCenterPage() {
        return lastIsSideCenterPage;
    }

    public static final void setLastIsSideCenterPage(boolean z) {
        lastIsSideCenterPage = z;
    }

    public static final boolean hasEnableShowGuideBubble(AccountInfo userInfo, MainResourceManager.TopLeftInfo topLeftInfo) {
        List bubbles;
        boolean z;
        boolean z2;
        HomeSideCenterService sideCenterService;
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        boolean res = false;
        if (topLeftInfo != null) {
            HomeSideCenterTab curTab = getCurrentHomeSideCenterTab();
            if (topLeftInfo.hitRecentTabExp() && miniGamePlayState == MiniGameOpenState.FROM_OTHER_PAGE && curTab != HomeSideCenterTab.UNKNOWN && curTab != HomeSideCenterTab.MINE && (bubbles = topLeftInfo.bubbles) != null && bubbles.size() > 1) {
                List $this$any$iv = bubbles;
                if (!($this$any$iv instanceof Collection) || !$this$any$iv.isEmpty()) {
                    Iterator<T> it = $this$any$iv.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            MainResourceManager.TopLeftBubble bubble = (MainResourceManager.TopLeftBubble) it.next();
                            if (bubble.type == 1) {
                                z2 = true;
                                continue;
                            } else {
                                z2 = false;
                                continue;
                            }
                            if (z2) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                } else {
                    z = false;
                }
                if (z && isMiniGameOverThisTime && Intrinsics.areEqual(lastGameInlineTime, "1")) {
                    List $this$first$iv = bubbles;
                    for (Object element$iv : $this$first$iv) {
                        MainResourceManager.TopLeftBubble it2 = (MainResourceManager.TopLeftBubble) element$iv;
                        MainResourceManager.TopLeftBubble it3 = it2.type == 1 ? 1 : null;
                        if (it3 != null) {
                            MainResourceManager.TopLeftBubble bubble2 = (MainResourceManager.TopLeftBubble) element$iv;
                            String recordId = "sp_has_shown_game_guide_click_" + bubble2.id + "_" + userInfo.getMid();
                            SharedPreferencesField displayed$delegate = new SharedPreferencesField(recordId, false, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);
                            if (!hasEnableShowGuideBubble$lambda$0$0$2(displayed$delegate)) {
                                res = true;
                                isMiniGameOverThisTime = false;
                                setTopLeftAvatarRecentIconIncludePendent(false);
                                if (curTab != HomeSideCenterTab.RECENT && (sideCenterService = getSideCenterService()) != null) {
                                    sideCenterService.setCurrentHomeTab(HomeSideCenterTab.RECENT);
                                }
                            }
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            }
        }
        lastGameInlineTime = "0";
        return res;
    }

    private static final boolean hasEnableShowGuideBubble$lambda$0$0$2(SharedPreferencesField<Boolean> sharedPreferencesField) {
        return ((Boolean) sharedPreferencesField.getValue((Object) null, $$delegatedProperties[0])).booleanValue();
    }

    public static final boolean getHasDoTopLeftMiniGameAnimation() {
        return ((Boolean) hasDoTopLeftMiniGameAnimation$delegate.getValue((Object) null, $$delegatedProperties[1])).booleanValue();
    }

    public static final void setHasDoTopLeftMiniGameAnimation(boolean z) {
        hasDoTopLeftMiniGameAnimation$delegate.setValue((Object) null, $$delegatedProperties[1], Boolean.valueOf(z));
    }

    private static final boolean getTopLeftAvatarRecentIconIncludePendent() {
        return ((Boolean) topLeftAvatarRecentIconIncludePendent$delegate.getValue((Object) null, $$delegatedProperties[2])).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTopLeftAvatarRecentIconIncludePendent(boolean z) {
        topLeftAvatarRecentIconIncludePendent$delegate.setValue((Object) null, $$delegatedProperties[2], Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HomeSideCenterService getSideCenterService() {
        return (HomeSideCenterService) sideCenterService$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HomeSideCenterService sideCenterService_delegate$lambda$0() {
        return (HomeSideCenterService) BLRouter.get$default(BLRouter.INSTANCE, HomeSideCenterService.class, (String) null, 2, (Object) null);
    }

    public static final void initTopLeftService() {
        if (!isTopLeftServiceInit) {
            registerGlobalTopLeftGameListener();
            registerGlobalSideCenterPageListener();
        }
        isTopLeftServiceInit = true;
    }

    private static final void registerGlobalTopLeftGameListener() {
        BLog.i(TAG, "registerTopLeftListener");
        BuildersKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new HomeTopLeftStateHolderKt$registerGlobalTopLeftGameListener$1(null), 3, (Object) null);
    }

    private static final void registerGlobalSideCenterPageListener() {
        HomeSideCenterService sideCenterService = getSideCenterService();
        if (sideCenterService != null) {
            sideCenterService.setPageActionListener(new SideCenterPageActionListener() { // from class: tv.danmaku.bili.ui.main2.basic.story.HomeTopLeftStateHolderKt$registerGlobalSideCenterPageListener$1
                public void onPageEnter() {
                    HomeTopLeftStateHolderKt.setTopLeftAvatarRecentIconIncludePendent(false);
                }

                public void onPageExit() {
                    SideCenterPageListener sideCenterPageListener2;
                    sideCenterPageListener2 = HomeTopLeftStateHolderKt.sideCenterPageListener;
                    if (sideCenterPageListener2 != null) {
                        sideCenterPageListener2.onExitPage();
                    }
                }
            });
        }
    }

    public static final void registerSideCenterPageListener(BaseMainFrameFragment $this$registerSideCenterPageListener, SideCenterPageListener listener) {
        Intrinsics.checkNotNullParameter($this$registerSideCenterPageListener, "<this>");
        Intrinsics.checkNotNullParameter(listener, "listener");
        sideCenterPageListener = listener;
        $this$registerSideCenterPageListener.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: tv.danmaku.bili.ui.main2.basic.story.HomeTopLeftStateHolderKt$registerSideCenterPageListener$1
            public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.-CC.$default$onCreate(this, lifecycleOwner);
            }

            public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.-CC.$default$onPause(this, lifecycleOwner);
            }

            public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.-CC.$default$onResume(this, lifecycleOwner);
            }

            public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.-CC.$default$onStart(this, lifecycleOwner);
            }

            public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.-CC.$default$onStop(this, lifecycleOwner);
            }

            public void onDestroy(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                DefaultLifecycleObserver.-CC.$default$onDestroy(this, owner);
                HomeTopLeftStateHolderKt.sideCenterPageListener = null;
            }
        });
    }

    public static final boolean canDisplayTopLeftAnimation() {
        MainResourceManager.TopLeftInfo topLeft = getTopLeftInfo();
        if (topLeft == null) {
            return false;
        }
        if (topLeft.hitRecentTabExp()) {
            HomeSideCenterTab currentTab = getCurrentHomeSideCenterTab();
            if (lastIsSideCenterPage) {
                return false;
            }
            if (!getHasDoTopLeftMiniGameAnimation() && miniGamePlayState == MiniGameOpenState.FROM_OTHER_PAGE && currentTab == HomeSideCenterTab.RECENT && isMiniGameOverThisTime) {
                isMiniGameOverThisTime = false;
                return true;
            } else if (isColdStartPlayTopLeftAnimation) {
                return false;
            } else {
                if (miniGamePlayState == MiniGameOpenState.INIT || !isMiniGameOverThisTime) {
                    return currentTab == HomeSideCenterTab.STORY || currentTab == HomeSideCenterTab.LISTEN || (currentTab == HomeSideCenterTab.RECENT && getTopLeftAvatarRecentIconIncludePendent());
                }
                return false;
            }
        } else if (isColdStartPlayTopLeftAnimation) {
            return false;
        } else {
            return topLeft.gotoFlag == 2 || topLeft.gotoFlag == 3;
        }
    }

    public static final boolean useAvatarWithPendentStyle() {
        MainResourceManager.TopLeftInfo topLeft = getTopLeftInfo();
        if (topLeft == null) {
            return false;
        }
        if (!topLeft.hitRecentTabExp()) {
            return topLeft.gotoFlag == 2 || topLeft.gotoFlag == 3;
        }
        HomeSideCenterTab tab = getCurrentHomeSideCenterTab();
        return tab == HomeSideCenterTab.LISTEN || tab == HomeSideCenterTab.STORY || (tab == HomeSideCenterTab.RECENT && getTopLeftAvatarRecentIconIncludePendent());
    }

    public static final HomeSideCenterTab getCurrentHomeSideCenterTab() {
        MainResourceManager.TopLeftInfo topLeft = getTopLeftInfo();
        if (topLeft == null) {
            return HomeSideCenterTab.UNKNOWN;
        }
        if (topLeft.hitRecentTabExp()) {
            return getNewContainerCurrentTab(topLeft);
        }
        return lastIsStory() ? HomeSideCenterTab.STORY : HomeSideCenterTab.LISTEN;
    }

    public static final HomeSideCenterTab getNewContainerCurrentTab(MainResourceManager.TopLeftInfo $this$getNewContainerCurrentTab) {
        HomeSideCenterTab tab;
        Intrinsics.checkNotNullParameter($this$getNewContainerCurrentTab, "<this>");
        HomeSideCenterService sideCenterService = getSideCenterService();
        if (sideCenterService == null || (tab = sideCenterService.getCurrentHomeTab()) == null) {
            tab = HomeSideCenterTab.UNKNOWN;
        }
        if (tab != HomeSideCenterTab.UNKNOWN) {
            return tab;
        }
        switch ($this$getNewContainerCurrentTab.gotoFlag) {
            case 1:
                return HomeSideCenterTab.MINE;
            case 2:
                return HomeSideCenterTab.STORY;
            case 3:
                return HomeSideCenterTab.LISTEN;
            case 4:
                return HomeSideCenterTab.RECENT;
            default:
                return HomeSideCenterTab.UNKNOWN;
        }
    }

    public static final HomeSideCenterTab getNewContainerCurrentTabFromLocal() {
        HomeSideCenterTab tab;
        HomeSideCenterService sideCenterService = getSideCenterService();
        if (sideCenterService == null || (tab = sideCenterService.getCurrentHomeTab()) == null) {
            tab = HomeSideCenterTab.UNKNOWN;
        }
        BLog.i(TAG, "getNewContainerCurrentTabFromLocal, tab = " + tab);
        return tab;
    }

    public static final MainResourceManager.TopLeftInfo getTopLeftInfo() {
        MainResourceManager.TopLeftInfo $this$getTopLeftInfo_u24lambda_u240 = MainResourceManager.getInstance().getTopLeftInfo();
        BLog.i(TAG, "getTopLeftInfo :" + $this$getTopLeftInfo_u24lambda_u240);
        return $this$getTopLeftInfo_u24lambda_u240;
    }

    public static final boolean lastIsStory() {
        HomeVideoShortCutService homeVideoShortCutService = (HomeVideoShortCutService) BLRouter.get$default(BLRouter.INSTANCE, HomeVideoShortCutService.class, (String) null, 2, (Object) null);
        return !Intrinsics.areEqual(homeVideoShortCutService != null ? homeVideoShortCutService.getCurrentTab() : null, "PAGER_PODCAST");
    }

    public static final void resetTopLeftMiniGameHistory() {
        setHasDoTopLeftMiniGameAnimation(false);
        lastIsSideCenterPage = false;
        miniGamePlayState = MiniGameOpenState.INIT;
        setTopLeftAvatarRecentIconIncludePendent(false);
    }

    public static final String getHOME_SIDE_CENTER_ROUTER() {
        return HOME_SIDE_CENTER_ROUTER;
    }
}