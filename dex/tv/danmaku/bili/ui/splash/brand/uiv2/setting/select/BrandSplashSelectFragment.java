package tv.danmaku.bili.ui.splash.brand.uiv2.setting.select;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.spy.generated.androidx_fragment_app_Fragment;
import com.bilibili.lib.ui.callback.IBackPress;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel;
import tv.danmaku.bili.ui.splash.databinding.BiliAppListBrandSplashSelectFragmentBinding;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSelectFragment.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/select/BrandSplashSelectFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bilibili/lib/ui/callback/IBackPress;", "<init>", "()V", "binding", "Ltv/danmaku/bili/ui/splash/databinding/BiliAppListBrandSplashSelectFragmentBinding;", "vm", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/BrandSplashSettingViewModel;", "getVm", "()Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/BrandSplashSettingViewModel;", "vm$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onBackPressed", "", "Companion", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashSelectFragment extends androidx_fragment_app_Fragment implements IBackPress {
    private BiliAppListBrandSplashSelectFragmentBinding binding;
    private final Lazy vm$delegate;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public BrandSplashSelectFragment() {
        final Fragment $this$activityViewModels_u24default$iv = (Fragment) this;
        this.vm$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$activityViewModels_u24default$iv, Reflection.getOrCreateKotlinClass(BrandSplashSettingViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectFragment$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m1600invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m1601invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r2;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectFragment$special$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelProvider.Factory m1602invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BrandSplashSettingViewModel getVm() {
        return (BrandSplashSettingViewModel) this.vm$delegate.getValue();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            getVm().isFloatSelectWindowSelect().setValue(false);
            getParentFragmentManager().beginTransaction().remove((Fragment) this).commitAllowingStateLoss();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        BiliAppListBrandSplashSelectFragmentBinding inflate = BiliAppListBrandSplashSelectFragmentBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        BiliAppListBrandSplashSelectFragmentBinding biliAppListBrandSplashSelectFragmentBinding = this.binding;
        if (biliAppListBrandSplashSelectFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListBrandSplashSelectFragmentBinding = null;
        }
        View root = biliAppListBrandSplashSelectFragmentBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view2, "view");
        super.onViewCreated(view2, savedInstanceState);
        BiliAppListBrandSplashSelectFragmentBinding biliAppListBrandSplashSelectFragmentBinding = this.binding;
        BiliAppListBrandSplashSelectFragmentBinding biliAppListBrandSplashSelectFragmentBinding2 = null;
        if (biliAppListBrandSplashSelectFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListBrandSplashSelectFragmentBinding = null;
        }
        biliAppListBrandSplashSelectFragmentBinding.close.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                BrandSplashSelectFragment.onViewCreated$lambda$0(BrandSplashSelectFragment.this, view3);
            }
        });
        BiliAppListBrandSplashSelectFragmentBinding biliAppListBrandSplashSelectFragmentBinding3 = this.binding;
        if (biliAppListBrandSplashSelectFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListBrandSplashSelectFragmentBinding3 = null;
        }
        biliAppListBrandSplashSelectFragmentBinding3.rvItems.setLayoutManager(new GridLayoutManager(getContext(), 4));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashSelectFragment$onViewCreated$2(this, null), 3, (Object) null);
        BiliAppListBrandSplashSelectFragmentBinding biliAppListBrandSplashSelectFragmentBinding4 = this.binding;
        if (biliAppListBrandSplashSelectFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListBrandSplashSelectFragmentBinding4 = null;
        }
        biliAppListBrandSplashSelectFragmentBinding4.rvItems.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectFragment$onViewCreated$3
            public void getItemOffsets(Rect outRect, View view3, RecyclerView parent, RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view3, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                super.getItemOffsets(outRect, view3, parent, state);
                outRect.bottom = 0;
                outRect.top = ListExtentionsKt.toPx(16);
                outRect.left = ListExtentionsKt.toPx(6);
                outRect.right = ListExtentionsKt.toPx(6);
            }
        });
        BiliAppListBrandSplashSelectFragmentBinding biliAppListBrandSplashSelectFragmentBinding5 = this.binding;
        if (biliAppListBrandSplashSelectFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListBrandSplashSelectFragmentBinding5 = null;
        }
        biliAppListBrandSplashSelectFragmentBinding5.flSelectContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                BrandSplashSelectFragment.onViewCreated$lambda$1(BrandSplashSelectFragment.this, view3);
            }
        });
        BiliAppListBrandSplashSelectFragmentBinding biliAppListBrandSplashSelectFragmentBinding6 = this.binding;
        if (biliAppListBrandSplashSelectFragmentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            biliAppListBrandSplashSelectFragmentBinding2 = biliAppListBrandSplashSelectFragmentBinding6;
        }
        biliAppListBrandSplashSelectFragmentBinding2.contentAreaContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                BrandSplashSelectFragment.onViewCreated$lambda$2(view3);
            }
        });
        ValueAnimator $this$onViewCreated_u24lambda_u243 = ValueAnimator.ofInt(0, 127);
        $this$onViewCreated_u24lambda_u243.setStartDelay(300L);
        $this$onViewCreated_u24lambda_u243.setDuration(100L);
        $this$onViewCreated_u24lambda_u243.setInterpolator(new LinearInterpolator());
        $this$onViewCreated_u24lambda_u243.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectFragment$$ExternalSyntheticLambda3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BrandSplashSelectFragment.onViewCreated$lambda$3$0(BrandSplashSelectFragment.this, valueAnimator);
            }
        });
        $this$onViewCreated_u24lambda_u243.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(BrandSplashSelectFragment this$0, View it) {
        this$0.getVm().isFloatSelectWindowSelect().setValue(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(BrandSplashSelectFragment this$0, View it) {
        this$0.getVm().isFloatSelectWindowSelect().setValue(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(View it) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3$0(BrandSplashSelectFragment this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int progress = ((Integer) animatedValue).intValue();
        BiliAppListBrandSplashSelectFragmentBinding biliAppListBrandSplashSelectFragmentBinding = this$0.binding;
        if (biliAppListBrandSplashSelectFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListBrandSplashSelectFragmentBinding = null;
        }
        TintFrameLayout tintFrameLayout = biliAppListBrandSplashSelectFragmentBinding.flSelectContainer;
        ColorDrawable $this$onViewCreated_u24lambda_u243_u240_u240 = new ColorDrawable();
        $this$onViewCreated_u24lambda_u243_u240_u240.setColor(ColorUtils.setAlphaComponent(-16777216, progress));
        tintFrameLayout.setBackground($this$onViewCreated_u24lambda_u243_u240_u240);
    }

    public boolean onBackPressed() {
        getVm().isFloatSelectWindowSelect().setValue(false);
        return true;
    }

    /* compiled from: BrandSplashSelectFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/select/BrandSplashSelectFragment$Companion;", "", "<init>", "()V", "newInstance", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/select/BrandSplashSelectFragment;", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BrandSplashSelectFragment newInstance() {
            return new BrandSplashSelectFragment();
        }
    }
}