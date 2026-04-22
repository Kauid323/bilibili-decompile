package tv.danmaku.bili.ui.splash.brand.uiv2.setting.select;

import com.bapis.bilibili.app.dynamic.v2.DynModuleType;
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
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel;
import tv.danmaku.bili.ui.splash.databinding.BiliAppListBrandSplashBottomSelectFloatWindowBinding;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSelectBottomFloatFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectBottomFloatFragment$onViewCreated$1", f = "BrandSplashSelectBottomFloatFragment.kt", i = {}, l = {DynModuleType.module_manga_collection_VALUE}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BrandSplashSelectBottomFloatFragment$onViewCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BrandSplashSelectBottomFloatFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrandSplashSelectBottomFloatFragment$onViewCreated$1(BrandSplashSelectBottomFloatFragment brandSplashSelectBottomFloatFragment, Continuation<? super BrandSplashSelectBottomFloatFragment$onViewCreated$1> continuation) {
        super(2, continuation);
        this.this$0 = brandSplashSelectBottomFloatFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrandSplashSelectBottomFloatFragment$onViewCreated$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BrandSplashSelectBottomFloatFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectBottomFloatFragment$onViewCreated$1$1", f = "BrandSplashSelectBottomFloatFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.splash.brand.uiv2.setting.select.BrandSplashSelectBottomFloatFragment$onViewCreated$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ BrandSplashSelectBottomFloatFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BrandSplashSelectBottomFloatFragment brandSplashSelectBottomFloatFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = brandSplashSelectBottomFloatFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.Z$0 = ((Boolean) obj).booleanValue();
            return anonymousClass1;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
        }

        public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
            return create(Boolean.valueOf(z), continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            BiliAppListBrandSplashBottomSelectFloatWindowBinding biliAppListBrandSplashBottomSelectFloatWindowBinding;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    boolean it = this.Z$0;
                    biliAppListBrandSplashBottomSelectFloatWindowBinding = this.this$0.binding;
                    if (biliAppListBrandSplashBottomSelectFloatWindowBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        biliAppListBrandSplashBottomSelectFloatWindowBinding = null;
                    }
                    biliAppListBrandSplashBottomSelectFloatWindowBinding.vArrow.setSelected(it);
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
                if (FlowKt.collectLatest(vm.isFloatSelectWindowSelect(), new AnonymousClass1(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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