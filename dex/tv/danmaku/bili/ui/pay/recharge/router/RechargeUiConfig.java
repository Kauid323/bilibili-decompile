package tv.danmaku.bili.ui.pay.recharge.router;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import tv.danmaku.bili.ui.rank.router.RankRouter;

public class RechargeUiConfig implements Parcelable {
    public static final Parcelable.Creator<RechargeUiConfig> CREATOR = new Parcelable.Creator<RechargeUiConfig>() { // from class: tv.danmaku.bili.ui.pay.recharge.router.RechargeUiConfig.1
        @Override // android.os.Parcelable.Creator
        public RechargeUiConfig createFromParcel(Parcel source) {
            return new RechargeUiConfig(source);
        }

        @Override // android.os.Parcelable.Creator
        public RechargeUiConfig[] newArray(int size) {
            return new RechargeUiConfig[size];
        }
    };
    @JSONField(name = "maxConsumptionValue")
    public float maxConsumptionValue;
    @JSONField(name = "notEnoughDialogInfo")
    public NotEnoughDialogInfo notEnoughDialogInfo;
    @JSONField(name = "tooLargeDialogInfo")
    public TooLargeDialogInfo tooLargeDialogInfo;

    public RechargeUiConfig() {
        this.maxConsumptionValue = -1.0f;
    }

    public RechargeUiConfig(Builder builder) {
        this.maxConsumptionValue = -1.0f;
        this.maxConsumptionValue = builder.maxConsumptionValue;
        if (!TextUtils.isEmpty(builder.tl_message)) {
            this.tooLargeDialogInfo = new TooLargeDialogInfo(builder.tl_title, builder.tl_message, builder.tl_negative, builder.tl_positive);
        }
        if (!TextUtils.isEmpty(builder.ne_message)) {
            this.notEnoughDialogInfo = new NotEnoughDialogInfo(builder.ne_title, builder.ne_message, builder.ne_negative, builder.ne_positive);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(this.maxConsumptionValue);
        dest.writeParcelable(this.tooLargeDialogInfo, flags);
        dest.writeParcelable(this.notEnoughDialogInfo, flags);
    }

    protected RechargeUiConfig(Parcel in) {
        this.maxConsumptionValue = -1.0f;
        this.maxConsumptionValue = in.readFloat();
        this.tooLargeDialogInfo = (TooLargeDialogInfo) in.readParcelable(TooLargeDialogInfo.class.getClassLoader());
        this.notEnoughDialogInfo = (NotEnoughDialogInfo) in.readParcelable(NotEnoughDialogInfo.class.getClassLoader());
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class TooLargeDialogInfo implements Parcelable {
        public static final Parcelable.Creator<TooLargeDialogInfo> CREATOR = new Parcelable.Creator<TooLargeDialogInfo>() { // from class: tv.danmaku.bili.ui.pay.recharge.router.RechargeUiConfig.TooLargeDialogInfo.1
            @Override // android.os.Parcelable.Creator
            public TooLargeDialogInfo createFromParcel(Parcel source) {
                return new TooLargeDialogInfo(source);
            }

            @Override // android.os.Parcelable.Creator
            public TooLargeDialogInfo[] newArray(int size) {
                return new TooLargeDialogInfo[size];
            }
        };
        @JSONField(name = "message")
        public String message;
        @JSONField(name = "negative")
        public String negative;
        @JSONField(name = "positive")
        public String positive;
        @JSONField(name = RankRouter.BundleKey.ACTION_PARAM_TITLE)
        public String title;

        public TooLargeDialogInfo() {
        }

        public TooLargeDialogInfo(String title, String message, String negative, String positive) {
            this.title = title;
            this.message = message;
            this.negative = negative;
            this.positive = positive;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.title);
            dest.writeString(this.message);
            dest.writeString(this.negative);
            dest.writeString(this.positive);
        }

        protected TooLargeDialogInfo(Parcel in) {
            this.title = in.readString();
            this.message = in.readString();
            this.negative = in.readString();
            this.positive = in.readString();
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class NotEnoughDialogInfo implements Parcelable {
        public static final Parcelable.Creator<NotEnoughDialogInfo> CREATOR = new Parcelable.Creator<NotEnoughDialogInfo>() { // from class: tv.danmaku.bili.ui.pay.recharge.router.RechargeUiConfig.NotEnoughDialogInfo.1
            @Override // android.os.Parcelable.Creator
            public NotEnoughDialogInfo createFromParcel(Parcel source) {
                return new NotEnoughDialogInfo(source);
            }

            @Override // android.os.Parcelable.Creator
            public NotEnoughDialogInfo[] newArray(int size) {
                return new NotEnoughDialogInfo[size];
            }
        };
        @JSONField(name = "message")
        public String message;
        @JSONField(name = "negative")
        public String negative;
        @JSONField(name = "positive")
        public String positive;
        @JSONField(name = RankRouter.BundleKey.ACTION_PARAM_TITLE)
        public String title;

        public NotEnoughDialogInfo() {
        }

        public NotEnoughDialogInfo(String title, String message, String negative, String positive) {
            this.title = title;
            this.message = message;
            this.negative = negative;
            this.positive = positive;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.title);
            dest.writeString(this.message);
            dest.writeString(this.negative);
            dest.writeString(this.positive);
        }

        protected NotEnoughDialogInfo(Parcel in) {
            this.title = in.readString();
            this.message = in.readString();
            this.negative = in.readString();
            this.positive = in.readString();
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Builder {
        public float maxConsumptionValue = -1.0f;
        private String ne_message;
        private String ne_negative;
        private String ne_positive;
        private String ne_title;
        private String tl_message;
        private String tl_negative;
        private String tl_positive;
        private String tl_title;

        public Builder tooLargeDialog(String title, String message, String negative, String positive) {
            this.tl_title = title;
            this.tl_message = message;
            this.tl_negative = negative;
            this.tl_positive = positive;
            return this;
        }

        public Builder notEnoughDialog(String title, String message, String negative, String positive) {
            this.ne_title = title;
            this.ne_message = message;
            this.ne_negative = negative;
            this.ne_positive = positive;
            return this;
        }

        public Builder maxConsumptionValue(float max) {
            this.maxConsumptionValue = max;
            return this;
        }

        public RechargeUiConfig build() {
            return new RechargeUiConfig(this);
        }
    }
}