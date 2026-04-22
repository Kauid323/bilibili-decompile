package tv.danmaku.bili.auth.helper;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: EvokeFacialHelper.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0007B'\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\tB;\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\rB;\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0011B1\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R\u001a\u0010\u001e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001a\u0010'\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u0018R\u001e\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00101\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018R\u001c\u00104\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018¨\u00067"}, d2 = {"Ltv/danmaku/bili/auth/helper/RequestFacialData;", "", "<init>", "()V", ChannelRoutes.CHANNEL_NAME, "", "card", "(Ljava/lang/String;Ljava/lang/String;)V", "bizType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "scene", "Ltv/danmaku/bili/auth/helper/SceneType;", "sourceEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ltv/danmaku/bili/auth/helper/SceneType;Ljava/lang/String;)V", "tempCode", "isAfter14", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "mBizType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "mName", "getMName", "()Ljava/lang/String;", "setMName", "(Ljava/lang/String;)V", "mCard", "getMCard", "setMCard", "getMBizType", "setMBizType", "mSourceEvent", "getMSourceEvent", "setMSourceEvent", "()Z", "setAfter14", "(Z)V", "mTempCode", "getMTempCode", "setMTempCode", "mScene", "getMScene", "setMScene", "cardType", "", "getCardType", "()Ljava/lang/Integer;", "setCardType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "gender", "getGender", "setGender", "birthday", "getBirthday", "setBirthday", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RequestFacialData {
    private String birthday;
    private Integer cardType;
    private String gender;
    private boolean isAfter14;
    private String mBizType;
    private String mCard;
    private String mName;
    private String mScene;
    private String mSourceEvent;
    private String mTempCode;

    public RequestFacialData() {
        this.mName = "";
        this.mCard = "";
        this.mBizType = "realname";
        this.mSourceEvent = "";
        this.mTempCode = "";
        this.mScene = "";
    }

    public final String getMName() {
        return this.mName;
    }

    public final void setMName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mName = str;
    }

    public final String getMCard() {
        return this.mCard;
    }

    public final void setMCard(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mCard = str;
    }

    public final String getMBizType() {
        return this.mBizType;
    }

    public final void setMBizType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mBizType = str;
    }

    public final String getMSourceEvent() {
        return this.mSourceEvent;
    }

    public final void setMSourceEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mSourceEvent = str;
    }

    public final boolean isAfter14() {
        return this.isAfter14;
    }

    public final void setAfter14(boolean z) {
        this.isAfter14 = z;
    }

    public final String getMTempCode() {
        return this.mTempCode;
    }

    public final void setMTempCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mTempCode = str;
    }

    public final String getMScene() {
        return this.mScene;
    }

    public final void setMScene(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mScene = str;
    }

    public final Integer getCardType() {
        return this.cardType;
    }

    public final void setCardType(Integer num) {
        this.cardType = num;
    }

    public final String getGender() {
        return this.gender;
    }

    public final void setGender(String str) {
        this.gender = str;
    }

    public final String getBirthday() {
        return this.birthday;
    }

    public final void setBirthday(String str) {
        this.birthday = str;
    }

    public RequestFacialData(String name, String card) {
        this();
        this.mName = name == null ? "" : name;
        this.mCard = card != null ? card : "";
    }

    public RequestFacialData(String name, String card, String bizType) {
        this();
        this.mName = name == null ? "" : name;
        this.mCard = card != null ? card : "";
        this.mBizType = bizType == null ? "realname" : bizType;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ RequestFacialData(String str, String str2, String str3, SceneType sceneType, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, sceneType, r5);
        String str5;
        if ((i & 16) == 0) {
            str5 = str4;
        } else {
            str5 = "";
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RequestFacialData(String name, String card, String bizType, SceneType scene, String sourceEvent) {
        this();
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.mName = name == null ? "" : name;
        this.mCard = card == null ? "" : card;
        this.mBizType = bizType == null ? "realname" : bizType;
        this.mScene = scene.getValue();
        this.mSourceEvent = sourceEvent != null ? sourceEvent : "";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ RequestFacialData(String str, String str2, String str3, boolean z, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, z, r5);
        String str5;
        if ((i & 16) == 0) {
            str5 = str4;
        } else {
            str5 = "";
        }
    }

    public RequestFacialData(String name, String card, String tempCode, boolean isAfter14, String sourceEvent) {
        this();
        this.mName = name == null ? "" : name;
        this.mCard = card == null ? "" : card;
        this.mTempCode = tempCode == null ? "" : tempCode;
        this.isAfter14 = isAfter14;
        this.mSourceEvent = sourceEvent != null ? sourceEvent : "";
    }

    public RequestFacialData(String name, String card, String mBizType, String sourceEvent) {
        this();
        if (name == null) {
        }
        if (card == null) {
        }
        if (mBizType == null) {
        }
        if (sourceEvent == null) {
        }
    }
}