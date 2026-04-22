package tv.danmaku.bili.category;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;

public class CategorySense implements Parcelable {
    public static final Parcelable.Creator<CategorySense> CREATOR = new Parcelable.Creator<CategorySense>() { // from class: tv.danmaku.bili.category.CategorySense.1
        @Override // android.os.Parcelable.Creator
        public CategorySense createFromParcel(Parcel in) {
            return new CategorySense(in);
        }

        @Override // android.os.Parcelable.Creator
        public CategorySense[] newArray(int size) {
            return new CategorySense[size];
        }
    };
    @JSONField(name = "scenes_name")
    public String mSensesName;
    @JSONField(name = "senses_type")
    public String mSensesType;

    public CategorySense() {
    }

    protected CategorySense(Parcel in) {
        this.mSensesName = in.readString();
        this.mSensesType = in.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mSensesName);
        dest.writeString(this.mSensesType);
    }
}