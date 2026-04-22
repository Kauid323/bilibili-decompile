package tv.danmaku.bili.auth.modify;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import com.bilibili.app.auth.R;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.droid.InputMethodManagerHelper;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.facialrecognition.FacialRecognitionHelper;
import com.bilibili.lib.facialrecognition.v2.FacialErrorInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.AuthBlockChecker;
import tv.danmaku.bili.auth.BiliAuthFragment;
import tv.danmaku.bili.auth.helper.AuthToastHelper;
import tv.danmaku.bili.auth.helper.EvokeFacialHelper;
import tv.danmaku.bili.auth.helper.ReasonType;
import tv.danmaku.bili.auth.helper.RequestChangePersonListener;
import tv.danmaku.bili.auth.helper.RequestFacialData;
import tv.danmaku.bili.auth.helper.SceneType;
import tv.danmaku.bili.auth.v2.BiliAuditingFragmentV2;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: BiliAuthModifyNewPersonFragment.kt */
@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001 \u0018\u0000 H2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001HB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020\fH\u0002J\u0010\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u0016H\u0002J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0006\u00100\u001a\u00020.J\u001a\u00101\u001a\u00020.2\b\u00102\u001a\u0004\u0018\u00010#2\u0006\u00103\u001a\u00020\fH\u0016J\b\u00106\u001a\u00020.H\u0002J\u0012\u00107\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u00108\u001a\u00020.H\u0002J\b\u00109\u001a\u00020.H\u0016J\u0012\u0010:\u001a\u00020.2\b\u0010;\u001a\u0004\u0018\u00010\u0016H\u0016J\"\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020\u00192\b\u0010>\u001a\u0004\u0018\u00010\u00162\u0006\u0010?\u001a\u00020\u0019H\u0016J\b\u0010@\u001a\u00020.H\u0016J\b\u0010A\u001a\u00020.H\u0016J\u0012\u0010C\u001a\u00020\f2\b\u0010D\u001a\u0004\u0018\u00010\u0016H\u0002J\u0017\u0010E\u001a\u00020\u00162\b\u0010F\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010GR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u001cj\b\u0012\u0004\u0012\u00020\u0016`\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthModifyNewPersonFragment;", "Ltv/danmaku/bili/auth/modify/BaseAuthModifyFragment;", "Landroid/view/View$OnFocusChangeListener;", "Lcom/bilibili/lib/facialrecognition/FacialRecognitionHelper$IFacialCallback;", "<init>", "()V", "mName", "Landroid/widget/EditText;", "mCard", "mEnter", "Landroid/widget/Button;", "isClick", "", "isNameChecked", "isCardChecked", "mAuthToastHelper", "Ltv/danmaku/bili/auth/helper/AuthToastHelper;", "mEvokeFacialHelper", "Ltv/danmaku/bili/auth/helper/EvokeFacialHelper;", "mAuthBlockChecker", "Ltv/danmaku/bili/auth/AuthBlockChecker;", "mToken_old", "", "mToken_new", "mReason", "", "Ljava/lang/Integer;", "mImg_token_list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mImgMinNum", "mTextWatcher", "tv/danmaku/bili/auth/modify/BiliAuthModifyNewPersonFragment$mTextWatcher$1", "Ltv/danmaku/bili/auth/modify/BiliAuthModifyNewPersonFragment$mTextWatcher$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "checkContentVolid", "cardValid", "card", "onViewCreated", "", "view", "handleArgument", "onFocusChange", "v", "hasFocus", "hideInputRunnable", "Ljava/lang/Runnable;", "beforeFacial", "checkNameCardBlock", "checkBlockFinish", "onInitSuccess", "onSuccess", "requestID", "onFailure", "errorCode", AuthResultCbHelper.ARGS_MSG, "causeCode", "onRequestStart", "onRequestEnd", "BUNDLE_KEY_MODIFY_TIPS", "requestChangePerson", "token_new", "reasonToText", "reason", "(Ljava/lang/Integer;)Ljava/lang/String;", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthModifyNewPersonFragment extends BaseAuthModifyFragment implements View.OnFocusChangeListener, FacialRecognitionHelper.IFacialCallback {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "BiliAuthNewNameFragment";
    private boolean isCardChecked;
    private boolean isClick;
    private boolean isNameChecked;
    private AuthToastHelper mAuthToastHelper;
    private EditText mCard;
    private Button mEnter;
    private EvokeFacialHelper mEvokeFacialHelper;
    private EditText mName;
    private final AuthBlockChecker mAuthBlockChecker = new AuthBlockChecker();
    private String mToken_old = "";
    private String mToken_new = "";
    private Integer mReason = 0;
    private ArrayList<String> mImg_token_list = new ArrayList<>();
    private int mImgMinNum = 7;
    private final BiliAuthModifyNewPersonFragment$mTextWatcher$1 mTextWatcher = new TextWatcher() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyNewPersonFragment$mTextWatcher$1
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            Button button;
            boolean checkContentVolid;
            BiliAuthModifyNewPersonFragment.this.isClick = false;
            button = BiliAuthModifyNewPersonFragment.this.mEnter;
            if (button != null) {
                checkContentVolid = BiliAuthModifyNewPersonFragment.this.checkContentVolid();
                button.setEnabled(checkContentVolid);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    };
    private final Runnable hideInputRunnable = new Runnable() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyNewPersonFragment$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            BiliAuthModifyNewPersonFragment.hideInputRunnable$lambda$0(BiliAuthModifyNewPersonFragment.this);
        }
    };
    private final String BUNDLE_KEY_MODIFY_TIPS = "key_modify_seccess";

    public /* synthetic */ void onDetectStart() {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onDetectStart(this);
    }

    public /* synthetic */ void onFailure(FacialErrorInfo facialErrorInfo) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onFailure(this, facialErrorInfo);
    }

    public /* synthetic */ void onSuccess(String str, String str2) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onSuccess(this, str, str2);
    }

    public /* synthetic */ void onSuccessForOverride(String str, String str2) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onSuccessForOverride(this, str, str2);
    }

    /* compiled from: BiliAuthModifyNewPersonFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthModifyNewPersonFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Ltv/danmaku/bili/auth/modify/BiliAuthModifyNewPersonFragment;", "params", "Landroid/os/Bundle;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BiliAuthModifyNewPersonFragment newInstance(Bundle params) {
            BiliAuthModifyNewPersonFragment fragment = new BiliAuthModifyNewPersonFragment();
            if (params != null) {
                fragment.setArguments(params);
            }
            return fragment;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view = inflater.inflate(R.layout.fragment_auth_modify_new_info, container, false);
        Intrinsics.checkNotNullExpressionValue(view, "inflate(...)");
        this.mEvokeFacialHelper = new EvokeFacialHelper(getContext());
        this.mAuthToastHelper = new AuthToastHelper(requireHostActivity());
        this.mName = (EditText) view.findViewById(R.id.edit_new_name);
        this.mCard = (EditText) view.findViewById(R.id.edit_new_card);
        EditText editText = this.mName;
        if (editText != null) {
            editText.addTextChangedListener(this.mTextWatcher);
        }
        EditText editText2 = this.mName;
        if (editText2 != null) {
            editText2.setOnFocusChangeListener(this);
        }
        EditText editText3 = this.mCard;
        if (editText3 != null) {
            editText3.addTextChangedListener(this.mTextWatcher);
        }
        EditText editText4 = this.mCard;
        if (editText4 != null) {
            editText4.setOnFocusChangeListener(this);
        }
        this.mEnter = (Button) view.findViewById(R.id.btn_auth_enter);
        Button button = this.mEnter;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyNewPersonFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BiliAuthModifyNewPersonFragment.onCreateView$lambda$0(BiliAuthModifyNewPersonFragment.this, view2);
                }
            });
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(BiliAuthModifyNewPersonFragment this$0, View it) {
        if (this$0.checkContentVolid() && !this$0.isClick) {
            EditText editText = this$0.mName;
            if (editText != null) {
                editText.clearFocus();
            }
            EditText editText2 = this$0.mCard;
            if (editText2 != null) {
                editText2.clearFocus();
            }
            this$0.beforeFacial();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean checkContentVolid() {
        boolean z;
        boolean z2;
        Editable text;
        String obj;
        Editable text2;
        String obj2;
        EditText editText = this.mName;
        if (editText != null && (text2 = editText.getText()) != null && (obj2 = text2.toString()) != null) {
            if (obj2.length() > 0) {
                z = true;
                if (z) {
                    EditText editText2 = this.mCard;
                    if (editText2 != null && (text = editText2.getText()) != null && (obj = text.toString()) != null) {
                        if (obj.length() > 0) {
                            z2 = true;
                            if (z2) {
                                EditText editText3 = this.mCard;
                                if (cardValid(String.valueOf(editText3 != null ? editText3.getText() : null))) {
                                    return true;
                                }
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                    }
                }
                return false;
            }
        }
        z = false;
        if (z) {
        }
        return false;
    }

    private final boolean cardValid(String card) {
        Regex regexCard = new Regex("^\\d{15}$|^\\d{17}[0-9Xx]$");
        return regexCard.matches(card);
    }

    @Override // tv.danmaku.bili.auth.modify.BaseAuthModifyFragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        refreshUi();
        handleArgument();
    }

    public final void handleArgument() {
        ArrayList<String> arrayList;
        Bundle bundle = getArguments();
        this.mToken_old = (bundle == null || (r1 = bundle.getString(getBUNDLE_KEY_REQUEST_ID$auth_debug())) == null) ? "" : "";
        this.mReason = Integer.valueOf(bundle != null ? bundle.getInt(getBUNDLE_KEY_MODIFY_REASON$auth_debug()) : 0);
        if (bundle == null || (arrayList = bundle.getStringArrayList(getBUNDLE_KEY_PHOTOS$auth_debug())) == null) {
            arrayList = new ArrayList<>();
        }
        this.mImg_token_list = arrayList;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View v, boolean hasFocus) {
        if (v == null) {
            return;
        }
        if (Intrinsics.areEqual(v, this.mName)) {
            if (!hasFocus) {
                this.isNameChecked = false;
            }
        } else if (Intrinsics.areEqual(v, this.mCard) && !hasFocus) {
            this.isCardChecked = false;
        }
        HandlerThreads.getHandler(0).postDelayed(this.hideInputRunnable, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideInputRunnable$lambda$0(BiliAuthModifyNewPersonFragment this$0) {
        EditText editText = this$0.mName;
        boolean z = true;
        if ((editText == null || editText.isFocused()) ? false : true) {
            EditText editText2 = this$0.mCard;
            if (editText2 == null || editText2.isFocused()) {
                z = false;
            }
            if (z) {
                InputMethodManagerHelper.hideSoftInput(this$0.getActivity(), this$0.getView(), 0);
                Button button = this$0.mEnter;
                if (button != null) {
                    button.setEnabled(this$0.checkContentVolid());
                }
            }
        }
    }

    private final void beforeFacial() {
        AuthToastHelper authToastHelper = this.mAuthToastHelper;
        if (authToastHelper != null) {
            AuthToastHelper.showLoading$default(authToastHelper, null, 1, null);
        }
        checkBlockFinish();
    }

    private final void checkNameCardBlock(EditText view) {
        String content = String.valueOf(view != null ? view.getText() : null);
        String str = content;
        if (str == null || StringsKt.isBlank(str)) {
            AuthToastHelper authToastHelper = this.mAuthToastHelper;
            if (authToastHelper != null) {
                authToastHelper.dismissLoading();
                return;
            }
            return;
        }
        this.mAuthBlockChecker.checkBlock(content, new BiliAuthModifyNewPersonFragment$checkNameCardBlock$1(this, view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkBlockFinish() {
        if (!this.isNameChecked) {
            checkNameCardBlock(this.mName);
        } else if (!this.isCardChecked) {
            checkNameCardBlock(this.mCard);
        } else {
            AuthToastHelper authToastHelper = this.mAuthToastHelper;
            if (authToastHelper != null) {
                authToastHelper.dismissLoading();
            }
            EvokeFacialHelper $this$checkBlockFinish_u24lambda_u240 = this.mEvokeFacialHelper;
            if ($this$checkBlockFinish_u24lambda_u240 != null) {
                $this$checkBlockFinish_u24lambda_u240.setMDelayEnter(false);
                this.isClick = true;
                $this$checkBlockFinish_u24lambda_u240.setFacialListener(this);
                EditText editText = this.mName;
                String valueOf = String.valueOf(editText != null ? editText.getText() : null);
                EditText editText2 = this.mCard;
                $this$checkBlockFinish_u24lambda_u240.startFacial(new RequestFacialData(valueOf, String.valueOf(editText2 != null ? editText2.getText() : null), "verify", SceneType.REALNAMEVERIFY, sourceEvent()), (Activity) requireHostActivity());
            }
        }
    }

    public void onInitSuccess() {
        Activity requireActivity;
        Context context = getContext();
        if (context == null || (requireActivity = ContextUtilKt.requireActivity(context)) == null) {
            return;
        }
        requireActivity.runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyNewPersonFragment$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthModifyNewPersonFragment.onInitSuccess$lambda$0(BiliAuthModifyNewPersonFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitSuccess$lambda$0(BiliAuthModifyNewPersonFragment this$0) {
        BLog.i(BiliAuthFragment.TAG, "FacialRecognition::onInitSuccess");
        AuthToastHelper authToastHelper = this$0.mAuthToastHelper;
        if (authToastHelper != null) {
            authToastHelper.dismissLoading();
        }
        EvokeFacialHelper $this$onInitSuccess_u24lambda_u240_u240 = this$0.mEvokeFacialHelper;
        if ($this$onInitSuccess_u24lambda_u240_u240 != null) {
            $this$onInitSuccess_u24lambda_u240_u240.setMFacialInit(true);
            $this$onInitSuccess_u24lambda_u240_u240.enterFacial();
        }
    }

    public void onSuccess(String requestID) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onSuccess(this, requestID);
        EvokeFacialHelper evokeFacialHelper = this.mEvokeFacialHelper;
        if (evokeFacialHelper != null) {
            evokeFacialHelper.facialFinish();
        }
        this.isClick = false;
        ToastHelper.showToastShort(getContext(), bili.resource.account.R.string.account_global_string_322);
        requestChangePerson(requestID);
    }

    public void onFailure(final int errorCode, final String msg, int causeCode) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onFailure(this, errorCode, msg, causeCode);
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyNewPersonFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthModifyNewPersonFragment.onFailure$lambda$0(BiliAuthModifyNewPersonFragment.this, errorCode, msg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFailure$lambda$0(BiliAuthModifyNewPersonFragment this$0, int $errorCode, String $msg) {
        this$0.isClick = false;
        String str = "";
        EvokeFacialHelper $this$onFailure_u24lambda_u240_u240 = this$0.mEvokeFacialHelper;
        if ($this$onFailure_u24lambda_u240_u240 != null) {
            $this$onFailure_u24lambda_u240_u240.facialFinish();
            str = $this$onFailure_u24lambda_u240_u240.code2Message($errorCode, $msg);
        }
        ToastHelper.showToastShort(this$0.getContext(), str);
    }

    public void onRequestStart() {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onRequestStart(this);
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyNewPersonFragment$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthModifyNewPersonFragment.onRequestStart$lambda$0(BiliAuthModifyNewPersonFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRequestStart$lambda$0(BiliAuthModifyNewPersonFragment this$0) {
        EvokeFacialHelper evokeFacialHelper = this$0.mEvokeFacialHelper;
        if (evokeFacialHelper != null) {
            evokeFacialHelper.facialFinish();
        }
    }

    public void onRequestEnd() {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onRequestEnd(this);
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyNewPersonFragment$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthModifyNewPersonFragment.onRequestEnd$lambda$0(BiliAuthModifyNewPersonFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRequestEnd$lambda$0(BiliAuthModifyNewPersonFragment this$0) {
        this$0.isClick = false;
        EvokeFacialHelper evokeFacialHelper = this$0.mEvokeFacialHelper;
        if (evokeFacialHelper != null) {
            evokeFacialHelper.facialFinish();
        }
    }

    private final boolean requestChangePerson(String token_new) {
        Integer num = this.mReason;
        int value = ReasonType.NONE.getValue();
        if ((num != null && num.intValue() == value) || this.mImg_token_list.isEmpty() || this.mImg_token_list.size() < this.mImgMinNum) {
            return false;
        }
        getMModifyHelper().requestChangePerson(token_new, this.mToken_old, reasonToText(this.mReason), this.mImg_token_list, new RequestChangePersonListener() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyNewPersonFragment$requestChangePerson$1
            @Override // tv.danmaku.bili.auth.helper.RequestChangePersonListener
            public void OnSuccess() {
                BiliAuthModifyNewPersonFragment.this.showFragmentWithBundle(BiliAuthModifyNewPersonFragment.this.getContext(), BiliAuthModifyNewPersonFragment.this.getArguments(), (Fragment) BiliAuthModifyNewPersonFragment.this, BiliAuthModifyNewPersonFragment.this.getURL_BILI_AUTH_MODIFY_APPLYING$auth_debug(), BiliAuditingFragmentV2.TAG);
            }

            @Override // tv.danmaku.bili.auth.helper.RequestChangePersonListener
            public void onError(String msg) {
                ToastHelper.showToastShort(BiliAuthModifyNewPersonFragment.this.getContext(), msg);
            }
        });
        return false;
    }

    private final String reasonToText(Integer reason) {
        if (reason != null && reason.intValue() == 1) {
            String result = getString(bili.resource.account.R.string.account_global_string_202);
            Intrinsics.checkNotNullExpressionValue(result, "getString(...)");
            return result;
        } else if (reason == null || reason.intValue() != 2) {
            return "";
        } else {
            String result2 = getString(bili.resource.account.R.string.account_global_string_219);
            Intrinsics.checkNotNullExpressionValue(result2, "getString(...)");
            return result2;
        }
    }
}