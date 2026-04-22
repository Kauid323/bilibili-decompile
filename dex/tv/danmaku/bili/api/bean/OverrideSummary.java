package tv.danmaku.bili.api.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import tv.danmaku.bili.router.ChannelRoutes;

public class OverrideSummary implements Parcelable {
    public static final Parcelable.Creator<OverrideSummary> CREATOR = new Parcelable.Creator<OverrideSummary>() { // from class: tv.danmaku.bili.api.bean.OverrideSummary.1
        @Override // android.os.Parcelable.Creator
        public OverrideSummary createFromParcel(Parcel in) {
            return new OverrideSummary(in);
        }

        @Override // android.os.Parcelable.Creator
        public OverrideSummary[] newArray(int size) {
            return new OverrideSummary[size];
        }
    };
    @JSONField(name = "override_conf")
    public Config config;
    @JSONField(name = "current_user")
    public User currentUser;
    @JSONField(name = "override_user")
    public User overrideUser;

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class User implements Parcelable {
        public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() { // from class: tv.danmaku.bili.api.bean.OverrideSummary.User.1
            @Override // android.os.Parcelable.Creator
            public User createFromParcel(Parcel in) {
                return new User(in);
            }

            @Override // android.os.Parcelable.Creator
            public User[] newArray(int size) {
                return new User[size];
            }
        };
        @JSONField(name = "face")
        public String face;
        @JSONField(name = "follower")
        public int follower;
        @JSONField(name = "following")
        public int following;
        @JSONField(name = "mid")
        public long mid;
        @JSONField(name = ChannelRoutes.CHANNEL_NAME)
        public String name;

        public User() {
        }

        protected User(Parcel in) {
            this.mid = in.readLong();
            this.name = in.readString();
            this.face = in.readString();
            this.following = in.readInt();
            this.follower = in.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeLong(this.mid);
            dest.writeString(this.name);
            dest.writeString(this.face);
            dest.writeInt(this.following);
            dest.writeInt(this.follower);
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Config implements Parcelable {
        public static final Parcelable.Creator<Config> CREATOR = new Parcelable.Creator<Config>() { // from class: tv.danmaku.bili.api.bean.OverrideSummary.Config.1
            @Override // android.os.Parcelable.Creator
            public Config createFromParcel(Parcel in) {
                return new Config(in);
            }

            @Override // android.os.Parcelable.Creator
            public Config[] newArray(int size) {
                return new Config[size];
            }
        };
        @JSONField(name = "interval_days")
        public int intervalDays;

        public Config() {
        }

        protected Config(Parcel in) {
            this.intervalDays = in.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.intervalDays);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }
    }

    public OverrideSummary() {
    }

    protected OverrideSummary(Parcel in) {
        this.currentUser = (User) in.readParcelable(User.class.getClassLoader());
        this.overrideUser = (User) in.readParcelable(User.class.getClassLoader());
        this.config = (Config) in.readParcelable(Config.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.currentUser, flags);
        dest.writeParcelable(this.overrideUser, flags);
        dest.writeParcelable(this.config, flags);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}