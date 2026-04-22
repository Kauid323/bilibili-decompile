package tv.danmaku.video.bilicardplayer.player;

import android.net.Uri;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.FetchBusinessData;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetOnlineInfo;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetWorkInfo;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.InvokeCommandDetailPanel;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.OpenUrlScheme;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.ReportSubtitle;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateCurrentWork;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateFullscreenState;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdatePreference;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateShipChain;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateVideoDetailState;
import tv.danmaku.biliplayerv2.service.interact.biz.model.DanmakuFeedbackInfo;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.video.bilicardplayer.CardTaskRepository;
import tv.danmaku.video.bilicardplayer.ChronosEvent;
import tv.danmaku.video.bilicardplayer.DataRelationShipChain;
import tv.danmaku.video.bilicardplayer.DataWorkInfo;

/* compiled from: CardChronosInvokeObserver.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\rH\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\rH\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\rH\u0016J\u0016\u0010\u001a\u001a\u00020\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/CardChronosInvokeObserver;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/RpcInvokeObserver;", "repository", "Ltv/danmaku/video/bilicardplayer/CardTaskRepository;", "<init>", "(Ltv/danmaku/video/bilicardplayer/CardTaskRepository;)V", "onRpcGetWorkInfo", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetWorkInfo$Response;", "onRpcGetCurrentWork", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateCurrentWork$Response;", "getRelationshipChain", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateShipChain$Response;", "onUpdateCurrentWork", "", "result", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateCurrentWork$Request;", "onTriggerTripleLike", "", "onUpdateCoinState", "coin", "onUpdateFavoState", "favo", "onUpdateFollowState", "follow", "onUpdateLikeState", "like", "onUpdateStaffFollowState", "followStateList", "", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateVideoDetailState$FollowState;", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CardChronosInvokeObserver implements RpcInvokeObserver {
    private final CardTaskRepository repository;

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public /* synthetic */ FetchBusinessData.Response fetchBusinessData(String str, Object obj) {
        return RpcInvokeObserver.CC.$default$fetchBusinessData(this, str, obj);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public /* synthetic */ GetOnlineInfo.Response getOnlineInfo() {
        return RpcInvokeObserver.CC.$default$getOnlineInfo(this);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public /* synthetic */ int[] getPlayerComponentsHeight() {
        return RpcInvokeObserver.CC.$default$getPlayerComponentsHeight(this);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public /* synthetic */ void notifyDanmakuExperiment(String str, boolean z) {
        RpcInvokeObserver.CC.$default$notifyDanmakuExperiment(this, str, z);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public /* synthetic */ void notifyDanmakuSent(String str) {
        RpcInvokeObserver.CC.$default$notifyDanmakuSent(this, str);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public /* synthetic */ void onDanmakuReply(String str, String str2, long j, String str3) {
        RpcInvokeObserver.CC.$default$onDanmakuReply(this, str, str2, j, str3);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public /* synthetic */ void onInvokeDanmakuInputPanel(InvokeCommandDetailPanel.CommandDetailParams commandDetailParams) {
        RpcInvokeObserver.CC.$default$onInvokeDanmakuInputPanel(this, commandDetailParams);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public /* synthetic */ void onShowDanmakuFeedback(DanmakuFeedbackInfo danmakuFeedbackInfo, String str, Map map, Function8 function8) {
        RpcInvokeObserver.CC.$default$onShowDanmakuFeedback(this, danmakuFeedbackInfo, str, map, function8);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public /* synthetic */ void onUpdateClockInState(UpdateVideoDetailState.CheckInState checkInState) {
        Intrinsics.checkNotNullParameter(checkInState, "clockInState");
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public /* synthetic */ void onUpdateDislikeState(boolean z) {
        RpcInvokeObserver.CC.$default$onUpdateDislikeState(this, z);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public /* synthetic */ void onUpdateRelationshipChain(UpdateShipChain.Request request) {
        RpcInvokeObserver.CC.$default$onUpdateRelationshipChain(this, request);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public /* synthetic */ void onUpdateReserveState(UpdateVideoDetailState.ReserveState reserveState) {
        Intrinsics.checkNotNullParameter(reserveState, "reserveState");
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public /* synthetic */ void onUpdateSeasonFollowState(boolean z) {
        RpcInvokeObserver.CC.$default$onUpdateSeasonFollowState(this, z);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public /* synthetic */ boolean openURLSchema(Uri uri, OpenUrlScheme.BizParams bizParams) {
        return RpcInvokeObserver.CC.$default$openURLSchema(this, uri, bizParams);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public /* synthetic */ boolean openURLScheme(String str, String str2, Integer num, OpenUrlScheme.BizParams bizParams, Integer num2) {
        return RpcInvokeObserver.CC.$default$openURLScheme(this, str, str2, num, bizParams, num2);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public /* synthetic */ void showDanmakuFeedbackWebview(String str, Map map, Function8 function8) {
        RpcInvokeObserver.CC.$default$showDanmakuFeedbackWebview(this, str, map, function8);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public /* synthetic */ void showPlayerNaPage(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public /* synthetic */ void showPlayerWebView(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public /* synthetic */ boolean showSubtitleReportDialog(ReportSubtitle.SubtitleMeta subtitleMeta, ReportSubtitle.SubtitleMeta subtitleMeta2) {
        return RpcInvokeObserver.CC.$default$showSubtitleReportDialog(this, subtitleMeta, subtitleMeta2);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public /* synthetic */ void updateDanmakuInputPanel(String str, Boolean bool, Boolean bool2, Function2 function2) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public /* synthetic */ UpdateFullscreenState.Response updateFullscreenState(Boolean bool, Boolean bool2) {
        return RpcInvokeObserver.CC.$default$updateFullscreenState(this, bool, bool2);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public /* synthetic */ UpdatePreference.Response updatePreference(String str, String str2) {
        return RpcInvokeObserver.CC.$default$updatePreference(this, str, str2);
    }

    public CardChronosInvokeObserver(CardTaskRepository repository) {
        this.repository = repository;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public GetWorkInfo.Response onRpcGetWorkInfo() {
        DataWorkInfo it;
        GetWorkInfo.Response result = new GetWorkInfo.Response();
        CardTaskRepository cardTaskRepository = this.repository;
        if (cardTaskRepository != null && (it = cardTaskRepository.getChronosWorkInfo()) != null) {
            result.setWorkId(it.getWorkId());
            result.setWorkTitle(it.getWorkTitle());
            result.setVideoList(it.getVideoList());
            result.setVideoId(it.getVideoId());
            result.setVideoTitle(it.getVideoTitle());
            result.setDuration(it.getDuration());
            result.setUpperId(it.getUpperId());
            result.setUpperName(it.getUpperName());
            result.setUpperAvatar(it.getUpperAvatar());
        }
        return result;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public UpdateCurrentWork.Response onRpcGetCurrentWork() {
        DataWorkInfo it;
        UpdateCurrentWork.Response result = new UpdateCurrentWork.Response();
        CardTaskRepository cardTaskRepository = this.repository;
        if (cardTaskRepository != null && (it = cardTaskRepository.getChronosWorkInfo()) != null) {
            result.setWorkId(it.getWorkId());
            result.setVideoId(it.getVideoId());
        }
        return result;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public UpdateShipChain.Response getRelationshipChain() {
        DataRelationShipChain it;
        UpdateShipChain.Response result = new UpdateShipChain.Response();
        CardTaskRepository cardTaskRepository = this.repository;
        if (cardTaskRepository != null && (it = cardTaskRepository.getChronosRelationShipChain()) != null) {
            result.setCoinState(it.getRelationCoinState());
            result.setLikeState(it.getRelationLikeState());
            result.setLikeNum(it.getRelationLikeNum());
            result.setFavoriteState(it.getRelationFavoriteState());
            result.setFollowState(it.getRelationFollowState());
        }
        return result;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public boolean onUpdateCurrentWork(UpdateCurrentWork.Request result) {
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public void onTriggerTripleLike() {
        CardTaskRepository cardTaskRepository = this.repository;
        if (cardTaskRepository != null) {
            cardTaskRepository.requestEvent(ChronosEvent.TRIPLE_LIKE, true);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public void onUpdateCoinState(boolean coin) {
        CardTaskRepository cardTaskRepository = this.repository;
        if (cardTaskRepository != null) {
            cardTaskRepository.requestEvent(ChronosEvent.COIN, coin);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public void onUpdateFavoState(boolean favo) {
        CardTaskRepository cardTaskRepository = this.repository;
        if (cardTaskRepository != null) {
            cardTaskRepository.requestEvent(ChronosEvent.FAV, favo);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public void onUpdateFollowState(boolean follow) {
        CardTaskRepository cardTaskRepository = this.repository;
        if (cardTaskRepository != null) {
            cardTaskRepository.requestEvent(ChronosEvent.FOLLOW, follow);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public void onUpdateLikeState(boolean like) {
        CardTaskRepository cardTaskRepository = this.repository;
        if (cardTaskRepository != null) {
            cardTaskRepository.requestEvent(ChronosEvent.LIKE, !like);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.RpcInvokeObserver
    public void onUpdateStaffFollowState(List<UpdateVideoDetailState.FollowState> list) {
        Intrinsics.checkNotNullParameter(list, "followStateList");
        CardTaskRepository cardTaskRepository = this.repository;
        if (cardTaskRepository != null) {
            cardTaskRepository.onUpdateStaffFollowState(list);
        }
    }
}