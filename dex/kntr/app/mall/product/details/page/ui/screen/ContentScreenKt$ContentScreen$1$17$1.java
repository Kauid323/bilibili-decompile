package kntr.app.mall.product.details.page.ui.screen;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.runtime.State;
import kntr.app.mall.product.details.page.api.model.BasicInfoFloor;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
import kntr.app.mall.product.details.page.utils.DateFormatKt;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.SharedPreferences;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContentScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$ContentScreen$1$17$1", f = "ContentScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ContentScreenKt$ContentScreen$1$17$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OnBackPressedDispatcher $backHandler;
    final /* synthetic */ State<Boolean> $isRetainPopupVisible$delegate;
    final /* synthetic */ PageViewModel $pageViewModel;
    final /* synthetic */ ProductDetailsResponse.ProductDetailsData $productDetailsData;
    final /* synthetic */ OnBackPressedCallback $retainPopupCallback;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentScreenKt$ContentScreen$1$17$1(ProductDetailsResponse.ProductDetailsData productDetailsData, OnBackPressedCallback onBackPressedCallback, PageViewModel pageViewModel, OnBackPressedDispatcher onBackPressedDispatcher, State<Boolean> state, Continuation<? super ContentScreenKt$ContentScreen$1$17$1> continuation) {
        super(2, continuation);
        this.$productDetailsData = productDetailsData;
        this.$retainPopupCallback = onBackPressedCallback;
        this.$pageViewModel = pageViewModel;
        this.$backHandler = onBackPressedDispatcher;
        this.$isRetainPopupVisible$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ContentScreenKt$ContentScreen$1$17$1(this.$productDetailsData, this.$retainPopupCallback, this.$pageViewModel, this.$backHandler, this.$isRetainPopupVisible$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean ContentScreen$lambda$15$27;
        Integer retainDaysFreq;
        Long longOrNull;
        BasicInfoFloor basicInfoFloorVO;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ProductDetailsResponse.ProductDetailsData productDetailsData = this.$productDetailsData;
                int retainDaysFreq2 = 0;
                boolean isNewCustomer = (productDetailsData == null || (basicInfoFloorVO = productDetailsData.getBasicInfoFloorVO()) == null) ? false : Intrinsics.areEqual(basicInfoFloorVO.getNewCustomer(), Boxing.boxBoolean(true));
                ProductDetailsResponse.ProductDetailsData productDetailsData2 = this.$productDetailsData;
                boolean isFromTm = productDetailsData2 != null ? Intrinsics.areEqual(productDetailsData2.getFromTm(), Boxing.boxBoolean(true)) : false;
                if (!isNewCustomer && isFromTm) {
                    ContentScreen$lambda$15$27 = ContentScreenKt.ContentScreen$lambda$15$27(this.$isRetainPopupVisible$delegate);
                    if (!ContentScreen$lambda$15$27) {
                        String string$default = SharedPreferences.getString$default(this.$pageViewModel.getSp(), "retainPopupTimestamp", null, 2, null);
                        long lastShowTimestamp = (string$default == null || (longOrNull = StringsKt.toLongOrNull(string$default)) == null) ? 0L : longOrNull.longValue();
                        long currentTimestamp = DateFormatKt.getCurrentTimeMillis();
                        BasicInfoFloor basicInfoFloorVO2 = this.$productDetailsData.getBasicInfoFloorVO();
                        if (basicInfoFloorVO2 != null && (retainDaysFreq = basicInfoFloorVO2.getRetainDaysFreq()) != null) {
                            retainDaysFreq2 = retainDaysFreq.intValue();
                        }
                        int dayInterval = DateFormatKt.dayInterval$default(lastShowTimestamp, currentTimestamp, null, 4, null);
                        if (dayInterval >= retainDaysFreq2) {
                            this.$backHandler.addCallback(this.$retainPopupCallback);
                        } else {
                            this.$retainPopupCallback.remove();
                        }
                        return Unit.INSTANCE;
                    }
                }
                this.$retainPopupCallback.remove();
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}