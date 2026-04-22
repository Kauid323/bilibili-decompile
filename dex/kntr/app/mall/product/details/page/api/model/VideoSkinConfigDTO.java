package kntr.app.mall.product.details.page.api.model;

import kntr.app.upcomingEpisode.ConstantsKt;
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

/* compiled from: ResponseModels.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\bHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006!"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/VideoSkinConfigDTO;", "", "progressBarColor", "", "progressBarIcon", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getProgressBarColor", "()Ljava/lang/String;", "getProgressBarIcon", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class VideoSkinConfigDTO {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String progressBarColor;
    private final String progressBarIcon;

    public VideoSkinConfigDTO() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ VideoSkinConfigDTO copy$default(VideoSkinConfigDTO videoSkinConfigDTO, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = videoSkinConfigDTO.progressBarColor;
        }
        if ((i & 2) != 0) {
            str2 = videoSkinConfigDTO.progressBarIcon;
        }
        return videoSkinConfigDTO.copy(str, str2);
    }

    public final String component1() {
        return this.progressBarColor;
    }

    public final String component2() {
        return this.progressBarIcon;
    }

    public final VideoSkinConfigDTO copy(String str, String str2) {
        return new VideoSkinConfigDTO(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VideoSkinConfigDTO) {
            VideoSkinConfigDTO videoSkinConfigDTO = (VideoSkinConfigDTO) obj;
            return Intrinsics.areEqual(this.progressBarColor, videoSkinConfigDTO.progressBarColor) && Intrinsics.areEqual(this.progressBarIcon, videoSkinConfigDTO.progressBarIcon);
        }
        return false;
    }

    public int hashCode() {
        return ((this.progressBarColor == null ? 0 : this.progressBarColor.hashCode()) * 31) + (this.progressBarIcon != null ? this.progressBarIcon.hashCode() : 0);
    }

    public String toString() {
        String str = this.progressBarColor;
        return "VideoSkinConfigDTO(progressBarColor=" + str + ", progressBarIcon=" + this.progressBarIcon + ")";
    }

    /* compiled from: ResponseModels.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/VideoSkinConfigDTO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/VideoSkinConfigDTO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<VideoSkinConfigDTO> serializer() {
            return VideoSkinConfigDTO$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ VideoSkinConfigDTO(int seen0, String progressBarColor, String progressBarIcon, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.progressBarColor = null;
        } else {
            this.progressBarColor = progressBarColor;
        }
        if ((seen0 & 2) == 0) {
            this.progressBarIcon = null;
        } else {
            this.progressBarIcon = progressBarIcon;
        }
    }

    public VideoSkinConfigDTO(String progressBarColor, String progressBarIcon) {
        this.progressBarColor = progressBarColor;
        this.progressBarIcon = progressBarIcon;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(VideoSkinConfigDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.progressBarColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.progressBarColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.progressBarIcon != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.progressBarIcon);
        }
    }

    public /* synthetic */ VideoSkinConfigDTO(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getProgressBarColor() {
        return this.progressBarColor;
    }

    public final String getProgressBarIcon() {
        return this.progressBarIcon;
    }
}