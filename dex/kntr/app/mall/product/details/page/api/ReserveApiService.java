package kntr.app.mall.product.details.page.api;

import com.bilibili.mall.kmm.base.MallEnvKt;
import java.util.Map;
import kntr.app.mall.product.details.page.api.CouponListResponse;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: ReserveApiService.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0080@¢\u0006\u0004\b\f\u0010\rJP\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00112\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0011H\u0080@¢\u0006\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkntr/app/mall/product/details/page/api/ReserveApiService;", "", "<init>", "()V", "RESERVE_RECEIVE_URL", "", "RESERVE_RECEIVE_RESULT_URL", "K_LOG_TAG", "reserveAndReceiveCouponResult", "Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveResultResponse;", "token", "itemsId", "reserveAndReceiveCouponResult$product_details_page_debug", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reserveAndReceiveCoupon", "Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveAndReceiveResponse;", "reserveReq", "", "receiveCouponCmd", "reserveAndReceiveCoupon$product_details_page_debug", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ReserveResultResponse", "ReserveAndReceiveResponse", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ReserveApiService {
    public static final int $stable = 0;
    public static final ReserveApiService INSTANCE = new ReserveApiService();
    private static final String K_LOG_TAG = "NA_WR_ReserveApiService";
    private static final String RESERVE_RECEIVE_RESULT_URL = "https://mall.bilibili.com/mall-marketing-c/course/reserveAndReceiveResult";
    private static final String RESERVE_RECEIVE_URL = "https://mall.bilibili.com/mall-marketing-c/course/reserveAndReceiveCoupon";

    private ReserveApiService() {
    }

    /* compiled from: ReserveApiService.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0003*+,B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006-"}, d2 = {"Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveResultResponse;", "", "code", "", "errtag", "message", "", "data", "Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveResultResponse$ReserveResultData;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveResultResponse$ReserveResultData;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveResultResponse$ReserveResultData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrtag", "getMessage", "()Ljava/lang/String;", "getData", "()Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveResultResponse$ReserveResultData;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveResultResponse$ReserveResultData;)Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveResultResponse;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ReserveResultData", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ReserveResultResponse {
        private final Integer code;
        private final ReserveResultData data;
        private final Integer errtag;
        private final String message;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public ReserveResultResponse() {
            this((Integer) null, (Integer) null, (String) null, (ReserveResultData) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ReserveResultResponse copy$default(ReserveResultResponse reserveResultResponse, Integer num, Integer num2, String str, ReserveResultData reserveResultData, int i, Object obj) {
            if ((i & 1) != 0) {
                num = reserveResultResponse.code;
            }
            if ((i & 2) != 0) {
                num2 = reserveResultResponse.errtag;
            }
            if ((i & 4) != 0) {
                str = reserveResultResponse.message;
            }
            if ((i & 8) != 0) {
                reserveResultData = reserveResultResponse.data;
            }
            return reserveResultResponse.copy(num, num2, str, reserveResultData);
        }

        public final Integer component1() {
            return this.code;
        }

        public final Integer component2() {
            return this.errtag;
        }

        public final String component3() {
            return this.message;
        }

        public final ReserveResultData component4() {
            return this.data;
        }

        public final ReserveResultResponse copy(Integer num, Integer num2, String str, ReserveResultData reserveResultData) {
            return new ReserveResultResponse(num, num2, str, reserveResultData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ReserveResultResponse) {
                ReserveResultResponse reserveResultResponse = (ReserveResultResponse) obj;
                return Intrinsics.areEqual(this.code, reserveResultResponse.code) && Intrinsics.areEqual(this.errtag, reserveResultResponse.errtag) && Intrinsics.areEqual(this.message, reserveResultResponse.message) && Intrinsics.areEqual(this.data, reserveResultResponse.data);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.code == null ? 0 : this.code.hashCode()) * 31) + (this.errtag == null ? 0 : this.errtag.hashCode())) * 31) + (this.message == null ? 0 : this.message.hashCode())) * 31) + (this.data != null ? this.data.hashCode() : 0);
        }

        public String toString() {
            Integer num = this.code;
            Integer num2 = this.errtag;
            String str = this.message;
            return "ReserveResultResponse(code=" + num + ", errtag=" + num2 + ", message=" + str + ", data=" + this.data + ")";
        }

        /* compiled from: ReserveApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveResultResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveResultResponse;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ReserveResultResponse> serializer() {
                return new GeneratedSerializer<ReserveResultResponse>() { // from class: kntr.app.mall.product.details.page.api.ReserveApiService$ReserveResultResponse$$serializer
                    public static final int $stable;
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.ReserveApiService.ReserveResultResponse", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.ReserveApiService$ReserveResultResponse> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.ReserveApiService$ReserveResultResponse> A[REMOVE]) =  kntr.app.mall.product.details.page.api.ReserveApiService$ReserveResultResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.ReserveApiService$ReserveResultResponse$$serializer)
                             in method: kntr.app.mall.product.details.page.api.ReserveApiService.ReserveResultResponse.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.ReserveApiService$ReserveResultResponse>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                              ("kntr.app.mall.product.details.page.api.ReserveApiService.ReserveResultResponse")
                              (wrap: kntr.app.mall.product.details.page.api.ReserveApiService$ReserveResultResponse$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.ReserveApiService$ReserveResultResponse$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.ReserveApiService$ReserveResultResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.ReserveApiService$ReserveResultResponse$$serializer)
                              (4 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.ReserveApiService$ReserveResultResponse$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.ReserveApiService$ReserveResultResponse$$serializer
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
                            kntr.app.mall.product.details.page.api.ReserveApiService$ReserveResultResponse$$serializer r0 = kntr.app.mall.product.details.page.api.ReserveApiService$ReserveResultResponse$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.ReserveApiService.ReserveResultResponse.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ ReserveResultResponse(int seen0, Integer code, Integer errtag, String message, ReserveResultData data, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.code = 0;
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

                public ReserveResultResponse(Integer code, Integer errtag, String message, ReserveResultData data) {
                    this.code = code;
                    this.errtag = errtag;
                    this.message = message;
                    this.data = data;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(ReserveResultResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Integer num;
                    Integer num2;
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || (num = self.code) == null || num.intValue() != 0) {
                        output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.code);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || (num2 = self.errtag) == null || num2.intValue() != 0) {
                        output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.errtag);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.message, "")) {
                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.message);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.data != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, ReserveApiService$ReserveResultResponse$ReserveResultData$$serializer.INSTANCE, self.data);
                    }
                }

                public /* synthetic */ ReserveResultResponse(Integer num, Integer num2, String str, ReserveResultData reserveResultData, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? 0 : num2, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? null : reserveResultData);
                }

                public final Integer getCode() {
                    return this.code;
                }

                public final Integer getErrtag() {
                    return this.errtag;
                }

                public final String getMessage() {
                    return this.message;
                }

                /* compiled from: ReserveApiService.kt */
                @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000201BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fBW\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003JV\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u000eHÖ\u0001J\t\u0010'\u001a\u00020\tHÖ\u0001J%\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001¢\u0006\u0002\b/R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001a¨\u00062"}, d2 = {"Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveResultResponse$ReserveResultData;", "", "couponInfoDTO", "Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem;", "finished", "", "receiveCouponSuccess", "reserveSuccess", "resultText", "", "toast", "<init>", "(Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCouponInfoDTO", "()Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem;", "getFinished", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getReceiveCouponSuccess", "getReserveSuccess", "getResultText", "()Ljava/lang/String;", "getToast", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveResultResponse$ReserveResultData;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                @Serializable
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class ReserveResultData {
                    private final CouponListResponse.CouponListItem couponInfoDTO;
                    private final Boolean finished;
                    private final Boolean receiveCouponSuccess;
                    private final Boolean reserveSuccess;
                    private final String resultText;
                    private final String toast;
                    public static final Companion Companion = new Companion(null);
                    public static final int $stable = 8;

                    public ReserveResultData() {
                        this((CouponListResponse.CouponListItem) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
                    }

                    public static /* synthetic */ ReserveResultData copy$default(ReserveResultData reserveResultData, CouponListResponse.CouponListItem couponListItem, Boolean bool, Boolean bool2, Boolean bool3, String str, String str2, int i, Object obj) {
                        if ((i & 1) != 0) {
                            couponListItem = reserveResultData.couponInfoDTO;
                        }
                        if ((i & 2) != 0) {
                            bool = reserveResultData.finished;
                        }
                        Boolean bool4 = bool;
                        if ((i & 4) != 0) {
                            bool2 = reserveResultData.receiveCouponSuccess;
                        }
                        Boolean bool5 = bool2;
                        if ((i & 8) != 0) {
                            bool3 = reserveResultData.reserveSuccess;
                        }
                        Boolean bool6 = bool3;
                        if ((i & 16) != 0) {
                            str = reserveResultData.resultText;
                        }
                        String str3 = str;
                        if ((i & 32) != 0) {
                            str2 = reserveResultData.toast;
                        }
                        return reserveResultData.copy(couponListItem, bool4, bool5, bool6, str3, str2);
                    }

                    public final CouponListResponse.CouponListItem component1() {
                        return this.couponInfoDTO;
                    }

                    public final Boolean component2() {
                        return this.finished;
                    }

                    public final Boolean component3() {
                        return this.receiveCouponSuccess;
                    }

                    public final Boolean component4() {
                        return this.reserveSuccess;
                    }

                    public final String component5() {
                        return this.resultText;
                    }

                    public final String component6() {
                        return this.toast;
                    }

                    public final ReserveResultData copy(CouponListResponse.CouponListItem couponListItem, Boolean bool, Boolean bool2, Boolean bool3, String str, String str2) {
                        return new ReserveResultData(couponListItem, bool, bool2, bool3, str, str2);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof ReserveResultData) {
                            ReserveResultData reserveResultData = (ReserveResultData) obj;
                            return Intrinsics.areEqual(this.couponInfoDTO, reserveResultData.couponInfoDTO) && Intrinsics.areEqual(this.finished, reserveResultData.finished) && Intrinsics.areEqual(this.receiveCouponSuccess, reserveResultData.receiveCouponSuccess) && Intrinsics.areEqual(this.reserveSuccess, reserveResultData.reserveSuccess) && Intrinsics.areEqual(this.resultText, reserveResultData.resultText) && Intrinsics.areEqual(this.toast, reserveResultData.toast);
                        }
                        return false;
                    }

                    public int hashCode() {
                        return ((((((((((this.couponInfoDTO == null ? 0 : this.couponInfoDTO.hashCode()) * 31) + (this.finished == null ? 0 : this.finished.hashCode())) * 31) + (this.receiveCouponSuccess == null ? 0 : this.receiveCouponSuccess.hashCode())) * 31) + (this.reserveSuccess == null ? 0 : this.reserveSuccess.hashCode())) * 31) + (this.resultText == null ? 0 : this.resultText.hashCode())) * 31) + (this.toast != null ? this.toast.hashCode() : 0);
                    }

                    public String toString() {
                        CouponListResponse.CouponListItem couponListItem = this.couponInfoDTO;
                        Boolean bool = this.finished;
                        Boolean bool2 = this.receiveCouponSuccess;
                        Boolean bool3 = this.reserveSuccess;
                        String str = this.resultText;
                        return "ReserveResultData(couponInfoDTO=" + couponListItem + ", finished=" + bool + ", receiveCouponSuccess=" + bool2 + ", reserveSuccess=" + bool3 + ", resultText=" + str + ", toast=" + this.toast + ")";
                    }

                    /* compiled from: ReserveApiService.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveResultResponse$ReserveResultData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveResultResponse$ReserveResultData;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<ReserveResultData> serializer() {
                            return ReserveApiService$ReserveResultResponse$ReserveResultData$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ ReserveResultData(int seen0, CouponListResponse.CouponListItem couponInfoDTO, Boolean finished, Boolean receiveCouponSuccess, Boolean reserveSuccess, String resultText, String toast, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((seen0 & 1) == 0) {
                            this.couponInfoDTO = null;
                        } else {
                            this.couponInfoDTO = couponInfoDTO;
                        }
                        if ((seen0 & 2) == 0) {
                            this.finished = null;
                        } else {
                            this.finished = finished;
                        }
                        if ((seen0 & 4) == 0) {
                            this.receiveCouponSuccess = null;
                        } else {
                            this.receiveCouponSuccess = receiveCouponSuccess;
                        }
                        if ((seen0 & 8) == 0) {
                            this.reserveSuccess = null;
                        } else {
                            this.reserveSuccess = reserveSuccess;
                        }
                        if ((seen0 & 16) == 0) {
                            this.resultText = null;
                        } else {
                            this.resultText = resultText;
                        }
                        if ((seen0 & 32) == 0) {
                            this.toast = null;
                        } else {
                            this.toast = toast;
                        }
                    }

                    public ReserveResultData(CouponListResponse.CouponListItem couponInfoDTO, Boolean finished, Boolean receiveCouponSuccess, Boolean reserveSuccess, String resultText, String toast) {
                        this.couponInfoDTO = couponInfoDTO;
                        this.finished = finished;
                        this.receiveCouponSuccess = receiveCouponSuccess;
                        this.reserveSuccess = reserveSuccess;
                        this.resultText = resultText;
                        this.toast = toast;
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$product_details_page_debug(ReserveResultData self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.couponInfoDTO != null) {
                            output.encodeNullableSerializableElement(serialDesc, 0, CouponListResponse$CouponListItem$$serializer.INSTANCE, self.couponInfoDTO);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.finished != null) {
                            output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.finished);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.receiveCouponSuccess != null) {
                            output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.receiveCouponSuccess);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.reserveSuccess != null) {
                            output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.reserveSuccess);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.resultText != null) {
                            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.resultText);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.toast != null) {
                            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.toast);
                        }
                    }

                    public /* synthetic */ ReserveResultData(CouponListResponse.CouponListItem couponListItem, Boolean bool, Boolean bool2, Boolean bool3, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : couponListItem, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : bool3, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : str2);
                    }

                    public final CouponListResponse.CouponListItem getCouponInfoDTO() {
                        return this.couponInfoDTO;
                    }

                    public final Boolean getFinished() {
                        return this.finished;
                    }

                    public final Boolean getReceiveCouponSuccess() {
                        return this.receiveCouponSuccess;
                    }

                    public final Boolean getReserveSuccess() {
                        return this.reserveSuccess;
                    }

                    public final String getResultText() {
                        return this.resultText;
                    }

                    public final String getToast() {
                        return this.toast;
                    }
                }

                public final ReserveResultData getData() {
                    return this.data;
                }
            }

            public static /* synthetic */ Object reserveAndReceiveCouponResult$product_details_page_debug$default(ReserveApiService reserveApiService, String str, String str2, Continuation continuation, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = null;
                }
                if ((i & 2) != 0) {
                    str2 = null;
                }
                return reserveApiService.reserveAndReceiveCouponResult$product_details_page_debug(str, str2, continuation);
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object reserveAndReceiveCouponResult$product_details_page_debug(String token, String itemsId, Continuation<? super ReserveResultResponse> continuation) {
                ReserveApiService$reserveAndReceiveCouponResult$1 reserveApiService$reserveAndReceiveCouponResult$1;
                ReserveApiService$reserveAndReceiveCouponResult$1 reserveApiService$reserveAndReceiveCouponResult$12;
                String itemsId2;
                String token2;
                Client client;
                Map headers$iv;
                Pair[] pairArr;
                Client this_$iv;
                Object mallKntrAsyncRequest;
                String token3;
                String itemsId3;
                if (continuation instanceof ReserveApiService$reserveAndReceiveCouponResult$1) {
                    reserveApiService$reserveAndReceiveCouponResult$1 = (ReserveApiService$reserveAndReceiveCouponResult$1) continuation;
                    if ((reserveApiService$reserveAndReceiveCouponResult$1.label & Integer.MIN_VALUE) != 0) {
                        reserveApiService$reserveAndReceiveCouponResult$1.label -= Integer.MIN_VALUE;
                        reserveApiService$reserveAndReceiveCouponResult$12 = reserveApiService$reserveAndReceiveCouponResult$1;
                        Object $result = reserveApiService$reserveAndReceiveCouponResult$12.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (reserveApiService$reserveAndReceiveCouponResult$12.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                try {
                                    client = Client.INSTANCE;
                                    headers$iv = MapsKt.mapOf(TuplesKt.to("Content-Type", "application/json"));
                                    pairArr = new Pair[2];
                                    itemsId2 = token;
                                } catch (Exception e) {
                                    e = e;
                                    itemsId2 = token;
                                }
                                try {
                                    pairArr[0] = TuplesKt.to("token", itemsId2);
                                    token2 = itemsId;
                                } catch (Exception e2) {
                                    e = e2;
                                    token2 = itemsId;
                                    KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to reserve and receive coupon result: " + e.getMessage(), e);
                                    return new ReserveResultResponse(Boxing.boxInt(-1), (Integer) null, "Failed to reserve and receive coupon result: " + e.getMessage(), (ReserveResultResponse.ReserveResultData) null, 10, (DefaultConstructorMarker) null);
                                }
                                try {
                                    pairArr[1] = TuplesKt.to("itemsId", token2);
                                    Map params$iv = MapsKt.mapOf(pairArr);
                                    this_$iv = client;
                                    try {
                                        reserveApiService$reserveAndReceiveCouponResult$12.L$0 = SpillingKt.nullOutSpilledVariable(token);
                                        reserveApiService$reserveAndReceiveCouponResult$12.L$1 = SpillingKt.nullOutSpilledVariable(itemsId);
                                        reserveApiService$reserveAndReceiveCouponResult$12.L$2 = this_$iv;
                                        reserveApiService$reserveAndReceiveCouponResult$12.L$3 = SpillingKt.nullOutSpilledVariable(RESERVE_RECEIVE_RESULT_URL);
                                        reserveApiService$reserveAndReceiveCouponResult$12.L$4 = SpillingKt.nullOutSpilledVariable("POST");
                                        reserveApiService$reserveAndReceiveCouponResult$12.L$5 = SpillingKt.nullOutSpilledVariable(headers$iv);
                                        reserveApiService$reserveAndReceiveCouponResult$12.L$6 = SpillingKt.nullOutSpilledVariable(params$iv);
                                        reserveApiService$reserveAndReceiveCouponResult$12.I$0 = 0;
                                        reserveApiService$reserveAndReceiveCouponResult$12.label = 1;
                                        mallKntrAsyncRequest = MallEnvKt.mallKntrAsyncRequest(RESERVE_RECEIVE_RESULT_URL, "POST", headers$iv, params$iv, reserveApiService$reserveAndReceiveCouponResult$12);
                                        if (mallKntrAsyncRequest == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        token3 = itemsId2;
                                        itemsId3 = token2;
                                        String jsonString$iv = (String) mallKntrAsyncRequest;
                                        Json this_$iv$iv = this_$iv.getJson();
                                        Intrinsics.checkNotNull(jsonString$iv);
                                        this_$iv$iv.getSerializersModule();
                                        Object res$iv = this_$iv$iv.decodeFromString(ReserveResultResponse.Companion.serializer(), jsonString$iv);
                                        try {
                                            return (ReserveResultResponse) res$iv;
                                        } catch (Exception e3) {
                                            e = e3;
                                            String str = token3;
                                            token2 = itemsId3;
                                            itemsId2 = str;
                                            KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to reserve and receive coupon result: " + e.getMessage(), e);
                                            return new ReserveResultResponse(Boxing.boxInt(-1), (Integer) null, "Failed to reserve and receive coupon result: " + e.getMessage(), (ReserveResultResponse.ReserveResultData) null, 10, (DefaultConstructorMarker) null);
                                        }
                                    } catch (Exception e4) {
                                        e$iv = e4;
                                        try {
                                            KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                            throw e$iv;
                                        } catch (Exception e5) {
                                            e = e5;
                                            KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to reserve and receive coupon result: " + e.getMessage(), e);
                                            return new ReserveResultResponse(Boxing.boxInt(-1), (Integer) null, "Failed to reserve and receive coupon result: " + e.getMessage(), (ReserveResultResponse.ReserveResultData) null, 10, (DefaultConstructorMarker) null);
                                        }
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to reserve and receive coupon result: " + e.getMessage(), e);
                                    return new ReserveResultResponse(Boxing.boxInt(-1), (Integer) null, "Failed to reserve and receive coupon result: " + e.getMessage(), (ReserveResultResponse.ReserveResultData) null, 10, (DefaultConstructorMarker) null);
                                }
                            case 1:
                                int i = reserveApiService$reserveAndReceiveCouponResult$12.I$0;
                                Map map = (Map) reserveApiService$reserveAndReceiveCouponResult$12.L$6;
                                Map map2 = (Map) reserveApiService$reserveAndReceiveCouponResult$12.L$5;
                                String str2 = (String) reserveApiService$reserveAndReceiveCouponResult$12.L$4;
                                String str3 = (String) reserveApiService$reserveAndReceiveCouponResult$12.L$3;
                                this_$iv = (Client) reserveApiService$reserveAndReceiveCouponResult$12.L$2;
                                itemsId3 = (String) reserveApiService$reserveAndReceiveCouponResult$12.L$1;
                                token3 = (String) reserveApiService$reserveAndReceiveCouponResult$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    mallKntrAsyncRequest = $result;
                                    String jsonString$iv2 = (String) mallKntrAsyncRequest;
                                    Json this_$iv$iv2 = this_$iv.getJson();
                                    Intrinsics.checkNotNull(jsonString$iv2);
                                    this_$iv$iv2.getSerializersModule();
                                    Object res$iv2 = this_$iv$iv2.decodeFromString(ReserveResultResponse.Companion.serializer(), jsonString$iv2);
                                    return (ReserveResultResponse) res$iv2;
                                } catch (Exception e7) {
                                    e$iv = e7;
                                    String str4 = token3;
                                    token2 = itemsId3;
                                    itemsId2 = str4;
                                    KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                    throw e$iv;
                                }
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
                reserveApiService$reserveAndReceiveCouponResult$1 = new ReserveApiService$reserveAndReceiveCouponResult$1(this, continuation);
                reserveApiService$reserveAndReceiveCouponResult$12 = reserveApiService$reserveAndReceiveCouponResult$1;
                Object $result2 = reserveApiService$reserveAndReceiveCouponResult$12.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (reserveApiService$reserveAndReceiveCouponResult$12.label) {
                }
            }

            /* compiled from: ReserveApiService.kt */
            @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J>\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006*"}, d2 = {"Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveAndReceiveResponse;", "", "code", "", "errtag", "message", "", "data", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrtag", "getMessage", "()Ljava/lang/String;", "getData", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveAndReceiveResponse;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class ReserveAndReceiveResponse {
                public static final int $stable = 0;
                public static final Companion Companion = new Companion(null);
                private final Integer code;
                private final String data;
                private final Integer errtag;
                private final String message;

                public ReserveAndReceiveResponse() {
                    this((Integer) null, (Integer) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
                }

                public static /* synthetic */ ReserveAndReceiveResponse copy$default(ReserveAndReceiveResponse reserveAndReceiveResponse, Integer num, Integer num2, String str, String str2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        num = reserveAndReceiveResponse.code;
                    }
                    if ((i & 2) != 0) {
                        num2 = reserveAndReceiveResponse.errtag;
                    }
                    if ((i & 4) != 0) {
                        str = reserveAndReceiveResponse.message;
                    }
                    if ((i & 8) != 0) {
                        str2 = reserveAndReceiveResponse.data;
                    }
                    return reserveAndReceiveResponse.copy(num, num2, str, str2);
                }

                public final Integer component1() {
                    return this.code;
                }

                public final Integer component2() {
                    return this.errtag;
                }

                public final String component3() {
                    return this.message;
                }

                public final String component4() {
                    return this.data;
                }

                public final ReserveAndReceiveResponse copy(Integer num, Integer num2, String str, String str2) {
                    return new ReserveAndReceiveResponse(num, num2, str, str2);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof ReserveAndReceiveResponse) {
                        ReserveAndReceiveResponse reserveAndReceiveResponse = (ReserveAndReceiveResponse) obj;
                        return Intrinsics.areEqual(this.code, reserveAndReceiveResponse.code) && Intrinsics.areEqual(this.errtag, reserveAndReceiveResponse.errtag) && Intrinsics.areEqual(this.message, reserveAndReceiveResponse.message) && Intrinsics.areEqual(this.data, reserveAndReceiveResponse.data);
                    }
                    return false;
                }

                public int hashCode() {
                    return ((((((this.code == null ? 0 : this.code.hashCode()) * 31) + (this.errtag == null ? 0 : this.errtag.hashCode())) * 31) + (this.message == null ? 0 : this.message.hashCode())) * 31) + (this.data != null ? this.data.hashCode() : 0);
                }

                public String toString() {
                    Integer num = this.code;
                    Integer num2 = this.errtag;
                    String str = this.message;
                    return "ReserveAndReceiveResponse(code=" + num + ", errtag=" + num2 + ", message=" + str + ", data=" + this.data + ")";
                }

                /* compiled from: ReserveApiService.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveAndReceiveResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveAndReceiveResponse;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<ReserveAndReceiveResponse> serializer() {
                        return new GeneratedSerializer<ReserveAndReceiveResponse>() { // from class: kntr.app.mall.product.details.page.api.ReserveApiService$ReserveAndReceiveResponse$$serializer
                            public static final int $stable;
                            private static final SerialDescriptor descriptor;

                            public final SerialDescriptor getDescriptor() {
                                return descriptor;
                            }

                            static {
                                SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.ReserveApiService.ReserveAndReceiveResponse", 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                                      (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.ReserveApiService$ReserveAndReceiveResponse> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.ReserveApiService$ReserveAndReceiveResponse> A[REMOVE]) =  kntr.app.mall.product.details.page.api.ReserveApiService$ReserveAndReceiveResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.ReserveApiService$ReserveAndReceiveResponse$$serializer)
                                     in method: kntr.app.mall.product.details.page.api.ReserveApiService.ReserveAndReceiveResponse.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.ReserveApiService$ReserveAndReceiveResponse>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                                      ("kntr.app.mall.product.details.page.api.ReserveApiService.ReserveAndReceiveResponse")
                                      (wrap: kntr.app.mall.product.details.page.api.ReserveApiService$ReserveAndReceiveResponse$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.ReserveApiService$ReserveAndReceiveResponse$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.ReserveApiService$ReserveAndReceiveResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.ReserveApiService$ReserveAndReceiveResponse$$serializer)
                                      (4 int)
                                     call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.ReserveApiService$ReserveAndReceiveResponse$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.ReserveApiService$ReserveAndReceiveResponse$$serializer
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
                                    kntr.app.mall.product.details.page.api.ReserveApiService$ReserveAndReceiveResponse$$serializer r0 = kntr.app.mall.product.details.page.api.ReserveApiService$ReserveAndReceiveResponse$$serializer.INSTANCE
                                    kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                                    return r0
                                */
                                throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.ReserveApiService.ReserveAndReceiveResponse.Companion.serializer():kotlinx.serialization.KSerializer");
                            }
                        }

                        public /* synthetic */ ReserveAndReceiveResponse(int seen0, Integer code, Integer errtag, String message, String data, SerializationConstructorMarker serializationConstructorMarker) {
                            if ((seen0 & 1) == 0) {
                                this.code = 0;
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

                        public ReserveAndReceiveResponse(Integer code, Integer errtag, String message, String data) {
                            this.code = code;
                            this.errtag = errtag;
                            this.message = message;
                            this.data = data;
                        }

                        @JvmStatic
                        public static final /* synthetic */ void write$Self$product_details_page_debug(ReserveAndReceiveResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
                            Integer num;
                            Integer num2;
                            if (output.shouldEncodeElementDefault(serialDesc, 0) || (num = self.code) == null || num.intValue() != 0) {
                                output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.code);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 1) || (num2 = self.errtag) == null || num2.intValue() != 0) {
                                output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.errtag);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.message, "")) {
                                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.message);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.data != null) {
                                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.data);
                            }
                        }

                        public /* synthetic */ ReserveAndReceiveResponse(Integer num, Integer num2, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                            this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? 0 : num2, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? null : str2);
                        }

                        public final Integer getCode() {
                            return this.code;
                        }

                        public final Integer getErrtag() {
                            return this.errtag;
                        }

                        public final String getMessage() {
                            return this.message;
                        }

                        public final String getData() {
                            return this.data;
                        }
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public static /* synthetic */ Object reserveAndReceiveCoupon$product_details_page_debug$default(ReserveApiService reserveApiService, String str, Map map, Map map2, Continuation continuation, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = null;
                        }
                        if ((i & 2) != 0) {
                            map = null;
                        }
                        if ((i & 4) != 0) {
                            map2 = null;
                        }
                        return reserveApiService.reserveAndReceiveCoupon$product_details_page_debug(str, map, map2, continuation);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
                    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
                    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object reserveAndReceiveCoupon$product_details_page_debug(String itemsId, Map<String, ? extends Object> map, Map<String, ? extends Object> map2, Continuation<? super ReserveAndReceiveResponse> continuation) {
                        ReserveApiService$reserveAndReceiveCoupon$1 reserveApiService$reserveAndReceiveCoupon$1;
                        ReserveApiService$reserveAndReceiveCoupon$1 reserveApiService$reserveAndReceiveCoupon$12;
                        Client this_$iv;
                        Object mallKntrAsyncRequest;
                        if (continuation instanceof ReserveApiService$reserveAndReceiveCoupon$1) {
                            reserveApiService$reserveAndReceiveCoupon$1 = (ReserveApiService$reserveAndReceiveCoupon$1) continuation;
                            if ((reserveApiService$reserveAndReceiveCoupon$1.label & Integer.MIN_VALUE) != 0) {
                                reserveApiService$reserveAndReceiveCoupon$1.label -= Integer.MIN_VALUE;
                                reserveApiService$reserveAndReceiveCoupon$12 = reserveApiService$reserveAndReceiveCoupon$1;
                                Object $result = reserveApiService$reserveAndReceiveCoupon$12.result;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (reserveApiService$reserveAndReceiveCoupon$12.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        try {
                                            Client client = Client.INSTANCE;
                                            Map headers$iv = MapsKt.mapOf(TuplesKt.to("Content-Type", "application/json"));
                                            Pair[] pairArr = new Pair[3];
                                            try {
                                                pairArr[0] = TuplesKt.to("itemsId", itemsId);
                                                try {
                                                    pairArr[1] = TuplesKt.to("reserveReq", map);
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                                try {
                                                    pairArr[2] = TuplesKt.to("receiveCouponCmd", map2);
                                                    Map params$iv = MapsKt.mapOf(pairArr);
                                                    this_$iv = client;
                                                    try {
                                                        reserveApiService$reserveAndReceiveCoupon$12.L$0 = SpillingKt.nullOutSpilledVariable(itemsId);
                                                        reserveApiService$reserveAndReceiveCoupon$12.L$1 = SpillingKt.nullOutSpilledVariable(map);
                                                        reserveApiService$reserveAndReceiveCoupon$12.L$2 = SpillingKt.nullOutSpilledVariable(map2);
                                                        reserveApiService$reserveAndReceiveCoupon$12.L$3 = this_$iv;
                                                        reserveApiService$reserveAndReceiveCoupon$12.L$4 = SpillingKt.nullOutSpilledVariable(RESERVE_RECEIVE_URL);
                                                        reserveApiService$reserveAndReceiveCoupon$12.L$5 = SpillingKt.nullOutSpilledVariable("POST");
                                                        reserveApiService$reserveAndReceiveCoupon$12.L$6 = SpillingKt.nullOutSpilledVariable(headers$iv);
                                                        reserveApiService$reserveAndReceiveCoupon$12.L$7 = SpillingKt.nullOutSpilledVariable(params$iv);
                                                        reserveApiService$reserveAndReceiveCoupon$12.I$0 = 0;
                                                        reserveApiService$reserveAndReceiveCoupon$12.label = 1;
                                                        mallKntrAsyncRequest = MallEnvKt.mallKntrAsyncRequest(RESERVE_RECEIVE_URL, "POST", headers$iv, params$iv, reserveApiService$reserveAndReceiveCoupon$12);
                                                        if (mallKntrAsyncRequest == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        try {
                                                            String jsonString$iv = (String) mallKntrAsyncRequest;
                                                            Json this_$iv$iv = this_$iv.getJson();
                                                            Intrinsics.checkNotNull(jsonString$iv);
                                                            this_$iv$iv.getSerializersModule();
                                                            Object res$iv = this_$iv$iv.decodeFromString(ReserveAndReceiveResponse.Companion.serializer(), jsonString$iv);
                                                            try {
                                                                return (ReserveAndReceiveResponse) res$iv;
                                                            } catch (Exception e2) {
                                                                e = e2;
                                                                KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to reserve and receive coupon: " + e.getMessage(), e);
                                                                return new ReserveAndReceiveResponse(Boxing.boxInt(-1), (Integer) null, "Failed to reserve and receive coupon: " + e.getMessage(), (String) null, 10, (DefaultConstructorMarker) null);
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
                                                                KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to reserve and receive coupon: " + e.getMessage(), e);
                                                                return new ReserveAndReceiveResponse(Boxing.boxInt(-1), (Integer) null, "Failed to reserve and receive coupon: " + e.getMessage(), (String) null, 10, (DefaultConstructorMarker) null);
                                                            }
                                                        }
                                                    } catch (Exception e6) {
                                                        e$iv = e6;
                                                        KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                                        throw e$iv;
                                                    }
                                                } catch (Exception e7) {
                                                    e = e7;
                                                    KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to reserve and receive coupon: " + e.getMessage(), e);
                                                    return new ReserveAndReceiveResponse(Boxing.boxInt(-1), (Integer) null, "Failed to reserve and receive coupon: " + e.getMessage(), (String) null, 10, (DefaultConstructorMarker) null);
                                                }
                                            } catch (Exception e8) {
                                                e = e8;
                                            }
                                        } catch (Exception e9) {
                                            e = e9;
                                        }
                                    case 1:
                                        int i = reserveApiService$reserveAndReceiveCoupon$12.I$0;
                                        Map map3 = (Map) reserveApiService$reserveAndReceiveCoupon$12.L$7;
                                        Map map4 = (Map) reserveApiService$reserveAndReceiveCoupon$12.L$6;
                                        String str = (String) reserveApiService$reserveAndReceiveCoupon$12.L$5;
                                        String str2 = (String) reserveApiService$reserveAndReceiveCoupon$12.L$4;
                                        this_$iv = (Client) reserveApiService$reserveAndReceiveCoupon$12.L$3;
                                        Map map5 = (Map) reserveApiService$reserveAndReceiveCoupon$12.L$2;
                                        Map map6 = (Map) reserveApiService$reserveAndReceiveCoupon$12.L$1;
                                        String str3 = (String) reserveApiService$reserveAndReceiveCoupon$12.L$0;
                                        try {
                                            ResultKt.throwOnFailure($result);
                                            mallKntrAsyncRequest = $result;
                                            String jsonString$iv2 = (String) mallKntrAsyncRequest;
                                            Json this_$iv$iv2 = this_$iv.getJson();
                                            Intrinsics.checkNotNull(jsonString$iv2);
                                            this_$iv$iv2.getSerializersModule();
                                            Object res$iv2 = this_$iv$iv2.decodeFromString(ReserveAndReceiveResponse.Companion.serializer(), jsonString$iv2);
                                            return (ReserveAndReceiveResponse) res$iv2;
                                        } catch (Exception e10) {
                                            e$iv = e10;
                                            KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                            throw e$iv;
                                        }
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            }
                        }
                        reserveApiService$reserveAndReceiveCoupon$1 = new ReserveApiService$reserveAndReceiveCoupon$1(this, continuation);
                        reserveApiService$reserveAndReceiveCoupon$12 = reserveApiService$reserveAndReceiveCoupon$1;
                        Object $result2 = reserveApiService$reserveAndReceiveCoupon$12.result;
                        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (reserveApiService$reserveAndReceiveCoupon$12.label) {
                        }
                    }
                }