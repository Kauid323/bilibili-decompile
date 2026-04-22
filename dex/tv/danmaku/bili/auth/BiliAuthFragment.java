package tv.danmaku.bili.auth;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.app.auth.R;
import com.bilibili.droid.BundleUtil;
import com.bilibili.droid.H5UrlConfigHelper;
import com.bilibili.droid.InputMethodManagerHelper;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.biliid.api.BuvidHelper;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.facialrecognition.FacialParams;
import com.bilibili.lib.facialrecognition.FacialRecognitionHelper;
import com.bilibili.lib.facialrecognition.v2.FacialErrorInfo;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.ui.PermissionsChecker;
import com.bilibili.lib.ui.mixin.Flag;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.cb.AuthResultCbMsg;
import tv.danmaku.bili.quick.LoginQualityMonitor;
import tv.danmaku.bili.report.DefaultAuthReporter;

/* compiled from: BiliAuthFragment.kt */
@Metadata(d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u001c\u0018\u0000 c2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001cB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J&\u0010-\u001a\u0004\u0018\u00010\n2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00102\u001a\u00020\u0014H\u0002J\u0006\u00103\u001a\u00020*J\u0012\u00104\u001a\u00020*2\b\u00105\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u00106\u001a\u00020*2\b\u00107\u001a\u0004\u0018\u00010\u00192\u0006\u00108\u001a\u000209H\u0002J\u0012\u0010:\u001a\u00020*2\b\u0010;\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010<\u001a\u00020*2\b\u0010;\u001a\u0004\u0018\u00010\n2\u0006\u0010=\u001a\u00020\u0014H\u0016J\"\u0010@\u001a\u00020*2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020B2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u001a\u0010F\u001a\u00020*2\u0006\u00105\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010G\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010H\u001a\u00020*H\u0002J\u0012\u0010I\u001a\u00020*2\b\b\u0002\u0010J\u001a\u00020\u0014H\u0002J\b\u0010K\u001a\u00020*H\u0002J\b\u0010L\u001a\u00020*H\u0002J\b\u0010M\u001a\u00020*H\u0002J\b\u0010N\u001a\u00020\u0014H\u0002J\u0010\u0010O\u001a\u00020\u00142\u0006\u0010P\u001a\u00020\u0019H\u0002J\u0012\u0010R\u001a\u00020*2\b\u0010S\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010R\u001a\u00020*2\b\u0010S\u001a\u0004\u0018\u00010\u00192\u0006\u0010T\u001a\u00020\u0019H\u0016J\u0012\u0010U\u001a\u00020*2\b\u0010S\u001a\u0004\u0018\u00010\u0019H\u0002J\"\u0010V\u001a\u00020*2\u0006\u0010W\u001a\u00020B2\b\u0010X\u001a\u0004\u0018\u00010\u00192\u0006\u0010Y\u001a\u00020BH\u0016J\b\u0010Z\u001a\u00020*H\u0016J\b\u0010[\u001a\u00020*H\u0016J\b\u0010\\\u001a\u00020*H\u0016J\b\u0010]\u001a\u00020*H\u0016J\u0010\u0010^\u001a\u00020*2\u0006\u0010_\u001a\u00020`H\u0016J\u0010\u0010a\u001a\u00020*2\u0006\u0010_\u001a\u00020`H\u0016J\u0006\u0010b\u001a\u00020\u0014R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Ltv/danmaku/bili/auth/BiliAuthFragment;", "Ltv/danmaku/bili/auth/BaseAuthFragment;", "Lcom/bilibili/lib/facialrecognition/FacialRecognitionHelper$IFacialCallback;", "Landroid/view/View$OnFocusChangeListener;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "mEditName", "Landroid/widget/EditText;", "mNameLine", "Landroid/view/View;", "mEditCard", "mCardLine", "mAuthEnter", "mManualLayout", "mManualTv", "Landroid/widget/TextView;", "mFacial", "Lcom/bilibili/lib/facialrecognition/FacialRecognitionHelper;", "mFragmentShow", "", "mAuthBlockChecker", "Ltv/danmaku/bili/auth/AuthBlockChecker;", "permissions", "", "", "[Ljava/lang/String;", "mTextWatcher", "tv/danmaku/bili/auth/BiliAuthFragment$mTextWatcher$1", "Ltv/danmaku/bili/auth/BiliAuthFragment$mTextWatcher$1;", "mCheckBox", "Landroid/widget/CheckBox;", "mCheckBoxContainer", "mAgreementTips", "mSdkInit", "mDelayEnterAfterInit", "isAfter14", "isChecking", "mDelayEnterAfterCheck", "mTempCode", "isClick", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "isAgreementChecked", "clearFocus", "afterClearFocus", "view", "checkNameCardBlock", "content", "listener", "Ltv/danmaku/bili/auth/AuthBlockListener;", "onClick", "v", "onFocusChange", "hasFocus", "hideInputRunnable", "Ljava/lang/Runnable;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onViewCreated", "onViewStateRestored", "checkPermissionWhenEnter", "initFacial", "enter", "enterFacial", "enterFacialInternal", "showPermissionDialog", "contentValid", "cardValid", "card", "cacheTeenRequestId", "onSuccess", "requestID", "authCode", "toSuccessPage", "onFailure", "errorCode", AuthResultCbHelper.ARGS_MSG, "causeCode", "onInitSuccess", "onRequestStart", "onRequestEnd", "onDetectStart", "onFragmentShow", "lastFlag", "Lcom/bilibili/lib/ui/mixin/Flag;", "onFragmentHide", "isFragmentShow", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthFragment extends BaseAuthFragment implements FacialRecognitionHelper.IFacialCallback, View.OnFocusChangeListener, View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final String FAIL_14_AUTH = "fail_14_auth";
    public static final String FAIL_NOT_14 = "fail_not_14";
    public static final String KEY_FAIL = "key_fail";
    public static final String TAG = "Auth_BiliAuthFragment";
    private boolean isAfter14;
    private boolean isChecking;
    private boolean isClick;
    private TextView mAgreementTips;
    private View mAuthEnter;
    private View mCardLine;
    private CheckBox mCheckBox;
    private View mCheckBoxContainer;
    private boolean mDelayEnterAfterCheck;
    private boolean mDelayEnterAfterInit;
    private EditText mEditCard;
    private EditText mEditName;
    private FacialRecognitionHelper mFacial;
    private boolean mFragmentShow;
    private View mManualLayout;
    private TextView mManualTv;
    private View mNameLine;
    private boolean mSdkInit;
    private final AuthBlockChecker mAuthBlockChecker = new AuthBlockChecker();
    private final String[] permissions = {"android.permission.CAMERA"};
    private final BiliAuthFragment$mTextWatcher$1 mTextWatcher = new TextWatcher() { // from class: tv.danmaku.bili.auth.BiliAuthFragment$mTextWatcher$1
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            View view;
            boolean contentValid;
            boolean isAgreementChecked;
            boolean z = false;
            BiliAuthFragment.this.isClick = false;
            view = BiliAuthFragment.this.mAuthEnter;
            if (view != null) {
                contentValid = BiliAuthFragment.this.contentValid();
                if (contentValid) {
                    isAgreementChecked = BiliAuthFragment.this.isAgreementChecked();
                    if (isAgreementChecked) {
                        z = true;
                    }
                }
                view.setEnabled(z);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    };
    private String mTempCode = "";
    private final Runnable hideInputRunnable = new Runnable() { // from class: tv.danmaku.bili.auth.BiliAuthFragment$$ExternalSyntheticLambda5
        @Override // java.lang.Runnable
        public final void run() {
            BiliAuthFragment.hideInputRunnable$lambda$0(BiliAuthFragment.this);
        }
    };
    private String cacheTeenRequestId = "";

    public /* synthetic */ void onFailure(FacialErrorInfo facialErrorInfo) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onFailure(this, facialErrorInfo);
    }

    public /* synthetic */ void onSuccessForOverride(String str, String str2) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onSuccessForOverride(this, str, str2);
    }

    /* compiled from: BiliAuthFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/auth/BiliAuthFragment$Companion;", "", "<init>", "()V", "TAG", "", "KEY_FAIL", "FAIL_NOT_14", "FAIL_14_AUTH", "newInstance", "Ltv/danmaku/bili/auth/BiliAuthFragment;", "params", "Landroid/os/Bundle;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BiliAuthFragment newInstance(Bundle params) {
            BiliAuthFragment fragment = new BiliAuthFragment();
            if (params != null) {
                fragment.setArguments(params);
            }
            return fragment;
        }
    }

    private static boolean __Ghost$Insertion$com_bilibili_infra_base_aop_StoragePermissionHook_shouldShowRequestPermissionRationale(Activity activity, String permission) {
        String finalPerm = permission;
        if (Build.VERSION.SDK_INT >= 33) {
            if ("android.permission.READ_EXTERNAL_STORAGE".equals(permission)) {
                finalPerm = "android.permission.READ_MEDIA_IMAGES";
            } else if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(permission)) {
                return false;
            }
        }
        return Boolean.valueOf(ActivityCompat.shouldShowRequestPermissionRationale(activity, finalPerm)).booleanValue();
    }

    public void onCreate(Bundle savedInstanceState) {
        Intent intent;
        Intent intent2;
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        Bundle bundle = null;
        this.isAfter14 = BundleUtil.getBoolean((activity == null || (intent2 = activity.getIntent()) == null) ? null : intent2.getExtras(), BiliAuthConstants.BUNDLE_KEY_AFTER_14, new boolean[]{false});
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            bundle = intent.getExtras();
        }
        String string = BundleUtil.getString(bundle, BiliAuthConstants.BUNDLE_KEY_TEMP_CODE, new String[]{""});
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.mTempCode = string;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view2 = inflater.inflate(R.layout.fragment_auth, container, false);
        Intrinsics.checkNotNullExpressionValue(view2, "inflate(...)");
        this.mEditName = (EditText) view2.findViewById(R.id.edit_name);
        this.mEditCard = (EditText) view2.findViewById(R.id.edit_card);
        this.mNameLine = view2.findViewById(R.id.name_line);
        this.mCardLine = view2.findViewById(R.id.card_line);
        EditText editText = this.mEditName;
        if (editText != null) {
            editText.addTextChangedListener(this.mTextWatcher);
        }
        EditText editText2 = this.mEditName;
        if (editText2 != null) {
            editText2.setOnFocusChangeListener(this);
        }
        EditText editText3 = this.mEditCard;
        if (editText3 != null) {
            editText3.addTextChangedListener(this.mTextWatcher);
        }
        EditText editText4 = this.mEditCard;
        if (editText4 != null) {
            editText4.setOnFocusChangeListener(this);
        }
        this.mAuthEnter = view2.findViewById(R.id.btn_auth_enter);
        View view3 = this.mAuthEnter;
        if (view3 != null) {
            view3.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.auth.BiliAuthFragment$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    BiliAuthFragment.onCreateView$lambda$0(BiliAuthFragment.this, view4);
                }
            });
        }
        this.mManualLayout = view2.findViewById(R.id.manual_layout);
        if ((this.mTempCode.length() > 0) && (view = this.mManualLayout) != null) {
            view.setVisibility(4);
        }
        this.mManualTv = (TextView) view2.findViewById(R.id.tv_auth_manual);
        this.mCheckBoxContainer = view2.findViewById(R.id.facial_ag_checkbox_container);
        View view4 = this.mCheckBoxContainer;
        if (view4 != null) {
            view4.setOnClickListener(this);
        }
        this.mCheckBox = (CheckBox) view2.findViewById(R.id.facial_ag_checkbox);
        CheckBox checkBox = this.mCheckBox;
        if (checkBox != null) {
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.auth.BiliAuthFragment$$ExternalSyntheticLambda1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    BiliAuthFragment.onCreateView$lambda$1(BiliAuthFragment.this, compoundButton, z);
                }
            });
        }
        this.mAgreementTips = (TextView) view2.findViewById(R.id.tv_facial_agreement);
        TextView textView = this.mAgreementTips;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        return view2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(BiliAuthFragment this$0, View it) {
        it.requestFocus();
        Log.i(TAG, "isClick= " + this$0.isClick);
        if (!this$0.isClick) {
            this$0.isClick = true;
            this$0.checkPermissionWhenEnter();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1(BiliAuthFragment this$0, CompoundButton compoundButton, boolean isChecked) {
        boolean z = false;
        this$0.isClick = false;
        View view = this$0.mAuthEnter;
        if (view != null) {
            if (this$0.contentValid() && isChecked) {
                z = true;
            }
            view.setEnabled(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isAgreementChecked() {
        CheckBox checkBox = this.mCheckBox;
        if (checkBox != null) {
            return checkBox.isChecked();
        }
        return false;
    }

    public final void clearFocus() {
        EditText editText;
        EditText editText2;
        BLog.d(TAG, "clearFocus()");
        EditText editText3 = this.mEditName;
        boolean z = true;
        if ((editText3 != null && editText3.isFocused()) && (editText2 = this.mEditName) != null) {
            editText2.clearFocus();
        }
        EditText editText4 = this.mEditCard;
        if (editText4 == null || !editText4.isFocused()) {
            z = false;
        }
        if (z && (editText = this.mEditCard) != null) {
            editText.clearFocus();
        }
        View view = this.mAuthEnter;
        if (view != null) {
            view.requestFocus();
        }
    }

    private final void afterClearFocus(EditText view) {
        if (view == null) {
            return;
        }
        String content = view.getText().toString();
        this.isChecking = true;
        checkNameCardBlock(content, new BiliAuthFragment$afterClearFocus$1(this, view));
    }

    private final void checkNameCardBlock(String content, AuthBlockListener listener) {
        showLoading();
        String str = content;
        if (str == null || StringsKt.isBlank(str)) {
            dismissLoading();
            listener.isBlock(false);
            return;
        }
        this.mAuthBlockChecker.checkBlock(content, listener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer valueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.tv_facial_agreement;
        if (valueOf == null || valueOf.intValue() != i) {
            int i2 = R.id.facial_ag_checkbox_container;
            if (valueOf == null || valueOf.intValue() != i2) {
                return;
            }
        }
        CheckBox $this$onClick_u24lambda_u240 = this.mCheckBox;
        if ($this$onClick_u24lambda_u240 != null) {
            $this$onClick_u24lambda_u240.setChecked(!$this$onClick_u24lambda_u240.isChecked());
            if (!contentValid()) {
                HandlerThreads.getHandler(0).removeCallbacks(this.hideInputRunnable);
            }
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View v, boolean hasFocus) {
        if (v == null) {
            return;
        }
        if (Intrinsics.areEqual(v, this.mEditName)) {
            View view = this.mNameLine;
            if (view != null) {
                view.setSelected(hasFocus);
            }
            if (!hasFocus) {
                afterClearFocus(this.mEditName);
            }
        } else if (Intrinsics.areEqual(v, this.mEditCard)) {
            View view2 = this.mCardLine;
            if (view2 != null) {
                view2.setSelected(hasFocus);
            }
            if (!hasFocus) {
                afterClearFocus(this.mEditCard);
            }
        }
        HandlerThreads.getHandler(0).postDelayed(this.hideInputRunnable, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideInputRunnable$lambda$0(BiliAuthFragment this$0) {
        EditText editText = this$0.mEditName;
        boolean z = true;
        if ((editText == null || editText.isFocused()) ? false : true) {
            EditText editText2 = this$0.mEditCard;
            if (editText2 == null || editText2.isFocused()) {
                z = false;
            }
            if (z) {
                InputMethodManagerHelper.hideSoftInput(this$0.getActivity(), this$0.getView(), 0);
                View view = this$0.mAuthEnter;
                if (view != null) {
                    view.requestFocus();
                }
            }
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String stringExtra;
        super.onActivityResult(requestCode, resultCode, data);
        dismissLoading();
        BLog.i(TAG, "onActivityResult requestCode = " + requestCode);
        String str = "";
        switch (requestCode) {
            case 301:
                int result = data != null ? data.getIntExtra(BiliAuthConstants.AUTH_KEY_JS_RESULT, -200) : -200;
                int status = result > -200 ? result : -1;
                finishWithCallBack(new AuthResultCbMsg(status, ""));
                return;
            case 302:
                Activity requireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
                if (resultCode == -1) {
                    AuthResultCbHelper.setResultToActivityWithRequestId(requireActivity, 3, this.cacheTeenRequestId);
                    requireActivity.finish();
                    return;
                }
                if (data != null && (stringExtra = data.getStringExtra(KEY_FAIL)) != null) {
                    str = stringExtra;
                }
                boolean not14 = Intrinsics.areEqual(str, FAIL_NOT_14);
                if (not14) {
                    toSuccessPage(this.cacheTeenRequestId);
                    return;
                }
                AuthResultCbHelper.setResultToActivity(requireActivity, -1);
                requireActivity.finish();
                return;
            default:
                return;
        }
    }

    @Override // tv.danmaku.bili.auth.BaseAuthFragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        String manualUrl;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        String agreementUrl_facial = AuthAgreementLinkHelper.INSTANCE.getFacialAgreementLink();
        String agreementHighLight = getString(bili.resource.account.R.string.account_global_string_254);
        Intrinsics.checkNotNullExpressionValue(agreementHighLight, "getString(...)");
        AuthAgreementLinkHelper authAgreementLinkHelper = AuthAgreementLinkHelper.INSTANCE;
        TextView textView = this.mAgreementTips;
        String string = getString(bili.resource.account.R.string.account_global_string_264);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        authAgreementLinkHelper.attachContentLink(textView, string, agreementHighLight, agreementUrl_facial, FoundationAlias.getFapp().getResources().getColor(R.color.text_blue_kit), new LinkItemListener() { // from class: tv.danmaku.bili.auth.BiliAuthFragment$onViewCreated$1
            @Override // tv.danmaku.bili.auth.LinkItemListener
            public void onItemClick() {
                InputMethodManagerHelper.hideSoftInput(BiliAuthFragment.this.getActivity(), view, 0);
            }
        }, (r23 & 64) != 0 ? "" : null, (r23 & BR.cover) != 0 ? "" : null, (r23 & BR.hallEnterHotText) != 0 ? MapsKt.emptyMap() : null);
        String url = H5UrlConfigHelper.INSTANCE.getUrl("auth", "url_auth_identify_realname_default", BiliAuthConstants.AUTH_IDENTIFY_REALNAME_DEFAULT);
        if (url != null) {
            manualUrl = url;
        } else {
            manualUrl = BiliAuthConstants.AUTH_IDENTIFY_REALNAME_DEFAULT;
        }
        String manualHighLight = getString(bili.resource.account.R.string.account_global_string_286);
        Intrinsics.checkNotNullExpressionValue(manualHighLight, "getString(...)");
        AuthAgreementLinkHelper authAgreementLinkHelper2 = AuthAgreementLinkHelper.INSTANCE;
        TextView textView2 = this.mManualTv;
        String string2 = getString(bili.resource.account.R.string.account_global_string_255);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        authAgreementLinkHelper2.attachContentLink(textView2, string2, manualHighLight, manualUrl, FoundationAlias.getFapp().getResources().getColor(R.color.text_blue_kit), new LinkItemListener() { // from class: tv.danmaku.bili.auth.BiliAuthFragment$onViewCreated$2
            @Override // tv.danmaku.bili.auth.LinkItemListener
            public void onItemClick() {
                InputMethodManagerHelper.hideSoftInput(BiliAuthFragment.this.getActivity(), view, 0);
                DefaultAuthReporter.INSTANCE.reportManualCheckClick(BiliAuthFragment.this.sourceEvent());
            }
        }, (r23 & 64) != 0 ? "" : null, (r23 & BR.cover) != 0 ? "" : null, (r23 & BR.hallEnterHotText) != 0 ? MapsKt.emptyMap() : null);
        initFacial$default(this, false, 1, null);
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        BLog.i(TAG, "onViewStateRestored");
        if (savedInstanceState != null && contentValid()) {
            View view = this.mAuthEnter;
            if (view != null) {
                view.setEnabled(true);
            }
            View view2 = this.mAuthEnter;
            if (view2 != null) {
                view2.requestFocus();
            }
        }
    }

    private final void checkPermissionWhenEnter() {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        PermissionsChecker.grantPermission(activity, PermissionsChecker.getLifecycle(activity), PermissionsChecker.CAMERA_PERMISSION, 17, activity.getString(bili.resource.common.R.string.common_global_string_323)).continueWith(new Continuation() { // from class: tv.danmaku.bili.auth.BiliAuthFragment$$ExternalSyntheticLambda2
            public final Object then(Task task) {
                Unit checkPermissionWhenEnter$lambda$0;
                checkPermissionWhenEnter$lambda$0 = BiliAuthFragment.checkPermissionWhenEnter$lambda$0(BiliAuthFragment.this, task);
                return checkPermissionWhenEnter$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkPermissionWhenEnter$lambda$0(BiliAuthFragment this$0, Task it) {
        if (it.isCancelled() || it.isFaulted()) {
            BLog.e(TAG, "Permission check Not Pass, Check Show Storage Permission Alert.");
            this$0.showPermissionDialog();
        } else if (this$0.mSdkInit) {
            this$0.enterFacial();
        } else {
            this$0.initFacial(true);
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ void initFacial$default(BiliAuthFragment biliAuthFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        biliAuthFragment.initFacial(z);
    }

    private final void initFacial(boolean enter) {
        BLog.i(TAG, "initFacial enter = " + enter);
        Context context = getContext();
        if (context != null) {
            this.mDelayEnterAfterInit = enter;
            if (enter) {
                showLoading();
            }
            String accessKey = BiliAccounts.get(FoundationAlias.getFapp()).getAccessKey();
            if (accessKey == null) {
                accessKey = "";
            }
            this.mFacial = new FacialRecognitionHelper(context, accessKey, BuvidHelper.getBuvid(), this);
            FacialRecognitionHelper facialRecognitionHelper = this.mFacial;
            if (facialRecognitionHelper != null) {
                facialRecognitionHelper.init();
            }
        }
    }

    private final void enterFacial() {
        if (this.isChecking) {
            this.mDelayEnterAfterCheck = true;
            return;
        }
        EditText editText = this.mEditName;
        boolean z = false;
        if ((editText == null || editText.isFocused()) ? false : true) {
            EditText editText2 = this.mEditCard;
            if (editText2 != null && !editText2.isFocused()) {
                z = true;
            }
            if (z) {
                enterFacialInternal();
                return;
            }
        }
        this.mDelayEnterAfterCheck = true;
        clearFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enterFacialInternal() {
        Editable text;
        String obj;
        Editable text2;
        if (!contentValid()) {
            ToastHelper.showToastShort(getActivity(), "请输入完整信息！");
        } else if (this.mFacial == null) {
            ToastHelper.showToastShort(getActivity(), "初始化失败！");
        } else {
            DefaultAuthReporter.INSTANCE.reportEnterFaceClick(sourceEvent());
            EditText editText = this.mEditName;
            String card = "";
            String name = (editText == null || (text2 = editText.getText()) == null || (name = text2.toString()) == null) ? "" : "";
            EditText editText2 = this.mEditCard;
            if (editText2 != null && (text = editText2.getText()) != null && (obj = text.toString()) != null) {
                card = obj;
            }
            setUserInfo(name, card);
            BLog.i(TAG, "enterFacial " + this.isAfter14);
            FacialParams mFacialParams = new FacialParams(name, card, this.mTempCode, sourceEvent(), this.isAfter14, (String) null, (String) null, 96, (DefaultConstructorMarker) null);
            if (this.mTempCode.length() > 0) {
                FacialRecognitionHelper facialRecognitionHelper = this.mFacial;
                if (facialRecognitionHelper == null) {
                    return;
                }
                mFacialParams.setBizType("facialcontrol");
                facialRecognitionHelper.beginDetect(mFacialParams);
            } else if (this.isAfter14) {
                FacialRecognitionHelper facialRecognitionHelper2 = this.mFacial;
                if (facialRecognitionHelper2 == null) {
                    return;
                }
                mFacialParams.setBizType("teen");
                facialRecognitionHelper2.beginDetect(mFacialParams);
            } else {
                FacialRecognitionHelper facialRecognitionHelper3 = this.mFacial;
                if (facialRecognitionHelper3 != null) {
                    facialRecognitionHelper3.beginDetect(mFacialParams);
                }
            }
        }
    }

    private final void showPermissionDialog() {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        boolean showRequest = __Ghost$Insertion$com_bilibili_infra_base_aop_StoragePermissionHook_shouldShowRequestPermissionRationale(activity, "android.permission.CAMERA");
        if (!showRequest) {
            PermissionsChecker.showPermissionSettingAlert(activity, FoundationAlias.getFapp().getString(bili.resource.account.R.string.account_global_string_476), FoundationAlias.getFapp().getString(bili.resource.account.R.string.account_global_string_477), new PermissionsChecker.PermissionSettingAlertEventListener() { // from class: tv.danmaku.bili.auth.BiliAuthFragment$showPermissionDialog$1
                public void onCancelClick(AlertDialog dialog) {
                }

                public void onSettingClick(AlertDialog dialog) {
                }

                public void onShow(AlertDialog dialog) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean contentValid() {
        boolean z;
        boolean z2;
        Editable text;
        String obj;
        Editable text2;
        String obj2;
        EditText editText = this.mEditName;
        if (editText != null && (text2 = editText.getText()) != null && (obj2 = text2.toString()) != null) {
            if (obj2.length() > 0) {
                z = true;
                if (z) {
                    EditText editText2 = this.mEditCard;
                    if (editText2 != null && (text = editText2.getText()) != null && (obj = text.toString()) != null) {
                        if (obj.length() > 0) {
                            z2 = true;
                            if (z2) {
                                EditText editText3 = this.mEditCard;
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

    public void onSuccess(final String requestID) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onSuccess(this, requestID);
        this.cacheTeenRequestId = "";
        moveToFrontIfNeed();
        if (isAdded()) {
            HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.BiliAuthFragment$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    BiliAuthFragment.onSuccess$lambda$0(requestID, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSuccess$lambda$0(String $requestID, BiliAuthFragment this$0) {
        Intent intent;
        BLog.i(TAG, "FacialRecognition::onSuccess, requestId = " + $requestID);
        this$0.dismissLoading();
        FragmentActivity activity = this$0.getActivity();
        if (BundleUtil.getBoolean((activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras(), BiliAuthConstants.BUNDLE_KEY_AFTER_14, new boolean[]{false})) {
            this$0.cacheTeenRequestId = $requestID == null ? "" : $requestID;
            BLRouter.routeTo(new RouteRequest.Builder("bilibili://main/teenagersmode/guardian-bind").requestCode(302).build(), (Fragment) this$0);
            return;
        }
        this$0.toSuccessPage($requestID);
    }

    public void onSuccess(final String requestID, final String authCode) {
        Intrinsics.checkNotNullParameter(authCode, "authCode");
        this.cacheTeenRequestId = "";
        BLog.i(TAG, "FacialRecognition:: onSuccess authCode, requestId = " + requestID);
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.BiliAuthFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthFragment.onSuccess$lambda$1(BiliAuthFragment.this, requestID, authCode);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSuccess$lambda$1(BiliAuthFragment this$0, String $requestID, String $authCode) {
        this$0.dismissLoading();
        this$0.setAuthStatus(1, $requestID);
        this$0.successForLogin($authCode, $requestID);
    }

    private final void toSuccessPage(final String requestID) {
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.BiliAuthFragment$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthFragment.toSuccessPage$lambda$0(BiliAuthFragment.this, requestID);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void toSuccessPage$lambda$0(BiliAuthFragment this$0, String $requestID) {
        BLog.i(TAG, "FacialRecognition::toSuccessPage");
        this$0.dismissLoading();
        this$0.setAuthStatus(1, $requestID);
        Bundle bundle = new Bundle();
        Pair userInfo = this$0.getUserInfo(true);
        if (userInfo != null) {
            bundle.putString("key_real_name", (String) userInfo.getFirst());
            bundle.putString("key_card", (String) userInfo.getSecond());
        }
        this$0.toFragment(1, bundle, (Fragment) this$0);
    }

    public void onFailure(final int errorCode, final String msg, final int causeCode) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onFailure(this, errorCode, msg, causeCode);
        moveToFrontIfNeed();
        if (isAdded()) {
            HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.BiliAuthFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    BiliAuthFragment.onFailure$lambda$0(errorCode, msg, causeCode, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFailure$lambda$0(int $errorCode, String $msg, int $causeCode, BiliAuthFragment this$0) {
        String message;
        BLog.i(TAG, "FacialRecognition::onFailure::errorCode = " + $errorCode + ", msg = " + $msg + ", causeCode = " + $causeCode);
        this$0.dismissLoading();
        switch ($errorCode) {
            case 1:
                message = this$0.getString(R.string.auth_sdk_init_fail);
                break;
            case 2:
            case 5:
            case 6:
            default:
                if ($msg != null) {
                    message = $msg;
                    break;
                } else {
                    message = this$0.getString(bili.resource.account.R.string.account_global_string_434);
                    Intrinsics.checkNotNullExpressionValue(message, "getString(...)");
                    break;
                }
            case 3:
            case 4:
                message = this$0.getString(bili.resource.account.R.string.account_global_string_434);
                break;
            case 7:
                message = FoundationAlias.getFapp().getString(bili.resource.account.R.string.account_global_string_465);
                break;
        }
        Intrinsics.checkNotNull(message);
        if ($errorCode < 5 || $errorCode == 7) {
            ToastHelper.showToastShort(this$0.getContext(), message);
            return;
        }
        this$0.setAuthErrorMsg(message, $causeCode);
        this$0.setAuthStatus(2, LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR);
        Bundle bundle = new Bundle();
        bundle.putString("key_fail_msg", $msg == null ? "" : $msg);
        bundle.putInt("key_error_code", $causeCode);
        Pair userInfo = BaseAuthFragment.getUserInfo$default(this$0, false, 1, null);
        if (userInfo != null) {
            bundle.putString("key_real_name", (String) userInfo.getFirst());
            bundle.putString("key_card", (String) userInfo.getSecond());
        }
        this$0.toFragment(2, bundle, (Fragment) this$0);
    }

    public void onInitSuccess() {
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.BiliAuthFragment$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthFragment.onInitSuccess$lambda$0(BiliAuthFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitSuccess$lambda$0(BiliAuthFragment this$0) {
        BLog.i(TAG, "FacialRecognition::onInitSuccess");
        this$0.dismissLoading();
        this$0.mSdkInit = true;
        if (this$0.mDelayEnterAfterInit) {
            this$0.mDelayEnterAfterInit = false;
            this$0.enterFacial();
        }
    }

    public void onRequestStart() {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onRequestStart(this);
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.BiliAuthFragment$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthFragment.onRequestStart$lambda$0(BiliAuthFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRequestStart$lambda$0(BiliAuthFragment this$0) {
        BLog.i(TAG, "FacialRecognition::onRequestStart");
        this$0.showLoading();
    }

    public void onRequestEnd() {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onRequestEnd(this);
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.BiliAuthFragment$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthFragment.onRequestEnd$lambda$0(BiliAuthFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRequestEnd$lambda$0(BiliAuthFragment this$0) {
        BLog.i(TAG, "FacialRecognition::onRequestEnd");
        this$0.dismissLoading();
    }

    public void onDetectStart() {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onDetectStart(this);
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.BiliAuthFragment$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthFragment.onDetectStart$lambda$0(BiliAuthFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDetectStart$lambda$0(BiliAuthFragment this$0) {
        BLog.i(TAG, "FacialRecognition::onDetectStart");
        DefaultAuthReporter.INSTANCE.reportFaceScanShow(this$0.sourceEvent());
    }

    public void onFragmentShow(Flag lastFlag) {
        Intrinsics.checkNotNullParameter(lastFlag, "lastFlag");
        super.onFragmentShow(lastFlag);
        DefaultAuthReporter.INSTANCE.reportFaceCheckShow(sourceEvent());
        this.mFragmentShow = true;
        this.isClick = false;
    }

    public void onFragmentHide(Flag lastFlag) {
        Intrinsics.checkNotNullParameter(lastFlag, "lastFlag");
        super.onFragmentHide(lastFlag);
        this.mFragmentShow = false;
    }

    public final boolean isFragmentShow() {
        return this.mFragmentShow;
    }
}