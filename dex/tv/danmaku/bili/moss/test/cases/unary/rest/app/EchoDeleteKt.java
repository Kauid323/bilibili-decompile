package tv.danmaku.bili.moss.test.cases.unary.rest.app;

import com.bapis.bilibili.api.probe.v1.ProbeServiceMoss;
import com.bapis.bilibili.api.probe.v1.SimpleMessage;
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

/* compiled from: EchoDelete.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\b\u0010\u0002\u001a\u00020\u0001H\u0000¨\u0006\u0003"}, d2 = {"testEchoDeleteSync", "", "testEchoDeleteAsync", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class EchoDeleteKt {
    public static final void testEchoDeleteSync() {
        GeneratedMessageLite buildTestSimpleMessage = ModelMocksKt.buildTestSimpleMessage();
        try {
            GeneratedMessageLite executeEchoDelete = new ProbeServiceMoss((String) null, 0, OptionsKt.contentTypeOptions(), 3, (DefaultConstructorMarker) null).executeEchoDelete(buildTestSimpleMessage);
            Intrinsics.checkNotNull(executeEchoDelete);
            CheckKt.checkEqual(buildTestSimpleMessage, executeEchoDelete);
        } catch (Exception e) {
            BLog.e(MossTestKt.TAG, "testEchoDeleteSync throws " + e);
        }
    }

    public static final void testEchoDeleteAsync() {
        final SimpleMessage req = ModelMocksKt.buildTestSimpleMessage();
        new ProbeServiceMoss((String) null, 0, OptionsKt.contentTypeOptions(), 3, (DefaultConstructorMarker) null).echoDelete(req, new MossResponseHandler<SimpleMessage>() { // from class: tv.danmaku.bili.moss.test.cases.unary.rest.app.EchoDeleteKt$testEchoDeleteAsync$handler$1
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

            public void onNext(SimpleMessage value) {
                if (value == null) {
                    BLog.efmt(MossTestKt.TAG, "testEchoDeleteAsync onNext returns null.", new Object[0]);
                    return;
                }
                try {
                    CheckKt.checkEqual(req, (GeneratedMessageLite) value);
                } catch (Exception e) {
                    BLog.efmt(MossTestKt.TAG, "testEchoDeleteAsync check failed " + e, new Object[0]);
                }
            }

            public void onError(MossException t) {
                BLog.e(MossTestKt.TAG, "testEchoDeleteAsync onError " + t);
            }

            public void onCompleted() {
                BLog.e(MossTestKt.TAG, "testEchoDeleteAsync onCompleted");
            }
        });
    }
}