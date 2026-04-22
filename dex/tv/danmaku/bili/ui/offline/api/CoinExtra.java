package tv.danmaku.bili.ui.offline.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;

public class CoinExtra implements Parcelable {
    public static final Parcelable.Creator<CoinExtra> CREATOR = new Parcelable.Creator<CoinExtra>() { // from class: tv.danmaku.bili.ui.offline.api.CoinExtra.1
        @Override // android.os.Parcelable.Creator
        public CoinExtra createFromParcel(Parcel in) {
            return new CoinExtra(in);
        }

        @Override // android.os.Parcelable.Creator
        public CoinExtra[] newArray(int size) {
            return new CoinExtra[size];
        }
    };
    @JSONField(name = "coin_number")
    public int coinNum;
    @JSONField(name = "max_num")
    public int maxNum;

    public CoinExtra() {
    }

    protected CoinExtra(Parcel in) {
        this.maxNum = in.readInt();
        this.coinNum = in.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.maxNum);
        dest.writeInt(this.coinNum);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}