package tv.danmaku.bili.ui.offline.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;

public class Upper implements Parcelable {
    public static final Parcelable.Creator<Upper> CREATOR = new Parcelable.Creator<Upper>() { // from class: tv.danmaku.bili.ui.offline.api.Upper.1
        @Override // android.os.Parcelable.Creator
        public Upper createFromParcel(Parcel in) {
            return new Upper(in);
        }

        @Override // android.os.Parcelable.Creator
        public Upper[] newArray(int size) {
            return new Upper[size];
        }
    };
    @JSONField(name = "display_name")
    public String displayName;
    public String face;
    public long fans;
    public int followed;
    public long mid;
    public String name;
    @JSONField(name = "official_desc")
    public String officialDesc;
    @JSONField(name = "official_role")
    public int officialRole;
    @JSONField(name = "official_title")
    public String officialTitle;
    @JSONField(name = "vip_due_date")
    public long vipDueDate;
    @JSONField(name = "vip_pay_type")
    public int vipPayType;
    @JSONField(name = "vip_statue")
    public int vipStatue;
    @JSONField(name = "vip_type")
    public int vipType;

    public Upper() {
    }

    protected Upper(Parcel in) {
        this.face = in.readString();
        this.followed = in.readInt();
        this.mid = in.readLong();
        this.name = in.readString();
        this.vipType = in.readInt();
        this.vipStatue = in.readInt();
        this.vipDueDate = in.readLong();
        this.vipPayType = in.readInt();
        this.fans = in.readLong();
        this.officialRole = in.readInt();
        this.officialTitle = in.readString();
        this.officialDesc = in.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.face);
        dest.writeInt(this.followed);
        dest.writeLong(this.mid);
        dest.writeString(this.name);
        dest.writeInt(this.vipType);
        dest.writeInt(this.vipStatue);
        dest.writeLong(this.vipDueDate);
        dest.writeInt(this.vipPayType);
        dest.writeLong(this.fans);
        dest.writeInt(this.officialRole);
        dest.writeString(this.officialTitle);
        dest.writeString(this.officialDesc);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isFollowed() {
        return this.followed == 1;
    }

    public void setFollowed(boolean isFollowed) {
        this.followed = isFollowed ? 1 : 0;
    }
}