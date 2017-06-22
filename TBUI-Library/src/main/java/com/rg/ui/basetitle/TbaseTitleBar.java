package com.rg.ui.basetitle;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rg.ui.R;

import static android.R.attr.id;


/**
 * TbaseActivity titleBar
 * Last Update Date 2017年6月21日15:01:42
 * author @Rango
 */
public class TbaseTitleBar extends RelativeLayout implements View.OnClickListener {
    public static final int POSITION_LEFT = 101;
    public static final int POSITION_CENTER = 102;
    public static final int POSITION_RIGHT = 103;

    private RadioButton radioButtonLeft, radioButtonCenter, radioButtonRight;
    private LayoutInflater inflater;
    private RelativeLayout titleRootLayout;


    private OnTbaseTitleLeftViewClickListener onTbaseTitleLeftViewClickListener;

    private OnTbaseTitleCenterViewClickListener onTbaseTitleCenterViewClickListener;

    private OnTbaseTitleRightViewClickListener onTbaseTitleRightViewClickListener;

    public interface OnTbaseTitleLeftViewClickListener {
        void onClick(View v);
    }

    public interface OnTbaseTitleCenterViewClickListener {
        void onClick(View v);
    }

    public interface OnTbaseTitleRightViewClickListener {
        void onClick(View v);
    }

    /**
     * new  Object  in class  call this Constructor
     *
     * @param context
     */
    public TbaseTitleBar(Context context) {
        super(context);
        initLayout(context);
    }

    /**
     * Edit in XML  but no point android.style,  call this Constructor
     *
     * @param context
     * @param attrs
     */
    public TbaseTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
    }

    /**
     * Edit in XML  and point android.style,call this Constructor
     *
     * @param context
     * @param attrs    layout_width layout_height
     * @param defStyle
     */
    public TbaseTitleBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initLayout(context);
    }

    private final void initLayout(Context context) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        titleRootLayout = (RelativeLayout) inflaterView(R.layout.tbase_titlebar_layout, this, true);
        radioButtonLeft = (RadioButton) titleRootLayout.findViewById(R.id.tbase_titleLayout_left);
        radioButtonCenter = (RadioButton) titleRootLayout.findViewById(R.id.tbase_titleLayout_center);
        radioButtonRight = (RadioButton) titleRootLayout.findViewById(R.id.tbase_titleLayout_right);
        radioButtonLeft.setOnClickListener(this);
        radioButtonRight.setOnClickListener(this);
        radioButtonCenter.setOnClickListener(this);
    }

    private View inflaterView(int LayoutId, ViewGroup root, boolean attachToRoot) {
        return inflater.inflate(LayoutId, root, attachToRoot);
    }

    //-- root ------------
    public void setBackgroundDrawable(@DrawableRes int resid) {
        titleRootLayout.setBackgroundResource(resid);
    }

    public void setBackgroundColorRes(@ColorRes int resid) {
        titleRootLayout.setBackgroundResource(resid);
    }

    public void setBackgroundColorInt(@ColorInt int color) {
        titleRootLayout.setBackgroundColor(color);
    }

    // Listener-------------------------------
    public void setLeftBtnOnClickListener(@NonNull OnTbaseTitleLeftViewClickListener leftListener) {
        this.onTbaseTitleLeftViewClickListener = leftListener;
    }

    public void cancelLeftBtnOnClickListener() {
        onTbaseTitleLeftViewClickListener = null;
    }

    public void setCenterBtnOnClickListener(@NonNull OnTbaseTitleCenterViewClickListener centerViewClickListener) {
        onTbaseTitleCenterViewClickListener = centerViewClickListener;
    }

    public void cancelCenterBtnOnClickListener() {
        onTbaseTitleCenterViewClickListener = null;
    }

    public void setRightBtnOnClickListener(@NonNull OnTbaseTitleRightViewClickListener rightBtnOnClickListener) {
        onTbaseTitleRightViewClickListener = rightBtnOnClickListener;
    }

    public void cancelRightBtnOnClickListener() {
        onTbaseTitleRightViewClickListener = null;
    }

    //---- 设置字符资源
    public RadioButton setText(@StringRes int id, int position) {
        String s = getResources().getString(id);
        return setText(s, position);
    }

    public RadioButton setTitleText(@StringRes int id) {
        return setText(id, POSITION_CENTER);
    }

    public RadioButton setTitleText(@NonNull String s) {
        return setText(s, POSITION_CENTER);
    }

    public RadioButton getLeftBtn() {
        return radioButtonLeft;
    }

    public RadioButton getRightBtn() {
        return radioButtonRight;
    }

    public RadioButton getCenterBtn() {
        return radioButtonCenter;
    }

    public RadioButton setText(@NonNull String s, int position) {
        RadioButton result = null;
        switch (position) {
            case POSITION_LEFT:
                radioButtonLeft.setText(s);
                result = radioButtonLeft;
                break;
            case POSITION_CENTER:
                radioButtonCenter.setText(s);
                result = radioButtonCenter;
                break;
            case POSITION_RIGHT:
                radioButtonRight.setText(s);
                result = radioButtonCenter;
                break;
            default:
                break;
        }
        return result;
    }

    //---设置图片资源
    public RadioButton setButtonBackGroundDrawableRes(@DrawableRes int id, int position) {
        RadioButton result = null;
        switch (position) {
            case POSITION_LEFT:
                radioButtonLeft.setBackgroundResource(id);
                result = radioButtonLeft;
                break;
            case POSITION_CENTER:
                radioButtonCenter.setBackgroundResource(id);
                result = radioButtonCenter;
                break;
            case POSITION_RIGHT:
                radioButtonRight.setBackgroundResource(id);
                result = radioButtonCenter;
                break;
            default:
                break;
        }
        return result;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tbase_titleLayout_left) {
            if (null != onTbaseTitleLeftViewClickListener) {
                onTbaseTitleLeftViewClickListener.onClick(v);
            }
            return;
        }
        if (v.getId() == R.id.tbase_titleLayout_center) {
            if (null != onTbaseTitleCenterViewClickListener) {
                onTbaseTitleCenterViewClickListener.onClick(v);
            }
            return;
        }
        if (v.getId() == R.id.tbase_titleLayout_right) {
            if (null != onTbaseTitleRightViewClickListener) {
                onTbaseTitleRightViewClickListener.onClick(v);
            }
            return;
        }

    }
}
