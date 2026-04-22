package home.sidecenter.recent;

import com.bapis.bilibili.app.home.v1.KBadge;
import com.bapis.bilibili.app.home.v1.KRecentRecommendMetaInfo;
import kotlin.Metadata;

/* compiled from: Content.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010$\u001a\u00020\u0000H&R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000e8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\t8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\fR\u001a\u0010\u0015\u001a\u00020\t8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\fR\u001a\u0010\u0018\u001a\u00020\t8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\fR\u0014\u0010\u001b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\fR\u001a\u0010\u001d\u001a\u00020\u001e8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010!R\u0012\u0010\"\u001a\u00020\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!¨\u0006%À\u0006\u0003"}, d2 = {"Lhome/sidecenter/recent/RecentContent;", "", "recMeta", "Lcom/bapis/bilibili/app/home/v1/KRecentRecommendMetaInfo;", "getRecMeta$annotations", "()V", "getRecMeta", "()Lcom/bapis/bilibili/app/home/v1/KRecentRecommendMetaInfo;", "cover", "", "getCover$annotations", "getCover", "()Ljava/lang/String;", "badge", "Lcom/bapis/bilibili/app/home/v1/KBadge;", "getBadge$annotations", "getBadge", "()Lcom/bapis/bilibili/app/home/v1/KBadge;", "title", "getTitle$annotations", "getTitle", "subTitle", "getSubTitle$annotations", "getSubTitle", "addTime", "getAddTime$annotations", "getAddTime", "url", "getUrl", "deleted", "", "getDeleted$annotations", "getDeleted", "()Z", "fromCache", "getFromCache", "markDeleted", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface RecentContent {
    String getAddTime();

    KBadge getBadge();

    String getCover();

    boolean getDeleted();

    boolean getFromCache();

    KRecentRecommendMetaInfo getRecMeta();

    String getSubTitle();

    String getTitle();

    String getUrl();

    RecentContent markDeleted();

    /* compiled from: Content.kt */
    /* renamed from: home.sidecenter.recent.RecentContent$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public final /* synthetic */ class CC {
        public static String $default$getCover(RecentContent _this) {
            String cover;
            KRecentRecommendMetaInfo recMeta = _this.getRecMeta();
            return (recMeta == null || (cover = recMeta.getCover()) == null) ? "" : cover;
        }

        public static KBadge $default$getBadge(RecentContent _this) {
            KRecentRecommendMetaInfo recMeta = _this.getRecMeta();
            if (recMeta != null) {
                return recMeta.getBadge();
            }
            return null;
        }

        public static String $default$getTitle(RecentContent _this) {
            String title;
            KRecentRecommendMetaInfo recMeta = _this.getRecMeta();
            return (recMeta == null || (title = recMeta.getTitle()) == null) ? "" : title;
        }

        public static String $default$getSubTitle(RecentContent _this) {
            String subTitle;
            KRecentRecommendMetaInfo recMeta = _this.getRecMeta();
            return (recMeta == null || (subTitle = recMeta.getSubTitle()) == null) ? "" : subTitle;
        }

        public static String $default$getAddTime(RecentContent _this) {
            String addTime;
            KRecentRecommendMetaInfo recMeta = _this.getRecMeta();
            return (recMeta == null || (addTime = recMeta.getAddTime()) == null) ? "" : addTime;
        }

        public static String $default$getUrl(RecentContent _this) {
            String url;
            KRecentRecommendMetaInfo recMeta = _this.getRecMeta();
            return (recMeta == null || (url = recMeta.getUrl()) == null) ? "" : url;
        }
    }

    /* compiled from: Content.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getAddTime$annotations() {
        }

        public static /* synthetic */ void getBadge$annotations() {
        }

        public static /* synthetic */ void getCover$annotations() {
        }

        public static /* synthetic */ void getDeleted$annotations() {
        }

        public static /* synthetic */ void getRecMeta$annotations() {
        }

        public static /* synthetic */ void getSubTitle$annotations() {
        }

        public static /* synthetic */ void getTitle$annotations() {
        }

        @Deprecated
        public static String getCover(RecentContent $this) {
            return CC.$default$getCover($this);
        }

        @Deprecated
        public static KBadge getBadge(RecentContent $this) {
            return CC.$default$getBadge($this);
        }

        @Deprecated
        public static String getTitle(RecentContent $this) {
            return CC.$default$getTitle($this);
        }

        @Deprecated
        public static String getSubTitle(RecentContent $this) {
            return CC.$default$getSubTitle($this);
        }

        @Deprecated
        public static String getAddTime(RecentContent $this) {
            return CC.$default$getAddTime($this);
        }

        @Deprecated
        public static String getUrl(RecentContent $this) {
            return CC.$default$getUrl($this);
        }
    }
}