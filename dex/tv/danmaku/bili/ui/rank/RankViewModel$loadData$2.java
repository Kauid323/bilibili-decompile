package tv.danmaku.bili.ui.rank;

import android.os.Bundle;
import com.bapis.bilibili.app.show.rank.v1.RankRegionInfo;
import com.bapis.bilibili.app.show.rank.v1.RankRegionListReply;
import com.bilibili.lib.moss.api.MossException;
import com.bilibili.lib.moss.api.MossResponseHandler;
import com.bilibili.routeui.PageInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.rank.api.RankApiManager;
import tv.danmaku.bili.ui.rank.model.RankStatus;
import tv.danmaku.bili.ui.rank.model.RankUiState;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RankViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.rank.RankViewModel$loadData$2", f = "RankViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class RankViewModel$loadData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RankViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankViewModel$loadData$2(RankViewModel rankViewModel, Continuation<? super RankViewModel$loadData$2> continuation) {
        super(2, continuation);
        this.this$0 = rankViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RankViewModel$loadData$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                final RankViewModel rankViewModel = this.this$0;
                RankApiManager.getRankTabList(new MossResponseHandler<RankRegionListReply>() { // from class: tv.danmaku.bili.ui.rank.RankViewModel$loadData$2.1
                    public /* synthetic */ void onCompleted() {
                        MossResponseHandler.-CC.$default$onCompleted(this);
                    }

                    public /* synthetic */ void onHeaders(Map map) {
                        MossResponseHandler.-CC.$default$onHeaders(this, map);
                    }

                    public /* synthetic */ long onNextForAck(Object obj2) {
                        return MossResponseHandler.-CC.$default$onNextForAck(this, obj2);
                    }

                    public /* synthetic */ void onUpstreamAck(Long l) {
                        MossResponseHandler.-CC.$default$onUpstreamAck(this, l);
                    }

                    public /* synthetic */ void onValid() {
                        MossResponseHandler.-CC.$default$onValid(this);
                    }

                    public void onNext(RankRegionListReply value) {
                        MutableStateFlow $this$update$iv;
                        RankViewModel rankViewModel2;
                        int $i$f$update;
                        List<PageInfo> emptyList;
                        Iterable regionsList;
                        String handleScheme;
                        $this$update$iv = RankViewModel.this._uiState;
                        RankViewModel rankViewModel3 = RankViewModel.this;
                        int $i$f$update2 = 0;
                        while (true) {
                            Object prevValue$iv = $this$update$iv.getValue();
                            RankUiState state = (RankUiState) prevValue$iv;
                            boolean z = false;
                            RankStatus rankStatus = RankStatus.SUCCESS;
                            if (value == null || (regionsList = value.getRegionsList()) == null) {
                                rankViewModel2 = rankViewModel3;
                                $i$f$update = $i$f$update2;
                                emptyList = CollectionsKt.emptyList();
                            } else {
                                Iterable $this$map$iv = regionsList;
                                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                for (Object item$iv$iv : $this$map$iv) {
                                    RankRegionInfo it = (RankRegionInfo) item$iv$iv;
                                    int $i$f$update3 = $i$f$update2;
                                    String name = it.getName();
                                    Intrinsics.checkNotNull(it);
                                    boolean z2 = z;
                                    handleScheme = rankViewModel3.handleScheme(it);
                                    destination$iv$iv.add(new PageInfo((Integer) null, name, handleScheme, (Bundle) null));
                                    $i$f$update2 = $i$f$update3;
                                    z = z2;
                                    rankViewModel3 = rankViewModel3;
                                }
                                rankViewModel2 = rankViewModel3;
                                $i$f$update = $i$f$update2;
                                emptyList = (List) destination$iv$iv;
                            }
                            Object nextValue$iv = state.copy(rankStatus, emptyList);
                            if ($this$update$iv.compareAndSet(prevValue$iv, nextValue$iv)) {
                                return;
                            }
                            $i$f$update2 = $i$f$update;
                            rankViewModel3 = rankViewModel2;
                        }
                    }

                    public void onError(MossException t) {
                        MutableStateFlow $this$update$iv;
                        Object prevValue$iv;
                        RankUiState it;
                        BLog.e("RankViewModel", "fetchData error: " + (t != null ? t.getMessage() : null));
                        $this$update$iv = RankViewModel.this._uiState;
                        do {
                            prevValue$iv = $this$update$iv.getValue();
                            it = (RankUiState) prevValue$iv;
                        } while (!$this$update$iv.compareAndSet(prevValue$iv, RankUiState.copy$default(it, RankStatus.FAILED, null, 2, null)));
                    }
                });
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}