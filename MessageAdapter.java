package com.example.travelcompanion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MessageAdapter extends BaseAdapter {
    private Context context;
    private List<Message> messages;
    private LayoutInflater inflater;

    public MessageAdapter(Context context, List<Message> messages) {
        this.context = context;
        this.messages = messages;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.message, parent, false);
        }

        TextView usernameTextView = convertView.findViewById(R.id.usernameTextView);
        TextView messageTextView = convertView.findViewById(R.id.messageTextView);

        Message message = messages.get(position);

        usernameTextView.setText(message.getUsername());
        messageTextView.setText(message.getMessage());

        return convertView;
    }
}

