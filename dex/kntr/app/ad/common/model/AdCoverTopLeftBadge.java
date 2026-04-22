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

/* compiled from: AdCoverTopLeftBadge.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB?\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\rJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J5\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006("}, d2 = {"Lkntr/app/ad/common/model/AdCoverTopLeftBadge;", RoomRecommendViewModel.EMPTY_CURSOR, "iconUrl", RoomRecommendViewModel.EMPTY_CURSOR, "iconNightUrl", "iconWidth", RoomRecommendViewModel.EMPTY_CURSOR, "iconHeight", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;IILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getIconUrl", "()Ljava/lang/String;", "getIconNightUrl", "getIconWidth", "()I", "getIconHeight", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdCoverTopLeftBadge {
    public static final Companion Companion = new Companion(null);
    private final int iconHeight;
    private final String iconNightUrl;
    private final String iconUrl;
    private final int iconWidth;

    public AdCoverTopLeftBadge() {
        this((String) null, (String) null, 0, 0, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdCoverTopLeftBadge copy$default(AdCoverTopLeftBadge adCoverTopLeftBadge, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = adCoverTopLeftBadge.iconUrl;
        }
        if ((i3 & 2) != 0) {
            str2 = adCoverTopLeftBadge.iconNightUrl;
        }
        if ((i3 & 4) != 0) {
            i = adCoverTopLeftBadge.iconWidth;
        }
        if ((i3 & 8) != 0) {
            i2 = adCoverTopLeftBadge.iconHeight;
        }
        return adCoverTopLeftBadge.copy(str, str2, i, i2);
    }

    public final String component1() {
        return this.iconUrl;
    }

    public final String component2() {
        return this.iconNightUrl;
    }

    public final int component3() {
        return this.iconWidth;
    }

    public final int component4() {
        return this.iconHeight;
    }

    public final AdCoverTopLeftBadge copy(String str, String str2, int i, int i2) {
        return new AdCoverTopLeftBadge(str, str2, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdCoverTopLeftBadge) {
            AdCoverTopLeftBadge adCoverTopLeftBadge = (AdCoverTopLeftBadge) obj;
            return Intrinsics.areEqual(this.iconUrl, adCoverTopLeftBadge.iconUrl) && Intrinsics.areEqual(this.iconNightUrl, adCoverTopLeftBadge.iconNightUrl) && this.iconWidth == adCoverTopLeftBadge.iconWidth && this.iconHeight == adCoverTopLeftBadge.iconHeight;
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.iconUrl == null ? 0 : this.iconUrl.hashCode()) * 31) + (this.iconNightUrl != null ? this.iconNightUrl.hashCode() : 0)) * 31) + this.iconWidth) * 31) + this.iconHeight;
    }

    public String toString() {
        String str = this.iconUrl;
        String str2 = this.iconNightUrl;
        int i = this.iconWidth;
        return "AdCoverTopLeftBadge(iconUrl=" + str + ", iconNightUrl=" + str2 + ", iconWidth=" + i + ", iconHeight=" + this.iconHeight + ")";
    }

    /* compiled from: AdCoverTopLeftBadge.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdCoverTopLeftBadge$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdCoverTopLeftBadge;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdCoverTopLeftBadge> serializer() {
            return AdCoverTopLeftBadge$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdCoverTopLeftBadge(int seen0, String iconUrl, String iconNightUrl, int iconWidth, int iconHeight, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.iconUrl = null;
        } else {
            this.iconUrl = iconUrl;
        }
        if ((seen0 & 2) == 0) {
            this.iconNightUrl = null;
        } else {
            this.iconNightUrl = iconNightUrl;
        }
        if ((seen0 & 4) == 0) {
            this.iconWidth = 0;
        } else {
            this.iconWidth = iconWidth;
        }
        if ((seen0 & 8) == 0) {
            this.iconHeight = 0;
        } else {
            this.iconHeight = iconHeight;
        }
    }

    public AdCoverTopLeftBadge(String iconUrl, String iconNightUrl, int iconWidth, int iconHeight) {
        this.iconUrl = iconUrl;
        this.iconNightUrl = iconNightUrl;
        this.iconWidth = iconWidth;
        this.iconHeight = iconHeight;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdCoverTopLeftBadge self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.iconUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.iconUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.iconNightUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.iconNightUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.iconWidth != 0) {
            output.encodeIntElement(serialDesc, 2, self.iconWidth);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.iconHeight != 0) {
            output.encodeIntElement(serialDesc, 3, self.iconHeight);
        }
    }

    public /* synthetic */ AdCoverTopLeftBadge(String str, String str2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getIconNightUrl() {
        return this.iconNightUrl;
    }

    public final int getIconWidth() {
        return this.iconWidth;
    }

    public final int getIconHeight() {
        return this.iconHeight;
    }
}