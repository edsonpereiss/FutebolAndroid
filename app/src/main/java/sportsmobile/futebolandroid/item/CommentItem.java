package sportsmobile.futebolandroid.item;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import sportsmobile.futebolandroid.R;
import sportsmobile.futebolandroid.model.Comment;
import sportsmobile.futebolandroid.model.Standing;

/**
 * Created by edsonreis on 07/12/17.
 */

@EViewGroup(R.layout.item_comment)
public class CommentItem extends CardView
{

    @ViewById protected TextView comments;
    @ViewById protected TextView minute;
    @ViewById protected ImageView img_action;

    protected Context context;

    public CommentItem(Context context)
    {
        super(context);

        this.context = context;
    }

    public void bind(Comment comment)
    {
        img_action.setVisibility(VISIBLE);

        if(comment.comment.contains("yellow"))
        {
            img_action.setImageResource(R.drawable.ic_card_yellow);
        }
        else if(comment.comment.contains("red"))
        {
            img_action.setImageResource(R.drawable.ic_card_red);
        }
        else if(comment.isgoal.contains("1"))
        {
            img_action.setImageResource(R.drawable.ic_ball);
        }
        else
        {
            img_action.setVisibility(GONE);
        }

        comments.setText(comment.comment);
        minute.setText(comment.minute);
    }
}