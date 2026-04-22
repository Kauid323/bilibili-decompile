package tv.danmaku.bili.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import bili.resource.account.R;
import com.bilibili.lib.accountsui.web.AccountWebAPActivity;
import com.bilibili.lib.blconfig.ConfigManager;
import java.lang.ref.WeakReference;
import kotlin.Pair;
import tv.danmaku.bili.quick.LoginIspHelper;

public class AgreementLinkHelper {
    public static final String DEFAULT_PRIVACY_POLICY_URL = "https://www.bilibili.com/blackboard/privacy-h5.html";
    public static final String DEFAULT_USER_PROTOCOL_URL = "https://www.bilibili.com/blackboard/account-useragreement.html";
    public static final String LINK_ACCOUNT_CHECK_HELP = "https://www.bilibili.com/h5/project-msg-auth/helper/list?list_id=6c12a7c17da044048d7772f1ead26084";
    public static final String LINK_ACCOUNT_CMOBILE_AGREEMENT_H5 = "https://wap.cmpassport.com/resources/html/contract.html";
    public static final String LINK_ACCOUNT_TELECOM_AGREEMENT_H5 = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true&appKey=";
    public static final String LINK_ACCOUNT_UNICOM_AGREEMENT_H5 = "https://opencloud.wostore.cn/authz/resource/html/disclaimer.html?fromsdk=true";
    private Context mContext;

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface ClickLinkItemListener {
        public static final int ITEM_ID_AGREEMENT = 2;
        public static final int ITEM_ID_HELP = 1;
        public static final int ITEM_ID_ISP_AGREEMENT = 4;
        public static final int ITEM_ID_PRIVACY = 3;

        void onItemLinkClick(int i);
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class H5Urls {
        public static String getUserProtocolUrl() {
            return (String) ConfigManager.config().get("permission_url.user_agreement", AgreementLinkHelper.DEFAULT_USER_PROTOCOL_URL);
        }

        public static String getPrivacyPolicyUrl() {
            return (String) ConfigManager.config().get("permission_url.privacy", AgreementLinkHelper.DEFAULT_PRIVACY_POLICY_URL);
        }
    }

    public AgreementLinkHelper(Context context) {
        this.mContext = context;
    }

    public void attachLinkContentHelp(TextView helpText, String tips, ClickLinkItemListener listener, int underLineColor) {
        if (helpText == null || TextUtils.isEmpty(tips)) {
            return;
        }
        String linkCheckHelp = this.mContext.getString(R.string.account_global_string_153);
        SpannableString text = SpannableString.valueOf(tips);
        int startCheckHelp = tips.indexOf(linkCheckHelp);
        int endCheckHelp = linkCheckHelp.length() + startCheckHelp;
        boolean isHandle = false;
        if (startCheckHelp != -1 && endCheckHelp > startCheckHelp) {
            text.setSpan(new NoUnderlineSpan(listener, LINK_ACCOUNT_CHECK_HELP, 1, underLineColor), startCheckHelp, endCheckHelp, 18);
            isHandle = true;
        }
        if (isHandle) {
            helpText.setText(text);
            helpText.setMovementMethod(LinkMovementMethod.getInstance());
            helpText.setHighlightColor(this.mContext.getResources().getColor(com.bilibili.app.comm.baseres.R.color.gray_dark_alpha26));
        }
    }

    public void attachLinkContentAgreement(TextView agreementText, String tips, ClickLinkItemListener listener) {
        attachLinkContentAgreement(agreementText, tips, 0, null, listener);
    }

    public void attachLinkContentAgreement(TextView agreementText, String tips, int underLineColor, ClickLinkItemListener listener) {
        attachLinkContentAgreement(agreementText, tips, underLineColor, null, listener);
    }

    public void attachLinkContentAgreement(TextView agreementText, String tips, int underLineColor, String ispName, ClickLinkItemListener listener) {
        if (agreementText != null && !TextUtils.isEmpty(tips)) {
            String linkUserAgreement = this.mContext.getString(R.string.account_global_string_56);
            String linkPrivacyAgreement = this.mContext.getString(R.string.account_global_string_110);
            Pair<String, String> carrierAndLink = LoginIspHelper.INSTANCE.getIspCarrierTextAndLink(this.mContext, ispName);
            String ispAgreement = (String) carrierAndLink.getFirst();
            String ispLinkUrl = (String) carrierAndLink.getSecond();
            SpannableString text = SpannableString.valueOf(tips);
            int startUserAgreement = tips.indexOf(linkUserAgreement);
            int endUserAgreement = startUserAgreement + linkUserAgreement.length();
            int startPrivacyAgreement = tips.indexOf(linkPrivacyAgreement);
            int endPrivacyAgreement = startPrivacyAgreement + linkPrivacyAgreement.length();
            boolean isHandle = false | addNoUnderlineSpan(text, startUserAgreement, endUserAgreement, H5Urls.getUserProtocolUrl(), 2, underLineColor, listener) | addNoUnderlineSpan(text, startPrivacyAgreement, endPrivacyAgreement, H5Urls.getPrivacyPolicyUrl(), 3, underLineColor, listener);
            if (!TextUtils.isEmpty(ispAgreement) && !TextUtils.isEmpty(ispLinkUrl)) {
                int startIspAgreement = tips.indexOf(ispAgreement);
                int endIspAgreement = startIspAgreement + ispAgreement.length();
                isHandle |= addNoUnderlineSpan(text, startIspAgreement, endIspAgreement, ispLinkUrl, 4, underLineColor, listener);
            }
            if (isHandle) {
                agreementText.setText(text);
                agreementText.setMovementMethod(LinkMovementMethod.getInstance());
                agreementText.setHighlightColor(this.mContext.getResources().getColor(com.bilibili.app.comm.baseres.R.color.gray_dark_alpha26));
            }
        }
    }

    private boolean addNoUnderlineSpan(SpannableString text, int startIndex, int endIndex, String url, int id, int underLineColor, ClickLinkItemListener listener) {
        if (startIndex != -1 && endIndex > startIndex) {
            text.setSpan(new NoUnderlineSpan(listener, url, id, underLineColor), startIndex, endIndex, 18);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class NoUnderlineSpan extends ClickableSpan {
        private int mId;
        private WeakReference<ClickLinkItemListener> mListenerRef;
        private int mUnderLineColor;
        private String mUrl;

        public NoUnderlineSpan(ClickLinkItemListener listener, String url, int id, int underLineColor) {
            this.mListenerRef = new WeakReference<>(listener);
            this.mUrl = url;
            this.mId = id;
            this.mUnderLineColor = underLineColor;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            ClickLinkItemListener listener = this.mListenerRef.get();
            if (listener != null) {
                listener.onItemLinkClick(this.mId);
            }
            Context context = widget.getContext();
            Intent webIntent = new Intent(context, AccountWebAPActivity.class);
            webIntent.setData(Uri.parse(this.mUrl));
            context.startActivity(webIntent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
            ds.bgColor = 0;
            ds.setColor(this.mUnderLineColor);
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static class UserAgreementSpan extends NoUnderlineSpan {
        public UserAgreementSpan(ClickLinkItemListener listener, String url, int id, int underLineColor) {
            super(listener, url, id, underLineColor);
        }

        @Override // tv.danmaku.bili.ui.AgreementLinkHelper.NoUnderlineSpan, android.text.style.ClickableSpan
        public void onClick(View widget) {
            super.onClick(widget);
        }
    }
}