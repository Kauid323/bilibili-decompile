package tv.danmaku.bili.rating;

import android.app.Application;
import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.app.comm.IJsBridgeContextV2;
import com.bilibili.base.BiliContext;
import com.bilibili.common.webview.js.JsbDynamicService;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.blkv.RawKV;
import com.bilibili.lib.dd.DeviceDecision;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BuildConfig;
import tv.danmaku.bili.BR;

/* compiled from: RatingJSB.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096@¢\u0006\u0002\u0010\fJ:\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/rating/RatingJSBService;", "Lcom/bilibili/common/webview/js/JsbDynamicService;", "jsbContext", "Lcom/bilibili/app/comm/IJsBridgeContextV2;", "<init>", "(Lcom/bilibili/app/comm/IJsBridgeContextV2;)V", "execute", "", "data", "Lcom/alibaba/fastjson/JSONObject;", "callbackId", "", "(Lcom/alibaba/fastjson/JSONObject;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showGuide", "context", "Landroid/content/Context;", "directRatingGuide", "Ltv/danmaku/bili/rating/DirectRatingGuide;", "ratingThenGuide", "Ltv/danmaku/bili/rating/RatingThenGuide;", "count", "specialPage", "", "(Landroid/content/Context;Ltv/danmaku/bili/rating/DirectRatingGuide;Ltv/danmaku/bili/rating/RatingThenGuide;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.BUILD_TYPE, "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RatingJSBService implements JsbDynamicService {
    public static final int $stable = 8;
    private final IJsBridgeContextV2 jsbContext;

    public RatingJSBService(IJsBridgeContextV2 jsbContext) {
        Intrinsics.checkNotNullParameter(jsbContext, "jsbContext");
        this.jsbContext = jsbContext;
    }

    public Object execute(JSONObject data, String callbackId, Continuation<? super Unit> continuation) {
        Integer intOrNull;
        Context context = this.jsbContext.getHostContext();
        if (context == null) {
            return Unit.INSTANCE;
        }
        if (DeviceDecision.INSTANCE.getBoolean("dd_rating_guidance", false)) {
            Application application = BiliContext.application();
            RawKV blkv = application != null ? BLKV.getKvs$default(application, RatingEventRegisterKt.RATING_DIALOG_COUNT_FILE_NAME, true, 0, 4, (Object) null) : null;
            int lastCount = blkv != null ? ((Number) blkv.get(RatingEventRegisterKt.RATING_DIALOG_COUNT_KEY, Boxing.boxInt(1))).intValue() : 1;
            if (lastCount > 3) {
                return Unit.INSTANCE;
            }
            String dd = DeviceDecision.INSTANCE.dd(RatingEventRegisterKt.DD_RATING_POP_CD_CONFIG, "90");
            int cd = (dd == null || (intOrNull = StringsKt.toIntOrNull(dd)) == null) ? 90 : intOrNull.intValue();
            if (RatingEventRegisterKt.isRatingDisplayCD(blkv, cd)) {
                return Unit.INSTANCE;
            }
            Ref.IntRef count = new Ref.IntRef();
            count.element = lastCount;
            long likeCount = blkv != null ? ((Number) blkv.get(RatingEventRegisterKt.RATING_DIALOG_LIKE_COUNT_KEY, Boxing.boxLong(0L))).longValue() : 0L;
            int specialPage = data != null ? data.getIntValue("special_page") : 0;
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(continuation.getContext()), (CoroutineContext) null, (CoroutineStart) null, new RatingJSBService$execute$2(lastCount, specialPage, likeCount, this, context, count, blkv, null), 3, (Object) null);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object showGuide(Context context, DirectRatingGuide directRatingGuide, RatingThenGuide ratingThenGuide, String count, int specialPage, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new RatingJSBService$showGuide$2(directRatingGuide, context, count, specialPage, ratingThenGuide, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public void release() {
    }
}