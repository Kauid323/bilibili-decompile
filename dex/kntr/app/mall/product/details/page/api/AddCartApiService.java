package kntr.app.mall.product.details.page.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AddCartApiService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\bÁ\u0002\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0080@¢\u0006\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkntr/app/mall/product/details/page/api/AddCartApiService;", "", "<init>", "()V", "API_URL_STRING", "", "addCart", "Lkntr/app/mall/product/details/page/api/AddCartApiService$AddCartResponse;", "itemsId", "", "shopId", "", "skuId", "skuNum", "saleType", "trackId", "addCart$product_details_page_debug", "(JIJIILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AddCartResponse", "AddCartData", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AddCartApiService {
    public static final int $stable = 0;
    private static final String API_URL_STRING = "https://mall.bilibili.com/mall-c/cart/na/sku/new";
    public static final AddCartApiService INSTANCE = new AddCartApiService();

    private AddCartApiService() {
    }

    /* compiled from: AddCartApiService.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBC\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\u0007HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006/"}, d2 = {"Lkntr/app/mall/product/details/page/api/AddCartApiService$AddCartResponse;", "", "code", "", "errtag", "", "message", "", "data", "Lkntr/app/mall/product/details/page/api/AddCartApiService$AddCartData;", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/AddCartApiService$AddCartData;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/AddCartApiService$AddCartData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getErrtag", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/String;", "getData", "()Lkntr/app/mall/product/details/page/api/AddCartApiService$AddCartData;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/AddCartApiService$AddCartData;)Lkntr/app/mall/product/details/page/api/AddCartApiService$AddCartResponse;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AddCartResponse {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final Long code;
        private final AddCartData data;
        private final Integer errtag;
        private final String message;

        public AddCartResponse() {
            this((Long) null, (Integer) null, (String) null, (AddCartData) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ AddCartResponse copy$default(AddCartResponse addCartResponse, Long l, Integer num, String str, AddCartData addCartData, int i, Object obj) {
            if ((i & 1) != 0) {
                l = addCartResponse.code;
            }
            if ((i & 2) != 0) {
                num = addCartResponse.errtag;
            }
            if ((i & 4) != 0) {
                str = addCartResponse.message;
            }
            if ((i & 8) != 0) {
                addCartData = addCartResponse.data;
            }
            return addCartResponse.copy(l, num, str, addCartData);
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

        public final AddCartData component4() {
            return this.data;
        }

        public final AddCartResponse copy(Long l, Integer num, String str, AddCartData addCartData) {
            return new AddCartResponse(l, num, str, addCartData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AddCartResponse) {
                AddCartResponse addCartResponse = (AddCartResponse) obj;
                return Intrinsics.areEqual(this.code, addCartResponse.code) && Intrinsics.areEqual(this.errtag, addCartResponse.errtag) && Intrinsics.areEqual(this.message, addCartResponse.message) && Intrinsics.areEqual(this.data, addCartResponse.data);
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
            return "AddCartResponse(code=" + l + ", errtag=" + num + ", message=" + str + ", data=" + this.data + ")";
        }

        /* compiled from: AddCartApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/AddCartApiService$AddCartResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/AddCartApiService$AddCartResponse;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<AddCartResponse> serializer() {
                return new GeneratedSerializer<AddCartResponse>() { // from class: kntr.app.mall.product.details.page.api.AddCartApiService$AddCartResponse$$serializer
                    public static final int $stable;
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.AddCartApiService.AddCartResponse", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.AddCartApiService$AddCartResponse> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.AddCartApiService$AddCartResponse> A[REMOVE]) =  kntr.app.mall.product.details.page.api.AddCartApiService$AddCartResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.AddCartApiService$AddCartResponse$$serializer)
                             in method: kntr.app.mall.product.details.page.api.AddCartApiService.AddCartResponse.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.AddCartApiService$AddCartResponse>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                              ("kntr.app.mall.product.details.page.api.AddCartApiService.AddCartResponse")
                              (wrap: kntr.app.mall.product.details.page.api.AddCartApiService$AddCartResponse$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.AddCartApiService$AddCartResponse$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.AddCartApiService$AddCartResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.AddCartApiService$AddCartResponse$$serializer)
                              (4 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.AddCartApiService$AddCartResponse$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.AddCartApiService$AddCartResponse$$serializer
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
                            kntr.app.mall.product.details.page.api.AddCartApiService$AddCartResponse$$serializer r0 = kntr.app.mall.product.details.page.api.AddCartApiService$AddCartResponse$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.AddCartApiService.AddCartResponse.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ AddCartResponse(int seen0, Long code, Integer errtag, String message, AddCartData data, SerializationConstructorMarker serializationConstructorMarker) {
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

                public AddCartResponse(Long code, Integer errtag, String message, AddCartData data) {
                    this.code = code;
                    this.errtag = errtag;
                    this.message = message;
                    this.data = data;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(AddCartResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
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
                        output.encodeNullableSerializableElement(serialDesc, 3, AddCartApiService$AddCartData$$serializer.INSTANCE, self.data);
                    }
                }

                public /* synthetic */ AddCartResponse(Long l, Integer num, String str, AddCartData addCartData, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : addCartData);
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

                public final AddCartData getData() {
                    return this.data;
                }
            }

            /* compiled from: AddCartApiService.kt */
            @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J%\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0001¢\u0006\u0002\b\u001bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lkntr/app/mall/product/details/page/api/AddCartApiService$AddCartData;", "", "codeMsg", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCodeMsg", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class AddCartData {
                public static final int $stable = 0;
                public static final Companion Companion = new Companion(null);
                private final String codeMsg;

                public AddCartData() {
                    this((String) null, 1, (DefaultConstructorMarker) null);
                }

                public static /* synthetic */ AddCartData copy$default(AddCartData addCartData, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = addCartData.codeMsg;
                    }
                    return addCartData.copy(str);
                }

                public final String component1() {
                    return this.codeMsg;
                }

                public final AddCartData copy(String str) {
                    return new AddCartData(str);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof AddCartData) && Intrinsics.areEqual(this.codeMsg, ((AddCartData) obj).codeMsg);
                }

                public int hashCode() {
                    if (this.codeMsg == null) {
                        return 0;
                    }
                    return this.codeMsg.hashCode();
                }

                public String toString() {
                    return "AddCartData(codeMsg=" + this.codeMsg + ")";
                }

                /* compiled from: AddCartApiService.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/AddCartApiService$AddCartData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/AddCartApiService$AddCartData;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<AddCartData> serializer() {
                        return AddCartApiService$AddCartData$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ AddCartData(int seen0, String codeMsg, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.codeMsg = null;
                    } else {
                        this.codeMsg = codeMsg;
                    }
                }

                public AddCartData(String codeMsg) {
                    this.codeMsg = codeMsg;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(AddCartData self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    boolean z = true;
                    if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.codeMsg == null) {
                        z = false;
                    }
                    if (z) {
                        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.codeMsg);
                    }
                }

                public /* synthetic */ AddCartData(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str);
                }

                public final String getCodeMsg() {
                    return this.codeMsg;
                }
            }

            /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:22:0x00d4
                	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
                */
            public final java.lang.Object addCart$product_details_page_debug(long r24, int r26, long r27, int r29, int r30, java.lang.String r31, kotlin.coroutines.Continuation<? super kntr.app.mall.product.details.page.api.AddCartApiService.AddCartResponse> r32) {
                /*
                    Method dump skipped, instructions count: 560
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.AddCartApiService.addCart$product_details_page_debug(long, int, long, int, int, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }