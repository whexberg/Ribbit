package com.whexberg.ribbit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseUser;
import com.squareup.picasso.Picasso;
import com.whexberg.ribbit.R;
import com.whexberg.ribbit.utils.MD5Util;

import java.util.List;

/**
 * Created by william on 12/17/15.
 */
public class UserAdapter extends ArrayAdapter<ParseUser> {

    protected Context mContext;
    protected List<ParseUser> mUsers;
    protected GridView mGridView;

    public UserAdapter(Context context, List<ParseUser> users) {
        super(context, R.layout.message_item, users);
        mContext = context;
        mUsers = users;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.user_item, null);
            holder = new ViewHolder();
            holder.userImageView = (ImageView) convertView.findViewById(R.id.userImageView);
            holder.checkImageView = (ImageView) convertView.findViewById(R.id.checkImageView);
            holder.nameLabel = (TextView) convertView.findViewById(R.id.nameLabel);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ParseUser user = mUsers.get(position);
        String email = user.getEmail().toLowerCase();

        if (email.equals("")) {
            holder.userImageView.setImageResource(R.drawable.avatar_empty);
        } else {
            String hash = MD5Util.md5Hex(email);
            String gravatarUrl = "http://www.gravatar.com/avatar/"
                    + hash + "?s=204&d=404";
            Picasso.with(mContext)
                    .load(gravatarUrl)
                    .placeholder(R.drawable.avatar_empty)
                    .into(holder.userImageView);
        }

        holder.nameLabel.setText(user.getUsername());

        mGridView = (GridView) parent;
        if (mGridView.isItemChecked(position)) {
            holder.checkImageView.setVisibility(View.VISIBLE);
        } else {
            holder.checkImageView.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }

    public void refill(List<ParseUser> users) {
        mUsers.clear();
        mUsers.addAll(users);
        notifyDataSetChanged();
    }

    private static class ViewHolder {
        ImageView userImageView;
        ImageView checkImageView;
        TextView nameLabel;
    }
}
