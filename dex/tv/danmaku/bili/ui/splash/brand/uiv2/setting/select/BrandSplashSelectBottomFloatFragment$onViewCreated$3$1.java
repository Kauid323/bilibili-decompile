package tv.danmaku.bili.ui.splash.brand.uiv2.setting.select;

import com.bilibili.app.comm.list.common.widget.PromoToast;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSetOption;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingData;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.FloatUiState;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrandSplashSelectBottomFloatFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectBottomFloatFragment$onViewCreated$3$1", f = "BrandSplashSelectBottomFloatFragment.kt", i = {}, l = {53, 59}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BrandSplashSelectBottomFloatFragment$onViewCreated$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BrandSplashSelectBottomFloatFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrandSplashSelectBottomFloatFragment$onViewCreated$3$1(BrandSplashSelectBottomFloatFragment brandSplashSelectBottomFloatFragment, Continuation<? super BrandSplashSelectBottomFloatFragment$onViewCreated$3$1> continuation) {
        super(2, continuation);
        this.this$0 = brandSplashSelectBottomFloatFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrandSplashSelectBottomFloatFragment$onViewCreated$3$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        BrandSplashSettingViewModel vm;
        BrandSplashSettingViewModel vm2;
        BrandSplashSettingViewModel vm3;
        BrandSplashSetOption setOption;
        String emptyToast;
        BrandSplashSettingViewModel vm4;
        BrandSplashSettingViewModel vm5;
        BrandSplashSettingViewModel vm6;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                vm = this.this$0.getVm();
                this.label = 1;
                Object first = FlowKt.first(vm.getSelectedSplash(), (Continuation) this);
                if (first == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result = first;
                if (!((List) $result).isEmpty()) {
                    vm3 = this.this$0.getVm();
                    BrandSplashSettingData brandSplashSettingData = (BrandSplashSettingData) vm3.getBrandSplashData().getValue();
                    String it = (brandSplashSettingData == null || (setOption = brandSplashSettingData.getSetOption()) == null || (emptyToast = setOption.getEmptyToast()) == null) ? null : ListExtentionsKt.takeIfNotBlank(emptyToast);
                    PromoToast.showMidToast(this.this$0.getContext(), it);
                    return Unit.INSTANCE;
                }
                vm2 = this.this$0.getVm();
                this.label = 2;
                $result = FlowKt.first(vm2.getFloatUiState(), (Continuation) this);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (!((FloatUiState) $result).getSaveButtonEnable()) {
                    vm4 = this.this$0.getVm();
                    vm4.saveCustomSplash();
                    vm5 = this.this$0.getVm();
                    vm5.isFloatSelectWindowSelect().setValue(Boxing.boxBoolean(false));
                    vm6 = this.this$0.getVm();
                    vm6.getUnSaveState().setValue(Boxing.boxBoolean(false));
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                if (!((List) $result).isEmpty()) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                if (!((FloatUiState) $result).getSaveButtonEnable()) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}