package tv.danmaku.bili.ui.filechooser;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ListView;
import androidx.fragment.app.ListFragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import bili.resource.homepage.R;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.lib.ui.PermissionsChecker;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import java.io.File;
import java.util.List;

public class FileListFragment extends ListFragment implements LoaderManager.LoaderCallbacks<List<File>> {
    private static final int LOADER_ID = 0;
    private static final int REQUEST_CODE_STORAGE = 1;
    private FileListAdapter mAdapter;
    private Callbacks mListener;
    private String mPath;

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface Callbacks {
        void onFileSelected(File file);
    }

    public /* bridge */ /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        onLoadFinished((Loader<List<File>>) loader, (List) obj);
    }

    public static FileListFragment newInstance(String path) {
        FileListFragment fragment = new FileListFragment();
        Bundle args = new Bundle();
        args.putString(FileChooserActivity.PATH, path);
        fragment.setArguments(args);
        return fragment;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.mListener = (Callbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement FileListFragment.Callbacks");
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mAdapter = new FileListAdapter(getActivity());
        this.mPath = getArguments() != null ? getArguments().getString(FileChooserActivity.PATH) : Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setEmptyText(getString(R.string.homepage_global_string_153));
        setListAdapter(this.mAdapter);
        setListShown(false);
        PermissionsChecker.grantExternalPermissions(this, false).continueWith(new Continuation<Void, Void>() { // from class: tv.danmaku.bili.ui.filechooser.FileListFragment.1
            public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                return m1687then((Task<Void>) task);
            }

            /* renamed from: then  reason: collision with other method in class */
            public Void m1687then(Task<Void> task) throws Exception {
                if (task.isFaulted() || task.isCancelled()) {
                    FileListFragment.this.setEmptyText(FileListFragment.this.getString(R.string.homepage_global_string_238));
                    FileListFragment.this.setListShown(true);
                    PermissionsChecker.checkShowStoragePermissionAlert(FileListFragment.this.getActivity(), "");
                } else {
                    FileListFragment.this.getLoaderManager().initLoader(0, (Bundle) null, FileListFragment.this);
                }
                return null;
            }
        }, UiThreadImmediateExecutorService.getInstance());
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionsChecker.onPermissionResult(requestCode, permissions, grantResults);
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        FileListAdapter adapter = (FileListAdapter) l.getAdapter();
        if (adapter != null) {
            File file = adapter.getItem(position);
            this.mPath = file.getAbsolutePath();
            this.mListener.onFileSelected(file);
        }
    }

    public Loader<List<File>> onCreateLoader(int id, Bundle args) {
        return new FileLoader(getActivity(), this.mPath);
    }

    public void onLoadFinished(Loader<List<File>> loader, List<File> data) {
        this.mAdapter.setListItems(data);
        if (isResumed()) {
            setListShown(true);
        } else {
            setListShownNoAnimation(true);
        }
    }

    public void onLoaderReset(Loader<List<File>> loader) {
        this.mAdapter.clear();
    }
}