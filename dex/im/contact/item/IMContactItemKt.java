package im.contact.item;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
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
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
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
import bili.resource.im.Res;
import bili.resource.im.String1_commonMainKt;
import com.bapis.bilibili.account.service.v1.KNameRender;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeDayNight;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import im.base.model.AvatarHolder;
import im.base.model.NameRenderHolder;
import im.base.model.VipNameColorHolder;
import im.base.namerender.NameRenderPainterKt;
import im.contact.IMContactPageEventHandler;
import im.contact.model.IMContactItem;
import im.contact.model.IMContactOnContactClick;
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
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: IMContactItem.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"IMContactItem", "", "item", "Lim/contact/model/IMContactItem;", "eventHandler", "Lim/contact/IMContactPageEventHandler;", "(Lim/contact/model/IMContactItem;Lim/contact/IMContactPageEventHandler;Landroidx/compose/runtime/Composer;I)V", "contact-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMContactItemKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMContactItem$lambda$2(IMContactItem iMContactItem, IMContactPageEventHandler iMContactPageEventHandler, int i2, Composer composer, int i3) {
        IMContactItem(iMContactItem, iMContactPageEventHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void IMContactItem(final IMContactItem item, final IMContactPageEventHandler eventHandler, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Function0 factory$iv$iv$iv$iv;
        Composer $composer$iv$iv;
        Brush nameBrush;
        Integer valueOf;
        TextStyle style;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        Composer $composer3 = $composer.startRestartGroup(1870231515);
        ComposerKt.sourceInformation($composer3, "C(IMContactItem)N(item,eventHandler)40@1486L97,35@1351L2282:IMContactItem.kt#c1ra23");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(eventHandler) ? 32 : 16;
        }
        if (!$composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1870231515, $dirty, -1, "im.contact.item.IMContactItem (IMContactItem.kt:34)");
            }
            Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(56));
            ComposerKt.sourceInformationMarkerStart($composer3, 1996163708, "CC(remember):IMContactItem.kt#9igjgp");
            boolean invalid$iv = (($dirty & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32) | (($dirty & 14) == 4);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: im.contact.item.IMContactItemKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit IMContactItem$lambda$0$0;
                        IMContactItem$lambda$0$0 = IMContactItemKt.IMContactItem$lambda$0$0(IMContactPageEventHandler.this, item);
                        return IMContactItem$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), Dp.constructor-impl(8), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i3 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            RowScope $this$IMContactItem_u24lambda_u241 = rowScope;
            ComposerKt.sourceInformationMarkerStart($composer3, 786036849, "C59@2116L13,82@2795L202:IMContactItem.kt#c1ra23");
            AvatarHolder avatar = item.getAvatar();
            AvatarItem it = avatar != null ? avatar.getAvatar() : null;
            if (it == null) {
                $composer3.startReplaceGroup(786004948);
                $composer3.endReplaceGroup();
                $composer2 = $composer3;
                $composer$iv$iv = $composer3;
                $composer$iv = $composer3;
            } else {
                $composer3.startReplaceGroup(786004949);
                ComposerKt.sourceInformation($composer3, "*47@1795L30,48@1838L99");
                AvatarState state = AvatarKt.rememberAvatarState-ziNgDLE(it, Dp.constructor-impl(40), $composer3, 48);
                AvatarSizeConfig sizeConfig$iv = AvatarSizeConfig.Largest;
                ComposerKt.sourceInformationMarkerStart($composer3, -1812324423, "CC(Avatar)N(state,modifier,sizeConfig)20@712L229:Avatar.kt#v7x95u");
                Modifier modifier$iv2 = Modifier.Companion;
                Modifier modifier$iv$iv = modifier$iv2.then(SizeKt.size-3ABfNKs(Modifier.Companion, sizeConfig$iv.constraintSize-u2uoSUM(state)));
                Alignment contentAlignment$iv$iv = Alignment.Companion.getTopStart();
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv$iv, false);
                int $changed$iv$iv$iv2 = (48 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv$iv = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv$iv);
                Function0 factory$iv$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv$iv = (($changed$iv$iv$iv2 << 6) & 896) | 6;
                $composer2 = $composer3;
                $composer$iv = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv$iv = factory$iv$iv$iv$iv2;
                    $composer3.createNode(factory$iv$iv$iv$iv);
                } else {
                    factory$iv$iv$iv$iv = factory$iv$iv$iv$iv2;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv$iv = Updater.constructor-impl($composer3);
                $composer$iv$iv = $composer3;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, localMap$iv$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, materialized$iv$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i4 = ($changed$iv$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i5 = ((48 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -60560984, "C24@868L21:Avatar.kt#v7x95u");
                $composer3.startReplaceGroup(-833237573);
                ComposerKt.sourceInformation($composer3, "*25@905L20");
                AvatarScope $this$Avatar_u24lambda_u240_u240$iv = AvatarKt.rememberAvatarScope($composer3, 0);
                AvatarContentKt.AvatarContent($this$Avatar_u24lambda_u240_u240$iv, state, $composer3, (384 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW);
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Unit unit = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            NameRenderHolder nameRender = item.getNameRender();
            KNameRender it2 = nameRender != null ? nameRender.getNameRender() : null;
            if (it2 == null) {
                $composer3.startReplaceGroup(786248267);
                $composer3.endReplaceGroup();
                nameBrush = null;
            } else {
                $composer3.startReplaceGroup(786248268);
                ComposerKt.sourceInformation($composer3, "*56@2036L27");
                nameBrush = NameRenderPainterKt.rememberNameRenderBrush(it2, $composer3, 0);
                $composer3.endReplaceGroup();
            }
            ThemeDayNight currentTheme = BiliTheme.INSTANCE.getDayNightTheme($composer3, BiliTheme.$stable);
            if (currentTheme == ThemeDayNight.Day) {
                VipNameColorHolder vipNameColor = item.getVipNameColor();
                valueOf = vipNameColor != null ? Integer.valueOf(vipNameColor.getDayColor()) : null;
            } else {
                VipNameColorHolder vipNameColor2 = item.getVipNameColor();
                valueOf = vipNameColor2 != null ? Integer.valueOf(vipNameColor2.getNightColor()) : null;
            }
            int vipColor = valueOf != null ? valueOf.intValue() : 0;
            if (nameBrush != null) {
                $composer3.startReplaceGroup(786643859);
                ComposerKt.sourceInformation($composer3, "69@2444L9");
                TextStyle textStyle = TextStyle.copy-Ns73l9s$default(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16b(), nameBrush, (float) CropImageView.DEFAULT_ASPECT_RATIO, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 33554430, (Object) null);
                $composer3.endReplaceGroup();
                style = textStyle;
            } else if (vipColor != 0) {
                $composer3.startReplaceGroup(786766061);
                ComposerKt.sourceInformation($composer3, "73@2567L9");
                TextStyle textStyle2 = TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16b(), ColorKt.Color(vipColor), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null);
                $composer3.endReplaceGroup();
                style = textStyle2;
            } else {
                $composer3.startReplaceGroup(786885318);
                ComposerKt.sourceInformation($composer3, "77@2687L9,77@2725L6");
                TextStyle textStyle3 = TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16b(), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null);
                $composer3.endReplaceGroup();
                style = textStyle3;
            }
            TextKt.Text-Nvy7gAk(item.getName(), $this$IMContactItem_u24lambda_u241.weight(Modifier.Companion, 1.0f, false), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, style, $composer3, 0, 24960, 110588);
            if (item.isSpecialFollow()) {
                $composer3.startReplaceGroup(787288721);
                ComposerKt.sourceInformation($composer3, "92@3076L46,93@3158L6,94@3211L9,98@3361L6,91@3047L570");
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String1_commonMainKt.getIm_global_string_88(Res.string.INSTANCE), $composer3, 0), PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(BorderKt.border-xT4_qwU(Modifier.Companion, Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Dp.constructor-impl(4), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl((float) 0.5d), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl((float) 1.5d), 5, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT10(), $composer3, 0, 0, 131064);
            } else {
                $composer3.startReplaceGroup(784247435);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.contact.item.IMContactItemKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMContactItem$lambda$2;
                    IMContactItem$lambda$2 = IMContactItemKt.IMContactItem$lambda$2(IMContactItem.this, eventHandler, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return IMContactItem$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMContactItem$lambda$0$0(IMContactPageEventHandler $eventHandler, IMContactItem $item) {
        $eventHandler.getActionHandler().invoke(new IMContactOnContactClick($item));
        return Unit.INSTANCE;
    }
}