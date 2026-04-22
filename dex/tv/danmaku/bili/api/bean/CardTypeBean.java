package tv.danmaku.bili.api.bean;

import BottomSheetItemData$;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.lib.dd.DeviceDecision;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: CardTypeBean.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J=\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\"\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001e\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017¨\u0006&"}, d2 = {"Ltv/danmaku/bili/api/bean/CardTypeBean;", "", "id", "", ChannelRoutes.CHANNEL_NAME, "", "genderRequired", "", "birthdayRequired", "onlyManualVerification", "<init>", "(ILjava/lang/String;ZZZ)V", "getId", "()I", "setId", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getGenderRequired", "()Z", "setGenderRequired", "(Z)V", "getBirthdayRequired", "setBirthdayRequired", "getOnlyManualVerification", "setOnlyManualVerification", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CardTypeBean {
    @JSONField(name = "birthday_required")
    private boolean birthdayRequired;
    @JSONField(name = "gender_required")
    private boolean genderRequired;
    @JSONField(name = "id")
    private int id;
    @JSONField(name = ChannelRoutes.CHANNEL_NAME)
    private String name;
    @JSONField(name = "only_manual_verification")
    private boolean onlyManualVerification;

    public CardTypeBean() {
        this(0, null, false, false, false, 31, null);
    }

    public static /* synthetic */ CardTypeBean copy$default(CardTypeBean cardTypeBean, int i, String str, boolean z, boolean z2, boolean z3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = cardTypeBean.id;
        }
        if ((i2 & 2) != 0) {
            str = cardTypeBean.name;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            z = cardTypeBean.genderRequired;
        }
        boolean z4 = z;
        if ((i2 & 8) != 0) {
            z2 = cardTypeBean.birthdayRequired;
        }
        boolean z5 = z2;
        if ((i2 & 16) != 0) {
            z3 = cardTypeBean.onlyManualVerification;
        }
        return cardTypeBean.copy(i, str2, z4, z5, z3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final boolean component3() {
        return this.genderRequired;
    }

    public final boolean component4() {
        return this.birthdayRequired;
    }

    public final boolean component5() {
        return this.onlyManualVerification;
    }

    public final CardTypeBean copy(int i, String str, boolean z, boolean z2, boolean z3) {
        return new CardTypeBean(i, str, z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CardTypeBean) {
            CardTypeBean cardTypeBean = (CardTypeBean) obj;
            return this.id == cardTypeBean.id && Intrinsics.areEqual(this.name, cardTypeBean.name) && this.genderRequired == cardTypeBean.genderRequired && this.birthdayRequired == cardTypeBean.birthdayRequired && this.onlyManualVerification == cardTypeBean.onlyManualVerification;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.id * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.genderRequired)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.birthdayRequired)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.onlyManualVerification);
    }

    public String toString() {
        int i = this.id;
        String str = this.name;
        boolean z = this.genderRequired;
        boolean z2 = this.birthdayRequired;
        return "CardTypeBean(id=" + i + ", name=" + str + ", genderRequired=" + z + ", birthdayRequired=" + z2 + ", onlyManualVerification=" + this.onlyManualVerification + ")";
    }

    public CardTypeBean(int id, String name, boolean genderRequired, boolean birthdayRequired, boolean onlyManualVerification) {
        this.id = id;
        this.name = name;
        this.genderRequired = genderRequired;
        this.birthdayRequired = birthdayRequired;
        this.onlyManualVerification = onlyManualVerification;
    }

    public /* synthetic */ CardTypeBean(int i, String str, boolean z, boolean z2, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? DeviceDecision.INSTANCE.dd("auth_card_type_resident_id", "居民身份证") : str, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? false : z3);
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final boolean getGenderRequired() {
        return this.genderRequired;
    }

    public final void setGenderRequired(boolean z) {
        this.genderRequired = z;
    }

    public final boolean getBirthdayRequired() {
        return this.birthdayRequired;
    }

    public final void setBirthdayRequired(boolean z) {
        this.birthdayRequired = z;
    }

    public final boolean getOnlyManualVerification() {
        return this.onlyManualVerification;
    }

    public final void setOnlyManualVerification(boolean z) {
        this.onlyManualVerification = z;
    }
}