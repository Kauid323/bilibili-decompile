package kntr.app.mall.product.details.page.api;

import com.bilibili.mall.kmm.base.MallEnvKt;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import java.util.Map;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
import kntr.app.mall.product.details.page.utils.DateFormatKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.upper.trace.config.CommonProjectType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: ProductApiService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0080@¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0080@¢\u0006\u0004\b\u0015\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R,\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductApiService;", "", "<init>", "()V", "API_URL_STRING", "", "K_LOG_TAG", "recentTimeConsuming", "Lkotlin/Triple;", "", "getRecentTimeConsuming", "()Lkotlin/Triple;", "setRecentTimeConsuming", "(Lkotlin/Triple;)V", "getProductDetails", "Lkntr/app/mall/product/details/page/api/model/ProductDetailsResponse;", "params", "Lkntr/app/mall/product/details/page/api/ProductApiService$ProductDetailRequest;", "getProductDetails$product_details_page_debug", "(Lkntr/app/mall/product/details/page/api/ProductApiService$ProductDetailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mallKntrGetProductDetails", "mallKntrGetProductDetails$product_details_page_debug", "ProductDetailRequest", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ProductApiService {
    private static final String API_URL_STRING = "https://mall.bilibili.com/mall-search-items/items_detail/info";
    private static final String K_LOG_TAG = "NA_WR_ProductApiService";
    public static final ProductApiService INSTANCE = new ProductApiService();
    private static Triple<Long, Long, Long> recentTimeConsuming = new Triple<>(0L, 0L, 0L);
    public static final int $stable = 8;

    private ProductApiService() {
    }

    /* compiled from: ProductApiService.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 c2\u00020\u0001:\u0003abcB\u0083\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u001c\u0010\u001dBí\u0001\b\u0010\u0012\u0006\u0010\u001e\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001c\u0010!J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010A\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010B\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010C\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010D\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010E\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010F\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010'J\u008a\u0002\u0010S\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010TJ\u0013\u0010U\u001a\u00020\t2\b\u0010V\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010W\u001a\u00020\u0007HÖ\u0001J\t\u0010X\u001a\u00020\u0005HÖ\u0001J%\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_H\u0001¢\u0006\u0002\b`R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010(\u001a\u0004\b/\u0010'R\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010+\u001a\u0004\b0\u0010*R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010.\u001a\u0004\b1\u0010-R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010.\u001a\u0004\b2\u0010-R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010(\u001a\u0004\b4\u0010'R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010%R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010%R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010%R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010%R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010%R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010%R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010.\u001a\u0004\b:\u0010-R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010%R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010%R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010(\u001a\u0004\b=\u0010'¨\u0006d"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductApiService$ProductDetailRequest;", "", "appQuery", "Lkntr/app/mall/product/details/page/api/ProductApiService$ProductDetailRequest$AppQuery;", "buvid", "", "channels", "", "half", "", "itemsId", "", "itemsVersion", "microDetail", "mid", "roomId", "scene", "shopId", "ua", "msource", "trackId", "from", "isAd", "fromSpmId", "addrId", "originUrl", "timeZone", "themeMode", "<init>", "(Lkntr/app/mall/product/details/page/api/ProductApiService$ProductDetailRequest$AppQuery;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/mall/product/details/page/api/ProductApiService$ProductDetailRequest$AppQuery;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAppQuery", "()Lkntr/app/mall/product/details/page/api/ProductApiService$ProductDetailRequest$AppQuery;", "getBuvid", "()Ljava/lang/String;", "getChannels", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHalf", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getItemsId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getItemsVersion", "getMicroDetail", "getMid", "getRoomId", "getScene", "getShopId", "getUa", "getMsource", "getTrackId", "getFrom", "getFromSpmId", "getAddrId", "getOriginUrl", "getTimeZone", "getThemeMode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(Lkntr/app/mall/product/details/page/api/ProductApiService$ProductDetailRequest$AppQuery;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/ProductApiService$ProductDetailRequest;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "AppQuery", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ProductDetailRequest {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final Long addrId;
        private final AppQuery appQuery;
        private final String buvid;
        private final Integer channels;
        private final String from;
        private final String fromSpmId;
        private final Boolean half;
        private final String isAd;
        private final Long itemsId;
        private final Integer itemsVersion;
        private final Boolean microDetail;
        private final Long mid;
        private final String msource;
        private final String originUrl;
        private final Long roomId;
        private final String scene;
        private final Integer shopId;
        private final Integer themeMode;
        private final String timeZone;
        private final String trackId;
        private final String ua;

        public ProductDetailRequest() {
            this((AppQuery) null, (String) null, (Integer) null, (Boolean) null, (Long) null, (Integer) null, (Boolean) null, (Long) null, (Long) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Long) null, (String) null, (String) null, (Integer) null, 2097151, (DefaultConstructorMarker) null);
        }

        public final AppQuery component1() {
            return this.appQuery;
        }

        public final String component10() {
            return this.scene;
        }

        public final Integer component11() {
            return this.shopId;
        }

        public final String component12() {
            return this.ua;
        }

        public final String component13() {
            return this.msource;
        }

        public final String component14() {
            return this.trackId;
        }

        public final String component15() {
            return this.from;
        }

        public final String component16() {
            return this.isAd;
        }

        public final String component17() {
            return this.fromSpmId;
        }

        public final Long component18() {
            return this.addrId;
        }

        public final String component19() {
            return this.originUrl;
        }

        public final String component2() {
            return this.buvid;
        }

        public final String component20() {
            return this.timeZone;
        }

        public final Integer component21() {
            return this.themeMode;
        }

        public final Integer component3() {
            return this.channels;
        }

        public final Boolean component4() {
            return this.half;
        }

        public final Long component5() {
            return this.itemsId;
        }

        public final Integer component6() {
            return this.itemsVersion;
        }

        public final Boolean component7() {
            return this.microDetail;
        }

        public final Long component8() {
            return this.mid;
        }

        public final Long component9() {
            return this.roomId;
        }

        public final ProductDetailRequest copy(AppQuery appQuery, String str, Integer num, Boolean bool, Long l, Integer num2, Boolean bool2, Long l2, Long l3, String str2, Integer num3, String str3, String str4, String str5, String str6, String str7, String str8, Long l4, String str9, String str10, Integer num4) {
            return new ProductDetailRequest(appQuery, str, num, bool, l, num2, bool2, l2, l3, str2, num3, str3, str4, str5, str6, str7, str8, l4, str9, str10, num4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ProductDetailRequest) {
                ProductDetailRequest productDetailRequest = (ProductDetailRequest) obj;
                return Intrinsics.areEqual(this.appQuery, productDetailRequest.appQuery) && Intrinsics.areEqual(this.buvid, productDetailRequest.buvid) && Intrinsics.areEqual(this.channels, productDetailRequest.channels) && Intrinsics.areEqual(this.half, productDetailRequest.half) && Intrinsics.areEqual(this.itemsId, productDetailRequest.itemsId) && Intrinsics.areEqual(this.itemsVersion, productDetailRequest.itemsVersion) && Intrinsics.areEqual(this.microDetail, productDetailRequest.microDetail) && Intrinsics.areEqual(this.mid, productDetailRequest.mid) && Intrinsics.areEqual(this.roomId, productDetailRequest.roomId) && Intrinsics.areEqual(this.scene, productDetailRequest.scene) && Intrinsics.areEqual(this.shopId, productDetailRequest.shopId) && Intrinsics.areEqual(this.ua, productDetailRequest.ua) && Intrinsics.areEqual(this.msource, productDetailRequest.msource) && Intrinsics.areEqual(this.trackId, productDetailRequest.trackId) && Intrinsics.areEqual(this.from, productDetailRequest.from) && Intrinsics.areEqual(this.isAd, productDetailRequest.isAd) && Intrinsics.areEqual(this.fromSpmId, productDetailRequest.fromSpmId) && Intrinsics.areEqual(this.addrId, productDetailRequest.addrId) && Intrinsics.areEqual(this.originUrl, productDetailRequest.originUrl) && Intrinsics.areEqual(this.timeZone, productDetailRequest.timeZone) && Intrinsics.areEqual(this.themeMode, productDetailRequest.themeMode);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((this.appQuery == null ? 0 : this.appQuery.hashCode()) * 31) + (this.buvid == null ? 0 : this.buvid.hashCode())) * 31) + (this.channels == null ? 0 : this.channels.hashCode())) * 31) + (this.half == null ? 0 : this.half.hashCode())) * 31) + (this.itemsId == null ? 0 : this.itemsId.hashCode())) * 31) + (this.itemsVersion == null ? 0 : this.itemsVersion.hashCode())) * 31) + (this.microDetail == null ? 0 : this.microDetail.hashCode())) * 31) + (this.mid == null ? 0 : this.mid.hashCode())) * 31) + (this.roomId == null ? 0 : this.roomId.hashCode())) * 31) + (this.scene == null ? 0 : this.scene.hashCode())) * 31) + (this.shopId == null ? 0 : this.shopId.hashCode())) * 31) + (this.ua == null ? 0 : this.ua.hashCode())) * 31) + (this.msource == null ? 0 : this.msource.hashCode())) * 31) + (this.trackId == null ? 0 : this.trackId.hashCode())) * 31) + (this.from == null ? 0 : this.from.hashCode())) * 31) + (this.isAd == null ? 0 : this.isAd.hashCode())) * 31) + (this.fromSpmId == null ? 0 : this.fromSpmId.hashCode())) * 31) + (this.addrId == null ? 0 : this.addrId.hashCode())) * 31) + (this.originUrl == null ? 0 : this.originUrl.hashCode())) * 31) + (this.timeZone == null ? 0 : this.timeZone.hashCode())) * 31) + (this.themeMode != null ? this.themeMode.hashCode() : 0);
        }

        public String toString() {
            AppQuery appQuery = this.appQuery;
            String str = this.buvid;
            Integer num = this.channels;
            Boolean bool = this.half;
            Long l = this.itemsId;
            Integer num2 = this.itemsVersion;
            Boolean bool2 = this.microDetail;
            Long l2 = this.mid;
            Long l3 = this.roomId;
            String str2 = this.scene;
            Integer num3 = this.shopId;
            String str3 = this.ua;
            String str4 = this.msource;
            String str5 = this.trackId;
            String str6 = this.from;
            String str7 = this.isAd;
            String str8 = this.fromSpmId;
            Long l4 = this.addrId;
            String str9 = this.originUrl;
            String str10 = this.timeZone;
            return "ProductDetailRequest(appQuery=" + appQuery + ", buvid=" + str + ", channels=" + num + ", half=" + bool + ", itemsId=" + l + ", itemsVersion=" + num2 + ", microDetail=" + bool2 + ", mid=" + l2 + ", roomId=" + l3 + ", scene=" + str2 + ", shopId=" + num3 + ", ua=" + str3 + ", msource=" + str4 + ", trackId=" + str5 + ", from=" + str6 + ", isAd=" + str7 + ", fromSpmId=" + str8 + ", addrId=" + l4 + ", originUrl=" + str9 + ", timeZone=" + str10 + ", themeMode=" + this.themeMode + ")";
        }

        /* compiled from: ProductApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductApiService$ProductDetailRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ProductApiService$ProductDetailRequest;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ProductDetailRequest> serializer() {
                return new GeneratedSerializer<ProductDetailRequest>() { // from class: kntr.app.mall.product.details.page.api.ProductApiService$ProductDetailRequest$$serializer
                    public static final int $stable;
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.ProductApiService.ProductDetailRequest", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.ProductApiService$ProductDetailRequest> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.ProductApiService$ProductDetailRequest> A[REMOVE]) =  kntr.app.mall.product.details.page.api.ProductApiService$ProductDetailRequest$$serializer.INSTANCE kntr.app.mall.product.details.page.api.ProductApiService$ProductDetailRequest$$serializer)
                             in method: kntr.app.mall.product.details.page.api.ProductApiService.ProductDetailRequest.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.ProductApiService$ProductDetailRequest>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                            	at java.util.ArrayList.forEach(ArrayList.java:1257)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:309)
                            	... 5 more
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: CONSTRUCTOR  (r0v1 'pluginGeneratedSerialDescriptor' kotlinx.serialization.descriptors.SerialDescriptor) = 
                              ("kntr.app.mall.product.details.page.api.ProductApiService.ProductDetailRequest")
                              (wrap: kntr.app.mall.product.details.page.api.ProductApiService$ProductDetailRequest$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.ProductApiService$ProductDetailRequest$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.ProductApiService$ProductDetailRequest$$serializer.INSTANCE kntr.app.mall.product.details.page.api.ProductApiService$ProductDetailRequest$$serializer)
                              (21 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.ProductApiService$ProductDetailRequest$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                            	... 5 more
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.ProductApiService$ProductDetailRequest$$serializer
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:775)
                            	at jadx.core.codegen.InsnGen.staticField(InsnGen.java:224)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:491)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:765)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                            	... 15 more
                            */
                        /*
                            this = this;
                            kntr.app.mall.product.details.page.api.ProductApiService$ProductDetailRequest$$serializer r0 = kntr.app.mall.product.details.page.api.ProductApiService$ProductDetailRequest$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.ProductApiService.ProductDetailRequest.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ ProductDetailRequest(int seen0, AppQuery appQuery, String buvid, Integer channels, Boolean half, Long itemsId, Integer itemsVersion, Boolean microDetail, Long mid, Long roomId, String scene, Integer shopId, String ua, String msource, String trackId, String from, String isAd, String fromSpmId, Long addrId, String originUrl, String timeZone, Integer themeMode, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.appQuery = null;
                    } else {
                        this.appQuery = appQuery;
                    }
                    if ((seen0 & 2) == 0) {
                        this.buvid = null;
                    } else {
                        this.buvid = buvid;
                    }
                    if ((seen0 & 4) == 0) {
                        this.channels = null;
                    } else {
                        this.channels = channels;
                    }
                    if ((seen0 & 8) == 0) {
                        this.half = null;
                    } else {
                        this.half = half;
                    }
                    if ((seen0 & 16) == 0) {
                        this.itemsId = null;
                    } else {
                        this.itemsId = itemsId;
                    }
                    if ((seen0 & 32) == 0) {
                        this.itemsVersion = null;
                    } else {
                        this.itemsVersion = itemsVersion;
                    }
                    if ((seen0 & 64) == 0) {
                        this.microDetail = null;
                    } else {
                        this.microDetail = microDetail;
                    }
                    if ((seen0 & 128) == 0) {
                        this.mid = null;
                    } else {
                        this.mid = mid;
                    }
                    if ((seen0 & 256) == 0) {
                        this.roomId = null;
                    } else {
                        this.roomId = roomId;
                    }
                    if ((seen0 & 512) == 0) {
                        this.scene = null;
                    } else {
                        this.scene = scene;
                    }
                    if ((seen0 & 1024) == 0) {
                        this.shopId = null;
                    } else {
                        this.shopId = shopId;
                    }
                    if ((seen0 & 2048) == 0) {
                        this.ua = null;
                    } else {
                        this.ua = ua;
                    }
                    if ((seen0 & 4096) == 0) {
                        this.msource = null;
                    } else {
                        this.msource = msource;
                    }
                    if ((seen0 & 8192) == 0) {
                        this.trackId = null;
                    } else {
                        this.trackId = trackId;
                    }
                    if ((seen0 & 16384) == 0) {
                        this.from = null;
                    } else {
                        this.from = from;
                    }
                    if ((seen0 & 32768) == 0) {
                        this.isAd = null;
                    } else {
                        this.isAd = isAd;
                    }
                    if ((seen0 & 65536) == 0) {
                        this.fromSpmId = null;
                    } else {
                        this.fromSpmId = fromSpmId;
                    }
                    if ((seen0 & 131072) == 0) {
                        this.addrId = null;
                    } else {
                        this.addrId = addrId;
                    }
                    if ((seen0 & 262144) == 0) {
                        this.originUrl = null;
                    } else {
                        this.originUrl = originUrl;
                    }
                    if ((seen0 & 524288) == 0) {
                        this.timeZone = null;
                    } else {
                        this.timeZone = timeZone;
                    }
                    if ((seen0 & 1048576) == 0) {
                        this.themeMode = 1;
                    } else {
                        this.themeMode = themeMode;
                    }
                }

                public ProductDetailRequest(AppQuery appQuery, String buvid, Integer channels, Boolean half, Long itemsId, Integer itemsVersion, Boolean microDetail, Long mid, Long roomId, String scene, Integer shopId, String ua, String msource, String trackId, String from, String isAd, String fromSpmId, Long addrId, String originUrl, String timeZone, Integer themeMode) {
                    this.appQuery = appQuery;
                    this.buvid = buvid;
                    this.channels = channels;
                    this.half = half;
                    this.itemsId = itemsId;
                    this.itemsVersion = itemsVersion;
                    this.microDetail = microDetail;
                    this.mid = mid;
                    this.roomId = roomId;
                    this.scene = scene;
                    this.shopId = shopId;
                    this.ua = ua;
                    this.msource = msource;
                    this.trackId = trackId;
                    this.from = from;
                    this.isAd = isAd;
                    this.fromSpmId = fromSpmId;
                    this.addrId = addrId;
                    this.originUrl = originUrl;
                    this.timeZone = timeZone;
                    this.themeMode = themeMode;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(ProductDetailRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Integer num;
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.appQuery != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, ProductApiService$ProductDetailRequest$AppQuery$$serializer.INSTANCE, self.appQuery);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.buvid != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.buvid);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.channels != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.channels);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.half != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.half);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.itemsId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 4, LongSerializer.INSTANCE, self.itemsId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 5) || self.itemsVersion != null) {
                        output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.itemsVersion);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 6) || self.microDetail != null) {
                        output.encodeNullableSerializableElement(serialDesc, 6, BooleanSerializer.INSTANCE, self.microDetail);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 7) || self.mid != null) {
                        output.encodeNullableSerializableElement(serialDesc, 7, LongSerializer.INSTANCE, self.mid);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 8) || self.roomId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 8, LongSerializer.INSTANCE, self.roomId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 9) || self.scene != null) {
                        output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.scene);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 10) || self.shopId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 10, IntSerializer.INSTANCE, self.shopId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 11) || self.ua != null) {
                        output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.ua);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 12) || self.msource != null) {
                        output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.msource);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 13) || self.trackId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.trackId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 14) || self.from != null) {
                        output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.from);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 15) || self.isAd != null) {
                        output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.isAd);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 16) || self.fromSpmId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.fromSpmId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 17) || self.addrId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 17, LongSerializer.INSTANCE, self.addrId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 18) || self.originUrl != null) {
                        output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.originUrl);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 19) || self.timeZone != null) {
                        output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.timeZone);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 20) || (num = self.themeMode) == null || num.intValue() != 1) {
                        output.encodeNullableSerializableElement(serialDesc, 20, IntSerializer.INSTANCE, self.themeMode);
                    }
                }

                public /* synthetic */ ProductDetailRequest(AppQuery appQuery, String str, Integer num, Boolean bool, Long l, Integer num2, Boolean bool2, Long l2, Long l3, String str2, Integer num3, String str3, String str4, String str5, String str6, String str7, String str8, Long l4, String str9, String str10, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : appQuery, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : bool2, (i & 128) != 0 ? null : l2, (i & 256) != 0 ? null : l3, (i & 512) != 0 ? null : str2, (i & 1024) != 0 ? null : num3, (i & 2048) != 0 ? null : str3, (i & 4096) != 0 ? null : str4, (i & 8192) != 0 ? null : str5, (i & 16384) != 0 ? null : str6, (i & 32768) != 0 ? null : str7, (i & 65536) != 0 ? null : str8, (i & 131072) != 0 ? null : l4, (i & 262144) != 0 ? null : str9, (i & 524288) != 0 ? null : str10, (i & 1048576) != 0 ? 1 : num4);
                }

                public final AppQuery getAppQuery() {
                    return this.appQuery;
                }

                public final String getBuvid() {
                    return this.buvid;
                }

                public final Integer getChannels() {
                    return this.channels;
                }

                public final Boolean getHalf() {
                    return this.half;
                }

                public final Long getItemsId() {
                    return this.itemsId;
                }

                public final Integer getItemsVersion() {
                    return this.itemsVersion;
                }

                public final Boolean getMicroDetail() {
                    return this.microDetail;
                }

                public final Long getMid() {
                    return this.mid;
                }

                public final Long getRoomId() {
                    return this.roomId;
                }

                public final String getScene() {
                    return this.scene;
                }

                public final Integer getShopId() {
                    return this.shopId;
                }

                public final String getUa() {
                    return this.ua;
                }

                public final String getMsource() {
                    return this.msource;
                }

                public final String getTrackId() {
                    return this.trackId;
                }

                public final String getFrom() {
                    return this.from;
                }

                public final String isAd() {
                    return this.isAd;
                }

                public final String getFromSpmId() {
                    return this.fromSpmId;
                }

                public final Long getAddrId() {
                    return this.addrId;
                }

                public final String getOriginUrl() {
                    return this.originUrl;
                }

                public final String getTimeZone() {
                    return this.timeZone;
                }

                /* compiled from: ProductApiService.kt */
                @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0002/0BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fBW\b\u0010\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\bHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0004\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u00061"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductApiService$ProductDetailRequest$AppQuery;", "", "build", "", "isDegrate", "", "mobi_app", "mversion", "", CommonProjectType.NETWORK, "platform", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBuild", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMobi_app", "getMversion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNetwork", "getPlatform", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/ProductApiService$ProductDetailRequest$AppQuery;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                @Serializable
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class AppQuery {
                    public static final int $stable = 0;
                    public static final Companion Companion = new Companion(null);
                    private final String build;
                    private final Boolean isDegrate;
                    private final String mobi_app;
                    private final Integer mversion;
                    private final String network;
                    private final String platform;

                    public AppQuery() {
                        this((String) null, (Boolean) null, (String) null, (Integer) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
                    }

                    public static /* synthetic */ AppQuery copy$default(AppQuery appQuery, String str, Boolean bool, String str2, Integer num, String str3, String str4, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = appQuery.build;
                        }
                        if ((i & 2) != 0) {
                            bool = appQuery.isDegrate;
                        }
                        Boolean bool2 = bool;
                        if ((i & 4) != 0) {
                            str2 = appQuery.mobi_app;
                        }
                        String str5 = str2;
                        if ((i & 8) != 0) {
                            num = appQuery.mversion;
                        }
                        Integer num2 = num;
                        if ((i & 16) != 0) {
                            str3 = appQuery.network;
                        }
                        String str6 = str3;
                        if ((i & 32) != 0) {
                            str4 = appQuery.platform;
                        }
                        return appQuery.copy(str, bool2, str5, num2, str6, str4);
                    }

                    public final String component1() {
                        return this.build;
                    }

                    public final Boolean component2() {
                        return this.isDegrate;
                    }

                    public final String component3() {
                        return this.mobi_app;
                    }

                    public final Integer component4() {
                        return this.mversion;
                    }

                    public final String component5() {
                        return this.network;
                    }

                    public final String component6() {
                        return this.platform;
                    }

                    public final AppQuery copy(String str, Boolean bool, String str2, Integer num, String str3, String str4) {
                        return new AppQuery(str, bool, str2, num, str3, str4);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof AppQuery) {
                            AppQuery appQuery = (AppQuery) obj;
                            return Intrinsics.areEqual(this.build, appQuery.build) && Intrinsics.areEqual(this.isDegrate, appQuery.isDegrate) && Intrinsics.areEqual(this.mobi_app, appQuery.mobi_app) && Intrinsics.areEqual(this.mversion, appQuery.mversion) && Intrinsics.areEqual(this.network, appQuery.network) && Intrinsics.areEqual(this.platform, appQuery.platform);
                        }
                        return false;
                    }

                    public int hashCode() {
                        return ((((((((((this.build == null ? 0 : this.build.hashCode()) * 31) + (this.isDegrate == null ? 0 : this.isDegrate.hashCode())) * 31) + (this.mobi_app == null ? 0 : this.mobi_app.hashCode())) * 31) + (this.mversion == null ? 0 : this.mversion.hashCode())) * 31) + (this.network == null ? 0 : this.network.hashCode())) * 31) + (this.platform != null ? this.platform.hashCode() : 0);
                    }

                    public String toString() {
                        String str = this.build;
                        Boolean bool = this.isDegrate;
                        String str2 = this.mobi_app;
                        Integer num = this.mversion;
                        String str3 = this.network;
                        return "AppQuery(build=" + str + ", isDegrate=" + bool + ", mobi_app=" + str2 + ", mversion=" + num + ", network=" + str3 + ", platform=" + this.platform + ")";
                    }

                    /* compiled from: ProductApiService.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductApiService$ProductDetailRequest$AppQuery$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ProductApiService$ProductDetailRequest$AppQuery;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<AppQuery> serializer() {
                            return ProductApiService$ProductDetailRequest$AppQuery$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ AppQuery(int seen0, String build, Boolean isDegrate, String mobi_app, Integer mversion, String network, String platform, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((seen0 & 1) == 0) {
                            this.build = null;
                        } else {
                            this.build = build;
                        }
                        if ((seen0 & 2) == 0) {
                            this.isDegrate = null;
                        } else {
                            this.isDegrate = isDegrate;
                        }
                        if ((seen0 & 4) == 0) {
                            this.mobi_app = null;
                        } else {
                            this.mobi_app = mobi_app;
                        }
                        if ((seen0 & 8) == 0) {
                            this.mversion = null;
                        } else {
                            this.mversion = mversion;
                        }
                        if ((seen0 & 16) == 0) {
                            this.network = "";
                        } else {
                            this.network = network;
                        }
                        if ((seen0 & 32) == 0) {
                            this.platform = null;
                        } else {
                            this.platform = platform;
                        }
                    }

                    public AppQuery(String build, Boolean isDegrate, String mobi_app, Integer mversion, String network, String platform) {
                        this.build = build;
                        this.isDegrate = isDegrate;
                        this.mobi_app = mobi_app;
                        this.mversion = mversion;
                        this.network = network;
                        this.platform = platform;
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$product_details_page_debug(AppQuery self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.build != null) {
                            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.build);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.isDegrate != null) {
                            output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.isDegrate);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.mobi_app != null) {
                            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.mobi_app);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.mversion != null) {
                            output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.mversion);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.network, "")) {
                            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.network);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.platform != null) {
                            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.platform);
                        }
                    }

                    public /* synthetic */ AppQuery(String str, Boolean bool, String str2, Integer num, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? "" : str3, (i & 32) != 0 ? null : str4);
                    }

                    public final String getBuild() {
                        return this.build;
                    }

                    public final Boolean isDegrate() {
                        return this.isDegrate;
                    }

                    public final String getMobi_app() {
                        return this.mobi_app;
                    }

                    public final Integer getMversion() {
                        return this.mversion;
                    }

                    public final String getNetwork() {
                        return this.network;
                    }

                    public final String getPlatform() {
                        return this.platform;
                    }
                }

                public final Integer getThemeMode() {
                    return this.themeMode;
                }
            }

            public final Triple<Long, Long, Long> getRecentTimeConsuming() {
                return recentTimeConsuming;
            }

            public final void setRecentTimeConsuming(Triple<Long, Long, Long> triple) {
                Intrinsics.checkNotNullParameter(triple, "<set-?>");
                recentTimeConsuming = triple;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0057  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0090  */
            /* JADX WARN: Removed duplicated region for block: B:53:0x0195 A[Catch: Exception -> 0x0231, TryCatch #7 {Exception -> 0x0231, blocks: (B:67:0x0224, B:69:0x0228, B:70:0x0230, B:51:0x0182, B:53:0x0195, B:55:0x01dc, B:62:0x01f5), top: B:93:0x0182 }] */
            /* JADX WARN: Removed duplicated region for block: B:55:0x01dc A[Catch: Exception -> 0x0231, TRY_LEAVE, TryCatch #7 {Exception -> 0x0231, blocks: (B:67:0x0224, B:69:0x0228, B:70:0x0230, B:51:0x0182, B:53:0x0195, B:55:0x01dc, B:62:0x01f5), top: B:93:0x0182 }] */
            /* JADX WARN: Removed duplicated region for block: B:67:0x0224 A[Catch: Exception -> 0x0231, TryCatch #7 {Exception -> 0x0231, blocks: (B:67:0x0224, B:69:0x0228, B:70:0x0230, B:51:0x0182, B:53:0x0195, B:55:0x01dc, B:62:0x01f5), top: B:93:0x0182 }] */
            /* JADX WARN: Removed duplicated region for block: B:69:0x0228 A[Catch: Exception -> 0x0231, TryCatch #7 {Exception -> 0x0231, blocks: (B:67:0x0224, B:69:0x0228, B:70:0x0230, B:51:0x0182, B:53:0x0195, B:55:0x01dc, B:62:0x01f5), top: B:93:0x0182 }] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object getProductDetails$product_details_page_debug(ProductDetailRequest params, Continuation<? super ProductDetailsResponse> continuation) {
                ProductApiService$getProductDetails$1 productApiService$getProductDetails$1;
                ProductApiService$getProductDetails$1 productApiService$getProductDetails$12;
                HttpClient $this$post$iv;
                HttpMessageBuilder httpRequestBuilder;
                KType kType;
                Object execute;
                ProductDetailRequest params2;
                KType kType2;
                HttpResponse response;
                KType kType3;
                Object bodyNullable;
                if (continuation instanceof ProductApiService$getProductDetails$1) {
                    productApiService$getProductDetails$1 = (ProductApiService$getProductDetails$1) continuation;
                    if ((productApiService$getProductDetails$1.label & Integer.MIN_VALUE) != 0) {
                        productApiService$getProductDetails$1.label -= Integer.MIN_VALUE;
                        productApiService$getProductDetails$12 = productApiService$getProductDetails$1;
                        Object $result = productApiService$getProductDetails$12.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (productApiService$getProductDetails$12.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                try {
                                    $this$post$iv = Client.INSTANCE.getHttpClient();
                                    httpRequestBuilder = new HttpRequestBuilder();
                                    HttpRequestKt.url(httpRequestBuilder, API_URL_STRING);
                                    HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
                                } catch (Exception e) {
                                    e = e;
                                }
                                try {
                                    if (params == null) {
                                        httpRequestBuilder.setBody(NullBody.INSTANCE);
                                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ProductDetailRequest.class);
                                        try {
                                            kType2 = Reflection.typeOf(ProductDetailRequest.class);
                                        } catch (Throwable th) {
                                            kType2 = null;
                                        }
                                        httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType2));
                                    } else if (params instanceof OutgoingContent) {
                                        httpRequestBuilder.setBody(params);
                                        httpRequestBuilder.setBodyType((TypeInfo) null);
                                    } else {
                                        httpRequestBuilder.setBody(params);
                                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ProductDetailRequest.class);
                                        try {
                                            kType = Reflection.typeOf(ProductDetailRequest.class);
                                        } catch (Throwable th2) {
                                            kType = null;
                                        }
                                        httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass2, kType));
                                    }
                                    httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
                                    HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, $this$post$iv);
                                    productApiService$getProductDetails$12.L$0 = SpillingKt.nullOutSpilledVariable(params);
                                    productApiService$getProductDetails$12.L$1 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                    productApiService$getProductDetails$12.L$2 = SpillingKt.nullOutSpilledVariable(API_URL_STRING);
                                    productApiService$getProductDetails$12.L$3 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                    productApiService$getProductDetails$12.L$4 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                    productApiService$getProductDetails$12.L$5 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                                    productApiService$getProductDetails$12.L$6 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                    productApiService$getProductDetails$12.I$0 = 0;
                                    productApiService$getProductDetails$12.I$1 = 0;
                                    productApiService$getProductDetails$12.I$2 = 0;
                                    productApiService$getProductDetails$12.I$3 = 0;
                                    productApiService$getProductDetails$12.label = 1;
                                    execute = httpStatement.execute(productApiService$getProductDetails$12);
                                    if (execute == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    params2 = params;
                                    try {
                                        response = (HttpResponse) execute;
                                        if (Intrinsics.areEqual(response.getStatus(), HttpStatusCode.Companion.getOK())) {
                                            KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch product details: " + response.getStatus());
                                            return new ProductDetailsResponse(Boxing.boxInt(-1), (Integer) null, "Failed to fetch product details: " + response.getStatus(), (ProductDetailsResponse.ProductDetailsData) null, 10, (DefaultConstructorMarker) null);
                                        }
                                        HttpClientCall call = response.getCall();
                                        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(ProductDetailsResponse.class);
                                        try {
                                            kType3 = Reflection.typeOf(ProductDetailsResponse.class);
                                        } catch (Throwable th3) {
                                            kType3 = null;
                                        }
                                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass3, kType3);
                                        productApiService$getProductDetails$12.L$0 = SpillingKt.nullOutSpilledVariable(params2);
                                        productApiService$getProductDetails$12.L$1 = SpillingKt.nullOutSpilledVariable(response);
                                        productApiService$getProductDetails$12.L$2 = SpillingKt.nullOutSpilledVariable(response);
                                        productApiService$getProductDetails$12.L$3 = null;
                                        productApiService$getProductDetails$12.L$4 = null;
                                        productApiService$getProductDetails$12.L$5 = null;
                                        productApiService$getProductDetails$12.L$6 = null;
                                        productApiService$getProductDetails$12.I$0 = 0;
                                        productApiService$getProductDetails$12.label = 2;
                                        bodyNullable = call.bodyNullable(typeInfo, productApiService$getProductDetails$12);
                                        if (bodyNullable == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        if (bodyNullable == null) {
                                            ProductDetailsResponse rtValue = (ProductDetailsResponse) bodyNullable;
                                            return rtValue;
                                        }
                                        throw new NullPointerException("null cannot be cast to non-null type kntr.app.mall.product.details.page.api.model.ProductDetailsResponse");
                                    } catch (Exception e2) {
                                        e = e2;
                                        KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch product details: " + e.getMessage(), e);
                                        return new ProductDetailsResponse(Boxing.boxInt(-1), (Integer) null, "Failed to fetch product details: " + e.getMessage(), (ProductDetailsResponse.ProductDetailsData) null, 10, (DefaultConstructorMarker) null);
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch product details: " + e.getMessage(), e);
                                    return new ProductDetailsResponse(Boxing.boxInt(-1), (Integer) null, "Failed to fetch product details: " + e.getMessage(), (ProductDetailsResponse.ProductDetailsData) null, 10, (DefaultConstructorMarker) null);
                                }
                            case 1:
                                int i = productApiService$getProductDetails$12.I$3;
                                int i2 = productApiService$getProductDetails$12.I$2;
                                int i3 = productApiService$getProductDetails$12.I$1;
                                int i4 = productApiService$getProductDetails$12.I$0;
                                HttpClient httpClient = (HttpClient) productApiService$getProductDetails$12.L$6;
                                HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) productApiService$getProductDetails$12.L$5;
                                HttpClient httpClient2 = (HttpClient) productApiService$getProductDetails$12.L$4;
                                HttpClient httpClient3 = (HttpClient) productApiService$getProductDetails$12.L$3;
                                String str = (String) productApiService$getProductDetails$12.L$2;
                                HttpClient httpClient4 = (HttpClient) productApiService$getProductDetails$12.L$1;
                                params2 = (ProductDetailRequest) productApiService$getProductDetails$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    execute = $result;
                                    response = (HttpResponse) execute;
                                    if (Intrinsics.areEqual(response.getStatus(), HttpStatusCode.Companion.getOK())) {
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch product details: " + e.getMessage(), e);
                                    return new ProductDetailsResponse(Boxing.boxInt(-1), (Integer) null, "Failed to fetch product details: " + e.getMessage(), (ProductDetailsResponse.ProductDetailsData) null, 10, (DefaultConstructorMarker) null);
                                }
                                break;
                            case 2:
                                int i5 = productApiService$getProductDetails$12.I$0;
                                HttpResponse httpResponse = (HttpResponse) productApiService$getProductDetails$12.L$2;
                                HttpResponse httpResponse2 = (HttpResponse) productApiService$getProductDetails$12.L$1;
                                ProductDetailRequest productDetailRequest = (ProductDetailRequest) productApiService$getProductDetails$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    bodyNullable = $result;
                                    if (bodyNullable == null) {
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch product details: " + e.getMessage(), e);
                                    return new ProductDetailsResponse(Boxing.boxInt(-1), (Integer) null, "Failed to fetch product details: " + e.getMessage(), (ProductDetailsResponse.ProductDetailsData) null, 10, (DefaultConstructorMarker) null);
                                }
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
                productApiService$getProductDetails$1 = new ProductApiService$getProductDetails$1(this, continuation);
                productApiService$getProductDetails$12 = productApiService$getProductDetails$1;
                Object $result2 = productApiService$getProductDetails$12.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (productApiService$getProductDetails$12.label) {
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object mallKntrGetProductDetails$product_details_page_debug(ProductDetailRequest params, Continuation<? super ProductDetailsResponse> continuation) {
                ProductApiService$mallKntrGetProductDetails$1 productApiService$mallKntrGetProductDetails$1;
                ProductApiService$mallKntrGetProductDetails$1 productApiService$mallKntrGetProductDetails$12;
                long startTimestamp;
                Object mallKntrAsyncRequest;
                Client $this$iv;
                try {
                    if (continuation instanceof ProductApiService$mallKntrGetProductDetails$1) {
                        productApiService$mallKntrGetProductDetails$1 = (ProductApiService$mallKntrGetProductDetails$1) continuation;
                        if ((productApiService$mallKntrGetProductDetails$1.label & Integer.MIN_VALUE) != 0) {
                            productApiService$mallKntrGetProductDetails$1.label -= Integer.MIN_VALUE;
                            productApiService$mallKntrGetProductDetails$12 = productApiService$mallKntrGetProductDetails$1;
                            Object $result = productApiService$mallKntrGetProductDetails$12.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (productApiService$mallKntrGetProductDetails$12.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    startTimestamp = DateFormatKt.getCurrentTimeMillis();
                                    try {
                                        Client $this$iv2 = Client.INSTANCE;
                                        Map params$iv = MapsKt.mapOf(new Pair[]{TuplesKt.to("appQuery", params.getAppQuery()), TuplesKt.to("buvid", params.getBuvid()), TuplesKt.to("channels", params.getChannels()), TuplesKt.to("half", params.getHalf()), TuplesKt.to("itemsId", params.getItemsId()), TuplesKt.to("itemsVersion", params.getItemsVersion()), TuplesKt.to("microDetail", params.getMicroDetail()), TuplesKt.to("mid", params.getMid()), TuplesKt.to("roomId", params.getRoomId()), TuplesKt.to("scene", params.getScene()), TuplesKt.to("shopId", params.getShopId()), TuplesKt.to("ua", params.getUa()), TuplesKt.to("msource", params.getMsource()), TuplesKt.to("trackId", params.getTrackId()), TuplesKt.to("from", params.getFrom()), TuplesKt.to("isAd", params.isAd()), TuplesKt.to("fromSpmId", params.getFromSpmId()), TuplesKt.to("addrId", params.getAddrId()), TuplesKt.to("originUrl", params.getOriginUrl()), TuplesKt.to("timeZone", params.getTimeZone()), TuplesKt.to("themeMode", params.getThemeMode())});
                                        try {
                                            productApiService$mallKntrGetProductDetails$12.L$0 = SpillingKt.nullOutSpilledVariable(params);
                                            productApiService$mallKntrGetProductDetails$12.L$1 = $this$iv2;
                                            productApiService$mallKntrGetProductDetails$12.L$2 = SpillingKt.nullOutSpilledVariable(API_URL_STRING);
                                            productApiService$mallKntrGetProductDetails$12.L$3 = SpillingKt.nullOutSpilledVariable("POST");
                                            productApiService$mallKntrGetProductDetails$12.L$4 = SpillingKt.nullOutSpilledVariable(params$iv);
                                            productApiService$mallKntrGetProductDetails$12.J$0 = startTimestamp;
                                            productApiService$mallKntrGetProductDetails$12.I$0 = 0;
                                            productApiService$mallKntrGetProductDetails$12.label = 1;
                                            mallKntrAsyncRequest = MallEnvKt.mallKntrAsyncRequest(API_URL_STRING, "POST", (Map) null, params$iv, productApiService$mallKntrGetProductDetails$12);
                                            if (mallKntrAsyncRequest == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            $this$iv = $this$iv2;
                                            try {
                                                String jsonString$iv = (String) mallKntrAsyncRequest;
                                                Json this_$iv$iv = $this$iv.getJson();
                                                Intrinsics.checkNotNull(jsonString$iv);
                                                this_$iv$iv.getSerializersModule();
                                                Object res$iv = this_$iv$iv.decodeFromString(ProductDetailsResponse.Companion.serializer(), jsonString$iv);
                                                try {
                                                    ProductDetailsResponse response = (ProductDetailsResponse) res$iv;
                                                    long endTimestamp = DateFormatKt.getCurrentTimeMillis();
                                                    recentTimeConsuming = new Triple<>(Boxing.boxLong(startTimestamp), Boxing.boxLong(endTimestamp), Boxing.boxLong(endTimestamp - startTimestamp));
                                                    return response;
                                                } catch (Exception e) {
                                                    e = e;
                                                    KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch product details: " + e.getMessage(), e);
                                                    ProductDetailsResponse response2 = new ProductDetailsResponse(Boxing.boxInt(-1), (Integer) null, "Failed to fetch product details: " + e.getMessage(), (ProductDetailsResponse.ProductDetailsData) null, 10, (DefaultConstructorMarker) null);
                                                    long endTimestamp2 = DateFormatKt.getCurrentTimeMillis();
                                                    recentTimeConsuming = new Triple<>(Boxing.boxLong(startTimestamp), Boxing.boxLong(endTimestamp2), Boxing.boxLong(endTimestamp2 - startTimestamp));
                                                    return response2;
                                                }
                                            } catch (Exception e2) {
                                                e$iv = e2;
                                                try {
                                                    try {
                                                        try {
                                                            KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                                            throw e$iv;
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch product details: " + e.getMessage(), e);
                                                            ProductDetailsResponse response22 = new ProductDetailsResponse(Boxing.boxInt(-1), (Integer) null, "Failed to fetch product details: " + e.getMessage(), (ProductDetailsResponse.ProductDetailsData) null, 10, (DefaultConstructorMarker) null);
                                                            long endTimestamp22 = DateFormatKt.getCurrentTimeMillis();
                                                            recentTimeConsuming = new Triple<>(Boxing.boxLong(startTimestamp), Boxing.boxLong(endTimestamp22), Boxing.boxLong(endTimestamp22 - startTimestamp));
                                                            return response22;
                                                        }
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        long endTimestamp3 = DateFormatKt.getCurrentTimeMillis();
                                                        recentTimeConsuming = new Triple<>(Boxing.boxLong(startTimestamp), Boxing.boxLong(endTimestamp3), Boxing.boxLong(endTimestamp3 - startTimestamp));
                                                        throw th;
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                }
                                            }
                                        } catch (Exception e6) {
                                            e$iv = e6;
                                            KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                            throw e$iv;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            long endTimestamp32 = DateFormatKt.getCurrentTimeMillis();
                                            recentTimeConsuming = new Triple<>(Boxing.boxLong(startTimestamp), Boxing.boxLong(endTimestamp32), Boxing.boxLong(endTimestamp32 - startTimestamp));
                                            throw th;
                                        }
                                    } catch (Exception e7) {
                                        e = e7;
                                        KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch product details: " + e.getMessage(), e);
                                        ProductDetailsResponse response222 = new ProductDetailsResponse(Boxing.boxInt(-1), (Integer) null, "Failed to fetch product details: " + e.getMessage(), (ProductDetailsResponse.ProductDetailsData) null, 10, (DefaultConstructorMarker) null);
                                        long endTimestamp222 = DateFormatKt.getCurrentTimeMillis();
                                        recentTimeConsuming = new Triple<>(Boxing.boxLong(startTimestamp), Boxing.boxLong(endTimestamp222), Boxing.boxLong(endTimestamp222 - startTimestamp));
                                        return response222;
                                    } catch (Throwable th4) {
                                        th = th4;
                                    }
                                case 1:
                                    int i = productApiService$mallKntrGetProductDetails$12.I$0;
                                    startTimestamp = productApiService$mallKntrGetProductDetails$12.J$0;
                                    Map map = (Map) productApiService$mallKntrGetProductDetails$12.L$4;
                                    String str = (String) productApiService$mallKntrGetProductDetails$12.L$3;
                                    String str2 = (String) productApiService$mallKntrGetProductDetails$12.L$2;
                                    Client $this$iv3 = (Client) productApiService$mallKntrGetProductDetails$12.L$1;
                                    ProductDetailRequest productDetailRequest = (ProductDetailRequest) productApiService$mallKntrGetProductDetails$12.L$0;
                                    try {
                                        try {
                                            ResultKt.throwOnFailure($result);
                                            $this$iv = $this$iv3;
                                            mallKntrAsyncRequest = $result;
                                            String jsonString$iv2 = (String) mallKntrAsyncRequest;
                                            Json this_$iv$iv2 = $this$iv.getJson();
                                            Intrinsics.checkNotNull(jsonString$iv2);
                                            this_$iv$iv2.getSerializersModule();
                                            Object res$iv2 = this_$iv$iv2.decodeFromString(ProductDetailsResponse.Companion.serializer(), jsonString$iv2);
                                            ProductDetailsResponse response3 = (ProductDetailsResponse) res$iv2;
                                            long endTimestamp4 = DateFormatKt.getCurrentTimeMillis();
                                            recentTimeConsuming = new Triple<>(Boxing.boxLong(startTimestamp), Boxing.boxLong(endTimestamp4), Boxing.boxLong(endTimestamp4 - startTimestamp));
                                            return response3;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            long endTimestamp322 = DateFormatKt.getCurrentTimeMillis();
                                            recentTimeConsuming = new Triple<>(Boxing.boxLong(startTimestamp), Boxing.boxLong(endTimestamp322), Boxing.boxLong(endTimestamp322 - startTimestamp));
                                            throw th;
                                        }
                                    } catch (Exception e8) {
                                        e$iv = e8;
                                        KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                        throw e$iv;
                                    }
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }
                    switch (productApiService$mallKntrGetProductDetails$12.label) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
                productApiService$mallKntrGetProductDetails$1 = new ProductApiService$mallKntrGetProductDetails$1(this, continuation);
                productApiService$mallKntrGetProductDetails$12 = productApiService$mallKntrGetProductDetails$1;
                Object $result2 = productApiService$mallKntrGetProductDetails$12.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
        }