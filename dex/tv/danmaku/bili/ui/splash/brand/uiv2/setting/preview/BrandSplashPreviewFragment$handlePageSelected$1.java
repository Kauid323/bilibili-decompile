package tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview;

import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.bili.ui.splash.databinding.BiliAppListBrandSplashPreviewFragmentBinding;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrandSplashPreviewFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview.BrandSplashPreviewFragment$handlePageSelected$1", f = "BrandSplashPreviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BrandSplashPreviewFragment$handlePageSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BrandSplash $data;
    int label;
    final /* synthetic */ BrandSplashPreviewFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrandSplashPreviewFragment$handlePageSelected$1(BrandSplashPreviewFragment brandSplashPreviewFragment, BrandSplash brandSplash, Continuation<? super BrandSplashPreviewFragment$handlePageSelected$1> continuation) {
        super(2, continuation);
        this.this$0 = brandSplashPreviewFragment;
        this.$data = brandSplash;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrandSplashPreviewFragment$handlePageSelected$1(this.this$0, this.$data, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        BiliAppListBrandSplashPreviewFragmentBinding binding;
        BiliAppListBrandSplashPreviewFragmentBinding binding2;
        BiliAppListBrandSplashPreviewFragmentBinding binding3;
        BiliAppListBrandSplashPreviewFragmentBinding binding4;
        BiliAppListBrandSplashPreviewFragmentBinding binding5;
        BiliAppListBrandSplashPreviewFragmentBinding binding6;
        BiliAppListBrandSplashPreviewFragmentBinding binding7;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                binding = this.this$0.getBinding();
                binding.brandSplashPreviewImageTitle.setText(this.$data.getThumbName());
                binding2 = this.this$0.getBinding();
                binding2.brandSplashPreviewSelectBtn.setSelected(this.$data.isSelected());
                if (this.$data.isSelected() && this.$data.isCustomModeOn()) {
                    binding7 = this.this$0.getBinding();
                    binding7.brandSplashPreviewSelectBtn.setBackgroundResource(R.drawable.ic_brand_splash_selected);
                    return Unit.INSTANCE;
                }
                if (this.$data.isDisabled()) {
                    binding5 = this.this$0.getBinding();
                    binding5.brandSplashPreviewSelect.setTextColor(ContextCompat.getColor(this.this$0.requireContext(), com.bilibili.lib.theme.R.color.Text4));
                    binding6 = this.this$0.getBinding();
                    binding6.brandSplashPreviewSelectBtn.setBackgroundResource(R.drawable.ic_brand_splash_select_btn_disable);
                } else {
                    binding3 = this.this$0.getBinding();
                    binding3.brandSplashPreviewSelect.setTextColor(ContextCompat.getColor(this.this$0.requireContext(), com.bilibili.lib.theme.R.color.Text1));
                    binding4 = this.this$0.getBinding();
                    binding4.brandSplashPreviewSelectBtn.setBackgroundResource(R.drawable.ic_brand_splash_unselect);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}