package tv.danmaku.bili.ui.main2.userprotocol;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import bili.resource.homepage.R;
import bolts.Task;
import com.bilibili.base.util.DelayTaskController;
import com.bilibili.homepage.UserProtocolDialogListener;
import com.bilibili.lib.crashreport.CrashReporter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;
import tv.danmaku.bili.ui.video.main.UtilKt;

/* compiled from: UserProtocolBlockDialogEntrepot.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010 \u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0006J\u000e\u0010(\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0006J\u000e\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u0013J\u000e\u0010.\u001a\u00020&2\u0006\u0010*\u001a\u00020+J\u0006\u0010/\u001a\u00020\bJ\u0006\u00100\u001a\u00020\bJ\u0006\u00101\u001a\u00020\bJ\n\u00102\u001a\u00020&*\u000203J\u0006\u00104\u001a\u00020&J\b\u00105\u001a\u00020&H\u0002J\u0006\u00106\u001a\u00020&R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u00067"}, d2 = {"Ltv/danmaku/bili/ui/main2/userprotocol/UserProtocolBlockDialogEntrepot;", "", "<init>", "()V", "mListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bilibili/homepage/UserProtocolDialogListener;", "showBackground", "", "getShowBackground", "()Z", "setShowBackground", "(Z)V", "mFirstStep", "getMFirstStep", "setMFirstStep", "activityRef", "", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "getActivityRef", "()Ljava/util/List;", "from", "", "getFrom", "()Ljava/lang/String;", "setFrom", "(Ljava/lang/String;)V", "getTvContent", "context", "Landroid/content/Context;", "getTvCancel", "getTvConfirm", "getSpaceViewVisible", "", "getDefaultLinkString", "Landroid/text/SpannableStringBuilder;", "addUserProtocolDialogListener", "", "listener", "removeUserProtocolDialogListener", "agree", "dialog", "Ltv/danmaku/bili/ui/main2/userprotocol/UserProtocolBlockDialog;", "mockAgree", AudioIntentHelper.FROM_ACTIVITY, "disagree", "hitVisitorMod", "hitFakePegasus", "hitMainActivityV2", "dismissSafely", "Landroidx/appcompat/app/AppCompatDialog;", "reset", "exit", "triggerInit", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UserProtocolBlockDialogEntrepot {
    public static final int $stable;
    private static boolean showBackground;
    public static final UserProtocolBlockDialogEntrepot INSTANCE = new UserProtocolBlockDialogEntrepot();
    private static final CopyOnWriteArrayList<UserProtocolDialogListener> mListeners = new CopyOnWriteArrayList<>();
    private static boolean mFirstStep = true;
    private static final List<WeakReference<Activity>> activityRef = new ArrayList();
    private static String from = "";

    private UserProtocolBlockDialogEntrepot() {
    }

    static {
        UserProtocolExperiment.INSTANCE.experiment();
        $stable = 8;
    }

    public final boolean getShowBackground() {
        return showBackground;
    }

    public final void setShowBackground(boolean z) {
        showBackground = z;
    }

    public final boolean getMFirstStep() {
        return mFirstStep;
    }

    public final void setMFirstStep(boolean z) {
        mFirstStep = z;
    }

    public final List<WeakReference<Activity>> getActivityRef() {
        return activityRef;
    }

    public final String getFrom() {
        return from;
    }

    public final void setFrom(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        from = str;
    }

    public final String getTvContent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (mFirstStep) {
            String string = context.getString(R.string.homepage_global_string_48);
            Intrinsics.checkNotNull(string);
            return string;
        }
        String string2 = context.getString(R.string.homepage_global_string_65);
        Intrinsics.checkNotNull(string2);
        return string2;
    }

    public final String getTvCancel(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (mFirstStep) {
            String string = context.getString(bili.resource.common.R.string.common_global_string_148);
            Intrinsics.checkNotNull(string);
            return string;
        } else if (hitVisitorMod() && hitFakePegasus()) {
            String string2 = context.getString(R.string.homepage_global_string_56);
            Intrinsics.checkNotNull(string2);
            return string2;
        } else {
            String string3 = context.getString(R.string.homepage_global_string_27);
            Intrinsics.checkNotNull(string3);
            return string3;
        }
    }

    public final String getTvConfirm(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (mFirstStep) {
            if (UserProtocolExperiment.hitVipMode()) {
                String string = context.getString(R.string.homepage_global_string_72);
                Intrinsics.checkNotNull(string);
                return string;
            }
            String string2 = context.getString(bili.resource.common.R.string.common_global_string_230);
            Intrinsics.checkNotNull(string2);
            return string2;
        } else if (UserProtocolExperiment.hitVipMode()) {
            String string3 = context.getString(R.string.homepage_global_string_72);
            Intrinsics.checkNotNull(string3);
            return string3;
        } else {
            String string4 = context.getString(R.string.homepage_global_string_35);
            Intrinsics.checkNotNull(string4);
            return string4;
        }
    }

    public final int getSpaceViewVisible() {
        if (mFirstStep) {
            return 8;
        }
        return 0;
    }

    public final SpannableStringBuilder getDefaultLinkString(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String defaultContent = context.getString(R.string.homepage_global_string_45);
        Intrinsics.checkNotNullExpressionValue(defaultContent, "getString(...)");
        String defaultPolicy = context.getString(R.string.homepage_global_string_62);
        Intrinsics.checkNotNullExpressionValue(defaultPolicy, "getString(...)");
        String defaultUser = context.getString(R.string.homepage_global_string_17);
        Intrinsics.checkNotNullExpressionValue(defaultUser, "getString(...)");
        SpannableStringBuilder ss = new SpannableStringBuilder(defaultContent);
        int linkColor = ContextCompat.getColor(context, com.bilibili.lib.ui.R.color.text_blue_kit);
        int userStartIndex = StringsKt.indexOf$default(defaultContent, defaultUser, 0, false, 6, (Object) null);
        if (userStartIndex != -1) {
            ss.setSpan(new ForegroundColorSpan(linkColor), userStartIndex, defaultUser.length() + userStartIndex, 33);
            ss.setSpan(new ClickableSpan() { // from class: tv.danmaku.bili.ui.main2.userprotocol.UserProtocolBlockDialogEntrepot$getDefaultLinkString$1
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.checkNotNullParameter(widget, "widget");
                    UserProtocolHelper.openLocalBrowser(context, UserProtocolHelper.H5Urls.getUserProtocolUrl());
                    UserProtocolHelper.reportUserProtocolDialogUrlClick("app.main-agreement-pop.urlclick.0.click", "1", UserProtocolBlockDialogEntrepot.INSTANCE.getMFirstStep() ? 1 : 2, true);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    Intrinsics.checkNotNullParameter(ds, "ds");
                    ds.setUnderlineText(false);
                    ds.bgColor = 0;
                }
            }, userStartIndex, defaultUser.length() + userStartIndex, 33);
        }
        int policyStartIndex = StringsKt.indexOf$default(defaultContent, defaultPolicy, 0, false, 6, (Object) null);
        if (policyStartIndex != -1) {
            ss.setSpan(new ForegroundColorSpan(linkColor), policyStartIndex, defaultPolicy.length() + policyStartIndex, 33);
            ss.setSpan(new ClickableSpan() { // from class: tv.danmaku.bili.ui.main2.userprotocol.UserProtocolBlockDialogEntrepot$getDefaultLinkString$2
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.checkNotNullParameter(widget, "widget");
                    UserProtocolHelper.openLocalBrowser(context, UserProtocolHelper.H5Urls.getPrivacyPolicyUrl());
                    UserProtocolHelper.reportUserProtocolDialogUrlClick("app.main-agreement-pop.urlclick.0.click", "2", UserProtocolBlockDialogEntrepot.INSTANCE.getMFirstStep() ? 1 : 2, true);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    Intrinsics.checkNotNullParameter(ds, "ds");
                    ds.setUnderlineText(false);
                    ds.bgColor = 0;
                }
            }, policyStartIndex, defaultPolicy.length() + policyStartIndex, 33);
        }
        return ss;
    }

    public final void addUserProtocolDialogListener(UserProtocolDialogListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        mListeners.add(listener);
    }

    public final void removeUserProtocolDialogListener(UserProtocolDialogListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        mListeners.remove(listener);
    }

    public final void agree(UserProtocolBlockDialog dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dismissSafely(dialog);
        final Activity it = dialog.getOwnerActivity();
        if (it != null) {
            DelayTaskController.triggerExecute(it);
            UserProtocolHelper.setUserAgreeVersion(it, -1);
            Iterable $this$forEach$iv = mListeners;
            for (Object element$iv : $this$forEach$iv) {
                ((UserProtocolDialogListener) element$iv).onAgree();
            }
            UserProtocolHelper.reportConfirmClick(mFirstStep ? 1 : 2, 1);
            UtilKt.deepLinkTrack("UserBlockDialog click agree, mFirstStep = " + mFirstStep + " current seed is " + UserProtocolExperiment.getSeed());
            Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.main2.userprotocol.UserProtocolBlockDialogEntrepot$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Unit agree$lambda$0$1;
                    agree$lambda$0$1 = UserProtocolBlockDialogEntrepot.agree$lambda$0$1(it);
                    return agree$lambda$0$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit agree$lambda$0$1(Activity $it) {
        UserProtocolHelper.delayReportIfNeed($it);
        return Unit.INSTANCE;
    }

    public final void mockAgree(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        DelayTaskController.triggerExecute(activity);
        UserProtocolHelper.setUserAgreeVersion(activity, -1);
        Iterable $this$forEach$iv = mListeners;
        for (Object element$iv : $this$forEach$iv) {
            UserProtocolDialogListener it = (UserProtocolDialogListener) element$iv;
            it.onAgree();
        }
        UserProtocolHelper.reportConfirmClick(mFirstStep ? 1 : 2, 1);
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.main2.userprotocol.UserProtocolBlockDialogEntrepot$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit mockAgree$lambda$1;
                mockAgree$lambda$1 = UserProtocolBlockDialogEntrepot.mockAgree$lambda$1(activity);
                return mockAgree$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mockAgree$lambda$1(Activity $activity) {
        UserProtocolHelper.delayReportIfNeed($activity);
        return Unit.INSTANCE;
    }

    public final void disagree(UserProtocolBlockDialog dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (mFirstStep) {
            Iterable $this$forEach$iv = mListeners;
            for (Object element$iv : $this$forEach$iv) {
                UserProtocolDialogListener it = (UserProtocolDialogListener) element$iv;
                it.onCancel(mFirstStep);
            }
            mFirstStep = false;
            UserProtocolHelper.reportUserProtocolDialogClick("app.main-agreement-pop.no.0.click", true);
            UserProtocolHelper.reportUserProtocolDialogShow("app.main-secondagreement-pop.secpv.0.show", true);
            if (INSTANCE.hitVisitorMod()) {
                INSTANCE.dismissSafely(dialog);
                return;
            }
            TextView mTvContent = dialog.getMTvContent();
            if (mTvContent != null) {
                mTvContent.scrollTo(0, 0);
            }
            TextView mTvContent2 = dialog.getMTvContent();
            if (mTvContent2 != null) {
                UserProtocolBlockDialogEntrepot userProtocolBlockDialogEntrepot = INSTANCE;
                Context context = dialog.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                mTvContent2.setText(userProtocolBlockDialogEntrepot.getTvContent(context));
            }
            TextView mTvConfirm = dialog.getMTvConfirm();
            if (mTvConfirm != null) {
                UserProtocolBlockDialogEntrepot userProtocolBlockDialogEntrepot2 = INSTANCE;
                Context context2 = dialog.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                mTvConfirm.setText(userProtocolBlockDialogEntrepot2.getTvConfirm(context2));
            }
            TextView mTvCancel = dialog.getMTvCancel();
            if (mTvCancel != null) {
                UserProtocolBlockDialogEntrepot userProtocolBlockDialogEntrepot3 = INSTANCE;
                Context context3 = dialog.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                mTvCancel.setText(userProtocolBlockDialogEntrepot3.getTvCancel(context3));
            }
            View mSpaceView = dialog.getMSpaceView();
            if (mSpaceView != null) {
                mSpaceView.setVisibility(INSTANCE.getSpaceViewVisible());
                return;
            }
            return;
        }
        Iterable $this$forEach$iv2 = mListeners;
        for (Object element$iv2 : $this$forEach$iv2) {
            UserProtocolDialogListener it2 = (UserProtocolDialogListener) element$iv2;
            it2.onCancel(mFirstStep);
        }
        INSTANCE.dismissSafely(dialog);
        UserProtocolHelper.reportUserProtocolDialogClick("app.main-secondagreement-pop.quit.0.click", true);
        if (!INSTANCE.hitVisitorMod() || !INSTANCE.hitFakePegasus()) {
            INSTANCE.exit();
            INSTANCE.reset();
        }
    }

    public final boolean hitVisitorMod() {
        return UserProtocolExperiment.hitVisitMode();
    }

    public final boolean hitFakePegasus() {
        if (Intrinsics.areEqual(from, "FAKE_MAIN_ACTIVITY") || Intrinsics.areEqual(from, "FAKE_PEGASUS") || Intrinsics.areEqual(from, "FAKE_VIDEO_DETAIL")) {
            return true;
        }
        return false;
    }

    public final boolean hitMainActivityV2() {
        if (Intrinsics.areEqual(from, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH)) {
            return true;
        }
        return false;
    }

    public final void dismissSafely(AppCompatDialog $this$dismissSafely) {
        Intrinsics.checkNotNullParameter($this$dismissSafely, "<this>");
        if ($this$dismissSafely.getOwnerActivity() != null) {
            Activity ownerActivity = $this$dismissSafely.getOwnerActivity();
            Intrinsics.checkNotNull(ownerActivity);
            if (ownerActivity.isFinishing()) {
                return;
            }
            try {
                $this$dismissSafely.dismiss();
            } catch (Exception e) {
                CrashReporter.INSTANCE.postCaughtException(e);
            }
        }
    }

    public final void reset() {
        mFirstStep = true;
        activityRef.clear();
        mListeners.clear();
    }

    private final void exit() {
        Iterable $this$forEach$iv = activityRef;
        for (Object element$iv : $this$forEach$iv) {
            WeakReference it = (WeakReference) element$iv;
            Activity activity = (Activity) it.get();
            if (activity != null && !activity.isFinishing()) {
                activity.finishAndRemoveTask();
            }
        }
    }

    public final void triggerInit() {
    }
}