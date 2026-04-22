package kntr.app.digital.preview.share;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.ogv.bdesign.placeholder.TvLoadingKt;
import java.util.List;
import javax.inject.Inject;
import kntr.app.digital.preview.BusinessCoroutineScope;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.DialogScope;
import kntr.app.digital.preview.DialogService;
import kntr.app.digital.preview.card.DigitalItemContainerKt;
import kntr.app.digital.preview.card.image.ImageModuleKt;
import kntr.app.digital.preview.share.ShareDialogService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImageState;
import kntr.common.share.common.MarkPointContent;
import kntr.common.share.common.ShareBiliContent;
import kntr.common.share.common.ShareContent;
import kntr.common.share.common.ShareDynamicContent;
import kntr.common.share.common.ShareIMContent;
import kntr.common.share.common.ShareImage;
import kntr.common.share.common.ShareMiniProgramContent;
import kntr.common.share.common.ShareMode;
import kntr.common.share.common.ShareParams;
import kntr.common.share.common.ShareTarget;
import kntr.common.share.common.ui.ShareMenuVM;
import kntr.common.share.common.ui.ShareMenuViewKt;
import kntr.common.share.common.ui.ShareMenuViewStyle;
import kntr.common.share.domain.ShareDomainApi;
import kntr.common.share.domain.model.ShareSession;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.digital.preview.generated.resources.Drawable0_commonMainKt;
import srcs.app.digital.preview.generated.resources.Res;

/* compiled from: ShareDialogService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0001\u0018\u00002\u00020\u0001:\u0001\u001eB#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J+\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u001cH\u0003¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001f²\u0006\n\u0010 \u001a\u00020!X\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020!X\u008a\u008e\u0002"}, d2 = {"Lkntr/app/digital/preview/share/ShareDialogService;", RoomRecommendViewModel.EMPTY_CURSOR, "toaster", "Lkntr/common/trio/toast/Toaster;", "dialogService", "Lkntr/app/digital/preview/DialogService;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkntr/common/trio/toast/Toaster;Lkntr/app/digital/preview/DialogService;Lkotlinx/coroutines/CoroutineScope;)V", "<set-?>", "Landroidx/compose/ui/graphics/ImageBitmap;", "image", "getImage", "()Landroidx/compose/ui/graphics/ImageBitmap;", "setImage", "(Landroidx/compose/ui/graphics/ImageBitmap;)V", "image$delegate", "Landroidx/compose/runtime/MutableState;", "keepShowing", RoomRecommendViewModel.EMPTY_CURSOR, "shareInfo", "Lkntr/app/digital/preview/share/ShareDialogService$ShareInfo;", "(Lkntr/app/digital/preview/share/ShareDialogService$ShareInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Content", "viewModel", "Lkntr/common/share/common/ui/ShareMenuVM;", "onDismissRequest", "Lkotlin/Function0;", "(Lkntr/common/share/common/ui/ShareMenuVM;Lkntr/app/digital/preview/share/ShareDialogService$ShareInfo;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ShareInfo", "preview_debug", "cardImageLoadSuccess", RoomRecommendViewModel.EMPTY_CURSOR, "imageUiDrawn"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ShareDialogService {
    public static final int $stable = 8;
    private final CoroutineScope coroutineScope;
    private final DialogService dialogService;
    private final MutableState image$delegate;
    private final Toaster toaster;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$8(ShareDialogService shareDialogService, ShareMenuVM shareMenuVM, ShareInfo shareInfo, Function0 function0, int i, Composer composer, int i2) {
        shareDialogService.Content(shareMenuVM, shareInfo, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    @Inject
    public ShareDialogService(Toaster toaster, DialogService dialogService, @BusinessCoroutineScope CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(toaster, "toaster");
        Intrinsics.checkNotNullParameter(dialogService, "dialogService");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.toaster = toaster;
        this.dialogService = dialogService;
        this.coroutineScope = coroutineScope;
        this.image$delegate = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* compiled from: ShareDialogService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\u0016"}, d2 = {"Lkntr/app/digital/preview/share/ShareDialogService$ShareInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "uniqueId", RoomRecommendViewModel.EMPTY_CURSOR, "frameImg", "leftTopTagImg", "image", "cardName", "detail", "avatar", "shareUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUniqueId", "()Ljava/lang/String;", "getFrameImg", "getLeftTopTagImg", "getImage", "getCardName", "getDetail", "getAvatar", "getShareUrl", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ShareInfo {
        public static final int $stable = 0;
        private final String avatar;
        private final String cardName;
        private final String detail;
        private final String frameImg;
        private final String image;
        private final String leftTopTagImg;
        private final String shareUrl;
        private final String uniqueId;

        public ShareInfo(String uniqueId, String frameImg, String leftTopTagImg, String image, String cardName, String detail, String avatar, String shareUrl) {
            Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
            Intrinsics.checkNotNullParameter(image, "image");
            Intrinsics.checkNotNullParameter(cardName, "cardName");
            Intrinsics.checkNotNullParameter(detail, "detail");
            Intrinsics.checkNotNullParameter(avatar, "avatar");
            Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
            this.uniqueId = uniqueId;
            this.frameImg = frameImg;
            this.leftTopTagImg = leftTopTagImg;
            this.image = image;
            this.cardName = cardName;
            this.detail = detail;
            this.avatar = avatar;
            this.shareUrl = shareUrl;
        }

        public final String getUniqueId() {
            return this.uniqueId;
        }

        public final String getFrameImg() {
            return this.frameImg;
        }

        public final String getLeftTopTagImg() {
            return this.leftTopTagImg;
        }

        public final String getImage() {
            return this.image;
        }

        public final String getCardName() {
            return this.cardName;
        }

        public final String getDetail() {
            return this.detail;
        }

        public final String getAvatar() {
            return this.avatar;
        }

        public final String getShareUrl() {
            return this.shareUrl;
        }
    }

    public final ImageBitmap getImage() {
        State $this$getValue$iv = this.image$delegate;
        return (ImageBitmap) $this$getValue$iv.getValue();
    }

    public final void setImage(ImageBitmap imageBitmap) {
        MutableState $this$setValue$iv = this.image$delegate;
        $this$setValue$iv.setValue(imageBitmap);
    }

    public final Object keepShowing(final ShareInfo shareInfo, Continuation<? super Unit> continuation) {
        Object keepDialogShowing = this.dialogService.keepDialogShowing((Function3) ComposableLambdaKt.composableLambdaInstance(1684178681, true, new Function3() { // from class: kntr.app.digital.preview.share.ShareDialogService$$ExternalSyntheticLambda6
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit keepShowing$lambda$0;
                keepShowing$lambda$0 = ShareDialogService.keepShowing$lambda$0(ShareDialogService.ShareInfo.this, this, (DialogScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return keepShowing$lambda$0;
            }
        }), continuation);
        return keepDialogShowing == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? keepDialogShowing : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit keepShowing$lambda$0(final ShareInfo $shareInfo, final ShareDialogService this$0, final DialogScope $this$keepDialogShowing, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$keepDialogShowing, "$this$keepDialogShowing");
        ComposerKt.sourceInformation($composer, "C105@4536L1041,127@5618L107,131@5778L9,133@5849L429,144@6295L90:ShareDialogService.kt#q5u6yf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer.changed($this$keepDialogShowing) : $composer.changedInstance($this$keepDialogShowing) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1684178681, $dirty2, -1, "kntr.app.digital.preview.share.ShareDialogService.keepShowing.<anonymous> (ShareDialogService.kt:92)");
            }
            final String content = "活动火热售卖中，快来开卡吧！\n " + $shareInfo.getShareUrl();
            ShareSession shareSession = new ShareSession(new ShareParams("sqzz.activity.bag.card-share.click", $shareInfo.getUniqueId(), RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, (ShareParams.PageInfo) null, (List) null, 48, (DefaultConstructorMarker) null), (String) null, (String) null, (String) null, 14, (DefaultConstructorMarker) null);
            CoroutineScope coroutineScope = this$0.coroutineScope;
            ComposerKt.sourceInformationMarkerStart($composer, -706935510, "CC(remember):ShareDialogService.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(this$0) | $composer.changed($shareInfo) | $composer.changed(content);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.digital.preview.share.ShareDialogService$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        ShareContent keepShowing$lambda$0$0$0;
                        keepShowing$lambda$0$0$0 = ShareDialogService.keepShowing$lambda$0$0$0(ShareDialogService.this, $shareInfo, content, (ShareTarget) obj);
                        return keepShowing$lambda$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function1 function1 = (Function1) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -706901820, "CC(remember):ShareDialogService.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 14) == 4 || (($dirty2 & 8) != 0 && $composer.changedInstance($this$keepDialogShowing));
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.digital.preview.share.ShareDialogService$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        boolean keepShowing$lambda$0$1$0;
                        keepShowing$lambda$0$1$0 = ShareDialogService.keepShowing$lambda$0$1$0(DialogScope.this, (ShareTarget) obj);
                        return Boolean.valueOf(keepShowing$lambda$0$1$0);
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            Function1 function12 = (Function1) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -706896798, "CC(remember):ShareDialogService.kt#9igjgp");
            Object it$iv3 = $composer.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.app.digital.preview.share.ShareDialogService$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        boolean keepShowing$lambda$0$2$0;
                        keepShowing$lambda$0$2$0 = ShareDialogService.keepShowing$lambda$0$2$0((ShareTarget) obj);
                        return Boolean.valueOf(keepShowing$lambda$0$2$0);
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ShareMenuVM viewModel = new ShareMenuVM(shareSession, coroutineScope, (ShareDomainApi) null, (Function1) null, function1, function12, (Function1) it$iv3, 12, (DefaultConstructorMarker) null);
            CoroutineScope coroutineScope2 = this$0.coroutineScope;
            ComposerKt.sourceInformationMarkerStart($composer, -706894106, "CC(remember):ShareDialogService.kt#9igjgp");
            boolean invalid$iv3 = $composer.changedInstance(viewModel) | $composer.changedInstance(this$0);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv3 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = (Function2) new ShareDialogService$keepShowing$2$1$1(viewModel, this$0, null);
                $composer.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            BuildersKt.launch$default(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, (Function2) it$iv4, 3, (Object) null);
            this$0.Content(viewModel, $shareInfo, $this$keepDialogShowing.getOnDismissRequest(), $composer, ShareMenuVM.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShareContent keepShowing$lambda$0$0$0(ShareDialogService this$0, ShareInfo $shareInfo, String $content, ShareTarget shareTarget) {
        Intrinsics.checkNotNullParameter(shareTarget, "<unused var>");
        ShareMode shareMode = ShareMode.Image;
        ImageBitmap it = this$0.getImage();
        return new ShareContent(shareMode, $shareInfo.getCardName(), $content, (String) null, it != null ? new ShareImage.Raw(it) : null, (String) null, (String) null, (String) null, (ShareMiniProgramContent) null, (ShareIMContent) null, new ShareDynamicContent(new ShareBiliContent((String) null, $content, (String) null, (String) null, 2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 4077, (DefaultConstructorMarker) null), true, (String) null, (String) null, (String) null, (String) null, 60, (DefaultConstructorMarker) null), (MarkPointContent) null, 3048, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean keepShowing$lambda$0$1$0(DialogScope $this_keepDialogShowing, ShareTarget it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $this_keepDialogShowing.getOnDismissRequest().invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean keepShowing$lambda$0$2$0(ShareTarget it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return false;
    }

    private final void Content(final ShareMenuVM viewModel, final ShareInfo shareInfo, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1130546296);
        ComposerKt.sourceInformation($composer2, "C(Content)N(viewModel,shareInfo,onDismissRequest)154@6616L23,155@6680L34,156@6747L34,158@6821L152,158@6795L178,170@7264L8702,163@6987L8979:ShareDialogService.kt#q5u6yf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(viewModel) : $composer2.changedInstance(viewModel) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(shareInfo) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(this) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1130546296, $dirty2, -1, "kntr.app.digital.preview.share.ShareDialogService.Content (ShareDialogService.kt:153)");
            }
            final GraphicsLayer graphicsLayer = GraphicsLayerScopeKt.rememberGraphicsLayer($composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, -171727942, "CC(remember):ShareDialogService.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState cardImageLoadSuccess$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -171725798, "CC(remember):ShareDialogService.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableState imageUiDrawn$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -171723312, "CC(remember):ShareDialogService.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(this) | $composer2.changedInstance(graphicsLayer);
            Object value$iv3 = $composer2.rememberedValue();
            if (invalid$iv || value$iv3 == Composer.Companion.getEmpty()) {
                value$iv3 = new ShareDialogService$Content$1$1(this, graphicsLayer, cardImageLoadSuccess$delegate, imageUiDrawn$delegate, null);
                $composer2.updateRememberedValue(value$iv3);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(shareInfo, (Function2) value$iv3, $composer2, ($dirty2 >> 3) & 14);
            AndroidDialog_androidKt.Dialog(function0, new DialogProperties(false, false, false, 1, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(884492879, true, new Function2() { // from class: kntr.app.digital.preview.share.ShareDialogService$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$7;
                    Content$lambda$7 = ShareDialogService.Content$lambda$7(graphicsLayer, cardImageLoadSuccess$delegate, imageUiDrawn$delegate, shareInfo, this, viewModel, function0, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$7;
                }
            }, $composer2, 54), $composer2, (($dirty2 >> 6) & 14) | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.share.ShareDialogService$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$8;
                    Content$lambda$8 = ShareDialogService.Content$lambda$8(ShareDialogService.this, viewModel, shareInfo, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Content$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void Content$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Content$lambda$4(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void Content$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$7(final GraphicsLayer $graphicsLayer, final MutableState $cardImageLoadSuccess$delegate, final MutableState $imageUiDrawn$delegate, final ShareInfo $shareInfo, ShareDialogService this$0, ShareMenuVM $viewModel, Function0 $onDismissRequest, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Modifier drawModifier;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Function0 factory$iv$iv$iv6;
        Object value$iv;
        ComposerKt.sourceInformation($composer, "C171@7282L8670:ShareDialogService.kt#q5u6yf");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(884492879, $changed, -1, "kntr.app.digital.preview.share.ShareDialogService.Content.<anonymous> (ShareDialogService.kt:171)");
            }
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv7;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv7;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int i2 = ((6 >> 6) & 112) | 6;
            ColumnScope $this$Content_u24lambda_u247_u240 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 370104089, "C186@7947L5719,308@13688L38,310@13748L2186:ShareDialogService.kt#q5u6yf");
            if (!Content$lambda$1($cardImageLoadSuccess$delegate) || Content$lambda$4($imageUiDrawn$delegate)) {
                $composer.startReplaceGroup(370314237);
                $composer.endReplaceGroup();
                drawModifier = Modifier.Companion;
            } else {
                $composer.startReplaceGroup(369936316);
                ComposerKt.sourceInformation($composer, "176@7526L304");
                Modifier modifier = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart($composer, 566124437, "CC(remember):ShareDialogService.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($graphicsLayer);
                Object it$iv = $composer.rememberedValue();
                if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                    value$iv = it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    drawModifier = DrawModifierKt.drawWithContent(modifier, (Function1) value$iv);
                    $composer.endReplaceGroup();
                }
                value$iv = new Function1() { // from class: kntr.app.digital.preview.share.ShareDialogService$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj) {
                        Unit Content$lambda$7$0$0$0;
                        Content$lambda$7$0$0$0 = ShareDialogService.Content$lambda$7$0$0$0($graphicsLayer, $imageUiDrawn$delegate, (ContentDrawScope) obj);
                        return Content$lambda$7$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                ComposerKt.sourceInformationMarkerEnd($composer);
                drawModifier = DrawModifierKt.drawWithContent(modifier, (Function1) value$iv);
                $composer.endReplaceGroup();
            }
            Modifier modifier$iv2 = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(60), Dp.constructor-impl(56), Dp.constructor-impl(60), 0.0f, 8, (Object) null).then(drawModifier), 0.0f, 1, (Object) null), ColorKt.Color(4279900698L), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12))), Dp.constructor-impl(16));
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv8;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv8;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 338899770, "C206@8949L469,197@8478L940,220@9592L9,217@9443L293,224@9761L1436,256@11223L295,264@11544L2100:ShareDialogService.kt#q5u6yf");
            DigitalItemContainerKt.DigitalCardContainer($shareInfo.getFrameImg(), $shareInfo.getLeftTopTagImg(), AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(16), 7, (Object) null), 0.0f, 1, (Object) null), 0.6666667f, false, 2, (Object) null), false, ComposableLambdaKt.rememberComposableLambda(-381674116, true, new Function3() { // from class: kntr.app.digital.preview.share.ShareDialogService$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit Content$lambda$7$0$1$0;
                    Content$lambda$7$0$1$0 = ShareDialogService.Content$lambda$7$0$1$0(ShareDialogService.ShareInfo.this, $cardImageLoadSuccess$delegate, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return Content$lambda$7$0$1$0;
                }
            }, $composer, 54), $composer, 28032, 0);
            TextKt.Text-Nvy7gAk($shareInfo.getCardName(), (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16(), $composer, 384, 24960, 110586);
            Modifier modifier$iv3 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(3), 0.0f, 0.0f, 13, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv3 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv9;
                $composer.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv9;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i6 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1987330379, "C230@10036L779,250@11015L9,247@10845L326:ShareDialogService.kt#q5u6yf");
            String $this$asRequest_u24default$iv = $shareInfo.getAvatar();
            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
            Unit unit = Unit.INSTANCE;
            BiliImageKt.BiliImage(imageRequest.build(), ClipKt.clip(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(6), 0.0f, 11, (Object) null), Dp.constructor-impl(20)), RoundedCornerShapeKt.getCircleShape()), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, ComposableSingletons$ShareDialogServiceKt.INSTANCE.m988getLambda$1600729266$preview_debug(), $composer, 100663296, 252);
            TextKt.Text-Nvy7gAk($shareInfo.getDetail(), (Modifier) null, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), $composer, 384, 24960, 110586);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(18), 1, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl((float) 0.5d)), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), $composer, 6);
            Modifier modifier$iv4 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv4 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
            Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv10;
                $composer.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv10;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i8 = ((390 >> 6) & 112) | 6;
            RowScope $this$Content_u24lambda_u247_u240_u241_u242 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 926920508, "C269@11794L49,268@11745L277,273@12051L190,278@12270L727:ShareDialogService.kt#q5u6yf");
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIcon_share_bilibili(Res.drawable.INSTANCE), $composer, 0), (String) null, SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(60), Dp.constructor-impl(27)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 432, 120);
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$Content_u24lambda_u247_u240_u241_u242, PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(16), 1, (Object) null), 1.0f, false, 2, (Object) null), $composer, 0);
            Modifier modifier$iv5 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(12), 0.0f, 11, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv3 = Alignment.Companion.getStart();
            int $i$f$Column = ((6 >> 3) & 14) | ((6 >> 3) & 112);
            MeasurePolicy measurePolicy$iv5 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer, $i$f$Column);
            int $changed$iv$iv5 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv5 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer, modifier$iv5);
            Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv5 = factory$iv$iv$iv11;
                $composer.createNode(factory$iv$iv$iv5);
            } else {
                factory$iv$iv$iv5 = factory$iv$iv$iv11;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i10 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1547524080, "C284@12588L9,281@12416L220,289@12841L9,286@12669L298:ShareDialogService.kt#q5u6yf");
            TextKt.Text-Nvy7gAk("长按识别", (Modifier) null, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT10(), $composer, 390, 0, 131066);
            TextKt.Text-Nvy7gAk("开启活动", PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(10), 0.0f, 0.0f, 13, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT10(), $composer, 438, 0, 131064);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ImageBitmap it = Share_androidKt.getShare().getQrcodeImageBitmap($shareInfo.getShareUrl(), 450, 450);
            if (it == null) {
                $composer.startReplaceGroup(928404290);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(928404291);
                ComposerKt.sourceInformation($composer, "*299@13331L253");
                ImageKt.Image(new BitmapPainter(it, 0L, 0L, 6, (DefaultConstructorMarker) null), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(54)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, BitmapPainter.$stable | 432, 120);
                Unit unit2 = Unit.INSTANCE;
                $composer.endReplaceGroup();
                Unit unit3 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$Content_u24lambda_u247_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer, 0);
            Modifier modifier$iv6 = BackgroundKt.background-bw27NRU(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ColorKt.Color(4279900698L), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 0.0f, 12, (Object) null));
            Alignment.Horizontal horizontalAlignment$iv4 = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv4 = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv6 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv4, horizontalAlignment$iv4, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv6 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv6 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer, modifier$iv6);
            Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv6 = factory$iv$iv$iv12;
                $composer.createNode(factory$iv$iv$iv6);
            } else {
                factory$iv$iv$iv6 = factory$iv$iv$iv12;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
            int i11 = ($changed$iv$iv$iv6 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
            int i12 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1408109941, "C338@15092L291,348@15543L9,345@15408L504:ShareDialogService.kt#q5u6yf");
            ImageBitmap imageBitmap = this$0.getImage();
            Modifier modifier2 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(10), 0.0f, 0.0f, 13, (Object) null);
            if (imageBitmap == null) {
                $composer.startReplaceGroup(1408227988);
                ComposerKt.sourceInformation($composer, "328@14648L18,327@14599L228");
                ImageKt.Image(TvLoadingKt.tvLoadingPainter($composer, 0), (String) null, SizeKt.wrapContentSize$default(modifier2, (Alignment) null, false, 3, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 432, 120);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(1408513312);
                ComposerKt.sourceInformation($composer, "333@14889L152");
                ShareMenuViewKt.ShareMenuView($viewModel, modifier2, (ShareMenuViewStyle) null, (Function5) null, $composer, ShareMenuVM.$stable | 48, 12);
                $composer.endReplaceGroup();
            }
            SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl((float) 0.5d)), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), $composer, 6);
            TextKt.Text-Nvy7gAk("取消", ClickableKt.clickable-oSLSa3U$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(16), 1, (Object) null), false, (String) null, (Role) null, (MutableInteractionSource) null, $onDismissRequest, 15, (Object) null), Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16(), $composer, 390, 0, 130040);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$7$0$0$0(GraphicsLayer $graphicsLayer, final MutableState $imageUiDrawn$delegate, final ContentDrawScope $this$drawWithContent) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
        DrawScope.-CC.record-JVtK1S4$default((DrawScope) $this$drawWithContent, $graphicsLayer, 0L, new Function1() { // from class: kntr.app.digital.preview.share.ShareDialogService$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit Content$lambda$7$0$0$0$0;
                Content$lambda$7$0$0$0$0 = ShareDialogService.Content$lambda$7$0$0$0$0($this$drawWithContent, $imageUiDrawn$delegate, (DrawScope) obj);
                return Content$lambda$7$0$0$0$0;
            }
        }, 1, (Object) null);
        GraphicsLayerKt.drawLayer((DrawScope) $this$drawWithContent, $graphicsLayer);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$7$0$0$0$0(ContentDrawScope $this_drawWithContent, MutableState $imageUiDrawn$delegate, DrawScope $this$record) {
        Intrinsics.checkNotNullParameter($this$record, "$this$record");
        Content$lambda$5($imageUiDrawn$delegate, true);
        $this_drawWithContent.drawContent();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$7$0$1$0(ShareInfo $shareInfo, final MutableState $cardImageLoadSuccess$delegate, BoxScope $this$DigitalCardContainer, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$DigitalCardContainer, "$this$DigitalCardContainer");
        ComposerKt.sourceInformation($composer, "C210@9152L209,207@8979L413:ShareDialogService.kt#q5u6yf");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-381674116, $changed, -1, "kntr.app.digital.preview.share.ShareDialogService.Content.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ShareDialogService.kt:207)");
            }
            String image = $shareInfo.getImage();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -1716598611, "CC(remember):ShareDialogService.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.digital.preview.share.ShareDialogService$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit Content$lambda$7$0$1$0$0$0;
                        Content$lambda$7$0$1$0$0$0 = ShareDialogService.Content$lambda$7$0$1$0$0$0($cardImageLoadSuccess$delegate, (ImageState) obj);
                        return Content$lambda$7$0$1$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ImageModuleKt.ImageUI(image, fillMaxSize$default, (Function1) it$iv, $composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$7$0$1$0$0$0(MutableState $cardImageLoadSuccess$delegate, ImageState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof ImageState.Success) {
            Content$lambda$2($cardImageLoadSuccess$delegate, true);
        }
        return Unit.INSTANCE;
    }
}