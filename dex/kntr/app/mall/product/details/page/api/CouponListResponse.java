package kntr.app.mall.product.details.page.api;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kntr.app.mall.product.details.page.api.CouponListResponse;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.KotlinVersion;
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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CouponListApiService.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0003-./B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fBE\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\r\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J9\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\u0013\u0010!\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u00060"}, d2 = {"Lkntr/app/mall/product/details/page/api/CouponListResponse;", "", "code", "", "message", "", "errtag", "", "data", "", "Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem;", "<init>", "(JLjava/lang/String;ILjava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()J", "getMessage", "()Ljava/lang/String;", "getErrtag", "()I", "getData", "()Ljava/util/List;", "isValid", "", "isValid$product_details_page_debug", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "CouponListItem", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class CouponListResponse {
    private final long code;
    private final List<CouponListItem> data;
    private final int errtag;
    private final String message;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.CouponListResponse$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = CouponListResponse._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public CouponListResponse() {
        this(0L, (String) null, 0, (List) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CouponListResponse copy$default(CouponListResponse couponListResponse, long j, String str, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = couponListResponse.code;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            str = couponListResponse.message;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            i = couponListResponse.errtag;
        }
        int i3 = i;
        List<CouponListItem> list2 = list;
        if ((i2 & 8) != 0) {
            list2 = couponListResponse.data;
        }
        return couponListResponse.copy(j2, str2, i3, list2);
    }

    public final long component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final int component3() {
        return this.errtag;
    }

    public final List<CouponListItem> component4() {
        return this.data;
    }

    public final CouponListResponse copy(long j, String str, int i, List<CouponListItem> list) {
        Intrinsics.checkNotNullParameter(str, "message");
        return new CouponListResponse(j, str, i, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CouponListResponse) {
            CouponListResponse couponListResponse = (CouponListResponse) obj;
            return this.code == couponListResponse.code && Intrinsics.areEqual(this.message, couponListResponse.message) && this.errtag == couponListResponse.errtag && Intrinsics.areEqual(this.data, couponListResponse.data);
        }
        return false;
    }

    public int hashCode() {
        return (((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.code) * 31) + this.message.hashCode()) * 31) + this.errtag) * 31) + (this.data == null ? 0 : this.data.hashCode());
    }

    public String toString() {
        long j = this.code;
        String str = this.message;
        int i = this.errtag;
        return "CouponListResponse(code=" + j + ", message=" + str + ", errtag=" + i + ", data=" + this.data + ")";
    }

    /* compiled from: CouponListApiService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CouponListResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CouponListResponse;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CouponListResponse> serializer() {
            return new GeneratedSerializer<CouponListResponse>() { // from class: kntr.app.mall.product.details.page.api.CouponListResponse$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.CouponListResponse", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.CouponListResponse> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.CouponListResponse> A[REMOVE]) =  kntr.app.mall.product.details.page.api.CouponListResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.CouponListResponse$$serializer)
                         in method: kntr.app.mall.product.details.page.api.CouponListResponse.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.CouponListResponse>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                          ("kntr.app.mall.product.details.page.api.CouponListResponse")
                          (wrap: kntr.app.mall.product.details.page.api.CouponListResponse$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.CouponListResponse$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.CouponListResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.CouponListResponse$$serializer)
                          (4 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.CouponListResponse$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.CouponListResponse$$serializer
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
                        kntr.app.mall.product.details.page.api.CouponListResponse$$serializer r0 = kntr.app.mall.product.details.page.api.CouponListResponse$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.CouponListResponse.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ CouponListResponse(int seen0, long code, String message, int errtag, List data, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.code = 0L;
                } else {
                    this.code = code;
                }
                if ((seen0 & 2) == 0) {
                    this.message = "";
                } else {
                    this.message = message;
                }
                if ((seen0 & 4) == 0) {
                    this.errtag = 0;
                } else {
                    this.errtag = errtag;
                }
                if ((seen0 & 8) == 0) {
                    this.data = null;
                } else {
                    this.data = data;
                }
            }

            public CouponListResponse(long code, String message, int errtag, List<CouponListItem> list) {
                Intrinsics.checkNotNullParameter(message, "message");
                this.code = code;
                this.message = message;
                this.errtag = errtag;
                this.data = list;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(CouponListResponse$CouponListItem$$serializer.INSTANCE);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(CouponListResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.code != 0) {
                    output.encodeLongElement(serialDesc, 0, self.code);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.message, "")) {
                    output.encodeStringElement(serialDesc, 1, self.message);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.errtag != 0) {
                    output.encodeIntElement(serialDesc, 2, self.errtag);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.data != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.data);
                }
            }

            public /* synthetic */ CouponListResponse(long j, String str, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? null : list);
            }

            public final long getCode() {
                return this.code;
            }

            public final String getMessage() {
                return this.message;
            }

            public final int getErrtag() {
                return this.errtag;
            }

            public final List<CouponListItem> getData() {
                return this.data;
            }

            /* compiled from: CouponListApiService.kt */
            @Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0003\b\u0084\u0001\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 Õ\u00012\u00020\u0001:\u0006Ó\u0001Ô\u0001Õ\u0001B³\u0005\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\b\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\bB\u0010CBß\u0004\b\u0010\u0012\u0006\u0010D\u001a\u00020\u0006\u0012\u0006\u0010E\u001a\u00020\u0006\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010 \u001a\u0004\u0018\u00010\t\u0012\b\u0010!\u001a\u0004\u0018\u00010\t\u0012\b\u0010\"\u001a\u0004\u0018\u00010\t\u0012\b\u0010#\u001a\u0004\u0018\u00010\t\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010%\u001a\u0004\u0018\u00010&\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\b\u0012\b\u0010*\u001a\u0004\u0018\u00010\t\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010,\u001a\u0004\u0018\u00010&\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010.\u001a\u0004\u0018\u00010\t\u0012\b\u0010/\u001a\u0004\u0018\u00010\t\u0012\b\u00100\u001a\u0004\u0018\u00010\t\u0012\b\u00101\u001a\u0004\u0018\u00010\u0006\u0012\b\u00102\u001a\u0004\u0018\u00010\u0006\u0012\b\u00103\u001a\u0004\u0018\u00010\u0003\u0012\b\u00104\u001a\u0004\u0018\u00010)\u0012\b\u00105\u001a\u0004\u0018\u00010\u0006\u0012\b\u00106\u001a\u0004\u0018\u00010\t\u0012\b\u00107\u001a\u0004\u0018\u00010\t\u0012\b\u00108\u001a\u0004\u0018\u00010\t\u0012\b\u00109\u001a\u0004\u0018\u00010\t\u0012\b\u0010:\u001a\u0004\u0018\u00010\t\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010<\u001a\u0004\u0018\u00010\t\u0012\b\u0010=\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010>\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010?\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010@\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010A\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010F\u001a\u0004\u0018\u00010G¢\u0006\u0004\bB\u0010HJ\u0011\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010JJ\u0011\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010JJ\u0011\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010NJ\u0012\u0010\u0090\u0001\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010JJ\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010NJ\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010NJ\u0011\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010NJ\u0011\u0010 \u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010dJ\f\u0010¡\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010¢\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010NJ\f\u0010£\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010¤\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010dJ\f\u0010¥\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010¦\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010§\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010¨\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010©\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010NJ\u0011\u0010ª\u0001\u001a\u0004\u0018\u00010&HÆ\u0003¢\u0006\u0002\u0010pJ\u0011\u0010«\u0001\u001a\u0004\u0018\u00010&HÆ\u0003¢\u0006\u0002\u0010pJ\u0012\u0010¬\u0001\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\bHÆ\u0003J\f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010®\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010NJ\u0011\u0010¯\u0001\u001a\u0004\u0018\u00010&HÆ\u0003¢\u0006\u0002\u0010pJ\u0011\u0010°\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010JJ\f\u0010±\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010²\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010³\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010´\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010NJ\u0011\u0010µ\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010NJ\u0011\u0010¶\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010JJ\u0011\u0010·\u0001\u001a\u0004\u0018\u00010)HÆ\u0003¢\u0006\u0002\u0010~J\u0011\u0010¸\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010NJ\f\u0010¹\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010º\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010»\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010¼\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010½\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010¾\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010JJ\f\u0010¿\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010À\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010NJ\u0011\u0010Á\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010NJ\u0011\u0010Â\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010NJ\u0011\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010NJ\u0011\u0010Ä\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010NJ¼\u0005\u0010Å\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\b2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010,\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00104\u001a\u0004\u0018\u00010)2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00106\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0003\u0010Æ\u0001J\u0015\u0010Ç\u0001\u001a\u00020&2\t\u0010È\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010É\u0001\u001a\u00020\u0006HÖ\u0001J\n\u0010Ê\u0001\u001a\u00020\tHÖ\u0001J-\u0010Ë\u0001\u001a\u00030Ì\u00012\u0007\u0010Í\u0001\u001a\u00020\u00002\b\u0010Î\u0001\u001a\u00030Ï\u00012\b\u0010Ð\u0001\u001a\u00030Ñ\u0001H\u0001¢\u0006\u0003\bÒ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010K\u001a\u0004\bI\u0010JR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010K\u001a\u0004\bL\u0010JR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010O\u001a\u0004\bM\u0010NR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010K\u001a\u0004\bT\u0010JR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bU\u0010SR\u0013\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bV\u0010SR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bY\u0010SR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010SR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b[\u0010SR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010SR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b]\u0010SR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010O\u001a\u0004\b^\u0010NR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b_\u0010SR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b`\u0010SR\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010O\u001a\u0004\ba\u0010NR\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010O\u001a\u0004\bb\u0010NR\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010e\u001a\u0004\bc\u0010dR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bf\u0010SR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010O\u001a\u0004\bg\u0010NR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bh\u0010SR\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010e\u001a\u0004\bi\u0010dR\u0013\u0010 \u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bj\u0010SR\u0013\u0010!\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bk\u0010SR\u0013\u0010\"\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bl\u0010SR\u0013\u0010#\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bm\u0010SR\u0015\u0010$\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010O\u001a\u0004\bn\u0010NR\u0015\u0010%\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0002\u0010q\u001a\u0004\bo\u0010pR\u0015\u0010'\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0002\u0010q\u001a\u0004\b'\u0010pR\u0019\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\br\u0010QR\u0013\u0010*\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bs\u0010SR\u0015\u0010+\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010O\u001a\u0004\bt\u0010NR\u0015\u0010,\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0002\u0010q\u001a\u0004\bu\u0010pR\u0015\u0010-\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010K\u001a\u0004\bv\u0010JR\u0013\u0010.\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bw\u0010SR\u0013\u0010/\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bx\u0010SR\u0013\u00100\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\by\u0010SR\u0015\u00101\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010O\u001a\u0004\bz\u0010NR\u0015\u00102\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010O\u001a\u0004\b{\u0010NR\u0015\u00103\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010K\u001a\u0004\b|\u0010JR\u0015\u00104\u001a\u0004\u0018\u00010)¢\u0006\n\n\u0002\u0010\u007f\u001a\u0004\b}\u0010~R\u0016\u00105\u001a\u0004\u0018\u00010\u0006¢\u0006\u000b\n\u0002\u0010O\u001a\u0005\b\u0080\u0001\u0010NR\u0014\u00106\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010SR\u0014\u00107\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010SR\u0014\u00108\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010SR\u0014\u00109\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010SR\u0014\u0010:\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u0085\u0001\u0010SR\u0016\u0010;\u001a\u0004\u0018\u00010\u0003¢\u0006\u000b\n\u0002\u0010K\u001a\u0005\b\u0086\u0001\u0010JR\u0014\u0010<\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010SR\u0016\u0010=\u001a\u0004\u0018\u00010\u0006¢\u0006\u000b\n\u0002\u0010O\u001a\u0005\b\u0088\u0001\u0010NR\u0016\u0010>\u001a\u0004\u0018\u00010\u0006¢\u0006\u000b\n\u0002\u0010O\u001a\u0005\b\u0089\u0001\u0010NR\u0016\u0010?\u001a\u0004\u0018\u00010\u0006¢\u0006\u000b\n\u0002\u0010O\u001a\u0005\b\u008a\u0001\u0010NR\u0016\u0010@\u001a\u0004\u0018\u00010\u0006¢\u0006\u000b\n\u0002\u0010O\u001a\u0005\b\u008b\u0001\u0010NR\u0016\u0010A\u001a\u0004\u0018\u00010\u0006¢\u0006\u000b\n\u0002\u0010O\u001a\u0005\b\u008c\u0001\u0010N¨\u0006Ö\u0001"}, d2 = {"Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem;", "", "afterHandleType", "", "benefitType", "channel", "", "couponCodeIdList", "", "", "couponCodeName", "couponCodeType", "couponDesc", "couponDiscount", "couponExt", "Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem$CouponExtModel;", "couponId", "couponName", "couponStatus", "couponStatusMsg", "couponTag", "couponType", "couponTypeDesc", "couponTypeName", "discount", "discountCondition", "discountConditionY", "", "discountLayerName", "discountLimit", "discountLimitDesc", "discountY", "exclusiveName", "followId", "followUpName", "followName", "followStatus", "hasReceived", "", "isReceived", "itemsList", "", "landingPageUrl", "maxNumPerUser", "needDeviceCheck", "newUserLimit", "owners", "ownersName", "preCouponDiscount", "receiveEndTime", "receiveStartTime", "scopeType", "serverTime", "shopId", "shopLabel", "showName", "sourceActivityId", "sourceAuthorityId", "sourceId", "status", "sufCouponDiscount", "useEffectDays", "useEffectUnit", "useEndTime", "useStartTime", "userCouponReceiveStatus", "<init>", "(Ljava/lang/Byte;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem$CouponExtModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen0", "seen1", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/Byte;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem$CouponExtModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAfterHandleType", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getBenefitType", "getChannel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCouponCodeIdList", "()Ljava/util/List;", "getCouponCodeName", "()Ljava/lang/String;", "getCouponCodeType", "getCouponDesc", "getCouponDiscount", "getCouponExt", "()Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem$CouponExtModel;", "getCouponId", "getCouponName", "getCouponStatus", "getCouponStatusMsg", "getCouponTag", "getCouponType", "getCouponTypeDesc", "getCouponTypeName", "getDiscount", "getDiscountCondition", "getDiscountConditionY", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getDiscountLayerName", "getDiscountLimit", "getDiscountLimitDesc", "getDiscountY", "getExclusiveName", "getFollowId", "getFollowUpName", "getFollowName", "getFollowStatus", "getHasReceived", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getItemsList", "getLandingPageUrl", "getMaxNumPerUser", "getNeedDeviceCheck", "getNewUserLimit", "getOwners", "getOwnersName", "getPreCouponDiscount", "getReceiveEndTime", "getReceiveStartTime", "getScopeType", "getServerTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getShopId", "getShopLabel", "getShowName", "getSourceActivityId", "getSourceAuthorityId", "getSourceId", "getStatus", "getSufCouponDiscount", "getUseEffectDays", "getUseEffectUnit", "getUseEndTime", "getUseStartTime", "getUserCouponReceiveStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "copy", "(Ljava/lang/Byte;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem$CouponExtModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "CouponExtModel", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class CouponListItem {
                private final Byte afterHandleType;
                private final Byte benefitType;
                private final Integer channel;
                private final List<String> couponCodeIdList;
                private final String couponCodeName;
                private final Byte couponCodeType;
                private final String couponDesc;
                private final String couponDiscount;
                private final CouponExtModel couponExt;
                private final String couponId;
                private final String couponName;
                private final String couponStatus;
                private final String couponStatusMsg;
                private final String couponTag;
                private final Integer couponType;
                private final String couponTypeDesc;
                private final String couponTypeName;
                private final Integer discount;
                private final Integer discountCondition;
                private final Double discountConditionY;
                private final String discountLayerName;
                private final Integer discountLimit;
                private final String discountLimitDesc;
                private final Double discountY;
                private final String exclusiveName;
                private final String followId;
                private final String followName;
                private final Integer followStatus;
                private final String followUpName;
                private final Boolean hasReceived;
                private final Boolean isReceived;
                private final List<Long> itemsList;
                private final String landingPageUrl;
                private final Integer maxNumPerUser;
                private final Boolean needDeviceCheck;
                private final Byte newUserLimit;
                private final String owners;
                private final String ownersName;
                private final String preCouponDiscount;
                private final Integer receiveEndTime;
                private final Integer receiveStartTime;
                private final Byte scopeType;
                private final Long serverTime;
                private final Integer shopId;
                private final String shopLabel;
                private final String showName;
                private final String sourceActivityId;
                private final String sourceAuthorityId;
                private final String sourceId;
                private final Byte status;
                private final String sufCouponDiscount;
                private final Integer useEffectDays;
                private final Integer useEffectUnit;
                private final Integer useEndTime;
                private final Integer useStartTime;
                private final Integer userCouponReceiveStatus;
                public static final Companion Companion = new Companion(null);
                public static final int $stable = 8;
                private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.CouponListResponse$CouponListItem$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        KSerializer _childSerializers$_anonymous_;
                        _childSerializers$_anonymous_ = CouponListResponse.CouponListItem._childSerializers$_anonymous_();
                        return _childSerializers$_anonymous_;
                    }
                }), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.CouponListResponse$CouponListItem$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        KSerializer _childSerializers$_anonymous_$0;
                        _childSerializers$_anonymous_$0 = CouponListResponse.CouponListItem._childSerializers$_anonymous_$0();
                        return _childSerializers$_anonymous_$0;
                    }
                }), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};

                public CouponListItem() {
                    this((Byte) null, (Byte) null, (Integer) null, (List) null, (String) null, (Byte) null, (String) null, (String) null, (CouponExtModel) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (Integer) null, (Integer) null, (Double) null, (String) null, (Integer) null, (String) null, (Double) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Boolean) null, (Boolean) null, (List) null, (String) null, (Integer) null, (Boolean) null, (Byte) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Byte) null, (Long) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Byte) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, -1, 16777215, (DefaultConstructorMarker) null);
                }

                public final Byte component1() {
                    return this.afterHandleType;
                }

                public final String component10() {
                    return this.couponId;
                }

                public final String component11() {
                    return this.couponName;
                }

                public final String component12() {
                    return this.couponStatus;
                }

                public final String component13() {
                    return this.couponStatusMsg;
                }

                public final String component14() {
                    return this.couponTag;
                }

                public final Integer component15() {
                    return this.couponType;
                }

                public final String component16() {
                    return this.couponTypeDesc;
                }

                public final String component17() {
                    return this.couponTypeName;
                }

                public final Integer component18() {
                    return this.discount;
                }

                public final Integer component19() {
                    return this.discountCondition;
                }

                public final Byte component2() {
                    return this.benefitType;
                }

                public final Double component20() {
                    return this.discountConditionY;
                }

                public final String component21() {
                    return this.discountLayerName;
                }

                public final Integer component22() {
                    return this.discountLimit;
                }

                public final String component23() {
                    return this.discountLimitDesc;
                }

                public final Double component24() {
                    return this.discountY;
                }

                public final String component25() {
                    return this.exclusiveName;
                }

                public final String component26() {
                    return this.followId;
                }

                public final String component27() {
                    return this.followUpName;
                }

                public final String component28() {
                    return this.followName;
                }

                public final Integer component29() {
                    return this.followStatus;
                }

                public final Integer component3() {
                    return this.channel;
                }

                public final Boolean component30() {
                    return this.hasReceived;
                }

                public final Boolean component31() {
                    return this.isReceived;
                }

                public final List<Long> component32() {
                    return this.itemsList;
                }

                public final String component33() {
                    return this.landingPageUrl;
                }

                public final Integer component34() {
                    return this.maxNumPerUser;
                }

                public final Boolean component35() {
                    return this.needDeviceCheck;
                }

                public final Byte component36() {
                    return this.newUserLimit;
                }

                public final String component37() {
                    return this.owners;
                }

                public final String component38() {
                    return this.ownersName;
                }

                public final String component39() {
                    return this.preCouponDiscount;
                }

                public final List<String> component4() {
                    return this.couponCodeIdList;
                }

                public final Integer component40() {
                    return this.receiveEndTime;
                }

                public final Integer component41() {
                    return this.receiveStartTime;
                }

                public final Byte component42() {
                    return this.scopeType;
                }

                public final Long component43() {
                    return this.serverTime;
                }

                public final Integer component44() {
                    return this.shopId;
                }

                public final String component45() {
                    return this.shopLabel;
                }

                public final String component46() {
                    return this.showName;
                }

                public final String component47() {
                    return this.sourceActivityId;
                }

                public final String component48() {
                    return this.sourceAuthorityId;
                }

                public final String component49() {
                    return this.sourceId;
                }

                public final String component5() {
                    return this.couponCodeName;
                }

                public final Byte component50() {
                    return this.status;
                }

                public final String component51() {
                    return this.sufCouponDiscount;
                }

                public final Integer component52() {
                    return this.useEffectDays;
                }

                public final Integer component53() {
                    return this.useEffectUnit;
                }

                public final Integer component54() {
                    return this.useEndTime;
                }

                public final Integer component55() {
                    return this.useStartTime;
                }

                public final Integer component56() {
                    return this.userCouponReceiveStatus;
                }

                public final Byte component6() {
                    return this.couponCodeType;
                }

                public final String component7() {
                    return this.couponDesc;
                }

                public final String component8() {
                    return this.couponDiscount;
                }

                public final CouponExtModel component9() {
                    return this.couponExt;
                }

                public final CouponListItem copy(Byte b, Byte b2, Integer num, List<String> list, String str, Byte b3, String str2, String str3, CouponExtModel couponExtModel, String str4, String str5, String str6, String str7, String str8, Integer num2, String str9, String str10, Integer num3, Integer num4, Double d, String str11, Integer num5, String str12, Double d2, String str13, String str14, String str15, String str16, Integer num6, Boolean bool, Boolean bool2, List<Long> list2, String str17, Integer num7, Boolean bool3, Byte b4, String str18, String str19, String str20, Integer num8, Integer num9, Byte b5, Long l, Integer num10, String str21, String str22, String str23, String str24, String str25, Byte b6, String str26, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15) {
                    return new CouponListItem(b, b2, num, list, str, b3, str2, str3, couponExtModel, str4, str5, str6, str7, str8, num2, str9, str10, num3, num4, d, str11, num5, str12, d2, str13, str14, str15, str16, num6, bool, bool2, list2, str17, num7, bool3, b4, str18, str19, str20, num8, num9, b5, l, num10, str21, str22, str23, str24, str25, b6, str26, num11, num12, num13, num14, num15);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof CouponListItem) {
                        CouponListItem couponListItem = (CouponListItem) obj;
                        return Intrinsics.areEqual(this.afterHandleType, couponListItem.afterHandleType) && Intrinsics.areEqual(this.benefitType, couponListItem.benefitType) && Intrinsics.areEqual(this.channel, couponListItem.channel) && Intrinsics.areEqual(this.couponCodeIdList, couponListItem.couponCodeIdList) && Intrinsics.areEqual(this.couponCodeName, couponListItem.couponCodeName) && Intrinsics.areEqual(this.couponCodeType, couponListItem.couponCodeType) && Intrinsics.areEqual(this.couponDesc, couponListItem.couponDesc) && Intrinsics.areEqual(this.couponDiscount, couponListItem.couponDiscount) && Intrinsics.areEqual(this.couponExt, couponListItem.couponExt) && Intrinsics.areEqual(this.couponId, couponListItem.couponId) && Intrinsics.areEqual(this.couponName, couponListItem.couponName) && Intrinsics.areEqual(this.couponStatus, couponListItem.couponStatus) && Intrinsics.areEqual(this.couponStatusMsg, couponListItem.couponStatusMsg) && Intrinsics.areEqual(this.couponTag, couponListItem.couponTag) && Intrinsics.areEqual(this.couponType, couponListItem.couponType) && Intrinsics.areEqual(this.couponTypeDesc, couponListItem.couponTypeDesc) && Intrinsics.areEqual(this.couponTypeName, couponListItem.couponTypeName) && Intrinsics.areEqual(this.discount, couponListItem.discount) && Intrinsics.areEqual(this.discountCondition, couponListItem.discountCondition) && Intrinsics.areEqual(this.discountConditionY, couponListItem.discountConditionY) && Intrinsics.areEqual(this.discountLayerName, couponListItem.discountLayerName) && Intrinsics.areEqual(this.discountLimit, couponListItem.discountLimit) && Intrinsics.areEqual(this.discountLimitDesc, couponListItem.discountLimitDesc) && Intrinsics.areEqual(this.discountY, couponListItem.discountY) && Intrinsics.areEqual(this.exclusiveName, couponListItem.exclusiveName) && Intrinsics.areEqual(this.followId, couponListItem.followId) && Intrinsics.areEqual(this.followUpName, couponListItem.followUpName) && Intrinsics.areEqual(this.followName, couponListItem.followName) && Intrinsics.areEqual(this.followStatus, couponListItem.followStatus) && Intrinsics.areEqual(this.hasReceived, couponListItem.hasReceived) && Intrinsics.areEqual(this.isReceived, couponListItem.isReceived) && Intrinsics.areEqual(this.itemsList, couponListItem.itemsList) && Intrinsics.areEqual(this.landingPageUrl, couponListItem.landingPageUrl) && Intrinsics.areEqual(this.maxNumPerUser, couponListItem.maxNumPerUser) && Intrinsics.areEqual(this.needDeviceCheck, couponListItem.needDeviceCheck) && Intrinsics.areEqual(this.newUserLimit, couponListItem.newUserLimit) && Intrinsics.areEqual(this.owners, couponListItem.owners) && Intrinsics.areEqual(this.ownersName, couponListItem.ownersName) && Intrinsics.areEqual(this.preCouponDiscount, couponListItem.preCouponDiscount) && Intrinsics.areEqual(this.receiveEndTime, couponListItem.receiveEndTime) && Intrinsics.areEqual(this.receiveStartTime, couponListItem.receiveStartTime) && Intrinsics.areEqual(this.scopeType, couponListItem.scopeType) && Intrinsics.areEqual(this.serverTime, couponListItem.serverTime) && Intrinsics.areEqual(this.shopId, couponListItem.shopId) && Intrinsics.areEqual(this.shopLabel, couponListItem.shopLabel) && Intrinsics.areEqual(this.showName, couponListItem.showName) && Intrinsics.areEqual(this.sourceActivityId, couponListItem.sourceActivityId) && Intrinsics.areEqual(this.sourceAuthorityId, couponListItem.sourceAuthorityId) && Intrinsics.areEqual(this.sourceId, couponListItem.sourceId) && Intrinsics.areEqual(this.status, couponListItem.status) && Intrinsics.areEqual(this.sufCouponDiscount, couponListItem.sufCouponDiscount) && Intrinsics.areEqual(this.useEffectDays, couponListItem.useEffectDays) && Intrinsics.areEqual(this.useEffectUnit, couponListItem.useEffectUnit) && Intrinsics.areEqual(this.useEndTime, couponListItem.useEndTime) && Intrinsics.areEqual(this.useStartTime, couponListItem.useStartTime) && Intrinsics.areEqual(this.userCouponReceiveStatus, couponListItem.userCouponReceiveStatus);
                    }
                    return false;
                }

                public int hashCode() {
                    return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.afterHandleType == null ? 0 : this.afterHandleType.hashCode()) * 31) + (this.benefitType == null ? 0 : this.benefitType.hashCode())) * 31) + (this.channel == null ? 0 : this.channel.hashCode())) * 31) + (this.couponCodeIdList == null ? 0 : this.couponCodeIdList.hashCode())) * 31) + (this.couponCodeName == null ? 0 : this.couponCodeName.hashCode())) * 31) + (this.couponCodeType == null ? 0 : this.couponCodeType.hashCode())) * 31) + (this.couponDesc == null ? 0 : this.couponDesc.hashCode())) * 31) + (this.couponDiscount == null ? 0 : this.couponDiscount.hashCode())) * 31) + (this.couponExt == null ? 0 : this.couponExt.hashCode())) * 31) + (this.couponId == null ? 0 : this.couponId.hashCode())) * 31) + (this.couponName == null ? 0 : this.couponName.hashCode())) * 31) + (this.couponStatus == null ? 0 : this.couponStatus.hashCode())) * 31) + (this.couponStatusMsg == null ? 0 : this.couponStatusMsg.hashCode())) * 31) + (this.couponTag == null ? 0 : this.couponTag.hashCode())) * 31) + (this.couponType == null ? 0 : this.couponType.hashCode())) * 31) + (this.couponTypeDesc == null ? 0 : this.couponTypeDesc.hashCode())) * 31) + (this.couponTypeName == null ? 0 : this.couponTypeName.hashCode())) * 31) + (this.discount == null ? 0 : this.discount.hashCode())) * 31) + (this.discountCondition == null ? 0 : this.discountCondition.hashCode())) * 31) + (this.discountConditionY == null ? 0 : this.discountConditionY.hashCode())) * 31) + (this.discountLayerName == null ? 0 : this.discountLayerName.hashCode())) * 31) + (this.discountLimit == null ? 0 : this.discountLimit.hashCode())) * 31) + (this.discountLimitDesc == null ? 0 : this.discountLimitDesc.hashCode())) * 31) + (this.discountY == null ? 0 : this.discountY.hashCode())) * 31) + (this.exclusiveName == null ? 0 : this.exclusiveName.hashCode())) * 31) + (this.followId == null ? 0 : this.followId.hashCode())) * 31) + (this.followUpName == null ? 0 : this.followUpName.hashCode())) * 31) + (this.followName == null ? 0 : this.followName.hashCode())) * 31) + (this.followStatus == null ? 0 : this.followStatus.hashCode())) * 31) + (this.hasReceived == null ? 0 : this.hasReceived.hashCode())) * 31) + (this.isReceived == null ? 0 : this.isReceived.hashCode())) * 31) + (this.itemsList == null ? 0 : this.itemsList.hashCode())) * 31) + (this.landingPageUrl == null ? 0 : this.landingPageUrl.hashCode())) * 31) + (this.maxNumPerUser == null ? 0 : this.maxNumPerUser.hashCode())) * 31) + (this.needDeviceCheck == null ? 0 : this.needDeviceCheck.hashCode())) * 31) + (this.newUserLimit == null ? 0 : this.newUserLimit.hashCode())) * 31) + (this.owners == null ? 0 : this.owners.hashCode())) * 31) + (this.ownersName == null ? 0 : this.ownersName.hashCode())) * 31) + (this.preCouponDiscount == null ? 0 : this.preCouponDiscount.hashCode())) * 31) + (this.receiveEndTime == null ? 0 : this.receiveEndTime.hashCode())) * 31) + (this.receiveStartTime == null ? 0 : this.receiveStartTime.hashCode())) * 31) + (this.scopeType == null ? 0 : this.scopeType.hashCode())) * 31) + (this.serverTime == null ? 0 : this.serverTime.hashCode())) * 31) + (this.shopId == null ? 0 : this.shopId.hashCode())) * 31) + (this.shopLabel == null ? 0 : this.shopLabel.hashCode())) * 31) + (this.showName == null ? 0 : this.showName.hashCode())) * 31) + (this.sourceActivityId == null ? 0 : this.sourceActivityId.hashCode())) * 31) + (this.sourceAuthorityId == null ? 0 : this.sourceAuthorityId.hashCode())) * 31) + (this.sourceId == null ? 0 : this.sourceId.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.sufCouponDiscount == null ? 0 : this.sufCouponDiscount.hashCode())) * 31) + (this.useEffectDays == null ? 0 : this.useEffectDays.hashCode())) * 31) + (this.useEffectUnit == null ? 0 : this.useEffectUnit.hashCode())) * 31) + (this.useEndTime == null ? 0 : this.useEndTime.hashCode())) * 31) + (this.useStartTime == null ? 0 : this.useStartTime.hashCode())) * 31) + (this.userCouponReceiveStatus != null ? this.userCouponReceiveStatus.hashCode() : 0);
                }

                public String toString() {
                    Byte b = this.afterHandleType;
                    Byte b2 = this.benefitType;
                    Integer num = this.channel;
                    List<String> list = this.couponCodeIdList;
                    String str = this.couponCodeName;
                    Byte b3 = this.couponCodeType;
                    String str2 = this.couponDesc;
                    String str3 = this.couponDiscount;
                    CouponExtModel couponExtModel = this.couponExt;
                    String str4 = this.couponId;
                    String str5 = this.couponName;
                    String str6 = this.couponStatus;
                    String str7 = this.couponStatusMsg;
                    String str8 = this.couponTag;
                    Integer num2 = this.couponType;
                    String str9 = this.couponTypeDesc;
                    String str10 = this.couponTypeName;
                    Integer num3 = this.discount;
                    Integer num4 = this.discountCondition;
                    Double d = this.discountConditionY;
                    String str11 = this.discountLayerName;
                    Integer num5 = this.discountLimit;
                    String str12 = this.discountLimitDesc;
                    Double d2 = this.discountY;
                    String str13 = this.exclusiveName;
                    String str14 = this.followId;
                    String str15 = this.followUpName;
                    String str16 = this.followName;
                    Integer num6 = this.followStatus;
                    Boolean bool = this.hasReceived;
                    Boolean bool2 = this.isReceived;
                    List<Long> list2 = this.itemsList;
                    String str17 = this.landingPageUrl;
                    Integer num7 = this.maxNumPerUser;
                    Boolean bool3 = this.needDeviceCheck;
                    Byte b4 = this.newUserLimit;
                    String str18 = this.owners;
                    String str19 = this.ownersName;
                    String str20 = this.preCouponDiscount;
                    Integer num8 = this.receiveEndTime;
                    Integer num9 = this.receiveStartTime;
                    Byte b5 = this.scopeType;
                    Long l = this.serverTime;
                    Integer num10 = this.shopId;
                    String str21 = this.shopLabel;
                    String str22 = this.showName;
                    String str23 = this.sourceActivityId;
                    String str24 = this.sourceAuthorityId;
                    String str25 = this.sourceId;
                    Byte b6 = this.status;
                    String str26 = this.sufCouponDiscount;
                    Integer num11 = this.useEffectDays;
                    Integer num12 = this.useEffectUnit;
                    Integer num13 = this.useEndTime;
                    Integer num14 = this.useStartTime;
                    return "CouponListItem(afterHandleType=" + b + ", benefitType=" + b2 + ", channel=" + num + ", couponCodeIdList=" + list + ", couponCodeName=" + str + ", couponCodeType=" + b3 + ", couponDesc=" + str2 + ", couponDiscount=" + str3 + ", couponExt=" + couponExtModel + ", couponId=" + str4 + ", couponName=" + str5 + ", couponStatus=" + str6 + ", couponStatusMsg=" + str7 + ", couponTag=" + str8 + ", couponType=" + num2 + ", couponTypeDesc=" + str9 + ", couponTypeName=" + str10 + ", discount=" + num3 + ", discountCondition=" + num4 + ", discountConditionY=" + d + ", discountLayerName=" + str11 + ", discountLimit=" + num5 + ", discountLimitDesc=" + str12 + ", discountY=" + d2 + ", exclusiveName=" + str13 + ", followId=" + str14 + ", followUpName=" + str15 + ", followName=" + str16 + ", followStatus=" + num6 + ", hasReceived=" + bool + ", isReceived=" + bool2 + ", itemsList=" + list2 + ", landingPageUrl=" + str17 + ", maxNumPerUser=" + num7 + ", needDeviceCheck=" + bool3 + ", newUserLimit=" + b4 + ", owners=" + str18 + ", ownersName=" + str19 + ", preCouponDiscount=" + str20 + ", receiveEndTime=" + num8 + ", receiveStartTime=" + num9 + ", scopeType=" + b5 + ", serverTime=" + l + ", shopId=" + num10 + ", shopLabel=" + str21 + ", showName=" + str22 + ", sourceActivityId=" + str23 + ", sourceAuthorityId=" + str24 + ", sourceId=" + str25 + ", status=" + b6 + ", sufCouponDiscount=" + str26 + ", useEffectDays=" + num11 + ", useEffectUnit=" + num12 + ", useEndTime=" + num13 + ", useStartTime=" + num14 + ", userCouponReceiveStatus=" + this.userCouponReceiveStatus + ")";
                }

                /* compiled from: CouponListApiService.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<CouponListItem> serializer() {
                        return CouponListResponse$CouponListItem$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ CouponListItem(int seen0, int seen1, Byte afterHandleType, Byte benefitType, Integer channel, List couponCodeIdList, String couponCodeName, Byte couponCodeType, String couponDesc, String couponDiscount, CouponExtModel couponExt, String couponId, String couponName, String couponStatus, String couponStatusMsg, String couponTag, Integer couponType, String couponTypeDesc, String couponTypeName, Integer discount, Integer discountCondition, Double discountConditionY, String discountLayerName, Integer discountLimit, String discountLimitDesc, Double discountY, String exclusiveName, String followId, String followUpName, String followName, Integer followStatus, Boolean hasReceived, Boolean isReceived, List itemsList, String landingPageUrl, Integer maxNumPerUser, Boolean needDeviceCheck, Byte newUserLimit, String owners, String ownersName, String preCouponDiscount, Integer receiveEndTime, Integer receiveStartTime, Byte scopeType, Long serverTime, Integer shopId, String shopLabel, String showName, String sourceActivityId, String sourceAuthorityId, String sourceId, Byte status, String sufCouponDiscount, Integer useEffectDays, Integer useEffectUnit, Integer useEndTime, Integer useStartTime, Integer userCouponReceiveStatus, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.afterHandleType = null;
                    } else {
                        this.afterHandleType = afterHandleType;
                    }
                    if ((seen0 & 2) == 0) {
                        this.benefitType = null;
                    } else {
                        this.benefitType = benefitType;
                    }
                    if ((seen0 & 4) == 0) {
                        this.channel = null;
                    } else {
                        this.channel = channel;
                    }
                    if ((seen0 & 8) == 0) {
                        this.couponCodeIdList = null;
                    } else {
                        this.couponCodeIdList = couponCodeIdList;
                    }
                    if ((seen0 & 16) == 0) {
                        this.couponCodeName = null;
                    } else {
                        this.couponCodeName = couponCodeName;
                    }
                    if ((seen0 & 32) == 0) {
                        this.couponCodeType = null;
                    } else {
                        this.couponCodeType = couponCodeType;
                    }
                    if ((seen0 & 64) == 0) {
                        this.couponDesc = null;
                    } else {
                        this.couponDesc = couponDesc;
                    }
                    if ((seen0 & 128) == 0) {
                        this.couponDiscount = null;
                    } else {
                        this.couponDiscount = couponDiscount;
                    }
                    if ((seen0 & 256) == 0) {
                        this.couponExt = null;
                    } else {
                        this.couponExt = couponExt;
                    }
                    if ((seen0 & 512) == 0) {
                        this.couponId = null;
                    } else {
                        this.couponId = couponId;
                    }
                    if ((seen0 & 1024) == 0) {
                        this.couponName = null;
                    } else {
                        this.couponName = couponName;
                    }
                    if ((seen0 & 2048) == 0) {
                        this.couponStatus = null;
                    } else {
                        this.couponStatus = couponStatus;
                    }
                    if ((seen0 & 4096) == 0) {
                        this.couponStatusMsg = null;
                    } else {
                        this.couponStatusMsg = couponStatusMsg;
                    }
                    if ((seen0 & 8192) == 0) {
                        this.couponTag = null;
                    } else {
                        this.couponTag = couponTag;
                    }
                    if ((seen0 & 16384) == 0) {
                        this.couponType = null;
                    } else {
                        this.couponType = couponType;
                    }
                    if ((seen0 & 32768) == 0) {
                        this.couponTypeDesc = null;
                    } else {
                        this.couponTypeDesc = couponTypeDesc;
                    }
                    if ((seen0 & 65536) == 0) {
                        this.couponTypeName = null;
                    } else {
                        this.couponTypeName = couponTypeName;
                    }
                    if ((seen0 & 131072) == 0) {
                        this.discount = null;
                    } else {
                        this.discount = discount;
                    }
                    if ((seen0 & 262144) == 0) {
                        this.discountCondition = null;
                    } else {
                        this.discountCondition = discountCondition;
                    }
                    if ((seen0 & 524288) == 0) {
                        this.discountConditionY = null;
                    } else {
                        this.discountConditionY = discountConditionY;
                    }
                    if ((seen0 & 1048576) == 0) {
                        this.discountLayerName = null;
                    } else {
                        this.discountLayerName = discountLayerName;
                    }
                    if ((seen0 & 2097152) == 0) {
                        this.discountLimit = null;
                    } else {
                        this.discountLimit = discountLimit;
                    }
                    if ((seen0 & 4194304) == 0) {
                        this.discountLimitDesc = null;
                    } else {
                        this.discountLimitDesc = discountLimitDesc;
                    }
                    if ((seen0 & 8388608) == 0) {
                        this.discountY = null;
                    } else {
                        this.discountY = discountY;
                    }
                    if ((seen0 & 16777216) == 0) {
                        this.exclusiveName = null;
                    } else {
                        this.exclusiveName = exclusiveName;
                    }
                    if ((seen0 & 33554432) == 0) {
                        this.followId = null;
                    } else {
                        this.followId = followId;
                    }
                    if ((seen0 & 67108864) == 0) {
                        this.followUpName = null;
                    } else {
                        this.followUpName = followUpName;
                    }
                    if ((seen0 & 134217728) == 0) {
                        this.followName = null;
                    } else {
                        this.followName = followName;
                    }
                    if ((seen0 & 268435456) == 0) {
                        this.followStatus = null;
                    } else {
                        this.followStatus = followStatus;
                    }
                    if ((seen0 & 536870912) == 0) {
                        this.hasReceived = null;
                    } else {
                        this.hasReceived = hasReceived;
                    }
                    if ((seen0 & 1073741824) == 0) {
                        this.isReceived = null;
                    } else {
                        this.isReceived = isReceived;
                    }
                    if ((seen0 & Integer.MIN_VALUE) == 0) {
                        this.itemsList = null;
                    } else {
                        this.itemsList = itemsList;
                    }
                    if ((seen1 & 1) == 0) {
                        this.landingPageUrl = null;
                    } else {
                        this.landingPageUrl = landingPageUrl;
                    }
                    if ((seen1 & 2) == 0) {
                        this.maxNumPerUser = null;
                    } else {
                        this.maxNumPerUser = maxNumPerUser;
                    }
                    if ((seen1 & 4) == 0) {
                        this.needDeviceCheck = null;
                    } else {
                        this.needDeviceCheck = needDeviceCheck;
                    }
                    if ((seen1 & 8) == 0) {
                        this.newUserLimit = null;
                    } else {
                        this.newUserLimit = newUserLimit;
                    }
                    if ((seen1 & 16) == 0) {
                        this.owners = null;
                    } else {
                        this.owners = owners;
                    }
                    if ((seen1 & 32) == 0) {
                        this.ownersName = null;
                    } else {
                        this.ownersName = ownersName;
                    }
                    if ((seen1 & 64) == 0) {
                        this.preCouponDiscount = null;
                    } else {
                        this.preCouponDiscount = preCouponDiscount;
                    }
                    if ((seen1 & 128) == 0) {
                        this.receiveEndTime = null;
                    } else {
                        this.receiveEndTime = receiveEndTime;
                    }
                    if ((seen1 & 256) == 0) {
                        this.receiveStartTime = null;
                    } else {
                        this.receiveStartTime = receiveStartTime;
                    }
                    if ((seen1 & 512) == 0) {
                        this.scopeType = null;
                    } else {
                        this.scopeType = scopeType;
                    }
                    if ((seen1 & 1024) == 0) {
                        this.serverTime = null;
                    } else {
                        this.serverTime = serverTime;
                    }
                    if ((seen1 & 2048) == 0) {
                        this.shopId = null;
                    } else {
                        this.shopId = shopId;
                    }
                    if ((seen1 & 4096) == 0) {
                        this.shopLabel = null;
                    } else {
                        this.shopLabel = shopLabel;
                    }
                    if ((seen1 & 8192) == 0) {
                        this.showName = null;
                    } else {
                        this.showName = showName;
                    }
                    if ((seen1 & 16384) == 0) {
                        this.sourceActivityId = null;
                    } else {
                        this.sourceActivityId = sourceActivityId;
                    }
                    if ((seen1 & 32768) == 0) {
                        this.sourceAuthorityId = null;
                    } else {
                        this.sourceAuthorityId = sourceAuthorityId;
                    }
                    if ((seen1 & 65536) == 0) {
                        this.sourceId = null;
                    } else {
                        this.sourceId = sourceId;
                    }
                    if ((seen1 & 131072) == 0) {
                        this.status = null;
                    } else {
                        this.status = status;
                    }
                    if ((seen1 & 262144) == 0) {
                        this.sufCouponDiscount = null;
                    } else {
                        this.sufCouponDiscount = sufCouponDiscount;
                    }
                    if ((seen1 & 524288) == 0) {
                        this.useEffectDays = null;
                    } else {
                        this.useEffectDays = useEffectDays;
                    }
                    if ((seen1 & 1048576) == 0) {
                        this.useEffectUnit = null;
                    } else {
                        this.useEffectUnit = useEffectUnit;
                    }
                    if ((seen1 & 2097152) == 0) {
                        this.useEndTime = null;
                    } else {
                        this.useEndTime = useEndTime;
                    }
                    if ((seen1 & 4194304) == 0) {
                        this.useStartTime = null;
                    } else {
                        this.useStartTime = useStartTime;
                    }
                    if ((seen1 & 8388608) == 0) {
                        this.userCouponReceiveStatus = null;
                    } else {
                        this.userCouponReceiveStatus = userCouponReceiveStatus;
                    }
                }

                public CouponListItem(Byte afterHandleType, Byte benefitType, Integer channel, List<String> list, String couponCodeName, Byte couponCodeType, String couponDesc, String couponDiscount, CouponExtModel couponExt, String couponId, String couponName, String couponStatus, String couponStatusMsg, String couponTag, Integer couponType, String couponTypeDesc, String couponTypeName, Integer discount, Integer discountCondition, Double discountConditionY, String discountLayerName, Integer discountLimit, String discountLimitDesc, Double discountY, String exclusiveName, String followId, String followUpName, String followName, Integer followStatus, Boolean hasReceived, Boolean isReceived, List<Long> list2, String landingPageUrl, Integer maxNumPerUser, Boolean needDeviceCheck, Byte newUserLimit, String owners, String ownersName, String preCouponDiscount, Integer receiveEndTime, Integer receiveStartTime, Byte scopeType, Long serverTime, Integer shopId, String shopLabel, String showName, String sourceActivityId, String sourceAuthorityId, String sourceId, Byte status, String sufCouponDiscount, Integer useEffectDays, Integer useEffectUnit, Integer useEndTime, Integer useStartTime, Integer userCouponReceiveStatus) {
                    this.afterHandleType = afterHandleType;
                    this.benefitType = benefitType;
                    this.channel = channel;
                    this.couponCodeIdList = list;
                    this.couponCodeName = couponCodeName;
                    this.couponCodeType = couponCodeType;
                    this.couponDesc = couponDesc;
                    this.couponDiscount = couponDiscount;
                    this.couponExt = couponExt;
                    this.couponId = couponId;
                    this.couponName = couponName;
                    this.couponStatus = couponStatus;
                    this.couponStatusMsg = couponStatusMsg;
                    this.couponTag = couponTag;
                    this.couponType = couponType;
                    this.couponTypeDesc = couponTypeDesc;
                    this.couponTypeName = couponTypeName;
                    this.discount = discount;
                    this.discountCondition = discountCondition;
                    this.discountConditionY = discountConditionY;
                    this.discountLayerName = discountLayerName;
                    this.discountLimit = discountLimit;
                    this.discountLimitDesc = discountLimitDesc;
                    this.discountY = discountY;
                    this.exclusiveName = exclusiveName;
                    this.followId = followId;
                    this.followUpName = followUpName;
                    this.followName = followName;
                    this.followStatus = followStatus;
                    this.hasReceived = hasReceived;
                    this.isReceived = isReceived;
                    this.itemsList = list2;
                    this.landingPageUrl = landingPageUrl;
                    this.maxNumPerUser = maxNumPerUser;
                    this.needDeviceCheck = needDeviceCheck;
                    this.newUserLimit = newUserLimit;
                    this.owners = owners;
                    this.ownersName = ownersName;
                    this.preCouponDiscount = preCouponDiscount;
                    this.receiveEndTime = receiveEndTime;
                    this.receiveStartTime = receiveStartTime;
                    this.scopeType = scopeType;
                    this.serverTime = serverTime;
                    this.shopId = shopId;
                    this.shopLabel = shopLabel;
                    this.showName = showName;
                    this.sourceActivityId = sourceActivityId;
                    this.sourceAuthorityId = sourceAuthorityId;
                    this.sourceId = sourceId;
                    this.status = status;
                    this.sufCouponDiscount = sufCouponDiscount;
                    this.useEffectDays = useEffectDays;
                    this.useEffectUnit = useEffectUnit;
                    this.useEndTime = useEndTime;
                    this.useStartTime = useStartTime;
                    this.userCouponReceiveStatus = userCouponReceiveStatus;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                    return new ArrayListSerializer(StringSerializer.INSTANCE);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                    return new ArrayListSerializer(LongSerializer.INSTANCE);
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(CouponListItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.afterHandleType != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, ByteSerializer.INSTANCE, self.afterHandleType);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.benefitType != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, ByteSerializer.INSTANCE, self.benefitType);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.channel != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.channel);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.couponCodeIdList != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.couponCodeIdList);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.couponCodeName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.couponCodeName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 5) || self.couponCodeType != null) {
                        output.encodeNullableSerializableElement(serialDesc, 5, ByteSerializer.INSTANCE, self.couponCodeType);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 6) || self.couponDesc != null) {
                        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.couponDesc);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 7) || self.couponDiscount != null) {
                        output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.couponDiscount);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 8) || self.couponExt != null) {
                        output.encodeNullableSerializableElement(serialDesc, 8, CouponListResponse$CouponListItem$CouponExtModel$$serializer.INSTANCE, self.couponExt);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 9) || self.couponId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.couponId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 10) || self.couponName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.couponName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 11) || self.couponStatus != null) {
                        output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.couponStatus);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 12) || self.couponStatusMsg != null) {
                        output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.couponStatusMsg);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 13) || self.couponTag != null) {
                        output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.couponTag);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 14) || self.couponType != null) {
                        output.encodeNullableSerializableElement(serialDesc, 14, IntSerializer.INSTANCE, self.couponType);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 15) || self.couponTypeDesc != null) {
                        output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.couponTypeDesc);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 16) || self.couponTypeName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.couponTypeName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 17) || self.discount != null) {
                        output.encodeNullableSerializableElement(serialDesc, 17, IntSerializer.INSTANCE, self.discount);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 18) || self.discountCondition != null) {
                        output.encodeNullableSerializableElement(serialDesc, 18, IntSerializer.INSTANCE, self.discountCondition);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 19) || self.discountConditionY != null) {
                        output.encodeNullableSerializableElement(serialDesc, 19, DoubleSerializer.INSTANCE, self.discountConditionY);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 20) || self.discountLayerName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 20, StringSerializer.INSTANCE, self.discountLayerName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 21) || self.discountLimit != null) {
                        output.encodeNullableSerializableElement(serialDesc, 21, IntSerializer.INSTANCE, self.discountLimit);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 22) || self.discountLimitDesc != null) {
                        output.encodeNullableSerializableElement(serialDesc, 22, StringSerializer.INSTANCE, self.discountLimitDesc);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 23) || self.discountY != null) {
                        output.encodeNullableSerializableElement(serialDesc, 23, DoubleSerializer.INSTANCE, self.discountY);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 24) || self.exclusiveName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 24, StringSerializer.INSTANCE, self.exclusiveName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 25) || self.followId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 25, StringSerializer.INSTANCE, self.followId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 26) || self.followUpName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 26, StringSerializer.INSTANCE, self.followUpName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 27) || self.followName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 27, StringSerializer.INSTANCE, self.followName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 28) || self.followStatus != null) {
                        output.encodeNullableSerializableElement(serialDesc, 28, IntSerializer.INSTANCE, self.followStatus);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 29) || self.hasReceived != null) {
                        output.encodeNullableSerializableElement(serialDesc, 29, BooleanSerializer.INSTANCE, self.hasReceived);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 30) || self.isReceived != null) {
                        output.encodeNullableSerializableElement(serialDesc, 30, BooleanSerializer.INSTANCE, self.isReceived);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 31) || self.itemsList != null) {
                        output.encodeNullableSerializableElement(serialDesc, 31, lazyArr[31].getValue(), self.itemsList);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 32) || self.landingPageUrl != null) {
                        output.encodeNullableSerializableElement(serialDesc, 32, StringSerializer.INSTANCE, self.landingPageUrl);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 33) || self.maxNumPerUser != null) {
                        output.encodeNullableSerializableElement(serialDesc, 33, IntSerializer.INSTANCE, self.maxNumPerUser);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 34) || self.needDeviceCheck != null) {
                        output.encodeNullableSerializableElement(serialDesc, 34, BooleanSerializer.INSTANCE, self.needDeviceCheck);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 35) || self.newUserLimit != null) {
                        output.encodeNullableSerializableElement(serialDesc, 35, ByteSerializer.INSTANCE, self.newUserLimit);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 36) || self.owners != null) {
                        output.encodeNullableSerializableElement(serialDesc, 36, StringSerializer.INSTANCE, self.owners);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 37) || self.ownersName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 37, StringSerializer.INSTANCE, self.ownersName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 38) || self.preCouponDiscount != null) {
                        output.encodeNullableSerializableElement(serialDesc, 38, StringSerializer.INSTANCE, self.preCouponDiscount);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 39) || self.receiveEndTime != null) {
                        output.encodeNullableSerializableElement(serialDesc, 39, IntSerializer.INSTANCE, self.receiveEndTime);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 40) || self.receiveStartTime != null) {
                        output.encodeNullableSerializableElement(serialDesc, 40, IntSerializer.INSTANCE, self.receiveStartTime);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 41) || self.scopeType != null) {
                        output.encodeNullableSerializableElement(serialDesc, 41, ByteSerializer.INSTANCE, self.scopeType);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 42) || self.serverTime != null) {
                        output.encodeNullableSerializableElement(serialDesc, 42, LongSerializer.INSTANCE, self.serverTime);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 43) || self.shopId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 43, IntSerializer.INSTANCE, self.shopId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 44) || self.shopLabel != null) {
                        output.encodeNullableSerializableElement(serialDesc, 44, StringSerializer.INSTANCE, self.shopLabel);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 45) || self.showName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 45, StringSerializer.INSTANCE, self.showName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 46) || self.sourceActivityId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 46, StringSerializer.INSTANCE, self.sourceActivityId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 47) || self.sourceAuthorityId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 47, StringSerializer.INSTANCE, self.sourceAuthorityId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sourceId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 48, StringSerializer.INSTANCE, self.sourceId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 49) || self.status != null) {
                        output.encodeNullableSerializableElement(serialDesc, 49, ByteSerializer.INSTANCE, self.status);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 50) || self.sufCouponDiscount != null) {
                        output.encodeNullableSerializableElement(serialDesc, 50, StringSerializer.INSTANCE, self.sufCouponDiscount);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 51) || self.useEffectDays != null) {
                        output.encodeNullableSerializableElement(serialDesc, 51, IntSerializer.INSTANCE, self.useEffectDays);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 52) || self.useEffectUnit != null) {
                        output.encodeNullableSerializableElement(serialDesc, 52, IntSerializer.INSTANCE, self.useEffectUnit);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 53) || self.useEndTime != null) {
                        output.encodeNullableSerializableElement(serialDesc, 53, IntSerializer.INSTANCE, self.useEndTime);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 54) || self.useStartTime != null) {
                        output.encodeNullableSerializableElement(serialDesc, 54, IntSerializer.INSTANCE, self.useStartTime);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 55) || self.userCouponReceiveStatus != null) {
                        output.encodeNullableSerializableElement(serialDesc, 55, IntSerializer.INSTANCE, self.userCouponReceiveStatus);
                    }
                }

                public /* synthetic */ CouponListItem(Byte b, Byte b2, Integer num, List list, String str, Byte b3, String str2, String str3, CouponExtModel couponExtModel, String str4, String str5, String str6, String str7, String str8, Integer num2, String str9, String str10, Integer num3, Integer num4, Double d, String str11, Integer num5, String str12, Double d2, String str13, String str14, String str15, String str16, Integer num6, Boolean bool, Boolean bool2, List list2, String str17, Integer num7, Boolean bool3, Byte b4, String str18, String str19, String str20, Integer num8, Integer num9, Byte b5, Long l, Integer num10, String str21, String str22, String str23, String str24, String str25, Byte b6, String str26, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : b, (i & 2) != 0 ? null : b2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : b3, (i & 64) != 0 ? null : str2, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : couponExtModel, (i & 512) != 0 ? null : str4, (i & 1024) != 0 ? null : str5, (i & 2048) != 0 ? null : str6, (i & 4096) != 0 ? null : str7, (i & 8192) != 0 ? null : str8, (i & 16384) != 0 ? null : num2, (i & 32768) != 0 ? null : str9, (i & 65536) != 0 ? null : str10, (i & 131072) != 0 ? null : num3, (i & 262144) != 0 ? null : num4, (i & 524288) != 0 ? null : d, (i & 1048576) != 0 ? null : str11, (i & 2097152) != 0 ? null : num5, (i & 4194304) != 0 ? null : str12, (i & 8388608) != 0 ? null : d2, (i & 16777216) != 0 ? null : str13, (i & 33554432) != 0 ? null : str14, (i & 67108864) != 0 ? null : str15, (i & 134217728) != 0 ? null : str16, (i & 268435456) != 0 ? null : num6, (i & 536870912) != 0 ? null : bool, (i & 1073741824) != 0 ? null : bool2, (i & Integer.MIN_VALUE) != 0 ? null : list2, (i2 & 1) != 0 ? null : str17, (i2 & 2) != 0 ? null : num7, (i2 & 4) != 0 ? null : bool3, (i2 & 8) != 0 ? null : b4, (i2 & 16) != 0 ? null : str18, (i2 & 32) != 0 ? null : str19, (i2 & 64) != 0 ? null : str20, (i2 & 128) != 0 ? null : num8, (i2 & 256) != 0 ? null : num9, (i2 & 512) != 0 ? null : b5, (i2 & 1024) != 0 ? null : l, (i2 & 2048) != 0 ? null : num10, (i2 & 4096) != 0 ? null : str21, (i2 & 8192) != 0 ? null : str22, (i2 & 16384) != 0 ? null : str23, (i2 & 32768) != 0 ? null : str24, (i2 & 65536) != 0 ? null : str25, (i2 & 131072) != 0 ? null : b6, (i2 & 262144) != 0 ? null : str26, (i2 & 524288) != 0 ? null : num11, (i2 & 1048576) != 0 ? null : num12, (i2 & 2097152) != 0 ? null : num13, (i2 & 4194304) != 0 ? null : num14, (i2 & 8388608) != 0 ? null : num15);
                }

                public final Byte getAfterHandleType() {
                    return this.afterHandleType;
                }

                public final Byte getBenefitType() {
                    return this.benefitType;
                }

                public final Integer getChannel() {
                    return this.channel;
                }

                public final List<String> getCouponCodeIdList() {
                    return this.couponCodeIdList;
                }

                public final String getCouponCodeName() {
                    return this.couponCodeName;
                }

                public final Byte getCouponCodeType() {
                    return this.couponCodeType;
                }

                public final String getCouponDesc() {
                    return this.couponDesc;
                }

                public final String getCouponDiscount() {
                    return this.couponDiscount;
                }

                public final CouponExtModel getCouponExt() {
                    return this.couponExt;
                }

                public final String getCouponId() {
                    return this.couponId;
                }

                public final String getCouponName() {
                    return this.couponName;
                }

                public final String getCouponStatus() {
                    return this.couponStatus;
                }

                public final String getCouponStatusMsg() {
                    return this.couponStatusMsg;
                }

                public final String getCouponTag() {
                    return this.couponTag;
                }

                public final Integer getCouponType() {
                    return this.couponType;
                }

                public final String getCouponTypeDesc() {
                    return this.couponTypeDesc;
                }

                public final String getCouponTypeName() {
                    return this.couponTypeName;
                }

                public final Integer getDiscount() {
                    return this.discount;
                }

                public final Integer getDiscountCondition() {
                    return this.discountCondition;
                }

                public final Double getDiscountConditionY() {
                    return this.discountConditionY;
                }

                public final String getDiscountLayerName() {
                    return this.discountLayerName;
                }

                public final Integer getDiscountLimit() {
                    return this.discountLimit;
                }

                public final String getDiscountLimitDesc() {
                    return this.discountLimitDesc;
                }

                public final Double getDiscountY() {
                    return this.discountY;
                }

                public final String getExclusiveName() {
                    return this.exclusiveName;
                }

                public final String getFollowId() {
                    return this.followId;
                }

                public final String getFollowUpName() {
                    return this.followUpName;
                }

                public final String getFollowName() {
                    return this.followName;
                }

                public final Integer getFollowStatus() {
                    return this.followStatus;
                }

                public final Boolean getHasReceived() {
                    return this.hasReceived;
                }

                public final Boolean isReceived() {
                    return this.isReceived;
                }

                public final List<Long> getItemsList() {
                    return this.itemsList;
                }

                public final String getLandingPageUrl() {
                    return this.landingPageUrl;
                }

                public final Integer getMaxNumPerUser() {
                    return this.maxNumPerUser;
                }

                public final Boolean getNeedDeviceCheck() {
                    return this.needDeviceCheck;
                }

                public final Byte getNewUserLimit() {
                    return this.newUserLimit;
                }

                public final String getOwners() {
                    return this.owners;
                }

                public final String getOwnersName() {
                    return this.ownersName;
                }

                public final String getPreCouponDiscount() {
                    return this.preCouponDiscount;
                }

                public final Integer getReceiveEndTime() {
                    return this.receiveEndTime;
                }

                public final Integer getReceiveStartTime() {
                    return this.receiveStartTime;
                }

                public final Byte getScopeType() {
                    return this.scopeType;
                }

                public final Long getServerTime() {
                    return this.serverTime;
                }

                public final Integer getShopId() {
                    return this.shopId;
                }

                public final String getShopLabel() {
                    return this.shopLabel;
                }

                public final String getShowName() {
                    return this.showName;
                }

                public final String getSourceActivityId() {
                    return this.sourceActivityId;
                }

                public final String getSourceAuthorityId() {
                    return this.sourceAuthorityId;
                }

                public final String getSourceId() {
                    return this.sourceId;
                }

                public final Byte getStatus() {
                    return this.status;
                }

                public final String getSufCouponDiscount() {
                    return this.sufCouponDiscount;
                }

                public final Integer getUseEffectDays() {
                    return this.useEffectDays;
                }

                public final Integer getUseEffectUnit() {
                    return this.useEffectUnit;
                }

                public final Integer getUseEndTime() {
                    return this.useEndTime;
                }

                public final Integer getUseStartTime() {
                    return this.useStartTime;
                }

                /* compiled from: CouponListApiService.kt */
                @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 92\u00020\u0001:\u000289Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fBq\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000e\u0010\u0014J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jt\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0011HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001J%\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0001¢\u0006\u0002\b7R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\t\u0010\u001bR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016¨\u0006:"}, d2 = {"Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem$CouponExtModel;", "", "amountLimitDesc", "", "batchIds", "", "", "couponScene", "couponScope", "isMore", "", "priceBreakCopyWriting", "receiveUser", "showDiscount", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAmountLimitDesc", "()Ljava/lang/String;", "getBatchIds", "()Ljava/util/List;", "getCouponScene", "getCouponScope", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPriceBreakCopyWriting$annotations", "()V", "getPriceBreakCopyWriting", "getReceiveUser", "getShowDiscount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem$CouponExtModel;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                @Serializable
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class CouponExtModel {
                    private final String amountLimitDesc;
                    private final List<Long> batchIds;
                    private final String couponScene;
                    private final String couponScope;
                    private final Boolean isMore;
                    private final String priceBreakCopyWriting;
                    private final String receiveUser;
                    private final String showDiscount;
                    public static final Companion Companion = new Companion(null);
                    public static final int $stable = 8;
                    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.CouponListResponse$CouponListItem$CouponExtModel$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            KSerializer _childSerializers$_anonymous_;
                            _childSerializers$_anonymous_ = CouponListResponse.CouponListItem.CouponExtModel._childSerializers$_anonymous_();
                            return _childSerializers$_anonymous_;
                        }
                    }), null, null, null, null, null, null};

                    public CouponExtModel() {
                        this((String) null, (List) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (int) KotlinVersion.MAX_COMPONENT_VALUE, (DefaultConstructorMarker) null);
                    }

                    @SerialName("priceBreakCopywriting")
                    public static /* synthetic */ void getPriceBreakCopyWriting$annotations() {
                    }

                    public final String component1() {
                        return this.amountLimitDesc;
                    }

                    public final List<Long> component2() {
                        return this.batchIds;
                    }

                    public final String component3() {
                        return this.couponScene;
                    }

                    public final String component4() {
                        return this.couponScope;
                    }

                    public final Boolean component5() {
                        return this.isMore;
                    }

                    public final String component6() {
                        return this.priceBreakCopyWriting;
                    }

                    public final String component7() {
                        return this.receiveUser;
                    }

                    public final String component8() {
                        return this.showDiscount;
                    }

                    public final CouponExtModel copy(String str, List<Long> list, String str2, String str3, Boolean bool, String str4, String str5, String str6) {
                        return new CouponExtModel(str, list, str2, str3, bool, str4, str5, str6);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof CouponExtModel) {
                            CouponExtModel couponExtModel = (CouponExtModel) obj;
                            return Intrinsics.areEqual(this.amountLimitDesc, couponExtModel.amountLimitDesc) && Intrinsics.areEqual(this.batchIds, couponExtModel.batchIds) && Intrinsics.areEqual(this.couponScene, couponExtModel.couponScene) && Intrinsics.areEqual(this.couponScope, couponExtModel.couponScope) && Intrinsics.areEqual(this.isMore, couponExtModel.isMore) && Intrinsics.areEqual(this.priceBreakCopyWriting, couponExtModel.priceBreakCopyWriting) && Intrinsics.areEqual(this.receiveUser, couponExtModel.receiveUser) && Intrinsics.areEqual(this.showDiscount, couponExtModel.showDiscount);
                        }
                        return false;
                    }

                    public int hashCode() {
                        return ((((((((((((((this.amountLimitDesc == null ? 0 : this.amountLimitDesc.hashCode()) * 31) + (this.batchIds == null ? 0 : this.batchIds.hashCode())) * 31) + (this.couponScene == null ? 0 : this.couponScene.hashCode())) * 31) + (this.couponScope == null ? 0 : this.couponScope.hashCode())) * 31) + (this.isMore == null ? 0 : this.isMore.hashCode())) * 31) + (this.priceBreakCopyWriting == null ? 0 : this.priceBreakCopyWriting.hashCode())) * 31) + (this.receiveUser == null ? 0 : this.receiveUser.hashCode())) * 31) + (this.showDiscount != null ? this.showDiscount.hashCode() : 0);
                    }

                    public String toString() {
                        String str = this.amountLimitDesc;
                        List<Long> list = this.batchIds;
                        String str2 = this.couponScene;
                        String str3 = this.couponScope;
                        Boolean bool = this.isMore;
                        String str4 = this.priceBreakCopyWriting;
                        String str5 = this.receiveUser;
                        return "CouponExtModel(amountLimitDesc=" + str + ", batchIds=" + list + ", couponScene=" + str2 + ", couponScope=" + str3 + ", isMore=" + bool + ", priceBreakCopyWriting=" + str4 + ", receiveUser=" + str5 + ", showDiscount=" + this.showDiscount + ")";
                    }

                    /* compiled from: CouponListApiService.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem$CouponExtModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem$CouponExtModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<CouponExtModel> serializer() {
                            return CouponListResponse$CouponListItem$CouponExtModel$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ CouponExtModel(int seen0, String amountLimitDesc, List batchIds, String couponScene, String couponScope, Boolean isMore, String priceBreakCopyWriting, String receiveUser, String showDiscount, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((seen0 & 1) == 0) {
                            this.amountLimitDesc = null;
                        } else {
                            this.amountLimitDesc = amountLimitDesc;
                        }
                        if ((seen0 & 2) == 0) {
                            this.batchIds = null;
                        } else {
                            this.batchIds = batchIds;
                        }
                        if ((seen0 & 4) == 0) {
                            this.couponScene = null;
                        } else {
                            this.couponScene = couponScene;
                        }
                        if ((seen0 & 8) == 0) {
                            this.couponScope = null;
                        } else {
                            this.couponScope = couponScope;
                        }
                        if ((seen0 & 16) == 0) {
                            this.isMore = null;
                        } else {
                            this.isMore = isMore;
                        }
                        if ((seen0 & 32) == 0) {
                            this.priceBreakCopyWriting = null;
                        } else {
                            this.priceBreakCopyWriting = priceBreakCopyWriting;
                        }
                        if ((seen0 & 64) == 0) {
                            this.receiveUser = null;
                        } else {
                            this.receiveUser = receiveUser;
                        }
                        if ((seen0 & 128) == 0) {
                            this.showDiscount = null;
                        } else {
                            this.showDiscount = showDiscount;
                        }
                    }

                    public CouponExtModel(String amountLimitDesc, List<Long> list, String couponScene, String couponScope, Boolean isMore, String priceBreakCopyWriting, String receiveUser, String showDiscount) {
                        this.amountLimitDesc = amountLimitDesc;
                        this.batchIds = list;
                        this.couponScene = couponScene;
                        this.couponScope = couponScope;
                        this.isMore = isMore;
                        this.priceBreakCopyWriting = priceBreakCopyWriting;
                        this.receiveUser = receiveUser;
                        this.showDiscount = showDiscount;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                        return new ArrayListSerializer(LongSerializer.INSTANCE);
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$product_details_page_debug(CouponExtModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.amountLimitDesc != null) {
                            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.amountLimitDesc);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.batchIds != null) {
                            output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.batchIds);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.couponScene != null) {
                            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.couponScene);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.couponScope != null) {
                            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.couponScope);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.isMore != null) {
                            output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.isMore);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.priceBreakCopyWriting != null) {
                            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.priceBreakCopyWriting);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.receiveUser != null) {
                            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.receiveUser);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.showDiscount != null) {
                            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.showDiscount);
                        }
                    }

                    public /* synthetic */ CouponExtModel(String str, List list, String str2, String str3, Boolean bool, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) == 0 ? str6 : null);
                    }

                    public final String getAmountLimitDesc() {
                        return this.amountLimitDesc;
                    }

                    public final List<Long> getBatchIds() {
                        return this.batchIds;
                    }

                    public final String getCouponScene() {
                        return this.couponScene;
                    }

                    public final String getCouponScope() {
                        return this.couponScope;
                    }

                    public final Boolean isMore() {
                        return this.isMore;
                    }

                    public final String getPriceBreakCopyWriting() {
                        return this.priceBreakCopyWriting;
                    }

                    public final String getReceiveUser() {
                        return this.receiveUser;
                    }

                    public final String getShowDiscount() {
                        return this.showDiscount;
                    }
                }

                public final Integer getUserCouponReceiveStatus() {
                    return this.userCouponReceiveStatus;
                }
            }

            public final boolean isValid$product_details_page_debug() {
                return this.code == 0 && this.data != null;
            }
        }