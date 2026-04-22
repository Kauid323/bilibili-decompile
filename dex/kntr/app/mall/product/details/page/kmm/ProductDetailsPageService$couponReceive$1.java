package kntr.app.mall.product.details.page.kmm;

import java.util.Map;
import kntr.app.mall.product.details.page.api.CouponListApiService;
import kntr.app.mall.product.details.page.api.CouponListResponse;
import kntr.app.mall.product.details.page.kmm.ProductDetailsPageDataState;
import kntr.app.mall.product.details.page.utils.DateFormatKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.appinfo.KAppInfo;
import kntr.base.device.DeviceType;
import kntr.base.device.KDevice;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: ProductDetailsPageService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.kmm.ProductDetailsPageService$couponReceive$1", f = "ProductDetailsPageService.kt", i = {0, 0}, l = {343}, m = "invokeSuspend", n = {"platform", "params"}, s = {"L$0", "L$1"}, v = 1)
final class ProductDetailsPageService$couponReceive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CouponListResponse.CouponListItem $coupon;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ProductDetailsPageService this$0;

    /* compiled from: ProductDetailsPageService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceType.values().length];
            try {
                iArr[DeviceType.iOS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DeviceType.Android.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DeviceType.HarmonyOS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailsPageService$couponReceive$1(CouponListResponse.CouponListItem couponListItem, ProductDetailsPageService productDetailsPageService, Continuation<? super ProductDetailsPageService$couponReceive$1> continuation) {
        super(2, continuation);
        this.$coupon = couponListItem;
        this.this$0 = productDetailsPageService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProductDetailsPageService$couponReceive$1(this.$coupon, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        MutableStateFlow $receiver$iv;
        Object prevValue$iv$iv;
        Object nextValue$iv$iv;
        String str;
        Object mallKntrReceiveCoupon$product_details_page_debug;
        MutableStateFlow $receiver$iv2;
        Object prevValue$iv$iv2;
        Object nextValue$iv$iv2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    switch (WhenMappings.$EnumSwitchMapping$0[KDevice.INSTANCE.getDeviceType().ordinal()]) {
                        case 1:
                            str = "ios";
                            break;
                        case 2:
                            str = "android";
                            break;
                        case 3:
                            str = "harmonyos";
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                    String platform = str;
                    Map params = MapsKt.mapOf(new Pair[]{TuplesKt.to("deviceId", KDevice.INSTANCE.getBuvid()), TuplesKt.to("fromPage", Boxing.boxInt(2)), TuplesKt.to("deviceInfo", MapsKt.mapOf(new Pair[]{TuplesKt.to("build", ""), TuplesKt.to("info", KAppInfo.INSTANCE.getMobiApp()), TuplesKt.to("platform", platform), TuplesKt.to("ua", "")})), TuplesKt.to("sourceId", this.$coupon.getSourceId()), TuplesKt.to("sourceAuthorityId", this.$coupon.getSourceAuthorityId()), TuplesKt.to("sourceActivityId", this.$coupon.getSourceId()), TuplesKt.to("needDeviceCheck", Boxing.boxBoolean(false)), TuplesKt.to("sourceBizId", Boxing.boxLong(DateFormatKt.getCurrentTimeMillis()))});
                    this.L$0 = SpillingKt.nullOutSpilledVariable(platform);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(params);
                    this.label = 1;
                    mallKntrReceiveCoupon$product_details_page_debug = CouponListApiService.INSTANCE.mallKntrReceiveCoupon$product_details_page_debug(params, (Continuation) this);
                    if (mallKntrReceiveCoupon$product_details_page_debug == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    Map map = (Map) this.L$1;
                    String str2 = (String) this.L$0;
                    ResultKt.throwOnFailure($result);
                    mallKntrReceiveCoupon$product_details_page_debug = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            CouponListApiService.CouponReceiveResposne response = (CouponListApiService.CouponReceiveResposne) mallKntrReceiveCoupon$product_details_page_debug;
            ProductDetailsPageService productDetailsPageService = this.this$0;
            $receiver$iv2 = this.this$0._couponReceiveFlow;
            ProductDetailsPageDataState.ProductDetailsPageStatus pageStatus$iv = ProductDetailsPageDataState.ProductDetailsPageStatus.SUCCESS;
            do {
                prevValue$iv$iv2 = $receiver$iv2.getValue();
                ProductDetailsPageDataState productDetailsPageDataState = (ProductDetailsPageDataState) prevValue$iv$iv2;
                nextValue$iv$iv2 = new ProductDetailsPageDataState(pageStatus$iv, response, null);
            } while (!$receiver$iv2.compareAndSet(prevValue$iv$iv2, nextValue$iv$iv2));
        } catch (Exception e) {
            ProductDetailsPageService productDetailsPageService2 = this.this$0;
            $receiver$iv = this.this$0._couponReceiveFlow;
            ProductDetailsPageDataState.ProductDetailsPageStatus pageStatus$iv2 = ProductDetailsPageDataState.ProductDetailsPageStatus.ERROR;
            do {
                prevValue$iv$iv = $receiver$iv.getValue();
                ProductDetailsPageDataState productDetailsPageDataState2 = (ProductDetailsPageDataState) prevValue$iv$iv;
                nextValue$iv$iv = new ProductDetailsPageDataState(pageStatus$iv2, null, null);
            } while (!$receiver$iv.compareAndSet(prevValue$iv$iv, nextValue$iv$iv));
        }
        return Unit.INSTANCE;
    }
}