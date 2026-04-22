package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Iterator;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.FileInfoFloor;
import kntr.app.mall.product.details.page.api.model.SkuInfoFloor;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.mall.product.details.page.vm.FloorType;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FileInfoFloorComponent.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a'\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\u000e\u001a\u0017\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\u0010\u0013\u001a \u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012H\u0000\u001a\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012H\u0000¨\u0006\u0018²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u0084\u0002"}, d2 = {"FileInfoFloorComponent", "", "module", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "pageViewModel", "Lkntr/app/mall/product/details/page/vm/PageViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/ContentModule;Lkntr/app/mall/product/details/page/vm/PageViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "FileInfoItemComponent", "data", "Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfoItem;", "scale", "", "(Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfoItem;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "formatDuration", "", "durationInSeconds", "", "(Ljava/lang/Integer;)Ljava/lang/String;", "formatTime", "hours", "minutes", "seconds", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FileInfoFloorComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileInfoFloorComponent$lambda$0(ContentModule contentModule, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        FileInfoFloorComponent(contentModule, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileInfoFloorComponent$lambda$2(ContentModule contentModule, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        FileInfoFloorComponent(contentModule, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileInfoFloorComponent$lambda$7(ContentModule contentModule, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        FileInfoFloorComponent(contentModule, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileInfoItemComponent$lambda$0(FileInfoFloor.FileInfoItem fileInfoItem, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        FileInfoItemComponent(fileInfoItem, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileInfoItemComponent$lambda$3(FileInfoFloor.FileInfoItem fileInfoItem, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        FileInfoItemComponent(fileInfoItem, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void FileInfoFloorComponent(final ContentModule module, final PageViewModel pageViewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Object obj;
        final String skuDisplayText;
        String str;
        SkuInfoFloor.ItemsSkuListVO itemsSkuListVO;
        List<SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem> itemsSkuList;
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(pageViewModel, "pageViewModel");
        Composer $composer3 = $composer.startRestartGroup(-1482353945);
        ComposerKt.sourceInformation($composer3, "C(FileInfoFloorComponent)N(module,pageViewModel,modifier)52@2291L16,54@2388L16,57@2508L34,59@2653L16,64@2973L16,85@3590L3879,76@3253L4216:FileInfoFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(module) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(pageViewModel) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
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
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1482353945, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.FileInfoFloorComponent (FileInfoFloorComponent.kt:48)");
            }
            if (module instanceof ContentModule.FileInfoModule) {
                State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
                final float scale = FileInfoFloorComponent$lambda$1(scaleModel$delegate).getScale();
                State fileInfoState = SnapshotStateKt.collectAsState(pageViewModel.getFileInfo(), (CoroutineContext) null, $composer3, 0, 1);
                final FileInfoFloor.FileInfo fileInfoVO = (FileInfoFloor.FileInfo) fileInfoState.getValue();
                if (fileInfoVO != null) {
                    final Long total = fileInfoVO.getTotal();
                    ComposerKt.sourceInformationMarkerStart($composer3, 1387016201, "CC(remember):FileInfoFloorComponent.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        $composer3.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    final MutableState showMore = (MutableState) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    List<FileInfoFloor.FileInfoItem> list = fileInfoVO.getList();
                    final boolean needShowMore = (list != null ? list.size() : 0) > 2;
                    State contentModules = SnapshotStateKt.collectAsState(pageViewModel.getContentModules$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
                    Iterator it = ((Iterable) contentModules.getValue()).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        ContentModule it2 = (ContentModule) obj;
                        if (it2.getFloorType() == FloorType.SKU_INFO) {
                            break;
                        }
                    }
                    ContentModule.SkuInfoModule skuInfoModule = obj instanceof ContentModule.SkuInfoModule ? (ContentModule.SkuInfoModule) obj : null;
                    SkuInfoFloor skuInfoFloor = skuInfoModule != null ? skuInfoModule.getData() : null;
                    int skuCount = (skuInfoFloor == null || (itemsSkuListVO = skuInfoFloor.getItemsSkuListVO()) == null || (itemsSkuList = itemsSkuListVO.getItemsSkuList()) == null) ? 0 : itemsSkuList.size();
                    State selectedSku = SnapshotStateKt.collectAsState(pageViewModel.getFileInfoSelectedSku(), (CoroutineContext) null, $composer3, 0, 1);
                    if (skuCount <= 1) {
                        skuDisplayText = "";
                    } else {
                        SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem sku = (SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem) selectedSku.getValue();
                        if (sku != null) {
                            List<String> specValues = sku.getSpecValues();
                            String joinToString$default = specValues != null ? CollectionsKt.joinToString$default(specValues, "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) : null;
                            if (joinToString$default == null) {
                                joinToString$default = "";
                            }
                            str = "规格 " + joinToString$default + "的";
                        } else {
                            str = null;
                        }
                        skuDisplayText = str == null ? "" : str;
                    }
                    $composer2 = $composer3;
                    final int i3 = skuCount;
                    PaddingCardKt.PaddingCard(modifier3, PaddingKt.PaddingValues-a9UjIt4$default(0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(8, scale), 7, (Object) null), PaddingKt.PaddingValues-YgX7TsA(ProvideUiScaleKt.dpScaled(12, scale), ProvideUiScaleKt.dpScaled(16, scale)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(12, scale)), ComposableLambdaKt.rememberComposableLambda(-382658132, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.FileInfoFloorComponentKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                            Unit FileInfoFloorComponent$lambda$6;
                            FileInfoFloorComponent$lambda$6 = FileInfoFloorComponentKt.FileInfoFloorComponent$lambda$6(FileInfoFloor.FileInfo.this, needShowMore, scale, skuDisplayText, total, i3, pageViewModel, showMore, (BoxScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                            return FileInfoFloorComponent$lambda$6;
                        }
                    }, $composer2, 54), $composer2, (($dirty2 >> 6) & 14) | 24576, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                    if (endRestartGroup != null) {
                        final Modifier modifier4 = modifier3;
                        endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.FileInfoFloorComponentKt$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj2, Object obj3) {
                                Unit FileInfoFloorComponent$lambda$2;
                                FileInfoFloorComponent$lambda$2 = FileInfoFloorComponentKt.FileInfoFloorComponent$lambda$2(ContentModule.this, pageViewModel, modifier4, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                                return FileInfoFloorComponent$lambda$2;
                            }
                        });
                        return;
                    }
                    return;
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup2 = $composer3.endRestartGroup();
                if (endRestartGroup2 != null) {
                    final Modifier modifier5 = modifier3;
                    endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.FileInfoFloorComponentKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit FileInfoFloorComponent$lambda$0;
                            FileInfoFloorComponent$lambda$0 = FileInfoFloorComponentKt.FileInfoFloorComponent$lambda$0(ContentModule.this, pageViewModel, modifier5, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                            return FileInfoFloorComponent$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.FileInfoFloorComponentKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj2, Object obj3) {
                    Unit FileInfoFloorComponent$lambda$7;
                    FileInfoFloorComponent$lambda$7 = FileInfoFloorComponentKt.FileInfoFloorComponent$lambda$7(ContentModule.this, pageViewModel, modifier6, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return FileInfoFloorComponent$lambda$7;
                }
            });
        }
    }

    private static final UiScaleModel FileInfoFloorComponent$lambda$1(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -112
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit FileInfoFloorComponent$lambda$6(kntr.app.mall.product.details.page.api.model.FileInfoFloor.FileInfo r140, boolean r141, float r142, java.lang.String r143, java.lang.Long r144, int r145, kntr.app.mall.product.details.page.vm.PageViewModel r146, androidx.compose.runtime.MutableState r147, androidx.compose.foundation.layout.BoxScope r148, androidx.compose.runtime.Composer r149, int r150) {
        /*
            Method dump skipped, instructions count: 2277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.ui.components.FileInfoFloorComponentKt.FileInfoFloorComponent$lambda$6(kntr.app.mall.product.details.page.api.model.FileInfoFloor$FileInfo, boolean, float, java.lang.String, java.lang.Long, int, kntr.app.mall.product.details.page.vm.PageViewModel, androidx.compose.runtime.MutableState, androidx.compose.foundation.layout.BoxScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileInfoFloorComponent$lambda$6$0$0$1$0(PageViewModel $pageViewModel) {
        $pageViewModel.updateSkuSwitchState$product_details_page_debug(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileInfoFloorComponent$lambda$6$0$3$0(MutableState $showMore) {
        $showMore.setValue(Boolean.valueOf(!((Boolean) $showMore.getValue()).booleanValue()));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x0934  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0940  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0946  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x09c2  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x09c7  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x09ca  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0a6a  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0a7b  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0a85  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0c9f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FileInfoItemComponent(final FileInfoFloor.FileInfoItem data, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        boolean z;
        Function0 factory$iv$iv$iv6;
        Composer $composer$iv;
        Composer $composer$iv2;
        Composer $composer$iv$iv;
        Composer $composer3;
        Composer $composer$iv3;
        Function0 factory$iv$iv$iv7;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer $composer4 = $composer.startRestartGroup(-2022322405);
        ComposerKt.sourceInformation($composer4, "C(FileInfoItemComponent)N(data,scale,modifier)209@8251L6,203@8031L4669:FileInfoFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(data) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changed(scale) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer4.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2022322405, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.FileInfoItemComponent (FileInfoFloorComponent.kt:194)");
            }
            String fileName = data.getFileName();
            if (fileName != null) {
                Integer downloadStatus = data.getDownloadStatus();
                Integer duration = data.getDuration();
                String it = data.getFileContentType();
                if (it == null) {
                    String it2 = StringsKt.substringAfterLast(fileName, '.', "");
                    it = !StringsKt.isBlank(it2) ? "." + it2 : "";
                }
                String fileContentType = it;
                Modifier modifier$iv$iv = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(52, scale)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(8, scale))), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBg2-0d7_KjU(), (Shape) null, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv$iv);
                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv8;
                    $composer4.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv8;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
                modifier3 = modifier4;
                $composer2 = $composer4;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i4 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -254933168, "C211@8280L4414:FileInfoFloorComponent.kt#o90vz8");
                Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(8, scale), 0.0f, ProvideUiScaleKt.dpScaled(10, scale), 0.0f, 10, (Object) null);
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv2 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv9;
                    $composer4.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv9;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i6 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -735742947, "C222@8718L6,218@8535L983,244@9532L3152:FileInfoFloorComponent.kt#o90vz8");
                Modifier modifier$iv2 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(40, scale)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(6, scale))), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText4-0d7_KjU(), (Shape) null, 2, (Object) null);
                Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv3 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv10;
                    $composer4.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv10;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i8 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -1550762422, "C:FileInfoFloorComponent.kt#o90vz8");
                String fileIcon = data.getFileIcon();
                if (fileIcon == null || fileIcon.length() == 0) {
                    $composer4.startReplaceGroup(-1550717194);
                    ComposerKt.sourceInformation($composer4, "227@8928L19,226@8875L321");
                    IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getMic_singer_fill_500($composer4, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(24, scale)), Color.Companion.getWhite-0d7_KjU(), $composer4, Painter.$stable | 3120, 0);
                    $composer4.endReplaceGroup();
                } else {
                    $composer4.startReplaceGroup(-1550376101);
                    ComposerKt.sourceInformation($composer4, "235@9242L244");
                    String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(data.getFileIcon());
                    ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                    Unit unit = Unit.INSTANCE;
                    BiliImageKt.BiliImage(imageRequest.build(), SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(24, scale)), null, null, null, null, null, null, null, $composer4, 0, 508);
                    $composer4.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Modifier modifier$iv3 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(8, scale), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                int $changed$iv$iv4 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv4 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv11;
                    $composer4.createNode(factory$iv$iv$iv4);
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv11;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i10 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, 1364704484, "C251@9786L804:FileInfoFloorComponent.kt#o90vz8");
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Modifier modifier$iv4 = Modifier.Companion;
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                int $changed$iv$iv$iv5 = ((384 >> 3) & 14) | ((384 >> 3) & 112);
                MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, $changed$iv$iv$iv5);
                int $changed$iv$iv5 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv5 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer4, modifier$iv4);
                Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv6 = (($changed$iv$iv5 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv5 = factory$iv$iv$iv12;
                    $composer4.createNode(factory$iv$iv$iv5);
                } else {
                    factory$iv$iv$iv5 = factory$iv$iv$iv12;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                int i11 = ($changed$iv$iv$iv6 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i12 = ((384 >> 6) & 112) | 6;
                RowScope $this$FileInfoItemComponent_u24lambda_u242_u240_u241_u240 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer4, 1424278795, "C256@10023L6,257@10079L9,254@9899L450,266@10466L6,267@10522L9,264@10370L202:FileInfoFloorComponent.kt#o90vz8");
                TextKt.Text-Nvy7gAk(StringsKt.substringBeforeLast(fileName, '.', fileName), $this$FileInfoItemComponent_u24lambda_u242_u240_u241_u240.weight(Modifier.Companion, 1.0f, false), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12(), scale), $composer4, 0, 24960, 110584);
                TextKt.Text-Nvy7gAk(fileContentType, (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12(), scale), $composer4, 0, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                if (duration != null) {
                    if ((duration.intValue() > 0 ? 1 : 0) == 1) {
                        z = true;
                        if (z && (downloadStatus == null || downloadStatus.intValue() != 0)) {
                            $composer4.startReplaceGroup(1354906375);
                            $composer4.endReplaceGroup();
                            $composer3 = $composer4;
                            $composer$iv = $composer4;
                            $composer$iv2 = $composer4;
                        } else {
                            $composer4.startReplaceGroup(1365588603);
                            ComposerKt.sourceInformation($composer4, "274@10728L1924");
                            Modifier modifier$iv5 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(4, scale), 0.0f, 0.0f, 13, (Object) null);
                            Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                            int $changed$iv$iv6 = (384 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                            CompositionLocalMap localMap$iv$iv6 = $composer4.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer4, modifier$iv5);
                            Function0 factory$iv$iv$iv13 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv7 = (($changed$iv$iv6 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if (!$composer4.getInserting()) {
                                factory$iv$iv$iv6 = factory$iv$iv$iv13;
                                $composer4.createNode(factory$iv$iv$iv6);
                            } else {
                                factory$iv$iv$iv6 = factory$iv$iv$iv13;
                                $composer4.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer4);
                            $composer$iv = $composer4;
                            $composer$iv2 = $composer4;
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                            int i13 = ($changed$iv$iv$iv7 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScope rowScope2 = RowScopeInstance.INSTANCE;
                            int i14 = ((384 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, 777992100, "C:FileInfoFloorComponent.kt#o90vz8");
                            if ((duration == null ? duration.intValue() : 0) <= 0) {
                                $composer4.startReplaceGroup(777989433);
                                ComposerKt.sourceInformation($composer4, "280@11047L22,281@11120L6,279@10986L391,290@11528L6,291@11592L9,288@11407L336");
                                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getClock_history_line_200($composer4, 6), "时间", SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(16, scale)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU(), $composer4, Painter.$stable | 48, 0);
                                TextKt.Text-Nvy7gAk(formatDuration(duration), PaddingKt.padding-VpY3zN4$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, scale), 0.0f, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12(), scale), $composer4, 0, 0, 131064);
                            } else {
                                $composer4.startReplaceGroup(767094886);
                            }
                            $composer4.endReplaceGroup();
                            if (downloadStatus != null) {
                                $composer$iv$iv = $composer4;
                                $composer3 = $composer4;
                                $composer$iv3 = $composer4;
                            } else if (downloadStatus.intValue() == 0) {
                                $composer4.startReplaceGroup(778846428);
                                ComposerKt.sourceInformation($composer4, "301@12090L6,297@11850L754");
                                Modifier modifier$iv6 = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(ClipKt.clip(Modifier.Companion, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, scale))), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), (Shape) null, 2, (Object) null), ProvideUiScaleKt.dpScaled(4, scale), 0.0f, 2, (Object) null);
                                Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
                                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicy$iv7 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                                int $changed$iv$iv7 = (48 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv7 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                                CompositionLocalMap localMap$iv$iv7 = $composer4.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer4, modifier$iv6);
                                Function0 factory$iv$iv$iv14 = ComposeUiNode.Companion.getConstructor();
                                int $changed$iv$iv$iv8 = (($changed$iv$iv7 << 6) & 896) | 6;
                                $composer3 = $composer4;
                                $composer$iv3 = $composer4;
                                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!($composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer4.startReusableNode();
                                if ($composer4.getInserting()) {
                                    factory$iv$iv$iv7 = factory$iv$iv$iv14;
                                    $composer4.createNode(factory$iv$iv$iv7);
                                } else {
                                    factory$iv$iv$iv7 = factory$iv$iv$iv14;
                                    $composer4.useNode();
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv7 = Updater.constructor-impl($composer4);
                                $composer$iv$iv = $composer4;
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, measurePolicy$iv7, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, localMap$iv$iv7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv7, Integer.valueOf(compositeKeyHash$iv$iv7), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, materialized$iv$iv7, ComposeUiNode.Companion.getSetModifier());
                                int i15 = ($changed$iv$iv$iv8 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                                int i16 = ((48 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer4, -1262471287, "C307@12444L6,308@12512L9,305@12328L246:FileInfoFloorComponent.kt#o90vz8");
                                TextKt.Text-Nvy7gAk("购买后仅可在线查看", (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT10(), scale), $composer4, 6, 0, 131066);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                $composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                $composer4.endReplaceGroup();
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                $composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                $composer3.endReplaceGroup();
                            } else {
                                $composer$iv$iv = $composer4;
                                $composer3 = $composer4;
                                $composer$iv3 = $composer4;
                            }
                            $composer4.startReplaceGroup(767094886);
                            $composer4.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                            $composer3.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }
                z = false;
                if (z) {
                }
                $composer4.startReplaceGroup(1365588603);
                ComposerKt.sourceInformation($composer4, "274@10728L1924");
                Modifier modifier$iv52 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(4, scale), 0.0f, 0.0f, 13, (Object) null);
                Alignment.Vertical verticalAlignment$iv32 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv32 = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv62 = RowKt.rowMeasurePolicy(horizontalArrangement$iv32, verticalAlignment$iv32, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv62 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv62 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv62 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv62 = ComposedModifierKt.materializeModifier($composer4, modifier$iv52);
                Function0 factory$iv$iv$iv132 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv72 = (($changed$iv$iv62 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                }
                $composer4.startReusableNode();
                if (!$composer4.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv62 = Updater.constructor-impl($composer4);
                $composer$iv = $composer4;
                $composer$iv2 = $composer4;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, measurePolicy$iv62, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, localMap$iv$iv62, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv62, Integer.valueOf(compositeKeyHash$iv$iv62), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv62, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, materialized$iv$iv62, ComposeUiNode.Companion.getSetModifier());
                int i132 = ($changed$iv$iv$iv72 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope22 = RowScopeInstance.INSTANCE;
                int i142 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, 777992100, "C:FileInfoFloorComponent.kt#o90vz8");
                if ((duration == null ? duration.intValue() : 0) <= 0) {
                }
                $composer4.endReplaceGroup();
                if (downloadStatus != null) {
                }
                $composer4.startReplaceGroup(767094886);
                $composer4.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                if (ComposerKt.isTraceInProgress()) {
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier5 = modifier4;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.FileInfoFloorComponentKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit FileInfoItemComponent$lambda$0;
                            FileInfoItemComponent$lambda$0 = FileInfoFloorComponentKt.FileInfoItemComponent$lambda$0(FileInfoFloor.FileInfoItem.this, scale, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return FileInfoItemComponent$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.FileInfoFloorComponentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit FileInfoItemComponent$lambda$3;
                    FileInfoItemComponent$lambda$3 = FileInfoFloorComponentKt.FileInfoItemComponent$lambda$3(FileInfoFloor.FileInfoItem.this, scale, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return FileInfoItemComponent$lambda$3;
                }
            });
        }
    }

    public static final String formatDuration(Integer durationInSeconds) {
        if (durationInSeconds == null || durationInSeconds.intValue() <= 0) {
            return "00:00";
        }
        int hours = durationInSeconds.intValue() / 3600;
        int minutes = (durationInSeconds.intValue() % 3600) / 60;
        int seconds = durationInSeconds.intValue() % 60;
        if (hours > 0) {
            return formatTime(hours, minutes, seconds);
        }
        return formatTime(minutes, seconds);
    }

    public static final String formatTime(int hours, int minutes, int seconds) {
        String padStart = StringsKt.padStart(String.valueOf(hours), 2, '0');
        String padStart2 = StringsKt.padStart(String.valueOf(minutes), 2, '0');
        return padStart + ":" + padStart2 + ":" + StringsKt.padStart(String.valueOf(seconds), 2, '0');
    }

    public static final String formatTime(int minutes, int seconds) {
        String padStart = StringsKt.padStart(String.valueOf(minutes), 2, '0');
        return padStart + ":" + StringsKt.padStart(String.valueOf(seconds), 2, '0');
    }
}