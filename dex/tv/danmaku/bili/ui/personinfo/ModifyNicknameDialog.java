package tv.danmaku.bili.ui.personinfo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.api.BiliApiException;
import com.bilibili.app.personinfo.R;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import com.bilibili.moduleservice.main.OnModifyNameCallback;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.personinfo.api.BiliMemberApiService;
import tv.danmaku.bili.ui.personinfo.api.PersonInfoModifyNameBean;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.bili.utils.UiUtils;
import tv.danmaku.bili.widget.CharacterInputFilter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ModifyNicknameDialog.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u001dH\u0014J\b\u0010!\u001a\u00020\u001dH\u0002J\u0010\u0010\"\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010$J\b\u0010%\u001a\u00020\u001dH\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u0005H\u0002J\u0010\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010\u0017J\b\u0010*\u001a\u00020\u001dH\u0002J\b\u0010+\u001a\u00020\u001dH\u0002J\b\u0010,\u001a\u00020\u001dH\u0002J\u0018\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001bH\u0002R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/ModifyNicknameDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "from", LoginSceneProcessor.SCENE_KEY, "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getFrom", "getScene", "mEtNickname", "Landroid/widget/EditText;", "mBtnSubmit", "Landroid/widget/Button;", "mIvClear", "Landroid/widget/ImageView;", "mEtContainer", "Landroid/widget/LinearLayout;", "mCallback", "Lcom/bilibili/moduleservice/main/OnModifyNameCallback;", "mProcessDialog", "Lcom/bilibili/magicasakura/widgets/TintProgressDialog;", "mIsNickFree", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "checkNickFree", "onViewCreated", "view", "Landroid/view/View;", "onBackPressed", "onModifyName", "nickname", "setOnModifyNameCallback", "callback", "showProcessDialog", "hideProcessDialog", "reportCancel", "reportResult", "code", "", "isSuccess", "Companion", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ModifyNicknameDialog extends AppCompatDialog {
    private static final String EVENT_ID_CANCEL_CLICK = "main.set-nickname.nickpopup.cancel.click";
    private static final String EVENT_ID_DIALOG_SHOW = "main.set-nickname.nickpopup.0.show";
    private static final String EVENT_ID_SUBMIT_CLICK = "main.set-nickname.nickpopup.submit.click";
    private static final String EVENT_ID_SUBMIT_RESULT = "main.set-nickname.nickname-code.0.show";
    private final String from;
    private Button mBtnSubmit;
    private OnModifyNameCallback mCallback;
    private LinearLayout mEtContainer;
    private EditText mEtNickname;
    private boolean mIsNickFree;
    private ImageView mIvClear;
    private TintProgressDialog mProcessDialog;
    private final String scene;
    private final String title;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModifyNicknameDialog(Context context, String title, String from, String scene) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.title = title;
        this.from = from;
        this.scene = scene;
    }

    public /* synthetic */ ModifyNicknameDialog(Context context, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? "" : str, str2, (i & 8) != 0 ? "" : str3);
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getTitle() {
        return this.title;
    }

    /* compiled from: ModifyNicknameDialog.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/ModifyNicknameDialog$Companion;", "", "<init>", "()V", "EVENT_ID_CANCEL_CLICK", "", "EVENT_ID_DIALOG_SHOW", "EVENT_ID_SUBMIT_CLICK", "EVENT_ID_SUBMIT_RESULT", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.bili_app_layout_modify_nickname_dialog, (ViewGroup) null, false);
        setContentView(contentView);
        onViewCreated(contentView);
        setCanceledOnTouchOutside(false);
        checkNickFree();
    }

    protected void onStart() {
        super.onStart();
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setBackgroundDrawableResource(17170445);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setLayout(UiUtils.dp2px(getContext(), 280.0f), -2);
        }
    }

    private final void checkNickFree() {
        String accessKey = BiliAccounts.get(getContext()).getAccessKey();
        ((BiliMemberApiService) ServiceGenerator.createService(BiliMemberApiService.class)).getNickFree(accessKey).enqueue(new BiliApiDataCallback<JSONObject>() { // from class: tv.danmaku.bili.ui.personinfo.ModifyNicknameDialog$checkNickFree$1
            public void onDataSuccess(JSONObject data) {
                ModifyNicknameDialog modifyNicknameDialog = ModifyNicknameDialog.this;
                boolean z = false;
                if (data != null) {
                    try {
                        Boolean bool = data.getBoolean("nick_free");
                        if (bool != null) {
                            z = bool.booleanValue();
                        }
                    } catch (Exception e) {
                    }
                }
                modifyNicknameDialog.mIsNickFree = z;
            }

            public void onError(Throwable t) {
            }

            public boolean isCancel() {
                Activity findActivityOrNull = ContextUtilKt.findActivityOrNull(ModifyNicknameDialog.this.getContext());
                if (findActivityOrNull != null) {
                    return findActivityOrNull.isFinishing();
                }
                return false;
            }
        });
    }

    public final void onViewCreated(View view2) {
        if (view2 == null) {
            return;
        }
        View findViewById = view2.findViewById(R.id.nickname_et);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mEtNickname = (EditText) findViewById;
        View findViewById2 = view2.findViewById(R.id.clear);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mIvClear = (ImageView) findViewById2;
        ((ImageView) view2.findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.personinfo.ModifyNicknameDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ModifyNicknameDialog.onViewCreated$lambda$0(ModifyNicknameDialog.this, view3);
            }
        });
        ((TextView) view2.findViewById(R.id.cancel)).setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.personinfo.ModifyNicknameDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ModifyNicknameDialog.onViewCreated$lambda$1(ModifyNicknameDialog.this, view3);
            }
        });
        TextView tvTitle = (TextView) view2.findViewById(R.id.modify_name_tips);
        if (!TextUtils.isEmpty(this.title)) {
            tvTitle.setText(this.title);
        }
        View findViewById3 = view2.findViewById(R.id.nickname_submit);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.mBtnSubmit = (Button) findViewById3;
        Button button = this.mBtnSubmit;
        ImageView imageView = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnSubmit");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.personinfo.ModifyNicknameDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ModifyNicknameDialog.onViewCreated$lambda$2(ModifyNicknameDialog.this, view3);
            }
        });
        Button button2 = this.mBtnSubmit;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnSubmit");
            button2 = null;
        }
        button2.setEnabled(false);
        EditText editText = this.mEtNickname;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtNickname");
            editText = null;
        }
        editText.addTextChangedListener(new TextWatcher() { // from class: tv.danmaku.bili.ui.personinfo.ModifyNicknameDialog$onViewCreated$4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                ImageView imageView2;
                Button button3;
                LinearLayout linearLayout;
                ImageView imageView3;
                Button button4;
                LinearLayout linearLayout2 = null;
                Button button5 = null;
                if ((s != null ? s.length() : 0) > 0) {
                    imageView3 = ModifyNicknameDialog.this.mIvClear;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mIvClear");
                        imageView3 = null;
                    }
                    imageView3.setVisibility(0);
                    button4 = ModifyNicknameDialog.this.mBtnSubmit;
                    if (button4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBtnSubmit");
                    } else {
                        button5 = button4;
                    }
                    button5.setEnabled(true);
                    return;
                }
                imageView2 = ModifyNicknameDialog.this.mIvClear;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvClear");
                    imageView2 = null;
                }
                imageView2.setVisibility(8);
                button3 = ModifyNicknameDialog.this.mBtnSubmit;
                if (button3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBtnSubmit");
                    button3 = null;
                }
                button3.setEnabled(false);
                linearLayout = ModifyNicknameDialog.this.mEtContainer;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEtContainer");
                } else {
                    linearLayout2 = linearLayout;
                }
                linearLayout2.setBackground(ContextCompat.getDrawable(ModifyNicknameDialog.this.getContext(), R.drawable.person_info_shape_modify_nickname_input_bg));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        CharacterInputFilter inputFilter = new CharacterInputFilter(' ');
        EditText editText2 = this.mEtNickname;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtNickname");
            editText2 = null;
        }
        InputFilter[] filters = editText2.getFilters();
        Intrinsics.checkNotNullExpressionValue(filters, "getFilters(...)");
        List filters2 = ArraysKt.toMutableList(filters);
        filters2.add(inputFilter);
        EditText editText3 = this.mEtNickname;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtNickname");
            editText3 = null;
        }
        List $this$toTypedArray$iv = filters2;
        editText3.setFilters((InputFilter[]) $this$toTypedArray$iv.toArray(new InputFilter[0]));
        View findViewById4 = view2.findViewById(R.id.et_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.mEtContainer = (LinearLayout) findViewById4;
        ImageView imageView2 = this.mIvClear;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvClear");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.personinfo.ModifyNicknameDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ModifyNicknameDialog.onViewCreated$lambda$3(ModifyNicknameDialog.this, view3);
            }
        });
        Neurons.reportExposure$default(false, EVENT_ID_DIALOG_SHOW, MapsKt.mapOf(new Pair[]{TuplesKt.to("from_spmid", this.from), TuplesKt.to(LoginSceneProcessor.SCENE_KEY, this.scene)}), (List) null, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(ModifyNicknameDialog this$0, View it) {
        this$0.dismiss();
        this$0.reportCancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(ModifyNicknameDialog this$0, View it) {
        this$0.dismiss();
        this$0.reportCancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(ModifyNicknameDialog this$0, View it) {
        boolean z = false;
        Neurons.reportClick(false, EVENT_ID_SUBMIT_CLICK, MapsKt.mapOf(new Pair[]{TuplesKt.to("from_spmid", this$0.from), TuplesKt.to(LoginSceneProcessor.SCENE_KEY, this$0.scene)}));
        EditText editText = this$0.mEtNickname;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtNickname");
            editText = null;
        }
        Editable nickname = editText.getText();
        Editable editable = nickname;
        if (editable == null || editable.length() == 0) {
            z = true;
        }
        if (z) {
            ToastHelper.showToastShort(this$0.getContext(), bili.resource.profile.R.string.profile_global_string_46);
        } else {
            this$0.onModifyName(nickname.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(ModifyNicknameDialog this$0, View it) {
        EditText editText = this$0.mEtNickname;
        ImageView imageView = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtNickname");
            editText = null;
        }
        editText.setText("");
        ImageView imageView2 = this$0.mIvClear;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvClear");
        } else {
            imageView = imageView2;
        }
        imageView.setVisibility(8);
    }

    public void onBackPressed() {
        super.onBackPressed();
        reportCancel();
    }

    private final void onModifyName(String nickname) {
        if (!ConnectivityMonitor.getInstance().isNetworkActive()) {
            ToastHelper.showToastShort(getContext(), bili.resource.profile.R.string.profile_global_string_24);
            return;
        }
        showProcessDialog();
        String accessKey = BiliAccounts.get(getContext()).getAccessKey();
        ((BiliMemberApiService) ServiceGenerator.createService(BiliMemberApiService.class)).modifyUserName(accessKey, nickname).enqueue(new BiliApiDataCallback<PersonInfoModifyNameBean>() { // from class: tv.danmaku.bili.ui.personinfo.ModifyNicknameDialog$onModifyName$1
            public void onDataSuccess(PersonInfoModifyNameBean data) {
                LinearLayout linearLayout;
                String it;
                OnModifyNameCallback onModifyNameCallback;
                ModifyNicknameDialog.this.hideProcessDialog();
                linearLayout = ModifyNicknameDialog.this.mEtContainer;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEtContainer");
                    linearLayout = null;
                }
                linearLayout.setBackground(ContextCompat.getDrawable(ModifyNicknameDialog.this.getContext(), R.drawable.person_info_shape_modify_nickname_input_bg));
                if (data != null && (it = data.successName) != null) {
                    String it2 = TextUtils.isEmpty(it) ? null : it;
                    if (it2 != null) {
                        ModifyNicknameDialog modifyNicknameDialog = ModifyNicknameDialog.this;
                        onModifyNameCallback = modifyNicknameDialog.mCallback;
                        if (onModifyNameCallback != null) {
                            onModifyNameCallback.onSuccess(it2);
                        }
                        modifyNicknameDialog.dismiss();
                    }
                }
                ModifyNicknameDialog.this.dismiss();
                ToastHelper.showToastShort(ModifyNicknameDialog.this.getContext(), bili.resource.profile.R.string.profile_global_string_54);
                ModifyNicknameDialog.this.reportResult(0, true);
            }

            public void onError(Throwable t) {
                LinearLayout linearLayout;
                ModifyNicknameDialog.this.hideProcessDialog();
                linearLayout = ModifyNicknameDialog.this.mEtContainer;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEtContainer");
                    linearLayout = null;
                }
                linearLayout.setBackground(ContextCompat.getDrawable(ModifyNicknameDialog.this.getContext(), R.drawable.person_info_shape_modify_nickname_input_error_bg));
                if ((t instanceof BiliApiException) && !TextUtils.isEmpty(((BiliApiException) t).getMessage())) {
                    ToastHelper.showToastShort(ModifyNicknameDialog.this.getContext(), ((BiliApiException) t).getMessage());
                    ModifyNicknameDialog.this.reportResult(((BiliApiException) t).mCode, false);
                    return;
                }
                ToastHelper.showToastShort(ModifyNicknameDialog.this.getContext(), bili.resource.profile.R.string.profile_global_string_28);
            }

            public boolean isCancel() {
                Activity findActivityOrNull = ContextUtilKt.findActivityOrNull(ModifyNicknameDialog.this.getContext());
                if (findActivityOrNull != null) {
                    return findActivityOrNull.isFinishing();
                }
                return false;
            }
        });
    }

    public final void setOnModifyNameCallback(OnModifyNameCallback callback) {
        this.mCallback = callback;
    }

    private final void showProcessDialog() {
        if (this.mProcessDialog == null) {
            this.mProcessDialog = TintProgressDialog.show(getContext(), "", "");
        }
        TintProgressDialog tintProgressDialog = this.mProcessDialog;
        if (tintProgressDialog != null) {
            tintProgressDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideProcessDialog() {
        TintProgressDialog tintProgressDialog = this.mProcessDialog;
        if (tintProgressDialog != null) {
            tintProgressDialog.dismiss();
        }
    }

    private final void reportCancel() {
        Neurons.reportClick(false, EVENT_ID_CANCEL_CLICK, MapsKt.mapOf(new Pair[]{TuplesKt.to("from_spmid", this.from), TuplesKt.to(LoginSceneProcessor.SCENE_KEY, this.scene)}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportResult(int code, boolean isSuccess) {
        Pair[] pairArr = new Pair[6];
        pairArr[0] = TuplesKt.to("code", String.valueOf(code));
        pairArr[1] = TuplesKt.to("set_result", isSuccess ? "1" : "0");
        pairArr[2] = TuplesKt.to("mode", this.mIsNickFree ? "1" : "2");
        pairArr[3] = TuplesKt.to("from_spmid", this.from);
        pairArr[4] = TuplesKt.to("spmid", "main.set-nickname.nickpopup.0");
        pairArr[5] = TuplesKt.to(LoginSceneProcessor.SCENE_KEY, this.scene);
        Neurons.reportExposure$default(false, "main.set-nickname.nickname-code.0.show", MapsKt.mapOf(pairArr), (List) null, 8, (Object) null);
    }
}