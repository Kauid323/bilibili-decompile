package tv.danmaku.bili.report.biz.api.track.apm.sample.api;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.consume.consumer.track.apm.config.TrackConfig;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.report.sample.Sample;
import tv.danmaku.bili.report.sample.Whitelist;
import tv.danmaku.bili.report.sample.rule.url.BizSample;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: ImageSample.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a$\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007\u001a\b\u0010\n\u001a\u00020\u000bH\u0002\"\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"imageTrackSample", "Lkotlin/Pair;", "", "", ReportEvent.Tag.HOST, "", FileChooserActivity.PATH, "sImageSampleRules", "", "Ltv/danmaku/bili/report/sample/rule/url/BizSample;", "trackDefImgSample", "", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ImageSampleKt {
    private static final List<BizSample> sImageSampleRules;

    public static final Pair<Boolean, Float> imageTrackSample(String host, String path) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        if (Whitelist.Companion.wl()) {
            return new Pair<>(true, Float.valueOf(1.0f));
        }
        BizSample bizRate = BizSample.Companion.find(host, path, sImageSampleRules);
        if (bizRate != null) {
            return Sample.Companion.sample(bizRate.getSample());
        }
        return Sample.Companion.sample(trackDefImgSample());
    }

    static {
        BizSample.Companion companion = BizSample.Companion;
        String imageSample = TrackConfig.INSTANCE.getImageSample();
        if (imageSample == null) {
            imageSample = "[]";
        }
        List<BizSample> parse = companion.parse(imageSample);
        if (parse == null) {
            parse = CollectionsKt.emptyList();
        }
        sImageSampleRules = parse;
    }

    private static final int trackDefImgSample() {
        Integer intOrNull;
        String defImageSample = TrackConfig.INSTANCE.getDefImageSample();
        if (defImageSample == null || (intOrNull = StringsKt.toIntOrNull(defImageSample)) == null) {
            return 10;
        }
        return intOrNull.intValue();
    }
}