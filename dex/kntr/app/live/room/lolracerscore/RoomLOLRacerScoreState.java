package kntr.app.live.room.lolracerscore;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RoomLOLRacerScoreVM.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreState;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Idle", "DidPostRacerScore", "DidUpdatePlayers", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreState$DidPostRacerScore;", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreState$DidUpdatePlayers;", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreState$Idle;", "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class RoomLOLRacerScoreState {
    public /* synthetic */ RoomLOLRacerScoreState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: RoomLOLRacerScoreVM.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreState$Idle;", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreState;", "<init>", "()V", "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Idle extends RoomLOLRacerScoreState {
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super(null);
        }
    }

    private RoomLOLRacerScoreState() {
    }

    /* compiled from: RoomLOLRacerScoreVM.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0001'B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003JO\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\nHÆ\u0001J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\nHÖ\u0001J\t\u0010&\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017¨\u0006("}, d2 = {"Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreState$DidPostRacerScore;", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreState;", "success", RoomRecommendViewModel.EMPTY_CURSOR, AdAlarmExtraKey.CID, RoomRecommendViewModel.EMPTY_CURSOR, "racerID", "racerName", RoomRecommendViewModel.EMPTY_CURSOR, "score", RoomRecommendViewModel.EMPTY_CURSOR, "bo", "from", "<init>", "(ZJJLjava/lang/String;IJI)V", "getSuccess", "()Z", "getCid", "()J", "getRacerID", "getRacerName", "()Ljava/lang/String;", "getScore", "()I", "getBo", "getFrom", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "Companion", "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DidPostRacerScore extends RoomLOLRacerScoreState {
        public static final Companion Companion = new Companion(null);
        public static final int SCORE_FROM_H5 = 1;
        public static final int SCORE_FROM_NATIVE = 2;
        private final long bo;
        private final long cid;
        private final int from;
        private final long racerID;
        private final String racerName;
        private final int score;
        private final boolean success;

        public final boolean component1() {
            return this.success;
        }

        public final long component2() {
            return this.cid;
        }

        public final long component3() {
            return this.racerID;
        }

        public final String component4() {
            return this.racerName;
        }

        public final int component5() {
            return this.score;
        }

        public final long component6() {
            return this.bo;
        }

        public final int component7() {
            return this.from;
        }

        public final DidPostRacerScore copy(boolean z, long j2, long j3, String str, int i, long j4, int i2) {
            Intrinsics.checkNotNullParameter(str, "racerName");
            return new DidPostRacerScore(z, j2, j3, str, i, j4, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DidPostRacerScore) {
                DidPostRacerScore didPostRacerScore = (DidPostRacerScore) obj;
                return this.success == didPostRacerScore.success && this.cid == didPostRacerScore.cid && this.racerID == didPostRacerScore.racerID && Intrinsics.areEqual(this.racerName, didPostRacerScore.racerName) && this.score == didPostRacerScore.score && this.bo == didPostRacerScore.bo && this.from == didPostRacerScore.from;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.success) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cid)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.racerID)) * 31) + this.racerName.hashCode()) * 31) + this.score) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.bo)) * 31) + this.from;
        }

        public String toString() {
            boolean z = this.success;
            long j2 = this.cid;
            long j3 = this.racerID;
            String str = this.racerName;
            int i = this.score;
            long j4 = this.bo;
            return "DidPostRacerScore(success=" + z + ", cid=" + j2 + ", racerID=" + j3 + ", racerName=" + str + ", score=" + i + ", bo=" + j4 + ", from=" + this.from + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DidPostRacerScore(boolean success, long cid, long racerID, String racerName, int score, long bo, int from) {
            super(null);
            Intrinsics.checkNotNullParameter(racerName, "racerName");
            this.success = success;
            this.cid = cid;
            this.racerID = racerID;
            this.racerName = racerName;
            this.score = score;
            this.bo = bo;
            this.from = from;
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final long getCid() {
            return this.cid;
        }

        public final long getRacerID() {
            return this.racerID;
        }

        public final String getRacerName() {
            return this.racerName;
        }

        public final int getScore() {
            return this.score;
        }

        public final long getBo() {
            return this.bo;
        }

        public final int getFrom() {
            return this.from;
        }

        /* compiled from: RoomLOLRacerScoreVM.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreState$DidPostRacerScore$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "SCORE_FROM_H5", RoomRecommendViewModel.EMPTY_CURSOR, "SCORE_FROM_NATIVE", "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: RoomLOLRacerScoreVM.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreState$DidUpdatePlayers;", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreState;", "reason", RoomRecommendViewModel.EMPTY_CURSOR, "dataModel", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/live/room/lolracerscore/LiveRacerScoreDataModel;", "<init>", "(ILjava/util/List;)V", "getReason", "()I", "getDataModel", "()Ljava/util/List;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "Companion", "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DidUpdatePlayers extends RoomLOLRacerScoreState {
        public static final Companion Companion = new Companion(null);
        public static final int DID_CLEAR_SELECTION = 6;
        public static final int DID_GET_LOL_PLAYERS = 1;
        public static final int DID_SCORE_TO_PLAYER = 5;
        public static final int DID_SELECT_PLAYER = 3;
        public static final int ERROR_GET_LOL_PLAYERS = 2;
        public static final int ERROR_SCORE_TO_PLAYER = 4;
        public static final int SCORE_FROM_H5_FAIL = 9;
        public static final int SCORE_FROM_H5_SUCCESS = 7;
        public static final int SCORE_FROM_NATIVE_FAIL = 10;
        public static final int SCORE_FROM_NATIVE_SUCCESS = 8;
        private final List<LiveRacerScoreDataModel> dataModel;
        private final int reason;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DidUpdatePlayers copy$default(DidUpdatePlayers didUpdatePlayers, int i, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = didUpdatePlayers.reason;
            }
            if ((i2 & 2) != 0) {
                list = didUpdatePlayers.dataModel;
            }
            return didUpdatePlayers.copy(i, list);
        }

        public final int component1() {
            return this.reason;
        }

        public final List<LiveRacerScoreDataModel> component2() {
            return this.dataModel;
        }

        public final DidUpdatePlayers copy(int i, List<LiveRacerScoreDataModel> list) {
            Intrinsics.checkNotNullParameter(list, "dataModel");
            return new DidUpdatePlayers(i, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DidUpdatePlayers) {
                DidUpdatePlayers didUpdatePlayers = (DidUpdatePlayers) obj;
                return this.reason == didUpdatePlayers.reason && Intrinsics.areEqual(this.dataModel, didUpdatePlayers.dataModel);
            }
            return false;
        }

        public int hashCode() {
            return (this.reason * 31) + this.dataModel.hashCode();
        }

        public String toString() {
            int i = this.reason;
            return "DidUpdatePlayers(reason=" + i + ", dataModel=" + this.dataModel + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DidUpdatePlayers(int reason, List<LiveRacerScoreDataModel> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "dataModel");
            this.reason = reason;
            this.dataModel = list;
        }

        public final int getReason() {
            return this.reason;
        }

        public final List<LiveRacerScoreDataModel> getDataModel() {
            return this.dataModel;
        }

        /* compiled from: RoomLOLRacerScoreVM.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreState$DidUpdatePlayers$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "DID_GET_LOL_PLAYERS", RoomRecommendViewModel.EMPTY_CURSOR, "ERROR_GET_LOL_PLAYERS", "DID_SELECT_PLAYER", "ERROR_SCORE_TO_PLAYER", "DID_SCORE_TO_PLAYER", "DID_CLEAR_SELECTION", "SCORE_FROM_H5_SUCCESS", "SCORE_FROM_NATIVE_SUCCESS", "SCORE_FROM_H5_FAIL", "SCORE_FROM_NATIVE_FAIL", "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}