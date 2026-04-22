package tv.danmaku.bili.ui.personinfo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.app.personinfo.R;
import com.bilibili.droid.H5UrlConfigHelper;
import com.bilibili.droid.InputMethodManagerHelper;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.pvtracker.IPvTracker;
import tv.danmaku.bili.ui.personinfo.PersonInfoLoadFragment;
import tv.danmaku.bili.ui.personinfo.api.BiliMemberApiService;
import tv.danmaku.bili.ui.personinfo.event.ModifyPersonInfoEvent;
import tv.danmaku.bili.ui.personinfo.event.ModifyType;
import tv.danmaku.bili.utils.PersonInfoHelper;
import tv.danmaku.bili.utils.PersonInfoReport;
import tv.danmaku.bili.widget.CharacterInputFilter;
import tv.danmaku.bili.widget.LoadingImageView;
import tv.danmaku.bili.widget.dialog.BiliCommonDialog;

public class PersonInfoModifyNameFragment extends BaseModifyFragment implements View.OnClickListener, IPvTracker {
    private static final String CUSTOM_SERVICE_GET_COIN_URI = "https://www.bilibili.com/h5/customer-service";
    public static final String TAG = "PersonInfoModifyNameFragment";
    EditText mEditText;
    private String mFrom;
    RelativeLayout mLayoutContent;
    LoadingImageView mLoadingView;
    private String mOldName;
    private String mScene;
    TextView mTextView;
    private boolean nickFree = false;

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    @Override // tv.danmaku.bili.ui.personinfo.BaseModifyFragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view2 = inflater.inflate(R.layout.bili_app_fragment_perinfo_modify_name, container, false);
        findViews(view2);
        initEditText();
        initTextView();
        loadNickFree();
        return view2;
    }

    private void findViews(View view2) {
        this.mLayoutContent = (RelativeLayout) view2.findViewById(R.id.layout_content);
        this.mLoadingView = (LoadingImageView) view2.findViewById(R.id.loading_view);
        this.mEditText = (EditText) view2.findViewById(R.id.name_edit);
        this.mTextView = (TextView) view2.findViewById(R.id.tv_tips);
        view2.findViewById(R.id.coin_help).setOnClickListener(this);
        view2.findViewById(R.id.clear_name).setOnClickListener(this);
    }

    public void onResume() {
        super.onResume();
        if (this.mEditText != null) {
            this.mEditText.requestFocus();
            this.mEditText.postDelayed(new Runnable() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonInfoModifyNameFragment.this.getActivity() != null) {
                        InputMethodManagerHelper.showSoftInput(PersonInfoModifyNameFragment.this.getActivity(), PersonInfoModifyNameFragment.this.mEditText, 1);
                    }
                }
            }, 100L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() == R.id.clear_name) {
            this.mEditText.setText("");
        } else if (v.getId() == R.id.coin_help && getActivity() != null) {
            String url = H5UrlConfigHelper.INSTANCE.getUrl("person_info", "url_custom_service", "https://www.bilibili.com/h5/customer-service");
            PersonInfoHelper.intentTo(getActivity(), Uri.parse(url), true);
        }
    }

    private void initEditText() {
        InputFilter[] filters;
        this.mEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameFragment.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    PersonInfoModifyNameFragment.this.showSoftInput(v);
                } else {
                    PersonInfoModifyNameFragment.this.hideSoftInput(v.getWindowToken());
                }
            }
        });
        InputFilter[] filters2 = this.mEditText.getFilters();
        InputFilter filter = new CharacterInputFilter(' ');
        if (filters2.length > 0) {
            InputFilter[] newFilters = new InputFilter[filters2.length + 1];
            System.arraycopy(filters2, 0, newFilters, 0, filters2.length);
            newFilters[filters2.length] = filter;
            filters = newFilters;
        } else {
            filters = new InputFilter[]{filter};
        }
        this.mEditText.setFilters(filters);
    }

    public void initTextView() {
        this.mTextView.setText(bili.resource.profile.R.string.profile_global_string_32);
    }

    private String getOldName() {
        AccountInfo myInfo;
        if (this.mOldName == null && (myInfo = PersonInfoLoadHelper.getLocalAccountInfo(getActivity())) != null) {
            this.mOldName = myInfo.getUserName();
        }
        return this.mOldName;
    }

    public void saveModifyName(PersonInfoLoadFragment.ModifyCallBack callBack) {
        String name = this.mEditText.getText().toString();
        if (name.equals(getOldName())) {
            ToastHelper.showToastShort(getActivity(), bili.resource.profile.R.string.profile_global_string_53);
        } else {
            showConfirmDialog(name, callBack);
        }
    }

    public void cancelLoadingProcess() {
        if (this.mProgressDialog != null) {
            this.mProgressDialog.dismiss();
        }
    }

    public void loadNickFree() {
        showLoading();
        String accessKey = BiliAccounts.get(getContext()).getAccessKey();
        ((BiliMemberApiService) ServiceGenerator.createService(BiliMemberApiService.class)).getNickFree(accessKey).enqueue(new BiliApiDataCallback<JSONObject>() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameFragment.3
            public void onDataSuccess(JSONObject result) {
                if (result != null) {
                    try {
                        if (result.containsKey("nick_free")) {
                            PersonInfoModifyNameFragment.this.nickFree = result.getBoolean("nick_free").booleanValue();
                            PersonInfoModifyNameFragment.this.mTextView.setText(PersonInfoModifyNameFragment.this.nickFree ? bili.resource.profile.R.string.profile_global_string_17 : bili.resource.profile.R.string.profile_global_string_32);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                PersonInfoModifyNameFragment.this.hideLoading();
            }

            public void onError(Throwable error) {
                PersonInfoModifyNameFragment.this.hideLoading();
            }

            public boolean isCancel() {
                return PersonInfoModifyNameFragment.this.getActivity() == null;
            }
        });
    }

    public boolean isNickFree() {
        return this.nickFree;
    }

    public void onEventModifyPersonInfo(ModifyPersonInfoEvent event) {
        if (getActivity() != null && event.modifyType == ModifyType.NAME) {
            cancelLoadingProcess();
            if (event.error == null) {
                if (this.mImmShowing) {
                    hideSoftInput(this.mEditText.getWindowToken());
                }
                getActivity().onBackPressed();
            }
        }
    }

    public void showLoading() {
        if (this.mLoadingView != null) {
            this.mLoadingView.setVisibility(0);
            this.mLoadingView.setRefreshing();
            this.mLayoutContent.setVisibility(8);
        }
    }

    public void hideLoading() {
        if (this.mLoadingView != null) {
            this.mLoadingView.setRefreshComplete();
            this.mLoadingView.setVisibility(8);
            this.mLayoutContent.setVisibility(0);
        }
    }

    public void showConfirmDialog(final String name, final PersonInfoLoadFragment.ModifyCallBack callBack) {
        final FragmentActivity activity = getActivity();
        FragmentManager manager = getFragmentManager();
        if (activity == null || manager == null) {
            return;
        }
        BiliCommonDialog dialog = new BiliCommonDialog.Builder(activity).setTitle(getString(isNickFree() ? bili.resource.profile.R.string.profile_global_string_55 : bili.resource.profile.R.string.profile_global_string_58)).setButtonStyle(1).setContentText(getString(isNickFree() ? bili.resource.profile.R.string.profile_global_string_3 : bili.resource.profile.R.string.profile_global_string_7)).setNegativeButton(getString(bili.resource.common.R.string.common_global_string_238), new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameFragment$$ExternalSyntheticLambda0
            @Override // tv.danmaku.bili.widget.dialog.BiliCommonDialog.OnDialogTextClickListener
            public final void onDialogTextClicked(View view2, BiliCommonDialog biliCommonDialog) {
                biliCommonDialog.dismiss();
            }
        }).setPositiveButton(getString(bili.resource.common.R.string.common_global_string_129), new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameFragment$$ExternalSyntheticLambda1
            @Override // tv.danmaku.bili.widget.dialog.BiliCommonDialog.OnDialogTextClickListener
            public final void onDialogTextClicked(View view2, BiliCommonDialog biliCommonDialog) {
                PersonInfoModifyNameFragment.this.m1419lambda$showConfirmDialog$1$tvdanmakubiliuipersoninfoPersonInfoModifyNameFragment(name, callBack, activity, view2, biliCommonDialog);
            }
        }).build();
        dialog.show(manager, "modify-name-confirm-dialog");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showConfirmDialog$1$tv-danmaku-bili-ui-personinfo-PersonInfoModifyNameFragment  reason: not valid java name */
    public /* synthetic */ void m1419lambda$showConfirmDialog$1$tvdanmakubiliuipersoninfoPersonInfoModifyNameFragment(String name, PersonInfoLoadFragment.ModifyCallBack callBack, Activity activity, View view2, BiliCommonDialog dialog1) {
        PersonInfoLoadFragment loadFragment;
        PersonInfoReport.reportModifyNickNameSumitClick(isNickFree() ? "1" : "2");
        if (getFragmentManager() != null && (loadFragment = PersonInfoLoadFragment.getInstance(getFragmentManager())) != null) {
            loadFragment.modifyUserName(isNickFree(), name, this.mFrom, this.mScene, callBack);
        }
        dialog1.dismiss();
        this.mProgressDialog = TintProgressDialog.show(activity, (CharSequence) null, activity.getString(bili.resource.common.R.string.common_global_string_227), true);
        this.mProgressDialog.setCanceledOnTouchOutside(false);
    }

    public String getPvEventId() {
        return "main.set-nickname.0.0.pv";
    }

    public Bundle getPvExtra() {
        Bundle bundle = new Bundle();
        bundle.putString("mode", isNickFree() ? "1" : "2");
        return bundle;
    }

    public void setFrom(String from) {
        this.mFrom = from;
    }

    public void setScene(String scene) {
        this.mScene = scene;
    }
}