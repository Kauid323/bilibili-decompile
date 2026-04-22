package tv.danmaku.bili.ui.freedata.tracer;

import com.bapis.bilibili.app.wall.v1.RuleInfo;
import com.bapis.bilibili.app.wall.v1.RulesInfo;
import com.bapis.bilibili.app.wall.v1.RulesReply;
import com.bilibili.fd_service.api.beans.RulesInfoData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: FreeDataRuleDelegateImpl.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0007H\u0002\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002\u001a\b\u0010\u000b\u001a\u00020\u0006H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"ISP_FLAG_CU", "", "ISP_FLAG_CM", "ISP_FLAG_CT", "TAG", "toRulesInfoData", "Lcom/bilibili/fd_service/api/beans/RulesInfoData;", "Lcom/bapis/bilibili/app/wall/v1/RulesReply;", "toRuleInfoBean", "Lcom/bilibili/fd_service/api/beans/RulesInfoData$RulesInfo$InfoItem$RulesInfoBean;", "Lcom/bapis/bilibili/app/wall/v1/RuleInfo;", "newRulesInfo", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FreeDataRuleDelegateImplKt {
    private static final String ISP_FLAG_CM = "cm";
    private static final String ISP_FLAG_CT = "ct";
    private static final String ISP_FLAG_CU = "cu";
    private static final String TAG = "FreeDataDelegateImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final RulesInfoData toRulesInfoData(RulesReply $this$toRulesInfoData) {
        Iterable rulesInfoList;
        List list;
        Iterable rulesInfoList2;
        List list2;
        Iterable rulesInfoList3;
        List list3;
        try {
            RulesInfoData result = newRulesInfo();
            RulesInfo rulesInfoCu = $this$toRulesInfoData.getRulesInfoOrThrow(ISP_FLAG_CU);
            RulesInfo rulesInfoCt = $this$toRulesInfoData.getRulesInfoOrThrow(ISP_FLAG_CT);
            RulesInfo rulesInfoCm = $this$toRulesInfoData.getRulesInfoOrThrow(ISP_FLAG_CM);
            RulesInfoData.RulesInfo $this$toRulesInfoData_u24lambda_u240 = result.rulesInfo;
            if ($this$toRulesInfoData_u24lambda_u240 != null) {
                if (rulesInfoCu != null && (rulesInfoList3 = rulesInfoCu.getRulesInfoList()) != null) {
                    Iterable $this$forEach$iv = rulesInfoList3;
                    for (Object element$iv : $this$forEach$iv) {
                        RuleInfo it = (RuleInfo) element$iv;
                        RulesInfoData.RulesInfo.InfoItem infoItem = $this$toRulesInfoData_u24lambda_u240.cu;
                        if (infoItem != null && (list3 = infoItem.rulesInfo) != null) {
                            Intrinsics.checkNotNull(it);
                            list3.add(toRuleInfoBean(it));
                        }
                    }
                }
                if (rulesInfoCm != null && (rulesInfoList2 = rulesInfoCm.getRulesInfoList()) != null) {
                    Iterable $this$forEach$iv2 = rulesInfoList2;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        RuleInfo it2 = (RuleInfo) element$iv2;
                        RulesInfoData.RulesInfo.InfoItem infoItem2 = $this$toRulesInfoData_u24lambda_u240.cm;
                        if (infoItem2 != null && (list2 = infoItem2.rulesInfo) != null) {
                            Intrinsics.checkNotNull(it2);
                            list2.add(toRuleInfoBean(it2));
                        }
                    }
                }
                if (rulesInfoCt != null && (rulesInfoList = rulesInfoCt.getRulesInfoList()) != null) {
                    Iterable $this$forEach$iv3 = rulesInfoList;
                    for (Object element$iv3 : $this$forEach$iv3) {
                        RuleInfo it3 = (RuleInfo) element$iv3;
                        RulesInfoData.RulesInfo.InfoItem infoItem3 = $this$toRulesInfoData_u24lambda_u240.ct;
                        if (infoItem3 != null && (list = infoItem3.rulesInfo) != null) {
                            Intrinsics.checkNotNull(it3);
                            list.add(toRuleInfoBean(it3));
                        }
                    }
                }
            }
            return result;
        } catch (Exception e) {
            BLog.e(TAG, e);
            return null;
        }
    }

    private static final RulesInfoData.RulesInfo.InfoItem.RulesInfoBean toRuleInfoBean(RuleInfo $this$toRuleInfoBean) {
        RulesInfoData.RulesInfo.InfoItem.RulesInfoBean result = new RulesInfoData.RulesInfo.InfoItem.RulesInfoBean();
        result.a = $this$toRuleInfoBean.getA();
        result.m = $this$toRuleInfoBean.getM();
        result.p = $this$toRuleInfoBean.getP();
        result.tf = $this$toRuleInfoBean.getTf();
        return result;
    }

    private static final RulesInfoData newRulesInfo() {
        RulesInfoData result = new RulesInfoData();
        RulesInfoData.RulesInfo $this$newRulesInfo_u24lambda_u240 = new RulesInfoData.RulesInfo();
        $this$newRulesInfo_u24lambda_u240.cm = new RulesInfoData.RulesInfo.InfoItem();
        $this$newRulesInfo_u24lambda_u240.cm.rulesInfo = new ArrayList();
        $this$newRulesInfo_u24lambda_u240.ct = new RulesInfoData.RulesInfo.InfoItem();
        $this$newRulesInfo_u24lambda_u240.ct.rulesInfo = new ArrayList();
        $this$newRulesInfo_u24lambda_u240.cu = new RulesInfoData.RulesInfo.InfoItem();
        $this$newRulesInfo_u24lambda_u240.cu.rulesInfo = new ArrayList();
        result.rulesInfo = $this$newRulesInfo_u24lambda_u240;
        return result;
    }
}