package tv.danmaku.bili.ui.offline.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;

public class PlayListInfos implements Parcelable, Cloneable {
    public static final Parcelable.Creator<PlayListInfos> CREATOR = new Parcelable.Creator<PlayListInfos>() { // from class: tv.danmaku.bili.ui.offline.api.PlayListInfos.1
        @Override // android.os.Parcelable.Creator
        public PlayListInfos createFromParcel(Parcel in) {
            return new PlayListInfos(in);
        }

        @Override // android.os.Parcelable.Creator
        public PlayListInfos[] newArray(int size) {
            return new PlayListInfos[size];
        }
    };
    @JSONField(name = "has_more")
    public boolean hasMore;
    @JSONField(name = "total_count")
    public int totalCount;

    public PlayListInfos() {
    }

    protected PlayListInfos(Parcel in) {
        this.hasMore = in.readByte() != 0;
        this.totalCount = in.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.hasMore ? (byte) 1 : (byte) 0);
        dest.writeInt(this.totalCount);
    }
}