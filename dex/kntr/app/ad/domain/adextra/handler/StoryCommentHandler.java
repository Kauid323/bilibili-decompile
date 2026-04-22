package kntr.app.ad.domain.adextra.handler;

import kntr.app.ad.common.utils.JsonExtKt;
import kntr.app.ad.domain.adextra.handler.DefaultHandler;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.ad.protocol.adextra.AdExtraStoryCommentQuery;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: StoryCommentHandler.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/StoryCommentHandler;", "Lkntr/app/ad/domain/adextra/handler/IAdExtraQueryHandler;", "Lkntr/app/ad/protocol/adextra/AdExtraStoryCommentQuery;", "<init>", "()V", "handle", RoomRecommendViewModel.EMPTY_CURSOR, "query", "Response", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StoryCommentHandler implements IAdExtraQueryHandler<AdExtraStoryCommentQuery> {

    /* compiled from: StoryCommentHandler.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 U2\u00020\u0001:\u0003STUB7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tBï\u0003\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0003\u0012\b\u00100\u001a\u0004\u0018\u00010\u0003\u0012\b\u00101\u001a\u0004\u0018\u00010\u0003\u0012\b\u00102\u001a\u0004\u0018\u00010\u0003\u0012\b\u00103\u001a\u0004\u0018\u00010\u0003\u0012\b\u00104\u001a\u0004\u0018\u00010\u0003\u0012\b\u00105\u001a\u0004\u0018\u00010\u0003\u0012\b\u00106\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u00107\u001a\u0004\u0018\u000108¢\u0006\u0004\b\b\u00109J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010D\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010HHÖ\u0003J\t\u0010I\u001a\u00020\u000bHÖ\u0001J\t\u0010J\u001a\u00020\u0003HÖ\u0001J%\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QH\u0001¢\u0006\u0002\bRR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010;R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010;¨\u0006V"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/StoryCommentHandler$Response;", "Lkntr/app/ad/domain/adextra/handler/DefaultHandler$Response;", "aiTrackId", RoomRecommendViewModel.EMPTY_CURSOR, "ocpxTargetType", "commentReq", "Lkntr/app/ad/domain/adextra/handler/StoryCommentHandler$Response$CommentReq;", "natureAd", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/domain/adextra/handler/StoryCommentHandler$Response$CommentReq;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "seen1", "networkV2", ReportBuildInParam.NETWORK, "operatorType", ReportBuildInParam.VENDOR, ReportBuildInParam.MODEL, ReportBuildInParam.UA, "uaSys", "mobiApp", "osV", ReportBuildInParam.BUILD, "screenSize", "bootMark", "updateMark", "userApps", "dnsClientIp", "opensdkVer", ReportBuildInParam.LNG, ReportBuildInParam.LAT, "lbsTs", "storyShownIds", "apName", "apMac", "isKntr", ReportBuildInParam.IMEI, ReportBuildInParam.MAC, ReportBuildInParam.ANDROID_ID, ReportBuildInParam.OAID, "gameId", ReportBuildInParam.DISK, "hardwareModel", "initialTime", ReportBuildInParam.IDFA, ReportBuildInParam.LANGUAGE, ReportBuildInParam.MACHINE, ReportBuildInParam.MEMORY, ReportBuildInParam.BOOT_TIME_IN_SEC, "carrierInfo", ReportBuildInParam.COUNTRY_CODE, ReportBuildInParam.DEVICE_NAME, ReportBuildInParam.SYS_FILE_TIME, "systemVersion", ReportBuildInParam.TIME_ZONE, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/domain/adextra/handler/StoryCommentHandler$Response$CommentReq;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAiTrackId", "()Ljava/lang/String;", "getOcpxTargetType", "getCommentReq", "()Lkntr/app/ad/domain/adextra/handler/StoryCommentHandler$Response$CommentReq;", "getNatureAd", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adextra_debug", "CommentReq", "$serializer", "Companion", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Response extends DefaultHandler.Response {
        public static final Companion Companion = new Companion(null);
        private final String aiTrackId;
        private final CommentReq commentReq;
        private final String natureAd;
        private final String ocpxTargetType;

        public Response() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ Response copy$default(Response response, String str, String str2, CommentReq commentReq, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = response.aiTrackId;
            }
            if ((i & 2) != 0) {
                str2 = response.ocpxTargetType;
            }
            if ((i & 4) != 0) {
                commentReq = response.commentReq;
            }
            if ((i & 8) != 0) {
                str3 = response.natureAd;
            }
            return response.copy(str, str2, commentReq, str3);
        }

        public final String component1() {
            return this.aiTrackId;
        }

        public final String component2() {
            return this.ocpxTargetType;
        }

        public final CommentReq component3() {
            return this.commentReq;
        }

        public final String component4() {
            return this.natureAd;
        }

        public final Response copy(String str, String str2, CommentReq commentReq, String str3) {
            return new Response(str, str2, commentReq, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Response) {
                Response response = (Response) obj;
                return Intrinsics.areEqual(this.aiTrackId, response.aiTrackId) && Intrinsics.areEqual(this.ocpxTargetType, response.ocpxTargetType) && Intrinsics.areEqual(this.commentReq, response.commentReq) && Intrinsics.areEqual(this.natureAd, response.natureAd);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.aiTrackId == null ? 0 : this.aiTrackId.hashCode()) * 31) + (this.ocpxTargetType == null ? 0 : this.ocpxTargetType.hashCode())) * 31) + (this.commentReq == null ? 0 : this.commentReq.hashCode())) * 31) + (this.natureAd != null ? this.natureAd.hashCode() : 0);
        }

        public String toString() {
            String str = this.aiTrackId;
            String str2 = this.ocpxTargetType;
            CommentReq commentReq = this.commentReq;
            return "Response(aiTrackId=" + str + ", ocpxTargetType=" + str2 + ", commentReq=" + commentReq + ", natureAd=" + this.natureAd + ")";
        }

        /* compiled from: StoryCommentHandler.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/StoryCommentHandler$Response$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/domain/adextra/handler/StoryCommentHandler$Response;", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Response> serializer() {
                return new GeneratedSerializer<Response>() { // from class: kntr.app.ad.domain.adextra.handler.StoryCommentHandler$Response$$serializer
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.domain.adextra.handler.StoryCommentHandler.Response", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.ad.domain.adextra.handler.StoryCommentHandler$Response> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.ad.domain.adextra.handler.StoryCommentHandler$Response> A[REMOVE]) =  kntr.app.ad.domain.adextra.handler.StoryCommentHandler$Response$$serializer.INSTANCE kntr.app.ad.domain.adextra.handler.StoryCommentHandler$Response$$serializer)
                             in method: kntr.app.ad.domain.adextra.handler.StoryCommentHandler.Response.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.ad.domain.adextra.handler.StoryCommentHandler$Response>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                              ("kntr.app.ad.domain.adextra.handler.StoryCommentHandler.Response")
                              (wrap: kntr.app.ad.domain.adextra.handler.StoryCommentHandler$Response$$serializer : 0x0009: SGET  (r1v0 kntr.app.ad.domain.adextra.handler.StoryCommentHandler$Response$$serializer A[REMOVE]) =  kntr.app.ad.domain.adextra.handler.StoryCommentHandler$Response$$serializer.INSTANCE kntr.app.ad.domain.adextra.handler.StoryCommentHandler$Response$$serializer)
                              (46 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.ad.domain.adextra.handler.StoryCommentHandler$Response$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.ad.domain.adextra.handler.StoryCommentHandler$Response$$serializer
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
                            kntr.app.ad.domain.adextra.handler.StoryCommentHandler$Response$$serializer r0 = kntr.app.ad.domain.adextra.handler.StoryCommentHandler$Response$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.ad.domain.adextra.handler.StoryCommentHandler.Response.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ Response(int seen0, int seen1, String networkV2, String network, String operatorType, String vendor, String model, String ua, String uaSys, String mobiApp, String osV, Integer build, String screenSize, String bootMark, String updateMark, String userApps, String dnsClientIp, String opensdkVer, String lng, String lat, String lbsTs, String storyShownIds, String apName, String apMac, String isKntr, String imei, String mac, String androidid, String oaid, String gameId, String disk, String hardwareModel, String initialTime, String idfa, String language, String machine, String memory, String bootTimeInSec, String carrierInfo, String countryCode, String deviceName, String sysFileTime, String systemVersion, String timeZone, String aiTrackId, String ocpxTargetType, CommentReq commentReq, String natureAd, SerializationConstructorMarker serializationConstructorMarker) {
                    super(seen0, seen1, networkV2, network, operatorType, vendor, model, ua, uaSys, mobiApp, osV, build, screenSize, bootMark, updateMark, userApps, dnsClientIp, opensdkVer, lng, lat, lbsTs, storyShownIds, apName, apMac, isKntr, imei, mac, androidid, oaid, gameId, disk, hardwareModel, initialTime, idfa, language, machine, memory, bootTimeInSec, carrierInfo, countryCode, deviceName, sysFileTime, systemVersion, timeZone, serializationConstructorMarker);
                    Response response;
                    if ((seen1 & 1024) == 0) {
                        response = this;
                        response.aiTrackId = null;
                    } else {
                        response = this;
                        response.aiTrackId = aiTrackId;
                    }
                    if ((seen1 & 2048) == 0) {
                        response.ocpxTargetType = null;
                    } else {
                        response.ocpxTargetType = ocpxTargetType;
                    }
                    if ((seen1 & 4096) == 0) {
                        response.commentReq = null;
                    } else {
                        response.commentReq = commentReq;
                    }
                    if ((seen1 & 8192) == 0) {
                        response.natureAd = null;
                    } else {
                        response.natureAd = natureAd;
                    }
                }

                public Response(String aiTrackId, String ocpxTargetType, CommentReq commentReq, String natureAd) {
                    this.aiTrackId = aiTrackId;
                    this.ocpxTargetType = ocpxTargetType;
                    this.commentReq = commentReq;
                    this.natureAd = natureAd;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$adextra_debug(Response self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    DefaultHandler.Response.write$Self(self, output, serialDesc);
                    if (output.shouldEncodeElementDefault(serialDesc, 42) || self.aiTrackId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 42, StringSerializer.INSTANCE, self.aiTrackId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 43) || self.ocpxTargetType != null) {
                        output.encodeNullableSerializableElement(serialDesc, 43, StringSerializer.INSTANCE, self.ocpxTargetType);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 44) || self.commentReq != null) {
                        output.encodeNullableSerializableElement(serialDesc, 44, StoryCommentHandler$Response$CommentReq$$serializer.INSTANCE, self.commentReq);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 45) || self.natureAd != null) {
                        output.encodeNullableSerializableElement(serialDesc, 45, StringSerializer.INSTANCE, self.natureAd);
                    }
                }

                public /* synthetic */ Response(String str, String str2, CommentReq commentReq, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : commentReq, (i & 8) != 0 ? null : str3);
                }

                public final String getAiTrackId() {
                    return this.aiTrackId;
                }

                public final String getOcpxTargetType() {
                    return this.ocpxTargetType;
                }

                public final CommentReq getCommentReq() {
                    return this.commentReq;
                }

                /* compiled from: StoryCommentHandler.kt */
                @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 -2\u00020\u0001:\u0002,-BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nBM\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\fHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006."}, d2 = {"Lkntr/app/ad/domain/adextra/handler/StoryCommentHandler$Response$CommentReq;", RoomRecommendViewModel.EMPTY_CURSOR, "ocpxTargetType", RoomRecommendViewModel.EMPTY_CURSOR, "linkedCreativeId", RoomRecommendViewModel.EMPTY_CURSOR, "trackId", "sourceId", "requestId", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOcpxTargetType", "()Ljava/lang/String;", "getLinkedCreativeId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTrackId", "getSourceId", "getRequestId", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lkntr/app/ad/domain/adextra/handler/StoryCommentHandler$Response$CommentReq;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adextra_debug", "$serializer", "Companion", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                @Serializable
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class CommentReq {
                    public static final Companion Companion = new Companion(null);
                    private final Long linkedCreativeId;
                    private final String ocpxTargetType;
                    private final String requestId;
                    private final Long sourceId;
                    private final String trackId;

                    public CommentReq() {
                        this((String) null, (Long) null, (String) null, (Long) null, (String) null, 31, (DefaultConstructorMarker) null);
                    }

                    public static /* synthetic */ CommentReq copy$default(CommentReq commentReq, String str, Long l, String str2, Long l2, String str3, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = commentReq.ocpxTargetType;
                        }
                        if ((i & 2) != 0) {
                            l = commentReq.linkedCreativeId;
                        }
                        Long l3 = l;
                        if ((i & 4) != 0) {
                            str2 = commentReq.trackId;
                        }
                        String str4 = str2;
                        if ((i & 8) != 0) {
                            l2 = commentReq.sourceId;
                        }
                        Long l4 = l2;
                        if ((i & 16) != 0) {
                            str3 = commentReq.requestId;
                        }
                        return commentReq.copy(str, l3, str4, l4, str3);
                    }

                    public final String component1() {
                        return this.ocpxTargetType;
                    }

                    public final Long component2() {
                        return this.linkedCreativeId;
                    }

                    public final String component3() {
                        return this.trackId;
                    }

                    public final Long component4() {
                        return this.sourceId;
                    }

                    public final String component5() {
                        return this.requestId;
                    }

                    public final CommentReq copy(String str, Long l, String str2, Long l2, String str3) {
                        return new CommentReq(str, l, str2, l2, str3);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof CommentReq) {
                            CommentReq commentReq = (CommentReq) obj;
                            return Intrinsics.areEqual(this.ocpxTargetType, commentReq.ocpxTargetType) && Intrinsics.areEqual(this.linkedCreativeId, commentReq.linkedCreativeId) && Intrinsics.areEqual(this.trackId, commentReq.trackId) && Intrinsics.areEqual(this.sourceId, commentReq.sourceId) && Intrinsics.areEqual(this.requestId, commentReq.requestId);
                        }
                        return false;
                    }

                    public int hashCode() {
                        return ((((((((this.ocpxTargetType == null ? 0 : this.ocpxTargetType.hashCode()) * 31) + (this.linkedCreativeId == null ? 0 : this.linkedCreativeId.hashCode())) * 31) + (this.trackId == null ? 0 : this.trackId.hashCode())) * 31) + (this.sourceId == null ? 0 : this.sourceId.hashCode())) * 31) + (this.requestId != null ? this.requestId.hashCode() : 0);
                    }

                    public String toString() {
                        String str = this.ocpxTargetType;
                        Long l = this.linkedCreativeId;
                        String str2 = this.trackId;
                        Long l2 = this.sourceId;
                        return "CommentReq(ocpxTargetType=" + str + ", linkedCreativeId=" + l + ", trackId=" + str2 + ", sourceId=" + l2 + ", requestId=" + this.requestId + ")";
                    }

                    /* compiled from: StoryCommentHandler.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/StoryCommentHandler$Response$CommentReq$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/domain/adextra/handler/StoryCommentHandler$Response$CommentReq;", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<CommentReq> serializer() {
                            return StoryCommentHandler$Response$CommentReq$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ CommentReq(int seen0, String ocpxTargetType, Long linkedCreativeId, String trackId, Long sourceId, String requestId, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((seen0 & 1) == 0) {
                            this.ocpxTargetType = null;
                        } else {
                            this.ocpxTargetType = ocpxTargetType;
                        }
                        if ((seen0 & 2) == 0) {
                            this.linkedCreativeId = null;
                        } else {
                            this.linkedCreativeId = linkedCreativeId;
                        }
                        if ((seen0 & 4) == 0) {
                            this.trackId = null;
                        } else {
                            this.trackId = trackId;
                        }
                        if ((seen0 & 8) == 0) {
                            this.sourceId = null;
                        } else {
                            this.sourceId = sourceId;
                        }
                        if ((seen0 & 16) == 0) {
                            this.requestId = null;
                        } else {
                            this.requestId = requestId;
                        }
                    }

                    public CommentReq(String ocpxTargetType, Long linkedCreativeId, String trackId, Long sourceId, String requestId) {
                        this.ocpxTargetType = ocpxTargetType;
                        this.linkedCreativeId = linkedCreativeId;
                        this.trackId = trackId;
                        this.sourceId = sourceId;
                        this.requestId = requestId;
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$adextra_debug(CommentReq self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.ocpxTargetType != null) {
                            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.ocpxTargetType);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.linkedCreativeId != null) {
                            output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.linkedCreativeId);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.trackId != null) {
                            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.trackId);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.sourceId != null) {
                            output.encodeNullableSerializableElement(serialDesc, 3, LongSerializer.INSTANCE, self.sourceId);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.requestId != null) {
                            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.requestId);
                        }
                    }

                    public /* synthetic */ CommentReq(String str, Long l, String str2, Long l2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : l2, (i & 16) != 0 ? null : str3);
                    }

                    public final String getOcpxTargetType() {
                        return this.ocpxTargetType;
                    }

                    public final Long getLinkedCreativeId() {
                        return this.linkedCreativeId;
                    }

                    public final String getTrackId() {
                        return this.trackId;
                    }

                    public final Long getSourceId() {
                        return this.sourceId;
                    }

                    public final String getRequestId() {
                        return this.requestId;
                    }
                }

                public final String getNatureAd() {
                    return this.natureAd;
                }
            }

            @Override // kntr.app.ad.domain.adextra.handler.IAdExtraQueryHandler
            public String handle(AdExtraStoryCommentQuery query) {
                Long longOrNull;
                Intrinsics.checkNotNullParameter(query, "query");
                String ocpxTargetType = null;
                Response.CommentReq commentReq = null;
                String natureAd = null;
                String str = null;
                if (query.isAd()) {
                    ocpxTargetType = query.getOcpxTargetType();
                    String ocpxTargetType2 = query.getOcpxTargetType();
                    String valueOf = (ocpxTargetType2 == null || (longOrNull = StringsKt.toLongOrNull(ocpxTargetType2)) == null) ? null : String.valueOf(longOrNull.longValue());
                    Long linkedCreativeId = query.getLinkedCreativeId();
                    Long valueOf2 = Long.valueOf(linkedCreativeId != null ? linkedCreativeId.longValue() : 0L);
                    String trackId = query.getTrackId();
                    String str2 = RoomRecommendViewModel.EMPTY_CURSOR;
                    String str3 = trackId == null ? RoomRecommendViewModel.EMPTY_CURSOR : trackId;
                    Long sourceId = query.getSourceId();
                    Long valueOf3 = Long.valueOf(sourceId != null ? sourceId.longValue() : 0L);
                    String requestId = query.getRequestId();
                    if (requestId != null) {
                        str2 = requestId;
                    }
                    commentReq = new Response.CommentReq(valueOf, valueOf2, str3, valueOf3, str2);
                    String it = query.getNatureAd();
                    if (it == null || StringsKt.isBlank(it)) {
                        it = null;
                    }
                    natureAd = it;
                }
                String it2 = query.getAiTrackId();
                if (it2 != null && !StringsKt.isBlank(it2)) {
                    str = it2;
                }
                Response it3 = new Response(str, ocpxTargetType, commentReq, natureAd);
                StringFormat $this$encodeToString$iv = JsonExtKt.getAdJson();
                $this$encodeToString$iv.getSerializersModule();
                return $this$encodeToString$iv.encodeToString(Response.Companion.serializer(), it3);
            }
        }