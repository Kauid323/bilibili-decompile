package tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrandSplashSettingViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel", f = "BrandSplashSettingViewModel.kt", i = {0, 0}, l = {366}, m = "updateNewReceiveSectionSelectedState", n = {"newSections", "isOnCustomMode"}, s = {"L$0", "Z$0"}, v = 1)
public final class BrandSplashSettingViewModel$updateNewReceiveSectionSelectedState$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BrandSplashSettingViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrandSplashSettingViewModel$updateNewReceiveSectionSelectedState$1(BrandSplashSettingViewModel brandSplashSettingViewModel, Continuation<? super BrandSplashSettingViewModel$updateNewReceiveSectionSelectedState$1> continuation) {
        super(continuation);
        this.this$0 = brandSplashSettingViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object updateNewReceiveSectionSelectedState;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        updateNewReceiveSectionSelectedState = this.this$0.updateNewReceiveSectionSelectedState(null, (Continuation) this);
        return updateNewReceiveSectionSelectedState;
    }
}