package logic;

import java.util.ArrayList;

public class Channel {

    private String name;
    private ArrayList<Message> messageList;

    public Channel(String name) {
        this.messageList = new ArrayList<>();
        this.setName(name); 
    }

    public void addMessage(Message message) {
        this.messageList.add(message);
    }

    public void setName(String name) {
        if (name.isBlank())
            this.name = "off-topic";
        else
            this.name = name;
    }

    public int getMessageCount() {
        return messageList.size();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Message> getMessageList() {
        return messageList;
    }

}
