package tv.danmaku.bili.auth.v2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bilibili.app.auth.R;
import com.bilibili.droid.InputMethodManagerHelper;
import com.bilibili.lib.foundation.FoundationAlias;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.AuthAgreementLinkHelper;
import tv.danmaku.bili.auth.LinkItemListener;
import tv.danmaku.bili.report.DefaultAuthReporter;

/* compiled from: BiliAuditingFragmentV2.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/auth/v2/BiliAuditingFragmentV2;", "Ltv/danmaku/bili/auth/v2/BaseAuthFragmentV2;", "<init>", "()V", "mTips", "Landroid/widget/TextView;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "BUNDLE_KEY_MODIFY_TIPS", "", "refreshUi", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuditingFragmentV2 extends BaseAuthFragmentV2 {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "BiliAuditingFragmentV2";
    private final String BUNDLE_KEY_MODIFY_TIPS = "key_modify_seccess";
    private TextView mTips;

    /* compiled from: BiliAuditingFragmentV2.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/auth/v2/BiliAuditingFragmentV2$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Ltv/danmaku/bili/auth/v2/BiliAuditingFragmentV2;", "params", "Landroid/os/Bundle;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BiliAuditingFragmentV2 newInstance(Bundle params) {
            BiliAuditingFragmentV2 fragment = new BiliAuditingFragmentV2();
            if (params != null) {
                fragment.setArguments(params);
            }
            return fragment;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final View view = inflater.inflate(R.layout.fragment_auditing2, container, false);
        Intrinsics.checkNotNullExpressionValue(view, "inflate(...)");
        TextView tv_agreement = (TextView) view.findViewById(R.id.tv_modify_agreement);
        this.mTips = (TextView) view.findViewById(R.id.success_tips);
        String highLight = getString(bili.resource.account.R.string.account_global_string_312);
        Intrinsics.checkNotNullExpressionValue(highLight, "getString(...)");
        AuthAgreementLinkHelper authAgreementLinkHelper = AuthAgreementLinkHelper.INSTANCE;
        String string = getString(bili.resource.account.R.string.account_global_string_238);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        authAgreementLinkHelper.attachContentLink(tv_agreement, string, highLight, AuthAgreementLinkHelper.INSTANCE.getAuthAgreementLink(), FoundationAlias.getFapp().getResources().getColor(R.color.text_blue_kit), new LinkItemListener() { // from class: tv.danmaku.bili.auth.v2.BiliAuditingFragmentV2$onCreateView$1
            @Override // tv.danmaku.bili.auth.LinkItemListener
            public void onItemClick() {
                InputMethodManagerHelper.hideSoftInput(BiliAuditingFragmentV2.this.getActivity(), view, 0);
                DefaultAuthReporter.INSTANCE.reportManualCheckClick(BiliAuditingFragmentV2.this.sourceEvent());
            }
        }, (r23 & 64) != 0 ? "" : null, (r23 & BR.cover) != 0 ? "" : null, (r23 & BR.hallEnterHotText) != 0 ? MapsKt.emptyMap() : null);
        return view;
    }

    @Override // tv.danmaku.bili.auth.v2.BaseAuthFragmentV2
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        refreshUi();
    }

    @Override // tv.danmaku.bili.auth.v2.BaseAuthFragmentV2
    public void refreshUi() {
        TextView textView;
        Bundle arguments = getArguments();
        Serializable result = (arguments == null || (r0 = arguments.getStringArrayList(this.BUNDLE_KEY_MODIFY_TIPS)) == null) ? "" : "";
        if (!result.equals("modify") || (textView = this.mTips) == null) {
            return;
        }
        textView.setText(getString(bili.resource.account.R.string.account_global_string_268));
    }
}