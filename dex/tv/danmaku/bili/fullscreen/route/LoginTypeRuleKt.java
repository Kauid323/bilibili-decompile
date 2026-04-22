package tv.danmaku.bili.fullscreen.route;

import android.util.SparseArray;
import com.bilibili.lib.accounts.model.TInfoLogin;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: LoginTypeRule.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0000\u001a.\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u0002H\u0006H\u0082\u0010¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"getLoginTypeList", "", "Ltv/danmaku/bili/fullscreen/route/ValidLoginType;", "Lcom/bilibili/lib/accounts/model/TInfoLogin;", "insertAt", "", "T", "Landroid/util/SparseArray;", "key", "", "value", "(Landroid/util/SparseArray;ILjava/lang/Object;)V", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginTypeRuleKt {
    public static final List<ValidLoginType> getLoginTypeList(TInfoLogin $this$getLoginTypeList) {
        Intrinsics.checkNotNullParameter($this$getLoginTypeList, "<this>");
        SparseArray sparseArray = new SparseArray();
        TInfoLogin.LoginBean login = $this$getLoginTypeList.login;
        if (login != null) {
            TInfoLogin.LoginBean.FastLoginBean it = login.fastLogin;
            if (it != null) {
                if ((it.rank > 0 ? 1 : null) == null) {
                    it = null;
                }
                if (it != null) {
                    insertAt(sparseArray, it.rank, ValidLoginType.FastReLogin);
                }
            }
            TInfoLogin.QuickBean it2 = login.quick;
            if (it2 != null) {
                if ((it2.rank > 0 ? 1 : null) == null) {
                    it2 = null;
                }
                if (it2 != null) {
                    insertAt(sparseArray, it2.rank, ValidLoginType.QuickLogin);
                }
            }
            TInfoLogin.LoginBean.PwdBean it3 = login.pwd;
            if (it3 != null) {
                if ((it3.rank > 0 ? 1 : null) == null) {
                    it3 = null;
                }
                if (it3 != null) {
                    insertAt(sparseArray, it3.rank, ValidLoginType.PwdLogin);
                }
            }
            TInfoLogin.LoginBean.SmsBean it4 = login.sms;
            if (it4 != null) {
                TInfoLogin.LoginBean.SmsBean it5 = it4.rank > 0 ? it4 : null;
                if (it5 != null) {
                    insertAt(sparseArray, it5.rank, ValidLoginType.SmsLogin);
                }
            }
        }
        Iterable $this$map$iv = RangesKt.until(0, sparseArray.size());
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        IntIterator it6 = $this$map$iv.iterator();
        while (it6.hasNext()) {
            int item$iv$iv = it6.nextInt();
            destination$iv$iv.add((ValidLoginType) sparseArray.valueAt(item$iv$iv));
        }
        List it7 = (List) destination$iv$iv;
        BLog.i(StartLoginPageKt.TAG_LOGINRULE, "getLoginTypeList = " + it7);
        return it7;
    }

    private static final <T> void insertAt(SparseArray<T> sparseArray, int key, T t) {
        while (sparseArray.get(key) != null) {
            key++;
        }
        sparseArray.put(key, t);
    }
}