package com.visitshopdemo.activity;

import android.app.ProgressDialog;

import com.qk.applibrary.view.BaseActivity;

/**
 * 功能:activity基类
 */
public abstract class HouseResourceBaseActivity extends BaseActivity {
    private ProgressDialog loadingProgressDialog;

       /**
     * 打开加载框,用于调用接口弹出的对话框
     *
     * @param title
     * @param message
     * @return
     */
    @Override
    public ProgressDialog showProgressDialog(String title, String message) {
        try {
            if (isFinishing() == false) {
                if (loadingProgressDialog == null) {
                    loadingProgressDialog = ProgressDialog.show(this, title,
                            message);

                    loadingProgressDialog.setCancelable(false);
                    loadingProgressDialog.setCanceledOnTouchOutside(false);
                } else {
                    loadingProgressDialog.setTitle(title);
                    loadingProgressDialog.setMessage(message);
                    if (loadingProgressDialog.isShowing() == false) {
                        loadingProgressDialog.show();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadingProgressDialog;
    }

    @Override
    public void dissmissProgressDialog() {
        try {
            if (isFinishing() == false && loadingProgressDialog != null) {
                loadingProgressDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
