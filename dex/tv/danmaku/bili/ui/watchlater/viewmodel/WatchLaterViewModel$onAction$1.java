package tv.danmaku.bili.ui.watchlater.viewmodel;

import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.playset.FavoriteService;
import com.bilibili.playset.OnFavoChangedListenerV2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayableParams;
import tv.danmaku.bili.ui.watchlater.data.PageState;
import tv.danmaku.bili.ui.watchlater.data.ToastType;
import tv.danmaku.bili.ui.watchlater.data.WLAction;
import tv.danmaku.bili.ui.watchlater.data.WLEvent;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterItem;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterList;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterResponse;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterState;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterTabState;
import tv.danmaku.bili.ui.watchlater.utils.WatchLaterReporterKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterViewModel.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/watchlater/data/WatchLaterState;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel$onAction$1", f = "WatchLaterViewModel.kt", i = {2}, l = {AuthorSpaceHeaderPlayableParams.AUTHOR_SPACE_HEADER_PLAYER_REPORT_AUTO_PLAY, 113, 284, 296, 302, 394}, m = "invokeSuspend", n = {"deleteList"}, s = {"L$0"}, v = 1)
public final class WatchLaterViewModel$onAction$1 extends SuspendLambda implements Function1<Continuation<? super WatchLaterState>, Object> {
    final /* synthetic */ WLAction $action;
    final /* synthetic */ WatchLaterState $state;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ WatchLaterViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchLaterViewModel$onAction$1(WLAction wLAction, WatchLaterState watchLaterState, WatchLaterViewModel watchLaterViewModel, Continuation<? super WatchLaterViewModel$onAction$1> continuation) {
        super(1, continuation);
        this.$action = wLAction;
        this.$state = watchLaterState;
        this.this$0 = watchLaterViewModel;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new WatchLaterViewModel$onAction$1(this.$action, this.$state, this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super WatchLaterState> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final List checkedList;
        WatchLaterState copy$default;
        List deleteList;
        Object deleteVideos;
        Object $result2;
        WatchLaterTabState tabAll;
        WatchLaterTabState tabToView;
        WatchLaterItem copy;
        Object element$iv;
        WatchLaterTabState tabAll2;
        WatchLaterTabState tabToView2;
        WatchLaterTabState tabAll3;
        WatchLaterTabState tabToView3;
        WatchLaterState watchLaterState;
        Object cleanVideo;
        Object $result3;
        WatchLaterState watchLaterState2;
        Object cleanVideo2;
        Object $result4;
        List deleteList2;
        WatchLaterState copy$default2;
        WatchLaterViewModel watchLaterViewModel;
        WatchLaterState watchLaterState3;
        Object deleteVideos2;
        Object $result5;
        WatchLaterViewModel watchLaterViewModel2;
        boolean z;
        List it;
        List it2;
        WatchLaterState watchLaterState4;
        WatchLaterRequestParam $this$invokeSuspend_u24lambda_u241_u240;
        Object requestData;
        Object $result6;
        WatchLaterState watchLaterState5;
        Object requestData2;
        Object $result7;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                WLAction wLAction = this.$action;
                if (wLAction instanceof WLAction.LoadAction) {
                    watchLaterState5 = this.$state;
                    WatchLaterViewModel watchLaterViewModel3 = this.this$0;
                    WLAction.LoadAction loadAction = (WLAction.LoadAction) this.$action;
                    int pageIndex = loadAction.getPageIndex();
                    boolean isLoadMore = loadAction.isLoadMore();
                    this.L$0 = watchLaterState5;
                    this.label = 1;
                    requestData2 = watchLaterViewModel3.requestData(pageIndex, isLoadMore, false, this);
                    if (requestData2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result7 = $result;
                    return watchLaterState5;
                } else if (wLAction instanceof WLAction.RefreshAction) {
                    watchLaterState4 = this.$state;
                    WatchLaterViewModel watchLaterViewModel4 = this.this$0;
                    WLAction wLAction2 = this.$action;
                    $this$invokeSuspend_u24lambda_u241_u240 = watchLaterViewModel4.requestParam;
                    WLAction.RefreshAction refreshAction = (WLAction.RefreshAction) wLAction2;
                    $this$invokeSuspend_u24lambda_u241_u240.getStartKey().set(refreshAction.getPageIndex(), "");
                    Unit unit = Unit.INSTANCE;
                    watchLaterViewModel4.requestParam = $this$invokeSuspend_u24lambda_u241_u240;
                    int pageIndex2 = refreshAction.getPageIndex();
                    this.L$0 = watchLaterState4;
                    this.label = 2;
                    requestData = watchLaterViewModel4.requestData(pageIndex2, false, true, this);
                    if (requestData == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result6 = $result;
                    return watchLaterState4;
                } else if (wLAction instanceof WLAction.LoadCompleteAction) {
                    List list = new ArrayList();
                    if (((WLAction.LoadCompleteAction) this.$action).getPageIndex() == 0) {
                        if (((WLAction.LoadCompleteAction) this.$action).isLoadMore()) {
                            list.addAll(this.$state.getTabAll().getData().getList());
                        }
                        WatchLaterResponse response = ((WLAction.LoadCompleteAction) this.$action).getResponse();
                        if (response != null && (it2 = response.getList()) != null) {
                            Boxing.boxBoolean(list.addAll(it2));
                        }
                        WatchLaterState watchLaterState6 = this.$state;
                        WatchLaterTabState tabAll4 = this.$state.getTabAll();
                        WatchLaterList copy2 = this.$state.getTabAll().getData().copy(list);
                        PageState.Empty empty = list.isEmpty() ? PageState.Empty.INSTANCE : PageState.Success.INSTANCE;
                        WatchLaterResponse response2 = ((WLAction.LoadCompleteAction) this.$action).getResponse();
                        String playUrl = response2 != null ? response2.getPlayUrl() : null;
                        boolean isLoadMore2 = ((WLAction.LoadCompleteAction) this.$action).isLoadMore();
                        WatchLaterResponse response3 = ((WLAction.LoadCompleteAction) this.$action).getResponse();
                        return WatchLaterState.copy$default(watchLaterState6, tabAll4.copy(copy2, empty, playUrl, isLoadMore2, false, response3 != null ? response3.getHasMore() : false), null, false, false, 14, null);
                    }
                    if (((WLAction.LoadCompleteAction) this.$action).isLoadMore()) {
                        list.addAll(this.$state.getTabToView().getData().getList());
                    }
                    WatchLaterResponse response4 = ((WLAction.LoadCompleteAction) this.$action).getResponse();
                    if (response4 != null && (it = response4.getList()) != null) {
                        Boxing.boxBoolean(list.addAll(it));
                    }
                    WatchLaterState watchLaterState7 = this.$state;
                    WatchLaterTabState tabToView4 = this.$state.getTabToView();
                    WatchLaterList copy3 = this.$state.getTabToView().getData().copy(list);
                    PageState.Empty empty2 = list.isEmpty() ? PageState.Empty.INSTANCE : PageState.Success.INSTANCE;
                    WatchLaterResponse response5 = ((WLAction.LoadCompleteAction) this.$action).getResponse();
                    String playUrl2 = response5 != null ? response5.getPlayUrl() : null;
                    boolean isLoadMore3 = ((WLAction.LoadCompleteAction) this.$action).isLoadMore();
                    WatchLaterResponse response6 = ((WLAction.LoadCompleteAction) this.$action).getResponse();
                    return WatchLaterState.copy$default(watchLaterState7, null, tabToView4.copy(copy3, empty2, playUrl2, isLoadMore3, false, response6 != null ? response6.getHasMore() : false), false, false, 13, null);
                } else if (wLAction instanceof WLAction.LoadError) {
                    if (((WLAction.LoadError) this.$action).getPageIndex() == 0) {
                        return WatchLaterState.copy$default(this.$state, WatchLaterTabState.copy$default(this.$state.getTabAll(), null, ((WLAction.LoadError) this.$action).isLoadMore() ? this.$state.getTabAll().getPageState() : new PageState.Error(((WLAction.LoadError) this.$action).getNetworkActive()), null, ((WLAction.LoadError) this.$action).isLoadMore(), false, false, 53, null), null, false, false, 14, null);
                    }
                    return WatchLaterState.copy$default(this.$state, null, WatchLaterTabState.copy$default(this.$state.getTabToView(), null, ((WLAction.LoadError) this.$action).isLoadMore() ? this.$state.getTabToView().getPageState() : new PageState.Error(((WLAction.LoadError) this.$action).getNetworkActive()), null, ((WLAction.LoadError) this.$action).isLoadMore(), false, false, 53, null), false, false, 13, null);
                } else if (wLAction instanceof WLAction.RefreshError) {
                    this.this$0.emitEvent(new AnonymousClass5(null));
                    return ((WLAction.RefreshError) this.$action).getPageIndex() == 0 ? WatchLaterState.copy$default(this.$state, WatchLaterTabState.copy$default(this.$state.getTabAll(), null, null, null, false, false, false, 47, null), null, false, false, 14, null) : WatchLaterState.copy$default(this.$state, null, WatchLaterTabState.copy$default(this.$state.getTabToView(), null, null, null, false, false, false, 47, null), false, false, 13, null);
                } else if (wLAction instanceof WLAction.Loading) {
                    if (((WLAction.Loading) this.$action).getPageIndex() == 0) {
                        return WatchLaterState.copy$default(this.$state, WatchLaterTabState.copy$default(this.$state.getTabAll(), null, ((WLAction.Loading) this.$action).isLoadMore() ? this.$state.getTabAll().getPageState() : PageState.Loading.INSTANCE, null, ((WLAction.Loading) this.$action).isLoadMore(), false, false, 53, null), null, false, false, 14, null);
                    }
                    return WatchLaterState.copy$default(this.$state, null, WatchLaterTabState.copy$default(this.$state.getTabToView(), null, ((WLAction.Loading) this.$action).isLoadMore() ? this.$state.getTabToView().getPageState() : PageState.Loading.INSTANCE, null, ((WLAction.Loading) this.$action).isLoadMore(), false, false, 53, null), false, false, 13, null);
                } else if (wLAction instanceof WLAction.Refreshing) {
                    return ((WLAction.Refreshing) this.$action).getPageIndex() == 0 ? WatchLaterState.copy$default(this.$state, WatchLaterTabState.copy$default(this.$state.getTabAll(), null, null, null, false, true, false, 47, null), null, false, false, 14, null) : WatchLaterState.copy$default(this.$state, null, WatchLaterTabState.copy$default(this.$state.getTabToView(), null, null, null, false, true, false, 47, null), false, false, 13, null);
                } else if (Intrinsics.areEqual(wLAction, WLAction.ChangeCheckState.INSTANCE)) {
                    WatchLaterState copy$default3 = WatchLaterState.copy$default(this.$state, null, null, !this.$state.isCheckMode(), false, 11, null);
                    WatchLaterState watchLaterState8 = this.$state;
                    WatchLaterViewModel watchLaterViewModel5 = this.this$0;
                    if (watchLaterState8.isCheckMode()) {
                        watchLaterViewModel5.sendAction(new WLAction.CancelAll(((Number) watchLaterViewModel5.curPageIndex.getValue()).intValue()));
                        return copy$default3;
                    }
                    return copy$default3;
                } else if (Intrinsics.areEqual(wLAction, WLAction.SortAction.INSTANCE)) {
                    WatchLaterState copy$default4 = WatchLaterState.copy$default(this.$state, new WatchLaterTabState(null, null, null, false, false, false, 63, null), new WatchLaterTabState(null, null, null, false, false, false, 63, null), false, !this.$state.getAsc(), 4, null);
                    WatchLaterViewModel watchLaterViewModel6 = this.this$0;
                    watchLaterViewModel6.sendAction(new WLAction.LoadAction(((Number) watchLaterViewModel6.curPageIndex.getValue()).intValue(), false));
                    watchLaterViewModel6.pageFirstLoad.put(Boxing.boxInt(((Number) watchLaterViewModel6.curPageIndex.getValue()).intValue() ^ 1), Boxing.boxBoolean(false));
                    return copy$default4;
                } else if (wLAction instanceof WLAction.DeleteChecked) {
                    Iterable $this$filterTo$iv$iv = (((Number) this.this$0.curPageIndex.getValue()).intValue() == 0 ? this.$state.getTabAll() : this.$state.getTabToView()).getData().getList();
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filterTo$iv$iv) {
                        if (((WatchLaterItem) element$iv$iv).isChecked()) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                    }
                    deleteList2 = (List) destination$iv$iv;
                    List $this$map$iv = deleteList2;
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        destination$iv$iv2.add(Boxing.boxLong(((WatchLaterItem) item$iv$iv).getAid()));
                    }
                    final List deleteAidList = (List) destination$iv$iv2;
                    WatchLaterTabState tabAll5 = this.$state.getTabAll();
                    WatchLaterList data = this.$state.getTabAll().getData();
                    List<WatchLaterItem> list2 = this.$state.getTabAll().getData().getList();
                    final WLAction wLAction3 = this.$action;
                    WatchLaterTabState tabAll6 = WatchLaterTabState.copy$default(tabAll5, data.copy(WatchLaterViewModelKt.filterNotItem(list2, new Function1() { // from class: tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel$onAction$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            boolean invokeSuspend$lambda$8;
                            invokeSuspend$lambda$8 = WatchLaterViewModel$onAction$1.invokeSuspend$lambda$8(WLAction.this, deleteAidList, (WatchLaterItem) obj);
                            return Boolean.valueOf(invokeSuspend$lambda$8);
                        }
                    })), null, null, false, false, false, 62, null);
                    WatchLaterTabState tabToView5 = this.$state.getTabToView();
                    WatchLaterList data2 = this.$state.getTabToView().getData();
                    List<WatchLaterItem> list3 = this.$state.getTabToView().getData().getList();
                    final WLAction wLAction4 = this.$action;
                    WatchLaterTabState tabToView6 = WatchLaterTabState.copy$default(tabToView5, data2.copy(WatchLaterViewModelKt.filterNotItem(list3, new Function1() { // from class: tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel$onAction$1$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            boolean invokeSuspend$lambda$9;
                            invokeSuspend$lambda$9 = WatchLaterViewModel$onAction$1.invokeSuspend$lambda$9(WLAction.this, deleteAidList, (WatchLaterItem) obj);
                            return Boolean.valueOf(invokeSuspend$lambda$9);
                        }
                    })), null, null, false, false, false, 62, null);
                    copy$default2 = WatchLaterState.copy$default(this.$state, (!tabAll6.getData().getList().isEmpty() || tabAll6.getHasMore()) ? tabAll6 : WatchLaterTabState.copy$default(tabAll6, null, PageState.Empty.INSTANCE, null, false, false, false, 61, null), (!tabToView6.getData().getList().isEmpty() || tabToView6.getHasMore()) ? tabToView6 : WatchLaterTabState.copy$default(tabToView6, null, PageState.Empty.INSTANCE, null, false, false, false, 61, null), false, false, 12, null);
                    WLAction wLAction5 = this.$action;
                    watchLaterViewModel = this.this$0;
                    if (!((WLAction.DeleteChecked) wLAction5).getRealDelete()) {
                        watchLaterState3 = copy$default2;
                        WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_BATCH_DELETE_CLICK, MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_NUM, String.valueOf(deleteList2.size()))));
                        watchLaterViewModel.sendAction(WLAction.ChangeCheckState.INSTANCE);
                        return watchLaterState3;
                    }
                    String resourceString = WatchLaterViewModelKt.toResourceString(deleteList2);
                    this.L$0 = deleteList2;
                    this.L$1 = copy$default2;
                    this.L$2 = watchLaterViewModel;
                    this.label = 3;
                    deleteVideos2 = watchLaterViewModel.deleteVideos(resourceString, this);
                    if (deleteVideos2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result5 = $result;
                    watchLaterViewModel2 = watchLaterViewModel;
                    z = false;
                    watchLaterViewModel = watchLaterViewModel2;
                    watchLaterState3 = copy$default2;
                    WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_BATCH_DELETE_CLICK, MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_NUM, String.valueOf(deleteList2.size()))));
                    watchLaterViewModel.sendAction(WLAction.ChangeCheckState.INSTANCE);
                    return watchLaterState3;
                } else if (Intrinsics.areEqual(wLAction, WLAction.DeleteInvalid.INSTANCE)) {
                    watchLaterState2 = this.$state;
                    WatchLaterViewModel watchLaterViewModel7 = this.this$0;
                    this.L$0 = watchLaterState2;
                    this.label = 4;
                    cleanVideo2 = watchLaterViewModel7.cleanVideo(1, this);
                    if (cleanVideo2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result4 = $result;
                    return watchLaterState2;
                } else if (Intrinsics.areEqual(wLAction, WLAction.DeleteWatched.INSTANCE)) {
                    watchLaterState = this.$state;
                    WatchLaterViewModel watchLaterViewModel8 = this.this$0;
                    this.L$0 = watchLaterState;
                    this.label = 5;
                    cleanVideo = watchLaterViewModel8.cleanVideo(2, this);
                    if (cleanVideo == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result3 = $result;
                    return watchLaterState;
                } else if (wLAction instanceof WLAction.ChangeCardCheckState) {
                    WatchLaterState watchLaterState9 = this.$state;
                    if (((WLAction.ChangeCardCheckState) this.$action).getPageIndex() == 0) {
                        WatchLaterTabState tabAll7 = this.$state.getTabAll();
                        WatchLaterList data3 = this.$state.getTabAll().getData();
                        Iterable $this$map$iv2 = this.$state.getTabAll().getData().getList();
                        WLAction wLAction6 = this.$action;
                        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                        for (Object item$iv$iv2 : $this$map$iv2) {
                            WatchLaterItem item = (WatchLaterItem) item$iv$iv2;
                            if (Intrinsics.areEqual(item.getItemId(), ((WLAction.ChangeCardCheckState) wLAction6).getItemId())) {
                                item = item.copy((r40 & 1) != 0 ? item.cardType : 0, (r40 & 2) != 0 ? item.aid : 0L, (r40 & 4) != 0 ? item.title : null, (r40 & 8) != 0 ? item.intro : null, (r40 & 16) != 0 ? item.pic : null, (r40 & 32) != 0 ? item.duration : 0L, (r40 & 64) != 0 ? item.progress : 0L, (r40 & 128) != 0 ? item.uri : null, (r40 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? item.arcState : 0, (r40 & 512) != 0 ? item.pgcLabel : null, (r40 & 1024) != 0 ? item.showUp : false, (r40 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? item.forbidFav : false, (r40 & 4096) != 0 ? item.owner : null, (r40 & 8192) != 0 ? item.leftIconType : 0, (r40 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) != 0 ? item.leftText : null, (r40 & 32768) != 0 ? item.rightIconType : 0, (r40 & 65536) != 0 ? item.rightText : null, (r40 & 131072) != 0 ? item.isChecked : !item.isChecked(), (r40 & 262144) != 0 ? item.itemId : null);
                            }
                            destination$iv$iv3.add(item);
                        }
                        tabAll3 = WatchLaterTabState.copy$default(tabAll7, data3.copy((List) destination$iv$iv3), null, null, false, false, false, 62, null);
                    } else {
                        tabAll3 = this.$state.getTabAll();
                    }
                    if (((WLAction.ChangeCardCheckState) this.$action).getPageIndex() == 1) {
                        WatchLaterTabState tabToView7 = this.$state.getTabToView();
                        WatchLaterList data4 = this.$state.getTabToView().getData();
                        Iterable $this$map$iv3 = this.$state.getTabToView().getData().getList();
                        WLAction wLAction7 = this.$action;
                        Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                        for (Object item$iv$iv3 : $this$map$iv3) {
                            WatchLaterItem item2 = (WatchLaterItem) item$iv$iv3;
                            if (Intrinsics.areEqual(item2.getItemId(), ((WLAction.ChangeCardCheckState) wLAction7).getItemId())) {
                                item2 = item2.copy((r40 & 1) != 0 ? item2.cardType : 0, (r40 & 2) != 0 ? item2.aid : 0L, (r40 & 4) != 0 ? item2.title : null, (r40 & 8) != 0 ? item2.intro : null, (r40 & 16) != 0 ? item2.pic : null, (r40 & 32) != 0 ? item2.duration : 0L, (r40 & 64) != 0 ? item2.progress : 0L, (r40 & 128) != 0 ? item2.uri : null, (r40 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? item2.arcState : 0, (r40 & 512) != 0 ? item2.pgcLabel : null, (r40 & 1024) != 0 ? item2.showUp : false, (r40 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? item2.forbidFav : false, (r40 & 4096) != 0 ? item2.owner : null, (r40 & 8192) != 0 ? item2.leftIconType : 0, (r40 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) != 0 ? item2.leftText : null, (r40 & 32768) != 0 ? item2.rightIconType : 0, (r40 & 65536) != 0 ? item2.rightText : null, (r40 & 131072) != 0 ? item2.isChecked : !item2.isChecked(), (r40 & 262144) != 0 ? item2.itemId : null);
                            }
                            destination$iv$iv4.add(item2);
                        }
                        tabToView3 = WatchLaterTabState.copy$default(tabToView7, data4.copy((List) destination$iv$iv4), null, null, false, false, false, 62, null);
                    } else {
                        tabToView3 = this.$state.getTabToView();
                    }
                    return WatchLaterState.copy$default(watchLaterState9, tabAll3, tabToView3, false, false, 12, null);
                } else if (wLAction instanceof WLAction.CheckAll) {
                    if (((WLAction.CheckAll) this.$action).getPageIndex() == 0) {
                        Iterable $this$all$iv = this.$state.getTabAll().getData().getList();
                        if (!($this$all$iv instanceof Collection) || !((Collection) $this$all$iv).isEmpty()) {
                            for (Object element$iv2 : $this$all$iv) {
                                if (!((WatchLaterItem) element$iv2).isChecked()) {
                                    element$iv = null;
                                }
                            }
                            element$iv = 1;
                        }
                        element$iv = 1;
                    } else {
                        Iterable $this$all$iv2 = this.$state.getTabToView().getData().getList();
                        if (!($this$all$iv2 instanceof Collection) || !((Collection) $this$all$iv2).isEmpty()) {
                            for (Object element$iv3 : $this$all$iv2) {
                                if (!((WatchLaterItem) element$iv3).isChecked()) {
                                    element$iv = null;
                                }
                            }
                            element$iv = 1;
                        }
                        element$iv = 1;
                    }
                    WatchLaterState watchLaterState10 = this.$state;
                    if (((WLAction.CheckAll) this.$action).getPageIndex() == 0) {
                        WatchLaterTabState tabAll8 = this.$state.getTabAll();
                        WatchLaterList data5 = this.$state.getTabAll().getData();
                        Iterable $this$map$iv4 = this.$state.getTabAll().getData().getList();
                        Collection destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                        for (Object item$iv$iv4 : $this$map$iv4) {
                            WatchLaterItem it3 = (WatchLaterItem) item$iv$iv4;
                            if (it3.isChecked() != (element$iv == null)) {
                                it3 = it3.copy((r40 & 1) != 0 ? it3.cardType : 0, (r40 & 2) != 0 ? it3.aid : 0L, (r40 & 4) != 0 ? it3.title : null, (r40 & 8) != 0 ? it3.intro : null, (r40 & 16) != 0 ? it3.pic : null, (r40 & 32) != 0 ? it3.duration : 0L, (r40 & 64) != 0 ? it3.progress : 0L, (r40 & 128) != 0 ? it3.uri : null, (r40 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? it3.arcState : 0, (r40 & 512) != 0 ? it3.pgcLabel : null, (r40 & 1024) != 0 ? it3.showUp : false, (r40 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? it3.forbidFav : false, (r40 & 4096) != 0 ? it3.owner : null, (r40 & 8192) != 0 ? it3.leftIconType : 0, (r40 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) != 0 ? it3.leftText : null, (r40 & 32768) != 0 ? it3.rightIconType : 0, (r40 & 65536) != 0 ? it3.rightText : null, (r40 & 131072) != 0 ? it3.isChecked : element$iv == null, (r40 & 262144) != 0 ? it3.itemId : null);
                            }
                            destination$iv$iv5.add(it3);
                        }
                        tabAll2 = WatchLaterTabState.copy$default(tabAll8, data5.copy((List) destination$iv$iv5), null, null, false, false, false, 62, null);
                    } else {
                        tabAll2 = this.$state.getTabAll();
                    }
                    if (((WLAction.CheckAll) this.$action).getPageIndex() == 1) {
                        WatchLaterTabState tabToView8 = this.$state.getTabToView();
                        WatchLaterList data6 = this.$state.getTabToView().getData();
                        Iterable $this$map$iv5 = this.$state.getTabToView().getData().getList();
                        Collection destination$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                        for (Object item$iv$iv5 : $this$map$iv5) {
                            WatchLaterItem it4 = (WatchLaterItem) item$iv$iv5;
                            if (it4.isChecked() != (element$iv == null)) {
                                it4 = it4.copy((r40 & 1) != 0 ? it4.cardType : 0, (r40 & 2) != 0 ? it4.aid : 0L, (r40 & 4) != 0 ? it4.title : null, (r40 & 8) != 0 ? it4.intro : null, (r40 & 16) != 0 ? it4.pic : null, (r40 & 32) != 0 ? it4.duration : 0L, (r40 & 64) != 0 ? it4.progress : 0L, (r40 & 128) != 0 ? it4.uri : null, (r40 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? it4.arcState : 0, (r40 & 512) != 0 ? it4.pgcLabel : null, (r40 & 1024) != 0 ? it4.showUp : false, (r40 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? it4.forbidFav : false, (r40 & 4096) != 0 ? it4.owner : null, (r40 & 8192) != 0 ? it4.leftIconType : 0, (r40 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) != 0 ? it4.leftText : null, (r40 & 32768) != 0 ? it4.rightIconType : 0, (r40 & 65536) != 0 ? it4.rightText : null, (r40 & 131072) != 0 ? it4.isChecked : element$iv == null, (r40 & 262144) != 0 ? it4.itemId : null);
                            }
                            destination$iv$iv6.add(it4);
                        }
                        tabToView2 = WatchLaterTabState.copy$default(tabToView8, data6.copy((List) destination$iv$iv6), null, null, false, false, false, 62, null);
                    } else {
                        tabToView2 = this.$state.getTabToView();
                    }
                    return WatchLaterState.copy$default(watchLaterState10, tabAll2, tabToView2, false, false, 12, null);
                } else if (wLAction instanceof WLAction.CancelAll) {
                    WatchLaterState watchLaterState11 = this.$state;
                    if (((WLAction.CancelAll) this.$action).getPageIndex() == 0) {
                        WatchLaterTabState tabAll9 = this.$state.getTabAll();
                        WatchLaterList data7 = this.$state.getTabAll().getData();
                        Iterable $this$map$iv6 = this.$state.getTabAll().getData().getList();
                        Collection destination$iv$iv7 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv6, 10));
                        for (Object item$iv$iv6 : $this$map$iv6) {
                            WatchLaterItem it5 = (WatchLaterItem) item$iv$iv6;
                            destination$iv$iv7.add(!it5.isChecked() ? it5 : it5.copy((r40 & 1) != 0 ? it5.cardType : 0, (r40 & 2) != 0 ? it5.aid : 0L, (r40 & 4) != 0 ? it5.title : null, (r40 & 8) != 0 ? it5.intro : null, (r40 & 16) != 0 ? it5.pic : null, (r40 & 32) != 0 ? it5.duration : 0L, (r40 & 64) != 0 ? it5.progress : 0L, (r40 & 128) != 0 ? it5.uri : null, (r40 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? it5.arcState : 0, (r40 & 512) != 0 ? it5.pgcLabel : null, (r40 & 1024) != 0 ? it5.showUp : false, (r40 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? it5.forbidFav : false, (r40 & 4096) != 0 ? it5.owner : null, (r40 & 8192) != 0 ? it5.leftIconType : 0, (r40 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) != 0 ? it5.leftText : null, (r40 & 32768) != 0 ? it5.rightIconType : 0, (r40 & 65536) != 0 ? it5.rightText : null, (r40 & 131072) != 0 ? it5.isChecked : false, (r40 & 262144) != 0 ? it5.itemId : null));
                        }
                        tabAll = WatchLaterTabState.copy$default(tabAll9, data7.copy((List) destination$iv$iv7), null, null, false, false, false, 62, null);
                    } else {
                        tabAll = this.$state.getTabAll();
                    }
                    if (((WLAction.CancelAll) this.$action).getPageIndex() == 1) {
                        WatchLaterTabState tabToView9 = this.$state.getTabToView();
                        WatchLaterList data8 = this.$state.getTabToView().getData();
                        Iterable $this$map$iv7 = this.$state.getTabToView().getData().getList();
                        Collection destination$iv$iv8 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv7, 10));
                        for (Object item$iv$iv7 : $this$map$iv7) {
                            WatchLaterItem it6 = (WatchLaterItem) item$iv$iv7;
                            if (it6.isChecked()) {
                                copy = it6.copy((r40 & 1) != 0 ? it6.cardType : 0, (r40 & 2) != 0 ? it6.aid : 0L, (r40 & 4) != 0 ? it6.title : null, (r40 & 8) != 0 ? it6.intro : null, (r40 & 16) != 0 ? it6.pic : null, (r40 & 32) != 0 ? it6.duration : 0L, (r40 & 64) != 0 ? it6.progress : 0L, (r40 & 128) != 0 ? it6.uri : null, (r40 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? it6.arcState : 0, (r40 & 512) != 0 ? it6.pgcLabel : null, (r40 & 1024) != 0 ? it6.showUp : false, (r40 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? it6.forbidFav : false, (r40 & 4096) != 0 ? it6.owner : null, (r40 & 8192) != 0 ? it6.leftIconType : 0, (r40 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) != 0 ? it6.leftText : null, (r40 & 32768) != 0 ? it6.rightIconType : 0, (r40 & 65536) != 0 ? it6.rightText : null, (r40 & 131072) != 0 ? it6.isChecked : false, (r40 & 262144) != 0 ? it6.itemId : null);
                                it6 = copy;
                            }
                            destination$iv$iv8.add(it6);
                        }
                        tabToView = WatchLaterTabState.copy$default(tabToView9, data8.copy((List) destination$iv$iv8), null, null, false, false, false, 62, null);
                    } else {
                        tabToView = this.$state.getTabToView();
                    }
                    return WatchLaterState.copy$default(watchLaterState11, tabAll, tabToView, false, false, 12, null);
                } else if (!(wLAction instanceof WLAction.DeleteItem)) {
                    if (wLAction instanceof WLAction.BatchOperation) {
                        WatchLaterState watchLaterState12 = this.$state;
                        final WatchLaterViewModel watchLaterViewModel9 = this.this$0;
                        WatchLaterState watchLaterState13 = this.$state;
                        WLAction wLAction8 = this.$action;
                        if (((Number) watchLaterViewModel9.curPageIndex.getValue()).intValue() == 0) {
                            Iterable $this$filterTo$iv$iv2 = watchLaterState13.getTabAll().getData().getList();
                            Collection destination$iv$iv9 = new ArrayList();
                            for (Object element$iv$iv2 : $this$filterTo$iv$iv2) {
                                WatchLaterItem it7 = (WatchLaterItem) element$iv$iv2;
                                if (((!it7.isChecked() || it7.getForbidFav()) ? null : 1) != null) {
                                    destination$iv$iv9.add(element$iv$iv2);
                                }
                            }
                            checkedList = (List) destination$iv$iv9;
                        } else {
                            Iterable $this$filterTo$iv$iv3 = watchLaterState13.getTabToView().getData().getList();
                            Collection destination$iv$iv10 = new ArrayList();
                            for (Object element$iv$iv3 : $this$filterTo$iv$iv3) {
                                WatchLaterItem it8 = (WatchLaterItem) element$iv$iv3;
                                if (((!it8.isChecked() || it8.getForbidFav()) ? null : 1) != null) {
                                    destination$iv$iv10.add(element$iv$iv3);
                                }
                            }
                            checkedList = (List) destination$iv$iv10;
                        }
                        final int count = checkedList.size();
                        FavoriteService favoriteService = (FavoriteService) BLRouter.INSTANCE.get(FavoriteService.class, "FAVORITE_SERVICE");
                        if (favoriteService != null) {
                            WLAction.BatchOperation batchOperation = (WLAction.BatchOperation) wLAction8;
                            favoriteService.showFavoriteSingleBottomSheet(batchOperation.getFragmentManager(), count, batchOperation.getOpType(), new OnFavoChangedListenerV2() { // from class: tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel$onAction$1$18$1
                                public void onCopySuccess() {
                                    WatchLaterViewModel.this.sendAction(WLAction.ChangeCheckState.INSTANCE);
                                    WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_BATCH_COPY_CLICK, MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_NUM, String.valueOf(count))));
                                }

                                public void onMoveSuccess() {
                                    WatchLaterViewModel.this.sendAction(new WLAction.DeleteChecked(false));
                                    WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_BATCH_MOVE_CLICK, MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_NUM, String.valueOf(count))));
                                }

                                public void onFailed() {
                                    WatchLaterViewModel.this.sendAction(WLAction.ChangeCheckState.INSTANCE);
                                }

                                public String getMediaListResource() {
                                    return WatchLaterViewModelKt.toResourceString(checkedList);
                                }
                            });
                            Unit unit2 = Unit.INSTANCE;
                            return watchLaterState12;
                        }
                        return watchLaterState12;
                    }
                    throw new NoWhenBranchMatchedException();
                } else {
                    WatchLaterTabState tabAll10 = this.$state.getTabAll();
                    WatchLaterList data9 = this.$state.getTabAll().getData();
                    List<WatchLaterItem> list4 = this.$state.getTabAll().getData().getList();
                    final WLAction wLAction9 = this.$action;
                    WatchLaterTabState tabAll11 = WatchLaterTabState.copy$default(tabAll10, data9.copy(WatchLaterViewModelKt.filterNotItem(list4, new Function1() { // from class: tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel$onAction$1$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            boolean invokeSuspend$lambda$21;
                            invokeSuspend$lambda$21 = WatchLaterViewModel$onAction$1.invokeSuspend$lambda$21(WLAction.this, (WatchLaterItem) obj);
                            return Boolean.valueOf(invokeSuspend$lambda$21);
                        }
                    })), null, null, false, false, false, 62, null);
                    WatchLaterTabState tabToView10 = this.$state.getTabToView();
                    WatchLaterList data10 = this.$state.getTabToView().getData();
                    List<WatchLaterItem> list5 = this.$state.getTabToView().getData().getList();
                    final WLAction wLAction10 = this.$action;
                    WatchLaterTabState tabToView11 = WatchLaterTabState.copy$default(tabToView10, data10.copy(WatchLaterViewModelKt.filterNotItem(list5, new Function1() { // from class: tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel$onAction$1$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            boolean invokeSuspend$lambda$22;
                            invokeSuspend$lambda$22 = WatchLaterViewModel$onAction$1.invokeSuspend$lambda$22(WLAction.this, (WatchLaterItem) obj);
                            return Boolean.valueOf(invokeSuspend$lambda$22);
                        }
                    })), null, null, false, false, false, 62, null);
                    copy$default = WatchLaterState.copy$default(this.$state, (!tabAll11.getData().getList().isEmpty() || tabAll11.getHasMore()) ? tabAll11 : WatchLaterTabState.copy$default(tabAll11, null, PageState.Empty.INSTANCE, null, false, false, false, 61, null), (!tabToView11.getData().getList().isEmpty() || tabToView11.getHasMore()) ? tabToView11 : WatchLaterTabState.copy$default(tabToView11, null, PageState.Empty.INSTANCE, null, false, false, false, 61, null), false, false, 12, null);
                    WatchLaterViewModel watchLaterViewModel10 = this.this$0;
                    WatchLaterState watchLaterState14 = this.$state;
                    WLAction wLAction11 = this.$action;
                    if (((Number) watchLaterViewModel10.curPageIndex.getValue()).intValue() == 0) {
                        Iterable $this$filterTo$iv$iv4 = watchLaterState14.getTabAll().getData().getList();
                        Collection destination$iv$iv11 = new ArrayList();
                        for (Object element$iv$iv4 : $this$filterTo$iv$iv4) {
                            if ((((WatchLaterItem) element$iv$iv4).getAid() == ((WLAction.DeleteItem) wLAction11).getAid() ? 1 : null) != null) {
                                destination$iv$iv11.add(element$iv$iv4);
                            }
                        }
                        deleteList = (List) destination$iv$iv11;
                    } else {
                        Iterable $this$filterTo$iv$iv5 = watchLaterState14.getTabToView().getData().getList();
                        Collection destination$iv$iv12 = new ArrayList();
                        for (Object element$iv$iv5 : $this$filterTo$iv$iv5) {
                            if ((((WatchLaterItem) element$iv$iv5).getAid() == ((WLAction.DeleteItem) wLAction11).getAid() ? 1 : null) != null) {
                                destination$iv$iv12.add(element$iv$iv5);
                            }
                        }
                        deleteList = (List) destination$iv$iv12;
                    }
                    String resourceString2 = WatchLaterViewModelKt.toResourceString(deleteList);
                    this.L$0 = copy$default;
                    this.label = 6;
                    deleteVideos = watchLaterViewModel10.deleteVideos(resourceString2, this);
                    if (deleteVideos == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = $result;
                    return copy$default;
                }
            case 1:
                $result7 = $result;
                watchLaterState5 = (WatchLaterState) this.L$0;
                ResultKt.throwOnFailure($result7);
                return watchLaterState5;
            case 2:
                $result6 = $result;
                watchLaterState4 = (WatchLaterState) this.L$0;
                ResultKt.throwOnFailure($result6);
                return watchLaterState4;
            case 3:
                $result5 = $result;
                z = false;
                watchLaterViewModel2 = (WatchLaterViewModel) this.L$2;
                copy$default2 = (WatchLaterState) this.L$1;
                deleteList2 = (List) this.L$0;
                ResultKt.throwOnFailure($result5);
                watchLaterViewModel = watchLaterViewModel2;
                watchLaterState3 = copy$default2;
                WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_BATCH_DELETE_CLICK, MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_NUM, String.valueOf(deleteList2.size()))));
                watchLaterViewModel.sendAction(WLAction.ChangeCheckState.INSTANCE);
                return watchLaterState3;
            case 4:
                $result4 = $result;
                watchLaterState2 = (WatchLaterState) this.L$0;
                ResultKt.throwOnFailure($result4);
                return watchLaterState2;
            case 5:
                $result3 = $result;
                watchLaterState = (WatchLaterState) this.L$0;
                ResultKt.throwOnFailure($result3);
                return watchLaterState;
            case 6:
                $result2 = $result;
                copy$default = (WatchLaterState) this.L$0;
                ResultKt.throwOnFailure($result2);
                return copy$default;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WatchLaterViewModel.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/watchlater/data/WLEvent;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel$onAction$1$5", f = "WatchLaterViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel$onAction$1$5  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass5 extends SuspendLambda implements Function1<Continuation<? super WLEvent>, Object> {
        int label;

        AnonymousClass5(Continuation<? super AnonymousClass5> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass5(continuation);
        }

        public final Object invoke(Continuation<? super WLEvent> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return new WLEvent.ShowToast(ToastType.NetworkError.INSTANCE);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$8(WLAction $action, List $deleteAidList, WatchLaterItem item) {
        if (((WLAction.DeleteChecked) $action).getRealDelete()) {
            return $deleteAidList.contains(Long.valueOf(item.getAid()));
        }
        return $deleteAidList.contains(Long.valueOf(item.getAid())) && !item.isInvalid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$9(WLAction $action, List $deleteAidList, WatchLaterItem item) {
        if (((WLAction.DeleteChecked) $action).getRealDelete()) {
            return $deleteAidList.contains(Long.valueOf(item.getAid()));
        }
        return $deleteAidList.contains(Long.valueOf(item.getAid())) && !item.isInvalid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$21(WLAction $action, WatchLaterItem it) {
        return it.getAid() == ((WLAction.DeleteItem) $action).getAid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$22(WLAction $action, WatchLaterItem it) {
        return it.getAid() == ((WLAction.DeleteItem) $action).getAid();
    }
}