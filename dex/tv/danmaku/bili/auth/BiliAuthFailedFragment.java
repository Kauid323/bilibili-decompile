package tv.danmaku.bili.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bilibili.app.auth.R;
import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.DefaultAuthReporter;

/* compiled from: BiliAuthFailedFragment.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/auth/BiliAuthFailedFragment;", "Ltv/danmaku/bili/auth/BaseAuthFragment;", "<init>", "()V", "mName", "Landroid/widget/TextView;", "mCard", "mFailMsg", "", "mFailCode", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "refreshUi", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthFailedFragment extends BaseAuthFragment {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "BiliAuthFailedFragment";
    private TextView mCard;
    private int mFailCode;
    private String mFailMsg;
    private TextView mName;

    /* compiled from: BiliAuthFailedFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/auth/BiliAuthFailedFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Ltv/danmaku/bili/auth/BiliAuthFailedFragment;", "params", "Landroid/os/Bundle;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BiliAuthFailedFragment newInstance(Bundle params) {
            BiliAuthFailedFragment fragment = new BiliAuthFailedFragment();
            if (params != null) {
                fragment.setArguments(params);
            }
            return fragment;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view = inflater.inflate(R.layout.fragment_auth_failed, container, false);
        Intrinsics.checkNotNullExpressionValue(view, "inflate(...)");
        this.mName = (TextView) view.findViewById(R.id.tv_realname);
        this.mCard = (TextView) view.findViewById(R.id.tv_card);
        View findViewById = view.findViewById(R.id.btn_re_auth);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        Button reAuth = (Button) findViewById;
        reAuth.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.auth.BiliAuthFailedFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BiliAuthFailedFragment.onCreateView$lambda$0(BiliAuthFailedFragment.this, view2);
            }
        });
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(BiliAuthFailedFragment this$0, View it) {
        DefaultAuthReporter.INSTANCE.reportReEnterFaceClick(this$0.sourceEvent());
        this$0.toFragment(3, null, (Fragment) this$0);
    }

    @Override // tv.danmaku.bili.auth.BaseAuthFragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        refreshUi();
    }

    @Override // tv.danmaku.bili.auth.BaseAuthFragment
    public void refreshUi() {
        Bundle extra = getArguments();
        if (extra != null) {
            this.mFailMsg = extra.getString("key_fail_msg");
            this.mFailCode = extra.getInt("key_error_code");
            String name = extra.getString("key_real_name");
            if (name == null) {
                name = "";
            }
            String card = extra.getString("key_card");
            if (card == null) {
                card = "";
            }
            TextView textView = this.mName;
            if (textView != null) {
                textView.setText(FoundationAlias.getFapp().getString(bili.resource.account.R.string.account_global_string_307, new Object[]{name}));
            }
            TextView textView2 = this.mCard;
            if (textView2 != null) {
                textView2.setText(FoundationAlias.getFapp().getString(bili.resource.account.R.string.account_global_string_332, new Object[]{card}));
            }
            DefaultAuthReporter defaultAuthReporter = DefaultAuthReporter.INSTANCE;
            String sourceEvent = sourceEvent();
            String str = this.mFailMsg;
            defaultAuthReporter.reportAuthResultShow(sourceEvent, 0, str != null ? str : "");
        }
    }
}