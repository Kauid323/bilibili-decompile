package tv.danmaku.bili.ui.splash.brand.uiv2.setting.select;

import com.bilibili.magicasakura.widgets.TintTextView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSetOption;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingData;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.FloatUiState;
import tv.danmaku.bili.ui.splash.databinding.BiliAppListBrandSplashBottomSelectFloatWindowBinding;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSelectBottomFloatFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectBottomFloatFragment$onViewCreated$5", f = "BrandSplashSelectBottomFloatFragment.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BrandSplashSelectBottomFloatFragment$onViewCreated$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BrandSplashSelectBottomFloatFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrandSplashSelectBottomFloatFragment$onViewCreated$5(BrandSplashSelectBottomFloatFragment brandSplashSelectBottomFloatFragment, Continuation<? super BrandSplashSelectBottomFloatFragment$onViewCreated$5> continuation) {
        super(2, continuation);
        this.this$0 = brandSplashSelectBottomFloatFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrandSplashSelectBottomFloatFragment$onViewCreated$5(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BrandSplashSelectBottomFloatFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/FloatUiState;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectBottomFloatFragment$onViewCreated$5$1", f = "BrandSplashSelectBottomFloatFragment.kt", i = {0}, l = {83}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectBottomFloatFragment$onViewCreated$5$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<FloatUiState, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ BrandSplashSelectBottomFloatFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BrandSplashSelectBottomFloatFragment brandSplashSelectBottomFloatFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = brandSplashSelectBottomFloatFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(FloatUiState floatUiState, Continuation<? super Unit> continuation) {
            return create(floatUiState, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            FloatUiState state;
            BiliAppListBrandSplashBottomSelectFloatWindowBinding biliAppListBrandSplashBottomSelectFloatWindowBinding;
            BiliAppListBrandSplashBottomSelectFloatWindowBinding biliAppListBrandSplashBottomSelectFloatWindowBinding2;
            BiliAppListBrandSplashBottomSelectFloatWindowBinding biliAppListBrandSplashBottomSelectFloatWindowBinding3;
            TintTextView tintTextView;
            BrandSplashSettingViewModel vm;
            BrandSplashSetOption option;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            String str = null;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    state = (FloatUiState) this.L$0;
                    biliAppListBrandSplashBottomSelectFloatWindowBinding = this.this$0.binding;
                    if (biliAppListBrandSplashBottomSelectFloatWindowBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        biliAppListBrandSplashBottomSelectFloatWindowBinding = null;
                    }
                    biliAppListBrandSplashBottomSelectFloatWindowBinding.tvSelectedCount.setText(String.valueOf(state.getSelectedCount()));
                    int resId = state.getSaveButtonEnable() ? R.drawable.bili_app_list_brand_setting_save_button_enable : R.drawable.bili_app_list_brand_setting_save_button_disable;
                    biliAppListBrandSplashBottomSelectFloatWindowBinding2 = this.this$0.binding;
                    if (biliAppListBrandSplashBottomSelectFloatWindowBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        biliAppListBrandSplashBottomSelectFloatWindowBinding2 = null;
                    }
                    biliAppListBrandSplashBottomSelectFloatWindowBinding2.tvSaveSelect.setBackgroundResource(resId);
                    biliAppListBrandSplashBottomSelectFloatWindowBinding3 = this.this$0.binding;
                    if (biliAppListBrandSplashBottomSelectFloatWindowBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        biliAppListBrandSplashBottomSelectFloatWindowBinding3 = null;
                    }
                    tintTextView = biliAppListBrandSplashBottomSelectFloatWindowBinding3.tvMaxPrompt;
                    vm = this.this$0.getVm();
                    this.L$0 = state;
                    this.L$1 = tintTextView;
                    this.label = 1;
                    Object first = FlowKt.first(vm.getBrandSplashData(), (Continuation) this);
                    if (first != coroutine_suspended) {
                        $result = first;
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    state = (FloatUiState) this.L$0;
                    ResultKt.throwOnFailure($result);
                    tintTextView = (TintTextView) this.L$1;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            BrandSplashSettingData brandSplashSettingData = (BrandSplashSettingData) $result;
            if (brandSplashSettingData != null && (option = brandSplashSettingData.getSetOption()) != null) {
                str = state.getSaveButtonEnable() ? option.getMaxPrompt() : option.getDefaultPrompt();
            }
            tintTextView.setText(str);
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object $result) {
        BrandSplashSettingViewModel vm;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                vm = this.this$0.getVm();
                this.label = 1;
                if (FlowKt.collectLatest(vm.getFloatUiState(), new AnonymousClass1(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}