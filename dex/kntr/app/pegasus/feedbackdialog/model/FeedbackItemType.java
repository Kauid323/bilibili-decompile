package kntr.app.pegasus.feedbackdialog.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: FeedbackModel.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lkntr/app/pegasus/feedbackdialog/model/FeedbackItemType;", "", "value", "", "hasLink", "", "loginCheck", "dismissRevert", "<init>", "(Ljava/lang/String;ILjava/lang/String;ZZZ)V", "getValue", "()Ljava/lang/String;", "getHasLink", "()Z", "getLoginCheck", "getDismissRevert", "WATCH_LATER", "FEEDBACK", "DISLIKE", "LINK", "LINK_LOGIN", "TRANSLATE", "DEFAULT", "feedbackdialog_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public enum FeedbackItemType {
    WATCH_LATER("watch_later", false, false, false, 14, null),
    FEEDBACK("feedback", false, false, true, 6, null),
    DISLIKE("dislike", false, false, true, 6, null),
    LINK("link", true, false, false, 12, null),
    LINK_LOGIN("link_login", false, true, false, 10, null),
    TRANSLATE("translate", false, false, false, 14, null),
    DEFAULT("default", false, false, false, 14, null);
    
    private final boolean dismissRevert;
    private final boolean hasLink;
    private final boolean loginCheck;
    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<FeedbackItemType> getEntries() {
        return $ENTRIES;
    }

    FeedbackItemType(String value, boolean hasLink, boolean loginCheck, boolean dismissRevert) {
        this.value = value;
        this.hasLink = hasLink;
        this.loginCheck = loginCheck;
        this.dismissRevert = dismissRevert;
    }

    /* synthetic */ FeedbackItemType(String str, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3);
    }

    public final String getValue() {
        return this.value;
    }

    public final boolean getHasLink() {
        return this.hasLink;
    }

    public final boolean getLoginCheck() {
        return this.loginCheck;
    }

    public final boolean getDismissRevert() {
        return this.dismissRevert;
    }
}