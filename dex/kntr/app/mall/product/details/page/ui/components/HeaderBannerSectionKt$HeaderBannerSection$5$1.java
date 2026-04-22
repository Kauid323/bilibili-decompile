package kntr.app.mall.product.details.page.ui.components;

import java.util.List;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BlurOption;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.imageloader.Radius;
import kntr.base.imageloader.Sigma;
import kntr.base.imageloader.Size;
import kntr.base.imageloader.SizeControllerKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HeaderBannerSection.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$HeaderBannerSection$5$1", f = "HeaderBannerSection.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HeaderBannerSectionKt$HeaderBannerSection$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $heightPixel;
    final /* synthetic */ List<String> $imageList;
    final /* synthetic */ PageViewModel $pageViewModel;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ int $widthPixel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderBannerSectionKt$HeaderBannerSection$5$1(List<String> list, int i, int i2, CoroutineScope coroutineScope, PageViewModel pageViewModel, Continuation<? super HeaderBannerSectionKt$HeaderBannerSection$5$1> continuation) {
        super(2, continuation);
        this.$imageList = list;
        this.$widthPixel = i;
        this.$heightPixel = i2;
        this.$scope = coroutineScope;
        this.$pageViewModel = pageViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HeaderBannerSectionKt$HeaderBannerSection$5$1(this.$imageList, this.$widthPixel, this.$heightPixel, this.$scope, this.$pageViewModel, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                List it = this.$imageList;
                if (it != null) {
                    int i = this.$widthPixel;
                    int i2 = this.$heightPixel;
                    CoroutineScope coroutineScope = this.$scope;
                    PageViewModel pageViewModel = this.$pageViewModel;
                    for (String image : it) {
                        Size size = SizeControllerKt.m1578getStageSizeIc4ZqO0(i, i2);
                        ImmutableImageRequest styleRequest = new ImageRequest(HelperKt.customizedImageUrl(image)).m1493requestWidth3VbuI34(size.m1577getWidthuhUG8m8()).m1488requestHeight3VbuI34(size.m1576getHeightuhUG8m8()).build();
                        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new HeaderBannerSectionKt$HeaderBannerSection$5$1$1$1(styleRequest, null), 3, (Object) null);
                    }
                    if (pageViewModel.shouldShowIpFeedRecommend$product_details_page_debug()) {
                        ImmutableImageRequest recommendRequest = new ImageRequest(HelperKt.customizedImageUrl((String) CollectionsKt.last(it))).requestBlur(new BlurOption(Radius.m1550constructorimpl(Boxing.boxInt(39)), Sigma.m1565constructorimpl(Boxing.boxInt(39)), null)).build();
                        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new HeaderBannerSectionKt$HeaderBannerSection$5$1$1$2(recommendRequest, null), 3, (Object) null);
                    }
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}