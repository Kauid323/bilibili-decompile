package tv.danmaku.bili.ui.personinfo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import bili.resource.common.R;
import com.bilibili.api.BiliApiException;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import tv.danmaku.bili.ui.personinfo.PersonInfoLoadFragment;
import tv.danmaku.bili.ui.personinfo.api.PersonInfoModifyNameBean;
import tv.danmaku.bili.ui.personinfo.event.ModifyPersonInfoEvent;
import tv.danmaku.bili.utils.RealNameErrorHelper;

public class PersonInfoModifyNameActivity extends BaseToolbarActivity {
    public static final String KEY_MODIFY_NAME_SUCCESS = "key_modify_name_success";
    public static final int REQUEST_MODIFY_NAME = 17;
    private static final String TAG = "PersonInfoModifyNameActivity";
    private PersonInfoLoadFragment.ModifyCallBack callBack = new PersonInfoLoadFragment.ModifyCallBack() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameActivity.1
        @Override // tv.danmaku.bili.ui.personinfo.PersonInfoLoadFragment.ModifyCallBack
        public void onModifyPersonInfo(ModifyPersonInfoEvent event) {
            PersonInfoModifyNameFragment findFragmentByTag = PersonInfoModifyNameActivity.this.getSupportFragmentManager().findFragmentByTag(PersonInfoModifyNameFragment.TAG);
            if (findFragmentByTag instanceof PersonInfoModifyNameFragment) {
                findFragmentByTag.cancelLoadingProcess();
            }
            if (event.error != null) {
                if (event.error instanceof BiliApiException) {
                    PersonInfoModifyNameActivity.this.dealWithError(event.error);
                } else {
                    ToastHelper.showToastShort(PersonInfoModifyNameActivity.this, R.string.common_global_string_196);
                }
            } else if (PersonInfoModifyNameActivity.this.mAccountInfo == null) {
                ToastHelper.showToastShort(PersonInfoModifyNameActivity.this, R.string.common_global_string_196);
            } else {
                PersonInfoModifyNameActivity.this.dealWithSuccess(event);
            }
        }
    };
    private AccountInfo mAccountInfo;
    private PersonInfoModifyNameFragment mFragment;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.bilibili.lib.basecomponent.R.layout.bili_app_activity_with_toolbar);
        ensureToolbar();
        showBackButton();
        PersonInfoLoadFragment loaderFragment = PersonInfoLoadFragment.getInstance(getSupportFragmentManager());
        if (loaderFragment == null) {
            PersonInfoLoadFragment loaderFragment2 = new PersonInfoLoadFragment();
            PersonInfoLoadFragment.attachTo(getSupportFragmentManager(), loaderFragment2);
        }
        getSupportActionBar().setTitle(bili.resource.profile.R.string.profile_global_string_58);
        String from = getIntent().getStringExtra(PersonInfo.KEY_MODIFY_NAME_FROM);
        String scene = getIntent().getStringExtra(PersonInfo.KEY_MODIFY_NAME_SCENE);
        if (savedInstanceState == null) {
            this.mFragment = new PersonInfoModifyNameFragment();
            this.mFragment.setFrom(from);
            this.mFragment.setScene(scene);
            getSupportFragmentManager().beginTransaction().add(com.bilibili.lib.basecomponent.R.id.content_layout, this.mFragment, PersonInfoModifyNameFragment.TAG).commit();
        }
        this.mAccountInfo = PersonInfoLoadHelper.getLocalAccountInfo(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(com.bilibili.app.personinfo.R.menu.modify_person_info, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        PersonInfoModifyNameFragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(PersonInfoModifyNameFragment.TAG);
        if (findFragmentByTag instanceof PersonInfoModifyNameFragment) {
            findFragmentByTag.saveModifyName(this.callBack);
        }
        return super.onOptionsItemSelected(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void dealWithError(Exception error) {
        int errorCode = ((BiliApiException) error).mCode;
        String errorStr = error.getMessage();
        if (RealNameErrorHelper.isRealName(errorCode)) {
            RealNameErrorHelper.showDialog(this, errorCode, errorStr);
            return;
        }
        if (TextUtils.isEmpty(errorStr)) {
            errorStr = getResources().getString(R.string.common_global_string_196);
            if (errorCode == -618) {
                errorStr = getResources().getString(bili.resource.profile.R.string.profile_global_string_19);
            } else if (errorCode == -655) {
                errorStr = getResources().getString(bili.resource.homepage.R.string.homepage_global_string_235);
            } else if (errorCode == -707) {
                errorStr = getResources().getString(bili.resource.profile.R.string.profile_global_string_10);
            } else if (errorCode == 10000) {
                errorStr = getResources().getString(bili.resource.space.R.string.space_global_string_155);
            }
        }
        ToastHelper.showToastShort(this, errorStr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void dealWithSuccess(ModifyPersonInfoEvent event) {
        if (event.response instanceof PersonInfoModifyNameBean) {
            String modifyName = null;
            if (!TextUtils.isEmpty(((PersonInfoModifyNameBean) event.response).successName)) {
                modifyName = ((PersonInfoModifyNameBean) event.response).successName;
            } else if (!TextUtils.isEmpty(((PersonInfoModifyNameBean) event.response).originName)) {
                modifyName = ((PersonInfoModifyNameBean) event.response).originName;
            }
            if (!TextUtils.isEmpty(modifyName)) {
                this.mAccountInfo.setUserName(modifyName);
                setResult(-1, new Intent().putExtra("key_modify_name_success", modifyName));
            }
        } else if (event.response instanceof String) {
            this.mAccountInfo.setUserName(String.valueOf(event.response));
            setResult(-1, new Intent().putExtra("key_modify_name_success", String.valueOf(event.response)));
        }
        PersonInfoLoadHelper.setLocalAccountInfo(this, this.mAccountInfo, false);
        ToastHelper.showToastShort(this, R.string.common_global_string_163);
        finish();
    }
}