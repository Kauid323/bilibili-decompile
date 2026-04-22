package tv.danmaku.bili.auth.modify;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDelegateImpl$;
import androidx.fragment.app.Fragment;
import bili.resource.account.R;
import com.bilibili.droid.ToastHelper;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.helper.CheckCardDigitsLitener;

/* compiled from: BiliAuthModifyNameFragment.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0003J\u001c\u0010\u001b\u001a\u00020\u0018*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0018H\u0016J\u0006\u0010\"\u001a\u00020\u0018J\u0016\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020\u00182\b\u0010(\u001a\u0004\u0018\u00010)J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006."}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthModifyNameFragment;", "Ltv/danmaku/bili/auth/modify/BaseAuthModifyFragment;", "<init>", "()V", "mName", "Landroid/widget/TextView;", "mCard", "mCardDigit", "", "editList", "Ljava/util/ArrayList;", "Landroid/widget/EditText;", "Lkotlin/collections/ArrayList;", "getEditList", "()Ljava/util/ArrayList;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "showCheckDialog", "setButtonEnable", "Landroid/widget/Button;", "bgAlpha", "", "enable", "", "refreshUi", "requestCheckIDCardDigits", "addEdit", "btn_ok", "parentLayout", "Landroid/widget/LinearLayout;", "keyBoardVisibleChanged", "popupWindow", "Landroid/widget/PopupWindow;", "dpToPx", "", "dp", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthModifyNameFragment extends BaseAuthModifyFragment {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "BiliAuthModifyNameFragment";
    private TextView mCard;
    private TextView mName;
    private String mCardDigit = "";
    private final ArrayList<EditText> editList = new ArrayList<>();

    public final ArrayList<EditText> getEditList() {
        return this.editList;
    }

    /* compiled from: BiliAuthModifyNameFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthModifyNameFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Ltv/danmaku/bili/auth/modify/BiliAuthModifyNameFragment;", "params", "Landroid/os/Bundle;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BiliAuthModifyNameFragment newInstance(Bundle params) {
            BiliAuthModifyNameFragment fragment = new BiliAuthModifyNameFragment();
            if (params != null) {
                fragment.setArguments(params);
            }
            return fragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(Object popup) {
        Intrinsics.checkNotNullParameter(popup, "popup");
        if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
            Thread thread = Thread.currentThread();
            if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                IllegalStateException exp = new IllegalStateException("PopupWindow.dismiss() called from non-UI thread: " + thread + ", 请联系 Jackin");
                BLog.e("BgThreadUIAccess", "PopupWindow.dismiss() called from non-UI thread: " + thread, exp);
                Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new AppCompatDelegateImpl$.ExternalSyntheticLambda0());
                if (BuildConfig.DEBUG) {
                    throw exp;
                }
            }
        }
        ((PopupWindow) popup).dismiss();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ActionBar $this$onCreateView_u24lambda_u240 = getSupportActionBar();
        if ($this$onCreateView_u24lambda_u240 != null) {
            $this$onCreateView_u24lambda_u240.setTitle(R.string.account_global_string_227);
        }
        View view = inflater.inflate(com.bilibili.app.auth.R.layout.fragment_modify_name, container, false);
        Intrinsics.checkNotNullExpressionValue(view, "inflate(...)");
        this.mName = (TextView) view.findViewById(com.bilibili.app.auth.R.id.name);
        this.mCard = (TextView) view.findViewById(com.bilibili.app.auth.R.id.card);
        Button btn_next = (Button) view.findViewById(com.bilibili.app.auth.R.id.btn_modify_next);
        btn_next.setAlpha(0.5f);
        btn_next.setEnabled(false);
        TextView mCheck = (TextView) view.findViewById(com.bilibili.app.auth.R.id.check);
        mCheck.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyNameFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BiliAuthModifyNameFragment.this.showCheckDialog();
            }
        });
        return view;
    }

    @Override // tv.danmaku.bili.auth.modify.BaseAuthModifyFragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(R.string.account_global_string_227);
        }
        refreshUi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCheckDialog() {
        View pwView = getLayoutInflater().inflate(com.bilibili.app.auth.R.layout.bili_app_dialog_auth_check, (ViewGroup) null);
        final PopupWindow popupWin = new PopupWindow(pwView, -1, -1);
        LinearLayout parentLayout = (LinearLayout) pwView.findViewById(com.bilibili.app.auth.R.id.card_layout);
        Button btn_cancel = (Button) pwView.findViewById(com.bilibili.app.auth.R.id.btn_check_cancel);
        if (btn_cancel != null) {
            btn_cancel.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyNameFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BiliAuthModifyNameFragment.__Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(popupWin);
                }
            });
        }
        Button btn_ok = (Button) pwView.findViewById(com.bilibili.app.auth.R.id.btn_check_ok);
        btn_ok.setEnabled(false);
        Intrinsics.checkNotNull(btn_ok);
        setButtonEnable(btn_ok, 0.5f, false);
        btn_ok.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyNameFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiliAuthModifyNameFragment.showCheckDialog$lambda$1(BiliAuthModifyNameFragment.this, popupWin, view);
            }
        });
        Intrinsics.checkNotNull(parentLayout);
        addEdit(btn_ok, parentLayout);
        keyBoardVisibleChanged(popupWin);
        popupWin.setOutsideTouchable(true);
        popupWin.setTouchable(true);
        popupWin.setFocusable(true);
        popupWin.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#80000000")));
        popupWin.setContentView(pwView);
        popupWin.showAtLocation(pwView, 17, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCheckDialog$lambda$1(BiliAuthModifyNameFragment this$0, PopupWindow $popupWin, View it) {
        this$0.mCardDigit = "";
        Iterator<EditText> it2 = this$0.editList.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            EditText next = it2.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            EditText edit = next;
            String str = this$0.mCardDigit;
            this$0.mCardDigit = str + ((Object) edit.getText());
        }
        this$0.requestCheckIDCardDigits();
        if ($popupWin != null) {
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss($popupWin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setButtonEnable(Button $this$setButtonEnable, float bgAlpha, boolean enable) {
        $this$setButtonEnable.setAlpha(bgAlpha);
        $this$setButtonEnable.setEnabled(enable);
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
            TextView textView = this.mName;
            if (textView != null) {
                textView.setText(name);
            }
            TextView textView2 = this.mCard;
            if (textView2 != null) {
                textView2.setText(card);
            }
        }
    }

    public final void requestCheckIDCardDigits() {
        getMModifyHelper().requestCheckIDCardDigits(this.mCardDigit, new CheckCardDigitsLitener() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyNameFragment$requestCheckIDCardDigits$1
            @Override // tv.danmaku.bili.auth.helper.CheckCardDigitsLitener
            public void onSuccess() {
                BiliAuthModifyNameFragment.this.showFragmentWithBundle(BiliAuthModifyNameFragment.this.getContext(), BiliAuthModifyNameFragment.this.getArguments(), (Fragment) BiliAuthModifyNameFragment.this, BiliAuthModifyNameFragment.this.getURL_BILI_AUTH_MODIFY_NEW_NAME$auth_debug(), "BiliAuthNewNameFragment");
                ToastHelper.showToastShort(BiliAuthModifyNameFragment.this.getContext(), R.string.account_global_string_277);
            }

            @Override // tv.danmaku.bili.auth.helper.CheckCardDigitsLitener
            public void onError(String msg) {
                String str;
                Context context = BiliAuthModifyNameFragment.this.getContext();
                if (msg == null) {
                    str = BiliAuthModifyNameFragment.this.getString(R.string.account_global_string_478);
                    Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
                } else {
                    str = msg;
                }
                ToastHelper.showToastShort(context, str);
            }
        });
    }

    public final void addEdit(final Button btn_ok, final LinearLayout parentLayout) {
        Intrinsics.checkNotNullParameter(btn_ok, "btn_ok");
        Intrinsics.checkNotNullParameter(parentLayout, "parentLayout");
        this.editList.clear();
        for (int i = 0; i < 4; i++) {
            View inflate = getLayoutInflater().inflate(com.bilibili.app.auth.R.layout.bili_app_dialog_card_edit, (ViewGroup) parentLayout, false);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.EditText");
            final EditText editText = (EditText) inflate;
            editText.setTag(Integer.valueOf(i));
            this.editList.add(editText);
            final int i2 = i;
            editText.addTextChangedListener(new TextWatcher() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyNameFragment$addEdit$1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s != null && s.length() == 1) {
                        if (i2 < 3) {
                            EditText nextEditText = (EditText) parentLayout.findViewWithTag(Integer.valueOf(i2 + 1));
                            if (nextEditText != null) {
                                nextEditText.requestFocus();
                                return;
                            }
                            return;
                        }
                        editText.clearFocus();
                        editText.setEnabled(false);
                        this.setButtonEnable(btn_ok, 1.0f, true);
                        return;
                    }
                    if (s != null && s.length() == 0) {
                        editText.setEnabled(true);
                        this.setButtonEnable(btn_ok, 0.5f, false);
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                }
            });
            parentLayout.addView(editText);
        }
    }

    public final void keyBoardVisibleChanged(final PopupWindow popupWindow) {
        ViewTreeObserver viewTreeObserver;
        View contentView;
        View contentView2;
        final View rootView = null;
        final View contentView3 = (popupWindow == null || (contentView2 = popupWindow.getContentView()) == null) ? null : contentView2.findViewById(com.bilibili.app.auth.R.id.content);
        if (popupWindow != null && (contentView = popupWindow.getContentView()) != null) {
            rootView = contentView.getRootView();
        }
        if (rootView != null && (viewTreeObserver = rootView.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyNameFragment$keyBoardVisibleChanged$1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    View view = rootView;
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                    }
                    if (rootView != null && contentView3 != null) {
                        int screenHeight = rootView.getRootView().getHeight();
                        int keyboardHeight = screenHeight - rect.bottom;
                        boolean isKeyboardVisible = ((double) keyboardHeight) > ((double) screenHeight) * 0.15d;
                        if (popupWindow != null) {
                            BiliAuthModifyNameFragment biliAuthModifyNameFragment = this;
                            View $this$onGlobalLayout_u24lambda_u240_u240 = contentView3;
                            if (isKeyboardVisible) {
                                int content_h = biliAuthModifyNameFragment.dpToPx(BR.drawerOpen);
                                int location_h = (screenHeight - content_h) / 2;
                                int popupY = location_h + content_h;
                                if (popupY > screenHeight - keyboardHeight) {
                                    int offsetY = (popupY - (screenHeight - keyboardHeight)) + biliAuthModifyNameFragment.dpToPx(30);
                                    if ($this$onGlobalLayout_u24lambda_u240_u240 != null) {
                                        $this$onGlobalLayout_u24lambda_u240_u240.setTranslationY(-offsetY);
                                    }
                                }
                            } else if ($this$onGlobalLayout_u24lambda_u240_u240 != null) {
                                $this$onGlobalLayout_u24lambda_u240_u240.setTranslationY(0.0f);
                            }
                        }
                    }
                }
            });
        }
    }

    public final int dpToPx(int dp) {
        float density = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dp * density);
    }
}