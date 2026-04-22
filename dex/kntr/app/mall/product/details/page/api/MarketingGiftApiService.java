package kntr.app.mall.product.details.page.api;

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
import kntr.app.mall.product.details.page.api.MarketingGiftApiService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.KotlinVersion;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: MarketingGiftApiService.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003\u000b\f\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0080@¢\u0006\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/mall/product/details/page/api/MarketingGiftApiService;", "", "<init>", "()V", "API_URL_STRING", "", "getMarketingGift", "Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftResponse;", "marketingId", "getMarketingGift$product_details_page_debug", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MarketingGiftResponse", "MarketingGiftData", "MarketingGiftRequest", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MarketingGiftApiService {
    public static final int $stable = 0;
    private static final String API_URL_STRING = "https://mall.bilibili.com/mall-marketing-campaign/marketing/search/query_marketing_gift";
    public static final MarketingGiftApiService INSTANCE = new MarketingGiftApiService();

    private MarketingGiftApiService() {
    }

    /* compiled from: MarketingGiftApiService.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBC\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\u0007HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006/"}, d2 = {"Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftResponse;", "", "code", "", "errtag", "", "message", "", "data", "Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftData;", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftData;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getErrtag", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/String;", "getData", "()Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftData;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftData;)Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftResponse;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class MarketingGiftResponse {
        private final Long code;
        private final MarketingGiftData data;
        private final Integer errtag;
        private final String message;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public MarketingGiftResponse() {
            this((Long) null, (Integer) null, (String) null, (MarketingGiftData) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ MarketingGiftResponse copy$default(MarketingGiftResponse marketingGiftResponse, Long l, Integer num, String str, MarketingGiftData marketingGiftData, int i, Object obj) {
            if ((i & 1) != 0) {
                l = marketingGiftResponse.code;
            }
            if ((i & 2) != 0) {
                num = marketingGiftResponse.errtag;
            }
            if ((i & 4) != 0) {
                str = marketingGiftResponse.message;
            }
            if ((i & 8) != 0) {
                marketingGiftData = marketingGiftResponse.data;
            }
            return marketingGiftResponse.copy(l, num, str, marketingGiftData);
        }

        public final Long component1() {
            return this.code;
        }

        public final Integer component2() {
            return this.errtag;
        }

        public final String component3() {
            return this.message;
        }

        public final MarketingGiftData component4() {
            return this.data;
        }

        public final MarketingGiftResponse copy(Long l, Integer num, String str, MarketingGiftData marketingGiftData) {
            return new MarketingGiftResponse(l, num, str, marketingGiftData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MarketingGiftResponse) {
                MarketingGiftResponse marketingGiftResponse = (MarketingGiftResponse) obj;
                return Intrinsics.areEqual(this.code, marketingGiftResponse.code) && Intrinsics.areEqual(this.errtag, marketingGiftResponse.errtag) && Intrinsics.areEqual(this.message, marketingGiftResponse.message) && Intrinsics.areEqual(this.data, marketingGiftResponse.data);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.code == null ? 0 : this.code.hashCode()) * 31) + (this.errtag == null ? 0 : this.errtag.hashCode())) * 31) + (this.message == null ? 0 : this.message.hashCode())) * 31) + (this.data != null ? this.data.hashCode() : 0);
        }

        public String toString() {
            Long l = this.code;
            Integer num = this.errtag;
            String str = this.message;
            return "MarketingGiftResponse(code=" + l + ", errtag=" + num + ", message=" + str + ", data=" + this.data + ")";
        }

        /* compiled from: MarketingGiftApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftResponse;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<MarketingGiftResponse> serializer() {
                return new GeneratedSerializer<MarketingGiftResponse>() { // from class: kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftResponse$$serializer
                    public static final int $stable;
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.MarketingGiftApiService.MarketingGiftResponse", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftResponse> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftResponse> A[REMOVE]) =  kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftResponse$$serializer)
                             in method: kntr.app.mall.product.details.page.api.MarketingGiftApiService.MarketingGiftResponse.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftResponse>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                              ("kntr.app.mall.product.details.page.api.MarketingGiftApiService.MarketingGiftResponse")
                              (wrap: kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftResponse$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftResponse$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftResponse$$serializer)
                              (4 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftResponse$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftResponse$$serializer
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
                            kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftResponse$$serializer r0 = kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftResponse$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.MarketingGiftApiService.MarketingGiftResponse.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ MarketingGiftResponse(int seen0, Long code, Integer errtag, String message, MarketingGiftData data, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.code = null;
                    } else {
                        this.code = code;
                    }
                    if ((seen0 & 2) == 0) {
                        this.errtag = null;
                    } else {
                        this.errtag = errtag;
                    }
                    if ((seen0 & 4) == 0) {
                        this.message = null;
                    } else {
                        this.message = message;
                    }
                    if ((seen0 & 8) == 0) {
                        this.data = null;
                    } else {
                        this.data = data;
                    }
                }

                public MarketingGiftResponse(Long code, Integer errtag, String message, MarketingGiftData data) {
                    this.code = code;
                    this.errtag = errtag;
                    this.message = message;
                    this.data = data;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(MarketingGiftResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.code != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.code);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.errtag != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.errtag);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.message != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.message);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.data != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, MarketingGiftApiService$MarketingGiftData$$serializer.INSTANCE, self.data);
                    }
                }

                public /* synthetic */ MarketingGiftResponse(Long l, Integer num, String str, MarketingGiftData marketingGiftData, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : marketingGiftData);
                }

                public final Long getCode() {
                    return this.code;
                }

                public final Integer getErrtag() {
                    return this.errtag;
                }

                public final String getMessage() {
                    return this.message;
                }

                public final MarketingGiftData getData() {
                    return this.data;
                }
            }

            /* compiled from: MarketingGiftApiService.kt */
            @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 92\u00020\u0001:\u0003789Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u000fBq\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0013J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017Jt\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0005HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001f\u0010\u0017¨\u0006:"}, d2 = {"Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftData;", "", "activityUrl", "", "endTime", "", "marketingId", "marketingName", "marketingStageDTOList", "", "Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftData$MarketingStage;", "ruleDesc", "ruleUrl", "startTime", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActivityUrl", "()Ljava/lang/String;", "getEndTime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMarketingId", "getMarketingName", "getMarketingStageDTOList", "()Ljava/util/List;", "getRuleDesc", "getRuleUrl", "getStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftData;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "MarketingStage", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class MarketingGiftData {
                private final String activityUrl;
                private final Integer endTime;
                private final String marketingId;
                private final String marketingName;
                private final List<MarketingStage> marketingStageDTOList;
                private final String ruleDesc;
                private final String ruleUrl;
                private final Integer startTime;
                public static final Companion Companion = new Companion(null);
                public static final int $stable = 8;
                private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftData$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        KSerializer _childSerializers$_anonymous_;
                        _childSerializers$_anonymous_ = MarketingGiftApiService.MarketingGiftData._childSerializers$_anonymous_();
                        return _childSerializers$_anonymous_;
                    }
                }), null, null, null};

                public MarketingGiftData() {
                    this((String) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (String) null, (Integer) null, (int) KotlinVersion.MAX_COMPONENT_VALUE, (DefaultConstructorMarker) null);
                }

                public final String component1() {
                    return this.activityUrl;
                }

                public final Integer component2() {
                    return this.endTime;
                }

                public final String component3() {
                    return this.marketingId;
                }

                public final String component4() {
                    return this.marketingName;
                }

                public final List<MarketingStage> component5() {
                    return this.marketingStageDTOList;
                }

                public final String component6() {
                    return this.ruleDesc;
                }

                public final String component7() {
                    return this.ruleUrl;
                }

                public final Integer component8() {
                    return this.startTime;
                }

                public final MarketingGiftData copy(String str, Integer num, String str2, String str3, List<MarketingStage> list, String str4, String str5, Integer num2) {
                    return new MarketingGiftData(str, num, str2, str3, list, str4, str5, num2);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof MarketingGiftData) {
                        MarketingGiftData marketingGiftData = (MarketingGiftData) obj;
                        return Intrinsics.areEqual(this.activityUrl, marketingGiftData.activityUrl) && Intrinsics.areEqual(this.endTime, marketingGiftData.endTime) && Intrinsics.areEqual(this.marketingId, marketingGiftData.marketingId) && Intrinsics.areEqual(this.marketingName, marketingGiftData.marketingName) && Intrinsics.areEqual(this.marketingStageDTOList, marketingGiftData.marketingStageDTOList) && Intrinsics.areEqual(this.ruleDesc, marketingGiftData.ruleDesc) && Intrinsics.areEqual(this.ruleUrl, marketingGiftData.ruleUrl) && Intrinsics.areEqual(this.startTime, marketingGiftData.startTime);
                    }
                    return false;
                }

                public int hashCode() {
                    return ((((((((((((((this.activityUrl == null ? 0 : this.activityUrl.hashCode()) * 31) + (this.endTime == null ? 0 : this.endTime.hashCode())) * 31) + (this.marketingId == null ? 0 : this.marketingId.hashCode())) * 31) + (this.marketingName == null ? 0 : this.marketingName.hashCode())) * 31) + (this.marketingStageDTOList == null ? 0 : this.marketingStageDTOList.hashCode())) * 31) + (this.ruleDesc == null ? 0 : this.ruleDesc.hashCode())) * 31) + (this.ruleUrl == null ? 0 : this.ruleUrl.hashCode())) * 31) + (this.startTime != null ? this.startTime.hashCode() : 0);
                }

                public String toString() {
                    String str = this.activityUrl;
                    Integer num = this.endTime;
                    String str2 = this.marketingId;
                    String str3 = this.marketingName;
                    List<MarketingStage> list = this.marketingStageDTOList;
                    String str4 = this.ruleDesc;
                    String str5 = this.ruleUrl;
                    return "MarketingGiftData(activityUrl=" + str + ", endTime=" + num + ", marketingId=" + str2 + ", marketingName=" + str3 + ", marketingStageDTOList=" + list + ", ruleDesc=" + str4 + ", ruleUrl=" + str5 + ", startTime=" + this.startTime + ")";
                }

                /* compiled from: MarketingGiftApiService.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftData;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<MarketingGiftData> serializer() {
                        return MarketingGiftApiService$MarketingGiftData$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ MarketingGiftData(int seen0, String activityUrl, Integer endTime, String marketingId, String marketingName, List marketingStageDTOList, String ruleDesc, String ruleUrl, Integer startTime, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.activityUrl = null;
                    } else {
                        this.activityUrl = activityUrl;
                    }
                    if ((seen0 & 2) == 0) {
                        this.endTime = null;
                    } else {
                        this.endTime = endTime;
                    }
                    if ((seen0 & 4) == 0) {
                        this.marketingId = null;
                    } else {
                        this.marketingId = marketingId;
                    }
                    if ((seen0 & 8) == 0) {
                        this.marketingName = null;
                    } else {
                        this.marketingName = marketingName;
                    }
                    if ((seen0 & 16) == 0) {
                        this.marketingStageDTOList = null;
                    } else {
                        this.marketingStageDTOList = marketingStageDTOList;
                    }
                    if ((seen0 & 32) == 0) {
                        this.ruleDesc = null;
                    } else {
                        this.ruleDesc = ruleDesc;
                    }
                    if ((seen0 & 64) == 0) {
                        this.ruleUrl = null;
                    } else {
                        this.ruleUrl = ruleUrl;
                    }
                    if ((seen0 & 128) == 0) {
                        this.startTime = null;
                    } else {
                        this.startTime = startTime;
                    }
                }

                public MarketingGiftData(String activityUrl, Integer endTime, String marketingId, String marketingName, List<MarketingStage> list, String ruleDesc, String ruleUrl, Integer startTime) {
                    this.activityUrl = activityUrl;
                    this.endTime = endTime;
                    this.marketingId = marketingId;
                    this.marketingName = marketingName;
                    this.marketingStageDTOList = list;
                    this.ruleDesc = ruleDesc;
                    this.ruleUrl = ruleUrl;
                    this.startTime = startTime;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                    return new ArrayListSerializer(MarketingGiftApiService$MarketingGiftData$MarketingStage$$serializer.INSTANCE);
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(MarketingGiftData self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.activityUrl != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.activityUrl);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.endTime != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.endTime);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.marketingId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.marketingId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.marketingName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.marketingName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.marketingStageDTOList != null) {
                        output.encodeNullableSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.marketingStageDTOList);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 5) || self.ruleDesc != null) {
                        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.ruleDesc);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 6) || self.ruleUrl != null) {
                        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.ruleUrl);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 7) || self.startTime != null) {
                        output.encodeNullableSerializableElement(serialDesc, 7, IntSerializer.INSTANCE, self.startTime);
                    }
                }

                public /* synthetic */ MarketingGiftData(String str, Integer num, String str2, String str3, List list, String str4, String str5, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) == 0 ? num2 : null);
                }

                public final String getActivityUrl() {
                    return this.activityUrl;
                }

                public final Integer getEndTime() {
                    return this.endTime;
                }

                public final String getMarketingId() {
                    return this.marketingId;
                }

                public final String getMarketingName() {
                    return this.marketingName;
                }

                public final List<MarketingStage> getMarketingStageDTOList() {
                    return this.marketingStageDTOList;
                }

                public final String getRuleDesc() {
                    return this.ruleDesc;
                }

                public final String getRuleUrl() {
                    return this.ruleUrl;
                }

                /* compiled from: MarketingGiftApiService.kt */
                @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0003*+,B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nBI\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003JD\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006-"}, d2 = {"Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftData$MarketingStage;", "", "condition", "", "conditionType", "level", "marketingStageBenefitDTOList", "", "Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftData$MarketingStage$MarketingStageBenefit;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCondition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getConditionType", "getLevel", "getMarketingStageBenefitDTOList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftData$MarketingStage;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "MarketingStageBenefit", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                @Serializable
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class MarketingStage {
                    private final Integer condition;
                    private final Integer conditionType;
                    private final Integer level;
                    private final List<MarketingStageBenefit> marketingStageBenefitDTOList;
                    public static final Companion Companion = new Companion(null);
                    public static final int $stable = 8;
                    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftData$MarketingStage$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            KSerializer _childSerializers$_anonymous_;
                            _childSerializers$_anonymous_ = MarketingGiftApiService.MarketingGiftData.MarketingStage._childSerializers$_anonymous_();
                            return _childSerializers$_anonymous_;
                        }
                    })};

                    public MarketingStage() {
                        this((Integer) null, (Integer) null, (Integer) null, (List) null, 15, (DefaultConstructorMarker) null);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public static /* synthetic */ MarketingStage copy$default(MarketingStage marketingStage, Integer num, Integer num2, Integer num3, List list, int i, Object obj) {
                        if ((i & 1) != 0) {
                            num = marketingStage.condition;
                        }
                        if ((i & 2) != 0) {
                            num2 = marketingStage.conditionType;
                        }
                        if ((i & 4) != 0) {
                            num3 = marketingStage.level;
                        }
                        if ((i & 8) != 0) {
                            list = marketingStage.marketingStageBenefitDTOList;
                        }
                        return marketingStage.copy(num, num2, num3, list);
                    }

                    public final Integer component1() {
                        return this.condition;
                    }

                    public final Integer component2() {
                        return this.conditionType;
                    }

                    public final Integer component3() {
                        return this.level;
                    }

                    public final List<MarketingStageBenefit> component4() {
                        return this.marketingStageBenefitDTOList;
                    }

                    public final MarketingStage copy(Integer num, Integer num2, Integer num3, List<MarketingStageBenefit> list) {
                        return new MarketingStage(num, num2, num3, list);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof MarketingStage) {
                            MarketingStage marketingStage = (MarketingStage) obj;
                            return Intrinsics.areEqual(this.condition, marketingStage.condition) && Intrinsics.areEqual(this.conditionType, marketingStage.conditionType) && Intrinsics.areEqual(this.level, marketingStage.level) && Intrinsics.areEqual(this.marketingStageBenefitDTOList, marketingStage.marketingStageBenefitDTOList);
                        }
                        return false;
                    }

                    public int hashCode() {
                        return ((((((this.condition == null ? 0 : this.condition.hashCode()) * 31) + (this.conditionType == null ? 0 : this.conditionType.hashCode())) * 31) + (this.level == null ? 0 : this.level.hashCode())) * 31) + (this.marketingStageBenefitDTOList != null ? this.marketingStageBenefitDTOList.hashCode() : 0);
                    }

                    public String toString() {
                        Integer num = this.condition;
                        Integer num2 = this.conditionType;
                        Integer num3 = this.level;
                        return "MarketingStage(condition=" + num + ", conditionType=" + num2 + ", level=" + num3 + ", marketingStageBenefitDTOList=" + this.marketingStageBenefitDTOList + ")";
                    }

                    /* compiled from: MarketingGiftApiService.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftData$MarketingStage$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftData$MarketingStage;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<MarketingStage> serializer() {
                            return MarketingGiftApiService$MarketingGiftData$MarketingStage$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ MarketingStage(int seen0, Integer condition, Integer conditionType, Integer level, List marketingStageBenefitDTOList, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((seen0 & 1) == 0) {
                            this.condition = null;
                        } else {
                            this.condition = condition;
                        }
                        if ((seen0 & 2) == 0) {
                            this.conditionType = null;
                        } else {
                            this.conditionType = conditionType;
                        }
                        if ((seen0 & 4) == 0) {
                            this.level = null;
                        } else {
                            this.level = level;
                        }
                        if ((seen0 & 8) == 0) {
                            this.marketingStageBenefitDTOList = null;
                        } else {
                            this.marketingStageBenefitDTOList = marketingStageBenefitDTOList;
                        }
                    }

                    public MarketingStage(Integer condition, Integer conditionType, Integer level, List<MarketingStageBenefit> list) {
                        this.condition = condition;
                        this.conditionType = conditionType;
                        this.level = level;
                        this.marketingStageBenefitDTOList = list;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                        return new ArrayListSerializer(MarketingGiftApiService$MarketingGiftData$MarketingStage$MarketingStageBenefit$$serializer.INSTANCE);
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$product_details_page_debug(MarketingStage self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.condition != null) {
                            output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.condition);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.conditionType != null) {
                            output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.conditionType);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.level != null) {
                            output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.level);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.marketingStageBenefitDTOList != null) {
                            output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.marketingStageBenefitDTOList);
                        }
                    }

                    public /* synthetic */ MarketingStage(Integer num, Integer num2, Integer num3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : list);
                    }

                    public final Integer getCondition() {
                        return this.condition;
                    }

                    public final Integer getConditionType() {
                        return this.conditionType;
                    }

                    public final Integer getLevel() {
                        return this.level;
                    }

                    /* compiled from: MarketingGiftApiService.kt */
                    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000278Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eBk\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jn\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017¨\u00069"}, d2 = {"Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftData$MarketingStage$MarketingStageBenefit;", "", "benefitStockStatus", "", "itemsDetailUrl", "", "itemsId", "", "quantity", "showImg", "showName", "skuId", "subShowName", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBenefitStockStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getItemsDetailUrl", "()Ljava/lang/String;", "getItemsId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getQuantity", "getShowImg", "getShowName", "getSkuId", "getSubShowName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftData$MarketingStage$MarketingStageBenefit;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    @Serializable
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class MarketingStageBenefit {
                        public static final int $stable = 0;
                        public static final Companion Companion = new Companion(null);
                        private final Integer benefitStockStatus;
                        private final String itemsDetailUrl;
                        private final Long itemsId;
                        private final Integer quantity;
                        private final String showImg;
                        private final String showName;
                        private final Long skuId;
                        private final String subShowName;

                        public MarketingStageBenefit() {
                            this((Integer) null, (String) null, (Long) null, (Integer) null, (String) null, (String) null, (Long) null, (String) null, (int) KotlinVersion.MAX_COMPONENT_VALUE, (DefaultConstructorMarker) null);
                        }

                        public final Integer component1() {
                            return this.benefitStockStatus;
                        }

                        public final String component2() {
                            return this.itemsDetailUrl;
                        }

                        public final Long component3() {
                            return this.itemsId;
                        }

                        public final Integer component4() {
                            return this.quantity;
                        }

                        public final String component5() {
                            return this.showImg;
                        }

                        public final String component6() {
                            return this.showName;
                        }

                        public final Long component7() {
                            return this.skuId;
                        }

                        public final String component8() {
                            return this.subShowName;
                        }

                        public final MarketingStageBenefit copy(Integer num, String str, Long l, Integer num2, String str2, String str3, Long l2, String str4) {
                            return new MarketingStageBenefit(num, str, l, num2, str2, str3, l2, str4);
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj instanceof MarketingStageBenefit) {
                                MarketingStageBenefit marketingStageBenefit = (MarketingStageBenefit) obj;
                                return Intrinsics.areEqual(this.benefitStockStatus, marketingStageBenefit.benefitStockStatus) && Intrinsics.areEqual(this.itemsDetailUrl, marketingStageBenefit.itemsDetailUrl) && Intrinsics.areEqual(this.itemsId, marketingStageBenefit.itemsId) && Intrinsics.areEqual(this.quantity, marketingStageBenefit.quantity) && Intrinsics.areEqual(this.showImg, marketingStageBenefit.showImg) && Intrinsics.areEqual(this.showName, marketingStageBenefit.showName) && Intrinsics.areEqual(this.skuId, marketingStageBenefit.skuId) && Intrinsics.areEqual(this.subShowName, marketingStageBenefit.subShowName);
                            }
                            return false;
                        }

                        public int hashCode() {
                            return ((((((((((((((this.benefitStockStatus == null ? 0 : this.benefitStockStatus.hashCode()) * 31) + (this.itemsDetailUrl == null ? 0 : this.itemsDetailUrl.hashCode())) * 31) + (this.itemsId == null ? 0 : this.itemsId.hashCode())) * 31) + (this.quantity == null ? 0 : this.quantity.hashCode())) * 31) + (this.showImg == null ? 0 : this.showImg.hashCode())) * 31) + (this.showName == null ? 0 : this.showName.hashCode())) * 31) + (this.skuId == null ? 0 : this.skuId.hashCode())) * 31) + (this.subShowName != null ? this.subShowName.hashCode() : 0);
                        }

                        public String toString() {
                            Integer num = this.benefitStockStatus;
                            String str = this.itemsDetailUrl;
                            Long l = this.itemsId;
                            Integer num2 = this.quantity;
                            String str2 = this.showImg;
                            String str3 = this.showName;
                            Long l2 = this.skuId;
                            return "MarketingStageBenefit(benefitStockStatus=" + num + ", itemsDetailUrl=" + str + ", itemsId=" + l + ", quantity=" + num2 + ", showImg=" + str2 + ", showName=" + str3 + ", skuId=" + l2 + ", subShowName=" + this.subShowName + ")";
                        }

                        /* compiled from: MarketingGiftApiService.kt */
                        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftData$MarketingStage$MarketingStageBenefit$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftData$MarketingStage$MarketingStageBenefit;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class Companion {
                            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                this();
                            }

                            private Companion() {
                            }

                            public final KSerializer<MarketingStageBenefit> serializer() {
                                return MarketingGiftApiService$MarketingGiftData$MarketingStage$MarketingStageBenefit$$serializer.INSTANCE;
                            }
                        }

                        public /* synthetic */ MarketingStageBenefit(int seen0, Integer benefitStockStatus, String itemsDetailUrl, Long itemsId, Integer quantity, String showImg, String showName, Long skuId, String subShowName, SerializationConstructorMarker serializationConstructorMarker) {
                            if ((seen0 & 1) == 0) {
                                this.benefitStockStatus = null;
                            } else {
                                this.benefitStockStatus = benefitStockStatus;
                            }
                            if ((seen0 & 2) == 0) {
                                this.itemsDetailUrl = null;
                            } else {
                                this.itemsDetailUrl = itemsDetailUrl;
                            }
                            if ((seen0 & 4) == 0) {
                                this.itemsId = null;
                            } else {
                                this.itemsId = itemsId;
                            }
                            if ((seen0 & 8) == 0) {
                                this.quantity = null;
                            } else {
                                this.quantity = quantity;
                            }
                            if ((seen0 & 16) == 0) {
                                this.showImg = null;
                            } else {
                                this.showImg = showImg;
                            }
                            if ((seen0 & 32) == 0) {
                                this.showName = null;
                            } else {
                                this.showName = showName;
                            }
                            if ((seen0 & 64) == 0) {
                                this.skuId = null;
                            } else {
                                this.skuId = skuId;
                            }
                            if ((seen0 & 128) == 0) {
                                this.subShowName = null;
                            } else {
                                this.subShowName = subShowName;
                            }
                        }

                        public MarketingStageBenefit(Integer benefitStockStatus, String itemsDetailUrl, Long itemsId, Integer quantity, String showImg, String showName, Long skuId, String subShowName) {
                            this.benefitStockStatus = benefitStockStatus;
                            this.itemsDetailUrl = itemsDetailUrl;
                            this.itemsId = itemsId;
                            this.quantity = quantity;
                            this.showImg = showImg;
                            this.showName = showName;
                            this.skuId = skuId;
                            this.subShowName = subShowName;
                        }

                        @JvmStatic
                        public static final /* synthetic */ void write$Self$product_details_page_debug(MarketingStageBenefit self, CompositeEncoder output, SerialDescriptor serialDesc) {
                            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.benefitStockStatus != null) {
                                output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.benefitStockStatus);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.itemsDetailUrl != null) {
                                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.itemsDetailUrl);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.itemsId != null) {
                                output.encodeNullableSerializableElement(serialDesc, 2, LongSerializer.INSTANCE, self.itemsId);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.quantity != null) {
                                output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.quantity);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.showImg != null) {
                                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.showImg);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.showName != null) {
                                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.showName);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.skuId != null) {
                                output.encodeNullableSerializableElement(serialDesc, 6, LongSerializer.INSTANCE, self.skuId);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.subShowName != null) {
                                output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.subShowName);
                            }
                        }

                        public /* synthetic */ MarketingStageBenefit(Integer num, String str, Long l, Integer num2, String str2, String str3, Long l2, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : l2, (i & 128) == 0 ? str4 : null);
                        }

                        public final Integer getBenefitStockStatus() {
                            return this.benefitStockStatus;
                        }

                        public final String getItemsDetailUrl() {
                            return this.itemsDetailUrl;
                        }

                        public final Long getItemsId() {
                            return this.itemsId;
                        }

                        public final Integer getQuantity() {
                            return this.quantity;
                        }

                        public final String getShowImg() {
                            return this.showImg;
                        }

                        public final String getShowName() {
                            return this.showName;
                        }

                        public final Long getSkuId() {
                            return this.skuId;
                        }

                        public final String getSubShowName() {
                            return this.subShowName;
                        }
                    }

                    public final List<MarketingStageBenefit> getMarketingStageBenefitDTOList() {
                        return this.marketingStageBenefitDTOList;
                    }
                }

                public final Integer getStartTime() {
                    return this.startTime;
                }
            }

            /* compiled from: MarketingGiftApiService.kt */
            @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J%\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0001¢\u0006\u0002\b\u001bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftRequest;", "", "marketingId", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMarketingId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class MarketingGiftRequest {
                public static final int $stable = 0;
                public static final Companion Companion = new Companion(null);
                private final String marketingId;

                public MarketingGiftRequest() {
                    this((String) null, 1, (DefaultConstructorMarker) null);
                }

                public static /* synthetic */ MarketingGiftRequest copy$default(MarketingGiftRequest marketingGiftRequest, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = marketingGiftRequest.marketingId;
                    }
                    return marketingGiftRequest.copy(str);
                }

                public final String component1() {
                    return this.marketingId;
                }

                public final MarketingGiftRequest copy(String str) {
                    return new MarketingGiftRequest(str);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof MarketingGiftRequest) && Intrinsics.areEqual(this.marketingId, ((MarketingGiftRequest) obj).marketingId);
                }

                public int hashCode() {
                    if (this.marketingId == null) {
                        return 0;
                    }
                    return this.marketingId.hashCode();
                }

                public String toString() {
                    return "MarketingGiftRequest(marketingId=" + this.marketingId + ")";
                }

                /* compiled from: MarketingGiftApiService.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftRequest;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<MarketingGiftRequest> serializer() {
                        return new GeneratedSerializer<MarketingGiftRequest>() { // from class: kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftRequest$$serializer
                            public static final int $stable;
                            private static final SerialDescriptor descriptor;

                            public final SerialDescriptor getDescriptor() {
                                return descriptor;
                            }

                            static {
                                SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.MarketingGiftApiService.MarketingGiftRequest", 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                                      (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftRequest> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftRequest> A[REMOVE]) =  kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftRequest$$serializer.INSTANCE kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftRequest$$serializer)
                                     in method: kntr.app.mall.product.details.page.api.MarketingGiftApiService.MarketingGiftRequest.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftRequest>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                                      ("kntr.app.mall.product.details.page.api.MarketingGiftApiService.MarketingGiftRequest")
                                      (wrap: kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftRequest$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftRequest$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftRequest$$serializer.INSTANCE kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftRequest$$serializer)
                                      (1 int)
                                     call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftRequest$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftRequest$$serializer
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
                                    kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftRequest$$serializer r0 = kntr.app.mall.product.details.page.api.MarketingGiftApiService$MarketingGiftRequest$$serializer.INSTANCE
                                    kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                                    return r0
                                */
                                throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.MarketingGiftApiService.MarketingGiftRequest.Companion.serializer():kotlinx.serialization.KSerializer");
                            }
                        }

                        public /* synthetic */ MarketingGiftRequest(int seen0, String marketingId, SerializationConstructorMarker serializationConstructorMarker) {
                            if ((seen0 & 1) == 0) {
                                this.marketingId = null;
                            } else {
                                this.marketingId = marketingId;
                            }
                        }

                        public MarketingGiftRequest(String marketingId) {
                            this.marketingId = marketingId;
                        }

                        @JvmStatic
                        public static final /* synthetic */ void write$Self$product_details_page_debug(MarketingGiftRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
                            boolean z = true;
                            if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.marketingId == null) {
                                z = false;
                            }
                            if (z) {
                                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.marketingId);
                            }
                        }

                        public /* synthetic */ MarketingGiftRequest(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                            this((i & 1) != 0 ? null : str);
                        }

                        public final String getMarketingId() {
                            return this.marketingId;
                        }
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
                    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
                    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
                    /* JADX WARN: Removed duplicated region for block: B:22:0x008e  */
                    /* JADX WARN: Removed duplicated region for block: B:43:0x0170 A[Catch: Exception -> 0x01f1, TryCatch #6 {Exception -> 0x01f1, blocks: (B:57:0x01e4, B:59:0x01e8, B:60:0x01f0, B:41:0x015d, B:43:0x0170, B:45:0x019c, B:52:0x01b5), top: B:81:0x015d }] */
                    /* JADX WARN: Removed duplicated region for block: B:45:0x019c A[Catch: Exception -> 0x01f1, TRY_LEAVE, TryCatch #6 {Exception -> 0x01f1, blocks: (B:57:0x01e4, B:59:0x01e8, B:60:0x01f0, B:41:0x015d, B:43:0x0170, B:45:0x019c, B:52:0x01b5), top: B:81:0x015d }] */
                    /* JADX WARN: Removed duplicated region for block: B:57:0x01e4 A[Catch: Exception -> 0x01f1, TryCatch #6 {Exception -> 0x01f1, blocks: (B:57:0x01e4, B:59:0x01e8, B:60:0x01f0, B:41:0x015d, B:43:0x0170, B:45:0x019c, B:52:0x01b5), top: B:81:0x015d }] */
                    /* JADX WARN: Removed duplicated region for block: B:59:0x01e8 A[Catch: Exception -> 0x01f1, TryCatch #6 {Exception -> 0x01f1, blocks: (B:57:0x01e4, B:59:0x01e8, B:60:0x01f0, B:41:0x015d, B:43:0x0170, B:45:0x019c, B:52:0x01b5), top: B:81:0x015d }] */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object getMarketingGift$product_details_page_debug(String marketingId, Continuation<? super MarketingGiftResponse> continuation) {
                        MarketingGiftApiService$getMarketingGift$1 marketingGiftApiService$getMarketingGift$1;
                        MarketingGiftApiService$getMarketingGift$1 marketingGiftApiService$getMarketingGift$12;
                        HttpClient $this$post$iv;
                        HttpMessageBuilder httpRequestBuilder;
                        Object body$iv;
                        KType kType;
                        String marketingId2;
                        HttpResponse response;
                        KType kType2;
                        Object bodyNullable;
                        if (continuation instanceof MarketingGiftApiService$getMarketingGift$1) {
                            marketingGiftApiService$getMarketingGift$1 = (MarketingGiftApiService$getMarketingGift$1) continuation;
                            if ((marketingGiftApiService$getMarketingGift$1.label & Integer.MIN_VALUE) != 0) {
                                marketingGiftApiService$getMarketingGift$1.label -= Integer.MIN_VALUE;
                                marketingGiftApiService$getMarketingGift$12 = marketingGiftApiService$getMarketingGift$1;
                                Object $result = marketingGiftApiService$getMarketingGift$12.result;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (marketingGiftApiService$getMarketingGift$12.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        try {
                                            $this$post$iv = Client.INSTANCE.getHttpClient();
                                            httpRequestBuilder = new HttpRequestBuilder();
                                            HttpRequestKt.url(httpRequestBuilder, API_URL_STRING);
                                            HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
                                            body$iv = new MarketingGiftRequest(marketingId);
                                        } catch (Exception e) {
                                            e = e;
                                        }
                                        try {
                                            if (body$iv instanceof OutgoingContent) {
                                                httpRequestBuilder.setBody(body$iv);
                                                httpRequestBuilder.setBodyType((TypeInfo) null);
                                            } else {
                                                httpRequestBuilder.setBody(body$iv);
                                                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MarketingGiftRequest.class);
                                                try {
                                                    kType = Reflection.typeOf(MarketingGiftRequest.class);
                                                } catch (Throwable th) {
                                                    kType = null;
                                                }
                                                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
                                            }
                                            httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
                                            HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, $this$post$iv);
                                            marketingGiftApiService$getMarketingGift$12.L$0 = SpillingKt.nullOutSpilledVariable(marketingId);
                                            marketingGiftApiService$getMarketingGift$12.L$1 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                            marketingGiftApiService$getMarketingGift$12.L$2 = SpillingKt.nullOutSpilledVariable(API_URL_STRING);
                                            marketingGiftApiService$getMarketingGift$12.L$3 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                            marketingGiftApiService$getMarketingGift$12.L$4 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                            marketingGiftApiService$getMarketingGift$12.L$5 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                                            marketingGiftApiService$getMarketingGift$12.L$6 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                            marketingGiftApiService$getMarketingGift$12.I$0 = 0;
                                            marketingGiftApiService$getMarketingGift$12.I$1 = 0;
                                            marketingGiftApiService$getMarketingGift$12.I$2 = 0;
                                            marketingGiftApiService$getMarketingGift$12.I$3 = 0;
                                            marketingGiftApiService$getMarketingGift$12.label = 1;
                                            Object execute = httpStatement.execute(marketingGiftApiService$getMarketingGift$12);
                                            if (execute == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            $result = execute;
                                            marketingId2 = marketingId;
                                            try {
                                                response = (HttpResponse) $result;
                                                if (Intrinsics.areEqual(response.getStatus(), HttpStatusCode.Companion.getOK())) {
                                                    return new MarketingGiftResponse(Boxing.boxLong(-1L), (Integer) null, "Failed to fetch marketing gift: " + response.getStatus(), (MarketingGiftData) null, 10, (DefaultConstructorMarker) null);
                                                }
                                                HttpClientCall call = response.getCall();
                                                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(MarketingGiftResponse.class);
                                                try {
                                                    kType2 = Reflection.typeOf(MarketingGiftResponse.class);
                                                } catch (Throwable th2) {
                                                    kType2 = null;
                                                }
                                                TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass2, kType2);
                                                marketingGiftApiService$getMarketingGift$12.L$0 = SpillingKt.nullOutSpilledVariable(marketingId2);
                                                marketingGiftApiService$getMarketingGift$12.L$1 = SpillingKt.nullOutSpilledVariable(response);
                                                marketingGiftApiService$getMarketingGift$12.L$2 = SpillingKt.nullOutSpilledVariable(response);
                                                marketingGiftApiService$getMarketingGift$12.L$3 = null;
                                                marketingGiftApiService$getMarketingGift$12.L$4 = null;
                                                marketingGiftApiService$getMarketingGift$12.L$5 = null;
                                                marketingGiftApiService$getMarketingGift$12.L$6 = null;
                                                marketingGiftApiService$getMarketingGift$12.I$0 = 0;
                                                marketingGiftApiService$getMarketingGift$12.label = 2;
                                                bodyNullable = call.bodyNullable(typeInfo, marketingGiftApiService$getMarketingGift$12);
                                                if (bodyNullable == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                if (bodyNullable == null) {
                                                    MarketingGiftResponse rtValue = (MarketingGiftResponse) bodyNullable;
                                                    return rtValue;
                                                }
                                                throw new NullPointerException("null cannot be cast to non-null type kntr.app.mall.product.details.page.api.MarketingGiftApiService.MarketingGiftResponse");
                                            } catch (Exception e2) {
                                                e = e2;
                                                return new MarketingGiftResponse(Boxing.boxLong(-1L), (Integer) null, "Failed to fetch marketing gift: " + e.getMessage(), (MarketingGiftData) null, 10, (DefaultConstructorMarker) null);
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            return new MarketingGiftResponse(Boxing.boxLong(-1L), (Integer) null, "Failed to fetch marketing gift: " + e.getMessage(), (MarketingGiftData) null, 10, (DefaultConstructorMarker) null);
                                        }
                                    case 1:
                                        int i = marketingGiftApiService$getMarketingGift$12.I$3;
                                        int i2 = marketingGiftApiService$getMarketingGift$12.I$2;
                                        int i3 = marketingGiftApiService$getMarketingGift$12.I$1;
                                        int i4 = marketingGiftApiService$getMarketingGift$12.I$0;
                                        HttpClient httpClient = (HttpClient) marketingGiftApiService$getMarketingGift$12.L$6;
                                        HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) marketingGiftApiService$getMarketingGift$12.L$5;
                                        HttpClient httpClient2 = (HttpClient) marketingGiftApiService$getMarketingGift$12.L$4;
                                        HttpClient httpClient3 = (HttpClient) marketingGiftApiService$getMarketingGift$12.L$3;
                                        String str = (String) marketingGiftApiService$getMarketingGift$12.L$2;
                                        HttpClient httpClient4 = (HttpClient) marketingGiftApiService$getMarketingGift$12.L$1;
                                        String marketingId3 = (String) marketingGiftApiService$getMarketingGift$12.L$0;
                                        try {
                                            ResultKt.throwOnFailure($result);
                                            marketingId2 = marketingId3;
                                            response = (HttpResponse) $result;
                                            if (Intrinsics.areEqual(response.getStatus(), HttpStatusCode.Companion.getOK())) {
                                            }
                                        } catch (Exception e4) {
                                            e = e4;
                                            return new MarketingGiftResponse(Boxing.boxLong(-1L), (Integer) null, "Failed to fetch marketing gift: " + e.getMessage(), (MarketingGiftData) null, 10, (DefaultConstructorMarker) null);
                                        }
                                        break;
                                    case 2:
                                        int i5 = marketingGiftApiService$getMarketingGift$12.I$0;
                                        HttpResponse httpResponse = (HttpResponse) marketingGiftApiService$getMarketingGift$12.L$2;
                                        HttpResponse httpResponse2 = (HttpResponse) marketingGiftApiService$getMarketingGift$12.L$1;
                                        String str2 = (String) marketingGiftApiService$getMarketingGift$12.L$0;
                                        try {
                                            ResultKt.throwOnFailure($result);
                                            bodyNullable = $result;
                                            if (bodyNullable == null) {
                                            }
                                        } catch (Exception e5) {
                                            e = e5;
                                            return new MarketingGiftResponse(Boxing.boxLong(-1L), (Integer) null, "Failed to fetch marketing gift: " + e.getMessage(), (MarketingGiftData) null, 10, (DefaultConstructorMarker) null);
                                        }
                                        break;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            }
                        }
                        marketingGiftApiService$getMarketingGift$1 = new MarketingGiftApiService$getMarketingGift$1(this, continuation);
                        marketingGiftApiService$getMarketingGift$12 = marketingGiftApiService$getMarketingGift$1;
                        Object $result2 = marketingGiftApiService$getMarketingGift$12.result;
                        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (marketingGiftApiService$getMarketingGift$12.label) {
                        }
                    }
                }