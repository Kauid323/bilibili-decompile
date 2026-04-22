package tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.lib.homepage.MainImageExtension;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.bean.BaseImageDataSubscriber;
import com.bilibili.lib.image2.bean.DecodedImageHolder;
import com.bilibili.lib.image2.bean.ImageDataSource;
import com.bilibili.lib.image2.bean.StaticBitmapImageHolder;
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
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel;
import tv.danmaku.bili.ui.splash.databinding.BiliAppListBrandSplashPreviewItemViewBinding;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashPreviewAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J \u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0018H\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/preview/BrandSplashPreviewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/preview/BrandSplashPreviewViewHolder;", "dataList", "", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplash;", "fragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Ljava/util/List;Landroidx/fragment/app/Fragment;)V", "getDataList", "()Ljava/util/List;", "getFragment", "()Landroidx/fragment/app/Fragment;", "vm", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/BrandSplashSettingViewModel;", "getVm", "()Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/BrandSplashSettingViewModel;", "vm$delegate", "Lkotlin/Lazy;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "onBind", "data", "initLogo", "logoResId", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashPreviewAdapter extends RecyclerView.Adapter<BrandSplashPreviewViewHolder> {
    public static final int $stable = 8;
    private final List<BrandSplash> dataList;
    private final Fragment fragment;
    private final Lazy vm$delegate;

    public BrandSplashPreviewAdapter(List<BrandSplash> list, Fragment fragment) {
        List dataList = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.dataList = dataList;
        this.fragment = fragment;
        final Fragment $this$activityViewModels_u24default$iv = this.fragment;
        this.vm$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$activityViewModels_u24default$iv, Reflection.getOrCreateKotlinClass(BrandSplashSettingViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview.BrandSplashPreviewAdapter$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m1579invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview.BrandSplashPreviewAdapter$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m1580invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r2;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview.BrandSplashPreviewAdapter$special$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelProvider.Factory m1581invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    public final List<BrandSplash> getDataList() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.dataList);
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    private final BrandSplashSettingViewModel getVm() {
        return (BrandSplashSettingViewModel) this.vm$delegate.getValue();
    }

    public BrandSplashPreviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        BiliAppListBrandSplashPreviewItemViewBinding bind = BiliAppListBrandSplashPreviewItemViewBinding.bind(LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_list_brand_splash_preview_item_view, parent, false));
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        return new BrandSplashPreviewViewHolder(bind);
    }

    public int getItemCount() {
        return this.dataList.size();
    }

    public void onBindViewHolder(BrandSplashPreviewViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        onBind(holder, this.dataList.get(position));
    }

    private final void onBind(BrandSplashPreviewViewHolder holder, BrandSplash data) {
        BiliImageView splashImageView;
        if (Intrinsics.areEqual(data.getMode(), BrandSplashKt.MODE_FULL)) {
            holder.getBinding().brandSplash.setVisibility(8);
            holder.getBinding().fullBrandSplash.setVisibility(0);
            splashImageView = holder.getBinding().fullBrandSplash;
        } else {
            holder.getBinding().brandSplash.setVisibility(0);
            holder.getBinding().fullBrandSplash.setVisibility(8);
            splashImageView = holder.getBinding().brandSplash;
        }
        Intrinsics.checkNotNull(splashImageView);
        String localRes = BrandSplashKt.loadLocalImagePath(data);
        BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
        Context context = holder.getBinding().getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        biliImageLoader.with(context).url(localRes == null ? data.getThumb() : localRes).into(splashImageView);
        int logoResId = Intrinsics.areEqual(data.getMode(), BrandSplashKt.MODE_FULL) ? R.drawable.ic_logo_full_brand_default : R.drawable.ic_logo_default;
        holder.getBinding().brandLogo.setImageResource(logoResId);
        holder.getBinding().brandLogo.setVisibility(data.getShowLogo() ? 0 : 8);
        holder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview.BrandSplashPreviewAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BrandSplashPreviewAdapter.onBind$lambda$0(BrandSplashPreviewAdapter.this, view2);
            }
        });
        initLogo(holder, data, logoResId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBind$lambda$0(BrandSplashPreviewAdapter this$0, View it) {
        this$0.getVm().getFullPreviewMode().setValue(Boolean.valueOf(!((Boolean) this$0.getVm().getFullPreviewMode().getValue()).booleanValue()));
    }

    private final void initLogo(final BrandSplashPreviewViewHolder holder, BrandSplash data, final int logoResId) {
        String logoUrl = data.getLogoUrl();
        if (logoUrl != null && !TextUtils.isEmpty(logoUrl)) {
            BiliImageLoader.INSTANCE.acquire(this.fragment).with(360, 180).asDecodedImage().thumbnailUrlTransformStrategy(MainImageExtension.getThumbnailUrlTransformStrategy(0, 0, false)).url(logoUrl).submit().subscribe(new BaseImageDataSubscriber<DecodedImageHolder<?>>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview.BrandSplashPreviewAdapter$initLogo$1
                protected void onNewResultImpl(ImageDataSource<DecodedImageHolder<?>> imageDataSource) {
                    if (imageDataSource != null && imageDataSource.getResult() != null) {
                        Object result = imageDataSource.getResult();
                        Intrinsics.checkNotNull(result);
                        StaticBitmapImageHolder staticBitmapImageHolder = (DecodedImageHolder) result;
                        if (staticBitmapImageHolder instanceof StaticBitmapImageHolder) {
                            Bitmap bitmap = staticBitmapImageHolder.get();
                            if (bitmap == null || bitmap.isRecycled()) {
                                BrandSplashPreviewViewHolder.this.getBinding().brandLogo.setImageResource(logoResId);
                            } else {
                                BrandSplashPreviewViewHolder.this.getBinding().brandLogo.setImageBitmap(bitmap);
                            }
                        }
                    }
                }

                protected void onFailureImpl(ImageDataSource<DecodedImageHolder<?>> imageDataSource) {
                    BrandSplashPreviewViewHolder.this.getBinding().brandLogo.setImageResource(logoResId);
                }
            });
        }
    }
}