package kntr.app.ad.domain.macrosubst;

import java.util.Locale;
import kntr.app.ad.common.utils.StringExtKt;
import kntr.app.ad.domain.platformspec.AdPlatformSpec;
import kntr.app.ad.domain.report.internal.ReportErrorCode;
import kntr.app.ad.protocol.IMotion;
import kntr.app.ad.protocol.macrosubst.IMacroSubst;
import kntr.app.ad.protocol.report.IReportable;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.device.DeviceType;
import kntr.base.device.KDevice;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* compiled from: AdMacroSubst.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lkntr/app/ad/domain/macrosubst/AdMacroSubst;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Companion", "macrosubst_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdMacroSubst {
    public static final Companion Companion = new Companion(null);

    /* compiled from: AdMacroSubst.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lkntr/app/ad/domain/macrosubst/AdMacroSubst$Companion;", "Lkntr/app/ad/protocol/macrosubst/IMacroSubst;", "<init>", "()V", "process", RoomRecommendViewModel.EMPTY_CURSOR, "url", "adInfo", "Lkntr/app/ad/protocol/report/IReportable;", "ts", "motion", "Lkntr/app/ad/protocol/IMotion;", "macrosubst_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion implements IMacroSubst {

        /* compiled from: AdMacroSubst.kt */
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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // kntr.app.ad.protocol.macrosubst.IMacroSubst
        public String process(String url, IReportable adInfo, String ts, IMotion motion) {
            Number number;
            Number number2;
            Number number3;
            Number number4;
            String str;
            String it;
            String str2;
            String it2;
            String it3;
            String access$replace;
            String str3;
            String it4;
            String it5;
            String str4;
            String md5;
            String str5;
            String it6;
            Intrinsics.checkNotNullParameter(ts, "ts");
            String str6 = url;
            if (str6 == null || StringsKt.isBlank(str6)) {
                return null;
            }
            String access$replace2 = AdMacroSubstKt.access$replace(AdMacroSubstKt.access$replace(url, TuplesKt.to("__REQUESTID__", adInfo != null ? adInfo.getRequestId() : null)), TuplesKt.to("__IP__", adInfo != null ? adInfo.getIp() : null));
            Number $this$orZero$iv = adInfo != null ? Long.valueOf(adInfo.getCreativeId()) : null;
            if ($this$orZero$iv == null) {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    number = (Long) Double.valueOf(0.0d);
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    number = (Long) Float.valueOf(0.0f);
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    number = (Number) 0L;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    number = (Long) 0;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                    number = (Long) (char) 0;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    number = (Long) (short) 0;
                } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                    throw new RuntimeException("not primitive number type");
                } else {
                    number = (Long) (byte) 0;
                }
            } else {
                number = $this$orZero$iv;
            }
            long creativeId = number.longValue();
            if (creativeId > 0) {
                access$replace2 = AdMacroSubstKt.access$replace(access$replace2, TuplesKt.to("__CREATIVEID__", String.valueOf(creativeId)));
            }
            String access$replace3 = AdMacroSubstKt.access$replace(access$replace2, TuplesKt.to("__TRACKID__", adInfo != null ? adInfo.getTrack_id() : null));
            Number $this$orZero$iv2 = adInfo != null ? Long.valueOf(adInfo.getShopId()) : null;
            if ($this$orZero$iv2 == null) {
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Long.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    number2 = (Long) Double.valueOf(0.0d);
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    number2 = (Long) Float.valueOf(0.0f);
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    number2 = (Number) 0L;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    number2 = (Long) 0;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                    number2 = (Long) (char) 0;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    number2 = (Long) (short) 0;
                } else if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                    throw new RuntimeException("not primitive number type");
                } else {
                    number2 = (Long) (byte) 0;
                }
            } else {
                number2 = $this$orZero$iv2;
            }
            long shopId = number2.longValue();
            if (shopId > 0) {
                access$replace3 = AdMacroSubstKt.access$replace(access$replace3, TuplesKt.to("__SHOPID__", String.valueOf(shopId)));
            }
            Number $this$orZero$iv3 = adInfo != null ? Long.valueOf(adInfo.getUpMid()) : null;
            if ($this$orZero$iv3 == null) {
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Long.class);
                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    number3 = (Long) Double.valueOf(0.0d);
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    number3 = (Long) Float.valueOf(0.0f);
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    number3 = (Number) 0L;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    number3 = (Long) 0;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                    number3 = (Long) (char) 0;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    number3 = (Long) (short) 0;
                } else if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                    throw new RuntimeException("not primitive number type");
                } else {
                    number3 = (Long) (byte) 0;
                }
            } else {
                number3 = $this$orZero$iv3;
            }
            long upMid = number3.longValue();
            if (upMid > 0) {
                access$replace3 = AdMacroSubstKt.access$replace(access$replace3, TuplesKt.to("__UPMID__", String.valueOf(upMid)));
            }
            int i = ReportErrorCode.ERROR_UNKNOWN;
            String access$replace4 = AdMacroSubstKt.access$replace(AdMacroSubstKt.access$replace(AdMacroSubstKt.access$replace(AdMacroSubstKt.access$replace(AdMacroSubstKt.access$replace(access$replace3, TuplesKt.to("__WIDTH__", String.valueOf(motion != null ? motion.getWidth() : -999))), TuplesKt.to("__HEIGHT__", String.valueOf(motion != null ? motion.getHeight() : -999))), TuplesKt.to("__DOWN_X__", String.valueOf(motion != null ? motion.getDownX() : -999))), TuplesKt.to("__DOWN_Y__", String.valueOf(motion != null ? motion.getDownY() : -999))), TuplesKt.to("__UP_X__", String.valueOf(motion != null ? motion.getUpX() : -999)));
            if (motion != null) {
                i = motion.getUpY();
            }
            String access$replace5 = AdMacroSubstKt.access$replace(AdMacroSubstKt.access$replace(access$replace4, TuplesKt.to("__UP_Y__", String.valueOf(i))), TuplesKt.to("__OS__", String.valueOf(AdPlatformSpec.INSTANCE.getOs())));
            Number $this$orZero$iv4 = adInfo != null ? Integer.valueOf(adInfo.getReplaceStrategy()) : null;
            if ($this$orZero$iv4 == null) {
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Integer.class);
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    number4 = (Integer) Double.valueOf(0.0d);
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    number4 = (Integer) Float.valueOf(0.0f);
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    number4 = (Integer) 0L;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    number4 = (Number) 0;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                    number4 = (Integer) (char) 0;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    number4 = (Integer) (short) 0;
                } else if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                    throw new RuntimeException("not primitive number type");
                } else {
                    number4 = (Integer) (byte) 0;
                }
            } else {
                number4 = $this$orZero$iv4;
            }
            int strategy = number4.intValue();
            switch (WhenMappings.$EnumSwitchMapping$0[KDevice.INSTANCE.getDeviceType().ordinal()]) {
                case 1:
                    String $this$magicValueByStrategy$iv = AdPlatformSpec.INSTANCE.getAndroidId();
                    if ($this$magicValueByStrategy$iv != null) {
                        switch (strategy) {
                            case 1:
                                str = RoomRecommendViewModel.EMPTY_CURSOR;
                                if (!AdMacroSubstKt.access$isEmptyOrDefault("__ANDROIDID__", $this$magicValueByStrategy$iv)) {
                                    it = StringExtKt.md5($this$magicValueByStrategy$iv);
                                    break;
                                } else {
                                    if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) && !AdMacroSubstKt.access$isInOriginMacroList(url) && !StringsKt.isBlank($this$magicValueByStrategy$iv)) {
                                        it = StringExtKt.md5($this$magicValueByStrategy$iv);
                                        break;
                                    }
                                    it = "__ANDROIDID__";
                                    break;
                                }
                                break;
                            case 2:
                                if (!AdMacroSubstKt.access$isEmptyOrDefault("__ANDROIDID__", $this$magicValueByStrategy$iv)) {
                                    str = RoomRecommendViewModel.EMPTY_CURSOR;
                                    it = StringExtKt.md5($this$magicValueByStrategy$iv);
                                    break;
                                } else {
                                    str = RoomRecommendViewModel.EMPTY_CURSOR;
                                    if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) && !AdMacroSubstKt.access$isInEmptyList(url)) {
                                        if (!StringsKt.isBlank($this$magicValueByStrategy$iv)) {
                                            it = StringExtKt.md5($this$magicValueByStrategy$iv);
                                            break;
                                        }
                                        it = "__ANDROIDID__";
                                        break;
                                    } else {
                                        it = str;
                                        break;
                                    }
                                }
                            default:
                                str = RoomRecommendViewModel.EMPTY_CURSOR;
                                if (!StringsKt.isBlank($this$magicValueByStrategy$iv)) {
                                    it = StringExtKt.md5($this$magicValueByStrategy$iv);
                                    break;
                                }
                                it = "__ANDROIDID__";
                                break;
                        }
                    } else {
                        str = RoomRecommendViewModel.EMPTY_CURSOR;
                        it = null;
                    }
                    String access$replace6 = AdMacroSubstKt.access$replace(access$replace5, TuplesKt.to("__ANDROIDID__", it));
                    String $this$magicValueByStrategy_u24default$iv = AdPlatformSpec.INSTANCE.getOaid();
                    if ($this$magicValueByStrategy_u24default$iv != null) {
                        switch (strategy) {
                            case 1:
                                if (!AdMacroSubstKt.access$isEmptyOrDefault("__OAID__", $this$magicValueByStrategy_u24default$iv)) {
                                    str2 = $this$magicValueByStrategy_u24default$iv;
                                    break;
                                } else {
                                    if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) && !AdMacroSubstKt.access$isInOriginMacroList(url) && !StringsKt.isBlank($this$magicValueByStrategy_u24default$iv)) {
                                        str2 = $this$magicValueByStrategy_u24default$iv;
                                        break;
                                    }
                                    str2 = "__OAID__";
                                    break;
                                }
                                break;
                            case 2:
                                if (!AdMacroSubstKt.access$isEmptyOrDefault("__OAID__", $this$magicValueByStrategy_u24default$iv)) {
                                    str2 = $this$magicValueByStrategy_u24default$iv;
                                    break;
                                } else if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) && !AdMacroSubstKt.access$isInEmptyList(url)) {
                                    if (!StringsKt.isBlank($this$magicValueByStrategy_u24default$iv)) {
                                        str2 = $this$magicValueByStrategy_u24default$iv;
                                        break;
                                    }
                                    str2 = "__OAID__";
                                    break;
                                } else {
                                    str2 = str;
                                    break;
                                }
                            default:
                                if (!StringsKt.isBlank($this$magicValueByStrategy_u24default$iv)) {
                                    str2 = $this$magicValueByStrategy_u24default$iv;
                                    break;
                                }
                                str2 = "__OAID__";
                                break;
                        }
                    } else {
                        str2 = null;
                    }
                    String access$replace7 = AdMacroSubstKt.access$replace(access$replace6, TuplesKt.to("__OAID__", str2));
                    String $this$magicValueByStrategy$iv2 = AdPlatformSpec.INSTANCE.getOaid();
                    if ($this$magicValueByStrategy$iv2 != null) {
                        switch (strategy) {
                            case 1:
                                if (!AdMacroSubstKt.access$isEmptyOrDefault("__OAIDMD5__", $this$magicValueByStrategy$iv2)) {
                                    it2 = StringExtKt.md5($this$magicValueByStrategy$iv2);
                                    break;
                                } else {
                                    if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) && !AdMacroSubstKt.access$isInOriginMacroList(url) && !StringsKt.isBlank($this$magicValueByStrategy$iv2)) {
                                        it2 = StringExtKt.md5($this$magicValueByStrategy$iv2);
                                        break;
                                    }
                                    it2 = "__OAIDMD5__";
                                    break;
                                }
                                break;
                            case 2:
                                if (!AdMacroSubstKt.access$isEmptyOrDefault("__OAIDMD5__", $this$magicValueByStrategy$iv2)) {
                                    it2 = StringExtKt.md5($this$magicValueByStrategy$iv2);
                                    break;
                                } else if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) && !AdMacroSubstKt.access$isInEmptyList(url)) {
                                    if (!StringsKt.isBlank($this$magicValueByStrategy$iv2)) {
                                        it2 = StringExtKt.md5($this$magicValueByStrategy$iv2);
                                        break;
                                    }
                                    it2 = "__OAIDMD5__";
                                    break;
                                } else {
                                    it2 = str;
                                    break;
                                }
                                break;
                            default:
                                if (!StringsKt.isBlank($this$magicValueByStrategy$iv2)) {
                                    it2 = StringExtKt.md5($this$magicValueByStrategy$iv2);
                                    break;
                                }
                                it2 = "__OAIDMD5__";
                                break;
                        }
                    } else {
                        it2 = null;
                    }
                    String access$replace8 = AdMacroSubstKt.access$replace(access$replace7, TuplesKt.to("__OAIDMD5__", it2));
                    String $this$magicValueByStrategy$iv3 = AdPlatformSpec.INSTANCE.getImei();
                    if ($this$magicValueByStrategy$iv3 != null) {
                        switch (strategy) {
                            case 1:
                                if (!AdMacroSubstKt.access$isEmptyOrDefault("__IMEI__", $this$magicValueByStrategy$iv3)) {
                                    it3 = StringExtKt.md5($this$magicValueByStrategy$iv3);
                                    break;
                                } else {
                                    if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) && !AdMacroSubstKt.access$isInOriginMacroList(url) && !StringsKt.isBlank($this$magicValueByStrategy$iv3)) {
                                        it3 = StringExtKt.md5($this$magicValueByStrategy$iv3);
                                        break;
                                    }
                                    it3 = "__IMEI__";
                                    break;
                                }
                                break;
                            case 2:
                                if (!AdMacroSubstKt.access$isEmptyOrDefault("__IMEI__", $this$magicValueByStrategy$iv3)) {
                                    it3 = StringExtKt.md5($this$magicValueByStrategy$iv3);
                                    break;
                                } else if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) && !AdMacroSubstKt.access$isInEmptyList(url)) {
                                    if (!StringsKt.isBlank($this$magicValueByStrategy$iv3)) {
                                        it3 = StringExtKt.md5($this$magicValueByStrategy$iv3);
                                        break;
                                    }
                                    it3 = "__IMEI__";
                                    break;
                                } else {
                                    it3 = str;
                                    break;
                                }
                                break;
                            default:
                                if (!StringsKt.isBlank($this$magicValueByStrategy$iv3)) {
                                    it3 = StringExtKt.md5($this$magicValueByStrategy$iv3);
                                    break;
                                }
                                it3 = "__IMEI__";
                                break;
                        }
                    } else {
                        it3 = null;
                    }
                    access$replace = AdMacroSubstKt.access$replace(access$replace8, TuplesKt.to("__IMEI__", it3));
                    Unit unit = Unit.INSTANCE;
                    break;
                case 2:
                    String $this$magicValueByStrategy_u24default$iv2 = AdPlatformSpec.INSTANCE.getOaid();
                    if ($this$magicValueByStrategy_u24default$iv2 != null) {
                        switch (strategy) {
                            case 1:
                                if (!AdMacroSubstKt.access$isEmptyOrDefault("__IDFA__", $this$magicValueByStrategy_u24default$iv2)) {
                                    str3 = $this$magicValueByStrategy_u24default$iv2;
                                    break;
                                } else {
                                    if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) && !AdMacroSubstKt.access$isInOriginMacroList(url) && !StringsKt.isBlank($this$magicValueByStrategy_u24default$iv2)) {
                                        str3 = $this$magicValueByStrategy_u24default$iv2;
                                        break;
                                    }
                                    str3 = "__IDFA__";
                                    break;
                                }
                                break;
                            case 2:
                                if (!AdMacroSubstKt.access$isEmptyOrDefault("__IDFA__", $this$magicValueByStrategy_u24default$iv2)) {
                                    str3 = $this$magicValueByStrategy_u24default$iv2;
                                    break;
                                } else if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) && !AdMacroSubstKt.access$isInEmptyList(url)) {
                                    if (!StringsKt.isBlank($this$magicValueByStrategy_u24default$iv2)) {
                                        str3 = $this$magicValueByStrategy_u24default$iv2;
                                        break;
                                    }
                                    str3 = "__IDFA__";
                                    break;
                                } else {
                                    str3 = RoomRecommendViewModel.EMPTY_CURSOR;
                                    break;
                                }
                            default:
                                if (!StringsKt.isBlank($this$magicValueByStrategy_u24default$iv2)) {
                                    str3 = $this$magicValueByStrategy_u24default$iv2;
                                    break;
                                }
                                str3 = "__IDFA__";
                                break;
                        }
                    } else {
                        str3 = null;
                    }
                    String access$replace9 = AdMacroSubstKt.access$replace(access$replace5, TuplesKt.to("__IDFA__", str3));
                    String $this$magicValueByStrategy$iv4 = AdPlatformSpec.INSTANCE.getOaid();
                    if ($this$magicValueByStrategy$iv4 != null) {
                        switch (strategy) {
                            case 1:
                                if (!AdMacroSubstKt.access$isEmptyOrDefault("__IDFAMD5__", $this$magicValueByStrategy$iv4)) {
                                    it4 = StringExtKt.md5($this$magicValueByStrategy$iv4);
                                    break;
                                } else {
                                    if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) && !AdMacroSubstKt.access$isInOriginMacroList(url) && !StringsKt.isBlank($this$magicValueByStrategy$iv4)) {
                                        it4 = StringExtKt.md5($this$magicValueByStrategy$iv4);
                                        break;
                                    }
                                    it4 = "__IDFAMD5__";
                                    break;
                                }
                                break;
                            case 2:
                                if (!AdMacroSubstKt.access$isEmptyOrDefault("__IDFAMD5__", $this$magicValueByStrategy$iv4)) {
                                    it4 = StringExtKt.md5($this$magicValueByStrategy$iv4);
                                    break;
                                } else if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) && !AdMacroSubstKt.access$isInEmptyList(url)) {
                                    if (!StringsKt.isBlank($this$magicValueByStrategy$iv4)) {
                                        it4 = StringExtKt.md5($this$magicValueByStrategy$iv4);
                                        break;
                                    }
                                    it4 = "__IDFAMD5__";
                                    break;
                                } else {
                                    it4 = RoomRecommendViewModel.EMPTY_CURSOR;
                                    break;
                                }
                                break;
                            default:
                                if (!StringsKt.isBlank($this$magicValueByStrategy$iv4)) {
                                    it4 = StringExtKt.md5($this$magicValueByStrategy$iv4);
                                    break;
                                }
                                it4 = "__IDFAMD5__";
                                break;
                        }
                    } else {
                        it4 = null;
                    }
                    access$replace = AdMacroSubstKt.access$replace(access$replace9, TuplesKt.to("__IDFAMD5__", it4));
                    Unit unit2 = Unit.INSTANCE;
                    str = RoomRecommendViewModel.EMPTY_CURSOR;
                    break;
                case 3:
                    String $this$magicValueByStrategy_u24default$iv3 = AdPlatformSpec.INSTANCE.getOaid();
                    if ($this$magicValueByStrategy_u24default$iv3 != null) {
                        switch (strategy) {
                            case 1:
                                if (!AdMacroSubstKt.access$isEmptyOrDefault("__OAID__", $this$magicValueByStrategy_u24default$iv3)) {
                                    str5 = $this$magicValueByStrategy_u24default$iv3;
                                    break;
                                } else {
                                    if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) && !AdMacroSubstKt.access$isInOriginMacroList(url) && !StringsKt.isBlank($this$magicValueByStrategy_u24default$iv3)) {
                                        str5 = $this$magicValueByStrategy_u24default$iv3;
                                        break;
                                    }
                                    str5 = "__OAID__";
                                    break;
                                }
                                break;
                            case 2:
                                if (!AdMacroSubstKt.access$isEmptyOrDefault("__OAID__", $this$magicValueByStrategy_u24default$iv3)) {
                                    str5 = $this$magicValueByStrategy_u24default$iv3;
                                    break;
                                } else if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) && !AdMacroSubstKt.access$isInEmptyList(url)) {
                                    if (!StringsKt.isBlank($this$magicValueByStrategy_u24default$iv3)) {
                                        str5 = $this$magicValueByStrategy_u24default$iv3;
                                        break;
                                    }
                                    str5 = "__OAID__";
                                    break;
                                } else {
                                    str5 = RoomRecommendViewModel.EMPTY_CURSOR;
                                    break;
                                }
                            default:
                                if (!StringsKt.isBlank($this$magicValueByStrategy_u24default$iv3)) {
                                    str5 = $this$magicValueByStrategy_u24default$iv3;
                                    break;
                                }
                                str5 = "__OAID__";
                                break;
                        }
                    } else {
                        str5 = null;
                    }
                    String access$replace10 = AdMacroSubstKt.access$replace(access$replace5, TuplesKt.to("__OAID__", str5));
                    String $this$magicValueByStrategy$iv5 = AdPlatformSpec.INSTANCE.getOaid();
                    if ($this$magicValueByStrategy$iv5 != null) {
                        switch (strategy) {
                            case 1:
                                if (!AdMacroSubstKt.access$isEmptyOrDefault("__OAIDMD5__", $this$magicValueByStrategy$iv5)) {
                                    it6 = StringExtKt.md5($this$magicValueByStrategy$iv5);
                                    break;
                                } else {
                                    if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) && !AdMacroSubstKt.access$isInOriginMacroList(url) && !StringsKt.isBlank($this$magicValueByStrategy$iv5)) {
                                        it6 = StringExtKt.md5($this$magicValueByStrategy$iv5);
                                        break;
                                    }
                                    it6 = "__OAIDMD5__";
                                    break;
                                }
                            case 2:
                                if (!AdMacroSubstKt.access$isEmptyOrDefault("__OAIDMD5__", $this$magicValueByStrategy$iv5)) {
                                    it6 = StringExtKt.md5($this$magicValueByStrategy$iv5);
                                    break;
                                } else if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) && !AdMacroSubstKt.access$isInEmptyList(url)) {
                                    if (!StringsKt.isBlank($this$magicValueByStrategy$iv5)) {
                                        it6 = StringExtKt.md5($this$magicValueByStrategy$iv5);
                                        break;
                                    }
                                    it6 = "__OAIDMD5__";
                                    break;
                                } else {
                                    it6 = RoomRecommendViewModel.EMPTY_CURSOR;
                                    break;
                                }
                            default:
                                if (!StringsKt.isBlank($this$magicValueByStrategy$iv5)) {
                                    it6 = StringExtKt.md5($this$magicValueByStrategy$iv5);
                                    break;
                                }
                                it6 = "__OAIDMD5__";
                                break;
                        }
                    } else {
                        it6 = null;
                    }
                    access$replace = AdMacroSubstKt.access$replace(access$replace10, TuplesKt.to("__OAIDMD5__", it6));
                    Unit unit3 = Unit.INSTANCE;
                    str = RoomRecommendViewModel.EMPTY_CURSOR;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            String mac = AdPlatformSpec.INSTANCE.getWifiMacAddress();
            if (mac != null) {
                switch (strategy) {
                    case 1:
                        if (!AdMacroSubstKt.access$isEmptyOrDefault("__MAC__", mac)) {
                            String it7 = mac == null ? str : mac;
                            String upperCase = AdMacroSubstKt.access$getNoColonMacString(it7).toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                            it5 = StringExtKt.md5(upperCase);
                            break;
                        } else {
                            if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) && !AdMacroSubstKt.access$isInOriginMacroList(url)) {
                                String str7 = mac;
                                if (!(str7 == null || StringsKt.isBlank(str7))) {
                                    String upperCase2 = AdMacroSubstKt.access$getNoColonMacString(mac).toUpperCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                                    it5 = StringExtKt.md5(upperCase2);
                                    break;
                                }
                            }
                            it5 = "__MAC__";
                            break;
                        }
                    case 2:
                        if (!AdMacroSubstKt.access$isEmptyOrDefault("__MAC__", mac)) {
                            String it8 = mac == null ? str : mac;
                            String upperCase3 = AdMacroSubstKt.access$getNoColonMacString(it8).toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(upperCase3, "toUpperCase(...)");
                            it5 = StringExtKt.md5(upperCase3);
                            break;
                        } else {
                            if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) && !AdMacroSubstKt.access$isInEmptyList(url)) {
                                String str8 = mac;
                                if (!(str8 == null || StringsKt.isBlank(str8))) {
                                    String upperCase4 = AdMacroSubstKt.access$getNoColonMacString(mac).toUpperCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(upperCase4, "toUpperCase(...)");
                                    it5 = StringExtKt.md5(upperCase4);
                                    break;
                                } else {
                                    it5 = "__MAC__";
                                    break;
                                }
                            }
                            it5 = str;
                            break;
                        }
                        break;
                    default:
                        String str9 = mac;
                        if (!(str9 == null || StringsKt.isBlank(str9))) {
                            String upperCase5 = AdMacroSubstKt.access$getNoColonMacString(mac).toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(upperCase5, "toUpperCase(...)");
                            it5 = StringExtKt.md5(upperCase5);
                            break;
                        }
                        it5 = "__MAC__";
                        break;
                }
            } else {
                it5 = null;
            }
            String access$replace11 = AdMacroSubstKt.access$replace(access$replace, TuplesKt.to("__MAC__", it5));
            if (mac != null) {
                switch (strategy) {
                    case 1:
                        if (!AdMacroSubstKt.access$isEmptyOrDefault("__MAC1__", mac)) {
                            if (mac != null) {
                                str = mac;
                            }
                            String it9 = str;
                            String upperCase6 = it9.toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(upperCase6, "toUpperCase(...)");
                            md5 = StringExtKt.md5(upperCase6);
                            break;
                        } else {
                            boolean z = false;
                            if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) && !AdMacroSubstKt.access$isInOriginMacroList(url)) {
                                String str10 = mac;
                                if (!((str10 == null || StringsKt.isBlank(str10)) ? true : true)) {
                                    String upperCase7 = mac.toUpperCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(upperCase7, "toUpperCase(...)");
                                    md5 = StringExtKt.md5(upperCase7);
                                    break;
                                }
                            }
                            md5 = "__MAC1__";
                            break;
                        }
                        break;
                    case 2:
                        if (!AdMacroSubstKt.access$isEmptyOrDefault("__MAC1__", mac)) {
                            if (mac != null) {
                                str = mac;
                            }
                            String it10 = str;
                            String upperCase8 = it10.toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(upperCase8, "toUpperCase(...)");
                            md5 = StringExtKt.md5(upperCase8);
                            break;
                        } else if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) && !AdMacroSubstKt.access$isInEmptyList(url)) {
                            String str11 = mac;
                            if (!(str11 == null || StringsKt.isBlank(str11))) {
                                String upperCase9 = mac.toUpperCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(upperCase9, "toUpperCase(...)");
                                md5 = StringExtKt.md5(upperCase9);
                                break;
                            }
                            md5 = "__MAC1__";
                            break;
                        } else {
                            md5 = str;
                            break;
                        }
                        break;
                    default:
                        boolean z2 = false;
                        String str12 = mac;
                        if (!((str12 == null || StringsKt.isBlank(str12)) ? true : true)) {
                            String upperCase10 = mac.toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(upperCase10, "toUpperCase(...)");
                            md5 = StringExtKt.md5(upperCase10);
                            break;
                        }
                        md5 = "__MAC1__";
                        break;
                }
                str4 = md5;
            } else {
                str4 = null;
            }
            String access$replace12 = AdMacroSubstKt.access$replace(access$replace11, TuplesKt.to("__MAC1__", str4));
            Unit unit4 = Unit.INSTANCE;
            return AdMacroSubstKt.access$replace(AdMacroSubstKt.access$replace(AdMacroSubstKt.access$replace(AdMacroSubstKt.access$replace(access$replace12, TuplesKt.to("__UA__", AdPlatformSpec.INSTANCE.getUaWeb())), TuplesKt.to("__TS__", ts.toString())), TuplesKt.to("__MID__", String.valueOf(AdPlatformSpec.INSTANCE.getMid()))), TuplesKt.to("__BUVID__", AdPlatformSpec.INSTANCE.getBuvid()));
        }
    }
}