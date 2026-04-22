package tv.danmaku.bili.ui.personinfo;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bilibili.api.BiliApiException;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.ui.BaseNonUIFragment;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.personinfo.PersonInfoLoadFragment;
import tv.danmaku.bili.ui.personinfo.api.BiliMemberApiService;
import tv.danmaku.bili.ui.personinfo.api.PersonInfoModifyNameBean;
import tv.danmaku.bili.ui.personinfo.event.ModifyPersonInfoEvent;
import tv.danmaku.bili.ui.personinfo.event.ModifyType;
import tv.danmaku.bili.ui.personinfo.event.PersonInfoModifyViewModel;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.bili.utils.PersonInfoReport;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PersonInfoLoadFragment.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 (2\u00020\u0001:\u0002()B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J6\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0011J\u000e\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006*"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/PersonInfoLoadFragment;", "Lcom/bilibili/lib/ui/BaseNonUIFragment;", "<init>", "()V", "personInfoModifyViewModel", "Ltv/danmaku/bili/ui/personinfo/event/PersonInfoModifyViewModel;", "getPersonInfoModifyViewModel", "()Ltv/danmaku/bili/ui/personinfo/event/PersonInfoModifyViewModel;", "setPersonInfoModifyViewModel", "(Ltv/danmaku/bili/ui/personinfo/event/PersonInfoModifyViewModel;)V", "apiService", "Ltv/danmaku/bili/ui/personinfo/api/BiliMemberApiService;", "getApiService", "()Ltv/danmaku/bili/ui/personinfo/api/BiliMemberApiService;", "apiService$delegate", "Lkotlin/Lazy;", "accessKey", "", "kotlin.jvm.PlatformType", "getAccessKey", "()Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "modifyUserName", "isNickFree", "", "name", "from", LoginSceneProcessor.SCENE_KEY, "modifyCallBack", "Ltv/danmaku/bili/ui/personinfo/PersonInfoLoadFragment$ModifyCallBack;", "modifySignature", "signature", "modifySex", "sex", "", "modifyBirthday", "birthday", "Companion", "ModifyCallBack", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PersonInfoLoadFragment extends BaseNonUIFragment {
    public static final int CONNECT_NETWORK_ERROR = -4097;
    public static final int ERROR_CODE_MODIFY_FORBIDDEN = 10000;
    private static final String TAG = "PersonInfoLoadFragment";
    private final Lazy apiService$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoLoadFragment$$ExternalSyntheticLambda0
        public final Object invoke() {
            BiliMemberApiService apiService_delegate$lambda$0;
            apiService_delegate$lambda$0 = PersonInfoLoadFragment.apiService_delegate$lambda$0();
            return apiService_delegate$lambda$0;
        }
    });
    private PersonInfoModifyViewModel personInfoModifyViewModel;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: PersonInfoLoadFragment.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/PersonInfoLoadFragment$ModifyCallBack;", "", "onModifyPersonInfo", "", "event", "Ltv/danmaku/bili/ui/personinfo/event/ModifyPersonInfoEvent;", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface ModifyCallBack {
        void onModifyPersonInfo(ModifyPersonInfoEvent modifyPersonInfoEvent);
    }

    public final PersonInfoModifyViewModel getPersonInfoModifyViewModel() {
        return this.personInfoModifyViewModel;
    }

    public final void setPersonInfoModifyViewModel(PersonInfoModifyViewModel personInfoModifyViewModel) {
        this.personInfoModifyViewModel = personInfoModifyViewModel;
    }

    private final BiliMemberApiService getApiService() {
        return (BiliMemberApiService) this.apiService$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BiliMemberApiService apiService_delegate$lambda$0() {
        return (BiliMemberApiService) ServiceGenerator.createService(BiliMemberApiService.class);
    }

    private final String getAccessKey() {
        return BiliAccounts.get(getContext()).getAccessKey();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModelStoreOwner activity = getActivity();
        if (activity != null) {
            this.personInfoModifyViewModel = (PersonInfoModifyViewModel) new ViewModelProvider(activity).get(PersonInfoModifyViewModel.class);
        }
    }

    public static /* synthetic */ void modifyUserName$default(PersonInfoLoadFragment personInfoLoadFragment, boolean z, String str, String str2, String str3, ModifyCallBack modifyCallBack, int i, Object obj) {
        if ((i & 16) != 0) {
            modifyCallBack = null;
        }
        personInfoLoadFragment.modifyUserName(z, str, str2, str3, modifyCallBack);
    }

    public final void modifyUserName(final boolean isNickFree, final String name, final String from, final String scene, final ModifyCallBack modifyCallBack) {
        Intrinsics.checkNotNullParameter(name, "name");
        getApiService().modifyUserName(getAccessKey(), name).enqueue(new BiliApiDataCallback<PersonInfoModifyNameBean>() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoLoadFragment$modifyUserName$1
            public void onDataSuccess(PersonInfoModifyNameBean data) {
                MutableLiveData<ModifyPersonInfoEvent> modifyPersonInfoEvent;
                PersonInfoModifyViewModel personInfoModifyViewModel = PersonInfoLoadFragment.this.getPersonInfoModifyViewModel();
                if (personInfoModifyViewModel != null && (modifyPersonInfoEvent = personInfoModifyViewModel.getModifyPersonInfoEvent()) != null) {
                    modifyPersonInfoEvent.setValue(new ModifyPersonInfoEvent(ModifyType.NAME, name, null, 4, null));
                }
                if (data != null) {
                    data.originName = name;
                    PersonInfoLoadFragment.ModifyCallBack modifyCallBack2 = modifyCallBack;
                    if (modifyCallBack2 != null) {
                        modifyCallBack2.onModifyPersonInfo(new ModifyPersonInfoEvent(ModifyType.NAME, data, null, 4, null));
                    }
                } else {
                    PersonInfoLoadFragment.ModifyCallBack modifyCallBack3 = modifyCallBack;
                    if (modifyCallBack3 != null) {
                        modifyCallBack3.onModifyPersonInfo(new ModifyPersonInfoEvent(ModifyType.NAME, name, null, 4, null));
                    }
                }
                PersonInfoReport.reportModifyNickNameCodeShow("0", isNickFree ? "1" : "2", from, scene);
            }

            public void onError(Throwable error) {
                MutableLiveData<ModifyPersonInfoEvent> modifyPersonInfoEvent;
                Intrinsics.checkNotNullParameter(error, "error");
                PersonInfoModifyViewModel personInfoModifyViewModel = PersonInfoLoadFragment.this.getPersonInfoModifyViewModel();
                if (personInfoModifyViewModel != null && (modifyPersonInfoEvent = personInfoModifyViewModel.getModifyPersonInfoEvent()) != null) {
                    modifyPersonInfoEvent.setValue(new ModifyPersonInfoEvent(ModifyType.NAME, null, (Exception) error, 2, null));
                }
                PersonInfoLoadFragment.ModifyCallBack modifyCallBack2 = modifyCallBack;
                if (modifyCallBack2 != null) {
                    modifyCallBack2.onModifyPersonInfo(new ModifyPersonInfoEvent(ModifyType.NAME, null, (Exception) error, 2, null));
                }
                if (error instanceof BiliApiException) {
                    PersonInfoReport.reportModifyNickNameCodeShow(String.valueOf(((BiliApiException) error).mCode), isNickFree ? "1" : "2", from, scene);
                }
            }

            public boolean isCancel() {
                return PersonInfoLoadFragment.this.getActivity() == null;
            }
        });
    }

    public final void modifySignature(final String signature) {
        Intrinsics.checkNotNullParameter(signature, "signature");
        getApiService().modifySignature(getAccessKey(), signature).enqueue(new BiliApiDataCallback<Void>() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoLoadFragment$modifySignature$1
            public void onDataSuccess(Void result) {
                MutableLiveData<ModifyPersonInfoEvent> modifyPersonInfoEvent;
                PersonInfoModifyViewModel personInfoModifyViewModel = PersonInfoLoadFragment.this.getPersonInfoModifyViewModel();
                if (personInfoModifyViewModel != null && (modifyPersonInfoEvent = personInfoModifyViewModel.getModifyPersonInfoEvent()) != null) {
                    modifyPersonInfoEvent.setValue(new ModifyPersonInfoEvent(ModifyType.SIGNATURE, signature, null, 4, null));
                }
            }

            public void onError(Throwable error) {
                MutableLiveData<ModifyPersonInfoEvent> modifyPersonInfoEvent;
                Intrinsics.checkNotNullParameter(error, "error");
                PersonInfoModifyViewModel personInfoModifyViewModel = PersonInfoLoadFragment.this.getPersonInfoModifyViewModel();
                if (personInfoModifyViewModel != null && (modifyPersonInfoEvent = personInfoModifyViewModel.getModifyPersonInfoEvent()) != null) {
                    modifyPersonInfoEvent.setValue(new ModifyPersonInfoEvent(ModifyType.SIGNATURE, null, (Exception) error, 2, null));
                }
            }

            public boolean isCancel() {
                return PersonInfoLoadFragment.this.getActivity() == null;
            }
        });
    }

    public final void modifySex(final int sex) {
        getApiService().modifySex(getAccessKey(), sex).enqueue(new BiliApiDataCallback<Void>() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoLoadFragment$modifySex$1
            public void onDataSuccess(Void response) {
                MutableLiveData<ModifyPersonInfoEvent> modifyPersonInfoEvent;
                PersonInfoModifyViewModel personInfoModifyViewModel = PersonInfoLoadFragment.this.getPersonInfoModifyViewModel();
                if (personInfoModifyViewModel != null && (modifyPersonInfoEvent = personInfoModifyViewModel.getModifyPersonInfoEvent()) != null) {
                    modifyPersonInfoEvent.setValue(new ModifyPersonInfoEvent(ModifyType.SEX, Integer.valueOf(sex), null, 4, null));
                }
            }

            public void onError(Throwable error) {
                MutableLiveData<ModifyPersonInfoEvent> modifyPersonInfoEvent;
                Intrinsics.checkNotNullParameter(error, "error");
                PersonInfoModifyViewModel personInfoModifyViewModel = PersonInfoLoadFragment.this.getPersonInfoModifyViewModel();
                if (personInfoModifyViewModel != null && (modifyPersonInfoEvent = personInfoModifyViewModel.getModifyPersonInfoEvent()) != null) {
                    modifyPersonInfoEvent.setValue(new ModifyPersonInfoEvent(ModifyType.SEX, null, (Exception) error, 2, null));
                }
            }

            public boolean isCancel() {
                return PersonInfoLoadFragment.this.getActivity() == null;
            }
        });
    }

    public final void modifyBirthday(final String birthday) {
        Intrinsics.checkNotNullParameter(birthday, "birthday");
        getApiService().modifyBirthday(getAccessKey(), birthday).enqueue(new BiliApiDataCallback<Void>() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoLoadFragment$modifyBirthday$1
            public void onDataSuccess(Void response) {
                MutableLiveData<ModifyPersonInfoEvent> modifyPersonInfoEvent;
                PersonInfoModifyViewModel personInfoModifyViewModel = PersonInfoLoadFragment.this.getPersonInfoModifyViewModel();
                if (personInfoModifyViewModel != null && (modifyPersonInfoEvent = personInfoModifyViewModel.getModifyPersonInfoEvent()) != null) {
                    modifyPersonInfoEvent.setValue(new ModifyPersonInfoEvent(ModifyType.BIRTHDAY, birthday, null, 4, null));
                }
            }

            public void onError(Throwable error) {
                MutableLiveData<ModifyPersonInfoEvent> modifyPersonInfoEvent;
                Intrinsics.checkNotNullParameter(error, "error");
                PersonInfoModifyViewModel personInfoModifyViewModel = PersonInfoLoadFragment.this.getPersonInfoModifyViewModel();
                if (personInfoModifyViewModel != null && (modifyPersonInfoEvent = personInfoModifyViewModel.getModifyPersonInfoEvent()) != null) {
                    modifyPersonInfoEvent.setValue(new ModifyPersonInfoEvent(ModifyType.BIRTHDAY, null, (Exception) error, 2, null));
                }
            }

            public boolean isCancel() {
                return PersonInfoLoadFragment.this.getActivity() == null;
            }
        });
    }

    /* compiled from: PersonInfoLoadFragment.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/PersonInfoLoadFragment$Companion;", "", "<init>", "()V", "TAG", "", "CONNECT_NETWORK_ERROR", "", "ERROR_CODE_MODIFY_FORBIDDEN", "getInstance", "Ltv/danmaku/bili/ui/personinfo/PersonInfoLoadFragment;", "fm", "Landroidx/fragment/app/FragmentManager;", "attachTo", "", "fragment", "Landroidx/fragment/app/Fragment;", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PersonInfoLoadFragment getInstance(FragmentManager fm) {
            Intrinsics.checkNotNullParameter(fm, "fm");
            PersonInfoLoadFragment findFragmentByTag = fm.findFragmentByTag(PersonInfoLoadFragment.TAG);
            if (findFragmentByTag instanceof PersonInfoLoadFragment) {
                return findFragmentByTag;
            }
            return null;
        }

        @JvmStatic
        public final void attachTo(FragmentManager fm, Fragment fragment) {
            Intrinsics.checkNotNullParameter(fm, "fm");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            fm.beginTransaction().add(fragment, PersonInfoLoadFragment.TAG).commit();
        }
    }

    @JvmStatic
    public static final PersonInfoLoadFragment getInstance(FragmentManager fm) {
        return Companion.getInstance(fm);
    }

    @JvmStatic
    public static final void attachTo(FragmentManager fm, Fragment fragment) {
        Companion.attachTo(fm, fragment);
    }
}