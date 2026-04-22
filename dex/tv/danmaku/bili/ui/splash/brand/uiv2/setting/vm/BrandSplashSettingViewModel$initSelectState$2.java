package tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.MutableStateFlow;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSetOption;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingData;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrandSplashSettingViewModel.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplash;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$initSelectState$2", f = "BrandSplashSettingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BrandSplashSettingViewModel$initSelectState$2 extends SuspendLambda implements Function2<List<? extends BrandSplash>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BrandSplashSettingViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrandSplashSettingViewModel$initSelectState$2(BrandSplashSettingViewModel brandSplashSettingViewModel, Continuation<? super BrandSplashSettingViewModel$initSelectState$2> continuation) {
        super(2, continuation);
        this.this$0 = brandSplashSettingViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> brandSplashSettingViewModel$initSelectState$2 = new BrandSplashSettingViewModel$initSelectState$2(this.this$0, continuation);
        brandSplashSettingViewModel$initSelectState$2.L$0 = obj;
        return brandSplashSettingViewModel$initSelectState$2;
    }

    public final Object invoke(List<BrandSplash> list, Continuation<? super Unit> continuation) {
        return create(list, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        BrandSplashSetOption setOption;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                List it = (List) this.L$0;
                BrandSplashSettingData brandSplashSettingData = (BrandSplashSettingData) this.this$0.getBrandSplashData().getValue();
                int maxSize = (brandSplashSettingData == null || (setOption = brandSplashSettingData.getSetOption()) == null) ? 12 : setOption.getMaxSelected();
                if (this.this$0.getDisableSelect() && it.size() < maxSize) {
                    this.this$0.updateDisableState(false);
                    this.this$0.setDisableSelect(false);
                    mutableStateFlow2 = this.this$0._disableSelectFlow;
                    mutableStateFlow2.setValue(Boxing.boxBoolean(false));
                } else if (!this.this$0.getDisableSelect() && it.size() >= maxSize) {
                    this.this$0.updateDisableState(true);
                    this.this$0.setDisableSelect(true);
                    mutableStateFlow = this.this$0._disableSelectFlow;
                    mutableStateFlow.setValue(Boxing.boxBoolean(true));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}