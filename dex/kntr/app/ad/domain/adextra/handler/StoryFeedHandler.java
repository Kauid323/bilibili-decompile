package kntr.app.ad.domain.adextra.handler;

import kntr.app.ad.common.utils.JsonExtKt;
import kntr.app.ad.domain.adextra.handler.DefaultHandler;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.ad.protocol.adextra.AdExtraStoryFeedQuery;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: StoryFeedHandler.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/StoryFeedHandler;", "Lkntr/app/ad/domain/adextra/handler/IAdExtraQueryHandler;", "Lkntr/app/ad/protocol/adextra/AdExtraStoryFeedQuery;", "<init>", "()V", "handle", RoomRecommendViewModel.EMPTY_CURSOR, "query", "Response", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StoryFeedHandler implements IAdExtraQueryHandler<AdExtraStoryFeedQuery> {

    /* compiled from: StoryFeedHandler.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 [2\u00020\u0001:\u0002Z[B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bB\u008d\u0004\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0003\u0012\b\u00100\u001a\u0004\u0018\u00010\u0003\u0012\b\u00101\u001a\u0004\u0018\u00010\u0003\u0012\b\u00102\u001a\u0004\u0018\u00010\u0003\u0012\b\u00103\u001a\u0004\u0018\u00010\u0003\u0012\b\u00104\u001a\u0004\u0018\u00010\u0003\u0012\b\u00105\u001a\u0004\u0018\u00010\u0003\u0012\b\u00106\u001a\u0004\u0018\u00010\u0003\u0012\b\u00107\u001a\u0004\u0018\u00010\u0003\u0012\b\u00108\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u00109\u001a\u0004\u0018\u00010:¢\u0006\u0004\b\n\u0010;J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010K\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010OHÖ\u0003J\t\u0010P\u001a\u00020\rHÖ\u0001J\t\u0010Q\u001a\u00020\u0003HÖ\u0001J%\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020XH\u0001¢\u0006\u0002\bYR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010=R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010=R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010=R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010=R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010=R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010=¨\u0006\\"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/StoryFeedHandler$Response;", "Lkntr/app/ad/domain/adextra/handler/DefaultHandler$Response;", "caid", RoomRecommendViewModel.EMPTY_CURSOR, "natureAd", "creativeId", "trackId", "requestId", "fromSpmid", "adStoryExtra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "seen1", "networkV2", ReportBuildInParam.NETWORK, "operatorType", ReportBuildInParam.VENDOR, ReportBuildInParam.MODEL, ReportBuildInParam.UA, "uaSys", "mobiApp", "osV", ReportBuildInParam.BUILD, "screenSize", "bootMark", "updateMark", "userApps", "dnsClientIp", "opensdkVer", ReportBuildInParam.LNG, ReportBuildInParam.LAT, "lbsTs", "storyShownIds", "apName", "apMac", "isKntr", ReportBuildInParam.IMEI, ReportBuildInParam.MAC, ReportBuildInParam.ANDROID_ID, ReportBuildInParam.OAID, "gameId", ReportBuildInParam.DISK, "hardwareModel", "initialTime", ReportBuildInParam.IDFA, ReportBuildInParam.LANGUAGE, ReportBuildInParam.MACHINE, ReportBuildInParam.MEMORY, ReportBuildInParam.BOOT_TIME_IN_SEC, "carrierInfo", ReportBuildInParam.COUNTRY_CODE, ReportBuildInParam.DEVICE_NAME, ReportBuildInParam.SYS_FILE_TIME, "systemVersion", ReportBuildInParam.TIME_ZONE, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCaid", "()Ljava/lang/String;", "getNatureAd", "getCreativeId", "getTrackId", "getRequestId", "getFromSpmid", "getAdStoryExtra", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adextra_debug", "$serializer", "Companion", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Response extends DefaultHandler.Response {
        public static final Companion Companion = new Companion(null);
        private final String adStoryExtra;
        private final String caid;
        private final String creativeId;
        private final String fromSpmid;
        private final String natureAd;
        private final String requestId;
        private final String trackId;

        public Response() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public static /* synthetic */ Response copy$default(Response response, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
            if ((i & 1) != 0) {
                str = response.caid;
            }
            if ((i & 2) != 0) {
                str2 = response.natureAd;
            }
            String str8 = str2;
            if ((i & 4) != 0) {
                str3 = response.creativeId;
            }
            String str9 = str3;
            if ((i & 8) != 0) {
                str4 = response.trackId;
            }
            String str10 = str4;
            if ((i & 16) != 0) {
                str5 = response.requestId;
            }
            String str11 = str5;
            if ((i & 32) != 0) {
                str6 = response.fromSpmid;
            }
            String str12 = str6;
            if ((i & 64) != 0) {
                str7 = response.adStoryExtra;
            }
            return response.copy(str, str8, str9, str10, str11, str12, str7);
        }

        public final String component1() {
            return this.caid;
        }

        public final String component2() {
            return this.natureAd;
        }

        public final String component3() {
            return this.creativeId;
        }

        public final String component4() {
            return this.trackId;
        }

        public final String component5() {
            return this.requestId;
        }

        public final String component6() {
            return this.fromSpmid;
        }

        public final String component7() {
            return this.adStoryExtra;
        }

        public final Response copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            return new Response(str, str2, str3, str4, str5, str6, str7);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Response) {
                Response response = (Response) obj;
                return Intrinsics.areEqual(this.caid, response.caid) && Intrinsics.areEqual(this.natureAd, response.natureAd) && Intrinsics.areEqual(this.creativeId, response.creativeId) && Intrinsics.areEqual(this.trackId, response.trackId) && Intrinsics.areEqual(this.requestId, response.requestId) && Intrinsics.areEqual(this.fromSpmid, response.fromSpmid) && Intrinsics.areEqual(this.adStoryExtra, response.adStoryExtra);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((this.caid == null ? 0 : this.caid.hashCode()) * 31) + (this.natureAd == null ? 0 : this.natureAd.hashCode())) * 31) + (this.creativeId == null ? 0 : this.creativeId.hashCode())) * 31) + (this.trackId == null ? 0 : this.trackId.hashCode())) * 31) + (this.requestId == null ? 0 : this.requestId.hashCode())) * 31) + (this.fromSpmid == null ? 0 : this.fromSpmid.hashCode())) * 31) + (this.adStoryExtra != null ? this.adStoryExtra.hashCode() : 0);
        }

        public String toString() {
            String str = this.caid;
            String str2 = this.natureAd;
            String str3 = this.creativeId;
            String str4 = this.trackId;
            String str5 = this.requestId;
            String str6 = this.fromSpmid;
            return "Response(caid=" + str + ", natureAd=" + str2 + ", creativeId=" + str3 + ", trackId=" + str4 + ", requestId=" + str5 + ", fromSpmid=" + str6 + ", adStoryExtra=" + this.adStoryExtra + ")";
        }

        /* compiled from: StoryFeedHandler.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/StoryFeedHandler$Response$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/domain/adextra/handler/StoryFeedHandler$Response;", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Response> serializer() {
                return new GeneratedSerializer<Response>() { // from class: kntr.app.ad.domain.adextra.handler.StoryFeedHandler$Response$$serializer
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.domain.adextra.handler.StoryFeedHandler.Response", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.ad.domain.adextra.handler.StoryFeedHandler$Response> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.ad.domain.adextra.handler.StoryFeedHandler$Response> A[REMOVE]) =  kntr.app.ad.domain.adextra.handler.StoryFeedHandler$Response$$serializer.INSTANCE kntr.app.ad.domain.adextra.handler.StoryFeedHandler$Response$$serializer)
                             in method: kntr.app.ad.domain.adextra.handler.StoryFeedHandler.Response.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.ad.domain.adextra.handler.StoryFeedHandler$Response>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                              ("kntr.app.ad.domain.adextra.handler.StoryFeedHandler.Response")
                              (wrap: kntr.app.ad.domain.adextra.handler.StoryFeedHandler$Response$$serializer : 0x0009: SGET  (r1v0 kntr.app.ad.domain.adextra.handler.StoryFeedHandler$Response$$serializer A[REMOVE]) =  kntr.app.ad.domain.adextra.handler.StoryFeedHandler$Response$$serializer.INSTANCE kntr.app.ad.domain.adextra.handler.StoryFeedHandler$Response$$serializer)
                              (49 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.ad.domain.adextra.handler.StoryFeedHandler$Response$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.ad.domain.adextra.handler.StoryFeedHandler$Response$$serializer
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
                            kntr.app.ad.domain.adextra.handler.StoryFeedHandler$Response$$serializer r0 = kntr.app.ad.domain.adextra.handler.StoryFeedHandler$Response$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.ad.domain.adextra.handler.StoryFeedHandler.Response.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ Response(int seen0, int seen1, String networkV2, String network, String operatorType, String vendor, String model, String ua, String uaSys, String mobiApp, String osV, Integer build, String screenSize, String bootMark, String updateMark, String userApps, String dnsClientIp, String opensdkVer, String lng, String lat, String lbsTs, String storyShownIds, String apName, String apMac, String isKntr, String imei, String mac, String androidid, String oaid, String gameId, String disk, String hardwareModel, String initialTime, String idfa, String language, String machine, String memory, String bootTimeInSec, String carrierInfo, String countryCode, String deviceName, String sysFileTime, String systemVersion, String timeZone, String caid, String natureAd, String creativeId, String trackId, String requestId, String fromSpmid, String adStoryExtra, SerializationConstructorMarker serializationConstructorMarker) {
                    super(seen0, seen1, networkV2, network, operatorType, vendor, model, ua, uaSys, mobiApp, osV, build, screenSize, bootMark, updateMark, userApps, dnsClientIp, opensdkVer, lng, lat, lbsTs, storyShownIds, apName, apMac, isKntr, imei, mac, androidid, oaid, gameId, disk, hardwareModel, initialTime, idfa, language, machine, memory, bootTimeInSec, carrierInfo, countryCode, deviceName, sysFileTime, systemVersion, timeZone, serializationConstructorMarker);
                    Response response;
                    if ((seen1 & 1024) == 0) {
                        response = this;
                        response.caid = null;
                    } else {
                        response = this;
                        response.caid = caid;
                    }
                    if ((seen1 & 2048) == 0) {
                        response.natureAd = null;
                    } else {
                        response.natureAd = natureAd;
                    }
                    if ((seen1 & 4096) == 0) {
                        response.creativeId = null;
                    } else {
                        response.creativeId = creativeId;
                    }
                    if ((seen1 & 8192) == 0) {
                        response.trackId = null;
                    } else {
                        response.trackId = trackId;
                    }
                    if ((seen1 & 16384) == 0) {
                        response.requestId = null;
                    } else {
                        response.requestId = requestId;
                    }
                    if ((32768 & seen1) == 0) {
                        response.fromSpmid = null;
                    } else {
                        response.fromSpmid = fromSpmid;
                    }
                    if ((65536 & seen1) == 0) {
                        response.adStoryExtra = null;
                    } else {
                        response.adStoryExtra = adStoryExtra;
                    }
                }

                public Response(String caid, String natureAd, String creativeId, String trackId, String requestId, String fromSpmid, String adStoryExtra) {
                    this.caid = caid;
                    this.natureAd = natureAd;
                    this.creativeId = creativeId;
                    this.trackId = trackId;
                    this.requestId = requestId;
                    this.fromSpmid = fromSpmid;
                    this.adStoryExtra = adStoryExtra;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$adextra_debug(Response self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    DefaultHandler.Response.write$Self(self, output, serialDesc);
                    if (output.shouldEncodeElementDefault(serialDesc, 42) || self.caid != null) {
                        output.encodeNullableSerializableElement(serialDesc, 42, StringSerializer.INSTANCE, self.caid);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 43) || self.natureAd != null) {
                        output.encodeNullableSerializableElement(serialDesc, 43, StringSerializer.INSTANCE, self.natureAd);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 44) || self.creativeId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 44, StringSerializer.INSTANCE, self.creativeId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 45) || self.trackId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 45, StringSerializer.INSTANCE, self.trackId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 46) || self.requestId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 46, StringSerializer.INSTANCE, self.requestId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 47) || self.fromSpmid != null) {
                        output.encodeNullableSerializableElement(serialDesc, 47, StringSerializer.INSTANCE, self.fromSpmid);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 48) || self.adStoryExtra != null) {
                        output.encodeNullableSerializableElement(serialDesc, 48, StringSerializer.INSTANCE, self.adStoryExtra);
                    }
                }

                public /* synthetic */ Response(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7);
                }

                public final String getCaid() {
                    return this.caid;
                }

                public final String getNatureAd() {
                    return this.natureAd;
                }

                public final String getCreativeId() {
                    return this.creativeId;
                }

                public final String getTrackId() {
                    return this.trackId;
                }

                public final String getRequestId() {
                    return this.requestId;
                }

                public final String getFromSpmid() {
                    return this.fromSpmid;
                }

                public final String getAdStoryExtra() {
                    return this.adStoryExtra;
                }
            }

            @Override // kntr.app.ad.domain.adextra.handler.IAdExtraQueryHandler
            public String handle(AdExtraStoryFeedQuery query) {
                Intrinsics.checkNotNullParameter(query, "query");
                String it = query.getCaid();
                String str = (it == null || StringsKt.isBlank(it)) ? null : it;
                String it2 = query.getNatureAd();
                String str2 = (it2 == null || StringsKt.isBlank(it2)) ? null : it2;
                String it3 = query.getCreativeId();
                String str3 = (it3 == null || StringsKt.isBlank(it3)) ? null : it3;
                String it4 = query.getTrackId();
                String str4 = (it4 == null || StringsKt.isBlank(it4)) ? null : it4;
                String it5 = query.getRequestId();
                String str5 = (it5 == null || StringsKt.isBlank(it5)) ? null : it5;
                String fromSpmid = query.getFromSpmid();
                String it6 = query.getAdStoryExtra();
                Response it7 = new Response(str, str2, str3, str4, str5, fromSpmid, (it6 == null || StringsKt.isBlank(it6)) ? null : it6);
                StringFormat $this$encodeToString$iv = JsonExtKt.getAdJson();
                $this$encodeToString$iv.getSerializersModule();
                return $this$encodeToString$iv.encodeToString(Response.Companion.serializer(), it7);
            }
        }