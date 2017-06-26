package rango.ui.function;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import rango.tbaseui.R;

/**
 * Create on 2017/6/21.
 * github  https://github.com/HarkBen
 * Description:
 * -----------
 * author Ben
 * Last_Update - 2017/6/21
 */
public class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.MyViewHolder> {
    private List<FunctionListBean> datas;
    private Context context;
    @Nullable
    private OnItemClickListener onItemClickListener = null;

    public FunctionAdapter(List<FunctionListBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_function, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv.setText(datas.get(position).getFunctionName());
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null != onItemClickListener)
                onItemClickListener.onItemClick(datas.get(position), v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
   public  interface OnItemClickListener {
        void onItemClick(FunctionListBean bean, View view);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.if_tv_name);
        }
    }
}
