package kntr.app.ad.domain.adextra.handler;

import kntr.app.ad.common.utils.JsonExtKt;
import kntr.app.ad.domain.adextra.AdExtraUtilKt;
import kntr.app.ad.domain.adextra.handler.DefaultHandler;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.ad.protocol.adextra.AdExtraFollowingDetailQuery;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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

/* compiled from: FollowingDetailHandler.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/FollowingDetailHandler;", "Lkntr/app/ad/domain/adextra/handler/IAdExtraQueryHandler;", "Lkntr/app/ad/protocol/adextra/AdExtraFollowingDetailQuery;", "<init>", "()V", "handle", RoomRecommendViewModel.EMPTY_CURSOR, "query", "Response", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FollowingDetailHandler implements IAdExtraQueryHandler<AdExtraFollowingDetailQuery> {

    /* compiled from: FollowingDetailHandler.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0081\b\u0018\u0000 Q2\u00020\u0001:\u0004NOPQB\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007BÛ\u0003\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\f\u0012\b\u0010 \u001a\u0004\u0018\u00010\f\u0012\b\u0010!\u001a\u0004\u0018\u00010\f\u0012\b\u0010\"\u001a\u0004\u0018\u00010\f\u0012\b\u0010#\u001a\u0004\u0018\u00010\f\u0012\b\u0010$\u001a\u0004\u0018\u00010\f\u0012\b\u0010%\u001a\u0004\u0018\u00010\f\u0012\b\u0010&\u001a\u0004\u0018\u00010\f\u0012\b\u0010'\u001a\u0004\u0018\u00010\f\u0012\b\u0010(\u001a\u0004\u0018\u00010\f\u0012\b\u0010)\u001a\u0004\u0018\u00010\f\u0012\b\u0010*\u001a\u0004\u0018\u00010\f\u0012\b\u0010+\u001a\u0004\u0018\u00010\f\u0012\b\u0010,\u001a\u0004\u0018\u00010\f\u0012\b\u0010-\u001a\u0004\u0018\u00010\f\u0012\b\u0010.\u001a\u0004\u0018\u00010\f\u0012\b\u0010/\u001a\u0004\u0018\u00010\f\u0012\b\u00100\u001a\u0004\u0018\u00010\f\u0012\b\u00101\u001a\u0004\u0018\u00010\f\u0012\b\u00102\u001a\u0004\u0018\u00010\f\u0012\b\u00103\u001a\u0004\u0018\u00010\f\u0012\b\u00104\u001a\u0004\u0018\u00010\f\u0012\b\u00105\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u00106\u001a\u0004\u0018\u000107¢\u0006\u0004\b\u0006\u00108J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020\tHÖ\u0001J\t\u0010E\u001a\u00020\fHÖ\u0001J%\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00002\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0001¢\u0006\u0002\bMR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<¨\u0006R"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/FollowingDetailHandler$Response;", "Lkntr/app/ad/domain/adextra/handler/DefaultHandler$Response;", "tab3Req", "Lkntr/app/ad/domain/adextra/handler/FollowingDetailHandler$Response$Tab3Req;", "dynamicReq", "Lkntr/app/ad/domain/adextra/handler/FollowingDetailHandler$Response$DynamicReq;", "<init>", "(Lkntr/app/ad/domain/adextra/handler/FollowingDetailHandler$Response$Tab3Req;Lkntr/app/ad/domain/adextra/handler/FollowingDetailHandler$Response$DynamicReq;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "seen1", "networkV2", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.NETWORK, "operatorType", ReportBuildInParam.VENDOR, ReportBuildInParam.MODEL, ReportBuildInParam.UA, "uaSys", "mobiApp", "osV", ReportBuildInParam.BUILD, "screenSize", "bootMark", "updateMark", "userApps", "dnsClientIp", "opensdkVer", ReportBuildInParam.LNG, ReportBuildInParam.LAT, "lbsTs", "storyShownIds", "apName", "apMac", "isKntr", ReportBuildInParam.IMEI, ReportBuildInParam.MAC, ReportBuildInParam.ANDROID_ID, ReportBuildInParam.OAID, "gameId", ReportBuildInParam.DISK, "hardwareModel", "initialTime", ReportBuildInParam.IDFA, ReportBuildInParam.LANGUAGE, ReportBuildInParam.MACHINE, ReportBuildInParam.MEMORY, ReportBuildInParam.BOOT_TIME_IN_SEC, "carrierInfo", ReportBuildInParam.COUNTRY_CODE, ReportBuildInParam.DEVICE_NAME, ReportBuildInParam.SYS_FILE_TIME, "systemVersion", ReportBuildInParam.TIME_ZONE, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/domain/adextra/handler/FollowingDetailHandler$Response$Tab3Req;Lkntr/app/ad/domain/adextra/handler/FollowingDetailHandler$Response$DynamicReq;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTab3Req", "()Lkntr/app/ad/domain/adextra/handler/FollowingDetailHandler$Response$Tab3Req;", "getDynamicReq", "()Lkntr/app/ad/domain/adextra/handler/FollowingDetailHandler$Response$DynamicReq;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adextra_debug", "DynamicReq", "Tab3Req", "$serializer", "Companion", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Response extends DefaultHandler.Response {
        public static final Companion Companion = new Companion(null);
        private final DynamicReq dynamicReq;
        private final Tab3Req tab3Req;

        public Response() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ Response copy$default(Response response, Tab3Req tab3Req, DynamicReq dynamicReq, int i, Object obj) {
            if ((i & 1) != 0) {
                tab3Req = response.tab3Req;
            }
            if ((i & 2) != 0) {
                dynamicReq = response.dynamicReq;
            }
            return response.copy(tab3Req, dynamicReq);
        }

        public final Tab3Req component1() {
            return this.tab3Req;
        }

        public final DynamicReq component2() {
            return this.dynamicReq;
        }

        public final Response copy(Tab3Req tab3Req, DynamicReq dynamicReq) {
            return new Response(tab3Req, dynamicReq);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Response) {
                Response response = (Response) obj;
                return Intrinsics.areEqual(this.tab3Req, response.tab3Req) && Intrinsics.areEqual(this.dynamicReq, response.dynamicReq);
            }
            return false;
        }

        public int hashCode() {
            return ((this.tab3Req == null ? 0 : this.tab3Req.hashCode()) * 31) + (this.dynamicReq != null ? this.dynamicReq.hashCode() : 0);
        }

        public String toString() {
            Tab3Req tab3Req = this.tab3Req;
            return "Response(tab3Req=" + tab3Req + ", dynamicReq=" + this.dynamicReq + ")";
        }

        /* compiled from: FollowingDetailHandler.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/FollowingDetailHandler$Response$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/domain/adextra/handler/FollowingDetailHandler$Response;", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Response> serializer() {
                return new GeneratedSerializer<Response>() { // from class: kntr.app.ad.domain.adextra.handler.FollowingDetailHandler$Response$$serializer
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.domain.adextra.handler.FollowingDetailHandler.Response", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.ad.domain.adextra.handler.FollowingDetailHandler$Response> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.ad.domain.adextra.handler.FollowingDetailHandler$Response> A[REMOVE]) =  kntr.app.ad.domain.adextra.handler.FollowingDetailHandler$Response$$serializer.INSTANCE kntr.app.ad.domain.adextra.handler.FollowingDetailHandler$Response$$serializer)
                             in method: kntr.app.ad.domain.adextra.handler.FollowingDetailHandler.Response.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.ad.domain.adextra.handler.FollowingDetailHandler$Response>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                              ("kntr.app.ad.domain.adextra.handler.FollowingDetailHandler.Response")
                              (wrap: kntr.app.ad.domain.adextra.handler.FollowingDetailHandler$Response$$serializer : 0x0009: SGET  (r1v0 kntr.app.ad.domain.adextra.handler.FollowingDetailHandler$Response$$serializer A[REMOVE]) =  kntr.app.ad.domain.adextra.handler.FollowingDetailHandler$Response$$serializer.INSTANCE kntr.app.ad.domain.adextra.handler.FollowingDetailHandler$Response$$serializer)
                              (44 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.ad.domain.adextra.handler.FollowingDetailHandler$Response$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.ad.domain.adextra.handler.FollowingDetailHandler$Response$$serializer
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
                            kntr.app.ad.domain.adextra.handler.FollowingDetailHandler$Response$$serializer r0 = kntr.app.ad.domain.adextra.handler.FollowingDetailHandler$Response$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.ad.domain.adextra.handler.FollowingDetailHandler.Response.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ Response(int seen0, int seen1, String networkV2, String network, String operatorType, String vendor, String model, String ua, String uaSys, String mobiApp, String osV, Integer build, String screenSize, String bootMark, String updateMark, String userApps, String dnsClientIp, String opensdkVer, String lng, String lat, String lbsTs, String storyShownIds, String apName, String apMac, String isKntr, String imei, String mac, String androidid, String oaid, String gameId, String disk, String hardwareModel, String initialTime, String idfa, String language, String machine, String memory, String bootTimeInSec, String carrierInfo, String countryCode, String deviceName, String sysFileTime, String systemVersion, String timeZone, Tab3Req tab3Req, DynamicReq dynamicReq, SerializationConstructorMarker serializationConstructorMarker) {
                    super(seen0, seen1, networkV2, network, operatorType, vendor, model, ua, uaSys, mobiApp, osV, build, screenSize, bootMark, updateMark, userApps, dnsClientIp, opensdkVer, lng, lat, lbsTs, storyShownIds, apName, apMac, isKntr, imei, mac, androidid, oaid, gameId, disk, hardwareModel, initialTime, idfa, language, machine, memory, bootTimeInSec, carrierInfo, countryCode, deviceName, sysFileTime, systemVersion, timeZone, serializationConstructorMarker);
                    Response response;
                    if ((seen1 & 1024) == 0) {
                        response = this;
                        response.tab3Req = null;
                    } else {
                        response = this;
                        response.tab3Req = tab3Req;
                    }
                    if ((seen1 & 2048) == 0) {
                        response.dynamicReq = null;
                    } else {
                        response.dynamicReq = dynamicReq;
                    }
                }

                public Response(Tab3Req tab3Req, DynamicReq dynamicReq) {
                    this.tab3Req = tab3Req;
                    this.dynamicReq = dynamicReq;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$adextra_debug(Response self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    DefaultHandler.Response.write$Self(self, output, serialDesc);
                    if (output.shouldEncodeElementDefault(serialDesc, 42) || self.tab3Req != null) {
                        output.encodeNullableSerializableElement(serialDesc, 42, FollowingDetailHandler$Response$Tab3Req$$serializer.INSTANCE, self.tab3Req);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 43) || self.dynamicReq != null) {
                        output.encodeNullableSerializableElement(serialDesc, 43, FollowingDetailHandler$Response$DynamicReq$$serializer.INSTANCE, self.dynamicReq);
                    }
                }

                public /* synthetic */ Response(Tab3Req tab3Req, DynamicReq dynamicReq, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : tab3Req, (i & 2) != 0 ? null : dynamicReq);
                }

                public final Tab3Req getTab3Req() {
                    return this.tab3Req;
                }

                /* compiled from: FollowingDetailHandler.kt */
                @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 22\u00020\u0001:\u000212BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fBW\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018JV\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u000eHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018¨\u00063"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/FollowingDetailHandler$Response$DynamicReq;", RoomRecommendViewModel.EMPTY_CURSOR, "trackId", RoomRecommendViewModel.EMPTY_CURSOR, "fromSpmid", "extraParams", "Lkotlinx/serialization/json/JsonElement;", "linkedCreativeId", RoomRecommendViewModel.EMPTY_CURSOR, "requestId", "sourceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTrackId", "()Ljava/lang/String;", "getFromSpmid", "getExtraParams", "()Lkotlinx/serialization/json/JsonElement;", "getLinkedCreativeId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRequestId", "getSourceId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)Lkntr/app/ad/domain/adextra/handler/FollowingDetailHandler$Response$DynamicReq;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adextra_debug", "$serializer", "Companion", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                @Serializable
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class DynamicReq {
                    public static final Companion Companion = new Companion(null);
                    private final JsonElement extraParams;
                    private final String fromSpmid;
                    private final Long linkedCreativeId;
                    private final String requestId;
                    private final Long sourceId;
                    private final String trackId;

                    public DynamicReq() {
                        this((String) null, (String) null, (JsonElement) null, (Long) null, (String) null, (Long) null, 63, (DefaultConstructorMarker) null);
                    }

                    public static /* synthetic */ DynamicReq copy$default(DynamicReq dynamicReq, String str, String str2, JsonElement jsonElement, Long l, String str3, Long l2, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = dynamicReq.trackId;
                        }
                        if ((i & 2) != 0) {
                            str2 = dynamicReq.fromSpmid;
                        }
                        String str4 = str2;
                        if ((i & 4) != 0) {
                            jsonElement = dynamicReq.extraParams;
                        }
                        JsonElement jsonElement2 = jsonElement;
                        if ((i & 8) != 0) {
                            l = dynamicReq.linkedCreativeId;
                        }
                        Long l3 = l;
                        if ((i & 16) != 0) {
                            str3 = dynamicReq.requestId;
                        }
                        String str5 = str3;
                        if ((i & 32) != 0) {
                            l2 = dynamicReq.sourceId;
                        }
                        return dynamicReq.copy(str, str4, jsonElement2, l3, str5, l2);
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
                        return this.linkedCreativeId;
                    }

                    public final String component5() {
                        return this.requestId;
                    }

                    public final Long component6() {
                        return this.sourceId;
                    }

                    public final DynamicReq copy(String str, String str2, JsonElement jsonElement, Long l, String str3, Long l2) {
                        return new DynamicReq(str, str2, jsonElement, l, str3, l2);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof DynamicReq) {
                            DynamicReq dynamicReq = (DynamicReq) obj;
                            return Intrinsics.areEqual(this.trackId, dynamicReq.trackId) && Intrinsics.areEqual(this.fromSpmid, dynamicReq.fromSpmid) && Intrinsics.areEqual(this.extraParams, dynamicReq.extraParams) && Intrinsics.areEqual(this.linkedCreativeId, dynamicReq.linkedCreativeId) && Intrinsics.areEqual(this.requestId, dynamicReq.requestId) && Intrinsics.areEqual(this.sourceId, dynamicReq.sourceId);
                        }
                        return false;
                    }

                    public int hashCode() {
                        return ((((((((((this.trackId == null ? 0 : this.trackId.hashCode()) * 31) + (this.fromSpmid == null ? 0 : this.fromSpmid.hashCode())) * 31) + (this.extraParams == null ? 0 : this.extraParams.hashCode())) * 31) + (this.linkedCreativeId == null ? 0 : this.linkedCreativeId.hashCode())) * 31) + (this.requestId == null ? 0 : this.requestId.hashCode())) * 31) + (this.sourceId != null ? this.sourceId.hashCode() : 0);
                    }

                    public String toString() {
                        String str = this.trackId;
                        String str2 = this.fromSpmid;
                        JsonElement jsonElement = this.extraParams;
                        Long l = this.linkedCreativeId;
                        String str3 = this.requestId;
                        return "DynamicReq(trackId=" + str + ", fromSpmid=" + str2 + ", extraParams=" + jsonElement + ", linkedCreativeId=" + l + ", requestId=" + str3 + ", sourceId=" + this.sourceId + ")";
                    }

                    /* compiled from: FollowingDetailHandler.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/FollowingDetailHandler$Response$DynamicReq$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/domain/adextra/handler/FollowingDetailHandler$Response$DynamicReq;", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<DynamicReq> serializer() {
                            return FollowingDetailHandler$Response$DynamicReq$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ DynamicReq(int seen0, String trackId, String fromSpmid, JsonElement extraParams, Long linkedCreativeId, String requestId, Long sourceId, SerializationConstructorMarker serializationConstructorMarker) {
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
                            this.linkedCreativeId = null;
                        } else {
                            this.linkedCreativeId = linkedCreativeId;
                        }
                        if ((seen0 & 16) == 0) {
                            this.requestId = null;
                        } else {
                            this.requestId = requestId;
                        }
                        if ((seen0 & 32) == 0) {
                            this.sourceId = null;
                        } else {
                            this.sourceId = sourceId;
                        }
                    }

                    public DynamicReq(String trackId, String fromSpmid, JsonElement extraParams, Long linkedCreativeId, String requestId, Long sourceId) {
                        this.trackId = trackId;
                        this.fromSpmid = fromSpmid;
                        this.extraParams = extraParams;
                        this.linkedCreativeId = linkedCreativeId;
                        this.requestId = requestId;
                        this.sourceId = sourceId;
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$adextra_debug(DynamicReq self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.trackId != null) {
                            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.trackId);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.fromSpmid != null) {
                            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.fromSpmid);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.extraParams != null) {
                            output.encodeNullableSerializableElement(serialDesc, 2, JsonElementSerializer.INSTANCE, self.extraParams);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.linkedCreativeId != null) {
                            output.encodeNullableSerializableElement(serialDesc, 3, LongSerializer.INSTANCE, self.linkedCreativeId);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.requestId != null) {
                            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.requestId);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.sourceId != null) {
                            output.encodeNullableSerializableElement(serialDesc, 5, LongSerializer.INSTANCE, self.sourceId);
                        }
                    }

                    public /* synthetic */ DynamicReq(String str, String str2, JsonElement jsonElement, Long l, String str3, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : jsonElement, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : l2);
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

                    public final Long getLinkedCreativeId() {
                        return this.linkedCreativeId;
                    }

                    public final String getRequestId() {
                        return this.requestId;
                    }

                    public final Long getSourceId() {
                        return this.sourceId;
                    }
                }

                public final DynamicReq getDynamicReq() {
                    return this.dynamicReq;
                }

                /* compiled from: FollowingDetailHandler.kt */
                @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J>\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\fHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006-"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/FollowingDetailHandler$Response$Tab3Req;", RoomRecommendViewModel.EMPTY_CURSOR, "trackId", RoomRecommendViewModel.EMPTY_CURSOR, "fromSpmid", "extraParams", "Lkotlinx/serialization/json/JsonElement;", "sourceId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/Long;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTrackId", "()Ljava/lang/String;", "getFromSpmid", "getExtraParams", "()Lkotlinx/serialization/json/JsonElement;", "getSourceId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/Long;)Lkntr/app/ad/domain/adextra/handler/FollowingDetailHandler$Response$Tab3Req;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adextra_debug", "$serializer", "Companion", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

                    /* compiled from: FollowingDetailHandler.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/FollowingDetailHandler$Response$Tab3Req$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/domain/adextra/handler/FollowingDetailHandler$Response$Tab3Req;", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<Tab3Req> serializer() {
                            return FollowingDetailHandler$Response$Tab3Req$$serializer.INSTANCE;
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
            public String handle(AdExtraFollowingDetailQuery query) {
                Intrinsics.checkNotNullParameter(query, "query");
                Response.Tab3Req tab3Req = null;
                Response.DynamicReq dynamicReq = null;
                String bizExtra = query.getBizExtra();
                JsonObject bizExtraObject = bizExtra != null ? AdExtraUtilKt.getBizExtraObject(bizExtra) : null;
                Integer adDynamicDetail = bizExtraObject != null ? Integer.valueOf(AdExtraUtilKt.getAdDynamicDetail(bizExtraObject)) : null;
                if (adDynamicDetail != null && adDynamicDetail.intValue() == 1) {
                    String trackId = query.getTrackId();
                    if (trackId == null) {
                        trackId = RoomRecommendViewModel.EMPTY_CURSOR;
                    }
                    String fromSpmid = query.getFromSpmid();
                    if (fromSpmid == null) {
                        fromSpmid = RoomRecommendViewModel.EMPTY_CURSOR;
                    }
                    tab3Req = new Response.Tab3Req(trackId, fromSpmid, AdExtraUtilKt.getExtraParams(bizExtraObject), Long.valueOf(AdExtraUtilKt.getSourceId(bizExtraObject)));
                }
                if ((adDynamicDetail != null && adDynamicDetail.intValue() == 2) || query.getForceReqType()) {
                    String trackId2 = query.getTrackId();
                    String str = trackId2 == null ? RoomRecommendViewModel.EMPTY_CURSOR : trackId2;
                    String fromSpmid2 = query.getFromSpmid();
                    String str2 = fromSpmid2 == null ? RoomRecommendViewModel.EMPTY_CURSOR : fromSpmid2;
                    JsonElement extraParams = bizExtraObject != null ? AdExtraUtilKt.getExtraParams(bizExtraObject) : null;
                    Long linkedCreativeId = query.getLinkedCreativeId();
                    Long valueOf = Long.valueOf(linkedCreativeId != null ? linkedCreativeId.longValue() : 0L);
                    String requestId = query.getRequestId();
                    dynamicReq = new Response.DynamicReq(str, str2, extraParams, valueOf, requestId == null ? RoomRecommendViewModel.EMPTY_CURSOR : requestId, bizExtraObject != null ? Long.valueOf(AdExtraUtilKt.getSourceId(bizExtraObject)) : null);
                }
                Response it = new Response(tab3Req, dynamicReq);
                StringFormat $this$encodeToString$iv = JsonExtKt.getAdJson();
                $this$encodeToString$iv.getSerializersModule();
                return $this$encodeToString$iv.encodeToString(Response.Companion.serializer(), it);
            }
        }