package kntr.app.ad.domain.adextra.handler;

import java.util.Locale;
import kntr.app.ad.common.utils.AdJsonSerialName;
import kntr.app.ad.common.utils.JsonExtKt;
import kntr.app.ad.common.utils.StringExtKt;
import kntr.app.ad.domain.platformspec.AdPlatformSpec;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.ad.protocol.adextra.AdExtraDefaultQuery;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.device.DeviceType;
import kntr.base.device.KDevice;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DefaultHandler.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/DefaultHandler;", "Lkntr/app/ad/domain/adextra/handler/IAdExtraQueryHandler;", "Lkntr/app/ad/protocol/adextra/AdExtraDefaultQuery;", "<init>", "()V", "handle", RoomRecommendViewModel.EMPTY_CURSOR, "query", "Response", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DefaultHandler implements IAdExtraQueryHandler<AdExtraDefaultQuery> {

    /* compiled from: DefaultHandler.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u0000 E2\u00020\u0001:\u0002DEB\u0007¢\u0006\u0004\b\u0002\u0010\u0003BÇ\u0003\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\b\u0012\b\u0010 \u001a\u0004\u0018\u00010\b\u0012\b\u0010!\u001a\u0004\u0018\u00010\b\u0012\b\u0010\"\u001a\u0004\u0018\u00010\b\u0012\b\u0010#\u001a\u0004\u0018\u00010\b\u0012\b\u0010$\u001a\u0004\u0018\u00010\b\u0012\b\u0010%\u001a\u0004\u0018\u00010\b\u0012\b\u0010&\u001a\u0004\u0018\u00010\b\u0012\b\u0010'\u001a\u0004\u0018\u00010\b\u0012\b\u0010(\u001a\u0004\u0018\u00010\b\u0012\b\u0010)\u001a\u0004\u0018\u00010\b\u0012\b\u0010*\u001a\u0004\u0018\u00010\b\u0012\b\u0010+\u001a\u0004\u0018\u00010\b\u0012\b\u0010,\u001a\u0004\u0018\u00010\b\u0012\b\u0010-\u001a\u0004\u0018\u00010\b\u0012\b\u0010.\u001a\u0004\u0018\u00010\b\u0012\b\u0010/\u001a\u0004\u0018\u00010\b\u0012\b\u00100\u001a\u0004\u0018\u00010\b\u0012\b\u00101\u001a\u0004\u0018\u00010\b\u0012\b\u00102\u001a\u0004\u0018\u000103¢\u0006\u0004\b\u0002\u00104J \u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0007R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u00105R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b6\u0010\u0003R\u001a\u0010,\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b7\u0010\u0003R\u001a\u0010-\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b8\u0010\u0003R\u001a\u0010.\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b9\u0010\u0003R\u001a\u0010/\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b:\u0010\u0003R\u001a\u00100\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b;\u0010\u0003R\u001a\u00101\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b<\u0010\u0003¨\u0006F\u0080å\b\u0007\u0080å\b\t\u0080å\b\n\u0080å\b\u000b\u0080å\b\f\u0080å\b\r\u0080å\b\u000e\u0080å\b\u000f\u0080å\b\u0010\u0080å\b\u0011\u0080å\b\u0012\u0080å\b\u0013\u0080å\b\u0014\u0080å\b\u0015\u0080å\b\u0016\u0080å\b\u0017\u0080å\b\u0018\u0080å\b\u0019\u0080å\b\u001a\u0080å\b\u001b\u0080å\b\u001c\u0080å\b\u001d\u0080å\b\u001e\u0080å\b\u001f\u0080å\b \u0080å\b!\u0080å\b\"\u0080å\b#\u0080å\b$\u0080å\b%\u0080å\b&\u0080å\b'\u0080å\b(\u0080å\b)\u0080å\b*\u0080å\b+\u0080å\b,\u0080å\b-\u0080å\b.\u0080å\b/\u0080å\b0\u0080å\b1"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/DefaultHandler$Response;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "seen1", "networkV2", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.NETWORK, "operatorType", ReportBuildInParam.VENDOR, ReportBuildInParam.MODEL, ReportBuildInParam.UA, "uaSys", "mobiApp", "osV", ReportBuildInParam.BUILD, "screenSize", "bootMark", "updateMark", "userApps", "dnsClientIp", "opensdkVer", ReportBuildInParam.LNG, ReportBuildInParam.LAT, "lbsTs", "storyShownIds", "apName", "apMac", "isKntr", ReportBuildInParam.IMEI, ReportBuildInParam.MAC, ReportBuildInParam.ANDROID_ID, ReportBuildInParam.OAID, "gameId", ReportBuildInParam.DISK, "hardwareModel", "initialTime", ReportBuildInParam.IDFA, ReportBuildInParam.LANGUAGE, ReportBuildInParam.MACHINE, ReportBuildInParam.MEMORY, ReportBuildInParam.BOOT_TIME_IN_SEC, "carrierInfo", ReportBuildInParam.COUNTRY_CODE, ReportBuildInParam.DEVICE_NAME, ReportBuildInParam.SYS_FILE_TIME, "systemVersion", ReportBuildInParam.TIME_ZONE, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "Ljava/lang/Integer;", "getBootTimeInSec$annotations", "getCarrierInfo$annotations", "getCountryCode$annotations", "getDeviceName$annotations", "getSysFileTime$annotations", "getSystemVersion$annotations", "getTimeZone$annotations", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static class Response {
        public static final Companion Companion = new Companion(null);
        private String androidid;
        private String apMac;
        private String apName;
        private String bootMark;
        private String bootTimeInSec;
        private Integer build;
        private String carrierInfo;
        private String countryCode;
        private String deviceName;
        private String disk;
        private String dnsClientIp;
        private String gameId;
        private String hardwareModel;
        private String idfa;
        private String imei;
        private String initialTime;
        private String isKntr;
        private String language;
        private String lat;
        private String lbsTs;
        private String lng;
        private String mac;
        private String machine;
        private String memory;
        private String mobiApp;
        private String model;
        private String network;
        private String networkV2;
        private String oaid;
        private String opensdkVer;
        private String operatorType;
        private String osV;
        private String screenSize;
        private String storyShownIds;
        private String sysFileTime;
        private String systemVersion;
        private String timeZone;
        private String ua;
        private String uaSys;
        private String updateMark;
        private String userApps;
        private String vendor;

        /* compiled from: DefaultHandler.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DeviceType.values().length];
                try {
                    iArr[DeviceType.Android.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[DeviceType.iOS.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[DeviceType.HarmonyOS.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @AdJsonSerialName(ReportBuildInParam.BOOT_TIME_IN_SEC)
        private static /* synthetic */ void getBootTimeInSec$annotations() {
        }

        @AdJsonSerialName("carrierInfo")
        private static /* synthetic */ void getCarrierInfo$annotations() {
        }

        @AdJsonSerialName(ReportBuildInParam.COUNTRY_CODE)
        private static /* synthetic */ void getCountryCode$annotations() {
        }

        @AdJsonSerialName(ReportBuildInParam.DEVICE_NAME)
        private static /* synthetic */ void getDeviceName$annotations() {
        }

        @AdJsonSerialName(ReportBuildInParam.SYS_FILE_TIME)
        private static /* synthetic */ void getSysFileTime$annotations() {
        }

        @AdJsonSerialName("systemVersion")
        private static /* synthetic */ void getSystemVersion$annotations() {
        }

        @AdJsonSerialName(ReportBuildInParam.TIME_ZONE)
        private static /* synthetic */ void getTimeZone$annotations() {
        }

        /* compiled from: DefaultHandler.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/DefaultHandler$Response$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/domain/adextra/handler/DefaultHandler$Response;", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Response> serializer() {
                return new GeneratedSerializer<Response>() { // from class: kntr.app.ad.domain.adextra.handler.DefaultHandler$Response$$serializer
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.domain.adextra.handler.DefaultHandler.Response", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.ad.domain.adextra.handler.DefaultHandler$Response> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.ad.domain.adextra.handler.DefaultHandler$Response> A[REMOVE]) =  kntr.app.ad.domain.adextra.handler.DefaultHandler$Response$$serializer.INSTANCE kntr.app.ad.domain.adextra.handler.DefaultHandler$Response$$serializer)
                             in method: kntr.app.ad.domain.adextra.handler.DefaultHandler.Response.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.ad.domain.adextra.handler.DefaultHandler$Response>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                              ("kntr.app.ad.domain.adextra.handler.DefaultHandler.Response")
                              (wrap: kntr.app.ad.domain.adextra.handler.DefaultHandler$Response$$serializer : 0x0009: SGET  (r1v0 kntr.app.ad.domain.adextra.handler.DefaultHandler$Response$$serializer A[REMOVE]) =  kntr.app.ad.domain.adextra.handler.DefaultHandler$Response$$serializer.INSTANCE kntr.app.ad.domain.adextra.handler.DefaultHandler$Response$$serializer)
                              (42 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.ad.domain.adextra.handler.DefaultHandler$Response$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.ad.domain.adextra.handler.DefaultHandler$Response$$serializer
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
                            kntr.app.ad.domain.adextra.handler.DefaultHandler$Response$$serializer r0 = kntr.app.ad.domain.adextra.handler.DefaultHandler$Response$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.ad.domain.adextra.handler.DefaultHandler.Response.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public Response() {
                    String md5;
                    this.networkV2 = AdPlatformSpec.INSTANCE.getNetworkV2();
                    this.network = AdPlatformSpec.INSTANCE.getNetwork();
                    this.operatorType = AdPlatformSpec.INSTANCE.getCarrierName();
                    this.vendor = AdPlatformSpec.INSTANCE.getManufacturer();
                    this.model = AdPlatformSpec.INSTANCE.getModel();
                    this.ua = AdPlatformSpec.INSTANCE.getUaWeb();
                    this.uaSys = AdPlatformSpec.INSTANCE.getUaSys();
                    this.mobiApp = AdPlatformSpec.INSTANCE.getMobiApp();
                    this.osV = AdPlatformSpec.INSTANCE.getOsV();
                    this.build = Integer.valueOf(AdPlatformSpec.INSTANCE.getBuild());
                    this.screenSize = AdPlatformSpec.INSTANCE.getScreenSize();
                    this.bootMark = AdPlatformSpec.INSTANCE.getBootMark();
                    this.updateMark = AdPlatformSpec.INSTANCE.getUpdateMark();
                    this.userApps = AdPlatformSpec.INSTANCE.getUserApps();
                    String p0 = AdPlatformSpec.INSTANCE.getDnsClientIp();
                    String str = null;
                    this.dnsClientIp = (p0 == null || StringsKt.isBlank(p0)) ? null : p0;
                    this.opensdkVer = AdPlatformSpec.INSTANCE.getWxSdkVer();
                    this.lng = AdPlatformSpec.INSTANCE.getLng();
                    this.lat = AdPlatformSpec.INSTANCE.getLat();
                    this.lbsTs = AdPlatformSpec.INSTANCE.getLbsTs();
                    this.storyShownIds = AdPlatformSpec.INSTANCE.getStoryShownIds();
                    this.apName = RoomRecommendViewModel.EMPTY_CURSOR;
                    this.apMac = RoomRecommendViewModel.EMPTY_CURSOR;
                    this.isKntr = "1";
                    switch (WhenMappings.$EnumSwitchMapping$0[KDevice.INSTANCE.getDeviceType().ordinal()]) {
                        case 1:
                            this.imei = AdPlatformSpec.INSTANCE.getImei();
                            this.mac = AdPlatformSpec.INSTANCE.getWifiMacAddress();
                            this.androidid = AdPlatformSpec.INSTANCE.getAndroidId();
                            this.oaid = AdPlatformSpec.INSTANCE.getOaid();
                            this.gameId = AdPlatformSpec.INSTANCE.getGameId();
                            return;
                        case 2:
                            this.bootTimeInSec = AdPlatformSpec.INSTANCE.getBootTimeInSec();
                            this.carrierInfo = AdPlatformSpec.INSTANCE.getCarrierName();
                            this.countryCode = AdPlatformSpec.INSTANCE.getCountryCode();
                            String deviceName = AdPlatformSpec.INSTANCE.getDeviceName();
                            if (deviceName != null && (md5 = StringExtKt.md5(deviceName)) != null) {
                                str = md5.toUpperCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(str, "toUpperCase(...)");
                            }
                            this.deviceName = str;
                            this.disk = AdPlatformSpec.INSTANCE.getTotalDiskCapacity();
                            this.hardwareModel = AdPlatformSpec.INSTANCE.getHardwareModel();
                            this.idfa = AdPlatformSpec.INSTANCE.getIdfa();
                            this.language = AdPlatformSpec.INSTANCE.getLanguage();
                            this.machine = AdPlatformSpec.INSTANCE.getMachine();
                            this.memory = AdPlatformSpec.INSTANCE.getTotalMemory();
                            this.sysFileTime = AdPlatformSpec.INSTANCE.getSysFileTime();
                            this.systemVersion = AdPlatformSpec.INSTANCE.getOsV();
                            this.timeZone = AdPlatformSpec.INSTANCE.getTimeZoneOffset();
                            this.initialTime = AdPlatformSpec.INSTANCE.getInitialTime();
                            return;
                        case 3:
                            this.oaid = AdPlatformSpec.INSTANCE.getOaid();
                            return;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                }

                public /* synthetic */ Response(int seen0, int seen1, String networkV2, String network, String operatorType, String vendor, String model, String ua, String uaSys, String mobiApp, String osV, Integer build, String screenSize, String bootMark, String updateMark, String userApps, String dnsClientIp, String opensdkVer, String lng, String lat, String lbsTs, String storyShownIds, String apName, String apMac, String isKntr, String imei, String mac, String androidid, String oaid, String gameId, String disk, String hardwareModel, String initialTime, String idfa, String language, String machine, String memory, String bootTimeInSec, String carrierInfo, String countryCode, String deviceName, String sysFileTime, String systemVersion, String timeZone, SerializationConstructorMarker serializationConstructorMarker) {
                    String str;
                    String md5;
                    if ((seen0 & 1) == 0) {
                        this.networkV2 = null;
                    } else {
                        this.networkV2 = networkV2;
                    }
                    if ((seen0 & 2) == 0) {
                        this.network = null;
                    } else {
                        this.network = network;
                    }
                    if ((seen0 & 4) == 0) {
                        this.operatorType = null;
                    } else {
                        this.operatorType = operatorType;
                    }
                    if ((seen0 & 8) == 0) {
                        this.vendor = null;
                    } else {
                        this.vendor = vendor;
                    }
                    if ((seen0 & 16) == 0) {
                        this.model = null;
                    } else {
                        this.model = model;
                    }
                    if ((seen0 & 32) == 0) {
                        this.ua = null;
                    } else {
                        this.ua = ua;
                    }
                    if ((seen0 & 64) == 0) {
                        this.uaSys = null;
                    } else {
                        this.uaSys = uaSys;
                    }
                    if ((seen0 & 128) == 0) {
                        this.mobiApp = null;
                    } else {
                        this.mobiApp = mobiApp;
                    }
                    if ((seen0 & 256) == 0) {
                        this.osV = null;
                    } else {
                        this.osV = osV;
                    }
                    if ((seen0 & 512) == 0) {
                        this.build = null;
                    } else {
                        this.build = build;
                    }
                    if ((seen0 & 1024) == 0) {
                        this.screenSize = null;
                    } else {
                        this.screenSize = screenSize;
                    }
                    if ((seen0 & 2048) == 0) {
                        this.bootMark = null;
                    } else {
                        this.bootMark = bootMark;
                    }
                    if ((seen0 & 4096) == 0) {
                        this.updateMark = null;
                    } else {
                        this.updateMark = updateMark;
                    }
                    if ((seen0 & 8192) == 0) {
                        this.userApps = null;
                    } else {
                        this.userApps = userApps;
                    }
                    if ((seen0 & 16384) == 0) {
                        this.dnsClientIp = null;
                    } else {
                        this.dnsClientIp = dnsClientIp;
                    }
                    if ((seen0 & 32768) == 0) {
                        this.opensdkVer = null;
                    } else {
                        this.opensdkVer = opensdkVer;
                    }
                    if ((seen0 & 65536) == 0) {
                        this.lng = null;
                    } else {
                        this.lng = lng;
                    }
                    if ((seen0 & 131072) == 0) {
                        this.lat = null;
                    } else {
                        this.lat = lat;
                    }
                    if ((seen0 & 262144) == 0) {
                        this.lbsTs = null;
                    } else {
                        this.lbsTs = lbsTs;
                    }
                    if ((seen0 & 524288) == 0) {
                        this.storyShownIds = null;
                    } else {
                        this.storyShownIds = storyShownIds;
                    }
                    if ((seen0 & 1048576) == 0) {
                        this.apName = null;
                    } else {
                        this.apName = apName;
                    }
                    if ((seen0 & 2097152) == 0) {
                        this.apMac = null;
                    } else {
                        this.apMac = apMac;
                    }
                    if ((seen0 & 4194304) == 0) {
                        this.isKntr = null;
                    } else {
                        this.isKntr = isKntr;
                    }
                    if ((seen0 & 8388608) == 0) {
                        this.imei = null;
                    } else {
                        this.imei = imei;
                    }
                    if ((seen0 & 16777216) == 0) {
                        this.mac = null;
                    } else {
                        this.mac = mac;
                    }
                    if ((seen0 & 33554432) == 0) {
                        this.androidid = null;
                    } else {
                        this.androidid = androidid;
                    }
                    if ((seen0 & 67108864) == 0) {
                        this.oaid = null;
                    } else {
                        this.oaid = oaid;
                    }
                    if ((seen0 & 134217728) == 0) {
                        this.gameId = null;
                    } else {
                        this.gameId = gameId;
                    }
                    if ((seen0 & 268435456) == 0) {
                        this.disk = null;
                    } else {
                        this.disk = disk;
                    }
                    if ((seen0 & 536870912) == 0) {
                        this.hardwareModel = null;
                    } else {
                        this.hardwareModel = hardwareModel;
                    }
                    if ((seen0 & 1073741824) == 0) {
                        this.initialTime = null;
                    } else {
                        this.initialTime = initialTime;
                    }
                    if ((seen0 & Integer.MIN_VALUE) == 0) {
                        this.idfa = null;
                    } else {
                        this.idfa = idfa;
                    }
                    if ((seen1 & 1) == 0) {
                        this.language = null;
                    } else {
                        this.language = language;
                    }
                    if ((seen1 & 2) == 0) {
                        this.machine = null;
                    } else {
                        this.machine = machine;
                    }
                    if ((seen1 & 4) == 0) {
                        this.memory = null;
                    } else {
                        this.memory = memory;
                    }
                    if ((seen1 & 8) == 0) {
                        this.bootTimeInSec = null;
                    } else {
                        this.bootTimeInSec = bootTimeInSec;
                    }
                    if ((seen1 & 16) == 0) {
                        this.carrierInfo = null;
                    } else {
                        this.carrierInfo = carrierInfo;
                    }
                    if ((seen1 & 32) == 0) {
                        this.countryCode = null;
                    } else {
                        this.countryCode = countryCode;
                    }
                    if ((seen1 & 64) == 0) {
                        this.deviceName = null;
                    } else {
                        this.deviceName = deviceName;
                    }
                    if ((seen1 & 128) == 0) {
                        this.sysFileTime = null;
                    } else {
                        this.sysFileTime = sysFileTime;
                    }
                    if ((seen1 & 256) == 0) {
                        this.systemVersion = null;
                    } else {
                        this.systemVersion = systemVersion;
                    }
                    if ((seen1 & 512) == 0) {
                        this.timeZone = null;
                    } else {
                        this.timeZone = timeZone;
                    }
                    this.networkV2 = AdPlatformSpec.INSTANCE.getNetworkV2();
                    this.network = AdPlatformSpec.INSTANCE.getNetwork();
                    this.operatorType = AdPlatformSpec.INSTANCE.getCarrierName();
                    this.vendor = AdPlatformSpec.INSTANCE.getManufacturer();
                    this.model = AdPlatformSpec.INSTANCE.getModel();
                    this.ua = AdPlatformSpec.INSTANCE.getUaWeb();
                    this.uaSys = AdPlatformSpec.INSTANCE.getUaSys();
                    this.mobiApp = AdPlatformSpec.INSTANCE.getMobiApp();
                    this.osV = AdPlatformSpec.INSTANCE.getOsV();
                    this.build = Integer.valueOf(AdPlatformSpec.INSTANCE.getBuild());
                    this.screenSize = AdPlatformSpec.INSTANCE.getScreenSize();
                    this.bootMark = AdPlatformSpec.INSTANCE.getBootMark();
                    this.updateMark = AdPlatformSpec.INSTANCE.getUpdateMark();
                    this.userApps = AdPlatformSpec.INSTANCE.getUserApps();
                    String p0 = AdPlatformSpec.INSTANCE.getDnsClientIp();
                    p0 = (p0 == null || StringsKt.isBlank(p0)) ? null : null;
                    this.dnsClientIp = p0;
                    this.opensdkVer = AdPlatformSpec.INSTANCE.getWxSdkVer();
                    this.lng = AdPlatformSpec.INSTANCE.getLng();
                    this.lat = AdPlatformSpec.INSTANCE.getLat();
                    this.lbsTs = AdPlatformSpec.INSTANCE.getLbsTs();
                    this.storyShownIds = AdPlatformSpec.INSTANCE.getStoryShownIds();
                    this.apName = RoomRecommendViewModel.EMPTY_CURSOR;
                    this.apMac = RoomRecommendViewModel.EMPTY_CURSOR;
                    this.isKntr = "1";
                    switch (WhenMappings.$EnumSwitchMapping$0[KDevice.INSTANCE.getDeviceType().ordinal()]) {
                        case 1:
                            this.imei = AdPlatformSpec.INSTANCE.getImei();
                            this.mac = AdPlatformSpec.INSTANCE.getWifiMacAddress();
                            this.androidid = AdPlatformSpec.INSTANCE.getAndroidId();
                            this.oaid = AdPlatformSpec.INSTANCE.getOaid();
                            this.gameId = AdPlatformSpec.INSTANCE.getGameId();
                            return;
                        case 2:
                            this.bootTimeInSec = AdPlatformSpec.INSTANCE.getBootTimeInSec();
                            this.carrierInfo = AdPlatformSpec.INSTANCE.getCarrierName();
                            this.countryCode = AdPlatformSpec.INSTANCE.getCountryCode();
                            String deviceName2 = AdPlatformSpec.INSTANCE.getDeviceName();
                            if (deviceName2 == null || (md5 = StringExtKt.md5(deviceName2)) == null) {
                                str = null;
                            } else {
                                str = md5.toUpperCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(str, "toUpperCase(...)");
                            }
                            this.deviceName = str;
                            this.disk = AdPlatformSpec.INSTANCE.getTotalDiskCapacity();
                            this.hardwareModel = AdPlatformSpec.INSTANCE.getHardwareModel();
                            this.idfa = AdPlatformSpec.INSTANCE.getIdfa();
                            this.language = AdPlatformSpec.INSTANCE.getLanguage();
                            this.machine = AdPlatformSpec.INSTANCE.getMachine();
                            this.memory = AdPlatformSpec.INSTANCE.getTotalMemory();
                            this.sysFileTime = AdPlatformSpec.INSTANCE.getSysFileTime();
                            this.systemVersion = AdPlatformSpec.INSTANCE.getOsV();
                            this.timeZone = AdPlatformSpec.INSTANCE.getTimeZoneOffset();
                            this.initialTime = AdPlatformSpec.INSTANCE.getInitialTime();
                            return;
                        case 3:
                            this.oaid = AdPlatformSpec.INSTANCE.getOaid();
                            return;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self(Response self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.networkV2 != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.networkV2);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.network != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.network);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.operatorType != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.operatorType);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.vendor != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.vendor);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.model != null) {
                        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.model);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 5) || self.ua != null) {
                        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.ua);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 6) || self.uaSys != null) {
                        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.uaSys);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 7) || self.mobiApp != null) {
                        output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.mobiApp);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 8) || self.osV != null) {
                        output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.osV);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 9) || self.build != null) {
                        output.encodeNullableSerializableElement(serialDesc, 9, IntSerializer.INSTANCE, self.build);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 10) || self.screenSize != null) {
                        output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.screenSize);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 11) || self.bootMark != null) {
                        output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.bootMark);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 12) || self.updateMark != null) {
                        output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.updateMark);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 13) || self.userApps != null) {
                        output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.userApps);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 14) || self.dnsClientIp != null) {
                        output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.dnsClientIp);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 15) || self.opensdkVer != null) {
                        output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.opensdkVer);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 16) || self.lng != null) {
                        output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.lng);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 17) || self.lat != null) {
                        output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.lat);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 18) || self.lbsTs != null) {
                        output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.lbsTs);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 19) || self.storyShownIds != null) {
                        output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.storyShownIds);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 20) || self.apName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 20, StringSerializer.INSTANCE, self.apName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 21) || self.apMac != null) {
                        output.encodeNullableSerializableElement(serialDesc, 21, StringSerializer.INSTANCE, self.apMac);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 22) || self.isKntr != null) {
                        output.encodeNullableSerializableElement(serialDesc, 22, StringSerializer.INSTANCE, self.isKntr);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 23) || self.imei != null) {
                        output.encodeNullableSerializableElement(serialDesc, 23, StringSerializer.INSTANCE, self.imei);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 24) || self.mac != null) {
                        output.encodeNullableSerializableElement(serialDesc, 24, StringSerializer.INSTANCE, self.mac);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 25) || self.androidid != null) {
                        output.encodeNullableSerializableElement(serialDesc, 25, StringSerializer.INSTANCE, self.androidid);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 26) || self.oaid != null) {
                        output.encodeNullableSerializableElement(serialDesc, 26, StringSerializer.INSTANCE, self.oaid);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 27) || self.gameId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 27, StringSerializer.INSTANCE, self.gameId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 28) || self.disk != null) {
                        output.encodeNullableSerializableElement(serialDesc, 28, StringSerializer.INSTANCE, self.disk);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 29) || self.hardwareModel != null) {
                        output.encodeNullableSerializableElement(serialDesc, 29, StringSerializer.INSTANCE, self.hardwareModel);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 30) || self.initialTime != null) {
                        output.encodeNullableSerializableElement(serialDesc, 30, StringSerializer.INSTANCE, self.initialTime);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 31) || self.idfa != null) {
                        output.encodeNullableSerializableElement(serialDesc, 31, StringSerializer.INSTANCE, self.idfa);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 32) || self.language != null) {
                        output.encodeNullableSerializableElement(serialDesc, 32, StringSerializer.INSTANCE, self.language);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 33) || self.machine != null) {
                        output.encodeNullableSerializableElement(serialDesc, 33, StringSerializer.INSTANCE, self.machine);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 34) || self.memory != null) {
                        output.encodeNullableSerializableElement(serialDesc, 34, StringSerializer.INSTANCE, self.memory);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 35) || self.bootTimeInSec != null) {
                        output.encodeNullableSerializableElement(serialDesc, 35, StringSerializer.INSTANCE, self.bootTimeInSec);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 36) || self.carrierInfo != null) {
                        output.encodeNullableSerializableElement(serialDesc, 36, StringSerializer.INSTANCE, self.carrierInfo);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 37) || self.countryCode != null) {
                        output.encodeNullableSerializableElement(serialDesc, 37, StringSerializer.INSTANCE, self.countryCode);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 38) || self.deviceName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 38, StringSerializer.INSTANCE, self.deviceName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 39) || self.sysFileTime != null) {
                        output.encodeNullableSerializableElement(serialDesc, 39, StringSerializer.INSTANCE, self.sysFileTime);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 40) || self.systemVersion != null) {
                        output.encodeNullableSerializableElement(serialDesc, 40, StringSerializer.INSTANCE, self.systemVersion);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 41) || self.timeZone != null) {
                        output.encodeNullableSerializableElement(serialDesc, 41, StringSerializer.INSTANCE, self.timeZone);
                    }
                }
            }

            @Override // kntr.app.ad.domain.adextra.handler.IAdExtraQueryHandler
            public String handle(AdExtraDefaultQuery query) {
                Intrinsics.checkNotNullParameter(query, "query");
                StringFormat $this$encodeToString$iv = JsonExtKt.getAdJson();
                Object value$iv = new Response();
                $this$encodeToString$iv.getSerializersModule();
                return $this$encodeToString$iv.encodeToString(Response.Companion.serializer(), value$iv);
            }
        }