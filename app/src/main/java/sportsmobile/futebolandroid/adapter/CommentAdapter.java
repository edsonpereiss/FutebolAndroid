package sportsmobile.futebolandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.SystemService;

import java.util.ArrayList;
import java.util.List;


import sportsmobile.futebolandroid.item.CommentItem;
import sportsmobile.futebolandroid.item.CommentItem_;
import sportsmobile.futebolandroid.model.Comment;


/**
 * Created by edsonreis on 07/12/17.
 */

@EBean
public class CommentAdapter extends BaseAdapter
{
    protected List<Comment> comments = new ArrayList<>();
    @RootContext protected Context context;
    @SystemService protected LayoutInflater inflater;

    public void CommentAdapter(List<Comment> comments, Context context)
    {
        this.comments = comments;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        CommentItem commentItem;

        if (view == null)
        {
            commentItem = CommentItem_.build(context);
        }
        else
        {
            commentItem = (CommentItem) view;
        }

        commentItem.bind(getItem(position));

        return commentItem;
    }


    @Override
    public int getCount() {
        return comments.size();
    }

    @Override
    public Comment getItem(int position) {
        return comments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
