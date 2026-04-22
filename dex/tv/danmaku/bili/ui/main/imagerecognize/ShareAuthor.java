package tv.danmaku.bili.ui.main.imagerecognize;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.app.comm.baseres.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: ImageRecognizeHelper.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010+\u001a\u00020\u0017H\u0016J\u0018\u0010,\u001a\u00020-2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0017H\u0016J\u0006\u0010/\u001a\u00020\u0017R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R \u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R \u0010\"\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R \u0010%\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012R\u001e\u0010(\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001b¨\u00061"}, d2 = {"Ltv/danmaku/bili/ui/main/imagerecognize/ShareAuthor;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "mid", "", "getMid", "()J", "setMid", "(J)V", "nickname", "", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "avatarUrl", "getAvatarUrl", "setAvatarUrl", "officialType", "", "getOfficialType", "()I", "setOfficialType", "(I)V", "follower", "getFollower", "setFollower", "archiveNumber", "getArchiveNumber", "setArchiveNumber", "like", "getLike", "setLike", "officialTitle", "getOfficialTitle", "setOfficialTitle", "upHonor", "getUpHonor", "setUpHonor", "describeContents", "writeToParcel", "", "flags", "getVerifyIcon", "CREATOR", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ShareAuthor implements Parcelable {
    @JSONField(name = "archive_number")
    private String archiveNumber;
    @JSONField(name = "face")
    private String avatarUrl;
    @JSONField(name = "follower")
    private String follower;
    @JSONField(name = "like")
    private String like;
    @JSONField(name = "mid")
    private long mid;
    @JSONField(name = ChannelRoutes.CHANNEL_NAME)
    private String nickname;
    @JSONField(name = "official_title")
    private String officialTitle;
    @JSONField(name = "certification_type")
    private int officialType;
    @JSONField(name = "up_honor")
    private int upHonor;
    public static final CREATOR CREATOR = new CREATOR(null);
    public static final int $stable = 8;

    public ShareAuthor() {
        this.nickname = "";
        this.avatarUrl = "";
        this.follower = "";
        this.archiveNumber = "";
        this.like = "";
        this.officialTitle = "";
    }

    public final long getMid() {
        return this.mid;
    }

    public final void setMid(long j) {
        this.mid = j;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final void setNickname(String str) {
        this.nickname = str;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public final int getOfficialType() {
        return this.officialType;
    }

    public final void setOfficialType(int i) {
        this.officialType = i;
    }

    public final String getFollower() {
        return this.follower;
    }

    public final void setFollower(String str) {
        this.follower = str;
    }

    public final String getArchiveNumber() {
        return this.archiveNumber;
    }

    public final void setArchiveNumber(String str) {
        this.archiveNumber = str;
    }

    public final String getLike() {
        return this.like;
    }

    public final void setLike(String str) {
        this.like = str;
    }

    public final String getOfficialTitle() {
        return this.officialTitle;
    }

    public final void setOfficialTitle(String str) {
        this.officialTitle = str;
    }

    public final int getUpHonor() {
        return this.upHonor;
    }

    public final void setUpHonor(int i) {
        this.upHonor = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareAuthor(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.mid = parcel.readLong();
        this.nickname = parcel.readString();
        this.avatarUrl = parcel.readString();
        this.officialType = parcel.readInt();
        this.follower = parcel.readString();
        this.archiveNumber = parcel.readString();
        this.like = parcel.readString();
        this.officialTitle = parcel.readString();
        this.upHonor = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* compiled from: ImageRecognizeHelper.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/main/imagerecognize/ShareAuthor$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/bili/ui/main/imagerecognize/ShareAuthor;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ltv/danmaku/bili/ui/main/imagerecognize/ShareAuthor;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class CREATOR implements Parcelable.Creator<ShareAuthor> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public ShareAuthor createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ShareAuthor(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ShareAuthor[] newArray(int size) {
            return new ShareAuthor[size];
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.mid);
        parcel.writeString(this.nickname);
        parcel.writeString(this.avatarUrl);
        parcel.writeInt(this.officialType);
        parcel.writeString(this.follower);
        parcel.writeString(this.archiveNumber);
        parcel.writeString(this.like);
        parcel.writeString(this.officialTitle);
        parcel.writeInt(this.upHonor);
    }

    public final int getVerifyIcon() {
        switch (this.officialType) {
            case 0:
                return R.drawable.ic_authentication_personal_size_22;
            case 1:
                return R.drawable.ic_authentication_organization_size_22;
            default:
                return -1;
        }
    }
}