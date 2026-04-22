package tv.danmaku.bili.ui.main2.mine;

import android.view.View;
import com.bapis.bilibili.app.mine.v1.DisplayPos;
import com.bapis.bilibili.app.mine.v1.DisplayReportReq;
import com.bapis.bilibili.app.mine.v1.MineMoss;
import com.bapis.bilibili.app.mine.v1.MineMossKtxKt;
import com.bilibili.lib.moss.api.CallOptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.api.AccountMine;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeUserCenterFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$handleFansRedDot$1$1", f = "HomeUserCenterFragment.kt", i = {}, l = {1851}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HomeUserCenterFragment$handleFansRedDot$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AccountMine.FansEffect $effect;
    int label;
    final /* synthetic */ HomeUserCenterFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeUserCenterFragment$handleFansRedDot$1$1(AccountMine.FansEffect fansEffect, HomeUserCenterFragment homeUserCenterFragment, Continuation<? super HomeUserCenterFragment$handleFansRedDot$1$1> continuation) {
        super(2, continuation);
        this.$effect = fansEffect;
        this.this$0 = homeUserCenterFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeUserCenterFragment$handleFansRedDot$1$1(this.$effect, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        View view;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    DisplayReportReq req = DisplayReportReq.newBuilder().addContent(DisplayReportReq.ReportContent.newBuilder().setTimes(1L).setPos(DisplayPos.FANS_EFFECT).setExtra(this.$effect.reportInfo).build()).build();
                    MineMoss mineMoss = new MineMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
                    Intrinsics.checkNotNull(req);
                    this.label = 1;
                    if (MineMossKtxKt.suspendDisplayReport(mineMoss, req, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            view = this.this$0.mFansAchieveBadge;
            if (view != null) {
                view.setVisibility(8);
            }
        } catch (Exception e) {
        }
        return Unit.INSTANCE;
    }
}