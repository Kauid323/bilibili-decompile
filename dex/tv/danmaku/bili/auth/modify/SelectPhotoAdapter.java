package tv.danmaku.bili.auth.modify;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.auth.R;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.image2.view.BiliImageView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: SelectPhotoAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u000bJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\tJ\u0006\u0010\u001c\u001a\u00020\tJ\u0006\u0010\u001d\u001a\u00020\u0011J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Ltv/danmaku/bili/auth/modify/SelectPhotoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "photoList", "", "Ltv/danmaku/bili/auth/modify/UploadPhotoData;", "mMaxNum", "", "mListener", "Ltv/danmaku/bili/auth/modify/SelectPhotoListener;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "getItemViewType", "addPhoto", "photo", "setListener", "listener", "setMaxNum", "num", "getMaxNum", "checkAlubmHolder", "getPhotoList", "SelectPhotoHolder", "OpenAlbumHolder", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SelectPhotoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private SelectPhotoListener mListener;
    private List<UploadPhotoData> photoList = CollectionsKt.mutableListOf(new UploadPhotoData[]{new UploadPhotoData().setTag(PhotoType.ALBUM)});
    private int mMaxNum = 3;

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == PhotoType.PHOTO.getValue()) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_layout_photo, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new SelectPhotoHolder(inflate);
        }
        View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_layout_album, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
        return new OpenAlbumHolder(inflate2);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof SelectPhotoHolder) {
            BiliImageView $this$onBindViewHolder_u24lambda_u240 = ((SelectPhotoHolder) holder).getImage();
            $this$onBindViewHolder_u24lambda_u240.setImageURI(this.photoList.get(position).getMUri());
            $this$onBindViewHolder_u24lambda_u240.setBackgroundDrawable(FoundationAlias.getFapp().getDrawable(R.drawable.auth_img_bg));
            ImageView $this$onBindViewHolder_u24lambda_u241 = ((SelectPhotoHolder) holder).getDeleteBtn();
            $this$onBindViewHolder_u24lambda_u241.bringToFront();
            $this$onBindViewHolder_u24lambda_u241.setVisibility(0);
            $this$onBindViewHolder_u24lambda_u241.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.auth.modify.SelectPhotoAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectPhotoAdapter.onBindViewHolder$lambda$1$0(SelectPhotoAdapter.this, position, view);
                }
            });
        } else if (holder instanceof OpenAlbumHolder) {
            OpenAlbumHolder $this$onBindViewHolder_u24lambda_u242 = (OpenAlbumHolder) holder;
            $this$onBindViewHolder_u24lambda_u242.getPhotoNumTv().setText((this.photoList.size() - 1) + "/" + this.mMaxNum);
            $this$onBindViewHolder_u24lambda_u242.getContainer().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.auth.modify.SelectPhotoAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectPhotoAdapter.onBindViewHolder$lambda$2$0(SelectPhotoAdapter.this, view);
                }
            });
            ImageView $this$onBindViewHolder_u24lambda_u242_u241 = $this$onBindViewHolder_u24lambda_u242.getImage();
            $this$onBindViewHolder_u24lambda_u242_u241.setVisibility(0);
            $this$onBindViewHolder_u24lambda_u242_u241.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.auth.modify.SelectPhotoAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectPhotoAdapter.onBindViewHolder$lambda$2$1$0(SelectPhotoAdapter.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$0(SelectPhotoAdapter this$0, int $position, View it) {
        this$0.photoList.remove($position);
        this$0.checkAlubmHolder();
        this$0.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2$0(SelectPhotoAdapter this$0, View it) {
        SelectPhotoListener selectPhotoListener = this$0.mListener;
        if (selectPhotoListener != null) {
            selectPhotoListener.openAblum(this$0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2$1$0(SelectPhotoAdapter this$0, View it) {
        SelectPhotoListener selectPhotoListener = this$0.mListener;
        if (selectPhotoListener != null) {
            selectPhotoListener.openAblum(this$0);
        }
    }

    public int getItemCount() {
        return this.photoList.size();
    }

    public int getItemViewType(int position) {
        return this.photoList.get(position).getTag().getValue();
    }

    public final SelectPhotoAdapter addPhoto(UploadPhotoData photo) {
        Intrinsics.checkNotNullParameter(photo, "photo");
        this.photoList.add(this.photoList.size() - 1, photo);
        checkAlubmHolder();
        notifyDataSetChanged();
        return this;
    }

    public final SelectPhotoAdapter setListener(SelectPhotoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListener = listener;
        return this;
    }

    public final SelectPhotoAdapter setMaxNum(int num) {
        this.mMaxNum = num;
        return this;
    }

    public final int getMaxNum() {
        return this.mMaxNum;
    }

    public final void checkAlubmHolder() {
        if (this.photoList == null) {
            return;
        }
        if (this.photoList.size() == 0) {
            this.photoList.add(new UploadPhotoData().setTag(PhotoType.ALBUM));
        } else if (this.photoList.size() > this.mMaxNum && this.photoList.get(this.photoList.size() - 1).getTag() == PhotoType.ALBUM) {
            this.photoList.remove(this.photoList.size() - 1);
        } else if (this.photoList.size() < this.mMaxNum && this.photoList.get(this.photoList.size() - 1).getTag() != PhotoType.ALBUM) {
            this.photoList.add(new UploadPhotoData().setTag(PhotoType.ALBUM));
        }
    }

    public final List<UploadPhotoData> getPhotoList() {
        if (this.photoList.get(this.photoList.size() - 1).getTag() == PhotoType.ALBUM) {
            this.photoList.remove(this.photoList.size() - 1);
        }
        return this.photoList;
    }

    /* compiled from: SelectPhotoAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/auth/modify/SelectPhotoAdapter$SelectPhotoHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "image", "Lcom/bilibili/lib/image2/view/BiliImageView;", "getImage", "()Lcom/bilibili/lib/image2/view/BiliImageView;", "deleteBtn", "Landroid/widget/ImageView;", "getDeleteBtn", "()Landroid/widget/ImageView;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SelectPhotoHolder extends RecyclerView.ViewHolder {
        private final ImageView deleteBtn;
        private final BiliImageView image;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectPhotoHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            BiliImageView findViewById = itemView.findViewById(R.id.image);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.image = findViewById;
            View findViewById2 = itemView.findViewById(R.id.btn_delete);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.deleteBtn = (ImageView) findViewById2;
        }

        public final BiliImageView getImage() {
            return this.image;
        }

        public final ImageView getDeleteBtn() {
            return this.deleteBtn;
        }
    }

    /* compiled from: SelectPhotoAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/auth/modify/SelectPhotoAdapter$OpenAlbumHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "image", "Landroid/widget/ImageView;", "getImage", "()Landroid/widget/ImageView;", "photoNumTv", "Landroid/widget/TextView;", "getPhotoNumTv", "()Landroid/widget/TextView;", "container", "Landroid/widget/LinearLayout;", "getContainer", "()Landroid/widget/LinearLayout;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class OpenAlbumHolder extends RecyclerView.ViewHolder {
        private final LinearLayout container;
        private final ImageView image;
        private final TextView photoNumTv;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenAlbumHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.img);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.image = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.tv_number);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.photoNumTv = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.select_container);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.container = (LinearLayout) findViewById3;
        }

        public final ImageView getImage() {
            return this.image;
        }

        public final TextView getPhotoNumTv() {
            return this.photoNumTv;
        }

        public final LinearLayout getContainer() {
            return this.container;
        }
    }
}