package tv.danmaku.biliplayerv2.widget.function.danmaku.filter;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;

public class GlobalKeywordItem extends BaseKeywordItem {
    public static final Parcelable.Creator<GlobalKeywordItem> CREATOR = new Parcelable.Creator<GlobalKeywordItem>() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.GlobalKeywordItem.1
        @Override // android.os.Parcelable.Creator
        public GlobalKeywordItem createFromParcel(Parcel source) {
            return new GlobalKeywordItem(source);
        }

        @Override // android.os.Parcelable.Creator
        public GlobalKeywordItem[] newArray(int size) {
            return new GlobalKeywordItem[size];
        }
    };
    @JSONField(name = "version")
    public String mVersion;

    public GlobalKeywordItem() {
    }

    private GlobalKeywordItem(Parcel parcel) {
        super(parcel);
        this.mVersion = parcel.readString();
    }

    @Override // tv.danmaku.biliplayerv2.widget.function.danmaku.filter.BaseKeywordItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // tv.danmaku.biliplayerv2.widget.function.danmaku.filter.BaseKeywordItem, android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.mVersion);
    }
}