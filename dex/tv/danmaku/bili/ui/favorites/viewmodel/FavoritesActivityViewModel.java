package tv.danmaku.bili.ui.favorites.viewmodel;

import android.content.SharedPreferences;
import androidx.lifecycle.ViewModelKt;
import com.bilibili.app.comm.list.widget.utils.SharedPreferencesField;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.lib.arch.lifecycle.Resource;
import com.bilibili.lib.arch.lifecycle.Status;
import com.bilibili.okretro.BaseResponse;
import com.bilibili.okretro.GeneralResponse;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.api.FavoritesApiManagerKt;
import tv.danmaku.bili.ui.favorites.model.FavoritesTabs;
import tv.danmaku.bili.ui.favorites.model.Tab;
import tv.danmaku.bili.ui.favorites.state.FavActivityState;
import tv.danmaku.bili.ui.favorites.state.FavPageState;
import tv.danmaku.bili.ui.favorites.state.FavoritesPageAction;
import tv.danmaku.bili.ui.favorites.state.FavoritesPageEvent;

/* compiled from: FavoritesActivityViewModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 .2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010)J\u0016\u0010*\u001a\u00020'2\u0006\u0010(\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010)J\b\u0010+\u001a\u00020\u0003H\u0014J\u0010\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020\u0002H\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u001e\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006/"}, d2 = {"Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesActivityViewModel;", "Ltv/danmaku/bili/ui/favorites/viewmodel/BaseFavoritesViewModel;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction;", "Ltv/danmaku/bili/ui/favorites/state/FavActivityState;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;", "<init>", "()V", "hasCleanedRedDot", "", "<set-?>", "", "curDefaultTabId", "getCurDefaultTabId", "()I", "setCurDefaultTabId", "(I)V", "curDefaultTabId$delegate", "Lcom/bilibili/app/comm/list/widget/utils/SharedPreferencesField;", "defaultTabId", "getDefaultTabId", "setDefaultTabId", "fromSpmid", "", "getFromSpmid", "()Ljava/lang/String;", "setFromSpmid", "(Ljava/lang/String;)V", "pageState", "Lkotlinx/coroutines/flow/Flow;", "Ltv/danmaku/bili/ui/favorites/state/FavPageState;", "getPageState", "()Lkotlinx/coroutines/flow/Flow;", "tabData", "Ltv/danmaku/bili/ui/favorites/model/FavoritesTabs;", "getTabData", "value", "isAddIcon", "()Z", "requestCollectionTabs", "", "tabId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanFollowRedDot", "initUiState", "onAction", "action", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesActivityViewModel extends BaseFavoritesViewModel<FavoritesPageAction, FavActivityState, FavoritesPageEvent> {
    public static final String TAG = "FavoritesActivityViewModel";
    private final SharedPreferencesField curDefaultTabId$delegate = new SharedPreferencesField("sp_favorites_default_tab", 0, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);
    private int defaultTabId = -1;
    private String fromSpmid = "";
    private boolean hasCleanedRedDot;
    private boolean isAddIcon;
    private final Flow<FavPageState> pageState;
    private final Flow<FavoritesTabs> tabData;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(FavoritesActivityViewModel.class, "curDefaultTabId", "getCurDefaultTabId()I", 0))};
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public FavoritesActivityViewModel() {
        final Flow $this$map$iv = getUiStateFlow();
        this.pageState = FlowKt.distinctUntilChanged(new Flow<FavPageState>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$special$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$special$$inlined$map$1$2", f = "FavoritesActivityViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$special$$inlined$map$1$2$1  reason: invalid class name */
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
                                    FavActivityState it = (FavActivityState) value;
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
                Object collect = $this$map$iv.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        });
        final Flow $this$map$iv2 = getUiStateFlow();
        this.tabData = FlowKt.distinctUntilChanged(new Flow<FavoritesTabs>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$special$$inlined$map$2

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$special$$inlined$map$2$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$special$$inlined$map$2$2", f = "FavoritesActivityViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$special$$inlined$map$2$2$1  reason: invalid class name */
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
                                    FavActivityState it = (FavActivityState) value;
                                    FavoritesTabs tabs = it.getTabs();
                                    $continuation.label = 1;
                                    if (flowCollector.emit(tabs, $continuation) != coroutine_suspended) {
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
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    public final int getCurDefaultTabId() {
        return ((Number) this.curDefaultTabId$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public final void setCurDefaultTabId(int i) {
        this.curDefaultTabId$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i));
    }

    public final int getDefaultTabId() {
        return this.defaultTabId;
    }

    public final void setDefaultTabId(int i) {
        this.defaultTabId = i;
    }

    public final String getFromSpmid() {
        return this.fromSpmid;
    }

    public final void setFromSpmid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fromSpmid = str;
    }

    public final Flow<FavPageState> getPageState() {
        return this.pageState;
    }

    public final Flow<FavoritesTabs> getTabData() {
        return this.tabData;
    }

    public final boolean isAddIcon() {
        return this.isAddIcon;
    }

    /* compiled from: FavoritesActivityViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$1", f = "FavoritesActivityViewModel.kt", i = {}, l = {BR.bgBarDrawable}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
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
                    SharedFlow<FavoritesPageEvent> uiEventFlow = FavoritesActivityViewModel.this.getUiEventFlow();
                    final FavoritesActivityViewModel favoritesActivityViewModel = FavoritesActivityViewModel.this;
                    this.label = 1;
                    if (uiEventFlow.collect(new FlowCollector() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel.1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((FavoritesPageEvent) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(FavoritesPageEvent it, Continuation<? super Unit> continuation) {
                            boolean isAddIcon;
                            FavoritesActivityViewModel favoritesActivityViewModel2 = FavoritesActivityViewModel.this;
                            if (Intrinsics.areEqual(it, FavoritesPageEvent.ShowAddFolderIcon.INSTANCE)) {
                                isAddIcon = true;
                            } else {
                                isAddIcon = Intrinsics.areEqual(it, FavoritesPageEvent.ShowBatchManageIcon.INSTANCE) ? false : FavoritesActivityViewModel.this.isAddIcon();
                            }
                            favoritesActivityViewModel2.isAddIcon = isAddIcon;
                            return Unit.INSTANCE;
                        }
                    }, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object requestCollectionTabs(int tabId, Continuation<? super Unit> continuation) {
        FavoritesActivityViewModel$requestCollectionTabs$1 favoritesActivityViewModel$requestCollectionTabs$1;
        FavoritesActivityViewModel favoritesActivityViewModel;
        Object favoritesTabs;
        Resource $this$then$iv;
        if (continuation instanceof FavoritesActivityViewModel$requestCollectionTabs$1) {
            favoritesActivityViewModel$requestCollectionTabs$1 = (FavoritesActivityViewModel$requestCollectionTabs$1) continuation;
            if ((favoritesActivityViewModel$requestCollectionTabs$1.label & Integer.MIN_VALUE) != 0) {
                favoritesActivityViewModel$requestCollectionTabs$1.label -= Integer.MIN_VALUE;
                Object $result = favoritesActivityViewModel$requestCollectionTabs$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                boolean z = true;
                switch (favoritesActivityViewModel$requestCollectionTabs$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        favoritesActivityViewModel = this;
                        favoritesActivityViewModel$requestCollectionTabs$1.label = 1;
                        favoritesTabs = FavoritesApiManagerKt.getFavoritesTabs(tabId, favoritesActivityViewModel$requestCollectionTabs$1);
                        if (favoritesTabs == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        favoritesActivityViewModel = this;
                        favoritesTabs = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                $this$then$iv = (Resource) favoritesTabs;
                if ($this$then$iv.getStatus() == Status.SUCCESS) {
                    final FavoritesTabs tabs = (FavoritesTabs) $this$then$iv.getData();
                    if (tabs != null) {
                        List<Tab> tabs2 = tabs.getTabs();
                        if (tabs2 != null && !tabs2.isEmpty()) {
                            z = false;
                        }
                        if (!z) {
                            favoritesActivityViewModel.updateState(new Function1<FavActivityState, FavActivityState>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$requestCollectionTabs$2$2
                                public final FavActivityState invoke(FavActivityState $this$updateState) {
                                    Intrinsics.checkNotNullParameter($this$updateState, "$this$updateState");
                                    return FavActivityState.copy$default($this$updateState, FavPageState.Success.INSTANCE, false, FavoritesTabs.this, 2, null);
                                }
                            });
                        }
                    }
                    favoritesActivityViewModel.updateState(new Function1<FavActivityState, FavActivityState>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$requestCollectionTabs$2$1
                        public final FavActivityState invoke(FavActivityState $this$updateState) {
                            Intrinsics.checkNotNullParameter($this$updateState, "$this$updateState");
                            return FavActivityState.copy$default($this$updateState, FavPageState.OtherError.INSTANCE, false, null, 6, null);
                        }
                    });
                }
                if ($this$then$iv.getStatus() == Status.ERROR && $this$then$iv.getError() != null) {
                    Throwable it = $this$then$iv.getError();
                    Intrinsics.checkNotNull(it);
                    BLog.e(TAG, it.getMessage());
                    favoritesActivityViewModel.updateState(new Function1<FavActivityState, FavActivityState>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$requestCollectionTabs$3$1
                        public final FavActivityState invoke(FavActivityState $this$updateState) {
                            Intrinsics.checkNotNullParameter($this$updateState, "$this$updateState");
                            return FavActivityState.copy$default($this$updateState, ConnectivityMonitor.getInstance().isNetworkActive() ? FavPageState.OtherError.INSTANCE : FavPageState.NetworkError.INSTANCE, false, null, 6, null);
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        }
        favoritesActivityViewModel$requestCollectionTabs$1 = new FavoritesActivityViewModel$requestCollectionTabs$1(this, continuation);
        Object $result2 = favoritesActivityViewModel$requestCollectionTabs$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z2 = true;
        switch (favoritesActivityViewModel$requestCollectionTabs$1.label) {
        }
        $this$then$iv = (Resource) favoritesTabs;
        if ($this$then$iv.getStatus() == Status.SUCCESS) {
        }
        if ($this$then$iv.getStatus() == Status.ERROR) {
            Throwable it2 = $this$then$iv.getError();
            Intrinsics.checkNotNull(it2);
            BLog.e(TAG, it2.getMessage());
            favoritesActivityViewModel.updateState(new Function1<FavActivityState, FavActivityState>() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$requestCollectionTabs$3$1
                public final FavActivityState invoke(FavActivityState $this$updateState) {
                    Intrinsics.checkNotNullParameter($this$updateState, "$this$updateState");
                    return FavActivityState.copy$default($this$updateState, ConnectivityMonitor.getInstance().isNetworkActive() ? FavPageState.OtherError.INSTANCE : FavPageState.NetworkError.INSTANCE, false, null, 6, null);
                }
            });
        }
        return Unit.INSTANCE;
    }

    public final Object cleanFollowRedDot(int tabId, Continuation<? super Unit> continuation) {
        BLog.d(TAG, "clean red dot");
        if (this.hasCleanedRedDot) {
            return Unit.INSTANCE;
        }
        this.hasCleanedRedDot = true;
        Object collect = FlowKt.catch(FlowKt.flow(new FavoritesActivityViewModel$cleanFollowRedDot$2(tabId, null)), new FavoritesActivityViewModel$cleanFollowRedDot$3(null)).collect(new FlowCollector() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$cleanFollowRedDot$4
            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                return emit((GeneralResponse) value, (Continuation<? super Unit>) $completion);
            }

            public final Object emit(GeneralResponse<BaseResponse> generalResponse, Continuation<? super Unit> continuation2) {
                boolean z = false;
                if (generalResponse != null && generalResponse.isSuccess()) {
                    z = true;
                }
                if (z) {
                    BLog.i(FavoritesActivityViewModel.TAG, "follow tab clean RedDot success");
                } else {
                    BLog.i(FavoritesActivityViewModel.TAG, "follow tab clean RedDot fail");
                }
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* compiled from: FavoritesActivityViewModel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesActivityViewModel$Companion;", "", "<init>", "()V", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // tv.danmaku.bili.ui.favorites.viewmodel.BaseFavoritesViewModel
    public FavActivityState initUiState() {
        return new FavActivityState(null, false, null, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.favorites.viewmodel.BaseFavoritesViewModel
    public void onAction(FavoritesPageAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new FavoritesActivityViewModel$onAction$1(action, this, null), 3, (Object) null);
    }
}