package tv.danmaku.bili.ui.offline.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.videodownloader.model.VideoDownloadEntry;

public class OgvInfo implements Parcelable {
    public static final Parcelable.Creator<OgvInfo> CREATOR = new Parcelable.Creator<OgvInfo>() { // from class: tv.danmaku.bili.ui.offline.api.OgvInfo.1
        @Override // android.os.Parcelable.Creator
        public OgvInfo createFromParcel(Parcel in) {
            return new OgvInfo(in);
        }

        @Override // android.os.Parcelable.Creator
        public OgvInfo[] newArray(int size) {
            return new OgvInfo[size];
        }
    };
    @JSONField(name = "aid")
    public long aid;
    @JSONField(name = "cid")
    public long cid;
    @JSONField(name = "dimension")
    public Dimension dimension;
    public long duration;
    @JSONField(name = "epid")
    public long epid;
    public int index;
    public boolean isVipOnly;
    public String link;
    public int quality;
    public int realIndex;
    @JSONField(name = "season_id")
    public long seasonid;
    public String title;
    public String typeName;
    public VideoDownloadEntry videoDownloadEntry;

    public OgvInfo() {
    }

    protected OgvInfo(Parcel in) {
        this.aid = in.readLong();
        this.cid = in.readLong();
        this.seasonid = in.readLong();
        this.epid = in.readLong();
        this.videoDownloadEntry = in.readParcelable(VideoDownloadEntry.class.getClassLoader());
        this.quality = in.readInt();
        this.typeName = in.readString();
        this.duration = in.readLong();
        this.index = in.readInt();
        this.title = in.readString();
        this.isVipOnly = in.readInt() == 1;
        this.realIndex = in.readInt();
        this.link = in.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.aid);
        dest.writeLong(this.cid);
        dest.writeLong(this.seasonid);
        dest.writeLong(this.epid);
        dest.writeParcelable(this.videoDownloadEntry, flags);
        dest.writeInt(this.quality);
        dest.writeString(this.typeName);
        dest.writeLong(this.duration);
        dest.writeInt(this.index);
        dest.writeString(this.title);
        dest.writeInt(this.isVipOnly ? 1 : 0);
        dest.writeInt(this.realIndex);
        dest.writeString(this.link);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OgvInfo that = (OgvInfo) o;
        if (this.cid == that.cid) {
            return true;
        }
        return false;
    }
}