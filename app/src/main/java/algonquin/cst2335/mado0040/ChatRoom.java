package algonquin.cst2335.mado0040;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ChatRoom extends AppCompatActivity {

    Button sendButton;
    Button receiveButton;

    ArrayList<ChatMessage> messages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.chatlayout);
        chatList = findViewById(R.id.mrRecycler);

        ChatMessage thisMessage = new ChatMessage();
        MyChatAdapter adt = new MyChatAdapter();
        chatList.setAdapter(adt);
        chatList.setLayoutManager(new LinearLayoutManager(this));

        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(clk -> {
            String typedMessage = chatMessage.getText().toString();
            Date timeNow = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd-MMM-yyyy hh-mm-ss a", Locale.getDefault());
            String currentDateandTime = sdf.format(timeNow);
            int viewType = 1;
            messages.add(new ChatMessage(typedMessage, 1, currentDateandTime));
            chatMessage.setText("");
            adt.notifyItemInserted(messages.size() - 1);
        });

        receiveButton.setOnClickListener(clk -> {

        });


    }

    private class MyRowViews extends RecyclerView.ViewHolder {

        TextView messageText;
        TextView timeText;

        public MyRowViews(View itemView) {
            super(itemView);

            messageText = itemView.findViewById(R.id.message);
            timeText = itemView.findViewById(R.id.time);
        }
    }

    private class MyChatAdapter extends RecyclerView.Adapter<MyRowViews> {
        @Override
        public MyRowViews onCreateViewHolder(ViewGroup parent, int viewType) { LayoutInflater inflater = getLayoutInflater();
        View loadedRow = inflater.inflate(R.layout.sent_message, parent, false);
        MyRowViews initRow = new MyRowViews(loadedRow);
            return new MyRowViews(loadedRow);
        }

        @Override
        public void onBindViewHolder(MyRowViews holder, int position) {
        holder.messageText.setText( messages.get(position).getMessage() );
        holder.timeText.setText( messages.get(position).getTimeSent() );
        }

        @Override
        public int getItemCount() {
        return 0;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView timeView;
        TextView messageView;

        public MyViewHolder(View itemView) {
            super(itemView);


        timeView = itemView.findViewById(R.id.time);
        messageView = itemView.findViewById(R.id.message);
        }
    }

    private class ChatMessage
    {
        String message;
        int sendOrReceive;
        String timeSent;

        public ChatMessage(String message, int sendOrReceive, String timeSent) {
            this.message = message;
            this.sendOrReceive = sendOrReceive;
            this.timeSent = timeSent;
        }

        public String getMessage() {
            return message;
        }

        public int getSendOrReceive() {
            return sendOrReceive;
        }

        public String getTimeSent() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
            String currentDateandTime = sdf.format(new Date());
            return timeSent;
        }
    }
}
