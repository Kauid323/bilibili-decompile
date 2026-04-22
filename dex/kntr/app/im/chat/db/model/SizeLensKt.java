package kntr.app.im.chat.db.model;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.im.chat.db.model.Size;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SizeLens.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u000f*\u00020\u0010*\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u000f*\u00020\u0010*\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0011\u001a\u0004\b\u000e\u0010\u0012\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u00020\t0\u0013\"\b\b\u0000\u0010\u000f*\u00020\u0010*\u0010\u0012\u0004\u0012\u0002H\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u00020\t0\u0013\"\b\b\u0000\u0010\u000f*\u00020\u0010*\u0010\u0012\u0004\u0012\u0002H\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0016\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u00020\t0\u0013\"\b\b\u0000\u0010\u000f*\u00020\u0010*\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u00020\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0019\u001a\u0004\b\u000b\u0010\u001a\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u00020\t0\u0013\"\b\b\u0000\u0010\u000f*\u00020\u0010*\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u00020\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0019\u001a\u0004\b\u000e\u0010\u001a¨\u0006\u001b"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/im/chat/db/model/Size;", "Lkntr/app/im/chat/db/model/Size$Companion;", "getLens$annotations", "(Lkntr/app/im/chat/db/model/Size$Companion;)V", "getLens", "(Lkntr/app/im/chat/db/model/Size$Companion;)Lcom/bilibili/blens/BSimpleLens;", "width", RoomRecommendViewModel.EMPTY_CURSOR, "getWidth$annotations", "getWidth", "height", "getHeight$annotations", "getHeight", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "widthNullable$annotations", "widthNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "heightNullable$annotations", "heightNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "db_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SizeLensKt {
    public static /* synthetic */ void getHeight$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getHeight$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getHeight$annotations(Size.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(Size.Companion companion) {
    }

    public static /* synthetic */ void getWidth$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getWidth$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getWidth$annotations(Size.Companion companion) {
    }

    public static /* synthetic */ void heightNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void widthNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<Size, Size> getLens(Size.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<Size, Size>() { // from class: kntr.app.im.chat.db.model.SizeLensKt$special$$inlined$invoke$1
            public Size get(Size size) {
                Size it = size;
                return it;
            }

            public Size set(Size size, Size size2) {
                Size it = size2;
                return it;
            }

            public Size modify(Size size, Function1<? super Size, ? extends Size> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                Size it = size;
                return (Size) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<Size, Float> getWidth(Size.Companion $this$width) {
        Intrinsics.checkNotNullParameter($this$width, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<Size, Float>() { // from class: kntr.app.im.chat.db.model.SizeLensKt$special$$inlined$invoke$2
            public Float get(Size size) {
                Size it = size;
                return Float.valueOf(it.getWidth());
            }

            public Size set(Size size, Float f) {
                float width = f.floatValue();
                Size it = size;
                return Size.copy$default(it, width, 0.0f, 2, null);
            }

            public Size modify(Size size, Function1<? super Float, ? extends Float> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                Size it = size;
                float width = ((Number) function1.invoke(Float.valueOf(it.getWidth()))).floatValue();
                Size it2 = size;
                return Size.copy$default(it2, width, 0.0f, 2, null);
            }
        };
    }

    public static final BSimpleLens<Size, Float> getHeight(Size.Companion $this$height) {
        Intrinsics.checkNotNullParameter($this$height, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<Size, Float>() { // from class: kntr.app.im.chat.db.model.SizeLensKt$special$$inlined$invoke$3
            public Float get(Size size) {
                Size it = size;
                return Float.valueOf(it.getHeight());
            }

            public Size set(Size size, Float f) {
                float height = f.floatValue();
                Size it = size;
                return Size.copy$default(it, 0.0f, height, 1, null);
            }

            public Size modify(Size size, Function1<? super Float, ? extends Float> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                Size it = size;
                float height = ((Number) function1.invoke(Float.valueOf(it.getHeight()))).floatValue();
                Size it2 = size;
                return Size.copy$default(it2, 0.0f, height, 1, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, Float> getWidth(BSimpleLens<T, Size> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getWidth(Size.Companion));
    }

    public static final <T> BSimpleLens<T, Float> getHeight(BSimpleLens<T, Size> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getHeight(Size.Companion));
    }

    public static final <T> BNullableLens<T, Float> widthNullable(BSimpleLens<T, Size> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getWidth(Size.Companion));
    }

    public static final <T> BNullableLens<T, Float> heightNullable(BSimpleLens<T, Size> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getHeight(Size.Companion));
    }

    public static final <T> BNullableLens<T, Float> getWidth(BNullableLens<T, Size> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getWidth(Size.Companion));
    }

    public static final <T> BNullableLens<T, Float> getHeight(BNullableLens<T, Size> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getHeight(Size.Companion));
    }
}