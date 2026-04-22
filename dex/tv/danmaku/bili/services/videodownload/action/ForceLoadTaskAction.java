package tv.danmaku.bili.services.videodownload.action;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.bilibili.videodownloader.action.ServiceCustomizableAction;

public class ForceLoadTaskAction extends ServiceCustomizableAction {
    public static final Parcelable.Creator<ForceLoadTaskAction> CREATOR = new Parcelable.Creator<ForceLoadTaskAction>() { // from class: tv.danmaku.bili.services.videodownload.action.ForceLoadTaskAction.1
        @Override // android.os.Parcelable.Creator
        public ForceLoadTaskAction createFromParcel(Parcel source) {
            return new ForceLoadTaskAction(source);
        }

        @Override // android.os.Parcelable.Creator
        public ForceLoadTaskAction[] newArray(int size) {
            return new ForceLoadTaskAction[size];
        }
    };

    public boolean isNoneDistinction(Context context) {
        return true;
    }

    public int performAction() {
        return 5;
    }

    public String getSimpleName() {
        return "ForceLoadTaskAction";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
    }

    public ForceLoadTaskAction() {
    }

    protected ForceLoadTaskAction(Parcel in) {
    }
}