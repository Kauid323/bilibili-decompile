package tv.danmaku.bili.moss.test.cases.unary;

import com.bapis.bilibili.community.service.dm.v1.DMMoss;
import com.bapis.bilibili.community.service.dm.v1.DmSegMobileReply;
import com.bapis.bilibili.community.service.dm.v1.DmSegMobileReq;
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

/* compiled from: DfmTest.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003¨\u0006\u0006"}, d2 = {"testDfmSegSync", "", "aid", "", "cid", "testDfmSegAsync", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DfmTestKt {
    public static final void testDfmSegSync(long aid, long cid) {
        DmSegMobileReq request = DmSegMobileReq.newBuilder().setPid(aid).setOid(cid).setSegmentIndex(1L).setTeenagersMode(0).setType(1).build();
        try {
            DMMoss dMMoss = new DMMoss(MossTestKt.hostByPolicy(), 0, (CallOptions) null, 6, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNull(request);
            DmSegMobileReply reply = dMMoss.executeDmSegMobile(request);
            if (reply != null) {
                BLog.vfmt(MossTestKt.TAG, "Sync request codeReply=%s.", reply);
            } else {
                BLog.vfmt(MossTestKt.TAG, "Sync request get null.", new Object[0]);
            }
        } catch (MossException e) {
            BLog.efmt(MossTestKt.TAG, "Sync request throwable=%s.", e.toPrintString());
        }
    }

    public static final void testDfmSegAsync(long aid, long cid) {
        DmSegMobileReq request = DmSegMobileReq.newBuilder().setPid(aid).setOid(cid).setSegmentIndex(1L).setTeenagersMode(0).setType(1).build();
        MossResponseHandler<DmSegMobileReply> mossResponseHandler = new MossResponseHandler<DmSegMobileReply>() { // from class: tv.danmaku.bili.moss.test.cases.unary.DfmTestKt$testDfmSegAsync$handler$1
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

            public void onNext(DmSegMobileReply value) {
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
        DMMoss dMMoss = new DMMoss(MossTestKt.hostByPolicy(), 0, (CallOptions) null, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNull(request);
        dMMoss.dmSegMobile(request, mossResponseHandler);
    }
}