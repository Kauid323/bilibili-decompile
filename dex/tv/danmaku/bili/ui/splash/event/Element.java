package tv.danmaku.bili.ui.splash.event;

import androidx.core.util.ObjectsCompat;
import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.bili.ui.splash.common.CachedResource;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: EventSplashData.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010F\u001a\u00020\u001aJ\b\u0010G\u001a\u00020HH\u0016J\b\u0010I\u001a\u00020\u000bH\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR \u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010%\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR \u0010(\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR\u001c\u0010+\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR\u001e\u0010.\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR \u00101\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R \u00107\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\r\"\u0004\b9\u0010\u000fR \u0010:\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\r\"\u0004\b<\u0010\u000fR \u0010=\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\r\"\u0004\b?\u0010\u000fR\u001e\u0010@\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\"\"\u0004\bB\u0010$R\u001e\u0010C\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\"\"\u0004\bE\u0010$¨\u0006J"}, d2 = {"Ltv/danmaku/bili/ui/splash/event/Element;", "Ltv/danmaku/bili/ui/splash/common/CachedResource;", "<init>", "()V", "action", "Ltv/danmaku/bili/ui/splash/event/Action;", "getAction", "()Ltv/danmaku/bili/ui/splash/event/Action;", "setAction", "(Ltv/danmaku/bili/ui/splash/event/Action;)V", "bgColor", "", "getBgColor", "()Ljava/lang/String;", "setBgColor", "(Ljava/lang/String;)V", "bgImage", "getBgImage", "setBgImage", "bgImageHash", "getBgImageHash", "setBgImageHash", "bgImageLocalPath", "getBgImageLocalPath", "setBgImageLocalPath", "elementType", "", "getElementType", "()I", "setElementType", "(I)V", "id", "", "getId", "()J", "setId", "(J)V", "imageUrl", "getImageUrl", "setImageUrl", "imageUrlHash", "getImageUrlHash", "setImageUrlHash", "imageUrlLocalPath", "getImageUrlLocalPath", "setImageUrlLocalPath", "interactStyle", "getInteractStyle", "setInteractStyle", "layout", "Ltv/danmaku/bili/ui/splash/event/Layout;", "getLayout", "()Ltv/danmaku/bili/ui/splash/event/Layout;", "setLayout", "(Ltv/danmaku/bili/ui/splash/event/Layout;)V", RankRouter.BundleKey.ACTION_PARAM_TITLE, "getTitle", "setTitle", "text", "getText", "setText", "textColor", "getTextColor", "setTextColor", "showDuration", "getShowDuration", "setShowDuration", "hideDuration", "getHideDuration", "setHideDuration", "getResourceHash", "isResValid", "", "toString", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class Element implements CachedResource {
    public static final int $stable = 8;
    @JSONField(name = "action")
    private Action action;
    @JSONField(name = "bg_color")
    private String bgColor;
    @JSONField(name = "bg_image")
    private String bgImage;
    @JSONField(name = "bg_image_hash")
    private String bgImageHash;
    private String bgImageLocalPath;
    @JSONField(name = "element_type")
    private int elementType;
    @JSONField(name = "hide_duration")
    private long hideDuration;
    @JSONField(name = "id")
    private long id;
    @JSONField(name = "image_url")
    private String imageUrl;
    @JSONField(name = "image_url_hash")
    private String imageUrlHash;
    private String imageUrlLocalPath;
    @JSONField(name = "interact_style")
    private int interactStyle;
    @JSONField(name = "layout")
    private Layout layout;
    @JSONField(name = "show_duration")
    private long showDuration;
    @JSONField(name = "text")
    private String text;
    @JSONField(name = "text_color")
    private String textColor;
    @JSONField(name = RankRouter.BundleKey.ACTION_PARAM_TITLE)
    private String title;

    public final Action getAction() {
        return this.action;
    }

    public final void setAction(Action action) {
        this.action = action;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final void setBgColor(String str) {
        this.bgColor = str;
    }

    public final String getBgImage() {
        return this.bgImage;
    }

    public final void setBgImage(String str) {
        this.bgImage = str;
    }

    public final String getBgImageHash() {
        return this.bgImageHash;
    }

    public final void setBgImageHash(String str) {
        this.bgImageHash = str;
    }

    public final String getBgImageLocalPath() {
        return this.bgImageLocalPath;
    }

    public final void setBgImageLocalPath(String str) {
        this.bgImageLocalPath = str;
    }

    public final int getElementType() {
        return this.elementType;
    }

    public final void setElementType(int i) {
        this.elementType = i;
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public final String getImageUrlHash() {
        return this.imageUrlHash;
    }

    public final void setImageUrlHash(String str) {
        this.imageUrlHash = str;
    }

    public final String getImageUrlLocalPath() {
        return this.imageUrlLocalPath;
    }

    public final void setImageUrlLocalPath(String str) {
        this.imageUrlLocalPath = str;
    }

    public final int getInteractStyle() {
        return this.interactStyle;
    }

    public final void setInteractStyle(int i) {
        this.interactStyle = i;
    }

    public final Layout getLayout() {
        return this.layout;
    }

    public final void setLayout(Layout layout) {
        this.layout = layout;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(String str) {
        this.textColor = str;
    }

    public final long getShowDuration() {
        return this.showDuration;
    }

    public final void setShowDuration(long j) {
        this.showDuration = j;
    }

    public final long getHideDuration() {
        return this.hideDuration;
    }

    public final void setHideDuration(long j) {
        this.hideDuration = j;
    }

    public final int getResourceHash() {
        Iterable elements;
        int hash = ObjectsCompat.hash(new Object[]{this.imageUrlHash, this.bgImageHash});
        Action action = this.action;
        if (action != null && (elements = action.getElements()) != null) {
            Iterable $this$forEach$iv = elements;
            for (Object element$iv : $this$forEach$iv) {
                Element it = (Element) element$iv;
                hash = it != null ? it.getResourceHash() : hash ^ 0;
            }
        }
        return hash;
    }

    @Override // tv.danmaku.bili.ui.splash.common.CachedResource
    public boolean isResValid() {
        Iterable elements;
        boolean z;
        String str = this.bgImage;
        boolean z2 = false;
        if (!(str == null || StringsKt.isBlank(str))) {
            String fetchResourceLocalPathByHash = EventSplashStorageKt.fetchResourceLocalPathByHash(this.bgImageHash);
            if (fetchResourceLocalPathByHash == null) {
                fetchResourceLocalPathByHash = EventSplashStorageKt.fetchResourceLocalPathByUrl(this.bgImage);
            }
            this.bgImageLocalPath = fetchResourceLocalPathByHash;
            String str2 = this.bgImageLocalPath;
            return !((str2 == null || StringsKt.isBlank(str2)) ? true : true);
        }
        String str3 = this.imageUrl;
        if (!(str3 == null || StringsKt.isBlank(str3))) {
            String fetchResourceLocalPathByHash2 = EventSplashStorageKt.fetchResourceLocalPathByHash(this.imageUrlHash);
            if (fetchResourceLocalPathByHash2 == null) {
                fetchResourceLocalPathByHash2 = EventSplashStorageKt.fetchResourceLocalPathByUrl(this.imageUrl);
            }
            this.imageUrlLocalPath = fetchResourceLocalPathByHash2;
            String str4 = this.imageUrlLocalPath;
            return !((str4 == null || StringsKt.isBlank(str4)) ? true : true);
        }
        Action action = this.action;
        if (action != null && (elements = action.getElements()) != null) {
            Iterable $this$forEach$iv = elements;
            for (Object element$iv : $this$forEach$iv) {
                Element it = (Element) element$iv;
                if (it == null || !it.isResValid()) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (!z) {
                    return false;
                }
            }
        }
        return true;
    }

    public String toString() {
        String obj = super.toString();
        long j = this.id;
        int i = this.elementType;
        String str = this.text;
        Layout layout = this.layout;
        return obj + "id:" + j + " elementType:" + i + " text:" + str + " layout:" + layout + " action:" + this.action;
    }
}