package kntr.app.im.chat.core.model;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.im.chat.core.model.InputBoxConfig;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InputBoxConfigLens.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\",\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"*\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007\"B\u0010\b\u001a\u0010\u0012\u0004\u0012\u0002H\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0018\u001a\u0004\b\u000b\u0010\u0019\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u000f\u0010\u0019\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0012\u0010\u0019\"@\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u0015\u0010\u0019\"D\u0010\b\u001a\u0010\u0012\u0004\u0012\u0002H\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u0010\u0012\u0004\u0012\u0002H\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u001b\u0010\u0019\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\r0\u001c\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u0010\u0012\u0004\u0012\u0002H\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001f\"B\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\r0\u001c\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u0010\u0012\u0004\u0012\u0002H\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001f\"B\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\r0\u001c\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u0010\u0012\u0004\u0012\u0002H\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010\u001f\"B\u0010\b\u001a\u0010\u0012\u0004\u0012\u0002H\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u001c8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010$\u001a\u0004\b\u000b\u0010%\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\r0\u001c\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u001c8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010$\u001a\u0004\b\u000f\u0010&\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\r0\u001c\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u001c8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010$\u001a\u0004\b\u0012\u0010&\"@\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\r0\u001c\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u001c8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010$\u001a\u0004\b\u0015\u0010&¨\u0006'"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/im/chat/core/model/InputBoxConfig;", "Lkntr/app/im/chat/core/model/InputBoxConfig$Companion;", "getLens$annotations", "(Lkntr/app/im/chat/core/model/InputBoxConfig$Companion;)V", "getLens", "(Lkntr/app/im/chat/core/model/InputBoxConfig$Companion;)Lcom/bilibili/blens/BSimpleLens;", "hintText", RoomRecommendViewModel.EMPTY_CURSOR, "getHintText$annotations", "getHintText", "enablePic", RoomRecommendViewModel.EMPTY_CURSOR, "getEnablePic$annotations", "getEnablePic", "enableVideo", "getEnableVideo$annotations", "getEnableVideo", "enableSticker", "getEnableSticker$annotations", "getEnableSticker", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "hintTextNullable$annotations", "hintTextNullable", "Lcom/bilibili/blens/BNullableLens;", "enablePicNullable$annotations", "enablePicNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "enableVideoNullable$annotations", "enableVideoNullable", "enableStickerNullable$annotations", "enableStickerNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InputBoxConfigLensKt {
    public static /* synthetic */ void enablePicNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void enableStickerNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void enableVideoNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getEnablePic$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getEnablePic$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getEnablePic$annotations(InputBoxConfig.Companion companion) {
    }

    public static /* synthetic */ void getEnableSticker$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getEnableSticker$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getEnableSticker$annotations(InputBoxConfig.Companion companion) {
    }

    public static /* synthetic */ void getEnableVideo$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getEnableVideo$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getEnableVideo$annotations(InputBoxConfig.Companion companion) {
    }

    public static /* synthetic */ void getHintText$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getHintText$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getHintText$annotations(InputBoxConfig.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(InputBoxConfig.Companion companion) {
    }

    public static /* synthetic */ void hintTextNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<InputBoxConfig, InputBoxConfig> getLens(InputBoxConfig.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InputBoxConfig, InputBoxConfig>() { // from class: kntr.app.im.chat.core.model.InputBoxConfigLensKt$special$$inlined$invoke$1
            public InputBoxConfig get(InputBoxConfig inputBoxConfig) {
                InputBoxConfig it = inputBoxConfig;
                return it;
            }

            public InputBoxConfig set(InputBoxConfig inputBoxConfig, InputBoxConfig inputBoxConfig2) {
                InputBoxConfig it = inputBoxConfig2;
                return it;
            }

            public InputBoxConfig modify(InputBoxConfig inputBoxConfig, Function1<? super InputBoxConfig, ? extends InputBoxConfig> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InputBoxConfig it = inputBoxConfig;
                return (InputBoxConfig) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<InputBoxConfig, String> getHintText(InputBoxConfig.Companion $this$hintText) {
        Intrinsics.checkNotNullParameter($this$hintText, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InputBoxConfig, String>() { // from class: kntr.app.im.chat.core.model.InputBoxConfigLensKt$special$$inlined$invoke$2
            public String get(InputBoxConfig inputBoxConfig) {
                InputBoxConfig it = inputBoxConfig;
                return it.getHintText();
            }

            public InputBoxConfig set(InputBoxConfig inputBoxConfig, String str) {
                String hintText = str;
                InputBoxConfig it = inputBoxConfig;
                return InputBoxConfig.copy$default(it, hintText, false, false, false, 14, null);
            }

            public InputBoxConfig modify(InputBoxConfig inputBoxConfig, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InputBoxConfig it = inputBoxConfig;
                String hintText = (String) function1.invoke(it.getHintText());
                InputBoxConfig it2 = inputBoxConfig;
                return InputBoxConfig.copy$default(it2, hintText, false, false, false, 14, null);
            }
        };
    }

    public static final BSimpleLens<InputBoxConfig, Boolean> getEnablePic(InputBoxConfig.Companion $this$enablePic) {
        Intrinsics.checkNotNullParameter($this$enablePic, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InputBoxConfig, Boolean>() { // from class: kntr.app.im.chat.core.model.InputBoxConfigLensKt$special$$inlined$invoke$3
            public Boolean get(InputBoxConfig inputBoxConfig) {
                InputBoxConfig it = inputBoxConfig;
                return Boolean.valueOf(it.getEnablePic());
            }

            public InputBoxConfig set(InputBoxConfig inputBoxConfig, Boolean bool) {
                boolean enablePic = bool.booleanValue();
                InputBoxConfig it = inputBoxConfig;
                return InputBoxConfig.copy$default(it, null, enablePic, false, false, 13, null);
            }

            public InputBoxConfig modify(InputBoxConfig inputBoxConfig, Function1<? super Boolean, ? extends Boolean> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InputBoxConfig it = inputBoxConfig;
                boolean enablePic = ((Boolean) function1.invoke(Boolean.valueOf(it.getEnablePic()))).booleanValue();
                InputBoxConfig it2 = inputBoxConfig;
                return InputBoxConfig.copy$default(it2, null, enablePic, false, false, 13, null);
            }
        };
    }

    public static final BSimpleLens<InputBoxConfig, Boolean> getEnableVideo(InputBoxConfig.Companion $this$enableVideo) {
        Intrinsics.checkNotNullParameter($this$enableVideo, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InputBoxConfig, Boolean>() { // from class: kntr.app.im.chat.core.model.InputBoxConfigLensKt$special$$inlined$invoke$4
            public Boolean get(InputBoxConfig inputBoxConfig) {
                InputBoxConfig it = inputBoxConfig;
                return Boolean.valueOf(it.getEnableVideo());
            }

            public InputBoxConfig set(InputBoxConfig inputBoxConfig, Boolean bool) {
                boolean enableVideo = bool.booleanValue();
                InputBoxConfig it = inputBoxConfig;
                return InputBoxConfig.copy$default(it, null, false, enableVideo, false, 11, null);
            }

            public InputBoxConfig modify(InputBoxConfig inputBoxConfig, Function1<? super Boolean, ? extends Boolean> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InputBoxConfig it = inputBoxConfig;
                boolean enableVideo = ((Boolean) function1.invoke(Boolean.valueOf(it.getEnableVideo()))).booleanValue();
                InputBoxConfig it2 = inputBoxConfig;
                return InputBoxConfig.copy$default(it2, null, false, enableVideo, false, 11, null);
            }
        };
    }

    public static final BSimpleLens<InputBoxConfig, Boolean> getEnableSticker(InputBoxConfig.Companion $this$enableSticker) {
        Intrinsics.checkNotNullParameter($this$enableSticker, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InputBoxConfig, Boolean>() { // from class: kntr.app.im.chat.core.model.InputBoxConfigLensKt$special$$inlined$invoke$5
            public Boolean get(InputBoxConfig inputBoxConfig) {
                InputBoxConfig it = inputBoxConfig;
                return Boolean.valueOf(it.getEnableSticker());
            }

            public InputBoxConfig set(InputBoxConfig inputBoxConfig, Boolean bool) {
                boolean enableSticker = bool.booleanValue();
                InputBoxConfig it = inputBoxConfig;
                return InputBoxConfig.copy$default(it, null, false, false, enableSticker, 7, null);
            }

            public InputBoxConfig modify(InputBoxConfig inputBoxConfig, Function1<? super Boolean, ? extends Boolean> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InputBoxConfig it = inputBoxConfig;
                boolean enableSticker = ((Boolean) function1.invoke(Boolean.valueOf(it.getEnableSticker()))).booleanValue();
                InputBoxConfig it2 = inputBoxConfig;
                return InputBoxConfig.copy$default(it2, null, false, false, enableSticker, 7, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, String> getHintText(BSimpleLens<T, InputBoxConfig> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getHintText(InputBoxConfig.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getEnablePic(BSimpleLens<T, InputBoxConfig> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getEnablePic(InputBoxConfig.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getEnableVideo(BSimpleLens<T, InputBoxConfig> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getEnableVideo(InputBoxConfig.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getEnableSticker(BSimpleLens<T, InputBoxConfig> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getEnableSticker(InputBoxConfig.Companion));
    }

    public static final <T> BSimpleLens<T, String> hintTextNullable(BSimpleLens<T, InputBoxConfig> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getHintText(InputBoxConfig.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> enablePicNullable(BSimpleLens<T, InputBoxConfig> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getEnablePic(InputBoxConfig.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> enableVideoNullable(BSimpleLens<T, InputBoxConfig> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getEnableVideo(InputBoxConfig.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> enableStickerNullable(BSimpleLens<T, InputBoxConfig> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getEnableSticker(InputBoxConfig.Companion));
    }

    public static final <T> BSimpleLens<T, String> getHintText(BNullableLens<T, InputBoxConfig> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getHintText(InputBoxConfig.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getEnablePic(BNullableLens<T, InputBoxConfig> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getEnablePic(InputBoxConfig.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getEnableVideo(BNullableLens<T, InputBoxConfig> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getEnableVideo(InputBoxConfig.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getEnableSticker(BNullableLens<T, InputBoxConfig> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getEnableSticker(InputBoxConfig.Companion));
    }
}