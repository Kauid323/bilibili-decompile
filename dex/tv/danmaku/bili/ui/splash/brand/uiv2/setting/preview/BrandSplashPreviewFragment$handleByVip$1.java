package tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrandSplashPreviewFragment.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview.BrandSplashPreviewFragment", f = "BrandSplashPreviewFragment.kt", i = {}, l = {233}, m = "handleByVip", n = {}, s = {}, v = 1)
public final class BrandSplashPreviewFragment$handleByVip$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BrandSplashPreviewFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrandSplashPreviewFragment$handleByVip$1(BrandSplashPreviewFragment brandSplashPreviewFragment, Continuation<? super BrandSplashPreviewFragment$handleByVip$1> continuation) {
        super(continuation);
        this.this$0 = brandSplashPreviewFragment;
    }

    public final Object invokeSuspend(Object obj) {
        Object handleByVip;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handleByVip = this.this$0.handleByVip((Continuation) this);
        return handleByVip;
    }
}