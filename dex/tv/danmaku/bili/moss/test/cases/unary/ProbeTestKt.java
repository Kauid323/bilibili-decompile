package tv.danmaku.bili.moss.test.cases.unary;

import android.content.Context;
import com.bapis.bilibili.api.probe.v1.CodeReply;
import com.bapis.bilibili.api.probe.v1.CodeReq;
import com.bapis.bilibili.api.probe.v1.ProbeMoss;
import com.bapis.bilibili.api.probe.v1.ProbeReply;
import com.bapis.bilibili.api.probe.v1.ProbeReq;
import com.bapis.bilibili.api.probe.v1.ProbeSubReply;
import com.bapis.bilibili.api.probe.v1.ProbeSubReq;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.biliid.api.BuvidHelper;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.moss.api.MossException;
import com.bilibili.lib.moss.api.MossResponseHandler;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.moss.MossTestKt;
import tv.danmaku.bili.ui.filechooser.FileUtils;

/* compiled from: ProbeTest.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0007"}, d2 = {"testReqAsync", "", "context", "Landroid/content/Context;", "testSubAsync", "testCodeSync", "testCodeAsync", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ProbeTestKt {
    public static final void testReqAsync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ProbeReq.Builder $this$testReqAsync_u24lambda_u240 = ProbeReq.newBuilder();
        $this$testReqAsync_u24lambda_u240.setBuvid(BuvidHelper.getBuvid());
        $this$testReqAsync_u24lambda_u240.setMid(BiliAccounts.get(context).mid());
        ProbeReq request = $this$testReqAsync_u24lambda_u240.build();
        MossResponseHandler<ProbeReply> mossResponseHandler = new MossResponseHandler<ProbeReply>() { // from class: tv.danmaku.bili.moss.test.cases.unary.ProbeTestKt$testReqAsync$handler$1
            public /* synthetic */ void onHeaders(Map map) {
                MossResponseHandler.-CC.$default$onHeaders(this, map);
            }

            public /* synthetic */ long onNextForAck(Object obj) {
                return MossResponseHandler.-CC.$default$onNextForAck(this, obj);
            }

            public /* synthetic */ void onUpstreamAck(Long l) {
                MossResponseHandler.-CC.$default$onUpstreamAck(this, l);
            }

            public /* synthetic */ void onValid() {
                MossResponseHandler.-CC.$default$onValid(this);
            }

            public void onNext(ProbeReply value) {
                if (value == null) {
                    BLog.vfmt(MossTestKt.TAG, "Async onNext returns null.", new Object[0]);
                    return;
                }
                String content = value.getContent();
                BLog.e(MossTestKt.TAG, "Async onNext " + content + ", " + value.getTimestamp() + FileUtils.HIDDEN_PREFIX);
            }

            public void onError(MossException t) {
                BLog.e(MossTestKt.TAG, "Async onError " + t);
            }

            public void onCompleted() {
                BLog.e(MossTestKt.TAG, "Async onCompleted");
            }
        };
        ProbeMoss probeMoss = new ProbeMoss("broadcast.chat.bilibili.com", (int) BR.playerNickTextColor, (CallOptions) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNull(request);
        probeMoss.testReq(request, mossResponseHandler);
    }

    public static final void testSubAsync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ProbeSubReq.Builder $this$testSubAsync_u24lambda_u240 = ProbeSubReq.newBuilder();
        $this$testSubAsync_u24lambda_u240.setBuvid(BuvidHelper.getBuvid());
        ProbeSubReq subRequest = $this$testSubAsync_u24lambda_u240.build();
        MossResponseHandler<ProbeSubReply> mossResponseHandler = new MossResponseHandler<ProbeSubReply>() { // from class: tv.danmaku.bili.moss.test.cases.unary.ProbeTestKt$testSubAsync$subHandler$1
            public /* synthetic */ void onHeaders(Map map) {
                MossResponseHandler.-CC.$default$onHeaders(this, map);
            }

            public /* synthetic */ long onNextForAck(Object obj) {
                return MossResponseHandler.-CC.$default$onNextForAck(this, obj);
            }

            public /* synthetic */ void onUpstreamAck(Long l) {
                MossResponseHandler.-CC.$default$onUpstreamAck(this, l);
            }

            public /* synthetic */ void onValid() {
                MossResponseHandler.-CC.$default$onValid(this);
            }

            public void onNext(ProbeSubReply value) {
                if (value == null) {
                    BLog.vfmt(MossTestKt.TAG, "Async onNext returns null.", new Object[0]);
                    return;
                }
                BLog.e(MossTestKt.TAG, "Async onNext messageId = " + value.getMessageId());
            }

            public void onError(MossException t) {
                BLog.e(MossTestKt.TAG, "Async onError " + t);
            }

            public void onCompleted() {
                BLog.e(MossTestKt.TAG, "Async onCompleted");
            }
        };
        ProbeMoss service = new ProbeMoss("broadcast.chat.bilibili.com", (int) BR.playerNickTextColor, (CallOptions) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNull(subRequest);
        service.testSub(subRequest, mossResponseHandler);
    }

    public static final void testCodeSync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        CodeReq.Builder $this$testCodeSync_u24lambda_u240 = CodeReq.newBuilder();
        $this$testCodeSync_u24lambda_u240.setCode(-400L);
        CodeReq codeReq = $this$testCodeSync_u24lambda_u240.build();
        try {
            ProbeMoss probeMoss = new ProbeMoss(MossTestKt.hostByPolicy(), 0, (CallOptions) null, 6, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNull(codeReq);
            CodeReply reply = probeMoss.executeTestCode(codeReq);
            if (reply != null) {
                BLog.vfmt(MossTestKt.TAG, "Sync request codeReply=%s.", reply);
            } else {
                BLog.vfmt(MossTestKt.TAG, "Sync request get null.", new Object[0]);
            }
        } catch (MossException e) {
            BLog.efmt(MossTestKt.TAG, "Sync request throwable=%s.", e.toPrintString());
        }
    }

    public static final void testCodeAsync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        CodeReq.Builder $this$testCodeAsync_u24lambda_u240 = CodeReq.newBuilder();
        $this$testCodeAsync_u24lambda_u240.setCode(-400L);
        CodeReq codeReq = $this$testCodeAsync_u24lambda_u240.build();
        MossResponseHandler<CodeReply> mossResponseHandler = new MossResponseHandler<CodeReply>() { // from class: tv.danmaku.bili.moss.test.cases.unary.ProbeTestKt$testCodeAsync$handler$1
            public /* synthetic */ void onHeaders(Map map) {
                MossResponseHandler.-CC.$default$onHeaders(this, map);
            }

            public /* synthetic */ long onNextForAck(Object obj) {
                return MossResponseHandler.-CC.$default$onNextForAck(this, obj);
            }

            public /* synthetic */ void onUpstreamAck(Long l) {
                MossResponseHandler.-CC.$default$onUpstreamAck(this, l);
            }

            public /* synthetic */ void onValid() {
                MossResponseHandler.-CC.$default$onValid(this);
            }

            public void onNext(CodeReply value) {
                if (value == null) {
                    BLog.vfmt(MossTestKt.TAG, "Async onNext returns null.", new Object[0]);
                } else {
                    BLog.v(MossTestKt.TAG, "Async onNext, codeReply=" + value + FileUtils.HIDDEN_PREFIX);
                }
            }

            public void onError(MossException t) {
                BLog.e(MossTestKt.TAG, "Async onError " + t);
            }

            public void onCompleted() {
                BLog.v(MossTestKt.TAG, "Async onCompleted");
            }
        };
        ProbeMoss probeMoss = new ProbeMoss(MossTestKt.hostByPolicy(), 0, (CallOptions) null, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNull(codeReq);
        probeMoss.testCode(codeReq, mossResponseHandler);
    }
}