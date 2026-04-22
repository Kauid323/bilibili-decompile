package tv.danmaku.bili.ui.splash.ad.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BezierAnimationElement.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R \u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR \u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001e\u0010\"\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001e\u0010%\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u001e\u0010(\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR \u0010+\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R&\u00101\u001a\n\u0012\u0004\u0012\u000203\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R \u00108\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR \u0010;\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000fR \u0010>\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000fR\u001e\u0010A\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0007\"\u0004\bC\u0010\tR\u001e\u0010D\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0007\"\u0004\bF\u0010\tR\u001e\u0010G\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0007\"\u0004\bI\u0010\tR\u001e\u0010J\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0007\"\u0004\bL\u0010\t¨\u0006M"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/model/BezierAnimationElement;", "", "<init>", "()V", "type", "", "getType", "()I", "setType", "(I)V", "guideImageUrl", "", "getGuideImageUrl", "()Ljava/lang/String;", "setGuideImageUrl", "(Ljava/lang/String;)V", "guideImageMd5", "getGuideImageMd5", "setGuideImageMd5", "guideShowTime", "", "getGuideShowTime", "()J", "setGuideShowTime", "(J)V", "guideShowDuration", "getGuideShowDuration", "setGuideShowDuration", "imageUrl", "getImageUrl", "setImageUrl", "imageMd5", "getImageMd5", "setImageMd5", "duration", "getDuration", "setDuration", "width", "getWidth", "setWidth", "height", "getHeight", "setHeight", "position", "Ltv/danmaku/bili/ui/splash/ad/model/BezierPoint;", "getPosition", "()Ltv/danmaku/bili/ui/splash/ad/model/BezierPoint;", "setPosition", "(Ltv/danmaku/bili/ui/splash/ad/model/BezierPoint;)V", "list", "", "Ltv/danmaku/bili/ui/splash/ad/model/BezierAnimationItem;", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "topImageUrl", "getTopImageUrl", "setTopImageUrl", "topImageMd5", "getTopImageMd5", "setTopImageMd5", "lineColor", "getLineColor", "setLineColor", "topImageWidth", "getTopImageWidth", "setTopImageWidth", "topImageHeight", "getTopImageHeight", "setTopImageHeight", "imageWidth", "getImageWidth", "setImageWidth", "imageHeight", "getImageHeight", "setImageHeight", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BezierAnimationElement {
    public static final int $stable = 8;
    @JSONField(name = "duration")
    private long duration;
    @JSONField(name = "guide_image_md5")
    private String guideImageMd5;
    @JSONField(name = "guide_image_url")
    private String guideImageUrl;
    @JSONField(name = "guide_show_duration")
    private long guideShowDuration;
    @JSONField(name = "guide_show_time")
    private long guideShowTime;
    @JSONField(name = "height")
    private int height;
    @JSONField(name = "image_height")
    private int imageHeight;
    @JSONField(name = "image_md5")
    private String imageMd5;
    @JSONField(name = "image_url")
    private String imageUrl;
    @JSONField(name = "image_width")
    private int imageWidth;
    @JSONField(name = "line_color")
    private String lineColor;
    @JSONField(name = "list")
    private List<BezierAnimationItem> list;
    @JSONField(name = "position")
    private BezierPoint position;
    @JSONField(name = "top_image_height")
    private int topImageHeight;
    @JSONField(name = "top_image_md5")
    private String topImageMd5;
    @JSONField(name = "top_image_url")
    private String topImageUrl;
    @JSONField(name = "top_image_width")
    private int topImageWidth;
    @JSONField(name = "type")
    private int type;
    @JSONField(name = "width")
    private int width = 30;

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final String getGuideImageUrl() {
        return this.guideImageUrl;
    }

    public final void setGuideImageUrl(String str) {
        this.guideImageUrl = str;
    }

    public final String getGuideImageMd5() {
        return this.guideImageMd5;
    }

    public final void setGuideImageMd5(String str) {
        this.guideImageMd5 = str;
    }

    public final long getGuideShowTime() {
        return this.guideShowTime;
    }

    public final void setGuideShowTime(long j) {
        this.guideShowTime = j;
    }

    public final long getGuideShowDuration() {
        return this.guideShowDuration;
    }

    public final void setGuideShowDuration(long j) {
        this.guideShowDuration = j;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public final String getImageMd5() {
        return this.imageMd5;
    }

    public final void setImageMd5(String str) {
        this.imageMd5 = str;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final void setDuration(long j) {
        this.duration = j;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final BezierPoint getPosition() {
        return this.position;
    }

    public final void setPosition(BezierPoint bezierPoint) {
        this.position = bezierPoint;
    }

    public final List<BezierAnimationItem> getList() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.list);
    }

    public final void setList(List<BezierAnimationItem> list) {
        this.list = list;
    }

    public final String getTopImageUrl() {
        return this.topImageUrl;
    }

    public final void setTopImageUrl(String str) {
        this.topImageUrl = str;
    }

    public final String getTopImageMd5() {
        return this.topImageMd5;
    }

    public final void setTopImageMd5(String str) {
        this.topImageMd5 = str;
    }

    public final String getLineColor() {
        return this.lineColor;
    }

    public final void setLineColor(String str) {
        this.lineColor = str;
    }

    public final int getTopImageWidth() {
        return this.topImageWidth;
    }

    public final void setTopImageWidth(int i) {
        this.topImageWidth = i;
    }

    public final int getTopImageHeight() {
        return this.topImageHeight;
    }

    public final void setTopImageHeight(int i) {
        this.topImageHeight = i;
    }

    public final int getImageWidth() {
        return this.imageWidth;
    }

    public final void setImageWidth(int i) {
        this.imageWidth = i;
    }

    public final int getImageHeight() {
        return this.imageHeight;
    }

    public final void setImageHeight(int i) {
        this.imageHeight = i;
    }
}