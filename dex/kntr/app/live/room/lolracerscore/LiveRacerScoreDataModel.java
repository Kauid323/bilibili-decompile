package kntr.app.live.room.lolracerscore;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LiveRacerScoreDataModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003JO\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0013\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lkntr/app/live/room/lolracerscore/LiveRacerScoreDataModel;", RoomRecommendViewModel.EMPTY_CURSOR, AdAlarmExtraKey.CID, RoomRecommendViewModel.EMPTY_CURSOR, "racerID", "bo", "name", RoomRecommendViewModel.EMPTY_CURSOR, "photo", "userGrade", "isSelected", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getCid", "()J", "getRacerID", "getBo", "getName", "()Ljava/lang/String;", "getPhoto", "getUserGrade", "setUserGrade", "(Ljava/lang/String;)V", "()Z", "setSelected", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LiveRacerScoreDataModel {
    private final long bo;
    private final long cid;
    private boolean isSelected;
    private final String name;
    private final String photo;
    private final long racerID;
    private String userGrade;

    public final long component1() {
        return this.cid;
    }

    public final long component2() {
        return this.racerID;
    }

    public final long component3() {
        return this.bo;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.photo;
    }

    public final String component6() {
        return this.userGrade;
    }

    public final boolean component7() {
        return this.isSelected;
    }

    public final LiveRacerScoreDataModel copy(long j2, long j3, long j4, String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "photo");
        Intrinsics.checkNotNullParameter(str3, "userGrade");
        return new LiveRacerScoreDataModel(j2, j3, j4, str, str2, str3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveRacerScoreDataModel) {
            LiveRacerScoreDataModel liveRacerScoreDataModel = (LiveRacerScoreDataModel) obj;
            return this.cid == liveRacerScoreDataModel.cid && this.racerID == liveRacerScoreDataModel.racerID && this.bo == liveRacerScoreDataModel.bo && Intrinsics.areEqual(this.name, liveRacerScoreDataModel.name) && Intrinsics.areEqual(this.photo, liveRacerScoreDataModel.photo) && Intrinsics.areEqual(this.userGrade, liveRacerScoreDataModel.userGrade) && this.isSelected == liveRacerScoreDataModel.isSelected;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cid) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.racerID)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.bo)) * 31) + this.name.hashCode()) * 31) + this.photo.hashCode()) * 31) + this.userGrade.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isSelected);
    }

    public String toString() {
        long j2 = this.cid;
        long j3 = this.racerID;
        long j4 = this.bo;
        String str = this.name;
        String str2 = this.photo;
        String str3 = this.userGrade;
        return "LiveRacerScoreDataModel(cid=" + j2 + ", racerID=" + j3 + ", bo=" + j4 + ", name=" + str + ", photo=" + str2 + ", userGrade=" + str3 + ", isSelected=" + this.isSelected + ")";
    }

    public LiveRacerScoreDataModel(long cid, long racerID, long bo, String name, String photo, String userGrade, boolean isSelected) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(photo, "photo");
        Intrinsics.checkNotNullParameter(userGrade, "userGrade");
        this.cid = cid;
        this.racerID = racerID;
        this.bo = bo;
        this.name = name;
        this.photo = photo;
        this.userGrade = userGrade;
        this.isSelected = isSelected;
    }

    public final long getCid() {
        return this.cid;
    }

    public final long getRacerID() {
        return this.racerID;
    }

    public final long getBo() {
        return this.bo;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPhoto() {
        return this.photo;
    }

    public final String getUserGrade() {
        return this.userGrade;
    }

    public final void setUserGrade(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userGrade = str;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }
}