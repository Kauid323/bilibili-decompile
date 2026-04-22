package kntr.app.mall.product.details.page.api;

import com.bilibili.mall.kmm.base.MallEnvKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kntr.app.mall.product.details.page.api.CouponReceiveApiService;
import kntr.app.mall.product.details.page.api.model.CouponInfoModel;
import kntr.app.mall.product.details.page.utils.DateFormatKt;
import kntr.app.mall.product.details.page.utils.HelperKt;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;

/* compiled from: CouponReceiveApiService.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u001e\b\u0002\u0010\u000b\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f\u0018\u00010\tH\u0080@¢\u0006\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/mall/product/details/page/api/CouponReceiveApiService;", "", "<init>", "()V", "API_URL_STRING", "", "mallKntrReceiveCoupon", "Lkntr/app/mall/product/details/page/api/CouponReceiveApiService$Response;", "couponInfoList", "", "Lkntr/app/mall/product/details/page/api/model/CouponInfoModel;", "sourceInfos", "", "mallKntrReceiveCoupon$product_details_page_debug", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Response", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CouponReceiveApiService {
    public static final int $stable = 0;
    private static final String API_URL_STRING = "https://mall.bilibili.com/mall-search-items/coupon/batch/receive/coupons";
    public static final CouponReceiveApiService INSTANCE = new CouponReceiveApiService();

    private CouponReceiveApiService() {
    }

    /* compiled from: CouponReceiveApiService.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0003-./B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBC\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J>\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\rHÖ\u0001J\t\u0010$\u001a\u00020\u0007HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u00060"}, d2 = {"Lkntr/app/mall/product/details/page/api/CouponReceiveApiService$Response;", "", "code", "", "data", "Lkntr/app/mall/product/details/page/api/CouponReceiveApiService$Response$Data;", "message", "", "success", "", "<init>", "(Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/CouponReceiveApiService$Response$Data;Ljava/lang/String;Ljava/lang/Boolean;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Lkntr/app/mall/product/details/page/api/CouponReceiveApiService$Response$Data;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getData", "()Lkntr/app/mall/product/details/page/api/CouponReceiveApiService$Response$Data;", "getMessage", "()Ljava/lang/String;", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/CouponReceiveApiService$Response$Data;Ljava/lang/String;Ljava/lang/Boolean;)Lkntr/app/mall/product/details/page/api/CouponReceiveApiService$Response;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "Data", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Response {
        private final Long code;
        private final Data data;
        private final String message;
        private final Boolean success;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public Response() {
            this((Long) null, (Data) null, (String) null, (Boolean) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Response copy$default(Response response, Long l, Data data, String str, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                l = response.code;
            }
            if ((i & 2) != 0) {
                data = response.data;
            }
            if ((i & 4) != 0) {
                str = response.message;
            }
            if ((i & 8) != 0) {
                bool = response.success;
            }
            return response.copy(l, data, str, bool);
        }

        public final Long component1() {
            return this.code;
        }

        public final Data component2() {
            return this.data;
        }

        public final String component3() {
            return this.message;
        }

        public final Boolean component4() {
            return this.success;
        }

        public final Response copy(Long l, Data data, String str, Boolean bool) {
            return new Response(l, data, str, bool);
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
            Data data = this.data;
            String str = this.message;
            return "Response(code=" + l + ", data=" + data + ", message=" + str + ", success=" + this.success + ")";
        }

        /* compiled from: CouponReceiveApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CouponReceiveApiService$Response$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CouponReceiveApiService$Response;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Response> serializer() {
                return new GeneratedSerializer<Response>() { // from class: kntr.app.mall.product.details.page.api.CouponReceiveApiService$Response$$serializer
                    public static final int $stable;
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.CouponReceiveApiService.Response", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.CouponReceiveApiService$Response> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.CouponReceiveApiService$Response> A[REMOVE]) =  kntr.app.mall.product.details.page.api.CouponReceiveApiService$Response$$serializer.INSTANCE kntr.app.mall.product.details.page.api.CouponReceiveApiService$Response$$serializer)
                             in method: kntr.app.mall.product.details.page.api.CouponReceiveApiService.Response.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.CouponReceiveApiService$Response>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                              ("kntr.app.mall.product.details.page.api.CouponReceiveApiService.Response")
                              (wrap: kntr.app.mall.product.details.page.api.CouponReceiveApiService$Response$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.CouponReceiveApiService$Response$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.CouponReceiveApiService$Response$$serializer.INSTANCE kntr.app.mall.product.details.page.api.CouponReceiveApiService$Response$$serializer)
                              (4 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.CouponReceiveApiService$Response$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.CouponReceiveApiService$Response$$serializer
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
                            kntr.app.mall.product.details.page.api.CouponReceiveApiService$Response$$serializer r0 = kntr.app.mall.product.details.page.api.CouponReceiveApiService$Response$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.CouponReceiveApiService.Response.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ Response(int seen0, Long code, Data data, String message, Boolean success, SerializationConstructorMarker serializationConstructorMarker) {
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

                public Response(Long code, Data data, String message, Boolean success) {
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
                        output.encodeNullableSerializableElement(serialDesc, 1, CouponReceiveApiService$Response$Data$$serializer.INSTANCE, self.data);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.message != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.message);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.success != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.success);
                    }
                }

                public /* synthetic */ Response(Long l, Data data, String str, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : data, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : bool);
                }

                public final Long getCode() {
                    return this.code;
                }

                public final Data getData() {
                    return this.data;
                }

                public final String getMessage() {
                    return this.message;
                }

                /* compiled from: CouponReceiveApiService.kt */
                @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB?\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J8\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006)"}, d2 = {"Lkntr/app/mall/product/details/page/api/CouponReceiveApiService$Response$Data;", "", "receiveSuccess", "", "toast", "", "successReceivedAuthorityIds", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getReceiveSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getToast", "()Ljava/lang/String;", "getSuccessReceivedAuthorityIds", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;)Lkntr/app/mall/product/details/page/api/CouponReceiveApiService$Response$Data;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                @Serializable
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Data {
                    private final Boolean receiveSuccess;
                    private final List<String> successReceivedAuthorityIds;
                    private final String toast;
                    public static final Companion Companion = new Companion(null);
                    public static final int $stable = 8;
                    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.CouponReceiveApiService$Response$Data$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            KSerializer _childSerializers$_anonymous_;
                            _childSerializers$_anonymous_ = CouponReceiveApiService.Response.Data._childSerializers$_anonymous_();
                            return _childSerializers$_anonymous_;
                        }
                    })};

                    public Data() {
                        this((Boolean) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public static /* synthetic */ Data copy$default(Data data, Boolean bool, String str, List list, int i, Object obj) {
                        if ((i & 1) != 0) {
                            bool = data.receiveSuccess;
                        }
                        if ((i & 2) != 0) {
                            str = data.toast;
                        }
                        if ((i & 4) != 0) {
                            list = data.successReceivedAuthorityIds;
                        }
                        return data.copy(bool, str, list);
                    }

                    public final Boolean component1() {
                        return this.receiveSuccess;
                    }

                    public final String component2() {
                        return this.toast;
                    }

                    public final List<String> component3() {
                        return this.successReceivedAuthorityIds;
                    }

                    public final Data copy(Boolean bool, String str, List<String> list) {
                        return new Data(bool, str, list);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof Data) {
                            Data data = (Data) obj;
                            return Intrinsics.areEqual(this.receiveSuccess, data.receiveSuccess) && Intrinsics.areEqual(this.toast, data.toast) && Intrinsics.areEqual(this.successReceivedAuthorityIds, data.successReceivedAuthorityIds);
                        }
                        return false;
                    }

                    public int hashCode() {
                        return ((((this.receiveSuccess == null ? 0 : this.receiveSuccess.hashCode()) * 31) + (this.toast == null ? 0 : this.toast.hashCode())) * 31) + (this.successReceivedAuthorityIds != null ? this.successReceivedAuthorityIds.hashCode() : 0);
                    }

                    public String toString() {
                        Boolean bool = this.receiveSuccess;
                        String str = this.toast;
                        return "Data(receiveSuccess=" + bool + ", toast=" + str + ", successReceivedAuthorityIds=" + this.successReceivedAuthorityIds + ")";
                    }

                    /* compiled from: CouponReceiveApiService.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CouponReceiveApiService$Response$Data$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CouponReceiveApiService$Response$Data;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<Data> serializer() {
                            return CouponReceiveApiService$Response$Data$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ Data(int seen0, Boolean receiveSuccess, String toast, List successReceivedAuthorityIds, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((seen0 & 1) == 0) {
                            this.receiveSuccess = null;
                        } else {
                            this.receiveSuccess = receiveSuccess;
                        }
                        if ((seen0 & 2) == 0) {
                            this.toast = null;
                        } else {
                            this.toast = toast;
                        }
                        if ((seen0 & 4) == 0) {
                            this.successReceivedAuthorityIds = null;
                        } else {
                            this.successReceivedAuthorityIds = successReceivedAuthorityIds;
                        }
                    }

                    public Data(Boolean receiveSuccess, String toast, List<String> list) {
                        this.receiveSuccess = receiveSuccess;
                        this.toast = toast;
                        this.successReceivedAuthorityIds = list;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                        return new ArrayListSerializer(StringSerializer.INSTANCE);
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$product_details_page_debug(Data self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.receiveSuccess != null) {
                            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.receiveSuccess);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.toast != null) {
                            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.toast);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.successReceivedAuthorityIds != null) {
                            output.encodeNullableSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.successReceivedAuthorityIds);
                        }
                    }

                    public /* synthetic */ Data(Boolean bool, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : list);
                    }

                    public final Boolean getReceiveSuccess() {
                        return this.receiveSuccess;
                    }

                    public final String getToast() {
                        return this.toast;
                    }

                    public final List<String> getSuccessReceivedAuthorityIds() {
                        return this.successReceivedAuthorityIds;
                    }
                }

                public final Boolean getSuccess() {
                    return this.success;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Object mallKntrReceiveCoupon$product_details_page_debug$default(CouponReceiveApiService couponReceiveApiService, List list, List list2, Continuation continuation, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = null;
                }
                if ((i & 2) != 0) {
                    list2 = null;
                }
                return couponReceiveApiService.mallKntrReceiveCoupon$product_details_page_debug(list, list2, continuation);
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0062  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object mallKntrReceiveCoupon$product_details_page_debug(List<CouponInfoModel> list, List<? extends Map<String, ? extends Object>> list2, Continuation<? super Response> continuation) {
                CouponReceiveApiService$mallKntrReceiveCoupon$1 couponReceiveApiService$mallKntrReceiveCoupon$1;
                CouponReceiveApiService$mallKntrReceiveCoupon$1 couponReceiveApiService$mallKntrReceiveCoupon$12;
                Collection destination$iv$iv$iv;
                Client $this$iv;
                try {
                    if (continuation instanceof CouponReceiveApiService$mallKntrReceiveCoupon$1) {
                        couponReceiveApiService$mallKntrReceiveCoupon$1 = (CouponReceiveApiService$mallKntrReceiveCoupon$1) continuation;
                        if ((couponReceiveApiService$mallKntrReceiveCoupon$1.label & Integer.MIN_VALUE) != 0) {
                            couponReceiveApiService$mallKntrReceiveCoupon$1.label -= Integer.MIN_VALUE;
                            couponReceiveApiService$mallKntrReceiveCoupon$12 = couponReceiveApiService$mallKntrReceiveCoupon$1;
                            Object $result = couponReceiveApiService$mallKntrReceiveCoupon$12.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (couponReceiveApiService$mallKntrReceiveCoupon$12.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    try {
                                        Client client = Client.INSTANCE;
                                        Pair[] pairArr = new Pair[5];
                                        if (list != null) {
                                            try {
                                                Json json$iv = Client.INSTANCE.getJson();
                                                List<CouponInfoModel> list3 = list;
                                                Collection destination$iv$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                                                Iterable $this$mapTo$iv$iv$iv = list3;
                                                boolean z = false;
                                                for (Object item$iv$iv$iv : $this$mapTo$iv$iv$iv) {
                                                    json$iv.getSerializersModule();
                                                    Iterable $this$mapTo$iv$iv$iv2 = $this$mapTo$iv$iv$iv;
                                                    Object $result2 = $result;
                                                    boolean z2 = z;
                                                    try {
                                                        JsonElement element$iv = json$iv.encodeToJsonElement(CouponInfoModel.Companion.serializer(), item$iv$iv$iv);
                                                        destination$iv$iv$iv2.add(HelperKt.toFoundationValue(element$iv));
                                                        z = z2;
                                                        $result = $result2;
                                                        $this$mapTo$iv$iv$iv = $this$mapTo$iv$iv$iv2;
                                                    } catch (Exception e) {
                                                        e = e;
                                                        return new Response(Boxing.boxLong(-1L), (Response.Data) null, "Failed to receive coupon: " + e.getMessage(), (Boolean) null, 10, (DefaultConstructorMarker) null);
                                                    }
                                                }
                                                destination$iv$iv$iv = (List) destination$iv$iv$iv2;
                                            } catch (Exception e2) {
                                                e = e2;
                                            }
                                        } else {
                                            destination$iv$iv$iv = null;
                                        }
                                        try {
                                            pairArr[0] = TuplesKt.to("couponInfoVOS", destination$iv$iv$iv);
                                        } catch (Exception e3) {
                                            e = e3;
                                        }
                                        try {
                                            pairArr[1] = TuplesKt.to("sourceInfos", list2);
                                            pairArr[2] = TuplesKt.to("fromPage", Boxing.boxInt(10));
                                            pairArr[3] = TuplesKt.to("sourceActivityId", "1102");
                                            pairArr[4] = TuplesKt.to("sourceBizId", Boxing.boxLong(DateFormatKt.getCurrentTimeMillis()));
                                            Map params$iv = MapsKt.mapOf(pairArr);
                                            $this$iv = client;
                                            try {
                                                couponReceiveApiService$mallKntrReceiveCoupon$12.L$0 = SpillingKt.nullOutSpilledVariable(list);
                                                couponReceiveApiService$mallKntrReceiveCoupon$12.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                                                couponReceiveApiService$mallKntrReceiveCoupon$12.L$2 = $this$iv;
                                                couponReceiveApiService$mallKntrReceiveCoupon$12.L$3 = SpillingKt.nullOutSpilledVariable(API_URL_STRING);
                                                couponReceiveApiService$mallKntrReceiveCoupon$12.L$4 = SpillingKt.nullOutSpilledVariable("POST");
                                                couponReceiveApiService$mallKntrReceiveCoupon$12.L$5 = SpillingKt.nullOutSpilledVariable(params$iv);
                                                couponReceiveApiService$mallKntrReceiveCoupon$12.I$0 = 0;
                                                couponReceiveApiService$mallKntrReceiveCoupon$12.label = 1;
                                                $result = MallEnvKt.mallKntrAsyncRequest(API_URL_STRING, "POST", (Map) null, params$iv, couponReceiveApiService$mallKntrReceiveCoupon$12);
                                                if ($result == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                try {
                                                    String jsonString$iv = (String) $result;
                                                    Json this_$iv$iv = $this$iv.getJson();
                                                    Intrinsics.checkNotNull(jsonString$iv);
                                                    this_$iv$iv.getSerializersModule();
                                                    Object res$iv = this_$iv$iv.decodeFromString(Response.Companion.serializer(), jsonString$iv);
                                                    return (Response) res$iv;
                                                } catch (Exception e4) {
                                                    e$iv = e4;
                                                    KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                                    throw e$iv;
                                                }
                                            } catch (Exception e5) {
                                                e$iv = e5;
                                                KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                                throw e$iv;
                                            }
                                        } catch (Exception e6) {
                                            e = e6;
                                            return new Response(Boxing.boxLong(-1L), (Response.Data) null, "Failed to receive coupon: " + e.getMessage(), (Boolean) null, 10, (DefaultConstructorMarker) null);
                                        }
                                    } catch (Exception e7) {
                                        e = e7;
                                    }
                                case 1:
                                    int i = couponReceiveApiService$mallKntrReceiveCoupon$12.I$0;
                                    Map map = (Map) couponReceiveApiService$mallKntrReceiveCoupon$12.L$5;
                                    String str = (String) couponReceiveApiService$mallKntrReceiveCoupon$12.L$4;
                                    String str2 = (String) couponReceiveApiService$mallKntrReceiveCoupon$12.L$3;
                                    $this$iv = (Client) couponReceiveApiService$mallKntrReceiveCoupon$12.L$2;
                                    List list4 = (List) couponReceiveApiService$mallKntrReceiveCoupon$12.L$1;
                                    List list5 = (List) couponReceiveApiService$mallKntrReceiveCoupon$12.L$0;
                                    try {
                                        ResultKt.throwOnFailure($result);
                                        String jsonString$iv2 = (String) $result;
                                        Json this_$iv$iv2 = $this$iv.getJson();
                                        Intrinsics.checkNotNull(jsonString$iv2);
                                        this_$iv$iv2.getSerializersModule();
                                        Object res$iv2 = this_$iv$iv2.decodeFromString(Response.Companion.serializer(), jsonString$iv2);
                                        return (Response) res$iv2;
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
                    switch (couponReceiveApiService$mallKntrReceiveCoupon$12.label) {
                    }
                } catch (Exception e9) {
                    e = e9;
                }
                couponReceiveApiService$mallKntrReceiveCoupon$1 = new CouponReceiveApiService$mallKntrReceiveCoupon$1(this, continuation);
                couponReceiveApiService$mallKntrReceiveCoupon$12 = couponReceiveApiService$mallKntrReceiveCoupon$1;
                Object $result3 = couponReceiveApiService$mallKntrReceiveCoupon$12.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
        }