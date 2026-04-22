package tv.danmaku.bili.ui.offline.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import java.util.Collections;
import java.util.List;

public class Page implements Parcelable {
    public static final Parcelable.Creator<Page> CREATOR = new Parcelable.Creator<Page>() { // from class: tv.danmaku.bili.ui.offline.api.Page.1
        @Override // android.os.Parcelable.Creator
        public Page createFromParcel(Parcel in) {
            return new Page(in);
        }

        @Override // android.os.Parcelable.Creator
        public Page[] newArray(int size) {
            return new Page[size];
        }
    };
    public Dimension dimension;
    public long duration;
    public String from;
    public long id;
    public String intro;
    public boolean isVipOnly;
    public String link;
    public List<Meta> metas;
    public int page;
    public int quality;
    public int realPage;
    public String title;
    public VideoDownloadEntry videoDownloadEntry;

    public Page() {
        this.metas = Collections.emptyList();
    }

    protected Page(Parcel in) {
        this.metas = Collections.emptyList();
        this.duration = in.readLong();
        this.from = in.readString();
        this.id = in.readLong();
        this.metas = in.createTypedArrayList(Meta.CREATOR);
        this.page = in.readInt();
        this.title = in.readString();
        this.intro = in.readString();
        this.link = in.readString();
        this.videoDownloadEntry = in.readParcelable(VideoDownloadEntry.class.getClassLoader());
        this.quality = in.readInt();
        this.isVipOnly = in.readInt() == 1;
        this.realPage = in.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.duration);
        dest.writeString(this.from);
        dest.writeLong(this.id);
        dest.writeTypedList(this.metas);
        dest.writeInt(this.page);
        dest.writeString(this.title);
        dest.writeString(this.intro);
        dest.writeString(this.link);
        dest.writeParcelable(this.videoDownloadEntry, flags);
        dest.writeInt(this.quality);
        dest.writeInt(this.isVipOnly ? 1 : 0);
        dest.writeInt(this.realPage);
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
        Page that = (Page) o;
        if (this.id == that.id) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((int) (this.id ^ (this.id >> 30))) + this.title.hashCode();
    }
}