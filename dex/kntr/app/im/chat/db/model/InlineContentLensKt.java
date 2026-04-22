package kntr.app.im.chat.db.model;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.db.model.InlineContent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InlineContentLens.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"*\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007\"*\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00180\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007\"*\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010 \u001a\u0004\b\u000b\u0010!\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010 \u001a\u0004\b\u000f\u0010!\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010 \u001a\u0004\b\u0012\u0010!\"@\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00140\u0001\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010 \u001a\u0004\b\u0016\u0010!\"@\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00180\u0001\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010 \u001a\u0004\b\u001a\u0010!\"@\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010 \u001a\u0004\b\u001d\u0010!\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u0010\u0012\u0004\u0012\u0002H\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010 \u001a\u0004\b$\u0010%\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\r0\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u0010\u0012\u0004\u0012\u0002H\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010 \u001a\u0004\b'\u0010%\"B\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u0010\u0012\u0004\u0012\u0002H\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010 \u001a\u0004\b)\u0010%\"B\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00140\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u0010\u0012\u0004\u0012\u0002H\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010 \u001a\u0004\b+\u0010%\"B\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00180\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u0010\u0012\u0004\u0012\u0002H\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010 \u001a\u0004\b-\u0010%\"B\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u0010\u0012\u0004\u0012\u0002H\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010 \u001a\u0004\b/\u0010%\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\"8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u00100\u001a\u0004\b\u000b\u00101\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\r0\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\"8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u00100\u001a\u0004\b\u000f\u00101\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\"8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u00100\u001a\u0004\b\u0012\u00101\"@\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00140\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\"8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u00100\u001a\u0004\b\u0016\u00101\"@\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00180\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\"8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u00100\u001a\u0004\b\u001a\u00101\"@\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\"8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u00100\u001a\u0004\b\u001d\u00101¨\u00062"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/im/chat/db/model/InlineContent;", "Lkntr/app/im/chat/db/model/InlineContent$Companion;", "getLens$annotations", "(Lkntr/app/im/chat/db/model/InlineContent$Companion;)V", "getLens", "(Lkntr/app/im/chat/db/model/InlineContent$Companion;)Lcom/bilibili/blens/BSimpleLens;", ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "getId$annotations", "getId", "size", "Lkntr/app/im/chat/db/model/Size;", "getSize$annotations", "getSize", "url", "getUrl$annotations", "getUrl", "offset", RoomRecommendViewModel.EMPTY_CURSOR, "getOffset$annotations", "getOffset", "animated", RoomRecommendViewModel.EMPTY_CURSOR, "getAnimated$annotations", "getAnimated", "rawText", "getRawText$annotations", "getRawText", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "idNullable$annotations", "idNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "sizeNullable$annotations", "sizeNullable", "urlNullable$annotations", "urlNullable", "offsetNullable$annotations", "offsetNullable", "animatedNullable$annotations", "animatedNullable", "rawTextNullable$annotations", "rawTextNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "db_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InlineContentLensKt {
    public static /* synthetic */ void animatedNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getAnimated$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getAnimated$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getAnimated$annotations(InlineContent.Companion companion) {
    }

    public static /* synthetic */ void getId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getId$annotations(InlineContent.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(InlineContent.Companion companion) {
    }

    public static /* synthetic */ void getOffset$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getOffset$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getOffset$annotations(InlineContent.Companion companion) {
    }

    public static /* synthetic */ void getRawText$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getRawText$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getRawText$annotations(InlineContent.Companion companion) {
    }

    public static /* synthetic */ void getSize$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSize$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSize$annotations(InlineContent.Companion companion) {
    }

    public static /* synthetic */ void getUrl$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getUrl$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getUrl$annotations(InlineContent.Companion companion) {
    }

    public static /* synthetic */ void idNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void offsetNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void rawTextNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void sizeNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void urlNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<InlineContent, InlineContent> getLens(InlineContent.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InlineContent, InlineContent>() { // from class: kntr.app.im.chat.db.model.InlineContentLensKt$special$$inlined$invoke$1
            public InlineContent get(InlineContent inlineContent) {
                InlineContent it = inlineContent;
                return it;
            }

            public InlineContent set(InlineContent inlineContent, InlineContent inlineContent2) {
                InlineContent it = inlineContent2;
                return it;
            }

            public InlineContent modify(InlineContent inlineContent, Function1<? super InlineContent, ? extends InlineContent> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InlineContent it = inlineContent;
                return (InlineContent) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<InlineContent, String> getId(InlineContent.Companion $this$id) {
        Intrinsics.checkNotNullParameter($this$id, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InlineContent, String>() { // from class: kntr.app.im.chat.db.model.InlineContentLensKt$special$$inlined$invoke$2
            public String get(InlineContent inlineContent) {
                InlineContent it = inlineContent;
                return it.getId();
            }

            public InlineContent set(InlineContent inlineContent, String str) {
                String id = str;
                InlineContent it = inlineContent;
                return InlineContent.copy$default(it, id, null, null, 0, false, null, 62, null);
            }

            public InlineContent modify(InlineContent inlineContent, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InlineContent it = inlineContent;
                String id = (String) function1.invoke(it.getId());
                InlineContent it2 = inlineContent;
                return InlineContent.copy$default(it2, id, null, null, 0, false, null, 62, null);
            }
        };
    }

    public static final BSimpleLens<InlineContent, Size> getSize(InlineContent.Companion $this$size) {
        Intrinsics.checkNotNullParameter($this$size, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InlineContent, Size>() { // from class: kntr.app.im.chat.db.model.InlineContentLensKt$special$$inlined$invoke$3
            public Size get(InlineContent inlineContent) {
                InlineContent it = inlineContent;
                return it.getSize();
            }

            public InlineContent set(InlineContent inlineContent, Size size) {
                Size size2 = size;
                InlineContent it = inlineContent;
                return InlineContent.copy$default(it, null, size2, null, 0, false, null, 61, null);
            }

            public InlineContent modify(InlineContent inlineContent, Function1<? super Size, ? extends Size> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InlineContent it = inlineContent;
                Size size = (Size) function1.invoke(it.getSize());
                InlineContent it2 = inlineContent;
                return InlineContent.copy$default(it2, null, size, null, 0, false, null, 61, null);
            }
        };
    }

    public static final BSimpleLens<InlineContent, String> getUrl(InlineContent.Companion $this$url) {
        Intrinsics.checkNotNullParameter($this$url, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InlineContent, String>() { // from class: kntr.app.im.chat.db.model.InlineContentLensKt$special$$inlined$invoke$4
            public String get(InlineContent inlineContent) {
                InlineContent it = inlineContent;
                return it.getUrl();
            }

            public InlineContent set(InlineContent inlineContent, String str) {
                String url = str;
                InlineContent it = inlineContent;
                return InlineContent.copy$default(it, null, null, url, 0, false, null, 59, null);
            }

            public InlineContent modify(InlineContent inlineContent, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InlineContent it = inlineContent;
                String url = (String) function1.invoke(it.getUrl());
                InlineContent it2 = inlineContent;
                return InlineContent.copy$default(it2, null, null, url, 0, false, null, 59, null);
            }
        };
    }

    public static final BSimpleLens<InlineContent, Integer> getOffset(InlineContent.Companion $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InlineContent, Integer>() { // from class: kntr.app.im.chat.db.model.InlineContentLensKt$special$$inlined$invoke$5
            public Integer get(InlineContent inlineContent) {
                InlineContent it = inlineContent;
                return Integer.valueOf(it.getOffset());
            }

            public InlineContent set(InlineContent inlineContent, Integer num) {
                int offset = num.intValue();
                InlineContent it = inlineContent;
                return InlineContent.copy$default(it, null, null, null, offset, false, null, 55, null);
            }

            public InlineContent modify(InlineContent inlineContent, Function1<? super Integer, ? extends Integer> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InlineContent it = inlineContent;
                int offset = ((Number) function1.invoke(Integer.valueOf(it.getOffset()))).intValue();
                InlineContent it2 = inlineContent;
                return InlineContent.copy$default(it2, null, null, null, offset, false, null, 55, null);
            }
        };
    }

    public static final BSimpleLens<InlineContent, Boolean> getAnimated(InlineContent.Companion $this$animated) {
        Intrinsics.checkNotNullParameter($this$animated, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InlineContent, Boolean>() { // from class: kntr.app.im.chat.db.model.InlineContentLensKt$special$$inlined$invoke$6
            public Boolean get(InlineContent inlineContent) {
                InlineContent it = inlineContent;
                return Boolean.valueOf(it.getAnimated());
            }

            public InlineContent set(InlineContent inlineContent, Boolean bool) {
                boolean animated = bool.booleanValue();
                InlineContent it = inlineContent;
                return InlineContent.copy$default(it, null, null, null, 0, animated, null, 47, null);
            }

            public InlineContent modify(InlineContent inlineContent, Function1<? super Boolean, ? extends Boolean> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InlineContent it = inlineContent;
                boolean animated = ((Boolean) function1.invoke(Boolean.valueOf(it.getAnimated()))).booleanValue();
                InlineContent it2 = inlineContent;
                return InlineContent.copy$default(it2, null, null, null, 0, animated, null, 47, null);
            }
        };
    }

    public static final BSimpleLens<InlineContent, String> getRawText(InlineContent.Companion $this$rawText) {
        Intrinsics.checkNotNullParameter($this$rawText, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InlineContent, String>() { // from class: kntr.app.im.chat.db.model.InlineContentLensKt$special$$inlined$invoke$7
            public String get(InlineContent inlineContent) {
                InlineContent it = inlineContent;
                return it.getRawText();
            }

            public InlineContent set(InlineContent inlineContent, String str) {
                String rawText = str;
                InlineContent it = inlineContent;
                return InlineContent.copy$default(it, null, null, null, 0, false, rawText, 31, null);
            }

            public InlineContent modify(InlineContent inlineContent, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InlineContent it = inlineContent;
                String rawText = (String) function1.invoke(it.getRawText());
                InlineContent it2 = inlineContent;
                return InlineContent.copy$default(it2, null, null, null, 0, false, rawText, 31, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, String> getId(BSimpleLens<T, InlineContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getId(InlineContent.Companion));
    }

    public static final <T> BSimpleLens<T, Size> getSize(BSimpleLens<T, InlineContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSize(InlineContent.Companion));
    }

    public static final <T> BSimpleLens<T, String> getUrl(BSimpleLens<T, InlineContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getUrl(InlineContent.Companion));
    }

    public static final <T> BSimpleLens<T, Integer> getOffset(BSimpleLens<T, InlineContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getOffset(InlineContent.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getAnimated(BSimpleLens<T, InlineContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getAnimated(InlineContent.Companion));
    }

    public static final <T> BSimpleLens<T, String> getRawText(BSimpleLens<T, InlineContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getRawText(InlineContent.Companion));
    }

    public static final <T> BNullableLens<T, String> idNullable(BSimpleLens<T, InlineContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getId(InlineContent.Companion));
    }

    public static final <T> BNullableLens<T, Size> sizeNullable(BSimpleLens<T, InlineContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSize(InlineContent.Companion));
    }

    public static final <T> BNullableLens<T, String> urlNullable(BSimpleLens<T, InlineContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getUrl(InlineContent.Companion));
    }

    public static final <T> BNullableLens<T, Integer> offsetNullable(BSimpleLens<T, InlineContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getOffset(InlineContent.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> animatedNullable(BSimpleLens<T, InlineContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getAnimated(InlineContent.Companion));
    }

    public static final <T> BNullableLens<T, String> rawTextNullable(BSimpleLens<T, InlineContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getRawText(InlineContent.Companion));
    }

    public static final <T> BNullableLens<T, String> getId(BNullableLens<T, InlineContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getId(InlineContent.Companion));
    }

    public static final <T> BNullableLens<T, Size> getSize(BNullableLens<T, InlineContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSize(InlineContent.Companion));
    }

    public static final <T> BNullableLens<T, String> getUrl(BNullableLens<T, InlineContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getUrl(InlineContent.Companion));
    }

    public static final <T> BNullableLens<T, Integer> getOffset(BNullableLens<T, InlineContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getOffset(InlineContent.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getAnimated(BNullableLens<T, InlineContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getAnimated(InlineContent.Companion));
    }

    public static final <T> BNullableLens<T, String> getRawText(BNullableLens<T, InlineContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getRawText(InlineContent.Companion));
    }
}