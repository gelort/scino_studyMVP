package com.gelort.studymvp.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gelort.studymvp.R;
import com.gelort.studymvp.data.entity.Repository;
import com.google.common.collect.Lists;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gelort on 08.08.2016.
 */

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.ViewHolder> {

    private List<Repository> mItems;

    public RepositoryAdapter() {
        mItems = Lists.newArrayList();
    }

    public void setItems(List<Repository> items) {
        this.mItems.addAll(items);
    }

    @Override
    public RepositoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repository_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepositoryAdapter.ViewHolder holder, int position) {
        Repository repository = mItems.get(position);

        holder.repositoryName.setText(repository.getName());
    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.repository_title)
        TextView repositoryName;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
