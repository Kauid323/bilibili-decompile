package kntr.app.ad.common.model;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdFullText.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tBM\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u000bHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0010R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0012\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010¨\u0006-"}, d2 = {"Lkntr/app/ad/common/model/AdFullText;", RoomRecommendViewModel.EMPTY_CURSOR, "icon", RoomRecommendViewModel.EMPTY_CURSOR, "iconNight", "jumpUrl", "prefix", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getIcon", "()Ljava/lang/String;", "getIconNight$annotations", "()V", "getIconNight", "getJumpUrl$annotations", "getJumpUrl", "getPrefix", "getText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdFullText {
    public static final Companion Companion = new Companion(null);
    private final String icon;
    private final String iconNight;
    private final String jumpUrl;
    private final String prefix;
    private final String text;

    public AdFullText() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdFullText copy$default(AdFullText adFullText, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adFullText.icon;
        }
        if ((i & 2) != 0) {
            str2 = adFullText.iconNight;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = adFullText.jumpUrl;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = adFullText.prefix;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = adFullText.text;
        }
        return adFullText.copy(str, str6, str7, str8, str5);
    }

    @SerialName("icon_for_night")
    public static /* synthetic */ void getIconNight$annotations() {
    }

    @SerialName("jump_uri")
    public static /* synthetic */ void getJumpUrl$annotations() {
    }

    public final String component1() {
        return this.icon;
    }

    public final String component2() {
        return this.iconNight;
    }

    public final String component3() {
        return this.jumpUrl;
    }

    public final String component4() {
        return this.prefix;
    }

    public final String component5() {
        return this.text;
    }

    public final AdFullText copy(String str, String str2, String str3, String str4, String str5) {
        return new AdFullText(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdFullText) {
            AdFullText adFullText = (AdFullText) obj;
            return Intrinsics.areEqual(this.icon, adFullText.icon) && Intrinsics.areEqual(this.iconNight, adFullText.iconNight) && Intrinsics.areEqual(this.jumpUrl, adFullText.jumpUrl) && Intrinsics.areEqual(this.prefix, adFullText.prefix) && Intrinsics.areEqual(this.text, adFullText.text);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.icon == null ? 0 : this.icon.hashCode()) * 31) + (this.iconNight == null ? 0 : this.iconNight.hashCode())) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.prefix == null ? 0 : this.prefix.hashCode())) * 31) + (this.text != null ? this.text.hashCode() : 0);
    }

    public String toString() {
        String str = this.icon;
        String str2 = this.iconNight;
        String str3 = this.jumpUrl;
        String str4 = this.prefix;
        return "AdFullText(icon=" + str + ", iconNight=" + str2 + ", jumpUrl=" + str3 + ", prefix=" + str4 + ", text=" + this.text + ")";
    }

    /* compiled from: AdFullText.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdFullText$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdFullText;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdFullText> serializer() {
            return AdFullText$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdFullText(int seen0, String icon, String iconNight, String jumpUrl, String prefix, String text, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.icon = null;
        } else {
            this.icon = icon;
        }
        if ((seen0 & 2) == 0) {
            this.iconNight = null;
        } else {
            this.iconNight = iconNight;
        }
        if ((seen0 & 4) == 0) {
            this.jumpUrl = null;
        } else {
            this.jumpUrl = jumpUrl;
        }
        if ((seen0 & 8) == 0) {
            this.prefix = null;
        } else {
            this.prefix = prefix;
        }
        if ((seen0 & 16) == 0) {
            this.text = null;
        } else {
            this.text = text;
        }
    }

    public AdFullText(String icon, String iconNight, String jumpUrl, String prefix, String text) {
        this.icon = icon;
        this.iconNight = iconNight;
        this.jumpUrl = jumpUrl;
        this.prefix = prefix;
        this.text = text;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdFullText self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.icon != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.icon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.iconNight != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.iconNight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.jumpUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.jumpUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.prefix != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.prefix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.text != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.text);
        }
    }

    public /* synthetic */ AdFullText(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getIconNight() {
        return this.iconNight;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final String getText() {
        return this.text;
    }
}