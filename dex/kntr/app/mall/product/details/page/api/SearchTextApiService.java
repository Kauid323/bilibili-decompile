package kntr.app.mall.product.details.page.api;

import ComposableSingletons$CustomBottomSheetKt$;
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
import kntr.app.mall.product.details.page.api.SearchTextApiService;
import kntr.app.mall.product.details.page.utils.UserInfoKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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

/* compiled from: SearchTextApiService.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003\u000e\u000f\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/app/mall/product/details/page/api/SearchTextApiService;", "", "<init>", "()V", "API_URL_STRING", "", "K_LOG_TAG", "getSearchText", "Lkntr/app/mall/product/details/page/api/SearchTextApiService$SearchTextResponse;", "buvid", "mid", "", "getSearchText$product_details_page_debug", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SearchTextResponse", "SearchTextData", "SearchTextRequest", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SearchTextApiService {
    public static final int $stable = 0;
    private static final String API_URL_STRING = "https://mall.bilibili.com/mall-dayu/mall/internal/search/discovery/carousel";
    public static final SearchTextApiService INSTANCE = new SearchTextApiService();
    private static final String K_LOG_TAG = "NA_WR_SearchTextApiService";

    private SearchTextApiService() {
    }

    /* compiled from: SearchTextApiService.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB7\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\rJ\r\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J)\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006)"}, d2 = {"Lkntr/app/mall/product/details/page/api/SearchTextApiService$SearchTextResponse;", "", "code", "", "data", "Lkntr/app/mall/product/details/page/api/SearchTextApiService$SearchTextData;", "message", "", "<init>", "(ILkntr/app/mall/product/details/page/api/SearchTextApiService$SearchTextData;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILkntr/app/mall/product/details/page/api/SearchTextApiService$SearchTextData;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()I", "getData", "()Lkntr/app/mall/product/details/page/api/SearchTextApiService$SearchTextData;", "getMessage", "()Ljava/lang/String;", "isValid", "", "isValid$product_details_page_debug", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SearchTextResponse {
        private final int code;
        private final SearchTextData data;
        private final String message;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public static /* synthetic */ SearchTextResponse copy$default(SearchTextResponse searchTextResponse, int i, SearchTextData searchTextData, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = searchTextResponse.code;
            }
            if ((i2 & 2) != 0) {
                searchTextData = searchTextResponse.data;
            }
            if ((i2 & 4) != 0) {
                str = searchTextResponse.message;
            }
            return searchTextResponse.copy(i, searchTextData, str);
        }

        public final int component1() {
            return this.code;
        }

        public final SearchTextData component2() {
            return this.data;
        }

        public final String component3() {
            return this.message;
        }

        public final SearchTextResponse copy(int i, SearchTextData searchTextData, String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new SearchTextResponse(i, searchTextData, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SearchTextResponse) {
                SearchTextResponse searchTextResponse = (SearchTextResponse) obj;
                return this.code == searchTextResponse.code && Intrinsics.areEqual(this.data, searchTextResponse.data) && Intrinsics.areEqual(this.message, searchTextResponse.message);
            }
            return false;
        }

        public int hashCode() {
            return (((this.code * 31) + (this.data == null ? 0 : this.data.hashCode())) * 31) + this.message.hashCode();
        }

        public String toString() {
            int i = this.code;
            SearchTextData searchTextData = this.data;
            return "SearchTextResponse(code=" + i + ", data=" + searchTextData + ", message=" + this.message + ")";
        }

        /* compiled from: SearchTextApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/SearchTextApiService$SearchTextResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/SearchTextApiService$SearchTextResponse;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<SearchTextResponse> serializer() {
                return SearchTextApiService$SearchTextResponse$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ SearchTextResponse(int seen0, int code, SearchTextData data, String message, SerializationConstructorMarker serializationConstructorMarker) {
            if (4 != (seen0 & 4)) {
                PluginExceptionsKt.throwMissingFieldException(seen0, 4, SearchTextApiService$SearchTextResponse$$serializer.INSTANCE.getDescriptor());
            }
            if ((seen0 & 1) == 0) {
                this.code = 0;
            } else {
                this.code = code;
            }
            if ((seen0 & 2) == 0) {
                this.data = null;
            } else {
                this.data = data;
            }
            this.message = message;
        }

        public SearchTextResponse(int code, SearchTextData data, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.code = code;
            this.data = data;
            this.message = message;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(SearchTextResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.code != 0) {
                output.encodeIntElement(serialDesc, 0, self.code);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.data != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, SearchTextApiService$SearchTextData$$serializer.INSTANCE, self.data);
            }
            output.encodeStringElement(serialDesc, 2, self.message);
        }

        public /* synthetic */ SearchTextResponse(int i, SearchTextData searchTextData, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : searchTextData, str);
        }

        public final int getCode() {
            return this.code;
        }

        public final SearchTextData getData() {
            return this.data;
        }

        public final String getMessage() {
            return this.message;
        }

        public final boolean isValid$product_details_page_debug() {
            return this.code == 0 && this.data != null;
        }
    }

    /* compiled from: SearchTextApiService.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0003\u001e\u001f B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\bHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006!"}, d2 = {"Lkntr/app/mall/product/details/page/api/SearchTextApiService$SearchTextData;", "", "result", "", "Lkntr/app/mall/product/details/page/api/SearchTextApiService$SearchTextData$SearchTextResult;", "<init>", "(Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getResult", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "SearchTextResult", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SearchTextData {
        private final List<SearchTextResult> result;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.SearchTextApiService$SearchTextData$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = SearchTextApiService.SearchTextData._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        })};

        public SearchTextData() {
            this((List) null, 1, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SearchTextData copy$default(SearchTextData searchTextData, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = searchTextData.result;
            }
            return searchTextData.copy(list);
        }

        public final List<SearchTextResult> component1() {
            return this.result;
        }

        public final SearchTextData copy(List<SearchTextResult> list) {
            Intrinsics.checkNotNullParameter(list, "result");
            return new SearchTextData(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SearchTextData) && Intrinsics.areEqual(this.result, ((SearchTextData) obj).result);
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        public String toString() {
            return "SearchTextData(result=" + this.result + ")";
        }

        /* compiled from: SearchTextApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/SearchTextApiService$SearchTextData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/SearchTextApiService$SearchTextData;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<SearchTextData> serializer() {
                return SearchTextApiService$SearchTextData$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ SearchTextData(int seen0, List result, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.result = CollectionsKt.emptyList();
            } else {
                this.result = result;
            }
        }

        public SearchTextData(List<SearchTextResult> list) {
            Intrinsics.checkNotNullParameter(list, "result");
            this.result = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(SearchTextApiService$SearchTextData$SearchTextResult$$serializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(SearchTextData self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            boolean z = true;
            if (!output.shouldEncodeElementDefault(serialDesc, 0) && Intrinsics.areEqual(self.result, CollectionsKt.emptyList())) {
                z = false;
            }
            if (z) {
                output.encodeSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.result);
            }
        }

        public /* synthetic */ SearchTextData(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
        }

        /* compiled from: SearchTextApiService.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J%\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0001¢\u0006\u0002\b\u001bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lkntr/app/mall/product/details/page/api/SearchTextApiService$SearchTextData$SearchTextResult;", "", "word", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getWord", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class SearchTextResult {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final String word;

            public SearchTextResult() {
                this((String) null, 1, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ SearchTextResult copy$default(SearchTextResult searchTextResult, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = searchTextResult.word;
                }
                return searchTextResult.copy(str);
            }

            public final String component1() {
                return this.word;
            }

            public final SearchTextResult copy(String str) {
                return new SearchTextResult(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof SearchTextResult) && Intrinsics.areEqual(this.word, ((SearchTextResult) obj).word);
            }

            public int hashCode() {
                if (this.word == null) {
                    return 0;
                }
                return this.word.hashCode();
            }

            public String toString() {
                return "SearchTextResult(word=" + this.word + ")";
            }

            /* compiled from: SearchTextApiService.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/SearchTextApiService$SearchTextData$SearchTextResult$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/SearchTextApiService$SearchTextData$SearchTextResult;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<SearchTextResult> serializer() {
                    return SearchTextApiService$SearchTextData$SearchTextResult$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ SearchTextResult(int seen0, String word, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.word = null;
                } else {
                    this.word = word;
                }
            }

            public SearchTextResult(String word) {
                this.word = word;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(SearchTextResult self, CompositeEncoder output, SerialDescriptor serialDesc) {
                boolean z = true;
                if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.word == null) {
                    z = false;
                }
                if (z) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.word);
                }
            }

            public /* synthetic */ SearchTextResult(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }

            public final String getWord() {
                return this.word;
            }
        }

        public final List<SearchTextResult> getResult() {
            return this.result;
        }
    }

    /* compiled from: SearchTextApiService.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000212BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fBS\b\u0010\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJN\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\tHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a¨\u00063"}, d2 = {"Lkntr/app/mall/product/details/page/api/SearchTextApiService$SearchTextRequest;", "", "platform", "", "mid", "", "buvid", "scene", "channel", "", "phoneSystem", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPlatform", "()Ljava/lang/String;", "getMid", "()J", "getBuvid", "getScene", "getChannel", "()I", "getPhoneSystem", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)Lkntr/app/mall/product/details/page/api/SearchTextApiService$SearchTextRequest;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SearchTextRequest {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String buvid;
        private final int channel;
        private final long mid;
        private final Integer phoneSystem;
        private final String platform;
        private final String scene;

        public SearchTextRequest() {
            this((String) null, 0L, (String) null, (String) null, 0, (Integer) null, 63, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ SearchTextRequest copy$default(SearchTextRequest searchTextRequest, String str, long j, String str2, String str3, int i, Integer num, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = searchTextRequest.platform;
            }
            if ((i2 & 2) != 0) {
                j = searchTextRequest.mid;
            }
            long j2 = j;
            if ((i2 & 4) != 0) {
                str2 = searchTextRequest.buvid;
            }
            String str4 = str2;
            if ((i2 & 8) != 0) {
                str3 = searchTextRequest.scene;
            }
            String str5 = str3;
            if ((i2 & 16) != 0) {
                i = searchTextRequest.channel;
            }
            int i3 = i;
            if ((i2 & 32) != 0) {
                num = searchTextRequest.phoneSystem;
            }
            return searchTextRequest.copy(str, j2, str4, str5, i3, num);
        }

        public final String component1() {
            return this.platform;
        }

        public final long component2() {
            return this.mid;
        }

        public final String component3() {
            return this.buvid;
        }

        public final String component4() {
            return this.scene;
        }

        public final int component5() {
            return this.channel;
        }

        public final Integer component6() {
            return this.phoneSystem;
        }

        public final SearchTextRequest copy(String str, long j, String str2, String str3, int i, Integer num) {
            Intrinsics.checkNotNullParameter(str2, "buvid");
            Intrinsics.checkNotNullParameter(str3, "scene");
            return new SearchTextRequest(str, j, str2, str3, i, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SearchTextRequest) {
                SearchTextRequest searchTextRequest = (SearchTextRequest) obj;
                return Intrinsics.areEqual(this.platform, searchTextRequest.platform) && this.mid == searchTextRequest.mid && Intrinsics.areEqual(this.buvid, searchTextRequest.buvid) && Intrinsics.areEqual(this.scene, searchTextRequest.scene) && this.channel == searchTextRequest.channel && Intrinsics.areEqual(this.phoneSystem, searchTextRequest.phoneSystem);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((this.platform == null ? 0 : this.platform.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.mid)) * 31) + this.buvid.hashCode()) * 31) + this.scene.hashCode()) * 31) + this.channel) * 31) + (this.phoneSystem != null ? this.phoneSystem.hashCode() : 0);
        }

        public String toString() {
            String str = this.platform;
            long j = this.mid;
            String str2 = this.buvid;
            String str3 = this.scene;
            int i = this.channel;
            return "SearchTextRequest(platform=" + str + ", mid=" + j + ", buvid=" + str2 + ", scene=" + str3 + ", channel=" + i + ", phoneSystem=" + this.phoneSystem + ")";
        }

        /* compiled from: SearchTextApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/SearchTextApiService$SearchTextRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/SearchTextApiService$SearchTextRequest;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<SearchTextRequest> serializer() {
                return new GeneratedSerializer<SearchTextRequest>() { // from class: kntr.app.mall.product.details.page.api.SearchTextApiService$SearchTextRequest$$serializer
                    public static final int $stable;
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.SearchTextApiService.SearchTextRequest", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.SearchTextApiService$SearchTextRequest> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.SearchTextApiService$SearchTextRequest> A[REMOVE]) =  kntr.app.mall.product.details.page.api.SearchTextApiService$SearchTextRequest$$serializer.INSTANCE kntr.app.mall.product.details.page.api.SearchTextApiService$SearchTextRequest$$serializer)
                             in method: kntr.app.mall.product.details.page.api.SearchTextApiService.SearchTextRequest.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.SearchTextApiService$SearchTextRequest>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                              ("kntr.app.mall.product.details.page.api.SearchTextApiService.SearchTextRequest")
                              (wrap: kntr.app.mall.product.details.page.api.SearchTextApiService$SearchTextRequest$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.SearchTextApiService$SearchTextRequest$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.SearchTextApiService$SearchTextRequest$$serializer.INSTANCE kntr.app.mall.product.details.page.api.SearchTextApiService$SearchTextRequest$$serializer)
                              (6 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.SearchTextApiService$SearchTextRequest$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.SearchTextApiService$SearchTextRequest$$serializer
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
                            kntr.app.mall.product.details.page.api.SearchTextApiService$SearchTextRequest$$serializer r0 = kntr.app.mall.product.details.page.api.SearchTextApiService$SearchTextRequest$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.SearchTextApiService.SearchTextRequest.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ SearchTextRequest(int seen0, String platform, long mid, String buvid, String scene, int channel, Integer phoneSystem, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.platform = null;
                    } else {
                        this.platform = platform;
                    }
                    if ((seen0 & 2) == 0) {
                        this.mid = 0L;
                    } else {
                        this.mid = mid;
                    }
                    if ((seen0 & 4) == 0) {
                        this.buvid = "";
                    } else {
                        this.buvid = buvid;
                    }
                    if ((seen0 & 8) == 0) {
                        this.scene = "discovery-carousel";
                    } else {
                        this.scene = scene;
                    }
                    if ((seen0 & 16) == 0) {
                        this.channel = 1;
                    } else {
                        this.channel = channel;
                    }
                    if ((seen0 & 32) == 0) {
                        this.phoneSystem = null;
                    } else {
                        this.phoneSystem = phoneSystem;
                    }
                }

                public SearchTextRequest(String platform, long mid, String buvid, String scene, int channel, Integer phoneSystem) {
                    Intrinsics.checkNotNullParameter(buvid, "buvid");
                    Intrinsics.checkNotNullParameter(scene, "scene");
                    this.platform = platform;
                    this.mid = mid;
                    this.buvid = buvid;
                    this.scene = scene;
                    this.channel = channel;
                    this.phoneSystem = phoneSystem;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(SearchTextRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.platform != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.platform);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.mid != 0) {
                        output.encodeLongElement(serialDesc, 1, self.mid);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.buvid, "")) {
                        output.encodeStringElement(serialDesc, 2, self.buvid);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.scene, "discovery-carousel")) {
                        output.encodeStringElement(serialDesc, 3, self.scene);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.channel != 1) {
                        output.encodeIntElement(serialDesc, 4, self.channel);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 5) || self.phoneSystem != null) {
                        output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.phoneSystem);
                    }
                }

                public /* synthetic */ SearchTextRequest(String str, long j, String str2, String str3, int i, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? 0L : j, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "discovery-carousel" : str3, (i2 & 16) != 0 ? 1 : i, (i2 & 32) != 0 ? null : num);
                }

                public final String getPlatform() {
                    return this.platform;
                }

                public final long getMid() {
                    return this.mid;
                }

                public final String getBuvid() {
                    return this.buvid;
                }

                public final String getScene() {
                    return this.scene;
                }

                public final int getChannel() {
                    return this.channel;
                }

                public final Integer getPhoneSystem() {
                    return this.phoneSystem;
                }
            }

            public static /* synthetic */ Object getSearchText$product_details_page_debug$default(SearchTextApiService searchTextApiService, String str, long j, Continuation continuation, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = "";
                }
                if ((i & 2) != 0) {
                    Long userId = UserInfoKt.getUserId();
                    j = userId != null ? userId.longValue() : 0L;
                }
                return searchTextApiService.getSearchText$product_details_page_debug(str, j, continuation);
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x005e  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x00b3  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x01d7 A[Catch: Exception -> 0x0287, TRY_LEAVE, TryCatch #10 {Exception -> 0x0287, blocks: (B:52:0x01c4, B:54:0x01d7), top: B:115:0x01c4 }] */
            /* JADX WARN: Removed duplicated region for block: B:58:0x021e A[Catch: Exception -> 0x0285, TRY_LEAVE, TryCatch #11 {Exception -> 0x0285, blocks: (B:56:0x01f2, B:58:0x021e, B:65:0x0239), top: B:117:0x01d5 }] */
            /* JADX WARN: Removed duplicated region for block: B:70:0x0274 A[Catch: Exception -> 0x0278, TRY_ENTER, TryCatch #2 {Exception -> 0x0278, blocks: (B:70:0x0274, B:74:0x027c, B:75:0x0284), top: B:100:0x0272 }] */
            /* JADX WARN: Removed duplicated region for block: B:74:0x027c A[Catch: Exception -> 0x0278, TryCatch #2 {Exception -> 0x0278, blocks: (B:70:0x0274, B:74:0x027c, B:75:0x0284), top: B:100:0x0272 }] */
            /* JADX WARN: Removed duplicated region for block: B:93:0x02cb  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object getSearchText$product_details_page_debug(String buvid, long mid, Continuation<? super SearchTextResponse> continuation) {
                SearchTextApiService$getSearchText$1 searchTextApiService$getSearchText$1;
                SearchTextApiService$getSearchText$1 searchTextApiService$getSearchText$12;
                String str;
                KType kType;
                String str2;
                String buvid2;
                SearchTextRequest request;
                long mid2;
                KType kType2;
                Object bodyNullable;
                long mid3;
                String buvid3;
                String message;
                if (continuation instanceof SearchTextApiService$getSearchText$1) {
                    searchTextApiService$getSearchText$1 = (SearchTextApiService$getSearchText$1) continuation;
                    if ((searchTextApiService$getSearchText$1.label & Integer.MIN_VALUE) != 0) {
                        searchTextApiService$getSearchText$1.label -= Integer.MIN_VALUE;
                        searchTextApiService$getSearchText$12 = searchTextApiService$getSearchText$1;
                        Object $result = searchTextApiService$getSearchText$12.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (searchTextApiService$getSearchText$12.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                SearchTextRequest request2 = new SearchTextRequest((String) null, mid, buvid, (String) null, 0, (Integer) null, 57, (DefaultConstructorMarker) null);
                                try {
                                    HttpClient $this$post$iv = Client.INSTANCE.getHttpClient();
                                    HttpMessageBuilder httpRequestBuilder = new HttpRequestBuilder();
                                    HttpRequestKt.url(httpRequestBuilder, API_URL_STRING);
                                    HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
                                    if (request2 instanceof OutgoingContent) {
                                        try {
                                            httpRequestBuilder.setBody(request2);
                                            try {
                                                httpRequestBuilder.setBodyType((TypeInfo) null);
                                            } catch (Exception e) {
                                                e = e;
                                                str = K_LOG_TAG;
                                                KLog_androidKt.getKLog().e(str, "getSearchText error: " + e.getMessage());
                                                message = e.getMessage();
                                                if (message == null) {
                                                }
                                                return new SearchTextResponse(-1, (SearchTextData) null, message, 2, (DefaultConstructorMarker) null);
                                            }
                                        } catch (Exception e2) {
                                            e = e2;
                                            str = K_LOG_TAG;
                                        }
                                    } else {
                                        try {
                                            httpRequestBuilder.setBody(request2);
                                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SearchTextRequest.class);
                                            try {
                                                kType = Reflection.typeOf(SearchTextRequest.class);
                                            } catch (Throwable th) {
                                                kType = null;
                                            }
                                            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
                                        } catch (Exception e3) {
                                            e = e3;
                                            str = K_LOG_TAG;
                                            KLog_androidKt.getKLog().e(str, "getSearchText error: " + e.getMessage());
                                            message = e.getMessage();
                                            if (message == null) {
                                            }
                                            return new SearchTextResponse(-1, (SearchTextData) null, message, 2, (DefaultConstructorMarker) null);
                                        }
                                    }
                                    httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
                                    HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, $this$post$iv);
                                    str2 = K_LOG_TAG;
                                    try {
                                        searchTextApiService$getSearchText$12.L$0 = SpillingKt.nullOutSpilledVariable(buvid);
                                        searchTextApiService$getSearchText$12.L$1 = SpillingKt.nullOutSpilledVariable(request2);
                                        searchTextApiService$getSearchText$12.L$2 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                        searchTextApiService$getSearchText$12.L$3 = SpillingKt.nullOutSpilledVariable(API_URL_STRING);
                                        searchTextApiService$getSearchText$12.L$4 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                        searchTextApiService$getSearchText$12.L$5 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                        searchTextApiService$getSearchText$12.L$6 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                                        searchTextApiService$getSearchText$12.L$7 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                    } catch (Exception e4) {
                                        e = e4;
                                    }
                                    try {
                                        searchTextApiService$getSearchText$12.J$0 = mid;
                                        searchTextApiService$getSearchText$12.I$0 = 0;
                                        searchTextApiService$getSearchText$12.I$1 = 0;
                                        searchTextApiService$getSearchText$12.I$2 = 0;
                                        searchTextApiService$getSearchText$12.I$3 = 0;
                                        searchTextApiService$getSearchText$12.label = 1;
                                        Object execute = httpStatement.execute(searchTextApiService$getSearchText$12);
                                        if (execute == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        $result = execute;
                                        buvid2 = buvid;
                                        request = request2;
                                        mid2 = mid;
                                        try {
                                            str = (HttpResponse) $result;
                                        } catch (Exception e5) {
                                            e = e5;
                                            str = str2;
                                        }
                                        try {
                                            if (Intrinsics.areEqual(str.getStatus(), HttpStatusCode.Companion.getOK())) {
                                                KLog_androidKt.getKLog().e(str2, "getSearchText error: " + str.getStatus());
                                                return new SearchTextResponse(-1, (SearchTextData) null, "Request failed: " + str.getStatus(), 2, (DefaultConstructorMarker) null);
                                            }
                                            str = str2;
                                            HttpClientCall call = str.getCall();
                                            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(SearchTextResponse.class);
                                            try {
                                                kType2 = Reflection.typeOf(SearchTextResponse.class);
                                            } catch (Throwable th2) {
                                                kType2 = null;
                                            }
                                            TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass2, kType2);
                                            searchTextApiService$getSearchText$12.L$0 = SpillingKt.nullOutSpilledVariable(buvid2);
                                            searchTextApiService$getSearchText$12.L$1 = SpillingKt.nullOutSpilledVariable(request);
                                            searchTextApiService$getSearchText$12.L$2 = SpillingKt.nullOutSpilledVariable(str);
                                            searchTextApiService$getSearchText$12.L$3 = SpillingKt.nullOutSpilledVariable(str);
                                            searchTextApiService$getSearchText$12.L$4 = null;
                                            searchTextApiService$getSearchText$12.L$5 = null;
                                            searchTextApiService$getSearchText$12.L$6 = null;
                                            searchTextApiService$getSearchText$12.L$7 = null;
                                            searchTextApiService$getSearchText$12.J$0 = mid2;
                                            searchTextApiService$getSearchText$12.I$0 = 0;
                                            searchTextApiService$getSearchText$12.label = 2;
                                            bodyNullable = call.bodyNullable(typeInfo, searchTextApiService$getSearchText$12);
                                            if (bodyNullable == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            mid3 = mid2;
                                            buvid3 = buvid2;
                                            try {
                                                if (bodyNullable == null) {
                                                    SearchTextResponse rtValue = (SearchTextResponse) bodyNullable;
                                                    return rtValue;
                                                }
                                                throw new NullPointerException("null cannot be cast to non-null type kntr.app.mall.product.details.page.api.SearchTextApiService.SearchTextResponse");
                                            } catch (Exception e6) {
                                                e = e6;
                                                KLog_androidKt.getKLog().e(str, "getSearchText error: " + e.getMessage());
                                                message = e.getMessage();
                                                if (message == null) {
                                                }
                                                return new SearchTextResponse(-1, (SearchTextData) null, message, 2, (DefaultConstructorMarker) null);
                                            }
                                        } catch (Exception e7) {
                                            e = e7;
                                            KLog_androidKt.getKLog().e(str, "getSearchText error: " + e.getMessage());
                                            message = e.getMessage();
                                            if (message == null) {
                                            }
                                            return new SearchTextResponse(-1, (SearchTextData) null, message, 2, (DefaultConstructorMarker) null);
                                        }
                                    } catch (Exception e8) {
                                        e = e8;
                                        str = str2;
                                        KLog_androidKt.getKLog().e(str, "getSearchText error: " + e.getMessage());
                                        message = e.getMessage();
                                        if (message == null) {
                                            message = "Unknown error";
                                        }
                                        return new SearchTextResponse(-1, (SearchTextData) null, message, 2, (DefaultConstructorMarker) null);
                                    }
                                } catch (Exception e9) {
                                    e = e9;
                                    str = K_LOG_TAG;
                                }
                            case 1:
                                int i = searchTextApiService$getSearchText$12.I$3;
                                int i2 = searchTextApiService$getSearchText$12.I$2;
                                int i3 = searchTextApiService$getSearchText$12.I$1;
                                int i4 = searchTextApiService$getSearchText$12.I$0;
                                mid2 = searchTextApiService$getSearchText$12.J$0;
                                HttpClient httpClient = (HttpClient) searchTextApiService$getSearchText$12.L$7;
                                HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) searchTextApiService$getSearchText$12.L$6;
                                HttpClient httpClient2 = (HttpClient) searchTextApiService$getSearchText$12.L$5;
                                HttpClient httpClient3 = (HttpClient) searchTextApiService$getSearchText$12.L$4;
                                String str3 = (String) searchTextApiService$getSearchText$12.L$3;
                                HttpClient httpClient4 = (HttpClient) searchTextApiService$getSearchText$12.L$2;
                                request = (SearchTextRequest) searchTextApiService$getSearchText$12.L$1;
                                String buvid4 = (String) searchTextApiService$getSearchText$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    buvid2 = buvid4;
                                    str2 = K_LOG_TAG;
                                    str = (HttpResponse) $result;
                                    if (Intrinsics.areEqual(str.getStatus(), HttpStatusCode.Companion.getOK())) {
                                    }
                                } catch (Exception e10) {
                                    e = e10;
                                    str = K_LOG_TAG;
                                    KLog_androidKt.getKLog().e(str, "getSearchText error: " + e.getMessage());
                                    message = e.getMessage();
                                    if (message == null) {
                                    }
                                    return new SearchTextResponse(-1, (SearchTextData) null, message, 2, (DefaultConstructorMarker) null);
                                }
                                break;
                            case 2:
                                int i5 = searchTextApiService$getSearchText$12.I$0;
                                mid3 = searchTextApiService$getSearchText$12.J$0;
                                HttpResponse httpResponse = (HttpResponse) searchTextApiService$getSearchText$12.L$3;
                                HttpResponse httpResponse2 = (HttpResponse) searchTextApiService$getSearchText$12.L$2;
                                SearchTextRequest searchTextRequest = (SearchTextRequest) searchTextApiService$getSearchText$12.L$1;
                                buvid3 = (String) searchTextApiService$getSearchText$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    str = K_LOG_TAG;
                                    bodyNullable = $result;
                                    if (bodyNullable == null) {
                                    }
                                } catch (Exception e11) {
                                    e = e11;
                                    str = K_LOG_TAG;
                                    KLog_androidKt.getKLog().e(str, "getSearchText error: " + e.getMessage());
                                    message = e.getMessage();
                                    if (message == null) {
                                    }
                                    return new SearchTextResponse(-1, (SearchTextData) null, message, 2, (DefaultConstructorMarker) null);
                                }
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
                searchTextApiService$getSearchText$1 = new SearchTextApiService$getSearchText$1(this, continuation);
                searchTextApiService$getSearchText$12 = searchTextApiService$getSearchText$1;
                Object $result2 = searchTextApiService$getSearchText$12.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (searchTextApiService$getSearchText$12.label) {
                }
            }
        }