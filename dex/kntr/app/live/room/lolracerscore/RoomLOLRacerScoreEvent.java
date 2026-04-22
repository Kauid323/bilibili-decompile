package kntr.app.live.room.lolracerscore;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RoomLOLRacerScoreVM.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreEvent;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "PostRacerScore", "GetLOLPlayers", "DidSelectPlayer", "ScoreToPlayer", "ClearSelection", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreEvent$ClearSelection;", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreEvent$DidSelectPlayer;", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreEvent$GetLOLPlayers;", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreEvent$PostRacerScore;", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreEvent$ScoreToPlayer;", "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class RoomLOLRacerScoreEvent {
    public /* synthetic */ RoomLOLRacerScoreEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RoomLOLRacerScoreEvent() {
    }

    /* compiled from: RoomLOLRacerScoreVM.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\tHÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006#"}, d2 = {"Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreEvent$PostRacerScore;", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreEvent;", AdAlarmExtraKey.CID, RoomRecommendViewModel.EMPTY_CURSOR, "racerID", "racerName", RoomRecommendViewModel.EMPTY_CURSOR, "uid", "score", RoomRecommendViewModel.EMPTY_CURSOR, "bo", "<init>", "(JJLjava/lang/String;JIJ)V", "getCid", "()J", "getRacerID", "getRacerName", "()Ljava/lang/String;", "getUid", "getScore", "()I", "getBo", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class PostRacerScore extends RoomLOLRacerScoreEvent {
        private final long bo;
        private final long cid;
        private final long racerID;
        private final String racerName;
        private final int score;
        private final long uid;

        public final long component1() {
            return this.cid;
        }

        public final long component2() {
            return this.racerID;
        }

        public final String component3() {
            return this.racerName;
        }

        public final long component4() {
            return this.uid;
        }

        public final int component5() {
            return this.score;
        }

        public final long component6() {
            return this.bo;
        }

        public final PostRacerScore copy(long j2, long j3, String str, long j4, int i, long j5) {
            Intrinsics.checkNotNullParameter(str, "racerName");
            return new PostRacerScore(j2, j3, str, j4, i, j5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PostRacerScore) {
                PostRacerScore postRacerScore = (PostRacerScore) obj;
                return this.cid == postRacerScore.cid && this.racerID == postRacerScore.racerID && Intrinsics.areEqual(this.racerName, postRacerScore.racerName) && this.uid == postRacerScore.uid && this.score == postRacerScore.score && this.bo == postRacerScore.bo;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cid) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.racerID)) * 31) + this.racerName.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.uid)) * 31) + this.score) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.bo);
        }

        public String toString() {
            long j2 = this.cid;
            long j3 = this.racerID;
            String str = this.racerName;
            long j4 = this.uid;
            int i = this.score;
            return "PostRacerScore(cid=" + j2 + ", racerID=" + j3 + ", racerName=" + str + ", uid=" + j4 + ", score=" + i + ", bo=" + this.bo + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostRacerScore(long cid, long racerID, String racerName, long uid, int score, long bo) {
            super(null);
            Intrinsics.checkNotNullParameter(racerName, "racerName");
            this.cid = cid;
            this.racerID = racerID;
            this.racerName = racerName;
            this.uid = uid;
            this.score = score;
            this.bo = bo;
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

        public final long getUid() {
            return this.uid;
        }

        public final int getScore() {
            return this.score;
        }

        public final long getBo() {
            return this.bo;
        }
    }

    /* compiled from: RoomLOLRacerScoreVM.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreEvent$GetLOLPlayers;", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreEvent;", "defaultSelectedId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(J)V", "getDefaultSelectedId", "()J", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class GetLOLPlayers extends RoomLOLRacerScoreEvent {
        private final long defaultSelectedId;

        public static /* synthetic */ GetLOLPlayers copy$default(GetLOLPlayers getLOLPlayers, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j2 = getLOLPlayers.defaultSelectedId;
            }
            return getLOLPlayers.copy(j2);
        }

        public final long component1() {
            return this.defaultSelectedId;
        }

        public final GetLOLPlayers copy(long j2) {
            return new GetLOLPlayers(j2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetLOLPlayers) && this.defaultSelectedId == ((GetLOLPlayers) obj).defaultSelectedId;
        }

        public int hashCode() {
            return ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.defaultSelectedId);
        }

        public String toString() {
            return "GetLOLPlayers(defaultSelectedId=" + this.defaultSelectedId + ")";
        }

        public GetLOLPlayers(long defaultSelectedId) {
            super(null);
            this.defaultSelectedId = defaultSelectedId;
        }

        public final long getDefaultSelectedId() {
            return this.defaultSelectedId;
        }
    }

    /* compiled from: RoomLOLRacerScoreVM.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreEvent$DidSelectPlayer;", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreEvent;", "racerID", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(J)V", "getRacerID", "()J", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DidSelectPlayer extends RoomLOLRacerScoreEvent {
        private final long racerID;

        public static /* synthetic */ DidSelectPlayer copy$default(DidSelectPlayer didSelectPlayer, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j2 = didSelectPlayer.racerID;
            }
            return didSelectPlayer.copy(j2);
        }

        public final long component1() {
            return this.racerID;
        }

        public final DidSelectPlayer copy(long j2) {
            return new DidSelectPlayer(j2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DidSelectPlayer) && this.racerID == ((DidSelectPlayer) obj).racerID;
        }

        public int hashCode() {
            return ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.racerID);
        }

        public String toString() {
            return "DidSelectPlayer(racerID=" + this.racerID + ")";
        }

        public DidSelectPlayer(long racerID) {
            super(null);
            this.racerID = racerID;
        }

        public final long getRacerID() {
            return this.racerID;
        }
    }

    /* compiled from: RoomLOLRacerScoreVM.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreEvent$ScoreToPlayer;", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreEvent;", "racerID", RoomRecommendViewModel.EMPTY_CURSOR, "score", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(JI)V", "getRacerID", "()J", "getScore", "()I", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ScoreToPlayer extends RoomLOLRacerScoreEvent {
        private final long racerID;
        private final int score;

        public static /* synthetic */ ScoreToPlayer copy$default(ScoreToPlayer scoreToPlayer, long j2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j2 = scoreToPlayer.racerID;
            }
            if ((i2 & 2) != 0) {
                i = scoreToPlayer.score;
            }
            return scoreToPlayer.copy(j2, i);
        }

        public final long component1() {
            return this.racerID;
        }

        public final int component2() {
            return this.score;
        }

        public final ScoreToPlayer copy(long j2, int i) {
            return new ScoreToPlayer(j2, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ScoreToPlayer) {
                ScoreToPlayer scoreToPlayer = (ScoreToPlayer) obj;
                return this.racerID == scoreToPlayer.racerID && this.score == scoreToPlayer.score;
            }
            return false;
        }

        public int hashCode() {
            return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.racerID) * 31) + this.score;
        }

        public String toString() {
            long j2 = this.racerID;
            return "ScoreToPlayer(racerID=" + j2 + ", score=" + this.score + ")";
        }

        public ScoreToPlayer(long racerID, int score) {
            super(null);
            this.racerID = racerID;
            this.score = score;
        }

        public final long getRacerID() {
            return this.racerID;
        }

        public final int getScore() {
            return this.score;
        }
    }

    /* compiled from: RoomLOLRacerScoreVM.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreEvent$ClearSelection;", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreEvent;", "<init>", "()V", "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ClearSelection extends RoomLOLRacerScoreEvent {
        public static final ClearSelection INSTANCE = new ClearSelection();

        private ClearSelection() {
            super(null);
        }
    }
}