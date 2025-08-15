package logic;

import java.util.ArrayList;

public class Server {

    private String name;
    private User owner;
    private ArrayList<Channel> channelList;
    private ArrayList<User> memberList;

    public Server(String name, User owner, TemplateType template) {
        this.memberList = new ArrayList<>();
        this.channelList = new ArrayList<>();

        //TODO
        //addUser(owner);

        this.owner = owner;
        addUser(owner);
        setName(name);

        switch (template) {
            case BASIC:
                addChannel(owner, "general");
                break;
            case GAMING:
                addChannel(owner, "gaming");
                break;
            case STUDY:
                addChannel(owner, "homework-help");
                break;
        }
    }

    public boolean isMemberInServer(User user) {
        return memberList.contains(user);
    }

    public Channel addChannel(User user, String channelName) {
        if (!user.equals(owner))
            return null;

        Channel channel = new Channel(channelName);
        channelList.add(channel);
        
        return channel;
    }

    public User addUser(User user) {
        if (memberList.contains(user))
            return null;


        user.addJoinedServersList(this);
        memberList.add(user);
        return user;
    }

    public boolean kickUser(User kicker, User kicked) throws Exception {
        if (!kicker.equals(owner))
            throw new Exception("The kicker is not the owner");

        if (kicker.equals(kicked))
            return false;
            // throw new Exception("You can't kick yourself");


        boolean result = this.memberList.remove(kicked);
        if (result)
            kicked.getJoinedServersList().remove(this);

        return result;
    }

    public void setName(String name) {
        if (name.isBlank())
            this.name = owner.getName() + " home";
        else
            this.name = name;
    }

    public String getName() {
        return name;
    }

    public User getOwner() {
        return owner;
    }

    public ArrayList<Channel> getChannelList() {
        return channelList;
    }

    public ArrayList<User> getMemberList() {
        return memberList;
    }

}
