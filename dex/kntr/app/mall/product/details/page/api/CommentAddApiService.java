package kntr.app.mall.product.details.page.api;

import com.bilibili.mall.kmm.base.MallEnvKt;
import java.util.List;
import java.util.Map;
import kntr.app.mall.product.details.page.api.CommentAddApiService;
import kntr.app.mall.product.details.page.api.CommentInfoApiService;
import kntr.app.mall.product.details.page.utils.UserInfoKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.model.UserInfo;
import kntr.base.log.KLog_androidKt;
import kntr.common.upper.trace.config.AppKey;
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

/* compiled from: CommentAddApiService.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jd\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0080@¢\u0006\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentAddApiService;", "", "<init>", "()V", "API_URL_STRING", "", "addComment", "Lkntr/app/mall/product/details/page/api/CommentAddApiService$CommentAddResponse;", "subjectId", "", "subjectName", "subjectType", "", "content", "score", "shopId", "isAgreePub", "imgs", "addComment$product_details_page_debug", "(JLjava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CommentAddResponse", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CommentAddApiService {
    public static final int $stable = 0;
    private static final String API_URL_STRING = "https://mall.bilibili.com/mall-c/ugc/content/add";
    public static final CommentAddApiService INSTANCE = new CommentAddApiService();

    private CommentAddApiService() {
    }

    /* compiled from: CommentAddApiService.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0003-./B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBC\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0007HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u00060"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentAddApiService$CommentAddResponse;", "", "errtag", "", "code", "", "message", "", "data", "Lkntr/app/mall/product/details/page/api/CommentAddApiService$CommentAddResponse$CommentAddData;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/CommentAddApiService$CommentAddResponse$CommentAddData;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/CommentAddApiService$CommentAddResponse$CommentAddData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getErrtag", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMessage", "()Ljava/lang/String;", "getData", "()Lkntr/app/mall/product/details/page/api/CommentAddApiService$CommentAddResponse$CommentAddData;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/CommentAddApiService$CommentAddResponse$CommentAddData;)Lkntr/app/mall/product/details/page/api/CommentAddApiService$CommentAddResponse;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "CommentAddData", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CommentAddResponse {
        private final Long code;
        private final CommentAddData data;
        private final Integer errtag;
        private final String message;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public CommentAddResponse() {
            this((Integer) null, (Long) null, (String) null, (CommentAddData) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ CommentAddResponse copy$default(CommentAddResponse commentAddResponse, Integer num, Long l, String str, CommentAddData commentAddData, int i, Object obj) {
            if ((i & 1) != 0) {
                num = commentAddResponse.errtag;
            }
            if ((i & 2) != 0) {
                l = commentAddResponse.code;
            }
            if ((i & 4) != 0) {
                str = commentAddResponse.message;
            }
            if ((i & 8) != 0) {
                commentAddData = commentAddResponse.data;
            }
            return commentAddResponse.copy(num, l, str, commentAddData);
        }

        public final Integer component1() {
            return this.errtag;
        }

        public final Long component2() {
            return this.code;
        }

        public final String component3() {
            return this.message;
        }

        public final CommentAddData component4() {
            return this.data;
        }

        public final CommentAddResponse copy(Integer num, Long l, String str, CommentAddData commentAddData) {
            return new CommentAddResponse(num, l, str, commentAddData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CommentAddResponse) {
                CommentAddResponse commentAddResponse = (CommentAddResponse) obj;
                return Intrinsics.areEqual(this.errtag, commentAddResponse.errtag) && Intrinsics.areEqual(this.code, commentAddResponse.code) && Intrinsics.areEqual(this.message, commentAddResponse.message) && Intrinsics.areEqual(this.data, commentAddResponse.data);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.errtag == null ? 0 : this.errtag.hashCode()) * 31) + (this.code == null ? 0 : this.code.hashCode())) * 31) + (this.message == null ? 0 : this.message.hashCode())) * 31) + (this.data != null ? this.data.hashCode() : 0);
        }

        public String toString() {
            Integer num = this.errtag;
            Long l = this.code;
            String str = this.message;
            return "CommentAddResponse(errtag=" + num + ", code=" + l + ", message=" + str + ", data=" + this.data + ")";
        }

        /* compiled from: CommentAddApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentAddApiService$CommentAddResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CommentAddApiService$CommentAddResponse;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CommentAddResponse> serializer() {
                return new GeneratedSerializer<CommentAddResponse>() { // from class: kntr.app.mall.product.details.page.api.CommentAddApiService$CommentAddResponse$$serializer
                    public static final int $stable;
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.CommentAddApiService.CommentAddResponse", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.CommentAddApiService$CommentAddResponse> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.CommentAddApiService$CommentAddResponse> A[REMOVE]) =  kntr.app.mall.product.details.page.api.CommentAddApiService$CommentAddResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.CommentAddApiService$CommentAddResponse$$serializer)
                             in method: kntr.app.mall.product.details.page.api.CommentAddApiService.CommentAddResponse.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.CommentAddApiService$CommentAddResponse>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                              ("kntr.app.mall.product.details.page.api.CommentAddApiService.CommentAddResponse")
                              (wrap: kntr.app.mall.product.details.page.api.CommentAddApiService$CommentAddResponse$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.CommentAddApiService$CommentAddResponse$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.CommentAddApiService$CommentAddResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.CommentAddApiService$CommentAddResponse$$serializer)
                              (4 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.CommentAddApiService$CommentAddResponse$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.CommentAddApiService$CommentAddResponse$$serializer
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
                            kntr.app.mall.product.details.page.api.CommentAddApiService$CommentAddResponse$$serializer r0 = kntr.app.mall.product.details.page.api.CommentAddApiService$CommentAddResponse$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.CommentAddApiService.CommentAddResponse.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ CommentAddResponse(int seen0, Integer errtag, Long code, String message, CommentAddData data, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.errtag = null;
                    } else {
                        this.errtag = errtag;
                    }
                    if ((seen0 & 2) == 0) {
                        this.code = null;
                    } else {
                        this.code = code;
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

                public CommentAddResponse(Integer errtag, Long code, String message, CommentAddData data) {
                    this.errtag = errtag;
                    this.code = code;
                    this.message = message;
                    this.data = data;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(CommentAddResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.errtag != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.errtag);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.code != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.code);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.message != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.message);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.data != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, CommentAddApiService$CommentAddResponse$CommentAddData$$serializer.INSTANCE, self.data);
                    }
                }

                public /* synthetic */ CommentAddResponse(Integer num, Long l, String str, CommentAddData commentAddData, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : commentAddData);
                }

                public final Integer getErrtag() {
                    return this.errtag;
                }

                public final Long getCode() {
                    return this.code;
                }

                public final String getMessage() {
                    return this.message;
                }

                /* compiled from: CommentAddApiService.kt */
                @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-BC\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bBO\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003JJ\u0010\u001d\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\rHÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u0006."}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentAddApiService$CommentAddResponse$CommentAddData;", "", "comments", "", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel;", "ctime", "", "serverTime", "", "ugcIds", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getComments", "()Ljava/util/List;", "getCtime", "()Ljava/lang/String;", "getServerTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUgcIds", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;)Lkntr/app/mall/product/details/page/api/CommentAddApiService$CommentAddResponse$CommentAddData;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                @Serializable
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class CommentAddData {
                    private final List<CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel> comments;
                    private final String ctime;
                    private final Long serverTime;
                    private final List<Long> ugcIds;
                    public static final Companion Companion = new Companion(null);
                    public static final int $stable = 8;
                    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.CommentAddApiService$CommentAddResponse$CommentAddData$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            KSerializer _childSerializers$_anonymous_;
                            _childSerializers$_anonymous_ = CommentAddApiService.CommentAddResponse.CommentAddData._childSerializers$_anonymous_();
                            return _childSerializers$_anonymous_;
                        }
                    }), null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.CommentAddApiService$CommentAddResponse$CommentAddData$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            KSerializer _childSerializers$_anonymous_$0;
                            _childSerializers$_anonymous_$0 = CommentAddApiService.CommentAddResponse.CommentAddData._childSerializers$_anonymous_$0();
                            return _childSerializers$_anonymous_$0;
                        }
                    })};

                    public CommentAddData() {
                        this((List) null, (String) null, (Long) null, (List) null, 15, (DefaultConstructorMarker) null);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public static /* synthetic */ CommentAddData copy$default(CommentAddData commentAddData, List list, String str, Long l, List list2, int i, Object obj) {
                        if ((i & 1) != 0) {
                            list = commentAddData.comments;
                        }
                        if ((i & 2) != 0) {
                            str = commentAddData.ctime;
                        }
                        if ((i & 4) != 0) {
                            l = commentAddData.serverTime;
                        }
                        if ((i & 8) != 0) {
                            list2 = commentAddData.ugcIds;
                        }
                        return commentAddData.copy(list, str, l, list2);
                    }

                    public final List<CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel> component1() {
                        return this.comments;
                    }

                    public final String component2() {
                        return this.ctime;
                    }

                    public final Long component3() {
                        return this.serverTime;
                    }

                    public final List<Long> component4() {
                        return this.ugcIds;
                    }

                    public final CommentAddData copy(List<CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel> list, String str, Long l, List<Long> list2) {
                        return new CommentAddData(list, str, l, list2);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof CommentAddData) {
                            CommentAddData commentAddData = (CommentAddData) obj;
                            return Intrinsics.areEqual(this.comments, commentAddData.comments) && Intrinsics.areEqual(this.ctime, commentAddData.ctime) && Intrinsics.areEqual(this.serverTime, commentAddData.serverTime) && Intrinsics.areEqual(this.ugcIds, commentAddData.ugcIds);
                        }
                        return false;
                    }

                    public int hashCode() {
                        return ((((((this.comments == null ? 0 : this.comments.hashCode()) * 31) + (this.ctime == null ? 0 : this.ctime.hashCode())) * 31) + (this.serverTime == null ? 0 : this.serverTime.hashCode())) * 31) + (this.ugcIds != null ? this.ugcIds.hashCode() : 0);
                    }

                    public String toString() {
                        List<CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel> list = this.comments;
                        String str = this.ctime;
                        Long l = this.serverTime;
                        return "CommentAddData(comments=" + list + ", ctime=" + str + ", serverTime=" + l + ", ugcIds=" + this.ugcIds + ")";
                    }

                    /* compiled from: CommentAddApiService.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentAddApiService$CommentAddResponse$CommentAddData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CommentAddApiService$CommentAddResponse$CommentAddData;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<CommentAddData> serializer() {
                            return CommentAddApiService$CommentAddResponse$CommentAddData$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ CommentAddData(int seen0, List comments, String ctime, Long serverTime, List ugcIds, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((seen0 & 1) == 0) {
                            this.comments = null;
                        } else {
                            this.comments = comments;
                        }
                        if ((seen0 & 2) == 0) {
                            this.ctime = null;
                        } else {
                            this.ctime = ctime;
                        }
                        if ((seen0 & 4) == 0) {
                            this.serverTime = null;
                        } else {
                            this.serverTime = serverTime;
                        }
                        if ((seen0 & 8) == 0) {
                            this.ugcIds = null;
                        } else {
                            this.ugcIds = ugcIds;
                        }
                    }

                    public CommentAddData(List<CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel> list, String ctime, Long serverTime, List<Long> list2) {
                        this.comments = list;
                        this.ctime = ctime;
                        this.serverTime = serverTime;
                        this.ugcIds = list2;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                        return new ArrayListSerializer(CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$$serializer.INSTANCE);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                        return new ArrayListSerializer(LongSerializer.INSTANCE);
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$product_details_page_debug(CommentAddData self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.comments != null) {
                            output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.comments);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.ctime != null) {
                            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.ctime);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.serverTime != null) {
                            output.encodeNullableSerializableElement(serialDesc, 2, LongSerializer.INSTANCE, self.serverTime);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.ugcIds != null) {
                            output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.ugcIds);
                        }
                    }

                    public /* synthetic */ CommentAddData(List list, String str, Long l, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : list2);
                    }

                    public final List<CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel> getComments() {
                        return this.comments;
                    }

                    public final String getCtime() {
                        return this.ctime;
                    }

                    public final Long getServerTime() {
                        return this.serverTime;
                    }

                    public final List<Long> getUgcIds() {
                        return this.ugcIds;
                    }
                }

                public final CommentAddData getData() {
                    return this.data;
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x00ba  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object addComment$product_details_page_debug(long subjectId, String subjectName, int subjectType, String content, Integer score, Long shopId, Integer isAgreePub, String imgs, Continuation<? super CommentAddResponse> continuation) {
                CommentAddApiService$addComment$1 commentAddApiService$addComment$1;
                CommentAddApiService$addComment$1 commentAddApiService$addComment$12;
                long mid;
                Map params$iv;
                int $i$f$kntrRequest$product_details_page_debug;
                UserInfo userInfo;
                String method$iv;
                Client this_$iv;
                Object mallKntrAsyncRequest;
                Map params$iv2;
                if (continuation instanceof CommentAddApiService$addComment$1) {
                    commentAddApiService$addComment$1 = (CommentAddApiService$addComment$1) continuation;
                    if ((commentAddApiService$addComment$1.label & Integer.MIN_VALUE) != 0) {
                        commentAddApiService$addComment$1.label -= Integer.MIN_VALUE;
                        commentAddApiService$addComment$12 = commentAddApiService$addComment$1;
                        Object $result = commentAddApiService$addComment$12.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (commentAddApiService$addComment$12.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                UserInfo userInfo2 = UserInfoKt.getUserInfo();
                                Map comment = MapsKt.mapOf(new Pair[]{TuplesKt.to("subjectId", Boxing.boxLong(subjectId)), TuplesKt.to("subjectName", subjectName), TuplesKt.to("subjectType", Boxing.boxInt(subjectType)), TuplesKt.to("content", content), TuplesKt.to("score", score), TuplesKt.to("shopId", shopId), TuplesKt.to("isAgreePub", isAgreePub), TuplesKt.to("imgs", imgs)});
                                try {
                                    Client this_$iv2 = Client.INSTANCE;
                                    Pair[] pairArr = new Pair[5];
                                    pairArr[0] = TuplesKt.to("comments", CollectionsKt.listOf(comment));
                                    if (userInfo2 != null) {
                                        try {
                                            mid = userInfo2.getMid();
                                        } catch (Exception e) {
                                            return new CommentAddResponse((Integer) null, Boxing.boxLong(-1L), (String) null, (CommentAddResponse.CommentAddData) null, 13, (DefaultConstructorMarker) null);
                                        }
                                    } else {
                                        mid = 0;
                                    }
                                    pairArr[1] = TuplesKt.to("mid", Boxing.boxLong(mid));
                                    String name = userInfo2 != null ? userInfo2.getName() : null;
                                    if (name == null) {
                                        name = "";
                                    }
                                    pairArr[2] = TuplesKt.to("uname", name);
                                    pairArr[3] = TuplesKt.to("platform", Boxing.boxInt(3));
                                    pairArr[4] = TuplesKt.to(AppKey.VERSION, "1.0");
                                    params$iv = MapsKt.mapOf(pairArr);
                                    $i$f$kntrRequest$product_details_page_debug = 0;
                                    try {
                                        commentAddApiService$addComment$12.L$0 = SpillingKt.nullOutSpilledVariable(subjectName);
                                        commentAddApiService$addComment$12.L$1 = SpillingKt.nullOutSpilledVariable(content);
                                        commentAddApiService$addComment$12.L$2 = SpillingKt.nullOutSpilledVariable(score);
                                        commentAddApiService$addComment$12.L$3 = SpillingKt.nullOutSpilledVariable(shopId);
                                        commentAddApiService$addComment$12.L$4 = SpillingKt.nullOutSpilledVariable(isAgreePub);
                                        commentAddApiService$addComment$12.L$5 = SpillingKt.nullOutSpilledVariable(imgs);
                                        commentAddApiService$addComment$12.L$6 = SpillingKt.nullOutSpilledVariable(userInfo2);
                                        commentAddApiService$addComment$12.L$7 = SpillingKt.nullOutSpilledVariable(comment);
                                        commentAddApiService$addComment$12.L$8 = this_$iv2;
                                        commentAddApiService$addComment$12.L$9 = SpillingKt.nullOutSpilledVariable(API_URL_STRING);
                                        commentAddApiService$addComment$12.L$10 = SpillingKt.nullOutSpilledVariable("POST");
                                        commentAddApiService$addComment$12.L$11 = SpillingKt.nullOutSpilledVariable(params$iv);
                                        this_$iv = this_$iv2;
                                        try {
                                            commentAddApiService$addComment$12.J$0 = subjectId;
                                        } catch (Exception e2) {
                                            e$iv = e2;
                                        }
                                    } catch (Exception e3) {
                                        e$iv = e3;
                                        userInfo = userInfo2;
                                        method$iv = null;
                                    }
                                    try {
                                        commentAddApiService$addComment$12.I$0 = subjectType;
                                        commentAddApiService$addComment$12.I$1 = 0;
                                        commentAddApiService$addComment$12.label = 1;
                                        mallKntrAsyncRequest = MallEnvKt.mallKntrAsyncRequest(API_URL_STRING, "POST", (Map) null, params$iv, commentAddApiService$addComment$12);
                                        if (mallKntrAsyncRequest == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        userInfo = userInfo2;
                                        method$iv = null;
                                        try {
                                            String jsonString$iv = (String) mallKntrAsyncRequest;
                                            Json this_$iv$iv = this_$iv.getJson();
                                            Intrinsics.checkNotNull(jsonString$iv);
                                            this_$iv$iv.getSerializersModule();
                                            params$iv2 = params$iv;
                                        } catch (Exception e4) {
                                            e$iv = e4;
                                        }
                                        try {
                                            Object res$iv = this_$iv$iv.decodeFromString(CommentAddResponse.Companion.serializer(), jsonString$iv);
                                            return res$iv;
                                        } catch (Exception e5) {
                                            e$iv = e5;
                                            params$iv = params$iv2;
                                            try {
                                                KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                                throw e$iv;
                                            } catch (Exception e6) {
                                                return new CommentAddResponse((Integer) null, Boxing.boxLong(-1L), (String) null, (CommentAddResponse.CommentAddData) null, 13, (DefaultConstructorMarker) null);
                                            }
                                        }
                                    } catch (Exception e7) {
                                        e$iv = e7;
                                        userInfo = userInfo2;
                                        method$iv = null;
                                        KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                        throw e$iv;
                                    }
                                } catch (Exception e8) {
                                }
                            case 1:
                                int $i$f$kntrRequest$product_details_page_debug2 = commentAddApiService$addComment$12.I$1;
                                int i = commentAddApiService$addComment$12.I$0;
                                long j = commentAddApiService$addComment$12.J$0;
                                Map params$iv3 = (Map) commentAddApiService$addComment$12.L$11;
                                String str = (String) commentAddApiService$addComment$12.L$10;
                                String str2 = (String) commentAddApiService$addComment$12.L$9;
                                Client this_$iv3 = (Client) commentAddApiService$addComment$12.L$8;
                                Map map = (Map) commentAddApiService$addComment$12.L$7;
                                UserInfo userInfo3 = (UserInfo) commentAddApiService$addComment$12.L$6;
                                String str3 = (String) commentAddApiService$addComment$12.L$5;
                                Integer num = (Integer) commentAddApiService$addComment$12.L$4;
                                Long l = (Long) commentAddApiService$addComment$12.L$3;
                                Integer num2 = (Integer) commentAddApiService$addComment$12.L$2;
                                String str4 = (String) commentAddApiService$addComment$12.L$1;
                                String str5 = (String) commentAddApiService$addComment$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    params$iv = params$iv3;
                                    method$iv = null;
                                    this_$iv = this_$iv3;
                                    userInfo = userInfo3;
                                    $i$f$kntrRequest$product_details_page_debug = $i$f$kntrRequest$product_details_page_debug2;
                                    mallKntrAsyncRequest = $result;
                                    String jsonString$iv2 = (String) mallKntrAsyncRequest;
                                    Json this_$iv$iv2 = this_$iv.getJson();
                                    Intrinsics.checkNotNull(jsonString$iv2);
                                    this_$iv$iv2.getSerializersModule();
                                    params$iv2 = params$iv;
                                    Object res$iv2 = this_$iv$iv2.decodeFromString(CommentAddResponse.Companion.serializer(), jsonString$iv2);
                                    return res$iv2;
                                } catch (Exception e9) {
                                    e$iv = e9;
                                    params$iv = params$iv3;
                                    method$iv = null;
                                    $i$f$kntrRequest$product_details_page_debug = $i$f$kntrRequest$product_details_page_debug2;
                                    userInfo = userInfo3;
                                    KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                    throw e$iv;
                                }
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
                commentAddApiService$addComment$1 = new CommentAddApiService$addComment$1(this, continuation);
                commentAddApiService$addComment$12 = commentAddApiService$addComment$1;
                Object $result2 = commentAddApiService$addComment$12.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (commentAddApiService$addComment$12.label) {
                }
            }
        }