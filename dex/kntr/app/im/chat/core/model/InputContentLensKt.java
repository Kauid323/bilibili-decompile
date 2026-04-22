package kntr.app.im.chat.core.model;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import java.util.List;
import kntr.app.im.chat.core.model.InputContent;
import kntr.app.im.chat.db.model.InputBoxContent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InputContentLens.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"0\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"*\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"*\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00160\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001b\u001a\u0004\b\u000b\u0010\u001c\"F\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u0010\u0010\u001c\"@\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00120\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u0014\u0010\u001c\"@\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00160\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u001b\u001a\u0004\b\u0018\u0010\u001c\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010 \"H\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010 \"B\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00120\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010 \"B\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00160\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010 \"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010'\u001a\u0004\b\u000b\u0010(\"F\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010'\u001a\u0004\b\u0010\u0010(\"@\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00120\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010'\u001a\u0004\b\u0014\u0010(\"@\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00160\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010'\u001a\u0004\b\u0018\u0010(¨\u0006)"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/im/chat/core/model/InputContent;", "Lkntr/app/im/chat/core/model/InputContent$Companion;", "getLens$annotations", "(Lkntr/app/im/chat/core/model/InputContent$Companion;)V", "getLens", "(Lkntr/app/im/chat/core/model/InputContent$Companion;)Lcom/bilibili/blens/BSimpleLens;", "inputBoxContent", "Lkntr/app/im/chat/db/model/InputBoxContent;", "getInputBoxContent$annotations", "getInputBoxContent", "selectedAssets", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/common/photonic/Asset;", "getSelectedAssets$annotations", "getSelectedAssets", "useOriginImage", RoomRecommendViewModel.EMPTY_CURSOR, "getUseOriginImage$annotations", "getUseOriginImage", "contentVersion", RoomRecommendViewModel.EMPTY_CURSOR, "getContentVersion$annotations", "getContentVersion", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "inputBoxContentNullable$annotations", "inputBoxContentNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "selectedAssetsNullable$annotations", "selectedAssetsNullable", "useOriginImageNullable$annotations", "useOriginImageNullable", "contentVersionNullable$annotations", "contentVersionNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InputContentLensKt {
    public static /* synthetic */ void contentVersionNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContentVersion$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getContentVersion$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContentVersion$annotations(InputContent.Companion companion) {
    }

    public static /* synthetic */ void getInputBoxContent$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getInputBoxContent$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getInputBoxContent$annotations(InputContent.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(InputContent.Companion companion) {
    }

    public static /* synthetic */ void getSelectedAssets$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSelectedAssets$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSelectedAssets$annotations(InputContent.Companion companion) {
    }

    public static /* synthetic */ void getUseOriginImage$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getUseOriginImage$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getUseOriginImage$annotations(InputContent.Companion companion) {
    }

    public static /* synthetic */ void inputBoxContentNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void selectedAssetsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void useOriginImageNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<InputContent, InputContent> getLens(InputContent.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InputContent, InputContent>() { // from class: kntr.app.im.chat.core.model.InputContentLensKt$special$$inlined$invoke$1
            public InputContent get(InputContent inputContent) {
                InputContent it = inputContent;
                return it;
            }

            public InputContent set(InputContent inputContent, InputContent inputContent2) {
                InputContent it = inputContent2;
                return it;
            }

            public InputContent modify(InputContent inputContent, Function1<? super InputContent, ? extends InputContent> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InputContent it = inputContent;
                return (InputContent) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<InputContent, InputBoxContent> getInputBoxContent(InputContent.Companion $this$inputBoxContent) {
        Intrinsics.checkNotNullParameter($this$inputBoxContent, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InputContent, InputBoxContent>() { // from class: kntr.app.im.chat.core.model.InputContentLensKt$special$$inlined$invoke$2
            public InputBoxContent get(InputContent inputContent) {
                InputContent it = inputContent;
                return it.getInputBoxContent();
            }

            public InputContent set(InputContent inputContent, InputBoxContent inputBoxContent) {
                InputBoxContent inputBoxContent2 = inputBoxContent;
                InputContent it = inputContent;
                return InputContent.copy$default(it, inputBoxContent2, null, false, 0, 14, null);
            }

            public InputContent modify(InputContent inputContent, Function1<? super InputBoxContent, ? extends InputBoxContent> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InputContent it = inputContent;
                InputBoxContent inputBoxContent = (InputBoxContent) function1.invoke(it.getInputBoxContent());
                InputContent it2 = inputContent;
                return InputContent.copy$default(it2, inputBoxContent, null, false, 0, 14, null);
            }
        };
    }

    public static final BSimpleLens<InputContent, List<Asset>> getSelectedAssets(InputContent.Companion $this$selectedAssets) {
        Intrinsics.checkNotNullParameter($this$selectedAssets, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InputContent, List<? extends Asset>>() { // from class: kntr.app.im.chat.core.model.InputContentLensKt$special$$inlined$invoke$3
            public List<? extends Asset> get(InputContent inputContent) {
                InputContent it = inputContent;
                return it.getSelectedAssets();
            }

            public InputContent set(InputContent inputContent, List<? extends Asset> list) {
                List<? extends Asset> selectedAssets = list;
                InputContent it = inputContent;
                return InputContent.copy$default(it, null, selectedAssets, false, 0, 13, null);
            }

            public InputContent modify(InputContent inputContent, Function1<? super List<? extends Asset>, ? extends List<? extends Asset>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InputContent it = inputContent;
                List selectedAssets = (List) function1.invoke(it.getSelectedAssets());
                InputContent it2 = inputContent;
                return InputContent.copy$default(it2, null, selectedAssets, false, 0, 13, null);
            }
        };
    }

    public static final BSimpleLens<InputContent, Boolean> getUseOriginImage(InputContent.Companion $this$useOriginImage) {
        Intrinsics.checkNotNullParameter($this$useOriginImage, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InputContent, Boolean>() { // from class: kntr.app.im.chat.core.model.InputContentLensKt$special$$inlined$invoke$4
            public Boolean get(InputContent inputContent) {
                InputContent it = inputContent;
                return Boolean.valueOf(it.getUseOriginImage());
            }

            public InputContent set(InputContent inputContent, Boolean bool) {
                boolean useOriginImage = bool.booleanValue();
                InputContent it = inputContent;
                return InputContent.copy$default(it, null, null, useOriginImage, 0, 11, null);
            }

            public InputContent modify(InputContent inputContent, Function1<? super Boolean, ? extends Boolean> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InputContent it = inputContent;
                boolean useOriginImage = ((Boolean) function1.invoke(Boolean.valueOf(it.getUseOriginImage()))).booleanValue();
                InputContent it2 = inputContent;
                return InputContent.copy$default(it2, null, null, useOriginImage, 0, 11, null);
            }
        };
    }

    public static final BSimpleLens<InputContent, Integer> getContentVersion(InputContent.Companion $this$contentVersion) {
        Intrinsics.checkNotNullParameter($this$contentVersion, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InputContent, Integer>() { // from class: kntr.app.im.chat.core.model.InputContentLensKt$special$$inlined$invoke$5
            public Integer get(InputContent inputContent) {
                InputContent it = inputContent;
                return Integer.valueOf(it.getContentVersion());
            }

            public InputContent set(InputContent inputContent, Integer num) {
                int contentVersion = num.intValue();
                InputContent it = inputContent;
                return InputContent.copy$default(it, null, null, false, contentVersion, 7, null);
            }

            public InputContent modify(InputContent inputContent, Function1<? super Integer, ? extends Integer> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InputContent it = inputContent;
                int contentVersion = ((Number) function1.invoke(Integer.valueOf(it.getContentVersion()))).intValue();
                InputContent it2 = inputContent;
                return InputContent.copy$default(it2, null, null, false, contentVersion, 7, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, InputBoxContent> getInputBoxContent(BSimpleLens<T, InputContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getInputBoxContent(InputContent.Companion));
    }

    public static final <T> BSimpleLens<T, List<Asset>> getSelectedAssets(BSimpleLens<T, InputContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSelectedAssets(InputContent.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getUseOriginImage(BSimpleLens<T, InputContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getUseOriginImage(InputContent.Companion));
    }

    public static final <T> BSimpleLens<T, Integer> getContentVersion(BSimpleLens<T, InputContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getContentVersion(InputContent.Companion));
    }

    public static final <T> BNullableLens<T, InputBoxContent> inputBoxContentNullable(BSimpleLens<T, InputContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getInputBoxContent(InputContent.Companion));
    }

    public static final <T> BNullableLens<T, List<Asset>> selectedAssetsNullable(BSimpleLens<T, InputContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSelectedAssets(InputContent.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> useOriginImageNullable(BSimpleLens<T, InputContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getUseOriginImage(InputContent.Companion));
    }

    public static final <T> BNullableLens<T, Integer> contentVersionNullable(BSimpleLens<T, InputContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getContentVersion(InputContent.Companion));
    }

    public static final <T> BNullableLens<T, InputBoxContent> getInputBoxContent(BNullableLens<T, InputContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getInputBoxContent(InputContent.Companion));
    }

    public static final <T> BNullableLens<T, List<Asset>> getSelectedAssets(BNullableLens<T, InputContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSelectedAssets(InputContent.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getUseOriginImage(BNullableLens<T, InputContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getUseOriginImage(InputContent.Companion));
    }

    public static final <T> BNullableLens<T, Integer> getContentVersion(BNullableLens<T, InputContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getContentVersion(InputContent.Companion));
    }
}