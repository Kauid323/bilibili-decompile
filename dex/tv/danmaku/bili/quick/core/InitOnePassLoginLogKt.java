package tv.danmaku.bili.quick.core;

import android.app.Application;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.gripper.api.PreTrigger;
import com.bilibili.lib.gson.GsonKt;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.core.OnePassLoginPhaseStatus;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: initOnePassLoginLog.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\u0016\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u000e\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"initOnePassLoginLogManager", "", "createList", FavoritesConstsKt.SPMID, "", "reason", "phaseStatusToString", "status", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseStatus;", "writeFile", "list", "Ltv/danmaku/bili/quick/core/OnePassLoginError;", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InitOnePassLoginLogKt {
    @PreTrigger(trigger = "OnCreate")
    public static final void initOnePassLoginLogManager() {
        BLog.i("initOnePassLoginLog", "");
        OnePassLoginPathLinkManager.INSTANCE.registerPhaseStatusListener(new OnePassLoginPhaseStatusListener() { // from class: tv.danmaku.bili.quick.core.InitOnePassLoginLogKt$initOnePassLoginLogManager$1
            @Override // tv.danmaku.bili.quick.core.OnePassLoginPhaseStatusListener
            public void onChange(String key, OnePassLoginPhaseStatus phaseStatus, OnePassLoginPhoneData data) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(phaseStatus, "phaseStatus");
                String spmId = !Intrinsics.areEqual(key, OnePassLoginPathLinkManagerKt.NAMELESS) ? key : null;
                if (spmId == null) {
                    spmId = "";
                }
                if (phaseStatus instanceof OnePassLoginPhaseStatus.Failed) {
                    InitOnePassLoginLogKt.createList(spmId, ((OnePassLoginPhaseStatus.Failed) phaseStatus).getReason());
                }
            }
        });
    }

    public static final void createList(String spmid, String reason) {
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        Intrinsics.checkNotNullParameter(reason, "reason");
        ArrayList list = new ArrayList();
        LinkedList linkedList = OnePassLoginPathLinkManager.INSTANCE.getPathLinkMap().get(spmid);
        if (linkedList == null) {
            linkedList = new LinkedList();
        }
        Iterator<OnePassLoginPhaseStatus> it = linkedList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            OnePassLoginPhaseStatus next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            OnePassLoginPhaseStatus i = next;
            list.add(new OnePassLoginErrorData(i instanceof OnePassLoginPhaseStatus.Failed ? phaseStatusToString(i) : "通过", reason));
        }
        String format = DateFormat.getDateTimeInstance().format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        OnePassLoginError error = new OnePassLoginError(format, list);
        writeFile(error);
    }

    private static final String phaseStatusToString(OnePassLoginPhaseStatus status) {
        if (status instanceof OnePassLoginPhaseStatus.Failed) {
            return "失败";
        }
        if (status instanceof OnePassLoginPhaseStatus.Going) {
            return "进行中";
        }
        if (status instanceof OnePassLoginPhaseStatus.Passed) {
            return "通过";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void writeFile(OnePassLoginError list) {
        Intrinsics.checkNotNullParameter(list, "list");
        Application application = BiliContext.application();
        File file = new File(application != null ? application.getCacheDir() : null, "OnePassLoginErrorManager.txt");
        try {
            BufferedWriter fos = new BufferedWriter(new FileWriter(file, true));
            fos.write(GsonKt.toJsonString(list));
            fos.newLine();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}