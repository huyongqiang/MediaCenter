/**
 * 
 */
package com.rockchips.mediacenter.view;
import org.xutils.view.annotation.ViewInject;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rockchips.mediacenter.R;
/**
 * @author GaoFei
 * 文件删除提示对话框
 */
public class FileDeleteTipDialog extends AppBaseDialog implements View.OnClickListener, DialogInterface.OnDismissListener{
	
	@ViewInject(R.id.btn_ok)
	private Button mBtnOK;
	@ViewInject(R.id.btn_cancel)
	private Button mBtnCancel;
	@ViewInject(R.id.text_title)
	private TextView mTextConfirmDelete;
	private String mTipText;
	private boolean mIsOK;
	public interface CallBack{
		void onOK();
		void onCancel();
	}
	
	private CallBack mCallBack;
	
	public FileDeleteTipDialog(Context context, CallBack callBack) {
		super(context);
		mCallBack = callBack;
	}

	@Override
	public int getLayoutRes() {
		return R.layout.dialog_file_delete_tip;
	}

	@Override
	public void initData() {
		if(mTipText != null)
			mTextConfirmDelete.setText(mTipText);
	}

	@Override
	public void initEvent() {
		mBtnOK.setOnClickListener(this);
		mBtnCancel.setOnClickListener(this);
		setOnDismissListener(this);
	}

	@Override
	public void onClick(View view) {
		if(view.getId() == R.id.btn_ok){
			mIsOK = true;
			dismiss();
		}else{
			dismiss();
		}
	}
	
	@Override
	public void onDismiss(DialogInterface dialog) {
		if(mIsOK)
			mCallBack.onOK();
		else
			mCallBack.onCancel();
	}
	
	public void setTipText(String tipText){
		mTipText = tipText;
	}
}
