package tv.danmaku.bili.activities.login;

import android.content.Context;
import bili.resource.homepage.R;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.AccountException;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.BiliAccountsKt;
import com.bilibili.lib.accounts.model.AuthorizeCode;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SSOCodeActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.activities.login.SSOCodeActivity$doAuthorizing$2", f = "SSOCodeActivity.kt", i = {}, l = {BR.exposureEntry}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SSOCodeActivity$doAuthorizing$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SSOCodeActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SSOCodeActivity$doAuthorizing$2(SSOCodeActivity sSOCodeActivity, Continuation<? super SSOCodeActivity$doAuthorizing$2> continuation) {
        super(2, continuation);
        this.this$0 = sSOCodeActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SSOCodeActivity$doAuthorizing$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v8, types: [com.bilibili.lib.accounts.model.AuthorizeCode] */
    public final Object invokeSuspend(Object $result) {
        TintProgressDialog tintProgressDialog;
        boolean isLogout;
        String str;
        String str2;
        String str3;
        String str4;
        Object $result2;
        Object $result3;
        TintProgressDialog tintProgressDialog2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure((Object) $result);
                    String accessKey = BiliAccounts.get((Context) this.this$0).getAccessKey();
                    String accessKey2 = accessKey == null ? "" : accessKey;
                    this.this$0.targetSignatureSync();
                    BiliAccounts biliAccounts = BiliAccounts.get((Context) this.this$0);
                    Intrinsics.checkNotNullExpressionValue(biliAccounts, "get(...)");
                    str = this.this$0.mTargetSubId;
                    String str5 = str == null ? "" : str;
                    str2 = this.this$0.mTargetAppKey;
                    String str6 = str2 == null ? "" : str2;
                    str3 = this.this$0.mTargetPackageName;
                    str4 = this.this$0.mTargetSignature;
                    String str7 = str4 == null ? "" : str4;
                    this.label = 1;
                    Object suspendRequestForAuthorizeCode = BiliAccountsKt.suspendRequestForAuthorizeCode(biliAccounts, accessKey2, str5, str6, str3, str7, (Continuation) this);
                    if (suspendRequestForAuthorizeCode != coroutine_suspended) {
                        $result2 = $result;
                        $result3 = suspendRequestForAuthorizeCode;
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure((Object) $result);
                    $result2 = $result;
                    $result3 = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                $result = (AuthorizeCode) $result3;
                tintProgressDialog2 = this.this$0.mDialog;
                if (tintProgressDialog2 != null) {
                    tintProgressDialog2.dismiss();
                }
                this.this$0.setAuthorizeResult($result);
            } catch (Exception e) {
                Object obj = $result2;
                e = e;
                $result = obj;
                tintProgressDialog = this.this$0.mDialog;
                if (tintProgressDialog != null) {
                    tintProgressDialog.dismiss();
                }
                if (e instanceof AccountException) {
                    isLogout = this.this$0.isLogout(e.code());
                    if (isLogout) {
                        ToastHelper.showToastShort((Context) this.this$0, R.string.homepage_global_string_157);
                    } else {
                        ToastHelper.showToastLong((Context) this.this$0, e.getMessage());
                    }
                } else {
                    ToastHelper.showToastLong((Context) this.this$0, R.string.homepage_global_string_223);
                }
                return Unit.INSTANCE;
            }
        } catch (Exception e2) {
            e = e2;
        }
        return Unit.INSTANCE;
    }
}