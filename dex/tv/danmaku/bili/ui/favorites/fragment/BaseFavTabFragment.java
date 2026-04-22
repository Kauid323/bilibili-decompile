package tv.danmaku.bili.ui.favorites.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.app.comm.list.widget.statement.ErrorState;
import com.bilibili.app.comm.list.widget.statement.PlaceHolderState;
import com.bilibili.app.comm.list.widget.statement.StatePageKt;
import com.bilibili.app.comm.list.widget.text.MessageString;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.base.viewbinding.ViewBindingProperty;
import com.bilibili.base.viewbinding.full.CreateMethod;
import com.bilibili.base.viewbinding.full.ReflectionFragmentViewBindings;
import com.bilibili.base.viewbinding.internal.UtilsKt;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.exposer.ExposeListener;
import com.bilibili.exposer.ListExposer;
import com.bilibili.lib.ui.BaseFragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.databinding.BiliAppFragmentFavoritesTabBinding;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.favorites.state.FavPageState;
import tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel;
import tv.danmaku.bili.ui.favorites.widget.InterceptRecyclerView;

/* compiled from: BaseFavTabFragment.kt */
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u001b\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020%H&J\b\u0010&\u001a\u00020\u001eH&J\b\u0010'\u001a\u00020\u001eH&J\u0018\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020!H\u0014J\u000e\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020-J\b\u0010.\u001a\u00020\u001eH\u0016J,\u0010+\u001a\u00020\u001e2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u000104J\u0006\u00105\u001a\u00020\u001eJ\u0006\u00106\u001a\u00020\u001eR\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001c¨\u00067"}, d2 = {"Ltv/danmaku/bili/ui/favorites/fragment/BaseFavTabFragment;", "Lcom/bilibili/lib/ui/BaseFragment;", "<init>", "()V", "tabId", "", "getTabId", "()I", "firstTabName", "", "getFirstTabName", "()Ljava/lang/String;", "secondTabName", "getSecondTabName", "binding", "Ltv/danmaku/bili/databinding/BiliAppFragmentFavoritesTabBinding;", "getBinding", "()Ltv/danmaku/bili/databinding/BiliAppFragmentFavoritesTabBinding;", "binding$delegate", "Lcom/bilibili/base/viewbinding/ViewBindingProperty;", "activityVM", "Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesActivityViewModel;", "getActivityVM", "()Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesActivityViewModel;", "activityVM$delegate", "Lkotlin/Lazy;", "exposeListener", "tv/danmaku/bili/ui/favorites/fragment/BaseFavTabFragment$exposeListener$1", "Ltv/danmaku/bili/ui/favorites/fragment/BaseFavTabFragment$exposeListener$1;", "onResume", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "shouldInitOnResume", "", "firstInitPage", "onRetryClick", "onCardExposed", "position", "itemView", "showErrorView", "pageState", "Ltv/danmaku/bili/ui/favorites/state/FavPageState;", "onCleanInvalidClick", "placeState", "Lcom/bilibili/app/comm/list/widget/statement/PlaceHolderState;", AuthResultCbHelper.ARGS_STATE, "Lcom/bilibili/app/comm/list/widget/statement/ErrorState;", "clickInvoker", "Lkotlin/Function0;", "hideErrorView", "cleanInvalid", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class BaseFavTabFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(BaseFavTabFragment.class, "binding", "getBinding()Ltv/danmaku/bili/databinding/BiliAppFragmentFavoritesTabBinding;", 0))};
    public static final int $stable = 8;
    private final Lazy activityVM$delegate;
    private final ViewBindingProperty binding$delegate;
    private final BaseFavTabFragment$exposeListener$1 exposeListener;

    public abstract void firstInitPage();

    public abstract void onRetryClick();

    public abstract boolean shouldInitOnResume();

    /* JADX WARN: Type inference failed for: r0v5, types: [tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment$exposeListener$1] */
    public BaseFavTabFragment() {
        Fragment $this$viewBinding_u24default$iv = (Fragment) this;
        CreateMethod createMethod$iv = CreateMethod.INFLATE;
        Function1 onViewDestroyed$iv = UtilsKt.emptyVbCallback();
        this.binding$delegate = ReflectionFragmentViewBindings.viewBindingFragment($this$viewBinding_u24default$iv, BiliAppFragmentFavoritesTabBinding.class, createMethod$iv, onViewDestroyed$iv);
        final Fragment $this$activityViewModels_u24default$iv = (Fragment) this;
        this.activityVM$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$activityViewModels_u24default$iv, Reflection.getOrCreateKotlinClass(FavoritesActivityViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m1621invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m1622invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r2;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment$special$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelProvider.Factory m1623invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        this.exposeListener = new ExposeListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment$exposeListener$1
            public /* synthetic */ void onExposeEnd(int i, View view) {
                ExposeListener.-CC.$default$onExposeEnd(this, i, view);
            }

            public /* synthetic */ void onExposeStart(int i, View view) {
                ExposeListener.-CC.$default$onExposeStart(this, i, view);
            }

            public void onExpose(int position, View itemView) {
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                BaseFavTabFragment.this.onCardExposed(position, itemView);
            }
        };
    }

    public final int getTabId() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getInt(FavoritesConstsKt.KEY_FAV_TAB_ID, 0);
        }
        return 0;
    }

    public final String getFirstTabName() {
        String string;
        Bundle arguments = getArguments();
        return (arguments == null || (string = arguments.getString("tab_name", "")) == null) ? "" : string;
    }

    public final String getSecondTabName() {
        String string;
        Bundle arguments = getArguments();
        return (arguments == null || (string = arguments.getString("second_tab_name", "")) == null) ? "" : string;
    }

    public final BiliAppFragmentFavoritesTabBinding getBinding() {
        return (BiliAppFragmentFavoritesTabBinding) this.binding$delegate.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FavoritesActivityViewModel getActivityVM() {
        return (FavoritesActivityViewModel) this.activityVM$delegate.getValue();
    }

    public void onResume() {
        super.onResume();
        if (shouldInitOnResume()) {
            firstInitPage();
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        BiliAppFragmentFavoritesTabBinding $this$onViewCreated_u24lambda_u240 = getBinding();
        $this$onViewCreated_u24lambda_u240.swipeLayout.setColorSchemeResources(new int[]{R.color.theme_color_secondary});
        ListExposer.Companion companion = ListExposer.Companion;
        InterceptRecyclerView interceptRecyclerView = $this$onViewCreated_u24lambda_u240.recyclerView;
        Intrinsics.checkNotNullExpressionValue(interceptRecyclerView, "recyclerView");
        companion.with(interceptRecyclerView).setExposeListener(this.exposeListener).build();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCardExposed(int position, View itemView) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    public final void showErrorView(FavPageState pageState) {
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        if (!Intrinsics.areEqual(pageState, FavPageState.Empty.INSTANCE)) {
            if (!Intrinsics.areEqual(pageState, FavPageState.Init.INSTANCE)) {
                if (!Intrinsics.areEqual(pageState, FavPageState.Loading.INSTANCE)) {
                    if (Intrinsics.areEqual(pageState, FavPageState.NetworkError.INSTANCE)) {
                        showErrorView$default(this, null, new ErrorState.NetworkError(0, (MessageString) null, new MessageString.ResourceString(bili.resource.common.R.string.common_global_string_16), new MessageString.ResourceString(bili.resource.common.R.string.common_global_string_213), false, 19, (DefaultConstructorMarker) null), null, 5, null);
                        return;
                    } else if (Intrinsics.areEqual(pageState, FavPageState.OtherError.INSTANCE)) {
                        showErrorView$default(this, null, new ErrorState.OtherError(0, (MessageString) null, new MessageString.ResourceString(bili.resource.common.R.string.common_global_string_164), new MessageString.ResourceString(bili.resource.common.R.string.common_global_string_213), false, 19, (DefaultConstructorMarker) null), null, 5, null);
                        return;
                    } else if (Intrinsics.areEqual(pageState, FavPageState.CleanInvalid.INSTANCE)) {
                        showErrorView$default(this, null, new ErrorState.Empty(0, (MessageString) null, new MessageString.ResourceString(bili.resource.favorites.R.string.favorites_global_string_11), new MessageString.ResourceString(bili.resource.favorites.R.string.favorites_global_string_155), true, 3, (DefaultConstructorMarker) null), new BaseFavTabFragment$showErrorView$1(this), 1, null);
                        return;
                    } else if (!Intrinsics.areEqual(pageState, FavPageState.Success.INSTANCE)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        hideErrorView();
                        return;
                    }
                }
                showErrorView$default(this, PlaceHolderState.LoadingHolder.INSTANCE, null, null, 6, null);
                return;
            }
            return;
        }
        showErrorView$default(this, null, new ErrorState.Empty(0, (MessageString) null, (MessageString) null, (MessageString) null, false, 31, (DefaultConstructorMarker) null), null, 5, null);
    }

    public void onCleanInvalidClick() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showErrorView$default(BaseFavTabFragment baseFavTabFragment, PlaceHolderState placeHolderState, ErrorState errorState, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorView");
        }
        if ((i & 1) != 0) {
            placeHolderState = (PlaceHolderState) PlaceHolderState.ErrorHolder.INSTANCE;
        }
        if ((i & 2) != 0) {
            errorState = (ErrorState) new ErrorState.OtherError(0, (MessageString) null, (MessageString) null, (MessageString) null, false, 31, (DefaultConstructorMarker) null);
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        baseFavTabFragment.showErrorView(placeHolderState, errorState, function0);
    }

    public final void showErrorView(final PlaceHolderState placeState, final ErrorState state, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(placeState, "placeState");
        Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
        ListExtentionsKt.gone(getBinding().swipeLayout);
        ListExtentionsKt.visible(getBinding().errorView);
        getBinding().errorView.setContent(ComposableLambdaKt.composableLambdaInstance(1040644693, true, new Function2() { // from class: tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2) {
                Unit showErrorView$lambda$0;
                showErrorView$lambda$0 = BaseFavTabFragment.showErrorView$lambda$0(placeState, state, function0, this, (Composer) obj, ((Integer) obj2).intValue());
                return showErrorView$lambda$0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showErrorView$lambda$0(final PlaceHolderState $placeState, final ErrorState $state, final Function0 $clickInvoker, final BaseFavTabFragment this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C135@4929L173,135@4919L183:BaseFavTabFragment.kt#atjan2");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1040644693, $changed, -1, "tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment.showErrorView.<anonymous> (BaseFavTabFragment.kt:135)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-851449955, true, new Function2() { // from class: tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit showErrorView$lambda$0$0;
                    showErrorView$lambda$0$0 = BaseFavTabFragment.showErrorView$lambda$0$0($placeState, $state, $clickInvoker, this$0, (Composer) obj, ((Integer) obj2).intValue());
                    return showErrorView$lambda$0$0;
                }
            }, $composer, 54), $composer, (int) BR.negativeBtnVisible, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showErrorView$lambda$0$0(PlaceHolderState $placeState, ErrorState $state, final Function0 $clickInvoker, final BaseFavTabFragment this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C136@5008L80,136@4947L141:BaseFavTabFragment.kt#atjan2");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-851449955, $changed, -1, "tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment.showErrorView.<anonymous>.<anonymous> (BaseFavTabFragment.kt:136)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 2095349389, "CC(remember):BaseFavTabFragment.kt#9igjgp");
            boolean invalid$iv = $composer.changed($clickInvoker) | $composer.changedInstance(this$0);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit showErrorView$lambda$0$0$0$0;
                        showErrorView$lambda$0$0$0$0 = BaseFavTabFragment.showErrorView$lambda$0$0$0$0($clickInvoker, this$0);
                        return showErrorView$lambda$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            StatePageKt.StatePage($placeState, $state, (Function0) it$iv, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showErrorView$lambda$0$0$0$0(Function0 $clickInvoker, BaseFavTabFragment this$0) {
        if ($clickInvoker != null) {
            $clickInvoker.invoke();
        } else {
            this$0.onRetryClick();
        }
        return Unit.INSTANCE;
    }

    public final void hideErrorView() {
        ListExtentionsKt.visible(getBinding().swipeLayout);
        ListExtentionsKt.gone(getBinding().errorView);
    }

    public final void cleanInvalid() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new BaseFavTabFragment$cleanInvalid$1(this, null), 3, (Object) null);
    }
}