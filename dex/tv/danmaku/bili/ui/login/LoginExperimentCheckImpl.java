package tv.danmaku.bili.ui.login;

import android.content.Context;
import com.bilibili.homepage.LoginExperimentCheck;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.pandora.PandoraProcessor;

/* compiled from: LoginExperimentCheckImpl.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/login/LoginExperimentCheckImpl;", "Lcom/bilibili/homepage/LoginExperimentCheck;", "<init>", "()V", "onInterestDialogDismiss", "", "context", "Landroid/content/Context;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginExperimentCheckImpl implements LoginExperimentCheck {
    public static final int $stable = 0;

    public void onInterestDialogDismiss(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (PandoraProcessor.INSTANCE.getPandoraBean() != null) {
            PandoraProcessor.INSTANCE.showAnswerDialog(context, PandoraProcessor.INSTANCE.getPandoraBean(), true);
        } else {
            PandoraProcessor.INSTANCE.fetchDialogInfo(context);
        }
    }
}