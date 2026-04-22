package tv.danmaku.bili.activities.login;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.model.AuthorizeAgreement;
import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SSOCodeActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.activities.login.SSOCodeActivity$loadAgreement$1", f = "SSOCodeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SSOCodeActivity$loadAgreement$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SSOCodeActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SSOCodeActivity$loadAgreement$1(SSOCodeActivity sSOCodeActivity, Continuation<? super SSOCodeActivity$loadAgreement$1> continuation) {
        super(2, continuation);
        this.this$0 = sSOCodeActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SSOCodeActivity$loadAgreement$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0076, code lost:
        r2 = r6.this$0.mAgreementText;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        TextView textView;
        ProgressBar progressBar;
        String str;
        String str2;
        ProgressBar progressBar2;
        TextView textView2;
        String it;
        TextView textView3;
        Long longOrNull;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                try {
                    BiliAccounts biliAccounts = BiliAccounts.get(FoundationAlias.getFapp());
                    str = this.this$0.mTargetSubId;
                    long longValue = (str == null || (longOrNull = StringsKt.toLongOrNull(str)) == null) ? 0L : longOrNull.longValue();
                    str2 = this.this$0.mTargetAppKey;
                    if (str2 == null) {
                        str2 = "";
                    }
                    AuthorizeAgreement agreement = biliAccounts.getAuthAgreement(longValue, str2);
                    progressBar2 = this.this$0.mLoading;
                    if (progressBar2 != null) {
                        progressBar2.setVisibility(8);
                    }
                    textView2 = this.this$0.mAgreementText;
                    if (textView2 != null) {
                        textView2.setVisibility(0);
                    }
                    if (agreement != null && (it = agreement.getAgreement()) != null) {
                        if (!(!StringsKt.isBlank(it))) {
                            it = null;
                        }
                        if (it != null && textView3 != null) {
                            textView3.setText(it);
                        }
                    }
                } catch (Exception e) {
                    textView = this.this$0.mAgreementText;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                    progressBar = this.this$0.mLoading;
                    if (progressBar != null) {
                        progressBar.setVisibility(8);
                    }
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}