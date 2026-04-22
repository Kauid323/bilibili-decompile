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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bBC\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\nHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006'"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/GlobalSkinConfigDTO;", "", "fontColor", "", "selectBgColor", "refreshIcon", "refreshIconGif", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFontColor", "()Ljava/lang/String;", "getSelectBgColor", "getRefreshIcon", "getRefreshIconGif", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class GlobalSkinConfigDTO {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String fontColor;
    private final String refreshIcon;
    private final String refreshIconGif;
    private final String selectBgColor;

    public GlobalSkinConfigDTO() {
        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GlobalSkinConfigDTO copy$default(GlobalSkinConfigDTO globalSkinConfigDTO, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = globalSkinConfigDTO.fontColor;
        }
        if ((i & 2) != 0) {
            str2 = globalSkinConfigDTO.selectBgColor;
        }
        if ((i & 4) != 0) {
            str3 = globalSkinConfigDTO.refreshIcon;
        }
        if ((i & 8) != 0) {
            str4 = globalSkinConfigDTO.refreshIconGif;
        }
        return globalSkinConfigDTO.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.fontColor;
    }

    public final String component2() {
        return this.selectBgColor;
    }

    public final String component3() {
        return this.refreshIcon;
    }

    public final String component4() {
        return this.refreshIconGif;
    }

    public final GlobalSkinConfigDTO copy(String str, String str2, String str3, String str4) {
        return new GlobalSkinConfigDTO(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GlobalSkinConfigDTO) {
            GlobalSkinConfigDTO globalSkinConfigDTO = (GlobalSkinConfigDTO) obj;
            return Intrinsics.areEqual(this.fontColor, globalSkinConfigDTO.fontColor) && Intrinsics.areEqual(this.selectBgColor, globalSkinConfigDTO.selectBgColor) && Intrinsics.areEqual(this.refreshIcon, globalSkinConfigDTO.refreshIcon) && Intrinsics.areEqual(this.refreshIconGif, globalSkinConfigDTO.refreshIconGif);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.fontColor == null ? 0 : this.fontColor.hashCode()) * 31) + (this.selectBgColor == null ? 0 : this.selectBgColor.hashCode())) * 31) + (this.refreshIcon == null ? 0 : this.refreshIcon.hashCode())) * 31) + (this.refreshIconGif != null ? this.refreshIconGif.hashCode() : 0);
    }

    public String toString() {
        String str = this.fontColor;
        String str2 = this.selectBgColor;
        String str3 = this.refreshIcon;
        return "GlobalSkinConfigDTO(fontColor=" + str + ", selectBgColor=" + str2 + ", refreshIcon=" + str3 + ", refreshIconGif=" + this.refreshIconGif + ")";
    }

    /* compiled from: ResponseModels.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/GlobalSkinConfigDTO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/GlobalSkinConfigDTO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<GlobalSkinConfigDTO> serializer() {
            return GlobalSkinConfigDTO$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ GlobalSkinConfigDTO(int seen0, String fontColor, String selectBgColor, String refreshIcon, String refreshIconGif, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.fontColor = null;
        } else {
            this.fontColor = fontColor;
        }
        if ((seen0 & 2) == 0) {
            this.selectBgColor = null;
        } else {
            this.selectBgColor = selectBgColor;
        }
        if ((seen0 & 4) == 0) {
            this.refreshIcon = null;
        } else {
            this.refreshIcon = refreshIcon;
        }
        if ((seen0 & 8) == 0) {
            this.refreshIconGif = null;
        } else {
            this.refreshIconGif = refreshIconGif;
        }
    }

    public GlobalSkinConfigDTO(String fontColor, String selectBgColor, String refreshIcon, String refreshIconGif) {
        this.fontColor = fontColor;
        this.selectBgColor = selectBgColor;
        this.refreshIcon = refreshIcon;
        this.refreshIconGif = refreshIconGif;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(GlobalSkinConfigDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.fontColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.fontColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.selectBgColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.selectBgColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.refreshIcon != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.refreshIcon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.refreshIconGif != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.refreshIconGif);
        }
    }

    public /* synthetic */ GlobalSkinConfigDTO(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getFontColor() {
        return this.fontColor;
    }

    public final String getSelectBgColor() {
        return this.selectBgColor;
    }

    public final String getRefreshIcon() {
        return this.refreshIcon;
    }

    public final String getRefreshIconGif() {
        return this.refreshIconGif;
    }
}