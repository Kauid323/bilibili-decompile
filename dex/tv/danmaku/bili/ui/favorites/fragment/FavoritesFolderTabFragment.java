package tv.danmaku.bili.ui.favorites.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import bili.resource.favorites.R;
import com.bilibili.app.comm.list.common.widget.bottomsheet.ListBottomSheetDialog;
import com.bilibili.app.comm.list.common.widget.bottomsheet.ListBottomSheetItem;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.playset.editor.utils.PlaySetEditorRouterUtilsKt;
import com.bilibili.pvtracker.PageViewTracker;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.databinding.BiliAppFragmentFavoritesTabBinding;
import tv.danmaku.bili.ui.favorites.adapter.FolderListAdapter;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.favorites.model.FavoritesFolderItem;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;
import tv.danmaku.bili.ui.favorites.state.FavTabState;
import tv.danmaku.bili.ui.favorites.state.FavoritesPageAction;
import tv.danmaku.bili.ui.favorites.state.FolderAction;
import tv.danmaku.bili.ui.favorites.util.FavReportHelperKt;
import tv.danmaku.bili.ui.favorites.util.FavRouterUtilsKt;
import tv.danmaku.bili.ui.favorites.util.FavoritesFolderUtilsKt;
import tv.danmaku.bili.ui.favorites.util.FavoritesUtilsKt;
import tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel;
import tv.danmaku.bili.ui.watchlater.utils.WatchLaterRouterKt;
import tv.danmaku.bili.widget.swiperefresh.SwipeRefreshLayout;

/* compiled from: FavoritesFolderTabFragment.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010'\u001a\u00020\u0017H\u0016J\"\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u001b2\b\u0010+\u001a\u0004\u0018\u00010\fH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\n\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006-"}, d2 = {"Ltv/danmaku/bili/ui/favorites/fragment/FavoritesFolderTabFragment;", "Ltv/danmaku/bili/ui/favorites/fragment/BaseFavTabFragment;", "<init>", "()V", "viewModel", "Ltv/danmaku/bili/ui/favorites/viewmodel/FolderListViewModel;", "getViewModel", "()Ltv/danmaku/bili/ui/favorites/viewmodel/FolderListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "adapter", "Ltv/danmaku/bili/ui/favorites/adapter/FolderListAdapter;", "getAdapter", "()Ltv/danmaku/bili/ui/favorites/adapter/FolderListAdapter;", "shouldInitOnResume", "", "firstInitPage", "", "onRetryClick", "onCardExposed", "position", "", "itemView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onResume", "onActivityResult", "requestCode", "resultCode", "data", "FolderItemDecoration", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesFolderTabFragment extends BaseFavTabFragment {
    public static final int $stable = 8;
    private final FolderListAdapter adapter;
    private final ActivityResultLauncher<Intent> launcher;
    private final Lazy viewModel$delegate;

    public FavoritesFolderTabFragment() {
        final Fragment $this$viewModels_u24default$iv = (Fragment) this;
        Function0 factoryProducer$iv = new Function0() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$$ExternalSyntheticLambda1
            public final Object invoke() {
                ViewModelProvider.Factory viewModel_delegate$lambda$0;
                viewModel_delegate$lambda$0 = FavoritesFolderTabFragment.viewModel_delegate$lambda$0(FavoritesFolderTabFragment.this);
                return viewModel_delegate$lambda$0;
            }
        };
        final Function0 ownerProducer$iv = new Function0<Fragment>() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final Fragment m1641invoke() {
                return $this$viewModels_u24default$iv;
            }
        };
        final Lazy owner$delegate$iv = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStoreOwner m1642invoke() {
                return (ViewModelStoreOwner) ownerProducer$iv.invoke();
            }
        });
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$viewModels_u24default$iv, Reflection.getOrCreateKotlinClass(FolderListViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m1643invoke() {
                return FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m1644invoke() {
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
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$$ExternalSyntheticLambda2
            public final void onActivityResult(Object obj) {
                FavoritesFolderTabFragment.launcher$lambda$0(FavoritesFolderTabFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.launcher = registerForActivityResult;
        this.adapter = new FolderListAdapter(new Function2() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2) {
                Unit adapter$lambda$0;
                adapter$lambda$0 = FavoritesFolderTabFragment.adapter$lambda$0(FavoritesFolderTabFragment.this, (FavoritesFolderItem) obj, ((Integer) obj2).intValue());
                return adapter$lambda$0;
            }
        }, new Function1() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit adapter$lambda$1;
                adapter$lambda$1 = FavoritesFolderTabFragment.adapter$lambda$1(FavoritesFolderTabFragment.this, (FavoritesFolderItem) obj);
                return adapter$lambda$1;
            }
        }, new Function0() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$$ExternalSyntheticLambda5
            public final Object invoke() {
                Unit adapter$lambda$2;
                adapter$lambda$2 = FavoritesFolderTabFragment.adapter$lambda$2(FavoritesFolderTabFragment.this);
                return adapter$lambda$2;
            }
        }, new Function3() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$$ExternalSyntheticLambda6
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit adapter$lambda$3;
                adapter$lambda$3 = FavoritesFolderTabFragment.adapter$lambda$3(FavoritesFolderTabFragment.this, (FavoritesMediasItem) obj, ((Integer) obj2).intValue(), ((Long) obj3).longValue());
                return adapter$lambda$3;
            }
        }, new Function2() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$$ExternalSyntheticLambda7
            public final Object invoke(Object obj, Object obj2) {
                Unit adapter$lambda$4;
                adapter$lambda$4 = FavoritesFolderTabFragment.adapter$lambda$4(FavoritesFolderTabFragment.this, (FavoritesMediasItem) obj, ((Long) obj2).longValue());
                return adapter$lambda$4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FolderListViewModel getViewModel() {
        return (FolderListViewModel) this.viewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory viewModel_delegate$lambda$0(final FavoritesFolderTabFragment this$0) {
        return new ViewModelProvider.Factory() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$viewModel$2$1
            public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                return ViewModelProvider.Factory.-CC.$default$create(this, cls, creationExtras);
            }

            public /* synthetic */ ViewModel create(KClass kClass, CreationExtras creationExtras) {
                return ViewModelProvider.Factory.-CC.$default$create(this, kClass, creationExtras);
            }

            public <T extends ViewModel> T create(Class<T> cls) {
                Intrinsics.checkNotNullParameter(cls, "modelClass");
                return new FolderListViewModel(FavoritesFolderTabFragment.this.getTabId());
            }
        };
    }

    public final ActivityResultLauncher<Intent> getLauncher() {
        return this.launcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launcher$lambda$0(FavoritesFolderTabFragment this$0, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResultCode() == -1) {
            LifecycleOwner viewLifecycleOwner = this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new FavoritesFolderTabFragment$launcher$1$1(this$0, null), 3, (Object) null);
        }
    }

    public final FolderListAdapter getAdapter() {
        return this.adapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit adapter$lambda$0(FavoritesFolderTabFragment this$0, FavoritesFolderItem item, int pos) {
        Intrinsics.checkNotNullParameter(item, "item");
        FavRouterUtilsKt.routerToFavFolderList(item.getJumpLink(), (Fragment) this$0);
        Pair[] pairArr = new Pair[11];
        pairArr[0] = TuplesKt.to("oid", String.valueOf(item.getFid()));
        pairArr[1] = TuplesKt.to(FavoritesConstsKt.FAV_TYPE, String.valueOf(item.getType()));
        pairArr[2] = TuplesKt.to("tab_name", this$0.getFirstTabName());
        pairArr[3] = TuplesKt.to("second_tab_name", this$0.getSecondTabName());
        pairArr[4] = TuplesKt.to(FavoritesConstsKt.IS_ACQUIESCE, FavoritesUtilsKt.toIsAcquiesce(this$0.getTabId(), this$0.getActivityVM().getDefaultTabId()));
        pairArr[5] = TuplesKt.to(FavoritesConstsKt.POS, String.valueOf(pos + 1));
        pairArr[6] = TuplesKt.to("from_spmid", this$0.getActivityVM().getFromSpmid());
        pairArr[7] = TuplesKt.to(FavoritesConstsKt.JUMP_TYPE, "1");
        pairArr[8] = TuplesKt.to(FavoritesConstsKt.PLAYLIST_ID, String.valueOf(item.getFid()));
        pairArr[9] = TuplesKt.to(FavoritesConstsKt.LAYOUT_TYPE, String.valueOf(FavoritesFolderUtilsKt.layoutType()));
        String currentPolarisActionId = PageViewTracker.getInstance().currentPolarisActionId();
        if (currentPolarisActionId == null) {
            currentPolarisActionId = "";
        }
        pairArr[10] = TuplesKt.to(FavoritesConstsKt.ACTION_ID, currentPolarisActionId);
        FavReportHelperKt.reportFavCardClick(MapsKt.mapOf(pairArr));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit adapter$lambda$1(final FavoritesFolderTabFragment this$0, final FavoritesFolderItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        Context mContext = this$0.getContext();
        if (mContext == null) {
            return Unit.INSTANCE;
        }
        if (item.isDefault()) {
            return Unit.INSTANCE;
        }
        ArrayList items = new ArrayList(CollectionsKt.listOf(new ListBottomSheetItem(mContext.getString(R.string.favorites_global_string_140), Integer.valueOf(com.bilibili.iconfont.R.drawable.ref_arrow_to_top_up_line_500), 0, com.bilibili.lib.theme.R.color.Text1, false, mContext.getString(R.string.favorites_global_string_186), 0, 84, (DefaultConstructorMarker) null)));
        ListBottomSheetDialog newInstance = ListBottomSheetDialog.Companion.newInstance(items, new Function1() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Unit adapter$lambda$1$0;
                adapter$lambda$1$0 = FavoritesFolderTabFragment.adapter$lambda$1$0(FavoritesFolderTabFragment.this, item, ((Integer) obj).intValue());
                return adapter$lambda$1$0;
            }
        });
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        newInstance.show(childFragmentManager, "FavoriteTab Article");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit adapter$lambda$1$0(FavoritesFolderTabFragment this$0, FavoritesFolderItem $item, int it) {
        this$0.getViewModel().sendAction(new FolderAction.ToTop($item));
        FavReportHelperKt.reportLonePressTopClick($item.isTop(), $item.getFid());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit adapter$lambda$2(FavoritesFolderTabFragment this$0) {
        Context requireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        PlaySetEditorRouterUtilsKt.routeToCreatePage(requireContext, this$0.launcher, (int) FavRouterUtilsKt.REQ_CODE_CREATE_FOLDER);
        FavReportHelperKt.reportAddFavoritesFolderClick();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit adapter$lambda$3(FavoritesFolderTabFragment this$0, FavoritesMediasItem item, int pos, long fid) {
        Intrinsics.checkNotNullParameter(item, "item");
        WatchLaterRouterKt.routerTo$default(item.getLink(), this$0.getContext(), (Map) null, 4, (Object) null);
        Pair[] pairArr = new Pair[12];
        pairArr[0] = TuplesKt.to("oid", String.valueOf(item.getOid()));
        pairArr[1] = TuplesKt.to(FavoritesConstsKt.FAV_TYPE, String.valueOf(item.getOtype()));
        pairArr[2] = TuplesKt.to("tab_name", this$0.getFirstTabName());
        pairArr[3] = TuplesKt.to("second_tab_name", this$0.getSecondTabName());
        pairArr[4] = TuplesKt.to(FavoritesConstsKt.IS_ACQUIESCE, FavoritesUtilsKt.toIsAcquiesce(this$0.getTabId(), this$0.getActivityVM().getDefaultTabId()));
        pairArr[5] = TuplesKt.to(FavoritesConstsKt.POS, String.valueOf(pos + 1));
        pairArr[6] = TuplesKt.to("from_spmid", this$0.getActivityVM().getFromSpmid());
        pairArr[7] = TuplesKt.to(FavoritesConstsKt.JUMP_TYPE, "2");
        pairArr[8] = TuplesKt.to(FavoritesConstsKt.USER_STATE, item.getUserStateStr());
        pairArr[9] = TuplesKt.to(FavoritesConstsKt.LAYOUT_TYPE, String.valueOf(FavoritesFolderUtilsKt.layoutType()));
        pairArr[10] = TuplesKt.to(FavoritesConstsKt.PLAYLIST_ID, String.valueOf(fid));
        String currentPolarisActionId = PageViewTracker.getInstance().currentPolarisActionId();
        if (currentPolarisActionId == null) {
            currentPolarisActionId = "";
        }
        pairArr[11] = TuplesKt.to(FavoritesConstsKt.ACTION_ID, currentPolarisActionId);
        FavReportHelperKt.reportFavCardClick(MapsKt.mapOf(pairArr));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit adapter$lambda$4(FavoritesFolderTabFragment this$0, FavoritesMediasItem item, long fid) {
        Intrinsics.checkNotNullParameter(item, "item");
        WatchLaterRouterKt.routerTo$default(item.getLink(), this$0.getContext(), (Map) null, 4, (Object) null);
        Pair[] pairArr = new Pair[11];
        pairArr[0] = TuplesKt.to("oid", String.valueOf(item.getOid()));
        pairArr[1] = TuplesKt.to(FavoritesConstsKt.FAV_TYPE, String.valueOf(item.getOtype()));
        pairArr[2] = TuplesKt.to("tab_name", this$0.getFirstTabName());
        pairArr[3] = TuplesKt.to("second_tab_name", this$0.getSecondTabName());
        pairArr[4] = TuplesKt.to(FavoritesConstsKt.IS_ACQUIESCE, FavoritesUtilsKt.toIsAcquiesce(this$0.getTabId(), this$0.getActivityVM().getDefaultTabId()));
        pairArr[5] = TuplesKt.to("from_spmid", this$0.getActivityVM().getFromSpmid());
        pairArr[6] = TuplesKt.to(FavoritesConstsKt.USER_STATE, item.getUserStateStr());
        pairArr[7] = TuplesKt.to(FavoritesConstsKt.JUMP_TYPE, "2");
        pairArr[8] = TuplesKt.to(FavoritesConstsKt.LAYOUT_TYPE, String.valueOf(FavoritesFolderUtilsKt.layoutType()));
        pairArr[9] = TuplesKt.to(FavoritesConstsKt.PLAYLIST_ID, String.valueOf(fid));
        String currentPolarisActionId = PageViewTracker.getInstance().currentPolarisActionId();
        if (currentPolarisActionId == null) {
            currentPolarisActionId = "";
        }
        pairArr[10] = TuplesKt.to(FavoritesConstsKt.ACTION_ID, currentPolarisActionId);
        FavReportHelperKt.reportFavCardClick(MapsKt.mapOf(pairArr));
        return Unit.INSTANCE;
    }

    @Override // tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment
    public boolean shouldInitOnResume() {
        return !getViewModel().getHasInitPage();
    }

    @Override // tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment
    public void firstInitPage() {
        getViewModel().sendAction(new FolderAction.Load(false));
    }

    @Override // tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment
    public void onRetryClick() {
        getViewModel().sendAction(new FolderAction.Load(false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment
    public void onCardExposed(int position, View itemView) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        BLog.i(FavoritesFolderTabFragmentKt.TAG, "card exposed position:" + position);
        if (position < 0 || position >= ((FavTabState) getViewModel().getUiStateFlow().getValue()).getItemList().size()) {
            return;
        }
        FavoritesFolderItem item = (FavoritesFolderItem) ((FavTabState) getViewModel().getUiStateFlow().getValue()).getItemList().get(position);
        Pair[] pairArr = new Pair[10];
        pairArr[0] = TuplesKt.to("oid", String.valueOf(item.getFid()));
        pairArr[1] = TuplesKt.to(FavoritesConstsKt.FAV_TYPE, String.valueOf(item.getType()));
        pairArr[2] = TuplesKt.to("tab_name", getFirstTabName());
        pairArr[3] = TuplesKt.to("second_tab_name", getSecondTabName());
        pairArr[4] = TuplesKt.to(FavoritesConstsKt.IS_ACQUIESCE, FavoritesUtilsKt.toIsAcquiesce(getTabId(), getActivityVM().getDefaultTabId()));
        pairArr[5] = TuplesKt.to(FavoritesConstsKt.POS, String.valueOf(position + 1));
        pairArr[6] = TuplesKt.to("from_spmid", getActivityVM().getFromSpmid());
        pairArr[7] = TuplesKt.to(FavoritesConstsKt.PLAYLIST_ID, String.valueOf(item.getFid()));
        pairArr[8] = TuplesKt.to(FavoritesConstsKt.LAYOUT_TYPE, String.valueOf(FavoritesFolderUtilsKt.layoutType()));
        String currentPolarisActionId = PageViewTracker.getInstance().currentPolarisActionId();
        if (currentPolarisActionId == null) {
            currentPolarisActionId = "";
        }
        pairArr[9] = TuplesKt.to(FavoritesConstsKt.ACTION_ID, currentPolarisActionId);
        FavReportHelperKt.reportFavCardShow(MapsKt.mapOf(pairArr));
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
        $this$onViewCreated_u24lambda_u240.layoutContainer.setBackgroundResource(com.bilibili.lib.theme.R.color.Bg2);
        $this$onViewCreated_u24lambda_u240.recyclerView.setAdapter((RecyclerView.Adapter) this.adapter);
        $this$onViewCreated_u24lambda_u240.recyclerView.addItemDecoration(new FolderItemDecoration());
        $this$onViewCreated_u24lambda_u240.swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$$ExternalSyntheticLambda0
            public final void onRefresh() {
                FavoritesFolderTabFragment.onViewCreated$lambda$0$0(FavoritesFolderTabFragment.this);
            }
        });
        $this$onViewCreated_u24lambda_u240.recyclerView.setBackgroundResource(com.bilibili.lib.theme.R.color.Bg2);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new FavoritesFolderTabFragment$onViewCreated$2(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), (CoroutineContext) null, (CoroutineStart) null, new FavoritesFolderTabFragment$onViewCreated$3(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), (CoroutineContext) null, (CoroutineStart) null, new FavoritesFolderTabFragment$onViewCreated$4(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner4), (CoroutineContext) null, (CoroutineStart) null, new FavoritesFolderTabFragment$onViewCreated$5(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner5), (CoroutineContext) null, (CoroutineStart) null, new FavoritesFolderTabFragment$onViewCreated$6(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner6), (CoroutineContext) null, (CoroutineStart) null, new FavoritesFolderTabFragment$onViewCreated$7(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$0(FavoritesFolderTabFragment this$0) {
        this$0.getViewModel().sendAction(new FolderAction.Load(true));
    }

    @Override // tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment
    public void onResume() {
        super.onResume();
        getActivityVM().sendAction(FavoritesPageAction.ShowFolderTab.INSTANCE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 300 && resultCode == -1) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new FavoritesFolderTabFragment$onActivityResult$1(this, null), 3, (Object) null);
        }
        if (requestCode == 2333 && resultCode == -1) {
            firstInitPage();
        }
    }

    /* compiled from: FavoritesFolderTabFragment.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/favorites/fragment/FavoritesFolderTabFragment$FolderItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "EDGE_MARGIN", "", "SPACE", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", AuthResultCbHelper.ARGS_STATE, "Landroidx/recyclerview/widget/RecyclerView$State;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class FolderItemDecoration extends RecyclerView.ItemDecoration {
        public static final int $stable = 8;
        private final int EDGE_MARGIN = ListExtentionsKt.toPx(12);
        private final int SPACE = ListExtentionsKt.toPx(5);

        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
            int pos = parent.getChildAdapterPosition(view);
            int itemCount = state.getItemCount();
            outRect.left = this.EDGE_MARGIN;
            outRect.right = this.EDGE_MARGIN;
            if (pos == 0) {
                outRect.top = this.EDGE_MARGIN;
                outRect.bottom = this.SPACE;
            } else if (pos == itemCount - 1) {
                outRect.top = this.SPACE;
                outRect.bottom = this.EDGE_MARGIN;
            } else {
                outRect.top = this.SPACE;
                outRect.bottom = this.SPACE;
            }
        }
    }
}