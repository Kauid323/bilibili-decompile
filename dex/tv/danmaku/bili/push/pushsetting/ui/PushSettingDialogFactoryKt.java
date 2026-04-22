package tv.danmaku.bili.push.pushsetting.ui;

import android.os.Bundle;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.pushsetting.model.PushCallBackInfo;
import tv.danmaku.bili.push.pushsetting.model.PushNotice;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: PushSettingDialogFactory.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a(\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b\"\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"createNewPushSettingDialog", "Ltv/danmaku/bili/push/pushsetting/ui/BasePushSettingDialog;", "pushData", "Ltv/danmaku/bili/push/pushsetting/model/PushCallBackInfo;", "showFrom", "", FavoritesConstsKt.SPMID, "inDialogManager", "", "KEY_PUSH_CARD", "KEY_TYPE_FROM", "KEY_PUSH_SPMID", "KEY_SHOW_DIALOG_MANAGER", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PushSettingDialogFactoryKt {
    public static final String KEY_PUSH_CARD = "key_push_card";
    public static final String KEY_PUSH_SPMID = "key_push_spmid";
    public static final String KEY_SHOW_DIALOG_MANAGER = "key_show_dialog_manager";
    public static final String KEY_TYPE_FROM = "key_show_from";

    /* JADX WARN: Removed duplicated region for block: B:47:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final BasePushSettingDialog createNewPushSettingDialog(PushCallBackInfo pushData, String showFrom, String spmid, boolean inDialogManager) {
        PushSettingDialogV5 pushSettingDialogV5;
        Intrinsics.checkNotNullParameter(pushData, "pushData");
        Intrinsics.checkNotNullParameter(showFrom, "showFrom");
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        boolean z = false;
        if (pushData.templateType == 1) {
            List<PushNotice> list = pushData.notices;
            if (!(list == null || list.isEmpty())) {
                pushSettingDialogV5 = new PushSettingDialogV4();
                if (pushSettingDialogV5 != null) {
                    BasePushSettingDialog $this$createNewPushSettingDialog_u24lambda_u240 = pushSettingDialogV5;
                    Bundle $this$createNewPushSettingDialog_u24lambda_u240_u240 = new Bundle();
                    $this$createNewPushSettingDialog_u24lambda_u240_u240.putParcelable(KEY_PUSH_CARD, pushData);
                    $this$createNewPushSettingDialog_u24lambda_u240_u240.putString(KEY_TYPE_FROM, showFrom);
                    $this$createNewPushSettingDialog_u24lambda_u240_u240.putString(KEY_PUSH_SPMID, spmid);
                    $this$createNewPushSettingDialog_u24lambda_u240_u240.putBoolean(KEY_SHOW_DIALOG_MANAGER, inDialogManager);
                    $this$createNewPushSettingDialog_u24lambda_u240.setArguments($this$createNewPushSettingDialog_u24lambda_u240_u240);
                    return $this$createNewPushSettingDialog_u24lambda_u240;
                }
                return null;
            }
        }
        if (pushData.templateType == 1) {
            List<String> list2 = pushData.contents;
            if (!(list2 == null || list2.isEmpty())) {
                pushSettingDialogV5 = new PushSettingDialogV3();
                if (pushSettingDialogV5 != null) {
                }
            }
        }
        if (pushData.templateType == 2) {
            List<PushNotice> list3 = pushData.notices;
            if (!(list3 == null || list3.isEmpty())) {
                pushSettingDialogV5 = new PushSettingDialogV6();
                if (pushSettingDialogV5 != null) {
                }
            }
        }
        if (pushData.templateType == 2) {
            List<String> list4 = pushData.contents;
            if (list4 == null || list4.isEmpty()) {
                z = true;
            }
            if (!z) {
                pushSettingDialogV5 = new PushSettingDialogV5();
                if (pushSettingDialogV5 != null) {
                }
            }
        }
        pushSettingDialogV5 = null;
        if (pushSettingDialogV5 != null) {
        }
    }
}