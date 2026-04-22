package tv.danmaku.bili.ui.favorites.fragment;

import android.content.Context;
import android.content.Intent;
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
import androidx.fragment.app.FragmentActivity;
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
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.app.comm.list.common.widget.PromoToast;
import com.bilibili.app.comm.list.widget.scroll.AnyScrollLoadMoreScroller;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.ui.callback.IBackPress;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.playset.playlist.edit.RecyclerSortCallback;
import com.bilibili.playset.playlist.entity.SortRecord;
import com.bilibili.playset.widget.favorite.FavSnackBarUtil;
import com.bilibili.playset.widget.favorite.FavoriteDialog;
import com.bilibili.playset.widget.favorite.IFavoriteDialogListener;
import com.bilibili.pvtracker.PageViewTracker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.databinding.BiliAppFragmentFavoritesTabBinding;
import tv.danmaku.bili.ui.favorites.adapter.FavoritesEditListAdapter;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;
import tv.danmaku.bili.ui.favorites.state.FavTabState;
import tv.danmaku.bili.ui.favorites.state.FavoritesAction;
import tv.danmaku.bili.ui.favorites.state.FavoritesEvent;
import tv.danmaku.bili.ui.favorites.util.FavReportHelperKt;
import tv.danmaku.bili.ui.favorites.util.FavRouterUtilsKt;
import tv.danmaku.bili.ui.favorites.util.FavoritesUtilsKt;
import tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel;
import tv.danmaku.bili.widget.dialog.BiliCommonDialog;
import tv.danmaku.bili.widget.dialog.CustomButtonInfo;
import tv.danmaku.bili.widget.swiperefresh.SwipeRefreshLayout;

/* compiled from: FavoritesEditTabFragment.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001KB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020(H\u0002J\b\u0010+\u001a\u00020*H\u0016J\u001a\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u00100\u001a\u00020(H\u0002J\u001b\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u00103\u001a\u0004\u0018\u000104H\u0002¢\u0006\u0002\u00105J\u001b\u00106\u001a\u0004\u0018\u0001022\n\b\u0002\u00103\u001a\u0004\u0018\u000104H\u0002¢\u0006\u0002\u00105J\u0018\u00107\u001a\u00020(2\u0006\u00108\u001a\u0002022\u0006\u00109\u001a\u00020 H\u0014J\b\u0010@\u001a\u00020(H\u0002J\u001a\u0010A\u001a\u00020(2\u0006\u0010B\u001a\u00020C2\b\b\u0002\u0010D\u001a\u00020*H\u0002J\u0012\u0010E\u001a\u00020**\u00020FH\u0082@¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u00020*H\u0016J\b\u0010I\u001a\u00020(H\u0016J\b\u0010J\u001a\u00020(H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u001b0\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Ltv/danmaku/bili/ui/favorites/fragment/FavoritesEditTabFragment;", "Ltv/danmaku/bili/ui/favorites/fragment/BaseFavTabFragment;", "Lcom/bilibili/lib/ui/callback/IBackPress;", "<init>", "()V", "viewModel", "Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesEditListViewModel;", "getViewModel", "()Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesEditListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mSortOps", "", "Lcom/bilibili/playset/playlist/entity/SortRecord;", "getMSortOps", "()Ljava/util/List;", "mSortOps$delegate", "adapter", "Ltv/danmaku/bili/ui/favorites/adapter/FavoritesEditListAdapter;", "getAdapter", "()Ltv/danmaku/bili/ui/favorites/adapter/FavoritesEditListAdapter;", "setAdapter", "(Ltv/danmaku/bili/ui/favorites/adapter/FavoritesEditListAdapter;)V", "favoriteDialog", "Lcom/bilibili/playset/widget/favorite/FavoriteDialog;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initAdapter", "", "createNewFolder", "", "onBackPressed", "onViewCreated", "view", "mItemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "initItemTouchHelper", "getToolbarBgColor", "", "garb", "Lcom/bilibili/lib/ui/garb/Garb;", "(Lcom/bilibili/lib/ui/garb/Garb;)Ljava/lang/Integer;", "getToolbarTextColor", "onCardExposed", "position", "itemView", "mTitle", "", "mAttr", "playlistId", "", "totalMediaCount", "initParams", "showFavDialog", "event", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent;", "needRefresh", "showBiliCommonDialog", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldInitOnResume", "firstInitPage", "onRetryClick", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesEditTabFragment extends BaseFavTabFragment implements IBackPress {
    private static final String TAG = "FavoritesEditTabFragment";
    public FavoritesEditListAdapter adapter;
    private boolean createNewFolder;
    private FavoriteDialog favoriteDialog;
    private final ActivityResultLauncher<Intent> launcher;
    private int mAttr;
    private ItemTouchHelper mItemTouchHelper;
    private final Lazy mSortOps$delegate;
    private String mTitle;
    private long playlistId;
    private int totalMediaCount;
    private final Lazy viewModel$delegate;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public FavoritesEditTabFragment() {
        final Fragment $this$viewModels_u24default$iv = (Fragment) this;
        Function0 factoryProducer$iv = new Function0() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$$ExternalSyntheticLambda7
            public final Object invoke() {
                ViewModelProvider.Factory viewModel_delegate$lambda$0;
                viewModel_delegate$lambda$0 = FavoritesEditTabFragment.viewModel_delegate$lambda$0(FavoritesEditTabFragment.this);
                return viewModel_delegate$lambda$0;
            }
        };
        final Function0 ownerProducer$iv = new Function0<Fragment>() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final Fragment m1630invoke() {
                return $this$viewModels_u24default$iv;
            }
        };
        final Lazy owner$delegate$iv = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStoreOwner m1631invoke() {
                return (ViewModelStoreOwner) ownerProducer$iv.invoke();
            }
        });
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$viewModels_u24default$iv, Reflection.getOrCreateKotlinClass(FavoritesEditListViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m1632invoke() {
                return FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m1633invoke() {
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
        this.mSortOps$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$$ExternalSyntheticLambda8
            public final Object invoke() {
                List mSortOps_delegate$lambda$0;
                mSortOps_delegate$lambda$0 = FavoritesEditTabFragment.mSortOps_delegate$lambda$0();
                return mSortOps_delegate$lambda$0;
            }
        });
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$$ExternalSyntheticLambda9
            public final void onActivityResult(Object obj) {
                FavoritesEditTabFragment.launcher$lambda$0(FavoritesEditTabFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.launcher = registerForActivityResult;
        this.mTitle = "";
        this.mAttr = -1;
    }

    /* compiled from: FavoritesEditTabFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/favorites/fragment/FavoritesEditTabFragment$Companion;", "", "<init>", "()V", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final FavoritesEditListViewModel getViewModel() {
        return (FavoritesEditListViewModel) this.viewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory viewModel_delegate$lambda$0(final FavoritesEditTabFragment this$0) {
        return new ViewModelProvider.Factory() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$viewModel$2$1
            public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                return ViewModelProvider.Factory.-CC.$default$create(this, cls, creationExtras);
            }

            public /* synthetic */ ViewModel create(KClass kClass, CreationExtras creationExtras) {
                return ViewModelProvider.Factory.-CC.$default$create(this, kClass, creationExtras);
            }

            public <T extends ViewModel> T create(Class<T> cls) {
                List mSortOps;
                long j;
                int i;
                Intrinsics.checkNotNullParameter(cls, "modelClass");
                mSortOps = FavoritesEditTabFragment.this.getMSortOps();
                j = FavoritesEditTabFragment.this.playlistId;
                i = FavoritesEditTabFragment.this.totalMediaCount;
                return new FavoritesEditListViewModel(mSortOps, j, i);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SortRecord> getMSortOps() {
        return (List) this.mSortOps$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List mSortOps_delegate$lambda$0() {
        return new ArrayList();
    }

    public final FavoritesEditListAdapter getAdapter() {
        FavoritesEditListAdapter favoritesEditListAdapter = this.adapter;
        if (favoritesEditListAdapter != null) {
            return favoritesEditListAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        return null;
    }

    public final void setAdapter(FavoritesEditListAdapter favoritesEditListAdapter) {
        Intrinsics.checkNotNullParameter(favoritesEditListAdapter, "<set-?>");
        this.adapter = favoritesEditListAdapter;
    }

    public final ActivityResultLauncher<Intent> getLauncher() {
        return this.launcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launcher$lambda$0(FavoritesEditTabFragment this$0, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResultCode() == -1) {
            FavoriteDialog favoriteDialog = this$0.favoriteDialog;
            if (favoriteDialog != null) {
                favoriteDialog.updateFavBoxList();
            }
            this$0.createNewFolder = true;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        initParams();
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    private final void initAdapter() {
        setAdapter(new FavoritesEditListAdapter(getMSortOps(), getViewModel(), new FavoritesEditTabFragment$initAdapter$1(this)));
    }

    public boolean onBackPressed() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_result_is_create_folder", this.createNewFolder);
        Iterable $this$any$iv = getMSortOps();
        boolean z = false;
        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
            Iterator<T> it = $this$any$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object element$iv = it.next();
                SortRecord it2 = (SortRecord) element$iv;
                if (!it2.isInvalid()) {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            bundle.putParcelableArrayList("sort_record", new ArrayList<>(getMSortOps()));
            bundle.putString("api_params_sort_record", CollectionsKt.joinToString$default(getMSortOps(), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$$ExternalSyntheticLambda10
                public final Object invoke(Object obj) {
                    CharSequence onBackPressed$lambda$1;
                    onBackPressed$lambda$1 = FavoritesEditTabFragment.onBackPressed$lambda$1((SortRecord) obj);
                    return onBackPressed$lambda$1;
                }
            }, 30, (Object) null));
        }
        intent.putExtras(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence onBackPressed$lambda$1(SortRecord record) {
        Intrinsics.checkNotNullParameter(record, "record");
        return record.toString();
    }

    @Override // tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        BiliAppFragmentFavoritesTabBinding $this$onViewCreated_u24lambda_u240 = getBinding();
        initAdapter();
        $this$onViewCreated_u24lambda_u240.recyclerView.setAdapter(getAdapter());
        initItemTouchHelper();
        ListExtentionsKt.visible(getBinding().tabToolBarManage);
        getBinding().manageDone.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FavoritesEditTabFragment.this.onBackPressed();
            }
        });
        getBinding().swipeLayout.setEnabled(false);
        $this$onViewCreated_u24lambda_u240.recyclerView.addOnScrollListener((RecyclerView.OnScrollListener) new AnyScrollLoadMoreScroller(new Function0() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$$ExternalSyntheticLambda13
            public final Object invoke() {
                Unit onViewCreated$lambda$0$1;
                onViewCreated$lambda$0$1 = FavoritesEditTabFragment.onViewCreated$lambda$0$1(FavoritesEditTabFragment.this);
                return onViewCreated$lambda$0$1;
            }
        }));
        $this$onViewCreated_u24lambda_u240.swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$$ExternalSyntheticLambda14
            public final void onRefresh() {
                FavoritesEditTabFragment.onViewCreated$lambda$0$2(FavoritesEditTabFragment.this);
            }
        });
        boolean $this$onViewCreated_u24lambda_u240_u243 = getTabId() == 103;
        $this$onViewCreated_u24lambda_u240.move.setVisibility(ListExtentionsKt.toVisibility(!$this$onViewCreated_u24lambda_u240_u243));
        $this$onViewCreated_u24lambda_u240.copy.setVisibility(ListExtentionsKt.toVisibility($this$onViewCreated_u24lambda_u240_u243 ? false : true));
        $this$onViewCreated_u24lambda_u240.batchManageContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FavoritesEditTabFragment.onViewCreated$lambda$0$4(view2);
            }
        });
        View view2 = $this$onViewCreated_u24lambda_u240.move;
        Intrinsics.checkNotNullExpressionValue(view2, "move");
        ListExtentionsKt.addTouchDelegate(view2, ListExtentionsKt.toPx(5));
        View view3 = $this$onViewCreated_u24lambda_u240.copy;
        Intrinsics.checkNotNullExpressionValue(view3, "copy");
        ListExtentionsKt.addTouchDelegate(view3, ListExtentionsKt.toPx(5));
        $this$onViewCreated_u24lambda_u240.checkAllLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                FavoritesEditTabFragment.onViewCreated$lambda$0$5(FavoritesEditTabFragment.this, view4);
            }
        });
        $this$onViewCreated_u24lambda_u240.delete.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                FavoritesEditTabFragment.onViewCreated$lambda$0$6(FavoritesEditTabFragment.this, view4);
            }
        });
        $this$onViewCreated_u24lambda_u240.move.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                FavoritesEditTabFragment.onViewCreated$lambda$0$7(FavoritesEditTabFragment.this, view4);
            }
        });
        $this$onViewCreated_u24lambda_u240.copy.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                FavoritesEditTabFragment.onViewCreated$lambda$0$8(FavoritesEditTabFragment.this, view4);
            }
        });
        Integer toolbarBgColor$default = getToolbarBgColor$default(this, null, 1, null);
        if (toolbarBgColor$default != null) {
            $this$onViewCreated_u24lambda_u240.tabToolBarManage.setBackgroundColor(toolbarBgColor$default.intValue());
        }
        Integer toolbarTextColor$default = getToolbarTextColor$default(this, null, 1, null);
        if (toolbarTextColor$default != null) {
            int it = toolbarTextColor$default.intValue();
            $this$onViewCreated_u24lambda_u240.manageTitle.setTextColor(it);
            $this$onViewCreated_u24lambda_u240.manageDone.setTextColor(it);
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new FavoritesEditTabFragment$onViewCreated$2(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), (CoroutineContext) null, (CoroutineStart) null, new FavoritesEditTabFragment$onViewCreated$3(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), (CoroutineContext) null, (CoroutineStart) null, new FavoritesEditTabFragment$onViewCreated$4(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner4), (CoroutineContext) null, (CoroutineStart) null, new FavoritesEditTabFragment$onViewCreated$5(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner5), (CoroutineContext) null, (CoroutineStart) null, new FavoritesEditTabFragment$onViewCreated$6(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner6), (CoroutineContext) null, (CoroutineStart) null, new FavoritesEditTabFragment$onViewCreated$7(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$1(FavoritesEditTabFragment this$0) {
        this$0.getViewModel().sendAction(new FavoritesAction.Load(false));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$2(FavoritesEditTabFragment this$0) {
        this$0.getViewModel().sendAction(FavoritesAction.Refresh.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$4(View it) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$5(FavoritesEditTabFragment this$0, View it) {
        this$0.getViewModel().sendAction(FavoritesAction.CheckAll.INSTANCE);
        FavReportHelperKt.reportSecButtonClick(FavoritesConstsKt.BUTTON_NAME_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$6(FavoritesEditTabFragment this$0, View it) {
        this$0.getViewModel().sendAction(FavoritesAction.SortItems.INSTANCE);
        this$0.getViewModel().sendAction(FavoritesAction.ClickDelete.INSTANCE);
        FavReportHelperKt.reportSecButtonClick(FavoritesConstsKt.BUTTON_NAME_DELETE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$7(FavoritesEditTabFragment this$0, View it) {
        this$0.getViewModel().sendAction(FavoritesAction.SortItems.INSTANCE);
        this$0.getViewModel().sendAction(FavoritesAction.MoveTo.INSTANCE);
        FavReportHelperKt.reportSecButtonClick(FavoritesConstsKt.BUTTON_NAME_MOVE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$8(FavoritesEditTabFragment this$0, View it) {
        this$0.getViewModel().sendAction(FavoritesAction.SortItems.INSTANCE);
        this$0.getViewModel().sendAction(FavoritesAction.CopyTo.INSTANCE);
        FavReportHelperKt.reportSecButtonClick(FavoritesConstsKt.BUTTON_NAME_COPY);
    }

    private final void initItemTouchHelper() {
        this.mItemTouchHelper = new ItemTouchHelper(new RecyclerSortCallback(new Function2() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                boolean initItemTouchHelper$lambda$0;
                initItemTouchHelper$lambda$0 = FavoritesEditTabFragment.initItemTouchHelper$lambda$0(FavoritesEditTabFragment.this, (RecyclerView.ViewHolder) obj, (RecyclerView.ViewHolder) obj2);
                return Boolean.valueOf(initItemTouchHelper$lambda$0);
            }
        }, new Function1() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                boolean initItemTouchHelper$lambda$1;
                initItemTouchHelper$lambda$1 = FavoritesEditTabFragment.initItemTouchHelper$lambda$1(FavoritesEditTabFragment.this, ((Integer) obj).intValue());
                return Boolean.valueOf(initItemTouchHelper$lambda$1);
            }
        }));
        ItemTouchHelper itemTouchHelper = this.mItemTouchHelper;
        if (itemTouchHelper != null) {
            itemTouchHelper.attachToRecyclerView(getBinding().recyclerView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initItemTouchHelper$lambda$0(FavoritesEditTabFragment this$0, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(target, "target");
        this$0.getAdapter().swap(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initItemTouchHelper$lambda$1(FavoritesEditTabFragment this$0, int it) {
        return this$0.totalMediaCount <= 1000;
    }

    static /* synthetic */ Integer getToolbarBgColor$default(FavoritesEditTabFragment favoritesEditTabFragment, Garb garb, int i, Object obj) {
        if ((i & 1) != 0) {
            garb = null;
        }
        return favoritesEditTabFragment.getToolbarBgColor(garb);
    }

    private final Integer getToolbarBgColor(Garb garb) {
        int colorById;
        Garb realGarb = garb == null ? GarbManager.getCurGarb() : garb;
        Garb it = realGarb;
        if (!it.isPure() && !it.isPrimaryOnly()) {
            colorById = it.getSecondaryPageColor();
        } else if (it.isPure() && !it.isWhite() && !it.isNight()) {
            colorById = ThemeUtils.getColorById(requireContext(), R.color.theme_color_primary_tr_background);
        } else {
            return null;
        }
        return Integer.valueOf(colorById);
    }

    static /* synthetic */ Integer getToolbarTextColor$default(FavoritesEditTabFragment favoritesEditTabFragment, Garb garb, int i, Object obj) {
        if ((i & 1) != 0) {
            garb = null;
        }
        return favoritesEditTabFragment.getToolbarTextColor(garb);
    }

    private final Integer getToolbarTextColor(Garb garb) {
        Garb realGarb = garb == null ? GarbManager.getCurGarb() : garb;
        Garb it = realGarb;
        if (!it.isPure() && !it.isPrimaryOnly()) {
            return Integer.valueOf(it.getFontColor());
        }
        if (it.isPure() && !it.isWhite() && !it.isNight()) {
            return Integer.valueOf(ThemeUtils.getColorById(requireContext(), R.color.theme_color_primary_tr_title));
        }
        return null;
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

    private final void initParams() {
        Bundle it;
        Bundle arguments = getArguments();
        if (arguments != null && (it = arguments.getBundle("params")) != null) {
            String string = it.getString("mTitle");
            if (string == null) {
                string = "";
            }
            this.mTitle = string;
            this.mAttr = it.getInt("mAttr", -1);
            this.playlistId = it.getLong("playlistId");
            this.totalMediaCount = it.getInt("totalMediaCount");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void showFavDialog$default(FavoritesEditTabFragment favoritesEditTabFragment, FavoritesEvent favoritesEvent, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        favoritesEditTabFragment.showFavDialog(favoritesEvent, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showFavDialog(final FavoritesEvent event, final boolean needRefresh) {
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
        Iterable $this$filter$iv = getViewModel().getSortedList();
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
            return;
        }
        String resources = CollectionsKt.joinToString$default(checkedItems, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                CharSequence showFavDialog$lambda$3;
                showFavDialog$lambda$3 = FavoritesEditTabFragment.showFavDialog$lambda$3((FavoritesMediasItem) obj);
                return showFavDialog$lambda$3;
            }
        }, 30, (Object) null);
        final boolean hasInvalid = it.size() < checkedItems.size();
        FavoriteDialog.ExtraParams extraParam = new FavoriteDialog.ExtraParams(0L, 0L, FavoriteDialog.BizType.UGC, true, (int) FavRouterUtilsKt.REQ_CODE_CREATE_FOLDER, true, false, false, MapsKt.emptyMap(), "", FavoritesConstsKt.BATCH_ADD_WATCH_LATER_SP_MID, getActivityVM().getFromSpmid(), FavSnackBarUtil.Scene.DetailPage, (Boolean) null, false, true, resources, action, Long.valueOf(this.playlistId), 24576, (DefaultConstructorMarker) null);
        this.favoriteDialog = new FavoriteDialog(activity, extraParam, this.launcher);
        FavoriteDialog favoriteDialog = this.favoriteDialog;
        if (favoriteDialog != null) {
            favoriteDialog.setDialogListener(new IFavoriteDialogListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$showFavDialog$1
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
                public /* synthetic */ void m1636showSnackBar7SKmwc0(String str, int i, boolean z, String str2) {
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
                        if (event instanceof FavoritesEvent.CopyTo) {
                            this.getViewModel().sendAction(FavoritesAction.CancelAllChecked.INSTANCE);
                        }
                    }
                    if (needRefresh) {
                        this.getViewModel().sendAction(FavoritesAction.Refresh.INSTANCE);
                    }
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
    public final Object showBiliCommonDialog(Context $this$showBiliCommonDialog, Continuation<? super Boolean> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation it = cancellableContinuationImpl;
        BiliCommonDialog.Builder builder = BiliCommonDialog.Builder.setPositiveButton$default(BiliCommonDialog.Builder.setNegativeButton$default(new BiliCommonDialog.Builder($this$showBiliCommonDialog).setTitle(bili.resource.favorites.R.string.favorites_global_string_169), bili.resource.common.R.string.common_global_string_238, new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$showBiliCommonDialog$2$builder$1
            public final void onDialogTextClicked(View view, BiliCommonDialog biliCommonDialog) {
                Intrinsics.checkNotNullParameter(view, "<unused var>");
                Intrinsics.checkNotNullParameter(biliCommonDialog, "<unused var>");
                Result.Companion companion = Result.Companion;
                it.resumeWith(Result.constructor-impl(false));
            }
        }, true, (CustomButtonInfo) null, 8, (Object) null), bili.resource.common.R.string.common_global_string_113, new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$showBiliCommonDialog$2$builder$2
            public final void onDialogTextClicked(View view, BiliCommonDialog biliCommonDialog) {
                Intrinsics.checkNotNullParameter(view, "<unused var>");
                Intrinsics.checkNotNullParameter(biliCommonDialog, "<unused var>");
                Result.Companion companion = Result.Companion;
                it.resumeWith(Result.constructor-impl(true));
            }
        }, true, (CustomButtonInfo) null, 8, (Object) null).setTitleColorRes(com.bilibili.lib.theme.R.color.Text1).setButtonStyle(1).setCanceledOnTouchOutside(false);
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
}