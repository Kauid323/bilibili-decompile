package tv.danmaku.bili.auth.modify;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bilibili.app.auth.R;
import com.bilibili.droid.InputMethodManagerHelper;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.facialrecognition.FacialRecognitionHelper;
import com.bilibili.lib.facialrecognition.v2.FacialErrorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.AuthBlockChecker;
import tv.danmaku.bili.auth.AuthBlockListener;
import tv.danmaku.bili.auth.BiliAuthFragment;
import tv.danmaku.bili.auth.helper.AuthToastHelper;
import tv.danmaku.bili.auth.helper.EvokeFacialHelper;
import tv.danmaku.bili.auth.helper.RequestFacialData;
import tv.danmaku.bili.auth.helper.SceneType;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: BiliAuthNewNameFragment.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ?2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001?B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010'\u001a\u00020%H\u0016J\u0010\u0010(\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000eH\u0002J\b\u0010)\u001a\u00020\u0015H\u0002J\u0012\u0010*\u001a\u00020%2\b\u0010+\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010,\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010-\u001a\u00020%H\u0002J\b\u0010.\u001a\u00020%H\u0016J\u0012\u0010/\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\"\u00102\u001a\u00020%2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001012\u0006\u00106\u001a\u000204H\u0016J\u001a\u00107\u001a\u00020%2\b\u0010+\u001a\u0004\u0018\u00010\u000e2\u0006\u00108\u001a\u00020\u0015H\u0016J\u0012\u00109\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010,\u001a\u00020%2\b\u0010:\u001a\u0004\u0018\u0001012\u0006\u0010;\u001a\u00020<H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthNewNameFragment;", "Ltv/danmaku/bili/auth/modify/BaseAuthModifyFragment;", "Landroid/view/View$OnClickListener;", "Lcom/bilibili/lib/facialrecognition/FacialRecognitionHelper$IFacialCallback;", "Landroid/view/View$OnFocusChangeListener;", "<init>", "()V", "mName", "Landroid/widget/EditText;", "mCard", "Landroid/widget/TextView;", "mVerify", "Landroid/widget/Button;", "mCheckBoxContainer", "Landroid/view/View;", "mCheckBox", "Landroid/widget/CheckBox;", "mAgreementTips", "mAuthBlockChecker", "Ltv/danmaku/bili/auth/AuthBlockChecker;", "isClick", "", "mIsChecked", "isChecking", "isNameChecked", "mEvokeFacialHelper", "Ltv/danmaku/bili/auth/helper/EvokeFacialHelper;", "mAuthToastHelper", "Ltv/danmaku/bili/auth/helper/AuthToastHelper;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "refreshUi", "initView", "checkContentValid", "onClick", "v", "checkNameCardBlock", "checkBlockFinish", "onInitSuccess", "onSuccess", "requestID", "", "onFailure", "errorCode", "", AuthResultCbHelper.ARGS_MSG, "causeCode", "onFocusChange", "hasFocus", "afterClearFocus", "content", "listener", "Ltv/danmaku/bili/auth/AuthBlockListener;", "hideInputRunnable", "Ljava/lang/Runnable;", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthNewNameFragment extends BaseAuthModifyFragment implements View.OnClickListener, FacialRecognitionHelper.IFacialCallback, View.OnFocusChangeListener {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "BiliAuthNewNameFragment";
    private boolean isChecking;
    private boolean isClick;
    private boolean isNameChecked;
    private TextView mAgreementTips;
    private AuthToastHelper mAuthToastHelper;
    private TextView mCard;
    private CheckBox mCheckBox;
    private View mCheckBoxContainer;
    private EvokeFacialHelper mEvokeFacialHelper;
    private boolean mIsChecked;
    private EditText mName;
    private Button mVerify;
    private final AuthBlockChecker mAuthBlockChecker = new AuthBlockChecker();
    private final Runnable hideInputRunnable = new Runnable() { // from class: tv.danmaku.bili.auth.modify.BiliAuthNewNameFragment$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            BiliAuthNewNameFragment.hideInputRunnable$lambda$0(BiliAuthNewNameFragment.this);
        }
    };

    public /* synthetic */ void onDetectStart() {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onDetectStart(this);
    }

    public /* synthetic */ void onFailure(FacialErrorInfo facialErrorInfo) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onFailure(this, facialErrorInfo);
    }

    public /* synthetic */ void onRequestEnd() {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onRequestEnd(this);
    }

    public /* synthetic */ void onRequestStart() {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onRequestStart(this);
    }

    public /* synthetic */ void onSuccess(String str, String str2) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onSuccess(this, str, str2);
    }

    public /* synthetic */ void onSuccessForOverride(String str, String str2) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onSuccessForOverride(this, str, str2);
    }

    /* compiled from: BiliAuthNewNameFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthNewNameFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Ltv/danmaku/bili/auth/modify/BiliAuthNewNameFragment;", "params", "Landroid/os/Bundle;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BiliAuthNewNameFragment newInstance(Bundle params) {
            BiliAuthNewNameFragment fragment = new BiliAuthNewNameFragment();
            if (params != null) {
                fragment.setArguments(params);
            }
            return fragment;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view = inflater.inflate(R.layout.fragment_auth_edit_name, container, false);
        Intrinsics.checkNotNullExpressionValue(view, "inflate(...)");
        initView(view);
        return view;
    }

    @Override // tv.danmaku.bili.auth.modify.BaseAuthModifyFragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        refreshUi();
        EvokeFacialHelper $this$onViewCreated_u24lambda_u240 = this.mEvokeFacialHelper;
        if ($this$onViewCreated_u24lambda_u240 != null) {
            $this$onViewCreated_u24lambda_u240.setMDelayEnter(true);
            $this$onViewCreated_u24lambda_u240.setFacialListener(this);
            $this$onViewCreated_u24lambda_u240.initFacial();
        }
    }

    @Override // tv.danmaku.bili.auth.modify.BaseAuthModifyFragment
    public void refreshUi() {
        Bundle extra = getArguments();
        if (extra != null) {
            String card = extra.getString("key_card");
            if (card == null) {
                card = "";
            }
            TextView textView = this.mCard;
            if (textView != null) {
                textView.setText(card);
            }
        }
    }

    private final void initView(View view) {
        this.mEvokeFacialHelper = new EvokeFacialHelper(getContext());
        this.mAuthToastHelper = new AuthToastHelper(requireHostActivity());
        this.mName = (EditText) view.findViewById(R.id.edit_name);
        this.mCard = (TextView) view.findViewById(R.id.tv_card);
        this.mCheckBoxContainer = view.findViewById(R.id.facial_ag_checkbox_container);
        this.mCheckBox = (CheckBox) view.findViewById(R.id.facial_ag_checkbox);
        CheckBox checkBox = this.mCheckBox;
        if (checkBox != null) {
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.auth.modify.BiliAuthNewNameFragment$$ExternalSyntheticLambda2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    BiliAuthNewNameFragment.initView$lambda$0(BiliAuthNewNameFragment.this, compoundButton, z);
                }
            });
        }
        this.mAgreementTips = (TextView) view.findViewById(R.id.tv_facial_agreement);
        this.mVerify = (Button) view.findViewById(R.id.btn_auth_enter);
        handleAgreement(this.mAgreementTips);
        View view2 = this.mCheckBoxContainer;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
        TextView textView = this.mAgreementTips;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        Button button = this.mVerify;
        if (button != null) {
            button.setOnClickListener(this);
        }
        EditText editText = this.mName;
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher() { // from class: tv.danmaku.bili.auth.modify.BiliAuthNewNameFragment$initView$2
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                    Button button2;
                    boolean checkContentValid;
                    button2 = BiliAuthNewNameFragment.this.mVerify;
                    if (button2 != null) {
                        checkContentValid = BiliAuthNewNameFragment.this.checkContentValid();
                        button2.setEnabled(checkContentValid);
                    }
                    BiliAuthNewNameFragment.this.isNameChecked = false;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable p0) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(BiliAuthNewNameFragment this$0, CompoundButton compoundButton, boolean isChecked) {
        this$0.isClick = false;
        this$0.mIsChecked = isChecked;
        Button button = this$0.mVerify;
        if (button != null) {
            button.setEnabled(this$0.checkContentValid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkContentValid() {
        EditText editText = this.mName;
        return (String.valueOf(editText != null ? editText.getText() : null).length() > 0) && this.mIsChecked && !this.isChecking;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer valueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.tv_facial_agreement;
        if (valueOf == null || valueOf.intValue() != i) {
            int i2 = R.id.facial_ag_checkbox_container;
            if (valueOf == null || valueOf.intValue() != i2) {
                int i3 = R.id.btn_auth_enter;
                if (valueOf != null && valueOf.intValue() == i3 && checkContentValid()) {
                    EditText editText = this.mName;
                    if (editText != null) {
                        editText.clearFocus();
                    }
                    if (!this.isNameChecked) {
                        checkNameCardBlock(this.mName);
                        return;
                    } else {
                        checkBlockFinish();
                        return;
                    }
                }
                return;
            }
        }
        CheckBox $this$onClick_u24lambda_u240 = this.mCheckBox;
        if ($this$onClick_u24lambda_u240 != null) {
            $this$onClick_u24lambda_u240.setChecked(!$this$onClick_u24lambda_u240.isChecked());
            this.mIsChecked = $this$onClick_u24lambda_u240.isChecked();
            Button button = this.mVerify;
            if (button != null) {
                button.setEnabled(checkContentValid());
            }
        }
    }

    private final void checkNameCardBlock(EditText view) {
        String content = String.valueOf(view != null ? view.getText() : null);
        AuthToastHelper authToastHelper = this.mAuthToastHelper;
        boolean z = true;
        if (authToastHelper != null) {
            AuthToastHelper.showLoading$default(authToastHelper, null, 1, null);
        }
        String str = content;
        if (str != null && !StringsKt.isBlank(str)) {
            z = false;
        }
        if (z) {
            AuthToastHelper authToastHelper2 = this.mAuthToastHelper;
            if (authToastHelper2 != null) {
                authToastHelper2.dismissLoading();
                return;
            }
            return;
        }
        this.mAuthBlockChecker.checkBlock(content, new BiliAuthNewNameFragment$checkNameCardBlock$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkBlockFinish() {
        if (!this.isNameChecked) {
            checkNameCardBlock(this.mName);
            return;
        }
        EvokeFacialHelper $this$checkBlockFinish_u24lambda_u240 = this.mEvokeFacialHelper;
        if ($this$checkBlockFinish_u24lambda_u240 != null) {
            $this$checkBlockFinish_u24lambda_u240.setMDelayEnter(false);
            $this$checkBlockFinish_u24lambda_u240.setFacialListener(this);
            EditText editText = this.mName;
            String valueOf = String.valueOf(editText != null ? editText.getText() : null);
            TextView textView = this.mCard;
            $this$checkBlockFinish_u24lambda_u240.startFacial(new RequestFacialData(valueOf, String.valueOf(textView != null ? textView.getText() : null), "modifyName", SceneType.MODIFYNAME, sourceEvent()), (Activity) requireHostActivity());
        }
    }

    public void onInitSuccess() {
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.modify.BiliAuthNewNameFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthNewNameFragment.onInitSuccess$lambda$0(BiliAuthNewNameFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitSuccess$lambda$0(BiliAuthNewNameFragment this$0) {
        BLog.i(BiliAuthFragment.TAG, "FacialRecognition::onInitSuccess");
        EvokeFacialHelper $this$onInitSuccess_u24lambda_u240_u240 = this$0.mEvokeFacialHelper;
        if ($this$onInitSuccess_u24lambda_u240_u240 != null) {
            $this$onInitSuccess_u24lambda_u240_u240.setMFacialInit(true);
            $this$onInitSuccess_u24lambda_u240_u240.enterFacial();
        }
    }

    public void onSuccess(String requestID) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onSuccess(this, requestID);
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.modify.BiliAuthNewNameFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthNewNameFragment.onSuccess$lambda$0(BiliAuthNewNameFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSuccess$lambda$0(BiliAuthNewNameFragment this$0) {
        EvokeFacialHelper evokeFacialHelper = this$0.mEvokeFacialHelper;
        if (evokeFacialHelper != null) {
            evokeFacialHelper.facialFinish();
        }
        this$0.showFragmentByRoute(this$0.getContext(), (Fragment) this$0, new RouteRequest.Builder(this$0.getURL_BILI_AUTH_MODIFY_SUCCESS$auth_debug()).build(), "BiliAuthModifySuccessFragment");
    }

    public void onFailure(int errorCode, String msg, int causeCode) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onFailure(this, errorCode, msg, causeCode);
        EvokeFacialHelper evokeFacialHelper = this.mEvokeFacialHelper;
        if (evokeFacialHelper != null) {
            evokeFacialHelper.facialFinish();
        }
        EvokeFacialHelper evokeFacialHelper2 = this.mEvokeFacialHelper;
        String message = evokeFacialHelper2 != null ? evokeFacialHelper2.code2Message(errorCode, msg) : null;
        ToastHelper.showToastShort(getContext(), message);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View v, boolean hasFocus) {
        if (v == null) {
            return;
        }
        if (Intrinsics.areEqual(v, this.mName) && !hasFocus) {
            afterClearFocus(this.mName);
        }
        HandlerThreads.getHandler(0).postDelayed(this.hideInputRunnable, 200L);
    }

    private final void afterClearFocus(EditText view) {
        if (view == null) {
            return;
        }
        String content = view.getText().toString();
        this.isChecking = true;
        checkNameCardBlock(content, new BiliAuthNewNameFragment$afterClearFocus$1(view, this));
    }

    private final void checkNameCardBlock(String content, AuthBlockListener listener) {
        if (this.mEvokeFacialHelper != null) {
            String str = content;
            if (str == null || StringsKt.isBlank(str)) {
                AuthToastHelper authToastHelper = this.mAuthToastHelper;
                if (authToastHelper != null) {
                    authToastHelper.dismissLoading();
                }
                listener.isBlock(false);
                return;
            }
            this.mAuthBlockChecker.checkBlock(content, listener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideInputRunnable$lambda$0(BiliAuthNewNameFragment this$0) {
        EditText editText = this$0.mName;
        if ((editText == null || editText.isFocused()) ? false : true) {
            InputMethodManagerHelper.hideSoftInput(this$0.getActivity(), this$0.getView(), 0);
            Button button = this$0.mVerify;
            if (button != null) {
                button.setEnabled(this$0.checkContentValid());
            }
        }
    }
}