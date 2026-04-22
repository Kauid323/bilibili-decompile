package tv.danmaku.bili.auth;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.droid.H5UrlConfigHelper;
import com.bilibili.lib.foundation.FoundationAlias;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;

/* compiled from: BiliAuthExts.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jb\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0015J\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/auth/AuthAgreementLinkHelper;", "", "<init>", "()V", "LINK_AUTH_AGREEMENT_H5", "", "LINK_FACIAL_AGREEMENT_H5", "attachContentLink", "", "agreementTx", "Landroid/widget/TextView;", "tips", "highlight1", "url1", "underLineColor", "", "listener", "Ltv/danmaku/bili/auth/LinkItemListener;", "highlight2", "url2", "extras", "", "getFacialAgreementLink", "getAuthAgreementLink", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AuthAgreementLinkHelper {
    public static final AuthAgreementLinkHelper INSTANCE = new AuthAgreementLinkHelper();
    private static final String LINK_AUTH_AGREEMENT_H5 = "https://www.bilibili.com/blackboard/activity-CFb6c82RAY.html";
    private static final String LINK_FACIAL_AGREEMENT_H5 = "https://www.bilibili.com/blackboard/activity-msK3lx0JRp.html";

    private AuthAgreementLinkHelper() {
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void attachContentLink(TextView agreementTx, String tips, String highlight1, String url1, int underLineColor, LinkItemListener listener, String highlight2, String url2, Map<String, String> map) {
        boolean isHandle;
        SpannableString text;
        Intrinsics.checkNotNullParameter(tips, "tips");
        Intrinsics.checkNotNullParameter(highlight1, "highlight1");
        Intrinsics.checkNotNullParameter(url1, "url1");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(highlight2, "highlight2");
        Intrinsics.checkNotNullParameter(url2, "url2");
        Intrinsics.checkNotNullParameter(map, "extras");
        if (agreementTx == null) {
            return;
        }
        SpannableString text2 = SpannableString.valueOf(tips);
        int startCheckHelp1 = StringsKt.indexOf$default(tips, highlight1, 0, false, 6, (Object) null);
        int endCheckHelp1 = startCheckHelp1 + highlight1.length();
        if (startCheckHelp1 != -1 && endCheckHelp1 > startCheckHelp1) {
            text2.setSpan(new NoUnderlineSpan(listener, url1, underLineColor, map), startCheckHelp1, endCheckHelp1, 18);
            isHandle = true;
        } else {
            isHandle = false;
        }
        if (!(highlight2.length() == 0)) {
            if (!(url2.length() == 0)) {
                int startCheckHelp2 = StringsKt.indexOf$default(tips, highlight2, 0, false, 6, (Object) null);
                int endCheckHelp2 = highlight2.length() + startCheckHelp2;
                if (startCheckHelp2 == -1 || endCheckHelp2 <= startCheckHelp2) {
                    text = text2;
                } else {
                    text = text2;
                    text.setSpan(new NoUnderlineSpan(listener, url2, underLineColor, map), startCheckHelp2, endCheckHelp2, 18);
                    isHandle = true;
                }
                if (!isHandle) {
                    agreementTx.setText(text);
                    agreementTx.setMovementMethod(LinkMovementMethod.getInstance());
                    agreementTx.setHighlightColor(FoundationAlias.getFapp().getResources().getColor(R.color.gray_dark_alpha26));
                    return;
                }
                return;
            }
        }
        text = text2;
        if (!isHandle) {
        }
    }

    public final String getFacialAgreementLink() {
        String url = H5UrlConfigHelper.INSTANCE.getUrl("auth", "url_auth_agreement_tips", LINK_FACIAL_AGREEMENT_H5);
        return url == null ? LINK_FACIAL_AGREEMENT_H5 : url;
    }

    public final String getAuthAgreementLink() {
        String url = H5UrlConfigHelper.INSTANCE.getUrl("auth", "url_auth_agreement_tips", LINK_AUTH_AGREEMENT_H5);
        return url == null ? LINK_AUTH_AGREEMENT_H5 : url;
    }
}