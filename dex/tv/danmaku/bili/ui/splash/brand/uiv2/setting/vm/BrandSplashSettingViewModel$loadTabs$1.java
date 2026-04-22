package tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.ui.splash.brand.config.BrandSplashStorage;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSetOption;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingData;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingDataKt;
import tv.danmaku.bili.ui.splash.brand.service.BrandSplashServiceHelper;
import tv.danmaku.bili.ui.splash.utils.LoadingState;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrandSplashSettingViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$loadTabs$1", f = "BrandSplashSettingViewModel.kt", i = {}, l = {379, 391}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BrandSplashSettingViewModel$loadTabs$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BrandSplashSettingViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrandSplashSettingViewModel$loadTabs$1(BrandSplashSettingViewModel brandSplashSettingViewModel, Continuation<? super BrandSplashSettingViewModel$loadTabs$1> continuation) {
        super(2, continuation);
        this.this$0 = brandSplashSettingViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrandSplashSettingViewModel$loadTabs$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object $result2;
        BrandSplashSettingViewModel brandSplashSettingViewModel;
        BrandSplashSettingData data;
        Object initSelectState;
        BrandSplashSetOption setOption;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.this$0.getLoadingState().setValue(LoadingState.Loading.INSTANCE);
                this.label = 1;
                Object fetchSettingData = BrandSplashServiceHelper.INSTANCE.fetchSettingData((Continuation) this);
                if (fetchSettingData == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result = fetchSettingData;
                brandSplashSettingViewModel = this.this$0;
                data = (BrandSplashSettingData) $result;
                BrandSplashStorage.INSTANCE.updateMaxCustomBrandSplashCount((data != null || (setOption = data.getSetOption()) == null) ? 12 : setOption.getMaxSelected());
                if (data != null || !BrandSplashSettingDataKt.isValid(data)) {
                    brandSplashSettingViewModel.getLoadingState().setValue(new LoadingState.Error(new Throwable("data error")));
                    return Unit.INSTANCE;
                }
                brandSplashSettingViewModel.updateRemoteSelectedState(data);
                brandSplashSettingViewModel.getLoadingState().setValue(LoadingState.Complete.INSTANCE);
                brandSplashSettingViewModel.getBrandSplashData().setValue(data);
                brandSplashSettingViewModel.isFloatSelectWindowSelect().setValue(brandSplashSettingViewModel.isFloatSelectWindowSelect().getValue());
                this.label = 2;
                initSelectState = brandSplashSettingViewModel.initSelectState(this);
                return initSelectState == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                brandSplashSettingViewModel = this.this$0;
                data = (BrandSplashSettingData) $result;
                if (data != null) {
                    break;
                }
                BrandSplashStorage.INSTANCE.updateMaxCustomBrandSplashCount((data != null || (setOption = data.getSetOption()) == null) ? 12 : setOption.getMaxSelected());
                if (data != null) {
                    break;
                }
                brandSplashSettingViewModel.getLoadingState().setValue(new LoadingState.Error(new Throwable("data error")));
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}