package tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplashKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSettingViewModel.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\n"}, d2 = {"<anonymous>", "", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplash;", "selected", "brandSplashFromRouter"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$selectedDisplayedSplash$1", f = "BrandSplashSettingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BrandSplashSettingViewModel$selectedDisplayedSplash$1 extends SuspendLambda implements Function3<List<? extends BrandSplash>, BrandSplash, Continuation<? super List<? extends BrandSplash>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BrandSplashSettingViewModel$selectedDisplayedSplash$1(Continuation<? super BrandSplashSettingViewModel$selectedDisplayedSplash$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(List<BrandSplash> list, BrandSplash brandSplash, Continuation<? super List<BrandSplash>> continuation) {
        BrandSplashSettingViewModel$selectedDisplayedSplash$1 brandSplashSettingViewModel$selectedDisplayedSplash$1 = new BrandSplashSettingViewModel$selectedDisplayedSplash$1(continuation);
        brandSplashSettingViewModel$selectedDisplayedSplash$1.L$0 = list;
        brandSplashSettingViewModel$selectedDisplayedSplash$1.L$1 = brandSplash;
        return brandSplashSettingViewModel$selectedDisplayedSplash$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Iterable selected = (List) this.L$0;
                BrandSplash brandSplashFromRouter = (BrandSplash) this.L$1;
                if (brandSplashFromRouter == null) {
                    return selected;
                }
                Iterable $this$any$iv = selected;
                boolean z = false;
                if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                    Iterator it = $this$any$iv.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object element$iv = it.next();
                            BrandSplash it2 = (BrandSplash) element$iv;
                            if (Intrinsics.areEqual(BrandSplashKt.getUniqueId(it2), BrandSplashKt.getUniqueId(brandSplashFromRouter))) {
                                z = true;
                            }
                        }
                    }
                }
                if (z) {
                    return selected;
                }
                ArrayList $this$invokeSuspend_u24lambda_u241 = new ArrayList();
                $this$invokeSuspend_u24lambda_u241.add(brandSplashFromRouter);
                $this$invokeSuspend_u24lambda_u241.addAll((Collection) selected);
                return $this$invokeSuspend_u24lambda_u241;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}