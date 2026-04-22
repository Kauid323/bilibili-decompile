package tv.danmaku.bili.ui.main2.api;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.util.ObjectsCompat;
import bili.resource.homepage.R;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.app.comm.servercomm.ServerClock;
import com.bilibili.commons.time.DateUtils;
import com.bilibili.droid.StringFormatter;
import com.bilibili.droid.StringUtil;
import com.bilibili.lib.accountinfo.model.OfficialVerify;
import com.bilibili.lib.accountinfo.model.VipUserInfo;
import com.bilibili.lib.avatar.layers.model.AvatarItem;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.lib.homepage.mine.MenuItemTip;
import com.bilibili.lib.voldemort.data.VoldemortNameRender;
import j$.util.Objects;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.push.innerpush.v2.InnerPushReceiverKt;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.garb.GarbJsBridgeCallHandlerKt;
import tv.danmaku.bili.ui.garb.model.GarbData;
import tv.danmaku.bili.ui.main2.mine.modularvip.ColorConfig;
import tv.danmaku.bili.ui.main2.mine.modularvip.MineVipServiceKt;

public class AccountMine {
    public static final int AUDIO_TYPE_MONTH = 1;
    @JSONField(name = "achievement")
    public Achievement achievement;
    @JSONField(name = "answer")
    public Answer answer;
    @JSONField(name = "answer_status")
    public int answerStatus;
    @JSONField(name = "audio_type")
    public int audioType;
    @JSONField(deserialize = false, serialize = false)
    public transient AvatarItem avatar;
    private JSONObject avatarObject;
    @JSONField(name = "bcoin")
    public float bcoin;
    @JSONField(name = "bili_link_bubble")
    public BiliLinkBubble biliLinkBubble;
    @JSONField(name = "bubbles")
    public List<GuideBubble> bubbles;
    @JSONField(name = "coin")
    public float coin;
    @JSONField(name = "dynamic")
    public long dynamic;
    @JSONField(name = "enable_bili_link")
    public boolean enableBiliLink;
    @JSONField(name = "end_time")
    public long end_time;
    @JSONField(name = "face")
    public String face;
    @JSONField(name = "fans_effect")
    public FansEffect fansEffect;
    @JSONField(name = "first_live_time")
    public long firstLiveTime;
    @JSONField(name = "follower")
    public long follower;
    @JSONField(name = "following")
    public long following;
    @JSONField(name = "game_tip")
    public List<MenuItemTip> gameTips;
    @JSONField(name = "mall_home")
    public GarbEntrance garbEntrance;
    @JSONField(name = "handle")
    public String handle;
    @JSONField(name = "in_reg_audit")
    public int inRegAudit;
    @JSONField(name = "level")
    public int level;
    @JSONField(name = "live_tip")
    public LiveTip liveTip;
    @JSONField(name = "mid")
    public long mid;
    @JSONField(name = "modular_vip_section")
    public ModularVipSection modularVipSection;
    @JSONField(name = ChannelRoutes.CHANNEL_NAME)
    public String name;
    @JSONField(deserialize = false, serialize = false)
    public transient VoldemortNameRender nameRender;
    private JSONObject nameRenderObject;
    @JSONField(name = "new_followers")
    public int newFollowers;
    @JSONField(name = "new_followers_rtime")
    public long newFollowersTime;
    @JSONField(name = "nft")
    public NFTData nftData;
    @JSONField(name = "official_verify")
    public OfficialVerify officialVerify;
    @JSONField(name = "pendant")
    public Pendant pendant;
    @JSONField(name = AppConfig.HOST_RANK)
    public int rank;
    @JSONField(name = "sections")
    public List<MenuGroup> sectionList;
    @JSONField(name = "sections_v2")
    public List<MenuGroup> sectionListV2;
    @JSONField(name = "senior_gate")
    public SeniorStatus seniorStatus;
    @JSONField(name = "sex")
    public int sex;
    @JSONField(name = "show_creative")
    public int showCreative;
    @JSONField(name = "show_face_guide")
    public boolean showFaceGuide;
    @JSONField(name = "show_name_guide")
    public boolean showNameGuide;
    @JSONField(name = "show_nft_face_guide")
    public boolean showNftGuide;
    @JSONField(name = "show_videoup")
    public int showVideoup;
    @JSONField(name = "silence")
    public int silence;
    @JSONField(name = "use_modular_vip_section")
    public boolean useModularVipSection;
    @JSONField(name = "video_update_calendar")
    public MVideoUpdateCalendar videoUpdateCalendar;
    @JSONField(name = "vip")
    public VipUserInfo vip;
    @JSONField(name = "vip_section_right")
    public VipSectionRight vipSectionRight;
    @JSONField(name = "vip_section_v2")
    public VipSectionV2 vipSectionV2;
    @JSONField(name = MineVipServiceKt.VIP_REPORT_PARAM_VIP_TYPE)
    public int vipType;

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class AccountUperInfo {
        public boolean enableCreationModule;
        public boolean showCreative;
        public boolean showVideoUp;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Achievement {
        @JSONField(name = "senior_gate_flash")
        public SeniorGateFlash seniorGateFlash;
        @JSONField(name = "top_level_flash")
        public TopLevelFlash topLevelFlash;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class BiliLinkBubble {
        @JSONField(name = "desc")
        public String desc;
        @JSONField(name = "id")
        public int id;
        @JSONField(name = "pic")
        public String pic;
        @JSONField(name = ReportUtilKt.POS_TITLE)
        public String title;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class FansEffect {
        @JSONField(name = "achieve_type")
        public int achieveType;
        @JSONField(name = "button")
        public FansEffectButton button;
        @JSONField(name = "night_resource_url")
        public String nightResourceUrl;
        @JSONField(name = "report_info")
        public String reportInfo;
        @JSONField(name = "resource_url")
        public String resourceUrl;
        @JSONField(name = "show_type")
        public int showType;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class FansEffectButton {
        @JSONField(name = "bg_color")
        public String bgColor;
        @JSONField(name = "bg_night_color")
        public String bgNightColor;
        @JSONField(name = "text")
        public String text;
        @JSONField(name = "text_color")
        public String textColor;
        @JSONField(name = "text_night_color")
        public String textNightColor;
        @JSONField(name = AudioIntentHelper.ARGS_URI)
        public String uri;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class NFTData {
        @JSONField(name = "icon")
        public NFTIcon icon;
        @JSONField(name = "region_type")
        public int type;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class SeniorGateFlash {
        @JSONField(name = "icon")
        public String icon;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class TopLevelFlash {
        @JSONField(name = "icon")
        public String icon;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class VIPSectionRevision {
        @JSONField(name = "module_background")
        public VIPSectionStyles background;
        @JSONField(name = "module_background_color")
        public VIPSectionRevisionBgColor bgColor;
        @JSONField(name = "module_background_color_daily")
        public VIPSectionStyles bgColorDaily;
        @JSONField(name = "button_background_color")
        public VIPSectionStyles buttonBackground;
        @JSONField(name = "button_icon")
        public String buttonIcon;
        @JSONField(name = "button_icon_period")
        public int buttonIconPeriod;
        @JSONField(name = "button_icon_times")
        public int buttonIconTimes;
        @JSONField(name = "button_icon_type")
        public int buttonIconType;
        @JSONField(name = "button_link")
        public String buttonLink;
        @JSONField(name = "button_style")
        public int buttonStyle;
        @JSONField(name = "button_text_color")
        public VIPSectionStyles buttonTextColor;
        @JSONField(name = "click_title")
        public String clickTitle;
        @JSONField(name = "img")
        public String img;
        @JSONField(name = "img_night")
        public String imgNight;
        @JSONField(name = "main_text_color")
        public VIPSectionStyles mainTextColor;
        @JSONField(name = "vip_op_icons")
        public List<PositionStrategyConfig> positionStrategyConfigs;
        @JSONField(name = "sub_text_color")
        public VIPSectionStyles subTextColor;
        @JSONField(name = "text_color")
        public VIPSectionRevisionTextColor textColor;
        @JSONField(name = "version")
        public String version;
        @JSONField(name = "logo")
        public VIPSectionStyles vipLogo;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class VIPSectionRevisionBgColor {
        @JSONField(name = "day_dress")
        public String dayDress;
        @JSONField(name = "day_no_dress")
        public String dayNoDress;
        @JSONField(name = "night_dress")
        public String nightDress;
        @JSONField(name = "night_no_dress")
        public String nightNoDress;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class VIPSectionRevisionTextColor {
        @JSONField(name = "day_dress_text")
        public String dayDress;
        @JSONField(name = "day_no_dress_text")
        public String dayNoDress;
        @JSONField(name = "night_dress_text")
        public String nightDress;
        @JSONField(name = "night_no_dress_text")
        public String nightNoDress;
    }

    @JSONField(name = "avatar")
    public void setAvatar(JSONObject avatar) {
        this.avatarObject = avatar;
        if (avatar != null) {
            this.avatar = (AvatarItem) JSON.parseObject(avatar.toJSONString(), AvatarItem.class);
        }
    }

    @JSONField(name = "avatar")
    public JSONObject getAvatar() {
        return this.avatarObject;
    }

    @JSONField(name = "name_render")
    public void setNameRender(JSONObject nameRender) {
        this.nameRenderObject = nameRender;
        if (nameRender != null) {
            this.nameRender = (VoldemortNameRender) JSON.parseObject(nameRender.toJSONString(), VoldemortNameRender.class);
        }
    }

    @JSONField(name = "name_render")
    public JSONObject getNameRender() {
        return this.nameRenderObject;
    }

    public JSONObject toJsonObject() {
        String jsonString = JSON.toJSONString(this);
        return JSON.parseObject(jsonString);
    }

    public boolean isEffectiveVip() {
        return this.vipType == 1 || this.vipType == 2;
    }

    public boolean isAccountInRegAudit() {
        return this.inRegAudit == 1;
    }

    public boolean isEffectiveYearVip() {
        return this.vip != null && this.vip.isEffectiveYearVip();
    }

    public boolean isFormalAccount() {
        return this.rank >= 10000;
    }

    public boolean isLittleVip() {
        return this.vip != null && this.vip.isLittleVip();
    }

    public boolean isSeniorUser() {
        return this.level == 6 && this.seniorStatus != null && this.seniorStatus.isSeniorMember();
    }

    public String getLabelPath() {
        if (this.vip != null) {
            return this.vip.getLabelPath();
        }
        return null;
    }

    public String getLabelTheme() {
        if (this.vip != null) {
            return this.vip.getLabelTheme();
        }
        return null;
    }

    public int getVipStatusForReport() {
        if (this.vip != null) {
            if (this.vip.getVipType() == 1 || this.vip.getVipType() == 2) {
                if (this.vip.getVipStatus() == 1) {
                    return 1;
                }
                if (this.vip.getVipStatus() == 0) {
                    return 0;
                }
                return -1;
            }
            return -1;
        }
        return -1;
    }

    public int getVipTypeForReport() {
        if (this.vip != null) {
            return this.vip.getVipType();
        }
        return -1;
    }

    public String bCoinStr(Context context) {
        try {
            if (this.bcoin >= 10000.0f) {
                float n = this.bcoin / 10000.0f;
                return StringFormatter.format(Locale.CHINA, context.getString(R.string.homepage_global_string_133), new Object[]{Float.valueOf(n)});
            }
            float n2 = this.bcoin;
            return n2 >= 0.0f ? StringFormatter.format(Locale.CHINA, "%.1f", new Object[]{Float.valueOf(this.bcoin)}) : "0.0";
        } catch (NumberFormatException e) {
            return "-";
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Pendant {
        @JSONField(name = "image")
        public String image;
        @JSONField(name = "image_enhance")
        public String imageEnhance;

        public String getImageEnhanceUrl() {
            return StringUtil.isBlank(this.imageEnhance) ? this.image : this.imageEnhance;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pendant pendant = (Pendant) o;
            if (this.image == null ? pendant.image != null : !this.image.equals(pendant.image)) {
                return false;
            }
            if (this.imageEnhance != null) {
                return this.imageEnhance.equals(pendant.imageEnhance);
            }
            if (pendant.imageEnhance == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int result = this.image != null ? this.image.hashCode() : 0;
            return (result * 31) + (this.imageEnhance != null ? this.imageEnhance.hashCode() : 0);
        }

        public String toString() {
            return "Pendant{image='" + this.image + "'}";
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class ModularVipSection {
        @JSONField(name = BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND)
        public ModularVipBackground background;
        @JSONField(name = "button")
        public ModularVipButton button;
        @JSONField(name = "button_icon")
        public ModularVipButtonIcon buttonIcon;
        @JSONField(name = InnerPushReceiverKt.KEY_EXTRA)
        public ModularVipExtra extra;
        @JSONField(name = "logo")
        public ModularVipLogo logo;
        @JSONField(name = "subtitle")
        public ModularVipSubtitle subtitle;
        @JSONField(name = ReportUtilKt.POS_TITLE)
        public ModularVipTitle title;

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof ModularVipSection) {
                ModularVipSection that = (ModularVipSection) o;
                return Objects.equals(this.background, that.background) && Objects.equals(this.button, that.button) && Objects.equals(this.buttonIcon, that.buttonIcon) && Objects.equals(this.logo, that.logo) && Objects.equals(this.subtitle, that.subtitle) && Objects.equals(this.title, that.title) && Objects.equals(this.extra, that.extra);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.background, this.button, this.buttonIcon, this.logo, this.subtitle, this.title, this.extra});
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class ModularVipBackground {
        @JSONField(name = GarbJsBridgeCallHandlerKt.PURE_THEME)
        public ModularVipStyle colorLayer;
        @JSONField(name = "frequency_control")
        public boolean frequencyControl;
        @JSONField(name = "image")
        public String image;

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof ModularVipBackground) {
                ModularVipBackground that = (ModularVipBackground) o;
                return this.frequencyControl == that.frequencyControl && Objects.equals(this.image, that.image) && Objects.equals(this.colorLayer, that.colorLayer);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Boolean.valueOf(this.frequencyControl), this.image, this.colorLayer});
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class ModularVipButton {
        @JSONField(name = "background_style")
        public ModularVipStyle backgroundStyle;
        @JSONField(name = "frequency_control")
        public boolean frequencyControl;
        @JSONField(name = "style")
        public int style;
        @JSONField(name = "text")
        public String text;
        @JSONField(name = "text_style")
        public ModularVipStyle textStyle;
        @JSONField(name = "url")
        public String url;

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof ModularVipButton) {
                ModularVipButton that = (ModularVipButton) o;
                return this.frequencyControl == that.frequencyControl && this.style == that.style && Objects.equals(this.text, that.text) && Objects.equals(this.url, that.url) && Objects.equals(this.backgroundStyle, that.backgroundStyle) && Objects.equals(this.textStyle, that.textStyle);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Boolean.valueOf(this.frequencyControl), Integer.valueOf(this.style), this.text, this.url, this.backgroundStyle, this.textStyle});
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class ModularVipButtonIcon {
        @JSONField(name = "frequency_control")
        public boolean frequencyControl;
        @JSONField(name = "icon_type")
        public int iconType;
        @JSONField(name = "url")
        public String url;

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof ModularVipButtonIcon) {
                ModularVipButtonIcon that = (ModularVipButtonIcon) o;
                return this.frequencyControl == that.frequencyControl && this.iconType == that.iconType && Objects.equals(this.url, that.url);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Boolean.valueOf(this.frequencyControl), Integer.valueOf(this.iconType), this.url});
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class ModularVipLogo {
        @JSONField(name = "frequency_control")
        public boolean frequencyControl;
        @JSONField(name = "light_icon")
        public String lightIcon;
        @JSONField(name = "night_icon")
        public String nightIcon;

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof ModularVipLogo) {
                ModularVipLogo that = (ModularVipLogo) o;
                return this.frequencyControl == that.frequencyControl && Objects.equals(this.lightIcon, that.lightIcon) && Objects.equals(this.nightIcon, that.nightIcon);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Boolean.valueOf(this.frequencyControl), this.lightIcon, this.nightIcon});
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class ModularVipSubtitle {
        @JSONField(name = "frequency_control")
        public boolean frequencyControl;
        @JSONField(name = "text_style")
        public ModularVipStyle style;
        @JSONField(name = "text")
        public String text;

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof ModularVipSubtitle) {
                ModularVipSubtitle that = (ModularVipSubtitle) o;
                return this.frequencyControl == that.frequencyControl && Objects.equals(this.text, that.text) && Objects.equals(this.style, that.style);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Boolean.valueOf(this.frequencyControl), this.text, this.style});
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class ModularVipTitle {
        @JSONField(name = "frequency_control")
        public boolean frequencyControl;
        @JSONField(name = "text_style")
        public ModularVipStyle style;
        @JSONField(name = "text")
        public String text;
        @JSONField(name = "url")
        public String url;

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof ModularVipTitle) {
                ModularVipTitle that = (ModularVipTitle) o;
                return this.frequencyControl == that.frequencyControl && Objects.equals(this.text, that.text) && Objects.equals(this.url, that.url) && Objects.equals(this.style, that.style);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Boolean.valueOf(this.frequencyControl), this.text, this.url, this.style});
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class ModularVipExtra {
        @JSONField(name = "marketing_subtype")
        public String marketingSubType;
        @JSONField(name = "module_type")
        public int moduleType;
        @JSONField(name = "track_params")
        public ModularVipTrackParams trackParams;

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof ModularVipExtra) {
                ModularVipExtra that = (ModularVipExtra) o;
                return this.moduleType == that.moduleType && Objects.equals(this.marketingSubType, that.marketingSubType) && Objects.equals(this.trackParams, that.trackParams);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.marketingSubType, Integer.valueOf(this.moduleType), this.trackParams});
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class ModularVipTrackParams {
        @JSONField(name = MineVipServiceKt.VIP_REPORT_PARAM_EXP_GROUP_TAG)
        public String expGroupTag;
        @JSONField(name = MineVipServiceKt.VIP_REPORT_PARAM_EXP_TAG)
        public String expTag;
        @JSONField(name = "material_type")
        public String materialType;
        @JSONField(name = "position_id")
        public String positionId;
        @JSONField(name = MineVipServiceKt.VIP_REPORT_PARAM_TIPS_ID)
        public String tipsId;
        @JSONField(name = "tips_repeat_key")
        public String tipsRepeatKey;
        @JSONField(name = "vip_status")
        public String vipStatus;
        @JSONField(name = MineVipServiceKt.VIP_REPORT_PARAM_VIP_TYPE)
        public String vipType;

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof ModularVipTrackParams) {
                ModularVipTrackParams that = (ModularVipTrackParams) o;
                return Objects.equals(this.expGroupTag, that.expGroupTag) && Objects.equals(this.expTag, that.expTag) && Objects.equals(this.tipsId, that.tipsId) && Objects.equals(this.vipStatus, that.vipStatus) && Objects.equals(this.vipType, that.vipType) && Objects.equals(this.positionId, that.positionId) && Objects.equals(this.tipsRepeatKey, that.tipsRepeatKey) && Objects.equals(this.materialType, that.materialType);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.expGroupTag, this.expTag, this.tipsId, this.vipStatus, this.vipType, this.positionId, this.tipsRepeatKey, this.materialType});
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class ModularVipStyle {
        @JSONField(name = GarbData.ColorDetail.DARK_THEME)
        public ColorConfig dark;
        @JSONField(name = GarbData.ColorDetail.LIGHT_THEME)
        public ColorConfig light;

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof ModularVipStyle) {
                ModularVipStyle that = (ModularVipStyle) o;
                return Objects.equals(this.dark, that.dark) && Objects.equals(this.light, that.light);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.dark, this.light});
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public class VipSectionV2 {
        @JSONField(name = "desc")
        public String desc;
        @JSONField(name = MineVipServiceKt.VIP_REPORT_PARAM_EXP_GROUP_TAG)
        public String expGroupTag;
        @JSONField(name = MineVipServiceKt.VIP_REPORT_PARAM_EXP_TAG)
        public String expTag;
        @JSONField(name = "id")
        public long id;
        @JSONField(name = ReportUtilKt.POS_TITLE)
        public String title;
        @JSONField(name = "track_params")
        public ModularVipTrackParams trackParams;
        @JSONField(name = "type")
        public String type;
        @JSONField(name = "url")
        public String url;
        @JSONField(name = "vip_section_revision")
        public VIPSectionRevision vipSectionRevision;

        public VipSectionV2() {
        }

        public boolean isNewVipSection() {
            return this.type == null || TextUtils.equals(this.type, "2");
        }

        public boolean isValid() {
            return (this.title == null || this.desc == null || this.vipSectionRevision == null) ? false : true;
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class VipSectionRight {
        @JSONField(name = "id")
        public long id;
        @JSONField(name = "img")
        public String img;
        @JSONField(name = "link")
        public String link;
        @JSONField(name = "tip")
        public String tip;
        @JSONField(name = ReportUtilKt.POS_TITLE)
        public String title;

        public boolean isValid() {
            return (TextUtils.isEmpty(this.title) || TextUtils.isEmpty(this.tip) || TextUtils.isEmpty(this.link)) ? false : true;
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class GarbEntrance {
        @JSONField(name = "icon")
        public String icon;
        @JSONField(name = ReportUtilKt.POS_TITLE)
        public String title;
        @JSONField(name = AudioIntentHelper.ARGS_URI)
        public String uri;

        public boolean isValid() {
            return !TextUtils.isEmpty(this.uri);
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof GarbEntrance) {
                GarbEntrance that = (GarbEntrance) o;
                if (this.icon == null ? that.icon == null : this.icon.equals(that.icon)) {
                    if (this.uri == null ? that.uri == null : this.uri.equals(that.uri)) {
                        return this.title != null ? this.title.equals(that.title) : that.title == null;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            int result = this.icon != null ? this.icon.hashCode() : 0;
            return (((result * 31) + (this.uri != null ? this.uri.hashCode() : 0)) * 31) + (this.title != null ? this.title.hashCode() : 0);
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Answer {
        @JSONField(name = "activity_answer")
        public ActivityAnswer activityAnswer;
        public String progress;
        public String text;
        public String url;

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof Answer) {
                Answer answer = (Answer) o;
                return ObjectsCompat.equals(this.text, answer.text) && ObjectsCompat.equals(this.url, answer.url) && ObjectsCompat.equals(this.progress, answer.progress) && ObjectsCompat.equals(this.activityAnswer, answer.activityAnswer);
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.text, this.url, this.progress, this.activityAnswer});
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class ActivityAnswer {
        @JSONField(name = "badge")
        public String badge;
        @JSONField(name = "text")
        public String text;
        @JSONField(name = "url")
        public String url;

        public final boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof ActivityAnswer) {
                ActivityAnswer that = (ActivityAnswer) o;
                return ObjectsCompat.equals(this.badge, that.badge) && ObjectsCompat.equals(this.text, that.text) && ObjectsCompat.equals(this.url, that.url);
            }
            return false;
        }

        public int hashCode() {
            int result = ObjectsCompat.hashCode(this.badge);
            return (((result * 31) + ObjectsCompat.hashCode(this.text)) * 31) + ObjectsCompat.hashCode(this.url);
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class PositionStrategyConfig {
        @JSONField(name = "color_layer")
        public VIPSectionStyles backgroundColor;
        @JSONField(name = "icon_type")
        public int positionType;
        @JSONField(name = "display_strategy")
        public DisplayStrategyBean strategy;
        @JSONField(name = "icon")
        public String url;

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            PositionStrategyConfig that = (PositionStrategyConfig) o;
            if (this.positionType == that.positionType && ObjectsCompat.equals(this.url, that.url) && ObjectsCompat.equals(this.strategy, that.strategy) && ObjectsCompat.equals(this.backgroundColor, that.backgroundColor)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.url, Integer.valueOf(this.positionType), this.strategy, this.backgroundColor});
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class DisplayStrategyBean {
        @JSONField(name = "period")
        public int period;
        @JSONField(name = "strategy_type")
        public int strategyType;
        @JSONField(name = "times")
        public int times;

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            DisplayStrategyBean that = (DisplayStrategyBean) o;
            if (this.strategyType == that.strategyType && this.period == that.period && this.times == that.times) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{Integer.valueOf(this.strategyType), Integer.valueOf(this.period), Integer.valueOf(this.times)});
        }
    }

    public String toString() {
        return "AccountMine{mid=" + this.mid + ", name='" + this.name + "', face='" + this.face + "', coin=" + this.coin + ", bcoin=" + this.bcoin + ", sex=" + this.sex + ", rank=" + this.rank + ", answerStatus=" + this.answerStatus + ", silence=" + this.silence + ", end_time=" + this.end_time + ", showVideoup=" + this.showVideoup + ", showCreative=" + this.showCreative + ", level=" + this.level + ", vipType=" + this.vipType + ", audioType=" + this.audioType + ", dynamic=" + this.dynamic + ", following=" + this.following + ", follower=" + this.follower + ", pendant=" + this.pendant + ", officialVerify=" + this.officialVerify + ", newFollowers=" + this.newFollowers + ", seniorStatus=" + this.seniorStatus + '}';
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class LiveTip {
        public static final int BUTTON_MODE = 0;
        public static final int LINK_MODE = 1;
        public static final int NO_TEXT_MODE = 2;
        @JSONField(name = "button_icon")
        public String btnIcon;
        @JSONField(name = "button_text")
        public String btnText;
        @JSONField(name = "icon")
        public String iconUrl;
        @JSONField(name = "id")
        public long id;
        @JSONField(name = "mod")
        public int mode;
        @JSONField(name = "text")
        public String text;
        @JSONField(name = "url")
        public String url;
        @JSONField(name = "url_text")
        public String urlText;

        public boolean isValid() {
            return (TextUtils.isEmpty(this.url) || TextUtils.isEmpty(this.text)) ? false : true;
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class SeniorStatus {
        @JSONField(name = "birthday_conf")
        public BirthdayConf birthdayConf;
        @JSONField(name = "bubble")
        public String bubble;
        @JSONField(name = "text")
        public String entranceTitle;
        @JSONField(name = "identity")
        public int identity;
        @JSONField(name = "member_text")
        public String memberText;
        @JSONField(name = "url")
        public String url;

        @JSONField(deserialize = false, serialize = false)
        public boolean isSeniorMember() {
            return this.identity == 2 || this.identity == 3;
        }

        @JSONField(deserialize = false, serialize = false)
        public boolean showEntrance() {
            return !TextUtils.isEmpty(this.url);
        }

        public String toString() {
            return "SeniorStatus{identity=" + this.identity + ", entranceTitle='" + this.entranceTitle + "', url='" + this.url + "'}";
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class BirthdayConf {
        @JSONField(name = "birthday")
        public long birthday;
        @JSONField(name = "bubble_text")
        public String bubleText;
        @JSONField(name = "icon")
        public String icon;
        @JSONField(name = "url")
        public String url;

        public boolean isTodayBirthday() {
            Calendar c1 = Calendar.getInstance();
            c1.setTimeInMillis(this.birthday * 1000);
            Calendar c2 = Calendar.getInstance();
            c2.setTimeInMillis(ServerClock.unreliableNow());
            return c1.get(0) == c2.get(0) && c1.get(2) == c2.get(2) && c1.get(5) == c2.get(5);
        }

        public boolean needBless(long blessedMillTimes) {
            Calendar c1 = Calendar.getInstance();
            c1.setTimeInMillis(ServerClock.unreliableNow());
            Calendar c2 = Calendar.getInstance();
            c2.setTimeInMillis(blessedMillTimes);
            return isTodayBirthday() && !DateUtils.isSameDay(c1, c2);
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class GuideBubble {
        @JSONField(name = "icon")
        public String icon;
        @JSONField(name = "id")
        public long id;
        @JSONField(name = "type")
        public int type;

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            GuideBubble that = (GuideBubble) o;
            if (this.id == that.id && this.type == that.type && ObjectsCompat.equals(this.icon, that.icon)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{Long.valueOf(this.id), this.icon, Integer.valueOf(this.type)});
        }

        public String toString() {
            return "GuideBubble{id=" + this.id + ", icon='" + this.icon + "', type=" + this.type + '}';
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class NFTIcon {
        @JSONField(name = "show_status")
        public int showStatus;
        @JSONField(name = "url")
        public String url;
        private static int SHOW_STATUS_ZOOMING = 1;
        private static int SHOW_STATUS_RAW = 2;

        public boolean checkValid() {
            return this.showStatus == SHOW_STATUS_RAW || this.showStatus == SHOW_STATUS_ZOOMING;
        }

        public boolean enableZooming() {
            return this.showStatus == SHOW_STATUS_ZOOMING;
        }
    }
}