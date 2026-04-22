package tv.danmaku.bili.ui.favorites.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.list.common.widget.PromoToast;
import com.bilibili.app.comm.list.common.widget.bottomsheet.ListBottomSheetDialogV2;
import com.bilibili.app.comm.list.common.widget.bottomsheet.ListImageTitleItem;
import com.bilibili.app.comm.list.widget.scroll.AnyScrollLoadMoreScroller;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.theme.R;
import com.bilibili.playset.widget.FavoritesDividerDecoration;
import com.bilibili.playset.widget.favorite.FavSnackBarUtil;
import com.bilibili.playset.widget.favorite.FavoriteDialog;
import com.bilibili.playset.widget.favorite.IFavoriteDialogListener;
import com.bilibili.pvtracker.PageViewTracker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.databinding.BiliAppFragmentFavoritesTabBinding;
import tv.danmaku.bili.ui.favorites.adapter.FavoritesFooterAdapter;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;
import tv.danmaku.bili.ui.favorites.model.Upper;
import tv.danmaku.bili.ui.favorites.state.FavTabState;
import tv.danmaku.bili.ui.favorites.state.FavoritesAction;
import tv.danmaku.bili.ui.favorites.state.FavoritesEvent;
import tv.danmaku.bili.ui.favorites.state.FavoritesPageAction;
import tv.danmaku.bili.ui.favorites.util.FavReportHelperKt;
import tv.danmaku.bili.ui.favorites.util.FavRouterUtilsKt;
import tv.danmaku.bili.ui.favorites.util.FavoritesUtilsKt;
import tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel;
import tv.danmaku.bili.ui.favorites.widget.InterceptRecyclerView;
import tv.danmaku.bili.ui.watchlater.utils.WatchLaterRouterKt;
import tv.danmaku.bili.widget.dialog.BiliCommonDialog;
import tv.danmaku.bili.widget.dialog.CustomButtonInfo;
import tv.danmaku.bili.widget.swiperefresh.SwipeRefreshLayout;

/* compiled from: FavoritesTabFragment.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0018\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001bH\u0014J\u0010\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020.H\u0002J&\u0010/\u001a\u000200*\u0002012\b\b\u0001\u00102\u001a\u00020'2\b\b\u0001\u00103\u001a\u00020'H\u0082@¢\u0006\u0002\u00104J\b\u00105\u001a\u000200H\u0016J\b\u00106\u001a\u00020#H\u0016J\b\u00107\u001a\u00020#H\u0016J\b\u00108\u001a\u00020#H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006:"}, d2 = {"Ltv/danmaku/bili/ui/favorites/fragment/FavoritesTabFragment;", "Ltv/danmaku/bili/ui/favorites/fragment/BaseFavTabFragment;", "<init>", "()V", "viewModel", "Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesListViewModel;", "getViewModel", "()Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mAdapter", "Ltv/danmaku/bili/ui/favorites/adapter/FavoritesFooterAdapter;", "getMAdapter", "()Ltv/danmaku/bili/ui/favorites/adapter/FavoritesFooterAdapter;", "setMAdapter", "(Ltv/danmaku/bili/ui/favorites/adapter/FavoritesFooterAdapter;)V", "adapter", "getAdapter", "favoriteDialog", "Lcom/bilibili/playset/widget/favorite/FavoriteDialog;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onCardExposed", "position", "", "itemView", "showFavDialog", "event", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent;", "showInvalidCardDialog", "item", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "showBiliCommonDialog", "", "Landroid/content/Context;", ReportUtilKt.POS_TITLE, "positiveText", "(Landroid/content/Context;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldInitOnResume", "firstInitPage", "onRetryClick", "onCleanInvalidClick", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesTabFragment extends BaseFavTabFragment {
    private static final String TAG = "FavoritesTabFragment";
    private final FavoritesFooterAdapter adapter;
    private FavoriteDialog favoriteDialog;
    private final ActivityResultLauncher<Intent> launcher;
    private FavoritesFooterAdapter mAdapter;
    private final Lazy viewModel$delegate;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public FavoritesTabFragment() {
        final Fragment $this$viewModels_u24default$iv = (Fragment) this;
        Function0 factoryProducer$iv = new Function0() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$$ExternalSyntheticLambda12
            public final Object invoke() {
                ViewModelProvider.Factory viewModel_delegate$lambda$0;
                viewModel_delegate$lambda$0 = FavoritesTabFragment.viewModel_delegate$lambda$0(FavoritesTabFragment.this);
                return viewModel_delegate$lambda$0;
            }
        };
        final Function0 ownerProducer$iv = new Function0<Fragment>() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final Fragment m1649invoke() {
                return $this$viewModels_u24default$iv;
            }
        };
        final Lazy owner$delegate$iv = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStoreOwner m1650invoke() {
                return (ViewModelStoreOwner) ownerProducer$iv.invoke();
            }
        });
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$viewModels_u24default$iv, Reflection.getOrCreateKotlinClass(FavoritesListViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m1651invoke() {
                return FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m1652invoke() {
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
        this.adapter = new FavoritesFooterAdapter(new FavoritesTabFragment$adapter$1(this), new Function0() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$$ExternalSyntheticLambda13
            public final Object invoke() {
                Unit adapter$lambda$0;
                adapter$lambda$0 = FavoritesTabFragment.adapter$lambda$0(FavoritesTabFragment.this);
                return adapter$lambda$0;
            }
        });
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$$ExternalSyntheticLambda14
            public final void onActivityResult(Object obj) {
                FavoritesTabFragment.launcher$lambda$0(FavoritesTabFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.launcher = registerForActivityResult;
    }

    /* compiled from: FavoritesTabFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/favorites/fragment/FavoritesTabFragment$Companion;", "", "<init>", "()V", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final FavoritesListViewModel getViewModel() {
        return (FavoritesListViewModel) this.viewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory viewModel_delegate$lambda$0(final FavoritesTabFragment this$0) {
        return new ViewModelProvider.Factory() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$viewModel$2$1
            public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                return ViewModelProvider.Factory.-CC.$default$create(this, cls, creationExtras);
            }

            public /* synthetic */ ViewModel create(KClass kClass, CreationExtras creationExtras) {
                return ViewModelProvider.Factory.-CC.$default$create(this, kClass, creationExtras);
            }

            public <T extends ViewModel> T create(Class<T> cls) {
                Intrinsics.checkNotNullParameter(cls, "modelClass");
                return new FavoritesListViewModel(FavoritesTabFragment.this.getTabId());
            }
        };
    }

    public final FavoritesFooterAdapter getMAdapter() {
        return this.mAdapter;
    }

    public final void setMAdapter(FavoritesFooterAdapter favoritesFooterAdapter) {
        this.mAdapter = favoritesFooterAdapter;
    }

    public final FavoritesFooterAdapter getAdapter() {
        return this.adapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit adapter$lambda$0(FavoritesTabFragment this$0) {
        this$0.cleanInvalid();
        FavoritesFooterAdapter favoritesFooterAdapter = this$0.mAdapter;
        if (favoritesFooterAdapter != null) {
            favoritesFooterAdapter.showFooterGone();
        }
        return Unit.INSTANCE;
    }

    public final ActivityResultLauncher<Intent> getLauncher() {
        return this.launcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launcher$lambda$0(FavoritesTabFragment this$0, ActivityResult it) {
        FavoriteDialog favoriteDialog;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResultCode() != -1 || (favoriteDialog = this$0.favoriteDialog) == null) {
            return;
        }
        favoriteDialog.updateFavBoxList();
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
        final BiliAppFragmentFavoritesTabBinding $this$onViewCreated_u24lambda_u240 = getBinding();
        this.mAdapter = this.adapter;
        $this$onViewCreated_u24lambda_u240.recyclerView.setAdapter((RecyclerView.Adapter) this.adapter);
        $this$onViewCreated_u24lambda_u240.recyclerView.addOnScrollListener((RecyclerView.OnScrollListener) new AnyScrollLoadMoreScroller(new Function0() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit onViewCreated$lambda$0$0;
                onViewCreated$lambda$0$0 = FavoritesTabFragment.onViewCreated$lambda$0$0(FavoritesTabFragment.this);
                return onViewCreated$lambda$0$0;
            }
        }));
        InterceptRecyclerView interceptRecyclerView = $this$onViewCreated_u24lambda_u240.recyclerView;
        final int i = R.color.Ga2;
        final int px = ListExtentionsKt.toPx(0.5f);
        final int px2 = ListExtentionsKt.toPx(12);
        interceptRecyclerView.addItemDecoration((RecyclerView.ItemDecoration) new FavoritesDividerDecoration(i, px, px2) { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$onViewCreated$1$2
            protected boolean needDrawDivider(RecyclerView.ViewHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                return true;
            }
        });
        $this$onViewCreated_u24lambda_u240.swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$$ExternalSyntheticLambda6
            public final void onRefresh() {
                FavoritesTabFragment.onViewCreated$lambda$0$1(FavoritesTabFragment.this);
            }
        });
        boolean $this$onViewCreated_u24lambda_u240_u242 = getTabId() == 103;
        $this$onViewCreated_u24lambda_u240.move.setVisibility(ListExtentionsKt.toVisibility(!$this$onViewCreated_u24lambda_u240_u242));
        $this$onViewCreated_u24lambda_u240.copy.setVisibility(ListExtentionsKt.toVisibility($this$onViewCreated_u24lambda_u240_u242 ? false : true));
        $this$onViewCreated_u24lambda_u240.batchManageContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FavoritesTabFragment.onViewCreated$lambda$0$3(view2);
            }
        });
        View view2 = $this$onViewCreated_u24lambda_u240.move;
        Intrinsics.checkNotNullExpressionValue(view2, "move");
        ListExtentionsKt.addTouchDelegate(view2, ListExtentionsKt.toPx(5));
        View view3 = $this$onViewCreated_u24lambda_u240.copy;
        Intrinsics.checkNotNullExpressionValue(view3, "copy");
        ListExtentionsKt.addTouchDelegate(view3, ListExtentionsKt.toPx(5));
        $this$onViewCreated_u24lambda_u240.checkAllLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                FavoritesTabFragment.onViewCreated$lambda$0$4(FavoritesTabFragment.this, $this$onViewCreated_u24lambda_u240, view4);
            }
        });
        $this$onViewCreated_u24lambda_u240.delete.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                FavoritesTabFragment.onViewCreated$lambda$0$5(FavoritesTabFragment.this, view4);
            }
        });
        $this$onViewCreated_u24lambda_u240.move.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                FavoritesTabFragment.onViewCreated$lambda$0$6(FavoritesTabFragment.this, view4);
            }
        });
        $this$onViewCreated_u24lambda_u240.copy.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                FavoritesTabFragment.onViewCreated$lambda$0$7(FavoritesTabFragment.this, view4);
            }
        });
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new FavoritesTabFragment$onViewCreated$2(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), (CoroutineContext) null, (CoroutineStart) null, new FavoritesTabFragment$onViewCreated$3(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), (CoroutineContext) null, (CoroutineStart) null, new FavoritesTabFragment$onViewCreated$4(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner4), (CoroutineContext) null, (CoroutineStart) null, new FavoritesTabFragment$onViewCreated$5(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner5), (CoroutineContext) null, (CoroutineStart) null, new FavoritesTabFragment$onViewCreated$6(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner6), (CoroutineContext) null, (CoroutineStart) null, new FavoritesTabFragment$onViewCreated$7(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner7), (CoroutineContext) null, (CoroutineStart) null, new FavoritesTabFragment$onViewCreated$8(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner8 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner8, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner8), (CoroutineContext) null, (CoroutineStart) null, new FavoritesTabFragment$onViewCreated$9(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner9 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner9, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner9), (CoroutineContext) null, (CoroutineStart) null, new FavoritesTabFragment$onViewCreated$10(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner10 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner10, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner10), (CoroutineContext) null, (CoroutineStart) null, new FavoritesTabFragment$onViewCreated$11(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$0(FavoritesTabFragment this$0) {
        this$0.getViewModel().sendAction(new FavoritesAction.Load(false));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$1(FavoritesTabFragment this$0) {
        this$0.getViewModel().sendAction(FavoritesAction.Refresh.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$3(View it) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$4(FavoritesTabFragment this$0, BiliAppFragmentFavoritesTabBinding $this_run, View it) {
        this$0.adapter.notifyCheckAll(!$this_run.checkBox.isChecked());
        this$0.getViewModel().sendAction(FavoritesAction.CheckAll.INSTANCE);
        FavReportHelperKt.reportSecButtonClick(FavoritesConstsKt.BUTTON_NAME_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$5(FavoritesTabFragment this$0, View it) {
        this$0.getViewModel().sendAction(FavoritesAction.ClickDelete.INSTANCE);
        FavReportHelperKt.reportSecButtonClick(FavoritesConstsKt.BUTTON_NAME_DELETE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$6(FavoritesTabFragment this$0, View it) {
        this$0.getViewModel().sendAction(FavoritesAction.MoveTo.INSTANCE);
        FavReportHelperKt.reportSecButtonClick(FavoritesConstsKt.BUTTON_NAME_MOVE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$7(FavoritesTabFragment this$0, View it) {
        this$0.getViewModel().sendAction(FavoritesAction.CopyTo.INSTANCE);
        FavReportHelperKt.reportSecButtonClick(FavoritesConstsKt.BUTTON_NAME_COPY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment
    public void onCardExposed(int position, View itemView) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        BLog.i(TAG, "card exposed position:" + position);
        if (position < 0 || position >= ((FavTabState) getViewModel().getUiStateFlow().getValue()).getItemList().size()) {
            return;
        }
        FavoritesMediasItem item = (FavoritesMediasItem) ((FavTabState) getViewModel().getUiStateFlow().getValue()).getItemList().get(position);
        Pair[] pairArr = new Pair[9];
        pairArr[0] = TuplesKt.to("oid", String.valueOf(item.getOid()));
        pairArr[1] = TuplesKt.to(FavoritesConstsKt.FAV_TYPE, String.valueOf(item.getOtype()));
        pairArr[2] = TuplesKt.to("tab_name", getFirstTabName());
        pairArr[3] = TuplesKt.to("second_tab_name", getSecondTabName());
        pairArr[4] = TuplesKt.to(FavoritesConstsKt.IS_ACQUIESCE, FavoritesUtilsKt.toIsAcquiesce(getTabId(), getActivityVM().getDefaultTabId()));
        pairArr[5] = TuplesKt.to(FavoritesConstsKt.POS, String.valueOf(position + 1));
        pairArr[6] = TuplesKt.to("from_spmid", getActivityVM().getFromSpmid());
        pairArr[7] = TuplesKt.to(FavoritesConstsKt.USER_STATE, item.getUserStateStr());
        String currentPolarisActionId = PageViewTracker.getInstance().currentPolarisActionId();
        if (currentPolarisActionId == null) {
            currentPolarisActionId = "";
        }
        pairArr[8] = TuplesKt.to(FavoritesConstsKt.ACTION_ID, currentPolarisActionId);
        FavReportHelperKt.reportFavShow(FavoritesConstsKt.FAV_CONTENT_CARD_SHOW, MapsKt.mapOf(pairArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showFavDialog(final FavoritesEvent event) {
        String action;
        ComponentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (event instanceof FavoritesEvent.CopyTo) {
            action = "copy";
        } else {
            action = "move";
        }
        Iterable $this$filter$iv = ((FavTabState) getViewModel().getUiStateFlow().getValue()).getItemList();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (((FavoritesMediasItem) element$iv$iv).isChecked()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List checkedItems = (List) destination$iv$iv;
        List $this$filterNot$iv = checkedItems;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv2 : $this$filterNot$iv) {
            if (!(((FavoritesMediasItem) element$iv$iv2).getOtype() == 302)) {
                destination$iv$iv2.add(element$iv$iv2);
            }
        }
        List it = (List) destination$iv$iv2;
        if (it.isEmpty()) {
            PromoToast.showMidToast(getActivity(), "图文暂不支持移动到收藏夹");
            getActivityVM().sendAction(FavoritesPageAction.QuitBatchManage.INSTANCE);
            return;
        }
        String resources = CollectionsKt.joinToString$default(checkedItems, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                CharSequence showFavDialog$lambda$3;
                showFavDialog$lambda$3 = FavoritesTabFragment.showFavDialog$lambda$3((FavoritesMediasItem) obj);
                return showFavDialog$lambda$3;
            }
        }, 30, (Object) null);
        final boolean hasInvalid = it.size() < checkedItems.size();
        FavoriteDialog.ExtraParams extraParam = new FavoriteDialog.ExtraParams(0L, 0L, FavoriteDialog.BizType.UGC, true, (int) FavRouterUtilsKt.REQ_CODE_CREATE_FOLDER, true, false, false, MapsKt.emptyMap(), "", FavoritesConstsKt.BATCH_ADD_WATCH_LATER_SP_MID, getActivityVM().getFromSpmid(), FavSnackBarUtil.Scene.DetailPage, (Boolean) null, false, true, resources, action, (Long) null, 286720, (DefaultConstructorMarker) null);
        this.favoriteDialog = new FavoriteDialog(activity, extraParam, this.launcher);
        FavoriteDialog favoriteDialog = this.favoriteDialog;
        if (favoriteDialog != null) {
            favoriteDialog.setDialogListener(new IFavoriteDialogListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$showFavDialog$1
                public /* synthetic */ void onFavChanged(boolean z, boolean z2) {
                    IFavoriteDialogListener.-CC.$default$onFavChanged(this, z, z2);
                }

                public /* synthetic */ void onFavSeason(boolean z) {
                    IFavoriteDialogListener.-CC.$default$onFavSeason(this, z);
                }

                public /* synthetic */ void reportAddToFavBox(String str, String str2, String str3, String str4, Boolean bool) {
                    IFavoriteDialogListener.-CC.$default$reportAddToFavBox(this, str, str2, str3, str4, bool);
                }

                public /* synthetic */ void reportAddToFavBoxSeasonChecked(String str, String str2) {
                    IFavoriteDialogListener.-CC.$default$reportAddToFavBoxSeasonChecked(this, str, str2);
                }

                public /* synthetic */ void reportAddToWatchLater(Boolean bool) {
                    IFavoriteDialogListener.-CC.$default$reportAddToWatchLater(this, bool);
                }

                public /* synthetic */ void reportCreateFavBox() {
                    IFavoriteDialogListener.-CC.$default$reportCreateFavBox(this);
                }

                /* renamed from: showSnackBar-7SKmwc0  reason: not valid java name */
                public /* synthetic */ void m1657showSnackBar7SKmwc0(String str, int i, boolean z, String str2) {
                    IFavoriteDialogListener.-CC.$default$showSnackBar-7SKmwc0(this, str, i, z, str2);
                }

                public void onCommitChanged(boolean isCommitSuccess, String resultToast) {
                    String toast;
                    if (isCommitSuccess) {
                        if (resultToast != null) {
                            toast = resultToast;
                        } else if (hasInvalid && (event instanceof FavoritesEvent.CopyTo)) {
                            toast = "视频复制成功，图文暂不支持哦";
                        } else if (hasInvalid && (event instanceof FavoritesEvent.MoveTo)) {
                            toast = "视频移动成功，图文暂不支持哦";
                        } else if (event instanceof FavoritesEvent.CopyTo) {
                            toast = "视频复制成功";
                        } else {
                            toast = event instanceof FavoritesEvent.MoveTo ? "视频移动成功" : "操作成功";
                        }
                        PromoToast.showMidToast(this.getActivity(), toast);
                    }
                    this.getActivityVM().sendAction(FavoritesPageAction.QuitBatchManage.INSTANCE);
                }
            });
        }
        FavoriteDialog favoriteDialog2 = this.favoriteDialog;
        if (favoriteDialog2 != null) {
            favoriteDialog2.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence showFavDialog$lambda$3(FavoritesMediasItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String str = it.getOid() + ":" + it.getOtype();
        Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showInvalidCardDialog(final FavoritesMediasItem item) {
        List items = CollectionsKt.listOf(new ListImageTitleItem[]{new ListImageTitleItem(getString(bili.resource.favorites.R.string.favorites_global_string_179), (String) null, Integer.valueOf(com.bilibili.iconfont.R.drawable.ref_uploader_name_square_line_500), 0, R.color.Text1, true, 0, new Function0() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit showInvalidCardDialog$lambda$0;
                showInvalidCardDialog$lambda$0 = FavoritesTabFragment.showInvalidCardDialog$lambda$0(FavoritesMediasItem.this, this);
                return showInvalidCardDialog$lambda$0;
            }
        }, 74, (DefaultConstructorMarker) null), new ListImageTitleItem(getString(bili.resource.favorites.R.string.favorites_global_string_193), (String) null, Integer.valueOf(com.bilibili.iconfont.R.drawable.ref_magnifier_search_line_500), 0, R.color.Text1, true, 0, new Function0() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$$ExternalSyntheticLambda3
            public final Object invoke() {
                Unit showInvalidCardDialog$lambda$1;
                showInvalidCardDialog$lambda$1 = FavoritesTabFragment.showInvalidCardDialog$lambda$1(FavoritesMediasItem.this, this);
                return showInvalidCardDialog$lambda$1;
            }
        }, 74, (DefaultConstructorMarker) null), new ListImageTitleItem(getString(bili.resource.favorites.R.string.favorites_global_string_192), (String) null, Integer.valueOf(com.bilibili.playset.R.drawable.ic_brush_clear_line), 0, R.color.Text1, false, 0, new Function0() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$$ExternalSyntheticLambda4
            public final Object invoke() {
                Unit showInvalidCardDialog$lambda$2;
                showInvalidCardDialog$lambda$2 = FavoritesTabFragment.showInvalidCardDialog$lambda$2(FavoritesTabFragment.this, item);
                return showInvalidCardDialog$lambda$2;
            }
        }, (int) BR.config, (DefaultConstructorMarker) null), new ListImageTitleItem(getString(bili.resource.favorites.R.string.favorites_global_string_196), (String) null, Integer.valueOf(com.bilibili.playset.R.drawable.ic_brush_clear_line), 0, R.color.Text1, false, 0, new Function0() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$$ExternalSyntheticLambda5
            public final Object invoke() {
                Unit showInvalidCardDialog$lambda$3;
                showInvalidCardDialog$lambda$3 = FavoritesTabFragment.showInvalidCardDialog$lambda$3(FavoritesTabFragment.this, item);
                return showInvalidCardDialog$lambda$3;
            }
        }, (int) BR.config, (DefaultConstructorMarker) null)});
        ListBottomSheetDialogV2 newInstance = ListBottomSheetDialogV2.Companion.newInstance();
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        ListBottomSheetDialogV2.show$default(newInstance, childFragmentManager, getString(bili.resource.favorites.R.string.favorites_global_string_184), items, (Function0) null, "favorites_tab_invalid_card", 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showInvalidCardDialog$lambda$0(FavoritesMediasItem $item, FavoritesTabFragment this$0) {
        Upper it = $item.getUpper();
        if (it != null) {
            String jumpLink = it.getJumpLink();
            if (!(jumpLink == null || StringsKt.isBlank(jumpLink))) {
                WatchLaterRouterKt.routerTo$default(it.getJumpLink(), this$0.getApplicationContext(), (Map) null, 4, (Object) null);
            }
        }
        FavReportHelperKt.reportClickClearInvalidPanel(FavoritesConstsKt.CLEAR_INVALID_UP, FavoritesConstsKt.FAV_FROM_SPMID);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showInvalidCardDialog$lambda$1(FavoritesMediasItem $item, FavoritesTabFragment this$0) {
        String url = "bilibili://search?keyword=" + Uri.encode($item.getTitle());
        WatchLaterRouterKt.routerTo$default(url, this$0.getContext(), (Map) null, 4, (Object) null);
        FavReportHelperKt.reportClickClearInvalidPanel("search", FavoritesConstsKt.FAV_FROM_SPMID);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showInvalidCardDialog$lambda$2(FavoritesTabFragment this$0, FavoritesMediasItem $item) {
        this$0.getViewModel().sendAction(new FavoritesAction.ClearInvalidVideo($item));
        FavReportHelperKt.reportClickClearInvalidPanel(FavoritesConstsKt.CLEAR_INVALID_CLEAR, FavoritesConstsKt.FAV_FROM_SPMID);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showInvalidCardDialog$lambda$3(FavoritesTabFragment this$0, FavoritesMediasItem $item) {
        this$0.getViewModel().sendAction(new FavoritesAction.ClearAllInvalidVideo($item));
        FavReportHelperKt.reportClickClearInvalidPanel(FavoritesConstsKt.CLEAR_INVALID_CLEAR_ALL, FavoritesConstsKt.FAV_FROM_SPMID);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object showBiliCommonDialog(Context $this$showBiliCommonDialog, int title, int positiveText, Continuation<? super Boolean> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation it = cancellableContinuationImpl;
        BiliCommonDialog.Builder builder = BiliCommonDialog.Builder.setPositiveButton$default(BiliCommonDialog.Builder.setNegativeButton$default(new BiliCommonDialog.Builder($this$showBiliCommonDialog).setTitle(title), bili.resource.common.R.string.common_global_string_238, new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$showBiliCommonDialog$2$builder$1
            public final void onDialogTextClicked(View view, BiliCommonDialog biliCommonDialog) {
                Intrinsics.checkNotNullParameter(view, "<unused var>");
                Intrinsics.checkNotNullParameter(biliCommonDialog, "<unused var>");
                Result.Companion companion = Result.Companion;
                it.resumeWith(Result.constructor-impl(false));
            }
        }, true, (CustomButtonInfo) null, 8, (Object) null), positiveText, new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$showBiliCommonDialog$2$builder$2
            public final void onDialogTextClicked(View view, BiliCommonDialog biliCommonDialog) {
                Intrinsics.checkNotNullParameter(view, "<unused var>");
                Intrinsics.checkNotNullParameter(biliCommonDialog, "<unused var>");
                Result.Companion companion = Result.Companion;
                it.resumeWith(Result.constructor-impl(true));
            }
        }, true, (CustomButtonInfo) null, 8, (Object) null).setTitleColorRes(R.color.Text1).setButtonStyle(1).setCanceledOnTouchOutside(false);
        BiliCommonDialog build = builder.build();
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        build.show(childFragmentManager, "favorites_v2");
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment
    public boolean shouldInitOnResume() {
        return !getViewModel().getHasInitPage();
    }

    @Override // tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment
    public void firstInitPage() {
        getViewModel().sendAction(new FavoritesAction.Load(true));
    }

    @Override // tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment
    public void onRetryClick() {
        firstInitPage();
    }

    @Override // tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment
    public void onCleanInvalidClick() {
        cleanInvalid();
        getViewModel().sendAction(FavoritesAction.GotoEmpty.INSTANCE);
    }
}