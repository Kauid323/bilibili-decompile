package im.direct.notification.interactive;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;

/* compiled from: INState.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u001a"}, d2 = {"Lim/direct/notification/interactive/LikeCtrl;", "", "subjectID", "", "businessID", "sourceID", "isSelected", "", "<init>", "(JJJZ)V", "getSubjectID", "()J", "getBusinessID", "getSourceID", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LikeCtrl {
    private final long businessID;
    private final boolean isSelected;
    private final long sourceID;
    private final long subjectID;

    public final long component1() {
        return this.subjectID;
    }

    public final long component2() {
        return this.businessID;
    }

    public final long component3() {
        return this.sourceID;
    }

    public final boolean component4() {
        return this.isSelected;
    }

    public final LikeCtrl copy(long j, long j2, long j3, boolean z) {
        return new LikeCtrl(j, j2, j3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LikeCtrl) {
            LikeCtrl likeCtrl = (LikeCtrl) obj;
            return this.subjectID == likeCtrl.subjectID && this.businessID == likeCtrl.businessID && this.sourceID == likeCtrl.sourceID && this.isSelected == likeCtrl.isSelected;
        }
        return false;
    }

    public int hashCode() {
        return (((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.subjectID) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.businessID)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.sourceID)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isSelected);
    }

    public String toString() {
        long j = this.subjectID;
        long j2 = this.businessID;
        long j3 = this.sourceID;
        return "LikeCtrl(subjectID=" + j + ", businessID=" + j2 + ", sourceID=" + j3 + ", isSelected=" + this.isSelected + ")";
    }

    public LikeCtrl(long subjectID, long businessID, long sourceID, boolean isSelected) {
        this.subjectID = subjectID;
        this.businessID = businessID;
        this.sourceID = sourceID;
        this.isSelected = isSelected;
    }

    public final long getSubjectID() {
        return this.subjectID;
    }

    public final long getBusinessID() {
        return this.businessID;
    }

    public final long getSourceID() {
        return this.sourceID;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }
}