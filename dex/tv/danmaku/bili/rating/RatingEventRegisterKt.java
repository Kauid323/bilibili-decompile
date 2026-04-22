package tv.danmaku.bili.rating;

import android.app.Application;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.bilibili.base.BiliContext;
import com.bilibili.bus.Violet;
import com.bilibili.commons.time.DateUtils;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.blkv.RawKV;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.playerbizcommon.message.VideoLikeMessage;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;

/* compiled from: RatingEventRegister.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a4\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\"\u0010\u000b\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\f\u001a\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"RATING_DIALOG_COUNT_KEY", "", "RATING_DIALOG_GUIDE_COUNT_KEY", "RATING_DIALOG_COUNT_FILE_NAME", "RATING_DIALOG_LIKE_COUNT_KEY", "RATING_DIALOG_LAST_DISPLAY_TIME_KEY", "DD_RATING_POP_CD_CONFIG", "registerRatingEvent", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "block", "Lkotlin/Function3;", "Ltv/danmaku/bili/rating/DirectRatingGuide;", "Ltv/danmaku/bili/rating/RatingThenGuide;", "isRatingDisplayCD", "", "blkv", "Lcom/bilibili/lib/blkv/RawKV;", "defaultInterval", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RatingEventRegisterKt {
    public static final String DD_RATING_POP_CD_CONFIG = "dd.rating.popup.cd_control_time";
    public static final String RATING_DIALOG_COUNT_FILE_NAME = "rating_dialog_count_sp_file";
    public static final String RATING_DIALOG_COUNT_KEY = "rating_dialog_count";
    public static final String RATING_DIALOG_GUIDE_COUNT_KEY = "rating_dialog_guide_count";
    public static final String RATING_DIALOG_LAST_DISPLAY_TIME_KEY = "rating_dialog_last_display_time";
    public static final String RATING_DIALOG_LIKE_COUNT_KEY = "rating_dialog_like_count";

    public static final void registerRatingEvent(LifecycleOwner lifecycleOwner, Function3<? super DirectRatingGuide, ? super RatingThenGuide, ? super String, Unit> function3) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(function3, "block");
        if (DeviceDecision.INSTANCE.getBoolean("dd_rating_guidance", false) && lifecycleOwner != null) {
            Application application = BiliContext.application();
            final RawKV blkv = application != null ? BLKV.getKvs$default(application, RATING_DIALOG_COUNT_FILE_NAME, true, 0, 4, (Object) null) : null;
            int lastCount = blkv != null ? ((Number) blkv.get(RATING_DIALOG_COUNT_KEY, 1)).intValue() : 1;
            if (lastCount > 3) {
                return;
            }
            String dd = DeviceDecision.INSTANCE.dd(DD_RATING_POP_CD_CONFIG, "90");
            final int cd = (dd == null || (intOrNull = StringsKt.toIntOrNull(dd)) == null) ? 90 : intOrNull.intValue();
            boolean isRatingDisplayCD = isRatingDisplayCD(blkv, cd);
            if (isRatingDisplayCD) {
                return;
            }
            Observer observer = new Observer() { // from class: tv.danmaku.bili.rating.RatingEventRegisterKt$$ExternalSyntheticLambda0
                public final void onChanged(Object obj) {
                    RatingEventRegisterKt.registerRatingEvent$lambda$0(blkv, cd, (VideoLikeMessage) obj);
                }
            };
            Violet.INSTANCE.ofChannel(VideoLikeMessage.class).observeForever(observer);
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new RatingEventRegisterKt$registerRatingEvent$1(blkv, cd, function3, observer, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerRatingEvent$lambda$0(RawKV $blkv, int $cd, VideoLikeMessage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getLikeState() && !isRatingDisplayCD($blkv, $cd)) {
            long likeCount = $blkv != null ? ((Number) $blkv.get(RATING_DIALOG_LIKE_COUNT_KEY, 0L)).longValue() : 0L;
            if ($blkv != null) {
                $blkv.putLong(RATING_DIALOG_LIKE_COUNT_KEY, likeCount + 1);
            }
        }
    }

    public static /* synthetic */ boolean isRatingDisplayCD$default(RawKV rawKV, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 90;
        }
        return isRatingDisplayCD(rawKV, i);
    }

    public static final boolean isRatingDisplayCD(RawKV blkv, int defaultInterval) {
        long lastTime = blkv != null ? ((Number) blkv.get(RATING_DIALOG_LAST_DISPLAY_TIME_KEY, 0L)).longValue() : 0L;
        int latestShowedDaysDiff = DateUtils.daysDifference(new Date(lastTime), new Date(System.currentTimeMillis()));
        return latestShowedDaysDiff < defaultInterval;
    }
}