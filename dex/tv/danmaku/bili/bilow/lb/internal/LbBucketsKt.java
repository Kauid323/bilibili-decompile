package tv.danmaku.bili.bilow.lb.internal;

import com.bilibili.lib.biliid.api.BuvidHelper;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import tv.danmaku.bili.BR;

/* compiled from: LbBuckets.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u001a%\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\nH\u0002¢\u0006\u0002\u0010\u000e\u001a\b\u0010\u000f\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0004\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"MAX_BUCKET", "", "BUCKET_SALT", "", "bucket", "getBucket", "()I", "bucket$delegate", "Lkotlin/Lazy;", "getDeviceRule", "", "rules", "Ltv/danmaku/bili/bilow/lb/internal/LbRule;", "findMatchIndex", "(ILjava/util/List;)Ljava/lang/Integer;", "deviceBucket", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LbBucketsKt {
    private static final String BUCKET_SALT = "image_cdn_balance";
    private static final int MAX_BUCKET = 10000;
    private static final Lazy bucket$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.bilow.lb.internal.LbBucketsKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            int bucket_delegate$lambda$0;
            bucket_delegate$lambda$0 = LbBucketsKt.bucket_delegate$lambda$0();
            return Integer.valueOf(bucket_delegate$lambda$0);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final int bucket_delegate$lambda$0() {
        return deviceBucket();
    }

    private static final int getBucket() {
        return ((Number) bucket$delegate.getValue()).intValue();
    }

    public static final List<String> getDeviceRule(List<LbRule> list) {
        boolean z;
        Integer index;
        try {
            List<LbRule> list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                z = false;
                if (!z || (index = findMatchIndex(getBucket(), list)) == null) {
                    return null;
                }
                return list.get(index.intValue()).getRule();
            }
            z = true;
            if (!z) {
                return null;
            }
            return list.get(index.intValue()).getRule();
        } catch (Exception e) {
            return null;
        }
    }

    private static final Integer findMatchIndex(int bucket, List<LbRule> list) {
        int sum = 0;
        List<LbRule> $this$forEachIndexed$iv = list;
        int index = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            LbRule rule = (LbRule) item$iv;
            sum += rule.getWeight();
            if (bucket <= sum) {
                return Integer.valueOf(index);
            }
            index = index$iv;
        }
        return null;
    }

    private static final int deviceBucket() {
        try {
            String buvid = BuvidHelper.getBuvid();
            String hex = ByteString.Companion.encodeUtf8(buvid + BUCKET_SALT).md5().hex();
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String upperCase = hex.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            int raw = upperCase.hashCode() % 10000;
            return (raw + 10000) % 10000;
        } catch (Exception e) {
            return 0;
        }
    }
}