package tv.danmaku.bili.ui.favorites.viewmodel;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import androidx.lifecycle.ViewModelKt;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.lib.arch.lifecycle.Resource;
import com.bilibili.lib.arch.lifecycle.Status;
import com.bilibili.playset.api.PlaySetApiKt;
import com.bilibili.playset.playlist.entity.SortRecord;
import com.bilibili.playset.playlist.helper.ReportHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
import kotlinx.coroutines.JobKt;
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
import tv.danmaku.bili.ui.favorites.state.FavPageState;
import tv.danmaku.bili.ui.favorites.state.FavTabState;
import tv.danmaku.bili.ui.favorites.state.FavoritesAction;
import tv.danmaku.bili.ui.favorites.state.FavoritesEvent;

/* compiled from: FavoritesEditListViewModel.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u0000 62\u001a\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0001:\u000267B%\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ \u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00102\b\b\u0002\u0010*\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010+J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0014J\u0010\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020\u0002H\u0014J\u0016\u0010/\u001a\u00020(2\u0006\u00100\u001a\u000201H\u0082@¢\u0006\u0002\u00102J\u0016\u00103\u001a\u00020(2\u0006\u00104\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u00105R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u0019¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0011\u0010$\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u00068"}, d2 = {"Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesEditListViewModel;", "Ltv/danmaku/bili/ui/favorites/viewmodel/BaseFavoritesViewModel;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", "Ltv/danmaku/bili/ui/favorites/state/FavTabState;", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent;", "mSortOps", "", "Lcom/bilibili/playset/playlist/entity/SortRecord;", "playlistId", "", "totalMediaCount", "", "<init>", "(Ljava/util/List;JI)V", "isLoading", "", "sortedList", "getSortedList", "()Ljava/util/List;", "setSortedList", "(Ljava/util/List;)V", "requestParam", "Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesEditListViewModel$FolderRequestParams;", "itemListFlow", "Lkotlinx/coroutines/flow/Flow;", "", "getItemListFlow", "()Lkotlinx/coroutines/flow/Flow;", "pageStateFlow", "Ltv/danmaku/bili/ui/favorites/state/FavPageState;", "getPageStateFlow", "checkAll", "getCheckAll", "buttonClickable", "getButtonClickable", "hasInitPage", "getHasInitPage", "()Z", "getFavorites", "", "firstLoad", HotListDataPacker.METHOD_REFRESH, "(ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initUiState", "onAction", "action", "sortMedias", "sortOps", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDeleteSuccess", "success", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "FolderRequestParams", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesEditListViewModel extends BaseFavoritesViewModel<FavoritesAction, FavTabState<FavoritesMediasItem>, FavoritesEvent> {
    public static final String TAG = "FavoritesEditListViewModel";
    private final Flow<Boolean> buttonClickable;
    private final Flow<Boolean> checkAll;
    private boolean isLoading;
    private final Flow<List<FavoritesMediasItem>> itemListFlow;
    private final List<SortRecord> mSortOps;
    private final Flow<FavPageState> pageStateFlow;
    private final long playlistId;
    private FolderRequestParams requestParam;
    private List<FavoritesMediasItem> sortedList;
    private final int totalMediaCount;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public FavoritesEditListViewModel(List<SortRecord> list, long playlistId, int totalMediaCount) {
        Intrinsics.checkNotNullParameter(list, "mSortOps");
        this.mSortOps = list;
        this.playlistId = playlistId;
        this.totalMediaCount = totalMediaCount;
        this.sortedList = CollectionsKt.toMutableList(((FavTabState) getUiStateFlow().getValue()).getItemList());
        this.requestParam = new FolderRequestParams(this.playlistId, false, ((FavTabState) getUiStateFlow().getValue()).getPageNum(), 2, null);
        final Flow $this$map$iv = getUiStateFlow();
        this.itemListFlow = FlowKt.distinctUntilChanged(new Flow<List<? extends FavoritesMediasItem>>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$special$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$special$$inlined$map$1$2", f = "FavoritesEditListViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$special$$inlined$map$1$2$1  reason: invalid class name */
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
        this.pageStateFlow = FlowKt.distinctUntilChanged(new Flow<FavPageState>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$special$$inlined$map$2

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$special$$inlined$map$2$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$special$$inlined$map$2$2", f = "FavoritesEditListViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$special$$inlined$map$2$2$1  reason: invalid class name */
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
        this.checkAll = FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$special$$inlined$map$3

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$special$$inlined$map$3$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$special$$inlined$map$3$2", f = "FavoritesEditListViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$special$$inlined$map$3$2$1  reason: invalid class name */
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
                Object collect = $this$map$iv3.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        });
        final Flow $this$map$iv4 = getUiStateFlow();
        this.buttonClickable = FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$special$$inlined$map$4

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$special$$inlined$map$4$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$special$$inlined$map$4$2", f = "FavoritesEditListViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$special$$inlined$map$4$2$1  reason: invalid class name */
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
                Object collect = $this$map$iv4.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        });
    }

    public final List<FavoritesMediasItem> getSortedList() {
        return this.sortedList;
    }

    public final void setSortedList(List<FavoritesMediasItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.sortedList = list;
    }

    public final Flow<List<FavoritesMediasItem>> getItemListFlow() {
        return this.itemListFlow;
    }

    public final Flow<FavPageState> getPageStateFlow() {
        return this.pageStateFlow;
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
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getFavorites(boolean firstLoad, boolean refresh, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> favoritesEditListViewModel$getFavorites$1;
        final FavoritesEditListViewModel favoritesEditListViewModel;
        Object folderFullInfo;
        boolean refresh2;
        boolean firstLoad2;
        Resource $this$suspendThen$iv;
        boolean z;
        final boolean z2;
        final FavoritesTabList res;
        boolean z3;
        FavoritesEditListViewModel favoritesEditListViewModel2;
        boolean z4;
        boolean firstLoad3;
        Resource $this$suspendThen$iv2;
        Resource $this$catch$iv;
        if (continuation instanceof FavoritesEditListViewModel$getFavorites$1) {
            favoritesEditListViewModel$getFavorites$1 = (FavoritesEditListViewModel$getFavorites$1) continuation;
            if ((favoritesEditListViewModel$getFavorites$1.label & Integer.MIN_VALUE) != 0) {
                favoritesEditListViewModel$getFavorites$1.label -= Integer.MIN_VALUE;
                Object $result = favoritesEditListViewModel$getFavorites$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (favoritesEditListViewModel$getFavorites$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        favoritesEditListViewModel = this;
                        if (favoritesEditListViewModel.isLoading) {
                            return Unit.INSTANCE;
                        }
                        if (firstLoad || favoritesEditListViewModel.requestParam.getHasMore() || refresh) {
                            favoritesEditListViewModel.isLoading = true;
                            if (refresh) {
                                favoritesEditListViewModel.requestParam = new FolderRequestParams(favoritesEditListViewModel.playlistId, false, 1, 2, null);
                            }
                            final boolean z5 = firstLoad;
                            final boolean z6 = refresh;
                            favoritesEditListViewModel.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    FavTabState favorites$lambda$0;
                                    favorites$lambda$0 = FavoritesEditListViewModel.getFavorites$lambda$0(z5, z6, (FavTabState) obj);
                                    return favorites$lambda$0;
                                }
                            });
                            long playlistId = favoritesEditListViewModel.requestParam.getPlaylistId();
                            int pageNum = favoritesEditListViewModel.requestParam.getPageNum();
                            favoritesEditListViewModel$getFavorites$1.Z$0 = firstLoad;
                            favoritesEditListViewModel$getFavorites$1.Z$1 = refresh;
                            favoritesEditListViewModel$getFavorites$1.label = 1;
                            folderFullInfo = FavoritesApiManagerKt.getFolderFullInfo(playlistId, pageNum, favoritesEditListViewModel$getFavorites$1);
                            if (folderFullInfo == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            refresh2 = refresh;
                            firstLoad2 = firstLoad;
                            $this$suspendThen$iv = (Resource) folderFullInfo;
                            z = false;
                            if ($this$suspendThen$iv.getStatus() != Status.SUCCESS) {
                                res = (FavoritesTabList) $this$suspendThen$iv.getData();
                                z3 = false;
                                favoritesEditListViewModel.isLoading = false;
                                if (res != null) {
                                    List<FavoritesMediasItem> list = res.getList();
                                    if (!(list == null || list.isEmpty())) {
                                        if (favoritesEditListViewModel.requestParam.getPageNum() == 1) {
                                            favoritesEditListViewModel$getFavorites$1.L$0 = $this$suspendThen$iv;
                                            favoritesEditListViewModel$getFavorites$1.L$1 = res;
                                            favoritesEditListViewModel$getFavorites$1.Z$0 = firstLoad2;
                                            favoritesEditListViewModel$getFavorites$1.Z$1 = refresh2;
                                            favoritesEditListViewModel$getFavorites$1.label = 2;
                                            if (favoritesEditListViewModel.sendEffect(FavoritesEvent.DirectlyBatchManage.INSTANCE, favoritesEditListViewModel$getFavorites$1) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        }
                                        FavoritesTabList $this$getFavorites_u24lambda_u241_u240 = res;
                                        final boolean z7 = firstLoad2;
                                        final boolean z8 = !refresh2;
                                        favoritesEditListViewModel.updateState(new Function1<FavTabState<FavoritesMediasItem>, FavTabState<FavoritesMediasItem>>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$getFavorites$3$2$1
                                            public final FavTabState<FavoritesMediasItem> invoke(FavTabState<FavoritesMediasItem> favTabState) {
                                                FavTabState<FavoritesMediasItem> copy;
                                                int i;
                                                FavoritesMediasItem copy2;
                                                Intrinsics.checkNotNullParameter(favTabState, "$this$updateState");
                                                FavPageState.Success success = FavPageState.Success.INSTANCE;
                                                List $this$invoke_u24lambda_u240 = FavoritesEditListViewModel.this.getSortedList();
                                                boolean z9 = z7;
                                                boolean z10 = z8;
                                                FavoritesTabList favoritesTabList = res;
                                                FavoritesEditListViewModel favoritesEditListViewModel3 = FavoritesEditListViewModel.this;
                                                if (z9 || z10) {
                                                    $this$invoke_u24lambda_u240.clear();
                                                }
                                                Iterable $this$map$iv = favoritesTabList.getList();
                                                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                                for (Object item$iv$iv : $this$map$iv) {
                                                    FavoritesMediasItem it = (FavoritesMediasItem) item$iv$iv;
                                                    i = favoritesEditListViewModel3.totalMediaCount;
                                                    copy2 = it.copy((r45 & 1) != 0 ? it.cntInfo : null, (r45 & 2) != 0 ? it.cover : null, (r45 & 4) != 0 ? it.favTime : 0, (r45 & 8) != 0 ? it.oid : 0L, (r45 & 16) != 0 ? it.intro : null, (r45 & 32) != 0 ? it.link : null, (r45 & 64) != 0 ? it.ogv : null, (r45 & BR.cover) != 0 ? it.ugc : null, (r45 & BR.hallEnterHotText) != 0 ? it.page : 0, (r45 & BR.roleType) != 0 ? it.playbackPosition : 0, (r45 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? it.playbackDesc : null, (r45 & 2048) != 0 ? it.title : null, (r45 & 4096) != 0 ? it.otype : 0, (r45 & 8192) != 0 ? it.upper : null, (r45 & RingBuffer.CONSUME_SIZE) != 0 ? it.leftText : null, (r45 & 32768) != 0 ? it.leftIconType : 0, (r45 & AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR) != 0 ? it.rightText : null, (r45 & 131072) != 0 ? it.rightIconType : 0, (r45 & 262144) != 0 ? it.userState : 0, (r45 & 524288) != 0 ? it.isCheckMode : true, (r45 & 1048576) != 0 ? it.isChecked : false, (r45 & 2097152) != 0 ? it.cardType : 1, (r45 & 4194304) != 0 ? it.enableDrag : true, (r45 & 8388608) != 0 ? it.canDrag : i < 1000, (r45 & 16777216) != 0 ? it.isInvalid : false, (r45 & 33554432) != 0 ? it.translateInfo : null);
                                                    destination$iv$iv.add(copy2);
                                                }
                                                $this$invoke_u24lambda_u240.addAll((List) destination$iv$iv);
                                                Unit unit = Unit.INSTANCE;
                                                copy = favTabState.copy((r18 & 1) != 0 ? favTabState.pageState : success, (r18 & 2) != 0 ? favTabState.footerState : null, (r18 & 4) != 0 ? favTabState.itemList : $this$invoke_u24lambda_u240, (r18 & 8) != 0 ? favTabState.isRefreshing : false, (r18 & 16) != 0 ? favTabState.isCheckMode : false, (r18 & 32) != 0 ? favTabState.pageNum : FavoritesEditListViewModel.this.requestParam.getPageNum() + 1, (r18 & 64) != 0 ? favTabState.hasMore : false, (r18 & BR.cover) != 0 ? favTabState.hasInvalid : false);
                                                return copy;
                                            }
                                        });
                                        favoritesEditListViewModel.requestParam = FolderRequestParams.copy$default(favoritesEditListViewModel.requestParam, 0L, $this$getFavorites_u24lambda_u241_u240.getHasMore(), favoritesEditListViewModel.requestParam.getPageNum() + 1, 1, null);
                                        if (refresh2) {
                                            z2 = true;
                                        } else {
                                            favoritesEditListViewModel$getFavorites$1.L$0 = $this$suspendThen$iv;
                                            favoritesEditListViewModel$getFavorites$1.L$1 = null;
                                            favoritesEditListViewModel$getFavorites$1.Z$0 = firstLoad2;
                                            favoritesEditListViewModel$getFavorites$1.label = 3;
                                            if (favoritesEditListViewModel.sendEffect(FavoritesEvent.ScrollToTop.INSTANCE, favoritesEditListViewModel$getFavorites$1) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            favoritesEditListViewModel2 = favoritesEditListViewModel;
                                            z4 = z;
                                            firstLoad3 = firstLoad2;
                                            $this$suspendThen$iv2 = $this$suspendThen$iv;
                                            firstLoad2 = firstLoad3;
                                            $this$suspendThen$iv = $this$suspendThen$iv2;
                                            favoritesEditListViewModel = favoritesEditListViewModel2;
                                            z2 = true;
                                        }
                                    }
                                }
                                final boolean z9 = firstLoad2;
                                final boolean z10 = refresh2;
                                favoritesEditListViewModel.updateState(new Function1<FavTabState<FavoritesMediasItem>, FavTabState<FavoritesMediasItem>>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$getFavorites$3$1
                                    public final FavTabState<FavoritesMediasItem> invoke(FavTabState<FavoritesMediasItem> favTabState) {
                                        FavTabState<FavoritesMediasItem> copy;
                                        Intrinsics.checkNotNullParameter(favTabState, "$this$updateState");
                                        copy = favTabState.copy((r18 & 1) != 0 ? favTabState.pageState : (z9 || z10) ? FavPageState.Empty.INSTANCE : favTabState.getPageState(), (r18 & 2) != 0 ? favTabState.footerState : null, (r18 & 4) != 0 ? favTabState.itemList : (z9 || z10) ? CollectionsKt.emptyList() : favTabState.getItemList(), (r18 & 8) != 0 ? favTabState.isRefreshing : false, (r18 & 16) != 0 ? favTabState.isCheckMode : false, (r18 & 32) != 0 ? favTabState.pageNum : favoritesEditListViewModel.requestParam.getPageNum() + 1, (r18 & 64) != 0 ? favTabState.hasMore : false, (r18 & BR.cover) != 0 ? favTabState.hasInvalid : false);
                                        return copy;
                                    }
                                });
                                z2 = true;
                                favoritesEditListViewModel.requestParam = FolderRequestParams.copy$default(favoritesEditListViewModel.requestParam, 0L, res != null ? res.getHasMore() : true, favoritesEditListViewModel.requestParam.getPageNum() + 1, 1, null);
                            } else {
                                z2 = true;
                            }
                            $this$catch$iv = $this$suspendThen$iv;
                            if ($this$catch$iv.getStatus() == Status.ERROR && $this$catch$iv.getError() != null) {
                                Throwable it = $this$catch$iv.getError();
                                Intrinsics.checkNotNull(it);
                                BLog.e(TAG, it.getMessage());
                                favoritesEditListViewModel.isLoading = false;
                                if (!firstLoad2) {
                                    z2 = false;
                                }
                                favoritesEditListViewModel.updateState(new Function1<FavTabState<FavoritesMediasItem>, FavTabState<FavoritesMediasItem>>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$getFavorites$4$1
                                    public final FavTabState<FavoritesMediasItem> invoke(FavTabState<FavoritesMediasItem> favTabState) {
                                        FavPageState pageState;
                                        FavTabState<FavoritesMediasItem> copy;
                                        Intrinsics.checkNotNullParameter(favTabState, "$this$updateState");
                                        if (z2) {
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
                        return Unit.INSTANCE;
                    case 1:
                        favoritesEditListViewModel = this;
                        boolean refresh3 = favoritesEditListViewModel$getFavorites$1.Z$1;
                        boolean firstLoad4 = favoritesEditListViewModel$getFavorites$1.Z$0;
                        ResultKt.throwOnFailure($result);
                        folderFullInfo = $result;
                        refresh2 = refresh3;
                        firstLoad2 = firstLoad4;
                        $this$suspendThen$iv = (Resource) folderFullInfo;
                        z = false;
                        if ($this$suspendThen$iv.getStatus() != Status.SUCCESS) {
                        }
                        $this$catch$iv = $this$suspendThen$iv;
                        if ($this$catch$iv.getStatus() == Status.ERROR) {
                            Throwable it2 = $this$catch$iv.getError();
                            Intrinsics.checkNotNull(it2);
                            BLog.e(TAG, it2.getMessage());
                            favoritesEditListViewModel.isLoading = false;
                            if (!firstLoad2) {
                            }
                            favoritesEditListViewModel.updateState(new Function1<FavTabState<FavoritesMediasItem>, FavTabState<FavoritesMediasItem>>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$getFavorites$4$1
                                public final FavTabState<FavoritesMediasItem> invoke(FavTabState<FavoritesMediasItem> favTabState) {
                                    FavPageState pageState;
                                    FavTabState<FavoritesMediasItem> copy;
                                    Intrinsics.checkNotNullParameter(favTabState, "$this$updateState");
                                    if (z2) {
                                        pageState = ConnectivityMonitor.getInstance().isNetworkActive() ? FavPageState.OtherError.INSTANCE : FavPageState.NetworkError.INSTANCE;
                                    } else {
                                        pageState = favTabState.getPageState();
                                    }
                                    copy = favTabState.copy((r18 & 1) != 0 ? favTabState.pageState : pageState, (r18 & 2) != 0 ? favTabState.footerState : null, (r18 & 4) != 0 ? favTabState.itemList : null, (r18 & 8) != 0 ? favTabState.isRefreshing : false, (r18 & 16) != 0 ? favTabState.isCheckMode : false, (r18 & 32) != 0 ? favTabState.pageNum : 0, (r18 & 64) != 0 ? favTabState.hasMore : false, (r18 & BR.cover) != 0 ? favTabState.hasInvalid : false);
                                    return copy;
                                }
                            });
                            break;
                        }
                        return Unit.INSTANCE;
                    case 2:
                        favoritesEditListViewModel = this;
                        z = false;
                        z3 = false;
                        refresh2 = favoritesEditListViewModel$getFavorites$1.Z$1;
                        firstLoad2 = favoritesEditListViewModel$getFavorites$1.Z$0;
                        res = (FavoritesTabList) favoritesEditListViewModel$getFavorites$1.L$1;
                        $this$suspendThen$iv = (Resource) favoritesEditListViewModel$getFavorites$1.L$0;
                        ResultKt.throwOnFailure($result);
                        FavoritesTabList $this$getFavorites_u24lambda_u241_u2402 = res;
                        if (firstLoad2) {
                        }
                        if (!refresh2) {
                        }
                        favoritesEditListViewModel.updateState(new Function1<FavTabState<FavoritesMediasItem>, FavTabState<FavoritesMediasItem>>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$getFavorites$3$2$1
                            public final FavTabState<FavoritesMediasItem> invoke(FavTabState<FavoritesMediasItem> favTabState) {
                                FavTabState<FavoritesMediasItem> copy;
                                int i;
                                FavoritesMediasItem copy2;
                                Intrinsics.checkNotNullParameter(favTabState, "$this$updateState");
                                FavPageState.Success success = FavPageState.Success.INSTANCE;
                                List $this$invoke_u24lambda_u240 = FavoritesEditListViewModel.this.getSortedList();
                                boolean z92 = z7;
                                boolean z102 = z8;
                                FavoritesTabList favoritesTabList = res;
                                FavoritesEditListViewModel favoritesEditListViewModel3 = FavoritesEditListViewModel.this;
                                if (z92 || z102) {
                                    $this$invoke_u24lambda_u240.clear();
                                }
                                Iterable $this$map$iv = favoritesTabList.getList();
                                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                for (Object item$iv$iv : $this$map$iv) {
                                    FavoritesMediasItem it3 = (FavoritesMediasItem) item$iv$iv;
                                    i = favoritesEditListViewModel3.totalMediaCount;
                                    copy2 = it3.copy((r45 & 1) != 0 ? it3.cntInfo : null, (r45 & 2) != 0 ? it3.cover : null, (r45 & 4) != 0 ? it3.favTime : 0, (r45 & 8) != 0 ? it3.oid : 0L, (r45 & 16) != 0 ? it3.intro : null, (r45 & 32) != 0 ? it3.link : null, (r45 & 64) != 0 ? it3.ogv : null, (r45 & BR.cover) != 0 ? it3.ugc : null, (r45 & BR.hallEnterHotText) != 0 ? it3.page : 0, (r45 & BR.roleType) != 0 ? it3.playbackPosition : 0, (r45 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? it3.playbackDesc : null, (r45 & 2048) != 0 ? it3.title : null, (r45 & 4096) != 0 ? it3.otype : 0, (r45 & 8192) != 0 ? it3.upper : null, (r45 & RingBuffer.CONSUME_SIZE) != 0 ? it3.leftText : null, (r45 & 32768) != 0 ? it3.leftIconType : 0, (r45 & AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR) != 0 ? it3.rightText : null, (r45 & 131072) != 0 ? it3.rightIconType : 0, (r45 & 262144) != 0 ? it3.userState : 0, (r45 & 524288) != 0 ? it3.isCheckMode : true, (r45 & 1048576) != 0 ? it3.isChecked : false, (r45 & 2097152) != 0 ? it3.cardType : 1, (r45 & 4194304) != 0 ? it3.enableDrag : true, (r45 & 8388608) != 0 ? it3.canDrag : i < 1000, (r45 & 16777216) != 0 ? it3.isInvalid : false, (r45 & 33554432) != 0 ? it3.translateInfo : null);
                                    destination$iv$iv.add(copy2);
                                }
                                $this$invoke_u24lambda_u240.addAll((List) destination$iv$iv);
                                Unit unit = Unit.INSTANCE;
                                copy = favTabState.copy((r18 & 1) != 0 ? favTabState.pageState : success, (r18 & 2) != 0 ? favTabState.footerState : null, (r18 & 4) != 0 ? favTabState.itemList : $this$invoke_u24lambda_u240, (r18 & 8) != 0 ? favTabState.isRefreshing : false, (r18 & 16) != 0 ? favTabState.isCheckMode : false, (r18 & 32) != 0 ? favTabState.pageNum : FavoritesEditListViewModel.this.requestParam.getPageNum() + 1, (r18 & 64) != 0 ? favTabState.hasMore : false, (r18 & BR.cover) != 0 ? favTabState.hasInvalid : false);
                                return copy;
                            }
                        });
                        favoritesEditListViewModel.requestParam = FolderRequestParams.copy$default(favoritesEditListViewModel.requestParam, 0L, $this$getFavorites_u24lambda_u241_u2402.getHasMore(), favoritesEditListViewModel.requestParam.getPageNum() + 1, 1, null);
                        if (refresh2) {
                        }
                        break;
                    case 3:
                        favoritesEditListViewModel2 = this;
                        z4 = false;
                        firstLoad3 = favoritesEditListViewModel$getFavorites$1.Z$0;
                        $this$suspendThen$iv2 = (Resource) favoritesEditListViewModel$getFavorites$1.L$0;
                        ResultKt.throwOnFailure($result);
                        firstLoad2 = firstLoad3;
                        $this$suspendThen$iv = $this$suspendThen$iv2;
                        favoritesEditListViewModel = favoritesEditListViewModel2;
                        z2 = true;
                        $this$catch$iv = $this$suspendThen$iv;
                        if ($this$catch$iv.getStatus() == Status.ERROR) {
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        favoritesEditListViewModel$getFavorites$1 = new FavoritesEditListViewModel$getFavorites$1(this, continuation);
        Object $result2 = favoritesEditListViewModel$getFavorites$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (favoritesEditListViewModel$getFavorites$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object getFavorites$default(FavoritesEditListViewModel favoritesEditListViewModel, boolean z, boolean z2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return favoritesEditListViewModel.getFavorites(z, z2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FavTabState getFavorites$lambda$0(boolean $firstLoad, boolean $refresh, FavTabState $this$updateState) {
        Intrinsics.checkNotNullParameter($this$updateState, "$this$updateState");
        return FavTabState.copy$default($this$updateState, $firstLoad ? FavPageState.Loading.INSTANCE : $this$updateState.getPageState(), null, null, $refresh, false, 0, false, false, BR.group, null);
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
        BLog.d(TAG, "action:" + action);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new FavoritesEditListViewModel$onAction$1(action, this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sortMedias(String str, Continuation<? super Unit> continuation) {
        FavoritesEditListViewModel$sortMedias$1 favoritesEditListViewModel$sortMedias$1;
        FavoritesEditListViewModel favoritesEditListViewModel;
        long j;
        if (continuation instanceof FavoritesEditListViewModel$sortMedias$1) {
            favoritesEditListViewModel$sortMedias$1 = (FavoritesEditListViewModel$sortMedias$1) continuation;
            if ((favoritesEditListViewModel$sortMedias$1.label & Integer.MIN_VALUE) != 0) {
                favoritesEditListViewModel$sortMedias$1.label -= Integer.MIN_VALUE;
                Object $result = favoritesEditListViewModel$sortMedias$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (favoritesEditListViewModel$sortMedias$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            j = this.playlistId;
                            favoritesEditListViewModel$sortMedias$1.label = 1;
                        } catch (Exception e) {
                            e = e;
                            favoritesEditListViewModel = this;
                            BLog.w("ListPresenter.PlaySet", e);
                            JobKt.ensureActive(favoritesEditListViewModel$sortMedias$1.getContext());
                            ReportHelper.INSTANCE.reportCompleteSortDetailEvent(0);
                            favoritesEditListViewModel.mSortOps.clear();
                            return Unit.INSTANCE;
                        }
                        if (PlaySetApiKt.sortPlaySetMedias(str, j, favoritesEditListViewModel$sortMedias$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        favoritesEditListViewModel = this;
                        JobKt.ensureActive(favoritesEditListViewModel$sortMedias$1.getContext());
                        ReportHelper.INSTANCE.reportCompleteSortDetailEvent(1);
                        favoritesEditListViewModel.mSortOps.clear();
                        return Unit.INSTANCE;
                    case 1:
                        favoritesEditListViewModel = this;
                        try {
                            ResultKt.throwOnFailure($result);
                            JobKt.ensureActive(favoritesEditListViewModel$sortMedias$1.getContext());
                            ReportHelper.INSTANCE.reportCompleteSortDetailEvent(1);
                            favoritesEditListViewModel.mSortOps.clear();
                        } catch (Exception e2) {
                            e = e2;
                            BLog.w("ListPresenter.PlaySet", e);
                            JobKt.ensureActive(favoritesEditListViewModel$sortMedias$1.getContext());
                            ReportHelper.INSTANCE.reportCompleteSortDetailEvent(0);
                            favoritesEditListViewModel.mSortOps.clear();
                            return Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        favoritesEditListViewModel$sortMedias$1 = new FavoritesEditListViewModel$sortMedias$1(this, continuation);
        Object $result2 = favoritesEditListViewModel$sortMedias$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (favoritesEditListViewModel$sortMedias$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
    @Override // tv.danmaku.bili.ui.favorites.viewmodel.BaseFavoritesViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object onDeleteSuccess(boolean success, Continuation<? super Unit> continuation) {
        FavoritesEditListViewModel$onDeleteSuccess$1 favoritesEditListViewModel$onDeleteSuccess$1;
        FavoritesEditListViewModel favoritesEditListViewModel;
        if (continuation instanceof FavoritesEditListViewModel$onDeleteSuccess$1) {
            favoritesEditListViewModel$onDeleteSuccess$1 = (FavoritesEditListViewModel$onDeleteSuccess$1) continuation;
            if ((favoritesEditListViewModel$onDeleteSuccess$1.label & Integer.MIN_VALUE) != 0) {
                favoritesEditListViewModel$onDeleteSuccess$1.label -= Integer.MIN_VALUE;
                Object $result = favoritesEditListViewModel$onDeleteSuccess$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (favoritesEditListViewModel$onDeleteSuccess$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        boolean success2 = success;
                        favoritesEditListViewModel$onDeleteSuccess$1.label = 1;
                        if (sendEffect(new FavoritesEvent.ShowDeletedToast(success2), favoritesEditListViewModel$onDeleteSuccess$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        favoritesEditListViewModel = this;
                        break;
                    case 1:
                        favoritesEditListViewModel = this;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (((FavTabState) favoritesEditListViewModel.getUiStateFlow().getValue()).getItemList().isEmpty()) {
                    favoritesEditListViewModel.sendAction(FavoritesAction.Refresh.INSTANCE);
                }
                return Unit.INSTANCE;
            }
        }
        favoritesEditListViewModel$onDeleteSuccess$1 = new FavoritesEditListViewModel$onDeleteSuccess$1(this, continuation);
        Object $result2 = favoritesEditListViewModel$onDeleteSuccess$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (favoritesEditListViewModel$onDeleteSuccess$1.label) {
        }
        if (((FavTabState) favoritesEditListViewModel.getUiStateFlow().getValue()).getItemList().isEmpty()) {
        }
        return Unit.INSTANCE;
    }

    /* compiled from: FavoritesEditListViewModel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesEditListViewModel$Companion;", "", "<init>", "()V", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: FavoritesEditListViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesEditListViewModel$FolderRequestParams;", "", "playlistId", "", "hasMore", "", "pageNum", "", "<init>", "(JZI)V", "getPlaylistId", "()J", "getHasMore", "()Z", "getPageNum", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class FolderRequestParams {
        public static final int $stable = 0;
        private final boolean hasMore;
        private final int pageNum;
        private final long playlistId;

        public static /* synthetic */ FolderRequestParams copy$default(FolderRequestParams folderRequestParams, long j, boolean z, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = folderRequestParams.playlistId;
            }
            if ((i2 & 2) != 0) {
                z = folderRequestParams.hasMore;
            }
            if ((i2 & 4) != 0) {
                i = folderRequestParams.pageNum;
            }
            return folderRequestParams.copy(j, z, i);
        }

        public final long component1() {
            return this.playlistId;
        }

        public final boolean component2() {
            return this.hasMore;
        }

        public final int component3() {
            return this.pageNum;
        }

        public final FolderRequestParams copy(long j, boolean z, int i) {
            return new FolderRequestParams(j, z, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FolderRequestParams) {
                FolderRequestParams folderRequestParams = (FolderRequestParams) obj;
                return this.playlistId == folderRequestParams.playlistId && this.hasMore == folderRequestParams.hasMore && this.pageNum == folderRequestParams.pageNum;
            }
            return false;
        }

        public int hashCode() {
            return (((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.playlistId) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasMore)) * 31) + this.pageNum;
        }

        public String toString() {
            long j = this.playlistId;
            boolean z = this.hasMore;
            return "FolderRequestParams(playlistId=" + j + ", hasMore=" + z + ", pageNum=" + this.pageNum + ")";
        }

        public FolderRequestParams(long playlistId, boolean hasMore, int pageNum) {
            this.playlistId = playlistId;
            this.hasMore = hasMore;
            this.pageNum = pageNum;
        }

        public /* synthetic */ FolderRequestParams(long j, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? true : z, i);
        }

        public final long getPlaylistId() {
            return this.playlistId;
        }

        public final boolean getHasMore() {
            return this.hasMore;
        }

        public final int getPageNum() {
            return this.pageNum;
        }
    }
}