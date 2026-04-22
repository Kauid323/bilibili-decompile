package tv.danmaku.biliplayerv2.service.core;

import android.os.Build;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.droid.RomUtils;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.moduleservice.player.HDRUtil;
import java.util.List;
import java.util.Locale;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkCodecHelper;
import tv.danmaku.ijk.media.player.IjkCpuInfo;

/* compiled from: HDRUtilImpl.kt */
@Singleton
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Ltv/danmaku/biliplayerv2/service/core/HDRUtilImpl;", "Lcom/bilibili/moduleservice/player/HDRUtil;", "<init>", "()V", "sHdrExternalRenderBlackList", "", "Ltv/danmaku/biliplayerv2/service/core/HDRUtilImpl$BlackItem;", "sHdrExternalRenderWhiteList", "sHuaWeiHdrDisableExternalRenderList", "sNonHuaWeiHdrVividSystemRenderList", "sCpuName", "", "sPhoneModel", "sPhoneBrand", "couldHdrHw", "", "couldUseExternalRender", "isHdrVivid", "ensurePhoneInfo", "", "ensureHdrExternalRenderBlackList", "huaWeiEnableHwHdrWhiteList", "BlackItem", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class HDRUtilImpl implements HDRUtil {
    private String sCpuName;
    private List<BlackItem> sHdrExternalRenderBlackList;
    private List<BlackItem> sHdrExternalRenderWhiteList;
    private List<BlackItem> sHuaWeiHdrDisableExternalRenderList;
    private List<BlackItem> sNonHuaWeiHdrVividSystemRenderList;
    private String sPhoneBrand;
    private String sPhoneModel;

    public boolean couldHdrHw() {
        if (RomUtils.isHuaweiRom()) {
            return huaWeiEnableHwHdrWhiteList();
        }
        boolean remoteEnable = ConfigManager.Companion.isHitFF("player_render_hw_hdr");
        boolean z = false;
        boolean result = remoteEnable && (!RomUtils.isHuaweiRom() || IjkCodecHelper.isSupportHarmonyOSHDR());
        if (result) {
            String str = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "ijkplayer.disable_hw_hdr_model_list", (Object) null, 2, (Object) null);
            List<String> disableList = str != null ? StringsKt.split$default(str, new String[]{","}, false, 0, 6, (Object) null) : null;
            List list = disableList;
            if ((list == null || list.isEmpty()) ? true : true) {
                return true;
            }
            String model = Build.MODEL;
            for (String dm : disableList) {
                if (TextUtils.equals(model, dm)) {
                    return false;
                }
            }
            return result;
        }
        return false;
    }

    public boolean couldUseExternalRender(boolean isHdrVivid) {
        String cpuName;
        String str;
        String str2;
        String str3;
        String str4;
        String itemModel;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        ensureHdrExternalRenderBlackList();
        ensurePhoneInfo();
        if (RomUtils.isHuaweiRom()) {
            return !huaWeiEnableHwHdrWhiteList();
        }
        boolean enableExp = ConfigManager.Companion.ab2().getWithDefault("player_enable_new_exter_render_list", false);
        boolean androidBefore11 = !IjkCodecHelper.isHarmonyOS() && Build.VERSION.SDK_INT < 30;
        BLog.i("HDRUtilImpl", "enableExp=" + enableExp + ", androidBefore11=" + androidBefore11);
        if (androidBefore11 || !enableExp) {
            BLog.i("HDRUtilImpl", "couldUseExternalRender:old logic");
            List blackList = this.sHdrExternalRenderBlackList;
            if (blackList == null || (cpuName = this.sCpuName) == null) {
                return true;
            }
            String model = this.sPhoneModel;
            for (BlackItem item : blackList) {
                if (TextUtils.isEmpty(item.getModel())) {
                    Locale locale = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                    String lowerCase = cpuName.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    String str13 = lowerCase;
                    String cpuName2 = item.getCpuName();
                    if (cpuName2 != null) {
                        Locale locale2 = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale2, "ROOT");
                        str = cpuName2.toLowerCase(locale2);
                        Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
                    } else {
                        str = null;
                    }
                    if (TextUtils.equals(str13, str)) {
                        return false;
                    }
                } else {
                    if (model != null) {
                        Locale locale3 = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale3, "ROOT");
                        str2 = model.toLowerCase(locale3);
                        Intrinsics.checkNotNullExpressionValue(str2, "toLowerCase(...)");
                    } else {
                        str2 = null;
                    }
                    String str14 = str2;
                    String model2 = item.getModel();
                    if (model2 != null) {
                        Locale locale4 = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale4, "ROOT");
                        str3 = model2.toLowerCase(locale4);
                        Intrinsics.checkNotNullExpressionValue(str3, "toLowerCase(...)");
                    } else {
                        str3 = null;
                    }
                    if (TextUtils.equals(str14, str3)) {
                        Locale locale5 = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale5, "ROOT");
                        String lowerCase2 = cpuName.toLowerCase(locale5);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        String str15 = lowerCase2;
                        String cpuName3 = item.getCpuName();
                        if (cpuName3 != null) {
                            Locale locale6 = Locale.ROOT;
                            Intrinsics.checkNotNullExpressionValue(locale6, "ROOT");
                            str4 = cpuName3.toLowerCase(locale6);
                            Intrinsics.checkNotNullExpressionValue(str4, "toLowerCase(...)");
                        } else {
                            str4 = null;
                        }
                        if (TextUtils.equals(str15, str4)) {
                            String model3 = item.getModel();
                            if (model3 != null) {
                                Locale locale7 = Locale.ROOT;
                                Intrinsics.checkNotNullExpressionValue(locale7, "ROOT");
                                itemModel = model3.toLowerCase(locale7);
                                Intrinsics.checkNotNullExpressionValue(itemModel, "toLowerCase(...)");
                            } else {
                                itemModel = null;
                            }
                            String cpuName4 = item.getCpuName();
                            if (cpuName4 != null) {
                                Locale locale8 = Locale.ROOT;
                                Intrinsics.checkNotNullExpressionValue(locale8, "ROOT");
                                String lowerCase3 = cpuName4.toLowerCase(locale8);
                                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                                str5 = lowerCase3;
                            } else {
                                str5 = null;
                            }
                            String itemCpuName = str5;
                            BLog.i("HDRUtilImpl", "couldUseExternalRender=false, item.model=" + itemModel + ", item.cpuName=" + itemCpuName);
                            return false;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return true;
        }
        BLog.i("HDRUtilImpl", "couldUseExternalRender:new logic, isHdrVivid:" + isHdrVivid);
        String model4 = this.sPhoneModel;
        String brand = this.sPhoneBrand;
        if (isHdrVivid) {
            List systemRenderList = this.sNonHuaWeiHdrVividSystemRenderList;
            if (systemRenderList == null) {
                return true;
            }
            for (BlackItem item2 : systemRenderList) {
                if (!TextUtils.isEmpty(item2.getModel())) {
                    if (model4 != null) {
                        Locale locale9 = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale9, "ROOT");
                        str9 = model4.toLowerCase(locale9);
                        Intrinsics.checkNotNullExpressionValue(str9, "toLowerCase(...)");
                    } else {
                        str9 = null;
                    }
                    String str16 = str9;
                    String model5 = item2.getModel();
                    if (model5 != null) {
                        Locale locale10 = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale10, "ROOT");
                        str10 = model5.toLowerCase(locale10);
                        Intrinsics.checkNotNullExpressionValue(str10, "toLowerCase(...)");
                    } else {
                        str10 = null;
                    }
                    if (TextUtils.equals(str16, str10) && !TextUtils.isEmpty(item2.getBrand())) {
                        if (brand != null) {
                            Locale locale11 = Locale.ROOT;
                            Intrinsics.checkNotNullExpressionValue(locale11, "ROOT");
                            str11 = brand.toLowerCase(locale11);
                            Intrinsics.checkNotNullExpressionValue(str11, "toLowerCase(...)");
                        } else {
                            str11 = null;
                        }
                        String str17 = str11;
                        String brand2 = item2.getBrand();
                        if (brand2 != null) {
                            Locale locale12 = Locale.ROOT;
                            Intrinsics.checkNotNullExpressionValue(locale12, "ROOT");
                            str12 = brand2.toLowerCase(locale12);
                            Intrinsics.checkNotNullExpressionValue(str12, "toLowerCase(...)");
                        } else {
                            str12 = null;
                        }
                        if (TextUtils.equals(str17, str12)) {
                            BLog.i("HDRUtilImpl", "nonHuaWei HdrVivid SystemRender=true, model=" + model4 + " brand=" + brand + "\"");
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        List whiteList = this.sHdrExternalRenderWhiteList;
        if (whiteList == null) {
            return false;
        }
        for (BlackItem item3 : whiteList) {
            if (!TextUtils.isEmpty(item3.getModel())) {
                if (model4 != null) {
                    Locale locale13 = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(locale13, "ROOT");
                    str6 = model4.toLowerCase(locale13);
                    Intrinsics.checkNotNullExpressionValue(str6, "toLowerCase(...)");
                } else {
                    str6 = null;
                }
                String str18 = str6;
                String model6 = item3.getModel();
                if (model6 != null) {
                    Locale locale14 = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(locale14, "ROOT");
                    str7 = model6.toLowerCase(locale14);
                    Intrinsics.checkNotNullExpressionValue(str7, "toLowerCase(...)");
                } else {
                    str7 = null;
                }
                if (TextUtils.equals(str18, str7)) {
                    String model7 = item3.getModel();
                    if (model7 != null) {
                        Locale locale15 = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale15, "ROOT");
                        str8 = model7.toLowerCase(locale15);
                        Intrinsics.checkNotNullExpressionValue(str8, "toLowerCase(...)");
                    } else {
                        str8 = null;
                    }
                    String itemModel2 = str8;
                    BLog.i("HDRUtilImpl", "couldUseExternalRender=true, item.model=" + itemModel2);
                    return true;
                }
            }
        }
        return false;
    }

    private final void ensurePhoneInfo() {
        if (this.sPhoneModel != null) {
            return;
        }
        try {
            this.sCpuName = IjkCpuInfo.getCpuName();
            this.sPhoneModel = Build.MODEL;
            this.sPhoneBrand = Build.BRAND;
        } catch (Exception e) {
        }
    }

    private final void ensureHdrExternalRenderBlackList() {
        if (this.sHdrExternalRenderBlackList == null) {
            try {
                String blackListRaw = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "ijkplayer.disable_hdr_external_render_list", (Object) null, 2, (Object) null);
                if (blackListRaw != null) {
                    this.sHdrExternalRenderBlackList = JSON.parseArray(blackListRaw, BlackItem.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.sHdrExternalRenderWhiteList == null) {
            try {
                String whiteListRaw = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "ijkplayer.enable_hdr_external_render_list", (Object) null, 2, (Object) null);
                if (whiteListRaw != null) {
                    this.sHdrExternalRenderWhiteList = JSON.parseArray(whiteListRaw, BlackItem.class);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (this.sHuaWeiHdrDisableExternalRenderList == null) {
            try {
                String whiteListRaw2 = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "ijkplayer.huawei_disable_hdr_external_render_list", (Object) null, 2, (Object) null);
                if (whiteListRaw2 != null) {
                    this.sHuaWeiHdrDisableExternalRenderList = JSON.parseArray(whiteListRaw2, BlackItem.class);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        if (this.sNonHuaWeiHdrVividSystemRenderList == null) {
            try {
                String whiteListRaw3 = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "ijkplayer.non_huawei_hdr_vivid_system_render_list", (Object) null, 2, (Object) null);
                if (whiteListRaw3 != null) {
                    this.sNonHuaWeiHdrVividSystemRenderList = JSON.parseArray(whiteListRaw3, BlackItem.class);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public boolean huaWeiEnableHwHdrWhiteList() {
        String str;
        String str2;
        String str3;
        String str4;
        if (RomUtils.isHuaweiRom()) {
            ensureHdrExternalRenderBlackList();
            ensurePhoneInfo();
            List whiteList = this.sHuaWeiHdrDisableExternalRenderList;
            if (whiteList == null) {
                return false;
            }
            String model = this.sPhoneModel;
            String brand = this.sPhoneBrand;
            for (BlackItem item : whiteList) {
                if (!TextUtils.isEmpty(item.getModel())) {
                    String str5 = null;
                    if (model != null) {
                        Locale locale = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                        str = model.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
                    } else {
                        str = null;
                    }
                    String str6 = str;
                    String model2 = item.getModel();
                    if (model2 != null) {
                        Locale locale2 = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale2, "ROOT");
                        str2 = model2.toLowerCase(locale2);
                        Intrinsics.checkNotNullExpressionValue(str2, "toLowerCase(...)");
                    } else {
                        str2 = null;
                    }
                    if (TextUtils.equals(str6, str2) && !TextUtils.isEmpty(item.getBrand())) {
                        if (brand != null) {
                            Locale locale3 = Locale.ROOT;
                            Intrinsics.checkNotNullExpressionValue(locale3, "ROOT");
                            str3 = brand.toLowerCase(locale3);
                            Intrinsics.checkNotNullExpressionValue(str3, "toLowerCase(...)");
                        } else {
                            str3 = null;
                        }
                        String str7 = str3;
                        String brand2 = item.getBrand();
                        if (brand2 != null) {
                            Locale locale4 = Locale.ROOT;
                            Intrinsics.checkNotNullExpressionValue(locale4, "ROOT");
                            str4 = brand2.toLowerCase(locale4);
                            Intrinsics.checkNotNullExpressionValue(str4, "toLowerCase(...)");
                        } else {
                            str4 = null;
                        }
                        if (TextUtils.equals(str7, str4)) {
                            String model3 = item.getModel();
                            if (model3 != null) {
                                Locale locale5 = Locale.ROOT;
                                Intrinsics.checkNotNullExpressionValue(locale5, "ROOT");
                                str5 = model3.toLowerCase(locale5);
                                Intrinsics.checkNotNullExpressionValue(str5, "toLowerCase(...)");
                            }
                            String itemModel = str5;
                            BLog.i("HDRUtilImpl", "huaWeiEnableHwHdrWhiteList=true, item.model=" + itemModel);
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    /* compiled from: HDRUtilImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Ltv/danmaku/biliplayerv2/service/core/HDRUtilImpl$BlackItem;", "", "<init>", "()V", "model", "", "getModel", "()Ljava/lang/String;", "setModel", "(Ljava/lang/String;)V", "cpuName", "getCpuName", "setCpuName", "brand", "getBrand", "setBrand", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class BlackItem {
        @JSONField(name = "brand")
        private String brand;
        @JSONField(name = "cpuName")
        private String cpuName;
        @JSONField(name = "model")
        private String model;

        public final String getModel() {
            return this.model;
        }

        public final void setModel(String str) {
            this.model = str;
        }

        public final String getCpuName() {
            return this.cpuName;
        }

        public final void setCpuName(String str) {
            this.cpuName = str;
        }

        public final String getBrand() {
            return this.brand;
        }

        public final void setBrand(String str) {
            this.brand = str;
        }
    }
}