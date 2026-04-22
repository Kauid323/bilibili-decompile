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
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kntr.app.mall.product.details.page.api.CommentInfoApiService;
import kntr.app.mall.product.details.page.utils.DateFormatKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
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
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: CommentInfoApiService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0080@¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0080@¢\u0006\u0004\b\u0015\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R,\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService;", "", "<init>", "()V", "API_URL_STRING", "", "K_LOG_TAG", "recentTimeConsuming", "Lkotlin/Triple;", "", "getRecentTimeConsuming", "()Lkotlin/Triple;", "setRecentTimeConsuming", "(Lkotlin/Triple;)V", "getCommentInfo", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse;", "request", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoRequest;", "getCommentInfo$product_details_page_debug", "(Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mallKntrGetCommentInfo", "mallKntrGetCommentInfo$product_details_page_debug", "CommentInfoResponse", "CommentInfoRequest", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CommentInfoApiService {
    private static final String API_URL_STRING = "https://mall.bilibili.com/mall-c/ugc/content/allList";
    private static final String K_LOG_TAG = "NA_WR_CommentInfoApiService";
    public static final CommentInfoApiService INSTANCE = new CommentInfoApiService();
    private static Triple<Long, Long, Long> recentTimeConsuming = new Triple<>(0L, 0L, 0L);
    public static final int $stable = 8;

    private CommentInfoApiService() {
    }

    /* compiled from: CommentInfoApiService.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 12\u00020\u0001:\u0003/01B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBC\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\r\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\t\u0010&\u001a\u00020\u0007HÖ\u0001J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u00062"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse;", "", "code", "", "errtag", "", "message", "", "data", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData;", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getErrtag", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/String;", "getData", "()Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData;", "isValid", "", "isValid$product_details_page_debug", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData;)Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "CommentInfoData", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CommentInfoResponse {
        private final Long code;
        private final CommentInfoData data;
        private final Integer errtag;
        private final String message;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public CommentInfoResponse() {
            this((Long) null, (Integer) null, (String) null, (CommentInfoData) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ CommentInfoResponse copy$default(CommentInfoResponse commentInfoResponse, Long l, Integer num, String str, CommentInfoData commentInfoData, int i, Object obj) {
            if ((i & 1) != 0) {
                l = commentInfoResponse.code;
            }
            if ((i & 2) != 0) {
                num = commentInfoResponse.errtag;
            }
            if ((i & 4) != 0) {
                str = commentInfoResponse.message;
            }
            if ((i & 8) != 0) {
                commentInfoData = commentInfoResponse.data;
            }
            return commentInfoResponse.copy(l, num, str, commentInfoData);
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

        public final CommentInfoData component4() {
            return this.data;
        }

        public final CommentInfoResponse copy(Long l, Integer num, String str, CommentInfoData commentInfoData) {
            return new CommentInfoResponse(l, num, str, commentInfoData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CommentInfoResponse) {
                CommentInfoResponse commentInfoResponse = (CommentInfoResponse) obj;
                return Intrinsics.areEqual(this.code, commentInfoResponse.code) && Intrinsics.areEqual(this.errtag, commentInfoResponse.errtag) && Intrinsics.areEqual(this.message, commentInfoResponse.message) && Intrinsics.areEqual(this.data, commentInfoResponse.data);
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
            return "CommentInfoResponse(code=" + l + ", errtag=" + num + ", message=" + str + ", data=" + this.data + ")";
        }

        /* compiled from: CommentInfoApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CommentInfoResponse> serializer() {
                return new GeneratedSerializer<CommentInfoResponse>() { // from class: kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$$serializer
                    public static final int $stable;
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.CommentInfoApiService.CommentInfoResponse", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse> A[REMOVE]) =  kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$$serializer)
                             in method: kntr.app.mall.product.details.page.api.CommentInfoApiService.CommentInfoResponse.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                              ("kntr.app.mall.product.details.page.api.CommentInfoApiService.CommentInfoResponse")
                              (wrap: kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$$serializer)
                              (4 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$$serializer
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
                            kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$$serializer r0 = kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.CommentInfoApiService.CommentInfoResponse.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ CommentInfoResponse(int seen0, Long code, Integer errtag, String message, CommentInfoData data, SerializationConstructorMarker serializationConstructorMarker) {
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

                public CommentInfoResponse(Long code, Integer errtag, String message, CommentInfoData data) {
                    this.code = code;
                    this.errtag = errtag;
                    this.message = message;
                    this.data = data;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(CommentInfoResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
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
                        output.encodeNullableSerializableElement(serialDesc, 3, CommentInfoApiService$CommentInfoResponse$CommentInfoData$$serializer.INSTANCE, self.data);
                    }
                }

                public /* synthetic */ CommentInfoResponse(Long l, Integer num, String str, CommentInfoData commentInfoData, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : commentInfoData);
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

                public final CommentInfoData getData() {
                    return this.data;
                }

                /* compiled from: CommentInfoApiService.kt */
                @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\bH\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087\b\u0018\u0000 \u007f2\u00020\u0001:\u0007yz{|}~\u007fB¹\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0004\b\"\u0010#B\u009f\u0002\b\u0010\u0012\u0006\u0010$\u001a\u00020%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0007\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010 \u001a\u0004\u0018\u00010!\u0012\b\u0010&\u001a\u0004\u0018\u00010'¢\u0006\u0004\b\"\u0010(J\u0013\u0010K\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000¢\u0006\u0002\bLJ\r\u0010M\u001a\u00020\rH\u0000¢\u0006\u0002\bNJ\r\u0010O\u001a\u00020\rH\u0000¢\u0006\u0002\bPJ\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010,J\u0011\u0010U\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010,J\u0011\u0010X\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010,J\u0011\u0010\\\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0010\u0010]\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010^\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010,J\u0011\u0010b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0010\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010e\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010f\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0007HÆ\u0003J\u0010\u0010g\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010h\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010i\u001a\u0004\u0018\u00010!HÂ\u0003JÀ\u0002\u0010j\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!HÆ\u0001¢\u0006\u0002\u0010kJ\u0013\u0010l\u001a\u00020\r2\b\u0010m\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010n\u001a\u00020%HÖ\u0001J\t\u0010o\u001a\u00020pHÖ\u0001J%\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020\u00002\u0006\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020wH\u0001¢\u0006\u0002\bxR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010-\u001a\u0004\b0\u0010,R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010-\u001a\u0004\b1\u0010,R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010-\u001a\u0004\b6\u0010,R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010-\u001a\u0004\b7\u0010,R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b8\u0010/R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00105\u001a\u0004\b9\u00104R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010-\u001a\u0004\b>\u0010,R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010-\u001a\u0004\b?\u0010,R\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b@\u0010/R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010-\u001a\u0004\bA\u0010,R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010-\u001a\u0004\bB\u0010,R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010E\u001a\u0004\bC\u0010DR\u0019\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bF\u0010/R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010-\u001a\u0004\bG\u0010,R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010-\u001a\u0004\bH\u0010,R\u0018\u0010 \u001a\u0004\u0018\u00010!8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\bI\u0010JR\u0013\u0010Q\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\bR\u0010=¨\u0006\u0080\u0001"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData;", "", "activityItemsDTO", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$ActivityItems;", "commonCount", "", "commonList", "", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel;", "essenceCount", "essenceIncludeSubCount", "essenceList", "hasNextPage", "", "hotCount", "hotIncludeSubCount", "hotList", "merchantFlag", "merchantInfo", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel;", "relatedComment", "remainTotal", "selfCount", "selfList", "serverTime", "subjectId", "subjectType", "", "tags", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentTag;", "total", "totalCount", "_upList", "Lkotlinx/serialization/json/JsonElement;", "<init>", "(Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$ActivityItems;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Byte;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Lkotlinx/serialization/json/JsonElement;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$ActivityItems;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Byte;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActivityItemsDTO", "()Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$ActivityItems;", "getCommonCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCommonList", "()Ljava/util/List;", "getEssenceCount", "getEssenceIncludeSubCount", "getEssenceList", "getHasNextPage", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHotCount", "getHotIncludeSubCount", "getHotList", "getMerchantFlag", "getMerchantInfo", "()Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel;", "getRelatedComment", "()Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel;", "getRemainTotal", "getSelfCount", "getSelfList", "getServerTime", "getSubjectId", "getSubjectType", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getTags", "getTotal", "getTotalCount", "get_upList$annotations", "()V", "getCombinedCommentList", "getCombinedCommentList$product_details_page_debug", "shouldShowComment", "shouldShowComment$product_details_page_debug", "shouldShowHeaderComment", "shouldShowHeaderComment$product_details_page_debug", "upList", "getUpList", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "(Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$ActivityItems;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Byte;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Lkotlinx/serialization/json/JsonElement;)Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData;", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "SubTagModel", "CommentTag", "ActivityItems", "MerchantInfoModel", "CommentModel", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                @Serializable
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class CommentInfoData {
                    private final JsonElement _upList;
                    private final ActivityItems activityItemsDTO;
                    private final Long commonCount;
                    private final List<CommentModel> commonList;
                    private final Long essenceCount;
                    private final Long essenceIncludeSubCount;
                    private final List<CommentModel> essenceList;
                    private final Boolean hasNextPage;
                    private final Long hotCount;
                    private final Long hotIncludeSubCount;
                    private final List<CommentModel> hotList;
                    private final Boolean merchantFlag;
                    private final MerchantInfoModel merchantInfo;
                    private final CommentModel relatedComment;
                    private final Long remainTotal;
                    private final Long selfCount;
                    private final List<CommentModel> selfList;
                    private final Long serverTime;
                    private final Long subjectId;
                    private final Byte subjectType;
                    private final List<CommentTag> tags;
                    private final Long total;
                    private final Long totalCount;
                    public static final Companion Companion = new Companion(null);
                    public static final int $stable = 8;
                    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$CommentInfoData$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            KSerializer _childSerializers$_anonymous_;
                            _childSerializers$_anonymous_ = CommentInfoApiService.CommentInfoResponse.CommentInfoData._childSerializers$_anonymous_();
                            return _childSerializers$_anonymous_;
                        }
                    }), null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$CommentInfoData$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            KSerializer _childSerializers$_anonymous_$0;
                            _childSerializers$_anonymous_$0 = CommentInfoApiService.CommentInfoResponse.CommentInfoData._childSerializers$_anonymous_$0();
                            return _childSerializers$_anonymous_$0;
                        }
                    }), null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$CommentInfoData$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            KSerializer _childSerializers$_anonymous_$1;
                            _childSerializers$_anonymous_$1 = CommentInfoApiService.CommentInfoResponse.CommentInfoData._childSerializers$_anonymous_$1();
                            return _childSerializers$_anonymous_$1;
                        }
                    }), null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$CommentInfoData$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            KSerializer _childSerializers$_anonymous_$2;
                            _childSerializers$_anonymous_$2 = CommentInfoApiService.CommentInfoResponse.CommentInfoData._childSerializers$_anonymous_$2();
                            return _childSerializers$_anonymous_$2;
                        }
                    }), null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$CommentInfoData$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            KSerializer _childSerializers$_anonymous_$3;
                            _childSerializers$_anonymous_$3 = CommentInfoApiService.CommentInfoResponse.CommentInfoData._childSerializers$_anonymous_$3();
                            return _childSerializers$_anonymous_$3;
                        }
                    }), null, null, null};

                    public CommentInfoData() {
                        this((ActivityItems) null, (Long) null, (List) null, (Long) null, (Long) null, (List) null, (Boolean) null, (Long) null, (Long) null, (List) null, (Boolean) null, (MerchantInfoModel) null, (CommentModel) null, (Long) null, (Long) null, (List) null, (Long) null, (Long) null, (Byte) null, (List) null, (Long) null, (Long) null, (JsonElement) null, 8388607, (DefaultConstructorMarker) null);
                    }

                    private final JsonElement component23() {
                        return this._upList;
                    }

                    @SerialName("upList")
                    private static /* synthetic */ void get_upList$annotations() {
                    }

                    public final ActivityItems component1() {
                        return this.activityItemsDTO;
                    }

                    public final List<CommentModel> component10() {
                        return this.hotList;
                    }

                    public final Boolean component11() {
                        return this.merchantFlag;
                    }

                    public final MerchantInfoModel component12() {
                        return this.merchantInfo;
                    }

                    public final CommentModel component13() {
                        return this.relatedComment;
                    }

                    public final Long component14() {
                        return this.remainTotal;
                    }

                    public final Long component15() {
                        return this.selfCount;
                    }

                    public final List<CommentModel> component16() {
                        return this.selfList;
                    }

                    public final Long component17() {
                        return this.serverTime;
                    }

                    public final Long component18() {
                        return this.subjectId;
                    }

                    public final Byte component19() {
                        return this.subjectType;
                    }

                    public final Long component2() {
                        return this.commonCount;
                    }

                    public final List<CommentTag> component20() {
                        return this.tags;
                    }

                    public final Long component21() {
                        return this.total;
                    }

                    public final Long component22() {
                        return this.totalCount;
                    }

                    public final List<CommentModel> component3() {
                        return this.commonList;
                    }

                    public final Long component4() {
                        return this.essenceCount;
                    }

                    public final Long component5() {
                        return this.essenceIncludeSubCount;
                    }

                    public final List<CommentModel> component6() {
                        return this.essenceList;
                    }

                    public final Boolean component7() {
                        return this.hasNextPage;
                    }

                    public final Long component8() {
                        return this.hotCount;
                    }

                    public final Long component9() {
                        return this.hotIncludeSubCount;
                    }

                    public final CommentInfoData copy(ActivityItems activityItems, Long l, List<CommentModel> list, Long l2, Long l3, List<CommentModel> list2, Boolean bool, Long l4, Long l5, List<CommentModel> list3, Boolean bool2, MerchantInfoModel merchantInfoModel, CommentModel commentModel, Long l6, Long l7, List<CommentModel> list4, Long l8, Long l9, Byte b, List<CommentTag> list5, Long l10, Long l11, JsonElement jsonElement) {
                        return new CommentInfoData(activityItems, l, list, l2, l3, list2, bool, l4, l5, list3, bool2, merchantInfoModel, commentModel, l6, l7, list4, l8, l9, b, list5, l10, l11, jsonElement);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof CommentInfoData) {
                            CommentInfoData commentInfoData = (CommentInfoData) obj;
                            return Intrinsics.areEqual(this.activityItemsDTO, commentInfoData.activityItemsDTO) && Intrinsics.areEqual(this.commonCount, commentInfoData.commonCount) && Intrinsics.areEqual(this.commonList, commentInfoData.commonList) && Intrinsics.areEqual(this.essenceCount, commentInfoData.essenceCount) && Intrinsics.areEqual(this.essenceIncludeSubCount, commentInfoData.essenceIncludeSubCount) && Intrinsics.areEqual(this.essenceList, commentInfoData.essenceList) && Intrinsics.areEqual(this.hasNextPage, commentInfoData.hasNextPage) && Intrinsics.areEqual(this.hotCount, commentInfoData.hotCount) && Intrinsics.areEqual(this.hotIncludeSubCount, commentInfoData.hotIncludeSubCount) && Intrinsics.areEqual(this.hotList, commentInfoData.hotList) && Intrinsics.areEqual(this.merchantFlag, commentInfoData.merchantFlag) && Intrinsics.areEqual(this.merchantInfo, commentInfoData.merchantInfo) && Intrinsics.areEqual(this.relatedComment, commentInfoData.relatedComment) && Intrinsics.areEqual(this.remainTotal, commentInfoData.remainTotal) && Intrinsics.areEqual(this.selfCount, commentInfoData.selfCount) && Intrinsics.areEqual(this.selfList, commentInfoData.selfList) && Intrinsics.areEqual(this.serverTime, commentInfoData.serverTime) && Intrinsics.areEqual(this.subjectId, commentInfoData.subjectId) && Intrinsics.areEqual(this.subjectType, commentInfoData.subjectType) && Intrinsics.areEqual(this.tags, commentInfoData.tags) && Intrinsics.areEqual(this.total, commentInfoData.total) && Intrinsics.areEqual(this.totalCount, commentInfoData.totalCount) && Intrinsics.areEqual(this._upList, commentInfoData._upList);
                        }
                        return false;
                    }

                    public int hashCode() {
                        return ((((((((((((((((((((((((((((((((((((((((((((this.activityItemsDTO == null ? 0 : this.activityItemsDTO.hashCode()) * 31) + (this.commonCount == null ? 0 : this.commonCount.hashCode())) * 31) + (this.commonList == null ? 0 : this.commonList.hashCode())) * 31) + (this.essenceCount == null ? 0 : this.essenceCount.hashCode())) * 31) + (this.essenceIncludeSubCount == null ? 0 : this.essenceIncludeSubCount.hashCode())) * 31) + (this.essenceList == null ? 0 : this.essenceList.hashCode())) * 31) + (this.hasNextPage == null ? 0 : this.hasNextPage.hashCode())) * 31) + (this.hotCount == null ? 0 : this.hotCount.hashCode())) * 31) + (this.hotIncludeSubCount == null ? 0 : this.hotIncludeSubCount.hashCode())) * 31) + (this.hotList == null ? 0 : this.hotList.hashCode())) * 31) + (this.merchantFlag == null ? 0 : this.merchantFlag.hashCode())) * 31) + (this.merchantInfo == null ? 0 : this.merchantInfo.hashCode())) * 31) + (this.relatedComment == null ? 0 : this.relatedComment.hashCode())) * 31) + (this.remainTotal == null ? 0 : this.remainTotal.hashCode())) * 31) + (this.selfCount == null ? 0 : this.selfCount.hashCode())) * 31) + (this.selfList == null ? 0 : this.selfList.hashCode())) * 31) + (this.serverTime == null ? 0 : this.serverTime.hashCode())) * 31) + (this.subjectId == null ? 0 : this.subjectId.hashCode())) * 31) + (this.subjectType == null ? 0 : this.subjectType.hashCode())) * 31) + (this.tags == null ? 0 : this.tags.hashCode())) * 31) + (this.total == null ? 0 : this.total.hashCode())) * 31) + (this.totalCount == null ? 0 : this.totalCount.hashCode())) * 31) + (this._upList != null ? this._upList.hashCode() : 0);
                    }

                    public String toString() {
                        ActivityItems activityItems = this.activityItemsDTO;
                        Long l = this.commonCount;
                        List<CommentModel> list = this.commonList;
                        Long l2 = this.essenceCount;
                        Long l3 = this.essenceIncludeSubCount;
                        List<CommentModel> list2 = this.essenceList;
                        Boolean bool = this.hasNextPage;
                        Long l4 = this.hotCount;
                        Long l5 = this.hotIncludeSubCount;
                        List<CommentModel> list3 = this.hotList;
                        Boolean bool2 = this.merchantFlag;
                        MerchantInfoModel merchantInfoModel = this.merchantInfo;
                        CommentModel commentModel = this.relatedComment;
                        Long l6 = this.remainTotal;
                        Long l7 = this.selfCount;
                        List<CommentModel> list4 = this.selfList;
                        Long l8 = this.serverTime;
                        Long l9 = this.subjectId;
                        Byte b = this.subjectType;
                        List<CommentTag> list5 = this.tags;
                        Long l10 = this.total;
                        Long l11 = this.totalCount;
                        return "CommentInfoData(activityItemsDTO=" + activityItems + ", commonCount=" + l + ", commonList=" + list + ", essenceCount=" + l2 + ", essenceIncludeSubCount=" + l3 + ", essenceList=" + list2 + ", hasNextPage=" + bool + ", hotCount=" + l4 + ", hotIncludeSubCount=" + l5 + ", hotList=" + list3 + ", merchantFlag=" + bool2 + ", merchantInfo=" + merchantInfoModel + ", relatedComment=" + commentModel + ", remainTotal=" + l6 + ", selfCount=" + l7 + ", selfList=" + list4 + ", serverTime=" + l8 + ", subjectId=" + l9 + ", subjectType=" + b + ", tags=" + list5 + ", total=" + l10 + ", totalCount=" + l11 + ", _upList=" + this._upList + ")";
                    }

                    /* compiled from: CommentInfoApiService.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<CommentInfoData> serializer() {
                            return CommentInfoApiService$CommentInfoResponse$CommentInfoData$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ CommentInfoData(int seen0, ActivityItems activityItemsDTO, Long commonCount, List commonList, Long essenceCount, Long essenceIncludeSubCount, List essenceList, Boolean hasNextPage, Long hotCount, Long hotIncludeSubCount, List hotList, Boolean merchantFlag, MerchantInfoModel merchantInfo, CommentModel relatedComment, Long remainTotal, Long selfCount, List selfList, Long serverTime, Long subjectId, Byte subjectType, List tags, Long total, Long totalCount, JsonElement _upList, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((seen0 & 1) == 0) {
                            this.activityItemsDTO = null;
                        } else {
                            this.activityItemsDTO = activityItemsDTO;
                        }
                        if ((seen0 & 2) == 0) {
                            this.commonCount = null;
                        } else {
                            this.commonCount = commonCount;
                        }
                        if ((seen0 & 4) == 0) {
                            this.commonList = null;
                        } else {
                            this.commonList = commonList;
                        }
                        if ((seen0 & 8) == 0) {
                            this.essenceCount = null;
                        } else {
                            this.essenceCount = essenceCount;
                        }
                        if ((seen0 & 16) == 0) {
                            this.essenceIncludeSubCount = null;
                        } else {
                            this.essenceIncludeSubCount = essenceIncludeSubCount;
                        }
                        if ((seen0 & 32) == 0) {
                            this.essenceList = null;
                        } else {
                            this.essenceList = essenceList;
                        }
                        if ((seen0 & 64) == 0) {
                            this.hasNextPage = null;
                        } else {
                            this.hasNextPage = hasNextPage;
                        }
                        if ((seen0 & 128) == 0) {
                            this.hotCount = null;
                        } else {
                            this.hotCount = hotCount;
                        }
                        if ((seen0 & 256) == 0) {
                            this.hotIncludeSubCount = null;
                        } else {
                            this.hotIncludeSubCount = hotIncludeSubCount;
                        }
                        if ((seen0 & 512) == 0) {
                            this.hotList = null;
                        } else {
                            this.hotList = hotList;
                        }
                        if ((seen0 & 1024) == 0) {
                            this.merchantFlag = null;
                        } else {
                            this.merchantFlag = merchantFlag;
                        }
                        if ((seen0 & 2048) == 0) {
                            this.merchantInfo = null;
                        } else {
                            this.merchantInfo = merchantInfo;
                        }
                        if ((seen0 & 4096) == 0) {
                            this.relatedComment = null;
                        } else {
                            this.relatedComment = relatedComment;
                        }
                        if ((seen0 & 8192) == 0) {
                            this.remainTotal = null;
                        } else {
                            this.remainTotal = remainTotal;
                        }
                        if ((seen0 & 16384) == 0) {
                            this.selfCount = null;
                        } else {
                            this.selfCount = selfCount;
                        }
                        if ((seen0 & 32768) == 0) {
                            this.selfList = null;
                        } else {
                            this.selfList = selfList;
                        }
                        if ((seen0 & 65536) == 0) {
                            this.serverTime = null;
                        } else {
                            this.serverTime = serverTime;
                        }
                        if ((seen0 & 131072) == 0) {
                            this.subjectId = null;
                        } else {
                            this.subjectId = subjectId;
                        }
                        if ((seen0 & 262144) == 0) {
                            this.subjectType = null;
                        } else {
                            this.subjectType = subjectType;
                        }
                        if ((seen0 & 524288) == 0) {
                            this.tags = null;
                        } else {
                            this.tags = tags;
                        }
                        if ((seen0 & 1048576) == 0) {
                            this.total = null;
                        } else {
                            this.total = total;
                        }
                        if ((seen0 & 2097152) == 0) {
                            this.totalCount = null;
                        } else {
                            this.totalCount = totalCount;
                        }
                        if ((seen0 & 4194304) == 0) {
                            this._upList = null;
                        } else {
                            this._upList = _upList;
                        }
                    }

                    public CommentInfoData(ActivityItems activityItemsDTO, Long commonCount, List<CommentModel> list, Long essenceCount, Long essenceIncludeSubCount, List<CommentModel> list2, Boolean hasNextPage, Long hotCount, Long hotIncludeSubCount, List<CommentModel> list3, Boolean merchantFlag, MerchantInfoModel merchantInfo, CommentModel relatedComment, Long remainTotal, Long selfCount, List<CommentModel> list4, Long serverTime, Long subjectId, Byte subjectType, List<CommentTag> list5, Long total, Long totalCount, JsonElement _upList) {
                        this.activityItemsDTO = activityItemsDTO;
                        this.commonCount = commonCount;
                        this.commonList = list;
                        this.essenceCount = essenceCount;
                        this.essenceIncludeSubCount = essenceIncludeSubCount;
                        this.essenceList = list2;
                        this.hasNextPage = hasNextPage;
                        this.hotCount = hotCount;
                        this.hotIncludeSubCount = hotIncludeSubCount;
                        this.hotList = list3;
                        this.merchantFlag = merchantFlag;
                        this.merchantInfo = merchantInfo;
                        this.relatedComment = relatedComment;
                        this.remainTotal = remainTotal;
                        this.selfCount = selfCount;
                        this.selfList = list4;
                        this.serverTime = serverTime;
                        this.subjectId = subjectId;
                        this.subjectType = subjectType;
                        this.tags = list5;
                        this.total = total;
                        this.totalCount = totalCount;
                        this._upList = _upList;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                        return new ArrayListSerializer(CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$$serializer.INSTANCE);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                        return new ArrayListSerializer(CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$$serializer.INSTANCE);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
                        return new ArrayListSerializer(CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$$serializer.INSTANCE);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
                        return new ArrayListSerializer(CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$$serializer.INSTANCE);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
                        return new ArrayListSerializer(CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentTag$$serializer.INSTANCE);
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$product_details_page_debug(CommentInfoData self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.activityItemsDTO != null) {
                            output.encodeNullableSerializableElement(serialDesc, 0, CommentInfoApiService$CommentInfoResponse$CommentInfoData$ActivityItems$$serializer.INSTANCE, self.activityItemsDTO);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.commonCount != null) {
                            output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.commonCount);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.commonList != null) {
                            output.encodeNullableSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.commonList);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.essenceCount != null) {
                            output.encodeNullableSerializableElement(serialDesc, 3, LongSerializer.INSTANCE, self.essenceCount);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.essenceIncludeSubCount != null) {
                            output.encodeNullableSerializableElement(serialDesc, 4, LongSerializer.INSTANCE, self.essenceIncludeSubCount);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.essenceList != null) {
                            output.encodeNullableSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.essenceList);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.hasNextPage != null) {
                            output.encodeNullableSerializableElement(serialDesc, 6, BooleanSerializer.INSTANCE, self.hasNextPage);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.hotCount != null) {
                            output.encodeNullableSerializableElement(serialDesc, 7, LongSerializer.INSTANCE, self.hotCount);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.hotIncludeSubCount != null) {
                            output.encodeNullableSerializableElement(serialDesc, 8, LongSerializer.INSTANCE, self.hotIncludeSubCount);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.hotList != null) {
                            output.encodeNullableSerializableElement(serialDesc, 9, lazyArr[9].getValue(), self.hotList);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.merchantFlag != null) {
                            output.encodeNullableSerializableElement(serialDesc, 10, BooleanSerializer.INSTANCE, self.merchantFlag);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.merchantInfo != null) {
                            output.encodeNullableSerializableElement(serialDesc, 11, CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$$serializer.INSTANCE, self.merchantInfo);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.relatedComment != null) {
                            output.encodeNullableSerializableElement(serialDesc, 12, CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$$serializer.INSTANCE, self.relatedComment);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.remainTotal != null) {
                            output.encodeNullableSerializableElement(serialDesc, 13, LongSerializer.INSTANCE, self.remainTotal);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.selfCount != null) {
                            output.encodeNullableSerializableElement(serialDesc, 14, LongSerializer.INSTANCE, self.selfCount);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.selfList != null) {
                            output.encodeNullableSerializableElement(serialDesc, 15, lazyArr[15].getValue(), self.selfList);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.serverTime != null) {
                            output.encodeNullableSerializableElement(serialDesc, 16, LongSerializer.INSTANCE, self.serverTime);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.subjectId != null) {
                            output.encodeNullableSerializableElement(serialDesc, 17, LongSerializer.INSTANCE, self.subjectId);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.subjectType != null) {
                            output.encodeNullableSerializableElement(serialDesc, 18, ByteSerializer.INSTANCE, self.subjectType);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.tags != null) {
                            output.encodeNullableSerializableElement(serialDesc, 19, lazyArr[19].getValue(), self.tags);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 20) || self.total != null) {
                            output.encodeNullableSerializableElement(serialDesc, 20, LongSerializer.INSTANCE, self.total);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 21) || self.totalCount != null) {
                            output.encodeNullableSerializableElement(serialDesc, 21, LongSerializer.INSTANCE, self.totalCount);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 22) || self._upList != null) {
                            output.encodeNullableSerializableElement(serialDesc, 22, JsonElementSerializer.INSTANCE, self._upList);
                        }
                    }

                    public /* synthetic */ CommentInfoData(ActivityItems activityItems, Long l, List list, Long l2, Long l3, List list2, Boolean bool, Long l4, Long l5, List list3, Boolean bool2, MerchantInfoModel merchantInfoModel, CommentModel commentModel, Long l6, Long l7, List list4, Long l8, Long l9, Byte b, List list5, Long l10, Long l11, JsonElement jsonElement, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : activityItems, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : l2, (i & 16) != 0 ? null : l3, (i & 32) != 0 ? null : list2, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? null : l4, (i & 256) != 0 ? null : l5, (i & 512) != 0 ? null : list3, (i & 1024) != 0 ? null : bool2, (i & 2048) != 0 ? null : merchantInfoModel, (i & 4096) != 0 ? null : commentModel, (i & 8192) != 0 ? null : l6, (i & 16384) != 0 ? null : l7, (i & 32768) != 0 ? null : list4, (i & 65536) != 0 ? null : l8, (i & 131072) != 0 ? null : l9, (i & 262144) != 0 ? null : b, (i & 524288) != 0 ? null : list5, (i & 1048576) != 0 ? null : l10, (i & 2097152) != 0 ? null : l11, (i & 4194304) != 0 ? null : jsonElement);
                    }

                    public final ActivityItems getActivityItemsDTO() {
                        return this.activityItemsDTO;
                    }

                    public final Long getCommonCount() {
                        return this.commonCount;
                    }

                    public final List<CommentModel> getCommonList() {
                        return this.commonList;
                    }

                    public final Long getEssenceCount() {
                        return this.essenceCount;
                    }

                    public final Long getEssenceIncludeSubCount() {
                        return this.essenceIncludeSubCount;
                    }

                    public final List<CommentModel> getEssenceList() {
                        return this.essenceList;
                    }

                    public final Boolean getHasNextPage() {
                        return this.hasNextPage;
                    }

                    public final Long getHotCount() {
                        return this.hotCount;
                    }

                    public final Long getHotIncludeSubCount() {
                        return this.hotIncludeSubCount;
                    }

                    public final List<CommentModel> getHotList() {
                        return this.hotList;
                    }

                    public final Boolean getMerchantFlag() {
                        return this.merchantFlag;
                    }

                    public final MerchantInfoModel getMerchantInfo() {
                        return this.merchantInfo;
                    }

                    public final CommentModel getRelatedComment() {
                        return this.relatedComment;
                    }

                    public final Long getRemainTotal() {
                        return this.remainTotal;
                    }

                    public final Long getSelfCount() {
                        return this.selfCount;
                    }

                    public final List<CommentModel> getSelfList() {
                        return this.selfList;
                    }

                    public final Long getServerTime() {
                        return this.serverTime;
                    }

                    public final Long getSubjectId() {
                        return this.subjectId;
                    }

                    public final Byte getSubjectType() {
                        return this.subjectType;
                    }

                    public final List<CommentTag> getTags() {
                        return this.tags;
                    }

                    public final Long getTotal() {
                        return this.total;
                    }

                    public final Long getTotalCount() {
                        return this.totalCount;
                    }

                    /* compiled from: CommentInfoApiService.kt */
                    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006'"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$SubTagModel;", "", "tagId", "", "vCount1", "", "tagName", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTagId", "()Ljava/lang/String;", "getVCount1", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTagName", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$SubTagModel;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    @Serializable
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class SubTagModel {
                        public static final int $stable = 0;
                        public static final Companion Companion = new Companion(null);
                        private final String tagId;
                        private final String tagName;
                        private final Integer vCount1;

                        public static /* synthetic */ SubTagModel copy$default(SubTagModel subTagModel, String str, Integer num, String str2, int i, Object obj) {
                            if ((i & 1) != 0) {
                                str = subTagModel.tagId;
                            }
                            if ((i & 2) != 0) {
                                num = subTagModel.vCount1;
                            }
                            if ((i & 4) != 0) {
                                str2 = subTagModel.tagName;
                            }
                            return subTagModel.copy(str, num, str2);
                        }

                        public final String component1() {
                            return this.tagId;
                        }

                        public final Integer component2() {
                            return this.vCount1;
                        }

                        public final String component3() {
                            return this.tagName;
                        }

                        public final SubTagModel copy(String str, Integer num, String str2) {
                            return new SubTagModel(str, num, str2);
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj instanceof SubTagModel) {
                                SubTagModel subTagModel = (SubTagModel) obj;
                                return Intrinsics.areEqual(this.tagId, subTagModel.tagId) && Intrinsics.areEqual(this.vCount1, subTagModel.vCount1) && Intrinsics.areEqual(this.tagName, subTagModel.tagName);
                            }
                            return false;
                        }

                        public int hashCode() {
                            return ((((this.tagId == null ? 0 : this.tagId.hashCode()) * 31) + (this.vCount1 == null ? 0 : this.vCount1.hashCode())) * 31) + (this.tagName != null ? this.tagName.hashCode() : 0);
                        }

                        public String toString() {
                            String str = this.tagId;
                            Integer num = this.vCount1;
                            return "SubTagModel(tagId=" + str + ", vCount1=" + num + ", tagName=" + this.tagName + ")";
                        }

                        /* compiled from: CommentInfoApiService.kt */
                        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$SubTagModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$SubTagModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class Companion {
                            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                this();
                            }

                            private Companion() {
                            }

                            public final KSerializer<SubTagModel> serializer() {
                                return CommentInfoApiService$CommentInfoResponse$CommentInfoData$SubTagModel$$serializer.INSTANCE;
                            }
                        }

                        public /* synthetic */ SubTagModel(int seen0, String tagId, Integer vCount1, String tagName, SerializationConstructorMarker serializationConstructorMarker) {
                            if (7 != (seen0 & 7)) {
                                PluginExceptionsKt.throwMissingFieldException(seen0, 7, CommentInfoApiService$CommentInfoResponse$CommentInfoData$SubTagModel$$serializer.INSTANCE.getDescriptor());
                            }
                            this.tagId = tagId;
                            this.vCount1 = vCount1;
                            this.tagName = tagName;
                        }

                        public SubTagModel(String tagId, Integer vCount1, String tagName) {
                            this.tagId = tagId;
                            this.vCount1 = vCount1;
                            this.tagName = tagName;
                        }

                        @JvmStatic
                        public static final /* synthetic */ void write$Self$product_details_page_debug(SubTagModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
                            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.tagId);
                            output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.vCount1);
                            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.tagName);
                        }

                        public final String getTagId() {
                            return this.tagId;
                        }

                        public final Integer getVCount1() {
                            return this.vCount1;
                        }

                        public final String getTagName() {
                            return this.tagName;
                        }
                    }

                    /* compiled from: CommentInfoApiService.kt */
                    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\nHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentTag;", "", "tagName", "", "subTags", "", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$SubTagModel;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTagName", "()Ljava/lang/String;", "getSubTags", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    @Serializable
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class CommentTag {
                        private final List<SubTagModel> subTags;
                        private final String tagName;
                        public static final Companion Companion = new Companion(null);
                        public static final int $stable = 8;
                        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentTag$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                KSerializer _childSerializers$_anonymous_;
                                _childSerializers$_anonymous_ = CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentTag._childSerializers$_anonymous_();
                                return _childSerializers$_anonymous_;
                            }
                        })};

                        /* JADX WARN: Multi-variable type inference failed */
                        public static /* synthetic */ CommentTag copy$default(CommentTag commentTag, String str, List list, int i, Object obj) {
                            if ((i & 1) != 0) {
                                str = commentTag.tagName;
                            }
                            if ((i & 2) != 0) {
                                list = commentTag.subTags;
                            }
                            return commentTag.copy(str, list);
                        }

                        public final String component1() {
                            return this.tagName;
                        }

                        public final List<SubTagModel> component2() {
                            return this.subTags;
                        }

                        public final CommentTag copy(String str, List<SubTagModel> list) {
                            return new CommentTag(str, list);
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj instanceof CommentTag) {
                                CommentTag commentTag = (CommentTag) obj;
                                return Intrinsics.areEqual(this.tagName, commentTag.tagName) && Intrinsics.areEqual(this.subTags, commentTag.subTags);
                            }
                            return false;
                        }

                        public int hashCode() {
                            return ((this.tagName == null ? 0 : this.tagName.hashCode()) * 31) + (this.subTags != null ? this.subTags.hashCode() : 0);
                        }

                        public String toString() {
                            String str = this.tagName;
                            return "CommentTag(tagName=" + str + ", subTags=" + this.subTags + ")";
                        }

                        /* compiled from: CommentInfoApiService.kt */
                        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentTag$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentTag;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class Companion {
                            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                this();
                            }

                            private Companion() {
                            }

                            public final KSerializer<CommentTag> serializer() {
                                return CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentTag$$serializer.INSTANCE;
                            }
                        }

                        public /* synthetic */ CommentTag(int seen0, String tagName, List subTags, SerializationConstructorMarker serializationConstructorMarker) {
                            if (1 != (seen0 & 1)) {
                                PluginExceptionsKt.throwMissingFieldException(seen0, 1, CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentTag$$serializer.INSTANCE.getDescriptor());
                            }
                            this.tagName = tagName;
                            if ((seen0 & 2) == 0) {
                                this.subTags = null;
                            } else {
                                this.subTags = subTags;
                            }
                        }

                        public CommentTag(String tagName, List<SubTagModel> list) {
                            this.tagName = tagName;
                            this.subTags = list;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                            return new ArrayListSerializer(CommentInfoApiService$CommentInfoResponse$CommentInfoData$SubTagModel$$serializer.INSTANCE);
                        }

                        @JvmStatic
                        public static final /* synthetic */ void write$Self$product_details_page_debug(CommentTag self, CompositeEncoder output, SerialDescriptor serialDesc) {
                            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.tagName);
                            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.subTags != null) {
                                output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.subTags);
                            }
                        }

                        public /* synthetic */ CommentTag(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                            this(str, (i & 2) != 0 ? null : list);
                        }

                        public final String getTagName() {
                            return this.tagName;
                        }

                        public final List<SubTagModel> getSubTags() {
                            return this.subTags;
                        }
                    }

                    public final List<CommentModel> getCombinedCommentList$product_details_page_debug() {
                        List $this$getCombinedCommentList_u24lambda_u240 = CollectionsKt.createListBuilder();
                        List<CommentModel> list = this.essenceList;
                        if (list != null) {
                            $this$getCombinedCommentList_u24lambda_u240.addAll(list);
                        }
                        Collection p0 = this.commonList;
                        if (p0 != null) {
                            $this$getCombinedCommentList_u24lambda_u240.addAll(p0);
                        }
                        List<CommentModel> merged = CollectionsKt.build($this$getCombinedCommentList_u24lambda_u240);
                        Set seen = new LinkedHashSet();
                        List $this$getCombinedCommentList_u24lambda_u241 = CollectionsKt.createListBuilder();
                        for (CommentModel e : merged) {
                            if (e.getUgcId() == null || seen.add(e.getUgcId())) {
                                $this$getCombinedCommentList_u24lambda_u241.add(e);
                            }
                        }
                        List result = CollectionsKt.build($this$getCombinedCommentList_u24lambda_u241);
                        return result;
                    }

                    public final boolean shouldShowComment$product_details_page_debug() {
                        List combinedList = getCombinedCommentList$product_details_page_debug();
                        return !combinedList.isEmpty();
                    }

                    public final boolean shouldShowHeaderComment$product_details_page_debug() {
                        Iterable combinedList = getCombinedCommentList$product_details_page_debug();
                        Iterable $this$filter$iv = combinedList;
                        Collection destination$iv$iv = new ArrayList();
                        Iterator<T> it = $this$filter$iv.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Object element$iv$iv = it.next();
                            CommentModel it2 = (CommentModel) element$iv$iv;
                            List<String> imgs = it2.getImgs();
                            if ((imgs != null ? imgs.size() : 0) > 0) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                        }
                        List imageComments = (List) destination$iv$iv;
                        return imageComments.size() >= 2;
                    }

                    public final CommentModel getUpList() {
                        if (this._upList == null) {
                            return null;
                        }
                        if (this._upList instanceof JsonObject) {
                            return (CommentModel) Json.Default.decodeFromJsonElement(CommentModel.Companion.serializer(), this._upList);
                        }
                        if (this._upList instanceof JsonArray) {
                            JsonArray jsonArray = this._upList;
                            Intrinsics.checkNotNull(jsonArray, "null cannot be cast to non-null type kotlinx.serialization.json.JsonArray");
                            if (jsonArray.isEmpty()) {
                            }
                            return null;
                        }
                        return null;
                    }

                    /* compiled from: CommentInfoApiService.kt */
                    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002./BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bBW\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003JV\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014¨\u00060"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$ActivityItems;", "", "activityId", "", "activityName", "", "activityShortName", "activityTag", "activityTopic", "activityUrl", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActivityId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getActivityName", "()Ljava/lang/String;", "getActivityShortName", "getActivityTag", "getActivityTopic", "getActivityUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$ActivityItems;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    @Serializable
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class ActivityItems {
                        public static final int $stable = 0;
                        public static final Companion Companion = new Companion(null);
                        private final Integer activityId;
                        private final String activityName;
                        private final String activityShortName;
                        private final String activityTag;
                        private final String activityTopic;
                        private final String activityUrl;

                        public ActivityItems() {
                            this((Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
                        }

                        public static /* synthetic */ ActivityItems copy$default(ActivityItems activityItems, Integer num, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
                            if ((i & 1) != 0) {
                                num = activityItems.activityId;
                            }
                            if ((i & 2) != 0) {
                                str = activityItems.activityName;
                            }
                            String str6 = str;
                            if ((i & 4) != 0) {
                                str2 = activityItems.activityShortName;
                            }
                            String str7 = str2;
                            if ((i & 8) != 0) {
                                str3 = activityItems.activityTag;
                            }
                            String str8 = str3;
                            if ((i & 16) != 0) {
                                str4 = activityItems.activityTopic;
                            }
                            String str9 = str4;
                            if ((i & 32) != 0) {
                                str5 = activityItems.activityUrl;
                            }
                            return activityItems.copy(num, str6, str7, str8, str9, str5);
                        }

                        public final Integer component1() {
                            return this.activityId;
                        }

                        public final String component2() {
                            return this.activityName;
                        }

                        public final String component3() {
                            return this.activityShortName;
                        }

                        public final String component4() {
                            return this.activityTag;
                        }

                        public final String component5() {
                            return this.activityTopic;
                        }

                        public final String component6() {
                            return this.activityUrl;
                        }

                        public final ActivityItems copy(Integer num, String str, String str2, String str3, String str4, String str5) {
                            return new ActivityItems(num, str, str2, str3, str4, str5);
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj instanceof ActivityItems) {
                                ActivityItems activityItems = (ActivityItems) obj;
                                return Intrinsics.areEqual(this.activityId, activityItems.activityId) && Intrinsics.areEqual(this.activityName, activityItems.activityName) && Intrinsics.areEqual(this.activityShortName, activityItems.activityShortName) && Intrinsics.areEqual(this.activityTag, activityItems.activityTag) && Intrinsics.areEqual(this.activityTopic, activityItems.activityTopic) && Intrinsics.areEqual(this.activityUrl, activityItems.activityUrl);
                            }
                            return false;
                        }

                        public int hashCode() {
                            return ((((((((((this.activityId == null ? 0 : this.activityId.hashCode()) * 31) + (this.activityName == null ? 0 : this.activityName.hashCode())) * 31) + (this.activityShortName == null ? 0 : this.activityShortName.hashCode())) * 31) + (this.activityTag == null ? 0 : this.activityTag.hashCode())) * 31) + (this.activityTopic == null ? 0 : this.activityTopic.hashCode())) * 31) + (this.activityUrl != null ? this.activityUrl.hashCode() : 0);
                        }

                        public String toString() {
                            Integer num = this.activityId;
                            String str = this.activityName;
                            String str2 = this.activityShortName;
                            String str3 = this.activityTag;
                            String str4 = this.activityTopic;
                            return "ActivityItems(activityId=" + num + ", activityName=" + str + ", activityShortName=" + str2 + ", activityTag=" + str3 + ", activityTopic=" + str4 + ", activityUrl=" + this.activityUrl + ")";
                        }

                        /* compiled from: CommentInfoApiService.kt */
                        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$ActivityItems$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$ActivityItems;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class Companion {
                            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                this();
                            }

                            private Companion() {
                            }

                            public final KSerializer<ActivityItems> serializer() {
                                return CommentInfoApiService$CommentInfoResponse$CommentInfoData$ActivityItems$$serializer.INSTANCE;
                            }
                        }

                        public /* synthetic */ ActivityItems(int seen0, Integer activityId, String activityName, String activityShortName, String activityTag, String activityTopic, String activityUrl, SerializationConstructorMarker serializationConstructorMarker) {
                            if ((seen0 & 1) == 0) {
                                this.activityId = null;
                            } else {
                                this.activityId = activityId;
                            }
                            if ((seen0 & 2) == 0) {
                                this.activityName = null;
                            } else {
                                this.activityName = activityName;
                            }
                            if ((seen0 & 4) == 0) {
                                this.activityShortName = null;
                            } else {
                                this.activityShortName = activityShortName;
                            }
                            if ((seen0 & 8) == 0) {
                                this.activityTag = null;
                            } else {
                                this.activityTag = activityTag;
                            }
                            if ((seen0 & 16) == 0) {
                                this.activityTopic = null;
                            } else {
                                this.activityTopic = activityTopic;
                            }
                            if ((seen0 & 32) == 0) {
                                this.activityUrl = null;
                            } else {
                                this.activityUrl = activityUrl;
                            }
                        }

                        public ActivityItems(Integer activityId, String activityName, String activityShortName, String activityTag, String activityTopic, String activityUrl) {
                            this.activityId = activityId;
                            this.activityName = activityName;
                            this.activityShortName = activityShortName;
                            this.activityTag = activityTag;
                            this.activityTopic = activityTopic;
                            this.activityUrl = activityUrl;
                        }

                        @JvmStatic
                        public static final /* synthetic */ void write$Self$product_details_page_debug(ActivityItems self, CompositeEncoder output, SerialDescriptor serialDesc) {
                            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.activityId != null) {
                                output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.activityId);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.activityName != null) {
                                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.activityName);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.activityShortName != null) {
                                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.activityShortName);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.activityTag != null) {
                                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.activityTag);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.activityTopic != null) {
                                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.activityTopic);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.activityUrl != null) {
                                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.activityUrl);
                            }
                        }

                        public /* synthetic */ ActivityItems(Integer num, String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
                            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
                        }

                        public final Integer getActivityId() {
                            return this.activityId;
                        }

                        public final String getActivityName() {
                            return this.activityName;
                        }

                        public final String getActivityShortName() {
                            return this.activityShortName;
                        }

                        public final String getActivityTag() {
                            return this.activityTag;
                        }

                        public final String getActivityTopic() {
                            return this.activityTopic;
                        }

                        public final String getActivityUrl() {
                            return this.activityUrl;
                        }
                    }

                    /* compiled from: CommentInfoApiService.kt */
                    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 F2\u00020\u0001:\u0003DEFBs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011Bu\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0010\u0010\u0015J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u00100\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010&Jz\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u0003HÖ\u0001J\t\u0010;\u001a\u00020\tHÖ\u0001J%\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00002\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0001¢\u0006\u0002\bCR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001b\u0010\u0017R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001c\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u001e\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0013\u0010(\u001a\u0004\u0018\u00010)8F¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006G"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel;", "", "applyCount", "", RedirectImpKt.REDIRECT_KV_CONFIG, "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$Config;", "finishCount", "merchantId", "merchantName", "", "merchantShopFace", "merchantShopName", "positiveRatioElement", "Lkotlinx/serialization/json/JsonElement;", AppKey.UID, "", "<init>", "(Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$Config;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/Long;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$Config;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getApplyCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getConfig", "()Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$Config;", "getFinishCount", "getMerchantId", "getMerchantName", "()Ljava/lang/String;", "getMerchantShopFace", "getMerchantShopName", "getPositiveRatioElement$annotations", "()V", "getPositiveRatioElement", "()Lkotlinx/serialization/json/JsonElement;", "getUid", "()Ljava/lang/Long;", "Ljava/lang/Long;", "positiveRatio", "", "getPositiveRatio", "()Ljava/lang/Double;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$Config;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/Long;)Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "Config", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    @Serializable
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class MerchantInfoModel {
                        private final Integer applyCount;
                        private final Config config;
                        private final Integer finishCount;
                        private final Integer merchantId;
                        private final String merchantName;
                        private final String merchantShopFace;
                        private final String merchantShopName;
                        private final JsonElement positiveRatioElement;
                        private final Long uid;
                        public static final Companion Companion = new Companion(null);
                        public static final int $stable = 8;

                        public MerchantInfoModel() {
                            this((Integer) null, (Config) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (JsonElement) null, (Long) null, 511, (DefaultConstructorMarker) null);
                        }

                        @SerialName("positiveRatio")
                        public static /* synthetic */ void getPositiveRatioElement$annotations() {
                        }

                        public final Integer component1() {
                            return this.applyCount;
                        }

                        public final Config component2() {
                            return this.config;
                        }

                        public final Integer component3() {
                            return this.finishCount;
                        }

                        public final Integer component4() {
                            return this.merchantId;
                        }

                        public final String component5() {
                            return this.merchantName;
                        }

                        public final String component6() {
                            return this.merchantShopFace;
                        }

                        public final String component7() {
                            return this.merchantShopName;
                        }

                        public final JsonElement component8() {
                            return this.positiveRatioElement;
                        }

                        public final Long component9() {
                            return this.uid;
                        }

                        public final MerchantInfoModel copy(Integer num, Config config, Integer num2, Integer num3, String str, String str2, String str3, JsonElement jsonElement, Long l) {
                            return new MerchantInfoModel(num, config, num2, num3, str, str2, str3, jsonElement, l);
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj instanceof MerchantInfoModel) {
                                MerchantInfoModel merchantInfoModel = (MerchantInfoModel) obj;
                                return Intrinsics.areEqual(this.applyCount, merchantInfoModel.applyCount) && Intrinsics.areEqual(this.config, merchantInfoModel.config) && Intrinsics.areEqual(this.finishCount, merchantInfoModel.finishCount) && Intrinsics.areEqual(this.merchantId, merchantInfoModel.merchantId) && Intrinsics.areEqual(this.merchantName, merchantInfoModel.merchantName) && Intrinsics.areEqual(this.merchantShopFace, merchantInfoModel.merchantShopFace) && Intrinsics.areEqual(this.merchantShopName, merchantInfoModel.merchantShopName) && Intrinsics.areEqual(this.positiveRatioElement, merchantInfoModel.positiveRatioElement) && Intrinsics.areEqual(this.uid, merchantInfoModel.uid);
                            }
                            return false;
                        }

                        public int hashCode() {
                            return ((((((((((((((((this.applyCount == null ? 0 : this.applyCount.hashCode()) * 31) + (this.config == null ? 0 : this.config.hashCode())) * 31) + (this.finishCount == null ? 0 : this.finishCount.hashCode())) * 31) + (this.merchantId == null ? 0 : this.merchantId.hashCode())) * 31) + (this.merchantName == null ? 0 : this.merchantName.hashCode())) * 31) + (this.merchantShopFace == null ? 0 : this.merchantShopFace.hashCode())) * 31) + (this.merchantShopName == null ? 0 : this.merchantShopName.hashCode())) * 31) + (this.positiveRatioElement == null ? 0 : this.positiveRatioElement.hashCode())) * 31) + (this.uid != null ? this.uid.hashCode() : 0);
                        }

                        public String toString() {
                            Integer num = this.applyCount;
                            Config config = this.config;
                            Integer num2 = this.finishCount;
                            Integer num3 = this.merchantId;
                            String str = this.merchantName;
                            String str2 = this.merchantShopFace;
                            String str3 = this.merchantShopName;
                            JsonElement jsonElement = this.positiveRatioElement;
                            return "MerchantInfoModel(applyCount=" + num + ", config=" + config + ", finishCount=" + num2 + ", merchantId=" + num3 + ", merchantName=" + str + ", merchantShopFace=" + str2 + ", merchantShopName=" + str3 + ", positiveRatioElement=" + jsonElement + ", uid=" + this.uid + ")";
                        }

                        /* compiled from: CommentInfoApiService.kt */
                        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class Companion {
                            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                this();
                            }

                            private Companion() {
                            }

                            public final KSerializer<MerchantInfoModel> serializer() {
                                return CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$$serializer.INSTANCE;
                            }
                        }

                        public /* synthetic */ MerchantInfoModel(int seen0, Integer applyCount, Config config, Integer finishCount, Integer merchantId, String merchantName, String merchantShopFace, String merchantShopName, JsonElement positiveRatioElement, Long uid, SerializationConstructorMarker serializationConstructorMarker) {
                            if ((seen0 & 1) == 0) {
                                this.applyCount = null;
                            } else {
                                this.applyCount = applyCount;
                            }
                            if ((seen0 & 2) == 0) {
                                this.config = null;
                            } else {
                                this.config = config;
                            }
                            if ((seen0 & 4) == 0) {
                                this.finishCount = null;
                            } else {
                                this.finishCount = finishCount;
                            }
                            if ((seen0 & 8) == 0) {
                                this.merchantId = null;
                            } else {
                                this.merchantId = merchantId;
                            }
                            if ((seen0 & 16) == 0) {
                                this.merchantName = null;
                            } else {
                                this.merchantName = merchantName;
                            }
                            if ((seen0 & 32) == 0) {
                                this.merchantShopFace = null;
                            } else {
                                this.merchantShopFace = merchantShopFace;
                            }
                            if ((seen0 & 64) == 0) {
                                this.merchantShopName = null;
                            } else {
                                this.merchantShopName = merchantShopName;
                            }
                            if ((seen0 & 128) == 0) {
                                this.positiveRatioElement = null;
                            } else {
                                this.positiveRatioElement = positiveRatioElement;
                            }
                            if ((seen0 & 256) == 0) {
                                this.uid = null;
                            } else {
                                this.uid = uid;
                            }
                        }

                        public MerchantInfoModel(Integer applyCount, Config config, Integer finishCount, Integer merchantId, String merchantName, String merchantShopFace, String merchantShopName, JsonElement positiveRatioElement, Long uid) {
                            this.applyCount = applyCount;
                            this.config = config;
                            this.finishCount = finishCount;
                            this.merchantId = merchantId;
                            this.merchantName = merchantName;
                            this.merchantShopFace = merchantShopFace;
                            this.merchantShopName = merchantShopName;
                            this.positiveRatioElement = positiveRatioElement;
                            this.uid = uid;
                        }

                        @JvmStatic
                        public static final /* synthetic */ void write$Self$product_details_page_debug(MerchantInfoModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
                            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.applyCount != null) {
                                output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.applyCount);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.config != null) {
                                output.encodeNullableSerializableElement(serialDesc, 1, CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$Config$$serializer.INSTANCE, self.config);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.finishCount != null) {
                                output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.finishCount);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.merchantId != null) {
                                output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.merchantId);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.merchantName != null) {
                                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.merchantName);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.merchantShopFace != null) {
                                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.merchantShopFace);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.merchantShopName != null) {
                                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.merchantShopName);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.positiveRatioElement != null) {
                                output.encodeNullableSerializableElement(serialDesc, 7, JsonElementSerializer.INSTANCE, self.positiveRatioElement);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.uid != null) {
                                output.encodeNullableSerializableElement(serialDesc, 8, LongSerializer.INSTANCE, self.uid);
                            }
                        }

                        public /* synthetic */ MerchantInfoModel(Integer num, Config config, Integer num2, Integer num3, String str, String str2, String str3, JsonElement jsonElement, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
                            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : config, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : jsonElement, (i & 256) == 0 ? l : null);
                        }

                        public final Integer getApplyCount() {
                            return this.applyCount;
                        }

                        public final Config getConfig() {
                            return this.config;
                        }

                        public final Integer getFinishCount() {
                            return this.finishCount;
                        }

                        public final Integer getMerchantId() {
                            return this.merchantId;
                        }

                        public final String getMerchantName() {
                            return this.merchantName;
                        }

                        public final String getMerchantShopFace() {
                            return this.merchantShopFace;
                        }

                        public final String getMerchantShopName() {
                            return this.merchantShopName;
                        }

                        public final JsonElement getPositiveRatioElement() {
                            return this.positiveRatioElement;
                        }

                        public final Long getUid() {
                            return this.uid;
                        }

                        public final Double getPositiveRatio() {
                            if (this.positiveRatioElement instanceof JsonPrimitive) {
                                if (this.positiveRatioElement.isString()) {
                                    return StringsKt.toDoubleOrNull(this.positiveRatioElement.getContent());
                                }
                                if (JsonElementKt.getDoubleOrNull(this.positiveRatioElement) != null) {
                                    return Double.valueOf(JsonElementKt.getDouble(this.positiveRatioElement));
                                }
                                return null;
                            }
                            return null;
                        }

                        /* compiled from: CommentInfoApiService.kt */
                        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\tJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006 "}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$Config;", "", "replySetting", "", "<init>", "(Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getReplySetting", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$Config;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        @Serializable
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class Config {
                            public static final int $stable = 0;
                            public static final Companion Companion = new Companion(null);
                            private final Integer replySetting;

                            public Config() {
                                this((Integer) null, 1, (DefaultConstructorMarker) null);
                            }

                            public static /* synthetic */ Config copy$default(Config config, Integer num, int i, Object obj) {
                                if ((i & 1) != 0) {
                                    num = config.replySetting;
                                }
                                return config.copy(num);
                            }

                            public final Integer component1() {
                                return this.replySetting;
                            }

                            public final Config copy(Integer num) {
                                return new Config(num);
                            }

                            public boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return (obj instanceof Config) && Intrinsics.areEqual(this.replySetting, ((Config) obj).replySetting);
                            }

                            public int hashCode() {
                                if (this.replySetting == null) {
                                    return 0;
                                }
                                return this.replySetting.hashCode();
                            }

                            public String toString() {
                                return "Config(replySetting=" + this.replySetting + ")";
                            }

                            /* compiled from: CommentInfoApiService.kt */
                            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$Config$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$Config;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                            public static final class Companion {
                                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                    this();
                                }

                                private Companion() {
                                }

                                public final KSerializer<Config> serializer() {
                                    return CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$Config$$serializer.INSTANCE;
                                }
                            }

                            public /* synthetic */ Config(int seen0, Integer replySetting, SerializationConstructorMarker serializationConstructorMarker) {
                                if ((seen0 & 1) == 0) {
                                    this.replySetting = null;
                                } else {
                                    this.replySetting = replySetting;
                                }
                            }

                            public Config(Integer replySetting) {
                                this.replySetting = replySetting;
                            }

                            @JvmStatic
                            public static final /* synthetic */ void write$Self$product_details_page_debug(Config self, CompositeEncoder output, SerialDescriptor serialDesc) {
                                boolean z = true;
                                if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.replySetting == null) {
                                    z = false;
                                }
                                if (z) {
                                    output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.replySetting);
                                }
                            }

                            public /* synthetic */ Config(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
                                this((i & 1) != 0 ? null : num);
                            }

                            public final Integer getReplySetting() {
                                return this.replySetting;
                            }
                        }
                    }

                    /* compiled from: CommentInfoApiService.kt */
                    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b}\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u0000 Ï\u00012\u00020\u0001:\fÊ\u0001Ë\u0001Ì\u0001Í\u0001Î\u0001Ï\u0001B\u009b\u0005\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0006\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006\u0012\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u0006\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b@\u0010ABÏ\u0004\b\u0010\u0012\u0006\u0010B\u001a\u00020\u0003\u0012\u0006\u0010C\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\"\u001a\u0004\u0018\u00010\n\u0012\b\u0010#\u001a\u0004\u0018\u00010\n\u0012\b\u0010$\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010%\u001a\u0004\u0018\u00010\n\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010(\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010*\u001a\u0004\u0018\u00010\n\u0012\b\u0010+\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0012\u0012\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0006\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010/\u001a\u0004\u0018\u00010\n\u0012\b\u00100\u001a\u0004\u0018\u00010\u000e\u0012\b\u00101\u001a\u0004\u0018\u00010\n\u0012\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006\u0012\u000e\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u0006\u0012\b\u00105\u001a\u0004\u0018\u000106\u0012\b\u00107\u001a\u0004\u0018\u00010\u000e\u0012\b\u00108\u001a\u0004\u0018\u00010\u000e\u0012\b\u00109\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010:\u001a\u0004\u0018\u00010\n\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010=\u001a\u0004\u0018\u00010>\u0012\b\u0010?\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010D\u001a\u0004\u0018\u00010E¢\u0006\u0004\b@\u0010FJ\u0011\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010HJ\u0011\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010HJ\u0012\u0010\u008a\u0001\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0012\u0010\u008b\u0001\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010SJ\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010HJ\u0011\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010XJ\u0011\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010HJ\u0012\u0010\u0094\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010XJ\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010SJ\f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010XJ\u0011\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010XJ\u0011\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u001cHÆ\u0003¢\u0006\u0002\u0010cJ\u0011\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010XJ\u0011\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010XJ\u0011\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010SJ\u0011\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010HJ\u0011\u0010 \u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010XJ\f\u0010¡\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010£\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010SJ\f\u0010¤\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010¥\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010HJ\u0011\u0010¦\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010XJ\u0011\u0010§\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010SJ\u0011\u0010¨\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010XJ\f\u0010©\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010ª\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010SJ\u0011\u0010«\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010XJ\u0012\u0010¬\u0001\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010XJ\f\u0010®\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010¯\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010SJ\f\u0010°\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0012\u0010±\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006HÆ\u0003J\u0012\u0010²\u0001\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u0006HÆ\u0003J\f\u0010³\u0001\u001a\u0004\u0018\u000106HÆ\u0003J\u0011\u0010´\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010SJ\u0011\u0010µ\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010SJ\u0011\u0010¶\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010XJ\f\u0010·\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010¸\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010HJ\f\u0010¹\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010º\u0001\u001a\u0004\u0018\u00010>HÆ\u0003J\u0011\u0010»\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010SJ¤\u0005\u0010¼\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00062\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u00062\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0003\u0010½\u0001J\u0015\u0010¾\u0001\u001a\u00020\u001c2\t\u0010¿\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010À\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010Á\u0001\u001a\u00020\nHÖ\u0001J-\u0010Â\u0001\u001a\u00030Ã\u00012\u0007\u0010Ä\u0001\u001a\u00020\u00002\b\u0010Å\u0001\u001a\u00030Æ\u00012\b\u0010Ç\u0001\u001a\u00030È\u0001H\u0001¢\u0006\u0003\bÉ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010I\u001a\u0004\bG\u0010HR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010I\u001a\u0004\bJ\u0010HR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bM\u0010LR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bP\u0010OR\u0013\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010OR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010T\u001a\u0004\bR\u0010SR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bU\u0010OR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010I\u001a\u0004\bV\u0010HR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010Y\u001a\u0004\bW\u0010XR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010I\u001a\u0004\bZ\u0010HR\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b[\u0010LR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010Y\u001a\u0004\b\\\u0010XR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b]\u0010OR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010T\u001a\u0004\b^\u0010SR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b_\u0010OR\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010Y\u001a\u0004\b`\u0010XR\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010Y\u001a\u0004\ba\u0010XR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\n\n\u0002\u0010d\u001a\u0004\bb\u0010cR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010Y\u001a\u0004\be\u0010XR\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010Y\u001a\u0004\bf\u0010XR\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010T\u001a\u0004\bg\u0010SR\u0015\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010I\u001a\u0004\bh\u0010HR\u0015\u0010!\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010Y\u001a\u0004\bi\u0010XR\u0013\u0010\"\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bj\u0010OR\u0013\u0010#\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bk\u0010OR\u0015\u0010$\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010T\u001a\u0004\bl\u0010SR\u0013\u0010%\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bm\u0010OR\u0015\u0010&\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010I\u001a\u0004\bn\u0010HR\u0015\u0010'\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010Y\u001a\u0004\bo\u0010XR\u0015\u0010(\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010T\u001a\u0004\bp\u0010SR\u0015\u0010)\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010Y\u001a\u0004\bq\u0010XR\u0013\u0010*\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\br\u0010OR\u0015\u0010+\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010T\u001a\u0004\bs\u0010SR\u0015\u0010,\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010Y\u001a\u0004\bt\u0010XR\u0019\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bu\u0010LR\u0015\u0010.\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010Y\u001a\u0004\bv\u0010XR\u0013\u0010/\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bw\u0010OR\u0015\u00100\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010T\u001a\u0004\bx\u0010SR\u0013\u00101\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\by\u0010OR\u0019\u00102\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bz\u0010LR\u0019\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b{\u0010LR\u0013\u00105\u001a\u0004\u0018\u000106¢\u0006\b\n\u0000\u001a\u0004\b|\u0010}R\u0015\u00107\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010T\u001a\u0004\b~\u0010SR\u0015\u00108\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010T\u001a\u0004\b\u007f\u0010SR\u0016\u00109\u001a\u0004\u0018\u00010\u0012¢\u0006\u000b\n\u0002\u0010Y\u001a\u0005\b\u0080\u0001\u0010XR\u0014\u0010:\u001a\u0004\u0018\u00010\n¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010OR\u0016\u0010;\u001a\u0004\u0018\u00010\u0003¢\u0006\u000b\n\u0002\u0010I\u001a\u0005\b\u0082\u0001\u0010HR\u0015\u0010<\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0015\u0010=\u001a\u0004\u0018\u00010>¢\u0006\n\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0016\u0010?\u001a\u0004\u0018\u00010\u000e¢\u0006\u000b\n\u0002\u0010T\u001a\u0005\b\u0087\u0001\u0010S¨\u0006Ð\u0001"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel;", "", "activityId", "", "actualCount", "atUserInfoDTOs", "", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo;", "ats", "content", "", "crowdfundingDesc", "ctime", "display", "", "displayMessage", "downCount", "dynId", "", "floor", "imgs", "lastReplyTime", "manhuaContent", "manhuaDisplay", "manhuaDisplayContent", "merchantId", "mid", "newType", "", "orderId", "parent", "platform", "publishSource", "publishTime", "publishTimeDesc", "qqContent", "qqDisplay", "qqDisplayContent", "replyCount", "root", "score", "skuId", "skuSpecStr", "state", "subCommentCount", "subCommentList", "subjectId", "subjectName", "subjectType", "subjectUrl", "tags", "topicList", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$TopicModel;", "topicTag", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$TopicTag;", "type", "typeModifyOrigin", "ugcId", "uname", "upCount", "userinfo", "video", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$VideoModel;", "voteType", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Byte;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$TopicTag;Ljava/lang/Byte;Ljava/lang/Byte;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$VideoModel;Ljava/lang/Byte;)V", "seen0", "seen1", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Byte;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$TopicTag;Ljava/lang/Byte;Ljava/lang/Byte;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$VideoModel;Ljava/lang/Byte;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActivityId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getActualCount", "getAtUserInfoDTOs", "()Ljava/util/List;", "getAts", "getContent", "()Ljava/lang/String;", "getCrowdfundingDesc", "getCtime", "getDisplay", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getDisplayMessage", "getDownCount", "getDynId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFloor", "getImgs", "getLastReplyTime", "getManhuaContent", "getManhuaDisplay", "getManhuaDisplayContent", "getMerchantId", "getMid", "getNewType", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getOrderId", "getParent", "getPlatform", "getPublishSource", "getPublishTime", "getPublishTimeDesc", "getQqContent", "getQqDisplay", "getQqDisplayContent", "getReplyCount", "getRoot", "getScore", "getSkuId", "getSkuSpecStr", "getState", "getSubCommentCount", "getSubCommentList", "getSubjectId", "getSubjectName", "getSubjectType", "getSubjectUrl", "getTags", "getTopicList", "getTopicTag", "()Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$TopicTag;", "getType", "getTypeModifyOrigin", "getUgcId", "getUname", "getUpCount", "getUserinfo", "()Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo;", "getVideo", "()Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$VideoModel;", "getVoteType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Byte;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$TopicTag;Ljava/lang/Byte;Ljava/lang/Byte;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$VideoModel;Ljava/lang/Byte;)Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "UserInfo", "TopicModel", "TopicTag", "VideoModel", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    @Serializable
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class CommentModel {
                        private final Integer activityId;
                        private final Integer actualCount;
                        private final List<UserInfo> atUserInfoDTOs;
                        private final List<Integer> ats;
                        private final String content;
                        private final String crowdfundingDesc;
                        private final String ctime;
                        private final Byte display;
                        private final String displayMessage;
                        private final Integer downCount;
                        private final Long dynId;
                        private final Integer floor;
                        private final List<String> imgs;
                        private final Long lastReplyTime;
                        private final String manhuaContent;
                        private final Byte manhuaDisplay;
                        private final String manhuaDisplayContent;
                        private final Long merchantId;
                        private final Long mid;
                        private final Boolean newType;
                        private final Long orderId;
                        private final Long parent;
                        private final Byte platform;
                        private final Integer publishSource;
                        private final Long publishTime;
                        private final String publishTimeDesc;
                        private final String qqContent;
                        private final Byte qqDisplay;
                        private final String qqDisplayContent;
                        private final Integer replyCount;
                        private final Long root;
                        private final Byte score;
                        private final Long skuId;
                        private final String skuSpecStr;
                        private final Byte state;
                        private final Long subCommentCount;
                        private final List<CommentModel> subCommentList;
                        private final Long subjectId;
                        private final String subjectName;
                        private final Byte subjectType;
                        private final String subjectUrl;
                        private final List<String> tags;
                        private final List<TopicModel> topicList;
                        private final TopicTag topicTag;
                        private final Byte type;
                        private final Byte typeModifyOrigin;
                        private final Long ugcId;
                        private final String uname;
                        private final Integer upCount;
                        private final UserInfo userinfo;
                        private final VideoModel video;
                        private final Byte voteType;
                        public static final Companion Companion = new Companion(null);
                        public static final int $stable = 8;
                        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                KSerializer _childSerializers$_anonymous_;
                                _childSerializers$_anonymous_ = CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel._childSerializers$_anonymous_();
                                return _childSerializers$_anonymous_;
                            }
                        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                KSerializer _childSerializers$_anonymous_$0;
                                _childSerializers$_anonymous_$0 = CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel._childSerializers$_anonymous_$0();
                                return _childSerializers$_anonymous_$0;
                            }
                        }), null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$$ExternalSyntheticLambda2
                            public final Object invoke() {
                                KSerializer _childSerializers$_anonymous_$1;
                                _childSerializers$_anonymous_$1 = CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel._childSerializers$_anonymous_$1();
                                return _childSerializers$_anonymous_$1;
                            }
                        }), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$$ExternalSyntheticLambda3
                            public final Object invoke() {
                                KSerializer _childSerializers$_anonymous_$2;
                                _childSerializers$_anonymous_$2 = CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel._childSerializers$_anonymous_$2();
                                return _childSerializers$_anonymous_$2;
                            }
                        }), null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$$ExternalSyntheticLambda4
                            public final Object invoke() {
                                KSerializer _childSerializers$_anonymous_$3;
                                _childSerializers$_anonymous_$3 = CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel._childSerializers$_anonymous_$3();
                                return _childSerializers$_anonymous_$3;
                            }
                        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$$ExternalSyntheticLambda5
                            public final Object invoke() {
                                KSerializer _childSerializers$_anonymous_$4;
                                _childSerializers$_anonymous_$4 = CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel._childSerializers$_anonymous_$4();
                                return _childSerializers$_anonymous_$4;
                            }
                        }), null, null, null, null, null, null, null, null, null};

                        public CommentModel() {
                            this((Integer) null, (Integer) null, (List) null, (List) null, (String) null, (String) null, (String) null, (Byte) null, (String) null, (Integer) null, (Long) null, (Integer) null, (List) null, (Long) null, (String) null, (Byte) null, (String) null, (Long) null, (Long) null, (Boolean) null, (Long) null, (Long) null, (Byte) null, (Integer) null, (Long) null, (String) null, (String) null, (Byte) null, (String) null, (Integer) null, (Long) null, (Byte) null, (Long) null, (String) null, (Byte) null, (Long) null, (List) null, (Long) null, (String) null, (Byte) null, (String) null, (List) null, (List) null, (TopicTag) null, (Byte) null, (Byte) null, (Long) null, (String) null, (Integer) null, (UserInfo) null, (VideoModel) null, (Byte) null, -1, 1048575, (DefaultConstructorMarker) null);
                        }

                        public final Integer component1() {
                            return this.activityId;
                        }

                        public final Integer component10() {
                            return this.downCount;
                        }

                        public final Long component11() {
                            return this.dynId;
                        }

                        public final Integer component12() {
                            return this.floor;
                        }

                        public final List<String> component13() {
                            return this.imgs;
                        }

                        public final Long component14() {
                            return this.lastReplyTime;
                        }

                        public final String component15() {
                            return this.manhuaContent;
                        }

                        public final Byte component16() {
                            return this.manhuaDisplay;
                        }

                        public final String component17() {
                            return this.manhuaDisplayContent;
                        }

                        public final Long component18() {
                            return this.merchantId;
                        }

                        public final Long component19() {
                            return this.mid;
                        }

                        public final Integer component2() {
                            return this.actualCount;
                        }

                        public final Boolean component20() {
                            return this.newType;
                        }

                        public final Long component21() {
                            return this.orderId;
                        }

                        public final Long component22() {
                            return this.parent;
                        }

                        public final Byte component23() {
                            return this.platform;
                        }

                        public final Integer component24() {
                            return this.publishSource;
                        }

                        public final Long component25() {
                            return this.publishTime;
                        }

                        public final String component26() {
                            return this.publishTimeDesc;
                        }

                        public final String component27() {
                            return this.qqContent;
                        }

                        public final Byte component28() {
                            return this.qqDisplay;
                        }

                        public final String component29() {
                            return this.qqDisplayContent;
                        }

                        public final List<UserInfo> component3() {
                            return this.atUserInfoDTOs;
                        }

                        public final Integer component30() {
                            return this.replyCount;
                        }

                        public final Long component31() {
                            return this.root;
                        }

                        public final Byte component32() {
                            return this.score;
                        }

                        public final Long component33() {
                            return this.skuId;
                        }

                        public final String component34() {
                            return this.skuSpecStr;
                        }

                        public final Byte component35() {
                            return this.state;
                        }

                        public final Long component36() {
                            return this.subCommentCount;
                        }

                        public final List<CommentModel> component37() {
                            return this.subCommentList;
                        }

                        public final Long component38() {
                            return this.subjectId;
                        }

                        public final String component39() {
                            return this.subjectName;
                        }

                        public final List<Integer> component4() {
                            return this.ats;
                        }

                        public final Byte component40() {
                            return this.subjectType;
                        }

                        public final String component41() {
                            return this.subjectUrl;
                        }

                        public final List<String> component42() {
                            return this.tags;
                        }

                        public final List<TopicModel> component43() {
                            return this.topicList;
                        }

                        public final TopicTag component44() {
                            return this.topicTag;
                        }

                        public final Byte component45() {
                            return this.type;
                        }

                        public final Byte component46() {
                            return this.typeModifyOrigin;
                        }

                        public final Long component47() {
                            return this.ugcId;
                        }

                        public final String component48() {
                            return this.uname;
                        }

                        public final Integer component49() {
                            return this.upCount;
                        }

                        public final String component5() {
                            return this.content;
                        }

                        public final UserInfo component50() {
                            return this.userinfo;
                        }

                        public final VideoModel component51() {
                            return this.video;
                        }

                        public final Byte component52() {
                            return this.voteType;
                        }

                        public final String component6() {
                            return this.crowdfundingDesc;
                        }

                        public final String component7() {
                            return this.ctime;
                        }

                        public final Byte component8() {
                            return this.display;
                        }

                        public final String component9() {
                            return this.displayMessage;
                        }

                        public final CommentModel copy(Integer num, Integer num2, List<UserInfo> list, List<Integer> list2, String str, String str2, String str3, Byte b, String str4, Integer num3, Long l, Integer num4, List<String> list3, Long l2, String str5, Byte b2, String str6, Long l3, Long l4, Boolean bool, Long l5, Long l6, Byte b3, Integer num5, Long l7, String str7, String str8, Byte b4, String str9, Integer num6, Long l8, Byte b5, Long l9, String str10, Byte b6, Long l10, List<CommentModel> list4, Long l11, String str11, Byte b7, String str12, List<String> list5, List<TopicModel> list6, TopicTag topicTag, Byte b8, Byte b9, Long l12, String str13, Integer num7, UserInfo userInfo, VideoModel videoModel, Byte b10) {
                            return new CommentModel(num, num2, list, list2, str, str2, str3, b, str4, num3, l, num4, list3, l2, str5, b2, str6, l3, l4, bool, l5, l6, b3, num5, l7, str7, str8, b4, str9, num6, l8, b5, l9, str10, b6, l10, list4, l11, str11, b7, str12, list5, list6, topicTag, b8, b9, l12, str13, num7, userInfo, videoModel, b10);
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj instanceof CommentModel) {
                                CommentModel commentModel = (CommentModel) obj;
                                return Intrinsics.areEqual(this.activityId, commentModel.activityId) && Intrinsics.areEqual(this.actualCount, commentModel.actualCount) && Intrinsics.areEqual(this.atUserInfoDTOs, commentModel.atUserInfoDTOs) && Intrinsics.areEqual(this.ats, commentModel.ats) && Intrinsics.areEqual(this.content, commentModel.content) && Intrinsics.areEqual(this.crowdfundingDesc, commentModel.crowdfundingDesc) && Intrinsics.areEqual(this.ctime, commentModel.ctime) && Intrinsics.areEqual(this.display, commentModel.display) && Intrinsics.areEqual(this.displayMessage, commentModel.displayMessage) && Intrinsics.areEqual(this.downCount, commentModel.downCount) && Intrinsics.areEqual(this.dynId, commentModel.dynId) && Intrinsics.areEqual(this.floor, commentModel.floor) && Intrinsics.areEqual(this.imgs, commentModel.imgs) && Intrinsics.areEqual(this.lastReplyTime, commentModel.lastReplyTime) && Intrinsics.areEqual(this.manhuaContent, commentModel.manhuaContent) && Intrinsics.areEqual(this.manhuaDisplay, commentModel.manhuaDisplay) && Intrinsics.areEqual(this.manhuaDisplayContent, commentModel.manhuaDisplayContent) && Intrinsics.areEqual(this.merchantId, commentModel.merchantId) && Intrinsics.areEqual(this.mid, commentModel.mid) && Intrinsics.areEqual(this.newType, commentModel.newType) && Intrinsics.areEqual(this.orderId, commentModel.orderId) && Intrinsics.areEqual(this.parent, commentModel.parent) && Intrinsics.areEqual(this.platform, commentModel.platform) && Intrinsics.areEqual(this.publishSource, commentModel.publishSource) && Intrinsics.areEqual(this.publishTime, commentModel.publishTime) && Intrinsics.areEqual(this.publishTimeDesc, commentModel.publishTimeDesc) && Intrinsics.areEqual(this.qqContent, commentModel.qqContent) && Intrinsics.areEqual(this.qqDisplay, commentModel.qqDisplay) && Intrinsics.areEqual(this.qqDisplayContent, commentModel.qqDisplayContent) && Intrinsics.areEqual(this.replyCount, commentModel.replyCount) && Intrinsics.areEqual(this.root, commentModel.root) && Intrinsics.areEqual(this.score, commentModel.score) && Intrinsics.areEqual(this.skuId, commentModel.skuId) && Intrinsics.areEqual(this.skuSpecStr, commentModel.skuSpecStr) && Intrinsics.areEqual(this.state, commentModel.state) && Intrinsics.areEqual(this.subCommentCount, commentModel.subCommentCount) && Intrinsics.areEqual(this.subCommentList, commentModel.subCommentList) && Intrinsics.areEqual(this.subjectId, commentModel.subjectId) && Intrinsics.areEqual(this.subjectName, commentModel.subjectName) && Intrinsics.areEqual(this.subjectType, commentModel.subjectType) && Intrinsics.areEqual(this.subjectUrl, commentModel.subjectUrl) && Intrinsics.areEqual(this.tags, commentModel.tags) && Intrinsics.areEqual(this.topicList, commentModel.topicList) && Intrinsics.areEqual(this.topicTag, commentModel.topicTag) && Intrinsics.areEqual(this.type, commentModel.type) && Intrinsics.areEqual(this.typeModifyOrigin, commentModel.typeModifyOrigin) && Intrinsics.areEqual(this.ugcId, commentModel.ugcId) && Intrinsics.areEqual(this.uname, commentModel.uname) && Intrinsics.areEqual(this.upCount, commentModel.upCount) && Intrinsics.areEqual(this.userinfo, commentModel.userinfo) && Intrinsics.areEqual(this.video, commentModel.video) && Intrinsics.areEqual(this.voteType, commentModel.voteType);
                            }
                            return false;
                        }

                        public int hashCode() {
                            return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.activityId == null ? 0 : this.activityId.hashCode()) * 31) + (this.actualCount == null ? 0 : this.actualCount.hashCode())) * 31) + (this.atUserInfoDTOs == null ? 0 : this.atUserInfoDTOs.hashCode())) * 31) + (this.ats == null ? 0 : this.ats.hashCode())) * 31) + (this.content == null ? 0 : this.content.hashCode())) * 31) + (this.crowdfundingDesc == null ? 0 : this.crowdfundingDesc.hashCode())) * 31) + (this.ctime == null ? 0 : this.ctime.hashCode())) * 31) + (this.display == null ? 0 : this.display.hashCode())) * 31) + (this.displayMessage == null ? 0 : this.displayMessage.hashCode())) * 31) + (this.downCount == null ? 0 : this.downCount.hashCode())) * 31) + (this.dynId == null ? 0 : this.dynId.hashCode())) * 31) + (this.floor == null ? 0 : this.floor.hashCode())) * 31) + (this.imgs == null ? 0 : this.imgs.hashCode())) * 31) + (this.lastReplyTime == null ? 0 : this.lastReplyTime.hashCode())) * 31) + (this.manhuaContent == null ? 0 : this.manhuaContent.hashCode())) * 31) + (this.manhuaDisplay == null ? 0 : this.manhuaDisplay.hashCode())) * 31) + (this.manhuaDisplayContent == null ? 0 : this.manhuaDisplayContent.hashCode())) * 31) + (this.merchantId == null ? 0 : this.merchantId.hashCode())) * 31) + (this.mid == null ? 0 : this.mid.hashCode())) * 31) + (this.newType == null ? 0 : this.newType.hashCode())) * 31) + (this.orderId == null ? 0 : this.orderId.hashCode())) * 31) + (this.parent == null ? 0 : this.parent.hashCode())) * 31) + (this.platform == null ? 0 : this.platform.hashCode())) * 31) + (this.publishSource == null ? 0 : this.publishSource.hashCode())) * 31) + (this.publishTime == null ? 0 : this.publishTime.hashCode())) * 31) + (this.publishTimeDesc == null ? 0 : this.publishTimeDesc.hashCode())) * 31) + (this.qqContent == null ? 0 : this.qqContent.hashCode())) * 31) + (this.qqDisplay == null ? 0 : this.qqDisplay.hashCode())) * 31) + (this.qqDisplayContent == null ? 0 : this.qqDisplayContent.hashCode())) * 31) + (this.replyCount == null ? 0 : this.replyCount.hashCode())) * 31) + (this.root == null ? 0 : this.root.hashCode())) * 31) + (this.score == null ? 0 : this.score.hashCode())) * 31) + (this.skuId == null ? 0 : this.skuId.hashCode())) * 31) + (this.skuSpecStr == null ? 0 : this.skuSpecStr.hashCode())) * 31) + (this.state == null ? 0 : this.state.hashCode())) * 31) + (this.subCommentCount == null ? 0 : this.subCommentCount.hashCode())) * 31) + (this.subCommentList == null ? 0 : this.subCommentList.hashCode())) * 31) + (this.subjectId == null ? 0 : this.subjectId.hashCode())) * 31) + (this.subjectName == null ? 0 : this.subjectName.hashCode())) * 31) + (this.subjectType == null ? 0 : this.subjectType.hashCode())) * 31) + (this.subjectUrl == null ? 0 : this.subjectUrl.hashCode())) * 31) + (this.tags == null ? 0 : this.tags.hashCode())) * 31) + (this.topicList == null ? 0 : this.topicList.hashCode())) * 31) + (this.topicTag == null ? 0 : this.topicTag.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.typeModifyOrigin == null ? 0 : this.typeModifyOrigin.hashCode())) * 31) + (this.ugcId == null ? 0 : this.ugcId.hashCode())) * 31) + (this.uname == null ? 0 : this.uname.hashCode())) * 31) + (this.upCount == null ? 0 : this.upCount.hashCode())) * 31) + (this.userinfo == null ? 0 : this.userinfo.hashCode())) * 31) + (this.video == null ? 0 : this.video.hashCode())) * 31) + (this.voteType != null ? this.voteType.hashCode() : 0);
                        }

                        public String toString() {
                            Integer num = this.activityId;
                            Integer num2 = this.actualCount;
                            List<UserInfo> list = this.atUserInfoDTOs;
                            List<Integer> list2 = this.ats;
                            String str = this.content;
                            String str2 = this.crowdfundingDesc;
                            String str3 = this.ctime;
                            Byte b = this.display;
                            String str4 = this.displayMessage;
                            Integer num3 = this.downCount;
                            Long l = this.dynId;
                            Integer num4 = this.floor;
                            List<String> list3 = this.imgs;
                            Long l2 = this.lastReplyTime;
                            String str5 = this.manhuaContent;
                            Byte b2 = this.manhuaDisplay;
                            String str6 = this.manhuaDisplayContent;
                            Long l3 = this.merchantId;
                            Long l4 = this.mid;
                            Boolean bool = this.newType;
                            Long l5 = this.orderId;
                            Long l6 = this.parent;
                            Byte b3 = this.platform;
                            Integer num5 = this.publishSource;
                            Long l7 = this.publishTime;
                            String str7 = this.publishTimeDesc;
                            String str8 = this.qqContent;
                            Byte b4 = this.qqDisplay;
                            String str9 = this.qqDisplayContent;
                            Integer num6 = this.replyCount;
                            Long l8 = this.root;
                            Byte b5 = this.score;
                            Long l9 = this.skuId;
                            String str10 = this.skuSpecStr;
                            Byte b6 = this.state;
                            Long l10 = this.subCommentCount;
                            List<CommentModel> list4 = this.subCommentList;
                            Long l11 = this.subjectId;
                            String str11 = this.subjectName;
                            Byte b7 = this.subjectType;
                            String str12 = this.subjectUrl;
                            List<String> list5 = this.tags;
                            List<TopicModel> list6 = this.topicList;
                            TopicTag topicTag = this.topicTag;
                            Byte b8 = this.type;
                            Byte b9 = this.typeModifyOrigin;
                            Long l12 = this.ugcId;
                            String str13 = this.uname;
                            Integer num7 = this.upCount;
                            UserInfo userInfo = this.userinfo;
                            VideoModel videoModel = this.video;
                            return "CommentModel(activityId=" + num + ", actualCount=" + num2 + ", atUserInfoDTOs=" + list + ", ats=" + list2 + ", content=" + str + ", crowdfundingDesc=" + str2 + ", ctime=" + str3 + ", display=" + b + ", displayMessage=" + str4 + ", downCount=" + num3 + ", dynId=" + l + ", floor=" + num4 + ", imgs=" + list3 + ", lastReplyTime=" + l2 + ", manhuaContent=" + str5 + ", manhuaDisplay=" + b2 + ", manhuaDisplayContent=" + str6 + ", merchantId=" + l3 + ", mid=" + l4 + ", newType=" + bool + ", orderId=" + l5 + ", parent=" + l6 + ", platform=" + b3 + ", publishSource=" + num5 + ", publishTime=" + l7 + ", publishTimeDesc=" + str7 + ", qqContent=" + str8 + ", qqDisplay=" + b4 + ", qqDisplayContent=" + str9 + ", replyCount=" + num6 + ", root=" + l8 + ", score=" + b5 + ", skuId=" + l9 + ", skuSpecStr=" + str10 + ", state=" + b6 + ", subCommentCount=" + l10 + ", subCommentList=" + list4 + ", subjectId=" + l11 + ", subjectName=" + str11 + ", subjectType=" + b7 + ", subjectUrl=" + str12 + ", tags=" + list5 + ", topicList=" + list6 + ", topicTag=" + topicTag + ", type=" + b8 + ", typeModifyOrigin=" + b9 + ", ugcId=" + l12 + ", uname=" + str13 + ", upCount=" + num7 + ", userinfo=" + userInfo + ", video=" + videoModel + ", voteType=" + this.voteType + ")";
                        }

                        /* compiled from: CommentInfoApiService.kt */
                        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class Companion {
                            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                this();
                            }

                            private Companion() {
                            }

                            public final KSerializer<CommentModel> serializer() {
                                return CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$$serializer.INSTANCE;
                            }
                        }

                        public /* synthetic */ CommentModel(int seen0, int seen1, Integer activityId, Integer actualCount, List atUserInfoDTOs, List ats, String content, String crowdfundingDesc, String ctime, Byte display, String displayMessage, Integer downCount, Long dynId, Integer floor, List imgs, Long lastReplyTime, String manhuaContent, Byte manhuaDisplay, String manhuaDisplayContent, Long merchantId, Long mid, Boolean newType, Long orderId, Long parent, Byte platform, Integer publishSource, Long publishTime, String publishTimeDesc, String qqContent, Byte qqDisplay, String qqDisplayContent, Integer replyCount, Long root, Byte score, Long skuId, String skuSpecStr, Byte state, Long subCommentCount, List subCommentList, Long subjectId, String subjectName, Byte subjectType, String subjectUrl, List tags, List topicList, TopicTag topicTag, Byte type, Byte typeModifyOrigin, Long ugcId, String uname, Integer upCount, UserInfo userinfo, VideoModel video, Byte voteType, SerializationConstructorMarker serializationConstructorMarker) {
                            if ((seen0 & 1) == 0) {
                                this.activityId = null;
                            } else {
                                this.activityId = activityId;
                            }
                            if ((seen0 & 2) == 0) {
                                this.actualCount = null;
                            } else {
                                this.actualCount = actualCount;
                            }
                            if ((seen0 & 4) == 0) {
                                this.atUserInfoDTOs = null;
                            } else {
                                this.atUserInfoDTOs = atUserInfoDTOs;
                            }
                            if ((seen0 & 8) == 0) {
                                this.ats = null;
                            } else {
                                this.ats = ats;
                            }
                            if ((seen0 & 16) == 0) {
                                this.content = null;
                            } else {
                                this.content = content;
                            }
                            if ((seen0 & 32) == 0) {
                                this.crowdfundingDesc = null;
                            } else {
                                this.crowdfundingDesc = crowdfundingDesc;
                            }
                            if ((seen0 & 64) == 0) {
                                this.ctime = null;
                            } else {
                                this.ctime = ctime;
                            }
                            if ((seen0 & 128) == 0) {
                                this.display = null;
                            } else {
                                this.display = display;
                            }
                            if ((seen0 & 256) == 0) {
                                this.displayMessage = null;
                            } else {
                                this.displayMessage = displayMessage;
                            }
                            if ((seen0 & 512) == 0) {
                                this.downCount = null;
                            } else {
                                this.downCount = downCount;
                            }
                            if ((seen0 & 1024) == 0) {
                                this.dynId = null;
                            } else {
                                this.dynId = dynId;
                            }
                            if ((seen0 & 2048) == 0) {
                                this.floor = null;
                            } else {
                                this.floor = floor;
                            }
                            if ((seen0 & 4096) == 0) {
                                this.imgs = null;
                            } else {
                                this.imgs = imgs;
                            }
                            if ((seen0 & 8192) == 0) {
                                this.lastReplyTime = null;
                            } else {
                                this.lastReplyTime = lastReplyTime;
                            }
                            if ((seen0 & 16384) == 0) {
                                this.manhuaContent = null;
                            } else {
                                this.manhuaContent = manhuaContent;
                            }
                            if ((seen0 & 32768) == 0) {
                                this.manhuaDisplay = null;
                            } else {
                                this.manhuaDisplay = manhuaDisplay;
                            }
                            if ((seen0 & 65536) == 0) {
                                this.manhuaDisplayContent = null;
                            } else {
                                this.manhuaDisplayContent = manhuaDisplayContent;
                            }
                            if ((seen0 & 131072) == 0) {
                                this.merchantId = null;
                            } else {
                                this.merchantId = merchantId;
                            }
                            if ((seen0 & 262144) == 0) {
                                this.mid = null;
                            } else {
                                this.mid = mid;
                            }
                            if ((seen0 & 524288) == 0) {
                                this.newType = null;
                            } else {
                                this.newType = newType;
                            }
                            if ((seen0 & 1048576) == 0) {
                                this.orderId = null;
                            } else {
                                this.orderId = orderId;
                            }
                            if ((seen0 & 2097152) == 0) {
                                this.parent = null;
                            } else {
                                this.parent = parent;
                            }
                            if ((seen0 & 4194304) == 0) {
                                this.platform = null;
                            } else {
                                this.platform = platform;
                            }
                            if ((seen0 & 8388608) == 0) {
                                this.publishSource = null;
                            } else {
                                this.publishSource = publishSource;
                            }
                            if ((seen0 & 16777216) == 0) {
                                this.publishTime = null;
                            } else {
                                this.publishTime = publishTime;
                            }
                            if ((seen0 & 33554432) == 0) {
                                this.publishTimeDesc = null;
                            } else {
                                this.publishTimeDesc = publishTimeDesc;
                            }
                            if ((seen0 & 67108864) == 0) {
                                this.qqContent = null;
                            } else {
                                this.qqContent = qqContent;
                            }
                            if ((seen0 & 134217728) == 0) {
                                this.qqDisplay = null;
                            } else {
                                this.qqDisplay = qqDisplay;
                            }
                            if ((seen0 & 268435456) == 0) {
                                this.qqDisplayContent = null;
                            } else {
                                this.qqDisplayContent = qqDisplayContent;
                            }
                            if ((seen0 & 536870912) == 0) {
                                this.replyCount = null;
                            } else {
                                this.replyCount = replyCount;
                            }
                            if ((seen0 & 1073741824) == 0) {
                                this.root = null;
                            } else {
                                this.root = root;
                            }
                            if ((seen0 & Integer.MIN_VALUE) == 0) {
                                this.score = null;
                            } else {
                                this.score = score;
                            }
                            if ((seen1 & 1) == 0) {
                                this.skuId = null;
                            } else {
                                this.skuId = skuId;
                            }
                            if ((seen1 & 2) == 0) {
                                this.skuSpecStr = null;
                            } else {
                                this.skuSpecStr = skuSpecStr;
                            }
                            if ((seen1 & 4) == 0) {
                                this.state = null;
                            } else {
                                this.state = state;
                            }
                            if ((seen1 & 8) == 0) {
                                this.subCommentCount = null;
                            } else {
                                this.subCommentCount = subCommentCount;
                            }
                            if ((seen1 & 16) == 0) {
                                this.subCommentList = null;
                            } else {
                                this.subCommentList = subCommentList;
                            }
                            if ((seen1 & 32) == 0) {
                                this.subjectId = null;
                            } else {
                                this.subjectId = subjectId;
                            }
                            if ((seen1 & 64) == 0) {
                                this.subjectName = null;
                            } else {
                                this.subjectName = subjectName;
                            }
                            if ((seen1 & 128) == 0) {
                                this.subjectType = null;
                            } else {
                                this.subjectType = subjectType;
                            }
                            if ((seen1 & 256) == 0) {
                                this.subjectUrl = null;
                            } else {
                                this.subjectUrl = subjectUrl;
                            }
                            if ((seen1 & 512) == 0) {
                                this.tags = null;
                            } else {
                                this.tags = tags;
                            }
                            if ((seen1 & 1024) == 0) {
                                this.topicList = null;
                            } else {
                                this.topicList = topicList;
                            }
                            if ((seen1 & 2048) == 0) {
                                this.topicTag = null;
                            } else {
                                this.topicTag = topicTag;
                            }
                            if ((seen1 & 4096) == 0) {
                                this.type = null;
                            } else {
                                this.type = type;
                            }
                            if ((seen1 & 8192) == 0) {
                                this.typeModifyOrigin = null;
                            } else {
                                this.typeModifyOrigin = typeModifyOrigin;
                            }
                            if ((seen1 & 16384) == 0) {
                                this.ugcId = null;
                            } else {
                                this.ugcId = ugcId;
                            }
                            if ((seen1 & 32768) == 0) {
                                this.uname = null;
                            } else {
                                this.uname = uname;
                            }
                            if ((seen1 & 65536) == 0) {
                                this.upCount = null;
                            } else {
                                this.upCount = upCount;
                            }
                            if ((seen1 & 131072) == 0) {
                                this.userinfo = null;
                            } else {
                                this.userinfo = userinfo;
                            }
                            if ((seen1 & 262144) == 0) {
                                this.video = null;
                            } else {
                                this.video = video;
                            }
                            if ((seen1 & 524288) == 0) {
                                this.voteType = null;
                            } else {
                                this.voteType = voteType;
                            }
                        }

                        public CommentModel(Integer activityId, Integer actualCount, List<UserInfo> list, List<Integer> list2, String content, String crowdfundingDesc, String ctime, Byte display, String displayMessage, Integer downCount, Long dynId, Integer floor, List<String> list3, Long lastReplyTime, String manhuaContent, Byte manhuaDisplay, String manhuaDisplayContent, Long merchantId, Long mid, Boolean newType, Long orderId, Long parent, Byte platform, Integer publishSource, Long publishTime, String publishTimeDesc, String qqContent, Byte qqDisplay, String qqDisplayContent, Integer replyCount, Long root, Byte score, Long skuId, String skuSpecStr, Byte state, Long subCommentCount, List<CommentModel> list4, Long subjectId, String subjectName, Byte subjectType, String subjectUrl, List<String> list5, List<TopicModel> list6, TopicTag topicTag, Byte type, Byte typeModifyOrigin, Long ugcId, String uname, Integer upCount, UserInfo userinfo, VideoModel video, Byte voteType) {
                            this.activityId = activityId;
                            this.actualCount = actualCount;
                            this.atUserInfoDTOs = list;
                            this.ats = list2;
                            this.content = content;
                            this.crowdfundingDesc = crowdfundingDesc;
                            this.ctime = ctime;
                            this.display = display;
                            this.displayMessage = displayMessage;
                            this.downCount = downCount;
                            this.dynId = dynId;
                            this.floor = floor;
                            this.imgs = list3;
                            this.lastReplyTime = lastReplyTime;
                            this.manhuaContent = manhuaContent;
                            this.manhuaDisplay = manhuaDisplay;
                            this.manhuaDisplayContent = manhuaDisplayContent;
                            this.merchantId = merchantId;
                            this.mid = mid;
                            this.newType = newType;
                            this.orderId = orderId;
                            this.parent = parent;
                            this.platform = platform;
                            this.publishSource = publishSource;
                            this.publishTime = publishTime;
                            this.publishTimeDesc = publishTimeDesc;
                            this.qqContent = qqContent;
                            this.qqDisplay = qqDisplay;
                            this.qqDisplayContent = qqDisplayContent;
                            this.replyCount = replyCount;
                            this.root = root;
                            this.score = score;
                            this.skuId = skuId;
                            this.skuSpecStr = skuSpecStr;
                            this.state = state;
                            this.subCommentCount = subCommentCount;
                            this.subCommentList = list4;
                            this.subjectId = subjectId;
                            this.subjectName = subjectName;
                            this.subjectType = subjectType;
                            this.subjectUrl = subjectUrl;
                            this.tags = list5;
                            this.topicList = list6;
                            this.topicTag = topicTag;
                            this.type = type;
                            this.typeModifyOrigin = typeModifyOrigin;
                            this.ugcId = ugcId;
                            this.uname = uname;
                            this.upCount = upCount;
                            this.userinfo = userinfo;
                            this.video = video;
                            this.voteType = voteType;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                            return new ArrayListSerializer(CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$$serializer.INSTANCE);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                            return new ArrayListSerializer(IntSerializer.INSTANCE);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
                            return new ArrayListSerializer(StringSerializer.INSTANCE);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
                            return new ArrayListSerializer(CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$$serializer.INSTANCE);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
                            return new ArrayListSerializer(StringSerializer.INSTANCE);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$4() {
                            return new ArrayListSerializer(CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$TopicModel$$serializer.INSTANCE);
                        }

                        @JvmStatic
                        public static final /* synthetic */ void write$Self$product_details_page_debug(CommentModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
                            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.activityId != null) {
                                output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.activityId);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.actualCount != null) {
                                output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.actualCount);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.atUserInfoDTOs != null) {
                                output.encodeNullableSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.atUserInfoDTOs);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.ats != null) {
                                output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.ats);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.content != null) {
                                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.content);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.crowdfundingDesc != null) {
                                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.crowdfundingDesc);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.ctime != null) {
                                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.ctime);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.display != null) {
                                output.encodeNullableSerializableElement(serialDesc, 7, ByteSerializer.INSTANCE, self.display);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.displayMessage != null) {
                                output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.displayMessage);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.downCount != null) {
                                output.encodeNullableSerializableElement(serialDesc, 9, IntSerializer.INSTANCE, self.downCount);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.dynId != null) {
                                output.encodeNullableSerializableElement(serialDesc, 10, LongSerializer.INSTANCE, self.dynId);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.floor != null) {
                                output.encodeNullableSerializableElement(serialDesc, 11, IntSerializer.INSTANCE, self.floor);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.imgs != null) {
                                output.encodeNullableSerializableElement(serialDesc, 12, lazyArr[12].getValue(), self.imgs);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.lastReplyTime != null) {
                                output.encodeNullableSerializableElement(serialDesc, 13, LongSerializer.INSTANCE, self.lastReplyTime);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 14) || self.manhuaContent != null) {
                                output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.manhuaContent);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 15) || self.manhuaDisplay != null) {
                                output.encodeNullableSerializableElement(serialDesc, 15, ByteSerializer.INSTANCE, self.manhuaDisplay);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 16) || self.manhuaDisplayContent != null) {
                                output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.manhuaDisplayContent);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 17) || self.merchantId != null) {
                                output.encodeNullableSerializableElement(serialDesc, 17, LongSerializer.INSTANCE, self.merchantId);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 18) || self.mid != null) {
                                output.encodeNullableSerializableElement(serialDesc, 18, LongSerializer.INSTANCE, self.mid);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 19) || self.newType != null) {
                                output.encodeNullableSerializableElement(serialDesc, 19, BooleanSerializer.INSTANCE, self.newType);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 20) || self.orderId != null) {
                                output.encodeNullableSerializableElement(serialDesc, 20, LongSerializer.INSTANCE, self.orderId);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 21) || self.parent != null) {
                                output.encodeNullableSerializableElement(serialDesc, 21, LongSerializer.INSTANCE, self.parent);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 22) || self.platform != null) {
                                output.encodeNullableSerializableElement(serialDesc, 22, ByteSerializer.INSTANCE, self.platform);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 23) || self.publishSource != null) {
                                output.encodeNullableSerializableElement(serialDesc, 23, IntSerializer.INSTANCE, self.publishSource);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 24) || self.publishTime != null) {
                                output.encodeNullableSerializableElement(serialDesc, 24, LongSerializer.INSTANCE, self.publishTime);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 25) || self.publishTimeDesc != null) {
                                output.encodeNullableSerializableElement(serialDesc, 25, StringSerializer.INSTANCE, self.publishTimeDesc);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 26) || self.qqContent != null) {
                                output.encodeNullableSerializableElement(serialDesc, 26, StringSerializer.INSTANCE, self.qqContent);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 27) || self.qqDisplay != null) {
                                output.encodeNullableSerializableElement(serialDesc, 27, ByteSerializer.INSTANCE, self.qqDisplay);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 28) || self.qqDisplayContent != null) {
                                output.encodeNullableSerializableElement(serialDesc, 28, StringSerializer.INSTANCE, self.qqDisplayContent);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 29) || self.replyCount != null) {
                                output.encodeNullableSerializableElement(serialDesc, 29, IntSerializer.INSTANCE, self.replyCount);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 30) || self.root != null) {
                                output.encodeNullableSerializableElement(serialDesc, 30, LongSerializer.INSTANCE, self.root);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 31) || self.score != null) {
                                output.encodeNullableSerializableElement(serialDesc, 31, ByteSerializer.INSTANCE, self.score);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 32) || self.skuId != null) {
                                output.encodeNullableSerializableElement(serialDesc, 32, LongSerializer.INSTANCE, self.skuId);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 33) || self.skuSpecStr != null) {
                                output.encodeNullableSerializableElement(serialDesc, 33, StringSerializer.INSTANCE, self.skuSpecStr);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 34) || self.state != null) {
                                output.encodeNullableSerializableElement(serialDesc, 34, ByteSerializer.INSTANCE, self.state);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 35) || self.subCommentCount != null) {
                                output.encodeNullableSerializableElement(serialDesc, 35, LongSerializer.INSTANCE, self.subCommentCount);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 36) || self.subCommentList != null) {
                                output.encodeNullableSerializableElement(serialDesc, 36, lazyArr[36].getValue(), self.subCommentList);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 37) || self.subjectId != null) {
                                output.encodeNullableSerializableElement(serialDesc, 37, LongSerializer.INSTANCE, self.subjectId);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 38) || self.subjectName != null) {
                                output.encodeNullableSerializableElement(serialDesc, 38, StringSerializer.INSTANCE, self.subjectName);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 39) || self.subjectType != null) {
                                output.encodeNullableSerializableElement(serialDesc, 39, ByteSerializer.INSTANCE, self.subjectType);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 40) || self.subjectUrl != null) {
                                output.encodeNullableSerializableElement(serialDesc, 40, StringSerializer.INSTANCE, self.subjectUrl);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 41) || self.tags != null) {
                                output.encodeNullableSerializableElement(serialDesc, 41, lazyArr[41].getValue(), self.tags);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 42) || self.topicList != null) {
                                output.encodeNullableSerializableElement(serialDesc, 42, lazyArr[42].getValue(), self.topicList);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 43) || self.topicTag != null) {
                                output.encodeNullableSerializableElement(serialDesc, 43, CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$TopicTag$$serializer.INSTANCE, self.topicTag);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 44) || self.type != null) {
                                output.encodeNullableSerializableElement(serialDesc, 44, ByteSerializer.INSTANCE, self.type);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 45) || self.typeModifyOrigin != null) {
                                output.encodeNullableSerializableElement(serialDesc, 45, ByteSerializer.INSTANCE, self.typeModifyOrigin);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 46) || self.ugcId != null) {
                                output.encodeNullableSerializableElement(serialDesc, 46, LongSerializer.INSTANCE, self.ugcId);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 47) || self.uname != null) {
                                output.encodeNullableSerializableElement(serialDesc, 47, StringSerializer.INSTANCE, self.uname);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 48) || self.upCount != null) {
                                output.encodeNullableSerializableElement(serialDesc, 48, IntSerializer.INSTANCE, self.upCount);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 49) || self.userinfo != null) {
                                output.encodeNullableSerializableElement(serialDesc, 49, CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$$serializer.INSTANCE, self.userinfo);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 50) || self.video != null) {
                                output.encodeNullableSerializableElement(serialDesc, 50, CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$VideoModel$$serializer.INSTANCE, self.video);
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 51) || self.voteType != null) {
                                output.encodeNullableSerializableElement(serialDesc, 51, ByteSerializer.INSTANCE, self.voteType);
                            }
                        }

                        public /* synthetic */ CommentModel(Integer num, Integer num2, List list, List list2, String str, String str2, String str3, Byte b, String str4, Integer num3, Long l, Integer num4, List list3, Long l2, String str5, Byte b2, String str6, Long l3, Long l4, Boolean bool, Long l5, Long l6, Byte b3, Integer num5, Long l7, String str7, String str8, Byte b4, String str9, Integer num6, Long l8, Byte b5, Long l9, String str10, Byte b6, Long l10, List list4, Long l11, String str11, Byte b7, String str12, List list5, List list6, TopicTag topicTag, Byte b8, Byte b9, Long l12, String str13, Integer num7, UserInfo userInfo, VideoModel videoModel, Byte b10, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : list2, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : b, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : num3, (i & 1024) != 0 ? null : l, (i & 2048) != 0 ? null : num4, (i & 4096) != 0 ? null : list3, (i & 8192) != 0 ? null : l2, (i & 16384) != 0 ? null : str5, (i & 32768) != 0 ? null : b2, (i & 65536) != 0 ? null : str6, (i & 131072) != 0 ? null : l3, (i & 262144) != 0 ? null : l4, (i & 524288) != 0 ? null : bool, (i & 1048576) != 0 ? null : l5, (i & 2097152) != 0 ? null : l6, (i & 4194304) != 0 ? null : b3, (i & 8388608) != 0 ? null : num5, (i & 16777216) != 0 ? null : l7, (i & 33554432) != 0 ? null : str7, (i & 67108864) != 0 ? null : str8, (i & 134217728) != 0 ? null : b4, (i & 268435456) != 0 ? null : str9, (i & 536870912) != 0 ? null : num6, (i & 1073741824) != 0 ? null : l8, (i & Integer.MIN_VALUE) != 0 ? null : b5, (i2 & 1) != 0 ? null : l9, (i2 & 2) != 0 ? null : str10, (i2 & 4) != 0 ? null : b6, (i2 & 8) != 0 ? null : l10, (i2 & 16) != 0 ? null : list4, (i2 & 32) != 0 ? null : l11, (i2 & 64) != 0 ? null : str11, (i2 & 128) != 0 ? null : b7, (i2 & 256) != 0 ? null : str12, (i2 & 512) != 0 ? null : list5, (i2 & 1024) != 0 ? null : list6, (i2 & 2048) != 0 ? null : topicTag, (i2 & 4096) != 0 ? null : b8, (i2 & 8192) != 0 ? null : b9, (i2 & 16384) != 0 ? null : l12, (i2 & 32768) != 0 ? null : str13, (i2 & 65536) != 0 ? null : num7, (i2 & 131072) != 0 ? null : userInfo, (i2 & 262144) != 0 ? null : videoModel, (i2 & 524288) != 0 ? null : b10);
                        }

                        public final Integer getActivityId() {
                            return this.activityId;
                        }

                        public final Integer getActualCount() {
                            return this.actualCount;
                        }

                        public final List<UserInfo> getAtUserInfoDTOs() {
                            return this.atUserInfoDTOs;
                        }

                        public final List<Integer> getAts() {
                            return this.ats;
                        }

                        public final String getContent() {
                            return this.content;
                        }

                        public final String getCrowdfundingDesc() {
                            return this.crowdfundingDesc;
                        }

                        public final String getCtime() {
                            return this.ctime;
                        }

                        public final Byte getDisplay() {
                            return this.display;
                        }

                        public final String getDisplayMessage() {
                            return this.displayMessage;
                        }

                        public final Integer getDownCount() {
                            return this.downCount;
                        }

                        public final Long getDynId() {
                            return this.dynId;
                        }

                        public final Integer getFloor() {
                            return this.floor;
                        }

                        public final List<String> getImgs() {
                            return this.imgs;
                        }

                        public final Long getLastReplyTime() {
                            return this.lastReplyTime;
                        }

                        public final String getManhuaContent() {
                            return this.manhuaContent;
                        }

                        public final Byte getManhuaDisplay() {
                            return this.manhuaDisplay;
                        }

                        public final String getManhuaDisplayContent() {
                            return this.manhuaDisplayContent;
                        }

                        public final Long getMerchantId() {
                            return this.merchantId;
                        }

                        public final Long getMid() {
                            return this.mid;
                        }

                        public final Boolean getNewType() {
                            return this.newType;
                        }

                        public final Long getOrderId() {
                            return this.orderId;
                        }

                        public final Long getParent() {
                            return this.parent;
                        }

                        public final Byte getPlatform() {
                            return this.platform;
                        }

                        public final Integer getPublishSource() {
                            return this.publishSource;
                        }

                        public final Long getPublishTime() {
                            return this.publishTime;
                        }

                        public final String getPublishTimeDesc() {
                            return this.publishTimeDesc;
                        }

                        public final String getQqContent() {
                            return this.qqContent;
                        }

                        public final Byte getQqDisplay() {
                            return this.qqDisplay;
                        }

                        public final String getQqDisplayContent() {
                            return this.qqDisplayContent;
                        }

                        public final Integer getReplyCount() {
                            return this.replyCount;
                        }

                        public final Long getRoot() {
                            return this.root;
                        }

                        public final Byte getScore() {
                            return this.score;
                        }

                        public final Long getSkuId() {
                            return this.skuId;
                        }

                        public final String getSkuSpecStr() {
                            return this.skuSpecStr;
                        }

                        public final Byte getState() {
                            return this.state;
                        }

                        public final Long getSubCommentCount() {
                            return this.subCommentCount;
                        }

                        public final List<CommentModel> getSubCommentList() {
                            return this.subCommentList;
                        }

                        public final Long getSubjectId() {
                            return this.subjectId;
                        }

                        public final String getSubjectName() {
                            return this.subjectName;
                        }

                        public final Byte getSubjectType() {
                            return this.subjectType;
                        }

                        public final String getSubjectUrl() {
                            return this.subjectUrl;
                        }

                        public final List<String> getTags() {
                            return this.tags;
                        }

                        public final List<TopicModel> getTopicList() {
                            return this.topicList;
                        }

                        public final TopicTag getTopicTag() {
                            return this.topicTag;
                        }

                        public final Byte getType() {
                            return this.type;
                        }

                        public final Byte getTypeModifyOrigin() {
                            return this.typeModifyOrigin;
                        }

                        public final Long getUgcId() {
                            return this.ugcId;
                        }

                        public final String getUname() {
                            return this.uname;
                        }

                        public final Integer getUpCount() {
                            return this.upCount;
                        }

                        public final UserInfo getUserinfo() {
                            return this.userinfo;
                        }

                        public final VideoModel getVideo() {
                            return this.video;
                        }

                        /* compiled from: CommentInfoApiService.kt */
                        @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 s2\u00020\u0001:\u0004pqrsB³\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b!\u0010\"B\u0095\u0002\b\u0010\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\u0010$\u001a\u0004\u0018\u00010%¢\u0006\u0004\b!\u0010&J\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010O\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010S\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00107J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010U\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00107J\u000b\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0010\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010]\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010^\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010 HÆ\u0003Jº\u0002\u0010b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 HÆ\u0001¢\u0006\u0002\u0010cJ\u0013\u0010d\u001a\u00020\u000b2\b\u0010e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010f\u001a\u00020\u0003HÖ\u0001J\t\u0010g\u001a\u00020\u0005HÖ\u0001J%\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020\u00002\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020nH\u0001¢\u0006\u0002\boR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010)\u001a\u0004\b-\u0010(R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010+R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010)\u001a\u0004\b/\u0010(R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010+R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u00102\u001a\u0004\b4\u00101R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010+R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u00108\u001a\u0004\b6\u00107R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010+R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u00108\u001a\u0004\b:\u00107R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010+R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010)\u001a\u0004\b>\u0010(R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u0010+R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b@\u0010+R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bA\u0010+R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010)\u001a\u0004\bB\u0010(R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u00102\u001a\u0004\bC\u00101R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bD\u0010+R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bE\u0010+R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bF\u0010+R\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bG\u0010H¨\u0006t"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo;", "", "attention", "", "avatar", "", "avatarIcon", "avatarIdentity", "decorateImg", "fans", "followed", "", "level", "merchant", "merchantIcon", "merchantId", "", "merchantUrl", "mid", "nicknameColor", "official", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$OfficialModel;", "relation", "sex", "sign", "spaceUrl", "subjectRelation", "supportFollowAction", "uname", "name", "userName", "vip", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$VipModel;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$OfficialModel;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$VipModel;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$OfficialModel;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$VipModel;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAttention", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAvatar", "()Ljava/lang/String;", "getAvatarIcon", "getAvatarIdentity", "getDecorateImg", "getFans", "getFollowed", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLevel", "getMerchant", "getMerchantIcon", "getMerchantId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMerchantUrl", "getMid", "getNicknameColor", "getOfficial", "()Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$OfficialModel;", "getRelation", "getSex", "getSign", "getSpaceUrl", "getSubjectRelation", "getSupportFollowAction", "getUname", "getName", "getUserName", "getVip", "()Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$VipModel;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$OfficialModel;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$VipModel;)Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "OfficialModel", "VipModel", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        @Serializable
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class UserInfo {
                            public static final int $stable = 0;
                            public static final Companion Companion = new Companion(null);
                            private final Integer attention;
                            private final String avatar;
                            private final String avatarIcon;
                            private final Integer avatarIdentity;
                            private final String decorateImg;
                            private final Integer fans;
                            private final Boolean followed;
                            private final String level;
                            private final Boolean merchant;
                            private final String merchantIcon;
                            private final Long merchantId;
                            private final String merchantUrl;
                            private final Long mid;
                            private final String name;
                            private final String nicknameColor;
                            private final OfficialModel official;
                            private final Integer relation;
                            private final String sex;
                            private final String sign;
                            private final String spaceUrl;
                            private final Integer subjectRelation;
                            private final Boolean supportFollowAction;
                            private final String uname;
                            private final String userName;
                            private final VipModel vip;

                            public UserInfo() {
                                this((Integer) null, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, (Boolean) null, (String) null, (Boolean) null, (String) null, (Long) null, (String) null, (Long) null, (String) null, (OfficialModel) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Boolean) null, (String) null, (String) null, (String) null, (VipModel) null, 33554431, (DefaultConstructorMarker) null);
                            }

                            public final Integer component1() {
                                return this.attention;
                            }

                            public final String component10() {
                                return this.merchantIcon;
                            }

                            public final Long component11() {
                                return this.merchantId;
                            }

                            public final String component12() {
                                return this.merchantUrl;
                            }

                            public final Long component13() {
                                return this.mid;
                            }

                            public final String component14() {
                                return this.nicknameColor;
                            }

                            public final OfficialModel component15() {
                                return this.official;
                            }

                            public final Integer component16() {
                                return this.relation;
                            }

                            public final String component17() {
                                return this.sex;
                            }

                            public final String component18() {
                                return this.sign;
                            }

                            public final String component19() {
                                return this.spaceUrl;
                            }

                            public final String component2() {
                                return this.avatar;
                            }

                            public final Integer component20() {
                                return this.subjectRelation;
                            }

                            public final Boolean component21() {
                                return this.supportFollowAction;
                            }

                            public final String component22() {
                                return this.uname;
                            }

                            public final String component23() {
                                return this.name;
                            }

                            public final String component24() {
                                return this.userName;
                            }

                            public final VipModel component25() {
                                return this.vip;
                            }

                            public final String component3() {
                                return this.avatarIcon;
                            }

                            public final Integer component4() {
                                return this.avatarIdentity;
                            }

                            public final String component5() {
                                return this.decorateImg;
                            }

                            public final Integer component6() {
                                return this.fans;
                            }

                            public final Boolean component7() {
                                return this.followed;
                            }

                            public final String component8() {
                                return this.level;
                            }

                            public final Boolean component9() {
                                return this.merchant;
                            }

                            public final UserInfo copy(Integer num, String str, String str2, Integer num2, String str3, Integer num3, Boolean bool, String str4, Boolean bool2, String str5, Long l, String str6, Long l2, String str7, OfficialModel officialModel, Integer num4, String str8, String str9, String str10, Integer num5, Boolean bool3, String str11, String str12, String str13, VipModel vipModel) {
                                return new UserInfo(num, str, str2, num2, str3, num3, bool, str4, bool2, str5, l, str6, l2, str7, officialModel, num4, str8, str9, str10, num5, bool3, str11, str12, str13, vipModel);
                            }

                            public boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj instanceof UserInfo) {
                                    UserInfo userInfo = (UserInfo) obj;
                                    return Intrinsics.areEqual(this.attention, userInfo.attention) && Intrinsics.areEqual(this.avatar, userInfo.avatar) && Intrinsics.areEqual(this.avatarIcon, userInfo.avatarIcon) && Intrinsics.areEqual(this.avatarIdentity, userInfo.avatarIdentity) && Intrinsics.areEqual(this.decorateImg, userInfo.decorateImg) && Intrinsics.areEqual(this.fans, userInfo.fans) && Intrinsics.areEqual(this.followed, userInfo.followed) && Intrinsics.areEqual(this.level, userInfo.level) && Intrinsics.areEqual(this.merchant, userInfo.merchant) && Intrinsics.areEqual(this.merchantIcon, userInfo.merchantIcon) && Intrinsics.areEqual(this.merchantId, userInfo.merchantId) && Intrinsics.areEqual(this.merchantUrl, userInfo.merchantUrl) && Intrinsics.areEqual(this.mid, userInfo.mid) && Intrinsics.areEqual(this.nicknameColor, userInfo.nicknameColor) && Intrinsics.areEqual(this.official, userInfo.official) && Intrinsics.areEqual(this.relation, userInfo.relation) && Intrinsics.areEqual(this.sex, userInfo.sex) && Intrinsics.areEqual(this.sign, userInfo.sign) && Intrinsics.areEqual(this.spaceUrl, userInfo.spaceUrl) && Intrinsics.areEqual(this.subjectRelation, userInfo.subjectRelation) && Intrinsics.areEqual(this.supportFollowAction, userInfo.supportFollowAction) && Intrinsics.areEqual(this.uname, userInfo.uname) && Intrinsics.areEqual(this.name, userInfo.name) && Intrinsics.areEqual(this.userName, userInfo.userName) && Intrinsics.areEqual(this.vip, userInfo.vip);
                                }
                                return false;
                            }

                            public int hashCode() {
                                return ((((((((((((((((((((((((((((((((((((((((((((((((this.attention == null ? 0 : this.attention.hashCode()) * 31) + (this.avatar == null ? 0 : this.avatar.hashCode())) * 31) + (this.avatarIcon == null ? 0 : this.avatarIcon.hashCode())) * 31) + (this.avatarIdentity == null ? 0 : this.avatarIdentity.hashCode())) * 31) + (this.decorateImg == null ? 0 : this.decorateImg.hashCode())) * 31) + (this.fans == null ? 0 : this.fans.hashCode())) * 31) + (this.followed == null ? 0 : this.followed.hashCode())) * 31) + (this.level == null ? 0 : this.level.hashCode())) * 31) + (this.merchant == null ? 0 : this.merchant.hashCode())) * 31) + (this.merchantIcon == null ? 0 : this.merchantIcon.hashCode())) * 31) + (this.merchantId == null ? 0 : this.merchantId.hashCode())) * 31) + (this.merchantUrl == null ? 0 : this.merchantUrl.hashCode())) * 31) + (this.mid == null ? 0 : this.mid.hashCode())) * 31) + (this.nicknameColor == null ? 0 : this.nicknameColor.hashCode())) * 31) + (this.official == null ? 0 : this.official.hashCode())) * 31) + (this.relation == null ? 0 : this.relation.hashCode())) * 31) + (this.sex == null ? 0 : this.sex.hashCode())) * 31) + (this.sign == null ? 0 : this.sign.hashCode())) * 31) + (this.spaceUrl == null ? 0 : this.spaceUrl.hashCode())) * 31) + (this.subjectRelation == null ? 0 : this.subjectRelation.hashCode())) * 31) + (this.supportFollowAction == null ? 0 : this.supportFollowAction.hashCode())) * 31) + (this.uname == null ? 0 : this.uname.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.userName == null ? 0 : this.userName.hashCode())) * 31) + (this.vip != null ? this.vip.hashCode() : 0);
                            }

                            public String toString() {
                                Integer num = this.attention;
                                String str = this.avatar;
                                String str2 = this.avatarIcon;
                                Integer num2 = this.avatarIdentity;
                                String str3 = this.decorateImg;
                                Integer num3 = this.fans;
                                Boolean bool = this.followed;
                                String str4 = this.level;
                                Boolean bool2 = this.merchant;
                                String str5 = this.merchantIcon;
                                Long l = this.merchantId;
                                String str6 = this.merchantUrl;
                                Long l2 = this.mid;
                                String str7 = this.nicknameColor;
                                OfficialModel officialModel = this.official;
                                Integer num4 = this.relation;
                                String str8 = this.sex;
                                String str9 = this.sign;
                                String str10 = this.spaceUrl;
                                Integer num5 = this.subjectRelation;
                                Boolean bool3 = this.supportFollowAction;
                                String str11 = this.uname;
                                String str12 = this.name;
                                String str13 = this.userName;
                                return "UserInfo(attention=" + num + ", avatar=" + str + ", avatarIcon=" + str2 + ", avatarIdentity=" + num2 + ", decorateImg=" + str3 + ", fans=" + num3 + ", followed=" + bool + ", level=" + str4 + ", merchant=" + bool2 + ", merchantIcon=" + str5 + ", merchantId=" + l + ", merchantUrl=" + str6 + ", mid=" + l2 + ", nicknameColor=" + str7 + ", official=" + officialModel + ", relation=" + num4 + ", sex=" + str8 + ", sign=" + str9 + ", spaceUrl=" + str10 + ", subjectRelation=" + num5 + ", supportFollowAction=" + bool3 + ", uname=" + str11 + ", name=" + str12 + ", userName=" + str13 + ", vip=" + this.vip + ")";
                            }

                            /* compiled from: CommentInfoApiService.kt */
                            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                            public static final class Companion {
                                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                    this();
                                }

                                private Companion() {
                                }

                                public final KSerializer<UserInfo> serializer() {
                                    return CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$$serializer.INSTANCE;
                                }
                            }

                            public /* synthetic */ UserInfo(int seen0, Integer attention, String avatar, String avatarIcon, Integer avatarIdentity, String decorateImg, Integer fans, Boolean followed, String level, Boolean merchant, String merchantIcon, Long merchantId, String merchantUrl, Long mid, String nicknameColor, OfficialModel official, Integer relation, String sex, String sign, String spaceUrl, Integer subjectRelation, Boolean supportFollowAction, String uname, String name, String userName, VipModel vip, SerializationConstructorMarker serializationConstructorMarker) {
                                if ((seen0 & 1) == 0) {
                                    this.attention = null;
                                } else {
                                    this.attention = attention;
                                }
                                if ((seen0 & 2) == 0) {
                                    this.avatar = null;
                                } else {
                                    this.avatar = avatar;
                                }
                                if ((seen0 & 4) == 0) {
                                    this.avatarIcon = null;
                                } else {
                                    this.avatarIcon = avatarIcon;
                                }
                                if ((seen0 & 8) == 0) {
                                    this.avatarIdentity = null;
                                } else {
                                    this.avatarIdentity = avatarIdentity;
                                }
                                if ((seen0 & 16) == 0) {
                                    this.decorateImg = null;
                                } else {
                                    this.decorateImg = decorateImg;
                                }
                                if ((seen0 & 32) == 0) {
                                    this.fans = null;
                                } else {
                                    this.fans = fans;
                                }
                                if ((seen0 & 64) == 0) {
                                    this.followed = null;
                                } else {
                                    this.followed = followed;
                                }
                                if ((seen0 & 128) == 0) {
                                    this.level = null;
                                } else {
                                    this.level = level;
                                }
                                if ((seen0 & 256) == 0) {
                                    this.merchant = null;
                                } else {
                                    this.merchant = merchant;
                                }
                                if ((seen0 & 512) == 0) {
                                    this.merchantIcon = null;
                                } else {
                                    this.merchantIcon = merchantIcon;
                                }
                                if ((seen0 & 1024) == 0) {
                                    this.merchantId = null;
                                } else {
                                    this.merchantId = merchantId;
                                }
                                if ((seen0 & 2048) == 0) {
                                    this.merchantUrl = null;
                                } else {
                                    this.merchantUrl = merchantUrl;
                                }
                                if ((seen0 & 4096) == 0) {
                                    this.mid = null;
                                } else {
                                    this.mid = mid;
                                }
                                if ((seen0 & 8192) == 0) {
                                    this.nicknameColor = null;
                                } else {
                                    this.nicknameColor = nicknameColor;
                                }
                                if ((seen0 & 16384) == 0) {
                                    this.official = null;
                                } else {
                                    this.official = official;
                                }
                                if ((seen0 & 32768) == 0) {
                                    this.relation = null;
                                } else {
                                    this.relation = relation;
                                }
                                if ((seen0 & 65536) == 0) {
                                    this.sex = null;
                                } else {
                                    this.sex = sex;
                                }
                                if ((seen0 & 131072) == 0) {
                                    this.sign = null;
                                } else {
                                    this.sign = sign;
                                }
                                if ((seen0 & 262144) == 0) {
                                    this.spaceUrl = null;
                                } else {
                                    this.spaceUrl = spaceUrl;
                                }
                                if ((seen0 & 524288) == 0) {
                                    this.subjectRelation = null;
                                } else {
                                    this.subjectRelation = subjectRelation;
                                }
                                if ((seen0 & 1048576) == 0) {
                                    this.supportFollowAction = null;
                                } else {
                                    this.supportFollowAction = supportFollowAction;
                                }
                                if ((seen0 & 2097152) == 0) {
                                    this.uname = null;
                                } else {
                                    this.uname = uname;
                                }
                                if ((seen0 & 4194304) == 0) {
                                    this.name = null;
                                } else {
                                    this.name = name;
                                }
                                if ((seen0 & 8388608) == 0) {
                                    this.userName = null;
                                } else {
                                    this.userName = userName;
                                }
                                if ((seen0 & 16777216) == 0) {
                                    this.vip = null;
                                } else {
                                    this.vip = vip;
                                }
                            }

                            public UserInfo(Integer attention, String avatar, String avatarIcon, Integer avatarIdentity, String decorateImg, Integer fans, Boolean followed, String level, Boolean merchant, String merchantIcon, Long merchantId, String merchantUrl, Long mid, String nicknameColor, OfficialModel official, Integer relation, String sex, String sign, String spaceUrl, Integer subjectRelation, Boolean supportFollowAction, String uname, String name, String userName, VipModel vip) {
                                this.attention = attention;
                                this.avatar = avatar;
                                this.avatarIcon = avatarIcon;
                                this.avatarIdentity = avatarIdentity;
                                this.decorateImg = decorateImg;
                                this.fans = fans;
                                this.followed = followed;
                                this.level = level;
                                this.merchant = merchant;
                                this.merchantIcon = merchantIcon;
                                this.merchantId = merchantId;
                                this.merchantUrl = merchantUrl;
                                this.mid = mid;
                                this.nicknameColor = nicknameColor;
                                this.official = official;
                                this.relation = relation;
                                this.sex = sex;
                                this.sign = sign;
                                this.spaceUrl = spaceUrl;
                                this.subjectRelation = subjectRelation;
                                this.supportFollowAction = supportFollowAction;
                                this.uname = uname;
                                this.name = name;
                                this.userName = userName;
                                this.vip = vip;
                            }

                            @JvmStatic
                            public static final /* synthetic */ void write$Self$product_details_page_debug(UserInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
                                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.attention != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.attention);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.avatar != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.avatar);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.avatarIcon != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.avatarIcon);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.avatarIdentity != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.avatarIdentity);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.decorateImg != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.decorateImg);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.fans != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.fans);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.followed != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 6, BooleanSerializer.INSTANCE, self.followed);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.level != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.level);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.merchant != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 8, BooleanSerializer.INSTANCE, self.merchant);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 9) || self.merchantIcon != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.merchantIcon);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 10) || self.merchantId != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 10, LongSerializer.INSTANCE, self.merchantId);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 11) || self.merchantUrl != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.merchantUrl);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 12) || self.mid != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 12, LongSerializer.INSTANCE, self.mid);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 13) || self.nicknameColor != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.nicknameColor);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 14) || self.official != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 14, CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$OfficialModel$$serializer.INSTANCE, self.official);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 15) || self.relation != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 15, IntSerializer.INSTANCE, self.relation);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 16) || self.sex != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.sex);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 17) || self.sign != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.sign);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 18) || self.spaceUrl != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.spaceUrl);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 19) || self.subjectRelation != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 19, IntSerializer.INSTANCE, self.subjectRelation);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 20) || self.supportFollowAction != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 20, BooleanSerializer.INSTANCE, self.supportFollowAction);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 21) || self.uname != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 21, StringSerializer.INSTANCE, self.uname);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 22) || self.name != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 22, StringSerializer.INSTANCE, self.name);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 23) || self.userName != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 23, StringSerializer.INSTANCE, self.userName);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 24) || self.vip != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 24, CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$VipModel$$serializer.INSTANCE, self.vip);
                                }
                            }

                            public /* synthetic */ UserInfo(Integer num, String str, String str2, Integer num2, String str3, Integer num3, Boolean bool, String str4, Boolean bool2, String str5, Long l, String str6, Long l2, String str7, OfficialModel officialModel, Integer num4, String str8, String str9, String str10, Integer num5, Boolean bool3, String str11, String str12, String str13, VipModel vipModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
                                this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : num3, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? null : bool2, (i & 512) != 0 ? null : str5, (i & 1024) != 0 ? null : l, (i & 2048) != 0 ? null : str6, (i & 4096) != 0 ? null : l2, (i & 8192) != 0 ? null : str7, (i & 16384) != 0 ? null : officialModel, (i & 32768) != 0 ? null : num4, (i & 65536) != 0 ? null : str8, (i & 131072) != 0 ? null : str9, (i & 262144) != 0 ? null : str10, (i & 524288) != 0 ? null : num5, (i & 1048576) != 0 ? null : bool3, (i & 2097152) != 0 ? null : str11, (i & 4194304) != 0 ? null : str12, (i & 8388608) != 0 ? null : str13, (i & 16777216) != 0 ? null : vipModel);
                            }

                            public final Integer getAttention() {
                                return this.attention;
                            }

                            public final String getAvatar() {
                                return this.avatar;
                            }

                            public final String getAvatarIcon() {
                                return this.avatarIcon;
                            }

                            public final Integer getAvatarIdentity() {
                                return this.avatarIdentity;
                            }

                            public final String getDecorateImg() {
                                return this.decorateImg;
                            }

                            public final Integer getFans() {
                                return this.fans;
                            }

                            public final Boolean getFollowed() {
                                return this.followed;
                            }

                            public final String getLevel() {
                                return this.level;
                            }

                            public final Boolean getMerchant() {
                                return this.merchant;
                            }

                            public final String getMerchantIcon() {
                                return this.merchantIcon;
                            }

                            public final Long getMerchantId() {
                                return this.merchantId;
                            }

                            public final String getMerchantUrl() {
                                return this.merchantUrl;
                            }

                            public final Long getMid() {
                                return this.mid;
                            }

                            public final String getNicknameColor() {
                                return this.nicknameColor;
                            }

                            public final OfficialModel getOfficial() {
                                return this.official;
                            }

                            public final Integer getRelation() {
                                return this.relation;
                            }

                            public final String getSex() {
                                return this.sex;
                            }

                            public final String getSign() {
                                return this.sign;
                            }

                            public final String getSpaceUrl() {
                                return this.spaceUrl;
                            }

                            public final Integer getSubjectRelation() {
                                return this.subjectRelation;
                            }

                            public final Boolean getSupportFollowAction() {
                                return this.supportFollowAction;
                            }

                            public final String getUname() {
                                return this.uname;
                            }

                            public final String getName() {
                                return this.name;
                            }

                            public final String getUserName() {
                                return this.userName;
                            }

                            /* compiled from: CommentInfoApiService.kt */
                            @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ2\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000e¨\u0006'"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$OfficialModel;", "", "role", "", "title", "", "type", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRole", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/String;", "getType", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$OfficialModel;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                            @Serializable
                            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                            public static final class OfficialModel {
                                public static final int $stable = 0;
                                public static final Companion Companion = new Companion(null);
                                private final Integer role;
                                private final String title;
                                private final Integer type;

                                public OfficialModel() {
                                    this((Integer) null, (String) null, (Integer) null, 7, (DefaultConstructorMarker) null);
                                }

                                public static /* synthetic */ OfficialModel copy$default(OfficialModel officialModel, Integer num, String str, Integer num2, int i, Object obj) {
                                    if ((i & 1) != 0) {
                                        num = officialModel.role;
                                    }
                                    if ((i & 2) != 0) {
                                        str = officialModel.title;
                                    }
                                    if ((i & 4) != 0) {
                                        num2 = officialModel.type;
                                    }
                                    return officialModel.copy(num, str, num2);
                                }

                                public final Integer component1() {
                                    return this.role;
                                }

                                public final String component2() {
                                    return this.title;
                                }

                                public final Integer component3() {
                                    return this.type;
                                }

                                public final OfficialModel copy(Integer num, String str, Integer num2) {
                                    return new OfficialModel(num, str, num2);
                                }

                                public boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj instanceof OfficialModel) {
                                        OfficialModel officialModel = (OfficialModel) obj;
                                        return Intrinsics.areEqual(this.role, officialModel.role) && Intrinsics.areEqual(this.title, officialModel.title) && Intrinsics.areEqual(this.type, officialModel.type);
                                    }
                                    return false;
                                }

                                public int hashCode() {
                                    return ((((this.role == null ? 0 : this.role.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0);
                                }

                                public String toString() {
                                    Integer num = this.role;
                                    String str = this.title;
                                    return "OfficialModel(role=" + num + ", title=" + str + ", type=" + this.type + ")";
                                }

                                /* compiled from: CommentInfoApiService.kt */
                                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$OfficialModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$OfficialModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                                public static final class Companion {
                                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                        this();
                                    }

                                    private Companion() {
                                    }

                                    public final KSerializer<OfficialModel> serializer() {
                                        return CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$OfficialModel$$serializer.INSTANCE;
                                    }
                                }

                                public /* synthetic */ OfficialModel(int seen0, Integer role, String title, Integer type, SerializationConstructorMarker serializationConstructorMarker) {
                                    if ((seen0 & 1) == 0) {
                                        this.role = null;
                                    } else {
                                        this.role = role;
                                    }
                                    if ((seen0 & 2) == 0) {
                                        this.title = null;
                                    } else {
                                        this.title = title;
                                    }
                                    if ((seen0 & 4) == 0) {
                                        this.type = null;
                                    } else {
                                        this.type = type;
                                    }
                                }

                                public OfficialModel(Integer role, String title, Integer type) {
                                    this.role = role;
                                    this.title = title;
                                    this.type = type;
                                }

                                @JvmStatic
                                public static final /* synthetic */ void write$Self$product_details_page_debug(OfficialModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
                                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.role != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.role);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.title != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.title);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.type != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.type);
                                    }
                                }

                                public /* synthetic */ OfficialModel(Integer num, String str, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                                    this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num2);
                                }

                                public final Integer getRole() {
                                    return this.role;
                                }

                                public final String getTitle() {
                                    return this.title;
                                }

                                public final Integer getType() {
                                    return this.type;
                                }
                            }

                            public final VipModel getVip() {
                                return this.vip;
                            }

                            /* compiled from: CommentInfoApiService.kt */
                            @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 52\u00020\u0001:\u000245B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rBa\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0011J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013Jb\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001J%\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0002\b3R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001b\u0010\u0013R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001c\u0010\u0013R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001d\u0010\u0013¨\u00066"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$VipModel;", "", "avatar_subscript", "", "avatar_subscript_url", "", "due_date", "", "nickname_color", "status", "theme_type", "type", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAvatar_subscript", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAvatar_subscript_url", "()Ljava/lang/String;", "getDue_date", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNickname_color", "getStatus", "getTheme_type", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$VipModel;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                            @Serializable
                            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                            public static final class VipModel {
                                public static final int $stable = 0;
                                public static final Companion Companion = new Companion(null);
                                private final Integer avatar_subscript;
                                private final String avatar_subscript_url;
                                private final Long due_date;
                                private final String nickname_color;
                                private final Integer status;
                                private final Integer theme_type;
                                private final Integer type;

                                public VipModel() {
                                    this((Integer) null, (String) null, (Long) null, (String) null, (Integer) null, (Integer) null, (Integer) null, 127, (DefaultConstructorMarker) null);
                                }

                                public static /* synthetic */ VipModel copy$default(VipModel vipModel, Integer num, String str, Long l, String str2, Integer num2, Integer num3, Integer num4, int i, Object obj) {
                                    if ((i & 1) != 0) {
                                        num = vipModel.avatar_subscript;
                                    }
                                    if ((i & 2) != 0) {
                                        str = vipModel.avatar_subscript_url;
                                    }
                                    String str3 = str;
                                    if ((i & 4) != 0) {
                                        l = vipModel.due_date;
                                    }
                                    Long l2 = l;
                                    if ((i & 8) != 0) {
                                        str2 = vipModel.nickname_color;
                                    }
                                    String str4 = str2;
                                    if ((i & 16) != 0) {
                                        num2 = vipModel.status;
                                    }
                                    Integer num5 = num2;
                                    if ((i & 32) != 0) {
                                        num3 = vipModel.theme_type;
                                    }
                                    Integer num6 = num3;
                                    if ((i & 64) != 0) {
                                        num4 = vipModel.type;
                                    }
                                    return vipModel.copy(num, str3, l2, str4, num5, num6, num4);
                                }

                                public final Integer component1() {
                                    return this.avatar_subscript;
                                }

                                public final String component2() {
                                    return this.avatar_subscript_url;
                                }

                                public final Long component3() {
                                    return this.due_date;
                                }

                                public final String component4() {
                                    return this.nickname_color;
                                }

                                public final Integer component5() {
                                    return this.status;
                                }

                                public final Integer component6() {
                                    return this.theme_type;
                                }

                                public final Integer component7() {
                                    return this.type;
                                }

                                public final VipModel copy(Integer num, String str, Long l, String str2, Integer num2, Integer num3, Integer num4) {
                                    return new VipModel(num, str, l, str2, num2, num3, num4);
                                }

                                public boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj instanceof VipModel) {
                                        VipModel vipModel = (VipModel) obj;
                                        return Intrinsics.areEqual(this.avatar_subscript, vipModel.avatar_subscript) && Intrinsics.areEqual(this.avatar_subscript_url, vipModel.avatar_subscript_url) && Intrinsics.areEqual(this.due_date, vipModel.due_date) && Intrinsics.areEqual(this.nickname_color, vipModel.nickname_color) && Intrinsics.areEqual(this.status, vipModel.status) && Intrinsics.areEqual(this.theme_type, vipModel.theme_type) && Intrinsics.areEqual(this.type, vipModel.type);
                                    }
                                    return false;
                                }

                                public int hashCode() {
                                    return ((((((((((((this.avatar_subscript == null ? 0 : this.avatar_subscript.hashCode()) * 31) + (this.avatar_subscript_url == null ? 0 : this.avatar_subscript_url.hashCode())) * 31) + (this.due_date == null ? 0 : this.due_date.hashCode())) * 31) + (this.nickname_color == null ? 0 : this.nickname_color.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.theme_type == null ? 0 : this.theme_type.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0);
                                }

                                public String toString() {
                                    Integer num = this.avatar_subscript;
                                    String str = this.avatar_subscript_url;
                                    Long l = this.due_date;
                                    String str2 = this.nickname_color;
                                    Integer num2 = this.status;
                                    Integer num3 = this.theme_type;
                                    return "VipModel(avatar_subscript=" + num + ", avatar_subscript_url=" + str + ", due_date=" + l + ", nickname_color=" + str2 + ", status=" + num2 + ", theme_type=" + num3 + ", type=" + this.type + ")";
                                }

                                /* compiled from: CommentInfoApiService.kt */
                                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$VipModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$VipModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                                public static final class Companion {
                                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                        this();
                                    }

                                    private Companion() {
                                    }

                                    public final KSerializer<VipModel> serializer() {
                                        return CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$VipModel$$serializer.INSTANCE;
                                    }
                                }

                                public /* synthetic */ VipModel(int seen0, Integer avatar_subscript, String avatar_subscript_url, Long due_date, String nickname_color, Integer status, Integer theme_type, Integer type, SerializationConstructorMarker serializationConstructorMarker) {
                                    if ((seen0 & 1) == 0) {
                                        this.avatar_subscript = null;
                                    } else {
                                        this.avatar_subscript = avatar_subscript;
                                    }
                                    if ((seen0 & 2) == 0) {
                                        this.avatar_subscript_url = null;
                                    } else {
                                        this.avatar_subscript_url = avatar_subscript_url;
                                    }
                                    if ((seen0 & 4) == 0) {
                                        this.due_date = null;
                                    } else {
                                        this.due_date = due_date;
                                    }
                                    if ((seen0 & 8) == 0) {
                                        this.nickname_color = null;
                                    } else {
                                        this.nickname_color = nickname_color;
                                    }
                                    if ((seen0 & 16) == 0) {
                                        this.status = null;
                                    } else {
                                        this.status = status;
                                    }
                                    if ((seen0 & 32) == 0) {
                                        this.theme_type = null;
                                    } else {
                                        this.theme_type = theme_type;
                                    }
                                    if ((seen0 & 64) == 0) {
                                        this.type = null;
                                    } else {
                                        this.type = type;
                                    }
                                }

                                public VipModel(Integer avatar_subscript, String avatar_subscript_url, Long due_date, String nickname_color, Integer status, Integer theme_type, Integer type) {
                                    this.avatar_subscript = avatar_subscript;
                                    this.avatar_subscript_url = avatar_subscript_url;
                                    this.due_date = due_date;
                                    this.nickname_color = nickname_color;
                                    this.status = status;
                                    this.theme_type = theme_type;
                                    this.type = type;
                                }

                                @JvmStatic
                                public static final /* synthetic */ void write$Self$product_details_page_debug(VipModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
                                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.avatar_subscript != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.avatar_subscript);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.avatar_subscript_url != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.avatar_subscript_url);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.due_date != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 2, LongSerializer.INSTANCE, self.due_date);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.nickname_color != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.nickname_color);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.status != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.status);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 5) || self.theme_type != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.theme_type);
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 6) || self.type != null) {
                                        output.encodeNullableSerializableElement(serialDesc, 6, IntSerializer.INSTANCE, self.type);
                                    }
                                }

                                public /* synthetic */ VipModel(Integer num, String str, Long l, String str2, Integer num2, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                                    this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : num3, (i & 64) != 0 ? null : num4);
                                }

                                public final Integer getAvatar_subscript() {
                                    return this.avatar_subscript;
                                }

                                public final String getAvatar_subscript_url() {
                                    return this.avatar_subscript_url;
                                }

                                public final Long getDue_date() {
                                    return this.due_date;
                                }

                                public final String getNickname_color() {
                                    return this.nickname_color;
                                }

                                public final Integer getStatus() {
                                    return this.status;
                                }

                                public final Integer getTheme_type() {
                                    return this.theme_type;
                                }

                                public final Integer getType() {
                                    return this.type;
                                }
                            }
                        }

                        public final Byte getVoteType() {
                            return this.voteType;
                        }

                        /* compiled from: CommentInfoApiService.kt */
                        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\nHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$TopicModel;", "", "mainTopicId", "", "topicId", "topicName", "", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMainTopicId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTopicId", "getTopicName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$TopicModel;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        @Serializable
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class TopicModel {
                            public static final int $stable = 0;
                            public static final Companion Companion = new Companion(null);
                            private final Long mainTopicId;
                            private final Long topicId;
                            private final String topicName;

                            public TopicModel() {
                                this((Long) null, (Long) null, (String) null, 7, (DefaultConstructorMarker) null);
                            }

                            public static /* synthetic */ TopicModel copy$default(TopicModel topicModel, Long l, Long l2, String str, int i, Object obj) {
                                if ((i & 1) != 0) {
                                    l = topicModel.mainTopicId;
                                }
                                if ((i & 2) != 0) {
                                    l2 = topicModel.topicId;
                                }
                                if ((i & 4) != 0) {
                                    str = topicModel.topicName;
                                }
                                return topicModel.copy(l, l2, str);
                            }

                            public final Long component1() {
                                return this.mainTopicId;
                            }

                            public final Long component2() {
                                return this.topicId;
                            }

                            public final String component3() {
                                return this.topicName;
                            }

                            public final TopicModel copy(Long l, Long l2, String str) {
                                return new TopicModel(l, l2, str);
                            }

                            public boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj instanceof TopicModel) {
                                    TopicModel topicModel = (TopicModel) obj;
                                    return Intrinsics.areEqual(this.mainTopicId, topicModel.mainTopicId) && Intrinsics.areEqual(this.topicId, topicModel.topicId) && Intrinsics.areEqual(this.topicName, topicModel.topicName);
                                }
                                return false;
                            }

                            public int hashCode() {
                                return ((((this.mainTopicId == null ? 0 : this.mainTopicId.hashCode()) * 31) + (this.topicId == null ? 0 : this.topicId.hashCode())) * 31) + (this.topicName != null ? this.topicName.hashCode() : 0);
                            }

                            public String toString() {
                                Long l = this.mainTopicId;
                                Long l2 = this.topicId;
                                return "TopicModel(mainTopicId=" + l + ", topicId=" + l2 + ", topicName=" + this.topicName + ")";
                            }

                            /* compiled from: CommentInfoApiService.kt */
                            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$TopicModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$TopicModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                            public static final class Companion {
                                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                    this();
                                }

                                private Companion() {
                                }

                                public final KSerializer<TopicModel> serializer() {
                                    return CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$TopicModel$$serializer.INSTANCE;
                                }
                            }

                            public /* synthetic */ TopicModel(int seen0, Long mainTopicId, Long topicId, String topicName, SerializationConstructorMarker serializationConstructorMarker) {
                                if ((seen0 & 1) == 0) {
                                    this.mainTopicId = null;
                                } else {
                                    this.mainTopicId = mainTopicId;
                                }
                                if ((seen0 & 2) == 0) {
                                    this.topicId = null;
                                } else {
                                    this.topicId = topicId;
                                }
                                if ((seen0 & 4) == 0) {
                                    this.topicName = null;
                                } else {
                                    this.topicName = topicName;
                                }
                            }

                            public TopicModel(Long mainTopicId, Long topicId, String topicName) {
                                this.mainTopicId = mainTopicId;
                                this.topicId = topicId;
                                this.topicName = topicName;
                            }

                            @JvmStatic
                            public static final /* synthetic */ void write$Self$product_details_page_debug(TopicModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
                                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.mainTopicId != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.mainTopicId);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.topicId != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.topicId);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.topicName != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.topicName);
                                }
                            }

                            public /* synthetic */ TopicModel(Long l, Long l2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                                this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) != 0 ? null : str);
                            }

                            public final Long getMainTopicId() {
                                return this.mainTopicId;
                            }

                            public final Long getTopicId() {
                                return this.topicId;
                            }

                            public final String getTopicName() {
                                return this.topicName;
                            }
                        }

                        /* compiled from: CommentInfoApiService.kt */
                        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$TopicTag;", "", "topicTagId", "", "topicTagName", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTopicTagId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTopicTagName", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$TopicTag;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        @Serializable
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class TopicTag {
                            public static final int $stable = 0;
                            public static final Companion Companion = new Companion(null);
                            private final Integer topicTagId;
                            private final String topicTagName;

                            public TopicTag() {
                                this((Integer) null, (String) null, 3, (DefaultConstructorMarker) null);
                            }

                            public static /* synthetic */ TopicTag copy$default(TopicTag topicTag, Integer num, String str, int i, Object obj) {
                                if ((i & 1) != 0) {
                                    num = topicTag.topicTagId;
                                }
                                if ((i & 2) != 0) {
                                    str = topicTag.topicTagName;
                                }
                                return topicTag.copy(num, str);
                            }

                            public final Integer component1() {
                                return this.topicTagId;
                            }

                            public final String component2() {
                                return this.topicTagName;
                            }

                            public final TopicTag copy(Integer num, String str) {
                                return new TopicTag(num, str);
                            }

                            public boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj instanceof TopicTag) {
                                    TopicTag topicTag = (TopicTag) obj;
                                    return Intrinsics.areEqual(this.topicTagId, topicTag.topicTagId) && Intrinsics.areEqual(this.topicTagName, topicTag.topicTagName);
                                }
                                return false;
                            }

                            public int hashCode() {
                                return ((this.topicTagId == null ? 0 : this.topicTagId.hashCode()) * 31) + (this.topicTagName != null ? this.topicTagName.hashCode() : 0);
                            }

                            public String toString() {
                                Integer num = this.topicTagId;
                                return "TopicTag(topicTagId=" + num + ", topicTagName=" + this.topicTagName + ")";
                            }

                            /* compiled from: CommentInfoApiService.kt */
                            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$TopicTag$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$TopicTag;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                            public static final class Companion {
                                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                    this();
                                }

                                private Companion() {
                                }

                                public final KSerializer<TopicTag> serializer() {
                                    return CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$TopicTag$$serializer.INSTANCE;
                                }
                            }

                            public /* synthetic */ TopicTag(int seen0, Integer topicTagId, String topicTagName, SerializationConstructorMarker serializationConstructorMarker) {
                                if ((seen0 & 1) == 0) {
                                    this.topicTagId = null;
                                } else {
                                    this.topicTagId = topicTagId;
                                }
                                if ((seen0 & 2) == 0) {
                                    this.topicTagName = null;
                                } else {
                                    this.topicTagName = topicTagName;
                                }
                            }

                            public TopicTag(Integer topicTagId, String topicTagName) {
                                this.topicTagId = topicTagId;
                                this.topicTagName = topicTagName;
                            }

                            @JvmStatic
                            public static final /* synthetic */ void write$Self$product_details_page_debug(TopicTag self, CompositeEncoder output, SerialDescriptor serialDesc) {
                                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.topicTagId != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.topicTagId);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.topicTagName != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.topicTagName);
                                }
                            }

                            public /* synthetic */ TopicTag(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                                this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str);
                            }

                            public final Integer getTopicTagId() {
                                return this.topicTagId;
                            }

                            public final String getTopicTagName() {
                                return this.topicTagName;
                            }
                        }

                        /* compiled from: CommentInfoApiService.kt */
                        @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 62\u00020\u0001:\u000256B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rBa\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jb\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u000fHÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001J%\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\b4R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017¨\u00067"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$VideoModel;", "", "aid", "", "cover", "", "desc", "postType", "", "status", "title", "url", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAid", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCover", "()Ljava/lang/String;", "getDesc", "getPostType", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getStatus", "getTitle", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$VideoModel;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        @Serializable
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class VideoModel {
                            public static final int $stable = 0;
                            public static final Companion Companion = new Companion(null);
                            private final Long aid;
                            private final String cover;
                            private final String desc;
                            private final Byte postType;
                            private final Byte status;
                            private final String title;
                            private final String url;

                            public VideoModel() {
                                this((Long) null, (String) null, (String) null, (Byte) null, (Byte) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
                            }

                            public static /* synthetic */ VideoModel copy$default(VideoModel videoModel, Long l, String str, String str2, Byte b, Byte b2, String str3, String str4, int i, Object obj) {
                                if ((i & 1) != 0) {
                                    l = videoModel.aid;
                                }
                                if ((i & 2) != 0) {
                                    str = videoModel.cover;
                                }
                                String str5 = str;
                                if ((i & 4) != 0) {
                                    str2 = videoModel.desc;
                                }
                                String str6 = str2;
                                if ((i & 8) != 0) {
                                    b = videoModel.postType;
                                }
                                Byte b3 = b;
                                if ((i & 16) != 0) {
                                    b2 = videoModel.status;
                                }
                                Byte b4 = b2;
                                if ((i & 32) != 0) {
                                    str3 = videoModel.title;
                                }
                                String str7 = str3;
                                if ((i & 64) != 0) {
                                    str4 = videoModel.url;
                                }
                                return videoModel.copy(l, str5, str6, b3, b4, str7, str4);
                            }

                            public final Long component1() {
                                return this.aid;
                            }

                            public final String component2() {
                                return this.cover;
                            }

                            public final String component3() {
                                return this.desc;
                            }

                            public final Byte component4() {
                                return this.postType;
                            }

                            public final Byte component5() {
                                return this.status;
                            }

                            public final String component6() {
                                return this.title;
                            }

                            public final String component7() {
                                return this.url;
                            }

                            public final VideoModel copy(Long l, String str, String str2, Byte b, Byte b2, String str3, String str4) {
                                return new VideoModel(l, str, str2, b, b2, str3, str4);
                            }

                            public boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj instanceof VideoModel) {
                                    VideoModel videoModel = (VideoModel) obj;
                                    return Intrinsics.areEqual(this.aid, videoModel.aid) && Intrinsics.areEqual(this.cover, videoModel.cover) && Intrinsics.areEqual(this.desc, videoModel.desc) && Intrinsics.areEqual(this.postType, videoModel.postType) && Intrinsics.areEqual(this.status, videoModel.status) && Intrinsics.areEqual(this.title, videoModel.title) && Intrinsics.areEqual(this.url, videoModel.url);
                                }
                                return false;
                            }

                            public int hashCode() {
                                return ((((((((((((this.aid == null ? 0 : this.aid.hashCode()) * 31) + (this.cover == null ? 0 : this.cover.hashCode())) * 31) + (this.desc == null ? 0 : this.desc.hashCode())) * 31) + (this.postType == null ? 0 : this.postType.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.url != null ? this.url.hashCode() : 0);
                            }

                            public String toString() {
                                Long l = this.aid;
                                String str = this.cover;
                                String str2 = this.desc;
                                Byte b = this.postType;
                                Byte b2 = this.status;
                                String str3 = this.title;
                                return "VideoModel(aid=" + l + ", cover=" + str + ", desc=" + str2 + ", postType=" + b + ", status=" + b2 + ", title=" + str3 + ", url=" + this.url + ")";
                            }

                            /* compiled from: CommentInfoApiService.kt */
                            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$VideoModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$VideoModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                            public static final class Companion {
                                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                    this();
                                }

                                private Companion() {
                                }

                                public final KSerializer<VideoModel> serializer() {
                                    return CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$VideoModel$$serializer.INSTANCE;
                                }
                            }

                            public /* synthetic */ VideoModel(int seen0, Long aid, String cover, String desc, Byte postType, Byte status, String title, String url, SerializationConstructorMarker serializationConstructorMarker) {
                                if ((seen0 & 1) == 0) {
                                    this.aid = null;
                                } else {
                                    this.aid = aid;
                                }
                                if ((seen0 & 2) == 0) {
                                    this.cover = null;
                                } else {
                                    this.cover = cover;
                                }
                                if ((seen0 & 4) == 0) {
                                    this.desc = null;
                                } else {
                                    this.desc = desc;
                                }
                                if ((seen0 & 8) == 0) {
                                    this.postType = null;
                                } else {
                                    this.postType = postType;
                                }
                                if ((seen0 & 16) == 0) {
                                    this.status = null;
                                } else {
                                    this.status = status;
                                }
                                if ((seen0 & 32) == 0) {
                                    this.title = null;
                                } else {
                                    this.title = title;
                                }
                                if ((seen0 & 64) == 0) {
                                    this.url = null;
                                } else {
                                    this.url = url;
                                }
                            }

                            public VideoModel(Long aid, String cover, String desc, Byte postType, Byte status, String title, String url) {
                                this.aid = aid;
                                this.cover = cover;
                                this.desc = desc;
                                this.postType = postType;
                                this.status = status;
                                this.title = title;
                                this.url = url;
                            }

                            @JvmStatic
                            public static final /* synthetic */ void write$Self$product_details_page_debug(VideoModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
                                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.aid != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.aid);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.cover != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.cover);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.desc != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.desc);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.postType != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 3, ByteSerializer.INSTANCE, self.postType);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.status != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 4, ByteSerializer.INSTANCE, self.status);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.title != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.title);
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.url != null) {
                                    output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.url);
                                }
                            }

                            public /* synthetic */ VideoModel(Long l, String str, String str2, Byte b, Byte b2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                                this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : b, (i & 16) != 0 ? null : b2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4);
                            }

                            public final Long getAid() {
                                return this.aid;
                            }

                            public final String getCover() {
                                return this.cover;
                            }

                            public final String getDesc() {
                                return this.desc;
                            }

                            public final Byte getPostType() {
                                return this.postType;
                            }

                            public final Byte getStatus() {
                                return this.status;
                            }

                            public final String getTitle() {
                                return this.title;
                            }

                            public final String getUrl() {
                                return this.url;
                            }
                        }
                    }
                }

                public final boolean isValid$product_details_page_debug() {
                    Long l = this.code;
                    return (l == null || l.longValue() != 0 || this.data == null) ? false : true;
                }
            }

            public final Triple<Long, Long, Long> getRecentTimeConsuming() {
                return recentTimeConsuming;
            }

            public final void setRecentTimeConsuming(Triple<Long, Long, Long> triple) {
                Intrinsics.checkNotNullParameter(triple, "<set-?>");
                recentTimeConsuming = triple;
            }

            /* compiled from: CommentInfoApiService.kt */
            @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 V2\u00020\u0001:\u0002UVB¿\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018B»\u0001\b\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0017\u0010\u001cJ\u0010\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010!J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010:\u001a\u00020\nHÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010>\u001a\u00020\u000eHÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJÈ\u0001\u0010F\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010GJ\u0013\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010K\u001a\u00020\u0005HÖ\u0001J\t\u0010L\u001a\u00020\u000eHÖ\u0001J%\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u00002\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH\u0001¢\u0006\u0002\bTR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010)R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b/\u0010\u001eR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010)R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b3\u0010\u001eR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b4\u0010\u001eR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b5\u0010\u001e¨\u0006W"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoRequest;", "", "mid", "", "autoEssence", "", "ignoreEssenceIds", "", "ignoreHotIds", "loginStatue", "", "pageNum", "pageSize", "rateFactor", "", "scene", "subPageSize", "subTagId", "subjectId", "subjectType", "tagId", "topicId", "ugcId", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;BIILjava/lang/String;Ljava/lang/String;ILjava/lang/Long;JILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;BIILjava/lang/String;Ljava/lang/String;ILjava/lang/Long;JILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMid", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAutoEssence", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIgnoreEssenceIds", "()Ljava/util/List;", "getIgnoreHotIds", "getLoginStatue", "()B", "getPageNum", "()I", "getPageSize", "getRateFactor", "()Ljava/lang/String;", "getScene", "getSubPageSize", "getSubTagId", "getSubjectId", "()J", "getSubjectType", "getTagId", "getTopicId", "getUgcId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;BIILjava/lang/String;Ljava/lang/String;ILjava/lang/Long;JILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoRequest;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class CommentInfoRequest {
                private final Integer autoEssence;
                private final List<Long> ignoreEssenceIds;
                private final List<Long> ignoreHotIds;
                private final byte loginStatue;
                private final Long mid;
                private final int pageNum;
                private final int pageSize;
                private final String rateFactor;
                private final String scene;
                private final int subPageSize;
                private final Long subTagId;
                private final long subjectId;
                private final int subjectType;
                private final Long tagId;
                private final Long topicId;
                private final Long ugcId;
                public static final Companion Companion = new Companion(null);
                public static final int $stable = 8;
                private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoRequest$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        KSerializer _childSerializers$_anonymous_;
                        _childSerializers$_anonymous_ = CommentInfoApiService.CommentInfoRequest._childSerializers$_anonymous_();
                        return _childSerializers$_anonymous_;
                    }
                }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoRequest$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        KSerializer _childSerializers$_anonymous_$0;
                        _childSerializers$_anonymous_$0 = CommentInfoApiService.CommentInfoRequest._childSerializers$_anonymous_$0();
                        return _childSerializers$_anonymous_$0;
                    }
                }), null, null, null, null, null, null, null, null, null, null, null, null};

                public final Long component1() {
                    return this.mid;
                }

                public final int component10() {
                    return this.subPageSize;
                }

                public final Long component11() {
                    return this.subTagId;
                }

                public final long component12() {
                    return this.subjectId;
                }

                public final int component13() {
                    return this.subjectType;
                }

                public final Long component14() {
                    return this.tagId;
                }

                public final Long component15() {
                    return this.topicId;
                }

                public final Long component16() {
                    return this.ugcId;
                }

                public final Integer component2() {
                    return this.autoEssence;
                }

                public final List<Long> component3() {
                    return this.ignoreEssenceIds;
                }

                public final List<Long> component4() {
                    return this.ignoreHotIds;
                }

                public final byte component5() {
                    return this.loginStatue;
                }

                public final int component6() {
                    return this.pageNum;
                }

                public final int component7() {
                    return this.pageSize;
                }

                public final String component8() {
                    return this.rateFactor;
                }

                public final String component9() {
                    return this.scene;
                }

                public final CommentInfoRequest copy(Long l, Integer num, List<Long> list, List<Long> list2, byte b, int i, int i2, String str, String str2, int i3, Long l2, long j, int i4, Long l3, Long l4, Long l5) {
                    Intrinsics.checkNotNullParameter(list, "ignoreEssenceIds");
                    Intrinsics.checkNotNullParameter(list2, "ignoreHotIds");
                    Intrinsics.checkNotNullParameter(str2, "scene");
                    return new CommentInfoRequest(l, num, list, list2, b, i, i2, str, str2, i3, l2, j, i4, l3, l4, l5);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof CommentInfoRequest) {
                        CommentInfoRequest commentInfoRequest = (CommentInfoRequest) obj;
                        return Intrinsics.areEqual(this.mid, commentInfoRequest.mid) && Intrinsics.areEqual(this.autoEssence, commentInfoRequest.autoEssence) && Intrinsics.areEqual(this.ignoreEssenceIds, commentInfoRequest.ignoreEssenceIds) && Intrinsics.areEqual(this.ignoreHotIds, commentInfoRequest.ignoreHotIds) && this.loginStatue == commentInfoRequest.loginStatue && this.pageNum == commentInfoRequest.pageNum && this.pageSize == commentInfoRequest.pageSize && Intrinsics.areEqual(this.rateFactor, commentInfoRequest.rateFactor) && Intrinsics.areEqual(this.scene, commentInfoRequest.scene) && this.subPageSize == commentInfoRequest.subPageSize && Intrinsics.areEqual(this.subTagId, commentInfoRequest.subTagId) && this.subjectId == commentInfoRequest.subjectId && this.subjectType == commentInfoRequest.subjectType && Intrinsics.areEqual(this.tagId, commentInfoRequest.tagId) && Intrinsics.areEqual(this.topicId, commentInfoRequest.topicId) && Intrinsics.areEqual(this.ugcId, commentInfoRequest.ugcId);
                    }
                    return false;
                }

                public int hashCode() {
                    return ((((((((((((((((((((((((((((((this.mid == null ? 0 : this.mid.hashCode()) * 31) + (this.autoEssence == null ? 0 : this.autoEssence.hashCode())) * 31) + this.ignoreEssenceIds.hashCode()) * 31) + this.ignoreHotIds.hashCode()) * 31) + this.loginStatue) * 31) + this.pageNum) * 31) + this.pageSize) * 31) + (this.rateFactor == null ? 0 : this.rateFactor.hashCode())) * 31) + this.scene.hashCode()) * 31) + this.subPageSize) * 31) + (this.subTagId == null ? 0 : this.subTagId.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.subjectId)) * 31) + this.subjectType) * 31) + (this.tagId == null ? 0 : this.tagId.hashCode())) * 31) + (this.topicId == null ? 0 : this.topicId.hashCode())) * 31) + (this.ugcId != null ? this.ugcId.hashCode() : 0);
                }

                public String toString() {
                    Long l = this.mid;
                    Integer num = this.autoEssence;
                    List<Long> list = this.ignoreEssenceIds;
                    List<Long> list2 = this.ignoreHotIds;
                    byte b = this.loginStatue;
                    int i = this.pageNum;
                    int i2 = this.pageSize;
                    String str = this.rateFactor;
                    String str2 = this.scene;
                    int i3 = this.subPageSize;
                    Long l2 = this.subTagId;
                    long j = this.subjectId;
                    int i4 = this.subjectType;
                    Long l3 = this.tagId;
                    Long l4 = this.topicId;
                    return "CommentInfoRequest(mid=" + l + ", autoEssence=" + num + ", ignoreEssenceIds=" + list + ", ignoreHotIds=" + list2 + ", loginStatue=" + ((int) b) + ", pageNum=" + i + ", pageSize=" + i2 + ", rateFactor=" + str + ", scene=" + str2 + ", subPageSize=" + i3 + ", subTagId=" + l2 + ", subjectId=" + j + ", subjectType=" + i4 + ", tagId=" + l3 + ", topicId=" + l4 + ", ugcId=" + this.ugcId + ")";
                }

                /* compiled from: CommentInfoApiService.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoRequest;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<CommentInfoRequest> serializer() {
                        return CommentInfoApiService$CommentInfoRequest$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ CommentInfoRequest(int seen0, Long mid, Integer autoEssence, List ignoreEssenceIds, List ignoreHotIds, byte loginStatue, int pageNum, int pageSize, String rateFactor, String scene, int subPageSize, Long subTagId, long subjectId, int subjectType, Long tagId, Long topicId, Long ugcId, SerializationConstructorMarker serializationConstructorMarker) {
                    if (2048 != (seen0 & 2048)) {
                        PluginExceptionsKt.throwMissingFieldException(seen0, 2048, CommentInfoApiService$CommentInfoRequest$$serializer.INSTANCE.getDescriptor());
                    }
                    if ((seen0 & 1) == 0) {
                        this.mid = null;
                    } else {
                        this.mid = mid;
                    }
                    if ((seen0 & 2) == 0) {
                        this.autoEssence = null;
                    } else {
                        this.autoEssence = autoEssence;
                    }
                    if ((seen0 & 4) == 0) {
                        this.ignoreEssenceIds = CollectionsKt.emptyList();
                    } else {
                        this.ignoreEssenceIds = ignoreEssenceIds;
                    }
                    if ((seen0 & 8) == 0) {
                        this.ignoreHotIds = CollectionsKt.emptyList();
                    } else {
                        this.ignoreHotIds = ignoreHotIds;
                    }
                    if ((seen0 & 16) == 0) {
                        this.loginStatue = (byte) 0;
                    } else {
                        this.loginStatue = loginStatue;
                    }
                    if ((seen0 & 32) == 0) {
                        this.pageNum = 1;
                    } else {
                        this.pageNum = pageNum;
                    }
                    if ((seen0 & 64) == 0) {
                        this.pageSize = 20;
                    } else {
                        this.pageSize = pageSize;
                    }
                    if ((seen0 & 128) == 0) {
                        this.rateFactor = null;
                    } else {
                        this.rateFactor = rateFactor;
                    }
                    if ((seen0 & 256) == 0) {
                        this.scene = "item_detail_page";
                    } else {
                        this.scene = scene;
                    }
                    if ((seen0 & 512) == 0) {
                        this.subPageSize = 20;
                    } else {
                        this.subPageSize = subPageSize;
                    }
                    if ((seen0 & 1024) == 0) {
                        this.subTagId = null;
                    } else {
                        this.subTagId = subTagId;
                    }
                    this.subjectId = subjectId;
                    if ((seen0 & 4096) == 0) {
                        this.subjectType = 1;
                    } else {
                        this.subjectType = subjectType;
                    }
                    if ((seen0 & 8192) == 0) {
                        this.tagId = null;
                    } else {
                        this.tagId = tagId;
                    }
                    if ((seen0 & 16384) == 0) {
                        this.topicId = null;
                    } else {
                        this.topicId = topicId;
                    }
                    if ((seen0 & 32768) == 0) {
                        this.ugcId = null;
                    } else {
                        this.ugcId = ugcId;
                    }
                }

                public CommentInfoRequest(Long mid, Integer autoEssence, List<Long> list, List<Long> list2, byte loginStatue, int pageNum, int pageSize, String rateFactor, String scene, int subPageSize, Long subTagId, long subjectId, int subjectType, Long tagId, Long topicId, Long ugcId) {
                    Intrinsics.checkNotNullParameter(list, "ignoreEssenceIds");
                    Intrinsics.checkNotNullParameter(list2, "ignoreHotIds");
                    Intrinsics.checkNotNullParameter(scene, "scene");
                    this.mid = mid;
                    this.autoEssence = autoEssence;
                    this.ignoreEssenceIds = list;
                    this.ignoreHotIds = list2;
                    this.loginStatue = loginStatue;
                    this.pageNum = pageNum;
                    this.pageSize = pageSize;
                    this.rateFactor = rateFactor;
                    this.scene = scene;
                    this.subPageSize = subPageSize;
                    this.subTagId = subTagId;
                    this.subjectId = subjectId;
                    this.subjectType = subjectType;
                    this.tagId = tagId;
                    this.topicId = topicId;
                    this.ugcId = ugcId;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                    return new ArrayListSerializer(LongSerializer.INSTANCE);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                    return new ArrayListSerializer(LongSerializer.INSTANCE);
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(CommentInfoRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.mid != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.mid);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.autoEssence != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.autoEssence);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.ignoreEssenceIds, CollectionsKt.emptyList())) {
                        output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.ignoreEssenceIds);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.ignoreHotIds, CollectionsKt.emptyList())) {
                        output.encodeSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.ignoreHotIds);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.loginStatue != 0) {
                        output.encodeByteElement(serialDesc, 4, self.loginStatue);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 5) || self.pageNum != 1) {
                        output.encodeIntElement(serialDesc, 5, self.pageNum);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 6) || self.pageSize != 20) {
                        output.encodeIntElement(serialDesc, 6, self.pageSize);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 7) || self.rateFactor != null) {
                        output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.rateFactor);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.scene, "item_detail_page")) {
                        output.encodeStringElement(serialDesc, 8, self.scene);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 9) || self.subPageSize != 20) {
                        output.encodeIntElement(serialDesc, 9, self.subPageSize);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 10) || self.subTagId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 10, LongSerializer.INSTANCE, self.subTagId);
                    }
                    output.encodeLongElement(serialDesc, 11, self.subjectId);
                    if (output.shouldEncodeElementDefault(serialDesc, 12) || self.subjectType != 1) {
                        output.encodeIntElement(serialDesc, 12, self.subjectType);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 13) || self.tagId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 13, LongSerializer.INSTANCE, self.tagId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 14) || self.topicId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 14, LongSerializer.INSTANCE, self.topicId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 15) || self.ugcId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 15, LongSerializer.INSTANCE, self.ugcId);
                    }
                }

                public /* synthetic */ CommentInfoRequest(Long l, Integer num, List list, List list2, byte b, int i, int i2, String str, String str2, int i3, Long l2, long j, int i4, Long l3, Long l4, Long l5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i5 & 1) != 0 ? null : l, (i5 & 2) != 0 ? null : num, (i5 & 4) != 0 ? CollectionsKt.emptyList() : list, (i5 & 8) != 0 ? CollectionsKt.emptyList() : list2, (i5 & 16) != 0 ? (byte) 0 : b, (i5 & 32) != 0 ? 1 : i, (i5 & 64) != 0 ? 20 : i2, (i5 & 128) != 0 ? null : str, (i5 & 256) != 0 ? "item_detail_page" : str2, (i5 & 512) != 0 ? 20 : i3, (i5 & 1024) != 0 ? null : l2, j, (i5 & 4096) != 0 ? 1 : i4, (i5 & 8192) != 0 ? null : l3, (i5 & 16384) != 0 ? null : l4, (i5 & 32768) != 0 ? null : l5);
                }

                public final Long getMid() {
                    return this.mid;
                }

                public final Integer getAutoEssence() {
                    return this.autoEssence;
                }

                public final List<Long> getIgnoreEssenceIds() {
                    return this.ignoreEssenceIds;
                }

                public final List<Long> getIgnoreHotIds() {
                    return this.ignoreHotIds;
                }

                public final byte getLoginStatue() {
                    return this.loginStatue;
                }

                public final int getPageNum() {
                    return this.pageNum;
                }

                public final int getPageSize() {
                    return this.pageSize;
                }

                public final String getRateFactor() {
                    return this.rateFactor;
                }

                public final String getScene() {
                    return this.scene;
                }

                public final int getSubPageSize() {
                    return this.subPageSize;
                }

                public final Long getSubTagId() {
                    return this.subTagId;
                }

                public final long getSubjectId() {
                    return this.subjectId;
                }

                public final int getSubjectType() {
                    return this.subjectType;
                }

                public final Long getTagId() {
                    return this.tagId;
                }

                public final Long getTopicId() {
                    return this.topicId;
                }

                public final Long getUgcId() {
                    return this.ugcId;
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0057  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0090  */
            /* JADX WARN: Removed duplicated region for block: B:53:0x0195 A[Catch: Exception -> 0x0232, TryCatch #7 {Exception -> 0x0232, blocks: (B:67:0x0225, B:69:0x0229, B:70:0x0231, B:51:0x0182, B:53:0x0195, B:55:0x01dd, B:62:0x01f6), top: B:93:0x0182 }] */
            /* JADX WARN: Removed duplicated region for block: B:55:0x01dd A[Catch: Exception -> 0x0232, TRY_LEAVE, TryCatch #7 {Exception -> 0x0232, blocks: (B:67:0x0225, B:69:0x0229, B:70:0x0231, B:51:0x0182, B:53:0x0195, B:55:0x01dd, B:62:0x01f6), top: B:93:0x0182 }] */
            /* JADX WARN: Removed duplicated region for block: B:67:0x0225 A[Catch: Exception -> 0x0232, TryCatch #7 {Exception -> 0x0232, blocks: (B:67:0x0225, B:69:0x0229, B:70:0x0231, B:51:0x0182, B:53:0x0195, B:55:0x01dd, B:62:0x01f6), top: B:93:0x0182 }] */
            /* JADX WARN: Removed duplicated region for block: B:69:0x0229 A[Catch: Exception -> 0x0232, TryCatch #7 {Exception -> 0x0232, blocks: (B:67:0x0225, B:69:0x0229, B:70:0x0231, B:51:0x0182, B:53:0x0195, B:55:0x01dd, B:62:0x01f6), top: B:93:0x0182 }] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object getCommentInfo$product_details_page_debug(CommentInfoRequest request, Continuation<? super CommentInfoResponse> continuation) {
                CommentInfoApiService$getCommentInfo$1 commentInfoApiService$getCommentInfo$1;
                CommentInfoApiService$getCommentInfo$1 commentInfoApiService$getCommentInfo$12;
                HttpClient $this$post$iv;
                HttpMessageBuilder httpRequestBuilder;
                KType kType;
                Object execute;
                CommentInfoRequest request2;
                KType kType2;
                HttpResponse response;
                KType kType3;
                Object bodyNullable;
                if (continuation instanceof CommentInfoApiService$getCommentInfo$1) {
                    commentInfoApiService$getCommentInfo$1 = (CommentInfoApiService$getCommentInfo$1) continuation;
                    if ((commentInfoApiService$getCommentInfo$1.label & Integer.MIN_VALUE) != 0) {
                        commentInfoApiService$getCommentInfo$1.label -= Integer.MIN_VALUE;
                        commentInfoApiService$getCommentInfo$12 = commentInfoApiService$getCommentInfo$1;
                        Object $result = commentInfoApiService$getCommentInfo$12.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (commentInfoApiService$getCommentInfo$12.label) {
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
                                    if (request == null) {
                                        httpRequestBuilder.setBody(NullBody.INSTANCE);
                                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(CommentInfoRequest.class);
                                        try {
                                            kType2 = Reflection.typeOf(CommentInfoRequest.class);
                                        } catch (Throwable th) {
                                            kType2 = null;
                                        }
                                        httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType2));
                                    } else if (request instanceof OutgoingContent) {
                                        httpRequestBuilder.setBody(request);
                                        httpRequestBuilder.setBodyType((TypeInfo) null);
                                    } else {
                                        httpRequestBuilder.setBody(request);
                                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(CommentInfoRequest.class);
                                        try {
                                            kType = Reflection.typeOf(CommentInfoRequest.class);
                                        } catch (Throwable th2) {
                                            kType = null;
                                        }
                                        httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass2, kType));
                                    }
                                    httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
                                    HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, $this$post$iv);
                                    commentInfoApiService$getCommentInfo$12.L$0 = SpillingKt.nullOutSpilledVariable(request);
                                    commentInfoApiService$getCommentInfo$12.L$1 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                    commentInfoApiService$getCommentInfo$12.L$2 = SpillingKt.nullOutSpilledVariable(API_URL_STRING);
                                    commentInfoApiService$getCommentInfo$12.L$3 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                    commentInfoApiService$getCommentInfo$12.L$4 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                    commentInfoApiService$getCommentInfo$12.L$5 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                                    commentInfoApiService$getCommentInfo$12.L$6 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                    commentInfoApiService$getCommentInfo$12.I$0 = 0;
                                    commentInfoApiService$getCommentInfo$12.I$1 = 0;
                                    commentInfoApiService$getCommentInfo$12.I$2 = 0;
                                    commentInfoApiService$getCommentInfo$12.I$3 = 0;
                                    commentInfoApiService$getCommentInfo$12.label = 1;
                                    execute = httpStatement.execute(commentInfoApiService$getCommentInfo$12);
                                    if (execute == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    request2 = request;
                                    try {
                                        response = (HttpResponse) execute;
                                        if (Intrinsics.areEqual(response.getStatus(), HttpStatusCode.Companion.getOK())) {
                                            KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch comment info: " + response.getStatus());
                                            return new CommentInfoResponse(Boxing.boxLong(-1L), (Integer) null, "Failed to fetch comment info: " + response.getStatus(), (CommentInfoResponse.CommentInfoData) null, 10, (DefaultConstructorMarker) null);
                                        }
                                        HttpClientCall call = response.getCall();
                                        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(CommentInfoResponse.class);
                                        try {
                                            kType3 = Reflection.typeOf(CommentInfoResponse.class);
                                        } catch (Throwable th3) {
                                            kType3 = null;
                                        }
                                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass3, kType3);
                                        commentInfoApiService$getCommentInfo$12.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                                        commentInfoApiService$getCommentInfo$12.L$1 = SpillingKt.nullOutSpilledVariable(response);
                                        commentInfoApiService$getCommentInfo$12.L$2 = SpillingKt.nullOutSpilledVariable(response);
                                        commentInfoApiService$getCommentInfo$12.L$3 = null;
                                        commentInfoApiService$getCommentInfo$12.L$4 = null;
                                        commentInfoApiService$getCommentInfo$12.L$5 = null;
                                        commentInfoApiService$getCommentInfo$12.L$6 = null;
                                        commentInfoApiService$getCommentInfo$12.I$0 = 0;
                                        commentInfoApiService$getCommentInfo$12.label = 2;
                                        bodyNullable = call.bodyNullable(typeInfo, commentInfoApiService$getCommentInfo$12);
                                        if (bodyNullable == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        if (bodyNullable == null) {
                                            CommentInfoResponse rtValue = (CommentInfoResponse) bodyNullable;
                                            return rtValue;
                                        }
                                        throw new NullPointerException("null cannot be cast to non-null type kntr.app.mall.product.details.page.api.CommentInfoApiService.CommentInfoResponse");
                                    } catch (Exception e2) {
                                        e = e2;
                                        KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch comment info: " + e.getMessage(), e);
                                        return new CommentInfoResponse(Boxing.boxLong(-1L), (Integer) null, "Failed to fetch comment info: " + e.getMessage(), (CommentInfoResponse.CommentInfoData) null, 10, (DefaultConstructorMarker) null);
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch comment info: " + e.getMessage(), e);
                                    return new CommentInfoResponse(Boxing.boxLong(-1L), (Integer) null, "Failed to fetch comment info: " + e.getMessage(), (CommentInfoResponse.CommentInfoData) null, 10, (DefaultConstructorMarker) null);
                                }
                            case 1:
                                int i = commentInfoApiService$getCommentInfo$12.I$3;
                                int i2 = commentInfoApiService$getCommentInfo$12.I$2;
                                int i3 = commentInfoApiService$getCommentInfo$12.I$1;
                                int i4 = commentInfoApiService$getCommentInfo$12.I$0;
                                HttpClient httpClient = (HttpClient) commentInfoApiService$getCommentInfo$12.L$6;
                                HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) commentInfoApiService$getCommentInfo$12.L$5;
                                HttpClient httpClient2 = (HttpClient) commentInfoApiService$getCommentInfo$12.L$4;
                                HttpClient httpClient3 = (HttpClient) commentInfoApiService$getCommentInfo$12.L$3;
                                String str = (String) commentInfoApiService$getCommentInfo$12.L$2;
                                HttpClient httpClient4 = (HttpClient) commentInfoApiService$getCommentInfo$12.L$1;
                                request2 = (CommentInfoRequest) commentInfoApiService$getCommentInfo$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    execute = $result;
                                    response = (HttpResponse) execute;
                                    if (Intrinsics.areEqual(response.getStatus(), HttpStatusCode.Companion.getOK())) {
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch comment info: " + e.getMessage(), e);
                                    return new CommentInfoResponse(Boxing.boxLong(-1L), (Integer) null, "Failed to fetch comment info: " + e.getMessage(), (CommentInfoResponse.CommentInfoData) null, 10, (DefaultConstructorMarker) null);
                                }
                                break;
                            case 2:
                                int i5 = commentInfoApiService$getCommentInfo$12.I$0;
                                HttpResponse httpResponse = (HttpResponse) commentInfoApiService$getCommentInfo$12.L$2;
                                HttpResponse httpResponse2 = (HttpResponse) commentInfoApiService$getCommentInfo$12.L$1;
                                CommentInfoRequest commentInfoRequest = (CommentInfoRequest) commentInfoApiService$getCommentInfo$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    bodyNullable = $result;
                                    if (bodyNullable == null) {
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch comment info: " + e.getMessage(), e);
                                    return new CommentInfoResponse(Boxing.boxLong(-1L), (Integer) null, "Failed to fetch comment info: " + e.getMessage(), (CommentInfoResponse.CommentInfoData) null, 10, (DefaultConstructorMarker) null);
                                }
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
                commentInfoApiService$getCommentInfo$1 = new CommentInfoApiService$getCommentInfo$1(this, continuation);
                commentInfoApiService$getCommentInfo$12 = commentInfoApiService$getCommentInfo$1;
                Object $result2 = commentInfoApiService$getCommentInfo$12.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (commentInfoApiService$getCommentInfo$12.label) {
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object mallKntrGetCommentInfo$product_details_page_debug(CommentInfoRequest request, Continuation<? super CommentInfoResponse> continuation) {
                CommentInfoApiService$mallKntrGetCommentInfo$1 commentInfoApiService$mallKntrGetCommentInfo$1;
                CommentInfoApiService$mallKntrGetCommentInfo$1 commentInfoApiService$mallKntrGetCommentInfo$12;
                long startTimestamp;
                Client $this$iv;
                Map params$iv;
                Object mallKntrAsyncRequest;
                Client $this$iv2;
                if (continuation instanceof CommentInfoApiService$mallKntrGetCommentInfo$1) {
                    commentInfoApiService$mallKntrGetCommentInfo$1 = (CommentInfoApiService$mallKntrGetCommentInfo$1) continuation;
                    if ((commentInfoApiService$mallKntrGetCommentInfo$1.label & Integer.MIN_VALUE) != 0) {
                        commentInfoApiService$mallKntrGetCommentInfo$1.label -= Integer.MIN_VALUE;
                        commentInfoApiService$mallKntrGetCommentInfo$12 = commentInfoApiService$mallKntrGetCommentInfo$1;
                        Object $result = commentInfoApiService$mallKntrGetCommentInfo$12.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (commentInfoApiService$mallKntrGetCommentInfo$12.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                startTimestamp = DateFormatKt.getCurrentTimeMillis();
                                try {
                                    $this$iv = Client.INSTANCE;
                                    params$iv = MapsKt.mapOf(new Pair[]{TuplesKt.to("autoEssence", request.getAutoEssence()), TuplesKt.to("ignoreEssenceIds", request.getIgnoreEssenceIds()), TuplesKt.to("ignoreHotIds", request.getIgnoreHotIds()), TuplesKt.to("loginStatue", Boxing.boxByte(request.getLoginStatue())), TuplesKt.to("pageNum", Boxing.boxInt(request.getPageNum())), TuplesKt.to("pageSize", Boxing.boxInt(request.getPageSize())), TuplesKt.to("rateFactor", request.getRateFactor()), TuplesKt.to("scene", request.getScene()), TuplesKt.to("subPageSize", Boxing.boxInt(request.getSubPageSize())), TuplesKt.to("subTagId", request.getSubTagId()), TuplesKt.to("subjectId", Boxing.boxLong(request.getSubjectId())), TuplesKt.to("subjectType", Boxing.boxInt(request.getSubjectType())), TuplesKt.to("tagId", request.getTagId()), TuplesKt.to("topicId", request.getTopicId()), TuplesKt.to("ugcId", request.getUgcId()), TuplesKt.to("mid", request.getMid())});
                                } catch (Exception e) {
                                    e = e;
                                    KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch comment info: " + e.getMessage(), e);
                                    CommentInfoResponse response = new CommentInfoResponse(Boxing.boxLong(-1L), (Integer) null, "Failed to fetch comment info: " + e.getMessage(), (CommentInfoResponse.CommentInfoData) null, 10, (DefaultConstructorMarker) null);
                                    long endTimestamp = DateFormatKt.getCurrentTimeMillis();
                                    long duration = endTimestamp - startTimestamp;
                                    recentTimeConsuming = new Triple<>(Boxing.boxLong(startTimestamp), Boxing.boxLong(endTimestamp), Boxing.boxLong(duration));
                                    return response;
                                } catch (Throwable th) {
                                    th = th;
                                }
                                try {
                                    commentInfoApiService$mallKntrGetCommentInfo$12.L$0 = SpillingKt.nullOutSpilledVariable(request);
                                    commentInfoApiService$mallKntrGetCommentInfo$12.L$1 = $this$iv;
                                    commentInfoApiService$mallKntrGetCommentInfo$12.L$2 = SpillingKt.nullOutSpilledVariable(API_URL_STRING);
                                    commentInfoApiService$mallKntrGetCommentInfo$12.L$3 = SpillingKt.nullOutSpilledVariable("POST");
                                    commentInfoApiService$mallKntrGetCommentInfo$12.L$4 = SpillingKt.nullOutSpilledVariable(params$iv);
                                    commentInfoApiService$mallKntrGetCommentInfo$12.J$0 = startTimestamp;
                                    commentInfoApiService$mallKntrGetCommentInfo$12.I$0 = 0;
                                    commentInfoApiService$mallKntrGetCommentInfo$12.label = 1;
                                    mallKntrAsyncRequest = MallEnvKt.mallKntrAsyncRequest(API_URL_STRING, "POST", (Map) null, params$iv, commentInfoApiService$mallKntrGetCommentInfo$12);
                                    if (mallKntrAsyncRequest == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    $this$iv2 = $this$iv;
                                    try {
                                        String jsonString$iv = (String) mallKntrAsyncRequest;
                                        Json this_$iv$iv = $this$iv2.getJson();
                                        Intrinsics.checkNotNull(jsonString$iv);
                                        this_$iv$iv.getSerializersModule();
                                        Object res$iv = this_$iv$iv.decodeFromString(CommentInfoResponse.Companion.serializer(), jsonString$iv);
                                        try {
                                            CommentInfoResponse response2 = (CommentInfoResponse) res$iv;
                                            long endTimestamp2 = DateFormatKt.getCurrentTimeMillis();
                                            long duration2 = endTimestamp2 - startTimestamp;
                                            recentTimeConsuming = new Triple<>(Boxing.boxLong(startTimestamp), Boxing.boxLong(endTimestamp2), Boxing.boxLong(duration2));
                                            return response2;
                                        } catch (Exception e2) {
                                            e = e2;
                                            KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch comment info: " + e.getMessage(), e);
                                            CommentInfoResponse response3 = new CommentInfoResponse(Boxing.boxLong(-1L), (Integer) null, "Failed to fetch comment info: " + e.getMessage(), (CommentInfoResponse.CommentInfoData) null, 10, (DefaultConstructorMarker) null);
                                            long endTimestamp3 = DateFormatKt.getCurrentTimeMillis();
                                            long duration3 = endTimestamp3 - startTimestamp;
                                            recentTimeConsuming = new Triple<>(Boxing.boxLong(startTimestamp), Boxing.boxLong(endTimestamp3), Boxing.boxLong(duration3));
                                            return response3;
                                        }
                                    } catch (Exception e3) {
                                        e$iv = e3;
                                        try {
                                            try {
                                                try {
                                                    try {
                                                        KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                                        throw e$iv;
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        KLog_androidKt.getKLog().e(K_LOG_TAG, "Failed to fetch comment info: " + e.getMessage(), e);
                                                        CommentInfoResponse response32 = new CommentInfoResponse(Boxing.boxLong(-1L), (Integer) null, "Failed to fetch comment info: " + e.getMessage(), (CommentInfoResponse.CommentInfoData) null, 10, (DefaultConstructorMarker) null);
                                                        long endTimestamp32 = DateFormatKt.getCurrentTimeMillis();
                                                        long duration32 = endTimestamp32 - startTimestamp;
                                                        recentTimeConsuming = new Triple<>(Boxing.boxLong(startTimestamp), Boxing.boxLong(endTimestamp32), Boxing.boxLong(duration32));
                                                        return response32;
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    long endTimestamp4 = DateFormatKt.getCurrentTimeMillis();
                                                    long duration4 = endTimestamp4 - startTimestamp;
                                                    recentTimeConsuming = new Triple<>(Boxing.boxLong(startTimestamp), Boxing.boxLong(endTimestamp4), Boxing.boxLong(duration4));
                                                    throw th;
                                                }
                                            } catch (Exception e5) {
                                                e = e5;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                long endTimestamp42 = DateFormatKt.getCurrentTimeMillis();
                                                long duration42 = endTimestamp42 - startTimestamp;
                                                recentTimeConsuming = new Triple<>(Boxing.boxLong(startTimestamp), Boxing.boxLong(endTimestamp42), Boxing.boxLong(duration42));
                                                throw th;
                                            }
                                        } catch (Exception e6) {
                                            e = e6;
                                        } catch (Throwable th4) {
                                            th = th4;
                                        }
                                    }
                                } catch (Exception e7) {
                                    e$iv = e7;
                                    KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                    throw e$iv;
                                } catch (Throwable th5) {
                                    th = th5;
                                    long endTimestamp422 = DateFormatKt.getCurrentTimeMillis();
                                    long duration422 = endTimestamp422 - startTimestamp;
                                    recentTimeConsuming = new Triple<>(Boxing.boxLong(startTimestamp), Boxing.boxLong(endTimestamp422), Boxing.boxLong(duration422));
                                    throw th;
                                }
                            case 1:
                                int i = commentInfoApiService$mallKntrGetCommentInfo$12.I$0;
                                startTimestamp = commentInfoApiService$mallKntrGetCommentInfo$12.J$0;
                                Map map = (Map) commentInfoApiService$mallKntrGetCommentInfo$12.L$4;
                                String str = (String) commentInfoApiService$mallKntrGetCommentInfo$12.L$3;
                                String str2 = (String) commentInfoApiService$mallKntrGetCommentInfo$12.L$2;
                                Client $this$iv3 = (Client) commentInfoApiService$mallKntrGetCommentInfo$12.L$1;
                                CommentInfoRequest commentInfoRequest = (CommentInfoRequest) commentInfoApiService$mallKntrGetCommentInfo$12.L$0;
                                try {
                                    try {
                                        ResultKt.throwOnFailure($result);
                                        $this$iv2 = $this$iv3;
                                        mallKntrAsyncRequest = $result;
                                        String jsonString$iv2 = (String) mallKntrAsyncRequest;
                                        Json this_$iv$iv2 = $this$iv2.getJson();
                                        Intrinsics.checkNotNull(jsonString$iv2);
                                        this_$iv$iv2.getSerializersModule();
                                        Object res$iv2 = this_$iv$iv2.decodeFromString(CommentInfoResponse.Companion.serializer(), jsonString$iv2);
                                        CommentInfoResponse response22 = (CommentInfoResponse) res$iv2;
                                        long endTimestamp22 = DateFormatKt.getCurrentTimeMillis();
                                        long duration22 = endTimestamp22 - startTimestamp;
                                        recentTimeConsuming = new Triple<>(Boxing.boxLong(startTimestamp), Boxing.boxLong(endTimestamp22), Boxing.boxLong(duration22));
                                        return response22;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        long endTimestamp4222 = DateFormatKt.getCurrentTimeMillis();
                                        long duration4222 = endTimestamp4222 - startTimestamp;
                                        recentTimeConsuming = new Triple<>(Boxing.boxLong(startTimestamp), Boxing.boxLong(endTimestamp4222), Boxing.boxLong(duration4222));
                                        throw th;
                                    }
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
                commentInfoApiService$mallKntrGetCommentInfo$1 = new CommentInfoApiService$mallKntrGetCommentInfo$1(this, continuation);
                commentInfoApiService$mallKntrGetCommentInfo$12 = commentInfoApiService$mallKntrGetCommentInfo$1;
                Object $result2 = commentInfoApiService$mallKntrGetCommentInfo$12.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (commentInfoApiService$mallKntrGetCommentInfo$12.label) {
                }
            }
        }