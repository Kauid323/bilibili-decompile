package kntr.app.mall.product.details.page.kmm;

import io.ktor.http.Parameters;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLUtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kntr.app.mall.product.details.page.api.Client;
import kntr.app.mall.product.details.page.api.CommentInfoApiService;
import kntr.app.mall.product.details.page.api.CouponListApiService;
import kntr.app.mall.product.details.page.api.CouponListResponse;
import kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService;
import kntr.app.mall.product.details.page.api.LiveInfoApiService;
import kntr.app.mall.product.details.page.api.MarketingGiftApiService;
import kntr.app.mall.product.details.page.api.ReserveApiService;
import kntr.app.mall.product.details.page.api.SearchTextApiService;
import kntr.app.mall.product.details.page.api.ShareImageGenerateApiService;
import kntr.app.mall.product.details.page.api.model.ActionIconModel;
import kntr.app.mall.product.details.page.api.model.CouponInfoModel;
import kntr.app.mall.product.details.page.api.model.CouponPackageInfoModel;
import kntr.app.mall.product.details.page.api.model.FileInfoFloor;
import kntr.app.mall.product.details.page.api.model.FooterFloor;
import kntr.app.mall.product.details.page.api.model.IpBrandFloor;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
import kntr.app.mall.product.details.page.kmm.ProductDetailsPageDataState;
import kntr.app.mall.product.details.page.kmm.ProductShareActionState;
import kntr.app.mall.product.details.page.utils.DateFormatKt;
import kntr.app.mall.product.details.page.vm.ApiRepository;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.appinfo.KAppInfo;
import kntr.base.device.DeviceType;
import kntr.base.device.KDevice;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.json.Json;

/* compiled from: ProductDetailsPageService.kt */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010v\u001a\u00020wJ\u0006\u0010x\u001a\u00020wJ\u000e\u0010y\u001a\u00020w2\u0006\u0010z\u001a\u00020{J\u000e\u0010|\u001a\u00020w2\u0006\u0010}\u001a\u00020\u0005J\u0017\u0010~\u001a\u00020w2\u0006\u0010\u0011\u001a\u00020\u00052\u0007\u0010\u007f\u001a\u00030\u0080\u0001JE\u0010\u0081\u0001\u001a\u00020w2\u000b\b\u0002\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00052\f\b\u0002\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u00012\u0010\b\u0002\u0010\u0085\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0086\u00012\t\b\u0002\u0010\u0087\u0001\u001a\u00020\u0005¢\u0006\u0003\u0010\u0088\u0001JZ\u0010\u0089\u0001\u001a\u00020w2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u00012\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u0080\u0001¢\u0006\u0003\u0010\u008f\u0001J&\u0010\u0090\u0001\u001a\u00020w2\t\b\u0002\u0010\u0091\u0001\u001a\u00020$2\f\b\u0002\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0080\u0001¢\u0006\u0003\u0010\u0093\u0001J!\u0010\u0094\u0001\u001a\u00020w2\u000b\b\u0002\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0005J\u001c\u0010\u0097\u0001\u001a\u00020w2\u0006\u0010J\u001a\u00020\u001b2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001eH\u0002J\t\u0010\u0099\u0001\u001a\u00020wH\u0002J\u0007\u0010\u009a\u0001\u001a\u00020wJ\t\u0010\u009b\u0001\u001a\u00020wH\u0002J\u0012\u0010\u009c\u0001\u001a\u00020w2\u0007\u0010\u0091\u0001\u001a\u00020$H\u0002JQ\u0010\u009d\u0001\u001a\u00020w\"\t\b\u0000\u0010\u009e\u0001*\u00020\u0001*\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u0003H\u009e\u00010\u001a0\u00192\b\u0010\u009f\u0001\u001a\u00030 \u00012\f\b\u0002\u0010¡\u0001\u001a\u0005\u0018\u0001H\u009e\u00012\u000b\b\u0002\u0010¢\u0001\u001a\u0004\u0018\u00010\u0005H\u0082\b¢\u0006\u0003\u0010£\u0001JQ\u0010¤\u0001\u001a\u00020w\"\t\b\u0000\u0010\u009e\u0001*\u00020\u0001*\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u0003H\u009e\u0001030\u00192\b\u0010\u009f\u0001\u001a\u00030¥\u00012\f\b\u0002\u0010¡\u0001\u001a\u0005\u0018\u0001H\u009e\u00012\u000b\b\u0002\u0010¢\u0001\u001a\u0004\u0018\u00010\u0005H\u0082\b¢\u0006\u0003\u0010¦\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000204030\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020$0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b;\u0010<R\"\u0010?\u001a\b\u0012\u0004\u0012\u00020$0@8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010\t\u001a\u0004\bB\u0010CR$\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050@8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bE\u0010\t\u001a\u0004\bF\u0010CR(\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0@8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bH\u0010\t\u001a\u0004\bI\u0010CR(\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0@8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bK\u0010\t\u001a\u0004\bL\u0010CR(\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001a0@8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bN\u0010\t\u001a\u0004\bO\u0010CR(\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001a0@8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bQ\u0010\t\u001a\u0004\bR\u0010CR(\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u001a0@8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bT\u0010\t\u001a\u0004\bU\u0010CR(\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0@8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bW\u0010\t\u001a\u0004\bX\u0010CR(\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001a0Z8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b[\u0010\t\u001a\u0004\b\\\u0010]R(\u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u001a0Z8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b_\u0010\t\u001a\u0004\b`\u0010]R(\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u001a0Z8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bb\u0010\t\u001a\u0004\bc\u0010]R(\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u001a0Z8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\be\u0010\t\u001a\u0004\bf\u0010]R(\u0010g\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\u001a0Z8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bh\u0010\t\u001a\u0004\bi\u0010]R(\u0010j\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u001a0Z8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bk\u0010\t\u001a\u0004\bl\u0010]R(\u0010m\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u001a0Z8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bn\u0010\t\u001a\u0004\bo\u0010]R(\u0010p\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000204030Z8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bq\u0010\t\u001a\u0004\br\u0010]R$\u0010s\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080Z8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bt\u0010\t\u001a\u0004\bu\u0010]¨\u0006§\u0001"}, d2 = {"Lkntr/app/mall/product/details/page/kmm/ProductDetailsPageService;", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "url", "", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;)V", "getCoroutineScope$product_details_page_debug$annotations", "()V", "getCoroutineScope$product_details_page_debug", "()Lkotlinx/coroutines/CoroutineScope;", "urlWithoutDetailPreload", "getUrlWithoutDetailPreload", "()Ljava/lang/String;", "urlParams", "Lio/ktor/http/Parameters;", "itemsId", "msource", "trackId", "from", "isAd", "detailPreload", "fromSpmId", "_productPreloadResponse", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkntr/app/mall/product/details/page/kmm/ProductDetailsPageDataState;", "Lkntr/app/mall/product/details/page/api/model/ProductDetailsResponse;", "_productDetailsResponse", "_commentApiResponse", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse;", "_couponApiResponse", "Lkntr/app/mall/product/details/page/api/CouponListResponse;", "_liveApiResponse", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoResponse;", "_wishInfo", "", "_couponListResponseFlow", "_couponReceiveFlow", "Lkntr/app/mall/product/details/page/api/CouponListApiService$CouponReceiveResposne;", "_fileInfoFlow", "Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfo;", "_giftInfoFlow", "Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftData;", "_reserveResultFlow", "Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveResultResponse$ReserveResultData;", "_ipFeedRecommendFlow", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendV2ApiService$Response;", "_searchWordFlow", "Lkntr/app/mall/product/details/page/api/SearchTextApiService$SearchTextResponse;", "_shareImageFlow", "Lkntr/app/mall/product/details/page/kmm/ProductShareActionState;", "Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$Response;", "_loadingState", "_errorState", "_upCouponDisplayStateFlow", "Lkntr/app/mall/product/details/page/kmm/ProductDetailsPageUpCouponDisplayModel;", "mRepository", "Lkntr/app/mall/product/details/page/vm/ApiRepository;", "getMRepository", "()Lkntr/app/mall/product/details/page/vm/ApiRepository;", "mRepository$delegate", "Lkotlin/Lazy;", "loadingState", "Lkotlinx/coroutines/flow/Flow;", "getLoadingState$annotations", "getLoadingState", "()Lkotlinx/coroutines/flow/Flow;", "errorState", "getErrorState$annotations", "getErrorState", "productPreloadResponse", "getProductPreloadResponse$annotations", "getProductPreloadResponse", "productDetailsResponse", "getProductDetailsResponse$annotations", "getProductDetailsResponse", "commentApiResponse", "getCommentApiResponse$annotations", "getCommentApiResponse", "couponApiResponse", "getCouponApiResponse$annotations", "getCouponApiResponse", "liveApiResponse", "getLiveApiResponse$annotations", "getLiveApiResponse", "wishInfo", "getWishInfo$annotations", "getWishInfo", "couponListResponseFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getCouponListResponseFlow$annotations", "getCouponListResponseFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "fileInfoFlow", "getFileInfoFlow$annotations", "getFileInfoFlow", "reserveResultFlow", "getReserveResultFlow$annotations", "getReserveResultFlow", "giftInfoFlow", "getGiftInfoFlow$annotations", "getGiftInfoFlow", "couponReceiveFlow", "getCouponReceiveFlow$annotations", "getCouponReceiveFlow", "ipFeedRecommendFlow", "getIpFeedRecommendFlow$annotations", "getIpFeedRecommendFlow", "searchWordFlow", "getSearchWordFlow$annotations", "getSearchWordFlow", "shareImageFlow", "getShareImageFlow$annotations", "getShareImageFlow", "upCouponDisplayStateFlow", "getUpCouponDisplayStateFlow$annotations", "getUpCouponDisplayStateFlow", "getShareImage", "", "getSearchWord", "couponReceive", "coupon", "Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem;", "getGiftInfo", "marketId", "getFileInfo", "skuId", "", "getCouponList", "mid", "personalStatus", "", "sourceAuthorityIdList", "", "sourceId", "(Ljava/lang/String;Ljava/lang/Byte;Ljava/util/List;Ljava/lang/String;)V", "triggerReserve", "autoOnSaleTime", "", "sourceAuthorityId", "activityId", "shopId", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "loadProductDetails", "isFirst", "addrId", "(ZLjava/lang/Long;)V", "getIPFeedRecommend", "ipRightId", "itemIds", "fetchDataSuccess", "commentResponse", "fetchDataSuccessAfter", "clearUpCouponDisplayState", "handleAutoFetchCoupons", "reportLoadFinished", "updateState", "T", "pageStatus", "Lkntr/app/mall/product/details/page/kmm/ProductDetailsPageDataState$ProductDetailsPageStatus;", "holdData", "errorMessage", "(Lkotlinx/coroutines/flow/MutableStateFlow;Lkntr/app/mall/product/details/page/kmm/ProductDetailsPageDataState$ProductDetailsPageStatus;Ljava/lang/Object;Ljava/lang/String;)V", "updateShareState", "Lkntr/app/mall/product/details/page/kmm/ProductShareActionState$ProductShareStatus;", "(Lkotlinx/coroutines/flow/MutableStateFlow;Lkntr/app/mall/product/details/page/kmm/ProductShareActionState$ProductShareStatus;Ljava/lang/Object;Ljava/lang/String;)V", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ProductDetailsPageService {
    public static final int $stable = 8;
    private final MutableStateFlow<ProductDetailsPageDataState<CommentInfoApiService.CommentInfoResponse>> _commentApiResponse;
    private final MutableStateFlow<ProductDetailsPageDataState<CouponListResponse>> _couponApiResponse;
    private final MutableStateFlow<ProductDetailsPageDataState<CouponListResponse>> _couponListResponseFlow;
    private final MutableStateFlow<ProductDetailsPageDataState<CouponListApiService.CouponReceiveResposne>> _couponReceiveFlow;
    private final MutableStateFlow<String> _errorState;
    private final MutableStateFlow<ProductDetailsPageDataState<FileInfoFloor.FileInfo>> _fileInfoFlow;
    private final MutableStateFlow<ProductDetailsPageDataState<MarketingGiftApiService.MarketingGiftData>> _giftInfoFlow;
    private final MutableStateFlow<ProductDetailsPageDataState<IPFeedRecommendV2ApiService.Response>> _ipFeedRecommendFlow;
    private final MutableStateFlow<ProductDetailsPageDataState<LiveInfoApiService.LiveInfoResponse>> _liveApiResponse;
    private final MutableStateFlow<Boolean> _loadingState;
    private final MutableStateFlow<ProductDetailsPageDataState<ProductDetailsResponse>> _productDetailsResponse;
    private final MutableStateFlow<ProductDetailsPageDataState<ProductDetailsResponse>> _productPreloadResponse;
    private final MutableStateFlow<ProductDetailsPageDataState<ReserveApiService.ReserveResultResponse.ReserveResultData>> _reserveResultFlow;
    private final MutableStateFlow<ProductDetailsPageDataState<SearchTextApiService.SearchTextResponse>> _searchWordFlow;
    private final MutableStateFlow<ProductShareActionState<ShareImageGenerateApiService.Response>> _shareImageFlow;
    private final MutableStateFlow<ProductDetailsPageUpCouponDisplayModel> _upCouponDisplayStateFlow;
    private final MutableStateFlow<ProductDetailsPageDataState<Boolean>> _wishInfo;
    private final Flow<ProductDetailsPageDataState<CommentInfoApiService.CommentInfoResponse>> commentApiResponse;
    private final CoroutineScope coroutineScope;
    private final Flow<ProductDetailsPageDataState<CouponListResponse>> couponApiResponse;
    private final SharedFlow<ProductDetailsPageDataState<CouponListResponse>> couponListResponseFlow;
    private final SharedFlow<ProductDetailsPageDataState<CouponListApiService.CouponReceiveResposne>> couponReceiveFlow;
    private final String detailPreload;
    private final Flow<String> errorState;
    private final SharedFlow<ProductDetailsPageDataState<FileInfoFloor.FileInfo>> fileInfoFlow;
    private final String from;
    private final String fromSpmId;
    private final SharedFlow<ProductDetailsPageDataState<MarketingGiftApiService.MarketingGiftData>> giftInfoFlow;
    private final SharedFlow<ProductDetailsPageDataState<IPFeedRecommendV2ApiService.Response>> ipFeedRecommendFlow;
    private final String isAd;
    private final String itemsId;
    private final Flow<ProductDetailsPageDataState<LiveInfoApiService.LiveInfoResponse>> liveApiResponse;
    private final Flow<Boolean> loadingState;
    private final Lazy mRepository$delegate;
    private final String msource;
    private final Flow<ProductDetailsPageDataState<ProductDetailsResponse>> productDetailsResponse;
    private final Flow<ProductDetailsPageDataState<ProductDetailsResponse>> productPreloadResponse;
    private final SharedFlow<ProductDetailsPageDataState<ReserveApiService.ReserveResultResponse.ReserveResultData>> reserveResultFlow;
    private final SharedFlow<ProductDetailsPageDataState<SearchTextApiService.SearchTextResponse>> searchWordFlow;
    private final SharedFlow<ProductShareActionState<ShareImageGenerateApiService.Response>> shareImageFlow;
    private final String trackId;
    private final SharedFlow<ProductDetailsPageUpCouponDisplayModel> upCouponDisplayStateFlow;
    private final String url;
    private final Parameters urlParams;
    private final String urlWithoutDetailPreload;
    private final Flow<ProductDetailsPageDataState<Boolean>> wishInfo;

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

    public static /* synthetic */ void getCommentApiResponse$annotations() {
    }

    public static /* synthetic */ void getCoroutineScope$product_details_page_debug$annotations() {
    }

    public static /* synthetic */ void getCouponApiResponse$annotations() {
    }

    public static /* synthetic */ void getCouponListResponseFlow$annotations() {
    }

    public static /* synthetic */ void getCouponReceiveFlow$annotations() {
    }

    public static /* synthetic */ void getErrorState$annotations() {
    }

    public static /* synthetic */ void getFileInfoFlow$annotations() {
    }

    public static /* synthetic */ void getGiftInfoFlow$annotations() {
    }

    public static /* synthetic */ void getIpFeedRecommendFlow$annotations() {
    }

    public static /* synthetic */ void getLiveApiResponse$annotations() {
    }

    public static /* synthetic */ void getLoadingState$annotations() {
    }

    public static /* synthetic */ void getProductDetailsResponse$annotations() {
    }

    public static /* synthetic */ void getProductPreloadResponse$annotations() {
    }

    public static /* synthetic */ void getReserveResultFlow$annotations() {
    }

    public static /* synthetic */ void getSearchWordFlow$annotations() {
    }

    public static /* synthetic */ void getShareImageFlow$annotations() {
    }

    public static /* synthetic */ void getUpCouponDisplayStateFlow$annotations() {
    }

    public static /* synthetic */ void getWishInfo$annotations() {
    }

    public ProductDetailsPageService(CoroutineScope coroutineScope, String url) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.coroutineScope = coroutineScope;
        this.url = url;
        String str = this.url;
        URLBuilder $this$urlWithoutDetailPreload_u24lambda_u240 = URLUtilsKt.URLBuilder(URLUtilsKt.Url(str == null ? "" : str));
        $this$urlWithoutDetailPreload_u24lambda_u240.getParameters().remove("detailPreload");
        this.urlWithoutDetailPreload = $this$urlWithoutDetailPreload_u24lambda_u240.buildString();
        String str2 = this.url;
        this.urlParams = URLUtilsKt.Url(str2 != null ? str2 : "").getParameters();
        this.itemsId = this.urlParams.get("itemsId");
        this.msource = this.urlParams.get("msource");
        this.trackId = this.urlParams.get("track_id");
        this.from = this.urlParams.get("from");
        this.isAd = this.urlParams.get("is_ad");
        this.detailPreload = this.urlParams.get("detailPreload");
        this.fromSpmId = this.urlParams.get("fromSpmId");
        this._productPreloadResponse = StateFlowKt.MutableStateFlow(new ProductDetailsPageDataState(null, null, null, 7, null));
        this._productDetailsResponse = StateFlowKt.MutableStateFlow(new ProductDetailsPageDataState(null, null, null, 7, null));
        this._commentApiResponse = StateFlowKt.MutableStateFlow(new ProductDetailsPageDataState(null, null, null, 7, null));
        this._couponApiResponse = StateFlowKt.MutableStateFlow(new ProductDetailsPageDataState(null, null, null, 7, null));
        this._liveApiResponse = StateFlowKt.MutableStateFlow(new ProductDetailsPageDataState(null, null, null, 7, null));
        this._wishInfo = StateFlowKt.MutableStateFlow(new ProductDetailsPageDataState(null, null, null, 7, null));
        this._couponListResponseFlow = StateFlowKt.MutableStateFlow(new ProductDetailsPageDataState(null, null, null, 7, null));
        this._couponReceiveFlow = StateFlowKt.MutableStateFlow(new ProductDetailsPageDataState(null, null, null, 7, null));
        this._fileInfoFlow = StateFlowKt.MutableStateFlow(new ProductDetailsPageDataState(null, null, null, 7, null));
        this._giftInfoFlow = StateFlowKt.MutableStateFlow(new ProductDetailsPageDataState(null, null, null, 7, null));
        this._reserveResultFlow = StateFlowKt.MutableStateFlow(new ProductDetailsPageDataState(null, null, null, 7, null));
        this._ipFeedRecommendFlow = StateFlowKt.MutableStateFlow(new ProductDetailsPageDataState(null, null, null, 7, null));
        this._searchWordFlow = StateFlowKt.MutableStateFlow(new ProductDetailsPageDataState(null, null, null, 7, null));
        this._shareImageFlow = StateFlowKt.MutableStateFlow(new ProductShareActionState(null, null, null, 7, null));
        this._loadingState = StateFlowKt.MutableStateFlow(false);
        this._errorState = StateFlowKt.MutableStateFlow((Object) null);
        this._upCouponDisplayStateFlow = StateFlowKt.MutableStateFlow((Object) null);
        this.mRepository$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.mall.product.details.page.kmm.ProductDetailsPageService$$ExternalSyntheticLambda0
            public final Object invoke() {
                ProductDetailsPageApiRepositoryImp mRepository_delegate$lambda$0;
                mRepository_delegate$lambda$0 = ProductDetailsPageService.mRepository_delegate$lambda$0(ProductDetailsPageService.this);
                return mRepository_delegate$lambda$0;
            }
        });
        this.loadingState = FlowKt.asSharedFlow(this._loadingState);
        this.errorState = FlowKt.asSharedFlow(this._errorState);
        this.productPreloadResponse = FlowKt.asSharedFlow(this._productPreloadResponse);
        this.productDetailsResponse = FlowKt.asSharedFlow(this._productDetailsResponse);
        this.commentApiResponse = FlowKt.asSharedFlow(this._commentApiResponse);
        this.couponApiResponse = FlowKt.asSharedFlow(this._couponApiResponse);
        this.liveApiResponse = FlowKt.asSharedFlow(this._liveApiResponse);
        this.wishInfo = FlowKt.asSharedFlow(this._wishInfo);
        this.couponListResponseFlow = FlowKt.asSharedFlow(this._couponListResponseFlow);
        this.fileInfoFlow = FlowKt.asSharedFlow(this._fileInfoFlow);
        this.reserveResultFlow = FlowKt.asSharedFlow(this._reserveResultFlow);
        this.giftInfoFlow = FlowKt.asSharedFlow(this._giftInfoFlow);
        this.couponReceiveFlow = FlowKt.asSharedFlow(this._couponReceiveFlow);
        this.ipFeedRecommendFlow = FlowKt.asSharedFlow(this._ipFeedRecommendFlow);
        this.searchWordFlow = FlowKt.asSharedFlow(this._searchWordFlow);
        this.shareImageFlow = FlowKt.asSharedFlow(this._shareImageFlow);
        this.upCouponDisplayStateFlow = FlowKt.asSharedFlow(this._upCouponDisplayStateFlow);
    }

    public /* synthetic */ ProductDetailsPageService(CoroutineScope coroutineScope, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, (i & 2) != 0 ? null : str);
    }

    public final CoroutineScope getCoroutineScope$product_details_page_debug() {
        return this.coroutineScope;
    }

    public final String getUrlWithoutDetailPreload() {
        return this.urlWithoutDetailPreload;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApiRepository getMRepository() {
        return (ApiRepository) this.mRepository$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProductDetailsPageApiRepositoryImp mRepository_delegate$lambda$0(ProductDetailsPageService this$0) {
        return new ProductDetailsPageApiRepositoryImp(this$0.itemsId, this$0.msource, this$0.trackId, this$0.from, this$0.isAd, this$0.fromSpmId);
    }

    public final Flow<Boolean> getLoadingState() {
        return this.loadingState;
    }

    public final Flow<String> getErrorState() {
        return this.errorState;
    }

    public final Flow<ProductDetailsPageDataState<ProductDetailsResponse>> getProductPreloadResponse() {
        return this.productPreloadResponse;
    }

    public final Flow<ProductDetailsPageDataState<ProductDetailsResponse>> getProductDetailsResponse() {
        return this.productDetailsResponse;
    }

    public final Flow<ProductDetailsPageDataState<CommentInfoApiService.CommentInfoResponse>> getCommentApiResponse() {
        return this.commentApiResponse;
    }

    public final Flow<ProductDetailsPageDataState<CouponListResponse>> getCouponApiResponse() {
        return this.couponApiResponse;
    }

    public final Flow<ProductDetailsPageDataState<LiveInfoApiService.LiveInfoResponse>> getLiveApiResponse() {
        return this.liveApiResponse;
    }

    public final Flow<ProductDetailsPageDataState<Boolean>> getWishInfo() {
        return this.wishInfo;
    }

    public final SharedFlow<ProductDetailsPageDataState<CouponListResponse>> getCouponListResponseFlow() {
        return this.couponListResponseFlow;
    }

    public final SharedFlow<ProductDetailsPageDataState<FileInfoFloor.FileInfo>> getFileInfoFlow() {
        return this.fileInfoFlow;
    }

    public final SharedFlow<ProductDetailsPageDataState<ReserveApiService.ReserveResultResponse.ReserveResultData>> getReserveResultFlow() {
        return this.reserveResultFlow;
    }

    public final SharedFlow<ProductDetailsPageDataState<MarketingGiftApiService.MarketingGiftData>> getGiftInfoFlow() {
        return this.giftInfoFlow;
    }

    public final SharedFlow<ProductDetailsPageDataState<CouponListApiService.CouponReceiveResposne>> getCouponReceiveFlow() {
        return this.couponReceiveFlow;
    }

    public final SharedFlow<ProductDetailsPageDataState<IPFeedRecommendV2ApiService.Response>> getIpFeedRecommendFlow() {
        return this.ipFeedRecommendFlow;
    }

    public final SharedFlow<ProductDetailsPageDataState<SearchTextApiService.SearchTextResponse>> getSearchWordFlow() {
        return this.searchWordFlow;
    }

    public final SharedFlow<ProductShareActionState<ShareImageGenerateApiService.Response>> getShareImageFlow() {
        return this.shareImageFlow;
    }

    public final SharedFlow<ProductDetailsPageUpCouponDisplayModel> getUpCouponDisplayStateFlow() {
        return this.upCouponDisplayStateFlow;
    }

    public final void getShareImage() {
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ProductDetailsPageService$getShareImage$1(this, null), 3, (Object) null);
    }

    public final void getSearchWord() {
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ProductDetailsPageService$getSearchWord$1(this, null), 3, (Object) null);
    }

    public final void couponReceive(CouponListResponse.CouponListItem coupon) {
        Intrinsics.checkNotNullParameter(coupon, "coupon");
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ProductDetailsPageService$couponReceive$1(coupon, this, null), 3, (Object) null);
    }

    public final void getGiftInfo(String marketId) {
        Intrinsics.checkNotNullParameter(marketId, "marketId");
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ProductDetailsPageService$getGiftInfo$1(marketId, this, null), 3, (Object) null);
    }

    public final void getFileInfo(String itemsId, long skuId) {
        Intrinsics.checkNotNullParameter(itemsId, "itemsId");
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ProductDetailsPageService$getFileInfo$1(itemsId, skuId, this, null), 3, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void getCouponList$default(ProductDetailsPageService productDetailsPageService, String str, Byte b, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            b = null;
        }
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 8) != 0) {
            str2 = "";
        }
        productDetailsPageService.getCouponList(str, b, list, str2);
    }

    public final void getCouponList(String mid, Byte personalStatus, List<String> list, String sourceId) {
        Intrinsics.checkNotNullParameter(list, "sourceAuthorityIdList");
        Intrinsics.checkNotNullParameter(sourceId, "sourceId");
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ProductDetailsPageService$getCouponList$1(mid, personalStatus, list, sourceId, this, null), 3, (Object) null);
    }

    public final void triggerReserve(String itemsId, Integer autoOnSaleTime, String sourceId, String sourceAuthorityId, String activityId, String trackId, Long shopId) {
        String str;
        Pair[] pairArr = new Pair[7];
        Pair[] pairArr2 = new Pair[4];
        pairArr2[0] = TuplesKt.to("build", "");
        pairArr2[1] = TuplesKt.to("info", KAppInfo.INSTANCE.getMobiApp());
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
        pairArr2[2] = TuplesKt.to("platform", str);
        pairArr2[3] = TuplesKt.to("ua", "");
        pairArr[0] = TuplesKt.to("deviceInfo", MapsKt.mapOf(pairArr2));
        pairArr[1] = TuplesKt.to("deviceId", KDevice.INSTANCE.getBuvid());
        pairArr[2] = TuplesKt.to("sourceId", sourceId);
        pairArr[3] = TuplesKt.to("sourceAuthorityId", sourceAuthorityId);
        pairArr[4] = TuplesKt.to("sourceActivityId", activityId);
        pairArr[5] = TuplesKt.to("needDeviceCheck", false);
        pairArr[6] = TuplesKt.to("sourceBizId", Long.valueOf(DateFormatKt.getCurrentTimeMillis()));
        Map receiveCouponCmd = MapsKt.mapOf(pairArr);
        Map reserveReq = MapsKt.mapOf(new Pair[]{TuplesKt.to("voteType", 1), TuplesKt.to("subjectId", itemsId), TuplesKt.to("onSaleTime", autoOnSaleTime), TuplesKt.to("subjectType", 18), TuplesKt.to("trackId", trackId), TuplesKt.to("shopId", shopId), TuplesKt.to("channels", 1)});
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ProductDetailsPageService$triggerReserve$1(this, itemsId, reserveReq, receiveCouponCmd, null), 3, (Object) null);
    }

    public static /* synthetic */ void loadProductDetails$default(ProductDetailsPageService productDetailsPageService, boolean z, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            l = null;
        }
        productDetailsPageService.loadProductDetails(z, l);
    }

    public final void loadProductDetails(boolean isFirst, Long addrId) {
        Object prevValue$iv$iv;
        Object nextValue$iv$iv;
        if (((Boolean) this._loadingState.getValue()).booleanValue()) {
            return;
        }
        ILogger kLog = KLog_androidKt.getKLog();
        String str = this.detailPreload;
        if (str == null) {
            str = "";
        }
        kLog.i("naDetail_log", str);
        if (isFirst) {
            String str2 = this.detailPreload;
            boolean z = false;
            if (str2 != null) {
                if (str2.length() > 0) {
                    z = true;
                }
            }
            if (z) {
                Json this_$iv = Client.INSTANCE.getJson();
                String string$iv = this.detailPreload;
                this_$iv.getSerializersModule();
                ProductDetailsResponse preloadedResponse = (ProductDetailsResponse) this_$iv.decodeFromString(ProductDetailsResponse.Companion.serializer(), string$iv);
                Integer code = preloadedResponse.getCode();
                if (code != null && code.intValue() == 0) {
                    KLog_androidKt.getKLog().i("PageViewModel", "使用预加载数据");
                    MutableStateFlow $receiver$iv = this._productPreloadResponse;
                    ProductDetailsPageDataState.ProductDetailsPageStatus pageStatus$iv = ProductDetailsPageDataState.ProductDetailsPageStatus.SUCCESS;
                    do {
                        prevValue$iv$iv = $receiver$iv.getValue();
                        ProductDetailsPageDataState productDetailsPageDataState = (ProductDetailsPageDataState) prevValue$iv$iv;
                        nextValue$iv$iv = new ProductDetailsPageDataState(pageStatus$iv, preloadedResponse, null);
                    } while (!$receiver$iv.compareAndSet(prevValue$iv$iv, nextValue$iv$iv));
                    fetchDataSuccess(preloadedResponse, null);
                } else {
                    KLog_androidKt.getKLog().e("PageViewModel", "预加载数据错误: " + preloadedResponse.getMessage());
                }
            }
        }
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ProductDetailsPageService$loadProductDetails$1(this, isFirst, addrId, null), 3, (Object) null);
    }

    public static /* synthetic */ void getIPFeedRecommend$default(ProductDetailsPageService productDetailsPageService, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        productDetailsPageService.getIPFeedRecommend(str, str2);
    }

    public final void getIPFeedRecommend(String ipRightId, String itemIds) {
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ProductDetailsPageService$getIPFeedRecommend$1(this, ipRightId, itemIds, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchDataSuccess(ProductDetailsResponse productDetailsResponse, CommentInfoApiService.CommentInfoResponse commentResponse) {
        Object holdData$iv;
        Object prevValue$iv$iv;
        Object nextValue$iv$iv;
        MutableStateFlow $this$update$iv;
        Object prevValue$iv;
        MutableStateFlow $this$update$iv2;
        Object prevValue$iv2;
        Integer code;
        String message;
        String it;
        FooterFloor footerFloorVO;
        List<ActionIconModel> footer;
        Object obj;
        boolean z;
        MutableStateFlow $receiver$iv = this._wishInfo;
        ProductDetailsPageDataState.ProductDetailsPageStatus pageStatus$iv = ProductDetailsPageDataState.ProductDetailsPageStatus.SUCCESS;
        ProductDetailsResponse.ProductDetailsData data = productDetailsResponse.getData();
        if (data != null && (footerFloorVO = data.getFooterFloorVO()) != null && (footer = footerFloorVO.getFooter()) != null) {
            Iterator<T> it2 = footer.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                ActionIconModel it3 = (ActionIconModel) obj;
                Integer type = it3.getType();
                if (type != null && type.intValue() == 6) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            ActionIconModel actionIconModel = (ActionIconModel) obj;
            if (actionIconModel != null) {
                holdData$iv = actionIconModel.getActive();
                do {
                    prevValue$iv$iv = $receiver$iv.getValue();
                    ProductDetailsPageDataState productDetailsPageDataState = (ProductDetailsPageDataState) prevValue$iv$iv;
                    nextValue$iv$iv = new ProductDetailsPageDataState(pageStatus$iv, holdData$iv, null);
                } while (!$receiver$iv.compareAndSet(prevValue$iv$iv, nextValue$iv$iv));
                $this$update$iv = this._loadingState;
                do {
                    prevValue$iv = $this$update$iv.getValue();
                    ((Boolean) prevValue$iv).booleanValue();
                } while (!$this$update$iv.compareAndSet(prevValue$iv, false));
                $this$update$iv2 = this._errorState;
                do {
                    prevValue$iv2 = $this$update$iv2.getValue();
                    String str = (String) prevValue$iv2;
                    code = productDetailsResponse.getCode();
                    if (code == null || code.intValue() != 0) {
                        message = productDetailsResponse.getMessage();
                    } else {
                        message = null;
                    }
                    it = message;
                } while (!$this$update$iv2.compareAndSet(prevValue$iv2, it));
            }
        }
        holdData$iv = null;
        do {
            prevValue$iv$iv = $receiver$iv.getValue();
            ProductDetailsPageDataState productDetailsPageDataState2 = (ProductDetailsPageDataState) prevValue$iv$iv;
            nextValue$iv$iv = new ProductDetailsPageDataState(pageStatus$iv, holdData$iv, null);
        } while (!$receiver$iv.compareAndSet(prevValue$iv$iv, nextValue$iv$iv));
        $this$update$iv = this._loadingState;
        do {
            prevValue$iv = $this$update$iv.getValue();
            ((Boolean) prevValue$iv).booleanValue();
        } while (!$this$update$iv.compareAndSet(prevValue$iv, false));
        $this$update$iv2 = this._errorState;
        do {
            prevValue$iv2 = $this$update$iv2.getValue();
            String str2 = (String) prevValue$iv2;
            code = productDetailsResponse.getCode();
            if (code == null) {
                message = null;
                it = message;
            }
            message = productDetailsResponse.getMessage();
            it = message;
        } while (!$this$update$iv2.compareAndSet(prevValue$iv2, it));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchDataSuccessAfter() {
        ProductDetailsResponse.ProductDetailsData data;
        IpBrandFloor ipBrandFloorVO;
        List<IpBrandFloor.IpRightInfo> ipRightList;
        IpBrandFloor.IpRightInfo ipRightInfo;
        String str = null;
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ProductDetailsPageService$fetchDataSuccessAfter$1(this, null), 3, (Object) null);
        getSearchWord();
        ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) ((ProductDetailsPageDataState) this._productDetailsResponse.getValue()).getHoldData();
        if (productDetailsResponse != null && (data = productDetailsResponse.getData()) != null && (ipBrandFloorVO = data.getIpBrandFloorVO()) != null && (ipRightList = ipBrandFloorVO.getIpRightList()) != null && (ipRightInfo = (IpBrandFloor.IpRightInfo) CollectionsKt.firstOrNull(ipRightList)) != null) {
            str = ipRightInfo.getIpRightId();
        }
        String ipRightId = str;
        if (ipRightId != null) {
            getIPFeedRecommend(ipRightId, this.itemsId);
        }
        handleAutoFetchCoupons();
    }

    public final void clearUpCouponDisplayState() {
        Object prevValue$iv;
        MutableStateFlow $this$update$iv = this._upCouponDisplayStateFlow;
        do {
            prevValue$iv = $this$update$iv.getValue();
            ProductDetailsPageUpCouponDisplayModel productDetailsPageUpCouponDisplayModel = (ProductDetailsPageUpCouponDisplayModel) prevValue$iv;
        } while (!$this$update$iv.compareAndSet(prevValue$iv, (Object) null));
    }

    private final void handleAutoFetchCoupons() {
        CouponPackageInfoModel couponPackageInfoModel;
        Object prevValue$iv;
        Object nextValue$iv;
        Object obj;
        CouponPackageInfoModel it;
        ProductDetailsResponse.ProductDetailsData data;
        FooterFloor footerFloorVO;
        ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) ((ProductDetailsPageDataState) this._productDetailsResponse.getValue()).getHoldData();
        List couponPackageInfos = (productDetailsResponse == null || (data = productDetailsResponse.getData()) == null || (footerFloorVO = data.getFooterFloorVO()) == null) ? null : footerFloorVO.getCouponPackageInfos();
        if (couponPackageInfos != null) {
            Iterator<T> it2 = couponPackageInfos.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                Byte showCouponType = ((CouponPackageInfoModel) obj).getShowCouponType();
                if (showCouponType == null || showCouponType.byteValue() != 10) {
                    it = null;
                    continue;
                } else {
                    it = 1;
                    continue;
                }
                if (it != null) {
                    break;
                }
            }
            couponPackageInfoModel = (CouponPackageInfoModel) obj;
        } else {
            couponPackageInfoModel = null;
        }
        CouponPackageInfoModel upCouponPackageInfo = couponPackageInfoModel;
        if (upCouponPackageInfo != null) {
            int i = 2;
            if (Intrinsics.areEqual(upCouponPackageInfo.getReceived(), true) && Intrinsics.areEqual(upCouponPackageInfo.getPopup(), true)) {
                MutableStateFlow $this$update$iv = this._upCouponDisplayStateFlow;
                do {
                    prevValue$iv = $this$update$iv.getValue();
                    ProductDetailsPageUpCouponDisplayModel productDetailsPageUpCouponDisplayModel = (ProductDetailsPageUpCouponDisplayModel) prevValue$iv;
                    nextValue$iv = new ProductDetailsPageUpCouponDisplayModel(upCouponPackageInfo.getPackagePopInfoVO(), (List) null, 2, (DefaultConstructorMarker) null);
                } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
            } else if (Intrinsics.areEqual(upCouponPackageInfo.getAutoReceive(), true)) {
                CouponPackageInfoModel.CouponPackagePopInfoModel packagePopInfoVO = upCouponPackageInfo.getPackagePopInfoVO();
                List couponInfoList = packagePopInfoVO != null ? packagePopInfoVO.getCouponInfoList() : null;
                List list = couponInfoList;
                if (list == null || list.isEmpty()) {
                    return;
                }
                List $this$map$iv = couponInfoList;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    CouponInfoModel it3 = (CouponInfoModel) item$iv$iv;
                    Pair[] pairArr = new Pair[i];
                    pairArr[0] = TuplesKt.to("sourceId", it3.getSourceId());
                    pairArr[1] = TuplesKt.to("sourceAuthorityId", it3.getSourceAuthorityId());
                    destination$iv$iv.add(MapsKt.mapOf(pairArr));
                    i = 2;
                }
                List sourceInfos = (List) destination$iv$iv;
                BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ProductDetailsPageService$handleAutoFetchCoupons$2(upCouponPackageInfo, sourceInfos, this, null), 3, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportLoadFinished(boolean isFirst) {
    }

    static /* synthetic */ void updateState$default(ProductDetailsPageService $this, MutableStateFlow $receiver, ProductDetailsPageDataState.ProductDetailsPageStatus pageStatus, Object holdData, String errorMessage, int i, Object obj) {
        Object prevValue$iv;
        Object nextValue$iv;
        if ((i & 2) != 0) {
            holdData = null;
        }
        if ((i & 4) != 0) {
            errorMessage = null;
        }
        do {
            prevValue$iv = $receiver.getValue();
            ProductDetailsPageDataState productDetailsPageDataState = (ProductDetailsPageDataState) prevValue$iv;
            nextValue$iv = new ProductDetailsPageDataState(pageStatus, holdData, errorMessage);
        } while (!$receiver.compareAndSet(prevValue$iv, nextValue$iv));
    }

    private final <T> void updateState(MutableStateFlow<ProductDetailsPageDataState<T>> mutableStateFlow, ProductDetailsPageDataState.ProductDetailsPageStatus pageStatus, T t, String errorMessage) {
        Object prevValue$iv;
        Object nextValue$iv;
        do {
            prevValue$iv = mutableStateFlow.getValue();
            ProductDetailsPageDataState productDetailsPageDataState = (ProductDetailsPageDataState) prevValue$iv;
            nextValue$iv = new ProductDetailsPageDataState(pageStatus, t, errorMessage);
        } while (!mutableStateFlow.compareAndSet(prevValue$iv, nextValue$iv));
    }

    static /* synthetic */ void updateShareState$default(ProductDetailsPageService $this, MutableStateFlow $receiver, ProductShareActionState.ProductShareStatus pageStatus, Object holdData, String errorMessage, int i, Object obj) {
        Object prevValue$iv;
        Object nextValue$iv;
        if ((i & 2) != 0) {
            holdData = null;
        }
        if ((i & 4) != 0) {
            errorMessage = null;
        }
        do {
            prevValue$iv = $receiver.getValue();
            ProductShareActionState productShareActionState = (ProductShareActionState) prevValue$iv;
            nextValue$iv = new ProductShareActionState(pageStatus, holdData, errorMessage);
        } while (!$receiver.compareAndSet(prevValue$iv, nextValue$iv));
    }

    private final <T> void updateShareState(MutableStateFlow<ProductShareActionState<T>> mutableStateFlow, ProductShareActionState.ProductShareStatus pageStatus, T t, String errorMessage) {
        Object prevValue$iv;
        Object nextValue$iv;
        do {
            prevValue$iv = mutableStateFlow.getValue();
            ProductShareActionState productShareActionState = (ProductShareActionState) prevValue$iv;
            nextValue$iv = new ProductShareActionState(pageStatus, t, errorMessage);
        } while (!mutableStateFlow.compareAndSet(prevValue$iv, nextValue$iv));
    }
}