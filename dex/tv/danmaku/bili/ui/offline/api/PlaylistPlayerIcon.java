package tv.danmaku.bili.ui.offline.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;

public class PlaylistPlayerIcon implements Parcelable {
    public static final Parcelable.Creator<PlaylistPlayerIcon> CREATOR = new Parcelable.Creator<PlaylistPlayerIcon>() { // from class: tv.danmaku.bili.ui.offline.api.PlaylistPlayerIcon.1
        @Override // android.os.Parcelable.Creator
        public PlaylistPlayerIcon createFromParcel(Parcel source) {
            return new PlaylistPlayerIcon(source);
        }

        @Override // android.os.Parcelable.Creator
        public PlaylistPlayerIcon[] newArray(int size) {
            return new PlaylistPlayerIcon[size];
        }
    };
    @JSONField(name = "ctime")
    public long ctime;
    public String dragLeftIcon;
    public String dragMetaJson;
    public String dragRightIcon;
    public String dragSpriteImg;
    public String finishMetaJson;
    public String finishSpriteImg;
    public String middleIcon;
    @JSONField(name = "url1")
    public String url1;
    @JSONField(name = "url2")
    public String url2;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url1);
        dest.writeString(this.url2);
        dest.writeLong(this.ctime);
        dest.writeString(this.dragSpriteImg);
        dest.writeString(this.dragMetaJson);
        dest.writeString(this.finishSpriteImg);
        dest.writeString(this.finishMetaJson);
        dest.writeString(this.dragLeftIcon);
        dest.writeString(this.middleIcon);
        dest.writeString(this.dragRightIcon);
    }

    public PlaylistPlayerIcon() {
    }

    protected PlaylistPlayerIcon(Parcel in) {
        this.url1 = in.readString();
        this.url2 = in.readString();
        this.ctime = in.readLong();
        this.dragSpriteImg = in.readString();
        this.dragMetaJson = in.readString();
        this.finishSpriteImg = in.readString();
        this.finishMetaJson = in.readString();
        this.dragLeftIcon = in.readString();
        this.middleIcon = in.readString();
        this.dragRightIcon = in.readString();
    }
}