package kntr.app.ad.domain.macrosubst;

import java.util.Iterator;
import java.util.Map;
import kntr.app.ad.common.model.MMAReplaceDefault;
import kntr.app.ad.common.model.MMAReplaceUrls;
import kntr.app.ad.common.utils.StringExt_androidKt;
import kntr.app.ad.domain.config.AdConfigKt;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.device.DeviceType;
import kntr.base.device.KDevice;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AdMacroSubst.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\u001a\"\u0010\u001c\u001a\u00020\u0001*\u00020\u00012\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001eH\u0002\u001a\u0010\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u0001H\u0002\u001a=\u0010!\u001a\u00020\u0001*\u0004\u0018\u00010\u00012\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u00012\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010&H\u0082\b\u001a\u001a\u0010'\u001a\u00020(2\u0006\u0010\"\u001a\u00020\u00012\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0019\u0010*\u001a\u00020(*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010+H\u0002¢\u0006\u0002\u0010,\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010-\u001a\u00020(*\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.\"\u0018\u0010/\u001a\u00020(*\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u0010.\"\u001d\u00100\u001a\u0004\u0018\u0001018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b2\u00103\"5\u00106\u001a\u001c\u0012\u0004\u0012\u00020\u0001\u0012\u0010\u0012\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010+\u0018\u0001078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00105\u001a\u0004\b8\u00109¨\u0006;"}, d2 = {AdMacroSubstKt.__OS__, RoomRecommendViewModel.EMPTY_CURSOR, AdMacroSubstKt.__MAC__, AdMacroSubstKt.__MAC1__, AdMacroSubstKt.__UA__, AdMacroSubstKt.__TS__, AdMacroSubstKt.__MID__, AdMacroSubstKt.__BUVID__, AdMacroSubstKt.__WIDTH__, AdMacroSubstKt.__HEIGHT__, AdMacroSubstKt.__DOWN_X__, AdMacroSubstKt.__DOWN_Y__, AdMacroSubstKt.__UP_X__, AdMacroSubstKt.__UP_Y__, AdMacroSubstKt.__REQUESTID__, AdMacroSubstKt.__IP__, AdMacroSubstKt.__TRACKID__, AdMacroSubstKt.__CREATIVEID__, AdMacroSubstKt.__SHOPID__, AdMacroSubstKt.__UPMID__, AdMacroSubstKt.__ANDROIDID__, AdMacroSubstKt.__IMEI__, AdMacroSubstKt.__OAID__, AdMacroSubstKt.__OAIDMD5__, AdMacroSubstKt.__IDFA__, AdMacroSubstKt.__IDFAMD5__, "NO_MOTION_VALUE", RoomRecommendViewModel.EMPTY_CURSOR, "replace", "pair", "Lkotlin/Pair;", "getNoColonMacString", ReportBuildInParam.MAC, "magicValueByStrategy", "tag", "strategy", "url", "transformer", "Lkotlin/Function1;", "isEmptyOrDefault", RoomRecommendViewModel.EMPTY_CURSOR, "value", "isPostern", RoomRecommendViewModel.EMPTY_CURSOR, "([Ljava/lang/String;)Z", "isInOriginMacroList", "(Ljava/lang/String;)Z", "isInEmptyList", "mmaReplaceUrls", "Lkntr/app/ad/common/model/MMAReplaceUrls;", "getMmaReplaceUrls", "()Lkntr/app/ad/common/model/MMAReplaceUrls;", "mmaReplaceUrls$delegate", "Lkotlin/Lazy;", "mmaReplaceDefault", RoomRecommendViewModel.EMPTY_CURSOR, "getMmaReplaceDefault", "()Ljava/util/Map;", "mmaReplaceDefault$delegate", "macrosubst_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdMacroSubstKt {
    private static final int NO_MOTION_VALUE = -999;
    private static final String __ANDROIDID__ = "__ANDROIDID__";
    private static final String __BUVID__ = "__BUVID__";
    private static final String __CREATIVEID__ = "__CREATIVEID__";
    private static final String __DOWN_X__ = "__DOWN_X__";
    private static final String __DOWN_Y__ = "__DOWN_Y__";
    private static final String __HEIGHT__ = "__HEIGHT__";
    private static final String __IDFAMD5__ = "__IDFAMD5__";
    private static final String __IDFA__ = "__IDFA__";
    private static final String __IMEI__ = "__IMEI__";
    private static final String __IP__ = "__IP__";
    private static final String __MAC1__ = "__MAC1__";
    private static final String __MAC__ = "__MAC__";
    private static final String __MID__ = "__MID__";
    private static final String __OAIDMD5__ = "__OAIDMD5__";
    private static final String __OAID__ = "__OAID__";
    private static final String __OS__ = "__OS__";
    private static final String __REQUESTID__ = "__REQUESTID__";
    private static final String __SHOPID__ = "__SHOPID__";
    private static final String __TRACKID__ = "__TRACKID__";
    private static final String __TS__ = "__TS__";
    private static final String __UA__ = "__UA__";
    private static final String __UPMID__ = "__UPMID__";
    private static final String __UP_X__ = "__UP_X__";
    private static final String __UP_Y__ = "__UP_Y__";
    private static final String __WIDTH__ = "__WIDTH__";
    private static final Lazy mmaReplaceUrls$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.macrosubst.AdMacroSubstKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            MMAReplaceUrls mmaReplaceUrls_delegate$lambda$0;
            mmaReplaceUrls_delegate$lambda$0 = AdMacroSubstKt.mmaReplaceUrls_delegate$lambda$0();
            return mmaReplaceUrls_delegate$lambda$0;
        }
    });
    private static final Lazy mmaReplaceDefault$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.macrosubst.AdMacroSubstKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            Map mmaReplaceDefault_delegate$lambda$0;
            mmaReplaceDefault_delegate$lambda$0 = AdMacroSubstKt.mmaReplaceDefault_delegate$lambda$0();
            return mmaReplaceDefault_delegate$lambda$0;
        }
    });

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

    public static final /* synthetic */ String access$getNoColonMacString(String mac) {
        return getNoColonMacString(mac);
    }

    public static final /* synthetic */ boolean access$isEmptyOrDefault(String tag, String value) {
        return isEmptyOrDefault(tag, value);
    }

    public static final /* synthetic */ boolean access$isInEmptyList(String $receiver) {
        return isInEmptyList($receiver);
    }

    public static final /* synthetic */ boolean access$isInOriginMacroList(String $receiver) {
        return isInOriginMacroList($receiver);
    }

    public static final /* synthetic */ String access$replace(String $receiver, Pair pair) {
        return replace($receiver, pair);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x001b, code lost:
        if (r0 != null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String replace(String $this$replace, Pair<String, String> pair) {
        String value;
        String it = (String) pair.getSecond();
        if (it != null) {
            if (StringsKt.isBlank(it)) {
                it = null;
            }
            if (it != null) {
                value = StringExt_androidKt.urlEncode(it);
            }
        }
        value = (String) pair.getSecond();
        return StringsKt.replace$default($this$replace, (String) pair.getFirst(), value == null ? RoomRecommendViewModel.EMPTY_CURSOR : value, false, 4, (Object) null);
    }

    public static final String getNoColonMacString(String mac) {
        if (StringsKt.contains$default(mac, ":", false, 2, (Object) null)) {
            String result = StringsKt.replace$default(mac, ":", RoomRecommendViewModel.EMPTY_CURSOR, false, 4, (Object) null);
            return result;
        }
        return mac;
    }

    static /* synthetic */ String magicValueByStrategy$default(String $this$magicValueByStrategy_u24default, String tag, int strategy, String url, Function1 transformer, int i, Object obj) {
        if ((i & 8) != 0) {
            Function1 transformer2 = new Function1<String, String>() { // from class: kntr.app.ad.domain.macrosubst.AdMacroSubstKt$magicValueByStrategy$1
                public final String invoke(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it;
                }
            };
            transformer = transformer2;
        }
        String str = RoomRecommendViewModel.EMPTY_CURSOR;
        boolean z = true;
        switch (strategy) {
            case 1:
                if (isEmptyOrDefault(tag, $this$magicValueByStrategy_u24default)) {
                    if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) && !isInOriginMacroList(url)) {
                        String str2 = $this$magicValueByStrategy_u24default;
                        if (str2 != null && !StringsKt.isBlank(str2)) {
                            z = false;
                        }
                        if (!z) {
                            return (String) transformer.invoke($this$magicValueByStrategy_u24default);
                        }
                    }
                } else {
                    if ($this$magicValueByStrategy_u24default != null) {
                        str = $this$magicValueByStrategy_u24default;
                    }
                    return (String) transformer.invoke(str);
                }
                break;
            case 2:
                if (isEmptyOrDefault(tag, $this$magicValueByStrategy_u24default)) {
                    if (!StringsKt.startsWith$default(url, "http", false, 2, (Object) null) || isInEmptyList(url)) {
                        return RoomRecommendViewModel.EMPTY_CURSOR;
                    }
                    String str3 = $this$magicValueByStrategy_u24default;
                    if (str3 != null && !StringsKt.isBlank(str3)) {
                        z = false;
                    }
                    if (!z) {
                        return (String) transformer.invoke($this$magicValueByStrategy_u24default);
                    }
                } else {
                    if ($this$magicValueByStrategy_u24default != null) {
                        str = $this$magicValueByStrategy_u24default;
                    }
                    return (String) transformer.invoke(str);
                }
                break;
            default:
                String str4 = $this$magicValueByStrategy_u24default;
                if (str4 != null && !StringsKt.isBlank(str4)) {
                    z = false;
                }
                if (!z) {
                    return (String) transformer.invoke($this$magicValueByStrategy_u24default);
                }
                break;
        }
        return tag;
    }

    private static final String magicValueByStrategy(String $this$magicValueByStrategy, String tag, int strategy, String url, Function1<? super String, String> function1) {
        String str = RoomRecommendViewModel.EMPTY_CURSOR;
        boolean z = true;
        switch (strategy) {
            case 1:
                if (isEmptyOrDefault(tag, $this$magicValueByStrategy)) {
                    if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) && !isInOriginMacroList(url)) {
                        String str2 = $this$magicValueByStrategy;
                        if (str2 != null && !StringsKt.isBlank(str2)) {
                            z = false;
                        }
                        if (!z) {
                            return (String) function1.invoke($this$magicValueByStrategy);
                        }
                    }
                } else {
                    if ($this$magicValueByStrategy != null) {
                        str = $this$magicValueByStrategy;
                    }
                    return (String) function1.invoke(str);
                }
                break;
            case 2:
                if (isEmptyOrDefault(tag, $this$magicValueByStrategy)) {
                    if (!StringsKt.startsWith$default(url, "http", false, 2, (Object) null) || isInEmptyList(url)) {
                        return RoomRecommendViewModel.EMPTY_CURSOR;
                    }
                    String str3 = $this$magicValueByStrategy;
                    if (str3 != null && !StringsKt.isBlank(str3)) {
                        z = false;
                    }
                    if (!z) {
                        return (String) function1.invoke($this$magicValueByStrategy);
                    }
                } else {
                    if ($this$magicValueByStrategy != null) {
                        str = $this$magicValueByStrategy;
                    }
                    return (String) function1.invoke(str);
                }
                break;
            default:
                String str4 = $this$magicValueByStrategy;
                if (str4 != null && !StringsKt.isBlank(str4)) {
                    z = false;
                }
                if (!z) {
                    return (String) function1.invoke($this$magicValueByStrategy);
                }
                break;
        }
        return tag;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x005e A[EDGE_INSN: B:76:0x005e->B:72:0x005e ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean isEmptyOrDefault(String tag, String value) {
        int i;
        String str = value;
        boolean z = true;
        if (str == null || StringsKt.isBlank(str)) {
            return true;
        }
        Map $this$any$iv = getMmaReplaceDefault();
        if ($this$any$iv != null) {
            if (!$this$any$iv.isEmpty()) {
                Iterator<Map.Entry<String, String[]>> it = $this$any$iv.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Map.Entry element$iv = it.next();
                        String k = element$iv.getKey();
                        String[] v = element$iv.getValue();
                        if (Intrinsics.areEqual(k, tag)) {
                            if (v != null && ArraysKt.contains(v, value)) {
                                i = 1;
                                continue;
                                if (i != 0) {
                                    break;
                                }
                            }
                        }
                        i = 0;
                        continue;
                        if (i != 0) {
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            } else {
                z = false;
            }
            return z;
        }
        return false;
    }

    private static final boolean isPostern(String[] $this$isPostern) {
        for (String str : $this$isPostern) {
            if (Intrinsics.areEqual(str, "*")) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean isInOriginMacroList(String $this$isInOriginMacroList) {
        boolean z;
        String[] originMacroList;
        Object[] $this$any$iv;
        Object[] $this$any$iv2;
        MMAReplaceUrls mmaReplaceUrls = getMmaReplaceUrls();
        if (mmaReplaceUrls != null && ($this$any$iv = mmaReplaceUrls.getOriginMacroList()) != null) {
            int length = $this$any$iv.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    Object element$iv = $this$any$iv[i];
                    String it = (element$iv == null || !StringsKt.contains$default($this$isInOriginMacroList, (CharSequence) element$iv, false, 2, (Object) null)) ? null : 1;
                    if (it != null) {
                        $this$any$iv2 = 1;
                        break;
                    }
                    i++;
                } else {
                    $this$any$iv2 = null;
                    break;
                }
            }
            if ($this$any$iv2 == 1) {
                z = true;
                if (z) {
                    MMAReplaceUrls mmaReplaceUrls2 = getMmaReplaceUrls();
                    return mmaReplaceUrls2 != null && (originMacroList = mmaReplaceUrls2.getOriginMacroList()) != null && isPostern(originMacroList);
                }
                return true;
            }
        }
        z = false;
        if (z) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean isInEmptyList(String $this$isInEmptyList) {
        boolean z;
        String[] emptyList;
        Object[] $this$any$iv;
        Object[] $this$any$iv2;
        MMAReplaceUrls mmaReplaceUrls = getMmaReplaceUrls();
        if (mmaReplaceUrls != null && ($this$any$iv = mmaReplaceUrls.getEmptyList()) != null) {
            int length = $this$any$iv.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    Object element$iv = $this$any$iv[i];
                    String it = (element$iv == null || !StringsKt.contains$default($this$isInEmptyList, (CharSequence) element$iv, false, 2, (Object) null)) ? null : 1;
                    if (it != null) {
                        $this$any$iv2 = 1;
                        break;
                    }
                    i++;
                } else {
                    $this$any$iv2 = null;
                    break;
                }
            }
            if ($this$any$iv2 == 1) {
                z = true;
                if (z) {
                    MMAReplaceUrls mmaReplaceUrls2 = getMmaReplaceUrls();
                    return mmaReplaceUrls2 != null && (emptyList = mmaReplaceUrls2.getEmptyList()) != null && isPostern(emptyList);
                }
                return true;
            }
        }
        z = false;
        if (z) {
        }
    }

    private static final MMAReplaceUrls getMmaReplaceUrls() {
        return (MMAReplaceUrls) mmaReplaceUrls$delegate.getValue();
    }

    public static final MMAReplaceUrls mmaReplaceUrls_delegate$lambda$0() {
        return AdConfigKt.getMmaReplaceUrls();
    }

    private static final Map<String, String[]> getMmaReplaceDefault() {
        return (Map) mmaReplaceDefault$delegate.getValue();
    }

    public static final Map mmaReplaceDefault_delegate$lambda$0() {
        switch (WhenMappings.$EnumSwitchMapping$0[KDevice.INSTANCE.getDeviceType().ordinal()]) {
            case 1:
                MMAReplaceDefault it = AdConfigKt.getMmaReplaceDefault();
                if (it != null) {
                    String[] oaidDefaults = it.getOaidDefaults();
                    return MapsKt.mapOf(new Pair[]{TuplesKt.to(__MAC__, it.getMacDefaults()), TuplesKt.to(__MAC1__, it.getMac1Defaults()), TuplesKt.to(__OAID__, oaidDefaults), TuplesKt.to(__OAIDMD5__, oaidDefaults), TuplesKt.to(__ANDROIDID__, it.getAndroididDefaults()), TuplesKt.to(__IMEI__, it.getImeiDefaults())});
                }
                return null;
            case 2:
                String[] idfaDefaults = {"00000000-0000-0000-0000-000000000000"};
                return MapsKt.mapOf(new Pair[]{TuplesKt.to(__IDFA__, idfaDefaults), TuplesKt.to(__IDFAMD5__, idfaDefaults)});
            case 3:
                MMAReplaceDefault it2 = AdConfigKt.getMmaReplaceDefault();
                if (it2 != null) {
                    String[] oaidDefaults2 = it2.getOaidDefaults();
                    return MapsKt.mapOf(new Pair[]{TuplesKt.to(__OAID__, oaidDefaults2), TuplesKt.to(__OAIDMD5__, oaidDefaults2)});
                }
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}