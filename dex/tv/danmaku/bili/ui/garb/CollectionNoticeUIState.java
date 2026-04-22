package tv.danmaku.bili.ui.garb;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.api.Notice;

/* compiled from: CollectionNoticeUIState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/CollectionNoticeUIState;", "", "Loading", "Failure", "Ready", "Ltv/danmaku/bili/ui/garb/CollectionNoticeUIState$Failure;", "Ltv/danmaku/bili/ui/garb/CollectionNoticeUIState$Loading;", "Ltv/danmaku/bili/ui/garb/CollectionNoticeUIState$Ready;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface CollectionNoticeUIState {

    /* compiled from: CollectionNoticeUIState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/garb/CollectionNoticeUIState$Loading;", "Ltv/danmaku/bili/ui/garb/CollectionNoticeUIState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Loading implements CollectionNoticeUIState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Loading) {
                Loading loading = (Loading) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1177184460;
        }

        public String toString() {
            return "Loading";
        }

        private Loading() {
        }
    }

    /* compiled from: CollectionNoticeUIState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/garb/CollectionNoticeUIState$Failure;", "Ltv/danmaku/bili/ui/garb/CollectionNoticeUIState;", "isNetWorkError", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Failure implements CollectionNoticeUIState {
        public static final int $stable = 0;
        private final boolean isNetWorkError;

        public static /* synthetic */ Failure copy$default(Failure failure, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = failure.isNetWorkError;
            }
            return failure.copy(z);
        }

        public final boolean component1() {
            return this.isNetWorkError;
        }

        public final Failure copy(boolean z) {
            return new Failure(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failure) && this.isNetWorkError == ((Failure) obj).isNetWorkError;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isNetWorkError);
        }

        public String toString() {
            return "Failure(isNetWorkError=" + this.isNetWorkError + ")";
        }

        public Failure(boolean isNetWorkError) {
            this.isNetWorkError = isNetWorkError;
        }

        public final boolean isNetWorkError() {
            return this.isNetWorkError;
        }
    }

    /* compiled from: CollectionNoticeUIState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/ui/garb/CollectionNoticeUIState$Ready;", "Ltv/danmaku/bili/ui/garb/CollectionNoticeUIState;", "notice", "Ltv/danmaku/bili/ui/garb/api/Notice;", "isMe", "", "<init>", "(Ltv/danmaku/bili/ui/garb/api/Notice;Z)V", "getNotice", "()Ltv/danmaku/bili/ui/garb/api/Notice;", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Ready implements CollectionNoticeUIState {
        public static final int $stable = 0;
        private final boolean isMe;
        private final Notice notice;

        public static /* synthetic */ Ready copy$default(Ready ready, Notice notice, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                notice = ready.notice;
            }
            if ((i & 2) != 0) {
                z = ready.isMe;
            }
            return ready.copy(notice, z);
        }

        public final Notice component1() {
            return this.notice;
        }

        public final boolean component2() {
            return this.isMe;
        }

        public final Ready copy(Notice notice, boolean z) {
            Intrinsics.checkNotNullParameter(notice, "notice");
            return new Ready(notice, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Ready) {
                Ready ready = (Ready) obj;
                return Intrinsics.areEqual(this.notice, ready.notice) && this.isMe == ready.isMe;
            }
            return false;
        }

        public int hashCode() {
            return (this.notice.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isMe);
        }

        public String toString() {
            Notice notice = this.notice;
            return "Ready(notice=" + notice + ", isMe=" + this.isMe + ")";
        }

        public Ready(Notice notice, boolean isMe) {
            Intrinsics.checkNotNullParameter(notice, "notice");
            this.notice = notice;
            this.isMe = isMe;
        }

        public final Notice getNotice() {
            return this.notice;
        }

        public final boolean isMe() {
            return this.isMe;
        }
    }
}