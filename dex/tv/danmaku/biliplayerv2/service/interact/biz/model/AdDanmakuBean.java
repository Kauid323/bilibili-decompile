package tv.danmaku.biliplayerv2.service.interact.biz.model;

import android.graphics.Bitmap;
import androidx.core.util.ObjectsCompat;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AdDanmakuBean.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\b\u0017\u0018\u0000 \u001d2\u00020\u0001:\b\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/AdDanmakuBean;", "", "<init>", "()V", "cardType", "", "getCardType", "()I", "setCardType", "(I)V", "identity", "", "getIdentity", "()Ljava/lang/Long;", "setIdentity", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "isDm", "", "isFloatView", "isFloatViewPermanent", "isFloatViewActivities", "AdDm", "AdFloatView", "AdFloatViewPermanent", "AdFloatViewAnswer", "AdFloatViewGot", "AdFloatViewCommerce", "AdFloatViewCommon", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public class AdDanmakuBean {
    private int cardType;
    private Long identity = 0L;
    public static final Companion Companion = new Companion(null);
    public static final int AD_DANMAKU = 55001;

    public final int getCardType() {
        return this.cardType;
    }

    public final void setCardType(int i) {
        this.cardType = i;
    }

    public final Long getIdentity() {
        return this.identity;
    }

    public final void setIdentity(Long l) {
        this.identity = l;
    }

    /* compiled from: AdDanmakuBean.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0096\u0002J\b\u00107\u001a\u000208H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001c\u0010%\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\u0011\u00101\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b2\u0010\u001f¨\u00069"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/AdDanmakuBean$AdDm;", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/AdDanmakuBean;", "<init>", "()V", RankRouter.BundleKey.VIDEO_DETAIL_COVER, "", "getCover", "()Ljava/lang/String;", "setCover", "(Ljava/lang/String;)V", "adTag", "getAdTag", "setAdTag", "danmuTitle", "getDanmuTitle", "setDanmuTitle", "desc", "getDesc", "setDesc", "danmuBegin", "", "getDanmuBegin", "()J", "setDanmuBegin", "(J)V", "danmuLife", "getDanmuLife", "setDanmuLife", "danmuHeight", "", "getDanmuHeight", "()F", "setDanmuHeight", "(F)V", "danmuColor", "getDanmuColor", "setDanmuColor", "adverLogo", "getAdverLogo", "setAdverLogo", "bitmapAdverLogo", "Landroid/graphics/Bitmap;", "getBitmapAdverLogo", "()Landroid/graphics/Bitmap;", "setBitmapAdverLogo", "(Landroid/graphics/Bitmap;)V", "bitmapCover", "getBitmapCover", "setBitmapCover", "realDanmuHeight", "getRealDanmuHeight", "equals", "", "other", "", "hashCode", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AdDm extends AdDanmakuBean {
        private String adTag;
        private String adverLogo;
        private Bitmap bitmapAdverLogo;
        private Bitmap bitmapCover;
        private String cover;
        private long danmuBegin;
        private String danmuColor;
        private float danmuHeight;
        private long danmuLife;
        private String danmuTitle;
        private String desc;

        public final String getCover() {
            return this.cover;
        }

        public final void setCover(String str) {
            this.cover = str;
        }

        public final String getAdTag() {
            return this.adTag;
        }

        public final void setAdTag(String str) {
            this.adTag = str;
        }

        public final String getDanmuTitle() {
            return this.danmuTitle;
        }

        public final void setDanmuTitle(String str) {
            this.danmuTitle = str;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final void setDesc(String str) {
            this.desc = str;
        }

        public final long getDanmuBegin() {
            return this.danmuBegin;
        }

        public final void setDanmuBegin(long j) {
            this.danmuBegin = j;
        }

        public final long getDanmuLife() {
            return this.danmuLife;
        }

        public final void setDanmuLife(long j) {
            this.danmuLife = j;
        }

        public final float getDanmuHeight() {
            return this.danmuHeight;
        }

        public final void setDanmuHeight(float f) {
            this.danmuHeight = f;
        }

        public final String getDanmuColor() {
            return this.danmuColor;
        }

        public final void setDanmuColor(String str) {
            this.danmuColor = str;
        }

        public final String getAdverLogo() {
            return this.adverLogo;
        }

        public final void setAdverLogo(String str) {
            this.adverLogo = str;
        }

        public final Bitmap getBitmapAdverLogo() {
            return this.bitmapAdverLogo;
        }

        public final void setBitmapAdverLogo(Bitmap bitmap) {
            this.bitmapAdverLogo = bitmap;
        }

        public final Bitmap getBitmapCover() {
            return this.bitmapCover;
        }

        public final void setBitmapCover(Bitmap bitmap) {
            this.bitmapCover = bitmap;
        }

        public final float getRealDanmuHeight() {
            return this.danmuHeight / 100;
        }

        public boolean equals(Object other) {
            if (other instanceof AdDm) {
                if (this != other) {
                    if (this.danmuBegin != ((AdDm) other).danmuBegin) {
                        return false;
                    }
                    if (!(this.danmuHeight == ((AdDm) other).danmuHeight) || !Intrinsics.areEqual(getIdentity(), ((AdDm) other).getIdentity())) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{Long.valueOf(this.danmuBegin), Float.valueOf(this.danmuHeight), getIdentity()});
        }
    }

    /* compiled from: AdDanmakuBean.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0096\u0002J\b\u0010$\u001a\u00020%H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001b¨\u0006&"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/AdDanmakuBean$AdFloatView;", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/AdDanmakuBean;", "<init>", "()V", "image_url", "", "getImage_url", "()Ljava/lang/String;", "setImage_url", "(Ljava/lang/String;)V", "bg_color", "getBg_color", "setBg_color", "ad_notes", "getAd_notes", "setAd_notes", RankRouter.BundleKey.ACTION_PARAM_TITLE, "getTitle", "setTitle", "button_text", "getButton_text", "setButton_text", "appearance_time", "", "getAppearance_time", "()Ljava/lang/Long;", "setAppearance_time", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "duration", "getDuration", "setDuration", "equals", "", "other", "", "hashCode", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AdFloatView extends AdDanmakuBean {
        private String ad_notes;
        private Long appearance_time;
        private String bg_color;
        private String button_text;
        private Long duration;
        private String image_url;
        private String title;

        public final String getImage_url() {
            return this.image_url;
        }

        public final void setImage_url(String str) {
            this.image_url = str;
        }

        public final String getBg_color() {
            return this.bg_color;
        }

        public final void setBg_color(String str) {
            this.bg_color = str;
        }

        public final String getAd_notes() {
            return this.ad_notes;
        }

        public final void setAd_notes(String str) {
            this.ad_notes = str;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final String getButton_text() {
            return this.button_text;
        }

        public final void setButton_text(String str) {
            this.button_text = str;
        }

        public final Long getAppearance_time() {
            return this.appearance_time;
        }

        public final void setAppearance_time(Long l) {
            this.appearance_time = l;
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final void setDuration(Long l) {
            this.duration = l;
        }

        public boolean equals(Object other) {
            if (other instanceof AdFloatView) {
                return this == other || (Intrinsics.areEqual(this.appearance_time, ((AdFloatView) other).appearance_time) && Intrinsics.areEqual(getIdentity(), ((AdFloatView) other).getIdentity()));
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.appearance_time, getIdentity()});
        }
    }

    /* compiled from: AdDanmakuBean.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0096\u0002J\b\u0010'\u001a\u00020(H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001e\u0010 \u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015¨\u0006)"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/AdDanmakuBean$AdFloatViewPermanent;", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/AdDanmakuBean;", "<init>", "()V", "image_url", "", "getImage_url", "()Ljava/lang/String;", "setImage_url", "(Ljava/lang/String;)V", "bg_color", "getBg_color", "setBg_color", RankRouter.BundleKey.ACTION_PARAM_TITLE, "getTitle", "setTitle", "appearance_time", "", "getAppearance_time", "()Ljava/lang/Long;", "setAppearance_time", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "duration", "getDuration", "setDuration", "fold_time", "getFold_time", "setFold_time", "width", "getWidth", "setWidth", "height", "getHeight", "setHeight", "equals", "", "other", "", "hashCode", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AdFloatViewPermanent extends AdDanmakuBean {
        private Long appearance_time;
        private String bg_color;
        private Long duration;
        private Long fold_time;
        private Long height;
        private String image_url;
        private String title;
        private Long width;

        public final String getImage_url() {
            return this.image_url;
        }

        public final void setImage_url(String str) {
            this.image_url = str;
        }

        public final String getBg_color() {
            return this.bg_color;
        }

        public final void setBg_color(String str) {
            this.bg_color = str;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final Long getAppearance_time() {
            return this.appearance_time;
        }

        public final void setAppearance_time(Long l) {
            this.appearance_time = l;
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final void setDuration(Long l) {
            this.duration = l;
        }

        public final Long getFold_time() {
            return this.fold_time;
        }

        public final void setFold_time(Long l) {
            this.fold_time = l;
        }

        public final Long getWidth() {
            return this.width;
        }

        public final void setWidth(Long l) {
            this.width = l;
        }

        public final Long getHeight() {
            return this.height;
        }

        public final void setHeight(Long l) {
            this.height = l;
        }

        public boolean equals(Object other) {
            if (other instanceof AdFloatViewPermanent) {
                return this == other || (Intrinsics.areEqual(this.appearance_time, ((AdFloatViewPermanent) other).appearance_time) && Intrinsics.areEqual(this.height, ((AdFloatViewPermanent) other).height) && Intrinsics.areEqual(getIdentity(), ((AdFloatViewPermanent) other).getIdentity()));
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.appearance_time, this.height, getIdentity()});
        }
    }

    /* compiled from: AdDanmakuBean.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010EH\u0096\u0002J\b\u0010F\u001a\u00020!H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001e\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010'\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\tR\u001c\u0010*\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\tR\u001c\u0010-\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\tR\u001c\u00100\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010\tR\u001c\u00103\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0007\"\u0004\b5\u0010\tR\u001c\u00106\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0007\"\u0004\b8\u0010\tR\u001c\u00109\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0007\"\u0004\b;\u0010\tR\u001c\u0010<\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0007\"\u0004\b>\u0010\tR\u001c\u0010?\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0007\"\u0004\bA\u0010\t¨\u0006G"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/AdDanmakuBean$AdFloatViewAnswer;", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/AdDanmakuBean;", "<init>", "()V", "ball_id", "", "getBall_id", "()Ljava/lang/String;", "setBall_id", "(Ljava/lang/String;)V", "question_image_url", "getQuestion_image_url", "setQuestion_image_url", ChronosDanmakuSender.KEY_VOTE_QUESTION, "getQuestion", "setQuestion", "selections", "", "getSelections", "()Ljava/util/List;", "setSelections", "(Ljava/util/List;)V", "appearance_time", "", "getAppearance_time", "()Ljava/lang/Long;", "setAppearance_time", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "duration", "getDuration", "setDuration", "state", "", "getState", "()Ljava/lang/Integer;", "setState", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "failed_notes", "getFailed_notes", "setFailed_notes", "succeed_notes", "getSucceed_notes", "setSucceed_notes", "succeed_btn_text", "getSucceed_btn_text", "setSucceed_btn_text", "succeed_image_url", "getSucceed_image_url", "setSucceed_image_url", "got_notes", "getGot_notes", "setGot_notes", "got_btn_text", "getGot_btn_text", "setGot_btn_text", "got_image_url", "getGot_image_url", "setGot_image_url", "ad_tag_image_url", "getAd_tag_image_url", "setAd_tag_image_url", "ad_tag_text", "getAd_tag_text", "setAd_tag_text", "equals", "", "other", "", "hashCode", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AdFloatViewAnswer extends AdDanmakuBean {
        private String ad_tag_image_url;
        private String ad_tag_text;
        private Long appearance_time;
        private String ball_id;
        private Long duration;
        private String failed_notes;
        private String got_btn_text;
        private String got_image_url;
        private String got_notes;
        private String question;
        private String question_image_url;
        private List<String> selections;
        private Integer state;
        private String succeed_btn_text;
        private String succeed_image_url;
        private String succeed_notes;

        public final String getBall_id() {
            return this.ball_id;
        }

        public final void setBall_id(String str) {
            this.ball_id = str;
        }

        public final String getQuestion_image_url() {
            return this.question_image_url;
        }

        public final void setQuestion_image_url(String str) {
            this.question_image_url = str;
        }

        public final String getQuestion() {
            return this.question;
        }

        public final void setQuestion(String str) {
            this.question = str;
        }

        public final List<String> getSelections() {
            return EnhancedUnmodifiabilityKt.unmodifiable(this.selections);
        }

        public final void setSelections(List<String> list) {
            this.selections = list;
        }

        public final Long getAppearance_time() {
            return this.appearance_time;
        }

        public final void setAppearance_time(Long l) {
            this.appearance_time = l;
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final void setDuration(Long l) {
            this.duration = l;
        }

        public final Integer getState() {
            return this.state;
        }

        public final void setState(Integer num) {
            this.state = num;
        }

        public final String getFailed_notes() {
            return this.failed_notes;
        }

        public final void setFailed_notes(String str) {
            this.failed_notes = str;
        }

        public final String getSucceed_notes() {
            return this.succeed_notes;
        }

        public final void setSucceed_notes(String str) {
            this.succeed_notes = str;
        }

        public final String getSucceed_btn_text() {
            return this.succeed_btn_text;
        }

        public final void setSucceed_btn_text(String str) {
            this.succeed_btn_text = str;
        }

        public final String getSucceed_image_url() {
            return this.succeed_image_url;
        }

        public final void setSucceed_image_url(String str) {
            this.succeed_image_url = str;
        }

        public final String getGot_notes() {
            return this.got_notes;
        }

        public final void setGot_notes(String str) {
            this.got_notes = str;
        }

        public final String getGot_btn_text() {
            return this.got_btn_text;
        }

        public final void setGot_btn_text(String str) {
            this.got_btn_text = str;
        }

        public final String getGot_image_url() {
            return this.got_image_url;
        }

        public final void setGot_image_url(String str) {
            this.got_image_url = str;
        }

        public final String getAd_tag_image_url() {
            return this.ad_tag_image_url;
        }

        public final void setAd_tag_image_url(String str) {
            this.ad_tag_image_url = str;
        }

        public final String getAd_tag_text() {
            return this.ad_tag_text;
        }

        public final void setAd_tag_text(String str) {
            this.ad_tag_text = str;
        }

        public boolean equals(Object other) {
            if (other instanceof AdFloatViewAnswer) {
                return this == other || (Intrinsics.areEqual(this.appearance_time, ((AdFloatViewAnswer) other).appearance_time) && Intrinsics.areEqual(getIdentity(), ((AdFloatViewAnswer) other).getIdentity()));
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.appearance_time, getIdentity()});
        }
    }

    /* compiled from: AdDanmakuBean.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0096\u0002J\b\u0010@\u001a\u00020\u001eH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010$\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR\u001c\u0010'\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\tR\u001c\u0010*\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\tR\u001c\u0010-\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\tR\u001c\u00100\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010\tR\u001c\u00103\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0007\"\u0004\b5\u0010\tR\u001c\u00106\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0007\"\u0004\b8\u0010\tR\u001c\u00109\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0007\"\u0004\b;\u0010\t¨\u0006A"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/AdDanmakuBean$AdFloatViewGot;", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/AdDanmakuBean;", "<init>", "()V", "ball_id", "", "getBall_id", "()Ljava/lang/String;", "setBall_id", "(Ljava/lang/String;)V", "image_url", "getImage_url", "setImage_url", "notes", "getNotes", "setNotes", "btn_text", "getBtn_text", "setBtn_text", "appearance_time", "", "getAppearance_time", "()Ljava/lang/Long;", "setAppearance_time", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "duration", "getDuration", "setDuration", "state", "", "getState", "()Ljava/lang/Integer;", "setState", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "succeed_notes", "getSucceed_notes", "setSucceed_notes", "succeed_btn_text", "getSucceed_btn_text", "setSucceed_btn_text", "succeed_image_url", "getSucceed_image_url", "setSucceed_image_url", "got_notes", "getGot_notes", "setGot_notes", "got_btn_text", "getGot_btn_text", "setGot_btn_text", "got_image_url", "getGot_image_url", "setGot_image_url", "ad_tag_image_url", "getAd_tag_image_url", "setAd_tag_image_url", "ad_tag_text", "getAd_tag_text", "setAd_tag_text", "equals", "", "other", "", "hashCode", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AdFloatViewGot extends AdDanmakuBean {
        private String ad_tag_image_url;
        private String ad_tag_text;
        private Long appearance_time;
        private String ball_id;
        private String btn_text;
        private Long duration;
        private String got_btn_text;
        private String got_image_url;
        private String got_notes;
        private String image_url;
        private String notes;
        private Integer state;
        private String succeed_btn_text;
        private String succeed_image_url;
        private String succeed_notes;

        public final String getBall_id() {
            return this.ball_id;
        }

        public final void setBall_id(String str) {
            this.ball_id = str;
        }

        public final String getImage_url() {
            return this.image_url;
        }

        public final void setImage_url(String str) {
            this.image_url = str;
        }

        public final String getNotes() {
            return this.notes;
        }

        public final void setNotes(String str) {
            this.notes = str;
        }

        public final String getBtn_text() {
            return this.btn_text;
        }

        public final void setBtn_text(String str) {
            this.btn_text = str;
        }

        public final Long getAppearance_time() {
            return this.appearance_time;
        }

        public final void setAppearance_time(Long l) {
            this.appearance_time = l;
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final void setDuration(Long l) {
            this.duration = l;
        }

        public final Integer getState() {
            return this.state;
        }

        public final void setState(Integer num) {
            this.state = num;
        }

        public final String getSucceed_notes() {
            return this.succeed_notes;
        }

        public final void setSucceed_notes(String str) {
            this.succeed_notes = str;
        }

        public final String getSucceed_btn_text() {
            return this.succeed_btn_text;
        }

        public final void setSucceed_btn_text(String str) {
            this.succeed_btn_text = str;
        }

        public final String getSucceed_image_url() {
            return this.succeed_image_url;
        }

        public final void setSucceed_image_url(String str) {
            this.succeed_image_url = str;
        }

        public final String getGot_notes() {
            return this.got_notes;
        }

        public final void setGot_notes(String str) {
            this.got_notes = str;
        }

        public final String getGot_btn_text() {
            return this.got_btn_text;
        }

        public final void setGot_btn_text(String str) {
            this.got_btn_text = str;
        }

        public final String getGot_image_url() {
            return this.got_image_url;
        }

        public final void setGot_image_url(String str) {
            this.got_image_url = str;
        }

        public final String getAd_tag_image_url() {
            return this.ad_tag_image_url;
        }

        public final void setAd_tag_image_url(String str) {
            this.ad_tag_image_url = str;
        }

        public final String getAd_tag_text() {
            return this.ad_tag_text;
        }

        public final void setAd_tag_text(String str) {
            this.ad_tag_text = str;
        }

        public boolean equals(Object other) {
            if (other instanceof AdFloatViewGot) {
                return this == other || (Intrinsics.areEqual(this.appearance_time, ((AdFloatViewGot) other).appearance_time) && Intrinsics.areEqual(getIdentity(), ((AdFloatViewGot) other).getIdentity()));
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.appearance_time, getIdentity()});
        }
    }

    /* compiled from: AdDanmakuBean.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0096\u0002J\b\u0010:\u001a\u00020\u000bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010!\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001c\u0010$\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR\u001c\u0010'\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\tR\u001c\u0010*\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\tR\u001c\u0010-\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\tR\u001c\u00100\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010\tR\u001c\u00103\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0007\"\u0004\b5\u0010\t¨\u0006;"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/AdDanmakuBean$AdFloatViewCommerce;", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/AdDanmakuBean;", "<init>", "()V", "image_url", "", "getImage_url", "()Ljava/lang/String;", "setImage_url", "(Ljava/lang/String;)V", "image_width", "", "getImage_width", "()Ljava/lang/Integer;", "setImage_width", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "image_height", "getImage_height", "setImage_height", "ad_notes", "getAd_notes", "setAd_notes", RankRouter.BundleKey.ACTION_PARAM_TITLE, "getTitle", "setTitle", "appearance_time", "", "getAppearance_time", "()Ljava/lang/Long;", "setAppearance_time", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "duration", "getDuration", "setDuration", "button_text", "getButton_text", "setButton_text", "price_desc", "getPrice_desc", "setPrice_desc", "price_symbol", "getPrice_symbol", "setPrice_symbol", "cur_price", "getCur_price", "setCur_price", "ori_price", "getOri_price", "setOri_price", "desc", "getDesc", "setDesc", "equals", "", "other", "", "hashCode", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AdFloatViewCommerce extends AdDanmakuBean {
        private String ad_notes;
        private Long appearance_time;
        private String button_text;
        private String cur_price;
        private String desc;
        private Long duration;
        private Integer image_height;
        private String image_url;
        private Integer image_width;
        private String ori_price;
        private String price_desc;
        private String price_symbol;
        private String title;

        public final String getImage_url() {
            return this.image_url;
        }

        public final void setImage_url(String str) {
            this.image_url = str;
        }

        public final Integer getImage_width() {
            return this.image_width;
        }

        public final void setImage_width(Integer num) {
            this.image_width = num;
        }

        public final Integer getImage_height() {
            return this.image_height;
        }

        public final void setImage_height(Integer num) {
            this.image_height = num;
        }

        public final String getAd_notes() {
            return this.ad_notes;
        }

        public final void setAd_notes(String str) {
            this.ad_notes = str;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final Long getAppearance_time() {
            return this.appearance_time;
        }

        public final void setAppearance_time(Long l) {
            this.appearance_time = l;
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final void setDuration(Long l) {
            this.duration = l;
        }

        public final String getButton_text() {
            return this.button_text;
        }

        public final void setButton_text(String str) {
            this.button_text = str;
        }

        public final String getPrice_desc() {
            return this.price_desc;
        }

        public final void setPrice_desc(String str) {
            this.price_desc = str;
        }

        public final String getPrice_symbol() {
            return this.price_symbol;
        }

        public final void setPrice_symbol(String str) {
            this.price_symbol = str;
        }

        public final String getCur_price() {
            return this.cur_price;
        }

        public final void setCur_price(String str) {
            this.cur_price = str;
        }

        public final String getOri_price() {
            return this.ori_price;
        }

        public final void setOri_price(String str) {
            this.ori_price = str;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final void setDesc(String str) {
            this.desc = str;
        }

        public boolean equals(Object other) {
            if (other instanceof AdFloatViewCommerce) {
                return this == other || (Intrinsics.areEqual(this.appearance_time, ((AdFloatViewCommerce) other).appearance_time) && Intrinsics.areEqual(getIdentity(), ((AdFloatViewCommerce) other).getIdentity()));
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.appearance_time, getIdentity()});
        }
    }

    /* compiled from: AdDanmakuBean.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0096\u0002J\b\u0010.\u001a\u00020\u000bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR\u001e\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010'\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%¨\u0006/"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/AdDanmakuBean$AdFloatViewCommon;", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/AdDanmakuBean;", "<init>", "()V", "image_url", "", "getImage_url", "()Ljava/lang/String;", "setImage_url", "(Ljava/lang/String;)V", "image_width", "", "getImage_width", "()Ljava/lang/Integer;", "setImage_width", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "image_height", "getImage_height", "setImage_height", "ad_notes", "getAd_notes", "setAd_notes", RankRouter.BundleKey.ACTION_PARAM_TITLE, "getTitle", "setTitle", "desc", "getDesc", "setDesc", "button_text", "getButton_text", "setButton_text", "appearance_time", "", "getAppearance_time", "()Ljava/lang/Long;", "setAppearance_time", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "duration", "getDuration", "setDuration", "equals", "", "other", "", "hashCode", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AdFloatViewCommon extends AdDanmakuBean {
        private String ad_notes;
        private Long appearance_time;
        private String button_text;
        private String desc;
        private Long duration;
        private Integer image_height;
        private String image_url;
        private Integer image_width;
        private String title;

        public final String getImage_url() {
            return this.image_url;
        }

        public final void setImage_url(String str) {
            this.image_url = str;
        }

        public final Integer getImage_width() {
            return this.image_width;
        }

        public final void setImage_width(Integer num) {
            this.image_width = num;
        }

        public final Integer getImage_height() {
            return this.image_height;
        }

        public final void setImage_height(Integer num) {
            this.image_height = num;
        }

        public final String getAd_notes() {
            return this.ad_notes;
        }

        public final void setAd_notes(String str) {
            this.ad_notes = str;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final void setDesc(String str) {
            this.desc = str;
        }

        public final String getButton_text() {
            return this.button_text;
        }

        public final void setButton_text(String str) {
            this.button_text = str;
        }

        public final Long getAppearance_time() {
            return this.appearance_time;
        }

        public final void setAppearance_time(Long l) {
            this.appearance_time = l;
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final void setDuration(Long l) {
            this.duration = l;
        }

        public boolean equals(Object other) {
            if (other instanceof AdFloatViewCommon) {
                return this == other || (Intrinsics.areEqual(this.appearance_time, ((AdFloatViewCommon) other).appearance_time) && Intrinsics.areEqual(getIdentity(), ((AdFloatViewCommon) other).getIdentity()));
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.appearance_time, getIdentity()});
        }
    }

    /* compiled from: AdDanmakuBean.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/AdDanmakuBean$Companion;", "", "<init>", "()V", "AD_DANMAKU", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final boolean isDm() {
        return this.cardType == 21 || this.cardType == 22 || this.cardType == 23 || this.cardType == 24 || this.cardType == 29 || this.cardType == 30;
    }

    public final boolean isFloatView() {
        return this.cardType == 31 || this.cardType == 32;
    }

    public final boolean isFloatViewPermanent() {
        return this.cardType == 38;
    }

    public final boolean isFloatViewActivities() {
        return this.cardType == 76 || this.cardType == 77;
    }
}