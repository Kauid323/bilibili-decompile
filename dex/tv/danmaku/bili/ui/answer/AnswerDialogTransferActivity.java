package tv.danmaku.bili.ui.answer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.droid.Target28Compat;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import com.bilibili.moduleservice.main.AnswerService;
import com.bilibili.studio.uperbase.router.wrapper.BundleWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.core.LoginSceneProcessor;
import tv.danmaku.bili.quick.ui.LoginQuickActivityV2;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.loginv2.LoginAnswerDialogHelper;
import tv.danmaku.bili.ui.loginv2.LoginOriginalActivityV2;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;

/* compiled from: AnswerDialogTransferActivity.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/answer/AnswerDialogTransferActivity;", "Lcom/bilibili/lib/ui/BaseAppCompatActivity;", "<init>", "()V", LoginSceneProcessor.BIZ_KEY, "", FavoritesConstsKt.SPMID, "infoRequested", "", LoginQuickActivityV2.INTENT_KEY_LOGIN_EXPERIMENT, "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AnswerDialogTransferActivity extends BaseAppCompatActivity {
    public static final String FROM_QUICK = "quick_login";
    public static final String FROM_SMS_DIALOG = "text_msg";
    private boolean infoRequested;
    private boolean loginExperiment;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private String business = "";
    private String spmid = "";

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* compiled from: AnswerDialogTransferActivity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/answer/AnswerDialogTransferActivity$Companion;", "", "<init>", "()V", "FROM_SMS_DIALOG", "", "FROM_QUICK", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        Target28Compat.setScreenPortraitWithoutAndroidO((Activity) this);
        super.onCreate(savedInstanceState);
        this.business = BundleWrapper.Companion.optString(getIntent(), "from", FROM_SMS_DIALOG);
        this.spmid = BundleWrapper.Companion.optString(getIntent(), FavoritesConstsKt.SPMID, "");
        this.infoRequested = BundleWrapper.Companion.optBoolean(getIntent(), "info_requested", false);
        this.loginExperiment = BundleWrapper.Companion.optBoolean(getIntent(), LoginOriginalActivityV2.KEY_LOGIN_EXPERIMENT, false);
        View view = new View((Context) this);
        setContentView(view);
        view.post(new Runnable() { // from class: tv.danmaku.bili.ui.answer.AnswerDialogTransferActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AnswerDialogTransferActivity.onCreate$lambda$0(AnswerDialogTransferActivity.this);
            }
        });
        LoginAnswerDialogHelper.INSTANCE.setAnswerDialogLoginExperimentParam((Context) this, false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(final AnswerDialogTransferActivity this$0) {
        int answerStatus = BiliAccountInfo.Companion.get().getAnswerStatus();
        switch (answerStatus) {
            case 1:
            case 2:
                AnswerService answerService = (AnswerService) BLRouter.INSTANCE.getServices(AnswerService.class).get(MineReporter.MINE_ICON_TYPE_DEFAULT);
                Function0 dismissCallback = new Function0() { // from class: tv.danmaku.bili.ui.answer.AnswerDialogTransferActivity$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit onCreate$lambda$0$0;
                        onCreate$lambda$0$0 = AnswerDialogTransferActivity.onCreate$lambda$0$0(AnswerDialogTransferActivity.this);
                        return onCreate$lambda$0$0;
                    }
                };
                if (!this$0.infoRequested) {
                    if (answerService != null) {
                        answerService.showAnswerGuide((Context) this$0, this$0.business, this$0.spmid, 0, dismissCallback);
                        return;
                    }
                    return;
                } else if (answerService != null) {
                    Context context = (Context) this$0;
                    String str = this$0.business;
                    Intent intent = this$0.getIntent();
                    answerService.showAnswerGuide(context, str, intent != null ? intent.getExtras() : null, 0, dismissCallback);
                    return;
                } else {
                    return;
                }
            default:
                this$0.finish();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0(AnswerDialogTransferActivity this$0) {
        this$0.finish();
        return Unit.INSTANCE;
    }

    protected void onDestroy() {
        super.onDestroy();
        MainDialogManager.showNextDialog("answer_after_login", false);
    }
}