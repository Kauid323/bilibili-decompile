package tv.danmaku.bili.report;

import android.content.Context;
import com.bilibili.base.Applications;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.lib.accounts.BiliAccounts;

class InfoEyesOperatingDataPublicQueryString {
    public static final String KEY_MID = "mid";
    public static final String KEY_NET = "net";
    public static final String KEY_OID = "oid";
    public static final String KEY_VER = "ver";
    private String mMID;
    private int mNet;
    private String mOID;
    private String mVer;

    public InfoEyesOperatingDataPublicQueryString() {
        Context context = Applications.getCurrent();
        long mid = BiliAccounts.get(context).mid();
        if (mid > 0) {
            this.mMID = String.valueOf(mid);
        } else {
            this.mMID = "";
        }
        this.mVer = InfoEyesUtils.getAppVersion(context);
        this.mNet = ConnectivityMonitor.getInstance().getNetwork();
        try {
            this.mOID = InfoEyesUtils.getTelephonyProvider(context);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.mOID = "";
        }
    }

    public String toString() {
        return "mid=" + this.mMID + "&" + KEY_VER + "=" + this.mVer + "&" + KEY_NET + "=" + this.mNet + "&oid=" + this.mOID;
    }

    public static String get() {
        return new InfoEyesOperatingDataPublicQueryString().toString();
    }

    public static String get2() {
        InfoEyesOperatingDataPublicQueryString instance = new InfoEyesOperatingDataPublicQueryString();
        StringBuilder builder = new StringBuilder();
        builder.append(instance.mMID).append("|").append(instance.mVer).append("|").append("" + instance.mNet).append("|").append(instance.mOID);
        return builder.toString();
    }
}