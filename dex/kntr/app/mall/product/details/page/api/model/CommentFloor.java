package kntr.app.mall.product.details.page.api.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CommentFloor.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000212BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bBW\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\rHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0012¨\u00063"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CommentFloor;", "Lkntr/app/mall/product/details/page/api/model/FloorModel;", "floorKey", "", "floorIcon", "bgImgUrl", "showPreBuyComment", "", "avatar", "placeholderString", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFloorKey", "()Ljava/lang/String;", "getFloorIcon", "getBgImgUrl", "getShowPreBuyComment", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAvatar", "getPlaceholderString$annotations", "()V", "getPlaceholderString", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/CommentFloor;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class CommentFloor implements FloorModel {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String avatar;
    private final String bgImgUrl;
    private final String floorIcon;
    private final String floorKey;
    private final String placeholderString;
    private final Boolean showPreBuyComment;

    public CommentFloor() {
        this((String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CommentFloor copy$default(CommentFloor commentFloor, String str, String str2, String str3, Boolean bool, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = commentFloor.floorKey;
        }
        if ((i & 2) != 0) {
            str2 = commentFloor.floorIcon;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = commentFloor.bgImgUrl;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            bool = commentFloor.showPreBuyComment;
        }
        Boolean bool2 = bool;
        if ((i & 16) != 0) {
            str4 = commentFloor.avatar;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            str5 = commentFloor.placeholderString;
        }
        return commentFloor.copy(str, str6, str7, bool2, str8, str5);
    }

    @SerialName("placeHolder")
    public static /* synthetic */ void getPlaceholderString$annotations() {
    }

    public final String component1() {
        return this.floorKey;
    }

    public final String component2() {
        return this.floorIcon;
    }

    public final String component3() {
        return this.bgImgUrl;
    }

    public final Boolean component4() {
        return this.showPreBuyComment;
    }

    public final String component5() {
        return this.avatar;
    }

    public final String component6() {
        return this.placeholderString;
    }

    public final CommentFloor copy(String str, String str2, String str3, Boolean bool, String str4, String str5) {
        return new CommentFloor(str, str2, str3, bool, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CommentFloor) {
            CommentFloor commentFloor = (CommentFloor) obj;
            return Intrinsics.areEqual(this.floorKey, commentFloor.floorKey) && Intrinsics.areEqual(this.floorIcon, commentFloor.floorIcon) && Intrinsics.areEqual(this.bgImgUrl, commentFloor.bgImgUrl) && Intrinsics.areEqual(this.showPreBuyComment, commentFloor.showPreBuyComment) && Intrinsics.areEqual(this.avatar, commentFloor.avatar) && Intrinsics.areEqual(this.placeholderString, commentFloor.placeholderString);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((this.floorKey == null ? 0 : this.floorKey.hashCode()) * 31) + (this.floorIcon == null ? 0 : this.floorIcon.hashCode())) * 31) + (this.bgImgUrl == null ? 0 : this.bgImgUrl.hashCode())) * 31) + (this.showPreBuyComment == null ? 0 : this.showPreBuyComment.hashCode())) * 31) + (this.avatar == null ? 0 : this.avatar.hashCode())) * 31) + (this.placeholderString != null ? this.placeholderString.hashCode() : 0);
    }

    public String toString() {
        String str = this.floorKey;
        String str2 = this.floorIcon;
        String str3 = this.bgImgUrl;
        Boolean bool = this.showPreBuyComment;
        String str4 = this.avatar;
        return "CommentFloor(floorKey=" + str + ", floorIcon=" + str2 + ", bgImgUrl=" + str3 + ", showPreBuyComment=" + bool + ", avatar=" + str4 + ", placeholderString=" + this.placeholderString + ")";
    }

    /* compiled from: CommentFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CommentFloor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CommentFloor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CommentFloor> serializer() {
            return CommentFloor$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CommentFloor(int seen0, String floorKey, String floorIcon, String bgImgUrl, Boolean showPreBuyComment, String avatar, String placeholderString, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.floorKey = null;
        } else {
            this.floorKey = floorKey;
        }
        if ((seen0 & 2) == 0) {
            this.floorIcon = null;
        } else {
            this.floorIcon = floorIcon;
        }
        if ((seen0 & 4) == 0) {
            this.bgImgUrl = null;
        } else {
            this.bgImgUrl = bgImgUrl;
        }
        if ((seen0 & 8) == 0) {
            this.showPreBuyComment = null;
        } else {
            this.showPreBuyComment = showPreBuyComment;
        }
        if ((seen0 & 16) == 0) {
            this.avatar = null;
        } else {
            this.avatar = avatar;
        }
        if ((seen0 & 32) == 0) {
            this.placeholderString = null;
        } else {
            this.placeholderString = placeholderString;
        }
    }

    public CommentFloor(String floorKey, String floorIcon, String bgImgUrl, Boolean showPreBuyComment, String avatar, String placeholderString) {
        this.floorKey = floorKey;
        this.floorIcon = floorIcon;
        this.bgImgUrl = bgImgUrl;
        this.showPreBuyComment = showPreBuyComment;
        this.avatar = avatar;
        this.placeholderString = placeholderString;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(CommentFloor self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.getFloorKey() != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.getFloorKey());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.getFloorIcon() != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.getFloorIcon());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.getBgImgUrl() != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.getBgImgUrl());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.showPreBuyComment != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.showPreBuyComment);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.avatar != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.avatar);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.placeholderString != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.placeholderString);
        }
    }

    public /* synthetic */ CommentFloor(String str, String str2, String str3, Boolean bool, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
    }

    @Override // kntr.app.mall.product.details.page.api.model.FloorModel
    public String getFloorKey() {
        return this.floorKey;
    }

    @Override // kntr.app.mall.product.details.page.api.model.FloorModel
    public String getFloorIcon() {
        return this.floorIcon;
    }

    @Override // kntr.app.mall.product.details.page.api.model.FloorModel
    public String getBgImgUrl() {
        return this.bgImgUrl;
    }

    public final Boolean getShowPreBuyComment() {
        return this.showPreBuyComment;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getPlaceholderString() {
        return this.placeholderString;
    }
}