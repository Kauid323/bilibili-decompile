package tv.danmaku.bili.ui.splash.brand.uiv2.setting;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.list.widget.utils.PaddingUtilsKt;
import com.bilibili.base.viewbinding.ViewBindingProperty;
import com.bilibili.base.viewbinding.full.CreateMethod;
import com.bilibili.base.viewbinding.full.ReflectionFragmentViewBindings;
import com.bilibili.base.viewbinding.internal.UtilsKt;
import com.bilibili.lib.ui.BaseToolbarFragment;
import com.bilibili.lib.ui.callback.IBackPress;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.MutableStateFlow;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.brand.config.BrandSplashParam;
import tv.danmaku.bili.ui.splash.brand.config.BrandSplashStorage;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSetOption;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingData;
import tv.danmaku.bili.ui.splash.brand.reporter.BrandSplashReporter;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview.BrandSplashPreviewFragment;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectBottomFloatFragment;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectFragment;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.model.CustomModeState;
import tv.danmaku.bili.ui.splash.databinding.BiliAppListBrandSplashSettingFragmentBinding;
import tv.danmaku.bili.ui.splash.utils.UiUtils;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSettingFragment.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J$\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020*2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u00101\u001a\u00020&H\u0002J\u0018\u00102\u001a\u00020&2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020&H\u0002J\u0010\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u000208H\u0002J\u0010\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u000208H\u0002J\u0010\u0010@\u001a\u00020&2\u0006\u0010=\u001a\u000208H\u0002J\u0010\u0010A\u001a\u00020&2\u0006\u0010=\u001a\u000208H\u0002J\b\u0010B\u001a\u00020&H\u0002J\b\u0010C\u001a\u00020&H\u0002J\b\u0010D\u001a\u00020&H\u0002J\b\u0010E\u001a\u000208H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0010\u001a\u0004\b\"\u0010#¨\u0006G"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/BrandSplashSettingFragment;", "Lcom/bilibili/lib/ui/BaseToolbarFragment;", "Lcom/bilibili/lib/ui/callback/IBackPress;", "<init>", "()V", "binding", "Ltv/danmaku/bili/ui/splash/databinding/BiliAppListBrandSplashSettingFragmentBinding;", "getBinding", "()Ltv/danmaku/bili/ui/splash/databinding/BiliAppListBrandSplashSettingFragmentBinding;", "binding$delegate", "Lcom/bilibili/base/viewbinding/ViewBindingProperty;", "floatBottomFragment", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/select/BrandSplashSelectBottomFloatFragment;", "getFloatBottomFragment", "()Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/select/BrandSplashSelectBottomFloatFragment;", "floatBottomFragment$delegate", "Lkotlin/Lazy;", "selectedFragment", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/select/BrandSplashSelectFragment;", "getSelectedFragment", "()Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/select/BrandSplashSelectFragment;", "selectedFragment$delegate", "previewFragment", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/preview/BrandSplashPreviewFragment;", "getPreviewFragment", "()Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/preview/BrandSplashPreviewFragment;", "previewFragment$delegate", "searchFragment", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/search/BrandSplashSearchFragment;", "getSearchFragment", "()Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/search/BrandSplashSearchFragment;", "searchFragment$delegate", "vm", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/BrandSplashSettingViewModel;", "getVm", "()Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/BrandSplashSettingViewModel;", "vm$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "onCreateToolbarMenu", "menu", "Landroid/view/Menu;", "menuInflater", "Landroid/view/MenuInflater;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "loadData", "showSelectFragment", "show", "showFloatSelectButton", "isChecked", "showSearchFragment", "showPreviewreFragment", "showLoading", "onLoadComplete", "onLoadError", "onBackPressed", "Companion", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashSettingFragment extends BaseToolbarFragment implements IBackPress {
    private static final String TAG = "[BrandSplash]BrandSplashSettingFragment";
    private final ViewBindingProperty binding$delegate;
    private final Lazy floatBottomFragment$delegate;
    private final Lazy previewFragment$delegate;
    private final Lazy searchFragment$delegate;
    private final Lazy selectedFragment$delegate;
    private final Lazy vm$delegate;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(BrandSplashSettingFragment.class, "binding", "getBinding()Ltv/danmaku/bili/ui/splash/databinding/BiliAppListBrandSplashSettingFragmentBinding;", 0))};
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public BrandSplashSettingFragment() {
        Fragment $this$viewBinding_u24default$iv = (Fragment) this;
        CreateMethod createMethod$iv = CreateMethod.INFLATE;
        Function1 onViewDestroyed$iv = UtilsKt.emptyVbCallback();
        this.binding$delegate = ReflectionFragmentViewBindings.viewBindingFragment($this$viewBinding_u24default$iv, BiliAppListBrandSplashSettingFragmentBinding.class, createMethod$iv, onViewDestroyed$iv);
        this.floatBottomFragment$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment$$ExternalSyntheticLambda0
            public final Object invoke() {
                BrandSplashSelectBottomFloatFragment floatBottomFragment_delegate$lambda$0;
                floatBottomFragment_delegate$lambda$0 = BrandSplashSettingFragment.floatBottomFragment_delegate$lambda$0();
                return floatBottomFragment_delegate$lambda$0;
            }
        });
        this.selectedFragment$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment$$ExternalSyntheticLambda1
            public final Object invoke() {
                BrandSplashSelectFragment selectedFragment_delegate$lambda$0;
                selectedFragment_delegate$lambda$0 = BrandSplashSettingFragment.selectedFragment_delegate$lambda$0();
                return selectedFragment_delegate$lambda$0;
            }
        });
        this.previewFragment$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment$$ExternalSyntheticLambda2
            public final Object invoke() {
                BrandSplashPreviewFragment previewFragment_delegate$lambda$0;
                previewFragment_delegate$lambda$0 = BrandSplashSettingFragment.previewFragment_delegate$lambda$0();
                return previewFragment_delegate$lambda$0;
            }
        });
        this.searchFragment$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment$$ExternalSyntheticLambda3
            public final Object invoke() {
                BrandSplashSearchFragment searchFragment_delegate$lambda$0;
                searchFragment_delegate$lambda$0 = BrandSplashSettingFragment.searchFragment_delegate$lambda$0();
                return searchFragment_delegate$lambda$0;
            }
        });
        final Fragment $this$activityViewModels_u24default$iv = (Fragment) this;
        this.vm$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$activityViewModels_u24default$iv, Reflection.getOrCreateKotlinClass(BrandSplashSettingViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m1574invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m1575invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r2;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment$special$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelProvider.Factory m1576invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BiliAppListBrandSplashSettingFragmentBinding getBinding() {
        return (BiliAppListBrandSplashSettingFragmentBinding) this.binding$delegate.getValue(this, $$delegatedProperties[0]);
    }

    private final BrandSplashSelectBottomFloatFragment getFloatBottomFragment() {
        return (BrandSplashSelectBottomFloatFragment) this.floatBottomFragment$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BrandSplashSelectBottomFloatFragment floatBottomFragment_delegate$lambda$0() {
        return BrandSplashSelectBottomFloatFragment.Companion.newInstance();
    }

    private final BrandSplashSelectFragment getSelectedFragment() {
        return (BrandSplashSelectFragment) this.selectedFragment$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BrandSplashSelectFragment selectedFragment_delegate$lambda$0() {
        return BrandSplashSelectFragment.Companion.newInstance();
    }

    private final BrandSplashPreviewFragment getPreviewFragment() {
        return (BrandSplashPreviewFragment) this.previewFragment$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BrandSplashPreviewFragment previewFragment_delegate$lambda$0() {
        return BrandSplashPreviewFragment.Companion.newInstance();
    }

    private final BrandSplashSearchFragment getSearchFragment() {
        return (BrandSplashSearchFragment) this.searchFragment$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BrandSplashSearchFragment searchFragment_delegate$lambda$0() {
        return new BrandSplashSearchFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BrandSplashSettingViewModel getVm() {
        return (BrandSplashSettingViewModel) this.vm$delegate.getValue();
    }

    public void onCreate(Bundle savedInstanceState) {
        Window window;
        final View $this$doOnPreDraw$iv;
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null || ($this$doOnPreDraw$iv = window.getDecorView()) == null) {
            return;
        }
        OneShotPreDrawListener.add($this$doOnPreDraw$iv, new Runnable() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment$onCreate$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                BiliAppListBrandSplashSettingFragmentBinding binding;
                BiliAppListBrandSplashSettingFragmentBinding binding2;
                BiliAppListBrandSplashSettingFragmentBinding binding3;
                BiliAppListBrandSplashSettingFragmentBinding binding4;
                BiliAppListBrandSplashSettingFragmentBinding binding5;
                BiliAppListBrandSplashSettingFragmentBinding binding6;
                View view2 = $this$doOnPreDraw$iv;
                BLog.i("[BrandSplash]BrandSplashSettingFragment", "on preDraw");
                UiUtils.INSTANCE.transportStatusBarV2((Activity) this.getActivity());
                int statusBarHeight = StatusBarCompat.getStatusBarHeight(this.getContext());
                BLog.i("[BrandSplash]BrandSplashSettingFragment", "doOnPreDraw, statusBarHeight = " + statusBarHeight);
                binding = this.getBinding();
                ViewGroup.LayoutParams layoutParams = binding.navTopBar.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) layoutParams;
                lp.height += statusBarHeight;
                binding2 = this.getBinding();
                binding2.navTopBar.setLayoutParams(lp);
                binding3 = this.getBinding();
                View view3 = binding3.navTopBar;
                Intrinsics.checkNotNullExpressionValue(view3, "navTopBar");
                PaddingUtilsKt.setPaddingTop(view3, statusBarHeight);
                binding4 = this.getBinding();
                ViewGroup.LayoutParams layoutParams2 = binding4.loadingView.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams loadingLp = (ViewGroup.MarginLayoutParams) layoutParams2;
                binding5 = this.getBinding();
                loadingLp.topMargin = binding5.navTopBar.getHeight();
                binding6 = this.getBinding();
                binding6.loadingView.setLayoutParams(loadingLp);
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view2, "view");
        super.onViewCreated(view2, savedInstanceState);
        BrandSplashReporter.INSTANCE.reportSettingPageShow();
        initView();
        loadData();
    }

    private final void initView() {
        BrandSplashParam brandSplashParam = BrandSplashParam.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        setTitle(brandSplashParam.getSplashSettingTitle(requireContext));
        getBinding().modeSettingArea.defaultModeSwitch.setChecked(BrandSplashStorage.INSTANCE.isCustomMode());
        getBinding().vpContainer.setUserInputEnabled(false);
        getBinding().vpContainer.setOffscreenPageLimit(1);
        getBinding().modeSettingArea.defaultModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment$$ExternalSyntheticLambda4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                BrandSplashSettingFragment.initView$lambda$0(BrandSplashSettingFragment.this, compoundButton, z);
            }
        });
        getBinding().modeSettingArea.defaultModeSwitch.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BrandSplashSettingFragment.initView$lambda$1(view2);
            }
        });
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashSettingFragment$initView$3(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashSettingFragment$initView$4(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashSettingFragment$initView$5(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner4), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashSettingFragment$initView$6(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner5), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashSettingFragment$initView$7(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner6), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashSettingFragment$initView$8(this, null), 3, (Object) null);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
        RecyclerView.Adapter brandSplashSettingViewPagerAdapter = new BrandSplashSettingViewPagerAdapter(childFragmentManager, lifecycle);
        getBinding().vpContainer.setAdapter(brandSplashSettingViewPagerAdapter);
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner7), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashSettingFragment$initView$9(this, brandSplashSettingViewPagerAdapter, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner8 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner8, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner8), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashSettingFragment$initView$10(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(BrandSplashSettingFragment this$0, CompoundButton compoundButton, boolean isChecked) {
        this$0.getVm().getCustomModeState().setValue(new CustomModeState(isChecked, false, null, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(View it) {
        BrandSplashReporter brandSplashReporter = BrandSplashReporter.INSTANCE;
        Intrinsics.checkNotNull(it, "null cannot be cast to non-null type androidx.appcompat.widget.SwitchCompat");
        brandSplashReporter.reportCustomSwitchClicked(((SwitchCompat) it).isChecked());
    }

    public void onCreateToolbarMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "menuInflater");
        super.onCreateToolbarMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.brand_splash_menu_search, menu);
        final MenuItem item = menu.findItem(R.id.searchable_search);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment$$ExternalSyntheticLambda6
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean onCreateToolbarMenu$lambda$0;
                onCreateToolbarMenu$lambda$0 = BrandSplashSettingFragment.onCreateToolbarMenu$lambda$0(BrandSplashSettingFragment.this, item, menuItem);
                return onCreateToolbarMenu$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateToolbarMenu$lambda$0(BrandSplashSettingFragment this$0, MenuItem $item, MenuItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNull($item);
        return this$0.onOptionsItemSelected($item);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        int id = item.getItemId();
        if (id == R.id.searchable_search) {
            getVm().getSearchPageViewModel().getSearchFragmentShowing().setValue(true);
        }
        return super.onOptionsItemSelected(item);
    }

    private final void loadData() {
        getVm().loadTabs();
        Bundle it = getArguments();
        if (it != null) {
            MutableStateFlow<BrandSplash> brandSplashFromRouter = getVm().getBrandSplashFromRouter();
            BrandSplash brandSplash = null;
            try {
                BrandSplash $this$loadData_u24lambda_u240_u240 = (BrandSplash) new Gson().fromJson(it.getString("brandSplash"), BrandSplash.class);
                if ($this$loadData_u24lambda_u240_u240 != null) {
                    $this$loadData_u24lambda_u240_u240.setToBeSet(true);
                    $this$loadData_u24lambda_u240_u240.setCustomModeOn(true);
                    brandSplash = $this$loadData_u24lambda_u240_u240;
                }
            } catch (JsonSyntaxException e) {
            }
            brandSplashFromRouter.setValue(brandSplash);
            if (Intrinsics.areEqual(it.getString("autoOpenFloat"), "1")) {
                getVm().autoOpenFloat();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSelectFragment(boolean show) {
        if (show && !getSelectedFragment().isAdded()) {
            getChildFragmentManager().beginTransaction().setCustomAnimations(R.anim.fragment_bottom_in, R.anim.fragment_bottom_out).add(R.id.fragment_container, getSelectedFragment()).commitNowAllowingStateLoss();
        } else if (!show && getSelectedFragment().isAdded()) {
            getChildFragmentManager().beginTransaction().setCustomAnimations(R.anim.fragment_bottom_in, R.anim.fragment_bottom_out).remove(getSelectedFragment()).commitNowAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showFloatSelectButton(boolean isChecked) {
        BLog.i(TAG, "doFloatInOut, " + isChecked);
        if (isChecked && !getFloatBottomFragment().isAdded()) {
            getChildFragmentManager().beginTransaction().setCustomAnimations(R.anim.fragment_bottom_in, R.anim.fragment_bottom_out).add(R.id.bottom_float_fragment_container, getFloatBottomFragment()).commitNowAllowingStateLoss();
        } else if (!isChecked && getFloatBottomFragment().isAdded()) {
            getChildFragmentManager().beginTransaction().setCustomAnimations(R.anim.fragment_bottom_in, R.anim.fragment_bottom_out).remove(getFloatBottomFragment()).commitNowAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSearchFragment(boolean show) {
        if (show && !getSearchFragment().isAdded()) {
            getChildFragmentManager().beginTransaction().setCustomAnimations(R.anim.fragment_bottom_in, R.anim.fragment_bottom_out).add(R.id.search_fragment_container, getSearchFragment()).commitNowAllowingStateLoss();
        } else if (!show && getSearchFragment().isAdded()) {
            getChildFragmentManager().beginTransaction().setCustomAnimations(R.anim.fragment_bottom_in, R.anim.fragment_bottom_out).remove(getSearchFragment()).commitNowAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPreviewreFragment(boolean show) {
        if (show && !getPreviewFragment().isAdded()) {
            getChildFragmentManager().beginTransaction().setCustomAnimations(R.anim.fragment_bottom_in, R.anim.fragment_bottom_out).add(R.id.fragment_container, getPreviewFragment()).commitNowAllowingStateLoss();
        } else if (!show && getPreviewFragment().isAdded()) {
            getChildFragmentManager().beginTransaction().setCustomAnimations(R.anim.fragment_bottom_in, R.anim.fragment_bottom_out).remove(getPreviewFragment()).commitNowAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoading() {
        getBinding().loadingView.setVisibility(0);
        getBinding().loadingView.setRefreshing();
        getBinding().loadingView.setButtonVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLoadComplete() {
        getBinding().loadingView.setRefreshComplete();
        getBinding().loadingView.setVisibility(8);
        showFloatSelectButton(BrandSplashStorage.INSTANCE.isCustomMode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLoadError() {
        if (activityDie()) {
            return;
        }
        getBinding().loadingView.setVisibility(0);
        getBinding().loadingView.setRefreshError(getString(bili.resource.common.R.string.common_global_string_91));
        getBinding().loadingView.setImageResource(com.bilibili.app.comm.baseres.R.drawable.bili_2233_fail);
        getBinding().loadingView.setButtonText(bili.resource.common.R.string.common_global_string_94);
        getBinding().loadingView.setButtonVisible(true);
        getBinding().loadingView.setButtonBackground(com.bilibili.lib.ui.R.drawable.selector_button_solid_pink);
        getBinding().loadingView.setButtonClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BrandSplashSettingFragment.onLoadError$lambda$0(BrandSplashSettingFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLoadError$lambda$0(BrandSplashSettingFragment this$0, View it) {
        this$0.getVm().loadTabs();
    }

    public boolean onBackPressed() {
        if (getSelectedFragment().isAdded()) {
            getSelectedFragment().onBackPressed();
            return true;
        } else if (getPreviewFragment().isAdded()) {
            getPreviewFragment().onBackPressed();
            return true;
        } else if (getSearchFragment().isAdded()) {
            getSearchFragment().onBackPressed();
            return true;
        } else {
            BrandSplashSettingData brandSplashSettingData = (BrandSplashSettingData) getVm().getBrandSplashData().getValue();
            BrandSplashSetOption option = brandSplashSettingData != null ? brandSplashSettingData.getSetOption() : null;
            if (!BrandSplashStorage.INSTANCE.isCustomMode() || option == null) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                    return false;
                }
                return false;
            }
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashSettingFragment$onBackPressed$1(this, option, null), 3, (Object) null);
            return true;
        }
    }

    /* compiled from: BrandSplashSettingFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/BrandSplashSettingFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/BrandSplashSettingFragment;", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BrandSplashSettingFragment newInstance() {
            return new BrandSplashSettingFragment();
        }
    }
}