package kntr.app.oversea.translation.setting.guidance;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslationSettingGuidance.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003JU\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0014¨\u0006'"}, d2 = {"Lkntr/app/oversea/translation/setting/guidance/TranslationSettingGuidanceData;", "", "iconUrl", "", "title", "bulletList", "", "tip", "translateButtonText", "languageSettingsText", "settingButtonUri", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIconUrl", "()Ljava/lang/String;", "getTitle", "getBulletList", "()Ljava/util/List;", "getTip", "setTip", "(Ljava/lang/String;)V", "getTranslateButtonText", "getLanguageSettingsText", "getSettingButtonUri", "setSettingButtonUri", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "translation-setting-guidance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TranslationSettingGuidanceData {
    public static final int $stable = 8;
    private final List<String> bulletList;
    private final String iconUrl;
    private final String languageSettingsText;
    private String settingButtonUri;
    private String tip;
    private final String title;
    private final String translateButtonText;

    public static /* synthetic */ TranslationSettingGuidanceData copy$default(TranslationSettingGuidanceData translationSettingGuidanceData, String str, String str2, List list, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = translationSettingGuidanceData.iconUrl;
        }
        if ((i & 2) != 0) {
            str2 = translationSettingGuidanceData.title;
        }
        String str7 = str2;
        List<String> list2 = list;
        if ((i & 4) != 0) {
            list2 = translationSettingGuidanceData.bulletList;
        }
        List list3 = list2;
        if ((i & 8) != 0) {
            str3 = translationSettingGuidanceData.tip;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            str4 = translationSettingGuidanceData.translateButtonText;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            str5 = translationSettingGuidanceData.languageSettingsText;
        }
        String str10 = str5;
        if ((i & 64) != 0) {
            str6 = translationSettingGuidanceData.settingButtonUri;
        }
        return translationSettingGuidanceData.copy(str, str7, list3, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.iconUrl;
    }

    public final String component2() {
        return this.title;
    }

    public final List<String> component3() {
        return this.bulletList;
    }

    public final String component4() {
        return this.tip;
    }

    public final String component5() {
        return this.translateButtonText;
    }

    public final String component6() {
        return this.languageSettingsText;
    }

    public final String component7() {
        return this.settingButtonUri;
    }

    public final TranslationSettingGuidanceData copy(String str, String str2, List<String> list, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "iconUrl");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(list, "bulletList");
        Intrinsics.checkNotNullParameter(str3, "tip");
        Intrinsics.checkNotNullParameter(str4, "translateButtonText");
        Intrinsics.checkNotNullParameter(str5, "languageSettingsText");
        Intrinsics.checkNotNullParameter(str6, "settingButtonUri");
        return new TranslationSettingGuidanceData(str, str2, list, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TranslationSettingGuidanceData) {
            TranslationSettingGuidanceData translationSettingGuidanceData = (TranslationSettingGuidanceData) obj;
            return Intrinsics.areEqual(this.iconUrl, translationSettingGuidanceData.iconUrl) && Intrinsics.areEqual(this.title, translationSettingGuidanceData.title) && Intrinsics.areEqual(this.bulletList, translationSettingGuidanceData.bulletList) && Intrinsics.areEqual(this.tip, translationSettingGuidanceData.tip) && Intrinsics.areEqual(this.translateButtonText, translationSettingGuidanceData.translateButtonText) && Intrinsics.areEqual(this.languageSettingsText, translationSettingGuidanceData.languageSettingsText) && Intrinsics.areEqual(this.settingButtonUri, translationSettingGuidanceData.settingButtonUri);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.iconUrl.hashCode() * 31) + this.title.hashCode()) * 31) + this.bulletList.hashCode()) * 31) + this.tip.hashCode()) * 31) + this.translateButtonText.hashCode()) * 31) + this.languageSettingsText.hashCode()) * 31) + this.settingButtonUri.hashCode();
    }

    public String toString() {
        String str = this.iconUrl;
        String str2 = this.title;
        List<String> list = this.bulletList;
        String str3 = this.tip;
        String str4 = this.translateButtonText;
        String str5 = this.languageSettingsText;
        return "TranslationSettingGuidanceData(iconUrl=" + str + ", title=" + str2 + ", bulletList=" + list + ", tip=" + str3 + ", translateButtonText=" + str4 + ", languageSettingsText=" + str5 + ", settingButtonUri=" + this.settingButtonUri + ")";
    }

    public TranslationSettingGuidanceData(String iconUrl, String title, List<String> list, String tip, String translateButtonText, String languageSettingsText, String settingButtonUri) {
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(list, "bulletList");
        Intrinsics.checkNotNullParameter(tip, "tip");
        Intrinsics.checkNotNullParameter(translateButtonText, "translateButtonText");
        Intrinsics.checkNotNullParameter(languageSettingsText, "languageSettingsText");
        Intrinsics.checkNotNullParameter(settingButtonUri, "settingButtonUri");
        this.iconUrl = iconUrl;
        this.title = title;
        this.bulletList = list;
        this.tip = tip;
        this.translateButtonText = translateButtonText;
        this.languageSettingsText = languageSettingsText;
        this.settingButtonUri = settingButtonUri;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<String> getBulletList() {
        return this.bulletList;
    }

    public final String getTip() {
        return this.tip;
    }

    public final void setTip(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tip = str;
    }

    public final String getTranslateButtonText() {
        return this.translateButtonText;
    }

    public final String getLanguageSettingsText() {
        return this.languageSettingsText;
    }

    public final String getSettingButtonUri() {
        return this.settingButtonUri;
    }

    public final void setSettingButtonUri(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.settingButtonUri = str;
    }
}