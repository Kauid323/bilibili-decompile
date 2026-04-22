package tv.danmaku.bili.ui.main2.basic.story;

import com.bilibili.homepage.HomeSideCenterService;
import com.bilibili.homepage.HomeSideCenterTab;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.moduleservice.fasthybrid.minigame.MiniGameLaunchOpt;
import com.bilibili.moduleservice.fasthybrid.minigame.MiniGameSidebarBridgeService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.resource.MainResourceManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeTopLeftStateHolder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.basic.story.HomeTopLeftStateHolderKt$registerGlobalTopLeftGameListener$1", f = "HomeTopLeftStateHolder.kt", i = {}, l = {BR.cover}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HomeTopLeftStateHolderKt$registerGlobalTopLeftGameListener$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HomeTopLeftStateHolderKt$registerGlobalTopLeftGameListener$1(Continuation<? super HomeTopLeftStateHolderKt$registerGlobalTopLeftGameListener$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeTopLeftStateHolderKt$registerGlobalTopLeftGameListener$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeTopLeftStateHolder.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", AppConfig.HOST_GAME, "Lcom/bilibili/moduleservice/fasthybrid/minigame/MiniGameLaunchOpt;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.main2.basic.story.HomeTopLeftStateHolderKt$registerGlobalTopLeftGameListener$1$1", f = "HomeTopLeftStateHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.main2.basic.story.HomeTopLeftStateHolderKt$registerGlobalTopLeftGameListener$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<MiniGameLaunchOpt, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(MiniGameLaunchOpt miniGameLaunchOpt, Continuation<? super Unit> continuation) {
            return create(miniGameLaunchOpt, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x008f, code lost:
            r0 = tv.danmaku.bili.ui.main2.basic.story.HomeTopLeftStateHolderKt.getSideCenterService();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            HomeSideCenterService sideCenterService;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    MiniGameLaunchOpt game = (MiniGameLaunchOpt) this.L$0;
                    BLog.i("[TopLeft]HomeSideCenterStateHolder", "registerTopLeftListener, onChange game = " + game);
                    HomeTopLeftStateHolderKt.isMiniGameOverThisTime = true;
                    HomeTopLeftStateHolderKt.lastGameInlineTime = String.valueOf(game.getExtras().get("over2Mins"));
                    HomeSideCenterTab curTab = HomeTopLeftStateHolderKt.getCurrentHomeSideCenterTab();
                    MainResourceManager.TopLeftInfo topLeftInfo = HomeTopLeftStateHolderKt.getTopLeftInfo();
                    boolean z = false;
                    if (topLeftInfo != null && topLeftInfo.hitRecentTabExp()) {
                        z = true;
                    }
                    if (z && (curTab == HomeSideCenterTab.LISTEN || curTab == HomeSideCenterTab.STORY || curTab == HomeSideCenterTab.RECENT)) {
                        if (game.getLastJumpFromSidebar() || !HomeTopLeftStateHolderKt.getHasDoTopLeftMiniGameAnimation()) {
                            HomeTopLeftStateHolderKt.setTopLeftAvatarRecentIconIncludePendent(true);
                        }
                        HomeTopLeftStateHolderKt.miniGamePlayState = game.getLastJumpFromSidebar() ? MiniGameOpenState.FROM_RECENT_PAGE : MiniGameOpenState.FROM_OTHER_PAGE;
                        if (!HomeTopLeftStateHolderKt.getLastIsSideCenterPage() && !HomeTopLeftStateHolderKt.getHasDoTopLeftMiniGameAnimation() && sideCenterService != null) {
                            sideCenterService.setCurrentHomeTab(HomeSideCenterTab.RECENT);
                        }
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Flow miniGameEnterBackgroundFlow;
        Flow distinctUntilChanged;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                MiniGameSidebarBridgeService miniGameSidebarBridgeService = (MiniGameSidebarBridgeService) BLRouter.INSTANCE.get(MiniGameSidebarBridgeService.class, "MiniGameSidebarBridgeService");
                if (miniGameSidebarBridgeService != null && (miniGameEnterBackgroundFlow = miniGameSidebarBridgeService.getMiniGameEnterBackgroundFlow()) != null && (distinctUntilChanged = FlowKt.distinctUntilChanged(miniGameEnterBackgroundFlow)) != null) {
                    this.label = 1;
                    if (FlowKt.collectLatest(distinctUntilChanged, new AnonymousClass1(null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}