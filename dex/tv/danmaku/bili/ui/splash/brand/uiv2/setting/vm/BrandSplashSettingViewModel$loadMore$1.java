package tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm;

import java.util.List;
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
import kotlinx.coroutines.flow.MutableStateFlow;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingData;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingMoreData;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingPageMore;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingTab;
import tv.danmaku.bili.ui.splash.brand.service.BrandSplashServiceHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrandSplashSettingViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$loadMore$1", f = "BrandSplashSettingViewModel.kt", i = {1, 1}, l = {402, 408}, m = "invokeSuspend", n = {"tab", "newSectionList"}, s = {"L$2", "L$3"}, v = 1)
public final class BrandSplashSettingViewModel$loadMore$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BrandSplashSettingPageMore $page;
    final /* synthetic */ String $source;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ BrandSplashSettingViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrandSplashSettingViewModel$loadMore$1(String str, BrandSplashSettingPageMore brandSplashSettingPageMore, BrandSplashSettingViewModel brandSplashSettingViewModel, Continuation<? super BrandSplashSettingViewModel$loadMore$1> continuation) {
        super(2, continuation);
        this.$source = str;
        this.$page = brandSplashSettingPageMore;
        this.this$0 = brandSplashSettingViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrandSplashSettingViewModel$loadMore$1(this.$source, this.$page, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object fetchNextPage;
        Object $result2;
        BrandSplashSettingTab tab;
        BrandSplashSettingViewModel brandSplashSettingViewModel;
        String str;
        BrandSplashSettingTab tab2;
        Object updateNewReceiveSectionSelectedState;
        List newSectionList;
        BrandSplashSettingData copyBrandSplashData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                fetchNextPage = BrandSplashServiceHelper.INSTANCE.fetchNextPage(this.$source, this.$page.getLastSplashBizId(), this.$page.getGroupNo(), this.$page.getType(), (r17 & 16) != 0 ? "" : null, (Continuation) this);
                if (fetchNextPage != coroutine_suspended) {
                    $result2 = $result;
                    $result = fetchNextPage;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                break;
            case 2:
                newSectionList = (List) this.L$3;
                tab2 = (BrandSplashSettingTab) this.L$2;
                str = (String) this.L$1;
                brandSplashSettingViewModel = (BrandSplashSettingViewModel) this.L$0;
                ResultKt.throwOnFailure($result);
                MutableStateFlow<BrandSplashSettingData> brandSplashData = brandSplashSettingViewModel.getBrandSplashData();
                copyBrandSplashData = brandSplashSettingViewModel.copyBrandSplashData(newSectionList, tab2.getPage(), str);
                brandSplashData.setValue(copyBrandSplashData);
                this.this$0.loadingMore = false;
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        BrandSplashSettingMoreData brandSplashSettingMoreData = (BrandSplashSettingMoreData) $result;
        if (brandSplashSettingMoreData != null && (tab = brandSplashSettingMoreData.getTab()) != null) {
            brandSplashSettingViewModel = this.this$0;
            str = this.$source;
            tab2 = tab;
            brandSplashSettingViewModel.loadingMore = false;
            List newSectionList2 = tab2.getSections();
            if (newSectionList2 == null) {
                return Unit.INSTANCE;
            }
            if (!Intrinsics.areEqual(tab2.getSource(), str) || newSectionList2.isEmpty() || tab2.getPage() == null) {
                return Unit.INSTANCE;
            }
            this.L$0 = brandSplashSettingViewModel;
            this.L$1 = str;
            this.L$2 = tab2;
            this.L$3 = newSectionList2;
            this.label = 2;
            updateNewReceiveSectionSelectedState = brandSplashSettingViewModel.updateNewReceiveSectionSelectedState(newSectionList2, this);
            if (updateNewReceiveSectionSelectedState == coroutine_suspended) {
                return coroutine_suspended;
            }
            $result = $result2;
            newSectionList = newSectionList2;
            MutableStateFlow<BrandSplashSettingData> brandSplashData2 = brandSplashSettingViewModel.getBrandSplashData();
            copyBrandSplashData = brandSplashSettingViewModel.copyBrandSplashData(newSectionList, tab2.getPage(), str);
            brandSplashData2.setValue(copyBrandSplashData);
        }
        this.this$0.loadingMore = false;
        return Unit.INSTANCE;
    }
}