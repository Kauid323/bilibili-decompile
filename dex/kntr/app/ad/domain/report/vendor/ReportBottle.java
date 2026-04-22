package kntr.app.ad.domain.report.vendor;

import kntr.app.ad.common.utils.StringExtKt;
import kntr.app.ad.domain.platformspec.AdPlatformSpec;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.ad.domain.report.internal.ReportExtraHandler;
import kntr.app.ad.protocol.report.IReportable;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.device.DeviceType;
import kntr.base.device.KDevice;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReportBottle.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0016J\u001b\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\nH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/app/ad/domain/report/vendor/ReportBottle;", "Lkntr/app/ad/domain/report/vendor/IReportBottle;", "reportable", "Lkntr/app/ad/protocol/report/IReportable;", "<init>", "(Lkntr/app/ad/protocol/report/IReportable;)V", "getBuildIn", "Lkotlin/Function1;", "Lkntr/app/ad/domain/report/internal/ReportExtraHandler;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/ExtensionFunctionType;", "getPreset", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReportBottle implements IReportBottle {
    private final IReportable reportable;

    /* compiled from: ReportBottle.kt */
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

    public ReportBottle(IReportable reportable) {
        this.reportable = reportable;
    }

    @Override // kntr.app.ad.domain.report.vendor.IReportBottle
    public Function1<ReportExtraHandler, Unit> getBuildIn() {
        final AdPlatformSpec it = AdPlatformSpec.INSTANCE;
        return new Function1() { // from class: kntr.app.ad.domain.report.vendor.ReportBottle$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit buildIn$lambda$0$0;
                buildIn$lambda$0$0 = ReportBottle.getBuildIn$lambda$0$0(AdPlatformSpec.this, (ReportExtraHandler) obj);
                return buildIn$lambda$0$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getBuildIn$lambda$0$0(AdPlatformSpec $it, ReportExtraHandler $this$let) {
        Intrinsics.checkNotNullParameter($this$let, "$this$let");
        $this$let.put$report_debug(ReportBuildInParam.OS, $it.getOs());
        $this$let.put(ReportBuildInParam.OS_V, $it.getOsV());
        $this$let.put(ReportBuildInParam.TERM, $it.getManufacturer());
        $this$let.put(ReportBuildInParam.VENDOR, $it.getManufacturer());
        $this$let.put$report_debug(ReportBuildInParam.MID, $it.getMid());
        $this$let.put(ReportBuildInParam.BUVID, $it.getBuvid());
        $this$let.put(ReportBuildInParam.UA, $it.getUaWeb());
        $this$let.put(ReportBuildInParam.UA_SYS, $it.getUaSys());
        $this$let.put$report_debug(ReportBuildInParam.CLIENT_VERSION, $it.getBuild());
        $this$let.put(ReportBuildInParam.NETWORK, $it.getNetwork());
        $this$let.put(ReportBuildInParam.LNG, $it.getLng());
        $this$let.put(ReportBuildInParam.LAT, $it.getLat());
        $this$let.put(ReportBuildInParam.LBS_TS, $it.getLbsTs());
        $this$let.put(ReportBuildInParam.OPERATOR_TYPE, $it.getCarrierName());
        $this$let.put(ReportBuildInParam.SCREEN_SIZE, $it.getScreenSize());
        $this$let.put(ReportBuildInParam.MOBI_APP, $it.getMobiApp());
        $this$let.put$report_debug(ReportBuildInParam.BUILD, $it.getBuild());
        $this$let.put$report_debug(ReportBuildInParam.BUILD_ID, $it.getBuild());
        $this$let.put(ReportBuildInParam.DNS_CLIENT_IP, $it.getDnsClientIp());
        $this$let.put(ReportBuildInParam.MODEL, $it.getModel());
        switch (WhenMappings.$EnumSwitchMapping$0[KDevice.INSTANCE.getDeviceType().ordinal()]) {
            case 1:
                $this$let.put(ReportBuildInParam.OAID, $it.getOaid());
                $this$let.put(ReportBuildInParam.IMEI, $it.getImei());
                $this$let.put(ReportBuildInParam.MAC, $it.getWifiMacAddress());
                $this$let.put(ReportBuildInParam.ANDROID_ID, $it.getAndroidId());
                $this$let.put(ReportBuildInParam.GAME_ID, $it.getGameId());
                break;
            case 2:
                $this$let.put(ReportBuildInParam.IDFA, $it.getIdfa());
                $this$let.put(ReportBuildInParam.INITIAL_TIME, $it.getInitialTime());
                $this$let.put(ReportBuildInParam.BOOT_TIME_IN_SEC, $it.getBootTimeInSec());
                $this$let.put(ReportBuildInParam.COUNTRY_CODE, $it.getCountryCode());
                $this$let.put(ReportBuildInParam.LANGUAGE, $it.getLanguage());
                String deviceName = $it.getDeviceName();
                $this$let.put(ReportBuildInParam.DEVICE_NAME, deviceName != null ? StringExtKt.md5(deviceName) : null);
                $this$let.put(ReportBuildInParam.MACHINE, $it.getMachine());
                $this$let.put(ReportBuildInParam.MEMORY, $it.getTotalMemory());
                $this$let.put(ReportBuildInParam.DISK, $it.getTotalDiskCapacity());
                $this$let.put(ReportBuildInParam.SYS_FILE_TIME, $it.getSysFileTime());
                $this$let.put(ReportBuildInParam.HARDWARE_MODEL, $it.getHardwareModel());
                $this$let.put(ReportBuildInParam.TIME_ZONE, $it.getTimeZoneOffset());
                break;
            case 3:
                $this$let.put(ReportBuildInParam.OAID, $it.getOaid());
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }

    @Override // kntr.app.ad.domain.report.vendor.IReportBottle
    public Function1<ReportExtraHandler, Unit> getPreset() {
        final IReportable it = this.reportable;
        if (it != null) {
            return new Function1() { // from class: kntr.app.ad.domain.report.vendor.ReportBottle$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit preset$lambda$0$0;
                    preset$lambda$0$0 = ReportBottle.getPreset$lambda$0$0(IReportable.this, (ReportExtraHandler) obj);
                    return preset$lambda$0$0;
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPreset$lambda$0$0(IReportable $it, ReportExtraHandler $this$let) {
        Intrinsics.checkNotNullParameter($this$let, "$this$let");
        int isAdLoc = $it.isAdLoc() ? 1 : 0;
        $this$let.put$report_debug(ReportBuildInParam.IS_AD, isAdLoc);
        $this$let.put("ad_cb", $it.getAdCb());
        $this$let.put$report_debug(ReportBuildInParam.SRC_ID, $it.getSourceId());
        $this$let.put(ReportBuildInParam.REQUEST_ID, $it.getRequestId());
        $this$let.put$report_debug(ReportBuildInParam.CREATIVE_ID, $it.getCreativeId());
        $this$let.put(ReportBuildInParam.IP, $it.getIp());
        $this$let.put$report_debug(ReportBuildInParam.RESOURCE_ID, $it.getResourceId());
        $this$let.put$report_debug(ReportBuildInParam.IDX, $it.getIndex());
        $this$let.put$report_debug(ReportBuildInParam.CARD_INDEX, $it.getCardIndex());
        $this$let.put$report_debug(ReportBuildInParam.SERVER_TYPE, $it.getServerType());
        $this$let.put$report_debug(ReportBuildInParam.CM_MARK, $it.getCmMark());
        $this$let.put$report_debug(ReportBuildInParam.CREATIVE_TYPE, $it.getCreativeType());
        $this$let.put$report_debug(ReportBuildInParam.CREATIVE_STYLE, $it.getCreativeStyle());
        $this$let.put("track_id", $it.getTrack_id());
        $this$let.put$report_debug(ReportBuildInParam.SHOP_ID, $it.getShopId());
        $this$let.put$report_debug(ReportBuildInParam.UP_MID, $it.getUpMid());
        $this$let.put$report_debug(ReportBuildInParam.PRODUCT_ID, $it.getProductId());
        $this$let.put(ReportBuildInParam.FROM_TRACK_ID, $it.getFromTrackId());
        $this$let.put("cm_from_track_id", $it.getCmFromTrackId());
        Long valueOf = Long.valueOf($it.getItemId());
        long it = valueOf.longValue();
        if (!(it != 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            long itemId = valueOf.longValue();
            $this$let.put$report_debug(ReportBuildInParam.ITEM_ID, itemId);
        }
        $this$let.put$report_debug(ReportBuildInParam.ITEM_SOURCE, $it.getItemSource());
        $this$let.put(ReportBuildInParam.EXTRA_PARAMS, $it.getExtraParams());
        $this$let.put$report_debug(ReportBuildInParam.ID, $it.getId());
        $this$let.put$report_debug(ReportBuildInParam.NATURE_AD, $it.getNatureAd());
        $this$let.put(ReportBuildInParam.CARD_TYPE, $it.getCardType());
        $this$let.put(ReportBuildInParam.AV_ID, String.valueOf($it.getAvid()));
        $this$let.put$report_debug(ReportBuildInParam.BUTTON_SHOW, $it.getButtonShow());
        return Unit.INSTANCE;
    }
}