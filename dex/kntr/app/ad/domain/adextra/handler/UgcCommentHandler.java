package kntr.app.ad.domain.adextra.handler;

import kntr.app.ad.common.utils.JsonExtKt;
import kntr.app.ad.domain.adextra.AdExtraUtilKt;
import kntr.app.ad.domain.adextra.handler.DefaultHandler;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.ad.protocol.adextra.AdExtraUgcCommentQuery;
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
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonObject;

/* compiled from: UgcCommentHandler.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/UgcCommentHandler;", "Lkntr/app/ad/domain/adextra/handler/IAdExtraQueryHandler;", "Lkntr/app/ad/protocol/adextra/AdExtraUgcCommentQuery;", "<init>", "()V", "handle", RoomRecommendViewModel.EMPTY_CURSOR, "query", "Response", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UgcCommentHandler implements IAdExtraQueryHandler<AdExtraUgcCommentQuery> {

    /* compiled from: UgcCommentHandler.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0081\b\u0018\u0000 a2\u00020\u0001:\u0004^_`aB[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rB\u008d\u0004\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0003\u0012\b\u00100\u001a\u0004\u0018\u00010\u0003\u0012\b\u00101\u001a\u0004\u0018\u00010\u0003\u0012\b\u00102\u001a\u0004\u0018\u00010\u0003\u0012\b\u00103\u001a\u0004\u0018\u00010\u0003\u0012\b\u00104\u001a\u0004\u0018\u00010\u0003\u0012\b\u00105\u001a\u0004\u0018\u00010\u0003\u0012\b\u00106\u001a\u0004\u0018\u00010\u0003\u0012\b\u00107\u001a\u0004\u0018\u00010\u0003\u0012\b\u00108\u001a\u0004\u0018\u00010\u0003\u0012\b\u00109\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010;\u001a\u0004\u0018\u00010<¢\u0006\u0004\b\f\u0010=J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u000bHÆ\u0003J]\u0010O\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010SHÖ\u0003J\t\u0010T\u001a\u00020\u000fHÖ\u0001J\t\u0010U\u001a\u00020\u0003HÖ\u0001J%\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\H\u0001¢\u0006\u0002\b]R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010?R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010?R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010?R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010?R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bF\u0010G¨\u0006b"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/UgcCommentHandler$Response;", "Lkntr/app/ad/domain/adextra/handler/DefaultHandler$Response;", "caid", RoomRecommendViewModel.EMPTY_CURSOR, "aiFromTrackId", "aiTrackId", "natureAd", "ocpxTargetType", "commentReq", "Lkntr/app/ad/domain/adextra/handler/UgcCommentHandler$Response$CommentReq;", "tab3Req", "Lkntr/app/ad/domain/adextra/handler/UgcCommentHandler$Response$Tab3Req;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/domain/adextra/handler/UgcCommentHandler$Response$CommentReq;Lkntr/app/ad/domain/adextra/handler/UgcCommentHandler$Response$Tab3Req;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "seen1", "networkV2", ReportBuildInParam.NETWORK, "operatorType", ReportBuildInParam.VENDOR, ReportBuildInParam.MODEL, ReportBuildInParam.UA, "uaSys", "mobiApp", "osV", ReportBuildInParam.BUILD, "screenSize", "bootMark", "updateMark", "userApps", "dnsClientIp", "opensdkVer", ReportBuildInParam.LNG, ReportBuildInParam.LAT, "lbsTs", "storyShownIds", "apName", "apMac", "isKntr", ReportBuildInParam.IMEI, ReportBuildInParam.MAC, ReportBuildInParam.ANDROID_ID, ReportBuildInParam.OAID, "gameId", ReportBuildInParam.DISK, "hardwareModel", "initialTime", ReportBuildInParam.IDFA, ReportBuildInParam.LANGUAGE, ReportBuildInParam.MACHINE, ReportBuildInParam.MEMORY, ReportBuildInParam.BOOT_TIME_IN_SEC, "carrierInfo", ReportBuildInParam.COUNTRY_CODE, ReportBuildInParam.DEVICE_NAME, ReportBuildInParam.SYS_FILE_TIME, "systemVersion", ReportBuildInParam.TIME_ZONE, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/domain/adextra/handler/UgcCommentHandler$Response$CommentReq;Lkntr/app/ad/domain/adextra/handler/UgcCommentHandler$Response$Tab3Req;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCaid", "()Ljava/lang/String;", "getAiFromTrackId", "getAiTrackId", "getNatureAd", "getOcpxTargetType", "getCommentReq", "()Lkntr/app/ad/domain/adextra/handler/UgcCommentHandler$Response$CommentReq;", "getTab3Req", "()Lkntr/app/ad/domain/adextra/handler/UgcCommentHandler$Response$Tab3Req;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adextra_debug", "CommentReq", "Tab3Req", "$serializer", "Companion", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Response extends DefaultHandler.Response {
        public static final Companion Companion = new Companion(null);
        private final String aiFromTrackId;
        private final String aiTrackId;
        private final String caid;
        private final CommentReq commentReq;
        private final String natureAd;
        private final String ocpxTargetType;
        private final Tab3Req tab3Req;

        public Response() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public static /* synthetic */ Response copy$default(Response response, String str, String str2, String str3, String str4, String str5, CommentReq commentReq, Tab3Req tab3Req, int i, Object obj) {
            if ((i & 1) != 0) {
                str = response.caid;
            }
            if ((i & 2) != 0) {
                str2 = response.aiFromTrackId;
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                str3 = response.aiTrackId;
            }
            String str7 = str3;
            if ((i & 8) != 0) {
                str4 = response.natureAd;
            }
            String str8 = str4;
            if ((i & 16) != 0) {
                str5 = response.ocpxTargetType;
            }
            String str9 = str5;
            if ((i & 32) != 0) {
                commentReq = response.commentReq;
            }
            CommentReq commentReq2 = commentReq;
            if ((i & 64) != 0) {
                tab3Req = response.tab3Req;
            }
            return response.copy(str, str6, str7, str8, str9, commentReq2, tab3Req);
        }

        public final String component1() {
            return this.caid;
        }

        public final String component2() {
            return this.aiFromTrackId;
        }

        public final String component3() {
            return this.aiTrackId;
        }

        public final String component4() {
            return this.natureAd;
        }

        public final String component5() {
            return this.ocpxTargetType;
        }

        public final CommentReq component6() {
            return this.commentReq;
        }

        public final Tab3Req component7() {
            return this.tab3Req;
        }

        public final Response copy(String str, String str2, String str3, String str4, String str5, CommentReq commentReq, Tab3Req tab3Req) {
            return new Response(str, str2, str3, str4, str5, commentReq, tab3Req);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Response) {
                Response response = (Response) obj;
                return Intrinsics.areEqual(this.caid, response.caid) && Intrinsics.areEqual(this.aiFromTrackId, response.aiFromTrackId) && Intrinsics.areEqual(this.aiTrackId, response.aiTrackId) && Intrinsics.areEqual(this.natureAd, response.natureAd) && Intrinsics.areEqual(this.ocpxTargetType, response.ocpxTargetType) && Intrinsics.areEqual(this.commentReq, response.commentReq) && Intrinsics.areEqual(this.tab3Req, response.tab3Req);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((this.caid == null ? 0 : this.caid.hashCode()) * 31) + (this.aiFromTrackId == null ? 0 : this.aiFromTrackId.hashCode())) * 31) + (this.aiTrackId == null ? 0 : this.aiTrackId.hashCode())) * 31) + (this.natureAd == null ? 0 : this.natureAd.hashCode())) * 31) + (this.ocpxTargetType == null ? 0 : this.ocpxTargetType.hashCode())) * 31) + (this.commentReq == null ? 0 : this.commentReq.hashCode())) * 31) + (this.tab3Req != null ? this.tab3Req.hashCode() : 0);
        }

        public String toString() {
            String str = this.caid;
            String str2 = this.aiFromTrackId;
            String str3 = this.aiTrackId;
            String str4 = this.natureAd;
            String str5 = this.ocpxTargetType;
            CommentReq commentReq = this.commentReq;
            return "Response(caid=" + str + ", aiFromTrackId=" + str2 + ", aiTrackId=" + str3 + ", natureAd=" + str4 + ", ocpxTargetType=" + str5 + ", commentReq=" + commentReq + ", tab3Req=" + this.tab3Req + ")";
        }

        /* compiled from: UgcCommentHandler.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/UgcCommentHandler$Response$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/domain/adextra/handler/UgcCommentHandler$Response;", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Response> serializer() {
                return new GeneratedSerializer<Response>() { // from class: kntr.app.ad.domain.adextra.handler.UgcCommentHandler$Response$$serializer
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.domain.adextra.handler.UgcCommentHandler.Response", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.ad.domain.adextra.handler.UgcCommentHandler$Response> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.ad.domain.adextra.handler.UgcCommentHandler$Response> A[REMOVE]) =  kntr.app.ad.domain.adextra.handler.UgcCommentHandler$Response$$serializer.INSTANCE kntr.app.ad.domain.adextra.handler.UgcCommentHandler$Response$$serializer)
                             in method: kntr.app.ad.domain.adextra.handler.UgcCommentHandler.Response.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.ad.domain.adextra.handler.UgcCommentHandler$Response>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                              ("kntr.app.ad.domain.adextra.handler.UgcCommentHandler.Response")
                              (wrap: kntr.app.ad.domain.adextra.handler.UgcCommentHandler$Response$$serializer : 0x0009: SGET  (r1v0 kntr.app.ad.domain.adextra.handler.UgcCommentHandler$Response$$serializer A[REMOVE]) =  kntr.app.ad.domain.adextra.handler.UgcCommentHandler$Response$$serializer.INSTANCE kntr.app.ad.domain.adextra.handler.UgcCommentHandler$Response$$serializer)
                              (49 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.ad.domain.adextra.handler.UgcCommentHandler$Response$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.ad.domain.adextra.handler.UgcCommentHandler$Response$$serializer
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
                            kntr.app.ad.domain.adextra.handler.UgcCommentHandler$Response$$serializer r0 = kntr.app.ad.domain.adextra.handler.UgcCommentHandler$Response$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.ad.domain.adextra.handler.UgcCommentHandler.Response.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ Response(int seen0, int seen1, String networkV2, String network, String operatorType, String vendor, String model, String ua, String uaSys, String mobiApp, String osV, Integer build, String screenSize, String bootMark, String updateMark, String userApps, String dnsClientIp, String opensdkVer, String lng, String lat, String lbsTs, String storyShownIds, String apName, String apMac, String isKntr, String imei, String mac, String androidid, String oaid, String gameId, String disk, String hardwareModel, String initialTime, String idfa, String language, String machine, String memory, String bootTimeInSec, String carrierInfo, String countryCode, String deviceName, String sysFileTime, String systemVersion, String timeZone, String caid, String aiFromTrackId, String aiTrackId, String natureAd, String ocpxTargetType, CommentReq commentReq, Tab3Req tab3Req, SerializationConstructorMarker serializationConstructorMarker) {
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
                        response.aiFromTrackId = null;
                    } else {
                        response.aiFromTrackId = aiFromTrackId;
                    }
                    if ((seen1 & 4096) == 0) {
                        response.aiTrackId = null;
                    } else {
                        response.aiTrackId = aiTrackId;
                    }
                    if ((seen1 & 8192) == 0) {
                        response.natureAd = null;
                    } else {
                        response.natureAd = natureAd;
                    }
                    if ((seen1 & 16384) == 0) {
                        response.ocpxTargetType = null;
                    } else {
                        response.ocpxTargetType = ocpxTargetType;
                    }
                    if ((32768 & seen1) == 0) {
                        response.commentReq = null;
                    } else {
                        response.commentReq = commentReq;
                    }
                    if ((65536 & seen1) == 0) {
                        response.tab3Req = null;
                    } else {
                        response.tab3Req = tab3Req;
                    }
                }

                public Response(String caid, String aiFromTrackId, String aiTrackId, String natureAd, String ocpxTargetType, CommentReq commentReq, Tab3Req tab3Req) {
                    this.caid = caid;
                    this.aiFromTrackId = aiFromTrackId;
                    this.aiTrackId = aiTrackId;
                    this.natureAd = natureAd;
                    this.ocpxTargetType = ocpxTargetType;
                    this.commentReq = commentReq;
                    this.tab3Req = tab3Req;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$adextra_debug(Response self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    DefaultHandler.Response.write$Self(self, output, serialDesc);
                    if (output.shouldEncodeElementDefault(serialDesc, 42) || self.caid != null) {
                        output.encodeNullableSerializableElement(serialDesc, 42, StringSerializer.INSTANCE, self.caid);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 43) || self.aiFromTrackId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 43, StringSerializer.INSTANCE, self.aiFromTrackId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 44) || self.aiTrackId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 44, StringSerializer.INSTANCE, self.aiTrackId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 45) || self.natureAd != null) {
                        output.encodeNullableSerializableElement(serialDesc, 45, StringSerializer.INSTANCE, self.natureAd);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 46) || self.ocpxTargetType != null) {
                        output.encodeNullableSerializableElement(serialDesc, 46, StringSerializer.INSTANCE, self.ocpxTargetType);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 47) || self.commentReq != null) {
                        output.encodeNullableSerializableElement(serialDesc, 47, UgcCommentHandler$Response$CommentReq$$serializer.INSTANCE, self.commentReq);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 48) || self.tab3Req != null) {
                        output.encodeNullableSerializableElement(serialDesc, 48, UgcCommentHandler$Response$Tab3Req$$serializer.INSTANCE, self.tab3Req);
                    }
                }

                public /* synthetic */ Response(String str, String str2, String str3, String str4, String str5, CommentReq commentReq, Tab3Req tab3Req, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : commentReq, (i & 64) != 0 ? null : tab3Req);
                }

                public final String getCaid() {
                    return this.caid;
                }

                public final String getAiFromTrackId() {
                    return this.aiFromTrackId;
                }

                public final String getAiTrackId() {
                    return this.aiTrackId;
                }

                public final String getNatureAd() {
                    return this.natureAd;
                }

                public final String getOcpxTargetType() {
                    return this.ocpxTargetType;
                }

                public final CommentReq getCommentReq() {
                    return this.commentReq;
                }

                /* compiled from: UgcCommentHandler.kt */
                @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 B2\u00020\u0001:\u0002ABB\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011B\u0093\u0001\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0010\u0010\u0016J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009e\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0013HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001J%\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0001¢\u0006\u0002\b@R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001f\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018¨\u0006C"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/UgcCommentHandler$Response$CommentReq;", RoomRecommendViewModel.EMPTY_CURSOR, "ocpxTargetType", RoomRecommendViewModel.EMPTY_CURSOR, "linkedCreativeId", RoomRecommendViewModel.EMPTY_CURSOR, "trackId", "sourceId", "requestId", "resourceId", "fromTrackId", "titleEncode", "titleMaterialId", "imageMaterialId", "tabClickFrom", "cardAdStyle", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOcpxTargetType", "()Ljava/lang/String;", "getLinkedCreativeId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTrackId", "getSourceId", "getRequestId", "getResourceId", "getFromTrackId", "getTitleEncode", "getTitleMaterialId", "getImageMaterialId", "getTabClickFrom", "getCardAdStyle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/ad/domain/adextra/handler/UgcCommentHandler$Response$CommentReq;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adextra_debug", "$serializer", "Companion", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                @Serializable
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class CommentReq {
                    public static final Companion Companion = new Companion(null);
                    private final String cardAdStyle;
                    private final String fromTrackId;
                    private final String imageMaterialId;
                    private final Long linkedCreativeId;
                    private final String ocpxTargetType;
                    private final String requestId;
                    private final Long resourceId;
                    private final Long sourceId;
                    private final String tabClickFrom;
                    private final String titleEncode;
                    private final String titleMaterialId;
                    private final String trackId;

                    public CommentReq() {
                        this((String) null, (Long) null, (String) null, (Long) null, (String) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 4095, (DefaultConstructorMarker) null);
                    }

                    public final String component1() {
                        return this.ocpxTargetType;
                    }

                    public final String component10() {
                        return this.imageMaterialId;
                    }

                    public final String component11() {
                        return this.tabClickFrom;
                    }

                    public final String component12() {
                        return this.cardAdStyle;
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

                    public final Long component6() {
                        return this.resourceId;
                    }

                    public final String component7() {
                        return this.fromTrackId;
                    }

                    public final String component8() {
                        return this.titleEncode;
                    }

                    public final String component9() {
                        return this.titleMaterialId;
                    }

                    public final CommentReq copy(String str, Long l, String str2, Long l2, String str3, Long l3, String str4, String str5, String str6, String str7, String str8, String str9) {
                        return new CommentReq(str, l, str2, l2, str3, l3, str4, str5, str6, str7, str8, str9);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof CommentReq) {
                            CommentReq commentReq = (CommentReq) obj;
                            return Intrinsics.areEqual(this.ocpxTargetType, commentReq.ocpxTargetType) && Intrinsics.areEqual(this.linkedCreativeId, commentReq.linkedCreativeId) && Intrinsics.areEqual(this.trackId, commentReq.trackId) && Intrinsics.areEqual(this.sourceId, commentReq.sourceId) && Intrinsics.areEqual(this.requestId, commentReq.requestId) && Intrinsics.areEqual(this.resourceId, commentReq.resourceId) && Intrinsics.areEqual(this.fromTrackId, commentReq.fromTrackId) && Intrinsics.areEqual(this.titleEncode, commentReq.titleEncode) && Intrinsics.areEqual(this.titleMaterialId, commentReq.titleMaterialId) && Intrinsics.areEqual(this.imageMaterialId, commentReq.imageMaterialId) && Intrinsics.areEqual(this.tabClickFrom, commentReq.tabClickFrom) && Intrinsics.areEqual(this.cardAdStyle, commentReq.cardAdStyle);
                        }
                        return false;
                    }

                    public int hashCode() {
                        return ((((((((((((((((((((((this.ocpxTargetType == null ? 0 : this.ocpxTargetType.hashCode()) * 31) + (this.linkedCreativeId == null ? 0 : this.linkedCreativeId.hashCode())) * 31) + (this.trackId == null ? 0 : this.trackId.hashCode())) * 31) + (this.sourceId == null ? 0 : this.sourceId.hashCode())) * 31) + (this.requestId == null ? 0 : this.requestId.hashCode())) * 31) + (this.resourceId == null ? 0 : this.resourceId.hashCode())) * 31) + (this.fromTrackId == null ? 0 : this.fromTrackId.hashCode())) * 31) + (this.titleEncode == null ? 0 : this.titleEncode.hashCode())) * 31) + (this.titleMaterialId == null ? 0 : this.titleMaterialId.hashCode())) * 31) + (this.imageMaterialId == null ? 0 : this.imageMaterialId.hashCode())) * 31) + (this.tabClickFrom == null ? 0 : this.tabClickFrom.hashCode())) * 31) + (this.cardAdStyle != null ? this.cardAdStyle.hashCode() : 0);
                    }

                    public String toString() {
                        String str = this.ocpxTargetType;
                        Long l = this.linkedCreativeId;
                        String str2 = this.trackId;
                        Long l2 = this.sourceId;
                        String str3 = this.requestId;
                        Long l3 = this.resourceId;
                        String str4 = this.fromTrackId;
                        String str5 = this.titleEncode;
                        String str6 = this.titleMaterialId;
                        String str7 = this.imageMaterialId;
                        String str8 = this.tabClickFrom;
                        return "CommentReq(ocpxTargetType=" + str + ", linkedCreativeId=" + l + ", trackId=" + str2 + ", sourceId=" + l2 + ", requestId=" + str3 + ", resourceId=" + l3 + ", fromTrackId=" + str4 + ", titleEncode=" + str5 + ", titleMaterialId=" + str6 + ", imageMaterialId=" + str7 + ", tabClickFrom=" + str8 + ", cardAdStyle=" + this.cardAdStyle + ")";
                    }

                    /* compiled from: UgcCommentHandler.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/UgcCommentHandler$Response$CommentReq$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/domain/adextra/handler/UgcCommentHandler$Response$CommentReq;", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<CommentReq> serializer() {
                            return UgcCommentHandler$Response$CommentReq$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ CommentReq(int seen0, String ocpxTargetType, Long linkedCreativeId, String trackId, Long sourceId, String requestId, Long resourceId, String fromTrackId, String titleEncode, String titleMaterialId, String imageMaterialId, String tabClickFrom, String cardAdStyle, SerializationConstructorMarker serializationConstructorMarker) {
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
                        if ((seen0 & 32) == 0) {
                            this.resourceId = null;
                        } else {
                            this.resourceId = resourceId;
                        }
                        if ((seen0 & 64) == 0) {
                            this.fromTrackId = null;
                        } else {
                            this.fromTrackId = fromTrackId;
                        }
                        if ((seen0 & 128) == 0) {
                            this.titleEncode = null;
                        } else {
                            this.titleEncode = titleEncode;
                        }
                        if ((seen0 & 256) == 0) {
                            this.titleMaterialId = null;
                        } else {
                            this.titleMaterialId = titleMaterialId;
                        }
                        if ((seen0 & 512) == 0) {
                            this.imageMaterialId = null;
                        } else {
                            this.imageMaterialId = imageMaterialId;
                        }
                        if ((seen0 & 1024) == 0) {
                            this.tabClickFrom = null;
                        } else {
                            this.tabClickFrom = tabClickFrom;
                        }
                        if ((seen0 & 2048) == 0) {
                            this.cardAdStyle = null;
                        } else {
                            this.cardAdStyle = cardAdStyle;
                        }
                    }

                    public CommentReq(String ocpxTargetType, Long linkedCreativeId, String trackId, Long sourceId, String requestId, Long resourceId, String fromTrackId, String titleEncode, String titleMaterialId, String imageMaterialId, String tabClickFrom, String cardAdStyle) {
                        this.ocpxTargetType = ocpxTargetType;
                        this.linkedCreativeId = linkedCreativeId;
                        this.trackId = trackId;
                        this.sourceId = sourceId;
                        this.requestId = requestId;
                        this.resourceId = resourceId;
                        this.fromTrackId = fromTrackId;
                        this.titleEncode = titleEncode;
                        this.titleMaterialId = titleMaterialId;
                        this.imageMaterialId = imageMaterialId;
                        this.tabClickFrom = tabClickFrom;
                        this.cardAdStyle = cardAdStyle;
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
                        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.resourceId != null) {
                            output.encodeNullableSerializableElement(serialDesc, 5, LongSerializer.INSTANCE, self.resourceId);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.fromTrackId != null) {
                            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.fromTrackId);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.titleEncode != null) {
                            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.titleEncode);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.titleMaterialId != null) {
                            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.titleMaterialId);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.imageMaterialId != null) {
                            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.imageMaterialId);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.tabClickFrom != null) {
                            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.tabClickFrom);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.cardAdStyle != null) {
                            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.cardAdStyle);
                        }
                    }

                    public /* synthetic */ CommentReq(String str, Long l, String str2, Long l2, String str3, Long l3, String str4, String str5, String str6, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : l2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : l3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : str6, (i & 512) != 0 ? null : str7, (i & 1024) != 0 ? null : str8, (i & 2048) == 0 ? str9 : null);
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

                    public final Long getResourceId() {
                        return this.resourceId;
                    }

                    public final String getFromTrackId() {
                        return this.fromTrackId;
                    }

                    public final String getTitleEncode() {
                        return this.titleEncode;
                    }

                    public final String getTitleMaterialId() {
                        return this.titleMaterialId;
                    }

                    public final String getImageMaterialId() {
                        return this.imageMaterialId;
                    }

                    public final String getTabClickFrom() {
                        return this.tabClickFrom;
                    }

                    public final String getCardAdStyle() {
                        return this.cardAdStyle;
                    }
                }

                public final Tab3Req getTab3Req() {
                    return this.tab3Req;
                }

                /* compiled from: UgcCommentHandler.kt */
                @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J>\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\fHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006-"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/UgcCommentHandler$Response$Tab3Req;", RoomRecommendViewModel.EMPTY_CURSOR, "trackId", RoomRecommendViewModel.EMPTY_CURSOR, "fromSpmid", "extraParams", "Lkotlinx/serialization/json/JsonElement;", "sourceId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/Long;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTrackId", "()Ljava/lang/String;", "getFromSpmid", "getExtraParams", "()Lkotlinx/serialization/json/JsonElement;", "getSourceId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/Long;)Lkntr/app/ad/domain/adextra/handler/UgcCommentHandler$Response$Tab3Req;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adextra_debug", "$serializer", "Companion", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                @Serializable
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class Tab3Req {
                    public static final Companion Companion = new Companion(null);
                    private final JsonElement extraParams;
                    private final String fromSpmid;
                    private final Long sourceId;
                    private final String trackId;

                    public Tab3Req() {
                        this((String) null, (String) null, (JsonElement) null, (Long) null, 15, (DefaultConstructorMarker) null);
                    }

                    public static /* synthetic */ Tab3Req copy$default(Tab3Req tab3Req, String str, String str2, JsonElement jsonElement, Long l, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = tab3Req.trackId;
                        }
                        if ((i & 2) != 0) {
                            str2 = tab3Req.fromSpmid;
                        }
                        if ((i & 4) != 0) {
                            jsonElement = tab3Req.extraParams;
                        }
                        if ((i & 8) != 0) {
                            l = tab3Req.sourceId;
                        }
                        return tab3Req.copy(str, str2, jsonElement, l);
                    }

                    public final String component1() {
                        return this.trackId;
                    }

                    public final String component2() {
                        return this.fromSpmid;
                    }

                    public final JsonElement component3() {
                        return this.extraParams;
                    }

                    public final Long component4() {
                        return this.sourceId;
                    }

                    public final Tab3Req copy(String str, String str2, JsonElement jsonElement, Long l) {
                        return new Tab3Req(str, str2, jsonElement, l);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof Tab3Req) {
                            Tab3Req tab3Req = (Tab3Req) obj;
                            return Intrinsics.areEqual(this.trackId, tab3Req.trackId) && Intrinsics.areEqual(this.fromSpmid, tab3Req.fromSpmid) && Intrinsics.areEqual(this.extraParams, tab3Req.extraParams) && Intrinsics.areEqual(this.sourceId, tab3Req.sourceId);
                        }
                        return false;
                    }

                    public int hashCode() {
                        return ((((((this.trackId == null ? 0 : this.trackId.hashCode()) * 31) + (this.fromSpmid == null ? 0 : this.fromSpmid.hashCode())) * 31) + (this.extraParams == null ? 0 : this.extraParams.hashCode())) * 31) + (this.sourceId != null ? this.sourceId.hashCode() : 0);
                    }

                    public String toString() {
                        String str = this.trackId;
                        String str2 = this.fromSpmid;
                        JsonElement jsonElement = this.extraParams;
                        return "Tab3Req(trackId=" + str + ", fromSpmid=" + str2 + ", extraParams=" + jsonElement + ", sourceId=" + this.sourceId + ")";
                    }

                    /* compiled from: UgcCommentHandler.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/UgcCommentHandler$Response$Tab3Req$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/domain/adextra/handler/UgcCommentHandler$Response$Tab3Req;", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<Tab3Req> serializer() {
                            return UgcCommentHandler$Response$Tab3Req$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ Tab3Req(int seen0, String trackId, String fromSpmid, JsonElement extraParams, Long sourceId, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((seen0 & 1) == 0) {
                            this.trackId = null;
                        } else {
                            this.trackId = trackId;
                        }
                        if ((seen0 & 2) == 0) {
                            this.fromSpmid = null;
                        } else {
                            this.fromSpmid = fromSpmid;
                        }
                        if ((seen0 & 4) == 0) {
                            this.extraParams = null;
                        } else {
                            this.extraParams = extraParams;
                        }
                        if ((seen0 & 8) == 0) {
                            this.sourceId = null;
                        } else {
                            this.sourceId = sourceId;
                        }
                    }

                    public Tab3Req(String trackId, String fromSpmid, JsonElement extraParams, Long sourceId) {
                        this.trackId = trackId;
                        this.fromSpmid = fromSpmid;
                        this.extraParams = extraParams;
                        this.sourceId = sourceId;
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$adextra_debug(Tab3Req self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.trackId != null) {
                            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.trackId);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.fromSpmid != null) {
                            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.fromSpmid);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.extraParams != null) {
                            output.encodeNullableSerializableElement(serialDesc, 2, JsonElementSerializer.INSTANCE, self.extraParams);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.sourceId != null) {
                            output.encodeNullableSerializableElement(serialDesc, 3, LongSerializer.INSTANCE, self.sourceId);
                        }
                    }

                    public /* synthetic */ Tab3Req(String str, String str2, JsonElement jsonElement, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : jsonElement, (i & 8) != 0 ? null : l);
                    }

                    public final String getTrackId() {
                        return this.trackId;
                    }

                    public final String getFromSpmid() {
                        return this.fromSpmid;
                    }

                    public final JsonElement getExtraParams() {
                        return this.extraParams;
                    }

                    public final Long getSourceId() {
                        return this.sourceId;
                    }
                }
            }

            @Override // kntr.app.ad.domain.adextra.handler.IAdExtraQueryHandler
            public String handle(AdExtraUgcCommentQuery query) {
                Long longOrNull;
                Long linkedCreativeId;
                Long resourceId;
                Long longOrNull2;
                Intrinsics.checkNotNullParameter(query, "query");
                String ocpxTargetType = null;
                Response.CommentReq commentReq = null;
                Response.Tab3Req tab3Req = null;
                Long linkedCreativeId2 = query.getLinkedCreativeId();
                String str = RoomRecommendViewModel.EMPTY_CURSOR;
                String str2 = null;
                if (linkedCreativeId2 != null && ((linkedCreativeId = query.getLinkedCreativeId()) == null || linkedCreativeId.longValue() != 0)) {
                    ocpxTargetType = query.getOcpxTargetType();
                    String ocpxTargetType2 = query.getOcpxTargetType();
                    String valueOf = (ocpxTargetType2 == null || (longOrNull2 = StringsKt.toLongOrNull(ocpxTargetType2)) == null) ? null : String.valueOf(longOrNull2.longValue());
                    Long linkedCreativeId3 = query.getLinkedCreativeId();
                    Long valueOf2 = Long.valueOf(linkedCreativeId3 != null ? linkedCreativeId3.longValue() : 0L);
                    String trackId = query.getTrackId();
                    String str3 = trackId == null ? RoomRecommendViewModel.EMPTY_CURSOR : trackId;
                    Long sourceId = query.getSourceId();
                    Long valueOf3 = Long.valueOf(sourceId != null ? sourceId.longValue() : 0L);
                    AdExtraUgcCommentQuery.CommentQuery commentQuery = query.getCommentQuery();
                    String requestId = commentQuery != null ? commentQuery.getRequestId() : null;
                    String str4 = requestId == null ? RoomRecommendViewModel.EMPTY_CURSOR : requestId;
                    AdExtraUgcCommentQuery.CommentQuery commentQuery2 = query.getCommentQuery();
                    Long valueOf4 = Long.valueOf((commentQuery2 == null || (resourceId = commentQuery2.getResourceId()) == null) ? 0L : resourceId.longValue());
                    AdExtraUgcCommentQuery.CommentQuery commentQuery3 = query.getCommentQuery();
                    String fromTrackId = commentQuery3 != null ? commentQuery3.getFromTrackId() : null;
                    AdExtraUgcCommentQuery.CommentQuery commentQuery4 = query.getCommentQuery();
                    String titleEncode = commentQuery4 != null ? commentQuery4.getTitleEncode() : null;
                    String str5 = titleEncode == null ? RoomRecommendViewModel.EMPTY_CURSOR : titleEncode;
                    AdExtraUgcCommentQuery.CommentQuery commentQuery5 = query.getCommentQuery();
                    String titleMaterialId = commentQuery5 != null ? commentQuery5.getTitleMaterialId() : null;
                    String str6 = titleMaterialId == null ? RoomRecommendViewModel.EMPTY_CURSOR : titleMaterialId;
                    AdExtraUgcCommentQuery.CommentQuery commentQuery6 = query.getCommentQuery();
                    String imageMaterialId = commentQuery6 != null ? commentQuery6.getImageMaterialId() : null;
                    String str7 = imageMaterialId == null ? RoomRecommendViewModel.EMPTY_CURSOR : imageMaterialId;
                    AdExtraUgcCommentQuery.CommentQuery commentQuery7 = query.getCommentQuery();
                    String tabClickFrom = commentQuery7 != null ? commentQuery7.getTabClickFrom() : null;
                    String str8 = tabClickFrom == null ? RoomRecommendViewModel.EMPTY_CURSOR : tabClickFrom;
                    AdExtraUgcCommentQuery.CommentQuery commentQuery8 = query.getCommentQuery();
                    String cardAdStyle = commentQuery8 != null ? commentQuery8.getCardAdStyle() : null;
                    commentReq = new Response.CommentReq(valueOf, valueOf2, str3, valueOf3, str4, valueOf4, fromTrackId, str5, str6, str7, str8, cardAdStyle == null ? RoomRecommendViewModel.EMPTY_CURSOR : cardAdStyle);
                }
                String bizExtra = query.getBizExtra();
                JsonObject bizExtraObject = bizExtra != null ? AdExtraUtilKt.getBizExtraObject(bizExtra) : null;
                boolean z = false;
                if (bizExtraObject != null && AdExtraUtilKt.getAdPlayPage(bizExtraObject) == 2) {
                    z = true;
                }
                if (z) {
                    String trackId2 = query.getTrackId();
                    if (trackId2 == null) {
                        trackId2 = RoomRecommendViewModel.EMPTY_CURSOR;
                    }
                    String fromSpmid = query.getFromSpmid();
                    if (fromSpmid != null) {
                        str = fromSpmid;
                    }
                    JsonElement extraParams = AdExtraUtilKt.getExtraParams(bizExtraObject);
                    Long sourceId2 = query.getSourceId();
                    tab3Req = new Response.Tab3Req(trackId2, str, extraParams, Long.valueOf(sourceId2 != null ? sourceId2.longValue() : 0L));
                }
                String caid = query.getCaid();
                String it = query.getAiFromTrackId();
                String str9 = (it == null || StringsKt.isBlank(it)) ? null : it;
                String it2 = query.getAiTrackId();
                String str10 = (it2 == null || StringsKt.isBlank(it2)) ? null : it2;
                String it3 = query.getNatureAd();
                String str11 = (it3 == null || StringsKt.isBlank(it3)) ? null : it3;
                if (ocpxTargetType != null && (longOrNull = StringsKt.toLongOrNull(ocpxTargetType)) != null) {
                    str2 = String.valueOf(longOrNull.longValue());
                }
                Response it4 = new Response(caid, str9, str10, str11, str2, commentReq, tab3Req);
                StringFormat $this$encodeToString$iv = JsonExtKt.getAdJson();
                $this$encodeToString$iv.getSerializersModule();
                return $this$encodeToString$iv.encodeToString(Response.Companion.serializer(), it4);
            }
        }