package tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.model.CustomModeState;
import tv.danmaku.bili.ui.splash.utils.LoadingState;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSettingViewModel.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\n"}, d2 = {"<anonymous>", "", "loadingState", "Ltv/danmaku/bili/ui/splash/utils/LoadingState;", "customMode", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/model/CustomModeState;", "fullPreviewMode", "previewPageEntryItem", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplash;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$floatButtonShowState$1", f = "BrandSplashSettingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BrandSplashSettingViewModel$floatButtonShowState$1 extends SuspendLambda implements Function5<LoadingState, CustomModeState, Boolean, BrandSplash, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    /* synthetic */ boolean Z$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BrandSplashSettingViewModel$floatButtonShowState$1(Continuation<? super BrandSplashSettingViewModel$floatButtonShowState$1> continuation) {
        super(5, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return invoke((LoadingState) obj, (CustomModeState) obj2, ((Boolean) obj3).booleanValue(), (BrandSplash) obj4, (Continuation) obj5);
    }

    public final Object invoke(LoadingState loadingState, CustomModeState customModeState, boolean z, BrandSplash brandSplash, Continuation<? super Boolean> continuation) {
        BrandSplashSettingViewModel$floatButtonShowState$1 brandSplashSettingViewModel$floatButtonShowState$1 = new BrandSplashSettingViewModel$floatButtonShowState$1(continuation);
        brandSplashSettingViewModel$floatButtonShowState$1.L$0 = loadingState;
        brandSplashSettingViewModel$floatButtonShowState$1.L$1 = customModeState;
        brandSplashSettingViewModel$floatButtonShowState$1.Z$0 = z;
        brandSplashSettingViewModel$floatButtonShowState$1.L$2 = brandSplash;
        return brandSplashSettingViewModel$floatButtonShowState$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                LoadingState loadingState = (LoadingState) this.L$0;
                CustomModeState customMode = (CustomModeState) this.L$1;
                boolean fullPreviewMode = this.Z$0;
                BrandSplash previewPageEntryItem = (BrandSplash) this.L$2;
                boolean z = false;
                if (Intrinsics.areEqual(loadingState, LoadingState.Complete.INSTANCE)) {
                    if (customMode.getCustomMode() && !fullPreviewMode) {
                        z = true;
                    } else if (!fullPreviewMode && previewPageEntryItem != null) {
                        z = true;
                    }
                }
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}