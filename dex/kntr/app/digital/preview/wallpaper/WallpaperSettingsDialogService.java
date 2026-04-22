package kntr.app.digital.preview.wallpaper;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.ModalBottomSheetProperties;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
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
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import javax.inject.Inject;
import kntr.app.ad.ad.biz.search.AdSearchSubCardType;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.DialogScope;
import kntr.app.digital.preview.DialogService;
import kntr.app.digital.preview.report.ReportService;
import kntr.app.digital.preview.save.Save_androidKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.KomponentScope;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.digital.preview.generated.resources.Drawable0_commonMainKt;
import srcs.app.digital.preview.generated.resources.Res;

/* compiled from: WallpaperSettingsDialogService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B7\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ&\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0015J3\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018H\u0003¢\u0006\u0002\u0010\u0019J'\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00132\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0003¢\u0006\u0002\u0010 R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lkntr/app/digital/preview/wallpaper/WallpaperSettingsDialogService;", RoomRecommendViewModel.EMPTY_CURSOR, "komponentScope", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "reportService", "Lkntr/app/digital/preview/report/ReportService;", "setHomeWallpaper", "Lkntr/app/digital/preview/wallpaper/SetHomeWallpaper;", "setLockscreenWallpaper", "Lkntr/app/digital/preview/wallpaper/SetLockscreenWallpaper;", "dialogService", "Lkntr/app/digital/preview/DialogService;", "<init>", "(Lkntr/common/komponent/KomponentScope;Lkntr/app/digital/preview/report/ReportService;Lkntr/app/digital/preview/wallpaper/SetHomeWallpaper;Lkntr/app/digital/preview/wallpaper/SetLockscreenWallpaper;Lkntr/app/digital/preview/DialogService;)V", "keepShowing", "isImage", RoomRecommendViewModel.EMPTY_CURSOR, "downloadImageLink", RoomRecommendViewModel.EMPTY_CURSOR, "downloadVideoLink", "(ZLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "DigitalWallpaperDialog", "onDismiss", "Lkotlin/Function0;", "(ZLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ActionItemUI", "resource", "Lorg/jetbrains/compose/resources/DrawableResource;", "text", "modifier", "Landroidx/compose/ui/Modifier;", "(Lorg/jetbrains/compose/resources/DrawableResource;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WallpaperSettingsDialogService {
    public static final int $stable = 8;
    private final DialogService dialogService;
    private final KomponentScope<Unit> komponentScope;
    private final ReportService reportService;
    private final SetHomeWallpaper setHomeWallpaper;
    private final SetLockscreenWallpaper setLockscreenWallpaper;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActionItemUI$lambda$1(WallpaperSettingsDialogService wallpaperSettingsDialogService, DrawableResource drawableResource, String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        wallpaperSettingsDialogService.ActionItemUI(drawableResource, str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DigitalWallpaperDialog$lambda$1(WallpaperSettingsDialogService wallpaperSettingsDialogService, boolean z, String str, String str2, Function0 function0, int i, Composer composer, int i2) {
        wallpaperSettingsDialogService.DigitalWallpaperDialog(z, str, str2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    @Inject
    public WallpaperSettingsDialogService(KomponentScope<? super Unit> komponentScope, ReportService reportService, SetHomeWallpaper setHomeWallpaper, SetLockscreenWallpaper setLockscreenWallpaper, DialogService dialogService) {
        Intrinsics.checkNotNullParameter(komponentScope, "komponentScope");
        Intrinsics.checkNotNullParameter(reportService, "reportService");
        Intrinsics.checkNotNullParameter(setHomeWallpaper, "setHomeWallpaper");
        Intrinsics.checkNotNullParameter(setLockscreenWallpaper, "setLockscreenWallpaper");
        Intrinsics.checkNotNullParameter(dialogService, "dialogService");
        this.komponentScope = komponentScope;
        this.reportService = reportService;
        this.setHomeWallpaper = setHomeWallpaper;
        this.setLockscreenWallpaper = setLockscreenWallpaper;
        this.dialogService = dialogService;
    }

    public final Object keepShowing(final boolean isImage, final String downloadImageLink, final String downloadVideoLink, Continuation<? super Unit> continuation) {
        Object keepDialogShowing = this.dialogService.keepDialogShowing((Function3) ComposableLambdaKt.composableLambdaInstance(794972049, true, new Function3() { // from class: kntr.app.digital.preview.wallpaper.WallpaperSettingsDialogService$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit keepShowing$lambda$0;
                keepShowing$lambda$0 = WallpaperSettingsDialogService.keepShowing$lambda$0(WallpaperSettingsDialogService.this, isImage, downloadImageLink, downloadVideoLink, (DialogScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return keepShowing$lambda$0;
            }
        }), continuation);
        return keepDialogShowing == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? keepDialogShowing : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit keepShowing$lambda$0(WallpaperSettingsDialogService this$0, boolean $isImage, String $downloadImageLink, String $downloadVideoLink, DialogScope $this$keepDialogShowing, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$keepDialogShowing, "$this$keepDialogShowing");
        ComposerKt.sourceInformation($composer, "C51@2246L87:WallpaperSettingsDialogService.kt#r7wz8s");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer.changed($this$keepDialogShowing) : $composer.changedInstance($this$keepDialogShowing) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(794972049, $dirty2, -1, "kntr.app.digital.preview.wallpaper.WallpaperSettingsDialogService.keepShowing.<anonymous> (WallpaperSettingsDialogService.kt:51)");
            }
            this$0.DigitalWallpaperDialog($isImage, $downloadImageLink, $downloadVideoLink, $this$keepDialogShowing.getOnDismissRequest(), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private final void DigitalWallpaperDialog(final boolean isImage, final String downloadImageLink, final String downloadVideoLink, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-764981668);
        ComposerKt.sourceInformation($composer2, "C(DigitalWallpaperDialog)N(isImage,downloadImageLink,downloadVideoLink,onDismiss)71@2978L3632,63@2638L3972:WallpaperSettingsDialogService.kt#r7wz8s");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(isImage) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(downloadImageLink) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(downloadVideoLink) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(this) ? 16384 : 8192;
        }
        if ($composer2.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-764981668, $dirty, -1, "kntr.app.digital.preview.wallpaper.WallpaperSettingsDialogService.DigitalWallpaperDialog (WallpaperSettingsDialogService.kt:62)");
            }
            ModalBottomSheetKt.ModalBottomSheet-YbuCTN8(function0, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (SheetState) null, 0.0f, false, RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 0.0f, 12, (Object) null), ColorKt.Color(4279900698L), 0L, 0.0f, 0L, (Function2) null, (Function2) null, (ModalBottomSheetProperties) null, ComposableLambdaKt.rememberComposableLambda(1193404862, true, new Function3() { // from class: kntr.app.digital.preview.wallpaper.WallpaperSettingsDialogService$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit DigitalWallpaperDialog$lambda$0;
                    DigitalWallpaperDialog$lambda$0 = WallpaperSettingsDialogService.DigitalWallpaperDialog$lambda$0(WallpaperSettingsDialogService.this, downloadImageLink, function0, isImage, downloadVideoLink, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return DigitalWallpaperDialog$lambda$0;
                }
            }, $composer2, 54), $composer2, (($dirty >> 9) & 14) | 1572912, 3078, 7068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.wallpaper.WallpaperSettingsDialogService$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit DigitalWallpaperDialog$lambda$1;
                    DigitalWallpaperDialog$lambda$1 = WallpaperSettingsDialogService.DigitalWallpaperDialog$lambda$1(WallpaperSettingsDialogService.this, isImage, downloadImageLink, downloadVideoLink, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return DigitalWallpaperDialog$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x033b, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x03d6, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit DigitalWallpaperDialog$lambda$0(final WallpaperSettingsDialogService this$0, final String $downloadImageLink, final Function0 $onDismiss, final boolean $isImage, final String $downloadVideoLink, ColumnScope $this$ModalBottomSheet, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter($this$ModalBottomSheet, "$this$ModalBottomSheet");
        ComposerKt.sourceInformation($composer, "C72@2996L3600:WallpaperSettingsDialogService.kt#r7wz8s");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1193404862, $changed, -1, "kntr.app.digital.preview.wallpaper.WallpaperSettingsDialogService.DigitalWallpaperDialog.<anonymous> (WallpaperSettingsDialogService.kt:72)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(40), 7, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
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
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 44654563, "C78@3206L41,81@3357L9,82@3414L6,79@3268L254,85@3543L41,86@3605L2973:WallpaperSettingsDialogService.kt#r7wz8s");
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
            TextKt.Text-Nvy7gAk("设为手机壁纸", PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(20), 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT15(), $composer, 54, 0, 131064);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(28)), $composer, 6);
            Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceAround();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            int $changed$iv$iv2 = (54 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1677450853, "C98@4149L425,92@3852L749,112@4868L431,107@4626L700,126@5597L932,121@5351L1205:WallpaperSettingsDialogService.kt#r7wz8s");
            DrawableResource digital_wallpaper_desk = Drawable0_commonMainKt.getDigital_wallpaper_desk(Res.drawable.INSTANCE);
            Modifier wrapContentSize$default = SizeKt.wrapContentSize$default(Modifier.Companion, (Alignment) null, false, 3, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 2024105889, "CC(remember):WallpaperSettingsDialogService.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(this$0) | $composer.changed($downloadImageLink) | $composer.changed($onDismiss);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.digital.preview.wallpaper.WallpaperSettingsDialogService$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit DigitalWallpaperDialog$lambda$0$0$0$0$0;
                    DigitalWallpaperDialog$lambda$0$0$0$0$0 = WallpaperSettingsDialogService.DigitalWallpaperDialog$lambda$0$0$0$0$0(WallpaperSettingsDialogService.this, $downloadImageLink, $onDismiss);
                    return DigitalWallpaperDialog$lambda$0$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            this$0.ActionItemUI(digital_wallpaper_desk, "设为桌面", ClickableKt.clickable-oSLSa3U$default(wrapContentSize$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), $composer, 48, 0);
            DrawableResource digital_wallpaper_lock = Drawable0_commonMainKt.getDigital_wallpaper_lock(Res.drawable.INSTANCE);
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, 2024128903, "CC(remember):WallpaperSettingsDialogService.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance(this$0) | $composer.changed($downloadImageLink) | $composer.changed($onDismiss);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function0() { // from class: kntr.app.digital.preview.wallpaper.WallpaperSettingsDialogService$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit DigitalWallpaperDialog$lambda$0$0$0$1$0;
                    DigitalWallpaperDialog$lambda$0$0$0$1$0 = WallpaperSettingsDialogService.DigitalWallpaperDialog$lambda$0$0$0$1$0(WallpaperSettingsDialogService.this, $downloadImageLink, $onDismiss);
                    return DigitalWallpaperDialog$lambda$0$0$0$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            this$0.ActionItemUI(digital_wallpaper_lock, "设为锁屏", ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), $composer, 48, 0);
            DrawableResource digital_wallpaper_download = Drawable0_commonMainKt.getDigital_wallpaper_download(Res.drawable.INSTANCE);
            Modifier modifier2 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, 2024152732, "CC(remember):WallpaperSettingsDialogService.kt#9igjgp");
            boolean invalid$iv3 = $composer.changed($isImage) | $composer.changed($downloadVideoLink) | $composer.changedInstance(this$0) | $composer.changed($downloadImageLink) | $composer.changed($onDismiss);
            Object value$iv3 = $composer.rememberedValue();
            if (invalid$iv3 || value$iv3 == Composer.Companion.getEmpty()) {
                value$iv3 = new Function0() { // from class: kntr.app.digital.preview.wallpaper.WallpaperSettingsDialogService$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit DigitalWallpaperDialog$lambda$0$0$0$2$0;
                        DigitalWallpaperDialog$lambda$0$0$0$2$0 = WallpaperSettingsDialogService.DigitalWallpaperDialog$lambda$0$0$0$2$0($isImage, $downloadVideoLink, this$0, $downloadImageLink, $onDismiss);
                        return DigitalWallpaperDialog$lambda$0$0$0$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            this$0.ActionItemUI(digital_wallpaper_download, "保存卡牌", ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv3, 15, (Object) null), $composer, 48, 0);
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
    public static final Unit DigitalWallpaperDialog$lambda$0$0$0$0$0(WallpaperSettingsDialogService this$0, String $downloadImageLink, Function0 $onDismiss) {
        this$0.setHomeWallpaper.invoke($downloadImageLink);
        this$0.reportService.report("sqzz.dressing.single-card.wallpaper.click", MapsKt.mapOf(TuplesKt.to("btn", "1")));
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DigitalWallpaperDialog$lambda$0$0$0$1$0(WallpaperSettingsDialogService this$0, String $downloadImageLink, Function0 $onDismiss) {
        this$0.setLockscreenWallpaper.invoke($downloadImageLink);
        this$0.reportService.report("sqzz.dressing.single-card.wallpaper.click", MapsKt.mapOf(TuplesKt.to("btn", AdSearchSubCardType.CARD_TYPE_2)));
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DigitalWallpaperDialog$lambda$0$0$0$2$0(boolean $isImage, String $downloadVideoLink, WallpaperSettingsDialogService this$0, String $downloadImageLink, Function0 $onDismiss) {
        if ($isImage || StringsKt.isBlank($downloadVideoLink)) {
            Save_androidKt.getSave().saveImage(this$0.komponentScope, $downloadImageLink);
        } else {
            Save_androidKt.getSave().saveVideo(this$0.komponentScope, $downloadImageLink, CollectionsKt.listOf($downloadVideoLink));
        }
        this$0.reportService.report("sqzz.dressing.single-card.wallpaper.click", MapsKt.mapOf(TuplesKt.to("btn", AdSearchSubCardType.CARD_TYPE_3)));
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    private final void ActionItemUI(final DrawableResource resource, final String text, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1887655905);
        ComposerKt.sourceInformation($composer2, "C(ActionItemUI)N(resource,text,modifier)154@6809L387:WallpaperSettingsDialogService.kt#r7wz8s");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(resource) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(text) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1887655905, $dirty2, -1, "kntr.app.digital.preview.wallpaper.WallpaperSettingsDialogService.ActionItemUI (WallpaperSettingsDialogService.kt:153)");
            }
            int $changed$iv = ($dirty2 >> 6) & 14;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            Modifier modifier5 = modifier4;
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -325438553, "C156@6892L25,155@6855L181,160@7053L41,161@7147L9,161@7111L71:WallpaperSettingsDialogService.kt#r7wz8s");
            ImageKt.Image(ImageResourcesKt.painterResource(resource, $composer2, $dirty2 & 14), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(52)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, Painter.$stable | 432, 120);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(14)), $composer2, 6);
            TextKt.Text-Nvy7gAk(text, (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, (($dirty2 >> 3) & 14) | 384, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.wallpaper.WallpaperSettingsDialogService$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit ActionItemUI$lambda$1;
                    ActionItemUI$lambda$1 = WallpaperSettingsDialogService.ActionItemUI$lambda$1(WallpaperSettingsDialogService.this, resource, text, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ActionItemUI$lambda$1;
                }
            });
        }
    }
}