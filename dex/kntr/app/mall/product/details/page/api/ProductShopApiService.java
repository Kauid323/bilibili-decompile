package kntr.app.mall.product.details.page.api;

import ComposableSingletons$CustomBottomSheetKt$;
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
import kntr.app.mall.product.details.page.api.ProductShopApiService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
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
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: ProductShopApiService.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0080@¢\u0006\u0004\b\r\u0010\u000eJ>\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\t\u001a\u00020\u00112\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0080@¢\u0006\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopApiService;", "", "<init>", "()V", "API_URL_STRING", "", "K_LOG_TAG", "getProductShopDetails", "Lkntr/app/mall/product/details/page/api/ProductShopApiService$ProductShopDetailsResponse;", "merchantId", "", "mSource", "trackId", "getProductShopDetails$product_details_page_debug", "(JLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mallKntrGetProductShopDetails", "itemDetailType", "", "mallKntrGetProductShopDetails$product_details_page_debug", "(Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ProductShopDetailsResponse", "ProductShopDetailsRequest", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ProductShopApiService {
    public static final int $stable = 0;
    private static final String API_URL_STRING = "https://mall.bilibili.com/mall-merchant-c-search/shop/for/item/detail";
    public static final ProductShopApiService INSTANCE = new ProductShopApiService();
    private static final String K_LOG_TAG = "NA_WR_ProductShopApiService";

    private ProductShopApiService() {
    }

    /* compiled from: ProductShopApiService.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0003,-.B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bB?\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\r\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001aJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010 \u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0007HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006/"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopApiService$ProductShopDetailsResponse;", "", "code", "", "errtag", "", "message", "", "data", "Lkntr/app/mall/product/details/page/api/ProductShopApiService$ProductShopDetailsResponse$ProductShopDetailsData;", "<init>", "(JILjava/lang/String;Lkntr/app/mall/product/details/page/api/ProductShopApiService$ProductShopDetailsResponse$ProductShopDetailsData;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJILjava/lang/String;Lkntr/app/mall/product/details/page/api/ProductShopApiService$ProductShopDetailsResponse$ProductShopDetailsData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()J", "getErrtag", "()I", "getMessage", "()Ljava/lang/String;", "getData", "()Lkntr/app/mall/product/details/page/api/ProductShopApiService$ProductShopDetailsResponse$ProductShopDetailsData;", "isValid", "", "isValid$product_details_page_debug", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ProductShopDetailsData", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ProductShopDetailsResponse {
        private final long code;
        private final ProductShopDetailsData data;
        private final int errtag;
        private final String message;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public ProductShopDetailsResponse() {
            this(0L, 0, (String) null, (ProductShopDetailsData) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ProductShopDetailsResponse copy$default(ProductShopDetailsResponse productShopDetailsResponse, long j, int i, String str, ProductShopDetailsData productShopDetailsData, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = productShopDetailsResponse.code;
            }
            long j2 = j;
            if ((i2 & 2) != 0) {
                i = productShopDetailsResponse.errtag;
            }
            int i3 = i;
            if ((i2 & 4) != 0) {
                str = productShopDetailsResponse.message;
            }
            String str2 = str;
            if ((i2 & 8) != 0) {
                productShopDetailsData = productShopDetailsResponse.data;
            }
            return productShopDetailsResponse.copy(j2, i3, str2, productShopDetailsData);
        }

        public final long component1() {
            return this.code;
        }

        public final int component2() {
            return this.errtag;
        }

        public final String component3() {
            return this.message;
        }

        public final ProductShopDetailsData component4() {
            return this.data;
        }

        public final ProductShopDetailsResponse copy(long j, int i, String str, ProductShopDetailsData productShopDetailsData) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new ProductShopDetailsResponse(j, i, str, productShopDetailsData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ProductShopDetailsResponse) {
                ProductShopDetailsResponse productShopDetailsResponse = (ProductShopDetailsResponse) obj;
                return this.code == productShopDetailsResponse.code && this.errtag == productShopDetailsResponse.errtag && Intrinsics.areEqual(this.message, productShopDetailsResponse.message) && Intrinsics.areEqual(this.data, productShopDetailsResponse.data);
            }
            return false;
        }

        public int hashCode() {
            return (((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.code) * 31) + this.errtag) * 31) + this.message.hashCode()) * 31) + (this.data == null ? 0 : this.data.hashCode());
        }

        public String toString() {
            long j = this.code;
            int i = this.errtag;
            String str = this.message;
            return "ProductShopDetailsResponse(code=" + j + ", errtag=" + i + ", message=" + str + ", data=" + this.data + ")";
        }

        /* compiled from: ProductShopApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopApiService$ProductShopDetailsResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ProductShopApiService$ProductShopDetailsResponse;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ProductShopDetailsResponse> serializer() {
                return new GeneratedSerializer<ProductShopDetailsResponse>() { // from class: kntr.app.mall.product.details.page.api.ProductShopApiService$ProductShopDetailsResponse$$serializer
                    public static final int $stable;
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.ProductShopApiService.ProductShopDetailsResponse", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.ProductShopApiService$ProductShopDetailsResponse> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.ProductShopApiService$ProductShopDetailsResponse> A[REMOVE]) =  kntr.app.mall.product.details.page.api.ProductShopApiService$ProductShopDetailsResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.ProductShopApiService$ProductShopDetailsResponse$$serializer)
                             in method: kntr.app.mall.product.details.page.api.ProductShopApiService.ProductShopDetailsResponse.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.ProductShopApiService$ProductShopDetailsResponse>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                              ("kntr.app.mall.product.details.page.api.ProductShopApiService.ProductShopDetailsResponse")
                              (wrap: kntr.app.mall.product.details.page.api.ProductShopApiService$ProductShopDetailsResponse$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.ProductShopApiService$ProductShopDetailsResponse$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.ProductShopApiService$ProductShopDetailsResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.ProductShopApiService$ProductShopDetailsResponse$$serializer)
                              (4 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.ProductShopApiService$ProductShopDetailsResponse$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.ProductShopApiService$ProductShopDetailsResponse$$serializer
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
                            kntr.app.mall.product.details.page.api.ProductShopApiService$ProductShopDetailsResponse$$serializer r0 = kntr.app.mall.product.details.page.api.ProductShopApiService$ProductShopDetailsResponse$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.ProductShopApiService.ProductShopDetailsResponse.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ ProductShopDetailsResponse(int seen0, long code, int errtag, String message, ProductShopDetailsData data, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.code = 0L;
                    } else {
                        this.code = code;
                    }
                    if ((seen0 & 2) == 0) {
                        this.errtag = 0;
                    } else {
                        this.errtag = errtag;
                    }
                    if ((seen0 & 4) == 0) {
                        this.message = "";
                    } else {
                        this.message = message;
                    }
                    if ((seen0 & 8) == 0) {
                        this.data = null;
                    } else {
                        this.data = data;
                    }
                }

                public ProductShopDetailsResponse(long code, int errtag, String message, ProductShopDetailsData data) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    this.code = code;
                    this.errtag = errtag;
                    this.message = message;
                    this.data = data;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(ProductShopDetailsResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.code != 0) {
                        output.encodeLongElement(serialDesc, 0, self.code);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.errtag != 0) {
                        output.encodeIntElement(serialDesc, 1, self.errtag);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.message, "")) {
                        output.encodeStringElement(serialDesc, 2, self.message);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.data != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, ProductShopApiService$ProductShopDetailsResponse$ProductShopDetailsData$$serializer.INSTANCE, self.data);
                    }
                }

                public /* synthetic */ ProductShopDetailsResponse(long j, int i, String str, ProductShopDetailsData productShopDetailsData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? null : productShopDetailsData);
                }

                public final long getCode() {
                    return this.code;
                }

                public final int getErrtag() {
                    return this.errtag;
                }

                public final String getMessage() {
                    return this.message;
                }

                public final ProductShopDetailsData getData() {
                    return this.data;
                }

                /* compiled from: ProductShopApiService.kt */
                @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B7\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nBE\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\fHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006)"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopApiService$ProductShopDetailsResponse$ProductShopDetailsData;", "", "shopItems", "", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsShopItem;", "hotItems", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem;", "merchantInfo", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo;", "<init>", "(Ljava/util/List;Ljava/util/List;Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getShopItems", "()Ljava/util/List;", "getHotItems", "getMerchantInfo", "()Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                @Serializable
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class ProductShopDetailsData {
                    private final List<ProductShopDetailsHotItem> hotItems;
                    private final ProductShopDetailsMerchantInfo merchantInfo;
                    private final List<ProductShopDetailsShopItem> shopItems;
                    public static final Companion Companion = new Companion(null);
                    public static final int $stable = 8;
                    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopApiService$ProductShopDetailsResponse$ProductShopDetailsData$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            KSerializer _childSerializers$_anonymous_;
                            _childSerializers$_anonymous_ = ProductShopApiService.ProductShopDetailsResponse.ProductShopDetailsData._childSerializers$_anonymous_();
                            return _childSerializers$_anonymous_;
                        }
                    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopApiService$ProductShopDetailsResponse$ProductShopDetailsData$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            KSerializer _childSerializers$_anonymous_$0;
                            _childSerializers$_anonymous_$0 = ProductShopApiService.ProductShopDetailsResponse.ProductShopDetailsData._childSerializers$_anonymous_$0();
                            return _childSerializers$_anonymous_$0;
                        }
                    }), null};

                    public ProductShopDetailsData() {
                        this((List) null, (List) null, (ProductShopDetailsMerchantInfo) null, 7, (DefaultConstructorMarker) null);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public static /* synthetic */ ProductShopDetailsData copy$default(ProductShopDetailsData productShopDetailsData, List list, List list2, ProductShopDetailsMerchantInfo productShopDetailsMerchantInfo, int i, Object obj) {
                        if ((i & 1) != 0) {
                            list = productShopDetailsData.shopItems;
                        }
                        if ((i & 2) != 0) {
                            list2 = productShopDetailsData.hotItems;
                        }
                        if ((i & 4) != 0) {
                            productShopDetailsMerchantInfo = productShopDetailsData.merchantInfo;
                        }
                        return productShopDetailsData.copy(list, list2, productShopDetailsMerchantInfo);
                    }

                    public final List<ProductShopDetailsShopItem> component1() {
                        return this.shopItems;
                    }

                    public final List<ProductShopDetailsHotItem> component2() {
                        return this.hotItems;
                    }

                    public final ProductShopDetailsMerchantInfo component3() {
                        return this.merchantInfo;
                    }

                    public final ProductShopDetailsData copy(List<ProductShopDetailsShopItem> list, List<ProductShopDetailsHotItem> list2, ProductShopDetailsMerchantInfo productShopDetailsMerchantInfo) {
                        return new ProductShopDetailsData(list, list2, productShopDetailsMerchantInfo);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof ProductShopDetailsData) {
                            ProductShopDetailsData productShopDetailsData = (ProductShopDetailsData) obj;
                            return Intrinsics.areEqual(this.shopItems, productShopDetailsData.shopItems) && Intrinsics.areEqual(this.hotItems, productShopDetailsData.hotItems) && Intrinsics.areEqual(this.merchantInfo, productShopDetailsData.merchantInfo);
                        }
                        return false;
                    }

                    public int hashCode() {
                        return ((((this.shopItems == null ? 0 : this.shopItems.hashCode()) * 31) + (this.hotItems == null ? 0 : this.hotItems.hashCode())) * 31) + (this.merchantInfo != null ? this.merchantInfo.hashCode() : 0);
                    }

                    public String toString() {
                        List<ProductShopDetailsShopItem> list = this.shopItems;
                        List<ProductShopDetailsHotItem> list2 = this.hotItems;
                        return "ProductShopDetailsData(shopItems=" + list + ", hotItems=" + list2 + ", merchantInfo=" + this.merchantInfo + ")";
                    }

                    /* compiled from: ProductShopApiService.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopApiService$ProductShopDetailsResponse$ProductShopDetailsData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ProductShopApiService$ProductShopDetailsResponse$ProductShopDetailsData;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<ProductShopDetailsData> serializer() {
                            return ProductShopApiService$ProductShopDetailsResponse$ProductShopDetailsData$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ ProductShopDetailsData(int seen0, List shopItems, List hotItems, ProductShopDetailsMerchantInfo merchantInfo, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((seen0 & 1) == 0) {
                            this.shopItems = null;
                        } else {
                            this.shopItems = shopItems;
                        }
                        if ((seen0 & 2) == 0) {
                            this.hotItems = null;
                        } else {
                            this.hotItems = hotItems;
                        }
                        if ((seen0 & 4) == 0) {
                            this.merchantInfo = null;
                        } else {
                            this.merchantInfo = merchantInfo;
                        }
                    }

                    public ProductShopDetailsData(List<ProductShopDetailsShopItem> list, List<ProductShopDetailsHotItem> list2, ProductShopDetailsMerchantInfo merchantInfo) {
                        this.shopItems = list;
                        this.hotItems = list2;
                        this.merchantInfo = merchantInfo;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                        return new ArrayListSerializer(ProductShopDetailsShopItem$$serializer.INSTANCE);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                        return new ArrayListSerializer(ProductShopDetailsHotItem$$serializer.INSTANCE);
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$product_details_page_debug(ProductShopDetailsData self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.shopItems != null) {
                            output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.shopItems);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.hotItems != null) {
                            output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.hotItems);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.merchantInfo != null) {
                            output.encodeNullableSerializableElement(serialDesc, 2, ProductShopDetailsMerchantInfo$$serializer.INSTANCE, self.merchantInfo);
                        }
                    }

                    public /* synthetic */ ProductShopDetailsData(List list, List list2, ProductShopDetailsMerchantInfo productShopDetailsMerchantInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : productShopDetailsMerchantInfo);
                    }

                    public final List<ProductShopDetailsShopItem> getShopItems() {
                        return this.shopItems;
                    }

                    public final List<ProductShopDetailsHotItem> getHotItems() {
                        return this.hotItems;
                    }

                    public final ProductShopDetailsMerchantInfo getMerchantInfo() {
                        return this.merchantInfo;
                    }
                }

                public final boolean isValid$product_details_page_debug() {
                    return this.code == 0 && this.data != null;
                }
            }

            /* compiled from: ProductShopApiService.kt */
            @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB7\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\nHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006("}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopApiService$ProductShopDetailsRequest;", "", "merchantId", "", "mSource", "", "trackId", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMerchantId", "()J", "getMSource$annotations", "()V", "getMSource", "()Ljava/lang/String;", "getTrackId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class ProductShopDetailsRequest {
                public static final int $stable = 0;
                public static final Companion Companion = new Companion(null);
                private final String mSource;
                private final long merchantId;
                private final String trackId;

                public static /* synthetic */ ProductShopDetailsRequest copy$default(ProductShopDetailsRequest productShopDetailsRequest, long j, String str, String str2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        j = productShopDetailsRequest.merchantId;
                    }
                    if ((i & 2) != 0) {
                        str = productShopDetailsRequest.mSource;
                    }
                    if ((i & 4) != 0) {
                        str2 = productShopDetailsRequest.trackId;
                    }
                    return productShopDetailsRequest.copy(j, str, str2);
                }

                @SerialName("msource")
                public static /* synthetic */ void getMSource$annotations() {
                }

                public final long component1() {
                    return this.merchantId;
                }

                public final String component2() {
                    return this.mSource;
                }

                public final String component3() {
                    return this.trackId;
                }

                public final ProductShopDetailsRequest copy(long j, String str, String str2) {
                    return new ProductShopDetailsRequest(j, str, str2);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof ProductShopDetailsRequest) {
                        ProductShopDetailsRequest productShopDetailsRequest = (ProductShopDetailsRequest) obj;
                        return this.merchantId == productShopDetailsRequest.merchantId && Intrinsics.areEqual(this.mSource, productShopDetailsRequest.mSource) && Intrinsics.areEqual(this.trackId, productShopDetailsRequest.trackId);
                    }
                    return false;
                }

                public int hashCode() {
                    return (((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.merchantId) * 31) + (this.mSource == null ? 0 : this.mSource.hashCode())) * 31) + (this.trackId != null ? this.trackId.hashCode() : 0);
                }

                public String toString() {
                    long j = this.merchantId;
                    String str = this.mSource;
                    return "ProductShopDetailsRequest(merchantId=" + j + ", mSource=" + str + ", trackId=" + this.trackId + ")";
                }

                /* compiled from: ProductShopApiService.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopApiService$ProductShopDetailsRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ProductShopApiService$ProductShopDetailsRequest;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<ProductShopDetailsRequest> serializer() {
                        return ProductShopApiService$ProductShopDetailsRequest$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ ProductShopDetailsRequest(int seen0, long merchantId, String mSource, String trackId, SerializationConstructorMarker serializationConstructorMarker) {
                    if (1 != (seen0 & 1)) {
                        PluginExceptionsKt.throwMissingFieldException(seen0, 1, ProductShopApiService$ProductShopDetailsRequest$$serializer.INSTANCE.getDescriptor());
                    }
                    this.merchantId = merchantId;
                    if ((seen0 & 2) == 0) {
                        this.mSource = null;
                    } else {
                        this.mSource = mSource;
                    }
                    if ((seen0 & 4) == 0) {
                        this.trackId = null;
                    } else {
                        this.trackId = trackId;
                    }
                }

                public ProductShopDetailsRequest(long merchantId, String mSource, String trackId) {
                    this.merchantId = merchantId;
                    this.mSource = mSource;
                    this.trackId = trackId;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(ProductShopDetailsRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    output.encodeLongElement(serialDesc, 0, self.merchantId);
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.mSource != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.mSource);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.trackId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.trackId);
                    }
                }

                public /* synthetic */ ProductShopDetailsRequest(long j, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
                }

                public final long getMerchantId() {
                    return this.merchantId;
                }

                public final String getMSource() {
                    return this.mSource;
                }

                public final String getTrackId() {
                    return this.trackId;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x00bd  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x01ce A[Catch: Exception -> 0x0285, TRY_LEAVE, TryCatch #12 {Exception -> 0x0285, blocks: (B:52:0x01bb, B:54:0x01ce), top: B:118:0x01bb }] */
            /* JADX WARN: Removed duplicated region for block: B:62:0x021a A[Catch: Exception -> 0x0283, TRY_LEAVE, TryCatch #13 {Exception -> 0x0283, blocks: (B:58:0x01eb, B:62:0x021a, B:69:0x0237), top: B:120:0x01cc }] */
            /* JADX WARN: Removed duplicated region for block: B:74:0x0271 A[Catch: Exception -> 0x0275, TRY_ENTER, TryCatch #5 {Exception -> 0x0275, blocks: (B:74:0x0271, B:78:0x027a, B:79:0x0282), top: B:105:0x026f }] */
            /* JADX WARN: Removed duplicated region for block: B:78:0x027a A[Catch: Exception -> 0x0275, TryCatch #5 {Exception -> 0x0275, blocks: (B:74:0x0271, B:78:0x027a, B:79:0x0282), top: B:105:0x026f }] */
            /* JADX WARN: Type inference failed for: r11v4, types: [int] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object getProductShopDetails$product_details_page_debug(long merchantId, String mSource, String trackId, Continuation<? super ProductShopDetailsResponse> continuation) {
                ProductShopApiService$getProductShopDetails$1 productShopApiService$getProductShopDetails$1;
                ProductShopApiService$getProductShopDetails$1 productShopApiService$getProductShopDetails$12;
                String str;
                String str2;
                KType kType;
                String str3;
                String str4;
                Object execute;
                String trackId2;
                String mSource2;
                KType kType2;
                Object bodyNullable;
                String mSource3;
                String trackId3;
                long merchantId2 = merchantId;
                if (continuation instanceof ProductShopApiService$getProductShopDetails$1) {
                    productShopApiService$getProductShopDetails$1 = (ProductShopApiService$getProductShopDetails$1) continuation;
                    if ((productShopApiService$getProductShopDetails$1.label & Integer.MIN_VALUE) != 0) {
                        productShopApiService$getProductShopDetails$1.label -= Integer.MIN_VALUE;
                        productShopApiService$getProductShopDetails$12 = productShopApiService$getProductShopDetails$1;
                        Object $result = productShopApiService$getProductShopDetails$12.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (productShopApiService$getProductShopDetails$12.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                try {
                                    HttpClient $this$post$iv = Client.INSTANCE.getHttpClient();
                                    HttpMessageBuilder httpRequestBuilder = new HttpRequestBuilder();
                                    HttpRequestKt.url(httpRequestBuilder, API_URL_STRING);
                                    HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
                                    Object body$iv = new ProductShopDetailsRequest(merchantId2, mSource, trackId);
                                    if (body$iv instanceof OutgoingContent) {
                                        try {
                                            httpRequestBuilder.setBody(body$iv);
                                            try {
                                                httpRequestBuilder.setBodyType((TypeInfo) null);
                                            } catch (Exception e) {
                                                e = e;
                                                str = K_LOG_TAG;
                                                str2 = "Failed to fetch shop detail: ";
                                                KLog_androidKt.getKLog().e(str, str2 + e.getMessage(), e);
                                                return new ProductShopDetailsResponse(-1L, 0, str2 + e.getMessage(), (ProductShopDetailsResponse.ProductShopDetailsData) null, 10, (DefaultConstructorMarker) null);
                                            }
                                        } catch (Exception e2) {
                                            e = e2;
                                            str = K_LOG_TAG;
                                            str2 = "Failed to fetch shop detail: ";
                                        }
                                    } else {
                                        try {
                                            httpRequestBuilder.setBody(body$iv);
                                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ProductShopDetailsRequest.class);
                                            try {
                                                kType = Reflection.typeOf(ProductShopDetailsRequest.class);
                                            } catch (Throwable th) {
                                                kType = null;
                                            }
                                            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
                                        } catch (Exception e3) {
                                            e = e3;
                                            str = K_LOG_TAG;
                                            str2 = "Failed to fetch shop detail: ";
                                            KLog_androidKt.getKLog().e(str, str2 + e.getMessage(), e);
                                            return new ProductShopDetailsResponse(-1L, 0, str2 + e.getMessage(), (ProductShopDetailsResponse.ProductShopDetailsData) null, 10, (DefaultConstructorMarker) null);
                                        }
                                    }
                                    httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
                                    str3 = K_LOG_TAG;
                                    try {
                                        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, $this$post$iv);
                                        str4 = "Failed to fetch shop detail: ";
                                        try {
                                            productShopApiService$getProductShopDetails$12.L$0 = SpillingKt.nullOutSpilledVariable(mSource);
                                            productShopApiService$getProductShopDetails$12.L$1 = SpillingKt.nullOutSpilledVariable(trackId);
                                            productShopApiService$getProductShopDetails$12.L$2 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                            productShopApiService$getProductShopDetails$12.L$3 = SpillingKt.nullOutSpilledVariable(API_URL_STRING);
                                            productShopApiService$getProductShopDetails$12.L$4 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                            productShopApiService$getProductShopDetails$12.L$5 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                            productShopApiService$getProductShopDetails$12.L$6 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                                            productShopApiService$getProductShopDetails$12.L$7 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                            productShopApiService$getProductShopDetails$12.J$0 = merchantId2;
                                            productShopApiService$getProductShopDetails$12.I$0 = 0;
                                            productShopApiService$getProductShopDetails$12.I$1 = 0;
                                            productShopApiService$getProductShopDetails$12.I$2 = 0;
                                            productShopApiService$getProductShopDetails$12.I$3 = 0;
                                            productShopApiService$getProductShopDetails$12.label = 1;
                                            execute = httpStatement.execute(productShopApiService$getProductShopDetails$12);
                                            if (execute == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            trackId2 = trackId;
                                            str = null;
                                            mSource2 = mSource;
                                            try {
                                                str2 = (HttpResponse) execute;
                                                try {
                                                    if (Intrinsics.areEqual(str2.getStatus(), HttpStatusCode.Companion.getOK())) {
                                                        ILogger kLog = KLog_androidKt.getKLog();
                                                        HttpStatusCode status = str2.getStatus();
                                                        str2 = str4;
                                                        try {
                                                            kLog.e(str3, str2 + status);
                                                            return new ProductShopDetailsResponse(-1L, 0, str2 + str2.getStatus(), (ProductShopDetailsResponse.ProductShopDetailsData) null, 10, (DefaultConstructorMarker) null);
                                                        } catch (Exception e4) {
                                                            e = e4;
                                                            str = str3;
                                                            KLog_androidKt.getKLog().e(str, str2 + e.getMessage(), e);
                                                            return new ProductShopDetailsResponse(-1L, 0, str2 + e.getMessage(), (ProductShopDetailsResponse.ProductShopDetailsData) null, 10, (DefaultConstructorMarker) null);
                                                        }
                                                    }
                                                    str = str3;
                                                    str2 = str4;
                                                    HttpClientCall call = str2.getCall();
                                                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ProductShopDetailsResponse.class);
                                                    try {
                                                        kType2 = Reflection.typeOf(ProductShopDetailsResponse.class);
                                                    } catch (Throwable th2) {
                                                        kType2 = null;
                                                    }
                                                    TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass2, kType2);
                                                    productShopApiService$getProductShopDetails$12.L$0 = SpillingKt.nullOutSpilledVariable(mSource2);
                                                    productShopApiService$getProductShopDetails$12.L$1 = SpillingKt.nullOutSpilledVariable(trackId2);
                                                    productShopApiService$getProductShopDetails$12.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                                    productShopApiService$getProductShopDetails$12.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                                                    productShopApiService$getProductShopDetails$12.L$4 = null;
                                                    productShopApiService$getProductShopDetails$12.L$5 = null;
                                                    productShopApiService$getProductShopDetails$12.L$6 = null;
                                                    productShopApiService$getProductShopDetails$12.L$7 = null;
                                                    productShopApiService$getProductShopDetails$12.J$0 = merchantId2;
                                                    productShopApiService$getProductShopDetails$12.I$0 = 0;
                                                    productShopApiService$getProductShopDetails$12.label = 2;
                                                    bodyNullable = call.bodyNullable(typeInfo, productShopApiService$getProductShopDetails$12);
                                                    if (bodyNullable == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    mSource3 = mSource2;
                                                    trackId3 = trackId2;
                                                    try {
                                                        if (bodyNullable == null) {
                                                            ProductShopDetailsResponse rtValue = (ProductShopDetailsResponse) bodyNullable;
                                                            return rtValue;
                                                        }
                                                        throw new NullPointerException("null cannot be cast to non-null type kntr.app.mall.product.details.page.api.ProductShopApiService.ProductShopDetailsResponse");
                                                    } catch (Exception e5) {
                                                        e = e5;
                                                        KLog_androidKt.getKLog().e(str, str2 + e.getMessage(), e);
                                                        return new ProductShopDetailsResponse(-1L, 0, str2 + e.getMessage(), (ProductShopDetailsResponse.ProductShopDetailsData) null, 10, (DefaultConstructorMarker) null);
                                                    }
                                                } catch (Exception e6) {
                                                    e = e6;
                                                }
                                            } catch (Exception e7) {
                                                e = e7;
                                                str = str3;
                                                str2 = str4;
                                            }
                                        } catch (Exception e8) {
                                            e = e8;
                                            str = str3;
                                            str2 = str4;
                                            KLog_androidKt.getKLog().e(str, str2 + e.getMessage(), e);
                                            return new ProductShopDetailsResponse(-1L, 0, str2 + e.getMessage(), (ProductShopDetailsResponse.ProductShopDetailsData) null, 10, (DefaultConstructorMarker) null);
                                        }
                                    } catch (Exception e9) {
                                        e = e9;
                                        str2 = "Failed to fetch shop detail: ";
                                        str = str3;
                                    }
                                } catch (Exception e10) {
                                    e = e10;
                                    str = K_LOG_TAG;
                                    str2 = "Failed to fetch shop detail: ";
                                }
                            case 1:
                                int i = productShopApiService$getProductShopDetails$12.I$3;
                                ?? r11 = productShopApiService$getProductShopDetails$12.I$2;
                                int i2 = productShopApiService$getProductShopDetails$12.I$1;
                                int i3 = productShopApiService$getProductShopDetails$12.I$0;
                                merchantId2 = productShopApiService$getProductShopDetails$12.J$0;
                                HttpClient httpClient = (HttpClient) productShopApiService$getProductShopDetails$12.L$7;
                                HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) productShopApiService$getProductShopDetails$12.L$6;
                                HttpClient httpClient2 = (HttpClient) productShopApiService$getProductShopDetails$12.L$5;
                                HttpClient httpClient3 = (HttpClient) productShopApiService$getProductShopDetails$12.L$4;
                                String str5 = (String) productShopApiService$getProductShopDetails$12.L$3;
                                HttpClient httpClient4 = (HttpClient) productShopApiService$getProductShopDetails$12.L$2;
                                trackId2 = (String) productShopApiService$getProductShopDetails$12.L$1;
                                String mSource4 = (String) productShopApiService$getProductShopDetails$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    mSource2 = mSource4;
                                    str3 = K_LOG_TAG;
                                    execute = $result;
                                    str = r11;
                                    str4 = "Failed to fetch shop detail: ";
                                    str2 = (HttpResponse) execute;
                                    if (Intrinsics.areEqual(str2.getStatus(), HttpStatusCode.Companion.getOK())) {
                                    }
                                } catch (Exception e11) {
                                    e = e11;
                                    str = K_LOG_TAG;
                                    str2 = "Failed to fetch shop detail: ";
                                    KLog_androidKt.getKLog().e(str, str2 + e.getMessage(), e);
                                    return new ProductShopDetailsResponse(-1L, 0, str2 + e.getMessage(), (ProductShopDetailsResponse.ProductShopDetailsData) null, 10, (DefaultConstructorMarker) null);
                                }
                                break;
                            case 2:
                                int i4 = productShopApiService$getProductShopDetails$12.I$0;
                                long j = productShopApiService$getProductShopDetails$12.J$0;
                                HttpResponse httpResponse = (HttpResponse) productShopApiService$getProductShopDetails$12.L$3;
                                HttpResponse httpResponse2 = (HttpResponse) productShopApiService$getProductShopDetails$12.L$2;
                                trackId3 = (String) productShopApiService$getProductShopDetails$12.L$1;
                                mSource3 = (String) productShopApiService$getProductShopDetails$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    str = K_LOG_TAG;
                                    str2 = "Failed to fetch shop detail: ";
                                    bodyNullable = $result;
                                    if (bodyNullable == null) {
                                    }
                                } catch (Exception e12) {
                                    e = e12;
                                    str = K_LOG_TAG;
                                    str2 = "Failed to fetch shop detail: ";
                                    KLog_androidKt.getKLog().e(str, str2 + e.getMessage(), e);
                                    return new ProductShopDetailsResponse(-1L, 0, str2 + e.getMessage(), (ProductShopDetailsResponse.ProductShopDetailsData) null, 10, (DefaultConstructorMarker) null);
                                }
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
                productShopApiService$getProductShopDetails$1 = new ProductShopApiService$getProductShopDetails$1(this, continuation);
                productShopApiService$getProductShopDetails$12 = productShopApiService$getProductShopDetails$1;
                Object $result2 = productShopApiService$getProductShopDetails$12.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (productShopApiService$getProductShopDetails$12.label) {
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object mallKntrGetProductShopDetails$product_details_page_debug(Integer itemDetailType, int merchantId, String mSource, String trackId, Continuation<? super ProductShopDetailsResponse> continuation) {
                ProductShopApiService$mallKntrGetProductShopDetails$1 productShopApiService$mallKntrGetProductShopDetails$1;
                ProductShopApiService$mallKntrGetProductShopDetails$1 productShopApiService$mallKntrGetProductShopDetails$12;
                Object mallKntrAsyncRequest;
                Client $this$iv;
                if (continuation instanceof ProductShopApiService$mallKntrGetProductShopDetails$1) {
                    productShopApiService$mallKntrGetProductShopDetails$1 = (ProductShopApiService$mallKntrGetProductShopDetails$1) continuation;
                    if ((productShopApiService$mallKntrGetProductShopDetails$1.label & Integer.MIN_VALUE) != 0) {
                        productShopApiService$mallKntrGetProductShopDetails$1.label -= Integer.MIN_VALUE;
                        productShopApiService$mallKntrGetProductShopDetails$12 = productShopApiService$mallKntrGetProductShopDetails$1;
                        Object $result = productShopApiService$mallKntrGetProductShopDetails$12.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (productShopApiService$mallKntrGetProductShopDetails$12.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                try {
                                    Client $this$iv2 = Client.INSTANCE;
                                    Pair[] pairArr = new Pair[4];
                                    try {
                                        pairArr[0] = TuplesKt.to("itemDetailType", itemDetailType);
                                        pairArr[1] = TuplesKt.to("merchantId", Boxing.boxInt(merchantId));
                                        try {
                                            pairArr[2] = TuplesKt.to("mSource", mSource);
                                            try {
                                                pairArr[3] = TuplesKt.to("trackId", trackId);
                                                Map params$iv = MapsKt.mapOf(pairArr);
                                                try {
                                                    productShopApiService$mallKntrGetProductShopDetails$12.L$0 = SpillingKt.nullOutSpilledVariable(itemDetailType);
                                                    productShopApiService$mallKntrGetProductShopDetails$12.L$1 = SpillingKt.nullOutSpilledVariable(mSource);
                                                    productShopApiService$mallKntrGetProductShopDetails$12.L$2 = SpillingKt.nullOutSpilledVariable(trackId);
                                                    productShopApiService$mallKntrGetProductShopDetails$12.L$3 = $this$iv2;
                                                    productShopApiService$mallKntrGetProductShopDetails$12.L$4 = SpillingKt.nullOutSpilledVariable(API_URL_STRING);
                                                    productShopApiService$mallKntrGetProductShopDetails$12.L$5 = SpillingKt.nullOutSpilledVariable("POST");
                                                    productShopApiService$mallKntrGetProductShopDetails$12.L$6 = SpillingKt.nullOutSpilledVariable(params$iv);
                                                } catch (Exception e) {
                                                    e$iv = e;
                                                }
                                                try {
                                                    productShopApiService$mallKntrGetProductShopDetails$12.I$0 = merchantId;
                                                    productShopApiService$mallKntrGetProductShopDetails$12.I$1 = 0;
                                                    productShopApiService$mallKntrGetProductShopDetails$12.label = 1;
                                                    mallKntrAsyncRequest = MallEnvKt.mallKntrAsyncRequest(API_URL_STRING, "POST", (Map) null, params$iv, productShopApiService$mallKntrGetProductShopDetails$12);
                                                    if (mallKntrAsyncRequest == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    $this$iv = $this$iv2;
                                                    try {
                                                        String jsonString$iv = (String) mallKntrAsyncRequest;
                                                        Json this_$iv$iv = $this$iv.getJson();
                                                        Intrinsics.checkNotNull(jsonString$iv);
                                                        this_$iv$iv.getSerializersModule();
                                                        Object res$iv = this_$iv$iv.decodeFromString(ProductShopDetailsResponse.Companion.serializer(), jsonString$iv);
                                                        try {
                                                            return (ProductShopDetailsResponse) res$iv;
                                                        } catch (Exception e2) {
                                                            e = e2;
                                                            KLog_androidKt.getKLog().e(K_LOG_TAG, "获取商品详情失败：" + e.getMessage(), e);
                                                            return new ProductShopDetailsResponse(-1L, 0, "获取商品详情失败：" + e.getMessage(), (ProductShopDetailsResponse.ProductShopDetailsData) null, 10, (DefaultConstructorMarker) null);
                                                        }
                                                    } catch (Exception e3) {
                                                        e$iv = e3;
                                                        try {
                                                            try {
                                                            } catch (Exception e4) {
                                                                e = e4;
                                                            }
                                                        } catch (Exception e5) {
                                                            e = e5;
                                                        }
                                                        try {
                                                            KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                                            throw e$iv;
                                                        } catch (Exception e6) {
                                                            e = e6;
                                                            KLog_androidKt.getKLog().e(K_LOG_TAG, "获取商品详情失败：" + e.getMessage(), e);
                                                            return new ProductShopDetailsResponse(-1L, 0, "获取商品详情失败：" + e.getMessage(), (ProductShopDetailsResponse.ProductShopDetailsData) null, 10, (DefaultConstructorMarker) null);
                                                        }
                                                    }
                                                } catch (Exception e7) {
                                                    e$iv = e7;
                                                    KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                                    throw e$iv;
                                                }
                                            } catch (Exception e8) {
                                                e = e8;
                                                KLog_androidKt.getKLog().e(K_LOG_TAG, "获取商品详情失败：" + e.getMessage(), e);
                                                return new ProductShopDetailsResponse(-1L, 0, "获取商品详情失败：" + e.getMessage(), (ProductShopDetailsResponse.ProductShopDetailsData) null, 10, (DefaultConstructorMarker) null);
                                            }
                                        } catch (Exception e9) {
                                            e = e9;
                                        }
                                    } catch (Exception e10) {
                                        e = e10;
                                    }
                                } catch (Exception e11) {
                                    e = e11;
                                }
                            case 1:
                                int i = productShopApiService$mallKntrGetProductShopDetails$12.I$1;
                                int i2 = productShopApiService$mallKntrGetProductShopDetails$12.I$0;
                                Map map = (Map) productShopApiService$mallKntrGetProductShopDetails$12.L$6;
                                String str = (String) productShopApiService$mallKntrGetProductShopDetails$12.L$5;
                                String str2 = (String) productShopApiService$mallKntrGetProductShopDetails$12.L$4;
                                Client $this$iv3 = (Client) productShopApiService$mallKntrGetProductShopDetails$12.L$3;
                                String str3 = (String) productShopApiService$mallKntrGetProductShopDetails$12.L$2;
                                String str4 = (String) productShopApiService$mallKntrGetProductShopDetails$12.L$1;
                                Integer num = (Integer) productShopApiService$mallKntrGetProductShopDetails$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    $this$iv = $this$iv3;
                                    mallKntrAsyncRequest = $result;
                                    String jsonString$iv2 = (String) mallKntrAsyncRequest;
                                    Json this_$iv$iv2 = $this$iv.getJson();
                                    Intrinsics.checkNotNull(jsonString$iv2);
                                    this_$iv$iv2.getSerializersModule();
                                    Object res$iv2 = this_$iv$iv2.decodeFromString(ProductShopDetailsResponse.Companion.serializer(), jsonString$iv2);
                                    return (ProductShopDetailsResponse) res$iv2;
                                } catch (Exception e12) {
                                    e$iv = e12;
                                    KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                    throw e$iv;
                                }
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
                productShopApiService$mallKntrGetProductShopDetails$1 = new ProductShopApiService$mallKntrGetProductShopDetails$1(this, continuation);
                productShopApiService$mallKntrGetProductShopDetails$12 = productShopApiService$mallKntrGetProductShopDetails$1;
                Object $result2 = productShopApiService$mallKntrGetProductShopDetails$12.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (productShopApiService$mallKntrGetProductShopDetails$12.label) {
                }
            }
        }