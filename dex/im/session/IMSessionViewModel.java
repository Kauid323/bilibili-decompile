package im.session;

import com.bapis.bilibili.app.im.v1.KAutoReplyToast;
import com.bapis.bilibili.app.im.v1.KSessionPageType;
import com.tencent.tauth.AuthActivity;
import im.base.IMToast;
import im.session.model.IMSessionAlert;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: IMSessionViewModel.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H'R\u0018\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010\u001cR\"\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u00188&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0006\u001a\u0004\b$\u0010\u001c¨\u0006%À\u0006\u0003"}, d2 = {"Lim/session/IMSessionViewModel;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope$annotations", "()V", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lim/session/IMState;", "getState$annotations", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "pageType", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "getPageType", "()Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "dispatch", "", AuthActivity.ACTION_KEY, "Lim/session/IMAction;", "toastFlow", "Lkotlinx/coroutines/flow/Flow;", "Lim/base/IMToast;", "getToastFlow$annotations", "getToastFlow", "()Lkotlinx/coroutines/flow/Flow;", "autoReplyBubble", "Lcom/bapis/bilibili/app/im/v1/KAutoReplyToast;", "getAutoReplyBubble$annotations", "getAutoReplyBubble", "alertFlow", "Lim/session/model/IMSessionAlert;", "getAlertFlow$annotations", "getAlertFlow", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMSessionViewModel extends AutoCloseable {

    /* compiled from: IMSessionViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getAlertFlow$annotations() {
        }

        public static /* synthetic */ void getAutoReplyBubble$annotations() {
        }

        public static /* synthetic */ void getScope$annotations() {
        }

        public static /* synthetic */ void getState$annotations() {
        }

        public static /* synthetic */ void getToastFlow$annotations() {
        }
    }

    void dispatch(IMAction iMAction);

    Flow<IMSessionAlert> getAlertFlow();

    Flow<KAutoReplyToast> getAutoReplyBubble();

    KSessionPageType getPageType();

    CoroutineScope getScope();

    StateFlow<IMState> getState();

    Flow<IMToast> getToastFlow();
}