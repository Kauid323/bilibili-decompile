package tv.danmaku.bili.widget;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

public class ActionModeNoOpCallback implements ActionMode.Callback {
    private static volatile ActionModeNoOpCallback instance;

    public static ActionModeNoOpCallback getInstance() {
        if (instance == null) {
            synchronized (ActionModeNoOpCallback.class) {
                if (instance == null) {
                    instance = new ActionModeNoOpCallback();
                }
            }
        }
        return instance;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode mode) {
    }
}