package tv.danmaku.bili.cb;

import android.app.Activity;
import android.content.Intent;
import tv.danmaku.bili.auth.BiliAuthTransferActivity;

public class AuthResultCbHelper {
    public static final String ARGS_CALLBACK = "callback";
    public static final String ARGS_CBM = "cbm";
    public static final String ARGS_MSG = "msg";
    public static final String ARGS_STATE = "state";

    public static void setResultToActivity(Activity activity, int state) {
        setResultToActivity(activity, state, 0);
    }

    public static void setResultToActivityWithRequestId(Activity activity, int state, String requestId) {
        Intent intent = new Intent();
        AuthResultCbMsg msg = new AuthResultCbMsg(state);
        msg.requestId = requestId;
        intent.putExtra(ARGS_CBM, msg);
        activity.setResult(-1, intent);
    }

    public static void setResultToActivity(Activity activity, int state, int ageInfo) {
        Intent intent = new Intent();
        intent.putExtra(ARGS_CBM, new AuthResultCbMsg(state));
        intent.putExtra(BiliAuthTransferActivity.KEY_AGE_INFO, ageInfo);
        activity.setResult(-1, intent);
    }

    public static void setResultToActivity(Activity activity, int state, int ageInfo, String authCode, String requestId) {
        Intent intent = new Intent();
        AuthResultCbMsg msg = new AuthResultCbMsg(state, "", authCode);
        msg.requestId = requestId;
        intent.putExtra(ARGS_CBM, msg);
        intent.putExtra(BiliAuthTransferActivity.KEY_AGE_INFO, ageInfo);
        activity.setResult(-1, intent);
    }

    public static void setResultToActivity(Activity activity, int state, String msg) {
        Intent intent = new Intent();
        intent.putExtra(ARGS_CBM, new AuthResultCbMsg(state, msg));
        activity.setResult(-1, intent);
    }

    public static void setResultToActivity(Activity activity, AuthResultCbMsg authResultCbMsg) {
        Intent intent = new Intent();
        intent.putExtra(ARGS_CBM, authResultCbMsg);
        activity.setResult(-1, intent);
    }
}