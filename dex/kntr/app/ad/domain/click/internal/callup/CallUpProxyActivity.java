package kntr.app.ad.domain.click.internal.callup;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.bilibili.lib.spy.generated.android_app_Activity;
import com.bilibili.lib.tribe.core.internal.Hooks;
import kntr.app.ad.domain.click.internal.action.results.CallUpFailureReason;
import kntr.app.ad.domain.click.internal.action.results.CallUpResult;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallUpProxyActivity.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0018H\u0014J\b\u0010\u001c\u001a\u00020\u0018H\u0014J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\n\u0010 \u001a\u0004\u0018\u00010!H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006$"}, d2 = {"Lkntr/app/ad/domain/click/internal/callup/CallUpProxyActivity;", "Landroid/app/Activity;", "<init>", "()V", "targetIntent", "Landroid/content/Intent;", "hasExecutedStop", RoomRecommendViewModel.EMPTY_CURSOR, "isFirstResume", "hasFinishedByUser", "hasSentResult", "callUpStartTime", RoomRecommendViewModel.EMPTY_CURSOR, "onCreateTime", "hasShowSystemAlertWindow", "getHasShowSystemAlertWindow", "()Z", "callbackId", RoomRecommendViewModel.EMPTY_CURSOR, "getCallbackId", "()Ljava/lang/String;", "callbackId$delegate", "Lkotlin/Lazy;", "onCreate", RoomRecommendViewModel.EMPTY_CURSOR, "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onStop", "sendResult", "result", "Lkntr/app/ad/domain/click/internal/action/results/CallUpResult;", "getCallback", "Lkntr/app/ad/domain/click/internal/callup/CallUpCallback;", "finishActivity", "Companion", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CallUpProxyActivity extends android_app_Activity {
    public static final Companion Companion = new Companion(null);
    private static final String EXTRA_CALLBACK_ID = "extra_callback_id";
    private static final String EXTRA_TARGET_INTENT = "extra_target_intent";
    private long callUpStartTime;
    private boolean hasExecutedStop;
    private boolean hasFinishedByUser;
    private boolean hasSentResult;
    private long onCreateTime;
    private Intent targetIntent;
    private boolean isFirstResume = true;
    private final Lazy callbackId$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.click.internal.callup.CallUpProxyActivity$$ExternalSyntheticLambda0
        public final Object invoke() {
            String callbackId_delegate$lambda$0;
            callbackId_delegate$lambda$0 = CallUpProxyActivity.callbackId_delegate$lambda$0(CallUpProxyActivity.this);
            return callbackId_delegate$lambda$0;
        }
    });

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* compiled from: CallUpProxyActivity.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/app/ad/domain/click/internal/callup/CallUpProxyActivity$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "EXTRA_TARGET_INTENT", RoomRecommendViewModel.EMPTY_CURSOR, "EXTRA_CALLBACK_ID", "createLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "targetIntent", "callbackId", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent createLaunchIntent(Context context, Intent targetIntent, String callbackId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(targetIntent, "targetIntent");
            Intrinsics.checkNotNullParameter(callbackId, "callbackId");
            Intent $this$createLaunchIntent_u24lambda_u240 = new Intent(context, CallUpProxyActivity.class);
            $this$createLaunchIntent_u24lambda_u240.putExtra(CallUpProxyActivity.EXTRA_TARGET_INTENT, targetIntent);
            $this$createLaunchIntent_u24lambda_u240.putExtra(CallUpProxyActivity.EXTRA_CALLBACK_ID, callbackId);
            $this$createLaunchIntent_u24lambda_u240.addFlags(268435456);
            return $this$createLaunchIntent_u24lambda_u240;
        }
    }

    private final boolean getHasShowSystemAlertWindow() {
        return (this.onCreateTime == 0 || this.callUpStartTime == 0 || this.callUpStartTime - this.onCreateTime < 1000) ? false : true;
    }

    private final String getCallbackId() {
        return (String) this.callbackId$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String callbackId_delegate$lambda$0(CallUpProxyActivity this$0) {
        String stringExtra = this$0.getIntent().getStringExtra(EXTRA_CALLBACK_ID);
        return stringExtra == null ? RoomRecommendViewModel.EMPTY_CURSOR : stringExtra;
    }

    protected void onCreate(Bundle savedInstanceState) {
        Intent intent;
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 33) {
            intent = (Intent) getIntent().getParcelableExtra(EXTRA_TARGET_INTENT, Intent.class);
        } else {
            intent = (Intent) getIntent().getParcelableExtra(EXTRA_TARGET_INTENT);
        }
        this.targetIntent = intent;
        try {
            startActivity(this.targetIntent);
            this.onCreateTime = System.currentTimeMillis();
        } catch (Exception e) {
            sendResult(new CallUpResult.Failure(new CallUpFailureReason.InternalError(e.getLocalizedMessage())));
            finishActivity();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.isFirstResume) {
            this.isFirstResume = false;
            return;
        }
        if (!this.hasExecutedStop) {
            sendResult(new CallUpResult.Failure(CallUpFailureReason.UserCancelled.INSTANCE));
        } else {
            long stayTimeMillis = System.currentTimeMillis() - this.callUpStartTime;
            CallUpCallback callback = getCallback();
            if (callback != null) {
                callback.onStayDuration(stayTimeMillis);
            }
        }
        finishActivity();
    }

    protected void onStop() {
        CallUpCallback callback;
        super.onStop();
        this.hasExecutedStop = true;
        if (!this.hasFinishedByUser) {
            this.callUpStartTime = System.currentTimeMillis();
            sendResult(CallUpResult.Success.INSTANCE);
            if (!getHasShowSystemAlertWindow() || (callback = getCallback()) == null) {
                return;
            }
            callback.onShowSystemAlert();
        }
    }

    private final void sendResult(CallUpResult result) {
        if (this.hasSentResult) {
            return;
        }
        this.hasSentResult = true;
        CallUpCallback callback = getCallback();
        if (callback != null) {
            callback.onResult(result);
        }
    }

    private final CallUpCallback getCallback() {
        return CallUpCallbacks.INSTANCE.getCallback(getCallbackId());
    }

    private final void finishActivity() {
        this.hasFinishedByUser = true;
        CallUpCallbacks.INSTANCE.removeCallback(getCallbackId());
        finish();
        overridePendingTransition(0, 0);
    }
}