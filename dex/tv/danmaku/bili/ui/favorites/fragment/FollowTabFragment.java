package tv.danmaku.bili.ui.favorites.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.theme.R;
import com.bilibili.playset.widget.FavoritesDividerDecoration;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.databinding.BiliAppFragmentFavoritesTabBinding;
import tv.danmaku.bili.ui.favorites.adapter.FollowListAdapter;
import tv.danmaku.bili.ui.favorites.state.FollowAction;
import tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel;
import tv.danmaku.bili.ui.favorites.widget.InterceptRecyclerView;
import tv.danmaku.bili.widget.swiperefresh.SwipeRefreshLayout;

/* compiled from: FollowTabFragment.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000fH\u0014R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\""}, d2 = {"Ltv/danmaku/bili/ui/favorites/fragment/FollowTabFragment;", "Ltv/danmaku/bili/ui/favorites/fragment/BaseFavTabFragment;", "<init>", "()V", "viewModel", "Ltv/danmaku/bili/ui/favorites/viewmodel/FollowListViewModel;", "getViewModel", "()Ltv/danmaku/bili/ui/favorites/viewmodel/FollowListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "adapter", "Ltv/danmaku/bili/ui/favorites/adapter/FollowListAdapter;", "getAdapter", "()Ltv/danmaku/bili/ui/favorites/adapter/FollowListAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "firstInitPage", "onRetryClick", "shouldInitOnResume", "", "onCardExposed", "position", "", "itemView", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FollowTabFragment extends BaseFavTabFragment {
    public static final int DELETE = 0;
    public static final String TAG = "FollowTabFragment";
    private final FollowListAdapter adapter;
    private final Lazy viewModel$delegate;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public FollowTabFragment() {
        final Fragment $this$viewModels_u24default$iv = (Fragment) this;
        Function0 factoryProducer$iv = new Function0() { // from class: tv.danmaku.bili.ui.favorites.fragment.FollowTabFragment$$ExternalSyntheticLambda0
            public final Object invoke() {
                ViewModelProvider.Factory viewModel_delegate$lambda$0;
                viewModel_delegate$lambda$0 = FollowTabFragment.viewModel_delegate$lambda$0(FollowTabFragment.this);
                return viewModel_delegate$lambda$0;
            }
        };
        final Function0 ownerProducer$iv = new Function0<Fragment>() { // from class: tv.danmaku.bili.ui.favorites.fragment.FollowTabFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final Fragment m1665invoke() {
                return $this$viewModels_u24default$iv;
            }
        };
        final Lazy owner$delegate$iv = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: tv.danmaku.bili.ui.favorites.fragment.FollowTabFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStoreOwner m1666invoke() {
                return (ViewModelStoreOwner) ownerProducer$iv.invoke();
            }
        });
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$viewModels_u24default$iv, Reflection.getOrCreateKotlinClass(FollowListViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.ui.favorites.fragment.FollowTabFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m1667invoke() {
                return FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.ui.favorites.fragment.FollowTabFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m1668invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r2;
                if (function0 != null && (creationExtras = (CreationExtras) function0.invoke()) != null) {
                    return creationExtras;
                }
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory2 = hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory ? hasDefaultViewModelProviderFactory : null;
                return hasDefaultViewModelProviderFactory2 != null ? hasDefaultViewModelProviderFactory2.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, factoryProducer$iv);
        this.adapter = new FollowListAdapter(new FollowTabFragment$adapter$1(this));
    }

    public final FollowListViewModel getViewModel() {
        return (FollowListViewModel) this.viewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory viewModel_delegate$lambda$0(final FollowTabFragment this$0) {
        return new ViewModelProvider.Factory() { // from class: tv.danmaku.bili.ui.favorites.fragment.FollowTabFragment$viewModel$2$1
            public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                return ViewModelProvider.Factory.-CC.$default$create(this, cls, creationExtras);
            }

            public /* synthetic */ ViewModel create(KClass kClass, CreationExtras creationExtras) {
                return ViewModelProvider.Factory.-CC.$default$create(this, kClass, creationExtras);
            }

            public <T extends ViewModel> T create(Class<T> cls) {
                Intrinsics.checkNotNullParameter(cls, "modelClass");
                return new FollowListViewModel(FollowTabFragment.this.getTabId());
            }
        };
    }

    public final FollowListAdapter getAdapter() {
        return this.adapter;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        BiliAppFragmentFavoritesTabBinding $this$onViewCreated_u24lambda_u240 = getBinding();
        $this$onViewCreated_u24lambda_u240.recyclerView.setAdapter((RecyclerView.Adapter) this.adapter);
        RecyclerView.ItemAnimator itemAnimator = $this$onViewCreated_u24lambda_u240.recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(0L);
        }
        InterceptRecyclerView interceptRecyclerView = $this$onViewCreated_u24lambda_u240.recyclerView;
        Intrinsics.checkNotNullExpressionValue(interceptRecyclerView, "recyclerView");
        ListExtentionsKt.onReachBottom(interceptRecyclerView, 2, new Function0() { // from class: tv.danmaku.bili.ui.favorites.fragment.FollowTabFragment$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit onViewCreated$lambda$0$0;
                onViewCreated$lambda$0$0 = FollowTabFragment.onViewCreated$lambda$0$0(FollowTabFragment.this);
                return onViewCreated$lambda$0$0;
            }
        });
        InterceptRecyclerView interceptRecyclerView2 = $this$onViewCreated_u24lambda_u240.recyclerView;
        final int i = R.color.Ga2;
        final int px = ListExtentionsKt.toPx(0.5f);
        final int px2 = ListExtentionsKt.toPx(12);
        interceptRecyclerView2.addItemDecoration((RecyclerView.ItemDecoration) new FavoritesDividerDecoration(i, px, px2) { // from class: tv.danmaku.bili.ui.favorites.fragment.FollowTabFragment$onViewCreated$1$2
            protected boolean needDrawDivider(RecyclerView.ViewHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                return true;
            }
        });
        $this$onViewCreated_u24lambda_u240.swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FollowTabFragment$$ExternalSyntheticLambda2
            public final void onRefresh() {
                FollowTabFragment.onViewCreated$lambda$0$1(FollowTabFragment.this);
            }
        });
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new FollowTabFragment$onViewCreated$2(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), (CoroutineContext) null, (CoroutineStart) null, new FollowTabFragment$onViewCreated$3(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), (CoroutineContext) null, (CoroutineStart) null, new FollowTabFragment$onViewCreated$4(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner4), (CoroutineContext) null, (CoroutineStart) null, new FollowTabFragment$onViewCreated$5(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner5), (CoroutineContext) null, (CoroutineStart) null, new FollowTabFragment$onViewCreated$6(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$0(FollowTabFragment this$0) {
        this$0.getViewModel().sendAction(new FollowAction.Load(false));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$1(FollowTabFragment this$0) {
        this$0.getViewModel().sendAction(FollowAction.Refresh.INSTANCE);
    }

    @Override // tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment
    public void firstInitPage() {
        getViewModel().sendAction(new FollowAction.Load(true));
    }

    @Override // tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment
    public void onRetryClick() {
        getViewModel().sendAction(new FollowAction.Load(true));
    }

    @Override // tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment
    public boolean shouldInitOnResume() {
        return !getViewModel().getHasInitPage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment
    public void onCardExposed(int position, View itemView) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        if (!getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner).launchWhenCreated(new FollowTabFragment$onCardExposed$1(position, this, null));
    }

    /* compiled from: FollowTabFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/favorites/fragment/FollowTabFragment$Companion;", "", "<init>", "()V", "DELETE", "", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}