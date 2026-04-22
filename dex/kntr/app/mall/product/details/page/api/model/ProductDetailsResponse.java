package kntr.app.mall.product.details.page.api.model;

import java.util.List;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ResponseModels.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0003,-.B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\r\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006/"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ProductDetailsResponse;", "", "code", "", "errtag", "message", "", "data", "Lkntr/app/mall/product/details/page/api/model/ProductDetailsResponse$ProductDetailsData;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ProductDetailsResponse$ProductDetailsData;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ProductDetailsResponse$ProductDetailsData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrtag", "getMessage", "()Ljava/lang/String;", "getData", "()Lkntr/app/mall/product/details/page/api/model/ProductDetailsResponse$ProductDetailsData;", "isValid", "", "isValid$product_details_page_debug", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ProductDetailsResponse$ProductDetailsData;)Lkntr/app/mall/product/details/page/api/model/ProductDetailsResponse;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ProductDetailsData", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class ProductDetailsResponse {
    private final Integer code;
    private final ProductDetailsData data;
    private final Integer errtag;
    private final String message;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ProductDetailsResponse() {
        this((Integer) null, (Integer) null, (String) null, (ProductDetailsData) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ProductDetailsResponse copy$default(ProductDetailsResponse productDetailsResponse, Integer num, Integer num2, String str, ProductDetailsData productDetailsData, int i, Object obj) {
        if ((i & 1) != 0) {
            num = productDetailsResponse.code;
        }
        if ((i & 2) != 0) {
            num2 = productDetailsResponse.errtag;
        }
        if ((i & 4) != 0) {
            str = productDetailsResponse.message;
        }
        if ((i & 8) != 0) {
            productDetailsData = productDetailsResponse.data;
        }
        return productDetailsResponse.copy(num, num2, str, productDetailsData);
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

    public final ProductDetailsData component4() {
        return this.data;
    }

    public final ProductDetailsResponse copy(Integer num, Integer num2, String str, ProductDetailsData productDetailsData) {
        return new ProductDetailsResponse(num, num2, str, productDetailsData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProductDetailsResponse) {
            ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) obj;
            return Intrinsics.areEqual(this.code, productDetailsResponse.code) && Intrinsics.areEqual(this.errtag, productDetailsResponse.errtag) && Intrinsics.areEqual(this.message, productDetailsResponse.message) && Intrinsics.areEqual(this.data, productDetailsResponse.data);
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
        return "ProductDetailsResponse(code=" + num + ", errtag=" + num2 + ", message=" + str + ", data=" + this.data + ")";
    }

    /* compiled from: ResponseModels.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ProductDetailsResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ProductDetailsResponse;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ProductDetailsResponse> serializer() {
            return new GeneratedSerializer<ProductDetailsResponse>() { // from class: kntr.app.mall.product.details.page.api.model.ProductDetailsResponse$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.ProductDetailsResponse", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.model.ProductDetailsResponse> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.model.ProductDetailsResponse> A[REMOVE]) =  kntr.app.mall.product.details.page.api.model.ProductDetailsResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.model.ProductDetailsResponse$$serializer)
                         in method: kntr.app.mall.product.details.page.api.model.ProductDetailsResponse.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.model.ProductDetailsResponse>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                          ("kntr.app.mall.product.details.page.api.model.ProductDetailsResponse")
                          (wrap: kntr.app.mall.product.details.page.api.model.ProductDetailsResponse$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.model.ProductDetailsResponse$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.model.ProductDetailsResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.model.ProductDetailsResponse$$serializer)
                          (4 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.model.ProductDetailsResponse$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.model.ProductDetailsResponse$$serializer
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
                        kntr.app.mall.product.details.page.api.model.ProductDetailsResponse$$serializer r0 = kntr.app.mall.product.details.page.api.model.ProductDetailsResponse$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.model.ProductDetailsResponse.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ ProductDetailsResponse(int seen0, Integer code, Integer errtag, String message, ProductDetailsData data, SerializationConstructorMarker serializationConstructorMarker) {
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

            public ProductDetailsResponse(Integer code, Integer errtag, String message, ProductDetailsData data) {
                this.code = code;
                this.errtag = errtag;
                this.message = message;
                this.data = data;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(ProductDetailsResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
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
                    output.encodeNullableSerializableElement(serialDesc, 3, ProductDetailsResponse$ProductDetailsData$$serializer.INSTANCE, self.data);
                }
            }

            public /* synthetic */ ProductDetailsResponse(Integer num, Integer num2, String str, ProductDetailsData productDetailsData, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? 0 : num2, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? null : productDetailsData);
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

            /* compiled from: ResponseModels.kt */
            @Metadata(d1 = {"\u0000\u00ad\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0003\bª\u0001\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u009c\u00022\u00020\u0001:\u0004\u009b\u0002\u009c\u0002BÑ\u0005\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u000100\u0012\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000103\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000105\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000107\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000109\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u000105\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010I\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u000105\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010M\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010O\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010T\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010V\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010X\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010Z\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\\\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010_\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010a\u0012\u0010\b\u0002\u0010b\u001a\n\u0012\u0004\u0012\u00020c\u0018\u00010\u001c¢\u0006\u0004\bd\u0010eBù\u0004\b\u0010\u0012\u0006\u0010f\u001a\u00020\u0013\u0012\u0006\u0010g\u001a\u00020\u0013\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010 \u001a\u0004\u0018\u00010!\u0012\b\u0010\"\u001a\u0004\u0018\u00010#\u0012\b\u0010$\u001a\u0004\u0018\u00010%\u0012\b\u0010&\u001a\u0004\u0018\u00010'\u0012\b\u0010(\u001a\u0004\u0018\u00010)\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010+\u001a\u0004\u0018\u00010,\u0012\b\u0010-\u001a\u0004\u0018\u00010.\u0012\b\u0010/\u001a\u0004\u0018\u000100\u0012\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c\u0012\b\u00102\u001a\u0004\u0018\u000103\u0012\b\u00104\u001a\u0004\u0018\u000105\u0012\b\u00106\u001a\u0004\u0018\u000107\u0012\b\u00108\u001a\u0004\u0018\u000109\u0012\b\u0010:\u001a\u0004\u0018\u00010;\u0012\b\u0010<\u001a\u0004\u0018\u00010=\u0012\b\u0010>\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010?\u001a\u0004\u0018\u00010@\u0012\b\u0010A\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010B\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010C\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010D\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010E\u001a\u0004\u0018\u00010F\u0012\b\u0010G\u001a\u0004\u0018\u000105\u0012\b\u0010H\u001a\u0004\u0018\u00010I\u0012\b\u0010J\u001a\u0004\u0018\u000105\u0012\b\u0010K\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010L\u001a\u0004\u0018\u00010M\u0012\b\u0010N\u001a\u0004\u0018\u00010O\u0012\b\u0010P\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010Q\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010R\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010S\u001a\u0004\u0018\u00010T\u0012\b\u0010U\u001a\u0004\u0018\u00010V\u0012\b\u0010W\u001a\u0004\u0018\u00010X\u0012\b\u0010Y\u001a\u0004\u0018\u00010Z\u0012\b\u0010[\u001a\u0004\u0018\u00010\\\u0012\b\u0010]\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010^\u001a\u0004\u0018\u00010_\u0012\b\u0010`\u001a\u0004\u0018\u00010a\u0012\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020c\u0018\u00010\u001c\u0012\b\u0010h\u001a\u0004\u0018\u00010i¢\u0006\u0004\bd\u0010jJ\f\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ô\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010Õ\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010Ö\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010×\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010Ø\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010Ù\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010Ú\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003J\f\u0010Û\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\f\u0010Ü\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0011\u0010Ý\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010|J\f\u0010Þ\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0012\u0010ß\u0001\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\u0011\u0010à\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010|J\f\u0010á\u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u0012\u0010â\u0001\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cHÆ\u0003J\f\u0010ã\u0001\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\f\u0010ä\u0001\u001a\u0004\u0018\u00010!HÆ\u0003J\f\u0010å\u0001\u001a\u0004\u0018\u00010#HÆ\u0003J\f\u0010æ\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010ç\u0001\u001a\u0004\u0018\u00010'HÆ\u0003J\f\u0010è\u0001\u001a\u0004\u0018\u00010)HÆ\u0003J\f\u0010é\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010ê\u0001\u001a\u0004\u0018\u00010,HÆ\u0003J\f\u0010ë\u0001\u001a\u0004\u0018\u00010.HÆ\u0003J\f\u0010ì\u0001\u001a\u0004\u0018\u000100HÆ\u0003J\u0012\u0010í\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001cHÆ\u0003J\f\u0010î\u0001\u001a\u0004\u0018\u000103HÆ\u0003J\u0012\u0010ï\u0001\u001a\u0004\u0018\u000105HÆ\u0003¢\u0006\u0003\u0010£\u0001J\f\u0010ð\u0001\u001a\u0004\u0018\u000107HÆ\u0003J\f\u0010ñ\u0001\u001a\u0004\u0018\u000109HÆ\u0003J\f\u0010ò\u0001\u001a\u0004\u0018\u00010;HÆ\u0003J\u0012\u0010ó\u0001\u001a\u0004\u0018\u00010=HÆ\u0003¢\u0006\u0003\u0010¬\u0001J\u0011\u0010ô\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010|J\f\u0010õ\u0001\u001a\u0004\u0018\u00010@HÆ\u0003J\f\u0010ö\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010÷\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010ø\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010ù\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010ú\u0001\u001a\u0004\u0018\u00010FHÆ\u0003J\u0012\u0010û\u0001\u001a\u0004\u0018\u000105HÆ\u0003¢\u0006\u0003\u0010£\u0001J\f\u0010ü\u0001\u001a\u0004\u0018\u00010IHÆ\u0003J\u0012\u0010ý\u0001\u001a\u0004\u0018\u000105HÆ\u0003¢\u0006\u0003\u0010£\u0001J\f\u0010þ\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010ÿ\u0001\u001a\u0004\u0018\u00010MHÆ\u0003J\f\u0010\u0080\u0002\u001a\u0004\u0018\u00010OHÆ\u0003J\u0011\u0010\u0081\u0002\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010|J\u0011\u0010\u0082\u0002\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010|J\u0011\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010|J\f\u0010\u0084\u0002\u001a\u0004\u0018\u00010THÆ\u0003J\f\u0010\u0085\u0002\u001a\u0004\u0018\u00010VHÆ\u0003J\f\u0010\u0086\u0002\u001a\u0004\u0018\u00010XHÆ\u0003J\f\u0010\u0087\u0002\u001a\u0004\u0018\u00010ZHÆ\u0003J\f\u0010\u0088\u0002\u001a\u0004\u0018\u00010\\HÆ\u0003J\u0011\u0010\u0089\u0002\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010|J\f\u0010\u008a\u0002\u001a\u0004\u0018\u00010_HÆ\u0003J\f\u0010\u008b\u0002\u001a\u0004\u0018\u00010aHÆ\u0003J\u0012\u0010\u008c\u0002\u001a\n\u0012\u0004\u0012\u00020c\u0018\u00010\u001cHÆ\u0003JÚ\u0005\u0010\u008d\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c2\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\n\b\u0002\u00106\u001a\u0004\u0018\u0001072\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\n\b\u0002\u0010G\u001a\u0004\u0018\u0001052\n\b\u0002\u0010H\u001a\u0004\u0018\u00010I2\n\b\u0002\u0010J\u001a\u0004\u0018\u0001052\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010L\u001a\u0004\u0018\u00010M2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010O2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010S\u001a\u0004\u0018\u00010T2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010V2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010X2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010Z2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\\2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010^\u001a\u0004\u0018\u00010_2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010a2\u0010\b\u0002\u0010b\u001a\n\u0012\u0004\u0012\u00020c\u0018\u00010\u001cHÆ\u0001¢\u0006\u0003\u0010\u008e\u0002J\u0015\u0010\u008f\u0002\u001a\u0002052\t\u0010\u0090\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0091\u0002\u001a\u00020\u0013HÖ\u0001J\n\u0010\u0092\u0002\u001a\u00020\u0005HÖ\u0001J-\u0010\u0093\u0002\u001a\u00030\u0094\u00022\u0007\u0010\u0095\u0002\u001a\u00020\u00002\b\u0010\u0096\u0002\u001a\u00030\u0097\u00022\b\u0010\u0098\u0002\u001a\u00030\u0099\u0002H\u0001¢\u0006\u0003\b\u009a\u0002R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bk\u0010lR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bm\u0010nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bo\u0010pR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bq\u0010nR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\br\u0010nR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bs\u0010nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bt\u0010nR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010}\u001a\u0004\b{\u0010|R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b~\u0010\u007fR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\r\n\u0003\u0010\u0082\u0001\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0013¢\u0006\u000b\n\u0002\u0010}\u001a\u0005\b\u0083\u0001\u0010|R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\n\n\u0000\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001b\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c¢\u0006\n\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\n\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0015\u0010 \u001a\u0004\u0018\u00010!¢\u0006\n\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\"\u0010\"\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\u0012\n\u0000\u0012\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\"\u0010$\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\u0012\n\u0000\u0012\u0006\b\u0090\u0001\u0010\u008d\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\"\u0010&\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\u0012\n\u0000\u0012\u0006\b\u0093\u0001\u0010\u008d\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0015\u0010(\u001a\u0004\u0018\u00010)¢\u0006\n\n\u0000\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0014\u0010*\u001a\u0004\u0018\u00010\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0098\u0001\u0010nR\u0015\u0010+\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0015\u0010-\u001a\u0004\u0018\u00010.¢\u0006\n\n\u0000\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0015\u0010/\u001a\u0004\u0018\u000100¢\u0006\n\n\u0000\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001b\u00101\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c¢\u0006\n\n\u0000\u001a\u0006\b\u009f\u0001\u0010\u0087\u0001R\u0015\u00102\u001a\u0004\u0018\u000103¢\u0006\n\n\u0000\u001a\u0006\b \u0001\u0010¡\u0001R\u0018\u00104\u001a\u0004\u0018\u000105¢\u0006\r\n\u0003\u0010¤\u0001\u001a\u0006\b¢\u0001\u0010£\u0001R\u0015\u00106\u001a\u0004\u0018\u000107¢\u0006\n\n\u0000\u001a\u0006\b¥\u0001\u0010¦\u0001R\u0015\u00108\u001a\u0004\u0018\u000109¢\u0006\n\n\u0000\u001a\u0006\b§\u0001\u0010¨\u0001R\u0015\u0010:\u001a\u0004\u0018\u00010;¢\u0006\n\n\u0000\u001a\u0006\b©\u0001\u0010ª\u0001R\u0018\u0010<\u001a\u0004\u0018\u00010=¢\u0006\r\n\u0003\u0010\u00ad\u0001\u001a\u0006\b«\u0001\u0010¬\u0001R\u0016\u0010>\u001a\u0004\u0018\u00010\u0013¢\u0006\u000b\n\u0002\u0010}\u001a\u0005\b®\u0001\u0010|R\u0015\u0010?\u001a\u0004\u0018\u00010@¢\u0006\n\n\u0000\u001a\u0006\b¯\u0001\u0010°\u0001R\u0014\u0010A\u001a\u0004\u0018\u00010\u0005¢\u0006\t\n\u0000\u001a\u0005\b±\u0001\u0010nR\u0014\u0010B\u001a\u0004\u0018\u00010\u0005¢\u0006\t\n\u0000\u001a\u0005\b²\u0001\u0010nR\u0014\u0010C\u001a\u0004\u0018\u00010\u0005¢\u0006\t\n\u0000\u001a\u0005\b³\u0001\u0010nR\u0014\u0010D\u001a\u0004\u0018\u00010\u0005¢\u0006\t\n\u0000\u001a\u0005\b´\u0001\u0010nR\u0015\u0010E\u001a\u0004\u0018\u00010F¢\u0006\n\n\u0000\u001a\u0006\bµ\u0001\u0010¶\u0001R\u0018\u0010G\u001a\u0004\u0018\u000105¢\u0006\r\n\u0003\u0010¤\u0001\u001a\u0006\b·\u0001\u0010£\u0001R\u0015\u0010H\u001a\u0004\u0018\u00010I¢\u0006\n\n\u0000\u001a\u0006\b¸\u0001\u0010¹\u0001R\u0018\u0010J\u001a\u0004\u0018\u000105¢\u0006\r\n\u0003\u0010¤\u0001\u001a\u0006\bº\u0001\u0010£\u0001R\u0014\u0010K\u001a\u0004\u0018\u00010\u0005¢\u0006\t\n\u0000\u001a\u0005\b»\u0001\u0010nR\u0015\u0010L\u001a\u0004\u0018\u00010M¢\u0006\n\n\u0000\u001a\u0006\b¼\u0001\u0010½\u0001R\u0015\u0010N\u001a\u0004\u0018\u00010O¢\u0006\n\n\u0000\u001a\u0006\b¾\u0001\u0010¿\u0001R\u0016\u0010P\u001a\u0004\u0018\u00010\u0013¢\u0006\u000b\n\u0002\u0010}\u001a\u0005\bÀ\u0001\u0010|R\u0016\u0010Q\u001a\u0004\u0018\u00010\u0013¢\u0006\u000b\n\u0002\u0010}\u001a\u0005\bÁ\u0001\u0010|R\u0016\u0010R\u001a\u0004\u0018\u00010\u0013¢\u0006\u000b\n\u0002\u0010}\u001a\u0005\bÂ\u0001\u0010|R\u0015\u0010S\u001a\u0004\u0018\u00010T¢\u0006\n\n\u0000\u001a\u0006\bÃ\u0001\u0010Ä\u0001R\u0015\u0010U\u001a\u0004\u0018\u00010V¢\u0006\n\n\u0000\u001a\u0006\bÅ\u0001\u0010Æ\u0001R\u0015\u0010W\u001a\u0004\u0018\u00010X¢\u0006\n\n\u0000\u001a\u0006\bÇ\u0001\u0010È\u0001R\u0015\u0010Y\u001a\u0004\u0018\u00010Z¢\u0006\n\n\u0000\u001a\u0006\bÉ\u0001\u0010Ê\u0001R\u0015\u0010[\u001a\u0004\u0018\u00010\\¢\u0006\n\n\u0000\u001a\u0006\bË\u0001\u0010Ì\u0001R\u0016\u0010]\u001a\u0004\u0018\u00010\u0013¢\u0006\u000b\n\u0002\u0010}\u001a\u0005\bÍ\u0001\u0010|R\u0015\u0010^\u001a\u0004\u0018\u00010_¢\u0006\n\n\u0000\u001a\u0006\bÎ\u0001\u0010Ï\u0001R\u0015\u0010`\u001a\u0004\u0018\u00010a¢\u0006\n\n\u0000\u001a\u0006\bÐ\u0001\u0010Ñ\u0001R\u001b\u0010b\u001a\n\u0012\u0004\u0012\u00020c\u0018\u00010\u001c¢\u0006\n\n\u0000\u001a\u0006\bÒ\u0001\u0010\u0087\u0001¨\u0006\u009d\u0002"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ProductDetailsResponse$ProductDetailsData;", "", "actAtmosphereFloorVO", "Lkntr/app/mall/product/details/page/api/model/ActAtmosphereFloor;", "activityDepositPrice", "", "activityInfoFloorVO", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor;", "activityOriginalDepositPrice", "activityOriginalPrice", "activityPrice", "activityTags", "advStateFloorVO", "Lkntr/app/mall/product/details/page/api/model/AdvStateFloor;", "atmospherePriceFloorVO", "Lkntr/app/mall/product/details/page/api/model/AtmospherePriceFloor;", "attrFloorVO", "Lkntr/app/mall/product/details/page/api/model/AttrFloor;", "autoOnSaleTime", "", "basicInfoFloorVO", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor;", "canAddCart", "", "cmcContentType", "commentFloorVO", "Lkntr/app/mall/product/details/page/api/model/CommentFloor;", "commitmentTag", "", "Lkntr/app/mall/product/details/page/api/model/CommitmentTag;", "couponInfoFloorVO", "Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor;", "courseInfoFloorVO", "Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor;", "crowdfundingAtmosFloorVO", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingAtmosFloor;", "crowdfundingProgressFloorVO", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor;", "crowdfundingStairsFloorVO", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor;", "deliveryInfoFloorVO", "Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor;", "depositPrice", "detailDescFloorVO", "Lkntr/app/mall/product/details/page/api/model/DetailDescFloor;", "fileInfoFloorVO", "Lkntr/app/mall/product/details/page/api/model/FileInfoFloor;", "fixedTabSkin", "Lkntr/app/mall/product/details/page/api/model/FixedTabSkinVO;", "floorKeys", "footerFloorVO", "Lkntr/app/mall/product/details/page/api/model/FooterFloor;", "fromTm", "", "globalSkin", "Lkntr/app/mall/product/details/page/api/model/GlobalSkinConfigDTO;", "headerFloorVO", "Lkntr/app/mall/product/details/page/api/model/HeaderFloor;", "ipBrandFloorVO", "Lkntr/app/mall/product/details/page/api/model/IpBrandFloor;", "itemsId", "", "itemsStatus", "mallRecExpBO", "Lkntr/app/mall/product/details/page/api/model/MallRecExpBO;", "maxActivityDepositPrice", "maxActivityOriginalDepositPrice", "maxActivityOriginalPrice", "maxActivityPrice", "mergeAtmospherePriceFloorVO", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor;", "multiSku", "merchantInfo", "Lkntr/app/mall/product/details/page/api/model/MerchantInfo;", "preSale", "presaleDeliveryTimeStr", "priceFloorVO", "Lkntr/app/mall/product/details/page/api/model/PriceFloor;", "recFloorVO", "Lkntr/app/mall/product/details/page/api/model/RecFloor;", "restriction", "restrictionPerOrder", "saleStatus", "seriesFloorVO", "Lkntr/app/mall/product/details/page/api/model/SeriesFloor;", "serviceDescFloorVO", "Lkntr/app/mall/product/details/page/api/model/ServiceDescFloor;", "serviceFloorVO", "Lkntr/app/mall/product/details/page/api/model/ServiceFloor;", "shopInfoFloorVO", "Lkntr/app/mall/product/details/page/api/model/ShopInfoFloor;", "skuInfoFloorVO", "Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor;", "status", "upMeasureFloorVO", "Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor;", "videoSkin", "Lkntr/app/mall/product/details/page/api/model/VideoSkinConfigDTO;", "userInteractInfos", "Lkntr/app/mall/product/details/page/api/model/ActionIconModel;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/ActAtmosphereFloor;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/AdvStateFloor;Lkntr/app/mall/product/details/page/api/model/AtmospherePriceFloor;Lkntr/app/mall/product/details/page/api/model/AttrFloor;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor;Ljava/lang/Byte;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/CommentFloor;Ljava/util/List;Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor;Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor;Lkntr/app/mall/product/details/page/api/model/CrowdfundingAtmosFloor;Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor;Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor;Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/DetailDescFloor;Lkntr/app/mall/product/details/page/api/model/FileInfoFloor;Lkntr/app/mall/product/details/page/api/model/FixedTabSkinVO;Ljava/util/List;Lkntr/app/mall/product/details/page/api/model/FooterFloor;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/GlobalSkinConfigDTO;Lkntr/app/mall/product/details/page/api/model/HeaderFloor;Lkntr/app/mall/product/details/page/api/model/IpBrandFloor;Ljava/lang/Long;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/MallRecExpBO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/MerchantInfo;Ljava/lang/Boolean;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/PriceFloor;Lkntr/app/mall/product/details/page/api/model/RecFloor;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/SeriesFloor;Lkntr/app/mall/product/details/page/api/model/ServiceDescFloor;Lkntr/app/mall/product/details/page/api/model/ServiceFloor;Lkntr/app/mall/product/details/page/api/model/ShopInfoFloor;Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor;Lkntr/app/mall/product/details/page/api/model/VideoSkinConfigDTO;Ljava/util/List;)V", "seen0", "seen1", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILkntr/app/mall/product/details/page/api/model/ActAtmosphereFloor;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/AdvStateFloor;Lkntr/app/mall/product/details/page/api/model/AtmospherePriceFloor;Lkntr/app/mall/product/details/page/api/model/AttrFloor;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor;Ljava/lang/Byte;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/CommentFloor;Ljava/util/List;Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor;Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor;Lkntr/app/mall/product/details/page/api/model/CrowdfundingAtmosFloor;Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor;Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor;Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/DetailDescFloor;Lkntr/app/mall/product/details/page/api/model/FileInfoFloor;Lkntr/app/mall/product/details/page/api/model/FixedTabSkinVO;Ljava/util/List;Lkntr/app/mall/product/details/page/api/model/FooterFloor;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/GlobalSkinConfigDTO;Lkntr/app/mall/product/details/page/api/model/HeaderFloor;Lkntr/app/mall/product/details/page/api/model/IpBrandFloor;Ljava/lang/Long;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/MallRecExpBO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/MerchantInfo;Ljava/lang/Boolean;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/PriceFloor;Lkntr/app/mall/product/details/page/api/model/RecFloor;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/SeriesFloor;Lkntr/app/mall/product/details/page/api/model/ServiceDescFloor;Lkntr/app/mall/product/details/page/api/model/ServiceFloor;Lkntr/app/mall/product/details/page/api/model/ShopInfoFloor;Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor;Lkntr/app/mall/product/details/page/api/model/VideoSkinConfigDTO;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActAtmosphereFloorVO", "()Lkntr/app/mall/product/details/page/api/model/ActAtmosphereFloor;", "getActivityDepositPrice", "()Ljava/lang/String;", "getActivityInfoFloorVO", "()Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor;", "getActivityOriginalDepositPrice", "getActivityOriginalPrice", "getActivityPrice", "getActivityTags", "getAdvStateFloorVO", "()Lkntr/app/mall/product/details/page/api/model/AdvStateFloor;", "getAtmospherePriceFloorVO", "()Lkntr/app/mall/product/details/page/api/model/AtmospherePriceFloor;", "getAttrFloorVO", "()Lkntr/app/mall/product/details/page/api/model/AttrFloor;", "getAutoOnSaleTime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBasicInfoFloorVO", "()Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor;", "getCanAddCart", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getCmcContentType", "getCommentFloorVO", "()Lkntr/app/mall/product/details/page/api/model/CommentFloor;", "getCommitmentTag", "()Ljava/util/List;", "getCouponInfoFloorVO", "()Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor;", "getCourseInfoFloorVO", "()Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor;", "getCrowdfundingAtmosFloorVO$annotations", "()V", "getCrowdfundingAtmosFloorVO", "()Lkntr/app/mall/product/details/page/api/model/CrowdfundingAtmosFloor;", "getCrowdfundingProgressFloorVO$annotations", "getCrowdfundingProgressFloorVO", "()Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor;", "getCrowdfundingStairsFloorVO$annotations", "getCrowdfundingStairsFloorVO", "()Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor;", "getDeliveryInfoFloorVO", "()Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor;", "getDepositPrice", "getDetailDescFloorVO", "()Lkntr/app/mall/product/details/page/api/model/DetailDescFloor;", "getFileInfoFloorVO", "()Lkntr/app/mall/product/details/page/api/model/FileInfoFloor;", "getFixedTabSkin", "()Lkntr/app/mall/product/details/page/api/model/FixedTabSkinVO;", "getFloorKeys", "getFooterFloorVO", "()Lkntr/app/mall/product/details/page/api/model/FooterFloor;", "getFromTm", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getGlobalSkin", "()Lkntr/app/mall/product/details/page/api/model/GlobalSkinConfigDTO;", "getHeaderFloorVO", "()Lkntr/app/mall/product/details/page/api/model/HeaderFloor;", "getIpBrandFloorVO", "()Lkntr/app/mall/product/details/page/api/model/IpBrandFloor;", "getItemsId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getItemsStatus", "getMallRecExpBO", "()Lkntr/app/mall/product/details/page/api/model/MallRecExpBO;", "getMaxActivityDepositPrice", "getMaxActivityOriginalDepositPrice", "getMaxActivityOriginalPrice", "getMaxActivityPrice", "getMergeAtmospherePriceFloorVO", "()Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor;", "getMultiSku", "getMerchantInfo", "()Lkntr/app/mall/product/details/page/api/model/MerchantInfo;", "getPreSale", "getPresaleDeliveryTimeStr", "getPriceFloorVO", "()Lkntr/app/mall/product/details/page/api/model/PriceFloor;", "getRecFloorVO", "()Lkntr/app/mall/product/details/page/api/model/RecFloor;", "getRestriction", "getRestrictionPerOrder", "getSaleStatus", "getSeriesFloorVO", "()Lkntr/app/mall/product/details/page/api/model/SeriesFloor;", "getServiceDescFloorVO", "()Lkntr/app/mall/product/details/page/api/model/ServiceDescFloor;", "getServiceFloorVO", "()Lkntr/app/mall/product/details/page/api/model/ServiceFloor;", "getShopInfoFloorVO", "()Lkntr/app/mall/product/details/page/api/model/ShopInfoFloor;", "getSkuInfoFloorVO", "()Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor;", "getStatus", "getUpMeasureFloorVO", "()Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor;", "getVideoSkin", "()Lkntr/app/mall/product/details/page/api/model/VideoSkinConfigDTO;", "getUserInteractInfos", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "copy", "(Lkntr/app/mall/product/details/page/api/model/ActAtmosphereFloor;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/AdvStateFloor;Lkntr/app/mall/product/details/page/api/model/AtmospherePriceFloor;Lkntr/app/mall/product/details/page/api/model/AttrFloor;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor;Ljava/lang/Byte;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/CommentFloor;Ljava/util/List;Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor;Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor;Lkntr/app/mall/product/details/page/api/model/CrowdfundingAtmosFloor;Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor;Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor;Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/DetailDescFloor;Lkntr/app/mall/product/details/page/api/model/FileInfoFloor;Lkntr/app/mall/product/details/page/api/model/FixedTabSkinVO;Ljava/util/List;Lkntr/app/mall/product/details/page/api/model/FooterFloor;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/GlobalSkinConfigDTO;Lkntr/app/mall/product/details/page/api/model/HeaderFloor;Lkntr/app/mall/product/details/page/api/model/IpBrandFloor;Ljava/lang/Long;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/MallRecExpBO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/MerchantInfo;Ljava/lang/Boolean;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/PriceFloor;Lkntr/app/mall/product/details/page/api/model/RecFloor;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/SeriesFloor;Lkntr/app/mall/product/details/page/api/model/ServiceDescFloor;Lkntr/app/mall/product/details/page/api/model/ServiceFloor;Lkntr/app/mall/product/details/page/api/model/ShopInfoFloor;Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor;Lkntr/app/mall/product/details/page/api/model/VideoSkinConfigDTO;Ljava/util/List;)Lkntr/app/mall/product/details/page/api/model/ProductDetailsResponse$ProductDetailsData;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class ProductDetailsData {
                private final ActAtmosphereFloor actAtmosphereFloorVO;
                private final String activityDepositPrice;
                private final ActivityInfoFloor activityInfoFloorVO;
                private final String activityOriginalDepositPrice;
                private final String activityOriginalPrice;
                private final String activityPrice;
                private final String activityTags;
                private final AdvStateFloor advStateFloorVO;
                private final AtmospherePriceFloor atmospherePriceFloorVO;
                private final AttrFloor attrFloorVO;
                private final Integer autoOnSaleTime;
                private final BasicInfoFloor basicInfoFloorVO;
                private final Byte canAddCart;
                private final Integer cmcContentType;
                private final CommentFloor commentFloorVO;
                private final List<CommitmentTag> commitmentTag;
                private final CouponInfoFloor couponInfoFloorVO;
                private final CourseInfoFloor courseInfoFloorVO;
                private final CrowdfundingAtmosFloor crowdfundingAtmosFloorVO;
                private final CrowdfundingProgressFloor crowdfundingProgressFloorVO;
                private final CrowdfundingStairsFloor crowdfundingStairsFloorVO;
                private final DeliveryInfoFloor deliveryInfoFloorVO;
                private final String depositPrice;
                private final DetailDescFloor detailDescFloorVO;
                private final FileInfoFloor fileInfoFloorVO;
                private final FixedTabSkinVO fixedTabSkin;
                private final List<String> floorKeys;
                private final FooterFloor footerFloorVO;
                private final Boolean fromTm;
                private final GlobalSkinConfigDTO globalSkin;
                private final HeaderFloor headerFloorVO;
                private final IpBrandFloor ipBrandFloorVO;
                private final Long itemsId;
                private final Integer itemsStatus;
                private final MallRecExpBO mallRecExpBO;
                private final String maxActivityDepositPrice;
                private final String maxActivityOriginalDepositPrice;
                private final String maxActivityOriginalPrice;
                private final String maxActivityPrice;
                private final MerchantInfo merchantInfo;
                private final MergeAtmospherePriceFloor mergeAtmospherePriceFloorVO;
                private final Boolean multiSku;
                private final Boolean preSale;
                private final String presaleDeliveryTimeStr;
                private final PriceFloor priceFloorVO;
                private final RecFloor recFloorVO;
                private final Integer restriction;
                private final Integer restrictionPerOrder;
                private final Integer saleStatus;
                private final SeriesFloor seriesFloorVO;
                private final ServiceDescFloor serviceDescFloorVO;
                private final ServiceFloor serviceFloorVO;
                private final ShopInfoFloor shopInfoFloorVO;
                private final SkuInfoFloor skuInfoFloorVO;
                private final Integer status;
                private final UpMeasureFloor upMeasureFloorVO;
                private final List<ActionIconModel> userInteractInfos;
                private final VideoSkinConfigDTO videoSkin;
                public static final Companion Companion = new Companion(null);
                public static final int $stable = 8;
                private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.ProductDetailsResponse$ProductDetailsData$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        KSerializer _childSerializers$_anonymous_;
                        _childSerializers$_anonymous_ = ProductDetailsResponse.ProductDetailsData._childSerializers$_anonymous_();
                        return _childSerializers$_anonymous_;
                    }
                }), null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.ProductDetailsResponse$ProductDetailsData$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        KSerializer _childSerializers$_anonymous_$0;
                        _childSerializers$_anonymous_$0 = ProductDetailsResponse.ProductDetailsData._childSerializers$_anonymous_$0();
                        return _childSerializers$_anonymous_$0;
                    }
                }), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.ProductDetailsResponse$ProductDetailsData$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        KSerializer _childSerializers$_anonymous_$1;
                        _childSerializers$_anonymous_$1 = ProductDetailsResponse.ProductDetailsData._childSerializers$_anonymous_$1();
                        return _childSerializers$_anonymous_$1;
                    }
                })};

                public ProductDetailsData() {
                    this((ActAtmosphereFloor) null, (String) null, (ActivityInfoFloor) null, (String) null, (String) null, (String) null, (String) null, (AdvStateFloor) null, (AtmospherePriceFloor) null, (AttrFloor) null, (Integer) null, (BasicInfoFloor) null, (Byte) null, (Integer) null, (CommentFloor) null, (List) null, (CouponInfoFloor) null, (CourseInfoFloor) null, (CrowdfundingAtmosFloor) null, (CrowdfundingProgressFloor) null, (CrowdfundingStairsFloor) null, (DeliveryInfoFloor) null, (String) null, (DetailDescFloor) null, (FileInfoFloor) null, (FixedTabSkinVO) null, (List) null, (FooterFloor) null, (Boolean) null, (GlobalSkinConfigDTO) null, (HeaderFloor) null, (IpBrandFloor) null, (Long) null, (Integer) null, (MallRecExpBO) null, (String) null, (String) null, (String) null, (String) null, (MergeAtmospherePriceFloor) null, (Boolean) null, (MerchantInfo) null, (Boolean) null, (String) null, (PriceFloor) null, (RecFloor) null, (Integer) null, (Integer) null, (Integer) null, (SeriesFloor) null, (ServiceDescFloor) null, (ServiceFloor) null, (ShopInfoFloor) null, (SkuInfoFloor) null, (Integer) null, (UpMeasureFloor) null, (VideoSkinConfigDTO) null, (List) null, -1, 67108863, (DefaultConstructorMarker) null);
                }

                @SerialName("crowdFundingAtmosFloorVO")
                public static /* synthetic */ void getCrowdfundingAtmosFloorVO$annotations() {
                }

                @SerialName("crowdFundingProgressFloorVO")
                public static /* synthetic */ void getCrowdfundingProgressFloorVO$annotations() {
                }

                @SerialName("crowdFundingStairsFloorVO")
                public static /* synthetic */ void getCrowdfundingStairsFloorVO$annotations() {
                }

                public final ActAtmosphereFloor component1() {
                    return this.actAtmosphereFloorVO;
                }

                public final AttrFloor component10() {
                    return this.attrFloorVO;
                }

                public final Integer component11() {
                    return this.autoOnSaleTime;
                }

                public final BasicInfoFloor component12() {
                    return this.basicInfoFloorVO;
                }

                public final Byte component13() {
                    return this.canAddCart;
                }

                public final Integer component14() {
                    return this.cmcContentType;
                }

                public final CommentFloor component15() {
                    return this.commentFloorVO;
                }

                public final List<CommitmentTag> component16() {
                    return this.commitmentTag;
                }

                public final CouponInfoFloor component17() {
                    return this.couponInfoFloorVO;
                }

                public final CourseInfoFloor component18() {
                    return this.courseInfoFloorVO;
                }

                public final CrowdfundingAtmosFloor component19() {
                    return this.crowdfundingAtmosFloorVO;
                }

                public final String component2() {
                    return this.activityDepositPrice;
                }

                public final CrowdfundingProgressFloor component20() {
                    return this.crowdfundingProgressFloorVO;
                }

                public final CrowdfundingStairsFloor component21() {
                    return this.crowdfundingStairsFloorVO;
                }

                public final DeliveryInfoFloor component22() {
                    return this.deliveryInfoFloorVO;
                }

                public final String component23() {
                    return this.depositPrice;
                }

                public final DetailDescFloor component24() {
                    return this.detailDescFloorVO;
                }

                public final FileInfoFloor component25() {
                    return this.fileInfoFloorVO;
                }

                public final FixedTabSkinVO component26() {
                    return this.fixedTabSkin;
                }

                public final List<String> component27() {
                    return this.floorKeys;
                }

                public final FooterFloor component28() {
                    return this.footerFloorVO;
                }

                public final Boolean component29() {
                    return this.fromTm;
                }

                public final ActivityInfoFloor component3() {
                    return this.activityInfoFloorVO;
                }

                public final GlobalSkinConfigDTO component30() {
                    return this.globalSkin;
                }

                public final HeaderFloor component31() {
                    return this.headerFloorVO;
                }

                public final IpBrandFloor component32() {
                    return this.ipBrandFloorVO;
                }

                public final Long component33() {
                    return this.itemsId;
                }

                public final Integer component34() {
                    return this.itemsStatus;
                }

                public final MallRecExpBO component35() {
                    return this.mallRecExpBO;
                }

                public final String component36() {
                    return this.maxActivityDepositPrice;
                }

                public final String component37() {
                    return this.maxActivityOriginalDepositPrice;
                }

                public final String component38() {
                    return this.maxActivityOriginalPrice;
                }

                public final String component39() {
                    return this.maxActivityPrice;
                }

                public final String component4() {
                    return this.activityOriginalDepositPrice;
                }

                public final MergeAtmospherePriceFloor component40() {
                    return this.mergeAtmospherePriceFloorVO;
                }

                public final Boolean component41() {
                    return this.multiSku;
                }

                public final MerchantInfo component42() {
                    return this.merchantInfo;
                }

                public final Boolean component43() {
                    return this.preSale;
                }

                public final String component44() {
                    return this.presaleDeliveryTimeStr;
                }

                public final PriceFloor component45() {
                    return this.priceFloorVO;
                }

                public final RecFloor component46() {
                    return this.recFloorVO;
                }

                public final Integer component47() {
                    return this.restriction;
                }

                public final Integer component48() {
                    return this.restrictionPerOrder;
                }

                public final Integer component49() {
                    return this.saleStatus;
                }

                public final String component5() {
                    return this.activityOriginalPrice;
                }

                public final SeriesFloor component50() {
                    return this.seriesFloorVO;
                }

                public final ServiceDescFloor component51() {
                    return this.serviceDescFloorVO;
                }

                public final ServiceFloor component52() {
                    return this.serviceFloorVO;
                }

                public final ShopInfoFloor component53() {
                    return this.shopInfoFloorVO;
                }

                public final SkuInfoFloor component54() {
                    return this.skuInfoFloorVO;
                }

                public final Integer component55() {
                    return this.status;
                }

                public final UpMeasureFloor component56() {
                    return this.upMeasureFloorVO;
                }

                public final VideoSkinConfigDTO component57() {
                    return this.videoSkin;
                }

                public final List<ActionIconModel> component58() {
                    return this.userInteractInfos;
                }

                public final String component6() {
                    return this.activityPrice;
                }

                public final String component7() {
                    return this.activityTags;
                }

                public final AdvStateFloor component8() {
                    return this.advStateFloorVO;
                }

                public final AtmospherePriceFloor component9() {
                    return this.atmospherePriceFloorVO;
                }

                public final ProductDetailsData copy(ActAtmosphereFloor actAtmosphereFloor, String str, ActivityInfoFloor activityInfoFloor, String str2, String str3, String str4, String str5, AdvStateFloor advStateFloor, AtmospherePriceFloor atmospherePriceFloor, AttrFloor attrFloor, Integer num, BasicInfoFloor basicInfoFloor, Byte b, Integer num2, CommentFloor commentFloor, List<CommitmentTag> list, CouponInfoFloor couponInfoFloor, CourseInfoFloor courseInfoFloor, CrowdfundingAtmosFloor crowdfundingAtmosFloor, CrowdfundingProgressFloor crowdfundingProgressFloor, CrowdfundingStairsFloor crowdfundingStairsFloor, DeliveryInfoFloor deliveryInfoFloor, String str6, DetailDescFloor detailDescFloor, FileInfoFloor fileInfoFloor, FixedTabSkinVO fixedTabSkinVO, List<String> list2, FooterFloor footerFloor, Boolean bool, GlobalSkinConfigDTO globalSkinConfigDTO, HeaderFloor headerFloor, IpBrandFloor ipBrandFloor, Long l, Integer num3, MallRecExpBO mallRecExpBO, String str7, String str8, String str9, String str10, MergeAtmospherePriceFloor mergeAtmospherePriceFloor, Boolean bool2, MerchantInfo merchantInfo, Boolean bool3, String str11, PriceFloor priceFloor, RecFloor recFloor, Integer num4, Integer num5, Integer num6, SeriesFloor seriesFloor, ServiceDescFloor serviceDescFloor, ServiceFloor serviceFloor, ShopInfoFloor shopInfoFloor, SkuInfoFloor skuInfoFloor, Integer num7, UpMeasureFloor upMeasureFloor, VideoSkinConfigDTO videoSkinConfigDTO, List<ActionIconModel> list3) {
                    return new ProductDetailsData(actAtmosphereFloor, str, activityInfoFloor, str2, str3, str4, str5, advStateFloor, atmospherePriceFloor, attrFloor, num, basicInfoFloor, b, num2, commentFloor, list, couponInfoFloor, courseInfoFloor, crowdfundingAtmosFloor, crowdfundingProgressFloor, crowdfundingStairsFloor, deliveryInfoFloor, str6, detailDescFloor, fileInfoFloor, fixedTabSkinVO, list2, footerFloor, bool, globalSkinConfigDTO, headerFloor, ipBrandFloor, l, num3, mallRecExpBO, str7, str8, str9, str10, mergeAtmospherePriceFloor, bool2, merchantInfo, bool3, str11, priceFloor, recFloor, num4, num5, num6, seriesFloor, serviceDescFloor, serviceFloor, shopInfoFloor, skuInfoFloor, num7, upMeasureFloor, videoSkinConfigDTO, list3);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof ProductDetailsData) {
                        ProductDetailsData productDetailsData = (ProductDetailsData) obj;
                        return Intrinsics.areEqual(this.actAtmosphereFloorVO, productDetailsData.actAtmosphereFloorVO) && Intrinsics.areEqual(this.activityDepositPrice, productDetailsData.activityDepositPrice) && Intrinsics.areEqual(this.activityInfoFloorVO, productDetailsData.activityInfoFloorVO) && Intrinsics.areEqual(this.activityOriginalDepositPrice, productDetailsData.activityOriginalDepositPrice) && Intrinsics.areEqual(this.activityOriginalPrice, productDetailsData.activityOriginalPrice) && Intrinsics.areEqual(this.activityPrice, productDetailsData.activityPrice) && Intrinsics.areEqual(this.activityTags, productDetailsData.activityTags) && Intrinsics.areEqual(this.advStateFloorVO, productDetailsData.advStateFloorVO) && Intrinsics.areEqual(this.atmospherePriceFloorVO, productDetailsData.atmospherePriceFloorVO) && Intrinsics.areEqual(this.attrFloorVO, productDetailsData.attrFloorVO) && Intrinsics.areEqual(this.autoOnSaleTime, productDetailsData.autoOnSaleTime) && Intrinsics.areEqual(this.basicInfoFloorVO, productDetailsData.basicInfoFloorVO) && Intrinsics.areEqual(this.canAddCart, productDetailsData.canAddCart) && Intrinsics.areEqual(this.cmcContentType, productDetailsData.cmcContentType) && Intrinsics.areEqual(this.commentFloorVO, productDetailsData.commentFloorVO) && Intrinsics.areEqual(this.commitmentTag, productDetailsData.commitmentTag) && Intrinsics.areEqual(this.couponInfoFloorVO, productDetailsData.couponInfoFloorVO) && Intrinsics.areEqual(this.courseInfoFloorVO, productDetailsData.courseInfoFloorVO) && Intrinsics.areEqual(this.crowdfundingAtmosFloorVO, productDetailsData.crowdfundingAtmosFloorVO) && Intrinsics.areEqual(this.crowdfundingProgressFloorVO, productDetailsData.crowdfundingProgressFloorVO) && Intrinsics.areEqual(this.crowdfundingStairsFloorVO, productDetailsData.crowdfundingStairsFloorVO) && Intrinsics.areEqual(this.deliveryInfoFloorVO, productDetailsData.deliveryInfoFloorVO) && Intrinsics.areEqual(this.depositPrice, productDetailsData.depositPrice) && Intrinsics.areEqual(this.detailDescFloorVO, productDetailsData.detailDescFloorVO) && Intrinsics.areEqual(this.fileInfoFloorVO, productDetailsData.fileInfoFloorVO) && Intrinsics.areEqual(this.fixedTabSkin, productDetailsData.fixedTabSkin) && Intrinsics.areEqual(this.floorKeys, productDetailsData.floorKeys) && Intrinsics.areEqual(this.footerFloorVO, productDetailsData.footerFloorVO) && Intrinsics.areEqual(this.fromTm, productDetailsData.fromTm) && Intrinsics.areEqual(this.globalSkin, productDetailsData.globalSkin) && Intrinsics.areEqual(this.headerFloorVO, productDetailsData.headerFloorVO) && Intrinsics.areEqual(this.ipBrandFloorVO, productDetailsData.ipBrandFloorVO) && Intrinsics.areEqual(this.itemsId, productDetailsData.itemsId) && Intrinsics.areEqual(this.itemsStatus, productDetailsData.itemsStatus) && Intrinsics.areEqual(this.mallRecExpBO, productDetailsData.mallRecExpBO) && Intrinsics.areEqual(this.maxActivityDepositPrice, productDetailsData.maxActivityDepositPrice) && Intrinsics.areEqual(this.maxActivityOriginalDepositPrice, productDetailsData.maxActivityOriginalDepositPrice) && Intrinsics.areEqual(this.maxActivityOriginalPrice, productDetailsData.maxActivityOriginalPrice) && Intrinsics.areEqual(this.maxActivityPrice, productDetailsData.maxActivityPrice) && Intrinsics.areEqual(this.mergeAtmospherePriceFloorVO, productDetailsData.mergeAtmospherePriceFloorVO) && Intrinsics.areEqual(this.multiSku, productDetailsData.multiSku) && Intrinsics.areEqual(this.merchantInfo, productDetailsData.merchantInfo) && Intrinsics.areEqual(this.preSale, productDetailsData.preSale) && Intrinsics.areEqual(this.presaleDeliveryTimeStr, productDetailsData.presaleDeliveryTimeStr) && Intrinsics.areEqual(this.priceFloorVO, productDetailsData.priceFloorVO) && Intrinsics.areEqual(this.recFloorVO, productDetailsData.recFloorVO) && Intrinsics.areEqual(this.restriction, productDetailsData.restriction) && Intrinsics.areEqual(this.restrictionPerOrder, productDetailsData.restrictionPerOrder) && Intrinsics.areEqual(this.saleStatus, productDetailsData.saleStatus) && Intrinsics.areEqual(this.seriesFloorVO, productDetailsData.seriesFloorVO) && Intrinsics.areEqual(this.serviceDescFloorVO, productDetailsData.serviceDescFloorVO) && Intrinsics.areEqual(this.serviceFloorVO, productDetailsData.serviceFloorVO) && Intrinsics.areEqual(this.shopInfoFloorVO, productDetailsData.shopInfoFloorVO) && Intrinsics.areEqual(this.skuInfoFloorVO, productDetailsData.skuInfoFloorVO) && Intrinsics.areEqual(this.status, productDetailsData.status) && Intrinsics.areEqual(this.upMeasureFloorVO, productDetailsData.upMeasureFloorVO) && Intrinsics.areEqual(this.videoSkin, productDetailsData.videoSkin) && Intrinsics.areEqual(this.userInteractInfos, productDetailsData.userInteractInfos);
                    }
                    return false;
                }

                public int hashCode() {
                    return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.actAtmosphereFloorVO == null ? 0 : this.actAtmosphereFloorVO.hashCode()) * 31) + (this.activityDepositPrice == null ? 0 : this.activityDepositPrice.hashCode())) * 31) + (this.activityInfoFloorVO == null ? 0 : this.activityInfoFloorVO.hashCode())) * 31) + (this.activityOriginalDepositPrice == null ? 0 : this.activityOriginalDepositPrice.hashCode())) * 31) + (this.activityOriginalPrice == null ? 0 : this.activityOriginalPrice.hashCode())) * 31) + (this.activityPrice == null ? 0 : this.activityPrice.hashCode())) * 31) + (this.activityTags == null ? 0 : this.activityTags.hashCode())) * 31) + (this.advStateFloorVO == null ? 0 : this.advStateFloorVO.hashCode())) * 31) + (this.atmospherePriceFloorVO == null ? 0 : this.atmospherePriceFloorVO.hashCode())) * 31) + (this.attrFloorVO == null ? 0 : this.attrFloorVO.hashCode())) * 31) + (this.autoOnSaleTime == null ? 0 : this.autoOnSaleTime.hashCode())) * 31) + (this.basicInfoFloorVO == null ? 0 : this.basicInfoFloorVO.hashCode())) * 31) + (this.canAddCart == null ? 0 : this.canAddCart.hashCode())) * 31) + (this.cmcContentType == null ? 0 : this.cmcContentType.hashCode())) * 31) + (this.commentFloorVO == null ? 0 : this.commentFloorVO.hashCode())) * 31) + (this.commitmentTag == null ? 0 : this.commitmentTag.hashCode())) * 31) + (this.couponInfoFloorVO == null ? 0 : this.couponInfoFloorVO.hashCode())) * 31) + (this.courseInfoFloorVO == null ? 0 : this.courseInfoFloorVO.hashCode())) * 31) + (this.crowdfundingAtmosFloorVO == null ? 0 : this.crowdfundingAtmosFloorVO.hashCode())) * 31) + (this.crowdfundingProgressFloorVO == null ? 0 : this.crowdfundingProgressFloorVO.hashCode())) * 31) + (this.crowdfundingStairsFloorVO == null ? 0 : this.crowdfundingStairsFloorVO.hashCode())) * 31) + (this.deliveryInfoFloorVO == null ? 0 : this.deliveryInfoFloorVO.hashCode())) * 31) + (this.depositPrice == null ? 0 : this.depositPrice.hashCode())) * 31) + (this.detailDescFloorVO == null ? 0 : this.detailDescFloorVO.hashCode())) * 31) + (this.fileInfoFloorVO == null ? 0 : this.fileInfoFloorVO.hashCode())) * 31) + (this.fixedTabSkin == null ? 0 : this.fixedTabSkin.hashCode())) * 31) + (this.floorKeys == null ? 0 : this.floorKeys.hashCode())) * 31) + (this.footerFloorVO == null ? 0 : this.footerFloorVO.hashCode())) * 31) + (this.fromTm == null ? 0 : this.fromTm.hashCode())) * 31) + (this.globalSkin == null ? 0 : this.globalSkin.hashCode())) * 31) + (this.headerFloorVO == null ? 0 : this.headerFloorVO.hashCode())) * 31) + (this.ipBrandFloorVO == null ? 0 : this.ipBrandFloorVO.hashCode())) * 31) + (this.itemsId == null ? 0 : this.itemsId.hashCode())) * 31) + (this.itemsStatus == null ? 0 : this.itemsStatus.hashCode())) * 31) + (this.mallRecExpBO == null ? 0 : this.mallRecExpBO.hashCode())) * 31) + (this.maxActivityDepositPrice == null ? 0 : this.maxActivityDepositPrice.hashCode())) * 31) + (this.maxActivityOriginalDepositPrice == null ? 0 : this.maxActivityOriginalDepositPrice.hashCode())) * 31) + (this.maxActivityOriginalPrice == null ? 0 : this.maxActivityOriginalPrice.hashCode())) * 31) + (this.maxActivityPrice == null ? 0 : this.maxActivityPrice.hashCode())) * 31) + (this.mergeAtmospherePriceFloorVO == null ? 0 : this.mergeAtmospherePriceFloorVO.hashCode())) * 31) + (this.multiSku == null ? 0 : this.multiSku.hashCode())) * 31) + (this.merchantInfo == null ? 0 : this.merchantInfo.hashCode())) * 31) + (this.preSale == null ? 0 : this.preSale.hashCode())) * 31) + (this.presaleDeliveryTimeStr == null ? 0 : this.presaleDeliveryTimeStr.hashCode())) * 31) + (this.priceFloorVO == null ? 0 : this.priceFloorVO.hashCode())) * 31) + (this.recFloorVO == null ? 0 : this.recFloorVO.hashCode())) * 31) + (this.restriction == null ? 0 : this.restriction.hashCode())) * 31) + (this.restrictionPerOrder == null ? 0 : this.restrictionPerOrder.hashCode())) * 31) + (this.saleStatus == null ? 0 : this.saleStatus.hashCode())) * 31) + (this.seriesFloorVO == null ? 0 : this.seriesFloorVO.hashCode())) * 31) + (this.serviceDescFloorVO == null ? 0 : this.serviceDescFloorVO.hashCode())) * 31) + (this.serviceFloorVO == null ? 0 : this.serviceFloorVO.hashCode())) * 31) + (this.shopInfoFloorVO == null ? 0 : this.shopInfoFloorVO.hashCode())) * 31) + (this.skuInfoFloorVO == null ? 0 : this.skuInfoFloorVO.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.upMeasureFloorVO == null ? 0 : this.upMeasureFloorVO.hashCode())) * 31) + (this.videoSkin == null ? 0 : this.videoSkin.hashCode())) * 31) + (this.userInteractInfos != null ? this.userInteractInfos.hashCode() : 0);
                }

                public String toString() {
                    ActAtmosphereFloor actAtmosphereFloor = this.actAtmosphereFloorVO;
                    String str = this.activityDepositPrice;
                    ActivityInfoFloor activityInfoFloor = this.activityInfoFloorVO;
                    String str2 = this.activityOriginalDepositPrice;
                    String str3 = this.activityOriginalPrice;
                    String str4 = this.activityPrice;
                    String str5 = this.activityTags;
                    AdvStateFloor advStateFloor = this.advStateFloorVO;
                    AtmospherePriceFloor atmospherePriceFloor = this.atmospherePriceFloorVO;
                    AttrFloor attrFloor = this.attrFloorVO;
                    Integer num = this.autoOnSaleTime;
                    BasicInfoFloor basicInfoFloor = this.basicInfoFloorVO;
                    Byte b = this.canAddCart;
                    Integer num2 = this.cmcContentType;
                    CommentFloor commentFloor = this.commentFloorVO;
                    List<CommitmentTag> list = this.commitmentTag;
                    CouponInfoFloor couponInfoFloor = this.couponInfoFloorVO;
                    CourseInfoFloor courseInfoFloor = this.courseInfoFloorVO;
                    CrowdfundingAtmosFloor crowdfundingAtmosFloor = this.crowdfundingAtmosFloorVO;
                    CrowdfundingProgressFloor crowdfundingProgressFloor = this.crowdfundingProgressFloorVO;
                    CrowdfundingStairsFloor crowdfundingStairsFloor = this.crowdfundingStairsFloorVO;
                    DeliveryInfoFloor deliveryInfoFloor = this.deliveryInfoFloorVO;
                    String str6 = this.depositPrice;
                    DetailDescFloor detailDescFloor = this.detailDescFloorVO;
                    FileInfoFloor fileInfoFloor = this.fileInfoFloorVO;
                    FixedTabSkinVO fixedTabSkinVO = this.fixedTabSkin;
                    List<String> list2 = this.floorKeys;
                    FooterFloor footerFloor = this.footerFloorVO;
                    Boolean bool = this.fromTm;
                    GlobalSkinConfigDTO globalSkinConfigDTO = this.globalSkin;
                    HeaderFloor headerFloor = this.headerFloorVO;
                    IpBrandFloor ipBrandFloor = this.ipBrandFloorVO;
                    Long l = this.itemsId;
                    Integer num3 = this.itemsStatus;
                    MallRecExpBO mallRecExpBO = this.mallRecExpBO;
                    String str7 = this.maxActivityDepositPrice;
                    String str8 = this.maxActivityOriginalDepositPrice;
                    String str9 = this.maxActivityOriginalPrice;
                    String str10 = this.maxActivityPrice;
                    MergeAtmospherePriceFloor mergeAtmospherePriceFloor = this.mergeAtmospherePriceFloorVO;
                    Boolean bool2 = this.multiSku;
                    MerchantInfo merchantInfo = this.merchantInfo;
                    Boolean bool3 = this.preSale;
                    String str11 = this.presaleDeliveryTimeStr;
                    PriceFloor priceFloor = this.priceFloorVO;
                    RecFloor recFloor = this.recFloorVO;
                    Integer num4 = this.restriction;
                    Integer num5 = this.restrictionPerOrder;
                    Integer num6 = this.saleStatus;
                    SeriesFloor seriesFloor = this.seriesFloorVO;
                    ServiceDescFloor serviceDescFloor = this.serviceDescFloorVO;
                    ServiceFloor serviceFloor = this.serviceFloorVO;
                    ShopInfoFloor shopInfoFloor = this.shopInfoFloorVO;
                    SkuInfoFloor skuInfoFloor = this.skuInfoFloorVO;
                    Integer num7 = this.status;
                    UpMeasureFloor upMeasureFloor = this.upMeasureFloorVO;
                    VideoSkinConfigDTO videoSkinConfigDTO = this.videoSkin;
                    return "ProductDetailsData(actAtmosphereFloorVO=" + actAtmosphereFloor + ", activityDepositPrice=" + str + ", activityInfoFloorVO=" + activityInfoFloor + ", activityOriginalDepositPrice=" + str2 + ", activityOriginalPrice=" + str3 + ", activityPrice=" + str4 + ", activityTags=" + str5 + ", advStateFloorVO=" + advStateFloor + ", atmospherePriceFloorVO=" + atmospherePriceFloor + ", attrFloorVO=" + attrFloor + ", autoOnSaleTime=" + num + ", basicInfoFloorVO=" + basicInfoFloor + ", canAddCart=" + b + ", cmcContentType=" + num2 + ", commentFloorVO=" + commentFloor + ", commitmentTag=" + list + ", couponInfoFloorVO=" + couponInfoFloor + ", courseInfoFloorVO=" + courseInfoFloor + ", crowdfundingAtmosFloorVO=" + crowdfundingAtmosFloor + ", crowdfundingProgressFloorVO=" + crowdfundingProgressFloor + ", crowdfundingStairsFloorVO=" + crowdfundingStairsFloor + ", deliveryInfoFloorVO=" + deliveryInfoFloor + ", depositPrice=" + str6 + ", detailDescFloorVO=" + detailDescFloor + ", fileInfoFloorVO=" + fileInfoFloor + ", fixedTabSkin=" + fixedTabSkinVO + ", floorKeys=" + list2 + ", footerFloorVO=" + footerFloor + ", fromTm=" + bool + ", globalSkin=" + globalSkinConfigDTO + ", headerFloorVO=" + headerFloor + ", ipBrandFloorVO=" + ipBrandFloor + ", itemsId=" + l + ", itemsStatus=" + num3 + ", mallRecExpBO=" + mallRecExpBO + ", maxActivityDepositPrice=" + str7 + ", maxActivityOriginalDepositPrice=" + str8 + ", maxActivityOriginalPrice=" + str9 + ", maxActivityPrice=" + str10 + ", mergeAtmospherePriceFloorVO=" + mergeAtmospherePriceFloor + ", multiSku=" + bool2 + ", merchantInfo=" + merchantInfo + ", preSale=" + bool3 + ", presaleDeliveryTimeStr=" + str11 + ", priceFloorVO=" + priceFloor + ", recFloorVO=" + recFloor + ", restriction=" + num4 + ", restrictionPerOrder=" + num5 + ", saleStatus=" + num6 + ", seriesFloorVO=" + seriesFloor + ", serviceDescFloorVO=" + serviceDescFloor + ", serviceFloorVO=" + serviceFloor + ", shopInfoFloorVO=" + shopInfoFloor + ", skuInfoFloorVO=" + skuInfoFloor + ", status=" + num7 + ", upMeasureFloorVO=" + upMeasureFloor + ", videoSkin=" + videoSkinConfigDTO + ", userInteractInfos=" + this.userInteractInfos + ")";
                }

                /* compiled from: ResponseModels.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ProductDetailsResponse$ProductDetailsData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ProductDetailsResponse$ProductDetailsData;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<ProductDetailsData> serializer() {
                        return ProductDetailsResponse$ProductDetailsData$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ ProductDetailsData(int seen0, int seen1, ActAtmosphereFloor actAtmosphereFloorVO, String activityDepositPrice, ActivityInfoFloor activityInfoFloorVO, String activityOriginalDepositPrice, String activityOriginalPrice, String activityPrice, String activityTags, AdvStateFloor advStateFloorVO, AtmospherePriceFloor atmospherePriceFloorVO, AttrFloor attrFloorVO, Integer autoOnSaleTime, BasicInfoFloor basicInfoFloorVO, Byte canAddCart, Integer cmcContentType, CommentFloor commentFloorVO, List commitmentTag, CouponInfoFloor couponInfoFloorVO, CourseInfoFloor courseInfoFloorVO, CrowdfundingAtmosFloor crowdfundingAtmosFloorVO, CrowdfundingProgressFloor crowdfundingProgressFloorVO, CrowdfundingStairsFloor crowdfundingStairsFloorVO, DeliveryInfoFloor deliveryInfoFloorVO, String depositPrice, DetailDescFloor detailDescFloorVO, FileInfoFloor fileInfoFloorVO, FixedTabSkinVO fixedTabSkin, List floorKeys, FooterFloor footerFloorVO, Boolean fromTm, GlobalSkinConfigDTO globalSkin, HeaderFloor headerFloorVO, IpBrandFloor ipBrandFloorVO, Long itemsId, Integer itemsStatus, MallRecExpBO mallRecExpBO, String maxActivityDepositPrice, String maxActivityOriginalDepositPrice, String maxActivityOriginalPrice, String maxActivityPrice, MergeAtmospherePriceFloor mergeAtmospherePriceFloorVO, Boolean multiSku, MerchantInfo merchantInfo, Boolean preSale, String presaleDeliveryTimeStr, PriceFloor priceFloorVO, RecFloor recFloorVO, Integer restriction, Integer restrictionPerOrder, Integer saleStatus, SeriesFloor seriesFloorVO, ServiceDescFloor serviceDescFloorVO, ServiceFloor serviceFloorVO, ShopInfoFloor shopInfoFloorVO, SkuInfoFloor skuInfoFloorVO, Integer status, UpMeasureFloor upMeasureFloorVO, VideoSkinConfigDTO videoSkin, List userInteractInfos, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.actAtmosphereFloorVO = null;
                    } else {
                        this.actAtmosphereFloorVO = actAtmosphereFloorVO;
                    }
                    if ((seen0 & 2) == 0) {
                        this.activityDepositPrice = null;
                    } else {
                        this.activityDepositPrice = activityDepositPrice;
                    }
                    if ((seen0 & 4) == 0) {
                        this.activityInfoFloorVO = null;
                    } else {
                        this.activityInfoFloorVO = activityInfoFloorVO;
                    }
                    if ((seen0 & 8) == 0) {
                        this.activityOriginalDepositPrice = null;
                    } else {
                        this.activityOriginalDepositPrice = activityOriginalDepositPrice;
                    }
                    if ((seen0 & 16) == 0) {
                        this.activityOriginalPrice = null;
                    } else {
                        this.activityOriginalPrice = activityOriginalPrice;
                    }
                    if ((seen0 & 32) == 0) {
                        this.activityPrice = null;
                    } else {
                        this.activityPrice = activityPrice;
                    }
                    if ((seen0 & 64) == 0) {
                        this.activityTags = null;
                    } else {
                        this.activityTags = activityTags;
                    }
                    if ((seen0 & 128) == 0) {
                        this.advStateFloorVO = null;
                    } else {
                        this.advStateFloorVO = advStateFloorVO;
                    }
                    if ((seen0 & 256) == 0) {
                        this.atmospherePriceFloorVO = null;
                    } else {
                        this.atmospherePriceFloorVO = atmospherePriceFloorVO;
                    }
                    if ((seen0 & 512) == 0) {
                        this.attrFloorVO = null;
                    } else {
                        this.attrFloorVO = attrFloorVO;
                    }
                    if ((seen0 & 1024) == 0) {
                        this.autoOnSaleTime = null;
                    } else {
                        this.autoOnSaleTime = autoOnSaleTime;
                    }
                    if ((seen0 & 2048) == 0) {
                        this.basicInfoFloorVO = null;
                    } else {
                        this.basicInfoFloorVO = basicInfoFloorVO;
                    }
                    if ((seen0 & 4096) == 0) {
                        this.canAddCart = null;
                    } else {
                        this.canAddCart = canAddCart;
                    }
                    if ((seen0 & 8192) == 0) {
                        this.cmcContentType = null;
                    } else {
                        this.cmcContentType = cmcContentType;
                    }
                    if ((seen0 & 16384) == 0) {
                        this.commentFloorVO = null;
                    } else {
                        this.commentFloorVO = commentFloorVO;
                    }
                    if ((seen0 & 32768) == 0) {
                        this.commitmentTag = null;
                    } else {
                        this.commitmentTag = commitmentTag;
                    }
                    if ((seen0 & 65536) == 0) {
                        this.couponInfoFloorVO = null;
                    } else {
                        this.couponInfoFloorVO = couponInfoFloorVO;
                    }
                    if ((seen0 & 131072) == 0) {
                        this.courseInfoFloorVO = null;
                    } else {
                        this.courseInfoFloorVO = courseInfoFloorVO;
                    }
                    if ((seen0 & 262144) == 0) {
                        this.crowdfundingAtmosFloorVO = null;
                    } else {
                        this.crowdfundingAtmosFloorVO = crowdfundingAtmosFloorVO;
                    }
                    if ((seen0 & 524288) == 0) {
                        this.crowdfundingProgressFloorVO = null;
                    } else {
                        this.crowdfundingProgressFloorVO = crowdfundingProgressFloorVO;
                    }
                    if ((seen0 & 1048576) == 0) {
                        this.crowdfundingStairsFloorVO = null;
                    } else {
                        this.crowdfundingStairsFloorVO = crowdfundingStairsFloorVO;
                    }
                    if ((seen0 & 2097152) == 0) {
                        this.deliveryInfoFloorVO = null;
                    } else {
                        this.deliveryInfoFloorVO = deliveryInfoFloorVO;
                    }
                    if ((seen0 & 4194304) == 0) {
                        this.depositPrice = null;
                    } else {
                        this.depositPrice = depositPrice;
                    }
                    if ((seen0 & 8388608) == 0) {
                        this.detailDescFloorVO = null;
                    } else {
                        this.detailDescFloorVO = detailDescFloorVO;
                    }
                    if ((seen0 & 16777216) == 0) {
                        this.fileInfoFloorVO = null;
                    } else {
                        this.fileInfoFloorVO = fileInfoFloorVO;
                    }
                    if ((seen0 & 33554432) == 0) {
                        this.fixedTabSkin = null;
                    } else {
                        this.fixedTabSkin = fixedTabSkin;
                    }
                    if ((seen0 & 67108864) == 0) {
                        this.floorKeys = null;
                    } else {
                        this.floorKeys = floorKeys;
                    }
                    if ((seen0 & 134217728) == 0) {
                        this.footerFloorVO = null;
                    } else {
                        this.footerFloorVO = footerFloorVO;
                    }
                    if ((seen0 & 268435456) == 0) {
                        this.fromTm = null;
                    } else {
                        this.fromTm = fromTm;
                    }
                    if ((seen0 & 536870912) == 0) {
                        this.globalSkin = null;
                    } else {
                        this.globalSkin = globalSkin;
                    }
                    if ((seen0 & 1073741824) == 0) {
                        this.headerFloorVO = null;
                    } else {
                        this.headerFloorVO = headerFloorVO;
                    }
                    if ((seen0 & Integer.MIN_VALUE) == 0) {
                        this.ipBrandFloorVO = null;
                    } else {
                        this.ipBrandFloorVO = ipBrandFloorVO;
                    }
                    if ((seen1 & 1) == 0) {
                        this.itemsId = null;
                    } else {
                        this.itemsId = itemsId;
                    }
                    if ((seen1 & 2) == 0) {
                        this.itemsStatus = null;
                    } else {
                        this.itemsStatus = itemsStatus;
                    }
                    if ((seen1 & 4) == 0) {
                        this.mallRecExpBO = null;
                    } else {
                        this.mallRecExpBO = mallRecExpBO;
                    }
                    if ((seen1 & 8) == 0) {
                        this.maxActivityDepositPrice = null;
                    } else {
                        this.maxActivityDepositPrice = maxActivityDepositPrice;
                    }
                    if ((seen1 & 16) == 0) {
                        this.maxActivityOriginalDepositPrice = null;
                    } else {
                        this.maxActivityOriginalDepositPrice = maxActivityOriginalDepositPrice;
                    }
                    if ((seen1 & 32) == 0) {
                        this.maxActivityOriginalPrice = null;
                    } else {
                        this.maxActivityOriginalPrice = maxActivityOriginalPrice;
                    }
                    if ((seen1 & 64) == 0) {
                        this.maxActivityPrice = null;
                    } else {
                        this.maxActivityPrice = maxActivityPrice;
                    }
                    if ((seen1 & 128) == 0) {
                        this.mergeAtmospherePriceFloorVO = null;
                    } else {
                        this.mergeAtmospherePriceFloorVO = mergeAtmospherePriceFloorVO;
                    }
                    if ((seen1 & 256) == 0) {
                        this.multiSku = null;
                    } else {
                        this.multiSku = multiSku;
                    }
                    if ((seen1 & 512) == 0) {
                        this.merchantInfo = null;
                    } else {
                        this.merchantInfo = merchantInfo;
                    }
                    if ((seen1 & 1024) == 0) {
                        this.preSale = null;
                    } else {
                        this.preSale = preSale;
                    }
                    if ((seen1 & 2048) == 0) {
                        this.presaleDeliveryTimeStr = null;
                    } else {
                        this.presaleDeliveryTimeStr = presaleDeliveryTimeStr;
                    }
                    if ((seen1 & 4096) == 0) {
                        this.priceFloorVO = null;
                    } else {
                        this.priceFloorVO = priceFloorVO;
                    }
                    if ((seen1 & 8192) == 0) {
                        this.recFloorVO = null;
                    } else {
                        this.recFloorVO = recFloorVO;
                    }
                    if ((seen1 & 16384) == 0) {
                        this.restriction = null;
                    } else {
                        this.restriction = restriction;
                    }
                    if ((seen1 & 32768) == 0) {
                        this.restrictionPerOrder = null;
                    } else {
                        this.restrictionPerOrder = restrictionPerOrder;
                    }
                    if ((seen1 & 65536) == 0) {
                        this.saleStatus = null;
                    } else {
                        this.saleStatus = saleStatus;
                    }
                    if ((seen1 & 131072) == 0) {
                        this.seriesFloorVO = null;
                    } else {
                        this.seriesFloorVO = seriesFloorVO;
                    }
                    if ((seen1 & 262144) == 0) {
                        this.serviceDescFloorVO = null;
                    } else {
                        this.serviceDescFloorVO = serviceDescFloorVO;
                    }
                    if ((seen1 & 524288) == 0) {
                        this.serviceFloorVO = null;
                    } else {
                        this.serviceFloorVO = serviceFloorVO;
                    }
                    if ((seen1 & 1048576) == 0) {
                        this.shopInfoFloorVO = null;
                    } else {
                        this.shopInfoFloorVO = shopInfoFloorVO;
                    }
                    if ((seen1 & 2097152) == 0) {
                        this.skuInfoFloorVO = null;
                    } else {
                        this.skuInfoFloorVO = skuInfoFloorVO;
                    }
                    if ((seen1 & 4194304) == 0) {
                        this.status = null;
                    } else {
                        this.status = status;
                    }
                    if ((seen1 & 8388608) == 0) {
                        this.upMeasureFloorVO = null;
                    } else {
                        this.upMeasureFloorVO = upMeasureFloorVO;
                    }
                    if ((seen1 & 16777216) == 0) {
                        this.videoSkin = null;
                    } else {
                        this.videoSkin = videoSkin;
                    }
                    if ((seen1 & 33554432) == 0) {
                        this.userInteractInfos = null;
                    } else {
                        this.userInteractInfos = userInteractInfos;
                    }
                }

                public ProductDetailsData(ActAtmosphereFloor actAtmosphereFloorVO, String activityDepositPrice, ActivityInfoFloor activityInfoFloorVO, String activityOriginalDepositPrice, String activityOriginalPrice, String activityPrice, String activityTags, AdvStateFloor advStateFloorVO, AtmospherePriceFloor atmospherePriceFloorVO, AttrFloor attrFloorVO, Integer autoOnSaleTime, BasicInfoFloor basicInfoFloorVO, Byte canAddCart, Integer cmcContentType, CommentFloor commentFloorVO, List<CommitmentTag> list, CouponInfoFloor couponInfoFloorVO, CourseInfoFloor courseInfoFloorVO, CrowdfundingAtmosFloor crowdfundingAtmosFloorVO, CrowdfundingProgressFloor crowdfundingProgressFloorVO, CrowdfundingStairsFloor crowdfundingStairsFloorVO, DeliveryInfoFloor deliveryInfoFloorVO, String depositPrice, DetailDescFloor detailDescFloorVO, FileInfoFloor fileInfoFloorVO, FixedTabSkinVO fixedTabSkin, List<String> list2, FooterFloor footerFloorVO, Boolean fromTm, GlobalSkinConfigDTO globalSkin, HeaderFloor headerFloorVO, IpBrandFloor ipBrandFloorVO, Long itemsId, Integer itemsStatus, MallRecExpBO mallRecExpBO, String maxActivityDepositPrice, String maxActivityOriginalDepositPrice, String maxActivityOriginalPrice, String maxActivityPrice, MergeAtmospherePriceFloor mergeAtmospherePriceFloorVO, Boolean multiSku, MerchantInfo merchantInfo, Boolean preSale, String presaleDeliveryTimeStr, PriceFloor priceFloorVO, RecFloor recFloorVO, Integer restriction, Integer restrictionPerOrder, Integer saleStatus, SeriesFloor seriesFloorVO, ServiceDescFloor serviceDescFloorVO, ServiceFloor serviceFloorVO, ShopInfoFloor shopInfoFloorVO, SkuInfoFloor skuInfoFloorVO, Integer status, UpMeasureFloor upMeasureFloorVO, VideoSkinConfigDTO videoSkin, List<ActionIconModel> list3) {
                    this.actAtmosphereFloorVO = actAtmosphereFloorVO;
                    this.activityDepositPrice = activityDepositPrice;
                    this.activityInfoFloorVO = activityInfoFloorVO;
                    this.activityOriginalDepositPrice = activityOriginalDepositPrice;
                    this.activityOriginalPrice = activityOriginalPrice;
                    this.activityPrice = activityPrice;
                    this.activityTags = activityTags;
                    this.advStateFloorVO = advStateFloorVO;
                    this.atmospherePriceFloorVO = atmospherePriceFloorVO;
                    this.attrFloorVO = attrFloorVO;
                    this.autoOnSaleTime = autoOnSaleTime;
                    this.basicInfoFloorVO = basicInfoFloorVO;
                    this.canAddCart = canAddCart;
                    this.cmcContentType = cmcContentType;
                    this.commentFloorVO = commentFloorVO;
                    this.commitmentTag = list;
                    this.couponInfoFloorVO = couponInfoFloorVO;
                    this.courseInfoFloorVO = courseInfoFloorVO;
                    this.crowdfundingAtmosFloorVO = crowdfundingAtmosFloorVO;
                    this.crowdfundingProgressFloorVO = crowdfundingProgressFloorVO;
                    this.crowdfundingStairsFloorVO = crowdfundingStairsFloorVO;
                    this.deliveryInfoFloorVO = deliveryInfoFloorVO;
                    this.depositPrice = depositPrice;
                    this.detailDescFloorVO = detailDescFloorVO;
                    this.fileInfoFloorVO = fileInfoFloorVO;
                    this.fixedTabSkin = fixedTabSkin;
                    this.floorKeys = list2;
                    this.footerFloorVO = footerFloorVO;
                    this.fromTm = fromTm;
                    this.globalSkin = globalSkin;
                    this.headerFloorVO = headerFloorVO;
                    this.ipBrandFloorVO = ipBrandFloorVO;
                    this.itemsId = itemsId;
                    this.itemsStatus = itemsStatus;
                    this.mallRecExpBO = mallRecExpBO;
                    this.maxActivityDepositPrice = maxActivityDepositPrice;
                    this.maxActivityOriginalDepositPrice = maxActivityOriginalDepositPrice;
                    this.maxActivityOriginalPrice = maxActivityOriginalPrice;
                    this.maxActivityPrice = maxActivityPrice;
                    this.mergeAtmospherePriceFloorVO = mergeAtmospherePriceFloorVO;
                    this.multiSku = multiSku;
                    this.merchantInfo = merchantInfo;
                    this.preSale = preSale;
                    this.presaleDeliveryTimeStr = presaleDeliveryTimeStr;
                    this.priceFloorVO = priceFloorVO;
                    this.recFloorVO = recFloorVO;
                    this.restriction = restriction;
                    this.restrictionPerOrder = restrictionPerOrder;
                    this.saleStatus = saleStatus;
                    this.seriesFloorVO = seriesFloorVO;
                    this.serviceDescFloorVO = serviceDescFloorVO;
                    this.serviceFloorVO = serviceFloorVO;
                    this.shopInfoFloorVO = shopInfoFloorVO;
                    this.skuInfoFloorVO = skuInfoFloorVO;
                    this.status = status;
                    this.upMeasureFloorVO = upMeasureFloorVO;
                    this.videoSkin = videoSkin;
                    this.userInteractInfos = list3;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                    return new ArrayListSerializer(CommitmentTag$$serializer.INSTANCE);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                    return new ArrayListSerializer(StringSerializer.INSTANCE);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
                    return new ArrayListSerializer(ActionIconModel$$serializer.INSTANCE);
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(ProductDetailsData self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.actAtmosphereFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, ActAtmosphereFloor$$serializer.INSTANCE, self.actAtmosphereFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.activityDepositPrice != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.activityDepositPrice);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.activityInfoFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, ActivityInfoFloor$$serializer.INSTANCE, self.activityInfoFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.activityOriginalDepositPrice != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.activityOriginalDepositPrice);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.activityOriginalPrice != null) {
                        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.activityOriginalPrice);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 5) || self.activityPrice != null) {
                        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.activityPrice);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 6) || self.activityTags != null) {
                        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.activityTags);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 7) || self.advStateFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 7, AdvStateFloor$$serializer.INSTANCE, self.advStateFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 8) || self.atmospherePriceFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 8, AtmospherePriceFloor$$serializer.INSTANCE, self.atmospherePriceFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 9) || self.attrFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 9, AttrFloor$$serializer.INSTANCE, self.attrFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 10) || self.autoOnSaleTime != null) {
                        output.encodeNullableSerializableElement(serialDesc, 10, IntSerializer.INSTANCE, self.autoOnSaleTime);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 11) || self.basicInfoFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 11, BasicInfoFloor$$serializer.INSTANCE, self.basicInfoFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 12) || self.canAddCart != null) {
                        output.encodeNullableSerializableElement(serialDesc, 12, ByteSerializer.INSTANCE, self.canAddCart);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 13) || self.cmcContentType != null) {
                        output.encodeNullableSerializableElement(serialDesc, 13, IntSerializer.INSTANCE, self.cmcContentType);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 14) || self.commentFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 14, CommentFloor$$serializer.INSTANCE, self.commentFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 15) || self.commitmentTag != null) {
                        output.encodeNullableSerializableElement(serialDesc, 15, lazyArr[15].getValue(), self.commitmentTag);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 16) || self.couponInfoFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 16, CouponInfoFloor$$serializer.INSTANCE, self.couponInfoFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 17) || self.courseInfoFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 17, CourseInfoFloor$$serializer.INSTANCE, self.courseInfoFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 18) || self.crowdfundingAtmosFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 18, CrowdfundingAtmosFloor$$serializer.INSTANCE, self.crowdfundingAtmosFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 19) || self.crowdfundingProgressFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 19, CrowdfundingProgressFloor$$serializer.INSTANCE, self.crowdfundingProgressFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 20) || self.crowdfundingStairsFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 20, CrowdfundingStairsFloor$$serializer.INSTANCE, self.crowdfundingStairsFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 21) || self.deliveryInfoFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 21, DeliveryInfoFloor$$serializer.INSTANCE, self.deliveryInfoFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 22) || self.depositPrice != null) {
                        output.encodeNullableSerializableElement(serialDesc, 22, StringSerializer.INSTANCE, self.depositPrice);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 23) || self.detailDescFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 23, DetailDescFloor$$serializer.INSTANCE, self.detailDescFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 24) || self.fileInfoFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 24, FileInfoFloor$$serializer.INSTANCE, self.fileInfoFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 25) || self.fixedTabSkin != null) {
                        output.encodeNullableSerializableElement(serialDesc, 25, FixedTabSkinVO$$serializer.INSTANCE, self.fixedTabSkin);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 26) || self.floorKeys != null) {
                        output.encodeNullableSerializableElement(serialDesc, 26, lazyArr[26].getValue(), self.floorKeys);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 27) || self.footerFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 27, FooterFloor$$serializer.INSTANCE, self.footerFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 28) || self.fromTm != null) {
                        output.encodeNullableSerializableElement(serialDesc, 28, BooleanSerializer.INSTANCE, self.fromTm);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 29) || self.globalSkin != null) {
                        output.encodeNullableSerializableElement(serialDesc, 29, GlobalSkinConfigDTO$$serializer.INSTANCE, self.globalSkin);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 30) || self.headerFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 30, HeaderFloor$$serializer.INSTANCE, self.headerFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 31) || self.ipBrandFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 31, IpBrandFloor$$serializer.INSTANCE, self.ipBrandFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 32) || self.itemsId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 32, LongSerializer.INSTANCE, self.itemsId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 33) || self.itemsStatus != null) {
                        output.encodeNullableSerializableElement(serialDesc, 33, IntSerializer.INSTANCE, self.itemsStatus);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 34) || self.mallRecExpBO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 34, MallRecExpBO$$serializer.INSTANCE, self.mallRecExpBO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 35) || self.maxActivityDepositPrice != null) {
                        output.encodeNullableSerializableElement(serialDesc, 35, StringSerializer.INSTANCE, self.maxActivityDepositPrice);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 36) || self.maxActivityOriginalDepositPrice != null) {
                        output.encodeNullableSerializableElement(serialDesc, 36, StringSerializer.INSTANCE, self.maxActivityOriginalDepositPrice);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 37) || self.maxActivityOriginalPrice != null) {
                        output.encodeNullableSerializableElement(serialDesc, 37, StringSerializer.INSTANCE, self.maxActivityOriginalPrice);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 38) || self.maxActivityPrice != null) {
                        output.encodeNullableSerializableElement(serialDesc, 38, StringSerializer.INSTANCE, self.maxActivityPrice);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 39) || self.mergeAtmospherePriceFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 39, MergeAtmospherePriceFloor$$serializer.INSTANCE, self.mergeAtmospherePriceFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 40) || self.multiSku != null) {
                        output.encodeNullableSerializableElement(serialDesc, 40, BooleanSerializer.INSTANCE, self.multiSku);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 41) || self.merchantInfo != null) {
                        output.encodeNullableSerializableElement(serialDesc, 41, MerchantInfo$$serializer.INSTANCE, self.merchantInfo);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 42) || self.preSale != null) {
                        output.encodeNullableSerializableElement(serialDesc, 42, BooleanSerializer.INSTANCE, self.preSale);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 43) || self.presaleDeliveryTimeStr != null) {
                        output.encodeNullableSerializableElement(serialDesc, 43, StringSerializer.INSTANCE, self.presaleDeliveryTimeStr);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 44) || self.priceFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 44, PriceFloor$$serializer.INSTANCE, self.priceFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 45) || self.recFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 45, RecFloor$$serializer.INSTANCE, self.recFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 46) || self.restriction != null) {
                        output.encodeNullableSerializableElement(serialDesc, 46, IntSerializer.INSTANCE, self.restriction);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 47) || self.restrictionPerOrder != null) {
                        output.encodeNullableSerializableElement(serialDesc, 47, IntSerializer.INSTANCE, self.restrictionPerOrder);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 48) || self.saleStatus != null) {
                        output.encodeNullableSerializableElement(serialDesc, 48, IntSerializer.INSTANCE, self.saleStatus);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 49) || self.seriesFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 49, SeriesFloor$$serializer.INSTANCE, self.seriesFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 50) || self.serviceDescFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 50, ServiceDescFloor$$serializer.INSTANCE, self.serviceDescFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 51) || self.serviceFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 51, ServiceFloor$$serializer.INSTANCE, self.serviceFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 52) || self.shopInfoFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 52, ShopInfoFloor$$serializer.INSTANCE, self.shopInfoFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 53) || self.skuInfoFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 53, SkuInfoFloor$$serializer.INSTANCE, self.skuInfoFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 54) || self.status != null) {
                        output.encodeNullableSerializableElement(serialDesc, 54, IntSerializer.INSTANCE, self.status);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 55) || self.upMeasureFloorVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 55, UpMeasureFloor$$serializer.INSTANCE, self.upMeasureFloorVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 56) || self.videoSkin != null) {
                        output.encodeNullableSerializableElement(serialDesc, 56, VideoSkinConfigDTO$$serializer.INSTANCE, self.videoSkin);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 57) || self.userInteractInfos != null) {
                        output.encodeNullableSerializableElement(serialDesc, 57, lazyArr[57].getValue(), self.userInteractInfos);
                    }
                }

                public /* synthetic */ ProductDetailsData(ActAtmosphereFloor actAtmosphereFloor, String str, ActivityInfoFloor activityInfoFloor, String str2, String str3, String str4, String str5, AdvStateFloor advStateFloor, AtmospherePriceFloor atmospherePriceFloor, AttrFloor attrFloor, Integer num, BasicInfoFloor basicInfoFloor, Byte b, Integer num2, CommentFloor commentFloor, List list, CouponInfoFloor couponInfoFloor, CourseInfoFloor courseInfoFloor, CrowdfundingAtmosFloor crowdfundingAtmosFloor, CrowdfundingProgressFloor crowdfundingProgressFloor, CrowdfundingStairsFloor crowdfundingStairsFloor, DeliveryInfoFloor deliveryInfoFloor, String str6, DetailDescFloor detailDescFloor, FileInfoFloor fileInfoFloor, FixedTabSkinVO fixedTabSkinVO, List list2, FooterFloor footerFloor, Boolean bool, GlobalSkinConfigDTO globalSkinConfigDTO, HeaderFloor headerFloor, IpBrandFloor ipBrandFloor, Long l, Integer num3, MallRecExpBO mallRecExpBO, String str7, String str8, String str9, String str10, MergeAtmospherePriceFloor mergeAtmospherePriceFloor, Boolean bool2, MerchantInfo merchantInfo, Boolean bool3, String str11, PriceFloor priceFloor, RecFloor recFloor, Integer num4, Integer num5, Integer num6, SeriesFloor seriesFloor, ServiceDescFloor serviceDescFloor, ServiceFloor serviceFloor, ShopInfoFloor shopInfoFloor, SkuInfoFloor skuInfoFloor, Integer num7, UpMeasureFloor upMeasureFloor, VideoSkinConfigDTO videoSkinConfigDTO, List list3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : actAtmosphereFloor, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : activityInfoFloor, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : advStateFloor, (i & 256) != 0 ? null : atmospherePriceFloor, (i & 512) != 0 ? null : attrFloor, (i & 1024) != 0 ? null : num, (i & 2048) != 0 ? null : basicInfoFloor, (i & 4096) != 0 ? null : b, (i & 8192) != 0 ? null : num2, (i & 16384) != 0 ? null : commentFloor, (i & 32768) != 0 ? null : list, (i & 65536) != 0 ? null : couponInfoFloor, (i & 131072) != 0 ? null : courseInfoFloor, (i & 262144) != 0 ? null : crowdfundingAtmosFloor, (i & 524288) != 0 ? null : crowdfundingProgressFloor, (i & 1048576) != 0 ? null : crowdfundingStairsFloor, (i & 2097152) != 0 ? null : deliveryInfoFloor, (i & 4194304) != 0 ? null : str6, (i & 8388608) != 0 ? null : detailDescFloor, (i & 16777216) != 0 ? null : fileInfoFloor, (i & 33554432) != 0 ? null : fixedTabSkinVO, (i & 67108864) != 0 ? null : list2, (i & 134217728) != 0 ? null : footerFloor, (i & 268435456) != 0 ? null : bool, (i & 536870912) != 0 ? null : globalSkinConfigDTO, (i & 1073741824) != 0 ? null : headerFloor, (i & Integer.MIN_VALUE) != 0 ? null : ipBrandFloor, (i2 & 1) != 0 ? null : l, (i2 & 2) != 0 ? null : num3, (i2 & 4) != 0 ? null : mallRecExpBO, (i2 & 8) != 0 ? null : str7, (i2 & 16) != 0 ? null : str8, (i2 & 32) != 0 ? null : str9, (i2 & 64) != 0 ? null : str10, (i2 & 128) != 0 ? null : mergeAtmospherePriceFloor, (i2 & 256) != 0 ? null : bool2, (i2 & 512) != 0 ? null : merchantInfo, (i2 & 1024) != 0 ? null : bool3, (i2 & 2048) != 0 ? null : str11, (i2 & 4096) != 0 ? null : priceFloor, (i2 & 8192) != 0 ? null : recFloor, (i2 & 16384) != 0 ? null : num4, (i2 & 32768) != 0 ? null : num5, (i2 & 65536) != 0 ? null : num6, (i2 & 131072) != 0 ? null : seriesFloor, (i2 & 262144) != 0 ? null : serviceDescFloor, (i2 & 524288) != 0 ? null : serviceFloor, (i2 & 1048576) != 0 ? null : shopInfoFloor, (i2 & 2097152) != 0 ? null : skuInfoFloor, (i2 & 4194304) != 0 ? null : num7, (i2 & 8388608) != 0 ? null : upMeasureFloor, (i2 & 16777216) != 0 ? null : videoSkinConfigDTO, (i2 & 33554432) != 0 ? null : list3);
                }

                public final ActAtmosphereFloor getActAtmosphereFloorVO() {
                    return this.actAtmosphereFloorVO;
                }

                public final String getActivityDepositPrice() {
                    return this.activityDepositPrice;
                }

                public final ActivityInfoFloor getActivityInfoFloorVO() {
                    return this.activityInfoFloorVO;
                }

                public final String getActivityOriginalDepositPrice() {
                    return this.activityOriginalDepositPrice;
                }

                public final String getActivityOriginalPrice() {
                    return this.activityOriginalPrice;
                }

                public final String getActivityPrice() {
                    return this.activityPrice;
                }

                public final String getActivityTags() {
                    return this.activityTags;
                }

                public final AdvStateFloor getAdvStateFloorVO() {
                    return this.advStateFloorVO;
                }

                public final AtmospherePriceFloor getAtmospherePriceFloorVO() {
                    return this.atmospherePriceFloorVO;
                }

                public final AttrFloor getAttrFloorVO() {
                    return this.attrFloorVO;
                }

                public final Integer getAutoOnSaleTime() {
                    return this.autoOnSaleTime;
                }

                public final BasicInfoFloor getBasicInfoFloorVO() {
                    return this.basicInfoFloorVO;
                }

                public final Byte getCanAddCart() {
                    return this.canAddCart;
                }

                public final Integer getCmcContentType() {
                    return this.cmcContentType;
                }

                public final CommentFloor getCommentFloorVO() {
                    return this.commentFloorVO;
                }

                public final List<CommitmentTag> getCommitmentTag() {
                    return this.commitmentTag;
                }

                public final CouponInfoFloor getCouponInfoFloorVO() {
                    return this.couponInfoFloorVO;
                }

                public final CourseInfoFloor getCourseInfoFloorVO() {
                    return this.courseInfoFloorVO;
                }

                public final CrowdfundingAtmosFloor getCrowdfundingAtmosFloorVO() {
                    return this.crowdfundingAtmosFloorVO;
                }

                public final CrowdfundingProgressFloor getCrowdfundingProgressFloorVO() {
                    return this.crowdfundingProgressFloorVO;
                }

                public final CrowdfundingStairsFloor getCrowdfundingStairsFloorVO() {
                    return this.crowdfundingStairsFloorVO;
                }

                public final DeliveryInfoFloor getDeliveryInfoFloorVO() {
                    return this.deliveryInfoFloorVO;
                }

                public final String getDepositPrice() {
                    return this.depositPrice;
                }

                public final DetailDescFloor getDetailDescFloorVO() {
                    return this.detailDescFloorVO;
                }

                public final FileInfoFloor getFileInfoFloorVO() {
                    return this.fileInfoFloorVO;
                }

                public final FixedTabSkinVO getFixedTabSkin() {
                    return this.fixedTabSkin;
                }

                public final List<String> getFloorKeys() {
                    return this.floorKeys;
                }

                public final FooterFloor getFooterFloorVO() {
                    return this.footerFloorVO;
                }

                public final Boolean getFromTm() {
                    return this.fromTm;
                }

                public final GlobalSkinConfigDTO getGlobalSkin() {
                    return this.globalSkin;
                }

                public final HeaderFloor getHeaderFloorVO() {
                    return this.headerFloorVO;
                }

                public final IpBrandFloor getIpBrandFloorVO() {
                    return this.ipBrandFloorVO;
                }

                public final Long getItemsId() {
                    return this.itemsId;
                }

                public final Integer getItemsStatus() {
                    return this.itemsStatus;
                }

                public final MallRecExpBO getMallRecExpBO() {
                    return this.mallRecExpBO;
                }

                public final String getMaxActivityDepositPrice() {
                    return this.maxActivityDepositPrice;
                }

                public final String getMaxActivityOriginalDepositPrice() {
                    return this.maxActivityOriginalDepositPrice;
                }

                public final String getMaxActivityOriginalPrice() {
                    return this.maxActivityOriginalPrice;
                }

                public final String getMaxActivityPrice() {
                    return this.maxActivityPrice;
                }

                public final MergeAtmospherePriceFloor getMergeAtmospherePriceFloorVO() {
                    return this.mergeAtmospherePriceFloorVO;
                }

                public final Boolean getMultiSku() {
                    return this.multiSku;
                }

                public final MerchantInfo getMerchantInfo() {
                    return this.merchantInfo;
                }

                public final Boolean getPreSale() {
                    return this.preSale;
                }

                public final String getPresaleDeliveryTimeStr() {
                    return this.presaleDeliveryTimeStr;
                }

                public final PriceFloor getPriceFloorVO() {
                    return this.priceFloorVO;
                }

                public final RecFloor getRecFloorVO() {
                    return this.recFloorVO;
                }

                public final Integer getRestriction() {
                    return this.restriction;
                }

                public final Integer getRestrictionPerOrder() {
                    return this.restrictionPerOrder;
                }

                public final Integer getSaleStatus() {
                    return this.saleStatus;
                }

                public final SeriesFloor getSeriesFloorVO() {
                    return this.seriesFloorVO;
                }

                public final ServiceDescFloor getServiceDescFloorVO() {
                    return this.serviceDescFloorVO;
                }

                public final ServiceFloor getServiceFloorVO() {
                    return this.serviceFloorVO;
                }

                public final ShopInfoFloor getShopInfoFloorVO() {
                    return this.shopInfoFloorVO;
                }

                public final SkuInfoFloor getSkuInfoFloorVO() {
                    return this.skuInfoFloorVO;
                }

                public final Integer getStatus() {
                    return this.status;
                }

                public final UpMeasureFloor getUpMeasureFloorVO() {
                    return this.upMeasureFloorVO;
                }

                public final VideoSkinConfigDTO getVideoSkin() {
                    return this.videoSkin;
                }

                public final List<ActionIconModel> getUserInteractInfos() {
                    return this.userInteractInfos;
                }
            }

            public final ProductDetailsData getData() {
                return this.data;
            }

            public final boolean isValid$product_details_page_debug() {
                Integer num = this.code;
                return (num == null || num.intValue() != 0 || this.data == null) ? false : true;
            }
        }