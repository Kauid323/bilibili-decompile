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
import kntr.app.mall.product.details.page.api.FeedBlastApiService;
import kntr.app.mall.product.details.page.api.model.FeedsModel;
import kntr.app.mall.product.details.page.api.model.FeedsModel$$serializer;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: FeedBlastApiService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\bÁ\u0002\u0018\u00002\u00020\u0001:\u0003\u0010\u0011\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0080@¢\u0006\u0004\b\u000b\u0010\fJ$\u0010\r\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0080@¢\u0006\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkntr/app/mall/product/details/page/api/FeedBlastApiService;", "", "<init>", "()V", "API_URL_STRING", "", "loadFeedBlast", "Lkntr/app/mall/product/details/page/api/model/FeedsModel;", "pageNum", "", "itemsId", "loadFeedBlast$product_details_page_debug", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kntrLoadFeedBlast", "kntrLoadFeedBlast$product_details_page_debug", "(Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Response", "Request", "TermQuery", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FeedBlastApiService {
    public static final int $stable = 0;
    private static final String API_URL_STRING = "https://mall.bilibili.com/mall/noah/feed/sceneRec";
    public static final FeedBlastApiService INSTANCE = new FeedBlastApiService();

    private FeedBlastApiService() {
    }

    /* compiled from: FeedBlastApiService.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006#"}, d2 = {"Lkntr/app/mall/product/details/page/api/FeedBlastApiService$Response;", "", "code", "", "data", "Lkntr/app/mall/product/details/page/api/model/FeedsModel;", "<init>", "(ILkntr/app/mall/product/details/page/api/model/FeedsModel;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILkntr/app/mall/product/details/page/api/model/FeedsModel;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()I", "getData", "()Lkntr/app/mall/product/details/page/api/model/FeedsModel;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Response {
        private final int code;
        private final FeedsModel data;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public static /* synthetic */ Response copy$default(Response response, int i, FeedsModel feedsModel, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = response.code;
            }
            if ((i2 & 2) != 0) {
                feedsModel = response.data;
            }
            return response.copy(i, feedsModel);
        }

        public final int component1() {
            return this.code;
        }

        public final FeedsModel component2() {
            return this.data;
        }

        public final Response copy(int i, FeedsModel feedsModel) {
            Intrinsics.checkNotNullParameter(feedsModel, "data");
            return new Response(i, feedsModel);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Response) {
                Response response = (Response) obj;
                return this.code == response.code && Intrinsics.areEqual(this.data, response.data);
            }
            return false;
        }

        public int hashCode() {
            return (this.code * 31) + this.data.hashCode();
        }

        public String toString() {
            int i = this.code;
            return "Response(code=" + i + ", data=" + this.data + ")";
        }

        /* compiled from: FeedBlastApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/FeedBlastApiService$Response$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/FeedBlastApiService$Response;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Response> serializer() {
                return FeedBlastApiService$Response$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Response(int seen0, int code, FeedsModel data, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (seen0 & 3)) {
                PluginExceptionsKt.throwMissingFieldException(seen0, 3, FeedBlastApiService$Response$$serializer.INSTANCE.getDescriptor());
            }
            this.code = code;
            this.data = data;
        }

        public Response(int code, FeedsModel data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.code = code;
            this.data = data;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(Response self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeIntElement(serialDesc, 0, self.code);
            output.encodeSerializableElement(serialDesc, 1, FeedsModel$$serializer.INSTANCE, self.data);
        }

        public final int getCode() {
            return this.code;
        }

        public final FeedsModel getData() {
            return this.data;
        }
    }

    /* compiled from: FeedBlastApiService.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bBI\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JD\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006-"}, d2 = {"Lkntr/app/mall/product/details/page/api/FeedBlastApiService$Request;", "", "pageSize", "", "pageNum", "scene", "", "termQueries", "", "Lkntr/app/mall/product/details/page/api/FeedBlastApiService$TermQuery;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPageSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPageNum", "getScene", "()Ljava/lang/String;", "getTermQueries", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)Lkntr/app/mall/product/details/page/api/FeedBlastApiService$Request;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Request {
        private final Integer pageNum;
        private final Integer pageSize;
        private final String scene;
        private final List<TermQuery> termQueries;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.FeedBlastApiService$Request$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = FeedBlastApiService.Request._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        })};

        public Request() {
            this((Integer) null, (Integer) null, (String) null, (List) null, 15, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Request copy$default(Request request, Integer num, Integer num2, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                num = request.pageSize;
            }
            if ((i & 2) != 0) {
                num2 = request.pageNum;
            }
            if ((i & 4) != 0) {
                str = request.scene;
            }
            if ((i & 8) != 0) {
                list = request.termQueries;
            }
            return request.copy(num, num2, str, list);
        }

        public final Integer component1() {
            return this.pageSize;
        }

        public final Integer component2() {
            return this.pageNum;
        }

        public final String component3() {
            return this.scene;
        }

        public final List<TermQuery> component4() {
            return this.termQueries;
        }

        public final Request copy(Integer num, Integer num2, String str, List<TermQuery> list) {
            return new Request(num, num2, str, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Request) {
                Request request = (Request) obj;
                return Intrinsics.areEqual(this.pageSize, request.pageSize) && Intrinsics.areEqual(this.pageNum, request.pageNum) && Intrinsics.areEqual(this.scene, request.scene) && Intrinsics.areEqual(this.termQueries, request.termQueries);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.pageSize == null ? 0 : this.pageSize.hashCode()) * 31) + (this.pageNum == null ? 0 : this.pageNum.hashCode())) * 31) + (this.scene == null ? 0 : this.scene.hashCode())) * 31) + (this.termQueries != null ? this.termQueries.hashCode() : 0);
        }

        public String toString() {
            Integer num = this.pageSize;
            Integer num2 = this.pageNum;
            String str = this.scene;
            return "Request(pageSize=" + num + ", pageNum=" + num2 + ", scene=" + str + ", termQueries=" + this.termQueries + ")";
        }

        /* compiled from: FeedBlastApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/FeedBlastApiService$Request$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/FeedBlastApiService$Request;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Request> serializer() {
                return new GeneratedSerializer<Request>() { // from class: kntr.app.mall.product.details.page.api.FeedBlastApiService$Request$$serializer
                    public static final int $stable;
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.FeedBlastApiService.Request", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.FeedBlastApiService$Request> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.FeedBlastApiService$Request> A[REMOVE]) =  kntr.app.mall.product.details.page.api.FeedBlastApiService$Request$$serializer.INSTANCE kntr.app.mall.product.details.page.api.FeedBlastApiService$Request$$serializer)
                             in method: kntr.app.mall.product.details.page.api.FeedBlastApiService.Request.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.FeedBlastApiService$Request>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                              ("kntr.app.mall.product.details.page.api.FeedBlastApiService.Request")
                              (wrap: kntr.app.mall.product.details.page.api.FeedBlastApiService$Request$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.FeedBlastApiService$Request$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.FeedBlastApiService$Request$$serializer.INSTANCE kntr.app.mall.product.details.page.api.FeedBlastApiService$Request$$serializer)
                              (4 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.FeedBlastApiService$Request$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.FeedBlastApiService$Request$$serializer
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
                            kntr.app.mall.product.details.page.api.FeedBlastApiService$Request$$serializer r0 = kntr.app.mall.product.details.page.api.FeedBlastApiService$Request$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.FeedBlastApiService.Request.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ Request(int seen0, Integer pageSize, Integer pageNum, String scene, List termQueries, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.pageSize = null;
                    } else {
                        this.pageSize = pageSize;
                    }
                    if ((seen0 & 2) == 0) {
                        this.pageNum = null;
                    } else {
                        this.pageNum = pageNum;
                    }
                    if ((seen0 & 4) == 0) {
                        this.scene = null;
                    } else {
                        this.scene = scene;
                    }
                    if ((seen0 & 8) == 0) {
                        this.termQueries = null;
                    } else {
                        this.termQueries = termQueries;
                    }
                }

                public Request(Integer pageSize, Integer pageNum, String scene, List<TermQuery> list) {
                    this.pageSize = pageSize;
                    this.pageNum = pageNum;
                    this.scene = scene;
                    this.termQueries = list;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                    return new ArrayListSerializer(FeedBlastApiService$TermQuery$$serializer.INSTANCE);
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(Request self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.pageSize != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.pageSize);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.pageNum != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.pageNum);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.scene != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.scene);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.termQueries != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.termQueries);
                    }
                }

                public /* synthetic */ Request(Integer num, Integer num2, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : list);
                }

                public final Integer getPageSize() {
                    return this.pageSize;
                }

                public final Integer getPageNum() {
                    return this.pageNum;
                }

                public final String getScene() {
                    return this.scene;
                }

                public final List<TermQuery> getTermQueries() {
                    return this.termQueries;
                }
            }

            /* compiled from: FeedBlastApiService.kt */
            @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B5\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\tHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lkntr/app/mall/product/details/page/api/FeedBlastApiService$TermQuery;", "", "field", "", "values", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getField", "()Ljava/lang/String;", "getValues", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class TermQuery {
                private final String field;
                private final List<String> values;
                public static final Companion Companion = new Companion(null);
                public static final int $stable = 8;
                private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.FeedBlastApiService$TermQuery$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        KSerializer _childSerializers$_anonymous_;
                        _childSerializers$_anonymous_ = FeedBlastApiService.TermQuery._childSerializers$_anonymous_();
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

                /* compiled from: FeedBlastApiService.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/FeedBlastApiService$TermQuery$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/FeedBlastApiService$TermQuery;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<TermQuery> serializer() {
                        return FeedBlastApiService$TermQuery$$serializer.INSTANCE;
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

            /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x00a0  */
            /* JADX WARN: Removed duplicated region for block: B:45:0x01ab A[Catch: Exception -> 0x0215, TryCatch #7 {Exception -> 0x0215, blocks: (B:43:0x0198, B:45:0x01ab, B:47:0x01b2, B:54:0x01cb), top: B:89:0x0198 }] */
            /* JADX WARN: Removed duplicated region for block: B:47:0x01b2 A[Catch: Exception -> 0x0215, TRY_LEAVE, TryCatch #7 {Exception -> 0x0215, blocks: (B:43:0x0198, B:45:0x01ab, B:47:0x01b2, B:54:0x01cb), top: B:89:0x0198 }] */
            /* JADX WARN: Removed duplicated region for block: B:59:0x0202 A[Catch: Exception -> 0x020a, TRY_ENTER, TryCatch #3 {Exception -> 0x020a, blocks: (B:59:0x0202, B:63:0x020c, B:64:0x0214), top: B:82:0x0200 }] */
            /* JADX WARN: Removed duplicated region for block: B:63:0x020c A[Catch: Exception -> 0x020a, TryCatch #3 {Exception -> 0x020a, blocks: (B:59:0x0202, B:63:0x020c, B:64:0x0214), top: B:82:0x0200 }] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object loadFeedBlast$product_details_page_debug(int pageNum, String itemsId, Continuation<? super FeedsModel> continuation) {
                FeedBlastApiService$loadFeedBlast$1 feedBlastApiService$loadFeedBlast$1;
                FeedBlastApiService$loadFeedBlast$1 feedBlastApiService$loadFeedBlast$12;
                KType kType;
                HttpStatement httpStatement;
                int pageNum2;
                Object execute;
                String itemsId2;
                Request request;
                HttpResponse response;
                KType kType2;
                Object bodyNullable;
                if (continuation instanceof FeedBlastApiService$loadFeedBlast$1) {
                    feedBlastApiService$loadFeedBlast$1 = (FeedBlastApiService$loadFeedBlast$1) continuation;
                    if ((feedBlastApiService$loadFeedBlast$1.label & Integer.MIN_VALUE) != 0) {
                        feedBlastApiService$loadFeedBlast$1.label -= Integer.MIN_VALUE;
                        feedBlastApiService$loadFeedBlast$12 = feedBlastApiService$loadFeedBlast$1;
                        Object $result = feedBlastApiService$loadFeedBlast$12.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (feedBlastApiService$loadFeedBlast$12.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                Request request2 = new Request(Boxing.boxInt(20), Boxing.boxInt(pageNum), "detail_bottom", CollectionsKt.listOf(new TermQuery("item_id", CollectionsKt.listOfNotNull(itemsId))));
                                try {
                                    HttpClient $this$post$iv = Client.INSTANCE.getHttpClient();
                                    HttpMessageBuilder httpRequestBuilder = new HttpRequestBuilder();
                                    HttpRequestKt.url(httpRequestBuilder, API_URL_STRING);
                                    HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
                                    try {
                                        if (request2 instanceof OutgoingContent) {
                                            httpRequestBuilder.setBody(request2);
                                            httpRequestBuilder.setBodyType((TypeInfo) null);
                                        } else {
                                            httpRequestBuilder.setBody(request2);
                                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Request.class);
                                            try {
                                                kType = Reflection.typeOf(Request.class);
                                            } catch (Throwable th) {
                                                kType = null;
                                            }
                                            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
                                        }
                                        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
                                        httpStatement = new HttpStatement(httpRequestBuilder, $this$post$iv);
                                        feedBlastApiService$loadFeedBlast$12.L$0 = SpillingKt.nullOutSpilledVariable(itemsId);
                                        feedBlastApiService$loadFeedBlast$12.L$1 = SpillingKt.nullOutSpilledVariable(request2);
                                        feedBlastApiService$loadFeedBlast$12.L$2 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                        feedBlastApiService$loadFeedBlast$12.L$3 = SpillingKt.nullOutSpilledVariable(API_URL_STRING);
                                        feedBlastApiService$loadFeedBlast$12.L$4 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                        feedBlastApiService$loadFeedBlast$12.L$5 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                        feedBlastApiService$loadFeedBlast$12.L$6 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                                        feedBlastApiService$loadFeedBlast$12.L$7 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                        pageNum2 = pageNum;
                                    } catch (Exception e) {
                                    }
                                } catch (Exception e2) {
                                }
                                try {
                                    feedBlastApiService$loadFeedBlast$12.I$0 = pageNum2;
                                    feedBlastApiService$loadFeedBlast$12.I$1 = 0;
                                    feedBlastApiService$loadFeedBlast$12.I$2 = 0;
                                    feedBlastApiService$loadFeedBlast$12.I$3 = 0;
                                    feedBlastApiService$loadFeedBlast$12.I$4 = 0;
                                    feedBlastApiService$loadFeedBlast$12.label = 1;
                                    execute = httpStatement.execute(feedBlastApiService$loadFeedBlast$12);
                                    if (execute == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    itemsId2 = itemsId;
                                    request = request2;
                                    try {
                                        response = (HttpResponse) execute;
                                        if (Intrinsics.areEqual(response.getStatus(), HttpStatusCode.Companion.getOK())) {
                                            return new FeedsModel(null);
                                        }
                                        HttpClientCall call = response.getCall();
                                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Response.class);
                                        try {
                                            kType2 = Reflection.typeOf(Response.class);
                                        } catch (Throwable th2) {
                                            kType2 = null;
                                        }
                                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass2, kType2);
                                        feedBlastApiService$loadFeedBlast$12.L$0 = SpillingKt.nullOutSpilledVariable(itemsId2);
                                        feedBlastApiService$loadFeedBlast$12.L$1 = SpillingKt.nullOutSpilledVariable(request);
                                        feedBlastApiService$loadFeedBlast$12.L$2 = SpillingKt.nullOutSpilledVariable(response);
                                        feedBlastApiService$loadFeedBlast$12.L$3 = SpillingKt.nullOutSpilledVariable(response);
                                        feedBlastApiService$loadFeedBlast$12.L$4 = null;
                                        feedBlastApiService$loadFeedBlast$12.L$5 = null;
                                        feedBlastApiService$loadFeedBlast$12.L$6 = null;
                                        feedBlastApiService$loadFeedBlast$12.L$7 = null;
                                        feedBlastApiService$loadFeedBlast$12.I$0 = pageNum2;
                                        feedBlastApiService$loadFeedBlast$12.I$1 = 0;
                                        feedBlastApiService$loadFeedBlast$12.label = 2;
                                        bodyNullable = call.bodyNullable(typeInfo, feedBlastApiService$loadFeedBlast$12);
                                        if (bodyNullable == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        try {
                                            if (bodyNullable == null) {
                                                Response rtValue = (Response) bodyNullable;
                                                return rtValue.getData();
                                            }
                                            throw new NullPointerException("null cannot be cast to non-null type kntr.app.mall.product.details.page.api.FeedBlastApiService.Response");
                                        } catch (Exception e3) {
                                            return new FeedsModel(null);
                                        }
                                    } catch (Exception e4) {
                                        return new FeedsModel(null);
                                    }
                                } catch (Exception e5) {
                                    return new FeedsModel(null);
                                }
                            case 1:
                                int i = feedBlastApiService$loadFeedBlast$12.I$4;
                                int i2 = feedBlastApiService$loadFeedBlast$12.I$3;
                                int i3 = feedBlastApiService$loadFeedBlast$12.I$2;
                                int i4 = feedBlastApiService$loadFeedBlast$12.I$1;
                                int pageNum3 = feedBlastApiService$loadFeedBlast$12.I$0;
                                HttpClient httpClient = (HttpClient) feedBlastApiService$loadFeedBlast$12.L$7;
                                HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) feedBlastApiService$loadFeedBlast$12.L$6;
                                HttpClient httpClient2 = (HttpClient) feedBlastApiService$loadFeedBlast$12.L$5;
                                HttpClient httpClient3 = (HttpClient) feedBlastApiService$loadFeedBlast$12.L$4;
                                String str = (String) feedBlastApiService$loadFeedBlast$12.L$3;
                                HttpClient httpClient4 = (HttpClient) feedBlastApiService$loadFeedBlast$12.L$2;
                                Request request3 = (Request) feedBlastApiService$loadFeedBlast$12.L$1;
                                itemsId2 = (String) feedBlastApiService$loadFeedBlast$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    execute = $result;
                                    request = request3;
                                    pageNum2 = pageNum3;
                                    response = (HttpResponse) execute;
                                    if (Intrinsics.areEqual(response.getStatus(), HttpStatusCode.Companion.getOK())) {
                                    }
                                } catch (Exception e6) {
                                    return new FeedsModel(null);
                                }
                                break;
                            case 2:
                                int i5 = feedBlastApiService$loadFeedBlast$12.I$1;
                                int i6 = feedBlastApiService$loadFeedBlast$12.I$0;
                                HttpResponse httpResponse = (HttpResponse) feedBlastApiService$loadFeedBlast$12.L$3;
                                HttpResponse httpResponse2 = (HttpResponse) feedBlastApiService$loadFeedBlast$12.L$2;
                                Request request4 = (Request) feedBlastApiService$loadFeedBlast$12.L$1;
                                String str2 = (String) feedBlastApiService$loadFeedBlast$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    bodyNullable = $result;
                                    if (bodyNullable == null) {
                                    }
                                } catch (Exception e7) {
                                    return new FeedsModel(null);
                                }
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
                feedBlastApiService$loadFeedBlast$1 = new FeedBlastApiService$loadFeedBlast$1(this, continuation);
                feedBlastApiService$loadFeedBlast$12 = feedBlastApiService$loadFeedBlast$1;
                Object $result2 = feedBlastApiService$loadFeedBlast$12.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (feedBlastApiService$loadFeedBlast$12.label) {
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object kntrLoadFeedBlast$product_details_page_debug(Integer pageNum, String itemsId, Continuation<? super FeedsModel> continuation) {
                FeedBlastApiService$kntrLoadFeedBlast$1 feedBlastApiService$kntrLoadFeedBlast$1;
                FeedBlastApiService$kntrLoadFeedBlast$1 feedBlastApiService$kntrLoadFeedBlast$12;
                Client $this$iv;
                Pair[] pairArr;
                Exception e$iv;
                Client $this$iv2;
                Object obj;
                Integer pageNum2;
                Client $this$iv3;
                if (continuation instanceof FeedBlastApiService$kntrLoadFeedBlast$1) {
                    feedBlastApiService$kntrLoadFeedBlast$1 = (FeedBlastApiService$kntrLoadFeedBlast$1) continuation;
                    if ((feedBlastApiService$kntrLoadFeedBlast$1.label & Integer.MIN_VALUE) != 0) {
                        feedBlastApiService$kntrLoadFeedBlast$1.label -= Integer.MIN_VALUE;
                        feedBlastApiService$kntrLoadFeedBlast$12 = feedBlastApiService$kntrLoadFeedBlast$1;
                        Object $result = feedBlastApiService$kntrLoadFeedBlast$12.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (feedBlastApiService$kntrLoadFeedBlast$12.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                try {
                                    $this$iv = Client.INSTANCE;
                                    pairArr = new Pair[4];
                                } catch (Exception e) {
                                }
                                try {
                                    pairArr[0] = TuplesKt.to("pageNum", pageNum);
                                    pairArr[1] = TuplesKt.to("pageSize", Boxing.boxInt(20));
                                    pairArr[2] = TuplesKt.to("scene", "detail_bottom");
                                    pairArr[3] = TuplesKt.to("termQueries", CollectionsKt.listOf(MapsKt.mapOf(new Pair[]{TuplesKt.to("field", "item_id"), TuplesKt.to("values", CollectionsKt.listOfNotNull(itemsId))})));
                                    Map params$iv = MapsKt.mapOf(pairArr);
                                    try {
                                        feedBlastApiService$kntrLoadFeedBlast$12.L$0 = SpillingKt.nullOutSpilledVariable(pageNum);
                                        feedBlastApiService$kntrLoadFeedBlast$12.L$1 = SpillingKt.nullOutSpilledVariable(itemsId);
                                        feedBlastApiService$kntrLoadFeedBlast$12.L$2 = $this$iv;
                                        feedBlastApiService$kntrLoadFeedBlast$12.L$3 = SpillingKt.nullOutSpilledVariable(API_URL_STRING);
                                        feedBlastApiService$kntrLoadFeedBlast$12.L$4 = SpillingKt.nullOutSpilledVariable("POST");
                                        feedBlastApiService$kntrLoadFeedBlast$12.L$5 = SpillingKt.nullOutSpilledVariable(params$iv);
                                        feedBlastApiService$kntrLoadFeedBlast$12.I$0 = 0;
                                        feedBlastApiService$kntrLoadFeedBlast$12.label = 1;
                                        Object mallKntrAsyncRequest = MallEnvKt.mallKntrAsyncRequest(API_URL_STRING, "POST", (Map) null, params$iv, feedBlastApiService$kntrLoadFeedBlast$12);
                                        if (mallKntrAsyncRequest == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        obj = mallKntrAsyncRequest;
                                        pageNum2 = pageNum;
                                        $this$iv3 = $this$iv;
                                        String jsonString$iv = (String) obj;
                                        Json this_$iv$iv = $this$iv3.getJson();
                                        Intrinsics.checkNotNull(jsonString$iv);
                                        this_$iv$iv.getSerializersModule();
                                        Object res$iv = this_$iv$iv.decodeFromString(Response.Companion.serializer(), jsonString$iv);
                                        try {
                                            Response response = (Response) res$iv;
                                            return response.getData();
                                        } catch (Exception e2) {
                                            return new FeedsModel(null);
                                        }
                                    } catch (Exception e3) {
                                        e$iv = e3;
                                        $this$iv2 = $this$iv;
                                        try {
                                            KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                            throw e$iv;
                                        } catch (Exception e4) {
                                            return new FeedsModel(null);
                                        }
                                    }
                                } catch (Exception e5) {
                                    return new FeedsModel(null);
                                }
                            case 1:
                                int i = feedBlastApiService$kntrLoadFeedBlast$12.I$0;
                                Map map = (Map) feedBlastApiService$kntrLoadFeedBlast$12.L$5;
                                String str = (String) feedBlastApiService$kntrLoadFeedBlast$12.L$4;
                                String str2 = (String) feedBlastApiService$kntrLoadFeedBlast$12.L$3;
                                $this$iv3 = (Client) feedBlastApiService$kntrLoadFeedBlast$12.L$2;
                                String str3 = (String) feedBlastApiService$kntrLoadFeedBlast$12.L$1;
                                pageNum2 = (Integer) feedBlastApiService$kntrLoadFeedBlast$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    obj = $result;
                                    String jsonString$iv2 = (String) obj;
                                    Json this_$iv$iv2 = $this$iv3.getJson();
                                    Intrinsics.checkNotNull(jsonString$iv2);
                                    this_$iv$iv2.getSerializersModule();
                                    Object res$iv2 = this_$iv$iv2.decodeFromString(Response.Companion.serializer(), jsonString$iv2);
                                    Response response2 = (Response) res$iv2;
                                    return response2.getData();
                                } catch (Exception e6) {
                                    e$iv = e6;
                                    $this$iv2 = $this$iv3;
                                    KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                    throw e$iv;
                                }
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
                feedBlastApiService$kntrLoadFeedBlast$1 = new FeedBlastApiService$kntrLoadFeedBlast$1(this, continuation);
                feedBlastApiService$kntrLoadFeedBlast$12 = feedBlastApiService$kntrLoadFeedBlast$1;
                Object $result2 = feedBlastApiService$kntrLoadFeedBlast$12.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (feedBlastApiService$kntrLoadFeedBlast$12.label) {
                }
            }
        }