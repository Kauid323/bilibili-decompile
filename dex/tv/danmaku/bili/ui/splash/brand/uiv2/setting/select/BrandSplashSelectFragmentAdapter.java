package tv.danmaku.bili.ui.splash.brand.uiv2.setting.select;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.list.common.widget.PromoToast;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplashKt;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSetOption;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingData;
import tv.danmaku.bili.ui.splash.brand.reporter.BrandSplashReporter;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel;
import tv.danmaku.bili.ui.splash.databinding.BiliAppListBrandSplashCardItemSmallBinding;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: BrandSplashSelectFragmentAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0016H\u0016J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/select/BrandSplashSelectFragmentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/select/BrandSplashCardTypeSmallHolder;", "dataList", "", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplash;", "fragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Ljava/util/List;Landroidx/fragment/app/Fragment;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "vm", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/BrandSplashSettingViewModel;", "getVm", "()Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/BrandSplashSettingViewModel;", "vm$delegate", "Lkotlin/Lazy;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "updateBgColor", "isSelected", "", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashSelectFragmentAdapter extends RecyclerView.Adapter<BrandSplashCardTypeSmallHolder> {
    public static final int $stable = 8;
    private final List<BrandSplash> dataList;
    private final Fragment fragment;
    private final Lazy vm$delegate;

    public BrandSplashSelectFragmentAdapter(List<BrandSplash> list, Fragment fragment) {
        List dataList = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.dataList = dataList;
        this.fragment = fragment;
        final Fragment $this$activityViewModels_u24default$iv = this.fragment;
        this.vm$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$activityViewModels_u24default$iv, Reflection.getOrCreateKotlinClass(BrandSplashSettingViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectFragmentAdapter$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m1605invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectFragmentAdapter$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m1606invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r2;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectFragmentAdapter$special$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelProvider.Factory m1607invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    private final BrandSplashSettingViewModel getVm() {
        return (BrandSplashSettingViewModel) this.vm$delegate.getValue();
    }

    public BrandSplashCardTypeSmallHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        BiliAppListBrandSplashCardItemSmallBinding bind = BiliAppListBrandSplashCardItemSmallBinding.bind(LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_list_brand_splash_card_item_small, parent, false));
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        return new BrandSplashCardTypeSmallHolder(bind);
    }

    public int getItemCount() {
        return this.dataList.size();
    }

    public void onBindViewHolder(final BrandSplashCardTypeSmallHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final BrandSplash data = this.dataList.get(position);
        holder.getBinding().title.setText(data.getThumbName());
        holder.getBinding().selectBtn.setSelected(data.isSelected());
        holder.getBinding().badge.setVisibility((!data.isToBeSet() || data.isSelected()) ? 8 : 0);
        updateBgColor(holder, holder.getBinding().selectBtn.isSelected());
        holder.getBinding().selectBtn.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectFragmentAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BrandSplashSelectFragmentAdapter.onBindViewHolder$lambda$0(BrandSplashSelectFragmentAdapter.this, holder, data, view2);
            }
        });
        holder.getBinding().title.setText(data.getThumbName());
        String localRes = BrandSplashKt.loadLocalImagePath(data);
        BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
        Context context = holder.getBinding().getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ImageRequestBuilder url = biliImageLoader.with(context).url(localRes == null ? data.getThumb() : localRes);
        BiliImageView biliImageView = holder.getBinding().brandImage;
        Intrinsics.checkNotNullExpressionValue(biliImageView, "brandImage");
        url.into(biliImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(BrandSplashSelectFragmentAdapter this$0, BrandSplashCardTypeSmallHolder $holder, BrandSplash $data, View it) {
        BrandSplash copy;
        BrandSplash copy2;
        BrandSplashSetOption setOption;
        String it2;
        if (this$0.getVm().getDisableSelect() && !$holder.getBinding().selectBtn.isSelected()) {
            BrandSplashSettingData brandSplashSettingData = (BrandSplashSettingData) this$0.getVm().getBrandSplashData().getValue();
            if (brandSplashSettingData != null && (setOption = brandSplashSettingData.getSetOption()) != null && (it2 = setOption.getOverflowToast()) != null) {
                if (!(it2.length() > 0)) {
                    it2 = null;
                }
                if (it2 != null) {
                    PromoToast.showMidToast(BiliContext.application(), it2);
                    return;
                }
                return;
            }
            return;
        }
        $holder.getBinding().selectBtn.setSelected(!$holder.getBinding().selectBtn.isSelected());
        this$0.updateBgColor($holder, $holder.getBinding().selectBtn.isSelected());
        BrandSplashReporter brandSplashReporter = BrandSplashReporter.INSTANCE;
        long id = $data.getId();
        String source = $data.getSource();
        if (source == null) {
            source = "";
        }
        brandSplashReporter.reportCustomBrandSplashClicked(id, source, $holder.getBinding().selectBtn.isSelected());
        BrandSplashSettingViewModel vm = this$0.getVm();
        copy = $data.copy((r30 & 1) != 0 ? $data.id : 0L, (r30 & 2) != 0 ? $data.thumb : null, (r30 & 4) != 0 ? $data.thumbHash : null, (r30 & 8) != 0 ? $data.thumbName : null, (r30 & 16) != 0 ? $data.logoUrl : null, (r30 & 32) != 0 ? $data.logoHash : null, (r30 & 64) != 0 ? $data.mode : null, (r30 & 128) != 0 ? $data.source : null, (r30 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? $data.showLogo : false, (r30 & 512) != 0 ? $data.isSelected : !$holder.getBinding().selectBtn.isSelected(), (r30 & 1024) != 0 ? $data.isDisabled : false, (r30 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? $data.isCustomModeOn : false, (r30 & 4096) != 0 ? $data.isToBeSet : false);
        copy2 = $data.copy((r30 & 1) != 0 ? $data.id : 0L, (r30 & 2) != 0 ? $data.thumb : null, (r30 & 4) != 0 ? $data.thumbHash : null, (r30 & 8) != 0 ? $data.thumbName : null, (r30 & 16) != 0 ? $data.logoUrl : null, (r30 & 32) != 0 ? $data.logoHash : null, (r30 & 64) != 0 ? $data.mode : null, (r30 & 128) != 0 ? $data.source : null, (r30 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? $data.showLogo : false, (r30 & 512) != 0 ? $data.isSelected : $holder.getBinding().selectBtn.isSelected(), (r30 & 1024) != 0 ? $data.isDisabled : false, (r30 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? $data.isCustomModeOn : false, (r30 & 4096) != 0 ? $data.isToBeSet : false);
        vm.updateItem(copy, copy2);
        this$0.getVm().getUnSaveState().setValue(true);
    }

    private final void updateBgColor(BrandSplashCardTypeSmallHolder holder, boolean isSelected) {
        int outlineColor = holder.getBinding().getRoot().getResources().getColor(isSelected ? com.bilibili.lib.theme.R.color.Brand_pink : com.bilibili.lib.theme.R.color.Bg3);
        Drawable bg = holder.getBinding().cardOutline.getBackground();
        bg.setTint(outlineColor);
    }
}