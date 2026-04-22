package kntr.app.game.steam;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import kntr.app.ad.ad.biz.search.AdSearchSubCardType;
import kntr.app.game.base.viewmodel.PageLoadMoreState;
import kntr.app.game.base.viewmodel.PageState;
import kntr.app.game.base.viewmodel.event.PageEvent;
import kntr.app.game.bean.SteamDetailPageData;
import kntr.app.game.bean.SteamGameListSortType;
import kntr.app.game.report.ReportKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: SteamDetailVM.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/game/base/viewmodel/PageState;", "event", "Lkntr/app/game/base/viewmodel/event/PageEvent;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/game/base/viewmodel/PageState$Content;", "Lkntr/app/game/bean/SteamDetailPageData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.steam.SteamDetailVM$customContentBlock$1", f = "SteamDetailVM.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {193, 207, 221}, m = "invokeSuspend", n = {"event", "state", "current", "event", "state", "current", "page", "text", "toastStatus", "event", "state", "current", "page", "text", "toastStatus"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
final class SteamDetailVM$customContentBlock$1 extends SuspendLambda implements Function3<PageEvent, State<PageState.Content<SteamDetailPageData>>, Continuation<? super ChangedState<? extends PageState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ SteamDetailVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SteamDetailVM$customContentBlock$1(SteamDetailVM steamDetailVM, Continuation<? super SteamDetailVM$customContentBlock$1> continuation) {
        super(3, continuation);
        this.this$0 = steamDetailVM;
    }

    public final Object invoke(PageEvent pageEvent, State<PageState.Content<SteamDetailPageData>> state, Continuation<? super ChangedState<? extends PageState>> continuation) {
        SteamDetailVM$customContentBlock$1 steamDetailVM$customContentBlock$1 = new SteamDetailVM$customContentBlock$1(this.this$0, continuation);
        steamDetailVM$customContentBlock$1.L$0 = pageEvent;
        steamDetailVM$customContentBlock$1.L$1 = state;
        return steamDetailVM$customContentBlock$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0104 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0187  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        PageState.Content current;
        MutableStateFlow mutableStateFlow;
        Object refreshInfo;
        SteamDetailPageData page;
        String text;
        String toastStatus;
        MutableSharedFlow mutableSharedFlow;
        PageState.Content current2;
        String toastStatus2;
        SteamDetailPageData page2;
        String text2;
        MutableStateFlow mutableStateFlow2;
        Object requestGameList;
        final SteamDetailPageData page3;
        PageState.Content current3;
        List list;
        PageEvent event = (PageEvent) this.L$0;
        final State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                current = (PageState.Content) state.getSnapshot();
                if (current.getLoadMore().isLoading() || current.getRefreshState().getRefreshing()) {
                    KLog_androidKt.getKLog().d("SteamDetailVM", "customContentBlock loading: " + current.getLoadMore().isLoading() + ", refresh: " + current.getRefreshState().getRefreshing());
                    return state.noChange();
                } else if (!(event instanceof PageEvent.Custom) || !Intrinsics.areEqual(((PageEvent.Custom) event).getName(), this.this$0.getRefreshSteamDataEventName())) {
                    if ((event instanceof PageEvent.Custom) && Intrinsics.areEqual(((PageEvent.Custom) event).getName(), this.this$0.getDispatchSortTypeEventName())) {
                        KLog_androidKt.getKLog().d("SteamDetailVM", "dispatchSortTypeEventName");
                        Object content = ((PageEvent.Custom) event).getContent();
                        SteamGameListSortType type = content instanceof SteamGameListSortType ? (SteamGameListSortType) content : null;
                        if (type == null || this.this$0.getSortType() == type) {
                            KLog_androidKt.getKLog().d("SteamDetailVM", "dispatchSortTypeEventName type is null or same");
                            return state.noChange();
                        }
                        this.this$0.setSortType(type);
                        this.this$0.setRefreshSortType(true);
                        final SteamDetailPageData data = (SteamDetailPageData) ((PageState.Content) state.getSnapshot()).getData();
                        data.setList(CollectionsKt.emptyList());
                        return state.override(new Function1() { // from class: kntr.app.game.steam.SteamDetailVM$customContentBlock$1$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                PageState.Content invokeSuspend$lambda$1;
                                invokeSuspend$lambda$1 = SteamDetailVM$customContentBlock$1.invokeSuspend$lambda$1(state, data, (PageState.Content) obj);
                                return invokeSuspend$lambda$1;
                            }
                        });
                    }
                    return state.noChange();
                } else {
                    KLog_androidKt.getKLog().d("SteamDetailVM", "refreshSteamDataEventName");
                    mutableStateFlow = this.this$0.refreshSteamFlow;
                    mutableStateFlow.setValue(Boxing.boxBoolean(true));
                    this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                    this.L$1 = state;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(current);
                    this.label = 1;
                    refreshInfo = this.this$0.refreshInfo((Continuation) this);
                    if (refreshInfo == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    page = (SteamDetailPageData) refreshInfo;
                    if (page == null && !page.getNeedMakePublic()) {
                        text = "更新成功";
                        toastStatus = "1";
                    } else if (page == null) {
                        text = "未公开数据，需设置公开后更新";
                        toastStatus = AdSearchSubCardType.CARD_TYPE_3;
                    } else {
                        text = "更新失败，请稍后再试";
                        toastStatus = AdSearchSubCardType.CARD_TYPE_2;
                    }
                    mutableSharedFlow = this.this$0.toast;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                    this.L$1 = state;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(current);
                    this.L$3 = page;
                    this.L$4 = SpillingKt.nullOutSpilledVariable(text);
                    this.L$5 = toastStatus;
                    this.label = 2;
                    if (mutableSharedFlow.emit(text, (Continuation) this) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    String str = toastStatus;
                    current2 = current;
                    toastStatus2 = str;
                    String str2 = text;
                    page2 = page;
                    text2 = str2;
                    ReportKt.reportExposure("game-ball.steam-game-list.steam-game-list.update-toast.show", MapsKt.mapOf(TuplesKt.to("toast", toastStatus2)));
                    mutableStateFlow2 = this.this$0.refreshSteamFlow;
                    mutableStateFlow2.setValue(Boxing.boxBoolean(false));
                    if (page2 != null) {
                        return state.noChange();
                    }
                    this.this$0.setMPage(1);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                    this.L$1 = state;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(current2);
                    this.L$3 = page2;
                    this.L$4 = SpillingKt.nullOutSpilledVariable(text2);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(toastStatus2);
                    this.label = 3;
                    requestGameList = this.this$0.requestGameList(this.this$0.getMPage(), (Continuation) this);
                    if (requestGameList == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    page3 = page2;
                    current3 = current2;
                    list = (List) requestGameList;
                    if (list != null) {
                        this.this$0.setMPage(this.this$0.getMPage() + 1);
                    }
                    final PageLoadMoreState loadState = list != null ? PageLoadMoreState.Companion.getError() : list.isEmpty() ? PageLoadMoreState.Companion.getNoMore() : PageLoadMoreState.Companion.getIdle();
                    page3.setList(list);
                    return state.override(new Function1() { // from class: kntr.app.game.steam.SteamDetailVM$customContentBlock$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            PageState.Content invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = SteamDetailVM$customContentBlock$1.invokeSuspend$lambda$0(SteamDetailPageData.this, state, loadState, (PageState.Content) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                }
            case 1:
                current = (PageState.Content) this.L$2;
                ResultKt.throwOnFailure($result);
                refreshInfo = $result;
                page = (SteamDetailPageData) refreshInfo;
                if (page == null) {
                    break;
                }
                if (page == null) {
                }
                mutableSharedFlow = this.this$0.toast;
                this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                this.L$1 = state;
                this.L$2 = SpillingKt.nullOutSpilledVariable(current);
                this.L$3 = page;
                this.L$4 = SpillingKt.nullOutSpilledVariable(text);
                this.L$5 = toastStatus;
                this.label = 2;
                if (mutableSharedFlow.emit(text, (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 2:
                toastStatus2 = (String) this.L$5;
                text2 = (String) this.L$4;
                page2 = (SteamDetailPageData) this.L$3;
                current2 = (PageState.Content) this.L$2;
                ResultKt.throwOnFailure($result);
                ReportKt.reportExposure("game-ball.steam-game-list.steam-game-list.update-toast.show", MapsKt.mapOf(TuplesKt.to("toast", toastStatus2)));
                mutableStateFlow2 = this.this$0.refreshSteamFlow;
                mutableStateFlow2.setValue(Boxing.boxBoolean(false));
                if (page2 != null) {
                }
                break;
            case 3:
                String str3 = (String) this.L$5;
                String str4 = (String) this.L$4;
                page3 = (SteamDetailPageData) this.L$3;
                current3 = (PageState.Content) this.L$2;
                ResultKt.throwOnFailure($result);
                requestGameList = $result;
                list = (List) requestGameList;
                if (list != null) {
                }
                if (list != null) {
                }
                page3.setList(list);
                return state.override(new Function1() { // from class: kntr.app.game.steam.SteamDetailVM$customContentBlock$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        PageState.Content invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = SteamDetailVM$customContentBlock$1.invokeSuspend$lambda$0(SteamDetailPageData.this, state, loadState, (PageState.Content) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageState.Content invokeSuspend$lambda$0(SteamDetailPageData $page, State $state, PageLoadMoreState $loadState, PageState.Content $this$override) {
        return new PageState.Content($page, $loadState, ((PageState.Content) $state.getSnapshot()).getRefreshState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageState.Content invokeSuspend$lambda$1(State $state, SteamDetailPageData $data, PageState.Content $this$override) {
        return new PageState.Content($data, PageLoadMoreState.Companion.getLoading(), ((PageState.Content) $state.getSnapshot()).getRefreshState());
    }
}