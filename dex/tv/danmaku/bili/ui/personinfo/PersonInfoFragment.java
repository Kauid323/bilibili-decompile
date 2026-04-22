package tv.danmaku.bili.ui.personinfo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import bolts.Continuation;
import bolts.Task;
import com.alibaba.fastjson.JSONObject;
import com.bapis.bilibili.account.interfaces.v1.AccountProfileReply;
import com.bapis.bilibili.account.interfaces.v1.ProfileField;
import com.bapis.bilibili.account.interfaces.v1.UserFieldSetting;
import com.bapis.bilibili.account.interfaces.v1.UserHandleFieldSetting;
import com.bilibili.api.BiliApiException;
import com.bilibili.app.comm.list.widget.utils.LifecycleExtentionsKt;
import com.bilibili.app.comm.servercomm.ServerClock;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.BundleUtil;
import com.bilibili.droid.ClipboardHelper;
import com.bilibili.droid.H5UrlConfigHelper;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.accountinfo.model.InviteInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.config.BLRemoteConfig;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.lib.router.Router;
import com.bilibili.lib.theme.R;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.lib.ui.mixin.Flag;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.bilibili.magicasakura.widgets.TintView;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.pvtracker.IPvTracker;
import com.bilibili.pvtracker.PageViewTracker;
import java.util.Iterator;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.personinfo.api.BiliMemberApiService;
import tv.danmaku.bili.ui.personinfo.api.BiliSchool;
import tv.danmaku.bili.ui.personinfo.api.BirthdayModified;
import tv.danmaku.bili.ui.personinfo.api.PersonInfoMossApiService;
import tv.danmaku.bili.ui.personinfo.api.PointFlagBean;
import tv.danmaku.bili.ui.personinfo.event.ModifyPersonInfoEvent;
import tv.danmaku.bili.ui.personinfo.event.ModifyType;
import tv.danmaku.bili.ui.personinfo.event.PersonInfoModifyViewModel;
import tv.danmaku.bili.ui.personinfo.view.BannedItemView;
import tv.danmaku.bili.utils.PersonInfoHelper;
import tv.danmaku.bili.utils.PersonInfoReport;
import tv.danmaku.bili.utils.RealNameErrorHelper;
import tv.danmaku.bili.widget.LoadingImageView;
import tv.danmaku.bili.widget.dialog.BiliCommonDialog;
import usercenter.UserHandleModel;

public class PersonInfoFragment extends BaseFragment implements IPvTracker {
    private static final String AUTH_URL = "https://account.bilibili.com/official/mobile/home";
    private static final String PV_EVENT_ID = "main.account-information.0.0.pv";
    private static final int REQUEST_CODE_INVITATION = 1001;
    private static final int REQUEST_CODE_SCHOOL = 1002;
    public static final String TAG = "PersonInfoFragment";
    private static final String invitationUrl = "https://account.bilibili.com/mobile/account/invitation";
    private AccountInfo mAccountInfo;
    private TintView mAuthDividerLine;
    private ViewGroup mAuthLayout;
    private TextView mAuthText;
    private StaticImageView2 mAvatar;
    private BannedItemView mBannedEntry;
    private TextView mBirthday;
    private TextView mHandle;
    private TintView mHandleDividerLine;
    private ViewGroup mHandleLayout;
    private ViewGroup mHeadPendantLayout;
    private String mHeadPendantUrl;
    private TintView mInvitationDividerLine;
    private ViewGroup mInvitationLayout;
    private LoadingImageView mLoadingView;
    private TextView mName;
    private TintView mPendantDividerLine;
    private ImageView mPendantRedPoint;
    private PersonInfoModifyViewModel mPersonInfoModifyViewModel;
    private TintProgressDialog mProgressDialog;
    private TintTextView mSchool;
    private ViewGroup mSchoolLayout;
    private ScrollView mScrollView;
    private TextView mSex;
    private TextView mSignature;
    private TextView mUid;
    private UserHandleModel mUserHandleModel;
    private TintImageView schoolIndicator;
    private BiliSchool schoolInfo = null;
    private Boolean isEnableFreeCoinsChangeNickName = Boolean.valueOf(DeviceDecision.INSTANCE.getBoolean("free_coins_change_nick_name", false));

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    private void loadSchool() {
        ((BiliMemberApiService) ServiceGenerator.createService(BiliMemberApiService.class)).school().enqueue(new BiliApiDataCallback<BiliSchool>() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoFragment.1
            public void onDataSuccess(BiliSchool data) {
                PersonInfoFragment.this.setSchool(data);
            }

            public void onError(Throwable t) {
                PersonInfoFragment.this.setSchool(null);
            }

            public boolean isCancel() {
                return PersonInfoFragment.this.activityDie();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSchool(BiliSchool school) {
        int colorRes;
        if (school == null || !school.isShow) {
            this.mSchoolLayout.setVisibility(8);
            return;
        }
        this.schoolInfo = school;
        this.mSchoolLayout.setVisibility(0);
        if (TextUtils.isEmpty(school.name)) {
            if (Boolean.TRUE.equals(this.mPersonInfoModifyViewModel.getShowCampusHint().getValue())) {
                colorRes = R.color.Brand_pink;
            } else {
                colorRes = R.color.Ga5;
            }
            this.mSchool.setTextColorById(colorRes);
            this.schoolIndicator.setImageTintList(colorRes);
            this.mSchool.setText(bili.resource.profile.R.string.profile_global_string_41);
        } else {
            this.mSchool.setText(school.name);
        }
        this.mSchoolLayout.setTag(school.jumpUrl);
    }

    private void loadAccountProfile() {
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoFragment$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PersonInfoFragment.lambda$loadAccountProfile$1();
            }
        }).continueWith(new Continuation() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoFragment$$ExternalSyntheticLambda6
            public final Object then(Task task) {
                return PersonInfoFragment.this.m1405lambda$loadAccountProfile$2$tvdanmakubiliuipersoninfoPersonInfoFragment(task);
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ AccountProfileReply lambda$loadAccountProfile$1() throws Exception {
        try {
            return (AccountProfileReply) BuildersKt.runBlocking(Dispatchers.getIO(), new Function2() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoFragment$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Object accountProfile;
                    CoroutineScope coroutineScope = (CoroutineScope) obj;
                    accountProfile = PersonInfoMossApiService.INSTANCE.getAccountProfile((kotlin.coroutines.Continuation) obj2);
                    return accountProfile;
                }
            });
        } catch (Exception e) {
            BLog.e(TAG, "loadAccountProfile error", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$loadAccountProfile$2$tv-danmaku-bili-ui-personinfo-PersonInfoFragment  reason: not valid java name */
    public /* synthetic */ Void m1405lambda$loadAccountProfile$2$tvdanmakubiliuipersoninfoPersonInfoFragment(Task task) throws Exception {
        AccountProfileReply reply = (AccountProfileReply) task.getResult();
        if (reply != null) {
            handleAccountProfile(reply);
            return null;
        }
        return null;
    }

    private void handleAccountProfile(AccountProfileReply reply) {
        if (reply == null) {
            return;
        }
        UserHandleFieldSetting handleSetting = null;
        Iterator it = reply.getFieldSettingList().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            UserFieldSetting fieldSetting = (UserFieldSetting) it.next();
            if (fieldSetting.getFieldType() == ProfileField.PROFILE_FIELD_HANDLE && fieldSetting.hasHandleSetting()) {
                handleSetting = fieldSetting.getHandleSetting();
                break;
            }
        }
        if (handleSetting != null && handleSetting.getVisible()) {
            this.mUserHandleModel = new UserHandleModel(reply.hasProfile() ? reply.getProfile().getHandle() : "", handleSetting.getEditable(), handleSetting.getRuleMessage(), handleSetting.getConfirmMessage(), handleSetting.getSubmittedMessage(), handleSetting.getBindTelUrl(), (int) handleSetting.getMaxLength());
            this.mHandleLayout.setVisibility(0);
            this.mHandleDividerLine.setVisibility(0);
            if (reply.hasProfile() && !TextUtils.isEmpty(reply.getProfile().getHandle())) {
                this.mHandle.setText(reply.getProfile().getHandle());
                return;
            } else {
                this.mHandle.setText("");
                return;
            }
        }
        this.mHandleLayout.setVisibility(8);
        this.mHandleDividerLine.setVisibility(8);
        this.mUserHandleModel = null;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.mPersonInfoModifyViewModel = (PersonInfoModifyViewModel) new ViewModelProvider(activity).get(PersonInfoModifyViewModel.class);
            this.mPersonInfoModifyViewModel.getModifyPersonInfoEvent().observe(activity, new Observer<ModifyPersonInfoEvent>() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoFragment.2
                public void onChanged(ModifyPersonInfoEvent modifyPersonInfoEvent) {
                    if (modifyPersonInfoEvent != null) {
                        PersonInfoFragment.this.onEventModifyPersonInfo(modifyPersonInfoEvent);
                    }
                }
            });
            this.mPersonInfoModifyViewModel.getUploadingEvent().observe(activity, new Observer<Void>() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoFragment.3
                public void onChanged(Void aVoid) {
                    PersonInfoFragment.this.onEventUploading();
                }
            });
            this.mPersonInfoModifyViewModel.getModifyUrl().observe(activity, new Observer<String>() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoFragment.4
                public void onChanged(String s) {
                    if (s != null) {
                        BiliImageLoader.INSTANCE.with(PersonInfoFragment.this.mAvatar.getContext()).url(s).into(PersonInfoFragment.this.mAvatar);
                    }
                }
            });
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view2 = inflater.inflate(com.bilibili.app.personinfo.R.layout.bili_app_fragment_perinfo, container, false);
        this.mAvatar = view2.findViewById(com.bilibili.app.personinfo.R.id.avatar);
        this.mScrollView = (ScrollView) view2.findViewById(com.bilibili.app.personinfo.R.id.scroll_layout);
        this.mLoadingView = (LoadingImageView) view2.findViewById(com.bilibili.app.personinfo.R.id.loading_view);
        this.mName = (TextView) view2.findViewById(com.bilibili.app.personinfo.R.id.name);
        this.mUid = (TextView) view2.findViewById(com.bilibili.app.personinfo.R.id.uid);
        this.mSex = (TextView) view2.findViewById(com.bilibili.app.personinfo.R.id.sex);
        this.mBirthday = (TextView) view2.findViewById(com.bilibili.app.personinfo.R.id.birthday);
        this.mSignature = (TextView) view2.findViewById(com.bilibili.app.personinfo.R.id.signature);
        this.mBannedEntry = (BannedItemView) view2.findViewById(com.bilibili.app.personinfo.R.id.banned_entry);
        this.mPendantRedPoint = (ImageView) view2.findViewById(com.bilibili.app.personinfo.R.id.pendant_red_point);
        this.mHeadPendantLayout = (ViewGroup) view2.findViewById(com.bilibili.app.personinfo.R.id.head_pendant_layout);
        this.mInvitationLayout = (ViewGroup) view2.findViewById(com.bilibili.app.personinfo.R.id.invitation_code_layout);
        this.mPendantDividerLine = view2.findViewById(com.bilibili.app.personinfo.R.id.divider_line_pendant);
        this.mInvitationDividerLine = view2.findViewById(com.bilibili.app.personinfo.R.id.divider_invitation_code);
        this.mAuthText = (TextView) view2.findViewById(com.bilibili.app.personinfo.R.id.auth_text);
        this.mAuthDividerLine = view2.findViewById(com.bilibili.app.personinfo.R.id.divider_line_auth);
        this.mAuthLayout = (ViewGroup) view2.findViewById(com.bilibili.app.personinfo.R.id.auth_layout);
        this.mSchoolLayout = (ViewGroup) view2.findViewById(com.bilibili.app.personinfo.R.id.school_layout);
        this.mSchool = view2.findViewById(com.bilibili.app.personinfo.R.id.school);
        this.schoolIndicator = view2.findViewById(com.bilibili.app.personinfo.R.id.school_indicator);
        this.mHandleLayout = (ViewGroup) view2.findViewById(com.bilibili.app.personinfo.R.id.handle_layout);
        this.mHandle = (TextView) view2.findViewById(com.bilibili.app.personinfo.R.id.handle);
        this.mHandleDividerLine = view2.findViewById(com.bilibili.app.personinfo.R.id.divider_line_handle);
        registerLayoutClick(view2, new View.OnClickListener() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PersonInfoFragment.this.onItemClick(view3);
            }
        }, com.bilibili.app.personinfo.R.id.signature_layout, com.bilibili.app.personinfo.R.id.name_layout, com.bilibili.app.personinfo.R.id.avatar_layout, com.bilibili.app.personinfo.R.id.sex_layout, com.bilibili.app.personinfo.R.id.birthday_layout, com.bilibili.app.personinfo.R.id.qr_code_layout, com.bilibili.app.personinfo.R.id.uid_layout, com.bilibili.app.personinfo.R.id.head_pendant_layout, com.bilibili.app.personinfo.R.id.invitation_code_layout, com.bilibili.app.personinfo.R.id.auth_layout, com.bilibili.app.personinfo.R.id.school_layout, com.bilibili.app.personinfo.R.id.handle_layout);
        return view2;
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
        super.onViewCreated(view2, savedInstanceState);
        requestHeadPendantInfo();
        this.mPersonInfoModifyViewModel.getShowCampusHint().observe(getViewLifecycleOwner(), new Observer() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoFragment$$ExternalSyntheticLambda7
            public final void onChanged(Object obj) {
                PersonInfoFragment.this.m1408lambda$onViewCreated$3$tvdanmakubiliuipersoninfoPersonInfoFragment((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onViewCreated$3$tv-danmaku-bili-ui-personinfo-PersonInfoFragment  reason: not valid java name */
    public /* synthetic */ void m1408lambda$onViewCreated$3$tvdanmakubiliuipersoninfoPersonInfoFragment(Boolean Boolean) {
        setSchool(this.schoolInfo);
    }

    public void onResume() {
        super.onResume();
        if (this.mAccountInfo == null) {
            showLoading();
            loadAccountInfo();
            loadSchool();
            loadAccountProfile();
        }
    }

    public void onFragmentShow(Flag lastFlag) {
        super.onFragmentShow(lastFlag);
        PageViewTracker.getInstance().setFragmentVisibility(this, true);
    }

    public void onFragmentHide(Flag lastFlag) {
        super.onFragmentHide(lastFlag);
        PageViewTracker.getInstance().setFragmentVisibility(this, false);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001) {
            showLoading();
            loadAccountInfo();
        } else if (requestCode == 1002) {
            loadSchool();
        } else if (requestCode == 17 && resultCode == -1) {
            String modifyName = data.getStringExtra("key_modify_name_success");
            if (!TextUtils.isEmpty(modifyName)) {
                this.mAccountInfo.setUserName(modifyName);
                this.mName.setText(this.mAccountInfo.getUserName());
                PersonInfoLoadHelper.setLocalAccountInfo(getActivity(), this.mAccountInfo, true);
            }
        }
    }

    private void registerLayoutClick(View root, View.OnClickListener l, int... ids) {
        for (int id : ids) {
            root.findViewById(id).setOnClickListener(l);
        }
    }

    private void requestHeadPendantInfo() {
        String accessKey = BiliAccounts.get(BiliContext.application()).getAccessKey();
        ((BiliMemberApiService) ServiceGenerator.createService(BiliMemberApiService.class)).getPointFlag(accessKey).enqueue(new BiliApiDataCallback<PointFlagBean>() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoFragment.5
            public void onDataSuccess(PointFlagBean data) {
                if (data != null && data.flagBean != null && data.linkBean != null) {
                    PersonInfoFragment.this.mPendantRedPoint.setVisibility(data.flagBean.pendant ? 0 : 8);
                    PersonInfoFragment.this.mHeadPendantUrl = data.linkBean.pendant_link;
                    return;
                }
                onError(null);
            }

            public boolean isCancel() {
                return PersonInfoFragment.this.activityDie();
            }

            public void onError(Throwable t) {
                PersonInfoFragment.this.mPendantDividerLine.setVisibility(8);
                PersonInfoFragment.this.mHeadPendantLayout.setVisibility(8);
            }
        });
    }

    private void callLogout() {
        Object task = Router.global().with(getContext()).call("action://main/logout-task");
        if (task instanceof Task) {
            ((Task) task).onSuccess(new Continuation() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoFragment$$ExternalSyntheticLambda12
                public final Object then(Task task2) {
                    return PersonInfoFragment.this.m1402lambda$callLogout$4$tvdanmakubiliuipersoninfoPersonInfoFragment(task2);
                }
            }, Task.UI_THREAD_EXECUTOR);
            return;
        }
        Log.e("LOGOUT", "No logout action found!!! Logout directly!");
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoFragment$$ExternalSyntheticLambda13
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PersonInfoFragment.this.m1403lambda$callLogout$5$tvdanmakubiliuipersoninfoPersonInfoFragment();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$callLogout$4$tv-danmaku-bili-ui-personinfo-PersonInfoFragment  reason: not valid java name */
    public /* synthetic */ Object m1402lambda$callLogout$4$tvdanmakubiliuipersoninfoPersonInfoFragment(Task t) throws Exception {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1);
            activity.finish();
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$callLogout$5$tv-danmaku-bili-ui-personinfo-PersonInfoFragment  reason: not valid java name */
    public /* synthetic */ Object m1403lambda$callLogout$5$tvdanmakubiliuipersoninfoPersonInfoFragment() throws Exception {
        BiliAccounts.get(getContext()).logout("PersonInfoFragment_callLogout");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onItemClick(View v) {
        ModifyType modifyType;
        int i = v.getId();
        if (i == com.bilibili.app.personinfo.R.id.name_layout) {
            getActivity();
            if (BiliAccountInfo.get().isOfficialCertification()) {
                showConfirmDialog();
                modifyType = ModifyType.NONE;
            } else {
                modifyType = ModifyType.NAME;
            }
            PersonInfoReport.reportClick(PersonInfoReport.PERSON_INFO_NIKCNAME_CLICK);
        } else if (i == com.bilibili.app.personinfo.R.id.signature_layout) {
            modifyType = ModifyType.SIGNATURE;
            PersonInfoReport.reportClick(PersonInfoReport.PERSON_INFO_SIGN_CLICK);
        } else if (i == com.bilibili.app.personinfo.R.id.avatar_layout) {
            modifyType = ModifyType.AVATAR;
            PersonInfoReport.reportClick(PersonInfoReport.PERSON_INFO_AVATAR_CLICK);
        } else if (i == com.bilibili.app.personinfo.R.id.sex_layout) {
            modifyType = ModifyType.SEX;
            PersonInfoReport.reportClick(PersonInfoReport.PERSON_INFO_SEX_CLICK);
        } else if (i == com.bilibili.app.personinfo.R.id.birthday_layout) {
            modifyType = ModifyType.BIRTHDAY;
            PersonInfoReport.reportClick(PersonInfoReport.PERSON_INFO_BIRTHDATE_CLICK);
        } else if (i == com.bilibili.app.personinfo.R.id.qr_code_layout) {
            modifyType = ModifyType.QR_CODE;
            PersonInfoReport.reportClick(PersonInfoReport.PERSON_INFO_QRCODE_CLICK);
        } else if (i == com.bilibili.app.personinfo.R.id.uid_layout) {
            modifyType = ModifyType.NONE;
            if (this.mAccountInfo != null) {
                ClipboardHelper.copy(getContext(), "UID:" + this.mAccountInfo.getMid());
                ToastHelper.showToastShort(getContext(), getString(bili.resource.profile.R.string.profile_global_string_57));
            }
            PersonInfoReport.reportClick(PersonInfoReport.PERSON_INFO_UID_CLICK);
        } else if (i == com.bilibili.app.personinfo.R.id.head_pendant_layout) {
            modifyType = ModifyType.NONE;
            if (!TextUtils.isEmpty(this.mHeadPendantUrl)) {
                PersonInfoHelper.intentTo(getActivity(), Uri.parse(this.mHeadPendantUrl), false);
                this.mPendantRedPoint.setVisibility(8);
            }
        } else if (i == com.bilibili.app.personinfo.R.id.invitation_code_layout) {
            modifyType = ModifyType.NONE;
            String url = H5UrlConfigHelper.INSTANCE.getUrl("person_info", "url_invitation", invitationUrl);
            RouteRequest request = new RouteRequest.Builder(url).requestCode(1001).build();
            BLRouter.routeTo(request, this);
            PersonInfoReport.reportClick(PersonInfoReport.ACCOUNT_INVITATION_CLICK);
        } else if (i == com.bilibili.app.personinfo.R.id.auth_layout) {
            modifyType = ModifyType.NONE;
            Object urlTag = this.mAuthLayout.getTag();
            String url2 = urlTag == null ? AUTH_URL : urlTag.toString();
            RouteRequest request2 = new RouteRequest.Builder(url2).build();
            BLRouter.routeTo(request2, this);
        } else if (i == com.bilibili.app.personinfo.R.id.school_layout) {
            modifyType = ModifyType.NONE;
            Object tag = this.mSchoolLayout.getTag();
            PersonInfoReport.reportSchoolClick();
            LifecycleExtentionsKt.onNextEvent(getViewLifecycleOwner(), Lifecycle.Event.ON_RESUME, new Function0() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoFragment$$ExternalSyntheticLambda14
                public final Object invoke() {
                    return PersonInfoFragment.this.m1406lambda$onItemClick$6$tvdanmakubiliuipersoninfoPersonInfoFragment();
                }
            });
            if (tag instanceof String) {
                BLRouter.routeTo(new RouteRequest.Builder((String) tag).requestCode(1002).build(), this);
            }
        } else if (i == com.bilibili.app.personinfo.R.id.handle_layout) {
            modifyType = ModifyType.HANDLE;
            if (this.mUserHandleModel != null) {
                RouteRequest request3 = new RouteRequest.Builder("activity://personinfo/handle").extras(new Function1() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoFragment$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        return PersonInfoFragment.this.m1407lambda$onItemClick$7$tvdanmakubiliuipersoninfoPersonInfoFragment((MutableBundleLike) obj);
                    }
                }).build();
                BLRouter.routeTo(request3, this);
            }
        } else {
            modifyType = ModifyType.NONE;
        }
        if (this.mPersonInfoModifyViewModel != null) {
            if (modifyType == ModifyType.NAME && this.isEnableFreeCoinsChangeNickName.booleanValue()) {
                BLRouter.routeTo(new RouteRequest.Builder(PersonInfo.URI_PERSONINFO_MODIFY_NAME_ACTIVITY2).requestCode(17).build(), this);
            } else {
                this.mPersonInfoModifyViewModel.getModifyType().setValue(modifyType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onItemClick$6$tv-danmaku-bili-ui-personinfo-PersonInfoFragment  reason: not valid java name */
    public /* synthetic */ Unit m1406lambda$onItemClick$6$tvdanmakubiliuipersoninfoPersonInfoFragment() {
        this.mPersonInfoModifyViewModel.getShowCampusHint().setValue(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onItemClick$7$tv-danmaku-bili-ui-personinfo-PersonInfoFragment  reason: not valid java name */
    public /* synthetic */ Unit m1407lambda$onItemClick$7$tvdanmakubiliuipersoninfoPersonInfoFragment(MutableBundleLike bundleLike) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(UserHandleActivity.KEY_USER_HANDLE_MODEL, this.mUserHandleModel);
        bundleLike.put(BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE, bundle);
        return null;
    }

    private void showConfirmDialog() {
        final FragmentActivity activity = getActivity();
        FragmentManager manager = getFragmentManager();
        if (activity == null || manager == null) {
            return;
        }
        BiliCommonDialog dialog = new BiliCommonDialog.Builder(activity).setTitle(activity.getString(bili.resource.profile.R.string.profile_global_string_51)).setButtonStyle(1).setContentText(activity.getString(bili.resource.profile.R.string.profile_global_string_39)).setNegativeButton(activity.getString(bili.resource.common.R.string.common_global_string_238), new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoFragment$$ExternalSyntheticLambda9
            @Override // tv.danmaku.bili.widget.dialog.BiliCommonDialog.OnDialogTextClickListener
            public final void onDialogTextClicked(View view2, BiliCommonDialog biliCommonDialog) {
                biliCommonDialog.dismiss();
            }
        }).setPositiveButton(activity.getString(bili.resource.profile.R.string.profile_global_string_60), new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoFragment$$ExternalSyntheticLambda10
            @Override // tv.danmaku.bili.widget.dialog.BiliCommonDialog.OnDialogTextClickListener
            public final void onDialogTextClicked(View view2, BiliCommonDialog biliCommonDialog) {
                PersonInfoFragment.lambda$showConfirmDialog$9(activity, view2, biliCommonDialog);
            }
        }).build();
        dialog.show(manager, "modify-name-confirm-dialog");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$showConfirmDialog$9(Activity activity, View view2, BiliCommonDialog dialog1) {
        String url = H5UrlConfigHelper.INSTANCE.getUrl("person_info", "url_condition_update", "https://account.bilibili.com/official/mobile/condition?update=1");
        RouteRequest routeRequest = new RouteRequest.Builder(Uri.parse(url)).build();
        BLRouter.routeTo(routeRequest, activity);
        dialog1.dismiss();
    }

    public void loadAccountInfo() {
        if (getActivity() == null) {
            return;
        }
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoFragment$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                AccountInfo requestForMyAccountInfo;
                requestForMyAccountInfo = BiliAccountInfo.get().requestForMyAccountInfo();
                return requestForMyAccountInfo;
            }
        }).continueWith(new Continuation() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoFragment$$ExternalSyntheticLambda3
            public final Object then(Task task) {
                return PersonInfoFragment.lambda$loadAccountInfo$11(task);
            }
        }, Task.UI_THREAD_EXECUTOR).continueWith(new Continuation() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoFragment$$ExternalSyntheticLambda4
            public final Object then(Task task) {
                return PersonInfoFragment.lambda$loadAccountInfo$12(task);
            }
        }, Task.BACKGROUND_EXECUTOR).continueWith(new Continuation() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoFragment$$ExternalSyntheticLambda5
            public final Object then(Task task) {
                return PersonInfoFragment.this.m1404lambda$loadAccountInfo$13$tvdanmakubiliuipersoninfoPersonInfoFragment(task);
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ AccountInfoLoadResult lambda$loadAccountInfo$11(Task task) throws Exception {
        if (task.isCompleted() && task.getResult() != null) {
            AccountInfoLoadResult result = new AccountInfoLoadResult((AccountInfo) task.getResult());
            return result;
        }
        AccountInfoLoadResult result2 = new AccountInfoLoadResult(task.getError());
        return result2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ AccountInfoLoadResult lambda$loadAccountInfo$12(Task task) throws Exception {
        AccountInfoLoadResult infoResult = (AccountInfoLoadResult) task.getResult();
        if (infoResult.error != null) {
            return infoResult;
        }
        BirthdayModified result = null;
        try {
            GeneralResponse<BirthdayModified> resp = (GeneralResponse) ((BiliMemberApiService) ServiceGenerator.createService(BiliMemberApiService.class)).birthdayModified().execute().body();
            if (resp != null) {
                result = (BirthdayModified) resp.data;
            }
        } catch (Exception e) {
            BLog.e(TAG, "birthdayModified error", e);
        }
        infoResult.birthDayEdited = Boolean.valueOf(result != null && result.getChanged());
        return infoResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$loadAccountInfo$13$tv-danmaku-bili-ui-personinfo-PersonInfoFragment  reason: not valid java name */
    public /* synthetic */ Object m1404lambda$loadAccountInfo$13$tvdanmakubiliuipersoninfoPersonInfoFragment(Task task) throws Exception {
        AccountInfoLoadResult infoResult = (AccountInfoLoadResult) task.getResult();
        onEventMyInfoLoadResult(infoResult);
        return null;
    }

    private void onEventMyInfoLoadResult(AccountInfoLoadResult result) {
        if (getActivity() == null) {
            return;
        }
        if (result.response != null) {
            this.mAccountInfo = result.response;
        } else if ((result.error instanceof BiliApiException) && result.error.isAuthStateError()) {
            callLogout();
            return;
        } else {
            this.mAccountInfo = PersonInfoLoadHelper.getLocalAccountInfo(getActivity());
            if (this.mAccountInfo == null) {
                showError();
                return;
            }
        }
        this.mPersonInfoModifyViewModel.setHasNft(this.mAccountInfo.getHasNft());
        hideLoading();
        setupView(result.birthDayEdited);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEventModifyPersonInfo(ModifyPersonInfoEvent event) {
        if (getActivity() != null) {
            if (this.mProgressDialog != null) {
                this.mProgressDialog.dismiss();
            }
            if (event.error != null) {
                if (event.error instanceof BiliApiException) {
                    dealWithError(event.modifyType, event.error);
                } else {
                    ToastHelper.showToastShort(getActivity(), bili.resource.common.R.string.common_global_string_196);
                }
            } else if (this.mAccountInfo == null) {
                ToastHelper.showToastShort(getActivity(), bili.resource.common.R.string.common_global_string_196);
            } else {
                dealWithSuccess(event);
            }
        }
    }

    public void onEventUploading() {
        if (getActivity() != null) {
            this.mProgressDialog = TintProgressDialog.show(getActivity(), (CharSequence) null, getResources().getString(bili.resource.common.R.string.common_global_string_227), true);
            this.mProgressDialog.setCanceledOnTouchOutside(false);
        }
    }

    private void setupView(Boolean birthDayEdited) {
        BLog.i(TAG, "setupView");
        BiliImageLoader.INSTANCE.with(this.mAvatar.getContext()).url(this.mAccountInfo.getAvatar()).into(this.mAvatar);
        this.mName.setText(this.mAccountInfo.getUserName());
        this.mUid.setText(String.valueOf(this.mAccountInfo.getMid()));
        this.mSex.setText(getSexString(this.mAccountInfo.getSex()));
        String birthdayText = this.mAccountInfo.getBirthday();
        if (!birthDayEdited.booleanValue()) {
            birthdayText = getString(bili.resource.profile.R.string.profile_global_string_16);
        }
        this.mBirthday.setText(birthdayText);
        String signature = this.mAccountInfo.getSignature();
        if (!TextUtils.isEmpty(signature)) {
            this.mSignature.setText(signature);
        } else {
            this.mSignature.setText(bili.resource.others.R.string.others_global_string_42);
        }
        if (this.mAccountInfo.getSilence() == 1) {
            long aLong = ServerClock.unreliableNow();
            long curTime = aLong != 0 ? aLong : System.currentTimeMillis();
            long curTime2 = curTime / 1000;
            long endTime = this.mAccountInfo.getEndTime();
            boolean expire = false;
            if (endTime != 0) {
                expire = curTime2 >= endTime;
            }
            this.mBannedEntry.setType(expire ? 2 : 1);
            this.mScrollView.setPadding(0, dp2Px(0), 0, dp2Px(16));
        } else {
            this.mBannedEntry.setType(0);
            this.mScrollView.setPadding(0, dp2Px(16), 0, dp2Px(16));
        }
        InviteInfo inviteInfo = this.mAccountInfo.getInviteInfo();
        if (inviteInfo == null || !inviteInfo.isDisplay()) {
            this.mInvitationLayout.setVisibility(8);
            this.mInvitationDividerLine.setVisibility(8);
        } else {
            this.mInvitationLayout.setVisibility(0);
            this.mInvitationDividerLine.setVisibility(0);
        }
        String authJson = BLRemoteConfig.getInstance().getString("account_official_entrance", "");
        this.mAuthLayout.setTag(AUTH_URL);
        if (!TextUtils.isEmpty(authJson)) {
            try {
                JSONObject jsonObject = JSONObject.parseObject(authJson);
                int disable = 0;
                if (jsonObject.containsKey("disable")) {
                    disable = jsonObject.getInteger("disable").intValue();
                }
                String link = null;
                if (jsonObject.containsKey("link")) {
                    link = jsonObject.getString("link");
                }
                if (disable != 0) {
                    this.mAuthLayout.setVisibility(8);
                    this.mAuthDividerLine.setVisibility(8);
                    return;
                }
                this.mAuthLayout.setVisibility(0);
                if (!TextUtils.isEmpty(link)) {
                    this.mAuthLayout.setTag(link);
                }
                this.mAuthDividerLine.setVisibility(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showLoading() {
        if (this.mLoadingView != null) {
            this.mLoadingView.setVisibility(0);
            this.mLoadingView.setRefreshing();
            this.mScrollView.setVisibility(8);
        }
    }

    public void hideLoading() {
        if (this.mLoadingView != null) {
            this.mLoadingView.setRefreshComplete();
            this.mLoadingView.setVisibility(8);
            this.mScrollView.setVisibility(0);
        }
    }

    public void showError() {
        if (this.mLoadingView != null) {
            if (!this.mLoadingView.isShown()) {
                this.mLoadingView.setVisibility(0);
            }
            this.mLoadingView.setRefreshError();
        }
    }

    public void dealWithError(ModifyType modifyType, Exception error) {
        int errorCode = ((BiliApiException) error).mCode;
        String errorStr = error.getMessage();
        if (RealNameErrorHelper.isRealName(errorCode)) {
            RealNameErrorHelper.showDialog(getActivity(), errorCode, errorStr);
            return;
        }
        if (TextUtils.isEmpty(errorStr)) {
            errorStr = getResources().getString(bili.resource.common.R.string.common_global_string_196);
            switch (modifyType) {
                case SEX:
                    if (errorCode == -653) {
                        errorStr = getResources().getString(bili.resource.profile.R.string.profile_global_string_14);
                        break;
                    }
                    break;
                case BIRTHDAY:
                    if (errorCode == -653) {
                        errorStr = getResources().getString(bili.resource.profile.R.string.profile_global_string_26);
                        break;
                    }
                    break;
                case AVATAR:
                    if (errorCode == -653) {
                        errorStr = getResources().getString(bili.resource.space.R.string.space_global_string_240);
                        break;
                    } else if (errorCode == -4097) {
                        errorStr = error.getMessage();
                        break;
                    } else if (errorCode == 10000) {
                        errorStr = getResources().getString(bili.resource.space.R.string.space_global_string_155);
                        break;
                    }
                    break;
                case NAME:
                    if (errorCode == -618) {
                        errorStr = getResources().getString(bili.resource.profile.R.string.profile_global_string_19);
                        break;
                    } else if (errorCode == -655) {
                        errorStr = getResources().getString(bili.resource.homepage.R.string.homepage_global_string_235);
                        break;
                    } else if (errorCode == -707) {
                        errorStr = getResources().getString(bili.resource.profile.R.string.profile_global_string_10);
                        break;
                    } else if (errorCode == 10000) {
                        errorStr = getResources().getString(bili.resource.space.R.string.space_global_string_155);
                        break;
                    }
                    break;
                case SIGNATURE:
                    if (errorCode == -653) {
                        errorStr = getResources().getString(bili.resource.profile.R.string.profile_global_string_13);
                        break;
                    } else if (errorCode == -1001) {
                        errorStr = getResources().getString(bili.resource.profile.R.string.profile_global_string_40);
                        break;
                    } else if (errorCode == 10000) {
                        errorStr = getResources().getString(bili.resource.space.R.string.space_global_string_155);
                        break;
                    }
                    break;
            }
        }
        ToastHelper.showToastShort(getActivity(), errorStr);
    }

    private void dealWithSuccess(ModifyPersonInfoEvent event) {
        switch (event.modifyType) {
            case SEX:
                if (event.response instanceof Integer) {
                    this.mAccountInfo.setSex(((Integer) event.response).intValue());
                }
                this.mSex.setText(getSexString(this.mAccountInfo.getSex()));
                break;
            case BIRTHDAY:
                this.mAccountInfo.setBirthday((String) event.response);
                this.mBirthday.setText(this.mAccountInfo.getBirthday());
                break;
            case AVATAR:
                if (event.response != null) {
                    this.mAccountInfo.setAvatar((String) event.response);
                    BiliImageLoader.INSTANCE.with(this.mAvatar.getContext()).url(this.mAccountInfo.getAvatar()).into(this.mAvatar);
                    break;
                }
                break;
            case NAME:
                this.mAccountInfo.setUserName((String) event.response);
                this.mName.setText(this.mAccountInfo.getUserName());
                break;
            case SIGNATURE:
                this.mAccountInfo.setSignature((String) event.response);
                this.mSignature.setText(this.mAccountInfo.getSignature());
                break;
        }
        PersonInfoLoadHelper.setLocalAccountInfo(getActivity(), this.mAccountInfo, true);
        ToastHelper.showToastShort(getActivity(), bili.resource.common.R.string.common_global_string_163);
    }

    public String getSexString(int sex) {
        switch (sex) {
            case 0:
                return getResources().getString(bili.resource.common.R.string.common_global_string_140);
            case 1:
                return getResources().getString(bili.resource.homepage.R.string.homepage_global_string_316);
            case 2:
                return getResources().getString(bili.resource.homepage.R.string.homepage_global_string_330);
            default:
                return getResources().getString(bili.resource.common.R.string.common_global_string_140);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.mAvatar = null;
        this.mScrollView = null;
        this.mLoadingView = null;
        this.mName = null;
        this.mUid = null;
        this.mSex = null;
        this.mBirthday = null;
        this.mSignature = null;
    }

    public static int dp2Px(int dp) {
        return (int) TypedValue.applyDimension(1, dp, Resources.getSystem().getDisplayMetrics());
    }

    public String getPvEventId() {
        return PV_EVENT_ID;
    }

    public Bundle getPvExtra() {
        return null;
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class AccountInfoLoadResult {
        public Boolean birthDayEdited;
        public Exception error;
        public AccountInfo response;

        public AccountInfoLoadResult(Exception error) {
            this.error = error;
        }

        public AccountInfoLoadResult(AccountInfo response) {
            this.response = response;
        }
    }
}