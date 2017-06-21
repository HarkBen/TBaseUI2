package rango.ui.function;

import android.os.Bundle;

import com.rg.ui.baseactivity.TBaseActivity;
import com.rg.ui.basetitle.TbaseTitleBar;

/**
 * Create on 2017/6/21.
 * github  https://github.com/HarkBen
 * Description:
 * -----------
 * author Ben
 * Last_Update - 2017/6/21
 */
public class UpdateVersionAct extends TBaseActivity {
    @Override
    public void onLayoutLoaded(Bundle savedInstanceState) {
        getTitleBar().setText("使用更新", TbaseTitleBar.POSITION_CENTER);

    }
}
