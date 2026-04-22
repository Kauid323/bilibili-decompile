package tv.danmaku.bili.ui.personinfo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import bili.resource.favorites.R;
import com.bilibili.app.comm.list.widget.dialog.LoadingDialog;
import com.bilibili.droid.H5UrlConfigHelper;
import com.bilibili.droid.InputMethodManagerHelper;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.moss.api.BusinessException;
import com.bilibili.lib.moss.api.NetworkException;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import com.bilibili.pvtracker.IPvTracker;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.offline.VideoOfflineManager;
import tv.danmaku.bili.ui.personinfo.modifyNameV2.ModifyNameV2Intent;
import tv.danmaku.bili.ui.personinfo.modifyNameV2.ModifyNameViewModelV2;
import tv.danmaku.bili.ui.personinfo.modifyNameV2.dialog.BindPhoneDialog;
import tv.danmaku.bili.ui.personinfo.modifyNameV2.dialog.ModifyNameConformDialog;
import tv.danmaku.bili.ui.personinfo.modifyNameV2.dialog.NickNameRetryDialog;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.bili.utils.PersonInfoHelper;
import tv.danmaku.bili.widget.CharacterInputFilter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PersonInfoModifyNameActivityV2.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0001MB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0017J\u0010\u0010*\u001a\u00020'2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010+\u001a\u00020#H\u0002J\b\u0010,\u001a\u00020#H\u0002J\b\u0010-\u001a\u00020#H\u0002J\b\u0010.\u001a\u00020#H\u0002J\u0010\u0010/\u001a\u00020#2\u0006\u00100\u001a\u000201H\u0002J\u0018\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u00020'H\u0002J\b\u00105\u001a\u00020#H\u0002J\b\u00106\u001a\u00020#H\u0002J\u0014\u00107\u001a\u00020#2\n\u00108\u001a\u000609j\u0002`:H\u0002J\u0010\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020\u0013H\u0002J\u0016\u0010=\u001a\u00020#2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00130?H\u0002J\u0018\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020\u00132\u0006\u0010B\u001a\u00020\u0013H\u0002J\u0010\u0010C\u001a\u00020#2\u0006\u0010D\u001a\u00020\u0013H\u0002J\"\u0010E\u001a\u00020#2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020G2\b\u0010I\u001a\u0004\u0018\u00010JH\u0014J\b\u0010K\u001a\u00020\u0013H\u0016J\b\u0010L\u001a\u00020%H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f¨\u0006N"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/PersonInfoModifyNameActivityV2;", "Lcom/bilibili/lib/ui/BaseToolbarActivity;", "Lcom/bilibili/pvtracker/IPvTracker;", "<init>", "()V", "retryDialog", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/dialog/NickNameRetryDialog;", "bindPhoneDialog", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/dialog/BindPhoneDialog;", "modifyConformDialog", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/dialog/ModifyNameConformDialog;", "editText", "Landroid/widget/EditText;", "clearName", "Landroid/widget/ImageView;", "messageTips", "Landroid/widget/TextView;", "changeRule", "oldName", "", "mAccountInfo", "Lcom/bilibili/lib/accountinfo/model/AccountInfo;", "viewModel", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameViewModelV2;", "item", "Landroid/view/MenuItem;", "from", LoginSceneProcessor.SCENE_KEY, "loadingDialog", "Lcom/bilibili/app/comm/list/widget/dialog/LoadingDialog;", "getLoadingDialog", "()Lcom/bilibili/app/comm/list/widget/dialog/LoadingDialog;", "loadingDialog$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "handleBundleParams", "initView", "otherInit", "handleViewModel", "showToast", "info", "", "handledCanEditState", "tips", "canEdit", "showLoading", "hideLoading", "onSubmitFailed", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSubmitSuccess", "name", "showNickNameReTryDialog", "names", "", "showBindPhoneDialog", "msg", "tel", "showModifyNameConformDialog", "conformMsg", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "getPvEventId", "getPvExtra", "Companion", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PersonInfoModifyNameActivityV2 extends BaseToolbarActivity implements IPvTracker {
    public static final String CUSTOM_SERVICE_GET_COIN_URI = "https://www.bilibili.com/h5/customer-service";
    private static final int ERROR_CODE_MODIFY_FORBIDDEN = 10000;
    public static final String KEY_MODIFY_NAME_SUCCESS = "key_modify_name_success";
    private static final int REQUEST_BIND_PHONE = 272;
    public static final int REQUEST_MODIFY_NAME = 17;
    private static final String TAG = "PersonInfoModifyNameActivityV2";
    private BindPhoneDialog bindPhoneDialog;
    private TextView changeRule;
    private ImageView clearName;
    private EditText editText;
    private String from;
    private MenuItem item;
    private final Lazy loadingDialog$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameActivityV2$$ExternalSyntheticLambda0
        public final Object invoke() {
            LoadingDialog loadingDialog_delegate$lambda$0;
            loadingDialog_delegate$lambda$0 = PersonInfoModifyNameActivityV2.loadingDialog_delegate$lambda$0(PersonInfoModifyNameActivityV2.this);
            return loadingDialog_delegate$lambda$0;
        }
    });
    private AccountInfo mAccountInfo;
    private TextView messageTips;
    private ModifyNameConformDialog modifyConformDialog;
    private String oldName;
    private NickNameRetryDialog retryDialog;
    private String scene;
    private ModifyNameViewModelV2 viewModel;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    /* compiled from: PersonInfoModifyNameActivityV2.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/PersonInfoModifyNameActivityV2$Companion;", "", "<init>", "()V", "TAG", "", "ERROR_CODE_MODIFY_FORBIDDEN", "", "REQUEST_BIND_PHONE", "REQUEST_MODIFY_NAME", "KEY_MODIFY_NAME_SUCCESS", "CUSTOM_SERVICE_GET_COIN_URI", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final LoadingDialog getLoadingDialog() {
        return (LoadingDialog) this.loadingDialog$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LoadingDialog loadingDialog_delegate$lambda$0(PersonInfoModifyNameActivityV2 this$0) {
        LoadingDialog.Companion companion = LoadingDialog.Companion;
        String string = this$0.getString(R.string.favorites_global_string_151);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return companion.withContent(string);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        handleViewModel();
        otherInit();
        handleBundleParams();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(com.bilibili.app.personinfo.R.menu.modify_person_info, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        EditText editText = this.editText;
        String newName = String.valueOf(editText != null ? editText.getText() : null);
        if (Intrinsics.areEqual(this.oldName, newName)) {
            ToastHelper.showToastShort((Context) this, bili.resource.profile.R.string.profile_global_string_53);
        } else {
            ModifyNameViewModelV2 modifyNameViewModelV2 = this.viewModel;
            if (modifyNameViewModelV2 != null) {
                modifyNameViewModelV2.sendIntent(new ModifyNameV2Intent.SaveSubmitIntent(newName));
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private final void handleBundleParams() {
        this.from = getIntent().getStringExtra(PersonInfo.KEY_MODIFY_NAME_FROM);
        this.scene = getIntent().getStringExtra(PersonInfo.KEY_MODIFY_NAME_SCENE);
    }

    private final void initView() {
        InputFilter[] filters;
        setContentView(com.bilibili.app.personinfo.R.layout.bili_app_modify_activity_with_toolbar);
        setTitle(bili.resource.profile.R.string.profile_global_string_58);
        showBackButton();
        this.editText = (EditText) findViewById(com.bilibili.app.personinfo.R.id.name_edit);
        this.clearName = (ImageView) findViewById(com.bilibili.app.personinfo.R.id.clear_name);
        this.messageTips = (TextView) findViewById(com.bilibili.app.personinfo.R.id.message_tips);
        this.changeRule = (TextView) findViewById(com.bilibili.app.personinfo.R.id.change_rule);
        TextView textView = this.changeRule;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameActivityV2$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PersonInfoModifyNameActivityV2.initView$lambda$0(PersonInfoModifyNameActivityV2.this, view2);
                }
            });
        }
        EditText it = this.editText;
        if (it != null) {
            InputFilter[] filters2 = it.getFilters();
            Intrinsics.checkNotNullExpressionValue(filters2, "getFilters(...)");
            InputFilter filter = new CharacterInputFilter(' ');
            if (filters2.length == 0) {
                filters = new InputFilter[]{filter};
            } else {
                InputFilter[] newFilters = new InputFilter[filters2.length + 1];
                System.arraycopy(filters2, 0, newFilters, 0, filters2.length);
                newFilters[filters2.length] = filter;
                filters = newFilters;
            }
            it.setFilters(filters);
        }
        ImageView imageView = this.clearName;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameActivityV2$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PersonInfoModifyNameActivityV2.initView$lambda$2(PersonInfoModifyNameActivityV2.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(PersonInfoModifyNameActivityV2 this$0, View it) {
        String url = H5UrlConfigHelper.INSTANCE.getUrl("person_info", "url_custom_service", "https://www.bilibili.com/h5/customer-service");
        PersonInfoHelper.intentTo((Context) this$0, Uri.parse(url), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(PersonInfoModifyNameActivityV2 this$0, View it) {
        EditText editText = this$0.editText;
        if (editText != null) {
            editText.setText("");
        }
    }

    private final void otherInit() {
        this.mAccountInfo = PersonInfoLoadHelper.getLocalAccountInfo((Context) this);
        AccountInfo it = this.mAccountInfo;
        if (it != null) {
            this.oldName = it.getUserName();
            EditText editText = this.editText;
            if (editText != null) {
                editText.setText(this.oldName);
            }
        }
    }

    private final void handleViewModel() {
        this.viewModel = (ModifyNameViewModelV2) new ViewModelProvider((ViewModelStoreOwner) this).get(ModifyNameViewModelV2.class);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new PersonInfoModifyNameActivityV2$handleViewModel$1(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new PersonInfoModifyNameActivityV2$handleViewModel$2(this, null), 3, (Object) null);
        ModifyNameViewModelV2 modifyNameViewModelV2 = this.viewModel;
        if (modifyNameViewModelV2 != null) {
            modifyNameViewModelV2.sendIntent(ModifyNameV2Intent.GetNickNameCopyWriteIntent.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(Object info) {
        if (info instanceof String) {
            ToastHelper.showToastShort((Context) this, (String) info);
        } else if (info instanceof Integer) {
            ToastHelper.showToastShort((Context) this, ((Number) info).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handledCanEditState(String tips, boolean canEdit) {
        TextView textView;
        Editable text;
        hideLoading();
        if (canEdit) {
            TextView textView2 = this.messageTips;
            if (textView2 != null) {
                textView2.setText(tips);
            }
            ImageView imageView = this.clearName;
            int i = 0;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            EditText editText = this.editText;
            if (editText != null) {
                editText.requestFocus();
            }
            EditText editText2 = this.editText;
            if (editText2 != null) {
                EditText editText3 = this.editText;
                if (editText3 != null && (text = editText3.getText()) != null) {
                    i = text.length();
                }
                editText2.setSelection(i);
            }
            EditText editText4 = this.editText;
            if (editText4 != null) {
                editText4.postDelayed(new Runnable() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameActivityV2$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        PersonInfoModifyNameActivityV2.handledCanEditState$lambda$0(PersonInfoModifyNameActivityV2.this);
                    }
                }, 100L);
                return;
            }
            return;
        }
        if (!StringsKt.isBlank(tips) && (textView = this.messageTips) != null) {
            textView.setText(tips);
        }
        EditText editText5 = this.editText;
        if (editText5 != null) {
            editText5.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handledCanEditState$lambda$0(PersonInfoModifyNameActivityV2 this$0) {
        InputMethodManagerHelper.showSoftInput((Context) this$0, this$0.editText, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoading() {
        if (!getLoadingDialog().isAdded()) {
            LoadingDialog loadingDialog = getLoadingDialog();
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            loadingDialog.show(supportFragmentManager, "loading");
        }
    }

    private final void hideLoading() {
        if (getLoadingDialog().isAdded()) {
            getLoadingDialog().dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSubmitFailed(Exception exception) {
        String string = getResources().getString(bili.resource.common.R.string.common_global_string_196);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = string;
        if (exception instanceof BusinessException) {
            String msg = exception.getMessage();
            int code = ((BusinessException) exception).getCode();
            if (msg != null) {
                if (!StringsKt.isBlank(msg)) {
                    ToastHelper.showToastShort((Context) this, msg);
                    return;
                }
                switch (code) {
                    case -707:
                        String string2 = getResources().getString(bili.resource.profile.R.string.profile_global_string_10);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        str = string2;
                        break;
                    case -655:
                        String string3 = getResources().getString(bili.resource.homepage.R.string.homepage_global_string_235);
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                        str = string3;
                        break;
                    case -618:
                        String string4 = getResources().getString(bili.resource.profile.R.string.profile_global_string_19);
                        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                        str = string4;
                        break;
                    case 10000:
                        String string5 = getResources().getString(bili.resource.space.R.string.space_global_string_155);
                        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                        str = string5;
                        break;
                }
                ToastHelper.showToastShort((Context) this, str);
            }
        } else if (exception instanceof NetworkException) {
            ToastHelper.showToastShort((Context) this, bili.resource.common.R.string.common_global_string_186);
        } else {
            ToastHelper.showToastShort((Context) this, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSubmitSuccess(String name) {
        if (this.mAccountInfo == null) {
            ToastHelper.showToastShort((Context) this, bili.resource.common.R.string.common_global_string_196);
            BLog.w(TAG, "submitSuccess but accountInfo is null!");
            return;
        }
        ToastHelper.showToastShort((Context) this, bili.resource.common.R.string.common_global_string_163);
        setResult(-1, new Intent().putExtra("key_modify_name_success", name));
        AccountInfo accountInfo = this.mAccountInfo;
        if (accountInfo != null) {
            accountInfo.setUserName(name);
        }
        PersonInfoLoadHelper.setLocalAccountInfo((Context) this, this.mAccountInfo, false);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showNickNameReTryDialog(List<String> list) {
        this.retryDialog = new NickNameRetryDialog(list);
        final NickNameRetryDialog $this$showNickNameReTryDialog_u24lambda_u240 = this.retryDialog;
        if ($this$showNickNameReTryDialog_u24lambda_u240 != null) {
            $this$showNickNameReTryDialog_u24lambda_u240.setCancelableOnTouchOutside(false);
            $this$showNickNameReTryDialog_u24lambda_u240.setCancelListener(new Function0() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameActivityV2$$ExternalSyntheticLambda4
                public final Object invoke() {
                    Unit showNickNameReTryDialog$lambda$0$0;
                    showNickNameReTryDialog$lambda$0$0 = PersonInfoModifyNameActivityV2.showNickNameReTryDialog$lambda$0$0(NickNameRetryDialog.this);
                    return showNickNameReTryDialog$lambda$0$0;
                }
            });
            $this$showNickNameReTryDialog_u24lambda_u240.setConfirmListener(new Function1() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameActivityV2$$ExternalSyntheticLambda5
                public final Object invoke(Object obj) {
                    Unit showNickNameReTryDialog$lambda$0$1;
                    showNickNameReTryDialog$lambda$0$1 = PersonInfoModifyNameActivityV2.showNickNameReTryDialog$lambda$0$1(PersonInfoModifyNameActivityV2.this, $this$showNickNameReTryDialog_u24lambda_u240, (String) obj);
                    return showNickNameReTryDialog$lambda$0$1;
                }
            });
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            $this$showNickNameReTryDialog_u24lambda_u240.show(supportFragmentManager, "nick_name_retry_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showNickNameReTryDialog$lambda$0$0(NickNameRetryDialog $this_apply) {
        $this_apply.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showNickNameReTryDialog$lambda$0$1(PersonInfoModifyNameActivityV2 this$0, NickNameRetryDialog $this_apply, String it) {
        Editable text;
        Intrinsics.checkNotNullParameter(it, "it");
        EditText editText = this$0.editText;
        if (editText != null) {
            editText.setText(it);
        }
        EditText editText2 = this$0.editText;
        if (editText2 != null) {
            EditText editText3 = this$0.editText;
            editText2.setSelection((editText3 == null || (text = editText3.getText()) == null) ? 0 : text.length());
        }
        ModifyNameViewModelV2 modifyNameViewModelV2 = this$0.viewModel;
        if (modifyNameViewModelV2 != null) {
            modifyNameViewModelV2.sendIntent(new ModifyNameV2Intent.UseAndSubmitIntent(it, "profile_app", this$0.from, this$0.scene));
        }
        $this_apply.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showBindPhoneDialog(String msg, final String tel) {
        this.bindPhoneDialog = new BindPhoneDialog();
        final BindPhoneDialog $this$showBindPhoneDialog_u24lambda_u240 = this.bindPhoneDialog;
        if ($this$showBindPhoneDialog_u24lambda_u240 != null) {
            $this$showBindPhoneDialog_u24lambda_u240.setCancelableOnTouchOutside(false);
            $this$showBindPhoneDialog_u24lambda_u240.setConditionMsg(msg);
            $this$showBindPhoneDialog_u24lambda_u240.setCancelListener(new Function0() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameActivityV2$$ExternalSyntheticLambda6
                public final Object invoke() {
                    Unit showBindPhoneDialog$lambda$0$0;
                    showBindPhoneDialog$lambda$0$0 = PersonInfoModifyNameActivityV2.showBindPhoneDialog$lambda$0$0(BindPhoneDialog.this);
                    return showBindPhoneDialog$lambda$0$0;
                }
            });
            $this$showBindPhoneDialog_u24lambda_u240.setConfirmListener(new Function0() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameActivityV2$$ExternalSyntheticLambda7
                public final Object invoke() {
                    Unit showBindPhoneDialog$lambda$0$1;
                    showBindPhoneDialog$lambda$0$1 = PersonInfoModifyNameActivityV2.showBindPhoneDialog$lambda$0$1(tel, this, $this$showBindPhoneDialog_u24lambda_u240);
                    return showBindPhoneDialog$lambda$0$1;
                }
            });
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            $this$showBindPhoneDialog_u24lambda_u240.show(supportFragmentManager, "bind_phone_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showBindPhoneDialog$lambda$0$0(BindPhoneDialog $this_apply) {
        $this_apply.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showBindPhoneDialog$lambda$0$1(String $tel, PersonInfoModifyNameActivityV2 this$0, BindPhoneDialog $this_apply) {
        if (StringsKt.startsWith$default($tel, "http", false, 2, (Object) null)) {
            Uri parse = Uri.parse($tel);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            BLRouter.routeTo(new RouteRequest.Builder(parse).requestCode((int) REQUEST_BIND_PHONE).build(), (Context) this$0);
        }
        $this_apply.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showModifyNameConformDialog(String conformMsg) {
        this.modifyConformDialog = new ModifyNameConformDialog();
        final ModifyNameConformDialog $this$showModifyNameConformDialog_u24lambda_u240 = this.modifyConformDialog;
        if ($this$showModifyNameConformDialog_u24lambda_u240 != null) {
            $this$showModifyNameConformDialog_u24lambda_u240.setCancelableOnTouchOutside(false);
            $this$showModifyNameConformDialog_u24lambda_u240.setConfirmationMsg(conformMsg);
            EditText it = this.editText;
            if (it != null) {
                $this$showModifyNameConformDialog_u24lambda_u240.setEditName(it.getText().toString());
            }
            $this$showModifyNameConformDialog_u24lambda_u240.setCancelListener(new Function0() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameActivityV2$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit showModifyNameConformDialog$lambda$0$1;
                    showModifyNameConformDialog$lambda$0$1 = PersonInfoModifyNameActivityV2.showModifyNameConformDialog$lambda$0$1(ModifyNameConformDialog.this);
                    return showModifyNameConformDialog$lambda$0$1;
                }
            });
            $this$showModifyNameConformDialog_u24lambda_u240.setConfirmListener(new Function0() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameActivityV2$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit showModifyNameConformDialog$lambda$0$2;
                    showModifyNameConformDialog$lambda$0$2 = PersonInfoModifyNameActivityV2.showModifyNameConformDialog$lambda$0$2(PersonInfoModifyNameActivityV2.this, $this$showModifyNameConformDialog_u24lambda_u240);
                    return showModifyNameConformDialog$lambda$0$2;
                }
            });
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            $this$showModifyNameConformDialog_u24lambda_u240.show(supportFragmentManager, "modify_name_conform_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showModifyNameConformDialog$lambda$0$1(ModifyNameConformDialog $this_apply) {
        $this_apply.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showModifyNameConformDialog$lambda$0$2(PersonInfoModifyNameActivityV2 this$0, ModifyNameConformDialog $this_apply) {
        ModifyNameViewModelV2 modifyNameViewModelV2 = this$0.viewModel;
        if (modifyNameViewModelV2 != null) {
            EditText editText = this$0.editText;
            modifyNameViewModelV2.sendIntent(new ModifyNameV2Intent.UseAndSubmitIntent(String.valueOf(editText != null ? editText.getText() : null), "profile_app", this$0.from, this$0.scene));
        }
        $this_apply.dismiss();
        return Unit.INSTANCE;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ModifyNameViewModelV2 modifyNameViewModelV2;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != REQUEST_BIND_PHONE || (modifyNameViewModelV2 = this.viewModel) == null) {
            return;
        }
        modifyNameViewModelV2.sendIntent(ModifyNameV2Intent.GetNickNameCopyWriteIntent.INSTANCE);
    }

    public String getPvEventId() {
        return "main.set-nickname.0.0.pv";
    }

    public Bundle getPvExtra() {
        Bundle bundle = new Bundle();
        bundle.putString("mode", "1");
        bundle.putString(VideoOfflineManager.EXTRA_PLAYLIST_TYPE, "1");
        return bundle;
    }
}