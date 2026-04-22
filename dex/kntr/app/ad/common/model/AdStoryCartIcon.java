package kntr.app.ad.common.model;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdStoryCartIcon.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006$"}, d2 = {"Lkntr/app/ad/common/model/AdStoryCartIcon;", RoomRecommendViewModel.EMPTY_CURSOR, "iconUrl", RoomRecommendViewModel.EMPTY_CURSOR, "iconText", "iconTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getIconUrl", "()Ljava/lang/String;", "getIconText", "getIconTitle", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdStoryCartIcon {
    public static final Companion Companion = new Companion(null);
    private final String iconText;
    private final String iconTitle;
    private final String iconUrl;

    public AdStoryCartIcon() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdStoryCartIcon copy$default(AdStoryCartIcon adStoryCartIcon, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adStoryCartIcon.iconUrl;
        }
        if ((i & 2) != 0) {
            str2 = adStoryCartIcon.iconText;
        }
        if ((i & 4) != 0) {
            str3 = adStoryCartIcon.iconTitle;
        }
        return adStoryCartIcon.copy(str, str2, str3);
    }

    public final String component1() {
        return this.iconUrl;
    }

    public final String component2() {
        return this.iconText;
    }

    public final String component3() {
        return this.iconTitle;
    }

    public final AdStoryCartIcon copy(String str, String str2, String str3) {
        return new AdStoryCartIcon(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdStoryCartIcon) {
            AdStoryCartIcon adStoryCartIcon = (AdStoryCartIcon) obj;
            return Intrinsics.areEqual(this.iconUrl, adStoryCartIcon.iconUrl) && Intrinsics.areEqual(this.iconText, adStoryCartIcon.iconText) && Intrinsics.areEqual(this.iconTitle, adStoryCartIcon.iconTitle);
        }
        return false;
    }

    public int hashCode() {
        return ((((this.iconUrl == null ? 0 : this.iconUrl.hashCode()) * 31) + (this.iconText == null ? 0 : this.iconText.hashCode())) * 31) + (this.iconTitle != null ? this.iconTitle.hashCode() : 0);
    }

    public String toString() {
        String str = this.iconUrl;
        String str2 = this.iconText;
        return "AdStoryCartIcon(iconUrl=" + str + ", iconText=" + str2 + ", iconTitle=" + this.iconTitle + ")";
    }

    /* compiled from: AdStoryCartIcon.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdStoryCartIcon$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdStoryCartIcon;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdStoryCartIcon> serializer() {
            return AdStoryCartIcon$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdStoryCartIcon(int seen0, String iconUrl, String iconText, String iconTitle, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.iconUrl = null;
        } else {
            this.iconUrl = iconUrl;
        }
        if ((seen0 & 2) == 0) {
            this.iconText = null;
        } else {
            this.iconText = iconText;
        }
        if ((seen0 & 4) == 0) {
            this.iconTitle = null;
        } else {
            this.iconTitle = iconTitle;
        }
    }

    public AdStoryCartIcon(String iconUrl, String iconText, String iconTitle) {
        this.iconUrl = iconUrl;
        this.iconText = iconText;
        this.iconTitle = iconTitle;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdStoryCartIcon self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.iconUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.iconUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.iconText != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.iconText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.iconTitle != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.iconTitle);
        }
    }

    public /* synthetic */ AdStoryCartIcon(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getIconText() {
        return this.iconText;
    }

    public final String getIconTitle() {
        return this.iconTitle;
    }
}