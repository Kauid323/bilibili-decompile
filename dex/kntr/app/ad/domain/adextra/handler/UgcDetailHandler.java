package kntr.app.ad.domain.adextra.handler;

import kntr.app.ad.common.utils.JsonExtKt;
import kntr.app.ad.domain.adextra.AdExtraUtilKt;
import kntr.app.ad.domain.adextra.handler.DefaultHandler;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.ad.protocol.adextra.AdExtraUgcDetailQuery;
import kntr.app.ad.protocol.adextra.AdViewQuery;
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

/* compiled from: UgcDetailHandler.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler;", "Lkntr/app/ad/domain/adextra/handler/IAdExtraQueryHandler;", "Lkntr/app/ad/protocol/adextra/AdExtraUgcDetailQuery;", "<init>", "()V", "handle", RoomRecommendViewModel.EMPTY_CURSOR, "query", "Response", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UgcDetailHandler implements IAdExtraQueryHandler<AdExtraUgcDetailQuery> {

    /* compiled from: UgcDetailHandler.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0081\b\u0018\u0000 k2\u00020\u0001:\u0005ghijkBg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010B\u0097\u0004\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0003\u0012\b\u00100\u001a\u0004\u0018\u00010\u0003\u0012\b\u00101\u001a\u0004\u0018\u00010\u0003\u0012\b\u00102\u001a\u0004\u0018\u00010\u0003\u0012\b\u00103\u001a\u0004\u0018\u00010\u0003\u0012\b\u00104\u001a\u0004\u0018\u00010\u0003\u0012\b\u00105\u001a\u0004\u0018\u00010\u0003\u0012\b\u00106\u001a\u0004\u0018\u00010\u0003\u0012\b\u00107\u001a\u0004\u0018\u00010\u0003\u0012\b\u00108\u001a\u0004\u0018\u00010\u0003\u0012\b\u00109\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010=\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010>\u001a\u0004\u0018\u00010?¢\u0006\u0004\b\u000f\u0010@J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010EJ\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jn\u0010W\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010XJ\u0013\u0010Y\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010\\HÖ\u0003J\t\u0010]\u001a\u00020\u0012HÖ\u0001J\t\u0010^\u001a\u00020\u0003HÖ\u0001J%\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00002\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020eH\u0001¢\u0006\u0002\bfR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010BR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010F\u001a\u0004\bD\u0010ER\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010BR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u0010BR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\bM\u0010N¨\u0006l"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response;", "Lkntr/app/ad/domain/adextra/handler/DefaultHandler$Response;", "caid", RoomRecommendViewModel.EMPTY_CURSOR, "ocpxTargetType", "linkedCreativeId", RoomRecommendViewModel.EMPTY_CURSOR, "trackId", "natureAd", "nativeReq", "Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$NativeReq;", "viewReq", "Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$ViewReq;", "tab3Req", "Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$Tab3Req;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$NativeReq;Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$ViewReq;Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$Tab3Req;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "seen1", "networkV2", ReportBuildInParam.NETWORK, "operatorType", ReportBuildInParam.VENDOR, ReportBuildInParam.MODEL, ReportBuildInParam.UA, "uaSys", "mobiApp", "osV", ReportBuildInParam.BUILD, "screenSize", "bootMark", "updateMark", "userApps", "dnsClientIp", "opensdkVer", ReportBuildInParam.LNG, ReportBuildInParam.LAT, "lbsTs", "storyShownIds", "apName", "apMac", "isKntr", ReportBuildInParam.IMEI, ReportBuildInParam.MAC, ReportBuildInParam.ANDROID_ID, ReportBuildInParam.OAID, "gameId", ReportBuildInParam.DISK, "hardwareModel", "initialTime", ReportBuildInParam.IDFA, ReportBuildInParam.LANGUAGE, ReportBuildInParam.MACHINE, ReportBuildInParam.MEMORY, ReportBuildInParam.BOOT_TIME_IN_SEC, "carrierInfo", ReportBuildInParam.COUNTRY_CODE, ReportBuildInParam.DEVICE_NAME, ReportBuildInParam.SYS_FILE_TIME, "systemVersion", ReportBuildInParam.TIME_ZONE, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$NativeReq;Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$ViewReq;Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$Tab3Req;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCaid", "()Ljava/lang/String;", "getOcpxTargetType", "getLinkedCreativeId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTrackId", "getNatureAd", "getNativeReq", "()Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$NativeReq;", "getViewReq", "()Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$ViewReq;", "getTab3Req", "()Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$Tab3Req;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$NativeReq;Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$ViewReq;Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$Tab3Req;)Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adextra_debug", "ViewReq", "Tab3Req", "NativeReq", "$serializer", "Companion", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Response extends DefaultHandler.Response {
        public static final Companion Companion = new Companion(null);
        private final String caid;
        private final Long linkedCreativeId;
        private final NativeReq nativeReq;
        private final String natureAd;
        private final String ocpxTargetType;
        private final Tab3Req tab3Req;
        private final String trackId;
        private final ViewReq viewReq;

        public Response() {
            this(null, null, null, null, null, null, null, null, 255, null);
        }

        public final String component1() {
            return this.caid;
        }

        public final String component2() {
            return this.ocpxTargetType;
        }

        public final Long component3() {
            return this.linkedCreativeId;
        }

        public final String component4() {
            return this.trackId;
        }

        public final String component5() {
            return this.natureAd;
        }

        public final NativeReq component6() {
            return this.nativeReq;
        }

        public final ViewReq component7() {
            return this.viewReq;
        }

        public final Tab3Req component8() {
            return this.tab3Req;
        }

        public final Response copy(String str, String str2, Long l, String str3, String str4, NativeReq nativeReq, ViewReq viewReq, Tab3Req tab3Req) {
            return new Response(str, str2, l, str3, str4, nativeReq, viewReq, tab3Req);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Response) {
                Response response = (Response) obj;
                return Intrinsics.areEqual(this.caid, response.caid) && Intrinsics.areEqual(this.ocpxTargetType, response.ocpxTargetType) && Intrinsics.areEqual(this.linkedCreativeId, response.linkedCreativeId) && Intrinsics.areEqual(this.trackId, response.trackId) && Intrinsics.areEqual(this.natureAd, response.natureAd) && Intrinsics.areEqual(this.nativeReq, response.nativeReq) && Intrinsics.areEqual(this.viewReq, response.viewReq) && Intrinsics.areEqual(this.tab3Req, response.tab3Req);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((this.caid == null ? 0 : this.caid.hashCode()) * 31) + (this.ocpxTargetType == null ? 0 : this.ocpxTargetType.hashCode())) * 31) + (this.linkedCreativeId == null ? 0 : this.linkedCreativeId.hashCode())) * 31) + (this.trackId == null ? 0 : this.trackId.hashCode())) * 31) + (this.natureAd == null ? 0 : this.natureAd.hashCode())) * 31) + (this.nativeReq == null ? 0 : this.nativeReq.hashCode())) * 31) + (this.viewReq == null ? 0 : this.viewReq.hashCode())) * 31) + (this.tab3Req != null ? this.tab3Req.hashCode() : 0);
        }

        public String toString() {
            String str = this.caid;
            String str2 = this.ocpxTargetType;
            Long l = this.linkedCreativeId;
            String str3 = this.trackId;
            String str4 = this.natureAd;
            NativeReq nativeReq = this.nativeReq;
            ViewReq viewReq = this.viewReq;
            return "Response(caid=" + str + ", ocpxTargetType=" + str2 + ", linkedCreativeId=" + l + ", trackId=" + str3 + ", natureAd=" + str4 + ", nativeReq=" + nativeReq + ", viewReq=" + viewReq + ", tab3Req=" + this.tab3Req + ")";
        }

        /* compiled from: UgcDetailHandler.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response;", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Response> serializer() {
                return new GeneratedSerializer<Response>() { // from class: kntr.app.ad.domain.adextra.handler.UgcDetailHandler$Response$$serializer
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.domain.adextra.handler.UgcDetailHandler.Response", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.ad.domain.adextra.handler.UgcDetailHandler$Response> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.ad.domain.adextra.handler.UgcDetailHandler$Response> A[REMOVE]) =  kntr.app.ad.domain.adextra.handler.UgcDetailHandler$Response$$serializer.INSTANCE kntr.app.ad.domain.adextra.handler.UgcDetailHandler$Response$$serializer)
                             in method: kntr.app.ad.domain.adextra.handler.UgcDetailHandler.Response.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.ad.domain.adextra.handler.UgcDetailHandler$Response>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                              ("kntr.app.ad.domain.adextra.handler.UgcDetailHandler.Response")
                              (wrap: kntr.app.ad.domain.adextra.handler.UgcDetailHandler$Response$$serializer : 0x0009: SGET  (r1v0 kntr.app.ad.domain.adextra.handler.UgcDetailHandler$Response$$serializer A[REMOVE]) =  kntr.app.ad.domain.adextra.handler.UgcDetailHandler$Response$$serializer.INSTANCE kntr.app.ad.domain.adextra.handler.UgcDetailHandler$Response$$serializer)
                              (50 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.ad.domain.adextra.handler.UgcDetailHandler$Response$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.ad.domain.adextra.handler.UgcDetailHandler$Response$$serializer
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
                            kntr.app.ad.domain.adextra.handler.UgcDetailHandler$Response$$serializer r0 = kntr.app.ad.domain.adextra.handler.UgcDetailHandler$Response$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.ad.domain.adextra.handler.UgcDetailHandler.Response.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ Response(int seen0, int seen1, String networkV2, String network, String operatorType, String vendor, String model, String ua, String uaSys, String mobiApp, String osV, Integer build, String screenSize, String bootMark, String updateMark, String userApps, String dnsClientIp, String opensdkVer, String lng, String lat, String lbsTs, String storyShownIds, String apName, String apMac, String isKntr, String imei, String mac, String androidid, String oaid, String gameId, String disk, String hardwareModel, String initialTime, String idfa, String language, String machine, String memory, String bootTimeInSec, String carrierInfo, String countryCode, String deviceName, String sysFileTime, String systemVersion, String timeZone, String caid, String ocpxTargetType, Long linkedCreativeId, String trackId, String natureAd, NativeReq nativeReq, ViewReq viewReq, Tab3Req tab3Req, SerializationConstructorMarker serializationConstructorMarker) {
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
                        response.ocpxTargetType = null;
                    } else {
                        response.ocpxTargetType = ocpxTargetType;
                    }
                    if ((seen1 & 4096) == 0) {
                        response.linkedCreativeId = null;
                    } else {
                        response.linkedCreativeId = linkedCreativeId;
                    }
                    if ((seen1 & 8192) == 0) {
                        response.trackId = null;
                    } else {
                        response.trackId = trackId;
                    }
                    if ((seen1 & 16384) == 0) {
                        response.natureAd = null;
                    } else {
                        response.natureAd = natureAd;
                    }
                    if ((32768 & seen1) == 0) {
                        response.nativeReq = null;
                    } else {
                        response.nativeReq = nativeReq;
                    }
                    if ((65536 & seen1) == 0) {
                        response.viewReq = null;
                    } else {
                        response.viewReq = viewReq;
                    }
                    if ((131072 & seen1) == 0) {
                        response.tab3Req = null;
                    } else {
                        response.tab3Req = tab3Req;
                    }
                }

                public Response(String caid, String ocpxTargetType, Long linkedCreativeId, String trackId, String natureAd, NativeReq nativeReq, ViewReq viewReq, Tab3Req tab3Req) {
                    this.caid = caid;
                    this.ocpxTargetType = ocpxTargetType;
                    this.linkedCreativeId = linkedCreativeId;
                    this.trackId = trackId;
                    this.natureAd = natureAd;
                    this.nativeReq = nativeReq;
                    this.viewReq = viewReq;
                    this.tab3Req = tab3Req;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$adextra_debug(Response self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    DefaultHandler.Response.write$Self(self, output, serialDesc);
                    if (output.shouldEncodeElementDefault(serialDesc, 42) || self.caid != null) {
                        output.encodeNullableSerializableElement(serialDesc, 42, StringSerializer.INSTANCE, self.caid);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 43) || self.ocpxTargetType != null) {
                        output.encodeNullableSerializableElement(serialDesc, 43, StringSerializer.INSTANCE, self.ocpxTargetType);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 44) || self.linkedCreativeId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 44, LongSerializer.INSTANCE, self.linkedCreativeId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 45) || self.trackId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 45, StringSerializer.INSTANCE, self.trackId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 46) || self.natureAd != null) {
                        output.encodeNullableSerializableElement(serialDesc, 46, StringSerializer.INSTANCE, self.natureAd);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 47) || self.nativeReq != null) {
                        output.encodeNullableSerializableElement(serialDesc, 47, UgcDetailHandler$Response$NativeReq$$serializer.INSTANCE, self.nativeReq);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 48) || self.viewReq != null) {
                        output.encodeNullableSerializableElement(serialDesc, 48, UgcDetailHandler$Response$ViewReq$$serializer.INSTANCE, self.viewReq);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 49) || self.tab3Req != null) {
                        output.encodeNullableSerializableElement(serialDesc, 49, UgcDetailHandler$Response$Tab3Req$$serializer.INSTANCE, self.tab3Req);
                    }
                }

                public /* synthetic */ Response(String str, String str2, Long l, String str3, String str4, NativeReq nativeReq, ViewReq viewReq, Tab3Req tab3Req, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : nativeReq, (i & 64) != 0 ? null : viewReq, (i & 128) == 0 ? tab3Req : null);
                }

                public final String getCaid() {
                    return this.caid;
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

                public final String getNatureAd() {
                    return this.natureAd;
                }

                public final NativeReq getNativeReq() {
                    return this.nativeReq;
                }

                public final ViewReq getViewReq() {
                    return this.viewReq;
                }

                /* compiled from: UgcDetailHandler.kt */
                @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 E2\u00020\u0001:\u0002DEB£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012B\u009d\u0001\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0011\u0010\u0017J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jª\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u0014HÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001J%\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00002\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0001¢\u0006\u0002\bCR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001e\u0010\u001bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b \u0010\u001bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019¨\u0006F"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$ViewReq;", RoomRecommendViewModel.EMPTY_CURSOR, "ocpxTargetType", RoomRecommendViewModel.EMPTY_CURSOR, "linkedCreativeId", RoomRecommendViewModel.EMPTY_CURSOR, "trackId", "sourceId", "requestId", "resourceId", "fromTrackId", "titleEncode", "titleMaterialId", "imageMaterialId", "tabClickFrom", "cardAdStyle", "cmBackhaulExtra", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOcpxTargetType", "()Ljava/lang/String;", "getLinkedCreativeId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTrackId", "getSourceId", "getRequestId", "getResourceId", "getFromTrackId", "getTitleEncode", "getTitleMaterialId", "getImageMaterialId", "getTabClickFrom", "getCardAdStyle", "getCmBackhaulExtra", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$ViewReq;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adextra_debug", "$serializer", "Companion", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                @Serializable
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class ViewReq {
                    public static final Companion Companion = new Companion(null);
                    private final String cardAdStyle;
                    private final String cmBackhaulExtra;
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

                    public ViewReq() {
                        this((String) null, (Long) null, (String) null, (Long) null, (String) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 8191, (DefaultConstructorMarker) null);
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

                    public final String component13() {
                        return this.cmBackhaulExtra;
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

                    public final ViewReq copy(String str, Long l, String str2, Long l2, String str3, Long l3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
                        return new ViewReq(str, l, str2, l2, str3, l3, str4, str5, str6, str7, str8, str9, str10);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof ViewReq) {
                            ViewReq viewReq = (ViewReq) obj;
                            return Intrinsics.areEqual(this.ocpxTargetType, viewReq.ocpxTargetType) && Intrinsics.areEqual(this.linkedCreativeId, viewReq.linkedCreativeId) && Intrinsics.areEqual(this.trackId, viewReq.trackId) && Intrinsics.areEqual(this.sourceId, viewReq.sourceId) && Intrinsics.areEqual(this.requestId, viewReq.requestId) && Intrinsics.areEqual(this.resourceId, viewReq.resourceId) && Intrinsics.areEqual(this.fromTrackId, viewReq.fromTrackId) && Intrinsics.areEqual(this.titleEncode, viewReq.titleEncode) && Intrinsics.areEqual(this.titleMaterialId, viewReq.titleMaterialId) && Intrinsics.areEqual(this.imageMaterialId, viewReq.imageMaterialId) && Intrinsics.areEqual(this.tabClickFrom, viewReq.tabClickFrom) && Intrinsics.areEqual(this.cardAdStyle, viewReq.cardAdStyle) && Intrinsics.areEqual(this.cmBackhaulExtra, viewReq.cmBackhaulExtra);
                        }
                        return false;
                    }

                    public int hashCode() {
                        return ((((((((((((((((((((((((this.ocpxTargetType == null ? 0 : this.ocpxTargetType.hashCode()) * 31) + (this.linkedCreativeId == null ? 0 : this.linkedCreativeId.hashCode())) * 31) + (this.trackId == null ? 0 : this.trackId.hashCode())) * 31) + (this.sourceId == null ? 0 : this.sourceId.hashCode())) * 31) + (this.requestId == null ? 0 : this.requestId.hashCode())) * 31) + (this.resourceId == null ? 0 : this.resourceId.hashCode())) * 31) + (this.fromTrackId == null ? 0 : this.fromTrackId.hashCode())) * 31) + (this.titleEncode == null ? 0 : this.titleEncode.hashCode())) * 31) + (this.titleMaterialId == null ? 0 : this.titleMaterialId.hashCode())) * 31) + (this.imageMaterialId == null ? 0 : this.imageMaterialId.hashCode())) * 31) + (this.tabClickFrom == null ? 0 : this.tabClickFrom.hashCode())) * 31) + (this.cardAdStyle == null ? 0 : this.cardAdStyle.hashCode())) * 31) + (this.cmBackhaulExtra != null ? this.cmBackhaulExtra.hashCode() : 0);
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
                        String str9 = this.cardAdStyle;
                        return "ViewReq(ocpxTargetType=" + str + ", linkedCreativeId=" + l + ", trackId=" + str2 + ", sourceId=" + l2 + ", requestId=" + str3 + ", resourceId=" + l3 + ", fromTrackId=" + str4 + ", titleEncode=" + str5 + ", titleMaterialId=" + str6 + ", imageMaterialId=" + str7 + ", tabClickFrom=" + str8 + ", cardAdStyle=" + str9 + ", cmBackhaulExtra=" + this.cmBackhaulExtra + ")";
                    }

                    /* compiled from: UgcDetailHandler.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$ViewReq$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$ViewReq;", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<ViewReq> serializer() {
                            return UgcDetailHandler$Response$ViewReq$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ ViewReq(int seen0, String ocpxTargetType, Long linkedCreativeId, String trackId, Long sourceId, String requestId, Long resourceId, String fromTrackId, String titleEncode, String titleMaterialId, String imageMaterialId, String tabClickFrom, String cardAdStyle, String cmBackhaulExtra, SerializationConstructorMarker serializationConstructorMarker) {
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
                        if ((seen0 & 4096) == 0) {
                            this.cmBackhaulExtra = null;
                        } else {
                            this.cmBackhaulExtra = cmBackhaulExtra;
                        }
                    }

                    public ViewReq(String ocpxTargetType, Long linkedCreativeId, String trackId, Long sourceId, String requestId, Long resourceId, String fromTrackId, String titleEncode, String titleMaterialId, String imageMaterialId, String tabClickFrom, String cardAdStyle, String cmBackhaulExtra) {
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
                        this.cmBackhaulExtra = cmBackhaulExtra;
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$adextra_debug(ViewReq self, CompositeEncoder output, SerialDescriptor serialDesc) {
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
                        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.cmBackhaulExtra != null) {
                            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.cmBackhaulExtra);
                        }
                    }

                    public /* synthetic */ ViewReq(String str, Long l, String str2, Long l2, String str3, Long l3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : l2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : l3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : str6, (i & 512) != 0 ? null : str7, (i & 1024) != 0 ? null : str8, (i & 2048) != 0 ? null : str9, (i & 4096) == 0 ? str10 : null);
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

                    public final String getCmBackhaulExtra() {
                        return this.cmBackhaulExtra;
                    }
                }

                public final Tab3Req getTab3Req() {
                    return this.tab3Req;
                }

                /* compiled from: UgcDetailHandler.kt */
                @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J>\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\fHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006-"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$Tab3Req;", RoomRecommendViewModel.EMPTY_CURSOR, "trackId", RoomRecommendViewModel.EMPTY_CURSOR, "fromSpmid", "extraParams", "Lkotlinx/serialization/json/JsonElement;", "sourceId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/Long;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTrackId", "()Ljava/lang/String;", "getFromSpmid", "getExtraParams", "()Lkotlinx/serialization/json/JsonElement;", "getSourceId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/Long;)Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$Tab3Req;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adextra_debug", "$serializer", "Companion", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

                    /* compiled from: UgcDetailHandler.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$Tab3Req$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$Tab3Req;", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<Tab3Req> serializer() {
                            return UgcDetailHandler$Response$Tab3Req$$serializer.INSTANCE;
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

                /* compiled from: UgcDetailHandler.kt */
                @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\tHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$NativeReq;", RoomRecommendViewModel.EMPTY_CURSOR, "nativeMode", RoomRecommendViewModel.EMPTY_CURSOR, "extraParams", "Lkotlinx/serialization/json/JsonElement;", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getNativeMode", "()Ljava/lang/String;", "getExtraParams", "()Lkotlinx/serialization/json/JsonElement;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adextra_debug", "$serializer", "Companion", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                @Serializable
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class NativeReq {
                    public static final Companion Companion = new Companion(null);
                    private final JsonElement extraParams;
                    private final String nativeMode;

                    public NativeReq() {
                        this((String) null, (JsonElement) null, 3, (DefaultConstructorMarker) null);
                    }

                    public static /* synthetic */ NativeReq copy$default(NativeReq nativeReq, String str, JsonElement jsonElement, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = nativeReq.nativeMode;
                        }
                        if ((i & 2) != 0) {
                            jsonElement = nativeReq.extraParams;
                        }
                        return nativeReq.copy(str, jsonElement);
                    }

                    public final String component1() {
                        return this.nativeMode;
                    }

                    public final JsonElement component2() {
                        return this.extraParams;
                    }

                    public final NativeReq copy(String str, JsonElement jsonElement) {
                        return new NativeReq(str, jsonElement);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof NativeReq) {
                            NativeReq nativeReq = (NativeReq) obj;
                            return Intrinsics.areEqual(this.nativeMode, nativeReq.nativeMode) && Intrinsics.areEqual(this.extraParams, nativeReq.extraParams);
                        }
                        return false;
                    }

                    public int hashCode() {
                        return ((this.nativeMode == null ? 0 : this.nativeMode.hashCode()) * 31) + (this.extraParams != null ? this.extraParams.hashCode() : 0);
                    }

                    public String toString() {
                        String str = this.nativeMode;
                        return "NativeReq(nativeMode=" + str + ", extraParams=" + this.extraParams + ")";
                    }

                    /* compiled from: UgcDetailHandler.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$NativeReq$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$NativeReq;", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<NativeReq> serializer() {
                            return UgcDetailHandler$Response$NativeReq$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ NativeReq(int seen0, String nativeMode, JsonElement extraParams, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((seen0 & 1) == 0) {
                            this.nativeMode = null;
                        } else {
                            this.nativeMode = nativeMode;
                        }
                        if ((seen0 & 2) == 0) {
                            this.extraParams = null;
                        } else {
                            this.extraParams = extraParams;
                        }
                    }

                    public NativeReq(String nativeMode, JsonElement extraParams) {
                        this.nativeMode = nativeMode;
                        this.extraParams = extraParams;
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$adextra_debug(NativeReq self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.nativeMode != null) {
                            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.nativeMode);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.extraParams != null) {
                            output.encodeNullableSerializableElement(serialDesc, 1, JsonElementSerializer.INSTANCE, self.extraParams);
                        }
                    }

                    public /* synthetic */ NativeReq(String str, JsonElement jsonElement, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : jsonElement);
                    }

                    public final String getNativeMode() {
                        return this.nativeMode;
                    }

                    public final JsonElement getExtraParams() {
                        return this.extraParams;
                    }
                }
            }

            @Override // kntr.app.ad.domain.adextra.handler.IAdExtraQueryHandler
            public String handle(AdExtraUgcDetailQuery query) {
                Long longOrNull;
                Response.ViewReq viewReq;
                Long longOrNull2;
                Long longOrNull3;
                Intrinsics.checkNotNullParameter(query, "query");
                Response.NativeReq nativeReq = null;
                Response.ViewReq viewReq2 = null;
                Response.Tab3Req tab3Req = null;
                String bizExtra = query.getBizExtra();
                JsonObject bizExtraObject = bizExtra != null ? AdExtraUtilKt.getBizExtraObject(bizExtra) : null;
                if (query.getNativeMode() >= 1) {
                    nativeReq = new Response.NativeReq(String.valueOf(query.getNativeMode()), bizExtraObject != null ? AdExtraUtilKt.getExtraParams(bizExtraObject) : null);
                }
                Integer valueOf = bizExtraObject != null ? Integer.valueOf(AdExtraUtilKt.getAdPlayPage(bizExtraObject)) : null;
                if (valueOf != null && valueOf.intValue() == 1) {
                    AdViewQuery $this$handle_u24lambda_u240 = query.getViewQuery();
                    if ($this$handle_u24lambda_u240 != null) {
                        String ocpxTargetType = query.getOcpxTargetType();
                        String valueOf2 = (ocpxTargetType == null || (longOrNull3 = StringsKt.toLongOrNull(ocpxTargetType)) == null) ? null : String.valueOf(longOrNull3.longValue());
                        Long linkedCreativeId = query.getLinkedCreativeId();
                        Long valueOf3 = Long.valueOf(linkedCreativeId != null ? linkedCreativeId.longValue() : 0L);
                        String trackId = query.getTrackId();
                        String str = trackId == null ? RoomRecommendViewModel.EMPTY_CURSOR : trackId;
                        Long sourceId = query.getSourceId();
                        Long valueOf4 = Long.valueOf(sourceId != null ? sourceId.longValue() : 0L);
                        String requestId = $this$handle_u24lambda_u240.getRequestId();
                        String str2 = requestId == null ? RoomRecommendViewModel.EMPTY_CURSOR : requestId;
                        Long resourceId = $this$handle_u24lambda_u240.getResourceId();
                        Long valueOf5 = Long.valueOf(resourceId != null ? resourceId.longValue() : 0L);
                        String fromTrackId = $this$handle_u24lambda_u240.getFromTrackId();
                        String titleEncode = $this$handle_u24lambda_u240.getTitleEncode();
                        String str3 = titleEncode == null ? RoomRecommendViewModel.EMPTY_CURSOR : titleEncode;
                        String titleMaterialId = $this$handle_u24lambda_u240.getTitleMaterialId();
                        String str4 = titleMaterialId == null ? RoomRecommendViewModel.EMPTY_CURSOR : titleMaterialId;
                        String imageMaterialId = $this$handle_u24lambda_u240.getImageMaterialId();
                        String str5 = imageMaterialId == null ? RoomRecommendViewModel.EMPTY_CURSOR : imageMaterialId;
                        String tabClickFrom = $this$handle_u24lambda_u240.getTabClickFrom();
                        String str6 = tabClickFrom == null ? RoomRecommendViewModel.EMPTY_CURSOR : tabClickFrom;
                        String cardAdStyle = $this$handle_u24lambda_u240.getCardAdStyle();
                        String str7 = cardAdStyle == null ? RoomRecommendViewModel.EMPTY_CURSOR : cardAdStyle;
                        String it = $this$handle_u24lambda_u240.getCmBackhaulExtra();
                        viewReq = new Response.ViewReq(valueOf2, valueOf3, str, valueOf4, str2, valueOf5, fromTrackId, str3, str4, str5, str6, str7, (it == null || StringsKt.isBlank(it)) ? null : it);
                    } else {
                        viewReq = null;
                    }
                    Response.ViewReq viewReq3 = viewReq;
                    if (viewReq3 == null) {
                        String ocpxTargetType2 = query.getOcpxTargetType();
                        String valueOf6 = (ocpxTargetType2 == null || (longOrNull2 = StringsKt.toLongOrNull(ocpxTargetType2)) == null) ? null : String.valueOf(longOrNull2.longValue());
                        Long linkedCreativeId2 = query.getLinkedCreativeId();
                        Long valueOf7 = Long.valueOf(linkedCreativeId2 != null ? linkedCreativeId2.longValue() : 0L);
                        String trackId2 = query.getTrackId();
                        String str8 = trackId2 == null ? RoomRecommendViewModel.EMPTY_CURSOR : trackId2;
                        Long sourceId2 = query.getSourceId();
                        viewReq3 = new Response.ViewReq(valueOf6, valueOf7, str8, Long.valueOf(sourceId2 != null ? sourceId2.longValue() : 0L), (String) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 8176, (DefaultConstructorMarker) null);
                    }
                    viewReq2 = viewReq3;
                } else if (valueOf != null && valueOf.intValue() == 2) {
                    String trackId3 = query.getTrackId();
                    if (trackId3 == null) {
                        trackId3 = RoomRecommendViewModel.EMPTY_CURSOR;
                    }
                    JsonElement extraParams = AdExtraUtilKt.getExtraParams(bizExtraObject);
                    String fromSpmid = query.getFromSpmid();
                    if (fromSpmid == null) {
                        fromSpmid = RoomRecommendViewModel.EMPTY_CURSOR;
                    }
                    Long sourceId3 = query.getSourceId();
                    tab3Req = new Response.Tab3Req(trackId3, fromSpmid, extraParams, Long.valueOf(sourceId3 != null ? sourceId3.longValue() : 0L));
                }
                String caid = query.getCaid();
                String ocpxTargetType3 = query.getOcpxTargetType();
                String valueOf8 = (ocpxTargetType3 == null || (longOrNull = StringsKt.toLongOrNull(ocpxTargetType3)) == null) ? null : String.valueOf(longOrNull.longValue());
                Long linkedCreativeId3 = query.getLinkedCreativeId();
                Long valueOf9 = Long.valueOf(linkedCreativeId3 != null ? linkedCreativeId3.longValue() : 0L);
                String trackId4 = query.getTrackId();
                String str9 = trackId4 == null ? RoomRecommendViewModel.EMPTY_CURSOR : trackId4;
                String it2 = query.getNatureAd();
                Object value$iv = new Response(caid, valueOf8, valueOf9, str9, (it2 == null || StringsKt.isBlank(it2)) ? null : it2, nativeReq, viewReq2, tab3Req);
                StringFormat $this$encodeToString$iv = JsonExtKt.getAdJson();
                $this$encodeToString$iv.getSerializersModule();
                return $this$encodeToString$iv.encodeToString(Response.Companion.serializer(), value$iv);
            }
        }