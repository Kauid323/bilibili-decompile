package im.setting;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.account.service.v1.KNameRender;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeDayNight;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import im.base.model.VipNameColorHolder;
import im.base.namerender.NameRenderPainterKt;
import im.setting.model.SettingItem;
import im.setting.model.extension.KSettingUserInfoExtKt;
import kntr.common.compose.res.CommonRes;
import kntr.compose.avatar.AvatarKt;
import kntr.compose.avatar.AvatarScope;
import kntr.compose.avatar.AvatarSizeConfig;
import kntr.compose.avatar.AvatarState;
import kntr.compose.avatar.internal.AvatarContentKt;
import kntr.compose.avatar.model.AvatarItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.im.setting.ui.generated.resources.Res;
import srcs.common.compose.res.generated.resources.Drawable0_commonMainKt;

/* compiled from: IMSettingUserInfoItem.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a#\u0010\t\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¨\u0006\u0017"}, d2 = {"IMSettingUserInfoItem", "", "item", "Lim/setting/model/SettingItem$UserInfo;", "onAction", "Lim/setting/IMSettingActionHandler;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lim/setting/model/SettingItem$UserInfo;Lim/setting/IMSettingActionHandler;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "IMSettingUserInfoAvatar", "avatar", "Lkntr/compose/avatar/model/AvatarItem;", "normalSize", "Landroidx/compose/ui/unit/Dp;", "IMSettingUserInfoAvatar-rAjV9yQ", "(Lkntr/compose/avatar/model/AvatarItem;FLandroidx/compose/runtime/Composer;II)V", "userLevelResource", "Lorg/jetbrains/compose/resources/DrawableResource;", "level", "", "genderResource", "gender", "", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMSettingUserInfoItemKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSettingUserInfoAvatar_rAjV9yQ$lambda$0(AvatarItem avatarItem, float f2, int i2, int i3, Composer composer, int i4) {
        m3398IMSettingUserInfoAvatarrAjV9yQ(avatarItem, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSettingUserInfoItem$lambda$2(SettingItem.UserInfo userInfo, IMSettingActionHandler iMSettingActionHandler, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        IMSettingUserInfoItem(userInfo, iMSettingActionHandler, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static final void IMSettingUserInfoItem(final SettingItem.UserInfo item, final IMSettingActionHandler onAction, Modifier modifier, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Brush nameBrush;
        TextStyle nameStyle;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        Composer $composer3 = $composer.startRestartGroup(-547711152);
        ComposerKt.sourceInformation($composer3, "C(IMSettingUserInfoItem)N(item,onAction,modifier)57@2484L6,59@2604L79,53@2345L3314:IMSettingUserInfoItem.kt#w7mava");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer3.changed(onAction) : $composer3.changedInstance(onAction) ? 32 : 16;
        }
        int i3 = i2 & 4;
        if (i3 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i3 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-547711152, $dirty2, -1, "im.setting.IMSettingUserInfoItem (IMSettingUserInfoItem.kt:52)");
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Modifier modifier3 = PaddingKt.padding-qDBjuR0(BackgroundKt.background-bw27NRU$default(modifier2, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(8), Dp.constructor-impl(10), Dp.constructor-impl(12), Dp.constructor-impl(10));
            ComposerKt.sourceInformationMarkerStart($composer3, 1930573183, "CC(remember):IMSettingUserInfoItem.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32 || (($dirty2 & 64) != 0 && $composer3.changedInstance(onAction))) | (($dirty2 & 14) == 4);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: im.setting.IMSettingUserInfoItemKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit IMSettingUserInfoItem$lambda$0$0;
                        IMSettingUserInfoItem$lambda$0$0 = IMSettingUserInfoItemKt.IMSettingUserInfoItem$lambda$0$0(IMSettingActionHandler.this, item);
                        return IMSettingUserInfoItem$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier3, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (384 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Modifier modifier4 = modifier2;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i5 = ((384 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            RowScope $this$IMSettingUserInfoItem_u24lambda_u241 = rowScope;
            ComposerKt.sourceInformationMarkerStart($composer3, 104477775, "C68@2904L13,89@3560L45,90@3614L29,91@3652L1747,139@5408L29,141@5487L28,143@5585L6,140@5446L207:IMSettingUserInfoItem.kt#w7mava");
            KNameRender it = item.getValue().getNameRender();
            if (it == null) {
                $composer3.startReplaceGroup(104438806);
                $composer3.endReplaceGroup();
                nameBrush = null;
            } else {
                $composer3.startReplaceGroup(104438807);
                ComposerKt.sourceInformation($composer3, "*65@2774L27");
                nameBrush = NameRenderPainterKt.rememberNameRenderBrush(it, $composer3, 0);
                $composer3.endReplaceGroup();
            }
            VipNameColorHolder vipColorHolder = KSettingUserInfoExtKt.vipColor(item.getValue());
            ThemeDayNight currentTheme = BiliTheme.INSTANCE.getDayNightTheme($composer3, BiliTheme.$stable);
            Integer vipColor = currentTheme == ThemeDayNight.Day ? vipColorHolder != null ? Integer.valueOf(vipColorHolder.getDayColor()) : null : vipColorHolder != null ? Integer.valueOf(vipColorHolder.getNightColor()) : null;
            if (nameBrush != null) {
                $composer3.startReplaceGroup(104877023);
                ComposerKt.sourceInformation($composer3, "78@3225L9");
                TextStyle textStyle = TextStyle.copy-Ns73l9s$default(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16(), nameBrush, (float) CropImageView.DEFAULT_ASPECT_RATIO, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 33554430, (Object) null);
                $composer3.endReplaceGroup();
                nameStyle = textStyle;
            } else if (vipColor != null) {
                $composer3.startReplaceGroup(105001209);
                ComposerKt.sourceInformation($composer3, "82@3350L9");
                TextStyle textStyle2 = TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16(), ColorKt.Color(vipColor.intValue()), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null);
                $composer3.endReplaceGroup();
                nameStyle = textStyle2;
            } else {
                $composer3.startReplaceGroup(105119474);
                ComposerKt.sourceInformation($composer3, "86@3469L9,86@3506L6");
                TextStyle textStyle3 = TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16(), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null);
                $composer3.endReplaceGroup();
                nameStyle = textStyle3;
            }
            m3398IMSettingUserInfoAvatarrAjV9yQ(item.getAvatar(), CropImageView.DEFAULT_ASPECT_RATIO, $composer3, 0, 2);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
            Modifier modifier$iv2 = $this$IMSettingUserInfoItem_u24lambda_u241.weight(Modifier.Companion, 1.0f, true);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(2));
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv2 = (48 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i7 = ((48 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1250424539, "C95@3803L1038,125@4958L9,126@5007L6,123@4873L241,133@5233L9,134@5282L6,131@5147L242:IMSettingUserInfoItem.kt#w7mava");
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(5));
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv$iv = Modifier.Companion;
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv3 = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i9 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 402114768, "C100@3994L194,108@4264L50,107@4227L206:IMSettingUserInfoItem.kt#w7mava");
            TextKt.Text-Nvy7gAk(item.getValue().getName(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, nameStyle, $composer3, 0, 24960, 110590);
            ImageKt.Image(ImageResourcesKt.painterResource(genderResource(item.getValue().getGender()), $composer3, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(22)), (Alignment) null, (ContentScale) null, (float) CropImageView.DEFAULT_ASPECT_RATIO, (ColorFilter) null, $composer3, Painter.$stable | 432, (int) TbsListener.ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR);
            DrawableResource userLevelResource = userLevelResource(item.getValue().getLevel());
            if (userLevelResource != null) {
                $composer3.startReplaceGroup(402699458);
                ComposerKt.sourceInformation($composer3, "116@4644L34,115@4603L206");
                ImageKt.Image(ImageResourcesKt.painterResource(userLevelResource, $composer3, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(22)), (Alignment) null, (ContentScale) null, (float) CropImageView.DEFAULT_ASPECT_RATIO, (ColorFilter) null, $composer3, Painter.$stable | 432, (int) TbsListener.ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR);
            } else {
                $composer3.startReplaceGroup(398125904);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextKt.Text-Nvy7gAk(item.getValue().getFirstText(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer3, 0, 24960, 110586);
            TextKt.Text-Nvy7gAk(item.getValue().getSecondText(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer3, 0, 24960, 110586);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer3, 6);
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_800($composer3, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), $composer3, Painter.$stable | 432, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: im.setting.IMSettingUserInfoItemKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSettingUserInfoItem$lambda$2;
                    IMSettingUserInfoItem$lambda$2 = IMSettingUserInfoItemKt.IMSettingUserInfoItem$lambda$2(SettingItem.UserInfo.this, onAction, modifier5, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSettingUserInfoItem$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSettingUserInfoItem$lambda$0$0(IMSettingActionHandler $onAction, SettingItem.UserInfo $item) {
        $onAction.invoke(new IMSettingUserInfoAction($item));
        return Unit.INSTANCE;
    }

    /* renamed from: IMSettingUserInfoAvatar-rAjV9yQ  reason: not valid java name */
    public static final void m3398IMSettingUserInfoAvatarrAjV9yQ(final AvatarItem avatar, float f2, Composer $composer, final int $changed, final int i2) {
        float f3;
        final float f4;
        Function0 factory$iv$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1417959070);
        ComposerKt.sourceInformation($composer2, "C(IMSettingUserInfoAvatar)N(avatar,normalSize:c#ui.unit.Dp):IMSettingUserInfoItem.kt#w7mava");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(avatar) ? 4 : 2;
        }
        int i3 = i2 & 2;
        if (i3 != 0) {
            $dirty |= 48;
            f3 = f2;
        } else if (($changed & 48) == 0) {
            f3 = f2;
            $dirty |= $composer2.changed(f3) ? 32 : 16;
        } else {
            f3 = f2;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (i3 == 0) {
                f4 = f3;
            } else {
                f4 = Dp.constructor-impl(48);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1417959070, $dirty, -1, "im.setting.IMSettingUserInfoAvatar (IMSettingUserInfoItem.kt:153)");
            }
            if (avatar != null) {
                $composer2.startReplaceGroup(1415411827);
                ComposerKt.sourceInformation($composer2, "156@5832L39,155@5804L129");
                AvatarState state$iv = AvatarKt.rememberAvatarState-ziNgDLE(avatar, f4, $composer2, ($dirty & 14) | ($dirty & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
                AvatarSizeConfig sizeConfig$iv = AvatarSizeConfig.Largest;
                ComposerKt.sourceInformationMarkerStart($composer2, -1812324423, "CC(Avatar)N(state,modifier,sizeConfig)20@712L229:Avatar.kt#v7x95u");
                Modifier modifier$iv = Modifier.Companion;
                Modifier modifier$iv$iv = modifier$iv.then(SizeKt.size-3ABfNKs(Modifier.Companion, sizeConfig$iv.constraintSize-u2uoSUM(state$iv)));
                Alignment contentAlignment$iv$iv = Alignment.Companion.getTopStart();
                ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv$iv, false);
                int $changed$iv$iv$iv = (48 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
                Function0 factory$iv$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv$iv = (($changed$iv$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv$iv = factory$iv$iv$iv$iv2;
                    $composer2.createNode(factory$iv$iv$iv$iv);
                } else {
                    factory$iv$iv$iv$iv = factory$iv$iv$iv$iv2;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv$iv = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, localMap$iv$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, materialized$iv$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i4 = ($changed$iv$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i5 = ((48 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -60560984, "C24@868L21:Avatar.kt#v7x95u");
                $composer2.startReplaceGroup(-833237573);
                ComposerKt.sourceInformation($composer2, "*25@905L20");
                AvatarScope $this$Avatar_u24lambda_u240_u240$iv = AvatarKt.rememberAvatarScope($composer2, 0);
                AvatarContentKt.AvatarContent($this$Avatar_u24lambda_u240_u240$iv, state$iv, $composer2, (384 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW);
                $composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(1415560875);
                ComposerKt.sourceInformation($composer2, "160@5955L105");
                BoxKt.Box(SizeKt.size-3ABfNKs(Modifier.Companion, AvatarSizeConfig.Largest.constraintSize-5rwHm24(f4)), $composer2, 0);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            f4 = f3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.setting.IMSettingUserInfoItemKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSettingUserInfoAvatar_rAjV9yQ$lambda$0;
                    IMSettingUserInfoAvatar_rAjV9yQ$lambda$0 = IMSettingUserInfoItemKt.IMSettingUserInfoAvatar_rAjV9yQ$lambda$0(avatar, f4, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSettingUserInfoAvatar_rAjV9yQ$lambda$0;
                }
            });
        }
    }

    private static final DrawableResource userLevelResource(int level) {
        switch (level) {
            case 0:
                return Drawable0_commonMainKt.getUser_level_0(CommonRes.INSTANCE.getDrawable());
            case 1:
                return Drawable0_commonMainKt.getUser_level_1(CommonRes.INSTANCE.getDrawable());
            case 2:
                return Drawable0_commonMainKt.getUser_level_2(CommonRes.INSTANCE.getDrawable());
            case 3:
                return Drawable0_commonMainKt.getUser_level_3(CommonRes.INSTANCE.getDrawable());
            case 4:
                return Drawable0_commonMainKt.getUser_level_4(CommonRes.INSTANCE.getDrawable());
            case 5:
                return Drawable0_commonMainKt.getUser_level_5(CommonRes.INSTANCE.getDrawable());
            case 6:
                return Drawable0_commonMainKt.getUser_level_6(CommonRes.INSTANCE.getDrawable());
            default:
                return null;
        }
    }

    private static final DrawableResource genderResource(String gender) {
        return Intrinsics.areEqual(gender, "男") ? srcs.app.im.setting.ui.generated.resources.Drawable0_commonMainKt.getGender_male(Res.drawable.INSTANCE) : Intrinsics.areEqual(gender, "女") ? srcs.app.im.setting.ui.generated.resources.Drawable0_commonMainKt.getGender_female(Res.drawable.INSTANCE) : srcs.app.im.setting.ui.generated.resources.Drawable0_commonMainKt.getGender_unknown(Res.drawable.INSTANCE);
    }
}