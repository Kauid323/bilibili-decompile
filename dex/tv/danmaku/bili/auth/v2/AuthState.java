package tv.danmaku.bili.auth.v2;

import BottomSheetItemData$;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.api.bean.CardTypeBean;
import tv.danmaku.bili.api.bean.Gender;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: AuthV2ViewModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\tJ\u000e\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00108\u001a\u00020\tHÆ\u0003J\t\u00109\u001a\u00020\tHÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J\t\u0010;\u001a\u00020\u000eHÆ\u0003JW\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010=\u001a\u00020\u000e2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020@HÖ\u0001J\t\u0010A\u001a\u000202HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010#\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b$\u0010\u001dR\u0011\u0010%\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b&\u0010\u001dR\u0011\u0010'\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b(\u0010\u001dR\u0014\u0010)\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u001dR\u0014\u0010+\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u001dR\u0014\u0010-\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u001dR\u0014\u0010/\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u001dR\u0011\u00101\u001a\u0002028F¢\u0006\u0006\u001a\u0004\b3\u00104¨\u0006B"}, d2 = {"Ltv/danmaku/bili/auth/v2/AuthState;", "", "type", "Ltv/danmaku/bili/api/bean/CardTypeBean;", "gender", "Ltv/danmaku/bili/api/bean/Gender;", "birth", "Ltv/danmaku/bili/auth/v2/AuthDate;", ChannelRoutes.CHANNEL_NAME, "Ltv/danmaku/bili/auth/v2/Content;", "card", "typeList", "", "agreementChecked", "", "<init>", "(Ltv/danmaku/bili/api/bean/CardTypeBean;Ltv/danmaku/bili/api/bean/Gender;Ltv/danmaku/bili/auth/v2/AuthDate;Ltv/danmaku/bili/auth/v2/Content;Ltv/danmaku/bili/auth/v2/Content;Ljava/util/List;Z)V", "getType", "()Ltv/danmaku/bili/api/bean/CardTypeBean;", "getGender", "()Ltv/danmaku/bili/api/bean/Gender;", "getBirth", "()Ltv/danmaku/bili/auth/v2/AuthDate;", "getName", "()Ltv/danmaku/bili/auth/v2/Content;", "getCard", "getTypeList", "()Ljava/util/List;", "getAgreementChecked", "()Z", "updateContent", "content", "getContent", "field", "Ltv/danmaku/bili/auth/v2/ContentField;", "localValidChecked", "getLocalValidChecked", "remoteValidChecked", "getRemoteValidChecked", "remoteValid", "getRemoteValid", "nameValid", "getNameValid", "cardValid", "getCardValid", "genderValid", "getGenderValid", "birthValid", "getBirthValid", "birthdayString", "", "getBirthdayString", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AuthState {
    private final boolean agreementChecked;
    private final AuthDate birth;
    private final Content card;
    private final Gender gender;
    private final Content name;
    private final CardTypeBean type;
    private final List<CardTypeBean> typeList;

    /* compiled from: AuthV2ViewModel.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ContentField.values().length];
            try {
                iArr[ContentField.Name.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ContentField.Card.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AuthState() {
        this(null, null, null, null, null, null, false, BR.countdownTrackEnabled, null);
    }

    public static /* synthetic */ AuthState copy$default(AuthState authState, CardTypeBean cardTypeBean, Gender gender, AuthDate authDate, Content content, Content content2, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            cardTypeBean = authState.type;
        }
        if ((i & 2) != 0) {
            gender = authState.gender;
        }
        Gender gender2 = gender;
        if ((i & 4) != 0) {
            authDate = authState.birth;
        }
        AuthDate authDate2 = authDate;
        if ((i & 8) != 0) {
            content = authState.name;
        }
        Content content3 = content;
        if ((i & 16) != 0) {
            content2 = authState.card;
        }
        Content content4 = content2;
        List<CardTypeBean> list2 = list;
        if ((i & 32) != 0) {
            list2 = authState.typeList;
        }
        List list3 = list2;
        if ((i & 64) != 0) {
            z = authState.agreementChecked;
        }
        return authState.copy(cardTypeBean, gender2, authDate2, content3, content4, list3, z);
    }

    public final CardTypeBean component1() {
        return this.type;
    }

    public final Gender component2() {
        return this.gender;
    }

    public final AuthDate component3() {
        return this.birth;
    }

    public final Content component4() {
        return this.name;
    }

    public final Content component5() {
        return this.card;
    }

    public final List<CardTypeBean> component6() {
        return this.typeList;
    }

    public final boolean component7() {
        return this.agreementChecked;
    }

    public final AuthState copy(CardTypeBean cardTypeBean, Gender gender, AuthDate authDate, Content content, Content content2, List<CardTypeBean> list, boolean z) {
        Intrinsics.checkNotNullParameter(cardTypeBean, "type");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(content, ChannelRoutes.CHANNEL_NAME);
        Intrinsics.checkNotNullParameter(content2, "card");
        Intrinsics.checkNotNullParameter(list, "typeList");
        return new AuthState(cardTypeBean, gender, authDate, content, content2, list, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AuthState) {
            AuthState authState = (AuthState) obj;
            return Intrinsics.areEqual(this.type, authState.type) && this.gender == authState.gender && Intrinsics.areEqual(this.birth, authState.birth) && Intrinsics.areEqual(this.name, authState.name) && Intrinsics.areEqual(this.card, authState.card) && Intrinsics.areEqual(this.typeList, authState.typeList) && this.agreementChecked == authState.agreementChecked;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.type.hashCode() * 31) + this.gender.hashCode()) * 31) + (this.birth == null ? 0 : this.birth.hashCode())) * 31) + this.name.hashCode()) * 31) + this.card.hashCode()) * 31) + this.typeList.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.agreementChecked);
    }

    public String toString() {
        CardTypeBean cardTypeBean = this.type;
        Gender gender = this.gender;
        AuthDate authDate = this.birth;
        Content content = this.name;
        Content content2 = this.card;
        List<CardTypeBean> list = this.typeList;
        return "AuthState(type=" + cardTypeBean + ", gender=" + gender + ", birth=" + authDate + ", name=" + content + ", card=" + content2 + ", typeList=" + list + ", agreementChecked=" + this.agreementChecked + ")";
    }

    public AuthState(CardTypeBean type, Gender gender, AuthDate birth, Content name, Content card, List<CardTypeBean> list, boolean agreementChecked) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(name, ChannelRoutes.CHANNEL_NAME);
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(list, "typeList");
        this.type = type;
        this.gender = gender;
        this.birth = birth;
        this.name = name;
        this.card = card;
        this.typeList = list;
        this.agreementChecked = agreementChecked;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ AuthState(CardTypeBean cardTypeBean, Gender gender, AuthDate authDate, Content content, Content content2, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r0, (i & 2) != 0 ? Gender.UNKNOWN : gender, (i & 4) != 0 ? null : authDate, (i & 8) != 0 ? new Content(ContentField.Name, null, null, 6, null) : content, (i & 16) != 0 ? new Content(ContentField.Card, null, null, 6, null) : content2, (i & 32) != 0 ? CollectionsKt.listOf(r0) : list, (i & 64) != 0 ? false : z);
        CardTypeBean cardTypeBean2 = (i & 1) != 0 ? new CardTypeBean(0, null, false, false, false, 31, null) : cardTypeBean;
    }

    public final CardTypeBean getType() {
        return this.type;
    }

    public final Gender getGender() {
        return this.gender;
    }

    public final AuthDate getBirth() {
        return this.birth;
    }

    public final Content getName() {
        return this.name;
    }

    public final Content getCard() {
        return this.card;
    }

    public final List<CardTypeBean> getTypeList() {
        return this.typeList;
    }

    public final boolean getAgreementChecked() {
        return this.agreementChecked;
    }

    public final AuthState updateContent(Content content) {
        Intrinsics.checkNotNullParameter(content, "content");
        switch (WhenMappings.$EnumSwitchMapping$0[content.getField().ordinal()]) {
            case 1:
                return copy$default(this, null, null, null, content, null, null, false, 119, null);
            case 2:
                return copy$default(this, null, null, null, null, content, null, false, BR.containerSelected, null);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final Content getContent(ContentField field) {
        Intrinsics.checkNotNullParameter(field, "field");
        switch (WhenMappings.$EnumSwitchMapping$0[field.ordinal()]) {
            case 1:
                return this.name;
            case 2:
                return this.card;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean getLocalValidChecked() {
        return getNameValid() && getCardValid() && getGenderValid() && getBirthValid() && this.agreementChecked;
    }

    public final boolean getRemoteValidChecked() {
        return this.name.getRemoteValidChecked() && this.card.getRemoteValidChecked();
    }

    public final boolean getRemoteValid() {
        return this.name.getRemoteValid() && this.card.getRemoteValid();
    }

    private final boolean getNameValid() {
        return !StringsKt.isBlank(this.name.getContent());
    }

    private final boolean getCardValid() {
        if (this.type.getId() != CertType.RESIDENT_ID.getCardType()) {
            return !StringsKt.isBlank(this.card.getContent());
        }
        Regex regexCard = new Regex("^\\d{15}$|^\\d{17}[0-9Xx]$");
        return regexCard.matches(this.card.getContent());
    }

    private final boolean getGenderValid() {
        return (this.type.getGenderRequired() && this.gender == Gender.UNKNOWN) ? false : true;
    }

    private final boolean getBirthValid() {
        return (this.type.getBirthdayRequired() && this.birth == null) ? false : true;
    }

    public final String getBirthdayString() {
        AuthDate authDate;
        String authDate2;
        return (!this.type.getBirthdayRequired() || (authDate = this.birth) == null || (authDate2 = authDate.toString()) == null) ? "" : authDate2;
    }
}