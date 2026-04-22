package tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bilibili.base.viewbinding.ViewBindingProperty;
import com.bilibili.base.viewbinding.full.CreateMethod;
import com.bilibili.base.viewbinding.full.ReflectionFragmentViewBindings;
import com.bilibili.base.viewbinding.internal.UtilsKt;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.ServicesProvider;
import com.bilibili.lib.spy.generated.androidx_fragment_app_Fragment;
import com.bilibili.lib.ui.callback.IBackPress;
import com.bilibili.vip.IBiliVipPaymentCombineService;
import com.bilibili.vip.VipPaymentCombineException;
import com.bilibili.vip.VipPrivilegeType;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
import tv.danmaku.bili.ui.splash.brand.config.BrandSplashConstKt;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSetOption;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingData;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingVipConfig;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel;
import tv.danmaku.bili.ui.splash.databinding.BiliAppListBrandSplashPreviewFragmentBinding;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: BrandSplashPreviewFragment.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\b\u0010\u001e\u001a\u00020\u0012H\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0002J\b\u0010 \u001a\u00020\u0012H\u0002J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0012H\u0016J\b\u0010%\u001a\u00020&H\u0016J\u000e\u0010'\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010(R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006*"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/preview/BrandSplashPreviewFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bilibili/lib/ui/callback/IBackPress;", "<init>", "()V", "binding", "Ltv/danmaku/bili/ui/splash/databinding/BiliAppListBrandSplashPreviewFragmentBinding;", "getBinding", "()Ltv/danmaku/bili/ui/splash/databinding/BiliAppListBrandSplashPreviewFragmentBinding;", "binding$delegate", "Lcom/bilibili/base/viewbinding/ViewBindingProperty;", "vm", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/BrandSplashSettingViewModel;", "getVm", "()Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/BrandSplashSettingViewModel;", "vm$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initData", "initView", "observerData", "handleSelectButtonClicked", "handlePageSelected", "data", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplash;", "onDestroy", "onBackPressed", "", "handleByVip", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashPreviewFragment extends androidx_fragment_app_Fragment implements IBackPress {
    private final ViewBindingProperty binding$delegate;
    private final Lazy vm$delegate;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(BrandSplashPreviewFragment.class, "binding", "getBinding()Ltv/danmaku/bili/ui/splash/databinding/BiliAppListBrandSplashPreviewFragmentBinding;", 0))};
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public BrandSplashPreviewFragment() {
        Fragment $this$viewBinding_u24default$iv = (Fragment) this;
        CreateMethod createMethod$iv = CreateMethod.INFLATE;
        Function1 onViewDestroyed$iv = UtilsKt.emptyVbCallback();
        this.binding$delegate = ReflectionFragmentViewBindings.viewBindingFragment($this$viewBinding_u24default$iv, BiliAppListBrandSplashPreviewFragmentBinding.class, createMethod$iv, onViewDestroyed$iv);
        final Fragment $this$activityViewModels_u24default$iv = (Fragment) this;
        this.vm$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$activityViewModels_u24default$iv, Reflection.getOrCreateKotlinClass(BrandSplashSettingViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview.BrandSplashPreviewFragment$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m1583invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview.BrandSplashPreviewFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m1584invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r2;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview.BrandSplashPreviewFragment$special$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelProvider.Factory m1585invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BiliAppListBrandSplashPreviewFragmentBinding getBinding() {
        return (BiliAppListBrandSplashPreviewFragmentBinding) this.binding$delegate.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BrandSplashSettingViewModel getVm() {
        return (BrandSplashSettingViewModel) this.vm$delegate.getValue();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            getVm().getFullPreviewMode().setValue(false);
            getVm().getPreviewPageEntryItem().setValue((Object) null);
            getParentFragmentManager().beginTransaction().remove((Fragment) this).commitAllowingStateLoss();
        }
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
        initView();
        initData();
    }

    private final void initData() {
        observerData();
    }

    private final void initView() {
        getBinding().brandSplashPreviewVp.setOffscreenPageLimit(2);
        getBinding().brandSplashPreviewVp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview.BrandSplashPreviewFragment$initView$1
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                BLog.i("[brandSplash]BrandSplashPreviewFragment", "onPageScrolled, position = " + position);
            }

            public void onPageSelected(int position) {
                BiliAppListBrandSplashPreviewFragmentBinding binding;
                List<BrandSplash> dataList;
                BrandSplash selectedItem;
                BrandSplashSettingViewModel vm;
                BrandSplash copy;
                super.onPageSelected(position);
                BLog.i("[brandSplash]BrandSplashPreviewFragment", "onPageSelected, position = " + position);
                binding = BrandSplashPreviewFragment.this.getBinding();
                RecyclerView.Adapter adapter = binding.brandSplashPreviewVp.getAdapter();
                BrandSplashPreviewAdapter brandSplashPreviewAdapter = adapter instanceof BrandSplashPreviewAdapter ? (BrandSplashPreviewAdapter) adapter : null;
                if (brandSplashPreviewAdapter != null && (dataList = brandSplashPreviewAdapter.getDataList()) != null && (selectedItem = dataList.get(position)) != null) {
                    vm = BrandSplashPreviewFragment.this.getVm();
                    MutableStateFlow<BrandSplash> previewPageEntryItem = vm.getPreviewPageEntryItem();
                    copy = selectedItem.copy((r30 & 1) != 0 ? selectedItem.id : 0L, (r30 & 2) != 0 ? selectedItem.thumb : null, (r30 & 4) != 0 ? selectedItem.thumbHash : null, (r30 & 8) != 0 ? selectedItem.thumbName : null, (r30 & 16) != 0 ? selectedItem.logoUrl : null, (r30 & 32) != 0 ? selectedItem.logoHash : null, (r30 & 64) != 0 ? selectedItem.mode : null, (r30 & 128) != 0 ? selectedItem.source : null, (r30 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? selectedItem.showLogo : false, (r30 & 512) != 0 ? selectedItem.isSelected : false, (r30 & 1024) != 0 ? selectedItem.isDisabled : false, (r30 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? selectedItem.isCustomModeOn : false, (r30 & 4096) != 0 ? selectedItem.isToBeSet : false);
                    previewPageEntryItem.setValue(copy);
                    BrandSplashPreviewFragment.this.handlePageSelected(selectedItem);
                }
            }

            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                BLog.i("[brandSplash]BrandSplashPreviewFragment", "onPageScrollStateChanged, state = " + state);
            }
        });
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashPreviewFragment$initView$2(this, null), 3, (Object) null);
        getBinding().topBar.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview.BrandSplashPreviewFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BrandSplashPreviewFragment.initView$lambda$0(view2);
            }
        });
        getBinding().brandSplashPreviewBack.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview.BrandSplashPreviewFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BrandSplashPreviewFragment.initView$lambda$1(BrandSplashPreviewFragment.this, view2);
            }
        });
        getBinding().brandSplashPreviewSelectBtn.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview.BrandSplashPreviewFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BrandSplashPreviewFragment.this.handleSelectButtonClicked();
            }
        });
        getBinding().brandSplashPreviewSelect.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview.BrandSplashPreviewFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BrandSplashPreviewFragment.this.handleSelectButtonClicked();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(View it) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(BrandSplashPreviewFragment this$0, View it) {
        this$0.getVm().getPreviewPageEntryItem().setValue((Object) null);
    }

    private final void observerData() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashPreviewFragment$observerData$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSelectButtonClicked() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashPreviewFragment$handleSelectButtonClicked$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlePageSelected(BrandSplash data) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashPreviewFragment$handlePageSelected$1(this, data, null), 3, (Object) null);
    }

    public void onDestroy() {
        super.onDestroy();
        getVm().getFullPreviewMode().setValue(false);
    }

    /* compiled from: BrandSplashPreviewFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/preview/BrandSplashPreviewFragment$Companion;", "", "<init>", "()V", "newInstance", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/preview/BrandSplashPreviewFragment;", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BrandSplashPreviewFragment newInstance() {
            return new BrandSplashPreviewFragment();
        }
    }

    public boolean onBackPressed() {
        getVm().getPreviewPageEntryItem().setValue((Object) null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleByVip(Continuation<? super Unit> continuation) {
        BrandSplashPreviewFragment$handleByVip$1 brandSplashPreviewFragment$handleByVip$1;
        Object buyVipResult;
        BrandSplashPreviewFragment brandSplashPreviewFragment;
        Throwable th;
        BrandSplashSetOption setOption;
        BrandSplashSettingVipConfig vipConfig;
        BrandSplashSetOption setOption2;
        BrandSplashSettingVipConfig vipConfig2;
        if (continuation instanceof BrandSplashPreviewFragment$handleByVip$1) {
            brandSplashPreviewFragment$handleByVip$1 = (BrandSplashPreviewFragment$handleByVip$1) continuation;
            if ((brandSplashPreviewFragment$handleByVip$1.label & Integer.MIN_VALUE) != 0) {
                brandSplashPreviewFragment$handleByVip$1.label -= Integer.MIN_VALUE;
                Object $result = brandSplashPreviewFragment$handleByVip$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (brandSplashPreviewFragment$handleByVip$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        VipPrivilegeType vipPrivilegeType = VipPrivilegeType.LaunchSplash;
                        Object obj = ServicesProvider.DefaultImpls.get$default(BLRouter.INSTANCE.getServices(IBiliVipPaymentCombineService.class), (String) null, 1, (Object) null);
                        Intrinsics.checkNotNull(obj);
                        FragmentManager childFragmentManager = getChildFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                        brandSplashPreviewFragment$handleByVip$1.label = 1;
                        buyVipResult = IBiliVipPaymentCombineService.-CC.buyVip-hUnOzRk$default((IBiliVipPaymentCombineService) obj, childFragmentManager, vipPrivilegeType, BrandSplashConstKt.BRAND_SPLASH_SETTING_SPMID, "vip.membership-purchase.open-pop-up.0.click", (Function0) null, brandSplashPreviewFragment$handleByVip$1, 16, (Object) null);
                        if (buyVipResult == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        brandSplashPreviewFragment = this;
                        break;
                    case 1:
                        brandSplashPreviewFragment = this;
                        ResultKt.throwOnFailure($result);
                        buyVipResult = ((Result) $result).unbox-impl();
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (Result.isSuccess-impl(buyVipResult)) {
                    Unit unit = (Unit) buyVipResult;
                    BrandSplashSettingData brandSplashSettingData = (BrandSplashSettingData) brandSplashPreviewFragment.getVm().getBrandSplashData().getValue();
                    if (brandSplashSettingData != null && (setOption2 = brandSplashSettingData.getSetOption()) != null && (vipConfig2 = setOption2.getVipConfig()) != null) {
                        vipConfig2.setLocked(false);
                    }
                    BrandSplashSettingData brandSplashSettingData2 = (BrandSplashSettingData) brandSplashPreviewFragment.getVm().getBrandSplashData().getValue();
                    if (brandSplashSettingData2 != null && (setOption = brandSplashSettingData2.getSetOption()) != null && (vipConfig = setOption.getVipConfig()) != null) {
                        vipConfig.setVipOrderPromotion(false);
                    }
                }
                th = Result.exceptionOrNull-impl(buyVipResult);
                if (th != null && !Intrinsics.areEqual(th, VipPaymentCombineException.PayTipsContinue.INSTANCE)) {
                    Intrinsics.areEqual(th, VipPaymentCombineException.PayTipsCancel.INSTANCE);
                }
                return Unit.INSTANCE;
            }
        }
        brandSplashPreviewFragment$handleByVip$1 = new BrandSplashPreviewFragment$handleByVip$1(this, continuation);
        Object $result2 = brandSplashPreviewFragment$handleByVip$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (brandSplashPreviewFragment$handleByVip$1.label) {
        }
        if (Result.isSuccess-impl(buyVipResult)) {
        }
        th = Result.exceptionOrNull-impl(buyVipResult);
        if (th != null) {
            Intrinsics.areEqual(th, VipPaymentCombineException.PayTipsCancel.INSTANCE);
        }
        return Unit.INSTANCE;
    }
}