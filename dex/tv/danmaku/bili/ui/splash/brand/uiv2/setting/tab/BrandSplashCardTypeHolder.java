package tv.danmaku.bili.ui.splash.brand.uiv2.setting.tab;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.theme.R;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplashKt;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSource;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel;
import tv.danmaku.bili.ui.splash.databinding.BiliAppListBrandSplashCardItemBinding;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashCardTypeHolder.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/tab/BrandSplashCardTypeHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Ltv/danmaku/bili/ui/splash/databinding/BiliAppListBrandSplashCardItemBinding;", "<init>", "(Ltv/danmaku/bili/ui/splash/databinding/BiliAppListBrandSplashCardItemBinding;)V", "getBinding", "()Ltv/danmaku/bili/ui/splash/databinding/BiliAppListBrandSplashCardItemBinding;", "bind", "", "data", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplash;", "fragment", "Landroidx/fragment/app/Fragment;", "payloads", "", "", "splash_debug", "vm", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/BrandSplashSettingViewModel;"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashCardTypeHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final BiliAppListBrandSplashCardItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrandSplashCardTypeHolder(BiliAppListBrandSplashCardItemBinding binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final BiliAppListBrandSplashCardItemBinding getBinding() {
        return this.binding;
    }

    public final void bind(final BrandSplash data, final Fragment fragment, List<? extends Object> list) {
        Resources resources;
        int i;
        int selectedBgResourceId;
        EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (Intrinsics.areEqual(data.getSource(), BrandSplashSource.VIP.getValue()) || Intrinsics.areEqual(data.getSource(), BrandSplashSource.DLC.getValue())) {
            ViewGroup.LayoutParams layoutParams = this.binding.brandContainer.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) layoutParams;
            lp.width = ListExtentionsKt.toPx(105);
            lp.height = -1;
            this.binding.brandContainer.setLayoutParams(lp);
        }
        if (data.isSelected() && data.isCustomModeOn()) {
            resources = this.binding.getRoot().getResources();
            i = R.color.Brand_pink;
        } else {
            resources = this.binding.getRoot().getResources();
            i = R.color.Bg3;
        }
        int outlineColor = resources.getColor(i);
        Drawable bg = this.binding.cardOutline.getBackground();
        bg.setTint(outlineColor);
        this.binding.cardOutline.setBackground(bg);
        this.binding.selectClickArea.setVisibility(data.isCustomModeOn() ? 0 : 8);
        this.binding.selectBtn.setSelected(data.isSelected());
        if (data.isSelected() && data.isCustomModeOn()) {
            selectedBgResourceId = tv.danmaku.bili.ui.splash.R.drawable.ic_brand_splash_selected;
        } else {
            selectedBgResourceId = data.isDisabled() ? tv.danmaku.bili.ui.splash.R.drawable.ic_brand_splash_select_btn_disable : tv.danmaku.bili.ui.splash.R.drawable.selector_brand_splash_select_btn;
        }
        this.binding.selectBtn.setBackgroundResource(selectedBgResourceId);
        this.binding.selectClickArea.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.tab.BrandSplashCardTypeHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BrandSplashCardTypeHolder.bind$lambda$0(fragment, data, view2);
            }
        });
        this.binding.title.setText(data.getThumbName());
        String localRes = BrandSplashKt.loadLocalImagePath(data);
        BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
        Context context = this.binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ImageRequestBuilder url = biliImageLoader.with(context).url(localRes == null ? data.getThumb() : localRes);
        BiliImageView biliImageView = this.binding.brandImage;
        Intrinsics.checkNotNullExpressionValue(biliImageView, "brandImage");
        url.into(biliImageView);
        this.binding.brandContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.tab.BrandSplashCardTypeHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BrandSplashCardTypeHolder.bind$lambda$1(fragment, data, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0(final Fragment $fragment, BrandSplash $data, View it) {
        Lazy vm$delegate = FragmentViewModelLazyKt.createViewModelLazy($fragment, Reflection.getOrCreateKotlinClass(BrandSplashSettingViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.tab.BrandSplashCardTypeHolder$bind$lambda$0$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m1610invoke() {
                return $fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.tab.BrandSplashCardTypeHolder$bind$lambda$0$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m1611invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r2;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.tab.BrandSplashCardTypeHolder$bind$lambda$0$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelProvider.Factory m1612invoke() {
                return $fragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        BrandSplashSettingViewModel bind$lambda$0$0 = bind$lambda$0$0(vm$delegate);
        FragmentManager childFragmentManager = $fragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        bind$lambda$0$0.selectCard($data, childFragmentManager);
    }

    private static final BrandSplashSettingViewModel bind$lambda$0$0(Lazy<BrandSplashSettingViewModel> lazy) {
        return (BrandSplashSettingViewModel) lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1(final Fragment $fragment, BrandSplash $data, View it) {
        Lazy vm$delegate = FragmentViewModelLazyKt.createViewModelLazy($fragment, Reflection.getOrCreateKotlinClass(BrandSplashSettingViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.tab.BrandSplashCardTypeHolder$bind$lambda$1$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m1613invoke() {
                return $fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.tab.BrandSplashCardTypeHolder$bind$lambda$1$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m1614invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r2;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.tab.BrandSplashCardTypeHolder$bind$lambda$1$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelProvider.Factory m1615invoke() {
                return $fragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        bind$lambda$1$0(vm$delegate).openPreviewPage($data, false);
    }

    private static final BrandSplashSettingViewModel bind$lambda$1$0(Lazy<BrandSplashSettingViewModel> lazy) {
        return (BrandSplashSettingViewModel) lazy.getValue();
    }
}