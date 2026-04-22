package kntr.app.im.chat.ui.upgrade;

import android.app.Activity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: UpgradeAnswerDialogDisplayer.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fH'¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/ui/upgrade/UpgradeAnswerDialogDisplayer;", RoomRecommendViewModel.EMPTY_CURSOR, "showUpgradeDialog", RoomRecommendViewModel.EMPTY_CURSOR, "context", "Landroid/app/Activity;", "Lkntr/common/photonic/permission/PlatformContext;", "business", RoomRecommendViewModel.EMPTY_CURSOR, "spmid", "shareFromSpmid", "onDismiss", "Lkotlin/Function0;", "upgrade_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface UpgradeAnswerDialogDisplayer {
    void showUpgradeDialog(Activity activity, String str, String str2, String str3, Function0<Unit> function0);

    /* compiled from: UpgradeAnswerDialogDisplayer.kt */
    /* renamed from: kntr.app.im.chat.ui.upgrade.UpgradeAnswerDialogDisplayer$-CC */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void showUpgradeDialog$default(UpgradeAnswerDialogDisplayer upgradeAnswerDialogDisplayer, Activity activity, String str, String str2, String str3, Function0 function0, int i, Object obj) {
            String str4;
            Function0 function02;
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showUpgradeDialog");
            }
            if ((i & 8) == 0) {
                str4 = str3;
            } else {
                str4 = str2;
            }
            if ((i & 16) == 0) {
                function02 = function0;
            } else {
                function02 = null;
            }
            upgradeAnswerDialogDisplayer.showUpgradeDialog(activity, str, str2, str4, function02);
        }
    }

    /* compiled from: UpgradeAnswerDialogDisplayer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
    }
}