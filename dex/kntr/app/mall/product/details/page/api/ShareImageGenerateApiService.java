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
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ShareImageGenerateApiService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\f\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0080@¢\u0006\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService;", "", "<init>", "()V", "API_URL_STRING", "", "requestGenerateShareImage", "Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$Response;", "params", "Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams;", "requestGenerateShareImage$product_details_page_debug", "(Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "RequestParams", "Response", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareImageGenerateApiService {
    public static final int $stable = 0;
    private static final String API_URL_STRING = "https://mall.bilibili.com/mall-dayu/kfptfe/watermark/external/share/baseImgShareV3";
    public static final ShareImageGenerateApiService INSTANCE = new ShareImageGenerateApiService();

    private ShareImageGenerateApiService() {
    }

    /* compiled from: ShareImageGenerateApiService.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0004)*+,B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006-"}, d2 = {"Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams;", "", "templateName", "", "uniqueId", "params", "Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Params;", "map", "Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Map;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Params;Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Params;Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTemplateName", "()Ljava/lang/String;", "getUniqueId", "getParams", "()Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Params;", "getMap", "()Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "Params", "Map", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class RequestParams {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final Map map;
        private final Params params;
        private final String templateName;
        private final String uniqueId;

        public RequestParams() {
            this((String) null, (String) null, (Params) null, (Map) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ RequestParams copy$default(RequestParams requestParams, String str, String str2, Params params, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = requestParams.templateName;
            }
            if ((i & 2) != 0) {
                str2 = requestParams.uniqueId;
            }
            if ((i & 4) != 0) {
                params = requestParams.params;
            }
            if ((i & 8) != 0) {
                map = requestParams.map;
            }
            return requestParams.copy(str, str2, params, map);
        }

        public final String component1() {
            return this.templateName;
        }

        public final String component2() {
            return this.uniqueId;
        }

        public final Params component3() {
            return this.params;
        }

        public final Map component4() {
            return this.map;
        }

        public final RequestParams copy(String str, String str2, Params params, Map map) {
            Intrinsics.checkNotNullParameter(str, "templateName");
            Intrinsics.checkNotNullParameter(str2, "uniqueId");
            return new RequestParams(str, str2, params, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RequestParams) {
                RequestParams requestParams = (RequestParams) obj;
                return Intrinsics.areEqual(this.templateName, requestParams.templateName) && Intrinsics.areEqual(this.uniqueId, requestParams.uniqueId) && Intrinsics.areEqual(this.params, requestParams.params) && Intrinsics.areEqual(this.map, requestParams.map);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.templateName.hashCode() * 31) + this.uniqueId.hashCode()) * 31) + (this.params == null ? 0 : this.params.hashCode())) * 31) + (this.map != null ? this.map.hashCode() : 0);
        }

        public String toString() {
            String str = this.templateName;
            String str2 = this.uniqueId;
            Params params = this.params;
            return "RequestParams(templateName=" + str + ", uniqueId=" + str2 + ", params=" + params + ", map=" + this.map + ")";
        }

        /* compiled from: ShareImageGenerateApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<RequestParams> serializer() {
                return new GeneratedSerializer<RequestParams>() { // from class: kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$RequestParams$$serializer
                    public static final int $stable;
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.ShareImageGenerateApiService.RequestParams", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$RequestParams> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$RequestParams> A[REMOVE]) =  kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$RequestParams$$serializer.INSTANCE kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$RequestParams$$serializer)
                             in method: kntr.app.mall.product.details.page.api.ShareImageGenerateApiService.RequestParams.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$RequestParams>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                              ("kntr.app.mall.product.details.page.api.ShareImageGenerateApiService.RequestParams")
                              (wrap: kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$RequestParams$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$RequestParams$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$RequestParams$$serializer.INSTANCE kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$RequestParams$$serializer)
                              (4 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$RequestParams$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$RequestParams$$serializer
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
                            kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$RequestParams$$serializer r0 = kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$RequestParams$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.ShareImageGenerateApiService.RequestParams.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ RequestParams(int seen0, String templateName, String uniqueId, Params params, Map map, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.templateName = "merchantShare";
                    } else {
                        this.templateName = templateName;
                    }
                    if ((seen0 & 2) == 0) {
                        this.uniqueId = "merchantShare";
                    } else {
                        this.uniqueId = uniqueId;
                    }
                    if ((seen0 & 4) == 0) {
                        this.params = null;
                    } else {
                        this.params = params;
                    }
                    if ((seen0 & 8) == 0) {
                        this.map = null;
                    } else {
                        this.map = map;
                    }
                }

                public RequestParams(String templateName, String uniqueId, Params params, Map map) {
                    Intrinsics.checkNotNullParameter(templateName, "templateName");
                    Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
                    this.templateName = templateName;
                    this.uniqueId = uniqueId;
                    this.params = params;
                    this.map = map;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(RequestParams self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.templateName, "merchantShare")) {
                        output.encodeStringElement(serialDesc, 0, self.templateName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.uniqueId, "merchantShare")) {
                        output.encodeStringElement(serialDesc, 1, self.uniqueId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.params != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, ShareImageGenerateApiService$RequestParams$Params$$serializer.INSTANCE, self.params);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.map != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, ShareImageGenerateApiService$RequestParams$Map$$serializer.INSTANCE, self.map);
                    }
                }

                public /* synthetic */ RequestParams(String str, String str2, Params params, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? "merchantShare" : str, (i & 2) != 0 ? "merchantShare" : str2, (i & 4) != 0 ? null : params, (i & 8) != 0 ? null : map);
                }

                public final String getTemplateName() {
                    return this.templateName;
                }

                public final String getUniqueId() {
                    return this.uniqueId;
                }

                public final Params getParams() {
                    return this.params;
                }

                /* compiled from: ShareImageGenerateApiService.kt */
                @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0003\u001d\u001e\u001fB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0001¢\u0006\u0002\b\u001cR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Params;", "", "shareQuery", "Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Params$ShareQuery;", "<init>", "(Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Params$ShareQuery;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Params$ShareQuery;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getShareQuery", "()Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Params$ShareQuery;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ShareQuery", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                @Serializable
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Params {
                    public static final int $stable = 0;
                    public static final Companion Companion = new Companion(null);
                    private final ShareQuery shareQuery;

                    public Params() {
                        this((ShareQuery) null, 1, (DefaultConstructorMarker) null);
                    }

                    public static /* synthetic */ Params copy$default(Params params, ShareQuery shareQuery, int i, Object obj) {
                        if ((i & 1) != 0) {
                            shareQuery = params.shareQuery;
                        }
                        return params.copy(shareQuery);
                    }

                    public final ShareQuery component1() {
                        return this.shareQuery;
                    }

                    public final Params copy(ShareQuery shareQuery) {
                        return new Params(shareQuery);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return (obj instanceof Params) && Intrinsics.areEqual(this.shareQuery, ((Params) obj).shareQuery);
                    }

                    public int hashCode() {
                        if (this.shareQuery == null) {
                            return 0;
                        }
                        return this.shareQuery.hashCode();
                    }

                    public String toString() {
                        return "Params(shareQuery=" + this.shareQuery + ")";
                    }

                    /* compiled from: ShareImageGenerateApiService.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Params$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Params;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<Params> serializer() {
                            return ShareImageGenerateApiService$RequestParams$Params$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ Params(int seen0, ShareQuery shareQuery, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((seen0 & 1) == 0) {
                            this.shareQuery = null;
                        } else {
                            this.shareQuery = shareQuery;
                        }
                    }

                    public Params(ShareQuery shareQuery) {
                        this.shareQuery = shareQuery;
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$product_details_page_debug(Params self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        boolean z = true;
                        if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.shareQuery == null) {
                            z = false;
                        }
                        if (z) {
                            output.encodeNullableSerializableElement(serialDesc, 0, ShareImageGenerateApiService$RequestParams$Params$ShareQuery$$serializer.INSTANCE, self.shareQuery);
                        }
                    }

                    public /* synthetic */ Params(ShareQuery shareQuery, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : shareQuery);
                    }

                    /* compiled from: ShareImageGenerateApiService.kt */
                    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J2\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0002\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006)"}, d2 = {"Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Params$ShareQuery;", "", "isMerchant", "", "itemsId", "", "merchantId", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getItemsId", "()Ljava/lang/String;", "getMerchantId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Params$ShareQuery;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    @Serializable
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class ShareQuery {
                        public static final int $stable = 0;
                        public static final Companion Companion = new Companion(null);
                        private final Integer isMerchant;
                        private final String itemsId;
                        private final Long merchantId;

                        public ShareQuery() {
                            this((Integer) null, (String) null, (Long) null, 7, (DefaultConstructorMarker) null);
                        }

                        public static /* synthetic */ ShareQuery copy$default(ShareQuery shareQuery, Integer num, String str, Long l, int i, Object obj) {
                            if ((i & 1) != 0) {
                                num = shareQuery.isMerchant;
                            }
                            if ((i & 2) != 0) {
                                str = shareQuery.itemsId;
                            }
                            if ((i & 4) != 0) {
                                l = shareQuery.merchantId;
                            }
                            return shareQuery.copy(num, str, l);
                        }

                        public final Integer component1() {
                            return this.isMerchant;
                        }

                        public final String component2() {
                            return this.itemsId;
                        }

                        public final Long component3() {
                            return this.merchantId;
                        }

                        public final ShareQuery copy(Integer num, String str, Long l) {
                            return new ShareQuery(num, str, l);
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj instanceof ShareQuery) {
                                ShareQuery shareQuery = (ShareQuery) obj;
                                return Intrinsics.areEqual(this.isMerchant, shareQuery.isMerchant) && Intrinsics.areEqual(this.itemsId, shareQuery.itemsId) && Intrinsics.areEqual(this.merchantId, shareQuery.merchantId);
                            }
                            return false;
                        }

                        public int hashCode() {
                            return ((((this.isMerchant == null ? 0 : this.isMerchant.hashCode()) * 31) + (this.itemsId == null ? 0 : this.itemsId.hashCode())) * 31) + (this.merchantId != null ? this.merchantId.hashCode() : 0);
                        }

                        public String toString() {
                            Integer num = this.isMerchant;
                            String str = this.itemsId;
                            return "ShareQuery(isMerchant=" + num + ", itemsId=" + str + ", merchantId=" + this.merchantId + ")";
                        }

                        /* compiled from: ShareImageGenerateApiService.kt */
                        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Params$ShareQuery$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Params$ShareQuery;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class Companion {
                            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                this();
                            }

                            private Companion() {
                            }

                            public final KSerializer<ShareQuery> serializer() {
                                return ShareImageGenerateApiService$RequestParams$Params$ShareQuery$$serializer.INSTANCE;
                            }
                        }

                        public /* synthetic */ ShareQuery(int seen0, Integer isMerchant, String itemsId, Long merchantId, SerializationConstructorMarker serializationConstructorMarker) {
                            if ((seen0 & 1) == 0) {
                                this.isMerchant = 1;
                            } else {
                                this.isMerchant = isMerchant;
                            }
                            if ((seen0 & 2) == 0) {
                                this.itemsId = null;
                            } else {
                                this.itemsId = itemsId;
                            }
                            if ((seen0 & 4) == 0) {
                                this.merchantId = null;
                            } else {
                                this.merchantId = merchantId;
                            }
                        }

                        public ShareQuery(Integer isMerchant, String itemsId, Long merchantId) {
                            this.isMerchant = isMerchant;
                            this.itemsId = itemsId;
                            this.merchantId = merchantId;
                        }

                        @JvmStatic
                        public static final /* synthetic */ void write$Self$product_details_page_debug(ShareQuery self, CompositeEncoder output, SerialDescriptor serialDesc) {
                            Integer num;
                            if (output.shouldEncodeElementDefault(serialDesc, 0) || (num = self.isMerchant) == null || num.intValue() != 1) {
                                output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.isMerchant);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.itemsId != null) {
                                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.itemsId);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.merchantId != null) {
                                output.encodeNullableSerializableElement(serialDesc, 2, LongSerializer.INSTANCE, self.merchantId);
                            }
                        }

                        public /* synthetic */ ShareQuery(Integer num, String str, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
                            this((i & 1) != 0 ? 1 : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : l);
                        }

                        public final Integer isMerchant() {
                            return this.isMerchant;
                        }

                        public final String getItemsId() {
                            return this.itemsId;
                        }

                        public final Long getMerchantId() {
                            return this.merchantId;
                        }
                    }

                    public final ShareQuery getShareQuery() {
                        return this.shareQuery;
                    }
                }

                public final Map getMap() {
                    return this.map;
                }

                /* compiled from: ShareImageGenerateApiService.kt */
                @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0002\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006%"}, d2 = {"Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Map;", "", "isMerchant", "", "share_mid", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShare_mid", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;)Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Map;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                @Serializable
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Map {
                    public static final int $stable = 0;
                    public static final Companion Companion = new Companion(null);
                    private final Integer isMerchant;
                    private final Long share_mid;

                    public Map() {
                        this((Integer) null, (Long) null, 3, (DefaultConstructorMarker) null);
                    }

                    public static /* synthetic */ Map copy$default(Map map, Integer num, Long l, int i, Object obj) {
                        if ((i & 1) != 0) {
                            num = map.isMerchant;
                        }
                        if ((i & 2) != 0) {
                            l = map.share_mid;
                        }
                        return map.copy(num, l);
                    }

                    public final Integer component1() {
                        return this.isMerchant;
                    }

                    public final Long component2() {
                        return this.share_mid;
                    }

                    public final Map copy(Integer num, Long l) {
                        return new Map(num, l);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof Map) {
                            Map map = (Map) obj;
                            return Intrinsics.areEqual(this.isMerchant, map.isMerchant) && Intrinsics.areEqual(this.share_mid, map.share_mid);
                        }
                        return false;
                    }

                    public int hashCode() {
                        return ((this.isMerchant == null ? 0 : this.isMerchant.hashCode()) * 31) + (this.share_mid != null ? this.share_mid.hashCode() : 0);
                    }

                    public String toString() {
                        Integer num = this.isMerchant;
                        return "Map(isMerchant=" + num + ", share_mid=" + this.share_mid + ")";
                    }

                    /* compiled from: ShareImageGenerateApiService.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Map$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$RequestParams$Map;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<Map> serializer() {
                            return ShareImageGenerateApiService$RequestParams$Map$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ Map(int seen0, Integer isMerchant, Long share_mid, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((seen0 & 1) == 0) {
                            this.isMerchant = 1;
                        } else {
                            this.isMerchant = isMerchant;
                        }
                        if ((seen0 & 2) == 0) {
                            this.share_mid = null;
                        } else {
                            this.share_mid = share_mid;
                        }
                    }

                    public Map(Integer isMerchant, Long share_mid) {
                        this.isMerchant = isMerchant;
                        this.share_mid = share_mid;
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$product_details_page_debug(Map self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        Integer num;
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || (num = self.isMerchant) == null || num.intValue() != 1) {
                            output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.isMerchant);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.share_mid != null) {
                            output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.share_mid);
                        }
                    }

                    public /* synthetic */ Map(Integer num, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? 1 : num, (i & 2) != 0 ? null : l);
                    }

                    public final Integer isMerchant() {
                        return this.isMerchant;
                    }

                    public final Long getShare_mid() {
                        return this.share_mid;
                    }
                }
            }

            /* compiled from: ShareImageGenerateApiService.kt */
            @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0003-./BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003JJ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u00060"}, d2 = {"Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$Response;", "", "code", "", "errtag", "message", "", "msg", "data", "Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$Response$Data;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$Response$Data;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$Response$Data;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrtag", "getMessage", "()Ljava/lang/String;", "getMsg", "getData", "()Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$Response$Data;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$Response$Data;)Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$Response;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "Data", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Response {
                public static final int $stable = 0;
                public static final Companion Companion = new Companion(null);
                private final Integer code;
                private final Data data;
                private final Integer errtag;
                private final String message;
                private final String msg;

                public Response() {
                    this((Integer) null, (Integer) null, (String) null, (String) null, (Data) null, 31, (DefaultConstructorMarker) null);
                }

                public static /* synthetic */ Response copy$default(Response response, Integer num, Integer num2, String str, String str2, Data data, int i, Object obj) {
                    if ((i & 1) != 0) {
                        num = response.code;
                    }
                    if ((i & 2) != 0) {
                        num2 = response.errtag;
                    }
                    Integer num3 = num2;
                    if ((i & 4) != 0) {
                        str = response.message;
                    }
                    String str3 = str;
                    if ((i & 8) != 0) {
                        str2 = response.msg;
                    }
                    String str4 = str2;
                    if ((i & 16) != 0) {
                        data = response.data;
                    }
                    return response.copy(num, num3, str3, str4, data);
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
                    return this.msg;
                }

                public final Data component5() {
                    return this.data;
                }

                public final Response copy(Integer num, Integer num2, String str, String str2, Data data) {
                    return new Response(num, num2, str, str2, data);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof Response) {
                        Response response = (Response) obj;
                        return Intrinsics.areEqual(this.code, response.code) && Intrinsics.areEqual(this.errtag, response.errtag) && Intrinsics.areEqual(this.message, response.message) && Intrinsics.areEqual(this.msg, response.msg) && Intrinsics.areEqual(this.data, response.data);
                    }
                    return false;
                }

                public int hashCode() {
                    return ((((((((this.code == null ? 0 : this.code.hashCode()) * 31) + (this.errtag == null ? 0 : this.errtag.hashCode())) * 31) + (this.message == null ? 0 : this.message.hashCode())) * 31) + (this.msg == null ? 0 : this.msg.hashCode())) * 31) + (this.data != null ? this.data.hashCode() : 0);
                }

                public String toString() {
                    Integer num = this.code;
                    Integer num2 = this.errtag;
                    String str = this.message;
                    String str2 = this.msg;
                    return "Response(code=" + num + ", errtag=" + num2 + ", message=" + str + ", msg=" + str2 + ", data=" + this.data + ")";
                }

                /* compiled from: ShareImageGenerateApiService.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$Response$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$Response;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<Response> serializer() {
                        return new GeneratedSerializer<Response>() { // from class: kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$Response$$serializer
                            public static final int $stable;
                            private static final SerialDescriptor descriptor;

                            public final SerialDescriptor getDescriptor() {
                                return descriptor;
                            }

                            static {
                                SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.ShareImageGenerateApiService.Response", 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                                      (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$Response> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$Response> A[REMOVE]) =  kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$Response$$serializer.INSTANCE kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$Response$$serializer)
                                     in method: kntr.app.mall.product.details.page.api.ShareImageGenerateApiService.Response.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$Response>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                                      ("kntr.app.mall.product.details.page.api.ShareImageGenerateApiService.Response")
                                      (wrap: kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$Response$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$Response$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$Response$$serializer.INSTANCE kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$Response$$serializer)
                                      (5 int)
                                     call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$Response$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$Response$$serializer
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
                                    kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$Response$$serializer r0 = kntr.app.mall.product.details.page.api.ShareImageGenerateApiService$Response$$serializer.INSTANCE
                                    kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                                    return r0
                                */
                                throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.ShareImageGenerateApiService.Response.Companion.serializer():kotlinx.serialization.KSerializer");
                            }
                        }

                        public /* synthetic */ Response(int seen0, Integer code, Integer errtag, String message, String msg, Data data, SerializationConstructorMarker serializationConstructorMarker) {
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
                                this.msg = "";
                            } else {
                                this.msg = msg;
                            }
                            if ((seen0 & 16) == 0) {
                                this.data = null;
                            } else {
                                this.data = data;
                            }
                        }

                        public Response(Integer code, Integer errtag, String message, String msg, Data data) {
                            this.code = code;
                            this.errtag = errtag;
                            this.message = message;
                            this.msg = msg;
                            this.data = data;
                        }

                        @JvmStatic
                        public static final /* synthetic */ void write$Self$product_details_page_debug(Response self, CompositeEncoder output, SerialDescriptor serialDesc) {
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
                            if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.msg, "")) {
                                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.msg);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.data != null) {
                                output.encodeNullableSerializableElement(serialDesc, 4, ShareImageGenerateApiService$Response$Data$$serializer.INSTANCE, self.data);
                            }
                        }

                        /* JADX WARN: Illegal instructions before constructor call */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public /* synthetic */ Response(Integer num, Integer num2, String str, String str2, Data data, int i, DefaultConstructorMarker defaultConstructorMarker) {
                            this((i & 1) != 0 ? r0 : num, (i & 2) == 0 ? num2 : 0, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? null : data);
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

                        public final String getMsg() {
                            return this.msg;
                        }

                        /* compiled from: ShareImageGenerateApiService.kt */
                        @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J>\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\fHÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011¨\u0006-"}, d2 = {"Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$Response$Data;", "", "height", "", "recognitionHasBadCase", "", "url", "", "width", "<init>", "(Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Double;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Double;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Double;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getHeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getRecognitionHasBadCase", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUrl", "()Ljava/lang/String;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Double;)Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$Response$Data;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        @Serializable
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class Data {
                            public static final int $stable = 0;
                            public static final Companion Companion = new Companion(null);
                            private final Double height;
                            private final Boolean recognitionHasBadCase;
                            private final String url;
                            private final Double width;

                            public Data() {
                                this((Double) null, (Boolean) null, (String) null, (Double) null, 15, (DefaultConstructorMarker) null);
                            }

                            public static /* synthetic */ Data copy$default(Data data, Double d, Boolean bool, String str, Double d2, int i, Object obj) {
                                if ((i & 1) != 0) {
                                    d = data.height;
                                }
                                if ((i & 2) != 0) {
                                    bool = data.recognitionHasBadCase;
                                }
                                if ((i & 4) != 0) {
                                    str = data.url;
                                }
                                if ((i & 8) != 0) {
                                    d2 = data.width;
                                }
                                return data.copy(d, bool, str, d2);
                            }

                            public final Double component1() {
                                return this.height;
                            }

                            public final Boolean component2() {
                                return this.recognitionHasBadCase;
                            }

                            public final String component3() {
                                return this.url;
                            }

                            public final Double component4() {
                                return this.width;
                            }

                            public final Data copy(Double d, Boolean bool, String str, Double d2) {
                                return new Data(d, bool, str, d2);
                            }

                            public boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj instanceof Data) {
                                    Data data = (Data) obj;
                                    return Intrinsics.areEqual(this.height, data.height) && Intrinsics.areEqual(this.recognitionHasBadCase, data.recognitionHasBadCase) && Intrinsics.areEqual(this.url, data.url) && Intrinsics.areEqual(this.width, data.width);
                                }
                                return false;
                            }

                            public int hashCode() {
                                return ((((((this.height == null ? 0 : this.height.hashCode()) * 31) + (this.recognitionHasBadCase == null ? 0 : this.recognitionHasBadCase.hashCode())) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.width != null ? this.width.hashCode() : 0);
                            }

                            public String toString() {
                                Double d = this.height;
                                Boolean bool = this.recognitionHasBadCase;
                                String str = this.url;
                                return "Data(height=" + d + ", recognitionHasBadCase=" + bool + ", url=" + str + ", width=" + this.width + ")";
                            }

                            /* compiled from: ShareImageGenerateApiService.kt */
                            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$Response$Data$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ShareImageGenerateApiService$Response$Data;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                            public static final class Companion {
                                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                    this();
                                }

                                private Companion() {
                                }

                                public final KSerializer<Data> serializer() {
                                    return ShareImageGenerateApiService$Response$Data$$serializer.INSTANCE;
                                }
                            }

                            public /* synthetic */ Data(int seen0, Double height, Boolean recognitionHasBadCase, String url, Double width, SerializationConstructorMarker serializationConstructorMarker) {
                                if ((seen0 & 1) == 0) {
                                    this.height = null;
                                } else {
                                    this.height = height;
                                }
                                if ((seen0 & 2) == 0) {
                                    this.recognitionHasBadCase = null;
                                } else {
                                    this.recognitionHasBadCase = recognitionHasBadCase;
                                }
                                if ((seen0 & 4) == 0) {
                                    this.url = null;
                                } else {
                                    this.url = url;
                                }
                                if ((seen0 & 8) == 0) {
                                    this.width = null;
                                } else {
                                    this.width = width;
                                }
                            }

                            public Data(Double height, Boolean recognitionHasBadCase, String url, Double width) {
                                this.height = height;
                                this.recognitionHasBadCase = recognitionHasBadCase;
                                this.url = url;
                                this.width = width;
                            }

                            @JvmStatic
                            public static final /* synthetic */ void write$Self$product_details_page_debug(Data self, CompositeEncoder output, SerialDescriptor serialDesc) {
                                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.height != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 0, DoubleSerializer.INSTANCE, self.height);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.recognitionHasBadCase != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.recognitionHasBadCase);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.url != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.url);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.width != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 3, DoubleSerializer.INSTANCE, self.width);
                                }
                            }

                            public /* synthetic */ Data(Double d, Boolean bool, String str, Double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                                this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : d2);
                            }

                            public final Double getHeight() {
                                return this.height;
                            }

                            public final Boolean getRecognitionHasBadCase() {
                                return this.recognitionHasBadCase;
                            }

                            public final String getUrl() {
                                return this.url;
                            }

                            public final Double getWidth() {
                                return this.width;
                            }
                        }

                        public final Data getData() {
                            return this.data;
                        }
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
                    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
                    /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
                    /* JADX WARN: Removed duplicated region for block: B:22:0x008c  */
                    /* JADX WARN: Removed duplicated region for block: B:53:0x0188 A[Catch: Exception -> 0x020a, TryCatch #4 {Exception -> 0x020a, blocks: (B:67:0x01fd, B:69:0x0201, B:70:0x0209, B:51:0x0175, B:53:0x0188, B:55:0x01b5, B:62:0x01ce), top: B:87:0x0175 }] */
                    /* JADX WARN: Removed duplicated region for block: B:55:0x01b5 A[Catch: Exception -> 0x020a, TRY_LEAVE, TryCatch #4 {Exception -> 0x020a, blocks: (B:67:0x01fd, B:69:0x0201, B:70:0x0209, B:51:0x0175, B:53:0x0188, B:55:0x01b5, B:62:0x01ce), top: B:87:0x0175 }] */
                    /* JADX WARN: Removed duplicated region for block: B:67:0x01fd A[Catch: Exception -> 0x020a, TryCatch #4 {Exception -> 0x020a, blocks: (B:67:0x01fd, B:69:0x0201, B:70:0x0209, B:51:0x0175, B:53:0x0188, B:55:0x01b5, B:62:0x01ce), top: B:87:0x0175 }] */
                    /* JADX WARN: Removed duplicated region for block: B:69:0x0201 A[Catch: Exception -> 0x020a, TryCatch #4 {Exception -> 0x020a, blocks: (B:67:0x01fd, B:69:0x0201, B:70:0x0209, B:51:0x0175, B:53:0x0188, B:55:0x01b5, B:62:0x01ce), top: B:87:0x0175 }] */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object requestGenerateShareImage$product_details_page_debug(RequestParams params, Continuation<? super Response> continuation) {
                        ShareImageGenerateApiService$requestGenerateShareImage$1 shareImageGenerateApiService$requestGenerateShareImage$1;
                        ShareImageGenerateApiService$requestGenerateShareImage$1 shareImageGenerateApiService$requestGenerateShareImage$12;
                        HttpClient $this$post$iv;
                        HttpMessageBuilder httpRequestBuilder;
                        KType kType;
                        Object execute;
                        RequestParams params2;
                        KType kType2;
                        HttpResponse response;
                        KType kType3;
                        Object bodyNullable;
                        if (continuation instanceof ShareImageGenerateApiService$requestGenerateShareImage$1) {
                            shareImageGenerateApiService$requestGenerateShareImage$1 = (ShareImageGenerateApiService$requestGenerateShareImage$1) continuation;
                            if ((shareImageGenerateApiService$requestGenerateShareImage$1.label & Integer.MIN_VALUE) != 0) {
                                shareImageGenerateApiService$requestGenerateShareImage$1.label -= Integer.MIN_VALUE;
                                shareImageGenerateApiService$requestGenerateShareImage$12 = shareImageGenerateApiService$requestGenerateShareImage$1;
                                Object $result = shareImageGenerateApiService$requestGenerateShareImage$12.result;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (shareImageGenerateApiService$requestGenerateShareImage$12.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        try {
                                            $this$post$iv = Client.INSTANCE.getHttpClient();
                                            httpRequestBuilder = new HttpRequestBuilder();
                                            HttpRequestKt.url(httpRequestBuilder, API_URL_STRING);
                                            HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
                                        } catch (Exception e) {
                                            e = e;
                                        }
                                        try {
                                            if (params == null) {
                                                httpRequestBuilder.setBody(NullBody.INSTANCE);
                                                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(RequestParams.class);
                                                try {
                                                    kType2 = Reflection.typeOf(RequestParams.class);
                                                } catch (Throwable th) {
                                                    kType2 = null;
                                                }
                                                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType2));
                                            } else if (params instanceof OutgoingContent) {
                                                httpRequestBuilder.setBody(params);
                                                httpRequestBuilder.setBodyType((TypeInfo) null);
                                            } else {
                                                httpRequestBuilder.setBody(params);
                                                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(RequestParams.class);
                                                try {
                                                    kType = Reflection.typeOf(RequestParams.class);
                                                } catch (Throwable th2) {
                                                    kType = null;
                                                }
                                                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass2, kType));
                                            }
                                            httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
                                            HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, $this$post$iv);
                                            shareImageGenerateApiService$requestGenerateShareImage$12.L$0 = SpillingKt.nullOutSpilledVariable(params);
                                            shareImageGenerateApiService$requestGenerateShareImage$12.L$1 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                            shareImageGenerateApiService$requestGenerateShareImage$12.L$2 = SpillingKt.nullOutSpilledVariable(API_URL_STRING);
                                            shareImageGenerateApiService$requestGenerateShareImage$12.L$3 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                            shareImageGenerateApiService$requestGenerateShareImage$12.L$4 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                            shareImageGenerateApiService$requestGenerateShareImage$12.L$5 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                                            shareImageGenerateApiService$requestGenerateShareImage$12.L$6 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                            shareImageGenerateApiService$requestGenerateShareImage$12.I$0 = 0;
                                            shareImageGenerateApiService$requestGenerateShareImage$12.I$1 = 0;
                                            shareImageGenerateApiService$requestGenerateShareImage$12.I$2 = 0;
                                            shareImageGenerateApiService$requestGenerateShareImage$12.I$3 = 0;
                                            shareImageGenerateApiService$requestGenerateShareImage$12.label = 1;
                                            execute = httpStatement.execute(shareImageGenerateApiService$requestGenerateShareImage$12);
                                            if (execute == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            params2 = params;
                                            try {
                                                response = (HttpResponse) execute;
                                                if (Intrinsics.areEqual(response.getStatus(), HttpStatusCode.Companion.getOK())) {
                                                    return new Response(Boxing.boxInt(-1), (Integer) null, "getShareImage error: " + response.getStatus(), (String) null, (Response.Data) null, 26, (DefaultConstructorMarker) null);
                                                }
                                                HttpClientCall call = response.getCall();
                                                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Response.class);
                                                try {
                                                    kType3 = Reflection.typeOf(Response.class);
                                                } catch (Throwable th3) {
                                                    kType3 = null;
                                                }
                                                TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass3, kType3);
                                                shareImageGenerateApiService$requestGenerateShareImage$12.L$0 = SpillingKt.nullOutSpilledVariable(params2);
                                                shareImageGenerateApiService$requestGenerateShareImage$12.L$1 = SpillingKt.nullOutSpilledVariable(response);
                                                shareImageGenerateApiService$requestGenerateShareImage$12.L$2 = SpillingKt.nullOutSpilledVariable(response);
                                                shareImageGenerateApiService$requestGenerateShareImage$12.L$3 = null;
                                                shareImageGenerateApiService$requestGenerateShareImage$12.L$4 = null;
                                                shareImageGenerateApiService$requestGenerateShareImage$12.L$5 = null;
                                                shareImageGenerateApiService$requestGenerateShareImage$12.L$6 = null;
                                                shareImageGenerateApiService$requestGenerateShareImage$12.I$0 = 0;
                                                shareImageGenerateApiService$requestGenerateShareImage$12.label = 2;
                                                bodyNullable = call.bodyNullable(typeInfo, shareImageGenerateApiService$requestGenerateShareImage$12);
                                                if (bodyNullable == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                if (bodyNullable == null) {
                                                    Response responseBody = (Response) bodyNullable;
                                                    return responseBody;
                                                }
                                                throw new NullPointerException("null cannot be cast to non-null type kntr.app.mall.product.details.page.api.ShareImageGenerateApiService.Response");
                                            } catch (Exception e2) {
                                                e = e2;
                                                return new Response(Boxing.boxInt(-1), (Integer) null, "getShareImage error: " + e.getMessage(), (String) null, (Response.Data) null, 26, (DefaultConstructorMarker) null);
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            return new Response(Boxing.boxInt(-1), (Integer) null, "getShareImage error: " + e.getMessage(), (String) null, (Response.Data) null, 26, (DefaultConstructorMarker) null);
                                        }
                                    case 1:
                                        int i = shareImageGenerateApiService$requestGenerateShareImage$12.I$3;
                                        int i2 = shareImageGenerateApiService$requestGenerateShareImage$12.I$2;
                                        int i3 = shareImageGenerateApiService$requestGenerateShareImage$12.I$1;
                                        int i4 = shareImageGenerateApiService$requestGenerateShareImage$12.I$0;
                                        HttpClient httpClient = (HttpClient) shareImageGenerateApiService$requestGenerateShareImage$12.L$6;
                                        HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) shareImageGenerateApiService$requestGenerateShareImage$12.L$5;
                                        HttpClient httpClient2 = (HttpClient) shareImageGenerateApiService$requestGenerateShareImage$12.L$4;
                                        HttpClient httpClient3 = (HttpClient) shareImageGenerateApiService$requestGenerateShareImage$12.L$3;
                                        String str = (String) shareImageGenerateApiService$requestGenerateShareImage$12.L$2;
                                        HttpClient httpClient4 = (HttpClient) shareImageGenerateApiService$requestGenerateShareImage$12.L$1;
                                        params2 = (RequestParams) shareImageGenerateApiService$requestGenerateShareImage$12.L$0;
                                        try {
                                            ResultKt.throwOnFailure($result);
                                            execute = $result;
                                            response = (HttpResponse) execute;
                                            if (Intrinsics.areEqual(response.getStatus(), HttpStatusCode.Companion.getOK())) {
                                            }
                                        } catch (Exception e4) {
                                            e = e4;
                                            return new Response(Boxing.boxInt(-1), (Integer) null, "getShareImage error: " + e.getMessage(), (String) null, (Response.Data) null, 26, (DefaultConstructorMarker) null);
                                        }
                                        break;
                                    case 2:
                                        int i5 = shareImageGenerateApiService$requestGenerateShareImage$12.I$0;
                                        HttpResponse httpResponse = (HttpResponse) shareImageGenerateApiService$requestGenerateShareImage$12.L$2;
                                        HttpResponse httpResponse2 = (HttpResponse) shareImageGenerateApiService$requestGenerateShareImage$12.L$1;
                                        RequestParams requestParams = (RequestParams) shareImageGenerateApiService$requestGenerateShareImage$12.L$0;
                                        try {
                                            ResultKt.throwOnFailure($result);
                                            bodyNullable = $result;
                                            if (bodyNullable == null) {
                                            }
                                        } catch (Exception e5) {
                                            e = e5;
                                            return new Response(Boxing.boxInt(-1), (Integer) null, "getShareImage error: " + e.getMessage(), (String) null, (Response.Data) null, 26, (DefaultConstructorMarker) null);
                                        }
                                        break;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            }
                        }
                        shareImageGenerateApiService$requestGenerateShareImage$1 = new ShareImageGenerateApiService$requestGenerateShareImage$1(this, continuation);
                        shareImageGenerateApiService$requestGenerateShareImage$12 = shareImageGenerateApiService$requestGenerateShareImage$1;
                        Object $result2 = shareImageGenerateApiService$requestGenerateShareImage$12.result;
                        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (shareImageGenerateApiService$requestGenerateShareImage$12.label) {
                        }
                    }
                }