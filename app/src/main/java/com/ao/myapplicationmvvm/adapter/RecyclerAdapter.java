package com.ao.myapplicationmvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


import com.ao.myapplicationmvvm.R;
import com.ao.myapplicationmvvm.pojo.ResponseModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

	private static final String TAG = RecyclerAdapter.class.getSimpleName();

	//private Context context;
	protected List<ResponseModel> list;
	public OnItemClickListenerView onItemClickListener;


	/*public RecyclerAdapter(List<ResponseModel> list) {
		this.list = list;
	}*/

	public void setListDta(List<ResponseModel> list){
		this.list = list;
		notifyDataSetChanged();
		
	}


	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
		ViewHolder viewHolder = new ViewHolder(view);
		return viewHolder;
	}


	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {

		ResponseModel item = list.get(position);
		holder.textView.setText(item.getBody());
		/*holder.textView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(v.getContext(), ""+position, Toast.LENGTH_SHORT).show();
			}
		});*/
		if (onItemClickListener != null) {
			holder.itemView.setOnClickListener(v -> {

				onItemClickListener.onItemClick(position);
			});
		}


	}


	@Override
	public int getItemCount() {
		//return iterator
		return list == null ? 0 : list.size();

	}

	public void setOnItemClickListener(OnItemClickListenerView onItemClickListener) {
		this.onItemClickListener = onItemClickListener;
	}

	public interface OnItemClickListenerView {
		void onItemClick(int position);
	}


	public static class ViewHolder extends RecyclerView.ViewHolder {
		//ViewHolder
		TextView textView;

		public ViewHolder(View itemView) {
			super(itemView);

				textView = itemView.findViewById(R.id.textViewRe);

		}
	}
}