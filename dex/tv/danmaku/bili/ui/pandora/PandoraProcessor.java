package tv.danmaku.bili.ui.pandora;

import android.content.Context;
import android.text.TextUtils;
import bolts.Continuation;
import bolts.Task;
import com.alibaba.fastjson.JSON;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.okretro.BiliApiDataCallback;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.loginv2.LoginAnswerDialogHelper;
import tv.danmaku.bili.ui.main.usergrow.UserGrowManager;
import tv.danmaku.bili.ui.main.usergrow.UserGrowSpHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PandoraProcessor.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J \u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u0004\u0018\u00010\tJ\"\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/pandora/PandoraProcessor;", "", "<init>", "()V", "TAG", "", "BUSINESS_ANSWER", "BUSINESS_GROW", "dataPandoraBean", "Ltv/danmaku/bili/ui/pandora/PandoraBean;", "init", "", "context", "Landroid/content/Context;", "showAnswerDialog", "data", "infoRequested", "", "getPandoraBean", "toAnswerDialogActivity", "registerAccountListener", "fetchDialogInfo", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PandoraProcessor {
    public static final String BUSINESS_ANSWER = "ANSWER";
    public static final String BUSINESS_GROW = "H5";
    private static final String TAG = "SignInDialogProcessor";
    private static PandoraBean dataPandoraBean;
    public static final PandoraProcessor INSTANCE = new PandoraProcessor();
    public static final int $stable = 8;

    /* compiled from: PandoraProcessor.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Topic.values().length];
            try {
                iArr[Topic.SIGN_IN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Topic.SIGN_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PandoraProcessor() {
    }

    @JvmStatic
    public static final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!BiliContext.isMainProcess()) {
            return;
        }
        INSTANCE.registerAccountListener(context);
    }

    public final void showAnswerDialog(final Context context, final PandoraBean data, final boolean infoRequested) {
        Intrinsics.checkNotNullParameter(context, "context");
        BLog.d(TAG, "showAnswerDialog = " + LoginAnswerDialogHelper.INSTANCE.needShowAnswerDialog(context));
        if (LoginAnswerDialogHelper.INSTANCE.needShowAnswerDialog(context)) {
            int $this$showAnswerDialog_u24lambda_u240 = BiliAccountInfo.Companion.get().getAnswerStatus();
            BLog.d(TAG, "answer status = " + $this$showAnswerDialog_u24lambda_u240);
            switch ($this$showAnswerDialog_u24lambda_u240) {
                case 1:
                case 2:
                    MainDialogManager.DialogManagerInfo managerInfo = new MainDialogManager.DialogManagerInfo("answer_after_login", new MainDialogManager.IDialogInterface() { // from class: tv.danmaku.bili.ui.pandora.PandoraProcessor$$ExternalSyntheticLambda1
                        public final void onShow() {
                            PandoraProcessor.showAnswerDialog$lambda$0$0(context, data, infoRequested);
                        }
                    }, 2051);
                    MainDialogManager.addDialog(managerInfo, context);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAnswerDialog$lambda$0$0(Context $context, PandoraBean $data, boolean $infoRequested) {
        INSTANCE.toAnswerDialogActivity($context, $data, $infoRequested);
    }

    public final PandoraBean getPandoraBean() {
        return dataPandoraBean;
    }

    private final void toAnswerDialogActivity(final Context context, final PandoraBean data, final boolean infoRequested) {
        RouteRequest request = new RouteRequest.Builder("activity://main/answer-dialog/transfer").extras(new Function1() { // from class: tv.danmaku.bili.ui.pandora.PandoraProcessor$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit answerDialogActivity$lambda$0;
                answerDialogActivity$lambda$0 = PandoraProcessor.toAnswerDialogActivity$lambda$0(context, infoRequested, data, (MutableBundleLike) obj);
                return answerDialogActivity$lambda$0;
            }
        }).build();
        BLRouter.routeTo(request, context);
        BLog.d(TAG, "activity://main/answer-dialog/transfer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toAnswerDialogActivity$lambda$0(Context $context, boolean $infoRequested, PandoraBean $data, MutableBundleLike $this$extras) {
        String buttonCancel;
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        $this$extras.put("from", LoginAnswerDialogHelper.INSTANCE.getAnswerDialogFrom($context));
        $this$extras.put("spmid", LoginAnswerDialogHelper.INSTANCE.getAnswerDialogSpmid($context));
        $this$extras.put("info_requested", String.valueOf($infoRequested));
        String str = "";
        $this$extras.put("dialog_link", ($data == null || (r1 = $data.getUrl()) == null) ? "" : "");
        $this$extras.put("dialog_desc", ($data == null || (r1 = $data.getDesc()) == null) ? "" : "");
        $this$extras.put("dialog_title", ($data == null || (r1 = $data.getTitle()) == null) ? "" : "");
        $this$extras.put("dialog_buttonConfirm", ($data == null || (r1 = $data.getButtonConfirm()) == null) ? "" : "");
        if ($data != null && (buttonCancel = $data.getButtonCancel()) != null) {
            str = buttonCancel;
        }
        $this$extras.put("dialog_buttonCancel", str);
        String jSONString = JSON.toJSONString($data != null ? $data.getGuideRewards() : null);
        Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(...)");
        $this$extras.put("dialog_guideRewards", jSONString);
        $this$extras.put("login_experiment", String.valueOf(LoginAnswerDialogHelper.INSTANCE.getAnswerDialogLoginExperiment($context)));
        $this$extras.put("login_experiment_value", LoginAnswerDialogHelper.INSTANCE.getAnswerDialogLoginExperimentValue($context));
        return Unit.INSTANCE;
    }

    private final void registerAccountListener(final Context context) {
        BiliAccounts.get(context).subscribe(new PassportObserver() { // from class: tv.danmaku.bili.ui.pandora.PandoraProcessor$$ExternalSyntheticLambda4
            public final void onChange(Topic topic) {
                PandoraProcessor.registerAccountListener$lambda$0(context, topic);
            }
        }, new Topic[]{Topic.SIGN_IN, Topic.SIGN_OUT});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerAccountListener$lambda$0(final Context $context, Topic topic) {
        switch (topic == null ? -1 : WhenMappings.$EnumSwitchMapping$0[topic.ordinal()]) {
            case 1:
                if (UserGrowSpHelper.Companion.isDialogShowing($context)) {
                    return;
                }
                Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.pandora.PandoraProcessor$$ExternalSyntheticLambda2
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        Unit registerAccountListener$lambda$0$0;
                        registerAccountListener$lambda$0$0 = PandoraProcessor.registerAccountListener$lambda$0$0();
                        return registerAccountListener$lambda$0$0;
                    }
                }).continueWith(new Continuation() { // from class: tv.danmaku.bili.ui.pandora.PandoraProcessor$$ExternalSyntheticLambda3
                    public final Object then(Task task) {
                        Unit registerAccountListener$lambda$0$1;
                        registerAccountListener$lambda$0$1 = PandoraProcessor.registerAccountListener$lambda$0$1($context, task);
                        return registerAccountListener$lambda$0$1;
                    }
                }, Task.UI_THREAD_EXECUTOR);
                return;
            case 2:
                UserGrowSpHelper.Companion.setNeedShowForLogin($context, false, "");
                UserGrowSpHelper.Companion.setDialogShowing($context, false);
                LoginAnswerDialogHelper.setNeedShowAnswerDialog$default(LoginAnswerDialogHelper.INSTANCE, $context, false, (String) null, (String) null, 12, (Object) null);
                LoginAnswerDialogHelper.INSTANCE.setAnswerDialogLoginExperimentParam($context, false, "");
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerAccountListener$lambda$0$0() {
        try {
            BLog.d(TAG, "showAnswerDialog LoginCountDownLaunch = " + LoginAnswerDialogHelper.INSTANCE.getLoginCountDownLaunch());
            CountDownLatch loginCountDownLaunch = LoginAnswerDialogHelper.INSTANCE.getLoginCountDownLaunch();
            if (loginCountDownLaunch != null) {
                loginCountDownLaunch.await(PlayerToastConfig.DURATION_5, TimeUnit.MILLISECONDS);
            }
        } catch (Exception e) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerAccountListener$lambda$0$1(Context $context, Task it) {
        INSTANCE.fetchDialogInfo($context);
        return Unit.INSTANCE;
    }

    public final void fetchDialogInfo(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!BiliAccounts.get(context).isLogin()) {
            return;
        }
        PandoraApiHelper.Companion.fetchDialogInfo(context, LoginAnswerDialogHelper.INSTANCE.getAnswerDialogFrom(context), LoginAnswerDialogHelper.INSTANCE.getAnswerDialogSpmid(context), new BiliApiDataCallback<PandoraBean>() { // from class: tv.danmaku.bili.ui.pandora.PandoraProcessor$fetchDialogInfo$1
            public void onDataSuccess(PandoraBean data) {
                BLog.d("SignInDialogProcessor", "PandoraApiResult = " + data);
                if (data == null) {
                    return;
                }
                if (!TextUtils.isEmpty(data.getUrl()) && Intrinsics.areEqual(PandoraProcessor.BUSINESS_GROW, data.getBusiness())) {
                    UserGrowManager userGrowManager = UserGrowManager.INSTANCE;
                    Context context2 = context;
                    String url = data.getUrl();
                    Intrinsics.checkNotNull(url);
                    userGrowManager.showUserGrowDialog(context2, url);
                } else if (Intrinsics.areEqual(PandoraProcessor.BUSINESS_ANSWER, data.getBusiness())) {
                    PandoraProcessor pandoraProcessor = PandoraProcessor.INSTANCE;
                    PandoraProcessor.dataPandoraBean = data;
                    if (LoginAnswerDialogHelper.INSTANCE.getAnswerDialogLoginExperiment(context) && LoginAnswerDialogHelper.INSTANCE.answerDialogLoginExperimentValueA1(context)) {
                        BLog.i("SignInDialogProcessor", "answer dialog experiment " + LoginAnswerDialogHelper.INSTANCE.getAnswerDialogLoginExperimentValue(context));
                        return;
                    }
                    PandoraProcessor.INSTANCE.showAnswerDialog(context, data, true);
                }
            }

            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
            }
        });
    }
}