package tv.danmaku.video.bilicardplayer;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosBiz;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosScene;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateVideoDetailState;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: CardTaskRepository.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H&J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0016\u0010\u0010\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H&J-\u0010\u0014\u001a\u00020\u000b2#\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0016H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/video/bilicardplayer/CardTaskRepository;", "", "getChronosWorkInfo", "Ltv/danmaku/video/bilicardplayer/DataWorkInfo;", "getChronosRelationShipChain", "Ltv/danmaku/video/bilicardplayer/DataRelationShipChain;", "getChronosSceneAndBiz", "Lkotlin/Pair;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosScene;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosBiz;", "requestEvent", "", "event", "Ltv/danmaku/video/bilicardplayer/ChronosEvent;", "state", "", "onUpdateStaffFollowState", "list", "", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateVideoDetailState$FollowState;", "setRelationShipChangeObserver", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface CardTaskRepository {
    DataRelationShipChain getChronosRelationShipChain();

    Pair<ChronosScene, ChronosBiz> getChronosSceneAndBiz();

    DataWorkInfo getChronosWorkInfo();

    void onUpdateStaffFollowState(List<UpdateVideoDetailState.FollowState> list);

    void requestEvent(ChronosEvent chronosEvent, boolean z);

    void setRelationShipChangeObserver(Function1<? super DataRelationShipChain, Unit> function1);
}