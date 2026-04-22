package tv.danmaku.bili.ui.favorites.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.lib.arch.lifecycle.Resource;
import com.bilibili.lib.arch.lifecycle.Status;
import com.bilibili.okretro.BaseResponse;
import com.bilibili.okretro.GeneralResponse;
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
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotlist.model.HotListDataPacker;
import tv.danmaku.bili.ui.favorites.api.FavoritesApiManagerKt;
import tv.danmaku.bili.ui.favorites.model.FavoritesFolder;
import tv.danmaku.bili.ui.favorites.model.FavoritesFolderItem;
import tv.danmaku.bili.ui.favorites.state.FavPageState;
import tv.danmaku.bili.ui.favorites.state.FavTabState;
import tv.danmaku.bili.ui.favorites.state.FolderAction;
import tv.danmaku.bili.ui.favorites.state.FolderEvent;

/* compiled from: FolderListViewModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u0002H\u0014J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0014J\b\u0010&\u001a\u00020\u001dH\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00170\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014¨\u0006'"}, d2 = {"Ltv/danmaku/bili/ui/favorites/viewmodel/FolderListViewModel;", "Ltv/danmaku/bili/ui/favorites/viewmodel/BaseFavoritesViewModel;", "Ltv/danmaku/bili/ui/favorites/state/FolderAction;", "Ltv/danmaku/bili/ui/favorites/state/FavTabState;", "Ltv/danmaku/bili/ui/favorites/model/FavoritesFolderItem;", "Ltv/danmaku/bili/ui/favorites/state/FolderEvent;", "tabId", "", "<init>", "(I)V", "getTabId", "()I", "hasInitPage", "", "getHasInitPage", "()Z", "isLoading", "canRefresh", "Lkotlinx/coroutines/flow/Flow;", "getCanRefresh", "()Lkotlinx/coroutines/flow/Flow;", "isRefreshing", "itemList", "", "getItemList", "pageState", "Ltv/danmaku/bili/ui/favorites/state/FavPageState;", "getPageState", "getFolderList", "", HotListDataPacker.METHOD_REFRESH, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTop", "data", "(Ltv/danmaku/bili/ui/favorites/model/FavoritesFolderItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAction", "action", "initUiState", "updateFolderLayoutType", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FolderListViewModel extends BaseFavoritesViewModel<FolderAction, FavTabState<FavoritesFolderItem>, FolderEvent> {
    public static final int $stable = 8;
    private final Flow<Boolean> canRefresh;
    private boolean isLoading;
    private final Flow<Boolean> isRefreshing;
    private final Flow<List<FavoritesFolderItem>> itemList;
    private final Flow<FavPageState> pageState;
    private final int tabId;

    public FolderListViewModel(int tabId) {
        this.tabId = tabId;
        final Flow $this$map$iv = getUiStateFlow();
        this.canRefresh = FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$special$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$special$$inlined$map$1$2", f = "FolderListViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$special$$inlined$map$1$2$1  reason: invalid class name */
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
        this.isRefreshing = FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$special$$inlined$map$2

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$special$$inlined$map$2$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$special$$inlined$map$2$2", f = "FolderListViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$special$$inlined$map$2$2$1  reason: invalid class name */
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
        this.itemList = FlowKt.distinctUntilChanged(new Flow<List<? extends FavoritesFolderItem>>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$special$$inlined$map$3

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$special$$inlined$map$3$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$special$$inlined$map$3$2", f = "FolderListViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$special$$inlined$map$3$2$1  reason: invalid class name */
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
        this.pageState = FlowKt.distinctUntilChanged(new Flow<FavPageState>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$special$$inlined$map$4

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$special$$inlined$map$4$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$special$$inlined$map$4$2", f = "FolderListViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$special$$inlined$map$4$2$1  reason: invalid class name */
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

    public final Flow<List<FavoritesFolderItem>> getItemList() {
        return this.itemList;
    }

    public final Flow<FavPageState> getPageState() {
        return this.pageState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009a, code lost:
        if ((r10 == null || r10.isEmpty()) != false) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getFolderList(boolean refresh, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> folderListViewModel$getFolderList$1;
        Object folderList;
        boolean refresh2;
        FolderListViewModel folderListViewModel;
        Resource $this$suspendThen$iv;
        final List it;
        boolean z;
        boolean z2;
        Resource $this$catch$iv;
        if (continuation instanceof FolderListViewModel$getFolderList$1) {
            folderListViewModel$getFolderList$1 = (FolderListViewModel$getFolderList$1) continuation;
            if ((folderListViewModel$getFolderList$1.label & Integer.MIN_VALUE) != 0) {
                folderListViewModel$getFolderList$1.label -= Integer.MIN_VALUE;
                Object $result = folderListViewModel$getFolderList$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (folderListViewModel$getFolderList$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!this.isLoading) {
                            this.isLoading = true;
                            final boolean z3 = refresh;
                            updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    FavTabState folderList$lambda$0;
                                    folderList$lambda$0 = FolderListViewModel.getFolderList$lambda$0(z3, (FavTabState) obj);
                                    return folderList$lambda$0;
                                }
                            });
                            folderListViewModel$getFolderList$1.Z$0 = refresh;
                            folderListViewModel$getFolderList$1.label = 1;
                            folderList = FavoritesApiManagerKt.getFolderList(folderListViewModel$getFolderList$1);
                            if (folderList != coroutine_suspended) {
                                refresh2 = refresh;
                                folderListViewModel = this;
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        } else {
                            return Unit.INSTANCE;
                        }
                    case 1:
                        folderListViewModel = this;
                        boolean refresh3 = folderListViewModel$getFolderList$1.Z$0;
                        ResultKt.throwOnFailure($result);
                        folderList = $result;
                        refresh2 = refresh3;
                        break;
                    case 2:
                        folderListViewModel = this;
                        z = false;
                        z2 = false;
                        refresh2 = folderListViewModel$getFolderList$1.Z$0;
                        $this$suspendThen$iv = (Resource) folderListViewModel$getFolderList$1.L$0;
                        ResultKt.throwOnFailure($result);
                        $this$catch$iv = $this$suspendThen$iv;
                        if ($this$catch$iv.getStatus() == Status.ERROR && $this$catch$iv.getError() != null) {
                            Intrinsics.checkNotNull($this$catch$iv.getError());
                            folderListViewModel.isLoading = false;
                            final boolean z4 = refresh2;
                            folderListViewModel.updateState(new Function1<FavTabState<FavoritesFolderItem>, FavTabState<FavoritesFolderItem>>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$getFolderList$4$1
                                public final FavTabState<FavoritesFolderItem> invoke(FavTabState<FavoritesFolderItem> favTabState) {
                                    FavPageState favPageState;
                                    FavTabState<FavoritesFolderItem> copy;
                                    Intrinsics.checkNotNullParameter(favTabState, "$this$updateState");
                                    if (z4) {
                                        favPageState = favTabState.getPageState();
                                    } else {
                                        favPageState = ConnectivityMonitor.getInstance().isNetworkActive() ? FavPageState.OtherError.INSTANCE : FavPageState.NetworkError.INSTANCE;
                                    }
                                    copy = favTabState.copy((r18 & 1) != 0 ? favTabState.pageState : favPageState, (r18 & 2) != 0 ? favTabState.footerState : null, (r18 & 4) != 0 ? favTabState.itemList : null, (r18 & 8) != 0 ? favTabState.isRefreshing : false, (r18 & 16) != 0 ? favTabState.isCheckMode : false, (r18 & 32) != 0 ? favTabState.pageNum : 0, (r18 & 64) != 0 ? favTabState.hasMore : false, (r18 & BR.cover) != 0 ? favTabState.hasInvalid : false);
                                    return copy;
                                }
                            });
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                $this$suspendThen$iv = (Resource) folderList;
                if ($this$suspendThen$iv.getStatus() == Status.SUCCESS) {
                    FavoritesFolder res = (FavoritesFolder) $this$suspendThen$iv.getData();
                    folderListViewModel.isLoading = false;
                    if (res != null) {
                        List<FavoritesFolderItem> list = res.getList();
                    }
                    final boolean z5 = refresh2;
                    folderListViewModel.updateState(new Function1<FavTabState<FavoritesFolderItem>, FavTabState<FavoritesFolderItem>>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$getFolderList$3$1
                        public final FavTabState<FavoritesFolderItem> invoke(FavTabState<FavoritesFolderItem> favTabState) {
                            FavTabState<FavoritesFolderItem> copy;
                            Intrinsics.checkNotNullParameter(favTabState, "$this$updateState");
                            copy = favTabState.copy((r18 & 1) != 0 ? favTabState.pageState : z5 ? favTabState.getPageState() : FavPageState.Empty.INSTANCE, (r18 & 2) != 0 ? favTabState.footerState : null, (r18 & 4) != 0 ? favTabState.itemList : null, (r18 & 8) != 0 ? favTabState.isRefreshing : false, (r18 & 16) != 0 ? favTabState.isCheckMode : false, (r18 & 32) != 0 ? favTabState.pageNum : 0, (r18 & 64) != 0 ? favTabState.hasMore : false, (r18 & BR.cover) != 0 ? favTabState.hasInvalid : false);
                            return copy;
                        }
                    });
                    if (res != null && (it = res.getList()) != null) {
                        folderListViewModel.updateState(new Function1<FavTabState<FavoritesFolderItem>, FavTabState<FavoritesFolderItem>>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$getFolderList$3$2$1
                            public final FavTabState<FavoritesFolderItem> invoke(FavTabState<FavoritesFolderItem> favTabState) {
                                FavTabState<FavoritesFolderItem> copy;
                                Intrinsics.checkNotNullParameter(favTabState, "$this$updateState");
                                copy = favTabState.copy((r18 & 1) != 0 ? favTabState.pageState : FavPageState.Success.INSTANCE, (r18 & 2) != 0 ? favTabState.footerState : null, (r18 & 4) != 0 ? favTabState.itemList : it, (r18 & 8) != 0 ? favTabState.isRefreshing : false, (r18 & 16) != 0 ? favTabState.isCheckMode : false, (r18 & 32) != 0 ? favTabState.pageNum : 0, (r18 & 64) != 0 ? favTabState.hasMore : false, (r18 & BR.cover) != 0 ? favTabState.hasInvalid : false);
                                return copy;
                            }
                        });
                        if (refresh2) {
                            folderListViewModel$getFolderList$1.L$0 = $this$suspendThen$iv;
                            folderListViewModel$getFolderList$1.Z$0 = refresh2;
                            folderListViewModel$getFolderList$1.label = 2;
                            if (folderListViewModel.sendEffect(FolderEvent.ScrollToTop.INSTANCE, folderListViewModel$getFolderList$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            z = false;
                            z2 = false;
                        }
                    }
                }
                $this$catch$iv = $this$suspendThen$iv;
                if ($this$catch$iv.getStatus() == Status.ERROR) {
                    Intrinsics.checkNotNull($this$catch$iv.getError());
                    folderListViewModel.isLoading = false;
                    if (refresh2) {
                    }
                    folderListViewModel.updateState(new Function1<FavTabState<FavoritesFolderItem>, FavTabState<FavoritesFolderItem>>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$getFolderList$4$1
                        public final FavTabState<FavoritesFolderItem> invoke(FavTabState<FavoritesFolderItem> favTabState) {
                            FavPageState favPageState;
                            FavTabState<FavoritesFolderItem> copy;
                            Intrinsics.checkNotNullParameter(favTabState, "$this$updateState");
                            if (z4) {
                                favPageState = favTabState.getPageState();
                            } else {
                                favPageState = ConnectivityMonitor.getInstance().isNetworkActive() ? FavPageState.OtherError.INSTANCE : FavPageState.NetworkError.INSTANCE;
                            }
                            copy = favTabState.copy((r18 & 1) != 0 ? favTabState.pageState : favPageState, (r18 & 2) != 0 ? favTabState.footerState : null, (r18 & 4) != 0 ? favTabState.itemList : null, (r18 & 8) != 0 ? favTabState.isRefreshing : false, (r18 & 16) != 0 ? favTabState.isCheckMode : false, (r18 & 32) != 0 ? favTabState.pageNum : 0, (r18 & 64) != 0 ? favTabState.hasMore : false, (r18 & BR.cover) != 0 ? favTabState.hasInvalid : false);
                            return copy;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        }
        folderListViewModel$getFolderList$1 = new FolderListViewModel$getFolderList$1(this, continuation);
        Object $result2 = folderListViewModel$getFolderList$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (folderListViewModel$getFolderList$1.label) {
        }
        $this$suspendThen$iv = (Resource) folderList;
        if ($this$suspendThen$iv.getStatus() == Status.SUCCESS) {
        }
        $this$catch$iv = $this$suspendThen$iv;
        if ($this$catch$iv.getStatus() == Status.ERROR) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FavTabState getFolderList$lambda$0(boolean $refresh, FavTabState $this$updateState) {
        FavTabState copy;
        FavTabState copy2;
        Intrinsics.checkNotNullParameter($this$updateState, "$this$updateState");
        if ($refresh) {
            copy2 = $this$updateState.copy((r18 & 1) != 0 ? $this$updateState.pageState : null, (r18 & 2) != 0 ? $this$updateState.footerState : null, (r18 & 4) != 0 ? $this$updateState.itemList : null, (r18 & 8) != 0 ? $this$updateState.isRefreshing : true, (r18 & 16) != 0 ? $this$updateState.isCheckMode : false, (r18 & 32) != 0 ? $this$updateState.pageNum : 0, (r18 & 64) != 0 ? $this$updateState.hasMore : false, (r18 & BR.cover) != 0 ? $this$updateState.hasInvalid : false);
            return copy2;
        }
        copy = $this$updateState.copy((r18 & 1) != 0 ? $this$updateState.pageState : FavPageState.Loading.INSTANCE, (r18 & 2) != 0 ? $this$updateState.footerState : null, (r18 & 4) != 0 ? $this$updateState.itemList : CollectionsKt.emptyList(), (r18 & 8) != 0 ? $this$updateState.isRefreshing : false, (r18 & 16) != 0 ? $this$updateState.isCheckMode : false, (r18 & 32) != 0 ? $this$updateState.pageNum : 0, (r18 & 64) != 0 ? $this$updateState.hasMore : false, (r18 & BR.cover) != 0 ? $this$updateState.hasInvalid : false);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object setTop(FavoritesFolderItem data, Continuation<? super Unit> continuation) {
        Object collect = FlowKt.catch(FlowKt.flow(new FolderListViewModel$setTop$2(data, null)), new FolderListViewModel$setTop$3(this, null)).collect(new FlowCollector() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$setTop$4
            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                return emit((GeneralResponse) value, (Continuation<? super Unit>) $completion);
            }

            public final Object emit(GeneralResponse<BaseResponse> generalResponse, Continuation<? super Unit> continuation2) {
                boolean z = false;
                if (generalResponse != null && generalResponse.isSuccess()) {
                    z = true;
                }
                if (z) {
                    FolderListViewModel.this.sendAction(new FolderAction.Load(true));
                    FolderListViewModel.this.sendEffect(new AnonymousClass1(null));
                } else {
                    FolderListViewModel.this.sendEffect(new AnonymousClass2(null));
                    BLog.i("FolderListViewModel", "set Top failed");
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: FolderListViewModel.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/favorites/state/FolderEvent;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$setTop$4$1", f = "FolderListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$setTop$4$1  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super FolderEvent>, Object> {
                int label;

                AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                    super(1, continuation);
                }

                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass1(continuation);
                }

                public final Object invoke(Continuation<? super FolderEvent> continuation) {
                    return create(continuation).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            return new FolderEvent.ShowAddTopToast(true);
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: FolderListViewModel.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/favorites/state/FolderEvent;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$setTop$4$2", f = "FolderListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$setTop$4$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super FolderEvent>, Object> {
                int label;

                AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                    super(1, continuation);
                }

                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass2(continuation);
                }

                public final Object invoke(Continuation<? super FolderEvent> continuation) {
                    return create(continuation).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            return new FolderEvent.ShowAddTopToast(false);
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.favorites.viewmodel.BaseFavoritesViewModel
    public void onAction(FolderAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new FolderListViewModel$onAction$1(action, this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // tv.danmaku.bili.ui.favorites.viewmodel.BaseFavoritesViewModel
    public FavTabState<FavoritesFolderItem> initUiState() {
        return new FavTabState<>(null, null, null, false, false, 0, false, false, BR.hallCover, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFolderLayoutType() {
        sendEffect(new FolderListViewModel$updateFolderLayoutType$1(null));
    }
}