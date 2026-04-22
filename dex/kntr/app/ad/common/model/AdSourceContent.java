package kntr.app.ad.common.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdSourceContent.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 D2\u00020\u0001:\u0003BCDBg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010Bi\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u000eHÆ\u0003Ji\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u00106\u001a\u00020\b2\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0012HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001J%\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0001¢\u0006\u0002\bAR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u001cR\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0017\u001a\u0004\b\u0007\u0010 R\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u001cR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010\u0019R\u001c\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0017\u001a\u0004\b&\u0010\u001cR\u001c\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0017\u001a\u0004\b(\u0010\u001cR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0017\u001a\u0004\b*\u0010+¨\u0006E"}, d2 = {"Lkntr/app/ad/common/model/AdSourceContent;", RoomRecommendViewModel.EMPTY_CURSOR, "requestId", RoomRecommendViewModel.EMPTY_CURSOR, "sourceId", RoomRecommendViewModel.EMPTY_CURSOR, "resourceId", "isAdLoc", RoomRecommendViewModel.EMPTY_CURSOR, "serverType", ReportBuildInParam.IP, "cardIndex", "index", "adContent", "Lkntr/app/ad/common/model/AdSourceContent$AdContent;", "<init>", "(Ljava/lang/String;JJZJLjava/lang/String;JJLkntr/app/ad/common/model/AdSourceContent$AdContent;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JJZJLjava/lang/String;JJLkntr/app/ad/common/model/AdSourceContent$AdContent;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRequestId$annotations", "()V", "getRequestId", "()Ljava/lang/String;", "getSourceId$annotations", "getSourceId", "()J", "getResourceId$annotations", "getResourceId", "isAdLoc$annotations", "()Z", "getServerType$annotations", "getServerType", "getIp$annotations", "getIp", "getCardIndex$annotations", "getCardIndex", "getIndex$annotations", "getIndex", "getAdContent$annotations", "getAdContent", "()Lkntr/app/ad/common/model/AdSourceContent$AdContent;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "AdContent", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdSourceContent {
    public static final Companion Companion = new Companion(null);
    private final AdContent adContent;
    private final long cardIndex;
    private final long index;
    private final String ip;
    private final boolean isAdLoc;
    private final String requestId;
    private final long resourceId;
    private final long serverType;
    private final long sourceId;

    public AdSourceContent() {
        this((String) null, 0L, 0L, false, 0L, (String) null, 0L, 0L, (AdContent) null, 511, (DefaultConstructorMarker) null);
    }

    @SerialName("ad_content")
    public static /* synthetic */ void getAdContent$annotations() {
    }

    @SerialName(ReportBuildInParam.CARD_INDEX)
    public static /* synthetic */ void getCardIndex$annotations() {
    }

    @SerialName("index")
    public static /* synthetic */ void getIndex$annotations() {
    }

    @SerialName("client_ip")
    public static /* synthetic */ void getIp$annotations() {
    }

    @SerialName(ReportBuildInParam.REQUEST_ID)
    public static /* synthetic */ void getRequestId$annotations() {
    }

    @SerialName(ReportBuildInParam.RESOURCE_ID)
    public static /* synthetic */ void getResourceId$annotations() {
    }

    @SerialName(ReportBuildInParam.SERVER_TYPE)
    public static /* synthetic */ void getServerType$annotations() {
    }

    @SerialName("source_id")
    public static /* synthetic */ void getSourceId$annotations() {
    }

    @SerialName("is_ad_loc")
    public static /* synthetic */ void isAdLoc$annotations() {
    }

    public final String component1() {
        return this.requestId;
    }

    public final long component2() {
        return this.sourceId;
    }

    public final long component3() {
        return this.resourceId;
    }

    public final boolean component4() {
        return this.isAdLoc;
    }

    public final long component5() {
        return this.serverType;
    }

    public final String component6() {
        return this.ip;
    }

    public final long component7() {
        return this.cardIndex;
    }

    public final long component8() {
        return this.index;
    }

    public final AdContent component9() {
        return this.adContent;
    }

    public final AdSourceContent copy(String str, long j2, long j3, boolean z, long j4, String str2, long j5, long j6, AdContent adContent) {
        return new AdSourceContent(str, j2, j3, z, j4, str2, j5, j6, adContent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdSourceContent) {
            AdSourceContent adSourceContent = (AdSourceContent) obj;
            return Intrinsics.areEqual(this.requestId, adSourceContent.requestId) && this.sourceId == adSourceContent.sourceId && this.resourceId == adSourceContent.resourceId && this.isAdLoc == adSourceContent.isAdLoc && this.serverType == adSourceContent.serverType && Intrinsics.areEqual(this.ip, adSourceContent.ip) && this.cardIndex == adSourceContent.cardIndex && this.index == adSourceContent.index && Intrinsics.areEqual(this.adContent, adSourceContent.adContent);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((this.requestId == null ? 0 : this.requestId.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.sourceId)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.resourceId)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isAdLoc)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.serverType)) * 31) + (this.ip == null ? 0 : this.ip.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cardIndex)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.index)) * 31) + (this.adContent != null ? this.adContent.hashCode() : 0);
    }

    public String toString() {
        String str = this.requestId;
        long j2 = this.sourceId;
        long j3 = this.resourceId;
        boolean z = this.isAdLoc;
        long j4 = this.serverType;
        String str2 = this.ip;
        long j5 = this.cardIndex;
        long j6 = this.index;
        return "AdSourceContent(requestId=" + str + ", sourceId=" + j2 + ", resourceId=" + j3 + ", isAdLoc=" + z + ", serverType=" + j4 + ", ip=" + str2 + ", cardIndex=" + j5 + ", index=" + j6 + ", adContent=" + this.adContent + ")";
    }

    /* compiled from: AdSourceContent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdSourceContent$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdSourceContent;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdSourceContent> serializer() {
            return new GeneratedSerializer<AdSourceContent>() { // from class: kntr.app.ad.common.model.AdSourceContent$$serializer
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.common.model.AdSourceContent", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.ad.common.model.AdSourceContent> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.ad.common.model.AdSourceContent> A[REMOVE]) =  kntr.app.ad.common.model.AdSourceContent$$serializer.INSTANCE kntr.app.ad.common.model.AdSourceContent$$serializer)
                         in method: kntr.app.ad.common.model.AdSourceContent.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.ad.common.model.AdSourceContent>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                          ("kntr.app.ad.common.model.AdSourceContent")
                          (wrap: kntr.app.ad.common.model.AdSourceContent$$serializer : 0x0009: SGET  (r1v0 kntr.app.ad.common.model.AdSourceContent$$serializer A[REMOVE]) =  kntr.app.ad.common.model.AdSourceContent$$serializer.INSTANCE kntr.app.ad.common.model.AdSourceContent$$serializer)
                          (9 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.ad.common.model.AdSourceContent$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.ad.common.model.AdSourceContent$$serializer
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
                        kntr.app.ad.common.model.AdSourceContent$$serializer r0 = kntr.app.ad.common.model.AdSourceContent$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.ad.common.model.AdSourceContent.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ AdSourceContent(int seen0, String requestId, long sourceId, long resourceId, boolean isAdLoc, long serverType, String ip, long cardIndex, long index, AdContent adContent, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.requestId = null;
                } else {
                    this.requestId = requestId;
                }
                if ((seen0 & 2) == 0) {
                    this.sourceId = 0L;
                } else {
                    this.sourceId = sourceId;
                }
                if ((seen0 & 4) == 0) {
                    this.resourceId = 0L;
                } else {
                    this.resourceId = resourceId;
                }
                if ((seen0 & 8) == 0) {
                    this.isAdLoc = false;
                } else {
                    this.isAdLoc = isAdLoc;
                }
                if ((seen0 & 16) == 0) {
                    this.serverType = -1L;
                } else {
                    this.serverType = serverType;
                }
                if ((seen0 & 32) == 0) {
                    this.ip = null;
                } else {
                    this.ip = ip;
                }
                if ((seen0 & 64) == 0) {
                    this.cardIndex = -1L;
                } else {
                    this.cardIndex = cardIndex;
                }
                if ((seen0 & 128) == 0) {
                    this.index = 0L;
                } else {
                    this.index = index;
                }
                if ((seen0 & 256) == 0) {
                    this.adContent = null;
                } else {
                    this.adContent = adContent;
                }
            }

            public AdSourceContent(String requestId, long sourceId, long resourceId, boolean isAdLoc, long serverType, String ip, long cardIndex, long index, AdContent adContent) {
                this.requestId = requestId;
                this.sourceId = sourceId;
                this.resourceId = resourceId;
                this.isAdLoc = isAdLoc;
                this.serverType = serverType;
                this.ip = ip;
                this.cardIndex = cardIndex;
                this.index = index;
                this.adContent = adContent;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$dto_debug(AdSourceContent self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.requestId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.requestId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.sourceId != 0) {
                    output.encodeLongElement(serialDesc, 1, self.sourceId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.resourceId != 0) {
                    output.encodeLongElement(serialDesc, 2, self.resourceId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.isAdLoc) {
                    output.encodeBooleanElement(serialDesc, 3, self.isAdLoc);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.serverType != -1) {
                    output.encodeLongElement(serialDesc, 4, self.serverType);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.ip != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.ip);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.cardIndex != -1) {
                    output.encodeLongElement(serialDesc, 6, self.cardIndex);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.index != 0) {
                    output.encodeLongElement(serialDesc, 7, self.index);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.adContent != null) {
                    output.encodeNullableSerializableElement(serialDesc, 8, AdSourceContent$AdContent$$serializer.INSTANCE, self.adContent);
                }
            }

            public /* synthetic */ AdSourceContent(String str, long j2, long j3, boolean z, long j4, String str2, long j5, long j6, AdContent adContent, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0L : j2, (i & 4) != 0 ? 0L : j3, (i & 8) != 0 ? false : z, (i & 16) != 0 ? -1L : j4, (i & 32) != 0 ? null : str2, (i & 64) == 0 ? j5 : -1L, (i & 128) == 0 ? j6 : 0L, (i & 256) == 0 ? adContent : null);
            }

            public final String getRequestId() {
                return this.requestId;
            }

            public final long getSourceId() {
                return this.sourceId;
            }

            public final long getResourceId() {
                return this.resourceId;
            }

            public final boolean isAdLoc() {
                return this.isAdLoc;
            }

            public final long getServerType() {
                return this.serverType;
            }

            public final String getIp() {
                return this.ip;
            }

            public final long getCardIndex() {
                return this.cardIndex;
            }

            public final long getIndex() {
                return this.index;
            }

            /* compiled from: AdSourceContent.kt */
            @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000278BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eBO\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\fHÆ\u0003JI\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010+\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\nHÖ\u0001J\t\u0010.\u001a\u00020\u0006HÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u0007\u0010\u001dR\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010 R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010#¨\u00069"}, d2 = {"Lkntr/app/ad/common/model/AdSourceContent$AdContent;", RoomRecommendViewModel.EMPTY_CURSOR, "creativeId", RoomRecommendViewModel.EMPTY_CURSOR, "creativeType", "adCb", RoomRecommendViewModel.EMPTY_CURSOR, "isAd", RoomRecommendViewModel.EMPTY_CURSOR, "cmMark", RoomRecommendViewModel.EMPTY_CURSOR, "extra", "Lkntr/app/ad/common/model/AdInfoExtra;", "<init>", "(JJLjava/lang/String;ZILkntr/app/ad/common/model/AdInfoExtra;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJLjava/lang/String;ZILkntr/app/ad/common/model/AdInfoExtra;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCreativeId$annotations", "()V", "getCreativeId", "()J", "getCreativeType$annotations", "getCreativeType", "getAdCb$annotations", "getAdCb", "()Ljava/lang/String;", "isAd$annotations", "()Z", "getCmMark$annotations", "getCmMark", "()I", "getExtra$annotations", "getExtra", "()Lkntr/app/ad/common/model/AdInfoExtra;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
            @Serializable
            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            public static final class AdContent {
                public static final Companion Companion = new Companion(null);
                private final String adCb;
                private final int cmMark;
                private final long creativeId;
                private final long creativeType;
                private final AdInfoExtra extra;
                private final boolean isAd;

                public AdContent() {
                    this(0L, 0L, (String) null, false, 0, (AdInfoExtra) null, 63, (DefaultConstructorMarker) null);
                }

                @SerialName("ad_cb")
                public static /* synthetic */ void getAdCb$annotations() {
                }

                @SerialName(ReportBuildInParam.CM_MARK)
                public static /* synthetic */ void getCmMark$annotations() {
                }

                @SerialName(ReportBuildInParam.CREATIVE_ID)
                public static /* synthetic */ void getCreativeId$annotations() {
                }

                @SerialName(ReportBuildInParam.CREATIVE_TYPE)
                public static /* synthetic */ void getCreativeType$annotations() {
                }

                @SerialName("extra")
                public static /* synthetic */ void getExtra$annotations() {
                }

                @SerialName(ReportBuildInParam.IS_AD)
                public static /* synthetic */ void isAd$annotations() {
                }

                public final long component1() {
                    return this.creativeId;
                }

                public final long component2() {
                    return this.creativeType;
                }

                public final String component3() {
                    return this.adCb;
                }

                public final boolean component4() {
                    return this.isAd;
                }

                public final int component5() {
                    return this.cmMark;
                }

                public final AdInfoExtra component6() {
                    return this.extra;
                }

                public final AdContent copy(long j2, long j3, String str, boolean z, int i, AdInfoExtra adInfoExtra) {
                    return new AdContent(j2, j3, str, z, i, adInfoExtra);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof AdContent) {
                        AdContent adContent = (AdContent) obj;
                        return this.creativeId == adContent.creativeId && this.creativeType == adContent.creativeType && Intrinsics.areEqual(this.adCb, adContent.adCb) && this.isAd == adContent.isAd && this.cmMark == adContent.cmMark && Intrinsics.areEqual(this.extra, adContent.extra);
                    }
                    return false;
                }

                public int hashCode() {
                    return (((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.creativeId) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.creativeType)) * 31) + (this.adCb == null ? 0 : this.adCb.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isAd)) * 31) + this.cmMark) * 31) + (this.extra != null ? this.extra.hashCode() : 0);
                }

                public String toString() {
                    long j2 = this.creativeId;
                    long j3 = this.creativeType;
                    String str = this.adCb;
                    boolean z = this.isAd;
                    int i = this.cmMark;
                    return "AdContent(creativeId=" + j2 + ", creativeType=" + j3 + ", adCb=" + str + ", isAd=" + z + ", cmMark=" + i + ", extra=" + this.extra + ")";
                }

                /* compiled from: AdSourceContent.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdSourceContent$AdContent$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdSourceContent$AdContent;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<AdContent> serializer() {
                        return AdSourceContent$AdContent$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ AdContent(int seen0, long creativeId, long creativeType, String adCb, boolean isAd, int cmMark, AdInfoExtra extra, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.creativeId = 0L;
                    } else {
                        this.creativeId = creativeId;
                    }
                    if ((seen0 & 2) == 0) {
                        this.creativeType = 0L;
                    } else {
                        this.creativeType = creativeType;
                    }
                    if ((seen0 & 4) == 0) {
                        this.adCb = null;
                    } else {
                        this.adCb = adCb;
                    }
                    if ((seen0 & 8) == 0) {
                        this.isAd = false;
                    } else {
                        this.isAd = isAd;
                    }
                    if ((seen0 & 16) == 0) {
                        this.cmMark = 0;
                    } else {
                        this.cmMark = cmMark;
                    }
                    if ((seen0 & 32) == 0) {
                        this.extra = null;
                    } else {
                        this.extra = extra;
                    }
                }

                public AdContent(long creativeId, long creativeType, String adCb, boolean isAd, int cmMark, AdInfoExtra extra) {
                    this.creativeId = creativeId;
                    this.creativeType = creativeType;
                    this.adCb = adCb;
                    this.isAd = isAd;
                    this.cmMark = cmMark;
                    this.extra = extra;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$dto_debug(AdContent self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.creativeId != 0) {
                        output.encodeLongElement(serialDesc, 0, self.creativeId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.creativeType != 0) {
                        output.encodeLongElement(serialDesc, 1, self.creativeType);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.adCb != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.adCb);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.isAd) {
                        output.encodeBooleanElement(serialDesc, 3, self.isAd);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.cmMark != 0) {
                        output.encodeIntElement(serialDesc, 4, self.cmMark);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 5) || self.extra != null) {
                        output.encodeNullableSerializableElement(serialDesc, 5, AdInfoExtra$$serializer.INSTANCE, self.extra);
                    }
                }

                public /* synthetic */ AdContent(long j2, long j3, String str, boolean z, int i, AdInfoExtra adInfoExtra, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i2 & 1) != 0 ? 0L : j2, (i2 & 2) == 0 ? j3 : 0L, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? false : z, (i2 & 16) == 0 ? i : 0, (i2 & 32) == 0 ? adInfoExtra : null);
                }

                public final long getCreativeId() {
                    return this.creativeId;
                }

                public final long getCreativeType() {
                    return this.creativeType;
                }

                public final String getAdCb() {
                    return this.adCb;
                }

                public final boolean isAd() {
                    return this.isAd;
                }

                public final int getCmMark() {
                    return this.cmMark;
                }

                public final AdInfoExtra getExtra() {
                    return this.extra;
                }
            }

            public final AdContent getAdContent() {
                return this.adContent;
            }
        }