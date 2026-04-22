package tv.danmaku.bili.ui.favorite.cheesesupport;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorite.cheesesupport.CheeseListAdapter;
import tv.danmaku.bili.widget.recycler.DividerDecoration;

/* compiled from: CheeseListDividerLine.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseListDividerLine;", "Ltv/danmaku/bili/widget/recycler/DividerDecoration;", "dividerColor", "", "dividerHeight", "dividerLeftSpace", "horizontalRightSpacingPx", "<init>", "(IIII)V", "needDrawDivider", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CheeseListDividerLine extends DividerDecoration {
    public static final int $stable = 8;

    public CheeseListDividerLine(int dividerColor, int dividerHeight, int dividerLeftSpace, int horizontalRightSpacingPx) {
        super(dividerColor, dividerHeight, dividerLeftSpace, horizontalRightSpacingPx);
    }

    protected boolean needDrawDivider(RecyclerView.ViewHolder holder) {
        return holder instanceof CheeseListAdapter.CheeseHolder;
    }
}