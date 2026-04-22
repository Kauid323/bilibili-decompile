package tv.danmaku.biliplayerimpl.report.share;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.pvtracker.PageViewTracker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerContainerCoroutineKt;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.service.report.IReporterService;
import tv.danmaku.biliplayerv2.service.report.NeuronsEvents;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SharedPlayReportService.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u000e\u0010\u0010\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/biliplayerimpl/report/share/SharedPlayReportService;", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "<init>", "()V", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "bindPlayerContainer", "", "playerContainer", "onStart", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "onAttachByShared", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "onStop", "reportSharedPlay", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SharedPlayReportService implements IPlayerService {
    private PlayerContainer mPlayerContainer;

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ void onCollectSharedParams(PlayerSharingType playerSharingType, PlayerSharingBundle playerSharingBundle) {
        IPlayerService.CC.$default$onCollectSharedParams(this, playerSharingType, playerSharingBundle);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ void onPlayerReset() {
        IPlayerService.CC.$default$onPlayerReset(this);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ PlayerServiceManager.ServiceConfig serviceConfig() {
        return IPlayerService.CC.$default$serviceConfig(this);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void bindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStart(PlayerSharingBundle bundle) {
        if (bundle == null) {
            return;
        }
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        BuildersKt.launch$default(PlayerContainerCoroutineKt.getCoroutineScope(playerContainer), (CoroutineContext) null, (CoroutineStart) null, new SharedPlayReportService$onStart$1(this, null), 3, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onAttachByShared(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        BuildersKt.launch$default(PlayerContainerCoroutineKt.getCoroutineScope(playerContainer), (CoroutineContext) null, (CoroutineStart) null, new SharedPlayReportService$onAttachByShared$1(this, null), 3, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStop() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object reportSharedPlay(Continuation<? super Unit> continuation) {
        SharedPlayReportService$reportSharedPlay$1 sharedPlayReportService$reportSharedPlay$1;
        SharedPlayReportService sharedPlayReportService;
        Flow currentStateFlow;
        Object first;
        SharedPlayReportService sharedPlayReportService2;
        PlayerContainer playerContainer;
        String it;
        if (continuation instanceof SharedPlayReportService$reportSharedPlay$1) {
            sharedPlayReportService$reportSharedPlay$1 = (SharedPlayReportService$reportSharedPlay$1) continuation;
            if ((sharedPlayReportService$reportSharedPlay$1.label & Integer.MIN_VALUE) != 0) {
                sharedPlayReportService$reportSharedPlay$1.label -= Integer.MIN_VALUE;
                Object $result = sharedPlayReportService$reportSharedPlay$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                PlayerContainer playerContainer2 = null;
                switch (sharedPlayReportService$reportSharedPlay$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        sharedPlayReportService = this;
                        PlayerContainer playerContainer3 = sharedPlayReportService.mPlayerContainer;
                        if (playerContainer3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                            playerContainer3 = null;
                        }
                        FragmentActivity findFragmentActivityOrNull = ContextUtilKt.findFragmentActivityOrNull(playerContainer3.getContext());
                        Lifecycle lifecycle = findFragmentActivityOrNull != null ? findFragmentActivityOrNull.getLifecycle() : null;
                        if (lifecycle != null && (currentStateFlow = lifecycle.getCurrentStateFlow()) != null) {
                            sharedPlayReportService$reportSharedPlay$1.label = 1;
                            first = FlowKt.first(currentStateFlow, new SharedPlayReportService$reportSharedPlay$2(null), sharedPlayReportService$reportSharedPlay$1);
                            if (first == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            sharedPlayReportService2 = sharedPlayReportService;
                            Lifecycle.State state = (Lifecycle.State) first;
                            sharedPlayReportService = sharedPlayReportService2;
                            break;
                        }
                        break;
                    case 1:
                        sharedPlayReportService2 = this;
                        ResultKt.throwOnFailure($result);
                        first = $result;
                        Lifecycle.State state2 = (Lifecycle.State) first;
                        sharedPlayReportService = sharedPlayReportService2;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                playerContainer = sharedPlayReportService.mPlayerContainer;
                if (playerContainer != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                } else {
                    playerContainer2 = playerContainer;
                }
                IReporterService $this$reportSharedPlay_u24lambda_u240 = playerContainer2.getReporterService();
                Map $this$reportSharedPlay_u24lambda_u240_u240 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("player_session_id", $this$reportSharedPlay_u24lambda_u240.getSession())});
                it = PageViewTracker.getInstance().currentPolarisActionId();
                if (it != null) {
                    $this$reportSharedPlay_u24lambda_u240_u240.put("action_id", it);
                }
                Unit unit = Unit.INSTANCE;
                $this$reportSharedPlay_u24lambda_u240.report(new NeuronsEvents.NormalEventV2("player.player.share-switch.0.player", $this$reportSharedPlay_u24lambda_u240_u240));
                return Unit.INSTANCE;
            }
        }
        sharedPlayReportService$reportSharedPlay$1 = new SharedPlayReportService$reportSharedPlay$1(this, continuation);
        Object $result2 = sharedPlayReportService$reportSharedPlay$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        PlayerContainer playerContainer22 = null;
        switch (sharedPlayReportService$reportSharedPlay$1.label) {
        }
        playerContainer = sharedPlayReportService.mPlayerContainer;
        if (playerContainer != null) {
        }
        IReporterService $this$reportSharedPlay_u24lambda_u2402 = playerContainer22.getReporterService();
        Map $this$reportSharedPlay_u24lambda_u240_u2402 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("player_session_id", $this$reportSharedPlay_u24lambda_u2402.getSession())});
        it = PageViewTracker.getInstance().currentPolarisActionId();
        if (it != null) {
        }
        Unit unit2 = Unit.INSTANCE;
        $this$reportSharedPlay_u24lambda_u2402.report(new NeuronsEvents.NormalEventV2("player.player.share-switch.0.player", $this$reportSharedPlay_u24lambda_u240_u2402));
        return Unit.INSTANCE;
    }
}