package tv.danmaku.biliplayerv2.widget.function.danmaku.filter;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import tv.danmaku.bili.ui.rank.router.RankRouter;

public class UserKeywordItem extends BaseKeywordItem {
    public static final Parcelable.Creator<UserKeywordItem> CREATOR = new Parcelable.Creator<UserKeywordItem>() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.UserKeywordItem.1
        @Override // android.os.Parcelable.Creator
        public UserKeywordItem createFromParcel(Parcel source) {
            return new UserKeywordItem(source);
        }

        @Override // android.os.Parcelable.Creator
        public UserKeywordItem[] newArray(int size) {
            return new UserKeywordItem[size];
        }
    };
    public static final int ID_NOT_UPLOAD = -2024;
    @JSONField(name = "comment")
    public String comment;
    @JSONField(name = RankRouter.BundleKey.AUTHOR_SPACE_MID)
    public long mid;

    private UserKeywordItem() {
    }

    public UserKeywordItem(long mid, int type, String data) {
        this.mid = mid;
        this.type = type;
        this.data = data;
    }

    public UserKeywordItem(long mid, int type, String data, String comment) {
        this.mid = mid;
        this.type = type;
        this.data = data;
        this.comment = comment;
    }

    private UserKeywordItem(Parcel parcel) {
        super(parcel);
        this.mid = parcel.readLong();
        this.comment = parcel.readString();
    }

    @Override // tv.danmaku.biliplayerv2.widget.function.danmaku.filter.BaseKeywordItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // tv.danmaku.biliplayerv2.widget.function.danmaku.filter.BaseKeywordItem, android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeLong(this.mid);
        dest.writeString(this.comment);
    }

    public UserKeywordItem copy() {
        UserKeywordItem result = new UserKeywordItem(this.mid, this.type, this.data);
        result.id = this.id;
        if (this.comment != null) {
            result.comment = this.comment;
        }
        return result;
    }
}