package tv.danmaku.bili.ui.splash.brand.uiv2.setting;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingConfig;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel;
import tv.danmaku.bili.ui.splash.databinding.BiliAppListBrandSplashSettingFragmentBinding;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrandSplashSettingFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment$initView$8", f = "BrandSplashSettingFragment.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BrandSplashSettingFragment$initView$8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BrandSplashSettingFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrandSplashSettingFragment$initView$8(BrandSplashSettingFragment brandSplashSettingFragment, Continuation<? super BrandSplashSettingFragment$initView$8> continuation) {
        super(2, continuation);
        this.this$0 = brandSplashSettingFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrandSplashSettingFragment$initView$8(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BrandSplashSettingFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingConfig;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment$initView$8$1", f = "BrandSplashSettingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment$initView$8$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<List<? extends BrandSplashSettingConfig>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BrandSplashSettingFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BrandSplashSettingFragment brandSplashSettingFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = brandSplashSettingFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(List<BrandSplashSettingConfig> list, Continuation<? super Unit> continuation) {
            return create(list, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            BiliAppListBrandSplashSettingFragmentBinding binding;
            BiliAppListBrandSplashSettingFragmentBinding binding2;
            BiliAppListBrandSplashSettingFragmentBinding binding3;
            BiliAppListBrandSplashSettingFragmentBinding binding4;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    List it = (List) this.L$0;
                    if (!it.isEmpty()) {
                        String title = ((BrandSplashSettingConfig) it.get(0)).getTitle();
                        if (!(title == null || title.length() == 0)) {
                            binding2 = this.this$0.getBinding();
                            binding2.modeSettingAreaContainer.setVisibility(0);
                            binding3 = this.this$0.getBinding();
                            binding3.modeSettingArea.defaultModeTitle.setText(((BrandSplashSettingConfig) it.get(0)).getTitle());
                            binding4 = this.this$0.getBinding();
                            binding4.modeSettingArea.defaultSubTitle.setText(((BrandSplashSettingConfig) it.get(0)).getSubTitle());
                            return Unit.INSTANCE;
                        }
                    }
                    binding = this.this$0.getBinding();
                    binding.modeSettingAreaContainer.setVisibility(8);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
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
                if (FlowKt.collectLatest(vm.getOptions(), new AnonymousClass1(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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