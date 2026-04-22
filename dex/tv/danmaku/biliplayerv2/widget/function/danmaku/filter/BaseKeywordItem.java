package tv.danmaku.biliplayerv2.widget.function.danmaku.filter;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

public class BaseKeywordItem implements Parcelable {
    public static final Parcelable.Creator<BaseKeywordItem> CREATOR = new Parcelable.Creator<BaseKeywordItem>() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.BaseKeywordItem.1
        @Override // android.os.Parcelable.Creator
        public BaseKeywordItem createFromParcel(Parcel source) {
            return new BaseKeywordItem(source);
        }

        @Override // android.os.Parcelable.Creator
        public BaseKeywordItem[] newArray(int size) {
            return new BaseKeywordItem[size];
        }
    };
    public static final String LEGAL_REGULAR_EXPRESSION = "^(\\/)(.+)\\/([img])*$";
    private static final String TAG = "BaseKeywordItem";
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_REGEX = 1;
    public static final int TYPE_USER = 2;
    @JSONField(name = "filter")
    public String data;
    @JSONField(name = "id")
    public long id;
    @JSONField(name = "type")
    public int type;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseKeywordItem() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseKeywordItem(Parcel parcel) {
        this.id = parcel.readLong();
        this.type = parcel.readInt();
        this.data = parcel.readString();
    }

    public static boolean isRegular(String content) {
        return !TextUtils.isEmpty(content) && content.matches(LEGAL_REGULAR_EXPRESSION);
    }

    public String toString() {
        try {
            return JSON.toJSONString(this);
        } catch (Exception e) {
            return "";
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof BaseKeywordItem) && this.id == ((BaseKeywordItem) obj).id && this.type == ((BaseKeywordItem) obj).type && this.data.equals(((BaseKeywordItem) obj).data);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeInt(this.type);
        dest.writeString(this.data);
    }
}