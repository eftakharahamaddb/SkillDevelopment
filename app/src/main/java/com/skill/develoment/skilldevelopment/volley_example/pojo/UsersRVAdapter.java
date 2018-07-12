package com.skill.develoment.skilldevelopment.volley_example.pojo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.skill.develoment.skilldevelopment.R;
import com.skill.develoment.skilldevelopment.volley_example.RequestStandard;
import com.skill.develoment.skilldevelopment.volley_example.VolleyExample;
import com.skill.develoment.skilldevelopment.volley_example.VolleyInstance;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsersRVAdapter extends RecyclerView.Adapter<UsersRVAdapter.ViewHolder> {
    private ArrayList<User> users;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.login)
        public TextView login;
        @BindView(R.id.node_id)
        public TextView node;
        @BindView(R.id.avatar)
        public NetworkImageView avatar;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public UsersRVAdapter(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.login.setText("" + users.get(position).getLogin());
        holder.node.setText("" + users.get(position).getNodeId());
        RequestStandard.loadImage(users.get(position).getAvatarUrl(), holder.avatar, holder.avatar.getContext());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
