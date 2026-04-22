package tv.danmaku.bili.auth.v2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bilibili.app.auth.R;
import com.bilibili.droid.InputMethodManagerHelper;
import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.AuthAgreementLinkHelper;
import tv.danmaku.bili.auth.LinkItemListener;
import tv.danmaku.bili.report.DefaultAuthReporter;

/* compiled from: BiliAuthFailedFragmentV2.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/auth/v2/BiliAuthFailedFragmentV2;", "Ltv/danmaku/bili/auth/v2/BaseAuthFragmentV2;", "<init>", "()V", "mTips", "Landroid/widget/TextView;", "mFailMsg", "", "mFailCode", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "refreshUi", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthFailedFragmentV2 extends BaseAuthFragmentV2 {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "BiliAuthFailedFragmentV2";
    private int mFailCode;
    private String mFailMsg;
    private TextView mTips;

    /* compiled from: BiliAuthFailedFragmentV2.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/auth/v2/BiliAuthFailedFragmentV2$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Ltv/danmaku/bili/auth/v2/BiliAuthFailedFragmentV2;", "params", "Landroid/os/Bundle;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BiliAuthFailedFragmentV2 newInstance(Bundle params) {
            BiliAuthFailedFragmentV2 fragment = new BiliAuthFailedFragmentV2();
            if (params != null) {
                fragment.setArguments(params);
            }
            return fragment;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final View view = inflater.inflate(R.layout.fragment_auth_modify_error, container, false);
        Intrinsics.checkNotNullExpressionValue(view, "inflate(...)");
        TextView mTitleTv = (TextView) view.findViewById(R.id.error_title);
        mTitleTv.setText(bili.resource.account.R.string.account_global_string_337);
        this.mTips = (TextView) view.findViewById(R.id.auth_check_tips);
        TextView tv_agreement = (TextView) view.findViewById(R.id.tv_modify_agreement);
        String highLight = getString(bili.resource.account.R.string.account_global_string_312);
        Intrinsics.checkNotNullExpressionValue(highLight, "getString(...)");
        AuthAgreementLinkHelper authAgreementLinkHelper = AuthAgreementLinkHelper.INSTANCE;
        String string = getString(bili.resource.account.R.string.account_global_string_238);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        authAgreementLinkHelper.attachContentLink(tv_agreement, string, highLight, AuthAgreementLinkHelper.INSTANCE.getAuthAgreementLink(), FoundationAlias.getFapp().getResources().getColor(R.color.text_blue_kit), new LinkItemListener() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFailedFragmentV2$onCreateView$1
            @Override // tv.danmaku.bili.auth.LinkItemListener
            public void onItemClick() {
                InputMethodManagerHelper.hideSoftInput(BiliAuthFailedFragmentV2.this.getActivity(), view, 0);
                DefaultAuthReporter.INSTANCE.reportManualCheckClick(BiliAuthFailedFragmentV2.this.sourceEvent());
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
        Bundle extra = getArguments();
        if (extra != null) {
            this.mFailMsg = extra.getString("key_fail_msg");
            this.mFailCode = extra.getInt("key_error_code");
            TextView textView = this.mTips;
            if (textView != null) {
                textView.setText(this.mFailMsg);
            }
        }
    }
}