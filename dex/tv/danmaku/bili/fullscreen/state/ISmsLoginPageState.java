package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.ToastInfo;

/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J!\u0010\u000e\u001a\u00020\u00002\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\b\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015H&R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0001\t\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginPage;", "loginType", "", "getLoginType", "()Ljava/lang/String;", "netCodeState", "Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "getNetCodeState", "()Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "agreementChecked", "", "getAgreementChecked", "()Z", "mutateInput", "mutate", "Lkotlin/Function1;", "Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;", "Lkotlin/ExtensionFunctionType;", "toast", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginCountingState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginIdleState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginLoadingState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginValidState;", "Ltv/danmaku/bili/fullscreen/state/NetCodeEnableState;", "Ltv/danmaku/bili/fullscreen/state/SmsLoginLoadingCountingState;", "Ltv/danmaku/bili/fullscreen/state/SmsLoginLoadingIdleState;", "Ltv/danmaku/bili/fullscreen/state/SmsLoginPageInitialState;", "Ltv/danmaku/bili/fullscreen/state/SmsLoginSelectCountryCodeState;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface ISmsLoginPageState extends IFullscreenLoginPage {
    boolean getAgreementChecked();

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    String getLoginType();

    NetCodeState getNetCodeState();

    ISmsLoginPageState mutateInput(Function1<? super SmsLoginInput, SmsLoginInput> function1);

    ISmsLoginPageState toast(ToastInfo toastInfo);

    /* compiled from: SmsLoginPageState.kt */
    /* renamed from: tv.danmaku.bili.fullscreen.state.ISmsLoginPageState$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final /* synthetic */ class CC {
        public static String $default$getLoginType(ISmsLoginPageState _this) {
            return "sms_fullscreen_new";
        }
    }
}