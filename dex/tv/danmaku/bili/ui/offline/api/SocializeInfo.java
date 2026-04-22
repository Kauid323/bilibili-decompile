package tv.danmaku.bili.ui.offline.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;

public class SocializeInfo implements Parcelable {
    public static final Parcelable.Creator<SocializeInfo> CREATOR = new Parcelable.Creator<SocializeInfo>() { // from class: tv.danmaku.bili.ui.offline.api.SocializeInfo.1
        @Override // android.os.Parcelable.Creator
        public SocializeInfo createFromParcel(Parcel in) {
            return new SocializeInfo(in);
        }

        @Override // android.os.Parcelable.Creator
        public SocializeInfo[] newArray(int size) {
            return new SocializeInfo[size];
        }
    };
    public static final int ICON_TYPE_VT = 1;
    public static final int ICON_TYPE_VV = 0;
    public int coin;
    public int collect;
    public long danmaku;
    @JSONField(name = "play_switch")
    public int iconType;
    public long play;
    public int share;
    public int thumb_down;
    public int thumb_up;
    @JSONField(name = "view_text_1")
    public String viewContent;

    public SocializeInfo() {
    }

    protected SocializeInfo(Parcel in) {
        this.collect = in.readInt();
        this.danmaku = in.readLong();
        this.play = in.readLong();
        this.share = in.readInt();
        this.thumb_down = in.readInt();
        this.thumb_up = in.readInt();
        this.coin = in.readInt();
        this.iconType = in.readInt();
        this.viewContent = in.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.collect);
        dest.writeLong(this.danmaku);
        dest.writeLong(this.play);
        dest.writeInt(this.share);
        dest.writeInt(this.thumb_down);
        dest.writeInt(this.thumb_up);
        dest.writeInt(this.coin);
        dest.writeInt(this.iconType);
        dest.writeString(this.viewContent);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void upShare() {
        this.share++;
    }
}