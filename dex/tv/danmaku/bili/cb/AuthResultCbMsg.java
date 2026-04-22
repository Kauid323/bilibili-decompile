package tv.danmaku.bili.cb;

import android.os.Parcel;
import android.os.Parcelable;

public class AuthResultCbMsg implements Parcelable {
    public static final Parcelable.Creator<AuthResultCbMsg> CREATOR = new Parcelable.Creator<AuthResultCbMsg>() { // from class: tv.danmaku.bili.cb.AuthResultCbMsg.1
        @Override // android.os.Parcelable.Creator
        public AuthResultCbMsg createFromParcel(Parcel in) {
            return new AuthResultCbMsg(in);
        }

        @Override // android.os.Parcelable.Creator
        public AuthResultCbMsg[] newArray(int size) {
            return new AuthResultCbMsg[size];
        }
    };
    public static final int STATE_APPLYING = 2;
    public static final int STATE_CANCEL = -1;
    public static final int STATE_FAIL = 0;
    public static final int STATE_PASSED = 3;
    public static final int STATE_SUCCESS = 1;
    public String authCode;
    public int errorCode;
    public String msg;
    public String requestId;
    public int state;

    public AuthResultCbMsg(int state) {
        this.state = state;
        this.msg = "";
    }

    public AuthResultCbMsg(int state, String msg, String authCode) {
        this.state = state;
        this.msg = msg;
        this.authCode = authCode;
    }

    public AuthResultCbMsg(int state, String msg) {
        this.state = state;
        this.msg = msg == null ? "" : msg;
    }

    public AuthResultCbMsg(int state, String msg, int errorCode) {
        this.state = state;
        this.msg = msg == null ? "" : msg;
        this.errorCode = errorCode;
    }

    protected AuthResultCbMsg(Parcel in) {
        this.state = in.readInt();
        this.msg = in.readString();
        this.errorCode = in.readInt();
        this.authCode = in.readString();
        this.requestId = in.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.state);
        dest.writeString(this.msg);
        dest.writeInt(this.errorCode);
        dest.writeString(this.authCode);
        dest.writeString(this.requestId);
    }
}