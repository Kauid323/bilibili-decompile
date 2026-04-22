package tv.danmaku.bili.ui.offline.api;

import android.os.Parcel;
import android.os.Parcelable;

public class Meta implements Parcelable {
    public static final Parcelable.Creator<Meta> CREATOR = new Parcelable.Creator<Meta>() { // from class: tv.danmaku.bili.ui.offline.api.Meta.1
        @Override // android.os.Parcelable.Creator
        public Meta createFromParcel(Parcel in) {
            return new Meta(in);
        }

        @Override // android.os.Parcelable.Creator
        public Meta[] newArray(int size) {
            return new Meta[size];
        }
    };
    public int quality;
    public long size;

    public Meta() {
    }

    protected Meta(Parcel in) {
        this.quality = in.readInt();
        this.size = in.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.quality);
        dest.writeLong(this.size);
    }
}