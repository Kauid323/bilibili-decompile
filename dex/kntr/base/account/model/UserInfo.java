package kntr.base.account.model;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserInfo.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u001c\u001a\u00020\u0005H\u0016J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003JE\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lkntr/base/account/model/UserInfo;", "", "mid", "", "name", "", "vip", "Lkntr/base/account/model/Vip;", "accessToken", "level", "", "answerStatus", "Lkntr/base/account/model/UserAnswerStatus;", "<init>", "(JLjava/lang/String;Lkntr/base/account/model/Vip;Ljava/lang/String;ILkntr/base/account/model/UserAnswerStatus;)V", "getMid", "()J", "getName", "()Ljava/lang/String;", "getVip", "()Lkntr/base/account/model/Vip;", "getAccessToken$annotations", "()V", "getAccessToken", "getLevel", "()I", "getAnswerStatus", "()Lkntr/base/account/model/UserAnswerStatus;", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UserInfo {
    private final String accessToken;
    private final UserAnswerStatus answerStatus;
    private final int level;
    private final long mid;
    private final String name;
    private final Vip vip;

    @PrivateUserInfoData
    public static /* synthetic */ void getAccessToken$annotations() {
    }

    public final long component1() {
        return this.mid;
    }

    public final String component2() {
        return this.name;
    }

    public final Vip component3() {
        return this.vip;
    }

    public final String component4() {
        return this.accessToken;
    }

    public final int component5() {
        return this.level;
    }

    public final UserAnswerStatus component6() {
        return this.answerStatus;
    }

    public final UserInfo copy(long j, String str, Vip vip, String str2, int i, UserAnswerStatus userAnswerStatus) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(vip, "vip");
        Intrinsics.checkNotNullParameter(str2, "accessToken");
        Intrinsics.checkNotNullParameter(userAnswerStatus, "answerStatus");
        return new UserInfo(j, str, vip, str2, i, userAnswerStatus);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserInfo) {
            UserInfo userInfo = (UserInfo) obj;
            return this.mid == userInfo.mid && Intrinsics.areEqual(this.name, userInfo.name) && Intrinsics.areEqual(this.vip, userInfo.vip) && Intrinsics.areEqual(this.accessToken, userInfo.accessToken) && this.level == userInfo.level && this.answerStatus == userInfo.answerStatus;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.mid) * 31) + this.name.hashCode()) * 31) + this.vip.hashCode()) * 31) + this.accessToken.hashCode()) * 31) + this.level) * 31) + this.answerStatus.hashCode();
    }

    public UserInfo(long mid, String name, Vip vip, String accessToken, int level, UserAnswerStatus answerStatus) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(vip, "vip");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(answerStatus, "answerStatus");
        this.mid = mid;
        this.name = name;
        this.vip = vip;
        this.accessToken = accessToken;
        this.level = level;
        this.answerStatus = answerStatus;
    }

    public final long getMid() {
        return this.mid;
    }

    public final String getName() {
        return this.name;
    }

    public final Vip getVip() {
        return this.vip;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final int getLevel() {
        return this.level;
    }

    public final UserAnswerStatus getAnswerStatus() {
        return this.answerStatus;
    }

    public String toString() {
        return "UserInfo(mid=" + this.mid + ")";
    }
}