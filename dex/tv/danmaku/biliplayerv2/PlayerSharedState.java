package tv.danmaku.biliplayerv2;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerSharingBundle.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0005J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0018"}, d2 = {"Ltv/danmaku/biliplayerv2/PlayerSharedState;", "Landroid/os/Parcelable;", "speedRate", "", "playerState", "", "lockSpeed", "", "videoId", "<init>", "(FIZI)V", "getSpeedRate", "()F", "getPlayerState", "()I", "getLockSpeed", "()Z", "getVideoId", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerSharedState implements Parcelable {
    public static final Parcelable.Creator<PlayerSharedState> CREATOR = new Creator();
    private final boolean lockSpeed;
    private final int playerState;
    private final float speedRate;
    private final int videoId;

    /* compiled from: PlayerSharingBundle.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Creator implements Parcelable.Creator<PlayerSharedState> {
        @Override // android.os.Parcelable.Creator
        public final PlayerSharedState createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PlayerSharedState(parcel.readFloat(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final PlayerSharedState[] newArray(int i) {
            return new PlayerSharedState[i];
        }
    }

    public PlayerSharedState(float speedRate, int playerState, boolean lockSpeed, int videoId) {
        this.speedRate = speedRate;
        this.playerState = playerState;
        this.lockSpeed = lockSpeed;
        this.videoId = videoId;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final float getSpeedRate() {
        return this.speedRate;
    }

    public final int getPlayerState() {
        return this.playerState;
    }

    public final boolean getLockSpeed() {
        return this.lockSpeed;
    }

    public final int getVideoId() {
        return this.videoId;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeFloat(this.speedRate);
        dest.writeInt(this.playerState);
        dest.writeInt(this.lockSpeed ? 1 : 0);
        dest.writeInt(this.videoId);
    }
}