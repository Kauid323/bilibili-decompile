package kntr.app.pegasus.feedbackdialog.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: FeedbackModel.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u001a\u0012\u0010\b\u001a\u00020\u0001*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¨\u0006\t"}, d2 = {"hasType", "", "", "Lkntr/app/pegasus/feedbackdialog/model/Feedback;", "type", "Lkntr/app/pegasus/feedbackdialog/model/FeedbackItemType;", "hasDislike", "hasFeedback", "hasWatchLater", "feedbackdialog_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FeedbackModelKt {
    private static final boolean hasType(List<Feedback> list, FeedbackItemType type) {
        Iterable $this$any$iv;
        FeedbackItem item;
        if (list == null) {
            return false;
        }
        List<Feedback> $this$any$iv2 = list;
        if (($this$any$iv2 instanceof Collection) && $this$any$iv2.isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv2) {
            Feedback feedback = (Feedback) element$iv;
            Iterable items = feedback.getItems();
            if (items == null) {
                $this$any$iv = null;
                continue;
            } else {
                Iterable $this$any$iv3 = items;
                if (($this$any$iv3 instanceof Collection) && ((Collection) $this$any$iv3).isEmpty()) {
                    $this$any$iv = null;
                    continue;
                } else {
                    Iterator<T> it = $this$any$iv3.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            $this$any$iv = null;
                            continue;
                            break;
                        }
                        Object element$iv2 = it.next();
                        FeedbackItem item2 = (FeedbackItem) element$iv2;
                        if (item2.getType() == type) {
                            item = 1;
                            continue;
                        } else {
                            item = null;
                            continue;
                        }
                        if (item != null) {
                            $this$any$iv = 1;
                            continue;
                            break;
                        }
                    }
                }
            }
            if ($this$any$iv != null) {
                return true;
            }
        }
        return false;
    }

    public static final boolean hasDislike(List<Feedback> list) {
        return hasType(list, FeedbackItemType.DISLIKE);
    }

    public static final boolean hasFeedback(List<Feedback> list) {
        return hasType(list, FeedbackItemType.FEEDBACK);
    }

    public static final boolean hasWatchLater(List<Feedback> list) {
        return hasType(list, FeedbackItemType.WATCH_LATER);
    }
}