package kntr.app.tribee.repost.page.introBottomSheet;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IntroBottomSheetState.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lkntr/app/tribee/repost/page/introBottomSheet/IntroBottomSheetState;", "", "avatarUrl", "", "upName", "avatarRightText", "avatarBottomText", "intro", "desc", "buttonText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "getUpName", "getAvatarRightText", "getAvatarBottomText", "getIntro", "getDesc", "getButtonText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class IntroBottomSheetState {
    public static final int $stable = 0;
    private final String avatarBottomText;
    private final String avatarRightText;
    private final String avatarUrl;
    private final String buttonText;
    private final String desc;
    private final String intro;
    private final String upName;

    public static /* synthetic */ IntroBottomSheetState copy$default(IntroBottomSheetState introBottomSheetState, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = introBottomSheetState.avatarUrl;
        }
        if ((i & 2) != 0) {
            str2 = introBottomSheetState.upName;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = introBottomSheetState.avatarRightText;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = introBottomSheetState.avatarBottomText;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = introBottomSheetState.intro;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = introBottomSheetState.desc;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = introBottomSheetState.buttonText;
        }
        return introBottomSheetState.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.avatarUrl;
    }

    public final String component2() {
        return this.upName;
    }

    public final String component3() {
        return this.avatarRightText;
    }

    public final String component4() {
        return this.avatarBottomText;
    }

    public final String component5() {
        return this.intro;
    }

    public final String component6() {
        return this.desc;
    }

    public final String component7() {
        return this.buttonText;
    }

    public final IntroBottomSheetState copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "avatarUrl");
        Intrinsics.checkNotNullParameter(str2, "upName");
        Intrinsics.checkNotNullParameter(str3, "avatarRightText");
        Intrinsics.checkNotNullParameter(str4, "avatarBottomText");
        Intrinsics.checkNotNullParameter(str5, "intro");
        Intrinsics.checkNotNullParameter(str6, "desc");
        Intrinsics.checkNotNullParameter(str7, "buttonText");
        return new IntroBottomSheetState(str, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IntroBottomSheetState) {
            IntroBottomSheetState introBottomSheetState = (IntroBottomSheetState) obj;
            return Intrinsics.areEqual(this.avatarUrl, introBottomSheetState.avatarUrl) && Intrinsics.areEqual(this.upName, introBottomSheetState.upName) && Intrinsics.areEqual(this.avatarRightText, introBottomSheetState.avatarRightText) && Intrinsics.areEqual(this.avatarBottomText, introBottomSheetState.avatarBottomText) && Intrinsics.areEqual(this.intro, introBottomSheetState.intro) && Intrinsics.areEqual(this.desc, introBottomSheetState.desc) && Intrinsics.areEqual(this.buttonText, introBottomSheetState.buttonText);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.avatarUrl.hashCode() * 31) + this.upName.hashCode()) * 31) + this.avatarRightText.hashCode()) * 31) + this.avatarBottomText.hashCode()) * 31) + this.intro.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.buttonText.hashCode();
    }

    public String toString() {
        String str = this.avatarUrl;
        String str2 = this.upName;
        String str3 = this.avatarRightText;
        String str4 = this.avatarBottomText;
        String str5 = this.intro;
        String str6 = this.desc;
        return "IntroBottomSheetState(avatarUrl=" + str + ", upName=" + str2 + ", avatarRightText=" + str3 + ", avatarBottomText=" + str4 + ", intro=" + str5 + ", desc=" + str6 + ", buttonText=" + this.buttonText + ")";
    }

    public IntroBottomSheetState(String avatarUrl, String upName, String avatarRightText, String avatarBottomText, String intro, String desc, String buttonText) {
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(upName, "upName");
        Intrinsics.checkNotNullParameter(avatarRightText, "avatarRightText");
        Intrinsics.checkNotNullParameter(avatarBottomText, "avatarBottomText");
        Intrinsics.checkNotNullParameter(intro, "intro");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        this.avatarUrl = avatarUrl;
        this.upName = upName;
        this.avatarRightText = avatarRightText;
        this.avatarBottomText = avatarBottomText;
        this.intro = intro;
        this.desc = desc;
        this.buttonText = buttonText;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getUpName() {
        return this.upName;
    }

    public final String getAvatarRightText() {
        return this.avatarRightText;
    }

    public final String getAvatarBottomText() {
        return this.avatarBottomText;
    }

    public final String getIntro() {
        return this.intro;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getButtonText() {
        return this.buttonText;
    }
}