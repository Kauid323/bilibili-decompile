package tv.danmaku.bili.ui.personinfo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import bili.resource.common.R;
import com.bilibili.app.comm.list.avatarcommon.changeavatar.AvatarChooser;
import com.bilibili.app.comm.list.avatarcommon.changeavatar.AvatarUploader;
import com.bilibili.app.comm.list.avatarcommon.changeavatar.UserinfoObserverKt;
import com.bilibili.base.BiliContext;
import com.bilibili.boxing.Boxing;
import com.bilibili.boxing.model.entity.BaseMedia;
import com.bilibili.boxing.model.entity.impl.ImageMedia;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import com.bilibili.playset.PlaySetErrorHelper;
import java.util.ArrayList;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.personinfo.event.ModifyPersonInfoEvent;
import tv.danmaku.bili.ui.personinfo.event.ModifyType;
import tv.danmaku.bili.ui.personinfo.event.PersonInfoModifyViewModel;
import tv.danmaku.bili.ui.personinfo.event.PersonInfoModifyViewModelKt;
import tv.danmaku.ijk.media.player.IjkMediaPlayerTracker;

public class PersonInfoActivity extends BaseToolbarActivity {
    public static final String TAG = "PersonInfoActivity";
    PersonInfoLoadFragment mLoaderFragment;
    PersonInfoModifyNameFragment mModifyNameFragment;
    PersonInfoModifySignFragment mModifySignFragment;
    PersonInfoFragment mPersonInfoFragment;
    private PersonInfoModifyViewModel mPersonInfoModifyViewModel;
    private ModifyType mModifyType = ModifyType.NONE;
    private final PassportObserver passportObserver = new PassportObserver() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoActivity$$ExternalSyntheticLambda0
        public final void onChange(Topic topic) {
            PersonInfoActivity.this.m1394lambda$new$0$tvdanmakubiliuipersoninfoPersonInfoActivity(topic);
        }
    };
    private AvatarUploader.UploadCallback mUploadCallback = new AvatarUploader.UploadCallback() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoActivity.4
        private static final int ERROR_CODE_MODIFY_FORBIDDEN = 10000;
        private TintProgressDialog mProgressDialog;

        public void onUploadBegin() {
            if (!PersonInfoActivity.this.activityDie()) {
                this.mProgressDialog = TintProgressDialog.show(PersonInfoActivity.this, (CharSequence) null, PersonInfoActivity.this.getString(R.string.common_global_string_227), true);
                this.mProgressDialog.setCanceledOnTouchOutside(false);
            }
        }

        public void onUploadFailed(int errCode, String errorStr) {
            if (PersonInfoActivity.this.activityDie()) {
                return;
            }
            if (this.mProgressDialog != null) {
                this.mProgressDialog.dismiss();
            }
            if (PlaySetErrorHelper.isRealName(errCode)) {
                PlaySetErrorHelper.showDialog(PersonInfoActivity.this, errCode, errorStr);
                return;
            }
            if (TextUtils.isEmpty(errorStr)) {
                errorStr = PersonInfoActivity.this.getResources().getString(R.string.common_global_string_196);
                if (errCode == -653) {
                    errorStr = PersonInfoActivity.this.getResources().getString(com.bilibili.app.comm.list.avatarcommon.R.string.avatar_failed);
                } else if (errCode == 10000) {
                    errorStr = PersonInfoActivity.this.getResources().getString(com.bilibili.app.comm.list.avatarcommon.R.string.modify_forbidden);
                }
            }
            ToastHelper.showToastShort(BiliContext.application(), errorStr);
        }

        public void onUploadSuccess(String url) {
            if (PersonInfoActivity.this.activityDie()) {
                return;
            }
            if (this.mProgressDialog != null) {
                this.mProgressDialog.dismiss();
            }
            PersonInfoActivity.this.mPersonInfoModifyViewModel.getModifyUrl().setValue(url);
        }
    };

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$tv-danmaku-bili-ui-personinfo-PersonInfoActivity  reason: not valid java name */
    public /* synthetic */ void m1394lambda$new$0$tvdanmakubiliuipersoninfoPersonInfoActivity(Topic topic) {
        if (topic == Topic.ACCOUNT_INFO_UPDATE) {
            HandlerThreads.getHandler(0).postDelayed(new Runnable() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    AccountInfo accountInfo;
                    if (PersonInfoActivity.this.isFinishing() || PersonInfoActivity.this.mPersonInfoModifyViewModel == null || (accountInfo = BiliAccountInfo.get().getAccountInfoFromCache()) == null) {
                        return;
                    }
                    String avatar = accountInfo.getAvatar();
                    BLog.i(PersonInfoActivity.TAG, "Topic.ACCOUNT_INFO_UPDATE " + avatar);
                    PersonInfoActivity.this.mPersonInfoModifyViewModel.getModifyUrl().setValue(avatar);
                }
            }, 0L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.bilibili.lib.basecomponent.R.layout.bili_app_activity_with_toolbar);
        this.mPersonInfoModifyViewModel = (PersonInfoModifyViewModel) new ViewModelProvider(this).get(PersonInfoModifyViewModel.class);
        this.mPersonInfoModifyViewModel.getModifyType().observe(this, new Observer<ModifyType>() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoActivity.2
            public void onChanged(ModifyType modifyType) {
                PersonInfoActivity.this.onEventInfoModify(modifyType);
            }
        });
        this.mPersonInfoModifyViewModel.getModifyPersonInfoEvent().observe(this, new Observer<ModifyPersonInfoEvent>() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoActivity.3
            public void onChanged(ModifyPersonInfoEvent modifyPersonInfoEvent) {
                if (modifyPersonInfoEvent != null) {
                    PersonInfoActivity.this.onEventModifyPersonInfo(modifyPersonInfoEvent);
                }
            }
        });
        boolean showCampusHint = Boolean.parseBoolean(getIntent().getStringExtra(PersonInfoModifyViewModelKt.KEY_FROM_CAMPUS_USER));
        this.mPersonInfoModifyViewModel.getShowCampusHint().setValue(Boolean.valueOf(showCampusHint));
        showBackButton();
        setupFragment(savedInstanceState, getSupportFragmentManager());
        UserinfoObserverKt.onUserinfoChanged(this, this.passportObserver, this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(com.bilibili.app.personinfo.R.menu.modify_person_info, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.mModifyNameFragment == null && this.mModifySignFragment == null) {
            menu.removeItem(com.bilibili.app.personinfo.R.id.menu_modify_save);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == com.bilibili.app.personinfo.R.id.menu_modify_save) {
            saveModifyByMenuType();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEventModifyPersonInfo(ModifyPersonInfoEvent modifyPersonInfoEvent) {
        ModifyType modifyType = modifyPersonInfoEvent.modifyType;
        switch (modifyType) {
            case NAME:
                if (this.mModifyNameFragment != null) {
                    this.mModifyNameFragment.onEventModifyPersonInfo(modifyPersonInfoEvent);
                    return;
                }
                return;
            case SIGNATURE:
                if (this.mModifySignFragment != null) {
                    this.mModifySignFragment.onEventModifyPersonInfo(modifyPersonInfoEvent);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void onEventInfoModify(ModifyType modifyType) {
        int selectedId;
        if (modifyType == null) {
            return;
        }
        FragmentManager fm = getSupportFragmentManager();
        switch (modifyType) {
            case NAME:
                this.mModifyNameFragment = new PersonInfoModifyNameFragment();
                FragmentTransaction transactionName = fm.beginTransaction();
                transactionName.hide(this.mPersonInfoFragment);
                if (this.mModifySignFragment != null) {
                    transactionName.hide(this.mModifySignFragment);
                }
                transactionName.add(com.bilibili.lib.basecomponent.R.id.content_layout, this.mModifyNameFragment, PersonInfoModifyNameFragment.TAG);
                transactionName.addToBackStack(TAG);
                transactionName.commit();
                fm.executePendingTransactions();
                setupOptionMenu(ModifyType.NAME, false);
                return;
            case SIGNATURE:
                this.mModifySignFragment = new PersonInfoModifySignFragment();
                FragmentTransaction transactionSign = fm.beginTransaction();
                transactionSign.hide(this.mPersonInfoFragment);
                if (this.mModifyNameFragment != null) {
                    transactionSign.hide(this.mModifyNameFragment);
                }
                transactionSign.add(com.bilibili.lib.basecomponent.R.id.content_layout, this.mModifySignFragment, PersonInfoModifySignFragment.TAG);
                transactionSign.addToBackStack(TAG);
                transactionSign.commit();
                fm.executePendingTransactions();
                setupOptionMenu(ModifyType.SIGNATURE, false);
                return;
            case AVATAR:
                new AvatarChooser(this, true, this.mUploadCallback).showAll(true, (int) IjkMediaPlayerTracker.BLIJK_EV_SET_AUTO_SWITCH);
                return;
            case SEX:
                AccountInfo info = PersonInfoLoadHelper.getLocalAccountInfo(this);
                if (info != null) {
                    PersonInfoSexDilaog sexFragment = new PersonInfoSexDilaog();
                    try {
                        selectedId = info.getSex();
                    } catch (NumberFormatException e) {
                        selectedId = 0;
                    }
                    if (selectedId > 2 || selectedId < 0) {
                    }
                    sexFragment.show(fm, "PersonInfoSexDilaog");
                    setupOptionMenu(ModifyType.SEX, true);
                    return;
                }
                return;
            case BIRTHDAY:
                AccountInfo myInfo = PersonInfoLoadHelper.getLocalAccountInfo(this);
                if (myInfo != null) {
                    PersonInfoBirthFragment birthFragment = new PersonInfoBirthFragment();
                    birthFragment.setDate(myInfo.getBirthday());
                    birthFragment.show(fm, PersonInfoBirthFragment.TAG);
                    setupOptionMenu(ModifyType.BIRTHDAY, true);
                    return;
                }
                return;
            case QR_CODE:
                startActivity(PersonInfoQRCodeActivity.createIntent(this));
                return;
            default:
                setupOptionMenu(ModifyType.NONE, true);
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void saveModifyByMenuType() {
        switch (this.mModifyType) {
            case NAME:
                this.mModifyNameFragment.saveModifyName(null);
                return;
            case SIGNATURE:
                String signature = this.mModifySignFragment.getModifySignature();
                AccountInfo info = PersonInfoLoadHelper.getLocalAccountInfo(this);
                if (signature != null && info != null) {
                    if (!signature.equals(info.getSignature())) {
                        this.mLoaderFragment.modifySignature(signature);
                        this.mModifySignFragment.mProgressDialog = TintProgressDialog.show(this, (CharSequence) null, getResources().getString(R.string.common_global_string_227), true);
                        this.mModifySignFragment.mProgressDialog.setCanceledOnTouchOutside(false);
                        return;
                    }
                    onBackPressed();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void setupFragment(Bundle savedInstanceState, FragmentManager fm) {
        this.mLoaderFragment = PersonInfoLoadFragment.getInstance(fm);
        if (this.mLoaderFragment == null) {
            this.mLoaderFragment = new PersonInfoLoadFragment();
            PersonInfoLoadFragment.attachTo(fm, this.mLoaderFragment);
        }
        if (savedInstanceState == null) {
            getSupportActionBar().setTitle(bili.resource.profile.R.string.profile_global_string_21);
            FragmentTransaction beginTransaction = fm.beginTransaction();
            int i = com.bilibili.lib.basecomponent.R.id.content_layout;
            PersonInfoFragment personInfoFragment = new PersonInfoFragment();
            this.mPersonInfoFragment = personInfoFragment;
            beginTransaction.add(i, personInfoFragment, PersonInfoFragment.TAG).commit();
            return;
        }
        this.mPersonInfoFragment = fm.findFragmentByTag(PersonInfoFragment.TAG);
        if (this.mPersonInfoFragment != null) {
            this.mModifyNameFragment = fm.findFragmentByTag(PersonInfoModifyNameFragment.TAG);
            this.mModifySignFragment = fm.findFragmentByTag(PersonInfoModifySignFragment.TAG);
            if (this.mModifyNameFragment != null) {
                fm.beginTransaction().hide(this.mPersonInfoFragment).show(this.mModifyNameFragment).addToBackStack(TAG).commit();
                setupOptionMenu(ModifyType.NAME, false);
            } else if (this.mModifySignFragment != null) {
                fm.beginTransaction().hide(this.mPersonInfoFragment).show(this.mModifySignFragment).addToBackStack(TAG).commit();
                setupOptionMenu(ModifyType.SIGNATURE, false);
            } else {
                fm.beginTransaction().show(this.mPersonInfoFragment).commit();
                setupOptionMenu(ModifyType.MAIN, true);
            }
        }
    }

    public void onBackPressed() {
        boolean popped = false;
        try {
            popped = getSupportFragmentManager().popBackStackImmediate(TAG, 1);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        if (popped) {
            setupOptionMenu(ModifyType.MAIN, true);
            this.mModifyNameFragment = null;
            this.mModifySignFragment = null;
            return;
        }
        super.onBackPressed();
    }

    private boolean isExistingFragmentByTag(String tag) {
        return getSupportFragmentManager().findFragmentByTag(tag) != null;
    }

    public void setupOptionMenu(ModifyType type, boolean isHiddenParentMenu) {
        this.mModifyType = type;
        switch (type) {
            case NAME:
                getSupportActionBar().setTitle(bili.resource.profile.R.string.profile_global_string_58);
                break;
            case SIGNATURE:
                getSupportActionBar().setTitle(bili.resource.profile.R.string.profile_global_string_6);
                break;
            case MAIN:
                getSupportActionBar().setTitle(bili.resource.profile.R.string.profile_global_string_21);
                break;
        }
        supportInvalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean activityDie() {
        if (isFinishing() || isDestroyed()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            if (requestCode == 1001) {
                AvatarUploader.uploadAvatar(AvatarChooser.PhotoSource.TAKE, (Uri) null, this.mUploadCallback);
            } else if (requestCode == 1002) {
                ArrayList<BaseMedia> result = Boxing.getResult(data);
                if (result == null || result.isEmpty()) {
                    return;
                }
                ImageMedia cropMedia = (ImageMedia) result.get(0);
                AvatarUploader.uploadAvatar(AvatarChooser.PhotoSource.CHOOSE, cropMedia.getImageUri(), this.mUploadCallback);
            } else if (requestCode == 1017) {
                setResult(0);
                finish();
            } else if (requestCode == 1003 || requestCode == 1005) {
                if (data != null) {
                    Uri uri = (Uri) data.getParcelableExtra("aphro_crop_image_uri");
                    AvatarUploader.uploadAvatar(AvatarChooser.PhotoSource.APHRO_CHOOSE, uri, this.mUploadCallback);
                }
            } else if (requestCode == 1004) {
                AvatarChooser.toCropAfterCamera(this, (int) IjkMediaPlayerTracker.BLIJK_EV_VIDEO_COMPONET_OPEN);
            }
        }
    }
}