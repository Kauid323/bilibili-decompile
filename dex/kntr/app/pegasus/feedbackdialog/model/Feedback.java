package kntr.app.pegasus.feedbackdialog.model;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeedbackModel.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lkntr/app/pegasus/feedbackdialog/model/Feedback;", "", "style", "Lkntr/app/pegasus/feedbackdialog/model/FeedbackStyle;", "title", "", "items", "", "Lkntr/app/pegasus/feedbackdialog/model/FeedbackItem;", "<init>", "(Lkntr/app/pegasus/feedbackdialog/model/FeedbackStyle;Ljava/lang/String;Ljava/util/List;)V", "getStyle", "()Lkntr/app/pegasus/feedbackdialog/model/FeedbackStyle;", "getTitle", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "feedbackdialog_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Feedback {
    public static final int $stable = 8;
    private final List<FeedbackItem> items;
    private final FeedbackStyle style;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Feedback copy$default(Feedback feedback, FeedbackStyle feedbackStyle, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            feedbackStyle = feedback.style;
        }
        if ((i & 2) != 0) {
            str = feedback.title;
        }
        if ((i & 4) != 0) {
            list = feedback.items;
        }
        return feedback.copy(feedbackStyle, str, list);
    }

    public final FeedbackStyle component1() {
        return this.style;
    }

    public final String component2() {
        return this.title;
    }

    public final List<FeedbackItem> component3() {
        return this.items;
    }

    public final Feedback copy(FeedbackStyle feedbackStyle, String str, List<FeedbackItem> list) {
        Intrinsics.checkNotNullParameter(feedbackStyle, "style");
        return new Feedback(feedbackStyle, str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Feedback) {
            Feedback feedback = (Feedback) obj;
            return this.style == feedback.style && Intrinsics.areEqual(this.title, feedback.title) && Intrinsics.areEqual(this.items, feedback.items);
        }
        return false;
    }

    public int hashCode() {
        return (((this.style.hashCode() * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.items != null ? this.items.hashCode() : 0);
    }

    public String toString() {
        FeedbackStyle feedbackStyle = this.style;
        String str = this.title;
        return "Feedback(style=" + feedbackStyle + ", title=" + str + ", items=" + this.items + ")";
    }

    public Feedback(FeedbackStyle style, String title, List<FeedbackItem> list) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.style = style;
        this.title = title;
        this.items = list;
    }

    public /* synthetic */ Feedback(FeedbackStyle feedbackStyle, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(feedbackStyle, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : list);
    }

    public final FeedbackStyle getStyle() {
        return this.style;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<FeedbackItem> getItems() {
        return this.items;
    }
}