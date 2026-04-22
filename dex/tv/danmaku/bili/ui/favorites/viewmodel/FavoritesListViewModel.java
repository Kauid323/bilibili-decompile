package tv.danmaku.bili.ui.favorites.viewmodel;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import androidx.lifecycle.ViewModelKt;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.lib.arch.lifecycle.Resource;
import com.bilibili.lib.arch.lifecycle.Status;
import com.bilibili.okretro.GeneralResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import shark.AndroidResourceIdNames;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.log.cache.RingBuffer;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotlist.model.HotListDataPacker;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.favorites.api.FavoritesApiManagerKt;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;
import tv.danmaku.bili.ui.favorites.model.FavoritesTabList;
import tv.danmaku.bili.ui.favorites.state.FavPageFooterState;
import tv.danmaku.bili.ui.favorites.state.FavPageState;
import tv.danmaku.bili.ui.favorites.state.FavTabState;
import tv.danmaku.bili.ui.favorites.state.FavoritesAction;
import tv.danmaku.bili.ui.favorites.state.FavoritesEvent;

/* compiled from: FavoritesListViewModel.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u0000 72\u001a\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0001:\u000278B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\r2\b\b\u0002\u0010)\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010*J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0014J\u0010\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020\u0002H\u0014J\u0016\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\rH\u0096@¢\u0006\u0002\u00100J\"\u00101\u001a\u00020\r2\u0006\u00102\u001a\u0002032\n\b\u0002\u00104\u001a\u0004\u0018\u000105H\u0082@¢\u0006\u0002\u00106R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\u0011¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014R\u0011\u0010#\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u00069"}, d2 = {"Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesListViewModel;", "Ltv/danmaku/bili/ui/favorites/viewmodel/BaseFavoritesViewModel;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", "Ltv/danmaku/bili/ui/favorites/state/FavTabState;", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent;", "tabId", "", "<init>", "(I)V", "getTabId", "()I", "isLoading", "", "requestParam", "Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesListViewModel$RequestParams;", "itemListFlow", "Lkotlinx/coroutines/flow/Flow;", "", "getItemListFlow", "()Lkotlinx/coroutines/flow/Flow;", "pageStateFlow", "Ltv/danmaku/bili/ui/favorites/state/FavPageState;", "getPageStateFlow", "footerStateFlow", "Ltv/danmaku/bili/ui/favorites/state/FavPageFooterState;", "getFooterStateFlow", "isRefreshing", "canRefresh", "getCanRefresh", "isCheckMode", "checkAll", "getCheckAll", "buttonClickable", "getButtonClickable", "hasInitPage", "getHasInitPage", "()Z", "getFavorites", "", "firstLoad", HotListDataPacker.METHOD_REFRESH, "(ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initUiState", "onAction", "action", "onDeleteSuccess", "success", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearInvalidItem", "resources", "", "fid", "", "(Ljava/lang/String;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "RequestParams", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesListViewModel extends BaseFavoritesViewModel<FavoritesAction, FavTabState<FavoritesMediasItem>, FavoritesEvent> {
    public static final String TAG = "FavoritesListViewModel";
    private final Flow<Boolean> buttonClickable;
    private final Flow<Boolean> canRefresh;
    private final Flow<Boolean> checkAll;
    private final Flow<FavPageFooterState> footerStateFlow;
    private final Flow<Boolean> isCheckMode;
    private boolean isLoading;
    private final Flow<Boolean> isRefreshing;
    private final Flow<List<FavoritesMediasItem>> itemListFlow;
    private final Flow<FavPageState> pageStateFlow;
    private RequestParams requestParam;
    private final int tabId;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public FavoritesListViewModel(int tabId) {
        this.tabId = tabId;
        this.requestParam = new RequestParams(0L, 0, 0, this.tabId, false, 23, null);
        final Flow $this$map$iv = getUiStateFlow();
        this.itemListFlow = FlowKt.distinctUntilChanged(new Flow<List<? extends FavoritesMediasItem>>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$1$2", f = "FavoritesListViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    FavTabState it = (FavTabState) value;
                                    List<T> itemList = it.getItemList();
                                    $continuation.label = 1;
                                    if (flowCollector.emit(itemList, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        });
        final Flow $this$map$iv2 = getUiStateFlow();
        this.pageStateFlow = FlowKt.distinctUntilChanged(new Flow<FavPageState>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$2

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$2$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$2$2", f = "FavoritesListViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$2$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    FavTabState it = (FavTabState) value;
                                    FavPageState pageState = it.getPageState();
                                    $continuation.label = 1;
                                    if (flowCollector.emit(pageState, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv2.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        });
        final Flow $this$map$iv3 = getUiStateFlow();
        this.footerStateFlow = FlowKt.distinctUntilChanged(new Flow<FavPageFooterState>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$3

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$3$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$3$2", f = "FavoritesListViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$3$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    FavTabState it = (FavTabState) value;
                                    FavPageFooterState footerState = it.getFooterState();
                                    $continuation.label = 1;
                                    if (flowCollector.emit(footerState, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv3.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        });
        final Flow $this$map$iv4 = getUiStateFlow();
        this.isRefreshing = FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$4

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$4$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$4$2", f = "FavoritesListViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$4$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    FavTabState it = (FavTabState) value;
                                    Boolean boxBoolean = Boxing.boxBoolean(it.isRefreshing());
                                    $continuation.label = 1;
                                    if (flowCollector.emit(boxBoolean, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv4.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        });
        final Flow $this$map$iv5 = getUiStateFlow();
        this.canRefresh = FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$5

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$5$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$5$2", f = "FavoritesListViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$5$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    FavTabState it = (FavTabState) value;
                                    Boolean boxBoolean = Boxing.boxBoolean((it.getItemList().isEmpty() || it.isCheckMode()) ? false : true);
                                    $continuation.label = 1;
                                    if (flowCollector.emit(boxBoolean, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv5.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        });
        final Flow $this$map$iv6 = getUiStateFlow();
        this.isCheckMode = FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$6

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$6$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$6$2", f = "FavoritesListViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$6$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    FavTabState it = (FavTabState) value;
                                    Boolean boxBoolean = Boxing.boxBoolean(it.isCheckMode());
                                    $continuation.label = 1;
                                    if (flowCollector.emit(boxBoolean, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv6.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        });
        final Flow $this$map$iv7 = getUiStateFlow();
        this.checkAll = FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$7

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$7$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$7$2", f = "FavoritesListViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$7$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    Iterable $this$all$iv;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    FavTabState state = (FavTabState) value;
                                    boolean z = false;
                                    if (!state.getItemList().isEmpty()) {
                                        Iterable $this$all$iv2 = state.getItemList();
                                        if (($this$all$iv2 instanceof Collection) && ((Collection) $this$all$iv2).isEmpty()) {
                                            $this$all$iv = 1;
                                        } else {
                                            Iterator<T> it = $this$all$iv2.iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    Object element$iv = it.next();
                                                    FavoritesMediasItem it2 = (FavoritesMediasItem) element$iv;
                                                    if (!it2.isChecked()) {
                                                        $this$all$iv = null;
                                                    }
                                                } else {
                                                    $this$all$iv = 1;
                                                }
                                            }
                                        }
                                        if ($this$all$iv != null) {
                                            z = true;
                                        }
                                    }
                                    Boolean boxBoolean = Boxing.boxBoolean(z);
                                    $continuation.label = 1;
                                    if (flowCollector.emit(boxBoolean, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv7.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        });
        final Flow $this$map$iv8 = getUiStateFlow();
        this.buttonClickable = FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$8

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$8$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$8$2", f = "FavoritesListViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$special$$inlined$map$8$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    int count$iv;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    FavTabState state = (FavTabState) value;
                                    Iterable $this$count$iv = state.getItemList();
                                    if (($this$count$iv instanceof Collection) && ((Collection) $this$count$iv).isEmpty()) {
                                        count$iv = 0;
                                    } else {
                                        count$iv = 0;
                                        for (Object element$iv : $this$count$iv) {
                                            FavoritesMediasItem item = (FavoritesMediasItem) element$iv;
                                            if (item.isChecked() && (count$iv = count$iv + 1) < 0) {
                                                CollectionsKt.throwCountOverflow();
                                            }
                                        }
                                    }
                                    Boolean boxBoolean = Boxing.boxBoolean(count$iv > 0);
                                    $continuation.label = 1;
                                    if (flowCollector.emit(boxBoolean, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
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
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv8.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        });
    }

    public final int getTabId() {
        return this.tabId;
    }

    public final Flow<List<FavoritesMediasItem>> getItemListFlow() {
        return this.itemListFlow;
    }

    public final Flow<FavPageState> getPageStateFlow() {
        return this.pageStateFlow;
    }

    public final Flow<FavPageFooterState> getFooterStateFlow() {
        return this.footerStateFlow;
    }

    public final Flow<Boolean> isRefreshing() {
        return this.isRefreshing;
    }

    public final Flow<Boolean> getCanRefresh() {
        return this.canRefresh;
    }

    public final Flow<Boolean> isCheckMode() {
        return this.isCheckMode;
    }

    public final Flow<Boolean> getCheckAll() {
        return this.checkAll;
    }

    public final Flow<Boolean> getButtonClickable() {
        return this.buttonClickable;
    }

    public final boolean getHasInitPage() {
        return !((FavTabState) getUiStateFlow().getValue()).getItemList().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0189  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getFavorites(boolean firstLoad, boolean refresh, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> favoritesListViewModel$getFavorites$1;
        FavoritesListViewModel favoritesListViewModel;
        Object favoritesList;
        boolean refresh2;
        boolean firstLoad2;
        Resource $this$suspendThen$iv;
        boolean z;
        FavoritesListViewModel favoritesListViewModel2;
        Resource $this$catch$iv;
        if (continuation instanceof FavoritesListViewModel$getFavorites$1) {
            favoritesListViewModel$getFavorites$1 = (FavoritesListViewModel$getFavorites$1) continuation;
            if ((favoritesListViewModel$getFavorites$1.label & Integer.MIN_VALUE) != 0) {
                favoritesListViewModel$getFavorites$1.label -= Integer.MIN_VALUE;
                Object $result = favoritesListViewModel$getFavorites$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (favoritesListViewModel$getFavorites$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        favoritesListViewModel = this;
                        if (favoritesListViewModel.isLoading) {
                            return Unit.INSTANCE;
                        }
                        if (firstLoad || favoritesListViewModel.requestParam.getHasMore() || refresh) {
                            favoritesListViewModel.isLoading = true;
                            if (refresh) {
                                favoritesListViewModel.requestParam = new RequestParams(0L, 0, 0, favoritesListViewModel.tabId, false, 23, null);
                            }
                            final boolean z2 = firstLoad;
                            final boolean z3 = refresh;
                            favoritesListViewModel.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    FavTabState favorites$lambda$0;
                                    favorites$lambda$0 = FavoritesListViewModel.getFavorites$lambda$0(z2, z3, (FavTabState) obj);
                                    return favorites$lambda$0;
                                }
                            });
                            long nextOid = favoritesListViewModel.requestParam.getNextOid();
                            int nextOType = favoritesListViewModel.requestParam.getNextOType();
                            int tabId = favoritesListViewModel.requestParam.getTabId();
                            int nextScore = favoritesListViewModel.requestParam.getNextScore();
                            favoritesListViewModel$getFavorites$1.Z$0 = firstLoad;
                            favoritesListViewModel$getFavorites$1.Z$1 = refresh;
                            favoritesListViewModel$getFavorites$1.label = 1;
                            favoritesList = FavoritesApiManagerKt.getFavoritesList(nextOid, nextOType, tabId, nextScore, favoritesListViewModel$getFavorites$1);
                            if (favoritesList != coroutine_suspended) {
                                refresh2 = refresh;
                                firstLoad2 = firstLoad;
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        } else {
                            return Unit.INSTANCE;
                        }
                        break;
                    case 1:
                        refresh2 = favoritesListViewModel$getFavorites$1.Z$1;
                        boolean firstLoad3 = favoritesListViewModel$getFavorites$1.Z$0;
                        ResultKt.throwOnFailure($result);
                        favoritesListViewModel = this;
                        firstLoad2 = firstLoad3;
                        favoritesList = $result;
                        break;
                    case 2:
                        favoritesListViewModel2 = this;
                        z = false;
                        firstLoad2 = favoritesListViewModel$getFavorites$1.Z$0;
                        $this$suspendThen$iv = (Resource) favoritesListViewModel$getFavorites$1.L$0;
                        ResultKt.throwOnFailure($result);
                        favoritesListViewModel = favoritesListViewModel2;
                        $this$catch$iv = $this$suspendThen$iv;
                        if ($this$catch$iv.getStatus() == Status.ERROR && $this$catch$iv.getError() != null) {
                            Throwable it = $this$catch$iv.getError();
                            Intrinsics.checkNotNull(it);
                            BLog.e(TAG, it.getMessage());
                            favoritesListViewModel.isLoading = false;
                            final boolean z4 = firstLoad2;
                            favoritesListViewModel.updateState(new Function1<FavTabState<FavoritesMediasItem>, FavTabState<FavoritesMediasItem>>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$getFavorites$4$1
                                public final FavTabState<FavoritesMediasItem> invoke(FavTabState<FavoritesMediasItem> favTabState) {
                                    FavPageState pageState;
                                    FavTabState<FavoritesMediasItem> copy;
                                    Intrinsics.checkNotNullParameter(favTabState, "$this$updateState");
                                    if (z4) {
                                        pageState = ConnectivityMonitor.getInstance().isNetworkActive() ? FavPageState.OtherError.INSTANCE : FavPageState.NetworkError.INSTANCE;
                                    } else {
                                        pageState = favTabState.getPageState();
                                    }
                                    copy = favTabState.copy((r18 & 1) != 0 ? favTabState.pageState : pageState, (r18 & 2) != 0 ? favTabState.footerState : null, (r18 & 4) != 0 ? favTabState.itemList : null, (r18 & 8) != 0 ? favTabState.isRefreshing : false, (r18 & 16) != 0 ? favTabState.isCheckMode : false, (r18 & 32) != 0 ? favTabState.pageNum : 0, (r18 & 64) != 0 ? favTabState.hasMore : false, (r18 & BR.cover) != 0 ? favTabState.hasInvalid : false);
                                    return copy;
                                }
                            });
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                $this$suspendThen$iv = (Resource) favoritesList;
                if ($this$suspendThen$iv.getStatus() == Status.SUCCESS) {
                    final FavoritesTabList res = (FavoritesTabList) $this$suspendThen$iv.getData();
                    favoritesListViewModel.isLoading = false;
                    if (res != null) {
                        List<FavoritesMediasItem> list = res.getList();
                        if (!(list == null || list.isEmpty())) {
                            final boolean z5 = firstLoad2;
                            final boolean z6 = refresh2;
                            favoritesListViewModel.updateState(new Function1<FavTabState<FavoritesMediasItem>, FavTabState<FavoritesMediasItem>>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$getFavorites$3$2
                                public final FavTabState<FavoritesMediasItem> invoke(FavTabState<FavoritesMediasItem> favTabState) {
                                    FavTabState<FavoritesMediasItem> copy;
                                    FavoritesMediasItem copy2;
                                    Intrinsics.checkNotNullParameter(favTabState, "$this$updateState");
                                    boolean beforeHasInvalid = favTabState.getHasInvalid() || FavoritesTabList.this.getHasInvalid();
                                    FavPageState.Success success = FavPageState.Success.INSTANCE;
                                    List $this$invoke_u24lambda_u240 = CollectionsKt.toMutableList(favTabState.getItemList());
                                    boolean z7 = z5;
                                    boolean z8 = z6;
                                    FavoritesTabList favoritesTabList = FavoritesTabList.this;
                                    if (z7 || z8) {
                                        $this$invoke_u24lambda_u240.clear();
                                    }
                                    Iterable $this$map$iv = favoritesTabList.getList();
                                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                    for (Object item$iv$iv : $this$map$iv) {
                                        FavoritesMediasItem it2 = (FavoritesMediasItem) item$iv$iv;
                                        copy2 = it2.copy((r45 & 1) != 0 ? it2.cntInfo : null, (r45 & 2) != 0 ? it2.cover : null, (r45 & 4) != 0 ? it2.favTime : 0, (r45 & 8) != 0 ? it2.oid : 0L, (r45 & 16) != 0 ? it2.intro : null, (r45 & 32) != 0 ? it2.link : null, (r45 & 64) != 0 ? it2.ogv : null, (r45 & BR.cover) != 0 ? it2.ugc : null, (r45 & BR.hallEnterHotText) != 0 ? it2.page : 0, (r45 & BR.roleType) != 0 ? it2.playbackPosition : 0, (r45 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? it2.playbackDesc : null, (r45 & 2048) != 0 ? it2.title : null, (r45 & 4096) != 0 ? it2.otype : 0, (r45 & 8192) != 0 ? it2.upper : null, (r45 & RingBuffer.CONSUME_SIZE) != 0 ? it2.leftText : null, (r45 & 32768) != 0 ? it2.leftIconType : 0, (r45 & AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR) != 0 ? it2.rightText : null, (r45 & 131072) != 0 ? it2.rightIconType : 0, (r45 & 262144) != 0 ? it2.userState : 0, (r45 & 524288) != 0 ? it2.isCheckMode : favTabState.isCheckMode(), (r45 & 1048576) != 0 ? it2.isChecked : false, (r45 & 2097152) != 0 ? it2.cardType : 0, (r45 & 4194304) != 0 ? it2.enableDrag : false, (r45 & 8388608) != 0 ? it2.canDrag : false, (r45 & 16777216) != 0 ? it2.isInvalid : false, (r45 & 33554432) != 0 ? it2.translateInfo : null);
                                        destination$iv$iv.add(copy2);
                                    }
                                    $this$invoke_u24lambda_u240.addAll((List) destination$iv$iv);
                                    copy = favTabState.copy((r18 & 1) != 0 ? favTabState.pageState : success, (r18 & 2) != 0 ? favTabState.footerState : (FavoritesTabList.this.getHasMore() || !beforeHasInvalid) ? FavPageFooterState.Gone.INSTANCE : FavPageFooterState.CleanInvalid.INSTANCE, (r18 & 4) != 0 ? favTabState.itemList : $this$invoke_u24lambda_u240, (r18 & 8) != 0 ? favTabState.isRefreshing : false, (r18 & 16) != 0 ? favTabState.isCheckMode : false, (r18 & 32) != 0 ? favTabState.pageNum : 0, (r18 & 64) != 0 ? favTabState.hasMore : FavoritesTabList.this.getHasMore(), (r18 & BR.cover) != 0 ? favTabState.hasInvalid : beforeHasInvalid);
                                    return copy;
                                }
                            });
                            favoritesListViewModel.requestParam = RequestParams.copy$default(favoritesListViewModel.requestParam, res.getNextOid(), res.getNextOType(), res.getNextScore(), 0, res.getHasMore(), 8, null);
                            if (refresh2) {
                                favoritesListViewModel$getFavorites$1.L$0 = $this$suspendThen$iv;
                                favoritesListViewModel$getFavorites$1.Z$0 = firstLoad2;
                                favoritesListViewModel$getFavorites$1.label = 2;
                                if (favoritesListViewModel.sendEffect(FavoritesEvent.ScrollToTop.INSTANCE, favoritesListViewModel$getFavorites$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                z = false;
                                favoritesListViewModel2 = favoritesListViewModel;
                                favoritesListViewModel = favoritesListViewModel2;
                            }
                        }
                    }
                    final boolean z7 = firstLoad2;
                    final boolean refresh3 = refresh2;
                    favoritesListViewModel.updateState(new Function1<FavTabState<FavoritesMediasItem>, FavTabState<FavoritesMediasItem>>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$getFavorites$3$1
                        /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
                            if ((r0 != null ? r0.getHasInvalid() : false) != false) goto L33;
                         */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final FavTabState<FavoritesMediasItem> invoke(FavTabState<FavoritesMediasItem> favTabState) {
                            boolean z8;
                            FavPageState favPageState;
                            FavTabState<FavoritesMediasItem> copy;
                            Intrinsics.checkNotNullParameter(favTabState, "$this$updateState");
                            if (!favTabState.getHasInvalid()) {
                                FavoritesTabList favoritesTabList = FavoritesTabList.this;
                                z8 = false;
                            }
                            z8 = true;
                            boolean allBeforeHasInvalid = z8;
                            FavoritesTabList favoritesTabList2 = FavoritesTabList.this;
                            boolean nextHasMore = favoritesTabList2 != null ? favoritesTabList2.getHasMore() : true;
                            if (z7 || refresh3) {
                                if (allBeforeHasInvalid) {
                                    favPageState = FavPageState.CleanInvalid.INSTANCE;
                                } else {
                                    favPageState = FavPageState.Empty.INSTANCE;
                                }
                            } else {
                                favPageState = favTabState.getPageState();
                            }
                            copy = favTabState.copy((r18 & 1) != 0 ? favTabState.pageState : favPageState, (r18 & 2) != 0 ? favTabState.footerState : (nextHasMore || !allBeforeHasInvalid) ? favTabState.getFooterState() : FavPageFooterState.CleanInvalid.INSTANCE, (r18 & 4) != 0 ? favTabState.itemList : (z7 || refresh3) ? CollectionsKt.emptyList() : favTabState.getItemList(), (r18 & 8) != 0 ? favTabState.isRefreshing : false, (r18 & 16) != 0 ? favTabState.isCheckMode : false, (r18 & 32) != 0 ? favTabState.pageNum : 0, (r18 & 64) != 0 ? favTabState.hasMore : nextHasMore, (r18 & BR.cover) != 0 ? favTabState.hasInvalid : allBeforeHasInvalid);
                            return copy;
                        }
                    });
                }
                $this$catch$iv = $this$suspendThen$iv;
                if ($this$catch$iv.getStatus() == Status.ERROR) {
                    Throwable it2 = $this$catch$iv.getError();
                    Intrinsics.checkNotNull(it2);
                    BLog.e(TAG, it2.getMessage());
                    favoritesListViewModel.isLoading = false;
                    if (firstLoad2) {
                    }
                    favoritesListViewModel.updateState(new Function1<FavTabState<FavoritesMediasItem>, FavTabState<FavoritesMediasItem>>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$getFavorites$4$1
                        public final FavTabState<FavoritesMediasItem> invoke(FavTabState<FavoritesMediasItem> favTabState) {
                            FavPageState pageState;
                            FavTabState<FavoritesMediasItem> copy;
                            Intrinsics.checkNotNullParameter(favTabState, "$this$updateState");
                            if (z4) {
                                pageState = ConnectivityMonitor.getInstance().isNetworkActive() ? FavPageState.OtherError.INSTANCE : FavPageState.NetworkError.INSTANCE;
                            } else {
                                pageState = favTabState.getPageState();
                            }
                            copy = favTabState.copy((r18 & 1) != 0 ? favTabState.pageState : pageState, (r18 & 2) != 0 ? favTabState.footerState : null, (r18 & 4) != 0 ? favTabState.itemList : null, (r18 & 8) != 0 ? favTabState.isRefreshing : false, (r18 & 16) != 0 ? favTabState.isCheckMode : false, (r18 & 32) != 0 ? favTabState.pageNum : 0, (r18 & 64) != 0 ? favTabState.hasMore : false, (r18 & BR.cover) != 0 ? favTabState.hasInvalid : false);
                            return copy;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        }
        favoritesListViewModel$getFavorites$1 = new FavoritesListViewModel$getFavorites$1(this, continuation);
        Object $result2 = favoritesListViewModel$getFavorites$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (favoritesListViewModel$getFavorites$1.label) {
        }
        $this$suspendThen$iv = (Resource) favoritesList;
        if ($this$suspendThen$iv.getStatus() == Status.SUCCESS) {
        }
        $this$catch$iv = $this$suspendThen$iv;
        if ($this$catch$iv.getStatus() == Status.ERROR) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object getFavorites$default(FavoritesListViewModel favoritesListViewModel, boolean z, boolean z2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return favoritesListViewModel.getFavorites(z, z2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FavTabState getFavorites$lambda$0(boolean $firstLoad, boolean $refresh, FavTabState $this$updateState) {
        FavTabState copy;
        Intrinsics.checkNotNullParameter($this$updateState, "$this$updateState");
        copy = $this$updateState.copy((r18 & 1) != 0 ? $this$updateState.pageState : $firstLoad ? FavPageState.Loading.INSTANCE : $this$updateState.getPageState(), (r18 & 2) != 0 ? $this$updateState.footerState : null, (r18 & 4) != 0 ? $this$updateState.itemList : null, (r18 & 8) != 0 ? $this$updateState.isRefreshing : $refresh, (r18 & 16) != 0 ? $this$updateState.isCheckMode : false, (r18 & 32) != 0 ? $this$updateState.pageNum : 0, (r18 & 64) != 0 ? $this$updateState.hasMore : false, (r18 & BR.cover) != 0 ? $this$updateState.hasInvalid : false);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // tv.danmaku.bili.ui.favorites.viewmodel.BaseFavoritesViewModel
    public FavTabState<FavoritesMediasItem> initUiState() {
        return new FavTabState<>(null, null, null, false, false, 0, false, false, BR.hallCover, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.favorites.viewmodel.BaseFavoritesViewModel
    public void onAction(FavoritesAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new FavoritesListViewModel$onAction$1(action, this, null), 3, (Object) null);
    }

    @Override // tv.danmaku.bili.ui.favorites.viewmodel.BaseFavoritesViewModel
    public Object onDeleteSuccess(boolean success, Continuation<? super Unit> continuation) {
        Object sendEffect = sendEffect(new FavoritesEvent.ShowDeletedToast(success), continuation);
        return sendEffect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendEffect : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(11:5|6|7|8|15|16|(1:18)|19|(1:21)(1:24)|22|23))|33|6|7|8|15|16|(0)|19|(0)(0)|22|23) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004f, code lost:
        r7 = kotlin.Result.Companion;
        r6 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r6));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object clearInvalidItem(String resources, Long fid, Continuation<? super Boolean> continuation) {
        FavoritesListViewModel$clearInvalidItem$1 favoritesListViewModel$clearInvalidItem$1;
        Object obj;
        Object deleteFavorites;
        if (continuation instanceof FavoritesListViewModel$clearInvalidItem$1) {
            favoritesListViewModel$clearInvalidItem$1 = (FavoritesListViewModel$clearInvalidItem$1) continuation;
            if ((favoritesListViewModel$clearInvalidItem$1.label & Integer.MIN_VALUE) != 0) {
                favoritesListViewModel$clearInvalidItem$1.label -= Integer.MIN_VALUE;
                Object $result = favoritesListViewModel$clearInvalidItem$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (favoritesListViewModel$clearInvalidItem$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Result.Companion companion = Result.Companion;
                        FavoritesListViewModel favoritesListViewModel = this;
                        favoritesListViewModel$clearInvalidItem$1.label = 1;
                        deleteFavorites = FavoritesApiManagerKt.deleteFavorites(resources, fid, favoritesListViewModel$clearInvalidItem$1);
                        if (deleteFavorites != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        ResultKt.throwOnFailure($result);
                        deleteFavorites = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl((GeneralResponse) deleteFavorites);
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                GeneralResponse generalResponse = (GeneralResponse) obj;
                return Boxing.boxBoolean(generalResponse == null ? generalResponse.isSuccess() : false);
            }
        }
        favoritesListViewModel$clearInvalidItem$1 = new FavoritesListViewModel$clearInvalidItem$1(this, continuation);
        Object $result2 = favoritesListViewModel$clearInvalidItem$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (favoritesListViewModel$clearInvalidItem$1.label) {
        }
        obj = Result.constructor-impl((GeneralResponse) deleteFavorites);
        if (Result.isFailure-impl(obj)) {
        }
        GeneralResponse generalResponse2 = (GeneralResponse) obj;
        return Boxing.boxBoolean(generalResponse2 == null ? generalResponse2.isSuccess() : false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object clearInvalidItem$default(FavoritesListViewModel favoritesListViewModel, String str, Long l, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        return favoritesListViewModel.clearInvalidItem(str, l, continuation);
    }

    /* compiled from: FavoritesListViewModel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesListViewModel$Companion;", "", "<init>", "()V", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: FavoritesListViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesListViewModel$RequestParams;", "", "nextOid", "", "nextOType", "", "nextScore", "tabId", "hasMore", "", "<init>", "(JIIIZ)V", "getNextOid", "()J", "getNextOType", "()I", "getNextScore", "getTabId", "getHasMore", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class RequestParams {
        public static final int $stable = 0;
        private final boolean hasMore;
        private final int nextOType;
        private final long nextOid;
        private final int nextScore;
        private final int tabId;

        public RequestParams() {
            this(0L, 0, 0, 0, false, 31, null);
        }

        public static /* synthetic */ RequestParams copy$default(RequestParams requestParams, long j, int i, int i2, int i3, boolean z, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                j = requestParams.nextOid;
            }
            long j2 = j;
            if ((i4 & 2) != 0) {
                i = requestParams.nextOType;
            }
            int i5 = i;
            if ((i4 & 4) != 0) {
                i2 = requestParams.nextScore;
            }
            int i6 = i2;
            if ((i4 & 8) != 0) {
                i3 = requestParams.tabId;
            }
            int i7 = i3;
            if ((i4 & 16) != 0) {
                z = requestParams.hasMore;
            }
            return requestParams.copy(j2, i5, i6, i7, z);
        }

        public final long component1() {
            return this.nextOid;
        }

        public final int component2() {
            return this.nextOType;
        }

        public final int component3() {
            return this.nextScore;
        }

        public final int component4() {
            return this.tabId;
        }

        public final boolean component5() {
            return this.hasMore;
        }

        public final RequestParams copy(long j, int i, int i2, int i3, boolean z) {
            return new RequestParams(j, i, i2, i3, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RequestParams) {
                RequestParams requestParams = (RequestParams) obj;
                return this.nextOid == requestParams.nextOid && this.nextOType == requestParams.nextOType && this.nextScore == requestParams.nextScore && this.tabId == requestParams.tabId && this.hasMore == requestParams.hasMore;
            }
            return false;
        }

        public int hashCode() {
            return (((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.nextOid) * 31) + this.nextOType) * 31) + this.nextScore) * 31) + this.tabId) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasMore);
        }

        public String toString() {
            long j = this.nextOid;
            int i = this.nextOType;
            int i2 = this.nextScore;
            int i3 = this.tabId;
            return "RequestParams(nextOid=" + j + ", nextOType=" + i + ", nextScore=" + i2 + ", tabId=" + i3 + ", hasMore=" + this.hasMore + ")";
        }

        public RequestParams(long nextOid, int nextOType, int nextScore, int tabId, boolean hasMore) {
            this.nextOid = nextOid;
            this.nextOType = nextOType;
            this.nextScore = nextScore;
            this.tabId = tabId;
            this.hasMore = hasMore;
        }

        public /* synthetic */ RequestParams(long j, int i, int i2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 0L : j, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3, (i4 & 16) != 0 ? true : z);
        }

        public final long getNextOid() {
            return this.nextOid;
        }

        public final int getNextOType() {
            return this.nextOType;
        }

        public final int getNextScore() {
            return this.nextScore;
        }

        public final int getTabId() {
            return this.tabId;
        }

        public final boolean getHasMore() {
            return this.hasMore;
        }
    }
}