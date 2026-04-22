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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ActionIconModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 N2\u00020\u0001:\u0002MNB£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014B\u009d\u0001\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0013\u0010\u0018J/\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010-\u001a\u00020\u00032\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010/\u001a\u00020\u0003H\u0000¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010<\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jª\u0001\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020\u00032\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020\u000fHÖ\u0001J\t\u0010D\u001a\u00020\u0005HÖ\u0001J%\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0001¢\u0006\u0002\bLR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010(\u001a\u0004\b)\u0010'R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001d¨\u0006O"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActionIconModel;", "", "active", "", "activeIcon", "", "activeNightIcon", "activatedIcon", "desc", "icon", "nightIcon", "jumpUrl", "shareExtra", "Lkntr/app/mall/product/details/page/api/model/ShareExtra;", "count", "", "type", "iconOutlineColor", "shareTemplateId", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ShareExtra;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ShareExtra;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActive", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getActiveIcon", "()Ljava/lang/String;", "getActiveNightIcon", "getActivatedIcon", "getDesc", "getIcon", "getNightIcon", "getJumpUrl", "getShareExtra", "()Lkntr/app/mall/product/details/page/api/model/ShareExtra;", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getType", "getIconOutlineColor", "getShareTemplateId", "getIconUrl", "isLight", "outerActive", "useStaticActiveIcon", "getIconUrl$product_details_page_debug", "(ZLjava/lang/Boolean;Z)Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ShareExtra;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/ActionIconModel;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class ActionIconModel {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String activatedIcon;
    private final Boolean active;
    private final String activeIcon;
    private final String activeNightIcon;
    private final Integer count;
    private final String desc;
    private final String icon;
    private final String iconOutlineColor;
    private final String jumpUrl;
    private final String nightIcon;
    private final ShareExtra shareExtra;
    private final String shareTemplateId;
    private final Integer type;

    public ActionIconModel() {
        this((Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (ShareExtra) null, (Integer) null, (Integer) null, (String) null, (String) null, 8191, (DefaultConstructorMarker) null);
    }

    public final Boolean component1() {
        return this.active;
    }

    public final Integer component10() {
        return this.count;
    }

    public final Integer component11() {
        return this.type;
    }

    public final String component12() {
        return this.iconOutlineColor;
    }

    public final String component13() {
        return this.shareTemplateId;
    }

    public final String component2() {
        return this.activeIcon;
    }

    public final String component3() {
        return this.activeNightIcon;
    }

    public final String component4() {
        return this.activatedIcon;
    }

    public final String component5() {
        return this.desc;
    }

    public final String component6() {
        return this.icon;
    }

    public final String component7() {
        return this.nightIcon;
    }

    public final String component8() {
        return this.jumpUrl;
    }

    public final ShareExtra component9() {
        return this.shareExtra;
    }

    public final ActionIconModel copy(Boolean bool, String str, String str2, String str3, String str4, String str5, String str6, String str7, ShareExtra shareExtra, Integer num, Integer num2, String str8, String str9) {
        return new ActionIconModel(bool, str, str2, str3, str4, str5, str6, str7, shareExtra, num, num2, str8, str9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActionIconModel) {
            ActionIconModel actionIconModel = (ActionIconModel) obj;
            return Intrinsics.areEqual(this.active, actionIconModel.active) && Intrinsics.areEqual(this.activeIcon, actionIconModel.activeIcon) && Intrinsics.areEqual(this.activeNightIcon, actionIconModel.activeNightIcon) && Intrinsics.areEqual(this.activatedIcon, actionIconModel.activatedIcon) && Intrinsics.areEqual(this.desc, actionIconModel.desc) && Intrinsics.areEqual(this.icon, actionIconModel.icon) && Intrinsics.areEqual(this.nightIcon, actionIconModel.nightIcon) && Intrinsics.areEqual(this.jumpUrl, actionIconModel.jumpUrl) && Intrinsics.areEqual(this.shareExtra, actionIconModel.shareExtra) && Intrinsics.areEqual(this.count, actionIconModel.count) && Intrinsics.areEqual(this.type, actionIconModel.type) && Intrinsics.areEqual(this.iconOutlineColor, actionIconModel.iconOutlineColor) && Intrinsics.areEqual(this.shareTemplateId, actionIconModel.shareTemplateId);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((this.active == null ? 0 : this.active.hashCode()) * 31) + (this.activeIcon == null ? 0 : this.activeIcon.hashCode())) * 31) + (this.activeNightIcon == null ? 0 : this.activeNightIcon.hashCode())) * 31) + (this.activatedIcon == null ? 0 : this.activatedIcon.hashCode())) * 31) + (this.desc == null ? 0 : this.desc.hashCode())) * 31) + (this.icon == null ? 0 : this.icon.hashCode())) * 31) + (this.nightIcon == null ? 0 : this.nightIcon.hashCode())) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.shareExtra == null ? 0 : this.shareExtra.hashCode())) * 31) + (this.count == null ? 0 : this.count.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.iconOutlineColor == null ? 0 : this.iconOutlineColor.hashCode())) * 31) + (this.shareTemplateId != null ? this.shareTemplateId.hashCode() : 0);
    }

    public String toString() {
        Boolean bool = this.active;
        String str = this.activeIcon;
        String str2 = this.activeNightIcon;
        String str3 = this.activatedIcon;
        String str4 = this.desc;
        String str5 = this.icon;
        String str6 = this.nightIcon;
        String str7 = this.jumpUrl;
        ShareExtra shareExtra = this.shareExtra;
        Integer num = this.count;
        Integer num2 = this.type;
        String str8 = this.iconOutlineColor;
        return "ActionIconModel(active=" + bool + ", activeIcon=" + str + ", activeNightIcon=" + str2 + ", activatedIcon=" + str3 + ", desc=" + str4 + ", icon=" + str5 + ", nightIcon=" + str6 + ", jumpUrl=" + str7 + ", shareExtra=" + shareExtra + ", count=" + num + ", type=" + num2 + ", iconOutlineColor=" + str8 + ", shareTemplateId=" + this.shareTemplateId + ")";
    }

    /* compiled from: ActionIconModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActionIconModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActionIconModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ActionIconModel> serializer() {
            return ActionIconModel$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ActionIconModel(int seen0, Boolean active, String activeIcon, String activeNightIcon, String activatedIcon, String desc, String icon, String nightIcon, String jumpUrl, ShareExtra shareExtra, Integer count, Integer type, String iconOutlineColor, String shareTemplateId, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.active = null;
        } else {
            this.active = active;
        }
        if ((seen0 & 2) == 0) {
            this.activeIcon = null;
        } else {
            this.activeIcon = activeIcon;
        }
        if ((seen0 & 4) == 0) {
            this.activeNightIcon = null;
        } else {
            this.activeNightIcon = activeNightIcon;
        }
        if ((seen0 & 8) == 0) {
            this.activatedIcon = null;
        } else {
            this.activatedIcon = activatedIcon;
        }
        if ((seen0 & 16) == 0) {
            this.desc = null;
        } else {
            this.desc = desc;
        }
        if ((seen0 & 32) == 0) {
            this.icon = null;
        } else {
            this.icon = icon;
        }
        if ((seen0 & 64) == 0) {
            this.nightIcon = null;
        } else {
            this.nightIcon = nightIcon;
        }
        if ((seen0 & 128) == 0) {
            this.jumpUrl = null;
        } else {
            this.jumpUrl = jumpUrl;
        }
        if ((seen0 & 256) == 0) {
            this.shareExtra = null;
        } else {
            this.shareExtra = shareExtra;
        }
        if ((seen0 & 512) == 0) {
            this.count = null;
        } else {
            this.count = count;
        }
        if ((seen0 & 1024) == 0) {
            this.type = null;
        } else {
            this.type = type;
        }
        if ((seen0 & 2048) == 0) {
            this.iconOutlineColor = null;
        } else {
            this.iconOutlineColor = iconOutlineColor;
        }
        if ((seen0 & 4096) == 0) {
            this.shareTemplateId = null;
        } else {
            this.shareTemplateId = shareTemplateId;
        }
    }

    public ActionIconModel(Boolean active, String activeIcon, String activeNightIcon, String activatedIcon, String desc, String icon, String nightIcon, String jumpUrl, ShareExtra shareExtra, Integer count, Integer type, String iconOutlineColor, String shareTemplateId) {
        this.active = active;
        this.activeIcon = activeIcon;
        this.activeNightIcon = activeNightIcon;
        this.activatedIcon = activatedIcon;
        this.desc = desc;
        this.icon = icon;
        this.nightIcon = nightIcon;
        this.jumpUrl = jumpUrl;
        this.shareExtra = shareExtra;
        this.count = count;
        this.type = type;
        this.iconOutlineColor = iconOutlineColor;
        this.shareTemplateId = shareTemplateId;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(ActionIconModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.active != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.active);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.activeIcon != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.activeIcon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.activeNightIcon != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.activeNightIcon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.activatedIcon != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.activatedIcon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.desc != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.desc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.icon != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.icon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.nightIcon != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.nightIcon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.jumpUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.jumpUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.shareExtra != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, ShareExtra$$serializer.INSTANCE, self.shareExtra);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.count != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, IntSerializer.INSTANCE, self.count);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.type != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, IntSerializer.INSTANCE, self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.iconOutlineColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.iconOutlineColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.shareTemplateId != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.shareTemplateId);
        }
    }

    public /* synthetic */ ActionIconModel(Boolean bool, String str, String str2, String str3, String str4, String str5, String str6, String str7, ShareExtra shareExtra, Integer num, Integer num2, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : shareExtra, (i & 512) != 0 ? null : num, (i & 1024) != 0 ? null : num2, (i & 2048) != 0 ? null : str8, (i & 4096) == 0 ? str9 : null);
    }

    public final Boolean getActive() {
        return this.active;
    }

    public final String getActiveIcon() {
        return this.activeIcon;
    }

    public final String getActiveNightIcon() {
        return this.activeNightIcon;
    }

    public final String getActivatedIcon() {
        return this.activatedIcon;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getNightIcon() {
        return this.nightIcon;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final ShareExtra getShareExtra() {
        return this.shareExtra;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getIconOutlineColor() {
        return this.iconOutlineColor;
    }

    public final String getShareTemplateId() {
        return this.shareTemplateId;
    }

    public static /* synthetic */ String getIconUrl$product_details_page_debug$default(ActionIconModel actionIconModel, boolean z, Boolean bool, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = null;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return actionIconModel.getIconUrl$product_details_page_debug(z, bool, z2);
    }

    public final String getIconUrl$product_details_page_debug(boolean isLight, Boolean outerActive, boolean useStaticActiveIcon) {
        Integer num;
        Boolean active = outerActive == null ? this.active : outerActive;
        boolean z = true;
        if (Intrinsics.areEqual(active, true) && useStaticActiveIcon && (num = this.type) != null && num.intValue() == 6) {
            String str = this.activatedIcon;
            if (str != null && str.length() != 0) {
                z = false;
            }
            if (z) {
                if (isLight) {
                    return "https://i0.hdslb.com/bfs/kfptfe/floor/245db7967414c920c90a346d5cd560a9b80f84e5.png";
                }
                return "https://i0.hdslb.com/bfs/kfptfe/floor/671675b1c219fea80921c4434b221249ea91b808.png";
            }
            return this.activatedIcon;
        } else if (Intrinsics.areEqual(active, true)) {
            String str2 = this.activeIcon;
            return str2 == null ? this.icon : str2;
        } else {
            return this.icon;
        }
    }
}