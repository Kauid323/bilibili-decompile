package tv.danmaku.bili.auth.modify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.fragment.app.Fragment;
import com.bilibili.app.auth.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.helper.ReasonType;

/* compiled from: BiliAuthModifyReasonFragment.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthModifyReasonFragment;", "Ltv/danmaku/bili/auth/modify/BaseAuthModifyFragment;", "<init>", "()V", "mNextEnter", "Landroid/view/View;", "mRadioGroup", "Landroid/widget/RadioGroup;", "mReason", "Ltv/danmaku/bili/auth/helper/ReasonType;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthModifyReasonFragment extends BaseAuthModifyFragment {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "BiliAuthModifyPersonFragment";
    private View mNextEnter;
    private RadioGroup mRadioGroup;
    private ReasonType mReason = ReasonType.NONE;

    /* compiled from: BiliAuthModifyReasonFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthModifyReasonFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Ltv/danmaku/bili/auth/modify/BiliAuthModifyReasonFragment;", "params", "Landroid/os/Bundle;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BiliAuthModifyReasonFragment newInstance(Bundle params) {
            BiliAuthModifyReasonFragment fragment = new BiliAuthModifyReasonFragment();
            if (params != null) {
                fragment.setArguments(params);
            }
            return fragment;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view = inflater.inflate(R.layout.fragment_auth_modify_reason, container, false);
        Intrinsics.checkNotNullExpressionValue(view, "inflate(...)");
        this.mRadioGroup = (RadioGroup) view.findViewById(R.id.group_reason);
        RadioGroup radioGroup = this.mRadioGroup;
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyReasonFragment$$ExternalSyntheticLambda0
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                    BiliAuthModifyReasonFragment.onCreateView$lambda$0(BiliAuthModifyReasonFragment.this, radioGroup2, i);
                }
            });
        }
        this.mNextEnter = view.findViewById(R.id.btn_modify_next);
        final View $this$onCreateView_u24lambda_u241 = this.mNextEnter;
        if ($this$onCreateView_u24lambda_u241 != null) {
            $this$onCreateView_u24lambda_u241.setEnabled(false);
            $this$onCreateView_u24lambda_u241.setAlpha(0.5f);
            $this$onCreateView_u24lambda_u241.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyReasonFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BiliAuthModifyReasonFragment.onCreateView$lambda$1$0(BiliAuthModifyReasonFragment.this, $this$onCreateView_u24lambda_u241, view2);
                }
            });
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(BiliAuthModifyReasonFragment this$0, RadioGroup group, int checkedId) {
        if (checkedId == R.id.radio_reason1) {
            this$0.mReason = ReasonType.KINSHIP;
            View $this$onCreateView_u24lambda_u240_u240 = this$0.mNextEnter;
            if ($this$onCreateView_u24lambda_u240_u240 != null) {
                $this$onCreateView_u24lambda_u240_u240.setEnabled(true);
                $this$onCreateView_u24lambda_u240_u240.setAlpha(1.0f);
            }
        } else if (checkedId == R.id.radio_reason2) {
            this$0.mReason = ReasonType.JOBCHANGE;
            View $this$onCreateView_u24lambda_u240_u241 = this$0.mNextEnter;
            if ($this$onCreateView_u24lambda_u240_u241 != null) {
                $this$onCreateView_u24lambda_u240_u241.setEnabled(true);
                $this$onCreateView_u24lambda_u240_u241.setAlpha(1.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1$0(BiliAuthModifyReasonFragment this$0, View $this_apply, View it) {
        Bundle bundle = this$0.getArguments();
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt(this$0.getBUNDLE_KEY_MODIFY_REASON$auth_debug(), this$0.mReason.getValue());
        this$0.showFragmentWithBundle($this_apply.getContext(), bundle, (Fragment) this$0, this$0.getURL_BILI_AUTH_MODIFY_PERSON_UPLOAD$auth_debug(), BiliAuthUploadFragment.TAG);
    }

    @Override // tv.danmaku.bili.auth.modify.BaseAuthModifyFragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
    }
}