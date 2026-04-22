package tv.danmaku.bili.ui.splash.event;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.bilibili.droid.DimenUtilsKt;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.utils.UiUtilsKt;
import tv.danmaku.bili.widget.PendantAvatarFrameLayout;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ElementFactory.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\"H\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010$\u001a\u00020\"H\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010$\u001a\u00020\"H\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010&2\u0006\u0010$\u001a\u00020\"H\u0002J\u0012\u0010)\u001a\u0004\u0018\u00010&2\u0006\u0010$\u001a\u00020\"H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010&2\u0006\u0010$\u001a\u00020\"H\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010&2\u0006\u0010$\u001a\u00020\"H\u0002J\u0010\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000eH\u0002J\"\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020&2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u000eH\u0002J\u0018\u00103\u001a\u0002042\u0006\u0010/\u001a\u00020&2\u0006\u00105\u001a\u000206H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b¨\u00067"}, d2 = {"Ltv/danmaku/bili/ui/splash/event/ElementFactory;", "", "splashData", "Ltv/danmaku/bili/ui/splash/event/EventSplashData;", "container", "Landroidx/constraintlayout/widget/ConstraintLayout;", "actionCallback", "Ltv/danmaku/bili/ui/splash/event/ElementActionCallback;", "<init>", "(Ltv/danmaku/bili/ui/splash/event/EventSplashData;Landroidx/constraintlayout/widget/ConstraintLayout;Ltv/danmaku/bili/ui/splash/event/ElementActionCallback;)V", "mContext", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "mRootWidth", "", "mRootHeight", "videoViewWidth", "getVideoViewWidth", "()I", "setVideoViewWidth", "(I)V", "videoViewHeight", "getVideoViewHeight", "setVideoViewHeight", "mConstraintSet", "Landroidx/constraintlayout/widget/ConstraintSet;", "getMConstraintSet", "()Landroidx/constraintlayout/widget/ConstraintSet;", "mConstraintSet$delegate", "Lkotlin/Lazy;", "generateAndDisplayElements", "", "elements", "", "Ltv/danmaku/bili/ui/splash/event/Element;", "addElementToContainer", "element", "generateBlankView", "Landroid/view/View;", "generatePic", "generateUserName", "generateAvatar", "generateText", "generateCompositeView", "getUserLevelRes", "level", "bindAction", "child", "action", "Ltv/danmaku/bili/ui/splash/event/Action;", "interactStyle", "generateLayoutParams", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "layout", "Ltv/danmaku/bili/ui/splash/event/Layout;", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ElementFactory {
    public static final int $stable = 8;
    private final ElementActionCallback actionCallback;
    private final ConstraintLayout container;
    private final Lazy mConstraintSet$delegate;
    private final Context mContext;
    private final int mRootHeight;
    private final int mRootWidth;
    private final EventSplashData splashData;
    private int videoViewHeight;
    private int videoViewWidth;

    public ElementFactory(EventSplashData splashData, ConstraintLayout container, ElementActionCallback actionCallback) {
        Intrinsics.checkNotNullParameter(splashData, "splashData");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(actionCallback, "actionCallback");
        this.splashData = splashData;
        this.container = container;
        this.actionCallback = actionCallback;
        if (!(this.container.getWidth() != 0)) {
            throw new IllegalStateException("Check failed.");
        }
        this.mContext = this.container.getContext();
        this.mRootWidth = this.container.getWidth();
        this.mRootHeight = this.container.getHeight();
        this.mConstraintSet$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.event.ElementFactory$$ExternalSyntheticLambda0
            public final Object invoke() {
                ConstraintSet mConstraintSet_delegate$lambda$0;
                mConstraintSet_delegate$lambda$0 = ElementFactory.mConstraintSet_delegate$lambda$0();
                return mConstraintSet_delegate$lambda$0;
            }
        });
    }

    public final int getVideoViewWidth() {
        return this.videoViewWidth;
    }

    public final void setVideoViewWidth(int i) {
        this.videoViewWidth = i;
    }

    public final int getVideoViewHeight() {
        return this.videoViewHeight;
    }

    public final void setVideoViewHeight(int i) {
        this.videoViewHeight = i;
    }

    private final ConstraintSet getMConstraintSet() {
        return (ConstraintSet) this.mConstraintSet$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConstraintSet mConstraintSet_delegate$lambda$0() {
        return new ConstraintSet();
    }

    public final void generateAndDisplayElements(List<Element> list) {
        Iterable elements = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(elements, "elements");
        getMConstraintSet().clone(this.container);
        Iterable $this$forEach$iv = elements;
        for (Object element$iv : $this$forEach$iv) {
            Element it = (Element) element$iv;
            addElementToContainer(it);
        }
        getMConstraintSet().applyTo(this.container);
    }

    private final void addElementToContainer(Element element) {
        View elementView;
        switch (element.getElementType()) {
            case 0:
                elementView = generateBlankView(element);
                break;
            case 1:
                elementView = generateText(element);
                break;
            case 2:
                elementView = generatePic(element);
                break;
            case 3:
            case 4:
            default:
                elementView = null;
                break;
            case 5:
                elementView = generateCompositeView(element);
                break;
        }
        BLog.i("[EventSplash]ElementFactory", "generate element :" + element + " view:" + elementView);
        if (elementView != null) {
            elementView.setTag(R.id.tag_splash_element_id, Long.valueOf(element.getId()));
            this.container.addView(elementView);
        }
    }

    private final View generateBlankView(Element element) {
        BLog.i("[EventSplash]ElementFactory", "start generateBlankView element:" + element);
        Layout layout = element.getLayout();
        if (layout == null) {
            return null;
        }
        View view2 = new View(this.mContext);
        view2.setLayoutParams((ViewGroup.LayoutParams) generateLayoutParams(view2, layout));
        Integer backgroundColor = UiUtilsKt.parseColorSafely(element.getBgColor());
        if (backgroundColor != null) {
            view2.setBackgroundColor(backgroundColor.intValue());
        }
        bindAction(view2, element.getAction(), element.getInteractStyle());
        return view2;
    }

    private final View generatePic(Element element) {
        BLog.i("[EventSplash]ElementFactory", "start generatePic element:" + element);
        Layout layout = element.getLayout();
        if (layout == null) {
            return null;
        }
        String localPath = element.getImageUrlLocalPath();
        String str = localPath;
        boolean z = false;
        if (str == null || StringsKt.isBlank(str)) {
            String fetchResourceLocalPathByHash = EventSplashStorageKt.fetchResourceLocalPathByHash(element.getImageUrlHash());
            if (fetchResourceLocalPathByHash == null) {
                fetchResourceLocalPathByHash = EventSplashStorageKt.fetchResourceLocalPathByUrl(element.getImageUrl());
            }
            localPath = fetchResourceLocalPathByHash;
        }
        String str2 = localPath;
        if (str2 == null || StringsKt.isBlank(str2)) {
            z = true;
        }
        if (z && element.isResValid()) {
            return null;
        }
        ImageView imageView = new ImageView(this.mContext);
        imageView.setLayoutParams((ViewGroup.LayoutParams) generateLayoutParams(imageView, layout));
        Bitmap bitmap = BitmapFactory.decodeFile(localPath);
        imageView.setImageBitmap(bitmap);
        bindAction(imageView, element.getAction(), element.getInteractStyle());
        return imageView;
    }

    private final View generateUserName(Element element) {
        Layout layout;
        BLog.i("[EventSplash]ElementFactory", "start generateUserName element:" + element);
        Account account = this.splashData.getAccount();
        if (account == null || (layout = element.getLayout()) == null) {
            return null;
        }
        int levelRes = 0;
        View itemView = LayoutInflater.from(this.mContext).inflate(R.layout.event_splash_element_nick_name, (ViewGroup) this.container, false);
        View findViewById = itemView.findViewById(R.id.nickname);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        TextView nickNameView = (TextView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.level);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        ImageView levelView = (ImageView) findViewById2;
        switch (account.getLevel()) {
            case 0:
                levelRes = com.bilibili.lib.basecomponent.R.drawable.ic_lv0;
                break;
            case 1:
                levelRes = com.bilibili.lib.basecomponent.R.drawable.ic_lv1;
                break;
            case 2:
                levelRes = com.bilibili.lib.basecomponent.R.drawable.ic_lv2;
                break;
            case 3:
                levelRes = com.bilibili.lib.basecomponent.R.drawable.ic_lv3;
                break;
            case 4:
                levelRes = com.bilibili.lib.basecomponent.R.drawable.ic_lv4;
                break;
            case 5:
                levelRes = com.bilibili.lib.basecomponent.R.drawable.ic_lv5;
                break;
            case 6:
                levelRes = com.bilibili.lib.basecomponent.R.drawable.ic_lv6;
                break;
        }
        if (levelRes != 0) {
            levelView.setImageResource(levelRes);
        } else {
            levelView.setVisibility(8);
        }
        nickNameView.setText(account.getUname());
        Integer color = UiUtilsKt.parseColorSafely(element.getTextColor());
        if (color != null) {
            nickNameView.setTextColor(color.intValue());
        }
        bindAction(nickNameView, element.getAction(), element.getInteractStyle());
        nickNameView.setLayoutParams((ViewGroup.LayoutParams) generateLayoutParams(nickNameView, layout));
        return nickNameView;
    }

    private final View generateAvatar(Element element) {
        Layout layout;
        BLog.i("[EventSplash]ElementFactory", "start generateAvatar element:" + element);
        Account account = this.splashData.getAccount();
        if (account == null || (layout = element.getLayout()) == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.event_splash_element_avatar, (ViewGroup) this.container, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type tv.danmaku.bili.widget.PendantAvatarFrameLayout");
        PendantAvatarFrameLayout avatar = (PendantAvatarFrameLayout) inflate;
        PendantAvatarFrameLayout.ShowParams showParam = new PendantAvatarFrameLayout.ShowParams().avatarImgUrl(account.getUimage());
        avatar.show(showParam);
        layout.setWidthPx(80);
        layout.setHeightPx(80);
        ConstraintLayout.LayoutParams lp = generateLayoutParams((View) avatar, layout);
        avatar.setLayoutParams((ViewGroup.LayoutParams) lp);
        return (View) avatar;
    }

    private final View generateText(Element element) {
        BLog.i("[EventSplash]ElementFactory", "start generateText element:" + element);
        Layout layout = element.getLayout();
        if (layout == null) {
            return null;
        }
        TextView tv2 = new TextView(this.mContext);
        tv2.setTextSize(16.0f);
        tv2.setLayoutParams((ViewGroup.LayoutParams) generateLayoutParams(tv2, layout));
        tv2.setText(element.getText());
        tv2.setGravity(17);
        Integer parseColorSafely = UiUtilsKt.parseColorSafely(element.getTextColor());
        if (parseColorSafely != null) {
            int it = parseColorSafely.intValue();
            tv2.setTextColor(it);
        }
        String bgImage = EventSplashStorageKt.fetchResourceLocalPathByHash(element.getBgImageHash());
        if (bgImage == null) {
            bgImage = EventSplashStorageKt.fetchResourceLocalPathByUrl(element.getBgImage());
        }
        Integer bgColor = UiUtilsKt.parseColorSafely(element.getBgColor());
        String str = bgImage;
        if (!(str == null || StringsKt.isBlank(str))) {
            tv2.setBackground(BitmapDrawable.createFromPath(bgImage));
        } else if (bgColor != null) {
            if (element.getInteractStyle() == 1) {
                GradientDrawable $this$generateText_u24lambda_u241 = new GradientDrawable();
                $this$generateText_u24lambda_u241.setCornerRadius(100000.0f);
                $this$generateText_u24lambda_u241.setColor(bgColor.intValue());
                tv2.setBackground($this$generateText_u24lambda_u241);
            } else {
                tv2.setBackgroundColor(bgColor.intValue());
            }
        }
        bindAction(tv2, element.getAction(), element.getInteractStyle());
        return tv2;
    }

    private final View generateCompositeView(Element element) {
        Layout layout;
        BLog.i("[EventSplash]ElementFactory", "start generateCompositeView element:" + element);
        Account account = this.splashData.getAccount();
        if (account == null || (layout = element.getLayout()) == null) {
            return null;
        }
        String localPath = element.getImageUrlLocalPath();
        String str = localPath;
        if (str == null || StringsKt.isBlank(str)) {
            String fetchResourceLocalPathByHash = EventSplashStorageKt.fetchResourceLocalPathByHash(element.getImageUrlHash());
            if (fetchResourceLocalPathByHash == null) {
                fetchResourceLocalPathByHash = EventSplashStorageKt.fetchResourceLocalPathByUrl(element.getImageUrl());
            }
            localPath = fetchResourceLocalPathByHash;
        }
        Bitmap bitmap = BitmapFactory.decodeFile(localPath);
        BitmapDrawable drawable = new BitmapDrawable(this.mContext.getResources(), bitmap);
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.bili_app_layout_event_splash_register, (ViewGroup) this.container, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        View view2 = (ConstraintLayout) inflate;
        view2.setBackground(drawable);
        PendantAvatarFrameLayout avatar = (PendantAvatarFrameLayout) view2.findViewById(R.id.avatar);
        PendantAvatarFrameLayout.ShowParams showParam = new PendantAvatarFrameLayout.ShowParams().avatarImgUrl(account.getUimage()).borderColor(R.color.avatar_border).borderWidth(2.0f);
        avatar.show(showParam);
        View findViewById = view2.findViewById(R.id.nickname);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        TextView nickNameView = (TextView) findViewById;
        View findViewById2 = view2.findViewById(R.id.level);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        ImageView levelView = (ImageView) findViewById2;
        int levelRes = getUserLevelRes(account.getLevel());
        if (levelRes != 0) {
            levelView.setImageResource(levelRes);
        } else {
            levelView.setVisibility(8);
        }
        nickNameView.setText(account.getUname());
        View findViewById3 = view2.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        TextView title = (TextView) findViewById3;
        title.setText(element.getTitle());
        View findViewById4 = view2.findViewById(R.id.content);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        TextView content = (TextView) findViewById4;
        content.setText(element.getText());
        layout.setWidthPx(DimenUtilsKt.dpToPx(layout.getWidthPx()));
        layout.setHeightPx(DimenUtilsKt.dpToPx(layout.getHeightPx()));
        view2.setLayoutParams(generateLayoutParams(view2, layout));
        return view2;
    }

    private final int getUserLevelRes(int level) {
        switch (level) {
            case 0:
                return com.bilibili.lib.basecomponent.R.drawable.ic_lv0;
            case 1:
                return com.bilibili.lib.basecomponent.R.drawable.ic_lv1;
            case 2:
                return com.bilibili.lib.basecomponent.R.drawable.ic_lv2;
            case 3:
                return com.bilibili.lib.basecomponent.R.drawable.ic_lv3;
            case 4:
                return com.bilibili.lib.basecomponent.R.drawable.ic_lv4;
            case 5:
                return com.bilibili.lib.basecomponent.R.drawable.ic_lv5;
            case 6:
                return com.bilibili.lib.basecomponent.R.drawable.ic_lv6;
            default:
                return 0;
        }
    }

    private final void bindAction(View child, final Action action, int interactStyle) {
        BLog.i("[EventSplash]ElementFactory", "bind action to " + child + " action:" + action + " interactStyle:" + interactStyle);
        if (action == null) {
            return;
        }
        final String url = action.getJumpUrl();
        boolean z = true;
        if (interactStyle == 1) {
            String str = url;
            if (str != null && !StringsKt.isBlank(str)) {
                z = false;
            }
            if (!z) {
                child.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.event.ElementFactory$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ElementFactory.bindAction$lambda$0(url, this, action, view2);
                    }
                });
                return;
            }
        }
        if (interactStyle == 2) {
            child.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.event.ElementFactory$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ElementFactory.bindAction$lambda$1(ElementFactory.this, action, view2);
                }
            });
        } else {
            child.setOnClickListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindAction$lambda$0(String $url, ElementFactory this$0, Action $action, View it) {
        BLRouter.routeTo$default(RouteRequestKt.toRouteRequest($url), (Context) null, 2, (Object) null);
        this$0.actionCallback.onActionTrigger($action, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindAction$lambda$1(ElementFactory this$0, Action $action, View it) {
        long currentPosition = this$0.actionCallback.getVideoCurrentPosition();
        if (currentPosition > $action.getInteractTime()) {
            this$0.actionCallback.seekTo(RangesKt.coerceAtLeast($action.getVideoSeekTo(), 0));
            this$0.actionCallback.onActionTrigger($action, false);
        }
        BLog.i("[EventSplash]ElementFactory", "on video action click current position :" + currentPosition);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ConstraintLayout.LayoutParams generateLayoutParams(View child, Layout layout) {
        int width;
        int height;
        int id;
        int anchorWidth = layout.getLayoutType() == 4 ? this.videoViewWidth : this.mRootWidth;
        int anchorHeight = layout.getLayoutType() == 4 ? this.videoViewHeight : this.mRootHeight;
        if (!(layout.getWidthPercent() == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN)) {
            if (!(layout.getHeightPercent() == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN)) {
                width = (int) (anchorWidth * layout.getWidthPercent() * 0.01f);
                height = (int) (anchorHeight * layout.getHeightPercent() * 0.01f);
                if (child.getId() == -1) {
                    id = child.getId();
                } else {
                    id = ViewCompat.generateViewId();
                    child.setId(id);
                }
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(width, height);
                int top = (layout.getTopPercent() > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN ? 1 : (layout.getTopPercent() == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN ? 0 : -1)) != 0 ? (int) (anchorHeight * layout.getTopPercent() * 0.01f) : layout.getTopPx();
                int left = (layout.getLeftPercent() > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN ? 1 : (layout.getLeftPercent() == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN ? 0 : -1)) != 0 ? (int) (anchorWidth * layout.getLeftPercent() * 0.01f) : layout.getLeftPx();
                int bottom = layout.getBottomPercent() == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN ? (int) (anchorHeight * layout.getBottomPercent() * 0.01f) : layout.getBottomPx();
                switch (layout.getLayoutType()) {
                    case 0:
                        int i = id;
                        getMConstraintSet().connect(i, 6, 0, 6, left);
                        getMConstraintSet().connect(i, 3, 0, 3, top);
                        break;
                    case 1:
                        int i2 = id;
                        getMConstraintSet().connect(i2, 6, 0, 6, left - (width / 2));
                        getMConstraintSet().connect(i2, 3, 0, 3, top - (height / 2));
                        break;
                    case 2:
                        int i3 = id;
                        getMConstraintSet().connect(i3, 6, 0, 6, left);
                        getMConstraintSet().connect(i3, 4, 0, 4, bottom);
                        break;
                    case 3:
                        int i4 = id;
                        getMConstraintSet().connect(i4, 6, 0, 6, left - (width / 2));
                        getMConstraintSet().connect(i4, 4, 0, 4, bottom - (height / 2));
                        break;
                    case 4:
                        float relativeLeft = left - ((this.videoViewWidth - this.mRootWidth) * 0.5f);
                        float relativeTop = top - ((this.videoViewHeight - this.mRootHeight) * 0.5f);
                        int i5 = id;
                        getMConstraintSet().connect(i5, 6, 0, 6, (int) (relativeLeft - (width / 2.0f)));
                        getMConstraintSet().connect(i5, 3, 0, 3, (int) (relativeTop - (height / 2.0f)));
                        break;
                }
                getMConstraintSet().constrainHeight(id, height);
                getMConstraintSet().constrainWidth(id, width);
                return layoutParams;
            }
        }
        width = layout.getWidthPx();
        height = layout.getHeightPx();
        if (child.getId() == -1) {
        }
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(width, height);
        int top2 = (layout.getTopPercent() > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN ? 1 : (layout.getTopPercent() == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN ? 0 : -1)) != 0 ? (int) (anchorHeight * layout.getTopPercent() * 0.01f) : layout.getTopPx();
        int left2 = (layout.getLeftPercent() > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN ? 1 : (layout.getLeftPercent() == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN ? 0 : -1)) != 0 ? (int) (anchorWidth * layout.getLeftPercent() * 0.01f) : layout.getLeftPx();
        if (layout.getBottomPercent() == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
        }
        switch (layout.getLayoutType()) {
        }
        getMConstraintSet().constrainHeight(id, height);
        getMConstraintSet().constrainWidth(id, width);
        return layoutParams2;
    }
}