package kntr.app.im.chat.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.emoticon.CollectionEmoticonPackageUiProvider;
import java.util.Collection;
import kntr.app.im.chat.sticker.StickerKt;
import kntr.app.im.chat.sticker.StickerState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatStickerCollection.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkntr/app/im/chat/ui/widget/ChatStickerCollection;", "Lcom/bilibili/emoticon/CollectionEmoticonPackageUiProvider;", "state", "Lkntr/app/im/chat/sticker/StickerState;", "<init>", "(Lkntr/app/im/chat/sticker/StickerState;)V", "PackageUi", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "TabUi", "hasAnyEmoticon", RoomRecommendViewModel.EMPTY_CURSOR, "getHasAnyEmoticon", "()Z", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatStickerCollection implements CollectionEmoticonPackageUiProvider {
    public static final int $stable = 0;
    private final StickerState state;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PackageUi$lambda$0(ChatStickerCollection chatStickerCollection, Modifier modifier, int i, Composer composer, int i2) {
        chatStickerCollection.PackageUi(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TabUi$lambda$1(ChatStickerCollection chatStickerCollection, Modifier modifier, int i, Composer composer, int i2) {
        chatStickerCollection.TabUi(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public ChatStickerCollection(StickerState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
    }

    public void PackageUi(final Modifier modifier, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer $composer2 = $composer.startRestartGroup(-1476152379);
        ComposerKt.sourceInformation($composer2, "C(PackageUi)N(modifier)22@846L29:ChatStickerCollection.kt#92mklk");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(this) ? 32 : 16;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1476152379, $dirty, -1, "kntr.app.im.chat.ui.widget.ChatStickerCollection.PackageUi (ChatStickerCollection.kt:21)");
            }
            StickerKt.StickerPanel(this.state, modifier, $composer2, ($dirty << 3) & 112, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.ChatStickerCollection$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit PackageUi$lambda$0;
                    PackageUi$lambda$0 = ChatStickerCollection.PackageUi$lambda$0(ChatStickerCollection.this, modifier, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return PackageUi$lambda$0;
                }
            });
        }
    }

    public void TabUi(final Modifier modifier, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer $composer2 = $composer.startRestartGroup(2096000086);
        ComposerKt.sourceInformation($composer2, "C(TabUi)N(modifier)27@952L339:ChatStickerCollection.kt#92mklk");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if ($composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2096000086, $dirty, -1, "kntr.app.im.chat.ui.widget.ChatStickerCollection.TabUi (ChatStickerCollection.kt:26)");
            }
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            int $changed$iv = ($dirty & 14) | 48;
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
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
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -880532906, "C29@1074L22,31@1212L6,28@1028L253:ChatStickerCollection.kt#92mklk");
            ImageKt.Image(BiliIconfont.INSTANCE.getStar_favorite_fill_500($composer2, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(22)), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getPi5-0d7_KjU(), 0, 2, (Object) null), $composer2, Painter.$stable | 432, 56);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.ChatStickerCollection$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit TabUi$lambda$1;
                    TabUi$lambda$1 = ChatStickerCollection.TabUi$lambda$1(ChatStickerCollection.this, modifier, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return TabUi$lambda$1;
                }
            });
        }
    }

    public boolean getHasAnyEmoticon() {
        return !((Collection) this.state.getStickerHolder().getValue()).isEmpty();
    }
}