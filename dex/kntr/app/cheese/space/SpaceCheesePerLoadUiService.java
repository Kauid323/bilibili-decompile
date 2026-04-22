package kntr.app.cheese.space;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.bilibili.ktor.KApiResponse;
import com.bilibili.ogv.operation3.module.list.LoadMoreUiKt;
import com.bilibili.ogv.operation3.module.list.MoreLoadingState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kntr.app.cheese.space.SpaceCheesePerLoadUiService;
import kntr.app.cheese.space.aggregate.UpId;
import kntr.app.cheese.space.api.ClassifiedInfo;
import kntr.app.cheese.space.api.PageData;
import kntr.app.cheese.space.api.SeasonFeed;
import kntr.app.cheese.space.api.SeasonInfo;
import kntr.app.cheese.space.api.SeasonModel;
import kntr.app.cheese.space.api.SortModel;
import kntr.app.cheese.space.api.SpaceCheesePageApi;
import kntr.app.cheese.space.feed.CreateCheeseFeedKomponent;
import kntr.app.cheese.space.filter.ClassifiedTypeIndex;
import kntr.app.cheese.space.filter.SortTypeIndex;
import kntr.app.cheese.space.product.CreateCheeseProductKomponent;
import kntr.app.cheese.space.title.CreateCheeseTitleKomponent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.compose.launcher.LocalToasterKt;
import kntr.common.komponent.KomponentHostScope;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.UiComposableLike;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: SpaceCheesePerLoadUiService.kt */
@PerLoadScope
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BY\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u001f\u001a\u00020\u001d2\b\b\u0002\u0010(\u001a\u00020)H\u0002J\b\u0010/\u001a\u000200H\u0002J\u0017\u00101\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u000203H\u0007¢\u0006\u0002\u00104J(\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u00182\u0006\u00107\u001a\u00020\u00182\b\b\u0002\u00108\u001a\u00020)H\u0082@¢\u0006\u0002\u00109R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010%\u001a\u00020\u0018X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00180'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00180-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00180-X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lkntr/app/cheese/space/SpaceCheesePerLoadUiService;", RoomRecommendViewModel.EMPTY_CURSOR, "komponentScope", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "pageData", "Lkntr/app/cheese/space/api/PageData;", "filmListHubChannelApi", "Lkntr/app/cheese/space/api/SpaceCheesePageApi;", "createCheeseFeedKomponent", "Lkntr/app/cheese/space/feed/CreateCheeseFeedKomponent;", "createCheeseProductKomponent", "Lkntr/app/cheese/space/product/CreateCheeseProductKomponent;", "createCheeseTitleKomponent", "Lkntr/app/cheese/space/title/CreateCheeseTitleKomponent;", "classifiedTypeIndex", "Lkntr/app/cheese/space/filter/ClassifiedTypeIndex;", "sortTypeIndex", "Lkntr/app/cheese/space/filter/SortTypeIndex;", "upId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/common/komponent/KomponentScope;Lkntr/app/cheese/space/api/PageData;Lkntr/app/cheese/space/api/SpaceCheesePageApi;Lkntr/app/cheese/space/feed/CreateCheeseFeedKomponent;Lkntr/app/cheese/space/product/CreateCheeseProductKomponent;Lkntr/app/cheese/space/title/CreateCheeseTitleKomponent;Lkntr/app/cheese/space/filter/ClassifiedTypeIndex;Lkntr/app/cheese/space/filter/SortTypeIndex;J)V", "pageNum", RoomRecommendViewModel.EMPTY_CURSOR, "items", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkntr/app/cheese/space/ItemEntry;", "<set-?>", "Lcom/bilibili/ogv/operation3/module/list/MoreLoadingState;", "moreLoadingState", "getMoreLoadingState", "()Lcom/bilibili/ogv/operation3/module/list/MoreLoadingState;", "setMoreLoadingState", "(Lcom/bilibili/ogv/operation3/module/list/MoreLoadingState;)V", "moreLoadingState$delegate", "Landroidx/compose/runtime/MutableState;", "topModuleCount", "scrollToPosition", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "hasNext", RoomRecommendViewModel.EMPTY_CURSOR, "listState", "Landroidx/compose/foundation/lazy/LazyListState;", "classifiedTypeIdState", "Landroidx/compose/runtime/State;", "sortTypeIdState", "getCurrentTabName", RoomRecommendViewModel.EMPTY_CURSOR, "Content", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "loadMore", "classifiedTypeId", "sortTypeId", "isAppend", "(IIZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SpaceCheesePerLoadUiService {
    public static final int $stable = 8;
    private final State<Integer> classifiedTypeIdState;
    private final ClassifiedTypeIndex classifiedTypeIndex;
    private final CreateCheeseFeedKomponent createCheeseFeedKomponent;
    private final CreateCheeseProductKomponent createCheeseProductKomponent;
    private final CreateCheeseTitleKomponent createCheeseTitleKomponent;
    private final SpaceCheesePageApi filmListHubChannelApi;
    private final SnapshotStateList<ItemEntry> items;
    private final KomponentScope<Unit> komponentScope;
    private final LazyListState listState;
    private final MutableState moreLoadingState$delegate;
    private final PageData pageData;
    private int pageNum;
    private final MutableSharedFlow<Integer> scrollToPosition;
    private final State<Integer> sortTypeIdState;
    private final SortTypeIndex sortTypeIndex;
    private final int topModuleCount;
    private final long upId;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$2(SpaceCheesePerLoadUiService spaceCheesePerLoadUiService, Modifier modifier, int i, int i2, Composer composer, int i3) {
        spaceCheesePerLoadUiService.Content(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    @Inject
    public SpaceCheesePerLoadUiService(KomponentScope<? super Unit> komponentScope, PageData pageData, SpaceCheesePageApi filmListHubChannelApi, CreateCheeseFeedKomponent createCheeseFeedKomponent, CreateCheeseProductKomponent createCheeseProductKomponent, CreateCheeseTitleKomponent createCheeseTitleKomponent, ClassifiedTypeIndex classifiedTypeIndex, SortTypeIndex sortTypeIndex, @UpId long upId) {
        Intrinsics.checkNotNullParameter(komponentScope, "komponentScope");
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        Intrinsics.checkNotNullParameter(filmListHubChannelApi, "filmListHubChannelApi");
        Intrinsics.checkNotNullParameter(createCheeseFeedKomponent, "createCheeseFeedKomponent");
        Intrinsics.checkNotNullParameter(createCheeseProductKomponent, "createCheeseProductKomponent");
        Intrinsics.checkNotNullParameter(createCheeseTitleKomponent, "createCheeseTitleKomponent");
        Intrinsics.checkNotNullParameter(classifiedTypeIndex, "classifiedTypeIndex");
        Intrinsics.checkNotNullParameter(sortTypeIndex, "sortTypeIndex");
        this.komponentScope = komponentScope;
        this.pageData = pageData;
        this.filmListHubChannelApi = filmListHubChannelApi;
        this.createCheeseFeedKomponent = createCheeseFeedKomponent;
        this.createCheeseProductKomponent = createCheeseProductKomponent;
        this.createCheeseTitleKomponent = createCheeseTitleKomponent;
        this.classifiedTypeIndex = classifiedTypeIndex;
        this.sortTypeIndex = sortTypeIndex;
        this.upId = upId;
        this.pageNum = 1;
        this.items = SnapshotStateKt.mutableStateListOf();
        this.moreLoadingState$delegate = SnapshotStateKt.mutableStateOf$default(getMoreLoadingState(true), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.topModuleCount = 2;
        this.scrollToPosition = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.listState = new LazyListState(0, 0, 3, (DefaultConstructorMarker) null);
        this.classifiedTypeIdState = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.cheese.space.SpaceCheesePerLoadUiService$$ExternalSyntheticLambda2
            public final Object invoke() {
                int classifiedTypeIdState$lambda$0;
                classifiedTypeIdState$lambda$0 = SpaceCheesePerLoadUiService.classifiedTypeIdState$lambda$0(SpaceCheesePerLoadUiService.this);
                return Integer.valueOf(classifiedTypeIdState$lambda$0);
            }
        });
        this.sortTypeIdState = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.cheese.space.SpaceCheesePerLoadUiService$$ExternalSyntheticLambda3
            public final Object invoke() {
                int sortTypeIdState$lambda$0;
                sortTypeIdState$lambda$0 = SpaceCheesePerLoadUiService.sortTypeIdState$lambda$0(SpaceCheesePerLoadUiService.this);
                return Integer.valueOf(sortTypeIdState$lambda$0);
            }
        });
        KomponentHostScope.-CC.launch$default(this.komponentScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    private final MoreLoadingState getMoreLoadingState() {
        State $this$getValue$iv = this.moreLoadingState$delegate;
        return (MoreLoadingState) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setMoreLoadingState(MoreLoadingState moreLoadingState) {
        MutableState $this$setValue$iv = this.moreLoadingState$delegate;
        $this$setValue$iv.setValue(moreLoadingState);
    }

    static /* synthetic */ MoreLoadingState getMoreLoadingState$default(SpaceCheesePerLoadUiService spaceCheesePerLoadUiService, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return spaceCheesePerLoadUiService.getMoreLoadingState(z);
    }

    private final MoreLoadingState getMoreLoadingState(boolean hasNext) {
        if (!hasNext) {
            return MoreLoadingState.NO_MORE;
        }
        return MoreLoadingState.IDLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int classifiedTypeIdState$lambda$0(SpaceCheesePerLoadUiService this$0) {
        ClassifiedInfo classifiedInfo = (ClassifiedInfo) CollectionsKt.getOrNull(this$0.pageData.getCourse_info().getSeason_info().getClassified_info_list(), this$0.classifiedTypeIndex.getValue());
        if (classifiedInfo != null) {
            return classifiedInfo.getId();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sortTypeIdState$lambda$0(SpaceCheesePerLoadUiService this$0) {
        SortModel sortModel = (SortModel) CollectionsKt.getOrNull(this$0.pageData.getCourse_info().getSeason_info().getSort_model_list(), this$0.sortTypeIndex.getValue());
        if (sortModel != null) {
            return sortModel.getSort_id();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getCurrentTabName() {
        String name;
        ClassifiedInfo classifiedInfo = (ClassifiedInfo) CollectionsKt.getOrNull(this.pageData.getCourse_info().getSeason_info().getClassified_info_list(), this.classifiedTypeIndex.getValue());
        return (classifiedInfo == null || (name = classifiedInfo.getName()) == null) ? RoomRecommendViewModel.EMPTY_CURSOR : name;
    }

    /* compiled from: SpaceCheesePerLoadUiService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.cheese.space.SpaceCheesePerLoadUiService$1", f = "SpaceCheesePerLoadUiService.kt", i = {0}, l = {99}, m = "invokeSuspend", n = {"scope"}, s = {"L$0"}, v = 1)
    /* renamed from: kntr.app.cheese.space.SpaceCheesePerLoadUiService$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    KomponentHostScope scope = KomponentHostScope.-CC.__sub$default(SpaceCheesePerLoadUiService.this.komponentScope, (Function1) null, 1, (Object) null);
                    SpaceCheesePerLoadUiService.this.items.add(new ItemEntry(KomponentHostScope.-CC.embed$default(scope, SpaceCheesePerLoadUiService.this.createCheeseProductKomponent.invoke(SpaceCheesePerLoadUiService.this.pageData.getCourse_info().getProduct_info()), (Function1) null, 2, (Object) null), scope));
                    SpaceCheesePerLoadUiService.this.items.add(new ItemEntry(KomponentHostScope.-CC.embed$default(scope, SpaceCheesePerLoadUiService.this.createCheeseTitleKomponent.invoke(SpaceCheesePerLoadUiService.this.pageData.getCourse_info().getSeason_info()), (Function1) null, 2, (Object) null), scope));
                    Iterable $this$mapIndexedTo$iv = SpaceCheesePerLoadUiService.this.pageData.getCourse_info().getSeason_info().getSeason_model_list();
                    Collection destination$iv = SpaceCheesePerLoadUiService.this.items;
                    SpaceCheesePerLoadUiService spaceCheesePerLoadUiService = SpaceCheesePerLoadUiService.this;
                    int index$iv = 0;
                    for (Object item$iv : $this$mapIndexedTo$iv) {
                        int index$iv2 = index$iv + 1;
                        if (index$iv < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        SeasonModel item = (SeasonModel) item$iv;
                        destination$iv.add(new ItemEntry(KomponentHostScope.-CC.embed$default(scope, spaceCheesePerLoadUiService.createCheeseFeedKomponent.invoke(item, index$iv, spaceCheesePerLoadUiService.getCurrentTabName()), (Function1) null, 2, (Object) null), scope));
                        index$iv = index$iv2;
                        $this$mapIndexedTo$iv = $this$mapIndexedTo$iv;
                    }
                    final SpaceCheesePerLoadUiService spaceCheesePerLoadUiService2 = SpaceCheesePerLoadUiService.this;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(scope);
                    this.label = 1;
                    if (FlowKt.collectLatest(SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.cheese.space.SpaceCheesePerLoadUiService$1$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Pair invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = SpaceCheesePerLoadUiService.AnonymousClass1.invokeSuspend$lambda$1(SpaceCheesePerLoadUiService.this);
                            return invokeSuspend$lambda$1;
                        }
                    }), new AnonymousClass3(SpaceCheesePerLoadUiService.this, null), (Continuation) this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    KomponentHostScope komponentHostScope = (KomponentHostScope) this.L$0;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SpaceCheesePerLoadUiService.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "<destruct>", "Lkotlin/Pair;", RoomRecommendViewModel.EMPTY_CURSOR}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "kntr.app.cheese.space.SpaceCheesePerLoadUiService$1$3", f = "SpaceCheesePerLoadUiService.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3}, l = {111, 113, 116, 123}, m = "invokeSuspend", n = {"<destruct>", "classifiedTypeId", "sortTypeId", "<destruct>", "classifiedTypeId", "sortTypeId", "<destruct>", "classifiedTypeId", "sortTypeId", "loadCount", "<destruct>", "classifiedTypeId", "sortTypeId", "loadCount"}, s = {"L$0", "I$0", "I$1", "L$0", "I$0", "I$1", "L$0", "I$0", "I$1", "I$2", "L$0", "I$0", "I$1", "I$2"}, v = 1)
        /* renamed from: kntr.app.cheese.space.SpaceCheesePerLoadUiService$1$3  reason: invalid class name */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class AnonymousClass3 extends SuspendLambda implements Function2<Pair<? extends Integer, ? extends Integer>, Continuation<? super Unit>, Object> {
            int I$0;
            int I$1;
            int I$2;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SpaceCheesePerLoadUiService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(SpaceCheesePerLoadUiService spaceCheesePerLoadUiService, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = spaceCheesePerLoadUiService;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass3 = new AnonymousClass3(this.this$0, continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            public final Object invoke(Pair<Integer, Integer> pair, Continuation<? super Unit> continuation) {
                return create(pair, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:24:0x00c4 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:25:0x00c5  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x00d7  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x013e A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:40:0x013f  */
            /* JADX WARN: Removed duplicated region for block: B:43:0x0100 A[SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object $result) {
                int classifiedTypeId;
                int loadCount;
                int classifiedTypeId2;
                int classifiedTypeId3;
                AnonymousClass3 anonymousClass3;
                final int sortTypeId;
                final int classifiedTypeId4;
                int loadCount2;
                Pair pair = (Pair) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        classifiedTypeId = ((Number) pair.component1()).intValue();
                        loadCount = ((Number) pair.component2()).intValue();
                        this.this$0.pageNum = 1;
                        this.this$0.setMoreLoadingState(MoreLoadingState.IDLE);
                        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt.firstOrNull(this.this$0.listState.getLayoutInfo().getVisibleItemsInfo());
                        if (!(lazyListItemInfo != null && lazyListItemInfo.getIndex() == 0)) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(pair);
                            this.I$0 = classifiedTypeId;
                            this.I$1 = loadCount;
                            this.label = 1;
                            if (this.this$0.scrollToPosition.emit(Boxing.boxInt(1), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(pair);
                        this.I$0 = classifiedTypeId;
                        this.I$1 = loadCount;
                        this.label = 2;
                        if (this.this$0.loadMore(classifiedTypeId, loadCount, false, (Continuation) this) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        classifiedTypeId2 = classifiedTypeId;
                        classifiedTypeId3 = 0;
                        anonymousClass3 = this;
                        sortTypeId = loadCount;
                        classifiedTypeId4 = classifiedTypeId2;
                        while (true) {
                            if (anonymousClass3.this$0.items.size() < 5) {
                                loadCount2 = classifiedTypeId3 + 1;
                                if (classifiedTypeId3 < 10) {
                                    anonymousClass3.L$0 = SpillingKt.nullOutSpilledVariable(pair);
                                    anonymousClass3.I$0 = classifiedTypeId4;
                                    anonymousClass3.I$1 = sortTypeId;
                                    anonymousClass3.I$2 = loadCount2;
                                    anonymousClass3.label = 3;
                                    if (SpaceCheesePerLoadUiService.loadMore$default(anonymousClass3.this$0, classifiedTypeId4, sortTypeId, false, (Continuation) anonymousClass3, 4, null) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    classifiedTypeId3 = loadCount2;
                                } else {
                                    classifiedTypeId3 = loadCount2;
                                }
                            }
                        }
                        final SpaceCheesePerLoadUiService spaceCheesePerLoadUiService = anonymousClass3.this$0;
                        final Flow $this$filter$iv = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.cheese.space.SpaceCheesePerLoadUiService$1$3$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                boolean invokeSuspend$lambda$0;
                                invokeSuspend$lambda$0 = SpaceCheesePerLoadUiService.AnonymousClass1.AnonymousClass3.invokeSuspend$lambda$0(SpaceCheesePerLoadUiService.this);
                                return Boolean.valueOf(invokeSuspend$lambda$0);
                            }
                        });
                        Flow $this$filter$iv2 = FlowKt.conflate(new Flow<Boolean>() { // from class: kntr.app.cheese.space.SpaceCheesePerLoadUiService$1$3$invokeSuspend$$inlined$filter$1
                            public Object collect(FlowCollector collector, Continuation $completion) {
                                Object collect = $this$filter$iv.collect(new AnonymousClass2(collector), $completion);
                                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                            }

                            /* compiled from: Emitters.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                            /* renamed from: kntr.app.cheese.space.SpaceCheesePerLoadUiService$1$3$invokeSuspend$$inlined$filter$1$2  reason: invalid class name */
                            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                            public static final class AnonymousClass2<T> implements FlowCollector {
                                final /* synthetic */ FlowCollector $this_unsafeFlow;

                                /* compiled from: Emitters.kt */
                                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                                @DebugMetadata(c = "kntr.app.cheese.space.SpaceCheesePerLoadUiService$1$3$invokeSuspend$$inlined$filter$1$2", f = "SpaceCheesePerLoadUiService.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                                /* renamed from: kntr.app.cheese.space.SpaceCheesePerLoadUiService$1$3$invokeSuspend$$inlined$filter$1$2$1  reason: invalid class name */
                                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                                public static final class AnonymousClass1 extends ContinuationImpl {
                                    int I$0;
                                    Object L$0;
                                    Object L$1;
                                    Object L$2;
                                    Object L$3;
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
                                /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
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
                                                    FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                                    AnonymousClass1 anonymousClass1 = $continuation;
                                                    boolean it = ((Boolean) value).booleanValue();
                                                    if (it) {
                                                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                                        $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                                        $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                                        $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$filter_u24lambda_u240);
                                                        $continuation.I$0 = 0;
                                                        $continuation.label = 1;
                                                        if ($this$filter_u24lambda_u240.emit(value, $continuation) != coroutine_suspended) {
                                                            break;
                                                        } else {
                                                            return coroutine_suspended;
                                                        }
                                                    }
                                                    break;
                                                case 1:
                                                    int i = $continuation.I$0;
                                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                                    Object obj = $continuation.L$2;
                                                    AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
                                                    Object value2 = $continuation.L$0;
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
                        });
                        final SpaceCheesePerLoadUiService spaceCheesePerLoadUiService2 = anonymousClass3.this$0;
                        anonymousClass3.L$0 = SpillingKt.nullOutSpilledVariable(pair);
                        anonymousClass3.I$0 = classifiedTypeId4;
                        anonymousClass3.I$1 = sortTypeId;
                        anonymousClass3.I$2 = classifiedTypeId3;
                        anonymousClass3.label = 4;
                        return $this$filter$iv2.collect(new FlowCollector() { // from class: kntr.app.cheese.space.SpaceCheesePerLoadUiService.1.3.3
                            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                return emit(((Boolean) value).booleanValue(), $completion);
                            }

                            public final Object emit(boolean it, Continuation<? super Unit> continuation) {
                                Object loadMore$default = SpaceCheesePerLoadUiService.loadMore$default(SpaceCheesePerLoadUiService.this, classifiedTypeId4, sortTypeId, false, continuation, 4, null);
                                return loadMore$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? loadMore$default : Unit.INSTANCE;
                            }
                        }, (Continuation) anonymousClass3) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                    case 1:
                        loadCount = this.I$1;
                        classifiedTypeId = this.I$0;
                        ResultKt.throwOnFailure($result);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(pair);
                        this.I$0 = classifiedTypeId;
                        this.I$1 = loadCount;
                        this.label = 2;
                        if (this.this$0.loadMore(classifiedTypeId, loadCount, false, (Continuation) this) != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        loadCount = this.I$1;
                        classifiedTypeId2 = this.I$0;
                        ResultKt.throwOnFailure($result);
                        classifiedTypeId3 = 0;
                        anonymousClass3 = this;
                        sortTypeId = loadCount;
                        classifiedTypeId4 = classifiedTypeId2;
                        while (true) {
                            if (anonymousClass3.this$0.items.size() < 5) {
                            }
                            classifiedTypeId3 = loadCount2;
                        }
                        final SpaceCheesePerLoadUiService spaceCheesePerLoadUiService3 = anonymousClass3.this$0;
                        final Flow $this$filter$iv3 = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.cheese.space.SpaceCheesePerLoadUiService$1$3$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                boolean invokeSuspend$lambda$0;
                                invokeSuspend$lambda$0 = SpaceCheesePerLoadUiService.AnonymousClass1.AnonymousClass3.invokeSuspend$lambda$0(SpaceCheesePerLoadUiService.this);
                                return Boolean.valueOf(invokeSuspend$lambda$0);
                            }
                        });
                        Flow $this$filter$iv22 = FlowKt.conflate(new Flow<Boolean>() { // from class: kntr.app.cheese.space.SpaceCheesePerLoadUiService$1$3$invokeSuspend$$inlined$filter$1
                            public Object collect(FlowCollector collector, Continuation $completion) {
                                Object collect = $this$filter$iv3.collect(new AnonymousClass2(collector), $completion);
                                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                            }

                            /* compiled from: Emitters.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                            /* renamed from: kntr.app.cheese.space.SpaceCheesePerLoadUiService$1$3$invokeSuspend$$inlined$filter$1$2  reason: invalid class name */
                            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                            public static final class AnonymousClass2<T> implements FlowCollector {
                                final /* synthetic */ FlowCollector $this_unsafeFlow;

                                /* compiled from: Emitters.kt */
                                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                                @DebugMetadata(c = "kntr.app.cheese.space.SpaceCheesePerLoadUiService$1$3$invokeSuspend$$inlined$filter$1$2", f = "SpaceCheesePerLoadUiService.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                                /* renamed from: kntr.app.cheese.space.SpaceCheesePerLoadUiService$1$3$invokeSuspend$$inlined$filter$1$2$1  reason: invalid class name */
                                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                                public static final class AnonymousClass1 extends ContinuationImpl {
                                    int I$0;
                                    Object L$0;
                                    Object L$1;
                                    Object L$2;
                                    Object L$3;
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
                                /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final Object emit(Object value, Continuation $completion) {
                                    Continuation $continuation;
                                    if ($completion instanceof AnonymousClass1) {
                                        $continuation = (AnonymousClass1) $completion;
                                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                                            $continuation.label -= Integer.MIN_VALUE;
                                            Object $result2 = $continuation.result;
                                            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            switch ($continuation.label) {
                                                case 0:
                                                    ResultKt.throwOnFailure($result2);
                                                    FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                                    AnonymousClass1 anonymousClass1 = $continuation;
                                                    boolean it = ((Boolean) value).booleanValue();
                                                    if (it) {
                                                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                                        $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                                        $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                                        $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$filter_u24lambda_u240);
                                                        $continuation.I$0 = 0;
                                                        $continuation.label = 1;
                                                        if ($this$filter_u24lambda_u240.emit(value, $continuation) != coroutine_suspended2) {
                                                            break;
                                                        } else {
                                                            return coroutine_suspended2;
                                                        }
                                                    }
                                                    break;
                                                case 1:
                                                    int i = $continuation.I$0;
                                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                                    Object obj = $continuation.L$2;
                                                    AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
                                                    Object value2 = $continuation.L$0;
                                                    ResultKt.throwOnFailure($result2);
                                                    break;
                                                default:
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }
                                    $continuation = new AnonymousClass1($completion);
                                    Object $result22 = $continuation.result;
                                    Object coroutine_suspended22 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch ($continuation.label) {
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                        });
                        final SpaceCheesePerLoadUiService spaceCheesePerLoadUiService22 = anonymousClass3.this$0;
                        anonymousClass3.L$0 = SpillingKt.nullOutSpilledVariable(pair);
                        anonymousClass3.I$0 = classifiedTypeId4;
                        anonymousClass3.I$1 = sortTypeId;
                        anonymousClass3.I$2 = classifiedTypeId3;
                        anonymousClass3.label = 4;
                        if ($this$filter$iv22.collect(new FlowCollector() { // from class: kntr.app.cheese.space.SpaceCheesePerLoadUiService.1.3.3
                            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                return emit(((Boolean) value).booleanValue(), $completion);
                            }

                            public final Object emit(boolean it, Continuation<? super Unit> continuation) {
                                Object loadMore$default = SpaceCheesePerLoadUiService.loadMore$default(SpaceCheesePerLoadUiService.this, classifiedTypeId4, sortTypeId, false, continuation, 4, null);
                                return loadMore$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? loadMore$default : Unit.INSTANCE;
                            }
                        }, (Continuation) anonymousClass3) == coroutine_suspended) {
                        }
                        break;
                    case 3:
                        int sortTypeId2 = this.I$2;
                        int sortTypeId3 = this.I$1;
                        int classifiedTypeId5 = this.I$0;
                        ResultKt.throwOnFailure($result);
                        anonymousClass3 = this;
                        sortTypeId = sortTypeId3;
                        classifiedTypeId4 = classifiedTypeId5;
                        classifiedTypeId3 = sortTypeId2;
                        while (true) {
                            if (anonymousClass3.this$0.items.size() < 5) {
                            }
                            classifiedTypeId3 = loadCount2;
                        }
                        final SpaceCheesePerLoadUiService spaceCheesePerLoadUiService32 = anonymousClass3.this$0;
                        final Flow $this$filter$iv32 = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.cheese.space.SpaceCheesePerLoadUiService$1$3$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                boolean invokeSuspend$lambda$0;
                                invokeSuspend$lambda$0 = SpaceCheesePerLoadUiService.AnonymousClass1.AnonymousClass3.invokeSuspend$lambda$0(SpaceCheesePerLoadUiService.this);
                                return Boolean.valueOf(invokeSuspend$lambda$0);
                            }
                        });
                        Flow $this$filter$iv222 = FlowKt.conflate(new Flow<Boolean>() { // from class: kntr.app.cheese.space.SpaceCheesePerLoadUiService$1$3$invokeSuspend$$inlined$filter$1
                            public Object collect(FlowCollector collector, Continuation $completion) {
                                Object collect = $this$filter$iv32.collect(new AnonymousClass2(collector), $completion);
                                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                            }

                            /* compiled from: Emitters.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                            /* renamed from: kntr.app.cheese.space.SpaceCheesePerLoadUiService$1$3$invokeSuspend$$inlined$filter$1$2  reason: invalid class name */
                            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                            public static final class AnonymousClass2<T> implements FlowCollector {
                                final /* synthetic */ FlowCollector $this_unsafeFlow;

                                /* compiled from: Emitters.kt */
                                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                                @DebugMetadata(c = "kntr.app.cheese.space.SpaceCheesePerLoadUiService$1$3$invokeSuspend$$inlined$filter$1$2", f = "SpaceCheesePerLoadUiService.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                                /* renamed from: kntr.app.cheese.space.SpaceCheesePerLoadUiService$1$3$invokeSuspend$$inlined$filter$1$2$1  reason: invalid class name */
                                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                                public static final class AnonymousClass1 extends ContinuationImpl {
                                    int I$0;
                                    Object L$0;
                                    Object L$1;
                                    Object L$2;
                                    Object L$3;
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
                                /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final Object emit(Object value, Continuation $completion) {
                                    Continuation $continuation;
                                    if ($completion instanceof AnonymousClass1) {
                                        $continuation = (AnonymousClass1) $completion;
                                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                                            $continuation.label -= Integer.MIN_VALUE;
                                            Object $result22 = $continuation.result;
                                            Object coroutine_suspended22 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            switch ($continuation.label) {
                                                case 0:
                                                    ResultKt.throwOnFailure($result22);
                                                    FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                                    AnonymousClass1 anonymousClass1 = $continuation;
                                                    boolean it = ((Boolean) value).booleanValue();
                                                    if (it) {
                                                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                                        $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                                        $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                                        $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$filter_u24lambda_u240);
                                                        $continuation.I$0 = 0;
                                                        $continuation.label = 1;
                                                        if ($this$filter_u24lambda_u240.emit(value, $continuation) != coroutine_suspended22) {
                                                            break;
                                                        } else {
                                                            return coroutine_suspended22;
                                                        }
                                                    }
                                                    break;
                                                case 1:
                                                    int i = $continuation.I$0;
                                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                                    Object obj = $continuation.L$2;
                                                    AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
                                                    Object value2 = $continuation.L$0;
                                                    ResultKt.throwOnFailure($result22);
                                                    break;
                                                default:
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }
                                    $continuation = new AnonymousClass1($completion);
                                    Object $result222 = $continuation.result;
                                    Object coroutine_suspended222 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch ($continuation.label) {
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                        });
                        final SpaceCheesePerLoadUiService spaceCheesePerLoadUiService222 = anonymousClass3.this$0;
                        anonymousClass3.L$0 = SpillingKt.nullOutSpilledVariable(pair);
                        anonymousClass3.I$0 = classifiedTypeId4;
                        anonymousClass3.I$1 = sortTypeId;
                        anonymousClass3.I$2 = classifiedTypeId3;
                        anonymousClass3.label = 4;
                        if ($this$filter$iv222.collect(new FlowCollector() { // from class: kntr.app.cheese.space.SpaceCheesePerLoadUiService.1.3.3
                            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                return emit(((Boolean) value).booleanValue(), $completion);
                            }

                            public final Object emit(boolean it, Continuation<? super Unit> continuation) {
                                Object loadMore$default = SpaceCheesePerLoadUiService.loadMore$default(SpaceCheesePerLoadUiService.this, classifiedTypeId4, sortTypeId, false, continuation, 4, null);
                                return loadMore$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? loadMore$default : Unit.INSTANCE;
                            }
                        }, (Continuation) anonymousClass3) == coroutine_suspended) {
                        }
                        break;
                    case 4:
                        int i = this.I$2;
                        int i2 = this.I$1;
                        int i3 = this.I$0;
                        ResultKt.throwOnFailure($result);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean invokeSuspend$lambda$0(SpaceCheesePerLoadUiService this$0) {
                LazyListItemInfo lastVisibleItem = (LazyListItemInfo) CollectionsKt.lastOrNull(this$0.listState.getLayoutInfo().getVisibleItemsInfo());
                return lastVisibleItem != null && lastVisibleItem.getIndex() >= this$0.listState.getLayoutInfo().getTotalItemsCount() + (-2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Pair invokeSuspend$lambda$1(SpaceCheesePerLoadUiService this$0) {
            return TuplesKt.to(this$0.classifiedTypeIdState.getValue(), this$0.sortTypeIdState.getValue());
        }
    }

    public final void Content(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-793654009);
        ComposerKt.sourceInformation($composer3, "C(Content)N(modifier)132@5502L135,132@5481L156,140@5748L711,137@5650L809:SpaceCheesePerLoadUiService.kt#mv22nr");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(this) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-793654009, $dirty2, -1, "kntr.app.cheese.space.SpaceCheesePerLoadUiService.Content (SpaceCheesePerLoadUiService.kt:131)");
            }
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1802678670, "CC(remember):SpaceCheesePerLoadUiService.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(this);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new SpaceCheesePerLoadUiService$Content$1$1(this, null);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer3, 6);
            LazyListState lazyListState = this.listState;
            ComposerKt.sourceInformationMarkerStart($composer3, 1802687118, "CC(remember):SpaceCheesePerLoadUiService.kt#9igjgp");
            boolean invalid$iv2 = $composer3.changedInstance(this);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.cheese.space.SpaceCheesePerLoadUiService$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        Unit Content$lambda$1$0;
                        Content$lambda$1$0 = SpaceCheesePerLoadUiService.Content$lambda$1$0(SpaceCheesePerLoadUiService.this, (LazyListScope) obj);
                        return Content$lambda$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            LazyDslKt.LazyColumn(modifier3, lazyListState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv2, $composer3, $dirty2 & 14, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.cheese.space.SpaceCheesePerLoadUiService$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$2;
                    Content$lambda$2 = SpaceCheesePerLoadUiService.Content$lambda$2(SpaceCheesePerLoadUiService.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$1$0(final SpaceCheesePerLoadUiService this$0, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        Iterable $this$forEach$iv = this$0.items;
        for (Object element$iv : $this$forEach$iv) {
            ItemEntry module = (ItemEntry) element$iv;
            if (module.getUi().getState() instanceof SeasonInfo) {
                final UiComposableLike item$iv = module.getUi();
                $this$LazyColumn.stickyHeader(item$iv.getKey(), item$iv.getContentType(), ComposableLambdaKt.composableLambdaInstance(-694940242, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.cheese.space.SpaceCheesePerLoadUiService$Content$lambda$1$0$0$$inlined$stickyHeaderComposableLike$1
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                        invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope $this$stickyHeader, int it, Composer $composer, int $changed) {
                        Intrinsics.checkNotNullParameter($this$stickyHeader, "$this$stickyHeader");
                        ComposerKt.sourceInformation($composer, "CN(it)60@1768L13:LazyLists.kt#vxw63z");
                        int $dirty = $changed;
                        if (($changed & 6) == 0) {
                            $dirty |= $composer.changed($this$stickyHeader) ? 4 : 2;
                        }
                        if (!$composer.shouldExecute(($dirty & 131) != 130, $dirty & 1)) {
                            $composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-694940242, $dirty, -1, "kntr.common.komponent.stickyHeaderComposableLike.<anonymous> (LazyLists.kt:60)");
                        }
                        UiComposableLike it2 = item$iv;
                        $composer.startReplaceGroup(1467097179);
                        ComposerKt.sourceInformation($composer, "CN(it)*143@5913L27:SpaceCheesePerLoadUiService.kt#mv22nr");
                        it2.invoke(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, ($dirty & 14 & 112) | 6);
                        $composer.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
            } else {
                final UiComposableLike item$iv2 = module.getUi();
                $this$LazyColumn.item(item$iv2.getKey(), item$iv2.getContentType(), ComposableLambdaKt.composableLambdaInstance(-253424457, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: kntr.app.cheese.space.SpaceCheesePerLoadUiService$Content$lambda$1$0$0$$inlined$itemComposableLike$1
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                        invoke((LazyItemScope) p1, (Composer) p2, ((Number) p3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope $this$item, Composer $composer, int $changed) {
                        Intrinsics.checkNotNullParameter($this$item, "$this$item");
                        ComposerKt.sourceInformation($composer, "C12@472L13:LazyLists.kt#vxw63z");
                        int $dirty = $changed;
                        if (($changed & 6) == 0) {
                            $dirty |= $composer.changed($this$item) ? 4 : 2;
                        }
                        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
                            $composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-253424457, $dirty, -1, "kntr.common.komponent.itemComposableLike.<anonymous> (LazyLists.kt:12)");
                        }
                        UiComposableLike it = item$iv2;
                        $composer.startReplaceGroup(1463936213);
                        ComposerKt.sourceInformation($composer, "CN(it)*145@6028L27:SpaceCheesePerLoadUiService.kt#mv22nr");
                        it.invoke(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, ($dirty & 14 & 112) | 6);
                        $composer.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
            }
        }
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1239656540, true, new Function3() { // from class: kntr.app.cheese.space.SpaceCheesePerLoadUiService$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit Content$lambda$1$0$1;
                Content$lambda$1$0$1 = SpaceCheesePerLoadUiService.Content$lambda$1$0$1(SpaceCheesePerLoadUiService.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return Content$lambda$1$0$1;
            }
        }), 3, (Object) null);
        if (this$0.items.size() < 10) {
            LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(188306999, true, new Function3() { // from class: kntr.app.cheese.space.SpaceCheesePerLoadUiService$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit Content$lambda$1$0$2;
                    Content$lambda$1$0$2 = SpaceCheesePerLoadUiService.Content$lambda$1$0$2(SpaceCheesePerLoadUiService.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return Content$lambda$1$0$2;
                }
            }), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$1$0$1(SpaceCheesePerLoadUiService this$0, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C149@6141L53:SpaceCheesePerLoadUiService.kt#mv22nr");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1239656540, $changed, -1, "kntr.app.cheese.space.SpaceCheesePerLoadUiService.Content.<anonymous>.<anonymous>.<anonymous> (SpaceCheesePerLoadUiService.kt:149)");
            }
            LoadMoreUiKt.LoadMoreUi(this$0.getMoreLoadingState(), SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$1$0$2(SpaceCheesePerLoadUiService this$0, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C153@6316L89:SpaceCheesePerLoadUiService.kt#mv22nr");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(188306999, $changed, -1, "kntr.app.cheese.space.SpaceCheesePerLoadUiService.Content.<anonymous>.<anonymous>.<anonymous> (SpaceCheesePerLoadUiService.kt:153)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            int $this$dp$iv = (10 - this$0.items.size()) * 92;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(fillMaxWidth$default, Dp.constructor-impl(Math.max(Dp.constructor-impl($this$dp$iv), Dp.constructor-impl(0)))), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadMore(int classifiedTypeId, int sortTypeId, boolean isAppend, Continuation<? super Unit> continuation) {
        SpaceCheesePerLoadUiService$loadMore$1 spaceCheesePerLoadUiService$loadMore$1;
        Object requestSpaceCourseSortedData;
        int classifiedTypeId2;
        int sortTypeId2;
        Object obj;
        boolean isAppend2;
        KApiResponse.BusinessFailure businessFailure;
        if (continuation instanceof SpaceCheesePerLoadUiService$loadMore$1) {
            spaceCheesePerLoadUiService$loadMore$1 = (SpaceCheesePerLoadUiService$loadMore$1) continuation;
            if ((spaceCheesePerLoadUiService$loadMore$1.label & Integer.MIN_VALUE) != 0) {
                spaceCheesePerLoadUiService$loadMore$1.label -= Integer.MIN_VALUE;
                Object $result = spaceCheesePerLoadUiService$loadMore$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (spaceCheesePerLoadUiService$loadMore$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (getMoreLoadingState() != MoreLoadingState.NO_MORE && getMoreLoadingState() != MoreLoadingState.LOADING) {
                            setMoreLoadingState(MoreLoadingState.LOADING);
                            SpaceCheesePageApi spaceCheesePageApi = this.filmListHubChannelApi;
                            long j2 = this.upId;
                            String valueOf = String.valueOf(classifiedTypeId);
                            String valueOf2 = String.valueOf(sortTypeId);
                            int i = this.pageNum;
                            spaceCheesePerLoadUiService$loadMore$1.I$0 = classifiedTypeId;
                            spaceCheesePerLoadUiService$loadMore$1.I$1 = sortTypeId;
                            spaceCheesePerLoadUiService$loadMore$1.Z$0 = isAppend;
                            spaceCheesePerLoadUiService$loadMore$1.label = 1;
                            requestSpaceCourseSortedData = spaceCheesePageApi.requestSpaceCourseSortedData(j2, (r21 & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : valueOf, (r21 & 4) != 0 ? 0 : 0, valueOf2, (r21 & 16) != 0 ? 0 : 0, (r21 & 32) != 0 ? 0 : i, (r21 & 64) != 0 ? 10 : 0, spaceCheesePerLoadUiService$loadMore$1);
                            if (requestSpaceCourseSortedData != coroutine_suspended) {
                                classifiedTypeId2 = classifiedTypeId;
                                sortTypeId2 = sortTypeId;
                                obj = requestSpaceCourseSortedData;
                                isAppend2 = isAppend;
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        isAppend2 = spaceCheesePerLoadUiService$loadMore$1.Z$0;
                        sortTypeId2 = spaceCheesePerLoadUiService$loadMore$1.I$1;
                        classifiedTypeId2 = spaceCheesePerLoadUiService$loadMore$1.I$0;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                businessFailure = (KApiResponse) obj;
                if (!(businessFailure instanceof KApiResponse.BusinessFailure)) {
                    setMoreLoadingState(MoreLoadingState.ERROR);
                } else if (businessFailure instanceof KApiResponse.ServiceUnavailable) {
                    ((KApiResponse.ServiceUnavailable) businessFailure).getException();
                    setMoreLoadingState(MoreLoadingState.ERROR);
                    KomponentScope $this$loadMore_u24lambda_u242_u240 = this.komponentScope;
                    Toaster.-CC.showToast$default((Toaster) $this$loadMore_u24lambda_u242_u240.getCurrent(LocalToasterKt.getLocalToaster()), "似乎已断开与互联网的连接", (ToastDuration) null, 2, (Object) null);
                } else if (!(businessFailure instanceof KApiResponse.Success)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    SeasonFeed pageModule = (SeasonFeed) ((KApiResponse.Success) businessFailure).getData();
                    int i2 = 1;
                    this.pageNum = pageModule.getPage().getNum() + 1;
                    Iterable $this$mapIndexed$iv = pageModule.getItems();
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                    int index$iv$iv = 0;
                    for (Object item$iv$iv : $this$mapIndexed$iv) {
                        int index$iv$iv2 = index$iv$iv + 1;
                        if (index$iv$iv < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        SeasonModel item = (SeasonModel) item$iv$iv;
                        int index = index$iv$iv;
                        KApiResponse.BusinessFailure businessFailure2 = businessFailure;
                        KomponentHostScope scope = KomponentHostScope.-CC.__sub$default(this.komponentScope, (Function1) null, i2, (Object) null);
                        destination$iv$iv.add(new ItemEntry(KomponentHostScope.-CC.embed$default(scope, this.createCheeseFeedKomponent.invoke(item, index, getCurrentTabName()), (Function1) null, 2, (Object) null), scope));
                        index$iv$iv = index$iv$iv2;
                        businessFailure = businessFailure2;
                        spaceCheesePerLoadUiService$loadMore$1 = spaceCheesePerLoadUiService$loadMore$1;
                        sortTypeId2 = sortTypeId2;
                        classifiedTypeId2 = classifiedTypeId2;
                        i2 = 1;
                    }
                    List newItems = (List) destination$iv$iv;
                    if (isAppend2) {
                        Boxing.boxBoolean(this.items.addAll(newItems));
                    } else {
                        List $this$loadMore_u24lambda_u240_u241 = this.items.subList(this.topModuleCount, this.items.size());
                        $this$loadMore_u24lambda_u240_u241.clear();
                        $this$loadMore_u24lambda_u240_u241.addAll(newItems);
                    }
                    setMoreLoadingState(getMoreLoadingState(pageModule.getPage().getNext()));
                }
                return Unit.INSTANCE;
            }
        }
        spaceCheesePerLoadUiService$loadMore$1 = new SpaceCheesePerLoadUiService$loadMore$1(this, continuation);
        Object $result2 = spaceCheesePerLoadUiService$loadMore$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (spaceCheesePerLoadUiService$loadMore$1.label) {
        }
        businessFailure = (KApiResponse) obj;
        if (!(businessFailure instanceof KApiResponse.BusinessFailure)) {
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object loadMore$default(SpaceCheesePerLoadUiService spaceCheesePerLoadUiService, int i, int i2, boolean z, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = true;
        }
        return spaceCheesePerLoadUiService.loadMore(i, i2, z, continuation);
    }
}