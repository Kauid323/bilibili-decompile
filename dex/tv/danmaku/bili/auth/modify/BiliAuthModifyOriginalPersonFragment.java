package tv.danmaku.bili.auth.modify;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bilibili.app.auth.R;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.facialrecognition.FacialRecognitionHelper;
import com.bilibili.lib.facialrecognition.v2.FacialErrorInfo;
import com.bilibili.lib.ui.mixin.Flag;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.BiliAuthFragment;
import tv.danmaku.bili.auth.helper.EvokeFacialHelper;
import tv.danmaku.bili.auth.helper.RequestFacialData;
import tv.danmaku.bili.auth.helper.SceneType;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: BiliAuthModifyOriginalPersonFragment.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u0012\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\r2\u0006\u0010$\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthModifyOriginalPersonFragment;", "Ltv/danmaku/bili/auth/modify/BaseAuthModifyFragment;", "Lcom/bilibili/lib/facialrecognition/FacialRecognitionHelper$IFacialCallback;", "<init>", "()V", "mNameTv", "Landroid/widget/TextView;", "mCardTv", "mEnter", "Landroid/widget/Button;", "isClick", "", "mName", "", "mCard", "mEvokeFacialHelper", "Ltv/danmaku/bili/auth/helper/EvokeFacialHelper;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "refreshUi", "onInitSuccess", "onSuccess", "requestID", "onFailure", "errorCode", "", AuthResultCbHelper.ARGS_MSG, "causeCode", "onFragmentShow", "lastFlag", "Lcom/bilibili/lib/ui/mixin/Flag;", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthModifyOriginalPersonFragment extends BaseAuthModifyFragment implements FacialRecognitionHelper.IFacialCallback {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "BiliAuthNewNameFragment";
    private boolean isClick;
    private TextView mCardTv;
    private Button mEnter;
    private EvokeFacialHelper mEvokeFacialHelper;
    private TextView mNameTv;
    private String mName = "";
    private String mCard = "";

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

    /* compiled from: BiliAuthModifyOriginalPersonFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthModifyOriginalPersonFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Ltv/danmaku/bili/auth/modify/BiliAuthModifyOriginalPersonFragment;", "params", "Landroid/os/Bundle;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BiliAuthModifyOriginalPersonFragment newInstance(Bundle params) {
            BiliAuthModifyOriginalPersonFragment fragment = new BiliAuthModifyOriginalPersonFragment();
            if (params != null) {
                fragment.setArguments(params);
            }
            return fragment;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view = inflater.inflate(R.layout.fragment_auth_modify_original_confim, container, false);
        Intrinsics.checkNotNullExpressionValue(view, "inflate(...)");
        this.mEvokeFacialHelper = new EvokeFacialHelper(getContext());
        this.mNameTv = (TextView) view.findViewById(R.id.name);
        this.mCardTv = (TextView) view.findViewById(R.id.card);
        this.mEnter = (Button) view.findViewById(R.id.btn_auth_enter);
        Button button = this.mEnter;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyOriginalPersonFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BiliAuthModifyOriginalPersonFragment.onCreateView$lambda$0(BiliAuthModifyOriginalPersonFragment.this, view2);
                }
            });
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(BiliAuthModifyOriginalPersonFragment this$0, View it) {
        EvokeFacialHelper evokeFacialHelper = this$0.mEvokeFacialHelper;
        if (evokeFacialHelper != null) {
            evokeFacialHelper.setFacialListener(this$0);
        }
        if (!this$0.isClick) {
            this$0.isClick = true;
            EvokeFacialHelper $this$onCreateView_u24lambda_u240_u240 = this$0.mEvokeFacialHelper;
            if ($this$onCreateView_u24lambda_u240_u240 != null) {
                $this$onCreateView_u24lambda_u240_u240.setMDelayEnter(false);
                $this$onCreateView_u24lambda_u240_u240.startFacial(new RequestFacialData(this$0.mName, this$0.mCard, "realnameVerify", SceneType.REALNAMEVERIFY, this$0.sourceEvent()), (Activity) this$0.requireHostActivity());
            }
        }
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
            String name = extra.getString("key_real_name");
            if (name == null) {
                name = "";
            }
            String string = extra.getString("key_card");
            String card = string != null ? string : "";
            TextView textView = this.mNameTv;
            if (textView != null) {
                textView.setText(name);
            }
            TextView textView2 = this.mCardTv;
            if (textView2 != null) {
                textView2.setText(card);
            }
            this.mName = name;
            this.mCard = card;
        }
    }

    public void onInitSuccess() {
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyOriginalPersonFragment$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthModifyOriginalPersonFragment.onInitSuccess$lambda$0(BiliAuthModifyOriginalPersonFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitSuccess$lambda$0(BiliAuthModifyOriginalPersonFragment this$0) {
        BLog.i(BiliAuthFragment.TAG, "FacialRecognition::onInitSuccess");
        EvokeFacialHelper $this$onInitSuccess_u24lambda_u240_u240 = this$0.mEvokeFacialHelper;
        if ($this$onInitSuccess_u24lambda_u240_u240 != null) {
            $this$onInitSuccess_u24lambda_u240_u240.setMFacialInit(true);
            $this$onInitSuccess_u24lambda_u240_u240.enterFacial();
        }
    }

    public void onSuccess(final String requestID) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onSuccess(this, requestID);
        this.isClick = false;
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyOriginalPersonFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthModifyOriginalPersonFragment.onSuccess$lambda$0(BiliAuthModifyOriginalPersonFragment.this, requestID);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSuccess$lambda$0(BiliAuthModifyOriginalPersonFragment this$0, String $requestID) {
        EvokeFacialHelper evokeFacialHelper = this$0.mEvokeFacialHelper;
        if (evokeFacialHelper != null) {
            evokeFacialHelper.facialFinish();
        }
        ToastHelper.showToastShort(this$0.getContext(), bili.resource.account.R.string.account_global_string_322);
        Bundle bundle = this$0.getArguments();
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(this$0.getBUNDLE_KEY_REQUEST_ID$auth_debug(), $requestID);
        this$0.showFragmentWithBundle(this$0.getContext(), bundle, (Fragment) this$0, this$0.getURL_BILI_AUTH_MODIFY_PERSON_NEW$auth_debug(), "BiliAuthModifySuccessFragment");
    }

    public void onFailure(final int errorCode, final String msg, int causeCode) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onFailure(this, errorCode, msg, causeCode);
        this.isClick = false;
        final Ref.ObjectRef message = new Ref.ObjectRef();
        message.element = "";
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyOriginalPersonFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthModifyOriginalPersonFragment.onFailure$lambda$0(BiliAuthModifyOriginalPersonFragment.this, message, msg, errorCode);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFailure$lambda$0(BiliAuthModifyOriginalPersonFragment this$0, Ref.ObjectRef $message, String $msg, int $errorCode) {
        EvokeFacialHelper $this$onFailure_u24lambda_u240_u240 = this$0.mEvokeFacialHelper;
        if ($this$onFailure_u24lambda_u240_u240 != null) {
            $this$onFailure_u24lambda_u240_u240.facialFinish();
            $message.element = $this$onFailure_u24lambda_u240_u240.code2Message($errorCode, $msg);
        }
        Context context = this$0.getContext();
        String str = (String) $message.element;
        if (str == null) {
            str = $msg;
        }
        ToastHelper.showToastShort(context, str);
    }

    public void onFragmentShow(Flag lastFlag) {
        Intrinsics.checkNotNullParameter(lastFlag, "lastFlag");
        super.onFragmentShow(lastFlag);
        this.isClick = false;
    }
}