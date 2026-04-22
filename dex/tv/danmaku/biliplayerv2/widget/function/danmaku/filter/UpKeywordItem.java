package tv.danmaku.biliplayerv2.widget.function.danmaku.filter;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import tv.danmaku.bili.ui.rank.router.RankRouter;

public class UpKeywordItem extends BaseKeywordItem {
    public static final Parcelable.Creator<UpKeywordItem> CREATOR = new Parcelable.Creator<UpKeywordItem>() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.UpKeywordItem.1
        @Override // android.os.Parcelable.Creator
        public UpKeywordItem createFromParcel(Parcel source) {
            return new UpKeywordItem(source);
        }

        @Override // android.os.Parcelable.Creator
        public UpKeywordItem[] newArray(int size) {
            return new UpKeywordItem[size];
        }
    };
    @JSONField(name = "cid")
    public long cid;
    @JSONField(name = RankRouter.BundleKey.AUTHOR_SPACE_MID)
    public long mid;

    public UpKeywordItem() {
    }

    private UpKeywordItem(Parcel parcel) {
        super(parcel);
        this.mid = parcel.readLong();
        this.cid = parcel.readLong();
    }

    @Override // tv.danmaku.biliplayerv2.widget.function.danmaku.filter.BaseKeywordItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // tv.danmaku.biliplayerv2.widget.function.danmaku.filter.BaseKeywordItem, android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeLong(this.mid);
        dest.writeLong(this.cid);
    }
}