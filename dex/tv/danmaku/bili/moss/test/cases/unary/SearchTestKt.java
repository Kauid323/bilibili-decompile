package tv.danmaku.bili.moss.test.cases.unary;

import android.content.Context;
import com.bapis.bilibili.app.interfaces.v1.SearchMoss;
import com.bapis.bilibili.app.interfaces.v1.SearchTestMoss;
import com.bapis.bilibili.app.interfaces.v1.SuggestionResult3Reply;
import com.bapis.bilibili.app.interfaces.v1.SuggestionResult3Req;
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

/* compiled from: SearchTest.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\u000b\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002\u001a\u0012\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011H\u0002¨\u0006\u0012"}, d2 = {"testSuggestAsync", "", "context", "Landroid/content/Context;", "keyword", "", "testSuggestSync", "testNoExistAsync", "testNoExistSync", "testMalformedAsync", "testMalformedSync", "print", "reply", "Lcom/bapis/bilibili/app/interfaces/v1/SuggestionResult3Reply;", "getRequest", "Lcom/bapis/bilibili/app/interfaces/v1/SuggestionResult3Req;", "getHandler", "Lcom/bilibili/lib/moss/api/MossResponseHandler;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SearchTestKt {
    public static final void testSuggestAsync(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        SuggestionResult3Req request = getRequest(keyword);
        MossResponseHandler handler = getHandler();
        new SearchMoss(MossTestKt.hostByPolicy(), (int) BR.playerNickTextColor, (CallOptions) null, 4, (DefaultConstructorMarker) null).suggest3(request, handler);
    }

    public static final void testSuggestSync(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        SuggestionResult3Req request = getRequest(keyword);
        try {
            SuggestionResult3Reply reply = new SearchMoss(MossTestKt.hostByPolicy(), (int) BR.playerNickTextColor, (CallOptions) null, 4, (DefaultConstructorMarker) null).executeSuggest3(request);
            print(reply);
        } catch (MossException e) {
            BLog.e(MossTestKt.TAG, "Sync request throwable " + e);
        }
    }

    public static final void testNoExistAsync(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        SuggestionResult3Req request = getRequest(keyword);
        MossResponseHandler handler = getHandler();
        new SearchTestMoss(MossTestKt.hostByPolicy(), (int) BR.playerNickTextColor, (CallOptions) null, 4, (DefaultConstructorMarker) null).notExist(request, handler);
    }

    public static final void testNoExistSync(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        SuggestionResult3Req request = getRequest(keyword);
        try {
            SuggestionResult3Reply reply = new SearchTestMoss(MossTestKt.hostByPolicy(), (int) BR.playerNickTextColor, (CallOptions) null, 4, (DefaultConstructorMarker) null).executeNotExist(request);
            print(reply);
        } catch (MossException e) {
            BLog.e(MossTestKt.TAG, "Sync request throwable " + e);
        }
    }

    public static final void testMalformedAsync(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        SuggestionResult3Req request = getRequest(keyword);
        MossResponseHandler handler = getHandler();
        new SearchMoss("www.baidu.com", (int) BR.playerNickTextColor, (CallOptions) null, 4, (DefaultConstructorMarker) null).suggest3(request, handler);
    }

    public static final void testMalformedSync(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        SuggestionResult3Req request = getRequest(keyword);
        try {
            SuggestionResult3Reply reply = new SearchMoss("www.baidu.com", (int) BR.playerNickTextColor, (CallOptions) null, 4, (DefaultConstructorMarker) null).executeSuggest3(request);
            print(reply);
        } catch (MossException e) {
            BLog.e(MossTestKt.TAG, "Sync request throwable " + e);
        }
    }

    private static final void print(SuggestionResult3Reply reply) {
        if (reply != null) {
            BLog.vfmt(MossTestKt.TAG, "Sync request trackid=%s, result item list size=%d.", reply.getTrackid(), Integer.valueOf(reply.getListCount()));
        } else {
            BLog.vfmt(MossTestKt.TAG, "Sync request get null.", new Object[0]);
        }
    }

    static /* synthetic */ SuggestionResult3Req getRequest$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "test";
        }
        return getRequest(str);
    }

    private static final SuggestionResult3Req getRequest(String keyword) {
        SuggestionResult3Req.Builder $this$getRequest_u24lambda_u240 = SuggestionResult3Req.newBuilder();
        $this$getRequest_u24lambda_u240.setKeyword(keyword);
        $this$getRequest_u24lambda_u240.setHighlight(1);
        $this$getRequest_u24lambda_u240.setTeenagersMode(0);
        SuggestionResult3Req build = $this$getRequest_u24lambda_u240.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    private static final MossResponseHandler<SuggestionResult3Reply> getHandler() {
        return new MossResponseHandler<SuggestionResult3Reply>() { // from class: tv.danmaku.bili.moss.test.cases.unary.SearchTestKt$getHandler$1
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

            public void onNext(SuggestionResult3Reply value) {
                if (value == null) {
                    BLog.vfmt(MossTestKt.TAG, "Async onNext returns null.", new Object[0]);
                } else {
                    BLog.vfmt(MossTestKt.TAG, "Async onNext trackid=%s, result item list size=%d.", value.getTrackid(), Integer.valueOf(value.getListCount()));
                }
            }

            public void onError(MossException t) {
                BLog.e(MossTestKt.TAG, "Async onError " + t);
            }

            public void onCompleted() {
                BLog.v(MossTestKt.TAG, "Async onCompleted");
            }
        };
    }
}