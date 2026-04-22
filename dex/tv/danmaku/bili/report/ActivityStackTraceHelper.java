package tv.danmaku.bili.report;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.bilibili.droid.thread.HandlerThreads;
import java.util.Stack;

public class ActivityStackTraceHelper {
    private static final boolean DEBUG = false;
    private static ActivityStackTraceHelper INSTANCE = null;
    private static final String TAG = "StackTrace";
    private Stack<String> mActivityNameStack = new Stack<>();
    private Stack<Integer> mActivityHashCodeStack = new Stack<>();

    public static ActivityStackTraceHelper getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        synchronized (ActivityStackTraceHelper.class) {
            if (INSTANCE == null) {
                INSTANCE = new ActivityStackTraceHelper();
            }
        }
        return INSTANCE;
    }

    public static String getActivityName(Activity activity) {
        String name = activity.getComponentName().getClassName();
        int dot = name.lastIndexOf(46);
        if (dot != -1) {
            String activityName = name.substring(dot + 1);
            return activityName;
        }
        return name;
    }

    public static String getActivityName(Activity activity, String[] appendParts) {
        if (appendParts == null || appendParts.length == 0) {
            return getActivityName(activity);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getActivityName(activity));
        for (String appendPart : appendParts) {
            if (!TextUtils.isEmpty(appendPart)) {
                stringBuilder.append('_');
                stringBuilder.append(appendPart);
            }
        }
        return stringBuilder.toString();
    }

    public void push(Activity activity) {
        String activityName = getActivityName(activity);
        int hashCode = activity.hashCode();
        synchronized (ActivityStackTraceHelper.class) {
            if (this.mActivityNameStack.isEmpty()) {
                this.mActivityNameStack.push(activityName);
                this.mActivityHashCodeStack.push(Integer.valueOf(hashCode));
            } else {
                Integer topHashCode = this.mActivityHashCodeStack.get(this.mActivityHashCodeStack.size() - 1);
                if (!topHashCode.equals(Integer.valueOf(hashCode))) {
                    this.mActivityNameStack.push(activityName);
                    this.mActivityHashCodeStack.push(Integer.valueOf(hashCode));
                }
            }
        }
    }

    public void updateOrPushTopName(Activity activity, String[] appendParts) {
        push(activity);
        updateTopName(activity, appendParts);
    }

    public void updateTopName(Activity activity, String[] appendParts) {
        String activityName = getActivityName(activity, appendParts);
        int hashCode = activity.hashCode();
        synchronized (ActivityStackTraceHelper.class) {
            if (!this.mActivityNameStack.isEmpty()) {
                Integer topHashCode = this.mActivityHashCodeStack.get(this.mActivityHashCodeStack.size() - 1);
                if (topHashCode.equals(Integer.valueOf(hashCode))) {
                    this.mActivityNameStack.pop();
                    this.mActivityNameStack.push(activityName);
                }
            }
        }
    }

    public void pop(Activity activity) {
        getActivityName(activity);
        int hashCode = activity.hashCode();
        synchronized (ActivityStackTraceHelper.class) {
            if (!this.mActivityNameStack.isEmpty()) {
                Integer topHashCode = this.mActivityHashCodeStack.get(this.mActivityHashCodeStack.size() - 1);
                if (topHashCode.equals(Integer.valueOf(hashCode))) {
                    this.mActivityNameStack.pop();
                    this.mActivityHashCodeStack.pop();
                }
            }
        }
    }

    private void schedulePrint() {
        HandlerThreads.post(1, new Runnable() { // from class: tv.danmaku.bili.report.ActivityStackTraceHelper.1
            @Override // java.lang.Runnable
            public void run() {
                Log.e(ActivityStackTraceHelper.TAG, ActivityStackTraceHelper.this.getStackString());
            }
        });
    }

    public String getStackString() {
        StringBuilder stringBuilder = new StringBuilder();
        synchronized (ActivityStackTraceHelper.class) {
            for (int i = 0; i < this.mActivityNameStack.size(); i++) {
                if (i != 0) {
                    stringBuilder.append('-');
                }
                stringBuilder.append(this.mActivityNameStack.elementAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public String obtainTopActivityName() {
        synchronized (ActivityStackTraceHelper.class) {
            if (!this.mActivityNameStack.isEmpty()) {
                return this.mActivityNameStack.get(this.mActivityNameStack.size() - 1);
            }
            return null;
        }
    }
}