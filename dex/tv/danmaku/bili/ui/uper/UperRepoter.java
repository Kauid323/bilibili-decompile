package tv.danmaku.bili.ui.uper;

import android.content.Context;
import bolts.Task;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.infoeyes.InfoEyesManager;
import java.util.concurrent.Callable;

public class UperRepoter {
    private static final String ODS_APP_GENERAL_EVENT = "000225";

    public static void mythContributeClick(final Context context) {
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.uper.UperRepoter$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UperRepoter.lambda$mythContributeClick$0(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void lambda$mythContributeClick$0(Context context) throws Exception {
        InfoEyesManager.getInstance().report2(false, "000225", new String[]{"myth_contribute_click", "click", BiliAccounts.get(context).mid() + ""});
        return null;
    }

    public static void mythContributeCenterButtonClick(final Context context) {
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.uper.UperRepoter$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UperRepoter.lambda$mythContributeCenterButtonClick$1(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void lambda$mythContributeCenterButtonClick$1(Context context) throws Exception {
        InfoEyesManager.getInstance().report2(false, "000225", new String[]{"uper_center_entrance_click", "click", BiliAccounts.get(context).mid() + ""});
        return null;
    }

    public static void ugcCenterCourseClick(final Context context) {
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.uper.UperRepoter$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UperRepoter.lambda$ugcCenterCourseClick$2(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void lambda$ugcCenterCourseClick$2(Context context) throws Exception {
        InfoEyesManager.getInstance().report2(false, "000225", new String[]{"ugc_center_course_click", "click", BiliAccounts.get(context).mid() + ""});
        return null;
    }

    public static void ugcCenterHotClick(final Context context) {
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.uper.UperRepoter$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UperRepoter.lambda$ugcCenterHotClick$3(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void lambda$ugcCenterHotClick$3(Context context) throws Exception {
        InfoEyesManager.getInstance().report2(false, "000225", new String[]{"ugc_center_hot_click", "click", BiliAccounts.get(context).mid() + ""});
        return null;
    }
}