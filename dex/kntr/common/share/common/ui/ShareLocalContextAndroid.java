package kntr.common.share.common.ui;

import android.app.Activity;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.share.common.ShareLocalContext;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SharePannel.android.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkntr/common/share/common/ui/ShareLocalContextAndroid;", "Lkntr/common/share/common/ShareLocalContext;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "currentCtx", "", "getCurrentCtx", "()Ljava/lang/Object;", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareLocalContextAndroid implements ShareLocalContext {
    private final Activity activity;

    public ShareLocalContextAndroid(Activity activity) {
        this.activity = activity;
        if (this.activity != null) {
            return;
        }
        KLog_androidKt.getKLog().e("ShareLocalContextAndroid", "activity is null");
    }

    @Override // kntr.common.share.common.ShareLocalContext
    public Object getCurrentCtx() {
        Activity activity = this.activity;
        return activity == null ? "" : activity;
    }
}