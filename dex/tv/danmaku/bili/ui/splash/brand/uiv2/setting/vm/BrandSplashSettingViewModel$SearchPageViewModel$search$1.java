package tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingMoreData;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingPageMore;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingTab;
import tv.danmaku.bili.ui.splash.brand.service.BrandSplashServiceHelper;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel;
import tv.danmaku.bili.utils.vip.JsBridgeCallHandlerVip;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrandSplashSettingViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$SearchPageViewModel$search$1", f = "BrandSplashSettingViewModel.kt", i = {}, l = {539}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BrandSplashSettingViewModel$SearchPageViewModel$search$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BrandSplashSettingViewModel.SearchPageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrandSplashSettingViewModel$SearchPageViewModel$search$1(BrandSplashSettingViewModel.SearchPageViewModel searchPageViewModel, Continuation<? super BrandSplashSettingViewModel$SearchPageViewModel$search$1> continuation) {
        super(2, continuation);
        this.this$0 = searchPageViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrandSplashSettingViewModel$SearchPageViewModel$search$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        BrandSplashSettingPageMore brandSplashSettingPageMore;
        BrandSplashSettingPageMore brandSplashSettingPageMore2;
        BrandSplashSettingPageMore brandSplashSettingPageMore3;
        Function1 function1;
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                BrandSplashServiceHelper brandSplashServiceHelper = BrandSplashServiceHelper.INSTANCE;
                brandSplashSettingPageMore = this.this$0.lastPageMore;
                long lastSplashBizId = brandSplashSettingPageMore != null ? brandSplashSettingPageMore.getLastSplashBizId() : 0L;
                String str = (String) this.this$0.getSearchTerm().getValue();
                brandSplashSettingPageMore2 = this.this$0.lastPageMore;
                String str2 = (brandSplashSettingPageMore2 == null || (r1 = brandSplashSettingPageMore2.getGroupNo()) == null) ? "" : "";
                brandSplashSettingPageMore3 = this.this$0.lastPageMore;
                int type = brandSplashSettingPageMore3 != null ? brandSplashSettingPageMore3.getType() : 0;
                this.label = 1;
                Object fetchNextPage = brandSplashServiceHelper.fetchNextPage(JsBridgeCallHandlerVip.VIP_NAME_SPACE, lastSplashBizId, str2, type, str, (Continuation) this);
                if (fetchNextPage != coroutine_suspended) {
                    $result = fetchNextPage;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        BrandSplashSettingMoreData data = (BrandSplashSettingMoreData) $result;
        if (data == null) {
            this.this$0.searchPageLoading = false;
        } else {
            BrandSplashSettingTab tab = data.getTab();
            if (tab != null) {
                BrandSplashSettingViewModel.SearchPageViewModel searchPageViewModel = this.this$0;
                List newSectionList = tab.getSections();
                if (newSectionList == null) {
                    return Unit.INSTANCE;
                }
                if (!newSectionList.isEmpty() && tab.getPage() != null) {
                    searchPageViewModel.lastPageMore = tab.getPage();
                    function1 = searchPageViewModel.updateNewReceiveSectionSelectedState;
                    function1.invoke(newSectionList);
                    mutableStateFlow = searchPageViewModel._searchResultData;
                    ArrayList $this$invokeSuspend_u24lambda_u240_u240 = new ArrayList();
                    mutableStateFlow2 = searchPageViewModel._searchResultData;
                    List list = (List) mutableStateFlow2.getValue();
                    if (list != null) {
                        Boxing.boxBoolean($this$invokeSuspend_u24lambda_u240_u240.addAll(list));
                    }
                    $this$invokeSuspend_u24lambda_u240_u240.addAll(newSectionList);
                    mutableStateFlow.setValue($this$invokeSuspend_u24lambda_u240_u240);
                } else {
                    return Unit.INSTANCE;
                }
            }
            this.this$0.searchPageLoading = false;
        }
        return Unit.INSTANCE;
    }
}