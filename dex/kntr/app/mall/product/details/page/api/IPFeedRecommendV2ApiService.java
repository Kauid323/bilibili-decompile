package kntr.app.mall.product.details.page.api;

import com.bilibili.mall.kmm.base.MallEnvKt;
import java.util.List;
import java.util.Map;
import kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService;
import kntr.app.mall.product.details.page.api.model.ShopItem;
import kntr.app.mall.product.details.page.api.model.ShopItem$$serializer;
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
import kotlinx.serialization.json.Json;

/* compiled from: IPFeedRecommendV2ApiService.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\f\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0080@¢\u0006\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendV2ApiService;", "", "<init>", "()V", "API_URL_STRING", "", "kntrGetIPFeedRecommend", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendV2ApiService$Response;", "ipRightId", "itemIds", "kntrGetIPFeedRecommend$product_details_page_debug", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Response", "RecommendData", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class IPFeedRecommendV2ApiService {
    public static final int $stable = 0;
    public static final String API_URL_STRING = "https://mall.bilibili.com/mall-c-search/ip/items/feed/v2";
    public static final IPFeedRecommendV2ApiService INSTANCE = new IPFeedRecommendV2ApiService();

    private IPFeedRecommendV2ApiService() {
    }

    /* compiled from: IPFeedRecommendV2ApiService.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006*"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendV2ApiService$Response;", "", "code", "", "message", "", "data", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendV2ApiService$RecommendData;", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/IPFeedRecommendV2ApiService$RecommendData;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/IPFeedRecommendV2ApiService$RecommendData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMessage", "()Ljava/lang/String;", "getData", "()Lkntr/app/mall/product/details/page/api/IPFeedRecommendV2ApiService$RecommendData;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/IPFeedRecommendV2ApiService$RecommendData;)Lkntr/app/mall/product/details/page/api/IPFeedRecommendV2ApiService$Response;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Response {
        private final Long code;
        private final RecommendData data;
        private final String message;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public Response() {
            this((Long) null, (String) null, (RecommendData) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Response copy$default(Response response, Long l, String str, RecommendData recommendData, int i, Object obj) {
            if ((i & 1) != 0) {
                l = response.code;
            }
            if ((i & 2) != 0) {
                str = response.message;
            }
            if ((i & 4) != 0) {
                recommendData = response.data;
            }
            return response.copy(l, str, recommendData);
        }

        public final Long component1() {
            return this.code;
        }

        public final String component2() {
            return this.message;
        }

        public final RecommendData component3() {
            return this.data;
        }

        public final Response copy(Long l, String str, RecommendData recommendData) {
            return new Response(l, str, recommendData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Response) {
                Response response = (Response) obj;
                return Intrinsics.areEqual(this.code, response.code) && Intrinsics.areEqual(this.message, response.message) && Intrinsics.areEqual(this.data, response.data);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.code == null ? 0 : this.code.hashCode()) * 31) + (this.message == null ? 0 : this.message.hashCode())) * 31) + (this.data != null ? this.data.hashCode() : 0);
        }

        public String toString() {
            Long l = this.code;
            String str = this.message;
            return "Response(code=" + l + ", message=" + str + ", data=" + this.data + ")";
        }

        /* compiled from: IPFeedRecommendV2ApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendV2ApiService$Response$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendV2ApiService$Response;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Response> serializer() {
                return new GeneratedSerializer<Response>() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService$Response$$serializer
                    public static final int $stable;
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService.Response", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService$Response> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService$Response> A[REMOVE]) =  kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService$Response$$serializer.INSTANCE kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService$Response$$serializer)
                             in method: kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService.Response.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService$Response>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                              ("kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService.Response")
                              (wrap: kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService$Response$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService$Response$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService$Response$$serializer.INSTANCE kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService$Response$$serializer)
                              (3 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService$Response$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService$Response$$serializer
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
                            kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService$Response$$serializer r0 = kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService$Response$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService.Response.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ Response(int seen0, Long code, String message, RecommendData data, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.code = 0L;
                    } else {
                        this.code = code;
                    }
                    if ((seen0 & 2) == 0) {
                        this.message = null;
                    } else {
                        this.message = message;
                    }
                    if ((seen0 & 4) == 0) {
                        this.data = null;
                    } else {
                        this.data = data;
                    }
                }

                public Response(Long code, String message, RecommendData data) {
                    this.code = code;
                    this.message = message;
                    this.data = data;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(Response self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Long l;
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || (l = self.code) == null || l.longValue() != 0) {
                        output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.code);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.message != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.message);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.data != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, IPFeedRecommendV2ApiService$RecommendData$$serializer.INSTANCE, self.data);
                    }
                }

                public /* synthetic */ Response(Long l, String str, RecommendData recommendData, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? 0L : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : recommendData);
                }

                public final Long getCode() {
                    return this.code;
                }

                public final String getMessage() {
                    return this.message;
                }

                public final RecommendData getData() {
                    return this.data;
                }
            }

            /* compiled from: IPFeedRecommendV2ApiService.kt */
            @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000201BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fB]\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\\\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001J%\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001¢\u0006\u0002\b/R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u00062"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendV2ApiService$RecommendData;", "", "total", "", "size", "pageNum", "pageSize", "pages", "list", "", "Lkntr/app/mall/product/details/page/api/model/ShopItem;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTotal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSize", "getPageNum", "getPageSize", "getPages", "getList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lkntr/app/mall/product/details/page/api/IPFeedRecommendV2ApiService$RecommendData;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class RecommendData {
                private final List<ShopItem> list;
                private final Integer pageNum;
                private final Integer pageSize;
                private final Integer pages;
                private final Integer size;
                private final Integer total;
                public static final Companion Companion = new Companion(null);
                public static final int $stable = 8;
                private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService$RecommendData$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        KSerializer _childSerializers$_anonymous_;
                        _childSerializers$_anonymous_ = IPFeedRecommendV2ApiService.RecommendData._childSerializers$_anonymous_();
                        return _childSerializers$_anonymous_;
                    }
                })};

                public RecommendData() {
                    this((Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (List) null, 63, (DefaultConstructorMarker) null);
                }

                public static /* synthetic */ RecommendData copy$default(RecommendData recommendData, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, List list, int i, Object obj) {
                    if ((i & 1) != 0) {
                        num = recommendData.total;
                    }
                    if ((i & 2) != 0) {
                        num2 = recommendData.size;
                    }
                    Integer num6 = num2;
                    if ((i & 4) != 0) {
                        num3 = recommendData.pageNum;
                    }
                    Integer num7 = num3;
                    if ((i & 8) != 0) {
                        num4 = recommendData.pageSize;
                    }
                    Integer num8 = num4;
                    if ((i & 16) != 0) {
                        num5 = recommendData.pages;
                    }
                    Integer num9 = num5;
                    List<ShopItem> list2 = list;
                    if ((i & 32) != 0) {
                        list2 = recommendData.list;
                    }
                    return recommendData.copy(num, num6, num7, num8, num9, list2);
                }

                public final Integer component1() {
                    return this.total;
                }

                public final Integer component2() {
                    return this.size;
                }

                public final Integer component3() {
                    return this.pageNum;
                }

                public final Integer component4() {
                    return this.pageSize;
                }

                public final Integer component5() {
                    return this.pages;
                }

                public final List<ShopItem> component6() {
                    return this.list;
                }

                public final RecommendData copy(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, List<ShopItem> list) {
                    return new RecommendData(num, num2, num3, num4, num5, list);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof RecommendData) {
                        RecommendData recommendData = (RecommendData) obj;
                        return Intrinsics.areEqual(this.total, recommendData.total) && Intrinsics.areEqual(this.size, recommendData.size) && Intrinsics.areEqual(this.pageNum, recommendData.pageNum) && Intrinsics.areEqual(this.pageSize, recommendData.pageSize) && Intrinsics.areEqual(this.pages, recommendData.pages) && Intrinsics.areEqual(this.list, recommendData.list);
                    }
                    return false;
                }

                public int hashCode() {
                    return ((((((((((this.total == null ? 0 : this.total.hashCode()) * 31) + (this.size == null ? 0 : this.size.hashCode())) * 31) + (this.pageNum == null ? 0 : this.pageNum.hashCode())) * 31) + (this.pageSize == null ? 0 : this.pageSize.hashCode())) * 31) + (this.pages == null ? 0 : this.pages.hashCode())) * 31) + (this.list != null ? this.list.hashCode() : 0);
                }

                public String toString() {
                    Integer num = this.total;
                    Integer num2 = this.size;
                    Integer num3 = this.pageNum;
                    Integer num4 = this.pageSize;
                    Integer num5 = this.pages;
                    return "RecommendData(total=" + num + ", size=" + num2 + ", pageNum=" + num3 + ", pageSize=" + num4 + ", pages=" + num5 + ", list=" + this.list + ")";
                }

                /* compiled from: IPFeedRecommendV2ApiService.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/IPFeedRecommendV2ApiService$RecommendData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendV2ApiService$RecommendData;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<RecommendData> serializer() {
                        return IPFeedRecommendV2ApiService$RecommendData$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ RecommendData(int seen0, Integer total, Integer size, Integer pageNum, Integer pageSize, Integer pages, List list, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.total = null;
                    } else {
                        this.total = total;
                    }
                    if ((seen0 & 2) == 0) {
                        this.size = null;
                    } else {
                        this.size = size;
                    }
                    if ((seen0 & 4) == 0) {
                        this.pageNum = null;
                    } else {
                        this.pageNum = pageNum;
                    }
                    if ((seen0 & 8) == 0) {
                        this.pageSize = null;
                    } else {
                        this.pageSize = pageSize;
                    }
                    if ((seen0 & 16) == 0) {
                        this.pages = null;
                    } else {
                        this.pages = pages;
                    }
                    if ((seen0 & 32) == 0) {
                        this.list = null;
                    } else {
                        this.list = list;
                    }
                }

                public RecommendData(Integer total, Integer size, Integer pageNum, Integer pageSize, Integer pages, List<ShopItem> list) {
                    this.total = total;
                    this.size = size;
                    this.pageNum = pageNum;
                    this.pageSize = pageSize;
                    this.pages = pages;
                    this.list = list;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                    return new ArrayListSerializer(ShopItem$$serializer.INSTANCE);
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(RecommendData self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.total != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.total);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.size != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.size);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.pageNum != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.pageNum);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.pageSize != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.pageSize);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.pages != null) {
                        output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.pages);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 5) || self.list != null) {
                        output.encodeNullableSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.list);
                    }
                }

                public /* synthetic */ RecommendData(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : num5, (i & 32) != 0 ? null : list);
                }

                public final Integer getTotal() {
                    return this.total;
                }

                public final Integer getSize() {
                    return this.size;
                }

                public final Integer getPageNum() {
                    return this.pageNum;
                }

                public final Integer getPageSize() {
                    return this.pageSize;
                }

                public final Integer getPages() {
                    return this.pages;
                }

                public final List<ShopItem> getList() {
                    return this.list;
                }
            }

            public static /* synthetic */ Object kntrGetIPFeedRecommend$product_details_page_debug$default(IPFeedRecommendV2ApiService iPFeedRecommendV2ApiService, String str, String str2, Continuation continuation, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = null;
                }
                if ((i & 2) != 0) {
                    str2 = null;
                }
                return iPFeedRecommendV2ApiService.kntrGetIPFeedRecommend$product_details_page_debug(str, str2, continuation);
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
            /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0069  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object kntrGetIPFeedRecommend$product_details_page_debug(String ipRightId, String itemIds, Continuation<? super Response> continuation) {
                IPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1 iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1;
                Client client;
                Pair[] pairArr;
                Client $this$iv;
                int $i$f$kntrRequest$product_details_page_debug;
                Object mallKntrAsyncRequest;
                try {
                    if (continuation instanceof IPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1) {
                        iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1 = (IPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1) continuation;
                        if ((iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1.label & Integer.MIN_VALUE) != 0) {
                            iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1.label -= Integer.MIN_VALUE;
                            Object $result = iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1.label) {
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
                                        pairArr[6] = TuplesKt.to("pageSize", Boxing.boxInt(10));
                                        pairArr[7] = TuplesKt.to("termQueries", CollectionsKt.listOf(new Map[]{MapsKt.mapOf(new Pair[]{TuplesKt.to("field", "ip"), TuplesKt.to("values", CollectionsKt.listOfNotNull(ipRightId))}), MapsKt.mapOf(new Pair[]{TuplesKt.to("field", "6"), TuplesKt.to("values", CollectionsKt.listOf("0,2,3,5,6,7"))})}));
                                        Map params$iv = MapsKt.mapOf(pairArr);
                                        $this$iv = client;
                                        try {
                                            iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1.L$0 = SpillingKt.nullOutSpilledVariable(ipRightId);
                                            iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1.L$1 = SpillingKt.nullOutSpilledVariable(itemIds);
                                            iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1.L$2 = $this$iv;
                                            iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1.L$3 = SpillingKt.nullOutSpilledVariable(API_URL_STRING);
                                            iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1.L$4 = SpillingKt.nullOutSpilledVariable("POST");
                                            iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1.L$5 = SpillingKt.nullOutSpilledVariable(params$iv);
                                            iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1.I$0 = 0;
                                            iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1.label = 1;
                                            mallKntrAsyncRequest = MallEnvKt.mallKntrAsyncRequest(API_URL_STRING, "POST", (Map) null, params$iv, iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1);
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
                                        return new Response(Boxing.boxLong(-1L), "Failed to fetch IP feed recommend: " + e.getMessage(), (RecommendData) null, 4, (DefaultConstructorMarker) null);
                                    }
                                case 1:
                                    $i$f$kntrRequest$product_details_page_debug = iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1.I$0;
                                    Map map = (Map) iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1.L$5;
                                    String str = (String) iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1.L$4;
                                    String str2 = (String) iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1.L$3;
                                    $this$iv = (Client) iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1.L$2;
                                    String str3 = (String) iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1.L$1;
                                    String str4 = (String) iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1.L$0;
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
                    switch (iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1.label) {
                    }
                } catch (Exception e6) {
                    e = e6;
                }
                iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1 = new IPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1(this, continuation);
                Object $result2 = iPFeedRecommendV2ApiService$kntrGetIPFeedRecommend$1.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
        }