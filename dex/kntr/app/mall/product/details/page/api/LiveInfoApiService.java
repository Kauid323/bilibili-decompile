package kntr.app.mall.product.details.page.api;

import com.bilibili.mall.kmm.base.MallEnvKt;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import java.util.Map;
import kntr.app.mall.product.details.page.api.LiveInfoApiService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.KotlinVersion;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: LiveInfoApiService.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0080@¢\u0006\u0004\b\u000b\u0010\fJ0\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0080@¢\u0006\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkntr/app/mall/product/details/page/api/LiveInfoApiService;", "", "<init>", "()V", "API_URL_STRING", "", "K_LOG_TAG", "getLiveInfo", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoResponse;", "itemsId", "", "getLiveInfo$product_details_page_debug", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mallKntrGetLiveInfo", "itemsVersion", "shopId", "mallKntrGetLiveInfo$product_details_page_debug", "(ILjava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LiveInfoResponse", "LiveInfoData", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LiveInfoApiService {
    public static final int $stable = 0;
    private static final String API_URL_STRING = "https://mall.bilibili.com/mall-c-search/items/info/live";
    public static final LiveInfoApiService INSTANCE = new LiveInfoApiService();
    private static final String K_LOG_TAG = "NA_WR_LiveInfoApiService";

    private LiveInfoApiService() {
    }

    /* compiled from: LiveInfoApiService.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBC\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020\tHÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006/"}, d2 = {"Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoResponse;", "", "code", "", "data", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData;", "errtag", "", "message", "", "<init>", "(Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData;Ljava/lang/Integer;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getData", "()Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData;", "getErrtag", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData;Ljava/lang/Integer;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoResponse;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class LiveInfoResponse {
        private final Long code;
        private final LiveInfoData data;
        private final Integer errtag;
        private final String message;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public LiveInfoResponse() {
            this((Long) null, (LiveInfoData) null, (Integer) null, (String) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ LiveInfoResponse copy$default(LiveInfoResponse liveInfoResponse, Long l, LiveInfoData liveInfoData, Integer num, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                l = liveInfoResponse.code;
            }
            if ((i & 2) != 0) {
                liveInfoData = liveInfoResponse.data;
            }
            if ((i & 4) != 0) {
                num = liveInfoResponse.errtag;
            }
            if ((i & 8) != 0) {
                str = liveInfoResponse.message;
            }
            return liveInfoResponse.copy(l, liveInfoData, num, str);
        }

        public final Long component1() {
            return this.code;
        }

        public final LiveInfoData component2() {
            return this.data;
        }

        public final Integer component3() {
            return this.errtag;
        }

        public final String component4() {
            return this.message;
        }

        public final LiveInfoResponse copy(Long l, LiveInfoData liveInfoData, Integer num, String str) {
            return new LiveInfoResponse(l, liveInfoData, num, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LiveInfoResponse) {
                LiveInfoResponse liveInfoResponse = (LiveInfoResponse) obj;
                return Intrinsics.areEqual(this.code, liveInfoResponse.code) && Intrinsics.areEqual(this.data, liveInfoResponse.data) && Intrinsics.areEqual(this.errtag, liveInfoResponse.errtag) && Intrinsics.areEqual(this.message, liveInfoResponse.message);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.code == null ? 0 : this.code.hashCode()) * 31) + (this.data == null ? 0 : this.data.hashCode())) * 31) + (this.errtag == null ? 0 : this.errtag.hashCode())) * 31) + (this.message != null ? this.message.hashCode() : 0);
        }

        public String toString() {
            Long l = this.code;
            LiveInfoData liveInfoData = this.data;
            Integer num = this.errtag;
            return "LiveInfoResponse(code=" + l + ", data=" + liveInfoData + ", errtag=" + num + ", message=" + this.message + ")";
        }

        /* compiled from: LiveInfoApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoResponse;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<LiveInfoResponse> serializer() {
                return new GeneratedSerializer<LiveInfoResponse>() { // from class: kntr.app.mall.product.details.page.api.LiveInfoApiService$LiveInfoResponse$$serializer
                    public static final int $stable;
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.LiveInfoApiService.LiveInfoResponse", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.LiveInfoApiService$LiveInfoResponse> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.LiveInfoApiService$LiveInfoResponse> A[REMOVE]) =  kntr.app.mall.product.details.page.api.LiveInfoApiService$LiveInfoResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.LiveInfoApiService$LiveInfoResponse$$serializer)
                             in method: kntr.app.mall.product.details.page.api.LiveInfoApiService.LiveInfoResponse.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.LiveInfoApiService$LiveInfoResponse>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                              ("kntr.app.mall.product.details.page.api.LiveInfoApiService.LiveInfoResponse")
                              (wrap: kntr.app.mall.product.details.page.api.LiveInfoApiService$LiveInfoResponse$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.LiveInfoApiService$LiveInfoResponse$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.LiveInfoApiService$LiveInfoResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.LiveInfoApiService$LiveInfoResponse$$serializer)
                              (4 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.LiveInfoApiService$LiveInfoResponse$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.LiveInfoApiService$LiveInfoResponse$$serializer
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
                            kntr.app.mall.product.details.page.api.LiveInfoApiService$LiveInfoResponse$$serializer r0 = kntr.app.mall.product.details.page.api.LiveInfoApiService$LiveInfoResponse$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.LiveInfoApiService.LiveInfoResponse.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ LiveInfoResponse(int seen0, Long code, LiveInfoData data, Integer errtag, String message, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.code = 0L;
                    } else {
                        this.code = code;
                    }
                    if ((seen0 & 2) == 0) {
                        this.data = null;
                    } else {
                        this.data = data;
                    }
                    if ((seen0 & 4) == 0) {
                        this.errtag = null;
                    } else {
                        this.errtag = errtag;
                    }
                    if ((seen0 & 8) == 0) {
                        this.message = null;
                    } else {
                        this.message = message;
                    }
                }

                public LiveInfoResponse(Long code, LiveInfoData data, Integer errtag, String message) {
                    this.code = code;
                    this.data = data;
                    this.errtag = errtag;
                    this.message = message;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(LiveInfoResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Long l;
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || (l = self.code) == null || l.longValue() != 0) {
                        output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.code);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.data != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, LiveInfoApiService$LiveInfoData$$serializer.INSTANCE, self.data);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.errtag != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.errtag);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.message != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.message);
                    }
                }

                public /* synthetic */ LiveInfoResponse(Long l, LiveInfoData liveInfoData, Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? 0L : l, (i & 2) != 0 ? null : liveInfoData, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str);
                }

                public final Long getCode() {
                    return this.code;
                }

                public final LiveInfoData getData() {
                    return this.data;
                }

                public final Integer getErrtag() {
                    return this.errtag;
                }

                public final String getMessage() {
                    return this.message;
                }
            }

            /* compiled from: LiveInfoApiService.kt */
            @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0004,-./BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\rHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u00060"}, d2 = {"Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData;", "", "jumpUrl", "", "lotteryDash", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash;", "promotionAtmosphereInfo", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$PromotionAtmosphereInfo;", "subTitle", "title", "<init>", "(Ljava/lang/String;Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash;Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$PromotionAtmosphereInfo;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash;Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$PromotionAtmosphereInfo;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getJumpUrl", "()Ljava/lang/String;", "getLotteryDash", "()Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash;", "getPromotionAtmosphereInfo", "()Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$PromotionAtmosphereInfo;", "getSubTitle", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "LotteryDash", "PromotionAtmosphereInfo", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class LiveInfoData {
                private final String jumpUrl;
                private final LotteryDash lotteryDash;
                private final PromotionAtmosphereInfo promotionAtmosphereInfo;
                private final String subTitle;
                private final String title;
                public static final Companion Companion = new Companion(null);
                public static final int $stable = 8;

                public LiveInfoData() {
                    this((String) null, (LotteryDash) null, (PromotionAtmosphereInfo) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
                }

                public static /* synthetic */ LiveInfoData copy$default(LiveInfoData liveInfoData, String str, LotteryDash lotteryDash, PromotionAtmosphereInfo promotionAtmosphereInfo, String str2, String str3, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = liveInfoData.jumpUrl;
                    }
                    if ((i & 2) != 0) {
                        lotteryDash = liveInfoData.lotteryDash;
                    }
                    LotteryDash lotteryDash2 = lotteryDash;
                    if ((i & 4) != 0) {
                        promotionAtmosphereInfo = liveInfoData.promotionAtmosphereInfo;
                    }
                    PromotionAtmosphereInfo promotionAtmosphereInfo2 = promotionAtmosphereInfo;
                    if ((i & 8) != 0) {
                        str2 = liveInfoData.subTitle;
                    }
                    String str4 = str2;
                    if ((i & 16) != 0) {
                        str3 = liveInfoData.title;
                    }
                    return liveInfoData.copy(str, lotteryDash2, promotionAtmosphereInfo2, str4, str3);
                }

                public final String component1() {
                    return this.jumpUrl;
                }

                public final LotteryDash component2() {
                    return this.lotteryDash;
                }

                public final PromotionAtmosphereInfo component3() {
                    return this.promotionAtmosphereInfo;
                }

                public final String component4() {
                    return this.subTitle;
                }

                public final String component5() {
                    return this.title;
                }

                public final LiveInfoData copy(String str, LotteryDash lotteryDash, PromotionAtmosphereInfo promotionAtmosphereInfo, String str2, String str3) {
                    return new LiveInfoData(str, lotteryDash, promotionAtmosphereInfo, str2, str3);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof LiveInfoData) {
                        LiveInfoData liveInfoData = (LiveInfoData) obj;
                        return Intrinsics.areEqual(this.jumpUrl, liveInfoData.jumpUrl) && Intrinsics.areEqual(this.lotteryDash, liveInfoData.lotteryDash) && Intrinsics.areEqual(this.promotionAtmosphereInfo, liveInfoData.promotionAtmosphereInfo) && Intrinsics.areEqual(this.subTitle, liveInfoData.subTitle) && Intrinsics.areEqual(this.title, liveInfoData.title);
                    }
                    return false;
                }

                public int hashCode() {
                    return ((((((((this.jumpUrl == null ? 0 : this.jumpUrl.hashCode()) * 31) + (this.lotteryDash == null ? 0 : this.lotteryDash.hashCode())) * 31) + (this.promotionAtmosphereInfo == null ? 0 : this.promotionAtmosphereInfo.hashCode())) * 31) + (this.subTitle == null ? 0 : this.subTitle.hashCode())) * 31) + (this.title != null ? this.title.hashCode() : 0);
                }

                public String toString() {
                    String str = this.jumpUrl;
                    LotteryDash lotteryDash = this.lotteryDash;
                    PromotionAtmosphereInfo promotionAtmosphereInfo = this.promotionAtmosphereInfo;
                    String str2 = this.subTitle;
                    return "LiveInfoData(jumpUrl=" + str + ", lotteryDash=" + lotteryDash + ", promotionAtmosphereInfo=" + promotionAtmosphereInfo + ", subTitle=" + str2 + ", title=" + this.title + ")";
                }

                /* compiled from: LiveInfoApiService.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<LiveInfoData> serializer() {
                        return LiveInfoApiService$LiveInfoData$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ LiveInfoData(int seen0, String jumpUrl, LotteryDash lotteryDash, PromotionAtmosphereInfo promotionAtmosphereInfo, String subTitle, String title, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.jumpUrl = null;
                    } else {
                        this.jumpUrl = jumpUrl;
                    }
                    if ((seen0 & 2) == 0) {
                        this.lotteryDash = null;
                    } else {
                        this.lotteryDash = lotteryDash;
                    }
                    if ((seen0 & 4) == 0) {
                        this.promotionAtmosphereInfo = null;
                    } else {
                        this.promotionAtmosphereInfo = promotionAtmosphereInfo;
                    }
                    if ((seen0 & 8) == 0) {
                        this.subTitle = null;
                    } else {
                        this.subTitle = subTitle;
                    }
                    if ((seen0 & 16) == 0) {
                        this.title = null;
                    } else {
                        this.title = title;
                    }
                }

                public LiveInfoData(String jumpUrl, LotteryDash lotteryDash, PromotionAtmosphereInfo promotionAtmosphereInfo, String subTitle, String title) {
                    this.jumpUrl = jumpUrl;
                    this.lotteryDash = lotteryDash;
                    this.promotionAtmosphereInfo = promotionAtmosphereInfo;
                    this.subTitle = subTitle;
                    this.title = title;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(LiveInfoData self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.jumpUrl != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.jumpUrl);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.lotteryDash != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, LiveInfoApiService$LiveInfoData$LotteryDash$$serializer.INSTANCE, self.lotteryDash);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.promotionAtmosphereInfo != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, LiveInfoApiService$LiveInfoData$PromotionAtmosphereInfo$$serializer.INSTANCE, self.promotionAtmosphereInfo);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.subTitle != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.subTitle);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.title != null) {
                        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.title);
                    }
                }

                public /* synthetic */ LiveInfoData(String str, LotteryDash lotteryDash, PromotionAtmosphereInfo promotionAtmosphereInfo, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : lotteryDash, (i & 4) != 0 ? null : promotionAtmosphereInfo, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3);
                }

                public final String getJumpUrl() {
                    return this.jumpUrl;
                }

                public final LotteryDash getLotteryDash() {
                    return this.lotteryDash;
                }

                public final PromotionAtmosphereInfo getPromotionAtmosphereInfo() {
                    return this.promotionAtmosphereInfo;
                }

                public final String getSubTitle() {
                    return this.subTitle;
                }

                /* compiled from: LiveInfoApiService.kt */
                @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0004\"#$%B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\tHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006&"}, d2 = {"Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash;", "", "activityInfo", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo;", "userActivityInfo", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo;", "<init>", "(Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo;Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo;Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActivityInfo", "()Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo;", "getUserActivityInfo", "()Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ActivityInfo", "UserActivityInfo", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                @Serializable
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class LotteryDash {
                    private final ActivityInfo activityInfo;
                    private final UserActivityInfo userActivityInfo;
                    public static final Companion Companion = new Companion(null);
                    public static final int $stable = 8;

                    public LotteryDash() {
                        this((ActivityInfo) null, (UserActivityInfo) null, 3, (DefaultConstructorMarker) null);
                    }

                    public static /* synthetic */ LotteryDash copy$default(LotteryDash lotteryDash, ActivityInfo activityInfo, UserActivityInfo userActivityInfo, int i, Object obj) {
                        if ((i & 1) != 0) {
                            activityInfo = lotteryDash.activityInfo;
                        }
                        if ((i & 2) != 0) {
                            userActivityInfo = lotteryDash.userActivityInfo;
                        }
                        return lotteryDash.copy(activityInfo, userActivityInfo);
                    }

                    public final ActivityInfo component1() {
                        return this.activityInfo;
                    }

                    public final UserActivityInfo component2() {
                        return this.userActivityInfo;
                    }

                    public final LotteryDash copy(ActivityInfo activityInfo, UserActivityInfo userActivityInfo) {
                        return new LotteryDash(activityInfo, userActivityInfo);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof LotteryDash) {
                            LotteryDash lotteryDash = (LotteryDash) obj;
                            return Intrinsics.areEqual(this.activityInfo, lotteryDash.activityInfo) && Intrinsics.areEqual(this.userActivityInfo, lotteryDash.userActivityInfo);
                        }
                        return false;
                    }

                    public int hashCode() {
                        return ((this.activityInfo == null ? 0 : this.activityInfo.hashCode()) * 31) + (this.userActivityInfo != null ? this.userActivityInfo.hashCode() : 0);
                    }

                    public String toString() {
                        ActivityInfo activityInfo = this.activityInfo;
                        return "LotteryDash(activityInfo=" + activityInfo + ", userActivityInfo=" + this.userActivityInfo + ")";
                    }

                    /* compiled from: LiveInfoApiService.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<LotteryDash> serializer() {
                            return LiveInfoApiService$LiveInfoData$LotteryDash$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ LotteryDash(int seen0, ActivityInfo activityInfo, UserActivityInfo userActivityInfo, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((seen0 & 1) == 0) {
                            this.activityInfo = null;
                        } else {
                            this.activityInfo = activityInfo;
                        }
                        if ((seen0 & 2) == 0) {
                            this.userActivityInfo = null;
                        } else {
                            this.userActivityInfo = userActivityInfo;
                        }
                    }

                    public LotteryDash(ActivityInfo activityInfo, UserActivityInfo userActivityInfo) {
                        this.activityInfo = activityInfo;
                        this.userActivityInfo = userActivityInfo;
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$product_details_page_debug(LotteryDash self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.activityInfo != null) {
                            output.encodeNullableSerializableElement(serialDesc, 0, LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo$$serializer.INSTANCE, self.activityInfo);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.userActivityInfo != null) {
                            output.encodeNullableSerializableElement(serialDesc, 1, LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo$$serializer.INSTANCE, self.userActivityInfo);
                        }
                    }

                    public /* synthetic */ LotteryDash(ActivityInfo activityInfo, UserActivityInfo userActivityInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : activityInfo, (i & 2) != 0 ? null : userActivityInfo);
                    }

                    public final ActivityInfo getActivityInfo() {
                        return this.activityInfo;
                    }

                    /* compiled from: LiveInfoApiService.kt */
                    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 O2\u00020\u0001:\u0003MNOBÁ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0016\u0010\u0017B·\u0001\b\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0016\u0010\u001bJ\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00103\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00104\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00107\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010>\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 JÈ\u0001\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020\b2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020\u0006HÖ\u0001J\t\u0010D\u001a\u00020\u0003HÖ\u0001J%\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0001¢\u0006\u0002\bLR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010#\u001a\u0004\b\u0007\u0010\"R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010!\u001a\u0004\b$\u0010 R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010!\u001a\u0004\b'\u0010 R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010!\u001a\u0004\b(\u0010 R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010!\u001a\u0004\b+\u0010 R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010!\u001a\u0004\b.\u0010 R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010!\u001a\u0004\b/\u0010 ¨\u0006P"}, d2 = {"Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo;", "", "activityTimeText", "", "buyTimeText", "endTime", "", "isSubmitted", "", "joinCnt", "joinList", "", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo$JoinModel;", "maxBuyTime", "publishTime", "publishTimeText", "ruleUrl", "startTime", "taskId", "taskStatus", "totalWinnerCount", "winnerCount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActivityTimeText", "()Ljava/lang/String;", "getBuyTimeText", "getEndTime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getJoinCnt", "getJoinList", "()Ljava/util/List;", "getMaxBuyTime", "getPublishTime", "getPublishTimeText", "getRuleUrl", "getStartTime", "getTaskId", "getTaskStatus", "getTotalWinnerCount", "getWinnerCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "JoinModel", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    @Serializable
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class ActivityInfo {
                        private final String activityTimeText;
                        private final String buyTimeText;
                        private final Integer endTime;
                        private final Boolean isSubmitted;
                        private final Integer joinCnt;
                        private final List<JoinModel> joinList;
                        private final Integer maxBuyTime;
                        private final Integer publishTime;
                        private final String publishTimeText;
                        private final String ruleUrl;
                        private final Integer startTime;
                        private final String taskId;
                        private final String taskStatus;
                        private final Integer totalWinnerCount;
                        private final Integer winnerCount;
                        public static final Companion Companion = new Companion(null);
                        public static final int $stable = 8;
                        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                KSerializer _childSerializers$_anonymous_;
                                _childSerializers$_anonymous_ = LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo._childSerializers$_anonymous_();
                                return _childSerializers$_anonymous_;
                            }
                        }), null, null, null, null, null, null, null, null, null};

                        public ActivityInfo() {
                            this((String) null, (String) null, (Integer) null, (Boolean) null, (Integer) null, (List) null, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (Integer) null, (Integer) null, 32767, (DefaultConstructorMarker) null);
                        }

                        public final String component1() {
                            return this.activityTimeText;
                        }

                        public final String component10() {
                            return this.ruleUrl;
                        }

                        public final Integer component11() {
                            return this.startTime;
                        }

                        public final String component12() {
                            return this.taskId;
                        }

                        public final String component13() {
                            return this.taskStatus;
                        }

                        public final Integer component14() {
                            return this.totalWinnerCount;
                        }

                        public final Integer component15() {
                            return this.winnerCount;
                        }

                        public final String component2() {
                            return this.buyTimeText;
                        }

                        public final Integer component3() {
                            return this.endTime;
                        }

                        public final Boolean component4() {
                            return this.isSubmitted;
                        }

                        public final Integer component5() {
                            return this.joinCnt;
                        }

                        public final List<JoinModel> component6() {
                            return this.joinList;
                        }

                        public final Integer component7() {
                            return this.maxBuyTime;
                        }

                        public final Integer component8() {
                            return this.publishTime;
                        }

                        public final String component9() {
                            return this.publishTimeText;
                        }

                        public final ActivityInfo copy(String str, String str2, Integer num, Boolean bool, Integer num2, List<JoinModel> list, Integer num3, Integer num4, String str3, String str4, Integer num5, String str5, String str6, Integer num6, Integer num7) {
                            return new ActivityInfo(str, str2, num, bool, num2, list, num3, num4, str3, str4, num5, str5, str6, num6, num7);
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj instanceof ActivityInfo) {
                                ActivityInfo activityInfo = (ActivityInfo) obj;
                                return Intrinsics.areEqual(this.activityTimeText, activityInfo.activityTimeText) && Intrinsics.areEqual(this.buyTimeText, activityInfo.buyTimeText) && Intrinsics.areEqual(this.endTime, activityInfo.endTime) && Intrinsics.areEqual(this.isSubmitted, activityInfo.isSubmitted) && Intrinsics.areEqual(this.joinCnt, activityInfo.joinCnt) && Intrinsics.areEqual(this.joinList, activityInfo.joinList) && Intrinsics.areEqual(this.maxBuyTime, activityInfo.maxBuyTime) && Intrinsics.areEqual(this.publishTime, activityInfo.publishTime) && Intrinsics.areEqual(this.publishTimeText, activityInfo.publishTimeText) && Intrinsics.areEqual(this.ruleUrl, activityInfo.ruleUrl) && Intrinsics.areEqual(this.startTime, activityInfo.startTime) && Intrinsics.areEqual(this.taskId, activityInfo.taskId) && Intrinsics.areEqual(this.taskStatus, activityInfo.taskStatus) && Intrinsics.areEqual(this.totalWinnerCount, activityInfo.totalWinnerCount) && Intrinsics.areEqual(this.winnerCount, activityInfo.winnerCount);
                            }
                            return false;
                        }

                        public int hashCode() {
                            return ((((((((((((((((((((((((((((this.activityTimeText == null ? 0 : this.activityTimeText.hashCode()) * 31) + (this.buyTimeText == null ? 0 : this.buyTimeText.hashCode())) * 31) + (this.endTime == null ? 0 : this.endTime.hashCode())) * 31) + (this.isSubmitted == null ? 0 : this.isSubmitted.hashCode())) * 31) + (this.joinCnt == null ? 0 : this.joinCnt.hashCode())) * 31) + (this.joinList == null ? 0 : this.joinList.hashCode())) * 31) + (this.maxBuyTime == null ? 0 : this.maxBuyTime.hashCode())) * 31) + (this.publishTime == null ? 0 : this.publishTime.hashCode())) * 31) + (this.publishTimeText == null ? 0 : this.publishTimeText.hashCode())) * 31) + (this.ruleUrl == null ? 0 : this.ruleUrl.hashCode())) * 31) + (this.startTime == null ? 0 : this.startTime.hashCode())) * 31) + (this.taskId == null ? 0 : this.taskId.hashCode())) * 31) + (this.taskStatus == null ? 0 : this.taskStatus.hashCode())) * 31) + (this.totalWinnerCount == null ? 0 : this.totalWinnerCount.hashCode())) * 31) + (this.winnerCount != null ? this.winnerCount.hashCode() : 0);
                        }

                        public String toString() {
                            String str = this.activityTimeText;
                            String str2 = this.buyTimeText;
                            Integer num = this.endTime;
                            Boolean bool = this.isSubmitted;
                            Integer num2 = this.joinCnt;
                            List<JoinModel> list = this.joinList;
                            Integer num3 = this.maxBuyTime;
                            Integer num4 = this.publishTime;
                            String str3 = this.publishTimeText;
                            String str4 = this.ruleUrl;
                            Integer num5 = this.startTime;
                            String str5 = this.taskId;
                            String str6 = this.taskStatus;
                            Integer num6 = this.totalWinnerCount;
                            return "ActivityInfo(activityTimeText=" + str + ", buyTimeText=" + str2 + ", endTime=" + num + ", isSubmitted=" + bool + ", joinCnt=" + num2 + ", joinList=" + list + ", maxBuyTime=" + num3 + ", publishTime=" + num4 + ", publishTimeText=" + str3 + ", ruleUrl=" + str4 + ", startTime=" + num5 + ", taskId=" + str5 + ", taskStatus=" + str6 + ", totalWinnerCount=" + num6 + ", winnerCount=" + this.winnerCount + ")";
                        }

                        /* compiled from: LiveInfoApiService.kt */
                        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class Companion {
                            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                this();
                            }

                            private Companion() {
                            }

                            public final KSerializer<ActivityInfo> serializer() {
                                return LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo$$serializer.INSTANCE;
                            }
                        }

                        public /* synthetic */ ActivityInfo(int seen0, String activityTimeText, String buyTimeText, Integer endTime, Boolean isSubmitted, Integer joinCnt, List joinList, Integer maxBuyTime, Integer publishTime, String publishTimeText, String ruleUrl, Integer startTime, String taskId, String taskStatus, Integer totalWinnerCount, Integer winnerCount, SerializationConstructorMarker serializationConstructorMarker) {
                            if ((seen0 & 1) == 0) {
                                this.activityTimeText = null;
                            } else {
                                this.activityTimeText = activityTimeText;
                            }
                            if ((seen0 & 2) == 0) {
                                this.buyTimeText = null;
                            } else {
                                this.buyTimeText = buyTimeText;
                            }
                            if ((seen0 & 4) == 0) {
                                this.endTime = null;
                            } else {
                                this.endTime = endTime;
                            }
                            if ((seen0 & 8) == 0) {
                                this.isSubmitted = null;
                            } else {
                                this.isSubmitted = isSubmitted;
                            }
                            if ((seen0 & 16) == 0) {
                                this.joinCnt = null;
                            } else {
                                this.joinCnt = joinCnt;
                            }
                            if ((seen0 & 32) == 0) {
                                this.joinList = null;
                            } else {
                                this.joinList = joinList;
                            }
                            if ((seen0 & 64) == 0) {
                                this.maxBuyTime = null;
                            } else {
                                this.maxBuyTime = maxBuyTime;
                            }
                            if ((seen0 & 128) == 0) {
                                this.publishTime = null;
                            } else {
                                this.publishTime = publishTime;
                            }
                            if ((seen0 & 256) == 0) {
                                this.publishTimeText = null;
                            } else {
                                this.publishTimeText = publishTimeText;
                            }
                            if ((seen0 & 512) == 0) {
                                this.ruleUrl = null;
                            } else {
                                this.ruleUrl = ruleUrl;
                            }
                            if ((seen0 & 1024) == 0) {
                                this.startTime = null;
                            } else {
                                this.startTime = startTime;
                            }
                            if ((seen0 & 2048) == 0) {
                                this.taskId = null;
                            } else {
                                this.taskId = taskId;
                            }
                            if ((seen0 & 4096) == 0) {
                                this.taskStatus = null;
                            } else {
                                this.taskStatus = taskStatus;
                            }
                            if ((seen0 & 8192) == 0) {
                                this.totalWinnerCount = null;
                            } else {
                                this.totalWinnerCount = totalWinnerCount;
                            }
                            if ((seen0 & 16384) == 0) {
                                this.winnerCount = null;
                            } else {
                                this.winnerCount = winnerCount;
                            }
                        }

                        public ActivityInfo(String activityTimeText, String buyTimeText, Integer endTime, Boolean isSubmitted, Integer joinCnt, List<JoinModel> list, Integer maxBuyTime, Integer publishTime, String publishTimeText, String ruleUrl, Integer startTime, String taskId, String taskStatus, Integer totalWinnerCount, Integer winnerCount) {
                            this.activityTimeText = activityTimeText;
                            this.buyTimeText = buyTimeText;
                            this.endTime = endTime;
                            this.isSubmitted = isSubmitted;
                            this.joinCnt = joinCnt;
                            this.joinList = list;
                            this.maxBuyTime = maxBuyTime;
                            this.publishTime = publishTime;
                            this.publishTimeText = publishTimeText;
                            this.ruleUrl = ruleUrl;
                            this.startTime = startTime;
                            this.taskId = taskId;
                            this.taskStatus = taskStatus;
                            this.totalWinnerCount = totalWinnerCount;
                            this.winnerCount = winnerCount;
                        }

                        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                            return new ArrayListSerializer(LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo$JoinModel$$serializer.INSTANCE);
                        }

                        @JvmStatic
                        public static final /* synthetic */ void write$Self$product_details_page_debug(ActivityInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
                            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.activityTimeText != null) {
                                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.activityTimeText);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.buyTimeText != null) {
                                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.buyTimeText);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.endTime != null) {
                                output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.endTime);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.isSubmitted != null) {
                                output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.isSubmitted);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.joinCnt != null) {
                                output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.joinCnt);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.joinList != null) {
                                output.encodeNullableSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.joinList);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.maxBuyTime != null) {
                                output.encodeNullableSerializableElement(serialDesc, 6, IntSerializer.INSTANCE, self.maxBuyTime);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.publishTime != null) {
                                output.encodeNullableSerializableElement(serialDesc, 7, IntSerializer.INSTANCE, self.publishTime);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.publishTimeText != null) {
                                output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.publishTimeText);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.ruleUrl != null) {
                                output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.ruleUrl);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.startTime != null) {
                                output.encodeNullableSerializableElement(serialDesc, 10, IntSerializer.INSTANCE, self.startTime);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.taskId != null) {
                                output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.taskId);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.taskStatus != null) {
                                output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.taskStatus);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.totalWinnerCount != null) {
                                output.encodeNullableSerializableElement(serialDesc, 13, IntSerializer.INSTANCE, self.totalWinnerCount);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 14) || self.winnerCount != null) {
                                output.encodeNullableSerializableElement(serialDesc, 14, IntSerializer.INSTANCE, self.winnerCount);
                            }
                        }

                        public /* synthetic */ ActivityInfo(String str, String str2, Integer num, Boolean bool, Integer num2, List list, Integer num3, Integer num4, String str3, String str4, Integer num5, String str5, String str6, Integer num6, Integer num7, int i, DefaultConstructorMarker defaultConstructorMarker) {
                            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : num3, (i & 128) != 0 ? null : num4, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : str4, (i & 1024) != 0 ? null : num5, (i & 2048) != 0 ? null : str5, (i & 4096) != 0 ? null : str6, (i & 8192) != 0 ? null : num6, (i & 16384) == 0 ? num7 : null);
                        }

                        public final String getActivityTimeText() {
                            return this.activityTimeText;
                        }

                        public final String getBuyTimeText() {
                            return this.buyTimeText;
                        }

                        public final Integer getEndTime() {
                            return this.endTime;
                        }

                        public final Boolean isSubmitted() {
                            return this.isSubmitted;
                        }

                        public final Integer getJoinCnt() {
                            return this.joinCnt;
                        }

                        public final List<JoinModel> getJoinList() {
                            return this.joinList;
                        }

                        public final Integer getMaxBuyTime() {
                            return this.maxBuyTime;
                        }

                        public final Integer getPublishTime() {
                            return this.publishTime;
                        }

                        public final String getPublishTimeText() {
                            return this.publishTimeText;
                        }

                        public final String getRuleUrl() {
                            return this.ruleUrl;
                        }

                        public final Integer getStartTime() {
                            return this.startTime;
                        }

                        public final String getTaskId() {
                            return this.taskId;
                        }

                        public final String getTaskStatus() {
                            return this.taskStatus;
                        }

                        public final Integer getTotalWinnerCount() {
                            return this.totalWinnerCount;
                        }

                        /* compiled from: LiveInfoApiService.kt */
                        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 62\u00020\u0001:\u000256Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eBk\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jn\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0005HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001J%\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\b4R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0004\u0010\u0015R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0006\u0010\u0015R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u00067"}, d2 = {"Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo$JoinModel;", "", "face", "", "isDeleted", "", "isFakeAccount", "mid", "", "name", "rank", "sex", "sign", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFace", "()Ljava/lang/String;", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMid", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getName", "getRank", "getSex", "getSign", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo$JoinModel;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        @Serializable
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class JoinModel {
                            public static final int $stable = 0;
                            public static final Companion Companion = new Companion(null);
                            private final String face;
                            private final Integer isDeleted;
                            private final Integer isFakeAccount;
                            private final Long mid;
                            private final String name;
                            private final Long rank;
                            private final String sex;
                            private final String sign;

                            public JoinModel() {
                                this((String) null, (Integer) null, (Integer) null, (Long) null, (String) null, (Long) null, (String) null, (String) null, (int) KotlinVersion.MAX_COMPONENT_VALUE, (DefaultConstructorMarker) null);
                            }

                            public final String component1() {
                                return this.face;
                            }

                            public final Integer component2() {
                                return this.isDeleted;
                            }

                            public final Integer component3() {
                                return this.isFakeAccount;
                            }

                            public final Long component4() {
                                return this.mid;
                            }

                            public final String component5() {
                                return this.name;
                            }

                            public final Long component6() {
                                return this.rank;
                            }

                            public final String component7() {
                                return this.sex;
                            }

                            public final String component8() {
                                return this.sign;
                            }

                            public final JoinModel copy(String str, Integer num, Integer num2, Long l, String str2, Long l2, String str3, String str4) {
                                return new JoinModel(str, num, num2, l, str2, l2, str3, str4);
                            }

                            public boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj instanceof JoinModel) {
                                    JoinModel joinModel = (JoinModel) obj;
                                    return Intrinsics.areEqual(this.face, joinModel.face) && Intrinsics.areEqual(this.isDeleted, joinModel.isDeleted) && Intrinsics.areEqual(this.isFakeAccount, joinModel.isFakeAccount) && Intrinsics.areEqual(this.mid, joinModel.mid) && Intrinsics.areEqual(this.name, joinModel.name) && Intrinsics.areEqual(this.rank, joinModel.rank) && Intrinsics.areEqual(this.sex, joinModel.sex) && Intrinsics.areEqual(this.sign, joinModel.sign);
                                }
                                return false;
                            }

                            public int hashCode() {
                                return ((((((((((((((this.face == null ? 0 : this.face.hashCode()) * 31) + (this.isDeleted == null ? 0 : this.isDeleted.hashCode())) * 31) + (this.isFakeAccount == null ? 0 : this.isFakeAccount.hashCode())) * 31) + (this.mid == null ? 0 : this.mid.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.rank == null ? 0 : this.rank.hashCode())) * 31) + (this.sex == null ? 0 : this.sex.hashCode())) * 31) + (this.sign != null ? this.sign.hashCode() : 0);
                            }

                            public String toString() {
                                String str = this.face;
                                Integer num = this.isDeleted;
                                Integer num2 = this.isFakeAccount;
                                Long l = this.mid;
                                String str2 = this.name;
                                Long l2 = this.rank;
                                String str3 = this.sex;
                                return "JoinModel(face=" + str + ", isDeleted=" + num + ", isFakeAccount=" + num2 + ", mid=" + l + ", name=" + str2 + ", rank=" + l2 + ", sex=" + str3 + ", sign=" + this.sign + ")";
                            }

                            /* compiled from: LiveInfoApiService.kt */
                            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo$JoinModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo$JoinModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                            public static final class Companion {
                                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                    this();
                                }

                                private Companion() {
                                }

                                public final KSerializer<JoinModel> serializer() {
                                    return LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo$JoinModel$$serializer.INSTANCE;
                                }
                            }

                            public /* synthetic */ JoinModel(int seen0, String face, Integer isDeleted, Integer isFakeAccount, Long mid, String name, Long rank, String sex, String sign, SerializationConstructorMarker serializationConstructorMarker) {
                                if ((seen0 & 1) == 0) {
                                    this.face = null;
                                } else {
                                    this.face = face;
                                }
                                if ((seen0 & 2) == 0) {
                                    this.isDeleted = null;
                                } else {
                                    this.isDeleted = isDeleted;
                                }
                                if ((seen0 & 4) == 0) {
                                    this.isFakeAccount = null;
                                } else {
                                    this.isFakeAccount = isFakeAccount;
                                }
                                if ((seen0 & 8) == 0) {
                                    this.mid = null;
                                } else {
                                    this.mid = mid;
                                }
                                if ((seen0 & 16) == 0) {
                                    this.name = null;
                                } else {
                                    this.name = name;
                                }
                                if ((seen0 & 32) == 0) {
                                    this.rank = null;
                                } else {
                                    this.rank = rank;
                                }
                                if ((seen0 & 64) == 0) {
                                    this.sex = null;
                                } else {
                                    this.sex = sex;
                                }
                                if ((seen0 & 128) == 0) {
                                    this.sign = null;
                                } else {
                                    this.sign = sign;
                                }
                            }

                            public JoinModel(String face, Integer isDeleted, Integer isFakeAccount, Long mid, String name, Long rank, String sex, String sign) {
                                this.face = face;
                                this.isDeleted = isDeleted;
                                this.isFakeAccount = isFakeAccount;
                                this.mid = mid;
                                this.name = name;
                                this.rank = rank;
                                this.sex = sex;
                                this.sign = sign;
                            }

                            @JvmStatic
                            public static final /* synthetic */ void write$Self$product_details_page_debug(JoinModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
                                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.face != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.face);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.isDeleted != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.isDeleted);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.isFakeAccount != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.isFakeAccount);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.mid != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 3, LongSerializer.INSTANCE, self.mid);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.name != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.name);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.rank != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 5, LongSerializer.INSTANCE, self.rank);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.sex != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.sex);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.sign != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.sign);
                                }
                            }

                            public /* synthetic */ JoinModel(String str, Integer num, Integer num2, Long l, String str2, Long l2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : l2, (i & 64) != 0 ? null : str3, (i & 128) == 0 ? str4 : null);
                            }

                            public final String getFace() {
                                return this.face;
                            }

                            public final Integer isDeleted() {
                                return this.isDeleted;
                            }

                            public final Integer isFakeAccount() {
                                return this.isFakeAccount;
                            }

                            public final Long getMid() {
                                return this.mid;
                            }

                            public final String getName() {
                                return this.name;
                            }

                            public final Long getRank() {
                                return this.rank;
                            }

                            public final String getSex() {
                                return this.sex;
                            }

                            public final String getSign() {
                                return this.sign;
                            }
                        }

                        public final Integer getWinnerCount() {
                            return this.winnerCount;
                        }
                    }

                    public final UserActivityInfo getUserActivityInfo() {
                        return this.userActivityInfo;
                    }

                    /* compiled from: LiveInfoApiService.kt */
                    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0003./0Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000eBm\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tHÆ\u0003Jn\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0010HÖ\u0001J\t\u0010%\u001a\u00020\fHÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0002\u0010\u0014R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0004\u0010\u0014R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0005\u0010\u0014R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0006\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0007\u0010\u0014R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u00061"}, d2 = {"Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo;", "", "isCouponReceived", "", "isFollow", "isJoined", "isSubmitted", "isWinner", "myTicketNos", "", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo$TicketNos;", "ticketNos", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMyTicketNos", "()Ljava/util/List;", "getTicketNos", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;)Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "TicketNos", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    @Serializable
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class UserActivityInfo {
                        private final Boolean isCouponReceived;
                        private final Boolean isFollow;
                        private final Boolean isJoined;
                        private final Boolean isSubmitted;
                        private final Boolean isWinner;
                        private final List<TicketNos> myTicketNos;
                        private final List<String> ticketNos;
                        public static final Companion Companion = new Companion(null);
                        public static final int $stable = 8;
                        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                KSerializer _childSerializers$_anonymous_;
                                _childSerializers$_anonymous_ = LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo._childSerializers$_anonymous_();
                                return _childSerializers$_anonymous_;
                            }
                        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                KSerializer _childSerializers$_anonymous_$0;
                                _childSerializers$_anonymous_$0 = LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo._childSerializers$_anonymous_$0();
                                return _childSerializers$_anonymous_$0;
                            }
                        })};

                        public UserActivityInfo() {
                            this((Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (List) null, (List) null, 127, (DefaultConstructorMarker) null);
                        }

                        public static /* synthetic */ UserActivityInfo copy$default(UserActivityInfo userActivityInfo, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, List list, List list2, int i, Object obj) {
                            if ((i & 1) != 0) {
                                bool = userActivityInfo.isCouponReceived;
                            }
                            if ((i & 2) != 0) {
                                bool2 = userActivityInfo.isFollow;
                            }
                            Boolean bool6 = bool2;
                            if ((i & 4) != 0) {
                                bool3 = userActivityInfo.isJoined;
                            }
                            Boolean bool7 = bool3;
                            if ((i & 8) != 0) {
                                bool4 = userActivityInfo.isSubmitted;
                            }
                            Boolean bool8 = bool4;
                            if ((i & 16) != 0) {
                                bool5 = userActivityInfo.isWinner;
                            }
                            Boolean bool9 = bool5;
                            List<TicketNos> list3 = list;
                            if ((i & 32) != 0) {
                                list3 = userActivityInfo.myTicketNos;
                            }
                            List list4 = list3;
                            List<String> list5 = list2;
                            if ((i & 64) != 0) {
                                list5 = userActivityInfo.ticketNos;
                            }
                            return userActivityInfo.copy(bool, bool6, bool7, bool8, bool9, list4, list5);
                        }

                        public final Boolean component1() {
                            return this.isCouponReceived;
                        }

                        public final Boolean component2() {
                            return this.isFollow;
                        }

                        public final Boolean component3() {
                            return this.isJoined;
                        }

                        public final Boolean component4() {
                            return this.isSubmitted;
                        }

                        public final Boolean component5() {
                            return this.isWinner;
                        }

                        public final List<TicketNos> component6() {
                            return this.myTicketNos;
                        }

                        public final List<String> component7() {
                            return this.ticketNos;
                        }

                        public final UserActivityInfo copy(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, List<TicketNos> list, List<String> list2) {
                            return new UserActivityInfo(bool, bool2, bool3, bool4, bool5, list, list2);
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj instanceof UserActivityInfo) {
                                UserActivityInfo userActivityInfo = (UserActivityInfo) obj;
                                return Intrinsics.areEqual(this.isCouponReceived, userActivityInfo.isCouponReceived) && Intrinsics.areEqual(this.isFollow, userActivityInfo.isFollow) && Intrinsics.areEqual(this.isJoined, userActivityInfo.isJoined) && Intrinsics.areEqual(this.isSubmitted, userActivityInfo.isSubmitted) && Intrinsics.areEqual(this.isWinner, userActivityInfo.isWinner) && Intrinsics.areEqual(this.myTicketNos, userActivityInfo.myTicketNos) && Intrinsics.areEqual(this.ticketNos, userActivityInfo.ticketNos);
                            }
                            return false;
                        }

                        public int hashCode() {
                            return ((((((((((((this.isCouponReceived == null ? 0 : this.isCouponReceived.hashCode()) * 31) + (this.isFollow == null ? 0 : this.isFollow.hashCode())) * 31) + (this.isJoined == null ? 0 : this.isJoined.hashCode())) * 31) + (this.isSubmitted == null ? 0 : this.isSubmitted.hashCode())) * 31) + (this.isWinner == null ? 0 : this.isWinner.hashCode())) * 31) + (this.myTicketNos == null ? 0 : this.myTicketNos.hashCode())) * 31) + (this.ticketNos != null ? this.ticketNos.hashCode() : 0);
                        }

                        public String toString() {
                            Boolean bool = this.isCouponReceived;
                            Boolean bool2 = this.isFollow;
                            Boolean bool3 = this.isJoined;
                            Boolean bool4 = this.isSubmitted;
                            Boolean bool5 = this.isWinner;
                            List<TicketNos> list = this.myTicketNos;
                            return "UserActivityInfo(isCouponReceived=" + bool + ", isFollow=" + bool2 + ", isJoined=" + bool3 + ", isSubmitted=" + bool4 + ", isWinner=" + bool5 + ", myTicketNos=" + list + ", ticketNos=" + this.ticketNos + ")";
                        }

                        /* compiled from: LiveInfoApiService.kt */
                        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class Companion {
                            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                this();
                            }

                            private Companion() {
                            }

                            public final KSerializer<UserActivityInfo> serializer() {
                                return LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo$$serializer.INSTANCE;
                            }
                        }

                        public /* synthetic */ UserActivityInfo(int seen0, Boolean isCouponReceived, Boolean isFollow, Boolean isJoined, Boolean isSubmitted, Boolean isWinner, List myTicketNos, List ticketNos, SerializationConstructorMarker serializationConstructorMarker) {
                            if ((seen0 & 1) == 0) {
                                this.isCouponReceived = null;
                            } else {
                                this.isCouponReceived = isCouponReceived;
                            }
                            if ((seen0 & 2) == 0) {
                                this.isFollow = null;
                            } else {
                                this.isFollow = isFollow;
                            }
                            if ((seen0 & 4) == 0) {
                                this.isJoined = null;
                            } else {
                                this.isJoined = isJoined;
                            }
                            if ((seen0 & 8) == 0) {
                                this.isSubmitted = null;
                            } else {
                                this.isSubmitted = isSubmitted;
                            }
                            if ((seen0 & 16) == 0) {
                                this.isWinner = null;
                            } else {
                                this.isWinner = isWinner;
                            }
                            if ((seen0 & 32) == 0) {
                                this.myTicketNos = null;
                            } else {
                                this.myTicketNos = myTicketNos;
                            }
                            if ((seen0 & 64) == 0) {
                                this.ticketNos = null;
                            } else {
                                this.ticketNos = ticketNos;
                            }
                        }

                        public UserActivityInfo(Boolean isCouponReceived, Boolean isFollow, Boolean isJoined, Boolean isSubmitted, Boolean isWinner, List<TicketNos> list, List<String> list2) {
                            this.isCouponReceived = isCouponReceived;
                            this.isFollow = isFollow;
                            this.isJoined = isJoined;
                            this.isSubmitted = isSubmitted;
                            this.isWinner = isWinner;
                            this.myTicketNos = list;
                            this.ticketNos = list2;
                        }

                        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                            return new ArrayListSerializer(LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo$TicketNos$$serializer.INSTANCE);
                        }

                        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                            return new ArrayListSerializer(StringSerializer.INSTANCE);
                        }

                        @JvmStatic
                        public static final /* synthetic */ void write$Self$product_details_page_debug(UserActivityInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
                            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.isCouponReceived != null) {
                                output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.isCouponReceived);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.isFollow != null) {
                                output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.isFollow);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.isJoined != null) {
                                output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.isJoined);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.isSubmitted != null) {
                                output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.isSubmitted);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.isWinner != null) {
                                output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.isWinner);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.myTicketNos != null) {
                                output.encodeNullableSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.myTicketNos);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.ticketNos != null) {
                                output.encodeNullableSerializableElement(serialDesc, 6, lazyArr[6].getValue(), self.ticketNos);
                            }
                        }

                        public /* synthetic */ UserActivityInfo(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                            this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : bool3, (i & 8) != 0 ? null : bool4, (i & 16) != 0 ? null : bool5, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : list2);
                        }

                        public final Boolean isCouponReceived() {
                            return this.isCouponReceived;
                        }

                        public final Boolean isFollow() {
                            return this.isFollow;
                        }

                        public final Boolean isJoined() {
                            return this.isJoined;
                        }

                        public final Boolean isSubmitted() {
                            return this.isSubmitted;
                        }

                        public final Boolean isWinner() {
                            return this.isWinner;
                        }

                        public final List<TicketNos> getMyTicketNos() {
                            return this.myTicketNos;
                        }

                        /* compiled from: LiveInfoApiService.kt */
                        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bBC\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\nHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006'"}, d2 = {"Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo$TicketNos;", "", "imgNames", "", "status", "statusText", "ticketNo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImgNames", "()Ljava/lang/String;", "getStatus", "getStatusText", "getTicketNo", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        @Serializable
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class TicketNos {
                            public static final int $stable = 0;
                            public static final Companion Companion = new Companion(null);
                            private final String imgNames;
                            private final String status;
                            private final String statusText;
                            private final String ticketNo;

                            public TicketNos() {
                                this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
                            }

                            public static /* synthetic */ TicketNos copy$default(TicketNos ticketNos, String str, String str2, String str3, String str4, int i, Object obj) {
                                if ((i & 1) != 0) {
                                    str = ticketNos.imgNames;
                                }
                                if ((i & 2) != 0) {
                                    str2 = ticketNos.status;
                                }
                                if ((i & 4) != 0) {
                                    str3 = ticketNos.statusText;
                                }
                                if ((i & 8) != 0) {
                                    str4 = ticketNos.ticketNo;
                                }
                                return ticketNos.copy(str, str2, str3, str4);
                            }

                            public final String component1() {
                                return this.imgNames;
                            }

                            public final String component2() {
                                return this.status;
                            }

                            public final String component3() {
                                return this.statusText;
                            }

                            public final String component4() {
                                return this.ticketNo;
                            }

                            public final TicketNos copy(String str, String str2, String str3, String str4) {
                                return new TicketNos(str, str2, str3, str4);
                            }

                            public boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj instanceof TicketNos) {
                                    TicketNos ticketNos = (TicketNos) obj;
                                    return Intrinsics.areEqual(this.imgNames, ticketNos.imgNames) && Intrinsics.areEqual(this.status, ticketNos.status) && Intrinsics.areEqual(this.statusText, ticketNos.statusText) && Intrinsics.areEqual(this.ticketNo, ticketNos.ticketNo);
                                }
                                return false;
                            }

                            public int hashCode() {
                                return ((((((this.imgNames == null ? 0 : this.imgNames.hashCode()) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.statusText == null ? 0 : this.statusText.hashCode())) * 31) + (this.ticketNo != null ? this.ticketNo.hashCode() : 0);
                            }

                            public String toString() {
                                String str = this.imgNames;
                                String str2 = this.status;
                                String str3 = this.statusText;
                                return "TicketNos(imgNames=" + str + ", status=" + str2 + ", statusText=" + str3 + ", ticketNo=" + this.ticketNo + ")";
                            }

                            /* compiled from: LiveInfoApiService.kt */
                            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo$TicketNos$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo$TicketNos;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                            public static final class Companion {
                                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                    this();
                                }

                                private Companion() {
                                }

                                public final KSerializer<TicketNos> serializer() {
                                    return LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo$TicketNos$$serializer.INSTANCE;
                                }
                            }

                            public /* synthetic */ TicketNos(int seen0, String imgNames, String status, String statusText, String ticketNo, SerializationConstructorMarker serializationConstructorMarker) {
                                if ((seen0 & 1) == 0) {
                                    this.imgNames = null;
                                } else {
                                    this.imgNames = imgNames;
                                }
                                if ((seen0 & 2) == 0) {
                                    this.status = null;
                                } else {
                                    this.status = status;
                                }
                                if ((seen0 & 4) == 0) {
                                    this.statusText = null;
                                } else {
                                    this.statusText = statusText;
                                }
                                if ((seen0 & 8) == 0) {
                                    this.ticketNo = null;
                                } else {
                                    this.ticketNo = ticketNo;
                                }
                            }

                            public TicketNos(String imgNames, String status, String statusText, String ticketNo) {
                                this.imgNames = imgNames;
                                this.status = status;
                                this.statusText = statusText;
                                this.ticketNo = ticketNo;
                            }

                            @JvmStatic
                            public static final /* synthetic */ void write$Self$product_details_page_debug(TicketNos self, CompositeEncoder output, SerialDescriptor serialDesc) {
                                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.imgNames != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.imgNames);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.status != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.status);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.statusText != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.statusText);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.ticketNo != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.ticketNo);
                                }
                            }

                            public /* synthetic */ TicketNos(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
                            }

                            public final String getImgNames() {
                                return this.imgNames;
                            }

                            public final String getStatus() {
                                return this.status;
                            }

                            public final String getStatusText() {
                                return this.statusText;
                            }

                            public final String getTicketNo() {
                                return this.ticketNo;
                            }
                        }

                        public final List<String> getTicketNos() {
                            return this.ticketNos;
                        }
                    }
                }

                public final String getTitle() {
                    return this.title;
                }

                /* compiled from: LiveInfoApiService.kt */
                @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bBC\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\nHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006'"}, d2 = {"Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$PromotionAtmosphereInfo;", "", "sideImg", "", "sideImgJumpUrl", "tagImg", "tagImgJumpUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSideImg", "()Ljava/lang/String;", "getSideImgJumpUrl", "getTagImg", "getTagImgJumpUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                @Serializable
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class PromotionAtmosphereInfo {
                    public static final int $stable = 0;
                    public static final Companion Companion = new Companion(null);
                    private final String sideImg;
                    private final String sideImgJumpUrl;
                    private final String tagImg;
                    private final String tagImgJumpUrl;

                    public PromotionAtmosphereInfo() {
                        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
                    }

                    public static /* synthetic */ PromotionAtmosphereInfo copy$default(PromotionAtmosphereInfo promotionAtmosphereInfo, String str, String str2, String str3, String str4, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = promotionAtmosphereInfo.sideImg;
                        }
                        if ((i & 2) != 0) {
                            str2 = promotionAtmosphereInfo.sideImgJumpUrl;
                        }
                        if ((i & 4) != 0) {
                            str3 = promotionAtmosphereInfo.tagImg;
                        }
                        if ((i & 8) != 0) {
                            str4 = promotionAtmosphereInfo.tagImgJumpUrl;
                        }
                        return promotionAtmosphereInfo.copy(str, str2, str3, str4);
                    }

                    public final String component1() {
                        return this.sideImg;
                    }

                    public final String component2() {
                        return this.sideImgJumpUrl;
                    }

                    public final String component3() {
                        return this.tagImg;
                    }

                    public final String component4() {
                        return this.tagImgJumpUrl;
                    }

                    public final PromotionAtmosphereInfo copy(String str, String str2, String str3, String str4) {
                        return new PromotionAtmosphereInfo(str, str2, str3, str4);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof PromotionAtmosphereInfo) {
                            PromotionAtmosphereInfo promotionAtmosphereInfo = (PromotionAtmosphereInfo) obj;
                            return Intrinsics.areEqual(this.sideImg, promotionAtmosphereInfo.sideImg) && Intrinsics.areEqual(this.sideImgJumpUrl, promotionAtmosphereInfo.sideImgJumpUrl) && Intrinsics.areEqual(this.tagImg, promotionAtmosphereInfo.tagImg) && Intrinsics.areEqual(this.tagImgJumpUrl, promotionAtmosphereInfo.tagImgJumpUrl);
                        }
                        return false;
                    }

                    public int hashCode() {
                        return ((((((this.sideImg == null ? 0 : this.sideImg.hashCode()) * 31) + (this.sideImgJumpUrl == null ? 0 : this.sideImgJumpUrl.hashCode())) * 31) + (this.tagImg == null ? 0 : this.tagImg.hashCode())) * 31) + (this.tagImgJumpUrl != null ? this.tagImgJumpUrl.hashCode() : 0);
                    }

                    public String toString() {
                        String str = this.sideImg;
                        String str2 = this.sideImgJumpUrl;
                        String str3 = this.tagImg;
                        return "PromotionAtmosphereInfo(sideImg=" + str + ", sideImgJumpUrl=" + str2 + ", tagImg=" + str3 + ", tagImgJumpUrl=" + this.tagImgJumpUrl + ")";
                    }

                    /* compiled from: LiveInfoApiService.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$PromotionAtmosphereInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$PromotionAtmosphereInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<PromotionAtmosphereInfo> serializer() {
                            return LiveInfoApiService$LiveInfoData$PromotionAtmosphereInfo$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ PromotionAtmosphereInfo(int seen0, String sideImg, String sideImgJumpUrl, String tagImg, String tagImgJumpUrl, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((seen0 & 1) == 0) {
                            this.sideImg = null;
                        } else {
                            this.sideImg = sideImg;
                        }
                        if ((seen0 & 2) == 0) {
                            this.sideImgJumpUrl = null;
                        } else {
                            this.sideImgJumpUrl = sideImgJumpUrl;
                        }
                        if ((seen0 & 4) == 0) {
                            this.tagImg = null;
                        } else {
                            this.tagImg = tagImg;
                        }
                        if ((seen0 & 8) == 0) {
                            this.tagImgJumpUrl = null;
                        } else {
                            this.tagImgJumpUrl = tagImgJumpUrl;
                        }
                    }

                    public PromotionAtmosphereInfo(String sideImg, String sideImgJumpUrl, String tagImg, String tagImgJumpUrl) {
                        this.sideImg = sideImg;
                        this.sideImgJumpUrl = sideImgJumpUrl;
                        this.tagImg = tagImg;
                        this.tagImgJumpUrl = tagImgJumpUrl;
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$product_details_page_debug(PromotionAtmosphereInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.sideImg != null) {
                            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.sideImg);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.sideImgJumpUrl != null) {
                            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.sideImgJumpUrl);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.tagImg != null) {
                            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.tagImg);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.tagImgJumpUrl != null) {
                            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.tagImgJumpUrl);
                        }
                    }

                    public /* synthetic */ PromotionAtmosphereInfo(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
                    }

                    public final String getSideImg() {
                        return this.sideImg;
                    }

                    public final String getSideImgJumpUrl() {
                        return this.sideImgJumpUrl;
                    }

                    public final String getTagImg() {
                        return this.tagImg;
                    }

                    public final String getTagImgJumpUrl() {
                        return this.tagImgJumpUrl;
                    }
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:66:0x002d  */
            /* JADX WARN: Removed duplicated region for block: B:68:0x0035  */
            /* JADX WARN: Removed duplicated region for block: B:71:0x0048  */
            /* JADX WARN: Removed duplicated region for block: B:76:0x0073  */
            /* JADX WARN: Removed duplicated region for block: B:83:0x00fc A[Catch: Exception -> 0x0070, TryCatch #0 {Exception -> 0x0070, blocks: (B:69:0x0041, B:97:0x015b, B:99:0x015f, B:100:0x0167, B:72:0x006a, B:81:0x00e9, B:83:0x00fc, B:85:0x0117, B:92:0x0131), top: B:107:0x002a }] */
            /* JADX WARN: Removed duplicated region for block: B:85:0x0117 A[Catch: Exception -> 0x0070, TRY_LEAVE, TryCatch #0 {Exception -> 0x0070, blocks: (B:69:0x0041, B:97:0x015b, B:99:0x015f, B:100:0x0167, B:72:0x006a, B:81:0x00e9, B:83:0x00fc, B:85:0x0117, B:92:0x0131), top: B:107:0x002a }] */
            /* JADX WARN: Removed duplicated region for block: B:97:0x015b A[Catch: Exception -> 0x0070, TryCatch #0 {Exception -> 0x0070, blocks: (B:69:0x0041, B:97:0x015b, B:99:0x015f, B:100:0x0167, B:72:0x006a, B:81:0x00e9, B:83:0x00fc, B:85:0x0117, B:92:0x0131), top: B:107:0x002a }] */
            /* JADX WARN: Removed duplicated region for block: B:99:0x015f A[Catch: Exception -> 0x0070, TryCatch #0 {Exception -> 0x0070, blocks: (B:69:0x0041, B:97:0x015b, B:99:0x015f, B:100:0x0167, B:72:0x006a, B:81:0x00e9, B:83:0x00fc, B:85:0x0117, B:92:0x0131), top: B:107:0x002a }] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object getLiveInfo$product_details_page_debug(int itemsId, Continuation<? super LiveInfoResponse> continuation) {
                LiveInfoApiService$getLiveInfo$1 liveInfoApiService$getLiveInfo$1;
                LiveInfoApiService$getLiveInfo$1 liveInfoApiService$getLiveInfo$12;
                Object execute;
                HttpResponse response;
                KType kType;
                Object bodyNullable;
                final int itemsId2 = itemsId;
                try {
                    if (continuation instanceof LiveInfoApiService$getLiveInfo$1) {
                        liveInfoApiService$getLiveInfo$1 = (LiveInfoApiService$getLiveInfo$1) continuation;
                        if ((liveInfoApiService$getLiveInfo$1.label & Integer.MIN_VALUE) != 0) {
                            liveInfoApiService$getLiveInfo$1.label -= Integer.MIN_VALUE;
                            liveInfoApiService$getLiveInfo$12 = liveInfoApiService$getLiveInfo$1;
                            Object $result = liveInfoApiService$getLiveInfo$12.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (liveInfoApiService$getLiveInfo$12.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    try {
                                        HttpClient $this$get$iv = Client.INSTANCE.getHttpClient();
                                        HttpRequestBuilder $this$get_u24lambda_u244$iv = new HttpRequestBuilder();
                                        HttpRequestKt.url($this$get_u24lambda_u244$iv, API_URL_STRING);
                                        ParametersKt.parameters(new Function1() { // from class: kntr.app.mall.product.details.page.api.LiveInfoApiService$$ExternalSyntheticLambda0
                                            public final Object invoke(Object obj) {
                                                Unit liveInfo$lambda$0$0;
                                                liveInfo$lambda$0$0 = LiveInfoApiService.getLiveInfo$lambda$0$0(itemsId2, (ParametersBuilder) obj);
                                                return liveInfo$lambda$0$0;
                                            }
                                        });
                                        $this$get_u24lambda_u244$iv.setMethod(HttpMethod.Companion.getGet());
                                        HttpStatement httpStatement = new HttpStatement($this$get_u24lambda_u244$iv, $this$get$iv);
                                        liveInfoApiService$getLiveInfo$12.L$0 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                        liveInfoApiService$getLiveInfo$12.L$1 = SpillingKt.nullOutSpilledVariable(API_URL_STRING);
                                        liveInfoApiService$getLiveInfo$12.L$2 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                        liveInfoApiService$getLiveInfo$12.L$3 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                        liveInfoApiService$getLiveInfo$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get_u24lambda_u244$iv);
                                        liveInfoApiService$getLiveInfo$12.L$5 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                        liveInfoApiService$getLiveInfo$12.I$0 = itemsId2;
                                        liveInfoApiService$getLiveInfo$12.I$1 = 0;
                                        liveInfoApiService$getLiveInfo$12.I$2 = 0;
                                        liveInfoApiService$getLiveInfo$12.I$3 = 0;
                                        liveInfoApiService$getLiveInfo$12.I$4 = 0;
                                        liveInfoApiService$getLiveInfo$12.label = 1;
                                        execute = httpStatement.execute(liveInfoApiService$getLiveInfo$12);
                                        if (execute == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        response = (HttpResponse) execute;
                                        if (Intrinsics.areEqual(response.getStatus(), HttpStatusCode.Companion.getOK())) {
                                            return new LiveInfoResponse(Boxing.boxLong(-1L), (LiveInfoData) null, Boxing.boxInt(-1), "Network error", 2, (DefaultConstructorMarker) null);
                                        }
                                        HttpClientCall call = response.getCall();
                                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(LiveInfoResponse.class);
                                        try {
                                            kType = Reflection.typeOf(LiveInfoResponse.class);
                                        } catch (Throwable th) {
                                            kType = null;
                                        }
                                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                                        liveInfoApiService$getLiveInfo$12.L$0 = SpillingKt.nullOutSpilledVariable(response);
                                        liveInfoApiService$getLiveInfo$12.L$1 = SpillingKt.nullOutSpilledVariable(response);
                                        liveInfoApiService$getLiveInfo$12.L$2 = null;
                                        liveInfoApiService$getLiveInfo$12.L$3 = null;
                                        liveInfoApiService$getLiveInfo$12.L$4 = null;
                                        liveInfoApiService$getLiveInfo$12.L$5 = null;
                                        liveInfoApiService$getLiveInfo$12.I$0 = itemsId2;
                                        liveInfoApiService$getLiveInfo$12.I$1 = 0;
                                        liveInfoApiService$getLiveInfo$12.label = 2;
                                        bodyNullable = call.bodyNullable(typeInfo, liveInfoApiService$getLiveInfo$12);
                                        if (bodyNullable == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        if (bodyNullable == null) {
                                            LiveInfoResponse rtValue = (LiveInfoResponse) bodyNullable;
                                            return rtValue;
                                        }
                                        throw new NullPointerException("null cannot be cast to non-null type kntr.app.mall.product.details.page.api.LiveInfoApiService.LiveInfoResponse");
                                    } catch (Exception e) {
                                        e = e;
                                        String message = e.getMessage();
                                        if (message == null) {
                                            message = "Unknown error";
                                        }
                                        return new LiveInfoResponse(Boxing.boxLong(-1L), (LiveInfoData) null, Boxing.boxInt(-1), message, 2, (DefaultConstructorMarker) null);
                                    }
                                case 1:
                                    int $i$f$body = liveInfoApiService$getLiveInfo$12.I$4;
                                    int i = liveInfoApiService$getLiveInfo$12.I$3;
                                    int i2 = liveInfoApiService$getLiveInfo$12.I$2;
                                    int i3 = liveInfoApiService$getLiveInfo$12.I$1;
                                    itemsId2 = liveInfoApiService$getLiveInfo$12.I$0;
                                    HttpClient httpClient = (HttpClient) liveInfoApiService$getLiveInfo$12.L$5;
                                    HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) liveInfoApiService$getLiveInfo$12.L$4;
                                    HttpClient httpClient2 = (HttpClient) liveInfoApiService$getLiveInfo$12.L$3;
                                    HttpClient httpClient3 = (HttpClient) liveInfoApiService$getLiveInfo$12.L$2;
                                    String str = (String) liveInfoApiService$getLiveInfo$12.L$1;
                                    HttpClient httpClient4 = (HttpClient) liveInfoApiService$getLiveInfo$12.L$0;
                                    ResultKt.throwOnFailure($result);
                                    execute = $result;
                                    response = (HttpResponse) execute;
                                    if (Intrinsics.areEqual(response.getStatus(), HttpStatusCode.Companion.getOK())) {
                                    }
                                    break;
                                case 2:
                                    int i4 = liveInfoApiService$getLiveInfo$12.I$1;
                                    int i5 = liveInfoApiService$getLiveInfo$12.I$0;
                                    HttpResponse httpResponse = (HttpResponse) liveInfoApiService$getLiveInfo$12.L$1;
                                    HttpResponse httpResponse2 = (HttpResponse) liveInfoApiService$getLiveInfo$12.L$0;
                                    ResultKt.throwOnFailure($result);
                                    bodyNullable = $result;
                                    if (bodyNullable == null) {
                                    }
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }
                    switch (liveInfoApiService$getLiveInfo$12.label) {
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                liveInfoApiService$getLiveInfo$1 = new LiveInfoApiService$getLiveInfo$1(this, continuation);
                liveInfoApiService$getLiveInfo$12 = liveInfoApiService$getLiveInfo$1;
                Object $result2 = liveInfoApiService$getLiveInfo$12.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }

            public static final Unit getLiveInfo$lambda$0$0(int $itemsId, ParametersBuilder $this$parameters) {
                Intrinsics.checkNotNullParameter($this$parameters, "$this$parameters");
                $this$parameters.append("itemsId", String.valueOf($itemsId));
                return Unit.INSTANCE;
            }

            public static /* synthetic */ Object mallKntrGetLiveInfo$product_details_page_debug$default(LiveInfoApiService liveInfoApiService, int i, Integer num, Integer num2, Continuation continuation, int i2, Object obj) {
                if ((i2 & 2) != 0) {
                    num = null;
                }
                if ((i2 & 4) != 0) {
                    num2 = null;
                }
                return liveInfoApiService.mallKntrGetLiveInfo$product_details_page_debug(i, num, num2, continuation);
            }

            /* JADX WARN: Removed duplicated region for block: B:114:0x0130  */
            /* JADX WARN: Removed duplicated region for block: B:76:0x002b  */
            /* JADX WARN: Removed duplicated region for block: B:78:0x0033  */
            /* JADX WARN: Removed duplicated region for block: B:83:0x0063  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object mallKntrGetLiveInfo$product_details_page_debug(int itemsId, Integer itemsVersion, Integer shopId, Continuation<? super LiveInfoResponse> continuation) {
                LiveInfoApiService$mallKntrGetLiveInfo$1 liveInfoApiService$mallKntrGetLiveInfo$1;
                LiveInfoApiService$mallKntrGetLiveInfo$1 liveInfoApiService$mallKntrGetLiveInfo$12;
                int itemsId2;
                Client $this$iv;
                Object obj;
                Map params$iv;
                int itemsId3;
                String message;
                if (continuation instanceof LiveInfoApiService$mallKntrGetLiveInfo$1) {
                    liveInfoApiService$mallKntrGetLiveInfo$1 = (LiveInfoApiService$mallKntrGetLiveInfo$1) continuation;
                    if ((liveInfoApiService$mallKntrGetLiveInfo$1.label & Integer.MIN_VALUE) != 0) {
                        liveInfoApiService$mallKntrGetLiveInfo$1.label -= Integer.MIN_VALUE;
                        liveInfoApiService$mallKntrGetLiveInfo$12 = liveInfoApiService$mallKntrGetLiveInfo$1;
                        Object $result = liveInfoApiService$mallKntrGetLiveInfo$12.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (liveInfoApiService$mallKntrGetLiveInfo$12.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                try {
                                    Client client = Client.INSTANCE;
                                    Map params$iv2 = MapsKt.mapOf(TuplesKt.to("itemsId", String.valueOf(itemsId)));
                                    $this$iv = client;
                                    try {
                                        liveInfoApiService$mallKntrGetLiveInfo$12.L$0 = SpillingKt.nullOutSpilledVariable(itemsVersion);
                                        liveInfoApiService$mallKntrGetLiveInfo$12.L$1 = SpillingKt.nullOutSpilledVariable(shopId);
                                        liveInfoApiService$mallKntrGetLiveInfo$12.L$2 = $this$iv;
                                        liveInfoApiService$mallKntrGetLiveInfo$12.L$3 = SpillingKt.nullOutSpilledVariable(API_URL_STRING);
                                        liveInfoApiService$mallKntrGetLiveInfo$12.L$4 = SpillingKt.nullOutSpilledVariable("GET");
                                        liveInfoApiService$mallKntrGetLiveInfo$12.L$5 = SpillingKt.nullOutSpilledVariable(params$iv2);
                                        itemsId2 = itemsId;
                                    } catch (Exception e) {
                                        e$iv = e;
                                        itemsId2 = itemsId;
                                    }
                                    try {
                                        liveInfoApiService$mallKntrGetLiveInfo$12.I$0 = itemsId2;
                                        liveInfoApiService$mallKntrGetLiveInfo$12.I$1 = 0;
                                        liveInfoApiService$mallKntrGetLiveInfo$12.label = 1;
                                        Object mallKntrAsyncRequest = MallEnvKt.mallKntrAsyncRequest(API_URL_STRING, "GET", (Map) null, params$iv2, liveInfoApiService$mallKntrGetLiveInfo$12);
                                        if (mallKntrAsyncRequest == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        obj = mallKntrAsyncRequest;
                                        params$iv = params$iv2;
                                        itemsId3 = itemsId2;
                                        String jsonString$iv = (String) obj;
                                        Json this_$iv$iv = $this$iv.getJson();
                                        Intrinsics.checkNotNull(jsonString$iv);
                                        this_$iv$iv.getSerializersModule();
                                        Object res$iv = this_$iv$iv.decodeFromString(LiveInfoResponse.Companion.serializer(), jsonString$iv);
                                        try {
                                            return (LiveInfoResponse) res$iv;
                                        } catch (Exception e2) {
                                            e = e2;
                                            itemsId2 = itemsId3;
                                            message = e.getMessage();
                                            if (message == null) {
                                            }
                                            return new LiveInfoResponse(Boxing.boxLong(-1L), (LiveInfoData) null, Boxing.boxInt(-1), message, 2, (DefaultConstructorMarker) null);
                                        }
                                    } catch (Exception e3) {
                                        e$iv = e3;
                                        try {
                                        } catch (Exception e4) {
                                            e = e4;
                                        }
                                        try {
                                            KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                            throw e$iv;
                                        } catch (Exception e5) {
                                            e = e5;
                                            message = e.getMessage();
                                            if (message == null) {
                                                message = "Unknown error";
                                            }
                                            return new LiveInfoResponse(Boxing.boxLong(-1L), (LiveInfoData) null, Boxing.boxInt(-1), message, 2, (DefaultConstructorMarker) null);
                                        }
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    itemsId2 = itemsId;
                                    message = e.getMessage();
                                    if (message == null) {
                                    }
                                    return new LiveInfoResponse(Boxing.boxLong(-1L), (LiveInfoData) null, Boxing.boxInt(-1), message, 2, (DefaultConstructorMarker) null);
                                }
                            case 1:
                                int i = liveInfoApiService$mallKntrGetLiveInfo$12.I$1;
                                itemsId3 = liveInfoApiService$mallKntrGetLiveInfo$12.I$0;
                                params$iv = (Map) liveInfoApiService$mallKntrGetLiveInfo$12.L$5;
                                String str = (String) liveInfoApiService$mallKntrGetLiveInfo$12.L$4;
                                String str2 = (String) liveInfoApiService$mallKntrGetLiveInfo$12.L$3;
                                $this$iv = (Client) liveInfoApiService$mallKntrGetLiveInfo$12.L$2;
                                Integer num = (Integer) liveInfoApiService$mallKntrGetLiveInfo$12.L$1;
                                Integer num2 = (Integer) liveInfoApiService$mallKntrGetLiveInfo$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    obj = $result;
                                    String jsonString$iv2 = (String) obj;
                                    Json this_$iv$iv2 = $this$iv.getJson();
                                    Intrinsics.checkNotNull(jsonString$iv2);
                                    this_$iv$iv2.getSerializersModule();
                                    Object res$iv2 = this_$iv$iv2.decodeFromString(LiveInfoResponse.Companion.serializer(), jsonString$iv2);
                                    return (LiveInfoResponse) res$iv2;
                                } catch (Exception e7) {
                                    e$iv = e7;
                                    itemsId2 = itemsId3;
                                    KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                    throw e$iv;
                                }
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
                liveInfoApiService$mallKntrGetLiveInfo$1 = new LiveInfoApiService$mallKntrGetLiveInfo$1(this, continuation);
                liveInfoApiService$mallKntrGetLiveInfo$12 = liveInfoApiService$mallKntrGetLiveInfo$1;
                Object $result2 = liveInfoApiService$mallKntrGetLiveInfo$12.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (liveInfoApiService$mallKntrGetLiveInfo$12.label) {
                }
            }
        }