package kntr.app.mall.product.details.page.api;

import com.bilibili.mall.kmm.base.MallEnvKt;
import java.util.Map;
import kntr.app.mall.product.details.page.api.model.FileInfoFloor;
import kntr.app.mall.product.details.page.api.model.FileInfoFloor$FileInfo$$serializer;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: ItemsFileApiService.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkntr/app/mall/product/details/page/api/ItemsFileApiService;", "", "<init>", "()V", "API_URL_STRING", "", "K_LOG_TAG", "getItemFiles", "Lkntr/app/mall/product/details/page/api/ItemsFileApiService$ItemsFileResponse;", "itemsId", "skuId", "", "getItemFiles$product_details_page_debug", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ItemsFileResponse", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ItemsFileApiService {
    public static final int $stable = 0;
    private static final String API_URL_STRING = "https://mall.bilibili.com/mall-search-items/items/merchant/files";
    public static final ItemsFileApiService INSTANCE = new ItemsFileApiService();
    private static final String K_LOG_TAG = "NA_WR_ItemsFileApiService";

    private ItemsFileApiService() {
    }

    /* compiled from: ItemsFileApiService.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBC\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020\tHÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006/"}, d2 = {"Lkntr/app/mall/product/details/page/api/ItemsFileApiService$ItemsFileResponse;", "", "code", "", "data", "Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfo;", "errtag", "", "message", "", "<init>", "(Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfo;Ljava/lang/Integer;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfo;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getData", "()Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfo;", "getErrtag", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfo;Ljava/lang/Integer;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/ItemsFileApiService$ItemsFileResponse;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ItemsFileResponse {
        private final Long code;
        private final FileInfoFloor.FileInfo data;
        private final Integer errtag;
        private final String message;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public ItemsFileResponse() {
            this((Long) null, (FileInfoFloor.FileInfo) null, (Integer) null, (String) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ItemsFileResponse copy$default(ItemsFileResponse itemsFileResponse, Long l, FileInfoFloor.FileInfo fileInfo, Integer num, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                l = itemsFileResponse.code;
            }
            if ((i & 2) != 0) {
                fileInfo = itemsFileResponse.data;
            }
            if ((i & 4) != 0) {
                num = itemsFileResponse.errtag;
            }
            if ((i & 8) != 0) {
                str = itemsFileResponse.message;
            }
            return itemsFileResponse.copy(l, fileInfo, num, str);
        }

        public final Long component1() {
            return this.code;
        }

        public final FileInfoFloor.FileInfo component2() {
            return this.data;
        }

        public final Integer component3() {
            return this.errtag;
        }

        public final String component4() {
            return this.message;
        }

        public final ItemsFileResponse copy(Long l, FileInfoFloor.FileInfo fileInfo, Integer num, String str) {
            return new ItemsFileResponse(l, fileInfo, num, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ItemsFileResponse) {
                ItemsFileResponse itemsFileResponse = (ItemsFileResponse) obj;
                return Intrinsics.areEqual(this.code, itemsFileResponse.code) && Intrinsics.areEqual(this.data, itemsFileResponse.data) && Intrinsics.areEqual(this.errtag, itemsFileResponse.errtag) && Intrinsics.areEqual(this.message, itemsFileResponse.message);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.code == null ? 0 : this.code.hashCode()) * 31) + (this.data == null ? 0 : this.data.hashCode())) * 31) + (this.errtag == null ? 0 : this.errtag.hashCode())) * 31) + (this.message != null ? this.message.hashCode() : 0);
        }

        public String toString() {
            Long l = this.code;
            FileInfoFloor.FileInfo fileInfo = this.data;
            Integer num = this.errtag;
            return "ItemsFileResponse(code=" + l + ", data=" + fileInfo + ", errtag=" + num + ", message=" + this.message + ")";
        }

        /* compiled from: ItemsFileApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ItemsFileApiService$ItemsFileResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ItemsFileApiService$ItemsFileResponse;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ItemsFileResponse> serializer() {
                return new GeneratedSerializer<ItemsFileResponse>() { // from class: kntr.app.mall.product.details.page.api.ItemsFileApiService$ItemsFileResponse$$serializer
                    public static final int $stable;
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.ItemsFileApiService.ItemsFileResponse", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.ItemsFileApiService$ItemsFileResponse> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.ItemsFileApiService$ItemsFileResponse> A[REMOVE]) =  kntr.app.mall.product.details.page.api.ItemsFileApiService$ItemsFileResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.ItemsFileApiService$ItemsFileResponse$$serializer)
                             in method: kntr.app.mall.product.details.page.api.ItemsFileApiService.ItemsFileResponse.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.ItemsFileApiService$ItemsFileResponse>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                              ("kntr.app.mall.product.details.page.api.ItemsFileApiService.ItemsFileResponse")
                              (wrap: kntr.app.mall.product.details.page.api.ItemsFileApiService$ItemsFileResponse$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.ItemsFileApiService$ItemsFileResponse$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.ItemsFileApiService$ItemsFileResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.ItemsFileApiService$ItemsFileResponse$$serializer)
                              (4 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.ItemsFileApiService$ItemsFileResponse$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.ItemsFileApiService$ItemsFileResponse$$serializer
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
                            kntr.app.mall.product.details.page.api.ItemsFileApiService$ItemsFileResponse$$serializer r0 = kntr.app.mall.product.details.page.api.ItemsFileApiService$ItemsFileResponse$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.ItemsFileApiService.ItemsFileResponse.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ ItemsFileResponse(int seen0, Long code, FileInfoFloor.FileInfo data, Integer errtag, String message, SerializationConstructorMarker serializationConstructorMarker) {
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

                public ItemsFileResponse(Long code, FileInfoFloor.FileInfo data, Integer errtag, String message) {
                    this.code = code;
                    this.data = data;
                    this.errtag = errtag;
                    this.message = message;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(ItemsFileResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Long l;
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || (l = self.code) == null || l.longValue() != 0) {
                        output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.code);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.data != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, FileInfoFloor$FileInfo$$serializer.INSTANCE, self.data);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.errtag != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.errtag);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.message != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.message);
                    }
                }

                public /* synthetic */ ItemsFileResponse(Long l, FileInfoFloor.FileInfo fileInfo, Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? 0L : l, (i & 2) != 0 ? null : fileInfo, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str);
                }

                public final Long getCode() {
                    return this.code;
                }

                public final FileInfoFloor.FileInfo getData() {
                    return this.data;
                }

                public final Integer getErrtag() {
                    return this.errtag;
                }

                public final String getMessage() {
                    return this.message;
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0062  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x016a  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object getItemFiles$product_details_page_debug(String itemsId, long skuId, Continuation<? super ItemsFileResponse> continuation) {
                ItemsFileApiService$getItemFiles$1 itemsFileApiService$getItemFiles$1;
                ItemsFileApiService$getItemFiles$1 itemsFileApiService$getItemFiles$12;
                String method$iv;
                long skuId2;
                Client $this$iv;
                Pair[] pairArr;
                Object mallKntrAsyncRequest;
                String url$iv;
                String method$iv2;
                long skuId3;
                String itemsId2;
                Client $this$iv2;
                String message;
                if (continuation instanceof ItemsFileApiService$getItemFiles$1) {
                    itemsFileApiService$getItemFiles$1 = (ItemsFileApiService$getItemFiles$1) continuation;
                    if ((itemsFileApiService$getItemFiles$1.label & Integer.MIN_VALUE) != 0) {
                        itemsFileApiService$getItemFiles$1.label -= Integer.MIN_VALUE;
                        itemsFileApiService$getItemFiles$12 = itemsFileApiService$getItemFiles$1;
                        Object $result = itemsFileApiService$getItemFiles$12.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (itemsFileApiService$getItemFiles$12.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                try {
                                    $this$iv = Client.INSTANCE;
                                    pairArr = new Pair[2];
                                    method$iv = itemsId;
                                } catch (Exception e) {
                                    e = e;
                                    method$iv = itemsId;
                                    skuId2 = skuId;
                                }
                                try {
                                    pairArr[0] = TuplesKt.to("itemsId", method$iv);
                                    pairArr[1] = TuplesKt.to("skuId", Boxing.boxLong(skuId));
                                    Map params$iv = MapsKt.mapOf(pairArr);
                                    try {
                                        itemsFileApiService$getItemFiles$12.L$0 = SpillingKt.nullOutSpilledVariable(itemsId);
                                        itemsFileApiService$getItemFiles$12.L$1 = $this$iv;
                                        itemsFileApiService$getItemFiles$12.L$2 = SpillingKt.nullOutSpilledVariable(API_URL_STRING);
                                        itemsFileApiService$getItemFiles$12.L$3 = SpillingKt.nullOutSpilledVariable("GET");
                                        itemsFileApiService$getItemFiles$12.L$4 = SpillingKt.nullOutSpilledVariable(params$iv);
                                        skuId2 = skuId;
                                        try {
                                            itemsFileApiService$getItemFiles$12.J$0 = skuId2;
                                            itemsFileApiService$getItemFiles$12.I$0 = 0;
                                            itemsFileApiService$getItemFiles$12.label = 1;
                                            mallKntrAsyncRequest = MallEnvKt.mallKntrAsyncRequest(API_URL_STRING, "GET", (Map) null, params$iv, itemsFileApiService$getItemFiles$12);
                                            if (mallKntrAsyncRequest == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            url$iv = API_URL_STRING;
                                            method$iv2 = "GET";
                                            skuId3 = skuId2;
                                            itemsId2 = method$iv;
                                            $this$iv2 = $this$iv;
                                            try {
                                                String jsonString$iv = (String) mallKntrAsyncRequest;
                                                Json this_$iv$iv = $this$iv2.getJson();
                                                Intrinsics.checkNotNull(jsonString$iv);
                                                this_$iv$iv.getSerializersModule();
                                                Object res$iv = this_$iv$iv.decodeFromString(ItemsFileResponse.Companion.serializer(), jsonString$iv);
                                                try {
                                                    return (ItemsFileResponse) res$iv;
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    method$iv = itemsId2;
                                                    skuId2 = skuId3;
                                                    KLog_androidKt.getKLog().e(K_LOG_TAG, "getItemFiles error: " + e.getMessage(), e);
                                                    message = e.getMessage();
                                                    if (message == null) {
                                                        message = "Unknown error";
                                                    }
                                                    return new ItemsFileResponse(Boxing.boxLong(-1L), (FileInfoFloor.FileInfo) null, Boxing.boxInt(-1), message, 2, (DefaultConstructorMarker) null);
                                                }
                                            } catch (Exception e3) {
                                                e$iv = e3;
                                                method$iv = itemsId2;
                                                skuId2 = skuId3;
                                                try {
                                                } catch (Exception e4) {
                                                    e = e4;
                                                }
                                                try {
                                                    KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                                    throw e$iv;
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    KLog_androidKt.getKLog().e(K_LOG_TAG, "getItemFiles error: " + e.getMessage(), e);
                                                    message = e.getMessage();
                                                    if (message == null) {
                                                    }
                                                    return new ItemsFileResponse(Boxing.boxLong(-1L), (FileInfoFloor.FileInfo) null, Boxing.boxInt(-1), message, 2, (DefaultConstructorMarker) null);
                                                }
                                            }
                                        } catch (Exception e6) {
                                            e$iv = e6;
                                            KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                            throw e$iv;
                                        }
                                    } catch (Exception e7) {
                                        e$iv = e7;
                                        skuId2 = skuId;
                                    }
                                } catch (Exception e8) {
                                    e = e8;
                                    skuId2 = skuId;
                                    KLog_androidKt.getKLog().e(K_LOG_TAG, "getItemFiles error: " + e.getMessage(), e);
                                    message = e.getMessage();
                                    if (message == null) {
                                    }
                                    return new ItemsFileResponse(Boxing.boxLong(-1L), (FileInfoFloor.FileInfo) null, Boxing.boxInt(-1), message, 2, (DefaultConstructorMarker) null);
                                }
                            case 1:
                                int i = itemsFileApiService$getItemFiles$12.I$0;
                                skuId3 = itemsFileApiService$getItemFiles$12.J$0;
                                Map map = (Map) itemsFileApiService$getItemFiles$12.L$4;
                                method$iv2 = (String) itemsFileApiService$getItemFiles$12.L$3;
                                String url$iv2 = (String) itemsFileApiService$getItemFiles$12.L$2;
                                Client $this$iv3 = (Client) itemsFileApiService$getItemFiles$12.L$1;
                                itemsId2 = (String) itemsFileApiService$getItemFiles$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    $this$iv2 = $this$iv3;
                                    url$iv = url$iv2;
                                    mallKntrAsyncRequest = $result;
                                    String jsonString$iv2 = (String) mallKntrAsyncRequest;
                                    Json this_$iv$iv2 = $this$iv2.getJson();
                                    Intrinsics.checkNotNull(jsonString$iv2);
                                    this_$iv$iv2.getSerializersModule();
                                    Object res$iv2 = this_$iv$iv2.decodeFromString(ItemsFileResponse.Companion.serializer(), jsonString$iv2);
                                    return (ItemsFileResponse) res$iv2;
                                } catch (Exception e9) {
                                    e$iv = e9;
                                    method$iv = itemsId2;
                                    skuId2 = skuId3;
                                    KLog_androidKt.getKLog().e("Client", "请求失败: " + e$iv.getMessage(), e$iv);
                                    throw e$iv;
                                }
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
                itemsFileApiService$getItemFiles$1 = new ItemsFileApiService$getItemFiles$1(this, continuation);
                itemsFileApiService$getItemFiles$12 = itemsFileApiService$getItemFiles$1;
                Object $result2 = itemsFileApiService$getItemFiles$12.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (itemsFileApiService$getItemFiles$12.label) {
                }
            }
        }