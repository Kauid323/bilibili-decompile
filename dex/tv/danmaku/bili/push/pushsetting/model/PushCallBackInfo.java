package tv.danmaku.bili.push.pushsetting.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import bili.resource.favorites.R;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.base.BiliContext;
import java.util.List;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

public class PushCallBackInfo implements Parcelable {
    public static final Parcelable.Creator<PushCallBackInfo> CREATOR = new Parcelable.Creator<PushCallBackInfo>() { // from class: tv.danmaku.bili.push.pushsetting.model.PushCallBackInfo.1
        @Override // android.os.Parcelable.Creator
        public PushCallBackInfo createFromParcel(Parcel in) {
            return new PushCallBackInfo(in);
        }

        @Override // android.os.Parcelable.Creator
        public PushCallBackInfo[] newArray(int size) {
            return new PushCallBackInfo[size];
        }
    };
    @JSONField(name = "ab_msg")
    public String abMsg;
    @JSONField(name = "banner")
    public PushBanner banner;
    @JSONField(name = "close_btn")
    public String closeButton;
    @JSONField(name = "confirm_action")
    public int confirmAction;
    @JSONField(name = "content")
    public String content;
    @JSONField(name = "contents")
    public List<String> contents;
    @JSONField(name = "filter_type")
    public String filterType;
    @JSONField(name = "notice_query")
    public boolean noticeQuery;
    @JSONField(name = "notices")
    public List<PushNotice> notices;
    @JSONField(name = "notify")
    public boolean notify;
    @JSONField(name = "open_btn")
    public String openButton;
    @JSONField(name = "popup_type")
    public int popupType;
    @JSONField(name = "template_type")
    public int templateType;
    @JSONField(name = ReportUtilKt.POS_TITLE)
    public String title;

    public boolean isSystemDialog() {
        return this.popupType == 1;
    }

    public boolean isManufacturerDialog() {
        return this.popupType == 2;
    }

    public PushCallBackInfo() {
        this.templateType = 0;
        this.confirmAction = 0;
        this.noticeQuery = false;
    }

    protected PushCallBackInfo(Parcel in) {
        this.templateType = 0;
        this.confirmAction = 0;
        this.noticeQuery = false;
        this.notify = in.readByte() != 0;
        this.title = in.readString();
        this.content = in.readString();
        this.templateType = in.readInt();
        this.confirmAction = in.readInt();
        this.popupType = in.readInt();
        this.abMsg = in.readString();
        this.banner = (PushBanner) in.readParcelable(PushBanner.class.getClassLoader());
        this.contents = in.createStringArrayList();
        this.closeButton = in.readString();
        this.openButton = in.readString();
        this.filterType = in.readString();
        this.notices = in.createTypedArrayList(PushNotice.CREATOR);
        this.noticeQuery = in.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.notify ? (byte) 1 : (byte) 0);
        dest.writeString(this.title);
        dest.writeString(this.content);
        dest.writeInt(this.templateType);
        dest.writeInt(this.confirmAction);
        dest.writeInt(this.popupType);
        dest.writeString(this.abMsg);
        dest.writeParcelable(this.banner, flags);
        dest.writeStringList(this.contents);
        dest.writeString(this.closeButton);
        dest.writeString(this.openButton);
        dest.writeString(this.filterType);
        dest.writeTypedList(this.notices);
        dest.writeByte(this.noticeQuery ? (byte) 1 : (byte) 0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getValidTitle() {
        if (TextUtils.isEmpty(this.title)) {
            return BiliContext.application().getString(R.string.favorites_global_string_34);
        }
        return this.title;
    }

    public String getValidContent() {
        if (TextUtils.isEmpty(this.content)) {
            return BiliContext.application().getString(R.string.favorites_global_string_43);
        }
        return this.content;
    }
}