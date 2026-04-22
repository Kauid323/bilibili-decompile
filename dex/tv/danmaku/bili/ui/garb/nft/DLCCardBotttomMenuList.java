package tv.danmaku.bili.ui.garb.nft;

import ComposableSingletons$CustomBottomSheetKt$;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.DividerKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bili.digital.common.NftCardMenuLimitedDialog;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.xpref.Xpref;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.ui.garb.GarbManagerDelegateKt;
import tv.danmaku.bili.ui.garb.api.CardRight;
import tv.danmaku.bili.ui.garb.api.CardRightShow;
import tv.danmaku.bili.ui.garb.api.UseMenu;
import tv.danmaku.bili.ui.garb.digital.base.view.DigitalFromType;
import tv.danmaku.bili.ui.garb.nft.DLCCardBotttomMenuList;
import tv.danmaku.bili.ui.garb.nft.util.DLCConstUtilKt;

/* compiled from: DLCCardBotttomMenuList.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 52\u00020\u0001:\u000245B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000fJ\u0006\u0010!\u001a\u00020\u001dJ\u0006\u0010\"\u001a\u00020\u001dJ\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u0011H\u0002J\u0018\u0010%\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010$\u001a\u00020\u0011H\u0002J\u0010\u0010*\u001a\u00020)2\u0006\u0010$\u001a\u00020\u0011H\u0002J\u0006\u0010+\u001a\u00020\u001dJ\u0010\u0010,\u001a\u00020-2\u0006\u0010&\u001a\u00020'H\u0002J\u0018\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u0002002\u0006\u0010&\u001a\u00020'H\u0002J\u001b\u00101\u001a\u00020\u001d2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0007¢\u0006\u0002\u00103R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u00066"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/DLCCardBotttomMenuList;", "", "context", "Landroid/app/Activity;", "mMid", "", "splashSettingNoticeDialogService", "Ltv/danmaku/bili/ui/garb/nft/DLCSplashSettingNoticeDialogService;", "<init>", "(Landroid/app/Activity;JLtv/danmaku/bili/ui/garb/nft/DLCSplashSettingNoticeDialogService;)V", "mPageType", "Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;", "mIsMe", "", AuthResultCbHelper.ARGS_CALLBACK, "Ltv/danmaku/bili/ui/garb/nft/BottomMenuButtonCallback;", "mRootView", "Landroid/view/ViewGroup;", "<set-?>", "", "Ltv/danmaku/bili/ui/garb/nft/DLCCardBotttomMenuList$UseMenuVM;", "useMenusData", "getUseMenusData", "()Ljava/util/List;", "setUseMenusData", "(Ljava/util/List;)V", "useMenusData$delegate", "Landroidx/compose/runtime/MutableState;", "init", "", "menu", "pageType", "cb", "open", "close", "initMenuButtons", "root", "initMyMenuButtons", "textColor", "", "initLine", "Landroid/view/View;", "initSpace", "refreshButton", "initBottomButtonWithType", "Landroidx/appcompat/widget/LinearLayoutCompat;", "initButtonWithType", "type", "Ltv/danmaku/bili/ui/garb/nft/DLCCardBottomButtonType;", "UseMenuList", "useMenus", "(Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "UseMenuVM", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCCardBotttomMenuList {
    private static final String KEY_FROM_TYPE = "from_type";
    private BottomMenuButtonCallback callback;
    private final Activity context;
    private final boolean mIsMe;
    private final long mMid;
    private DigitalFromType mPageType;
    private ViewGroup mRootView;
    private final DLCSplashSettingNoticeDialogService splashSettingNoticeDialogService;
    private final MutableState useMenusData$delegate;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DLCCardBotttomMenuList.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DLCCardBottomButtonType.values().length];
            try {
                iArr[DLCCardBottomButtonType.CHANGE_AVATAR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DLCCardBottomButtonType.CHANGE_HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UseMenuList$lambda$1(DLCCardBotttomMenuList dLCCardBotttomMenuList, List list, int i, Composer composer, int i2) {
        dLCCardBotttomMenuList.UseMenuList(list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public DLCCardBotttomMenuList(Activity context, long mMid, DLCSplashSettingNoticeDialogService splashSettingNoticeDialogService) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(splashSettingNoticeDialogService, "splashSettingNoticeDialogService");
        this.context = context;
        this.mMid = mMid;
        this.splashSettingNoticeDialogService = splashSettingNoticeDialogService;
        this.mPageType = DigitalFromType.SEE;
        this.mIsMe = this.mMid == BiliAccounts.get(this.context).mid();
        this.useMenusData$delegate = SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* compiled from: DLCCardBotttomMenuList.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R+\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/DLCCardBotttomMenuList$UseMenuVM;", "", "data", "Ltv/danmaku/bili/ui/garb/api/UseMenu;", "<init>", "(Ltv/danmaku/bili/ui/garb/api/UseMenu;)V", "getData", "()Ltv/danmaku/bili/ui/garb/api/UseMenu;", "<set-?>", "", "badgeShowing", "getBadgeShowing", "()Z", "setBadgeShowing", "(Z)V", "badgeShowing$delegate", "Landroidx/compose/runtime/MutableState;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class UseMenuVM {
        public static final int $stable = 0;
        private final MutableState badgeShowing$delegate;
        private final UseMenu data;

        public UseMenuVM(UseMenu data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.badgeShowing$delegate = SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
        }

        public final UseMenu getData() {
            return this.data;
        }

        public final boolean getBadgeShowing() {
            State $this$getValue$iv = this.badgeShowing$delegate;
            return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
        }

        public final void setBadgeShowing(boolean z) {
            MutableState $this$setValue$iv = this.badgeShowing$delegate;
            Object value$iv = Boolean.valueOf(z);
            $this$setValue$iv.setValue(value$iv);
        }
    }

    private final List<UseMenuVM> getUseMenusData() {
        State $this$getValue$iv = this.useMenusData$delegate;
        return (List) $this$getValue$iv.getValue();
    }

    private final void setUseMenusData(List<UseMenuVM> list) {
        MutableState $this$setValue$iv = this.useMenusData$delegate;
        $this$setValue$iv.setValue(list);
    }

    public final void init(ViewGroup menu, DigitalFromType pageType, BottomMenuButtonCallback cb) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(cb, "cb");
        if (menu == null) {
            return;
        }
        this.callback = cb;
        this.mPageType = pageType;
        this.mRootView = menu;
        initMenuButtons(menu);
    }

    public final void open() {
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    public final void close() {
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    private final void initMenuButtons(ViewGroup root) {
        BLog.i(GarbManagerDelegateKt.TAG, "initMenuButtons isMe " + this.mIsMe);
        int textColor = Color.parseColor("#FFFFFF");
        if (this.mIsMe) {
            initMyMenuButtons(root, textColor);
        }
    }

    private final void initMyMenuButtons(ViewGroup root, int textColor) {
        Iterable emptyList;
        View view;
        boolean z;
        CardRightShow cardRightShow;
        View initButtonWithType = initButtonWithType(DLCCardBottomButtonType.CHANGE_AVATAR, textColor);
        View line = initLine(root);
        View initButtonWithType2 = initButtonWithType(DLCCardBottomButtonType.CHANGE_HEADER, textColor);
        View space = initSpace(root);
        LinearLayoutCompat cancelButton = initBottomButtonWithType(textColor);
        root.addView(initButtonWithType);
        root.addView(line);
        root.addView(initButtonWithType2);
        BottomMenuButtonCallback bottomMenuButtonCallback = this.callback;
        if (bottomMenuButtonCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            bottomMenuButtonCallback = null;
        }
        Pair<CardRightShow, CardRight> limitInfo = bottomMenuButtonCallback.getLimitInfo();
        if (limitInfo == null || (cardRightShow = (CardRightShow) limitInfo.getFirst()) == null || (emptyList = cardRightShow.getUseMenus()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        Iterable $this$map$iv = emptyList;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            UseMenu it = (UseMenu) item$iv$iv;
            UseMenuVM $this$initMyMenuButtons_u24lambda_u240_u240 = new UseMenuVM(it);
            View view2 = initButtonWithType;
            View line2 = line;
            if ($this$initMyMenuButtons_u24lambda_u240_u240.getData().getJumpType() == UseMenu.Type.AppWidget) {
                view = initButtonWithType2;
                z = false;
                if (Xpref.getDefaultSharedPreferences(this.context).getBoolean("app_widget_enter_badge_showed", false)) {
                    $this$initMyMenuButtons_u24lambda_u240_u240.setBadgeShowing(z);
                    destination$iv$iv.add($this$initMyMenuButtons_u24lambda_u240_u240);
                    line = line2;
                    initButtonWithType = view2;
                    initButtonWithType2 = view;
                }
            } else {
                view = initButtonWithType2;
            }
            z = true;
            $this$initMyMenuButtons_u24lambda_u240_u240.setBadgeShowing(z);
            destination$iv$iv.add($this$initMyMenuButtons_u24lambda_u240_u240);
            line = line2;
            initButtonWithType = view2;
            initButtonWithType2 = view;
        }
        setUseMenusData((List) destination$iv$iv);
        ComposeView $this$initMyMenuButtons_u24lambda_u241 = new ComposeView(this.context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        $this$initMyMenuButtons_u24lambda_u241.setContent(ComposableLambdaKt.composableLambdaInstance(-1065204033, true, new Function2() { // from class: tv.danmaku.bili.ui.garb.nft.DLCCardBotttomMenuList$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit initMyMenuButtons$lambda$1$0;
                initMyMenuButtons$lambda$1$0 = DLCCardBotttomMenuList.initMyMenuButtons$lambda$1$0(DLCCardBotttomMenuList.this, (Composer) obj, ((Integer) obj2).intValue());
                return initMyMenuButtons$lambda$1$0;
            }
        }));
        root.addView((View) $this$initMyMenuButtons_u24lambda_u241);
        root.addView(space);
        root.addView((View) cancelButton);
        root.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initMyMenuButtons$lambda$1$0(final DLCCardBotttomMenuList this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C131@4856L151,131@4846L161:DLCCardBotttomMenuList.kt#ur528d");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1065204033, $changed, -1, "tv.danmaku.bili.ui.garb.nft.DLCCardBotttomMenuList.initMyMenuButtons.<anonymous>.<anonymous> (DLCCardBotttomMenuList.kt:131)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-614051321, true, new Function2() { // from class: tv.danmaku.bili.ui.garb.nft.DLCCardBotttomMenuList$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit initMyMenuButtons$lambda$1$0$0;
                    initMyMenuButtons$lambda$1$0$0 = DLCCardBotttomMenuList.initMyMenuButtons$lambda$1$0$0(DLCCardBotttomMenuList.this, (Composer) obj, ((Integer) obj2).intValue());
                    return initMyMenuButtons$lambda$1$0$0;
                }
            }, $composer, 54), $composer, (int) BR.negativeBtnVisible, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initMyMenuButtons$lambda$1$0$0(DLCCardBotttomMenuList this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C132@4882L36,133@4976L9:DLCCardBotttomMenuList.kt#ur528d");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-614051321, $changed, -1, "tv.danmaku.bili.ui.garb.nft.DLCCardBotttomMenuList.initMyMenuButtons.<anonymous>.<anonymous>.<anonymous> (DLCCardBotttomMenuList.kt:132)");
            }
            this$0.UseMenuList(this$0.getUseMenusData(), $composer, 0);
            this$0.splashSettingNoticeDialogService.Content($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private final View initLine(ViewGroup root) {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.bili_app_digital_detail_bottom_memu_line, root, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    private final View initSpace(ViewGroup root) {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.bili_app_digital_detail_bottom_menu_space, root, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* JADX WARN: Code restructure failed: missing block: B:163:0x0253, code lost:
        if (tv.danmaku.bili.ui.garb.nft.util.DLCConstUtilKt.hasHeaderImgUrl(r9) == true) goto L141;
     */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void refreshButton() {
        Iterable emptyList;
        BottomMenuButtonCallback bottomMenuButtonCallback;
        Pair<CardRightShow, CardRight> limitInfo;
        CardRightShow cardRightShow;
        CardRight cardRight;
        CardRightShow cardRightShow2;
        CardRightShow cardRightShow3;
        CardRightShow cardRightShow4;
        CardRight cardRight2;
        CardRightShow cardRightShow5;
        CardRightShow cardRightShow6;
        CardRightShow cardRightShow7;
        CardRightShow cardRightShow8;
        if (this.mIsMe) {
            BottomMenuButtonCallback bottomMenuButtonCallback2 = this.callback;
            if (bottomMenuButtonCallback2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                bottomMenuButtonCallback2 = null;
            }
            Pair<CardRightShow, CardRight> limitInfo2 = bottomMenuButtonCallback2.getLimitInfo();
            if (limitInfo2 == null || (cardRightShow8 = (CardRightShow) limitInfo2.getFirst()) == null || (emptyList = cardRightShow8.getUseMenus()) == null) {
                emptyList = CollectionsKt.emptyList();
            }
            Iterable $this$map$iv = emptyList;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                UseMenuVM $this$refreshButton_u24lambda_u240_u240 = new UseMenuVM((UseMenu) item$iv$iv);
                $this$refreshButton_u24lambda_u240_u240.setBadgeShowing(($this$refreshButton_u24lambda_u240_u240.getData().getJumpType() == UseMenu.Type.AppWidget && Xpref.getDefaultSharedPreferences(this.context).getBoolean("app_widget_enter_badge_showed", false)) ? false : true);
                destination$iv$iv.add($this$refreshButton_u24lambda_u240_u240);
            }
            setUseMenusData((List) destination$iv$iv);
            int textColor = Color.parseColor("#FFFFFF");
            ViewGroup viewGroup = this.mRootView;
            LinearLayoutCompat setAvatar = viewGroup != null ? (LinearLayoutCompat) viewGroup.findViewWithTag(DLCCardBottomButtonType.CHANGE_AVATAR) : null;
            ViewGroup viewGroup2 = this.mRootView;
            LinearLayoutCompat setHeader = viewGroup2 != null ? (LinearLayoutCompat) viewGroup2.findViewWithTag(DLCCardBottomButtonType.CHANGE_HEADER) : null;
            TextView setAvatarTitle = setAvatar != null ? (TextView) setAvatar.findViewById(R.id.nft_detail_menu_item_limited_title) : null;
            BiliImageView setAvatarTag = setAvatar != null ? (BiliImageView) setAvatar.findViewById(R.id.nft_detail_menu_item_limited_tag) : null;
            TextView setHeaderTitle = setHeader != null ? (TextView) setHeader.findViewById(R.id.nft_detail_menu_item_limited_title) : null;
            BiliImageView setHeaderTag = setHeader != null ? (BiliImageView) setHeader.findViewById(R.id.nft_detail_menu_item_limited_tag) : null;
            BottomMenuButtonCallback bottomMenuButtonCallback3 = this.callback;
            if (bottomMenuButtonCallback3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                bottomMenuButtonCallback3 = null;
            }
            Pair<CardRightShow, CardRight> limitInfo3 = bottomMenuButtonCallback3.getLimitInfo();
            if ((limitInfo3 == null || (cardRightShow7 = (CardRightShow) limitInfo3.getFirst()) == null || !DLCConstUtilKt.isAvatarInvalid(cardRightShow7)) ? false : true) {
                if (setAvatarTitle != null) {
                    setAvatarTitle.setTextColor(this.context.getResources().getColor(R.color.bili_app_nft_limit_time_text_color));
                }
            } else if (setAvatarTitle != null) {
                setAvatarTitle.setTextColor(textColor);
            }
            BottomMenuButtonCallback bottomMenuButtonCallback4 = this.callback;
            if (bottomMenuButtonCallback4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                bottomMenuButtonCallback4 = null;
            }
            Pair<CardRightShow, CardRight> limitInfo4 = bottomMenuButtonCallback4.getLimitInfo();
            if ((limitInfo4 == null || (cardRightShow6 = (CardRightShow) limitInfo4.getFirst()) == null || !DLCConstUtilKt.isHeaderInvalid(cardRightShow6)) ? false : true) {
                if (setHeaderTitle != null) {
                    setHeaderTitle.setTextColor(this.context.getResources().getColor(R.color.bili_app_nft_limit_time_text_color));
                }
            } else if (setHeaderTitle != null) {
                setHeaderTitle.setTextColor(textColor);
            }
            BottomMenuButtonCallback bottomMenuButtonCallback5 = this.callback;
            if (bottomMenuButtonCallback5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                bottomMenuButtonCallback5 = null;
            }
            Pair<CardRightShow, CardRight> limitInfo5 = bottomMenuButtonCallback5.getLimitInfo();
            if ((limitInfo5 == null || (cardRightShow5 = (CardRightShow) limitInfo5.getFirst()) == null || !DLCConstUtilKt.isAvatarValid(cardRightShow5)) ? false : true) {
                BottomMenuButtonCallback bottomMenuButtonCallback6 = this.callback;
                if (bottomMenuButtonCallback6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                    bottomMenuButtonCallback6 = null;
                }
                Pair<CardRightShow, CardRight> limitInfo6 = bottomMenuButtonCallback6.getLimitInfo();
                if ((limitInfo6 == null || (cardRight2 = (CardRight) limitInfo6.getSecond()) == null || !DLCConstUtilKt.isLimitedAvatar(cardRight2)) ? false : true) {
                    BottomMenuButtonCallback bottomMenuButtonCallback7 = this.callback;
                    if (bottomMenuButtonCallback7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                        bottomMenuButtonCallback7 = null;
                    }
                    Pair<CardRightShow, CardRight> limitInfo7 = bottomMenuButtonCallback7.getLimitInfo();
                    if ((limitInfo7 == null || (cardRightShow4 = (CardRightShow) limitInfo7.getFirst()) == null || !DLCConstUtilKt.hasAvatarImgUrl(cardRightShow4)) ? false : true) {
                        if (setAvatarTag != null) {
                            BiliImageView it = setAvatarTag;
                            ImageRequestBuilder with = BiliImageLoader.INSTANCE.with(this.context);
                            BottomMenuButtonCallback bottomMenuButtonCallback8 = this.callback;
                            if (bottomMenuButtonCallback8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                                bottomMenuButtonCallback8 = null;
                            }
                            Pair<CardRightShow, CardRight> limitInfo8 = bottomMenuButtonCallback8.getLimitInfo();
                            with.url((limitInfo8 == null || (cardRightShow3 = (CardRightShow) limitInfo8.getFirst()) == null) ? null : cardRightShow3.getHeadTagUrl()).into(it);
                            it.setVisibility(0);
                        }
                        bottomMenuButtonCallback = this.callback;
                        if (bottomMenuButtonCallback == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                            bottomMenuButtonCallback = null;
                        }
                        limitInfo = bottomMenuButtonCallback.getLimitInfo();
                        if (limitInfo == null && (cardRightShow2 = (CardRightShow) limitInfo.getFirst()) != null && DLCConstUtilKt.isHeaderValid(cardRightShow2)) {
                            BottomMenuButtonCallback bottomMenuButtonCallback9 = this.callback;
                            if (bottomMenuButtonCallback9 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                                bottomMenuButtonCallback9 = null;
                            }
                            Pair<CardRightShow, CardRight> limitInfo9 = bottomMenuButtonCallback9.getLimitInfo();
                            if ((limitInfo9 == null || (cardRight = (CardRight) limitInfo9.getSecond()) == null || !DLCConstUtilKt.isLimitedHeader(cardRight)) ? false : true) {
                                BottomMenuButtonCallback bottomMenuButtonCallback10 = this.callback;
                                if (bottomMenuButtonCallback10 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                                    bottomMenuButtonCallback10 = null;
                                }
                                Pair<CardRightShow, CardRight> limitInfo10 = bottomMenuButtonCallback10.getLimitInfo();
                                boolean z = (limitInfo10 == null || (r9 = (CardRightShow) limitInfo10.getFirst()) == null) ? false : true;
                                if (z) {
                                    if (setHeaderTag != null) {
                                        BiliImageView it2 = setHeaderTag;
                                        ImageRequestBuilder with2 = BiliImageLoader.INSTANCE.with(this.context);
                                        BottomMenuButtonCallback bottomMenuButtonCallback11 = this.callback;
                                        if (bottomMenuButtonCallback11 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                                            bottomMenuButtonCallback11 = null;
                                        }
                                        Pair<CardRightShow, CardRight> limitInfo11 = bottomMenuButtonCallback11.getLimitInfo();
                                        with2.url((limitInfo11 == null || (cardRightShow = (CardRightShow) limitInfo11.getFirst()) == null) ? null : cardRightShow.getBannerTagUrl()).into(it2);
                                        it2.setVisibility(0);
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                        if (setHeaderTag == null) {
                            setHeaderTag.setVisibility(8);
                            return;
                        }
                        return;
                    }
                }
            }
            if (setAvatarTag != null) {
                setAvatarTag.setVisibility(8);
            }
            bottomMenuButtonCallback = this.callback;
            if (bottomMenuButtonCallback == null) {
            }
            limitInfo = bottomMenuButtonCallback.getLimitInfo();
            if (limitInfo == null && (cardRightShow2 = (CardRightShow) limitInfo.getFirst()) != null && DLCConstUtilKt.isHeaderValid(cardRightShow2)) {
            }
            if (setHeaderTag == null) {
            }
        }
    }

    private final LinearLayoutCompat initBottomButtonWithType(int textColor) {
        LinearLayoutCompat inflate = LayoutInflater.from(this.context).inflate(R.layout.bili_app_dialog_digital_bottom_menu_cancel, (ViewGroup) null, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat");
        LinearLayoutCompat root = inflate;
        TextView button = (TextView) root.findViewById(R.id.nft_detail_menu_item_limited_title);
        button.setTextColor(textColor);
        button.setText("取消");
        root.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.nft.DLCCardBotttomMenuList$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DLCCardBotttomMenuList.initBottomButtonWithType$lambda$0(DLCCardBotttomMenuList.this, view);
            }
        });
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBottomButtonWithType$lambda$0(DLCCardBotttomMenuList this$0, View it) {
        ViewGroup viewGroup = this$0.mRootView;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        BottomMenuButtonCallback bottomMenuButtonCallback = this$0.callback;
        if (bottomMenuButtonCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            bottomMenuButtonCallback = null;
        }
        bottomMenuButtonCallback.dismissMenu();
    }

    private final LinearLayoutCompat initButtonWithType(DLCCardBottomButtonType type, int textColor) {
        String str;
        CardRightShow cardRightShow;
        CardRightShow cardRightShow2;
        CardRight cardRight;
        CardRightShow cardRightShow3;
        CardRightShow cardRightShow4;
        CardRightShow cardRightShow5;
        CardRightShow cardRightShow6;
        CardRight cardRight2;
        CardRightShow cardRightShow7;
        CardRightShow cardRightShow8;
        String str2 = null;
        LinearLayoutCompat inflate = LayoutInflater.from(this.context).inflate(R.layout.bili_app_dialog_digital_bottom_menu_item, (ViewGroup) null, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat");
        LinearLayoutCompat root = inflate;
        root.setTag(type);
        TextView button = (TextView) root.findViewById(R.id.nft_detail_menu_item_limited_title);
        BiliImageView setTag = root.findViewById(R.id.nft_detail_menu_item_limited_tag);
        button.setTextColor(textColor);
        boolean z = true;
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                BottomMenuButtonCallback bottomMenuButtonCallback = this.callback;
                if (bottomMenuButtonCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                    bottomMenuButtonCallback = null;
                }
                Pair<CardRightShow, CardRight> limitInfo = bottomMenuButtonCallback.getLimitInfo();
                if ((limitInfo == null || (cardRightShow4 = (CardRightShow) limitInfo.getFirst()) == null || !DLCConstUtilKt.isAvatarInvalid(cardRightShow4)) ? false : true) {
                    button.setTextColor(this.context.getResources().getColor(R.color.bili_app_nft_limit_time_text_color));
                } else {
                    button.setTextColor(textColor);
                }
                BottomMenuButtonCallback bottomMenuButtonCallback2 = this.callback;
                if (bottomMenuButtonCallback2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                    bottomMenuButtonCallback2 = null;
                }
                Pair<CardRightShow, CardRight> limitInfo2 = bottomMenuButtonCallback2.getLimitInfo();
                if ((limitInfo2 == null || (cardRightShow3 = (CardRightShow) limitInfo2.getFirst()) == null || !DLCConstUtilKt.isAvatarValid(cardRightShow3)) ? false : true) {
                    BottomMenuButtonCallback bottomMenuButtonCallback3 = this.callback;
                    if (bottomMenuButtonCallback3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                        bottomMenuButtonCallback3 = null;
                    }
                    Pair<CardRightShow, CardRight> limitInfo3 = bottomMenuButtonCallback3.getLimitInfo();
                    if ((limitInfo3 == null || (cardRight = (CardRight) limitInfo3.getSecond()) == null || !DLCConstUtilKt.isLimitedAvatar(cardRight)) ? false : true) {
                        BottomMenuButtonCallback bottomMenuButtonCallback4 = this.callback;
                        if (bottomMenuButtonCallback4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                            bottomMenuButtonCallback4 = null;
                        }
                        Pair<CardRightShow, CardRight> limitInfo4 = bottomMenuButtonCallback4.getLimitInfo();
                        if (limitInfo4 == null || (cardRightShow2 = (CardRightShow) limitInfo4.getFirst()) == null || !DLCConstUtilKt.hasAvatarImgUrl(cardRightShow2)) {
                            z = false;
                        }
                        if (z) {
                            if (setTag != null) {
                                ImageRequestBuilder with = BiliImageLoader.INSTANCE.with(this.context);
                                BottomMenuButtonCallback bottomMenuButtonCallback5 = this.callback;
                                if (bottomMenuButtonCallback5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                                    bottomMenuButtonCallback5 = null;
                                }
                                Pair<CardRightShow, CardRight> limitInfo5 = bottomMenuButtonCallback5.getLimitInfo();
                                if (limitInfo5 != null && (cardRightShow = (CardRightShow) limitInfo5.getFirst()) != null) {
                                    str2 = cardRightShow.getHeadTagUrl();
                                }
                                with.url(str2).into(setTag);
                                setTag.setVisibility(0);
                            }
                            root.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.nft.DLCCardBotttomMenuList$$ExternalSyntheticLambda4
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    DLCCardBotttomMenuList.initButtonWithType$lambda$1(DLCCardBotttomMenuList.this, view);
                                }
                            });
                            str = "设为头像";
                            break;
                        }
                    }
                }
                if (setTag != null) {
                    setTag.setVisibility(8);
                }
                root.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.nft.DLCCardBotttomMenuList$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DLCCardBotttomMenuList.initButtonWithType$lambda$1(DLCCardBotttomMenuList.this, view);
                    }
                });
                str = "设为头像";
                break;
            case 2:
                BottomMenuButtonCallback bottomMenuButtonCallback6 = this.callback;
                if (bottomMenuButtonCallback6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                    bottomMenuButtonCallback6 = null;
                }
                Pair<CardRightShow, CardRight> limitInfo6 = bottomMenuButtonCallback6.getLimitInfo();
                if ((limitInfo6 == null || (cardRightShow8 = (CardRightShow) limitInfo6.getFirst()) == null || !DLCConstUtilKt.isHeaderInvalid(cardRightShow8)) ? false : true) {
                    button.setTextColor(this.context.getResources().getColor(R.color.bili_app_nft_limit_time_text_color));
                } else {
                    button.setTextColor(textColor);
                }
                BottomMenuButtonCallback bottomMenuButtonCallback7 = this.callback;
                if (bottomMenuButtonCallback7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                    bottomMenuButtonCallback7 = null;
                }
                Pair<CardRightShow, CardRight> limitInfo7 = bottomMenuButtonCallback7.getLimitInfo();
                if ((limitInfo7 == null || (cardRightShow7 = (CardRightShow) limitInfo7.getFirst()) == null || !DLCConstUtilKt.isHeaderValid(cardRightShow7)) ? false : true) {
                    BottomMenuButtonCallback bottomMenuButtonCallback8 = this.callback;
                    if (bottomMenuButtonCallback8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                        bottomMenuButtonCallback8 = null;
                    }
                    Pair<CardRightShow, CardRight> limitInfo8 = bottomMenuButtonCallback8.getLimitInfo();
                    if ((limitInfo8 == null || (cardRight2 = (CardRight) limitInfo8.getSecond()) == null || !DLCConstUtilKt.isLimitedHeader(cardRight2)) ? false : true) {
                        BottomMenuButtonCallback bottomMenuButtonCallback9 = this.callback;
                        if (bottomMenuButtonCallback9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                            bottomMenuButtonCallback9 = null;
                        }
                        Pair<CardRightShow, CardRight> limitInfo9 = bottomMenuButtonCallback9.getLimitInfo();
                        if (limitInfo9 == null || (cardRightShow6 = (CardRightShow) limitInfo9.getFirst()) == null || !DLCConstUtilKt.hasHeaderImgUrl(cardRightShow6)) {
                            z = false;
                        }
                        if (z) {
                            if (setTag != null) {
                                ImageRequestBuilder with2 = BiliImageLoader.INSTANCE.with(this.context);
                                BottomMenuButtonCallback bottomMenuButtonCallback10 = this.callback;
                                if (bottomMenuButtonCallback10 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                                    bottomMenuButtonCallback10 = null;
                                }
                                Pair<CardRightShow, CardRight> limitInfo10 = bottomMenuButtonCallback10.getLimitInfo();
                                if (limitInfo10 != null && (cardRightShow5 = (CardRightShow) limitInfo10.getFirst()) != null) {
                                    str2 = cardRightShow5.getBannerTagUrl();
                                }
                                with2.url(str2).into(setTag);
                                setTag.setVisibility(0);
                            }
                            root.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.nft.DLCCardBotttomMenuList$$ExternalSyntheticLambda5
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    DLCCardBotttomMenuList.initButtonWithType$lambda$3(DLCCardBotttomMenuList.this, view);
                                }
                            });
                            str = "设为头图";
                            break;
                        }
                    }
                }
                if (setTag != null) {
                    setTag.setVisibility(8);
                }
                root.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.nft.DLCCardBotttomMenuList$$ExternalSyntheticLambda5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DLCCardBotttomMenuList.initButtonWithType$lambda$3(DLCCardBotttomMenuList.this, view);
                    }
                });
                str = "设为头图";
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        button.setText(str);
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initButtonWithType$lambda$1(final DLCCardBotttomMenuList this$0, View it) {
        CardRightShow cardRightShow;
        String it2;
        CardRight cardRight;
        CardRightShow cardRightShow2;
        CardRightShow cardRightShow3;
        CardRightShow cardRightShow4;
        BottomMenuButtonCallback bottomMenuButtonCallback = this$0.callback;
        BottomMenuButtonCallback bottomMenuButtonCallback2 = null;
        r2 = null;
        String str = null;
        if (bottomMenuButtonCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            bottomMenuButtonCallback = null;
        }
        Pair<CardRightShow, CardRight> limitInfo = bottomMenuButtonCallback.getLimitInfo();
        boolean z = true;
        if (((limitInfo == null || (cardRightShow4 = (CardRightShow) limitInfo.getFirst()) == null || !DLCConstUtilKt.isAvatarInvalid(cardRightShow4)) ? null : 1) != null) {
            BottomMenuButtonCallback bottomMenuButtonCallback3 = this$0.callback;
            if (bottomMenuButtonCallback3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                bottomMenuButtonCallback3 = null;
            }
            Pair<CardRightShow, CardRight> limitInfo2 = bottomMenuButtonCallback3.getLimitInfo();
            if (limitInfo2 != null && (cardRightShow3 = (CardRightShow) limitInfo2.getFirst()) != null) {
                str = cardRightShow3.getHeadPicToast();
            }
            String toast = str;
            if (!TextUtils.isEmpty(toast)) {
                ToastHelper.showToast(this$0.context, toast, 0);
                return;
            }
            return;
        }
        BottomMenuButtonCallback bottomMenuButtonCallback4 = this$0.callback;
        if (bottomMenuButtonCallback4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            bottomMenuButtonCallback4 = null;
        }
        Pair<CardRightShow, CardRight> limitInfo3 = bottomMenuButtonCallback4.getLimitInfo();
        if (((limitInfo3 == null || (cardRightShow2 = (CardRightShow) limitInfo3.getFirst()) == null || !DLCConstUtilKt.isAvatarValid(cardRightShow2)) ? null : 1) != null) {
            BottomMenuButtonCallback bottomMenuButtonCallback5 = this$0.callback;
            if (bottomMenuButtonCallback5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                bottomMenuButtonCallback5 = null;
            }
            Pair<CardRightShow, CardRight> limitInfo4 = bottomMenuButtonCallback5.getLimitInfo();
            if (limitInfo4 == null || (cardRight = (CardRight) limitInfo4.getSecond()) == null || !DLCConstUtilKt.isLimitedAvatar(cardRight)) {
                z = false;
            }
            if (z) {
                BottomMenuButtonCallback bottomMenuButtonCallback6 = this$0.callback;
                if (bottomMenuButtonCallback6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                    bottomMenuButtonCallback6 = null;
                }
                Pair<CardRightShow, CardRight> limitInfo5 = bottomMenuButtonCallback6.getLimitInfo();
                if (limitInfo5 != null && (cardRightShow = (CardRightShow) limitInfo5.getFirst()) != null && (it2 = cardRightShow.getHeadExpireFormat()) != null) {
                    Activity activity = this$0.context;
                    if (activity != null) {
                        NftCardMenuLimitedDialog.Companion.show(activity, "该数字周边可限时作为头像", it2, new Function0() { // from class: tv.danmaku.bili.ui.garb.nft.DLCCardBotttomMenuList$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                Unit initButtonWithType$lambda$1$0$0$0;
                                initButtonWithType$lambda$1$0$0$0 = DLCCardBotttomMenuList.initButtonWithType$lambda$1$0$0$0(DLCCardBotttomMenuList.this);
                                return initButtonWithType$lambda$1$0$0$0;
                            }
                        });
                        return;
                    }
                    return;
                }
            }
        }
        BottomMenuButtonCallback bottomMenuButtonCallback7 = this$0.callback;
        if (bottomMenuButtonCallback7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            bottomMenuButtonCallback7 = null;
        }
        bottomMenuButtonCallback7.setAvatar();
        BottomMenuButtonCallback bottomMenuButtonCallback8 = this$0.callback;
        if (bottomMenuButtonCallback8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
        } else {
            bottomMenuButtonCallback2 = bottomMenuButtonCallback8;
        }
        bottomMenuButtonCallback2.dismissMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initButtonWithType$lambda$1$0$0$0(DLCCardBotttomMenuList this$0) {
        BottomMenuButtonCallback bottomMenuButtonCallback = this$0.callback;
        BottomMenuButtonCallback bottomMenuButtonCallback2 = null;
        if (bottomMenuButtonCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            bottomMenuButtonCallback = null;
        }
        bottomMenuButtonCallback.setAvatar();
        BottomMenuButtonCallback bottomMenuButtonCallback3 = this$0.callback;
        if (bottomMenuButtonCallback3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
        } else {
            bottomMenuButtonCallback2 = bottomMenuButtonCallback3;
        }
        bottomMenuButtonCallback2.dismissMenu();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initButtonWithType$lambda$3(final DLCCardBotttomMenuList this$0, View it) {
        CardRightShow cardRightShow;
        String it2;
        CardRight cardRight;
        CardRightShow cardRightShow2;
        CardRightShow cardRightShow3;
        CardRightShow cardRightShow4;
        BottomMenuButtonCallback bottomMenuButtonCallback = this$0.callback;
        BottomMenuButtonCallback bottomMenuButtonCallback2 = null;
        r2 = null;
        String str = null;
        if (bottomMenuButtonCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            bottomMenuButtonCallback = null;
        }
        Pair<CardRightShow, CardRight> limitInfo = bottomMenuButtonCallback.getLimitInfo();
        boolean z = true;
        if (((limitInfo == null || (cardRightShow4 = (CardRightShow) limitInfo.getFirst()) == null || !DLCConstUtilKt.isHeaderInvalid(cardRightShow4)) ? null : 1) != null) {
            BottomMenuButtonCallback bottomMenuButtonCallback3 = this$0.callback;
            if (bottomMenuButtonCallback3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                bottomMenuButtonCallback3 = null;
            }
            Pair<CardRightShow, CardRight> limitInfo2 = bottomMenuButtonCallback3.getLimitInfo();
            if (limitInfo2 != null && (cardRightShow3 = (CardRightShow) limitInfo2.getFirst()) != null) {
                str = cardRightShow3.getBannerBgToast();
            }
            String toast = str;
            if (!TextUtils.isEmpty(toast)) {
                ToastHelper.showToast(this$0.context, toast, 0);
                return;
            }
            return;
        }
        BottomMenuButtonCallback bottomMenuButtonCallback4 = this$0.callback;
        if (bottomMenuButtonCallback4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            bottomMenuButtonCallback4 = null;
        }
        Pair<CardRightShow, CardRight> limitInfo3 = bottomMenuButtonCallback4.getLimitInfo();
        if (((limitInfo3 == null || (cardRightShow2 = (CardRightShow) limitInfo3.getFirst()) == null || !DLCConstUtilKt.isHeaderValid(cardRightShow2)) ? null : 1) != null) {
            BottomMenuButtonCallback bottomMenuButtonCallback5 = this$0.callback;
            if (bottomMenuButtonCallback5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                bottomMenuButtonCallback5 = null;
            }
            Pair<CardRightShow, CardRight> limitInfo4 = bottomMenuButtonCallback5.getLimitInfo();
            if (limitInfo4 == null || (cardRight = (CardRight) limitInfo4.getSecond()) == null || !DLCConstUtilKt.isLimitedHeader(cardRight)) {
                z = false;
            }
            if (z) {
                BottomMenuButtonCallback bottomMenuButtonCallback6 = this$0.callback;
                if (bottomMenuButtonCallback6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                    bottomMenuButtonCallback6 = null;
                }
                Pair<CardRightShow, CardRight> limitInfo5 = bottomMenuButtonCallback6.getLimitInfo();
                if (limitInfo5 != null && (cardRightShow = (CardRightShow) limitInfo5.getFirst()) != null && (it2 = cardRightShow.getBannerExpireFormat()) != null) {
                    Activity activity = this$0.context;
                    if (activity != null) {
                        NftCardMenuLimitedDialog.Companion.show(activity, "该数字周边可限时作为空间头图", it2, new Function0() { // from class: tv.danmaku.bili.ui.garb.nft.DLCCardBotttomMenuList$$ExternalSyntheticLambda6
                            public final Object invoke() {
                                Unit initButtonWithType$lambda$3$0$0$0;
                                initButtonWithType$lambda$3$0$0$0 = DLCCardBotttomMenuList.initButtonWithType$lambda$3$0$0$0(DLCCardBotttomMenuList.this);
                                return initButtonWithType$lambda$3$0$0$0;
                            }
                        });
                        return;
                    }
                    return;
                }
            }
        }
        BottomMenuButtonCallback bottomMenuButtonCallback7 = this$0.callback;
        if (bottomMenuButtonCallback7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            bottomMenuButtonCallback7 = null;
        }
        bottomMenuButtonCallback7.setHeader();
        BottomMenuButtonCallback bottomMenuButtonCallback8 = this$0.callback;
        if (bottomMenuButtonCallback8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
        } else {
            bottomMenuButtonCallback2 = bottomMenuButtonCallback8;
        }
        bottomMenuButtonCallback2.dismissMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initButtonWithType$lambda$3$0$0$0(DLCCardBotttomMenuList this$0) {
        BottomMenuButtonCallback bottomMenuButtonCallback = this$0.callback;
        BottomMenuButtonCallback bottomMenuButtonCallback2 = null;
        if (bottomMenuButtonCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            bottomMenuButtonCallback = null;
        }
        bottomMenuButtonCallback.setHeader();
        BottomMenuButtonCallback bottomMenuButtonCallback3 = this$0.callback;
        if (bottomMenuButtonCallback3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
        } else {
            bottomMenuButtonCallback2 = bottomMenuButtonCallback3;
        }
        bottomMenuButtonCallback2.dismissMenu();
        return Unit.INSTANCE;
    }

    /* compiled from: DLCCardBotttomMenuList.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/DLCCardBotttomMenuList$Companion;", "", "<init>", "()V", "KEY_FROM_TYPE", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void UseMenuList(final List<UseMenuVM> list, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(list, "useMenus");
        Composer $composer3 = $composer.startRestartGroup(1732482653);
        ComposerKt.sourceInformation($composer3, "C(UseMenuList)N(useMenus)377@14661L7,384@14924L3448,378@14677L3695:DLCCardBotttomMenuList.kt#ur528d");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(this) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1732482653, $dirty2, -1, "tv.danmaku.bili.ui.garb.nft.DLCCardBotttomMenuList.UseMenuList (DLCCardBotttomMenuList.kt:376)");
            }
            CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Context context = (Context) consume;
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), androidx.compose.ui.graphics.Color.Companion.getBlack-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(20), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -1531466891, "CC(remember):DLCCardBotttomMenuList.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(list) | $composer3.changedInstance(this);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: tv.danmaku.bili.ui.garb.nft.DLCCardBotttomMenuList$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit UseMenuList$lambda$0$0;
                        UseMenuList$lambda$0$0 = DLCCardBotttomMenuList.UseMenuList$lambda$0$0(list, this, (LazyListScope) obj);
                        return UseMenuList$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            LazyDslKt.LazyColumn(modifier, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv, $composer3, 6, (int) BR.roleName);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.garb.nft.DLCCardBotttomMenuList$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit UseMenuList$lambda$1;
                    UseMenuList$lambda$1 = DLCCardBotttomMenuList.UseMenuList$lambda$1(DLCCardBotttomMenuList.this, list, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return UseMenuList$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UseMenuList$lambda$0$0(final List $useMenus, final DLCCardBotttomMenuList this$0, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        $this$LazyColumn.items($useMenus.size(), (Function1) null, new Function1<Integer, Object>() { // from class: tv.danmaku.bili.ui.garb.nft.DLCCardBotttomMenuList$UseMenuList$lambda$0$0$$inlined$itemsIndexed$default$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                $useMenus.get(index);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: tv.danmaku.bili.ui.garb.nft.DLCCardBotttomMenuList$UseMenuList$lambda$0$0$$inlined$itemsIndexed$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                Function0 factory$iv$iv$iv;
                Modifier modifier;
                long j;
                long j2;
                ComposerKt.sourceInformation($composer, "CN(it)214@10668L26:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if ($composer.shouldExecute(($dirty & BR.danmakuNumIcon) != 146, $dirty & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2039820996, $dirty, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                    }
                    Object obj = $useMenus.get(it);
                    int $changed2 = ($dirty & 14) | ($dirty & BR.containerVisible);
                    final DLCCardBotttomMenuList.UseMenuVM menuVm = (DLCCardBotttomMenuList.UseMenuVM) obj;
                    $composer.startReplaceGroup(215359011);
                    ComposerKt.sourceInformation($composer, "CN(index,menuVm)*387@15035L142,392@15195L3152:DLCCardBotttomMenuList.kt#ur528d");
                    UseMenu menu = menuVm.getData();
                    DividerKt.Divider-oMI9zvI((Modifier) null, ColorKt.Color(436207615), Dp.constructor-impl(0.5f), 0.0f, $composer, (int) BR.pendentVisible, 9);
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Modifier modifier$iv = Modifier.Companion;
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((BR.negativeBtnVisible >> 3) & 14) | ((BR.negativeBtnVisible >> 3) & BR.containerVisible));
                    int $changed$iv$iv = (BR.negativeBtnVisible << 3) & BR.containerVisible;
                    ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                    CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                    Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                        factory$iv$iv$iv = factory$iv$iv$iv2;
                        $composer.createNode(factory$iv$iv$iv);
                    } else {
                        factory$iv$iv$iv = factory$iv$iv$iv2;
                        $composer.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    int i = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    int i2 = ((BR.negativeBtnVisible >> 6) & BR.containerVisible) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, 1090417457, "C395@15308L816:DLCCardBotttomMenuList.kt#ur528d");
                    $composer.startReplaceGroup(1559198546);
                    ComposerKt.sourceInformation($composer, "");
                    Modifier $this$UseMenuList_u24lambda_u240_u240_u240_u240_u240 = PaddingKt.padding-VpY3zN4$default(SizeKt.wrapContentSize$default(Modifier.Companion, (Alignment) null, false, 3, (Object) null), 0.0f, Dp.constructor-impl(14), 1, (Object) null);
                    if (menu.getAvailable()) {
                        $composer.startReplaceGroup(-1325079260);
                        ComposerKt.sourceInformation($composer, "401@15595L113");
                        ComposerKt.sourceInformationMarkerStart($composer, -1843858356, "CC(remember):DLCCardBotttomMenuList.kt#9igjgp");
                        boolean invalid$iv = $composer.changedInstance(this$0) | (((($changed2 & 896) ^ BR.negativeBtnVisible) > 256 && $composer.changed(menuVm)) || ($changed2 & BR.negativeBtnVisible) == 256);
                        Object it$iv = $composer.rememberedValue();
                        if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            Modifier modifier2 = ClickableKt.clickable-oSLSa3U$default($this$UseMenuList_u24lambda_u240_u240_u240_u240_u240, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                            $composer.endReplaceGroup();
                            modifier = modifier2;
                        }
                        final DLCCardBotttomMenuList dLCCardBotttomMenuList = this$0;
                        Object value$iv = (Function0) new Function0<Unit>() { // from class: tv.danmaku.bili.ui.garb.nft.DLCCardBotttomMenuList$UseMenuList$1$1$1$1$1$1$1
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m1770invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m1770invoke() {
                                BottomMenuButtonCallback bottomMenuButtonCallback;
                                bottomMenuButtonCallback = DLCCardBotttomMenuList.this.callback;
                                if (bottomMenuButtonCallback == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                                    bottomMenuButtonCallback = null;
                                }
                                bottomMenuButtonCallback.onUsingMenuClick(menuVm);
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        Modifier modifier22 = ClickableKt.clickable-oSLSa3U$default($this$UseMenuList_u24lambda_u240_u240_u240_u240_u240, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                        $composer.endReplaceGroup();
                        modifier = modifier22;
                    } else {
                        $composer.startReplaceGroup(-1324883557);
                        $composer.endReplaceGroup();
                        modifier = $this$UseMenuList_u24lambda_u240_u240_u240_u240_u240;
                    }
                    $composer.endReplaceGroup();
                    TextKt.Text--4IGK_g(menu.getTitle(), modifier, menu.getAvailable() ? ColorKt.Color(4294967295L) : androidx.compose.ui.graphics.Color.copy-wmQWz5c$default(ColorKt.Color(4294967295L), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), TextUnitKt.getSp(15), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 3072, 0, 131056);
                    String tips = menu.getTips();
                    if ((tips == null || StringsKt.isBlank(tips)) || !menuVm.getBadgeShowing()) {
                        $composer.startReplaceGroup(1075137277);
                    } else {
                        $composer.startReplaceGroup(1091276590);
                        ComposerKt.sourceInformation($composer, "");
                        if (menu.getJumpType() == UseMenu.Type.AppWidget) {
                            $composer.startReplaceGroup(1091336544);
                            ComposerKt.sourceInformation($composer, "418@16401L9,416@16295L1085");
                            String tips2 = menu.getTips();
                            TextStyle t10 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT10();
                            if (menu.getAvailable()) {
                                j2 = androidx.compose.ui.graphics.Color.Companion.getBlack-0d7_KjU();
                            } else {
                                j2 = androidx.compose.ui.graphics.Color.copy-wmQWz5c$default(androidx.compose.ui.graphics.Color.Companion.getBlack-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                            }
                            TextKt.Text--4IGK_g(tips2, PaddingKt.padding-VpY3zN4(BackgroundKt.background$default(SizeKt.wrapContentSize$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(10), 0.0f, 0.0f, 0.0f, 14, (Object) null), (Alignment) null, false, 3, (Object) null), Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, CollectionsKt.listOf(new androidx.compose.ui.graphics.Color[]{androidx.compose.ui.graphics.Color.box-impl(androidx.compose.ui.graphics.Color.Companion.getWhite-0d7_KjU()), androidx.compose.ui.graphics.Color.box-impl(ColorKt.Color(4294964413L))}), 0L, 0L, 0, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2)), 0.0f, 4, (Object) null), Dp.constructor-impl(3), Dp.constructor-impl(1)), j2, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t10, $composer, 0, 0, 65528);
                            $composer.endReplaceGroup();
                        } else {
                            $composer.startReplaceGroup(1092467672);
                            ComposerKt.sourceInformation($composer, "438@17549L9,446@18039L6,436@17443L837");
                            String tips3 = menu.getTips();
                            TextStyle t102 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT10();
                            if (menu.getAvailable()) {
                                $composer.startReplaceGroup(1559268207);
                                ComposerKt.sourceInformation($composer, "440@17670L6");
                                long j3 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_white-0d7_KjU();
                                $composer.endReplaceGroup();
                                j = j3;
                            } else {
                                $composer.startReplaceGroup(1559270639);
                                ComposerKt.sourceInformation($composer, "441@17735L6");
                                long j4 = androidx.compose.ui.graphics.Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_white-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                                $composer.endReplaceGroup();
                                j = j4;
                            }
                            TextKt.Text--4IGK_g(tips3, PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(SizeKt.wrapContentSize$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(10), 0.0f, 0.0f, 0.0f, 14, (Object) null), (Alignment) null, false, 3, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Dp.constructor-impl(5), Dp.constructor-impl(1)), j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t102, $composer, 0, 0, 65528);
                            $composer.endReplaceGroup();
                        }
                    }
                    $composer.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer.skipToGroupEnd();
            }
        }));
        return Unit.INSTANCE;
    }
}