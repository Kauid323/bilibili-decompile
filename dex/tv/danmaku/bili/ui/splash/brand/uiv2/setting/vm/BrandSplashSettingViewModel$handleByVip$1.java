package tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm;

import androidx.fragment.app.FragmentManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.ServicesProvider;
import com.bilibili.vip.IBiliVipPaymentCombineService;
import com.bilibili.vip.VipPaymentCombineException;
import com.bilibili.vip.VipPrivilegeType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.ui.splash.brand.config.BrandSplashConstKt;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSetOption;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingData;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingVipConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrandSplashSettingViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$handleByVip$1", f = "BrandSplashSettingViewModel.kt", i = {}, l = {287}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BrandSplashSettingViewModel$handleByVip$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentManager $fragmentManager;
    int label;
    final /* synthetic */ BrandSplashSettingViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrandSplashSettingViewModel$handleByVip$1(FragmentManager fragmentManager, BrandSplashSettingViewModel brandSplashSettingViewModel, Continuation<? super BrandSplashSettingViewModel$handleByVip$1> continuation) {
        super(2, continuation);
        this.$fragmentManager = fragmentManager;
        this.this$0 = brandSplashSettingViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrandSplashSettingViewModel$handleByVip$1(this.$fragmentManager, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object buyVipResult;
        BrandSplashSetOption setOption;
        BrandSplashSettingVipConfig vipConfig;
        BrandSplashSetOption setOption2;
        BrandSplashSettingVipConfig vipConfig2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                VipPrivilegeType vipPrivilegeType = VipPrivilegeType.LaunchSplash;
                Object obj = ServicesProvider.DefaultImpls.get$default(BLRouter.INSTANCE.getServices(IBiliVipPaymentCombineService.class), (String) null, 1, (Object) null);
                Intrinsics.checkNotNull(obj);
                this.label = 1;
                Object obj2 = IBiliVipPaymentCombineService.-CC.buyVip-hUnOzRk$default((IBiliVipPaymentCombineService) obj, this.$fragmentManager, vipPrivilegeType, BrandSplashConstKt.BRAND_SPLASH_SETTING_SPMID, "vip.membership-purchase.open-pop-up.0.click", (Function0) null, (Continuation) this, 16, (Object) null);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                buyVipResult = obj2;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                buyVipResult = ((Result) $result).unbox-impl();
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        BrandSplashSettingViewModel brandSplashSettingViewModel = this.this$0;
        if (Result.isSuccess-impl(buyVipResult)) {
            Unit unit = (Unit) buyVipResult;
            BrandSplashSettingData brandSplashSettingData = (BrandSplashSettingData) brandSplashSettingViewModel.getBrandSplashData().getValue();
            if (brandSplashSettingData != null && (setOption2 = brandSplashSettingData.getSetOption()) != null && (vipConfig2 = setOption2.getVipConfig()) != null) {
                vipConfig2.setLocked(false);
            }
            BrandSplashSettingData brandSplashSettingData2 = (BrandSplashSettingData) brandSplashSettingViewModel.getBrandSplashData().getValue();
            if (brandSplashSettingData2 != null && (setOption = brandSplashSettingData2.getSetOption()) != null && (vipConfig = setOption.getVipConfig()) != null) {
                vipConfig.setVipOrderPromotion(false);
            }
        }
        Object buyVipResult2 = Result.exceptionOrNull-impl(buyVipResult);
        if (buyVipResult2 != null && !Intrinsics.areEqual(buyVipResult2, VipPaymentCombineException.PayTipsContinue.INSTANCE)) {
            Intrinsics.areEqual(buyVipResult2, VipPaymentCombineException.PayTipsCancel.INSTANCE);
        }
        return Unit.INSTANCE;
    }
}