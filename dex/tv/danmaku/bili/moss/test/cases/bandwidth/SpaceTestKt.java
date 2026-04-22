package tv.danmaku.bili.moss.test.cases.bandwidth;

import bili.resource.homepage.R;
import com.bapis.bilibili.app.space.v1.ArchiveReply;
import com.bapis.bilibili.app.space.v1.ArchiveReq;
import com.bapis.bilibili.app.space.v1.SpaceMoss;
import com.bilibili.app.authorspace.api.BiliSpaceApiService;
import com.bilibili.app.authorspace.api.BiliSpaceVideoList;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.moss.api.MossException;
import com.bilibili.lib.moss.api.MossResponseHandler;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.moss.MossTestKt;

/* compiled from: SpaceTest.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"testSpaceSync", "", "testSpaceAsync", "getSpaceArchivePb", "Lcom/bapis/bilibili/app/space/v1/ArchiveReq;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SpaceTestKt {
    public static final void testSpaceSync() {
        ToastHelper.showToastShort(BiliContext.application(), R.string.homepage_global_string_173);
    }

    public static final void testSpaceAsync() {
        BiliCall call = ((BiliSpaceApiService) ServiceGenerator.createService(BiliSpaceApiService.class)).loadArchiveVideos(35147507L, 1, 10, "");
        call.enqueue(new BiliApiDataCallback<BiliSpaceVideoList>() { // from class: tv.danmaku.bili.moss.test.cases.bandwidth.SpaceTestKt$testSpaceAsync$1
            public void onDataSuccess(BiliSpaceVideoList data) {
            }

            public void onError(Throwable t) {
            }
        });
        new SpaceMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null).archive(getSpaceArchivePb(), new MossResponseHandler<ArchiveReply>() { // from class: tv.danmaku.bili.moss.test.cases.bandwidth.SpaceTestKt$testSpaceAsync$2
            public /* synthetic */ void onCompleted() {
                MossResponseHandler.-CC.$default$onCompleted(this);
            }

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

            public void onNext(ArchiveReply value) {
                if (value != null) {
                    BLog.d(MossTestKt.TAG, "Space archive on next");
                }
            }

            public void onError(MossException t) {
                if (t != null) {
                    BLog.e(MossTestKt.TAG, "Space archive on error, " + t);
                }
            }
        });
    }

    public static final ArchiveReq getSpaceArchivePb() {
        ArchiveReq.Builder $this$getSpaceArchivePb_u24lambda_u240 = ArchiveReq.newBuilder();
        $this$getSpaceArchivePb_u24lambda_u240.setVmid(35147507L);
        $this$getSpaceArchivePb_u24lambda_u240.setPn(1);
        $this$getSpaceArchivePb_u24lambda_u240.setPs(10);
        ArchiveReq build = $this$getSpaceArchivePb_u24lambda_u240.build();
        Intrinsics.checkNotNullExpressionValue(build, "run(...)");
        return build;
    }
}