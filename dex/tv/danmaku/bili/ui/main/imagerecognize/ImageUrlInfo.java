package tv.danmaku.bili.ui.main.imagerecognize;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.push.innerpush.v2.InnerPushReceiverKt;
import tv.danmaku.bili.ui.garb.NftCardJsBridgeCallHandler;

/* compiled from: ImageRecognizeHelper.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 ]2\u00020\u0001:\u0001]B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0006\u0010U\u001a\u000205J\u0006\u0010V\u001a\u000205J\u0006\u0010W\u001a\u000205J\u0006\u0010X\u001a\u000205J\u0018\u0010Y\u001a\u00020Z2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010[\u001a\u00020 H\u0016J\b\u0010\\\u001a\u00020 H\u0016R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R \u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R \u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R \u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010%\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012R \u0010(\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u0012R \u0010+\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012R \u0010.\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\u0002058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010:\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\"\"\u0004\b<\u0010$R \u0010=\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0010\"\u0004\b?\u0010\u0012R \u0010@\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0010\"\u0004\bB\u0010\u0012R \u0010C\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0010\"\u0004\bE\u0010\u0012R \u0010F\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0010\"\u0004\bH\u0010\u0012R \u0010I\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0010\"\u0004\bK\u0010\u0012R\u001e\u0010L\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\"\"\u0004\bN\u0010$R\u001c\u0010O\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0010\"\u0004\bQ\u0010\u0012R\u001c\u0010R\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0010\"\u0004\bT\u0010\u0012¨\u0006^"}, d2 = {"Ltv/danmaku/bili/ui/main/imagerecognize/ImageUrlInfo;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "aid", "", "getAid", "()J", "setAid", "(J)V", ReportUtilKt.POS_TITLE, "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "picUrl", "getPicUrl", "setPicUrl", "schema", "getSchema", "setSchema", "message", "getMessage", "setMessage", "shareBuvid", "getShareBuvid", "setShareBuvid", "shareType", "", "getShareType", "()I", "setShareType", "(I)V", "shareTime", "getShareTime", "setShareTime", "shareId", "getShareId", "setShareId", "shareOrigin", "getShareOrigin", "setShareOrigin", AppConfig.HOST_AUTHOR, "Ltv/danmaku/bili/ui/main/imagerecognize/ShareAuthor;", "getAuthor", "()Ltv/danmaku/bili/ui/main/imagerecognize/ShareAuthor;", "setAuthor", "(Ltv/danmaku/bili/ui/main/imagerecognize/ShareAuthor;)V", "autoClose", "", "getAutoClose", "()Z", "setAutoClose", "(Z)V", "autoCloseTime", "getAutoCloseTime", "setAutoCloseTime", "playCount", "getPlayCount", "setPlayCount", "duration", "getDuration", "setDuration", InnerPushReceiverKt.KEY_EXTRA, NftCardJsBridgeCallHandler.GET_EXTRA, "setExtra", "markUrl", "getMarkUrl", "setMarkUrl", "buttonText", "getButtonText", "setButtonText", "markType", "getMarkType", "setMarkType", "imageLocalPath", "getImageLocalPath", "setImageLocalPath", "originUrl", "getOriginUrl", "setOriginUrl", "isValid", "isStory", "isUpShare", "hasHonor", "writeToParcel", "", "flags", "describeContents", "CREATOR", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ImageUrlInfo implements Parcelable {
    @JSONField(name = "aid")
    private long aid;
    @JSONField(name = AppConfig.HOST_AUTHOR)
    private ShareAuthor author;
    @JSONField(name = "auto_close")
    private boolean autoClose;
    @JSONField(name = "auto_close_after")
    private int autoCloseTime;
    @JSONField(name = "button_text")
    private String buttonText;
    @JSONField(name = "duration")
    private String duration;
    @JSONField(name = InnerPushReceiverKt.KEY_EXTRA)
    private String extra;
    private String imageLocalPath;
    @JSONField(name = "corner_mark_type")
    private int markType;
    @JSONField(name = "corner_mark")
    private String markUrl;
    @JSONField(name = "message")
    private String message;
    private String originUrl;
    @JSONField(name = "pic")
    private String picUrl;
    @JSONField(name = "view")
    private String playCount;
    @JSONField(name = "schema")
    private String schema;
    @JSONField(name = "share_buvid")
    private String shareBuvid;
    @JSONField(name = "share_id")
    private String shareId;
    @JSONField(name = "share_origin")
    private String shareOrigin;
    @JSONField(name = "share_time")
    private String shareTime;
    @JSONField(name = "share_type")
    private int shareType;
    @JSONField(name = ReportUtilKt.POS_TITLE)
    private String title;
    public static final CREATOR CREATOR = new CREATOR(null);
    public static final int $stable = 8;

    public ImageUrlInfo() {
        this.title = "";
        this.picUrl = "";
        this.schema = "";
        this.message = "";
        this.shareBuvid = "";
        this.shareTime = "";
        this.shareId = "";
        this.shareOrigin = "";
        this.autoCloseTime = 5;
        this.playCount = "";
        this.duration = "";
        this.extra = "";
        this.markUrl = "";
        this.buttonText = "";
        this.imageLocalPath = "";
        this.originUrl = "";
    }

    public final long getAid() {
        return this.aid;
    }

    public final void setAid(long j) {
        this.aid = j;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getPicUrl() {
        return this.picUrl;
    }

    public final void setPicUrl(String str) {
        this.picUrl = str;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final void setSchema(String str) {
        this.schema = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final String getShareBuvid() {
        return this.shareBuvid;
    }

    public final void setShareBuvid(String str) {
        this.shareBuvid = str;
    }

    public final int getShareType() {
        return this.shareType;
    }

    public final void setShareType(int i) {
        this.shareType = i;
    }

    public final String getShareTime() {
        return this.shareTime;
    }

    public final void setShareTime(String str) {
        this.shareTime = str;
    }

    public final String getShareId() {
        return this.shareId;
    }

    public final void setShareId(String str) {
        this.shareId = str;
    }

    public final String getShareOrigin() {
        return this.shareOrigin;
    }

    public final void setShareOrigin(String str) {
        this.shareOrigin = str;
    }

    public final ShareAuthor getAuthor() {
        return this.author;
    }

    public final void setAuthor(ShareAuthor shareAuthor) {
        this.author = shareAuthor;
    }

    public final boolean getAutoClose() {
        return this.autoClose;
    }

    public final void setAutoClose(boolean z) {
        this.autoClose = z;
    }

    public final int getAutoCloseTime() {
        return this.autoCloseTime;
    }

    public final void setAutoCloseTime(int i) {
        this.autoCloseTime = i;
    }

    public final String getPlayCount() {
        return this.playCount;
    }

    public final void setPlayCount(String str) {
        this.playCount = str;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final void setDuration(String str) {
        this.duration = str;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final void setExtra(String str) {
        this.extra = str;
    }

    public final String getMarkUrl() {
        return this.markUrl;
    }

    public final void setMarkUrl(String str) {
        this.markUrl = str;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final void setButtonText(String str) {
        this.buttonText = str;
    }

    public final int getMarkType() {
        return this.markType;
    }

    public final void setMarkType(int i) {
        this.markType = i;
    }

    public final String getImageLocalPath() {
        return this.imageLocalPath;
    }

    public final void setImageLocalPath(String str) {
        this.imageLocalPath = str;
    }

    public final String getOriginUrl() {
        return this.originUrl;
    }

    public final void setOriginUrl(String str) {
        this.originUrl = str;
    }

    public final boolean isValid() {
        return true;
    }

    public final boolean isStory() {
        return TextUtils.equals(this.shareOrigin, AppConfig.HOST_STORY);
    }

    public final boolean isUpShare() {
        return this.shareType == 3;
    }

    public final boolean hasHonor() {
        ShareAuthor shareAuthor = this.author;
        boolean z = false;
        if (shareAuthor != null && shareAuthor.getUpHonor() == 0) {
            z = true;
        }
        return !z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageUrlInfo(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.aid = parcel.readLong();
        this.title = parcel.readString();
        this.picUrl = parcel.readString();
        this.schema = parcel.readString();
        this.message = parcel.readString();
        this.shareBuvid = parcel.readString();
        this.shareType = parcel.readInt();
        this.shareTime = parcel.readString();
        this.shareId = parcel.readString();
        this.shareOrigin = parcel.readString();
        this.author = (ShareAuthor) parcel.readParcelable(ShareAuthor.class.getClassLoader());
        this.autoClose = parcel.readByte() != 0;
        this.autoCloseTime = parcel.readInt();
        this.playCount = parcel.readString();
        this.duration = parcel.readString();
        this.imageLocalPath = parcel.readString();
        this.originUrl = parcel.readString();
        this.extra = parcel.readString();
        this.buttonText = parcel.readString();
        this.markUrl = parcel.readString();
        this.markType = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.aid);
        parcel.writeString(this.title);
        parcel.writeString(this.picUrl);
        parcel.writeString(this.schema);
        parcel.writeString(this.message);
        parcel.writeString(this.shareBuvid);
        parcel.writeInt(this.shareType);
        parcel.writeString(this.shareTime);
        parcel.writeString(this.shareId);
        parcel.writeString(this.shareOrigin);
        parcel.writeParcelable(this.author, flags);
        parcel.writeByte(this.autoClose ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.autoCloseTime);
        parcel.writeString(this.playCount);
        parcel.writeString(this.duration);
        parcel.writeString(this.imageLocalPath);
        parcel.writeString(this.originUrl);
        parcel.writeString(this.extra);
        parcel.writeString(this.buttonText);
        parcel.writeString(this.markUrl);
        parcel.writeInt(this.markType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* compiled from: ImageRecognizeHelper.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/main/imagerecognize/ImageUrlInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/bili/ui/main/imagerecognize/ImageUrlInfo;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ltv/danmaku/bili/ui/main/imagerecognize/ImageUrlInfo;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class CREATOR implements Parcelable.Creator<ImageUrlInfo> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public ImageUrlInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ImageUrlInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ImageUrlInfo[] newArray(int size) {
            return new ImageUrlInfo[size];
        }
    }
}