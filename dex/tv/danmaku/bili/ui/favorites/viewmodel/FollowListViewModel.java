package tv.danmaku.bili.ui.favorites.viewmodel;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import androidx.lifecycle.ViewModelKt;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.lib.arch.lifecycle.Resource;
import com.bilibili.lib.arch.lifecycle.Status;
import java.util.List;
import kotlin.Metadata;
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
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotlist.model.HotListDataPacker;
import tv.danmaku.bili.ui.favorites.api.FavoritesApiManagerKt;
import tv.danmaku.bili.ui.favorites.model.FollowItem;
import tv.danmaku.bili.ui.favorites.model.FollowResponse;
import tv.danmaku.bili.ui.favorites.state.FavPageState;
import tv.danmaku.bili.ui.favorites.state.FavTabState;
import tv.danmaku.bili.ui.favorites.state.FollowAction;
import tv.danmaku.bili.ui.favorites.state.FollowEvent;

/* compiled from: FollowListViewModel.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0001:\u0001+B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\"J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0014J\u000e\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u0007J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u0002H\u0014J\u0016\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010*R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00190\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016¨\u0006,"}, d2 = {"Ltv/danmaku/bili/ui/favorites/viewmodel/FollowListViewModel;", "Ltv/danmaku/bili/ui/favorites/viewmodel/BaseFavoritesViewModel;", "Ltv/danmaku/bili/ui/favorites/state/FollowAction;", "Ltv/danmaku/bili/ui/favorites/state/FavTabState;", "Ltv/danmaku/bili/ui/favorites/model/FollowItem;", "Ltv/danmaku/bili/ui/favorites/state/FollowEvent;", "tabId", "", "<init>", "(I)V", "getTabId", "()I", "requestParam", "Ltv/danmaku/bili/ui/favorites/viewmodel/FollowListViewModel$RequestParams;", "isLoading", "", "hasInitPage", "getHasInitPage", "()Z", "canRefresh", "Lkotlinx/coroutines/flow/Flow;", "getCanRefresh", "()Lkotlinx/coroutines/flow/Flow;", "isRefreshing", "itemList", "", "getItemList", "pageState", "Ltv/danmaku/bili/ui/favorites/state/FavPageState;", "getPageState", "getFollowList", "", "firstLoad", HotListDataPacker.METHOD_REFRESH, "(ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initUiState", "reportCardShow", "position", "onAction", "action", "onDeleteSuccess", "success", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "RequestParams", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FollowListViewModel extends BaseFavoritesViewModel<FollowAction, FavTabState<FollowItem>, FollowEvent> {
    public static final int $stable = 8;
    private final Flow<Boolean> canRefresh;
    private boolean isLoading;
    private final Flow<Boolean> isRefreshing;
    private final Flow<List<FollowItem>> itemList;
    private final Flow<FavPageState> pageState;
    private RequestParams requestParam;
    private final int tabId;

    public FollowListViewModel(int tabId) {
        this.tabId = tabId;
        this.requestParam = new RequestParams(this.tabId, 0L, 0, 0, false, 30, null);
        final Flow $this$map$iv = getUiStateFlow();
        this.canRefresh = FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$special$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$special$$inlined$map$1$2", f = "FollowListViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$special$$inlined$map$1$2$1  reason: invalid class name */
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
                                    Boolean boxBoolean = Boxing.boxBoolean(!it.getItemList().isEmpty());
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
                Object collect = $this$map$iv.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        });
        final Flow $this$map$iv2 = getUiStateFlow();
        this.isRefreshing = FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$special$$inlined$map$2

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$special$$inlined$map$2$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$special$$inlined$map$2$2", f = "FollowListViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$special$$inlined$map$2$2$1  reason: invalid class name */
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
                Object collect = $this$map$iv2.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        });
        final Flow $this$map$iv3 = getUiStateFlow();
        this.itemList = FlowKt.distinctUntilChanged(new Flow<List<? extends FollowItem>>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$special$$inlined$map$3

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$special$$inlined$map$3$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$special$$inlined$map$3$2", f = "FollowListViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$special$$inlined$map$3$2$1  reason: invalid class name */
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
                Object collect = $this$map$iv3.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        });
        final Flow $this$map$iv4 = getUiStateFlow();
        this.pageState = FlowKt.distinctUntilChanged(new Flow<FavPageState>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$special$$inlined$map$4

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$special$$inlined$map$4$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$special$$inlined$map$4$2", f = "FollowListViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$special$$inlined$map$4$2$1  reason: invalid class name */
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
                Object collect = $this$map$iv4.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        });
    }

    public final int getTabId() {
        return this.tabId;
    }

    public final boolean getHasInitPage() {
        return !((FavTabState) getUiStateFlow().getValue()).getItemList().isEmpty();
    }

    public final Flow<Boolean> getCanRefresh() {
        return this.canRefresh;
    }

    public final Flow<Boolean> isRefreshing() {
        return this.isRefreshing;
    }

    public final Flow<List<FollowItem>> getItemList() {
        return this.itemList;
    }

    public final Flow<FavPageState> getPageState() {
        return this.pageState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00fb, code lost:
        if ((r14 == null || r14.isEmpty()) != false) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x018b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getFollowList(boolean firstLoad, boolean refresh, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> followListViewModel$getFollowList$1;
        FollowListViewModel followListViewModel;
        Object followList;
        boolean refresh2;
        boolean firstLoad2;
        Resource $this$suspendThen$iv;
        boolean z;
        boolean z2;
        FollowListViewModel followListViewModel2;
        Resource $this$catch$iv;
        if (continuation instanceof FollowListViewModel$getFollowList$1) {
            followListViewModel$getFollowList$1 = (FollowListViewModel$getFollowList$1) continuation;
            if ((followListViewModel$getFollowList$1.label & Integer.MIN_VALUE) != 0) {
                followListViewModel$getFollowList$1.label -= Integer.MIN_VALUE;
                Object $result = followListViewModel$getFollowList$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (followListViewModel$getFollowList$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        followListViewModel = this;
                        if (followListViewModel.isLoading) {
                            return Unit.INSTANCE;
                        }
                        if (firstLoad || followListViewModel.requestParam.getHasMore() || refresh) {
                            followListViewModel.isLoading = true;
                            if (firstLoad || refresh) {
                                followListViewModel.requestParam = new RequestParams(followListViewModel.tabId, 0L, 0, 0, false, 30, null);
                            }
                            final boolean z3 = firstLoad;
                            final boolean z4 = refresh;
                            followListViewModel.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    FavTabState followList$lambda$0;
                                    followList$lambda$0 = FollowListViewModel.getFollowList$lambda$0(z3, z4, (FavTabState) obj);
                                    return followList$lambda$0;
                                }
                            });
                            int tabId = followListViewModel.requestParam.getTabId();
                            long startOid = followListViewModel.requestParam.getStartOid();
                            int startOType = followListViewModel.requestParam.getStartOType();
                            int startScore = followListViewModel.requestParam.getStartScore();
                            followListViewModel$getFollowList$1.Z$0 = firstLoad;
                            followListViewModel$getFollowList$1.Z$1 = refresh;
                            followListViewModel$getFollowList$1.label = 1;
                            followList = FavoritesApiManagerKt.getFollowList(tabId, startOid, startOType, startScore, followListViewModel$getFollowList$1);
                            if (followList != coroutine_suspended) {
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
                        refresh2 = followListViewModel$getFollowList$1.Z$1;
                        boolean firstLoad3 = followListViewModel$getFollowList$1.Z$0;
                        ResultKt.throwOnFailure($result);
                        followListViewModel = this;
                        firstLoad2 = firstLoad3;
                        followList = $result;
                        break;
                    case 2:
                        followListViewModel2 = this;
                        z = false;
                        z2 = false;
                        firstLoad2 = followListViewModel$getFollowList$1.Z$0;
                        FollowResponse followResponse = (FollowResponse) followListViewModel$getFollowList$1.L$1;
                        $this$suspendThen$iv = (Resource) followListViewModel$getFollowList$1.L$0;
                        ResultKt.throwOnFailure($result);
                        followListViewModel = followListViewModel2;
                        $this$catch$iv = $this$suspendThen$iv;
                        if ($this$catch$iv.getStatus() == Status.ERROR && $this$catch$iv.getError() != null) {
                            Intrinsics.checkNotNull($this$catch$iv.getError());
                            followListViewModel.isLoading = false;
                            final boolean z5 = !firstLoad2;
                            followListViewModel.updateState(new Function1<FavTabState<FollowItem>, FavTabState<FollowItem>>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$getFollowList$4$1
                                public final FavTabState<FollowItem> invoke(FavTabState<FollowItem> favTabState) {
                                    FavPageState pageState;
                                    FavTabState<FollowItem> copy;
                                    Intrinsics.checkNotNullParameter(favTabState, "$this$updateState");
                                    if (z5) {
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
                $this$suspendThen$iv = (Resource) followList;
                if ($this$suspendThen$iv.getStatus() == Status.SUCCESS) {
                    final FollowResponse res = (FollowResponse) $this$suspendThen$iv.getData();
                    followListViewModel.isLoading = false;
                    if (res != null) {
                        List<FollowItem> list = res.getList();
                    }
                    final boolean z6 = firstLoad2;
                    final boolean z7 = refresh2;
                    followListViewModel.updateState(new Function1<FavTabState<FollowItem>, FavTabState<FollowItem>>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$getFollowList$3$1
                        public final FavTabState<FollowItem> invoke(FavTabState<FollowItem> favTabState) {
                            FavTabState<FollowItem> copy;
                            Intrinsics.checkNotNullParameter(favTabState, "$this$updateState");
                            copy = favTabState.copy((r18 & 1) != 0 ? favTabState.pageState : (z6 || z7) ? FavPageState.Empty.INSTANCE : favTabState.getPageState(), (r18 & 2) != 0 ? favTabState.footerState : null, (r18 & 4) != 0 ? favTabState.itemList : (z6 || z7) ? CollectionsKt.emptyList() : favTabState.getItemList(), (r18 & 8) != 0 ? favTabState.isRefreshing : false, (r18 & 16) != 0 ? favTabState.isCheckMode : false, (r18 & 32) != 0 ? favTabState.pageNum : 0, (r18 & 64) != 0 ? favTabState.hasMore : false, (r18 & BR.cover) != 0 ? favTabState.hasInvalid : false);
                            return copy;
                        }
                    });
                    if (res != null) {
                        final boolean z8 = firstLoad2;
                        final boolean z9 = refresh2;
                        followListViewModel.updateState(new Function1<FavTabState<FollowItem>, FavTabState<FollowItem>>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$getFollowList$3$2$1
                            public final FavTabState<FollowItem> invoke(FavTabState<FollowItem> favTabState) {
                                FavTabState<FollowItem> copy;
                                Intrinsics.checkNotNullParameter(favTabState, "$this$updateState");
                                FavPageState.Success success = FavPageState.Success.INSTANCE;
                                List $this$invoke_u24lambda_u240 = CollectionsKt.toMutableList(favTabState.getItemList());
                                boolean z10 = z8;
                                boolean z11 = z9;
                                FollowResponse followResponse2 = res;
                                if (z10 || z11) {
                                    $this$invoke_u24lambda_u240.clear();
                                }
                                if (followResponse2.getList() != null) {
                                    $this$invoke_u24lambda_u240.addAll(followResponse2.getList());
                                }
                                Unit unit = Unit.INSTANCE;
                                copy = favTabState.copy((r18 & 1) != 0 ? favTabState.pageState : success, (r18 & 2) != 0 ? favTabState.footerState : null, (r18 & 4) != 0 ? favTabState.itemList : $this$invoke_u24lambda_u240, (r18 & 8) != 0 ? favTabState.isRefreshing : false, (r18 & 16) != 0 ? favTabState.isCheckMode : false, (r18 & 32) != 0 ? favTabState.pageNum : 0, (r18 & 64) != 0 ? favTabState.hasMore : false, (r18 & BR.cover) != 0 ? favTabState.hasInvalid : false);
                                return copy;
                            }
                        });
                        followListViewModel.requestParam = RequestParams.copy$default(followListViewModel.requestParam, 0, res.getNextOid(), res.getNextOType(), res.getNextScore(), res.getHasMore(), 1, null);
                        if (refresh2) {
                            followListViewModel$getFollowList$1.L$0 = $this$suspendThen$iv;
                            followListViewModel$getFollowList$1.L$1 = res;
                            followListViewModel$getFollowList$1.Z$0 = firstLoad2;
                            followListViewModel$getFollowList$1.label = 2;
                            if (followListViewModel.sendEffect(FollowEvent.ScrollToTop.INSTANCE, followListViewModel$getFollowList$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            z = false;
                            z2 = false;
                            followListViewModel2 = followListViewModel;
                            followListViewModel = followListViewModel2;
                        }
                    }
                }
                $this$catch$iv = $this$suspendThen$iv;
                if ($this$catch$iv.getStatus() == Status.ERROR) {
                    Intrinsics.checkNotNull($this$catch$iv.getError());
                    followListViewModel.isLoading = false;
                    if (!firstLoad2) {
                    }
                    followListViewModel.updateState(new Function1<FavTabState<FollowItem>, FavTabState<FollowItem>>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel$getFollowList$4$1
                        public final FavTabState<FollowItem> invoke(FavTabState<FollowItem> favTabState) {
                            FavPageState pageState;
                            FavTabState<FollowItem> copy;
                            Intrinsics.checkNotNullParameter(favTabState, "$this$updateState");
                            if (z5) {
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
        followListViewModel$getFollowList$1 = new FollowListViewModel$getFollowList$1(this, continuation);
        Object $result2 = followListViewModel$getFollowList$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (followListViewModel$getFollowList$1.label) {
        }
        $this$suspendThen$iv = (Resource) followList;
        if ($this$suspendThen$iv.getStatus() == Status.SUCCESS) {
        }
        $this$catch$iv = $this$suspendThen$iv;
        if ($this$catch$iv.getStatus() == Status.ERROR) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FavTabState getFollowList$lambda$0(boolean $firstLoad, boolean $refresh, FavTabState $this$updateState) {
        FavTabState copy;
        Intrinsics.checkNotNullParameter($this$updateState, "$this$updateState");
        copy = $this$updateState.copy((r18 & 1) != 0 ? $this$updateState.pageState : $firstLoad ? FavPageState.Loading.INSTANCE : $this$updateState.getPageState(), (r18 & 2) != 0 ? $this$updateState.footerState : null, (r18 & 4) != 0 ? $this$updateState.itemList : null, (r18 & 8) != 0 ? $this$updateState.isRefreshing : $refresh, (r18 & 16) != 0 ? $this$updateState.isCheckMode : false, (r18 & 32) != 0 ? $this$updateState.pageNum : 0, (r18 & 64) != 0 ? $this$updateState.hasMore : false, (r18 & BR.cover) != 0 ? $this$updateState.hasInvalid : false);
        return copy;
    }

    /* compiled from: FollowListViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/viewmodel/FollowListViewModel$RequestParams;", "", "tabId", "", "startOid", "", "startOType", "startScore", "hasMore", "", "<init>", "(IJIIZ)V", "getTabId", "()I", "getStartOid", "()J", "getStartOType", "getStartScore", "getHasMore", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class RequestParams {
        public static final int $stable = 0;
        private final boolean hasMore;
        private final int startOType;
        private final long startOid;
        private final int startScore;
        private final int tabId;

        public RequestParams() {
            this(0, 0L, 0, 0, false, 31, null);
        }

        public static /* synthetic */ RequestParams copy$default(RequestParams requestParams, int i, long j, int i2, int i3, boolean z, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = requestParams.tabId;
            }
            if ((i4 & 2) != 0) {
                j = requestParams.startOid;
            }
            long j2 = j;
            if ((i4 & 4) != 0) {
                i2 = requestParams.startOType;
            }
            int i5 = i2;
            if ((i4 & 8) != 0) {
                i3 = requestParams.startScore;
            }
            int i6 = i3;
            if ((i4 & 16) != 0) {
                z = requestParams.hasMore;
            }
            return requestParams.copy(i, j2, i5, i6, z);
        }

        public final int component1() {
            return this.tabId;
        }

        public final long component2() {
            return this.startOid;
        }

        public final int component3() {
            return this.startOType;
        }

        public final int component4() {
            return this.startScore;
        }

        public final boolean component5() {
            return this.hasMore;
        }

        public final RequestParams copy(int i, long j, int i2, int i3, boolean z) {
            return new RequestParams(i, j, i2, i3, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RequestParams) {
                RequestParams requestParams = (RequestParams) obj;
                return this.tabId == requestParams.tabId && this.startOid == requestParams.startOid && this.startOType == requestParams.startOType && this.startScore == requestParams.startScore && this.hasMore == requestParams.hasMore;
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.tabId * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.startOid)) * 31) + this.startOType) * 31) + this.startScore) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasMore);
        }

        public String toString() {
            int i = this.tabId;
            long j = this.startOid;
            int i2 = this.startOType;
            int i3 = this.startScore;
            return "RequestParams(tabId=" + i + ", startOid=" + j + ", startOType=" + i2 + ", startScore=" + i3 + ", hasMore=" + this.hasMore + ")";
        }

        public RequestParams(int tabId, long startOid, int startOType, int startScore, boolean hasMore) {
            this.tabId = tabId;
            this.startOid = startOid;
            this.startOType = startOType;
            this.startScore = startScore;
            this.hasMore = hasMore;
        }

        public /* synthetic */ RequestParams(int i, long j, int i2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0L : j, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) == 0 ? i3 : 0, (i4 & 16) != 0 ? true : z);
        }

        public final int getTabId() {
            return this.tabId;
        }

        public final long getStartOid() {
            return this.startOid;
        }

        public final int getStartOType() {
            return this.startOType;
        }

        public final int getStartScore() {
            return this.startScore;
        }

        public final boolean getHasMore() {
            return this.hasMore;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // tv.danmaku.bili.ui.favorites.viewmodel.BaseFavoritesViewModel
    public FavTabState<FollowItem> initUiState() {
        return new FavTabState<>(null, null, null, false, false, 0, false, false, BR.hallCover, null);
    }

    public final void reportCardShow(int position) {
        if (((FollowItem) CollectionsKt.getOrNull(((FavTabState) getUiStateFlow().getValue()).getItemList(), position)) == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.favorites.viewmodel.BaseFavoritesViewModel
    public void onAction(FollowAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new FollowListViewModel$onAction$1(action, this, null), 3, (Object) null);
    }

    @Override // tv.danmaku.bili.ui.favorites.viewmodel.BaseFavoritesViewModel
    public Object onDeleteSuccess(boolean success, Continuation<? super Unit> continuation) {
        Object sendEffect = sendEffect(new FollowEvent.ShowDeletedToast(success), continuation);
        return sendEffect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendEffect : Unit.INSTANCE;
    }
}