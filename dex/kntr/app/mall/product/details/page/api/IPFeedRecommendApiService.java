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
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import java.util.Map;
import kntr.app.mall.product.details.page.api.IPFeedRecommendApiService;
import kntr.app.mall.product.details.page.api.model.ActivityInfoFloor;
import kntr.app.mall.product.details.page.api.model.ActivityInfoFloor$AtmosInfo$$serializer;
import kntr.app.mall.product.details.page.api.model.AdvStateFloor;
import kntr.app.mall.product.details.page.api.model.AdvStateFloor$AdvState$$serializer;
import kntr.app.mall.product.details.page.api.model.ShopItem;
import kntr.app.mall.product.details.page.api.model.ShopItem$LabelGroup$$serializer;
import kntr.app.mall.product.details.page.api.model.ShopItem$MerchantInfo$$serializer;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* compiled from: IPFeedRecommendApiService.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003\u000e\u000f\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0080@¢\u0006\u0004\b\n\u0010\u000bJ(\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0080@¢\u0006\u0004\b\r\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService;", "", "<init>", "()V", "API_URL_STRING", "", "getIPFeedRecommend", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$Response;", "ipRightId", "itemIds", "getIPFeedRecommend$product_details_page_debug", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kntrGetIPFeedRecommend", "kntrGetIPFeedRecommend$product_details_page_debug", "RecommendRequestParams", "Response", "IPFeedRecommendModel", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class IPFeedRecommendApiService {
    public static final int $stable = 0;
    public static final String API_URL_STRING = "https://mall.bilibili.com/mall-c-search/ip/items/feed";
    public static final IPFeedRecommendApiService INSTANCE = new IPFeedRecommendApiService();

    private IPFeedRecommendApiService() {
    }

    /* compiled from: IPFeedRecommendApiService.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bJ\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 \u007f2\u00020\u0001:\u0004|}~\u007fBï\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u001e\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b&\u0010'BÉ\u0002\b\u0010\u0012\u0006\u0010(\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u001e\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010)\u001a\u0004\u0018\u00010*¢\u0006\u0004\b&\u0010+J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010S\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010U\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010W\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010]\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010_\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010`\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010AJ\u000b\u0010a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010g\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010h\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eHÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010l\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u001eHÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jö\u0002\u0010n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u001e2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010oJ\u0013\u0010p\u001a\u00020\u00032\b\u0010q\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010r\u001a\u00020\u0005HÖ\u0001J\t\u0010s\u001a\u00020\u0007HÖ\u0001J%\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020\u00002\u0006\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020zH\u0001¢\u0006\u0002\b{R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00101\u001a\u0004\b5\u00100R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00101\u001a\u0004\b6\u00100R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b7\u00103R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b8\u00103R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b9\u00103R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b:\u00103R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00101\u001a\u0004\b;\u00100R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010.\u001a\u0004\b<\u0010-R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b=\u00103R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b>\u00103R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00101\u001a\u0004\b?\u00100R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010B\u001a\u0004\b@\u0010AR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bC\u00103R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010.\u001a\u0004\bD\u0010-R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00101\u001a\u0004\bE\u00100R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00101\u001a\u0004\bF\u00100R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bG\u00103R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00101\u001a\u0004\bH\u00100R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bI\u00103R\u0019\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0013\u0010 \u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bL\u00103R\u0013\u0010!\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bM\u00103R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bN\u00103R\u0019\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\bO\u0010KR\u0013\u0010%\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bP\u00103¨\u0006\u0080\u0001"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$RecommendRequestParams;", "", "allowCache", "", "blindBoxSelectType", "", "build", "", "buvid", "bzType", "channels", "device", "filterType", "from", "fromSpmId", "group", "hightLight", "itemIds", "keyword", "mVersion", "mid", "", "mobiApp", "needMlsFilter", "pageIndex", "pageSize", "pageType", "pageVersion", "platform", "rangeQueries", "", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$RecommendRequestParams$RangeQuery;", "scene", "sortOrder", "sortType", "termQueries", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$RecommendRequestParams$TermQuery;", "trackId", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAllowCache", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBlindBoxSelectType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBuild", "()Ljava/lang/String;", "getBuvid", "getBzType", "getChannels", "getDevice", "getFilterType", "getFrom", "getFromSpmId", "getGroup", "getHightLight", "getItemIds", "getKeyword", "getMVersion", "getMid", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMobiApp", "getNeedMlsFilter", "getPageIndex", "getPageSize", "getPageType", "getPageVersion", "getPlatform", "getRangeQueries", "()Ljava/util/List;", "getScene", "getSortOrder", "getSortType", "getTermQueries", "getTrackId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$RecommendRequestParams;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "RangeQuery", "TermQuery", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class RecommendRequestParams {
        private final Boolean allowCache;
        private final Integer blindBoxSelectType;
        private final String build;
        private final String buvid;
        private final Integer bzType;
        private final Integer channels;
        private final String device;
        private final String filterType;
        private final String from;
        private final String fromSpmId;
        private final Integer group;
        private final Boolean hightLight;
        private final String itemIds;
        private final String keyword;
        private final Integer mVersion;
        private final Long mid;
        private final String mobiApp;
        private final Boolean needMlsFilter;
        private final Integer pageIndex;
        private final Integer pageSize;
        private final String pageType;
        private final Integer pageVersion;
        private final String platform;
        private final List<RangeQuery> rangeQueries;
        private final String scene;
        private final String sortOrder;
        private final String sortType;
        private final List<TermQuery> termQueries;
        private final String trackId;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$RecommendRequestParams$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = IPFeedRecommendApiService.RecommendRequestParams._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$RecommendRequestParams$$ExternalSyntheticLambda1
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$0;
                _childSerializers$_anonymous_$0 = IPFeedRecommendApiService.RecommendRequestParams._childSerializers$_anonymous_$0();
                return _childSerializers$_anonymous_$0;
            }
        }), null};

        public RecommendRequestParams() {
            this((Boolean) null, (Integer) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Boolean) null, (String) null, (String) null, (Integer) null, (Long) null, (String) null, (Boolean) null, (Integer) null, (Integer) null, (String) null, (Integer) null, (String) null, (List) null, (String) null, (String) null, (String) null, (List) null, (String) null, 536870911, (DefaultConstructorMarker) null);
        }

        public final Boolean component1() {
            return this.allowCache;
        }

        public final String component10() {
            return this.fromSpmId;
        }

        public final Integer component11() {
            return this.group;
        }

        public final Boolean component12() {
            return this.hightLight;
        }

        public final String component13() {
            return this.itemIds;
        }

        public final String component14() {
            return this.keyword;
        }

        public final Integer component15() {
            return this.mVersion;
        }

        public final Long component16() {
            return this.mid;
        }

        public final String component17() {
            return this.mobiApp;
        }

        public final Boolean component18() {
            return this.needMlsFilter;
        }

        public final Integer component19() {
            return this.pageIndex;
        }

        public final Integer component2() {
            return this.blindBoxSelectType;
        }

        public final Integer component20() {
            return this.pageSize;
        }

        public final String component21() {
            return this.pageType;
        }

        public final Integer component22() {
            return this.pageVersion;
        }

        public final String component23() {
            return this.platform;
        }

        public final List<RangeQuery> component24() {
            return this.rangeQueries;
        }

        public final String component25() {
            return this.scene;
        }

        public final String component26() {
            return this.sortOrder;
        }

        public final String component27() {
            return this.sortType;
        }

        public final List<TermQuery> component28() {
            return this.termQueries;
        }

        public final String component29() {
            return this.trackId;
        }

        public final String component3() {
            return this.build;
        }

        public final String component4() {
            return this.buvid;
        }

        public final Integer component5() {
            return this.bzType;
        }

        public final Integer component6() {
            return this.channels;
        }

        public final String component7() {
            return this.device;
        }

        public final String component8() {
            return this.filterType;
        }

        public final String component9() {
            return this.from;
        }

        public final RecommendRequestParams copy(Boolean bool, Integer num, String str, String str2, Integer num2, Integer num3, String str3, String str4, String str5, String str6, Integer num4, Boolean bool2, String str7, String str8, Integer num5, Long l, String str9, Boolean bool3, Integer num6, Integer num7, String str10, Integer num8, String str11, List<RangeQuery> list, String str12, String str13, String str14, List<TermQuery> list2, String str15) {
            return new RecommendRequestParams(bool, num, str, str2, num2, num3, str3, str4, str5, str6, num4, bool2, str7, str8, num5, l, str9, bool3, num6, num7, str10, num8, str11, list, str12, str13, str14, list2, str15);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RecommendRequestParams) {
                RecommendRequestParams recommendRequestParams = (RecommendRequestParams) obj;
                return Intrinsics.areEqual(this.allowCache, recommendRequestParams.allowCache) && Intrinsics.areEqual(this.blindBoxSelectType, recommendRequestParams.blindBoxSelectType) && Intrinsics.areEqual(this.build, recommendRequestParams.build) && Intrinsics.areEqual(this.buvid, recommendRequestParams.buvid) && Intrinsics.areEqual(this.bzType, recommendRequestParams.bzType) && Intrinsics.areEqual(this.channels, recommendRequestParams.channels) && Intrinsics.areEqual(this.device, recommendRequestParams.device) && Intrinsics.areEqual(this.filterType, recommendRequestParams.filterType) && Intrinsics.areEqual(this.from, recommendRequestParams.from) && Intrinsics.areEqual(this.fromSpmId, recommendRequestParams.fromSpmId) && Intrinsics.areEqual(this.group, recommendRequestParams.group) && Intrinsics.areEqual(this.hightLight, recommendRequestParams.hightLight) && Intrinsics.areEqual(this.itemIds, recommendRequestParams.itemIds) && Intrinsics.areEqual(this.keyword, recommendRequestParams.keyword) && Intrinsics.areEqual(this.mVersion, recommendRequestParams.mVersion) && Intrinsics.areEqual(this.mid, recommendRequestParams.mid) && Intrinsics.areEqual(this.mobiApp, recommendRequestParams.mobiApp) && Intrinsics.areEqual(this.needMlsFilter, recommendRequestParams.needMlsFilter) && Intrinsics.areEqual(this.pageIndex, recommendRequestParams.pageIndex) && Intrinsics.areEqual(this.pageSize, recommendRequestParams.pageSize) && Intrinsics.areEqual(this.pageType, recommendRequestParams.pageType) && Intrinsics.areEqual(this.pageVersion, recommendRequestParams.pageVersion) && Intrinsics.areEqual(this.platform, recommendRequestParams.platform) && Intrinsics.areEqual(this.rangeQueries, recommendRequestParams.rangeQueries) && Intrinsics.areEqual(this.scene, recommendRequestParams.scene) && Intrinsics.areEqual(this.sortOrder, recommendRequestParams.sortOrder) && Intrinsics.areEqual(this.sortType, recommendRequestParams.sortType) && Intrinsics.areEqual(this.termQueries, recommendRequestParams.termQueries) && Intrinsics.areEqual(this.trackId, recommendRequestParams.trackId);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.allowCache == null ? 0 : this.allowCache.hashCode()) * 31) + (this.blindBoxSelectType == null ? 0 : this.blindBoxSelectType.hashCode())) * 31) + (this.build == null ? 0 : this.build.hashCode())) * 31) + (this.buvid == null ? 0 : this.buvid.hashCode())) * 31) + (this.bzType == null ? 0 : this.bzType.hashCode())) * 31) + (this.channels == null ? 0 : this.channels.hashCode())) * 31) + (this.device == null ? 0 : this.device.hashCode())) * 31) + (this.filterType == null ? 0 : this.filterType.hashCode())) * 31) + (this.from == null ? 0 : this.from.hashCode())) * 31) + (this.fromSpmId == null ? 0 : this.fromSpmId.hashCode())) * 31) + (this.group == null ? 0 : this.group.hashCode())) * 31) + (this.hightLight == null ? 0 : this.hightLight.hashCode())) * 31) + (this.itemIds == null ? 0 : this.itemIds.hashCode())) * 31) + (this.keyword == null ? 0 : this.keyword.hashCode())) * 31) + (this.mVersion == null ? 0 : this.mVersion.hashCode())) * 31) + (this.mid == null ? 0 : this.mid.hashCode())) * 31) + (this.mobiApp == null ? 0 : this.mobiApp.hashCode())) * 31) + (this.needMlsFilter == null ? 0 : this.needMlsFilter.hashCode())) * 31) + (this.pageIndex == null ? 0 : this.pageIndex.hashCode())) * 31) + (this.pageSize == null ? 0 : this.pageSize.hashCode())) * 31) + (this.pageType == null ? 0 : this.pageType.hashCode())) * 31) + (this.pageVersion == null ? 0 : this.pageVersion.hashCode())) * 31) + (this.platform == null ? 0 : this.platform.hashCode())) * 31) + (this.rangeQueries == null ? 0 : this.rangeQueries.hashCode())) * 31) + (this.scene == null ? 0 : this.scene.hashCode())) * 31) + (this.sortOrder == null ? 0 : this.sortOrder.hashCode())) * 31) + (this.sortType == null ? 0 : this.sortType.hashCode())) * 31) + (this.termQueries == null ? 0 : this.termQueries.hashCode())) * 31) + (this.trackId != null ? this.trackId.hashCode() : 0);
        }

        public String toString() {
            Boolean bool = this.allowCache;
            Integer num = this.blindBoxSelectType;
            String str = this.build;
            String str2 = this.buvid;
            Integer num2 = this.bzType;
            Integer num3 = this.channels;
            String str3 = this.device;
            String str4 = this.filterType;
            String str5 = this.from;
            String str6 = this.fromSpmId;
            Integer num4 = this.group;
            Boolean bool2 = this.hightLight;
            String str7 = this.itemIds;
            String str8 = this.keyword;
            Integer num5 = this.mVersion;
            Long l = this.mid;
            String str9 = this.mobiApp;
            Boolean bool3 = this.needMlsFilter;
            Integer num6 = this.pageIndex;
            Integer num7 = this.pageSize;
            String str10 = this.pageType;
            Integer num8 = this.pageVersion;
            String str11 = this.platform;
            List<RangeQuery> list = this.rangeQueries;
            String str12 = this.scene;
            String str13 = this.sortOrder;
            String str14 = this.sortType;
            List<TermQuery> list2 = this.termQueries;
            return "RecommendRequestParams(allowCache=" + bool + ", blindBoxSelectType=" + num + ", build=" + str + ", buvid=" + str2 + ", bzType=" + num2 + ", channels=" + num3 + ", device=" + str3 + ", filterType=" + str4 + ", from=" + str5 + ", fromSpmId=" + str6 + ", group=" + num4 + ", hightLight=" + bool2 + ", itemIds=" + str7 + ", keyword=" + str8 + ", mVersion=" + num5 + ", mid=" + l + ", mobiApp=" + str9 + ", needMlsFilter=" + bool3 + ", pageIndex=" + num6 + ", pageSize=" + num7 + ", pageType=" + str10 + ", pageVersion=" + num8 + ", platform=" + str11 + ", rangeQueries=" + list + ", scene=" + str12 + ", sortOrder=" + str13 + ", sortType=" + str14 + ", termQueries=" + list2 + ", trackId=" + this.trackId + ")";
        }

        /* compiled from: IPFeedRecommendApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$RecommendRequestParams$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$RecommendRequestParams;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<RecommendRequestParams> serializer() {
                return new GeneratedSerializer<RecommendRequestParams>() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$RecommendRequestParams$$serializer
                    public static final int $stable;
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.IPFeedRecommendApiService.RecommendRequestParams", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$RecommendRequestParams> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$RecommendRequestParams> A[REMOVE]) =  kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$RecommendRequestParams$$serializer.INSTANCE kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$RecommendRequestParams$$serializer)
                             in method: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService.RecommendRequestParams.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$RecommendRequestParams>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                              ("kntr.app.mall.product.details.page.api.IPFeedRecommendApiService.RecommendRequestParams")
                              (wrap: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$RecommendRequestParams$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$RecommendRequestParams$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$RecommendRequestParams$$serializer.INSTANCE kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$RecommendRequestParams$$serializer)
                              (29 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$RecommendRequestParams$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$RecommendRequestParams$$serializer
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
                            kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$RecommendRequestParams$$serializer r0 = kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$RecommendRequestParams$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService.RecommendRequestParams.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ RecommendRequestParams(int seen0, Boolean allowCache, Integer blindBoxSelectType, String build, String buvid, Integer bzType, Integer channels, String device, String filterType, String from, String fromSpmId, Integer group, Boolean hightLight, String itemIds, String keyword, Integer mVersion, Long mid, String mobiApp, Boolean needMlsFilter, Integer pageIndex, Integer pageSize, String pageType, Integer pageVersion, String platform, List rangeQueries, String scene, String sortOrder, String sortType, List termQueries, String trackId, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.allowCache = null;
                    } else {
                        this.allowCache = allowCache;
                    }
                    if ((seen0 & 2) == 0) {
                        this.blindBoxSelectType = null;
                    } else {
                        this.blindBoxSelectType = blindBoxSelectType;
                    }
                    if ((seen0 & 4) == 0) {
                        this.build = null;
                    } else {
                        this.build = build;
                    }
                    if ((seen0 & 8) == 0) {
                        this.buvid = null;
                    } else {
                        this.buvid = buvid;
                    }
                    if ((seen0 & 16) == 0) {
                        this.bzType = null;
                    } else {
                        this.bzType = bzType;
                    }
                    if ((seen0 & 32) == 0) {
                        this.channels = null;
                    } else {
                        this.channels = channels;
                    }
                    if ((seen0 & 64) == 0) {
                        this.device = null;
                    } else {
                        this.device = device;
                    }
                    if ((seen0 & 128) == 0) {
                        this.filterType = null;
                    } else {
                        this.filterType = filterType;
                    }
                    if ((seen0 & 256) == 0) {
                        this.from = null;
                    } else {
                        this.from = from;
                    }
                    if ((seen0 & 512) == 0) {
                        this.fromSpmId = null;
                    } else {
                        this.fromSpmId = fromSpmId;
                    }
                    if ((seen0 & 1024) == 0) {
                        this.group = null;
                    } else {
                        this.group = group;
                    }
                    if ((seen0 & 2048) == 0) {
                        this.hightLight = null;
                    } else {
                        this.hightLight = hightLight;
                    }
                    if ((seen0 & 4096) == 0) {
                        this.itemIds = null;
                    } else {
                        this.itemIds = itemIds;
                    }
                    if ((seen0 & 8192) == 0) {
                        this.keyword = null;
                    } else {
                        this.keyword = keyword;
                    }
                    if ((seen0 & 16384) == 0) {
                        this.mVersion = null;
                    } else {
                        this.mVersion = mVersion;
                    }
                    if ((seen0 & 32768) == 0) {
                        this.mid = null;
                    } else {
                        this.mid = mid;
                    }
                    if ((seen0 & 65536) == 0) {
                        this.mobiApp = null;
                    } else {
                        this.mobiApp = mobiApp;
                    }
                    if ((seen0 & 131072) == 0) {
                        this.needMlsFilter = null;
                    } else {
                        this.needMlsFilter = needMlsFilter;
                    }
                    if ((seen0 & 262144) == 0) {
                        this.pageIndex = null;
                    } else {
                        this.pageIndex = pageIndex;
                    }
                    if ((seen0 & 524288) == 0) {
                        this.pageSize = null;
                    } else {
                        this.pageSize = pageSize;
                    }
                    if ((seen0 & 1048576) == 0) {
                        this.pageType = null;
                    } else {
                        this.pageType = pageType;
                    }
                    if ((seen0 & 2097152) == 0) {
                        this.pageVersion = null;
                    } else {
                        this.pageVersion = pageVersion;
                    }
                    if ((seen0 & 4194304) == 0) {
                        this.platform = null;
                    } else {
                        this.platform = platform;
                    }
                    if ((seen0 & 8388608) == 0) {
                        this.rangeQueries = null;
                    } else {
                        this.rangeQueries = rangeQueries;
                    }
                    if ((seen0 & 16777216) == 0) {
                        this.scene = null;
                    } else {
                        this.scene = scene;
                    }
                    if ((seen0 & 33554432) == 0) {
                        this.sortOrder = null;
                    } else {
                        this.sortOrder = sortOrder;
                    }
                    if ((seen0 & 67108864) == 0) {
                        this.sortType = null;
                    } else {
                        this.sortType = sortType;
                    }
                    if ((seen0 & 134217728) == 0) {
                        this.termQueries = null;
                    } else {
                        this.termQueries = termQueries;
                    }
                    if ((seen0 & 268435456) == 0) {
                        this.trackId = null;
                    } else {
                        this.trackId = trackId;
                    }
                }

                public RecommendRequestParams(Boolean allowCache, Integer blindBoxSelectType, String build, String buvid, Integer bzType, Integer channels, String device, String filterType, String from, String fromSpmId, Integer group, Boolean hightLight, String itemIds, String keyword, Integer mVersion, Long mid, String mobiApp, Boolean needMlsFilter, Integer pageIndex, Integer pageSize, String pageType, Integer pageVersion, String platform, List<RangeQuery> list, String scene, String sortOrder, String sortType, List<TermQuery> list2, String trackId) {
                    this.allowCache = allowCache;
                    this.blindBoxSelectType = blindBoxSelectType;
                    this.build = build;
                    this.buvid = buvid;
                    this.bzType = bzType;
                    this.channels = channels;
                    this.device = device;
                    this.filterType = filterType;
                    this.from = from;
                    this.fromSpmId = fromSpmId;
                    this.group = group;
                    this.hightLight = hightLight;
                    this.itemIds = itemIds;
                    this.keyword = keyword;
                    this.mVersion = mVersion;
                    this.mid = mid;
                    this.mobiApp = mobiApp;
                    this.needMlsFilter = needMlsFilter;
                    this.pageIndex = pageIndex;
                    this.pageSize = pageSize;
                    this.pageType = pageType;
                    this.pageVersion = pageVersion;
                    this.platform = platform;
                    this.rangeQueries = list;
                    this.scene = scene;
                    this.sortOrder = sortOrder;
                    this.sortType = sortType;
                    this.termQueries = list2;
                    this.trackId = trackId;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                    return new ArrayListSerializer(IPFeedRecommendApiService$RecommendRequestParams$RangeQuery$$serializer.INSTANCE);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                    return new ArrayListSerializer(IPFeedRecommendApiService$RecommendRequestParams$TermQuery$$serializer.INSTANCE);
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(RecommendRequestParams self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.allowCache != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.allowCache);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.blindBoxSelectType != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.blindBoxSelectType);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.build != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.build);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.buvid != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.buvid);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.bzType != null) {
                        output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.bzType);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 5) || self.channels != null) {
                        output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.channels);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 6) || self.device != null) {
                        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.device);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 7) || self.filterType != null) {
                        output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.filterType);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 8) || self.from != null) {
                        output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.from);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 9) || self.fromSpmId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.fromSpmId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 10) || self.group != null) {
                        output.encodeNullableSerializableElement(serialDesc, 10, IntSerializer.INSTANCE, self.group);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 11) || self.hightLight != null) {
                        output.encodeNullableSerializableElement(serialDesc, 11, BooleanSerializer.INSTANCE, self.hightLight);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 12) || self.itemIds != null) {
                        output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.itemIds);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 13) || self.keyword != null) {
                        output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.keyword);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 14) || self.mVersion != null) {
                        output.encodeNullableSerializableElement(serialDesc, 14, IntSerializer.INSTANCE, self.mVersion);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 15) || self.mid != null) {
                        output.encodeNullableSerializableElement(serialDesc, 15, LongSerializer.INSTANCE, self.mid);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 16) || self.mobiApp != null) {
                        output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.mobiApp);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 17) || self.needMlsFilter != null) {
                        output.encodeNullableSerializableElement(serialDesc, 17, BooleanSerializer.INSTANCE, self.needMlsFilter);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 18) || self.pageIndex != null) {
                        output.encodeNullableSerializableElement(serialDesc, 18, IntSerializer.INSTANCE, self.pageIndex);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 19) || self.pageSize != null) {
                        output.encodeNullableSerializableElement(serialDesc, 19, IntSerializer.INSTANCE, self.pageSize);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 20) || self.pageType != null) {
                        output.encodeNullableSerializableElement(serialDesc, 20, StringSerializer.INSTANCE, self.pageType);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 21) || self.pageVersion != null) {
                        output.encodeNullableSerializableElement(serialDesc, 21, IntSerializer.INSTANCE, self.pageVersion);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 22) || self.platform != null) {
                        output.encodeNullableSerializableElement(serialDesc, 22, StringSerializer.INSTANCE, self.platform);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 23) || self.rangeQueries != null) {
                        output.encodeNullableSerializableElement(serialDesc, 23, lazyArr[23].getValue(), self.rangeQueries);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 24) || self.scene != null) {
                        output.encodeNullableSerializableElement(serialDesc, 24, StringSerializer.INSTANCE, self.scene);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 25) || self.sortOrder != null) {
                        output.encodeNullableSerializableElement(serialDesc, 25, StringSerializer.INSTANCE, self.sortOrder);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 26) || self.sortType != null) {
                        output.encodeNullableSerializableElement(serialDesc, 26, StringSerializer.INSTANCE, self.sortType);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 27) || self.termQueries != null) {
                        output.encodeNullableSerializableElement(serialDesc, 27, lazyArr[27].getValue(), self.termQueries);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 28) || self.trackId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 28, StringSerializer.INSTANCE, self.trackId);
                    }
                }

                public /* synthetic */ RecommendRequestParams(Boolean bool, Integer num, String str, String str2, Integer num2, Integer num3, String str3, String str4, String str5, String str6, Integer num4, Boolean bool2, String str7, String str8, Integer num5, Long l, String str9, Boolean bool3, Integer num6, Integer num7, String str10, Integer num8, String str11, List list, String str12, String str13, String str14, List list2, String str15, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : num3, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? null : str6, (i & 1024) != 0 ? null : num4, (i & 2048) != 0 ? null : bool2, (i & 4096) != 0 ? null : str7, (i & 8192) != 0 ? null : str8, (i & 16384) != 0 ? null : num5, (i & 32768) != 0 ? null : l, (i & 65536) != 0 ? null : str9, (i & 131072) != 0 ? null : bool3, (i & 262144) != 0 ? null : num6, (i & 524288) != 0 ? null : num7, (i & 1048576) != 0 ? null : str10, (i & 2097152) != 0 ? null : num8, (i & 4194304) != 0 ? null : str11, (i & 8388608) != 0 ? null : list, (i & 16777216) != 0 ? null : str12, (i & 33554432) != 0 ? null : str13, (i & 67108864) != 0 ? null : str14, (i & 134217728) != 0 ? null : list2, (i & 268435456) != 0 ? null : str15);
                }

                public final Boolean getAllowCache() {
                    return this.allowCache;
                }

                public final Integer getBlindBoxSelectType() {
                    return this.blindBoxSelectType;
                }

                public final String getBuild() {
                    return this.build;
                }

                public final String getBuvid() {
                    return this.buvid;
                }

                public final Integer getBzType() {
                    return this.bzType;
                }

                public final Integer getChannels() {
                    return this.channels;
                }

                public final String getDevice() {
                    return this.device;
                }

                public final String getFilterType() {
                    return this.filterType;
                }

                public final String getFrom() {
                    return this.from;
                }

                public final String getFromSpmId() {
                    return this.fromSpmId;
                }

                public final Integer getGroup() {
                    return this.group;
                }

                public final Boolean getHightLight() {
                    return this.hightLight;
                }

                public final String getItemIds() {
                    return this.itemIds;
                }

                public final String getKeyword() {
                    return this.keyword;
                }

                public final Integer getMVersion() {
                    return this.mVersion;
                }

                public final Long getMid() {
                    return this.mid;
                }

                public final String getMobiApp() {
                    return this.mobiApp;
                }

                public final Boolean getNeedMlsFilter() {
                    return this.needMlsFilter;
                }

                public final Integer getPageIndex() {
                    return this.pageIndex;
                }

                public final Integer getPageSize() {
                    return this.pageSize;
                }

                public final String getPageType() {
                    return this.pageType;
                }

                public final Integer getPageVersion() {
                    return this.pageVersion;
                }

                public final String getPlatform() {
                    return this.platform;
                }

                public final List<RangeQuery> getRangeQueries() {
                    return this.rangeQueries;
                }

                public final String getScene() {
                    return this.scene;
                }

                public final String getSortOrder() {
                    return this.sortOrder;
                }

                public final String getSortType() {
                    return this.sortType;
                }

                public final List<TermQuery> getTermQueries() {
                    return this.termQueries;
                }

                /* compiled from: IPFeedRecommendApiService.kt */
                @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0003./0BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fB]\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JW\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u000eHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u00061"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$RecommendRequestParams$RangeQuery;", "", "field", "", "gt", "gte", "lt", "lte", "range", "", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$RecommendRequestParams$RangeQuery$Range;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getField", "()Ljava/lang/String;", "getGt", "getGte", "getLt", "getLte", "getRange", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "Range", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                @Serializable
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class RangeQuery {
                    private final String field;
                    private final String gt;
                    private final String gte;
                    private final String lt;
                    private final String lte;
                    private final List<Range> range;
                    public static final Companion Companion = new Companion(null);
                    public static final int $stable = 8;
                    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$RecommendRequestParams$RangeQuery$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            KSerializer _childSerializers$_anonymous_;
                            _childSerializers$_anonymous_ = IPFeedRecommendApiService.RecommendRequestParams.RangeQuery._childSerializers$_anonymous_();
                            return _childSerializers$_anonymous_;
                        }
                    })};

                    public RangeQuery() {
                        this((String) null, (String) null, (String) null, (String) null, (String) null, (List) null, 63, (DefaultConstructorMarker) null);
                    }

                    public static /* synthetic */ RangeQuery copy$default(RangeQuery rangeQuery, String str, String str2, String str3, String str4, String str5, List list, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = rangeQuery.field;
                        }
                        if ((i & 2) != 0) {
                            str2 = rangeQuery.gt;
                        }
                        String str6 = str2;
                        if ((i & 4) != 0) {
                            str3 = rangeQuery.gte;
                        }
                        String str7 = str3;
                        if ((i & 8) != 0) {
                            str4 = rangeQuery.lt;
                        }
                        String str8 = str4;
                        if ((i & 16) != 0) {
                            str5 = rangeQuery.lte;
                        }
                        String str9 = str5;
                        List<Range> list2 = list;
                        if ((i & 32) != 0) {
                            list2 = rangeQuery.range;
                        }
                        return rangeQuery.copy(str, str6, str7, str8, str9, list2);
                    }

                    public final String component1() {
                        return this.field;
                    }

                    public final String component2() {
                        return this.gt;
                    }

                    public final String component3() {
                        return this.gte;
                    }

                    public final String component4() {
                        return this.lt;
                    }

                    public final String component5() {
                        return this.lte;
                    }

                    public final List<Range> component6() {
                        return this.range;
                    }

                    public final RangeQuery copy(String str, String str2, String str3, String str4, String str5, List<Range> list) {
                        return new RangeQuery(str, str2, str3, str4, str5, list);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof RangeQuery) {
                            RangeQuery rangeQuery = (RangeQuery) obj;
                            return Intrinsics.areEqual(this.field, rangeQuery.field) && Intrinsics.areEqual(this.gt, rangeQuery.gt) && Intrinsics.areEqual(this.gte, rangeQuery.gte) && Intrinsics.areEqual(this.lt, rangeQuery.lt) && Intrinsics.areEqual(this.lte, rangeQuery.lte) && Intrinsics.areEqual(this.range, rangeQuery.range);
                        }
                        return false;
                    }

                    public int hashCode() {
                        return ((((((((((this.field == null ? 0 : this.field.hashCode()) * 31) + (this.gt == null ? 0 : this.gt.hashCode())) * 31) + (this.gte == null ? 0 : this.gte.hashCode())) * 31) + (this.lt == null ? 0 : this.lt.hashCode())) * 31) + (this.lte == null ? 0 : this.lte.hashCode())) * 31) + (this.range != null ? this.range.hashCode() : 0);
                    }

                    public String toString() {
                        String str = this.field;
                        String str2 = this.gt;
                        String str3 = this.gte;
                        String str4 = this.lt;
                        String str5 = this.lte;
                        return "RangeQuery(field=" + str + ", gt=" + str2 + ", gte=" + str3 + ", lt=" + str4 + ", lte=" + str5 + ", range=" + this.range + ")";
                    }

                    /* compiled from: IPFeedRecommendApiService.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$RecommendRequestParams$RangeQuery$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$RecommendRequestParams$RangeQuery;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<RangeQuery> serializer() {
                            return IPFeedRecommendApiService$RecommendRequestParams$RangeQuery$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ RangeQuery(int seen0, String field, String gt, String gte, String lt, String lte, List range, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((seen0 & 1) == 0) {
                            this.field = null;
                        } else {
                            this.field = field;
                        }
                        if ((seen0 & 2) == 0) {
                            this.gt = null;
                        } else {
                            this.gt = gt;
                        }
                        if ((seen0 & 4) == 0) {
                            this.gte = null;
                        } else {
                            this.gte = gte;
                        }
                        if ((seen0 & 8) == 0) {
                            this.lt = null;
                        } else {
                            this.lt = lt;
                        }
                        if ((seen0 & 16) == 0) {
                            this.lte = null;
                        } else {
                            this.lte = lte;
                        }
                        if ((seen0 & 32) == 0) {
                            this.range = null;
                        } else {
                            this.range = range;
                        }
                    }

                    public RangeQuery(String field, String gt, String gte, String lt, String lte, List<Range> list) {
                        this.field = field;
                        this.gt = gt;
                        this.gte = gte;
                        this.lt = lt;
                        this.lte = lte;
                        this.range = list;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                        return new ArrayListSerializer(IPFeedRecommendApiService$RecommendRequestParams$RangeQuery$Range$$serializer.INSTANCE);
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$product_details_page_debug(RangeQuery self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.field != null) {
                            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.field);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.gt != null) {
                            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.gt);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.gte != null) {
                            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.gte);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.lt != null) {
                            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.lt);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.lte != null) {
                            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.lte);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.range != null) {
                            output.encodeNullableSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.range);
                        }
                    }

                    public /* synthetic */ RangeQuery(String str, String str2, String str3, String str4, String str5, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : list);
                    }

                    public final String getField() {
                        return this.field;
                    }

                    public final String getGt() {
                        return this.gt;
                    }

                    public final String getGte() {
                        return this.gte;
                    }

                    public final String getLt() {
                        return this.lt;
                    }

                    public final String getLte() {
                        return this.lte;
                    }

                    /* compiled from: IPFeedRecommendApiService.kt */
                    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bBC\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\nHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006'"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$RecommendRequestParams$RangeQuery$Range;", "", "gt", "", "gte", "lt", "lte", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getGt", "()Ljava/lang/String;", "getGte", "getLt", "getLte", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    @Serializable
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class Range {
                        public static final int $stable = 0;
                        public static final Companion Companion = new Companion(null);
                        private final String gt;
                        private final String gte;
                        private final String lt;
                        private final String lte;

                        public Range() {
                            this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
                        }

                        public static /* synthetic */ Range copy$default(Range range, String str, String str2, String str3, String str4, int i, Object obj) {
                            if ((i & 1) != 0) {
                                str = range.gt;
                            }
                            if ((i & 2) != 0) {
                                str2 = range.gte;
                            }
                            if ((i & 4) != 0) {
                                str3 = range.lt;
                            }
                            if ((i & 8) != 0) {
                                str4 = range.lte;
                            }
                            return range.copy(str, str2, str3, str4);
                        }

                        public final String component1() {
                            return this.gt;
                        }

                        public final String component2() {
                            return this.gte;
                        }

                        public final String component3() {
                            return this.lt;
                        }

                        public final String component4() {
                            return this.lte;
                        }

                        public final Range copy(String str, String str2, String str3, String str4) {
                            return new Range(str, str2, str3, str4);
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj instanceof Range) {
                                Range range = (Range) obj;
                                return Intrinsics.areEqual(this.gt, range.gt) && Intrinsics.areEqual(this.gte, range.gte) && Intrinsics.areEqual(this.lt, range.lt) && Intrinsics.areEqual(this.lte, range.lte);
                            }
                            return false;
                        }

                        public int hashCode() {
                            return ((((((this.gt == null ? 0 : this.gt.hashCode()) * 31) + (this.gte == null ? 0 : this.gte.hashCode())) * 31) + (this.lt == null ? 0 : this.lt.hashCode())) * 31) + (this.lte != null ? this.lte.hashCode() : 0);
                        }

                        public String toString() {
                            String str = this.gt;
                            String str2 = this.gte;
                            String str3 = this.lt;
                            return "Range(gt=" + str + ", gte=" + str2 + ", lt=" + str3 + ", lte=" + this.lte + ")";
                        }

                        /* compiled from: IPFeedRecommendApiService.kt */
                        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$RecommendRequestParams$RangeQuery$Range$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$RecommendRequestParams$RangeQuery$Range;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class Companion {
                            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                this();
                            }

                            private Companion() {
                            }

                            public final KSerializer<Range> serializer() {
                                return IPFeedRecommendApiService$RecommendRequestParams$RangeQuery$Range$$serializer.INSTANCE;
                            }
                        }

                        public /* synthetic */ Range(int seen0, String gt, String gte, String lt, String lte, SerializationConstructorMarker serializationConstructorMarker) {
                            if ((seen0 & 1) == 0) {
                                this.gt = null;
                            } else {
                                this.gt = gt;
                            }
                            if ((seen0 & 2) == 0) {
                                this.gte = null;
                            } else {
                                this.gte = gte;
                            }
                            if ((seen0 & 4) == 0) {
                                this.lt = null;
                            } else {
                                this.lt = lt;
                            }
                            if ((seen0 & 8) == 0) {
                                this.lte = null;
                            } else {
                                this.lte = lte;
                            }
                        }

                        public Range(String gt, String gte, String lt, String lte) {
                            this.gt = gt;
                            this.gte = gte;
                            this.lt = lt;
                            this.lte = lte;
                        }

                        @JvmStatic
                        public static final /* synthetic */ void write$Self$product_details_page_debug(Range self, CompositeEncoder output, SerialDescriptor serialDesc) {
                            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.gt != null) {
                                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.gt);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.gte != null) {
                                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.gte);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.lt != null) {
                                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.lt);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.lte != null) {
                                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.lte);
                            }
                        }

                        public /* synthetic */ Range(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
                        }

                        public final String getGt() {
                            return this.gt;
                        }

                        public final String getGte() {
                            return this.gte;
                        }

                        public final String getLt() {
                            return this.lt;
                        }

                        public final String getLte() {
                            return this.lte;
                        }
                    }

                    public final List<Range> getRange() {
                        return this.range;
                    }
                }

                public final String getTrackId() {
                    return this.trackId;
                }

                /* compiled from: IPFeedRecommendApiService.kt */
                @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B5\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\tHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$RecommendRequestParams$TermQuery;", "", "field", "", "values", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getField", "()Ljava/lang/String;", "getValues", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                @Serializable
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class TermQuery {
                    private final String field;
                    private final List<String> values;
                    public static final Companion Companion = new Companion(null);
                    public static final int $stable = 8;
                    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$RecommendRequestParams$TermQuery$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            KSerializer _childSerializers$_anonymous_;
                            _childSerializers$_anonymous_ = IPFeedRecommendApiService.RecommendRequestParams.TermQuery._childSerializers$_anonymous_();
                            return _childSerializers$_anonymous_;
                        }
                    })};

                    public TermQuery() {
                        this((String) null, (List) null, 3, (DefaultConstructorMarker) null);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public static /* synthetic */ TermQuery copy$default(TermQuery termQuery, String str, List list, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = termQuery.field;
                        }
                        if ((i & 2) != 0) {
                            list = termQuery.values;
                        }
                        return termQuery.copy(str, list);
                    }

                    public final String component1() {
                        return this.field;
                    }

                    public final List<String> component2() {
                        return this.values;
                    }

                    public final TermQuery copy(String str, List<String> list) {
                        return new TermQuery(str, list);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof TermQuery) {
                            TermQuery termQuery = (TermQuery) obj;
                            return Intrinsics.areEqual(this.field, termQuery.field) && Intrinsics.areEqual(this.values, termQuery.values);
                        }
                        return false;
                    }

                    public int hashCode() {
                        return ((this.field == null ? 0 : this.field.hashCode()) * 31) + (this.values != null ? this.values.hashCode() : 0);
                    }

                    public String toString() {
                        String str = this.field;
                        return "TermQuery(field=" + str + ", values=" + this.values + ")";
                    }

                    /* compiled from: IPFeedRecommendApiService.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$RecommendRequestParams$TermQuery$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$RecommendRequestParams$TermQuery;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<TermQuery> serializer() {
                            return IPFeedRecommendApiService$RecommendRequestParams$TermQuery$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ TermQuery(int seen0, String field, List values, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((seen0 & 1) == 0) {
                            this.field = null;
                        } else {
                            this.field = field;
                        }
                        if ((seen0 & 2) == 0) {
                            this.values = null;
                        } else {
                            this.values = values;
                        }
                    }

                    public TermQuery(String field, List<String> list) {
                        this.field = field;
                        this.values = list;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                        return new ArrayListSerializer(StringSerializer.INSTANCE);
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$product_details_page_debug(TermQuery self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.field != null) {
                            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.field);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.values != null) {
                            output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.values);
                        }
                    }

                    public /* synthetic */ TermQuery(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list);
                    }

                    public final String getField() {
                        return this.field;
                    }

                    public final List<String> getValues() {
                        return this.values;
                    }
                }
            }

            /* compiled from: IPFeedRecommendApiService.kt */
            @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBC\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J>\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\rHÖ\u0001J\t\u0010$\u001a\u00020\u0007HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006/"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$Response;", "", "code", "", "data", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel;", "message", "", "success", "", "<init>", "(Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel;Ljava/lang/String;Ljava/lang/Boolean;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getData", "()Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel;", "getMessage", "()Ljava/lang/String;", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel;Ljava/lang/String;Ljava/lang/Boolean;)Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$Response;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Response {
                private final Long code;
                private final IPFeedRecommendModel data;
                private final String message;
                private final Boolean success;
                public static final Companion Companion = new Companion(null);
                public static final int $stable = 8;

                public Response() {
                    this((Long) null, (IPFeedRecommendModel) null, (String) null, (Boolean) null, 15, (DefaultConstructorMarker) null);
                }

                public static /* synthetic */ Response copy$default(Response response, Long l, IPFeedRecommendModel iPFeedRecommendModel, String str, Boolean bool, int i, Object obj) {
                    if ((i & 1) != 0) {
                        l = response.code;
                    }
                    if ((i & 2) != 0) {
                        iPFeedRecommendModel = response.data;
                    }
                    if ((i & 4) != 0) {
                        str = response.message;
                    }
                    if ((i & 8) != 0) {
                        bool = response.success;
                    }
                    return response.copy(l, iPFeedRecommendModel, str, bool);
                }

                public final Long component1() {
                    return this.code;
                }

                public final IPFeedRecommendModel component2() {
                    return this.data;
                }

                public final String component3() {
                    return this.message;
                }

                public final Boolean component4() {
                    return this.success;
                }

                public final Response copy(Long l, IPFeedRecommendModel iPFeedRecommendModel, String str, Boolean bool) {
                    return new Response(l, iPFeedRecommendModel, str, bool);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof Response) {
                        Response response = (Response) obj;
                        return Intrinsics.areEqual(this.code, response.code) && Intrinsics.areEqual(this.data, response.data) && Intrinsics.areEqual(this.message, response.message) && Intrinsics.areEqual(this.success, response.success);
                    }
                    return false;
                }

                public int hashCode() {
                    return ((((((this.code == null ? 0 : this.code.hashCode()) * 31) + (this.data == null ? 0 : this.data.hashCode())) * 31) + (this.message == null ? 0 : this.message.hashCode())) * 31) + (this.success != null ? this.success.hashCode() : 0);
                }

                public String toString() {
                    Long l = this.code;
                    IPFeedRecommendModel iPFeedRecommendModel = this.data;
                    String str = this.message;
                    return "Response(code=" + l + ", data=" + iPFeedRecommendModel + ", message=" + str + ", success=" + this.success + ")";
                }

                /* compiled from: IPFeedRecommendApiService.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$Response$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$Response;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<Response> serializer() {
                        return new GeneratedSerializer<Response>() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$Response$$serializer
                            public static final int $stable;
                            private static final SerialDescriptor descriptor;

                            public final SerialDescriptor getDescriptor() {
                                return descriptor;
                            }

                            static {
                                SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.IPFeedRecommendApiService.Response", 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                                      (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$Response> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$Response> A[REMOVE]) =  kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$Response$$serializer.INSTANCE kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$Response$$serializer)
                                     in method: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService.Response.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$Response>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: CONSTRUCTOR  (r0v1 'pluginGeneratedSerialDescriptor' kotlinx.serialization.descriptors.SerialDescriptor) = 
                                      ("kntr.app.mall.product.details.page.api.IPFeedRecommendApiService.Response")
                                      (wrap: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$Response$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$Response$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$Response$$serializer.INSTANCE kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$Response$$serializer)
                                      (4 int)
                                     call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$Response$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$Response$$serializer
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
                                    kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$Response$$serializer r0 = kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$Response$$serializer.INSTANCE
                                    kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                                    return r0
                                */
                                throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService.Response.Companion.serializer():kotlinx.serialization.KSerializer");
                            }
                        }

                        public /* synthetic */ Response(int seen0, Long code, IPFeedRecommendModel data, String message, Boolean success, SerializationConstructorMarker serializationConstructorMarker) {
                            if ((seen0 & 1) == 0) {
                                this.code = null;
                            } else {
                                this.code = code;
                            }
                            if ((seen0 & 2) == 0) {
                                this.data = null;
                            } else {
                                this.data = data;
                            }
                            if ((seen0 & 4) == 0) {
                                this.message = null;
                            } else {
                                this.message = message;
                            }
                            if ((seen0 & 8) == 0) {
                                this.success = null;
                            } else {
                                this.success = success;
                            }
                        }

                        public Response(Long code, IPFeedRecommendModel data, String message, Boolean success) {
                            this.code = code;
                            this.data = data;
                            this.message = message;
                            this.success = success;
                        }

                        @JvmStatic
                        public static final /* synthetic */ void write$Self$product_details_page_debug(Response self, CompositeEncoder output, SerialDescriptor serialDesc) {
                            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.code != null) {
                                output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.code);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.data != null) {
                                output.encodeNullableSerializableElement(serialDesc, 1, IPFeedRecommendApiService$IPFeedRecommendModel$$serializer.INSTANCE, self.data);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.message != null) {
                                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.message);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.success != null) {
                                output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.success);
                            }
                        }

                        public /* synthetic */ Response(Long l, IPFeedRecommendModel iPFeedRecommendModel, String str, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
                            this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : iPFeedRecommendModel, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : bool);
                        }

                        public final Long getCode() {
                            return this.code;
                        }

                        public final IPFeedRecommendModel getData() {
                            return this.data;
                        }

                        public final String getMessage() {
                            return this.message;
                        }

                        public final Boolean getSuccess() {
                            return this.success;
                        }
                    }

                    /* compiled from: IPFeedRecommendApiService.kt */
                    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 F2\u00020\u0001:\u0003DEFBµ\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013B³\u0001\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0012\u0010\u0017J\r\u0010(\u001a\u00020)H\u0000¢\u0006\u0002\b*J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u00103\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J¼\u0001\u00106\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00107J\u0013\u00108\u001a\u00020)2\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\rHÖ\u0001J\t\u0010;\u001a\u00020\tHÖ\u0001J%\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00002\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0001¢\u0006\u0002\bCR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019¨\u0006G"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel;", "", "blindBoxWords", "", "Lkotlinx/serialization/json/JsonElement;", "data", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem;", "fixHotWords", "guideIndexUrl", "", "guideSearch", "ipFeedSortFilters", "numResults", "", "querySearch", "searchFilter", "seid", "selectPrices", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Lkotlinx/serialization/json/JsonElement;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Lkotlinx/serialization/json/JsonElement;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBlindBoxWords", "()Ljava/util/List;", "getData", "getFixHotWords", "getGuideIndexUrl", "()Ljava/lang/String;", "getGuideSearch", "getIpFeedSortFilters", "getNumResults", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getQuerySearch", "()Lkotlinx/serialization/json/JsonElement;", "getSearchFilter", "getSeid", "getSelectPrices", "shouldShowIpFeedRecommend", "", "shouldShowIpFeedRecommend$product_details_page_debug", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Lkotlinx/serialization/json/JsonElement;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "IPFeedRecommendItem", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    @Serializable
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class IPFeedRecommendModel {
                        private final List<JsonElement> blindBoxWords;
                        private final List<IPFeedRecommendItem> data;
                        private final List<JsonElement> fixHotWords;
                        private final String guideIndexUrl;
                        private final List<JsonElement> guideSearch;
                        private final List<JsonElement> ipFeedSortFilters;
                        private final Integer numResults;
                        private final JsonElement querySearch;
                        private final List<JsonElement> searchFilter;
                        private final String seid;
                        private final List<JsonElement> selectPrices;
                        public static final Companion Companion = new Companion(null);
                        public static final int $stable = 8;
                        private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$IPFeedRecommendModel$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                KSerializer _childSerializers$_anonymous_;
                                _childSerializers$_anonymous_ = IPFeedRecommendApiService.IPFeedRecommendModel._childSerializers$_anonymous_();
                                return _childSerializers$_anonymous_;
                            }
                        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$IPFeedRecommendModel$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                KSerializer _childSerializers$_anonymous_$0;
                                _childSerializers$_anonymous_$0 = IPFeedRecommendApiService.IPFeedRecommendModel._childSerializers$_anonymous_$0();
                                return _childSerializers$_anonymous_$0;
                            }
                        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$IPFeedRecommendModel$$ExternalSyntheticLambda2
                            public final Object invoke() {
                                KSerializer _childSerializers$_anonymous_$1;
                                _childSerializers$_anonymous_$1 = IPFeedRecommendApiService.IPFeedRecommendModel._childSerializers$_anonymous_$1();
                                return _childSerializers$_anonymous_$1;
                            }
                        }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$IPFeedRecommendModel$$ExternalSyntheticLambda3
                            public final Object invoke() {
                                KSerializer _childSerializers$_anonymous_$2;
                                _childSerializers$_anonymous_$2 = IPFeedRecommendApiService.IPFeedRecommendModel._childSerializers$_anonymous_$2();
                                return _childSerializers$_anonymous_$2;
                            }
                        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$IPFeedRecommendModel$$ExternalSyntheticLambda4
                            public final Object invoke() {
                                KSerializer _childSerializers$_anonymous_$3;
                                _childSerializers$_anonymous_$3 = IPFeedRecommendApiService.IPFeedRecommendModel._childSerializers$_anonymous_$3();
                                return _childSerializers$_anonymous_$3;
                            }
                        }), null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$IPFeedRecommendModel$$ExternalSyntheticLambda5
                            public final Object invoke() {
                                KSerializer _childSerializers$_anonymous_$4;
                                _childSerializers$_anonymous_$4 = IPFeedRecommendApiService.IPFeedRecommendModel._childSerializers$_anonymous_$4();
                                return _childSerializers$_anonymous_$4;
                            }
                        }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$IPFeedRecommendModel$$ExternalSyntheticLambda6
                            public final Object invoke() {
                                KSerializer _childSerializers$_anonymous_$5;
                                _childSerializers$_anonymous_$5 = IPFeedRecommendApiService.IPFeedRecommendModel._childSerializers$_anonymous_$5();
                                return _childSerializers$_anonymous_$5;
                            }
                        })};

                        public IPFeedRecommendModel() {
                            this((List) null, (List) null, (List) null, (String) null, (List) null, (List) null, (Integer) null, (JsonElement) null, (List) null, (String) null, (List) null, 2047, (DefaultConstructorMarker) null);
                        }

                        public final List<JsonElement> component1() {
                            return this.blindBoxWords;
                        }

                        public final String component10() {
                            return this.seid;
                        }

                        public final List<JsonElement> component11() {
                            return this.selectPrices;
                        }

                        public final List<IPFeedRecommendItem> component2() {
                            return this.data;
                        }

                        public final List<JsonElement> component3() {
                            return this.fixHotWords;
                        }

                        public final String component4() {
                            return this.guideIndexUrl;
                        }

                        public final List<JsonElement> component5() {
                            return this.guideSearch;
                        }

                        public final List<JsonElement> component6() {
                            return this.ipFeedSortFilters;
                        }

                        public final Integer component7() {
                            return this.numResults;
                        }

                        public final JsonElement component8() {
                            return this.querySearch;
                        }

                        public final List<JsonElement> component9() {
                            return this.searchFilter;
                        }

                        public final IPFeedRecommendModel copy(List<? extends JsonElement> list, List<IPFeedRecommendItem> list2, List<? extends JsonElement> list3, String str, List<? extends JsonElement> list4, List<? extends JsonElement> list5, Integer num, JsonElement jsonElement, List<? extends JsonElement> list6, String str2, List<? extends JsonElement> list7) {
                            return new IPFeedRecommendModel(list, list2, list3, str, list4, list5, num, jsonElement, list6, str2, list7);
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj instanceof IPFeedRecommendModel) {
                                IPFeedRecommendModel iPFeedRecommendModel = (IPFeedRecommendModel) obj;
                                return Intrinsics.areEqual(this.blindBoxWords, iPFeedRecommendModel.blindBoxWords) && Intrinsics.areEqual(this.data, iPFeedRecommendModel.data) && Intrinsics.areEqual(this.fixHotWords, iPFeedRecommendModel.fixHotWords) && Intrinsics.areEqual(this.guideIndexUrl, iPFeedRecommendModel.guideIndexUrl) && Intrinsics.areEqual(this.guideSearch, iPFeedRecommendModel.guideSearch) && Intrinsics.areEqual(this.ipFeedSortFilters, iPFeedRecommendModel.ipFeedSortFilters) && Intrinsics.areEqual(this.numResults, iPFeedRecommendModel.numResults) && Intrinsics.areEqual(this.querySearch, iPFeedRecommendModel.querySearch) && Intrinsics.areEqual(this.searchFilter, iPFeedRecommendModel.searchFilter) && Intrinsics.areEqual(this.seid, iPFeedRecommendModel.seid) && Intrinsics.areEqual(this.selectPrices, iPFeedRecommendModel.selectPrices);
                            }
                            return false;
                        }

                        public int hashCode() {
                            return ((((((((((((((((((((this.blindBoxWords == null ? 0 : this.blindBoxWords.hashCode()) * 31) + (this.data == null ? 0 : this.data.hashCode())) * 31) + (this.fixHotWords == null ? 0 : this.fixHotWords.hashCode())) * 31) + (this.guideIndexUrl == null ? 0 : this.guideIndexUrl.hashCode())) * 31) + (this.guideSearch == null ? 0 : this.guideSearch.hashCode())) * 31) + (this.ipFeedSortFilters == null ? 0 : this.ipFeedSortFilters.hashCode())) * 31) + (this.numResults == null ? 0 : this.numResults.hashCode())) * 31) + (this.querySearch == null ? 0 : this.querySearch.hashCode())) * 31) + (this.searchFilter == null ? 0 : this.searchFilter.hashCode())) * 31) + (this.seid == null ? 0 : this.seid.hashCode())) * 31) + (this.selectPrices != null ? this.selectPrices.hashCode() : 0);
                        }

                        public String toString() {
                            List<JsonElement> list = this.blindBoxWords;
                            List<IPFeedRecommendItem> list2 = this.data;
                            List<JsonElement> list3 = this.fixHotWords;
                            String str = this.guideIndexUrl;
                            List<JsonElement> list4 = this.guideSearch;
                            List<JsonElement> list5 = this.ipFeedSortFilters;
                            Integer num = this.numResults;
                            JsonElement jsonElement = this.querySearch;
                            List<JsonElement> list6 = this.searchFilter;
                            String str2 = this.seid;
                            return "IPFeedRecommendModel(blindBoxWords=" + list + ", data=" + list2 + ", fixHotWords=" + list3 + ", guideIndexUrl=" + str + ", guideSearch=" + list4 + ", ipFeedSortFilters=" + list5 + ", numResults=" + num + ", querySearch=" + jsonElement + ", searchFilter=" + list6 + ", seid=" + str2 + ", selectPrices=" + this.selectPrices + ")";
                        }

                        /* compiled from: IPFeedRecommendApiService.kt */
                        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class Companion {
                            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                this();
                            }

                            private Companion() {
                            }

                            public final KSerializer<IPFeedRecommendModel> serializer() {
                                return IPFeedRecommendApiService$IPFeedRecommendModel$$serializer.INSTANCE;
                            }
                        }

                        public /* synthetic */ IPFeedRecommendModel(int seen0, List blindBoxWords, List data, List fixHotWords, String guideIndexUrl, List guideSearch, List ipFeedSortFilters, Integer numResults, JsonElement querySearch, List searchFilter, String seid, List selectPrices, SerializationConstructorMarker serializationConstructorMarker) {
                            if ((seen0 & 1) == 0) {
                                this.blindBoxWords = null;
                            } else {
                                this.blindBoxWords = blindBoxWords;
                            }
                            if ((seen0 & 2) == 0) {
                                this.data = null;
                            } else {
                                this.data = data;
                            }
                            if ((seen0 & 4) == 0) {
                                this.fixHotWords = null;
                            } else {
                                this.fixHotWords = fixHotWords;
                            }
                            if ((seen0 & 8) == 0) {
                                this.guideIndexUrl = null;
                            } else {
                                this.guideIndexUrl = guideIndexUrl;
                            }
                            if ((seen0 & 16) == 0) {
                                this.guideSearch = null;
                            } else {
                                this.guideSearch = guideSearch;
                            }
                            if ((seen0 & 32) == 0) {
                                this.ipFeedSortFilters = null;
                            } else {
                                this.ipFeedSortFilters = ipFeedSortFilters;
                            }
                            if ((seen0 & 64) == 0) {
                                this.numResults = null;
                            } else {
                                this.numResults = numResults;
                            }
                            if ((seen0 & 128) == 0) {
                                this.querySearch = null;
                            } else {
                                this.querySearch = querySearch;
                            }
                            if ((seen0 & 256) == 0) {
                                this.searchFilter = null;
                            } else {
                                this.searchFilter = searchFilter;
                            }
                            if ((seen0 & 512) == 0) {
                                this.seid = null;
                            } else {
                                this.seid = seid;
                            }
                            if ((seen0 & 1024) == 0) {
                                this.selectPrices = null;
                            } else {
                                this.selectPrices = selectPrices;
                            }
                        }

                        public IPFeedRecommendModel(List<? extends JsonElement> list, List<IPFeedRecommendItem> list2, List<? extends JsonElement> list3, String guideIndexUrl, List<? extends JsonElement> list4, List<? extends JsonElement> list5, Integer numResults, JsonElement querySearch, List<? extends JsonElement> list6, String seid, List<? extends JsonElement> list7) {
                            this.blindBoxWords = list;
                            this.data = list2;
                            this.fixHotWords = list3;
                            this.guideIndexUrl = guideIndexUrl;
                            this.guideSearch = list4;
                            this.ipFeedSortFilters = list5;
                            this.numResults = numResults;
                            this.querySearch = querySearch;
                            this.searchFilter = list6;
                            this.seid = seid;
                            this.selectPrices = list7;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                            return new ArrayListSerializer(JsonElementSerializer.INSTANCE);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                            return new ArrayListSerializer(IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$$serializer.INSTANCE);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
                            return new ArrayListSerializer(JsonElementSerializer.INSTANCE);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
                            return new ArrayListSerializer(JsonElementSerializer.INSTANCE);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
                            return new ArrayListSerializer(JsonElementSerializer.INSTANCE);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$4() {
                            return new ArrayListSerializer(JsonElementSerializer.INSTANCE);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$5() {
                            return new ArrayListSerializer(JsonElementSerializer.INSTANCE);
                        }

                        @JvmStatic
                        public static final /* synthetic */ void write$Self$product_details_page_debug(IPFeedRecommendModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
                            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.blindBoxWords != null) {
                                output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.blindBoxWords);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.data != null) {
                                output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.data);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.fixHotWords != null) {
                                output.encodeNullableSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.fixHotWords);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.guideIndexUrl != null) {
                                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.guideIndexUrl);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.guideSearch != null) {
                                output.encodeNullableSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.guideSearch);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.ipFeedSortFilters != null) {
                                output.encodeNullableSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.ipFeedSortFilters);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.numResults != null) {
                                output.encodeNullableSerializableElement(serialDesc, 6, IntSerializer.INSTANCE, self.numResults);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.querySearch != null) {
                                output.encodeNullableSerializableElement(serialDesc, 7, JsonElementSerializer.INSTANCE, self.querySearch);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.searchFilter != null) {
                                output.encodeNullableSerializableElement(serialDesc, 8, lazyArr[8].getValue(), self.searchFilter);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.seid != null) {
                                output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.seid);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.selectPrices != null) {
                                output.encodeNullableSerializableElement(serialDesc, 10, lazyArr[10].getValue(), self.selectPrices);
                            }
                        }

                        public /* synthetic */ IPFeedRecommendModel(List list, List list2, List list3, String str, List list4, List list5, Integer num, JsonElement jsonElement, List list6, String str2, List list7, int i, DefaultConstructorMarker defaultConstructorMarker) {
                            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : list4, (i & 32) != 0 ? null : list5, (i & 64) != 0 ? null : num, (i & 128) != 0 ? null : jsonElement, (i & 256) != 0 ? null : list6, (i & 512) != 0 ? null : str2, (i & 1024) == 0 ? list7 : null);
                        }

                        public final List<JsonElement> getBlindBoxWords() {
                            return this.blindBoxWords;
                        }

                        public final List<IPFeedRecommendItem> getData() {
                            return this.data;
                        }

                        public final List<JsonElement> getFixHotWords() {
                            return this.fixHotWords;
                        }

                        public final String getGuideIndexUrl() {
                            return this.guideIndexUrl;
                        }

                        public final List<JsonElement> getGuideSearch() {
                            return this.guideSearch;
                        }

                        public final List<JsonElement> getIpFeedSortFilters() {
                            return this.ipFeedSortFilters;
                        }

                        public final Integer getNumResults() {
                            return this.numResults;
                        }

                        public final JsonElement getQuerySearch() {
                            return this.querySearch;
                        }

                        public final List<JsonElement> getSearchFilter() {
                            return this.searchFilter;
                        }

                        public final String getSeid() {
                            return this.seid;
                        }

                        public final List<JsonElement> getSelectPrices() {
                            return this.selectPrices;
                        }

                        public final boolean shouldShowIpFeedRecommend$product_details_page_debug() {
                            List<IPFeedRecommendItem> list = this.data;
                            int size = list != null ? list.size() : 0;
                            return size > 3;
                        }

                        /* compiled from: IPFeedRecommendApiService.kt */
                        @Metadata(d1 = {"\u0000\u009b\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0003\b\u0086\u0001\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087\b\u0018\u0000 á\u00012\u00020\u0001:\u000eÛ\u0001Ü\u0001Ý\u0001Þ\u0001ß\u0001à\u0001á\u0001B¯\u0005\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\u0006\u0010'\u001a\u00020\n\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000108\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u001b\u0012\u0010\b\u0002\u0010@\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010\u0005\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010C\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\n¢\u0006\u0004\bH\u0010IBã\u0004\b\u0010\u0012\u0006\u0010J\u001a\u00020 \u0012\u0006\u0010K\u001a\u00020 \u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\u0010#\u001a\u0004\u0018\u00010\n\u0012\b\u0010$\u001a\u0004\u0018\u00010\n\u0012\b\u0010%\u001a\u0004\u0018\u00010&\u0012\b\u0010'\u001a\u0004\u0018\u00010\n\u0012\b\u0010(\u001a\u0004\u0018\u00010 \u0012\b\u0010)\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010*\u001a\u0004\u0018\u00010\n\u0012\b\u0010+\u001a\u0004\u0018\u00010,\u0012\b\u0010-\u001a\u0004\u0018\u00010\"\u0012\b\u0010.\u001a\u0004\u0018\u00010\n\u0012\b\u0010/\u001a\u0004\u0018\u00010 \u0012\b\u00100\u001a\u0004\u0018\u00010\n\u0012\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005\u0012\b\u00102\u001a\u0004\u0018\u00010\n\u0012\b\u00103\u001a\u0004\u0018\u00010\n\u0012\b\u00104\u001a\u0004\u0018\u00010\n\u0012\b\u00105\u001a\u0004\u0018\u00010\n\u0012\b\u00106\u001a\u0004\u0018\u00010 \u0012\b\u00107\u001a\u0004\u0018\u000108\u0012\b\u00109\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010:\u001a\u0004\u0018\u00010;\u0012\b\u0010<\u001a\u0004\u0018\u00010\"\u0012\b\u0010=\u001a\u0004\u0018\u00010\n\u0012\b\u0010>\u001a\u0004\u0018\u00010\n\u0012\b\u0010?\u001a\u0004\u0018\u00010\u001b\u0012\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010\u0005\u0012\b\u0010B\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005\u0012\b\u0010D\u001a\u0004\u0018\u00010E\u0012\b\u0010F\u001a\u0004\u0018\u00010 \u0012\b\u0010G\u001a\u0004\u0018\u00010\n\u0012\b\u0010L\u001a\u0004\u0018\u00010M¢\u0006\u0004\bH\u0010NJ\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010\u0098\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0099\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010TJ\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\f\u0010 \u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0012\u0010¡\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005HÆ\u0003J\u0011\u0010¢\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010TJ\f\u0010£\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0012\u0010¤\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005HÆ\u0003J\u0011\u0010¥\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010TJ\f\u0010¦\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\f\u0010§\u0001\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u0011\u0010¨\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010hJ\u0011\u0010©\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010hJ\f\u0010ª\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\f\u0010«\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010¬\u0001\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0002\u0010nJ\u0011\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0002\u0010qJ\f\u0010®\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\f\u0010¯\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\f\u0010°\u0001\u001a\u0004\u0018\u00010&HÆ\u0003J\n\u0010±\u0001\u001a\u00020\nHÆ\u0003J\u0011\u0010²\u0001\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0002\u0010nJ\u0011\u0010³\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010hJ\f\u0010´\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\f\u0010µ\u0001\u001a\u0004\u0018\u00010,HÆ\u0003J\u0011\u0010¶\u0001\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0002\u0010qJ\f\u0010·\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010¸\u0001\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0002\u0010nJ\f\u0010¹\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0012\u0010º\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005HÆ\u0003J\f\u0010»\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\f\u0010¼\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\f\u0010½\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\f\u0010¾\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010¿\u0001\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0002\u0010nJ\f\u0010À\u0001\u001a\u0004\u0018\u000108HÆ\u0003J\u0011\u0010Á\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010hJ\f\u0010Â\u0001\u001a\u0004\u0018\u00010;HÆ\u0003J\u0011\u0010Ã\u0001\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0002\u0010qJ\f\u0010Ä\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\f\u0010Å\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010Æ\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010hJ\u0012\u0010Ç\u0001\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010\u0005HÆ\u0003J\f\u0010È\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0012\u0010É\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005HÆ\u0003J\f\u0010Ê\u0001\u001a\u0004\u0018\u00010EHÆ\u0003J\u0011\u0010Ë\u0001\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0002\u0010nJ\f\u0010Ì\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003Jº\u0005\u0010Í\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010'\u001a\u00020\n2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010 2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00106\u001a\u0004\u0018\u00010 2\n\b\u0002\u00107\u001a\u0004\u0018\u0001082\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u001b2\u0010\b\u0002\u0010@\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010\u00052\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010C\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00052\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0003\u0010Î\u0001J\u0015\u0010Ï\u0001\u001a\u00020\"2\t\u0010Ð\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010Ñ\u0001\u001a\u00020 HÖ\u0001J\n\u0010Ò\u0001\u001a\u00020\nHÖ\u0001J-\u0010Ó\u0001\u001a\u00030Ô\u00012\u0007\u0010Õ\u0001\u001a\u00020\u00002\b\u0010Ö\u0001\u001a\u00030×\u00012\b\u0010Ø\u0001\u001a\u00030Ù\u0001H\u0001¢\u0006\u0003\bÚ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010U\u001a\u0004\bS\u0010TR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bX\u0010WR\u0013\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bY\u0010WR\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010WR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b[\u0010WR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b^\u0010WR\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b_\u0010RR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010U\u001a\u0004\b`\u0010TR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\ba\u0010WR\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bb\u0010RR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010U\u001a\u0004\bc\u0010TR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bd\u0010WR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010i\u001a\u0004\bg\u0010hR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010i\u001a\u0004\bj\u0010hR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bk\u0010WR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bl\u0010WR\u0015\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\n\n\u0002\u0010o\u001a\u0004\bm\u0010nR\u0015\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\n\n\u0002\u0010r\u001a\u0004\bp\u0010qR\u0013\u0010#\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bs\u0010WR\u0013\u0010$\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bt\u0010WR\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u0011\u0010'\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bw\u0010WR\u0015\u0010(\u001a\u0004\u0018\u00010 ¢\u0006\n\n\u0002\u0010o\u001a\u0004\bx\u0010nR\u0015\u0010)\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010i\u001a\u0004\by\u0010hR\u0013\u0010*\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bz\u0010WR\u0013\u0010+\u001a\u0004\u0018\u00010,¢\u0006\b\n\u0000\u001a\u0004\b{\u0010|R\u0015\u0010-\u001a\u0004\u0018\u00010\"¢\u0006\n\n\u0002\u0010r\u001a\u0004\b}\u0010qR\u0013\u0010.\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b~\u0010WR\u0015\u0010/\u001a\u0004\u0018\u00010 ¢\u0006\n\n\u0002\u0010o\u001a\u0004\b\u007f\u0010nR\u0014\u00100\u001a\u0004\u0018\u00010\n¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010WR\u001a\u00101\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010RR\u0014\u00102\u001a\u0004\u0018\u00010\n¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010WR\u0014\u00103\u001a\u0004\u0018\u00010\n¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010WR\u0014\u00104\u001a\u0004\u0018\u00010\n¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010WR\u0014\u00105\u001a\u0004\u0018\u00010\n¢\u0006\t\n\u0000\u001a\u0005\b\u0085\u0001\u0010WR\u0016\u00106\u001a\u0004\u0018\u00010 ¢\u0006\u000b\n\u0002\u0010o\u001a\u0005\b\u0086\u0001\u0010nR\u0015\u00107\u001a\u0004\u0018\u000108¢\u0006\n\n\u0000\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0016\u00109\u001a\u0004\u0018\u00010\u001b¢\u0006\u000b\n\u0002\u0010i\u001a\u0005\b\u0089\u0001\u0010hR\u0015\u0010:\u001a\u0004\u0018\u00010;¢\u0006\n\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0016\u0010<\u001a\u0004\u0018\u00010\"¢\u0006\u000b\n\u0002\u0010r\u001a\u0005\b\u008c\u0001\u0010qR\u0014\u0010=\u001a\u0004\u0018\u00010\n¢\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010WR\u0014\u0010>\u001a\u0004\u0018\u00010\n¢\u0006\t\n\u0000\u001a\u0005\b\u008e\u0001\u0010WR\u0016\u0010?\u001a\u0004\u0018\u00010\u001b¢\u0006\u000b\n\u0002\u0010i\u001a\u0005\b\u008f\u0001\u0010hR\u001a\u0010@\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0090\u0001\u0010RR\u0014\u0010B\u001a\u0004\u0018\u00010\n¢\u0006\t\n\u0000\u001a\u0005\b\u0091\u0001\u0010WR\u001a\u0010C\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0092\u0001\u0010RR\u0015\u0010D\u001a\u0004\u0018\u00010E¢\u0006\n\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0016\u0010F\u001a\u0004\u0018\u00010 ¢\u0006\u000b\n\u0002\u0010o\u001a\u0005\b\u0095\u0001\u0010nR\u0014\u0010G\u001a\u0004\u0018\u00010\n¢\u0006\t\n\u0000\u001a\u0005\b\u0096\u0001\u0010W¨\u0006â\u0001"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem;", "", "advState", "Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState;", "atmosList", "", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$AtmosInfo;", "brandId", "", "brandName", "", "brief", "cardType", "coin", "extraInfo", "feedTag", "Lkntr/app/mall/product/details/page/api/model/ShopItem$LabelGroup;", "guideIndexUrl", "imageList", "ipRightId", "ipRightName", "itemAttrs", "itemsId", "itemsImg", "itemsLabelVO", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$ItemsLabel;", "itemsType", "", "jumpLinkType", "jumpUrl", "jumpUrlH5", "like", "", "living", "", "marketingTag", "maxPreDepositPrice", "merchantInfo", "Lkntr/app/mall/product/details/page/api/model/ShopItem$MerchantInfo;", "name", "originPrice", "payType", "preDepositPrice", "preDepositVO", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$PreDeposit;", "preSale", "presaleDeliveryTimeStr", "presaleStartOrderTime", "price", "priceDesc", "pricePrefix", "priceSymbol", "properties", "recommendTag", "remain", "reportParams", "Lkotlinx/serialization/json/JsonObject;", "saleType", "secondKillVO", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SecondKillModel;", "selfSold", "soldOut", "specific", "subSaleType", "subSkuList", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SubSkuModel;", "tag", "tagPrefix", "tags", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$TagsModel;", "templateId", "track_Id", "<init>", "(Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ShopItem$LabelGroup;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$ItemsLabel;Ljava/lang/Byte;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ShopItem$MerchantInfo;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$PreDeposit;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/json/JsonObject;Ljava/lang/Byte;Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SecondKillModel;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$TagsModel;Ljava/lang/Integer;Ljava/lang/String;)V", "seen0", "seen1", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ShopItem$LabelGroup;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$ItemsLabel;Ljava/lang/Byte;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ShopItem$MerchantInfo;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$PreDeposit;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/json/JsonObject;Ljava/lang/Byte;Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SecondKillModel;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$TagsModel;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAdvState", "()Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState;", "getAtmosList", "()Ljava/util/List;", "getBrandId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getBrandName", "()Ljava/lang/String;", "getBrief", "getCardType", "getCoin", "getExtraInfo", "getFeedTag", "()Lkntr/app/mall/product/details/page/api/model/ShopItem$LabelGroup;", "getGuideIndexUrl", "getImageList", "getIpRightId", "getIpRightName", "getItemAttrs", "getItemsId", "getItemsImg", "getItemsLabelVO", "()Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$ItemsLabel;", "getItemsType", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getJumpLinkType", "getJumpUrl", "getJumpUrlH5", "getLike", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLiving", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMarketingTag", "getMaxPreDepositPrice", "getMerchantInfo", "()Lkntr/app/mall/product/details/page/api/model/ShopItem$MerchantInfo;", "getName", "getOriginPrice", "getPayType", "getPreDepositPrice", "getPreDepositVO", "()Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$PreDeposit;", "getPreSale", "getPresaleDeliveryTimeStr", "getPresaleStartOrderTime", "getPrice", "getPriceDesc", "getPricePrefix", "getPriceSymbol", "getProperties", "getRecommendTag", "getRemain", "getReportParams", "()Lkotlinx/serialization/json/JsonObject;", "getSaleType", "getSecondKillVO", "()Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SecondKillModel;", "getSelfSold", "getSoldOut", "getSpecific", "getSubSaleType", "getSubSkuList", "getTag", "getTagPrefix", "getTags", "()Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$TagsModel;", "getTemplateId", "getTrack_Id", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "copy", "(Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ShopItem$LabelGroup;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$ItemsLabel;Ljava/lang/Byte;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ShopItem$MerchantInfo;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$PreDeposit;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/json/JsonObject;Ljava/lang/Byte;Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SecondKillModel;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$TagsModel;Ljava/lang/Integer;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ItemsLabel", "PreDeposit", "SecondKillModel", "SubSkuModel", "TagsModel", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        @Serializable
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class IPFeedRecommendItem {
                            private final AdvStateFloor.AdvState advState;
                            private final List<ActivityInfoFloor.AtmosInfo> atmosList;
                            private final Long brandId;
                            private final String brandName;
                            private final String brief;
                            private final String cardType;
                            private final String coin;
                            private final String extraInfo;
                            private final ShopItem.LabelGroup feedTag;
                            private final String guideIndexUrl;
                            private final List<String> imageList;
                            private final Long ipRightId;
                            private final String ipRightName;
                            private final List<String> itemAttrs;
                            private final Long itemsId;
                            private final String itemsImg;
                            private final ItemsLabel itemsLabelVO;
                            private final Byte itemsType;
                            private final Byte jumpLinkType;
                            private final String jumpUrl;
                            private final String jumpUrlH5;
                            private final Integer like;
                            private final Boolean living;
                            private final String marketingTag;
                            private final String maxPreDepositPrice;
                            private final ShopItem.MerchantInfo merchantInfo;
                            private final String name;
                            private final Integer originPrice;
                            private final Byte payType;
                            private final String preDepositPrice;
                            private final PreDeposit preDepositVO;
                            private final Boolean preSale;
                            private final String presaleDeliveryTimeStr;
                            private final Integer presaleStartOrderTime;
                            private final String price;
                            private final List<String> priceDesc;
                            private final String pricePrefix;
                            private final String priceSymbol;
                            private final String properties;
                            private final String recommendTag;
                            private final Integer remain;
                            private final JsonObject reportParams;
                            private final Byte saleType;
                            private final SecondKillModel secondKillVO;
                            private final Boolean selfSold;
                            private final String soldOut;
                            private final String specific;
                            private final Byte subSaleType;
                            private final List<SubSkuModel> subSkuList;
                            private final String tag;
                            private final List<String> tagPrefix;
                            private final TagsModel tags;
                            private final Integer templateId;
                            private final String track_Id;
                            public static final Companion Companion = new Companion(null);
                            public static final int $stable = 8;
                            private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$$ExternalSyntheticLambda0
                                public final Object invoke() {
                                    KSerializer _childSerializers$_anonymous_;
                                    _childSerializers$_anonymous_ = IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem._childSerializers$_anonymous_();
                                    return _childSerializers$_anonymous_;
                                }
                            }), null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$$ExternalSyntheticLambda1
                                public final Object invoke() {
                                    KSerializer _childSerializers$_anonymous_$0;
                                    _childSerializers$_anonymous_$0 = IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem._childSerializers$_anonymous_$0();
                                    return _childSerializers$_anonymous_$0;
                                }
                            }), null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$$ExternalSyntheticLambda2
                                public final Object invoke() {
                                    KSerializer _childSerializers$_anonymous_$1;
                                    _childSerializers$_anonymous_$1 = IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem._childSerializers$_anonymous_$1();
                                    return _childSerializers$_anonymous_$1;
                                }
                            }), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$$ExternalSyntheticLambda3
                                public final Object invoke() {
                                    KSerializer _childSerializers$_anonymous_$2;
                                    _childSerializers$_anonymous_$2 = IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem._childSerializers$_anonymous_$2();
                                    return _childSerializers$_anonymous_$2;
                                }
                            }), null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$$ExternalSyntheticLambda4
                                public final Object invoke() {
                                    KSerializer _childSerializers$_anonymous_$3;
                                    _childSerializers$_anonymous_$3 = IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem._childSerializers$_anonymous_$3();
                                    return _childSerializers$_anonymous_$3;
                                }
                            }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$$ExternalSyntheticLambda5
                                public final Object invoke() {
                                    KSerializer _childSerializers$_anonymous_$4;
                                    _childSerializers$_anonymous_$4 = IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem._childSerializers$_anonymous_$4();
                                    return _childSerializers$_anonymous_$4;
                                }
                            }), null, null, null};

                            public final AdvStateFloor.AdvState component1() {
                                return this.advState;
                            }

                            public final String component10() {
                                return this.guideIndexUrl;
                            }

                            public final List<String> component11() {
                                return this.imageList;
                            }

                            public final Long component12() {
                                return this.ipRightId;
                            }

                            public final String component13() {
                                return this.ipRightName;
                            }

                            public final List<String> component14() {
                                return this.itemAttrs;
                            }

                            public final Long component15() {
                                return this.itemsId;
                            }

                            public final String component16() {
                                return this.itemsImg;
                            }

                            public final ItemsLabel component17() {
                                return this.itemsLabelVO;
                            }

                            public final Byte component18() {
                                return this.itemsType;
                            }

                            public final Byte component19() {
                                return this.jumpLinkType;
                            }

                            public final List<ActivityInfoFloor.AtmosInfo> component2() {
                                return this.atmosList;
                            }

                            public final String component20() {
                                return this.jumpUrl;
                            }

                            public final String component21() {
                                return this.jumpUrlH5;
                            }

                            public final Integer component22() {
                                return this.like;
                            }

                            public final Boolean component23() {
                                return this.living;
                            }

                            public final String component24() {
                                return this.marketingTag;
                            }

                            public final String component25() {
                                return this.maxPreDepositPrice;
                            }

                            public final ShopItem.MerchantInfo component26() {
                                return this.merchantInfo;
                            }

                            public final String component27() {
                                return this.name;
                            }

                            public final Integer component28() {
                                return this.originPrice;
                            }

                            public final Byte component29() {
                                return this.payType;
                            }

                            public final Long component3() {
                                return this.brandId;
                            }

                            public final String component30() {
                                return this.preDepositPrice;
                            }

                            public final PreDeposit component31() {
                                return this.preDepositVO;
                            }

                            public final Boolean component32() {
                                return this.preSale;
                            }

                            public final String component33() {
                                return this.presaleDeliveryTimeStr;
                            }

                            public final Integer component34() {
                                return this.presaleStartOrderTime;
                            }

                            public final String component35() {
                                return this.price;
                            }

                            public final List<String> component36() {
                                return this.priceDesc;
                            }

                            public final String component37() {
                                return this.pricePrefix;
                            }

                            public final String component38() {
                                return this.priceSymbol;
                            }

                            public final String component39() {
                                return this.properties;
                            }

                            public final String component4() {
                                return this.brandName;
                            }

                            public final String component40() {
                                return this.recommendTag;
                            }

                            public final Integer component41() {
                                return this.remain;
                            }

                            public final JsonObject component42() {
                                return this.reportParams;
                            }

                            public final Byte component43() {
                                return this.saleType;
                            }

                            public final SecondKillModel component44() {
                                return this.secondKillVO;
                            }

                            public final Boolean component45() {
                                return this.selfSold;
                            }

                            public final String component46() {
                                return this.soldOut;
                            }

                            public final String component47() {
                                return this.specific;
                            }

                            public final Byte component48() {
                                return this.subSaleType;
                            }

                            public final List<SubSkuModel> component49() {
                                return this.subSkuList;
                            }

                            public final String component5() {
                                return this.brief;
                            }

                            public final String component50() {
                                return this.tag;
                            }

                            public final List<String> component51() {
                                return this.tagPrefix;
                            }

                            public final TagsModel component52() {
                                return this.tags;
                            }

                            public final Integer component53() {
                                return this.templateId;
                            }

                            public final String component54() {
                                return this.track_Id;
                            }

                            public final String component6() {
                                return this.cardType;
                            }

                            public final String component7() {
                                return this.coin;
                            }

                            public final String component8() {
                                return this.extraInfo;
                            }

                            public final ShopItem.LabelGroup component9() {
                                return this.feedTag;
                            }

                            public final IPFeedRecommendItem copy(AdvStateFloor.AdvState advState, List<ActivityInfoFloor.AtmosInfo> list, Long l, String str, String str2, String str3, String str4, String str5, ShopItem.LabelGroup labelGroup, String str6, List<String> list2, Long l2, String str7, List<String> list3, Long l3, String str8, ItemsLabel itemsLabel, Byte b, Byte b2, String str9, String str10, Integer num, Boolean bool, String str11, String str12, ShopItem.MerchantInfo merchantInfo, String str13, Integer num2, Byte b3, String str14, PreDeposit preDeposit, Boolean bool2, String str15, Integer num3, String str16, List<String> list4, String str17, String str18, String str19, String str20, Integer num4, JsonObject jsonObject, Byte b4, SecondKillModel secondKillModel, Boolean bool3, String str21, String str22, Byte b5, List<SubSkuModel> list5, String str23, List<String> list6, TagsModel tagsModel, Integer num5, String str24) {
                                Intrinsics.checkNotNullParameter(str13, "name");
                                return new IPFeedRecommendItem(advState, list, l, str, str2, str3, str4, str5, labelGroup, str6, list2, l2, str7, list3, l3, str8, itemsLabel, b, b2, str9, str10, num, bool, str11, str12, merchantInfo, str13, num2, b3, str14, preDeposit, bool2, str15, num3, str16, list4, str17, str18, str19, str20, num4, jsonObject, b4, secondKillModel, bool3, str21, str22, b5, list5, str23, list6, tagsModel, num5, str24);
                            }

                            public boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj instanceof IPFeedRecommendItem) {
                                    IPFeedRecommendItem iPFeedRecommendItem = (IPFeedRecommendItem) obj;
                                    return Intrinsics.areEqual(this.advState, iPFeedRecommendItem.advState) && Intrinsics.areEqual(this.atmosList, iPFeedRecommendItem.atmosList) && Intrinsics.areEqual(this.brandId, iPFeedRecommendItem.brandId) && Intrinsics.areEqual(this.brandName, iPFeedRecommendItem.brandName) && Intrinsics.areEqual(this.brief, iPFeedRecommendItem.brief) && Intrinsics.areEqual(this.cardType, iPFeedRecommendItem.cardType) && Intrinsics.areEqual(this.coin, iPFeedRecommendItem.coin) && Intrinsics.areEqual(this.extraInfo, iPFeedRecommendItem.extraInfo) && Intrinsics.areEqual(this.feedTag, iPFeedRecommendItem.feedTag) && Intrinsics.areEqual(this.guideIndexUrl, iPFeedRecommendItem.guideIndexUrl) && Intrinsics.areEqual(this.imageList, iPFeedRecommendItem.imageList) && Intrinsics.areEqual(this.ipRightId, iPFeedRecommendItem.ipRightId) && Intrinsics.areEqual(this.ipRightName, iPFeedRecommendItem.ipRightName) && Intrinsics.areEqual(this.itemAttrs, iPFeedRecommendItem.itemAttrs) && Intrinsics.areEqual(this.itemsId, iPFeedRecommendItem.itemsId) && Intrinsics.areEqual(this.itemsImg, iPFeedRecommendItem.itemsImg) && Intrinsics.areEqual(this.itemsLabelVO, iPFeedRecommendItem.itemsLabelVO) && Intrinsics.areEqual(this.itemsType, iPFeedRecommendItem.itemsType) && Intrinsics.areEqual(this.jumpLinkType, iPFeedRecommendItem.jumpLinkType) && Intrinsics.areEqual(this.jumpUrl, iPFeedRecommendItem.jumpUrl) && Intrinsics.areEqual(this.jumpUrlH5, iPFeedRecommendItem.jumpUrlH5) && Intrinsics.areEqual(this.like, iPFeedRecommendItem.like) && Intrinsics.areEqual(this.living, iPFeedRecommendItem.living) && Intrinsics.areEqual(this.marketingTag, iPFeedRecommendItem.marketingTag) && Intrinsics.areEqual(this.maxPreDepositPrice, iPFeedRecommendItem.maxPreDepositPrice) && Intrinsics.areEqual(this.merchantInfo, iPFeedRecommendItem.merchantInfo) && Intrinsics.areEqual(this.name, iPFeedRecommendItem.name) && Intrinsics.areEqual(this.originPrice, iPFeedRecommendItem.originPrice) && Intrinsics.areEqual(this.payType, iPFeedRecommendItem.payType) && Intrinsics.areEqual(this.preDepositPrice, iPFeedRecommendItem.preDepositPrice) && Intrinsics.areEqual(this.preDepositVO, iPFeedRecommendItem.preDepositVO) && Intrinsics.areEqual(this.preSale, iPFeedRecommendItem.preSale) && Intrinsics.areEqual(this.presaleDeliveryTimeStr, iPFeedRecommendItem.presaleDeliveryTimeStr) && Intrinsics.areEqual(this.presaleStartOrderTime, iPFeedRecommendItem.presaleStartOrderTime) && Intrinsics.areEqual(this.price, iPFeedRecommendItem.price) && Intrinsics.areEqual(this.priceDesc, iPFeedRecommendItem.priceDesc) && Intrinsics.areEqual(this.pricePrefix, iPFeedRecommendItem.pricePrefix) && Intrinsics.areEqual(this.priceSymbol, iPFeedRecommendItem.priceSymbol) && Intrinsics.areEqual(this.properties, iPFeedRecommendItem.properties) && Intrinsics.areEqual(this.recommendTag, iPFeedRecommendItem.recommendTag) && Intrinsics.areEqual(this.remain, iPFeedRecommendItem.remain) && Intrinsics.areEqual(this.reportParams, iPFeedRecommendItem.reportParams) && Intrinsics.areEqual(this.saleType, iPFeedRecommendItem.saleType) && Intrinsics.areEqual(this.secondKillVO, iPFeedRecommendItem.secondKillVO) && Intrinsics.areEqual(this.selfSold, iPFeedRecommendItem.selfSold) && Intrinsics.areEqual(this.soldOut, iPFeedRecommendItem.soldOut) && Intrinsics.areEqual(this.specific, iPFeedRecommendItem.specific) && Intrinsics.areEqual(this.subSaleType, iPFeedRecommendItem.subSaleType) && Intrinsics.areEqual(this.subSkuList, iPFeedRecommendItem.subSkuList) && Intrinsics.areEqual(this.tag, iPFeedRecommendItem.tag) && Intrinsics.areEqual(this.tagPrefix, iPFeedRecommendItem.tagPrefix) && Intrinsics.areEqual(this.tags, iPFeedRecommendItem.tags) && Intrinsics.areEqual(this.templateId, iPFeedRecommendItem.templateId) && Intrinsics.areEqual(this.track_Id, iPFeedRecommendItem.track_Id);
                                }
                                return false;
                            }

                            public int hashCode() {
                                return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.advState == null ? 0 : this.advState.hashCode()) * 31) + (this.atmosList == null ? 0 : this.atmosList.hashCode())) * 31) + (this.brandId == null ? 0 : this.brandId.hashCode())) * 31) + (this.brandName == null ? 0 : this.brandName.hashCode())) * 31) + (this.brief == null ? 0 : this.brief.hashCode())) * 31) + (this.cardType == null ? 0 : this.cardType.hashCode())) * 31) + (this.coin == null ? 0 : this.coin.hashCode())) * 31) + (this.extraInfo == null ? 0 : this.extraInfo.hashCode())) * 31) + (this.feedTag == null ? 0 : this.feedTag.hashCode())) * 31) + (this.guideIndexUrl == null ? 0 : this.guideIndexUrl.hashCode())) * 31) + (this.imageList == null ? 0 : this.imageList.hashCode())) * 31) + (this.ipRightId == null ? 0 : this.ipRightId.hashCode())) * 31) + (this.ipRightName == null ? 0 : this.ipRightName.hashCode())) * 31) + (this.itemAttrs == null ? 0 : this.itemAttrs.hashCode())) * 31) + (this.itemsId == null ? 0 : this.itemsId.hashCode())) * 31) + (this.itemsImg == null ? 0 : this.itemsImg.hashCode())) * 31) + (this.itemsLabelVO == null ? 0 : this.itemsLabelVO.hashCode())) * 31) + (this.itemsType == null ? 0 : this.itemsType.hashCode())) * 31) + (this.jumpLinkType == null ? 0 : this.jumpLinkType.hashCode())) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.jumpUrlH5 == null ? 0 : this.jumpUrlH5.hashCode())) * 31) + (this.like == null ? 0 : this.like.hashCode())) * 31) + (this.living == null ? 0 : this.living.hashCode())) * 31) + (this.marketingTag == null ? 0 : this.marketingTag.hashCode())) * 31) + (this.maxPreDepositPrice == null ? 0 : this.maxPreDepositPrice.hashCode())) * 31) + (this.merchantInfo == null ? 0 : this.merchantInfo.hashCode())) * 31) + this.name.hashCode()) * 31) + (this.originPrice == null ? 0 : this.originPrice.hashCode())) * 31) + (this.payType == null ? 0 : this.payType.hashCode())) * 31) + (this.preDepositPrice == null ? 0 : this.preDepositPrice.hashCode())) * 31) + (this.preDepositVO == null ? 0 : this.preDepositVO.hashCode())) * 31) + (this.preSale == null ? 0 : this.preSale.hashCode())) * 31) + (this.presaleDeliveryTimeStr == null ? 0 : this.presaleDeliveryTimeStr.hashCode())) * 31) + (this.presaleStartOrderTime == null ? 0 : this.presaleStartOrderTime.hashCode())) * 31) + (this.price == null ? 0 : this.price.hashCode())) * 31) + (this.priceDesc == null ? 0 : this.priceDesc.hashCode())) * 31) + (this.pricePrefix == null ? 0 : this.pricePrefix.hashCode())) * 31) + (this.priceSymbol == null ? 0 : this.priceSymbol.hashCode())) * 31) + (this.properties == null ? 0 : this.properties.hashCode())) * 31) + (this.recommendTag == null ? 0 : this.recommendTag.hashCode())) * 31) + (this.remain == null ? 0 : this.remain.hashCode())) * 31) + (this.reportParams == null ? 0 : this.reportParams.hashCode())) * 31) + (this.saleType == null ? 0 : this.saleType.hashCode())) * 31) + (this.secondKillVO == null ? 0 : this.secondKillVO.hashCode())) * 31) + (this.selfSold == null ? 0 : this.selfSold.hashCode())) * 31) + (this.soldOut == null ? 0 : this.soldOut.hashCode())) * 31) + (this.specific == null ? 0 : this.specific.hashCode())) * 31) + (this.subSaleType == null ? 0 : this.subSaleType.hashCode())) * 31) + (this.subSkuList == null ? 0 : this.subSkuList.hashCode())) * 31) + (this.tag == null ? 0 : this.tag.hashCode())) * 31) + (this.tagPrefix == null ? 0 : this.tagPrefix.hashCode())) * 31) + (this.tags == null ? 0 : this.tags.hashCode())) * 31) + (this.templateId == null ? 0 : this.templateId.hashCode())) * 31) + (this.track_Id != null ? this.track_Id.hashCode() : 0);
                            }

                            public String toString() {
                                AdvStateFloor.AdvState advState = this.advState;
                                List<ActivityInfoFloor.AtmosInfo> list = this.atmosList;
                                Long l = this.brandId;
                                String str = this.brandName;
                                String str2 = this.brief;
                                String str3 = this.cardType;
                                String str4 = this.coin;
                                String str5 = this.extraInfo;
                                ShopItem.LabelGroup labelGroup = this.feedTag;
                                String str6 = this.guideIndexUrl;
                                List<String> list2 = this.imageList;
                                Long l2 = this.ipRightId;
                                String str7 = this.ipRightName;
                                List<String> list3 = this.itemAttrs;
                                Long l3 = this.itemsId;
                                String str8 = this.itemsImg;
                                ItemsLabel itemsLabel = this.itemsLabelVO;
                                Byte b = this.itemsType;
                                Byte b2 = this.jumpLinkType;
                                String str9 = this.jumpUrl;
                                String str10 = this.jumpUrlH5;
                                Integer num = this.like;
                                Boolean bool = this.living;
                                String str11 = this.marketingTag;
                                String str12 = this.maxPreDepositPrice;
                                ShopItem.MerchantInfo merchantInfo = this.merchantInfo;
                                String str13 = this.name;
                                Integer num2 = this.originPrice;
                                Byte b3 = this.payType;
                                String str14 = this.preDepositPrice;
                                PreDeposit preDeposit = this.preDepositVO;
                                Boolean bool2 = this.preSale;
                                String str15 = this.presaleDeliveryTimeStr;
                                Integer num3 = this.presaleStartOrderTime;
                                String str16 = this.price;
                                List<String> list4 = this.priceDesc;
                                String str17 = this.pricePrefix;
                                String str18 = this.priceSymbol;
                                String str19 = this.properties;
                                String str20 = this.recommendTag;
                                Integer num4 = this.remain;
                                JsonObject jsonObject = this.reportParams;
                                Byte b4 = this.saleType;
                                SecondKillModel secondKillModel = this.secondKillVO;
                                Boolean bool3 = this.selfSold;
                                String str21 = this.soldOut;
                                String str22 = this.specific;
                                Byte b5 = this.subSaleType;
                                List<SubSkuModel> list5 = this.subSkuList;
                                String str23 = this.tag;
                                List<String> list6 = this.tagPrefix;
                                TagsModel tagsModel = this.tags;
                                Integer num5 = this.templateId;
                                return "IPFeedRecommendItem(advState=" + advState + ", atmosList=" + list + ", brandId=" + l + ", brandName=" + str + ", brief=" + str2 + ", cardType=" + str3 + ", coin=" + str4 + ", extraInfo=" + str5 + ", feedTag=" + labelGroup + ", guideIndexUrl=" + str6 + ", imageList=" + list2 + ", ipRightId=" + l2 + ", ipRightName=" + str7 + ", itemAttrs=" + list3 + ", itemsId=" + l3 + ", itemsImg=" + str8 + ", itemsLabelVO=" + itemsLabel + ", itemsType=" + b + ", jumpLinkType=" + b2 + ", jumpUrl=" + str9 + ", jumpUrlH5=" + str10 + ", like=" + num + ", living=" + bool + ", marketingTag=" + str11 + ", maxPreDepositPrice=" + str12 + ", merchantInfo=" + merchantInfo + ", name=" + str13 + ", originPrice=" + num2 + ", payType=" + b3 + ", preDepositPrice=" + str14 + ", preDepositVO=" + preDeposit + ", preSale=" + bool2 + ", presaleDeliveryTimeStr=" + str15 + ", presaleStartOrderTime=" + num3 + ", price=" + str16 + ", priceDesc=" + list4 + ", pricePrefix=" + str17 + ", priceSymbol=" + str18 + ", properties=" + str19 + ", recommendTag=" + str20 + ", remain=" + num4 + ", reportParams=" + jsonObject + ", saleType=" + b4 + ", secondKillVO=" + secondKillModel + ", selfSold=" + bool3 + ", soldOut=" + str21 + ", specific=" + str22 + ", subSaleType=" + b5 + ", subSkuList=" + list5 + ", tag=" + str23 + ", tagPrefix=" + list6 + ", tags=" + tagsModel + ", templateId=" + num5 + ", track_Id=" + this.track_Id + ")";
                            }

                            /* compiled from: IPFeedRecommendApiService.kt */
                            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                            public static final class Companion {
                                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                    this();
                                }

                                private Companion() {
                                }

                                public final KSerializer<IPFeedRecommendItem> serializer() {
                                    return IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$$serializer.INSTANCE;
                                }
                            }

                            public /* synthetic */ IPFeedRecommendItem(int seen0, int seen1, AdvStateFloor.AdvState advState, List atmosList, Long brandId, String brandName, String brief, String cardType, String coin, String extraInfo, ShopItem.LabelGroup feedTag, String guideIndexUrl, List imageList, Long ipRightId, String ipRightName, List itemAttrs, Long itemsId, String itemsImg, ItemsLabel itemsLabelVO, Byte itemsType, Byte jumpLinkType, String jumpUrl, String jumpUrlH5, Integer like, Boolean living, String marketingTag, String maxPreDepositPrice, ShopItem.MerchantInfo merchantInfo, String name, Integer originPrice, Byte payType, String preDepositPrice, PreDeposit preDepositVO, Boolean preSale, String presaleDeliveryTimeStr, Integer presaleStartOrderTime, String price, List priceDesc, String pricePrefix, String priceSymbol, String properties, String recommendTag, Integer remain, JsonObject reportParams, Byte saleType, SecondKillModel secondKillVO, Boolean selfSold, String soldOut, String specific, Byte subSaleType, List subSkuList, String tag, List tagPrefix, TagsModel tags, Integer templateId, String track_Id, SerializationConstructorMarker serializationConstructorMarker) {
                                if ((67108864 != (seen0 & 67108864)) | false) {
                                    PluginExceptionsKt.throwArrayMissingFieldException(new int[]{seen0, seen1}, new int[]{67108864, 0}, IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$$serializer.INSTANCE.getDescriptor());
                                }
                                if ((seen0 & 1) == 0) {
                                    this.advState = null;
                                } else {
                                    this.advState = advState;
                                }
                                if ((seen0 & 2) == 0) {
                                    this.atmosList = null;
                                } else {
                                    this.atmosList = atmosList;
                                }
                                if ((seen0 & 4) == 0) {
                                    this.brandId = null;
                                } else {
                                    this.brandId = brandId;
                                }
                                if ((seen0 & 8) == 0) {
                                    this.brandName = null;
                                } else {
                                    this.brandName = brandName;
                                }
                                if ((seen0 & 16) == 0) {
                                    this.brief = null;
                                } else {
                                    this.brief = brief;
                                }
                                if ((seen0 & 32) == 0) {
                                    this.cardType = null;
                                } else {
                                    this.cardType = cardType;
                                }
                                if ((seen0 & 64) == 0) {
                                    this.coin = null;
                                } else {
                                    this.coin = coin;
                                }
                                if ((seen0 & 128) == 0) {
                                    this.extraInfo = null;
                                } else {
                                    this.extraInfo = extraInfo;
                                }
                                if ((seen0 & 256) == 0) {
                                    this.feedTag = null;
                                } else {
                                    this.feedTag = feedTag;
                                }
                                if ((seen0 & 512) == 0) {
                                    this.guideIndexUrl = null;
                                } else {
                                    this.guideIndexUrl = guideIndexUrl;
                                }
                                if ((seen0 & 1024) == 0) {
                                    this.imageList = null;
                                } else {
                                    this.imageList = imageList;
                                }
                                if ((seen0 & 2048) == 0) {
                                    this.ipRightId = null;
                                } else {
                                    this.ipRightId = ipRightId;
                                }
                                if ((seen0 & 4096) == 0) {
                                    this.ipRightName = null;
                                } else {
                                    this.ipRightName = ipRightName;
                                }
                                if ((seen0 & 8192) == 0) {
                                    this.itemAttrs = null;
                                } else {
                                    this.itemAttrs = itemAttrs;
                                }
                                if ((seen0 & 16384) == 0) {
                                    this.itemsId = null;
                                } else {
                                    this.itemsId = itemsId;
                                }
                                if ((seen0 & 32768) == 0) {
                                    this.itemsImg = null;
                                } else {
                                    this.itemsImg = itemsImg;
                                }
                                if ((seen0 & 65536) == 0) {
                                    this.itemsLabelVO = null;
                                } else {
                                    this.itemsLabelVO = itemsLabelVO;
                                }
                                if ((seen0 & 131072) == 0) {
                                    this.itemsType = null;
                                } else {
                                    this.itemsType = itemsType;
                                }
                                if ((seen0 & 262144) == 0) {
                                    this.jumpLinkType = null;
                                } else {
                                    this.jumpLinkType = jumpLinkType;
                                }
                                if ((seen0 & 524288) == 0) {
                                    this.jumpUrl = null;
                                } else {
                                    this.jumpUrl = jumpUrl;
                                }
                                if ((seen0 & 1048576) == 0) {
                                    this.jumpUrlH5 = null;
                                } else {
                                    this.jumpUrlH5 = jumpUrlH5;
                                }
                                if ((seen0 & 2097152) == 0) {
                                    this.like = null;
                                } else {
                                    this.like = like;
                                }
                                if ((seen0 & 4194304) == 0) {
                                    this.living = null;
                                } else {
                                    this.living = living;
                                }
                                if ((seen0 & 8388608) == 0) {
                                    this.marketingTag = null;
                                } else {
                                    this.marketingTag = marketingTag;
                                }
                                if ((seen0 & 16777216) == 0) {
                                    this.maxPreDepositPrice = null;
                                } else {
                                    this.maxPreDepositPrice = maxPreDepositPrice;
                                }
                                if ((seen0 & 33554432) == 0) {
                                    this.merchantInfo = null;
                                } else {
                                    this.merchantInfo = merchantInfo;
                                }
                                this.name = name;
                                if ((seen0 & 134217728) == 0) {
                                    this.originPrice = null;
                                } else {
                                    this.originPrice = originPrice;
                                }
                                if ((seen0 & 268435456) == 0) {
                                    this.payType = null;
                                } else {
                                    this.payType = payType;
                                }
                                if ((seen0 & 536870912) == 0) {
                                    this.preDepositPrice = null;
                                } else {
                                    this.preDepositPrice = preDepositPrice;
                                }
                                if ((seen0 & 1073741824) == 0) {
                                    this.preDepositVO = null;
                                } else {
                                    this.preDepositVO = preDepositVO;
                                }
                                if ((seen0 & Integer.MIN_VALUE) == 0) {
                                    this.preSale = null;
                                } else {
                                    this.preSale = preSale;
                                }
                                if ((seen1 & 1) == 0) {
                                    this.presaleDeliveryTimeStr = null;
                                } else {
                                    this.presaleDeliveryTimeStr = presaleDeliveryTimeStr;
                                }
                                if ((seen1 & 2) == 0) {
                                    this.presaleStartOrderTime = null;
                                } else {
                                    this.presaleStartOrderTime = presaleStartOrderTime;
                                }
                                if ((seen1 & 4) == 0) {
                                    this.price = null;
                                } else {
                                    this.price = price;
                                }
                                if ((seen1 & 8) == 0) {
                                    this.priceDesc = null;
                                } else {
                                    this.priceDesc = priceDesc;
                                }
                                if ((seen1 & 16) == 0) {
                                    this.pricePrefix = null;
                                } else {
                                    this.pricePrefix = pricePrefix;
                                }
                                if ((seen1 & 32) == 0) {
                                    this.priceSymbol = null;
                                } else {
                                    this.priceSymbol = priceSymbol;
                                }
                                if ((seen1 & 64) == 0) {
                                    this.properties = null;
                                } else {
                                    this.properties = properties;
                                }
                                if ((seen1 & 128) == 0) {
                                    this.recommendTag = null;
                                } else {
                                    this.recommendTag = recommendTag;
                                }
                                if ((seen1 & 256) == 0) {
                                    this.remain = null;
                                } else {
                                    this.remain = remain;
                                }
                                if ((seen1 & 512) == 0) {
                                    this.reportParams = null;
                                } else {
                                    this.reportParams = reportParams;
                                }
                                if ((seen1 & 1024) == 0) {
                                    this.saleType = null;
                                } else {
                                    this.saleType = saleType;
                                }
                                if ((seen1 & 2048) == 0) {
                                    this.secondKillVO = null;
                                } else {
                                    this.secondKillVO = secondKillVO;
                                }
                                if ((seen1 & 4096) == 0) {
                                    this.selfSold = null;
                                } else {
                                    this.selfSold = selfSold;
                                }
                                if ((seen1 & 8192) == 0) {
                                    this.soldOut = null;
                                } else {
                                    this.soldOut = soldOut;
                                }
                                if ((seen1 & 16384) == 0) {
                                    this.specific = null;
                                } else {
                                    this.specific = specific;
                                }
                                if ((seen1 & 32768) == 0) {
                                    this.subSaleType = null;
                                } else {
                                    this.subSaleType = subSaleType;
                                }
                                if ((seen1 & 65536) == 0) {
                                    this.subSkuList = null;
                                } else {
                                    this.subSkuList = subSkuList;
                                }
                                if ((seen1 & 131072) == 0) {
                                    this.tag = null;
                                } else {
                                    this.tag = tag;
                                }
                                if ((seen1 & 262144) == 0) {
                                    this.tagPrefix = null;
                                } else {
                                    this.tagPrefix = tagPrefix;
                                }
                                if ((seen1 & 524288) == 0) {
                                    this.tags = null;
                                } else {
                                    this.tags = tags;
                                }
                                if ((seen1 & 1048576) == 0) {
                                    this.templateId = null;
                                } else {
                                    this.templateId = templateId;
                                }
                                if ((seen1 & 2097152) == 0) {
                                    this.track_Id = null;
                                } else {
                                    this.track_Id = track_Id;
                                }
                            }

                            public IPFeedRecommendItem(AdvStateFloor.AdvState advState, List<ActivityInfoFloor.AtmosInfo> list, Long brandId, String brandName, String brief, String cardType, String coin, String extraInfo, ShopItem.LabelGroup feedTag, String guideIndexUrl, List<String> list2, Long ipRightId, String ipRightName, List<String> list3, Long itemsId, String itemsImg, ItemsLabel itemsLabelVO, Byte itemsType, Byte jumpLinkType, String jumpUrl, String jumpUrlH5, Integer like, Boolean living, String marketingTag, String maxPreDepositPrice, ShopItem.MerchantInfo merchantInfo, String name, Integer originPrice, Byte payType, String preDepositPrice, PreDeposit preDepositVO, Boolean preSale, String presaleDeliveryTimeStr, Integer presaleStartOrderTime, String price, List<String> list4, String pricePrefix, String priceSymbol, String properties, String recommendTag, Integer remain, JsonObject reportParams, Byte saleType, SecondKillModel secondKillVO, Boolean selfSold, String soldOut, String specific, Byte subSaleType, List<SubSkuModel> list5, String tag, List<String> list6, TagsModel tags, Integer templateId, String track_Id) {
                                Intrinsics.checkNotNullParameter(name, "name");
                                this.advState = advState;
                                this.atmosList = list;
                                this.brandId = brandId;
                                this.brandName = brandName;
                                this.brief = brief;
                                this.cardType = cardType;
                                this.coin = coin;
                                this.extraInfo = extraInfo;
                                this.feedTag = feedTag;
                                this.guideIndexUrl = guideIndexUrl;
                                this.imageList = list2;
                                this.ipRightId = ipRightId;
                                this.ipRightName = ipRightName;
                                this.itemAttrs = list3;
                                this.itemsId = itemsId;
                                this.itemsImg = itemsImg;
                                this.itemsLabelVO = itemsLabelVO;
                                this.itemsType = itemsType;
                                this.jumpLinkType = jumpLinkType;
                                this.jumpUrl = jumpUrl;
                                this.jumpUrlH5 = jumpUrlH5;
                                this.like = like;
                                this.living = living;
                                this.marketingTag = marketingTag;
                                this.maxPreDepositPrice = maxPreDepositPrice;
                                this.merchantInfo = merchantInfo;
                                this.name = name;
                                this.originPrice = originPrice;
                                this.payType = payType;
                                this.preDepositPrice = preDepositPrice;
                                this.preDepositVO = preDepositVO;
                                this.preSale = preSale;
                                this.presaleDeliveryTimeStr = presaleDeliveryTimeStr;
                                this.presaleStartOrderTime = presaleStartOrderTime;
                                this.price = price;
                                this.priceDesc = list4;
                                this.pricePrefix = pricePrefix;
                                this.priceSymbol = priceSymbol;
                                this.properties = properties;
                                this.recommendTag = recommendTag;
                                this.remain = remain;
                                this.reportParams = reportParams;
                                this.saleType = saleType;
                                this.secondKillVO = secondKillVO;
                                this.selfSold = selfSold;
                                this.soldOut = soldOut;
                                this.specific = specific;
                                this.subSaleType = subSaleType;
                                this.subSkuList = list5;
                                this.tag = tag;
                                this.tagPrefix = list6;
                                this.tags = tags;
                                this.templateId = templateId;
                                this.track_Id = track_Id;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                                return new ArrayListSerializer(ActivityInfoFloor$AtmosInfo$$serializer.INSTANCE);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                                return new ArrayListSerializer(StringSerializer.INSTANCE);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
                                return new ArrayListSerializer(StringSerializer.INSTANCE);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
                                return new ArrayListSerializer(StringSerializer.INSTANCE);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
                                return new ArrayListSerializer(IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SubSkuModel$$serializer.INSTANCE);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$4() {
                                return new ArrayListSerializer(StringSerializer.INSTANCE);
                            }

                            @JvmStatic
                            public static final /* synthetic */ void write$Self$product_details_page_debug(IPFeedRecommendItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
                                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.advState != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 0, AdvStateFloor$AdvState$$serializer.INSTANCE, self.advState);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.atmosList != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.atmosList);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.brandId != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 2, LongSerializer.INSTANCE, self.brandId);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.brandName != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.brandName);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.brief != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.brief);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.cardType != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.cardType);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.coin != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.coin);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.extraInfo != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.extraInfo);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.feedTag != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 8, ShopItem$LabelGroup$$serializer.INSTANCE, self.feedTag);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 9) || self.guideIndexUrl != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.guideIndexUrl);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 10) || self.imageList != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 10, lazyArr[10].getValue(), self.imageList);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 11) || self.ipRightId != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 11, LongSerializer.INSTANCE, self.ipRightId);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 12) || self.ipRightName != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.ipRightName);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 13) || self.itemAttrs != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 13, lazyArr[13].getValue(), self.itemAttrs);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 14) || self.itemsId != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 14, LongSerializer.INSTANCE, self.itemsId);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 15) || self.itemsImg != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.itemsImg);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 16) || self.itemsLabelVO != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 16, IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$ItemsLabel$$serializer.INSTANCE, self.itemsLabelVO);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 17) || self.itemsType != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 17, ByteSerializer.INSTANCE, self.itemsType);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 18) || self.jumpLinkType != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 18, ByteSerializer.INSTANCE, self.jumpLinkType);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 19) || self.jumpUrl != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.jumpUrl);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 20) || self.jumpUrlH5 != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 20, StringSerializer.INSTANCE, self.jumpUrlH5);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 21) || self.like != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 21, IntSerializer.INSTANCE, self.like);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 22) || self.living != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 22, BooleanSerializer.INSTANCE, self.living);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 23) || self.marketingTag != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 23, StringSerializer.INSTANCE, self.marketingTag);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 24) || self.maxPreDepositPrice != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 24, StringSerializer.INSTANCE, self.maxPreDepositPrice);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 25) || self.merchantInfo != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 25, ShopItem$MerchantInfo$$serializer.INSTANCE, self.merchantInfo);
                                }
                                output.encodeStringElement(serialDesc, 26, self.name);
                                if (output.shouldEncodeElementDefault(serialDesc, 27) || self.originPrice != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 27, IntSerializer.INSTANCE, self.originPrice);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 28) || self.payType != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 28, ByteSerializer.INSTANCE, self.payType);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 29) || self.preDepositPrice != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 29, StringSerializer.INSTANCE, self.preDepositPrice);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 30) || self.preDepositVO != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 30, IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$PreDeposit$$serializer.INSTANCE, self.preDepositVO);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 31) || self.preSale != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 31, BooleanSerializer.INSTANCE, self.preSale);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 32) || self.presaleDeliveryTimeStr != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 32, StringSerializer.INSTANCE, self.presaleDeliveryTimeStr);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 33) || self.presaleStartOrderTime != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 33, IntSerializer.INSTANCE, self.presaleStartOrderTime);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 34) || self.price != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 34, StringSerializer.INSTANCE, self.price);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 35) || self.priceDesc != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 35, lazyArr[35].getValue(), self.priceDesc);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 36) || self.pricePrefix != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 36, StringSerializer.INSTANCE, self.pricePrefix);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 37) || self.priceSymbol != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 37, StringSerializer.INSTANCE, self.priceSymbol);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 38) || self.properties != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 38, StringSerializer.INSTANCE, self.properties);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 39) || self.recommendTag != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 39, StringSerializer.INSTANCE, self.recommendTag);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 40) || self.remain != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 40, IntSerializer.INSTANCE, self.remain);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 41) || self.reportParams != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 41, JsonObjectSerializer.INSTANCE, self.reportParams);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 42) || self.saleType != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 42, ByteSerializer.INSTANCE, self.saleType);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 43) || self.secondKillVO != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 43, IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SecondKillModel$$serializer.INSTANCE, self.secondKillVO);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 44) || self.selfSold != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 44, BooleanSerializer.INSTANCE, self.selfSold);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 45) || self.soldOut != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 45, StringSerializer.INSTANCE, self.soldOut);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 46) || self.specific != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 46, StringSerializer.INSTANCE, self.specific);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 47) || self.subSaleType != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 47, ByteSerializer.INSTANCE, self.subSaleType);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 48) || self.subSkuList != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 48, lazyArr[48].getValue(), self.subSkuList);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 49) || self.tag != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 49, StringSerializer.INSTANCE, self.tag);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 50) || self.tagPrefix != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 50, lazyArr[50].getValue(), self.tagPrefix);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 51) || self.tags != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 51, IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$TagsModel$$serializer.INSTANCE, self.tags);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 52) || self.templateId != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 52, IntSerializer.INSTANCE, self.templateId);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 53) || self.track_Id != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 53, StringSerializer.INSTANCE, self.track_Id);
                                }
                            }

                            public /* synthetic */ IPFeedRecommendItem(AdvStateFloor.AdvState advState, List list, Long l, String str, String str2, String str3, String str4, String str5, ShopItem.LabelGroup labelGroup, String str6, List list2, Long l2, String str7, List list3, Long l3, String str8, ItemsLabel itemsLabel, Byte b, Byte b2, String str9, String str10, Integer num, Boolean bool, String str11, String str12, ShopItem.MerchantInfo merchantInfo, String str13, Integer num2, Byte b3, String str14, PreDeposit preDeposit, Boolean bool2, String str15, Integer num3, String str16, List list4, String str17, String str18, String str19, String str20, Integer num4, JsonObject jsonObject, Byte b4, SecondKillModel secondKillModel, Boolean bool3, String str21, String str22, Byte b5, List list5, String str23, List list6, TagsModel tagsModel, Integer num5, String str24, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                                this((i & 1) != 0 ? null : advState, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : labelGroup, (i & 512) != 0 ? null : str6, (i & 1024) != 0 ? null : list2, (i & 2048) != 0 ? null : l2, (i & 4096) != 0 ? null : str7, (i & 8192) != 0 ? null : list3, (i & 16384) != 0 ? null : l3, (i & 32768) != 0 ? null : str8, (i & 65536) != 0 ? null : itemsLabel, (i & 131072) != 0 ? null : b, (i & 262144) != 0 ? null : b2, (i & 524288) != 0 ? null : str9, (i & 1048576) != 0 ? null : str10, (i & 2097152) != 0 ? null : num, (i & 4194304) != 0 ? null : bool, (i & 8388608) != 0 ? null : str11, (i & 16777216) != 0 ? null : str12, (i & 33554432) != 0 ? null : merchantInfo, str13, (i & 134217728) != 0 ? null : num2, (i & 268435456) != 0 ? null : b3, (i & 536870912) != 0 ? null : str14, (i & 1073741824) != 0 ? null : preDeposit, (i & Integer.MIN_VALUE) != 0 ? null : bool2, (i2 & 1) != 0 ? null : str15, (i2 & 2) != 0 ? null : num3, (i2 & 4) != 0 ? null : str16, (i2 & 8) != 0 ? null : list4, (i2 & 16) != 0 ? null : str17, (i2 & 32) != 0 ? null : str18, (i2 & 64) != 0 ? null : str19, (i2 & 128) != 0 ? null : str20, (i2 & 256) != 0 ? null : num4, (i2 & 512) != 0 ? null : jsonObject, (i2 & 1024) != 0 ? null : b4, (i2 & 2048) != 0 ? null : secondKillModel, (i2 & 4096) != 0 ? null : bool3, (i2 & 8192) != 0 ? null : str21, (i2 & 16384) != 0 ? null : str22, (32768 & i2) != 0 ? null : b5, (65536 & i2) != 0 ? null : list5, (i2 & 131072) != 0 ? null : str23, (i2 & 262144) != 0 ? null : list6, (i2 & 524288) != 0 ? null : tagsModel, (i2 & 1048576) != 0 ? null : num5, (i2 & 2097152) != 0 ? null : str24);
                            }

                            public final AdvStateFloor.AdvState getAdvState() {
                                return this.advState;
                            }

                            public final List<ActivityInfoFloor.AtmosInfo> getAtmosList() {
                                return this.atmosList;
                            }

                            public final Long getBrandId() {
                                return this.brandId;
                            }

                            public final String getBrandName() {
                                return this.brandName;
                            }

                            public final String getBrief() {
                                return this.brief;
                            }

                            public final String getCardType() {
                                return this.cardType;
                            }

                            public final String getCoin() {
                                return this.coin;
                            }

                            public final String getExtraInfo() {
                                return this.extraInfo;
                            }

                            public final ShopItem.LabelGroup getFeedTag() {
                                return this.feedTag;
                            }

                            public final String getGuideIndexUrl() {
                                return this.guideIndexUrl;
                            }

                            public final List<String> getImageList() {
                                return this.imageList;
                            }

                            public final Long getIpRightId() {
                                return this.ipRightId;
                            }

                            public final String getIpRightName() {
                                return this.ipRightName;
                            }

                            public final List<String> getItemAttrs() {
                                return this.itemAttrs;
                            }

                            public final Long getItemsId() {
                                return this.itemsId;
                            }

                            public final String getItemsImg() {
                                return this.itemsImg;
                            }

                            public final ItemsLabel getItemsLabelVO() {
                                return this.itemsLabelVO;
                            }

                            public final Byte getItemsType() {
                                return this.itemsType;
                            }

                            public final Byte getJumpLinkType() {
                                return this.jumpLinkType;
                            }

                            public final String getJumpUrl() {
                                return this.jumpUrl;
                            }

                            public final String getJumpUrlH5() {
                                return this.jumpUrlH5;
                            }

                            public final Integer getLike() {
                                return this.like;
                            }

                            public final Boolean getLiving() {
                                return this.living;
                            }

                            public final String getMarketingTag() {
                                return this.marketingTag;
                            }

                            public final String getMaxPreDepositPrice() {
                                return this.maxPreDepositPrice;
                            }

                            public final ShopItem.MerchantInfo getMerchantInfo() {
                                return this.merchantInfo;
                            }

                            public final String getName() {
                                return this.name;
                            }

                            public final Integer getOriginPrice() {
                                return this.originPrice;
                            }

                            public final Byte getPayType() {
                                return this.payType;
                            }

                            public final String getPreDepositPrice() {
                                return this.preDepositPrice;
                            }

                            public final PreDeposit getPreDepositVO() {
                                return this.preDepositVO;
                            }

                            public final Boolean getPreSale() {
                                return this.preSale;
                            }

                            public final String getPresaleDeliveryTimeStr() {
                                return this.presaleDeliveryTimeStr;
                            }

                            public final Integer getPresaleStartOrderTime() {
                                return this.presaleStartOrderTime;
                            }

                            public final String getPrice() {
                                return this.price;
                            }

                            public final List<String> getPriceDesc() {
                                return this.priceDesc;
                            }

                            public final String getPricePrefix() {
                                return this.pricePrefix;
                            }

                            public final String getPriceSymbol() {
                                return this.priceSymbol;
                            }

                            public final String getProperties() {
                                return this.properties;
                            }

                            public final String getRecommendTag() {
                                return this.recommendTag;
                            }

                            public final Integer getRemain() {
                                return this.remain;
                            }

                            public final JsonObject getReportParams() {
                                return this.reportParams;
                            }

                            public final Byte getSaleType() {
                                return this.saleType;
                            }

                            public final SecondKillModel getSecondKillVO() {
                                return this.secondKillVO;
                            }

                            public final Boolean getSelfSold() {
                                return this.selfSold;
                            }

                            public final String getSoldOut() {
                                return this.soldOut;
                            }

                            public final String getSpecific() {
                                return this.specific;
                            }

                            public final Byte getSubSaleType() {
                                return this.subSaleType;
                            }

                            public final List<SubSkuModel> getSubSkuList() {
                                return this.subSkuList;
                            }

                            public final String getTag() {
                                return this.tag;
                            }

                            public final List<String> getTagPrefix() {
                                return this.tagPrefix;
                            }

                            public final TagsModel getTags() {
                                return this.tags;
                            }

                            public final Integer getTemplateId() {
                                return this.templateId;
                            }

                            /* compiled from: IPFeedRecommendApiService.kt */
                            @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bBi\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003Jc\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\rHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014¨\u0006/"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$ItemsLabel;", "", "itemsLabel", "", "itemsTagNames", "", "marketingLabel", "marketingTagNames", "recommendLabel", "recommendTagNames", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getItemsLabel", "()Ljava/lang/String;", "getItemsTagNames", "()Ljava/util/List;", "getMarketingLabel", "getMarketingTagNames", "getRecommendLabel", "getRecommendTagNames", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                            @Serializable
                            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                            public static final class ItemsLabel {
                                private final String itemsLabel;
                                private final List<String> itemsTagNames;
                                private final String marketingLabel;
                                private final List<String> marketingTagNames;
                                private final String recommendLabel;
                                private final List<String> recommendTagNames;
                                public static final Companion Companion = new Companion(null);
                                public static final int $stable = 8;
                                private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$ItemsLabel$$ExternalSyntheticLambda0
                                    public final Object invoke() {
                                        KSerializer _childSerializers$_anonymous_;
                                        _childSerializers$_anonymous_ = IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.ItemsLabel._childSerializers$_anonymous_();
                                        return _childSerializers$_anonymous_;
                                    }
                                }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$ItemsLabel$$ExternalSyntheticLambda1
                                    public final Object invoke() {
                                        KSerializer _childSerializers$_anonymous_$0;
                                        _childSerializers$_anonymous_$0 = IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.ItemsLabel._childSerializers$_anonymous_$0();
                                        return _childSerializers$_anonymous_$0;
                                    }
                                }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$ItemsLabel$$ExternalSyntheticLambda2
                                    public final Object invoke() {
                                        KSerializer _childSerializers$_anonymous_$1;
                                        _childSerializers$_anonymous_$1 = IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.ItemsLabel._childSerializers$_anonymous_$1();
                                        return _childSerializers$_anonymous_$1;
                                    }
                                })};

                                public ItemsLabel() {
                                    this((String) null, (List) null, (String) null, (List) null, (String) null, (List) null, 63, (DefaultConstructorMarker) null);
                                }

                                public static /* synthetic */ ItemsLabel copy$default(ItemsLabel itemsLabel, String str, List list, String str2, List list2, String str3, List list3, int i, Object obj) {
                                    if ((i & 1) != 0) {
                                        str = itemsLabel.itemsLabel;
                                    }
                                    List<String> list4 = list;
                                    if ((i & 2) != 0) {
                                        list4 = itemsLabel.itemsTagNames;
                                    }
                                    List list5 = list4;
                                    if ((i & 4) != 0) {
                                        str2 = itemsLabel.marketingLabel;
                                    }
                                    String str4 = str2;
                                    List<String> list6 = list2;
                                    if ((i & 8) != 0) {
                                        list6 = itemsLabel.marketingTagNames;
                                    }
                                    List list7 = list6;
                                    if ((i & 16) != 0) {
                                        str3 = itemsLabel.recommendLabel;
                                    }
                                    String str5 = str3;
                                    List<String> list8 = list3;
                                    if ((i & 32) != 0) {
                                        list8 = itemsLabel.recommendTagNames;
                                    }
                                    return itemsLabel.copy(str, list5, str4, list7, str5, list8);
                                }

                                public final String component1() {
                                    return this.itemsLabel;
                                }

                                public final List<String> component2() {
                                    return this.itemsTagNames;
                                }

                                public final String component3() {
                                    return this.marketingLabel;
                                }

                                public final List<String> component4() {
                                    return this.marketingTagNames;
                                }

                                public final String component5() {
                                    return this.recommendLabel;
                                }

                                public final List<String> component6() {
                                    return this.recommendTagNames;
                                }

                                public final ItemsLabel copy(String str, List<String> list, String str2, List<String> list2, String str3, List<String> list3) {
                                    return new ItemsLabel(str, list, str2, list2, str3, list3);
                                }

                                public boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj instanceof ItemsLabel) {
                                        ItemsLabel itemsLabel = (ItemsLabel) obj;
                                        return Intrinsics.areEqual(this.itemsLabel, itemsLabel.itemsLabel) && Intrinsics.areEqual(this.itemsTagNames, itemsLabel.itemsTagNames) && Intrinsics.areEqual(this.marketingLabel, itemsLabel.marketingLabel) && Intrinsics.areEqual(this.marketingTagNames, itemsLabel.marketingTagNames) && Intrinsics.areEqual(this.recommendLabel, itemsLabel.recommendLabel) && Intrinsics.areEqual(this.recommendTagNames, itemsLabel.recommendTagNames);
                                    }
                                    return false;
                                }

                                public int hashCode() {
                                    return ((((((((((this.itemsLabel == null ? 0 : this.itemsLabel.hashCode()) * 31) + (this.itemsTagNames == null ? 0 : this.itemsTagNames.hashCode())) * 31) + (this.marketingLabel == null ? 0 : this.marketingLabel.hashCode())) * 31) + (this.marketingTagNames == null ? 0 : this.marketingTagNames.hashCode())) * 31) + (this.recommendLabel == null ? 0 : this.recommendLabel.hashCode())) * 31) + (this.recommendTagNames != null ? this.recommendTagNames.hashCode() : 0);
                                }

                                public String toString() {
                                    String str = this.itemsLabel;
                                    List<String> list = this.itemsTagNames;
                                    String str2 = this.marketingLabel;
                                    List<String> list2 = this.marketingTagNames;
                                    String str3 = this.recommendLabel;
                                    return "ItemsLabel(itemsLabel=" + str + ", itemsTagNames=" + list + ", marketingLabel=" + str2 + ", marketingTagNames=" + list2 + ", recommendLabel=" + str3 + ", recommendTagNames=" + this.recommendTagNames + ")";
                                }

                                /* compiled from: IPFeedRecommendApiService.kt */
                                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$ItemsLabel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$ItemsLabel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                                public static final class Companion {
                                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                        this();
                                    }

                                    private Companion() {
                                    }

                                    public final KSerializer<ItemsLabel> serializer() {
                                        return IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$ItemsLabel$$serializer.INSTANCE;
                                    }
                                }

                                public /* synthetic */ ItemsLabel(int seen0, String itemsLabel, List itemsTagNames, String marketingLabel, List marketingTagNames, String recommendLabel, List recommendTagNames, SerializationConstructorMarker serializationConstructorMarker) {
                                    if ((seen0 & 1) == 0) {
                                        this.itemsLabel = null;
                                    } else {
                                        this.itemsLabel = itemsLabel;
                                    }
                                    if ((seen0 & 2) == 0) {
                                        this.itemsTagNames = null;
                                    } else {
                                        this.itemsTagNames = itemsTagNames;
                                    }
                                    if ((seen0 & 4) == 0) {
                                        this.marketingLabel = null;
                                    } else {
                                        this.marketingLabel = marketingLabel;
                                    }
                                    if ((seen0 & 8) == 0) {
                                        this.marketingTagNames = null;
                                    } else {
                                        this.marketingTagNames = marketingTagNames;
                                    }
                                    if ((seen0 & 16) == 0) {
                                        this.recommendLabel = null;
                                    } else {
                                        this.recommendLabel = recommendLabel;
                                    }
                                    if ((seen0 & 32) == 0) {
                                        this.recommendTagNames = null;
                                    } else {
                                        this.recommendTagNames = recommendTagNames;
                                    }
                                }

                                public ItemsLabel(String itemsLabel, List<String> list, String marketingLabel, List<String> list2, String recommendLabel, List<String> list3) {
                                    this.itemsLabel = itemsLabel;
                                    this.itemsTagNames = list;
                                    this.marketingLabel = marketingLabel;
                                    this.marketingTagNames = list2;
                                    this.recommendLabel = recommendLabel;
                                    this.recommendTagNames = list3;
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                                    return new ArrayListSerializer(StringSerializer.INSTANCE);
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                                    return new ArrayListSerializer(StringSerializer.INSTANCE);
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
                                    return new ArrayListSerializer(StringSerializer.INSTANCE);
                                }

                                @JvmStatic
                                public static final /* synthetic */ void write$Self$product_details_page_debug(ItemsLabel self, CompositeEncoder output, SerialDescriptor serialDesc) {
                                    Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.itemsLabel != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.itemsLabel);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.itemsTagNames != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.itemsTagNames);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.marketingLabel != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.marketingLabel);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.marketingTagNames != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.marketingTagNames);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.recommendLabel != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.recommendLabel);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 5) || self.recommendTagNames != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.recommendTagNames);
                                    }
                                }

                                public /* synthetic */ ItemsLabel(String str, List list, String str2, List list2, String str3, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : list2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : list3);
                                }

                                public final String getItemsLabel() {
                                    return this.itemsLabel;
                                }

                                public final List<String> getItemsTagNames() {
                                    return this.itemsTagNames;
                                }

                                public final String getMarketingLabel() {
                                    return this.marketingLabel;
                                }

                                public final List<String> getMarketingTagNames() {
                                    return this.marketingTagNames;
                                }

                                public final String getRecommendLabel() {
                                    return this.recommendLabel;
                                }

                                public final List<String> getRecommendTagNames() {
                                    return this.recommendTagNames;
                                }
                            }

                            public final String getTrack_Id() {
                                return this.track_Id;
                            }

                            /* compiled from: IPFeedRecommendApiService.kt */
                            @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006$"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$PreDeposit;", "", "maxPreDepositPrice", "", "preDepositPrice", "price", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMaxPreDepositPrice", "()Ljava/lang/String;", "getPreDepositPrice", "getPrice", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                            @Serializable
                            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                            public static final class PreDeposit {
                                public static final int $stable = 0;
                                public static final Companion Companion = new Companion(null);
                                private final String maxPreDepositPrice;
                                private final String preDepositPrice;
                                private final String price;

                                public PreDeposit() {
                                    this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
                                }

                                public static /* synthetic */ PreDeposit copy$default(PreDeposit preDeposit, String str, String str2, String str3, int i, Object obj) {
                                    if ((i & 1) != 0) {
                                        str = preDeposit.maxPreDepositPrice;
                                    }
                                    if ((i & 2) != 0) {
                                        str2 = preDeposit.preDepositPrice;
                                    }
                                    if ((i & 4) != 0) {
                                        str3 = preDeposit.price;
                                    }
                                    return preDeposit.copy(str, str2, str3);
                                }

                                public final String component1() {
                                    return this.maxPreDepositPrice;
                                }

                                public final String component2() {
                                    return this.preDepositPrice;
                                }

                                public final String component3() {
                                    return this.price;
                                }

                                public final PreDeposit copy(String str, String str2, String str3) {
                                    return new PreDeposit(str, str2, str3);
                                }

                                public boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj instanceof PreDeposit) {
                                        PreDeposit preDeposit = (PreDeposit) obj;
                                        return Intrinsics.areEqual(this.maxPreDepositPrice, preDeposit.maxPreDepositPrice) && Intrinsics.areEqual(this.preDepositPrice, preDeposit.preDepositPrice) && Intrinsics.areEqual(this.price, preDeposit.price);
                                    }
                                    return false;
                                }

                                public int hashCode() {
                                    return ((((this.maxPreDepositPrice == null ? 0 : this.maxPreDepositPrice.hashCode()) * 31) + (this.preDepositPrice == null ? 0 : this.preDepositPrice.hashCode())) * 31) + (this.price != null ? this.price.hashCode() : 0);
                                }

                                public String toString() {
                                    String str = this.maxPreDepositPrice;
                                    String str2 = this.preDepositPrice;
                                    return "PreDeposit(maxPreDepositPrice=" + str + ", preDepositPrice=" + str2 + ", price=" + this.price + ")";
                                }

                                /* compiled from: IPFeedRecommendApiService.kt */
                                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$PreDeposit$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$PreDeposit;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                                public static final class Companion {
                                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                        this();
                                    }

                                    private Companion() {
                                    }

                                    public final KSerializer<PreDeposit> serializer() {
                                        return IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$PreDeposit$$serializer.INSTANCE;
                                    }
                                }

                                public /* synthetic */ PreDeposit(int seen0, String maxPreDepositPrice, String preDepositPrice, String price, SerializationConstructorMarker serializationConstructorMarker) {
                                    if ((seen0 & 1) == 0) {
                                        this.maxPreDepositPrice = null;
                                    } else {
                                        this.maxPreDepositPrice = maxPreDepositPrice;
                                    }
                                    if ((seen0 & 2) == 0) {
                                        this.preDepositPrice = null;
                                    } else {
                                        this.preDepositPrice = preDepositPrice;
                                    }
                                    if ((seen0 & 4) == 0) {
                                        this.price = null;
                                    } else {
                                        this.price = price;
                                    }
                                }

                                public PreDeposit(String maxPreDepositPrice, String preDepositPrice, String price) {
                                    this.maxPreDepositPrice = maxPreDepositPrice;
                                    this.preDepositPrice = preDepositPrice;
                                    this.price = price;
                                }

                                @JvmStatic
                                public static final /* synthetic */ void write$Self$product_details_page_debug(PreDeposit self, CompositeEncoder output, SerialDescriptor serialDesc) {
                                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.maxPreDepositPrice != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.maxPreDepositPrice);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.preDepositPrice != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.preDepositPrice);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.price != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.price);
                                    }
                                }

                                public /* synthetic */ PreDeposit(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
                                }

                                public final String getMaxPreDepositPrice() {
                                    return this.maxPreDepositPrice;
                                }

                                public final String getPreDepositPrice() {
                                    return this.preDepositPrice;
                                }

                                public final String getPrice() {
                                    return this.price;
                                }
                            }

                            /* compiled from: IPFeedRecommendApiService.kt */
                            @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 I2\u00020\u0001:\u0002HIB\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0012\u0010\u0013B\u0093\u0001\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0012\u0010\u0018J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00102\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010#J\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00104\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00106\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010#J\u0010\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u009e\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020\r2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u0015HÖ\u0001J\t\u0010>\u001a\u00020?HÖ\u0001J%\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00002\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0001¢\u0006\u0002\bGR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u001aR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b%\u0010\u001aR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b)\u0010\u001aR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010$\u001a\u0004\b*\u0010#R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010 \u001a\u0004\b+\u0010\u001fR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010 \u001a\u0004\b,\u0010\u001f¨\u0006J"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SecondKillModel;", "", "advanceCountdownTime", "", "endTime", "itemsId", "lowerDiscountDepositPrice", "", "lowerDiscountPrice", "process", "", "serverTime", "soldOut", "", "startTime", "type", "upperDiscountDepositPrice", "upperDiscountPrice", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Byte;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Byte;Ljava/lang/Double;Ljava/lang/Double;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Byte;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Byte;Ljava/lang/Double;Ljava/lang/Double;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAdvanceCountdownTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndTime", "getItemsId", "getLowerDiscountDepositPrice", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLowerDiscountPrice", "getProcess", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getServerTime", "getSoldOut", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStartTime", "getType", "getUpperDiscountDepositPrice", "getUpperDiscountPrice", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Byte;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Byte;Ljava/lang/Double;Ljava/lang/Double;)Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SecondKillModel;", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                            @Serializable
                            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                            public static final class SecondKillModel {
                                public static final int $stable = 0;
                                public static final Companion Companion = new Companion(null);
                                private final Long advanceCountdownTime;
                                private final Long endTime;
                                private final Long itemsId;
                                private final Double lowerDiscountDepositPrice;
                                private final Double lowerDiscountPrice;
                                private final Byte process;
                                private final Long serverTime;
                                private final Boolean soldOut;
                                private final Long startTime;
                                private final Byte type;
                                private final Double upperDiscountDepositPrice;
                                private final Double upperDiscountPrice;

                                public SecondKillModel() {
                                    this((Long) null, (Long) null, (Long) null, (Double) null, (Double) null, (Byte) null, (Long) null, (Boolean) null, (Long) null, (Byte) null, (Double) null, (Double) null, 4095, (DefaultConstructorMarker) null);
                                }

                                public final Long component1() {
                                    return this.advanceCountdownTime;
                                }

                                public final Byte component10() {
                                    return this.type;
                                }

                                public final Double component11() {
                                    return this.upperDiscountDepositPrice;
                                }

                                public final Double component12() {
                                    return this.upperDiscountPrice;
                                }

                                public final Long component2() {
                                    return this.endTime;
                                }

                                public final Long component3() {
                                    return this.itemsId;
                                }

                                public final Double component4() {
                                    return this.lowerDiscountDepositPrice;
                                }

                                public final Double component5() {
                                    return this.lowerDiscountPrice;
                                }

                                public final Byte component6() {
                                    return this.process;
                                }

                                public final Long component7() {
                                    return this.serverTime;
                                }

                                public final Boolean component8() {
                                    return this.soldOut;
                                }

                                public final Long component9() {
                                    return this.startTime;
                                }

                                public final SecondKillModel copy(Long l, Long l2, Long l3, Double d, Double d2, Byte b, Long l4, Boolean bool, Long l5, Byte b2, Double d3, Double d4) {
                                    return new SecondKillModel(l, l2, l3, d, d2, b, l4, bool, l5, b2, d3, d4);
                                }

                                public boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj instanceof SecondKillModel) {
                                        SecondKillModel secondKillModel = (SecondKillModel) obj;
                                        return Intrinsics.areEqual(this.advanceCountdownTime, secondKillModel.advanceCountdownTime) && Intrinsics.areEqual(this.endTime, secondKillModel.endTime) && Intrinsics.areEqual(this.itemsId, secondKillModel.itemsId) && Intrinsics.areEqual(this.lowerDiscountDepositPrice, secondKillModel.lowerDiscountDepositPrice) && Intrinsics.areEqual(this.lowerDiscountPrice, secondKillModel.lowerDiscountPrice) && Intrinsics.areEqual(this.process, secondKillModel.process) && Intrinsics.areEqual(this.serverTime, secondKillModel.serverTime) && Intrinsics.areEqual(this.soldOut, secondKillModel.soldOut) && Intrinsics.areEqual(this.startTime, secondKillModel.startTime) && Intrinsics.areEqual(this.type, secondKillModel.type) && Intrinsics.areEqual(this.upperDiscountDepositPrice, secondKillModel.upperDiscountDepositPrice) && Intrinsics.areEqual(this.upperDiscountPrice, secondKillModel.upperDiscountPrice);
                                    }
                                    return false;
                                }

                                public int hashCode() {
                                    return ((((((((((((((((((((((this.advanceCountdownTime == null ? 0 : this.advanceCountdownTime.hashCode()) * 31) + (this.endTime == null ? 0 : this.endTime.hashCode())) * 31) + (this.itemsId == null ? 0 : this.itemsId.hashCode())) * 31) + (this.lowerDiscountDepositPrice == null ? 0 : this.lowerDiscountDepositPrice.hashCode())) * 31) + (this.lowerDiscountPrice == null ? 0 : this.lowerDiscountPrice.hashCode())) * 31) + (this.process == null ? 0 : this.process.hashCode())) * 31) + (this.serverTime == null ? 0 : this.serverTime.hashCode())) * 31) + (this.soldOut == null ? 0 : this.soldOut.hashCode())) * 31) + (this.startTime == null ? 0 : this.startTime.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.upperDiscountDepositPrice == null ? 0 : this.upperDiscountDepositPrice.hashCode())) * 31) + (this.upperDiscountPrice != null ? this.upperDiscountPrice.hashCode() : 0);
                                }

                                public String toString() {
                                    Long l = this.advanceCountdownTime;
                                    Long l2 = this.endTime;
                                    Long l3 = this.itemsId;
                                    Double d = this.lowerDiscountDepositPrice;
                                    Double d2 = this.lowerDiscountPrice;
                                    Byte b = this.process;
                                    Long l4 = this.serverTime;
                                    Boolean bool = this.soldOut;
                                    Long l5 = this.startTime;
                                    Byte b2 = this.type;
                                    Double d3 = this.upperDiscountDepositPrice;
                                    return "SecondKillModel(advanceCountdownTime=" + l + ", endTime=" + l2 + ", itemsId=" + l3 + ", lowerDiscountDepositPrice=" + d + ", lowerDiscountPrice=" + d2 + ", process=" + b + ", serverTime=" + l4 + ", soldOut=" + bool + ", startTime=" + l5 + ", type=" + b2 + ", upperDiscountDepositPrice=" + d3 + ", upperDiscountPrice=" + this.upperDiscountPrice + ")";
                                }

                                /* compiled from: IPFeedRecommendApiService.kt */
                                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SecondKillModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SecondKillModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                                public static final class Companion {
                                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                        this();
                                    }

                                    private Companion() {
                                    }

                                    public final KSerializer<SecondKillModel> serializer() {
                                        return IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SecondKillModel$$serializer.INSTANCE;
                                    }
                                }

                                public /* synthetic */ SecondKillModel(int seen0, Long advanceCountdownTime, Long endTime, Long itemsId, Double lowerDiscountDepositPrice, Double lowerDiscountPrice, Byte process, Long serverTime, Boolean soldOut, Long startTime, Byte type, Double upperDiscountDepositPrice, Double upperDiscountPrice, SerializationConstructorMarker serializationConstructorMarker) {
                                    if ((seen0 & 1) == 0) {
                                        this.advanceCountdownTime = null;
                                    } else {
                                        this.advanceCountdownTime = advanceCountdownTime;
                                    }
                                    if ((seen0 & 2) == 0) {
                                        this.endTime = null;
                                    } else {
                                        this.endTime = endTime;
                                    }
                                    if ((seen0 & 4) == 0) {
                                        this.itemsId = null;
                                    } else {
                                        this.itemsId = itemsId;
                                    }
                                    if ((seen0 & 8) == 0) {
                                        this.lowerDiscountDepositPrice = null;
                                    } else {
                                        this.lowerDiscountDepositPrice = lowerDiscountDepositPrice;
                                    }
                                    if ((seen0 & 16) == 0) {
                                        this.lowerDiscountPrice = null;
                                    } else {
                                        this.lowerDiscountPrice = lowerDiscountPrice;
                                    }
                                    if ((seen0 & 32) == 0) {
                                        this.process = null;
                                    } else {
                                        this.process = process;
                                    }
                                    if ((seen0 & 64) == 0) {
                                        this.serverTime = null;
                                    } else {
                                        this.serverTime = serverTime;
                                    }
                                    if ((seen0 & 128) == 0) {
                                        this.soldOut = null;
                                    } else {
                                        this.soldOut = soldOut;
                                    }
                                    if ((seen0 & 256) == 0) {
                                        this.startTime = null;
                                    } else {
                                        this.startTime = startTime;
                                    }
                                    if ((seen0 & 512) == 0) {
                                        this.type = null;
                                    } else {
                                        this.type = type;
                                    }
                                    if ((seen0 & 1024) == 0) {
                                        this.upperDiscountDepositPrice = null;
                                    } else {
                                        this.upperDiscountDepositPrice = upperDiscountDepositPrice;
                                    }
                                    if ((seen0 & 2048) == 0) {
                                        this.upperDiscountPrice = null;
                                    } else {
                                        this.upperDiscountPrice = upperDiscountPrice;
                                    }
                                }

                                public SecondKillModel(Long advanceCountdownTime, Long endTime, Long itemsId, Double lowerDiscountDepositPrice, Double lowerDiscountPrice, Byte process, Long serverTime, Boolean soldOut, Long startTime, Byte type, Double upperDiscountDepositPrice, Double upperDiscountPrice) {
                                    this.advanceCountdownTime = advanceCountdownTime;
                                    this.endTime = endTime;
                                    this.itemsId = itemsId;
                                    this.lowerDiscountDepositPrice = lowerDiscountDepositPrice;
                                    this.lowerDiscountPrice = lowerDiscountPrice;
                                    this.process = process;
                                    this.serverTime = serverTime;
                                    this.soldOut = soldOut;
                                    this.startTime = startTime;
                                    this.type = type;
                                    this.upperDiscountDepositPrice = upperDiscountDepositPrice;
                                    this.upperDiscountPrice = upperDiscountPrice;
                                }

                                @JvmStatic
                                public static final /* synthetic */ void write$Self$product_details_page_debug(SecondKillModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
                                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.advanceCountdownTime != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.advanceCountdownTime);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.endTime != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.endTime);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.itemsId != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 2, LongSerializer.INSTANCE, self.itemsId);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.lowerDiscountDepositPrice != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 3, DoubleSerializer.INSTANCE, self.lowerDiscountDepositPrice);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.lowerDiscountPrice != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 4, DoubleSerializer.INSTANCE, self.lowerDiscountPrice);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 5) || self.process != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 5, ByteSerializer.INSTANCE, self.process);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 6) || self.serverTime != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 6, LongSerializer.INSTANCE, self.serverTime);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 7) || self.soldOut != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 7, BooleanSerializer.INSTANCE, self.soldOut);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 8) || self.startTime != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 8, LongSerializer.INSTANCE, self.startTime);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 9) || self.type != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 9, ByteSerializer.INSTANCE, self.type);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 10) || self.upperDiscountDepositPrice != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 10, DoubleSerializer.INSTANCE, self.upperDiscountDepositPrice);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 11) || self.upperDiscountPrice != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 11, DoubleSerializer.INSTANCE, self.upperDiscountPrice);
                                    }
                                }

                                public /* synthetic */ SecondKillModel(Long l, Long l2, Long l3, Double d, Double d2, Byte b, Long l4, Boolean bool, Long l5, Byte b2, Double d3, Double d4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                                    this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) != 0 ? null : l3, (i & 8) != 0 ? null : d, (i & 16) != 0 ? null : d2, (i & 32) != 0 ? null : b, (i & 64) != 0 ? null : l4, (i & 128) != 0 ? null : bool, (i & 256) != 0 ? null : l5, (i & 512) != 0 ? null : b2, (i & 1024) != 0 ? null : d3, (i & 2048) == 0 ? d4 : null);
                                }

                                public final Long getAdvanceCountdownTime() {
                                    return this.advanceCountdownTime;
                                }

                                public final Long getEndTime() {
                                    return this.endTime;
                                }

                                public final Long getItemsId() {
                                    return this.itemsId;
                                }

                                public final Double getLowerDiscountDepositPrice() {
                                    return this.lowerDiscountDepositPrice;
                                }

                                public final Double getLowerDiscountPrice() {
                                    return this.lowerDiscountPrice;
                                }

                                public final Byte getProcess() {
                                    return this.process;
                                }

                                public final Long getServerTime() {
                                    return this.serverTime;
                                }

                                public final Boolean getSoldOut() {
                                    return this.soldOut;
                                }

                                public final Long getStartTime() {
                                    return this.startTime;
                                }

                                public final Byte getType() {
                                    return this.type;
                                }

                                public final Double getUpperDiscountDepositPrice() {
                                    return this.upperDiscountDepositPrice;
                                }

                                public final Double getUpperDiscountPrice() {
                                    return this.upperDiscountPrice;
                                }
                            }

                            /* compiled from: IPFeedRecommendApiService.kt */
                            @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 R2\u00020\u0001:\u0002QRB»\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017B±\u0001\b\u0010\u0012\u0006\u0010\u0018\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0016\u0010\u001bJ\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010<\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010=\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010B\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u00101JÂ\u0001\u0010C\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020\u00142\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020\nHÖ\u0001J\t\u0010H\u001a\u00020\u0003HÖ\u0001J%\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020OH\u0001¢\u0006\u0002\bPR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0015\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010&\u001a\u0004\b(\u0010%R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010+\u001a\u0004\b,\u0010*R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010&\u001a\u0004\b.\u0010%R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u00102\u001a\u0004\b3\u00101¨\u0006S"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SubSkuModel;", "", "imageUrl", "", "itemsType", "", "name", "overseasPreShippingTime", "presaleDeliveryTimeStr", "saleStatus", "", "skuSpec", "sliceNum", "subSkuId", "", "subSkuItemsId", "subSkuPrice", "type", "url", "whiteListSku", "", "wishedSku", "<init>", "(Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImageUrl", "()Ljava/lang/String;", "getItemsType", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getName", "getOverseasPreShippingTime", "getPresaleDeliveryTimeStr", "getSaleStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSkuSpec", "getSliceNum", "getSubSkuId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSubSkuItemsId", "getSubSkuPrice", "getType", "getUrl", "getWhiteListSku", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getWishedSku", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SubSkuModel;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                            @Serializable
                            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                            public static final class SubSkuModel {
                                public static final int $stable = 0;
                                public static final Companion Companion = new Companion(null);
                                private final String imageUrl;
                                private final Byte itemsType;
                                private final String name;
                                private final String overseasPreShippingTime;
                                private final String presaleDeliveryTimeStr;
                                private final Integer saleStatus;
                                private final String skuSpec;
                                private final Integer sliceNum;
                                private final Long subSkuId;
                                private final Long subSkuItemsId;
                                private final String subSkuPrice;
                                private final Integer type;
                                private final String url;
                                private final Boolean whiteListSku;
                                private final Boolean wishedSku;

                                public SubSkuModel() {
                                    this((String) null, (Byte) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, (Long) null, (Long) null, (String) null, (Integer) null, (String) null, (Boolean) null, (Boolean) null, 32767, (DefaultConstructorMarker) null);
                                }

                                public final String component1() {
                                    return this.imageUrl;
                                }

                                public final Long component10() {
                                    return this.subSkuItemsId;
                                }

                                public final String component11() {
                                    return this.subSkuPrice;
                                }

                                public final Integer component12() {
                                    return this.type;
                                }

                                public final String component13() {
                                    return this.url;
                                }

                                public final Boolean component14() {
                                    return this.whiteListSku;
                                }

                                public final Boolean component15() {
                                    return this.wishedSku;
                                }

                                public final Byte component2() {
                                    return this.itemsType;
                                }

                                public final String component3() {
                                    return this.name;
                                }

                                public final String component4() {
                                    return this.overseasPreShippingTime;
                                }

                                public final String component5() {
                                    return this.presaleDeliveryTimeStr;
                                }

                                public final Integer component6() {
                                    return this.saleStatus;
                                }

                                public final String component7() {
                                    return this.skuSpec;
                                }

                                public final Integer component8() {
                                    return this.sliceNum;
                                }

                                public final Long component9() {
                                    return this.subSkuId;
                                }

                                public final SubSkuModel copy(String str, Byte b, String str2, String str3, String str4, Integer num, String str5, Integer num2, Long l, Long l2, String str6, Integer num3, String str7, Boolean bool, Boolean bool2) {
                                    return new SubSkuModel(str, b, str2, str3, str4, num, str5, num2, l, l2, str6, num3, str7, bool, bool2);
                                }

                                public boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj instanceof SubSkuModel) {
                                        SubSkuModel subSkuModel = (SubSkuModel) obj;
                                        return Intrinsics.areEqual(this.imageUrl, subSkuModel.imageUrl) && Intrinsics.areEqual(this.itemsType, subSkuModel.itemsType) && Intrinsics.areEqual(this.name, subSkuModel.name) && Intrinsics.areEqual(this.overseasPreShippingTime, subSkuModel.overseasPreShippingTime) && Intrinsics.areEqual(this.presaleDeliveryTimeStr, subSkuModel.presaleDeliveryTimeStr) && Intrinsics.areEqual(this.saleStatus, subSkuModel.saleStatus) && Intrinsics.areEqual(this.skuSpec, subSkuModel.skuSpec) && Intrinsics.areEqual(this.sliceNum, subSkuModel.sliceNum) && Intrinsics.areEqual(this.subSkuId, subSkuModel.subSkuId) && Intrinsics.areEqual(this.subSkuItemsId, subSkuModel.subSkuItemsId) && Intrinsics.areEqual(this.subSkuPrice, subSkuModel.subSkuPrice) && Intrinsics.areEqual(this.type, subSkuModel.type) && Intrinsics.areEqual(this.url, subSkuModel.url) && Intrinsics.areEqual(this.whiteListSku, subSkuModel.whiteListSku) && Intrinsics.areEqual(this.wishedSku, subSkuModel.wishedSku);
                                    }
                                    return false;
                                }

                                public int hashCode() {
                                    return ((((((((((((((((((((((((((((this.imageUrl == null ? 0 : this.imageUrl.hashCode()) * 31) + (this.itemsType == null ? 0 : this.itemsType.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.overseasPreShippingTime == null ? 0 : this.overseasPreShippingTime.hashCode())) * 31) + (this.presaleDeliveryTimeStr == null ? 0 : this.presaleDeliveryTimeStr.hashCode())) * 31) + (this.saleStatus == null ? 0 : this.saleStatus.hashCode())) * 31) + (this.skuSpec == null ? 0 : this.skuSpec.hashCode())) * 31) + (this.sliceNum == null ? 0 : this.sliceNum.hashCode())) * 31) + (this.subSkuId == null ? 0 : this.subSkuId.hashCode())) * 31) + (this.subSkuItemsId == null ? 0 : this.subSkuItemsId.hashCode())) * 31) + (this.subSkuPrice == null ? 0 : this.subSkuPrice.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.whiteListSku == null ? 0 : this.whiteListSku.hashCode())) * 31) + (this.wishedSku != null ? this.wishedSku.hashCode() : 0);
                                }

                                public String toString() {
                                    String str = this.imageUrl;
                                    Byte b = this.itemsType;
                                    String str2 = this.name;
                                    String str3 = this.overseasPreShippingTime;
                                    String str4 = this.presaleDeliveryTimeStr;
                                    Integer num = this.saleStatus;
                                    String str5 = this.skuSpec;
                                    Integer num2 = this.sliceNum;
                                    Long l = this.subSkuId;
                                    Long l2 = this.subSkuItemsId;
                                    String str6 = this.subSkuPrice;
                                    Integer num3 = this.type;
                                    String str7 = this.url;
                                    Boolean bool = this.whiteListSku;
                                    return "SubSkuModel(imageUrl=" + str + ", itemsType=" + b + ", name=" + str2 + ", overseasPreShippingTime=" + str3 + ", presaleDeliveryTimeStr=" + str4 + ", saleStatus=" + num + ", skuSpec=" + str5 + ", sliceNum=" + num2 + ", subSkuId=" + l + ", subSkuItemsId=" + l2 + ", subSkuPrice=" + str6 + ", type=" + num3 + ", url=" + str7 + ", whiteListSku=" + bool + ", wishedSku=" + this.wishedSku + ")";
                                }

                                /* compiled from: IPFeedRecommendApiService.kt */
                                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SubSkuModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SubSkuModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                                public static final class Companion {
                                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                        this();
                                    }

                                    private Companion() {
                                    }

                                    public final KSerializer<SubSkuModel> serializer() {
                                        return IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SubSkuModel$$serializer.INSTANCE;
                                    }
                                }

                                public /* synthetic */ SubSkuModel(int seen0, String imageUrl, Byte itemsType, String name, String overseasPreShippingTime, String presaleDeliveryTimeStr, Integer saleStatus, String skuSpec, Integer sliceNum, Long subSkuId, Long subSkuItemsId, String subSkuPrice, Integer type, String url, Boolean whiteListSku, Boolean wishedSku, SerializationConstructorMarker serializationConstructorMarker) {
                                    if ((seen0 & 1) == 0) {
                                        this.imageUrl = null;
                                    } else {
                                        this.imageUrl = imageUrl;
                                    }
                                    if ((seen0 & 2) == 0) {
                                        this.itemsType = null;
                                    } else {
                                        this.itemsType = itemsType;
                                    }
                                    if ((seen0 & 4) == 0) {
                                        this.name = null;
                                    } else {
                                        this.name = name;
                                    }
                                    if ((seen0 & 8) == 0) {
                                        this.overseasPreShippingTime = null;
                                    } else {
                                        this.overseasPreShippingTime = overseasPreShippingTime;
                                    }
                                    if ((seen0 & 16) == 0) {
                                        this.presaleDeliveryTimeStr = null;
                                    } else {
                                        this.presaleDeliveryTimeStr = presaleDeliveryTimeStr;
                                    }
                                    if ((seen0 & 32) == 0) {
                                        this.saleStatus = null;
                                    } else {
                                        this.saleStatus = saleStatus;
                                    }
                                    if ((seen0 & 64) == 0) {
                                        this.skuSpec = null;
                                    } else {
                                        this.skuSpec = skuSpec;
                                    }
                                    if ((seen0 & 128) == 0) {
                                        this.sliceNum = null;
                                    } else {
                                        this.sliceNum = sliceNum;
                                    }
                                    if ((seen0 & 256) == 0) {
                                        this.subSkuId = null;
                                    } else {
                                        this.subSkuId = subSkuId;
                                    }
                                    if ((seen0 & 512) == 0) {
                                        this.subSkuItemsId = null;
                                    } else {
                                        this.subSkuItemsId = subSkuItemsId;
                                    }
                                    if ((seen0 & 1024) == 0) {
                                        this.subSkuPrice = null;
                                    } else {
                                        this.subSkuPrice = subSkuPrice;
                                    }
                                    if ((seen0 & 2048) == 0) {
                                        this.type = null;
                                    } else {
                                        this.type = type;
                                    }
                                    if ((seen0 & 4096) == 0) {
                                        this.url = null;
                                    } else {
                                        this.url = url;
                                    }
                                    if ((seen0 & 8192) == 0) {
                                        this.whiteListSku = null;
                                    } else {
                                        this.whiteListSku = whiteListSku;
                                    }
                                    if ((seen0 & 16384) == 0) {
                                        this.wishedSku = null;
                                    } else {
                                        this.wishedSku = wishedSku;
                                    }
                                }

                                public SubSkuModel(String imageUrl, Byte itemsType, String name, String overseasPreShippingTime, String presaleDeliveryTimeStr, Integer saleStatus, String skuSpec, Integer sliceNum, Long subSkuId, Long subSkuItemsId, String subSkuPrice, Integer type, String url, Boolean whiteListSku, Boolean wishedSku) {
                                    this.imageUrl = imageUrl;
                                    this.itemsType = itemsType;
                                    this.name = name;
                                    this.overseasPreShippingTime = overseasPreShippingTime;
                                    this.presaleDeliveryTimeStr = presaleDeliveryTimeStr;
                                    this.saleStatus = saleStatus;
                                    this.skuSpec = skuSpec;
                                    this.sliceNum = sliceNum;
                                    this.subSkuId = subSkuId;
                                    this.subSkuItemsId = subSkuItemsId;
                                    this.subSkuPrice = subSkuPrice;
                                    this.type = type;
                                    this.url = url;
                                    this.whiteListSku = whiteListSku;
                                    this.wishedSku = wishedSku;
                                }

                                @JvmStatic
                                public static final /* synthetic */ void write$Self$product_details_page_debug(SubSkuModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
                                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.imageUrl != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.imageUrl);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.itemsType != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 1, ByteSerializer.INSTANCE, self.itemsType);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.name != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.name);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.overseasPreShippingTime != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.overseasPreShippingTime);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.presaleDeliveryTimeStr != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.presaleDeliveryTimeStr);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 5) || self.saleStatus != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.saleStatus);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 6) || self.skuSpec != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.skuSpec);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 7) || self.sliceNum != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 7, IntSerializer.INSTANCE, self.sliceNum);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 8) || self.subSkuId != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 8, LongSerializer.INSTANCE, self.subSkuId);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 9) || self.subSkuItemsId != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 9, LongSerializer.INSTANCE, self.subSkuItemsId);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 10) || self.subSkuPrice != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.subSkuPrice);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 11) || self.type != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 11, IntSerializer.INSTANCE, self.type);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 12) || self.url != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.url);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 13) || self.whiteListSku != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 13, BooleanSerializer.INSTANCE, self.whiteListSku);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 14) || self.wishedSku != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 14, BooleanSerializer.INSTANCE, self.wishedSku);
                                    }
                                }

                                public /* synthetic */ SubSkuModel(String str, Byte b, String str2, String str3, String str4, Integer num, String str5, Integer num2, Long l, Long l2, String str6, Integer num3, String str7, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : b, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : num2, (i & 256) != 0 ? null : l, (i & 512) != 0 ? null : l2, (i & 1024) != 0 ? null : str6, (i & 2048) != 0 ? null : num3, (i & 4096) != 0 ? null : str7, (i & 8192) != 0 ? null : bool, (i & 16384) == 0 ? bool2 : null);
                                }

                                public final String getImageUrl() {
                                    return this.imageUrl;
                                }

                                public final Byte getItemsType() {
                                    return this.itemsType;
                                }

                                public final String getName() {
                                    return this.name;
                                }

                                public final String getOverseasPreShippingTime() {
                                    return this.overseasPreShippingTime;
                                }

                                public final String getPresaleDeliveryTimeStr() {
                                    return this.presaleDeliveryTimeStr;
                                }

                                public final Integer getSaleStatus() {
                                    return this.saleStatus;
                                }

                                public final String getSkuSpec() {
                                    return this.skuSpec;
                                }

                                public final Integer getSliceNum() {
                                    return this.sliceNum;
                                }

                                public final Long getSubSkuId() {
                                    return this.subSkuId;
                                }

                                public final Long getSubSkuItemsId() {
                                    return this.subSkuItemsId;
                                }

                                public final String getSubSkuPrice() {
                                    return this.subSkuPrice;
                                }

                                public final Integer getType() {
                                    return this.type;
                                }

                                public final String getUrl() {
                                    return this.url;
                                }

                                public final Boolean getWhiteListSku() {
                                    return this.whiteListSku;
                                }

                                public final Boolean getWishedSku() {
                                    return this.wishedSku;
                                }
                            }

                            /* compiled from: IPFeedRecommendApiService.kt */
                            @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.BO\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bBY\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003JV\u0010\u001e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020\u0004HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u0006/"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$TagsModel;", "", "bizTagList", "", "", "cateTagList", "finishOrderCnt", "", "finishOrderCount", "saleNum", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBizTagList", "()Ljava/util/List;", "getCateTagList", "getFinishOrderCnt", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFinishOrderCount", "()Ljava/lang/String;", "getSaleNum", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$TagsModel;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                            @Serializable
                            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                            public static final class TagsModel {
                                private final List<String> bizTagList;
                                private final List<String> cateTagList;
                                private final Integer finishOrderCnt;
                                private final String finishOrderCount;
                                private final String saleNum;
                                public static final Companion Companion = new Companion(null);
                                public static final int $stable = 8;
                                private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$TagsModel$$ExternalSyntheticLambda0
                                    public final Object invoke() {
                                        KSerializer _childSerializers$_anonymous_;
                                        _childSerializers$_anonymous_ = IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.TagsModel._childSerializers$_anonymous_();
                                        return _childSerializers$_anonymous_;
                                    }
                                }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$TagsModel$$ExternalSyntheticLambda1
                                    public final Object invoke() {
                                        KSerializer _childSerializers$_anonymous_$0;
                                        _childSerializers$_anonymous_$0 = IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.TagsModel._childSerializers$_anonymous_$0();
                                        return _childSerializers$_anonymous_$0;
                                    }
                                }), null, null, null};

                                public TagsModel() {
                                    this((List) null, (List) null, (Integer) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
                                }

                                public static /* synthetic */ TagsModel copy$default(TagsModel tagsModel, List list, List list2, Integer num, String str, String str2, int i, Object obj) {
                                    List<String> list3 = list;
                                    if ((i & 1) != 0) {
                                        list3 = tagsModel.bizTagList;
                                    }
                                    List<String> list4 = list2;
                                    if ((i & 2) != 0) {
                                        list4 = tagsModel.cateTagList;
                                    }
                                    List list5 = list4;
                                    if ((i & 4) != 0) {
                                        num = tagsModel.finishOrderCnt;
                                    }
                                    Integer num2 = num;
                                    if ((i & 8) != 0) {
                                        str = tagsModel.finishOrderCount;
                                    }
                                    String str3 = str;
                                    if ((i & 16) != 0) {
                                        str2 = tagsModel.saleNum;
                                    }
                                    return tagsModel.copy(list3, list5, num2, str3, str2);
                                }

                                public final List<String> component1() {
                                    return this.bizTagList;
                                }

                                public final List<String> component2() {
                                    return this.cateTagList;
                                }

                                public final Integer component3() {
                                    return this.finishOrderCnt;
                                }

                                public final String component4() {
                                    return this.finishOrderCount;
                                }

                                public final String component5() {
                                    return this.saleNum;
                                }

                                public final TagsModel copy(List<String> list, List<String> list2, Integer num, String str, String str2) {
                                    return new TagsModel(list, list2, num, str, str2);
                                }

                                public boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj instanceof TagsModel) {
                                        TagsModel tagsModel = (TagsModel) obj;
                                        return Intrinsics.areEqual(this.bizTagList, tagsModel.bizTagList) && Intrinsics.areEqual(this.cateTagList, tagsModel.cateTagList) && Intrinsics.areEqual(this.finishOrderCnt, tagsModel.finishOrderCnt) && Intrinsics.areEqual(this.finishOrderCount, tagsModel.finishOrderCount) && Intrinsics.areEqual(this.saleNum, tagsModel.saleNum);
                                    }
                                    return false;
                                }

                                public int hashCode() {
                                    return ((((((((this.bizTagList == null ? 0 : this.bizTagList.hashCode()) * 31) + (this.cateTagList == null ? 0 : this.cateTagList.hashCode())) * 31) + (this.finishOrderCnt == null ? 0 : this.finishOrderCnt.hashCode())) * 31) + (this.finishOrderCount == null ? 0 : this.finishOrderCount.hashCode())) * 31) + (this.saleNum != null ? this.saleNum.hashCode() : 0);
                                }

                                public String toString() {
                                    List<String> list = this.bizTagList;
                                    List<String> list2 = this.cateTagList;
                                    Integer num = this.finishOrderCnt;
                                    String str = this.finishOrderCount;
                                    return "TagsModel(bizTagList=" + list + ", cateTagList=" + list2 + ", finishOrderCnt=" + num + ", finishOrderCount=" + str + ", saleNum=" + this.saleNum + ")";
                                }

                                /* compiled from: IPFeedRecommendApiService.kt */
                                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$TagsModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$TagsModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                                public static final class Companion {
                                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                        this();
                                    }

                                    private Companion() {
                                    }

                                    public final KSerializer<TagsModel> serializer() {
                                        return IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$TagsModel$$serializer.INSTANCE;
                                    }
                                }

                                public /* synthetic */ TagsModel(int seen0, List bizTagList, List cateTagList, Integer finishOrderCnt, String finishOrderCount, String saleNum, SerializationConstructorMarker serializationConstructorMarker) {
                                    if ((seen0 & 1) == 0) {
                                        this.bizTagList = null;
                                    } else {
                                        this.bizTagList = bizTagList;
                                    }
                                    if ((seen0 & 2) == 0) {
                                        this.cateTagList = null;
                                    } else {
                                        this.cateTagList = cateTagList;
                                    }
                                    if ((seen0 & 4) == 0) {
                                        this.finishOrderCnt = null;
                                    } else {
                                        this.finishOrderCnt = finishOrderCnt;
                                    }
                                    if ((seen0 & 8) == 0) {
                                        this.finishOrderCount = null;
                                    } else {
                                        this.finishOrderCount = finishOrderCount;
                                    }
                                    if ((seen0 & 16) == 0) {
                                        this.saleNum = null;
                                    } else {
                                        this.saleNum = saleNum;
                                    }
                                }

                                public TagsModel(List<String> list, List<String> list2, Integer finishOrderCnt, String finishOrderCount, String saleNum) {
                                    this.bizTagList = list;
                                    this.cateTagList = list2;
                                    this.finishOrderCnt = finishOrderCnt;
                                    this.finishOrderCount = finishOrderCount;
                                    this.saleNum = saleNum;
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                                    return new ArrayListSerializer(StringSerializer.INSTANCE);
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                                    return new ArrayListSerializer(StringSerializer.INSTANCE);
                                }

                                @JvmStatic
                                public static final /* synthetic */ void write$Self$product_details_page_debug(TagsModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
                                    Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.bizTagList != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.bizTagList);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.cateTagList != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.cateTagList);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.finishOrderCnt != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.finishOrderCnt);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.finishOrderCount != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.finishOrderCount);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.saleNum != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.saleNum);
                                    }
                                }

                                public /* synthetic */ TagsModel(List list, List list2, Integer num, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                                    this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2);
                                }

                                public final List<String> getBizTagList() {
                                    return this.bizTagList;
                                }

                                public final List<String> getCateTagList() {
                                    return this.cateTagList;
                                }

                                public final Integer getFinishOrderCnt() {
                                    return this.finishOrderCnt;
                                }

                                public final String getFinishOrderCount() {
                                    return this.finishOrderCount;
                                }

                                public final String getSaleNum() {
                                    return this.saleNum;
                                }
                            }
                        }
                    }

                    public static /* synthetic */ Object getIPFeedRecommend$product_details_page_debug$default(IPFeedRecommendApiService iPFeedRecommendApiService, String str, String str2, Continuation continuation, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = null;
                        }
                        if ((i & 2) != 0) {
                            str2 = null;
                        }
                        return iPFeedRecommendApiService.getIPFeedRecommend$product_details_page_debug(str, str2, continuation);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
                    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
                    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
                    /* JADX WARN: Removed duplicated region for block: B:22:0x009c  */
                    /* JADX WARN: Removed duplicated region for block: B:43:0x01e7 A[Catch: Exception -> 0x026a, TryCatch #3 {Exception -> 0x026a, blocks: (B:57:0x025d, B:59:0x0261, B:60:0x0269, B:41:0x01d4, B:43:0x01e7, B:45:0x020f, B:52:0x0228), top: B:75:0x01d4 }] */
                    /* JADX WARN: Removed duplicated region for block: B:45:0x020f A[Catch: Exception -> 0x026a, TRY_LEAVE, TryCatch #3 {Exception -> 0x026a, blocks: (B:57:0x025d, B:59:0x0261, B:60:0x0269, B:41:0x01d4, B:43:0x01e7, B:45:0x020f, B:52:0x0228), top: B:75:0x01d4 }] */
                    /* JADX WARN: Removed duplicated region for block: B:57:0x025d A[Catch: Exception -> 0x026a, TryCatch #3 {Exception -> 0x026a, blocks: (B:57:0x025d, B:59:0x0261, B:60:0x0269, B:41:0x01d4, B:43:0x01e7, B:45:0x020f, B:52:0x0228), top: B:75:0x01d4 }] */
                    /* JADX WARN: Removed duplicated region for block: B:59:0x0261 A[Catch: Exception -> 0x026a, TryCatch #3 {Exception -> 0x026a, blocks: (B:57:0x025d, B:59:0x0261, B:60:0x0269, B:41:0x01d4, B:43:0x01e7, B:45:0x020f, B:52:0x0228), top: B:75:0x01d4 }] */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object getIPFeedRecommend$product_details_page_debug(String ipRightId, String itemIds, Continuation<? super Response> continuation) {
                        IPFeedRecommendApiService$getIPFeedRecommend$1 iPFeedRecommendApiService$getIPFeedRecommend$1;
                        IPFeedRecommendApiService$getIPFeedRecommend$1 iPFeedRecommendApiService$getIPFeedRecommend$12;
                        KType kType;
                        String ipRightId2;
                        String itemIds2;
                        HttpResponse response;
                        KType kType2;
                        Object bodyNullable;
                        if (continuation instanceof IPFeedRecommendApiService$getIPFeedRecommend$1) {
                            iPFeedRecommendApiService$getIPFeedRecommend$1 = (IPFeedRecommendApiService$getIPFeedRecommend$1) continuation;
                            if ((iPFeedRecommendApiService$getIPFeedRecommend$1.label & Integer.MIN_VALUE) != 0) {
                                iPFeedRecommendApiService$getIPFeedRecommend$1.label -= Integer.MIN_VALUE;
                                iPFeedRecommendApiService$getIPFeedRecommend$12 = iPFeedRecommendApiService$getIPFeedRecommend$1;
                                Object $result = iPFeedRecommendApiService$getIPFeedRecommend$12.result;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (iPFeedRecommendApiService$getIPFeedRecommend$12.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        try {
                                            HttpClient $this$post$iv = Client.INSTANCE.getHttpClient();
                                            HttpMessageBuilder httpRequestBuilder = new HttpRequestBuilder();
                                            HttpRequestKt.url(httpRequestBuilder, API_URL_STRING);
                                            HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
                                            RecommendRequestParams.TermQuery[] termQueryArr = new RecommendRequestParams.TermQuery[2];
                                            try {
                                                termQueryArr[0] = new RecommendRequestParams.TermQuery("ip", CollectionsKt.listOfNotNull(ipRightId));
                                                termQueryArr[1] = new RecommendRequestParams.TermQuery("6", CollectionsKt.listOf("0,2,3,5,6,7"));
                                                Object body$iv = new RecommendRequestParams((Boolean) null, (Integer) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Boolean) null, itemIds, (String) null, (Integer) null, (Long) null, (String) null, (Boolean) null, Boxing.boxInt(1), Boxing.boxInt(5), (String) null, (Integer) null, (String) null, (List) null, "ip", "", "", CollectionsKt.listOf(termQueryArr), "", 15986687, (DefaultConstructorMarker) null);
                                                if (body$iv instanceof OutgoingContent) {
                                                    httpRequestBuilder.setBody(body$iv);
                                                    httpRequestBuilder.setBodyType((TypeInfo) null);
                                                } else {
                                                    httpRequestBuilder.setBody(body$iv);
                                                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(RecommendRequestParams.class);
                                                    try {
                                                        kType = Reflection.typeOf(RecommendRequestParams.class);
                                                    } catch (Throwable th) {
                                                        kType = null;
                                                    }
                                                    httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
                                                }
                                                httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
                                                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, $this$post$iv);
                                                iPFeedRecommendApiService$getIPFeedRecommend$12.L$0 = SpillingKt.nullOutSpilledVariable(ipRightId);
                                                iPFeedRecommendApiService$getIPFeedRecommend$12.L$1 = SpillingKt.nullOutSpilledVariable(itemIds);
                                                iPFeedRecommendApiService$getIPFeedRecommend$12.L$2 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                                iPFeedRecommendApiService$getIPFeedRecommend$12.L$3 = SpillingKt.nullOutSpilledVariable(API_URL_STRING);
                                                iPFeedRecommendApiService$getIPFeedRecommend$12.L$4 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                                iPFeedRecommendApiService$getIPFeedRecommend$12.L$5 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                                iPFeedRecommendApiService$getIPFeedRecommend$12.L$6 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                                                iPFeedRecommendApiService$getIPFeedRecommend$12.L$7 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                                iPFeedRecommendApiService$getIPFeedRecommend$12.I$0 = 0;
                                                iPFeedRecommendApiService$getIPFeedRecommend$12.I$1 = 0;
                                                iPFeedRecommendApiService$getIPFeedRecommend$12.I$2 = 0;
                                                iPFeedRecommendApiService$getIPFeedRecommend$12.I$3 = 0;
                                                iPFeedRecommendApiService$getIPFeedRecommend$12.label = 1;
                                                Object execute = httpStatement.execute(iPFeedRecommendApiService$getIPFeedRecommend$12);
                                                if (execute == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                ipRightId2 = ipRightId;
                                                $result = execute;
                                                itemIds2 = itemIds;
                                                try {
                                                    response = (HttpResponse) $result;
                                                    if (Intrinsics.areEqual(response.getStatus(), HttpStatusCode.Companion.getOK())) {
                                                        return new Response(Boxing.boxLong(-1L), (IPFeedRecommendModel) null, "Failed to fetch IP feed recommend: " + response.getStatus(), (Boolean) null, 10, (DefaultConstructorMarker) null);
                                                    }
                                                    HttpClientCall call = response.getCall();
                                                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Response.class);
                                                    try {
                                                        kType2 = Reflection.typeOf(Response.class);
                                                    } catch (Throwable th2) {
                                                        kType2 = null;
                                                    }
                                                    TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass2, kType2);
                                                    iPFeedRecommendApiService$getIPFeedRecommend$12.L$0 = SpillingKt.nullOutSpilledVariable(ipRightId2);
                                                    iPFeedRecommendApiService$getIPFeedRecommend$12.L$1 = SpillingKt.nullOutSpilledVariable(itemIds2);
                                                    iPFeedRecommendApiService$getIPFeedRecommend$12.L$2 = SpillingKt.nullOutSpilledVariable(response);
                                                    iPFeedRecommendApiService$getIPFeedRecommend$12.L$3 = SpillingKt.nullOutSpilledVariable(response);
                                                    iPFeedRecommendApiService$getIPFeedRecommend$12.L$4 = null;
                                                    iPFeedRecommendApiService$getIPFeedRecommend$12.L$5 = null;
                                                    iPFeedRecommendApiService$getIPFeedRecommend$12.L$6 = null;
                                                    iPFeedRecommendApiService$getIPFeedRecommend$12.L$7 = null;
                                                    iPFeedRecommendApiService$getIPFeedRecommend$12.I$0 = 0;
                                                    iPFeedRecommendApiService$getIPFeedRecommend$12.label = 2;
                                                    bodyNullable = call.bodyNullable(typeInfo, iPFeedRecommendApiService$getIPFeedRecommend$12);
                                                    if (bodyNullable == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    if (bodyNullable == null) {
                                                        Response retValue = (Response) bodyNullable;
                                                        return retValue;
                                                    }
                                                    throw new NullPointerException("null cannot be cast to non-null type kntr.app.mall.product.details.page.api.IPFeedRecommendApiService.Response");
                                                } catch (Exception e) {
                                                    e = e;
                                                    return new Response(Boxing.boxLong(-1L), (IPFeedRecommendModel) null, "Failed to fetch IP feed recommend: " + e.getMessage(), (Boolean) null, 10, (DefaultConstructorMarker) null);
                                                }
                                            } catch (Exception e2) {
                                                e = e2;
                                                return new Response(Boxing.boxLong(-1L), (IPFeedRecommendModel) null, "Failed to fetch IP feed recommend: " + e.getMessage(), (Boolean) null, 10, (DefaultConstructorMarker) null);
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                        }
                                    case 1:
                                        int i = iPFeedRecommendApiService$getIPFeedRecommend$12.I$3;
                                        int i2 = iPFeedRecommendApiService$getIPFeedRecommend$12.I$2;
                                        int i3 = iPFeedRecommendApiService$getIPFeedRecommend$12.I$1;
                                        int i4 = iPFeedRecommendApiService$getIPFeedRecommend$12.I$0;
                                        HttpClient httpClient = (HttpClient) iPFeedRecommendApiService$getIPFeedRecommend$12.L$7;
                                        HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) iPFeedRecommendApiService$getIPFeedRecommend$12.L$6;
                                        HttpClient httpClient2 = (HttpClient) iPFeedRecommendApiService$getIPFeedRecommend$12.L$5;
                                        HttpClient httpClient3 = (HttpClient) iPFeedRecommendApiService$getIPFeedRecommend$12.L$4;
                                        String str = (String) iPFeedRecommendApiService$getIPFeedRecommend$12.L$3;
                                        HttpClient httpClient4 = (HttpClient) iPFeedRecommendApiService$getIPFeedRecommend$12.L$2;
                                        String itemIds3 = (String) iPFeedRecommendApiService$getIPFeedRecommend$12.L$1;
                                        ipRightId2 = (String) iPFeedRecommendApiService$getIPFeedRecommend$12.L$0;
                                        try {
                                            ResultKt.throwOnFailure($result);
                                            itemIds2 = itemIds3;
                                            response = (HttpResponse) $result;
                                            if (Intrinsics.areEqual(response.getStatus(), HttpStatusCode.Companion.getOK())) {
                                            }
                                        } catch (Exception e4) {
                                            e = e4;
                                            return new Response(Boxing.boxLong(-1L), (IPFeedRecommendModel) null, "Failed to fetch IP feed recommend: " + e.getMessage(), (Boolean) null, 10, (DefaultConstructorMarker) null);
                                        }
                                        break;
                                    case 2:
                                        int i5 = iPFeedRecommendApiService$getIPFeedRecommend$12.I$0;
                                        HttpResponse httpResponse = (HttpResponse) iPFeedRecommendApiService$getIPFeedRecommend$12.L$3;
                                        HttpResponse httpResponse2 = (HttpResponse) iPFeedRecommendApiService$getIPFeedRecommend$12.L$2;
                                        String str2 = (String) iPFeedRecommendApiService$getIPFeedRecommend$12.L$1;
                                        String str3 = (String) iPFeedRecommendApiService$getIPFeedRecommend$12.L$0;
                                        try {
                                            ResultKt.throwOnFailure($result);
                                            bodyNullable = $result;
                                            if (bodyNullable == null) {
                                            }
                                        } catch (Exception e5) {
                                            e = e5;
                                            return new Response(Boxing.boxLong(-1L), (IPFeedRecommendModel) null, "Failed to fetch IP feed recommend: " + e.getMessage(), (Boolean) null, 10, (DefaultConstructorMarker) null);
                                        }
                                        break;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            }
                        }
                        iPFeedRecommendApiService$getIPFeedRecommend$1 = new IPFeedRecommendApiService$getIPFeedRecommend$1(this, continuation);
                        iPFeedRecommendApiService$getIPFeedRecommend$12 = iPFeedRecommendApiService$getIPFeedRecommend$1;
                        Object $result2 = iPFeedRecommendApiService$getIPFeedRecommend$12.result;
                        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (iPFeedRecommendApiService$getIPFeedRecommend$12.label) {
                        }
                    }

                    public static /* synthetic */ Object kntrGetIPFeedRecommend$product_details_page_debug$default(IPFeedRecommendApiService iPFeedRecommendApiService, String str, String str2, Continuation continuation, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = null;
                        }
                        if ((i & 2) != 0) {
                            str2 = null;
                        }
                        return iPFeedRecommendApiService.kntrGetIPFeedRecommend$product_details_page_debug(str, str2, continuation);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
                    /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
                    /* JADX WARN: Removed duplicated region for block: B:17:0x0069  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object kntrGetIPFeedRecommend$product_details_page_debug(String ipRightId, String itemIds, Continuation<? super Response> continuation) {
                        IPFeedRecommendApiService$kntrGetIPFeedRecommend$1 iPFeedRecommendApiService$kntrGetIPFeedRecommend$1;
                        Client client;
                        Pair[] pairArr;
                        Client $this$iv;
                        int $i$f$kntrRequest$product_details_page_debug;
                        Object mallKntrAsyncRequest;
                        try {
                            if (continuation instanceof IPFeedRecommendApiService$kntrGetIPFeedRecommend$1) {
                                iPFeedRecommendApiService$kntrGetIPFeedRecommend$1 = (IPFeedRecommendApiService$kntrGetIPFeedRecommend$1) continuation;
                                if ((iPFeedRecommendApiService$kntrGetIPFeedRecommend$1.label & Integer.MIN_VALUE) != 0) {
                                    iPFeedRecommendApiService$kntrGetIPFeedRecommend$1.label -= Integer.MIN_VALUE;
                                    Object $result = iPFeedRecommendApiService$kntrGetIPFeedRecommend$1.result;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (iPFeedRecommendApiService$kntrGetIPFeedRecommend$1.label) {
                                        case 0:
                                            ResultKt.throwOnFailure($result);
                                            try {
                                                client = Client.INSTANCE;
                                                pairArr = new Pair[8];
                                                pairArr[0] = TuplesKt.to("trackId", "");
                                                pairArr[1] = TuplesKt.to("sortOrder", "");
                                                pairArr[2] = TuplesKt.to("scene", "ip");
                                                pairArr[3] = TuplesKt.to("sortType", "");
                                            } catch (Exception e) {
                                                e = e;
                                            }
                                            try {
                                                pairArr[4] = TuplesKt.to("itemIds", itemIds);
                                                pairArr[5] = TuplesKt.to("pageIndex", Boxing.boxInt(1));
                                                pairArr[6] = TuplesKt.to("pageSize", Boxing.boxInt(5));
                                                pairArr[7] = TuplesKt.to("termQueries", CollectionsKt.listOf(new Map[]{MapsKt.mapOf(new Pair[]{TuplesKt.to("field", "ip"), TuplesKt.to("values", CollectionsKt.listOfNotNull(ipRightId))}), MapsKt.mapOf(new Pair[]{TuplesKt.to("field", "6"), TuplesKt.to("values", CollectionsKt.listOf("0,2,3,5,6,7"))})}));
                                                Map params$iv = MapsKt.mapOf(pairArr);
                                                $this$iv = client;
                                                try {
                                                    iPFeedRecommendApiService$kntrGetIPFeedRecommend$1.L$0 = SpillingKt.nullOutSpilledVariable(ipRightId);
                                                    iPFeedRecommendApiService$kntrGetIPFeedRecommend$1.L$1 = SpillingKt.nullOutSpilledVariable(itemIds);
                                                    iPFeedRecommendApiService$kntrGetIPFeedRecommend$1.L$2 = $this$iv;
                                                    iPFeedRecommendApiService$kntrGetIPFeedRecommend$1.L$3 = SpillingKt.nullOutSpilledVariable(API_URL_STRING);
                                                    iPFeedRecommendApiService$kntrGetIPFeedRecommend$1.L$4 = SpillingKt.nullOutSpilledVariable("POST");
                                                    iPFeedRecommendApiService$kntrGetIPFeedRecommend$1.L$5 = SpillingKt.nullOutSpilledVariable(params$iv);
                                                    iPFeedRecommendApiService$kntrGetIPFeedRecommend$1.I$0 = 0;
                                                    iPFeedRecommendApiService$kntrGetIPFeedRecommend$1.label = 1;
                                                    mallKntrAsyncRequest = MallEnvKt.mallKntrAsyncRequest(API_URL_STRING, "POST", (Map) null, params$iv, iPFeedRecommendApiService$kntrGetIPFeedRecommend$1);
                                                    if (mallKntrAsyncRequest == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    $i$f$kntrRequest$product_details_page_debug = 0;
                                                    try {
                                                        String jsonString$iv = (String) mallKntrAsyncRequest;
                                                        Json this_$iv$iv = $this$iv.getJson();
                                                        Intrinsics.checkNotNull(jsonString$iv);
                                                        this_$iv$iv.getSerializersModule();
                                                        Object res$iv = this_$iv$iv.decodeFromString(Response.Companion.serializer(), jsonString$iv);
                                                        Response response = (Response) res$iv;
                                                        return response;
                                                    } catch (Exception e2) {
                                                        e$iv = e2;
                                                        KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                                        throw e$iv;
                                                    }
                                                } catch (Exception e3) {
                                                    e$iv = e3;
                                                    $i$f$kntrRequest$product_details_page_debug = 0;
                                                    KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                                    throw e$iv;
                                                }
                                            } catch (Exception e4) {
                                                e = e4;
                                                return new Response(Boxing.boxLong(-1L), (IPFeedRecommendModel) null, "Failed to fetch IP feed recommend: " + e.getMessage(), (Boolean) null, 10, (DefaultConstructorMarker) null);
                                            }
                                        case 1:
                                            $i$f$kntrRequest$product_details_page_debug = iPFeedRecommendApiService$kntrGetIPFeedRecommend$1.I$0;
                                            Map map = (Map) iPFeedRecommendApiService$kntrGetIPFeedRecommend$1.L$5;
                                            String str = (String) iPFeedRecommendApiService$kntrGetIPFeedRecommend$1.L$4;
                                            String str2 = (String) iPFeedRecommendApiService$kntrGetIPFeedRecommend$1.L$3;
                                            $this$iv = (Client) iPFeedRecommendApiService$kntrGetIPFeedRecommend$1.L$2;
                                            String str3 = (String) iPFeedRecommendApiService$kntrGetIPFeedRecommend$1.L$1;
                                            String str4 = (String) iPFeedRecommendApiService$kntrGetIPFeedRecommend$1.L$0;
                                            try {
                                                ResultKt.throwOnFailure($result);
                                                mallKntrAsyncRequest = $result;
                                                String jsonString$iv2 = (String) mallKntrAsyncRequest;
                                                Json this_$iv$iv2 = $this$iv.getJson();
                                                Intrinsics.checkNotNull(jsonString$iv2);
                                                this_$iv$iv2.getSerializersModule();
                                                Object res$iv2 = this_$iv$iv2.decodeFromString(Response.Companion.serializer(), jsonString$iv2);
                                                Response response2 = (Response) res$iv2;
                                                return response2;
                                            } catch (Exception e5) {
                                                e$iv = e5;
                                                KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                                throw e$iv;
                                            }
                                        default:
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                }
                            }
                            switch (iPFeedRecommendApiService$kntrGetIPFeedRecommend$1.label) {
                            }
                        } catch (Exception e6) {
                            e = e6;
                        }
                        iPFeedRecommendApiService$kntrGetIPFeedRecommend$1 = new IPFeedRecommendApiService$kntrGetIPFeedRecommend$1(this, continuation);
                        Object $result2 = iPFeedRecommendApiService$kntrGetIPFeedRecommend$1.result;
                        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    }
                }