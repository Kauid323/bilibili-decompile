package tv.danmaku.bili.quick;

import android.content.Context;
import bili.resource.account.R;
import com.bilibili.api.BiliConfig;
import com.bilibili.lib.accounts.model.TInfoLogin;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.core.LoginRuleProcessor;
import tv.danmaku.bili.splash.ad.utils.NetworkUtilsKt;
import tv.danmaku.bili.ui.AgreementLinkHelper;

/* compiled from: LoginIspHelper.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005J(\u0010\t\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/quick/LoginIspHelper;", "", "<init>", "()V", "getIspCarrierText", "", "context", "Landroid/content/Context;", "ispName", "getIspCarrierTextAndLink", "Lkotlin/Pair;", "getIspCarrierLabel", "carrierProtocol", "Lcom/bilibili/lib/accounts/model/TInfoLogin$QuickProtocolBean$CarrierProtocolBean;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginIspHelper {
    public static final int $stable = 0;
    public static final LoginIspHelper INSTANCE = new LoginIspHelper();

    private LoginIspHelper() {
    }

    public final String getIspCarrierText(Context context, String ispName) {
        TInfoLogin.QuickProtocolBean quickProtocolBean;
        TInfoLogin.QuickProtocolBean quickProtocolBean2;
        TInfoLogin.QuickProtocolBean quickProtocolBean3;
        Intrinsics.checkNotNullParameter(context, "context");
        TInfoLogin.QuickProtocolBean.CarrierProtocolBean carrierProtocolBean = null;
        if (ispName != null) {
            switch (ispName.hashCode()) {
                case -1429363305:
                    if (ispName.equals("telecom")) {
                        TInfoLogin mTInfoLogin = LoginRuleProcessor.INSTANCE.getMTInfoLogin();
                        if (mTInfoLogin != null && (quickProtocolBean = mTInfoLogin.quickProtocol) != null) {
                            carrierProtocolBean = quickProtocolBean.telecom;
                        }
                        String ispCarrierLabel = getIspCarrierLabel(carrierProtocolBean);
                        if (ispCarrierLabel == null) {
                            String string = context.getString(R.string.account_global_string_44);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            return string;
                        }
                        return ispCarrierLabel;
                    }
                    return null;
                case -1068855134:
                    if (ispName.equals(NetworkUtilsKt.NETWORK_TYPE_MOBILE)) {
                        TInfoLogin mTInfoLogin2 = LoginRuleProcessor.INSTANCE.getMTInfoLogin();
                        if (mTInfoLogin2 != null && (quickProtocolBean2 = mTInfoLogin2.quickProtocol) != null) {
                            carrierProtocolBean = quickProtocolBean2.mobile;
                        }
                        String ispCarrierLabel2 = getIspCarrierLabel(carrierProtocolBean);
                        if (ispCarrierLabel2 == null) {
                            String string2 = context.getString(R.string.account_global_string_16);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                            return string2;
                        }
                        return ispCarrierLabel2;
                    }
                    return null;
                case -840542575:
                    if (ispName.equals(AppConfig.HOST_UNICOM)) {
                        TInfoLogin mTInfoLogin3 = LoginRuleProcessor.INSTANCE.getMTInfoLogin();
                        if (mTInfoLogin3 != null && (quickProtocolBean3 = mTInfoLogin3.quickProtocol) != null) {
                            carrierProtocolBean = quickProtocolBean3.unicom;
                        }
                        String ispCarrierLabel3 = getIspCarrierLabel(carrierProtocolBean);
                        if (ispCarrierLabel3 == null) {
                            String string3 = context.getString(R.string.account_global_string_95);
                            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                            return string3;
                        }
                        return ispCarrierLabel3;
                    }
                    return null;
                default:
                    return null;
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final Pair<String, String> getIspCarrierTextAndLink(Context context, String ispName) {
        String agreement;
        String linkUrl;
        String str;
        TInfoLogin.QuickProtocolBean quickProtocolBean;
        TInfoLogin.QuickProtocolBean.CarrierProtocolBean carrierProtocolBean;
        TInfoLogin.QuickProtocolBean quickProtocolBean2;
        String str2;
        TInfoLogin.QuickProtocolBean quickProtocolBean3;
        TInfoLogin.QuickProtocolBean.CarrierProtocolBean carrierProtocolBean2;
        TInfoLogin.QuickProtocolBean quickProtocolBean4;
        String str3;
        TInfoLogin.QuickProtocolBean quickProtocolBean5;
        TInfoLogin.QuickProtocolBean.CarrierProtocolBean carrierProtocolBean3;
        TInfoLogin.QuickProtocolBean quickProtocolBean6;
        Intrinsics.checkNotNullParameter(context, "context");
        if (ispName != null) {
            TInfoLogin.QuickProtocolBean.CarrierProtocolBean carrierProtocolBean4 = null;
            switch (ispName.hashCode()) {
                case -1429363305:
                    if (ispName.equals("telecom")) {
                        TInfoLogin mTInfoLogin = LoginRuleProcessor.INSTANCE.getMTInfoLogin();
                        if (mTInfoLogin != null && (quickProtocolBean2 = mTInfoLogin.quickProtocol) != null) {
                            carrierProtocolBean4 = quickProtocolBean2.telecom;
                        }
                        String ispCarrierLabel = getIspCarrierLabel(carrierProtocolBean4);
                        if (ispCarrierLabel == null) {
                            ispCarrierLabel = context.getString(R.string.account_global_string_44);
                            Intrinsics.checkNotNullExpressionValue(ispCarrierLabel, "getString(...)");
                        }
                        agreement = ispCarrierLabel;
                        TInfoLogin mTInfoLogin2 = LoginRuleProcessor.INSTANCE.getMTInfoLogin();
                        if (mTInfoLogin2 == null || (quickProtocolBean = mTInfoLogin2.quickProtocol) == null || (carrierProtocolBean = quickProtocolBean.telecom) == null || (str = carrierProtocolBean.link) == null) {
                            str = AgreementLinkHelper.LINK_ACCOUNT_TELECOM_AGREEMENT_H5;
                        }
                        linkUrl = str;
                        break;
                    }
                    break;
                case -1068855134:
                    if (ispName.equals(NetworkUtilsKt.NETWORK_TYPE_MOBILE)) {
                        TInfoLogin mTInfoLogin3 = LoginRuleProcessor.INSTANCE.getMTInfoLogin();
                        if (mTInfoLogin3 != null && (quickProtocolBean4 = mTInfoLogin3.quickProtocol) != null) {
                            carrierProtocolBean4 = quickProtocolBean4.mobile;
                        }
                        String ispCarrierLabel2 = getIspCarrierLabel(carrierProtocolBean4);
                        if (ispCarrierLabel2 == null) {
                            ispCarrierLabel2 = context.getString(R.string.account_global_string_16);
                            Intrinsics.checkNotNullExpressionValue(ispCarrierLabel2, "getString(...)");
                        }
                        agreement = ispCarrierLabel2;
                        TInfoLogin mTInfoLogin4 = LoginRuleProcessor.INSTANCE.getMTInfoLogin();
                        if (mTInfoLogin4 == null || (quickProtocolBean3 = mTInfoLogin4.quickProtocol) == null || (carrierProtocolBean2 = quickProtocolBean3.mobile) == null || (str2 = carrierProtocolBean2.link) == null) {
                            str2 = AgreementLinkHelper.LINK_ACCOUNT_CMOBILE_AGREEMENT_H5;
                        }
                        linkUrl = str2;
                        break;
                    }
                    break;
                case -840542575:
                    if (ispName.equals(AppConfig.HOST_UNICOM)) {
                        TInfoLogin mTInfoLogin5 = LoginRuleProcessor.INSTANCE.getMTInfoLogin();
                        if (mTInfoLogin5 != null && (quickProtocolBean6 = mTInfoLogin5.quickProtocol) != null) {
                            carrierProtocolBean4 = quickProtocolBean6.unicom;
                        }
                        String ispCarrierLabel3 = getIspCarrierLabel(carrierProtocolBean4);
                        if (ispCarrierLabel3 == null) {
                            ispCarrierLabel3 = context.getString(R.string.account_global_string_95);
                            Intrinsics.checkNotNullExpressionValue(ispCarrierLabel3, "getString(...)");
                        }
                        agreement = ispCarrierLabel3;
                        TInfoLogin mTInfoLogin6 = LoginRuleProcessor.INSTANCE.getMTInfoLogin();
                        if (mTInfoLogin6 == null || (quickProtocolBean5 = mTInfoLogin6.quickProtocol) == null || (carrierProtocolBean3 = quickProtocolBean5.unicom) == null || (str3 = carrierProtocolBean3.link) == null) {
                            str3 = AgreementLinkHelper.LINK_ACCOUNT_UNICOM_AGREEMENT_H5;
                        }
                        linkUrl = str3;
                        break;
                    }
                    break;
            }
            return new Pair<>(agreement, linkUrl);
        }
        agreement = null;
        linkUrl = null;
        return new Pair<>(agreement, linkUrl);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getIspCarrierLabel(TInfoLogin.QuickProtocolBean.CarrierProtocolBean carrierProtocol) {
        String str;
        if (carrierProtocol == null) {
            return null;
        }
        String currentLocale = BiliConfig.getCurrentLocale();
        Intrinsics.checkNotNullExpressionValue(currentLocale, "getCurrentLocale(...)");
        if (!StringsKt.contains$default(currentLocale, "zh-Hant", false, 2, (Object) null)) {
            String currentLocale2 = BiliConfig.getCurrentLocale();
            Intrinsics.checkNotNullExpressionValue(currentLocale2, "getCurrentLocale(...)");
            if (!StringsKt.contains$default(currentLocale2, "zh_TW", false, 2, (Object) null)) {
                String currentLocale3 = BiliConfig.getCurrentLocale();
                Intrinsics.checkNotNullExpressionValue(currentLocale3, "getCurrentLocale(...)");
                if (!StringsKt.contains$default(currentLocale3, "zh_HK", false, 2, (Object) null)) {
                    String currentLocale4 = BiliConfig.getCurrentLocale();
                    Intrinsics.checkNotNullExpressionValue(currentLocale4, "getCurrentLocale(...)");
                    if (!StringsKt.contains$default(currentLocale4, "zh_MO", false, 2, (Object) null)) {
                        str = carrierProtocol.label;
                        if (str != null) {
                            return null;
                        }
                        String it = str;
                        if (StringsKt.isBlank(it)) {
                            return null;
                        }
                        return str;
                    }
                }
            }
        }
        str = carrierProtocol.labelHK;
        if (str != null) {
        }
    }
}