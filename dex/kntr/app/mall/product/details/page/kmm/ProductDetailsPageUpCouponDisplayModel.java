package kntr.app.mall.product.details.page.kmm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.CouponInfoModel;
import kntr.app.mall.product.details.page.api.model.CouponPackageInfoModel;
import kntr.app.mall.product.details.page.api.model.CouponPackageInfoModel$CouponPackagePopInfoModel$$serializer;
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
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ProductDetailsPageUpCouponDisplayModel.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\b\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0005H\u0007J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\nHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006'"}, d2 = {"Lkntr/app/mall/product/details/page/kmm/ProductDetailsPageUpCouponDisplayModel;", "", "popupInfoModel", "Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackagePopInfoModel;", "successReceivedAuthorityIds", "", "", "<init>", "(Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackagePopInfoModel;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackagePopInfoModel;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPopupInfoModel", "()Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackagePopInfoModel;", "getSuccessReceivedAuthorityIds", "()Ljava/util/List;", "isValid", "", "getValidCouponInfoList", "Lkntr/app/mall/product/details/page/api/model/CouponInfoModel;", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class ProductDetailsPageUpCouponDisplayModel {
    private final CouponPackageInfoModel.CouponPackagePopInfoModel popupInfoModel;
    private final List<String> successReceivedAuthorityIds;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ProductDetailsPageUpCouponDisplayModel._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public ProductDetailsPageUpCouponDisplayModel() {
        this((CouponPackageInfoModel.CouponPackagePopInfoModel) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProductDetailsPageUpCouponDisplayModel copy$default(ProductDetailsPageUpCouponDisplayModel productDetailsPageUpCouponDisplayModel, CouponPackageInfoModel.CouponPackagePopInfoModel couponPackagePopInfoModel, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            couponPackagePopInfoModel = productDetailsPageUpCouponDisplayModel.popupInfoModel;
        }
        if ((i & 2) != 0) {
            list = productDetailsPageUpCouponDisplayModel.successReceivedAuthorityIds;
        }
        return productDetailsPageUpCouponDisplayModel.copy(couponPackagePopInfoModel, list);
    }

    public final CouponPackageInfoModel.CouponPackagePopInfoModel component1() {
        return this.popupInfoModel;
    }

    public final List<String> component2() {
        return this.successReceivedAuthorityIds;
    }

    public final ProductDetailsPageUpCouponDisplayModel copy(CouponPackageInfoModel.CouponPackagePopInfoModel couponPackagePopInfoModel, List<String> list) {
        return new ProductDetailsPageUpCouponDisplayModel(couponPackagePopInfoModel, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProductDetailsPageUpCouponDisplayModel) {
            ProductDetailsPageUpCouponDisplayModel productDetailsPageUpCouponDisplayModel = (ProductDetailsPageUpCouponDisplayModel) obj;
            return Intrinsics.areEqual(this.popupInfoModel, productDetailsPageUpCouponDisplayModel.popupInfoModel) && Intrinsics.areEqual(this.successReceivedAuthorityIds, productDetailsPageUpCouponDisplayModel.successReceivedAuthorityIds);
        }
        return false;
    }

    public int hashCode() {
        return ((this.popupInfoModel == null ? 0 : this.popupInfoModel.hashCode()) * 31) + (this.successReceivedAuthorityIds != null ? this.successReceivedAuthorityIds.hashCode() : 0);
    }

    public String toString() {
        CouponPackageInfoModel.CouponPackagePopInfoModel couponPackagePopInfoModel = this.popupInfoModel;
        return "ProductDetailsPageUpCouponDisplayModel(popupInfoModel=" + couponPackagePopInfoModel + ", successReceivedAuthorityIds=" + this.successReceivedAuthorityIds + ")";
    }

    /* compiled from: ProductDetailsPageUpCouponDisplayModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/kmm/ProductDetailsPageUpCouponDisplayModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/kmm/ProductDetailsPageUpCouponDisplayModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ProductDetailsPageUpCouponDisplayModel> serializer() {
            return new GeneratedSerializer<ProductDetailsPageUpCouponDisplayModel>() { // from class: kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel> A[REMOVE]) =  kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel$$serializer.INSTANCE kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel$$serializer)
                         in method: kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                          ("kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel")
                          (wrap: kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel$$serializer.INSTANCE kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel$$serializer)
                          (2 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel$$serializer
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
                        kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel$$serializer r0 = kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ ProductDetailsPageUpCouponDisplayModel(int seen0, CouponPackageInfoModel.CouponPackagePopInfoModel popupInfoModel, List successReceivedAuthorityIds, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.popupInfoModel = null;
                } else {
                    this.popupInfoModel = popupInfoModel;
                }
                if ((seen0 & 2) == 0) {
                    this.successReceivedAuthorityIds = null;
                } else {
                    this.successReceivedAuthorityIds = successReceivedAuthorityIds;
                }
            }

            public ProductDetailsPageUpCouponDisplayModel(CouponPackageInfoModel.CouponPackagePopInfoModel popupInfoModel, List<String> list) {
                this.popupInfoModel = popupInfoModel;
                this.successReceivedAuthorityIds = list;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(StringSerializer.INSTANCE);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(ProductDetailsPageUpCouponDisplayModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.popupInfoModel != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, CouponPackageInfoModel$CouponPackagePopInfoModel$$serializer.INSTANCE, self.popupInfoModel);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.successReceivedAuthorityIds != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.successReceivedAuthorityIds);
                }
            }

            public /* synthetic */ ProductDetailsPageUpCouponDisplayModel(CouponPackageInfoModel.CouponPackagePopInfoModel couponPackagePopInfoModel, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : couponPackagePopInfoModel, (i & 2) != 0 ? null : list);
            }

            public final CouponPackageInfoModel.CouponPackagePopInfoModel getPopupInfoModel() {
                return this.popupInfoModel;
            }

            public final List<String> getSuccessReceivedAuthorityIds() {
                return this.successReceivedAuthorityIds;
            }

            public final boolean isValid() {
                boolean z = false;
                if (this.popupInfoModel == null) {
                    return false;
                }
                List validCouponInfoList = getValidCouponInfoList();
                List list = validCouponInfoList;
                if (list == null || list.isEmpty()) {
                    z = true;
                }
                return !z;
            }

            /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
                if ((r9 != null && kotlin.collections.CollectionsKt.contains(r9, r7.getSourceAuthorityId())) != false) goto L30;
             */
            /* JADX WARN: Removed duplicated region for block: B:42:0x0074 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:44:0x001a A[SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final List<CouponInfoModel> getValidCouponInfoList() {
                List list;
                Iterable couponInfoList;
                CouponPackageInfoModel.CouponPackagePopInfoModel couponPackagePopInfoModel = this.popupInfoModel;
                if (couponPackagePopInfoModel == null || (couponInfoList = couponPackagePopInfoModel.getCouponInfoList()) == null) {
                    list = null;
                } else {
                    Iterable $this$filter$iv = couponInfoList;
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        CouponInfoModel it = (CouponInfoModel) element$iv$iv;
                        boolean z = true;
                        if (Intrinsics.areEqual(it.getCouponAvailable(), true)) {
                            Byte status = it.getStatus();
                            if (!(status != null && status.byteValue() == 1)) {
                                Byte status2 = it.getStatus();
                                if (status2 != null && status2.byteValue() == 0) {
                                    List<String> list2 = this.successReceivedAuthorityIds;
                                }
                            }
                            if (!z) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                    }
                    list = (List) destination$iv$iv;
                }
                List validCouponInfoList = list;
                return validCouponInfoList;
            }
        }