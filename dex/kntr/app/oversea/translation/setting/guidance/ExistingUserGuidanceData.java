package kntr.app.oversea.translation.setting.guidance;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ExistingUserGuidanceData.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 92\u00020\u0001:\u000289BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rBu\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003Je\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u000fHÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001J%\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0001¢\u0006\u0002\b7R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b \u0010\u0014¨\u0006:"}, d2 = {"Lkntr/app/oversea/translation/setting/guidance/ExistingUserGuidanceData;", "", "title", "", "desc", "tip", "iconUrl", "confirmButtonText", "cancelButtonText", "gotoSettingsText", "gotoSettingsUri", "langChineseName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle", "()Ljava/lang/String;", "getDesc", "getTip", "getIconUrl", "getConfirmButtonText", "getCancelButtonText", "getGotoSettingsText", "getGotoSettingsUri", "getLangChineseName", "setLangChineseName", "(Ljava/lang/String;)V", "formattedDesc", "getFormattedDesc", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$translation_setting_guidance_debug", "$serializer", "Companion", "translation-setting-guidance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class ExistingUserGuidanceData {
    private final String cancelButtonText;
    private final String confirmButtonText;
    private final String desc;
    private final String gotoSettingsText;
    private final String gotoSettingsUri;
    private final String iconUrl;
    private String langChineseName;
    private final String tip;
    private final String title;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.desc;
    }

    public final String component3() {
        return this.tip;
    }

    public final String component4() {
        return this.iconUrl;
    }

    public final String component5() {
        return this.confirmButtonText;
    }

    public final String component6() {
        return this.cancelButtonText;
    }

    public final String component7() {
        return this.gotoSettingsText;
    }

    public final String component8() {
        return this.gotoSettingsUri;
    }

    public final String component9() {
        return this.langChineseName;
    }

    public final ExistingUserGuidanceData copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "desc");
        Intrinsics.checkNotNullParameter(str3, "tip");
        Intrinsics.checkNotNullParameter(str4, "iconUrl");
        Intrinsics.checkNotNullParameter(str5, "confirmButtonText");
        Intrinsics.checkNotNullParameter(str6, "cancelButtonText");
        Intrinsics.checkNotNullParameter(str7, "gotoSettingsText");
        Intrinsics.checkNotNullParameter(str8, "gotoSettingsUri");
        return new ExistingUserGuidanceData(str, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ExistingUserGuidanceData) {
            ExistingUserGuidanceData existingUserGuidanceData = (ExistingUserGuidanceData) obj;
            return Intrinsics.areEqual(this.title, existingUserGuidanceData.title) && Intrinsics.areEqual(this.desc, existingUserGuidanceData.desc) && Intrinsics.areEqual(this.tip, existingUserGuidanceData.tip) && Intrinsics.areEqual(this.iconUrl, existingUserGuidanceData.iconUrl) && Intrinsics.areEqual(this.confirmButtonText, existingUserGuidanceData.confirmButtonText) && Intrinsics.areEqual(this.cancelButtonText, existingUserGuidanceData.cancelButtonText) && Intrinsics.areEqual(this.gotoSettingsText, existingUserGuidanceData.gotoSettingsText) && Intrinsics.areEqual(this.gotoSettingsUri, existingUserGuidanceData.gotoSettingsUri) && Intrinsics.areEqual(this.langChineseName, existingUserGuidanceData.langChineseName);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((this.title.hashCode() * 31) + this.desc.hashCode()) * 31) + this.tip.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.confirmButtonText.hashCode()) * 31) + this.cancelButtonText.hashCode()) * 31) + this.gotoSettingsText.hashCode()) * 31) + this.gotoSettingsUri.hashCode()) * 31) + (this.langChineseName == null ? 0 : this.langChineseName.hashCode());
    }

    public String toString() {
        String str = this.title;
        String str2 = this.desc;
        String str3 = this.tip;
        String str4 = this.iconUrl;
        String str5 = this.confirmButtonText;
        String str6 = this.cancelButtonText;
        String str7 = this.gotoSettingsText;
        String str8 = this.gotoSettingsUri;
        return "ExistingUserGuidanceData(title=" + str + ", desc=" + str2 + ", tip=" + str3 + ", iconUrl=" + str4 + ", confirmButtonText=" + str5 + ", cancelButtonText=" + str6 + ", gotoSettingsText=" + str7 + ", gotoSettingsUri=" + str8 + ", langChineseName=" + this.langChineseName + ")";
    }

    /* compiled from: ExistingUserGuidanceData.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/oversea/translation/setting/guidance/ExistingUserGuidanceData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/oversea/translation/setting/guidance/ExistingUserGuidanceData;", "translation-setting-guidance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ExistingUserGuidanceData> serializer() {
            return ExistingUserGuidanceData$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ExistingUserGuidanceData(int seen0, String title, String desc, String tip, String iconUrl, String confirmButtonText, String cancelButtonText, String gotoSettingsText, String gotoSettingsUri, String langChineseName, SerializationConstructorMarker serializationConstructorMarker) {
        if (255 != (seen0 & KotlinVersion.MAX_COMPONENT_VALUE)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, (int) KotlinVersion.MAX_COMPONENT_VALUE, ExistingUserGuidanceData$$serializer.INSTANCE.getDescriptor());
        }
        this.title = title;
        this.desc = desc;
        this.tip = tip;
        this.iconUrl = iconUrl;
        this.confirmButtonText = confirmButtonText;
        this.cancelButtonText = cancelButtonText;
        this.gotoSettingsText = gotoSettingsText;
        this.gotoSettingsUri = gotoSettingsUri;
        if ((seen0 & 256) == 0) {
            this.langChineseName = null;
        } else {
            this.langChineseName = langChineseName;
        }
    }

    public ExistingUserGuidanceData(String title, String desc, String tip, String iconUrl, String confirmButtonText, String cancelButtonText, String gotoSettingsText, String gotoSettingsUri, String langChineseName) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(tip, "tip");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(confirmButtonText, "confirmButtonText");
        Intrinsics.checkNotNullParameter(cancelButtonText, "cancelButtonText");
        Intrinsics.checkNotNullParameter(gotoSettingsText, "gotoSettingsText");
        Intrinsics.checkNotNullParameter(gotoSettingsUri, "gotoSettingsUri");
        this.title = title;
        this.desc = desc;
        this.tip = tip;
        this.iconUrl = iconUrl;
        this.confirmButtonText = confirmButtonText;
        this.cancelButtonText = cancelButtonText;
        this.gotoSettingsText = gotoSettingsText;
        this.gotoSettingsUri = gotoSettingsUri;
        this.langChineseName = langChineseName;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$translation_setting_guidance_debug(ExistingUserGuidanceData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.title);
        output.encodeStringElement(serialDesc, 1, self.desc);
        output.encodeStringElement(serialDesc, 2, self.tip);
        output.encodeStringElement(serialDesc, 3, self.iconUrl);
        output.encodeStringElement(serialDesc, 4, self.confirmButtonText);
        output.encodeStringElement(serialDesc, 5, self.cancelButtonText);
        output.encodeStringElement(serialDesc, 6, self.gotoSettingsText);
        output.encodeStringElement(serialDesc, 7, self.gotoSettingsUri);
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.langChineseName != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.langChineseName);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ExistingUserGuidanceData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, str8, r10);
        String str10;
        if ((i & 256) == 0) {
            str10 = str9;
        } else {
            str10 = null;
        }
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getTip() {
        return this.tip;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getConfirmButtonText() {
        return this.confirmButtonText;
    }

    public final String getCancelButtonText() {
        return this.cancelButtonText;
    }

    public final String getGotoSettingsText() {
        return this.gotoSettingsText;
    }

    public final String getGotoSettingsUri() {
        return this.gotoSettingsUri;
    }

    public final String getLangChineseName() {
        return this.langChineseName;
    }

    public final void setLangChineseName(String str) {
        this.langChineseName = str;
    }

    public final String getFormattedDesc() {
        String str = this.langChineseName;
        if (str == null || StringsKt.isBlank(str)) {
            return this.desc;
        }
        String str2 = this.desc;
        String str3 = this.langChineseName;
        Intrinsics.checkNotNull(str3);
        return StringsKt.replace$default(str2, "%s", str3, false, 4, (Object) null);
    }
}