package kntr.app.im.chat.core.model;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: ChatPageData.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/model/ChatUpgradeAnswerDialogStatus;", RoomRecommendViewModel.EMPTY_CURSOR, "IDLE", "SHOW", "DISMISSED", "Lkntr/app/im/chat/core/model/ChatUpgradeAnswerDialogStatus$DISMISSED;", "Lkntr/app/im/chat/core/model/ChatUpgradeAnswerDialogStatus$IDLE;", "Lkntr/app/im/chat/core/model/ChatUpgradeAnswerDialogStatus$SHOW;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ChatUpgradeAnswerDialogStatus {

    /* compiled from: ChatPageData.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/core/model/ChatUpgradeAnswerDialogStatus$IDLE;", "Lkntr/app/im/chat/core/model/ChatUpgradeAnswerDialogStatus;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class IDLE implements ChatUpgradeAnswerDialogStatus {
        public static final int $stable = 0;
        public static final IDLE INSTANCE = new IDLE();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof IDLE) {
                IDLE idle = (IDLE) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -713259948;
        }

        public String toString() {
            return "IDLE";
        }

        private IDLE() {
        }
    }

    /* compiled from: ChatPageData.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/core/model/ChatUpgradeAnswerDialogStatus$SHOW;", "Lkntr/app/im/chat/core/model/ChatUpgradeAnswerDialogStatus;", "lastShowTime", "Lkotlinx/datetime/Instant;", "<init>", "(Lkotlinx/datetime/Instant;)V", "getLastShowTime", "()Lkotlinx/datetime/Instant;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SHOW implements ChatUpgradeAnswerDialogStatus {
        public static final int $stable = 8;
        private final Instant lastShowTime;

        public static /* synthetic */ SHOW copy$default(SHOW show, Instant instant, int i, Object obj) {
            if ((i & 1) != 0) {
                instant = show.lastShowTime;
            }
            return show.copy(instant);
        }

        public final Instant component1() {
            return this.lastShowTime;
        }

        public final SHOW copy(Instant instant) {
            Intrinsics.checkNotNullParameter(instant, "lastShowTime");
            return new SHOW(instant);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SHOW) && Intrinsics.areEqual(this.lastShowTime, ((SHOW) obj).lastShowTime);
        }

        public int hashCode() {
            return this.lastShowTime.hashCode();
        }

        public String toString() {
            return "SHOW(lastShowTime=" + this.lastShowTime + ")";
        }

        public SHOW(Instant lastShowTime) {
            Intrinsics.checkNotNullParameter(lastShowTime, "lastShowTime");
            this.lastShowTime = lastShowTime;
        }

        public final Instant getLastShowTime() {
            return this.lastShowTime;
        }
    }

    /* compiled from: ChatPageData.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/core/model/ChatUpgradeAnswerDialogStatus$DISMISSED;", "Lkntr/app/im/chat/core/model/ChatUpgradeAnswerDialogStatus;", "lastShowTime", "Lkotlinx/datetime/Instant;", "<init>", "(Lkotlinx/datetime/Instant;)V", "getLastShowTime", "()Lkotlinx/datetime/Instant;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DISMISSED implements ChatUpgradeAnswerDialogStatus {
        public static final int $stable = 8;
        private final Instant lastShowTime;

        public static /* synthetic */ DISMISSED copy$default(DISMISSED dismissed, Instant instant, int i, Object obj) {
            if ((i & 1) != 0) {
                instant = dismissed.lastShowTime;
            }
            return dismissed.copy(instant);
        }

        public final Instant component1() {
            return this.lastShowTime;
        }

        public final DISMISSED copy(Instant instant) {
            Intrinsics.checkNotNullParameter(instant, "lastShowTime");
            return new DISMISSED(instant);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DISMISSED) && Intrinsics.areEqual(this.lastShowTime, ((DISMISSED) obj).lastShowTime);
        }

        public int hashCode() {
            return this.lastShowTime.hashCode();
        }

        public String toString() {
            return "DISMISSED(lastShowTime=" + this.lastShowTime + ")";
        }

        public DISMISSED(Instant lastShowTime) {
            Intrinsics.checkNotNullParameter(lastShowTime, "lastShowTime");
            this.lastShowTime = lastShowTime;
        }

        public final Instant getLastShowTime() {
            return this.lastShowTime;
        }
    }
}