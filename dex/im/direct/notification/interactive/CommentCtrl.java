package im.direct.notification.interactive;

import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: INState.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016JX\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006'"}, d2 = {"Lim/direct/notification/interactive/CommentCtrl;", "", "subjectID", "", "rootID", "sourceID", "targetID", "businessID", "nickname", "", "replyUserMid", "<init>", "(JJJJJLjava/lang/String;Ljava/lang/Long;)V", "getSubjectID", "()J", "getRootID", "getSourceID", "getTargetID", "getBusinessID", "getNickname", "()Ljava/lang/String;", "getReplyUserMid", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(JJJJJLjava/lang/String;Ljava/lang/Long;)Lim/direct/notification/interactive/CommentCtrl;", "equals", "", "other", "hashCode", "", "toString", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommentCtrl {
    private final long businessID;
    private final String nickname;
    private final Long replyUserMid;
    private final long rootID;
    private final long sourceID;
    private final long subjectID;
    private final long targetID;

    public final long component1() {
        return this.subjectID;
    }

    public final long component2() {
        return this.rootID;
    }

    public final long component3() {
        return this.sourceID;
    }

    public final long component4() {
        return this.targetID;
    }

    public final long component5() {
        return this.businessID;
    }

    public final String component6() {
        return this.nickname;
    }

    public final Long component7() {
        return this.replyUserMid;
    }

    public final CommentCtrl copy(long j, long j2, long j3, long j4, long j5, String str, Long l) {
        return new CommentCtrl(j, j2, j3, j4, j5, str, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CommentCtrl) {
            CommentCtrl commentCtrl = (CommentCtrl) obj;
            return this.subjectID == commentCtrl.subjectID && this.rootID == commentCtrl.rootID && this.sourceID == commentCtrl.sourceID && this.targetID == commentCtrl.targetID && this.businessID == commentCtrl.businessID && Intrinsics.areEqual(this.nickname, commentCtrl.nickname) && Intrinsics.areEqual(this.replyUserMid, commentCtrl.replyUserMid);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.subjectID) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.rootID)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.sourceID)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.targetID)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.businessID)) * 31) + (this.nickname == null ? 0 : this.nickname.hashCode())) * 31) + (this.replyUserMid != null ? this.replyUserMid.hashCode() : 0);
    }

    public String toString() {
        long j = this.subjectID;
        long j2 = this.rootID;
        long j3 = this.sourceID;
        long j4 = this.targetID;
        long j5 = this.businessID;
        String str = this.nickname;
        return "CommentCtrl(subjectID=" + j + ", rootID=" + j2 + ", sourceID=" + j3 + ", targetID=" + j4 + ", businessID=" + j5 + ", nickname=" + str + ", replyUserMid=" + this.replyUserMid + ")";
    }

    public CommentCtrl(long subjectID, long rootID, long sourceID, long targetID, long businessID, String nickname, Long replyUserMid) {
        this.subjectID = subjectID;
        this.rootID = rootID;
        this.sourceID = sourceID;
        this.targetID = targetID;
        this.businessID = businessID;
        this.nickname = nickname;
        this.replyUserMid = replyUserMid;
    }

    public final long getSubjectID() {
        return this.subjectID;
    }

    public final long getRootID() {
        return this.rootID;
    }

    public final long getSourceID() {
        return this.sourceID;
    }

    public final long getTargetID() {
        return this.targetID;
    }

    public final long getBusinessID() {
        return this.businessID;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final Long getReplyUserMid() {
        return this.replyUserMid;
    }
}