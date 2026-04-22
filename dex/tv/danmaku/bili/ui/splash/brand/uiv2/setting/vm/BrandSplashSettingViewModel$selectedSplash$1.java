package tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplashKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSettingViewModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplash;", "all", "", "saved"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$selectedSplash$1", f = "BrandSplashSettingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BrandSplashSettingViewModel$selectedSplash$1 extends SuspendLambda implements Function3<List<? extends BrandSplash>, List<? extends BrandSplash>, Continuation<? super List<BrandSplash>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BrandSplashSettingViewModel$selectedSplash$1(Continuation<? super BrandSplashSettingViewModel$selectedSplash$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(List<BrandSplash> list, List<BrandSplash> list2, Continuation<? super List<BrandSplash>> continuation) {
        BrandSplashSettingViewModel$selectedSplash$1 brandSplashSettingViewModel$selectedSplash$1 = new BrandSplashSettingViewModel$selectedSplash$1(continuation);
        brandSplashSettingViewModel$selectedSplash$1.L$0 = list;
        brandSplashSettingViewModel$selectedSplash$1.L$1 = list2;
        return brandSplashSettingViewModel$selectedSplash$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Iterable all = (List) this.L$0;
                Iterable saved = (List) this.L$1;
                Collection destination$iv$iv = new ArrayList();
                Iterator it = all.iterator();
                while (true) {
                    boolean z = true;
                    if (!it.hasNext()) {
                        Iterable selected = (List) destination$iv$iv;
                        Iterable $this$map$iv = selected;
                        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            destination$iv$iv2.add(BrandSplashKt.getUniqueId((BrandSplash) item$iv$iv));
                        }
                        Set selectedSet = CollectionsKt.toSet((List) destination$iv$iv2);
                        List selected2 = CollectionsKt.toMutableList((Collection) selected);
                        Iterable $this$filterTo$iv$iv = saved;
                        Collection destination$iv$iv3 = new ArrayList();
                        for (Object element$iv$iv : $this$filterTo$iv$iv) {
                            BrandSplash it2 = (BrandSplash) element$iv$iv;
                            if (((it2.isSelected() && it2.isCustomModeOn() && !selectedSet.contains(BrandSplashKt.getUniqueId(it2))) ? 1 : null) != null) {
                                destination$iv$iv3.add(element$iv$iv);
                            }
                        }
                        Iterable $this$forEach$iv = (List) destination$iv$iv3;
                        for (Object element$iv : $this$forEach$iv) {
                            BrandSplash splash = (BrandSplash) element$iv;
                            selected2.add(splash);
                        }
                        return selected2;
                    }
                    Object element$iv$iv2 = it.next();
                    BrandSplash it3 = (BrandSplash) element$iv$iv2;
                    if ((it3.isSelected() && it3.isCustomModeOn()) ? false : false) {
                        destination$iv$iv.add(element$iv$iv2);
                    }
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}