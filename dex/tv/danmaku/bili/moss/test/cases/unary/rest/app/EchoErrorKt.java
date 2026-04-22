package tv.danmaku.bili.moss.test.cases.unary.rest.app;

import com.bapis.bilibili.api.probe.v1.ErrorMessage;
import com.bapis.bilibili.api.probe.v1.ProbeServiceMoss;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.moss.api.MossException;
import com.bilibili.lib.moss.api.MossResponseHandler;
import com.google.protobuf.GeneratedMessageLite;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.moss.MossTestKt;
import tv.danmaku.bili.moss.test.cases.unary.rest.CheckKt;
import tv.danmaku.bili.moss.test.cases.unary.rest.ModelMocksKt;
import tv.danmaku.bili.moss.test.cases.unary.rest.OptionsKt;

/* compiled from: EchoError.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\b\u0010\u0002\u001a\u00020\u0001H\u0000¨\u0006\u0003"}, d2 = {"testEchoErrorSync", "", "testEchoErrorAsync", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class EchoErrorKt {
    public static final void testEchoErrorSync() {
        GeneratedMessageLite buildErrorMessage = ModelMocksKt.buildErrorMessage();
        try {
            GeneratedMessageLite executeEchoError = new ProbeServiceMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null).executeEchoError(buildErrorMessage);
            Intrinsics.checkNotNull(executeEchoError);
            CheckKt.checkEqual(buildErrorMessage, executeEchoError);
        } catch (Exception e) {
            BLog.e(MossTestKt.TAG, "testEchoErrorSync throws " + e);
        }
    }

    public static final void testEchoErrorAsync() {
        final ErrorMessage req = ModelMocksKt.buildErrorMessage();
        new ProbeServiceMoss((String) null, 0, OptionsKt.contentTypeOptions(), 3, (DefaultConstructorMarker) null).echoError(req, new MossResponseHandler<ErrorMessage>() { // from class: tv.danmaku.bili.moss.test.cases.unary.rest.app.EchoErrorKt$testEchoErrorAsync$handler$1
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

            public void onNext(ErrorMessage value) {
                if (value == null) {
                    BLog.efmt(MossTestKt.TAG, "testEchoErrorSync onNext returns null.", new Object[0]);
                    return;
                }
                try {
                    CheckKt.checkEqual(req, (GeneratedMessageLite) value);
                } catch (Exception e) {
                    BLog.efmt(MossTestKt.TAG, "testEchoErrorSync check failed " + e, new Object[0]);
                }
            }

            public void onError(MossException t) {
                BLog.e(MossTestKt.TAG, "testEchoErrorSync onError " + t);
            }

            public void onCompleted() {
                BLog.e(MossTestKt.TAG, "testEchoErrorSync onCompleted");
            }
        });
    }
}