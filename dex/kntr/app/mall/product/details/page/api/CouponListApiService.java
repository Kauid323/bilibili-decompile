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
import kntr.app.mall.product.details.page.api.CouponListApiService;
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
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

/* compiled from: CouponListApiService.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u0080@¢\u0006\u0004\b\u000f\u0010\u0010JB\u0010\u0011\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u0080@¢\u0006\u0004\b\u0012\u0010\u0010J*\u0010\u0013\u001a\u00020\u00142\u0018\b\u0002\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0016H\u0080@¢\u0006\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkntr/app/mall/product/details/page/api/CouponListApiService;", "", "<init>", "()V", "API_URL_STRING", "", "K_LOG_TAG", "getCouponList", "Lkntr/app/mall/product/details/page/api/CouponListResponse;", "mid", "personalStatus", "", "sourceAuthorityIdList", "", "sourceId", "getCouponList$product_details_page_debug", "(Ljava/lang/String;Ljava/lang/Byte;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mallKntrGetCouponList", "mallKntrGetCouponList$product_details_page_debug", "mallKntrReceiveCoupon", "Lkntr/app/mall/product/details/page/api/CouponListApiService$CouponReceiveResposne;", "params", "", "mallKntrReceiveCoupon$product_details_page_debug", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CouponListRequest", "CouponReceiveResposne", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CouponListApiService {
    public static final int $stable = 0;
    private static final String API_URL_STRING = "https://mall.bilibili.com/mall-marketing-c/coupon/user_coupon_list";
    public static final CouponListApiService INSTANCE = new CouponListApiService();
    private static final String K_LOG_TAG = "NA_WR_CouponListApiService";

    private CouponListApiService() {
    }

    /* compiled from: CouponListApiService.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nBI\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J@\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\fHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006-"}, d2 = {"Lkntr/app/mall/product/details/page/api/CouponListApiService$CouponListRequest;", "", "mid", "", "personalStatus", "", "sourceAuthorityIdList", "", "sourceId", "<init>", "(Ljava/lang/String;Ljava/lang/Byte;Ljava/util/List;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Byte;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMid", "()Ljava/lang/String;", "getPersonalStatus", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getSourceAuthorityIdList", "()Ljava/util/List;", "getSourceId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Byte;Ljava/util/List;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/CouponListApiService$CouponListRequest;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CouponListRequest {
        private final String mid;
        private final Byte personalStatus;
        private final List<String> sourceAuthorityIdList;
        private final String sourceId;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.CouponListApiService$CouponListRequest$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = CouponListApiService.CouponListRequest._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), null};

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CouponListRequest copy$default(CouponListRequest couponListRequest, String str, Byte b, List list, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = couponListRequest.mid;
            }
            if ((i & 2) != 0) {
                b = couponListRequest.personalStatus;
            }
            if ((i & 4) != 0) {
                list = couponListRequest.sourceAuthorityIdList;
            }
            if ((i & 8) != 0) {
                str2 = couponListRequest.sourceId;
            }
            return couponListRequest.copy(str, b, list, str2);
        }

        public final String component1() {
            return this.mid;
        }

        public final Byte component2() {
            return this.personalStatus;
        }

        public final List<String> component3() {
            return this.sourceAuthorityIdList;
        }

        public final String component4() {
            return this.sourceId;
        }

        public final CouponListRequest copy(String str, Byte b, List<String> list, String str2) {
            Intrinsics.checkNotNullParameter(list, "sourceAuthorityIdList");
            Intrinsics.checkNotNullParameter(str2, "sourceId");
            return new CouponListRequest(str, b, list, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CouponListRequest) {
                CouponListRequest couponListRequest = (CouponListRequest) obj;
                return Intrinsics.areEqual(this.mid, couponListRequest.mid) && Intrinsics.areEqual(this.personalStatus, couponListRequest.personalStatus) && Intrinsics.areEqual(this.sourceAuthorityIdList, couponListRequest.sourceAuthorityIdList) && Intrinsics.areEqual(this.sourceId, couponListRequest.sourceId);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.mid == null ? 0 : this.mid.hashCode()) * 31) + (this.personalStatus != null ? this.personalStatus.hashCode() : 0)) * 31) + this.sourceAuthorityIdList.hashCode()) * 31) + this.sourceId.hashCode();
        }

        public String toString() {
            String str = this.mid;
            Byte b = this.personalStatus;
            List<String> list = this.sourceAuthorityIdList;
            return "CouponListRequest(mid=" + str + ", personalStatus=" + b + ", sourceAuthorityIdList=" + list + ", sourceId=" + this.sourceId + ")";
        }

        /* compiled from: CouponListApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CouponListApiService$CouponListRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CouponListApiService$CouponListRequest;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CouponListRequest> serializer() {
                return CouponListApiService$CouponListRequest$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ CouponListRequest(int seen0, String mid, Byte personalStatus, List sourceAuthorityIdList, String sourceId, SerializationConstructorMarker serializationConstructorMarker) {
            if (12 != (seen0 & 12)) {
                PluginExceptionsKt.throwMissingFieldException(seen0, 12, CouponListApiService$CouponListRequest$$serializer.INSTANCE.getDescriptor());
            }
            if ((seen0 & 1) == 0) {
                this.mid = null;
            } else {
                this.mid = mid;
            }
            if ((seen0 & 2) == 0) {
                this.personalStatus = null;
            } else {
                this.personalStatus = personalStatus;
            }
            this.sourceAuthorityIdList = sourceAuthorityIdList;
            this.sourceId = sourceId;
        }

        public CouponListRequest(String mid, Byte personalStatus, List<String> list, String sourceId) {
            Intrinsics.checkNotNullParameter(list, "sourceAuthorityIdList");
            Intrinsics.checkNotNullParameter(sourceId, "sourceId");
            this.mid = mid;
            this.personalStatus = personalStatus;
            this.sourceAuthorityIdList = list;
            this.sourceId = sourceId;
        }

        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(CouponListRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.mid != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.mid);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.personalStatus != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, ByteSerializer.INSTANCE, self.personalStatus);
            }
            output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.sourceAuthorityIdList);
            output.encodeStringElement(serialDesc, 3, self.sourceId);
        }

        public /* synthetic */ CouponListRequest(String str, Byte b, List list, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : b, list, str2);
        }

        public final String getMid() {
            return this.mid;
        }

        public final Byte getPersonalStatus() {
            return this.personalStatus;
        }

        public final List<String> getSourceAuthorityIdList() {
            return this.sourceAuthorityIdList;
        }

        public final String getSourceId() {
            return this.sourceId;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01c8 A[Catch: Exception -> 0x027e, TryCatch #2 {Exception -> 0x027e, blocks: (B:138:0x01b5, B:140:0x01c8, B:142:0x0209, B:149:0x0222), top: B:172:0x01b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0209 A[Catch: Exception -> 0x027e, TRY_LEAVE, TryCatch #2 {Exception -> 0x027e, blocks: (B:138:0x01b5, B:140:0x01c8, B:142:0x0209, B:149:0x0222), top: B:172:0x01b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0269 A[Catch: Exception -> 0x026d, TRY_ENTER, TryCatch #4 {Exception -> 0x026d, blocks: (B:154:0x0269, B:158:0x0275, B:159:0x027d), top: B:175:0x0267 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0275 A[Catch: Exception -> 0x026d, TryCatch #4 {Exception -> 0x026d, blocks: (B:154:0x0269, B:158:0x0275, B:159:0x027d), top: B:175:0x0267 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getCouponList$product_details_page_debug(String mid, Byte personalStatus, List<String> list, String sourceId, Continuation<? super CouponListResponse> continuation) {
        CouponListApiService$getCouponList$1 couponListApiService$getCouponList$1;
        CouponListApiService$getCouponList$1 couponListApiService$getCouponList$12;
        KType kType;
        String mid2;
        Byte personalStatus2;
        List<String> list2;
        String sourceId2;
        HttpResponse response;
        KType kType2;
        Object bodyNullable;
        List<String> list3;
        Byte personalStatus3;
        String mid3;
        if (continuation instanceof CouponListApiService$getCouponList$1) {
            couponListApiService$getCouponList$1 = (CouponListApiService$getCouponList$1) continuation;
            if ((couponListApiService$getCouponList$1.label & Integer.MIN_VALUE) != 0) {
                couponListApiService$getCouponList$1.label -= Integer.MIN_VALUE;
                couponListApiService$getCouponList$12 = couponListApiService$getCouponList$1;
                Object $result = couponListApiService$getCouponList$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (couponListApiService$getCouponList$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            HttpClient $this$post$iv = Client.INSTANCE.getHttpClient();
                            HttpMessageBuilder httpRequestBuilder = new HttpRequestBuilder();
                            HttpRequestKt.url(httpRequestBuilder, API_URL_STRING);
                            HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
                            try {
                                Object body$iv = new CouponListRequest(mid, personalStatus, list, sourceId);
                                if (body$iv instanceof OutgoingContent) {
                                    try {
                                        httpRequestBuilder.setBody(body$iv);
                                        httpRequestBuilder.setBodyType((TypeInfo) null);
                                    } catch (Exception e) {
                                        e = e;
                                        KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch coupon list: " + e.getMessage(), e);
                                        return new CouponListResponse(-1L, "Failed to fetch coupon list: " + e.getMessage(), 0, (List) null, 12, (DefaultConstructorMarker) null);
                                    }
                                } else {
                                    httpRequestBuilder.setBody(body$iv);
                                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(CouponListRequest.class);
                                    try {
                                        kType = Reflection.typeOf(CouponListRequest.class);
                                    } catch (Throwable th) {
                                        kType = null;
                                    }
                                    httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
                                }
                                httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
                                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, $this$post$iv);
                                couponListApiService$getCouponList$12.L$0 = SpillingKt.nullOutSpilledVariable(mid);
                                couponListApiService$getCouponList$12.L$1 = SpillingKt.nullOutSpilledVariable(personalStatus);
                                couponListApiService$getCouponList$12.L$2 = SpillingKt.nullOutSpilledVariable(list);
                                couponListApiService$getCouponList$12.L$3 = SpillingKt.nullOutSpilledVariable(sourceId);
                                couponListApiService$getCouponList$12.L$4 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                couponListApiService$getCouponList$12.L$5 = SpillingKt.nullOutSpilledVariable(API_URL_STRING);
                                couponListApiService$getCouponList$12.L$6 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                couponListApiService$getCouponList$12.L$7 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                couponListApiService$getCouponList$12.L$8 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                                couponListApiService$getCouponList$12.L$9 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                couponListApiService$getCouponList$12.I$0 = 0;
                                couponListApiService$getCouponList$12.I$1 = 0;
                                couponListApiService$getCouponList$12.I$2 = 0;
                                couponListApiService$getCouponList$12.I$3 = 0;
                                couponListApiService$getCouponList$12.label = 1;
                                $result = httpStatement.execute(couponListApiService$getCouponList$12);
                                if ($result == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                mid2 = mid;
                                personalStatus2 = personalStatus;
                                list2 = list;
                                sourceId2 = sourceId;
                                try {
                                    response = (HttpResponse) $result;
                                    if (Intrinsics.areEqual(response.getStatus(), HttpStatusCode.Companion.getOK())) {
                                        KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch coupon list: " + response.getStatus());
                                        return new CouponListResponse(-1L, "Failed to fetch coupon list: " + response.getStatus(), 0, (List) null, 12, (DefaultConstructorMarker) null);
                                    }
                                    HttpClientCall call = response.getCall();
                                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(CouponListResponse.class);
                                    try {
                                        kType2 = Reflection.typeOf(CouponListResponse.class);
                                    } catch (Throwable th2) {
                                        kType2 = null;
                                    }
                                    TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass2, kType2);
                                    couponListApiService$getCouponList$12.L$0 = SpillingKt.nullOutSpilledVariable(mid2);
                                    couponListApiService$getCouponList$12.L$1 = SpillingKt.nullOutSpilledVariable(personalStatus2);
                                    couponListApiService$getCouponList$12.L$2 = SpillingKt.nullOutSpilledVariable(list2);
                                    couponListApiService$getCouponList$12.L$3 = SpillingKt.nullOutSpilledVariable(sourceId2);
                                    couponListApiService$getCouponList$12.L$4 = SpillingKt.nullOutSpilledVariable(response);
                                    couponListApiService$getCouponList$12.L$5 = SpillingKt.nullOutSpilledVariable(response);
                                    couponListApiService$getCouponList$12.L$6 = null;
                                    couponListApiService$getCouponList$12.L$7 = null;
                                    couponListApiService$getCouponList$12.L$8 = null;
                                    couponListApiService$getCouponList$12.L$9 = null;
                                    couponListApiService$getCouponList$12.I$0 = 0;
                                    couponListApiService$getCouponList$12.label = 2;
                                    bodyNullable = call.bodyNullable(typeInfo, couponListApiService$getCouponList$12);
                                    if (bodyNullable == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    list3 = list2;
                                    personalStatus3 = personalStatus2;
                                    mid3 = mid2;
                                    try {
                                        if (bodyNullable == null) {
                                            CouponListResponse retValue = (CouponListResponse) bodyNullable;
                                            return retValue;
                                        }
                                        throw new NullPointerException("null cannot be cast to non-null type kntr.app.mall.product.details.page.api.CouponListResponse");
                                    } catch (Exception e2) {
                                        e = e2;
                                        KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch coupon list: " + e.getMessage(), e);
                                        return new CouponListResponse(-1L, "Failed to fetch coupon list: " + e.getMessage(), 0, (List) null, 12, (DefaultConstructorMarker) null);
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch coupon list: " + e.getMessage(), e);
                                    return new CouponListResponse(-1L, "Failed to fetch coupon list: " + e.getMessage(), 0, (List) null, 12, (DefaultConstructorMarker) null);
                                }
                            } catch (Exception e4) {
                                e = e4;
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    case 1:
                        int i = couponListApiService$getCouponList$12.I$3;
                        int i2 = couponListApiService$getCouponList$12.I$2;
                        int i3 = couponListApiService$getCouponList$12.I$1;
                        int i4 = couponListApiService$getCouponList$12.I$0;
                        HttpClient httpClient = (HttpClient) couponListApiService$getCouponList$12.L$9;
                        HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) couponListApiService$getCouponList$12.L$8;
                        HttpClient httpClient2 = (HttpClient) couponListApiService$getCouponList$12.L$7;
                        HttpClient httpClient3 = (HttpClient) couponListApiService$getCouponList$12.L$6;
                        String str = (String) couponListApiService$getCouponList$12.L$5;
                        HttpClient httpClient4 = (HttpClient) couponListApiService$getCouponList$12.L$4;
                        String sourceId3 = (String) couponListApiService$getCouponList$12.L$3;
                        list2 = (List) couponListApiService$getCouponList$12.L$2;
                        personalStatus2 = (Byte) couponListApiService$getCouponList$12.L$1;
                        mid2 = (String) couponListApiService$getCouponList$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            sourceId2 = sourceId3;
                            response = (HttpResponse) $result;
                            if (Intrinsics.areEqual(response.getStatus(), HttpStatusCode.Companion.getOK())) {
                            }
                        } catch (Exception e6) {
                            e = e6;
                            KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch coupon list: " + e.getMessage(), e);
                            return new CouponListResponse(-1L, "Failed to fetch coupon list: " + e.getMessage(), 0, (List) null, 12, (DefaultConstructorMarker) null);
                        }
                        break;
                    case 2:
                        int i5 = couponListApiService$getCouponList$12.I$0;
                        HttpResponse httpResponse = (HttpResponse) couponListApiService$getCouponList$12.L$5;
                        HttpResponse httpResponse2 = (HttpResponse) couponListApiService$getCouponList$12.L$4;
                        String str2 = (String) couponListApiService$getCouponList$12.L$3;
                        list3 = (List) couponListApiService$getCouponList$12.L$2;
                        personalStatus3 = (Byte) couponListApiService$getCouponList$12.L$1;
                        mid3 = (String) couponListApiService$getCouponList$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            bodyNullable = $result;
                            if (bodyNullable == null) {
                            }
                        } catch (Exception e7) {
                            e = e7;
                            KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch coupon list: " + e.getMessage(), e);
                            return new CouponListResponse(-1L, "Failed to fetch coupon list: " + e.getMessage(), 0, (List) null, 12, (DefaultConstructorMarker) null);
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        couponListApiService$getCouponList$1 = new CouponListApiService$getCouponList$1(this, continuation);
        couponListApiService$getCouponList$12 = couponListApiService$getCouponList$1;
        Object $result2 = couponListApiService$getCouponList$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (couponListApiService$getCouponList$12.label) {
        }
    }

    public static /* synthetic */ Object mallKntrGetCouponList$product_details_page_debug$default(CouponListApiService couponListApiService, String str, Byte b, List list, String str2, Continuation continuation, int i, Object obj) {
        return couponListApiService.mallKntrGetCouponList$product_details_page_debug((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : b, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? "" : str2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mallKntrGetCouponList$product_details_page_debug(String mid, Byte personalStatus, List<String> list, String sourceId, Continuation<? super CouponListResponse> continuation) {
        CouponListApiService$mallKntrGetCouponList$1 couponListApiService$mallKntrGetCouponList$1;
        CouponListApiService$mallKntrGetCouponList$1 couponListApiService$mallKntrGetCouponList$12;
        List<String> list2;
        Exception e$iv;
        Client $this$iv;
        Object obj;
        List<String> list3;
        Client $this$iv2;
        if (continuation instanceof CouponListApiService$mallKntrGetCouponList$1) {
            couponListApiService$mallKntrGetCouponList$1 = (CouponListApiService$mallKntrGetCouponList$1) continuation;
            if ((couponListApiService$mallKntrGetCouponList$1.label & Integer.MIN_VALUE) != 0) {
                couponListApiService$mallKntrGetCouponList$1.label -= Integer.MIN_VALUE;
                couponListApiService$mallKntrGetCouponList$12 = couponListApiService$mallKntrGetCouponList$1;
                Object $result = couponListApiService$mallKntrGetCouponList$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (couponListApiService$mallKntrGetCouponList$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            Client $this$iv3 = Client.INSTANCE;
                            Pair[] pairArr = new Pair[4];
                            try {
                                pairArr[0] = TuplesKt.to("mid", mid);
                                try {
                                    pairArr[1] = TuplesKt.to("personalStatus", personalStatus);
                                    list2 = list;
                                    try {
                                        pairArr[2] = TuplesKt.to("sourceAuthorityIdList", list2);
                                        try {
                                            pairArr[3] = TuplesKt.to("sourceId", sourceId);
                                            Map params$iv = MapsKt.mapOf(pairArr);
                                            try {
                                                couponListApiService$mallKntrGetCouponList$12.L$0 = SpillingKt.nullOutSpilledVariable(mid);
                                                couponListApiService$mallKntrGetCouponList$12.L$1 = SpillingKt.nullOutSpilledVariable(personalStatus);
                                                couponListApiService$mallKntrGetCouponList$12.L$2 = SpillingKt.nullOutSpilledVariable(list);
                                                couponListApiService$mallKntrGetCouponList$12.L$3 = SpillingKt.nullOutSpilledVariable(sourceId);
                                                couponListApiService$mallKntrGetCouponList$12.L$4 = $this$iv3;
                                                couponListApiService$mallKntrGetCouponList$12.L$5 = SpillingKt.nullOutSpilledVariable(API_URL_STRING);
                                                couponListApiService$mallKntrGetCouponList$12.L$6 = SpillingKt.nullOutSpilledVariable("POST");
                                                couponListApiService$mallKntrGetCouponList$12.L$7 = SpillingKt.nullOutSpilledVariable(params$iv);
                                                couponListApiService$mallKntrGetCouponList$12.I$0 = 0;
                                                couponListApiService$mallKntrGetCouponList$12.label = 1;
                                                Object mallKntrAsyncRequest = MallEnvKt.mallKntrAsyncRequest(API_URL_STRING, "POST", (Map) null, params$iv, couponListApiService$mallKntrGetCouponList$12);
                                                if (mallKntrAsyncRequest == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                obj = mallKntrAsyncRequest;
                                                list3 = list2;
                                                $this$iv2 = $this$iv3;
                                                try {
                                                    String jsonString$iv = (String) obj;
                                                    Json this_$iv$iv = $this$iv2.getJson();
                                                    Intrinsics.checkNotNull(jsonString$iv);
                                                    this_$iv$iv.getSerializersModule();
                                                    Object res$iv = this_$iv$iv.decodeFromString(CouponListResponse.Companion.serializer(), jsonString$iv);
                                                    try {
                                                        return (CouponListResponse) res$iv;
                                                    } catch (Exception e) {
                                                        e = e;
                                                        list2 = list3;
                                                        KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch coupon list: " + e.getMessage(), e);
                                                        return new CouponListResponse(-1L, "Failed to fetch coupon list: " + e.getMessage(), 0, (List) null, 12, (DefaultConstructorMarker) null);
                                                    }
                                                } catch (Exception e2) {
                                                    e$iv = e2;
                                                    $this$iv = $this$iv2;
                                                    list2 = list3;
                                                    try {
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                    }
                                                    try {
                                                        KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                                        throw e$iv;
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch coupon list: " + e.getMessage(), e);
                                                        return new CouponListResponse(-1L, "Failed to fetch coupon list: " + e.getMessage(), 0, (List) null, 12, (DefaultConstructorMarker) null);
                                                    }
                                                }
                                            } catch (Exception e5) {
                                                e$iv = e5;
                                                $this$iv = $this$iv3;
                                                KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                                throw e$iv;
                                            }
                                        } catch (Exception e6) {
                                            e = e6;
                                            KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch coupon list: " + e.getMessage(), e);
                                            return new CouponListResponse(-1L, "Failed to fetch coupon list: " + e.getMessage(), 0, (List) null, 12, (DefaultConstructorMarker) null);
                                        }
                                    } catch (Exception e7) {
                                        e = e7;
                                    }
                                } catch (Exception e8) {
                                    e = e8;
                                    list2 = list;
                                }
                            } catch (Exception e9) {
                                e = e9;
                                list2 = list;
                            }
                        } catch (Exception e10) {
                            e = e10;
                            list2 = list;
                        }
                    case 1:
                        int i = couponListApiService$mallKntrGetCouponList$12.I$0;
                        Map map = (Map) couponListApiService$mallKntrGetCouponList$12.L$7;
                        String str = (String) couponListApiService$mallKntrGetCouponList$12.L$6;
                        String str2 = (String) couponListApiService$mallKntrGetCouponList$12.L$5;
                        Client $this$iv4 = (Client) couponListApiService$mallKntrGetCouponList$12.L$4;
                        String str3 = (String) couponListApiService$mallKntrGetCouponList$12.L$3;
                        list3 = (List) couponListApiService$mallKntrGetCouponList$12.L$2;
                        Byte b = (Byte) couponListApiService$mallKntrGetCouponList$12.L$1;
                        String str4 = (String) couponListApiService$mallKntrGetCouponList$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            obj = $result;
                            $this$iv2 = $this$iv4;
                            String jsonString$iv2 = (String) obj;
                            Json this_$iv$iv2 = $this$iv2.getJson();
                            Intrinsics.checkNotNull(jsonString$iv2);
                            this_$iv$iv2.getSerializersModule();
                            Object res$iv2 = this_$iv$iv2.decodeFromString(CouponListResponse.Companion.serializer(), jsonString$iv2);
                            return (CouponListResponse) res$iv2;
                        } catch (Exception e11) {
                            e$iv = e11;
                            $this$iv = $this$iv4;
                            list2 = list3;
                            KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                            throw e$iv;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        couponListApiService$mallKntrGetCouponList$1 = new CouponListApiService$mallKntrGetCouponList$1(this, continuation);
        couponListApiService$mallKntrGetCouponList$12 = couponListApiService$mallKntrGetCouponList$1;
        Object $result2 = couponListApiService$mallKntrGetCouponList$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (couponListApiService$mallKntrGetCouponList$12.label) {
        }
    }

    /* compiled from: CouponListApiService.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006*"}, d2 = {"Lkntr/app/mall/product/details/page/api/CouponListApiService$CouponReceiveResposne;", "", "code", "", "message", "", "errtag", "data", "Lkotlinx/serialization/json/JsonElement;", "<init>", "(ILjava/lang/String;ILkotlinx/serialization/json/JsonElement;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;ILkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getErrtag", "getData", "()Lkotlinx/serialization/json/JsonElement;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CouponReceiveResposne {
        private final int code;
        private final JsonElement data;
        private final int errtag;
        private final String message;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public CouponReceiveResposne() {
            this(0, (String) null, 0, (JsonElement) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ CouponReceiveResposne copy$default(CouponReceiveResposne couponReceiveResposne, int i, String str, int i2, JsonElement jsonElement, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = couponReceiveResposne.code;
            }
            if ((i3 & 2) != 0) {
                str = couponReceiveResposne.message;
            }
            if ((i3 & 4) != 0) {
                i2 = couponReceiveResposne.errtag;
            }
            if ((i3 & 8) != 0) {
                jsonElement = couponReceiveResposne.data;
            }
            return couponReceiveResposne.copy(i, str, i2, jsonElement);
        }

        public final int component1() {
            return this.code;
        }

        public final String component2() {
            return this.message;
        }

        public final int component3() {
            return this.errtag;
        }

        public final JsonElement component4() {
            return this.data;
        }

        public final CouponReceiveResposne copy(int i, String str, int i2, JsonElement jsonElement) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new CouponReceiveResposne(i, str, i2, jsonElement);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CouponReceiveResposne) {
                CouponReceiveResposne couponReceiveResposne = (CouponReceiveResposne) obj;
                return this.code == couponReceiveResposne.code && Intrinsics.areEqual(this.message, couponReceiveResposne.message) && this.errtag == couponReceiveResposne.errtag && Intrinsics.areEqual(this.data, couponReceiveResposne.data);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.code * 31) + this.message.hashCode()) * 31) + this.errtag) * 31) + (this.data == null ? 0 : this.data.hashCode());
        }

        public String toString() {
            int i = this.code;
            String str = this.message;
            int i2 = this.errtag;
            return "CouponReceiveResposne(code=" + i + ", message=" + str + ", errtag=" + i2 + ", data=" + this.data + ")";
        }

        /* compiled from: CouponListApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CouponListApiService$CouponReceiveResposne$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CouponListApiService$CouponReceiveResposne;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CouponReceiveResposne> serializer() {
                return new GeneratedSerializer<CouponReceiveResposne>() { // from class: kntr.app.mall.product.details.page.api.CouponListApiService$CouponReceiveResposne$$serializer
                    public static final int $stable;
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.CouponListApiService.CouponReceiveResposne", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.CouponListApiService$CouponReceiveResposne> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.CouponListApiService$CouponReceiveResposne> A[REMOVE]) =  kntr.app.mall.product.details.page.api.CouponListApiService$CouponReceiveResposne$$serializer.INSTANCE kntr.app.mall.product.details.page.api.CouponListApiService$CouponReceiveResposne$$serializer)
                             in method: kntr.app.mall.product.details.page.api.CouponListApiService.CouponReceiveResposne.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.CouponListApiService$CouponReceiveResposne>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                              ("kntr.app.mall.product.details.page.api.CouponListApiService.CouponReceiveResposne")
                              (wrap: kntr.app.mall.product.details.page.api.CouponListApiService$CouponReceiveResposne$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.CouponListApiService$CouponReceiveResposne$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.CouponListApiService$CouponReceiveResposne$$serializer.INSTANCE kntr.app.mall.product.details.page.api.CouponListApiService$CouponReceiveResposne$$serializer)
                              (4 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.CouponListApiService$CouponReceiveResposne$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.CouponListApiService$CouponReceiveResposne$$serializer
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
                            kntr.app.mall.product.details.page.api.CouponListApiService$CouponReceiveResposne$$serializer r0 = kntr.app.mall.product.details.page.api.CouponListApiService$CouponReceiveResposne$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.CouponListApiService.CouponReceiveResposne.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ CouponReceiveResposne(int seen0, int code, String message, int errtag, JsonElement data, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.code = 0;
                    } else {
                        this.code = code;
                    }
                    if ((seen0 & 2) == 0) {
                        this.message = "";
                    } else {
                        this.message = message;
                    }
                    if ((seen0 & 4) == 0) {
                        this.errtag = 0;
                    } else {
                        this.errtag = errtag;
                    }
                    if ((seen0 & 8) == 0) {
                        this.data = null;
                    } else {
                        this.data = data;
                    }
                }

                public CouponReceiveResposne(int code, String message, int errtag, JsonElement data) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    this.code = code;
                    this.message = message;
                    this.errtag = errtag;
                    this.data = data;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(CouponReceiveResposne self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.code != 0) {
                        output.encodeIntElement(serialDesc, 0, self.code);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.message, "")) {
                        output.encodeStringElement(serialDesc, 1, self.message);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.errtag != 0) {
                        output.encodeIntElement(serialDesc, 2, self.errtag);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.data != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, JsonElementSerializer.INSTANCE, self.data);
                    }
                }

                public /* synthetic */ CouponReceiveResposne(int i, String str, int i2, JsonElement jsonElement, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? null : jsonElement);
                }

                public final int getCode() {
                    return this.code;
                }

                public final String getMessage() {
                    return this.message;
                }

                public final int getErrtag() {
                    return this.errtag;
                }

                public final JsonElement getData() {
                    return this.data;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Object mallKntrReceiveCoupon$product_details_page_debug$default(CouponListApiService couponListApiService, Map map, Continuation continuation, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = null;
                }
                return couponListApiService.mallKntrReceiveCoupon$product_details_page_debug(map, continuation);
            }

            /* JADX WARN: Removed duplicated region for block: B:59:0x002b  */
            /* JADX WARN: Removed duplicated region for block: B:61:0x0033  */
            /* JADX WARN: Removed duplicated region for block: B:66:0x005b  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object mallKntrReceiveCoupon$product_details_page_debug(Map<String, ? extends Object> map, Continuation<? super CouponReceiveResposne> continuation) {
                CouponListApiService$mallKntrReceiveCoupon$1 couponListApiService$mallKntrReceiveCoupon$1;
                CouponListApiService$mallKntrReceiveCoupon$1 couponListApiService$mallKntrReceiveCoupon$12;
                Client this_$iv;
                Object obj;
                try {
                    if (continuation instanceof CouponListApiService$mallKntrReceiveCoupon$1) {
                        couponListApiService$mallKntrReceiveCoupon$1 = (CouponListApiService$mallKntrReceiveCoupon$1) continuation;
                        if ((couponListApiService$mallKntrReceiveCoupon$1.label & Integer.MIN_VALUE) != 0) {
                            couponListApiService$mallKntrReceiveCoupon$1.label -= Integer.MIN_VALUE;
                            couponListApiService$mallKntrReceiveCoupon$12 = couponListApiService$mallKntrReceiveCoupon$1;
                            Object $result = couponListApiService$mallKntrReceiveCoupon$12.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (couponListApiService$mallKntrReceiveCoupon$12.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    try {
                                        Client client = Client.INSTANCE;
                                        Map headers$iv = MapsKt.mapOf(TuplesKt.to("Content-Type", "application/json"));
                                        this_$iv = client;
                                        Map params$iv = map == null ? MapsKt.emptyMap() : map;
                                        try {
                                            couponListApiService$mallKntrReceiveCoupon$12.L$0 = SpillingKt.nullOutSpilledVariable(map);
                                            couponListApiService$mallKntrReceiveCoupon$12.L$1 = this_$iv;
                                            couponListApiService$mallKntrReceiveCoupon$12.L$2 = SpillingKt.nullOutSpilledVariable("https://mall.bilibili.com/mall-marketing-c/coupon/receivecoupon");
                                            couponListApiService$mallKntrReceiveCoupon$12.L$3 = SpillingKt.nullOutSpilledVariable("POST");
                                            couponListApiService$mallKntrReceiveCoupon$12.L$4 = SpillingKt.nullOutSpilledVariable(headers$iv);
                                            couponListApiService$mallKntrReceiveCoupon$12.L$5 = SpillingKt.nullOutSpilledVariable(params$iv);
                                            couponListApiService$mallKntrReceiveCoupon$12.I$0 = 0;
                                            couponListApiService$mallKntrReceiveCoupon$12.label = 1;
                                            Object mallKntrAsyncRequest = MallEnvKt.mallKntrAsyncRequest("https://mall.bilibili.com/mall-marketing-c/coupon/receivecoupon", "POST", headers$iv, params$iv, couponListApiService$mallKntrReceiveCoupon$12);
                                            if (mallKntrAsyncRequest == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            obj = mallKntrAsyncRequest;
                                            String jsonString$iv = (String) obj;
                                            Json this_$iv$iv = this_$iv.getJson();
                                            Intrinsics.checkNotNull(jsonString$iv);
                                            this_$iv$iv.getSerializersModule();
                                            Object res$iv = this_$iv$iv.decodeFromString(CouponReceiveResposne.Companion.serializer(), jsonString$iv);
                                            return (CouponReceiveResposne) res$iv;
                                        } catch (Exception e) {
                                            e$iv = e;
                                            KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                            throw e$iv;
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch coupon: " + e.getMessage(), e);
                                        return new CouponReceiveResposne(-1, "Failed to fetch coupon: " + e.getMessage(), 0, (JsonElement) null, 12, (DefaultConstructorMarker) null);
                                    }
                                case 1:
                                    int i = couponListApiService$mallKntrReceiveCoupon$12.I$0;
                                    Map map2 = (Map) couponListApiService$mallKntrReceiveCoupon$12.L$5;
                                    Map map3 = (Map) couponListApiService$mallKntrReceiveCoupon$12.L$4;
                                    String str = (String) couponListApiService$mallKntrReceiveCoupon$12.L$3;
                                    String str2 = (String) couponListApiService$mallKntrReceiveCoupon$12.L$2;
                                    this_$iv = (Client) couponListApiService$mallKntrReceiveCoupon$12.L$1;
                                    Map map4 = (Map) couponListApiService$mallKntrReceiveCoupon$12.L$0;
                                    try {
                                        ResultKt.throwOnFailure($result);
                                        obj = $result;
                                        String jsonString$iv2 = (String) obj;
                                        Json this_$iv$iv2 = this_$iv.getJson();
                                        Intrinsics.checkNotNull(jsonString$iv2);
                                        this_$iv$iv2.getSerializersModule();
                                        Object res$iv2 = this_$iv$iv2.decodeFromString(CouponReceiveResposne.Companion.serializer(), jsonString$iv2);
                                        return (CouponReceiveResposne) res$iv2;
                                    } catch (Exception e3) {
                                        e$iv = e3;
                                        KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                        throw e$iv;
                                    }
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }
                    switch (couponListApiService$mallKntrReceiveCoupon$12.label) {
                    }
                } catch (Exception e4) {
                    e = e4;
                }
                couponListApiService$mallKntrReceiveCoupon$1 = new CouponListApiService$mallKntrReceiveCoupon$1(this, continuation);
                couponListApiService$mallKntrReceiveCoupon$12 = couponListApiService$mallKntrReceiveCoupon$1;
                Object $result2 = couponListApiService$mallKntrReceiveCoupon$12.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
        }