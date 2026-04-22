package tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSettingViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/FloatUiState;", "selectedSplash", "", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplash;", "unSave", ""}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$floatUiState$1", f = "BrandSplashSettingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BrandSplashSettingViewModel$floatUiState$1 extends SuspendLambda implements Function3<List<? extends BrandSplash>, Boolean, Continuation<? super FloatUiState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BrandSplashSettingViewModel$floatUiState$1(Continuation<? super BrandSplashSettingViewModel$floatUiState$1> continuation) {
        super(3, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((List) obj, ((Boolean) obj2).booleanValue(), (Continuation) obj3);
    }

    public final Object invoke(List<BrandSplash> list, boolean z, Continuation<? super FloatUiState> continuation) {
        BrandSplashSettingViewModel$floatUiState$1 brandSplashSettingViewModel$floatUiState$1 = new BrandSplashSettingViewModel$floatUiState$1(continuation);
        brandSplashSettingViewModel$floatUiState$1.L$0 = list;
        brandSplashSettingViewModel$floatUiState$1.Z$0 = z;
        return brandSplashSettingViewModel$floatUiState$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                List selectedSplash = (List) this.L$0;
                boolean unSave = this.Z$0;
                boolean z = false;
                FloatUiState floatUiState = new FloatUiState(false, 0, 3, null);
                int size = selectedSplash.size();
                if (unSave) {
                    if ((!selectedSplash.isEmpty() ? 1 : null) != null) {
                        z = true;
                    }
                }
                return floatUiState.copy(z, size);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}