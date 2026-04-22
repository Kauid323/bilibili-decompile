package tv.danmaku.bili.ui.splash.brand.uiv2.setting.tab;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.spy.generated.androidx_fragment_app_Fragment;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingData;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingPageMore;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingTab;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSource;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel;
import tv.danmaku.bili.ui.splash.databinding.BiliAppListBrandSplashSettingTabFragmentBinding;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSettingTabFragment.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/tab/BrandSplashSettingTabFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Ltv/danmaku/bili/ui/splash/databinding/BiliAppListBrandSplashSettingTabFragmentBinding;", "vm", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/BrandSplashSettingViewModel;", "source", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "hasMore", "", "Companion", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashSettingTabFragment extends androidx_fragment_app_Fragment {
    private static final String TAG = "[BrandSplash]BrandSplashSettingTabFragment";
    private BiliAppListBrandSplashSettingTabFragmentBinding binding;
    private String source;
    private BrandSplashSettingViewModel vm;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        this.source = arguments != null ? arguments.getString("source") : null;
        ViewModelStoreOwner activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        this.vm = (BrandSplashSettingViewModel) new ViewModelProvider(activity).get(BrandSplashSettingViewModel.class);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        BiliAppListBrandSplashSettingTabFragmentBinding inflate = BiliAppListBrandSplashSettingTabFragmentBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        BiliAppListBrandSplashSettingTabFragmentBinding biliAppListBrandSplashSettingTabFragmentBinding = this.binding;
        if (biliAppListBrandSplashSettingTabFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListBrandSplashSettingTabFragmentBinding = null;
        }
        View root = biliAppListBrandSplashSettingTabFragmentBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view2, "view");
        super.onViewCreated(view2, savedInstanceState);
        if (Intrinsics.areEqual(this.source, BrandSplashSource.VIP.getValue())) {
            BiliAppListBrandSplashSettingTabFragmentBinding biliAppListBrandSplashSettingTabFragmentBinding = this.binding;
            if (biliAppListBrandSplashSettingTabFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                biliAppListBrandSplashSettingTabFragmentBinding = null;
            }
            ViewGroup.LayoutParams layoutParams = biliAppListBrandSplashSettingTabFragmentBinding.rvItems.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) layoutParams;
            lp.leftMargin = ListExtentionsKt.toPx(0);
            lp.rightMargin = ListExtentionsKt.toPx(0);
            BiliAppListBrandSplashSettingTabFragmentBinding biliAppListBrandSplashSettingTabFragmentBinding2 = this.binding;
            if (biliAppListBrandSplashSettingTabFragmentBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                biliAppListBrandSplashSettingTabFragmentBinding2 = null;
            }
            biliAppListBrandSplashSettingTabFragmentBinding2.rvItems.setLayoutParams(lp);
        }
        BiliAppListBrandSplashSettingTabFragmentBinding biliAppListBrandSplashSettingTabFragmentBinding3 = this.binding;
        if (biliAppListBrandSplashSettingTabFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListBrandSplashSettingTabFragmentBinding3 = null;
        }
        RecyclerView recyclerView = biliAppListBrandSplashSettingTabFragmentBinding3.rvItems;
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.tab.BrandSplashSettingTabFragment$onViewCreated$1$1
            public int getSpanSize(int position) {
                BiliAppListBrandSplashSettingTabFragmentBinding biliAppListBrandSplashSettingTabFragmentBinding4;
                biliAppListBrandSplashSettingTabFragmentBinding4 = BrandSplashSettingTabFragment.this.binding;
                if (biliAppListBrandSplashSettingTabFragmentBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    biliAppListBrandSplashSettingTabFragmentBinding4 = null;
                }
                RecyclerView.Adapter adapter = biliAppListBrandSplashSettingTabFragmentBinding4.rvItems.getAdapter();
                BrandSplashSettingAdapter brandSplashSettingAdapter = adapter instanceof BrandSplashSettingAdapter ? (BrandSplashSettingAdapter) adapter : null;
                if (brandSplashSettingAdapter != null) {
                    return brandSplashSettingAdapter.getSpanCount(position);
                }
                return 3;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        BiliAppListBrandSplashSettingTabFragmentBinding biliAppListBrandSplashSettingTabFragmentBinding4 = this.binding;
        if (biliAppListBrandSplashSettingTabFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListBrandSplashSettingTabFragmentBinding4 = null;
        }
        biliAppListBrandSplashSettingTabFragmentBinding4.rvItems.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.tab.BrandSplashSettingTabFragment$onViewCreated$2
            /* JADX WARN: Removed duplicated region for block: B:15:0x005c  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void getItemOffsets(Rect outRect, View view3, RecyclerView parent, RecyclerView.State state) {
                RecyclerView.Adapter adapter;
                int bottom;
                String str;
                boolean hasMore;
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view3, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                super.getItemOffsets(outRect, view3, parent, state);
                int pos = parent.getChildAdapterPosition(view3);
                if (pos == (parent.getAdapter() != null ? adapter.getItemCount() : 0) - 1) {
                    hasMore = BrandSplashSettingTabFragment.this.hasMore();
                    if (!hasMore) {
                        bottom = ListExtentionsKt.toPx(150);
                        outRect.bottom = bottom;
                        outRect.top = ListExtentionsKt.toPx(16);
                        str = BrandSplashSettingTabFragment.this.source;
                        int padding = Intrinsics.areEqual(str, BrandSplashSource.VIP.getValue()) ? 0 : 6;
                        outRect.left = ListExtentionsKt.toPx(padding);
                        outRect.right = ListExtentionsKt.toPx(padding);
                    }
                }
                bottom = 0;
                outRect.bottom = bottom;
                outRect.top = ListExtentionsKt.toPx(16);
                str = BrandSplashSettingTabFragment.this.source;
                if (Intrinsics.areEqual(str, BrandSplashSource.VIP.getValue())) {
                }
                outRect.left = ListExtentionsKt.toPx(padding);
                outRect.right = ListExtentionsKt.toPx(padding);
            }
        });
        BiliAppListBrandSplashSettingTabFragmentBinding biliAppListBrandSplashSettingTabFragmentBinding5 = this.binding;
        if (biliAppListBrandSplashSettingTabFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListBrandSplashSettingTabFragmentBinding5 = null;
        }
        RecyclerView recyclerView2 = biliAppListBrandSplashSettingTabFragmentBinding5.rvItems;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "rvItems");
        ListExtentionsKt.onReachBottom(recyclerView2, 0, new Function0() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.tab.BrandSplashSettingTabFragment$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit onViewCreated$lambda$1;
                onViewCreated$lambda$1 = BrandSplashSettingTabFragment.onViewCreated$lambda$1(BrandSplashSettingTabFragment.this);
                return onViewCreated$lambda$1;
            }
        });
        BrandSplashSettingAdapter adapter = new BrandSplashSettingAdapter((Fragment) this);
        BiliAppListBrandSplashSettingTabFragmentBinding biliAppListBrandSplashSettingTabFragmentBinding6 = this.binding;
        if (biliAppListBrandSplashSettingTabFragmentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListBrandSplashSettingTabFragmentBinding6 = null;
        }
        biliAppListBrandSplashSettingTabFragmentBinding6.rvItems.setAdapter(adapter);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashSettingTabFragment$onViewCreated$4(this, adapter, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$1(BrandSplashSettingTabFragment this$0) {
        List<BrandSplashSettingTab> tabs;
        Object obj;
        BrandSplashSettingPageMore page;
        BLog.i(TAG, "onReachBottom, source = " + this$0.source);
        BrandSplashSettingViewModel brandSplashSettingViewModel = this$0.vm;
        BrandSplashSettingViewModel brandSplashSettingViewModel2 = null;
        if (brandSplashSettingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            brandSplashSettingViewModel = null;
        }
        BrandSplashSettingData brandSplashSettingData = (BrandSplashSettingData) brandSplashSettingViewModel.getBrandSplashData().getValue();
        if (brandSplashSettingData != null && (tabs = brandSplashSettingData.getTabs()) != null) {
            Iterator<T> it = tabs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                BrandSplashSettingTab tab = (BrandSplashSettingTab) obj;
                if (Intrinsics.areEqual(tab.getSource(), this$0.source)) {
                    break;
                }
            }
            BrandSplashSettingTab brandSplashSettingTab = (BrandSplashSettingTab) obj;
            if (brandSplashSettingTab != null && (page = brandSplashSettingTab.getPage()) != null) {
                if (page.getHasMore()) {
                    BrandSplashSettingViewModel brandSplashSettingViewModel3 = this$0.vm;
                    if (brandSplashSettingViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                    } else {
                        brandSplashSettingViewModel2 = brandSplashSettingViewModel3;
                    }
                    brandSplashSettingViewModel2.loadMore(this$0.source, page);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasMore() {
        List<BrandSplashSettingTab> tabs;
        BrandSplashSettingPageMore page;
        BrandSplashSettingViewModel brandSplashSettingViewModel = this.vm;
        Object obj = null;
        if (brandSplashSettingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            brandSplashSettingViewModel = null;
        }
        BrandSplashSettingData brandSplashSettingData = (BrandSplashSettingData) brandSplashSettingViewModel.getBrandSplashData().getValue();
        if (brandSplashSettingData != null && (tabs = brandSplashSettingData.getTabs()) != null) {
            Iterator<T> it = tabs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                BrandSplashSettingTab tab = (BrandSplashSettingTab) next;
                if (Intrinsics.areEqual(tab.getSource(), this.source)) {
                    obj = next;
                    break;
                }
            }
            BrandSplashSettingTab brandSplashSettingTab = (BrandSplashSettingTab) obj;
            if (brandSplashSettingTab != null && (page = brandSplashSettingTab.getPage()) != null) {
                return page.getHasMore();
            }
        }
        return false;
    }

    /* compiled from: BrandSplashSettingTabFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/tab/BrandSplashSettingTabFragment$Companion;", "", "<init>", "()V", "newInstance", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/tab/BrandSplashSettingTabFragment;", "source", "", "TAG", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BrandSplashSettingTabFragment newInstance(String source) {
            Intrinsics.checkNotNullParameter(source, "source");
            BrandSplashSettingTabFragment $this$newInstance_u24lambda_u240 = new BrandSplashSettingTabFragment();
            Bundle $this$newInstance_u24lambda_u240_u240 = new Bundle();
            $this$newInstance_u24lambda_u240_u240.putString("source", source);
            $this$newInstance_u24lambda_u240.setArguments($this$newInstance_u24lambda_u240_u240);
            return $this$newInstance_u24lambda_u240;
        }
    }
}