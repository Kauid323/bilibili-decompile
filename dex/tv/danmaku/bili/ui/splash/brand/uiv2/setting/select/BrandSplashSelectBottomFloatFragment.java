package tv.danmaku.bili.ui.splash.brand.uiv2.setting.select;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bilibili.lib.spy.generated.androidx_fragment_app_Fragment;
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
import tv.danmaku.bili.ui.splash.databinding.BiliAppListBrandSplashBottomSelectFloatWindowBinding;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSelectBottomFloatFragment.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/select/BrandSplashSelectBottomFloatFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Ltv/danmaku/bili/ui/splash/databinding/BiliAppListBrandSplashBottomSelectFloatWindowBinding;", "vm", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/BrandSplashSettingViewModel;", "getVm", "()Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/BrandSplashSettingViewModel;", "vm$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Companion", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashSelectBottomFloatFragment extends androidx_fragment_app_Fragment {
    private BiliAppListBrandSplashBottomSelectFloatWindowBinding binding;
    private final Lazy vm$delegate;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public BrandSplashSelectBottomFloatFragment() {
        final Fragment $this$activityViewModels_u24default$iv = (Fragment) this;
        this.vm$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$activityViewModels_u24default$iv, Reflection.getOrCreateKotlinClass(BrandSplashSettingViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectBottomFloatFragment$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m1596invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectBottomFloatFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m1597invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r2;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectBottomFloatFragment$special$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelProvider.Factory m1598invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BrandSplashSettingViewModel getVm() {
        return (BrandSplashSettingViewModel) this.vm$delegate.getValue();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        BiliAppListBrandSplashBottomSelectFloatWindowBinding inflate = BiliAppListBrandSplashBottomSelectFloatWindowBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        BiliAppListBrandSplashBottomSelectFloatWindowBinding biliAppListBrandSplashBottomSelectFloatWindowBinding = this.binding;
        if (biliAppListBrandSplashBottomSelectFloatWindowBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListBrandSplashBottomSelectFloatWindowBinding = null;
        }
        View root = biliAppListBrandSplashBottomSelectFloatWindowBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view2, "view");
        super.onViewCreated(view2, savedInstanceState);
        BiliAppListBrandSplashBottomSelectFloatWindowBinding biliAppListBrandSplashBottomSelectFloatWindowBinding = this.binding;
        if (biliAppListBrandSplashBottomSelectFloatWindowBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListBrandSplashBottomSelectFloatWindowBinding = null;
        }
        biliAppListBrandSplashBottomSelectFloatWindowBinding.vArrow.setSelected(((Boolean) getVm().isFloatSelectWindowSelect().getValue()).booleanValue());
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashSelectBottomFloatFragment$onViewCreated$1(this, null), 3, (Object) null);
        BiliAppListBrandSplashBottomSelectFloatWindowBinding biliAppListBrandSplashBottomSelectFloatWindowBinding2 = this.binding;
        if (biliAppListBrandSplashBottomSelectFloatWindowBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListBrandSplashBottomSelectFloatWindowBinding2 = null;
        }
        biliAppListBrandSplashBottomSelectFloatWindowBinding2.clickArea.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectBottomFloatFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                BrandSplashSelectBottomFloatFragment.onViewCreated$lambda$0(BrandSplashSelectBottomFloatFragment.this, view3);
            }
        });
        BiliAppListBrandSplashBottomSelectFloatWindowBinding biliAppListBrandSplashBottomSelectFloatWindowBinding3 = this.binding;
        if (biliAppListBrandSplashBottomSelectFloatWindowBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListBrandSplashBottomSelectFloatWindowBinding3 = null;
        }
        biliAppListBrandSplashBottomSelectFloatWindowBinding3.tvSaveSelect.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectBottomFloatFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                BrandSplashSelectBottomFloatFragment.onViewCreated$lambda$1(BrandSplashSelectBottomFloatFragment.this, view3);
            }
        });
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashSelectBottomFloatFragment$onViewCreated$4(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashSelectBottomFloatFragment$onViewCreated$5(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner4), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashSelectBottomFloatFragment$onViewCreated$6(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(BrandSplashSelectBottomFloatFragment this$0, View it) {
        boolean state = ((Boolean) this$0.getVm().isFloatSelectWindowSelect().getValue()).booleanValue();
        this$0.getVm().isFloatSelectWindowSelect().setValue(Boolean.valueOf(!state));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(BrandSplashSelectBottomFloatFragment this$0, View it) {
        LifecycleOwner viewLifecycleOwner = this$0.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashSelectBottomFloatFragment$onViewCreated$3$1(this$0, null), 3, (Object) null);
    }

    /* compiled from: BrandSplashSelectBottomFloatFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/select/BrandSplashSelectBottomFloatFragment$Companion;", "", "<init>", "()V", "newInstance", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/select/BrandSplashSelectBottomFloatFragment;", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BrandSplashSelectBottomFloatFragment newInstance() {
            return new BrandSplashSelectBottomFloatFragment();
        }
    }
}