package kntr.app.deepsearch.base.model.biz;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.deepsearch.base.model.biz.TextConfigModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextConfigModelLens.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"*\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"*\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"*\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\"*\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007\"*\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001c0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u0007\",\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010 0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0005\u001a\u0004\b\"\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010#*\u00020$*\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010%\u001a\u0004\b\u000b\u0010&\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010#*\u00020$*\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010%\u001a\u0004\b\u000e\u0010&\"@\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010#*\u00020$*\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010%\u001a\u0004\b\u0011\u0010&\"@\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010#*\u00020$*\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010%\u001a\u0004\b\u0014\u0010&\"@\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010#*\u00020$*\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010%\u001a\u0004\b\u0017\u0010&\"@\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010#*\u00020$*\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010%\u001a\u0004\b\u001a\u0010&\"@\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u001c0\u0001\"\b\b\u0000\u0010#*\u00020$*\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010%\u001a\u0004\b\u001e\u0010&\"B\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u0002H#\u0012\u0006\u0012\u0004\u0018\u00010 0\u0001\"\b\b\u0000\u0010#*\u00020$*\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010%\u001a\u0004\b\"\u0010&\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\t0'\"\b\b\u0000\u0010#*\u00020$*\u0010\u0012\u0004\u0012\u0002H#\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010%\u001a\u0004\b)\u0010*\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\t0'\"\b\b\u0000\u0010#*\u00020$*\u0010\u0012\u0004\u0012\u0002H#\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010%\u001a\u0004\b,\u0010*\"B\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\t0'\"\b\b\u0000\u0010#*\u00020$*\u0010\u0012\u0004\u0012\u0002H#\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b-\u0010%\u001a\u0004\b.\u0010*\"B\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\t0'\"\b\b\u0000\u0010#*\u00020$*\u0010\u0012\u0004\u0012\u0002H#\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010%\u001a\u0004\b0\u0010*\"B\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\t0'\"\b\b\u0000\u0010#*\u00020$*\u0010\u0012\u0004\u0012\u0002H#\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b1\u0010%\u001a\u0004\b2\u0010*\"B\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\t0'\"\b\b\u0000\u0010#*\u00020$*\u0010\u0012\u0004\u0012\u0002H#\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b3\u0010%\u001a\u0004\b4\u0010*\"B\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u001c0'\"\b\b\u0000\u0010#*\u00020$*\u0010\u0012\u0004\u0012\u0002H#\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010%\u001a\u0004\b6\u0010*\"D\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u0002H#\u0012\u0006\u0012\u0004\u0018\u00010 0\u0001\"\b\b\u0000\u0010#*\u00020$*\u0010\u0012\u0004\u0012\u0002H#\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b7\u0010%\u001a\u0004\b8\u0010&\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\t0'\"\b\b\u0000\u0010#*\u00020$*\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00020'8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u00109\u001a\u0004\b\u000b\u0010:\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\t0'\"\b\b\u0000\u0010#*\u00020$*\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00020'8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u00109\u001a\u0004\b\u000e\u0010:\"@\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\t0'\"\b\b\u0000\u0010#*\u00020$*\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00020'8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u00109\u001a\u0004\b\u0011\u0010:\"@\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\t0'\"\b\b\u0000\u0010#*\u00020$*\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00020'8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u00109\u001a\u0004\b\u0014\u0010:\"@\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\t0'\"\b\b\u0000\u0010#*\u00020$*\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00020'8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u00109\u001a\u0004\b\u0017\u0010:\"@\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\t0'\"\b\b\u0000\u0010#*\u00020$*\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00020'8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u00109\u001a\u0004\b\u001a\u0010:\"@\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u001c0'\"\b\b\u0000\u0010#*\u00020$*\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00020'8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u00109\u001a\u0004\b\u001e\u0010:\"B\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u0002H#\u0012\u0006\u0012\u0004\u0018\u00010 0\u0001\"\b\b\u0000\u0010#*\u00020$*\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00020'8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u00109\u001a\u0004\b\"\u0010;¨\u0006<"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/deepsearch/base/model/biz/TextConfigModel;", "Lkntr/app/deepsearch/base/model/biz/TextConfigModel$Companion;", "getLens$annotations", "(Lkntr/app/deepsearch/base/model/biz/TextConfigModel$Companion;)V", "getLens", "(Lkntr/app/deepsearch/base/model/biz/TextConfigModel$Companion;)Lcom/bilibili/blens/BSimpleLens;", "startText", RoomRecommendViewModel.EMPTY_CURSOR, "getStartText$annotations", "getStartText", "completeText", "getCompleteText$annotations", "getCompleteText", "streamingText", "getStreamingText$annotations", "getStreamingText", "chatBotIcon", "getChatBotIcon$annotations", "getChatBotIcon", "navigationThinking", "getNavigationThinking$annotations", "getNavigationThinking", "navigationAnswering", "getNavigationAnswering$annotations", "getNavigationAnswering", "sessionEndInterval", RoomRecommendViewModel.EMPTY_CURSOR, "getSessionEndInterval$annotations", "getSessionEndInterval", "treadPop", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTreadPopModel;", "getTreadPop$annotations", "getTreadPop", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "startTextNullable$annotations", "startTextNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "completeTextNullable$annotations", "completeTextNullable", "streamingTextNullable$annotations", "streamingTextNullable", "chatBotIconNullable$annotations", "chatBotIconNullable", "navigationThinkingNullable$annotations", "navigationThinkingNullable", "navigationAnsweringNullable$annotations", "navigationAnsweringNullable", "sessionEndIntervalNullable$annotations", "sessionEndIntervalNullable", "treadPopNullable$annotations", "treadPopNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TextConfigModelLensKt {
    public static /* synthetic */ void chatBotIconNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void completeTextNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getChatBotIcon$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getChatBotIcon$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getChatBotIcon$annotations(TextConfigModel.Companion companion) {
    }

    public static /* synthetic */ void getCompleteText$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCompleteText$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCompleteText$annotations(TextConfigModel.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(TextConfigModel.Companion companion) {
    }

    public static /* synthetic */ void getNavigationAnswering$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getNavigationAnswering$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getNavigationAnswering$annotations(TextConfigModel.Companion companion) {
    }

    public static /* synthetic */ void getNavigationThinking$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getNavigationThinking$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getNavigationThinking$annotations(TextConfigModel.Companion companion) {
    }

    public static /* synthetic */ void getSessionEndInterval$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSessionEndInterval$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSessionEndInterval$annotations(TextConfigModel.Companion companion) {
    }

    public static /* synthetic */ void getStartText$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getStartText$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getStartText$annotations(TextConfigModel.Companion companion) {
    }

    public static /* synthetic */ void getStreamingText$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getStreamingText$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getStreamingText$annotations(TextConfigModel.Companion companion) {
    }

    public static /* synthetic */ void getTreadPop$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getTreadPop$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getTreadPop$annotations(TextConfigModel.Companion companion) {
    }

    public static /* synthetic */ void navigationAnsweringNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void navigationThinkingNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void sessionEndIntervalNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void startTextNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void streamingTextNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void treadPopNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<TextConfigModel, TextConfigModel> getLens(TextConfigModel.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TextConfigModel, TextConfigModel>() { // from class: kntr.app.deepsearch.base.model.biz.TextConfigModelLensKt$special$$inlined$invoke$1
            public TextConfigModel get(TextConfigModel textConfigModel) {
                TextConfigModel it = textConfigModel;
                return it;
            }

            public TextConfigModel set(TextConfigModel textConfigModel, TextConfigModel textConfigModel2) {
                TextConfigModel it = textConfigModel2;
                return it;
            }

            public TextConfigModel modify(TextConfigModel textConfigModel, Function1<? super TextConfigModel, ? extends TextConfigModel> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                TextConfigModel it = textConfigModel;
                return (TextConfigModel) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<TextConfigModel, String> getStartText(TextConfigModel.Companion $this$startText) {
        Intrinsics.checkNotNullParameter($this$startText, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TextConfigModel, String>() { // from class: kntr.app.deepsearch.base.model.biz.TextConfigModelLensKt$special$$inlined$invoke$2
            public String get(TextConfigModel textConfigModel) {
                TextConfigModel it = textConfigModel;
                return it.getStartText();
            }

            public TextConfigModel set(TextConfigModel textConfigModel, String str) {
                TextConfigModel copy;
                String startText = str;
                TextConfigModel it = textConfigModel;
                copy = it.copy((r20 & 1) != 0 ? it.startText : startText, (r20 & 2) != 0 ? it.completeText : null, (r20 & 4) != 0 ? it.streamingText : null, (r20 & 8) != 0 ? it.chatBotIcon : null, (r20 & 16) != 0 ? it.navigationThinking : null, (r20 & 32) != 0 ? it.navigationAnswering : null, (r20 & 64) != 0 ? it.sessionEndInterval : 0L, (r20 & 128) != 0 ? it.treadPop : null);
                return copy;
            }

            public TextConfigModel modify(TextConfigModel textConfigModel, Function1<? super String, ? extends String> function1) {
                TextConfigModel copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                TextConfigModel it = textConfigModel;
                String startText = (String) function1.invoke(it.getStartText());
                TextConfigModel it2 = textConfigModel;
                copy = it2.copy((r20 & 1) != 0 ? it2.startText : startText, (r20 & 2) != 0 ? it2.completeText : null, (r20 & 4) != 0 ? it2.streamingText : null, (r20 & 8) != 0 ? it2.chatBotIcon : null, (r20 & 16) != 0 ? it2.navigationThinking : null, (r20 & 32) != 0 ? it2.navigationAnswering : null, (r20 & 64) != 0 ? it2.sessionEndInterval : 0L, (r20 & 128) != 0 ? it2.treadPop : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<TextConfigModel, String> getCompleteText(TextConfigModel.Companion $this$completeText) {
        Intrinsics.checkNotNullParameter($this$completeText, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TextConfigModel, String>() { // from class: kntr.app.deepsearch.base.model.biz.TextConfigModelLensKt$special$$inlined$invoke$3
            public String get(TextConfigModel textConfigModel) {
                TextConfigModel it = textConfigModel;
                return it.getCompleteText();
            }

            public TextConfigModel set(TextConfigModel textConfigModel, String str) {
                TextConfigModel copy;
                String completeText = str;
                TextConfigModel it = textConfigModel;
                copy = it.copy((r20 & 1) != 0 ? it.startText : null, (r20 & 2) != 0 ? it.completeText : completeText, (r20 & 4) != 0 ? it.streamingText : null, (r20 & 8) != 0 ? it.chatBotIcon : null, (r20 & 16) != 0 ? it.navigationThinking : null, (r20 & 32) != 0 ? it.navigationAnswering : null, (r20 & 64) != 0 ? it.sessionEndInterval : 0L, (r20 & 128) != 0 ? it.treadPop : null);
                return copy;
            }

            public TextConfigModel modify(TextConfigModel textConfigModel, Function1<? super String, ? extends String> function1) {
                TextConfigModel copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                TextConfigModel it = textConfigModel;
                String completeText = (String) function1.invoke(it.getCompleteText());
                TextConfigModel it2 = textConfigModel;
                copy = it2.copy((r20 & 1) != 0 ? it2.startText : null, (r20 & 2) != 0 ? it2.completeText : completeText, (r20 & 4) != 0 ? it2.streamingText : null, (r20 & 8) != 0 ? it2.chatBotIcon : null, (r20 & 16) != 0 ? it2.navigationThinking : null, (r20 & 32) != 0 ? it2.navigationAnswering : null, (r20 & 64) != 0 ? it2.sessionEndInterval : 0L, (r20 & 128) != 0 ? it2.treadPop : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<TextConfigModel, String> getStreamingText(TextConfigModel.Companion $this$streamingText) {
        Intrinsics.checkNotNullParameter($this$streamingText, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TextConfigModel, String>() { // from class: kntr.app.deepsearch.base.model.biz.TextConfigModelLensKt$special$$inlined$invoke$4
            public String get(TextConfigModel textConfigModel) {
                TextConfigModel it = textConfigModel;
                return it.getStreamingText();
            }

            public TextConfigModel set(TextConfigModel textConfigModel, String str) {
                TextConfigModel copy;
                String streamingText = str;
                TextConfigModel it = textConfigModel;
                copy = it.copy((r20 & 1) != 0 ? it.startText : null, (r20 & 2) != 0 ? it.completeText : null, (r20 & 4) != 0 ? it.streamingText : streamingText, (r20 & 8) != 0 ? it.chatBotIcon : null, (r20 & 16) != 0 ? it.navigationThinking : null, (r20 & 32) != 0 ? it.navigationAnswering : null, (r20 & 64) != 0 ? it.sessionEndInterval : 0L, (r20 & 128) != 0 ? it.treadPop : null);
                return copy;
            }

            public TextConfigModel modify(TextConfigModel textConfigModel, Function1<? super String, ? extends String> function1) {
                TextConfigModel copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                TextConfigModel it = textConfigModel;
                String streamingText = (String) function1.invoke(it.getStreamingText());
                TextConfigModel it2 = textConfigModel;
                copy = it2.copy((r20 & 1) != 0 ? it2.startText : null, (r20 & 2) != 0 ? it2.completeText : null, (r20 & 4) != 0 ? it2.streamingText : streamingText, (r20 & 8) != 0 ? it2.chatBotIcon : null, (r20 & 16) != 0 ? it2.navigationThinking : null, (r20 & 32) != 0 ? it2.navigationAnswering : null, (r20 & 64) != 0 ? it2.sessionEndInterval : 0L, (r20 & 128) != 0 ? it2.treadPop : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<TextConfigModel, String> getChatBotIcon(TextConfigModel.Companion $this$chatBotIcon) {
        Intrinsics.checkNotNullParameter($this$chatBotIcon, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TextConfigModel, String>() { // from class: kntr.app.deepsearch.base.model.biz.TextConfigModelLensKt$special$$inlined$invoke$5
            public String get(TextConfigModel textConfigModel) {
                TextConfigModel it = textConfigModel;
                return it.getChatBotIcon();
            }

            public TextConfigModel set(TextConfigModel textConfigModel, String str) {
                TextConfigModel copy;
                String chatBotIcon = str;
                TextConfigModel it = textConfigModel;
                copy = it.copy((r20 & 1) != 0 ? it.startText : null, (r20 & 2) != 0 ? it.completeText : null, (r20 & 4) != 0 ? it.streamingText : null, (r20 & 8) != 0 ? it.chatBotIcon : chatBotIcon, (r20 & 16) != 0 ? it.navigationThinking : null, (r20 & 32) != 0 ? it.navigationAnswering : null, (r20 & 64) != 0 ? it.sessionEndInterval : 0L, (r20 & 128) != 0 ? it.treadPop : null);
                return copy;
            }

            public TextConfigModel modify(TextConfigModel textConfigModel, Function1<? super String, ? extends String> function1) {
                TextConfigModel copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                TextConfigModel it = textConfigModel;
                String chatBotIcon = (String) function1.invoke(it.getChatBotIcon());
                TextConfigModel it2 = textConfigModel;
                copy = it2.copy((r20 & 1) != 0 ? it2.startText : null, (r20 & 2) != 0 ? it2.completeText : null, (r20 & 4) != 0 ? it2.streamingText : null, (r20 & 8) != 0 ? it2.chatBotIcon : chatBotIcon, (r20 & 16) != 0 ? it2.navigationThinking : null, (r20 & 32) != 0 ? it2.navigationAnswering : null, (r20 & 64) != 0 ? it2.sessionEndInterval : 0L, (r20 & 128) != 0 ? it2.treadPop : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<TextConfigModel, String> getNavigationThinking(TextConfigModel.Companion $this$navigationThinking) {
        Intrinsics.checkNotNullParameter($this$navigationThinking, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TextConfigModel, String>() { // from class: kntr.app.deepsearch.base.model.biz.TextConfigModelLensKt$special$$inlined$invoke$6
            public String get(TextConfigModel textConfigModel) {
                TextConfigModel it = textConfigModel;
                return it.getNavigationThinking();
            }

            public TextConfigModel set(TextConfigModel textConfigModel, String str) {
                TextConfigModel copy;
                String navigationThinking = str;
                TextConfigModel it = textConfigModel;
                copy = it.copy((r20 & 1) != 0 ? it.startText : null, (r20 & 2) != 0 ? it.completeText : null, (r20 & 4) != 0 ? it.streamingText : null, (r20 & 8) != 0 ? it.chatBotIcon : null, (r20 & 16) != 0 ? it.navigationThinking : navigationThinking, (r20 & 32) != 0 ? it.navigationAnswering : null, (r20 & 64) != 0 ? it.sessionEndInterval : 0L, (r20 & 128) != 0 ? it.treadPop : null);
                return copy;
            }

            public TextConfigModel modify(TextConfigModel textConfigModel, Function1<? super String, ? extends String> function1) {
                TextConfigModel copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                TextConfigModel it = textConfigModel;
                String navigationThinking = (String) function1.invoke(it.getNavigationThinking());
                TextConfigModel it2 = textConfigModel;
                copy = it2.copy((r20 & 1) != 0 ? it2.startText : null, (r20 & 2) != 0 ? it2.completeText : null, (r20 & 4) != 0 ? it2.streamingText : null, (r20 & 8) != 0 ? it2.chatBotIcon : null, (r20 & 16) != 0 ? it2.navigationThinking : navigationThinking, (r20 & 32) != 0 ? it2.navigationAnswering : null, (r20 & 64) != 0 ? it2.sessionEndInterval : 0L, (r20 & 128) != 0 ? it2.treadPop : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<TextConfigModel, String> getNavigationAnswering(TextConfigModel.Companion $this$navigationAnswering) {
        Intrinsics.checkNotNullParameter($this$navigationAnswering, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TextConfigModel, String>() { // from class: kntr.app.deepsearch.base.model.biz.TextConfigModelLensKt$special$$inlined$invoke$7
            public String get(TextConfigModel textConfigModel) {
                TextConfigModel it = textConfigModel;
                return it.getNavigationAnswering();
            }

            public TextConfigModel set(TextConfigModel textConfigModel, String str) {
                TextConfigModel copy;
                String navigationAnswering = str;
                TextConfigModel it = textConfigModel;
                copy = it.copy((r20 & 1) != 0 ? it.startText : null, (r20 & 2) != 0 ? it.completeText : null, (r20 & 4) != 0 ? it.streamingText : null, (r20 & 8) != 0 ? it.chatBotIcon : null, (r20 & 16) != 0 ? it.navigationThinking : null, (r20 & 32) != 0 ? it.navigationAnswering : navigationAnswering, (r20 & 64) != 0 ? it.sessionEndInterval : 0L, (r20 & 128) != 0 ? it.treadPop : null);
                return copy;
            }

            public TextConfigModel modify(TextConfigModel textConfigModel, Function1<? super String, ? extends String> function1) {
                TextConfigModel copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                TextConfigModel it = textConfigModel;
                String navigationAnswering = (String) function1.invoke(it.getNavigationAnswering());
                TextConfigModel it2 = textConfigModel;
                copy = it2.copy((r20 & 1) != 0 ? it2.startText : null, (r20 & 2) != 0 ? it2.completeText : null, (r20 & 4) != 0 ? it2.streamingText : null, (r20 & 8) != 0 ? it2.chatBotIcon : null, (r20 & 16) != 0 ? it2.navigationThinking : null, (r20 & 32) != 0 ? it2.navigationAnswering : navigationAnswering, (r20 & 64) != 0 ? it2.sessionEndInterval : 0L, (r20 & 128) != 0 ? it2.treadPop : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<TextConfigModel, Long> getSessionEndInterval(TextConfigModel.Companion $this$sessionEndInterval) {
        Intrinsics.checkNotNullParameter($this$sessionEndInterval, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TextConfigModel, Long>() { // from class: kntr.app.deepsearch.base.model.biz.TextConfigModelLensKt$special$$inlined$invoke$8
            public Long get(TextConfigModel textConfigModel) {
                TextConfigModel it = textConfigModel;
                return Long.valueOf(it.getSessionEndInterval());
            }

            public TextConfigModel set(TextConfigModel textConfigModel, Long l) {
                TextConfigModel copy;
                long sessionEndInterval = l.longValue();
                TextConfigModel it = textConfigModel;
                copy = it.copy((r20 & 1) != 0 ? it.startText : null, (r20 & 2) != 0 ? it.completeText : null, (r20 & 4) != 0 ? it.streamingText : null, (r20 & 8) != 0 ? it.chatBotIcon : null, (r20 & 16) != 0 ? it.navigationThinking : null, (r20 & 32) != 0 ? it.navigationAnswering : null, (r20 & 64) != 0 ? it.sessionEndInterval : sessionEndInterval, (r20 & 128) != 0 ? it.treadPop : null);
                return copy;
            }

            public TextConfigModel modify(TextConfigModel textConfigModel, Function1<? super Long, ? extends Long> function1) {
                TextConfigModel it;
                Intrinsics.checkNotNullParameter(function1, "map");
                TextConfigModel it2 = textConfigModel;
                long sessionEndInterval = ((Number) function1.invoke(Long.valueOf(it2.getSessionEndInterval()))).longValue();
                TextConfigModel it3 = textConfigModel;
                it = it3.copy((r20 & 1) != 0 ? it3.startText : null, (r20 & 2) != 0 ? it3.completeText : null, (r20 & 4) != 0 ? it3.streamingText : null, (r20 & 8) != 0 ? it3.chatBotIcon : null, (r20 & 16) != 0 ? it3.navigationThinking : null, (r20 & 32) != 0 ? it3.navigationAnswering : null, (r20 & 64) != 0 ? it3.sessionEndInterval : sessionEndInterval, (r20 & 128) != 0 ? it3.treadPop : null);
                return it;
            }
        };
    }

    public static final BSimpleLens<TextConfigModel, DeepSearchTreadPopModel> getTreadPop(TextConfigModel.Companion $this$treadPop) {
        Intrinsics.checkNotNullParameter($this$treadPop, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TextConfigModel, DeepSearchTreadPopModel>() { // from class: kntr.app.deepsearch.base.model.biz.TextConfigModelLensKt$special$$inlined$invoke$9
            public DeepSearchTreadPopModel get(TextConfigModel textConfigModel) {
                TextConfigModel it = textConfigModel;
                return it.getTreadPop();
            }

            public TextConfigModel set(TextConfigModel textConfigModel, DeepSearchTreadPopModel deepSearchTreadPopModel) {
                TextConfigModel copy;
                DeepSearchTreadPopModel treadPop = deepSearchTreadPopModel;
                TextConfigModel it = textConfigModel;
                copy = it.copy((r20 & 1) != 0 ? it.startText : null, (r20 & 2) != 0 ? it.completeText : null, (r20 & 4) != 0 ? it.streamingText : null, (r20 & 8) != 0 ? it.chatBotIcon : null, (r20 & 16) != 0 ? it.navigationThinking : null, (r20 & 32) != 0 ? it.navigationAnswering : null, (r20 & 64) != 0 ? it.sessionEndInterval : 0L, (r20 & 128) != 0 ? it.treadPop : treadPop);
                return copy;
            }

            public TextConfigModel modify(TextConfigModel textConfigModel, Function1<? super DeepSearchTreadPopModel, ? extends DeepSearchTreadPopModel> function1) {
                TextConfigModel copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                TextConfigModel it = textConfigModel;
                DeepSearchTreadPopModel treadPop = (DeepSearchTreadPopModel) function1.invoke(it.getTreadPop());
                TextConfigModel it2 = textConfigModel;
                copy = it2.copy((r20 & 1) != 0 ? it2.startText : null, (r20 & 2) != 0 ? it2.completeText : null, (r20 & 4) != 0 ? it2.streamingText : null, (r20 & 8) != 0 ? it2.chatBotIcon : null, (r20 & 16) != 0 ? it2.navigationThinking : null, (r20 & 32) != 0 ? it2.navigationAnswering : null, (r20 & 64) != 0 ? it2.sessionEndInterval : 0L, (r20 & 128) != 0 ? it2.treadPop : treadPop);
                return copy;
            }
        };
    }

    public static final <T> BSimpleLens<T, String> getStartText(BSimpleLens<T, TextConfigModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getStartText(TextConfigModel.Companion));
    }

    public static final <T> BSimpleLens<T, String> getCompleteText(BSimpleLens<T, TextConfigModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getCompleteText(TextConfigModel.Companion));
    }

    public static final <T> BSimpleLens<T, String> getStreamingText(BSimpleLens<T, TextConfigModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getStreamingText(TextConfigModel.Companion));
    }

    public static final <T> BSimpleLens<T, String> getChatBotIcon(BSimpleLens<T, TextConfigModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getChatBotIcon(TextConfigModel.Companion));
    }

    public static final <T> BSimpleLens<T, String> getNavigationThinking(BSimpleLens<T, TextConfigModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getNavigationThinking(TextConfigModel.Companion));
    }

    public static final <T> BSimpleLens<T, String> getNavigationAnswering(BSimpleLens<T, TextConfigModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getNavigationAnswering(TextConfigModel.Companion));
    }

    public static final <T> BSimpleLens<T, Long> getSessionEndInterval(BSimpleLens<T, TextConfigModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSessionEndInterval(TextConfigModel.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchTreadPopModel> getTreadPop(BSimpleLens<T, TextConfigModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getTreadPop(TextConfigModel.Companion));
    }

    public static final <T> BNullableLens<T, String> startTextNullable(BSimpleLens<T, TextConfigModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getStartText(TextConfigModel.Companion));
    }

    public static final <T> BNullableLens<T, String> completeTextNullable(BSimpleLens<T, TextConfigModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getCompleteText(TextConfigModel.Companion));
    }

    public static final <T> BNullableLens<T, String> streamingTextNullable(BSimpleLens<T, TextConfigModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getStreamingText(TextConfigModel.Companion));
    }

    public static final <T> BNullableLens<T, String> chatBotIconNullable(BSimpleLens<T, TextConfigModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getChatBotIcon(TextConfigModel.Companion));
    }

    public static final <T> BNullableLens<T, String> navigationThinkingNullable(BSimpleLens<T, TextConfigModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getNavigationThinking(TextConfigModel.Companion));
    }

    public static final <T> BNullableLens<T, String> navigationAnsweringNullable(BSimpleLens<T, TextConfigModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getNavigationAnswering(TextConfigModel.Companion));
    }

    public static final <T> BNullableLens<T, Long> sessionEndIntervalNullable(BSimpleLens<T, TextConfigModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSessionEndInterval(TextConfigModel.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchTreadPopModel> treadPopNullable(BSimpleLens<T, TextConfigModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getTreadPop(TextConfigModel.Companion));
    }

    public static final <T> BNullableLens<T, String> getStartText(BNullableLens<T, TextConfigModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getStartText(TextConfigModel.Companion));
    }

    public static final <T> BNullableLens<T, String> getCompleteText(BNullableLens<T, TextConfigModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getCompleteText(TextConfigModel.Companion));
    }

    public static final <T> BNullableLens<T, String> getStreamingText(BNullableLens<T, TextConfigModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getStreamingText(TextConfigModel.Companion));
    }

    public static final <T> BNullableLens<T, String> getChatBotIcon(BNullableLens<T, TextConfigModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getChatBotIcon(TextConfigModel.Companion));
    }

    public static final <T> BNullableLens<T, String> getNavigationThinking(BNullableLens<T, TextConfigModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getNavigationThinking(TextConfigModel.Companion));
    }

    public static final <T> BNullableLens<T, String> getNavigationAnswering(BNullableLens<T, TextConfigModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getNavigationAnswering(TextConfigModel.Companion));
    }

    public static final <T> BNullableLens<T, Long> getSessionEndInterval(BNullableLens<T, TextConfigModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSessionEndInterval(TextConfigModel.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchTreadPopModel> getTreadPop(BNullableLens<T, TextConfigModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getTreadPop(TextConfigModel.Companion));
    }
}